package com.winnertel.ems.epon.iad.bbs4000;

import com.winnertel.ems.epon.iad.bbs4000.constant.CommonConstant;
import com.winnertel.ems.epon.iad.bbs4000.gui.action.DynamicFunctionTreeNodeAction;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.BBS4000OnuMibBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.swing.tree.BaseNodeDecorator;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.task.RefreshAllTask;

import java.util.Properties;
import java.util.Vector;

public class IADCMTreeBuilder extends BaseNodeDecorator {
    public static final String CM_BBS4000_NODE = "FBW5000";

    // CSM Card node
    private final String[] subTreeOfCSM = new String[]{
            "Link_Aggregation",
            "MAC_Address",
            "Port_Monitor",
            //"RSTP",
            "VLAN",
            "Interface_Extension",
            "ARP",
            "IP_Route",
            "ACL",
            "IGMP_Multicast",
            "DHCP",
            "MSTP",
            "ONU_Upgrade"
    };

    private final String[] subTreeOfDHCP = new String[]{
            "DHCP_Relay",
            "DHCP_Server",
            "DHCP_States"
    };

    // EPM Card node
    private final String[] subTreeOfEPM = new String[]{
            "Ethernet_Port_EPM",
            "OLT",
            "ONU",
            "Performance_EPM",
            "QoS"
    };

    // GEM Card node
    private final String[] subTreeOfGEM = new String[]{
            "Ethernet_Port_GEM",
            "Performance_GEM",
            "QoS"
    };

    // XGM Card node
    private final String[] subTreeOfXGM = new String[]{
            "Ethernet_Port_XGM",
            "Performance_XGM",
            "QoS_XGM"
    }; //added by Zhou Chao

    // OSM Card node
    private final String[] subTreeOfOSM = new String[]{
            "Ethernet_Port_OSM",
            "Performance_OSM",
            "QoS_OSM"
    }; //added by Zhou Chao

    // GPM Card node
    private final String[] subTreeOfGPM = new String[]{
            "Ethernet_Port_GPM",
            "Performance_GPM",
            "QoS_GPM"
    }; //added by Zhou Chao

    private IDeviceManager fDeviceManager = null;
    //private BaseAction fExecutor = null;

    private BaseModuleType fModuleType = new ModuleType();

    public IADCMTreeBuilder(IApplication anApplication) {
        super(anApplication);
    }

    public void decorateNode(FunctionTreeNode aNode) {
        FunctionTreeNodeObject userObject = (FunctionTreeNodeObject) aNode.getUserObject();

        this.fDeviceManager = userObject.getDeviceManager();
        //this.fExecutor = userObject.getExecutor();

        //fModuleType = (BaseModuleType)fDeviceManager.getProperties().get(BaseModuleType.BBS4000_ModuleType);
        //fCsmModule = fModuleType.getAllCSMModuleType()[0];

        String id = userObject.getId();
        if (id.equals(CM_BBS4000_NODE)) {
            buildTree(aNode);
        }
    }

    private void buildTree(FunctionTreeNode aNode) {
        //add the Summary Node to root node.
        aNode.add(createNode("Summary", fDeviceManager.getGuiComposer().getString("Summary"), fDeviceManager, fApplication, null, FunctionTreeNodeObject.ITEM));

        //add the Chassis Node.
        FunctionTreeNode chassisNode = createNode("Chassis", fApplication.getGlobalStringMap().getString("Chassis"), fDeviceManager, fApplication, null, FunctionTreeNodeObject.CHASSIS);
        aNode.add(chassisNode);

        //only 1 chasis in BBS4000 NE.
        int chassisIndex = 1;
        buildModule(chassisNode, chassisIndex);
    }

    private void buildModule(FunctionTreeNode chassisNode, int _shelfIndex) {
        String key = null;

        // set communities for snmp proxy
        String oldReadCommunity = fApplication.getSnmpProxy().getReadCommunity();
        String oldWriteCommunity = fApplication.getSnmpProxy().getWriteCommunity();

        Properties keyContext = new Properties();
        /*
        keyContext.setProperty("cardType", String.valueOf(fCsmModule));
        keyContext.setProperty("shelfIndex", String.valueOf(_shelfIndex));
        String readCommunity = CommonCommunityComposer.composeCommunity(fModuleType.getCommunityType(fCsmModule), fDeviceManager.getVersion(), keyContext, fDeviceManager.getReadCommunity());
        if (readCommunity != null) {
            fApplication.getSnmpProxy().setReadCommunity(readCommunity);
        }
        String writeCommunity = CommonCommunityComposer.composeCommunity(fModuleType.getCommunityType(fCsmModule), fDeviceManager.getVersion(), keyContext, fDeviceManager.getWriteCommunity());
        if (writeCommunity != null) {
            fApplication.getSnmpProxy().setWriteCommunity(writeCommunity);
        }
        */

        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector module = null;
        Task t = new RefreshAllTask(bean);
        try {
            module = (Vector) (fApplication.getTaskManager().executeTask(t));
        } catch (Exception ex) {
            ex.printStackTrace();  //To change body of catch statement use Options | File Templates.
            MessageDialog.showQueryFailedDialog(fApplication);
            // set original communities for snmp proxy
            fApplication.getSnmpProxy().setReadCommunity(oldReadCommunity);
            fApplication.getSnmpProxy().setWriteCommunity(oldWriteCommunity);
            return;
        }

        int csmCardId = 0;
        int gemCardId = 0;
        int epmCardId = 0;
        int xgmCardId = 0; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        int osmCardId = 0; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        int gpmCardId = 0; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        if (module != null) {
            for (int j = 0; j < module.size(); j++) {
                BBS4000CardMibBean m = (BBS4000CardMibBean) module.get(j);
                if (m.getUtsEponModuleAdminState().intValue() != 2) { //2 - unlocked.
                    continue;
                }

                if (fModuleType.isCSMModule(m.getUtsEponModuleBoardType().intValue())) {
                    csmCardId++;
                    if (m.getUtsEponModuleBoardPhyId().intValue() == 13) {
                        key = fDeviceManager.getGuiComposer().getString("Slot ") + "A - CSM";
                    } else {
                        key = fDeviceManager.getGuiComposer().getString("Slot ") + "B - CSM";
                    }

                    keyContext = new Properties();
                    keyContext.setProperty("cardType", String.valueOf(m.getUtsEponModuleBoardType().intValue()));
                    keyContext.setProperty("shelfIndex", String.valueOf(_shelfIndex));
                    keyContext.setProperty("slotIndex", String.valueOf(m.getUtsEponModuleBoardPhyId()));
                    keyContext.setProperty("cardIndex", String.valueOf(csmCardId));

                    if (m.getUtsEponModuleRedundancyState().intValue() == 2) {
                        // build sub-tree under the CSM Card.
                        chassisNode.add(buildModuleNode("CSM", key, subTreeOfCSM, keyContext));
                    } else {
                        FunctionTreeNode moduleNode = createNode("CSM_Standby", key, fDeviceManager, fApplication, keyContext, FunctionTreeNodeObject.BOARD);
                        chassisNode.add(moduleNode);
                    }
                } else if (fModuleType.isEPM04BModule(m.getUtsEponModuleBoardType().intValue())) {
                    epmCardId++;
                    key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - EPM04B";

                    keyContext = new Properties();
                    keyContext.setProperty("cardType", String.valueOf(m.getUtsEponModuleBoardType().intValue()));
                    keyContext.setProperty("shelfIndex", String.valueOf(_shelfIndex));
                    keyContext.setProperty("slotIndex", String.valueOf(m.getUtsEponModuleBoardPhyId()));
                    keyContext.setProperty("cardIndex", String.valueOf(epmCardId));
                    // build sub-tree under the EPM Card.
                    chassisNode.add(buildModuleNode("EPM_04B", key, subTreeOfEPM, keyContext));
                } else if (fModuleType.isEPMModule(m.getUtsEponModuleBoardType().intValue())) {
                    epmCardId++;
                    key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - EPM";

                    keyContext = new Properties();
                    keyContext.setProperty("cardType", String.valueOf(m.getUtsEponModuleBoardType().intValue()));
                    keyContext.setProperty("shelfIndex", String.valueOf(_shelfIndex));
                    keyContext.setProperty("slotIndex", String.valueOf(m.getUtsEponModuleBoardPhyId()));
                    keyContext.setProperty("cardIndex", String.valueOf(epmCardId));
                    // build sub-tree under the EPM Card.
                    chassisNode.add(buildModuleNode("EPM", key, subTreeOfEPM, keyContext));
                } else if (fModuleType.isGEMModule(m.getUtsEponModuleBoardType().intValue())) {
                    gemCardId++;
                    //zhangyunfang added 2007.4.8
                    //key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - GEM";
                    key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - " + fModuleType.getModuleDisplayName(m.getUtsEponModuleBoardType().intValue());

                    keyContext = new Properties();
                    keyContext.setProperty("cardType", String.valueOf(m.getUtsEponModuleBoardType().intValue()));
                    keyContext.setProperty("shelfIndex", String.valueOf(_shelfIndex));
                    keyContext.setProperty("slotIndex", String.valueOf(m.getUtsEponModuleBoardPhyId()));
                    keyContext.setProperty("cardIndex", String.valueOf(gemCardId));
                    // build sub-tree under the GEM Card.
                    chassisNode.add(buildModuleNode("GEM", key, subTreeOfGEM, keyContext));
                } else
                if (fModuleType.isXGMModule(m.getUtsEponModuleBoardType().intValue())) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
                    xgmCardId++;
                    //key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - XGM";
                    key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - " + fModuleType.getModuleDisplayName(m.getUtsEponModuleBoardType().intValue());

                    keyContext = new Properties();
                    keyContext.setProperty("cardType", String.valueOf(m.getUtsEponModuleBoardType().intValue()));
                    keyContext.setProperty("shelfIndex", String.valueOf(_shelfIndex));
                    keyContext.setProperty("slotIndex", String.valueOf(m.getUtsEponModuleBoardPhyId()));
                    keyContext.setProperty("cardIndex", String.valueOf(xgmCardId));
                    // build sub-tree under the XGM Card.
                    chassisNode.add(buildModuleNode("XGM", key, subTreeOfXGM, keyContext));
                } else
                if (fModuleType.isOSMModule(m.getUtsEponModuleBoardType().intValue())) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
                    osmCardId++;
                    //key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - OSM";
                    key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - " + fModuleType.getModuleDisplayName(m.getUtsEponModuleBoardType().intValue());

                    keyContext = new Properties();
                    keyContext.setProperty("cardType", String.valueOf(m.getUtsEponModuleBoardType().intValue()));
                    keyContext.setProperty("shelfIndex", String.valueOf(_shelfIndex));
                    keyContext.setProperty("slotIndex", String.valueOf(m.getUtsEponModuleBoardPhyId()));
                    keyContext.setProperty("cardIndex", String.valueOf(osmCardId));
                    // build sub-tree under the OSM Card.
                    chassisNode.add(buildModuleNode("OSM", key, subTreeOfOSM, keyContext));
                } else
                if (fModuleType.isGPMModule(m.getUtsEponModuleBoardType().intValue())) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
                    gpmCardId++;
                    //key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - GPM";
                    key = fDeviceManager.getGuiComposer().getString("Slot ") + m.getUtsEponModuleBoardPhyId() + " - " + fModuleType.getModuleDisplayName(m.getUtsEponModuleBoardType().intValue());

                    keyContext = new Properties();
                    keyContext.setProperty("cardType", String.valueOf(m.getUtsEponModuleBoardType().intValue()));
                    keyContext.setProperty("shelfIndex", String.valueOf(_shelfIndex));
                    keyContext.setProperty("slotIndex", String.valueOf(m.getUtsEponModuleBoardPhyId()));
                    keyContext.setProperty("cardIndex", String.valueOf(gpmCardId));
                    // build sub-tree under the GPM Card.
                    chassisNode.add(buildModuleNode("GPM", key, subTreeOfGPM, keyContext));
                }
            }
        }
        // set original communities for snmp proxy
        fApplication.getSnmpProxy().setReadCommunity(oldReadCommunity);
        fApplication.getSnmpProxy().setWriteCommunity(oldWriteCommunity);
    }

    private FunctionTreeNode buildModuleNode(String id, String name, String[] textOfSubTreeNodes, Properties keyContext) {
        FunctionTreeNode module = createNode(id, name, fDeviceManager, fApplication, keyContext, FunctionTreeNodeObject.BOARD);

        for (int i = 0; i < textOfSubTreeNodes.length; i++) {
            String displayName = fDeviceManager.getGuiComposer().getString(textOfSubTreeNodes[i]);
            FunctionTreeNode subTreeNode = createNode(textOfSubTreeNodes[i], displayName, fDeviceManager, fApplication, keyContext, FunctionTreeNodeObject.ITEM);
            if (textOfSubTreeNodes[i].equals("DHCP")) {
                for (int j = 0; j < subTreeOfDHCP.length; j++) {
                    displayName = fDeviceManager.getGuiComposer().getString(subTreeOfDHCP[j]);
                    subTreeNode.add(createNode(subTreeOfDHCP[j], displayName, fDeviceManager, fApplication, keyContext, FunctionTreeNodeObject.ITEM));
                }
            }

            if (textOfSubTreeNodes[i].startsWith("ONU")) {
                try {
                    BBS4000OnuMibBean bean = new BBS4000OnuMibBean(fApplication.getSnmpProxy());
                    bean.setIndex(0, new Integer(keyContext.getProperty("slotIndex")));
                    bean.setIndex(1, new Integer(1));
                    bean.setIndex(2, new Integer(1));
                    bean.setIndex(3, new Integer(0));
                    bean.setIndexPrefix(keyContext.getProperty("slotIndex") + ".1");

                    Task t = new RefreshAllTask(bean);
                    Vector v = (Vector) (fApplication.getTaskManager().executeTask(t));

                    for (int j = 0; v != null & j < v.size(); j++) {
                        BBS4000OnuMibBean onu = (BBS4000OnuMibBean) v.get(j);

                        String onuIndex = new StringBuffer().append(onu.getUtsDot3Onu2CtcModuleId()).append(".1.").append(onu.getUtsDot3Onu2CtcPortId()).append(".").append(onu.getUtsDot3Onu2CtcLogicalPortId()).toString();
                        keyContext = (Properties) keyContext.clone();
                        keyContext.setProperty(CommonConstant.CURRENT_ONU_ID, "" + onu.getUtsDot3Onu2CtcLogicalPortId());
                        keyContext.setProperty(CommonConstant.CURRENT_PORT_ID, "" + onu.getUtsDot3Onu2CtcPortId());
                        keyContext.setProperty(CommonConstant.CURRENT_ONU_IFINDEX, onuIndex);

                        String onuName = new StringBuffer().append(onu.getUtsDot3Onu2CtcModuleId()).append("/").append(onu.getUtsDot3Onu2CtcPortId()).append("/").append(onu.getUtsDot3Onu2CtcLogicalPortId()).toString();
                        subTreeNode.add(createNode("ONU_Instance", onuName, fDeviceManager, fApplication, keyContext, FunctionTreeNodeObject.ITEM));
                    }
                } catch (Exception e) {
                }
            }

            module.add(subTreeNode);
        }

        return module;
    }

    private static FunctionTreeNode createNode(String _nodeId, String _name, IDeviceManager _deviceManager, IApplication _application, Properties _keyContext, String _type) {
        FunctionTreeNodeObject nodeInfo;
        FunctionTreeNode node;
        DynamicFunctionTreeNodeAction action = new DynamicFunctionTreeNodeAction(_application);
        nodeInfo = new FunctionTreeNodeObject(_deviceManager, _nodeId, _name, action, null, _type);
        nodeInfo.setReadCommunity(_deviceManager.getReadCommunity());
        nodeInfo.setWriteCommunity(_deviceManager.getWriteCommunity());
        nodeInfo.setProperties(_keyContext);
        node = new FunctionTreeNode(nodeInfo);
        action.setFunctionTreeNode(node);

        return node;
    }

}
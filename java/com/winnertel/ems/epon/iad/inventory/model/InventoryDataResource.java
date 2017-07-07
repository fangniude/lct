package com.winnertel.ems.epon.iad.inventory.model;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.EocDevInfoTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuInfoTable;
import com.winnertel.ems.epon.iad.inventory.mib.ONUMBean;
import com.winnertel.ems.epon.iad.inventory.mib.OnuCtcBean;
import com.winnertel.ems.epon.inventory.OnuMODHelper;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.inms.topodb.UTopoAPI;

import java.util.Properties;
import java.util.Vector;

public class InventoryDataResource {

    private static int IADReady = 1;

    private SnmpProxy snmpProxy = null;

    private NENode rnode = null;
    private IStringMap fStringMap = null;

    public NENode getRootNode() {
        return rnode;
    }

    public InventoryDataResource(SnmpProxy snmpProxy, String name, String label, Vector beans, IStringMap aStringMap) {
        this.snmpProxy = snmpProxy;
        fStringMap = aStringMap;
        rnode = new NENode(name, label);
        buildInventoryTree(rnode, beans);
    }

    private void buildInventoryTree(NENode node, Vector beans) {
        if (beans.size() > 0) {
            if (beans.get(0) instanceof ONUMBean) {
                for (int i = 0; i < beans.size(); i++) {
                    if (!filterNode((ONUMBean) beans.get(i)))
                        insertNode(node, (ONUMBean) beans.get(i));
                }
            } else if (beans.get(0) instanceof GponOnuBean) { //added by Zhou Chao, 2009/1/5
                for (int i = 0; i < beans.size(); i++) {
                    if (!filterNode((GponOnuBean) beans.get(i)))
                        insertNode(node, (GponOnuBean) beans.get(i));
                }
            } else if (beans.get(0) instanceof OnuInfoTable) { //added by Zhou Chao, 2010/5/17
                for (int i = 0; i < beans.size(); i++) {
                    if (!filterNode((OnuInfoTable) beans.get(i)))
                        insertNode(node, (OnuInfoTable) beans.get(i));
                }
            } else {
                for (int i = 0; i < beans.size(); i++) {
                    if (!filterNode((OnuCtcBean) beans.get(i)))
                        insertNode(node, (OnuCtcBean) beans.get(i));
                }
            }
        }
    }

    private boolean filterNode(ONUMBean bean) {
        if (bean.getUtsDot3OnuRegistrationState() == 3
                && bean.getUtsDot3OnuIADStatus() == IADReady
                && (bean.getUtsDot3OnuHwType() == IADConstants.onu2024
                || bean.getUtsDot3OnuHwType() == IADConstants.onu200a
                || bean.getUtsDot3OnuHwType() == IADConstants.onu2004
                || bean.getUtsDot3OnuHwType() == IADConstants.onu404
                || bean.getUtsDot3OnuHwType() == IADConstants.onu804
                || bean.getUtsDot3OnuHwType() == IADConstants.onu3004
                || bean.getUtsDot3OnuHwType() == IADConstants.onu2004i)
                || bean.getUtsDot3OnuHwType() == IADConstants.onu2024i
                || bean.getUtsDot3OnuHwType() == IADConstants.onu204i
                || bean.getUtsDot3OnuHwType() == IADConstants.onu208i
                || bean.getUtsDot3OnuHwType() == IADConstants.onu404i
                || bean.getUtsDot3OnuHwType() == IADConstants.onu804i
                || bean.getUtsDot3OnuHwType() == IADConstants.onu204i_c1) {
            return false;
        } else {
            return true;
        }
    }

    //modified by Zhou Chao
    private boolean filterNode(OnuCtcBean bean) {
        String onuType = bean.getUtsDot3Onu2CtcOnuModel();
        if ((bean.getUtsDot3Onu2CtcRegisterStatus() == 1 && bean.getUtsDot3Onu2CtcSwitchAdminStatus() == 1)
                && (onuType.equalsIgnoreCase("A002") || onuType.equalsIgnoreCase("A003") || onuType.equalsIgnoreCase("A004")
                || onuType.equalsIgnoreCase("A005") || onuType.equalsIgnoreCase("A007") || onuType.equalsIgnoreCase("A009")
                || onuType.equalsIgnoreCase("A00A") || onuType.equalsIgnoreCase("A00D") || onuType.equalsIgnoreCase("A00E")
                || onuType.equalsIgnoreCase("A018") || onuType.equalsIgnoreCase("A019") || onuType.equalsIgnoreCase("A020")
                || onuType.equalsIgnoreCase("A024") || onuType.equalsIgnoreCase("B141") || onuType.equalsIgnoreCase("B142")
                || onuType.equalsIgnoreCase("B341") || onuType.equalsIgnoreCase("A108") || onuType.equalsIgnoreCase("A022")
                || onuType.equalsIgnoreCase("A00B") || onuType.equalsIgnoreCase("A101") || onuType.equalsIgnoreCase("A109")
                || onuType.equalsIgnoreCase("A10E") || onuType.equalsIgnoreCase("A112") || onuType.equalsIgnoreCase("A116")
                || "A110".equalsIgnoreCase(onuType) || "D002".equalsIgnoreCase(onuType) || "D003".equalsIgnoreCase(onuType))) {   
            return false;
        }

        return true;
    }

    /**
     * Least significant byte of vendor product code which provides a vendor-specific product code for the ONT.(R) (2 bytes):
     * 1 �C ONT1001t (952)
     * 2 �C ONT408t (958v)
     * Most significant byte of vendor product code which provides a vendor-specific product code for the ONT.(R) (2 bytes).
     * 0 �C revision 0
     */
    //added by Zhou Chao, 2009/1/5 -- begin
    private boolean filterNode(GponOnuBean bean) {
        int onuHardwareType = bean.getOnuCfgOnuHardwareType().intValue(); //getOnuCfgOnuHardwareRevision()
        if ((bean.getOnuCfgOperationalState() == 1) //Enabled
                && (onuHardwareType == 1 || onuHardwareType == 2)) {
            return false;
        }

        return true;
    }
    //added by Zhou Chao, 2009/1/5 -- end

    //added by Zhou Chao, 2010/5/17 -- begin
    private boolean filterNode(OnuInfoTable bean) {
        return false;
    }
    //added by Zhou Chao, 2010/5/17 -- end

    //modified by Zhou Chao, 2010/5/17 -- begin
    private void insertNode(NENode node, ONUMBean bean) {
        if (node == null || bean == null)
            return;

        String moduleId = bean.getUtsDot3OnuModuleId().toString();
        String portId = bean.getUtsDot3OnuPortId().toString();
        String logicalPortId = bean.getUtsDot3OnuLogicalPortId().toString();
        String onuType = OnuMODHelper.convertHwType(String.valueOf(bean.getUtsDot3OnuHwType()));
        String onuVersion = bean.getUtsDot3OnuFwVersion();

        insertNode(node, moduleId, portId, logicalPortId, onuType, onuVersion);
    }
    //modified by Zhou Chao, 2010/5/17 -- end

    //modified by Zhou Chao, 2010/5/17 -- begin
    private void insertNode(NENode node, OnuCtcBean bean) {
        if (node == null || bean == null)
            return;

        String moduleId = bean.getUtsDot3Onu2CtcModuleId().toString();
        String portId = bean.getUtsDot3Onu2CtcPortId().toString();
        String logicalPortId = bean.getUtsDot3Onu2CtcLogicalPortId().toString();
        String onuType = OnuMODHelper.convertHwType(bean.getUtsDot3Onu2CtcOnuModel());
        String onuVersion = getOnuVersion(bean.getUtsDot3Onu2CtcSerialNumber());

        insertNode(node, moduleId, portId, logicalPortId, onuType, onuVersion);
    }
    //modified by Zhou Chao, 2010/5/17 -- end

    //modified by Zhou Chao, 2010/5/17 -- begin
    private void insertNode(NENode node, GponOnuBean bean) {
        if (node == null || bean == null)
            return;

        String moduleId = bean.getOnuCfgSlotNo().toString();
        String portId = bean.getOnuCfgPortNo().toString();
        String logicalPortId = bean.getOnuCfgLogicalPortNo().toString();
        int onuHardwareType = bean.getOnuCfgOnuHardwareType().intValue();
        String onuType = (onuHardwareType == 1 ? "ONT1001t" : (onuHardwareType == 2 ? "ONT408t" : "Unknown"));
        String onuVersion = bean.getOnuCfgVersion();

        insertNode(node, moduleId, portId, logicalPortId, onuType, onuVersion);
    }
    //modified by Zhou Chao, 2010/5/17 -- end

    //added by Zhou Chao, 2010/5/17 -- begin
    private void insertNode(NENode node, OnuInfoTable bean) {
        if (node == null || bean == null)
            return;

        int deviceId = bean.getOnuDeviceIndex();
        int[] indexes = formatEponDeviceIndex(deviceId);

        //TODO
        String moduleId = String.valueOf(indexes[2]);
        String portId = String.valueOf(indexes[1]);
        String onuId = String.valueOf(indexes[0]);

        //String onuType = bean.getOnuType(); //fixed(1), chassisBased(2)
        //String onuType = bean.getOnuChipType();
        //String onuVersion = bean.getOnuChipVersion();

        String onuType = "ONU"; //NGB-ONU
        String onuVersion = "";

        insertNode(node, moduleId, portId, onuId, onuType, onuVersion);
    }
    //added by Zhou Chao, 2010/5/17 -- end

    //modified by Zhou Chao, 2010/5/17 -- begin
    private void insertNode(NENode node, String moduleId, String portId, String onuId, String onuType, String onuVersion) {
        Object aModuleNode = node.searchChild(moduleId);
        ModuleNode mnode = null;
        PortNode pnode = null;

        if (aModuleNode == null) {
            mnode = new ModuleNode(moduleId, fStringMap.getString("OLT Module") + " " + moduleId);
            node.addChild(mnode);
            pnode = new PortNode(portId, fStringMap.getString("OLT Port") + " " + portId);
            mnode.addChild(pnode);
        } else {
            mnode = (ModuleNode) aModuleNode;
            Object aPortNode = mnode.searchChild(portId);
            if (aPortNode == null) {
                pnode = new PortNode(portId, fStringMap.getString("OLT Port") + " " + portId);
                mnode.addChild(pnode);
            } else {
                pnode = (PortNode) aPortNode;
            }
        }

        LogicalPortNode lnode = new LogicalPortNode(onuId, getOnuLabel(moduleId, portId, onuId));
        pnode.addChild(lnode);

        IADNode inode = new IADNode(onuId, onuType);
        inode.setVersion(onuVersion != null ? onuVersion : "");
        lnode.addChild(inode);

        //added by Zhou Chao, 2010/5/17 -- begin
        Properties tProperties = null;
        try {
            tProperties = UTopoAPI.getAPI().getNodeProperties(node.getName());
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }

//        Properties tProperties = ClientUtility.getNePropertiesByNeName(node.getName());
        if(tProperties != null) {
            String neType = tProperties.getProperty("neType", "FBW5000");
            String neVersion = tProperties.getProperty("swVersion", "4.0.0");
            if (neType.startsWith("FBW5000") && neVersion.startsWith("4.0.")) {
                Vector eocList = getEocList();
                if (eocList != null && eocList.size() > 0) {
                    inode.setHasChild(true);
                    for (int i = 0; i < eocList.size(); i++) {
                        String row = (String) eocList.get(i);
                        String[] aEoc = row.split(";");
                        if (aEoc != null && aEoc.length >= 6) {
                            String eocDeviceId = aEoc[0];
                            String eocCardId = aEoc[1];
                            String eocPortId = aEoc[2];
                            String eocSeriesNumber = aEoc[3];
                            String eocIpAddress = aEoc[4];
                            String eocMacAddress = aEoc[5];
                            EocNode enode = new EocNode(eocDeviceId, eocCardId, eocPortId, eocSeriesNumber, eocIpAddress, eocMacAddress);
                            inode.addChild(enode);
                        }
                    }
                }
            }
        }

        //added by Zhou Chao, 2010/5/17 -- end
    }
    //modified by Zhou Chao, 2010/5/17 -- end

    //added by Zhou Chao, 2010/5/17 -- begin
    private Vector getEocList() {
        Vector eocList = new Vector();

        try {
            EocDevInfoTable table = new EocDevInfoTable(snmpProxy);
            Vector data = table.retrieveAll();
            if (data != null) {
                //if (eocList == null)
                //    eocList = new Vector();
                for (int i = 0; i < data.size(); i++) {
                    EocDevInfoTable bean = (EocDevInfoTable) data.get(i);
                    if (bean != null) {
                        String row = bean.getEocDeviceIndex() + ";" + bean.getEocCardIndex() + ";" + bean.getEocPortIndex() + ";" + bean.getEocSeriesNumber() + ";" + bean.getEocDeviceIpAddress() + ";" + bean.getEocDeviceMacAddress();
                        eocList.add(row);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return eocList;
    }
    //added by Zhou Chao, 2010/5/17 -- end

    private String getOnuLabel(String cardId, String portId, String onuId) {
        String ifIndex = cardId + "/" + portId + "/" + onuId;
        String label = "";

//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                if (onuMgmtMgr != null) {
//                    label = onuMgmtMgr.getOnuLabel(rnode.getName(), ifIndex);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        if (label == null || label.trim().length() <= 0) {
            label = fStringMap.getString("ONU Port") + " " + onuId;
        }

        return label;
    }

    private String getOnuVersion(byte[] serial) {
        for (int i = 0; i < 16; i++) {
            if (serial[22 + i] < 32 || serial[22 + i] > 126) serial[22 + i] = 32;
        }

        String version = new String(serial, 22, 16).trim();

        if (version.indexOf("|") != -1) {
            version = version.substring(version.indexOf("|") + 1);
        }

        //remove the forth sub-version from string.
        int count = 0;
        for (int i = 0; i < version.length(); i++) {
            if (version.charAt(i) == '.') {
                count++;
            }

            if (count > 2) {
                return version.substring(0, i);
            }
        }

        return version;
    }

    private int[] formatEponDeviceIndex(int eponDeviceIndex) {
        int[] indexes = new int[4];

        for (int i = 0; i < indexes.length; i++) {
            indexes[indexes.length - 1 - i] = eponDeviceIndex & 0xFF;
            eponDeviceIndex = eponDeviceIndex >> 8;
        }

        return indexes;
    }

}
/**
 * Created by Zhou Chao, 2011/5/6
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.ems.epon.iad.IADManager;
import com.winnertel.ems.epon.iad.common.MainApplet;
import com.winnertel.ems.epon.iad.inventory.mib.Dot3OnuSwitchTable;
import com.winnertel.ems.epon.iad.snmp.OnuSnmpParameter;
import com.winnertel.ems.epon.inventory.OnuMODHelper;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.device.DvmUtil;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.inms.topoui.*;
import com.winnertel.inms.topoui.v2.ClientMenuReader;
import com.winnertel.nms.lite.client.rmi.ScoaAPI;
import com.winnertel.nms.lite.momodel.ManagedElement;
import com.winnertel.nms.lite.util.APIUtil;
import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.SnmpOID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

public class OpenOnuDvmAction extends SnmpAction implements ManagedWindow {

    private static IADManager iadMgr;
    private static String title;


    public OpenOnuDvmAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
        int selectedRowCount = fTable.getSelectedRowCount();
        if (selectedRowCount == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

        String neName = fApplication.getActiveDeviceManager().getName();
        String neType = fApplication.getActiveDeviceManager().getType();
        String onuLabel = "";
        int moduleId = 0;
        int portId = 0;
        int onuId = 0;
        String nodeType = "Unknown";
        String nodeVersion = "";

        try {
            byte[] type = null;
            byte[] version = null;
            if (bean instanceof com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcTable) {
                onuLabel = ((com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcTable) bean).getOnuLabel();
                moduleId = ((com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcModuleId();
                portId = ((com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcPortId();
                onuId = ((com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcLogicalPortId();
                type = ((com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcSerialNumber();
                version = ((com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcFwVer();
            } else if (bean instanceof com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable) {
                onuLabel = ((com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable) bean).getOnuLabel();
                moduleId = ((com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcModuleId();
                portId = ((com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcPortId();
                onuId = ((com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcLogicalPortId();
                type = ((com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcSerialNumber();
                version = ((com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcFwVer();
            } else if (bean instanceof com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcTable) {
                onuLabel = "";
                moduleId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcModuleId();
                portId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcPortId();
                onuId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcLogicalPortId();
                type = ((com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcSerialNumber();
                version = ((com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcFwVer();
            } else if (bean instanceof com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcTable) {
                onuLabel = ((com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcTable) bean).getOnuLabel();
                moduleId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcModuleId();
                portId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcPortId();
                onuId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcLogicalPortId();
                type = ((com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcSerialNumber();
                version = ((com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcFwVer();
            } else if (bean instanceof com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable) {
                onuLabel = ((com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable) bean).getOnuLabel();
                moduleId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcModuleId();
                portId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcPortId();
                onuId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcLogicalPortId();
                type = ((com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcSerialNumber();
                version = ((com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcFwVer();
            } else if (bean instanceof com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable) {
                onuLabel = ((com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable) bean).getOnuLabel();
                moduleId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcModuleId();
                portId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcPortId();
                onuId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcLogicalPortId();
                type = ((com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcSerialNumber();
                version = ((com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcFwVer();
            } else if (bean instanceof com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable) {
                onuLabel = ((com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable) bean).getOnuLabel();
                moduleId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcModuleId();
                portId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcPortId();
                onuId = ((com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcLogicalPortId();
                type = ((com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcSerialNumber();
                version = ((com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable) bean).getUtsDot3Onu2CtcFwVer();
            }
            for (int i = 0; i < 4; i++) {
                if (type[4 + i] < 32 || type[4 + i] > 126)
                    type[4 + i] = 32;
            }
            if (type != null)
                if ("true".equalsIgnoreCase(System.getProperty("dvm.mode.lct"))) {
                    nodeType = OnuMODHelper.convertHwType(new String(type, 4, 4, "ISO-8859-1"));
                } else {
                    nodeType = UTopoUIContext.getInstance().getNETypeByLabe(OnuMODHelper.convertHwType(new String(type, 4, 4, "ISO-8859-1")));
                }

            if (version != null && version.length > 0) {
                StringBuffer sb = new StringBuffer();
                if (version.length > 5)
                    sb.append(version[5] & 0xFF).append(".");
                if (version.length > 7)
                    sb.append(version[7] & 0xFF).append(".");
                if (version.length > 9)
                    sb.append(version[9] & 0xFF);
                nodeVersion = sb.toString();
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        if (nodeType == null || nodeType.trim().length() <= 0) {
            MessageDialog.showInfoMessageDialog(fApplication, fApplication.getGlobalStringMap().getString("Err_NodeType_Is_Invalid"));
            return;
        }

        //if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
        //    throw new OperationCanceledException("Open ONU device management action canceled");
        //}

        Task t = new OpenOnuDvmTask(neName, neType, onuLabel, moduleId, portId, onuId, nodeType, nodeVersion);
        t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Operation in process, please wait..."));

        Boolean result = null;
        try {
            result = (Boolean) fApplication.getTaskManager().executeTask(t);
            if (result == null || !result) {
                throw new OperationFailedException("Open ONU device management operation failed");
            }

            MainApplet applet = iadMgr.getDvmFrame(buildTitle(neName, onuLabel, moduleId, portId, onuId, nodeType));
            if (applet != null) {
                Frame topMostFrame = applet.getTopMostFrame();
                topMostFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
                topMostFrame.toFront();
            }
        } catch (Exception e1) {
            result = Boolean.FALSE;
            e1.printStackTrace();
        }

//        try {
//            new RefreshAllCommand(fApplication, fTable).execute();
//        } catch (Exception e1) {
//            e1.printStackTrace();
//            throw new OperationFailedException("Refresh data operation failed");
//        }
    }

    private boolean openOnuDvm(final String neName, String neType, String onuLabel, int moduleId, int portId, int onuId, String nodeType, String nodeVersion) {
        if (neName == null || neName.trim().length() <= 0 || neType == null || neType.trim().length() <= 0 || nodeType == null || nodeType.trim().length() <= 0)
            return false;
        Properties tmpProp = null;
        try {
            tmpProp = APIUtil.getTopoAPI().getMEByMoName(neName).getProperties();
            if (tmpProp == null)
                return false;

            if (iadMgr == null) {
                iadMgr = new IADManager(tmpProp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        SnmpParameter para = null;

        if ("true".equalsIgnoreCase(System.getProperty("dvm.mode.lct"))) {
            para = new SnmpParameter(neName, 161);
        } else {
            UTopoUIContext context = UTopoUIContext.getInstance();
            if (context != null) {
                ManagedElement me = context.getMONodeByNEId(neName);
                if (me != null) {
                    para = new SnmpParameter(me.getIpAddress(), me.getSnmpPort(), true);
                    para.setReadCommunity(me.getReadCommunity());
                    para.setWriteCommunity(me.getWriteCommunity());
                    para.setSnmpVersion(DvmUtil.convertSnmpVersion(me.getSnmpVersion()));
                }
            }
        }
        iadMgr.setSnmpParameter(para);

        iadMgr.init();

        String[] onuTypeList = new String[]{
                "ONU408t",
                "ONU4024i",
                "ONT958/952",
                "ONU404i",
                "ONU804i",
                "ONU204d",
                "ONU4016i",
                "ONU4016i-t",
                "ONU2016i-e",
                "ONU2024i",
                "ONU2024i-C1",
                "ONU2004-2",
                "ONU204i-h",
                "ONU204i-h R.c1",
                "ONU204i-k7 R.a4",
                "ONU204i-k7 R.a5",
                "ONU204i-h R.h1",
                "ONU204i-k7 R.a2",
                "ONU208P",
                "ONU208i",
                "ONU2004i",
                "ONU204i",
                "ONU204i-e",
                "JS16B-v",
                "JS24B-v",
                "CLT2168",
                "CLT2170",
                "CLT2171",
        };

        boolean isSupported = false;
        for (int i = 0; i < onuTypeList.length; i++) {
            if (nodeType.equalsIgnoreCase(onuTypeList[i])) {
                isSupported = true;
                break;
            }
        }

        title = buildTitle(neName, onuLabel, moduleId, portId, onuId, nodeType);

        if (isSupported) {
            //get the node's IP address from swtich table to check
            try {
                com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OnuSwitchTable switchTableBean = new com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OnuSwitchTable(fApplication.getSnmpProxy());
                switchTableBean.setIndex(0, moduleId);
                switchTableBean.setIndex(1, portId);
                switchTableBean.setIndex(2, onuId);
                if (switchTableBean.retrieve()) {
                    String switchIp = switchTableBean.getUtsDot3OnuSwitchIpAddress();
                    if (switchIp != null && switchIp.trim().length() > 0 && !switchIp.trim().equalsIgnoreCase("0.0.0.0")) {
                        String title = buildTitle(neName, onuLabel, moduleId, portId, onuId, nodeType);
                        String version = null; //String version = nodeVersion;
//                        if (version == null || version.trim().length() <= 0) {
                        //version = getOnuVersion(iadMgr, moduleId, portId, onuId); //get the version from ONU swtich

                        //added by zengtian 2012/02/21 for NMS00072240
                        try {
                            String oltIpAdress = neName; //modified by Zhouchao, 2012/2/24

                            //added by zengtian 2012/02/27 for NMS00072240
                            if (!"true".equalsIgnoreCase(System.getProperty("dvm.mode.lct"))) {
                                oltIpAdress = tmpProp.getProperty("ipAddress");
                            }
                            String readCommunity = tmpProp.getProperty("readCommunity") + getCommunityPostfix(moduleId, portId, onuId);
                            int snmpPort = Integer.valueOf(tmpProp.getProperty("snmpPort"));
                            //version = SnmpUtility.getOnuVersion(neType, oltIpAdress, snmpPort, readCommunity);
                            version = getOnuVersion(iadMgr, nodeType, oltIpAdress, snmpPort, readCommunity);


                            if (version != null && !version.equalsIgnoreCase("")) {
                                String split[] = version.split("\\.");
                                if (split[0].length() > 1) {
                                    split[0] = split[0].substring(split[0].length() - 1, split[0].length());
                                    version = split[0] + "." + split[1] + "." + split[2];
                                }
                            }

                        } catch (Exception e1) {
                            e1.printStackTrace();
//                            }
                        }
                        if (version == null || version.trim().length() <= 0) {
                            version = "1.0.0"; //use the default version
                        }
                        ISnmpParameter snmpParameter = getSnmpProxyParameter(iadMgr, neName, moduleId, portId, onuId);
                        iadMgr.showDVM(snmpParameter, title, nodeType, version);

                        if (!"true".equalsIgnoreCase(System.getProperty("dvm.mode.lct"))) {
                            //added by zengtian 2012/02/21 for NMS00072364
                            constructFrame();
                        }
                    } else {
                        MessageDialog.showInfoMessageDialog(fApplication, fApplication.getGlobalStringMap().getString("Err_NodeSwitchIp_Is_Invalid"));
                        return false;
                    }
                } else {
                    MessageDialog.showInfoMessageDialog(fApplication, fApplication.getGlobalStringMap().getString("Err_NodeSwitchIp_Is_Invalid"));
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            MessageDialog.showInfoMessageDialog(fApplication, fApplication.getGlobalStringMap().getString("Err_NodeType_Is_Not_Supported"));
            return false;
        }

        return true;
    }

    private String buildTitle(String neName, String onuLabel, int moduleId, int portId, int onuId, String nodeType) {
        String oltLabel = "";
        if ("true".equalsIgnoreCase(System.getProperty("dvm.mode.lct"))) {
            oltLabel = neName;
        } else {
            try {
                oltLabel = ScoaAPI.getApiFactory().getRemoteTopoAPI().getMEByMoName(neName).getUserLabel();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            nodeType = UTopoUIContext.getInstance().getMOTypeLabel(nodeType);
        }
        String title = "";
        String titlePrefix = nodeType;
        if (onuLabel != null && onuLabel.trim().length() > 0)
            titlePrefix = onuLabel;
        title = titlePrefix + "(" + oltLabel + ":" + moduleId + "/" + portId + "/" + onuId + ")";

        return title;
    }

    private ISnmpParameter getSnmpProxyParameter(IADManager iadMgr, String neName, int moduleId, int portId, int onuId) {
        ISnmpParameter parameter = null;
        parameter = new OnuSnmpParameter(iadMgr, neName, moduleId, portId, onuId);

        return parameter;
    }

/*
    private void openOnuDvm(String neName, int moduleId, int portId, int onuId, String nodeType, String nodeVersion) {
        Properties tmpProp = ClientUtility.getNePropertiesByNeName(neName);
        if (tmpProp == null)
            return;

        IADManager iadMgr = new IADManager(tmpProp);
        OltSnmpParameter snmpProxyParameter = new OltSnmpParameter(iadMgr, neName);
        iadMgr.setSnmpParameter(snmpProxyParameter);
        iadMgr.init();

        if (nodeType.startsWith("B1205") || nodeType.startsWith("B130")) {
            String ip = getOnuIpAddress(iadMgr, moduleId, portId, onuId);
            if (ip != null) {
                System.out.println("The ONU IP: " + ip);
                openNeDvm(iadMgr, ip);
            } else {
                System.out.println("Can't get the ONU IP!");
            }
        } else if (nodeType.equalsIgnoreCase("ONU")) {
            String ip = getBbs4000R4OnuIpAddress(iadMgr, moduleId, portId, onuId);
            if (ip != null) {
                System.out.println("The ONU IP: " + ip);
                openNodeDvm(iadMgr, ip, nodeType);
            } else {
                System.out.println("Can't get the ONU IP!");
            }
        } else if (nodeType.startsWith("CBAT")) {
            String ip = getBbs4000R4EocIpAddress(iadMgr, moduleId, portId, onuId);
            if (ip != null) {
                System.out.println("The EOC IP: " + ip);
                openNodeDvm(iadMgr, ip, nodeType);
            } else {
                System.out.println("Can't get the EOC IP!");
            }
        } else if (nodeType.indexOf("204i-k7") >= 0 && nodeType.indexOf("R.a2") >= 0 && nodeType.indexOf("ONU") >= 0) {
            ISnmpParameter snmpParameter = getSnmpProxyParameter(iadMgr, neName, moduleId, portId, onuId);
            String title = moduleId + "/" + portId + "/" + onuId;
            String version = "1.0";
            iadMgr.showDVM(snmpParameter, title, "ONU204i-k7 R.a2", version);
        } else if (nodeType.contains("204i-h") && nodeType.contains("R.c1")) {
            String version = nodeVersion;
            if (version == null || version.trim().length() <= 0)
                version = getOnuVersion(iadMgr, moduleId, portId, onuId); //get the version from ONU swtich
            if (version == null || version.trim().length() <= 0)
                version = "1.0.0"; //use the default version
            ISnmpParameter snmpParameter = getSnmpProxyParameter(iadMgr, neName, moduleId, portId, onuId);
            String title = moduleId + "/" + portId + "/" + onuId;
            iadMgr.showDVM(snmpParameter, title, "ONU 204i-h R.c1", version);
        } else {
            String version = nodeVersion;
            if (version == null || version.trim().length() <= 0)
                version = getOnuVersion(iadMgr, moduleId, portId, onuId); //get the version from ONU swtich
            if (version == null || version.trim().length() <= 0)
                version = "1.0.0"; //use the default version
            ISnmpParameter snmpParameter = getSnmpProxyParameter(iadMgr, neName, moduleId, portId, onuId);
            String title = moduleId + "/" + portId + "/" + onuId;
            iadMgr.showDVM(snmpParameter, title, nodeType, version);
        }
    }
*/

    private ISnmpParameter getSnmpProxyParameter(IADManager iadMgr, String ipAddress) {
        SnmpParameter parameter = null;

        try {
            String nodeName = UTopoAPI.getAPI().getNodeNameByIP(ipAddress);
            if (nodeName == null)
                return null;

            Properties neProperty = UTopoAPI.getAPI().getNodeProperties(nodeName);
            if (neProperty == null)
                return null;

            int port = 161;
            String readCommunity = iadMgr.getSnmpProxy().getReadCommunity();
            String writeCommunity = iadMgr.getSnmpProxy().getWriteCommunity();
            String snmpVersion = "v2";

//            if (DebugMode.isDebug()) {
//                if (!SnmpUtility.snmpPing(ipAddress, port, readCommunity))
//                    return null;
//            }

            parameter = new SnmpParameter(ipAddress, port);
            parameter.setReadCommunity(readCommunity);
            parameter.setWriteCommunity(writeCommunity);
            parameter.setSnmpVersion(DvmUtil.convertSnmpVersion(snmpVersion));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return parameter;
    }

    private String getOnuIpAddress(IADManager iadMgr, int moduleId, int portId, int onuId) {
        try {
            Dot3OnuSwitchTable table = new Dot3OnuSwitchTable(iadMgr.getSnmpProxy());

            table.setUtsDot3OnuSwitchModuleId(moduleId);
            table.setUtsDot3OnuSwitchPortId(portId);
            table.setUtsDot3OnuSwitchLlid(onuId);
            table.retrieve();

            return table.getUtsDot3OnuSwitchIpAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getBbs4000R4OnuIpAddress(IADManager iadMgr, int moduleId, int portId, int onuId) {
        try {
            com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuInfoTable table = new com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuInfoTable(iadMgr.getSnmpProxy());

            int[] indexes = new int[4];
            indexes[3] = 0;
            indexes[2] = moduleId;
            indexes[1] = portId;
            indexes[0] = onuId;
            int eponDeviceIndex = constructEponDeviceIndex(indexes);

            table.setOnuDeviceIndex(eponDeviceIndex);
            table.retrieve();

            return table.getOnuIpAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getBbs4000R4EocIpAddress(IADManager iadMgr, int moduleId, int portId, int onuId) {
        try {
            com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuInfoTable table = new com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuInfoTable(iadMgr.getSnmpProxy());

            int[] indexes = new int[4];
            indexes[3] = 0;
            indexes[2] = moduleId;
            indexes[1] = portId;
            indexes[0] = onuId;
            int eponDeviceIndex = constructEponDeviceIndex(indexes);

            table.setOnuDeviceIndex(eponDeviceIndex);
            table.retrieve();

            return table.getOnuIpAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private int constructEponDeviceIndex(int[] indexes) {
        int eponDeviceIndex = 0;

        if (indexes != null) {
            for (int i = 0; i < indexes.length; i++) {
                eponDeviceIndex = indexes[indexes.length - 1 - i] & 0xFF;
                eponDeviceIndex = eponDeviceIndex << 8;
            }
        }

        return eponDeviceIndex;
    }

    private String getCommunityPostfix(int moduleId, int portId, int onuId) {
        StringBuffer sb = new StringBuffer("#OLTchassis:1");
        sb.append("#OLTmodule:").append(moduleId);
        sb.append("#OLTport:").append(portId);
        sb.append("#ONU:").append(onuId);

        return sb.toString();
    }

    private String getOnuVersion(IADManager iadMgr, String type, String ip, int port, String getCommunity) {
        SnmpTarget target = new SnmpTarget();
        target.setTimeout(1);
        target.setRetries(0);
        target.setAttemptPartial(true);

        target.setTargetHost(ip);
        target.setCommunity(getCommunity);
        target.setTargetPort(port);

        String version = null;
        try {
            if (type != null && "ONU204i-h".equalsIgnoreCase(type)) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.41355.1.3.10.100.33.2.2.1.0"));
            } else if (type != null && (type.startsWith("ONU4016i") || type.startsWith("ONU408t"))) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.41355.1.3.10.100.1408.2.1.3.0")); //for NMS00069686, added by Zhouchao, 2010/10/13
            } else if (type != null && type.startsWith("ONU4024i")) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.41355.1.3.10.100.4024.2.3.1.8.0"));
            } else if (type != null && (type.equalsIgnoreCase("ONU204i-h R.h1") || type.startsWith("ONU204i-k7 R.a"))) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.17409.2.3.4.1.1.13.0"));
            } else if (type != null && (type.startsWith("ONU204i") || type.startsWith("ONU2004-2") || type.equalsIgnoreCase("ONU2004i") || type.equalsIgnoreCase("ONU208"))) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.41355.1.3.10.100.106.2.2.0"));
            } else if (type != null && type.startsWith("ONU404i")) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.41355.1.3.10.100.17.2.2.1.0"));
            } else if (type != null && type.startsWith("ONU804i")) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.41355.1.3.10.100.20.2.2.1.0"));
            } else if (type != null && "JS16B-v".equals(type) ||
                    "JS24B-v".equals(type)) {
                // There is no version info in current SRS !
            } else if (type != null && type.startsWith("CLT2168")) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.17409.2.4.3.2.1.5.0"));
            } else if (type != null && type.startsWith("CLT2170") || type != null && type.startsWith("CLT2171")) {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.17409.2.4.1.1.6.0"));
            } else {
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.41355.1.3.10.100.106.2.2.0"));
            }

            Object result = target.snmpGet();
            if (result != null) {
                version = result.toString();

                //trim the forth sub-version.
                String split[] = version.split("\\.");
                if (split.length > 3) {
                    return split[0] + "." + split[1] + "." + split[2];
                }
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

        return version;
    }

    void openNeDvm(IADManager iadMgr, String ip) {
        try {
            List list = ScoaAPI.getApiFactory().getRemoteTopoAPI().getMEListByAddress(ip);
            if (list != null && list.size() > 0) {
                ManagedElement me = (ManagedElement) list.get(0);
                UINEContextInfo neinfo = TopoUICommon.getNEContextInfo(me);
                UIMenuItemData menuitemdata = UIMenuDataMgr.getInstance().getMenuItemData(UIMenuData.POPUP_MENU, neinfo.neType, ClientMenuReader.MENUITEM_DEVICEMGR);
                if (menuitemdata != null) {
                    UIMenuDataMgr.getInstance().processMenuItemAction(neinfo, menuitemdata);
                }
            } else {
                JOptionPane.showMessageDialog((JFrame) iadMgr.getOmcdParmMap().get("parentFrame"), "The ONU is not installed in TOPO.");
                System.out.println("The NE is not installed in TOPO.");
            }
        } catch (Exception e) {
            System.out.println("OpenOnuDvmAction.openNeDvm() -- Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void openNodeDvm(IADManager iadMgr, String ip, String type) {
        try {
            if (iadMgr != null)
                iadMgr.showDVM(getSnmpProxyParameter(iadMgr, ip), type + " Management", type, "");
        } catch (Exception e) {
            System.out.println("OpenOnuDvmAction.openNodeDvm() -- Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean construct() {
        return true;
    }

    public boolean destroy() {
        iadMgr.destroy();
        iadMgr.getDvmFrame(title).getTopMostFrame().dispose();
        return true;
    }

    public Window getWindow() {
        //MainApplet applet = iadMgr.getDvmFrame(title);
        return iadMgr.getDvmFrame(title).getTopMostFrame();
    }

    public boolean isSingleton() {
        return true;
    }

    //added by zengtian 2012/02/21 for NMS00072364
    public void constructFrame() {
        ManagedWindowMgr mgr = ManagedWindowMgr.getInstance();
        ManagedWindow mw = mgr.getWindowInstance("Open_ONU_Dvm_Log", "OpenOnuDvmAction");
        if (mw == null) {
            mw = new OpenOnuDvmAction(fApplication);
            mgr.constructAndShow("Open_ONU_Dvm_Log", "OpenOnuDvmAction", mw);
        } else {
            mgr.showWindow(mw.getWindow());
        }
    }

    class OpenOnuDvmTask extends Task {

        String neName = "";
        String neType = "";
        String onuLabel = "";
        int moduleId = 0;
        int portId = 0;
        int onuId = 0;
        String nodeType = "";
        String nodeVersion = "";

        public OpenOnuDvmTask(String neName, String neType, String onuLabel, int moduleId, int portId, int onuId, String nodeType, String nodeVersion) {
            this.neName = neName;
            this.neType = neType;
            this.onuLabel = onuLabel;
            this.moduleId = moduleId;
            this.portId = portId;
            this.onuId = onuId;
            this.nodeType = nodeType;
            this.nodeVersion = nodeVersion;
        }

        public Object execute() throws Exception {
            boolean result = openOnuDvm(neName, neType, onuLabel, moduleId, portId, onuId, nodeType, nodeVersion);

            return (result ? Boolean.TRUE : Boolean.FALSE);
        }

    }

}
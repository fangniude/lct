package com.winnertel.ems.epon.iad.inventory.gui;

import com.winnertel.ems.epon.iad.IADManager;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuInfoTable;
import com.winnertel.ems.epon.iad.common.mib.OnuMBean;
import com.winnertel.ems.epon.iad.inventory.mib.Dot3OnuSwitchTable;
import com.winnertel.ems.epon.iad.inventory.model.IADNode;
import com.winnertel.ems.epon.iad.inventory.model.InventoryNode;
import com.winnertel.ems.epon.iad.inventory.model.LogicalPortNode;
import com.winnertel.ems.epon.iad.inventory.model.ModuleNode;
import com.winnertel.ems.epon.iad.inventory.model.NENode;
import com.winnertel.ems.epon.iad.inventory.model.PortNode;
import com.winnertel.ems.epon.iad.snmp.OnuSnmpParameter;
import com.winnertel.em.standard.device.DvmUtil;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.inms.topoui.TopoUICommon;
import com.winnertel.inms.topoui.UIMenuData;
import com.winnertel.inms.topoui.UIMenuDataMgr;
import com.winnertel.inms.topoui.UIMenuItemData;
import com.winnertel.inms.topoui.UINEContextInfo;
import com.winnertel.inms.topoui.v2.ClientMenuReader;
import com.winnertel.nms.lite.client.rmi.ScoaAPI;
import com.winnertel.nms.lite.momodel.ManagedElement;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Properties;

public class InventoryTreeMouseAdapter extends MouseAdapter {

    private JTree fTree;
    private IADManager manager;

    public InventoryTreeMouseAdapter(IADManager manager, JTree tree) {
        this.manager = manager;
        fTree = tree;
    }

    public void mouseClicked(MouseEvent e) {
        if (e != null && e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
            mouseClick(e.getX(), e.getY());
        }
    }

    private void mouseClick(int x, int y) {
        TreePath path = fTree.getPathForLocation(x, y);
        if (path == null)
            return;

        InventoryNode selectedNode;
        selectedNode = (InventoryNode) fTree.getLastSelectedPathComponent();
        if (!(selectedNode instanceof IADNode)) return;

        String nodeType = selectedNode.toString();
        System.out.println("The selected node type is '" + nodeType + "'");

        if (nodeType.startsWith("B1205") || nodeType.startsWith("B130")) {
            String ip = getOnuIpAddress(path);
            if (ip != null) {
                System.out.println("The ONU IP: " + ip);
                openNeDvm(ip);
            } else {
                System.out.println("Can't get the ONU IP!");
            }
        } else if (nodeType.equalsIgnoreCase("ONU")) { //added by Zhou Chao, 2010/5/20
            String ip = getBbs4000R4OnuIpAddress(path);
            if (ip != null) {
                System.out.println("The ONU IP: " + ip);
                openNodeDvm(ip, nodeType);
            } else {
                System.out.println("Can't get the ONU IP!");
            }
        } else if (nodeType.startsWith("CBAT")) { //added by Zhou Chao, 2010/5/20 //todo
            String ip = getBbs4000R4EocIpAddress(path);
            if (ip != null) {
                System.out.println("The EOC IP: " + ip);
                openNodeDvm(ip, nodeType);
            } else {
                System.out.println("Can't get the EOC IP!");
            }
        }//else if (nodeType.equalsIgnoreCase("ONU 204i-k7 R.a2")){  // added by Hz20163 ,support 204i-k7 R.a2
        else if(nodeType.indexOf("204i-k7")>=0 && nodeType.indexOf("R.a2")>=0 && nodeType.indexOf("ONU")>=0){
        	String version ="1.0";
        	manager.showDVM(getSnmpProxyParameter(fTree.getSelectionPath()), getTitle(fTree.getSelectionPath()), "ONU204i-k7 R.a2", version);
        	//manager.showDVM(getSnmpProxyParameter(fTree.getSelectionPath()), getTitle(fTree.getSelectionPath()), "ONU204i-k7 R.a2", "1.0");
        }else if (nodeType.contains("204i-h") && nodeType.contains("R.c1")) {// added by HZ20192, support 204i-h R.c1
          //get the version from ONU swtich.
            String version = getOnuVersion(fTree.getSelectionPath());
            if (version == null) {
                //get the version from OLT.
                IADNode onuNode = (IADNode) selectedNode;
                version = onuNode.getVersion();
            }
            //use the default version.
            if (version == null || version.equals("")) {
                version = "1.0.0";
            }
            manager.showDVM(getSnmpProxyParameter(fTree.getSelectionPath()), getTitle(fTree.getSelectionPath()), "ONU 204i-h R.c1", version);
	}
        else if(nodeType.indexOf("JS16B-v")>=0 || nodeType.indexOf("JS24B-v")>=0){
        	String version ="1.0.0";
        	String nt;
        	if(nodeType.indexOf("JS16B-v")>=0){
        		nt="JS16B-v";
        	}else
        		nt="JS24B-v";
        	manager.showDVM(getSnmpProxyParameter(fTree.getSelectionPath()), getTitle(fTree.getSelectionPath()), nt, version);
        }

        else {
            //get the version from ONU swtich.
            String version = getOnuVersion(fTree.getSelectionPath());
            if (version == null) {
                //get the version from OLT.
                IADNode onuNode = (IADNode) selectedNode;
                version = onuNode.getVersion();
            }
            //use the default version.
            if (version == null || version.equals("")) {
                version = "1.0.0";
            }
            manager.showDVM(getSnmpProxyParameter(fTree.getSelectionPath()), getTitle(fTree.getSelectionPath()), selectedNode.toString(), version);
        }
    }

    private String getTitle(TreePath path) {
        Object[] os = path.getPath();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < os.length; i++) {
            InventoryNode node = (InventoryNode) os[i];
            if (node instanceof NENode) {
                sb.append(node.getSearchId()).append(":Module/Port/ONU:");
            }
            if (node instanceof ModuleNode) {
                sb.append(node.getSearchId()).append("/");
            } else if (node instanceof PortNode) {
                sb.append(node.getSearchId()).append("/");
            } else if (node instanceof LogicalPortNode) {
                sb.append(node.getSearchId());
            }
        }

        return sb.toString();
    }

    private ISnmpParameter getSnmpProxyParameter(TreePath path) {
        String neName = null;
        int moduleId = 0;
        int portId = 0;
        int onuId = 0;

        Object[] os = path.getPath();
        for (int i = 0; i < os.length; i++) {
            InventoryNode node = (InventoryNode) os[i];
            if (node instanceof NENode) {
                neName = ((NENode) node).getName();
            } else if (node instanceof ModuleNode) {
                moduleId = Integer.parseInt(node.getSearchId());
            } else if (node instanceof PortNode) {
                portId = Integer.parseInt(node.getSearchId());
            } else if (node instanceof LogicalPortNode) {
                onuId = Integer.parseInt(node.getSearchId());
            }
        }

        OnuSnmpParameter parameter = null;
//        if (DebugMode.isDebug()) { //added by Zhou Chao, 2009/3/13
//            parameter = new OnuSnmpParameter(null, neName, moduleId, portId, onuId) {
//                public void update() {
//                    setTargetHost(manager.getSnmpProxy().getTargetHost());
//                    setTargetPort(161);
//                    setSnmpVersion(getSnmpVersion());
//                    setReadCommunity(getCommunity(manager.getSnmpProxy().getReadCommunity()));
//                    setWriteCommunity(getCommunity(manager.getSnmpProxy().getWriteCommunity()));
//                }
//            };
//        } else
      {
            parameter = new OnuSnmpParameter(manager, neName, moduleId, portId, onuId);
        }
        parameter.update();

        return parameter;
    }

    //added by Zhou Chao, 2010/5/24
    private ISnmpParameter getSnmpProxyParameter(String ipAddress) { //todo
        SnmpParameter parameter = null;

        try {
            String nodeName = UTopoAPI.getAPI().getNodeNameByIP(ipAddress);
            if (nodeName == null)
                return null;

            Properties neProperty = UTopoAPI.getAPI().getNodeProperties(nodeName);
            if (neProperty == null)
                return null;

            int port = 161;
            String readCommunity = manager.getSnmpProxy().getReadCommunity();
            String writeCommunity = manager.getSnmpProxy().getWriteCommunity();
            String snmpVersion = "v2";

//            if (DebugMode.isDebug()) {
//                if (!SnmpUtility.snmpPing(ipAddress, port, readCommunity))
//                    return null;
//            }

            parameter = new SnmpParameter(ipAddress,port);
            parameter.setReadCommunity(readCommunity);
            parameter.setWriteCommunity(writeCommunity);
            parameter.setSnmpVersion(DvmUtil.convertSnmpVersion(snmpVersion));
        } catch (Exception e) {
        }

        return parameter;
    }

    private String getOnuIpAddress(TreePath path) {
        try {
            int module = 0;
            int port = 0;
            int onu = 0;

            Object[] os = path.getPath();
            for (int i = 0; i < os.length; i++) {
                InventoryNode node = (InventoryNode) os[i];
                if (node instanceof ModuleNode) {
                    module = Integer.parseInt(node.getSearchId());
                } else if (node instanceof PortNode) {
                    port = Integer.parseInt(node.getSearchId());
                } else if (node instanceof LogicalPortNode) {
                    onu = Integer.parseInt(node.getSearchId());
                }
            }

            Dot3OnuSwitchTable table = new Dot3OnuSwitchTable(manager.getSnmpProxy());

            table.setUtsDot3OnuSwitchModuleId(module);
            table.setUtsDot3OnuSwitchPortId(port);
            table.setUtsDot3OnuSwitchLlid(onu);
            table.retrieve();

            return table.getUtsDot3OnuSwitchIpAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //added by Zhou Chao, 2010/5/20
    private String getBbs4000R4OnuIpAddress(TreePath path) {
        try {
            int module = 0;
            int port = 0;
            int onu = 0;

            Object[] os = path.getPath();
            for (int i = 0; i < os.length; i++) {
                InventoryNode node = (InventoryNode) os[i];
                if (node instanceof ModuleNode) {
                    module = Integer.parseInt(node.getSearchId());
                } else if (node instanceof PortNode) {
                    port = Integer.parseInt(node.getSearchId());
                } else if (node instanceof LogicalPortNode) {
                    onu = Integer.parseInt(node.getSearchId());
                }
            }

            OnuInfoTable table = new OnuInfoTable(manager.getSnmpProxy());

            int[] indexes = new int[4];
            indexes[3] = 0;
            indexes[2] = module;
            indexes[1] = port;
            indexes[0] = onu;
            int eponDeviceIndex = constructEponDeviceIndex(indexes);

            table.setOnuDeviceIndex(eponDeviceIndex);
            table.retrieve();

            return table.getOnuIpAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //added by Zhou Chao, 2010/5/20
    private String getBbs4000R4EocIpAddress(TreePath path) {
        try {
            int module = 0;
            int port = 0;
            int onu = 0;

            Object[] os = path.getPath();
            for (int i = 0; i < os.length; i++) {
                InventoryNode node = (InventoryNode) os[i];
                if (node instanceof ModuleNode) {
                    module = Integer.parseInt(node.getSearchId());
                } else if (node instanceof PortNode) {
                    port = Integer.parseInt(node.getSearchId());
                } else if (node instanceof LogicalPortNode) {
                    onu = Integer.parseInt(node.getSearchId());
                }
            }

            OnuInfoTable table = new OnuInfoTable(manager.getSnmpProxy());

            int[] indexes = new int[4];
            indexes[3] = 0;
            indexes[2] = module;
            indexes[1] = port;
            indexes[0] = onu;
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

    private String getCommunityPostfix(TreePath path) {
        StringBuffer sb = new StringBuffer("#OLTchassis:1");

        Object[] os = path.getPath();
        for (int i = 0; i < os.length; i++) {
            InventoryNode node = (InventoryNode) os[i];
            if (node instanceof ModuleNode) {
                sb.append("#OLTmodule:").append(Integer.parseInt(node.getSearchId()));
            } else if (node instanceof PortNode) {
                sb.append("#OLTport:").append(Integer.parseInt(node.getSearchId()));
            } else if (node instanceof LogicalPortNode) {
                sb.append("#ONU:").append(Integer.parseInt(node.getSearchId()));
            }
        }

        return sb.toString();
    }

    private String getOnuVersion(TreePath path) {
        String version = null;
        String oldCommunity = manager.getSnmpProxy().getReadCommunity();

        try {
            manager.getSnmpProxy().setReadCommunity(oldCommunity + getCommunityPostfix(path));
            OnuMBean onu = new OnuMBean(manager.getSnmpProxy());
            onu.retrieve();

            version = onu.getSysSoftwareVer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.getSnmpProxy().setReadCommunity(oldCommunity);
        }

        //trim the fourth subversion.
        if (version != null && version.indexOf('.') != -1) {
            return version.substring(0, version.lastIndexOf('.'));
        }

        return version;
    }

    void openNeDvm(String ip) {
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
                JOptionPane.showMessageDialog((JFrame) manager.getOmcdParmMap().get("parentFrame"), "The ONU is not installed in TOPO.");
                System.out.println("The NE is not installed in TOPO.");
            }
        } catch (Exception e) {
            System.out.println("InventoryTreeMouseAdapter.openNeDvm() -- Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //added by Zhou Chao, 2010/5/24
    void openNodeDvm(String ip, String type) {
        try {
            if (manager != null)
                manager.showDVM(getSnmpProxyParameter(ip), type + " Management", type, "");
        } catch (Exception e) {
            System.out.println("InventoryTreeMouseAdapter.openNodeDvm() -- Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
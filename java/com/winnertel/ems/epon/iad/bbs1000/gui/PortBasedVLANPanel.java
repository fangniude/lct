package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.PortBasedVLAN;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.snmp.snmp2.DefaultSnmpException;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

/* Modified by Zhou Chao, 2008/7/17 */
public class PortBasedVLANPanel extends UPanel {

    //private IntegerTextField tfUtsLagExtDot1qVlanIndex = new IntegerTextField();
    private JTextField tfUtsLagExtDot1qVlanIndex = new JTextField();

    private StringTextField tfUtsLagExtDot1qVlanName = new StringTextField();

    // table for selecting "Tagged / Untagged / Port VID" fields
    JTable portSelectionTbl = null;
    CustomTblModel portSelectionTblModel = null;
    Set portVidSet = new HashSet();

    private int[] utsLagExtDot1qVlanIgmpSnoopVList = new int[]{2, 1,};
    private String[] utsLagExtDot1qVlanIgmpSnoopTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };

    private JComboBox tfUtsLagExtDot1qVlanIgmpSnoop = new JComboBox(utsLagExtDot1qVlanIgmpSnoopTList);

    private int[] utsEponDot1qVlanStpBridgeEnableVList = new int[]{2, 1,};
    private String[] utsEponDot1qVlanStpBridgeEnableTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsEponDot1qVlanStpBridgeEnable = new JComboBox(utsEponDot1qVlanStpBridgeEnableTList);

    private final String utsLagExtDot1qVlanIndex = fStringMap.getString("utsLagExtDot1qVlanIndex") + " : ";
    private final String utsLagExtDot1qVlanName = fStringMap.getString("utsLagExtDot1qVlanName") + " : ";
    private final String utsLagExtDot1qVlanIgmpSnoop = fStringMap.getString("utsLagExtDot1qVlanIgmpSnoop") + " : ";
    private final String utsEponDot1qVlanStpBridgeEnable = fStringMap.getString("utsEponDot1qVlanStpBridgeEnable") + " : ";

    public PortBasedVLANPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel baseInfoPanel1 = new JPanel();
        NTLayout layout1 = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseInfoPanel1.setLayout(layout1);
        baseInfoPanel1.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel1.add(new JLabel(utsLagExtDot1qVlanIndex));
        tfUtsLagExtDot1qVlanIndex.setName(fStringMap.getString("utsLagExtDot1qVlanIndex"));
        baseInfoPanel1.add(tfUtsLagExtDot1qVlanIndex);
        //baseInfoPanel1.add(new HSpacer());
        baseInfoPanel1.add(new JLabel("(" + fStringMap.getString("MSG_BATCH_INPUT_TIPS") + ")")); //added by Zhou Chao, 2009/1/8

        baseInfoPanel1.add(new JLabel(utsLagExtDot1qVlanName));
        tfUtsLagExtDot1qVlanName.setName(fStringMap.getString("utsLagExtDot1qVlanName"));
        baseInfoPanel1.add(tfUtsLagExtDot1qVlanName);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(utsLagExtDot1qVlanIgmpSnoop));
        tfUtsLagExtDot1qVlanIgmpSnoop.setName(fStringMap.getString("utsLagExtDot1qVlanIgmpSnoop"));
        baseInfoPanel1.add(tfUtsLagExtDot1qVlanIgmpSnoop);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(utsEponDot1qVlanStpBridgeEnable));
        tfUtsEponDot1qVlanStpBridgeEnable.setName(fStringMap.getString("utsEponDot1qVlanStpBridgeEnable"));
        baseInfoPanel1.add(tfUtsEponDot1qVlanStpBridgeEnable);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel.add(baseInfoPanel1);
        //baseInfoPanel.add(new HSpacer());

        // begin of construct port selecttion table
        JPanel baseInfoPanel2 = new JPanel();
        NTLayout layout2 = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout2.setMargins(6, 10, 6, 10);
        baseInfoPanel2.setLayout(layout2);
        baseInfoPanel2.setBorder(BorderFactory.createEtchedBorder());

        Vector columnNames = new Vector();
        Vector rowData = new Vector();

        columnNames.add(fStringMap.getString("Port ID"));
        columnNames.add(fStringMap.getString("utsLagExtDot1qVlanTaggedPortListPorts"));
        columnNames.add(fStringMap.getString("utsLagExtDot1qVlanUnTaggedPortListPorts"));
        columnNames.add(fStringMap.getString("utsLagExtDot1qVlanPortVidListPorts"));

        portSelectionTblModel = new CustomTblModel(rowData, columnNames);
        portSelectionTbl = new JTable(portSelectionTblModel);
        portSelectionTbl.setPreferredScrollableViewportSize(new Dimension(360, 230));
        portSelectionTbl.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent event) {
                AbstractTableModel model = (AbstractTableModel) event.getSource();
                int type = event.getType();
                switch (type) {
                    case TableModelEvent.UPDATE:
                        int rowIdx = event.getFirstRow();
                        int colIdx = event.getColumn();
                        Boolean tagged = (Boolean) model.getValueAt(rowIdx, 1);
                        Boolean untagged = (Boolean) model.getValueAt(rowIdx, 2);
                        if (colIdx == 1) {
                            if (tagged)
                                model.setValueAt(Boolean.FALSE, rowIdx, 2);
                            if (!tagged && !untagged) {
                                model.setValueAt(Boolean.FALSE, rowIdx, 3);
                            }
                        }
                        if (colIdx == 2) {
                            if (untagged)
                                model.setValueAt(Boolean.FALSE, rowIdx, 1);
                            if (!tagged && !untagged) {
                                model.setValueAt(Boolean.FALSE, rowIdx, 3);
                            }
                        }
                        if (colIdx == 3) {
                            Boolean pvid = (Boolean) model.getValueAt(rowIdx, 3);
                            if (!pvid) {
                                portVidSet.remove(model.getValueAt(rowIdx, 0));
                            }
                        }
                        break;
                }
            }
        });

        JScrollPane tmpScrollPane = new JScrollPane(portSelectionTbl);
        baseInfoPanel2.add(tmpScrollPane);

        baseInfoPanel.add(baseInfoPanel2);
        //baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    private Vector getPortList() throws Exception {
        Vector allPortList = new Vector();
        BBS1000CardMibBean cardMBean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, cardMBean);
        Set moduleBoardTypeSet = new HashSet();
        for (int i = 0; i < v.size(); i++) {
            int moduleBoardPhyId = ((BBS1000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId();
            int moduleBoardState = ((BBS1000CardMibBean) v.get(i)).getUtsEponModuleBoardState();
            if (moduleBoardState == 3) {
                moduleBoardTypeSet.add(String.valueOf(moduleBoardPhyId));
            }
        }
        for (Iterator iter = moduleBoardTypeSet.iterator(); iter.hasNext();) {
            String tmpBoardID = (String) iter.next();
            for (int i = 1; i <= 4; i++) {
                allPortList.add(tmpBoardID + "/" + i);
            }
        }

        EthIfExtTable portMBean = new EthIfExtTable(fApplication.getSnmpProxy());
        Vector portVec = portMBean.retrieveRealAll();
        // remove layer-3 ports and add vlan IDs
        for (int i = 0; i < portVec.size(); i++) {
            EthIfExtTable tmpL2PortTbl = (EthIfExtTable) portVec.elementAt(i);
            String portName = tmpL2PortTbl.getUtsEthIfExtModuleId() + "/" + tmpL2PortTbl.getUtsEthIfExtPortId();
            int tmpPortType = tmpL2PortTbl.getUtsEthIfExtPortType();
            int switchMode = tmpL2PortTbl.getUtsEthIfExtSwitchMode();
            if (tmpPortType == 1) {
                // remove layer-3 ports
                if (switchMode == 2) {
                    allPortList.remove(portName);
                }
            } else if (tmpPortType == 2 && switchMode == 1) { //lg and lay 2.
                allPortList.add("lg" + tmpL2PortTbl.getUtsEthIfExtLinkAggGroupId());
            }
        }

        // remove L2 port that in Link Aggregation set
        LinkAggregation lgMBean = new LinkAggregation(fApplication.getSnmpProxy());
        Vector lgVec = BeanService.refreshTableBean(fApplication, lgMBean);
        if (lgVec == null)
            lgVec = new Vector(0);
        Set l2PortInLGSet = new HashSet();
        for (int i = 0; i < lgVec.size(); i++) {
            LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(i);
            String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());
            for (int j = 0; j < array.length; j++) {
                l2PortInLGSet.add(array[j]);
            }
        }
        for (Iterator iter = l2PortInLGSet.iterator(); iter.hasNext();) {
            allPortList.remove(iter.next());
        }

        return allPortList;
    }

    protected void initForm() {
        //tfUtsLagExtDot1qVlanIndex.setValueScope(1, 4094);
        tfUtsLagExtDot1qVlanName.setLenScope(0, 16);
    }

    protected Set parsePortListString(byte[] b) {
        String[] portList = ConfigUtility.portMappingToStringArray(b);
        Set portListSet = new HashSet();
        for (int i = 0; i < portList.length; i++) {
            portListSet.add(portList[i]);
        }

        return portListSet;
    }

    public void refresh() {
        try {
            // init port vid list
            portVidSet.clear();
            PortBasedVLAN portVLANMBean = new PortBasedVLAN(fApplication.getSnmpProxy());
            Vector allPortVLANs = BeanService.refreshTableBean(fApplication, portVLANMBean);
            for (int i = 0; i < allPortVLANs.size(); i++) {
                PortBasedVLAN tmpPortBasedVLAN = (PortBasedVLAN) allPortVLANs.elementAt(i);
                if (tmpPortBasedVLAN.getUtsLagExtDot1qVlanIndex() != 1) {
                    portVidSet.addAll(parsePortListString(tmpPortBasedVLAN.getUtsLagExtDot1qVlanPortVidListPorts()));
                }
            }

            if (SnmpAction.IType.ADD.equals(fCommand)) {
                portSelectionTblModel.getDataVector().clear();
                Vector portList = getPortList();
                for (int i = 0; i < portList.size(); i++) {
                    Vector tmpVector = new Vector();
                    tmpVector.add(portList.elementAt(i));
                    tmpVector.add(Boolean.FALSE);
                    tmpVector.add(Boolean.FALSE);
                    tmpVector.add(Boolean.FALSE);
                    portSelectionTblModel.addRow(tmpVector);
                }

                return;
            }

            PortBasedVLAN mbean = (PortBasedVLAN) getModel();
            tfUtsLagExtDot1qVlanIndex.setEditable(false);
            //tfUtsLagExtDot1qVlanIndex.setValue(mbean.getUtsLagExtDot1qVlanIndex().intValue());
            tfUtsLagExtDot1qVlanIndex.setText(String.valueOf(mbean.getUtsLagExtDot1qVlanIndex()));
            tfUtsLagExtDot1qVlanName.setValue(mbean.getUtsLagExtDot1qVlanName());
            // begin to set tagged/untagged/vid data
            portSelectionTblModel.getDataVector().clear(); // clear original data first.
            Set taggedPortList = parsePortListString(mbean.getUtsLagExtDot1qVlanTaggedPortListPorts());
            Set untaggedPortList = parsePortListString(mbean.getUtsLagExtDot1qVlanUnTaggedPortListPorts());
            Set vidPortList = parsePortListString(mbean.getUtsLagExtDot1qVlanPortVidListPorts());

            Vector portList = getPortList();
            for (int i = 0; i < portList.size(); i++) {
                Vector tmpVector = new Vector();
                String portName = (String) portList.elementAt(i);
                tmpVector.add(portName);
                tmpVector.add(new Boolean(taggedPortList.contains(portName)));
                tmpVector.add(new Boolean(untaggedPortList.contains(portName)));
                tmpVector.add(new Boolean(vidPortList.contains(portName)));
                portSelectionTblModel.addRow(tmpVector);
            }

            // disable user to modify default VLAN (index:1)
            int vLANIdx = mbean.getUtsLagExtDot1qVlanIndex();
            if (vLANIdx == 1) {
                portSelectionTblModel.setBGlobalEditable(false);
            } else {
                portSelectionTblModel.setBGlobalEditable(true);
            }

            tfUtsLagExtDot1qVlanIgmpSnoop.setSelectedIndex(getIndexFromValue(utsLagExtDot1qVlanIgmpSnoopVList, mbean.getUtsLagExtDot1qVlanIgmpSnoop()));

            tfUtsEponDot1qVlanStpBridgeEnable.setSelectedIndex(getIndexFromValue(utsEponDot1qVlanStpBridgeEnableVList, mbean.getUtsEponDot1qVlanStpBridgeEnable()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //modified by Zhou Chao, 2008/7/17
    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new PortBasedVLAN(fApplication.getSnmpProxy()));

        PortBasedVLAN mbean = (PortBasedVLAN) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index

            boolean isSingle = true;
            int startIndex = 0;
            int endIndex = 0;
            String indexStr = tfUtsLagExtDot1qVlanIndex.getText();
            if (indexStr.indexOf("-") > 0) {
                isSingle = false;
                try {
                    startIndex = Integer.parseInt(indexStr.substring(0, indexStr.indexOf("-")).trim());
                } catch (NumberFormatException e) {
                }
                try {
                    endIndex = Integer.parseInt(indexStr.substring(indexStr.indexOf("-") + 1).trim());
                } catch (NumberFormatException e) {
                }
            } else {
                try {
                    endIndex = Integer.parseInt(indexStr);
                    startIndex = endIndex;
                } catch (NumberFormatException e) {
                }
            }

            /* apply 'check' in 'validateFrom'
            //check
            if (isSingle && (endIndex < 1 || endIndex > 4094)) {
                MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_VLAN_Is_Invalid_VLAN"));
                return;
            }
            if (!isSingle && (startIndex < 1 || startIndex > 4094) && (startIndex < endIndex)) {
                MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_VLAN_Is_Invalid_VLAN"));
                return;
            }
            */

            String vlanName = tfUtsLagExtDot1qVlanName.getValue();
            // get tagged/untagged/vid port lists
            byte[] taggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(1));
            byte[] untaggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(2));
            byte[] vidPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(3));
            int igmpSnoop = utsLagExtDot1qVlanIgmpSnoopVList[tfUtsLagExtDot1qVlanIgmpSnoop.getSelectedIndex()];
            int stpBridgeEnable = utsEponDot1qVlanStpBridgeEnableVList[tfUtsEponDot1qVlanStpBridgeEnable.getSelectedIndex()];

            for (int i = startIndex; i < endIndex; i++) {
                PortBasedVLAN bean = new PortBasedVLAN(fApplication.getSnmpProxy());

                bean.setUtsLagExtDot1qVlanIndex(i);
                bean.setUtsLagExtDot1qVlanName(vlanName);
                bean.setUtsLagExtDot1qVlanTaggedPortListPorts(taggedPorts);
                bean.setUtsLagExtDot1qVlanUnTaggedPortListPorts(untaggedPorts);
                bean.setUtsLagExtDot1qVlanPortVidListPorts(vidPorts);
                bean.setUtsLagExtDot1qVlanIgmpSnoop(igmpSnoop);
                bean.setUtsEponDot1qVlanStpBridgeEnable(stpBridgeEnable);
                try {
                    if (!bean.add())
                        return;
                } catch (MibBeanException e) {
                    return;
                }
            }

            // one (last) record
            mbean.setUtsLagExtDot1qVlanIndex(endIndex);
            mbean.setUtsLagExtDot1qVlanName(vlanName);
            mbean.setUtsLagExtDot1qVlanTaggedPortListPorts(taggedPorts);
            mbean.setUtsLagExtDot1qVlanUnTaggedPortListPorts(untaggedPorts);
            mbean.setUtsLagExtDot1qVlanPortVidListPorts(vidPorts);
            mbean.setUtsLagExtDot1qVlanIgmpSnoop(igmpSnoop);
            mbean.setUtsEponDot1qVlanStpBridgeEnable(stpBridgeEnable);
        } else {
            mbean.setUtsLagExtDot1qVlanName(tfUtsLagExtDot1qVlanName.getValue());

            // get tagged/untagged/vid port lists
            byte[] taggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(1));
            byte[] untaggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(2));
            byte[] vidPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(3));
            mbean.setUtsLagExtDot1qVlanTaggedPortListPorts(taggedPorts);
            mbean.setUtsLagExtDot1qVlanUnTaggedPortListPorts(untaggedPorts);
            mbean.setUtsLagExtDot1qVlanPortVidListPorts(vidPorts);

            mbean.setUtsLagExtDot1qVlanIgmpSnoop(utsLagExtDot1qVlanIgmpSnoopVList[tfUtsLagExtDot1qVlanIgmpSnoop.getSelectedIndex()]);
            mbean.setUtsEponDot1qVlanStpBridgeEnable(utsEponDot1qVlanStpBridgeEnableVList[tfUtsEponDot1qVlanStpBridgeEnable.getSelectedIndex()]);
        }
    }

    protected String[] getPortSelectionStr(int colIdx) {
        if (colIdx > 3 || colIdx < 1) {
            return new String[0];
        }

        ArrayList list = new ArrayList();
        for (int i = 0; i < portSelectionTblModel.getRowCount(); i++) {
            String portName = (String) portSelectionTblModel.getValueAt(i, 0);
            Boolean bValue = (Boolean) portSelectionTblModel.getValueAt(i, colIdx);
            if (bValue) {
                list.add(portName);
            }
        }

        return (String[]) list.toArray(new String[0]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void beforeUpdateModel() {
        super.beforeUpdateModel();
    }

    //modified by Zhou Chao, 2008/7/17
    public boolean validateFrom() {
        /*
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            String msg = checkVlanID();
            if (msg != null) {
                MessageDialog.showInfoMessageDialog(fApplication, msg);
                return false;
            }

            msg = checkVlanDuplicate();
            if (msg != null) {
                MessageDialog.showInfoMessageDialog(fApplication, msg);
                return false;
            }

            return true;
        }
        */

        String msg = checkVlanID();
        if (msg != null) {
            MessageDialog.showInfoMessageDialog(fApplication, msg);
            return false;
        }

        return true;
    }

    //modified by Zhou Chao, 2008/7/17
    private String checkVlanID() {
        String errMsg = null;

        boolean isSingle = true;
        int startIndex = 0;
        int endIndex = 0;
        String indexStr = tfUtsLagExtDot1qVlanIndex.getText();
        if (indexStr.indexOf("-") > 0) {
            isSingle = false;
            try {
                startIndex = Integer.parseInt(indexStr.substring(0, indexStr.indexOf("-")).trim());
            } catch (NumberFormatException e) {
            }
            try {
                endIndex = Integer.parseInt(indexStr.substring(indexStr.indexOf("-") + 1).trim());
            } catch (NumberFormatException e) {
            }
        } else {
            try {
                endIndex = Integer.parseInt(indexStr);
                startIndex = endIndex;
            } catch (NumberFormatException e) {
            }
        }

        //check
        if (isSingle) {
            if (endIndex < 1 || endIndex > 4094)
                return "VLAN " + endIndex + fStringMap.getString("Err_VLAN_Is_Invalid_VLAN");
        } else {
            if (startIndex < 1 || startIndex > 4094 || endIndex < 1 || endIndex > 4094 || startIndex > endIndex)
                return "VLAN " + endIndex + fStringMap.getString("Err_VLAN_Is_Invalid_VLAN");
        }

        for (int i = startIndex; i <= endIndex; i++) {
            if (1 == i) {
                return "VLAN 1 " + fStringMap.getString("Err_VLAN_Is_Reserved_VLAN");
            }
            /*
            if (1006 <= i && i <= 1133) {
                return "VLAN " + i + fStringMap.getString("Err_VLAN_Is_Reserved_VLAN");
            }
            */
        }
        
        if (SnmpAction.IType.ADD.equals(fCommand)) {
        	int row = fTable.getModel().getRowCount();
    		for(int k = 0; k < row; k++) {
    			int tvlanId = (Integer)fTable.getValueAt(k, 0);
    			if(startIndex <= tvlanId && endIndex >= tvlanId){
    				return fStringMap.getString("Err_Duplicate_VLAN_ID_1") + tvlanId + fStringMap.getString("Err_Duplicate_VLAN_ID_2");
    			}
    		}
        }

        
        try {
        	/*
            String[] oids = new String[]{".1.3.6.1.4.1.45121.1800.2.1.1.4.1.14.0"};
            Object[] rowData = fApplication.getSnmpProxy().loadRow(oids);
            int mode = 0;
            if (rowData != null && rowData.length != 0) {
                mode = Integer.parseInt(rowData[0].toString());
            }
            if (mode == 2) { // unique-tag-handling-mode
            */
        	String[] oids = new String[]{".1.3.6.1.4.1.45121.1800.2.1.1.2.1.0"};
                Object[] value = fApplication.getSnmpProxy().loadRow(oids);
                if (value != null && value.length != 0) {
                    int onuVlanBaseID = Integer.parseInt(value[0].toString());
                    if (onuVlanBaseID <= startIndex && startIndex <= onuVlanBaseID + 19) {
                        return "VLAN " + startIndex + fStringMap.getString("Err_VLAN_Is_ONU_VLAN") + onuVlanBaseID + "," + (onuVlanBaseID + 19) + ").";
                    }
                    if (onuVlanBaseID <= endIndex && endIndex <= onuVlanBaseID + 19) {
                        return "VLAN " + endIndex + fStringMap.getString("Err_VLAN_Is_ONU_VLAN") + onuVlanBaseID + "," + (onuVlanBaseID + 19) + ").";
                    }
                }
            //}
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (DefaultSnmpException e) {
            e.printStackTrace();
        }

        return errMsg;
    }

    /*
    private String checkPortList() {
        String errMsg = null;

        int vlanId = tfUtsLagExtDot1qVlanIndex.getValue();
        if (1 == vlanId) {
            return null;
        }

        int[] tagArray = ConfigUtility.StringArrayToPortArray(getPortSelectionStr(1));
        int[] untagArray = ConfigUtility.StringArrayToPortArray(getPortSelectionStr(2));

        for (int i = 0; i < tagArray.length; i++) {
            for (int j = 0; j < untagArray.length; j++) {
                if (tagArray[i] == untagArray[j]) {
                    return fStringMap.getString("Err_Port_Is_Tagged_And_Untagged");
                }
            }
        }

        // 1.check whether the tagged port and the untagged port is already defined in interface extention and
        // the switch mode is layer 3(the value is "2")
        EthInterface[] layer3Interface = new PortTreeNodeBuilder(fApplication.getSnmpProxy()).getThreeLayerInterface();
        for (int i = 0; i < layer3Interface.length; i++) {
            if (layer3Interface[i].getInterfaceID().indexOf("/") != -1) {
                int[] interNum = ConfigUtility.transferPortList(layer3Interface[i].getInterfaceID());
                for (int j = 0; j < tagArray.length; j++) {
                    if (interNum[0] == tagArray[j]) {
                        return fStringMap.getString("Err_Interface_Is_Layer3_1") + layer3Interface[i].getInterfaceID() + fStringMap.getString("Err_Interface_Is_Layer3_2");
                    }
                }
                for (int j = 0; j < untagArray.length; j++) {
                    if (interNum[0] == untagArray[j]) {
                        return fStringMap.getString("Err_Interface_Is_Layer3_1") + layer3Interface[i].getInterfaceID() + fStringMap.getString("Err_Interface_Is_Layer3_2");
                    }
                }
            }
        }

        //2.check whether the tagged port and the untagged is already link
        // aggregation member.
        LagInterface[] lag = LagInterface.getLagInterface(fApplication.getSnmpProxy());
        for (int i = 0; i < lag.length; i++) {
            int[] ports = lag[i].getPorts();
            for (int j = 0; j < ports.length; j++) {
                for (int k = 0; k < tagArray.length; k++) {
                    if (ports[j] == tagArray[k]) {
                        return fStringMap.getString("Err_Interface_Is_LG_1") + layer3Interface[i].getInterfaceID() + fStringMap.getString("Err_Interface_Is_LG_2");
                    }
                }
                for (int k = 0; k < untagArray.length; k++) {
                    if (ports[j] == untagArray[k]) {
                        return fStringMap.getString("Err_Interface_Is_LG_1") + layer3Interface[i].getInterfaceID() + fStringMap.getString("Err_Interface_Is_LG_2");
                    }
                }
            }
        }

        // added by Rox.
        // fix MR NMS00043948:
        // add check when create vlan or modify vlan, the vid port must belong to the tagged or untagged member list
        int[] pvidArray = ConfigUtility.StringArrayToPortArray(getPortSelectionStr(3));
        if (pvidArray.length != 0) {
            for (int i = 0; i < pvidArray.length; i++) {
                boolean exist = false;
                for (int j = 0; j < tagArray.length; j++) {
                    if (tagArray[j] == pvidArray[i]) {
                        exist = true;
                    }
                }
                for (int j = 0; j < untagArray.length; j++) {
                    if (untagArray[j] == pvidArray[i]) {
                        exist = true;
                    }
                }
                if (!exist) {
                    return fStringMap.getString("Err_PVID_Port_Not_Exist_1") + ConfigUtility.displayConfigIntfNum(pvidArray[i]) + fStringMap.getString("Err_PVID_Port_Not_Exist_2");
                }
            }

            // Except for the default VLAN 1, port can only belong to one VLAN's PVID list.
            VlanInterface[] vlan = VlanInterface.getVlanInterface(fApplication.getSnmpProxy());
            for (int i = 0; i < vlan.length; i++) {
                int alreadyVlanID = vlan[i].getVlanId();
                int[] alreadyVidPorts = vlan[i].getVidPorts();
                if ((alreadyVlanID != 1) && (vlanId != alreadyVlanID)) {
                    for (int j = 0; j < alreadyVidPorts.length; j++) {
                        for (int k = 0; k < pvidArray.length; k++) {
                            if (pvidArray[k] == alreadyVidPorts[j]) {
                                return fStringMap.getString("Err_PVID_Exist_In_Other_VLAN_1") + ConfigUtility.displayConfigIntfNum(pvidArray[k]) + fStringMap.getString("Err_PVID_Exist_In_Other_VLAN_2");
                            }
                        }
                    }
                }
            }
        }

        return errMsg;
    }
    */

    private String checkVlanDuplicate() {
        //int id = tfUtsLagExtDot1qVlanIndex.getValue();
        int id = 0;
        try {
            id = Integer.parseInt(tfUtsLagExtDot1qVlanIndex.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            PortBasedVLAN mBean = new PortBasedVLAN(fApplication.getSnmpProxy());
            Vector mbv = BeanService.refreshTableBean(fApplication, mBean);
            for (int i = 0; i < mbv.size(); i++) {
                int tmpVlanID = ((PortBasedVLAN) mbv.get(i)).getUtsLagExtDot1qVlanIndex();
                if (tmpVlanID == id) {
                    return fStringMap.getString("Err_Duplicate_VLAN_ID_1") + id + fStringMap.getString("Err_Duplicate_VLAN_ID_2");
                }
            }
        } catch (Exception ex) {
        }

        return null;
    }

    private class CustomTblModel extends DefaultTableModel {

        private static final long serialVersionUID = -1171878805440944363L;

        private boolean bGlobalEditable = true;

        public void setBGlobalEditable(boolean editable) {
            bGlobalEditable = editable;
        }

        public CustomTblModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        public CustomTblModel(Vector rowData, Vector columnNames) {
            super(rowData, columnNames);
        }

        public Class getColumnClass(int col) {
            // dataVector is a protected member of DefaultTableModel
            Vector v = (Vector) dataVector.elementAt(0);

            return v.elementAt(col).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            // for condition when user editing default VLAN (index:1)
            if (!bGlobalEditable)
                return false;

            // make the first column, which is 'port name', uneditable
            if (col == 0) {
                return false;
            }

            // the last column : VID
            if (col == 3) {
                String portName = (String) getValueAt(row, 0);
                Boolean tagged = (Boolean) getValueAt(row, 1);
                Boolean untagged = (Boolean) getValueAt(row, 2);

                if (!tagged && !untagged) {
                    return false;
                }

                Boolean pvid = (Boolean) getValueAt(row, 3);
                if (!pvid && portVidSet.contains(portName)) {
                    return false;
                }
            }

            return true;
        }

    }

}
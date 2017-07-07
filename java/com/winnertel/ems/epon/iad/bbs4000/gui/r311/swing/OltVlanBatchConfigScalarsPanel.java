package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.OltVlanBatchConfigScalars;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.command.RefreshTableCommand;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpCloseButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The OltVlanBatchConfigScalarsPanel class. Created by DVM Creator
 */
public class OltVlanBatchConfigScalarsPanel extends UPanel {

	private IntegerTextField tfUtsOltVlanBatchConfigStart = new IntegerTextField();

	private IntegerTextField tfUtsOltVlanBatchConfigStop = new IntegerTextField();

	private StringTextField tfUtsOltVlanBatchConfigVlanName = new StringTextField();

	private StringTextField tfUtsOltVlanBatchConfigTaggedPortListPorts = new StringTextField();

	private StringTextField tfUtsOltVlanBatchConfigUnTaggedPortListPorts = new StringTextField();
	
	private CustomTblModel portSelectionTblModel;
	
	private JTable portSelectionTbl;

	private int[] utsOltVlanBacthConfigIgmpSnoopVList = new int[] { 2, 1, };
	private String[] utsOltVlanBacthConfigIgmpSnoopTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };
//	private JComboBox tfUtsOltVlanBacthConfigIgmpSnoop = new JComboBox(
//			utsOltVlanBacthConfigIgmpSnoopTList);
	private int[] utsOltVlanBacthConfigPPPoEPlusVList = new int[] { 2, 1, };
	private String[] utsOltVlanBacthConfigPPPoEPlusTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };
//	private JComboBox tfUtsOltVlanBacthConfigPPPoEPlus = new JComboBox(
//			utsOltVlanBacthConfigPPPoEPlusTList);
	private int[] utsOltVlanBatchConfigL2DHCPOption82VList = new int[] { 2, 1, };
	private String[] utsOltVlanBatchConfigL2DHCPOption82TList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };
//	private JComboBox tfUtsOltVlanBatchConfigL2DHCPOption82 = new JComboBox(
//			utsOltVlanBatchConfigL2DHCPOption82TList);
	private int[] utsOltVlanBatchConfigArpProxySwitchVList = new int[] { 2, 1, };
	private String[] utsOltVlanBatchConfigArpProxySwitchTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };
//	private JComboBox tfUtsOltVlanBatchConfigArpProxySwitch = new JComboBox(
//			utsOltVlanBatchConfigArpProxySwitchTList);

	private final String utsOltVlanBatchConfigStart = fStringMap
			.getString("utsOltVlanBatchConfigStart")
			+ " : ";
	private final String utsOltVlanBatchConfigStop = fStringMap
			.getString("utsOltVlanBatchConfigStop")
			+ " : ";
	private final String utsOltVlanBatchConfigVlanName = fStringMap
			.getString("utsOltVlanBatchConfigVlanName")
			+ " : ";
	private final String utsOltVlanBatchConfigTaggedPortListPorts = fStringMap
			.getString("utsOltVlanBatchConfigTaggedPortListPorts")
			+ " : ";
	private final String utsOltVlanBatchConfigUnTaggedPortListPorts = fStringMap
			.getString("utsOltVlanBatchConfigUnTaggedPortListPorts")
			+ " : ";
	private final String utsOltVlanBacthConfigIgmpSnoop = fStringMap
			.getString("utsOltVlanBacthConfigIgmpSnoop")
			+ " : ";
	private final String utsOltVlanBacthConfigPPPoEPlus = fStringMap
			.getString("utsOltVlanBacthConfigPPPoEPlus")
			+ " : ";
	private final String utsOltVlanBatchConfigL2DHCPOption82 = fStringMap
			.getString("utsOltVlanBatchConfigL2DHCPOption82")
			+ " : ";
	private final String utsOltVlanBatchConfigArpProxySwitch = fStringMap
			.getString("utsOltVlanBatchConfigArpProxySwitch")
			+ " : ";
	private final String utsOltVlanBatchConfigPortListPorts = fStringMap
			.getString("utsOltVlanBatchConfigPortListPorts")
			+ " : ";

	private SnmpApplyButton btApply;
//	private SnmpRefreshButton btRefresh;
	private SnmpCloseButton btClose;

	public OltVlanBatchConfigScalarsPanel(IApplication app) {
		super(app);
		setModel(new OltVlanBatchConfigScalars(app.getSnmpProxy()));
		init();
	}

	public void initGui() {

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID,
				"Modify_OltVlanBatchConfigScalars");
//		btRefresh = new SnmpRefreshButton(fApplication, this);
		btClose = new SnmpCloseButton( fApplication, this );
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
//		buttonsPanel.add(btRefresh);
		buttonsPanel.add(btClose);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 2, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsOltVlanBatchConfigStart));
		tfUtsOltVlanBatchConfigStart.setName(fStringMap
				.getString("utsOltVlanBatchConfigStart"));
		baseInfoPanel.add(tfUtsOltVlanBatchConfigStart);

		baseInfoPanel.add(new JLabel(utsOltVlanBatchConfigStop));
		tfUtsOltVlanBatchConfigStop.setName(fStringMap
				.getString("utsOltVlanBatchConfigStop"));
		baseInfoPanel.add(tfUtsOltVlanBatchConfigStop);

		baseInfoPanel.add(new JLabel(utsOltVlanBatchConfigVlanName));
		tfUtsOltVlanBatchConfigVlanName.setName(fStringMap
				.getString("utsOltVlanBatchConfigVlanName"));
		baseInfoPanel.add(tfUtsOltVlanBatchConfigVlanName);

		
		//TODO..
		JPanel baseInfoPanel2 = new JPanel();
        NTLayout layout2 = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout2.setMargins(6, 10, 6, 10);
        baseInfoPanel2.setLayout(layout2);
        baseInfoPanel2.setBorder(BorderFactory.createEtchedBorder());

        Vector columnNames = new Vector();
        Vector rowData = new Vector();

        columnNames.add(fStringMap.getString("Port ID"));
        columnNames.add(fStringMap.getString("utsOltVlanBatchConfigTaggedPortListPorts"));
        columnNames.add(fStringMap.getString("utsOltVlanBatchConfigUnTaggedPortListPorts"));
//        columnNames.add(fStringMap.getString("utsLagExtDot1qVlanPortVidListPorts"));

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
//                            if (!tagged && !untagged) {
//                                model.setValueAt(Boolean.FALSE, rowIdx, 3);
//                            }
                        }
                        if (colIdx == 2) {
                            if (untagged)
                                model.setValueAt(Boolean.FALSE, rowIdx, 1);
//                            if (!tagged && !untagged) {
//                                model.setValueAt(Boolean.FALSE, rowIdx, 3);
//                            }
                        }
                        break;
                }
            }
        });

        JScrollPane tmpScrollPane = new JScrollPane(portSelectionTbl);
        baseInfoPanel2.add(tmpScrollPane);
        
        baseInfoPanel.add(new JLabel(utsOltVlanBatchConfigPortListPorts));
        baseInfoPanel.add(baseInfoPanel2);
        
        //TODO...

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

		add(buttonsPanel, BorderLayout.SOUTH);

	}

	protected void initForm() {
		tfUtsOltVlanBatchConfigStart.setValueScope(1, 4094);

		tfUtsOltVlanBatchConfigStop.setValueScope(1, 4094);

		tfUtsOltVlanBatchConfigVlanName.setLenScope(0, 16);

	}
	
	public boolean validateFrom() {
		if(tfUtsOltVlanBatchConfigStart.getValue() > tfUtsOltVlanBatchConfigStop.getValue()) {
			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_VlanBatch_Config"));
    		return false;
		}
		int row = fTable.getModel().getRowCount();
		for(int i = 0; i < row; i++) {
			int tvlanId = (Integer)fTable.getValueAt(i, 0);
			if(tfUtsOltVlanBatchConfigStart.getValue() <= tvlanId && tfUtsOltVlanBatchConfigStop.getValue() >= tvlanId){
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_VlanBatch_VlanIdConfig"));
	    		return false;
			}
		}
		return true;
	}

	public void refresh() {

		OltVlanBatchConfigScalars mbean = (OltVlanBatchConfigScalars) getModel();
		BeanService.refreshBean(fApplication, mbean);

		if (mbean.getUtsOltVlanBatchConfigStart() != null)
			tfUtsOltVlanBatchConfigStart.setValue(mbean
					.getUtsOltVlanBatchConfigStart().intValue());
		if (mbean.getUtsOltVlanBatchConfigStop() != null)
			tfUtsOltVlanBatchConfigStop.setValue(mbean
					.getUtsOltVlanBatchConfigStop().intValue());
		if (mbean.getUtsOltVlanBatchConfigVlanName() != null)
			tfUtsOltVlanBatchConfigVlanName.setValue(mbean
					.getUtsOltVlanBatchConfigVlanName());
//		if (mbean.getUtsOltVlanBatchConfigTaggedPortListPorts() != null)
//			tfUtsOltVlanBatchConfigTaggedPortListPorts.setValue(mbean
//					.getUtsOltVlanBatchConfigTaggedPortListPorts());
//		if (mbean.getUtsOltVlanBatchConfigUnTaggedPortListPorts() != null)
//			tfUtsOltVlanBatchConfigUnTaggedPortListPorts.setValue(mbean
//					.getUtsOltVlanBatchConfigUnTaggedPortListPorts());
//		if (mbean.getUtsOltVlanBacthConfigIgmpSnoop() != null)
//			tfUtsOltVlanBacthConfigIgmpSnoop
//					.setSelectedIndex(getIndexFromValue(
//							utsOltVlanBacthConfigIgmpSnoopVList, mbean
//									.getUtsOltVlanBacthConfigIgmpSnoop()
//									.intValue()));
//		if (mbean.getUtsOltVlanBacthConfigPPPoEPlus() != null)
//			tfUtsOltVlanBacthConfigPPPoEPlus
//					.setSelectedIndex(getIndexFromValue(
//							utsOltVlanBacthConfigPPPoEPlusVList, mbean
//									.getUtsOltVlanBacthConfigPPPoEPlus()
//									.intValue()));
//		if (mbean.getUtsOltVlanBatchConfigL2DHCPOption82() != null)
//			tfUtsOltVlanBatchConfigL2DHCPOption82
//					.setSelectedIndex(getIndexFromValue(
//							utsOltVlanBatchConfigL2DHCPOption82VList, mbean
//									.getUtsOltVlanBatchConfigL2DHCPOption82()
//									.intValue()));
//		if (mbean.getUtsOltVlanBatchConfigArpProxySwitch() != null)
//			tfUtsOltVlanBatchConfigArpProxySwitch
//					.setSelectedIndex(getIndexFromValue(
//							utsOltVlanBatchConfigArpProxySwitchVList, mbean
//									.getUtsOltVlanBatchConfigArpProxySwitch()
//									.intValue()));
		
		try {
			portSelectionTblModel.getDataVector().clear();
			Vector portList = getPortList();
			for (int i = 0; i < portList.size(); i++) {
				Vector tmpVector = new Vector();
				tmpVector.add(portList.elementAt(i));
				tmpVector.add(Boolean.FALSE);
				tmpVector.add(Boolean.FALSE);
//				tmpVector.add(Boolean.FALSE);
				portSelectionTblModel.addRow(tmpVector);
			}
		}
		catch(Exception e){
			
		}


	}

	public void updateModel() {

		OltVlanBatchConfigScalars mbean = (OltVlanBatchConfigScalars) getModel();

		mbean.setUtsOltVlanBatchConfigStart(new Integer(
				tfUtsOltVlanBatchConfigStart.getValue()));
		mbean.setUtsOltVlanBatchConfigStop(new Integer(
				tfUtsOltVlanBatchConfigStop.getValue()));
		mbean.setUtsOltVlanBatchConfigVlanName(new String(
				tfUtsOltVlanBatchConfigVlanName.getValue()));
//		mbean.setUtsOltVlanBatchConfigTaggedPortListPorts(new String(
//				tfUtsOltVlanBatchConfigTaggedPortListPorts.getValue()));
//		mbean.setUtsOltVlanBatchConfigUnTaggedPortListPorts(new String(
//				tfUtsOltVlanBatchConfigUnTaggedPortListPorts.getValue()));
//		mbean
//				.setUtsOltVlanBacthConfigIgmpSnoop(new Integer(
//						utsOltVlanBacthConfigIgmpSnoopVList[tfUtsOltVlanBacthConfigIgmpSnoop
//								.getSelectedIndex()]));
//		mbean
//				.setUtsOltVlanBacthConfigPPPoEPlus(new Integer(
//						utsOltVlanBacthConfigPPPoEPlusVList[tfUtsOltVlanBacthConfigPPPoEPlus
//								.getSelectedIndex()]));
//		mbean
//				.setUtsOltVlanBatchConfigL2DHCPOption82(new Integer(
//						utsOltVlanBatchConfigL2DHCPOption82VList[tfUtsOltVlanBatchConfigL2DHCPOption82
//								.getSelectedIndex()]));
//		mbean
//				.setUtsOltVlanBatchConfigArpProxySwitch(new Integer(
//						utsOltVlanBatchConfigArpProxySwitchVList[tfUtsOltVlanBatchConfigArpProxySwitch
//								.getSelectedIndex()]));
		
		byte[] taggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(1));
        byte[] untaggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(2));
        mbean.setUtsOltVlanBatchConfigTaggedPortListPorts(taggedPorts);
        mbean.setUtsOltVlanBatchConfigUnTaggedPortListPorts(untaggedPorts);

	}
	
//	public void setTable(SnmpTable aTable) {
//		super.setTable(aTable);
//        fTable = aTable;
//        fTable.clearSelection();
//        ((SnmpAction)btApply.getAction()).setTable(aTable);
//    }
	
	public void afterUpdateModel() {
		if(fTable!=null) {
        	RefreshTableCommand cmd = new RefreshTableCommand(fApplication, fTable);
        	cmd.execute();
        }
    }
	
	private Vector getPortList() throws Exception {
        Vector allPortList = new Vector();
        BBS4000CardMibBean cardMBean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, cardMBean);
        ModuleType moduleType = new ModuleType();
        for (int i = 0; i < v.size(); i++) {
            int moduleBoardPhyId = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId();
            int moduleBoardType = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardType();
            int modulePhyPreStat = ((BBS4000CardMibBean) v.get(i)).getUtsEponModulePhyPresenceStat();
            int moduleAdminState = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleAdminState();
            if ((moduleType.isGEMModule(moduleBoardType) || moduleType.isEPMModule(moduleBoardType)) && modulePhyPreStat == 1 && moduleAdminState == 2) {
                for (int j = 1; j <= 4; j++) {
                    allPortList.add(moduleBoardPhyId + "/" + j);
                }
            } else if ((moduleType.isXGMModule(moduleBoardType)) && modulePhyPreStat == 1 && moduleAdminState == 2) {
                allPortList.add(moduleBoardPhyId + "/1");
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

        for (int i = 0; i < lgVec.size(); i++) {
            LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(i);
            String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());
            for (int j = 0; j < array.length; j++) {
                allPortList.remove(array[j]);
            }
        }

        return allPortList;
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
	
	private class CustomTblModel extends DefaultTableModel {

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

//                Boolean pvid = (Boolean) getValueAt(row, 3);
//                if (!pvid && portVidSet.contains(portName)) {
//                    return false;
//                }
            }

            return true;
        }

    }

}

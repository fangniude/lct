package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.OltHandToHandConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class OltHandToHandConfigTablePanel extends UPanel {

//	private IntegerTextField tfUtsOltHandToHandConfigModuleId = new IntegerTextField();
	private JComboBox tfUtsOltHandToHandConfigModuleId = new JComboBox();

	private final String utsOltHandToHandConfigModuleId = fStringMap
			.getString("utsOltHandToHandConfigModuleId")
			+ " : ";
	
//	private IntegerTextField tfUtsOltHandToHandConfigPortId = new IntegerTextField();
	private JComboBox tfUtsOltHandToHandConfigPortId = new JComboBox();
	
	private final String utsOltHandToHandConfigPortId = fStringMap
			.getString("utsOltHandToHandConfigPortId")
			+ " : ";
	
	private final String utsOltHandToHandConfigUplinkPorts = fStringMap
			.getString("utsOltHandToHandConfigUplinkPorts");

	private JTable portSelectionTable = null;
	private PortSelTableModel portSelTabelModel = null;
	private Set portSelectedList = null;
	
	private ArrayList ifList = new ArrayList();

	public OltHandToHandConfigTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel mainInfoPanel = new JPanel();
		NTLayout layout1 = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout1.setMargins(6, 10, 6, 10);
		mainInfoPanel.setLayout(layout1);
		mainInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsOltHandToHandConfigModuleId));
		baseInfoPanel.add(tfUtsOltHandToHandConfigModuleId);
		tfUtsOltHandToHandConfigModuleId.setName("utsOltHandToHandConfigModuleId");
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsOltHandToHandConfigPortId));
		baseInfoPanel.add(tfUtsOltHandToHandConfigPortId);
		tfUtsOltHandToHandConfigPortId.setName("utsOltHandToHandConfigPortId");
		baseInfoPanel.add(new HSpacer());

		JPanel portSelPanel = new JPanel();
		NTLayout layout2 = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout2.setMargins(6, 10, 6, 10);
		portSelPanel.setLayout(layout2);
		portSelPanel.setBorder(BorderFactory.createEtchedBorder());

		Vector columnNames = new Vector();
		Vector rowData = new Vector();

		columnNames.add(fStringMap.getString("Port ID"));
		columnNames.add(utsOltHandToHandConfigUplinkPorts);
		portSelTabelModel = new PortSelTableModel(rowData, columnNames);
		portSelectionTable = new JTable(portSelTabelModel);

		JScrollPane tmpScrollPane = new JScrollPane(portSelectionTable);
		portSelPanel.add(tmpScrollPane);

		mainInfoPanel.add(baseInfoPanel);
		mainInfoPanel.add(portSelPanel);

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(mainInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

	}

	protected void initForm() {

	}
	
	private void refreshData() {
	    ifList.clear();

	    try {
	      BBS4000CardMibBean cardMBean = new BBS4000CardMibBean(fApplication.getSnmpProxy());

	      Vector v = BeanService.refreshTableBean(fApplication, cardMBean);

	      ModuleType moduleType = new ModuleType();
	      for (int i = 0; i < v.size(); i++) {
	        int moduleBoardPhyId = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId().intValue();
	        int moduleBoardType = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardType().intValue();
	        int modulePhyPreStat = ((BBS4000CardMibBean) v.get(i)).getUtsEponModulePhyPresenceStat().intValue();
	        int moduleAdminState = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleAdminState().intValue();
//	        if ((moduleType.isGEMModule(moduleBoardType) || moduleType.isEPMModule(moduleBoardType))
//	            && modulePhyPreStat == 1 && moduleAdminState == 2) {
//	          for (int j = 1; j <= 4; j++) {
	            ifList.add(moduleBoardPhyId);
//	          }
//	        } 
//	        else if ((moduleType.isXGMModule(moduleBoardType))
//	            && modulePhyPreStat == 1 && moduleAdminState == 2) {
//	            ifList.add(moduleBoardPhyId);
//	        }
	      }

	      // remove L2 port that in Link Aggregation set
//	      LinkAggregation lgMBean = new LinkAggregation(fApplication.getSnmpProxy());
//	      Vector lgVec = BeanService.refreshTableBean(fApplication, lgMBean);
//	      if (lgVec == null) lgVec = new Vector(0);

//	      for (int i = 0; i < lgVec.size(); i++) {
//	        LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(i);
//
//	        Integer lgGroupId = tmpLGMBean.getUtsLagExtDot3adAggGroupId();
//	        ifList.add("lg" + lgGroupId);
//
//	        String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());
//
//	        for (int j = 0; j < array.length; j++) {
//	          ifList.remove(array[j]);
//	        }
//	      }

	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }

	public void refresh() {
		refreshData();

		tfUtsOltHandToHandConfigModuleId.removeAllItems();
		tfUtsOltHandToHandConfigPortId.removeAllItems();
		
		for(int i = 0; i < ifList.size(); i++)
	    {
			tfUtsOltHandToHandConfigModuleId.addItem(ifList.get(i));
	    }

	    for(int i = 1; i < 5; i++)
	    {
	    	tfUtsOltHandToHandConfigPortId.addItem(i);
	    }
	    
		if (SnmpAction.IType.ADD.equals(fCommand)) {
			tfUtsOltHandToHandConfigModuleId.setEnabled(true);
			tfUtsOltHandToHandConfigPortId.setEnabled(true);
			
			portSelTabelModel.getDataVector().clear();
			Vector<Object> portList = getPortList();
			for (int i = 0; i < portList.size(); i++) {
				Vector tmpVector = new Vector();
				tmpVector.add(portList.elementAt(i));
				tmpVector.add(Boolean.FALSE);
				portSelTabelModel.addRow(tmpVector);
			}

			return;
		}
		
		OltHandToHandConfigTable mbean = (OltHandToHandConfigTable) getModel();
		try {
			mbean.retrieve();
		}
		catch(Exception e){}
	
		
		tfUtsOltHandToHandConfigModuleId.setSelectedItem(mbean.getUtsOltHandToHandConfigModuleId());
		tfUtsOltHandToHandConfigPortId.setSelectedItem(mbean.getUtsOltHandToHandConfigPortId());
		
		tfUtsOltHandToHandConfigModuleId.setEnabled(false);
		tfUtsOltHandToHandConfigPortId.setEnabled(false);

		portSelTabelModel.getDataVector().clear(); // clear original data
		if(portSelectedList!= null) portSelectedList.clear();
		portSelectedList = parsePortListString(mbean.getUtsOltHandToHandConfigUplinkPorts());

		Vector portList = getPortList();
		for (int i = 0; i < portList.size(); i++) {
			Vector<Object> tmpVector = new Vector<Object>();
			String portName = (String) portList.elementAt(i);
			tmpVector.add(portName);
			tmpVector.add(portSelectedList.contains(portName));
			portSelTabelModel.addRow(tmpVector);
		}
	}

	public void updateModel() {

		if (SnmpAction.IType.ADD.equals(fCommand)) {
			setModel(new OltHandToHandConfigTable(fApplication.getSnmpProxy()));
		}
		
		OltHandToHandConfigTable mbean = (OltHandToHandConfigTable) getModel();
		
		if (SnmpAction.IType.ADD.equals(fCommand)) {
			mbean.setUtsOltHandToHandConfigModuleId((Integer)tfUtsOltHandToHandConfigModuleId.getSelectedItem());
			mbean.setUtsOltHandToHandConfigPortId((Integer)tfUtsOltHandToHandConfigPortId.getSelectedItem());
			
			byte[] uplinkPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(1));
			mbean.setUtsOltHandToHandConfigUplinkPorts(uplinkPorts);
		}
		else {
			byte[] uplinkPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(1));
			mbean.setUtsOltHandToHandConfigUplinkPorts(uplinkPorts);
		}

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
	
	protected Set parsePortListString(byte[] b) {
		Set portListSet = new HashSet();
		if(b == null) return portListSet;
        String[] portList = ConfigUtility.portMappingToStringArray(b);
        for (int i = 0; i < portList.length; i++) {
            portListSet.add(portList[i]);
        }

        return portListSet;
    }

	private Vector getPortList() {
		Vector allPortList = new Vector();
        BBS4000CardMibBean cardMBean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, cardMBean);
        ModuleType moduleType = new ModuleType();
        for (int i = 0; i < v.size(); i++) {
            int moduleBoardPhyId = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId();
            int moduleBoardType = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardType();
            int modulePhyPreStat = ((BBS4000CardMibBean) v.get(i)).getUtsEponModulePhyPresenceStat();
            int moduleAdminState = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleAdminState();
            if ((moduleType.isGEMModule(moduleBoardType)) && modulePhyPreStat == 1 && moduleAdminState == 2) {
                for (int j = 1; j <= 4; j++) {
                    allPortList.add(moduleBoardPhyId + "/" + j);
                }
            }
        }

		try {
			EthIfExtTable portMBean = new EthIfExtTable(fApplication
					.getSnmpProxy());
			Vector portVec = portMBean.retrieveRealAll();
			// remove layer-3 ports and add vlan IDs
			for (int i = 0; i < portVec.size(); i++) {
				EthIfExtTable tmpL2PortTbl = (EthIfExtTable) portVec
						.elementAt(i);
				String portName = tmpL2PortTbl.getUtsEthIfExtModuleId() + "/"
						+ tmpL2PortTbl.getUtsEthIfExtPortId();
				int tmpPortType = tmpL2PortTbl.getUtsEthIfExtPortType();
				int switchMode = tmpL2PortTbl.getUtsEthIfExtSwitchMode();
				if (tmpPortType == 1) {
					// remove layer-3 ports
					if (switchMode == 2) {
						allPortList.remove(portName);
					}
				} else if (tmpPortType == 2 && switchMode == 1) { // lg and lay
																	// 2.
					allPortList.add("lg"
							+ tmpL2PortTbl.getUtsEthIfExtLinkAggGroupId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
        for (int i = 0; i < portSelTabelModel.getRowCount(); i++) {
            String portName = (String) portSelTabelModel.getValueAt(i, 0);
            Boolean bValue = (Boolean) portSelTabelModel.getValueAt(i, colIdx);
            if (bValue) {
                list.add(portName);
            }
        }

        return (String[]) list.toArray(new String[0]);
    }

	private class PortSelTableModel extends DefaultTableModel {

		private boolean bGlobalEditable = true;

		public void setBGlobalEditable(boolean editable) {
			bGlobalEditable = editable;
		}

		public PortSelTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		public PortSelTableModel(Vector rowData, Vector columnNames) {
			super(rowData, columnNames);
		}

		public Class getColumnClass(int col) {
			Vector v = (Vector) dataVector.elementAt(0);
			return v.elementAt(col).getClass();
		}

		public boolean isCellEditable(int row, int col) {
			if (!bGlobalEditable)
				return false;

			if (col == 0) {
				return false;
			}

			return true;
		}

	}

}

package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Olt2PonProtectionMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class PONProtectionMBeanPanel extends UPanel {

	private JComboBox tfUtsPonTrunckProtectionGroupId = new JComboBox();
	
//    private StringTextField tfUtsPonTrunckProtectionName = new StringTextField();
    
    private JComboBox tfUtsPonTrunckProtectionPort1Interface = new JComboBox();
    private JComboBox tfUtsPonTrunckProtectionPort2Interface = new JComboBox();

//    private int[] utsPonTrunckProtectionModeVList = new int[]{1, 2, 3, 4,};
    private int[] utsPonTrunckProtectionModeVList = new int[]{2, 3, 4, 5,};
    private String[] utsPonTrunckProtectionModeTList = new String[]{
//            fStringMap.getString("typeA"),
            fStringMap.getString("typeB-interModule"),
            fStringMap.getString("typeC"),
            fStringMap.getString("typeD"),
            fStringMap.getString("typeB-intraModule"),
    };
    private JComboBox tfUtsPonTrunckProtectionMode = new JComboBox(utsPonTrunckProtectionModeTList);
    
    private Vector groupList = new Vector();

    private final String utsPonTrunckProtectionGroupId = fStringMap.getString("utsPonTrunckProtectionGroupId") + ": ";
    private final String utsPonTrunckProtectionName = fStringMap.getString("utsPonTrunckProtectionName") + ": ";
    private final String utsPonTrunckProtectionPort1Interface = fStringMap.getString("utsPonTrunckProtectionPort1Interface") + ": ";
    private final String utsPonTrunckProtectionPort2Interface = fStringMap.getString("utsPonTrunckProtectionPort2Interface") + ": ";
    private final String utsPonTrunckProtectionMode = fStringMap.getString("utsPonTrunckProtectionMode") + ": ";

    public PONProtectionMBeanPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionGroupId));
        tfUtsPonTrunckProtectionGroupId.setName(fStringMap.getString("utsPonTrunckProtectionGroupId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionGroupId);
        baseInfoPanel.add(new HSpacer());
        
//        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionName));
//        tfUtsPonTrunckProtectionName.setName(fStringMap.getString("utsPonTrunckProtectionName"));
//        baseInfoPanel.add(tfUtsPonTrunckProtectionName);
//        baseInfoPanel.add(new HSpacer());
        
		baseInfoPanel.add(new JLabel(utsPonTrunckProtectionPort1Interface));
		baseInfoPanel.add(tfUtsPonTrunckProtectionPort1Interface);
		tfUtsPonTrunckProtectionPort1Interface
				.setName("utsPonTrunckProtectionPort1Interface");
		baseInfoPanel.add(new HSpacer());
		tfUtsPonTrunckProtectionPort1Interface.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(e.getSource()==utsPonTrunckProtectionMode
        				||utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()] == 5)
        			changeByUtsPonTrunckProtectionMode();
        	}
        });

		baseInfoPanel.add(new JLabel(utsPonTrunckProtectionPort2Interface));
		tfUtsPonTrunckProtectionPort2Interface.setName(fStringMap
				.getString("utsPonTrunckProtectionPort2Interface"));
		baseInfoPanel.add(tfUtsPonTrunckProtectionPort2Interface);
		baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionMode));
        tfUtsPonTrunckProtectionMode.setName(fStringMap.getString("utsPonTrunckProtectionMode"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionMode);
        baseInfoPanel.add(new HSpacer());
        tfUtsPonTrunckProtectionMode.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		changeByUtsPonTrunckProtectionMode();
        	}
        });

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
//    	tfUtsPonTrunckProtectionName.setLenScope(0, 16);
    }
    
    public boolean validateFrom() {
    	String port1 = (String)tfUtsPonTrunckProtectionPort1Interface.getSelectedItem();
    	String port2 = (String)tfUtsPonTrunckProtectionPort2Interface.getSelectedItem();
    	
    	String[] split1 = tfUtsPonTrunckProtectionPort1Interface.getSelectedItem().toString().split("/");
    	String[] split2 = tfUtsPonTrunckProtectionPort2Interface.getSelectedItem().toString().split("/");
    	
    	if (utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()] == 5) {
			if (split1[0].equals(split2[0])) {
				if (Integer.parseInt(split1[1]) - Integer.parseInt(split2[1]) != 1 && Integer.parseInt(split2[1]) - Integer.parseInt(split1[1]) != 1) {
					MessageDialog .showErrorMessageDialog( fApplication, fStringMap .getString("Err_PonTrunkProtection_PortID"));
					return false;
				}
			}
			else{
				MessageDialog .showErrorMessageDialog( fApplication, fStringMap .getString("Err_PonTrunkProtection_PortID"));
				return false;
			}
		}
    	
    	if(port1.equals(port2)) {
    		MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_PonTrunkProtection_Port"));
    		return false;
    	}
    	if(utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()] == 2) {
    		if(split1[0].equals(split2[0])) {
    			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_PonTrunkProtection_Module"));
    			return false;
    		}
    	}
		if(SnmpAction.IType.MODIFY.equals(fCommand)) {
    		Dot3Olt2PonProtectionMBean mbean = (Dot3Olt2PonProtectionMBean) getModel();
    		if ((utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()] == 5) &&
    				(utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()] != mbean.getUtsPonTrunckProtectionMode())) {
    			MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_PonTrunkProtection_TypeB"));
    			return false;
    		}
		}

		SnmpTableModel model = (SnmpTableModel) fTable.getModel();
		for(Object temp : model.getDataVector()){
			Dot3Olt2PonProtectionMBean bean = (Dot3Olt2PonProtectionMBean) temp;
			if(!tfUtsPonTrunckProtectionGroupId.getSelectedItem().equals(bean.getUtsPonTrunckProtectionGroupId()) &&
					(port1.equals(bean.getUtsPonTrunckProtectionPort1Interface())
					|| port1.equals(bean.getUtsPonTrunckProtectionPort2Interface())
					|| port2.equals(bean.getUtsPonTrunckProtectionPort1Interface())
					|| port2.equals(bean.getUtsPonTrunckProtectionPort2Interface()))){
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_PonTrunkProtection_Duplicate"));
				return false;
			}
		}
		
		Integer groupId = (Integer)tfUtsPonTrunckProtectionGroupId.getSelectedItem();

		for(int i = 0; i < fTable.getRowCount(); i++) {
			Integer tgroup = (Integer)fTable.getValueAt(i, 0);
			if(groupId.intValue() == tgroup.intValue()) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_TrunckProtectionGroup_Duplicate"));
				return false;
			}
		}
		
    	return true;
    }
    
    public void refresh() {
    	tfUtsPonTrunckProtectionGroupId.removeAllItems();
    	//changeByUtsPonTrunckProtectionMode();
    	
    	for(int i = 1; i < 23; i++) {
    		tfUtsPonTrunckProtectionGroupId.addItem(new Integer(i));
    	}
    	
    	tfUtsPonTrunckProtectionPort1Interface.removeAllItems();
		tfUtsPonTrunckProtectionPort2Interface.removeAllItems();

		/*tfUtsPonTrunckProtectionGroupId.setEnabled(true);
		tfUtsPonTrunckProtectionPort1Interface.setEnabled(true);
		tfUtsPonTrunckProtectionPort2Interface.setEnabled(true);
		tfUtsPonTrunckProtectionMode.setEnabled(true);*/
		
        BBS4000CardMibBean cardMBean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector cardList = BeanService.refreshTableBean(fApplication, cardMBean);
        ModuleType moduleType = new ModuleType();

        for(int i = 0; cardList!=null && i < cardList.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) cardList.get(i);
            if(moduleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                for(int j = 1; j <= 4; j++) {
                	tfUtsPonTrunckProtectionPort1Interface.addItem(card.getUtsEponModuleBoardPhyId() + "/" + j);
                	tfUtsPonTrunckProtectionPort2Interface.addItem(card.getUtsEponModuleBoardPhyId() + "/" + j);
                }
            }
        }

        Dot3Olt2PonProtectionMBean allMbean = new Dot3Olt2PonProtectionMBean(fApplication.getSnmpProxy());

        groupList.removeAllElements();
        groupList = BeanService.refreshTableBean(fApplication, allMbean);
        for(int i = 0; i < groupList.size(); i++) {
        	tfUtsPonTrunckProtectionGroupId.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionGroupId());
        	tfUtsPonTrunckProtectionPort1Interface.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionPort1Interface());
        	tfUtsPonTrunckProtectionPort1Interface.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionPort2Interface());
        	tfUtsPonTrunckProtectionPort2Interface.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionPort1Interface());
        	tfUtsPonTrunckProtectionPort2Interface.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionPort2Interface());
        }
        
    	if(SnmpAction.IType.MODIFY.equals(fCommand)) {
    		Dot3Olt2PonProtectionMBean mbean = (Dot3Olt2PonProtectionMBean) getModel();
    		tfUtsPonTrunckProtectionGroupId.addItem(mbean.getUtsPonTrunckProtectionGroupId());
    		tfUtsPonTrunckProtectionPort1Interface.addItem(mbean.getUtsPonTrunckProtectionPort1Interface());
    		tfUtsPonTrunckProtectionPort2Interface.addItem(mbean.getUtsPonTrunckProtectionPort2Interface());
    		tfUtsPonTrunckProtectionMode.setSelectedIndex(mbean.getUtsPonTrunckProtectionMode()- 2);
    		tfUtsPonTrunckProtectionGroupId.setSelectedItem(mbean.getUtsPonTrunckProtectionGroupId());
    		tfUtsPonTrunckProtectionPort1Interface.setSelectedItem(mbean.getUtsPonTrunckProtectionPort1Interface());
    		tfUtsPonTrunckProtectionPort2Interface.setSelectedItem(mbean.getUtsPonTrunckProtectionPort2Interface());
    		
    		tfUtsPonTrunckProtectionPort1Interface.setEnabled(false);
    		tfUtsPonTrunckProtectionPort2Interface.setEnabled(false);
    		tfUtsPonTrunckProtectionGroupId.setEnabled(false);
    		if (utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()] == 5) {
    			tfUtsPonTrunckProtectionMode.setEnabled(false);
    		}
        }
    	else {
    		if(cardList!=null && cardList.size()!= 0) tfUtsPonTrunckProtectionPort1Interface.setSelectedIndex(0);
    		if(cardList!=null && cardList.size()!= 0)  tfUtsPonTrunckProtectionPort2Interface.setSelectedIndex(1);
    	}

    }

    public void updateModel() {
    	if (SnmpAction.IType.ADD.equals(fCommand)) {
			setModel(new Dot3Olt2PonProtectionMBean(fApplication.getSnmpProxy()));
		}
    	
    	Dot3Olt2PonProtectionMBean mbean = (Dot3Olt2PonProtectionMBean) getModel();
    	
    	if (SnmpAction.IType.ADD.equals(fCommand)) {
    		mbean.setUtsPonTrunckProtectionGroupId((Integer)tfUtsPonTrunckProtectionGroupId.getSelectedItem());
//    		mbean.setUtsPonTrunckProtectionName(tfUtsPonTrunckProtectionName.getText());
    		mbean.setUtsPonTrunckProtectionPort1Interface((String)tfUtsPonTrunckProtectionPort1Interface.getSelectedItem());
    		mbean.setUtsPonTrunckProtectionPort2Interface((String)tfUtsPonTrunckProtectionPort2Interface.getSelectedItem());    		
            mbean.setUtsPonTrunckProtectionMode(utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()]);

		}
		else {
//			mbean.setUtsPonTrunckProtectionName(tfUtsPonTrunckProtectionName.getText());
			mbean.setUtsPonTrunckProtectionPort1Interface((String)tfUtsPonTrunckProtectionPort1Interface.getSelectedItem());
    		mbean.setUtsPonTrunckProtectionPort2Interface((String)tfUtsPonTrunckProtectionPort2Interface.getSelectedItem());		
            mbean.setUtsPonTrunckProtectionMode(utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()]);
		}
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }
    
    
	public void changeByUtsPonTrunckProtectionMode() {	
		/**
		����ܽ�����һ���û�ѡ����inner type b��
		1.	Port1ModuleId��Port2ModuleId����һ���û�����һ��Module ID�����ˡ�
		2.	Port1PortId��Port2PortIdֻ�����������ѡ��1��2����������3��4��������
		3.	Group ID��ʱ�������ֹ����룬��һ�¹�����ɣ�
		1/1-1/2  -------- 23
		1/3-1/4  -------- 24
		2/1-2/2 --------- 25
		.....
		6/1-6/2--------- 33
		....
		12/1-12/2 ------- 45
		12/3-12/4  -------46
		 */
		if (utsPonTrunckProtectionModeVList[tfUtsPonTrunckProtectionMode.getSelectedIndex()] == 5) {
			tfUtsPonTrunckProtectionGroupId.removeAllItems();

			if (tfUtsPonTrunckProtectionPort1Interface.getSelectedItem() != null) {
				String[] split = tfUtsPonTrunckProtectionPort1Interface.getSelectedItem().toString().split("/");
				Integer portId = Integer.parseInt(split[1]);
				tfUtsPonTrunckProtectionGroupId.setEnabled(false);
				int groupId = Integer.parseInt(split[0]) * 2 + 21;
				if ((portId % 2) == 0) {
					tfUtsPonTrunckProtectionPort2Interface.setSelectedItem(split[0] + "/" + (portId - 1));
					tfUtsPonTrunckProtectionGroupId.addItem(portId > 2 ? groupId + 1 : groupId);
					tfUtsPonTrunckProtectionGroupId.setSelectedItem(portId > 2 ? groupId + 1 : groupId);
				} else {
					tfUtsPonTrunckProtectionPort2Interface.setSelectedItem(split[0] + "/" + (portId + 1));
					tfUtsPonTrunckProtectionGroupId.addItem(portId > 2 ? groupId + 1 : groupId);
					tfUtsPonTrunckProtectionGroupId.setSelectedItem(portId > 1 ? groupId + 1 : groupId);
				}
				tfUtsPonTrunckProtectionPort2Interface.setEnabled(false);
			}
		} 
		else {
			tfUtsPonTrunckProtectionGroupId.removeAllItems();
			for (int i = 1; i < 23; i++) {
				tfUtsPonTrunckProtectionGroupId.addItem(new Integer(i));
			}
			for(int i = 0; i < groupList.size(); i++) {
	        	tfUtsPonTrunckProtectionGroupId.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionGroupId());
	        	tfUtsPonTrunckProtectionPort1Interface.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionPort1Interface());
	        	tfUtsPonTrunckProtectionPort1Interface.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionPort2Interface());
	        	tfUtsPonTrunckProtectionPort2Interface.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionPort1Interface());
	        	tfUtsPonTrunckProtectionPort2Interface.removeItem(((Dot3Olt2PonProtectionMBean) groupList.get(i)).getUtsPonTrunckProtectionPort2Interface());
	        }
			if(fCommand!=null && !SnmpAction.IType.MODIFY.equals(fCommand)) {
				tfUtsPonTrunckProtectionGroupId.setEnabled(true);
				tfUtsPonTrunckProtectionPort2Interface.setEnabled(true);
			}
		}

	}
    

}
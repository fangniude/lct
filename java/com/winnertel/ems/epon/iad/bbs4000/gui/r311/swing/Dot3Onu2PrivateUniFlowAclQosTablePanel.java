package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.MultiItemSelector;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2PrivateRuleProfileTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2PrivateUniFlowAclQosTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

/**
 * The Dot3Onu2PrivateUniFlowAclQosTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2PrivateUniFlowAclQosTablePanel extends UPanel {

	private JComboBox tfUtsDot3Onu2Ctc3UniModuleId = new JComboBox();

//	private JLabel tfUtsDot3Onu2Ctc3UniDeviceId = new JLabel();

	private int[] utsDot3Onu2Ctc3UniPortIdVList = new int[]{
            1, 2, 3, 4, };
    private String[] utsDot3Onu2Ctc3UniPortIdTList = new String[]{
            "1", "2", "3", "4",
    };
    private JComboBox tfUtsDot3Onu2Ctc3UniPortId = new JComboBox(utsDot3Onu2Ctc3UniPortIdTList);

//    private int[] utsDot3Onu2Ctc3UniLogicalPortIdVList = new int[]{
//            1, 2, 3, 4, };
//    private String[] utsDot3Onu2Ctc3UniLogicalPortIdTList = new String[]{
//            "1", "2", "3", "4",
//    };
	private JComboBox tfUtsDot3Onu2Ctc3UniLogicalPortId = new JComboBox();

	private int[] utsDot3Onu2Ctc3UniPhyPortIdVList = new int[]{
            1, 2, 3, 4, };
    private String[] utsDot3Onu2Ctc3UniPhyPortIdTList = new String[]{
            "1", "2", "3", "4",
    };
    private JComboBox tfUtsDot3Onu2Ctc3UniPhyPortId = new JComboBox(utsDot3Onu2Ctc3UniPhyPortIdTList);

	private IntegerTextField tfUtsDot3Onu2PrivateUniFlowPolicyId = new IntegerTextField();

//	private IntegerTextField tfUtsDot3Onu2PrivateRuleId = new IntegerTextField();
	private JComboBox tfUtsDot3Onu2PrivateRuleId = new JComboBox();

//	private StringTextField tfUtsDot3Onu2PrivateActionBitmap = new StringTextField();
	private MultiItemSelector tfUtsDot3Onu2PrivateActionBitmap = new MultiItemSelector();
	protected Vector vActionBitmap = new Vector();

	private IntegerTextField tfUtsDot3Onu2PrivateActionBandwidth = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateActionVlanId = new IntegerTextField();
	
	private IntegerTextField tfUtsDot3Onu2PrivateActionPriority = new IntegerTextField();

	private final String utsDot3Onu2Ctc3UniModuleId = fStringMap
			.getString("utsDot3Onu2Ctc3UniModuleId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniDeviceId = fStringMap
			.getString("utsDot3Onu2Ctc3UniDeviceId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniLogicalPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniPhyPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPhyPortId")
			+ " : ";
	private final String utsDot3Onu2PrivateUniFlowPolicyId = fStringMap
			.getString("utsDot3Onu2PrivateUniFlowPolicyId")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleId = fStringMap
			.getString("utsDot3Onu2PrivateRuleId")
			+ " : ";
	private final String utsDot3Onu2PrivateActionBitmap = fStringMap
			.getString("utsDot3Onu2PrivateActionBitmap")
			+ " : ";
	private final String utsDot3Onu2PrivateActionBandwidth = fStringMap
			.getString("utsDot3Onu2PrivateActionBandwidth")
			+ " : ";
	private final String utsDot3Onu2PrivateActionVlanId = fStringMap
			.getString("utsDot3Onu2PrivateActionVlanId")
			+ " : ";
	private final String utsDot3Onu2PrivateActionPriority = fStringMap
			.getString("utsDot3Onu2PrivateActionPriority")
			+ " : ";
	
	private final String forward = fStringMap.getString("forward");
	private final String drop = fStringMap.getString("drop");
	private final String rateLimit = fStringMap.getString("rateLimit");
	private final String vlanAssignment = fStringMap.getString("vlanAssignment");
	private final String priorityMarking = fStringMap.getString("priorityMarking");

	public Dot3Onu2PrivateUniFlowAclQosTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPhyPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPhyPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniFlowPolicyId));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniFlowPolicyId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleId));
		tfUtsDot3Onu2PrivateRuleId.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleId"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateActionBitmap));
		tfUtsDot3Onu2PrivateActionBitmap.setName(fStringMap
				.getString("utsDot3Onu2PrivateActionBitmap"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateActionBitmap);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateActionBandwidth));
		tfUtsDot3Onu2PrivateActionBandwidth.setName(fStringMap
				.getString("utsDot3Onu2PrivateActionBandwidth"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateActionBandwidth);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateActionVlanId));
		tfUtsDot3Onu2PrivateActionVlanId.setName(fStringMap
				.getString("utsDot3Onu2PrivateActionVlanId"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateActionVlanId);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateActionPriority));
		tfUtsDot3Onu2PrivateActionPriority.setName(fStringMap
				.getString("utsDot3Onu2PrivateActionPriority"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateActionPriority);
		tfUtsDot3Onu2PrivateActionPriority.setEnabled(false);
		baseInfoPanel.add(new HSpacer());

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
		vActionBitmap.add(forward);
		vActionBitmap.add(drop);
		vActionBitmap.add(rateLimit);
		vActionBitmap.add(vlanAssignment);
		vActionBitmap.add(priorityMarking);
		
		tfUtsDot3Onu2PrivateUniFlowPolicyId.setValueScope(1, 8);
		
//		tfUtsDot3Onu2PrivateRuleId.setValueScope(1, 128);

		tfUtsDot3Onu2PrivateActionBandwidth.setValueScope(1, 16384);

		tfUtsDot3Onu2PrivateActionVlanId.setValueScope(1, 4094);
		
		tfUtsDot3Onu2PrivateActionPriority.setValueScope(0, 7);
		
		tfUtsDot3Onu2PrivateActionBitmap.addSelectListener(new ItemListener()  {
			public void itemStateChanged(ItemEvent e) {
				tfUtsDot3Onu2PrivateActionPriority.setEnabled(false);
				Vector selected = tfUtsDot3Onu2PrivateActionBitmap.getSelectedChoices();
				for(Object sel: selected){
					if(sel.equals(priorityMarking)) {
						tfUtsDot3Onu2PrivateActionPriority.setEnabled(true);
					}
				}
			}
			
		});


	}
	
	public boolean validateFrom() {
		Vector selected = tfUtsDot3Onu2PrivateActionBitmap.getSelectedChoices();
		byte[] bytes = StringArrayToActionMapping(selected);
		if ((bytes[0] & 0x02) == 0x02) {
			if (((bytes[0] & 0x01) == 0x01) || ((bytes[0] & 0x04) == 0x04)
					|| ((bytes[0] & 0x08) == 0x08) || ((bytes[0] & 0x10) ==0x10)) {
				MessageDialog.showInfoMessageDialog(fApplication, fStringMap
						.getString("utsDot3Onu2PrivateActionBitmap")
						+ fStringMap.getString("Err_Dot3Onu2PrivateActionBitmap_Value"));
				return false;
			}

		}

		return true;
	}

	public void refresh() {
		tfUtsDot3Onu2Ctc3UniModuleId.removeAllItems();
		
		ModuleType fModuleType = new ModuleType();
		BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication
				.getSnmpProxy());
		Vector list = BeanService.refreshTableBean(fApplication, bean);
		for (int i = 0; list != null && i < list.size(); i++) {
			BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
			if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
				tfUtsDot3Onu2Ctc3UniModuleId.addItem(card
						.getUtsEponModuleBoardPhyId());
			}
		}
		
		tfUtsDot3Onu2Ctc3UniLogicalPortId.removeAllItems();
        int split = new BBS4000NE(fApplication).getPonSplitRatio();
        for (int i = 1; i <= split; i++) {
        	tfUtsDot3Onu2Ctc3UniLogicalPortId.addItem("" + i);
        }
        
        tfUtsDot3Onu2PrivateRuleId.removeAllItems();
        Dot3Onu2PrivateRuleProfileTable pbean = new Dot3Onu2PrivateRuleProfileTable(fApplication.getSnmpProxy());
        Vector proflies = BeanService.refreshTableBean(fApplication, pbean);
		for (int i = 0; proflies!=null && i < proflies.size(); i++) {
			Dot3Onu2PrivateRuleProfileTable profile = (Dot3Onu2PrivateRuleProfileTable) proflies.get(i);
			tfUtsDot3Onu2PrivateRuleId.addItem(profile.getUtsDot3Onu2PrivateRuleIndex());
		}
		
		tfUtsDot3Onu2PrivateActionBitmap.setSelectionChoices(vActionBitmap);
		
		if (SnmpAction.IType.ADD.equals(fCommand)) {
			tfUtsDot3Onu2Ctc3UniModuleId.setEnabled(true);
			tfUtsDot3Onu2Ctc3UniPortId.setEnabled(true);
			tfUtsDot3Onu2Ctc3UniLogicalPortId.setEnabled(true);
			tfUtsDot3Onu2Ctc3UniPhyPortId.setEnabled(true);
			tfUtsDot3Onu2PrivateUniFlowPolicyId.setEnabled(true);
			return;
		}
		Dot3Onu2PrivateUniFlowAclQosTable mbean = (Dot3Onu2PrivateUniFlowAclQosTable) getModel();

		tfUtsDot3Onu2Ctc3UniModuleId.setSelectedItem(mbean
				.getUtsDot3Onu2Ctc3UniModuleId());
//		tfUtsDot3Onu2Ctc3UniDeviceId.setText(mbean
//				.getUtsDot3Onu2Ctc3UniDeviceId().toString());
		tfUtsDot3Onu2Ctc3UniPortId.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2Ctc3UniPortIdVList, mbean
						.getUtsDot3Onu2Ctc3UniPortId().intValue()));
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setSelectedItem(""
				+ mbean.getUtsDot3Onu2Ctc3UniLogicalPortId());
		tfUtsDot3Onu2Ctc3UniPhyPortId.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2Ctc3UniPhyPortIdVList, mbean
						.getUtsDot3Onu2Ctc3UniPhyPortId().intValue()));
		tfUtsDot3Onu2PrivateUniFlowPolicyId.setValue(mbean
				.getUtsDot3Onu2PrivateUniFlowPolicyId());
//		tfUtsDot3Onu2PrivateRuleId.setValue(mbean.getUtsDot3Onu2PrivateRuleId()
//				.intValue());
		tfUtsDot3Onu2PrivateRuleId.setSelectedItem(mbean
				.getUtsDot3Onu2PrivateRuleId());
//		tfUtsDot3Onu2PrivateActionBitmap.setValue(mbean
//				.getUtsDot3Onu2PrivateActionBitmap());
		
		Vector selected = actionBitMappingToStringArray(mbean
				.getUtsDot3Onu2PrivateActionBitmap());

		tfUtsDot3Onu2PrivateActionBitmap.setSelectedChoices(selected);
	      
		
		tfUtsDot3Onu2PrivateActionBandwidth.setValue(mbean
				.getUtsDot3Onu2PrivateActionBandwidth().intValue());
		tfUtsDot3Onu2PrivateActionVlanId.setValue(mbean
				.getUtsDot3Onu2PrivateActionVlanId().intValue());
		
		tfUtsDot3Onu2Ctc3UniModuleId.setEnabled(false);
		tfUtsDot3Onu2Ctc3UniPortId.setEnabled(false);
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setEnabled(false);
		tfUtsDot3Onu2Ctc3UniPhyPortId.setEnabled(false);
		tfUtsDot3Onu2PrivateUniFlowPolicyId.setEnabled(false);
		
		setPrivateActionPriorityStatus(mbean.getUtsDot3Onu2PrivateActionBitmap());

	}

	public void updateModel() {

		if (SnmpAction.IType.ADD.equals(fCommand))
			setModel(new Dot3Onu2PrivateUniFlowAclQosTable(fApplication
					.getSnmpProxy()));

		Dot3Onu2PrivateUniFlowAclQosTable mbean = (Dot3Onu2PrivateUniFlowAclQosTable) getModel();

		 if (SnmpAction.IType.ADD.equals(fCommand)) {
			 mbean.setUtsDot3Onu2Ctc3UniModuleId(new Integer(tfUtsDot3Onu2Ctc3UniModuleId.getSelectedItem().toString()));
				mbean.setUtsDot3Onu2Ctc3UniDeviceId(1);
				mbean.setUtsDot3Onu2Ctc3UniPortId(new Integer((String) tfUtsDot3Onu2Ctc3UniPortId.getSelectedItem()));
				mbean.setUtsDot3Onu2Ctc3UniLogicalPortId(new Integer((String) tfUtsDot3Onu2Ctc3UniLogicalPortId.getSelectedItem()));
				mbean.setUtsDot3Onu2Ctc3UniPhyPortId(new Integer((String) tfUtsDot3Onu2Ctc3UniPhyPortId.getSelectedItem()));
				mbean.setUtsDot3Onu2PrivateUniFlowPolicyId(new Integer(tfUtsDot3Onu2PrivateUniFlowPolicyId.getValue()));
		 }

		mbean.setUtsDot3Onu2PrivateRuleId(new Integer(
				tfUtsDot3Onu2PrivateRuleId.getSelectedItem().toString()));
		
		Vector selected = tfUtsDot3Onu2PrivateActionBitmap.getSelectedChoices();
	    mbean.setUtsDot3Onu2PrivateActionBitmap(StringArrayToActionMapping(selected));
	      
	      
		mbean.setUtsDot3Onu2PrivateActionBandwidth(new Integer(
				tfUtsDot3Onu2PrivateActionBandwidth.getValue()));
		mbean.setUtsDot3Onu2PrivateActionVlanId(new Integer(
				tfUtsDot3Onu2PrivateActionVlanId.getValue()));
		
		if(tfUtsDot3Onu2PrivateActionPriority.isEnabled()) {
			mbean.setUtsDot3Onu2PrivateActionPriority(tfUtsDot3Onu2PrivateActionPriority.getValue());
		}

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
	
	public Vector actionBitMappingToStringArray(byte[] bts) {
		Vector list = new Vector();

		for (int i = 0; bts!= null && i < bts.length; i++) {
			if ((bts[i] & 0x01) == 0x01) {
				list.add(forward);
			}
			if ((bts[i] & 0x02) == 0x02) {
				list.add(drop);
			}
			if ((bts[i] & 0x04) == 0x04) {
				list.add(rateLimit);
			}
			if ((bts[i] & 0x08) == 0x08) {
				list.add(vlanAssignment);
			}
			if ((bts[i] & 0x10) == 0x10) {
				list.add(priorityMarking);
			}

		}
		return list;
	}
	
	public byte[] StringArrayToActionMapping(Vector<String> selected) {
		byte[] bts = new byte[1];
		for(String sel: selected){
			if(sel.equals(forward)) {
				bts[0] = (byte)(bts[0] | 0x01);
			}
			if(sel.equals(drop)) {
				bts[0] = (byte)(bts[0] | 0x02);
			}
			if(sel.equals(rateLimit)) {
				bts[0] = (byte)(bts[0] | 0x04);
			}
			if(sel.equals(vlanAssignment)) {
				bts[0] = (byte)(bts[0] | 0x08);
			}
			if(sel.equals(priorityMarking)) {
				bts[0] = (byte)(bts[0] | 0x10);
			}
		}
		return bts;
	}
	
	public void setPrivateActionPriorityStatus(Vector<String> selected) {
		tfUtsDot3Onu2PrivateActionPriority.setEnabled(false);
		for(String sel: selected){
			if(sel.equals(priorityMarking)) {
				tfUtsDot3Onu2PrivateActionPriority.setEnabled(true);
			}
		}
	}
	
	public void setPrivateActionPriorityStatus(byte[] bts) {
		tfUtsDot3Onu2PrivateActionPriority.setEnabled(false);
		for (int i = 0; bts!= null && i < bts.length; i++) {
			if ((bts[i] & 0x10) == 0x10) {
				tfUtsDot3Onu2PrivateActionPriority.setEnabled(true);
			}
		}
	}

	

}

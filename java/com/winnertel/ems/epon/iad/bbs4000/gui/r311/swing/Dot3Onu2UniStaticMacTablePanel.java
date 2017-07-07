package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2UniStaticMacTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The Dot3Onu2UniStaticMacTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2UniStaticMacTablePanel extends UPanel {

	private JComboBox tfUtsDot3Onu2Ctc3UniModuleId = new JComboBox();

//	private JLabel tfUtsDot3Onu2Ctc3UniDeviceId = new JLabel();
	
	private int[] utsDot3Onu2Ctc3UniPortIdVList = new int[]{
            1, 2, 3, 4, };
    private String[] utsDot3Onu2Ctc3UniPortIdTList = new String[]{
            "1", "2", "3", "4",
    };

	private JComboBox tfUtsDot3Onu2Ctc3UniPortId = new JComboBox(utsDot3Onu2Ctc3UniPortIdTList);

	private JComboBox tfUtsDot3Onu2Ctc3UniLogicalPortId = new JComboBox();

//	private IntegerTextField tfUtsDot3Onu2Ctc3UniPhyPortId = new IntegerTextField();
	private int[] utsDot3Onu2Ctc3UniPhyPortIdVList = new int[]{
            1, 2, 3, 4, };
    private String[] utsDot3Onu2Ctc3UniPhyPortIdTList = new String[]{
            "1", "2", "3", "4",
    };
    private JComboBox tfUtsDot3Onu2Ctc3UniPhyPortId = new JComboBox(utsDot3Onu2Ctc3UniPhyPortIdTList);

	private MacAddressField tfUtsDot3Onu2UniStaticMacAddress = new MacAddressField(
			MacAddressField.UNICAST_TYPE);

//	private int[] utsDot3Onu2UniStaticMacRowStatusVList = new int[] { 1, 2, 5,
//			4, 3, 6, };
//	private String[] utsDot3Onu2UniStaticMacRowStatusTList = new String[] {
//			fStringMap.getString("active"),
//			fStringMap.getString("notInService"),
//			fStringMap.getString("createAndWait"),
//			fStringMap.getString("createAndGo"),
//			fStringMap.getString("notReady"), fStringMap.getString("destroy"), };
//	private JComboBox tfUtsDot3Onu2UniStaticMacRowStatus = new JComboBox(
//			utsDot3Onu2UniStaticMacRowStatusTList);

	private final String utsDot3Onu2Ctc3UniModuleId = fStringMap
			.getString("utsDot3Onu2Ctc3UniModuleId")
			+ " : ";
//	private final String utsDot3Onu2Ctc3UniDeviceId = fStringMap
//			.getString("utsDot3Onu2Ctc3UniDeviceId")
//			+ " : ";
	private final String utsDot3Onu2Ctc3UniPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniLogicalPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniPhyPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPhyPortId")
			+ " : ";
	private final String utsDot3Onu2UniStaticMacAddress = fStringMap
			.getString("utsDot3Onu2UniStaticMacAddress")
			+ " : ";

	public Dot3Onu2UniStaticMacTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
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
		
//		for (int i = 1; i <= 64; i++)
//			tfUtsDot3Onu2Ctc3UniLogicalPortId.addItem("" + i);

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPhyPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPhyPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStaticMacAddress));
		baseInfoPanel.add(tfUtsDot3Onu2UniStaticMacAddress);
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

	}

	public void refresh() {
		tfUtsDot3Onu2Ctc3UniModuleId.removeAllItems();

		ModuleType fModuleType = new ModuleType();
		BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication
				.getSnmpProxy());
		Vector list = BeanService.refreshTableBean(fApplication, bean);
		for (int i = 0; i < list.size(); i++) {
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
        
		if (SnmpAction.IType.ADD.equals(fCommand)) {
			tfUtsDot3Onu2Ctc3UniModuleId.setEnabled(true);
			tfUtsDot3Onu2Ctc3UniPortId.setEnabled(true);
			tfUtsDot3Onu2Ctc3UniLogicalPortId.setEnabled(true);
			tfUtsDot3Onu2Ctc3UniPhyPortId.setEnabled(true);
			return;
		}
		Dot3Onu2UniStaticMacTable mbean = (Dot3Onu2UniStaticMacTable) getModel();

//		tfUtsDot3Onu2Ctc3UniModuleId.setText(mbean
//				.getUtsDot3Onu2Ctc3UniModuleId().toString());
		tfUtsDot3Onu2Ctc3UniModuleId.setSelectedItem(mbean
				.getUtsDot3Onu2Ctc3UniModuleId());
//		tfUtsDot3Onu2Ctc3UniDeviceId.setText(mbean
//				.getUtsDot3Onu2Ctc3UniDeviceId().toString());
//		tfUtsDot3Onu2Ctc3UniPortId.setText(mbean.getUtsDot3Onu2Ctc3UniPortId()
//				.toString());
		tfUtsDot3Onu2Ctc3UniPortId.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2Ctc3UniPortIdVList, mbean
						.getUtsDot3Onu2Ctc3UniPortId().intValue()));
//		tfUtsDot3Onu2Ctc3UniLogicalPortId.setText(mbean
//				.getUtsDot3Onu2Ctc3UniLogicalPortId().toString());
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setSelectedItem(""
				+ mbean.getUtsDot3Onu2Ctc3UniLogicalPortId());
		tfUtsDot3Onu2Ctc3UniPhyPortId.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2Ctc3UniPhyPortIdVList, mbean
						.getUtsDot3Onu2Ctc3UniPhyPortId().intValue()));
		tfUtsDot3Onu2UniStaticMacAddress.setValue(mbean
				.getUtsDot3Onu2UniStaticMacAddress());
		
		tfUtsDot3Onu2Ctc3UniModuleId.setEnabled(false);
		tfUtsDot3Onu2Ctc3UniPortId.setEnabled(false);
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setEnabled(false);
		tfUtsDot3Onu2Ctc3UniPhyPortId.setEnabled(false);

	}

	public void updateModel() {

		if (SnmpAction.IType.ADD.equals(fCommand))
			setModel(new Dot3Onu2UniStaticMacTable(fApplication.getSnmpProxy()));

		Dot3Onu2UniStaticMacTable mbean = (Dot3Onu2UniStaticMacTable) getModel();

		mbean.setUtsDot3Onu2Ctc3UniModuleId(new Integer(tfUtsDot3Onu2Ctc3UniModuleId.getSelectedItem().toString()));
		mbean.setUtsDot3Onu2Ctc3UniDeviceId(1);
		mbean.setUtsDot3Onu2Ctc3UniPortId(new Integer((String) tfUtsDot3Onu2Ctc3UniPortId.getSelectedItem()));
		mbean.setUtsDot3Onu2Ctc3UniLogicalPortId(new Integer((String) tfUtsDot3Onu2Ctc3UniLogicalPortId.getSelectedItem()));
		mbean.setUtsDot3Onu2Ctc3UniPhyPortId(new Integer((String) tfUtsDot3Onu2Ctc3UniPhyPortId.getSelectedItem()));
		mbean
				.setUtsDot3Onu2UniStaticMacAddress(tfUtsDot3Onu2UniStaticMacAddress
						.getValue());


		// mbean.setUtsDot3Onu2UniStaticMacRowStatus(new
		// Integer(utsDot3Onu2UniStaticMacRowStatusVList[tfUtsDot3Onu2UniStaticMacRowStatus.getSelectedIndex()]));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

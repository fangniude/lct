package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2OperationTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * The Dot3Onu2OperationTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2OperationTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2MacAgingTimeModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimeDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimePortId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimeLogicalPortId = new JLabel();
	
	private IntegerTextField tfUtsDot3Onu2PowerControlActions = new IntegerTextField();

	private int[] utsDot3Onu2PowerControlModeVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2PowerControlModeTList = new String[] {
			fStringMap.getString("unicast-llid"),
			fStringMap.getString("broadcast-llid"), };
	private JComboBox tfUtsDot3Onu2PowerControlMode = new JComboBox(
			utsDot3Onu2PowerControlModeTList);
	private MacAddressField tfUtsDot3Onu2PowerControlOnuId = new MacAddressField(MacAddressField.UNICAST_TYPE);
	
	private byte[] origeMacAddree = null;

	private int[] utsDot3Onu2PowerControlTxIdVList = new int[] { 1, 3, 2, };
	private String[] utsDot3Onu2PowerControlTxIdTList = new String[] {
			fStringMap.getString("active-tx"), fStringMap.getString("both-tx"),
			fStringMap.getString("standby-tx"), };
	private JComboBox tfUtsDot3Onu2PowerControlTxId = new JComboBox(
			utsDot3Onu2PowerControlTxIdTList);

	private final String utsDot3Onu2MacAgingTimeModuleId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeModuleId")
			+ " : ";
	private final String utsDot3Onu2MacAgingTimeDeviceId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeDeviceId")
			+ " : ";
	private final String utsDot3Onu2MacAgingTimePortId = fStringMap
			.getString("utsDot3Onu2MacAgingTimePortId")
			+ " : ";
	private final String utsDot3Onu2PowerControlActions = fStringMap
			.getString("utsDot3Onu2PowerControlActions")
			+ " : ";
	private JLabel controlLabel = new JLabel(utsDot3Onu2PowerControlActions);
	private final String utsDot3Onu2MacAgingTimeLogicalPortId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2PowerControlMode = fStringMap
			.getString("utsDot3Onu2PowerControlMode")
			+ " : ";
	private final String utsDot3Onu2PowerControlOnuId = fStringMap
			.getString("utsDot3Onu2PowerControlOnuId")
			+ " : ";
	private final String utsDot3Onu2PowerControlTxId = fStringMap
			.getString("utsDot3Onu2PowerControlTxId")
			+ " : ";

	public Dot3Onu2OperationTablePanel(IApplication app) {
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimePortId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimePortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeLogicalPortId);
		baseInfoPanel.add(new HSpacer());
		
//		baseInfoPanel.add(controlLabel);
//		tfUtsDot3Onu2PowerControlActions.setName(fStringMap
//				.getString("utsDot3Onu2PowerControlActions"));
//		baseInfoPanel.add(tfUtsDot3Onu2PowerControlActions);
//		baseInfoPanel.add(new HSpacer());


		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlMode));
		tfUtsDot3Onu2PowerControlMode.setName(fStringMap
				.getString("utsDot3Onu2PowerControlMode"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlOnuId));
		tfUtsDot3Onu2PowerControlOnuId.setName(fStringMap
				.getString("utsDot3Onu2PowerControlOnuId"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlOnuId);
		tfUtsDot3Onu2PowerControlOnuId.setValue("00:00:00:00:00:00");
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlTxId));
		tfUtsDot3Onu2PowerControlTxId.setName(fStringMap
				.getString("utsDot3Onu2PowerControlTxId"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlTxId);
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
		tfUtsDot3Onu2PowerControlMode.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tfUtsDot3Onu2PowerControlMode.getSelectedIndex() == 0) {
					tfUtsDot3Onu2PowerControlOnuId.setEnabled(false);
					tfUtsDot3Onu2PowerControlOnuId.setValue(origeMacAddree);
				} else {
					tfUtsDot3Onu2PowerControlOnuId.setEnabled(true);
				}
			}
		});

	}
	
	private void reLayout() {
		this.removeAll();
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimePortId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimePortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeLogicalPortId);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(controlLabel);
		tfUtsDot3Onu2PowerControlActions.setName(fStringMap
				.getString("utsDot3Onu2PowerControlActions"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlActions);
		baseInfoPanel.add(new HSpacer());


		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlMode));
		tfUtsDot3Onu2PowerControlMode.setName(fStringMap
				.getString("utsDot3Onu2PowerControlMode"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlOnuId));
		tfUtsDot3Onu2PowerControlOnuId.setName(fStringMap
				.getString("utsDot3Onu2PowerControlOnuId"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlOnuId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlTxId));
		tfUtsDot3Onu2PowerControlTxId.setName(fStringMap
				.getString("utsDot3Onu2PowerControlTxId"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlTxId);
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

	public void refresh() {

		Dot3Onu2OperationTable mbean = (Dot3Onu2OperationTable) getModel();

		if(mbean.getUtsDot3Onu2PowerControlActions() == 0 || mbean.getUtsDot3Onu2PowerControlActions() == 65535) {
			tfUtsDot3Onu2PowerControlActions.setValue(mbean.getUtsDot3Onu2PowerControlActions());
			tfUtsDot3Onu2PowerControlActions.setVisible(false);
			controlLabel.setVisible(false);
//			tfUtsDot3Onu2PowerControlActions.setText(mbean.getUtsDot3Onu2PowerControlActions() == 0 ? fStringMap.getString("Re-Enable") :  fStringMap.getString("ShutdownPermanently"));
			tfUtsDot3Onu2PowerControlActions.setEnabled(false);
		} else {
			reLayout();
			tfUtsDot3Onu2PowerControlActions.setValue(mbean.getUtsDot3Onu2PowerControlActions());
			tfUtsDot3Onu2PowerControlActions.setVisible(true);
			controlLabel.setVisible(true);
			tfUtsDot3Onu2PowerControlActions.setEnabled(true);
		}
		
		tfUtsDot3Onu2MacAgingTimeModuleId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeModuleId().toString());
		tfUtsDot3Onu2MacAgingTimeDeviceId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeDeviceId().toString());
		tfUtsDot3Onu2MacAgingTimePortId.setText(mbean
				.getUtsDot3Onu2MacAgingTimePortId().toString());
		tfUtsDot3Onu2MacAgingTimeLogicalPortId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeLogicalPortId().toString());
		
		tfUtsDot3Onu2PowerControlMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PowerControlModeVList, mbean
						.getUtsDot3Onu2PowerControlMode().intValue()));

//		if(mbean.getUtsDot3Onu2PowerControlOnuId()==null) {
		if((mbean.getUtsDot3Onu2PowerControlMode() == 1)) {
			tfUtsDot3Onu2PowerControlOnuId.setValue(mbean
					.getUtsDot3Onu2PowerControlOnuId());
			tfUtsDot3Onu2PowerControlOnuId.setEnabled(false);
		}
		else {
			tfUtsDot3Onu2PowerControlOnuId.setEnabled(true);
			tfUtsDot3Onu2PowerControlOnuId.setValue(mbean
				.getUtsDot3Onu2PowerControlOnuId());
		}
		
		origeMacAddree = mbean.getUtsDot3Onu2PowerControlOnuId();
		tfUtsDot3Onu2PowerControlTxId.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PowerControlTxIdVList, mbean
						.getUtsDot3Onu2PowerControlTxId().intValue()));

	}

	public void updateModel() {

		Dot3Onu2OperationTable mbean = (Dot3Onu2OperationTable) getModel();

		mbean.setUtsDot3Onu2PowerControlActions(new Integer(
				tfUtsDot3Onu2PowerControlActions.getValue()));  //TODO..
		mbean.setUtsDot3Onu2PowerControlMode(new Integer(
				utsDot3Onu2PowerControlModeVList[tfUtsDot3Onu2PowerControlMode
						.getSelectedIndex()]));
//		if(tfUtsDot3Onu2PowerControlOnuId.isEnabled()) {
		if(isMacValidate(tfUtsDot3Onu2PowerControlOnuId.getValue())) {
			mbean.setUtsDot3Onu2PowerControlOnuId(tfUtsDot3Onu2PowerControlOnuId
				.getValue());
		}
		else {
			mbean.setUtsDot3Onu2PowerControlOnuId(null);
		}
		mbean.setUtsDot3Onu2PowerControlTxId(new Integer(
				utsDot3Onu2PowerControlTxIdVList[tfUtsDot3Onu2PowerControlTxId
						.getSelectedIndex()]));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
	
	private boolean isMacValidate(byte[] mac) {
		if(mac==null || mac.length != 6) return false;

		return !(((mac[0] & 0xFF) == 0x0) && ((mac[1] & 0xFF) == 0x0) && ((mac[2] & 0xFF) == 0x0) && ((mac[3] & 0xFF) == 0x0)
			&& ((mac[4] & 0xFF) == 0x0) && ((mac[5] & 0xFF) == 0x0)); 
	}

}

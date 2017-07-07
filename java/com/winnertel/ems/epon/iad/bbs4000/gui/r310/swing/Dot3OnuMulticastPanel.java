package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.MulticastConfigure;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3OnuMulticastPanel extends UPanel {
	private JLabel tfUtsDot3Onu2CtcModuleId = new JLabel();
	private JLabel tfUtsDot3Onu2CtcPortId = new JLabel();
	private JLabel tfUtsDot3Onu2CtcLogicalPortId = new JLabel();

	private int[] utsDot3Onu2CtcMulticastSwitchVList = new int[] { 1, 2, 3, 4 };
	private String[] utsDot3Onu2CtcMulticastSwitchTList = new String[] {
			fStringMap.getString("special-snooping"), // 1
			fStringMap.getString("control-snooping"), // 2
			fStringMap.getString("standard-snooping"), // 3
			fStringMap.getString("disable"), // 4
	};
	private JComboBox tfUtsDot3Onu2CtcMulticastSwitch = new JComboBox(
			utsDot3Onu2CtcMulticastSwitchTList);

	private int[] utsDot3Onu2FastLeaveAdminControlVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2FastLeaveAdminControlTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };
	private JComboBox tfUtsDot3Onu2FastLeaveAdminControl = new JComboBox(
			utsDot3Onu2FastLeaveAdminControlTList);

	private final String utsDot3Onu2CtcModuleId = fStringMap
			.getString("utsDot3Onu2CtcModuleId")
			+ " : ";
	private final String utsDot3Onu2CtcPortId = fStringMap
			.getString("utsDot3Onu2CtcPortId")
			+ " : ";
	private final String utsDot3Onu2CtcLogicalPortId = fStringMap
			.getString("utsDot3Onu2CtcLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2CtcMulticastSwitch = fStringMap
			.getString("utsDot3Onu2CtcMulticastSwitch")
			+ " : ";
	private final String utsDot3Onu2FastLeaveAdminControl = fStringMap
			.getString("utsDot3Onu2FastLeaveAdminControl")
			+ " : ";

	public Dot3OnuMulticastPanel(IApplication app) {
		super(app);
		init();
	}

	public void initGui() {
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMulticastSwitch));
		baseInfoPanel.add(tfUtsDot3Onu2CtcMulticastSwitch);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2FastLeaveAdminControl));
		baseInfoPanel.add(tfUtsDot3Onu2FastLeaveAdminControl);
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

	public boolean validateFrom() {
		return true;
	}

	public void refresh() {
		MulticastConfigure mbean = (MulticastConfigure) getModel();
		if (mbean == null)
			return;

		tfUtsDot3Onu2CtcModuleId.setText(mbean
				.getUtsDot3Onu2CtcModuleId().toString());
		tfUtsDot3Onu2CtcPortId.setText(mbean.getUtsDot3Onu2CtcPortId()
				.toString());
		tfUtsDot3Onu2CtcLogicalPortId.setText(mbean
				.getUtsDot3Onu2CtcLogicalPortId().toString());

		if (mbean.getUtsDot3Onu2FastLeaveAdminControl() != null)
			tfUtsDot3Onu2FastLeaveAdminControl
					.setSelectedIndex(getIndexFromValue(
							utsDot3Onu2FastLeaveAdminControlVList, mbean
									.getUtsDot3Onu2FastLeaveAdminControl()
									.intValue()));
		else
			tfUtsDot3Onu2FastLeaveAdminControl.setSelectedIndex(-1);

		tfUtsDot3Onu2CtcMulticastSwitch.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcMulticastSwitchVList, mbean
						.getUtsDot3Onu2CtcMulticastSwitch().intValue()));

		boolean adminStatusUpOrNot = mbean.getUtsDot3Onu2CtcAdmin().intValue() == 1;
		tfUtsDot3Onu2CtcMulticastSwitch.setEnabled(adminStatusUpOrNot);

	}

	public void updateModel() {
		MulticastConfigure mbean = (MulticastConfigure) getModel();

		if (mbean.getUtsDot3Onu2CtcMulticastSwitch().intValue() != utsDot3Onu2CtcMulticastSwitchVList[tfUtsDot3Onu2CtcMulticastSwitch
				.getSelectedIndex()]) {
			mbean.setUtsDot3Onu2CtcMulticastSwitch(new Integer(
					utsDot3Onu2CtcMulticastSwitchVList[tfUtsDot3Onu2CtcMulticastSwitch
							.getSelectedIndex()]));
		}
		mbean
				.setUtsDot3Onu2FastLeaveAdminControl(utsDot3Onu2FastLeaveAdminControlVList[tfUtsDot3Onu2FastLeaveAdminControl
						.getSelectedIndex()]);

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}

		return 0;
	}

}

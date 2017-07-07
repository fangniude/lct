package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.MulticastConfigure;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class MulticastConfigurePanel extends UPanel {

	private int[] utsDot3Onu2CtcMulticastSwitchVList = new int[] { 1, 2, 3 };
	private String[] utsDot3Onu2CtcMulticastSwitchTList = new String[] {
			fStringMap.getString("special-snooping"),
			fStringMap.getString("control-snooping"),
			fStringMap.getString("standard-snooping") };
	private final String utsDot3Onu2CtcMulticastSwitch = fStringMap
			.getString("utsDot3Onu2CtcMulticastSwitch")
			+ " : ";

	private JComboBox tfUtsDot3Onu2CtcMulticastSwitch = new JComboBox(
			utsDot3Onu2CtcMulticastSwitchTList);

	private JLabel tfUtsDot3Onu2CtcModuleId = new JLabel();

	// private JLabel tfUtsDot3Onu2CtcDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcPortId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcLogicalPortId = new JLabel();

	private final String utsDot3Onu2CtcModuleId = fStringMap
			.getString("utsDot3Onu2CtcModuleId")
			+ " : ";
	// private final String utsDot3Onu2CtcDeviceId =
	// fStringMap.getString("utsDot3Onu2CtcDeviceId") + " : ";
	private final String utsDot3Onu2CtcPortId = fStringMap
			.getString("utsDot3Onu2CtcPortId")
			+ " : ";
	private final String utsDot3Onu2CtcLogicalPortId = fStringMap
			.getString("utsDot3Onu2CtcLogicalPortId")
			+ " : ";

	public MulticastConfigurePanel(IApplication app) {
		super(app);
		init();
	}

	protected void initGui() {
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcModuleId);
		baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3Onu2CtcDeviceId));
		// baseInfoPanel.add(tfUtsDot3Onu2CtcDeviceId);
		// baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		
		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMulticastSwitch));
		tfUtsDot3Onu2CtcMulticastSwitch.setName(fStringMap
				.getString("utsDot3Onu2CtcMulticastSwitch"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcMulticastSwitch);
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
		MulticastConfigure mbean = (MulticastConfigure) getModel();
		
	    tfUtsDot3Onu2CtcModuleId.setText(mbean.getUtsDot3Onu2CtcModuleId().toString());
//	    tfUtsDot3Onu2CtcDeviceId.setText(mbean.getUtsDot3Onu2CtcDeviceId().toString());
	    tfUtsDot3Onu2CtcPortId.setText(mbean.getUtsDot3Onu2CtcPortId().toString());
	    tfUtsDot3Onu2CtcLogicalPortId.setText(mbean.getUtsDot3Onu2CtcLogicalPortId().toString());
	    
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
			mbean
					.setUtsDot3Onu2CtcMulticastSwitch(new Integer(
							utsDot3Onu2CtcMulticastSwitchVList[tfUtsDot3Onu2CtcMulticastSwitch
									.getSelectedIndex()]));
		}
	}

	public void afterUpdateModel() {
		refresh();
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
}

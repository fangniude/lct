package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.UtsDot3Onu2AlarmSettingTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The utsDot3Onu2AlarmSettingTablPanel class. Created by DVM Creator
 */
public class UtsDot3Onu2AlarmSettingTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2AlarmSettingModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2AlarmSettingDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2AlarmSettingPortId = new JLabel();

	private JLabel tfUtsDot3Onu2AlarmSettingLogicalPortId = new JLabel();

	private IntegerTextField tfUtsDot3Onu2AlarmSettingProfileId = new IntegerTextField();

	private final String utsDot3Onu2AlarmSettingModuleId = fStringMap
			.getString("utsDot3Onu2AlarmSettingModuleId") + " : ";
	private final String utsDot3Onu2AlarmSettingDeviceId = fStringMap
			.getString("utsDot3Onu2AlarmSettingDeviceId") + " : ";
	private final String utsDot3Onu2AlarmSettingPortId = fStringMap
			.getString("utsDot3Onu2AlarmSettingPortId") + " : ";
	private final String utsDot3Onu2AlarmSettingLogicalPortId = fStringMap
			.getString("utsDot3Onu2AlarmSettingLogicalPortId") + " : ";
	private final String utsDot3Onu2AlarmSettingProfileId = fStringMap
			.getString("utsDot3Onu2AlarmSettingProfileId") + " : ";

	public UtsDot3Onu2AlarmSettingTablePanel(IApplication app) {
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmSettingModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmSettingModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmSettingDeviceId));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmSettingDeviceId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmSettingPortId));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmSettingPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmSettingLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmSettingLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmSettingProfileId));
		tfUtsDot3Onu2AlarmSettingProfileId.setName(fStringMap
				.getString("utsDot3Onu2AlarmSettingProfileId"));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmSettingProfileId);
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

		tfUtsDot3Onu2AlarmSettingProfileId.setValueScope(1, 1024);

	}

	public void refresh() {

		UtsDot3Onu2AlarmSettingTable mbean = (UtsDot3Onu2AlarmSettingTable) getModel();

		tfUtsDot3Onu2AlarmSettingModuleId.setText(mbean
				.getUtsDot3Onu2AlarmSettingModuleId().toString());
		tfUtsDot3Onu2AlarmSettingDeviceId.setText(mbean
				.getUtsDot3Onu2AlarmSettingDeviceId().toString());
		tfUtsDot3Onu2AlarmSettingPortId.setText(mbean
				.getUtsDot3Onu2AlarmSettingPortId().toString());
		tfUtsDot3Onu2AlarmSettingLogicalPortId.setText(mbean
				.getUtsDot3Onu2AlarmSettingLogicalPortId().toString());
		tfUtsDot3Onu2AlarmSettingProfileId.setValue(mbean
				.getUtsDot3Onu2AlarmSettingProfileId().intValue());

	}

	public void updateModel() {

		UtsDot3Onu2AlarmSettingTable mbean = (UtsDot3Onu2AlarmSettingTable) getModel();

		mbean.setUtsDot3Onu2AlarmSettingProfileId(new Integer(
				tfUtsDot3Onu2AlarmSettingProfileId.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

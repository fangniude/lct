package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipTimerTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2VoipTimerTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2VoipTimerTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private IntegerTextField tfUtsDot3Onu2VoipLongTimer = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipShortTimer = new IntegerTextField();

	private final String utsDot3Onu2VoipModuleId = fStringMap
			.getString("utsDot3Onu2VoipModuleId")
			+ " : ";
	private final String utsDot3Onu2VoipDeviceId = fStringMap
			.getString("utsDot3Onu2VoipDeviceId")
			+ " : ";
	private final String utsDot3Onu2VoipPortId = fStringMap
			.getString("utsDot3Onu2VoipPortId")
			+ " : ";
	private final String utsDot3Onu2VoipLogicalPortId = fStringMap
			.getString("utsDot3Onu2VoipLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2VoipLongTimer = fStringMap
			.getString("utsDot3Onu2VoipLongTimer")
			+ " : ";
	private final String utsDot3Onu2VoipShortTimer = fStringMap
			.getString("utsDot3Onu2VoipShortTimer")
			+ " : ";

	public Dot3Onu2VoipTimerTablePanel(IApplication app) {
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipDeviceId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipDeviceId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipLongTimer));
		tfUtsDot3Onu2VoipLongTimer.setName(fStringMap
				.getString("utsDot3Onu2VoipLongTimer"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipLongTimer);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipShortTimer));
		tfUtsDot3Onu2VoipShortTimer.setName(fStringMap
				.getString("utsDot3Onu2VoipShortTimer"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipShortTimer);
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

		tfUtsDot3Onu2VoipLongTimer.setValueScope(1, 40);

		tfUtsDot3Onu2VoipShortTimer.setValueScope(1, 40);

	}

	public void refresh() {

		Dot3Onu2VoipTimerTable mbean = (Dot3Onu2VoipTimerTable) getModel();

		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2VoipModuleId()
				.toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2VoipDeviceId()
				.toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2VoipPortId()
				.toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean
				.getUtsDot3Onu2VoipLogicalPortId().toString());
		tfUtsDot3Onu2VoipLongTimer.setValue(mbean.getUtsDot3Onu2VoipLongTimer()
				.intValue());
		tfUtsDot3Onu2VoipShortTimer.setValue(mbean
				.getUtsDot3Onu2VoipShortTimer().intValue());

	}

	public void updateModel() {

		Dot3Onu2VoipTimerTable mbean = (Dot3Onu2VoipTimerTable) getModel();

		mbean.setUtsDot3Onu2VoipLongTimer(new Integer(
				tfUtsDot3Onu2VoipLongTimer.getValue()));
		mbean.setUtsDot3Onu2VoipShortTimer(new Integer(
				tfUtsDot3Onu2VoipShortTimer.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3OltOpmOltDataTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3OltOpmOltDataTablePanel extends UPanel {
	private JLabel tfUtsDot3OltOpmOltDataModuleID = new JLabel();
	private JLabel tfUtsDot3OltOpmOltDataPortId = new JLabel();
	private JLabel tfUtsDot3OltOpmOltDataTemperature = new JLabel();
	private JLabel tfUtsDot3OltOpmOltDataVoltage = new JLabel();
	private JLabel tfUtsDot3OltOpmOltDataBiasCurrent = new JLabel();
	private JLabel tfUtsDot3OltOpmOltDataTxPower = new JLabel();

	private int[] utsDot3OltOpmPmSwitchVList = new int[] { 1, 2, };
	private String[] utsDot3OltOpmPmSwitchTList = new String[] {
			fStringMap.getString("enable"), fStringMap.getString("disable"), };
	private JComboBox tfUtsDot3OltOpmPmSwitch = new JComboBox(
			utsDot3OltOpmPmSwitchTList);

	private final String utsDot3OltOpmOltDataModuleID = fStringMap
			.getString("utsDot3OltOpmOltDataModuleID")
			+ " : ";
	private final String utsDot3OltOpmOltDataPortId = fStringMap
			.getString("utsDot3OltOpmOltDataPortId")
			+ " : ";
	private final String utsDot3OltOpmOltDataTemperature = fStringMap
			.getString("utsDot3OltOpmOltDataTemperature")
			+ " : ";
	private final String utsDot3OltOpmOltDataVoltage = fStringMap
			.getString("utsDot3OltOpmOltDataVoltage")
			+ " : ";
	private final String utsDot3OltOpmOltDataBiasCurrent = fStringMap
			.getString("utsDot3OltOpmOltDataBiasCurrent")
			+ " : ";
	private final String utsDot3OltOpmOltDataTxPower = fStringMap
			.getString("utsDot3OltOpmOltDataTxPower")
			+ " : ";
	private final String utsDot3OltOpmPmSwitch = fStringMap
			.getString("utsDot3OltOpmPmSwitch")
			+ " : ";

	public Dot3OltOpmOltDataTablePanel(IApplication app) {
		super(app);
		init();
	}

	public void initGui() {
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataModuleID));
		baseInfoPanel.add(tfUtsDot3OltOpmOltDataModuleID);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataPortId));
		baseInfoPanel.add(tfUtsDot3OltOpmOltDataPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataTemperature));
		baseInfoPanel.add(tfUtsDot3OltOpmOltDataTemperature);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataVoltage));
		baseInfoPanel.add(tfUtsDot3OltOpmOltDataVoltage);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataBiasCurrent));
		baseInfoPanel.add(tfUtsDot3OltOpmOltDataBiasCurrent);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataTxPower));
		baseInfoPanel.add(tfUtsDot3OltOpmOltDataTxPower);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmPmSwitch));
		baseInfoPanel.add(tfUtsDot3OltOpmPmSwitch);
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
		Dot3OltOpmOltDataTable mbean = (Dot3OltOpmOltDataTable) getModel();
		if (mbean == null)
			return;

		tfUtsDot3OltOpmOltDataModuleID.setText(mbean
				.getUtsDot3OltOpmOltDataModuleID().toString());
		tfUtsDot3OltOpmOltDataPortId.setText(mbean
				.getUtsDot3OltOpmOltDataPortId().toString());
		tfUtsDot3OltOpmOltDataTemperature.setText(mbean
				.getUtsDot3OltOpmOltDataTemperatureDisplay().toString());
		tfUtsDot3OltOpmOltDataVoltage.setText(mbean
				.getUtsDot3OltOpmOltDataVoltageDisplay().toString());
		tfUtsDot3OltOpmOltDataBiasCurrent.setText(mbean
				.getUtsDot3OltOpmOltDataBiasCurrentDisplay().toString());
		tfUtsDot3OltOpmOltDataTxPower.setText(mbean
				.getUtsDot3OltOpmOltDataTxPowerDisplay().toString());
		tfUtsDot3OltOpmPmSwitch.setSelectedIndex(getIndexFromValue(
				utsDot3OltOpmPmSwitchVList, mbean.getUtsDot3OltOpmPmSwitch()
						.intValue()));
	}

	public void updateModel() {
		Dot3OltOpmOltDataTable mbean = (Dot3OltOpmOltDataTable) getModel();
		if (mbean == null)
			return;

		mbean.setUtsDot3OltOpmPmSwitch(new Integer(
				utsDot3OltOpmPmSwitchVList[tfUtsDot3OltOpmPmSwitch
						.getSelectedIndex()]));
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}

		return 0;
	}

}

package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2Table;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Olt2TablePanel class. Created by DVM Creator
 */
public class Dot3Olt2TablePanel extends UPanel {

	private JLabel tfUtsDot3OltModuleId = new JLabel();

//	private JLabel tfUtsDot3OltDeviceId = new JLabel();
//
//	private int[] utsDot3OltPortIsolationVList = new int[] { 2, 1, };
//	private String[] utsDot3OltPortIsolationTList = new String[] {
//			fStringMap.getString("disable"), fStringMap.getString("enable"), };
//	private JComboBox tfUtsDot3OltPortIsolation = new JComboBox(
//			utsDot3OltPortIsolationTList);
//	private int[] utsDot3OltDot1adEnableVList = new int[] { 1, 2, };
//	private String[] utsDot3OltDot1adEnableTList = new String[] {
//			fStringMap.getString("true"), fStringMap.getString("false"), };
//	private JComboBox tfUtsDot3OltDot1adEnable = new JComboBox(
//			utsDot3OltDot1adEnableTList);
//	private IntegerTextField tfUtsDot3OltDot1adTPID = new IntegerTextField();
	private int[] utsDot3OltEncryptionModeVList = new int[] { 4, 3, };
	private String[] utsDot3OltEncryptionModeTList = new String[] {
			fStringMap.getString("disable"),
			fStringMap.getString("ctc_churning"), };
	private JComboBox tfUtsDot3OltEncryptionMode = new JComboBox(
			utsDot3OltEncryptionModeTList);
	private IntegerTextField tfUtsDot3OltEncryptionRekeyTimer = new IntegerTextField();

	private final String utsDot3OltModuleId = fStringMap
			.getString("utsDot3OltModuleId")
			+ " : ";
//	private final String utsDot3OltDeviceId = fStringMap
//			.getString("utsDot3OltDeviceId")
//			+ " : ";
//	private final String utsDot3OltPortIsolation = fStringMap
//			.getString("utsDot3OltPortIsolation")
//			+ " : ";
	private final String utsDot3OltDot1adEnable = fStringMap
			.getString("utsDot3OltDot1adEnable")
			+ " : ";
//	private final String utsDot3OltDot1adTPID = fStringMap
//			.getString("utsDot3OltDot1adTPID")
//			+ " : ";
	private final String utsDot3OltEncryptionMode = fStringMap
			.getString("utsDot3OltEncryptionMode")
			+ " : ";
	private final String utsDot3OltEncryptionRekeyTimer = fStringMap
			.getString("utsDot3OltEncryptionRekeyTimer")
			+ " : ";

	public Dot3Olt2TablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OltModuleId));
		baseInfoPanel.add(tfUtsDot3OltModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3OltDeviceId));
//		baseInfoPanel.add(tfUtsDot3OltDeviceId);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltPortIsolation));
//		tfUtsDot3OltPortIsolation.setName(fStringMap
//				.getString("utsDot3OltPortIsolation"));
//		baseInfoPanel.add(tfUtsDot3OltPortIsolation);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3OltDot1adEnable));
//		tfUtsDot3OltDot1adEnable.setName(fStringMap
//				.getString("utsDot3OltDot1adEnable"));
//		baseInfoPanel.add(tfUtsDot3OltDot1adEnable);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3OltDot1adTPID));
//		tfUtsDot3OltDot1adTPID.setName(fStringMap
//				.getString("utsDot3OltDot1adTPID"));
//		baseInfoPanel.add(tfUtsDot3OltDot1adTPID);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltEncryptionMode));
		tfUtsDot3OltEncryptionMode.setName(fStringMap
				.getString("utsDot3OltEncryptionMode"));
		baseInfoPanel.add(tfUtsDot3OltEncryptionMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltEncryptionRekeyTimer));
		tfUtsDot3OltEncryptionRekeyTimer.setName(fStringMap
				.getString("utsDot3OltEncryptionRekeyTimer"));
		baseInfoPanel.add(tfUtsDot3OltEncryptionRekeyTimer);
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
//		tfUtsDot3OltDot1adTPID.setValueScope(1, 65535);
		tfUtsDot3OltEncryptionRekeyTimer.setValueScope(0, 640);
	}

	public void refresh() {

		Dot3Olt2Table mbean = (Dot3Olt2Table) getModel();

		tfUtsDot3OltModuleId.setText(mbean.getUtsDot3OltModuleId().toString());
//		tfUtsDot3OltDeviceId.setText(mbean.getUtsDot3OltDeviceId().toString());
//		tfUtsDot3OltPortIsolation.setSelectedIndex(getIndexFromValue(
//				utsDot3OltPortIsolationVList, mbean
//						.getUtsDot3OltPortIsolation().intValue()));
//		tfUtsDot3OltDot1adEnable.setSelectedIndex(getIndexFromValue(
//				utsDot3OltDot1adEnableVList, mbean.getUtsDot3OltDot1adEnable()
//						.intValue()));
//		tfUtsDot3OltDot1adTPID.setValue(mbean.getUtsDot3OltDot1adTPID()
//				.intValue());
		tfUtsDot3OltEncryptionMode.setSelectedIndex(getIndexFromValue(
				utsDot3OltEncryptionModeVList, mbean
						.getUtsDot3OltEncryptionMode().intValue()));
		tfUtsDot3OltEncryptionRekeyTimer.setValue(mbean
				.getUtsDot3OltEncryptionRekeyTimer().intValue());
	}

	public void updateModel() {

		Dot3Olt2Table mbean = (Dot3Olt2Table) getModel();

//		mbean.setUtsDot3OltPortIsolation(new Integer(
//				utsDot3OltPortIsolationVList[tfUtsDot3OltPortIsolation
//						.getSelectedIndex()]));
//		mbean.setUtsDot3OltDot1adEnable(new Integer(
//				utsDot3OltDot1adEnableVList[tfUtsDot3OltDot1adEnable
//						.getSelectedIndex()]));
//		mbean.setUtsDot3OltDot1adTPID(new Integer(tfUtsDot3OltDot1adTPID
//				.getValue()));
		mbean.setUtsDot3OltEncryptionMode(new Integer(
				utsDot3OltEncryptionModeVList[tfUtsDot3OltEncryptionMode
						.getSelectedIndex()]));
		mbean.setUtsDot3OltEncryptionRekeyTimer(new Integer(
				tfUtsDot3OltEncryptionRekeyTimer.getValue()));
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

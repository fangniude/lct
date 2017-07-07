package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2PrivateUniOamTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2PrivateUniOamTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2PrivateUniOamTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2Ctc3UniModuleId = new JLabel();

//	private JLabel tfUtsDot3Onu2Ctc3UniDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPhyPortId = new JLabel();

	private int[] utsDot3Onu2PrivateUniSchedulingSchemeVList = new int[] { 1,
			2, };
	private String[] utsDot3Onu2PrivateUniSchedulingSchemeTList = new String[] {
			fStringMap.getString("sp"), fStringMap.getString("wrr"), };
	private JComboBox tfUtsDot3Onu2PrivateUniSchedulingScheme = new JComboBox(
			utsDot3Onu2PrivateUniSchedulingSchemeTList);
	
	private int[] utsDot3Onu2PrivateUniWeight0VList = new int[] { 1, 2, 3, 4,
			5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, };
	private String[] utsDot3Onu2PrivateUniWeight0TList = new String[] { "1",
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
			"14", "15", };
	private JComboBox tfUtsDot3Onu2PrivateUniWeight0 = new JComboBox(
			utsDot3Onu2PrivateUniWeight0TList);
//	private IntegerTextField tfUtsDot3Onu2PrivateUniWeight0 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateUniWeight1VList = new int[] { 1, 2, 3, 4,
			5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, };
	private String[] utsDot3Onu2PrivateUniWeight1TList = new String[] { "1",
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
			"14", "15", };
	private JComboBox tfUtsDot3Onu2PrivateUniWeight1 = new JComboBox(
			utsDot3Onu2PrivateUniWeight1TList);
//	private IntegerTextField tfUtsDot3Onu2PrivateUniWeight1 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateUniWeight2VList = new int[] { 1, 2, 3, 4,
			5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, };
	private String[] utsDot3Onu2PrivateUniWeight2TList = new String[] { "1",
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
			"14", "15", };
	private JComboBox tfUtsDot3Onu2PrivateUniWeight2 = new JComboBox(
			utsDot3Onu2PrivateUniWeight2TList);
//	private IntegerTextField tfUtsDot3Onu2PrivateUniWeight2 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateUniWeight3VList = new int[] { 1, 2, 3, 4,
			5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, };
	private String[] utsDot3Onu2PrivateUniWeight3TList = new String[] { "1",
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
			"14", "15", };
	private JComboBox tfUtsDot3Onu2PrivateUniWeight3 = new JComboBox(
			utsDot3Onu2PrivateUniWeight3TList);
//	private IntegerTextField tfUtsDot3Onu2PrivateUniWeight3 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateUniWeight4VList = new int[] { 0, 1, 2, 3,
			4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, };
	private String[] utsDot3Onu2PrivateUniWeight4TList = new String[] {
			fStringMap.getString("notsupported"), "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "11", "12", "13", "14", "15", };
	private JComboBox tfUtsDot3Onu2PrivateUniWeight4 = new JComboBox(
			utsDot3Onu2PrivateUniWeight4TList);
//	private IntegerTextField tfUtsDot3Onu2PrivateUniWeight4 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateUniWeight5VList = new int[] { 0, 1, 2, 3,
			4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, };
	private String[] utsDot3Onu2PrivateUniWeight5TList = new String[] {
			fStringMap.getString("notsupported"), "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "11", "12", "13", "14", "15", };
	private JComboBox tfUtsDot3Onu2PrivateUniWeight5 = new JComboBox(
			utsDot3Onu2PrivateUniWeight5TList);
//	private IntegerTextField tfUtsDot3Onu2PrivateUniWeight5 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateUniWeight6VList = new int[] { 0, 1, 2, 3,
			4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, };
	private String[] utsDot3Onu2PrivateUniWeight6TList = new String[] {
			fStringMap.getString("notsupported"), "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "11", "12", "13", "14", "15", };
	private JComboBox tfUtsDot3Onu2PrivateUniWeight6 = new JComboBox(
			utsDot3Onu2PrivateUniWeight6TList);
//	private IntegerTextField tfUtsDot3Onu2PrivateUniWeight6 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateUniWeight7VList = new int[] { 0, 1, 2, 3,
			4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, };
	private String[] utsDot3Onu2PrivateUniWeight7TList = new String[] {
			fStringMap.getString("notsupported"), "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "11", "12", "13", "14", "15", };
	private JComboBox tfUtsDot3Onu2PrivateUniWeight7 = new JComboBox(
			utsDot3Onu2PrivateUniWeight7TList);
//	private IntegerTextField tfUtsDot3Onu2PrivateUniWeight7 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniCos0 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniCos1 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniCos2 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniCos3 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniCos4 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniCos5 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniCos6 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniCos7 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateUniStormControlVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2PrivateUniStormControlTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsDot3Onu2PrivateUniStormControl = new JComboBox(
			utsDot3Onu2PrivateUniStormControlTList);
	private IntegerTextField tfUtsDot3Onu2PrivateUniBcRate = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniMcRate = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateUniDlfRate = new IntegerTextField();
	
	private int[] utsDot3Onu2PrivateUniSpeedVList = new int[] { 1, 2, 3, 4, };
	private String[] utsDot3Onu2PrivateUniSpeedTList = new String[] {
			fStringMap.getString("auto"), fStringMap.getString("speed-10mbps"),
			fStringMap.getString("speed-100mbps"),
			fStringMap.getString("speed-1000mbps"), };
	private JComboBox tfUtsDot3Onu2PrivateUniSpeed = new JComboBox(
			utsDot3Onu2PrivateUniSpeedTList);

	private int[] utsDot3Onu2PrivateUniDuplexVList = new int[] { 1, 2, 3, };
	private String[] utsDot3Onu2PrivateUniDuplexTList = new String[] {
			fStringMap.getString("auto"), fStringMap.getString("duplex-full"),
			fStringMap.getString("duplex-half"), };
	private JComboBox tfUtsDot3Onu2PrivateUniDuplex = new JComboBox(
			utsDot3Onu2PrivateUniDuplexTList);

//	private int[] utsDot3Onu2PrivateUniIsolateVList = new int[] { 1, 2, };
//	private String[] utsDot3Onu2PrivateUniIsolateTList = new String[] {
//			fStringMap.getString("true"), fStringMap.getString("false"), };
//	private JComboBox tfUtsDot3Onu2PrivateUniIsolate = new JComboBox(
//			utsDot3Onu2PrivateUniIsolateTList);

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
	private final String utsDot3Onu2PrivateUniSchedulingScheme = fStringMap
			.getString("utsDot3Onu2PrivateUniSchedulingScheme")
			+ " : ";
	private final String utsDot3Onu2PrivateUniWeight0 = fStringMap
			.getString("utsDot3Onu2PrivateUniWeight0")
			+ " : ";
	private final String utsDot3Onu2PrivateUniWeight1 = fStringMap
			.getString("utsDot3Onu2PrivateUniWeight1")
			+ " : ";
	private final String utsDot3Onu2PrivateUniWeight2 = fStringMap
			.getString("utsDot3Onu2PrivateUniWeight2")
			+ " : ";
	private final String utsDot3Onu2PrivateUniWeight3 = fStringMap
			.getString("utsDot3Onu2PrivateUniWeight3")
			+ " : ";
	private final String utsDot3Onu2PrivateUniWeight4 = fStringMap
			.getString("utsDot3Onu2PrivateUniWeight4")
			+ " : ";
	private final String utsDot3Onu2PrivateUniWeight5 = fStringMap
			.getString("utsDot3Onu2PrivateUniWeight5")
			+ " : ";
	private final String utsDot3Onu2PrivateUniWeight6 = fStringMap
			.getString("utsDot3Onu2PrivateUniWeight6")
			+ " : ";
	private final String utsDot3Onu2PrivateUniWeight7 = fStringMap
			.getString("utsDot3Onu2PrivateUniWeight7")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCos0 = fStringMap
			.getString("utsDot3Onu2PrivateUniCos0")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCos1 = fStringMap
			.getString("utsDot3Onu2PrivateUniCos1")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCos2 = fStringMap
			.getString("utsDot3Onu2PrivateUniCos2")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCos3 = fStringMap
			.getString("utsDot3Onu2PrivateUniCos3")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCos4 = fStringMap
			.getString("utsDot3Onu2PrivateUniCos4")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCos5 = fStringMap
			.getString("utsDot3Onu2PrivateUniCos5")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCos6 = fStringMap
			.getString("utsDot3Onu2PrivateUniCos6")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCos7 = fStringMap
			.getString("utsDot3Onu2PrivateUniCos7")
			+ " : ";
	private final String utsDot3Onu2PrivateUniStormControl = fStringMap
			.getString("utsDot3Onu2PrivateUniStormControl")
			+ " : ";
	private final String utsDot3Onu2PrivateUniBcRate = fStringMap
			.getString("utsDot3Onu2PrivateUniBcRate")
			+ " : ";
	private final String utsDot3Onu2PrivateUniMcRate = fStringMap
			.getString("utsDot3Onu2PrivateUniMcRate")
			+ " : ";
	private final String utsDot3Onu2PrivateUniDlfRate = fStringMap
			.getString("utsDot3Onu2PrivateUniDlfRate")
			+ " : ";
//	private final String utsDot3Onu2PrivateUniIsolate = fStringMap
//			.getString("utsDot3Onu2PrivateUniIsolate")
//			+ " : ";
	
	private final String utsDot3Onu2PrivateUniSpeed = fStringMap
			.getString("utsDot3Onu2PrivateUniSpeed")
			+ " : ";
	private final String utsDot3Onu2PrivateUniDuplex = fStringMap
			.getString("utsDot3Onu2PrivateUniDuplex")
			+ " : ";

	public Dot3Onu2PrivateUniOamTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(14, 5, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniModuleId);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPortId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPhyPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPhyPortId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniSchedulingScheme));
		tfUtsDot3Onu2PrivateUniSchedulingScheme.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniSchedulingScheme"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniSchedulingScheme);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniWeight0));
		tfUtsDot3Onu2PrivateUniWeight0.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniWeight0"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniWeight0);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniWeight1));
		tfUtsDot3Onu2PrivateUniWeight1.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniWeight1"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniWeight1);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniWeight2));
		tfUtsDot3Onu2PrivateUniWeight2.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniWeight2"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniWeight2);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniWeight3));
		tfUtsDot3Onu2PrivateUniWeight3.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniWeight3"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniWeight3);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniWeight4));
		tfUtsDot3Onu2PrivateUniWeight4.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniWeight4"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniWeight4);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniWeight5));
		tfUtsDot3Onu2PrivateUniWeight5.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniWeight5"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniWeight5);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniWeight6));
		tfUtsDot3Onu2PrivateUniWeight6.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniWeight6"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniWeight6);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniWeight7));
		tfUtsDot3Onu2PrivateUniWeight7.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniWeight7"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniWeight7);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCos0));
		tfUtsDot3Onu2PrivateUniCos0.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniCos0"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCos0);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCos1));
		tfUtsDot3Onu2PrivateUniCos1.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniCos1"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCos1);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCos2));
		tfUtsDot3Onu2PrivateUniCos2.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniCos2"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCos2);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCos3));
		tfUtsDot3Onu2PrivateUniCos3.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniCos3"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCos3);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCos4));
		tfUtsDot3Onu2PrivateUniCos4.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniCos4"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCos4);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCos5));
		tfUtsDot3Onu2PrivateUniCos5.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniCos5"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCos5);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCos6));
		tfUtsDot3Onu2PrivateUniCos6.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniCos6"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCos6);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCos7));
		tfUtsDot3Onu2PrivateUniCos7.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniCos7"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCos7);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniStormControl));
		tfUtsDot3Onu2PrivateUniStormControl.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniStormControl"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniStormControl);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniBcRate));
		tfUtsDot3Onu2PrivateUniBcRate.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniBcRate"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniBcRate);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniMcRate));
		tfUtsDot3Onu2PrivateUniMcRate.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniMcRate"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniMcRate);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniDlfRate));
		tfUtsDot3Onu2PrivateUniDlfRate.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniDlfRate"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniDlfRate);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniIsolate));
//		tfUtsDot3Onu2PrivateUniIsolate.setName(fStringMap
//				.getString("utsDot3Onu2PrivateUniIsolate"));
//		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniIsolate);
//		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniSpeed));
		tfUtsDot3Onu2PrivateUniSpeed.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniSpeed"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniSpeed);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniDuplex));
		tfUtsDot3Onu2PrivateUniDuplex.setName(fStringMap
				.getString("utsDot3Onu2PrivateUniDuplex"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniDuplex);
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

//		tfUtsDot3Onu2PrivateUniWeight0.setValueScope(1, 15);

//		tfUtsDot3Onu2PrivateUniWeight1.setValueScope(1, 15);

//		tfUtsDot3Onu2PrivateUniWeight2.setValueScope(1, 15);

//		tfUtsDot3Onu2PrivateUniWeight3.setValueScope(1, 15);

//		tfUtsDot3Onu2PrivateUniWeight4.setValueScope(1, 15);

//		tfUtsDot3Onu2PrivateUniWeight5.setValueScope(1, 15);

//		tfUtsDot3Onu2PrivateUniWeight6.setValueScope(1, 15);

//		tfUtsDot3Onu2PrivateUniWeight7.setValueScope(1, 15);

		tfUtsDot3Onu2PrivateUniCos0.setValueScope(0, 3);

		tfUtsDot3Onu2PrivateUniCos1.setValueScope(0, 3);

		tfUtsDot3Onu2PrivateUniCos2.setValueScope(0, 3);

		tfUtsDot3Onu2PrivateUniCos3.setValueScope(0, 3);

		tfUtsDot3Onu2PrivateUniCos4.setValueScope(0, 3);

		tfUtsDot3Onu2PrivateUniCos5.setValueScope(0, 3);

		tfUtsDot3Onu2PrivateUniCos6.setValueScope(0, 3);

		tfUtsDot3Onu2PrivateUniCos7.setValueScope(0, 3);

		tfUtsDot3Onu2PrivateUniBcRate.setValueScope(0, Integer.MAX_VALUE);

		tfUtsDot3Onu2PrivateUniMcRate.setValueScope(0, Integer.MAX_VALUE);

		tfUtsDot3Onu2PrivateUniDlfRate.setValueScope(0, Integer.MAX_VALUE);

	}
	
	public boolean validateFrom() {
        
		Integer tBcRate = tfUtsDot3Onu2PrivateUniBcRate.getValue();
		if ((tBcRate.intValue() > 0 && tBcRate.intValue() < 255)
				|| (tBcRate.intValue() > 100000)) {
			MessageDialog.showInfoMessageDialog(fApplication,
					fStringMap.getString("utsDot3Onu2PrivateUniBcRate")
							+ fStringMap.getString("Err_Dot3Onu2PrivateUni_Value"));
			return false;
		} 
		
		Integer tMcRate = tfUtsDot3Onu2PrivateUniMcRate.getValue();
		if ((tMcRate.intValue() > 0 && tMcRate.intValue() < 255)
				|| (tMcRate.intValue() > 100000)) {
			MessageDialog.showInfoMessageDialog(fApplication,
					fStringMap.getString("utsDot3Onu2PrivateUniMcRate")
							+ fStringMap.getString("Err_Dot3Onu2PrivateUni_Value"));
			return false;
		}
		
		Integer tDlfRate = tfUtsDot3Onu2PrivateUniDlfRate.getValue();
		if ((tDlfRate.intValue() > 0 && tDlfRate.intValue() < 255)
				|| (tDlfRate.intValue() > 100000)) {
			MessageDialog.showInfoMessageDialog(fApplication,
					fStringMap.getString("utsDot3Onu2PrivateUniDlfRate")
							+ fStringMap.getString("Err_Dot3Onu2PrivateUni_Value"));
			return false;
		}
		
		return true;
            
        
	}

	public void refresh() {

		Dot3Onu2PrivateUniOamTable mbean = (Dot3Onu2PrivateUniOamTable) getModel();

		tfUtsDot3Onu2Ctc3UniModuleId.setText(mbean
				.getUtsDot3Onu2Ctc3UniModuleId().toString());
//		tfUtsDot3Onu2Ctc3UniDeviceId.setText(mbean
//				.getUtsDot3Onu2Ctc3UniDeviceId().toString());
		tfUtsDot3Onu2Ctc3UniPortId.setText(mbean.getUtsDot3Onu2Ctc3UniPortId()
				.toString());
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniLogicalPortId().toString());
		tfUtsDot3Onu2Ctc3UniPhyPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniPhyPortId().toString());
		tfUtsDot3Onu2PrivateUniSchedulingScheme
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateUniSchedulingSchemeVList, mbean
								.getUtsDot3Onu2PrivateUniSchedulingScheme()
								.intValue()));
		tfUtsDot3Onu2PrivateUniWeight0.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniWeight0VList, mbean
						.getUtsDot3Onu2PrivateUniWeight0().intValue()));
//		tfUtsDot3Onu2PrivateUniWeight0.setValue(mbean
//				.getUtsDot3Onu2PrivateUniWeight0().intValue());
		tfUtsDot3Onu2PrivateUniWeight1.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniWeight1VList, mbean
						.getUtsDot3Onu2PrivateUniWeight1().intValue()));
//		tfUtsDot3Onu2PrivateUniWeight1.setValue(mbean
//				.getUtsDot3Onu2PrivateUniWeight1().intValue());
		tfUtsDot3Onu2PrivateUniWeight2.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniWeight2VList, mbean
						.getUtsDot3Onu2PrivateUniWeight2().intValue()));
//		tfUtsDot3Onu2PrivateUniWeight2.setValue(mbean
//				.getUtsDot3Onu2PrivateUniWeight2().intValue());
		tfUtsDot3Onu2PrivateUniWeight3.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniWeight3VList, mbean
						.getUtsDot3Onu2PrivateUniWeight3().intValue()));
//		tfUtsDot3Onu2PrivateUniWeight3.setValue(mbean
//				.getUtsDot3Onu2PrivateUniWeight3().intValue());
		tfUtsDot3Onu2PrivateUniWeight4.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniWeight4VList, mbean
						.getUtsDot3Onu2PrivateUniWeight4().intValue()));
//		tfUtsDot3Onu2PrivateUniWeight4.setValue(mbean
//				.getUtsDot3Onu2PrivateUniWeight4().intValue());
		tfUtsDot3Onu2PrivateUniWeight5.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniWeight5VList, mbean
						.getUtsDot3Onu2PrivateUniWeight5().intValue()));
//		tfUtsDot3Onu2PrivateUniWeight5.setValue(mbean
//				.getUtsDot3Onu2PrivateUniWeight5().intValue());
		tfUtsDot3Onu2PrivateUniWeight6.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniWeight6VList, mbean
						.getUtsDot3Onu2PrivateUniWeight6().intValue()));
//		tfUtsDot3Onu2PrivateUniWeight6.setValue(mbean
//				.getUtsDot3Onu2PrivateUniWeight6().intValue());
		tfUtsDot3Onu2PrivateUniWeight7.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniWeight7VList, mbean
						.getUtsDot3Onu2PrivateUniWeight7().intValue()));
//		tfUtsDot3Onu2PrivateUniWeight7.setValue(mbean
//				.getUtsDot3Onu2PrivateUniWeight7().intValue());
		tfUtsDot3Onu2PrivateUniCos0.setValue(mbean
				.getUtsDot3Onu2PrivateUniCos0().intValue());
		tfUtsDot3Onu2PrivateUniCos1.setValue(mbean
				.getUtsDot3Onu2PrivateUniCos1().intValue());
		tfUtsDot3Onu2PrivateUniCos2.setValue(mbean
				.getUtsDot3Onu2PrivateUniCos2().intValue());
		tfUtsDot3Onu2PrivateUniCos3.setValue(mbean
				.getUtsDot3Onu2PrivateUniCos3().intValue());
		tfUtsDot3Onu2PrivateUniCos4.setValue(mbean
				.getUtsDot3Onu2PrivateUniCos4().intValue());
		tfUtsDot3Onu2PrivateUniCos5.setValue(mbean
				.getUtsDot3Onu2PrivateUniCos5().intValue());
		tfUtsDot3Onu2PrivateUniCos6.setValue(mbean
				.getUtsDot3Onu2PrivateUniCos6().intValue());
		tfUtsDot3Onu2PrivateUniCos7.setValue(mbean
				.getUtsDot3Onu2PrivateUniCos7().intValue());
		tfUtsDot3Onu2PrivateUniStormControl.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniStormControlVList, mbean
						.getUtsDot3Onu2PrivateUniStormControl().intValue()));
		tfUtsDot3Onu2PrivateUniBcRate.setValue(mbean
				.getUtsDot3Onu2PrivateUniBcRate().intValue());
		tfUtsDot3Onu2PrivateUniMcRate.setValue(mbean
				.getUtsDot3Onu2PrivateUniMcRate().intValue());
		tfUtsDot3Onu2PrivateUniDlfRate.setValue(mbean
				.getUtsDot3Onu2PrivateUniDlfRate().intValue());
//		tfUtsDot3Onu2PrivateUniIsolate.setSelectedIndex(getIndexFromValue(
//				utsDot3Onu2PrivateUniIsolateVList, mbean
//						.getUtsDot3Onu2PrivateUniIsolate().intValue()));
		tfUtsDot3Onu2PrivateUniSpeed.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniSpeedVList, mbean
						.getUtsDot3Onu2PrivateUniSpeed().intValue()));
		tfUtsDot3Onu2PrivateUniDuplex.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateUniDuplexVList, mbean
						.getUtsDot3Onu2PrivateUniDuplex().intValue()));

	}

	public void updateModel() {

		Dot3Onu2PrivateUniOamTable mbean = (Dot3Onu2PrivateUniOamTable) getModel();

		mbean
				.setUtsDot3Onu2PrivateUniSchedulingScheme(new Integer(
						utsDot3Onu2PrivateUniSchedulingSchemeVList[tfUtsDot3Onu2PrivateUniSchedulingScheme
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2PrivateUniWeight0(new Integer(
						utsDot3Onu2PrivateUniWeight0VList[tfUtsDot3Onu2PrivateUniWeight0
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2PrivateUniWeight0(new Integer(
//				tfUtsDot3Onu2PrivateUniWeight0.getValue()));
		mbean
				.setUtsDot3Onu2PrivateUniWeight1(new Integer(
						utsDot3Onu2PrivateUniWeight1VList[tfUtsDot3Onu2PrivateUniWeight1
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2PrivateUniWeight1(new Integer(
//				tfUtsDot3Onu2PrivateUniWeight1.getValue()));
		mbean
				.setUtsDot3Onu2PrivateUniWeight2(new Integer(
						utsDot3Onu2PrivateUniWeight2VList[tfUtsDot3Onu2PrivateUniWeight2
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2PrivateUniWeight2(new Integer(
//				tfUtsDot3Onu2PrivateUniWeight2.getValue()));
		mbean
				.setUtsDot3Onu2PrivateUniWeight3(new Integer(
						utsDot3Onu2PrivateUniWeight3VList[tfUtsDot3Onu2PrivateUniWeight3
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2PrivateUniWeight3(new Integer(
//				tfUtsDot3Onu2PrivateUniWeight3.getValue()));
		mbean
				.setUtsDot3Onu2PrivateUniWeight4(new Integer(
						utsDot3Onu2PrivateUniWeight4VList[tfUtsDot3Onu2PrivateUniWeight4
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2PrivateUniWeight4(new Integer(
//				tfUtsDot3Onu2PrivateUniWeight4.getValue()));
		mbean
				.setUtsDot3Onu2PrivateUniWeight5(new Integer(
						utsDot3Onu2PrivateUniWeight5VList[tfUtsDot3Onu2PrivateUniWeight5
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2PrivateUniWeight5(new Integer(
//				tfUtsDot3Onu2PrivateUniWeight5.getValue()));
		mbean
				.setUtsDot3Onu2PrivateUniWeight6(new Integer(
						utsDot3Onu2PrivateUniWeight6VList[tfUtsDot3Onu2PrivateUniWeight6
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2PrivateUniWeight6(new Integer(
//				tfUtsDot3Onu2PrivateUniWeight6.getValue()));
		mbean
				.setUtsDot3Onu2PrivateUniWeight7(new Integer(
						utsDot3Onu2PrivateUniWeight7VList[tfUtsDot3Onu2PrivateUniWeight7
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2PrivateUniWeight7(new Integer(
//				tfUtsDot3Onu2PrivateUniWeight7.getValue()));
		mbean.setUtsDot3Onu2PrivateUniCos0(new Integer(
				tfUtsDot3Onu2PrivateUniCos0.getValue()));
		mbean.setUtsDot3Onu2PrivateUniCos1(new Integer(
				tfUtsDot3Onu2PrivateUniCos1.getValue()));
		mbean.setUtsDot3Onu2PrivateUniCos2(new Integer(
				tfUtsDot3Onu2PrivateUniCos2.getValue()));
		mbean.setUtsDot3Onu2PrivateUniCos3(new Integer(
				tfUtsDot3Onu2PrivateUniCos3.getValue()));
		mbean.setUtsDot3Onu2PrivateUniCos4(new Integer(
				tfUtsDot3Onu2PrivateUniCos4.getValue()));
		mbean.setUtsDot3Onu2PrivateUniCos5(new Integer(
				tfUtsDot3Onu2PrivateUniCos5.getValue()));
		mbean.setUtsDot3Onu2PrivateUniCos6(new Integer(
				tfUtsDot3Onu2PrivateUniCos6.getValue()));
		mbean.setUtsDot3Onu2PrivateUniCos7(new Integer(
				tfUtsDot3Onu2PrivateUniCos7.getValue()));
		mbean
				.setUtsDot3Onu2PrivateUniStormControl(new Integer(
						utsDot3Onu2PrivateUniStormControlVList[tfUtsDot3Onu2PrivateUniStormControl
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateUniBcRate(new Long(
				tfUtsDot3Onu2PrivateUniBcRate.getValue()));
		mbean.setUtsDot3Onu2PrivateUniMcRate(new Long(
				tfUtsDot3Onu2PrivateUniMcRate.getValue()));
		mbean.setUtsDot3Onu2PrivateUniDlfRate(new Long(
				tfUtsDot3Onu2PrivateUniDlfRate.getValue()));
//		mbean
//				.setUtsDot3Onu2PrivateUniIsolate(new Integer(
//						utsDot3Onu2PrivateUniIsolateVList[tfUtsDot3Onu2PrivateUniIsolate
//								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateUniSpeed(new Integer(
				utsDot3Onu2PrivateUniSpeedVList[tfUtsDot3Onu2PrivateUniSpeed
						.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateUniDuplex(new Integer(
				utsDot3Onu2PrivateUniDuplexVList[tfUtsDot3Onu2PrivateUniDuplex
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

/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.NeFileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.UtsOnuUpgradeRuleTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * The UtsOnuUpgradeRuleTablePanel class. Created by DVM Creator
 */
public class UtsOnuUpgradeRuleTablePanel extends UPanel {

	// private int[] utsOnuUpgradeRuleOnuTypeVList = new int[] { 103, 78, 29,
	// 95, 20, 40, 25, 15, 82, 96, 85, 79, 9, 16, 36, 75, 4, 72, 92, 1, 7, 42,
	// 93, 18, 30, 71, 14, 98, 13, 27, 99, 200, 12, 35, 100, 90, 32, 5, 3, 23,
	// 84, 91, 94, 11, 86, 31, 34, 73, 102, 81, 24, 21, 2, 80, 10, 61, 38, 77,
	// 41, 101, 88, 89, 26, 62, 33, 17, 76, 8, 19, 28, 74, 22, 39, 83, 6, 97, };
	// private String[] utsOnuUpgradeRuleOnuTypeTList = new String[] {
	// fStringMap.getString("onu204i-k7"),
	// fStringMap.getString("onu4016i-tA1S"), fStringMap.getString("onu804i"),
	// fStringMap.getString("onu204i-k2"), fStringMap.getString("clt2060"),
	// fStringMap.getString("onub1205d"), fStringMap.getString("onu2024i"),
	// fStringMap.getString("onu1001C"), fStringMap.getString("onu4024ia2b"),
	// fStringMap.getString("onu204i-k3"), fStringMap.getString("onu204ie"),
	// fStringMap.getString("onu208p"), fStringMap.getString("onu301"),
	// fStringMap.getString("onu3004"), fStringMap.getString("onu4024i"),
	// fStringMap.getString("onu4016i-t"), fStringMap.getString("onu200A"),
	// fStringMap.getString("onu404h"), fStringMap.getString("onu404i-c2"),
	// fStringMap.getString("onu100"), fStringMap.getString("onu2004"),
	// fStringMap.getString("onub1205"), fStringMap.getString("onu204i-h1"),
	// fStringMap.getString("onu2004i"), fStringMap.getString("onu101"),
	// fStringMap.getString("onu2004-2"), fStringMap.getString("onu804C"),
	// fStringMap.getString("onu804i-c1"), fStringMap.getString("onu804"),
	// fStringMap.getString("onu1001h"), fStringMap.getString("onu804i-c2"),
	// fStringMap.getString("unknow"), fStringMap.getString("onu404C"),
	// fStringMap.getString("onu4024t"), fStringMap.getString("tkOnu"),
	// fStringMap.getString("onu204i-c2"), fStringMap.getString("onu2004h"),
	// fStringMap.getString("onu200B"), fStringMap.getString("onu1000C"),
	// fStringMap.getString("onu204h"), fStringMap.getString("onub1202"),
	// fStringMap.getString("onu404i-c1"), fStringMap.getString("onu204i-k1"),
	// fStringMap.getString("onu404"),
	// fStringMap.getString("onu204ih"), fStringMap.getString("onu1001b"),
	// fStringMap.getString("onu404t"), fStringMap.getString("onu208h"),
	// fStringMap.getString("onu101i-c1"), fStringMap.getString("onu4024ia1s"),
	// fStringMap.getString("onu408t"), fStringMap.getString("onu204i"),
	// fStringMap.getString("onu1000B"), fStringMap.getString("onu4024ia1b"),
	// fStringMap.getString("onu301C"), fStringMap.getString("ont952"),
	// fStringMap.getString("onu101i"), fStringMap.getString("onu4016i-tA1B"),
	// fStringMap.getString("onub130"), fStringMap.getString("pmcOnu"),
	// fStringMap.getString("onu2024i-c1"), fStringMap.getString("onu204i-c1"),
	// fStringMap.getString("onub210"), fStringMap.getString("ont958"),
	// fStringMap.getString("onu204d"), fStringMap.getString("onu1001i"),
	// fStringMap.getString("onu2016i-e"),
	// fStringMap.getString("onu101K"), fStringMap.getString("onu404i"),
	// fStringMap.getString("onub220"), fStringMap.getString("onu4016i"),
	// fStringMap.getString("onu208i"), fStringMap.getString("onub1205y"),
	// fStringMap.getString("onu4024ia2s"), fStringMap.getString("onu2024"),
	// fStringMap.getString("onu204i-k4"), };
	/**
	 * HwType: onu100(1) onu1000B(2) onu1000C(3) onu200A(4) onu200B(5)
	 * onu2024(6) onu2004(7) onu101K(8) onu301(9) onu301C(10) onu404(11)
	 * onu404C(12) onu804(13) onu804C(14) onu1001C(15) onu3004(16) onu1001i(17)
	 * onu2004i(18) onu404i(19) clt2060(20) onu204i(21) onu208i(22) onu204h(23)
	 * onu408t(24) onu2024i(25) onub210(26) onu1001h(27) onub220(28) onu804i(29)
	 * onu101(30) onu1001b(31) onu2004h(32) onu204d(33) onu404t(34) onu4024t(35)
	 * onu4024i(36) onu101i(38) onub1205y(39) onub1205d(40) onub130(41)
	 * onub1205(42) ont1001t(61) ont408t(62) tkOnu(100) pmcOnu(101) unknow(200)
	 * onu2004-2(71) onu404h(72) onu208h(73) onu4016i(74) onu4016i-t(75)
	 * onu2016i-e(76) onu4016i-tA1B(77) onu4016i-tA1S(78) ONU208p(79)
	 * ONU204i-e(85) ONU204i-h(86) tkOnu(100) pmcOnu(101) unknow(200)
	 */
//	private int[] utsOnuUpgradeRuleOnuTypeVList = new int[] {// 302, 303, 301,//
//			// TODO only for
//			// hhjs OEM
//			17, 38, 71, 18, 76, 25, 21, 85, 86, 89, 93, 94, 95, 97, 104, 103,
//			108, 73, 22, 79, 75, 77, 78, 36, 19, 91, 24, 29, 98, 84, 42, 40,
//			39, 41, 105, 106, 301, 302, 303, 107, 401, 402, };
	/*
	 * private String[] utsOnuUpgradeRuleOnuTypeTList = new String[] {
	 * 
	 * // fStringMap.getString("clt2060"), // 20
	 * 
	 * // TODO only for hhjs OEM // fStringMap.getString("js04h-v"), // 302 //
	 * fStringMap.getString("js16b-v"), // 303 //
	 * fStringMap.getString("js24b-v"), // 301
	 * 
	 * // fStringMap.getString("ont952"), // 61 //
	 * fStringMap.getString("ont958"), // 62 // fStringMap.getString("onu100"),
	 * // 1 // fStringMap.getString("onu1000B"), // 2 //
	 * fStringMap.getString("onu1000C"), // 3 //
	 * fStringMap.getString("onu1001C"), // 15 //
	 * fStringMap.getString("onu1001b"), // 31 //
	 * fStringMap.getString("onu1001h"), // 27 fStringMap.getString("onu1001i"),
	 * // 17 // fStringMap.getString("onu101"), // 30 //
	 * fStringMap.getString("onu101K"), // 8 fStringMap.getString("onu101i"), //
	 * 38 // fStringMap.getString("onu101i-c1"), // 102 //
	 * fStringMap.getString("onu2004"), // 7 fStringMap.getString("onu2004-2"),
	 * // 71 // fStringMap.getString("onu2004h"), // 32
	 * fStringMap.getString("onu2004i"), // 18 //
	 * fStringMap.getString("onu200A"), // 4 // fStringMap.getString("onu200B"),
	 * // 5 fStringMap.getString("onu2016i-e"), // 76 //
	 * fStringMap.getString("onu2024"), // 6 fStringMap.getString("onu2024i"),
	 * // 25 // fStringMap.getString("onu2024i-c1"), // 88 //
	 * fStringMap.getString("onu204d"), // 33 //
	 * fStringMap.getString("onu204h"), // 23 fStringMap.getString("onu204i"),
	 * // 21 fStringMap.getString("onu204ie"), // 85
	 * fStringMap.getString("onu204ih"), // 86
	 * fStringMap.getString("onu204i-h-R-c1"), // 89 //
	 * fStringMap.getString("onu204i-h-R-c2"), // 90
	 * fStringMap.getString("onu204i-h-R-h1"), // 93
	 * fStringMap.getString("onu204i-k7-R-a1"), // 94
	 * fStringMap.getString("onu204i-k7-R-a2"), // 95 //
	 * fStringMap.getString("onu204i-k7-R-a3"), // 96
	 * fStringMap.getString("onu204i-k7-R-a4"), // 97
	 * fStringMap.getString("onu204i-k7-R-a5"), // 104
	 * fStringMap.getString("onu204i-k7-R-a7"), // 103
	 * fStringMap.getString("onu204i-k7-R-b2"), // 108
	 * fStringMap.getString("onu208h"), // 73 fStringMap.getString("onu208i"),
	 * // 22 fStringMap.getString("onu208p"), // 79 //
	 * fStringMap.getString("onu3004"), // 16 // fStringMap.getString("onu301"),
	 * // 9 // fStringMap.getString("onu301C"), // 10 //
	 * fStringMap.getString("onu4016i"), // 74
	 * fStringMap.getString("onu4016i-t"), // 75
	 * fStringMap.getString("onu4016i-tA1B"), // 77
	 * fStringMap.getString("onu4016i-tA1S"), // 78
	 * fStringMap.getString("onu4024i"), // 36 //
	 * fStringMap.getString("onu4024ia1b"), // 80 //
	 * fStringMap.getString("onu4024ia1s"), // 81 //
	 * fStringMap.getString("onu4024ia2b"), // 82 //
	 * fStringMap.getString("onu4024ia2s"), // 83 //
	 * fStringMap.getString("onu4024t"), // 35 //
	 * fStringMap.getString("onu404"), // 11 // fStringMap.getString("onu404C"),
	 * // 12 // fStringMap.getString("onu404h"), // 72
	 * fStringMap.getString("onu404i"), // 19
	 * fStringMap.getString("onu404i-R-c1"), // 91 //
	 * fStringMap.getString("onu404i-R-c2"), // 92 //
	 * fStringMap.getString("onu404t"), // 34 fStringMap.getString("onu408t"),
	 * // 24 // fStringMap.getString("onu804"), // 13 //
	 * fStringMap.getString("onu804C"), // 14 fStringMap.getString("onu804i"),
	 * // 29 fStringMap.getString("onu804i-R-c1"), // 98 //
	 * fStringMap.getString("onu804i-R-c2"), // 99
	 * fStringMap.getString("onub1202"), // 84 fStringMap.getString("onub1205"),
	 * // 42 fStringMap.getString("onub1205d"), // 40
	 * fStringMap.getString("onub1205y"), // 39 fStringMap.getString("onub130"),
	 * // 41 // fStringMap.getString("onub210"), // 26 //
	 * fStringMap.getString("onub220"), // 28 // fStringMap.getString("pmcOnu"),
	 * // 101 // fStringMap.getString("tkOnu"), // 100 //
	 * fStringMap.getString("unknow"), // 200
	 * 
	 * fStringMap.getString("CLT2168"), // 105 fStringMap.getString("CLT2170"),
	 * // 106
	 * 
	 * fStringMap.getString("js24b-v"), // 301 fStringMap.getString("js04h-v"),
	 * // 302 fStringMap.getString("js16b-v"), // 303
	 * 
	 * fStringMap.getString("onu-c3160"), // 107 fStringMap.getString("s1201"),
	 * // 401 fStringMap.getString("s1202"), // 402 };
	 */
	// private JComboBox tfUtsOnuUpgradeRuleOnuType = new
	// JComboBox(utsOnuUpgradeRuleOnuTypeTList);
	// private JComboBox tfUtsOnuUpgradeRuleOnuType = new JComboBox();

	// private int[] utsOnuUpgradeRuleHwCompVList = new int[] { 1, 2, 3, 4, 5,
	// };
	// private String[] utsOnuUpgradeRuleHwCompTList = new String[] {
	// fStringMap.getString("pon"), fStringMap.getString("switch"),
	// fStringMap.getString("voip"), fStringMap.getString("unified"),
	// fStringMap.getString("bootloader"), };

	// private int[] utsOnuUpgradeRuleHwCompVList = new int[] { 1 };
	// private String[] utsOnuUpgradeRuleHwCompTList = new String[] {
	// fStringMap.getString("hwcomp") };
	// private JComboBox tfUtsOnuUpgradeRuleHwComp = new
	// JComboBox(utsOnuUpgradeRuleHwCompTList);

	private int[] utsOnuUpgradeRuleUpgradeMethodVList = new int[] { 1, 2, 3, };
	private String[] utsOnuUpgradeRuleUpgradeMethodTList = new String[] {
			fStringMap.getString("manual"), fStringMap.getString("schedule"),
			fStringMap.getString("auto"), };
	private JComboBox tfUtsOnuUpgradeRuleUpgradeMethod = new JComboBox(
			utsOnuUpgradeRuleUpgradeMethodTList);

	private StringTextField tfUtsOnuUpgradeRuleSwVersino = new StringTextField();

	private StringTextField tfUtsOnuUpgradeRuleFtpPath = new StringTextField();

//	private IPAddressField tfUtsOnuUpgradeRuleFtpServerIp = new IPAddressField();
//
//	private StringTextField tfUtsOnuUpgradeRuleFtpUsername = new StringTextField();
//
//	private StringTextField tfUtsOnuUpgradeRuleFtpPassword = new StringTextField();
	
	private JButton btFileChooser = new JButton("...");

	// private int[] utsOnuUpgradeRuleRowStatusVList = new int[] { 1, 2, 5, 4,
	// 3, 6, };
	// private String[] utsOnuUpgradeRuleRowStatusTList = new String[] {
	// fStringMap.getString("active"), fStringMap.getString("notInService"),
	// fStringMap.getString("createAndWait"),
	// fStringMap.getString("createAndGo"), fStringMap.getString("notReady"),
	// fStringMap.getString("destroy"), };
	// private JComboBox tfUtsOnuUpgradeRuleRowStatus = new
	// JComboBox(utsOnuUpgradeRuleRowStatusTList);

	// private JButton btFileChooser = new JButton("...");

	// private final String utsOnuUpgradeRuleOnuType =
	// fStringMap.getString("utsOnuUpgradeRuleOnuType") + " : ";
	// private final String utsOnuUpgradeRuleHwComp =
	// fStringMap.getString("utsOnuUpgradeRuleHwComp") + " : ";
	private final String utsOnuUpgradeRuleUpgradeMethod = fStringMap
			.getString("utsOnuUpgradeRuleUpgradeMethod") + " : ";
	private final String utsOnuUpgradeRuleSwVersino = fStringMap
			.getString("utsOnuUpgradeRuleSwVersino") + " : ";
	private final String utsOnuUpgradeRuleFtpPath = fStringMap
			.getString("utsOnuUpgradeRuleFtpPath") + " : ";
//	private final String utsOnuUpgradeRuleFtpServerIp = fStringMap
//			.getString("utsOnuUpgradeRuleFtpServerIp") + " : ";
//	private final String utsOnuUpgradeRuleFtpUsername = fStringMap
//			.getString("utsOnuUpgradeRuleFtpUsername") + " : ";
//	private final String utsOnuUpgradeRuleFtpPassword = fStringMap
//			.getString("utsOnuUpgradeRuleFtpPassword") + " : ";
	
	private boolean isFtp = true;

	public UtsOnuUpgradeRuleTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		// baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleOnuType));
		// Vector<String> types= new Vector<String>();
		// for(int i = 1; i< 50; i++ ) {
		// types.add("ONU-" + i/10 + "-" + i%10);
		// }
		// tfUtsOnuUpgradeRuleOnuType.setModel(new DefaultComboBoxModel(types));
		// baseInfoPanel.add(tfUtsOnuUpgradeRuleOnuType);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleHwComp));
		// baseInfoPanel.add(tfUtsOnuUpgradeRuleHwComp);
		// baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleUpgradeMethod));
		tfUtsOnuUpgradeRuleUpgradeMethod.setName(fStringMap
				.getString("utsOnuUpgradeRuleUpgradeMethod"));
		baseInfoPanel.add(tfUtsOnuUpgradeRuleUpgradeMethod);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleSwVersino));
		tfUtsOnuUpgradeRuleSwVersino.setName(fStringMap
				.getString("utsOnuUpgradeRuleSwVersino"));
		baseInfoPanel.add(tfUtsOnuUpgradeRuleSwVersino);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleFtpPath));
		tfUtsOnuUpgradeRuleFtpPath.setName(fStringMap
				.getString("utsOnuUpgradeRuleFtpPath"));

		JPanel filechoose = new JPanel();
		layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
		filechoose.setLayout(layout);
		filechoose.add(tfUtsOnuUpgradeRuleFtpPath);
		filechoose.add(btFileChooser);
		btFileChooser.setPreferredSize(new Dimension(20, 20));
		baseInfoPanel.add(filechoose);
		baseInfoPanel.add(new HSpacer());

		btFileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NeFileChooser chooser = new NeFileChooser(fApplication, (JDialog)
						SwingUtilities.getWindowAncestor(UtsOnuUpgradeRuleTablePanel.this),
							new String[] { "flash:/onuImage" });
				chooser.show();
				if (chooser.getSelectedFile() != null) {
					tfUtsOnuUpgradeRuleFtpPath.setValue("flash:/onuImage/"+chooser.getSelectedFile().getName());
				}
			}
		});

//		baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleFtpPath));
//		tfUtsOnuUpgradeRuleFtpPath.setName(fStringMap
//				.getString("utsOnuUpgradeRuleFtpPath"));
//
//		JPanel filechoose = new JPanel();
//		layout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
//		filechoose.setLayout(layout);
//		filechoose.add(tfUtsOnuUpgradeRuleFtpPath);
//		// filechoose.add(btFileChooser);
//		// btFileChooser.setPreferredSize(new Dimension(20, 20));
//		baseInfoPanel.add(filechoose);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleFtpServerIp));
//		tfUtsOnuUpgradeRuleFtpServerIp.setName(fStringMap
//				.getString("utsOnuUpgradeRuleFtpServerIp"));
//		baseInfoPanel.add(tfUtsOnuUpgradeRuleFtpServerIp);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleFtpUsername));
//		tfUtsOnuUpgradeRuleFtpUsername.setName(fStringMap
//				.getString("utsOnuUpgradeRuleFtpUsername"));
//		baseInfoPanel.add(tfUtsOnuUpgradeRuleFtpUsername);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsOnuUpgradeRuleFtpPassword));
//		tfUtsOnuUpgradeRuleFtpPassword.setName(fStringMap
//				.getString("utsOnuUpgradeRuleFtpPassword"));
//		baseInfoPanel.add(tfUtsOnuUpgradeRuleFtpPassword);
//		baseInfoPanel.add(new HSpacer());

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

		tfUtsOnuUpgradeRuleSwVersino.setLenScope(0, 255);

		tfUtsOnuUpgradeRuleFtpPath.setLenScope(0, 63);

//		tfUtsOnuUpgradeRuleFtpUsername.setLenScope(0, 31);
//
//		tfUtsOnuUpgradeRuleFtpPassword.setLenScope(0, 31);

		// tfUtsOnuUpgradeRuleOnuType.addItemListener(new ItemListener() {
		// //TODO..
		// public void itemStateChanged(ItemEvent e) {
		// setOnuUpgradeRuleHwCompByType();
		// }
		// });

	}

	public void refresh() {
		if (SnmpAction.IType.ADD.equals(fCommand)) {
			// setOnuUpgradeRuleHwCompByType();
			return;
		}
		UtsOnuUpgradeRuleTable mbean = (UtsOnuUpgradeRuleTable) getModel();

		// tfUtsOnuUpgradeRuleOnuType.setSelectedIndex(getIndexFromValue(utsOnuUpgradeRuleOnuTypeVList,
		// mbean.getUtsOnuUpgradeRuleOnuType().intValue()));
		// tfUtsOnuUpgradeRuleHwComp.setSelectedIndex(getIndexFromValue(utsOnuUpgradeRuleHwCompVList,
		// mbean.getUtsOnuUpgradeRuleHwComp().intValue()));

		// tfUtsOnuUpgradeRuleOnuType.setSelectedIndex(mbean.getUtsOnuUpgradeRuleOnuType()-1);
		// tfUtsOnuUpgradeRuleHwComp.setSelectedIndex(0);
		tfUtsOnuUpgradeRuleUpgradeMethod.setSelectedIndex(getIndexFromValue(
				utsOnuUpgradeRuleUpgradeMethodVList, mbean
						.getUtsOnuUpgradeRuleUpgradeMethod().intValue()));
		tfUtsOnuUpgradeRuleSwVersino.setValue(mbean
				.getUtsOnuUpgradeRuleSwVersino());
		tfUtsOnuUpgradeRuleFtpPath
				.setValue(mbean.getUtsOnuUpgradeRuleFtpPath());
//		tfUtsOnuUpgradeRuleFtpServerIp.setValue(mbean
//				.getUtsOnuUpgradeRuleFtpServerIp());
//		tfUtsOnuUpgradeRuleFtpUsername.setValue(mbean
//				.getUtsOnuUpgradeRuleFtpUsername());
//		tfUtsOnuUpgradeRuleFtpPassword.setValue(mbean
//				.getUtsOnuUpgradeRuleFtpPassword());
		// tfUtsOnuUpgradeRuleRowStatus.setSelectedIndex(getIndexFromValue(utsOnuUpgradeRuleRowStatusVList,
		// mbean.getUtsOnuUpgradeRuleRowStatus().intValue()));
		// setOnuUpgradeRuleHwCompByType();
	}

	public void updateModel() {

		if (SnmpAction.IType.ADD.equals(fCommand))
			setModel(new UtsOnuUpgradeRuleTable(fApplication.getSnmpProxy()));

		UtsOnuUpgradeRuleTable mbean = (UtsOnuUpgradeRuleTable) getModel();

		if (SnmpAction.IType.ADD.equals(fCommand)) {
			// mbean.setUtsOnuUpgradeRuleOnuType(n/ew
			// Integer(utsOnuUpgradeRuleOnuTypeVList[tfUtsOnuUpgradeRuleOnuType.getSelectedIndex()]));
			// mbean.setUtsOnuUpgradeRuleHwComp(new
			// Integer(utsOnuUpgradeRuleHwCompVList[tfUtsOnuUpgradeRuleHwComp.getSelectedIndex()]));
			// mbean.setUtsOnuUpgradeRuleOnuType(tfUtsOnuUpgradeRuleOnuType.getSelectedIndex()+1);
			mbean.setUtsOnuUpgradeRuleOnuType(1);
			mbean.setUtsOnuUpgradeRuleHwComp(1);
			mbean.setUtsOnuUpgradeRuleUpgradeMethod(new Integer(
					utsOnuUpgradeRuleUpgradeMethodVList[tfUtsOnuUpgradeRuleUpgradeMethod
							.getSelectedIndex()]));
		}

		mbean.setUtsOnuUpgradeRuleSwVersino(new String(
				tfUtsOnuUpgradeRuleSwVersino.getValue()));
		mbean.setUtsOnuUpgradeRuleFtpPath(new String(tfUtsOnuUpgradeRuleFtpPath
				.getValue()));
//		if (isFtp) {
//			mbean.setUtsOnuUpgradeRuleFtpServerIp(new String(
//					tfUtsOnuUpgradeRuleFtpServerIp.getIPString()));
//			mbean.setUtsOnuUpgradeRuleFtpUsername(new String(
//					tfUtsOnuUpgradeRuleFtpUsername.getValue()));
//			mbean.setUtsOnuUpgradeRuleFtpPassword(new String(
//					tfUtsOnuUpgradeRuleFtpPassword.getValue()));
//		}
		// mbean.setUtsOnuUpgradeRuleRowStatus(new
		// Integer(utsOnuUpgradeRuleRowStatusVList[tfUtsOnuUpgradeRuleRowStatus.getSelectedIndex()]));

	}

	@Override
	public boolean validateFrom() {
		if ("".equals(tfUtsOnuUpgradeRuleSwVersino.getValue().trim())) {
			String msg = fStringMap.getString(utsOnuUpgradeRuleSwVersino)
					+ fStringMap.getString("is_empty");
			MessageDialog.showErrorMessageDialog(fApplication, msg);
			return false;
		}

//		if ("0.0.0.0".equals(tfUtsOnuUpgradeRuleFtpServerIp.getIPString())
//				&& "".equals(tfUtsOnuUpgradeRuleFtpUsername.getValue().trim())
//				&& "".equals(tfUtsOnuUpgradeRuleFtpPassword.getValue().trim())) {
//			isFtp = false;
//			return true;
//		}
//
//		if ("0.0.0.0".equals(tfUtsOnuUpgradeRuleFtpServerIp.getIPString())) {
//			String msg = fStringMap.getString(utsOnuUpgradeRuleFtpServerIp)
//					+ fStringMap.getString("is_0.0.0.0");
//			MessageDialog.showErrorMessageDialog(fApplication, msg);
//			return false;
//		}
//
//		if ("".equals(tfUtsOnuUpgradeRuleFtpUsername.getValue().trim())) {
//			String msg = fStringMap.getString(utsOnuUpgradeRuleFtpUsername)
//					+ fStringMap.getString("is_empty");
//			MessageDialog.showErrorMessageDialog(fApplication, msg);
//			return false;
//		}
//
//		if ("".equals(tfUtsOnuUpgradeRuleFtpPassword.getValue().trim())) {
//			String msg = fStringMap.getString(utsOnuUpgradeRuleFtpPassword)
//					+ fStringMap.getString("is_empty");
//			MessageDialog.showErrorMessageDialog(fApplication, msg);
//			return false;
//		}
//		isFtp = true;
		return super.validateFrom();
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

	/*
	 * private void setOnuUpgradeRuleHwCompByType() { int type =
	 * utsOnuUpgradeRuleOnuTypeVList
	 * [tfUtsOnuUpgradeRuleOnuType.getSelectedIndex()]; // String stype =
	 * tfUtsOnuUpgradeRuleOnuType.getSelectedItem().toString(); //PON: onu101i,
	 * onu1001i, onub1202, onub1205, onub1205d, onub1205y, onub130, onu-c3160
	 * if((type == 38) || (type == 17) || (type == 84) || (type == 42) || (type
	 * == 40) || (type == 39) || (type == 41) || (type == 107)) {
	 * utsOnuUpgradeRuleHwCompVList = new int[] {1}; String[]
	 * utsOnuUpgradeRuleHwCompTList = new String[] {
	 * fStringMap.getString("pon")}; tfUtsOnuUpgradeRuleHwComp.removeAllItems();
	 * for(int i = 0; i< utsOnuUpgradeRuleHwCompTList.length;i++) {
	 * tfUtsOnuUpgradeRuleHwComp.addItem(utsOnuUpgradeRuleHwCompTList[i]); } }
	 * //switch: onu204ie, onu204ih, onu204i-h-R-c1, onu2016i-e else if((type ==
	 * 85) || (type == 86) || (type == 89) || (type == 76)) {
	 * utsOnuUpgradeRuleHwCompVList = new int[] {2}; String[]
	 * utsOnuUpgradeRuleHwCompTList = new String[] {
	 * fStringMap.getString("switch")};
	 * tfUtsOnuUpgradeRuleHwComp.removeAllItems(); for(int i = 0; i<
	 * utsOnuUpgradeRuleHwCompTList.length;i++) {
	 * tfUtsOnuUpgradeRuleHwComp.addItem(utsOnuUpgradeRuleHwCompTList[i]); } }
	 * //unified: onu204i-h-R-h1, onu204i-k7-R-a1, onu204i-k7-R-a2,
	 * onu204i-k7-R-a4, onu204i-k7-R-a5, onu204i-k7-R-a7, onu404i-R-c1,
	 * onu804i-R-c1 // CLT2168, CLT2170, s1201, s1202, onu204i-k7-R-b2 else
	 * if((type == 93) || (type == 94) || (type == 95) || (type == 97) || (type
	 * == 104) || (type == 103) || (type == 91) || (type == 98) || (type == 105)
	 * || (type == 106) || (type == 401) || (type == 402) || (type == 108)) {
	 * utsOnuUpgradeRuleHwCompVList = new int[] {4}; String[]
	 * utsOnuUpgradeRuleHwCompTList = new String[] {
	 * fStringMap.getString("unified")};
	 * tfUtsOnuUpgradeRuleHwComp.removeAllItems(); for(int i = 0; i<
	 * utsOnuUpgradeRuleHwCompTList.length;i++) {
	 * tfUtsOnuUpgradeRuleHwComp.addItem(utsOnuUpgradeRuleHwCompTList[i]); }
	 * 
	 * } //pon, switch: onu204i, onu208h, onu208i, onu208p, onu2004-2, onu2004i,
	 * onu2024i, onu404i // onu408t, onu4016i-tA1B, onu4016i-tA1S, onu804i,
	 * js04h-v, js16b-v else if((type == 21) || (type == 73) || (type == 22) ||
	 * (type == 79) || (type == 71) || (type == 18) || (type == 25) || (type ==
	 * 19) || (type == 24) || (type == 77) || (type == 78) || (type == 29) ||
	 * (type == 302) || (type == 303)) { utsOnuUpgradeRuleHwCompVList = new
	 * int[] {1, 2}; String[] utsOnuUpgradeRuleHwCompTList = new String[] {
	 * fStringMap.getString("pon"), fStringMap.getString("switch")};
	 * tfUtsOnuUpgradeRuleHwComp.removeAllItems(); for(int i = 0; i<
	 * utsOnuUpgradeRuleHwCompTList.length;i++) {
	 * tfUtsOnuUpgradeRuleHwComp.addItem(utsOnuUpgradeRuleHwCompTList[i]); } }
	 * //pon, switch, VoIP: js24b-v, onu4024i else if((type == 301) || (type ==
	 * 36)) { utsOnuUpgradeRuleHwCompVList = new int[] {1, 2, 3}; String[]
	 * utsOnuUpgradeRuleHwCompTList = new String[] {
	 * fStringMap.getString("pon"), fStringMap.getString("switch"),
	 * fStringMap.getString("voip")};
	 * tfUtsOnuUpgradeRuleHwComp.removeAllItems(); for(int i = 0; i<
	 * utsOnuUpgradeRuleHwCompTList.length;i++) {
	 * tfUtsOnuUpgradeRuleHwComp.addItem(utsOnuUpgradeRuleHwCompTList[i]); } }
	 * else { utsOnuUpgradeRuleHwCompVList = new int[] { 1, 2, 3, 4, 5, };
	 * utsOnuUpgradeRuleHwCompTList = new String[] {
	 * fStringMap.getString("pon"), fStringMap.getString("switch"),
	 * fStringMap.getString("voip"), fStringMap.getString("unified"),
	 * fStringMap.getString("bootloader"), };
	 * tfUtsOnuUpgradeRuleHwComp.removeAllItems(); for(int i = 0; i<
	 * utsOnuUpgradeRuleHwCompTList.length;i++) {
	 * tfUtsOnuUpgradeRuleHwComp.addItem(utsOnuUpgradeRuleHwCompTList[i]); } } }
	 */

}

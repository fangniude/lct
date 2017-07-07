package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.MultiItemSelector;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2PrivateRuleProfileTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The Dot3Onu2PrivateRuleProfileTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2PrivateRuleProfileTablePanel extends UPanel {

	private IndexAutoGenField tfUtsDot3Onu2PrivateRuleIndex = new IndexAutoGenField(fApplication, 1);

	private StringTextField tfUtsDot3Onu2PrivateRuleName = new StringTextField();

	private MultiItemSelector tfUtsDot3Onu2PrivateRuleBitmap = new MultiItemSelector();
	protected Vector vRuleBitmap = new Vector();

	private int[] utsDot3Onu2PrivateRuleDMacMatchTypeVList = new int[] { 6, 3,
			1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleDMacMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleDMacMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleDMacMatchTypeTList);
	private MacAddressField tfUtsDot3Onu2PrivateRuleDMac = new MacAddressField();

	private int[] utsDot3Onu2PrivateRuleSMacMatchTypeVList = new int[] { 6, 3,
			1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleSMacMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleSMacMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleSMacMatchTypeTList);
	private MacAddressField tfUtsDot3Onu2PrivateRuleSMac = new MacAddressField();

	private int[] utsDot3Onu2PrivateRulePriMatchTypeVList = new int[] { 6, 3,
			1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRulePriMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRulePriMatchType = new JComboBox(
			utsDot3Onu2PrivateRulePriMatchTypeTList);
	private IntegerTextField tfUtsDot3Onu2PrivateRulePri = new IntegerTextField();

	private int[] utsDot3Onu2PrivateRuleVlanMatchTypeVList = new int[] { 6, 3,
			1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleVlanMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleVlanMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleVlanMatchTypeTList);
	private IntegerTextField tfUtsDot3Onu2PrivateRuleVlanId = new IntegerTextField();

	private int[] utsDot3Onu2PrivateRuleEtherTypeMatchTypeVList = new int[] {
			6, 3, 1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleEtherTypeMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleEtherTypeMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleEtherTypeMatchTypeTList);
	private IntegerTextField tfUtsDot3Onu2PrivateRuleEtherType = new IntegerTextField();

	private int[] utsDot3Onu2PrivateRuleDIPMatchTypeVList = new int[] { 6, 3,
			1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleDIPMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleDIPMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleDIPMatchTypeTList);
	private IPAddressField tfUtsDot3Onu2PrivateRuleDIP = new IPAddressField();

	private int[] utsDot3Onu2PrivateRuleSIPMatchTypeVList = new int[] { 6, 3,
			1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleSIPMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleSIPMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleSIPMatchTypeTList);
	private IPAddressField tfUtsDot3Onu2PrivateRuleSIP = new IPAddressField();

	private int[] utsDot3Onu2PrivateRuleIpTypeMatchTypeVList = new int[] { 6,
			3, 1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleIpTypeMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleIpTypeMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleIpTypeMatchTypeTList);
	private int[] utsDot3Onu2PrivateRuleIpTypeVList = new int[] { 1, 2, 17, 6, };
	private String[] utsDot3Onu2PrivateRuleIpTypeTList = new String[] {
			fStringMap.getString("icmp"), fStringMap.getString("igmp"),
			fStringMap.getString("udp"), fStringMap.getString("tcp"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleIpType = new JComboBox(
			utsDot3Onu2PrivateRuleIpTypeTList);
	private int[] utsDot3Onu2PrivateRuleDscpMatchTypeVList = new int[] { 6, 3,
			1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleDscpMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleDscpMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleDscpMatchTypeTList);
	private IntegerTextField tfUtsDot3Onu2PrivateRuleDscp = new IntegerTextField();

	private int[] utsDot3Onu2PrivateRulePrecedenceMatchTypeVList = new int[] {
			6, 3, 1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRulePrecedenceMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRulePrecedenceMatchType = new JComboBox(
			utsDot3Onu2PrivateRulePrecedenceMatchTypeTList);
	private int[] utsDot3Onu2PrivateRulePrecedenceVList = new int[] { 6, 4, 3,
			5, 2, 1, 7, 8, };
	private String[] utsDot3Onu2PrivateRulePrecedenceTList = new String[] {
			fStringMap.getString("crical"), fStringMap.getString("flash"),
			fStringMap.getString("immediate"),
			fStringMap.getString("flash-override"),
			fStringMap.getString("priority"), fStringMap.getString("routine"),
			fStringMap.getString("internetwork-control"), fStringMap.getString("network-control"), };
	private JComboBox tfUtsDot3Onu2PrivateRulePrecedence = new JComboBox(
			utsDot3Onu2PrivateRulePrecedenceTList);
	private int[] utsDot3Onu2PrivateRuleSourePortMatchTypeVList = new int[] {
			6, 3, 1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleSourePortMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleSourePortMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleSourePortMatchTypeTList);
	private IntegerTextField tfUtsDot3Onu2PrivateRuleSourcePort = new IntegerTextField();

	private int[] utsDot3Onu2PrivateRuleDstPortMatchTypeVList = new int[] { 6,
			3, 1, 4, 7, 2, 8, 5, };
	private String[] utsDot3Onu2PrivateRuleDstPortMatchTypeTList = new String[] {
			fStringMap.getString("field-exist"),
			fStringMap.getString("not-equal"),
			fStringMap.getString("never-match"),
			fStringMap.getString("less-than"),
			fStringMap.getString("field-not-exist"),
			fStringMap.getString("equal"),
			fStringMap.getString("always-match"),
			fStringMap.getString("more-than"), };
	private JComboBox tfUtsDot3Onu2PrivateRuleDstPortMatchType = new JComboBox(
			utsDot3Onu2PrivateRuleDstPortMatchTypeTList);
	private IntegerTextField tfUtsDot3Onu2PrivateRuleDstPort = new IntegerTextField();

	private final String utsDot3Onu2PrivateRuleIndex = fStringMap
			.getString("utsDot3Onu2PrivateRuleIndex")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleName = fStringMap
			.getString("utsDot3Onu2PrivateRuleName")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleBitmap = fStringMap
			.getString("utsDot3Onu2PrivateRuleBitmap")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleDMacMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleDMacMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleDMac = fStringMap
			.getString("utsDot3Onu2PrivateRuleDMac")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleSMacMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleSMacMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleSMac = fStringMap
			.getString("utsDot3Onu2PrivateRuleSMac")
			+ " : ";
	private final String utsDot3Onu2PrivateRulePriMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRulePriMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRulePri = fStringMap
			.getString("utsDot3Onu2PrivateRulePri")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleVlanMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleVlanMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleVlanId = fStringMap
			.getString("utsDot3Onu2PrivateRuleVlanId")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleEtherTypeMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleEtherTypeMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleEtherType = fStringMap
			.getString("utsDot3Onu2PrivateRuleEtherType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleDIPMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleDIPMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleDIP = fStringMap
			.getString("utsDot3Onu2PrivateRuleDIP")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleSIPMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleSIPMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleSIP = fStringMap
			.getString("utsDot3Onu2PrivateRuleSIP")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleIpTypeMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleIpTypeMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleIpType = fStringMap
			.getString("utsDot3Onu2PrivateRuleIpType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleDscpMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleDscpMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleDscp = fStringMap
			.getString("utsDot3Onu2PrivateRuleDscp")
			+ " : ";
	private final String utsDot3Onu2PrivateRulePrecedenceMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRulePrecedenceMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRulePrecedence = fStringMap
			.getString("utsDot3Onu2PrivateRulePrecedence")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleSourePortMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleSourePortMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleSourcePort = fStringMap
			.getString("utsDot3Onu2PrivateRuleSourcePort")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleDstPortMatchType = fStringMap
			.getString("utsDot3Onu2PrivateRuleDstPortMatchType")
			+ " : ";
	private final String utsDot3Onu2PrivateRuleDstPort = fStringMap
			.getString("utsDot3Onu2PrivateRuleDstPort")
			+ " : ";
	
	private final String DAMAC = fStringMap.getString("DAM AC");
	private final String SAMAC = fStringMap.getString("SAM AC");
	private final String PRI = fStringMap.getString("PRI");
	private final String vlanLabel = fStringMap.getString("VLAN ID");
	private final String EtherType = fStringMap.getString("Ether Type");
	private final String DAIP = fStringMap.getString("DA IP(IPv4)");
	private final String SAIP = fStringMap.getString("SA IP(IPv4)");
	private final String IPPROTOCOL = fStringMap.getString("IP Protocol Type");
	private final String IPDSCP = fStringMap.getString("IP DSCP(IPv4)");
	private final String IPPRECED = fStringMap.getString("IP Precedence(IPv6)");
	private final String SOURCEL4PORT = fStringMap.getString("Source L4 Port");
	private final String DESL4PORT = fStringMap.getString("Destination L4 Port");

	
	public Dot3Onu2PrivateRuleProfileTablePanel(IApplication app) {
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleIndex));
//		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleIndex);
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleIndex.getIndexPanel(0));
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleName));
		tfUtsDot3Onu2PrivateRuleName.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleName"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleName);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleBitmap));
		tfUtsDot3Onu2PrivateRuleBitmap.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleBitmap"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleBitmap);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleDMacMatchType));
		tfUtsDot3Onu2PrivateRuleDMacMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleDMacMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleDMacMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleDMac));
		tfUtsDot3Onu2PrivateRuleDMac.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleDMac"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleDMac);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleSMacMatchType));
		tfUtsDot3Onu2PrivateRuleSMacMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleSMacMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleSMacMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleSMac));
		tfUtsDot3Onu2PrivateRuleSMac.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleSMac"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleSMac);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRulePriMatchType));
		tfUtsDot3Onu2PrivateRulePriMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRulePriMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRulePriMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRulePri));
		tfUtsDot3Onu2PrivateRulePri.setName(fStringMap
				.getString("utsDot3Onu2PrivateRulePri"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRulePri);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleVlanMatchType));
		tfUtsDot3Onu2PrivateRuleVlanMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleVlanMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleVlanMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleVlanId));
		tfUtsDot3Onu2PrivateRuleVlanId.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleVlanId"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleVlanId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleEtherTypeMatchType));
		tfUtsDot3Onu2PrivateRuleEtherTypeMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleEtherTypeMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleEtherTypeMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleEtherType));
		tfUtsDot3Onu2PrivateRuleEtherType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleEtherType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleEtherType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleDIPMatchType));
		tfUtsDot3Onu2PrivateRuleDIPMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleDIPMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleDIPMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleDIP));
		tfUtsDot3Onu2PrivateRuleDIP.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleDIP"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleDIP);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleSIPMatchType));
		tfUtsDot3Onu2PrivateRuleSIPMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleSIPMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleSIPMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleSIP));
		tfUtsDot3Onu2PrivateRuleSIP.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleSIP"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleSIP);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleIpTypeMatchType));
		tfUtsDot3Onu2PrivateRuleIpTypeMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleIpTypeMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleIpTypeMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleIpType));
		tfUtsDot3Onu2PrivateRuleIpType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleIpType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleIpType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleDscpMatchType));
		tfUtsDot3Onu2PrivateRuleDscpMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleDscpMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleDscpMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleDscp));
		tfUtsDot3Onu2PrivateRuleDscp.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleDscp"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleDscp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2PrivateRulePrecedenceMatchType));
		tfUtsDot3Onu2PrivateRulePrecedenceMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRulePrecedenceMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRulePrecedenceMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRulePrecedence));
		tfUtsDot3Onu2PrivateRulePrecedence.setName(fStringMap
				.getString("utsDot3Onu2PrivateRulePrecedence"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRulePrecedence);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleSourePortMatchType));
		tfUtsDot3Onu2PrivateRuleSourePortMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleSourePortMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleSourePortMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleSourcePort));
		tfUtsDot3Onu2PrivateRuleSourcePort.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleSourcePort"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleSourcePort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleDstPortMatchType));
		tfUtsDot3Onu2PrivateRuleDstPortMatchType.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleDstPortMatchType"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleDstPortMatchType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateRuleDstPort));
		tfUtsDot3Onu2PrivateRuleDstPort.setName(fStringMap
				.getString("utsDot3Onu2PrivateRuleDstPort"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateRuleDstPort);
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
		vRuleBitmap.add(DAMAC);
		vRuleBitmap.add(SAMAC);
		vRuleBitmap.add(PRI);
		vRuleBitmap.add(vlanLabel);
		vRuleBitmap.add(EtherType);
		vRuleBitmap.add(DAIP);
		vRuleBitmap.add(SAIP);
		vRuleBitmap.add(IPPROTOCOL);
		vRuleBitmap.add(IPDSCP);
		vRuleBitmap.add(IPPRECED);
		vRuleBitmap.add(SOURCEL4PORT);
		vRuleBitmap.add(DESL4PORT);
		
//		tfUtsDot3Onu2PrivateRuleIndex.setValueScope(1, 128);
		tfUtsDot3Onu2PrivateRuleIndex.setValueScope(0, 1, 128);
		
		tfUtsDot3Onu2PrivateRuleName.setLenScope(0, 64);

		tfUtsDot3Onu2PrivateRulePri.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateRuleVlanId.setValueScope(1, 4094);

		tfUtsDot3Onu2PrivateRuleDscp.setValueScope(0, 63);

		tfUtsDot3Onu2PrivateRuleSourcePort.setValueScope(1, 65535);

		tfUtsDot3Onu2PrivateRuleDstPort.setValueScope(1, 65535);

	}

	public void refresh() {
		tfUtsDot3Onu2PrivateRuleBitmap.setSelectionChoices(vRuleBitmap);
		
		if (SnmpAction.IType.ADD.equals(fCommand)) {
			tfUtsDot3Onu2PrivateRuleIndex.setEnabled(true);
			tfUtsDot3Onu2PrivateRuleIndex.setTable(fTable);
			tfUtsDot3Onu2PrivateRuleIndex.refresh();
			return;
		}
		Dot3Onu2PrivateRuleProfileTable mbean = (Dot3Onu2PrivateRuleProfileTable) getModel();

//		tfUtsDot3Onu2PrivateRuleIndex.setText(mbean
//				.getUtsDot3Onu2PrivateRuleIndex().toString());
		tfUtsDot3Onu2PrivateRuleIndex.setValue(0, mbean.getUtsDot3Onu2PrivateRuleIndex());
		tfUtsDot3Onu2PrivateRuleName.setValue(mbean
				.getUtsDot3Onu2PrivateRuleName());
//		tfUtsDot3Onu2PrivateRuleBitmap.setValue(mbean
//				.getUtsDot3Onu2PrivateRuleBitmap());
		Vector selected = ruleBitMappingToStringArray(mbean
				.getUtsDot3Onu2PrivateRuleBitmap());
		tfUtsDot3Onu2PrivateRuleBitmap.setSelectedChoices(selected);
		tfUtsDot3Onu2PrivateRuleDMacMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleDMacMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleDMacMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleDMac.setValue(mbean
				.getUtsDot3Onu2PrivateRuleDMac());
		tfUtsDot3Onu2PrivateRuleSMacMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleSMacMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleSMacMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleSMac.setValue(mbean
				.getUtsDot3Onu2PrivateRuleSMac());
		tfUtsDot3Onu2PrivateRulePriMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRulePriMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRulePriMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRulePri.setValue(mbean
				.getUtsDot3Onu2PrivateRulePri().intValue());
		tfUtsDot3Onu2PrivateRuleVlanMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleVlanMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleVlanMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleVlanId.setValue(mbean
				.getUtsDot3Onu2PrivateRuleVlanId().intValue());
		tfUtsDot3Onu2PrivateRuleEtherTypeMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleEtherTypeMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleEtherTypeMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleEtherType.setValue(mbean
				.getUtsDot3Onu2PrivateRuleEtherType().intValue());
		tfUtsDot3Onu2PrivateRuleDIPMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleDIPMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleDIPMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleDIP.setValue(mbean
				.getUtsDot3Onu2PrivateRuleDIP());
		tfUtsDot3Onu2PrivateRuleSIPMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleSIPMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleSIPMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleSIP.setValue(mbean
				.getUtsDot3Onu2PrivateRuleSIP());
		tfUtsDot3Onu2PrivateRuleIpTypeMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleIpTypeMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleIpTypeMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleIpType.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateRuleIpTypeVList, mbean
						.getUtsDot3Onu2PrivateRuleIpType().intValue()));
		tfUtsDot3Onu2PrivateRuleDscpMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleDscpMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleDscpMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleDscp.setValue(mbean
				.getUtsDot3Onu2PrivateRuleDscp().intValue());
		tfUtsDot3Onu2PrivateRulePrecedenceMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRulePrecedenceMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRulePrecedenceMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRulePrecedence.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateRulePrecedenceVList, mbean
						.getUtsDot3Onu2PrivateRulePrecedence().intValue()));
		tfUtsDot3Onu2PrivateRuleSourePortMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleSourePortMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleSourePortMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleSourcePort.setValue(mbean
				.getUtsDot3Onu2PrivateRuleSourcePort().intValue());
		tfUtsDot3Onu2PrivateRuleDstPortMatchType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateRuleDstPortMatchTypeVList, mbean
								.getUtsDot3Onu2PrivateRuleDstPortMatchType()
								.intValue()));
		tfUtsDot3Onu2PrivateRuleDstPort.setValue(mbean
				.getUtsDot3Onu2PrivateRuleDstPort().intValue());
		tfUtsDot3Onu2PrivateRuleIndex.setEnabled(false);
	}

	public void updateModel() {

		if (SnmpAction.IType.ADD.equals(fCommand))
			setModel(new Dot3Onu2PrivateRuleProfileTable(fApplication
					.getSnmpProxy()));

		Dot3Onu2PrivateRuleProfileTable mbean = (Dot3Onu2PrivateRuleProfileTable) getModel();
		if (mbean == null)
            return;

		 if (SnmpAction.IType.ADD.equals(fCommand)) {
//			 mbean.setUtsDot3Onu2PrivateRuleIndex(new Integer(tfUtsDot3Onu2PrivateRuleIndex.getValue()));
			 mbean.setUtsDot3Onu2PrivateRuleIndex((int) tfUtsDot3Onu2PrivateRuleIndex.getValue(0));
		 }

		mbean.setUtsDot3Onu2PrivateRuleName(new String(
				tfUtsDot3Onu2PrivateRuleName.getValue()));
//		mbean.setUtsDot3Onu2PrivateRuleBitmap(new String(
//				tfUtsDot3Onu2PrivateRuleBitmap.getValue()));
		Vector selected = tfUtsDot3Onu2PrivateRuleBitmap.getSelectedChoices();
	    mbean.setUtsDot3Onu2PrivateRuleBitmap(StringArrayToRuleMapping(selected));
		mbean
				.setUtsDot3Onu2PrivateRuleDMacMatchType(new Integer(
						utsDot3Onu2PrivateRuleDMacMatchTypeVList[tfUtsDot3Onu2PrivateRuleDMacMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleDMac(tfUtsDot3Onu2PrivateRuleDMac
				.getValue());
		mbean
				.setUtsDot3Onu2PrivateRuleSMacMatchType(new Integer(
						utsDot3Onu2PrivateRuleSMacMatchTypeVList[tfUtsDot3Onu2PrivateRuleSMacMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleSMac(tfUtsDot3Onu2PrivateRuleSMac
				.getValue());
		mbean
				.setUtsDot3Onu2PrivateRulePriMatchType(new Integer(
						utsDot3Onu2PrivateRulePriMatchTypeVList[tfUtsDot3Onu2PrivateRulePriMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRulePri(new Integer(
				tfUtsDot3Onu2PrivateRulePri.getValue()));
		mbean
				.setUtsDot3Onu2PrivateRuleVlanMatchType(new Integer(
						utsDot3Onu2PrivateRuleVlanMatchTypeVList[tfUtsDot3Onu2PrivateRuleVlanMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleVlanId(new Integer(
				tfUtsDot3Onu2PrivateRuleVlanId.getValue()));
		mbean
				.setUtsDot3Onu2PrivateRuleEtherTypeMatchType(new Integer(
						utsDot3Onu2PrivateRuleEtherTypeMatchTypeVList[tfUtsDot3Onu2PrivateRuleEtherTypeMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleEtherType(new Integer(
				tfUtsDot3Onu2PrivateRuleEtherType.getValue()));
		mbean
				.setUtsDot3Onu2PrivateRuleDIPMatchType(new Integer(
						utsDot3Onu2PrivateRuleDIPMatchTypeVList[tfUtsDot3Onu2PrivateRuleDIPMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleDIP(new String(
				tfUtsDot3Onu2PrivateRuleDIP.getIPString()));
		mbean
				.setUtsDot3Onu2PrivateRuleSIPMatchType(new Integer(
						utsDot3Onu2PrivateRuleSIPMatchTypeVList[tfUtsDot3Onu2PrivateRuleSIPMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleSIP(new String(
				tfUtsDot3Onu2PrivateRuleSIP.getIPString()));
		mbean
				.setUtsDot3Onu2PrivateRuleIpTypeMatchType(new Integer(
						utsDot3Onu2PrivateRuleIpTypeMatchTypeVList[tfUtsDot3Onu2PrivateRuleIpTypeMatchType
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2PrivateRuleIpType(new Integer(
						utsDot3Onu2PrivateRuleIpTypeVList[tfUtsDot3Onu2PrivateRuleIpType
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2PrivateRuleDscpMatchType(new Integer(
						utsDot3Onu2PrivateRuleDscpMatchTypeVList[tfUtsDot3Onu2PrivateRuleDscpMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleDscp(new Integer(
				tfUtsDot3Onu2PrivateRuleDscp.getValue()));
		mbean
				.setUtsDot3Onu2PrivateRulePrecedenceMatchType(new Integer(
						utsDot3Onu2PrivateRulePrecedenceMatchTypeVList[tfUtsDot3Onu2PrivateRulePrecedenceMatchType
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2PrivateRulePrecedence(new Integer(
						utsDot3Onu2PrivateRulePrecedenceVList[tfUtsDot3Onu2PrivateRulePrecedence
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2PrivateRuleSourePortMatchType(new Integer(
						utsDot3Onu2PrivateRuleSourePortMatchTypeVList[tfUtsDot3Onu2PrivateRuleSourePortMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleSourcePort(new Long(
				tfUtsDot3Onu2PrivateRuleSourcePort.getValue()));
		mbean
				.setUtsDot3Onu2PrivateRuleDstPortMatchType(new Integer(
						utsDot3Onu2PrivateRuleDstPortMatchTypeVList[tfUtsDot3Onu2PrivateRuleDstPortMatchType
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateRuleDstPort(new Long(
				tfUtsDot3Onu2PrivateRuleDstPort.getValue()));

	}
	
	public void afterUpdateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
        	tfUtsDot3Onu2PrivateRuleIndex.increaseIndexValue();
        }
    }

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
		
	public Vector ruleBitMappingToStringArray(byte[] bts) {
		Vector list = new Vector();

		if(bts == null) return list;
		if(bts.length > 0) {
			if ((bts[0] & 0x01) == 0x01) {
				list.add(DAMAC);
			}
			if ((bts[0] & 0x02) == 0x02) {
				list.add(SAMAC);
			}
			if ((bts[0] & 0x04) == 0x04) {
				list.add(PRI);
			}
			if ((bts[0] & 0x08) == 0x08) {
				list.add(vlanLabel);
			}
			if ((bts[0] & 0x10) == 0x10) {
				list.add(EtherType);
			}
			if ((bts[0] & 0x20) == 0x20) {
				list.add(DAIP);
			}
			if ((bts[0] & 0x40) == 0x40) {
				list.add(SAIP);
			}
			if ((bts[0] & 0x80) == 0x80) {
				list.add(IPPROTOCOL);
			}
		}
		if(bts.length > 1) {
			if ((bts[1] & 0x01) == 0x01) {
				list.add(IPDSCP);
			}
			if ((bts[1] & 0x02) == 0x02) {
				list.add(IPPRECED);
			}
			if ((bts[1] & 0x04) == 0x04) {
				list.add(SOURCEL4PORT);
			}
			if ((bts[1] & 0x08) == 0x08) {
				list.add(DESL4PORT);
			}
		}
		
		return list;
	}

	public byte[] StringArrayToRuleMapping(Vector<String> selected) {
		byte[] bts = new byte[8];
		for(String sel: selected){
			if(sel.equals(DAMAC)) {
				bts[0] = (byte)(bts[0] | 0x01);
			}
			if(sel.equals(SAMAC)) {
				bts[0] = (byte)(bts[0] | 0x02);
			}
			if(sel.equals(PRI)) {
				bts[0] = (byte)(bts[0] | 0x04);
			}
			if(sel.equals(vlanLabel)) {
				bts[0] = (byte)(bts[0] | 0x08);
			}
			if(sel.equals(EtherType)) {
				bts[0] = (byte)(bts[0] | 0x10);
			}
			if(sel.equals(DAIP)) {
				bts[0] = (byte)(bts[0] | 0x20);
			}
			if(sel.equals(SAIP)) {
				bts[0] = (byte)(bts[0] | 0x40);
			}
			if(sel.equals(IPPROTOCOL)) {
				bts[0] = (byte)(bts[0] | 0x80);
			}
			if(sel.equals(IPDSCP)) {
				bts[1] = (byte)(bts[1] | 0x01);
			}
			if(sel.equals(IPPRECED)) {
				bts[1] = (byte)(bts[1] | 0x02);
			}
			if(sel.equals(SOURCEL4PORT)) {
				bts[1] = (byte)(bts[1] | 0x04);
			}
			if(sel.equals(DESL4PORT)) {
				bts[1] = (byte)(bts[1] | 0x08);
			}
		}
		return bts;
	}

}

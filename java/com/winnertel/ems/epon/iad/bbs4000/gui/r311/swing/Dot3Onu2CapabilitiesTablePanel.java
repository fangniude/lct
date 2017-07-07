package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2CapabilitiesTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2CapabilitiesTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2CapabilitiesTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2CapabilitiesModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesPortId = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesVersion = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesGEPortNumber = new JLabel();

	private JLabel tfUtsDot3OnuOnu2CapabilitiesGEPortList = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesFEPortNumber = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesFEPortList = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesPOTSPortNumber = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesE1PortNumber = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesUpsQueueNum = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesMaxUpsQueueNum = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesDownsQueueNum = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitiesMaxDownsQueueNum = new JLabel();

	private int[] utsDot3Onu2CapabilitiesBatteryInstalledVList = new int[] { 1,
			2, };
	private String[] utsDot3Onu2CapabilitiesBatteryInstalledTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsDot3Onu2CapabilitiesBatteryInstalled = new JComboBox(
			utsDot3Onu2CapabilitiesBatteryInstalledTList);
	private int[] utsDot3Onu2CapbilitiesOnuTypeVList = new int[] { 0, 2, 7, 1,
			8, 5, 3, 6, 4, };
	private String[] utsDot3Onu2CapbilitiesOnuTypeTList = new String[] {
			fStringMap.getString("sfu"), fStringMap.getString("sbu"),
			fStringMap.getString("cardEthDslMdu"), fStringMap.getString("hgu"),
			fStringMap.getString("mtu"), fStringMap.getString("boxCardDslMdu"),
			fStringMap.getString("boxEthMdu"),
			fStringMap.getString("chassisCardDslMdu"),
			fStringMap.getString("miniCardEthMdu"), };
	private JComboBox tfUtsDot3Onu2CapbilitiesOnuType = new JComboBox(
			utsDot3Onu2CapbilitiesOnuTypeTList);
	private int[] utsDot3Onu2CapbilitiesMultiLlidVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2CapbilitiesMultiLlidTList = new String[] {
			fStringMap.getString("multiLLID"),
			fStringMap.getString("singleLLID"), };
	private JComboBox tfUtsDot3Onu2CapbilitiesMultiLlid = new JComboBox(
			utsDot3Onu2CapbilitiesMultiLlidTList);
	private int[] utsDot3Onu2CapabilitiesProtectionTypeVList = new int[] { 2,
			1, 0, };
	private String[] utsDot3Onu2CapabilitiesProtectionTypeTList = new String[] {
			fStringMap.getString("typeD"), fStringMap.getString("typeC"),
			fStringMap.getString("notSupport"), };
	private JComboBox tfUtsDot3Onu2CapabilitiesProtectionType = new JComboBox(
			utsDot3Onu2CapabilitiesProtectionTypeTList);
	private int[] utsDot3Onu2CapabilitiesPonIfNumVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2CapabilitiesPonIfNumTList = new String[] {
			fStringMap.getString("one"), fStringMap.getString("two"), };
	private JComboBox tfUtsDot3Onu2CapabilitiesPonIfNum = new JComboBox(
			utsDot3Onu2CapabilitiesPonIfNumTList);
	private JLabel tfUtsDot3Onu2CapabilitiesSlotNum = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitesIfAttribute = new JLabel();

	private int[] utsDot3Onu2CapabilitiesIpv6VList = new int[] { 1, 2, };
	private String[] utsDot3Onu2CapabilitiesIpv6TList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsDot3Onu2CapabilitiesIpv6 = new JComboBox(
			utsDot3Onu2CapabilitiesIpv6TList);
	private int[] utsDot3Onu2CapabilitiesPowerSupplyControlVList = new int[] {
			2, 0, 1, };
	private String[] utsDot3Onu2CapabilitiesPowerSupplyControlTList = new String[] {
			fStringMap.getString("bothTxRxPowerSupplyControl"),
			fStringMap.getString("notPowerSupplyControl"),
			fStringMap.getString("onlyTxPowerSupplyControl"), };
	private JComboBox tfUtsDot3Onu2CapabilitiesPowerSupplyControl = new JComboBox(
			utsDot3Onu2CapabilitiesPowerSupplyControlTList);
	private JLabel tfUtsDot3Onu2CapabilitiesServiceSLA = new JLabel();

	private JLabel tfUtsDot3Onu2CapabilitesIfAttributePerSlot = new JLabel();

	private final String utsDot3Onu2CapabilitiesModuleId = fStringMap
			.getString("utsDot3Onu2CapabilitiesModuleId")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesDeviceId = fStringMap
			.getString("utsDot3Onu2CapabilitiesDeviceId")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesPortId = fStringMap
			.getString("utsDot3Onu2CapabilitiesPortId")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesLogicalPortId = fStringMap
			.getString("utsDot3Onu2CapabilitiesLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesVersion = fStringMap
			.getString("utsDot3Onu2CapabilitiesVersion")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesGEPortNumber = fStringMap
			.getString("utsDot3Onu2CapabilitiesGEPortNumber")
			+ " : ";
	private final String utsDot3OnuOnu2CapabilitiesGEPortList = fStringMap
			.getString("utsDot3OnuOnu2CapabilitiesGEPortList")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesFEPortNumber = fStringMap
			.getString("utsDot3Onu2CapabilitiesFEPortNumber")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesFEPortList = fStringMap
			.getString("utsDot3Onu2CapabilitiesFEPortList")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesPOTSPortNumber = fStringMap
			.getString("utsDot3Onu2CapabilitiesPOTSPortNumber")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesE1PortNumber = fStringMap
			.getString("utsDot3Onu2CapabilitiesE1PortNumber")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesUpsQueueNum = fStringMap
			.getString("utsDot3Onu2CapabilitiesUpsQueueNum")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesMaxUpsQueueNum = fStringMap
			.getString("utsDot3Onu2CapabilitiesMaxUpsQueueNum")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesDownsQueueNum = fStringMap
			.getString("utsDot3Onu2CapabilitiesDownsQueueNum")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesMaxDownsQueueNum = fStringMap
			.getString("utsDot3Onu2CapabilitiesMaxDownsQueueNum")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesBatteryInstalled = fStringMap
			.getString("utsDot3Onu2CapabilitiesBatteryInstalled")
			+ " : ";
	private final String utsDot3Onu2CapbilitiesOnuType = fStringMap
			.getString("utsDot3Onu2CapbilitiesOnuType")
			+ " : ";
	private final String utsDot3Onu2CapbilitiesMultiLlid = fStringMap
			.getString("utsDot3Onu2CapbilitiesMultiLlid")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesProtectionType = fStringMap
			.getString("utsDot3Onu2CapabilitiesProtectionType")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesPonIfNum = fStringMap
			.getString("utsDot3Onu2CapabilitiesPonIfNum")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesSlotNum = fStringMap
			.getString("utsDot3Onu2CapabilitiesSlotNum")
			+ " : ";
	private final String utsDot3Onu2CapabilitesIfAttribute = fStringMap
			.getString("utsDot3Onu2CapabilitesIfAttribute")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesIpv6 = fStringMap
			.getString("utsDot3Onu2CapabilitiesIpv6")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesPowerSupplyControl = fStringMap
			.getString("utsDot3Onu2CapabilitiesPowerSupplyControl")
			+ " : ";
	private final String utsDot3Onu2CapabilitiesServiceSLA = fStringMap
			.getString("utsDot3Onu2CapabilitiesServiceSLA")
			+ " : ";
	private final String utsDot3Onu2CapabilitesIfAttributePerSlot = fStringMap
			.getString("utsDot3Onu2CapabilitesIfAttributePerSlot")
			+ " : ";

	public Dot3Onu2CapabilitiesTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(26, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesDeviceId));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesDeviceId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesVersion));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesVersion);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesGEPortNumber));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesGEPortNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOnu2CapabilitiesGEPortList));
		baseInfoPanel.add(tfUtsDot3OnuOnu2CapabilitiesGEPortList);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesFEPortNumber));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesFEPortNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesFEPortList));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesFEPortList);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesPOTSPortNumber));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesPOTSPortNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesE1PortNumber));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesE1PortNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesUpsQueueNum));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesUpsQueueNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesMaxUpsQueueNum));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesMaxUpsQueueNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesDownsQueueNum));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesDownsQueueNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesMaxDownsQueueNum));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesMaxDownsQueueNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesBatteryInstalled));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesBatteryInstalled);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapbilitiesOnuType));
		baseInfoPanel.add(tfUtsDot3Onu2CapbilitiesOnuType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapbilitiesMultiLlid));
		baseInfoPanel.add(tfUtsDot3Onu2CapbilitiesMultiLlid);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesProtectionType));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesProtectionType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesPonIfNum));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesPonIfNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesSlotNum));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesSlotNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitesIfAttribute));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitesIfAttribute);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesIpv6));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesIpv6);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2CapabilitiesPowerSupplyControl));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesPowerSupplyControl);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitiesServiceSLA));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitiesServiceSLA);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CapabilitesIfAttributePerSlot));
		baseInfoPanel.add(tfUtsDot3Onu2CapabilitesIfAttributePerSlot);
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

		Dot3Onu2CapabilitiesTable mbean = (Dot3Onu2CapabilitiesTable) getModel();

		tfUtsDot3Onu2CapabilitiesModuleId.setText(mbean
				.getUtsDot3Onu2CapabilitiesModuleId().toString());
		tfUtsDot3Onu2CapabilitiesDeviceId.setText(mbean
				.getUtsDot3Onu2CapabilitiesDeviceId().toString());
		tfUtsDot3Onu2CapabilitiesPortId.setText(mbean
				.getUtsDot3Onu2CapabilitiesPortId().toString());
		tfUtsDot3Onu2CapabilitiesLogicalPortId.setText(mbean
				.getUtsDot3Onu2CapabilitiesLogicalPortId().toString());
		tfUtsDot3Onu2CapabilitiesVersion.setText(mbean
				.getUtsDot3Onu2CapabilitiesVersion().toString());
		tfUtsDot3Onu2CapabilitiesGEPortNumber.setText(mbean
				.getUtsDot3Onu2CapabilitiesGEPortNumber().toString());
//		tfUtsDot3OnuOnu2CapabilitiesGEPortList.setText(mbean
//				.getUtsDot3OnuOnu2CapabilitiesGEPortList());
		tfUtsDot3Onu2CapabilitiesFEPortNumber.setText(mbean
				.getUtsDot3Onu2CapabilitiesFEPortNumber().toString());
//		tfUtsDot3Onu2CapabilitiesFEPortList.setText(mbean
//				.getUtsDot3Onu2CapabilitiesFEPortList());
		tfUtsDot3Onu2CapabilitiesPOTSPortNumber.setText(mbean
				.getUtsDot3Onu2CapabilitiesPOTSPortNumber().toString());
		tfUtsDot3Onu2CapabilitiesE1PortNumber.setText(mbean
				.getUtsDot3Onu2CapabilitiesE1PortNumber().toString());
		tfUtsDot3Onu2CapabilitiesUpsQueueNum.setText(mbean
				.getUtsDot3Onu2CapabilitiesUpsQueueNum().toString());
		tfUtsDot3Onu2CapabilitiesMaxUpsQueueNum.setText(mbean
				.getUtsDot3Onu2CapabilitiesMaxUpsQueueNum().toString());
		tfUtsDot3Onu2CapabilitiesDownsQueueNum.setText(mbean
				.getUtsDot3Onu2CapabilitiesDownsQueueNum().toString());
		tfUtsDot3Onu2CapabilitiesMaxDownsQueueNum.setText(mbean
				.getUtsDot3Onu2CapabilitiesMaxDownsQueueNum().toString());
		tfUtsDot3Onu2CapabilitiesBatteryInstalled
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2CapabilitiesBatteryInstalledVList, mbean
								.getUtsDot3Onu2CapabilitiesBatteryInstalled()
								.intValue()));
		tfUtsDot3Onu2CapbilitiesOnuType.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CapbilitiesOnuTypeVList, mbean
						.getUtsDot3Onu2CapbilitiesOnuType().intValue()));
		tfUtsDot3Onu2CapbilitiesMultiLlid.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CapbilitiesMultiLlidVList, mbean
						.getUtsDot3Onu2CapbilitiesMultiLlid().intValue()));
		tfUtsDot3Onu2CapabilitiesProtectionType
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2CapabilitiesProtectionTypeVList, mbean
								.getUtsDot3Onu2CapabilitiesProtectionType()
								.intValue()));
		tfUtsDot3Onu2CapabilitiesPonIfNum.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CapabilitiesPonIfNumVList, mbean
						.getUtsDot3Onu2CapabilitiesPonIfNum().intValue()));
		tfUtsDot3Onu2CapabilitiesSlotNum.setText(mbean
				.getUtsDot3Onu2CapabilitiesSlotNum().toString());
//		tfUtsDot3Onu2CapabilitesIfAttribute.setText(mbean
//				.getUtsDot3Onu2CapabilitesIfAttribute());
		tfUtsDot3Onu2CapabilitiesIpv6.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CapabilitiesIpv6VList, mbean
						.getUtsDot3Onu2CapabilitiesIpv6().intValue()));
		tfUtsDot3Onu2CapabilitiesPowerSupplyControl
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2CapabilitiesPowerSupplyControlVList, mbean
								.getUtsDot3Onu2CapabilitiesPowerSupplyControl()
								.intValue()));
		tfUtsDot3Onu2CapabilitiesServiceSLA.setText(mbean
				.getUtsDot3Onu2CapabilitiesServiceSLA().toString());
//		tfUtsDot3Onu2CapabilitesIfAttributePerSlot.setText(mbean
//				.getUtsDot3Onu2CapabilitesIfAttributePerSlot());

	}

	public void updateModel() {

		Dot3Onu2CapabilitiesTable mbean = (Dot3Onu2CapabilitiesTable) getModel();

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

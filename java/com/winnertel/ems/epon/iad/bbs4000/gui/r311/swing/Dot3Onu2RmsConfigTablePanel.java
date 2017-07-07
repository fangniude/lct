package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2RmsConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2RmsConfigTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2RmsConfigTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private int[] utsDot3Onu2RmsIpModeVList = new int[] { 3, 2, 1, };
	private String[] utsDot3Onu2RmsIpModeTList = new String[] {
			fStringMap.getString("pppoe-pppoePlus"),
			fStringMap.getString("dhcp"), fStringMap.getString("static-ip"), };
	private JComboBox tfUtsDot3Onu2RmsIpMode = new JComboBox(
			utsDot3Onu2RmsIpModeTList);
	private StringTextField tfUtsDot3Onu2RmsIpAddress = new StringTextField();

	private StringTextField tfUtsDot3Onu2RmsNetmask = new StringTextField();

	private StringTextField tfUtsDot3Onu2RmsDefaultGw = new StringTextField();

	private int[] utsDot3Onu2RmsPppoeModeVList = new int[] { 3, 2, 1, };
	private String[] utsDot3Onu2RmsPppoeModeTList = new String[] {
			fStringMap.getString("pap"), fStringMap.getString("chap"),
			fStringMap.getString("auto"), };
	private JComboBox tfUtsDot3Onu2RmsPppoeMode = new JComboBox(
			utsDot3Onu2RmsPppoeModeTList);
	private StringTextField tfUtsDot3Onu2RmsPppoeUserName = new StringTextField();

	private StringTextField tfUtsDot3Onu2RmsPppoePassword = new StringTextField();

	private int[] utsDot3Onu2RmsTaggedFlagVList = new int[] { 2, 1, 3, };
	private String[] utsDot3Onu2RmsTaggedFlagTList = new String[] {
			fStringMap.getString("tag"), fStringMap.getString("transparent"),
			fStringMap.getString("vlan-stacking"), };
	private JComboBox tfUtsDot3Onu2RmsTaggedFlag = new JComboBox(
			utsDot3Onu2RmsTaggedFlagTList);
	private IntegerTextField tfUtsDot3Onu2RmsCvlan = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2RmsSvlan = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2RmsPriority = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2RmsUrlBlockNum = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2RmsUrlBlockSequence = new IntegerTextField();

	private StringTextField tfUtsDot3Onu2RmsUrl = new StringTextField();

	private final String utsDot3Onu2VoipModuleId = fStringMap
			.getString("utsDot3Onu2VoipModuleId")
			+ " : ";
//	private final String utsDot3Onu2VoipDeviceId = fStringMap
//			.getString("utsDot3Onu2VoipDeviceId")
//			+ " : ";
	private final String utsDot3Onu2VoipPortId = fStringMap
			.getString("utsDot3Onu2VoipPortId")
			+ " : ";
	private final String utsDot3Onu2VoipLogicalPortId = fStringMap
			.getString("utsDot3Onu2VoipLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2RmsIpMode = fStringMap
			.getString("utsDot3Onu2RmsIpMode")
			+ " : ";
	private final String utsDot3Onu2RmsIpAddress = fStringMap
			.getString("utsDot3Onu2RmsIpAddress")
			+ " : ";
	private final String utsDot3Onu2RmsNetmask = fStringMap
			.getString("utsDot3Onu2RmsNetmask")
			+ " : ";
	private final String utsDot3Onu2RmsDefaultGw = fStringMap
			.getString("utsDot3Onu2RmsDefaultGw")
			+ " : ";
	private final String utsDot3Onu2RmsPppoeMode = fStringMap
			.getString("utsDot3Onu2RmsPppoeMode")
			+ " : ";
	private final String utsDot3Onu2RmsPppoeUserName = fStringMap
			.getString("utsDot3Onu2RmsPppoeUserName")
			+ " : ";
	private final String utsDot3Onu2RmsPppoePassword = fStringMap
			.getString("utsDot3Onu2RmsPppoePassword")
			+ " : ";
	private final String utsDot3Onu2RmsTaggedFlag = fStringMap
			.getString("utsDot3Onu2RmsTaggedFlag")
			+ " : ";
	private final String utsDot3Onu2RmsCvlan = fStringMap
			.getString("utsDot3Onu2RmsCvlan")
			+ " : ";
	private final String utsDot3Onu2RmsSvlan = fStringMap
			.getString("utsDot3Onu2RmsSvlan")
			+ " : ";
	private final String utsDot3Onu2RmsPriority = fStringMap
			.getString("utsDot3Onu2RmsPriority")
			+ " : ";
	private final String utsDot3Onu2RmsUrlBlockNum = fStringMap
			.getString("utsDot3Onu2RmsUrlBlockNum")
			+ " : ";
	private final String utsDot3Onu2RmsUrlBlockSequence = fStringMap
			.getString("utsDot3Onu2RmsUrlBlockSequence")
			+ " : ";
	private final String utsDot3Onu2RmsUrl = fStringMap
			.getString("utsDot3Onu2RmsUrl")
			+ " : ";

	public Dot3Onu2RmsConfigTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(17, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2VoipDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsIpMode));
		tfUtsDot3Onu2RmsIpMode.setName(fStringMap
				.getString("utsDot3Onu2RmsIpMode"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsIpMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsIpAddress));
		tfUtsDot3Onu2RmsIpAddress.setName(fStringMap
				.getString("utsDot3Onu2RmsIpAddress"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsIpAddress);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsNetmask));
		tfUtsDot3Onu2RmsNetmask.setName(fStringMap
				.getString("utsDot3Onu2RmsNetmask"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsNetmask);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsDefaultGw));
		tfUtsDot3Onu2RmsDefaultGw.setName(fStringMap
				.getString("utsDot3Onu2RmsDefaultGw"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsDefaultGw);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsPppoeMode));
		tfUtsDot3Onu2RmsPppoeMode.setName(fStringMap
				.getString("utsDot3Onu2RmsPppoeMode"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsPppoeMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsPppoeUserName));
		tfUtsDot3Onu2RmsPppoeUserName.setName(fStringMap
				.getString("utsDot3Onu2RmsPppoeUserName"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsPppoeUserName);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsPppoePassword));
		tfUtsDot3Onu2RmsPppoePassword.setName(fStringMap
				.getString("utsDot3Onu2RmsPppoePassword"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsPppoePassword);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsTaggedFlag));
		tfUtsDot3Onu2RmsTaggedFlag.setName(fStringMap
				.getString("utsDot3Onu2RmsTaggedFlag"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsTaggedFlag);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsCvlan));
		tfUtsDot3Onu2RmsCvlan.setName(fStringMap
				.getString("utsDot3Onu2RmsCvlan"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsCvlan);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsSvlan));
		tfUtsDot3Onu2RmsSvlan.setName(fStringMap
				.getString("utsDot3Onu2RmsSvlan"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsSvlan);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsPriority));
		tfUtsDot3Onu2RmsPriority.setName(fStringMap
				.getString("utsDot3Onu2RmsPriority"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsPriority);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsUrlBlockNum));
		tfUtsDot3Onu2RmsUrlBlockNum.setName(fStringMap
				.getString("utsDot3Onu2RmsUrlBlockNum"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsUrlBlockNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsUrlBlockSequence));
		tfUtsDot3Onu2RmsUrlBlockSequence.setName(fStringMap
				.getString("utsDot3Onu2RmsUrlBlockSequence"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsUrlBlockSequence);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2RmsUrl));
		tfUtsDot3Onu2RmsUrl.setName(fStringMap.getString("utsDot3Onu2RmsUrl"));
		baseInfoPanel.add(tfUtsDot3Onu2RmsUrl);
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

		tfUtsDot3Onu2RmsPppoeUserName.setLenScope(0, 32);

		tfUtsDot3Onu2RmsPppoePassword.setLenScope(0, 32);

		tfUtsDot3Onu2RmsCvlan.setValueScope(1, 4094);

		tfUtsDot3Onu2RmsSvlan.setValueScope(0, 4094);

		tfUtsDot3Onu2RmsPriority.setValueScope(0, 7);

		tfUtsDot3Onu2RmsUrlBlockNum.setValueScope(1, 255);

		tfUtsDot3Onu2RmsUrlBlockSequence.setValueScope(0, 255);

		tfUtsDot3Onu2RmsUrl.setLenScope(0, 125);

	}

	public void refresh() {

		Dot3Onu2RmsConfigTable mbean = (Dot3Onu2RmsConfigTable) getModel();

		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2VoipModuleId()
				.toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2VoipDeviceId()
				.toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2VoipPortId()
				.toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean
				.getUtsDot3Onu2VoipLogicalPortId().toString());
		tfUtsDot3Onu2RmsIpMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2RmsIpModeVList, mbean.getUtsDot3Onu2RmsIpMode()
						.intValue()));
		tfUtsDot3Onu2RmsIpAddress.setValue(mbean.getUtsDot3Onu2RmsIpAddress());
		tfUtsDot3Onu2RmsNetmask.setValue(mbean.getUtsDot3Onu2RmsNetmask());
		tfUtsDot3Onu2RmsDefaultGw.setValue(mbean.getUtsDot3Onu2RmsDefaultGw());
		tfUtsDot3Onu2RmsPppoeMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2RmsPppoeModeVList, mbean
						.getUtsDot3Onu2RmsPppoeMode().intValue()));
		tfUtsDot3Onu2RmsPppoeUserName.setValue(mbean
				.getUtsDot3Onu2RmsPppoeUserName());
		tfUtsDot3Onu2RmsPppoePassword.setValue(mbean
				.getUtsDot3Onu2RmsPppoePassword());
		tfUtsDot3Onu2RmsTaggedFlag.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2RmsTaggedFlagVList, mbean
						.getUtsDot3Onu2RmsTaggedFlag().intValue()));
		tfUtsDot3Onu2RmsCvlan.setValue(mbean.getUtsDot3Onu2RmsCvlan()
				.intValue());
		tfUtsDot3Onu2RmsSvlan.setValue(mbean.getUtsDot3Onu2RmsSvlan()
				.intValue());
		tfUtsDot3Onu2RmsPriority.setValue(mbean.getUtsDot3Onu2RmsPriority()
				.intValue());
		tfUtsDot3Onu2RmsUrlBlockNum.setValue(mbean
				.getUtsDot3Onu2RmsUrlBlockNum().intValue());
		tfUtsDot3Onu2RmsUrlBlockSequence.setValue(mbean
				.getUtsDot3Onu2RmsUrlBlockSequence().intValue());
		tfUtsDot3Onu2RmsUrl.setValue(mbean.getUtsDot3Onu2RmsUrl());

	}

	public void updateModel() {

		Dot3Onu2RmsConfigTable mbean = (Dot3Onu2RmsConfigTable) getModel();

		mbean.setUtsDot3Onu2RmsIpMode(new Integer(
				utsDot3Onu2RmsIpModeVList[tfUtsDot3Onu2RmsIpMode
						.getSelectedIndex()]));
		mbean.setUtsDot3Onu2RmsIpAddress(new String(tfUtsDot3Onu2RmsIpAddress
				.getValue()));
		mbean.setUtsDot3Onu2RmsNetmask(new String(tfUtsDot3Onu2RmsNetmask
				.getValue()));
		mbean.setUtsDot3Onu2RmsDefaultGw(new String(tfUtsDot3Onu2RmsDefaultGw
				.getValue()));
		mbean.setUtsDot3Onu2RmsPppoeMode(new Integer(
				utsDot3Onu2RmsPppoeModeVList[tfUtsDot3Onu2RmsPppoeMode
						.getSelectedIndex()]));
		mbean.setUtsDot3Onu2RmsPppoeUserName(new String(
				tfUtsDot3Onu2RmsPppoeUserName.getValue()));
		mbean.setUtsDot3Onu2RmsPppoePassword(new String(
				tfUtsDot3Onu2RmsPppoePassword.getValue()));
		mbean.setUtsDot3Onu2RmsTaggedFlag(new Integer(
				utsDot3Onu2RmsTaggedFlagVList[tfUtsDot3Onu2RmsTaggedFlag
						.getSelectedIndex()]));
		mbean.setUtsDot3Onu2RmsCvlan(new Integer(tfUtsDot3Onu2RmsCvlan
				.getValue()));
		mbean.setUtsDot3Onu2RmsSvlan(new Integer(tfUtsDot3Onu2RmsSvlan
				.getValue()));
		mbean.setUtsDot3Onu2RmsPriority(new Integer(tfUtsDot3Onu2RmsPriority
				.getValue()));
		mbean.setUtsDot3Onu2RmsUrlBlockNum(new Integer(
				tfUtsDot3Onu2RmsUrlBlockNum.getValue()));
		mbean.setUtsDot3Onu2RmsUrlBlockSequence(new Integer(
				tfUtsDot3Onu2RmsUrlBlockSequence.getValue()));
		mbean.setUtsDot3Onu2RmsUrl(new String(tfUtsDot3Onu2RmsUrl.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Onu2VoipGlobalSettingTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Onu2VoipGlobalOffSettingTablePanel extends UPanel {
	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private int[] utsDot3Onu2VoipVoiceIpModeVList = new int[] { 0, 1, 2, };
	private String[] utsDot3Onu2VoipVoiceIpModeTList = new String[] { fStringMap.getString("staticIp"), fStringMap.getString("dhcp"),
			fStringMap.getString("pppoe"), };

	private JComboBox tfUtsDot3Onu2VoipVoiceIpMode = new JComboBox(utsDot3Onu2VoipVoiceIpModeTList);
	private IPAddressField tfUtsDot3Onu2VoipIadIpAddr = new IPAddressField();

	private IPAddressField tfUtsDot3Onu2VoipIadNetmask = new IPAddressField(true);

	private IPAddressField tfUtsDot3Onu2VoipIadDefGw = new IPAddressField();

	private int[] utsDot3Onu2VoipPppoeModeVList = new int[] { 2, 1, 0, };
	private String[] utsDot3Onu2VoipPppoeModeTList = new String[] { fStringMap.getString("pap"),
			fStringMap.getString("chap"), fStringMap.getString("auto"), };
	private JComboBox tfUtsDot3Onu2VoipPppoeMode = new JComboBox(utsDot3Onu2VoipPppoeModeTList);
	private StringTextField tfUtsDot3Onu2VoipPppoeUserName = new StringTextField();

	private StringTextField tfUtsDot3Onu2VoipPppoePassword = new StringTextField();

	private int[] utsDot3Onu2VoipTaggedFlagVList = new int[] { 2, 1, 0, };
	private String[] utsDot3Onu2VoipTaggedFlagTList = new String[] { fStringMap.getString("vlanStack"),
			fStringMap.getString("tag"), fStringMap.getString("transparent"), };
	private JComboBox tfUtsDot3Onu2VoipTaggedFlag = new JComboBox(utsDot3Onu2VoipTaggedFlagTList);
	private IntegerTextField tfUtsDot3Onu2VoipVoiceCvid = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipVoiceSvid = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipVoicePri = new IntegerTextField();
	
	private int[] utsDot3Onu2VoipIadConfiguredProtocolVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2VoipIadConfiguredProtocolTList = new String[] {
			fStringMap.getString("h248"), fStringMap.getString("sip"), };
	private JComboBox tfUtsDot3Onu2VoipIadConfiguredProtocol = new JComboBox(
			utsDot3Onu2VoipIadConfiguredProtocolTList);

	private final String utsDot3Onu2VoipModuleId = fStringMap.getString("utsDot3Onu2VoipModuleId") + " : ";
	private final String utsDot3Onu2VoipDeviceId = fStringMap.getString("utsDot3Onu2VoipDeviceId") + " : ";
	private final String utsDot3Onu2VoipPortId = fStringMap.getString("utsDot3Onu2VoipPortId") + " : ";
	private final String utsDot3Onu2VoipLogicalPortId = fStringMap.getString("utsDot3Onu2VoipLogicalPortId") + " : ";

	private final String utsDot3Onu2VoipVoiceIpMode = fStringMap.getString("utsDot3Onu2VoipVoiceIpMode") + " : ";
	private final String utsDot3Onu2VoipIadIpAddr = fStringMap.getString("utsDot3Onu2VoipIadIpAddr") + " : ";
	private final String utsDot3Onu2VoipIadNetmask = fStringMap.getString("utsDot3Onu2VoipIadNetmask") + " : ";
	private final String utsDot3Onu2VoipIadDefGw = fStringMap.getString("utsDot3Onu2VoipIadDefGw") + " : ";
	private final String utsDot3Onu2VoipPppoeMode = fStringMap.getString("utsDot3Onu2VoipPppoeMode") + " : ";
	private final String utsDot3Onu2VoipPppoeUserName = fStringMap.getString("utsDot3Onu2VoipPppoeUserName") + " : ";
	private final String utsDot3Onu2VoipPppoePassword = fStringMap.getString("utsDot3Onu2VoipPppoePassword") + " : ";
	private final String utsDot3Onu2VoipTaggedFlag = fStringMap.getString("utsDot3Onu2VoipTaggedFlag") + " : ";
	private final String utsDot3Onu2VoipVoiceCvid = fStringMap.getString("utsDot3Onu2VoipVoiceCvid") + " : ";
	private final String utsDot3Onu2VoipVoiceSvid = fStringMap.getString("utsDot3Onu2VoipVoiceSvid") + " : ";
	private final String utsDot3Onu2VoipVoicePri = fStringMap.getString("utsDot3Onu2VoipVoicePri") + " : ";
	private final String utsDot3Onu2VoipIadConfiguredProtocol = fStringMap.getString("utsDot3Onu2VoipIadConfiguredProtocol") + " : ";

	public Onu2VoipGlobalOffSettingTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(15, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipModuleId);
		baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3Onu2VoipDeviceId));
		// baseInfoPanel.add(tfUtsDot3Onu2VoipDeviceId);
		// baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipVoiceIpMode));
		tfUtsDot3Onu2VoipVoiceIpMode.setName(fStringMap.getString("utsDot3Onu2VoipVoiceIpMode"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipVoiceIpMode);
		baseInfoPanel.add(new HSpacer());
		tfUtsDot3Onu2VoipVoiceIpMode.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				changeItemStateByVoipVoiceIpMode();
			}
		});

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadIpAddr));
		tfUtsDot3Onu2VoipIadIpAddr.setName(fStringMap.getString("utsDot3Onu2VoipIadIpAddr"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadIpAddr);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadNetmask));
		tfUtsDot3Onu2VoipIadNetmask.setName(fStringMap.getString("utsDot3Onu2VoipIadNetmask"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadNetmask);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadDefGw));
		tfUtsDot3Onu2VoipIadDefGw.setName(fStringMap.getString("utsDot3Onu2VoipIadDefGw"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadDefGw);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPppoeMode));
		tfUtsDot3Onu2VoipPppoeMode.setName(fStringMap.getString("utsDot3Onu2VoipPppoeMode"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPppoeMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPppoeUserName));
		tfUtsDot3Onu2VoipPppoeUserName.setName(fStringMap.getString("utsDot3Onu2VoipPppoeUserName"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPppoeUserName);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPppoePassword));
		tfUtsDot3Onu2VoipPppoePassword.setName(fStringMap.getString("utsDot3Onu2VoipPppoePassword"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPppoePassword);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipTaggedFlag));
		tfUtsDot3Onu2VoipTaggedFlag.setName(fStringMap.getString("utsDot3Onu2VoipTaggedFlag"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipTaggedFlag);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipVoiceCvid));
		tfUtsDot3Onu2VoipVoiceCvid.setName(fStringMap.getString("utsDot3Onu2VoipVoiceCvid"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipVoiceCvid);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipVoiceSvid));
		tfUtsDot3Onu2VoipVoiceSvid.setName(fStringMap.getString("utsDot3Onu2VoipVoiceSvid"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipVoiceSvid);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipVoicePri));
		tfUtsDot3Onu2VoipVoicePri.setName(fStringMap.getString("utsDot3Onu2VoipVoicePri"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipVoicePri);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadConfiguredProtocol));
		tfUtsDot3Onu2VoipIadConfiguredProtocol.setName(fStringMap.getString("utsDot3Onu2VoipIadConfiguredProtocol"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadConfiguredProtocol);
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

		tfUtsDot3Onu2VoipPppoeUserName.setLenScope(0, 32);

		tfUtsDot3Onu2VoipPppoePassword.setLenScope(0, 32);

		tfUtsDot3Onu2VoipVoiceCvid.setValueScope(1, 4094);

		tfUtsDot3Onu2VoipVoiceSvid.setValueScope(0, 4094);

		tfUtsDot3Onu2VoipVoicePri.setValueScope(0, 7);
	}

	public void refresh() {

		Onu2VoipGlobalSettingTable mbean = (Onu2VoipGlobalSettingTable) getModel();

		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId().toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());

		tfUtsDot3Onu2VoipVoiceIpMode.setSelectedIndex(
				getIndexFromValue(utsDot3Onu2VoipVoiceIpModeVList, mbean.getUtsDot3Onu2CtcIadIpMode().intValue()));

		tfUtsDot3Onu2VoipIadIpAddr.setValue(mbean.getUtsDot3Onu2CtcIadIpAddr());
		tfUtsDot3Onu2VoipIadNetmask.setValue(mbean.getUtsDot3Onu2CtcIadNetMask());
		tfUtsDot3Onu2VoipIadDefGw.setValue(mbean.getUtsDot3Onu2CtcIadDefaultGw());

		tfUtsDot3Onu2VoipPppoeMode.setSelectedIndex(
				getIndexFromValue(utsDot3Onu2VoipPppoeModeVList, mbean.getUtsDot3Onu2CtcIadPppoeMode().intValue()));
		tfUtsDot3Onu2VoipPppoeUserName.setValue(mbean.getUtsDot3Onu2CtcIadPppoeUsername());
		tfUtsDot3Onu2VoipPppoePassword.setValue(mbean.getUtsDot3Onu2CtcIadPppoePassword());

		tfUtsDot3Onu2VoipTaggedFlag.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipTaggedFlagVList, mbean.getUtsDot3Onu2CtcIadTagMode().intValue()));
		tfUtsDot3Onu2VoipVoiceCvid.setValue(mbean.getUtsDot3Onu2CtcIadCvlan().intValue());
		tfUtsDot3Onu2VoipVoiceSvid.setValue(mbean.getUtsDot3Onu2CtcIadSvlan().intValue());
		tfUtsDot3Onu2VoipVoicePri.setValue(mbean.getUtsDot3Onu2CtcIadPriority().intValue());
		
		tfUtsDot3Onu2VoipIadConfiguredProtocol
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2VoipIadConfiguredProtocolVList, mbean
								.getUtsDot3Onu2CtcConfiguredVoipProtocol()
								.intValue()));


		changeItemStateByVoipVoiceIpMode();
	}

	public void updateModel() {

		Onu2VoipGlobalSettingTable mbean = (Onu2VoipGlobalSettingTable) getModel();

		mbean.setUtsDot3Onu2CtcIadIpMode(new Integer(utsDot3Onu2VoipVoiceIpModeVList[tfUtsDot3Onu2VoipVoiceIpMode
				.getSelectedIndex()]));
		mbean.setUtsDot3Onu2CtcIadIpAddr(new String(tfUtsDot3Onu2VoipIadIpAddr.getIPString()));
		mbean.setUtsDot3Onu2CtcIadNetMask(new String(tfUtsDot3Onu2VoipIadNetmask.getIPString()));
		mbean.setUtsDot3Onu2CtcIadDefaultGw(new String(tfUtsDot3Onu2VoipIadDefGw.getIPString()));
		mbean.setUtsDot3Onu2CtcIadPppoeMode(new Integer(utsDot3Onu2VoipPppoeModeVList[tfUtsDot3Onu2VoipPppoeMode
				.getSelectedIndex()]));
		mbean.setUtsDot3Onu2CtcIadPppoeUsername(new String(tfUtsDot3Onu2VoipPppoeUserName.getValue()));
		mbean.setUtsDot3Onu2CtcIadPppoePassword(new String(tfUtsDot3Onu2VoipPppoePassword.getValue()));
		mbean.setUtsDot3Onu2CtcIadTagMode(new Integer(utsDot3Onu2VoipTaggedFlagVList[tfUtsDot3Onu2VoipTaggedFlag
				.getSelectedIndex()]));
		mbean.setUtsDot3Onu2CtcIadCvlan(new Integer(tfUtsDot3Onu2VoipVoiceCvid.getValue()));
		mbean.setUtsDot3Onu2CtcIadSvlan(new Integer(tfUtsDot3Onu2VoipVoiceSvid.getValue()));
		mbean.setUtsDot3Onu2CtcIadPriority(new Integer(tfUtsDot3Onu2VoipVoicePri.getValue()));
		
		mbean
				.setUtsDot3Onu2CtcConfiguredVoipProtocol(new Integer(
						utsDot3Onu2VoipIadConfiguredProtocolVList[tfUtsDot3Onu2VoipIadConfiguredProtocol
								.getSelectedIndex()]));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

	public void changeItemStateByVoipVoiceIpMode() {
		switch(utsDot3Onu2VoipVoiceIpModeVList[tfUtsDot3Onu2VoipVoiceIpMode.getSelectedIndex()]) {
		case 0:
			tfUtsDot3Onu2VoipIadIpAddr.setEnabled(true);
			tfUtsDot3Onu2VoipIadNetmask.setEnabled(true);
			tfUtsDot3Onu2VoipIadDefGw.setEnabled(true);
			tfUtsDot3Onu2VoipPppoeMode.setEnabled(false);
			tfUtsDot3Onu2VoipPppoeUserName.setEnabled(false);
			tfUtsDot3Onu2VoipPppoePassword.setEnabled(false);
			break;
		case 1:
			tfUtsDot3Onu2VoipIadIpAddr.setEnabled(false);
			tfUtsDot3Onu2VoipIadNetmask.setEnabled(false);
			tfUtsDot3Onu2VoipIadDefGw.setEnabled(false);
			tfUtsDot3Onu2VoipPppoeMode.setEnabled(false);
			tfUtsDot3Onu2VoipPppoeUserName.setEnabled(false);
			tfUtsDot3Onu2VoipPppoePassword.setEnabled(false);
			break;
		case 2:
			tfUtsDot3Onu2VoipIadIpAddr.setEnabled(false);
			tfUtsDot3Onu2VoipIadNetmask.setEnabled(false);
			tfUtsDot3Onu2VoipIadDefGw.setEnabled(false);
			tfUtsDot3Onu2VoipPppoeMode.setEnabled(true);
			tfUtsDot3Onu2VoipPppoeUserName.setEnabled(true);
			tfUtsDot3Onu2VoipPppoePassword.setEnabled(true);
			break;
		default:
			break;
		}
	}
}
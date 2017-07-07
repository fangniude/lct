package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipSipSettingTable;
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

/**
 * The Dot3Onu2VoipSipSettingTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2VoipSipSettingTablePanel extends UPanel {
	
	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private IntegerTextField tfUtsDot3Onu2VoipSipMgPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2VoipSipPrimaryProxyServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2VoipSipPrimaryProxyServPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2VoipSipBackupProxyServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2VoipSipBackupProxyServPort = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipSipActiveProxyServer = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2VoipSipPrimaryRegServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2VoipSipPrimaryRegServPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2VoipSipBackupRegServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2VoipSipBackupRegServPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2VoipSipOutboundServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2VoipSipOutboundServPort = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipSipRegInterval = new IntegerTextField();

	private int[] utsDot3Onu2VoipSipHeartbeatSwitchVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2VoipSipHeartbeatSwitchTList = new String[] {
			fStringMap.getString("heartbeatOn"),
			fStringMap.getString("heartbeatOff"), };
	private JComboBox tfUtsDot3Onu2VoipSipHeartbeatSwitch = new JComboBox(
			utsDot3Onu2VoipSipHeartbeatSwitchTList);
	private IntegerTextField tfUtsDot3Onu2VoipSipHeartbeatCycle = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipSipHeartbeatCount = new IntegerTextField();

	private StringTextField tfUtsDot3Onu2VoipSipDigitmap = new StringTextField();

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

	private final String utsDot3Onu2VoipSipMgPort = fStringMap
			.getString("utsDot3Onu2VoipSipMgPort")
			+ " : ";
	private final String utsDot3Onu2VoipSipPrimaryProxyServIp = fStringMap
			.getString("utsDot3Onu2VoipSipPrimaryProxyServIp")
			+ " : ";
	private final String utsDot3Onu2VoipSipPrimaryProxyServPort = fStringMap
			.getString("utsDot3Onu2VoipSipPrimaryProxyServPort")
			+ " : ";
	private final String utsDot3Onu2VoipSipBackupProxyServIp = fStringMap
			.getString("utsDot3Onu2VoipSipBackupProxyServIp")
			+ " : ";
	private final String utsDot3Onu2VoipSipBackupProxyServPort = fStringMap
			.getString("utsDot3Onu2VoipSipBackupProxyServPort")
			+ " : ";
	private final String utsDot3Onu2VoipSipActiveProxyServer = fStringMap
			.getString("utsDot3Onu2VoipSipActiveProxyServer")
			+ " : ";
	private final String utsDot3Onu2VoipSipPrimaryRegServIp = fStringMap
			.getString("utsDot3Onu2VoipSipPrimaryRegServIp")
			+ " : ";
	private final String utsDot3Onu2VoipSipPrimaryRegServPort = fStringMap
			.getString("utsDot3Onu2VoipSipPrimaryRegServPort")
			+ " : ";
	private final String utsDot3Onu2VoipSipBackupRegServIp = fStringMap
			.getString("utsDot3Onu2VoipSipBackupRegServIp")
			+ " : ";
	private final String utsDot3Onu2VoipSipBackupRegServPort = fStringMap
			.getString("utsDot3Onu2VoipSipBackupRegServPort")
			+ " : ";
	private final String utsDot3Onu2VoipSipOutboundServIp = fStringMap
			.getString("utsDot3Onu2VoipSipOutboundServIp")
			+ " : ";
	private final String utsDot3Onu2VoipSipOutboundServPort = fStringMap
			.getString("utsDot3Onu2VoipSipOutboundServPort")
			+ " : ";
	private final String utsDot3Onu2VoipSipRegInterval = fStringMap
			.getString("utsDot3Onu2VoipSipRegInterval")
			+ " : ";
	private final String utsDot3Onu2VoipSipHeartbeatSwitch = fStringMap
			.getString("utsDot3Onu2VoipSipHeartbeatSwitch")
			+ " : ";
	private final String utsDot3Onu2VoipSipHeartbeatCycle = fStringMap
			.getString("utsDot3Onu2VoipSipHeartbeatCycle")
			+ " : ";
	private final String utsDot3Onu2VoipSipHeartbeatCount = fStringMap
			.getString("utsDot3Onu2VoipSipHeartbeatCount")
			+ " : ";
	private final String utsDot3Onu2VoipSipDigitmap = fStringMap
			.getString("utsDot3Onu2VoipSipDigitmap")
			+ " : ";

	public Dot3Onu2VoipSipSettingTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(20, 3, NTLayout.FILL, NTLayout.CENTER,
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipMgPort));
		tfUtsDot3Onu2VoipSipMgPort.setName(fStringMap
				.getString("utsDot3Onu2VoipSipMgPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipMgPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipPrimaryProxyServIp));
		tfUtsDot3Onu2VoipSipPrimaryProxyServIp.setName(fStringMap
				.getString("utsDot3Onu2VoipSipPrimaryProxyServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipPrimaryProxyServIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipPrimaryProxyServPort));
		tfUtsDot3Onu2VoipSipPrimaryProxyServPort.setName(fStringMap
				.getString("utsDot3Onu2VoipSipPrimaryProxyServPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipPrimaryProxyServPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipBackupProxyServIp));
		tfUtsDot3Onu2VoipSipBackupProxyServIp.setName(fStringMap
				.getString("utsDot3Onu2VoipSipBackupProxyServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipBackupProxyServIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipBackupProxyServPort));
		tfUtsDot3Onu2VoipSipBackupProxyServPort.setName(fStringMap
				.getString("utsDot3Onu2VoipSipBackupProxyServPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipBackupProxyServPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipActiveProxyServer));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipActiveProxyServer);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipPrimaryRegServIp));
		tfUtsDot3Onu2VoipSipPrimaryRegServIp.setName(fStringMap
				.getString("utsDot3Onu2VoipSipPrimaryRegServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipPrimaryRegServIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipPrimaryRegServPort));
		tfUtsDot3Onu2VoipSipPrimaryRegServPort.setName(fStringMap
				.getString("utsDot3Onu2VoipSipPrimaryRegServPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipPrimaryRegServPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipBackupRegServIp));
		tfUtsDot3Onu2VoipSipBackupRegServIp.setName(fStringMap
				.getString("utsDot3Onu2VoipSipBackupRegServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipBackupRegServIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipBackupRegServPort));
		tfUtsDot3Onu2VoipSipBackupRegServPort.setName(fStringMap
				.getString("utsDot3Onu2VoipSipBackupRegServPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipBackupRegServPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipOutboundServIp));
		tfUtsDot3Onu2VoipSipOutboundServIp.setName(fStringMap
				.getString("utsDot3Onu2VoipSipOutboundServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipOutboundServIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipOutboundServPort));
		tfUtsDot3Onu2VoipSipOutboundServPort.setName(fStringMap
				.getString("utsDot3Onu2VoipSipOutboundServPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipOutboundServPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipRegInterval));
		tfUtsDot3Onu2VoipSipRegInterval.setName(fStringMap
				.getString("utsDot3Onu2VoipSipRegInterval"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipRegInterval);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipHeartbeatSwitch));
		tfUtsDot3Onu2VoipSipHeartbeatSwitch.setName(fStringMap
				.getString("utsDot3Onu2VoipSipHeartbeatSwitch"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipHeartbeatSwitch);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipHeartbeatCycle));
		tfUtsDot3Onu2VoipSipHeartbeatCycle.setName(fStringMap
				.getString("utsDot3Onu2VoipSipHeartbeatCycle"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipHeartbeatCycle);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipHeartbeatCount));
		tfUtsDot3Onu2VoipSipHeartbeatCount.setName(fStringMap
				.getString("utsDot3Onu2VoipSipHeartbeatCount"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipHeartbeatCount);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipSipDigitmap));
		tfUtsDot3Onu2VoipSipDigitmap.setName(fStringMap
				.getString("utsDot3Onu2VoipSipDigitmap"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipSipDigitmap);
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
		tfUtsDot3Onu2VoipSipMgPort.setValueScope(1, 65535);

		tfUtsDot3Onu2VoipSipPrimaryProxyServPort.setValueScope(1, 65535);

		tfUtsDot3Onu2VoipSipBackupProxyServPort.setValueScope(0, 65535);

		tfUtsDot3Onu2VoipSipPrimaryRegServPort.setValueScope(1, 65535);

		tfUtsDot3Onu2VoipSipBackupRegServPort.setValueScope(0, 65535);

		tfUtsDot3Onu2VoipSipOutboundServPort.setValueScope(1, 65535);

		tfUtsDot3Onu2VoipSipRegInterval.setValueScope(1, 65535);

		tfUtsDot3Onu2VoipSipHeartbeatCycle.setValueScope(10, 1800);

		tfUtsDot3Onu2VoipSipHeartbeatCount.setValueScope(1, 10);

		tfUtsDot3Onu2VoipSipDigitmap.setLenScope(0, 1024);

	}

	public void refresh() {

		Dot3Onu2VoipSipSettingTable mbean = (Dot3Onu2VoipSipSettingTable) getModel();

		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId()
				.toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId()
				.toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId()
				.toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean
				.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());
		
		tfUtsDot3Onu2VoipSipMgPort.setValue(mbean.getUtsDot3Onu2CtcSipMgPort()
				.intValue());
		tfUtsDot3Onu2VoipSipPrimaryProxyServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipProxyServIp());
		tfUtsDot3Onu2VoipSipPrimaryProxyServPort.setValue(mbean
				.getUtsDot3Onu2CtcSipProxyServComPort().intValue());
		tfUtsDot3Onu2VoipSipBackupProxyServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipBackupProxyServIp());
		tfUtsDot3Onu2VoipSipBackupProxyServPort.setValue(mbean
				.getUtsDot3Onu2CtcSipBackupProxyServComPort().intValue());
		tfUtsDot3Onu2VoipSipActiveProxyServer.setValue(mbean
				.getUtsDot3Onu2CtcSipActiveProxyServ());
		tfUtsDot3Onu2VoipSipActiveProxyServer.setEnabled(false);
		tfUtsDot3Onu2VoipSipPrimaryRegServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipRegServIp());
		tfUtsDot3Onu2VoipSipPrimaryRegServPort.setValue(mbean
				.getUtsDot3Onu2CtcSipRegServComPort().intValue());
		tfUtsDot3Onu2VoipSipBackupRegServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipBackupRegServIp());
		tfUtsDot3Onu2VoipSipBackupRegServPort.setValue(mbean
				.getUtsDot3Onu2CtcSipBackupRegServComPort().intValue());
		tfUtsDot3Onu2VoipSipOutboundServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipOutBoundServIp());
		tfUtsDot3Onu2VoipSipOutboundServPort.setValue(mbean
				.getUtsDot3Onu2CtcSipOutBoundServPort().intValue());
		tfUtsDot3Onu2VoipSipRegInterval.setValue(mbean
				.getUtsDot3Onu2CtcSipRegInterval().intValue());
		tfUtsDot3Onu2VoipSipHeartbeatSwitch.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipSipHeartbeatSwitchVList, mbean
						.getUtsDot3Onu2CtcSipHeartbeatSwitch().intValue()));
		tfUtsDot3Onu2VoipSipHeartbeatCycle.setValue(mbean
				.getUtsDot3Onu2CtcSipHeartbeatCycle().intValue());
		tfUtsDot3Onu2VoipSipHeartbeatCount.setValue(mbean
				.getUtsDot3Onu2CtcSipHeartbeatCount().intValue());
//		tfUtsDot3Onu2VoipSipDigitmap.setValue(mbean
//				.getUtsDot3Onu2CtcSipDigitmap());

	}

	public void updateModel() {

		Dot3Onu2VoipSipSettingTable mbean = (Dot3Onu2VoipSipSettingTable) getModel();

		mbean.setUtsDot3Onu2CtcSipMgPort(new Integer(
				tfUtsDot3Onu2VoipSipMgPort.getValue()));
		mbean.setUtsDot3Onu2CtcSipProxyServIp(new String(
				tfUtsDot3Onu2VoipSipPrimaryProxyServIp.getIPString()));
		mbean.setUtsDot3Onu2CtcSipProxyServComPort(new Integer(
				tfUtsDot3Onu2VoipSipPrimaryProxyServPort.getValue()));
		mbean.setUtsDot3Onu2CtcSipBackupProxyServIp(new String(
				tfUtsDot3Onu2VoipSipBackupProxyServIp.getIPString()));
		mbean.setUtsDot3Onu2CtcSipBackupProxyServComPort(new Integer(
				tfUtsDot3Onu2VoipSipBackupProxyServPort.getValue()));

		mbean.setUtsDot3Onu2CtcSipRegServIp(new String(
				tfUtsDot3Onu2VoipSipPrimaryRegServIp.getIPString()));
		mbean.setUtsDot3Onu2CtcSipRegServComPort(new Integer(
				tfUtsDot3Onu2VoipSipPrimaryRegServPort.getValue()));
		mbean.setUtsDot3Onu2CtcSipBackupRegServIp(new String(
				tfUtsDot3Onu2VoipSipBackupRegServIp.getIPString()));
		mbean.setUtsDot3Onu2CtcSipBackupRegServComPort(new Integer(
				tfUtsDot3Onu2VoipSipBackupRegServPort.getValue()));
		mbean.setUtsDot3Onu2CtcSipOutBoundServIp(new String(
				tfUtsDot3Onu2VoipSipOutboundServIp.getIPString()));
		mbean.setUtsDot3Onu2CtcSipOutBoundServPort(new Integer(
				tfUtsDot3Onu2VoipSipOutboundServPort.getValue()));
		mbean.setUtsDot3Onu2CtcSipRegInterval(new Integer(
				tfUtsDot3Onu2VoipSipRegInterval.getValue()));
		mbean
				.setUtsDot3Onu2CtcSipHeartbeatSwitch(new Integer(
						utsDot3Onu2VoipSipHeartbeatSwitchVList[tfUtsDot3Onu2VoipSipHeartbeatSwitch
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2CtcSipHeartbeatCycle(new Integer(
				tfUtsDot3Onu2VoipSipHeartbeatCycle.getValue()));
		mbean.setUtsDot3Onu2CtcSipHeartbeatCount(new Integer(
				tfUtsDot3Onu2VoipSipHeartbeatCount.getValue()));
//		mbean.setUtsDot3Onu2CtcSipDigitmap(new String(
//				tfUtsDot3Onu2VoipSipDigitmap.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipH248SettingTable;
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

/**
 * The Dot3Onu2VoipH248SettingTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2VoipH248SettingTablePanel extends UPanel {
	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private IntegerTextField tfUtsDot3Onu2VoipH248MgPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2VoipH248PrimaryMgcIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2VoipH248PrimaryMgcPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2VoipH248BackupMgcIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2VoipH248BackupMgcPort = new IntegerTextField();

	private int[] utsDot3Onu2VoipH248ActiveMgcVList = new int[] { 1, 0, };
	private String[] utsDot3Onu2VoipH248ActiveMgcTList = new String[] {
			fStringMap.getString("primaryMgc"),
			fStringMap.getString("backupMgc"), };
	private JComboBox tfUtsDot3Onu2VoipH248ActiveMgc = new JComboBox(
			utsDot3Onu2VoipH248ActiveMgcTList);
	private int[] utsDot3Onu2VoipH248RegisterModeVList = new int[] { 1, 0, 2, };
	private String[] utsDot3Onu2VoipH248RegisterModeTList = new String[] {
			fStringMap.getString("domainName"), fStringMap.getString("ip"),
			fStringMap.getString("deviceName"), };
	private JComboBox tfUtsDot3Onu2VoipH248RegisterMode = new JComboBox(
			utsDot3Onu2VoipH248RegisterModeTList);
	private StringTextField tfUtsDot3Onu2VoipH248Mid = new StringTextField();

	private int[] utsDot3Onu2VoipH248HeartbeatModeVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2VoipH248HeartbeatModeTList = new String[] {
			fStringMap.getString("notUse"), fStringMap.getString("ctcNotify"), };
	private JComboBox tfUtsDot3Onu2VoipH248HeartbeatMode = new JComboBox(
			utsDot3Onu2VoipH248HeartbeatModeTList);
	private IntegerTextField tfUtsDot3Onu2VoipH248HeartbeatCycle = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipH248HeartbeatCount = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipH248RtpTidNum = new IntegerTextField();

	private StringTextField tfUtsDot3Onu2VoipH248RtpTidPrefix = new StringTextField();

	private IntegerTextField tfUtsDot3Onu2VoipH248RtpTidDigitBegin = new IntegerTextField();

	private int[] utsDot3Onu2VoipH248RtpTidModeVList = new int[] { 1, 0, };
	private String[] utsDot3Onu2VoipH248RtpTidModeTList = new String[] {
			fStringMap.getString("notAlign"), fStringMap.getString("align"), };
	private JComboBox tfUtsDot3Onu2VoipH248RtpTidMode = new JComboBox(
			utsDot3Onu2VoipH248RtpTidModeTList);
	private IntegerTextField tfUtsDot3Onu2VoipH248RtpTidDigitLen = new IntegerTextField();

	private StringTextField tfUtsDot3Onu2VoipH248FirstRtpTidName = new StringTextField();

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

	private final String utsDot3Onu2VoipH248MgPort = fStringMap
			.getString("utsDot3Onu2VoipH248MgPort")
			+ " : ";
	private final String utsDot3Onu2VoipH248PrimaryMgcIp = fStringMap
			.getString("utsDot3Onu2VoipH248PrimaryMgcIp")
			+ " : ";
	private final String utsDot3Onu2VoipH248PrimaryMgcPort = fStringMap
			.getString("utsDot3Onu2VoipH248PrimaryMgcPort")
			+ " : ";
	private final String utsDot3Onu2VoipH248BackupMgcIp = fStringMap
			.getString("utsDot3Onu2VoipH248BackupMgcIp")
			+ " : ";
	private final String utsDot3Onu2VoipH248BackupMgcPort = fStringMap
			.getString("utsDot3Onu2VoipH248BackupMgcPort")
			+ " : ";
	private final String utsDot3Onu2VoipH248ActiveMgc = fStringMap
			.getString("utsDot3Onu2VoipH248ActiveMgc")
			+ " : ";
	private final String utsDot3Onu2VoipH248RegisterMode = fStringMap
			.getString("utsDot3Onu2VoipH248RegisterMode")
			+ " : ";
	private final String utsDot3Onu2VoipH248Mid = fStringMap
			.getString("utsDot3Onu2VoipH248Mid")
			+ " : ";
	private final String utsDot3Onu2VoipH248HeartbeatMode = fStringMap
			.getString("utsDot3Onu2VoipH248HeartbeatMode")
			+ " : ";
	private final String utsDot3Onu2VoipH248HeartbeatCycle = fStringMap
			.getString("utsDot3Onu2VoipH248HeartbeatCycle")
			+ " : ";
	private final String utsDot3Onu2VoipH248HeartbeatCount = fStringMap
			.getString("utsDot3Onu2VoipH248HeartbeatCount")
			+ " : ";
	private final String utsDot3Onu2VoipH248RtpTidNum = fStringMap
			.getString("utsDot3Onu2VoipH248RtpTidNum")
			+ " : ";
	private final String utsDot3Onu2VoipH248RtpTidPrefix = fStringMap
			.getString("utsDot3Onu2VoipH248RtpTidPrefix")
			+ " : ";
	private final String utsDot3Onu2VoipH248RtpTidDigitBegin = fStringMap
			.getString("utsDot3Onu2VoipH248RtpTidDigitBegin")
			+ " : ";
	private final String utsDot3Onu2VoipH248RtpTidMode = fStringMap
			.getString("utsDot3Onu2VoipH248RtpTidMode")
			+ " : ";
	private final String utsDot3Onu2VoipH248RtpTidDigitLen = fStringMap
			.getString("utsDot3Onu2VoipH248RtpTidDigitLen")
			+ " : ";
	private final String utsDot3Onu2VoipH248FirstRtpTidName = fStringMap
			.getString("utsDot3Onu2VoipH248FirstRtpTidName")
			+ " : ";

	public Dot3Onu2VoipH248SettingTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(19, 3, NTLayout.FILL, NTLayout.CENTER,
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248MgPort));
		tfUtsDot3Onu2VoipH248MgPort.setName(fStringMap
				.getString("utsDot3Onu2VoipH248MgPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248MgPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248PrimaryMgcIp));
		tfUtsDot3Onu2VoipH248PrimaryMgcIp.setName(fStringMap
				.getString("utsDot3Onu2VoipH248PrimaryMgcIp"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248PrimaryMgcIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248PrimaryMgcPort));
		tfUtsDot3Onu2VoipH248PrimaryMgcPort.setName(fStringMap
				.getString("utsDot3Onu2VoipH248PrimaryMgcPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248PrimaryMgcPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248BackupMgcIp));
		tfUtsDot3Onu2VoipH248BackupMgcIp.setName(fStringMap
				.getString("utsDot3Onu2VoipH248BackupMgcIp"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248BackupMgcIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248BackupMgcPort));
		tfUtsDot3Onu2VoipH248BackupMgcPort.setName(fStringMap
				.getString("utsDot3Onu2VoipH248BackupMgcPort"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248BackupMgcPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248ActiveMgc));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248ActiveMgc);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248RegisterMode));
		tfUtsDot3Onu2VoipH248RegisterMode.setName(fStringMap
				.getString("utsDot3Onu2VoipH248RegisterMode"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248RegisterMode);
		baseInfoPanel.add(new HSpacer());
		
		tfUtsDot3Onu2VoipH248RegisterMode.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		changeConfigItemByRegMode();
        	}
        });

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248Mid));
		tfUtsDot3Onu2VoipH248Mid.setName(fStringMap
				.getString("utsDot3Onu2VoipH248Mid"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248Mid);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248HeartbeatMode));
		tfUtsDot3Onu2VoipH248HeartbeatMode.setName(fStringMap
				.getString("utsDot3Onu2VoipH248HeartbeatMode"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248HeartbeatMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248HeartbeatCycle));
		tfUtsDot3Onu2VoipH248HeartbeatCycle.setName(fStringMap
				.getString("utsDot3Onu2VoipH248HeartbeatCycle"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248HeartbeatCycle);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248HeartbeatCount));
		tfUtsDot3Onu2VoipH248HeartbeatCount.setName(fStringMap
				.getString("utsDot3Onu2VoipH248HeartbeatCount"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248HeartbeatCount);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248RtpTidNum));
		tfUtsDot3Onu2VoipH248RtpTidNum.setName(fStringMap
				.getString("utsDot3Onu2VoipH248RtpTidNum"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248RtpTidNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248RtpTidPrefix));
		tfUtsDot3Onu2VoipH248RtpTidPrefix.setName(fStringMap
				.getString("utsDot3Onu2VoipH248RtpTidPrefix"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248RtpTidPrefix);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248RtpTidDigitBegin));
		tfUtsDot3Onu2VoipH248RtpTidDigitBegin.setName(fStringMap
				.getString("utsDot3Onu2VoipH248RtpTidDigitBegin"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248RtpTidDigitBegin);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248RtpTidMode));
		tfUtsDot3Onu2VoipH248RtpTidMode.setName(fStringMap
				.getString("utsDot3Onu2VoipH248RtpTidMode"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248RtpTidMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248RtpTidDigitLen));
		tfUtsDot3Onu2VoipH248RtpTidDigitLen.setName(fStringMap
				.getString("utsDot3Onu2VoipH248RtpTidDigitLen"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipH248RtpTidDigitLen);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipH248FirstRtpTidName));
//		tfUtsDot3Onu2VoipH248FirstRtpTidName.setName(fStringMap
//				.getString("utsDot3Onu2VoipH248FirstRtpTidName"));
//		baseInfoPanel.add(tfUtsDot3Onu2VoipH248FirstRtpTidName);
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
		tfUtsDot3Onu2VoipH248MgPort.setValueScope(1, 65535);

		tfUtsDot3Onu2VoipH248PrimaryMgcPort.setValueScope(1, 65535);

		tfUtsDot3Onu2VoipH248BackupMgcPort.setValueScope(0, 65535);

		tfUtsDot3Onu2VoipH248Mid.setLenScope(0, 64);

		tfUtsDot3Onu2VoipH248HeartbeatCycle.setValueScope(10, 1800);
		
		tfUtsDot3Onu2VoipH248HeartbeatCycle.setDefaultValue(60);

		tfUtsDot3Onu2VoipH248HeartbeatCount.setValueScope(1, 10);

		tfUtsDot3Onu2VoipH248RtpTidNum.setValueScope(1, 255);

		tfUtsDot3Onu2VoipH248RtpTidPrefix.setLenScope(0, 16);

		tfUtsDot3Onu2VoipH248RtpTidDigitLen.setValueScope(1, 16);
		
		tfUtsDot3Onu2VoipH248RtpTidDigitBegin.setValueScope( 0, Integer.MAX_VALUE );

//		tfUtsDot3Onu2VoipH248FirstRtpTidName.setLenScope(0, 32);

	}

	public void refresh() {

		Dot3Onu2VoipH248SettingTable mbean = (Dot3Onu2VoipH248SettingTable) getModel();

		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2VoipModuleId()
				.toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2VoipDeviceId()
				.toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2VoipPortId()
				.toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean
				.getUtsDot3Onu2VoipLogicalPortId().toString());
		
		tfUtsDot3Onu2VoipH248MgPort.setValue(mbean
				.getUtsDot3Onu2VoipH248MgPort().intValue());
		tfUtsDot3Onu2VoipH248PrimaryMgcIp.setValue(mbean
				.getUtsDot3Onu2VoipH248PrimaryMgcIp());
		tfUtsDot3Onu2VoipH248PrimaryMgcPort.setValue(mbean
				.getUtsDot3Onu2VoipH248PrimaryMgcPort().intValue());
		tfUtsDot3Onu2VoipH248BackupMgcIp.setValue(mbean
				.getUtsDot3Onu2VoipH248BackupMgcIp());
		tfUtsDot3Onu2VoipH248BackupMgcPort.setValue(mbean
				.getUtsDot3Onu2VoipH248BackupMgcPort().intValue());
		tfUtsDot3Onu2VoipH248ActiveMgc.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipH248ActiveMgcVList, mbean
						.getUtsDot3Onu2VoipH248ActiveMgc().intValue()));
		tfUtsDot3Onu2VoipH248RegisterMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipH248RegisterModeVList, mbean
						.getUtsDot3Onu2VoipH248RegisterMode().intValue()));
		tfUtsDot3Onu2VoipH248Mid.setValue(mbean.getUtsDot3Onu2VoipH248Mid());
		tfUtsDot3Onu2VoipH248HeartbeatMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipH248HeartbeatModeVList, mbean
						.getUtsDot3Onu2VoipH248HeartbeatMode().intValue()));
		if(mbean.getUtsDot3Onu2VoipH248HeartbeatCycle().intValue()<10||
				mbean.getUtsDot3Onu2VoipH248HeartbeatCycle().intValue()>1800){
			tfUtsDot3Onu2VoipH248HeartbeatCycle.setValue(60);
		}else{
			tfUtsDot3Onu2VoipH248HeartbeatCycle.setValue(mbean
				.getUtsDot3Onu2VoipH248HeartbeatCycle().intValue());
		}
		tfUtsDot3Onu2VoipH248HeartbeatCount.setValue(mbean
				.getUtsDot3Onu2VoipH248HeartbeatCount().intValue());
		tfUtsDot3Onu2VoipH248RtpTidNum.setValue(mbean
				.getUtsDot3Onu2VoipH248RtpTidNum().intValue());
		tfUtsDot3Onu2VoipH248RtpTidPrefix.setValue(mbean
				.getUtsDot3Onu2VoipH248RtpTidPrefix());
		tfUtsDot3Onu2VoipH248RtpTidDigitBegin.setValue(mbean
				.getUtsDot3Onu2VoipH248RtpTidDigitBegin().intValue());
		tfUtsDot3Onu2VoipH248RtpTidMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipH248RtpTidModeVList, mbean
						.getUtsDot3Onu2VoipH248RtpTidMode().intValue()));
		tfUtsDot3Onu2VoipH248RtpTidDigitLen.setValue(mbean
				.getUtsDot3Onu2VoipH248RtpTidDigitLen().intValue());
//		tfUtsDot3Onu2VoipH248FirstRtpTidName.setValue(mbean
//				.getUtsDot3Onu2VoipH248FirstRtpTidName());
		
		tfUtsDot3Onu2VoipH248ActiveMgc.setEnabled(false);
		
		changeConfigItemByRegMode();
		
	}

	public void updateModel() {

		Dot3Onu2VoipH248SettingTable mbean = (Dot3Onu2VoipH248SettingTable) getModel();

		mbean.setUtsDot3Onu2VoipH248MgPort(new Integer(
				tfUtsDot3Onu2VoipH248MgPort.getValue()));
		mbean.setUtsDot3Onu2VoipH248PrimaryMgcIp(new String(
				tfUtsDot3Onu2VoipH248PrimaryMgcIp.getIPString()));
		mbean.setUtsDot3Onu2VoipH248PrimaryMgcPort(new Integer(
				tfUtsDot3Onu2VoipH248PrimaryMgcPort.getValue()));
		mbean.setUtsDot3Onu2VoipH248BackupMgcIp(new String(
				tfUtsDot3Onu2VoipH248BackupMgcIp.getIPString()));
		mbean.setUtsDot3Onu2VoipH248BackupMgcPort(new Integer(
				tfUtsDot3Onu2VoipH248BackupMgcPort.getValue()));

		mbean
				.setUtsDot3Onu2VoipH248RegisterMode(new Integer(
						utsDot3Onu2VoipH248RegisterModeVList[tfUtsDot3Onu2VoipH248RegisterMode
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2VoipH248Mid(new String(tfUtsDot3Onu2VoipH248Mid
				.getValue()));
		mbean
				.setUtsDot3Onu2VoipH248HeartbeatMode(new Integer(
						utsDot3Onu2VoipH248HeartbeatModeVList[tfUtsDot3Onu2VoipH248HeartbeatMode
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2VoipH248HeartbeatCycle(new Integer(
				tfUtsDot3Onu2VoipH248HeartbeatCycle.getValue()));
		mbean.setUtsDot3Onu2VoipH248HeartbeatCount(new Integer(
				tfUtsDot3Onu2VoipH248HeartbeatCount.getValue()));
		mbean.setUtsDot3Onu2VoipH248RtpTidNum(new Integer(
				tfUtsDot3Onu2VoipH248RtpTidNum.getValue()));
		mbean.setUtsDot3Onu2VoipH248RtpTidPrefix(new String(
				tfUtsDot3Onu2VoipH248RtpTidPrefix.getValue()));
		mbean.setUtsDot3Onu2VoipH248RtpTidDigitBegin(new Integer(
				tfUtsDot3Onu2VoipH248RtpTidDigitBegin.getValue()));
		mbean
				.setUtsDot3Onu2VoipH248RtpTidMode(new Integer(
						utsDot3Onu2VoipH248RtpTidModeVList[tfUtsDot3Onu2VoipH248RtpTidMode
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2VoipH248RtpTidDigitLen(new Integer(
				tfUtsDot3Onu2VoipH248RtpTidDigitLen.getValue()));
//		mbean.setUtsDot3Onu2VoipH248FirstRtpTidName(new String(
//				tfUtsDot3Onu2VoipH248FirstRtpTidName.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
	
	public void changeConfigItemByRegMode() {
		tfUtsDot3Onu2VoipH248Mid.setEnabled(false);
    	if(utsDot3Onu2VoipH248RegisterModeVList[tfUtsDot3Onu2VoipH248RegisterMode.getSelectedIndex()] == 1 ||
    			utsDot3Onu2VoipH248RegisterModeVList[tfUtsDot3Onu2VoipH248RegisterMode.getSelectedIndex()] == 2) {
    		tfUtsDot3Onu2VoipH248Mid.setEnabled(true);
    	}
    }

}

package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Onu2CtcCombinedFeaturesTable;
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
 * The Dot3Onu2CtcCombinedFeaturesTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2CtcCombinedFeaturesTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2CtcCombinedFeaturesModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcCombinedFeaturesDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcCombinedFeaturesPortId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId = new JLabel();

//	private JLabel tfUtsDot3Onu2CtcMduResetCardCardNumber = new JLabel();

//	private IntegerTextField tfUtsDot3Onu2CtcMduResetCardReset = new IntegerTextField();

//	private int[] utsDot3Onu2CtcHoldoverActionVList = new int[] { 1, 2, };
//	private String[] utsDot3Onu2CtcHoldoverActionTList = new String[] {
//			fStringMap.getString("disable"), fStringMap.getString("enable"), };
//	private JComboBox tfUtsDot3Onu2CtcHoldoverAction = new JComboBox(
//			utsDot3Onu2CtcHoldoverActionTList);
//	private IntegerTextField tfUtsDot3Onu2CtcHoldoverTime = new IntegerTextField();

//	private IntegerTextField tfUtsDot3Onu2CtcActivePonifAdminActivePon = new IntegerTextField();

//	private IntegerTextField tfUtsDot3Onu2CtcTftpOamCommit = new IntegerTextField();

//	private JLabel tfUtsDot3Onu2CtcIadInfoMacAddr = new JLabel();

//	private JLabel tfUtsDot3Onu2CtcIadInfoSupportedProtocol = new JLabel();
	private int[] utsDot3Onu2CtcIadInfoSupportedProtocolVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2CtcIadInfoSupportedProtocolTList = new String[] {
			fStringMap.getString("H.248"), fStringMap.getString("SIP"), };
	private JComboBox tfUtsDot3Onu2CtcIadInfoSupportedProtocol = new JComboBox(
			utsDot3Onu2CtcIadInfoSupportedProtocolTList);
	
	private int[] utsDot3Onu2CtcConfiguredVoipProtocolVList = new int[] { 1, 2, 3, };
	private String[] utsDot3Onu2CtcConfiguredVoipProtocolTList = new String[] {
			fStringMap.getString("none"), fStringMap.getString("SIP"), fStringMap.getString("H.248"), };
	private JComboBox tfUtsDot3Onu2CtcConfiguredVoipProtocol = new JComboBox(
			utsDot3Onu2CtcConfiguredVoipProtocolTList);

//	private JLabel tfUtsDot3Onu2CtcIadInfoSoftwareVer = new JLabel();

//	private JLabel tfUtsDot3Onu2CtcIadInfoSoftwareDate = new JLabel();

//	private JLabel tfUtsDot3Onu2CtcIadInfoVoipUserCount = new JLabel();

	private int[] utsDot3Onu2CtcIadIpModeVList = new int[] { 1, 0, 2, };
	private String[] utsDot3Onu2CtcIadIpModeTList = new String[] {
			fStringMap.getString("dhcp"), fStringMap.getString("staticIp"),
			fStringMap.getString("pppoe"), };
	private JComboBox tfUtsDot3Onu2CtcIadIpMode = new JComboBox(
			utsDot3Onu2CtcIadIpModeTList);
	private IPAddressField tfUtsDot3Onu2CtcIadIpAddr = new IPAddressField();

	private IPAddressField tfUtsDot3Onu2CtcIadNetMask = new IPAddressField(IPAddressField.IPMASK);

	private IPAddressField tfUtsDot3Onu2CtcIadDefaultGw = new IPAddressField();

//	private int[] utsDot3Onu2CtcIadPppoeModeVList = new int[] { 2, 1, 0, };
//	private String[] utsDot3Onu2CtcIadPppoeModeTList = new String[] {
//			fStringMap.getString("pap"), fStringMap.getString("chap"),
//			fStringMap.getString("auto"), };
//	private JComboBox tfUtsDot3Onu2CtcIadPppoeMode = new JComboBox(
//			utsDot3Onu2CtcIadPppoeModeTList);
	private StringTextField tfUtsDot3Onu2CtcIadPppoeUsername = new StringTextField();

	private StringTextField tfUtsDot3Onu2CtcIadPppoePassword = new StringTextField();

	private int[] utsDot3Onu2CtcIadTagModeVList = new int[] { 2, 1, 0, };
	private String[] utsDot3Onu2CtcIadTagModeTList = new String[] {
			fStringMap.getString("vlanStack"), fStringMap.getString("tag"),
			fStringMap.getString("transparent"), };
	private JComboBox tfUtsDot3Onu2CtcIadTagMode = new JComboBox(
			utsDot3Onu2CtcIadTagModeTList);
	private IntegerTextField tfUtsDot3Onu2CtcIadCvlan = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2CtcIadSvlan = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2CtcIadPriority = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2CtcH248MgPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2CtcH248MgcIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2CtcH248MgpComPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2CtcH248BackupMgcIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2CtcH248BackupMgcComPort = new IntegerTextField();

//	private int[] utsDot3Onu2CtcH248ActiveMgcVList = new int[] { 1, 0, };
//	private String[] utsDot3Onu2CtcH248ActiveMgcTList = new String[] {
//			fStringMap.getString("primaryMgc"),
//			fStringMap.getString("backupMgc"), };
//	private JComboBox tfUtsDot3Onu2CtcH248ActiveMgc = new JComboBox(
//			utsDot3Onu2CtcH248ActiveMgcTList);
	private int[] utsDot3Onu2CtcH248RegModeVList = new int[] { 0, 1, 2, };
	private String[] utsDot3Onu2CtcH248RegModeTList = new String[] {
			fStringMap.getString("ip"), fStringMap.getString("domain"),
			fStringMap.getString("deviceName"), };
	private JComboBox tfUtsDot3Onu2CtcH248RegMode = new JComboBox(
			utsDot3Onu2CtcH248RegModeTList);
	private StringTextField tfUtsDot3Onu2CtcH248Mid = new StringTextField();

	private int[] utsDot3Onu2CtcH248HeartbeatModeVList = new int[] { 1, 0, };
	private String[] utsDot3Onu2CtcH248HeartbeatModeTList = new String[] {
			fStringMap.getString("ctcNotify"), fStringMap.getString("notUse"), };
	private JComboBox tfUtsDot3Onu2CtcH248HeartbeatMode = new JComboBox(
			utsDot3Onu2CtcH248HeartbeatModeTList);
	private IntegerTextField tfUtsDot3Onu2CtcH248HeartbeatCycle = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2CtcH248HeartbeatCount = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2CtcH248RtpTidCfgTidNum = new IntegerTextField();

	private StringTextField tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix = new StringTextField();

	private IntegerTextField tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin = new IntegerTextField();

	private int[] utsDot3Onu2CtcH248RtpTidCfgTidModeVList = new int[] { 1, 0, };
	private String[] utsDot3Onu2CtcH248RtpTidCfgTidModeTList = new String[] {
			fStringMap.getString("notAlign"), fStringMap.getString("align"), };
	private JComboBox tfUtsDot3Onu2CtcH248RtpTidCfgTidMode = new JComboBox(
			utsDot3Onu2CtcH248RtpTidCfgTidModeTList);
	
	private IntegerTextField tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength = new IntegerTextField();

	private JLabel tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName = new JLabel();

	private IntegerTextField tfUtsDot3Onu2CtcSipMgPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2CtcSipProxyServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2CtcSipProxyServComPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2CtcSipBackupProxyServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2CtcSipBackupProxyServComPort = new IntegerTextField();

//	private StringTextField tfUtsDot3Onu2CtcSipActiveProxyServ = new StringTextField();

	private IPAddressField tfUtsDot3Onu2CtcSipRegServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2CtcSipRegServComPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2CtcSipBackupRegServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2CtcSipBackupRegServComPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2CtcSipOutBoundServIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2CtcSipOutBoundServPort = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2CtcSipRegInterval = new IntegerTextField();

	private int[] utsDot3Onu2CtcSipHeartbeatSwitchVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2CtcSipHeartbeatSwitchTList = new String[] {
			fStringMap.getString("heartbeatOn"),
			fStringMap.getString("heartbeatOff"), };
	private JComboBox tfUtsDot3Onu2CtcSipHeartbeatSwitch = new JComboBox(
			utsDot3Onu2CtcSipHeartbeatSwitchTList);
	private IntegerTextField tfUtsDot3Onu2CtcSipHeartbeatCycle = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2CtcSipHeartbeatCount = new IntegerTextField();

	private int[] utsDot3Onu2CtcFaxmodemCfgT38ModeVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2CtcFaxmodemCfgT38ModeTList = new String[] {
			fStringMap.getString("t30"), fStringMap.getString("t38"), };
	private JComboBox tfUtsDot3Onu2CtcFaxmodemCfgT38Mode = new JComboBox(
			utsDot3Onu2CtcFaxmodemCfgT38ModeTList);
	private int[] utsDot3Onu2CtcFaxmodemCfgCtrlVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2CtcFaxmodemCfgCtrlTList = new String[] {
			fStringMap.getString("negiotation"),
			fStringMap.getString("autoVbd"), };
	private JComboBox tfUtsDot3Onu2CtcFaxmodemCfgCtrl = new JComboBox(
			utsDot3Onu2CtcFaxmodemCfgCtrlTList);
//	private int[] utsDot3Onu2CtcH248IadOperationStausVList = new int[] { 3, 0,
//			4, 2, 1, };
//	private String[] utsDot3Onu2CtcH248IadOperationStausTList = new String[] {
//			fStringMap.getString("de-register"),
//			fStringMap.getString("registering"),
//			fStringMap.getString("iadRebooting"),
//			fStringMap.getString("iadFault"),
//			fStringMap.getString("registered"), };
//	private JComboBox tfUtsDot3Onu2CtcH248IadOperationStaus = new JComboBox(
//			utsDot3Onu2CtcH248IadOperationStausTList);
//	private int[] utsDot3Onu2CtcIadOperationVList = new int[] { 2, 0, 1, };
//	private String[] utsDot3Onu2CtcIadOperationTList = new String[] {
//			fStringMap.getString("voiceModuleReset"),
//			fStringMap.getString("reregisterToSoftswitch"),
//			fStringMap.getString("deregisterFromSoftswitch"), };
//	private JComboBox tfUtsDot3Onu2CtcIadOperation = new JComboBox(
//			utsDot3Onu2CtcIadOperationTList);
	private StringTextField tfUtsDot3Onu2CtcSipDigitMap = new StringTextField();

	private final String utsDot3Onu2CtcCombinedFeaturesModuleId = fStringMap
			.getString("utsDot3Onu2CtcCombinedFeaturesModuleId")
			+ " : ";
	private final String utsDot3Onu2CtcCombinedFeaturesDeviceId = fStringMap
			.getString("utsDot3Onu2CtcCombinedFeaturesDeviceId")
			+ " : ";
	private final String utsDot3Onu2CtcCombinedFeaturesPortId = fStringMap
			.getString("utsDot3Onu2CtcCombinedFeaturesPortId")
			+ " : ";
	private final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = fStringMap
			.getString("utsDot3Onu2CtcCombinedFeaturesLogicalPortId")
			+ " : ";
//	private final String utsDot3Onu2CtcMduResetCardCardNumber = fStringMap
//			.getString("utsDot3Onu2CtcMduResetCardCardNumber")
//			+ " : ";
//	private final String utsDot3Onu2CtcMduResetCardReset = fStringMap
//			.getString("utsDot3Onu2CtcMduResetCardReset")
//			+ " : ";
//	private final String utsDot3Onu2CtcHoldoverAction = fStringMap
//			.getString("utsDot3Onu2CtcHoldoverAction")
//			+ " : ";
//	private final String utsDot3Onu2CtcHoldoverTime = fStringMap
//			.getString("utsDot3Onu2CtcHoldoverTime")
//			+ " : ";
//	private final String utsDot3Onu2CtcActivePonifAdminActivePon = fStringMap
//			.getString("utsDot3Onu2CtcActivePonifAdminActivePon")
//			+ " : ";
//	private final String utsDot3Onu2CtcTftpOamCommit = fStringMap
//			.getString("utsDot3Onu2CtcTftpOamCommit")
//			+ " : ";
//	private final String utsDot3Onu2CtcIadInfoMacAddr = fStringMap
//			.getString("utsDot3Onu2CtcIadInfoMacAddr")
//			+ " : ";
	private final String utsDot3Onu2CtcIadInfoSupportedProtocol = fStringMap
			.getString("utsDot3Onu2CtcIadInfoSupportedProtocol")
			+ " : ";
	private final String utsDot3Onu2CtcConfiguredVoipProtocol = fStringMap
			.getString("utsDot3Onu2CtcConfiguredVoipProtocol")
			+ " : ";
//	private final String utsDot3Onu2CtcIadInfoSoftwareVer = fStringMap
//			.getString("utsDot3Onu2CtcIadInfoSoftwareVer")
//			+ " : ";
//	private final String utsDot3Onu2CtcIadInfoSoftwareDate = fStringMap
//			.getString("utsDot3Onu2CtcIadInfoSoftwareDate")
//			+ " : ";
//	private final String utsDot3Onu2CtcIadInfoVoipUserCount = fStringMap
//			.getString("utsDot3Onu2CtcIadInfoVoipUserCount")
//			+ " : ";
	private final String utsDot3Onu2CtcIadIpMode = fStringMap
			.getString("utsDot3Onu2CtcIadIpMode")
			+ " : ";
	private final String utsDot3Onu2CtcIadIpAddr = fStringMap
			.getString("utsDot3Onu2CtcIadIpAddr")
			+ " : ";
	private final String utsDot3Onu2CtcIadNetMask = fStringMap
			.getString("utsDot3Onu2CtcIadNetMask")
			+ " : ";
	private final String utsDot3Onu2CtcIadDefaultGw = fStringMap
			.getString("utsDot3Onu2CtcIadDefaultGw")
			+ " : ";
//	private final String utsDot3Onu2CtcIadPppoeMode = fStringMap
//			.getString("utsDot3Onu2CtcIadPppoeMode")
//			+ " : ";
	private final String utsDot3Onu2CtcIadPppoeUsername = fStringMap
			.getString("utsDot3Onu2CtcIadPppoeUsername")
			+ " : ";
	private final String utsDot3Onu2CtcIadPppoePassword = fStringMap
			.getString("utsDot3Onu2CtcIadPppoePassword")
			+ " : ";
	private final String utsDot3Onu2CtcIadTagMode = fStringMap
			.getString("utsDot3Onu2CtcIadTagMode")
			+ " : ";
	private final String utsDot3Onu2CtcIadCvlan = fStringMap
			.getString("utsDot3Onu2CtcIadCvlan")
			+ " : ";
	private final String utsDot3Onu2CtcIadSvlan = fStringMap
			.getString("utsDot3Onu2CtcIadSvlan")
			+ " : ";
	private final String utsDot3Onu2CtcIadPriority = fStringMap
			.getString("utsDot3Onu2CtcIadPriority")
			+ " : ";
	private final String utsDot3Onu2CtcH248MgPort = fStringMap
			.getString("utsDot3Onu2CtcH248MgPort")
			+ " : ";
	private final String utsDot3Onu2CtcH248MgcIp = fStringMap
			.getString("utsDot3Onu2CtcH248MgcIp")
			+ " : ";
	private final String utsDot3Onu2CtcH248MgpComPort = fStringMap
			.getString("utsDot3Onu2CtcH248MgpComPort")
			+ " : ";
	private final String utsDot3Onu2CtcH248BackupMgcIp = fStringMap
			.getString("utsDot3Onu2CtcH248BackupMgcIp")
			+ " : ";
	private final String utsDot3Onu2CtcH248BackupMgcComPort = fStringMap
			.getString("utsDot3Onu2CtcH248BackupMgcComPort")
			+ " : ";
//	private final String utsDot3Onu2CtcH248ActiveMgc = fStringMap
//			.getString("utsDot3Onu2CtcH248ActiveMgc")
//			+ " : ";
	private final String utsDot3Onu2CtcH248RegMode = fStringMap
			.getString("utsDot3Onu2CtcH248RegMode")
			+ " : ";
	private final String utsDot3Onu2CtcH248Mid = fStringMap
			.getString("utsDot3Onu2CtcH248Mid")
			+ " : ";
	private final String utsDot3Onu2CtcH248HeartbeatMode = fStringMap
			.getString("utsDot3Onu2CtcH248HeartbeatMode")
			+ " : ";
	private final String utsDot3Onu2CtcH248HeartbeatCycle = fStringMap
			.getString("utsDot3Onu2CtcH248HeartbeatCycle")
			+ " : ";
	private final String utsDot3Onu2CtcH248HeartbeatCount = fStringMap
			.getString("utsDot3Onu2CtcH248HeartbeatCount")
			+ " : ";
	private final String utsDot3Onu2CtcH248RtpTidCfgTidNum = fStringMap
			.getString("utsDot3Onu2CtcH248RtpTidCfgTidNum")
			+ " : ";
	private final String utsDot3Onu2CtcH248RtpTidCfgTidPrefix = fStringMap
			.getString("utsDot3Onu2CtcH248RtpTidCfgTidPrefix")
			+ " : ";
	private final String utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin = fStringMap
			.getString("utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin")
			+ " : ";
	private final String utsDot3Onu2CtcH248RtpTidCfgTidMode = fStringMap
			.getString("utsDot3Onu2CtcH248RtpTidCfgTidMode")
			+ " : ";
	private final String utsDot3Onu2CtcH248RtpTidCfgTidDigitLength = fStringMap
			.getString("utsDot3Onu2CtcH248RtpTidCfgTidDigitLength")
			+ " : ";
	private final String utsDot3Onu2CtcH248RtpTidInfoFirstTidName = fStringMap
			.getString("utsDot3Onu2CtcH248RtpTidInfoFirstTidName")
			+ " : ";
	private final String utsDot3Onu2CtcSipMgPort = fStringMap
			.getString("utsDot3Onu2CtcSipMgPort")
			+ " : ";
	private final String utsDot3Onu2CtcSipProxyServIp = fStringMap
			.getString("utsDot3Onu2CtcSipProxyServIp")
			+ " : ";
	private final String utsDot3Onu2CtcSipProxyServComPort = fStringMap
			.getString("utsDot3Onu2CtcSipProxyServComPort")
			+ " : ";
	private final String utsDot3Onu2CtcSipBackupProxyServIp = fStringMap
			.getString("utsDot3Onu2CtcSipBackupProxyServIp")
			+ " : ";
	private final String utsDot3Onu2CtcSipBackupProxyServComPort = fStringMap
			.getString("utsDot3Onu2CtcSipBackupProxyServComPort")
			+ " : ";
//	private final String utsDot3Onu2CtcSipActiveProxyServ = fStringMap
//			.getString("utsDot3Onu2CtcSipActiveProxyServ")
//			+ " : ";
	private final String utsDot3Onu2CtcSipRegServIp = fStringMap
			.getString("utsDot3Onu2CtcSipRegServIp")
			+ " : ";
	private final String utsDot3Onu2CtcSipRegServComPort = fStringMap
			.getString("utsDot3Onu2CtcSipRegServComPort")
			+ " : ";
	private final String utsDot3Onu2CtcSipBackupRegServIp = fStringMap
			.getString("utsDot3Onu2CtcSipBackupRegServIp")
			+ " : ";
	private final String utsDot3Onu2CtcSipBackupRegServComPort = fStringMap
			.getString("utsDot3Onu2CtcSipBackupRegServComPort")
			+ " : ";
	private final String utsDot3Onu2CtcSipOutBoundServIp = fStringMap
			.getString("utsDot3Onu2CtcSipOutBoundServIp")
			+ " : ";
	private final String utsDot3Onu2CtcSipOutBoundServPort = fStringMap
			.getString("utsDot3Onu2CtcSipOutBoundServPort")
			+ " : ";
	private final String utsDot3Onu2CtcSipRegInterval = fStringMap
			.getString("utsDot3Onu2CtcSipRegInterval")
			+ " : ";
	private final String utsDot3Onu2CtcSipHeartbeatSwitch = fStringMap
			.getString("utsDot3Onu2CtcSipHeartbeatSwitch")
			+ " : ";
	private final String utsDot3Onu2CtcSipHeartbeatCycle = fStringMap
			.getString("utsDot3Onu2CtcSipHeartbeatCycle")
			+ " : ";
	private final String utsDot3Onu2CtcSipHeartbeatCount = fStringMap
			.getString("utsDot3Onu2CtcSipHeartbeatCount")
			+ " : ";
	private final String utsDot3Onu2CtcFaxmodemCfgT38Mode = fStringMap
			.getString("utsDot3Onu2CtcFaxmodemCfgT38Mode")
			+ " : ";
	private final String utsDot3Onu2CtcFaxmodemCfgCtrl = fStringMap
			.getString("utsDot3Onu2CtcFaxmodemCfgCtrl")
			+ " : ";
//	private final String utsDot3Onu2CtcH248IadOperationStaus = fStringMap
//			.getString("utsDot3Onu2CtcH248IadOperationStaus")
//			+ " : ";
//	private final String utsDot3Onu2CtcIadOperation = fStringMap
//			.getString("utsDot3Onu2CtcIadOperation")
//			+ " : ";
	private final String utsDot3Onu2CtcSipDigitMap = fStringMap
			.getString("utsDot3Onu2CtcSipDigitMap")
			+ " : ";

	public Dot3Onu2CtcCombinedFeaturesTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(18, 10, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesModuleId);
		baseInfoPanel.add(new VSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesDeviceId);
//		baseInfoPanel.add(new VSpacer());
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesPortId);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2CtcCombinedFeaturesLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduResetCardCardNumber));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcMduResetCardCardNumber);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduResetCardReset));
//		tfUtsDot3Onu2CtcMduResetCardReset.setName(fStringMap
//				.getString("utsDot3Onu2CtcMduResetCardReset"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcMduResetCardReset);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcHoldoverAction));
//		tfUtsDot3Onu2CtcHoldoverAction.setName(fStringMap
//				.getString("utsDot3Onu2CtcHoldoverAction"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcHoldoverAction);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcHoldoverTime));
//		tfUtsDot3Onu2CtcHoldoverTime.setName(fStringMap
//				.getString("utsDot3Onu2CtcHoldoverTime"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcHoldoverTime);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcActivePonifAdminActivePon));
//		tfUtsDot3Onu2CtcActivePonifAdminActivePon.setName(fStringMap
//				.getString("utsDot3Onu2CtcActivePonifAdminActivePon"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcActivePonifAdminActivePon);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcTftpOamCommit));
//		tfUtsDot3Onu2CtcTftpOamCommit.setName(fStringMap
//				.getString("utsDot3Onu2CtcTftpOamCommit"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcTftpOamCommit);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoMacAddr));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoMacAddr);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoSupportedProtocol));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoSupportedProtocol);
		baseInfoPanel.add(new VSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcConfiguredVoipProtocol));
		baseInfoPanel.add(tfUtsDot3Onu2CtcConfiguredVoipProtocol);
		baseInfoPanel.add(new VSpacer());
		tfUtsDot3Onu2CtcConfiguredVoipProtocol.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				changeConfigItemByProtocol();
			}
		});

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoSoftwareVer));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoSoftwareVer);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoSoftwareDate));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoSoftwareDate);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoVoipUserCount));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoVoipUserCount);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadIpMode));
		tfUtsDot3Onu2CtcIadIpMode.setName(fStringMap
				.getString("utsDot3Onu2CtcIadIpMode"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadIpMode);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadIpAddr));
		tfUtsDot3Onu2CtcIadIpAddr.setName(fStringMap
				.getString("utsDot3Onu2CtcIadIpAddr"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadIpAddr);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadNetMask));
		tfUtsDot3Onu2CtcIadNetMask.setName(fStringMap
				.getString("utsDot3Onu2CtcIadNetMask"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadNetMask);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadDefaultGw));
		tfUtsDot3Onu2CtcIadDefaultGw.setName(fStringMap
				.getString("utsDot3Onu2CtcIadDefaultGw"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadDefaultGw);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadPppoeMode));
//		tfUtsDot3Onu2CtcIadPppoeMode.setName(fStringMap
//				.getString("utsDot3Onu2CtcIadPppoeMode"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcIadPppoeMode);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadPppoeUsername));
		tfUtsDot3Onu2CtcIadPppoeUsername.setName(fStringMap
				.getString("utsDot3Onu2CtcIadPppoeUsername"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadPppoeUsername);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadPppoePassword));
		tfUtsDot3Onu2CtcIadPppoePassword.setName(fStringMap
				.getString("utsDot3Onu2CtcIadPppoePassword"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadPppoePassword);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadTagMode));
		tfUtsDot3Onu2CtcIadTagMode.setName(fStringMap
				.getString("utsDot3Onu2CtcIadTagMode"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadTagMode);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadCvlan));
		tfUtsDot3Onu2CtcIadCvlan.setName(fStringMap
				.getString("utsDot3Onu2CtcIadCvlan"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadCvlan);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadSvlan));
		tfUtsDot3Onu2CtcIadSvlan.setName(fStringMap
				.getString("utsDot3Onu2CtcIadSvlan"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadSvlan);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadPriority));
		tfUtsDot3Onu2CtcIadPriority.setName(fStringMap
				.getString("utsDot3Onu2CtcIadPriority"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcIadPriority);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248MgPort));
		tfUtsDot3Onu2CtcH248MgPort.setName(fStringMap
				.getString("utsDot3Onu2CtcH248MgPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248MgPort);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248MgcIp));
		tfUtsDot3Onu2CtcH248MgcIp.setName(fStringMap
				.getString("utsDot3Onu2CtcH248MgcIp"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248MgcIp);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248MgpComPort));
		tfUtsDot3Onu2CtcH248MgpComPort.setName(fStringMap
				.getString("utsDot3Onu2CtcH248MgpComPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248MgpComPort);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248BackupMgcIp));
		tfUtsDot3Onu2CtcH248BackupMgcIp.setName(fStringMap
				.getString("utsDot3Onu2CtcH248BackupMgcIp"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248BackupMgcIp);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248BackupMgcComPort));
		tfUtsDot3Onu2CtcH248BackupMgcComPort.setName(fStringMap
				.getString("utsDot3Onu2CtcH248BackupMgcComPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248BackupMgcComPort);
		baseInfoPanel.add(new VSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248ActiveMgc));
//		tfUtsDot3Onu2CtcH248ActiveMgc.setName(fStringMap
//				.getString("utsDot3Onu2CtcH248ActiveMgc"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcH248ActiveMgc);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RegMode));
		tfUtsDot3Onu2CtcH248RegMode.setName(fStringMap
				.getString("utsDot3Onu2CtcH248RegMode"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248RegMode);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());
		
		tfUtsDot3Onu2CtcH248RegMode.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tfUtsDot3Onu2CtcH248RegMode.getSelectedIndex() == 1 || 
						tfUtsDot3Onu2CtcH248RegMode.getSelectedIndex() == 2 ) {
					tfUtsDot3Onu2CtcH248Mid.setEnabled(true);
				}
				else {
					tfUtsDot3Onu2CtcH248Mid.setEnabled(false);
				}
			}
		});

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248Mid));
		tfUtsDot3Onu2CtcH248Mid.setName(fStringMap
				.getString("utsDot3Onu2CtcH248Mid"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248Mid);
		baseInfoPanel.add(new VSpacer());
		tfUtsDot3Onu2CtcH248Mid.setEnabled(false);

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248HeartbeatMode));
		tfUtsDot3Onu2CtcH248HeartbeatMode.setName(fStringMap
				.getString("utsDot3Onu2CtcH248HeartbeatMode"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248HeartbeatMode);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248HeartbeatCycle));
		tfUtsDot3Onu2CtcH248HeartbeatCycle.setName(fStringMap
				.getString("utsDot3Onu2CtcH248HeartbeatCycle"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248HeartbeatCycle);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248HeartbeatCount));
		tfUtsDot3Onu2CtcH248HeartbeatCount.setName(fStringMap
				.getString("utsDot3Onu2CtcH248HeartbeatCount"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248HeartbeatCount);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidNum));
		tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.setName(fStringMap
				.getString("utsDot3Onu2CtcH248RtpTidCfgTidNum"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidNum);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidPrefix));
		tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.setName(fStringMap
				.getString("utsDot3Onu2CtcH248RtpTidCfgTidPrefix"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin));
		tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.setName(fStringMap
				.getString("utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidMode));
		tfUtsDot3Onu2CtcH248RtpTidCfgTidMode.setName(fStringMap
				.getString("utsDot3Onu2CtcH248RtpTidCfgTidMode"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidMode);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength));
		tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength.setName(fStringMap
				.getString("utsDot3Onu2CtcH248RtpTidCfgTidDigitLength"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidInfoFirstTidName));
		baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipMgPort));
		tfUtsDot3Onu2CtcSipMgPort.setName(fStringMap
				.getString("utsDot3Onu2CtcSipMgPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipMgPort);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipProxyServIp));
		tfUtsDot3Onu2CtcSipProxyServIp.setName(fStringMap
				.getString("utsDot3Onu2CtcSipProxyServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipProxyServIp);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipProxyServComPort));
		tfUtsDot3Onu2CtcSipProxyServComPort.setName(fStringMap
				.getString("utsDot3Onu2CtcSipProxyServComPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipProxyServComPort);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipBackupProxyServIp));
		tfUtsDot3Onu2CtcSipBackupProxyServIp.setName(fStringMap
				.getString("utsDot3Onu2CtcSipBackupProxyServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipBackupProxyServIp);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipBackupProxyServComPort));
		tfUtsDot3Onu2CtcSipBackupProxyServComPort.setName(fStringMap
				.getString("utsDot3Onu2CtcSipBackupProxyServComPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipBackupProxyServComPort);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipActiveProxyServ));
//		tfUtsDot3Onu2CtcSipActiveProxyServ.setName(fStringMap
//				.getString("utsDot3Onu2CtcSipActiveProxyServ"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcSipActiveProxyServ);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipRegServIp));
		tfUtsDot3Onu2CtcSipRegServIp.setName(fStringMap
				.getString("utsDot3Onu2CtcSipRegServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipRegServIp);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipRegServComPort));
		tfUtsDot3Onu2CtcSipRegServComPort.setName(fStringMap
				.getString("utsDot3Onu2CtcSipRegServComPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipRegServComPort);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipBackupRegServIp));
		tfUtsDot3Onu2CtcSipBackupRegServIp.setName(fStringMap
				.getString("utsDot3Onu2CtcSipBackupRegServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipBackupRegServIp);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipBackupRegServComPort));
		tfUtsDot3Onu2CtcSipBackupRegServComPort.setName(fStringMap
				.getString("utsDot3Onu2CtcSipBackupRegServComPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipBackupRegServComPort);
		baseInfoPanel.add(new VSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipOutBoundServIp));
		tfUtsDot3Onu2CtcSipOutBoundServIp.setName(fStringMap
				.getString("utsDot3Onu2CtcSipOutBoundServIp"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipOutBoundServIp);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipOutBoundServPort));
		tfUtsDot3Onu2CtcSipOutBoundServPort.setName(fStringMap
				.getString("utsDot3Onu2CtcSipOutBoundServPort"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipOutBoundServPort);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipRegInterval));
		tfUtsDot3Onu2CtcSipRegInterval.setName(fStringMap
				.getString("utsDot3Onu2CtcSipRegInterval"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipRegInterval);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipHeartbeatSwitch));
		tfUtsDot3Onu2CtcSipHeartbeatSwitch.setName(fStringMap
				.getString("utsDot3Onu2CtcSipHeartbeatSwitch"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipHeartbeatSwitch);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipHeartbeatCycle));
		tfUtsDot3Onu2CtcSipHeartbeatCycle.setName(fStringMap
				.getString("utsDot3Onu2CtcSipHeartbeatCycle"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipHeartbeatCycle);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipHeartbeatCount));
		tfUtsDot3Onu2CtcSipHeartbeatCount.setName(fStringMap
				.getString("utsDot3Onu2CtcSipHeartbeatCount"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipHeartbeatCount);
		baseInfoPanel.add(new VSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipDigitMap));
		tfUtsDot3Onu2CtcSipDigitMap.setName(fStringMap
				.getString("utsDot3Onu2CtcSipDigitMap"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcSipDigitMap);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcFaxmodemCfgT38Mode));
		tfUtsDot3Onu2CtcFaxmodemCfgT38Mode.setName(fStringMap
				.getString("utsDot3Onu2CtcFaxmodemCfgT38Mode"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcFaxmodemCfgT38Mode);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcFaxmodemCfgCtrl));
		tfUtsDot3Onu2CtcFaxmodemCfgCtrl.setName(fStringMap
				.getString("utsDot3Onu2CtcFaxmodemCfgCtrl"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcFaxmodemCfgCtrl);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248IadOperationStaus));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcH248IadOperationStaus);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadOperation));
//		tfUtsDot3Onu2CtcIadOperation.setName(fStringMap
//				.getString("utsDot3Onu2CtcIadOperation"));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcIadOperation);
//		baseInfoPanel.add(new HSpacer());
//

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

	}
	
	protected void changeConfigItemByProtocol() {
		//VoIP
		tfUtsDot3Onu2CtcIadIpMode.setEnabled(true);
		tfUtsDot3Onu2CtcIadIpAddr.setEnabled(true);
		tfUtsDot3Onu2CtcIadDefaultGw.setEnabled(true);
		tfUtsDot3Onu2CtcIadPppoeUsername.setEnabled(true);
		tfUtsDot3Onu2CtcIadPppoePassword.setEnabled(true);
		tfUtsDot3Onu2CtcIadTagMode.setEnabled(true);
		tfUtsDot3Onu2CtcIadCvlan.setEnabled(true);
		tfUtsDot3Onu2CtcIadSvlan.setEnabled(true);
		tfUtsDot3Onu2CtcIadPriority.setEnabled(true);
		tfUtsDot3Onu2CtcIadNetMask.setEnabled(true);
		
		//H.248
		tfUtsDot3Onu2CtcH248MgPort.setEnabled(false);
		tfUtsDot3Onu2CtcH248MgcIp.setEnabled(false);
		tfUtsDot3Onu2CtcH248MgcIp.setEditable(false);
		tfUtsDot3Onu2CtcH248MgpComPort.setEnabled(false);
		tfUtsDot3Onu2CtcH248BackupMgcIp.setEnabled(false);
		tfUtsDot3Onu2CtcH248BackupMgcIp.setEditable(false);
		tfUtsDot3Onu2CtcH248BackupMgcComPort.setEnabled(false);
		tfUtsDot3Onu2CtcH248RegMode.setEnabled(false);
		tfUtsDot3Onu2CtcH248Mid.setEnabled(false);
		tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.setEnabled(false);
		tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.setEnabled(false);
		tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.setEnabled(false);
		tfUtsDot3Onu2CtcH248RtpTidCfgTidMode.setEnabled(false);
		tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength.setEnabled(false);
		tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName.setEnabled(false);
		tfUtsDot3Onu2CtcH248HeartbeatMode.setEnabled(false);
		tfUtsDot3Onu2CtcH248HeartbeatCycle.setEnabled(false);
		tfUtsDot3Onu2CtcH248HeartbeatCount.setEnabled(false);
		
		//SIP
		tfUtsDot3Onu2CtcSipMgPort.setEnabled(false);
		tfUtsDot3Onu2CtcSipProxyServIp.setEnabled(false);
		tfUtsDot3Onu2CtcSipProxyServIp.setEditable(false);
		tfUtsDot3Onu2CtcSipProxyServComPort.setEnabled(false);
		tfUtsDot3Onu2CtcSipBackupProxyServIp.setEnabled(false);
		tfUtsDot3Onu2CtcSipBackupProxyServIp.setEditable(false);
		tfUtsDot3Onu2CtcSipBackupProxyServComPort.setEnabled(false);
		tfUtsDot3Onu2CtcSipRegServIp.setEnabled(false);
		tfUtsDot3Onu2CtcSipRegServIp.setEditable(false);
		tfUtsDot3Onu2CtcSipRegServComPort.setEnabled(false);
		tfUtsDot3Onu2CtcSipBackupRegServIp.setEnabled(false);
		tfUtsDot3Onu2CtcSipBackupRegServIp.setEditable(false);
		tfUtsDot3Onu2CtcSipBackupRegServComPort.setEnabled(false);
		tfUtsDot3Onu2CtcSipOutBoundServIp.setEnabled(false);
		tfUtsDot3Onu2CtcSipOutBoundServPort.setEnabled(false);
		tfUtsDot3Onu2CtcSipRegInterval.setEnabled(false);
		tfUtsDot3Onu2CtcSipHeartbeatSwitch.setEnabled(false);
		tfUtsDot3Onu2CtcSipHeartbeatCycle.setEnabled(false);
		tfUtsDot3Onu2CtcSipHeartbeatCount.setEnabled(false);
		tfUtsDot3Onu2CtcSipDigitMap.setEnabled(false);
		
		//Fax
		tfUtsDot3Onu2CtcFaxmodemCfgT38Mode.setEnabled(true);
		tfUtsDot3Onu2CtcFaxmodemCfgCtrl.setEnabled(true);
		
		if(tfUtsDot3Onu2CtcConfiguredVoipProtocol.getSelectedIndex() == 1) {		
			//protocol is SIP, follow SIP parameter is enable;
			tfUtsDot3Onu2CtcSipMgPort.setEnabled(true);
			tfUtsDot3Onu2CtcSipProxyServIp.setEnabled(true);
			tfUtsDot3Onu2CtcSipProxyServIp.setEditable(true);
			tfUtsDot3Onu2CtcSipProxyServComPort.setEnabled(true);
			tfUtsDot3Onu2CtcSipBackupProxyServIp.setEnabled(true);
			tfUtsDot3Onu2CtcSipBackupProxyServIp.setEditable(true);
			tfUtsDot3Onu2CtcSipBackupProxyServComPort.setEnabled(true);
			tfUtsDot3Onu2CtcSipRegServIp.setEnabled(true);
			tfUtsDot3Onu2CtcSipRegServIp.setEditable(true);
			tfUtsDot3Onu2CtcSipRegServComPort.setEnabled(true);
			tfUtsDot3Onu2CtcSipBackupRegServIp.setEnabled(true);
			tfUtsDot3Onu2CtcSipBackupRegServIp.setEditable(true);
			tfUtsDot3Onu2CtcSipBackupRegServComPort.setEnabled(true);
			tfUtsDot3Onu2CtcSipOutBoundServIp.setEnabled(true);
			tfUtsDot3Onu2CtcSipOutBoundServPort.setEnabled(true);
			tfUtsDot3Onu2CtcSipRegInterval.setEnabled(true);
			tfUtsDot3Onu2CtcSipHeartbeatSwitch.setEnabled(true);
			tfUtsDot3Onu2CtcSipHeartbeatCycle.setEnabled(true);
			tfUtsDot3Onu2CtcSipHeartbeatCount.setEnabled(true);
			tfUtsDot3Onu2CtcSipDigitMap.setEnabled(true);
		}
		else if(tfUtsDot3Onu2CtcConfiguredVoipProtocol.getSelectedIndex() == 2) {
			//protocol is H.248, follow H.248 parameter is enable;
			tfUtsDot3Onu2CtcH248MgPort.setEnabled(true);
			tfUtsDot3Onu2CtcH248MgcIp.setEnabled(true);
			tfUtsDot3Onu2CtcH248MgcIp.setEditable(true);
			tfUtsDot3Onu2CtcH248MgpComPort.setEnabled(true);
			tfUtsDot3Onu2CtcH248BackupMgcIp.setEnabled(true);
			tfUtsDot3Onu2CtcH248BackupMgcIp.setEditable(true);
			tfUtsDot3Onu2CtcH248BackupMgcComPort.setEnabled(true);
			tfUtsDot3Onu2CtcH248RegMode.setEnabled(true);
			tfUtsDot3Onu2CtcH248Mid.setEnabled(true);
			tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.setEnabled(true);
			tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.setEnabled(true);
			tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.setEnabled(true);
			tfUtsDot3Onu2CtcH248RtpTidCfgTidMode.setEnabled(true);
			tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength.setEnabled(true);
			tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName.setEnabled(true);
			tfUtsDot3Onu2CtcH248HeartbeatMode.setEnabled(true);
			tfUtsDot3Onu2CtcH248HeartbeatCycle.setEnabled(true);
			tfUtsDot3Onu2CtcH248HeartbeatCount.setEnabled(true);
		}

	}

	protected void initForm() {

//		tfUtsDot3Onu2CtcHoldoverTime.setValueScope(50, 1000);

//		tfUtsDot3Onu2CtcIadInfoMacAddr.setEnabled(false);
		
		tfUtsDot3Onu2CtcIadPppoeUsername.setMaxLen(32);
		
		tfUtsDot3Onu2CtcIadPppoePassword.setMaxLen(32);
		
		tfUtsDot3Onu2CtcH248Mid.setMaxLen(64);
		
		tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.setMaxLen(16);
		
//		tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.setMaxLen(8);
		
		tfUtsDot3Onu2CtcH248HeartbeatCycle.setValueScope(10, 1800);
		
		tfUtsDot3Onu2CtcH248HeartbeatCount.setValueScope(1, 10);
		
		tfUtsDot3Onu2CtcIadCvlan.setValueScope(1, 4094);

		tfUtsDot3Onu2CtcIadSvlan.setValueScope(1, 4094);

		tfUtsDot3Onu2CtcIadPriority.setValueScope(0, 7);

//		tfUtsDot3Onu2CtcH248HeartbeatCycle.setValueScope(10, 1800);

//		tfUtsDot3Onu2CtcH248HeartbeatCount.setValueScope(1, 10);

		tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.setValueScope(1, 255);

//		tfUtsDot3Onu2CtcSipRegInterval.setValueScope(1, 65535);

//		tfUtsDot3Onu2CtcSipHeartbeatCycle.setValueScope(10, 1800);

//		tfUtsDot3Onu2CtcSipHeartbeatCount.setValueScope(1, 10);
		
		tfUtsDot3Onu2CtcSipRegInterval.setValueScope(1, 65535);
		
		tfUtsDot3Onu2CtcSipHeartbeatCycle.setValueScope(10, 1800);
		
		tfUtsDot3Onu2CtcSipHeartbeatCount.setValueScope(1, 10);
		
		tfUtsDot3Onu2CtcSipDigitMap.setLenScope(0, 1024);

	}

	public void refresh() {

		Dot3Onu2CtcCombinedFeaturesTable mbean = (Dot3Onu2CtcCombinedFeaturesTable) getModel();

		tfUtsDot3Onu2CtcCombinedFeaturesModuleId.setText(mbean
				.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
		tfUtsDot3Onu2CtcCombinedFeaturesDeviceId.setText(mbean
				.getUtsDot3Onu2CtcCombinedFeaturesDeviceId().toString());
		tfUtsDot3Onu2CtcCombinedFeaturesPortId.setText(mbean
				.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
		tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId.setText(mbean
				.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());
//		tfUtsDot3Onu2CtcMduResetCardCardNumber.setText(mbean
//				.getUtsDot3Onu2CtcMduResetCardCardNumber().toString());
//		tfUtsDot3Onu2CtcMduResetCardReset.setValue(mbean
//				.getUtsDot3Onu2CtcMduResetCardReset().intValue());
//		tfUtsDot3Onu2CtcHoldoverAction.setSelectedIndex(getIndexFromValue(
//				utsDot3Onu2CtcHoldoverActionVList, mbean
//						.getUtsDot3Onu2CtcHoldoverAction().intValue()));
//		tfUtsDot3Onu2CtcHoldoverTime.setValue(mbean
//				.getUtsDot3Onu2CtcHoldoverTime().intValue());
//		tfUtsDot3Onu2CtcActivePonifAdminActivePon.setValue(mbean
//				.getUtsDot3Onu2CtcActivePonifAdminActivePon().intValue());
//		tfUtsDot3Onu2CtcTftpOamCommit.setValue(mbean
//				.getUtsDot3Onu2CtcTftpOamCommit().intValue());
//		tfUtsDot3Onu2CtcIadInfoMacAddr.setValue(mbean
//				.getUtsDot3Onu2CtcIadInfoMacAddr());
		tfUtsDot3Onu2CtcIadInfoSupportedProtocol.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcIadInfoSupportedProtocolVList, mbean
						.getUtsDot3Onu2CtcIadInfoSupportedProtocol().intValue()));
		tfUtsDot3Onu2CtcIadInfoSupportedProtocol.setEnabled(false);
		tfUtsDot3Onu2CtcConfiguredVoipProtocol.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcConfiguredVoipProtocolVList, mbean
						.getUtsDot3Onu2CtcConfiguredVoipProtocol().intValue()));
//		tfUtsDot3Onu2CtcIadInfoSoftwareVer.setText(mbean
//				.getUtsDot3Onu2CtcIadInfoSoftwareVer());
//		tfUtsDot3Onu2CtcIadInfoSoftwareDate.setText(mbean
//				.getUtsDot3Onu2CtcIadInfoSoftwareDate());
//		tfUtsDot3Onu2CtcIadInfoVoipUserCount.setText(mbean
//				.getUtsDot3Onu2CtcIadInfoVoipUserCount().toString());
		tfUtsDot3Onu2CtcIadIpMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcIadIpModeVList, mbean
						.getUtsDot3Onu2CtcIadIpMode().intValue()));
		tfUtsDot3Onu2CtcIadIpAddr.setValue(mbean.getUtsDot3Onu2CtcIadIpAddr());
		tfUtsDot3Onu2CtcIadNetMask
				.setValue(mbean.getUtsDot3Onu2CtcIadNetMask());
		tfUtsDot3Onu2CtcIadDefaultGw.setValue(mbean
				.getUtsDot3Onu2CtcIadDefaultGw());
//		tfUtsDot3Onu2CtcIadPppoeMode.setSelectedIndex(getIndexFromValue(
//				utsDot3Onu2CtcIadPppoeModeVList, mbean
//						.getUtsDot3Onu2CtcIadPppoeMode().intValue()));
		tfUtsDot3Onu2CtcIadPppoeUsername.setValue(mbean
				.getUtsDot3Onu2CtcIadPppoeUsername());
		tfUtsDot3Onu2CtcIadPppoePassword.setValue(mbean
				.getUtsDot3Onu2CtcIadPppoePassword());
		tfUtsDot3Onu2CtcIadTagMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcIadTagModeVList, mbean
						.getUtsDot3Onu2CtcIadTagMode().intValue()));
		tfUtsDot3Onu2CtcIadCvlan.setValue(mbean.getUtsDot3Onu2CtcIadCvlan()
				.intValue());
		tfUtsDot3Onu2CtcIadSvlan.setValue(mbean.getUtsDot3Onu2CtcIadSvlan()
				.intValue());
		tfUtsDot3Onu2CtcIadPriority.setValue(mbean
				.getUtsDot3Onu2CtcIadPriority().intValue());
		tfUtsDot3Onu2CtcH248MgPort.setValue(mbean.getUtsDot3Onu2CtcH248MgPort()
				.intValue());
		tfUtsDot3Onu2CtcH248MgcIp.setValue(mbean.getUtsDot3Onu2CtcH248MgcIp());
		tfUtsDot3Onu2CtcH248MgpComPort.setValue(mbean
				.getUtsDot3Onu2CtcH248MgpComPort().intValue());
		tfUtsDot3Onu2CtcH248BackupMgcIp.setValue(mbean
				.getUtsDot3Onu2CtcH248BackupMgcIp());
		tfUtsDot3Onu2CtcH248BackupMgcComPort.setValue(mbean
				.getUtsDot3Onu2CtcH248BackupMgcComPort().intValue());
//		tfUtsDot3Onu2CtcH248ActiveMgc.setSelectedIndex(getIndexFromValue(
//				utsDot3Onu2CtcH248ActiveMgcVList, mbean
//						.getUtsDot3Onu2CtcH248ActiveMgc().intValue()));
		tfUtsDot3Onu2CtcH248RegMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcH248RegModeVList, mbean
						.getUtsDot3Onu2CtcH248RegMode().intValue()));
		tfUtsDot3Onu2CtcH248Mid.setValue(mbean.getUtsDot3Onu2CtcH248Mid());
		tfUtsDot3Onu2CtcH248HeartbeatMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcH248HeartbeatModeVList, mbean
						.getUtsDot3Onu2CtcH248HeartbeatMode().intValue()));
		tfUtsDot3Onu2CtcH248HeartbeatCycle.setValue(mbean
				.getUtsDot3Onu2CtcH248HeartbeatCycle().intValue());
		tfUtsDot3Onu2CtcH248HeartbeatCount.setValue(mbean
				.getUtsDot3Onu2CtcH248HeartbeatCount().intValue());
		tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.setValue(mbean
				.getUtsDot3Onu2CtcH248RtpTidCfgTidNum().intValue());
		tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.setValue(mbean
				.getUtsDot3Onu2CtcH248RtpTidCfgTidPrefix());
		tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.setValue(mbean
				.getUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin());
		tfUtsDot3Onu2CtcH248RtpTidCfgTidMode
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2CtcH248RtpTidCfgTidModeVList, mbean
								.getUtsDot3Onu2CtcH248RtpTidCfgTidMode()
								.intValue()));
		tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength.setValue(mbean
				.getUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength().intValue());
		tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName.setText(mbean
				.getUtsDot3Onu2CtcH248RtpTidInfoFirstTidName());
		tfUtsDot3Onu2CtcSipMgPort.setValue(mbean.getUtsDot3Onu2CtcSipMgPort()
				.intValue());
		tfUtsDot3Onu2CtcSipProxyServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipProxyServIp());
		tfUtsDot3Onu2CtcSipProxyServComPort.setValue(mbean
				.getUtsDot3Onu2CtcSipProxyServComPort().intValue());
		tfUtsDot3Onu2CtcSipBackupProxyServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipBackupProxyServIp());
		tfUtsDot3Onu2CtcSipBackupProxyServComPort.setValue(mbean
				.getUtsDot3Onu2CtcSipBackupProxyServComPort().intValue());
//		tfUtsDot3Onu2CtcSipActiveProxyServ.setValue(mbean
//				.getUtsDot3Onu2CtcSipActiveProxyServ());
		tfUtsDot3Onu2CtcSipRegServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipRegServIp());
		tfUtsDot3Onu2CtcSipRegServComPort.setValue(mbean
				.getUtsDot3Onu2CtcSipRegServComPort().intValue());
		tfUtsDot3Onu2CtcSipBackupRegServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipBackupRegServIp());
		tfUtsDot3Onu2CtcSipBackupRegServComPort.setValue(mbean
				.getUtsDot3Onu2CtcSipBackupRegServComPort().intValue());
		tfUtsDot3Onu2CtcSipOutBoundServIp.setValue(mbean
				.getUtsDot3Onu2CtcSipOutBoundServIp());
		tfUtsDot3Onu2CtcSipOutBoundServPort.setValue(mbean
				.getUtsDot3Onu2CtcSipOutBoundServPort().intValue());
		tfUtsDot3Onu2CtcSipRegInterval.setValue(mbean
				.getUtsDot3Onu2CtcSipRegInterval().intValue());
		tfUtsDot3Onu2CtcSipHeartbeatSwitch.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcSipHeartbeatSwitchVList, mbean
						.getUtsDot3Onu2CtcSipHeartbeatSwitch().intValue()));
		tfUtsDot3Onu2CtcSipHeartbeatCycle.setValue(mbean
				.getUtsDot3Onu2CtcSipHeartbeatCycle().intValue());
		tfUtsDot3Onu2CtcSipHeartbeatCount.setValue(mbean
				.getUtsDot3Onu2CtcSipHeartbeatCount().intValue());
		tfUtsDot3Onu2CtcFaxmodemCfgT38Mode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcFaxmodemCfgT38ModeVList, mbean
						.getUtsDot3Onu2CtcFaxmodemCfgT38Mode().intValue()));
		tfUtsDot3Onu2CtcFaxmodemCfgCtrl.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcFaxmodemCfgCtrlVList, mbean
						.getUtsDot3Onu2CtcFaxmodemCfgCtrl().intValue()));
//		tfUtsDot3Onu2CtcH248IadOperationStaus
//				.setSelectedIndex(getIndexFromValue(
//						utsDot3Onu2CtcH248IadOperationStausVList, mbean
//								.getUtsDot3Onu2CtcH248IadOperationStaus()
//								.intValue()));
//		tfUtsDot3Onu2CtcIadOperation.setSelectedIndex(getIndexFromValue(
//				utsDot3Onu2CtcIadOperationVList, mbean
//						.getUtsDot3Onu2CtcIadOperation().intValue()));
		tfUtsDot3Onu2CtcSipDigitMap.setValue(mbean
				.getUtsDot3Onu2CtcSipDigitMap());
		
		changeConfigItemByProtocol();
	}

	public void updateModel() {

		Dot3Onu2CtcCombinedFeaturesTable mbean = (Dot3Onu2CtcCombinedFeaturesTable) getModel();

//		mbean.setUtsDot3Onu2CtcMduResetCardReset(new Integer(
//				tfUtsDot3Onu2CtcMduResetCardReset.getValue()));
//		mbean
//				.setUtsDot3Onu2CtcHoldoverAction(new Integer(
//						utsDot3Onu2CtcHoldoverActionVList[tfUtsDot3Onu2CtcHoldoverAction
//								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2CtcHoldoverTime(new Integer(
//				tfUtsDot3Onu2CtcHoldoverTime.getValue()));
//		mbean.setUtsDot3Onu2CtcActivePonifAdminActivePon(new Integer(
//				tfUtsDot3Onu2CtcActivePonifAdminActivePon.getValue()));
//		mbean.setUtsDot3Onu2CtcTftpOamCommit(new Integer(
//				tfUtsDot3Onu2CtcTftpOamCommit.getValue()));

		//VoIP
		mbean.setUtsDot3Onu2CtcIadIpMode(new Integer(
				utsDot3Onu2CtcIadIpModeVList[tfUtsDot3Onu2CtcIadIpMode
						.getSelectedIndex()]));
		mbean.setUtsDot3Onu2CtcIadIpAddr(tfUtsDot3Onu2CtcIadIpAddr.getIPString());
		mbean.setUtsDot3Onu2CtcIadNetMask(tfUtsDot3Onu2CtcIadNetMask
				.getIPString());
		mbean.setUtsDot3Onu2CtcIadDefaultGw(tfUtsDot3Onu2CtcIadDefaultGw.getIPString());
//		mbean.setUtsDot3Onu2CtcIadPppoeMode(new Integer(
//				utsDot3Onu2CtcIadPppoeModeVList[tfUtsDot3Onu2CtcIadPppoeMode
//						.getSelectedIndex()]));
		mbean.setUtsDot3Onu2CtcIadPppoeUsername(new String(
				tfUtsDot3Onu2CtcIadPppoeUsername.getValue()));
		mbean.setUtsDot3Onu2CtcIadPppoePassword(new String(
				tfUtsDot3Onu2CtcIadPppoePassword.getValue()));
		mbean.setUtsDot3Onu2CtcIadTagMode(new Integer(
				utsDot3Onu2CtcIadTagModeVList[tfUtsDot3Onu2CtcIadTagMode
						.getSelectedIndex()]));
		mbean.setUtsDot3Onu2CtcIadCvlan(new Integer(tfUtsDot3Onu2CtcIadCvlan
				.getValue()));
		mbean.setUtsDot3Onu2CtcIadSvlan(new Integer(tfUtsDot3Onu2CtcIadSvlan
				.getValue()));
		mbean.setUtsDot3Onu2CtcIadPriority(new Integer(
				tfUtsDot3Onu2CtcIadPriority.getValue()));
		
		
		//H.248
		if(tfUtsDot3Onu2CtcConfiguredVoipProtocol.getSelectedIndex() == 2) {
			mbean.setUtsDot3Onu2CtcH248MgPort(new Integer(
					tfUtsDot3Onu2CtcH248MgPort.getValue()));
			mbean.setUtsDot3Onu2CtcH248MgcIp(tfUtsDot3Onu2CtcH248MgcIp.getIPString());
			mbean.setUtsDot3Onu2CtcH248MgpComPort(new Integer(
					tfUtsDot3Onu2CtcH248MgpComPort.getValue()));
			mbean.setUtsDot3Onu2CtcH248BackupMgcIp(tfUtsDot3Onu2CtcH248BackupMgcIp.getIPString());
			mbean.setUtsDot3Onu2CtcH248BackupMgcComPort(new Integer(
					tfUtsDot3Onu2CtcH248BackupMgcComPort.getValue()));
//			mbean
//					.setUtsDot3Onu2CtcH248ActiveMgc(new Integer(
//							utsDot3Onu2CtcH248ActiveMgcVList[tfUtsDot3Onu2CtcH248ActiveMgc
//									.getSelectedIndex()]));
			mbean.setUtsDot3Onu2CtcH248RegMode(new Integer(
					utsDot3Onu2CtcH248RegModeVList[tfUtsDot3Onu2CtcH248RegMode
							.getSelectedIndex()]));
			mbean.setUtsDot3Onu2CtcH248Mid(new String(tfUtsDot3Onu2CtcH248Mid
					.getValue()));
			mbean
					.setUtsDot3Onu2CtcH248HeartbeatMode(new Integer(
							utsDot3Onu2CtcH248HeartbeatModeVList[tfUtsDot3Onu2CtcH248HeartbeatMode
									.getSelectedIndex()]));
			mbean.setUtsDot3Onu2CtcH248HeartbeatCycle(new Integer(
					tfUtsDot3Onu2CtcH248HeartbeatCycle.getValue()));
			mbean.setUtsDot3Onu2CtcH248HeartbeatCount(new Integer(
					tfUtsDot3Onu2CtcH248HeartbeatCount.getValue()));
			mbean.setUtsDot3Onu2CtcH248RtpTidCfgTidNum(new Integer(
					tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.getValue()));
			mbean.setUtsDot3Onu2CtcH248RtpTidCfgTidPrefix(new String(
					tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.getValue()));
			mbean
					.setUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin(tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin
							.getValue());
			mbean
					.setUtsDot3Onu2CtcH248RtpTidCfgTidMode(new Integer(
							utsDot3Onu2CtcH248RtpTidCfgTidModeVList[tfUtsDot3Onu2CtcH248RtpTidCfgTidMode
									.getSelectedIndex()]));
			mbean.setUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength(new Integer(
					tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength.getValue()));
		}
		
		//SIP
		if(tfUtsDot3Onu2CtcConfiguredVoipProtocol.getSelectedIndex() == 1) {
			mbean.setUtsDot3Onu2CtcSipMgPort(new Integer(
					tfUtsDot3Onu2CtcSipMgPort.getValue()));
			mbean.setUtsDot3Onu2CtcSipProxyServIp(tfUtsDot3Onu2CtcSipProxyServIp.getIPString());
			mbean.setUtsDot3Onu2CtcSipProxyServComPort(new Integer(
					tfUtsDot3Onu2CtcSipProxyServComPort.getValue()));
			mbean.setUtsDot3Onu2CtcSipBackupProxyServIp(
					tfUtsDot3Onu2CtcSipBackupProxyServIp.getIPString());
			mbean.setUtsDot3Onu2CtcSipBackupProxyServComPort(new Integer(
					tfUtsDot3Onu2CtcSipBackupProxyServComPort.getValue()));
//			mbean.setUtsDot3Onu2CtcSipActiveProxyServ(new String(
//					tfUtsDot3Onu2CtcSipActiveProxyServ.getValue()));
			mbean.setUtsDot3Onu2CtcSipRegServIp(
					tfUtsDot3Onu2CtcSipRegServIp.getIPString());
			mbean.setUtsDot3Onu2CtcSipRegServComPort(new Integer(
					tfUtsDot3Onu2CtcSipRegServComPort.getValue()));
			mbean.setUtsDot3Onu2CtcSipBackupRegServIp(
					tfUtsDot3Onu2CtcSipBackupRegServIp.getIPString());
			mbean.setUtsDot3Onu2CtcSipBackupRegServComPort(new Integer(
					tfUtsDot3Onu2CtcSipBackupRegServComPort.getValue()));
			mbean.setUtsDot3Onu2CtcSipOutBoundServIp(new String(
					tfUtsDot3Onu2CtcSipOutBoundServIp.getIPString()));
			mbean.setUtsDot3Onu2CtcSipOutBoundServPort(new Integer(
					tfUtsDot3Onu2CtcSipOutBoundServPort.getValue()));
			mbean.setUtsDot3Onu2CtcSipRegInterval(new Integer(
					tfUtsDot3Onu2CtcSipRegInterval.getValue()));
			mbean
					.setUtsDot3Onu2CtcSipHeartbeatSwitch(new Integer(
							utsDot3Onu2CtcSipHeartbeatSwitchVList[tfUtsDot3Onu2CtcSipHeartbeatSwitch
									.getSelectedIndex()]));
			mbean.setUtsDot3Onu2CtcSipHeartbeatCycle(new Integer(
					tfUtsDot3Onu2CtcSipHeartbeatCycle.getValue()));
			mbean.setUtsDot3Onu2CtcSipHeartbeatCount(new Integer(
					tfUtsDot3Onu2CtcSipHeartbeatCount.getValue()));
			
			mbean.setUtsDot3Onu2CtcSipDigitMap(new String(
					tfUtsDot3Onu2CtcSipDigitMap.getValue()));
			
		}
		mbean
				.setUtsDot3Onu2CtcFaxmodemCfgT38Mode(new Integer(
						utsDot3Onu2CtcFaxmodemCfgT38ModeVList[tfUtsDot3Onu2CtcFaxmodemCfgT38Mode
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2CtcFaxmodemCfgCtrl(new Integer(
						utsDot3Onu2CtcFaxmodemCfgCtrlVList[tfUtsDot3Onu2CtcFaxmodemCfgCtrl
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2CtcConfiguredVoipProtocol(new Integer(
						utsDot3Onu2CtcConfiguredVoipProtocolVList[tfUtsDot3Onu2CtcConfiguredVoipProtocol
								.getSelectedIndex()]));
//		mbean.setUtsDot3Onu2CtcIadOperation(new Integer(
//				utsDot3Onu2CtcIadOperationVList[tfUtsDot3Onu2CtcIadOperation
//						.getSelectedIndex()]));


	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

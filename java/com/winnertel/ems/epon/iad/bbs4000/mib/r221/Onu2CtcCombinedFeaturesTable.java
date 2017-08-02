/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Onu2CtcCombinedFeaturesTable extends SnmpMibBean {

    public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
    public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
    public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
    public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";
    public static final String utsDot3Onu2CtcMduResetCardCardNumber = "utsDot3Onu2CtcMduResetCardCardNumber";
    public static final String utsDot3Onu2CtcMduResetCardReset = "utsDot3Onu2CtcMduResetCardReset";
    public static final String utsDot3Onu2CtcHoldoverAction = "utsDot3Onu2CtcHoldoverAction";
    public static final String utsDot3Onu2CtcHoldoverTime = "utsDot3Onu2CtcHoldoverTime";
    public static final String utsDot3Onu2CtcActivePonifAdminActivePon = "utsDot3Onu2CtcActivePonifAdminActivePon";
    public static final String utsDot3Onu2CtcTftpOamCommit = "utsDot3Onu2CtcTftpOamCommit";
    public static final String utsDot3Onu2CtcIadInfoMacAddr = "utsDot3Onu2CtcIadInfoMacAddr";
    public static final String utsDot3Onu2CtcIadInfoSupportedProtocol = "utsDot3Onu2CtcIadInfoSupportedProtocol";
    public static final String utsDot3Onu2CtcIadInfoSoftwareVer = "utsDot3Onu2CtcIadInfoSoftwareVer";
    public static final String utsDot3Onu2CtcIadInfoSoftwareDate = "utsDot3Onu2CtcIadInfoSoftwareDate";
    public static final String utsDot3Onu2CtcIadInfoVoipUserCount = "utsDot3Onu2CtcIadInfoVoipUserCount";
    public static final String utsDot3Onu2CtcIadIpMode = "utsDot3Onu2CtcIadIpMode";
    public static final String utsDot3Onu2CtcIadIpAddr = "utsDot3Onu2CtcIadIpAddr";
    public static final String utsDot3Onu2CtcIadNetMask = "utsDot3Onu2CtcIadNetMask";
    public static final String utsDot3Onu2CtcIadDefaultGw = "utsDot3Onu2CtcIadDefaultGw";
    public static final String utsDot3Onu2CtcIadPppoeMode = "utsDot3Onu2CtcIadPppoeMode";
    public static final String utsDot3Onu2CtcIadPppoeUsername = "utsDot3Onu2CtcIadPppoeUsername";
    public static final String utsDot3Onu2CtcIadPppoePassword = "utsDot3Onu2CtcIadPppoePassword";
    public static final String utsDot3Onu2CtcIadTagMode = "utsDot3Onu2CtcIadTagMode";
    public static final String utsDot3Onu2CtcIadCvlan = "utsDot3Onu2CtcIadCvlan";
    public static final String utsDot3Onu2CtcIadSvlan = "utsDot3Onu2CtcIadSvlan";
    public static final String utsDot3Onu2CtcIadPriority = "utsDot3Onu2CtcIadPriority";
    public static final String utsDot3Onu2CtcH248MgPort = "utsDot3Onu2CtcH248MgPort";
    public static final String utsDot3Onu2CtcH248MgcIp = "utsDot3Onu2CtcH248MgcIp";
    public static final String utsDot3Onu2CtcH248MgpComPort = "utsDot3Onu2CtcH248MgpComPort";
    public static final String utsDot3Onu2CtcH248BackupMgcIp = "utsDot3Onu2CtcH248BackupMgcIp";
    public static final String utsDot3Onu2CtcH248BackupMgcComPort = "utsDot3Onu2CtcH248BackupMgcComPort";
    public static final String utsDot3Onu2CtcH248ActiveMgc = "utsDot3Onu2CtcH248ActiveMgc";
    public static final String utsDot3Onu2CtcH248RegMode = "utsDot3Onu2CtcH248RegMode";
    public static final String utsDot3Onu2CtcH248Mid = "utsDot3Onu2CtcH248Mid";
    public static final String utsDot3Onu2CtcH248HeartbeatMode = "utsDot3Onu2CtcH248HeartbeatMode";
    public static final String utsDot3Onu2CtcH248HeartbeatCycle = "utsDot3Onu2CtcH248HeartbeatCycle";
    public static final String utsDot3Onu2CtcH248HeartbeatCount = "utsDot3Onu2CtcH248HeartbeatCount";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidNum = "utsDot3Onu2CtcH248RtpTidCfgTidNum";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidPrefix = "utsDot3Onu2CtcH248RtpTidCfgTidPrefix";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin = "utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidMode = "utsDot3Onu2CtcH248RtpTidCfgTidMode";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidDigitLength = "utsDot3Onu2CtcH248RtpTidCfgTidDigitLength";
    public static final String utsDot3Onu2CtcH248RtpTidInfoFirstTidName = "utsDot3Onu2CtcH248RtpTidInfoFirstTidName";
    public static final String utsDot3Onu2CtcSipMgPort = "utsDot3Onu2CtcSipMgPort";
    public static final String utsDot3Onu2CtcSipProxyServIp = "utsDot3Onu2CtcSipProxyServIp";
    public static final String utsDot3Onu2CtcSipProxyServComPort = "utsDot3Onu2CtcSipProxyServComPort";
    public static final String utsDot3Onu2CtcSipBackupProxyServIp = "utsDot3Onu2CtcSipBackupProxyServIp";
    public static final String utsDot3Onu2CtcSipBackupProxyServComPort = "utsDot3Onu2CtcSipBackupProxyServComPort";
    public static final String utsDot3Onu2CtcSipActiveProxyServ = "utsDot3Onu2CtcSipActiveProxyServ";
    public static final String utsDot3Onu2CtcSipRegServIp = "utsDot3Onu2CtcSipRegServIp";
    public static final String utsDot3Onu2CtcSipRegServComPort = "utsDot3Onu2CtcSipRegServComPort";
    public static final String utsDot3Onu2CtcSipBackupRegServIp = "utsDot3Onu2CtcSipBackupRegServIp";
    public static final String utsDot3Onu2CtcSipBackupRegServComPort = "utsDot3Onu2CtcSipBackupRegServComPort";
    public static final String utsDot3Onu2CtcSipOutBoundServIp = "utsDot3Onu2CtcSipOutBoundServIp";
    public static final String utsDot3Onu2CtcSipOutBoundServPort = "utsDot3Onu2CtcSipOutBoundServPort";
    public static final String utsDot3Onu2CtcSipRegInterval = "utsDot3Onu2CtcSipRegInterval";
    public static final String utsDot3Onu2CtcSipHeartbeatSwitch = "utsDot3Onu2CtcSipHeartbeatSwitch";
    public static final String utsDot3Onu2CtcSipHeartbeatCycle = "utsDot3Onu2CtcSipHeartbeatCycle";
    public static final String utsDot3Onu2CtcSipHeartbeatCount = "utsDot3Onu2CtcSipHeartbeatCount";
    public static final String utsDot3Onu2CtcFaxmodemCfgT38Mode = "utsDot3Onu2CtcFaxmodemCfgT38Mode";
    public static final String utsDot3Onu2CtcFaxmodemCfgCtrl = "utsDot3Onu2CtcFaxmodemCfgCtrl";
    public static final String utsDot3Onu2CtcH248IadOperationStaus = "utsDot3Onu2CtcH248IadOperationStaus";
    public static final String utsDot3Onu2CtcIadOperation = "utsDot3Onu2CtcIadOperation";
    public static final String utsDot3Onu2CtcSipDigitMap = "utsDot3Onu2CtcSipDigitMap";

    public Onu2CtcCombinedFeaturesTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcCombinedFeaturesModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcCombinedFeaturesDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcCombinedFeaturesPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcCombinedFeaturesLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduResetCardCardNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcMduResetCardCardNumber, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduResetCardReset, new SnmpMibBeanProperty(utsDot3Onu2CtcMduResetCardReset, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcHoldoverAction, new SnmpMibBeanProperty(utsDot3Onu2CtcHoldoverAction, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcHoldoverTime, new SnmpMibBeanProperty(utsDot3Onu2CtcHoldoverTime, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcActivePonifAdminActivePon, new SnmpMibBeanProperty(utsDot3Onu2CtcActivePonifAdminActivePon, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcTftpOamCommit, new SnmpMibBeanProperty(utsDot3Onu2CtcTftpOamCommit, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.10", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadInfoMacAddr, new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoMacAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.101", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcIadInfoSupportedProtocol, new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoSupportedProtocol, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.102", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadInfoSoftwareVer, new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoSoftwareVer, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.103", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcIadInfoSoftwareDate, new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoSoftwareDate, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.104", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcIadInfoVoipUserCount, new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoVoipUserCount, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.105", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadIpMode, new SnmpMibBeanProperty(utsDot3Onu2CtcIadIpMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.131", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadIpAddr, new SnmpMibBeanProperty(utsDot3Onu2CtcIadIpAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.132", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcIadNetMask, new SnmpMibBeanProperty(utsDot3Onu2CtcIadNetMask, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.133", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcIadDefaultGw, new SnmpMibBeanProperty(utsDot3Onu2CtcIadDefaultGw, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.134", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcIadPppoeMode, new SnmpMibBeanProperty(utsDot3Onu2CtcIadPppoeMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.135", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadPppoeUsername, new SnmpMibBeanProperty(utsDot3Onu2CtcIadPppoeUsername, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.136", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcIadPppoePassword, new SnmpMibBeanProperty(utsDot3Onu2CtcIadPppoePassword, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.137", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcIadTagMode, new SnmpMibBeanProperty(utsDot3Onu2CtcIadTagMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.138", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadCvlan, new SnmpMibBeanProperty(utsDot3Onu2CtcIadCvlan, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.139", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadSvlan, new SnmpMibBeanProperty(utsDot3Onu2CtcIadSvlan, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.140", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadPriority, new SnmpMibBeanProperty(utsDot3Onu2CtcIadPriority, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.141", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248MgPort, new SnmpMibBeanProperty(utsDot3Onu2CtcH248MgPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.161", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248MgcIp, new SnmpMibBeanProperty(utsDot3Onu2CtcH248MgcIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.162", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcH248MgpComPort, new SnmpMibBeanProperty(utsDot3Onu2CtcH248MgpComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.163", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248BackupMgcIp, new SnmpMibBeanProperty(utsDot3Onu2CtcH248BackupMgcIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.164", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcH248BackupMgcComPort, new SnmpMibBeanProperty(utsDot3Onu2CtcH248BackupMgcComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.165", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248ActiveMgc, new SnmpMibBeanProperty(utsDot3Onu2CtcH248ActiveMgc, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.166", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248RegMode, new SnmpMibBeanProperty(utsDot3Onu2CtcH248RegMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.167", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248Mid, new SnmpMibBeanProperty(utsDot3Onu2CtcH248Mid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.168", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcH248HeartbeatMode, new SnmpMibBeanProperty(utsDot3Onu2CtcH248HeartbeatMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.169", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248HeartbeatCycle, new SnmpMibBeanProperty(utsDot3Onu2CtcH248HeartbeatCycle, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.170", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248HeartbeatCount, new SnmpMibBeanProperty(utsDot3Onu2CtcH248HeartbeatCount, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.171", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248RtpTidCfgTidNum, new SnmpMibBeanProperty(utsDot3Onu2CtcH248RtpTidCfgTidNum, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.201", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248RtpTidCfgTidPrefix, new SnmpMibBeanProperty(utsDot3Onu2CtcH248RtpTidCfgTidPrefix, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.202", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin, new SnmpMibBeanProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.203", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcH248RtpTidCfgTidMode, new SnmpMibBeanProperty(utsDot3Onu2CtcH248RtpTidCfgTidMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.204", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength, new SnmpMibBeanProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.205", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248RtpTidInfoFirstTidName, new SnmpMibBeanProperty(utsDot3Onu2CtcH248RtpTidInfoFirstTidName, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.231", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcSipMgPort, new SnmpMibBeanProperty(utsDot3Onu2CtcSipMgPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.261", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipProxyServIp, new SnmpMibBeanProperty(utsDot3Onu2CtcSipProxyServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.262", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcSipProxyServComPort, new SnmpMibBeanProperty(utsDot3Onu2CtcSipProxyServComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.263", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipBackupProxyServIp, new SnmpMibBeanProperty(utsDot3Onu2CtcSipBackupProxyServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.264", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcSipBackupProxyServComPort, new SnmpMibBeanProperty(utsDot3Onu2CtcSipBackupProxyServComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.265", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipActiveProxyServ, new SnmpMibBeanProperty(utsDot3Onu2CtcSipActiveProxyServ, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.266", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcSipRegServIp, new SnmpMibBeanProperty(utsDot3Onu2CtcSipRegServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.267", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcSipRegServComPort, new SnmpMibBeanProperty(utsDot3Onu2CtcSipRegServComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.268", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipBackupRegServIp, new SnmpMibBeanProperty(utsDot3Onu2CtcSipBackupRegServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.269", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcSipBackupRegServComPort, new SnmpMibBeanProperty(utsDot3Onu2CtcSipBackupRegServComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.270", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipOutBoundServIp, new SnmpMibBeanProperty(utsDot3Onu2CtcSipOutBoundServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.271", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcSipOutBoundServPort, new SnmpMibBeanProperty(utsDot3Onu2CtcSipOutBoundServPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.272", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipRegInterval, new SnmpMibBeanProperty(utsDot3Onu2CtcSipRegInterval, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.273", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipHeartbeatSwitch, new SnmpMibBeanProperty(utsDot3Onu2CtcSipHeartbeatSwitch, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.274", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipHeartbeatCycle, new SnmpMibBeanProperty(utsDot3Onu2CtcSipHeartbeatCycle, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.275", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipHeartbeatCount, new SnmpMibBeanProperty(utsDot3Onu2CtcSipHeartbeatCount, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.276", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode, new SnmpMibBeanProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.301", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFaxmodemCfgCtrl, new SnmpMibBeanProperty(utsDot3Onu2CtcFaxmodemCfgCtrl, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.302", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcH248IadOperationStaus, new SnmpMibBeanProperty(utsDot3Onu2CtcH248IadOperationStaus, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.331", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcIadOperation, new SnmpMibBeanProperty(utsDot3Onu2CtcIadOperation, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.332", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSipDigitMap, new SnmpMibBeanProperty(utsDot3Onu2CtcSipDigitMap, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.361", ISnmpConstant.STRING));
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesModuleId(Integer aUtsDot3Onu2CtcCombinedFeaturesModuleId) {
        setIndex(0, aUtsDot3Onu2CtcCombinedFeaturesModuleId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesDeviceId(Integer aUtsDot3Onu2CtcCombinedFeaturesDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcCombinedFeaturesDeviceId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesPortId) {
        setIndex(2, aUtsDot3Onu2CtcCombinedFeaturesPortId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesLogicalPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
    }

    public Integer getUtsDot3Onu2CtcMduResetCardCardNumber() {
        return (Integer) getProperty(utsDot3Onu2CtcMduResetCardCardNumber).getValue();
    }

    public void setUtsDot3Onu2CtcMduResetCardCardNumber(Integer aUtsDot3Onu2CtcMduResetCardCardNumber) {
        getProperty(utsDot3Onu2CtcMduResetCardCardNumber).setValue(aUtsDot3Onu2CtcMduResetCardCardNumber);
    }

    public Integer getUtsDot3Onu2CtcMduResetCardReset() {
        return (Integer) getProperty(utsDot3Onu2CtcMduResetCardReset).getValue();
    }

    public void setUtsDot3Onu2CtcMduResetCardReset(Integer aUtsDot3Onu2CtcMduResetCardReset) {
        getProperty(utsDot3Onu2CtcMduResetCardReset).setValue(aUtsDot3Onu2CtcMduResetCardReset);
    }

    public Integer getUtsDot3Onu2CtcHoldoverAction() {
        return (Integer) getProperty(utsDot3Onu2CtcHoldoverAction).getValue();
    }

    public void setUtsDot3Onu2CtcHoldoverAction(Integer aUtsDot3Onu2CtcHoldoverAction) {
        getProperty(utsDot3Onu2CtcHoldoverAction).setValue(aUtsDot3Onu2CtcHoldoverAction);
    }

    public Integer getUtsDot3Onu2CtcHoldoverTime() {
        return (Integer) getProperty(utsDot3Onu2CtcHoldoverTime).getValue();
    }

    public void setUtsDot3Onu2CtcHoldoverTime(Integer aUtsDot3Onu2CtcHoldoverTime) {
        getProperty(utsDot3Onu2CtcHoldoverTime).setValue(aUtsDot3Onu2CtcHoldoverTime);
    }

    public Integer getUtsDot3Onu2CtcActivePonifAdminActivePon() {
        return (Integer) getProperty(utsDot3Onu2CtcActivePonifAdminActivePon).getValue();
    }

    public void setUtsDot3Onu2CtcActivePonifAdminActivePon(Integer aUtsDot3Onu2CtcActivePonifAdminActivePon) {
        getProperty(utsDot3Onu2CtcActivePonifAdminActivePon).setValue(aUtsDot3Onu2CtcActivePonifAdminActivePon);
    }

    public Integer getUtsDot3Onu2CtcTftpOamCommit() {
        return (Integer) getProperty(utsDot3Onu2CtcTftpOamCommit).getValue();
    }

    public void setUtsDot3Onu2CtcTftpOamCommit(Integer aUtsDot3Onu2CtcTftpOamCommit) {
        getProperty(utsDot3Onu2CtcTftpOamCommit).setValue(aUtsDot3Onu2CtcTftpOamCommit);
    }

    public String getUtsDot3Onu2CtcIadInfoMacAddr() {
        return (String) getProperty(utsDot3Onu2CtcIadInfoMacAddr).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoMacAddr(String aUtsDot3Onu2CtcIadInfoMacAddr) {
        getProperty(utsDot3Onu2CtcIadInfoMacAddr).setValue(aUtsDot3Onu2CtcIadInfoMacAddr);
    }

    public Integer getUtsDot3Onu2CtcIadInfoSupportedProtocol() {
        return (Integer) getProperty(utsDot3Onu2CtcIadInfoSupportedProtocol).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoSupportedProtocol(Integer aUtsDot3Onu2CtcIadInfoSupportedProtocol) {
        getProperty(utsDot3Onu2CtcIadInfoSupportedProtocol).setValue(aUtsDot3Onu2CtcIadInfoSupportedProtocol);
    }

    public String getUtsDot3Onu2CtcIadInfoSoftwareVer() {
        return (String) getProperty(utsDot3Onu2CtcIadInfoSoftwareVer).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoSoftwareVer(String aUtsDot3Onu2CtcIadInfoSoftwareVer) {
        getProperty(utsDot3Onu2CtcIadInfoSoftwareVer).setValue(aUtsDot3Onu2CtcIadInfoSoftwareVer);
    }

    public String getUtsDot3Onu2CtcIadInfoSoftwareDate() {
        return (String) getProperty(utsDot3Onu2CtcIadInfoSoftwareDate).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoSoftwareDate(String aUtsDot3Onu2CtcIadInfoSoftwareDate) {
        getProperty(utsDot3Onu2CtcIadInfoSoftwareDate).setValue(aUtsDot3Onu2CtcIadInfoSoftwareDate);
    }

    public Integer getUtsDot3Onu2CtcIadInfoVoipUserCount() {
        return (Integer) getProperty(utsDot3Onu2CtcIadInfoVoipUserCount).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoVoipUserCount(Integer aUtsDot3Onu2CtcIadInfoVoipUserCount) {
        getProperty(utsDot3Onu2CtcIadInfoVoipUserCount).setValue(aUtsDot3Onu2CtcIadInfoVoipUserCount);
    }

    public Integer getUtsDot3Onu2CtcIadIpMode() {
        return (Integer) getProperty(utsDot3Onu2CtcIadIpMode).getValue();
    }

    public void setUtsDot3Onu2CtcIadIpMode(Integer aUtsDot3Onu2CtcIadIpMode) {
        getProperty(utsDot3Onu2CtcIadIpMode).setValue(aUtsDot3Onu2CtcIadIpMode);
    }

    public String getUtsDot3Onu2CtcIadIpAddr() {
        return (String) getProperty(utsDot3Onu2CtcIadIpAddr).getValue();
    }

    public void setUtsDot3Onu2CtcIadIpAddr(String aUtsDot3Onu2CtcIadIpAddr) {
        getProperty(utsDot3Onu2CtcIadIpAddr).setValue(aUtsDot3Onu2CtcIadIpAddr);
    }

    public String getUtsDot3Onu2CtcIadNetMask() {
        return (String) getProperty(utsDot3Onu2CtcIadNetMask).getValue();
    }

    public void setUtsDot3Onu2CtcIadNetMask(String aUtsDot3Onu2CtcIadNetMask) {
        getProperty(utsDot3Onu2CtcIadNetMask).setValue(aUtsDot3Onu2CtcIadNetMask);
    }

    public String getUtsDot3Onu2CtcIadDefaultGw() {
        return (String) getProperty(utsDot3Onu2CtcIadDefaultGw).getValue();
    }

    public void setUtsDot3Onu2CtcIadDefaultGw(String aUtsDot3Onu2CtcIadDefaultGw) {
        getProperty(utsDot3Onu2CtcIadDefaultGw).setValue(aUtsDot3Onu2CtcIadDefaultGw);
    }

    public Integer getUtsDot3Onu2CtcIadPppoeMode() {
        return (Integer) getProperty(utsDot3Onu2CtcIadPppoeMode).getValue();
    }

    public void setUtsDot3Onu2CtcIadPppoeMode(Integer aUtsDot3Onu2CtcIadPppoeMode) {
        getProperty(utsDot3Onu2CtcIadPppoeMode).setValue(aUtsDot3Onu2CtcIadPppoeMode);
    }

    public String getUtsDot3Onu2CtcIadPppoeUsername() {
        return (String) getProperty(utsDot3Onu2CtcIadPppoeUsername).getValue();
    }

    public void setUtsDot3Onu2CtcIadPppoeUsername(String aUtsDot3Onu2CtcIadPppoeUsername) {
        getProperty(utsDot3Onu2CtcIadPppoeUsername).setValue(aUtsDot3Onu2CtcIadPppoeUsername);
    }

    public String getUtsDot3Onu2CtcIadPppoePassword() {
        return (String) getProperty(utsDot3Onu2CtcIadPppoePassword).getValue();
    }

    public void setUtsDot3Onu2CtcIadPppoePassword(String aUtsDot3Onu2CtcIadPppoePassword) {
        getProperty(utsDot3Onu2CtcIadPppoePassword).setValue(aUtsDot3Onu2CtcIadPppoePassword);
    }

    public Integer getUtsDot3Onu2CtcIadTagMode() {
        return (Integer) getProperty(utsDot3Onu2CtcIadTagMode).getValue();
    }

    public void setUtsDot3Onu2CtcIadTagMode(Integer aUtsDot3Onu2CtcIadTagMode) {
        getProperty(utsDot3Onu2CtcIadTagMode).setValue(aUtsDot3Onu2CtcIadTagMode);
    }

    public Integer getUtsDot3Onu2CtcIadCvlan() {
        return (Integer) getProperty(utsDot3Onu2CtcIadCvlan).getValue();
    }

    public void setUtsDot3Onu2CtcIadCvlan(Integer aUtsDot3Onu2CtcIadCvlan) {
        getProperty(utsDot3Onu2CtcIadCvlan).setValue(aUtsDot3Onu2CtcIadCvlan);
    }

    public Integer getUtsDot3Onu2CtcIadSvlan() {
        return (Integer) getProperty(utsDot3Onu2CtcIadSvlan).getValue();
    }

    public void setUtsDot3Onu2CtcIadSvlan(Integer aUtsDot3Onu2CtcIadSvlan) {
        getProperty(utsDot3Onu2CtcIadSvlan).setValue(aUtsDot3Onu2CtcIadSvlan);
    }

    public Integer getUtsDot3Onu2CtcIadPriority() {
        return (Integer) getProperty(utsDot3Onu2CtcIadPriority).getValue();
    }

    public void setUtsDot3Onu2CtcIadPriority(Integer aUtsDot3Onu2CtcIadPriority) {
        getProperty(utsDot3Onu2CtcIadPriority).setValue(aUtsDot3Onu2CtcIadPriority);
    }

    public Integer getUtsDot3Onu2CtcH248MgPort() {
        return (Integer) getProperty(utsDot3Onu2CtcH248MgPort).getValue();
    }

    public void setUtsDot3Onu2CtcH248MgPort(Integer aUtsDot3Onu2CtcH248MgPort) {
        getProperty(utsDot3Onu2CtcH248MgPort).setValue(aUtsDot3Onu2CtcH248MgPort);
    }

    public String getUtsDot3Onu2CtcH248MgcIp() {
        return (String) getProperty(utsDot3Onu2CtcH248MgcIp).getValue();
    }

    public void setUtsDot3Onu2CtcH248MgcIp(String aUtsDot3Onu2CtcH248MgcIp) {
        getProperty(utsDot3Onu2CtcH248MgcIp).setValue(aUtsDot3Onu2CtcH248MgcIp);
    }

    public Integer getUtsDot3Onu2CtcH248MgpComPort() {
        return (Integer) getProperty(utsDot3Onu2CtcH248MgpComPort).getValue();
    }

    public void setUtsDot3Onu2CtcH248MgpComPort(Integer aUtsDot3Onu2CtcH248MgpComPort) {
        getProperty(utsDot3Onu2CtcH248MgpComPort).setValue(aUtsDot3Onu2CtcH248MgpComPort);
    }

    public String getUtsDot3Onu2CtcH248BackupMgcIp() {
        return (String) getProperty(utsDot3Onu2CtcH248BackupMgcIp).getValue();
    }

    public void setUtsDot3Onu2CtcH248BackupMgcIp(String aUtsDot3Onu2CtcH248BackupMgcIp) {
        getProperty(utsDot3Onu2CtcH248BackupMgcIp).setValue(aUtsDot3Onu2CtcH248BackupMgcIp);
    }

    public Integer getUtsDot3Onu2CtcH248BackupMgcComPort() {
        return (Integer) getProperty(utsDot3Onu2CtcH248BackupMgcComPort).getValue();
    }

    public void setUtsDot3Onu2CtcH248BackupMgcComPort(Integer aUtsDot3Onu2CtcH248BackupMgcComPort) {
        getProperty(utsDot3Onu2CtcH248BackupMgcComPort).setValue(aUtsDot3Onu2CtcH248BackupMgcComPort);
    }

    public Integer getUtsDot3Onu2CtcH248ActiveMgc() {
        return (Integer) getProperty(utsDot3Onu2CtcH248ActiveMgc).getValue();
    }

    public void setUtsDot3Onu2CtcH248ActiveMgc(Integer aUtsDot3Onu2CtcH248ActiveMgc) {
        getProperty(utsDot3Onu2CtcH248ActiveMgc).setValue(aUtsDot3Onu2CtcH248ActiveMgc);
    }

    public Integer getUtsDot3Onu2CtcH248RegMode() {
        return (Integer) getProperty(utsDot3Onu2CtcH248RegMode).getValue();
    }

    public void setUtsDot3Onu2CtcH248RegMode(Integer aUtsDot3Onu2CtcH248RegMode) {
        getProperty(utsDot3Onu2CtcH248RegMode).setValue(aUtsDot3Onu2CtcH248RegMode);
    }

    public String getUtsDot3Onu2CtcH248Mid() {
        return (String) getProperty(utsDot3Onu2CtcH248Mid).getValue();
    }

    public void setUtsDot3Onu2CtcH248Mid(String aUtsDot3Onu2CtcH248Mid) {
        getProperty(utsDot3Onu2CtcH248Mid).setValue(aUtsDot3Onu2CtcH248Mid);
    }

    public Integer getUtsDot3Onu2CtcH248HeartbeatMode() {
        return (Integer) getProperty(utsDot3Onu2CtcH248HeartbeatMode).getValue();
    }

    public void setUtsDot3Onu2CtcH248HeartbeatMode(Integer aUtsDot3Onu2CtcH248HeartbeatMode) {
        getProperty(utsDot3Onu2CtcH248HeartbeatMode).setValue(aUtsDot3Onu2CtcH248HeartbeatMode);
    }

    public Integer getUtsDot3Onu2CtcH248HeartbeatCycle() {
        return (Integer) getProperty(utsDot3Onu2CtcH248HeartbeatCycle).getValue();
    }

    public void setUtsDot3Onu2CtcH248HeartbeatCycle(Integer aUtsDot3Onu2CtcH248HeartbeatCycle) {
        getProperty(utsDot3Onu2CtcH248HeartbeatCycle).setValue(aUtsDot3Onu2CtcH248HeartbeatCycle);
    }

    public Integer getUtsDot3Onu2CtcH248HeartbeatCount() {
        return (Integer) getProperty(utsDot3Onu2CtcH248HeartbeatCount).getValue();
    }

    public void setUtsDot3Onu2CtcH248HeartbeatCount(Integer aUtsDot3Onu2CtcH248HeartbeatCount) {
        getProperty(utsDot3Onu2CtcH248HeartbeatCount).setValue(aUtsDot3Onu2CtcH248HeartbeatCount);
    }

    public Integer getUtsDot3Onu2CtcH248RtpTidCfgTidNum() {
        return (Integer) getProperty(utsDot3Onu2CtcH248RtpTidCfgTidNum).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidNum(Integer aUtsDot3Onu2CtcH248RtpTidCfgTidNum) {
        getProperty(utsDot3Onu2CtcH248RtpTidCfgTidNum).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidNum);
    }

    public String getUtsDot3Onu2CtcH248RtpTidCfgTidPrefix() {
        return (String) getProperty(utsDot3Onu2CtcH248RtpTidCfgTidPrefix).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidPrefix(String aUtsDot3Onu2CtcH248RtpTidCfgTidPrefix) {
        getProperty(utsDot3Onu2CtcH248RtpTidCfgTidPrefix).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidPrefix);
    }

    public String getUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin() {
        return (String) getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin(String aUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin) {
        getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin);
    }

    public Integer getUtsDot3Onu2CtcH248RtpTidCfgTidMode() {
        return (Integer) getProperty(utsDot3Onu2CtcH248RtpTidCfgTidMode).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidMode(Integer aUtsDot3Onu2CtcH248RtpTidCfgTidMode) {
        getProperty(utsDot3Onu2CtcH248RtpTidCfgTidMode).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidMode);
    }

    public Integer getUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength() {
        return (Integer) getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength(Integer aUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength) {
        getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength);
    }

    public String getUtsDot3Onu2CtcH248RtpTidInfoFirstTidName() {
        return (String) getProperty(utsDot3Onu2CtcH248RtpTidInfoFirstTidName).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidInfoFirstTidName(String aUtsDot3Onu2CtcH248RtpTidInfoFirstTidName) {
        getProperty(utsDot3Onu2CtcH248RtpTidInfoFirstTidName).setValue(aUtsDot3Onu2CtcH248RtpTidInfoFirstTidName);
    }

    public Integer getUtsDot3Onu2CtcSipMgPort() {
        return (Integer) getProperty(utsDot3Onu2CtcSipMgPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipMgPort(Integer aUtsDot3Onu2CtcSipMgPort) {
        getProperty(utsDot3Onu2CtcSipMgPort).setValue(aUtsDot3Onu2CtcSipMgPort);
    }

    public String getUtsDot3Onu2CtcSipProxyServIp() {
        return (String) getProperty(utsDot3Onu2CtcSipProxyServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipProxyServIp(String aUtsDot3Onu2CtcSipProxyServIp) {
        getProperty(utsDot3Onu2CtcSipProxyServIp).setValue(aUtsDot3Onu2CtcSipProxyServIp);
    }

    public Integer getUtsDot3Onu2CtcSipProxyServComPort() {
        return (Integer) getProperty(utsDot3Onu2CtcSipProxyServComPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipProxyServComPort(Integer aUtsDot3Onu2CtcSipProxyServComPort) {
        getProperty(utsDot3Onu2CtcSipProxyServComPort).setValue(aUtsDot3Onu2CtcSipProxyServComPort);
    }

    public String getUtsDot3Onu2CtcSipBackupProxyServIp() {
        return (String) getProperty(utsDot3Onu2CtcSipBackupProxyServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipBackupProxyServIp(String aUtsDot3Onu2CtcSipBackupProxyServIp) {
        getProperty(utsDot3Onu2CtcSipBackupProxyServIp).setValue(aUtsDot3Onu2CtcSipBackupProxyServIp);
    }

    public Integer getUtsDot3Onu2CtcSipBackupProxyServComPort() {
        return (Integer) getProperty(utsDot3Onu2CtcSipBackupProxyServComPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipBackupProxyServComPort(Integer aUtsDot3Onu2CtcSipBackupProxyServComPort) {
        getProperty(utsDot3Onu2CtcSipBackupProxyServComPort).setValue(aUtsDot3Onu2CtcSipBackupProxyServComPort);
    }

    public String getUtsDot3Onu2CtcSipActiveProxyServ() {
        return (String) getProperty(utsDot3Onu2CtcSipActiveProxyServ).getValue();
    }

    public void setUtsDot3Onu2CtcSipActiveProxyServ(String aUtsDot3Onu2CtcSipActiveProxyServ) {
        getProperty(utsDot3Onu2CtcSipActiveProxyServ).setValue(aUtsDot3Onu2CtcSipActiveProxyServ);
    }

    public String getUtsDot3Onu2CtcSipRegServIp() {
        return (String) getProperty(utsDot3Onu2CtcSipRegServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipRegServIp(String aUtsDot3Onu2CtcSipRegServIp) {
        getProperty(utsDot3Onu2CtcSipRegServIp).setValue(aUtsDot3Onu2CtcSipRegServIp);
    }

    public Integer getUtsDot3Onu2CtcSipRegServComPort() {
        return (Integer) getProperty(utsDot3Onu2CtcSipRegServComPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipRegServComPort(Integer aUtsDot3Onu2CtcSipRegServComPort) {
        getProperty(utsDot3Onu2CtcSipRegServComPort).setValue(aUtsDot3Onu2CtcSipRegServComPort);
    }

    public String getUtsDot3Onu2CtcSipBackupRegServIp() {
        return (String) getProperty(utsDot3Onu2CtcSipBackupRegServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipBackupRegServIp(String aUtsDot3Onu2CtcSipBackupRegServIp) {
        getProperty(utsDot3Onu2CtcSipBackupRegServIp).setValue(aUtsDot3Onu2CtcSipBackupRegServIp);
    }

    public Integer getUtsDot3Onu2CtcSipBackupRegServComPort() {
        return (Integer) getProperty(utsDot3Onu2CtcSipBackupRegServComPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipBackupRegServComPort(Integer aUtsDot3Onu2CtcSipBackupRegServComPort) {
        getProperty(utsDot3Onu2CtcSipBackupRegServComPort).setValue(aUtsDot3Onu2CtcSipBackupRegServComPort);
    }

    public String getUtsDot3Onu2CtcSipOutBoundServIp() {
        return (String) getProperty(utsDot3Onu2CtcSipOutBoundServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipOutBoundServIp(String aUtsDot3Onu2CtcSipOutBoundServIp) {
        getProperty(utsDot3Onu2CtcSipOutBoundServIp).setValue(aUtsDot3Onu2CtcSipOutBoundServIp);
    }

    public Integer getUtsDot3Onu2CtcSipOutBoundServPort() {
        return (Integer) getProperty(utsDot3Onu2CtcSipOutBoundServPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipOutBoundServPort(Integer aUtsDot3Onu2CtcSipOutBoundServPort) {
        getProperty(utsDot3Onu2CtcSipOutBoundServPort).setValue(aUtsDot3Onu2CtcSipOutBoundServPort);
    }

    public Integer getUtsDot3Onu2CtcSipRegInterval() {
        return (Integer) getProperty(utsDot3Onu2CtcSipRegInterval).getValue();
    }

    public void setUtsDot3Onu2CtcSipRegInterval(Integer aUtsDot3Onu2CtcSipRegInterval) {
        getProperty(utsDot3Onu2CtcSipRegInterval).setValue(aUtsDot3Onu2CtcSipRegInterval);
    }

    public Integer getUtsDot3Onu2CtcSipHeartbeatSwitch() {
        return (Integer) getProperty(utsDot3Onu2CtcSipHeartbeatSwitch).getValue();
    }

    public void setUtsDot3Onu2CtcSipHeartbeatSwitch(Integer aUtsDot3Onu2CtcSipHeartbeatSwitch) {
        getProperty(utsDot3Onu2CtcSipHeartbeatSwitch).setValue(aUtsDot3Onu2CtcSipHeartbeatSwitch);
    }

    public Integer getUtsDot3Onu2CtcSipHeartbeatCycle() {
        return (Integer) getProperty(utsDot3Onu2CtcSipHeartbeatCycle).getValue();
    }

    public void setUtsDot3Onu2CtcSipHeartbeatCycle(Integer aUtsDot3Onu2CtcSipHeartbeatCycle) {
        getProperty(utsDot3Onu2CtcSipHeartbeatCycle).setValue(aUtsDot3Onu2CtcSipHeartbeatCycle);
    }

    public Integer getUtsDot3Onu2CtcSipHeartbeatCount() {
        return (Integer) getProperty(utsDot3Onu2CtcSipHeartbeatCount).getValue();
    }

    public void setUtsDot3Onu2CtcSipHeartbeatCount(Integer aUtsDot3Onu2CtcSipHeartbeatCount) {
        getProperty(utsDot3Onu2CtcSipHeartbeatCount).setValue(aUtsDot3Onu2CtcSipHeartbeatCount);
    }

    public Integer getUtsDot3Onu2CtcFaxmodemCfgT38Mode() {
        return (Integer) getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode).getValue();
    }

    public void setUtsDot3Onu2CtcFaxmodemCfgT38Mode(Integer aUtsDot3Onu2CtcFaxmodemCfgT38Mode) {
        getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode).setValue(aUtsDot3Onu2CtcFaxmodemCfgT38Mode);
    }

    public Integer getUtsDot3Onu2CtcFaxmodemCfgCtrl() {
        return (Integer) getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl).getValue();
    }

    public void setUtsDot3Onu2CtcFaxmodemCfgCtrl(Integer aUtsDot3Onu2CtcFaxmodemCfgCtrl) {
        getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl).setValue(aUtsDot3Onu2CtcFaxmodemCfgCtrl);
    }

    public Integer getUtsDot3Onu2CtcH248IadOperationStaus() {
        return (Integer) getProperty(utsDot3Onu2CtcH248IadOperationStaus).getValue();
    }

    public void setUtsDot3Onu2CtcH248IadOperationStaus(Integer aUtsDot3Onu2CtcH248IadOperationStaus) {
        getProperty(utsDot3Onu2CtcH248IadOperationStaus).setValue(aUtsDot3Onu2CtcH248IadOperationStaus);
    }

    public Integer getUtsDot3Onu2CtcIadOperation() {
        return (Integer) getProperty(utsDot3Onu2CtcIadOperation).getValue();
    }

    public void setUtsDot3Onu2CtcIadOperation(Integer aUtsDot3Onu2CtcIadOperation) {
        getProperty(utsDot3Onu2CtcIadOperation).setValue(aUtsDot3Onu2CtcIadOperation);
    }

    public String getUtsDot3Onu2CtcSipDigitMap() {
        return (String) getProperty(utsDot3Onu2CtcSipDigitMap).getValue();
    }

    public void setUtsDot3Onu2CtcSipDigitMap(String aUtsDot3Onu2CtcSipDigitMap) {
        getProperty(utsDot3Onu2CtcSipDigitMap).setValue(aUtsDot3Onu2CtcSipDigitMap);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcMduResetCardCardNumber));
        prepareRead(getProperty(utsDot3Onu2CtcMduResetCardReset));
        prepareRead(getProperty(utsDot3Onu2CtcHoldoverAction));
        prepareRead(getProperty(utsDot3Onu2CtcHoldoverTime));
        prepareRead(getProperty(utsDot3Onu2CtcActivePonifAdminActivePon));
        prepareRead(getProperty(utsDot3Onu2CtcTftpOamCommit));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoMacAddr));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoSupportedProtocol));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoSoftwareVer));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoSoftwareDate));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoVoipUserCount));
        prepareRead(getProperty(utsDot3Onu2CtcIadIpMode));
        prepareRead(getProperty(utsDot3Onu2CtcIadIpAddr));
        prepareRead(getProperty(utsDot3Onu2CtcIadNetMask));
        prepareRead(getProperty(utsDot3Onu2CtcIadDefaultGw));
        prepareRead(getProperty(utsDot3Onu2CtcIadPppoeMode));
        prepareRead(getProperty(utsDot3Onu2CtcIadPppoeUsername));
        prepareRead(getProperty(utsDot3Onu2CtcIadPppoePassword));
        prepareRead(getProperty(utsDot3Onu2CtcIadTagMode));
        prepareRead(getProperty(utsDot3Onu2CtcIadCvlan));
        prepareRead(getProperty(utsDot3Onu2CtcIadSvlan));
        prepareRead(getProperty(utsDot3Onu2CtcIadPriority));
        prepareRead(getProperty(utsDot3Onu2CtcH248MgPort));
        prepareRead(getProperty(utsDot3Onu2CtcH248MgcIp));
        prepareRead(getProperty(utsDot3Onu2CtcH248MgpComPort));
        prepareRead(getProperty(utsDot3Onu2CtcH248BackupMgcIp));
        prepareRead(getProperty(utsDot3Onu2CtcH248BackupMgcComPort));
        prepareRead(getProperty(utsDot3Onu2CtcH248ActiveMgc));
        prepareRead(getProperty(utsDot3Onu2CtcH248RegMode));
        prepareRead(getProperty(utsDot3Onu2CtcH248Mid));
        prepareRead(getProperty(utsDot3Onu2CtcH248HeartbeatMode));
        prepareRead(getProperty(utsDot3Onu2CtcH248HeartbeatCycle));
        prepareRead(getProperty(utsDot3Onu2CtcH248HeartbeatCount));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidNum));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidPrefix));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidMode));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidInfoFirstTidName));
        prepareRead(getProperty(utsDot3Onu2CtcSipMgPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipProxyServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipProxyServComPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipBackupProxyServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipBackupProxyServComPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipActiveProxyServ));
        prepareRead(getProperty(utsDot3Onu2CtcSipRegServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipRegServComPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipBackupRegServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipBackupRegServComPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipOutBoundServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipOutBoundServPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipRegInterval));
        prepareRead(getProperty(utsDot3Onu2CtcSipHeartbeatSwitch));
        prepareRead(getProperty(utsDot3Onu2CtcSipHeartbeatCycle));
        prepareRead(getProperty(utsDot3Onu2CtcSipHeartbeatCount));
        prepareRead(getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode));
        prepareRead(getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl));
        prepareRead(getProperty(utsDot3Onu2CtcH248IadOperationStaus));
        prepareRead(getProperty(utsDot3Onu2CtcIadOperation));
        prepareRead(getProperty(utsDot3Onu2CtcSipDigitMap));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcMduResetCardCardNumber));
        prepareRead(getProperty(utsDot3Onu2CtcMduResetCardReset));
        prepareRead(getProperty(utsDot3Onu2CtcHoldoverAction));
        prepareRead(getProperty(utsDot3Onu2CtcHoldoverTime));
        prepareRead(getProperty(utsDot3Onu2CtcActivePonifAdminActivePon));
        prepareRead(getProperty(utsDot3Onu2CtcTftpOamCommit));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoMacAddr));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoSupportedProtocol));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoSoftwareVer));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoSoftwareDate));
        prepareRead(getProperty(utsDot3Onu2CtcIadInfoVoipUserCount));
        prepareRead(getProperty(utsDot3Onu2CtcIadIpMode));
        prepareRead(getProperty(utsDot3Onu2CtcIadIpAddr));
        prepareRead(getProperty(utsDot3Onu2CtcIadNetMask));
        prepareRead(getProperty(utsDot3Onu2CtcIadDefaultGw));
        prepareRead(getProperty(utsDot3Onu2CtcIadPppoeMode));
        prepareRead(getProperty(utsDot3Onu2CtcIadPppoeUsername));
        prepareRead(getProperty(utsDot3Onu2CtcIadPppoePassword));
        prepareRead(getProperty(utsDot3Onu2CtcIadTagMode));
        prepareRead(getProperty(utsDot3Onu2CtcIadCvlan));
        prepareRead(getProperty(utsDot3Onu2CtcIadSvlan));
        prepareRead(getProperty(utsDot3Onu2CtcIadPriority));
        prepareRead(getProperty(utsDot3Onu2CtcH248MgPort));
        prepareRead(getProperty(utsDot3Onu2CtcH248MgcIp));
        prepareRead(getProperty(utsDot3Onu2CtcH248MgpComPort));
        prepareRead(getProperty(utsDot3Onu2CtcH248BackupMgcIp));
        prepareRead(getProperty(utsDot3Onu2CtcH248BackupMgcComPort));
        prepareRead(getProperty(utsDot3Onu2CtcH248ActiveMgc));
        prepareRead(getProperty(utsDot3Onu2CtcH248RegMode));
        prepareRead(getProperty(utsDot3Onu2CtcH248Mid));
        prepareRead(getProperty(utsDot3Onu2CtcH248HeartbeatMode));
        prepareRead(getProperty(utsDot3Onu2CtcH248HeartbeatCycle));
        prepareRead(getProperty(utsDot3Onu2CtcH248HeartbeatCount));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidNum));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidPrefix));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidMode));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength));
        prepareRead(getProperty(utsDot3Onu2CtcH248RtpTidInfoFirstTidName));
        prepareRead(getProperty(utsDot3Onu2CtcSipMgPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipProxyServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipProxyServComPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipBackupProxyServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipBackupProxyServComPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipActiveProxyServ));
        prepareRead(getProperty(utsDot3Onu2CtcSipRegServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipRegServComPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipBackupRegServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipBackupRegServComPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipOutBoundServIp));
        prepareRead(getProperty(utsDot3Onu2CtcSipOutBoundServPort));
        prepareRead(getProperty(utsDot3Onu2CtcSipRegInterval));
        prepareRead(getProperty(utsDot3Onu2CtcSipHeartbeatSwitch));
        prepareRead(getProperty(utsDot3Onu2CtcSipHeartbeatCycle));
        prepareRead(getProperty(utsDot3Onu2CtcSipHeartbeatCount));
        prepareRead(getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode));
        prepareRead(getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl));
        prepareRead(getProperty(utsDot3Onu2CtcH248IadOperationStaus));
        prepareRead(getProperty(utsDot3Onu2CtcIadOperation));
        prepareRead(getProperty(utsDot3Onu2CtcSipDigitMap));

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3Onu2CtcMduResetCardReset));
        prepareSave(getProperty(utsDot3Onu2CtcHoldoverAction));
        prepareSave(getProperty(utsDot3Onu2CtcHoldoverTime));
        prepareSave(getProperty(utsDot3Onu2CtcActivePonifAdminActivePon));
        prepareSave(getProperty(utsDot3Onu2CtcTftpOamCommit));
        prepareSave(getProperty(utsDot3Onu2CtcIadIpMode));
        prepareSave(getProperty(utsDot3Onu2CtcIadIpAddr));
        prepareSave(getProperty(utsDot3Onu2CtcIadNetMask));
        prepareSave(getProperty(utsDot3Onu2CtcIadDefaultGw));
        prepareSave(getProperty(utsDot3Onu2CtcIadPppoeMode));
        prepareSave(getProperty(utsDot3Onu2CtcIadPppoeUsername));
        prepareSave(getProperty(utsDot3Onu2CtcIadPppoePassword));
        prepareSave(getProperty(utsDot3Onu2CtcIadTagMode));
        prepareSave(getProperty(utsDot3Onu2CtcIadCvlan));
        prepareSave(getProperty(utsDot3Onu2CtcIadSvlan));
        prepareSave(getProperty(utsDot3Onu2CtcIadPriority));
        prepareSave(getProperty(utsDot3Onu2CtcH248MgPort));
        prepareSave(getProperty(utsDot3Onu2CtcH248MgcIp));
        prepareSave(getProperty(utsDot3Onu2CtcH248MgpComPort));
        prepareSave(getProperty(utsDot3Onu2CtcH248BackupMgcIp));
        prepareSave(getProperty(utsDot3Onu2CtcH248BackupMgcComPort));
        prepareSave(getProperty(utsDot3Onu2CtcH248ActiveMgc));
        prepareSave(getProperty(utsDot3Onu2CtcH248RegMode));
        prepareSave(getProperty(utsDot3Onu2CtcH248Mid));
        prepareSave(getProperty(utsDot3Onu2CtcH248HeartbeatMode));
        prepareSave(getProperty(utsDot3Onu2CtcH248HeartbeatCycle));
        prepareSave(getProperty(utsDot3Onu2CtcH248HeartbeatCount));
        prepareSave(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidNum));
        prepareSave(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidPrefix));
        prepareSave(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin));
        prepareSave(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidMode));
        prepareSave(getProperty(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength));
        prepareSave(getProperty(utsDot3Onu2CtcSipMgPort));
        prepareSave(getProperty(utsDot3Onu2CtcSipProxyServIp));
        prepareSave(getProperty(utsDot3Onu2CtcSipProxyServComPort));
        prepareSave(getProperty(utsDot3Onu2CtcSipBackupProxyServIp));
        prepareSave(getProperty(utsDot3Onu2CtcSipBackupProxyServComPort));
        prepareSave(getProperty(utsDot3Onu2CtcSipActiveProxyServ));
        prepareSave(getProperty(utsDot3Onu2CtcSipRegServIp));
        prepareSave(getProperty(utsDot3Onu2CtcSipRegServComPort));
        prepareSave(getProperty(utsDot3Onu2CtcSipBackupRegServIp));
        prepareSave(getProperty(utsDot3Onu2CtcSipBackupRegServComPort));
        prepareSave(getProperty(utsDot3Onu2CtcSipOutBoundServIp));
        prepareSave(getProperty(utsDot3Onu2CtcSipOutBoundServPort));
        prepareSave(getProperty(utsDot3Onu2CtcSipRegInterval));
        prepareSave(getProperty(utsDot3Onu2CtcSipHeartbeatSwitch));
        prepareSave(getProperty(utsDot3Onu2CtcSipHeartbeatCycle));
        prepareSave(getProperty(utsDot3Onu2CtcSipHeartbeatCount));
        prepareSave(getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode));
        prepareSave(getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl));
        prepareSave(getProperty(utsDot3Onu2CtcIadOperation));
        prepareSave(getProperty(utsDot3Onu2CtcSipDigitMap));

        return save();
    }

}
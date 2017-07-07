package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2VoipH248SettingTable class. Created by QuickDVM
 */
public class Dot3Onu2VoipH248SettingTable extends SnmpMibBean {
	public static final String utsDot3Onu2VoipModuleId = "utsDot3Onu2VoipModuleId";
	public static final String utsDot3Onu2VoipDeviceId = "utsDot3Onu2VoipDeviceId";
	public static final String utsDot3Onu2VoipPortId = "utsDot3Onu2VoipPortId";
	public static final String utsDot3Onu2VoipLogicalPortId = "utsDot3Onu2VoipLogicalPortId";
	
	public static final String utsDot3Onu2VoipH248MgPort = "utsDot3Onu2VoipH248MgPort";
	public static final String utsDot3Onu2VoipH248PrimaryMgcIp = "utsDot3Onu2VoipH248PrimaryMgcIp";
	public static final String utsDot3Onu2VoipH248PrimaryMgcPort = "utsDot3Onu2VoipH248PrimaryMgcPort";
	public static final String utsDot3Onu2VoipH248BackupMgcIp = "utsDot3Onu2VoipH248BackupMgcIp";
	public static final String utsDot3Onu2VoipH248BackupMgcPort = "utsDot3Onu2VoipH248BackupMgcPort";
	public static final String utsDot3Onu2VoipH248ActiveMgc = "utsDot3Onu2VoipH248ActiveMgc";
	public static final String utsDot3Onu2VoipH248RegisterMode = "utsDot3Onu2VoipH248RegisterMode";
	public static final String utsDot3Onu2VoipH248Mid = "utsDot3Onu2VoipH248Mid";
	public static final String utsDot3Onu2VoipH248HeartbeatMode = "utsDot3Onu2VoipH248HeartbeatMode";
	public static final String utsDot3Onu2VoipH248HeartbeatCycle = "utsDot3Onu2VoipH248HeartbeatCycle";
	public static final String utsDot3Onu2VoipH248HeartbeatCount = "utsDot3Onu2VoipH248HeartbeatCount";
	public static final String utsDot3Onu2VoipH248RtpTidNum = "utsDot3Onu2VoipH248RtpTidNum";
	public static final String utsDot3Onu2VoipH248RtpTidPrefix = "utsDot3Onu2VoipH248RtpTidPrefix";
	public static final String utsDot3Onu2VoipH248RtpTidDigitBegin = "utsDot3Onu2VoipH248RtpTidDigitBegin";
	public static final String utsDot3Onu2VoipH248RtpTidMode = "utsDot3Onu2VoipH248RtpTidMode";
	public static final String utsDot3Onu2VoipH248RtpTidDigitLen = "utsDot3Onu2VoipH248RtpTidDigitLen";
	public static final String utsDot3Onu2VoipH248FirstRtpTidName = "utsDot3Onu2VoipH248FirstRtpTidName";

	public Dot3Onu2VoipH248SettingTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2VoipModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipModuleId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipDeviceId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPortId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipLogicalPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.4",
				ISnmpConstant.INTEGER));
		
		initProperty(utsDot3Onu2VoipH248MgPort, new SnmpMibBeanProperty(
				utsDot3Onu2VoipH248MgPort,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248PrimaryMgcIp,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248PrimaryMgcIp,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.2",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2VoipH248PrimaryMgcPort,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248PrimaryMgcPort,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248BackupMgcIp,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248BackupMgcIp,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.4",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2VoipH248BackupMgcPort, new SnmpMibBeanProperty(
				utsDot3Onu2VoipH248BackupMgcPort,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248ActiveMgc, new SnmpMibBeanProperty(
				utsDot3Onu2VoipH248ActiveMgc,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248RegisterMode, new SnmpMibBeanProperty(
				utsDot3Onu2VoipH248RegisterMode,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248Mid,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248Mid,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.8",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2VoipH248HeartbeatMode, new SnmpMibBeanProperty(
				utsDot3Onu2VoipH248HeartbeatMode,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248HeartbeatCycle,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248HeartbeatCycle,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.10",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248HeartbeatCount,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248HeartbeatCount,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.11",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248RtpTidNum, new SnmpMibBeanProperty(
				utsDot3Onu2VoipH248RtpTidNum,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.12",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248RtpTidPrefix, new SnmpMibBeanProperty(
				utsDot3Onu2VoipH248RtpTidPrefix,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.13",
				ISnmpConstant.STRING));
		initProperty(utsDot3Onu2VoipH248RtpTidDigitBegin,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248RtpTidDigitBegin,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.14",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248RtpTidMode, new SnmpMibBeanProperty(
				utsDot3Onu2VoipH248RtpTidMode,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.15",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248RtpTidDigitLen,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248RtpTidDigitLen,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.16",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipH248FirstRtpTidName,
				new SnmpMibBeanProperty(utsDot3Onu2VoipH248FirstRtpTidName,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.49.1.17",
						ISnmpConstant.STRING));

	}
	
	public Integer getUtsDot3Onu2VoipModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2VoipModuleId(Integer aUtsDot3Onu2VoipModuleId) {
		setIndex(0, aUtsDot3Onu2VoipModuleId);
	}

	public Integer getUtsDot3Onu2VoipDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2VoipDeviceId(Integer aUtsDot3Onu2VoipDeviceId) {
		setIndex(1, aUtsDot3Onu2VoipDeviceId);
	}

	public Integer getUtsDot3Onu2VoipPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2VoipPortId(Integer aUtsDot3Onu2VoipPortId) {
		setIndex(2, aUtsDot3Onu2VoipPortId);
	}

	public Integer getUtsDot3Onu2VoipLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2VoipLogicalPortId(
			Integer aUtsDot3Onu2VoipLogicalPortId) {
		setIndex(3, aUtsDot3Onu2VoipLogicalPortId);
	}

	public Integer getUtsDot3Onu2VoipH248MgPort() {
		return (Integer) getProperty(utsDot3Onu2VoipH248MgPort).getValue();
	}

	public void setUtsDot3Onu2VoipH248MgPort(Integer aUtsDot3Onu2VoipH248MgPort) {
		getProperty(utsDot3Onu2VoipH248MgPort).setValue(
				aUtsDot3Onu2VoipH248MgPort);
	}

	public String getUtsDot3Onu2VoipH248PrimaryMgcIp() {
		return (String) getProperty(utsDot3Onu2VoipH248PrimaryMgcIp).getValue();
	}

	public void setUtsDot3Onu2VoipH248PrimaryMgcIp(
			String aUtsDot3Onu2VoipH248PrimaryMgcIp) {
		getProperty(utsDot3Onu2VoipH248PrimaryMgcIp).setValue(
				aUtsDot3Onu2VoipH248PrimaryMgcIp);
	}

	public Integer getUtsDot3Onu2VoipH248PrimaryMgcPort() {
		return (Integer) getProperty(utsDot3Onu2VoipH248PrimaryMgcPort)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248PrimaryMgcPort(
			Integer aUtsDot3Onu2VoipH248PrimaryMgcPort) {
		getProperty(utsDot3Onu2VoipH248PrimaryMgcPort).setValue(
				aUtsDot3Onu2VoipH248PrimaryMgcPort);
	}

	public String getUtsDot3Onu2VoipH248BackupMgcIp() {
		return (String) getProperty(utsDot3Onu2VoipH248BackupMgcIp).getValue();
	}

	public void setUtsDot3Onu2VoipH248BackupMgcIp(
			String aUtsDot3Onu2VoipH248BackupMgcIp) {
		getProperty(utsDot3Onu2VoipH248BackupMgcIp).setValue(
				aUtsDot3Onu2VoipH248BackupMgcIp);
	}

	public Integer getUtsDot3Onu2VoipH248BackupMgcPort() {
		return (Integer) getProperty(utsDot3Onu2VoipH248BackupMgcPort)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248BackupMgcPort(
			Integer aUtsDot3Onu2VoipH248BackupMgcPort) {
		getProperty(utsDot3Onu2VoipH248BackupMgcPort).setValue(
				aUtsDot3Onu2VoipH248BackupMgcPort);
	}

	public Integer getUtsDot3Onu2VoipH248ActiveMgc() {
		return (Integer) getProperty(utsDot3Onu2VoipH248ActiveMgc).getValue();
	}

	public void setUtsDot3Onu2VoipH248ActiveMgc(
			Integer aUtsDot3Onu2VoipH248ActiveMgc) {
		getProperty(utsDot3Onu2VoipH248ActiveMgc).setValue(
				aUtsDot3Onu2VoipH248ActiveMgc);
	}

	public Integer getUtsDot3Onu2VoipH248RegisterMode() {
		return (Integer) getProperty(utsDot3Onu2VoipH248RegisterMode)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248RegisterMode(
			Integer aUtsDot3Onu2VoipH248RegisterMode) {
		getProperty(utsDot3Onu2VoipH248RegisterMode).setValue(
				aUtsDot3Onu2VoipH248RegisterMode);
	}

	public String getUtsDot3Onu2VoipH248Mid() {
		return (String) getProperty(utsDot3Onu2VoipH248Mid).getValue();
	}

	public void setUtsDot3Onu2VoipH248Mid(String aUtsDot3Onu2VoipH248Mid) {
		getProperty(utsDot3Onu2VoipH248Mid).setValue(aUtsDot3Onu2VoipH248Mid);
	}

	public Integer getUtsDot3Onu2VoipH248HeartbeatMode() {
		return (Integer) getProperty(utsDot3Onu2VoipH248HeartbeatMode)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248HeartbeatMode(
			Integer aUtsDot3Onu2VoipH248HeartbeatMode) {
		getProperty(utsDot3Onu2VoipH248HeartbeatMode).setValue(
				aUtsDot3Onu2VoipH248HeartbeatMode);
	}

	public Integer getUtsDot3Onu2VoipH248HeartbeatCycle() {
		return (Integer) getProperty(utsDot3Onu2VoipH248HeartbeatCycle)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248HeartbeatCycle(
			Integer aUtsDot3Onu2VoipH248HeartbeatCycle) {
		getProperty(utsDot3Onu2VoipH248HeartbeatCycle).setValue(
				aUtsDot3Onu2VoipH248HeartbeatCycle);
	}

	public Integer getUtsDot3Onu2VoipH248HeartbeatCount() {
		return (Integer) getProperty(utsDot3Onu2VoipH248HeartbeatCount)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248HeartbeatCount(
			Integer aUtsDot3Onu2VoipH248HeartbeatCount) {
		getProperty(utsDot3Onu2VoipH248HeartbeatCount).setValue(
				aUtsDot3Onu2VoipH248HeartbeatCount);
	}

	public Integer getUtsDot3Onu2VoipH248RtpTidNum() {
		return (Integer) getProperty(utsDot3Onu2VoipH248RtpTidNum).getValue();
	}

	public void setUtsDot3Onu2VoipH248RtpTidNum(
			Integer aUtsDot3Onu2VoipH248RtpTidNum) {
		getProperty(utsDot3Onu2VoipH248RtpTidNum).setValue(
				aUtsDot3Onu2VoipH248RtpTidNum);
	}

	public String getUtsDot3Onu2VoipH248RtpTidPrefix() {
		return (String) getProperty(utsDot3Onu2VoipH248RtpTidPrefix).getValue();
	}

	public void setUtsDot3Onu2VoipH248RtpTidPrefix(
			String aUtsDot3Onu2VoipH248RtpTidPrefix) {
		getProperty(utsDot3Onu2VoipH248RtpTidPrefix).setValue(
				aUtsDot3Onu2VoipH248RtpTidPrefix);
	}

	public Integer getUtsDot3Onu2VoipH248RtpTidDigitBegin() {
		return (Integer) getProperty(utsDot3Onu2VoipH248RtpTidDigitBegin)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248RtpTidDigitBegin(
			Integer aUtsDot3Onu2VoipH248RtpTidDigitBegin) {
		getProperty(utsDot3Onu2VoipH248RtpTidDigitBegin).setValue(
				aUtsDot3Onu2VoipH248RtpTidDigitBegin);
	}

	public Integer getUtsDot3Onu2VoipH248RtpTidMode() {
		return (Integer) getProperty(utsDot3Onu2VoipH248RtpTidMode).getValue();
	}

	public void setUtsDot3Onu2VoipH248RtpTidMode(
			Integer aUtsDot3Onu2VoipH248RtpTidMode) {
		getProperty(utsDot3Onu2VoipH248RtpTidMode).setValue(
				aUtsDot3Onu2VoipH248RtpTidMode);
	}

	public Integer getUtsDot3Onu2VoipH248RtpTidDigitLen() {
		return (Integer) getProperty(utsDot3Onu2VoipH248RtpTidDigitLen)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248RtpTidDigitLen(
			Integer aUtsDot3Onu2VoipH248RtpTidDigitLen) {
		getProperty(utsDot3Onu2VoipH248RtpTidDigitLen).setValue(
				aUtsDot3Onu2VoipH248RtpTidDigitLen);
	}

	public String getUtsDot3Onu2VoipH248FirstRtpTidName() {
		return (String) getProperty(utsDot3Onu2VoipH248FirstRtpTidName)
				.getValue();
	}

	public void setUtsDot3Onu2VoipH248FirstRtpTidName(
			String aUtsDot3Onu2VoipH248FirstRtpTidName) {
		getProperty(utsDot3Onu2VoipH248FirstRtpTidName).setValue(
				aUtsDot3Onu2VoipH248FirstRtpTidName);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipH248MgPort));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248PrimaryMgcIp));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248PrimaryMgcPort));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248BackupMgcIp));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248BackupMgcPort));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248ActiveMgc));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RegisterMode));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248Mid));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248HeartbeatMode));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248HeartbeatCycle));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248HeartbeatCount));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidNum));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidPrefix));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidDigitBegin));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidMode));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidDigitLen));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248FirstRtpTidName));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipH248MgPort));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248PrimaryMgcIp));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248PrimaryMgcPort));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248BackupMgcIp));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248BackupMgcPort));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248ActiveMgc));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RegisterMode));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248Mid));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248HeartbeatMode));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248HeartbeatCycle));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248HeartbeatCount));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidNum));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidPrefix));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidDigitBegin));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidMode));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248RtpTidDigitLen));
		prepareRead(super.getProperty(utsDot3Onu2VoipH248FirstRtpTidName));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2VoipH248MgPort));
		prepareSave(getProperty(utsDot3Onu2VoipH248PrimaryMgcIp));
		prepareSave(getProperty(utsDot3Onu2VoipH248PrimaryMgcPort));
		prepareSave(getProperty(utsDot3Onu2VoipH248BackupMgcIp));
		prepareSave(getProperty(utsDot3Onu2VoipH248BackupMgcPort));
		prepareSave(getProperty(utsDot3Onu2VoipH248RegisterMode));
		prepareSave(getProperty(utsDot3Onu2VoipH248Mid));
		prepareSave(getProperty(utsDot3Onu2VoipH248HeartbeatMode));
		prepareSave(getProperty(utsDot3Onu2VoipH248HeartbeatCycle));
		prepareSave(getProperty(utsDot3Onu2VoipH248HeartbeatCount));
		prepareSave(getProperty(utsDot3Onu2VoipH248RtpTidNum));
		prepareSave(getProperty(utsDot3Onu2VoipH248RtpTidPrefix));
		prepareSave(getProperty(utsDot3Onu2VoipH248RtpTidDigitBegin));
		prepareSave(getProperty(utsDot3Onu2VoipH248RtpTidMode));
		prepareSave(getProperty(utsDot3Onu2VoipH248RtpTidDigitLen));
//		prepareSave(getProperty(utsDot3Onu2VoipH248FirstRtpTidName));

		return save();
	}

}

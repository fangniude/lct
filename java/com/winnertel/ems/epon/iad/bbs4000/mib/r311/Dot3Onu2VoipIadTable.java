package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2VoipIadTable class. Created by QuickDVM
 */
public class Dot3Onu2VoipIadTable extends SnmpMibBean {
	public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
	public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
	public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
	public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";
	public static final String utsDot3Onu2CtcIadInfoMacAddr = "utsDot3Onu2CtcIadInfoMacAddr";
	public static final String utsDot3Onu2CtcIadInfoSupportedProtocol = "utsDot3Onu2CtcIadInfoSupportedProtocol";
	public static final String utsDot3Onu2CtcIadInfoSoftwareVer = "utsDot3Onu2CtcIadInfoSoftwareVer";
	public static final String utsDot3Onu2CtcIadInfoSoftwareDate = "utsDot3Onu2CtcIadInfoSoftwareDate";
	public static final String utsDot3Onu2CtcIadInfoVoipUserCount = "utsDot3Onu2CtcIadInfoVoipUserCount";
	public static final String utsDot3Onu2CtcH248IadOperationStaus = "utsDot3Onu2CtcH248IadOperationStaus";
	public static final String utsDot3Onu2CtcIadOperation = "utsDot3Onu2CtcIadOperation";
	public static final String utsDot3Onu2CtcConfiguredVoipProtocol = "utsDot3Onu2CtcConfiguredVoipProtocol";

	public Dot3Onu2VoipIadTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesLogicalPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcIadInfoMacAddr,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoMacAddr,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.101",
						ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3Onu2CtcIadInfoSupportedProtocol,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoSupportedProtocol,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.102",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcIadInfoSoftwareVer,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoSoftwareVer,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.103",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2CtcIadInfoSoftwareDate,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadInfoSoftwareDate,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.104",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2CtcIadInfoVoipUserCount, new SnmpMibBeanProperty(
				utsDot3Onu2CtcIadInfoVoipUserCount,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.105",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcH248IadOperationStaus, new SnmpMibBeanProperty(
				utsDot3Onu2CtcH248IadOperationStaus,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.331",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcIadOperation, new SnmpMibBeanProperty(
				utsDot3Onu2CtcIadOperation,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.332",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcConfiguredVoipProtocol,
				new SnmpMibBeanProperty(utsDot3Onu2CtcConfiguredVoipProtocol,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.401",
						ISnmpConstant.INTEGER));

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

	public byte[] getUtsDot3Onu2CtcIadInfoMacAddr() {
		return (byte[]) getProperty(utsDot3Onu2CtcIadInfoMacAddr).getValue();
	}

	public void setUtsDot3Onu2CtcIadInfoMacAddr(byte[] aUtsDot3Onu2CtcIadInfoMacAddr) {
		getProperty(utsDot3Onu2CtcIadInfoMacAddr).setValue(aUtsDot3Onu2CtcIadInfoMacAddr);
	}

	public Integer getUtsDot3Onu2CtcIadInfoSupportedProtocol() {
		return (Integer) getProperty(utsDot3Onu2CtcIadInfoSupportedProtocol)
				.getValue();
	}

	public void setUtsDot3Onu2CtcIadInfoSupportedProtocol(
			Integer aUtsDot3Onu2CtcIadInfoSupportedProtocol) {
		getProperty(utsDot3Onu2CtcIadInfoSupportedProtocol).setValue(
				aUtsDot3Onu2CtcIadInfoSupportedProtocol);
	}

	public String getUtsDot3Onu2CtcIadInfoSoftwareVer() {
		return (String) getProperty(utsDot3Onu2CtcIadInfoSoftwareVer).getValue();
	}

	public void setUtsDot3Onu2CtcIadInfoSoftwareVer(String aUtsDot3Onu2CtcIadInfoSoftwareVer) {
		getProperty(utsDot3Onu2CtcIadInfoSoftwareVer).setValue(
				aUtsDot3Onu2CtcIadInfoSoftwareVer);
	}

	public String getUtsDot3Onu2CtcIadInfoSoftwareDate() {
		return (String) getProperty(utsDot3Onu2CtcIadInfoSoftwareDate).getValue();
	}

	public void setUtsDot3Onu2CtcIadInfoSoftwareDate(String aUtsDot3Onu2CtcIadInfoSoftwareDate) {
		getProperty(utsDot3Onu2CtcIadInfoSoftwareDate).setValue(
				aUtsDot3Onu2CtcIadInfoSoftwareDate);
	}

	public Integer getUtsDot3Onu2CtcIadInfoVoipUserCount() {
		return (Integer) getProperty(utsDot3Onu2CtcIadInfoVoipUserCount).getValue();
	}

	public void setUtsDot3Onu2CtcIadInfoVoipUserCount(Integer aUtsDot3Onu2CtcIadInfoVoipUserCount) {
		getProperty(utsDot3Onu2CtcIadInfoVoipUserCount).setValue(
				aUtsDot3Onu2CtcIadInfoVoipUserCount);
	}

	public Integer getUtsDot3Onu2CtcH248IadOperationStaus() {
		return (Integer) getProperty(utsDot3Onu2CtcH248IadOperationStaus).getValue();
	}

	public void setUtsDot3Onu2CtcH248IadOperationStaus(
			Integer aUtsDot3Onu2CtcH248IadOperationStaus) {
		getProperty(utsDot3Onu2CtcH248IadOperationStaus).setValue(
				aUtsDot3Onu2CtcH248IadOperationStaus);
	}

	public Integer getUtsDot3Onu2CtcIadOperation() {
		return (Integer) getProperty(utsDot3Onu2CtcIadOperation).getValue();
	}

	public void setUtsDot3Onu2CtcIadOperation(
			Integer aUtsDot3Onu2CtcIadOperation) {
		getProperty(utsDot3Onu2CtcIadOperation).setValue(
				aUtsDot3Onu2CtcIadOperation);
	}

	public Integer getUtsDot3Onu2CtcConfiguredVoipProtocol() {
		return (Integer) getProperty(utsDot3Onu2CtcConfiguredVoipProtocol)
				.getValue();
	}

	public void setUtsDot3Onu2CtcConfiguredVoipProtocol(
			Integer aUtsDot3Onu2CtcConfiguredVoipProtocol) {
		getProperty(utsDot3Onu2CtcConfiguredVoipProtocol).setValue(
				aUtsDot3Onu2CtcConfiguredVoipProtocol);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoMacAddr));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoSupportedProtocol));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoSoftwareVer));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoSoftwareDate));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoVoipUserCount));
		prepareRead(super.getProperty(utsDot3Onu2CtcH248IadOperationStaus));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadOperation));
		prepareRead(super.getProperty(utsDot3Onu2CtcConfiguredVoipProtocol));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoMacAddr));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoSupportedProtocol));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoSoftwareVer));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoSoftwareDate));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadInfoVoipUserCount));
		prepareRead(super.getProperty(utsDot3Onu2CtcH248IadOperationStaus));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadOperation));
		prepareRead(super.getProperty(utsDot3Onu2CtcConfiguredVoipProtocol));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2CtcIadOperation));
		prepareSave(getProperty(utsDot3Onu2CtcConfiguredVoipProtocol));

		return save();
	}

}

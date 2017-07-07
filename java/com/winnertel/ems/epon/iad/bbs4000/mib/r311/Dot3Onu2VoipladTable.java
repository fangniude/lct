package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2VoipladTable extends SnmpMibBean {
	public static final String utsDot3Onu2VoipModuleId = "utsDot3Onu2VoipModuleId";
	public static final String utsDot3Onu2VoipDeviceId = "utsDot3Onu2VoipDeviceId";
	public static final String utsDot3Onu2VoipPortId = "utsDot3Onu2VoipPortId";
	public static final String utsDot3Onu2VoipLogicalPortId = "utsDot3Onu2VoipLogicalPortId";
	public static final String utsDot3Onu2VoipIadMac = "utsDot3Onu2VoipIadMac";
	public static final String utsDot3Onu2VoipIadCurrentProtocol = "utsDot3Onu2VoipIadCurrentProtocol";
	public static final String utsDot3Onu2VoipIadSwVerion = "utsDot3Onu2VoipIadSwVerion";
	public static final String utsDot3Onu2VoipIadSwDate = "utsDot3Onu2VoipIadSwDate";
	public static final String utsDot3Onu2VoipIadPortNum = "utsDot3Onu2VoipIadPortNum";
	public static final String utsDot3Onu2VoipIadOperStatus = "utsDot3Onu2VoipIadOperStatus";
	public static final String utsDot3Onu2VoipIadOperation = "utsDot3Onu2VoipIadOperation";
	public static final String utsDot3Onu2VoipIadConfiguredProtocol = "utsDot3Onu2VoipIadConfiguredProtocol";

	public Dot3Onu2VoipladTable(ISnmpProxy aSnmpProxy) {
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
		initProperty(utsDot3Onu2VoipIadMac,
				new SnmpMibBeanProperty(utsDot3Onu2VoipIadMac,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.5",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2VoipIadCurrentProtocol,
				new SnmpMibBeanProperty(utsDot3Onu2VoipIadCurrentProtocol,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipIadSwVerion,
				new SnmpMibBeanProperty(utsDot3Onu2VoipIadSwVerion,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.7",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2VoipIadSwDate,
				new SnmpMibBeanProperty(utsDot3Onu2VoipIadSwDate,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.8",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2VoipIadPortNum, new SnmpMibBeanProperty(
				utsDot3Onu2VoipIadPortNum,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipIadOperStatus, new SnmpMibBeanProperty(
				utsDot3Onu2VoipIadOperStatus,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipIadOperation, new SnmpMibBeanProperty(
				utsDot3Onu2VoipIadOperation,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipIadConfiguredProtocol,
				new SnmpMibBeanProperty(utsDot3Onu2VoipIadConfiguredProtocol,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.12",
						ISnmpConstant.INTEGER));

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

	public String getUtsDot3Onu2VoipIadMac() {
		return (String) getProperty(utsDot3Onu2VoipIadMac).getValue();
	}

	public void setUtsDot3Onu2VoipIadMac(String aUtsDot3Onu2VoipIadMac) {
		getProperty(utsDot3Onu2VoipIadMac).setValue(aUtsDot3Onu2VoipIadMac);
	}

	public Integer getUtsDot3Onu2VoipIadCurrentProtocol() {
		return (Integer) getProperty(utsDot3Onu2VoipIadCurrentProtocol)
				.getValue();
	}

	public void setUtsDot3Onu2VoipIadCurrentProtocol(
			Integer aUtsDot3Onu2VoipIadCurrentProtocol) {
		getProperty(utsDot3Onu2VoipIadCurrentProtocol).setValue(
				aUtsDot3Onu2VoipIadCurrentProtocol);
	}

	public String getUtsDot3Onu2VoipIadSwVerion() {
		return (String) getProperty(utsDot3Onu2VoipIadSwVerion).getValue();
	}

	public void setUtsDot3Onu2VoipIadSwVerion(String aUtsDot3Onu2VoipIadSwVerion) {
		getProperty(utsDot3Onu2VoipIadSwVerion).setValue(
				aUtsDot3Onu2VoipIadSwVerion);
	}

	public String getUtsDot3Onu2VoipIadSwDate() {
		return (String) getProperty(utsDot3Onu2VoipIadSwDate).getValue();
	}

	public void setUtsDot3Onu2VoipIadSwDate(String aUtsDot3Onu2VoipIadSwDate) {
		getProperty(utsDot3Onu2VoipIadSwDate).setValue(
				aUtsDot3Onu2VoipIadSwDate);
	}

	public Integer getUtsDot3Onu2VoipIadPortNum() {
		return (Integer) getProperty(utsDot3Onu2VoipIadPortNum).getValue();
	}

	public void setUtsDot3Onu2VoipIadPortNum(Integer aUtsDot3Onu2VoipIadPortNum) {
		getProperty(utsDot3Onu2VoipIadPortNum).setValue(
				aUtsDot3Onu2VoipIadPortNum);
	}

	public Integer getUtsDot3Onu2VoipIadOperStatus() {
		return (Integer) getProperty(utsDot3Onu2VoipIadOperStatus).getValue();
	}

	public void setUtsDot3Onu2VoipIadOperStatus(
			Integer aUtsDot3Onu2VoipIadOperStatus) {
		getProperty(utsDot3Onu2VoipIadOperStatus).setValue(
				aUtsDot3Onu2VoipIadOperStatus);
	}

	public Integer getUtsDot3Onu2VoipIadOperation() {
		return (Integer) getProperty(utsDot3Onu2VoipIadOperation).getValue();
	}

	public void setUtsDot3Onu2VoipIadOperation(
			Integer aUtsDot3Onu2VoipIadOperation) {
		getProperty(utsDot3Onu2VoipIadOperation).setValue(
				aUtsDot3Onu2VoipIadOperation);
	}

	public Integer getUtsDot3Onu2VoipIadConfiguredProtocol() {
		return (Integer) getProperty(utsDot3Onu2VoipIadConfiguredProtocol)
				.getValue();
	}

	public void setUtsDot3Onu2VoipIadConfiguredProtocol(
			Integer aUtsDot3Onu2VoipIadConfiguredProtocol) {
		getProperty(utsDot3Onu2VoipIadConfiguredProtocol).setValue(
				aUtsDot3Onu2VoipIadConfiguredProtocol);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipIadMac));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadCurrentProtocol));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadSwVerion));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadSwDate));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadPortNum));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadOperStatus));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadOperation));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadConfiguredProtocol));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipIadMac));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadCurrentProtocol));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadSwVerion));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadSwDate));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadPortNum));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadOperStatus));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadOperation));
		prepareRead(super.getProperty(utsDot3Onu2VoipIadConfiguredProtocol));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2VoipIadOperation));
		prepareSave(getProperty(utsDot3Onu2VoipIadConfiguredProtocol));

		return save();
	}

}
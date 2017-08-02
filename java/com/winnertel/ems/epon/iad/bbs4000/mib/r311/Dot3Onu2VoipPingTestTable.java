package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2VoipPingTestTable class. Created by QuickDVM
 */
public class Dot3Onu2VoipPingTestTable extends SnmpMibBean {
	public static final String utsDot3Onu2VoipModuleId = "utsDot3Onu2VoipModuleId";
	public static final String utsDot3Onu2VoipDeviceId = "utsDot3Onu2VoipDeviceId";
	public static final String utsDot3Onu2VoipPortId = "utsDot3Onu2VoipPortId";
	public static final String utsDot3Onu2VoipLogicalPortId = "utsDot3Onu2VoipLogicalPortId";
	public static final String utsDot3Onu2VoipPingTestDestIp = "utsDot3Onu2VoipPingTestDestIp";
	public static final String utsDot3Onu2VoipPingTestAction = "utsDot3Onu2VoipPingTestAction";
	public static final String utsDot3Onu2VoipPingTestTimes = "utsDot3Onu2VoipPingTestTimes";
	public static final String utsDot3Onu2VoipPingTestPacketSize = "utsDot3Onu2VoipPingTestPacketSize";
	public static final String utsDot3Onu2VoipPingTestTimeout = "utsDot3Onu2VoipPingTestTimeout";

	public Dot3Onu2VoipPingTestTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2VoipModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.47.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.47.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPortId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.47.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipLogicalPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.47.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingTestDestIp,
				new SnmpMibBeanProperty(utsDot3Onu2VoipPingTestDestIp,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.61.1.1",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2VoipPingTestAction, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingTestAction,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.61.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingTestTimes, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingTestTimes,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.61.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingTestPacketSize,
				new SnmpMibBeanProperty(utsDot3Onu2VoipPingTestPacketSize,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.61.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingTestTimeout, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingTestTimeout,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.61.1.5",
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

	public String getUtsDot3Onu2VoipPingTestDestIp() {
		return (String) getProperty(utsDot3Onu2VoipPingTestDestIp).getValue();
	}

	public void setUtsDot3Onu2VoipPingTestDestIp(
			String aUtsDot3Onu2VoipPingTestDestIp) {
		getProperty(utsDot3Onu2VoipPingTestDestIp).setValue(
				aUtsDot3Onu2VoipPingTestDestIp);
	}

	public Integer getUtsDot3Onu2VoipPingTestAction() {
		return (Integer) getProperty(utsDot3Onu2VoipPingTestAction).getValue();
	}

	public void setUtsDot3Onu2VoipPingTestAction(
			Integer aUtsDot3Onu2VoipPingTestAction) {
		getProperty(utsDot3Onu2VoipPingTestAction).setValue(
				aUtsDot3Onu2VoipPingTestAction);
	}

	public Integer getUtsDot3Onu2VoipPingTestTimes() {
		return (Integer) getProperty(utsDot3Onu2VoipPingTestTimes).getValue();
	}

	public void setUtsDot3Onu2VoipPingTestTimes(
			Integer aUtsDot3Onu2VoipPingTestTimes) {
		getProperty(utsDot3Onu2VoipPingTestTimes).setValue(
				aUtsDot3Onu2VoipPingTestTimes);
	}

	public Integer getUtsDot3Onu2VoipPingTestPacketSize() {
		return (Integer) getProperty(utsDot3Onu2VoipPingTestPacketSize)
				.getValue();
	}

	public void setUtsDot3Onu2VoipPingTestPacketSize(
			Integer aUtsDot3Onu2VoipPingTestPacketSize) {
		getProperty(utsDot3Onu2VoipPingTestPacketSize).setValue(
				aUtsDot3Onu2VoipPingTestPacketSize);
	}

	public Integer getUtsDot3Onu2VoipPingTestTimeout() {
		return (Integer) getProperty(utsDot3Onu2VoipPingTestTimeout).getValue();
	}

	public void setUtsDot3Onu2VoipPingTestTimeout(
			Integer aUtsDot3Onu2VoipPingTestTimeout) {
		getProperty(utsDot3Onu2VoipPingTestTimeout).setValue(
				aUtsDot3Onu2VoipPingTestTimeout);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestDestIp));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestAction));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestTimes));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestPacketSize));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestTimeout));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestDestIp));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestAction));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestTimes));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestPacketSize));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestTimeout));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2VoipPingTestDestIp));
		prepareSave(getProperty(utsDot3Onu2VoipPingTestAction));
		prepareSave(getProperty(utsDot3Onu2VoipPingTestTimes));
		prepareSave(getProperty(utsDot3Onu2VoipPingTestPacketSize));
		prepareSave(getProperty(utsDot3Onu2VoipPingTestTimeout));

		return save();
	}

}
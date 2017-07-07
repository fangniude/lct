package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2VoipTimerTable class. Created by QuickDVM
 */
public class Dot3Onu2VoipTimerTable extends SnmpMibBean {
	public static final String utsDot3Onu2VoipModuleId = "utsDot3Onu2VoipModuleId";
	public static final String utsDot3Onu2VoipDeviceId = "utsDot3Onu2VoipDeviceId";
	public static final String utsDot3Onu2VoipPortId = "utsDot3Onu2VoipPortId";
	public static final String utsDot3Onu2VoipLogicalPortId = "utsDot3Onu2VoipLogicalPortId";
	public static final String utsDot3Onu2VoipLongTimer = "utsDot3Onu2VoipLongTimer";
	public static final String utsDot3Onu2VoipShortTimer = "utsDot3Onu2VoipShortTimer";

	public Dot3Onu2VoipTimerTable(ISnmpProxy aSnmpProxy) {
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
		initProperty(utsDot3Onu2VoipLongTimer, new SnmpMibBeanProperty(
				utsDot3Onu2VoipLongTimer,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.63.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipShortTimer, new SnmpMibBeanProperty(
				utsDot3Onu2VoipShortTimer,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.63.1.2",
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

	public Integer getUtsDot3Onu2VoipLongTimer() {
		return (Integer) getProperty(utsDot3Onu2VoipLongTimer).getValue();
	}

	public void setUtsDot3Onu2VoipLongTimer(Integer aUtsDot3Onu2VoipLongTimer) {
		getProperty(utsDot3Onu2VoipLongTimer).setValue(
				aUtsDot3Onu2VoipLongTimer);
	}

	public Integer getUtsDot3Onu2VoipShortTimer() {
		return (Integer) getProperty(utsDot3Onu2VoipShortTimer).getValue();
	}

	public void setUtsDot3Onu2VoipShortTimer(Integer aUtsDot3Onu2VoipShortTimer) {
		getProperty(utsDot3Onu2VoipShortTimer).setValue(
				aUtsDot3Onu2VoipShortTimer);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipLongTimer));
		prepareRead(super.getProperty(utsDot3Onu2VoipShortTimer));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipLongTimer));
		prepareRead(super.getProperty(utsDot3Onu2VoipShortTimer));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2VoipLongTimer));
		prepareSave(getProperty(utsDot3Onu2VoipShortTimer));

		return save();
	}

}

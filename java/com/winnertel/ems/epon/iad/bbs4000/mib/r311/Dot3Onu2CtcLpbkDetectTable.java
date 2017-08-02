package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2CtcLpbkDetectTable class. Created by QuickDVM
 */
public class Dot3Onu2CtcLpbkDetectTable extends SnmpMibBean {
	public static final String utsDot3Onu2CtcLpbkDetectModuleId = "utsDot3Onu2CtcLpbkDetectModuleId";
	public static final String utsDot3Onu2CtcLpbkDetectDeviceId = "utsDot3Onu2CtcLpbkDetectDeviceId";
	public static final String utsDot3Onu2CtcLpbkDetectPortId = "utsDot3Onu2CtcLpbkDetectPortId";
	public static final String utsDot3Onu2CtcLpbkDetectLogicalPortId = "utsDot3Onu2CtcLpbkDetectLogicalPortId";
	public static final String utsDot3Onu2CtcLpbkDetectUniPort = "utsDot3Onu2CtcLpbkDetectUniPort";
	public static final String utsDot3Onu2CtcLpbkDetectAction = "utsDot3Onu2CtcLpbkDetectAction";

	public Dot3Onu2CtcLpbkDetectTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2CtcLpbkDetectModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcLpbkDetectModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.35.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcLpbkDetectDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcLpbkDetectDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.35.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcLpbkDetectPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcLpbkDetectPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.35.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcLpbkDetectLogicalPortId,
				new SnmpMibBeanProperty(utsDot3Onu2CtcLpbkDetectLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.35.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcLpbkDetectUniPort, new SnmpMibBeanProperty(
				utsDot3Onu2CtcLpbkDetectUniPort,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.35.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcLpbkDetectAction, new SnmpMibBeanProperty(
				utsDot3Onu2CtcLpbkDetectAction,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.35.1.6",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2CtcLpbkDetectModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2CtcLpbkDetectModuleId(
			Integer aUtsDot3Onu2CtcLpbkDetectModuleId) {
		setIndex(0, aUtsDot3Onu2CtcLpbkDetectModuleId);
	}

	public Integer getUtsDot3Onu2CtcLpbkDetectDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2CtcLpbkDetectDeviceId(
			Integer aUtsDot3Onu2CtcLpbkDetectDeviceId) {
		setIndex(1, aUtsDot3Onu2CtcLpbkDetectDeviceId);
	}

	public Integer getUtsDot3Onu2CtcLpbkDetectPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2CtcLpbkDetectPortId(
			Integer aUtsDot3Onu2CtcLpbkDetectPortId) {
		setIndex(2, aUtsDot3Onu2CtcLpbkDetectPortId);
	}

	public Integer getUtsDot3Onu2CtcLpbkDetectLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2CtcLpbkDetectLogicalPortId(
			Integer aUtsDot3Onu2CtcLpbkDetectLogicalPortId) {
		setIndex(3, aUtsDot3Onu2CtcLpbkDetectLogicalPortId);
	}

	public Integer getUtsDot3Onu2CtcLpbkDetectUniPort() {
		return (Integer) getIndex(4);
	}

	public void setUtsDot3Onu2CtcLpbkDetectUniPort(
			Integer aUtsDot3Onu2CtcLpbkDetectUniPort) {
		setIndex(4, aUtsDot3Onu2CtcLpbkDetectUniPort);
	}

	public Integer getUtsDot3Onu2CtcLpbkDetectAction() {
		return (Integer) getProperty(utsDot3Onu2CtcLpbkDetectAction).getValue();
	}

	public void setUtsDot3Onu2CtcLpbkDetectAction(
			Integer aUtsDot3Onu2CtcLpbkDetectAction) {
		getProperty(utsDot3Onu2CtcLpbkDetectAction).setValue(
				aUtsDot3Onu2CtcLpbkDetectAction);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcLpbkDetectAction));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcLpbkDetectAction));

		return loadAll(new int[] { 1, 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2CtcLpbkDetectAction));

		return save();
	}

}

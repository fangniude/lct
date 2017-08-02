package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2UniDynamicMacFlushTable class. Created by QuickDVM
 */
public class Dot3Onu2UniDynamicMacFlushTable extends SnmpMibBean {
	public static final String utsDot3Onu2MacAgingTimeModuleId = "utsDot3Onu2MacAgingTimeModuleId";
	public static final String utsDot3Onu2MacAgingTimeDeviceId = "utsDot3Onu2MacAgingTimeDeviceId";
	public static final String utsDot3Onu2MacAgingTimePortId = "utsDot3Onu2MacAgingTimePortId";
	public static final String utsDot3Onu2MacAgingTimeLogicalPortId = "utsDot3Onu2MacAgingTimeLogicalPortId";
	public static final String utsDot3Onu2UniDynamicMacFlushPort = "utsDot3Onu2UniDynamicMacFlushPort";

	public Dot3Onu2UniDynamicMacFlushTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2MacAgingTimeModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimeModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.55.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimeDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimeDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.55.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimePortId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimePortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.55.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimeLogicalPortId,
				new SnmpMibBeanProperty(utsDot3Onu2MacAgingTimeLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.55.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2UniDynamicMacFlushPort,
				new SnmpMibBeanProperty(utsDot3Onu2UniDynamicMacFlushPort,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.104.1.1",
						ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2MacAgingTimeModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2MacAgingTimeModuleId(
			Integer aUtsDot3Onu2MacAgingTimeModuleId) {
		setIndex(0, aUtsDot3Onu2MacAgingTimeModuleId);
	}

	public Integer getUtsDot3Onu2MacAgingTimeDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2MacAgingTimeDeviceId(
			Integer aUtsDot3Onu2MacAgingTimeDeviceId) {
		setIndex(1, aUtsDot3Onu2MacAgingTimeDeviceId);
	}

	public Integer getUtsDot3Onu2MacAgingTimePortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2MacAgingTimePortId(
			Integer aUtsDot3Onu2MacAgingTimePortId) {
		setIndex(2, aUtsDot3Onu2MacAgingTimePortId);
	}

	public Integer getUtsDot3Onu2MacAgingTimeLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2MacAgingTimeLogicalPortId(
			Integer aUtsDot3Onu2MacAgingTimeLogicalPortId) {
		setIndex(3, aUtsDot3Onu2MacAgingTimeLogicalPortId);
	}

	public Integer getUtsDot3Onu2UniDynamicMacFlushPort() {
		return (Integer) getProperty(utsDot3Onu2UniDynamicMacFlushPort)
				.getValue();
	}

	public void setUtsDot3Onu2UniDynamicMacFlushPort(
			Integer aUtsDot3Onu2UniDynamicMacFlushPort) {
		getProperty(utsDot3Onu2UniDynamicMacFlushPort).setValue(
				aUtsDot3Onu2UniDynamicMacFlushPort);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2UniDynamicMacFlushPort));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2UniDynamicMacFlushPort));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}
	
	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2UniDynamicMacFlushPort));

		return save();
	}

}

package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2OperationTable class. Created by QuickDVM
 */
public class Dot3Onu2OperationTable extends SnmpMibBean {
	public static final String utsDot3Onu2MacAgingTimeModuleId = "utsDot3Onu2MacAgingTimeModuleId";
	public static final String utsDot3Onu2MacAgingTimeDeviceId = "utsDot3Onu2MacAgingTimeDeviceId";
	public static final String utsDot3Onu2MacAgingTimePortId = "utsDot3Onu2MacAgingTimePortId";
	public static final String utsDot3Onu2MacAgingTimeLogicalPortId = "utsDot3Onu2MacAgingTimeLogicalPortId";
	public static final String utsDot3Onu2ConfigActions = "utsDot3Onu2ConfigActions";
	public static final String utsDot3Onu2PowerControlActions = "utsDot3Onu2PowerControlActions";
	public static final String utsDot3Onu2PowerControlMode = "utsDot3Onu2PowerControlMode";
	public static final String utsDot3Onu2PowerControlOnuId = "utsDot3Onu2PowerControlOnuId";
	public static final String utsDot3Onu2PowerControlTxId = "utsDot3Onu2PowerControlTxId";

	public Dot3Onu2OperationTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2MacAgingTimeModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimeModuleId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.55.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimeDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimeDeviceId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.55.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimePortId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimePortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.55.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimeLogicalPortId,
				new SnmpMibBeanProperty(utsDot3Onu2MacAgingTimeLogicalPortId,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.55.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2ConfigActions, new SnmpMibBeanProperty(
				utsDot3Onu2ConfigActions,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.60.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PowerControlActions, new SnmpMibBeanProperty(
				utsDot3Onu2PowerControlActions,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.60.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PowerControlMode, new SnmpMibBeanProperty(
				utsDot3Onu2PowerControlMode,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.60.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PowerControlOnuId,
				new SnmpMibBeanProperty(utsDot3Onu2PowerControlOnuId,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.60.1.4",
						ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3Onu2PowerControlTxId, new SnmpMibBeanProperty(
				utsDot3Onu2PowerControlTxId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.60.1.5",
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

	public Integer getUtsDot3Onu2ConfigActions() {
		return (Integer) getProperty(utsDot3Onu2ConfigActions).getValue();
	}

	public void setUtsDot3Onu2ConfigActions(Integer aUtsDot3Onu2ConfigActions) {
		getProperty(utsDot3Onu2ConfigActions).setValue(
				aUtsDot3Onu2ConfigActions);
	}

	public Integer getUtsDot3Onu2PowerControlActions() {
		return (Integer) getProperty(utsDot3Onu2PowerControlActions).getValue();
	}

	public void setUtsDot3Onu2PowerControlActions(
			Integer aUtsDot3Onu2PowerControlActions) {
		getProperty(utsDot3Onu2PowerControlActions).setValue(
				aUtsDot3Onu2PowerControlActions);
	}

	public Integer getUtsDot3Onu2PowerControlMode() {
		return (Integer) getProperty(utsDot3Onu2PowerControlMode).getValue();
	}

	public void setUtsDot3Onu2PowerControlMode(
			Integer aUtsDot3Onu2PowerControlMode) {
		getProperty(utsDot3Onu2PowerControlMode).setValue(
				aUtsDot3Onu2PowerControlMode);
	}

	public byte[] getUtsDot3Onu2PowerControlOnuId() {
		return (byte[]) getProperty(utsDot3Onu2PowerControlOnuId).getValue();
	}

	public void setUtsDot3Onu2PowerControlOnuId(
			byte[] aUtsDot3Onu2PowerControlOnuId) {
		getProperty(utsDot3Onu2PowerControlOnuId).setValue(
				aUtsDot3Onu2PowerControlOnuId);
	}

	public Integer getUtsDot3Onu2PowerControlTxId() {
		return (Integer) getProperty(utsDot3Onu2PowerControlTxId).getValue();
	}

	public void setUtsDot3Onu2PowerControlTxId(
			Integer aUtsDot3Onu2PowerControlTxId) {
		getProperty(utsDot3Onu2PowerControlTxId).setValue(
				aUtsDot3Onu2PowerControlTxId);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2ConfigActions));
		prepareRead(super.getProperty(utsDot3Onu2PowerControlActions));
		prepareRead(super.getProperty(utsDot3Onu2PowerControlMode));
		prepareRead(super.getProperty(utsDot3Onu2PowerControlOnuId));
		prepareRead(super.getProperty(utsDot3Onu2PowerControlTxId));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2ConfigActions));
		prepareRead(super.getProperty(utsDot3Onu2PowerControlActions));
		prepareRead(super.getProperty(utsDot3Onu2PowerControlMode));
		prepareRead(super.getProperty(utsDot3Onu2PowerControlOnuId));
		prepareRead(super.getProperty(utsDot3Onu2PowerControlTxId));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2ConfigActions));
		prepareSave(getProperty(utsDot3Onu2PowerControlActions));
		prepareSave(getProperty(utsDot3Onu2PowerControlMode));
		if(getUtsDot3Onu2PowerControlOnuId() != null)
			prepareSave(getProperty(utsDot3Onu2PowerControlOnuId));
		prepareSave(getProperty(utsDot3Onu2PowerControlTxId));

		return save();
	}

}

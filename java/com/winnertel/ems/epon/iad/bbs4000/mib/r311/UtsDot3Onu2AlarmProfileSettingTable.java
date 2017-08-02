package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The UtsDot3Onu2AlarmProfileSettingTable class. Created by QuickDVM
 */
public class UtsDot3Onu2AlarmProfileSettingTable extends SnmpMibBean {
	public static final String utsDot3Onu2AlarmProfileIndex = "utsDot3Onu2AlarmProfileIndex";
	public static final String utsDot3Onu2AlarmId = "utsDot3Onu2AlarmId";
	public static final String utsDot3Onu2AlarmInstance = "utsDot3Onu2AlarmInstance";
	public static final String utsDot3Onu2AlarmAdmin = "utsDot3Onu2AlarmAdmin";
	public static final String utsDot3Onu2AlarmRaiseThreshold = "utsDot3Onu2AlarmRaiseThreshold";
	public static final String utsDot3Onu2AlarmClearThreshold = "utsDot3Onu2AlarmClearThreshold";

	public UtsDot3Onu2AlarmProfileSettingTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2AlarmProfileIndex, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmProfileIndex,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.43.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmId, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.44.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmInstance, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmInstance,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.44.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmAdmin, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmAdmin,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.44.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmRaiseThreshold, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmRaiseThreshold,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.44.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmClearThreshold, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmClearThreshold,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.44.1.5",
				ISnmpConstant.INTEGER));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.44.1.100",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2AlarmProfileIndex() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2AlarmProfileIndex(
			Integer aUtsDot3Onu2AlarmProfileIndex) {
		setIndex(0, aUtsDot3Onu2AlarmProfileIndex);
	}

	public Integer getUtsDot3Onu2AlarmId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2AlarmId(Integer aUtsDot3Onu2AlarmId) {
		setIndex(1, aUtsDot3Onu2AlarmId);
	}

	public Integer getUtsDot3Onu2AlarmInstance() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2AlarmInstance(Integer aUtsDot3Onu2AlarmInstance) {
		setIndex(2, aUtsDot3Onu2AlarmInstance);
	}

	public Integer getUtsDot3Onu2AlarmAdmin() {
		return (Integer) getProperty(utsDot3Onu2AlarmAdmin).getValue();
	}

	public void setUtsDot3Onu2AlarmAdmin(Integer aUtsDot3Onu2AlarmAdmin) {
		getProperty(utsDot3Onu2AlarmAdmin).setValue(aUtsDot3Onu2AlarmAdmin);
	}

	public Integer getUtsDot3Onu2AlarmRaiseThreshold() {
		return (Integer) getProperty(utsDot3Onu2AlarmRaiseThreshold).getValue();
	}

	public void setUtsDot3Onu2AlarmRaiseThreshold(
			Integer aUtsDot3Onu2AlarmRaiseThreshold) {
		getProperty(utsDot3Onu2AlarmRaiseThreshold).setValue(
				aUtsDot3Onu2AlarmRaiseThreshold);
	}

	public Integer getUtsDot3Onu2AlarmClearThreshold() {
		return (Integer) getProperty(utsDot3Onu2AlarmClearThreshold).getValue();
	}

	public void setUtsDot3Onu2AlarmClearThreshold(
			Integer aUtsDot3Onu2AlarmClearThreshold) {
		getProperty(utsDot3Onu2AlarmClearThreshold).setValue(
				aUtsDot3Onu2AlarmClearThreshold);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2AlarmAdmin));
		prepareRead(super.getProperty(utsDot3Onu2AlarmRaiseThreshold));
		prepareRead(super.getProperty(utsDot3Onu2AlarmClearThreshold));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2AlarmAdmin));
		prepareRead(super.getProperty(utsDot3Onu2AlarmRaiseThreshold));
		prepareRead(super.getProperty(utsDot3Onu2AlarmClearThreshold));

		return loadAll(new int[] { 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2AlarmAdmin));
		prepareSave(getProperty(utsDot3Onu2AlarmRaiseThreshold));
		prepareSave(getProperty(utsDot3Onu2AlarmClearThreshold));

		return save();
	}

	public boolean add() throws MibBeanException {
		super.setRowStatus(new Integer(4));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException {
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

}

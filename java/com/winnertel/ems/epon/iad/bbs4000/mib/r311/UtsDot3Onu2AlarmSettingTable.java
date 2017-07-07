package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The utsDot3Onu2AlarmSettingTabl class. Created by QuickDVM
 */
public class UtsDot3Onu2AlarmSettingTable extends SnmpMibBean {
	public static final String utsDot3Onu2AlarmSettingModuleId = "utsDot3Onu2AlarmSettingModuleId";
	public static final String utsDot3Onu2AlarmSettingDeviceId = "utsDot3Onu2AlarmSettingDeviceId";
	public static final String utsDot3Onu2AlarmSettingPortId = "utsDot3Onu2AlarmSettingPortId";
	public static final String utsDot3Onu2AlarmSettingLogicalPortId = "utsDot3Onu2AlarmSettingLogicalPortId";
	public static final String utsDot3Onu2AlarmSettingProfileId = "utsDot3Onu2AlarmSettingProfileId";

	public UtsDot3Onu2AlarmSettingTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2AlarmSettingModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmSettingModuleId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.45.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmSettingDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmSettingDeviceId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.45.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmSettingPortId, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmSettingPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.45.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmSettingLogicalPortId,
				new SnmpMibBeanProperty(utsDot3Onu2AlarmSettingLogicalPortId,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.45.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmSettingProfileId, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmSettingProfileId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.45.1.5",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2AlarmSettingModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2AlarmSettingModuleId(
			Integer aUtsDot3Onu2AlarmSettingModuleId) {
		setIndex(0, aUtsDot3Onu2AlarmSettingModuleId);
	}

	public Integer getUtsDot3Onu2AlarmSettingDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2AlarmSettingDeviceId(
			Integer aUtsDot3Onu2AlarmSettingDeviceId) {
		setIndex(1, aUtsDot3Onu2AlarmSettingDeviceId);
	}

	public Integer getUtsDot3Onu2AlarmSettingPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2AlarmSettingPortId(
			Integer aUtsDot3Onu2AlarmSettingPortId) {
		setIndex(2, aUtsDot3Onu2AlarmSettingPortId);
	}

	public Integer getUtsDot3Onu2AlarmSettingLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2AlarmSettingLogicalPortId(
			Integer aUtsDot3Onu2AlarmSettingLogicalPortId) {
		setIndex(3, aUtsDot3Onu2AlarmSettingLogicalPortId);
	}

	public Integer getUtsDot3Onu2AlarmSettingProfileId() {
		return (Integer) getProperty(utsDot3Onu2AlarmSettingProfileId)
				.getValue();
	}

	public void setUtsDot3Onu2AlarmSettingProfileId(
			Integer aUtsDot3Onu2AlarmSettingProfileId) {
		getProperty(utsDot3Onu2AlarmSettingProfileId).setValue(
				aUtsDot3Onu2AlarmSettingProfileId);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2AlarmSettingProfileId));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2AlarmSettingProfileId));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2AlarmSettingProfileId));

		return save();
	}

}

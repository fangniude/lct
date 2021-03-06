package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class MulticastConfigure extends SnmpMibBean {

	public static final String utsDot3Onu2CtcModuleId = "utsDot3Onu2CtcModuleId";
	public static final String utsDot3Onu2CtcDeviceId = "utsDot3Onu2CtcDeviceId";
	public static final String utsDot3Onu2CtcPortId = "utsDot3Onu2CtcPortId";
	public static final String utsDot3Onu2CtcLogicalPortId = "utsDot3Onu2CtcLogicalPortId";

	public static final String utsDot3Onu2CtcMulticastSwitch = "utsDot3Onu2CtcMulticastSwitch";
	public static final String utsDot3Onu2CtcMCastControlType = "utsDot3Onu2CtcMCastControlType";
	public static final String utsDot3Onu2CtcMCastEntryNum = "utsDot3Onu2CtcMCastEntryNum";
	public static final String utsDot3Onu2CtcAdmin = "utsDot3Onu2CtcAdmin";

	public MulticastConfigure(ISnmpProxy arg0) {
		super(arg0);
		init();
	}

	@Override
	protected void init() {
		initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcLogicalPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.4",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3Onu2CtcMulticastSwitch, new SnmpMibBeanProperty(
				utsDot3Onu2CtcMulticastSwitch,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.27",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcMCastControlType, new SnmpMibBeanProperty(
				utsDot3Onu2CtcMCastControlType,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.28",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcMCastEntryNum, new SnmpMibBeanProperty(
				utsDot3Onu2CtcMCastEntryNum,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.29",
				ISnmpConstant.INTEGER));
		
		initProperty(utsDot3Onu2CtcAdmin, new SnmpMibBeanProperty(
				utsDot3Onu2CtcAdmin,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.37",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2CtcModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2CtcModuleId(Integer aUtsDot3Onu2CtcModuleId) {
		setIndex(0, aUtsDot3Onu2CtcModuleId);
	}

	public Integer getUtsDot3Onu2CtcDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2CtcDeviceId(Integer aUtsDot3Onu2CtcDeviceId) {
		setIndex(1, aUtsDot3Onu2CtcDeviceId);
	}

	public Integer getUtsDot3Onu2CtcPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2CtcPortId(Integer aUtsDot3Onu2CtcPortId) {
		setIndex(2, aUtsDot3Onu2CtcPortId);
	}

	public Integer getUtsDot3Onu2CtcLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2CtcLogicalPortId(
			Integer aUtsDot3Onu2CtcLogicalPortId) {
		setIndex(3, aUtsDot3Onu2CtcLogicalPortId);
	}

	public Integer getUtsDot3Onu2CtcMulticastSwitch() {
		return (Integer) getProperty(utsDot3Onu2CtcMulticastSwitch).getValue();
	}

	public void setUtsDot3Onu2CtcMulticastSwitch(
			Integer aUtsDot3Onu2CtcMulticastSwitch) {
		getProperty(utsDot3Onu2CtcMulticastSwitch).setValue(
				aUtsDot3Onu2CtcMulticastSwitch);
	}

	public Integer getUtsDot3Onu2CtcMCastControlType() {
		return (Integer) getProperty(utsDot3Onu2CtcMCastControlType).getValue();
	}

	public void setUtsDot3Onu2CtcMCastControlType(
			Integer aUtsDot3Onu2CtcMCastControlType) {
		getProperty(utsDot3Onu2CtcMCastControlType).setValue(
				aUtsDot3Onu2CtcMCastControlType);
	}

	public Integer getUtsDot3Onu2CtcMCastEntryNum() {
		return (Integer) getProperty(utsDot3Onu2CtcMCastEntryNum).getValue();
	}

	public void setUtsDot3Onu2CtcMCastEntryNum(
			Integer aUtsDot3Onu2CtcMCastEntryNum) {
		getProperty(utsDot3Onu2CtcMCastEntryNum).setValue(
				aUtsDot3Onu2CtcMCastEntryNum);
	}
	
    public Integer getUtsDot3Onu2CtcAdmin() {
        return (Integer) getProperty(utsDot3Onu2CtcAdmin).getValue();
    }

    public void setUtsDot3Onu2CtcAdmin(Integer aUtsDot3Onu2CtcAdmin) {
        getProperty(utsDot3Onu2CtcAdmin).setValue(aUtsDot3Onu2CtcAdmin);
    }

	@Override
	public boolean modify() throws MibBeanException {
	    prepareSave(getProperty(utsDot3Onu2CtcMulticastSwitch));
	    prepareSave(getProperty(utsDot3Onu2CtcMCastControlType));
		return save();
	}

	@Override
	public boolean retrieve() throws MibBeanException {
	    prepareRead(super.getProperty(utsDot3Onu2CtcMulticastSwitch));
	    prepareRead(super.getProperty(utsDot3Onu2CtcMCastControlType));
	    prepareRead(super.getProperty(utsDot3Onu2CtcMCastEntryNum));
	    prepareRead(getProperty(utsDot3Onu2CtcAdmin));
		return load();
	}

	@Override
	public Vector retrieveAll() throws MibBeanException {
	    prepareRead(super.getProperty(utsDot3Onu2CtcMulticastSwitch));
	    prepareRead(super.getProperty(utsDot3Onu2CtcMCastControlType));
	    prepareRead(super.getProperty(utsDot3Onu2CtcMCastEntryNum));
	    prepareRead(getProperty(utsDot3Onu2CtcAdmin));
	    return loadAll(new int[]{1 , 1 , 1 , 1 });
	}
}

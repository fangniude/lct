package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigDecimal;
import java.util.Vector;

public class Dot3Onu2OpticalReceiverTable extends SnmpMibBean {
	public static final String utsDot3OnuOpticalReceiverModuleId = "utsDot3OnuOpticalReceiverModuleId";
	public static final String utsDot3OnuOpticalReceiverDeviceId = "utsDot3OnuOpticalReceiverDeviceId";
	public static final String utsDot3OnuOpticalReceiverPortId = "utsDot3OnuOpticalReceiverPortId";
	public static final String utsDot3OnuOpticalReceiverLogicalPortId = "utsDot3OnuOpticalReceiverLogicalPortId";
	public static final String utsDot3OnuOpticalReceiverInputPower = "utsDot3OnuOpticalReceiverInputPower";
	public static final String utsDot3OnuOpticalReceiverOutputRFVoltage = "utsDot3OnuOpticalReceiverOutputRFVoltage";

	public Dot3Onu2OpticalReceiverTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuOpticalReceiverModuleId,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalReceiverModuleId,
						".1.3.6.1.4.1.45121.1800.2.5.1.4.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalReceiverDeviceId,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalReceiverDeviceId,
						".1.3.6.1.4.1.45121.1800.2.5.1.4.1.2",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalReceiverPortId,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalReceiverPortId,
						".1.3.6.1.4.1.45121.1800.2.5.1.4.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalReceiverLogicalPortId,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalReceiverLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.5.1.4.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalReceiverInputPower,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalReceiverInputPower,
						".1.3.6.1.4.1.45121.1800.2.5.1.4.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalReceiverOutputRFVoltage,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalReceiverOutputRFVoltage,
						".1.3.6.1.4.1.45121.1800.2.5.1.4.1.6",
						ISnmpConstant.INTEGER));
	}

	public Integer getUtsDot3OnuOpticalReceiverModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OnuOpticalReceiverModuleId(
			Integer aUtsDot3OnuOpticalReceiverModuleId) {
		setIndex(0, aUtsDot3OnuOpticalReceiverModuleId);
	}

	public Integer getUtsDot3OnuOpticalReceiverDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OnuOpticalReceiverDeviceId(
			Integer aUtsDot3OnuOpticalReceiverDeviceId) {
		setIndex(1, aUtsDot3OnuOpticalReceiverDeviceId);
	}

	public Integer getUtsDot3OnuOpticalReceiverPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3OnuOpticalReceiverPortId(
			Integer aUtsDot3OnuOpticalReceiverPortId) {
		setIndex(2, aUtsDot3OnuOpticalReceiverPortId);
	}

	public Integer getUtsDot3OnuOpticalReceiverLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3OnuOpticalReceiverLogicalPortId(
			Integer aUtsDot3OnuOpticalReceiverLogicalPortId) {
		setIndex(3, aUtsDot3OnuOpticalReceiverLogicalPortId);
	}

	public Integer getUtsDot3OnuOpticalReceiverInputPower() {
		return (Integer) getProperty(
				utsDot3OnuOpticalReceiverInputPower).getValue();
	}
	
	public double getUtsDot3OnuOpticalReceiverInputPowerDisplay() {
		return (double) getUtsDot3OnuOpticalReceiverInputPower()/1000;
	}

	public void setUtsDot3OnuOpticalReceiverInputPower(
			Integer aUtsDot3OnuOpticalReceiverInputPower) {
		getProperty(utsDot3OnuOpticalReceiverInputPower).setValue(
				aUtsDot3OnuOpticalReceiverInputPower);
	}

	public Integer getUtsDot3OnuOpticalReceiverOutputRFVoltage() {
		return (Integer) getProperty(
				utsDot3OnuOpticalReceiverOutputRFVoltage).getValue();
	}

	public void setUtsDot3OnuOpticalReceiverOutputRFVoltage(
			Integer aUtsDot3OnuOpticalReceiverOutputRFVoltage) {
		getProperty(utsDot3OnuOpticalReceiverOutputRFVoltage).setValue(
				aUtsDot3OnuOpticalReceiverOutputRFVoltage);
	}
	public boolean retrieve() throws MibBeanException {
		prepareRead(getProperty(utsDot3OnuOpticalReceiverInputPower));
		prepareRead(getProperty(utsDot3OnuOpticalReceiverOutputRFVoltage));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {

		prepareRead(getProperty(utsDot3OnuOpticalReceiverInputPower));
		prepareRead(getProperty(utsDot3OnuOpticalReceiverOutputRFVoltage));

		Vector v = loadAll(new int[]{1, 1, 1, 1});

	    return v;
	}

}

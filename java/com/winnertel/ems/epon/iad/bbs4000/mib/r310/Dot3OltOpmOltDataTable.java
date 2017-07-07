package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigDecimal;
import java.util.Vector;

public class Dot3OltOpmOltDataTable extends SnmpMibBean {

	public static final String utsDot3OltOpmOltDataModuleID = "utsDot3OltOpmOltDataModuleID";
	public static final String utsDot3OltOpmOltDataPortId = "utsDot3OltOpmOltDataPortId";
	public static final String utsDot3OltOpmOltDataTemperature = "utsDot3OltOpmOltDataTemperature";
	public static final String utsDot3OltOpmOltDataVoltage = "utsDot3OltOpmOltDataVoltage";
	public static final String utsDot3OltOpmOltDataBiasCurrent = "utsDot3OltOpmOltDataBiasCurrent";
	public static final String utsDot3OltOpmOltDataTxPower = "utsDot3OltOpmOltDataTxPower";
	public static final String utsDot3OltOpmPmSwitch = "utsDot3OltOpmPmSwitch";
	
	public static final String utsDot3OltOpmOltDataTemperatureDisplay = "utsDot3OltOpmOltDataTemperatureDisplay";
	public static final String utsDot3OltOpmOltDataVoltageDisplay = "utsDot3OltOpmOltDataVoltageDisplay";
	public static final String utsDot3OltOpmOltDataBiasCurrentDisplay = "utsDot3OltOpmOltDataBiasCurrentDisplay";
	public static final String utsDot3OltOpmOltDataTxPowerDisplay = "utsDot3OltOpmOltDataTxPowerDisplay";

	public Dot3OltOpmOltDataTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OltOpmOltDataModuleID, new SnmpMibBeanProperty(
				utsDot3OltOpmOltDataModuleID,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.18.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOltDataPortId, new SnmpMibBeanProperty(
				utsDot3OltOpmOltDataPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.18.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOltDataTemperature, new SnmpMibBeanProperty(
				utsDot3OltOpmOltDataTemperature,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.18.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOltDataVoltage, new SnmpMibBeanProperty(
				utsDot3OltOpmOltDataVoltage,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.18.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOltDataBiasCurrent, new SnmpMibBeanProperty(
				utsDot3OltOpmOltDataBiasCurrent,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.18.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOltDataTxPower, new SnmpMibBeanProperty(
				utsDot3OltOpmOltDataTxPower,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.18.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmPmSwitch, new SnmpMibBeanProperty(
				utsDot3OltOpmPmSwitch,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.18.1.100",
				ISnmpConstant.INTEGER));
	}

	public Integer getUtsDot3OltOpmOltDataModuleID() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OltOpmOltDataModuleID(
			Integer aUtsDot3OltOpmOltDataModuleID) {
		setIndex(0, aUtsDot3OltOpmOltDataModuleID);
	}

	public Integer getUtsDot3OltOpmOltDataPortId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OltOpmOltDataPortId(
			Integer aUtsDot3OltOpmOltDataPortId) {
		setIndex(1, aUtsDot3OltOpmOltDataPortId);
	}

	public Integer getUtsDot3OltOpmOltDataTemperature() {
		return (Integer) getProperty(utsDot3OltOpmOltDataTemperature)
				.getValue();
	}

	public void setUtsDot3OltOpmOltDataTemperature(
			Integer aUtsDot3OltOpmOltDataTemperature) {
		getProperty(utsDot3OltOpmOltDataTemperature).setValue(
				aUtsDot3OltOpmOltDataTemperature);
	}
	
	public Double getUtsDot3OltOpmOltDataTemperatureDisplay() {
		Double temp =  ((Integer) getProperty(utsDot3OltOpmOltDataTemperature)
				.getValue() / 256d);
		return (new BigDecimal(temp)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public void setUtsDot3OltOpmOltDataTemperatureDisplay(
			Double aUtsDot3OltOpmOltDataTemperature) {
	}
	

	public Integer getUtsDot3OltOpmOltDataVoltage() {
		return (Integer) getProperty(utsDot3OltOpmOltDataVoltage).getValue() / 1000;
	}

	public void setUtsDot3OltOpmOltDataVoltage(
			Integer aUtsDot3OltOpmOltDataVoltage) {
		getProperty(utsDot3OltOpmOltDataVoltage).setValue(
				aUtsDot3OltOpmOltDataVoltage);
	}
	
	public Double getUtsDot3OltOpmOltDataVoltageDisplay() {
		Double temp =  ((Integer) getProperty(utsDot3OltOpmOltDataVoltage)
				.getValue() / 10000d);
		return (new BigDecimal(temp)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmOltDataVoltageDisplay(
			Double aUtsDot3OltOpmOltDataVoltage) {
	}

	public Integer getUtsDot3OltOpmOltDataBiasCurrent() {
		return (Integer) getProperty(utsDot3OltOpmOltDataBiasCurrent)
				.getValue() / 500;
	}

	public void setUtsDot3OltOpmOltDataBiasCurrent(
			Integer aUtsDot3OltOpmOltDataBiasCurrent) {
		getProperty(utsDot3OltOpmOltDataBiasCurrent).setValue(
				aUtsDot3OltOpmOltDataBiasCurrent);
	}
	
	public Double getUtsDot3OltOpmOltDataBiasCurrentDisplay() {
		Double temp =  ((Integer) getProperty(utsDot3OltOpmOltDataBiasCurrent)
				.getValue() / 500d);
		return (new BigDecimal(temp)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmOltDataBiasCurrentDisplay(
			Double aUtsDot3OltOpmOltDataBiasCurrent) {
	}

	public Integer getUtsDot3OltOpmOltDataTxPower() {
		return (int) java.lang.Math.round(10 * java.lang.Math
				.log10((Integer) getProperty(utsDot3OltOpmOltDataTxPower)
						.getValue() / 10000.0));
	}

	public void setUtsDot3OltOpmOltDataTxPower(
			Integer aUtsDot3OltOpmOltDataTxPower) {
		getProperty(utsDot3OltOpmOltDataTxPower).setValue(aUtsDot3OltOpmOltDataTxPower);
	}
	
	public Double getUtsDot3OltOpmOltDataTxPowerDisplay() {
		Double temp =  10 * java.lang.Math
				.log10((Integer) getProperty(utsDot3OltOpmOltDataTxPower)
						.getValue() / 10000.0);
		if (Double.isInfinite(temp) || Double.isNaN(temp))
			return 0D;
		return (new BigDecimal(temp)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public void setUtsDot3OltOpmOltDataTxPowerDisplay(
			Integer aUtsDot3OltOpmOltDataTxPower) {
		getProperty(utsDot3OltOpmOltDataTxPower).setValue(aUtsDot3OltOpmOltDataTxPower);
	}

	public Integer getUtsDot3OltOpmPmSwitch() {
		return (Integer) getProperty(utsDot3OltOpmPmSwitch).getValue();
	}

	public void setUtsDot3OltOpmPmSwitch(Integer aUtsDot3OltOpmPmSwitch) {
		getProperty(utsDot3OltOpmPmSwitch).setValue(aUtsDot3OltOpmPmSwitch);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(getProperty(utsDot3OltOpmOltDataTemperature));
		prepareRead(getProperty(utsDot3OltOpmOltDataVoltage));
		prepareRead(getProperty(utsDot3OltOpmOltDataBiasCurrent));
		prepareRead(getProperty(utsDot3OltOpmOltDataTxPower));
		prepareRead(getProperty(utsDot3OltOpmPmSwitch));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(getProperty(utsDot3OltOpmOltDataTemperature));
		prepareRead(getProperty(utsDot3OltOpmOltDataVoltage));
		prepareRead(getProperty(utsDot3OltOpmOltDataBiasCurrent));
		prepareRead(getProperty(utsDot3OltOpmOltDataTxPower));		
		prepareRead(getProperty(utsDot3OltOpmPmSwitch));
		return loadAll(new int[]{1, 1});
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3OltOpmPmSwitch));

		return save();
	}

}
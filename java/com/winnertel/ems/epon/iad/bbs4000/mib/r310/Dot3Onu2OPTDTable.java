package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigDecimal;
import java.util.Vector;

public class Dot3Onu2OPTDTable extends SnmpMibBean {
	public static final String utsDot3OnuOpticalTransceiverDiagnosisModuleId = "utsDot3OnuOpticalTransceiverDiagnosisModuleId";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisDeviceId = "utsDot3OnuOpticalTransceiverDiagnosisDeviceId";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisPortId = "utsDot3OnuOpticalTransceiverDiagnosisPortId";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisLogicalPortId = "utsDot3OnuOpticalTransceiverDiagnosisLogicalPortId";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTemperature = "utsDot3OnuOpticalTransceiverDiagnosisTemperature";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisVoltage = "utsDot3OnuOpticalTransceiverDiagnosisVoltage";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent = "utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTxPower = "utsDot3OnuOpticalTransceiverDiagnosisTxPower";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisRxPower = "utsDot3OnuOpticalTransceiverDiagnosisRxPower";
	
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTemperatureDisplay = "utsDot3OnuOpticalTransceiverDiagnosisTemperatureDisplay";
	
	
/**
	public static final String utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation = "utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm = "utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm = "utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning = "utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning = "utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm = "utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm = "utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning = "utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning = "utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm = "utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm = "utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning = "utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning = "utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm = "utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm = "utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning = "utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning";
	public static final String utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning = "utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning";
*/
//	public static final String utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm = "utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm";
//	public static final String utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm = "utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm";
//	public static final String utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning = "utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning";
//	public static final String utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning = "utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning";

	public static final String utsDot3OnuOpticalTransceiverDiagnosisPmSwitch = "utsDot3OnuOpticalTransceiverDiagnosisPmSwitch";
	
	private String onuLabel = null; //added by Zengtian, 2011/9/9

	public Dot3Onu2OPTDTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisModuleId,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisModuleId,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisDeviceId,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisDeviceId,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.2",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisPortId,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisPortId,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisLogicalPortId,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTemperature,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTemperature,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltage,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisVoltage,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.7",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPower,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTxPower,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPower,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisRxPower,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.9",
						ISnmpConstant.INTEGER));
/**
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.12",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.15",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.16",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.17",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.18",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.19",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.20",
						ISnmpConstant.INTEGER));
		initProperty(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.21",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.22",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.23",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.24",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.25",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.26",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.27",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.28",
						ISnmpConstant.INTEGER));
		initProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.29",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.30",
						ISnmpConstant.INTEGER));
*/
//		initProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm,
//				new SnmpMibBeanProperty(
//						utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm,
//						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.31",
//						ISnmpConstant.INTEGER));
//		initProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm,
//				new SnmpMibBeanProperty(
//						utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm,
//						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.32",
//						ISnmpConstant.INTEGER));
//		initProperty(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning,
//				new SnmpMibBeanProperty(
//						utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning,
//						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.33",
//						ISnmpConstant.INTEGER));
//		initProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning,
//				new SnmpMibBeanProperty(
//						utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning,
//						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.34",
//						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOpticalTransceiverDiagnosisPmSwitch,
				new SnmpMibBeanProperty(
						utsDot3OnuOpticalTransceiverDiagnosisPmSwitch,
						".1.3.6.1.4.1.45121.1800.2.5.1.3.1.35",
						ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisModuleId(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisModuleId) {
		setIndex(0, aUtsDot3OnuOpticalTransceiverDiagnosisModuleId);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisDeviceId(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisDeviceId) {
		setIndex(1, aUtsDot3OnuOpticalTransceiverDiagnosisDeviceId);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisPortId(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisPortId) {
		setIndex(2, aUtsDot3OnuOpticalTransceiverDiagnosisPortId);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId) {
		setIndex(3, aUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTemperature() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTemperature).getValue();
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTemperature(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTemperature) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTemperature).setValue(
				aUtsDot3OnuOpticalTransceiverDiagnosisTemperature);
	}
	
	public Double getUtsDot3OnuOpticalTransceiverDiagnosisTemperatureDisplay() {
		Double temp =  ((Integer) getProperty(utsDot3OnuOpticalTransceiverDiagnosisTemperature)
				.getValue() / 256d);
		return (new BigDecimal(temp)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public void setUtsDot3OnuOpticalTransceiverDiagnosisTemperatureDisplay(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTemperature) {
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisVoltage() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisVoltage).getValue();
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisVoltage(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisVoltage) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltage).setValue(
				aUtsDot3OnuOpticalTransceiverDiagnosisVoltage);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent).getValue();
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTxPower() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTxPower).getValue();
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTxPower(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTxPower) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPower).setValue(
				aUtsDot3OnuOpticalTransceiverDiagnosisTxPower);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisRxPower() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisRxPower).getValue();
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisRxPower(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisRxPower) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPower).setValue(
				aUtsDot3OnuOpticalTransceiverDiagnosisRxPower);
	}
/**
	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation).getValue();
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm).getValue() / 256;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm).getValue() / 256;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning)
				.getValue() / 256;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning).getValue() / 256;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm)
				.getValue() / 1000;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm)
				.setValue(
						aUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm)
				.getValue() / 1000;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning)
				.getValue() / 1000;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning)
				.setValue(
						aUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning)
				.getValue() / 1000;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning)
				.setValue(
						aUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm).getValue() / 1000;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm).getValue() / 1000;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning)
				.getValue() / 1000;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning).getValue() / 1000;
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm() {
		return format((Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm)
				.getValue());
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm)
				.setValue(
						aUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm() {
		return format((Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm)
				.getValue());
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm)
				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning() {
		return format((Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning)
				.getValue());
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning)
				.setValue(
						aUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning);
	}

	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning() {
		return format((Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning)
				.getValue());
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning)
				.setValue(
						aUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning);
	}
*/
//	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm() {
//		return format((Integer) getProperty(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm)
//				.getValue());
//	}
//
//	public void setUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm(
//			Integer aUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm) {
//		getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm)
//				.setValue(
//						aUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm);
//	}
//
//	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm() {
//		return format((Integer) getProperty(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm)
//				.getValue());
//	}
//
//	public void setUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm(
//			Integer aUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm) {
//		getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm)
//				.setValue(aUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm);
//	}
//
//	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning() {
//		return format((Integer) getProperty(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning)
//				.getValue());
//	}
//
//	public void setUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning(
//			Integer aUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning) {
//		getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning)
//				.setValue(
//						aUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning);
//	}
//
//	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning() {
//		return format((Integer) getProperty(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning)
//				.getValue());
//	}
//
//	public void setUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning(
//			Integer aUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning) {
//		getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning)
//				.setValue(
//						aUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning);
//	}
	
	public Integer getUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch() {
		return (Integer) getProperty(
				utsDot3OnuOpticalTransceiverDiagnosisPmSwitch).getValue();
	}

	public void setUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch(
			Integer aUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch) {
		getProperty(utsDot3OnuOpticalTransceiverDiagnosisPmSwitch).setValue(
				aUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch);
	}
	
	 //added by Zengtian, 2011/9/9
	  public String getOnuLabel() {
	      return onuLabel;
	  }

	  //added by Zengtian, 2011/9/9
	  public void setOnuLabel(String label) {
	      onuLabel = label;
	  }
	
	/**
	Integer format(int value) {
		double d = 10 * Math.log10(value / (double) 10000);
		return new Integer((int) Math.round(d));
	}
*/
	public boolean retrieve() throws MibBeanException {
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTemperature));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltage));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPower));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPower));
/**		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning));
*/
//		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm));
//		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm));
//		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning));
//		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning));

		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisPmSwitch));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {

		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTemperature));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltage));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPower));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPower));
/**
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning));
		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning));
*/
//		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm));
//		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm));
//		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning));
//		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning));

		prepareRead(getProperty(utsDot3OnuOpticalTransceiverDiagnosisPmSwitch));

		Vector v = loadAll(new int[]{1, 1, 1, 1});

	    //added by Zengtian, 2011/9/9
//	    if (!DebugMode.isDebug()) {
//	        try {
//	            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//	            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//	            Map map = onuMgmtMgr.getOnuLabelMap(neName);
//	            for (int i = 0; i < v.size(); i++) {
//	            	Dot3Onu2OPTDTable bean = (Dot3Onu2OPTDTable) v.get(i);
//	                String key = new StringBuilder(neName).append(bean.getUtsDot3OnuOpticalTransceiverDiagnosisModuleId()).append("/").append(bean.getUtsDot3OnuOpticalTransceiverDiagnosisPortId()).append("/").append(bean.getUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId()).toString();
//	                if (map.containsKey(key)) {
//	                    bean.setOnuLabel((String) map.get(key));
//	                }
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }

	    return v;
	}

	public boolean modify() throws MibBeanException {
/**
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning));
*/
//		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm));
//		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm));
//		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning));
//		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning));
		prepareSave(getProperty(utsDot3OnuOpticalTransceiverDiagnosisPmSwitch));

		return save();
	}

}

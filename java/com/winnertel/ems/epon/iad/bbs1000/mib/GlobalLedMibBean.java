package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

public class GlobalLedMibBean extends SnmpMibBean {
  public static final String utsBBSLEDSysPowerLedState = "utsBBSLEDSysPowerLedState";
  public static final String utsBBSLEDSystemLedState = "utsBBSLEDSystemLedState";
  public static final String utsBBSLEDFanLedState = "utsBBSLEDFanLedState";
  public static final String utsBBSLEDAlarmCriticalLedState = "utsBBSLEDAlarmCriticalLedState";
  public static final String utsBBSLEDAlarmMajorLedState = "utsBBSLEDAlarmMajorLedState";
  public static final String utsBBSLEDAlarmMinorLedState = "utsBBSLEDAlarmMinorLedState";
  public static final String utsBBSLEDGsmUplinkSFP1State = "utsBBSLEDGsmUplinkSFP1State";
  public static final String utsBBSLEDGsmUplinkSFP2State = "utsBBSLEDGsmUplinkSFP2State";
  public static final String utsBBSLEDGsmUplinkSFP3State = "utsBBSLEDGsmUplinkSFP3State";
  public static final String utsBBSLEDGsmUplinkSFP4State = "utsBBSLEDGsmUplinkSFP4State";

  public GlobalLedMibBean(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsBBSLEDSysPowerLedState, new SnmpMibBeanProperty(utsBBSLEDSysPowerLedState, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.1", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDSystemLedState, new SnmpMibBeanProperty(utsBBSLEDSystemLedState, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.2", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDFanLedState, new SnmpMibBeanProperty(utsBBSLEDFanLedState, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.3", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDAlarmCriticalLedState, new SnmpMibBeanProperty(utsBBSLEDAlarmCriticalLedState, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.4", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDAlarmMajorLedState, new SnmpMibBeanProperty(utsBBSLEDAlarmMajorLedState, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.5", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDAlarmMinorLedState, new SnmpMibBeanProperty(utsBBSLEDAlarmMinorLedState, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.6", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDGsmUplinkSFP1State, new SnmpMibBeanProperty(utsBBSLEDGsmUplinkSFP1State, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.7", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDGsmUplinkSFP2State, new SnmpMibBeanProperty(utsBBSLEDGsmUplinkSFP2State, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.8", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDGsmUplinkSFP3State, new SnmpMibBeanProperty(utsBBSLEDGsmUplinkSFP3State, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.9", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDGsmUplinkSFP4State, new SnmpMibBeanProperty(utsBBSLEDGsmUplinkSFP4State, ".1.3.6.1.4.1.45121.1800.2.1.1.4.6.1.10", ISnmpConstant.INTEGER));
  }


  public Integer getUtsBBSLEDSysPowerLedState() {
    return (Integer) getProperty(utsBBSLEDSysPowerLedState).getValue();
  }

  public void setUtsBBSLEDSysPowerLedState(Integer aUtsBBSLEDSysPowerLedState) {
    getProperty(utsBBSLEDSystemLedState).setValue(aUtsBBSLEDSysPowerLedState);
  }


  public Integer getUtsBBSLEDSystemLedState() {
    return (Integer) getProperty(utsBBSLEDSystemLedState).getValue();
  }

  public void setUtsBBSLEDSystemLedState(Integer aUtsBBSLEDSystemLedState) {
    getProperty(utsBBSLEDSystemLedState).setValue(aUtsBBSLEDSystemLedState);
  }

  public Integer getUtsBBSLEDFanLedState() {
    return (Integer) getProperty(utsBBSLEDFanLedState).getValue();
  }

  public void setUtsBBSLEDFanLedState(Integer aUtsBBSLEDFanLedState) {
    getProperty(utsBBSLEDFanLedState).setValue(aUtsBBSLEDFanLedState);
  }

  public Integer getUtsBBSLEDAlarmCriticalLedState() {
    return (Integer) getProperty(utsBBSLEDAlarmCriticalLedState).getValue();
  }

  public void setUtsBBSLEDAlarmCriticalLedState(Integer aUtsBBSLEDAlarmCriticalLedState) {
    getProperty(utsBBSLEDAlarmCriticalLedState).setValue(aUtsBBSLEDAlarmCriticalLedState);
  }

  public Integer getUtsBBSLEDAlarmMajorLedState() {
    return (Integer) getProperty(utsBBSLEDAlarmMajorLedState).getValue();
  }

  public void setUtsBBSLEDAlarmMajorLedState(Integer aUtsBBSLEDAlarmMajorLedState) {
    getProperty(utsBBSLEDAlarmMajorLedState).setValue(aUtsBBSLEDAlarmMajorLedState);
  }

  public Integer getUtsBBSLEDAlarmMinorLedState() {
    return (Integer) getProperty(utsBBSLEDAlarmMinorLedState).getValue();
  }

  public void setUtsBBSLEDAlarmMinorLedState(Integer aUtsBBSLEDAlarmMinorLedState) {
    getProperty(utsBBSLEDAlarmMinorLedState).setValue(aUtsBBSLEDAlarmMinorLedState);
  }

  public Integer getUtsBBSLEDGsmUplinkSFP1State() {
    return (Integer) getProperty(utsBBSLEDGsmUplinkSFP1State).getValue();
  }

  public void setUtsBBSLEDGsmUplinkSFP1State(Integer aUtsBBSLEDGsmUplinkSFP1State) {
    getProperty(utsBBSLEDGsmUplinkSFP1State).setValue(aUtsBBSLEDGsmUplinkSFP1State);
  }

  public Integer getUtsBBSLEDGsmUplinkSFP2State() {
    return (Integer) getProperty(utsBBSLEDGsmUplinkSFP2State).getValue();
  }

  public void setUtsBBSLEDGsmUplinkSFP2State(Integer aUtsBBSLEDGsmUplinkSFP2State) {
    getProperty(utsBBSLEDGsmUplinkSFP2State).setValue(aUtsBBSLEDGsmUplinkSFP2State);
  }

  public Integer getUtsBBSLEDGsmUplinkSFP3State() {
    return (Integer) getProperty(utsBBSLEDGsmUplinkSFP3State).getValue();
  }

  public void setUtsBBSLEDGsmUplinkSFP3State(Integer aUtsBBSLEDGsmUplinkSFP3State) {
    getProperty(utsBBSLEDGsmUplinkSFP3State).setValue(aUtsBBSLEDGsmUplinkSFP3State);
  }

  public Integer getUtsBBSLEDGsmUplinkSFP4State() {
    return (Integer) getProperty(utsBBSLEDGsmUplinkSFP4State).getValue();
  }

  public void setUtsBBSLEDGsmUplinkSFP4State(Integer aUtsBBSLEDGsmUplinkSFP4State) {
    getProperty(utsBBSLEDGsmUplinkSFP4State).setValue(aUtsBBSLEDGsmUplinkSFP4State);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsBBSLEDSystemLedState));
    prepareRead(super.getProperty(utsBBSLEDFanLedState));
    prepareRead(super.getProperty(utsBBSLEDAlarmCriticalLedState));
    prepareRead(super.getProperty(utsBBSLEDAlarmMajorLedState));
    prepareRead(super.getProperty(utsBBSLEDAlarmMinorLedState));
    prepareRead(super.getProperty(utsBBSLEDGsmUplinkSFP1State));
    prepareRead(super.getProperty(utsBBSLEDGsmUplinkSFP2State));
    prepareRead(super.getProperty(utsBBSLEDGsmUplinkSFP3State));
    prepareRead(super.getProperty(utsBBSLEDGsmUplinkSFP4State));

    return load();
  }
}
package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class TCAConfig extends SnmpMibBean{

  public static final String utsBBSSysCpuUtilityAlarmThresholdTotal = "utsBBSSysCpuUtilityAlarmThresholdTotal";
  public static final String utsBBSSysCpuUtilityAlarmThresholdPerTask = "utsBBSSysCpuUtilityAlarmThresholdPerTask";
  public static final String utsBBSSysMemoryUtilityAlarmThreshold = "utsBBSSysMemoryUtilityAlarmThreshold";
//  public static final String utsPonSysReceiveSensitivityMax = "utsPonSysReceiveSensitivityMax";
//  public static final String utsPonSysOverloadOpticalPower = "utsPonSysOverloadOpticalPower";
  
  public TCAConfig(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  @Override
  protected void init() {
    initProperty(utsBBSSysCpuUtilityAlarmThresholdTotal, new SnmpMibBeanProperty(utsBBSSysCpuUtilityAlarmThresholdTotal, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.18", ISnmpConstant.INTEGER));
    initProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask, new SnmpMibBeanProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.19", ISnmpConstant.INTEGER));
    initProperty(utsBBSSysMemoryUtilityAlarmThreshold, new SnmpMibBeanProperty(utsBBSSysMemoryUtilityAlarmThreshold, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.20", ISnmpConstant.INTEGER));
//    initProperty(utsPonSysReceiveSensitivityMax, new SnmpMibBeanProperty(utsPonSysReceiveSensitivityMax, ".1.3.6.1.4.1.41355.1800.2.1.1.2.9", ISnmpConstant.INTEGER));
//    initProperty(utsPonSysOverloadOpticalPower, new SnmpMibBeanProperty(utsPonSysOverloadOpticalPower, ".1.3.6.1.4.1.41355.1800.2.1.1.2.10", ISnmpConstant.INTEGER));
  }
  
  public Integer getUtsBBSSysCpuUtilityAlarmThresholdTotal() {
    return (Integer) getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal)
        .getValue();
  }

  public void setUtsBBSSysCpuUtilityAlarmThresholdTotal(Integer aUtsBBSSysCpuUtilityAlarmThresholdTotal) {
    getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal).setValue(aUtsBBSSysCpuUtilityAlarmThresholdTotal);
  }

  public Integer getUtsBBSSysCpuUtilityAlarmThresholdPerTask() {
    return (Integer) getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask)
        .getValue();
  }

  public void setUtsBBSSysCpuUtilityAlarmThresholdPerTask(Integer aUtsBBSSysCpuUtilityAlarmThresholdPerTask) {
    getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask).setValue(aUtsBBSSysCpuUtilityAlarmThresholdPerTask);
  }

  public Integer getUtsBBSSysMemoryUtilityAlarmThreshold() {
    return (Integer) getProperty(utsBBSSysMemoryUtilityAlarmThreshold)
        .getValue();
  }

  public void setUtsBBSSysMemoryUtilityAlarmThreshold(Integer aUtsBBSSysMemoryUtilityAlarmThreshold) {
    getProperty(utsBBSSysMemoryUtilityAlarmThreshold).setValue(aUtsBBSSysMemoryUtilityAlarmThreshold);
  }

  
//  public Integer getUtsPonSysReceiveSensitivityMax() {
//    return (Integer)getProperty(utsPonSysReceiveSensitivityMax).getValue();
//  }
//
//  public void setUtsPonSysReceiveSensitivityMax(Integer aUtsPonSysReceiveSensitivityMax) {
//    getProperty(utsPonSysReceiveSensitivityMax).setValue(aUtsPonSysReceiveSensitivityMax);
//  }
//
//  public Integer getUtsPonSysOverloadOpticalPower() {
//    return (Integer)getProperty(utsPonSysOverloadOpticalPower).getValue();
//  }
//
//  public void setUtsPonSysOverloadOpticalPower(Integer aUtsPonSysOverloadOpticalPower) {
//    getProperty(utsPonSysOverloadOpticalPower).setValue(aUtsPonSysOverloadOpticalPower);
//  }

  public boolean retrieve()throws MibBeanException {
    prepareRead(getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal));
    prepareRead(getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask));
    prepareRead(getProperty(utsBBSSysMemoryUtilityAlarmThreshold));
//    prepareRead(getProperty(utsPonSysReceiveSensitivityMax));
//    prepareRead(getProperty(utsPonSysOverloadOpticalPower));
    return load();
  }
  
  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal));
    prepareSave(getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask));
    prepareSave(getProperty(utsBBSSysMemoryUtilityAlarmThreshold));
//    prepareSave(super.getProperty(utsPonSysReceiveSensitivityMax));
//    prepareSave(super.getProperty(utsPonSysOverloadOpticalPower));
    return save();
  }
}

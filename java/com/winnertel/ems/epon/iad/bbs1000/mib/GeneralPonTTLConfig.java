package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class GeneralPonTTLConfig extends SnmpMibBean{
  
  public static final String utsBBSBPDUTermination = "utsBBSBPDUTermination";
  public static final String utsBBSSysSoftwareRateLimiting = "utsBBSSysSoftwareRateLimiting";
  public static final String utsBBSSysCpuUtilityAlarmThresholdTotal = "utsBBSSysCpuUtilityAlarmThresholdTotal";
  public static final String utsBBSSysCpuUtilityAlarmThresholdPerTask = "utsBBSSysCpuUtilityAlarmThresholdPerTask";
  public static final String utsBBSSysMemoryUtilityAlarmThreshold = "utsBBSSysMemoryUtilityAlarmThreshold";
  public static final String utsBBSSysARPAgingTime = "utsBBSSysARPAgingTime";
  public static final String utsBBSSysMACAgingTime = "utsBBSSysMACAgingTime";
  public static final String utsPonSysOlpMode = "utsPonSysOlpMode";
  public static final String utsPonSysDot1adTPID = "utsPonSysDot1adTPID";
  
  public static final String utsPonSysLocalAuthentication = "utsPonSysLocalAuthentication";
  public static final String utsPonSysLogicalPortStrictBinging = "utsPonSysLogicalPortStrictBinging";
  public static final String utsPonSysSlaSynchronization = "utsPonSysSlaSynchronization";
  public static final String utsPonSysOltMACAgingTime = "utsPonSysOltMACAgingTime";
  public static final String utsPonSysOnuAuthTimeOut = "utsPonSysOnuAuthTimeOut";
  
  public static final String utsBBSMgmtTrafficTTL = "utsBBSMgmtTrafficTTL";
  
  public GeneralPonTTLConfig(ISnmpProxy snmpProxy) {
    super(snmpProxy);
    init();
  }
  
  protected void init() {
    initProperty(utsBBSBPDUTermination, new SnmpMibBeanProperty(utsBBSBPDUTermination, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.15",        ISnmpConstant.INTEGER));
    initProperty(utsBBSSysSoftwareRateLimiting, new SnmpMibBeanProperty(utsBBSSysSoftwareRateLimiting, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.16", ISnmpConstant.INTEGER));
    initProperty(utsBBSSysCpuUtilityAlarmThresholdTotal, new SnmpMibBeanProperty(utsBBSSysCpuUtilityAlarmThresholdTotal, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.18", ISnmpConstant.INTEGER));
    initProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask, new SnmpMibBeanProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.19", ISnmpConstant.INTEGER));
    initProperty(utsBBSSysMemoryUtilityAlarmThreshold, new SnmpMibBeanProperty(utsBBSSysMemoryUtilityAlarmThreshold, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.20", ISnmpConstant.INTEGER));
    initProperty(utsBBSSysARPAgingTime, new SnmpMibBeanProperty(utsBBSSysARPAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.21", ISnmpConstant.INTEGER));
    initProperty(utsBBSSysMACAgingTime, new SnmpMibBeanProperty(utsBBSSysMACAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.22", ISnmpConstant.INTEGER));
    initProperty(utsPonSysOlpMode, new SnmpMibBeanProperty(utsPonSysOlpMode, ".1.3.6.1.4.1.45121.1800.2.1.1.2.7", ISnmpConstant.INTEGER));
    initProperty(utsPonSysDot1adTPID, new SnmpMibBeanProperty(utsPonSysDot1adTPID, ".1.3.6.1.4.1.45121.1800.2.1.1.2.8", ISnmpConstant.INTEGER));

    initProperty(utsPonSysLocalAuthentication, new SnmpMibBeanProperty(utsPonSysLocalAuthentication, ".1.3.6.1.4.1.45121.1800.2.1.1.2.2", ISnmpConstant.INTEGER));
    initProperty(utsPonSysLogicalPortStrictBinging, new SnmpMibBeanProperty(utsPonSysLogicalPortStrictBinging, ".1.3.6.1.4.1.45121.1800.2.1.1.2.3", ISnmpConstant.INTEGER));
    initProperty(utsPonSysSlaSynchronization, new SnmpMibBeanProperty(utsPonSysSlaSynchronization, ".1.3.6.1.4.1.45121.1800.2.1.1.2.4", ISnmpConstant.INTEGER));
    initProperty(utsPonSysOltMACAgingTime, new SnmpMibBeanProperty(utsPonSysOltMACAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.2.5", ISnmpConstant.INTEGER));
    initProperty(utsPonSysOnuAuthTimeOut, new SnmpMibBeanProperty(utsPonSysOnuAuthTimeOut, ".1.3.6.1.4.1.45121.1800.2.1.1.2.6", ISnmpConstant.INTEGER));
 
    initProperty(utsBBSMgmtTrafficTTL, new SnmpMibBeanProperty(utsBBSMgmtTrafficTTL, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.26", ISnmpConstant.INTEGER));
  }
  public Integer getUtsBBSBPDUTermination() {
    return (Integer) getProperty(utsBBSBPDUTermination).getValue();
  }

  public void setUtsBBSBPDUTermination(Integer aUtsBBSBPDUTermination) {
    getProperty(utsBBSBPDUTermination).setValue(aUtsBBSBPDUTermination);
  }

  public Integer getUtsBBSSysSoftwareRateLimiting() {
    return (Integer) getProperty(utsBBSSysSoftwareRateLimiting).getValue();
  }

  public void setUtsBBSSysSoftwareRateLimiting(Integer aUtsBBSSysSoftwareRateLimiting) {
    getProperty(utsBBSSysSoftwareRateLimiting).setValue(aUtsBBSSysSoftwareRateLimiting);
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

  public Integer getUtsBBSSysARPAgingTime() {
    return (Integer) getProperty(utsBBSSysARPAgingTime).getValue();
  }

  public void setUtsBBSSysARPAgingTime(Integer aUtsBBSSysARPAgingTime) {
    getProperty(utsBBSSysARPAgingTime).setValue(aUtsBBSSysARPAgingTime);
  }

  public Integer getUtsBBSSysMACAgingTime() {
    return (Integer) getProperty(utsBBSSysMACAgingTime).getValue();
  }

  public void setUtsBBSSysMACAgingTime(Integer aUtsBBSSysMACAgingTime) {
    getProperty(utsBBSSysMACAgingTime).setValue(aUtsBBSSysMACAgingTime);
  }

  public Integer getUtsPonSysOlpMode() {
    return (Integer) getProperty(utsPonSysOlpMode).getValue();
  }

  public void setUtsPonSysOlpMode(Integer aUtsPonSysOlpMode) {
    getProperty(utsPonSysOlpMode).setValue(aUtsPonSysOlpMode);
  }

  public Integer getUtsPonSysDot1adTPID() {
    return (Integer) getProperty(utsPonSysDot1adTPID).getValue();
  }

  public void setUtsPonSysDot1adTPID(Integer autsPonSysDot1adTPID) {
    getProperty(utsPonSysDot1adTPID).setValue(autsPonSysDot1adTPID);
  }
  
  public Integer getUtsPonSysLocalAuthentication() {
    return (Integer) getProperty(utsPonSysLocalAuthentication).getValue();
  }

  public void setUtsPonSysLocalAuthentication(Integer aUtsPonSysLocalAuthentication) {
    getProperty(utsPonSysLocalAuthentication).setValue(aUtsPonSysLocalAuthentication);
  }

  public Integer getUtsPonSysLogicalPortStrictBinging() {
    return (Integer) getProperty(utsPonSysLogicalPortStrictBinging).getValue();
  }

  public void setUtsPonSysLogicalPortStrictBinging(Integer aUtsPonSysLogicalPortStrictBinging) {
    getProperty(utsPonSysLogicalPortStrictBinging).setValue(aUtsPonSysLogicalPortStrictBinging);
  }

  public Integer getUtsPonSysSlaSynchronization() {
    return (Integer) getProperty(utsPonSysSlaSynchronization).getValue();
  }

  public void setUtsPonSysSlaSynchronization(Integer aUtsPonSysSlaSynchronization) {
    getProperty(utsPonSysSlaSynchronization).setValue(aUtsPonSysSlaSynchronization);
  }

  public Integer getUtsPonSysOltMACAgingTime() {
    return (Integer) getProperty(utsPonSysOltMACAgingTime).getValue();
  }

  public void setUtsPonSysOltMACAgingTime(Integer aUtsPonSysOltMACAgingTime) {
    getProperty(utsPonSysOltMACAgingTime).setValue(aUtsPonSysOltMACAgingTime);
  }

  public Integer getUtsPonSysOnuAuthTimeOut() {
    return (Integer) getProperty(utsPonSysOnuAuthTimeOut).getValue();
  }

  public void setUtsPonSysOnuAuthTimeOut(Integer aUtsPonSysOnuAuthTimeOut) {
    getProperty(utsPonSysOnuAuthTimeOut).setValue(aUtsPonSysOnuAuthTimeOut);
  }
  
  public Integer getUtsBBSMgmtTrafficTTL() {
    return (Integer) getProperty(utsBBSMgmtTrafficTTL).getValue();
  }

  public void setUtsBBSMgmtTrafficTTL(Integer aUtsBBSMgmtTrafficTTL) {
    getProperty(utsBBSMgmtTrafficTTL).setValue(aUtsBBSMgmtTrafficTTL);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsBBSBPDUTermination));
    prepareRead(super.getProperty(utsBBSSysSoftwareRateLimiting));
    prepareRead(super.getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal));
    prepareRead(super.getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask));
    prepareRead(super.getProperty(utsBBSSysMemoryUtilityAlarmThreshold));
    prepareRead(super.getProperty(utsBBSSysARPAgingTime));
    prepareRead(super.getProperty(utsBBSSysMACAgingTime));
    prepareRead(super.getProperty(utsPonSysOlpMode));
    prepareRead(super.getProperty(utsPonSysDot1adTPID));

    prepareRead(super.getProperty(utsPonSysLocalAuthentication));
    prepareRead(super.getProperty(utsPonSysLogicalPortStrictBinging));
    prepareRead(super.getProperty(utsPonSysSlaSynchronization));
    prepareRead(super.getProperty(utsPonSysOltMACAgingTime));
    prepareRead(super.getProperty(utsPonSysOnuAuthTimeOut));
    
    prepareRead(super.getProperty(utsBBSMgmtTrafficTTL));
    return load();
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsBBSBPDUTermination));
    prepareSave(getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal));
    prepareSave(getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask));
    prepareSave(getProperty(utsBBSSysMemoryUtilityAlarmThreshold));
    prepareSave(getProperty(utsBBSSysARPAgingTime));
    prepareSave(getProperty(utsBBSSysMACAgingTime));
    prepareSave(getProperty(utsPonSysOlpMode));
    
    prepareSave(super.getProperty(utsPonSysLocalAuthentication));
    prepareSave(super.getProperty(utsPonSysLogicalPortStrictBinging));
    prepareSave(super.getProperty(utsPonSysSlaSynchronization));
    prepareSave(super.getProperty(utsPonSysOltMACAgingTime));
    prepareSave(super.getProperty(utsPonSysOnuAuthTimeOut));
    prepareSave(super.getProperty(utsPonSysDot1adTPID));
    
    prepareSave(getProperty(utsBBSMgmtTrafficTTL));

    return save();
  }

}


package com.winnertel.ems.epon.iad.bbs1000.mib.r330;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

public class GeneralPonTTLConfig extends SnmpMibBean {

  public static final String utsBBSBPDUTermination = "utsBBSBPDUTermination";
  public static final String utsBBSSysSoftwareRateLimiting = "utsBBSSysSoftwareRateLimiting";
  public static final String utsBBSSysCpuUtilityAlarmThresholdTotal = "utsBBSSysCpuUtilityAlarmThresholdTotal";
  public static final String utsBBSSysCpuUtilityAlarmThresholdPerTask = "utsBBSSysCpuUtilityAlarmThresholdPerTask";
  public static final String utsBBSSysMemoryUtilityAlarmThreshold = "utsBBSSysMemoryUtilityAlarmThreshold";
  public static final String utsBBSSysARPAgingTime = "utsBBSSysARPAgingTime";
  public static final String utsBBSSysMACAgingTime = "utsBBSSysMACAgingTime";
  public static final String utsPonSysOlpMode = "utsPonSysOlpMode";
//  public static final String utsBBSVlanVPNTPID = "utsBBSVlanVPNTPID";
//  public static final String utsBBSVlanVPNPRISource = "utsBBSVlanVPNPRISource";
//  public static final String utsBBSMaxFrameSize = "utsBBSMaxFrameSize";
  public static final String utsBBSMgmtGratuitousArpLearning = "utsBBSMgmtGratuitousArpLearning";

  public static final String utsBBSMgmtTrafficTTL = "utsBBSMgmtTrafficTTL";
  public static final String utsBBSMgmtArpLearning = "utsBBSMgmtArpLearning";
  public static final String utsBBSMgmtIgmpProxySourceIP = "utsBBSMgmtIgmpProxySourceIP";

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
//    initProperty(utsBBSVlanVPNTPID, new SnmpMibBeanProperty(utsBBSVlanVPNTPID, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.1", ISnmpConstant.INTEGER));
//    initProperty(utsBBSVlanVPNPRISource, new SnmpMibBeanProperty(utsBBSVlanVPNPRISource, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.3", ISnmpConstant.INTEGER));
//    initProperty(utsBBSMaxFrameSize, new SnmpMibBeanProperty(utsBBSMaxFrameSize, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.4", ISnmpConstant.INTEGER));
    initProperty(utsBBSMgmtGratuitousArpLearning, new SnmpMibBeanProperty(utsBBSMgmtGratuitousArpLearning, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.38", ISnmpConstant.INTEGER));
    //initProperty(utsPonSysDot1adTPID, new SnmpMibBeanProperty(utsPonSysDot1adTPID, ".1.3.6.1.4.1.45121.1800.2.1.1.2.8", ISnmpConstant.INTEGER));
    initProperty(utsBBSMgmtTrafficTTL, new SnmpMibBeanProperty(utsBBSMgmtTrafficTTL, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.26", ISnmpConstant.INTEGER));
    initProperty(utsBBSMgmtArpLearning, new SnmpMibBeanProperty(utsBBSMgmtArpLearning, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.45", ISnmpConstant.INTEGER));
    initProperty(utsBBSMgmtIgmpProxySourceIP, new SnmpMibBeanProperty(utsBBSMgmtIgmpProxySourceIP, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.51", ISnmpConstant.IP_ADDRESS));
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

//  public Integer getUtsBBSVlanVPNTPID() {
//    return (Integer) getProperty(utsBBSVlanVPNTPID).getValue();
//  }
//
//  public void setUtsBBSVlanVPNTPID(Integer aUtsBBSVlanVPNTPID) {
//    getProperty(utsBBSVlanVPNTPID).setValue(aUtsBBSVlanVPNTPID);
//  }
//
//  public Integer getUtsBBSVlanVPNPRISource() {
//    return (Integer) getProperty(utsBBSVlanVPNPRISource).getValue();
//  }
//
//  public void setUtsBBSVlanVPNPRISource(Integer aUtsBBSVlanVPNPRISource) {
//    getProperty(utsBBSVlanVPNPRISource).setValue(aUtsBBSVlanVPNPRISource);
//  }
//
//  public Integer getUtsBBSMaxFrameSize() {
//    return (Integer) getProperty(utsBBSMaxFrameSize).getValue();
//  }
//
//  public void setUtsBBSMaxFrameSize(Integer aUtsBBSMaxFrameSize) {
//    getProperty(utsBBSMaxFrameSize).setValue(aUtsBBSMaxFrameSize);
//  }

  public Integer getUtsBBSMgmtGratuitousArpLearning() {
    return (Integer) getProperty(utsBBSMgmtGratuitousArpLearning).getValue();
  }

  public void setUtsBBSMgmtGratuitousArpLearning(Integer aUtsBBSMgmtGratuitousArpLearning) {
    getProperty(utsBBSMgmtGratuitousArpLearning).setValue(aUtsBBSMgmtGratuitousArpLearning);
  }

  public Integer getUtsBBSMgmtTrafficTTL() {
    return (Integer) getProperty(utsBBSMgmtTrafficTTL).getValue();
  }

  public void setUtsBBSMgmtTrafficTTL(Integer aUtsBBSMgmtTrafficTTL) {
    getProperty(utsBBSMgmtTrafficTTL).setValue(aUtsBBSMgmtTrafficTTL);
  }

  public Integer getUtsBBSMgmtArpLearning() {
    return (Integer)getProperty(utsBBSMgmtArpLearning).getValue();
  }

  public void setUtsBBSMgmtArpLearning(Integer aUtsBBSMgmtArpLearning) {
    getProperty(utsBBSMgmtArpLearning).setValue(aUtsBBSMgmtArpLearning);
  }

  public String getUtsBBSMgmtIgmpProxySourceIP(){
    return (String)getProperty(utsBBSMgmtIgmpProxySourceIP).getValue();
  }
  public void setUtsBBSMgmtIgmpProxySourceIP(String aUtsBBSMgmtIgmpProxySourceIP){
    getProperty(utsBBSMgmtIgmpProxySourceIP).setValue(aUtsBBSMgmtIgmpProxySourceIP);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(getProperty(utsBBSBPDUTermination));
    prepareRead(getProperty(utsBBSSysSoftwareRateLimiting));
    prepareRead(getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal));
    prepareRead(getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask));
    prepareRead(getProperty(utsBBSSysMemoryUtilityAlarmThreshold));
    prepareRead(getProperty(utsBBSSysARPAgingTime));
    prepareRead(getProperty(utsBBSSysMACAgingTime));
    prepareRead(getProperty(utsPonSysOlpMode));
//    prepareRead(getProperty(utsBBSVlanVPNTPID));
//    prepareRead(getProperty(utsBBSVlanVPNPRISource));
//    prepareRead(getProperty(utsBBSMaxFrameSize));
    prepareRead(getProperty(utsBBSMgmtGratuitousArpLearning));

    prepareRead(getProperty(utsBBSMgmtTrafficTTL));
    prepareRead(getProperty(utsBBSMgmtArpLearning));
    prepareRead(getProperty(utsBBSMgmtIgmpProxySourceIP));

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
//    prepareSave(getProperty(utsBBSMaxFrameSize));
    prepareSave(getProperty(utsBBSMgmtGratuitousArpLearning));
    //prepareSave(getProperty(utsPonSysDot1adTPID));
    prepareSave(getProperty(utsBBSMgmtTrafficTTL));
    prepareSave(getProperty(utsBBSMgmtArpLearning));
    prepareSave(getProperty(utsBBSMgmtIgmpProxySourceIP));

    return save();
  }

}

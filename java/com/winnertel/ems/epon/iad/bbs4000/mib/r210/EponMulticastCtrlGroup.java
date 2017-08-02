package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class EponMulticastCtrlGroup  extends SnmpMibBean
{
  public static final String utsEponMulticastCtrlIpmcEnable = "utsEponMulticastCtrlIpmcEnable";
  public static final String utsEponMulticastCtrlIgmpSnoopingStatus = "utsEponMulticastCtrlIgmpSnoopingStatus";
  public static final String utsEponMcastCtrlIgmpProxyStatus = "utsEponMcastCtrlIgmpProxyStatus";
  public static final String utsEponMulticastCtrlSuperVidList = "utsEponMulticastCtrlSuperVidList";
  public static final String utsOltCtcMulticastCtrlMode = "utsOltCtcMulticastCtrlMode";
  public static final String utsOltNoCdrForShortJoinLeave= "utsOltNoCdrForShortJoinLeave";
  public static final String utsOltNoTimeForShortPreview = "utsOltNoTimeForShortPreview";
  public static final String utsBBSMgmtLastMembQueryIntvl = "utsBBSMgmtLastMembQueryIntvl";
  public static final String utsBBSMgmtQueryInterval = "utsBBSMgmtQueryInterval";
  public static final String utsBBSMgmtQueryMaxRespTime = "utsBBSMgmtQueryMaxRespTime";
  public static final String utsBBSMgmtRobustness = "utsBBSMgmtRobustness";

  public static final String utsOltCtcCdrServer = "utsOltCtcCdrServer";
  public static final String utsOltCtcCdrPort = "utsOltCtcCdrPort";
  public static final String utsOltCtcCdrReportInterval = "utsOltCtcCdrReportInterval";
  public static final String utsOltCtcCdrReportCount = "utsOltCtcCdrReportCount";
  public static final String utsOltCtcCdrForceReport = "utsOltCtcCdrForceReport";
  public static final String utsOltCtcCdrReportMode = "utsOltCtcCdrReportMode";
  
  public EponMulticastCtrlGroup(ISnmpProxy aSnmpProxy)
  {
    super(aSnmpProxy);
    init();
  }

  protected void init()
  {
    initProperty(utsEponMulticastCtrlIpmcEnable,
        new SnmpMibBeanProperty( utsEponMulticastCtrlIpmcEnable, ".1.3.6.1.4.1.45121.1800.2.2.1.5.1.1.6", ISnmpConstant.INTEGER));
    initProperty(utsEponMulticastCtrlIgmpSnoopingStatus,
        new SnmpMibBeanProperty(utsEponMulticastCtrlIgmpSnoopingStatus, ".1.3.6.1.4.1.45121.1800.2.2.1.5.1.1.7", ISnmpConstant.INTEGER));
    initProperty(utsEponMcastCtrlIgmpProxyStatus,
        new SnmpMibBeanProperty( utsEponMcastCtrlIgmpProxyStatus, ".1.3.6.1.4.1.45121.1800.2.2.1.5.1.1.8", ISnmpConstant.INTEGER));
    initProperty(utsEponMulticastCtrlSuperVidList,
        new SnmpMibBeanProperty( utsEponMulticastCtrlSuperVidList, ".1.3.6.1.4.1.45121.1800.2.2.1.5.1.1.9", ISnmpConstant.OCTETS));
    initProperty( utsOltCtcMulticastCtrlMode,
        new SnmpMibBeanProperty(utsOltCtcMulticastCtrlMode, ".1.3.6.1.4.1.45121.1800.2.4.3.1.3.1.2", ISnmpConstant.INTEGER));
    initProperty( utsOltNoCdrForShortJoinLeave,
        new SnmpMibBeanProperty(utsOltNoCdrForShortJoinLeave, ".1.3.6.1.4.1.45121.1800.2.4.3.1.3.1.3", ISnmpConstant.INTEGER));
    initProperty( utsOltNoTimeForShortPreview,
        new SnmpMibBeanProperty(utsOltNoTimeForShortPreview, ".1.3.6.1.4.1.45121.1800.2.4.3.1.3.1.4", ISnmpConstant.INTEGER));
    initProperty( utsBBSMgmtLastMembQueryIntvl,
        new SnmpMibBeanProperty(utsBBSMgmtLastMembQueryIntvl, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.28", ISnmpConstant.INTEGER));
    initProperty( utsBBSMgmtQueryInterval,
        new SnmpMibBeanProperty(utsBBSMgmtQueryInterval, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.29", ISnmpConstant.INTEGER));
    initProperty( utsBBSMgmtQueryMaxRespTime,
        new SnmpMibBeanProperty(utsBBSMgmtQueryMaxRespTime, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.30", ISnmpConstant.INTEGER));
    initProperty( utsBBSMgmtRobustness,
        new SnmpMibBeanProperty(utsBBSMgmtRobustness, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.31", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrServer, new SnmpMibBeanProperty(utsOltCtcCdrServer, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.1", ISnmpConstant.IP_ADDRESS));
    initProperty(utsOltCtcCdrPort, new SnmpMibBeanProperty(utsOltCtcCdrPort, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.2", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrReportInterval, new SnmpMibBeanProperty(utsOltCtcCdrReportInterval, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.3", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrReportCount, new SnmpMibBeanProperty(utsOltCtcCdrReportCount, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.4", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrForceReport, new SnmpMibBeanProperty(utsOltCtcCdrForceReport, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.5", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrReportMode, new SnmpMibBeanProperty(utsOltCtcCdrReportMode, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.6", ISnmpConstant.INTEGER));
  }

  public Integer getUtsEponMulticastCtrlIpmcEnable()
  {
    return (Integer) getProperty(utsEponMulticastCtrlIpmcEnable).getValue();
  }

  public void setUtsEponMulticastCtrlIpmcEnable(
      Integer aUtsEponMulticastCtrlIpmcEnable)
  {
    getProperty(utsEponMulticastCtrlIpmcEnable).setValue(
        aUtsEponMulticastCtrlIpmcEnable);
  }

  public Integer getUtsEponMulticastCtrlIgmpSnoopingStatus()
  {
    return (Integer) getProperty(utsEponMulticastCtrlIgmpSnoopingStatus)
        .getValue();
  }

  public void setUtsEponMulticastCtrlIgmpSnoopingStatus(
      Integer aUtsEponMulticastCtrlIgmpSnoopingStatus)
  {
    getProperty(utsEponMulticastCtrlIgmpSnoopingStatus).setValue(
        aUtsEponMulticastCtrlIgmpSnoopingStatus);
  }

  public Integer getUtsOltCtcMulticastCtrlMode() {
    return (Integer) getProperty(utsOltCtcMulticastCtrlMode).getValue();
  }

  public void setUtsOltCtcMulticastCtrlMode( Integer aUtsOltCtcMulticastCtrlMode) {
    getProperty(utsOltCtcMulticastCtrlMode).setValue( aUtsOltCtcMulticastCtrlMode);
  }

  public Integer getUtsOltNoCdrForShortJoinLeave() {
    return (Integer)getProperty(utsOltNoCdrForShortJoinLeave).getValue();
  }

  public void setUtsOltNoCdrForShortJoinLeave(Integer aUtsOltNoCdrForShortJoinLeave) {
    getProperty(utsOltNoCdrForShortJoinLeave).setValue(aUtsOltNoCdrForShortJoinLeave);
  }

  public Integer getUtsOltNoTimeForShortPreview() {
    return (Integer)getProperty(utsOltNoTimeForShortPreview).getValue();
  }

  public void setUtsOltNoTimeForShortPreview(Integer aUtsOltNoTimeForShortPreview) {
    getProperty(utsOltNoTimeForShortPreview).setValue(aUtsOltNoTimeForShortPreview);
  }

  public Integer getUtsEponMcastCtrlIgmpProxyStatus()
  {
    return (Integer) getProperty(utsEponMcastCtrlIgmpProxyStatus).getValue();
  }

  public void setUtsEponMcastCtrlIgmpProxyStatus( Integer aUtsEponMcastCtrlIgmpProxyStatus)
  {
    getProperty(utsEponMcastCtrlIgmpProxyStatus).setValue( aUtsEponMcastCtrlIgmpProxyStatus);
  }

  public byte[] getUtsEponMulticastCtrlSuperVidList() {
//    return bitMapToString("" + getProperty(utsEponMulticastCtrlSuperVidList).getValue());
    return (byte[])getProperty(utsEponMulticastCtrlSuperVidList).getValue();
  }

  public void setUtsEponMulticastCtrlSuperVidList(
      byte[] aUtsEponMulticastCtrlSuperVidList)
  {
//    getProperty(utsEponMulticastCtrlSuperVidList).setValue( generateBitMap(aUtsEponMulticastCtrlSuperVidList));
    getProperty(utsEponMulticastCtrlSuperVidList).setValue( aUtsEponMulticastCtrlSuperVidList);
  }

  public Integer getUtsBBSMgmtLastMembQueryIntvl()
  {
    return (Integer) getProperty(utsBBSMgmtLastMembQueryIntvl).getValue();
  }

  public void setUtsBBSMgmtLastMembQueryIntvl( Integer aUtsBBSMgmtLastMembQueryIntvl)
  {
    getProperty(utsBBSMgmtLastMembQueryIntvl).setValue( aUtsBBSMgmtLastMembQueryIntvl);
  }
  public Integer getUtsBBSMgmtQueryInterval()
  {
    return (Integer) getProperty(utsBBSMgmtQueryInterval).getValue();
  }

  public void setUtsBBSMgmtQueryInterval( Integer aUtsBBSMgmtQueryInterval)
  {
    getProperty(utsBBSMgmtQueryInterval).setValue( aUtsBBSMgmtQueryInterval);
  }
  public Integer getUtsBBSMgmtQueryMaxRespTime()
  {
    return (Integer) getProperty(utsBBSMgmtQueryMaxRespTime).getValue();
  }

  public void setUtsBBSMgmtQueryMaxRespTime( Integer aUtsBBSMgmtQueryMaxRespTime)
  {
    getProperty(utsBBSMgmtQueryMaxRespTime).setValue( aUtsBBSMgmtQueryMaxRespTime);
  }
  public Integer getUtsBBSMgmtRobustness()
  {
    return (Integer) getProperty(utsBBSMgmtRobustness).getValue();
  }

  public void setUtsBBSMgmtRobustness( Integer aUtsBBSMgmtRobustness)
  {
    getProperty(utsBBSMgmtRobustness).setValue( aUtsBBSMgmtRobustness);
  }

  public String getUtsOltCtcCdrServer() {
    return (String) getProperty(utsOltCtcCdrServer).getValue();
  }

  public void setUtsOltCtcCdrServer(String aUtsOltCtcCdrServer) {
    getProperty(utsOltCtcCdrServer).setValue(aUtsOltCtcCdrServer);
  }

  public Integer getUtsOltCtcCdrPort() {
    return (Integer)getProperty(utsOltCtcCdrPort).getValue();
  }

  public void setUtsOltCtcCdrPort(Integer aUtsOltCtcCdrPort)
  {
    getProperty(utsOltCtcCdrPort).setValue(aUtsOltCtcCdrPort);
  }

  public Integer getUtsOltCtcCdrReportInterval() {
    return (Integer) getProperty(utsOltCtcCdrReportInterval).getValue();
  }

  public void setUtsOltCtcCdrReportInterval(Integer aUtsOltCtcCdrReportInterval) {
    getProperty(utsOltCtcCdrReportInterval).setValue(aUtsOltCtcCdrReportInterval);
  }

  public Integer getUtsOltCtcCdrReportCount() {
    return (Integer) getProperty(utsOltCtcCdrReportCount).getValue();
  }

  public void setUtsOltCtcCdrReportCount(Integer aUtsOltCtcCdrReportCount) {
    getProperty(utsOltCtcCdrReportCount).setValue(aUtsOltCtcCdrReportCount);
  }

  public Integer getUtsOltCtcCdrForceReport() {
    return (Integer) getProperty(utsOltCtcCdrForceReport).getValue();
  }

  public void setUtsOltCtcCdrForceReport(Integer aUtsOltCtcCdrForceReport) {
    getProperty(utsOltCtcCdrForceReport).setValue(aUtsOltCtcCdrForceReport);
  }

  public Integer getUtsOltCtcCdrReportMode() {
    return (Integer) getProperty(utsOltCtcCdrReportMode).getValue();
  }

  public void setUtsOltCtcCdrReportMode(Integer aUtsOltCtcCdrReportMode) {
    getProperty(utsOltCtcCdrReportMode).setValue(aUtsOltCtcCdrReportMode);
  }
  
  public boolean retrieve() throws MibBeanException
  {
    prepareRead(getProperty(utsEponMulticastCtrlIpmcEnable));
    prepareRead(getProperty(utsEponMulticastCtrlIgmpSnoopingStatus));
    prepareRead(getProperty(utsEponMcastCtrlIgmpProxyStatus));
    prepareRead(getProperty(utsEponMulticastCtrlSuperVidList));
    prepareRead(getProperty(utsOltCtcMulticastCtrlMode));
    prepareRead(getProperty(utsOltNoCdrForShortJoinLeave));
    prepareRead(getProperty(utsOltNoTimeForShortPreview));
    prepareRead(getProperty(utsBBSMgmtLastMembQueryIntvl));
    prepareRead(getProperty(utsBBSMgmtQueryInterval));
    prepareRead(getProperty(utsBBSMgmtQueryMaxRespTime));
    prepareRead(getProperty(utsBBSMgmtRobustness));
    prepareRead(super.getProperty(utsOltCtcCdrServer));
    prepareRead(super.getProperty(utsOltCtcCdrPort));
    prepareRead(super.getProperty(utsOltCtcCdrReportInterval));
    prepareRead(super.getProperty(utsOltCtcCdrReportCount));
    prepareRead(super.getProperty(utsOltCtcCdrReportMode));
    return load();
  }

  public boolean modify() throws MibBeanException
  {
    prepareSave(getProperty(utsEponMulticastCtrlIpmcEnable));
    prepareSave(getProperty(utsEponMulticastCtrlIgmpSnoopingStatus));
    prepareSave(getProperty(utsEponMcastCtrlIgmpProxyStatus));
    prepareSave(getProperty(utsEponMulticastCtrlSuperVidList));
    prepareSave(getProperty(utsOltCtcMulticastCtrlMode));
    prepareSave(getProperty(utsOltNoCdrForShortJoinLeave));
    prepareSave(getProperty(utsOltNoTimeForShortPreview));
    prepareSave(getProperty(utsBBSMgmtLastMembQueryIntvl));
    prepareSave(getProperty(utsBBSMgmtQueryInterval));
    prepareSave(getProperty(utsBBSMgmtQueryMaxRespTime));
    prepareSave(getProperty(utsBBSMgmtRobustness));
    prepareSave(getProperty(utsOltCtcCdrServer));
    prepareSave(getProperty(utsOltCtcCdrPort));
    prepareSave(getProperty(utsOltCtcCdrReportInterval));
    prepareSave(getProperty(utsOltCtcCdrReportCount));
    prepareSave(getProperty(utsOltCtcCdrReportMode));

    return save();
  }
  
  public boolean forceReport() throws MibBeanException
  {
    setUtsOltCtcCdrForceReport(new Integer(1));
    prepareSave(getProperty(utsOltCtcCdrForceReport));

    return save();
  }
}

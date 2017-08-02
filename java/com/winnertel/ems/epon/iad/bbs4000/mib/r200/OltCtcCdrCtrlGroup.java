/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The OltCtcCdrCtrlGroup class.
 * Created by QuickDVM
 */
public class OltCtcCdrCtrlGroup extends SnmpMibBean {
  public static final String utsOltCtcCdrServer = "utsOltCtcCdrServer";
  public static final String utsOltCtcCdrPort = "utsOltCtcCdrPort";
  public static final String utsOltCtcCdrReportInterval = "utsOltCtcCdrReportInterval";
  public static final String utsOltCtcCdrReportCount = "utsOltCtcCdrReportCount";
  public static final String utsOltCtcCdrForceReport = "utsOltCtcCdrForceReport";
  public static final String utsOltCtcCdrReportMode = "utsOltCtcCdrReportMode";

  public OltCtcCdrCtrlGroup(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsOltCtcCdrServer, new SnmpMibBeanProperty(utsOltCtcCdrServer, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.1", ISnmpConstant.IP_ADDRESS));
    initProperty(utsOltCtcCdrPort, new SnmpMibBeanProperty(utsOltCtcCdrPort, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.2", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrReportInterval, new SnmpMibBeanProperty(utsOltCtcCdrReportInterval, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.3", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrReportCount, new SnmpMibBeanProperty(utsOltCtcCdrReportCount, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.4", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrForceReport, new SnmpMibBeanProperty(utsOltCtcCdrForceReport, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.5", ISnmpConstant.INTEGER));
    initProperty(utsOltCtcCdrReportMode, new SnmpMibBeanProperty(utsOltCtcCdrReportMode, ".1.3.6.1.4.1.45121.1800.2.4.3.2.1.6", ISnmpConstant.INTEGER));
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

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsOltCtcCdrServer));
    prepareRead(super.getProperty(utsOltCtcCdrPort));
    prepareRead(super.getProperty(utsOltCtcCdrReportInterval));
    prepareRead(super.getProperty(utsOltCtcCdrReportCount));
    prepareRead(super.getProperty(utsOltCtcCdrReportMode));

    return load();
  }

  public boolean modify() throws MibBeanException {
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
    
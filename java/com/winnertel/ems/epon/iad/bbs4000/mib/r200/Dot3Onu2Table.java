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
 * The Dot3Onu2Table class.
 * Created by QuickDVM
 */
public class Dot3Onu2Table extends SnmpMibBean {
  public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
  public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
  public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
  public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
  public static final String utsDot3OnuLlid = "utsDot3OnuLlid";
  public static final String utsDot3EepromVersion = "utsDot3EepromVersion";
  public static final String utsDot3OamVersion = "utsDot3OamVersion";
  public static final String utsDot3OnuMacAddress = "utsDot3OnuMacAddress";
  public static final String utsDot3OnuAdmin = "utsDot3OnuAdmin";
  public static final String utsDot3OnuTransparentMode = "utsDot3OnuTransparentMode";
  public static final String utsDot3OnuStatus = "utsDot3OnuStatus";
  public static final String utsDot3OnuMpcpTimeout = "utsDot3OnuMpcpTimeout";
  public static final String utsDot3OnuVendor = "utsDot3OnuVendor";
  public static final String utsDot3OnuModule = "utsDot3OnuModule";
  public static final String utsDot3OnuHwVersion2 = "utsDot3OnuHwVersion2";
  public static final String utsDot3OnuSerialNumber = "utsDot3OnuSerialNumber";
  public static final String utsDot3OnuLaserOnTime = "utsDot3OnuLaserOnTime";
  public static final String utsDot3OnuLaserOffTime = "utsDot3OnuLaserOffTime";
  public static final String utsDot3OnuDot1adEnable = "utsDot3OnuDot1adEnable";
  public static final String utsDot3OnuDot1adTPID = "utsDot3OnuDot1adTPID";
  public static final String utsDot3OnuReset2 = "utsDot3OnuReset2";

  public Dot3Onu2Table(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLlid, new SnmpMibBeanProperty(utsDot3OnuLlid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3EepromVersion, new SnmpMibBeanProperty(utsDot3EepromVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OamVersion, new SnmpMibBeanProperty(utsDot3OamVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMacAddress, new SnmpMibBeanProperty(utsDot3OnuMacAddress, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.8", ISnmpConstant.STRING));
    initProperty(utsDot3OnuAdmin, new SnmpMibBeanProperty(utsDot3OnuAdmin, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.9", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuTransparentMode, new SnmpMibBeanProperty(utsDot3OnuTransparentMode, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.10", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuStatus, new SnmpMibBeanProperty(utsDot3OnuStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.11", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMpcpTimeout, new SnmpMibBeanProperty(utsDot3OnuMpcpTimeout, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.12", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuVendor, new SnmpMibBeanProperty(utsDot3OnuVendor, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.13", ISnmpConstant.STRING));
    initProperty(utsDot3OnuModule, new SnmpMibBeanProperty(utsDot3OnuModule, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.14", ISnmpConstant.STRING));
    initProperty(utsDot3OnuHwVersion2, new SnmpMibBeanProperty(utsDot3OnuHwVersion2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.15", ISnmpConstant.STRING));
    initProperty(utsDot3OnuSerialNumber, new SnmpMibBeanProperty(utsDot3OnuSerialNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.16", ISnmpConstant.STRING));
    initProperty(utsDot3OnuLaserOnTime, new SnmpMibBeanProperty(utsDot3OnuLaserOnTime, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.17", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLaserOffTime, new SnmpMibBeanProperty(utsDot3OnuLaserOffTime, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.18", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDot1adEnable, new SnmpMibBeanProperty(utsDot3OnuDot1adEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.19", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDot1adTPID, new SnmpMibBeanProperty(utsDot3OnuDot1adTPID, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.20", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuReset2, new SnmpMibBeanProperty(utsDot3OnuReset2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.2.1.21", ISnmpConstant.INTEGER));

  }


  public Integer getUtsDot3OnuModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuModuleId(Integer aUtsDot3OnuModuleId) {
    setIndex(0, aUtsDot3OnuModuleId);
  }


  public Integer getUtsDot3OnuDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuDeviceId(Integer aUtsDot3OnuDeviceId) {
    setIndex(1, aUtsDot3OnuDeviceId);
  }


  public Integer getUtsDot3OnuPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OnuPortId(Integer aUtsDot3OnuPortId) {
    setIndex(2, aUtsDot3OnuPortId);
  }


  public Integer getUtsDot3OnuLogicalPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3OnuLogicalPortId(Integer aUtsDot3OnuLogicalPortId) {
    setIndex(3, aUtsDot3OnuLogicalPortId);
  }


  public Integer getUtsDot3OnuLlid() {
    return (Integer) getProperty(utsDot3OnuLlid).getValue();
  }

  public void setUtsDot3OnuLlid(Integer aUtsDot3OnuLlid) {
    getProperty(utsDot3OnuLlid).setValue(aUtsDot3OnuLlid);
  }

  public Integer getUtsDot3EepromVersion() {
    return (Integer) getProperty(utsDot3EepromVersion).getValue();
  }

  public void setUtsDot3EepromVersion(Integer aUtsDot3EepromVersion) {
    getProperty(utsDot3EepromVersion).setValue(aUtsDot3EepromVersion);
  }

  public Integer getUtsDot3OamVersion() {
    return (Integer) getProperty(utsDot3OamVersion).getValue();
  }

  public void setUtsDot3OamVersion(Integer aUtsDot3OamVersion) {
    getProperty(utsDot3OamVersion).setValue(aUtsDot3OamVersion);
  }

  public String getUtsDot3OnuMacAddress() {
    return (String) getProperty(utsDot3OnuMacAddress).getValue();
  }

  public void setUtsDot3OnuMacAddress(String aUtsDot3OnuMacAddress) {
    getProperty(utsDot3OnuMacAddress).setValue(aUtsDot3OnuMacAddress);
  }

  public Integer getUtsDot3OnuAdmin() {
    return (Integer) getProperty(utsDot3OnuAdmin).getValue();
  }

  public void setUtsDot3OnuAdmin(Integer aUtsDot3OnuAdmin) {
    getProperty(utsDot3OnuAdmin).setValue(aUtsDot3OnuAdmin);
  }

  public Integer getUtsDot3OnuTransparentMode() {
    return (Integer) getProperty(utsDot3OnuTransparentMode).getValue();
  }

  public void setUtsDot3OnuTransparentMode(Integer aUtsDot3OnuTransparentMode) {
    getProperty(utsDot3OnuTransparentMode).setValue(aUtsDot3OnuTransparentMode);
  }

  public Integer getUtsDot3OnuStatus() {
    return (Integer) getProperty(utsDot3OnuStatus).getValue();
  }

  public void setUtsDot3OnuStatus(Integer aUtsDot3OnuStatus) {
    getProperty(utsDot3OnuStatus).setValue(aUtsDot3OnuStatus);
  }

  public Integer getUtsDot3OnuMpcpTimeout() {
    return (Integer) getProperty(utsDot3OnuMpcpTimeout).getValue();
  }

  public void setUtsDot3OnuMpcpTimeout(Integer aUtsDot3OnuMpcpTimeout) {
    getProperty(utsDot3OnuMpcpTimeout).setValue(aUtsDot3OnuMpcpTimeout);
  }

  public String getUtsDot3OnuVendor() {
    return (String) getProperty(utsDot3OnuVendor).getValue();
  }

  public void setUtsDot3OnuVendor(String aUtsDot3OnuVendor) {
    getProperty(utsDot3OnuVendor).setValue(aUtsDot3OnuVendor);
  }

  public String getUtsDot3OnuModule() {
    return (String) getProperty(utsDot3OnuModule).getValue();
  }

  public void setUtsDot3OnuModule(String aUtsDot3OnuModule) {
    getProperty(utsDot3OnuModule).setValue(aUtsDot3OnuModule);
  }

  public String getUtsDot3OnuHwVersion2() {
    return (String) getProperty(utsDot3OnuHwVersion2).getValue();
  }

  public void setUtsDot3OnuHwVersion2(String aUtsDot3OnuHwVersion2) {
    getProperty(utsDot3OnuHwVersion2).setValue(aUtsDot3OnuHwVersion2);
  }

  public String getUtsDot3OnuSerialNumber() {
    return (String) getProperty(utsDot3OnuSerialNumber).getValue();
  }

  public void setUtsDot3OnuSerialNumber(String aUtsDot3OnuSerialNumber) {
    getProperty(utsDot3OnuSerialNumber).setValue(aUtsDot3OnuSerialNumber);
  }

  public Integer getUtsDot3OnuLaserOnTime() {
    return (Integer) getProperty(utsDot3OnuLaserOnTime).getValue();
  }

  public void setUtsDot3OnuLaserOnTime(Integer aUtsDot3OnuLaserOnTime) {
    getProperty(utsDot3OnuLaserOnTime).setValue(aUtsDot3OnuLaserOnTime);
  }

  public Integer getUtsDot3OnuLaserOffTime() {
    return (Integer) getProperty(utsDot3OnuLaserOffTime).getValue();
  }

  public void setUtsDot3OnuLaserOffTime(Integer aUtsDot3OnuLaserOffTime) {
    getProperty(utsDot3OnuLaserOffTime).setValue(aUtsDot3OnuLaserOffTime);
  }

  public Integer getUtsDot3OnuDot1adEnable() {
    return (Integer) getProperty(utsDot3OnuDot1adEnable).getValue();
  }

  public void setUtsDot3OnuDot1adEnable(Integer aUtsDot3OnuDot1adEnable) {
    getProperty(utsDot3OnuDot1adEnable).setValue(aUtsDot3OnuDot1adEnable);
  }

  public Integer getUtsDot3OnuDot1adTPID() {
    return (Integer) getProperty(utsDot3OnuDot1adTPID).getValue();
  }

  public void setUtsDot3OnuDot1adTPID(Integer aUtsDot3OnuDot1adTPID) {
    getProperty(utsDot3OnuDot1adTPID).setValue(aUtsDot3OnuDot1adTPID);
  }

  public Integer getUtsDot3OnuReset2() {
    return (Integer) getProperty(utsDot3OnuReset2).getValue();
  }

  public void setUtsDot3OnuReset2(Integer aUtsDot3OnuReset2) {
    getProperty(utsDot3OnuReset2).setValue(aUtsDot3OnuReset2);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuLlid));
    prepareRead(super.getProperty(utsDot3EepromVersion));
    prepareRead(super.getProperty(utsDot3OamVersion));
    prepareRead(super.getProperty(utsDot3OnuMacAddress));
    prepareRead(super.getProperty(utsDot3OnuAdmin));
    prepareRead(super.getProperty(utsDot3OnuTransparentMode));
    prepareRead(super.getProperty(utsDot3OnuStatus));
    prepareRead(super.getProperty(utsDot3OnuMpcpTimeout));
    prepareRead(super.getProperty(utsDot3OnuVendor));
    prepareRead(super.getProperty(utsDot3OnuModule));
    prepareRead(super.getProperty(utsDot3OnuHwVersion2));
    prepareRead(super.getProperty(utsDot3OnuSerialNumber));
    prepareRead(super.getProperty(utsDot3OnuLaserOnTime));
    prepareRead(super.getProperty(utsDot3OnuLaserOffTime));
    prepareRead(super.getProperty(utsDot3OnuDot1adEnable));
    prepareRead(super.getProperty(utsDot3OnuDot1adTPID));
    prepareRead(super.getProperty(utsDot3OnuReset2));

    return load();
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OnuAdmin));
    prepareSave(getProperty(utsDot3OnuTransparentMode));
    prepareSave(getProperty(utsDot3OnuStatus));
    prepareSave(getProperty(utsDot3OnuMpcpTimeout));
    prepareSave(getProperty(utsDot3OnuDot1adEnable));
    prepareSave(getProperty(utsDot3OnuDot1adTPID));
    prepareSave(getProperty(utsDot3OnuReset2));

    return save();
  }


}

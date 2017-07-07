/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;

import java.util.Vector;

/**
 * The Dot3Olt2PortTable class.
 * Created by QuickDVM
 */
public class Dot3Olt2PortTable extends SnmpMibBean {

  public static final String ifIndex = "ifIndex";

  public static final String utsDot3OltModuleId = "utsDot3OltModuleId";
  public static final String utsDot3OltDeviceId = "utsDot3OltDeviceId";
  public static final String utsDot3OltPortId = "utsDot3OltPortId";
  public static final String utsDot3OltOperStatus = "utsDot3OltOperStatus";
  public static final String utsDot3OltAdminStatus = "utsDot3OltAdminStatus";
  public static final String utsDot3OltRegisteredONUCount = "utsDot3OltRegisteredONUCount";
  public static final String utsDot3OltSyncTime = "utsDot3OltSyncTime";
  public static final String utsDot3OltLaserOnTime = "utsDot3OltLaserOnTime";
  public static final String utsDot3OltLaserOffTime = "utsDot3OltLaserOffTime";
  public static final String utsDot3OltRxFECEnable = "utsDot3OltRxFECEnable";
  public static final String utsDot3OltTransceiverTx = "utsDot3OltTransceiverTx";
  public static final String utsDot3OltTransceiverRx = "utsDot3OltTransceiverRx";
//  public static final String utsDot3OltONUP2PEnable = "utsDot3OltONUP2PEnable";
  public static final String utsDot3OltMPCPGateBackoffTime = "utsDot3OltMPCPGateBackoffTime";
  public static final String utsDot3OltP2pEnable = "utsDot3OltP2pEnable";
//  public static final String utsDot3OltOlpPort = "utsDot3OltOlpPort";

  public Dot3Olt2PortTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(utsDot3OltModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDeviceId, new SnmpMibBeanProperty(utsDot3OltDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortId, new SnmpMibBeanProperty(utsDot3OltPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltOperStatus, new SnmpMibBeanProperty(utsDot3OltOperStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltAdminStatus, new SnmpMibBeanProperty(utsDot3OltAdminStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltRegisteredONUCount, new SnmpMibBeanProperty(utsDot3OltRegisteredONUCount, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.10", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltSyncTime, new SnmpMibBeanProperty(utsDot3OltSyncTime, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.11", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltLaserOnTime, new SnmpMibBeanProperty(utsDot3OltLaserOnTime, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.12", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltLaserOffTime, new SnmpMibBeanProperty(utsDot3OltLaserOffTime, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.13", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltRxFECEnable, new SnmpMibBeanProperty(utsDot3OltRxFECEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.14", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltTransceiverTx, new SnmpMibBeanProperty(utsDot3OltTransceiverTx, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.15", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltTransceiverRx, new SnmpMibBeanProperty(utsDot3OltTransceiverRx, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.16", ISnmpConstant.INTEGER));
//    initProperty(utsDot3OltONUP2PEnable, new SnmpMibBeanProperty(utsDot3OltONUP2PEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.17", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltMPCPGateBackoffTime, new SnmpMibBeanProperty(utsDot3OltMPCPGateBackoffTime, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.18", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltP2pEnable, new SnmpMibBeanProperty(utsDot3OltP2pEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.21", ISnmpConstant.INTEGER));
//    initProperty(utsDot3OltOlpPort, new SnmpMibBeanProperty(utsDot3OltOlpPort, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.22", ISnmpConstant.INTEGER));
  }

  public Integer getIfIndex() {
	  return new Integer( ConfigUtility.generateIfIndex( new StringBuffer().append(getUtsDot3OltModuleId()).append("/").append(getUtsDot3OltPortId()).toString() ) );
  }

  public Integer getUtsDot3OltModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OltModuleId(Integer aUtsDot3OltModuleId) {
    setIndex(0, aUtsDot3OltModuleId);
  }


  public Integer getUtsDot3OltDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OltDeviceId(Integer aUtsDot3OltDeviceId) {
    setIndex(1, aUtsDot3OltDeviceId);
  }


  public Integer getUtsDot3OltPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OltPortId(Integer aUtsDot3OltPortId) {
    setIndex(2, aUtsDot3OltPortId);
  }


  public Integer getUtsDot3OltOperStatus() {
    return (Integer) getProperty(utsDot3OltOperStatus).getValue();
  }

  public void setUtsDot3OltOperStatus(Integer aUtsDot3OltOperStatus) {
    getProperty(utsDot3OltOperStatus).setValue(aUtsDot3OltOperStatus);
  }

  public Integer getUtsDot3OltAdminStatus() {
    return (Integer) getProperty(utsDot3OltAdminStatus).getValue();
  }

  public void setUtsDot3OltAdminStatus(Integer aUtsDot3OltAdminStatus) {
    getProperty(utsDot3OltAdminStatus).setValue(aUtsDot3OltAdminStatus);
  }

  public Integer getUtsDot3OltRegisteredONUCount() {
    return (Integer) getProperty(utsDot3OltRegisteredONUCount).getValue();
  }

  public void setUtsDot3OltRegisteredONUCount(Integer aUtsDot3OltRegisteredONUCount) {
    getProperty(utsDot3OltRegisteredONUCount).setValue(aUtsDot3OltRegisteredONUCount);
  }

  public Integer getUtsDot3OltSyncTime() {
    return (Integer) getProperty(utsDot3OltSyncTime).getValue();
  }

  public void setUtsDot3OltSyncTime(Integer aUtsDot3OltSyncTime) {
    getProperty(utsDot3OltSyncTime).setValue(aUtsDot3OltSyncTime);
  }

  public Integer getUtsDot3OltLaserOnTime() {
    return (Integer) getProperty(utsDot3OltLaserOnTime).getValue();
  }

  public void setUtsDot3OltLaserOnTime(Integer aUtsDot3OltLaserOnTime) {
    getProperty(utsDot3OltLaserOnTime).setValue(aUtsDot3OltLaserOnTime);
  }

  public Integer getUtsDot3OltLaserOffTime() {
    return (Integer) getProperty(utsDot3OltLaserOffTime).getValue();
  }

  public void setUtsDot3OltLaserOffTime(Integer aUtsDot3OltLaserOffTime) {
    getProperty(utsDot3OltLaserOffTime).setValue(aUtsDot3OltLaserOffTime);
  }

  public Integer getUtsDot3OltRxFECEnable() {
    return (Integer) getProperty(utsDot3OltRxFECEnable).getValue();
  }

  public void setUtsDot3OltRxFECEnable(Integer aUtsDot3OltRxFECEnable) {
    getProperty(utsDot3OltRxFECEnable).setValue(aUtsDot3OltRxFECEnable);
  }

  public Integer getUtsDot3OltTransceiverTx() {
    return (Integer) getProperty(utsDot3OltTransceiverTx).getValue();
  }

  public void setUtsDot3OltTransceiverTx(Integer aUtsDot3OltTransceiverTx) {
    getProperty(utsDot3OltTransceiverTx).setValue(aUtsDot3OltTransceiverTx);
  }

  public Integer getUtsDot3OltTransceiverRx() {
    return (Integer) getProperty(utsDot3OltTransceiverRx).getValue();
  }

  public void setUtsDot3OltTransceiverRx(Integer aUtsDot3OltTransceiverRx) {
    getProperty(utsDot3OltTransceiverRx).setValue(aUtsDot3OltTransceiverRx);
  }

//  public Integer getUtsDot3OltONUP2PEnable() {
//    return (Integer) getProperty(utsDot3OltONUP2PEnable).getValue();
//  }
//
//  public void setUtsDot3OltONUP2PEnable(Integer aUtsDot3OltONUP2PEnable) {
//    getProperty(utsDot3OltONUP2PEnable).setValue(aUtsDot3OltONUP2PEnable);
//  }

  public Integer getUtsDot3OltMPCPGateBackoffTime() {
    return (Integer) getProperty(utsDot3OltMPCPGateBackoffTime).getValue();
  }

  public void setUtsDot3OltMPCPGateBackoffTime(Integer aUtsDot3OltMPCPGateBackoffTime) {
    getProperty(utsDot3OltMPCPGateBackoffTime).setValue(aUtsDot3OltMPCPGateBackoffTime);
  }

  public Integer getUtsDot3OltP2pEnable() {
    return (Integer)getProperty(utsDot3OltP2pEnable).getValue();
  }

  public void setUtsDot3OltP2pEnable(Integer aUtsDot3OltP2pEnable) {
    getProperty(utsDot3OltP2pEnable).setValue(aUtsDot3OltP2pEnable);
  }

//  public Integer getUtsDot3OltOlpPort() {
//    return (Integer)getProperty(utsDot3OltOlpPort).getValue();
//  }
//
//  public void setUtsDot3OltOlpPort(Integer aUtsDot3OltOlpPort) {
//    getProperty(utsDot3OltOlpPort).setValue(aUtsDot3OltOlpPort);
//  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltOperStatus));
    prepareRead(super.getProperty(utsDot3OltAdminStatus));
    prepareRead(super.getProperty(utsDot3OltRegisteredONUCount));
    prepareRead(super.getProperty(utsDot3OltSyncTime));
    prepareRead(super.getProperty(utsDot3OltLaserOnTime));
    prepareRead(super.getProperty(utsDot3OltLaserOffTime));
    prepareRead(super.getProperty(utsDot3OltRxFECEnable));
    prepareRead(super.getProperty(utsDot3OltTransceiverTx));
    prepareRead(super.getProperty(utsDot3OltTransceiverRx));
//    prepareRead(super.getProperty(utsDot3OltONUP2PEnable));
    prepareRead(super.getProperty(utsDot3OltMPCPGateBackoffTime));
    prepareRead(super.getProperty(utsDot3OltP2pEnable));
//    prepareRead(super.getProperty(utsDot3OltOlpPort));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltOperStatus));
    prepareRead(super.getProperty(utsDot3OltAdminStatus));
    prepareRead(super.getProperty(utsDot3OltRegisteredONUCount));
    prepareRead(super.getProperty(utsDot3OltSyncTime));
    prepareRead(super.getProperty(utsDot3OltLaserOnTime));
    prepareRead(super.getProperty(utsDot3OltLaserOffTime));
    prepareRead(super.getProperty(utsDot3OltRxFECEnable));
    prepareRead(super.getProperty(utsDot3OltTransceiverTx));
    prepareRead(super.getProperty(utsDot3OltTransceiverRx));
//    prepareRead(super.getProperty(utsDot3OltONUP2PEnable));
    prepareRead(super.getProperty(utsDot3OltMPCPGateBackoffTime));
    prepareRead(super.getProperty(utsDot3OltP2pEnable));
//    prepareRead(super.getProperty(utsDot3OltOlpPort));

    return loadAll(new int[]{1
                             , 1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OltAdminStatus));
    prepareSave(getProperty(utsDot3OltRxFECEnable));
    prepareSave(getProperty(utsDot3OltTransceiverTx));
    prepareSave(getProperty(utsDot3OltTransceiverRx));
//    prepareSave(getProperty(utsDot3OltONUP2PEnable));
    prepareSave(getProperty(utsDot3OltMPCPGateBackoffTime));
    prepareSave(getProperty(utsDot3OltP2pEnable));
//    prepareSave(getProperty(utsDot3OltOlpPort));

    return save();
  }


}
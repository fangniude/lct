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

import java.util.Vector;

/**
 * The Dot3Olt2Table class.
 * Created by QuickDVM
 */
public class Dot3Olt2Table extends SnmpMibBean {
  public static final String utsDot3OltModuleId = "utsDot3OltModuleId";
  public static final String utsDot3OltDeviceId = "utsDot3OltDeviceId";
  public static final String utsDot3OltStatus = "utsDot3OltStatus";
  public static final String utsDot3OltMACAddress = "utsDot3OltMACAddress";
  public static final String utsDot3OltPortIsolation = "utsDot3OltPortIsolation";
  public static final String utsDot3OltDot1adEnable = "utsDot3OltDot1adEnable";
  public static final String utsDot3OltDot1adTPID = "utsDot3OltDot1adTPID";
  public static final String utsDot3OltDot1xMode = "utsDot3OltDot1xMode";
  public static final String utsDot3OltMPCPTimeout = "utsDot3OltMPCPTimeout";
  public static final String utsDot3OltNNIFlowControlTxEnable = "utsDot3OltNNIFlowControlTxEnable";
  public static final String utsDot3OltNNIFlowControlRxEnable = "utsDot3OltNNIFlowControlRxEnable";
  public static final String utsDot3OltNNIFlowControlLowTreshold = "utsDot3OltNNIFlowControlLowTreshold";
  public static final String utsDot3OltNNIFlowControlHighTreshold = "utsDot3OltNNIFlowControlHighTreshold";
  public static final String utsDot3OltEncryptionMode = "utsDot3OltEncryptionMode";
  public static final String utsDot3OltEncryptionRekeyTimer = "utsDot3OltEncryptionRekeyTimer";

  public Dot3Olt2Table(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(utsDot3OltModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDeviceId, new SnmpMibBeanProperty(utsDot3OltDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltStatus, new SnmpMibBeanProperty(utsDot3OltStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltMACAddress, new SnmpMibBeanProperty(utsDot3OltMACAddress, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.4", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsDot3OltPortIsolation, new SnmpMibBeanProperty(utsDot3OltPortIsolation, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDot1adEnable, new SnmpMibBeanProperty(utsDot3OltDot1adEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDot1adTPID, new SnmpMibBeanProperty(utsDot3OltDot1adTPID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.8", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDot1xMode, new SnmpMibBeanProperty(utsDot3OltDot1xMode, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.9", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltMPCPTimeout, new SnmpMibBeanProperty(utsDot3OltMPCPTimeout, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.10", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltNNIFlowControlTxEnable, new SnmpMibBeanProperty(utsDot3OltNNIFlowControlTxEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.11", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltNNIFlowControlRxEnable, new SnmpMibBeanProperty(utsDot3OltNNIFlowControlRxEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.12", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltNNIFlowControlLowTreshold, new SnmpMibBeanProperty(utsDot3OltNNIFlowControlLowTreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.13", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltNNIFlowControlHighTreshold, new SnmpMibBeanProperty(utsDot3OltNNIFlowControlHighTreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.14", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltEncryptionMode, new SnmpMibBeanProperty(utsDot3OltEncryptionMode, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.16", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltEncryptionRekeyTimer, new SnmpMibBeanProperty(utsDot3OltEncryptionRekeyTimer, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.1.1.17", ISnmpConstant.INTEGER));
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


  public Integer getUtsDot3OltStatus() {
    return (Integer) getProperty(utsDot3OltStatus).getValue();
  }

  public void setUtsDot3OltStatus(Integer aUtsDot3OltStatus) {
    getProperty(utsDot3OltStatus).setValue(aUtsDot3OltStatus);
  }

  public byte[] getUtsDot3OltMACAddress() {
    return (byte[]) getProperty(utsDot3OltMACAddress).getValue();
  }

  public void setUtsDot3OltMACAddress(byte[] aUtsDot3OltMACAddress) {
    getProperty(utsDot3OltMACAddress).setValue(aUtsDot3OltMACAddress);
  }

  public Integer getUtsDot3OltPortIsolation() {
    return (Integer) getProperty(utsDot3OltPortIsolation).getValue();
  }

  public void setUtsDot3OltPortIsolation(Integer aUtsDot3OltPortIsolation) {
    getProperty(utsDot3OltPortIsolation).setValue(aUtsDot3OltPortIsolation);
  }

  public Integer getUtsDot3OltDot1adEnable() {
    return (Integer) getProperty(utsDot3OltDot1adEnable).getValue();
  }

  public void setUtsDot3OltDot1adEnable(Integer aUtsDot3OltDot1adEnable) {
    getProperty(utsDot3OltDot1adEnable).setValue(aUtsDot3OltDot1adEnable);
  }

  public Integer getUtsDot3OltDot1adTPID() {
    return (Integer) getProperty(utsDot3OltDot1adTPID).getValue();
  }

  public void setUtsDot3OltDot1adTPID(Integer aUtsDot3OltDot1adTPID) {
    getProperty(utsDot3OltDot1adTPID).setValue(aUtsDot3OltDot1adTPID);
  }

  public Integer getUtsDot3OltDot1xMode() {
    return (Integer) getProperty(utsDot3OltDot1xMode).getValue();
  }

  public void setUtsDot3OltDot1xMode(Integer aUtsDot3OltDot1xMode) {
    getProperty(utsDot3OltDot1xMode).setValue(aUtsDot3OltDot1xMode);
  }

  public Integer getUtsDot3OltMPCPTimeout() {
    return (Integer) getProperty(utsDot3OltMPCPTimeout).getValue();
  }

  public void setUtsDot3OltMPCPTimeout(Integer aUtsDot3OltMPCPTimeout) {
    getProperty(utsDot3OltMPCPTimeout).setValue(aUtsDot3OltMPCPTimeout);
  }

  public Integer getUtsDot3OltNNIFlowControlTxEnable() {
    return (Integer) getProperty(utsDot3OltNNIFlowControlTxEnable).getValue();
  }

  public void setUtsDot3OltNNIFlowControlTxEnable(Integer aUtsDot3OltNNIFlowControlTxEnable) {
    getProperty(utsDot3OltNNIFlowControlTxEnable).setValue(aUtsDot3OltNNIFlowControlTxEnable);
  }

  public Integer getUtsDot3OltNNIFlowControlRxEnable() {
    return (Integer) getProperty(utsDot3OltNNIFlowControlRxEnable).getValue();
  }

  public void setUtsDot3OltNNIFlowControlRxEnable(Integer aUtsDot3OltNNIFlowControlRxEnable) {
    getProperty(utsDot3OltNNIFlowControlRxEnable).setValue(aUtsDot3OltNNIFlowControlRxEnable);
  }

  public Integer getUtsDot3OltNNIFlowControlLowTreshold() {
    return (Integer) getProperty(utsDot3OltNNIFlowControlLowTreshold).getValue();
  }

  public void setUtsDot3OltNNIFlowControlLowTreshold(Integer aUtsDot3OltNNIFlowControlLowTreshold) {
    getProperty(utsDot3OltNNIFlowControlLowTreshold).setValue(aUtsDot3OltNNIFlowControlLowTreshold);
  }

  public Integer getUtsDot3OltNNIFlowControlHighTreshold() {
    return (Integer) getProperty(utsDot3OltNNIFlowControlHighTreshold).getValue();
  }

  public void setUtsDot3OltNNIFlowControlHighTreshold(Integer aUtsDot3OltNNIFlowControlHighTreshold) {
    getProperty(utsDot3OltNNIFlowControlHighTreshold).setValue(aUtsDot3OltNNIFlowControlHighTreshold);
  }

  public Integer getUtsDot3OltEncryptionMode() {
    return (Integer) getProperty(utsDot3OltEncryptionMode).getValue();
  }

  public void setUtsDot3OltEncryptionMode(Integer aUtsDot3OltEncryptionMode) {
    getProperty(utsDot3OltEncryptionMode).setValue(aUtsDot3OltEncryptionMode);
  }

  public Integer getUtsDot3OltEncryptionRekeyTimer() {
    return (Integer) getProperty(utsDot3OltEncryptionRekeyTimer).getValue();
  }

  public void setUtsDot3OltEncryptionRekeyTimer(Integer aUtsDot3OltEncryptionRekeyTimer) {
    getProperty(utsDot3OltEncryptionRekeyTimer).setValue(aUtsDot3OltEncryptionRekeyTimer);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltStatus));
    prepareRead(super.getProperty(utsDot3OltMACAddress));
    prepareRead(super.getProperty(utsDot3OltPortIsolation));
    prepareRead(super.getProperty(utsDot3OltDot1adEnable));
    prepareRead(super.getProperty(utsDot3OltDot1adTPID));
    prepareRead(super.getProperty(utsDot3OltDot1xMode));
    prepareRead(super.getProperty(utsDot3OltMPCPTimeout));
    prepareRead(super.getProperty(utsDot3OltNNIFlowControlTxEnable));
    prepareRead(super.getProperty(utsDot3OltNNIFlowControlRxEnable));
    prepareRead(super.getProperty(utsDot3OltNNIFlowControlLowTreshold));
    prepareRead(super.getProperty(utsDot3OltNNIFlowControlHighTreshold));
    prepareRead(super.getProperty(utsDot3OltEncryptionMode));
    prepareRead(super.getProperty(utsDot3OltEncryptionRekeyTimer));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltStatus));
    prepareRead(super.getProperty(utsDot3OltMACAddress));
    prepareRead(super.getProperty(utsDot3OltPortIsolation));
    prepareRead(super.getProperty(utsDot3OltDot1adEnable));
//    prepareRead(super.getProperty(utsDot3OltDot1adTPID));
    prepareRead(super.getProperty(utsDot3OltDot1xMode));
    prepareRead(super.getProperty(utsDot3OltMPCPTimeout));
    prepareRead(super.getProperty(utsDot3OltNNIFlowControlTxEnable));
    prepareRead(super.getProperty(utsDot3OltNNIFlowControlRxEnable));
    prepareRead(super.getProperty(utsDot3OltNNIFlowControlLowTreshold));
    prepareRead(super.getProperty(utsDot3OltNNIFlowControlHighTreshold));
    prepareRead(super.getProperty(utsDot3OltEncryptionMode));
    prepareRead(super.getProperty(utsDot3OltEncryptionRekeyTimer));

//    setRowsToFetch(1);
    return loadAll(new int[]{1, 1 });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OltPortIsolation));
    prepareSave(getProperty(utsDot3OltDot1adEnable));
    prepareSave(getProperty(utsDot3OltDot1adTPID));
    prepareSave(getProperty(utsDot3OltEncryptionMode));
    prepareSave(getProperty(utsDot3OltEncryptionRekeyTimer));

    return save();
  }
}

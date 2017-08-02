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

import java.util.Vector;

/**
 * The Dot3Olt2QosGlbTable class.
 * Created by QuickDVM
 */
public class Dot3Olt2QosGlbTable extends SnmpMibBean {
  public static final String utsDot3OltModuleId = "utsDot3OltModuleId";
  public static final String utsDot3OltDeviceId = "utsDot3OltDeviceId";
  public static final String utsDot3OltQoSMode = "utsDot3OltQoSMode";
  public static final String utsDot3OltQoSL2OverheadInclude = "utsDot3OltQoSL2OverheadInclude";
  public static final String utsDot3OltWREDEnable = "utsDot3OltWREDEnable";
  public static final String utsDot3OltSchedulingMode = "utsDot3OltSchedulingMode";
  public static final String utsDot3OltSchedulingWeight = "utsDot3OltSchedulingWeight";
  public static final String utsDot3OltDot1p2QueueMap = "utsDot3OltDot1p2QueueMap";
  public static final String utsDot3OltDscp2QueueMap = "utsDot3OltDscp2QueueMap";
  public static final String utsDot3OltDefaultTx802Dot1pValue = "utsDot3OltDefaultTx802Dot1pValue";
  public static final String utsDot3OltDefaultCosQueue = "utsDot3OltDefaultCosQueue";
  public static final String utsDot3OltTxDot1pRemark = "utsDot3OltTxDot1pRemark";
  public static final String utsDot3OltTxDscpRemark = "utsDot3OltTxDscpRemark";

  public Dot3Olt2QosGlbTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(utsDot3OltModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDeviceId, new SnmpMibBeanProperty(utsDot3OltDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltQoSMode, new SnmpMibBeanProperty(utsDot3OltQoSMode, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltQoSL2OverheadInclude, new SnmpMibBeanProperty(utsDot3OltQoSL2OverheadInclude, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltWREDEnable, new SnmpMibBeanProperty(utsDot3OltWREDEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltSchedulingMode, new SnmpMibBeanProperty(utsDot3OltSchedulingMode, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltSchedulingWeight, new SnmpMibBeanProperty(utsDot3OltSchedulingWeight, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.7", ISnmpConstant.OCTETS));
    initProperty(utsDot3OltDot1p2QueueMap, new SnmpMibBeanProperty(utsDot3OltDot1p2QueueMap, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.8", ISnmpConstant.OCTETS));
    initProperty(utsDot3OltDscp2QueueMap, new SnmpMibBeanProperty(utsDot3OltDscp2QueueMap, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.9", ISnmpConstant.OCTETS));
    initProperty(utsDot3OltDefaultTx802Dot1pValue, new SnmpMibBeanProperty(utsDot3OltDefaultTx802Dot1pValue, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.10", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDefaultCosQueue, new SnmpMibBeanProperty(utsDot3OltDefaultCosQueue, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.11", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltTxDot1pRemark, new SnmpMibBeanProperty(utsDot3OltTxDot1pRemark, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.12", ISnmpConstant.OCTETS));
    initProperty(utsDot3OltTxDscpRemark, new SnmpMibBeanProperty(utsDot3OltTxDscpRemark, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.3.1.13", ISnmpConstant.OCTETS));
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


  public Integer getUtsDot3OltQoSMode() {
    return (Integer) getProperty(utsDot3OltQoSMode).getValue();
  }

  public void setUtsDot3OltQoSMode(Integer aUtsDot3OltQoSMode) {
    getProperty(utsDot3OltQoSMode).setValue(aUtsDot3OltQoSMode);
  }

  public Integer getUtsDot3OltQoSL2OverheadInclude() {
    return (Integer) getProperty(utsDot3OltQoSL2OverheadInclude).getValue();
  }

  public void setUtsDot3OltQoSL2OverheadInclude(Integer aUtsDot3OltQoSL2OverheadInclude) {
    getProperty(utsDot3OltQoSL2OverheadInclude).setValue(aUtsDot3OltQoSL2OverheadInclude);
  }

  public Integer getUtsDot3OltWREDEnable() {
    return (Integer) getProperty(utsDot3OltWREDEnable).getValue();
  }

  public void setUtsDot3OltWREDEnable(Integer aUtsDot3OltWREDEnable) {
    getProperty(utsDot3OltWREDEnable).setValue(aUtsDot3OltWREDEnable);
  }

  public Integer getUtsDot3OltSchedulingMode() {
    return (Integer) getProperty(utsDot3OltSchedulingMode).getValue();
  }

  public void setUtsDot3OltSchedulingMode(Integer aUtsDot3OltSchedulingMode) {
    getProperty(utsDot3OltSchedulingMode).setValue(aUtsDot3OltSchedulingMode);
  }

  public byte[] getUtsDot3OltSchedulingWeight() {
    return (byte[]) getProperty(utsDot3OltSchedulingWeight).getValue();
  }

  public void setUtsDot3OltSchedulingWeight(byte[] aUtsDot3OltSchedulingWeight) {
    getProperty(utsDot3OltSchedulingWeight).setValue(aUtsDot3OltSchedulingWeight);
  }

  public byte[] getUtsDot3OltDot1p2QueueMap() {
    return (byte[]) getProperty(utsDot3OltDot1p2QueueMap).getValue();
  }

  public void setUtsDot3OltDot1p2QueueMap(byte[] aUtsDot3OltDot1p2QueueMap) {
    getProperty(utsDot3OltDot1p2QueueMap).setValue(aUtsDot3OltDot1p2QueueMap);
  }

  public byte[] getUtsDot3OltDscp2QueueMap() {
    return (byte[]) getProperty(utsDot3OltDscp2QueueMap).getValue();
  }

  public void setUtsDot3OltDscp2QueueMap(byte[] aUtsDot3OltDscp2QueueMap) {
    getProperty(utsDot3OltDscp2QueueMap).setValue(aUtsDot3OltDscp2QueueMap);
  }

  public Integer getUtsDot3OltDefaultTx802Dot1pValue() {
    return (Integer) getProperty(utsDot3OltDefaultTx802Dot1pValue).getValue();
  }

  public void setUtsDot3OltDefaultTx802Dot1pValue(Integer aUtsDot3OltDefaultTx802Dot1pValue) {
    getProperty(utsDot3OltDefaultTx802Dot1pValue).setValue(aUtsDot3OltDefaultTx802Dot1pValue);
  }

  public Integer getUtsDot3OltDefaultCosQueue() {
    return (Integer) getProperty(utsDot3OltDefaultCosQueue).getValue();
  }

  public void setUtsDot3OltDefaultCosQueue(Integer aUtsDot3OltDefaultCosQueue) {
    getProperty(utsDot3OltDefaultCosQueue).setValue(aUtsDot3OltDefaultCosQueue);
  }

  public byte[] getUtsDot3OltTxDot1pRemark() {
      return (byte[]) getProperty(utsDot3OltTxDot1pRemark).getValue();
  }

  public void setUtsDot3OltTxDot1pRemark(byte[] autsDot3OltTxDot1pRemark) {
      getProperty(utsDot3OltTxDot1pRemark).setValue(autsDot3OltTxDot1pRemark);
  }

  public byte[] getUtsDot3OltTxDscpRemark() {
      return (byte[]) getProperty(utsDot3OltTxDscpRemark).getValue();
  }

  public void setUtsDot3OltTxDscpRemark(byte[] autsDot3OltTxDscpRemark) {
      getProperty(utsDot3OltTxDscpRemark).setValue(autsDot3OltTxDscpRemark);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltQoSMode));
    prepareRead(super.getProperty(utsDot3OltQoSL2OverheadInclude));
    prepareRead(super.getProperty(utsDot3OltWREDEnable));
    prepareRead(super.getProperty(utsDot3OltSchedulingMode));
    prepareRead(super.getProperty(utsDot3OltSchedulingWeight));
    prepareRead(super.getProperty(utsDot3OltDot1p2QueueMap));
    prepareRead(super.getProperty(utsDot3OltDscp2QueueMap));
    prepareRead(super.getProperty(utsDot3OltDefaultTx802Dot1pValue));
    prepareRead(super.getProperty(utsDot3OltDefaultCosQueue));
    prepareRead(super.getProperty(utsDot3OltTxDot1pRemark));
    prepareRead(super.getProperty(utsDot3OltTxDscpRemark));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltQoSMode));
    prepareRead(super.getProperty(utsDot3OltQoSL2OverheadInclude));
    prepareRead(super.getProperty(utsDot3OltWREDEnable));
    prepareRead(super.getProperty(utsDot3OltSchedulingMode));
    prepareRead(super.getProperty(utsDot3OltSchedulingWeight));
    prepareRead(super.getProperty(utsDot3OltDot1p2QueueMap));
    prepareRead(super.getProperty(utsDot3OltDscp2QueueMap));
    prepareRead(super.getProperty(utsDot3OltDefaultTx802Dot1pValue));
    prepareRead(super.getProperty(utsDot3OltDefaultCosQueue));
    prepareRead(super.getProperty(utsDot3OltTxDot1pRemark));
    prepareRead(super.getProperty(utsDot3OltTxDscpRemark));

    return loadAll(new int[]{1 , 1 });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OltQoSMode));
    prepareSave(getProperty(utsDot3OltQoSL2OverheadInclude));
    prepareSave(getProperty(utsDot3OltWREDEnable));
    prepareSave(getProperty(utsDot3OltSchedulingMode));
    prepareSave(getProperty(utsDot3OltSchedulingWeight));
    prepareSave(getProperty(utsDot3OltDot1p2QueueMap));
    prepareSave(getProperty(utsDot3OltDscp2QueueMap));
    prepareSave(getProperty(utsDot3OltDefaultTx802Dot1pValue));
    prepareSave(getProperty(utsDot3OltDefaultCosQueue));
    prepareSave(getProperty(utsDot3OltTxDot1pRemark));
    prepareSave(getProperty(utsDot3OltTxDscpRemark));

    return save();
  }


}

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
 * The Dot3Onu2CtcLpBkTable class.
 * Created by QuickDVM
 */
public class Dot3Onu2CtcLpBkTable extends SnmpMibBean {
  public static final String utsDot3OnuLpBkModuleId = "utsDot3OnuLpBkModuleId";
  public static final String utsDot3OnuLpBkDeviceId = "utsDot3OnuLpBkDeviceId";
  public static final String utsDot3OnuLpBkPortId = "utsDot3OnuLpBkPortId";
  public static final String utsDot3OnuLpBkLogicalPortId = "utsDot3OnuLpBkLogicalPortId";
  public static final String utsDot3OnuLpBkMode = "utsDot3OnuLpBkMode";
  public static final String utsDot3OnuLpBkPacketSize = "utsDot3OnuLpBkPacketSize";
  public static final String utsDot3OnuLpBkPacketNum = "utsDot3OnuLpBkPacketNum";
  public static final String utsDot3OnuLpBkStart = "utsDot3OnuLpBkStart";
  public static final String utsDot3OnuLpBkEnd = "utsDot3OnuLpBkEnd";
  public static final String utsDot3OnuLpBkResult = "utsDot3OnuLpBkResult";


  public Dot3Onu2CtcLpBkTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuLpBkModuleId, new SnmpMibBeanProperty(utsDot3OnuLpBkModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkDeviceId, new SnmpMibBeanProperty(utsDot3OnuLpBkDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkPortId, new SnmpMibBeanProperty(utsDot3OnuLpBkPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLpBkLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkMode, new SnmpMibBeanProperty(utsDot3OnuLpBkMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkPacketSize, new SnmpMibBeanProperty(utsDot3OnuLpBkPacketSize, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkPacketNum, new SnmpMibBeanProperty(utsDot3OnuLpBkPacketNum, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkStart, new SnmpMibBeanProperty(utsDot3OnuLpBkStart, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.8", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkEnd, new SnmpMibBeanProperty(utsDot3OnuLpBkEnd, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.9", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLpBkResult, new SnmpMibBeanProperty(utsDot3OnuLpBkResult, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.10", ISnmpConstant.STRING));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.15.1.11", ISnmpConstant.INTEGER));

  }


  public Integer getUtsDot3OnuLpBkModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuLpBkModuleId(Integer aUtsDot3OnuLpBkModuleId) {
    setIndex(0, aUtsDot3OnuLpBkModuleId);
  }


  public Integer getUtsDot3OnuLpBkDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuLpBkDeviceId(Integer aUtsDot3OnuLpBkDeviceId) {
    setIndex(1, aUtsDot3OnuLpBkDeviceId);
  }


  public Integer getUtsDot3OnuLpBkPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OnuLpBkPortId(Integer aUtsDot3OnuLpBkPortId) {
    setIndex(2, aUtsDot3OnuLpBkPortId);
  }


  public Integer getUtsDot3OnuLpBkLogicalPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3OnuLpBkLogicalPortId(Integer aUtsDot3OnuLpBkLogicalPortId) {
    setIndex(3, aUtsDot3OnuLpBkLogicalPortId);
  }


  public Integer getUtsDot3OnuLpBkMode() {
    return (Integer) getProperty(utsDot3OnuLpBkMode).getValue();
  }

  public void setUtsDot3OnuLpBkMode(Integer aUtsDot3OnuLpBkMode) {
    getProperty(utsDot3OnuLpBkMode).setValue(aUtsDot3OnuLpBkMode);
  }

  public Integer getUtsDot3OnuLpBkPacketSize() {
    return (Integer) getProperty(utsDot3OnuLpBkPacketSize).getValue();
  }

  public void setUtsDot3OnuLpBkPacketSize(Integer aUtsDot3OnuLpBkPacketSize) {
    getProperty(utsDot3OnuLpBkPacketSize).setValue(aUtsDot3OnuLpBkPacketSize);
  }

  public Integer getUtsDot3OnuLpBkPacketNum() {
    return (Integer) getProperty(utsDot3OnuLpBkPacketNum).getValue();
  }

  public void setUtsDot3OnuLpBkPacketNum(Integer aUtsDot3OnuLpBkPacketNum) {
    getProperty(utsDot3OnuLpBkPacketNum).setValue(aUtsDot3OnuLpBkPacketNum);
  }

  public Integer getUtsDot3OnuLpBkStart() {
    return (Integer) getProperty(utsDot3OnuLpBkStart).getValue();
  }

  public void setUtsDot3OnuLpBkStart(Integer aUtsDot3OnuLpBkStart) {
    getProperty(utsDot3OnuLpBkStart).setValue(aUtsDot3OnuLpBkStart);
  }

  public Integer getUtsDot3OnuLpBkEnd() {
    return (Integer) getProperty(utsDot3OnuLpBkEnd).getValue();
  }

  public void setUtsDot3OnuLpBkEnd(Integer aUtsDot3OnuLpBkEnd) {
    getProperty(utsDot3OnuLpBkEnd).setValue(aUtsDot3OnuLpBkEnd);
  }

  public String getUtsDot3OnuLpBkResult() {
    return (String) getProperty(utsDot3OnuLpBkResult).getValue();
  }

  public void setUtsDot3OnuLpBkResult(String aUtsDot3OnuLpBkResult) {
    getProperty(utsDot3OnuLpBkResult).setValue(aUtsDot3OnuLpBkResult);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuLpBkMode));
    prepareRead(super.getProperty(utsDot3OnuLpBkPacketSize));
    prepareRead(super.getProperty(utsDot3OnuLpBkPacketNum));
    prepareRead(super.getProperty(utsDot3OnuLpBkStart));
    prepareRead(super.getProperty(utsDot3OnuLpBkEnd));
    prepareRead(super.getProperty(utsDot3OnuLpBkResult));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuLpBkMode));
    prepareRead(super.getProperty(utsDot3OnuLpBkPacketSize));
    prepareRead(super.getProperty(utsDot3OnuLpBkPacketNum));
    prepareRead(super.getProperty(utsDot3OnuLpBkStart));
    prepareRead(super.getProperty(utsDot3OnuLpBkEnd));
    prepareRead(super.getProperty(utsDot3OnuLpBkResult));


    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OnuLpBkMode));
    prepareSave(getProperty(utsDot3OnuLpBkPacketSize));
    prepareSave(getProperty(utsDot3OnuLpBkPacketNum));
    prepareSave(getProperty(utsDot3OnuLpBkStart));
    prepareSave(getProperty(utsDot3OnuLpBkEnd));

    return save();
  }


  public boolean add() throws MibBeanException {
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(utsDot3OnuLpBkMode));
    prepareSave(getProperty(utsDot3OnuLpBkPacketSize));
    prepareSave(getProperty(utsDot3OnuLpBkPacketNum));
    prepareSave(getProperty(utsDot3OnuLpBkStart));
    prepareSave(getProperty(utsDot3OnuLpBkEnd));
    prepareSave(getProperty(ROW_STATUS));

    return save();
  }


  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

}

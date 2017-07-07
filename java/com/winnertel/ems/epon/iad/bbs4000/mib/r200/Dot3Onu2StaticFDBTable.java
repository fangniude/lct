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
 * The Dot3Onu2StaticFDBTable class.
 * Created by QuickDVM
 */
public class Dot3Onu2StaticFDBTable extends SnmpMibBean {
  public static final String utsDot3OnuStaticFDBModuleId = "utsDot3OnuStaticFDBModuleId";
  public static final String utsDot3OnuStaticFDBDeviceId = "utsDot3OnuStaticFDBDeviceId";
  public static final String utsDot3OnuStaticFDBPortId = "utsDot3OnuStaticFDBPortId";
  public static final String utsDot3OnuStaticFDBLPortId = "utsDot3OnuStaticFDBLPortId";
  public static final String utsDot3OnuStaticFDBDstMacAddr = "utsDot3OnuStaticFDBDstMacAddr";
  public static final String utsDot3OnuStaticFDBVlanId = "utsDot3OnuStaticFDBVlanId";
  public static final String utsDot3OnuStaticFDBEgressPort = "utsDot3OnuStaticFDBEgressPort";
  public static final String utsDot3OnuStaticFDBFunction = "utsDot3OnuStaticFDBFunction";


  public Dot3Onu2StaticFDBTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuStaticFDBModuleId, new SnmpMibBeanProperty(utsDot3OnuStaticFDBModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuStaticFDBDeviceId, new SnmpMibBeanProperty(utsDot3OnuStaticFDBDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuStaticFDBPortId, new SnmpMibBeanProperty(utsDot3OnuStaticFDBPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuStaticFDBLPortId, new SnmpMibBeanProperty(utsDot3OnuStaticFDBLPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuStaticFDBDstMacAddr, new SnmpMibBeanProperty(utsDot3OnuStaticFDBDstMacAddr, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.5", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsDot3OnuStaticFDBVlanId, new SnmpMibBeanProperty(utsDot3OnuStaticFDBVlanId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuStaticFDBEgressPort, new SnmpMibBeanProperty(utsDot3OnuStaticFDBEgressPort, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuStaticFDBFunction, new SnmpMibBeanProperty(utsDot3OnuStaticFDBFunction, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.8", ISnmpConstant.INTEGER));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.18.1.9", ISnmpConstant.INTEGER));
  }


  public Integer getUtsDot3OnuStaticFDBModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuStaticFDBModuleId(Integer aUtsDot3OnuStaticFDBModuleId) {
    setIndex(0, aUtsDot3OnuStaticFDBModuleId);
  }


  public Integer getUtsDot3OnuStaticFDBDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuStaticFDBDeviceId(Integer aUtsDot3OnuStaticFDBDeviceId) {
    setIndex(1, aUtsDot3OnuStaticFDBDeviceId);
  }


  public Integer getUtsDot3OnuStaticFDBPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OnuStaticFDBPortId(Integer aUtsDot3OnuStaticFDBPortId) {
    setIndex(2, aUtsDot3OnuStaticFDBPortId);
  }


  public Integer getUtsDot3OnuStaticFDBLPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3OnuStaticFDBLPortId(Integer aUtsDot3OnuStaticFDBLPortId) {
    setIndex(3, aUtsDot3OnuStaticFDBLPortId);
  }


  public byte[] getUtsDot3OnuStaticFDBDstMacAddr() {
    return (byte[]) getProperty(utsDot3OnuStaticFDBDstMacAddr).getValue();
  }

  public void setUtsDot3OnuStaticFDBDstMacAddr(byte[] aUtsDot3OnuStaticFDBDstMacAddr) {
    getProperty(utsDot3OnuStaticFDBDstMacAddr).setValue(aUtsDot3OnuStaticFDBDstMacAddr);
  }

  public Integer getUtsDot3OnuStaticFDBVlanId() {
    return (Integer) getProperty(utsDot3OnuStaticFDBVlanId).getValue();
  }

  public void setUtsDot3OnuStaticFDBVlanId(Integer aUtsDot3OnuStaticFDBVlanId) {
    getProperty(utsDot3OnuStaticFDBVlanId).setValue(aUtsDot3OnuStaticFDBVlanId);
  }

  public Integer getUtsDot3OnuStaticFDBEgressPort() {
    return (Integer) getProperty(utsDot3OnuStaticFDBEgressPort).getValue();
  }

  public void setUtsDot3OnuStaticFDBEgressPort(Integer aUtsDot3OnuStaticFDBEgressPort) {
    getProperty(utsDot3OnuStaticFDBEgressPort).setValue(aUtsDot3OnuStaticFDBEgressPort);
  }

  public Integer getUtsDot3OnuStaticFDBFunction() {
    return (Integer) getProperty(utsDot3OnuStaticFDBFunction).getValue();
  }

  public void setUtsDot3OnuStaticFDBFunction(Integer aUtsDot3OnuStaticFDBFunction) {
    getProperty(utsDot3OnuStaticFDBFunction).setValue(aUtsDot3OnuStaticFDBFunction);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuStaticFDBDstMacAddr));
    prepareRead(super.getProperty(utsDot3OnuStaticFDBVlanId));
    prepareRead(super.getProperty(utsDot3OnuStaticFDBEgressPort));
    prepareRead(super.getProperty(utsDot3OnuStaticFDBFunction));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuStaticFDBDstMacAddr));
    prepareRead(super.getProperty(utsDot3OnuStaticFDBVlanId));
    prepareRead(super.getProperty(utsDot3OnuStaticFDBEgressPort));
    prepareRead(super.getProperty(utsDot3OnuStaticFDBFunction));


    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
    });
  }


  public boolean add() throws MibBeanException {
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(utsDot3OnuStaticFDBDstMacAddr));
    prepareSave(getProperty(utsDot3OnuStaticFDBVlanId));
    prepareSave(getProperty(utsDot3OnuStaticFDBEgressPort));
    prepareSave(getProperty(utsDot3OnuStaticFDBFunction));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }


  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

}

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
 * The Dot3Onu2FDBTable class.
 * Created by QuickDVM
 */
public class Dot3Onu2FDBTable extends SnmpMibBean {
  public static final String utsDot3OnuFDBModuleId = "utsDot3OnuFDBModuleId";
  public static final String utsDot3OnuFDBDeviceId = "utsDot3OnuFDBDeviceId";
  public static final String utsDot3OnuFDBLPortId = "utsDot3OnuFDBLPortId";
  public static final String utsDot3OnuFDBPortId = "utsDot3OnuFDBPortId";
  public static final String utsDot3OnuFDBIndex = "utsDot3OnuFDBIndex";
  public static final String utsDot3OnuFDBDstMacAddr = "utsDot3OnuFDBDstMacAddr";
  public static final String utsDot3OnuFDBVlanId = "utsDot3OnuFDBVlanId";
  public static final String utsDot3OnuFDBEgressPort = "utsDot3OnuFDBEgressPort";

  public Dot3Onu2FDBTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuFDBModuleId, new SnmpMibBeanProperty(utsDot3OnuFDBModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuFDBDeviceId, new SnmpMibBeanProperty(utsDot3OnuFDBDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuFDBLPortId, new SnmpMibBeanProperty(utsDot3OnuFDBLPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuFDBPortId, new SnmpMibBeanProperty(utsDot3OnuFDBPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuFDBIndex, new SnmpMibBeanProperty(utsDot3OnuFDBIndex, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuFDBDstMacAddr, new SnmpMibBeanProperty(utsDot3OnuFDBDstMacAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.6", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsDot3OnuFDBVlanId, new SnmpMibBeanProperty(utsDot3OnuFDBVlanId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuFDBEgressPort, new SnmpMibBeanProperty(utsDot3OnuFDBEgressPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.8", ISnmpConstant.STRING));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.19.1.9", ISnmpConstant.INTEGER));
  }


  public Integer getUtsDot3OnuFDBModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuFDBModuleId(Integer aUtsDot3OnuFDBModuleId) {
    setIndex(0, aUtsDot3OnuFDBModuleId);
  }


  public Integer getUtsDot3OnuFDBDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuFDBDeviceId(Integer aUtsDot3OnuFDBDeviceId) {
    setIndex(1, aUtsDot3OnuFDBDeviceId);
  }


  public Integer getUtsDot3OnuFDBPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OnuFDBPortId(Integer aUtsDot3OnuFDBPortId) {
    setIndex(2, aUtsDot3OnuFDBPortId);
  }


  public Integer getUtsDot3OnuFDBLPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3OnuFDBLPortId(Integer aUtsDot3OnuFDBLPortId) {
    setIndex(3, aUtsDot3OnuFDBLPortId);
  }


  public Integer getUtsDot3OnuFDBIndex() {
    return (Integer) getIndex(4);
  }

  public void setUtsDot3OnuFDBIndex(Integer aUtsDot3OnuFDBIndex) {
    setIndex(4, aUtsDot3OnuFDBIndex);
  }


  public byte[] getUtsDot3OnuFDBDstMacAddr() {
    return (byte[]) getProperty(utsDot3OnuFDBDstMacAddr).getValue();
  }

  public void setUtsDot3OnuFDBDstMacAddr(byte[] aUtsDot3OnuFDBDstMacAddr) {
    getProperty(utsDot3OnuFDBDstMacAddr).setValue(aUtsDot3OnuFDBDstMacAddr);
  }

  public Integer getUtsDot3OnuFDBVlanId() {
    return (Integer) getProperty(utsDot3OnuFDBVlanId).getValue();
  }

  public void setUtsDot3OnuFDBVlanId(Integer aUtsDot3OnuFDBVlanId) {
    getProperty(utsDot3OnuFDBVlanId).setValue(aUtsDot3OnuFDBVlanId);
  }

  public String getUtsDot3OnuFDBEgressPort() {
    return (String) getProperty(utsDot3OnuFDBEgressPort).getValue();
  }

  public void setUtsDot3OnuFDBEgressPort(String aUtsDot3OnuFDBEgressPort) {
    getProperty(utsDot3OnuFDBEgressPort).setValue(aUtsDot3OnuFDBEgressPort);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuFDBDstMacAddr));
    prepareRead(super.getProperty(utsDot3OnuFDBVlanId));
    prepareRead(super.getProperty(utsDot3OnuFDBEgressPort));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuFDBDstMacAddr));
    prepareRead(super.getProperty(utsDot3OnuFDBVlanId));
    prepareRead(super.getProperty(utsDot3OnuFDBEgressPort));

    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
                             , 1
    });
  }

  public boolean add() throws MibBeanException {
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(utsDot3OnuFDBDstMacAddr));
    prepareSave(getProperty(utsDot3OnuFDBVlanId));
    prepareSave(getProperty(utsDot3OnuFDBEgressPort));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }


  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }
}

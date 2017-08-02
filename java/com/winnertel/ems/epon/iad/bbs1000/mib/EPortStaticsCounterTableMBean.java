package com.winnertel.ems.epon.iad.bbs1000.mib;


/*
    * Copyright (c) 2002-2005 UTStarcom, Inc.
    * All rights reserved.
    */

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.PerfStaOperGroup;

import java.util.Vector;
import java.math.BigInteger;

/**
 * The ONUPortStaticsCounterTableMBean class.
 * Created by QuickDVM
 */
public class EPortStaticsCounterTableMBean extends SnmpMibBean {
  public static final String utsEthIfExtIndex = "utsEthIfExtIndex";
  public static final String utsEthIfHCInOctets = "utsEthIfHCInOctets";
  public static final String utsEthIfHCInUcastPkts = "utsEthIfHCInUcastPkts";
  public static final String utsEthIfHCInMulticastPkts = "utsEthIfHCInMulticastPkts";
  public static final String utsEthIfHCInBroadcastPkts = "utsEthIfHCInBroadcastPkts";
  public static final String utsEthIfHCOutOctets = "utsEthIfHCOutOctets";
  public static final String utsEthIfHCOutUcastPkts = "utsEthIfHCOutUcastPkts";
  public static final String utsEthIfHCOutMulticastPkts = "utsEthIfHCOutMulticastPkts";
  public static final String utsEthIfHCOutBroadcastPkts = "utsEthIfHCOutBroadcastPkts";
  public static final String utsPerfStaClearAll = "utsPerfStaClearAll";

  public EPortStaticsCounterTableMBean(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsEthIfExtIndex, new SnmpMibBeanProperty(utsEthIfExtIndex, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.1", ISnmpConstant.INTEGER));
    initProperty(utsEthIfHCInOctets, new SnmpMibBeanProperty(utsEthIfHCInOctets, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.62", ISnmpConstant.COUNTER64));
    initProperty(utsEthIfHCInUcastPkts, new SnmpMibBeanProperty(utsEthIfHCInUcastPkts, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.63", ISnmpConstant.COUNTER64));
    initProperty(utsEthIfHCInMulticastPkts, new SnmpMibBeanProperty(utsEthIfHCInMulticastPkts, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.64", ISnmpConstant.COUNTER64));
    initProperty(utsEthIfHCInBroadcastPkts, new SnmpMibBeanProperty(utsEthIfHCInBroadcastPkts, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.65", ISnmpConstant.COUNTER64));
    initProperty(utsEthIfHCOutOctets, new SnmpMibBeanProperty(utsEthIfHCOutOctets, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.66", ISnmpConstant.COUNTER64));
    initProperty(utsEthIfHCOutUcastPkts, new SnmpMibBeanProperty(utsEthIfHCOutUcastPkts, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.67", ISnmpConstant.COUNTER64));
    initProperty(utsEthIfHCOutMulticastPkts, new SnmpMibBeanProperty(utsEthIfHCOutMulticastPkts, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.68", ISnmpConstant.COUNTER64));
    initProperty(utsEthIfHCOutBroadcastPkts, new SnmpMibBeanProperty(utsEthIfHCOutBroadcastPkts, ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.69", ISnmpConstant.COUNTER64));
    initProperty(utsPerfStaClearAll, new SnmpMibBeanProperty(utsPerfStaClearAll, ".1.3.6.1.4.1.45121.1800.4.4.1.1", ISnmpConstant.INTEGER));

  }


  public Integer getUtsEthIfExtIndex() {
    return (Integer) getIndex(0);
  }

  public void setUtsEthIfExtIndex(Integer aUtsEthIfExtIndex) {
    setIndex(0, aUtsEthIfExtIndex);
  }

  public BigInteger getUtsEthIfHCInOctets() {
    return (BigInteger) getProperty(utsEthIfHCInOctets).getValue();
  }

  public void setUtsEthIfHCInOctets(BigInteger aUtsEthIfHCInOctets) {
    getProperty(utsEthIfHCInOctets).setValue(aUtsEthIfHCInOctets);
  }

  public BigInteger getUtsEthIfHCInUcastPkts() {
    return (BigInteger) getProperty(utsEthIfHCInUcastPkts).getValue();
  }

  public void setUtsEthIfHCInUcastPkts(BigInteger aUtsEthIfHCInUcastPkts) {
    getProperty(utsEthIfHCInUcastPkts).setValue(aUtsEthIfHCInUcastPkts);
  }

  public BigInteger getUtsEthIfHCInMulticastPkts() {
    return (BigInteger) getProperty(utsEthIfHCInMulticastPkts).getValue();
  }

  public void setUtsEthIfHCInMulticastPkts(BigInteger aUtsEthIfHCInMulticastPkts) {
    getProperty(utsEthIfHCInMulticastPkts).setValue(aUtsEthIfHCInMulticastPkts);
  }

  public BigInteger getUtsEthIfHCInBroadcastPkts() {
    return (BigInteger) getProperty(utsEthIfHCInBroadcastPkts).getValue();
  }

  public void setUtsEthIfHCInBroadcastPkts(BigInteger aUtsEthIfHCInBroadcastPkts) {
    getProperty(utsEthIfHCInBroadcastPkts).setValue(aUtsEthIfHCInBroadcastPkts);
  }

  public BigInteger getUtsEthIfHCOutOctets() {
    return (BigInteger) getProperty(utsEthIfHCOutOctets).getValue();
  }

  public void setUtsEthIfHCOutOctets(BigInteger aUtsEthIfHCOutOctets) {
    getProperty(utsEthIfHCOutOctets).setValue(aUtsEthIfHCOutOctets);
  }

  public BigInteger getUtsEthIfHCOutUcastPkts() {
    return (BigInteger) getProperty(utsEthIfHCOutUcastPkts).getValue();
  }

  public void setUtsEthIfHCOutUcastPkts(BigInteger aUtsEthIfHCOutUcastPkts) {
    getProperty(utsEthIfHCOutUcastPkts).setValue(aUtsEthIfHCOutUcastPkts);
  }

  public BigInteger getUtsEthIfHCOutMulticastPkts() {
    return (BigInteger) getProperty(utsEthIfHCOutMulticastPkts).getValue();
  }

  public void setUtsEthIfHCOutMulticastPkts(BigInteger aUtsEthIfHCOutMulticastPkts) {
    getProperty(utsEthIfHCOutMulticastPkts).setValue(aUtsEthIfHCOutMulticastPkts);
  }

  public BigInteger getUtsEthIfHCOutBroadcastPkts() {
    return (BigInteger) getProperty(utsEthIfHCOutBroadcastPkts).getValue();
  }

  public void setUtsEthIfHCOutBroadcastPkts(BigInteger aUtsEthIfHCOutBroadcastPkts) {
    getProperty(utsEthIfHCOutBroadcastPkts).setValue(aUtsEthIfHCOutBroadcastPkts);
  }

  public void setUtsPerfStaClearAll(Integer aUtsPerfStaClearAll) {
    getProperty(utsPerfStaClearAll).setValue(aUtsPerfStaClearAll);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsEthIfHCInOctets));
    prepareRead(super.getProperty(utsEthIfHCInUcastPkts));
    prepareRead(super.getProperty(utsEthIfHCInMulticastPkts));
    prepareRead(super.getProperty(utsEthIfHCInBroadcastPkts));
    prepareRead(super.getProperty(utsEthIfHCOutOctets));
    prepareRead(super.getProperty(utsEthIfHCOutUcastPkts));
    prepareRead(super.getProperty(utsEthIfHCOutMulticastPkts));
    prepareRead(super.getProperty(utsEthIfHCOutBroadcastPkts));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsEthIfHCInOctets));
    prepareRead(super.getProperty(utsEthIfHCInUcastPkts));
    prepareRead(super.getProperty(utsEthIfHCInMulticastPkts));
    prepareRead(super.getProperty(utsEthIfHCInBroadcastPkts));
    prepareRead(super.getProperty(utsEthIfHCOutOctets));
    prepareRead(super.getProperty(utsEthIfHCOutUcastPkts));
    prepareRead(super.getProperty(utsEthIfHCOutMulticastPkts));
    prepareRead(super.getProperty(utsEthIfHCOutBroadcastPkts));

    return loadAll(new int[]{1});
  }

  public boolean delete() throws MibBeanException {
    PerfStaOperGroup mbean = new PerfStaOperGroup(fSnmpProxy);
    mbean.setUtsPerfStaClearAll(new Integer(2));
    mbean.modify();
    return true;
  }
}

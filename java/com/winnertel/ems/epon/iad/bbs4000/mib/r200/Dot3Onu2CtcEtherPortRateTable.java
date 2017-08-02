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
 * The Dot3Onu2CtcEtherPortTable class.
 * Created by QuickDVM
 */
public class Dot3Onu2CtcEtherPortRateTable extends SnmpMibBean {
  public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
  public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
  public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
  public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
  public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
  public static final String utsDot3OnuEtherPortPause = "utsDot3OnuEtherPortPause";
  public static final String utsDot3OnuEtherPortPolicingEnable = "utsDot3OnuEtherPortPolicingEnable";
  public static final String utsDot3OnuEtherPortPolicingCIR = "utsDot3OnuEtherPortPolicingCIR";
  public static final String utsDot3OnuEtherPortPolicingCBS = "utsDot3OnuEtherPortPolicingCBS";
  public static final String utsDot3OnuEtherPortPolicingEBS = "utsDot3OnuEtherPortPolicingEBS";

  public Dot3Onu2CtcEtherPortRateTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPause, new SnmpMibBeanProperty(utsDot3OnuEtherPortPause, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.31", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPolicingEnable, new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.32", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPolicingCIR, new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingCIR, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.33", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPolicingCBS, new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingCBS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.34", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPolicingEBS, new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingEBS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.35", ISnmpConstant.INTEGER));
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


  public Integer getUtsDot3OnuEtherPortIndex() {
    return (Integer) getIndex(4);
  }

  public void setUtsDot3OnuEtherPortIndex(Integer aUtsDot3OnuEtherPortIndex) {
    setIndex(4, aUtsDot3OnuEtherPortIndex);
  }

  public Integer getUtsDot3OnuEtherPortPause() {
    return (Integer) getProperty(utsDot3OnuEtherPortPause).getValue();
  }

  public void setUtsDot3OnuEtherPortPause(Integer aUtsDot3OnuEtherPortPause) {
    getProperty(utsDot3OnuEtherPortPause).setValue(aUtsDot3OnuEtherPortPause);
  }

  public Integer getUtsDot3OnuEtherPortPolicingEnable() {
    return (Integer) getProperty(utsDot3OnuEtherPortPolicingEnable).getValue();
  }

  public void setUtsDot3OnuEtherPortPolicingEnable(Integer aUtsDot3OnuEtherPortPolicingEnable) {
    getProperty(utsDot3OnuEtherPortPolicingEnable).setValue(aUtsDot3OnuEtherPortPolicingEnable);
  }

  public Integer getUtsDot3OnuEtherPortPolicingCIR() {
    return (Integer) getProperty(utsDot3OnuEtherPortPolicingCIR).getValue();
  }

  public void setUtsDot3OnuEtherPortPolicingCIR(Integer aUtsDot3OnuEtherPortPolicingCIR) {
    getProperty(utsDot3OnuEtherPortPolicingCIR).setValue(aUtsDot3OnuEtherPortPolicingCIR);
  }

  public Integer getUtsDot3OnuEtherPortPolicingCBS() {
    return (Integer) getProperty(utsDot3OnuEtherPortPolicingCBS).getValue();
  }

  public void setUtsDot3OnuEtherPortPolicingCBS(Integer aUtsDot3OnuEtherPortPolicingCBS) {
    getProperty(utsDot3OnuEtherPortPolicingCBS).setValue(aUtsDot3OnuEtherPortPolicingCBS);
  }

  public Integer getUtsDot3OnuEtherPortPolicingEBS() {
    return (Integer) getProperty(utsDot3OnuEtherPortPolicingEBS).getValue();
  }

  public void setUtsDot3OnuEtherPortPolicingEBS(Integer aUtsDot3OnuEtherPortPolicingEBS) {
    getProperty(utsDot3OnuEtherPortPolicingEBS).setValue(aUtsDot3OnuEtherPortPolicingEBS);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuEtherPortPause));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEnable));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCIR));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCBS));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEBS));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuEtherPortPause));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEnable));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCIR));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCBS));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEBS));

    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OnuEtherPortPause));
    prepareSave(getProperty(utsDot3OnuEtherPortPolicingEnable));
    prepareSave(getProperty(utsDot3OnuEtherPortPolicingCIR));
    prepareSave(getProperty(utsDot3OnuEtherPortPolicingCBS));
    prepareSave(getProperty(utsDot3OnuEtherPortPolicingEBS));

    return save();
  }
}

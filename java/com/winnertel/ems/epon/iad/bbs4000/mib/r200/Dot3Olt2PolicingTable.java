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
 * The Dot3Olt2PolicingTable class.
 * Created by QuickDVM
 */
public class Dot3Olt2PolicingTable extends SnmpMibBean {
  public static final String utsDot3OltModuleId = "utsDot3OltModuleId";
  public static final String utsDot3OltDeviceId = "utsDot3OltDeviceId";
  public static final String utsDot3OltBcPoliceEnable = "utsDot3OltBcPoliceEnable";
  public static final String utsDot3OltBcPoliceRate = "utsDot3OltBcPoliceRate";
  public static final String utsDot3OltBcPoliceBurstSize = "utsDot3OltBcPoliceBurstSize";
  public static final String utsDot3OltUmcPoliceEnable = "utsDot3OltUmcPoliceEnable";
  public static final String utsDot3OltUmcPoliceRate = "utsDot3OltUmcPoliceRate";
  public static final String utsDot3OltUmcPoliceBurstSize = "utsDot3OltUmcPoliceBurstSize";
  public static final String utsDot3OltUucPoliceEnable = "utsDot3OltUucPoliceEnable";
  public static final String utsDot3OltUucPoliceRate = "utsDot3OltUucPoliceRate";
  public static final String utsDot3OltUucPoliceBurstSize = "utsDot3OltUucPoliceBurstSize";

  public Dot3Olt2PolicingTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(utsDot3OltModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDeviceId, new SnmpMibBeanProperty(utsDot3OltDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltBcPoliceEnable, new SnmpMibBeanProperty(utsDot3OltBcPoliceEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltBcPoliceRate, new SnmpMibBeanProperty(utsDot3OltBcPoliceRate, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltBcPoliceBurstSize, new SnmpMibBeanProperty(utsDot3OltBcPoliceBurstSize, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltUmcPoliceEnable, new SnmpMibBeanProperty(utsDot3OltUmcPoliceEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltUmcPoliceRate, new SnmpMibBeanProperty(utsDot3OltUmcPoliceRate, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltUmcPoliceBurstSize, new SnmpMibBeanProperty(utsDot3OltUmcPoliceBurstSize, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.8", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltUucPoliceEnable, new SnmpMibBeanProperty(utsDot3OltUucPoliceEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.9", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltUucPoliceRate, new SnmpMibBeanProperty(utsDot3OltUucPoliceRate, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.10", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltUucPoliceBurstSize, new SnmpMibBeanProperty(utsDot3OltUucPoliceBurstSize, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.7.1.11", ISnmpConstant.INTEGER));

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


  public Integer getUtsDot3OltBcPoliceEnable() {
    return (Integer) getProperty(utsDot3OltBcPoliceEnable).getValue();
  }

  public void setUtsDot3OltBcPoliceEnable(Integer aUtsDot3OltBcPoliceEnable) {
    getProperty(utsDot3OltBcPoliceEnable).setValue(aUtsDot3OltBcPoliceEnable);
  }

  public Integer getUtsDot3OltBcPoliceRate() {
    return (Integer) getProperty(utsDot3OltBcPoliceRate).getValue();
  }

  public void setUtsDot3OltBcPoliceRate(Integer aUtsDot3OltBcPoliceRate) {
    getProperty(utsDot3OltBcPoliceRate).setValue(aUtsDot3OltBcPoliceRate);
  }

  public Integer getUtsDot3OltBcPoliceBurstSize() {
    return (Integer) getProperty(utsDot3OltBcPoliceBurstSize).getValue();
  }

  public void setUtsDot3OltBcPoliceBurstSize(Integer aUtsDot3OltBcPoliceBurstSize) {
    getProperty(utsDot3OltBcPoliceBurstSize).setValue(aUtsDot3OltBcPoliceBurstSize);
  }

  public Integer getUtsDot3OltUmcPoliceEnable() {
    return (Integer) getProperty(utsDot3OltUmcPoliceEnable).getValue();
  }

  public void setUtsDot3OltUmcPoliceEnable(Integer aUtsDot3OltUmcPoliceEnable) {
    getProperty(utsDot3OltUmcPoliceEnable).setValue(aUtsDot3OltUmcPoliceEnable);
  }

  public Integer getUtsDot3OltUmcPoliceRate() {
    return (Integer) getProperty(utsDot3OltUmcPoliceRate).getValue();
  }

  public void setUtsDot3OltUmcPoliceRate(Integer aUtsDot3OltUmcPoliceRate) {
    getProperty(utsDot3OltUmcPoliceRate).setValue(aUtsDot3OltUmcPoliceRate);
  }

  public Integer getUtsDot3OltUmcPoliceBurstSize() {
    return (Integer) getProperty(utsDot3OltUmcPoliceBurstSize).getValue();
  }

  public void setUtsDot3OltUmcPoliceBurstSize(Integer aUtsDot3OltUmcPoliceBurstSize) {
    getProperty(utsDot3OltUmcPoliceBurstSize).setValue(aUtsDot3OltUmcPoliceBurstSize);
  }

  public Integer getUtsDot3OltUucPoliceEnable() {
    return (Integer) getProperty(utsDot3OltUucPoliceEnable).getValue();
  }

  public void setUtsDot3OltUucPoliceEnable(Integer aUtsDot3OltUucPoliceEnable) {
    getProperty(utsDot3OltUucPoliceEnable).setValue(aUtsDot3OltUucPoliceEnable);
  }

  public Integer getUtsDot3OltUucPoliceRate() {
    return (Integer) getProperty(utsDot3OltUucPoliceRate).getValue();
  }

  public void setUtsDot3OltUucPoliceRate(Integer aUtsDot3OltUucPoliceRate) {
    getProperty(utsDot3OltUucPoliceRate).setValue(aUtsDot3OltUucPoliceRate);
  }

  public Integer getUtsDot3OltUucPoliceBurstSize() {
    return (Integer) getProperty(utsDot3OltUucPoliceBurstSize).getValue();
  }

  public void setUtsDot3OltUucPoliceBurstSize(Integer aUtsDot3OltUucPoliceBurstSize) {
    getProperty(utsDot3OltUucPoliceBurstSize).setValue(aUtsDot3OltUucPoliceBurstSize);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltBcPoliceEnable));
    prepareRead(super.getProperty(utsDot3OltBcPoliceRate));
    prepareRead(super.getProperty(utsDot3OltBcPoliceBurstSize));
    prepareRead(super.getProperty(utsDot3OltUmcPoliceEnable));
    prepareRead(super.getProperty(utsDot3OltUmcPoliceRate));
    prepareRead(super.getProperty(utsDot3OltUmcPoliceBurstSize));
    prepareRead(super.getProperty(utsDot3OltUucPoliceEnable));
    prepareRead(super.getProperty(utsDot3OltUucPoliceRate));
    prepareRead(super.getProperty(utsDot3OltUucPoliceBurstSize));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltBcPoliceEnable));
    prepareRead(super.getProperty(utsDot3OltBcPoliceRate));
    prepareRead(super.getProperty(utsDot3OltBcPoliceBurstSize));
    prepareRead(super.getProperty(utsDot3OltUmcPoliceEnable));
    prepareRead(super.getProperty(utsDot3OltUmcPoliceRate));
    prepareRead(super.getProperty(utsDot3OltUmcPoliceBurstSize));
    prepareRead(super.getProperty(utsDot3OltUucPoliceEnable));
    prepareRead(super.getProperty(utsDot3OltUucPoliceRate));
    prepareRead(super.getProperty(utsDot3OltUucPoliceBurstSize));

    return loadAll(new int[]{1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OltBcPoliceEnable));
    prepareSave(getProperty(utsDot3OltBcPoliceRate));
    prepareSave(getProperty(utsDot3OltBcPoliceBurstSize));
    prepareSave(getProperty(utsDot3OltUmcPoliceEnable));
    prepareSave(getProperty(utsDot3OltUmcPoliceRate));
    prepareSave(getProperty(utsDot3OltUmcPoliceBurstSize));
    prepareSave(getProperty(utsDot3OltUucPoliceEnable));
    prepareSave(getProperty(utsDot3OltUucPoliceRate));
    prepareSave(getProperty(utsDot3OltUucPoliceBurstSize));

    return save();
  }


}

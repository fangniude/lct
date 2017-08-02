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
 * The Dot3Olt2PortDbaTable class.
 * Created by QuickDVM
 */
public class Dot3Olt2PortDbaTable extends SnmpMibBean {
  public static final String utsDot3OltPortDbaModuleId = "utsDot3OltPortDbaModuleId";
  public static final String utsDot3OltPortDbaDeviceId = "utsDot3OltPortDbaDeviceId";
  public static final String utsDot3OltPortDbaPortId = "utsDot3OltPortDbaPortId";
  public static final String utsDot3OltPortDbaCycleSize = "utsDot3OltPortDbaCycleSize";
  public static final String utsDot3OltPortDbaDiscoveryFreq = "utsDot3OltPortDbaDiscoveryFreq";
  public static final String utsDot3OltPortDbaDiscoverySize = "utsDot3OltPortDbaDiscoverySize";

  public Dot3Olt2PortDbaTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OltPortDbaModuleId, new SnmpMibBeanProperty(utsDot3OltPortDbaModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.11.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortDbaDeviceId, new SnmpMibBeanProperty(utsDot3OltPortDbaDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.11.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortDbaPortId, new SnmpMibBeanProperty(utsDot3OltPortDbaPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.11.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortDbaCycleSize, new SnmpMibBeanProperty(utsDot3OltPortDbaCycleSize, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.11.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortDbaDiscoveryFreq, new SnmpMibBeanProperty(utsDot3OltPortDbaDiscoveryFreq, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.11.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortDbaDiscoverySize, new SnmpMibBeanProperty(utsDot3OltPortDbaDiscoverySize, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.11.1.6", ISnmpConstant.INTEGER));

  }


  public Integer getUtsDot3OltPortDbaModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OltPortDbaModuleId(Integer aUtsDot3OltPortDbaModuleId) {
    setIndex(0, aUtsDot3OltPortDbaModuleId);
  }


  public Integer getUtsDot3OltPortDbaDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OltPortDbaDeviceId(Integer aUtsDot3OltPortDbaDeviceId) {
    setIndex(1, aUtsDot3OltPortDbaDeviceId);
  }


  public Integer getUtsDot3OltPortDbaPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OltPortDbaPortId(Integer aUtsDot3OltPortDbaPortId) {
    setIndex(2, aUtsDot3OltPortDbaPortId);
  }


  public Integer getUtsDot3OltPortDbaCycleSize() {
    return (Integer) getProperty(utsDot3OltPortDbaCycleSize).getValue();
  }

  public void setUtsDot3OltPortDbaCycleSize(Integer aUtsDot3OltPortDbaCycleSize) {
    getProperty(utsDot3OltPortDbaCycleSize).setValue(aUtsDot3OltPortDbaCycleSize);
  }

  public Integer getUtsDot3OltPortDbaDiscoveryFreq() {
    return (Integer) getProperty(utsDot3OltPortDbaDiscoveryFreq).getValue();
  }

  public void setUtsDot3OltPortDbaDiscoveryFreq(Integer aUtsDot3OltPortDbaDiscoveryFreq) {
    getProperty(utsDot3OltPortDbaDiscoveryFreq).setValue(aUtsDot3OltPortDbaDiscoveryFreq);
  }

  public Integer getUtsDot3OltPortDbaDiscoverySize() {
    return (Integer) getProperty(utsDot3OltPortDbaDiscoverySize).getValue();
  }

  public void setUtsDot3OltPortDbaDiscoverySize(Integer aUtsDot3OltPortDbaDiscoverySize) {
    getProperty(utsDot3OltPortDbaDiscoverySize).setValue(aUtsDot3OltPortDbaDiscoverySize);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltPortDbaCycleSize));
    prepareRead(super.getProperty(utsDot3OltPortDbaDiscoveryFreq));
    prepareRead(super.getProperty(utsDot3OltPortDbaDiscoverySize));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltPortDbaCycleSize));
    prepareRead(super.getProperty(utsDot3OltPortDbaDiscoveryFreq));
    prepareRead(super.getProperty(utsDot3OltPortDbaDiscoverySize));

    return loadAll(new int[]{1
                             , 1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OltPortDbaCycleSize));
    prepareSave(getProperty(utsDot3OltPortDbaDiscoveryFreq));
    prepareSave(getProperty(utsDot3OltPortDbaDiscoverySize));

    return save();
  }


}

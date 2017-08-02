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
 * The OnuCtcMulticastTable class.
 * Created by QuickDVM
 */
public class OnuCtcMulticastTable extends SnmpMibBean {
  public static final String utsDot3OnuMCastModuleId = "utsDot3OnuMCastModuleId";
  public static final String utsDot3OnuMCastDeviceId = "utsDot3OnuMCastDeviceId";
  public static final String utsDot3OnuMCastPortId = "utsDot3OnuMCastPortId";
  public static final String utsDot3OnuMCastLogicalPortId = "utsDot3OnuMCastLogicalPortId";
  public static final String utsDot3OnuMCastEtherPortId = "utsDot3OnuMCastEtherPortId";
  public static final String utsDot3OnuMCastGroup = "utsDot3OnuMCastGroup";
  public static final String utsDot3OnuMCastMVlan = "utsDot3OnuMCastMVlan";
  public static final String utsDot3OnuMCastAuthType = "utsDot3OnuMCastAuthType";
  public static final String utsDot3OnuMCastDuration = "utsDot3OnuMCastDuration";

  public OnuCtcMulticastTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuMCastModuleId, new SnmpMibBeanProperty(utsDot3OnuMCastModuleId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastDeviceId, new SnmpMibBeanProperty(utsDot3OnuMCastDeviceId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastPortId, new SnmpMibBeanProperty(utsDot3OnuMCastPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuMCastLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastEtherPortId, new SnmpMibBeanProperty(utsDot3OnuMCastEtherPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastGroup, new SnmpMibBeanProperty(utsDot3OnuMCastGroup, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.6", ISnmpConstant.STRING));
    initProperty(utsDot3OnuMCastMVlan, new SnmpMibBeanProperty(utsDot3OnuMCastMVlan, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastAuthType, new SnmpMibBeanProperty(utsDot3OnuMCastAuthType, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.8", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastDuration, new SnmpMibBeanProperty(utsDot3OnuMCastDuration, ".1.3.6.1.4.1.45121.1800.2.4.3.1.6.1.9", ISnmpConstant.INTEGER));

  }


  public Integer getUtsDot3OnuMCastModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuMCastModuleId(Integer aUtsDot3OnuMCastModuleId) {
    setIndex(0, aUtsDot3OnuMCastModuleId);
  }


  public Integer getUtsDot3OnuMCastDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuMCastDeviceId(Integer aUtsDot3OnuMCastDeviceId) {
    setIndex(1, aUtsDot3OnuMCastDeviceId);
  }


  public Integer getUtsDot3OnuMCastPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OnuMCastPortId(Integer aUtsDot3OnuMCastPortId) {
    setIndex(2, aUtsDot3OnuMCastPortId);
  }


  public Integer getUtsDot3OnuMCastLogicalPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3OnuMCastLogicalPortId(Integer aUtsDot3OnuMCastLogicalPortId) {
    setIndex(3, aUtsDot3OnuMCastLogicalPortId);
  }


  public Integer getUtsDot3OnuMCastEtherPortId() {
    return (Integer) getIndex(4);
  }

  public void setUtsDot3OnuMCastEtherPortId(Integer aUtsDot3OnuMCastEtherPortId) {
    setIndex(4, aUtsDot3OnuMCastEtherPortId);
  }


  public String getUtsDot3OnuMCastGroup() {
    return (String) getIndex(5);
  }

  public void setUtsDot3OnuMCastGroup(String aUtsDot3OnuMCastGroup) {
    setIndex(5, aUtsDot3OnuMCastGroup);
  }


  public Integer getUtsDot3OnuMCastMVlan() {
    return (Integer) getProperty(utsDot3OnuMCastMVlan).getValue();
  }

  public void setUtsDot3OnuMCastMVlan(Integer aUtsDot3OnuMCastMVlan) {
    getProperty(utsDot3OnuMCastMVlan).setValue(aUtsDot3OnuMCastMVlan);
  }

  public Integer getUtsDot3OnuMCastAuthType() {
    return (Integer) getProperty(utsDot3OnuMCastAuthType).getValue();
  }

  public void setUtsDot3OnuMCastAuthType(Integer aUtsDot3OnuMCastAuthType) {
    getProperty(utsDot3OnuMCastAuthType).setValue(aUtsDot3OnuMCastAuthType);
  }

  public Integer getUtsDot3OnuMCastDuration() {
    return (Integer) getProperty(utsDot3OnuMCastDuration).getValue();
  }

  public void setUtsDot3OnuMCastDuration(Integer aUtsDot3OnuMCastDuration) {
    getProperty(utsDot3OnuMCastDuration).setValue(aUtsDot3OnuMCastDuration);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuMCastMVlan));
    prepareRead(super.getProperty(utsDot3OnuMCastAuthType));
    prepareRead(super.getProperty(utsDot3OnuMCastDuration));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuMCastMVlan));
    prepareRead(super.getProperty(utsDot3OnuMCastAuthType));
    prepareRead(super.getProperty(utsDot3OnuMCastDuration));

    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
                             , 1
                             , 4
    });
  }


}

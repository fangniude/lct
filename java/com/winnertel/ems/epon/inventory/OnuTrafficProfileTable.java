/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.inventory;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2TrafficProfTable class.
 * Created by QuickDVM
 */
public class OnuTrafficProfileTable extends SnmpMibBean {
  public static final String utsDot3OnuTProfModuleId = "utsDot3OnuTProfModuleId";
  public static final String utsDot3OnuTProfDeviceId = "utsDot3OnuTProfDeviceId";
  public static final String utsDot3OnuTProfPortId = "utsDot3OnuTProfPortId";
  public static final String utsDot3OnuTProfLogicalPortId = "utsDot3OnuTProfLogicalPortId";
  public static final String utsDot3OnuUpstreamPir = "utsDot3OnuUpstreamPir";
  public static final String utsDot3OnuDownstreamPir = "utsDot3OnuDownstreamPir";
  public static final String utsDot3OnuUpstreamCir = "utsDot3OnuUpstreamCir";
  public static final String utsDot3OnuDownstreamCir = "utsDot3OnuDownstreamCir";
  public static final String utsDot3OnuUpstreamMaxBurstSize = "utsDot3OnuUpstreamMaxBurstSize";
  public static final String utsDot3OnuDownstreamMaxBurstSize = "utsDot3OnuDownstreamMaxBurstSize";
  public static final String utsDot3Onu2CtcSerialNumber = "utsDot3Onu2CtcSerialNumber";

  private String onuLabel;

  public OnuTrafficProfileTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuTProfModuleId, new SnmpMibBeanProperty(utsDot3OnuTProfModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuTProfDeviceId, new SnmpMibBeanProperty(utsDot3OnuTProfDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuTProfPortId, new SnmpMibBeanProperty(utsDot3OnuTProfPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuTProfLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuTProfLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuUpstreamPir, new SnmpMibBeanProperty(utsDot3OnuUpstreamPir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDownstreamPir, new SnmpMibBeanProperty(utsDot3OnuDownstreamPir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuUpstreamCir, new SnmpMibBeanProperty(utsDot3OnuUpstreamCir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDownstreamCir, new SnmpMibBeanProperty(utsDot3OnuDownstreamCir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.8", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuUpstreamMaxBurstSize, new SnmpMibBeanProperty(utsDot3OnuUpstreamMaxBurstSize, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.9", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDownstreamMaxBurstSize, new SnmpMibBeanProperty(utsDot3OnuDownstreamMaxBurstSize, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.10", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcSerialNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcSerialNumber, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.8", ISnmpConstant.OCTETS));
  }


  public Integer getUtsDot3OnuTProfModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuTProfModuleId(Integer aUtsDot3OnuTProfModuleId) {
    setIndex(0, aUtsDot3OnuTProfModuleId);
  }


  public Integer getUtsDot3OnuTProfDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuTProfDeviceId(Integer aUtsDot3OnuTProfDeviceId) {
    setIndex(1, aUtsDot3OnuTProfDeviceId);
  }


  public Integer getUtsDot3OnuTProfPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OnuTProfPortId(Integer aUtsDot3OnuTProfPortId) {
    setIndex(2, aUtsDot3OnuTProfPortId);
  }


  public Integer getUtsDot3OnuTProfLogicalPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3OnuTProfLogicalPortId(Integer aUtsDot3OnuTProfLogicalPortId) {
    setIndex(3, aUtsDot3OnuTProfLogicalPortId);
  }


  public Integer getUtsDot3OnuUpstreamPir() {
    return (Integer) getProperty(utsDot3OnuUpstreamPir).getValue();
  }

  public void setUtsDot3OnuUpstreamPir(Integer aUtsDot3OnuUpstreamPir) {
    getProperty(utsDot3OnuUpstreamPir).setValue(aUtsDot3OnuUpstreamPir);
  }

  public Integer getUtsDot3OnuDownstreamPir() {
    return (Integer) getProperty(utsDot3OnuDownstreamPir).getValue();
  }

  public void setUtsDot3OnuDownstreamPir(Integer aUtsDot3OnuDownstreamPir) {
    getProperty(utsDot3OnuDownstreamPir).setValue(aUtsDot3OnuDownstreamPir);
  }

  public Integer getUtsDot3OnuUpstreamCir() {
    return (Integer) getProperty(utsDot3OnuUpstreamCir).getValue();
  }

  public void setUtsDot3OnuUpstreamCir(Integer aUtsDot3OnuUpstreamCir) {
    getProperty(utsDot3OnuUpstreamCir).setValue(aUtsDot3OnuUpstreamCir);
  }

  public Integer getUtsDot3OnuDownstreamCir() {
    return (Integer) getProperty(utsDot3OnuDownstreamCir).getValue();
  }

  public void setUtsDot3OnuDownstreamCir(Integer aUtsDot3OnuDownstreamCir) {
    getProperty(utsDot3OnuDownstreamCir).setValue(aUtsDot3OnuDownstreamCir);
  }

  public Integer getUtsDot3OnuUpstreamMaxBurstSize() {
    return (Integer) getProperty(utsDot3OnuUpstreamMaxBurstSize).getValue();
  }

  public void setUtsDot3OnuUpstreamMaxBurstSize(Integer aUtsDot3OnuUpstreamMaxBurstSize) {
    getProperty(utsDot3OnuUpstreamMaxBurstSize).setValue(aUtsDot3OnuUpstreamMaxBurstSize);
  }

  public Integer getUtsDot3OnuDownstreamMaxBurstSize() {
    return (Integer) getProperty(utsDot3OnuDownstreamMaxBurstSize).getValue();
  }

  public void setUtsDot3OnuDownstreamMaxBurstSize(Integer aUtsDot3OnuDownstreamMaxBurstSize) {
    getProperty(utsDot3OnuDownstreamMaxBurstSize).setValue(aUtsDot3OnuDownstreamMaxBurstSize);
  }

  public byte[] getUtsDot3Onu2CtcSerialNumber() {
    return (byte[])getProperty(utsDot3Onu2CtcSerialNumber).getValue();
  }

  public void setUtsDot3Onu2CtcSerialNumber(byte[] aUtsDot3Onu2CtcSerialNumber)
  {
    getProperty(utsDot3Onu2CtcSerialNumber).setValue(aUtsDot3Onu2CtcSerialNumber);
  }
  
  public String getUtsDot3Onu2CtcOnuModel()
  {
    byte[] value = (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
//    for ( int i = 0; i < 4; i++ ) {
//      if ( value[4+i] < 32 || value[4+i] > 126) value[4+i] = 32;
//    }

    byte[] model = new byte[4];
    System.arraycopy(value, 4, model, 0, model.length);
    return new String(model);

  }

  public String getOnuLabel() {
    return onuLabel;
  }

  public void setOnuLabel(String aLabel) {
    onuLabel = aLabel;
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuUpstreamPir));
    prepareRead(super.getProperty(utsDot3OnuDownstreamPir));
    prepareRead(super.getProperty(utsDot3OnuUpstreamCir));
    prepareRead(super.getProperty(utsDot3OnuDownstreamCir));
    prepareRead(super.getProperty(utsDot3OnuUpstreamMaxBurstSize));
    prepareRead(super.getProperty(utsDot3OnuDownstreamMaxBurstSize));
    prepareRead(super.getProperty(utsDot3Onu2CtcSerialNumber));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuUpstreamPir));
    prepareRead(super.getProperty(utsDot3OnuDownstreamPir));
    prepareRead(super.getProperty(utsDot3OnuUpstreamCir));
    prepareRead(super.getProperty(utsDot3OnuDownstreamCir));
    prepareRead(super.getProperty(utsDot3OnuUpstreamMaxBurstSize));
    prepareRead(super.getProperty(utsDot3OnuDownstreamMaxBurstSize));
    prepareRead(super.getProperty(utsDot3Onu2CtcSerialNumber));

    return loadAll(new int[]{1 , 1 , 1 , 1});

  }
}

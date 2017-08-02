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
 * The Dot3Onu2ClassifiRuleTable class.
 * Created by QuickDVM
 */
public class Dot3Onu2ClassifiRuleTable extends SnmpMibBean {
  public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
  public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
  public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
  public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
  public static final String utsDot3OnuClassifiRuleIndex = "utsDot3OnuClassifiRuleIndex";
  public static final String utsDot3OnuClassifiRuleEnable = "utsDot3OnuClassifiRuleEnable";
  public static final String utsDot3OnuClassifiRuleProtId = "utsDot3OnuClassifiRuleProtId";
  public static final String utsDot3OnuClassifiRuleUniPort = "utsDot3OnuClassifiRuleUniPort";
  public static final String utsDot3OnuClassifiRuleL4SrcPortStart = "utsDot3OnuClassifiRuleL4SrcPortStart";
  public static final String utsDot3OnuClassifiRuleL4SrcPortEnd = "utsDot3OnuClassifiRuleL4SrcPortEnd";
  public static final String utsDot3OnuClassifiRuleL4DstPortStart = "utsDot3OnuClassifiRuleL4DstPortStart";
  public static final String utsDot3OnuClassifiRuleL4DstPortEnd = "utsDot3OnuClassifiRuleL4DstPortEnd";
  public static final String utsDot3OnuClassifiRuleDscp = "utsDot3OnuClassifiRuleDscp";
  public static final String utsDot3OnuClassifiRule802Dot1p = "utsDot3OnuClassifiRule802Dot1p";
  public static final String utsDot3OnuClassifiRuleCosQueue = "utsDot3OnuClassifiRuleCosQueue";

  public Dot3Onu2ClassifiRuleTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleIndex, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleIndex, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleEnable, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleProtId, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleProtId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleUniPort, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleUniPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.8", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleL4SrcPortStart, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleL4SrcPortStart, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.9", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleL4SrcPortEnd, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleL4SrcPortEnd, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.10", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleL4DstPortStart, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleL4DstPortStart, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.11", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleL4DstPortEnd, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleL4DstPortEnd, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.12", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleDscp, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDscp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.13", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRule802Dot1p, new SnmpMibBeanProperty(utsDot3OnuClassifiRule802Dot1p, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.14", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleCosQueue, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleCosQueue, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.4.1.15", ISnmpConstant.INTEGER));

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


  public Integer getUtsDot3OnuClassifiRuleIndex() {
    return (Integer) getIndex(4);
  }

  public void setUtsDot3OnuClassifiRuleIndex(Integer aUtsDot3OnuClassifiRuleIndex) {
    setIndex(4, aUtsDot3OnuClassifiRuleIndex);
  }


  public Integer getUtsDot3OnuClassifiRuleEnable() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleEnable).getValue();
  }

  public void setUtsDot3OnuClassifiRuleEnable(Integer aUtsDot3OnuClassifiRuleEnable) {
    getProperty(utsDot3OnuClassifiRuleEnable).setValue(aUtsDot3OnuClassifiRuleEnable);
  }

  public Integer getUtsDot3OnuClassifiRuleProtId() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleProtId).getValue();
  }

  public void setUtsDot3OnuClassifiRuleProtId(Integer aUtsDot3OnuClassifiRuleProtId) {
    getProperty(utsDot3OnuClassifiRuleProtId).setValue(aUtsDot3OnuClassifiRuleProtId);
  }

  public Integer getUtsDot3OnuClassifiRuleUniPort() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleUniPort).getValue();
  }

  public void setUtsDot3OnuClassifiRuleUniPort(Integer aUtsDot3OnuClassifiRuleUniPort) {
    getProperty(utsDot3OnuClassifiRuleUniPort).setValue(aUtsDot3OnuClassifiRuleUniPort);
  }

  public Integer getUtsDot3OnuClassifiRuleL4SrcPortStart() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleL4SrcPortStart).getValue();
  }

  public void setUtsDot3OnuClassifiRuleL4SrcPortStart(Integer aUtsDot3OnuClassifiRuleL4SrcPortStart) {
    getProperty(utsDot3OnuClassifiRuleL4SrcPortStart).setValue(aUtsDot3OnuClassifiRuleL4SrcPortStart);
  }

  public Integer getUtsDot3OnuClassifiRuleL4SrcPortEnd() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleL4SrcPortEnd).getValue();
  }

  public void setUtsDot3OnuClassifiRuleL4SrcPortEnd(Integer aUtsDot3OnuClassifiRuleL4SrcPortEnd) {
    getProperty(utsDot3OnuClassifiRuleL4SrcPortEnd).setValue(aUtsDot3OnuClassifiRuleL4SrcPortEnd);
  }

  public Integer getUtsDot3OnuClassifiRuleL4DstPortStart() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleL4DstPortStart).getValue();
  }

  public void setUtsDot3OnuClassifiRuleL4DstPortStart(Integer aUtsDot3OnuClassifiRuleL4DstPortStart) {
    getProperty(utsDot3OnuClassifiRuleL4DstPortStart).setValue(aUtsDot3OnuClassifiRuleL4DstPortStart);
  }

  public Integer getUtsDot3OnuClassifiRuleL4DstPortEnd() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleL4DstPortEnd).getValue();
  }

  public void setUtsDot3OnuClassifiRuleL4DstPortEnd(Integer aUtsDot3OnuClassifiRuleL4DstPortEnd) {
    getProperty(utsDot3OnuClassifiRuleL4DstPortEnd).setValue(aUtsDot3OnuClassifiRuleL4DstPortEnd);
  }

  public Integer getUtsDot3OnuClassifiRuleDscp() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDscp).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDscp(Integer aUtsDot3OnuClassifiRuleDscp) {
    getProperty(utsDot3OnuClassifiRuleDscp).setValue(aUtsDot3OnuClassifiRuleDscp);
  }

  public Integer getUtsDot3OnuClassifiRule802Dot1p() {
    return (Integer) getProperty(utsDot3OnuClassifiRule802Dot1p).getValue();
  }

  public void setUtsDot3OnuClassifiRule802Dot1p(Integer aUtsDot3OnuClassifiRule802Dot1p) {
    getProperty(utsDot3OnuClassifiRule802Dot1p).setValue(aUtsDot3OnuClassifiRule802Dot1p);
  }

  public Integer getUtsDot3OnuClassifiRuleCosQueue() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleCosQueue).getValue();
  }

  public void setUtsDot3OnuClassifiRuleCosQueue(Integer aUtsDot3OnuClassifiRuleCosQueue) {
    getProperty(utsDot3OnuClassifiRuleCosQueue).setValue(aUtsDot3OnuClassifiRuleCosQueue);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleEnable));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleProtId));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleUniPort));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleL4SrcPortStart));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleL4SrcPortEnd));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleL4DstPortStart));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleL4DstPortEnd));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDscp));
    prepareRead(super.getProperty(utsDot3OnuClassifiRule802Dot1p));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleCosQueue));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleEnable));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleProtId));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleUniPort));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleL4SrcPortStart));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleL4SrcPortEnd));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleL4DstPortStart));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleL4DstPortEnd));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDscp));
    prepareRead(super.getProperty(utsDot3OnuClassifiRule802Dot1p));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleCosQueue));

    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OnuClassifiRuleIndex));
    prepareSave(getProperty(utsDot3OnuClassifiRuleEnable));
    prepareSave(getProperty(utsDot3OnuClassifiRuleProtId));
    prepareSave(getProperty(utsDot3OnuClassifiRuleUniPort));
    prepareSave(getProperty(utsDot3OnuClassifiRuleL4SrcPortStart));
    prepareSave(getProperty(utsDot3OnuClassifiRuleL4SrcPortEnd));
    prepareSave(getProperty(utsDot3OnuClassifiRuleL4DstPortStart));
    prepareSave(getProperty(utsDot3OnuClassifiRuleL4DstPortEnd));
    prepareSave(getProperty(utsDot3OnuClassifiRuleDscp));
    prepareSave(getProperty(utsDot3OnuClassifiRule802Dot1p));
    prepareSave(getProperty(utsDot3OnuClassifiRuleCosQueue));

    return save();
  }


}
    
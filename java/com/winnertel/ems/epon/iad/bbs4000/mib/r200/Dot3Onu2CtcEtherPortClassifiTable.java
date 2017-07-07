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
 * The Dot3Onu2CtcEtherPortClassifiTabl class.
 * Created by QuickDVM
 */
public class Dot3Onu2CtcEtherPortClassifiTable extends SnmpMibBean {
  public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
  public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
  public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
  public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
  public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
  public static final String utsDot3OnuClassifiRuleIndex = "utsDot3OnuClassifiRuleIndex";
  public static final String utsDot3OnuClassifiPrecedence = "utsDot3OnuClassifiPrecedence";
  public static final String utsDot3OnuClassifiQueueMapped = "utsDot3OnuClassifiQueueMapped";
  public static final String utsDot3OnuClassifiEtherPriMark = "utsDot3OnuClassifiEtherPriMark";
  public static final String utsDot3OnuClassifiFSelect1 = "utsDot3OnuClassifiFSelect1";
  public static final String utsDot3OnuClassifiFMatch1 = "utsDot3OnuClassifiFMatch1";
  public static final String utsDot3OnuClassifiOperator1 = "utsDot3OnuClassifiOperator1";
  public static final String utsDot3OnuClassifiFSelect2 = "utsDot3OnuClassifiFSelect2";
  public static final String utsDot3OnuClassifiFMatch2 = "utsDot3OnuClassifiFMatch2";
  public static final String utsDot3OnuClassifiOperator2 = "utsDot3OnuClassifiOperator2";
  public static final String utsDot3OnuClassifiFSelect3 = "utsDot3OnuClassifiFSelect3";
  public static final String utsDot3OnuClassifiFMatch3 = "utsDot3OnuClassifiFMatch3";
  public static final String utsDot3OnuClassifiOperator3 = "utsDot3OnuClassifiOperator3";


  public Dot3Onu2CtcEtherPortClassifiTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiRuleIndex, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleIndex, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiPrecedence, new SnmpMibBeanProperty(utsDot3OnuClassifiPrecedence, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiQueueMapped, new SnmpMibBeanProperty(utsDot3OnuClassifiQueueMapped, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.8", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiEtherPriMark, new SnmpMibBeanProperty(utsDot3OnuClassifiEtherPriMark, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.9", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiFSelect1, new SnmpMibBeanProperty(utsDot3OnuClassifiFSelect1, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.11", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiFMatch1, new SnmpMibBeanProperty(utsDot3OnuClassifiFMatch1, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.12", ISnmpConstant.STRING));
    initProperty(utsDot3OnuClassifiOperator1, new SnmpMibBeanProperty(utsDot3OnuClassifiOperator1, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.13", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiFSelect2, new SnmpMibBeanProperty(utsDot3OnuClassifiFSelect2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.21", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiFMatch2, new SnmpMibBeanProperty(utsDot3OnuClassifiFMatch2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.22", ISnmpConstant.STRING));
    initProperty(utsDot3OnuClassifiOperator2, new SnmpMibBeanProperty(utsDot3OnuClassifiOperator2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.23", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiFSelect3, new SnmpMibBeanProperty(utsDot3OnuClassifiFSelect3, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.31", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiFMatch3, new SnmpMibBeanProperty(utsDot3OnuClassifiFMatch3, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.32", ISnmpConstant.STRING));
    initProperty(utsDot3OnuClassifiOperator3, new SnmpMibBeanProperty(utsDot3OnuClassifiOperator3, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.33", ISnmpConstant.INTEGER));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.12.1.100", ISnmpConstant.INTEGER));

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


  public Integer getUtsDot3OnuClassifiRuleIndex() {
    return (Integer) getIndex(5);
  }

  public void setUtsDot3OnuClassifiRuleIndex(Integer aUtsDot3OnuClassifiRuleIndex) {
    setIndex(5, aUtsDot3OnuClassifiRuleIndex);
  }


  public Integer getUtsDot3OnuClassifiPrecedence() {
    return (Integer) getProperty(utsDot3OnuClassifiPrecedence).getValue();
  }

  public void setUtsDot3OnuClassifiPrecedence(Integer aUtsDot3OnuClassifiPrecedence) {
    getProperty(utsDot3OnuClassifiPrecedence).setValue(aUtsDot3OnuClassifiPrecedence);
  }

  public Integer getUtsDot3OnuClassifiQueueMapped() {
    return (Integer) getProperty(utsDot3OnuClassifiQueueMapped).getValue();
  }

  public void setUtsDot3OnuClassifiQueueMapped(Integer aUtsDot3OnuClassifiQueueMapped) {
    getProperty(utsDot3OnuClassifiQueueMapped).setValue(aUtsDot3OnuClassifiQueueMapped);
  }

  public Integer getUtsDot3OnuClassifiEtherPriMark() {
    return (Integer) getProperty(utsDot3OnuClassifiEtherPriMark).getValue();
  }

  public void setUtsDot3OnuClassifiEtherPriMark(Integer aUtsDot3OnuClassifiEtherPriMark) {
    getProperty(utsDot3OnuClassifiEtherPriMark).setValue(aUtsDot3OnuClassifiEtherPriMark);
  }

  public Integer getUtsDot3OnuClassifiFSelect1() {
    return (Integer) getProperty(utsDot3OnuClassifiFSelect1).getValue();
  }

  public void setUtsDot3OnuClassifiFSelect1(Integer aUtsDot3OnuClassifiFSelect1) {
    getProperty(utsDot3OnuClassifiFSelect1).setValue(aUtsDot3OnuClassifiFSelect1);
  }

  public String getUtsDot3OnuClassifiFMatch1() {
    return (String) getProperty(utsDot3OnuClassifiFMatch1).getValue();
  }

  public void setUtsDot3OnuClassifiFMatch1(String aUtsDot3OnuClassifiFMatch1) {
    getProperty(utsDot3OnuClassifiFMatch1).setValue(aUtsDot3OnuClassifiFMatch1);
  }

  public Integer getUtsDot3OnuClassifiOperator1() {
    return (Integer) getProperty(utsDot3OnuClassifiOperator1).getValue();
  }

  public void setUtsDot3OnuClassifiOperator1(Integer aUtsDot3OnuClassifiOperator1) {
    getProperty(utsDot3OnuClassifiOperator1).setValue(aUtsDot3OnuClassifiOperator1);
  }

  public Integer getUtsDot3OnuClassifiFSelect2() {
    return (Integer) getProperty(utsDot3OnuClassifiFSelect2).getValue();
  }

  public void setUtsDot3OnuClassifiFSelect2(Integer aUtsDot3OnuClassifiFSelect2) {
    getProperty(utsDot3OnuClassifiFSelect2).setValue(aUtsDot3OnuClassifiFSelect2);
  }

  public String getUtsDot3OnuClassifiFMatch2() {
    return (String) getProperty(utsDot3OnuClassifiFMatch2).getValue();
  }

  public void setUtsDot3OnuClassifiFMatch2(String aUtsDot3OnuClassifiFMatch2) {
    getProperty(utsDot3OnuClassifiFMatch2).setValue(aUtsDot3OnuClassifiFMatch2);
  }

  public Integer getUtsDot3OnuClassifiOperator2() {
    return (Integer) getProperty(utsDot3OnuClassifiOperator2).getValue();
  }

  public void setUtsDot3OnuClassifiOperator2(Integer aUtsDot3OnuClassifiOperator2) {
    getProperty(utsDot3OnuClassifiOperator2).setValue(aUtsDot3OnuClassifiOperator2);
  }

  public Integer getUtsDot3OnuClassifiFSelect3() {
    return (Integer) getProperty(utsDot3OnuClassifiFSelect3).getValue();
  }

  public void setUtsDot3OnuClassifiFSelect3(Integer aUtsDot3OnuClassifiFSelect3) {
    getProperty(utsDot3OnuClassifiFSelect3).setValue(aUtsDot3OnuClassifiFSelect3);
  }

  public String getUtsDot3OnuClassifiFMatch3() {
    return (String) getProperty(utsDot3OnuClassifiFMatch3).getValue();
  }

  public void setUtsDot3OnuClassifiFMatch3(String aUtsDot3OnuClassifiFMatch3) {
    getProperty(utsDot3OnuClassifiFMatch3).setValue(aUtsDot3OnuClassifiFMatch3);
  }

  public Integer getUtsDot3OnuClassifiOperator3() {
    return (Integer) getProperty(utsDot3OnuClassifiOperator3).getValue();
  }

  public void setUtsDot3OnuClassifiOperator3(Integer aUtsDot3OnuClassifiOperator3) {
    getProperty(utsDot3OnuClassifiOperator3).setValue(aUtsDot3OnuClassifiOperator3);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuClassifiPrecedence));
    prepareRead(super.getProperty(utsDot3OnuClassifiQueueMapped));
    prepareRead(super.getProperty(utsDot3OnuClassifiEtherPriMark));
    prepareRead(super.getProperty(utsDot3OnuClassifiFSelect1));
    prepareRead(super.getProperty(utsDot3OnuClassifiFMatch1));
    prepareRead(super.getProperty(utsDot3OnuClassifiOperator1));
    prepareRead(super.getProperty(utsDot3OnuClassifiFSelect2));
    prepareRead(super.getProperty(utsDot3OnuClassifiFMatch2));
    prepareRead(super.getProperty(utsDot3OnuClassifiOperator2));
    prepareRead(super.getProperty(utsDot3OnuClassifiFSelect3));
    prepareRead(super.getProperty(utsDot3OnuClassifiFMatch3));
    prepareRead(super.getProperty(utsDot3OnuClassifiOperator3));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuClassifiPrecedence));
    prepareRead(super.getProperty(utsDot3OnuClassifiQueueMapped));
    prepareRead(super.getProperty(utsDot3OnuClassifiEtherPriMark));
    prepareRead(super.getProperty(utsDot3OnuClassifiFSelect1));
    prepareRead(super.getProperty(utsDot3OnuClassifiFMatch1));
    prepareRead(super.getProperty(utsDot3OnuClassifiOperator1));
    prepareRead(super.getProperty(utsDot3OnuClassifiFSelect2));
    prepareRead(super.getProperty(utsDot3OnuClassifiFMatch2));
    prepareRead(super.getProperty(utsDot3OnuClassifiOperator2));
    prepareRead(super.getProperty(utsDot3OnuClassifiFSelect3));
    prepareRead(super.getProperty(utsDot3OnuClassifiFMatch3));
    prepareRead(super.getProperty(utsDot3OnuClassifiOperator3));


    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
                             , 1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OnuClassifiRuleIndex));
    prepareSave(getProperty(utsDot3OnuClassifiPrecedence));
    prepareSave(getProperty(utsDot3OnuClassifiQueueMapped));
    prepareSave(getProperty(utsDot3OnuClassifiEtherPriMark));
    prepareSave(getProperty(utsDot3OnuClassifiFSelect1));
    prepareSave(getProperty(utsDot3OnuClassifiFMatch1));
    prepareSave(getProperty(utsDot3OnuClassifiOperator1));
    prepareSave(getProperty(utsDot3OnuClassifiFSelect2));
    prepareSave(getProperty(utsDot3OnuClassifiFMatch2));
    prepareSave(getProperty(utsDot3OnuClassifiOperator2));
    prepareSave(getProperty(utsDot3OnuClassifiFSelect3));
    prepareSave(getProperty(utsDot3OnuClassifiFMatch3));
    prepareSave(getProperty(utsDot3OnuClassifiOperator3));


    return save();
  }


  public boolean add() throws MibBeanException {
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }


  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

}
    
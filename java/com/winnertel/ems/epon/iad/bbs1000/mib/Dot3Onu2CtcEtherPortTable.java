/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs1000.mib;

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
public class Dot3Onu2CtcEtherPortTable extends SnmpMibBean {
  public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
  public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
  public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
  public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
  public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
  public static final String utsDot3OnuEtherPortPhyAdminState = "utsDot3OnuEtherPortPhyAdminState";
  public static final String utsDot3OnuEtherPortPhyAdminCtrl = "utsDot3OnuEtherPortPhyAdminCtrl";
  public static final String utsDot3OnuEtherPortAutoNegAdminSt = "utsDot3OnuEtherPortAutoNegAdminSt";
  public static final String utsDot3OnuEtherPortAutoNegLocTec = "utsDot3OnuEtherPortAutoNegLocTec";
  public static final String utsDot3OnuEtherPortAutoNegAbility = "utsDot3OnuEtherPortAutoNegAbility";
  public static final String utsDot3OnuEtherPortAutoNegRestart = "utsDot3OnuEtherPortAutoNegRestart";
  public static final String utsDot3OnuEtherPortAutoNegAdminCtrl = "utsDot3OnuEtherPortAutoNegAdminCtrl";
  public static final String utsDot3OnuEtherPortLinkState = "utsDot3OnuEtherPortLinkState";
  public static final String utsDot3OnuEtherPortPause = "utsDot3OnuEtherPortPause";
  public static final String utsDot3OnuEtherPortPolicingEnable = "utsDot3OnuEtherPortPolicingEnable";
  public static final String utsDot3OnuEtherPortPolicingCIR = "utsDot3OnuEtherPortPolicingCIR";
  public static final String utsDot3OnuEtherPortPolicingCBS = "utsDot3OnuEtherPortPolicingCBS";
  public static final String utsDot3OnuEtherPortPolicingEBS = "utsDot3OnuEtherPortPolicingEBS";
  public static final String utsDot3OnuEtherPortVlanMode = "utsDot3OnuEtherPortVlanMode";
  public static final String utsDot3OnuEtherPortVlanTPID = "utsDot3OnuEtherPortVlanTPID";
  public static final String utsDot3OnuEtherPortVlanTag = "utsDot3OnuEtherPortVlanTag";
//  public static final String utsDot3OnuEtherPortVlanDefTag = "utsDot3OnuEtherPortVlanDefTag";
  public static final String utsDot3OnuEtherPortVlanTranslation = "utsDot3OnuEtherPortVlanTranslation";
  public static final String utsDot3OnuEtherPortMaxMVlanNum = "utsDot3OnuEtherPortMaxMVlanNum";
  public static final String utsDot3OnuEtherPortMVlanList = "utsDot3OnuEtherPortMVlanList";
  public static final String utsDot3OnuEtherPortMVlanClear = "utsDot3OnuEtherPortMVlanClear";
  public static final String utsDot3OnuEtherPortMaxMcGroupNum = "utsDot3OnuEtherPortMaxMcGroupNum";
  public static final String utsDot3OnuEtherPortMaxMcTagStripe = "utsDot3OnuEtherPortMaxMcTagStripe";
  public static final String utsDot3OnuEtherPortClassifiRuleClear = "utsDot3OnuEtherPortClassifiRuleClear";

  public Dot3Onu2CtcEtherPortTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPhyAdminState, new SnmpMibBeanProperty(utsDot3OnuEtherPortPhyAdminState, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPhyAdminCtrl, new SnmpMibBeanProperty(utsDot3OnuEtherPortPhyAdminCtrl, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortAutoNegAdminSt, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegAdminSt, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.8", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortAutoNegLocTec, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegLocTec, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.9", ISnmpConstant.OCTETS));
    initProperty(utsDot3OnuEtherPortAutoNegAbility, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegAbility, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.10", ISnmpConstant.OCTETS));
    initProperty(utsDot3OnuEtherPortAutoNegRestart, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegRestart, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.11", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortAutoNegAdminCtrl, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegAdminCtrl, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.12", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortLinkState, new SnmpMibBeanProperty(utsDot3OnuEtherPortLinkState, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.30", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPause, new SnmpMibBeanProperty(utsDot3OnuEtherPortPause, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.31", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPolicingEnable, new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.32", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPolicingCIR, new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingCIR, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.33", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPolicingCBS, new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingCBS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.34", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortPolicingEBS, new SnmpMibBeanProperty(utsDot3OnuEtherPortPolicingEBS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.35", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortVlanMode, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.36", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortVlanTPID, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTPID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.37", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortVlanTag, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTag, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.38", ISnmpConstant.INTEGER));
//    initProperty(utsDot3OnuEtherPortVlanDefTag, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanDefTag, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.39", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortVlanTranslation, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTranslation, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.40", ISnmpConstant.OCTETS));
    initProperty(utsDot3OnuEtherPortMaxMVlanNum, new SnmpMibBeanProperty(utsDot3OnuEtherPortMaxMVlanNum, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.41", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortMVlanList, new SnmpMibBeanProperty(utsDot3OnuEtherPortMVlanList, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.42", ISnmpConstant.OCTETS));
    initProperty(utsDot3OnuEtherPortMVlanClear, new SnmpMibBeanProperty(utsDot3OnuEtherPortMVlanClear, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.43", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortMaxMcGroupNum, new SnmpMibBeanProperty(utsDot3OnuEtherPortMaxMcGroupNum, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.44", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortMaxMcTagStripe, new SnmpMibBeanProperty(utsDot3OnuEtherPortMaxMcTagStripe, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.45", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortClassifiRuleClear, new SnmpMibBeanProperty(utsDot3OnuEtherPortClassifiRuleClear, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.46", ISnmpConstant.INTEGER));
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


  public Integer getUtsDot3OnuEtherPortPhyAdminState() {
    return (Integer) getProperty(utsDot3OnuEtherPortPhyAdminState).getValue();
  }

  public void setUtsDot3OnuEtherPortPhyAdminState(Integer aUtsDot3OnuEtherPortPhyAdminState) {
    getProperty(utsDot3OnuEtherPortPhyAdminState).setValue(aUtsDot3OnuEtherPortPhyAdminState);
  }

  public Integer getUtsDot3OnuEtherPortPhyAdminCtrl() {
    return (Integer) getProperty(utsDot3OnuEtherPortPhyAdminCtrl).getValue();
  }

  public void setUtsDot3OnuEtherPortPhyAdminCtrl(Integer aUtsDot3OnuEtherPortPhyAdminCtrl) {
    getProperty(utsDot3OnuEtherPortPhyAdminCtrl).setValue(aUtsDot3OnuEtherPortPhyAdminCtrl);
  }

  public Integer getUtsDot3OnuEtherPortAutoNegAdminSt() {
    return (Integer) getProperty(utsDot3OnuEtherPortAutoNegAdminSt).getValue();
  }

  public void setUtsDot3OnuEtherPortAutoNegAdminSt(Integer aUtsDot3OnuEtherPortAutoNegAdminSt) {
    getProperty(utsDot3OnuEtherPortAutoNegAdminSt).setValue(aUtsDot3OnuEtherPortAutoNegAdminSt);
  }

  public byte[] getUtsDot3OnuEtherPortAutoNegLocTec() {
    return (byte[]) getProperty(utsDot3OnuEtherPortAutoNegLocTec).getValue();
  }

  public void setUtsDot3OnuEtherPortAutoNegLocTec(byte[] aUtsDot3OnuEtherPortAutoNegLocTec) {
    getProperty(utsDot3OnuEtherPortAutoNegLocTec).setValue(aUtsDot3OnuEtherPortAutoNegLocTec);
  }

  public byte[] getUtsDot3OnuEtherPortAutoNegAbility() {
    return (byte[]) getProperty(utsDot3OnuEtherPortAutoNegAbility).getValue();
  }

  public void setUtsDot3OnuEtherPortAutoNegAbility(byte[] aUtsDot3OnuEtherPortAutoNegAbility) {
    getProperty(utsDot3OnuEtherPortAutoNegAbility).setValue(aUtsDot3OnuEtherPortAutoNegAbility);
  }

  public Integer getUtsDot3OnuEtherPortAutoNegRestart() {
    return (Integer) getProperty(utsDot3OnuEtherPortAutoNegRestart).getValue();
  }

  public void setUtsDot3OnuEtherPortAutoNegRestart(Integer aUtsDot3OnuEtherPortAutoNegRestart) {
    getProperty(utsDot3OnuEtherPortAutoNegRestart).setValue(aUtsDot3OnuEtherPortAutoNegRestart);
  }

  public Integer getUtsDot3OnuEtherPortAutoNegAdminCtrl() {
    return (Integer) getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl).getValue();
  }

  public void setUtsDot3OnuEtherPortAutoNegAdminCtrl(Integer aUtsDot3OnuEtherPortAutoNegAdminCtrl) {
    getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl).setValue(aUtsDot3OnuEtherPortAutoNegAdminCtrl);
  }

  public Integer getUtsDot3OnuEtherPortLinkState() {
    return (Integer) getProperty(utsDot3OnuEtherPortLinkState).getValue();
  }

  public void setUtsDot3OnuEtherPortLinkState(Integer aUtsDot3OnuEtherPortLinkState) {
    getProperty(utsDot3OnuEtherPortLinkState).setValue(aUtsDot3OnuEtherPortLinkState);
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

  public Integer getUtsDot3OnuEtherPortVlanMode() {
    return (Integer) getProperty(utsDot3OnuEtherPortVlanMode).getValue();
  }

  public void setUtsDot3OnuEtherPortVlanMode(Integer aUtsDot3OnuEtherPortVlanMode) {
    getProperty(utsDot3OnuEtherPortVlanMode).setValue(aUtsDot3OnuEtherPortVlanMode);
  }

  public Integer getUtsDot3OnuEtherPortVlanTPID() {
    return (Integer) getProperty(utsDot3OnuEtherPortVlanTPID).getValue();
  }

  public void setUtsDot3OnuEtherPortVlanTPID(Integer aUtsDot3OnuEtherPortVlanTPID) {
    getProperty(utsDot3OnuEtherPortVlanTPID).setValue(aUtsDot3OnuEtherPortVlanTPID);
  }

  public Integer getUtsDot3OnuEtherPortVlanTag() {
    return (Integer) getProperty(utsDot3OnuEtherPortVlanTag).getValue();
  }

  public void setUtsDot3OnuEtherPortVlanTag(Integer aUtsDot3OnuEtherPortVlanTag) {
    getProperty(utsDot3OnuEtherPortVlanTag).setValue(aUtsDot3OnuEtherPortVlanTag);
  }

//  public Integer getUtsDot3OnuEtherPortVlanDefTag() {
//    return (Integer) getProperty(utsDot3OnuEtherPortVlanDefTag).getValue();
//  }
//
//  public void setUtsDot3OnuEtherPortVlanDefTag(Integer aUtsDot3OnuEtherPortVlanDefTag) {
//    getProperty(utsDot3OnuEtherPortVlanDefTag).setValue(aUtsDot3OnuEtherPortVlanDefTag);
//  }

  public byte[] getUtsDot3OnuEtherPortVlanTranslation() {
    return (byte[]) getProperty(utsDot3OnuEtherPortVlanTranslation).getValue();
  }

  public void setUtsDot3OnuEtherPortVlanTranslation(byte[] aUtsDot3OnuEtherPortVlanTranslation) {
    getProperty(utsDot3OnuEtherPortVlanTranslation).setValue(aUtsDot3OnuEtherPortVlanTranslation);
  }

  public Integer getUtsDot3OnuEtherPortMaxMVlanNum() {
    return (Integer) getProperty(utsDot3OnuEtherPortMaxMVlanNum).getValue();
  }

  public void setUtsDot3OnuEtherPortMaxMVlanNum(Integer aUtsDot3OnuEtherPortMaxMVlanNum) {
    getProperty(utsDot3OnuEtherPortMaxMVlanNum).setValue(aUtsDot3OnuEtherPortMaxMVlanNum);
  }

  public byte[] getUtsDot3OnuEtherPortMVlanList() {
    return (byte[]) getProperty(utsDot3OnuEtherPortMVlanList).getValue();
  }

  public void setUtsDot3OnuEtherPortMVlanList(byte[] aUtsDot3OnuEtherPortMVlanList) {
    getProperty(utsDot3OnuEtherPortMVlanList).setValue(aUtsDot3OnuEtherPortMVlanList);
  }

  public Integer getUtsDot3OnuEtherPortMVlanClear() {
    return (Integer) getProperty(utsDot3OnuEtherPortMVlanClear).getValue();
  }

  public void setUtsDot3OnuEtherPortMVlanClear(Integer aUtsDot3OnuEtherPortMVlanClear) {
    getProperty(utsDot3OnuEtherPortMVlanClear).setValue(aUtsDot3OnuEtherPortMVlanClear);
  }

  public Integer getUtsDot3OnuEtherPortMaxMcGroupNum() {
    return (Integer) getProperty(utsDot3OnuEtherPortMaxMcGroupNum).getValue();
  }

  public void setUtsDot3OnuEtherPortMaxMcGroupNum(Integer aUtsDot3OnuEtherPortMaxMcGroupNum) {
    getProperty(utsDot3OnuEtherPortMaxMcGroupNum).setValue(aUtsDot3OnuEtherPortMaxMcGroupNum);
  }

  public Integer getUtsDot3OnuEtherPortMaxMcTagStripe() {
    return (Integer) getProperty(utsDot3OnuEtherPortMaxMcTagStripe).getValue();
  }

  public void setUtsDot3OnuEtherPortMaxMcTagStripe(Integer aUtsDot3OnuEtherPortMaxMcTagStripe) {
    getProperty(utsDot3OnuEtherPortMaxMcTagStripe).setValue(aUtsDot3OnuEtherPortMaxMcTagStripe);
  }

  public Integer getUtsDot3OnuEtherPortClassifiRuleClear()
  {
    return (Integer) getProperty(utsDot3OnuEtherPortClassifiRuleClear).getValue();
  }

  public void setUtsDot3OnuEtherPortClassifiRuleClear(Integer aUtsDot3OnuEtherPortClassifiRuleClear)
  {
    getProperty(utsDot3OnuEtherPortClassifiRuleClear).setValue(aUtsDot3OnuEtherPortClassifiRuleClear);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuEtherPortPhyAdminState));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegAdminSt));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegLocTec));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegAbility));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegRestart));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));
    prepareRead(super.getProperty(utsDot3OnuEtherPortLinkState));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPause));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEnable));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCIR));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCBS));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEBS));
    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanMode));
    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTPID));
    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTag));
//    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanDefTag));
    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTranslation));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMaxMVlanNum));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMVlanList));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMVlanClear));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMaxMcGroupNum));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMaxMcTagStripe));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuEtherPortPhyAdminState));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegAdminSt));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegLocTec));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegAbility));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegRestart));
    prepareRead(super.getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));
    prepareRead(super.getProperty(utsDot3OnuEtherPortLinkState));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPause));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEnable));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCIR));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingCBS));
    prepareRead(super.getProperty(utsDot3OnuEtherPortPolicingEBS));
    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanMode));
    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTPID));
    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTag));
//    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanDefTag));
    prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTranslation));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMaxMVlanNum));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMVlanList));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMVlanClear));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMaxMcGroupNum));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMaxMcTagStripe));

    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
    prepareSave(getProperty(utsDot3OnuEtherPortAutoNegRestart));
    prepareSave(getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));
    prepareSave(getProperty(utsDot3OnuEtherPortPause));
    prepareSave(getProperty(utsDot3OnuEtherPortPolicingEnable));
    prepareSave(getProperty(utsDot3OnuEtherPortPolicingCIR));
    prepareSave(getProperty(utsDot3OnuEtherPortPolicingCBS));
    prepareSave(getProperty(utsDot3OnuEtherPortPolicingEBS));
    prepareSave(getProperty(utsDot3OnuEtherPortVlanMode));
    prepareSave(getProperty(utsDot3OnuEtherPortVlanTPID));
    prepareSave(getProperty(utsDot3OnuEtherPortVlanTag));
//    prepareSave(getProperty(utsDot3OnuEtherPortVlanDefTag));
    prepareSave(getProperty(utsDot3OnuEtherPortVlanTranslation));
    prepareSave(getProperty(utsDot3OnuEtherPortMVlanList));
    prepareSave(getProperty(utsDot3OnuEtherPortMVlanClear));
    prepareSave(getProperty(utsDot3OnuEtherPortMaxMcGroupNum));
    prepareSave(getProperty(utsDot3OnuEtherPortMaxMcTagStripe));

    return save();
  }

  public boolean restartAutoNeg() throws MibBeanException {
    setUtsDot3OnuEtherPortAutoNegRestart(new Integer(1));
    prepareSave(getProperty(utsDot3OnuEtherPortAutoNegRestart));

    return save();
  }

  public boolean clearMulticastVlanList() throws MibBeanException {
    setUtsDot3OnuEtherPortMVlanClear(new Integer(1));
    prepareSave(getProperty(utsDot3OnuEtherPortMVlanClear));

    return save();
  }

  public boolean clearClassifiRule() throws MibBeanException {
    setUtsDot3OnuEtherPortClassifiRuleClear(new Integer(1));
    prepareSave(getProperty(utsDot3OnuEtherPortClassifiRuleClear));

    return save();
  }
}

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
 * The Dot3Onu2CtcClassifiRuleTable class.
 * Created by QuickDVM
 */
public class Dot3Onu2CtcClassifiRuleTable extends SnmpMibBean {
  public static final String utsDot3OnuClassifiRuleProfId = "utsDot3OnuClassifiRuleProfId";
  public static final String utsDot3OnuClassifiRuleId = "utsDot3OnuClassifiRuleId";
  public static final String utsDot3OnuClassifiRuleBitMap = "utsDot3OnuClassifiRuleBitMap";
  public static final String utsDot3OnuClassifiRuleDMacOper = "utsDot3OnuClassifiRuleDMacOper";
  public static final String utsDot3OnuClassifiRuleDMac = "utsDot3OnuClassifiRuleDMac";
  public static final String utsDot3OnuClassifiRuleDMac2 = "utsDot3OnuClassifiRuleDMac2";
  public static final String utsDot3OnuClassifiRuleSMacOper = "utsDot3OnuClassifiRuleSMacOper";
  public static final String utsDot3OnuClassifiRuleSMac = "utsDot3OnuClassifiRuleSMac";
  public static final String utsDot3OnuClassifiRuleSMac2 = "utsDot3OnuClassifiRuleSMac2";
  public static final String utsDot3OnuClassifiRulePriOper = "utsDot3OnuClassifiRulePriOper";
  public static final String utsDot3OnuClassifiRulePri = "utsDot3OnuClassifiRulePri";
  public static final String utsDot3OnuClassifiRulePri2 = "utsDot3OnuClassifiRulePri2";
  public static final String utsDot3OnuClassifiRuleVlanOper = "utsDot3OnuClassifiRuleVlanOper";
  public static final String utsDot3OnuClassifiRuleVlanId = "utsDot3OnuClassifiRuleVlanId";
  public static final String utsDot3OnuClassifiRuleVlanId2 = "utsDot3OnuClassifiRuleVlanId2";
  public static final String utsDot3OnuClassifiRuleTypeOper = "utsDot3OnuClassifiRuleTypeOper";
  public static final String utsDot3OnuClassifiRuleType = "utsDot3OnuClassifiRuleType";
  public static final String utsDot3OnuClassifiRuleType2 = "utsDot3OnuClassifiRuleType2";
  public static final String utsDot3OnuClassifiRuleSIPOper = "utsDot3OnuClassifiRuleSIPOper";
  public static final String utsDot3OnuClassifiRuleSIP = "utsDot3OnuClassifiRuleSIP";
  public static final String utsDot3OnuClassifiRuleSIP2 = "utsDot3OnuClassifiRuleSIP2";
  public static final String utsDot3OnuClassifiRuleDIPOper = "utsDot3OnuClassifiRuleDIPOper";
  public static final String utsDot3OnuClassifiRuleDIP = "utsDot3OnuClassifiRuleDIP";
  public static final String utsDot3OnuClassifiRuleDIP2 = "utsDot3OnuClassifiRuleDIP2";
  public static final String utsDot3OnuClassifiRuleDSCPOper = "utsDot3OnuClassifiRuleDSCPOper";
  public static final String utsDot3OnuClassifiRuleDSCP = "utsDot3OnuClassifiRuleDSCP";
  public static final String utsDot3OnuClassifiRuleDSCP2 = "utsDot3OnuClassifiRuleDSCP2";
  public static final String utsDot3OnuClassifiRuleSPortOper = "utsDot3OnuClassifiRuleSPortOper";
  public static final String utsDot3OnuClassifiRuleSPort1 = "utsDot3OnuClassifiRuleSPort1";
  public static final String utsDot3OnuClassifiRuleSPort2 = "utsDot3OnuClassifiRuleSPort2";
  public static final String utsDot3OnuClassifiRuleDPortOper = "utsDot3OnuClassifiRuleDPortOper";
  public static final String utsDot3OnuClassifiRuleDPort1 = "utsDot3OnuClassifiRuleDPort1";
  public static final String utsDot3OnuClassifiRuleDPort2 = "utsDot3OnuClassifiRuleDPort2";
  public static final String utsDot3OnuClassifiRuleProtocolOper = "utsDot3OnuClassifiRuleProtocolOper";
  public static final String utsDot3OnuClassifiRuleProtocol = "utsDot3OnuClassifiRuleProtocol";
  public static final String utsDot3OnuClassifiRuleProtocol2 = "utsDot3OnuClassifiRuleProtocol2";

  public Dot3Onu2CtcClassifiRuleTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
	    initProperty(utsDot3OnuClassifiRuleProfId, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleProfId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.1", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleId, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.2", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleBitMap, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleBitMap, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.3", ISnmpConstant.STRING));
	    initProperty(utsDot3OnuClassifiRuleDMacOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDMacOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.4", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleDMac, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDMac, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.5", ISnmpConstant.MAC_ADDRESS));
	    initProperty(utsDot3OnuClassifiRuleDMac2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDMac2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.6", ISnmpConstant.MAC_ADDRESS));
	    initProperty(utsDot3OnuClassifiRuleSMacOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSMacOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.7", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleSMac, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSMac, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.8", ISnmpConstant.MAC_ADDRESS));
	    initProperty(utsDot3OnuClassifiRuleSMac2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSMac2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.9", ISnmpConstant.MAC_ADDRESS));
	    initProperty(utsDot3OnuClassifiRulePriOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRulePriOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.10", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRulePri, new SnmpMibBeanProperty(utsDot3OnuClassifiRulePri, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.11", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRulePri2, new SnmpMibBeanProperty(utsDot3OnuClassifiRulePri2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.12", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleVlanOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleVlanOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.13", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleVlanId, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleVlanId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.14", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleVlanId2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleVlanId2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.15", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleTypeOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleTypeOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.16", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleType, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleType, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.17", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleType2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleType2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.18", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleSIPOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSIPOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.19", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleSIP, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSIP, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.20", ISnmpConstant.IP_ADDRESS));
	    initProperty(utsDot3OnuClassifiRuleSIP2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSIP2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.21", ISnmpConstant.IP_ADDRESS));
	    initProperty(utsDot3OnuClassifiRuleDIPOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDIPOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.22", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleDIP, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDIP, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.23", ISnmpConstant.IP_ADDRESS));
	    initProperty(utsDot3OnuClassifiRuleDIP2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDIP2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.24", ISnmpConstant.IP_ADDRESS));
	    initProperty(utsDot3OnuClassifiRuleDSCPOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDSCPOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.25", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleDSCP, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDSCP, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.26", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleDSCP2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDSCP2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.27", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleSPortOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSPortOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.28", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleSPort1, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSPort1, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.29", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleSPort2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleSPort2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.30", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleDPortOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDPortOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.31", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleDPort1, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDPort1, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.32", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleDPort2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleDPort2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.33", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleProtocolOper, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleProtocolOper, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.34", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleProtocol, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleProtocol, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.35", ISnmpConstant.INTEGER));
	    initProperty(utsDot3OnuClassifiRuleProtocol2, new SnmpMibBeanProperty(utsDot3OnuClassifiRuleProtocol2, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.20.1.36", ISnmpConstant.INTEGER));
  }


  public Integer getUtsDot3OnuClassifiRuleProfId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuClassifiRuleProfId(Integer aUtsDot3OnuClassifiRuleProfId) {
    setIndex(0, aUtsDot3OnuClassifiRuleProfId);
  }


  public Integer getUtsDot3OnuClassifiRuleId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuClassifiRuleId(Integer aUtsDot3OnuClassifiRuleId) {
    setIndex(1, aUtsDot3OnuClassifiRuleId);
  }


  public String getUtsDot3OnuClassifiRuleBitMap() {
    return (String) getProperty(utsDot3OnuClassifiRuleBitMap).getValue();
  }

  public void setUtsDot3OnuClassifiRuleBitMap(String aUtsDot3OnuClassifiRuleBitMap) {
    getProperty(utsDot3OnuClassifiRuleBitMap).setValue(aUtsDot3OnuClassifiRuleBitMap);
  }

  public Integer getUtsDot3OnuClassifiRuleDMacOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDMacOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDMacOper(Integer aUtsDot3OnuClassifiRuleDMacOper) {
    getProperty(utsDot3OnuClassifiRuleDMacOper).setValue(aUtsDot3OnuClassifiRuleDMacOper);
  }

  public byte[] getUtsDot3OnuClassifiRuleDMac() {
    return (byte[]) getProperty(utsDot3OnuClassifiRuleDMac).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDMac(byte[] aUtsDot3OnuClassifiRuleDMac) {
    getProperty(utsDot3OnuClassifiRuleDMac).setValue(aUtsDot3OnuClassifiRuleDMac);
  }

  public byte[] getUtsDot3OnuClassifiRuleDMac2() {
    return (byte[]) getProperty(utsDot3OnuClassifiRuleDMac2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDMac2(byte[] aUtsDot3OnuClassifiRuleDMac2) {
    getProperty(utsDot3OnuClassifiRuleDMac2).setValue(aUtsDot3OnuClassifiRuleDMac2);
  }

  public Integer getUtsDot3OnuClassifiRuleSMacOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleSMacOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSMacOper(Integer aUtsDot3OnuClassifiRuleSMacOper) {
    getProperty(utsDot3OnuClassifiRuleSMacOper).setValue(aUtsDot3OnuClassifiRuleSMacOper);
  }

  public byte[] getUtsDot3OnuClassifiRuleSMac() {
    return (byte[]) getProperty(utsDot3OnuClassifiRuleSMac).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSMac(byte[] aUtsDot3OnuClassifiRuleSMac) {
    getProperty(utsDot3OnuClassifiRuleSMac).setValue(aUtsDot3OnuClassifiRuleSMac);
  }

  public byte[] getUtsDot3OnuClassifiRuleSMac2() {
    return (byte[]) getProperty(utsDot3OnuClassifiRuleSMac2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSMac2(byte[] aUtsDot3OnuClassifiRuleSMac2) {
    getProperty(utsDot3OnuClassifiRuleSMac2).setValue(aUtsDot3OnuClassifiRuleSMac2);
  }

  public Integer getUtsDot3OnuClassifiRulePriOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRulePriOper).getValue();
  }

  public void setUtsDot3OnuClassifiRulePriOper(Integer aUtsDot3OnuClassifiRulePriOper) {
    getProperty(utsDot3OnuClassifiRulePriOper).setValue(aUtsDot3OnuClassifiRulePriOper);
  }

  public Integer getUtsDot3OnuClassifiRulePri() {
    return (Integer) getProperty(utsDot3OnuClassifiRulePri).getValue();
  }

  public void setUtsDot3OnuClassifiRulePri(Integer aUtsDot3OnuClassifiRulePri) {
    getProperty(utsDot3OnuClassifiRulePri).setValue(aUtsDot3OnuClassifiRulePri);
  }

  public Integer getUtsDot3OnuClassifiRulePri2() {
    return (Integer) getProperty(utsDot3OnuClassifiRulePri2).getValue();
  }

  public void setUtsDot3OnuClassifiRulePri2(Integer aUtsDot3OnuClassifiRulePri2) {
    getProperty(utsDot3OnuClassifiRulePri2).setValue(aUtsDot3OnuClassifiRulePri2);
  }

  public Integer getUtsDot3OnuClassifiRuleVlanOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleVlanOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleVlanOper(Integer aUtsDot3OnuClassifiRuleVlanOper) {
    getProperty(utsDot3OnuClassifiRuleVlanOper).setValue(aUtsDot3OnuClassifiRuleVlanOper);
  }

  public Integer getUtsDot3OnuClassifiRuleVlanId() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleVlanId).getValue();
  }

  public void setUtsDot3OnuClassifiRuleVlanId(Integer aUtsDot3OnuClassifiRuleVlanId) {
    getProperty(utsDot3OnuClassifiRuleVlanId).setValue(aUtsDot3OnuClassifiRuleVlanId);
  }

  public Integer getUtsDot3OnuClassifiRuleVlanId2() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleVlanId2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleVlanId2(Integer aUtsDot3OnuClassifiRuleVlanId2) {
    getProperty(utsDot3OnuClassifiRuleVlanId2).setValue(aUtsDot3OnuClassifiRuleVlanId2);
  }

  public Integer getUtsDot3OnuClassifiRuleTypeOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleTypeOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleTypeOper(Integer aUtsDot3OnuClassifiRuleTypeOper) {
    getProperty(utsDot3OnuClassifiRuleTypeOper).setValue(aUtsDot3OnuClassifiRuleTypeOper);
  }

  public Integer getUtsDot3OnuClassifiRuleType() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleType).getValue();
  }

  public void setUtsDot3OnuClassifiRuleType(Integer aUtsDot3OnuClassifiRuleType) {
    getProperty(utsDot3OnuClassifiRuleType).setValue(aUtsDot3OnuClassifiRuleType);
  }

  public Integer getUtsDot3OnuClassifiRuleType2() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleType2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleType2(Integer aUtsDot3OnuClassifiRuleType2) {
    getProperty(utsDot3OnuClassifiRuleType2).setValue(aUtsDot3OnuClassifiRuleType2);
  }

  public Integer getUtsDot3OnuClassifiRuleSIPOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleSIPOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSIPOper(Integer aUtsDot3OnuClassifiRuleSIPOper) {
    getProperty(utsDot3OnuClassifiRuleSIPOper).setValue(aUtsDot3OnuClassifiRuleSIPOper);
  }

  public String getUtsDot3OnuClassifiRuleSIP() {
    return (String) getProperty(utsDot3OnuClassifiRuleSIP).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSIP(String aUtsDot3OnuClassifiRuleSIP) {
    getProperty(utsDot3OnuClassifiRuleSIP).setValue(aUtsDot3OnuClassifiRuleSIP);
  }

  public String getUtsDot3OnuClassifiRuleSIP2() {
    return (String) getProperty(utsDot3OnuClassifiRuleSIP2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSIP2(String aUtsDot3OnuClassifiRuleSIP2) {
    getProperty(utsDot3OnuClassifiRuleSIP2).setValue(aUtsDot3OnuClassifiRuleSIP2);
  }

  public Integer getUtsDot3OnuClassifiRuleDIPOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDIPOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDIPOper(Integer aUtsDot3OnuClassifiRuleDIPOper) {
    getProperty(utsDot3OnuClassifiRuleDIPOper).setValue(aUtsDot3OnuClassifiRuleDIPOper);
  }

  public String getUtsDot3OnuClassifiRuleDIP() {
    return (String) getProperty(utsDot3OnuClassifiRuleDIP).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDIP(String aUtsDot3OnuClassifiRuleDIP) {
    getProperty(utsDot3OnuClassifiRuleDIP).setValue(aUtsDot3OnuClassifiRuleDIP);
  }

  public String getUtsDot3OnuClassifiRuleDIP2() {
    return (String) getProperty(utsDot3OnuClassifiRuleDIP2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDIP2(String aUtsDot3OnuClassifiRuleDIP2) {
    getProperty(utsDot3OnuClassifiRuleDIP2).setValue(aUtsDot3OnuClassifiRuleDIP2);
  }

  public Integer getUtsDot3OnuClassifiRuleDSCPOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDSCPOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDSCPOper(Integer aUtsDot3OnuClassifiRuleDSCPOper) {
    getProperty(utsDot3OnuClassifiRuleDSCPOper).setValue(aUtsDot3OnuClassifiRuleDSCPOper);
  }

  public Integer getUtsDot3OnuClassifiRuleDSCP() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDSCP).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDSCP(Integer aUtsDot3OnuClassifiRuleDSCP) {
    getProperty(utsDot3OnuClassifiRuleDSCP).setValue(aUtsDot3OnuClassifiRuleDSCP);
  }

  public Integer getUtsDot3OnuClassifiRuleDSCP2() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDSCP2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDSCP2(Integer aUtsDot3OnuClassifiRuleDSCP2) {
    getProperty(utsDot3OnuClassifiRuleDSCP2).setValue(aUtsDot3OnuClassifiRuleDSCP2);
  }

  public Integer getUtsDot3OnuClassifiRuleSPortOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleSPortOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSPortOper(Integer aUtsDot3OnuClassifiRuleSPortOper) {
    getProperty(utsDot3OnuClassifiRuleSPortOper).setValue(aUtsDot3OnuClassifiRuleSPortOper);
  }

  public Integer getUtsDot3OnuClassifiRuleSPort1() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleSPort1).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSPort1(Integer aUtsDot3OnuClassifiRuleSPort1) {
    getProperty(utsDot3OnuClassifiRuleSPort1).setValue(aUtsDot3OnuClassifiRuleSPort1);
  }

  public Integer getUtsDot3OnuClassifiRuleSPort2() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleSPort2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleSPort2(Integer aUtsDot3OnuClassifiRuleSPort2) {
    getProperty(utsDot3OnuClassifiRuleSPort2).setValue(aUtsDot3OnuClassifiRuleSPort2);
  }

  public Integer getUtsDot3OnuClassifiRuleDPortOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDPortOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDPortOper(Integer aUtsDot3OnuClassifiRuleDPortOper) {
    getProperty(utsDot3OnuClassifiRuleDPortOper).setValue(aUtsDot3OnuClassifiRuleDPortOper);
  }

  public Integer getUtsDot3OnuClassifiRuleDPort1() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDPort1).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDPort1(Integer aUtsDot3OnuClassifiRuleDPort1) {
    getProperty(utsDot3OnuClassifiRuleDPort1).setValue(aUtsDot3OnuClassifiRuleDPort1);
  }

  public Integer getUtsDot3OnuClassifiRuleDPort2() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleDPort2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleDPort2(Integer aUtsDot3OnuClassifiRuleDPort2) {
    getProperty(utsDot3OnuClassifiRuleDPort2).setValue(aUtsDot3OnuClassifiRuleDPort2);
  }

  public Integer getUtsDot3OnuClassifiRuleProtocolOper() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleProtocolOper).getValue();
  }

  public void setUtsDot3OnuClassifiRuleProtocolOper(Integer aUtsDot3OnuClassifiRuleProtocolOper) {
    getProperty(utsDot3OnuClassifiRuleProtocolOper).setValue(aUtsDot3OnuClassifiRuleProtocolOper);
  }

  public Integer getUtsDot3OnuClassifiRuleProtocol() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleProtocol).getValue();
  }

  public void setUtsDot3OnuClassifiRuleProtocol(Integer aUtsDot3OnuClassifiRuleProtocol) {
    getProperty(utsDot3OnuClassifiRuleProtocol).setValue(aUtsDot3OnuClassifiRuleProtocol);
  }

  public Integer getUtsDot3OnuClassifiRuleProtocol2() {
    return (Integer) getProperty(utsDot3OnuClassifiRuleProtocol2).getValue();
  }

  public void setUtsDot3OnuClassifiRuleProtocol2(Integer aUtsDot3OnuClassifiRuleProtocol2) {
    getProperty(utsDot3OnuClassifiRuleProtocol2).setValue(aUtsDot3OnuClassifiRuleProtocol2);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleBitMap));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDMacOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDMac));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleDMac2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSMacOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSMac));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleSMac2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRulePriOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRulePri));
	prepareRead(super.getProperty(utsDot3OnuClassifiRulePri2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleVlanOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleVlanId));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleVlanId2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleTypeOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleType));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleType2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSIPOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSIP));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleSIP2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDIPOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDIP));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleDIP2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDSCPOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDSCP));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleDSCP2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSPortOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSPort1));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSPort2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDPortOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDPort1));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDPort2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleProtocolOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleProtocol));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleProtocol2));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleBitMap));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDMacOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDMac));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleDMac2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSMacOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSMac));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleSMac2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRulePriOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRulePri));
	prepareRead(super.getProperty(utsDot3OnuClassifiRulePri2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleVlanOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleVlanId));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleVlanId2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleTypeOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleType));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleType2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSIPOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSIP));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleSIP2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDIPOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDIP));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleDIP2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDSCPOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDSCP));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleDSCP2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSPortOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSPort1));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleSPort2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDPortOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDPort1));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleDPort2));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleProtocolOper));
    prepareRead(super.getProperty(utsDot3OnuClassifiRuleProtocol));
	prepareRead(super.getProperty(utsDot3OnuClassifiRuleProtocol2));

    return loadAll(new int[]{1 , 1 });
  }


}

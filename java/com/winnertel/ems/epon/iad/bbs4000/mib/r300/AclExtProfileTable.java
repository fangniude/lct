package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The AclExtProfileTable class.
 * Created by QuickDVM
 */
public class AclExtProfileTable extends SnmpMibBean {
  public static final String utsAclExtProfileId = "utsAclExtProfileId";
  public static final String utsAclExtProfileFieldId = "utsAclExtProfileFieldId";
  public static final String utsAclExtProfileRuleId = "utsAclExtProfileRuleId";
  public static final String utsAclExtProfileName = "utsAclExtProfileName";
  public static final String utsAclExtProfileFieldName = "utsAclExtProfileFieldName";
  public static final String utsAclExtProfileRuleName = "utsAclExtProfileRuleName";
  public static final String utsAclExtProfileFieldBitmap = "utsAclExtProfileFieldBitmap";
  public static final String utsAclExtProfileFieldMaskDstMac = "utsAclExtProfileFieldMaskDstMac";
  public static final String utsAclExtProfileFieldMaskSrcMac = "utsAclExtProfileFieldMaskSrcMac";
  public static final String utsAclExtProfileFieldMaskArpTargetMac = "utsAclExtProfileFieldMaskArpTargetMac";
  public static final String utsAclExtProfileFieldMaskArpSendMac = "utsAclExtProfileFieldMaskArpSendMac";
  public static final String utsAclExtProfileFieldMaskSrcIp = "utsAclExtProfileFieldMaskSrcIp";
  public static final String utsAclExtProfileFieldMaskDstIp = "utsAclExtProfileFieldMaskDstIp";
  public static final String utsAclExtProfileFieldMaskVlan = "utsAclExtProfileFieldMaskVlan";
  public static final String utsAclExtProfileFieldMaskEtherType = "utsAclExtProfileFieldMaskEtherType";
  public static final String utsAclExtProfileFieldMaskTcpSrcPort = "utsAclExtProfileFieldMaskTcpSrcPort";
  public static final String utsAclExtProfileFieldMaskTcpDstPort = "utsAclExtProfileFieldMaskTcpDstPort";
  public static final String utsAclExtProfileFieldMaskSrcPortMin = "utsAclExtProfileFieldMaskSrcPortMin";
  public static final String utsAclExtProfileFieldMaskSrcPortMax = "utsAclExtProfileFieldMaskSrcPortMax";
  public static final String utsAclExtProfileFieldMaskDstPortMin = "utsAclExtProfileFieldMaskDstPortMin";
  public static final String utsAclExtProfileFieldMaskDstPortMax = "utsAclExtProfileFieldMaskDstPortMax";
  public static final String utsAclExtProfileFieldMaskTagPri = "utsAclExtProfileFieldMaskTagPri";
  public static final String utsAclExtProfileFieldMaskDscp = "utsAclExtProfileFieldMaskDscp";
  public static final String utsAclExtProfileFieldMaskProtocol = "utsAclExtProfileFieldMaskProtocol";
  public static final String utsAclExtProfileFieldMaskIHL = "utsAclExtProfileFieldMaskIHL";
  public static final String utsAclExtProfileFieldMaskFragmentOffset = "utsAclExtProfileFieldMaskFragmentOffset";
  public static final String utsAclExtProfileRuleValDstMac = "utsAclExtProfileRuleValDstMac";
  public static final String utsAclExtProfileRuleValSrcMac = "utsAclExtProfileRuleValSrcMac";
  public static final String utsAclExtProfileRuleValArpTargetMac = "utsAclExtProfileRuleValArpTargetMac";
  public static final String utsAclExtProfileRuleValArpSendMac = "utsAclExtProfileRuleValArpSendMac";
  public static final String utsAclExtProfileRuleValSrcIp = "utsAclExtProfileRuleValSrcIp";
  public static final String utsAclExtProfileRuleValDstIp = "utsAclExtProfileRuleValDstIp";
  public static final String utsAclExtProfileRuleValVlan = "utsAclExtProfileRuleValVlan";
  public static final String utsAclExtProfileRuleValEtherType = "utsAclExtProfileRuleValEtherType";
  public static final String utsAclExtProfileRuleValTcpSrcPort = "utsAclExtProfileRuleValTcpSrcPort";
  public static final String utsAclExtProfileRuleValTcpDstPort = "utsAclExtProfileRuleValTcpDstPort";
  public static final String utsAclExtProfileRuleValSrcPortMin = "utsAclExtProfileRuleValSrcPortMin";
  public static final String utsAclExtProfileRuleValSrcPortMax = "utsAclExtProfileRuleValSrcPortMax";
  public static final String utsAclExtProfileRuleValDstPortMin = "utsAclExtProfileRuleValDstPortMin";
  public static final String utsAclExtProfileRuleValDstPortMax = "utsAclExtProfileRuleValDstPortMax";
  public static final String utsAclExtProfileRuleValTagPri = "utsAclExtProfileRuleValTagPri";
  public static final String utsAclExtProfileRuleValDscp = "utsAclExtProfileRuleValDscp";
  public static final String utsAclExtProfileRuleValProtocol = "utsAclExtProfileRuleValProtocol";
  public static final String utsAclExtProfileRuleValNewDscp = "utsAclExtProfileRuleValNewDscp";
  public static final String utsAclExtProfileRuleValNewTagPri = "utsAclExtProfileRuleValNewTagPri";
  public static final String utsAclExtProfileRuleValNewBandwidth = "utsAclExtProfileRuleValNewBandwidth";
  public static final String utsAclExtProfileRuleValNewBurstSize = "utsAclExtProfileRuleValNewBurstSize";
  public static final String utsAclExtProfileRuleValNewOutPort = "utsAclExtProfileRuleValNewOutPort";
  public static final String utsAclExtProfileRuleValNewOutTag = "utsAclExtProfileRuleValNewOutTag";
  public static final String utsAclExtProfileRuleValNewVlanId = "utsAclExtProfileRuleValNewVlanId";
  public static final String utsAclExtProfileRuleValIHL = "utsAclExtProfileRuleValIHL";
  public static final String utsAclExtProfileRuleValFragmentOffset = "utsAclExtProfileRuleValFragmentOffset";
  public static final String utsAclExtProfileRuleValAction = "utsAclExtProfileRuleValAction";
  public static final String utsAclExtProfileFieldMaskInVlan  = "utsAclExtProfileFieldMaskInVlan";
  public static final String utsAclExtProfileFieldMaskInTagPri = "utsAclExtProfileFieldMaskInTagPri";
  public static final String utsAclExtProfileRuleValInVlan = "utsAclExtProfileRuleValInVlan";
  public static final String utsAclExtProfileRuleValInTagPri = "utsAclExtProfileRuleValInTagPri";
  public AclExtProfileTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsAclExtProfileId, new SnmpMibBeanProperty(utsAclExtProfileId, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.1", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldId, new SnmpMibBeanProperty(utsAclExtProfileFieldId, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.2", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleId, new SnmpMibBeanProperty(utsAclExtProfileRuleId, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.3", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileName, new SnmpMibBeanProperty(utsAclExtProfileName, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.4", ISnmpConstant.STRING));
    initProperty(utsAclExtProfileFieldName, new SnmpMibBeanProperty(utsAclExtProfileFieldName, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.5", ISnmpConstant.STRING));
    initProperty(utsAclExtProfileRuleName, new SnmpMibBeanProperty(utsAclExtProfileRuleName, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.6", ISnmpConstant.STRING));
    initProperty(utsAclExtProfileFieldBitmap, new SnmpMibBeanProperty(utsAclExtProfileFieldBitmap, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.7", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskDstMac, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskDstMac, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.8", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsAclExtProfileFieldMaskSrcMac, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskSrcMac, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.9", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsAclExtProfileFieldMaskArpTargetMac, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskArpTargetMac, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.10", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsAclExtProfileFieldMaskArpSendMac, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskArpSendMac, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.11", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsAclExtProfileFieldMaskSrcIp, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskSrcIp, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.12", ISnmpConstant.STRING));
    initProperty(utsAclExtProfileFieldMaskDstIp, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskDstIp, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.13", ISnmpConstant.STRING));
    initProperty(utsAclExtProfileFieldMaskVlan, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskVlan, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.14", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskEtherType, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskEtherType, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.15", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskTcpSrcPort, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskTcpSrcPort, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.16", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskTcpDstPort, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskTcpDstPort, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.17", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskSrcPortMin, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskSrcPortMin, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.18", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskSrcPortMax, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskSrcPortMax, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.19", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskDstPortMin, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskDstPortMin, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.20", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskDstPortMax, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskDstPortMax, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.21", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskTagPri, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskTagPri, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.22", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskDscp, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskDscp, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.23", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskProtocol, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskProtocol, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.24", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskIHL, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskIHL, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.25", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskFragmentOffset, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskFragmentOffset, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.26", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValDstMac, new SnmpMibBeanProperty(utsAclExtProfileRuleValDstMac, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.100", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsAclExtProfileRuleValSrcMac, new SnmpMibBeanProperty(utsAclExtProfileRuleValSrcMac, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.101", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsAclExtProfileRuleValArpTargetMac, new SnmpMibBeanProperty(utsAclExtProfileRuleValArpTargetMac, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.102", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsAclExtProfileRuleValArpSendMac, new SnmpMibBeanProperty(utsAclExtProfileRuleValArpSendMac, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.103", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsAclExtProfileRuleValSrcIp, new SnmpMibBeanProperty(utsAclExtProfileRuleValSrcIp, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.104", ISnmpConstant.STRING));
    initProperty(utsAclExtProfileRuleValDstIp, new SnmpMibBeanProperty(utsAclExtProfileRuleValDstIp, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.105", ISnmpConstant.STRING));
    initProperty(utsAclExtProfileRuleValVlan, new SnmpMibBeanProperty(utsAclExtProfileRuleValVlan, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.106", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValEtherType, new SnmpMibBeanProperty(utsAclExtProfileRuleValEtherType, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.107", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValTcpSrcPort, new SnmpMibBeanProperty(utsAclExtProfileRuleValTcpSrcPort, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.108", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValTcpDstPort, new SnmpMibBeanProperty(utsAclExtProfileRuleValTcpDstPort, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.109", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValSrcPortMin, new SnmpMibBeanProperty(utsAclExtProfileRuleValSrcPortMin, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.110", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValSrcPortMax, new SnmpMibBeanProperty(utsAclExtProfileRuleValSrcPortMax, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.111", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValDstPortMin, new SnmpMibBeanProperty(utsAclExtProfileRuleValDstPortMin, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.112", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValDstPortMax, new SnmpMibBeanProperty(utsAclExtProfileRuleValDstPortMax, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.113", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValTagPri, new SnmpMibBeanProperty(utsAclExtProfileRuleValTagPri, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.114", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValDscp, new SnmpMibBeanProperty(utsAclExtProfileRuleValDscp, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.115", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValProtocol, new SnmpMibBeanProperty(utsAclExtProfileRuleValProtocol, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.116", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValNewDscp, new SnmpMibBeanProperty(utsAclExtProfileRuleValNewDscp, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.117", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValNewTagPri, new SnmpMibBeanProperty(utsAclExtProfileRuleValNewTagPri, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.118", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValNewBandwidth, new SnmpMibBeanProperty(utsAclExtProfileRuleValNewBandwidth, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.119", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValNewBurstSize, new SnmpMibBeanProperty(utsAclExtProfileRuleValNewBurstSize, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.120", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValNewOutPort, new SnmpMibBeanProperty(utsAclExtProfileRuleValNewOutPort, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.121", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValNewOutTag, new SnmpMibBeanProperty(utsAclExtProfileRuleValNewOutTag, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.122", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValNewVlanId, new SnmpMibBeanProperty(utsAclExtProfileRuleValNewVlanId, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.123", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValIHL, new SnmpMibBeanProperty(utsAclExtProfileRuleValIHL, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.124", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValFragmentOffset, new SnmpMibBeanProperty(utsAclExtProfileRuleValFragmentOffset, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.125", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValAction, new SnmpMibBeanProperty(utsAclExtProfileRuleValAction, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.200", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskInVlan, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskInVlan, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.202", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileFieldMaskInTagPri, new SnmpMibBeanProperty(utsAclExtProfileFieldMaskInTagPri, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.203", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValInVlan, new SnmpMibBeanProperty(utsAclExtProfileRuleValInVlan, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.204", ISnmpConstant.INTEGER));
    initProperty(utsAclExtProfileRuleValInTagPri, new SnmpMibBeanProperty(utsAclExtProfileRuleValInTagPri, ".1.3.6.1.4.1.41355.1800.2.4.2.1.1.205", ISnmpConstant.INTEGER));
   
  }


  public Integer getUtsAclExtProfileId() {
    return (Integer) getIndex(0);
  }

  public void setUtsAclExtProfileId(Integer aUtsAclExtProfileId) {
    setIndex(0, aUtsAclExtProfileId);
  }


  public Integer getUtsAclExtProfileFieldId() {
    return (Integer) getIndex(1);
  }

  public void setUtsAclExtProfileFieldId(Integer aUtsAclExtProfileFieldId) {
    setIndex(1, aUtsAclExtProfileFieldId);
  }


  public Integer getUtsAclExtProfileRuleId() {
    return (Integer) getIndex(2);
  }

  public void setUtsAclExtProfileRuleId(Integer aUtsAclExtProfileRuleId) {
    setIndex(2, aUtsAclExtProfileRuleId);
  }


  public String getUtsAclExtProfileName() {
    return (String) getProperty(utsAclExtProfileName).getValue();
  }

  public void setUtsAclExtProfileName(String aUtsAclExtProfileName) {
    getProperty(utsAclExtProfileName).setValue(aUtsAclExtProfileName);
  }

  public String getUtsAclExtProfileFieldName() {
    return (String) getProperty(utsAclExtProfileFieldName).getValue();
  }

  public void setUtsAclExtProfileFieldName(String aUtsAclExtProfileFieldName) {
    getProperty(utsAclExtProfileFieldName).setValue(aUtsAclExtProfileFieldName);
  }

  public String getUtsAclExtProfileRuleName() {
    return (String) getProperty(utsAclExtProfileRuleName).getValue();
  }

  public void setUtsAclExtProfileRuleName(String aUtsAclExtProfileRuleName) {
    getProperty(utsAclExtProfileRuleName).setValue(aUtsAclExtProfileRuleName);
  }

  public Integer getUtsAclExtProfileFieldBitmap() {
    return (Integer) getProperty(utsAclExtProfileFieldBitmap).getValue();
  }

  public void setUtsAclExtProfileFieldBitmap(Integer aUtsAclExtProfileFieldBitmap) {
    getProperty(utsAclExtProfileFieldBitmap).setValue(aUtsAclExtProfileFieldBitmap);
  }

  public byte[] getUtsAclExtProfileFieldMaskDstMac() {
    return (byte[]) getProperty(utsAclExtProfileFieldMaskDstMac).getValue();
  }

  public void setUtsAclExtProfileFieldMaskDstMac(byte[] aUtsAclExtProfileFieldMaskDstMac) {
    getProperty(utsAclExtProfileFieldMaskDstMac).setValue(aUtsAclExtProfileFieldMaskDstMac);
  }

  public byte[] getUtsAclExtProfileFieldMaskSrcMac() {
    return (byte[]) getProperty(utsAclExtProfileFieldMaskSrcMac).getValue();
  }

  public void setUtsAclExtProfileFieldMaskSrcMac(byte[] aUtsAclExtProfileFieldMaskSrcMac) {
    getProperty(utsAclExtProfileFieldMaskSrcMac).setValue(aUtsAclExtProfileFieldMaskSrcMac);
  }

  public byte[] getUtsAclExtProfileFieldMaskArpTargetMac() {
    return (byte[]) getProperty(utsAclExtProfileFieldMaskArpTargetMac).getValue();
  }

  public void setUtsAclExtProfileFieldMaskArpTargetMac(byte[] aUtsAclExtProfileFieldMaskArpTargetMac) {
    getProperty(utsAclExtProfileFieldMaskArpTargetMac).setValue(aUtsAclExtProfileFieldMaskArpTargetMac);
  }

  public byte[] getUtsAclExtProfileFieldMaskArpSendMac() {
    return (byte[]) getProperty(utsAclExtProfileFieldMaskArpSendMac).getValue();
  }

  public void setUtsAclExtProfileFieldMaskArpSendMac(byte[] aUtsAclExtProfileFieldMaskArpSendMac) {
    getProperty(utsAclExtProfileFieldMaskArpSendMac).setValue(aUtsAclExtProfileFieldMaskArpSendMac);
  }

  public String getUtsAclExtProfileFieldMaskSrcIp() {
    return (String) getProperty(utsAclExtProfileFieldMaskSrcIp).getValue();
  }

  public void setUtsAclExtProfileFieldMaskSrcIp(String aUtsAclExtProfileFieldMaskSrcIp) {
    getProperty(utsAclExtProfileFieldMaskSrcIp).setValue(aUtsAclExtProfileFieldMaskSrcIp);
  }

  public String getUtsAclExtProfileFieldMaskDstIp() {
    return (String) getProperty(utsAclExtProfileFieldMaskDstIp).getValue();
  }

  public void setUtsAclExtProfileFieldMaskDstIp(String aUtsAclExtProfileFieldMaskDstIp) {
    getProperty(utsAclExtProfileFieldMaskDstIp).setValue(aUtsAclExtProfileFieldMaskDstIp);
  }

  public Integer getUtsAclExtProfileFieldMaskVlan() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskVlan).getValue();
  }

  public void setUtsAclExtProfileFieldMaskVlan(Integer aUtsAclExtProfileFieldMaskVlan) {
    getProperty(utsAclExtProfileFieldMaskVlan).setValue(aUtsAclExtProfileFieldMaskVlan);
  }

  public Integer getUtsAclExtProfileFieldMaskEtherType() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskEtherType).getValue();
  }

  public void setUtsAclExtProfileFieldMaskEtherType(Integer aUtsAclExtProfileFieldMaskEtherType) {
    getProperty(utsAclExtProfileFieldMaskEtherType).setValue(aUtsAclExtProfileFieldMaskEtherType);
  }

  public Integer getUtsAclExtProfileFieldMaskTcpSrcPort() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskTcpSrcPort).getValue();
  }

  public void setUtsAclExtProfileFieldMaskTcpSrcPort(Integer aUtsAclExtProfileFieldMaskTcpSrcPort) {
    getProperty(utsAclExtProfileFieldMaskTcpSrcPort).setValue(aUtsAclExtProfileFieldMaskTcpSrcPort);
  }

  public Integer getUtsAclExtProfileFieldMaskTcpDstPort() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskTcpDstPort).getValue();
  }

  public void setUtsAclExtProfileFieldMaskTcpDstPort(Integer aUtsAclExtProfileFieldMaskTcpDstPort) {
    getProperty(utsAclExtProfileFieldMaskTcpDstPort).setValue(aUtsAclExtProfileFieldMaskTcpDstPort);
  }

  public Integer getUtsAclExtProfileFieldMaskSrcPortMin() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskSrcPortMin).getValue();
  }

  public void setUtsAclExtProfileFieldMaskSrcPortMin(Integer aUtsAclExtProfileFieldMaskSrcPortMin) {
    getProperty(utsAclExtProfileFieldMaskSrcPortMin).setValue(aUtsAclExtProfileFieldMaskSrcPortMin);
  }

  public Integer getUtsAclExtProfileFieldMaskSrcPortMax() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskSrcPortMax).getValue();
  }

  public void setUtsAclExtProfileFieldMaskSrcPortMax(Integer aUtsAclExtProfileFieldMaskSrcPortMax) {
    getProperty(utsAclExtProfileFieldMaskSrcPortMax).setValue(aUtsAclExtProfileFieldMaskSrcPortMax);
  }

  public Integer getUtsAclExtProfileFieldMaskDstPortMin() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskDstPortMin).getValue();
  }

  public void setUtsAclExtProfileFieldMaskDstPortMin(Integer aUtsAclExtProfileFieldMaskDstPortMin) {
    getProperty(utsAclExtProfileFieldMaskDstPortMin).setValue(aUtsAclExtProfileFieldMaskDstPortMin);
  }

  public Integer getUtsAclExtProfileFieldMaskDstPortMax() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskDstPortMax).getValue();
  }

  public void setUtsAclExtProfileFieldMaskDstPortMax(Integer aUtsAclExtProfileFieldMaskDstPortMax) {
    getProperty(utsAclExtProfileFieldMaskDstPortMax).setValue(aUtsAclExtProfileFieldMaskDstPortMax);
  }

  public Integer getUtsAclExtProfileFieldMaskTagPri() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskTagPri).getValue();
  }

  public void setUtsAclExtProfileFieldMaskTagPri(Integer aUtsAclExtProfileFieldMaskTagPri) {
    getProperty(utsAclExtProfileFieldMaskTagPri).setValue(aUtsAclExtProfileFieldMaskTagPri);
  }

  public Integer getUtsAclExtProfileFieldMaskDscp() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskDscp).getValue();
  }

  public void setUtsAclExtProfileFieldMaskDscp(Integer aUtsAclExtProfileFieldMaskDscp) {
    getProperty(utsAclExtProfileFieldMaskDscp).setValue(aUtsAclExtProfileFieldMaskDscp);
  }

  public Integer getUtsAclExtProfileFieldMaskProtocol() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskProtocol).getValue();
  }

  public void setUtsAclExtProfileFieldMaskProtocol(Integer aUtsAclExtProfileFieldMaskProtocol) {
    getProperty(utsAclExtProfileFieldMaskProtocol).setValue(aUtsAclExtProfileFieldMaskProtocol);
  }

  public Integer getUtsAclExtProfileFieldMaskIHL() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskIHL).getValue();
  }

  public void setUtsAclExtProfileFieldMaskIHL(Integer aUtsAclExtProfileFieldMaskIHL) {
    getProperty(utsAclExtProfileFieldMaskIHL).setValue(aUtsAclExtProfileFieldMaskIHL);
  }

  public Integer getUtsAclExtProfileFieldMaskFragmentOffset() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskFragmentOffset).getValue();
  }

  public void setUtsAclExtProfileFieldMaskFragmentOffset(Integer aUtsAclExtProfileFieldMaskFragmentOffset) {
    getProperty(utsAclExtProfileFieldMaskFragmentOffset).setValue(aUtsAclExtProfileFieldMaskFragmentOffset);
  }

  public byte[] getUtsAclExtProfileRuleValDstMac() {
    return (byte[]) getProperty(utsAclExtProfileRuleValDstMac).getValue();
  }

  public void setUtsAclExtProfileRuleValDstMac(byte[] aUtsAclExtProfileRuleValDstMac) {
    getProperty(utsAclExtProfileRuleValDstMac).setValue(aUtsAclExtProfileRuleValDstMac);
  }

  public byte[] getUtsAclExtProfileRuleValSrcMac() {
    return (byte[]) getProperty(utsAclExtProfileRuleValSrcMac).getValue();
  }

  public void setUtsAclExtProfileRuleValSrcMac(byte[] aUtsAclExtProfileRuleValSrcMac) {
    getProperty(utsAclExtProfileRuleValSrcMac).setValue(aUtsAclExtProfileRuleValSrcMac);
  }

  public byte[] getUtsAclExtProfileRuleValArpTargetMac() {
    return (byte[]) getProperty(utsAclExtProfileRuleValArpTargetMac).getValue();
  }

  public void setUtsAclExtProfileRuleValArpTargetMac(byte[] aUtsAclExtProfileRuleValArpTargetMac) {
    getProperty(utsAclExtProfileRuleValArpTargetMac).setValue(aUtsAclExtProfileRuleValArpTargetMac);
  }

  public byte[] getUtsAclExtProfileRuleValArpSendMac() {
    return (byte[]) getProperty(utsAclExtProfileRuleValArpSendMac).getValue();
  }

  public void setUtsAclExtProfileRuleValArpSendMac(byte[] aUtsAclExtProfileRuleValArpSendMac) {
    getProperty(utsAclExtProfileRuleValArpSendMac).setValue(aUtsAclExtProfileRuleValArpSendMac);
  }

  public String getUtsAclExtProfileRuleValSrcIp() {
    return (String) getProperty(utsAclExtProfileRuleValSrcIp).getValue();
  }

  public void setUtsAclExtProfileRuleValSrcIp(String aUtsAclExtProfileRuleValSrcIp) {
    getProperty(utsAclExtProfileRuleValSrcIp).setValue(aUtsAclExtProfileRuleValSrcIp);
  }

  public String getUtsAclExtProfileRuleValDstIp() {
    return (String) getProperty(utsAclExtProfileRuleValDstIp).getValue();
  }

  public void setUtsAclExtProfileRuleValDstIp(String aUtsAclExtProfileRuleValDstIp) {
    getProperty(utsAclExtProfileRuleValDstIp).setValue(aUtsAclExtProfileRuleValDstIp);
  }

  public Integer getUtsAclExtProfileRuleValVlan() {
    return (Integer) getProperty(utsAclExtProfileRuleValVlan).getValue();
  }

  public void setUtsAclExtProfileRuleValVlan(Integer aUtsAclExtProfileRuleValVlan) {
    getProperty(utsAclExtProfileRuleValVlan).setValue(aUtsAclExtProfileRuleValVlan);
  }

  public Integer getUtsAclExtProfileRuleValEtherType() {
    return (Integer) getProperty(utsAclExtProfileRuleValEtherType).getValue();
  }

  public void setUtsAclExtProfileRuleValEtherType(Integer aUtsAclExtProfileRuleValEtherType) {
    getProperty(utsAclExtProfileRuleValEtherType).setValue(aUtsAclExtProfileRuleValEtherType);
  }

  public Integer getUtsAclExtProfileRuleValTcpSrcPort() {
    return (Integer) getProperty(utsAclExtProfileRuleValTcpSrcPort).getValue();
  }

  public void setUtsAclExtProfileRuleValTcpSrcPort(Integer aUtsAclExtProfileRuleValTcpSrcPort) {
    getProperty(utsAclExtProfileRuleValTcpSrcPort).setValue(aUtsAclExtProfileRuleValTcpSrcPort);
  }

  public Integer getUtsAclExtProfileRuleValTcpDstPort() {
    return (Integer) getProperty(utsAclExtProfileRuleValTcpDstPort).getValue();
  }

  public void setUtsAclExtProfileRuleValTcpDstPort(Integer aUtsAclExtProfileRuleValTcpDstPort) {
    getProperty(utsAclExtProfileRuleValTcpDstPort).setValue(aUtsAclExtProfileRuleValTcpDstPort);
  }

  public Integer getUtsAclExtProfileRuleValSrcPortMin() {
    return (Integer) getProperty(utsAclExtProfileRuleValSrcPortMin).getValue();
  }

  public void setUtsAclExtProfileRuleValSrcPortMin(Integer aUtsAclExtProfileRuleValSrcPortMin) {
    getProperty(utsAclExtProfileRuleValSrcPortMin).setValue(aUtsAclExtProfileRuleValSrcPortMin);
  }

  public Integer getUtsAclExtProfileRuleValSrcPortMax() {
    return (Integer) getProperty(utsAclExtProfileRuleValSrcPortMax).getValue();
  }

  public void setUtsAclExtProfileRuleValSrcPortMax(Integer aUtsAclExtProfileRuleValSrcPortMax) {
    getProperty(utsAclExtProfileRuleValSrcPortMax).setValue(aUtsAclExtProfileRuleValSrcPortMax);
  }

  public Integer getUtsAclExtProfileRuleValDstPortMin() {
    return (Integer) getProperty(utsAclExtProfileRuleValDstPortMin).getValue();
  }

  public void setUtsAclExtProfileRuleValDstPortMin(Integer aUtsAclExtProfileRuleValDstPortMin) {
    getProperty(utsAclExtProfileRuleValDstPortMin).setValue(aUtsAclExtProfileRuleValDstPortMin);
  }

  public Integer getUtsAclExtProfileRuleValDstPortMax() {
    return (Integer) getProperty(utsAclExtProfileRuleValDstPortMax).getValue();
  }

  public void setUtsAclExtProfileRuleValDstPortMax(Integer aUtsAclExtProfileRuleValDstPortMax) {
    getProperty(utsAclExtProfileRuleValDstPortMax).setValue(aUtsAclExtProfileRuleValDstPortMax);
  }

  public Integer getUtsAclExtProfileRuleValTagPri() {
    return (Integer) getProperty(utsAclExtProfileRuleValTagPri).getValue();
  }

  public void setUtsAclExtProfileRuleValTagPri(Integer aUtsAclExtProfileRuleValTagPri) {
    getProperty(utsAclExtProfileRuleValTagPri).setValue(aUtsAclExtProfileRuleValTagPri);
  }

  public Integer getUtsAclExtProfileRuleValDscp() {
    return (Integer) getProperty(utsAclExtProfileRuleValDscp).getValue();
  }

  public void setUtsAclExtProfileRuleValDscp(Integer aUtsAclExtProfileRuleValDscp) {
    getProperty(utsAclExtProfileRuleValDscp).setValue(aUtsAclExtProfileRuleValDscp);
  }

  public Integer getUtsAclExtProfileRuleValProtocol() {
    return (Integer) getProperty(utsAclExtProfileRuleValProtocol).getValue();
  }

  public void setUtsAclExtProfileRuleValProtocol(Integer aUtsAclExtProfileRuleValProtocol) {
    getProperty(utsAclExtProfileRuleValProtocol).setValue(aUtsAclExtProfileRuleValProtocol);
  }

  public Integer getUtsAclExtProfileRuleValNewDscp() {
    return (Integer) getProperty(utsAclExtProfileRuleValNewDscp).getValue();
  }

  public void setUtsAclExtProfileRuleValNewDscp(Integer aUtsAclExtProfileRuleValNewDscp) {
    getProperty(utsAclExtProfileRuleValNewDscp).setValue(aUtsAclExtProfileRuleValNewDscp);
  }

  public Integer getUtsAclExtProfileRuleValNewTagPri() {
    return (Integer) getProperty(utsAclExtProfileRuleValNewTagPri).getValue();
  }

  public void setUtsAclExtProfileRuleValNewTagPri(Integer aUtsAclExtProfileRuleValNewTagPri) {
    getProperty(utsAclExtProfileRuleValNewTagPri).setValue(aUtsAclExtProfileRuleValNewTagPri);
  }

  public Integer getUtsAclExtProfileRuleValNewBandwidth() {
    return (Integer) getProperty(utsAclExtProfileRuleValNewBandwidth).getValue();
  }

  public void setUtsAclExtProfileRuleValNewBandwidth(Integer aUtsAclExtProfileRuleValNewBandwidth) {
    getProperty(utsAclExtProfileRuleValNewBandwidth).setValue(aUtsAclExtProfileRuleValNewBandwidth);
  }

  public Integer getUtsAclExtProfileRuleValNewBurstSize() {
    return (Integer) getProperty(utsAclExtProfileRuleValNewBurstSize).getValue();
  }

  public void setUtsAclExtProfileRuleValNewBurstSize(Integer aUtsAclExtProfileRuleValNewBurstSize) {
    getProperty(utsAclExtProfileRuleValNewBurstSize).setValue(aUtsAclExtProfileRuleValNewBurstSize);
  }

  public Integer getUtsAclExtProfileRuleValNewOutPort() {
    return (Integer) getProperty(utsAclExtProfileRuleValNewOutPort).getValue();
  }

  public void setUtsAclExtProfileRuleValNewOutPort(Integer aUtsAclExtProfileRuleValNewOutPort) {
    getProperty(utsAclExtProfileRuleValNewOutPort).setValue(aUtsAclExtProfileRuleValNewOutPort);
  }

  public Integer getUtsAclExtProfileRuleValNewOutTag() {
    return (Integer) getProperty(utsAclExtProfileRuleValNewOutTag).getValue();
  }

  public void setUtsAclExtProfileRuleValNewOutTag(Integer aUtsAclExtProfileRuleValNewOutTag) {
    getProperty(utsAclExtProfileRuleValNewOutTag).setValue(aUtsAclExtProfileRuleValNewOutTag);
  }

  public Integer getUtsAclExtProfileRuleValNewVlanId() {
    return (Integer) getProperty(utsAclExtProfileRuleValNewVlanId).getValue();
  }

  public void setUtsAclExtProfileRuleValNewVlanId(Integer aUtsAclExtProfileRuleValNewVlanId) {
    getProperty(utsAclExtProfileRuleValNewVlanId).setValue(aUtsAclExtProfileRuleValNewVlanId);
  }

  public Integer getUtsAclExtProfileRuleValIHL() {
    return (Integer) getProperty(utsAclExtProfileRuleValIHL).getValue();
  }

  public void setUtsAclExtProfileRuleValIHL(Integer aUtsAclExtProfileRuleValIHL) {
    getProperty(utsAclExtProfileRuleValIHL).setValue(aUtsAclExtProfileRuleValIHL);
  }

  public Integer getUtsAclExtProfileRuleValFragmentOffset() {
    return (Integer) getProperty(utsAclExtProfileRuleValFragmentOffset).getValue();
  }

  public void setUtsAclExtProfileRuleValFragmentOffset(Integer aUtsAclExtProfileRuleValFragmentOffset) {
    getProperty(utsAclExtProfileRuleValFragmentOffset).setValue(aUtsAclExtProfileRuleValFragmentOffset);
  }

  public Integer getUtsAclExtProfileRuleValAction() {
    return (Integer) getProperty(utsAclExtProfileRuleValAction).getValue();
  }

  public void setUtsAclExtProfileRuleValAction(Integer aUtsAclExtProfileRuleValAction) {
    getProperty(utsAclExtProfileRuleValAction).setValue(aUtsAclExtProfileRuleValAction);
  }
///////
  public Integer getUtsAclExtProfileFieldMaskInVlan() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskInVlan).getValue();
  }

  public void setUtsAclExtProfileFieldMaskInVlan(
      Integer aUtsAclExtProfileFieldMaskInVlan) {
    getProperty(utsAclExtProfileFieldMaskInVlan).setValue(
        aUtsAclExtProfileFieldMaskInVlan);
  }


  public Integer getUtsAclExtProfileFieldMaskInTagPri() {
    return (Integer) getProperty(utsAclExtProfileFieldMaskInTagPri).getValue();
  }

  public void setUtsAclExtProfileFieldMaskInTagPri(
      Integer aUtsAclExtProfileFieldMaskInTagPri) {
    getProperty(utsAclExtProfileFieldMaskInTagPri).setValue(
        aUtsAclExtProfileFieldMaskInTagPri);
  }

  public Integer getUtsAclExtProfileRuleValInVlan() {
    return (Integer) getProperty(utsAclExtProfileRuleValInVlan).getValue();
  }

  public void setUtsAclExtProfileRuleValInVlan(
      Integer aUtsAclExtProfileRuleValInVlan) {
    getProperty(utsAclExtProfileRuleValInVlan).setValue(
        aUtsAclExtProfileRuleValInVlan);
  }

  public Integer getUtsAclExtProfileRuleValInTagPri() {
    return (Integer) getProperty(utsAclExtProfileRuleValInTagPri).getValue();
  }

  public void setUtsAclExtProfileRuleValInTagPri(
      Integer aUtsAclExtProfileRuleValInTagPri) {
    getProperty(utsAclExtProfileRuleValInTagPri).setValue(
        aUtsAclExtProfileRuleValInTagPri);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsAclExtProfileName));
    prepareRead(super.getProperty(utsAclExtProfileFieldName));
    prepareRead(super.getProperty(utsAclExtProfileRuleName));
    prepareRead(super.getProperty(utsAclExtProfileFieldBitmap));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDstMac));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskSrcMac));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskArpTargetMac));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskArpSendMac));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskSrcIp));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDstIp));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskVlan));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskEtherType));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskTcpSrcPort));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskTcpDstPort));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskSrcPortMin));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskSrcPortMax));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDstPortMin));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDstPortMax));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskTagPri));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDscp));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskProtocol));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskIHL));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskFragmentOffset));
    prepareRead(super.getProperty(utsAclExtProfileRuleValDstMac));
    prepareRead(super.getProperty(utsAclExtProfileRuleValSrcMac));
    prepareRead(super.getProperty(utsAclExtProfileRuleValArpTargetMac));
    prepareRead(super.getProperty(utsAclExtProfileRuleValArpSendMac));
    //load twice for too many items.
    load();

    prepareRead(super.getProperty(utsAclExtProfileRuleValSrcIp));
    prepareRead(super.getProperty(utsAclExtProfileRuleValDstIp));
    prepareRead(super.getProperty(utsAclExtProfileRuleValVlan));
    prepareRead(super.getProperty(utsAclExtProfileRuleValEtherType));
    prepareRead(super.getProperty(utsAclExtProfileRuleValTcpSrcPort));
    prepareRead(super.getProperty(utsAclExtProfileRuleValTcpDstPort));
    prepareRead(super.getProperty(utsAclExtProfileRuleValSrcPortMin));
    prepareRead(super.getProperty(utsAclExtProfileRuleValSrcPortMax));
    prepareRead(super.getProperty(utsAclExtProfileRuleValDstPortMin));
    prepareRead(super.getProperty(utsAclExtProfileRuleValDstPortMax));
    prepareRead(super.getProperty(utsAclExtProfileRuleValTagPri));
    prepareRead(super.getProperty(utsAclExtProfileRuleValDscp));
    prepareRead(super.getProperty(utsAclExtProfileRuleValProtocol));
    prepareRead(super.getProperty(utsAclExtProfileRuleValNewDscp));
    prepareRead(super.getProperty(utsAclExtProfileRuleValNewTagPri));
    prepareRead(super.getProperty(utsAclExtProfileRuleValNewBandwidth));
    prepareRead(super.getProperty(utsAclExtProfileRuleValNewBurstSize));
    prepareRead(super.getProperty(utsAclExtProfileRuleValNewOutPort));
    prepareRead(super.getProperty(utsAclExtProfileRuleValNewOutTag));
    prepareRead(super.getProperty(utsAclExtProfileRuleValNewVlanId));
    prepareRead(super.getProperty(utsAclExtProfileRuleValIHL));
    prepareRead(super.getProperty(utsAclExtProfileRuleValFragmentOffset));
    prepareRead(super.getProperty(utsAclExtProfileRuleValAction));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskInVlan));
    prepareRead(super.getProperty(utsAclExtProfileFieldMaskInTagPri));
    prepareRead(super.getProperty(utsAclExtProfileRuleValInVlan));
    prepareRead(super.getProperty(utsAclExtProfileRuleValInTagPri));
    

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsAclExtProfileName));
//    prepareRead(super.getProperty(utsAclExtProfileFieldName));
//    prepareRead(super.getProperty(utsAclExtProfileRuleName));
//    prepareRead(super.getProperty(utsAclExtProfileFieldBitmap));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDstMac));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskSrcMac));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskArpTargetMac));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskArpSendMac));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskSrcIp));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDstIp));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskVlan));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskEtherType));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskTcpSrcPort));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskTcpDstPort));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskSrcPortMin));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskSrcPortMax));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDstPortMin));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDstPortMax));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskTagPri));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskDscp));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskProtocol));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskIHL));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskFragmentOffset));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValDstMac));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValSrcMac));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValArpTargetMac));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValArpSendMac));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValSrcIp));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValDstIp));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValVlan));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValEtherType));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValTcpSrcPort));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValTcpDstPort));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValSrcPortMin));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValSrcPortMax));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValDstPortMin));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValDstPortMax));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValTagPri));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValDscp));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValProtocol));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValNewDscp));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValNewTagPri));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValNewBandwidth));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValNewBurstSize));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValNewOutPort));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValNewOutTag));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValNewVlanId));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValIHL));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValFragmentOffset));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValAction));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskInVlan));
//    prepareRead(super.getProperty(utsAclExtProfileFieldMaskInTagPri));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValInVlan));
//    prepareRead(super.getProperty(utsAclExtProfileRuleValInTagPri));


    Vector v = loadAll(new int[]{1
                             , 1
                             , 1
    });

    if(v != null) {
      for(int i = 0; i < v.size(); i++) {
        AclExtProfileTable one = (AclExtProfileTable)v.get(i);
        one.retrieve();
      }
    }

    return v;
  }


}
    
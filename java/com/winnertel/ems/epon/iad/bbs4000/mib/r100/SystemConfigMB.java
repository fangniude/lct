/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The SystemConfigMB class.
 * Created by Yang Yizai
 */
public class SystemConfigMB extends SnmpMibBean {
  public static final String gponSysCfgFdbAgingTimer = "gponSysCfgFdbAgingTimer";
  public static final String gponSysCfgIgmpProxyRoutingMode = "gponSysCfgIgmpProxyRoutingMode";
  public static final String gponSysCfgAuthenticationMethod = "gponSysCfgAuthenticationMethod";
  public static final String gponSysCfgEncryptionMode = "gponSysCfgEncryptionMode";
  public static final String gponSysCfgKeyExchangeInterval = "gponSysCfgKeyExchangeInterval";
  public static final String gponSysCfgDownstreamBroadcastGEMPortNo = "gponSysCfgDownstreamBroadcastGEMPortNo";

  public SystemConfigMB(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(gponSysCfgFdbAgingTimer, new SnmpMibBeanProperty(
        gponSysCfgFdbAgingTimer, ".1.3.6.1.4.1.45121.1.3.10.5.1.1.1",
        ISnmpConstant.GAUGE));
    initProperty(gponSysCfgIgmpProxyRoutingMode, new SnmpMibBeanProperty(
        gponSysCfgIgmpProxyRoutingMode, ".1.3.6.1.4.1.45121.1.3.10.5.1.1.2",
        ISnmpConstant.INTEGER));
    initProperty(gponSysCfgAuthenticationMethod, new SnmpMibBeanProperty(
        gponSysCfgAuthenticationMethod, ".1.3.6.1.4.1.45121.1.3.10.5.1.1.3",
        ISnmpConstant.INTEGER));
    initProperty(gponSysCfgEncryptionMode, new SnmpMibBeanProperty(
        gponSysCfgEncryptionMode, ".1.3.6.1.4.1.45121.1.3.10.5.1.1.4",
        ISnmpConstant.INTEGER));
    initProperty(gponSysCfgKeyExchangeInterval, new SnmpMibBeanProperty(
        gponSysCfgKeyExchangeInterval, ".1.3.6.1.4.1.45121.1.3.10.5.1.1.5",
        ISnmpConstant.GAUGE));
    initProperty(gponSysCfgDownstreamBroadcastGEMPortNo,
        new SnmpMibBeanProperty(gponSysCfgDownstreamBroadcastGEMPortNo,
            ".1.3.6.1.4.1.45121.1.3.10.5.1.1.6", ISnmpConstant.GAUGE));

  }

  public Long getGponSysCfgFdbAgingTimer() {
    return (Long) getProperty(gponSysCfgFdbAgingTimer).getValue();
  }

  public void setGponSysCfgFdbAgingTimer(Long aGponSysCfgFdbAgingTimer) {
    getProperty(gponSysCfgFdbAgingTimer).setValue(aGponSysCfgFdbAgingTimer);
  }

  public Integer getGponSysCfgIgmpProxyRoutingMode() {
    return (Integer) getProperty(gponSysCfgIgmpProxyRoutingMode).getValue();
  }

  public void setGponSysCfgIgmpProxyRoutingMode(
      Integer aGponSysCfgIgmpProxyRoutingMode) {
    getProperty(gponSysCfgIgmpProxyRoutingMode).setValue(
        aGponSysCfgIgmpProxyRoutingMode);
  }

  public Integer getGponSysCfgAuthenticationMethod() {
    return (Integer) getProperty(gponSysCfgAuthenticationMethod).getValue();
  }

  public void setGponSysCfgAuthenticationMethod(
      Integer aGponSysCfgAuthenticationMethod) {
    getProperty(gponSysCfgAuthenticationMethod).setValue(
        aGponSysCfgAuthenticationMethod);
  }

  public Integer getGponSysCfgEncryptionMode() {
    return (Integer) getProperty(gponSysCfgEncryptionMode).getValue();
  }

  public void setGponSysCfgEncryptionMode(Integer aGponSysCfgEncryptionMode) {
    getProperty(gponSysCfgEncryptionMode).setValue(aGponSysCfgEncryptionMode);
  }

  public Long getGponSysCfgKeyExchangeInterval() {
    return (Long) getProperty(gponSysCfgKeyExchangeInterval).getValue();
  }

  public void setGponSysCfgKeyExchangeInterval(
      Long aGponSysCfgKeyExchangeInterval) {
    getProperty(gponSysCfgKeyExchangeInterval).setValue(
        aGponSysCfgKeyExchangeInterval);
  }

  public Long getGponSysCfgDownstreamBroadcastGEMPortNo() {
    return (Long) getProperty(gponSysCfgDownstreamBroadcastGEMPortNo)
        .getValue();
  }

  public void setGponSysCfgDownstreamBroadcastGEMPortNo(
      Long aGponSysCfgDownstreamBroadcastGEMPortNo) {
    getProperty(gponSysCfgDownstreamBroadcastGEMPortNo).setValue(
        aGponSysCfgDownstreamBroadcastGEMPortNo);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(gponSysCfgFdbAgingTimer));
    prepareRead(super.getProperty(gponSysCfgIgmpProxyRoutingMode));
    prepareRead(super.getProperty(gponSysCfgAuthenticationMethod));
    prepareRead(super.getProperty(gponSysCfgEncryptionMode));
    prepareRead(super.getProperty(gponSysCfgKeyExchangeInterval));
    prepareRead(super.getProperty(gponSysCfgDownstreamBroadcastGEMPortNo));

    return load();
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(gponSysCfgFdbAgingTimer));
    prepareSave(getProperty(gponSysCfgIgmpProxyRoutingMode));
    prepareSave(getProperty(gponSysCfgAuthenticationMethod));
    prepareSave(getProperty(gponSysCfgEncryptionMode));
    prepareSave(getProperty(gponSysCfgKeyExchangeInterval));
    prepareSave(getProperty(gponSysCfgDownstreamBroadcastGEMPortNo));

    return save();
  }

}

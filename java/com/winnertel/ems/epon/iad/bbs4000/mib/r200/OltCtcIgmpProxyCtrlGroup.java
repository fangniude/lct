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

/**
 * The OltCtcIgmpProxyCtrlGroup class.
 * Created by QuickDVM
 */
public class OltCtcIgmpProxyCtrlGroup extends SnmpMibBean {
  public static final String utsOltCtcIgmpProxyVlan = "utsOltCtcIgmpProxyVlan";

  public OltCtcIgmpProxyCtrlGroup(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsOltCtcIgmpProxyVlan, new SnmpMibBeanProperty(utsOltCtcIgmpProxyVlan, ".1.3.6.1.4.1.41355.1800.2.4.3.1.3.1.1", ISnmpConstant.INTEGER));

  }


  public Integer getUtsOltCtcIgmpProxyVlan() {
    return (Integer) getProperty(utsOltCtcIgmpProxyVlan).getValue();
  }

  public void setUtsOltCtcIgmpProxyVlan(Integer aUtsOltCtcIgmpProxyVlan) {
    getProperty(utsOltCtcIgmpProxyVlan).setValue(aUtsOltCtcIgmpProxyVlan);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsOltCtcIgmpProxyVlan));

    return load();
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsOltCtcIgmpProxyVlan));

    return save();
  }


}
    
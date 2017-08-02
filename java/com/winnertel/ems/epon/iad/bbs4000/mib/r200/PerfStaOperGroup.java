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
 * The OltCtcCdrCtrlGroup class.
 * Created by QuickDVM
 */
public class PerfStaOperGroup extends SnmpMibBean {
  public static final String utsPerfStaClearAll = "utsPerfStaClearAll";
  public static final String utsPerfStaPMEnable = "utsPerfStaPMEnable";

  public PerfStaOperGroup(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsPerfStaClearAll, new SnmpMibBeanProperty(utsPerfStaClearAll, ".1.3.6.1.4.1.45121.1800.4.4.1.1", ISnmpConstant.INTEGER));
    initProperty(utsPerfStaPMEnable, new SnmpMibBeanProperty(utsPerfStaPMEnable, ".1.3.6.1.4.1.45121.1800.4.4.1.2", ISnmpConstant.INTEGER));
  }

  public Integer getUtsPerfStaClearAll() {
    return (Integer) getProperty(utsPerfStaClearAll).getValue();
  }

  public void setUtsPerfStaClearAll(Integer aUtsPerfStaClearAll) {
    getProperty(utsPerfStaClearAll).setValue(aUtsPerfStaClearAll);
  }

  public Integer getUtsPerfStaPMEnable() {
    return (Integer)getProperty(utsPerfStaPMEnable).getValue();
  }

  public void setUtsPerfStaPMEnable(Integer aUtsPerfStaPMEnable)
  {
    getProperty(utsPerfStaPMEnable).setValue(aUtsPerfStaPMEnable);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsPerfStaClearAll));
    prepareRead(super.getProperty(utsPerfStaPMEnable));

    return load();
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsPerfStaClearAll));
    prepareSave(getProperty(utsPerfStaPMEnable));

    return save();
  }
}

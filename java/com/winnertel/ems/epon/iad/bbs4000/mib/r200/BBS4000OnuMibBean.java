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
 * The Dot3Onu2CtcTable class.
 * Created by QuickDVM
 */
public class BBS4000OnuMibBean extends SnmpMibBean {
  public static final String utsDot3Onu2CtcModuleId = "utsDot3Onu2CtcModuleId";
  public static final String utsDot3Onu2CtcDeviceId = "utsDot3Onu2CtcDeviceId";
  public static final String utsDot3Onu2CtcPortId = "utsDot3Onu2CtcPortId";
  public static final String utsDot3Onu2CtcLogicalPortId = "utsDot3Onu2CtcLogicalPortId";
  public static final String utsDot3Onu2DbaQueueSetNum = "utsDot3Onu2DbaQueueSetNum";

  public BBS4000OnuMibBean(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2DbaQueueSetNum, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueSetNum, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.5", ISnmpConstant.INTEGER));
  }


  public Integer getUtsDot3Onu2CtcModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3Onu2CtcModuleId(Integer aUtsDot3Onu2CtcModuleId) {
    setIndex(0, aUtsDot3Onu2CtcModuleId);
  }


  public Integer getUtsDot3Onu2CtcDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3Onu2CtcDeviceId(Integer aUtsDot3Onu2CtcDeviceId) {
    setIndex(1, aUtsDot3Onu2CtcDeviceId);
  }


  public Integer getUtsDot3Onu2CtcPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3Onu2CtcPortId(Integer aUtsDot3Onu2CtcPortId) {
    setIndex(2, aUtsDot3Onu2CtcPortId);
  }


  public Integer getUtsDot3Onu2CtcLogicalPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3Onu2CtcLogicalPortId(Integer aUtsDot3Onu2CtcLogicalPortId) {
    setIndex(3, aUtsDot3Onu2CtcLogicalPortId);
  }

  public Integer getUtsDot3Onu2DbaQueueSetNum() {
    return (Integer) getProperty(utsDot3Onu2DbaQueueSetNum).getValue();
  }

  public void setUtsDot3Onu2DbaQueueSetNum(Integer aUtsDot3Onu2DbaQueueSetNum) {
    getProperty(utsDot3Onu2DbaQueueSetNum).setValue(aUtsDot3Onu2DbaQueueSetNum);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3Onu2DbaQueueSetNum));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3Onu2DbaQueueSetNum));

    setRowsPerFetch(50);
    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
    });
  }
}

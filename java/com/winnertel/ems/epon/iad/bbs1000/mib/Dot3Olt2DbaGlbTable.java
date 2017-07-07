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
 * The Dot3Olt2DbaGlbTable class.
 * Created by QuickDVM
 */
public class Dot3Olt2DbaGlbTable extends SnmpMibBean {
  public static final String utsDot3OltModuleId = "utsDot3OltModuleId";
  public static final String utsDot3OltDeviceId = "utsDot3OltDeviceId";
  public static final String utsDot3OltDbaMode = "utsDot3OltDbaMode";
  public static final String utsDot3OltDbaAlgorithm = "utsDot3OltDbaAlgorithm";

  public Dot3Olt2DbaGlbTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(utsDot3OltModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.4.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDeviceId, new SnmpMibBeanProperty(utsDot3OltDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.4.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDbaMode, new SnmpMibBeanProperty(utsDot3OltDbaMode, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.4.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDbaAlgorithm, new SnmpMibBeanProperty(utsDot3OltDbaAlgorithm, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.4.1.4", ISnmpConstant.INTEGER));

  }


  public Integer getUtsDot3OltModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OltModuleId(Integer aUtsDot3OltModuleId) {
    setIndex(0, aUtsDot3OltModuleId);
  }


  public Integer getUtsDot3OltDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OltDeviceId(Integer aUtsDot3OltDeviceId) {
    setIndex(1, aUtsDot3OltDeviceId);
  }


  public Integer getUtsDot3OltDbaMode() {
    return (Integer) getProperty(utsDot3OltDbaMode).getValue();
  }

  public void setUtsDot3OltDbaMode(Integer aUtsDot3OltDbaMode) {
    getProperty(utsDot3OltDbaMode).setValue(aUtsDot3OltDbaMode);
  }

  public Integer getUtsDot3OltDbaAlgorithm() {
    return (Integer) getProperty(utsDot3OltDbaAlgorithm).getValue();
  }

  public void setUtsDot3OltDbaAlgorithm(Integer aUtsDot3OltDbaAlgorithm) {
    getProperty(utsDot3OltDbaAlgorithm).setValue(aUtsDot3OltDbaAlgorithm);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltDbaMode));
    prepareRead(super.getProperty(utsDot3OltDbaAlgorithm));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltDbaMode));
    prepareRead(super.getProperty(utsDot3OltDbaAlgorithm));

    return loadAll(new int[]{1
                             , 1
    });
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OltDbaMode));
    prepareSave(getProperty(utsDot3OltDbaAlgorithm));

    return save();
  }


}

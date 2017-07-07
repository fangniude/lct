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
 * The Dot3Onu2CtcValidOnuMacTable class.
 * Created by QuickDVM
 */
public class Dot3Onu2CtcValidOnuMacTable extends SnmpMibBean {
  public static final String utsDot3OnuValidOnuMacModuleId = "utsDot3OnuValidOnuMacModuleId";
  public static final String utsDot3OnuValidOnuMacDeviceId = "utsDot3OnuValidOnuMacDeviceId";
  public static final String utsDot3OnuValidOnuMacPortId = "utsDot3OnuValidOnuMacPortId";
  public static final String utsDot3OnuValidOnuMacAppLPortId = "utsDot3OnuValidOnuMacAppLPortId";
  public static final String utsDot3ValidOnuMacAddr = "utsDot3ValidOnuMacAddr";
  public static final String utsDot3OnuDescription = "utsDot3OnuDescription";


  public Dot3Onu2CtcValidOnuMacTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuValidOnuMacModuleId, new SnmpMibBeanProperty(utsDot3OnuValidOnuMacModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuValidOnuMacDeviceId, new SnmpMibBeanProperty(utsDot3OnuValidOnuMacDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuValidOnuMacPortId, new SnmpMibBeanProperty(utsDot3OnuValidOnuMacPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuValidOnuMacAppLPortId, new SnmpMibBeanProperty(utsDot3OnuValidOnuMacAppLPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3ValidOnuMacAddr, new SnmpMibBeanProperty(utsDot3ValidOnuMacAddr, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.5", ISnmpConstant.MAC_ADDRESS));
    initProperty(utsDot3OnuDescription, new SnmpMibBeanProperty(utsDot3OnuDescription, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.10", ISnmpConstant.STRING));
  }


  public Integer getUtsDot3OnuValidOnuMacModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuValidOnuMacModuleId(Integer aUtsDot3OnuValidOnuMacModuleId) {
    setIndex(0, aUtsDot3OnuValidOnuMacModuleId);
  }


  public Integer getUtsDot3OnuValidOnuMacDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuValidOnuMacDeviceId(Integer aUtsDot3OnuValidOnuMacDeviceId) {
    setIndex(1, aUtsDot3OnuValidOnuMacDeviceId);
  }


  public Integer getUtsDot3OnuValidOnuMacPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OnuValidOnuMacPortId(Integer aUtsDot3OnuValidOnuMacPortId) {
    setIndex(2, aUtsDot3OnuValidOnuMacPortId);
  }


  public Integer getUtsDot3OnuValidOnuMacAppLPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3OnuValidOnuMacAppLPortId(Integer aUtsDot3OnuValidOnuMacAppLPortId) {
    setIndex(3, aUtsDot3OnuValidOnuMacAppLPortId);
  }


  public byte[] getUtsDot3ValidOnuMacAddr() {
    return (byte[]) getProperty(utsDot3ValidOnuMacAddr).getValue();
  }

  public void setUtsDot3ValidOnuMacAddr(byte[] aUtsDot3ValidOnuMacAddr) {
    getProperty(utsDot3ValidOnuMacAddr).setValue(aUtsDot3ValidOnuMacAddr);
  }
  
  public String getUtsDot3OnuDescription() {
      return (String) getProperty(utsDot3OnuDescription).getValue();
  }

  public void setUtsDot3OnuDescription(String aUtsDot3OnuDescription) {
      getProperty(utsDot3OnuDescription).setValue(aUtsDot3OnuDescription);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3ValidOnuMacAddr));
    prepareRead(getProperty(utsDot3OnuDescription));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3ValidOnuMacAddr));
    prepareRead(getProperty(utsDot3OnuDescription));

    return loadAll(new int[]{1
                             , 1
                             , 1
                             , 1
    });
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3ValidOnuMacAddr));
    prepareSave(getProperty(utsDot3OnuDescription));

    return save();
  }


  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }
}

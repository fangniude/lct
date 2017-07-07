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
 * The OltGlbMulticastGroupTable class.
 * Created by QuickDVM
 */
public class OltGlbMulticastGroupTable extends SnmpMibBean {
  public static final String utsOltGlbMulticastGroupMVlan = "utsOltGlbMulticastGroupMVlan";
  public static final String utsOltGlbMulticastGroupIpAddrStart = "utsOltGlbMulticastGroupIpAddrStart";
  public static final String utsOltGlbMulticastGroupIpAddrEnd = "utsOltGlbMulticastGroupIpAddrEnd";


  public OltGlbMulticastGroupTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsOltGlbMulticastGroupMVlan, new SnmpMibBeanProperty(utsOltGlbMulticastGroupMVlan, ".1.3.6.1.4.1.41355.1800.2.4.3.1.5.1.1", ISnmpConstant.INTEGER));
    initProperty(utsOltGlbMulticastGroupIpAddrStart, new SnmpMibBeanProperty(utsOltGlbMulticastGroupIpAddrStart, ".1.3.6.1.4.1.41355.1800.2.4.3.1.5.1.2", ISnmpConstant.IP_ADDRESS));
    initProperty(utsOltGlbMulticastGroupIpAddrEnd, new SnmpMibBeanProperty(utsOltGlbMulticastGroupIpAddrEnd, ".1.3.6.1.4.1.41355.1800.2.4.3.1.5.1.3", ISnmpConstant.IP_ADDRESS));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.4.3.1.5.1.4", ISnmpConstant.INTEGER));
  }


  public Integer getUtsOltGlbMulticastGroupMVlan() {
    return (Integer) getIndex(0);
  }

  public void setUtsOltGlbMulticastGroupMVlan(Integer aUtsOltGlbMulticastGroupMVlan) {
    setIndex(0, aUtsOltGlbMulticastGroupMVlan);
  }


  public String getUtsOltGlbMulticastGroupIpAddrStart() {
    return (String) getProperty(utsOltGlbMulticastGroupIpAddrStart).getValue();
  }

  public void setUtsOltGlbMulticastGroupIpAddrStart(String aUtsOltGlbMulticastGroupIpAddrStart) {
    getProperty(utsOltGlbMulticastGroupIpAddrStart).setValue(aUtsOltGlbMulticastGroupIpAddrStart);
  }

  public String getUtsOltGlbMulticastGroupIpAddrEnd() {
    return (String) getProperty(utsOltGlbMulticastGroupIpAddrEnd).getValue();
  }

  public void setUtsOltGlbMulticastGroupIpAddrEnd(String aUtsOltGlbMulticastGroupIpAddrEnd) {
    getProperty(utsOltGlbMulticastGroupIpAddrEnd).setValue(aUtsOltGlbMulticastGroupIpAddrEnd);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsOltGlbMulticastGroupIpAddrStart));
    prepareRead(super.getProperty(utsOltGlbMulticastGroupIpAddrEnd));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsOltGlbMulticastGroupIpAddrStart));
    prepareRead(super.getProperty(utsOltGlbMulticastGroupIpAddrEnd));

    return loadAll(new int[]{1
    });
  }

  public boolean add() throws MibBeanException {
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(utsOltGlbMulticastGroupIpAddrStart));
    prepareSave(getProperty(utsOltGlbMulticastGroupIpAddrEnd));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

}

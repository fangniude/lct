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
 * The OltPullDownMcTable class.
 * Created by QuickDVM
 */
public class OltPullDownMcTable extends SnmpMibBean {
  public static final String utsOltPullDownMcGroupIpAddr = "utsOltPullDownMcGroupIpAddr";
  public static final String utsOltPullDownMcGroupMVlan = "utsOltPullDownMcGroupMVlan";


  public OltPullDownMcTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsOltPullDownMcGroupIpAddr, new SnmpMibBeanProperty(utsOltPullDownMcGroupIpAddr, ".1.3.6.1.4.1.45121.1800.2.4.3.1.4.1.1", ISnmpConstant.IP_ADDRESS));
    initProperty(utsOltPullDownMcGroupMVlan, new SnmpMibBeanProperty(utsOltPullDownMcGroupMVlan, ".1.3.6.1.4.1.45121.1800.2.4.3.1.4.1.2", ISnmpConstant.INTEGER));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.4.3.1.4.1.3", ISnmpConstant.INTEGER));

  }


  public String getUtsOltPullDownMcGroupIpAddr() {
    return (String) getIndex(0);
  }

  public void setUtsOltPullDownMcGroupIpAddr(String aUtsOltPullDownMcGroupIpAddr) {
    setIndex(0, aUtsOltPullDownMcGroupIpAddr);
  }


  public Integer getUtsOltPullDownMcGroupMVlan() {
    return (Integer) getProperty(utsOltPullDownMcGroupMVlan).getValue();
  }

  public void setUtsOltPullDownMcGroupMVlan(Integer aUtsOltPullDownMcGroupMVlan) {
    getProperty(utsOltPullDownMcGroupMVlan).setValue(aUtsOltPullDownMcGroupMVlan);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsOltPullDownMcGroupMVlan));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsOltPullDownMcGroupMVlan));


    return loadAll(new int[]{4
    });
  }

  public boolean add() throws MibBeanException {
    super.setRowStatus(new Integer(4));

    prepareSave(getProperty(utsOltPullDownMcGroupMVlan));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }


  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

}

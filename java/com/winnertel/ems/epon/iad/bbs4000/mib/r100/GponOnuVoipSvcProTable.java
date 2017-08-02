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

import java.util.Vector;

/**
 * The GponOnuVoipSvcProTable class.
 * Created by QuickDVM
 */
public class GponOnuVoipSvcProTable extends SnmpMibBean {
  public static final String onuVoipSvcProfileIndex = "onuVoipSvcProfileIndex";
  public static final String onuVoipSvcProfileName = "onuVoipSvcProfileName";
  public static final String onuVoIPVirtualPortNo = "onuVoIPVirtualPortNo";
  public static final String onuVoIPConfigMethod = "onuVoIPConfigMethod";
  public static final String onuVoIPConfigServerAddress = "onuVoIPConfigServerAddress";
  public static final String onuVoIPConfigScriptLocation = "onuVoIPConfigScriptLocation";

  public GponOnuVoipSvcProTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(onuVoipSvcProfileIndex, new SnmpMibBeanProperty(
        onuVoipSvcProfileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.20.1.1",
        ISnmpConstant.GAUGE));
    initProperty(onuVoipSvcProfileName, new SnmpMibBeanProperty(
        onuVoipSvcProfileName, ".1.3.6.1.4.1.45121.1.3.10.5.2.20.1.2",
        ISnmpConstant.STRING));
    initProperty(onuVoIPVirtualPortNo, new SnmpMibBeanProperty(
        onuVoIPVirtualPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.20.1.3",
        ISnmpConstant.INTEGER));
    initProperty(onuVoIPConfigMethod, new SnmpMibBeanProperty(
        onuVoIPConfigMethod, ".1.3.6.1.4.1.45121.1.3.10.5.2.20.1.4",
        ISnmpConstant.INTEGER));
    initProperty(onuVoIPConfigServerAddress, new SnmpMibBeanProperty(
        onuVoIPConfigServerAddress, ".1.3.6.1.4.1.45121.1.3.10.5.2.20.1.5",
        ISnmpConstant.IP_ADDRESS));
    initProperty(onuVoIPConfigScriptLocation, new SnmpMibBeanProperty(
        onuVoIPConfigScriptLocation, ".1.3.6.1.4.1.45121.1.3.10.5.2.20.1.6",
        ISnmpConstant.STRING));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.20.1.7", ISnmpConstant.INTEGER));

  }

  public Long getOnuVoipSvcProfileIndex() {
    return (Long) getIndex(0);
  }

  public void setOnuVoipSvcProfileIndex(Long aOnuVoipSvcProfileIndex) {
    setIndex(0, aOnuVoipSvcProfileIndex);
  }

  public String getOnuVoipSvcProfileName() {
    return (String) getProperty(onuVoipSvcProfileName).getValue();
  }

  public void setOnuVoipSvcProfileName(String aOnuVoipSvcProfileName) {
    getProperty(onuVoipSvcProfileName).setValue(aOnuVoipSvcProfileName);
  }

  public Integer getOnuVoIPVirtualPortNo() {
    return (Integer) getProperty(onuVoIPVirtualPortNo).getValue();
  }

  public void setOnuVoIPVirtualPortNo(Integer aOnuVoIPVirtualPortNo) {
    getProperty(onuVoIPVirtualPortNo).setValue(aOnuVoIPVirtualPortNo);
  }

  public Integer getOnuVoIPConfigMethod() {
    return (Integer) getProperty(onuVoIPConfigMethod).getValue();
  }

  public void setOnuVoIPConfigMethod(Integer aOnuVoIPConfigMethod) {
    getProperty(onuVoIPConfigMethod).setValue(aOnuVoIPConfigMethod);
  }

  public String getOnuVoIPConfigServerAddress() {
    return (String) getProperty(onuVoIPConfigServerAddress).getValue();
  }

  public void setOnuVoIPConfigServerAddress(String aOnuVoIPConfigServerAddress) {
    getProperty(onuVoIPConfigServerAddress).setValue(
        aOnuVoIPConfigServerAddress);
  }

  public String getOnuVoIPConfigScriptLocation() {
    return (String) getProperty(onuVoIPConfigScriptLocation).getValue();
  }

  public void setOnuVoIPConfigScriptLocation(String aOnuVoIPConfigScriptLocation) {
    getProperty(onuVoIPConfigScriptLocation).setValue(
        aOnuVoIPConfigScriptLocation);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(onuVoipSvcProfileName));
    prepareRead(super.getProperty(onuVoIPVirtualPortNo));
    prepareRead(super.getProperty(onuVoIPConfigMethod));
    prepareRead(super.getProperty(onuVoIPConfigServerAddress));
    prepareRead(super.getProperty(onuVoIPConfigScriptLocation));

    return load();
  }

  public Vector retrieveAll(){
    prepareRead(super.getProperty(onuVoipSvcProfileName));
    prepareRead(super.getProperty(onuVoIPVirtualPortNo));
    prepareRead(super.getProperty(onuVoIPConfigMethod));
    prepareRead(super.getProperty(onuVoIPConfigServerAddress));
    prepareRead(super.getProperty(onuVoIPConfigScriptLocation));
    return loadAll(new int[]{2});
  }
  
  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(onuVoipSvcProfileName));
    prepareSave(getProperty(onuVoIPVirtualPortNo));
    prepareSave(getProperty(onuVoIPConfigMethod));
    prepareSave(getProperty(onuVoIPConfigServerAddress));
    prepareSave(getProperty(onuVoIPConfigScriptLocation));

    return save();
  }
  
  public boolean add() throws MibBeanException{
    prepareSave(getProperty(onuVoipSvcProfileName));
    prepareSave(getProperty(onuVoIPVirtualPortNo));
    prepareSave(getProperty(onuVoIPConfigMethod));
    prepareSave(getProperty(onuVoIPConfigServerAddress));
    prepareSave(getProperty(onuVoIPConfigScriptLocation));
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }
  
  public boolean delete() throws MibBeanException
  {
      super.setRowStatus(new Integer(6));
      prepareSave(getProperty(ROW_STATUS));
      return save();
  }
  
  public String toString(){
      return getOnuVoipSvcProfileName();
  }

}

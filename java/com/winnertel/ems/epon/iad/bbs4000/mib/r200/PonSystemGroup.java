package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The SystemInfoMbean class.
 * Created by QuickDVM
 */
public class PonSystemGroup extends SnmpMibBean {
//  public static final String utsPonSysVlanIdBase = "utsPonSysVlanIdBase";
  public static final String utsPonSysLocalAuthentication = "utsPonSysLocalAuthentication";
  public static final String utsPonSysLogicalPortStrictBinging = "utsPonSysLogicalPortStrictBinging";
  public static final String utsPonSysSlaSynchronization = "utsPonSysSlaSynchronization";
  public static final String utsPonSysOltMACAgingTime = "utsPonSysOltMACAgingTime";
  public static final String utsPonSysOnuAuthTimeOut = "utsPonSysOnuAuthTimeOut";
//  public static final String utsPonSysOlpMode = "utsPonSysOlpMode";
  public static final String utsPonSysDot1adTPID = "utsPonSysDot1adTPID";

  public PonSystemGroup(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
//    initProperty(utsPonSysVlanIdBase, new SnmpMibBeanProperty(utsPonSysVlanIdBase, ".1.3.6.1.4.1.45121.1800.2.1.1.2.1", ISnmpConstant.INTEGER));
    initProperty(utsPonSysLocalAuthentication, new SnmpMibBeanProperty(utsPonSysLocalAuthentication, ".1.3.6.1.4.1.45121.1800.2.1.1.2.2", ISnmpConstant.INTEGER));
    initProperty(utsPonSysLogicalPortStrictBinging, new SnmpMibBeanProperty(utsPonSysLogicalPortStrictBinging, ".1.3.6.1.4.1.45121.1800.2.1.1.2.3", ISnmpConstant.INTEGER));
    initProperty(utsPonSysSlaSynchronization, new SnmpMibBeanProperty(utsPonSysSlaSynchronization, ".1.3.6.1.4.1.45121.1800.2.1.1.2.4", ISnmpConstant.INTEGER));
    initProperty(utsPonSysOltMACAgingTime, new SnmpMibBeanProperty(utsPonSysOltMACAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.2.5", ISnmpConstant.INTEGER));
    initProperty(utsPonSysOnuAuthTimeOut, new SnmpMibBeanProperty(utsPonSysOnuAuthTimeOut, ".1.3.6.1.4.1.45121.1800.2.1.1.2.6", ISnmpConstant.INTEGER));
//    initProperty(utsPonSysOlpMode, new SnmpMibBeanProperty(utsPonSysOlpMode, ".1.3.6.1.4.1.45121.1800.2.1.1.2.7", ISnmpConstant.INTEGER));
    initProperty(utsPonSysDot1adTPID, new SnmpMibBeanProperty(utsPonSysDot1adTPID, ".1.3.6.1.4.1.45121.1800.2.1.1.2.8", ISnmpConstant.INTEGER));
  }


//  public Integer getUtsPonSysVlanIdBase() {
//    return (Integer) getProperty(utsPonSysVlanIdBase).getValue();
//  }
//
//  public void setUtsPonSysVlanIdBase(Integer aUtsPonSysVlanIdBase) {
//    getProperty(utsPonSysVlanIdBase).setValue(aUtsPonSysVlanIdBase);
//  }

  public Integer getUtsPonSysLocalAuthentication() {
    return (Integer) getProperty(utsPonSysLocalAuthentication).getValue();
  }

  public void setUtsPonSysLocalAuthentication(Integer aUtsPonSysLocalAuthentication) {
    getProperty(utsPonSysLocalAuthentication).setValue(aUtsPonSysLocalAuthentication);
  }

  public Integer getUtsPonSysLogicalPortStrictBinging() {
    return (Integer) getProperty(utsPonSysLogicalPortStrictBinging).getValue();
  }

  public void setUtsPonSysLogicalPortStrictBinging(Integer aUtsPonSysLogicalPortStrictBinging) {
    getProperty(utsPonSysLogicalPortStrictBinging).setValue(aUtsPonSysLogicalPortStrictBinging);
  }

  public Integer getUtsPonSysSlaSynchronization() {
    return (Integer) getProperty(utsPonSysSlaSynchronization).getValue();
  }

  public void setUtsPonSysSlaSynchronization(Integer aUtsPonSysSlaSynchronization) {
    getProperty(utsPonSysSlaSynchronization).setValue(aUtsPonSysSlaSynchronization);
  }

  public Integer getUtsPonSysOltMACAgingTime() {
    return (Integer) getProperty(utsPonSysOltMACAgingTime).getValue();
  }

  public void setUtsPonSysOltMACAgingTime(Integer aUtsPonSysOltMACAgingTime) {
    getProperty(utsPonSysOltMACAgingTime).setValue(aUtsPonSysOltMACAgingTime);
  }

  public Integer getUtsPonSysOnuAuthTimeOut() {
    return (Integer) getProperty(utsPonSysOnuAuthTimeOut).getValue();
  }

  public void setUtsPonSysOnuAuthTimeOut(Integer aUtsPonSysOnuAuthTimeOut) {
    getProperty(utsPonSysOnuAuthTimeOut).setValue(aUtsPonSysOnuAuthTimeOut);
  }

//  public Integer getUtsPonSysOlpMode() {
//    return (Integer) getProperty(utsPonSysOlpMode).getValue();
//  }
//
//  public void setUtsPonSysOlpMode(Integer aUtsPonSysOlpMode) {
//    getProperty(utsPonSysOlpMode).setValue(aUtsPonSysOlpMode);
//  }

  public Integer getUtsPonSysDot1adTPID() {
    return (Integer) getProperty(utsPonSysDot1adTPID).getValue();
  }

  public void setUtsPonSysDot1adTPID(Integer aUtsPonSysDot1adTPID) {
    getProperty(utsPonSysDot1adTPID).setValue(aUtsPonSysDot1adTPID);
  }

  public boolean retrieve() throws MibBeanException {
//    prepareRead(super.getProperty(utsPonSysVlanIdBase));
    prepareRead(super.getProperty(utsPonSysLocalAuthentication));
    prepareRead(super.getProperty(utsPonSysLogicalPortStrictBinging));
    prepareRead(super.getProperty(utsPonSysSlaSynchronization));
    prepareRead(super.getProperty(utsPonSysOltMACAgingTime));
    prepareRead(super.getProperty(utsPonSysOnuAuthTimeOut));
//    prepareRead(super.getProperty(utsPonSysOlpMode));
    prepareRead(super.getProperty(utsPonSysDot1adTPID));

    return load();
  }


  public boolean modify() throws MibBeanException {
//    prepareSave(super.getProperty(utsPonSysVlanIdBase));
    prepareSave(super.getProperty(utsPonSysLocalAuthentication));
    prepareSave(super.getProperty(utsPonSysLogicalPortStrictBinging));
    prepareSave(super.getProperty(utsPonSysSlaSynchronization));
    prepareSave(super.getProperty(utsPonSysOltMACAgingTime));
    prepareSave(super.getProperty(utsPonSysOnuAuthTimeOut));
//    prepareSave(super.getProperty(utsPonSysOlpMode));
    prepareSave(super.getProperty(utsPonSysDot1adTPID));

    return save();
  }
}

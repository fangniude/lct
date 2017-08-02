package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PonVlanTranslationTable extends SnmpMibBean {
  public static final String utsPonVlanTranslationModuleID = "utsPonVlanTranslationModuleID";
  public static final String utsPonVlanTranslationDeviceID = "utsPonVlanTranslationDeviceID";
  public static final String utsPonVlanTranslationPortID = "utsPonVlanTranslationPortID";
  public static final String utsPonVlanTranslationLogicPortID = "utsPonVlanTranslationLogicPortID";
  public static final String utsPonVlanTranslationOldVID = "utsPonVlanTranslationOldVID";
  public static final String utsPonVlanTranslationNewVID = "utsPonVlanTranslationNewVID";
  public static final String utsPonVlanTranslationNewCos = "utsPonVlanTranslationNewCos";
  
  public PonVlanTranslationTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsPonVlanTranslationModuleID, new SnmpMibBeanProperty(utsPonVlanTranslationModuleID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.1", ISnmpConstant.INTEGER));
    initProperty(utsPonVlanTranslationDeviceID, new SnmpMibBeanProperty(utsPonVlanTranslationDeviceID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.2", ISnmpConstant.INTEGER));
    initProperty(utsPonVlanTranslationPortID, new SnmpMibBeanProperty(utsPonVlanTranslationPortID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.3", ISnmpConstant.INTEGER));
    initProperty(utsPonVlanTranslationLogicPortID, new SnmpMibBeanProperty(utsPonVlanTranslationLogicPortID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.4", ISnmpConstant.INTEGER));
    initProperty(utsPonVlanTranslationOldVID, new SnmpMibBeanProperty(utsPonVlanTranslationOldVID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.5", ISnmpConstant.INTEGER));
    initProperty(utsPonVlanTranslationNewVID, new SnmpMibBeanProperty(utsPonVlanTranslationNewVID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.6", ISnmpConstant.INTEGER));
    initProperty(utsPonVlanTranslationNewCos, new SnmpMibBeanProperty(utsPonVlanTranslationNewCos, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.7", ISnmpConstant.INTEGER));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.8", ISnmpConstant.INTEGER));
  }

  public Integer getUtsPonVlanTranslationModuleID() {
    return (Integer) getIndex(0);
  }

  public void setUtsPonVlanTranslationModuleID(Integer autsPonVlanTranslationModuleID) {
    setIndex(0, autsPonVlanTranslationModuleID);
  }


  public Integer getUtsPonVlanTranslationDeviceID() {
    return (Integer) getIndex(1);
  }

  public void setUtsPonVlanTranslationDeviceID(Integer autsPonVlanTranslationDeviceID) {
    setIndex(1, autsPonVlanTranslationDeviceID);
  }


  public Integer getUtsPonVlanTranslationPortID() {
    return (Integer) getIndex(2);
  }

  public void setUtsPonVlanTranslationPortID(Integer autsPonVlanTranslationPortID) {
    setIndex(2, autsPonVlanTranslationPortID);
  }


  public Integer getUtsPonVlanTranslationLogicPortID() {
    return (Integer)getIndex(3);
  }

  public void setUtsPonVlanTranslationLogicPortID(Integer autsPonVlanTranslationLogicPortID) {
    setIndex(3, autsPonVlanTranslationLogicPortID);
  }

  public Integer getUtsPonVlanTranslationOldVID() {
    return (Integer)getIndex(4);
  }

  public void setUtsPonVlanTranslationOldVID(Integer autsPonVlanTranslationOldVID) {
    setIndex(4, autsPonVlanTranslationOldVID);
  }

  public Integer getUtsPonVlanTranslationNewVID() {
    return (Integer)getProperty(utsPonVlanTranslationNewVID).getValue();
  }

  public void setUtsPonVlanTranslationNewVID(Integer aUtsPonVlanTranslationNewVID) {
    getProperty(utsPonVlanTranslationNewVID).setValue(aUtsPonVlanTranslationNewVID);
  }

  public Integer getUtsPonVlanTranslationNewCos() {
    return (Integer)getProperty(utsPonVlanTranslationNewCos).getValue();
  }

  public void setUtsPonVlanTranslationNewCos(Integer aUtsPonVlanTranslationNewCos) {
    getProperty(utsPonVlanTranslationNewCos).setValue(aUtsPonVlanTranslationNewCos);
  }
  
  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsPonVlanTranslationNewVID));
    prepareRead(super.getProperty(utsPonVlanTranslationNewCos));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsPonVlanTranslationNewVID));
    prepareRead(super.getProperty(utsPonVlanTranslationNewCos));

    return loadAll(new int[]{1, 1, 1, 1, 1});
  }

  public boolean add() throws MibBeanException {
    prepareSave(getProperty(utsPonVlanTranslationNewVID));
    prepareSave(getProperty(utsPonVlanTranslationNewCos));

    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(ROW_STATUS));

    return save();
  }

  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));

    return save();
  }
}

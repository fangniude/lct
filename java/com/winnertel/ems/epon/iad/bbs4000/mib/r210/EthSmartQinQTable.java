package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EthSmartQinQTable extends SnmpMibBean {
  public static final String utsEthSmartQinQModuleID = "utsEthSmartQinQModuleID";
  public static final String utsEthSmartQinQPortID = "utsEthSmartQinQPortID";
  public static final String utsEthSmartQinQFrameType = "utsEthSmartQinQFrameType";
  public static final String utsEthSmartQinQEtherType = "utsEthSmartQinQEtherType";
  public static final String utsEthSmartQinQOutterVLANID = "utsEthSmartQinQOutterVLANID";

  public EthSmartQinQTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsEthSmartQinQModuleID, new SnmpMibBeanProperty(utsEthSmartQinQModuleID, ".1.3.6.1.4.1.45121.1800.2.2.1.9.1.1", ISnmpConstant.INTEGER));
    initProperty(utsEthSmartQinQPortID, new SnmpMibBeanProperty(utsEthSmartQinQPortID, ".1.3.6.1.4.1.45121.1800.2.2.1.9.1.2", ISnmpConstant.INTEGER));
    initProperty(utsEthSmartQinQFrameType, new SnmpMibBeanProperty(utsEthSmartQinQFrameType, ".1.3.6.1.4.1.45121.1800.2.2.1.9.1.3", ISnmpConstant.INTEGER));
    initProperty(utsEthSmartQinQEtherType, new SnmpMibBeanProperty(utsEthSmartQinQEtherType, ".1.3.6.1.4.1.45121.1800.2.2.1.9.1.4", ISnmpConstant.INTEGER));
    initProperty(utsEthSmartQinQOutterVLANID, new SnmpMibBeanProperty(utsEthSmartQinQOutterVLANID, ".1.3.6.1.4.1.45121.1800.2.2.1.9.1.5", ISnmpConstant.INTEGER));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.2.1.9.1.6", ISnmpConstant.INTEGER));
  }

  public Integer getIfIndex() {
    return (Integer)getIndex(0);
  }

  public void setIfIndex(Integer aIfIndex) {
    setIndex(0, aIfIndex);
  }

  public Integer getUtsEthSmartQinQModuleID() {
    return (Integer) getIndex(1);
  }

  public void setUtsEthSmartQinQModuleID(Integer aUtsEthSmartQinQModuleID) {
    setIndex(1, aUtsEthSmartQinQModuleID);
  }


  public Integer getUtsEthSmartQinQPortID() {
    return (Integer) getIndex(2);
  }

  public void setUtsEthSmartQinQPortID(Integer aUtsEthSmartQinQPortID) {
    setIndex(2, aUtsEthSmartQinQPortID);
  }


  public Integer getUtsEthSmartQinQFrameType() {
    return (Integer) getIndex(3);
  }

  public void setUtsEthSmartQinQFrameType(Integer aUtsEthSmartQinQFrameType) {
    setIndex(3, aUtsEthSmartQinQFrameType);
  }


  public Integer getUtsEthSmartQinQEtherType() {
    return (Integer) getIndex(4);
  }

  public void setUtsEthSmartQinQEtherType(Integer aUtsEthSmartQinQEtherType) {
    setIndex(4, aUtsEthSmartQinQEtherType);
  }

  public Integer getUtsEthSmartQinQOutterVLANID() {
    return (Integer) getProperty(utsEthSmartQinQOutterVLANID).getValue();
  }

  public void setUtsEthSmartQinQOutterVLANID(Integer aUtsEthSmartQinQOutterVLANID) {
    getProperty(utsEthSmartQinQOutterVLANID).setValue(aUtsEthSmartQinQOutterVLANID);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsEthSmartQinQOutterVLANID));
    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsEthSmartQinQOutterVLANID));

    return loadAll(new int[]{1 , 1 , 1 , 1, 1});
  }

  public boolean add() throws MibBeanException {
    getProperty(utsEthSmartQinQModuleID).setValue(getIndex(1));
    getProperty(utsEthSmartQinQPortID).setValue(getIndex(2));
    getProperty(utsEthSmartQinQFrameType).setValue(getIndex(3));
    getProperty(utsEthSmartQinQEtherType).setValue(getIndex(4));

    prepareSave(getProperty(utsEthSmartQinQModuleID));
    prepareSave(getProperty(utsEthSmartQinQPortID));
    prepareSave(getProperty(utsEthSmartQinQFrameType));
    prepareSave(getProperty(utsEthSmartQinQEtherType));

    prepareSave(getProperty(utsEthSmartQinQOutterVLANID));

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

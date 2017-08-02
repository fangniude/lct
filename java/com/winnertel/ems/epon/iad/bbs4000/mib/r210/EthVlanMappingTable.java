package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EthVlanMappingTable extends SnmpMibBean {
  public static final String utsEthVlanMappingModuleID = "utsEthVlanMappingModuleID";
  public static final String utsEthVlanMappingPortID = "utsEthVlanMappingPortID";
  public static final String utsEthVlanMappingInnerVID = "utsEthVlanMappingInnerVID";
  public static final String utsEthVlanMappingOuterVID = "utsEthVlanMappingOuterVID";
  public static final String utsEthVlanMappingTagMode = "utsEthVlanMappingTagMode";

  public EthVlanMappingTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsEthVlanMappingModuleID, new SnmpMibBeanProperty(utsEthVlanMappingModuleID, ".1.3.6.1.4.1.45121.1800.2.2.1.11.1.1", ISnmpConstant.INTEGER));
    initProperty(utsEthVlanMappingPortID, new SnmpMibBeanProperty(utsEthVlanMappingPortID, ".1.3.6.1.4.1.45121.1800.2.2.1.11.1.2", ISnmpConstant.INTEGER));
    initProperty(utsEthVlanMappingInnerVID, new SnmpMibBeanProperty(utsEthVlanMappingInnerVID, ".1.3.6.1.4.1.45121.1800.2.2.1.11.1.3", ISnmpConstant.INTEGER));
    initProperty(utsEthVlanMappingOuterVID, new SnmpMibBeanProperty(utsEthVlanMappingOuterVID, ".1.3.6.1.4.1.45121.1800.2.2.1.11.1.4", ISnmpConstant.INTEGER));
    initProperty(utsEthVlanMappingTagMode, new SnmpMibBeanProperty(utsEthVlanMappingTagMode, ".1.3.6.1.4.1.45121.1800.2.2.1.11.1.5", ISnmpConstant.INTEGER));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.2.1.11.1.6", ISnmpConstant.INTEGER));
  }

  public String getUtsEthVlanMappingIfIndex() {
    return getIndex(0) + "/" + getIndex(1);
  }

  public void setUtsEthVlanMappingIfIndex(String aIfIndex) {
    //
  }

  public Integer getUtsEthVlanMappingModuleID() {
    return (Integer) getIndex(0);
  }

  public void setUtsEthVlanMappingModuleID(Integer aUtsEthVlanMappingModuleID) {
    setIndex(0, aUtsEthVlanMappingModuleID);
  }


  public Integer getUtsEthVlanMappingPortID() {
    return (Integer) getIndex(1);
  }

  public void setUtsEthVlanMappingPortID(Integer aUtsEthVlanMappingPortID) {
    setIndex(1, aUtsEthVlanMappingPortID);
  }


  public Integer getUtsEthVlanMappingInnerVID() {
    return (Integer) getIndex(2);
  }

  public void setUtsEthVlanMappingInnerVID(Integer aUtsEthVlanMappingInnerVID) {
    setIndex(2, aUtsEthVlanMappingInnerVID);
  }


  public Integer getUtsEthVlanMappingOuterVID() {
    return (Integer) getProperty(utsEthVlanMappingOuterVID).getValue();
  }

  public void setUtsEthVlanMappingOuterVID(Integer aUtsEthVlanMappingOuterVID) {
    getProperty(utsEthVlanMappingOuterVID).setValue(aUtsEthVlanMappingOuterVID);
  }


  public Integer getUtsEthVlanMappingTagMode() {
    return (Integer) getProperty(utsEthVlanMappingTagMode).getValue();
  }

  public void setUtsEthVlanMappingTagMode(Integer aUtsEthVlanMappingTagMode) {
    getProperty(utsEthVlanMappingTagMode).setValue(aUtsEthVlanMappingTagMode);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsEthVlanMappingOuterVID));
    prepareRead(super.getProperty(utsEthVlanMappingTagMode));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsEthVlanMappingOuterVID));
    prepareRead(super.getProperty(utsEthVlanMappingTagMode));

    return loadAll(new int[]{1, 1, 1 });
  }

  public boolean add() throws MibBeanException {
    prepareSave(getProperty(utsEthVlanMappingOuterVID));
    prepareSave(getProperty(utsEthVlanMappingTagMode));

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

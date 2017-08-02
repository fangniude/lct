package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EthVlanTransparentTable extends SnmpMibBean {
  public static final String utsEthVlanTransparentSwitch = "utsEthVlanTransparentSwitch";
  public static final String utsEthVlanTransparentOuterVID = "utsEthVlanTransparentOuterVID";
  public static final String utsEthVlanTransparentTagMode = "utsEthVlanTransparentTagMode";

  public EthVlanTransparentTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsEthVlanTransparentSwitch, new SnmpMibBeanProperty(utsEthVlanTransparentSwitch, ".1.3.6.1.4.1.45121.1800.2.2.1.12.1.3", ISnmpConstant.INTEGER));
    initProperty(utsEthVlanTransparentOuterVID, new SnmpMibBeanProperty(utsEthVlanTransparentOuterVID, ".1.3.6.1.4.1.45121.1800.2.2.1.12.1.4", ISnmpConstant.INTEGER));
    initProperty(utsEthVlanTransparentTagMode, new SnmpMibBeanProperty(utsEthVlanTransparentTagMode, ".1.3.6.1.4.1.45121.1800.2.2.1.12.1.5", ISnmpConstant.INTEGER));
  }

  public Integer getIfIndex() {
    return (Integer)getIndex(0);
  }

  public void setIfIndex(Integer aIfIndex) {
    setIndex(0, aIfIndex);
  }

  public Integer getUtsEthVlanTransparentOuterVID() {
    return (Integer) getProperty(utsEthVlanTransparentOuterVID).getValue();
  }

  public void setUtsEthVlanTransparentOuterVID(Integer autsEthVlanTransparentOuterVID) {
    getProperty(utsEthVlanTransparentOuterVID).setValue(autsEthVlanTransparentOuterVID);
  }

  public Integer getUtsEthVlanTransparentSwitch() {
    return (Integer)getProperty(utsEthVlanTransparentSwitch).getValue();
  }

  public void setUtsEthVlanTransparentSwitch(Integer autsEthVlanTransparentSwitch) {
    getProperty(utsEthVlanTransparentSwitch).setValue(autsEthVlanTransparentSwitch);
  }

  public Integer getUtsEthVlanTransparentTagMode() {
    return (Integer) getProperty(utsEthVlanTransparentTagMode).getValue();
  }

  public void setUtsEthVlanTransparentTagMode(Integer aUtsEthVlanTransparentTagMode) {
    getProperty(utsEthVlanTransparentTagMode).setValue(aUtsEthVlanTransparentTagMode);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsEthVlanTransparentSwitch));
    prepareRead(super.getProperty(utsEthVlanTransparentOuterVID));
    prepareRead(super.getProperty(utsEthVlanTransparentTagMode));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsEthVlanTransparentSwitch));
    prepareRead(super.getProperty(utsEthVlanTransparentOuterVID));
    prepareRead(super.getProperty(utsEthVlanTransparentTagMode));

    return loadAll(new int[]{1});
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsEthVlanTransparentSwitch));
    prepareSave(getProperty(utsEthVlanTransparentOuterVID));
    prepareSave(getProperty(utsEthVlanTransparentTagMode));

    return save();
  }
}

package com.winnertel.ems.epon.iad.inventory.mib;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

import java.util.Vector;

public class OnuCtcBean extends SnmpMibBean {
  public static final String utsDot3Onu2CtcModuleId = "utsDot3Onu2CtcModuleId";
  public static final String utsDot3Onu2CtcDeviceId = "utsDot3Onu2CtcDeviceId";
  public static final String utsDot3Onu2CtcPortId = "utsDot3Onu2CtcPortId";
  public static final String utsDot3Onu2CtcLogicalPortId = "utsDot3Onu2CtcLogicalPortId";
  public static final String utsDot3Onu2CtcLlid = "utsDot3Onu2CtcLlid";
  public static final String utsDot3Onu2CtcOui = "utsDot3Onu2CtcOui";
  public static final String utsDot3Onu2CtcOamExtVersion = "utsDot3Onu2CtcOamExtVersion";
  public static final String utsDot3Onu2CtcSerialNumber = "utsDot3Onu2CtcSerialNumber";
  public static final String utsDot3Onu2CtcFwVer = "utsDot3Onu2CtcFwVer";
  public static final String utsDot3Onu2CtcRegisterStatus = "utsDot3Onu2CtcRegisterStatus";
  public static final String utsDot3Onu2CtcSwitchAdminStatus = "utsDot3Onu2CtcSwitchAdminStatus";
  public OnuCtcBean(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcLlid, new SnmpMibBeanProperty(utsDot3Onu2CtcLlid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcOui, new SnmpMibBeanProperty(utsDot3Onu2CtcOui, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.6", ISnmpConstant.STRING));
    initProperty(utsDot3Onu2CtcOamExtVersion, new SnmpMibBeanProperty(utsDot3Onu2CtcOamExtVersion, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcSerialNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcSerialNumber, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.8", ISnmpConstant.OCTETS));
    initProperty(utsDot3Onu2CtcFwVer, new SnmpMibBeanProperty(utsDot3Onu2CtcFwVer, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.9", ISnmpConstant.STRING));
    initProperty(utsDot3Onu2CtcRegisterStatus, new SnmpMibBeanProperty(utsDot3Onu2CtcRegisterStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.33", ISnmpConstant.INTEGER));
    initProperty(utsDot3Onu2CtcSwitchAdminStatus, new SnmpMibBeanProperty(utsDot3Onu2CtcSwitchAdminStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.52", ISnmpConstant.INTEGER));
  }

  public Integer getUtsDot3Onu2CtcModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3Onu2CtcModuleId(Integer aUtsDot3Onu2CtcModuleId) {
    setIndex(0, aUtsDot3Onu2CtcModuleId);
  }


  public Integer getUtsDot3Onu2CtcDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3Onu2CtcDeviceId(Integer aUtsDot3Onu2CtcDeviceId) {
    setIndex(1, aUtsDot3Onu2CtcDeviceId);
  }


  public Integer getUtsDot3Onu2CtcPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3Onu2CtcPortId(Integer aUtsDot3Onu2CtcPortId) {
    setIndex(2, aUtsDot3Onu2CtcPortId);
  }


  public Integer getUtsDot3Onu2CtcLogicalPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3Onu2CtcLogicalPortId(Integer aUtsDot3Onu2CtcLogicalPortId) {
    setIndex(3, aUtsDot3Onu2CtcLogicalPortId);
  }


  public Integer getUtsDot3Onu2CtcLlid() {
    return (Integer) getProperty(utsDot3Onu2CtcLlid).getValue();
  }

  public void setUtsDot3Onu2CtcLlid(Integer aUtsDot3Onu2CtcLlid) {
    getProperty(utsDot3Onu2CtcLlid).setValue(aUtsDot3Onu2CtcLlid);
  }

  public String getUtsDot3Onu2CtcOui() {
    return (String) getProperty(utsDot3Onu2CtcOui).getValue();
  }

  public void setUtsDot3Onu2CtcOui(String aUtsDot3Onu2CtcOui) {
    getProperty(utsDot3Onu2CtcOui).setValue(aUtsDot3Onu2CtcOui);
  }

  public Integer getUtsDot3Onu2CtcOamExtVersion() {
    return (Integer) getProperty(utsDot3Onu2CtcOamExtVersion).getValue();
  }

  public void setUtsDot3Onu2CtcOamExtVersion(Integer aUtsDot3Onu2CtcOamExtVersion) {
    getProperty(utsDot3Onu2CtcOamExtVersion).setValue(aUtsDot3Onu2CtcOamExtVersion);
  }

  public byte[] getUtsDot3Onu2CtcSerialNumber() {
    return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
  }

  public void setUtsDot3Onu2CtcSerialNumber(byte[] aUtsDot3Onu2CtcSerialNumber2) {
    getProperty(utsDot3Onu2CtcSerialNumber).setValue(aUtsDot3Onu2CtcSerialNumber2);
  }

  public byte[] getUtsDot3Onu2CtcOnuVendor()
  {
    return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
  }

  public String getUtsDot3Onu2CtcOnuModel()
  {
    byte[] value = (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    for ( int i = 0; i < 4; i++ ) {
      if ( value[4+i] < 32 || value[4+i] > 126) value[4+i] = 32;
    }

    return new String(value, 4, 4);
  }

  public String getUtsDot3Onu2CtcOnuMacAddr()
  {
    return (String) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
  }

  public String getUtsDot3Onu2CtcOnuHardwareVer()
  {
    return (String) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
  }

  public String getUtsDot3Onu2CtcOnuSoftwareVer()
  {
    return (String) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
  }

  public String getUtsDot3Onu2CtcFwVer() {
    return (String) getProperty(utsDot3Onu2CtcFwVer).getValue();
  }

  public void setUtsDot3Onu2CtcFwVer(String aUtsDot3Onu2CtcFwVersion2) {
    getProperty(utsDot3Onu2CtcFwVer).setValue(aUtsDot3Onu2CtcFwVersion2);
  }

  public Integer getUtsDot3Onu2CtcRegisterStatus() {
    return (Integer) getProperty(utsDot3Onu2CtcRegisterStatus).getValue();
  }

  public void setUtsDot3Onu2CtcRegisterStatus(Integer aUtsDot3Onu2CtcRegisterStatus) {
    getProperty(utsDot3Onu2CtcRegisterStatus).setValue(aUtsDot3Onu2CtcRegisterStatus);
  }
  
  public Integer getUtsDot3Onu2CtcSwitchAdminStatus() {
      return (Integer) getProperty(utsDot3Onu2CtcSwitchAdminStatus).getValue();
    }

    public void setUtsDot3Onu2CtcSwitchAdminStatus(Integer aUtsDot3Onu2CtcSwitchAdminStatus) {
      getProperty(utsDot3Onu2CtcSwitchAdminStatus).setValue(aUtsDot3Onu2CtcSwitchAdminStatus);
    }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3Onu2CtcLlid));
//    prepareRead(super.getProperty(utsDot3Onu2CtcOui));
    prepareRead(super.getProperty(utsDot3Onu2CtcOamExtVersion));
    prepareRead(super.getProperty(utsDot3Onu2CtcSerialNumber));
    prepareRead(super.getProperty(utsDot3Onu2CtcFwVer));
    prepareRead(super.getProperty(utsDot3Onu2CtcRegisterStatus));
    prepareRead(super.getProperty(utsDot3Onu2CtcSwitchAdminStatus));
    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3Onu2CtcLlid));
//    prepareRead(super.getProperty(utsDot3Onu2CtcOui));
    prepareRead(super.getProperty(utsDot3Onu2CtcOamExtVersion));
    prepareRead(super.getProperty(utsDot3Onu2CtcSerialNumber));
    prepareRead(super.getProperty(utsDot3Onu2CtcFwVer));
    prepareRead(super.getProperty(utsDot3Onu2CtcRegisterStatus));
    prepareRead(super.getProperty(utsDot3Onu2CtcSwitchAdminStatus));

    return loadAll(new int[]{1 , 1 , 1 , 1 });
  }
}

package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The EponModuleBoardTable class.
 * Created by QuickDVM
 */
public class MonitorSessionGroup extends SnmpMibBean {
  public static final String utsMonitorSessionModule = "utsMonitorSessionModule";
  public static final String utsMonitorSessionPort = "utsMonitorSessionPort";
  public static final String utsMonitorSessionIngressPortBitLists = "utsMonitorSessionIngressPortBitLists";
  public static final String utsMonitorSessionEngressPortBitLists = "utsMonitorSessionEngressPortBitLists";

  public MonitorSessionGroup(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsMonitorSessionModule, new SnmpMibBeanProperty(utsMonitorSessionModule, ".1.3.6.1.4.1.41355.1800.2.2.1.5.2.1", ISnmpConstant.INTEGER));
    initProperty(utsMonitorSessionPort, new SnmpMibBeanProperty(utsMonitorSessionPort, ".1.3.6.1.4.1.41355.1800.2.2.1.5.2.2", ISnmpConstant.INTEGER));
    initProperty(utsMonitorSessionIngressPortBitLists, new SnmpMibBeanProperty(utsMonitorSessionIngressPortBitLists, ".1.3.6.1.4.1.41355.1800.2.2.1.5.2.3", ISnmpConstant.OCTETS));
    initProperty(utsMonitorSessionEngressPortBitLists, new SnmpMibBeanProperty(utsMonitorSessionEngressPortBitLists, ".1.3.6.1.4.1.41355.1800.2.2.1.5.2.4", ISnmpConstant.OCTETS));
  }


  public Integer getUtsMonitorSessionModule() {
    return (Integer) getProperty(utsMonitorSessionModule).getValue();
  }

  public void setUtsMonitorSessionModule(Integer autsMonitorSessionModule) {
    getProperty(utsMonitorSessionModule).setValue(autsMonitorSessionModule);
  }


  public Integer getUtsMonitorSessionPort() {
    return (Integer) getProperty(utsMonitorSessionPort).getValue();
  }

  public void setUtsMonitorSessionPort(Integer autsMonitorSessionPort) {
    getProperty(utsMonitorSessionPort).setValue(autsMonitorSessionPort);
  }

  public byte[] getUtsMonitorSessionIngressPortBitLists() {
    return (byte[]) getProperty(utsMonitorSessionIngressPortBitLists).getValue();
  }

  public void setUtsMonitorSessionIngressPortBitLists(byte[] autsMonitorSessionIngressPortBitLists) {
    getProperty(utsMonitorSessionIngressPortBitLists).setValue(autsMonitorSessionIngressPortBitLists);
  }

  public byte[] getUtsMonitorSessionEngressPortBitLists() {
    return (byte[]) getProperty(utsMonitorSessionEngressPortBitLists).getValue();
  }

  public void setUtsMonitorSessionEngressPortBitLists(byte[] autsMonitorSessionEngressPortBitLists) {
    getProperty(utsMonitorSessionEngressPortBitLists).setValue(autsMonitorSessionEngressPortBitLists);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsMonitorSessionModule));
    prepareRead(super.getProperty(utsMonitorSessionPort));
    prepareRead(super.getProperty(utsMonitorSessionIngressPortBitLists));
    prepareRead(super.getProperty(utsMonitorSessionEngressPortBitLists));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsMonitorSessionModule));
    prepareRead(super.getProperty(utsMonitorSessionPort));
    prepareRead(super.getProperty(utsMonitorSessionIngressPortBitLists));
    prepareRead(super.getProperty(utsMonitorSessionEngressPortBitLists));

    return loadAll(new int[]{1});
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsMonitorSessionModule));
    prepareSave(getProperty(utsMonitorSessionPort));
    prepareSave(getProperty(utsMonitorSessionIngressPortBitLists));
    prepareSave(getProperty(utsMonitorSessionEngressPortBitLists));

    return save();
  }
}

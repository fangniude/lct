package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The Dot3Olt2PortTable class.
 * Created by QuickDVM
 */
public class OnuLoopbackTestGroup extends SnmpMibBean {
  public static final String utsBBSMgmtLoopbackDetection = "utsBBSMgmtLoopbackDetection";
  public static final String utsBBSMgmtLoopbackDetectIntervalTime = "utsBBSMgmtLoopbackDetectIntervalTime";

  public OnuLoopbackTestGroup(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsBBSMgmtLoopbackDetection, new SnmpMibBeanProperty(utsBBSMgmtLoopbackDetection, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.41", ISnmpConstant.INTEGER));
    initProperty(utsBBSMgmtLoopbackDetectIntervalTime, new SnmpMibBeanProperty(utsBBSMgmtLoopbackDetectIntervalTime, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.42", ISnmpConstant.INTEGER));
  }

  public Integer getUtsDot3OltModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OltModuleId(Integer aUtsDot3OltModuleId) {
    setIndex(0, aUtsDot3OltModuleId);
  }


  public Integer getUtsDot3OltDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OltDeviceId(Integer aUtsDot3OltDeviceId) {
    setIndex(1, aUtsDot3OltDeviceId);
  }


  public Integer getUtsDot3OltPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OltPortId(Integer aUtsDot3OltPortId) {
    setIndex(2, aUtsDot3OltPortId);
  }


  public Integer getUtsBBSMgmtLoopbackDetection() {
    return (Integer) getProperty(utsBBSMgmtLoopbackDetection).getValue();
  }

  public void setUtsBBSMgmtLoopbackDetection(Integer autsBBSMgmtLoopbackDetection) {
    getProperty(utsBBSMgmtLoopbackDetection).setValue(autsBBSMgmtLoopbackDetection);
  }

  public Integer getUtsBBSMgmtLoopbackDetectIntervalTime() {
    return (Integer) getProperty(utsBBSMgmtLoopbackDetectIntervalTime).getValue();
  }

  public void setUtsBBSMgmtLoopbackDetectIntervalTime(Integer autsBBSMgmtLoopbackDetectIntervalTime) {
    getProperty(utsBBSMgmtLoopbackDetectIntervalTime).setValue(autsBBSMgmtLoopbackDetectIntervalTime);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsBBSMgmtLoopbackDetection));
    prepareRead(super.getProperty(utsBBSMgmtLoopbackDetectIntervalTime));

    return load();
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsBBSMgmtLoopbackDetection));
    prepareSave(getProperty(utsBBSMgmtLoopbackDetectIntervalTime));

    return save();
  }
}
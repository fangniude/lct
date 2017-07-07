package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class LoopbackGlobalSettingBean extends SnmpMibBean {
  public static final String utsBBSMgmtLoopbackDetectIntervalTime = "utsBBSMgmtLoopbackDetectIntervalTime";

  public LoopbackGlobalSettingBean(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsBBSMgmtLoopbackDetectIntervalTime, new SnmpMibBeanProperty(utsBBSMgmtLoopbackDetectIntervalTime, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.42", ISnmpConstant.INTEGER));
  }

  public Integer getUtsBBSMgmtLoopbackDetectIntervalTime() {
    return (Integer) getProperty(utsBBSMgmtLoopbackDetectIntervalTime).getValue();
  }

  public void setUtsBBSMgmtLoopbackDetectIntervalTime(Integer autsBBSMgmtLoopbackDetectIntervalTime) {
    getProperty(utsBBSMgmtLoopbackDetectIntervalTime).setValue(autsBBSMgmtLoopbackDetectIntervalTime);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(getProperty(utsBBSMgmtLoopbackDetectIntervalTime));

    return load();
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsBBSMgmtLoopbackDetectIntervalTime));

    return save();
  }
}

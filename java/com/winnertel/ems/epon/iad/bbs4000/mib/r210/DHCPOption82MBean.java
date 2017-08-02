package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class DHCPOption82MBean extends SnmpMibBean {
  public static final String utsBBSMgmtOption82FormatModeSetting = "tsBBSMgmtOption82FormatModeSetting";
  public static final String utsBBSMgmtOption82DefaultCircuitID = "utsBBSMgmtOption82DefaultCircuitID";
  public static final String utsBBSMgmtOption82CustomizedCircuitID = "utsBBSMgmtOption82CustomizedCircuitID";
  public static final String utsBBSMgmtOption82DefaultRemoteID = "utsBBSMgmtOption82DefaultRemoteID";
  public static final String utsBBSMgmtOption82CustomizedRemoteID = "utsBBSMgmtOption82CustomizedRemoteID";
  public static final String utsBBSMgmtOption82CtcAccessNodeIdentifier = "utsBBSMgmtOption82CtcAccessNodeIdentifier";

  public DHCPOption82MBean(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsBBSMgmtOption82FormatModeSetting, new SnmpMibBeanProperty(utsBBSMgmtOption82FormatModeSetting, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.33", ISnmpConstant.INTEGER));
    initProperty(utsBBSMgmtOption82DefaultCircuitID, new SnmpMibBeanProperty(utsBBSMgmtOption82DefaultCircuitID, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.34", ISnmpConstant.STRING));
    initProperty(utsBBSMgmtOption82CustomizedCircuitID, new SnmpMibBeanProperty(utsBBSMgmtOption82CustomizedCircuitID, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.35", ISnmpConstant.STRING));
    initProperty(utsBBSMgmtOption82DefaultRemoteID, new SnmpMibBeanProperty(utsBBSMgmtOption82DefaultRemoteID, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.36", ISnmpConstant.STRING));
    initProperty(utsBBSMgmtOption82CustomizedRemoteID, new SnmpMibBeanProperty(utsBBSMgmtOption82CustomizedRemoteID, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.37", ISnmpConstant.STRING));
    initProperty(utsBBSMgmtOption82CtcAccessNodeIdentifier, new SnmpMibBeanProperty(utsBBSMgmtOption82CtcAccessNodeIdentifier, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.43", ISnmpConstant.STRING));
  }

  public Integer getUtsBBSMgmtOption82FormatModeSetting() {
    return (Integer) getProperty(utsBBSMgmtOption82FormatModeSetting).getValue();
  }

  public void setUtsBBSMgmtOption82FormatModeSetting(Integer aUtsBBSMgmtOption82FormatModeSetting) {
    getProperty(utsBBSMgmtOption82FormatModeSetting).setValue(aUtsBBSMgmtOption82FormatModeSetting);
  }

  public String getUtsBBSMgmtOption82DefaultCircuitID() {
    return (String) getProperty(utsBBSMgmtOption82DefaultCircuitID).getValue();
  }

  public void setUtsBBSMgmtOption82DefaultCircuitID(String aUtsBBSMgmtOption82DefaultCircuitID) {
    getProperty(utsBBSMgmtOption82DefaultCircuitID).setValue(aUtsBBSMgmtOption82DefaultCircuitID);
  }

  public String getUtsBBSMgmtOption82CustomizedCircuitID() {
    return (String) getProperty(utsBBSMgmtOption82CustomizedCircuitID).getValue();
  }

  public void setUtsBBSMgmtOption82CustomizedCircuitID(String aUtsBBSMgmtOption82CustomizedCircuitID) {
    getProperty(utsBBSMgmtOption82CustomizedCircuitID).setValue(aUtsBBSMgmtOption82CustomizedCircuitID);
  }

  public String getUtsBBSMgmtOption82DefaultRemoteID() {
    return (String) getProperty(utsBBSMgmtOption82DefaultRemoteID).getValue();
  }

  public void setUtsBBSMgmtOption82DefaultRemoteID(String aUtsBBSMgmtOption82DefaultRemoteID) {
    getProperty(utsBBSMgmtOption82DefaultRemoteID).setValue(aUtsBBSMgmtOption82DefaultRemoteID);
  }

  public String getUtsBBSMgmtOption82CustomizedRemoteID() {
    return (String) getProperty(utsBBSMgmtOption82CustomizedRemoteID).getValue();
  }

  public void setUtsBBSMgmtOption82CustomizedRemoteID(String aUtsBBSMgmtOption82CustomizedRemoteID) {
    getProperty(utsBBSMgmtOption82CustomizedRemoteID).setValue(aUtsBBSMgmtOption82CustomizedRemoteID);
  }

  public String getUtsBBSMgmtOption82CtcAccessNodeIdentifier() {
    return (String) getProperty(utsBBSMgmtOption82CtcAccessNodeIdentifier).getValue();
  }

  public void setUtsBBSMgmtOption82CtcAccessNodeIdentifier(String aUtsBBSMgmtOption82CtcAccessNodeIdentifier) {
    getProperty(utsBBSMgmtOption82CtcAccessNodeIdentifier).setValue(aUtsBBSMgmtOption82CtcAccessNodeIdentifier);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(getProperty(utsBBSMgmtOption82FormatModeSetting));
    prepareRead(getProperty(utsBBSMgmtOption82DefaultCircuitID));
    prepareRead(getProperty(utsBBSMgmtOption82CustomizedCircuitID));
    prepareRead(getProperty(utsBBSMgmtOption82DefaultRemoteID));
    prepareRead(getProperty(utsBBSMgmtOption82CustomizedRemoteID));
    prepareRead(getProperty(utsBBSMgmtOption82CtcAccessNodeIdentifier));

    return load();
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsBBSMgmtOption82FormatModeSetting));
    prepareSave(getProperty(utsBBSMgmtOption82CustomizedCircuitID));
    prepareSave(getProperty(utsBBSMgmtOption82CustomizedRemoteID));
    prepareSave(getProperty(utsBBSMgmtOption82CtcAccessNodeIdentifier));

    return save();
  }
}

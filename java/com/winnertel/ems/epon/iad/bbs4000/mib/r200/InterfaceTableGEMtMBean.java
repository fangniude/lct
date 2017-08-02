package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-18
 * Time: 14:26:14
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceTableGEMtMBean extends SnmpMibBean {

  public static final String ifIndex = "ifIndex";
  public static final String ifDescr = "ifDescr";
  public static final String ifType = "ifType";
  public static final String ifMtu = "ifMtu";
  public static final String ifSpeed = "ifSpeed";
  public static final String ifPhysAddress = "ifPhysAddress";
  public static final String ifAdminStatus = "ifAdminStatus";
  public static final String ifOperStatus = "ifOperStatus";
  public static final String ifLastChange = "ifLastChange";
  public static final String ifInOctets = "ifInOctets";
  public static final String ifInUcastPkts = "ifInUcastPkts";
  public static final String ifInNUcastPkts = "ifInNUcastPkts";
  public static final String ifInDiscards = "ifInDiscards";
  public static final String ifInErrors = "ifInErrors";
  public static final String ifInUnknownProtos = "ifInUnknownProtos";
  public static final String ifOutOctets = "ifOutOctets";
  public static final String ifOutUcastPkts = "ifOutUcastPkts";
  public static final String ifOutNUcastPkts = "ifOutNUcastPkts";
  public static final String ifOutDiscards = "ifOutDiscards";
  public static final String ifOutErrors = "ifOutErrors";
  public static final String ifOutQLen = "ifOutQLen";
  public static final String ifSpecific = "ifSpecific";
  public static final String utsEthIfExtDescription = "utsEthIfExtDescription";

  public InterfaceTableGEMtMBean(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(ifIndex, new SnmpMibBeanProperty(ifIndex, ".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
    initProperty(ifDescr, new SnmpMibBeanProperty(ifDescr, ".1.3.6.1.2.1.2.2.1.2", ISnmpConstant.STRING));
    initProperty(ifType, new SnmpMibBeanProperty(ifType, ".1.3.6.1.2.1.2.2.1.3", ISnmpConstant.INTEGER));
    initProperty(ifMtu, new SnmpMibBeanProperty(ifMtu, ".1.3.6.1.2.1.2.2.1.4", ISnmpConstant.INTEGER));
    initProperty(ifSpeed, new SnmpMibBeanProperty(ifSpeed, ".1.3.6.1.2.1.2.2.1.5", ISnmpConstant.GAUGE));
    initProperty(ifPhysAddress, new SnmpMibBeanProperty(ifPhysAddress, ".1.3.6.1.2.1.2.2.1.6", ISnmpConstant.MAC_ADDRESS));
    initProperty(ifAdminStatus, new SnmpMibBeanProperty(ifAdminStatus, ".1.3.6.1.2.1.2.2.1.7", ISnmpConstant.INTEGER));
    initProperty(ifOperStatus, new SnmpMibBeanProperty(ifOperStatus, ".1.3.6.1.2.1.2.2.1.8", ISnmpConstant.INTEGER));
    initProperty(ifLastChange, new SnmpMibBeanProperty(ifLastChange, ".1.3.6.1.2.1.2.2.1.9", ISnmpConstant.COUNTER));
    initProperty(ifInOctets, new SnmpMibBeanProperty(ifInOctets, ".1.3.6.1.2.1.2.2.1.10", ISnmpConstant.COUNTER));
    initProperty(ifInUcastPkts, new SnmpMibBeanProperty(ifInUcastPkts, ".1.3.6.1.2.1.2.2.1.11", ISnmpConstant.COUNTER));
    initProperty(ifInNUcastPkts, new SnmpMibBeanProperty(ifInNUcastPkts, ".1.3.6.1.2.1.2.2.1.12", ISnmpConstant.COUNTER));
    initProperty(ifInDiscards, new SnmpMibBeanProperty(ifInDiscards, ".1.3.6.1.2.1.2.2.1.13", ISnmpConstant.COUNTER));
    initProperty(ifInErrors, new SnmpMibBeanProperty(ifInErrors, ".1.3.6.1.2.1.2.2.1.14", ISnmpConstant.COUNTER));
    initProperty(ifInUnknownProtos, new SnmpMibBeanProperty(ifInUnknownProtos, ".1.3.6.1.2.1.2.2.1.15", ISnmpConstant.COUNTER));
    initProperty(ifOutOctets, new SnmpMibBeanProperty(ifOutOctets, ".1.3.6.1.2.1.2.2.1.16", ISnmpConstant.COUNTER));
    initProperty(ifOutUcastPkts, new SnmpMibBeanProperty(ifOutUcastPkts, ".1.3.6.1.2.1.2.2.1.17", ISnmpConstant.COUNTER));
    initProperty(ifOutNUcastPkts, new SnmpMibBeanProperty(ifOutNUcastPkts, ".1.3.6.1.2.1.2.2.1.18", ISnmpConstant.COUNTER));
    initProperty(ifOutDiscards, new SnmpMibBeanProperty(ifOutDiscards, ".1.3.6.1.2.1.2.2.1.19", ISnmpConstant.COUNTER));
    initProperty(ifOutErrors, new SnmpMibBeanProperty(ifOutErrors, ".1.3.6.1.2.1.2.2.1.20", ISnmpConstant.COUNTER));
    initProperty(ifOutQLen, new SnmpMibBeanProperty(ifOutQLen, ".1.3.6.1.2.1.2.2.1.21", ISnmpConstant.COUNTER));
    initProperty(ifSpecific, new SnmpMibBeanProperty(ifSpecific, ".1.3.6.1.2.1.2.2.1.22", ISnmpConstant.OBJID));
    initProperty(utsEthIfExtDescription, new SnmpMibBeanProperty(utsEthIfExtDescription, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.12", ISnmpConstant.STRING));
  }


  public Integer getIfIndex() {
    return (Integer) getIndex(0);
  }

  public void setIfIndex(Integer aIfIndex) {
    setIndex(0, aIfIndex);
  }


  public String getIfDescr() {
    return (String) getProperty(ifDescr).getValue();
  }

  public void setIfDescr(String aIfDescr) {
    getProperty(ifDescr).setValue(aIfDescr);
  }

  public Integer getIfType() {
    return (Integer) getProperty(ifType).getValue();
  }

  public void setIfType(Integer aIfType) {
    getProperty(ifType).setValue(aIfType);
  }

  public Integer getIfMtu() {
    return (Integer) getProperty(ifMtu).getValue();
  }

  public void setIfMtu(Integer aIfMtu) {
    getProperty(ifMtu).setValue(aIfMtu);
  }

  public Long getIfSpeed() {
    return (Long) getProperty(ifSpeed).getValue();
  }

  public void setIfSpeed(Long aIfSpeed) {
    getProperty(ifSpeed).setValue(aIfSpeed);
  }

  public byte[] getIfPhysAddress() {
    return (byte[]) getProperty(ifPhysAddress).getValue();
  }

  public void setIfPhysAddress(byte[] aIfPhysAddress) {
    getProperty(ifPhysAddress).setValue(aIfPhysAddress);
  }

  public Integer getIfAdminStatus() {
    return (Integer) getProperty(ifAdminStatus).getValue();
  }

  public void setIfAdminStatus(Integer aIfAdminStatus) {
    getProperty(ifAdminStatus).setValue(aIfAdminStatus);
  }

  public Integer getIfOperStatus() {
    return (Integer) getProperty(ifOperStatus).getValue();
  }

  public void setIfOperStatus(Integer aIfOperStatus) {
    getProperty(ifOperStatus).setValue(aIfOperStatus);
  }

  public Long getIfLastChange() {
    return (Long) getProperty(ifLastChange).getValue();
  }

  public void setIfLastChange(Long aIfLastChange) {
    getProperty(ifLastChange).setValue(aIfLastChange);
  }

  public Long getIfInOctets() {
    return (Long) getProperty(ifInOctets).getValue();
  }

  public void setIfInOctets(Long aIfInOctets) {
    getProperty(ifInOctets).setValue(aIfInOctets);
  }

  public Long getIfInUcastPkts() {
    return (Long) getProperty(ifInUcastPkts).getValue();
  }

  public void setIfInUcastPkts(Long aIfInUcastPkts) {
    getProperty(ifInUcastPkts).setValue(aIfInUcastPkts);
  }

  public Long getIfInNUcastPkts() {
    return (Long) getProperty(ifInNUcastPkts).getValue();
  }

  public void setIfInNUcastPkts(Long aIfInNUcastPkts) {
    getProperty(ifInNUcastPkts).setValue(aIfInNUcastPkts);
  }

  public Long getIfInDiscards() {
    return (Long) getProperty(ifInDiscards).getValue();
  }

  public void setIfInDiscards(Long aIfInDiscards) {
    getProperty(ifInDiscards).setValue(aIfInDiscards);
  }

  public Long getIfInErrors() {
    return (Long) getProperty(ifInErrors).getValue();
  }

  public void setIfInErrors(Long aIfInErrors) {
    getProperty(ifInErrors).setValue(aIfInErrors);
  }

  public Long getIfInUnknownProtos() {
    return (Long) getProperty(ifInUnknownProtos).getValue();
  }

  public void setIfInUnknownProtos(Long aIfInUnknownProtos) {
    getProperty(ifInUnknownProtos).setValue(aIfInUnknownProtos);
  }

  public Long getIfOutOctets() {
    return (Long) getProperty(ifOutOctets).getValue();
  }

  public void setIfOutOctets(Long aIfOutOctets) {
    getProperty(ifOutOctets).setValue(aIfOutOctets);
  }

  public Long getIfOutUcastPkts() {
    return (Long) getProperty(ifOutUcastPkts).getValue();
  }

  public void setIfOutUcastPkts(Long aIfOutUcastPkts) {
    getProperty(ifOutUcastPkts).setValue(aIfOutUcastPkts);
  }

  public Long getIfOutNUcastPkts() {
    return (Long) getProperty(ifOutNUcastPkts).getValue();
  }

  public void setIfOutNUcastPkts(Long aIfOutNUcastPkts) {
    getProperty(ifOutNUcastPkts).setValue(aIfOutNUcastPkts);
  }

  public Long getIfOutDiscards() {
    return (Long) getProperty(ifOutDiscards).getValue();
  }

  public void setIfOutDiscards(Long aIfOutDiscards) {
    getProperty(ifOutDiscards).setValue(aIfOutDiscards);
  }

  public Long getIfOutErrors() {
    return (Long) getProperty(ifOutErrors).getValue();
  }

  public void setIfOutErrors(Long aIfOutErrors) {
    getProperty(ifOutErrors).setValue(aIfOutErrors);
  }

  public Long getIfOutQLen() {
    return (Long) getProperty(ifOutQLen).getValue();
  }

  public void setIfOutQLen(Long aIfOutQLen) {
    getProperty(ifOutQLen).setValue(aIfOutQLen);
  }

  public String getIfSpecific() {
    return (String) getProperty(ifSpecific).getValue();
  }

  public void setIfSpecific(String aIfSpecific) {
    getProperty(ifSpecific).setValue(aIfSpecific);
  }

  public String getUtsEthIfExtDescription() {
    return (String) getProperty(utsEthIfExtDescription).getValue();
  }

  public void setUtsEthIfExtDescription(String aUtsEthIfExtDescription) {
    getProperty(utsEthIfExtDescription).setValue(aUtsEthIfExtDescription);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(ifDescr));
//        prepareRead(super.getProperty(ifType));
    prepareRead(super.getProperty(ifMtu));
    prepareRead(super.getProperty(ifSpeed));
    prepareRead(super.getProperty(ifPhysAddress));
    prepareRead(super.getProperty(ifAdminStatus));
    prepareRead(super.getProperty(ifOperStatus));
//        prepareRead(super.getProperty(ifLastChange));
//        prepareRead(super.getProperty(ifInOctets));
//        prepareRead(super.getProperty(ifInUcastPkts));
//        prepareRead(super.getProperty(ifInNUcastPkts));
//        prepareRead(super.getProperty(ifInDiscards));
//        prepareRead(super.getProperty(ifInErrors));
//        prepareRead(super.getProperty(ifInUnknownProtos));
//        prepareRead(super.getProperty(ifOutOctets));
//        prepareRead(super.getProperty(ifOutUcastPkts));
//        prepareRead(super.getProperty(ifOutNUcastPkts));
//        prepareRead(super.getProperty(ifOutDiscards));
//        prepareRead(super.getProperty(ifOutErrors));
//        prepareRead(super.getProperty(ifOutQLen));
//        prepareRead(super.getProperty(ifSpecific));
    prepareRead(super.getProperty(utsEthIfExtDescription));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(ifDescr));
//        prepareRead(super.getProperty(ifType));
    prepareRead(super.getProperty(ifMtu));
    prepareRead(super.getProperty(ifSpeed));
    prepareRead(super.getProperty(ifPhysAddress));
    prepareRead(super.getProperty(ifAdminStatus));
    prepareRead(super.getProperty(ifOperStatus));
//        prepareRead(super.getProperty(ifLastChange));
//        prepareRead(super.getProperty(ifInOctets));
//        prepareRead(super.getProperty(ifInUcastPkts));
//        prepareRead(super.getProperty(ifInNUcastPkts));
//        prepareRead(super.getProperty(ifInDiscards));
//        prepareRead(super.getProperty(ifInErrors));
//        prepareRead(super.getProperty(ifInUnknownProtos));
//        prepareRead(super.getProperty(ifOutOctets));
//        prepareRead(super.getProperty(ifOutUcastPkts));
//        prepareRead(super.getProperty(ifOutNUcastPkts));
//        prepareRead(super.getProperty(ifOutDiscards));
//        prepareRead(super.getProperty(ifOutErrors));
//        prepareRead(super.getProperty(ifOutQLen));
//        prepareRead(super.getProperty(ifSpecific));
    prepareRead(super.getProperty(utsEthIfExtDescription));

    //setRowsToFetch(4);

    return loadAll(new int[]{1});
  }


  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(ifAdminStatus));
    prepareSave(getProperty(utsEthIfExtDescription));

    return save();
  }

}
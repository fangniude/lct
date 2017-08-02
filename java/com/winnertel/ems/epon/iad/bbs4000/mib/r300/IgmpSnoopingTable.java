package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class IgmpSnoopingTable extends SnmpMibBean {
  public static final String utsIgmpSnoopingVID = "utsIgmpSnoopingVID";
  public static final String utsIgmpSnoopingGroupAddress = "utsIgmpSnoopingGroupAddress";
  public static final String utsIgmpSnoopingSourceAddress = "utsIgmpSnoopingSourceAddress";
  public static final String utsIgmpSnoopingType = "utsIgmpSnoopingType";
  public static final String utsIgmpSnoopingExpiryTime = "utsIgmpSnoopingExpiryTime";
  public static final String utsIgmpSnoopingEgressPortList = "utsIgmpSnoopingEgressPortList";

  public IgmpSnoopingTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsIgmpSnoopingVID, new SnmpMibBeanProperty(utsIgmpSnoopingVID, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.3.1.1", ISnmpConstant.INTEGER));
    initProperty(utsIgmpSnoopingGroupAddress, new SnmpMibBeanProperty(utsIgmpSnoopingGroupAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.3.1.2", ISnmpConstant.IP_ADDRESS));
    initProperty(utsIgmpSnoopingSourceAddress, new SnmpMibBeanProperty(utsIgmpSnoopingSourceAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.3.1.3", ISnmpConstant.IP_ADDRESS));
 
    initProperty(utsIgmpSnoopingType, new SnmpMibBeanProperty(utsIgmpSnoopingType, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.3.1.6", ISnmpConstant.INTEGER));
    initProperty(utsIgmpSnoopingExpiryTime, new SnmpMibBeanProperty(utsIgmpSnoopingExpiryTime, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.3.1.11", ISnmpConstant.INTEGER));
    initProperty(utsIgmpSnoopingEgressPortList, new SnmpMibBeanProperty(utsIgmpSnoopingEgressPortList, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.3.1.16", ISnmpConstant.OCTETS));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.2.1.6.9.3.1.100", ISnmpConstant.INTEGER));
  }

  public Integer getUtsIgmpSnoopingVID() {
    return (Integer) getIndex(0);
  }

  public void setUtsIgmpSnoopingVID(Integer aUtsIgmpSnoopingVID) {
    setIndex(0, aUtsIgmpSnoopingVID);
  }


  public String getUtsIgmpSnoopingGroupAddress() {
    return (String) getIndex(1);
  }

  public void setUtsIgmpSnoopingGroupAddress(String aUtsIgmpSnoopingGroupAddress) {
    setIndex(1, aUtsIgmpSnoopingGroupAddress);
  }
  
  public String getUtsIgmpSnoopingSourceAddress() {
	    return (String) getIndex(1);
	  }

  public void setUtsIgmpSnoopingSourceAddress(String aUtsIgmpSnoopingSourceAddress) {
	  setIndex(1, aUtsIgmpSnoopingSourceAddress);
  }

  public Integer getUtsIgmpSnoopingType() {
    return (Integer) getProperty(utsIgmpSnoopingType).getValue();
  }

  public void setUtsIgmpSnoopingType(Integer aUtsIgmpSnoopingType) {
    getProperty(utsIgmpSnoopingType).setValue(aUtsIgmpSnoopingType);
  }

  public Integer getUtsIgmpSnoopingExpiryTime() {
    return (Integer)getProperty(utsIgmpSnoopingExpiryTime).getValue();
  }

  public void setUtsIgmpSnoopingExpiryTime(Integer aUtsIgmpSnoopingExpiryTime) {
    getProperty(utsIgmpSnoopingExpiryTime).setValue(aUtsIgmpSnoopingExpiryTime);
  }

  public byte[] getUtsIgmpSnoopingEgressPortList() {
    return (byte[])getProperty(utsIgmpSnoopingEgressPortList).getValue();
  }

  public void setUtsIgmpSnoopingEgressPortList(byte[] aUtsIgmpSnoopingEgressPortList) {
    getProperty(utsIgmpSnoopingEgressPortList).setValue(aUtsIgmpSnoopingEgressPortList);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsIgmpSnoopingType));
    prepareRead(super.getProperty(utsIgmpSnoopingExpiryTime));
    prepareRead(super.getProperty(utsIgmpSnoopingEgressPortList));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsIgmpSnoopingType));
    prepareRead(super.getProperty(utsIgmpSnoopingExpiryTime));
    prepareRead(super.getProperty(utsIgmpSnoopingEgressPortList));

    return loadAll(new int[]{1, 4,4});
  }

  public boolean add() throws MibBeanException {
    prepareSave(getProperty(utsIgmpSnoopingType));
    prepareSave(getProperty(utsIgmpSnoopingExpiryTime));
    prepareSave(getProperty(utsIgmpSnoopingEgressPortList));

    super.setRowStatus(4);
    prepareSave(getProperty(ROW_STATUS));

    return save();
  }

  public boolean delete() throws MibBeanException {
    super.setRowStatus(6);
    prepareSave(getProperty(ROW_STATUS));

    return save();
  }
}

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuBwProfTable class.
 * Created by QuickDVM
 */
public class OnuBwProfTable extends SnmpMibBean {
  public static final String bandwidthProfileIndex = "bandwidthProfileIndex";
  public static final String onuBwProfileName = "onuBwProfileName";
  public static final String trafficType = "trafficType";
  public static final String fixedBandwidth = "fixedBandwidth";
  public static final String assuredBandwidth = "assuredBandwidth";
  public static final String maximumBandwidth = "maximumBandwidth";

  public OnuBwProfTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(bandwidthProfileIndex, new SnmpMibBeanProperty(
        bandwidthProfileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.4.1.1",
        ISnmpConstant.GAUGE));
    initProperty(onuBwProfileName, new SnmpMibBeanProperty(onuBwProfileName,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.4.1.2", ISnmpConstant.STRING));
    initProperty(trafficType, new SnmpMibBeanProperty(trafficType,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.4.1.3", ISnmpConstant.INTEGER));
    initProperty(fixedBandwidth, new SnmpMibBeanProperty(fixedBandwidth,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.4.1.4", ISnmpConstant.GAUGE));
    initProperty(assuredBandwidth, new SnmpMibBeanProperty(assuredBandwidth,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.4.1.5", ISnmpConstant.GAUGE));
    initProperty(maximumBandwidth, new SnmpMibBeanProperty(maximumBandwidth,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.4.1.6", ISnmpConstant.GAUGE));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.4.1.7", ISnmpConstant.INTEGER));

  }

  public Long getBandwidthProfileIndex() {
    return (Long) getIndex(0);
  }

  public void setBandwidthProfileIndex(Long aBandwidthProfileIndex) {
    setIndex(0, aBandwidthProfileIndex);
  }

  public String getOnuBwProfileName() {
    return (String) getProperty(onuBwProfileName).getValue();
  }

  public void setOnuBwProfileName(String aOnuBwProfileName) {
    getProperty(onuBwProfileName).setValue(aOnuBwProfileName);
  }

  public Integer getTrafficType() {
    return (Integer) getProperty(trafficType).getValue();
  }

  public void setTrafficType(Integer aTrafficType) {
    getProperty(trafficType).setValue(aTrafficType);
  }

  public Long getFixedBandwidth() {
    return (Long) getProperty(fixedBandwidth).getValue();
  }

  public void setFixedBandwidth(Long aFixedBandwidth) {
    getProperty(fixedBandwidth).setValue(aFixedBandwidth);
  }

  public Long getAssuredBandwidth() {
    return (Long) getProperty(assuredBandwidth).getValue();
  }

  public void setAssuredBandwidth(Long aAssuredBandwidth) {
    getProperty(assuredBandwidth).setValue(aAssuredBandwidth);
  }

  public Long getMaximumBandwidth() {
    return (Long) getProperty(maximumBandwidth).getValue();
  }

  public void setMaximumBandwidth(Long aMaximumBandwidth) {
    getProperty(maximumBandwidth).setValue(aMaximumBandwidth);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(onuBwProfileName));
    prepareRead(super.getProperty(trafficType));
    prepareRead(super.getProperty(fixedBandwidth));
    prepareRead(super.getProperty(assuredBandwidth));
    prepareRead(super.getProperty(maximumBandwidth));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(onuBwProfileName));
    prepareRead(super.getProperty(trafficType));
    prepareRead(super.getProperty(fixedBandwidth));
    prepareRead(super.getProperty(assuredBandwidth));
    prepareRead(super.getProperty(maximumBandwidth));

    return loadAll(new int[] { 2 });
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(onuBwProfileName));
    prepareSave(getProperty(trafficType));
    prepareSave(getProperty(fixedBandwidth));
    prepareSave(getProperty(assuredBandwidth));
    prepareSave(getProperty(maximumBandwidth));

    return save();
  }

  public boolean add() throws MibBeanException {
    prepareSave(getProperty(onuBwProfileName));
    prepareSave(getProperty(trafficType));
    prepareSave(getProperty(fixedBandwidth));
    prepareSave(getProperty(assuredBandwidth));
    prepareSave(getProperty(maximumBandwidth));
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

  public String toString() {
      return getOnuBwProfileName();
  }
}

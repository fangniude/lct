package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuVPorSvcProfTable class.
 * Created by QuickDVM
 */
public class OnuVPorSvcProfTable extends SnmpMibBean {
  public static final String virtualPortServiceProfileIndex = "virtualPortServiceProfileIndex";
  public static final String onuVPorSvcProfileName = "onuVPorSvcProfileName";
  public static final String upstreamTrafficMappingType = "upstreamTrafficMappingType";
  public static final String typeOfService = "typeOfService";
  public static final String encryptionMode = "encryptionMode";
  public static final String onuVPortSvcProfUpstreamBandwidthProfileIndex = "onuVPortSvcProfUpstreamBandwidthProfileIndex";
  public static final String upstreamFlowPriority = "upstreamFlowPriority";
  public static final String upstreamFlowWeight = "upstreamFlowWeight";
  public static final String upstreamRateControlSchedulerProfileIndex = "upstreamRateControlSchedulerProfileIndex";
  public static final String downstreamBandwidthProfileIndex = "downstreamBandwidthProfileIndex";
  public static final String downstreamQueuingSchedulingType = "downstreamQueuingSchedulingType";
  public static final String downstreamFlowPriority = "downstreamFlowPriority";

  public OnuVPorSvcProfTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(virtualPortServiceProfileIndex, new SnmpMibBeanProperty(
        virtualPortServiceProfileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.1",
        ISnmpConstant.GAUGE));
    initProperty(onuVPorSvcProfileName, new SnmpMibBeanProperty(
        onuVPorSvcProfileName, ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.2",
        ISnmpConstant.STRING));
    initProperty(upstreamTrafficMappingType, new SnmpMibBeanProperty(
        upstreamTrafficMappingType, ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.3",
        ISnmpConstant.GAUGE));
    initProperty(typeOfService, new SnmpMibBeanProperty(typeOfService,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.4", ISnmpConstant.INTEGER));
    initProperty(encryptionMode, new SnmpMibBeanProperty(encryptionMode,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.5", ISnmpConstant.INTEGER));
    initProperty(onuVPortSvcProfUpstreamBandwidthProfileIndex, new SnmpMibBeanProperty(onuVPortSvcProfUpstreamBandwidthProfileIndex,
            ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.6", ISnmpConstant.GAUGE));
    initProperty(upstreamFlowPriority, new SnmpMibBeanProperty(
        upstreamFlowPriority, ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.7",
        ISnmpConstant.GAUGE));
    initProperty(upstreamFlowWeight, new SnmpMibBeanProperty(
        upstreamFlowWeight, ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.8",
        ISnmpConstant.GAUGE));
    initProperty(upstreamRateControlSchedulerProfileIndex,
        new SnmpMibBeanProperty(upstreamRateControlSchedulerProfileIndex,
            ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.9", ISnmpConstant.GAUGE));
    initProperty(downstreamBandwidthProfileIndex, new SnmpMibBeanProperty(
        downstreamBandwidthProfileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.10",
        ISnmpConstant.GAUGE));
    initProperty(downstreamQueuingSchedulingType, new SnmpMibBeanProperty(
        downstreamQueuingSchedulingType, ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.11",
        ISnmpConstant.INTEGER));
    initProperty(downstreamFlowPriority, new SnmpMibBeanProperty(
        downstreamFlowPriority, ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.12",
        ISnmpConstant.GAUGE));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
        ".1.3.6.1.4.1.45121.1.3.10.5.2.3.1.13", ISnmpConstant.INTEGER));

  }

  public Long getVirtualPortServiceProfileIndex() {
    return (Long) getIndex(0);
  }

  public void setVirtualPortServiceProfileIndex(
      Long aVirtualPortServiceProfileIndex) {
    setIndex(0, aVirtualPortServiceProfileIndex);
  }

  public String getOnuVPorSvcProfileName() {
    return (String) getProperty(onuVPorSvcProfileName).getValue();
  }

  public void setOnuVPorSvcProfileName(String aOnuVPorSvcProfileName) {
    getProperty(onuVPorSvcProfileName).setValue(aOnuVPorSvcProfileName);
  }

  public Long getUpstreamTrafficMappingType() {
    return (Long) getProperty(upstreamTrafficMappingType).getValue();
  }

  public void setUpstreamTrafficMappingType(Long aUpstreamTrafficMappingType) {
    getProperty(upstreamTrafficMappingType).setValue(
        aUpstreamTrafficMappingType);
  }

  public Integer getTypeOfService() {
    return (Integer) getProperty(typeOfService).getValue();
  }

  public void setTypeOfService(Integer aTypeOfService) {
    getProperty(typeOfService).setValue(aTypeOfService);
  }

  public Integer getEncryptionMode() {
    return (Integer) getProperty(encryptionMode).getValue();
  }

  public void setEncryptionMode(Integer aEncryptionMode) {
    getProperty(encryptionMode).setValue(aEncryptionMode);
  }
  
  public Long getOnuVPortSvcProfUpstreamBandwidthProfileIndex() {
	    return (Long) getProperty(onuVPortSvcProfUpstreamBandwidthProfileIndex).getValue();
  }

  public void setOnuVPortSvcProfUpstreamBandwidthProfileIndex(Long aOnuVPortSvcProfUpstreamBandwidthProfileIndex) {
	  getProperty(onuVPortSvcProfUpstreamBandwidthProfileIndex).setValue(aOnuVPortSvcProfUpstreamBandwidthProfileIndex);
  }
  
  public Long getUpstreamFlowPriority() {
    return (Long) getProperty(upstreamFlowPriority).getValue();
  }

  public void setUpstreamFlowPriority(Long aUpstreamFlowPriority) {
    getProperty(upstreamFlowPriority).setValue(aUpstreamFlowPriority);
  }

  public Long getUpstreamFlowWeight() {
    return (Long) getProperty(upstreamFlowWeight).getValue();
  }

  public void setUpstreamFlowWeight(Long aUpstreamFlowWeight) {
    getProperty(upstreamFlowWeight).setValue(aUpstreamFlowWeight);
  }

  public Long getUpstreamRateControlSchedulerProfileIndex() {
    return (Long) getProperty(upstreamRateControlSchedulerProfileIndex)
        .getValue();
  }

  public void setUpstreamRateControlSchedulerProfileIndex(
      Long aUpstreamRateControlSchedulerProfileIndex) {
    getProperty(upstreamRateControlSchedulerProfileIndex).setValue(
        aUpstreamRateControlSchedulerProfileIndex);
  }

  public Long getDownstreamBandwidthProfileIndex() {
    return (Long) getProperty(downstreamBandwidthProfileIndex).getValue();
  }

  public void setDownstreamBandwidthProfileIndex(
      Long aDownstreamBandwidthProfileIndex) {
    getProperty(downstreamBandwidthProfileIndex).setValue(
        aDownstreamBandwidthProfileIndex);
  }

  public Integer getDownstreamQueuingSchedulingType() {
    return (Integer) getProperty(downstreamQueuingSchedulingType).getValue();
  }

  public void setDownstreamQueuingSchedulingType(
      Integer aDownstreamQueuingSchedulingType) {
    getProperty(downstreamQueuingSchedulingType).setValue(
        aDownstreamQueuingSchedulingType);
  }

  public Long getDownstreamFlowPriority() {
    return (Long) getProperty(downstreamFlowPriority).getValue();
  }

  public void setDownstreamFlowPriority(Long aDownstreamFlowPriority) {
    getProperty(downstreamFlowPriority).setValue(aDownstreamFlowPriority);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(onuVPorSvcProfileName));
    prepareRead(super.getProperty(upstreamTrafficMappingType));
    prepareRead(super.getProperty(typeOfService));
    prepareRead(super.getProperty(encryptionMode));
    prepareRead(super.getProperty(onuVPortSvcProfUpstreamBandwidthProfileIndex));
    prepareRead(super.getProperty(upstreamFlowPriority));
    prepareRead(super.getProperty(upstreamFlowWeight));
    prepareRead(super.getProperty(upstreamRateControlSchedulerProfileIndex));
    prepareRead(super.getProperty(downstreamBandwidthProfileIndex));
    prepareRead(super.getProperty(downstreamQueuingSchedulingType));
    prepareRead(super.getProperty(downstreamFlowPriority));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(onuVPorSvcProfileName));
    prepareRead(super.getProperty(upstreamTrafficMappingType));
    prepareRead(super.getProperty(typeOfService));
    prepareRead(super.getProperty(encryptionMode));
    prepareRead(super.getProperty(onuVPortSvcProfUpstreamBandwidthProfileIndex));
    prepareRead(super.getProperty(upstreamFlowPriority));
    prepareRead(super.getProperty(upstreamFlowWeight));
    prepareRead(super.getProperty(upstreamRateControlSchedulerProfileIndex));
    prepareRead(super.getProperty(downstreamBandwidthProfileIndex));
    prepareRead(super.getProperty(downstreamQueuingSchedulingType));
    prepareRead(super.getProperty(downstreamFlowPriority));

    return loadAll(new int[] { 2 });
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(onuVPorSvcProfileName));
    prepareSave(getProperty(typeOfService));
    prepareSave(getProperty(encryptionMode));
    prepareSave(getProperty(onuVPortSvcProfUpstreamBandwidthProfileIndex));
    prepareSave(getProperty(upstreamFlowPriority));
    prepareSave(getProperty(upstreamFlowWeight));
    prepareSave(getProperty(upstreamRateControlSchedulerProfileIndex));
    prepareSave(getProperty(downstreamBandwidthProfileIndex));
    prepareSave(getProperty(downstreamQueuingSchedulingType));
    prepareSave(getProperty(downstreamFlowPriority));

    return save();
  }

  public boolean add() throws MibBeanException {
    prepareSave(getProperty(onuVPorSvcProfileName));
    prepareSave(getProperty(typeOfService));
    prepareSave(getProperty(encryptionMode));
    prepareSave(getProperty(onuVPortSvcProfUpstreamBandwidthProfileIndex));
    prepareSave(getProperty(upstreamFlowPriority));
    prepareSave(getProperty(upstreamFlowWeight));
    prepareSave(getProperty(upstreamRateControlSchedulerProfileIndex));
    prepareSave(getProperty(downstreamBandwidthProfileIndex));
    prepareSave(getProperty(downstreamQueuingSchedulingType));
    prepareSave(getProperty(downstreamFlowPriority));

    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }
  
  public String toString(){
      return getOnuVPorSvcProfileName();
  }

}

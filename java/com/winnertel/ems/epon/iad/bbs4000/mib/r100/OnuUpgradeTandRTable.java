package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuUpgradeTandRTable class.
 * Created by QuickDVM
 */
public class OnuUpgradeTandRTable extends SnmpMibBean {
  public static final String onuUpgradeTaskandResultIndex = "onuUpgradeTaskandResultIndex";
  public static final String onuUpgradeTaskandResultOnuUpgradeTarget = "onuUpgradeTaskandResultOnuUpgradeTarget";
  public static final String onuUpgradeTaskandResultOnuUpgradeMethod = "onuUpgradeTaskandResultOnuUpgradeMethod";
  public static final String onuUpgradeTaskandResultOnuUpgradeOption = "onuUpgradeTaskandResultOnuUpgradeOption";
  public static final String onuUpgradeTaskStatus = "onuUpgradeTaskStatus";
  public static final String onuUpgradeImageInstance = "onuUpgradeImageInstance";
  public static final String onuUpgradeRebootMode = "onuUpgradeRebootMode";
  public static final String onuUpgradeScheduledTime = "onuUpgradeScheduledTime";
  public static final String onuUpgradeRebooScheduledTime = "onuUpgradeRebooScheduledTime";
  public static final String onuUpgradeParticipantPortListBitMap = "onuUpgradeParticipantPortListBitMap";
  public static final String onuUpgradeImageInstancePortListBitMap = "onuUpgradeImageInstancePortListBitMap";
  public static final String onuUpgradeProgressDownloadPortListBitMap = "onuUpgradeProgressDownloadPortListBitMap";
  public static final String onuUpgradeProgressActivatePortListBitMap = "onuUpgradeProgressActivatePortListBitMap";
  public static final String onuUpgradeProgressCommitPortListBitMap = "onuUpgradeProgressCommitPortListBitMap";
  public static final String onuUpgradeProgressFinalPortListBitMap = "onuUpgradeProgressFinalPortListBitMap";
  public static final String onuUpgradeResultPortListBitMap = "onuUpgradeResultPortListBitMap";

  private String onuUpgradeResult = null;

  public OnuUpgradeTandRTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(onuUpgradeTaskandResultIndex, new SnmpMibBeanProperty(
        onuUpgradeTaskandResultIndex, ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.1",
        ISnmpConstant.GAUGE));
    initProperty(onuUpgradeTaskandResultOnuUpgradeTarget,
        new SnmpMibBeanProperty(onuUpgradeTaskandResultOnuUpgradeTarget,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.2", ISnmpConstant.INTEGER));
    initProperty(onuUpgradeTaskandResultOnuUpgradeMethod,
        new SnmpMibBeanProperty(onuUpgradeTaskandResultOnuUpgradeMethod,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.3", ISnmpConstant.INTEGER));
    initProperty(onuUpgradeTaskandResultOnuUpgradeOption,
        new SnmpMibBeanProperty(onuUpgradeTaskandResultOnuUpgradeOption,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.4", ISnmpConstant.INTEGER));
    initProperty(onuUpgradeTaskStatus, new SnmpMibBeanProperty(
        onuUpgradeTaskStatus, ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.5",
        ISnmpConstant.INTEGER));
    initProperty(onuUpgradeImageInstance, new SnmpMibBeanProperty(
        onuUpgradeImageInstance, ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.6",
        ISnmpConstant.INTEGER));
    initProperty(onuUpgradeRebootMode, new SnmpMibBeanProperty(
        onuUpgradeRebootMode, ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.7",
        ISnmpConstant.INTEGER));
    initProperty(onuUpgradeScheduledTime, new SnmpMibBeanProperty(
        onuUpgradeScheduledTime, ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.8",
        ISnmpConstant.STRING));
    initProperty(onuUpgradeRebooScheduledTime, new SnmpMibBeanProperty(
        onuUpgradeRebooScheduledTime, ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.9",
        ISnmpConstant.STRING));
    initProperty(onuUpgradeParticipantPortListBitMap, new SnmpMibBeanProperty(
        onuUpgradeParticipantPortListBitMap,
        ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.10", ISnmpConstant.OCTETS));
    initProperty(onuUpgradeImageInstancePortListBitMap,
        new SnmpMibBeanProperty(onuUpgradeImageInstancePortListBitMap,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.11", ISnmpConstant.OCTETS));
    initProperty(onuUpgradeProgressDownloadPortListBitMap,
        new SnmpMibBeanProperty(onuUpgradeProgressDownloadPortListBitMap,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.12", ISnmpConstant.OCTETS));
    initProperty(onuUpgradeProgressActivatePortListBitMap,
        new SnmpMibBeanProperty(onuUpgradeProgressActivatePortListBitMap,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.13", ISnmpConstant.OCTETS));
    initProperty(onuUpgradeProgressCommitPortListBitMap,
        new SnmpMibBeanProperty(onuUpgradeProgressCommitPortListBitMap,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.14", ISnmpConstant.OCTETS));
    initProperty(onuUpgradeProgressFinalPortListBitMap,
        new SnmpMibBeanProperty(onuUpgradeProgressFinalPortListBitMap,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.15", ISnmpConstant.OCTETS));
    initProperty(onuUpgradeResultPortListBitMap, new SnmpMibBeanProperty(
        onuUpgradeResultPortListBitMap, ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.16",
        ISnmpConstant.OCTETS));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
        ".1.3.6.1.4.1.41355.1.3.10.5.2.22.1.17", ISnmpConstant.INTEGER));

  }
  
  public Long getOnuUpgradeTaskandResultIndex() {
  //  return (Long) getProperty(onuUpgradeTaskandResultIndex).getValue();
    return (Long)getIndex(0);
  }

  public void setOnuUpgradeTaskandResultIndex(
      Long aOnuUpgradeTaskandResultIndex) {
//    getProperty(onuUpgradeTaskandResultIndex).setValue(
//        aOnuUpgradeTaskandResultIndex);
  setIndex(0,aOnuUpgradeTaskandResultIndex);
  }
  

  public Integer getOnuUpgradeTaskandResultOnuUpgradeTarget() {
    return (Integer) getIndex(1);
  }

  public void setOnuUpgradeTaskandResultOnuUpgradeTarget(
      Integer aOnuUpgradeTaskandResultOnuUpgradeTarget) {
    setIndex(1, aOnuUpgradeTaskandResultOnuUpgradeTarget);
  }

  public Integer getOnuUpgradeTaskandResultOnuUpgradeMethod() {
    return (Integer) getIndex(2);
  }

  public void setOnuUpgradeTaskandResultOnuUpgradeMethod(
      Integer aOnuUpgradeTaskandResultOnuUpgradeMethod) {
    setIndex(2, aOnuUpgradeTaskandResultOnuUpgradeMethod);
  }



  public Integer getOnuUpgradeTaskandResultOnuUpgradeOption() {
    return (Integer) getProperty(onuUpgradeTaskandResultOnuUpgradeOption)
        .getValue();
  }

  public void setOnuUpgradeTaskandResultOnuUpgradeOption(
      Integer aOnuUpgradeTaskandResultOnuUpgradeOption) {
    getProperty(onuUpgradeTaskandResultOnuUpgradeOption).setValue(
        aOnuUpgradeTaskandResultOnuUpgradeOption);
  }

  public Integer getOnuUpgradeTaskStatus() {
    return (Integer) getProperty(onuUpgradeTaskStatus).getValue();
  }

  public void setOnuUpgradeTaskStatus(Integer aOnuUpgradeTaskStatus) {
    getProperty(onuUpgradeTaskStatus).setValue(aOnuUpgradeTaskStatus);
  }

  public Integer getOnuUpgradeImageInstance() {
    return (Integer) getProperty(onuUpgradeImageInstance).getValue();
  }

  public void setOnuUpgradeImageInstance(Integer aOnuUpgradeImageInstance) {
    getProperty(onuUpgradeImageInstance).setValue(aOnuUpgradeImageInstance);
  }

  public Integer getOnuUpgradeRebootMode() {
    return (Integer) getProperty(onuUpgradeRebootMode).getValue();
  }

  public void setOnuUpgradeRebootMode(Integer aOnuUpgradeRebootMode) {
    getProperty(onuUpgradeRebootMode).setValue(aOnuUpgradeRebootMode);
  }

  public String getOnuUpgradeScheduledTime() {
    return (String) getProperty(onuUpgradeScheduledTime).getValue();
  }

  public void setOnuUpgradeScheduledTime(String aOnuUpgradeScheduledTime) {
    getProperty(onuUpgradeScheduledTime).setValue(aOnuUpgradeScheduledTime);
  }

  public String getOnuUpgradeRebooScheduledTime() {
    return (String) getProperty(onuUpgradeRebooScheduledTime).getValue();
  }

  public void setOnuUpgradeRebooScheduledTime(
      String aOnuUpgradeRebooScheduledTime) {
    getProperty(onuUpgradeRebooScheduledTime).setValue(
        aOnuUpgradeRebooScheduledTime);
  }

  public byte[] getOnuUpgradeParticipantPortListBitMap() {
    return (byte[]) getProperty(onuUpgradeParticipantPortListBitMap).getValue();
  }

  public void setOnuUpgradeParticipantPortListBitMap(
      byte[] aOnuUpgradeParticipantPortListBitMap) {
    getProperty(onuUpgradeParticipantPortListBitMap).setValue(
        aOnuUpgradeParticipantPortListBitMap);
  }

  public byte[] getOnuUpgradeImageInstancePortListBitMap() {
    return (byte[]) getProperty(onuUpgradeImageInstancePortListBitMap)
        .getValue();
  }

  public void setOnuUpgradeImageInstancePortListBitMap(
      byte[] aOnuUpgradeImageInstancePortListBitMap) {
    getProperty(onuUpgradeImageInstancePortListBitMap).setValue(
        aOnuUpgradeImageInstancePortListBitMap);
  }

  public byte[] getOnuUpgradeProgressDownloadPortListBitMap() {
    return (byte[]) getProperty(onuUpgradeProgressDownloadPortListBitMap)
        .getValue();
  }

  public void setOnuUpgradeProgressDownloadPortListBitMap(
      byte[] aOnuUpgradeProgressDownloadPortListBitMap) {
    getProperty(onuUpgradeProgressDownloadPortListBitMap).setValue(
        aOnuUpgradeProgressDownloadPortListBitMap);
  }

  public byte[] getOnuUpgradeProgressActivatePortListBitMap() {
    return (byte[]) getProperty(onuUpgradeProgressActivatePortListBitMap)
        .getValue();
  }

  public void setOnuUpgradeProgressActivatePortListBitMap(
      byte[] aOnuUpgradeProgressActivatePortListBitMap) {
    getProperty(onuUpgradeProgressActivatePortListBitMap).setValue(
        aOnuUpgradeProgressActivatePortListBitMap);
  }

  public byte[] getOnuUpgradeProgressCommitPortListBitMap() {
    return (byte[]) getProperty(onuUpgradeProgressCommitPortListBitMap)
        .getValue();
  }

  public void setOnuUpgradeProgressCommitPortListBitMap(
      byte[] aOnuUpgradeProgressCommitPortListBitMap) {
    getProperty(onuUpgradeProgressCommitPortListBitMap).setValue(
        aOnuUpgradeProgressCommitPortListBitMap);
  }

  public byte[] getOnuUpgradeProgressFinalPortListBitMap() {
    return (byte[]) getProperty(onuUpgradeProgressFinalPortListBitMap)
        .getValue();
  }

  public void setOnuUpgradeProgressFinalPortListBitMap(
      byte[] aOnuUpgradeProgressFinalPortListBitMap) {
    getProperty(onuUpgradeProgressFinalPortListBitMap).setValue(
        aOnuUpgradeProgressFinalPortListBitMap);
  }

  public byte[] getOnuUpgradeResultPortListBitMap() {
    return (byte[]) getProperty(onuUpgradeResultPortListBitMap).getValue();
  }

  public void setOnuUpgradeResultPortListBitMap(
      byte[] aOnuUpgradeResultPortListBitMap) {
    getProperty(onuUpgradeResultPortListBitMap).setValue(
        aOnuUpgradeResultPortListBitMap);
  }

  public String getOnuUpgradeResult() {
    return onuUpgradeResult;
  }

  public void setOnuUpgradeResult(String result) {
    onuUpgradeResult = result;
  }
  
  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(onuUpgradeTaskandResultOnuUpgradeOption));
    prepareRead(super.getProperty(onuUpgradeTaskStatus));
    prepareRead(super.getProperty(onuUpgradeImageInstance));
    prepareRead(super.getProperty(onuUpgradeRebootMode));
    prepareRead(super.getProperty(onuUpgradeScheduledTime));
    prepareRead(super.getProperty(onuUpgradeRebooScheduledTime));
    prepareRead(super.getProperty(onuUpgradeParticipantPortListBitMap));
    load();
    prepareRead(super.getProperty(onuUpgradeImageInstancePortListBitMap));
    prepareRead(super.getProperty(onuUpgradeProgressDownloadPortListBitMap));
    load();
    prepareRead(super.getProperty(onuUpgradeProgressActivatePortListBitMap));
    prepareRead(super.getProperty(onuUpgradeProgressCommitPortListBitMap));
    load();
    prepareRead(super.getProperty(onuUpgradeProgressFinalPortListBitMap));
    prepareRead(super.getProperty(onuUpgradeResultPortListBitMap));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(onuUpgradeTaskandResultOnuUpgradeOption));
    prepareRead(super.getProperty(onuUpgradeTaskStatus));
    prepareRead(super.getProperty(onuUpgradeImageInstance));
    prepareRead(super.getProperty(onuUpgradeRebootMode));
    prepareRead(super.getProperty(onuUpgradeScheduledTime));
    prepareRead(super.getProperty(onuUpgradeRebooScheduledTime));
    prepareRead(super.getProperty(onuUpgradeParticipantPortListBitMap));
    prepareRead(super.getProperty(onuUpgradeImageInstancePortListBitMap));

    Vector v = loadAll(new int[] { 2,1, 1 });

    for(int i = 0; i < v.size(); i++) {
      OnuUpgradeTandRTable mbean = (OnuUpgradeTandRTable)v.get(i);

      mbean.prepareRead(super.getProperty(onuUpgradeProgressDownloadPortListBitMap));
      mbean.prepareRead(super.getProperty(onuUpgradeProgressActivatePortListBitMap));
      mbean.load();
      mbean.prepareRead(super.getProperty(onuUpgradeProgressCommitPortListBitMap));
      mbean.prepareRead(super.getProperty(onuUpgradeProgressFinalPortListBitMap));
      mbean.load();
      mbean.prepareRead(super.getProperty(onuUpgradeResultPortListBitMap));
      mbean.load();
    }

    return v;
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(onuUpgradeTaskandResultOnuUpgradeOption));
    prepareSave(getProperty(onuUpgradeImageInstance));
    prepareSave(getProperty(onuUpgradeRebootMode));
    prepareSave(getProperty(onuUpgradeScheduledTime));
    prepareSave(getProperty(onuUpgradeRebooScheduledTime));
    prepareSave(getProperty(onuUpgradeParticipantPortListBitMap));

    return save();
  }

  public boolean add() throws MibBeanException {
    prepareSave(getProperty(onuUpgradeTaskandResultOnuUpgradeOption));
    prepareSave(getProperty(onuUpgradeImageInstance));
    prepareSave(getProperty(onuUpgradeRebootMode));
    prepareSave(getProperty(onuUpgradeScheduledTime));
    prepareSave(getProperty(onuUpgradeRebooScheduledTime));
    prepareSave(getProperty(onuUpgradeParticipantPortListBitMap));
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }
}

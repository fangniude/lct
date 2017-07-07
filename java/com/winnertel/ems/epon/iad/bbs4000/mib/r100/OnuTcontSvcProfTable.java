package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuTcontSvcProfTable class.
 * Created by QuickDVM
 */
public class OnuTcontSvcProfTable extends SnmpMibBean {
  public static final String onuTcontServiceProfileIndex = "onuTcontServiceProfileIndex";
  public static final String onuTcontSvcProfileName = "onuTcontSvcProfileName";
  public static final String upstreamBandwidthProfileIndex = "upstreamBandwidthProfileIndex";
  public static final String upstreamQueuingSchedulingType = "upstreamQueuingSchedulingType";
  public static final String dbruMode = "dbruMode";

  public OnuTcontSvcProfTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(onuTcontServiceProfileIndex, new SnmpMibBeanProperty(
        onuTcontServiceProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.2.2.1.1",
        ISnmpConstant.GAUGE));
    initProperty(onuTcontSvcProfileName, new SnmpMibBeanProperty(
        onuTcontSvcProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.2.1.2",
        ISnmpConstant.STRING));
    initProperty(upstreamBandwidthProfileIndex, new SnmpMibBeanProperty(
        upstreamBandwidthProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.2.2.1.3",
        ISnmpConstant.GAUGE));
    initProperty(upstreamQueuingSchedulingType, new SnmpMibBeanProperty(
        upstreamQueuingSchedulingType, ".1.3.6.1.4.1.41355.1.3.10.5.2.2.1.4",
        ISnmpConstant.INTEGER));
    initProperty(dbruMode, new SnmpMibBeanProperty(
            dbruMode, ".1.3.6.1.4.1.41355.1.3.10.5.2.2.1.5",
            ISnmpConstant.GAUGE));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
            ".1.3.6.1.4.1.41355.1.3.10.5.2.2.1.100", ISnmpConstant.INTEGER));
  }

  public Long getOnuTcontServiceProfileIndex() {
    return (Long) getIndex(0);
  }

  public void setOnuTcontServiceProfileIndex(
      Long aOnuTcontServiceProfileIndex) {
    setIndex(0, aOnuTcontServiceProfileIndex);
  }

  public String getOnuTcontSvcProfileName() {
    return (String) getProperty(onuTcontSvcProfileName).getValue();
  }

  public void setOnuTcontSvcProfileName(String aOnuTcontSvcProfileName) {
    getProperty(onuTcontSvcProfileName).setValue(aOnuTcontSvcProfileName);
  }

  public Long getUpstreamBandwidthProfileIndex() {
    return (Long) getProperty(upstreamBandwidthProfileIndex).getValue();
  }

  public void setUpstreamBandwidthProfileIndex(
      Long aUpstreamBandwidthProfileIndex) {
    getProperty(upstreamBandwidthProfileIndex).setValue(
        aUpstreamBandwidthProfileIndex);
  }

  public Integer getUpstreamQueuingSchedulingType() {
    return (Integer) getProperty(upstreamQueuingSchedulingType).getValue();
  }

  public void setUpstreamQueuingSchedulingType(
      Integer aUpstreamQueuingSchedulingType) {
    getProperty(upstreamQueuingSchedulingType).setValue(
        aUpstreamQueuingSchedulingType);
  }
  
  public Long getDbruMode() {
      return (Long) getProperty(dbruMode).getValue();
    }

    public void setDbruMode(Long aDbruMode) {
      getProperty(dbruMode).setValue(
              aDbruMode);
    }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(onuTcontSvcProfileName));
    prepareRead(super.getProperty(upstreamBandwidthProfileIndex));
    prepareRead(super.getProperty(upstreamQueuingSchedulingType));
    prepareRead(super.getProperty(dbruMode));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(onuTcontSvcProfileName));
    prepareRead(super.getProperty(upstreamBandwidthProfileIndex));
    prepareRead(super.getProperty(upstreamQueuingSchedulingType));
    prepareRead(super.getProperty(dbruMode));
    return loadAll(new int[] { 2 });
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(onuTcontSvcProfileName));
    prepareSave(getProperty(upstreamBandwidthProfileIndex));
    prepareSave(getProperty(upstreamQueuingSchedulingType));
    prepareSave(getProperty(dbruMode));
    return save();
  }

  public boolean add() throws MibBeanException {
    prepareSave(getProperty(onuTcontSvcProfileName));
    prepareSave(getProperty(upstreamBandwidthProfileIndex));
    prepareSave(getProperty(upstreamQueuingSchedulingType));
    prepareSave(getProperty(dbruMode));
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
      return getOnuTcontSvcProfileName();
  }

}

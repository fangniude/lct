package com.winnertel.ems.epon.iad.bbs4000.mib;

/*
* Copyright (c) 2002-2005 UTStarcom, Inc.
* All rights reserved.
*/

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The PonLedTableBean class.
 * Created by QuickDVM
 */
public class CsmLedGroupBean extends SnmpMibBean
{
  public static final String utsBBSLEDCSMAPowerLedState= "utsBBSLEDCSMAPowerLedState";
  public static final String utsBBSLEDCSMAActiveLedState = "utsBBSLEDCSMAActiveLedState";
  public static final String utsBBSLEDCSMARunLedState = "utsBBSLEDCSMARunLedState";
  public static final String utsBBSLEDCSMACriticalAlarmLedState = "utsBBSLEDCSMACriticalAlarmLedState";
  public static final String utsBBSLEDCSMAMajorAlarmLedState = "utsBBSLEDCSMAMajorAlarmLedState";
  public static final String utsBBSLEDCSMAMinorAlarmLedState = "utsBBSLEDCSMAMinorAlarmLedState";
  public static final String utsBBSLEDCSMAHotSwapLedState = "utsBBSLEDCSMAHotSwapLedState";
  public static final String utsBBSLEDCSMAEmsPortLinkLedState = "utsBBSLEDCSMAEmsPortLinkLedState";
  public static final String utsBBSLEDCSMAEmsPortSpeedLedState = "utsBBSLEDCSMAEmsPortSpeedLedState";
  public static final String utsBBSLEDCSMBPowerLedState = "utsBBSLEDCSMBPowerLedState";
  public static final String utsBBSLEDCSMBActiveLedState = "utsBBSLEDCSMBActiveLedState";
  public static final String utsBBSLEDCSMBRunLedState = "utsBBSLEDCSMBRunLedState";
  public static final String utsBBSLEDCSMBCriticalAlarmLedState = "utsBBSLEDCSMBCriticalAlarmLedState";
  public static final String utsBBSLEDCSMBMajorAlarmLedState = "utsBBSLEDCSMBMajorAlarmLedState";
  public static final String utsBBSLEDCSMBMinorAlarmLedState = "utsBBSLEDCSMBMinorAlarmLedState";
  public static final String utsBBSLEDCSMBHotSwapLedState = "utsBBSLEDCSMBHotSwapLedState";
  public static final String utsBBSLEDCSMBEmsPortLinkLedState = "utsBBSLEDCSMBEmsPortLinkLedState";
  public static final String utsBBSLEDCSMBEmsPortSpeedLedState = "utsBBSLEDCSMBEmsPortSpeedLedState";

  private String fTableOid = ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.6.1";

  public CsmLedGroupBean(ISnmpProxy aSnmpProxy)
  {
    super(aSnmpProxy);
    init();
  }

  protected void init()
  {
    initProperty(utsBBSLEDCSMAPowerLedState, new SnmpMibBeanProperty(utsBBSLEDCSMAPowerLedState, fTableOid + ".1", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMAActiveLedState, new SnmpMibBeanProperty(utsBBSLEDCSMAActiveLedState, fTableOid + ".2", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMARunLedState, new SnmpMibBeanProperty(utsBBSLEDCSMARunLedState, fTableOid + ".3", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMACriticalAlarmLedState, new SnmpMibBeanProperty(utsBBSLEDCSMACriticalAlarmLedState, fTableOid + ".4", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMAMajorAlarmLedState, new SnmpMibBeanProperty(utsBBSLEDCSMAMajorAlarmLedState, fTableOid + ".5", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMAMinorAlarmLedState, new SnmpMibBeanProperty(utsBBSLEDCSMAMinorAlarmLedState, fTableOid + ".6", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMAHotSwapLedState, new SnmpMibBeanProperty(utsBBSLEDCSMAHotSwapLedState, fTableOid + ".7", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMAEmsPortLinkLedState, new SnmpMibBeanProperty(utsBBSLEDCSMAEmsPortLinkLedState, fTableOid + ".8", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMAEmsPortSpeedLedState, new SnmpMibBeanProperty(utsBBSLEDCSMAEmsPortSpeedLedState, fTableOid + ".9", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBPowerLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBPowerLedState, fTableOid + ".10", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBActiveLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBActiveLedState, fTableOid + ".11", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBRunLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBRunLedState, fTableOid + ".12", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBCriticalAlarmLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBCriticalAlarmLedState, fTableOid + ".13", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBMajorAlarmLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBMajorAlarmLedState, fTableOid + ".14", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBMinorAlarmLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBMinorAlarmLedState, fTableOid + ".15", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBHotSwapLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBHotSwapLedState, fTableOid + ".16", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBEmsPortLinkLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBEmsPortLinkLedState, fTableOid + ".17", ISnmpConstant.INTEGER));
    initProperty(utsBBSLEDCSMBEmsPortSpeedLedState, new SnmpMibBeanProperty(utsBBSLEDCSMBEmsPortSpeedLedState, fTableOid + ".18", ISnmpConstant.INTEGER));
  }

  public Integer getUtsBBSLEDCSMAPowerLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMAPowerLedState).getValue();
  }

  public void setUtsBBSLEDCSMAPowerLedState(Integer autsBBSLEDCSMAPowerLedState)
  {
    getProperty(utsBBSLEDCSMAPowerLedState).setValue(autsBBSLEDCSMAPowerLedState);
  }

  public Integer getUtsBBSLEDCSMAActiveLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMAActiveLedState).getValue();
  }

  public void setUtsBBSLEDCSMAActiveLedState(Integer autsBBSLEDCSMAActiveLedState)
  {
    getProperty(utsBBSLEDCSMAActiveLedState).setValue(autsBBSLEDCSMAActiveLedState);
  }

  public Integer getUtsBBSLEDCSMARunLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMARunLedState).getValue();
  }

  public void setUtsBBSLEDCSMARunLedState(Integer autsBBSLEDCSMARunLedState)
  {
    getProperty(utsBBSLEDCSMARunLedState).setValue(autsBBSLEDCSMARunLedState);
  }

  public Integer getUtsBBSLEDCSMACriticalAlarmLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMACriticalAlarmLedState).getValue();
  }

  public void setUtsBBSLEDCSMACriticalAlarmLedState(Integer autsBBSLEDCSMACriticalAlarmLedState)
  {
    getProperty(utsBBSLEDCSMACriticalAlarmLedState).setValue(autsBBSLEDCSMACriticalAlarmLedState);
  }

  public Integer getUtsBBSLEDCSMAMajorAlarmLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMAMajorAlarmLedState).getValue();
  }

  public void setUtsBBSLEDCSMAMajorAlarmLedState(Integer autsBBSLEDCSMAMajorAlarmLedState)
  {
    getProperty(utsBBSLEDCSMAMajorAlarmLedState).setValue(autsBBSLEDCSMAMajorAlarmLedState);
  }

  public Integer getUtsBBSLEDCSMAMinorAlarmLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMAMinorAlarmLedState).getValue();
  }

  public void setUtsBBSLEDCSMAMinorAlarmLedState(Integer autsBBSLEDCSMAMinorAlarmLedState)
  {
    getProperty(utsBBSLEDCSMAMinorAlarmLedState).setValue(autsBBSLEDCSMAMinorAlarmLedState);
  }

  public Integer getUtsBBSLEDCSMAHotSwapLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMAHotSwapLedState).getValue();
  }

  public void setUtsBBSLEDCSMAHotSwapLedState(Integer autsBBSLEDCSMAHotSwapLedState)
  {
    getProperty(utsBBSLEDCSMAHotSwapLedState).setValue(autsBBSLEDCSMAHotSwapLedState);
  }

  public Integer getUtsBBSLEDCSMAEmsPortLinkLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMAEmsPortLinkLedState).getValue();
  }

  public void setUtsBBSLEDCSMAEmsPortLinkLedState(Integer autsBBSLEDCSMAEmsPortLinkLedState)
  {
    getProperty(utsBBSLEDCSMAEmsPortLinkLedState).setValue(autsBBSLEDCSMAEmsPortLinkLedState);
  }

  public Integer getUtsBBSLEDCSMAEmsPortSpeedLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMAEmsPortSpeedLedState).getValue();
  }

  public void setUtsBBSLEDCSMAEmsPortSpeedLedState(Integer autsBBSLEDCSMAEmsPortSpeedLedState)
  {
    getProperty(utsBBSLEDCSMAEmsPortSpeedLedState).setValue(autsBBSLEDCSMAEmsPortSpeedLedState);
  }

  public Integer getUtsBBSLEDCSMBPowerLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMBPowerLedState).getValue();
  }

  public void setUtsBBSLEDCSMBPowerLedState(Integer autsBBSLEDCSMBPowerLedState)
  {
    getProperty(utsBBSLEDCSMBPowerLedState).setValue(autsBBSLEDCSMBPowerLedState);
  }

  public Integer getUtsBBSLEDCSMBActiveLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMBActiveLedState).getValue();
  }

  public void setUtsBBSLEDCSMBActiveLedState(Integer autsBBSLEDCSMBActiveLedState)
  {
    getProperty(utsBBSLEDCSMBActiveLedState).setValue(autsBBSLEDCSMBActiveLedState);
  }

  public Integer getUtsBBSLEDCSMBRunLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMBRunLedState).getValue();
  }

  public void setUtsBBSLEDCSMBRunLedState(Integer autsBBSLEDCSMBRunLedState)
  {
    getProperty(utsBBSLEDCSMBRunLedState).setValue(autsBBSLEDCSMBRunLedState);
  }

  public Integer getUtsBBSLEDCSMBCriticalAlarmLedState() {
      return (Integer)getProperty(utsBBSLEDCSMBCriticalAlarmLedState).getValue();
  }

  public void setUtsBBSLEDCSMBCriticalAlarmLedState(Integer aUtsBBSLEDCSMBCriticalAlarmLedState) {
      getProperty(utsBBSLEDCSMBCriticalAlarmLedState).setValue(aUtsBBSLEDCSMBCriticalAlarmLedState);
  }

  public Integer getUtsBBSLEDCSMBMajorAlarmLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMBMajorAlarmLedState).getValue();
  }

  public void setUtsBBSLEDCSMBMajorAlarmLedState(Integer autsBBSLEDCSMBMajorAlarmLedState)
  {
    getProperty(utsBBSLEDCSMBMajorAlarmLedState).setValue(autsBBSLEDCSMBMajorAlarmLedState);
  }

  public Integer getUtsBBSLEDCSMBMinorAlarmLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMBMinorAlarmLedState).getValue();
  }

  public void setUtsBBSLEDCSMBMinorAlarmLedState(Integer autsBBSLEDCSMBMinorAlarmLedState)
  {
    getProperty(utsBBSLEDCSMBMinorAlarmLedState).setValue(autsBBSLEDCSMBMinorAlarmLedState);
  }

  public Integer getUtsBBSLEDCSMBHotSwapLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMBHotSwapLedState).getValue();
  }

  public void setUtsBBSLEDCSMBHotSwapLedState(Integer autsBBSLEDCSMBHotSwapLedState)
  {
    getProperty(utsBBSLEDCSMBHotSwapLedState).setValue(autsBBSLEDCSMBHotSwapLedState);
  }

  public Integer getUtsBBSLEDCSMBEmsPortLinkLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMBEmsPortLinkLedState).getValue();
  }

  public void setUtsBBSLEDCSMBEmsPortLinkLedState(Integer autsBBSLEDCSMBEmsPortLinkLedState)
  {
    getProperty(utsBBSLEDCSMBEmsPortLinkLedState).setValue(autsBBSLEDCSMBEmsPortLinkLedState);
  }

  public Integer getUtsBBSLEDCSMBEmsPortSpeedLedState()
  {
    return (Integer)getProperty(utsBBSLEDCSMBEmsPortSpeedLedState).getValue();
  }

  public void setUtsBBSLEDCSMBEmsPortSpeedLedState(Integer autsBBSLEDCSMBEmsPortSpeedLedState)
  {
    getProperty(utsBBSLEDCSMBEmsPortSpeedLedState).setValue(autsBBSLEDCSMBEmsPortSpeedLedState);
  }

  public boolean retrieve() throws MibBeanException
  {
    prepareRead(super.getProperty(utsBBSLEDCSMAPowerLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAActiveLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMARunLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMACriticalAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAMajorAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAMinorAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAHotSwapLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAEmsPortLinkLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAEmsPortSpeedLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBPowerLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBActiveLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBRunLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBCriticalAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBMajorAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBMinorAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBHotSwapLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBEmsPortLinkLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBEmsPortSpeedLedState));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException
  {
    prepareRead(super.getProperty(utsBBSLEDCSMAPowerLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAActiveLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMARunLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMACriticalAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAMajorAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAMinorAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAHotSwapLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAEmsPortLinkLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMAEmsPortSpeedLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBPowerLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBActiveLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBRunLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBCriticalAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBMajorAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBMinorAlarmLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBHotSwapLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBEmsPortLinkLedState));
    prepareRead(super.getProperty(utsBBSLEDCSMBEmsPortSpeedLedState));

    return loadAll(new int[]{ 1 });
  }


}

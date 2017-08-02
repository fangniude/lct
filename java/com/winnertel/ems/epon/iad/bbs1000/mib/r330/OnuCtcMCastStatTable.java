package com.winnertel.ems.epon.iad.bbs1000.mib.r330;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

import java.util.Vector;

public class OnuCtcMCastStatTable extends SnmpMibBean {
  public static final String utsDot3OnuMCastStatMGroup = "utsDot3OnuMCastStatMGroup";
  public static final String utsDot3OnuMCastStatUserNum = "utsDot3OnuMCastStatUserNum";
  public static final String utsDot3OnuMCastStatRequestNum = "utsDot3OnuMCastStatRequestNum";
  public static final String utsDot3OnuMCastStatReqRejNum = "utsDot3OnuMCastStatReqRejNum";
  public static final String utsDot3OnuMCastStatTotalTime = "utsDot3OnuMCastStatTotalTime";
  public static final String utsDot3OnuMCastStatAverageTime = "utsDot3OnuMCastStatAverageTime";

  public OnuCtcMCastStatTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuMCastStatMGroup, new SnmpMibBeanProperty(utsDot3OnuMCastStatMGroup, ".1.3.6.1.4.1.45121.1800.2.4.3.1.7.1.2", ISnmpConstant.IP_ADDRESS));
    initProperty(utsDot3OnuMCastStatUserNum, new SnmpMibBeanProperty(utsDot3OnuMCastStatUserNum, ".1.3.6.1.4.1.45121.1800.2.4.3.1.7.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastStatRequestNum, new SnmpMibBeanProperty(utsDot3OnuMCastStatRequestNum, ".1.3.6.1.4.1.45121.1800.2.4.3.1.7.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastStatReqRejNum, new SnmpMibBeanProperty(utsDot3OnuMCastStatReqRejNum, ".1.3.6.1.4.1.45121.1800.2.4.3.1.7.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastStatTotalTime, new SnmpMibBeanProperty(utsDot3OnuMCastStatTotalTime, ".1.3.6.1.4.1.45121.1800.2.4.3.1.7.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastStatAverageTime, new SnmpMibBeanProperty(utsDot3OnuMCastStatAverageTime, ".1.3.6.1.4.1.45121.1800.2.4.3.1.7.1.8", ISnmpConstant.INTEGER));
  }


  public String getUtsDot3OnuMCastStatMGroup() {
    return (String) getIndex(0);
  }

  public void setUtsDot3OnuMCastStatMGroup(String aUtsDot3OnuMCastStatMGroup) {
    setIndex(0, aUtsDot3OnuMCastStatMGroup);
  }


  public Integer getUtsDot3OnuMCastStatUserNum() {
    return (Integer) getProperty(utsDot3OnuMCastStatUserNum).getValue();
  }

  public void setUtsDot3OnuMCastStatUserNum(Integer aUtsDot3OnuMCastStatUserNum) {
    getProperty(utsDot3OnuMCastStatUserNum).setValue(aUtsDot3OnuMCastStatUserNum);
  }

  public Integer getUtsDot3OnuMCastStatRequestNum() {
    return (Integer) getProperty(utsDot3OnuMCastStatRequestNum).getValue();
  }

  public void setUtsDot3OnuMCastStatRequestNum(Integer aUtsDot3OnuMCastStatRequestNum) {
    getProperty(utsDot3OnuMCastStatRequestNum).setValue(aUtsDot3OnuMCastStatRequestNum);
  }

  public Integer getUtsDot3OnuMCastStatReqRejNum() {
    return (Integer) getProperty(utsDot3OnuMCastStatReqRejNum).getValue();
  }

  public void setUtsDot3OnuMCastStatReqRejNum(Integer aUtsDot3OnuMCastStatReqRejNum) {
    getProperty(utsDot3OnuMCastStatReqRejNum).setValue(aUtsDot3OnuMCastStatReqRejNum);
  }

  public Integer getUtsDot3OnuMCastStatTotalTime() {
    return (Integer)getProperty(utsDot3OnuMCastStatTotalTime).getValue();
  }

  public void setUtsDot3OnuMCastStatTotalTime(Integer aUtsDot3OnuMCastStatTotalTime) {
    getProperty(utsDot3OnuMCastStatTotalTime).setValue(aUtsDot3OnuMCastStatTotalTime);
  }

  public Integer getUtsDot3OnuMCastStatAverageTime() {
    return (Integer)getProperty(utsDot3OnuMCastStatAverageTime).getValue();
  }

  public void setUtsDot3OnuMCastStatAverageTime(Integer aUtsDot3OnuMCastStatAverageTime) {
    getProperty(utsDot3OnuMCastStatAverageTime).setValue(aUtsDot3OnuMCastStatAverageTime);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuMCastStatUserNum));
    prepareRead(super.getProperty(utsDot3OnuMCastStatRequestNum));
    prepareRead(super.getProperty(utsDot3OnuMCastStatReqRejNum));
    prepareRead(super.getProperty(utsDot3OnuMCastStatTotalTime));
    prepareRead(super.getProperty(utsDot3OnuMCastStatAverageTime));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuMCastStatUserNum));
    prepareRead(super.getProperty(utsDot3OnuMCastStatRequestNum));
    prepareRead(super.getProperty(utsDot3OnuMCastStatReqRejNum));
    prepareRead(super.getProperty(utsDot3OnuMCastStatTotalTime));
    prepareRead(super.getProperty(utsDot3OnuMCastStatAverageTime));

    return loadAll(new int[]{4
    });
  }
}

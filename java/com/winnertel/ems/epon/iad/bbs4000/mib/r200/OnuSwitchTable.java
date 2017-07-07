package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuSwitchTable extends SnmpMibBean {
  public static final String utsDot3OnuSwitchIpAddress = "utsDot3OnuSwitchIpAddress";

  public OnuSwitchTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuSwitchIpAddress, new SnmpMibBeanProperty(utsDot3OnuSwitchIpAddress, ".1.3.6.1.4.1.41355.1800.2.3.1.2.3.1.1.5", ISnmpConstant.IP_ADDRESS));
  }

  public Integer getUtsDot3OnuSwitchModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuSwitchModuleId(Integer autsDot3Onu2CtcModuleId) {
    setIndex(0, autsDot3Onu2CtcModuleId);
  }

  public Integer getUtsDot3OnuSwitchPortId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OnuSwitchPortId(Integer autsDot3OnuSwitchPortId) {
    setIndex(1, autsDot3OnuSwitchPortId);
  }


  public Integer getUtsDot3OnuSwitchLogicalPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OnuSwitchLogicalPortId(Integer autsDot3OnuSwitchLogicalPortId) {
    setIndex(2, autsDot3OnuSwitchLogicalPortId);
  }

  public String getUtsDot3OnuSwitchIpAddress() {
    return (String) getProperty(utsDot3OnuSwitchIpAddress).getValue();
  }

  public void setUtsDot3OnuSwitchIpAddress(String aUtsDot3OnuSwitchIpAddress) {
    getProperty(utsDot3OnuSwitchIpAddress).setValue(aUtsDot3OnuSwitchIpAddress);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuSwitchIpAddress));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuSwitchIpAddress));

    return loadAll(new int[]{1
                             , 1
                             , 1
    });
  }
}

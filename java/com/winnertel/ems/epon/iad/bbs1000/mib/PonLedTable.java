package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

import java.util.Vector;

public class PonLedTable extends SnmpMibBean {
  public static final String utsLedPonSlotLedDispSlotId = "utsLedPonSlotLedDispSlotId";
  public static final String utsLedPonSlotLedDispPowLedStat = "utsLedPonSlotLedDispPowLedStat";
  public static final String utsLedPonSlotLedDispFaultLedStat = "utsLedPonSlotLedDispFaultLedStat";
  public static final String utsLedPonSlotLedDispSwapLedStat = "utsLedPonSlotLedDispSwapLedStat";
  public static final String utsLedPonSlotLedDispPonPort1LedStat = "utsLedPonSlotLedDispPonPort1LedStat";
  public static final String utsLedPonSlotLedDispPonPort2LedStat = "utsLedPonSlotLedDispPonPort2LedStat";
  public static final String utsLedPonSlotLedDispPonPort3LedStat = "utsLedPonSlotLedDispPonPort3LedStat";
  public static final String utsLedPonSlotLedDispPonPort4LedStat = "utsLedPonSlotLedDispPonPort4LedStat";

  public PonLedTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsLedPonSlotLedDispSlotId, new SnmpMibBeanProperty(utsLedPonSlotLedDispSlotId, ".1.3.6.1.4.1.41355.1800.2.1.1.4.6.2.1.1.1", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPowLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPowLedStat, ".1.3.6.1.4.1.41355.1800.2.1.1.4.6.2.1.1.2", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispFaultLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispFaultLedStat, ".1.3.6.1.4.1.41355.1800.2.1.1.4.6.2.1.1.3", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispSwapLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispSwapLedStat, ".1.3.6.1.4.1.41355.1800.2.1.1.4.6.2.1.1.4", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort1LedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort1LedStat, ".1.3.6.1.4.1.41355.1800.2.1.1.4.6.2.1.1.5", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort2LedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort2LedStat, ".1.3.6.1.4.1.41355.1800.2.1.1.4.6.2.1.1.6", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort3LedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort3LedStat, ".1.3.6.1.4.1.41355.1800.2.1.1.4.6.2.1.1.7", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort4LedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort4LedStat, ".1.3.6.1.4.1.41355.1800.2.1.1.4.6.2.1.1.8", ISnmpConstant.INTEGER));
  }

  public Integer getUtsLedPonSlotLedDispSlotId() {
    return (Integer) getIndex(0);
  }

  public void setUtsLedPonSlotLedDispSlotId(Integer aUtsLedPonSlotLedDispSlotId) {
    setIndex(0, aUtsLedPonSlotLedDispSlotId);
  }

  public Integer getUtsLedPonSlotLedDispPowLedStat() {
    return (Integer) getProperty(utsLedPonSlotLedDispPowLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPowLedStat(Integer aUtsLedPonSlotLedDispPowLedStat) {
    getProperty(utsLedPonSlotLedDispPowLedStat).setValue(aUtsLedPonSlotLedDispPowLedStat);
  }

  public Integer getUtsLedPonSlotLedDispFaultLedStat() {
    return (Integer) getProperty(utsLedPonSlotLedDispFaultLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispFaultLedStat(Integer aUtsLedPonSlotLedDispFaultLedStat) {
    getProperty(utsLedPonSlotLedDispFaultLedStat).setValue(aUtsLedPonSlotLedDispFaultLedStat);
  }

  public Integer getUtsLedPonSlotLedDispSwapLedStat() {
    return (Integer) getProperty(utsLedPonSlotLedDispSwapLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispSwapLedStat(Integer aUtsLedPonSlotLedDispSwapLedStat) {
    getProperty(utsLedPonSlotLedDispSwapLedStat).setValue(aUtsLedPonSlotLedDispSwapLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort1LedStat() {
    return (Integer) getProperty(utsLedPonSlotLedDispPonPort1LedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort1LedStat(Integer aUtsLedPonSlotLedDispPonPort1LedStat) {
    getProperty(utsLedPonSlotLedDispPonPort1LedStat).setValue(aUtsLedPonSlotLedDispPonPort1LedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort2LedStat() {
    return (Integer) getProperty(utsLedPonSlotLedDispPonPort2LedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort2LedStat(Integer aUtsLedPonSlotLedDispPonPort2LedStat) {
    getProperty(utsLedPonSlotLedDispPonPort2LedStat).setValue(aUtsLedPonSlotLedDispPonPort2LedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort3LedStat() {
    return (Integer) getProperty(utsLedPonSlotLedDispPonPort3LedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort3LedStat(Integer aUtsLedPonSlotLedDispPonPort3LedStat) {
    getProperty(utsLedPonSlotLedDispPonPort3LedStat).setValue(aUtsLedPonSlotLedDispPonPort3LedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort4LedStat() {
    return (Integer) getProperty(utsLedPonSlotLedDispPonPort4LedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort4LedStat(Integer aUtsLedPonSlotLedDispPonPort4LedStat) {
    getProperty(utsLedPonSlotLedDispPonPort4LedStat).setValue(aUtsLedPonSlotLedDispPonPort4LedStat);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsLedPonSlotLedDispPowLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispFaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispSwapLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort1LedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort2LedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort3LedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort4LedStat));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsLedPonSlotLedDispPowLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispFaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispSwapLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort1LedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort2LedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort3LedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort4LedStat));

    return loadAll(new int[]{1});
  }
}
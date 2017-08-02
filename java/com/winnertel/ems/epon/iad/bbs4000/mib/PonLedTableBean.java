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
public class PonLedTableBean extends SnmpMibBean
{
  public static final String utsLedPonSlotLedDispSlotId = "utsLedPonSlotLedDispSlotId";
  public static final String utsLedPonSlotLedDispPowLedStat = "utsLedPonSlotLedDispPowLedStat";
  public static final String utsLedPonSlotLedDispRunLedStat = "utsLedPonSlotLedDispRunLedStat";
  public static final String utsLedPonSlotLedDispFaultLedStat = "utsLedPonSlotLedDispFaultLedStat";
  public static final String utsLedPonSlotLedDispSwapLedStat = "utsLedPonSlotLedDispSwapLedStat";
  public static final String utsLedPonSlotLedDispPonPort1OprLedStat = "utsLedPonSlotLedDispPonPort1OprLedStat";
  public static final String utsLedPonSlotLedDispPonPort1FaultLedStat = "utsLedPonSlotLedDispPonPort1FaultLedStat";
  public static final String utsLedPonSlotLedDispPonPort2OprLedStat = "utsLedPonSlotLedDispPonPort2OprLedStat";
  public static final String utsLedPonSlotLedDispPonPort2FaultLedStat = "utsLedPonSlotLedDispPonPort2FaultLedStat";
  public static final String utsLedPonSlotLedDispPonPort3OprLedStat = "utsLedPonSlotLedDispPonPort3OprLedStat";
  public static final String utsLedPonSlotLedDispPonPort3FaultLedStat = "utsLedPonSlotLedDispPonPort3FaultLedStat";
  public static final String utsLedPonSlotLedDispPonPort4OprLedStat = "utsLedPonSlotLedDispPonPort4OprLedStat";
  public static final String utsLedPonSlotLedDispPonPort4FaultLedStat = "utsLedPonSlotLedDispPonPort4FaultLedStat";

  private String fTableOid = ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.6.2.1.1";

  public PonLedTableBean(ISnmpProxy aSnmpProxy)
  {
    super(aSnmpProxy);
    init();
  }

  protected void init()
  {
    initProperty(utsLedPonSlotLedDispSlotId, new SnmpMibBeanProperty(utsLedPonSlotLedDispSlotId, fTableOid + ".1", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPowLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPowLedStat, fTableOid + ".2", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispRunLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispRunLedStat, fTableOid + ".3", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispFaultLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispFaultLedStat, fTableOid + ".4", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispSwapLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispSwapLedStat, fTableOid + ".5", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort1OprLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort1OprLedStat, fTableOid + ".6", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort1FaultLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort1FaultLedStat, fTableOid + ".7", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort2OprLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort2OprLedStat, fTableOid + ".8", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort2FaultLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort2FaultLedStat, fTableOid + ".9", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort3OprLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort3OprLedStat, fTableOid + ".10", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort3FaultLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort3FaultLedStat, fTableOid + ".11", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort4OprLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort4OprLedStat, fTableOid + ".12", ISnmpConstant.INTEGER));
    initProperty(utsLedPonSlotLedDispPonPort4FaultLedStat, new SnmpMibBeanProperty(utsLedPonSlotLedDispPonPort4FaultLedStat, fTableOid + ".13", ISnmpConstant.INTEGER));

  }


  public Integer getUtsLedPonSlotLedDispSlotId()
  {
    return (Integer)getIndex(0);
  }

  public void setUtsLedPonSlotLedDispSlotId(Integer aUtsLedPonSlotLedDispSlotId)
  {
    setIndex(0, aUtsLedPonSlotLedDispSlotId);
  }

  public Integer getUtsLedPonSlotLedDispPowLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPowLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPowLedStat(Integer aUtsLedPonSlotLedDispPowLedStat)
  {
    getProperty(utsLedPonSlotLedDispPowLedStat).setValue(aUtsLedPonSlotLedDispPowLedStat);
  }

  public Integer getUtsLedPonSlotLedDispRunLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispRunLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispRunLedStat(Integer aUtsLedPonSlotLedDispRunLedStat)
  {
    getProperty(utsLedPonSlotLedDispRunLedStat).setValue(aUtsLedPonSlotLedDispRunLedStat);
  }

  public Integer getUtsLedPonSlotLedDispFaultLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispFaultLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispFaultLedStat(Integer aUtsLedPonSlotLedDispFaultLedStat)
  {
    getProperty(utsLedPonSlotLedDispFaultLedStat).setValue(aUtsLedPonSlotLedDispFaultLedStat);
  }

  public Integer getUtsLedPonSlotLedDispSwapLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispSwapLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispSwapLedStat(Integer aUtsLedPonSlotLedDispSwapLedStat)
  {
    getProperty(utsLedPonSlotLedDispSwapLedStat).setValue(aUtsLedPonSlotLedDispSwapLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort1OprLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPonPort1OprLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort1OprLedStat(Integer aUtsLedPonSlotLedDispPonPort1OprLedStat)
  {
    getProperty(utsLedPonSlotLedDispPonPort1OprLedStat).setValue(aUtsLedPonSlotLedDispPonPort1OprLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort1FaultLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPonPort1FaultLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort1FaultLedStat(Integer aUtsLedPonSlotLedDispPonPort1FaultLedStat)
  {
    getProperty(utsLedPonSlotLedDispPonPort1FaultLedStat).setValue(aUtsLedPonSlotLedDispPonPort1FaultLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort2OprLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPonPort2OprLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort2OprLedStat(Integer aUtsLedPonSlotLedDispPonPort2OprLedStat)
  {
    getProperty(utsLedPonSlotLedDispPonPort2OprLedStat).setValue(aUtsLedPonSlotLedDispPonPort2OprLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort2FaultLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPonPort2FaultLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort2FaultLedStat(Integer aUtsLedPonSlotLedDispPonPort2FaultLedStat)
  {
    getProperty(utsLedPonSlotLedDispPonPort2FaultLedStat).setValue(aUtsLedPonSlotLedDispPonPort2FaultLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort3OprLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPonPort3OprLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort3OprLedStat(Integer aUtsLedPonSlotLedDispPonPort3OprLedStat)
  {
    getProperty(utsLedPonSlotLedDispPonPort3OprLedStat).setValue(aUtsLedPonSlotLedDispPonPort3OprLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort3FaultLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPonPort3FaultLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort3FaultLedStat(Integer aUtsLedPonSlotLedDispPonPort3FaultLedStat)
  {
    getProperty(utsLedPonSlotLedDispPonPort3FaultLedStat).setValue(aUtsLedPonSlotLedDispPonPort3FaultLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort4OprLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPonPort4OprLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort4OprLedStat(Integer aUtsLedPonSlotLedDispPonPort4OprLedStat)
  {
    getProperty(utsLedPonSlotLedDispPonPort4OprLedStat).setValue(aUtsLedPonSlotLedDispPonPort4OprLedStat);
  }

  public Integer getUtsLedPonSlotLedDispPonPort4FaultLedStat()
  {
    return (Integer)getProperty(utsLedPonSlotLedDispPonPort4FaultLedStat).getValue();
  }

  public void setUtsLedPonSlotLedDispPonPort4FaultLedStat(Integer aUtsLedPonSlotLedDispPonPort4FaultLedStat)
  {
    getProperty(utsLedPonSlotLedDispPonPort4FaultLedStat).setValue(aUtsLedPonSlotLedDispPonPort4FaultLedStat);
  }


  public boolean retrieve() throws MibBeanException
  {
    prepareRead(super.getProperty(utsLedPonSlotLedDispPowLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispRunLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispFaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispSwapLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort1OprLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort1FaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort2OprLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort2FaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort3OprLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort3FaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort4OprLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort4FaultLedStat));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException
  {
    prepareRead(super.getProperty(utsLedPonSlotLedDispPowLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispRunLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispFaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispSwapLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort1OprLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort1FaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort2OprLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort2FaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort3OprLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort3FaultLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort4OprLedStat));
    prepareRead(super.getProperty(utsLedPonSlotLedDispPonPort4FaultLedStat));

    return loadAll(new int[]{1});
  }


}

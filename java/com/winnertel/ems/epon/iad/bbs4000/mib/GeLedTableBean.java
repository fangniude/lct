/*
* Copyright (c) 2002-2005 UTStarcom, Inc.
* All rights reserved.
*/
package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The GeLedTableBean class.
 * Created by QuickDVM
 */
public class GeLedTableBean extends SnmpMibBean
{
  public static final String utsLedGEPortSlotLedDispSlotId = "utsLedGEPortSlotLedDispSlotId";
  public static final String utsLedGEPortSlotLedDispPowLedStat = "utsLedGEPortSlotLedDispPowLedStat";
  public static final String utsLedGEPortSlotLedDispRunLedStat = "utsLedGEPortSlotLedDispRunLedStat";
  public static final String utsLedGEPortSlotLedDispFaultLedStat = "utsLedGEPortSlotLedDispFaultLedStat";
  public static final String utsLedGEPortSlotLedDispSwapLedStat = "utsLedGEPortSlotLedDispSwapLedStat";
  public static final String utsLedGEPortSlotLedDispPort1LinkLedStat = "utsLedGEPortSlotLedDispPort1LinkLedStat";
  public static final String utsLedGEPortSlotLedDispPort2LinkLedStat = "utsLedGEPortSlotLedDispPort2LinkLedStat";
  public static final String utsLedGEPortSlotLedDispPort3LinkLedStat = "utsLedGEPortSlotLedDispPort3LinkLedStat";
  public static final String utsLedGEPortSlotLedDispPort4LinkLedStat = "utsLedGEPortSlotLedDispPort4LinkLedStat";

  private String fTableOid = ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.6.3.1.1";

  public GeLedTableBean(ISnmpProxy aSnmpProxy)
  {
    super(aSnmpProxy);
    init();
  }

  protected void init()
  {
    initProperty(utsLedGEPortSlotLedDispSlotId, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispSlotId, fTableOid + ".1", ISnmpConstant.INTEGER));
    initProperty(utsLedGEPortSlotLedDispPowLedStat, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispPowLedStat, fTableOid + ".2", ISnmpConstant.INTEGER));
    initProperty(utsLedGEPortSlotLedDispRunLedStat, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispRunLedStat, fTableOid + ".3", ISnmpConstant.INTEGER));
    initProperty(utsLedGEPortSlotLedDispFaultLedStat, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispFaultLedStat, fTableOid + ".4", ISnmpConstant.INTEGER));
    initProperty(utsLedGEPortSlotLedDispSwapLedStat, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispSwapLedStat, fTableOid + ".5", ISnmpConstant.INTEGER));
    initProperty(utsLedGEPortSlotLedDispPort1LinkLedStat, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispPort1LinkLedStat, fTableOid + ".6", ISnmpConstant.INTEGER));
    initProperty(utsLedGEPortSlotLedDispPort2LinkLedStat, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispPort2LinkLedStat, fTableOid + ".8", ISnmpConstant.INTEGER));
    initProperty(utsLedGEPortSlotLedDispPort3LinkLedStat, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispPort3LinkLedStat, fTableOid + ".10", ISnmpConstant.INTEGER));
    initProperty(utsLedGEPortSlotLedDispPort4LinkLedStat, new SnmpMibBeanProperty(utsLedGEPortSlotLedDispPort4LinkLedStat, fTableOid + ".12", ISnmpConstant.INTEGER));

  }


  public Integer getUtsLedGEPortSlotLedDispSlotId()
  {
    return (Integer)getIndex(0);
  }

  public void setUtsLedGEPortSlotLedDispSlotId(Integer aUtsLedGEPortSlotLedDispSlotId)
  {
    setIndex(0, aUtsLedGEPortSlotLedDispSlotId);
  }

  public Integer getUtsLedGEPortSlotLedDispPowLedStat()
  {
    return (Integer)getProperty(utsLedGEPortSlotLedDispPowLedStat).getValue();
  }

  public void setUtsLedGEPortSlotLedDispPowLedStat(Integer aUtsLedGEPortSlotLedDispPowLedStat)
  {
    getProperty(utsLedGEPortSlotLedDispPowLedStat).setValue(aUtsLedGEPortSlotLedDispPowLedStat);
  }

  public Integer getUtsLedGEPortSlotLedDispRunLedStat()
  {
    return (Integer)getProperty(utsLedGEPortSlotLedDispRunLedStat).getValue();
  }

  public void setUtsLedGEPortSlotLedDispRunLedStat(Integer aUtsLedGEPortSlotLedDispRunLedStat)
  {
    getProperty(utsLedGEPortSlotLedDispRunLedStat).setValue(aUtsLedGEPortSlotLedDispRunLedStat);
  }

  public Integer getUtsLedGEPortSlotLedDispFaultLedStat()
  {
    return (Integer)getProperty(utsLedGEPortSlotLedDispFaultLedStat).getValue();
  }

  public void setUtsLedGEPortSlotLedDispFaultLedStat(Integer aUtsLedGEPortSlotLedDispFaultLedStat)
  {
    getProperty(utsLedGEPortSlotLedDispFaultLedStat).setValue(aUtsLedGEPortSlotLedDispFaultLedStat);
  }

  public Integer getUtsLedGEPortSlotLedDispSwapLedStat()
  {
    return (Integer)getProperty(utsLedGEPortSlotLedDispSwapLedStat).getValue();
  }

  public void setUtsLedGEPortSlotLedDispSwapLedStat(Integer aUtsLedGEPortSlotLedDispSwapLedStat)
  {
    getProperty(utsLedGEPortSlotLedDispSwapLedStat).setValue(aUtsLedGEPortSlotLedDispSwapLedStat);
  }

  public Integer getUtsLedGEPortSlotLedDispPort1LinkLedStat()
  {
    return (Integer)getProperty(utsLedGEPortSlotLedDispPort1LinkLedStat).getValue();
  }

  public void setUtsLedGEPortSlotLedDispPort1LinkLedStat(Integer aUtsLedGEPortSlotLedDispPort1LinkLedStat)
  {
    getProperty(utsLedGEPortSlotLedDispPort1LinkLedStat).setValue(aUtsLedGEPortSlotLedDispPort1LinkLedStat);
  }

  public Integer getUtsLedGEPortSlotLedDispPort2LinkLedStat()
  {
    return (Integer)getProperty(utsLedGEPortSlotLedDispPort2LinkLedStat).getValue();
  }

  public void setUtsLedGEPortSlotLedDispPort2LinkLedStat(Integer aUtsLedGEPortSlotLedDispPort2LinkLedStat)
  {
    getProperty(utsLedGEPortSlotLedDispPort2LinkLedStat).setValue(aUtsLedGEPortSlotLedDispPort2LinkLedStat);
  }

  public Integer getUtsLedGEPortSlotLedDispPort3LinkLedStat()
  {
    return (Integer)getProperty(utsLedGEPortSlotLedDispPort3LinkLedStat).getValue();
  }

  public void setUtsLedGEPortSlotLedDispPort3LinkLedStat(Integer aUtsLedGEPortSlotLedDispPort3LinkLedStat)
  {
    getProperty(utsLedGEPortSlotLedDispPort3LinkLedStat).setValue(aUtsLedGEPortSlotLedDispPort3LinkLedStat);
  }

  public Integer getUtsLedGEPortSlotLedDispPort4LinkLedStat()
  {
    return (Integer)getProperty(utsLedGEPortSlotLedDispPort4LinkLedStat).getValue();
  }

  public void setUtsLedGEPortSlotLedDispPort4LinkLedStat(Integer aUtsLedGEPortSlotLedDispPort4LinkLedStat)
  {
    getProperty(utsLedGEPortSlotLedDispPort4LinkLedStat).setValue(aUtsLedGEPortSlotLedDispPort4LinkLedStat);
  }


  public boolean retrieve() throws MibBeanException
  {
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPowLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispRunLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispFaultLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispSwapLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPort1LinkLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPort2LinkLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPort3LinkLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPort4LinkLedStat));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException
  {
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPowLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispRunLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispFaultLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispSwapLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPort1LinkLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPort2LinkLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPort3LinkLedStat));
    prepareRead(super.getProperty(utsLedGEPortSlotLedDispPort4LinkLedStat));

    return loadAll(new int[]{1});
  }


}

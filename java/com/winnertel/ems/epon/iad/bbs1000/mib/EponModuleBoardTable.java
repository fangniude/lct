package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

import java.util.Vector;

public class EponModuleBoardTable extends SnmpMibBean
{
  private final String utsEponModuleBoardPhyId = "utsEponModuleBoardPhyId";
  private final String utsEponModuleBoardType = "utsEponModuleBoardType";
  private final String utsEponModuleBoardState = "utsEponModuleBoardState";
  private final String utsEponModuleBoardSwVer = "utsEponModuleBoardSwVer";
  private final String utsEponModuleBoardBootromVer = "utsEponModuleBoardBootromVer";
  private final String utsEponModuleBoardVer = "utsEponModuleBoardVer";
  private final String utsEponModuleBoardAction = "utsEponModuleBoardAction";

  private String fTableOid = ".1.3.6.1.4.1.45121.1800.2.1.1.1.1";

  public EponModuleBoardTable(ISnmpProxy aSnmpProxy)
  {
    super(aSnmpProxy);
    init();
  } // GenModuleMBean

  protected void init()
  {
    initProperty(utsEponModuleBoardPhyId, new SnmpMibBeanProperty(utsEponModuleBoardPhyId, fTableOid + ".1", ISnmpConstant.INTEGER));
    initProperty(utsEponModuleBoardType, new SnmpMibBeanProperty(utsEponModuleBoardType, fTableOid + ".2", ISnmpConstant.INTEGER));
    initProperty(utsEponModuleBoardState, new SnmpMibBeanProperty(utsEponModuleBoardState, fTableOid + ".3", ISnmpConstant.INTEGER));
    initProperty(utsEponModuleBoardSwVer, new SnmpMibBeanProperty(utsEponModuleBoardSwVer, fTableOid + ".7", ISnmpConstant.STRING));
    initProperty(utsEponModuleBoardBootromVer, new SnmpMibBeanProperty(utsEponModuleBoardBootromVer, fTableOid + ".9", ISnmpConstant.STRING));
    initProperty(utsEponModuleBoardVer, new SnmpMibBeanProperty(utsEponModuleBoardVer, fTableOid + ".10", ISnmpConstant.STRING));
    initProperty(utsEponModuleBoardAction, new SnmpMibBeanProperty(utsEponModuleBoardAction, fTableOid + ".11", ISnmpConstant.INTEGER));
  } // init

  public void setUtsEponModuleBoardPhyId(Integer aInteger)
  {
    setIndex(0, aInteger);
  }

  public Integer getUtsEponModuleBoardPhyId()
  {
    return (Integer)getIndex(0);
  }

  public void setUtsEponModuleBoardType(Integer aInteger)
  {
    getProperty(utsEponModuleBoardType).setValue(aInteger);
  }

  public Integer getUtsEponModuleBoardType()
  {
    return (Integer)getProperty(utsEponModuleBoardType).getValue();
  }

  public void setUtsEponModuleBoardState(Integer aInteger)
  {
    getProperty(utsEponModuleBoardState).setValue(aInteger);
  }

  public Integer getUtsEponModuleBoardState()
  {
    return (Integer)getProperty(utsEponModuleBoardState).getValue();
  }

  public void setUtsEponModuleBoardSwVer(String swVer)
  {
    getProperty(utsEponModuleBoardSwVer).setValue(swVer);
  }

  public String getUtsEponModuleBoardSwVer()
  {
    return (String)getProperty(utsEponModuleBoardSwVer).getValue();
  }

  public void setUtsEponModuleBoardBootromVer(String bootromVer)
  {
    getProperty(utsEponModuleBoardBootromVer).setValue(bootromVer);
  }

  public String getUtsEponModuleBoardBootromVer()
  {
    return (String)getProperty(utsEponModuleBoardBootromVer).getValue();
  }

  public void setUtsEponModuleBoardVer(String passaveVer)
  {
    getProperty(utsEponModuleBoardVer).setValue(passaveVer);
  }

  public String getUtsEponModuleBoardVer()
  {
    return (String)getProperty(utsEponModuleBoardVer).getValue();
  }

  public void setUtsEponModuleBoardAction(Integer aInteger)
  {
    getProperty(utsEponModuleBoardAction).setValue(aInteger);
  }

  public Integer getUtsEponModuleBoardAction()
  {
    return (Integer)getProperty(utsEponModuleBoardAction).getValue();
  }

  public boolean retrieve() throws MibBeanException
  {
    prepareRead(getProperty(utsEponModuleBoardType));
    prepareRead(getProperty(utsEponModuleBoardState));
    prepareRead(getProperty(utsEponModuleBoardSwVer));
    prepareRead(getProperty(utsEponModuleBoardBootromVer));
    prepareRead(getProperty(utsEponModuleBoardVer));
    return load();
  } // retrieve

  public Vector retrieveAll()
  {
//    prepareRead(getProperty(utsEponModuleBoardPhyId));
    prepareRead(getProperty(utsEponModuleBoardType));
    prepareRead(getProperty(utsEponModuleBoardState));
    prepareRead(getProperty(utsEponModuleBoardSwVer));
    prepareRead(getProperty(utsEponModuleBoardBootromVer));
    prepareRead(getProperty(utsEponModuleBoardVer));

    return loadAll(new int[]{1});
  } // retrieveAll

  public boolean delete() throws MibBeanException
  {
    setUtsEponModuleBoardAction(new Integer(1));
    prepareSave(getProperty(utsEponModuleBoardAction));

    return save();
  }
}

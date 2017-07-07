package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class BBS4000CardMibBean extends SnmpMibBean
{
  private final String utsEponModuleBoardPhyId = "utsEponModuleBoardPhyId";
  private final String utsEponModuleBoardType = "utsEponModuleBoardType";
  private final String utsEponModulePhyPresenceStat = "utsEponModulePhyPresenceStat";
  private final String utsEponModuleAdminState = "utsEponModuleAdminState";
  private final String utsEponModuleOperationState = "utsEponModuleOperationState";
  private final String utsEponModuleRedundancyState = "utsEponModuleRedundancyState";
  private final String utsEponModuleBoardSwVer = "utsEponModuleBoardSwVer";
  private final String utsEponModuleBoardBootromVer = "utsEponModuleBoardBootromVer";
  private final String utsEponModuleBoardPassaveVer = "utsEponModuleBoardPassaveVer";
  public static final String utsEponModuleBoardHwVer = "utsEponModuleBoardHwVer";
  public static final String utsEponModuleBoardSerialNumber = "utsEponModuleBoardSerialNumber";

  private String fTableOid = ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.1.1";

  public BBS4000CardMibBean(ISnmpProxy aSnmpProxy)
  {
    super(aSnmpProxy);
    init();
  } // GenModuleMBean

  protected void init()
  {
    initProperty(utsEponModuleBoardPhyId, new SnmpMibBeanProperty(utsEponModuleBoardPhyId, fTableOid + ".1", ISnmpConstant.INTEGER));
    initProperty(utsEponModuleBoardType, new SnmpMibBeanProperty(utsEponModuleBoardType, fTableOid + ".2", ISnmpConstant.INTEGER));
    initProperty(utsEponModulePhyPresenceStat, new SnmpMibBeanProperty(utsEponModulePhyPresenceStat, fTableOid + ".3", ISnmpConstant.INTEGER));
    initProperty(utsEponModuleAdminState, new SnmpMibBeanProperty(utsEponModuleAdminState, fTableOid + ".4", ISnmpConstant.INTEGER));
    initProperty(utsEponModuleOperationState, new SnmpMibBeanProperty(utsEponModuleOperationState, fTableOid + ".5", ISnmpConstant.INTEGER));
    initProperty(utsEponModuleRedundancyState, new SnmpMibBeanProperty(utsEponModuleRedundancyState, fTableOid + ".6", ISnmpConstant.INTEGER));
    initProperty(utsEponModuleBoardSwVer, new SnmpMibBeanProperty(utsEponModuleBoardSwVer, fTableOid + ".12", ISnmpConstant.STRING));
    initProperty(utsEponModuleBoardBootromVer, new SnmpMibBeanProperty(utsEponModuleBoardBootromVer, fTableOid + ".13", ISnmpConstant.STRING));
    initProperty(utsEponModuleBoardPassaveVer, new SnmpMibBeanProperty(utsEponModuleBoardPassaveVer, fTableOid + ".14", ISnmpConstant.STRING));
    initProperty(utsEponModuleBoardHwVer, new SnmpMibBeanProperty(utsEponModuleBoardHwVer, fTableOid + ".21", ISnmpConstant.OCTETS));
    initProperty(utsEponModuleBoardSerialNumber, new SnmpMibBeanProperty(utsEponModuleBoardSerialNumber, fTableOid + ".23", ISnmpConstant.STRING));
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

  public void setUtsEponModulePhyPresenceStat(Integer aInteger)
  {
    getProperty(utsEponModulePhyPresenceStat).setValue(aInteger);
  }

  public Integer getUtsEponModulePhyPresenceStat()
  {
    return (Integer)getProperty(utsEponModulePhyPresenceStat).getValue();
  }

  public void setUtsEponModuleAdminState(Integer aInteger)
  {
    getProperty(utsEponModuleAdminState).setValue(aInteger);
  }

  public Integer getUtsEponModuleAdminState()
  {
    return (Integer)getProperty(utsEponModuleAdminState).getValue();
  }

  public void setUtsEponModuleOperationState(Integer aInteger)
  {
    getProperty(utsEponModuleOperationState).setValue(aInteger);
  }

  public Integer getUtsEponModuleOperationState()
  {
    return (Integer)getProperty(utsEponModuleOperationState).getValue();
  }

  public void setUtsEponModuleRedundancyState(Integer aInteger)
  {
    getProperty(utsEponModuleRedundancyState).setValue(aInteger);
  }

  public Integer getUtsEponModuleRedundancyState()
  {
    return (Integer)getProperty(utsEponModuleRedundancyState).getValue();
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

  public void setUtsEponModuleBoardPassaveVer(String passaveVer)
  {
    getProperty(utsEponModuleBoardPassaveVer).setValue(passaveVer);
  }

  public String getUtsEponModuleBoardPassaveVer()
  {
    return (String)getProperty(utsEponModuleBoardPassaveVer).getValue();
  }

  public byte[] getUtsEponModuleBoardHwVer() {
    return (byte[]) getProperty(utsEponModuleBoardHwVer).getValue();
  }

  public void setUtsEponModuleBoardHwVer(byte[] aUtsEponModuleBoardHwVer) {
    getProperty(utsEponModuleBoardHwVer).setValue(aUtsEponModuleBoardHwVer);
  }

  public String getUtsEponModuleBoardSerialNumber() {
    return (String) getProperty(utsEponModuleBoardSerialNumber).getValue();
  }

  public void setUtsEponModuleBoardSerialNumber(String aUtsEponModuleBoardSerialNumber) {
    getProperty(utsEponModuleBoardSerialNumber).setValue(aUtsEponModuleBoardSerialNumber);
  }

  public boolean modify() throws MibBeanException
  {
    prepareSave(getProperty(utsEponModuleAdminState));

    return save();
  }

  public boolean retrieve() throws MibBeanException
  {
//    prepareRead(getProperty(utsEponModuleBoardPhyId));
    prepareRead(getProperty(utsEponModuleBoardType));
    prepareRead(getProperty(utsEponModulePhyPresenceStat));
    prepareRead(getProperty(utsEponModuleAdminState));
    prepareRead(getProperty(utsEponModuleOperationState));
    prepareRead(getProperty(utsEponModuleRedundancyState));
    prepareRead(getProperty(utsEponModuleBoardSwVer));
    prepareRead(getProperty(utsEponModuleBoardBootromVer));
    prepareRead(getProperty(utsEponModuleBoardPassaveVer));
    prepareRead(getProperty(utsEponModuleBoardHwVer));
    prepareRead(getProperty(utsEponModuleBoardSerialNumber));

    return load();
  } // retrieve

  public Vector retrieveAll()
  {
//    prepareRead(getProperty(utsEponModuleBoardPhyId));
    prepareRead(getProperty(utsEponModuleBoardType));
    prepareRead(getProperty(utsEponModulePhyPresenceStat));
    prepareRead(getProperty(utsEponModuleAdminState));
    prepareRead(getProperty(utsEponModuleOperationState));
    prepareRead(getProperty(utsEponModuleRedundancyState));
    prepareRead(getProperty(utsEponModuleBoardSwVer));
    prepareRead(getProperty(utsEponModuleBoardBootromVer));
    prepareRead(getProperty(utsEponModuleBoardPassaveVer));
    prepareRead(getProperty(utsEponModuleBoardHwVer));
    prepareRead(getProperty(utsEponModuleBoardSerialNumber));

    setRowsPerFetch(50);
//    setRowsToFetch(14);
//    setIndex(0, "0");
    return loadAll(new int[]{1});
  } // retrieveAll

  public Vector retrieveEpm04b()
  {
    Vector v = retrieveAll();

    if(v != null)
    {
      int i = 0;
      while(i < v.size())
      {
        BBS4000CardMibBean one = (BBS4000CardMibBean)v.get(i);
        if(one.getUtsEponModuleBoardType().intValue() != 4)
        {
          v.remove(i);
        }
        else
        {
          i++;
        }
      }
    }
    return v;
  }
}

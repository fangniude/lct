package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class VlanModeConfigMBean extends SnmpMibBean
{
    public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
    public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
    public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
    public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
    public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
    public static final String utsDot3OnuEtherPortVlanMode = "utsDot3OnuEtherPortVlanMode";
    public static final String utsDot3OnuEtherPortVlanTag = "utsDot3OnuEtherPortVlanTag";
  public static final String utsDot3OnuEtherPortVlanTPID = "utsDot3OnuEtherPortVlanTPID";
  public static final String utsDot3OnuEtherPortVlanTranslation = "utsDot3OnuEtherPortVlanTranslation";

    public VlanModeConfigMBean(ISnmpProxy aSnmpProxy)
    {
        super(aSnmpProxy);
        init();
    }
    
    protected void init()
    {
        initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId,
            ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId,
            ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId,
            ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex,
            ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanMode, new SnmpMibBeanProperty(
            utsDot3OnuEtherPortVlanMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.36",
            ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanTag, new SnmpMibBeanProperty(
            utsDot3OnuEtherPortVlanTag, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.38",
            ISnmpConstant.INTEGER));
      initProperty(utsDot3OnuEtherPortVlanTPID, new SnmpMibBeanProperty(
          utsDot3OnuEtherPortVlanTPID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.37",
          ISnmpConstant.INTEGER));
      initProperty(utsDot3OnuEtherPortVlanTranslation, new SnmpMibBeanProperty(
          utsDot3OnuEtherPortVlanTranslation, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.40",
          ISnmpConstant.OCTETS));
    }
    
    public Integer getUtsDot3OnuModuleId()
    {
        return (Integer) getIndex(0);
    }
    
    public void setUtsDot3OnuModuleId(Integer aUtsDot3OnuModuleId)
    {
        setIndex(0, aUtsDot3OnuModuleId);
    }
    
    public Integer getUtsDot3OnuDeviceId()
    {
        return (Integer) getIndex(1);
    }
    
    public void setUtsDot3OnuDeviceId(Integer aUtsDot3OnuDeviceId)
    {
        setIndex(1, aUtsDot3OnuDeviceId);
    }
    
    public Integer getUtsDot3OnuPortId()
    {
        return (Integer) getIndex(2);
    }
    
    public void setUtsDot3OnuPortId(Integer aUtsDot3OnuPortId)
    {
        setIndex(2, aUtsDot3OnuPortId);
    }
    
    public Integer getUtsDot3OnuLogicalPortId()
    {
        return (Integer) getIndex(3);
    }
    
    public void setUtsDot3OnuLogicalPortId(Integer aUtsDot3OnuLogicalPortId)
    {
        setIndex(3, aUtsDot3OnuLogicalPortId);
    }
    
    public Integer getUtsDot3OnuEtherPortIndex()
    {
        return (Integer) getIndex(4);
    }
    
    public void setUtsDot3OnuEtherPortIndex(Integer aUtsDot3OnuEtherPortIndex)
    {
        setIndex(4, aUtsDot3OnuEtherPortIndex);
    }
    
    public Integer getUtsDot3OnuEtherPortVlanMode()
    {
        return (Integer) getProperty(utsDot3OnuEtherPortVlanMode).getValue();
    }
    
    public void setUtsDot3OnuEtherPortVlanMode(Integer aUtsDot3OnuEtherPortVlanMode)
    {
        getProperty(utsDot3OnuEtherPortVlanMode).setValue(aUtsDot3OnuEtherPortVlanMode);
    }
    
    public Integer getUtsDot3OnuEtherPortVlanTag()
    {
        return (Integer) getProperty(utsDot3OnuEtherPortVlanTag).getValue();
    }
    
    public void setUtsDot3OnuEtherPortVlanTag(Integer aUtsDot3OnuEtherPortVlanTag)
    {
        getProperty(utsDot3OnuEtherPortVlanTag).setValue(aUtsDot3OnuEtherPortVlanTag);
    }
    
  public Integer getUtsDot3OnuEtherPortVlanTPID()
  {
      return (Integer) getProperty(utsDot3OnuEtherPortVlanTPID).getValue();
  }

  public void setUtsDot3OnuEtherPortVlanTPID(Integer aUtsDot3OnuEtherPortVlanTPID)
  {
      getProperty(utsDot3OnuEtherPortVlanTPID).setValue(aUtsDot3OnuEtherPortVlanTPID);
  }

  public byte[] getUtsDot3OnuEtherPortVlanTranslation()
  {
      return (byte[]) getProperty(utsDot3OnuEtherPortVlanTranslation).getValue();
  }

  public void setUtsDot3OnuEtherPortVlanTranslation(byte[] aUtsDot3OnuEtherPortVlanTranslation)
  {
      getProperty(utsDot3OnuEtherPortVlanTranslation).setValue(
          aUtsDot3OnuEtherPortVlanTranslation);
  }

    public boolean retrieve() throws MibBeanException
    {
        prepareRead(super.getProperty(utsDot3OnuEtherPortVlanMode));
        prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTag));
      prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTPID));
      prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTranslation));

        return load();
    }
    
    public Vector retrieveAll() throws MibBeanException
    {
        prepareRead(super.getProperty(utsDot3OnuEtherPortVlanMode));
        prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTag));
      prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTPID));
      prepareRead(super.getProperty(utsDot3OnuEtherPortVlanTranslation));

        return loadAll(new int[] { 1, 1, 1, 1, 1 });
    }
    
    public boolean modify() throws MibBeanException
    {
        prepareSave(getProperty(utsDot3OnuEtherPortVlanMode));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTag));
      prepareSave(getProperty(utsDot3OnuEtherPortVlanTPID));
      prepareSave(getProperty(utsDot3OnuEtherPortVlanTranslation));

        return save();
    }
}

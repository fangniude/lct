/**
 * Title          :   OltSlotStatusTable.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * @author Shen Dayong
 * Create on 2008-10-2
 * Modify by HZ21044
 */

public class OltSlotStatusTable extends SnmpMibBean
{
    public static final String oltSlotStatusSlotNo = "oltSlotStatusSlotNo";
    public static final String oltSlotStatusOperationalState = "oltSlotStatusOperationalState";
    public static final String oltSlotStatusOltFirmwareVersion = "oltSlotStatusOltFirmwareVersion";
    
    public OltSlotStatusTable(ISnmpProxy aSnmpProxy)
    {
        super(aSnmpProxy);
        init();
    }
    
    protected void init()
    {
        initProperty(oltSlotStatusSlotNo, new SnmpMibBeanProperty(oltSlotStatusSlotNo,
            ".1.3.6.1.4.1.41355.1.3.10.5.1.2.1.1", ISnmpConstant.INTEGER));
        initProperty(oltSlotStatusOperationalState, new SnmpMibBeanProperty(
            oltSlotStatusOperationalState, ".1.3.6.1.4.1.41355.1.3.10.5.1.2.1.2",
            ISnmpConstant.INTEGER));
        initProperty(oltSlotStatusOltFirmwareVersion, new SnmpMibBeanProperty(
            oltSlotStatusOltFirmwareVersion, ".1.3.6.1.4.1.41355.1.3.10.5.1.2.1.3",
            ISnmpConstant.GAUGE));
        
    }
    
    public Integer getOltSlotStatusSlotNo()
    {
        return (Integer) getIndex(0);
    }
    
    public void setOltSlotStatusSlotNo(Integer aOltSlotStatusSlotNo)
    {
        setIndex(0, aOltSlotStatusSlotNo);
    }
    
    public Integer getOltSlotStatusOperationalState()
    {
        return (Integer) getProperty(oltSlotStatusOperationalState).getValue();
    }
    
    public void setOltSlotStatusOperationalState(Integer aOltSlotStatusOperationalState)
    {
        getProperty(oltSlotStatusOperationalState).setValue(aOltSlotStatusOperationalState);
    }
    
    public Long getOltSlotStatusOltFirmwareVersion()
    {
        return (Long) getProperty(oltSlotStatusOltFirmwareVersion).getValue();
    }
    
    public void setOltSlotStatusOltFirmwareVersion(Long aOltSlotStatusOltFirmwareVersion)
    {
        getProperty(oltSlotStatusOltFirmwareVersion).setValue(aOltSlotStatusOltFirmwareVersion);
    }
    
    public boolean retrieve() throws MibBeanException
    {
        prepareRead(super.getProperty(oltSlotStatusOperationalState));
        prepareRead(super.getProperty(oltSlotStatusOltFirmwareVersion));
        
        return load();
    }
    
    public Vector retrieveAll() throws MibBeanException
    {
        prepareRead(super.getProperty(oltSlotStatusOperationalState));
        prepareRead(super.getProperty(oltSlotStatusOltFirmwareVersion));
        
        return loadAll(new int[] { 1 });
    }
    
}

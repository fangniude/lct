/**
 * Title          :   OnuRateCtrSchProfTable.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * @author Shen Dayong
 * Create on 2008-9-30
 * Modify by HZ21044
 */

public class OnuRateCtrSchProfTable extends SnmpMibBean
{
    public static final String schedulerProfileIndex = "schedulerProfileIndex";
    public static final String onuRateCtrSchProfileName = "onuRateCtrSchProfileName";
    public static final String sir = "sir";
    public static final String pir = "pir";
    public static final String schedulerWeight = "schedulerWeight";
    
    public OnuRateCtrSchProfTable(ISnmpProxy aSnmpProxy)
    {
        super(aSnmpProxy);
        init();
    }
    
    protected void init()
    {
        initProperty(schedulerProfileIndex, new SnmpMibBeanProperty(schedulerProfileIndex,
            ".1.3.6.1.4.1.45121.1.3.10.5.2.5.1.1", ISnmpConstant.GAUGE));
        initProperty(onuRateCtrSchProfileName, new SnmpMibBeanProperty(onuRateCtrSchProfileName,
            ".1.3.6.1.4.1.45121.1.3.10.5.2.5.1.2", ISnmpConstant.STRING));
        initProperty(sir, new SnmpMibBeanProperty(sir, ".1.3.6.1.4.1.45121.1.3.10.5.2.5.1.3",
            ISnmpConstant.GAUGE));
        initProperty(pir, new SnmpMibBeanProperty(pir, ".1.3.6.1.4.1.45121.1.3.10.5.2.5.1.4",
            ISnmpConstant.GAUGE));
        initProperty(schedulerWeight, new SnmpMibBeanProperty(schedulerWeight,
            ".1.3.6.1.4.1.45121.1.3.10.5.2.5.1.5", ISnmpConstant.GAUGE));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
            ".1.3.6.1.4.1.45121.1.3.10.5.2.5.1.6", ISnmpConstant.INTEGER));
        
    }
    
    public Long getSchedulerProfileIndex()
    {
        return (Long) getIndex(0);
    }
    
    public void setSchedulerProfileIndex(Long aSchedulerProfileIndex)
    {
        setIndex(0, aSchedulerProfileIndex);
    }
    
    public String getOnuRateCtrSchProfileName()
    {
        return (String) getProperty(onuRateCtrSchProfileName).getValue();
    }
    
    public void setOnuRateCtrSchProfileName(String aOnuRateCtrSchProfileName)
    {
        getProperty(onuRateCtrSchProfileName).setValue(aOnuRateCtrSchProfileName);
    }
    
    public Long getSir()
    {
        return (Long) getProperty(sir).getValue();
    }
    
    public void setSir(Long aSir)
    {
        getProperty(sir).setValue(aSir);
    }
    
    public Long getPir()
    {
        return (Long) getProperty(pir).getValue();
    }
    
    public void setPir(Long aPir)
    {
        getProperty(pir).setValue(aPir);
    }
    
    public Long getSchedulerWeight()
    {
        return (Long) getProperty(schedulerWeight).getValue();
    }
    
    public void setSchedulerWeight(Long aSchedulerWeight)
    {
        getProperty(schedulerWeight).setValue(aSchedulerWeight);
    }
    
    public boolean retrieve() throws MibBeanException
    {
        prepareRead(super.getProperty(onuRateCtrSchProfileName));
        prepareRead(super.getProperty(sir));
        prepareRead(super.getProperty(pir));
        prepareRead(super.getProperty(schedulerWeight));
        
        return load();
    }
    
    public Vector retrieveAll() throws MibBeanException
    {
        prepareRead(super.getProperty(onuRateCtrSchProfileName));
        prepareRead(super.getProperty(sir));
        prepareRead(super.getProperty(pir));
        prepareRead(super.getProperty(schedulerWeight));
        
        return loadAll(new int[] { 2 });
    }
    
    public boolean modify() throws MibBeanException
    {
        prepareSave(getProperty(onuRateCtrSchProfileName));
        prepareSave(getProperty(sir));
        prepareSave(getProperty(pir));
        prepareSave(getProperty(schedulerWeight));
        
        return save();
    }
    
    public boolean add() throws MibBeanException
    {
        prepareSave(getProperty(onuRateCtrSchProfileName));
        prepareSave(getProperty(sir));
        prepareSave(getProperty(pir));
        prepareSave(getProperty(schedulerWeight));
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }
    
    public boolean delete() throws MibBeanException
    {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }
    
}

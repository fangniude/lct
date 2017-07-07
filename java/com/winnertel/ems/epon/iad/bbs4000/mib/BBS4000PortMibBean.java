package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class BBS4000PortMibBean extends SnmpMibBean
{
    public static final String utsSwitchPortExtIfNum = "utsSwitchPortExtIfNum";
//    public static final String utsSwitchPortExtModuleId = "utsSwitchPortExtModuleId";
//    public static final String utsSwitchPortExtPortId = "utsSwitchPortExtPortId";
//    public static final String utsSwitchPortExtLAGId = "utsSwitchPortExtLAGId";
//    public static final String utsSwitchPortExtPortType = "utsSwitchPortExtPortType";

    public BBS4000PortMibBean(ISnmpProxy aSnmpProxy)
    {
        super(aSnmpProxy);
        init();
    }

    protected void init()
    {
        initProperty(utsSwitchPortExtIfNum, new SnmpMibBeanProperty(utsSwitchPortExtIfNum, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.1", ISnmpConstant.INTEGER));
//        initProperty(utsSwitchPortExtModuleId, new SnmpMibBeanProperty(utsSwitchPortExtModuleId, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.2", ISnmpConstant.INTEGER));
//        initProperty(utsSwitchPortExtPortId, new SnmpMibBeanProperty(utsSwitchPortExtPortId, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.3", ISnmpConstant.INTEGER));
//        initProperty(utsSwitchPortExtLAGId, new SnmpMibBeanProperty(utsSwitchPortExtLAGId, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.4", ISnmpConstant.INTEGER));
//        initProperty(utsSwitchPortExtPortType, new SnmpMibBeanProperty(utsSwitchPortExtPortType, ".1.3.6.1.4.1.41355.1800.2.2.1.8.1.5", ISnmpConstant.INTEGER));
    }

    public Integer getUtsSwitchPortExtIfNum()
    {
    return (Integer)getIndex(0);
    }

    public void setUtsSwitchPortExtIfNum(Integer aUtsSwitchPortExtIfNum)
    {
        setIndex(0, aUtsSwitchPortExtIfNum);
    }

//    public Integer getUtsSwitchPortExtModuleId()
//    {
//        return (Integer) getProperty(utsSwitchPortExtModuleId).getValue();
//    }
//
//    public void setUtsSwitchPortExtModuleId(Integer aUtsSwitchPortExtModuleId)
//    {
//        getProperty(utsSwitchPortExtModuleId).setValue(aUtsSwitchPortExtModuleId);
//    }
//
//    public Integer getUtsSwitchPortExtPortId()
//    {
//        return (Integer) getProperty(utsSwitchPortExtPortId).getValue();
//    }
//
//    public void setUtsSwitchPortExtPortId(Integer aUtsSwitchPortExtPortId)
//    {
//        getProperty(utsSwitchPortExtPortId).setValue(aUtsSwitchPortExtPortId);
//    }
//
//    public Integer getUtsSwitchPortExtLAGId()
//    {
//        return (Integer) getProperty(utsSwitchPortExtLAGId).getValue();
//    }
//
//    public void setUtsSwitchPortExtLAGId(Integer aUtsSwitchPortExtLAGId)
//    {
//        getProperty(utsSwitchPortExtLAGId).setValue(aUtsSwitchPortExtLAGId);
//    }
//
//    public Integer getUtsSwitchPortExtPortType()
//    {
//        return (Integer) getProperty(utsSwitchPortExtPortType).getValue();
//    }
//
//    public void setUtsSwitchPortExtPortType(Integer aUtsSwitchPortExtPortType)
//    {
//        getProperty(utsSwitchPortExtPortType).setValue(aUtsSwitchPortExtPortType);
//    }


    public boolean retrieve() throws MibBeanException
    {
        prepareRead(super.getProperty(utsSwitchPortExtIfNum));
//        prepareRead(super.getProperty(utsSwitchPortExtModuleId));
//        prepareRead(super.getProperty(utsSwitchPortExtPortId));
//        prepareRead(super.getProperty(utsSwitchPortExtLAGId));
//        prepareRead(super.getProperty(utsSwitchPortExtPortType));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException
    {
        prepareRead(super.getProperty(utsSwitchPortExtIfNum));
//        prepareRead(super.getProperty(utsSwitchPortExtModuleId));
//        prepareRead(super.getProperty(utsSwitchPortExtPortId));
//        prepareRead(super.getProperty(utsSwitchPortExtLAGId));
//        prepareRead(super.getProperty(utsSwitchPortExtPortType));

        return loadAll(new int[]
        { 1 });
    }
}

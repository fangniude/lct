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
 * The DHCPLeaseLimitTableMBean class.
 * Created by QuickDVM
 */
public class DHCPLeaseLimitTableMBean extends SnmpMibBean {
    public static final String utsDHCPLeaseNumVlan = "utsDHCPLeaseNumVlan";
    public static final String utsDHCPLeaseNumVal = "utsDHCPLeaseNumVal";


    public DHCPLeaseLimitTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDHCPLeaseNumVlan, new SnmpMibBeanProperty(utsDHCPLeaseNumVlan, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.13.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDHCPLeaseNumVal, new SnmpMibBeanProperty(utsDHCPLeaseNumVal, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.13.1.2", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.13.1.3", ISnmpConstant.INTEGER));

    }


    public Integer getUtsDHCPLeaseNumVlan() {
        return (Integer) getIndex(0);
    }

    public void setUtsDHCPLeaseNumVlan(Integer aUtsDHCPLeaseNumVlan) {
        setIndex(0, aUtsDHCPLeaseNumVlan);
    }


    public Integer getUtsDHCPLeaseNumVal() {
        return (Integer) getProperty(utsDHCPLeaseNumVal).getValue();
    }

    public void setUtsDHCPLeaseNumVal(Integer aUtsDHCPLeaseNumVal) {
        getProperty(utsDHCPLeaseNumVal).setValue(aUtsDHCPLeaseNumVal);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDHCPLeaseNumVal));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsDHCPLeaseNumVal));


        return loadAll(new int[]{1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDHCPLeaseNumVal));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDHCPLeaseNumVal));
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }


    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}

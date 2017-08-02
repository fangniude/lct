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
 * The SysCommuTableMBean class.
 * Created by QuickDVM
 */
public class SysCommuTableMBean extends SnmpMibBean {
    public static final String utsSysCommunityIndex = "utsSysCommunityIndex";
    public static final String utsSysCommunityString = "utsSysCommunityString";
    public static final String utsSysCommunityAccess = "utsSysCommunityAccess";


    public SysCommuTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsSysCommunityIndex, new SnmpMibBeanProperty(utsSysCommunityIndex, ".1.3.6.1.4.1.45121.1800.2.1.1.4.7.1.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsSysCommunityString, new SnmpMibBeanProperty(utsSysCommunityString, ".1.3.6.1.4.1.45121.1800.2.1.1.4.7.1.1.1.3", ISnmpConstant.STRING));
        initProperty(utsSysCommunityAccess, new SnmpMibBeanProperty(utsSysCommunityAccess, ".1.3.6.1.4.1.45121.1800.2.1.1.4.7.1.1.1.4", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.1.1.4.7.1.1.1.5", ISnmpConstant.INTEGER));

    }


    public Integer getUtsSysCommunityIndex() {
        return (Integer) getIndex(0);
    }

    public void setUtsSysCommunityIndex(Integer aUtsSysCommunityIndex) {
        setIndex(0, aUtsSysCommunityIndex);
    }


    public String getUtsSysCommunityString() {
        return (String) getProperty(utsSysCommunityString).getValue();
    }

    public void setUtsSysCommunityString(String aUtsSysCommunityString) {
        getProperty(utsSysCommunityString).setValue(aUtsSysCommunityString);
    }

    public Integer getUtsSysCommunityAccess() {
        return (Integer) getProperty(utsSysCommunityAccess).getValue();
    }

    public void setUtsSysCommunityAccess(Integer aUtsSysCommunityAccess) {
        getProperty(utsSysCommunityAccess).setValue(aUtsSysCommunityAccess);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsSysCommunityString));
        prepareRead(super.getProperty(utsSysCommunityAccess));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsSysCommunityString));
        prepareRead(super.getProperty(utsSysCommunityAccess));


        return loadAll(new int[] {1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsSysCommunityString));
        prepareSave(getProperty(utsSysCommunityAccess));


        return save();
    }

     public boolean add() throws MibBeanException {
         prepareSave(getProperty(utsSysCommunityString));
        prepareSave(getProperty(utsSysCommunityAccess));
         super.setRowStatus(new Integer(5));
         prepareSave(getProperty(ROW_STATUS));
         save();
        return true;
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}

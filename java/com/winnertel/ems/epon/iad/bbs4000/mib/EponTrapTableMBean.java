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
 * The EponTrapTableMBean class.
 * Created by QuickDVM
 */
public class EponTrapTableMBean extends SnmpMibBean {
    public static final String utsEponTrapDestIP = "utsEponTrapDestIP";
    public static final String utsEponTrapUDPPort = "utsEponTrapUDPPort";
    public static final String utsEponTrapCommunityString = "utsEponTrapCommunityString";


    public EponTrapTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsEponTrapDestIP, new SnmpMibBeanProperty(utsEponTrapDestIP, ".1.3.6.1.4.1.41355.1800.3.1.1.1.1.1.1", ISnmpConstant.IP_ADDRESS));
        initProperty(utsEponTrapUDPPort, new SnmpMibBeanProperty(utsEponTrapUDPPort, ".1.3.6.1.4.1.41355.1800.3.1.1.1.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsEponTrapCommunityString, new SnmpMibBeanProperty(utsEponTrapCommunityString, ".1.3.6.1.4.1.41355.1800.3.1.1.1.1.1.3", ISnmpConstant.STRING));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.3.1.1.1.1.1.4", ISnmpConstant.INTEGER));

    }


    public String getUtsEponTrapDestIP() {
        return (String) getIndex(0);
    }

    public void setUtsEponTrapDestIP(String aUtsEponTrapDestIP) {
        setIndex(0, aUtsEponTrapDestIP);
    }


    public Integer getUtsEponTrapUDPPort() {
        return (Integer) getProperty(utsEponTrapUDPPort).getValue();
    }

    public void setUtsEponTrapUDPPort(Integer aUtsEponTrapUDPPort) {
        getProperty(utsEponTrapUDPPort).setValue(aUtsEponTrapUDPPort);
    }

    public String getUtsEponTrapCommunityString() {
        return (String) getProperty(utsEponTrapCommunityString).getValue();
    }

    public void setUtsEponTrapCommunityString(String aUtsEponTrapCommunityString) {
        getProperty(utsEponTrapCommunityString).setValue(aUtsEponTrapCommunityString);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsEponTrapDestIP));
        prepareRead(super.getProperty(utsEponTrapUDPPort));
        prepareRead(super.getProperty(utsEponTrapCommunityString));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsEponTrapDestIP));
        prepareRead(super.getProperty(utsEponTrapUDPPort));
        prepareRead(super.getProperty(utsEponTrapCommunityString));


        return loadAll(new int[]{1 });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsEponTrapDestIP));
        prepareSave(getProperty(utsEponTrapUDPPort));
        prepareSave(getProperty(utsEponTrapCommunityString));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsEponTrapDestIP));
        prepareSave(getProperty(utsEponTrapUDPPort));
        prepareSave(getProperty(utsEponTrapCommunityString));
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


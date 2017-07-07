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
 * The MonitorSessionControlTableMBean class.
 * Created by QuickDVM
 */
public class MonitorSessionControlTableMBean extends SnmpMibBean {
    public static final String utsMonitorSessionID = "utsMonitorSessionID" ;
    public static final String utsMonitorSessionModule = "utsMonitorSessionModule";
    public static final String utsMonitorSessionPort = "utsMonitorSessionPort";
    public static final String utsMonitorSessionIngressPortBitLists = "utsMonitorSessionIngressPortBitLists";
    public static final String utsMonitorSessionEngressPortBitLists = "utsMonitorSessionEngressPortBitLists";
//    public static final String utsMonitorSessionActive = "utsMonitorSessionActive" ;

    public MonitorSessionControlTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty( utsMonitorSessionID, new SnmpMibBeanProperty( utsMonitorSessionID, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.2.1.5.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsMonitorSessionModule, new SnmpMibBeanProperty(utsMonitorSessionModule, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.2.1.5.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsMonitorSessionPort, new SnmpMibBeanProperty(utsMonitorSessionPort, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.2.1.5.3.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsMonitorSessionIngressPortBitLists, new SnmpMibBeanProperty(utsMonitorSessionIngressPortBitLists, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.2.1.5.3.1.1.4", ISnmpConstant.OCTETS));
        initProperty(utsMonitorSessionEngressPortBitLists, new SnmpMibBeanProperty(utsMonitorSessionEngressPortBitLists, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.2.1.5.3.1.1.5", ISnmpConstant.OCTETS));
//        initProperty( utsMonitorSessionActive, new SnmpMibBeanProperty( utsMonitorSessionActive, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.2.1.5.3.1.1.6", ISnmpConstant.INTEGER));
        initProperty( ROW_STATUS, new SnmpMibBeanProperty( ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.2.1.5.3.1.1.7", ISnmpConstant.INTEGER));
    }
    public Integer getUtsMonitorSessionID() {
            return ( Integer)  getIndex(0);
    }
    public void setUtsMonitorSessionID( Integer aUtsMonitorSessionID ) {
             setIndex(0, aUtsMonitorSessionID);
    }

     public Integer getUtsMonitorSessionModule() {
         return (Integer) getProperty(utsMonitorSessionModule).getValue();
     }

    public void setUtsMonitorSessionModule(Integer aUtsMonitorSessionModule) {
        getProperty(utsMonitorSessionModule).setValue(aUtsMonitorSessionModule);
    }

    public Integer getUtsMonitorSessionPort() {
        return (Integer) getProperty(utsMonitorSessionPort).getValue();
    }

    public void setUtsMonitorSessionPort(Integer aUtsMonitorSessionPort) {
        getProperty(utsMonitorSessionPort).setValue(aUtsMonitorSessionPort);
    }


    public byte[] getUtsMonitorSessionIngressPortBitLists() {
        return (byte[]) getProperty(utsMonitorSessionIngressPortBitLists).getValue();
    }

    public void setUtsMonitorSessionIngressPortBitLists(byte[] aUtsMonitorSessionIngressPortBitLists) {
        getProperty(utsMonitorSessionIngressPortBitLists).setValue(aUtsMonitorSessionIngressPortBitLists);
    }

    public byte[] getUtsMonitorSessionEngressPortBitLists() {
        return (byte[])getProperty(utsMonitorSessionEngressPortBitLists).getValue();
    }

    public void setUtsMonitorSessionEngressPortBitLists(byte[] aUtsMonitorSessionEngressPortBitLists) {
        getProperty(utsMonitorSessionEngressPortBitLists).setValue(aUtsMonitorSessionEngressPortBitLists);
    }
//    public Integer getUtsMonitorSessionActive(){
//        return ( Integer) getProperty( utsMonitorSessionActive ).getValue();
//    }
//    public void setUtsMonitorSessionActive( Integer aUtsMonitorSessionActive ) {
//        getProperty( utsMonitorSessionActive ).setValue( aUtsMonitorSessionActive );
//    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsMonitorSessionModule));
        prepareRead(super.getProperty(utsMonitorSessionPort));
        prepareRead(super.getProperty(utsMonitorSessionIngressPortBitLists));
        prepareRead(super.getProperty(utsMonitorSessionEngressPortBitLists));
//        prepareRead(super.getProperty(utsMonitorSessionActive));
        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsMonitorSessionModule));
        prepareRead(super.getProperty(utsMonitorSessionPort));
        prepareRead(super.getProperty(utsMonitorSessionIngressPortBitLists));
        prepareRead(super.getProperty(utsMonitorSessionEngressPortBitLists));
//        prepareRead(super.getProperty(utsMonitorSessionActive));

        return loadAll(new int[]{1});
    }


    public boolean modify() throws MibBeanException {
//        prepareSave(getProperty(utsMonitorSessionID));
        prepareSave(getProperty(utsMonitorSessionModule));
        prepareSave(getProperty(utsMonitorSessionPort));
        prepareSave(getProperty(utsMonitorSessionIngressPortBitLists));
        prepareSave(getProperty(utsMonitorSessionEngressPortBitLists));
//        prepareSave(getProperty(utsMonitorSessionActive));
        return save();
    }
    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsMonitorSessionModule));
        prepareSave(getProperty(utsMonitorSessionPort));
        prepareSave(getProperty(utsMonitorSessionIngressPortBitLists));
        prepareSave(getProperty(utsMonitorSessionEngressPortBitLists));
//        prepareSave(getProperty(utsMonitorSessionActive));
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


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
 * The MSTPPortTableMBean class.
 * Created by QuickDVM
 */
public class MSTPPortTableMBean extends SnmpMibBean {
    public static final String mstpPortIndex = "mstpPortIndex";
    public static final String mstpPortAdminMACEnable = "mstpPortAdminMACEnable";
    public static final String mstpPortOperMACEnable = "mstpPortOperMACEnable";
//    public static final String mstpPortUpTime = "mstpPortUpTime";
    public static final String mstpPortAdminExternalPathCost = "mstpPortAdminExternalPathCost";
    public static final String mstpPortOperExternalPathCost = "mstpPortOperExternalPathCost";
    public static final String mstpPortAdminEdge = "mstpPortAdminEdge";
    public static final String mstpPortOperEdge = "mstpPortOperEdge";
//    public static final String mstpPortAutoEdge = "mstpPortAutoEdge";
    public static final String mstpPortAdminPointToPoint = "mstpPortAdminPointToPoint";
    public static final String mstpPortOperPointToPoint = "mstpPortOperPointToPoint";
    public static final String mstpPortHelloTime = "mstpPortHelloTime";
//    public static final String mstpPortAdminNonStp = "mstpPortAdminNonStp";
    public static final String mstpPortProtocolMigration = "mstpPortProtocolMigration";
//    public static final String mstpPortRxTcnBpduCounter = "mstpPortRxTcnBpduCounter";
//    public static final String mstpPortRxCfgBpduCounter = "mstpPortRxCfgBpduCounter";
//    public static final String mstpPortRxRstBpduCounter = "mstpPortRxRstBpduCounter";
//    public static final String mstpPortRxMstBpduCounter = "mstpPortRxMstBpduCounter";
//    public static final String mstpPortTxTcnBpduCounter = "mstpPortTxTcnBpduCounter";
//    public static final String mstpPortTxCfgBpduCounter = "mstpPortTxCfgBpduCounter";
//    public static final String mstpPortTxRstBpduCounter = "mstpPortTxRstBpduCounter";
//    public static final String mstpPortTxMstBpduCounter = "mstpPortTxMstBpduCounter";

    public MSTPPortTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(mstpPortIndex, new SnmpMibBeanProperty(mstpPortIndex, ".1.3.6.1.2.1.17.10.11.1.1", ISnmpConstant.INTEGER));
        initProperty(mstpPortAdminMACEnable, new SnmpMibBeanProperty(mstpPortAdminMACEnable, ".1.3.6.1.2.1.17.10.11.1.2", ISnmpConstant.INTEGER));
        initProperty(mstpPortOperMACEnable, new SnmpMibBeanProperty(mstpPortOperMACEnable, ".1.3.6.1.2.1.17.10.11.1.3", ISnmpConstant.INTEGER));
//        initProperty(mstpPortUpTime, new SnmpMibBeanProperty(mstpPortUpTime, ".1.3.6.1.2.1.17.10.11.1.4", ISnmpConstant.INTEGER));
        initProperty(mstpPortAdminExternalPathCost, new SnmpMibBeanProperty(mstpPortAdminExternalPathCost, ".1.3.6.1.2.1.17.10.11.1.5", ISnmpConstant.INTEGER));
        initProperty(mstpPortOperExternalPathCost, new SnmpMibBeanProperty(mstpPortOperExternalPathCost, ".1.3.6.1.2.1.17.10.11.1.6", ISnmpConstant.INTEGER));
        initProperty(mstpPortAdminEdge, new SnmpMibBeanProperty(mstpPortAdminEdge, ".1.3.6.1.2.1.17.10.11.1.7", ISnmpConstant.INTEGER));
        initProperty(mstpPortOperEdge, new SnmpMibBeanProperty(mstpPortOperEdge, ".1.3.6.1.2.1.17.10.11.1.8", ISnmpConstant.INTEGER));
//        initProperty(mstpPortAutoEdge, new SnmpMibBeanProperty(mstpPortAutoEdge, ".1.3.6.1.2.1.17.10.11.1.9", ISnmpConstant.INTEGER));
        initProperty(mstpPortAdminPointToPoint, new SnmpMibBeanProperty(mstpPortAdminPointToPoint, ".1.3.6.1.2.1.17.10.11.1.10", ISnmpConstant.INTEGER));
        initProperty(mstpPortOperPointToPoint, new SnmpMibBeanProperty(mstpPortOperPointToPoint, ".1.3.6.1.2.1.17.10.11.1.11", ISnmpConstant.INTEGER));
        initProperty(mstpPortHelloTime, new SnmpMibBeanProperty(mstpPortHelloTime, ".1.3.6.1.2.1.17.10.11.1.12", ISnmpConstant.INTEGER));
//        initProperty(mstpPortAdminNonStp, new SnmpMibBeanProperty(mstpPortAdminNonStp, ".1.3.6.1.2.1.17.10.11.1.13", ISnmpConstant.INTEGER));
        initProperty(mstpPortProtocolMigration, new SnmpMibBeanProperty(mstpPortProtocolMigration, ".1.3.6.1.2.1.17.10.11.1.14", ISnmpConstant.INTEGER));

//        initProperty(mstpPortRxTcnBpduCounter, new SnmpMibBeanProperty(mstpPortRxTcnBpduCounter, ".1.3.6.1.2.1.17.10.11.1.15", ISnmpConstant.INTEGER));
//        initProperty(mstpPortRxCfgBpduCounter, new SnmpMibBeanProperty(mstpPortRxCfgBpduCounter, ".1.3.6.1.2.1.17.10.11.1.16", ISnmpConstant.INTEGER));
//        initProperty(mstpPortRxRstBpduCounter, new SnmpMibBeanProperty(mstpPortRxRstBpduCounter, ".1.3.6.1.2.1.17.10.11.1.17", ISnmpConstant.INTEGER));
//        initProperty(mstpPortRxMstBpduCounter, new SnmpMibBeanProperty(mstpPortRxMstBpduCounter, ".1.3.6.1.2.1.17.10.11.1.18", ISnmpConstant.INTEGER));
//        initProperty(mstpPortTxTcnBpduCounter, new SnmpMibBeanProperty(mstpPortTxTcnBpduCounter, ".1.3.6.1.2.1.17.10.11.1.19", ISnmpConstant.INTEGER));
//        initProperty(mstpPortTxCfgBpduCounter, new SnmpMibBeanProperty(mstpPortTxCfgBpduCounter, ".1.3.6.1.2.1.17.10.11.1.20", ISnmpConstant.INTEGER));
//        initProperty(mstpPortTxRstBpduCounter, new SnmpMibBeanProperty(mstpPortTxRstBpduCounter, ".1.3.6.1.2.1.17.10.11.1.21", ISnmpConstant.INTEGER));
//        initProperty(mstpPortTxMstBpduCounter, new SnmpMibBeanProperty(mstpPortTxMstBpduCounter, ".1.3.6.1.2.1.17.10.11.1.22", ISnmpConstant.INTEGER));

    }


    public String getMstpPortIndex() {
        Integer index =  (Integer) getIndex(0);
        String strindex = "";
        if(index.intValue()<=48) {
            if(index.intValue()%4 == 0){
            strindex = new String(((index.intValue()/4))+"/"+4);
            }
            else{
                strindex = new String(((index.intValue()/4)+1)+"/"+(index.intValue()%4));
            }
        }
        else{
            strindex = "lg"+(index.intValue()-48);
        }
        return strindex;
    }

    public void setMstpPortIndex(Integer aMstpPortIndex) {
        setIndex(0, aMstpPortIndex);
    }


    public Integer getMstpPortAdminMACEnable() {
        return (Integer) getProperty(mstpPortAdminMACEnable).getValue();
    }

    public void setMstpPortAdminMACEnable(Integer aMstpPortAdminMACEnable) {
        getProperty(mstpPortAdminMACEnable).setValue(aMstpPortAdminMACEnable);
    }

    public Integer getMstpPortOperMACEnable() {
        return (Integer) getProperty(mstpPortOperMACEnable).getValue();
    }

    public void setMstpPortOperMACEnable(Integer aMstpPortOperMACEnable) {
        getProperty(mstpPortOperMACEnable).setValue(aMstpPortOperMACEnable);
    }

//    public Long getMstpPortUpTime() {
//        return (Long) getProperty(mstpPortUpTime).getValue();
//    }
//
//    public void setMstpPortUpTime(Long aMstpPortUpTime) {
//        getProperty(mstpPortUpTime).setValue(aMstpPortUpTime);
//    }

    public Integer getMstpPortAdminExternalPathCost() {
        return (Integer) getProperty(mstpPortAdminExternalPathCost).getValue();
    }

    public void setMstpPortAdminExternalPathCost(Integer aMstpPortAdminExternalPathCost) {
        getProperty(mstpPortAdminExternalPathCost).setValue(aMstpPortAdminExternalPathCost);
    }

    public Integer getMstpPortOperExternalPathCost() {
        return (Integer) getProperty(mstpPortOperExternalPathCost).getValue();
    }

    public void setMstpPortOperExternalPathCost(Integer aMstpPortOperExternalPathCost) {
        getProperty(mstpPortOperExternalPathCost).setValue(aMstpPortOperExternalPathCost);
    }

    public Integer getMstpPortAdminEdge() {
        return (Integer) getProperty(mstpPortAdminEdge).getValue();
    }

    public void setMstpPortAdminEdge(Integer aMstpPortAdminEdge) {
        getProperty(mstpPortAdminEdge).setValue(aMstpPortAdminEdge);
    }

    public Integer getMstpPortOperEdge() {
        return (Integer) getProperty(mstpPortOperEdge).getValue();
    }

    public void setMstpPortOperEdge(Integer aMstpPortOperEdge) {
        getProperty(mstpPortOperEdge).setValue(aMstpPortOperEdge);
    }

//    public Integer getMstpPortAutoEdge() {
//        return (Integer) getProperty(mstpPortAutoEdge).getValue();
//    }
//
//    public void setMstpPortAutoEdge(Integer aMstpPortAutoEdge) {
//        getProperty(mstpPortAutoEdge).setValue(aMstpPortAutoEdge);
//    }

    public Integer getMstpPortAdminPointToPoint() {
        return (Integer) getProperty(mstpPortAdminPointToPoint).getValue();
    }

    public void setMstpPortAdminPointToPoint(Integer aMstpPortAdminPointToPoint) {
        getProperty(mstpPortAdminPointToPoint).setValue(aMstpPortAdminPointToPoint);
    }

    public Integer getMstpPortOperPointToPoint() {
        return (Integer) getProperty(mstpPortOperPointToPoint).getValue();
    }

    public void setMstpPortOperPointToPoint(Integer aMstpPortOperPointToPoint) {
        getProperty(mstpPortOperPointToPoint).setValue(aMstpPortOperPointToPoint);
    }

    public Integer getMstpPortHelloTime() {
        return (Integer) getProperty(mstpPortHelloTime).getValue();
    }

    public void setMstpPortHelloTime(Integer aMstpPortHelloTime) {
        getProperty(mstpPortHelloTime).setValue(aMstpPortHelloTime);
    }

//    public Integer getMstpPortAdminNonStp() {
//        return (Integer) getProperty(mstpPortAdminNonStp).getValue();
//    }
//
//    public void setMstpPortAdminNonStp(Integer aMstpPortAdminNonStp) {
//        getProperty(mstpPortAdminNonStp).setValue(aMstpPortAdminNonStp);
//    }

    public Integer getMstpPortProtocolMigration() {
        return (Integer) getProperty(mstpPortProtocolMigration).getValue();
    }

    public void setMstpPortProtocolMigration(Integer aMstpPortProtocolMigration) {
        getProperty(mstpPortProtocolMigration).setValue(aMstpPortProtocolMigration);
    }

//    public Integer getMstpPortRxTcnBpduCounter() {
//        return (Integer) getProperty(mstpPortRxTcnBpduCounter).getValue();
//    }
//
//    public void setMstpPortRxTcnBpduCounter(Integer aMstpPortRxTcnBpduCounter) {
//        getProperty(mstpPortRxTcnBpduCounter).setValue(aMstpPortRxTcnBpduCounter);
//    }
//
//    public Long getMstpPortRxCfgBpduCounter() {
//        return (Long) getProperty(mstpPortRxCfgBpduCounter).getValue();
//    }
//
//    public void setMstpPortRxCfgBpduCounter(Long aMstpPortRxCfgBpduCounter) {
//        getProperty(mstpPortRxCfgBpduCounter).setValue(aMstpPortRxCfgBpduCounter);
//    }
//
//    public Long getMstpPortRxRstBpduCounter() {
//        return (Long) getProperty(mstpPortRxRstBpduCounter).getValue();
//    }
//
//    public void setMstpPortRxRstBpduCounter(Long aMstpPortRxRstBpduCounter) {
//        getProperty(mstpPortRxRstBpduCounter).setValue(aMstpPortRxRstBpduCounter);
//    }
//
//    public Long getMstpPortRxMstBpduCounter() {
//        return (Long) getProperty(mstpPortRxMstBpduCounter).getValue();
//    }
//
//    public void setMstpPortRxMstBpduCounter(Long aMstpPortRxMstBpduCounter) {
//        getProperty(mstpPortRxMstBpduCounter).setValue(aMstpPortRxMstBpduCounter);
//    }
//
//    public Long getMstpPortTxTcnBpduCounter() {
//        return (Long) getProperty(mstpPortTxTcnBpduCounter).getValue();
//    }
//
//    public void setMstpPortTxTcnBpduCounter(Long aMstpPortTxTcnBpduCounter) {
//        getProperty(mstpPortTxTcnBpduCounter).setValue(aMstpPortTxTcnBpduCounter);
//    }
//
//    public Long getMstpPortTxCfgBpduCounter() {
//        return (Long) getProperty(mstpPortTxCfgBpduCounter).getValue();
//    }
//
//    public void setMstpPortTxCfgBpduCounter(Long aMstpPortTxCfgBpduCounter) {
//        getProperty(mstpPortTxCfgBpduCounter).setValue(aMstpPortTxCfgBpduCounter);
//    }
//
//    public Long getMstpPortTxRstBpduCounter() {
//        return (Long) getProperty(mstpPortTxRstBpduCounter).getValue();
//    }
//
//    public void setMstpPortTxRstBpduCounter(Long aMstpPortTxRstBpduCounter) {
//        getProperty(mstpPortTxRstBpduCounter).setValue(aMstpPortTxRstBpduCounter);
//    }
//
//    public Long getMstpPortTxMstBpduCounter() {
//        return (Long) getProperty(mstpPortTxMstBpduCounter).getValue();
//    }
//
//    public void setMstpPortTxMstBpduCounter(Long aMstpPortTxMstBpduCounter) {
//        getProperty(mstpPortTxMstBpduCounter).setValue(aMstpPortTxMstBpduCounter);
//    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(mstpPortAdminMACEnable));
        prepareRead(super.getProperty(mstpPortOperMACEnable));
//        prepareRead(super.getProperty(mstpPortUpTime));
        prepareRead(super.getProperty(mstpPortAdminExternalPathCost));
        prepareRead(super.getProperty(mstpPortOperExternalPathCost));
        prepareRead(super.getProperty(mstpPortAdminEdge));
        prepareRead(super.getProperty(mstpPortOperEdge));
//        prepareRead(super.getProperty(mstpPortAutoEdge));
        prepareRead(super.getProperty(mstpPortAdminPointToPoint));
        prepareRead(super.getProperty(mstpPortOperPointToPoint));
        prepareRead(super.getProperty(mstpPortHelloTime));
//        prepareRead(super.getProperty(mstpPortAdminNonStp));
        prepareRead(super.getProperty(mstpPortProtocolMigration));
//        prepareRead(super.getProperty(mstpPortRxTcnBpduCounter));
//        prepareRead(super.getProperty(mstpPortRxCfgBpduCounter));
//        prepareRead(super.getProperty(mstpPortRxRstBpduCounter));
//        prepareRead(super.getProperty(mstpPortRxMstBpduCounter));
//        prepareRead(super.getProperty(mstpPortTxTcnBpduCounter));
//        prepareRead(super.getProperty(mstpPortTxCfgBpduCounter));
//        prepareRead(super.getProperty(mstpPortTxRstBpduCounter));
//        prepareRead(super.getProperty(mstpPortTxMstBpduCounter));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(mstpPortAdminMACEnable));
        prepareRead(super.getProperty(mstpPortOperMACEnable));
//        prepareRead(super.getProperty(mstpPortUpTime));
        prepareRead(super.getProperty(mstpPortAdminExternalPathCost));
        prepareRead(super.getProperty(mstpPortOperExternalPathCost));
        prepareRead(super.getProperty(mstpPortAdminEdge));
        prepareRead(super.getProperty(mstpPortOperEdge));
//        prepareRead(super.getProperty(mstpPortAutoEdge));
        prepareRead(super.getProperty(mstpPortAdminPointToPoint));
        prepareRead(super.getProperty(mstpPortOperPointToPoint));
        prepareRead(super.getProperty(mstpPortHelloTime));
//        prepareRead(super.getProperty(mstpPortAdminNonStp));
        prepareRead(super.getProperty(mstpPortProtocolMigration));
//        prepareRead(super.getProperty(mstpPortRxTcnBpduCounter));
//        prepareRead(super.getProperty(mstpPortRxCfgBpduCounter));
//        prepareRead(super.getProperty(mstpPortRxRstBpduCounter));
//        prepareRead(super.getProperty(mstpPortRxMstBpduCounter));
//        prepareRead(super.getProperty(mstpPortTxTcnBpduCounter));
//        prepareRead(super.getProperty(mstpPortTxCfgBpduCounter));
//        prepareRead(super.getProperty(mstpPortTxRstBpduCounter));
//        prepareRead(super.getProperty(mstpPortTxMstBpduCounter));

        return loadAll(new int[]{1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(mstpPortAdminMACEnable));
        prepareSave(getProperty(mstpPortAdminExternalPathCost));
        prepareSave(getProperty(mstpPortAdminEdge));
//        prepareSave(getProperty(mstpPortAutoEdge));
        prepareSave(getProperty(mstpPortAdminPointToPoint));
        prepareSave(getProperty(mstpPortHelloTime));
//        prepareSave(getProperty(mstpPortAdminNonStp));
        prepareSave(getProperty(mstpPortProtocolMigration));

        return save();
    }


}

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
 * The AlarmModelTableMBean class.
 * Created by QuickDVM
 */
public class AlarmModelTableMBean extends SnmpMibBean {
    public static final String utAlarmModelOID = "utAlarmModelOID";
    public static final String utAlarmModelSeverity = "utAlarmModelSeverity";
    public static final String utAlarmModelType = "utAlarmModelType";
    public static final String utAlarmModelProbableCause = "utAlarmModelProbableCause";
    public static final String utAlarmModelClearType = "utAlarmModelClearType";
    public static final String utAlarmModelResourceType = "utAlarmModelResourceType";
    public static final String utAlarmModelFilteredFlag = "utAlarmModelFilteredFlag";

    public AlarmModelTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utAlarmModelOID, new SnmpMibBeanProperty(utAlarmModelOID, ".1.3.6.1.4.1.45121.1800.3.1.1.4.1.1.1", ISnmpConstant.OBJID));
        initProperty(utAlarmModelSeverity, new SnmpMibBeanProperty(utAlarmModelSeverity, ".1.3.6.1.4.1.45121.1800.3.1.1.4.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utAlarmModelType, new SnmpMibBeanProperty(utAlarmModelType, ".1.3.6.1.4.1.45121.1800.3.1.1.4.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utAlarmModelProbableCause, new SnmpMibBeanProperty(utAlarmModelProbableCause, ".1.3.6.1.4.1.45121.1800.3.1.1.4.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utAlarmModelClearType, new SnmpMibBeanProperty(utAlarmModelClearType, ".1.3.6.1.4.1.45121.1800.3.1.1.4.1.1.5", ISnmpConstant.INTEGER));
        initProperty(utAlarmModelResourceType, new SnmpMibBeanProperty(utAlarmModelResourceType, ".1.3.6.1.4.1.45121.1800.3.1.1.4.1.1.6", ISnmpConstant.INTEGER));
        initProperty(utAlarmModelFilteredFlag, new SnmpMibBeanProperty(utAlarmModelFilteredFlag, ".1.3.6.1.4.1.45121.1800.3.1.1.4.1.1.7", ISnmpConstant.INTEGER));

    }


    public String getUtAlarmModelOID() {

        String temp = String.valueOf(getIndex(0));
         return temp;
    }

    public void setUtAlarmModelOID(String aUtAlarmModelOID) {
        setIndex(0, aUtAlarmModelOID);
    }


    public Integer getUtAlarmModelSeverity() {
        return (Integer) getProperty(utAlarmModelSeverity).getValue();
    }

    public void setUtAlarmModelSeverity(Integer aUtAlarmModelSeverity) {
        getProperty(utAlarmModelSeverity).setValue(aUtAlarmModelSeverity);
    }

    public Integer getUtAlarmModelType() {
        return (Integer) getProperty(utAlarmModelType).getValue();
    }

    public void setUtAlarmModelType(Integer aUtAlarmModelType) {
        getProperty(utAlarmModelType).setValue(aUtAlarmModelType);
    }

    public Integer getUtAlarmModelProbableCause() {
        return (Integer) getProperty(utAlarmModelProbableCause).getValue();
    }

    public void setUtAlarmModelProbableCause(Integer aUtAlarmModelProbableCause) {
        getProperty(utAlarmModelProbableCause).setValue(aUtAlarmModelProbableCause);
    }

    public Integer getUtAlarmModelClearType() {
        return (Integer) getProperty(utAlarmModelClearType).getValue();
    }

    public void setUtAlarmModelClearType(Integer aUtAlarmModelClearType) {
        getProperty(utAlarmModelClearType).setValue(aUtAlarmModelClearType);
    }

    public Integer getUtAlarmModelResourceType() {
        return (Integer) getProperty(utAlarmModelResourceType).getValue();
    }

    public void setUtAlarmModelResourceType(Integer aUtAlarmModelResourceType) {
        getProperty(utAlarmModelResourceType).setValue(aUtAlarmModelResourceType);
    }

    public Integer getUtAlarmModelFilteredFlag() {
        return (Integer) getProperty(utAlarmModelFilteredFlag).getValue();
    }

    public void setUtAlarmModelFilteredFlag(Integer aUtAlarmModelFilteredFlag) {
        getProperty(utAlarmModelFilteredFlag).setValue(aUtAlarmModelFilteredFlag);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utAlarmModelSeverity));
        prepareRead(super.getProperty(utAlarmModelType));
        prepareRead(super.getProperty(utAlarmModelProbableCause));
        prepareRead(super.getProperty(utAlarmModelClearType));
        prepareRead(super.getProperty(utAlarmModelResourceType));
        prepareRead(super.getProperty(utAlarmModelFilteredFlag));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utAlarmModelSeverity));
        prepareRead(super.getProperty(utAlarmModelType));
        prepareRead(super.getProperty(utAlarmModelProbableCause));
        prepareRead(super.getProperty(utAlarmModelClearType));
        prepareRead(super.getProperty(utAlarmModelResourceType));
        prepareRead(super.getProperty(utAlarmModelFilteredFlag));

        return loadAll(new int[]{0});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utAlarmModelSeverity));
        prepareSave(getProperty(utAlarmModelType));
        prepareSave(getProperty(utAlarmModelFilteredFlag));

        return save();
    }

     public boolean add() throws MibBeanException {
        prepareSave(super.getProperty(utAlarmModelSeverity));
        prepareSave(super.getProperty(utAlarmModelType));
        prepareSave(super.getProperty(utAlarmModelProbableCause));
        prepareSave(super.getProperty(utAlarmModelClearType));
        prepareSave(super.getProperty(utAlarmModelResourceType));
        prepareSave(super.getProperty(utAlarmModelFilteredFlag));
        super.setRowStatus(new Integer(5));
        prepareSave(getProperty(ROW_STATUS));
        save();
        return true;
    }



}

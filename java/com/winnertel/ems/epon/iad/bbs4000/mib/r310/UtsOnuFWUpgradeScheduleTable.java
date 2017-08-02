/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The UtsOnuFWUpgradeScheduleTable class. Created by QuickDVM
 */
public class UtsOnuFWUpgradeScheduleTable extends SnmpMibBean {
    public static final String utsOnuFWUpgradeScheduleTime = "utsOnuFWUpgradeScheduleTime";
    public static final String utsOnuFWUpgradeScheduleDuration = "utsOnuFWUpgradeScheduleDuration";
    public static final String utsOnuFWUpgradeScheduleOnuList = "utsOnuFWUpgradeScheduleOnuList";
    public static final String utsOnuFWUpgradeScheduleUpgradeAction = "utsOnuFWUpgradeScheduleUpgradeAction";
    public static final String utsOnuFWUpgradeScheduleCurrentStatus = "utsOnuFWUpgradeScheduleCurrentStatus";

    public UtsOnuFWUpgradeScheduleTable(ISnmpProxy aSnmpProxy) {
	super(aSnmpProxy);
	init();
    }

    protected void init() {
	initProperty(utsOnuFWUpgradeScheduleTime, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleTime, ".1.3.6.1.4.1.45121.1800.2.3.1.7.13.1.1", ISnmpConstant.OCTETS));
	initProperty(utsOnuFWUpgradeScheduleDuration, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleDuration, ".1.3.6.1.4.1.45121.1800.2.3.1.7.13.1.2", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeScheduleOnuList, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleOnuList, ".1.3.6.1.4.1.45121.1800.2.3.1.7.13.1.3", ISnmpConstant.OCTETS));
	initProperty(utsOnuFWUpgradeScheduleUpgradeAction, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleUpgradeAction, ".1.3.6.1.4.1.45121.1800.2.3.1.7.13.1.4", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeScheduleCurrentStatus, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleCurrentStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.7.13.1.5", ISnmpConstant.STRING));
	initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.7.13.1.100", ISnmpConstant.INTEGER));

    }

    public byte[] getUtsOnuFWUpgradeScheduleTime() {
//	byte[] result = new byte[11];
//	for (int i = 0; i < result.length; i++) {
//	    int intValue = (Integer) getIndex(i);
//	    result[i] = (byte) intValue;
//
//	}
	return (byte[]) getIndex(0);
    }

    public void setUtsOnuFWUpgradeScheduleTime(byte[] aUtsOnuFWUpgradeScheduleTime) {
//	for (int i = 0; i < aUtsOnuFWUpgradeScheduleTime.length; i++) {
//	    byte b = aUtsOnuFWUpgradeScheduleTime[i];
//	    setIndex(i, b);
//	}
	setIndex(0, aUtsOnuFWUpgradeScheduleTime);
    }

    public Integer getUtsOnuFWUpgradeScheduleDuration() {
	return (Integer) getProperty(utsOnuFWUpgradeScheduleDuration).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleDuration(Integer aUtsOnuFWUpgradeScheduleDuration) {
	getProperty(utsOnuFWUpgradeScheduleDuration).setValue(aUtsOnuFWUpgradeScheduleDuration);
    }

    public byte[] getUtsOnuFWUpgradeScheduleOnuList() {
	return (byte[]) getProperty(utsOnuFWUpgradeScheduleOnuList).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleOnuList(byte[] aUtsOnuFWUpgradeScheduleOnuList) {
	getProperty(utsOnuFWUpgradeScheduleOnuList).setValue(aUtsOnuFWUpgradeScheduleOnuList);
    }

    public Integer getUtsOnuFWUpgradeScheduleUpgradeAction() {
	return (Integer) getProperty(utsOnuFWUpgradeScheduleUpgradeAction).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleUpgradeAction(Integer aUtsOnuFWUpgradeScheduleUpgradeAction) {
	getProperty(utsOnuFWUpgradeScheduleUpgradeAction).setValue(aUtsOnuFWUpgradeScheduleUpgradeAction);
    }

    public String getUtsOnuFWUpgradeScheduleCurrentStatus() {
	return (String) getProperty(utsOnuFWUpgradeScheduleCurrentStatus).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleCurrentStatus(String aUtsOnuFWUpgradeScheduleCurrentStatus) {
	getProperty(utsOnuFWUpgradeScheduleCurrentStatus).setValue(aUtsOnuFWUpgradeScheduleCurrentStatus);
    }

    public boolean retrieve() throws MibBeanException {
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleDuration));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleOnuList));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleUpgradeAction));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleCurrentStatus));

	return load();
    }

    public Vector retrieveAll() throws MibBeanException {
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleDuration));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleOnuList));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleUpgradeAction));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleCurrentStatus));

	return loadAll(new int[] { 11 });
    }

    public boolean modify() throws MibBeanException {
	prepareSave(getProperty(utsOnuFWUpgradeScheduleDuration));
	prepareSave(getProperty(utsOnuFWUpgradeScheduleOnuList));
	prepareSave(getProperty(utsOnuFWUpgradeScheduleUpgradeAction));

	return save();
    }

    public boolean add() throws MibBeanException {
	prepareSave(getProperty(utsOnuFWUpgradeScheduleDuration));
	prepareSave(getProperty(utsOnuFWUpgradeScheduleOnuList));
	prepareSave(getProperty(utsOnuFWUpgradeScheduleUpgradeAction));

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

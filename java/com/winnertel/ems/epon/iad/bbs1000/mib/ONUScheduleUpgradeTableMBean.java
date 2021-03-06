package com.winnertel.ems.epon.iad.bbs1000.mib;


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
 * The ONUScheduleUpgradeTableMBean class.
 * Created by QuickDVM
 */
public class ONUScheduleUpgradeTableMBean extends SnmpMibBean {
    public static final String utsDot3OnuFWUpgradeStartingHour = "utsDot3OnuFWUpgradeStartingHour";
    public static final String utsDot3OnuFWUpgradeStartingMinute = "utsDot3OnuFWUpgradeStartingMinute";
    public static final String utsDot3OnuFWUpgradeDuration = "utsDot3OnuFWUpgradeDuration";
    public static final String utsDot3OnuFWUpgradePortListBitMap = "utsDot3OnuFWUpgradePortListBitMap";
    public static final String utsDot3OnuFWUpgradeOption = "utsDot3OnuFWUpgradeOption";

    public ONUScheduleUpgradeTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuFWUpgradeStartingHour, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeStartingHour, ".1.3.6.1.4.1.45121.1800.2.3.1.7.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeStartingMinute, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeStartingMinute, ".1.3.6.1.4.1.45121.1800.2.3.1.7.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeDuration, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeDuration, ".1.3.6.1.4.1.45121.1800.2.3.1.7.3.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradePortListBitMap, new SnmpMibBeanProperty(utsDot3OnuFWUpgradePortListBitMap, ".1.3.6.1.4.1.45121.1800.2.3.1.7.3.1.1.5", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuFWUpgradeOption, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeOption, ".1.3.6.1.4.1.45121.1800.2.3.1.7.3.1.1.6", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.7.3.1.1.7", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuFWUpgradeStartingHour() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuFWUpgradeStartingHour(Integer aUtsDot3OnuFWUpgradeStartingHour) {
        setIndex(0, aUtsDot3OnuFWUpgradeStartingHour);
    }

    public Integer getUtsDot3OnuFWUpgradeStartingMinute() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuFWUpgradeStartingMinute(Integer aUtsDot3OnuFWUpgradeStartingMinute) {
        setIndex(1, aUtsDot3OnuFWUpgradeStartingMinute);
    }

    public Integer getUtsDot3OnuFWUpgradeDuration() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeDuration).getValue();
    }

    public void setUtsDot3OnuFWUpgradeDuration(Integer aUtsDot3OnuFWUpgradeDuration) {
        getProperty(utsDot3OnuFWUpgradeDuration).setValue(aUtsDot3OnuFWUpgradeDuration);
    }

    public byte[] getUtsDot3OnuFWUpgradePortListBitMap() {
        return (byte[]) getProperty(utsDot3OnuFWUpgradePortListBitMap).getValue();
    }

    public void setUtsDot3OnuFWUpgradePortListBitMap(byte[] aUtsDot3OnuFWUpgradePortListBitMap) {
        getProperty(utsDot3OnuFWUpgradePortListBitMap).setValue(aUtsDot3OnuFWUpgradePortListBitMap);
    }

    public Integer getUtsDot3OnuFWUpgradeOption() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeOption).getValue();
    }

    public void setUtsDot3OnuFWUpgradeOption(Integer aUtsDot3OnuFWUpgradeOption) {
        getProperty(utsDot3OnuFWUpgradeOption).setValue(aUtsDot3OnuFWUpgradeOption);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeDuration));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradePortListBitMap));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeOption));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeDuration));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradePortListBitMap));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeOption));

        return loadAll(new int[]{1, 1});
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuFWUpgradeStartingHour));
        prepareSave(getProperty(utsDot3OnuFWUpgradeStartingMinute));
        prepareSave(getProperty(utsDot3OnuFWUpgradeDuration));
        prepareSave(getProperty(utsDot3OnuFWUpgradePortListBitMap));
        prepareSave(getProperty(utsDot3OnuFWUpgradeOption));
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        ONUUpgradePortListGroup group = new ONUUpgradePortListGroup(fSnmpProxy);
        group.enableScheduleUpgradePortList();

        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }
}

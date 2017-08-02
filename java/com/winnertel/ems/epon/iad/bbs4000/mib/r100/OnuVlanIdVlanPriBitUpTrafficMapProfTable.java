/**
 * Title          :   OnuVlanIdVlanPriBitUpTrafficMapProfTable.java
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
 *         Create on 2008-10-2
 *         Modify by HZ21044
 */

public class OnuVlanIdVlanPriBitUpTrafficMapProfTable extends SnmpMibBean {

    public static final String onuVlanIdVlanPriBitUpTrafficMapProfIndex1 = "onuVlanIdVlanPriBitUpTrafficMapProfIndex1";
    public static final String onuVlanIdVlanPriBitUpTrafficMapProfIndex2 = "onuVlanIdVlanPriBitUpTrafficMapProfIndex2";
    public static final String onuVlanIdVlanPriBitUpTrafficMapProfileName = "onuVlanIdVlanPriBitUpTrafficMapProfileName";
    public static final String onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart = "onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart";
    public static final String onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop = "onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop";
    public static final String onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap = "onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap";
    public static final String onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo = "onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo";

    public OnuVlanIdVlanPriBitUpTrafficMapProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVlanIdVlanPriBitUpTrafficMapProfIndex1, new SnmpMibBeanProperty(onuVlanIdVlanPriBitUpTrafficMapProfIndex1, ".1.3.6.1.4.1.45121.1.3.10.5.2.9.1.1", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdVlanPriBitUpTrafficMapProfIndex2, new SnmpMibBeanProperty(onuVlanIdVlanPriBitUpTrafficMapProfIndex2, ".1.3.6.1.4.1.45121.1.3.10.5.2.9.1.2", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdVlanPriBitUpTrafficMapProfileName, new SnmpMibBeanProperty(onuVlanIdVlanPriBitUpTrafficMapProfileName, ".1.3.6.1.4.1.45121.1.3.10.5.2.9.1.3", ISnmpConstant.STRING));
        initProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart, new SnmpMibBeanProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart, ".1.3.6.1.4.1.45121.1.3.10.5.2.9.1.4", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop, new SnmpMibBeanProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop, ".1.3.6.1.4.1.45121.1.3.10.5.2.9.1.5", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap, new SnmpMibBeanProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap, ".1.3.6.1.4.1.45121.1.3.10.5.2.9.1.6", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo, new SnmpMibBeanProperty(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.9.1.7", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.2.9.1.8", ISnmpConstant.INTEGER));
    }

    public Long getOnuVlanIdVlanPriBitUpTrafficMapProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOnuVlanIdVlanPriBitUpTrafficMapProfIndex1(Long aOnuVlanIdVlanPriBitUpTrafficMapProfIndex1) {
        setIndex(0, aOnuVlanIdVlanPriBitUpTrafficMapProfIndex1);
    }

    public Long getOnuVlanIdVlanPriBitUpTrafficMapProfIndex2() {
        return (Long) getIndex(1);
    }

    public void setOnuVlanIdVlanPriBitUpTrafficMapProfIndex2(
            Long aOnuVlanIdVlanPriBitUpTrafficMapProfIndex2) {
        setIndex(1, aOnuVlanIdVlanPriBitUpTrafficMapProfIndex2);
    }

    public String getOnuVlanIdVlanPriBitUpTrafficMapProfileName() {
        return (String) getProperty(onuVlanIdVlanPriBitUpTrafficMapProfileName).getValue();
    }

    public void setOnuVlanIdVlanPriBitUpTrafficMapProfileName(String aOnuVlanIdVlanPriBitUpTrafficMapProfileName) {
        getProperty(onuVlanIdVlanPriBitUpTrafficMapProfileName).setValue(aOnuVlanIdVlanPriBitUpTrafficMapProfileName);
    }

    public Long getOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart() {
        return (Long) getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart).getValue();
    }

    public void setOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart(Long aOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart) {
        getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart).setValue(aOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart);
    }

    public Long getOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop() {
        return (Long) getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop).getValue();
    }

    public void setOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop(Long aOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop) {
        getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop).setValue(aOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop);
    }

    public Long getOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap() {
        return (Long) getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap).getValue();
    }

    public void setOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap(Long aOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap) {
        getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap).setValue(aOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap);
    }

    public Integer getOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo() {
        return (Integer) getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo).getValue();
    }

    public void setOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo(Integer aOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo) {
        getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo).setValue(aOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfileName));
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart));
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop));
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap));
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfileName));
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart));
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop));
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap));
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfileName));
        prepareSave(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart));
        prepareSave(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop));
        prepareSave(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap));
        prepareSave(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareRead(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfileName));
        prepareSave(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart));
        prepareSave(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop));
        prepareSave(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap));
        prepareSave(getProperty(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    //added by Zhou Chao, 2009/2/13
    public String toString() {
        return getOnuVlanIdVlanPriBitUpTrafficMapProfileName();
    }

}
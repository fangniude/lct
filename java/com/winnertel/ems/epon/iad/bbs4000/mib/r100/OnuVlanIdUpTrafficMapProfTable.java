/**
 * Title          :   OnuVlanIdUpTrafficMapProfTable.java
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

public class OnuVlanIdUpTrafficMapProfTable extends SnmpMibBean {

    public static final String onuVlanIdUpTrafficMapProfIndex1 = "onuVlanIdUpTrafficMapProfIndex1";
    public static final String onuVlanIdUpTrafficMapProfIndex2 = "onuVlanIdUpTrafficMapProfIndex2";
    public static final String onuVlanIdUpTrafficMapProfileName = "onuVlanIdUpTrafficMapProfileName";
    public static final String onuVlanIdUpTrafficMapProfVlanIDStart = "onuVlanIdUpTrafficMapProfVlanIDStart";
    public static final String onuVlanIdUpTrafficMapProfVlanIDStop = "onuVlanIdUpTrafficMapProfVlanIDStop";
    public static final String onuVlanIdUpTrafficMapProfVirtualPortNo = "onuVlanIdUpTrafficMapProfVirtualPortNo";

    public OnuVlanIdUpTrafficMapProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVlanIdUpTrafficMapProfIndex1, new SnmpMibBeanProperty(onuVlanIdUpTrafficMapProfIndex1, ".1.3.6.1.4.1.41355.1.3.10.5.2.8.1.1", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdUpTrafficMapProfIndex2, new SnmpMibBeanProperty(onuVlanIdUpTrafficMapProfIndex2, ".1.3.6.1.4.1.41355.1.3.10.5.2.8.1.2", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdUpTrafficMapProfileName, new SnmpMibBeanProperty(onuVlanIdUpTrafficMapProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.8.1.3", ISnmpConstant.STRING));
        initProperty(onuVlanIdUpTrafficMapProfVlanIDStart, new SnmpMibBeanProperty(onuVlanIdUpTrafficMapProfVlanIDStart, ".1.3.6.1.4.1.41355.1.3.10.5.2.8.1.4", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdUpTrafficMapProfVlanIDStop, new SnmpMibBeanProperty(onuVlanIdUpTrafficMapProfVlanIDStop, ".1.3.6.1.4.1.41355.1.3.10.5.2.8.1.5", ISnmpConstant.GAUGE));
        initProperty(onuVlanIdUpTrafficMapProfVirtualPortNo, new SnmpMibBeanProperty(onuVlanIdUpTrafficMapProfVirtualPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.2.8.1.6", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.8.1.7", ISnmpConstant.INTEGER));
    }

    public Long getOnuVlanIdUpTrafficMapProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOnuVlanIdUpTrafficMapProfIndex1(Long aOnuVlanIdUpTrafficMapProfIndex1) {
        setIndex(0, aOnuVlanIdUpTrafficMapProfIndex1);
    }

    public Long getOnuVlanIdUpTrafficMapProfIndex2() {
        return (Long) getIndex(1);
    }

    public void setOnuVlanIdUpTrafficMapProfIndex2(Long aOnuVlanIdUpTrafficMapProfIndex2) {
        setIndex(1, aOnuVlanIdUpTrafficMapProfIndex2);
    }

    public String getOnuVlanIdUpTrafficMapProfileName() {
        return (String) getProperty(onuVlanIdUpTrafficMapProfileName).getValue();
    }

    public void setOnuVlanIdUpTrafficMapProfileName(String aOnuVlanIdUpTrafficMapProfileName) {
        getProperty(onuVlanIdUpTrafficMapProfileName).setValue(aOnuVlanIdUpTrafficMapProfileName);
    }

    public Long getOnuVlanIdUpTrafficMapProfVlanIDStart() {
        return (Long) getProperty(onuVlanIdUpTrafficMapProfVlanIDStart).getValue();
    }

    public void setOnuVlanIdUpTrafficMapProfVlanIDStart(Long aOnuVlanIdUpTrafficMapProfVlanIDStart) {
        getProperty(onuVlanIdUpTrafficMapProfVlanIDStart).setValue(aOnuVlanIdUpTrafficMapProfVlanIDStart);
    }

    public Long getOnuVlanIdUpTrafficMapProfVlanIDStop() {
        return (Long) getProperty(onuVlanIdUpTrafficMapProfVlanIDStop).getValue();
    }

    public void setOnuVlanIdUpTrafficMapProfVlanIDStop(Long aOnuVlanIdUpTrafficMapProfVlanIDStop) {
        getProperty(onuVlanIdUpTrafficMapProfVlanIDStop).setValue(aOnuVlanIdUpTrafficMapProfVlanIDStop);
    }

    public Integer getOnuVlanIdUpTrafficMapProfVirtualPortNo() {
        return (Integer) getProperty(onuVlanIdUpTrafficMapProfVirtualPortNo).getValue();
    }

    public void setOnuVlanIdUpTrafficMapProfVirtualPortNo(Integer aOnuVlanIdUpTrafficMapProfVirtualPortNo) {
        getProperty(onuVlanIdUpTrafficMapProfVirtualPortNo).setValue(aOnuVlanIdUpTrafficMapProfVirtualPortNo);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfileName));
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfVlanIDStart));
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfVlanIDStop));
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfVirtualPortNo));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfileName));
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfVlanIDStart));
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfVlanIDStop));
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfVirtualPortNo));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfileName));
        prepareSave(getProperty(onuVlanIdUpTrafficMapProfVlanIDStart));
        prepareSave(getProperty(onuVlanIdUpTrafficMapProfVlanIDStop));
        prepareSave(getProperty(onuVlanIdUpTrafficMapProfVirtualPortNo));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareRead(getProperty(onuVlanIdUpTrafficMapProfileName));
        prepareSave(getProperty(onuVlanIdUpTrafficMapProfVlanIDStart));
        prepareSave(getProperty(onuVlanIdUpTrafficMapProfVlanIDStop));
        prepareSave(getProperty(onuVlanIdUpTrafficMapProfVirtualPortNo));

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
        return getOnuVlanIdUpTrafficMapProfileName();
    }

}
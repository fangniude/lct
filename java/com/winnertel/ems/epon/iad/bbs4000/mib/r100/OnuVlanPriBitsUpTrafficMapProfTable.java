/**
 * Title          :   OnuVlanPriBitsUpTrafficMapProfTable.java
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

public class OnuVlanPriBitsUpTrafficMapProfTable extends SnmpMibBean {

    public static final String onuVlanPriBitsUpTrafficMapProfIndex1 = "onuVlanPriBitsUpTrafficMapProfIndex1";
    public static final String onuVlanPriBitsUpTrafficMapProfIndex2 = "onuVlanPriBitsUpTrafficMapProfIndex2";
    public static final String onuVlanPriBitsUpTrafficMapProfileName = "onuVlanPriBitsUpTrafficMapProfileName";
    public static final String onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap = "onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap";
    public static final String onuVlanPriBitsUpTrafficMapProfVirtualPortNo = "onuVlanPriBitsUpTrafficMapProfVirtualPortNo";

    public OnuVlanPriBitsUpTrafficMapProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVlanPriBitsUpTrafficMapProfIndex1, new SnmpMibBeanProperty(onuVlanPriBitsUpTrafficMapProfIndex1, ".1.3.6.1.4.1.41355.1.3.10.5.2.7.1.1", ISnmpConstant.GAUGE));
        initProperty(onuVlanPriBitsUpTrafficMapProfIndex2, new SnmpMibBeanProperty(onuVlanPriBitsUpTrafficMapProfIndex2, ".1.3.6.1.4.1.41355.1.3.10.5.2.7.1.2", ISnmpConstant.GAUGE));
        initProperty(onuVlanPriBitsUpTrafficMapProfileName, new SnmpMibBeanProperty(onuVlanPriBitsUpTrafficMapProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.7.1.3", ISnmpConstant.STRING));
        initProperty(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap, new SnmpMibBeanProperty(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap, ".1.3.6.1.4.1.41355.1.3.10.5.2.7.1.4", ISnmpConstant.GAUGE));
        initProperty(onuVlanPriBitsUpTrafficMapProfVirtualPortNo, new SnmpMibBeanProperty(onuVlanPriBitsUpTrafficMapProfVirtualPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.2.7.1.5", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.7.1.6", ISnmpConstant.INTEGER));
    }

    public Long getOnuVlanPriBitsUpTrafficMapProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOnuVlanPriBitsUpTrafficMapProfIndex1(Long aOnuVlanPriBitsUpTrafficMapProfIndex1) {
        setIndex(0, aOnuVlanPriBitsUpTrafficMapProfIndex1);
    }

    public Long getOnuVlanPriBitsUpTrafficMapProfIndex2() {
        return (Long) getIndex(1);
    }

    public void setOnuVlanPriBitsUpTrafficMapProfIndex2(Long aOnuVlanPriBitsUpTrafficMapProfIndex2) {
        setIndex(1, aOnuVlanPriBitsUpTrafficMapProfIndex2);
    }

    public String getOnuVlanPriBitsUpTrafficMapProfileName() {
        return (String) getProperty(onuVlanPriBitsUpTrafficMapProfileName).getValue();
    }

    public void setOnuVlanPriBitsUpTrafficMapProfileName(String aOnuVlanPriBitsUpTrafficMapProfileName) {
        getProperty(onuVlanPriBitsUpTrafficMapProfileName).setValue(aOnuVlanPriBitsUpTrafficMapProfileName);
    }

    public Long getOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap() {
        return (Long) getProperty(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap).getValue();
    }

    public void setOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap(Long aOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap) {
        getProperty(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap).setValue(aOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap);
    }

    public Integer getOnuVlanPriBitsUpTrafficMapProfVirtualPortNo() {
        return (Integer) getProperty(onuVlanPriBitsUpTrafficMapProfVirtualPortNo).getValue();
    }

    public void setOnuVlanPriBitsUpTrafficMapProfVirtualPortNo(Integer aOnuVlanPriBitsUpTrafficMapProfVirtualPortNo) {
        getProperty(onuVlanPriBitsUpTrafficMapProfVirtualPortNo).setValue(aOnuVlanPriBitsUpTrafficMapProfVirtualPortNo);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuVlanPriBitsUpTrafficMapProfileName));
        prepareRead(getProperty(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap));
        prepareRead(getProperty(onuVlanPriBitsUpTrafficMapProfVirtualPortNo));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuVlanPriBitsUpTrafficMapProfileName));
        prepareRead(getProperty(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap));
        prepareRead(getProperty(onuVlanPriBitsUpTrafficMapProfVirtualPortNo));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuVlanPriBitsUpTrafficMapProfileName));
        prepareSave(getProperty(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap));
        prepareSave(getProperty(onuVlanPriBitsUpTrafficMapProfVirtualPortNo));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuVlanPriBitsUpTrafficMapProfileName));
        prepareSave(getProperty(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap));
        prepareSave(getProperty(onuVlanPriBitsUpTrafficMapProfVirtualPortNo));

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
        return getOnuVlanPriBitsUpTrafficMapProfileName();
    }

}
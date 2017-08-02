/**
 * Title          :   OnuEthUniCfgProTable.java
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
 *         Create on 2008-9-30
 *         Modify by HZ21044
 */

public class OnuEthUniCfgProTable extends SnmpMibBean {

    public static final String onuEthUniCfgProEthernetUNIProfileIndex = "onuEthUniCfgProEthernetUNIProfileIndex";
    public static final String onuEthUniCfgProProfileName = "onuEthUniCfgProProfileName";
    public static final String onuEthUniCfgProAutoNegotiation = "onuEthUniCfgProAutoNegotiation";
    public static final String onuEthUniCfgProSpeed = "onuEthUniCfgProSpeed";
    public static final String onuEthUniCfgProDuplex = "onuEthUniCfgProDuplex";
    public static final String onuEthUniCfgProExpectedType = "onuEthUniCfgProExpectedType";
    public static final String onuEthUniCfgProMaxFrameSize = "onuEthUniCfgProMaxFrameSize";
    public static final String onuEthUniCfgProIndDTEDCE = "onuEthUniCfgProIndDTEDCE";

    public OnuEthUniCfgProTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuEthUniCfgProEthernetUNIProfileIndex, new SnmpMibBeanProperty(onuEthUniCfgProEthernetUNIProfileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.1", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgProProfileName, new SnmpMibBeanProperty(onuEthUniCfgProProfileName, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.2", ISnmpConstant.STRING));
        initProperty(onuEthUniCfgProAutoNegotiation, new SnmpMibBeanProperty(onuEthUniCfgProAutoNegotiation, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.3", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgProSpeed, new SnmpMibBeanProperty(onuEthUniCfgProSpeed, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.4", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgProDuplex, new SnmpMibBeanProperty(onuEthUniCfgProDuplex, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.5", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgProExpectedType, new SnmpMibBeanProperty(onuEthUniCfgProExpectedType, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.6", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgProMaxFrameSize, new SnmpMibBeanProperty(onuEthUniCfgProMaxFrameSize, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.7", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgProIndDTEDCE, new SnmpMibBeanProperty(onuEthUniCfgProIndDTEDCE, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.8", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.1.8.1.9", ISnmpConstant.INTEGER));
    }

    public Long getOnuEthUniCfgProEthernetUNIProfileIndex() {
        return (Long) getIndex(0);
    }

    public void setOnuEthUniCfgProEthernetUNIProfileIndex(Long aOnuEthUniCfgProEthernetUNIProfileIndex) {
        setIndex(0, aOnuEthUniCfgProEthernetUNIProfileIndex);
    }

    public String getOnuEthUniCfgProProfileName() {
        return (String) getProperty(onuEthUniCfgProProfileName).getValue();
    }

    public void setOnuEthUniCfgProProfileName(String aOnuEthUniCfgProProfileName) {
        getProperty(onuEthUniCfgProProfileName).setValue(aOnuEthUniCfgProProfileName);
    }

    public Integer getOnuEthUniCfgProAutoNegotiation() {
        return (Integer) getProperty(onuEthUniCfgProAutoNegotiation).getValue();
    }

    public void setOnuEthUniCfgProAutoNegotiation(Integer aOnuEthUniCfgProAutoNegotiation) {
        getProperty(onuEthUniCfgProAutoNegotiation).setValue(aOnuEthUniCfgProAutoNegotiation);
    }

    public Integer getOnuEthUniCfgProSpeed() {
        return (Integer) getProperty(onuEthUniCfgProSpeed).getValue();
    }

    public void setOnuEthUniCfgProSpeed(Integer aOnuEthUniCfgProSpeed) {
        getProperty(onuEthUniCfgProSpeed).setValue(aOnuEthUniCfgProSpeed);
    }

    public Integer getOnuEthUniCfgProDuplex() {
        return (Integer) getProperty(onuEthUniCfgProDuplex).getValue();
    }

    public void setOnuEthUniCfgProDuplex(Integer aOnuEthUniCfgProDuplex) {
        getProperty(onuEthUniCfgProDuplex).setValue(aOnuEthUniCfgProDuplex);
    }

    public Long getOnuEthUniCfgProExpectedType() {
        return (Long) getProperty(onuEthUniCfgProExpectedType).getValue();
    }

    public void setOnuEthUniCfgProExpectedType(Long aOnuEthUniCfgProExpectedType) {
        getProperty(onuEthUniCfgProExpectedType).setValue(aOnuEthUniCfgProExpectedType);
    }

    public Long getOnuEthUniCfgProMaxFrameSize() {
        return (Long) getProperty(onuEthUniCfgProMaxFrameSize).getValue();
    }

    public void setOnuEthUniCfgProMaxFrameSize(Long aOnuEthUniCfgProMaxFrameSize) {
        getProperty(onuEthUniCfgProMaxFrameSize).setValue(aOnuEthUniCfgProMaxFrameSize);
    }

    public Integer getOnuEthUniCfgProIndDTEDCE() {
        return (Integer) getProperty(onuEthUniCfgProIndDTEDCE).getValue();
    }

    public void setOnuEthUniCfgProIndDTEDCE(Integer aOnuEthUniCfgProIndDTEDCE) {
        getProperty(onuEthUniCfgProIndDTEDCE).setValue(aOnuEthUniCfgProIndDTEDCE);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuEthUniCfgProProfileName));
        prepareRead(super.getProperty(onuEthUniCfgProAutoNegotiation));
        prepareRead(super.getProperty(onuEthUniCfgProSpeed));
        prepareRead(super.getProperty(onuEthUniCfgProDuplex));
        prepareRead(super.getProperty(onuEthUniCfgProExpectedType));
        prepareRead(super.getProperty(onuEthUniCfgProMaxFrameSize));
        prepareRead(super.getProperty(onuEthUniCfgProIndDTEDCE));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuEthUniCfgProProfileName));
        prepareRead(super.getProperty(onuEthUniCfgProAutoNegotiation));
        prepareRead(super.getProperty(onuEthUniCfgProSpeed));
        prepareRead(super.getProperty(onuEthUniCfgProDuplex));
        prepareRead(super.getProperty(onuEthUniCfgProExpectedType));
        prepareRead(super.getProperty(onuEthUniCfgProMaxFrameSize));
        prepareRead(super.getProperty(onuEthUniCfgProIndDTEDCE));

        return loadAll(new int[]{2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuEthUniCfgProProfileName));
        prepareSave(getProperty(onuEthUniCfgProAutoNegotiation));
        prepareSave(getProperty(onuEthUniCfgProSpeed));
        prepareSave(getProperty(onuEthUniCfgProDuplex));
        prepareSave(getProperty(onuEthUniCfgProExpectedType));
        prepareSave(getProperty(onuEthUniCfgProMaxFrameSize));
        prepareSave(getProperty(onuEthUniCfgProIndDTEDCE));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuEthUniCfgProProfileName));
        prepareSave(getProperty(onuEthUniCfgProAutoNegotiation));
        prepareSave(getProperty(onuEthUniCfgProSpeed));
        prepareSave(getProperty(onuEthUniCfgProDuplex));
        prepareSave(getProperty(onuEthUniCfgProExpectedType));
        prepareSave(getProperty(onuEthUniCfgProMaxFrameSize));
        prepareSave(getProperty(onuEthUniCfgProIndDTEDCE));
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    //added by Zhou Chao, 2009/2/13
    public String toString() {
        return getOnuEthUniCfgProProfileName();
    }

}
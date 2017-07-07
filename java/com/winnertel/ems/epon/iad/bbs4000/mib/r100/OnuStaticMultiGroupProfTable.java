/**
 * Title          :   OnuStaticMultiGroupProfTable.java
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

public class OnuStaticMultiGroupProfTable extends SnmpMibBean {

    public static final String onuStaticMultiGroupProfIndex1 = "onuStaticMultiGroupProfIndex1";
    public static final String onuStaticMultiGroupProfIndex2 = "onuStaticMultiGroupProfIndex2";
    public static final String onuStaticMultiGroupProfileName = "onuStaticMultiGroupProfileName";
    public static final String onuStaticMultiGroupProfMulticastGemPortNo = "onuStaticMultiGroupProfMulticastGemPortNo";
    public static final String onuStaticMultiGroupProfMulticastVLANID = "onuStaticMultiGroupProfMulticastVLANID";
    public static final String onuStaticMultiGroupProfSourceIPAddress = "onuStaticMultiGroupProfSourceIPAddress";

    public static final String onuStaticMultiGroupProfMulticastGroupAddressStart = "onuStaticMultiGroupProfMulticastGroupAddressStart";
    public static final String onuStaticMultiGroupProfMulticastGroupAddressStop = "onuStaticMultiGroupProfMulticastGroupAddressStop";
    public static final String onuStaticMultiGroupProfImputedGroupBandwidth = "onuStaticMultiGroupProfImputedGroupBandwidth";

    public OnuStaticMultiGroupProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuStaticMultiGroupProfIndex1, new SnmpMibBeanProperty(onuStaticMultiGroupProfIndex1, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.1", ISnmpConstant.GAUGE));
        initProperty(onuStaticMultiGroupProfIndex2, new SnmpMibBeanProperty(onuStaticMultiGroupProfIndex2, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.2", ISnmpConstant.GAUGE));
        initProperty(onuStaticMultiGroupProfileName, new SnmpMibBeanProperty(onuStaticMultiGroupProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.3", ISnmpConstant.STRING));
        initProperty(onuStaticMultiGroupProfMulticastGemPortNo, new SnmpMibBeanProperty(onuStaticMultiGroupProfMulticastGemPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.4", ISnmpConstant.GAUGE));
        initProperty(onuStaticMultiGroupProfMulticastVLANID, new SnmpMibBeanProperty(onuStaticMultiGroupProfMulticastVLANID, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.5", ISnmpConstant.GAUGE));
        initProperty(onuStaticMultiGroupProfSourceIPAddress, new SnmpMibBeanProperty(onuStaticMultiGroupProfSourceIPAddress, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.6", ISnmpConstant.IP_ADDRESS));
        initProperty(onuStaticMultiGroupProfMulticastGroupAddressStart, new SnmpMibBeanProperty(onuStaticMultiGroupProfMulticastGroupAddressStart, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.7", ISnmpConstant.IP_ADDRESS));
        initProperty(onuStaticMultiGroupProfMulticastGroupAddressStop, new SnmpMibBeanProperty(onuStaticMultiGroupProfMulticastGroupAddressStop, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.8", ISnmpConstant.IP_ADDRESS));
        initProperty(onuStaticMultiGroupProfImputedGroupBandwidth, new SnmpMibBeanProperty(onuStaticMultiGroupProfImputedGroupBandwidth, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.9", ISnmpConstant.GAUGE));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.18.1.10", ISnmpConstant.INTEGER));
    }

    public Long getOnuStaticMultiGroupProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOnuStaticMultiGroupProfIndex1(Long aOnuStaticMultiGroupProfIndex1) {
        setIndex(0, aOnuStaticMultiGroupProfIndex1);
    }

    public Long getOnuStaticMultiGroupProfIndex2() {
        return (Long) getIndex(1);
    }

    public void setOnuStaticMultiGroupProfIndex2(Long aOnuStaticMultiGroupProfIndex2) {
        setIndex(1, aOnuStaticMultiGroupProfIndex2);
    }

    public String getOnuStaticMultiGroupProfileName() {
        return (String) getProperty(onuStaticMultiGroupProfileName).getValue();
    }

    public void setOnuStaticMultiGroupProfileName(String aOnuStaticMultiGroupProfileName) {
        getProperty(onuStaticMultiGroupProfileName).setValue(aOnuStaticMultiGroupProfileName);
    }

    public Long getOnuStaticMultiGroupProfMulticastGemPortNo() {
        return (Long) getProperty(onuStaticMultiGroupProfMulticastGemPortNo).getValue();
    }

    public void setOnuStaticMultiGroupProfMulticastGemPortNo(Long aOnuStaticMultiGroupProfMulticastGemPortNo) {
        getProperty(onuStaticMultiGroupProfMulticastGemPortNo).setValue(aOnuStaticMultiGroupProfMulticastGemPortNo);
    }

    public Long getOnuStaticMultiGroupProfMulticastVLANID() {
        return (Long) getProperty(onuStaticMultiGroupProfMulticastVLANID).getValue();
    }

    public void setOnuStaticMultiGroupProfMulticastVLANID(Long aOnuStaticMultiGroupProfMulticastVLANID) {
        getProperty(onuStaticMultiGroupProfMulticastVLANID).setValue(aOnuStaticMultiGroupProfMulticastVLANID);
    }

    public String getOnuStaticMultiGroupProfSourceIPAddress() {
        return (String) getProperty(onuStaticMultiGroupProfSourceIPAddress).getValue();
    }

    public void setOnuStaticMultiGroupProfSourceIPAddress(String aOnuStaticMultiGroupProfSourceIPAddress) {
        getProperty(onuStaticMultiGroupProfSourceIPAddress).setValue(aOnuStaticMultiGroupProfSourceIPAddress);
    }

    public Long getOnuStaticMultiGroupProfImputedGroupBandwidth() {
        return (Long) getProperty(onuStaticMultiGroupProfImputedGroupBandwidth).getValue();
    }

    public void setOnuStaticMultiGroupProfImputedGroupBandwidth(Long aOnuStaticMultiGroupProfImputedGroupBandwidth) {
        getProperty(onuStaticMultiGroupProfImputedGroupBandwidth).setValue(aOnuStaticMultiGroupProfImputedGroupBandwidth);
    }

    public String getOnuStaticMultiGroupProfMulticastGroupAddressStart() {
        return (String) getProperty(onuStaticMultiGroupProfMulticastGroupAddressStart).getValue();
    }

    public void setOnuStaticMultiGroupProfMulticastGroupAddressStart(String aOnuStaticMultiGroupProfMulticastGroupAddressStart) {
        getProperty(onuStaticMultiGroupProfMulticastGroupAddressStart).setValue(aOnuStaticMultiGroupProfMulticastGroupAddressStart);
    }

    public String getOnuStaticMultiGroupProfMulticastGroupAddressStop() {
        return (String) getProperty(onuStaticMultiGroupProfMulticastGroupAddressStop).getValue();
    }

    public void setOnuStaticMultiGroupProfMulticastGroupAddressStop(String aOnuStaticMultiGroupProfMulticastGroupAddressStop) {
        getProperty(onuStaticMultiGroupProfMulticastGroupAddressStop).setValue(aOnuStaticMultiGroupProfMulticastGroupAddressStop);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuStaticMultiGroupProfileName));
        prepareRead(super.getProperty(onuStaticMultiGroupProfMulticastGroupAddressStart));
        prepareRead(super.getProperty(onuStaticMultiGroupProfMulticastGroupAddressStop));
        prepareRead(super.getProperty(onuStaticMultiGroupProfMulticastGemPortNo));
        prepareRead(super.getProperty(onuStaticMultiGroupProfMulticastVLANID));
        prepareRead(super.getProperty(onuStaticMultiGroupProfSourceIPAddress));
        prepareRead(super.getProperty(onuStaticMultiGroupProfImputedGroupBandwidth));
        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuStaticMultiGroupProfMulticastGemPortNo));
        prepareRead(super.getProperty(onuStaticMultiGroupProfMulticastVLANID));
        prepareRead(super.getProperty(onuStaticMultiGroupProfSourceIPAddress));
        prepareRead(super.getProperty(onuStaticMultiGroupProfImputedGroupBandwidth));
        prepareRead(super.getProperty(onuStaticMultiGroupProfileName));
        prepareRead(super.getProperty(onuStaticMultiGroupProfMulticastGroupAddressStart));
        prepareRead(super.getProperty(onuStaticMultiGroupProfMulticastGroupAddressStop));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuStaticMultiGroupProfileName));
        prepareSave(getProperty(onuStaticMultiGroupProfMulticastGroupAddressStart));
        prepareSave(getProperty(onuStaticMultiGroupProfMulticastGroupAddressStop));
        prepareSave(getProperty(onuStaticMultiGroupProfMulticastGemPortNo));
        prepareSave(getProperty(onuStaticMultiGroupProfMulticastVLANID));
        prepareSave(getProperty(onuStaticMultiGroupProfSourceIPAddress));
        prepareSave(getProperty(onuStaticMultiGroupProfImputedGroupBandwidth));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuStaticMultiGroupProfileName));
        prepareSave(getProperty(onuStaticMultiGroupProfMulticastGroupAddressStart));
        prepareSave(getProperty(onuStaticMultiGroupProfMulticastGroupAddressStop));
        prepareSave(getProperty(onuStaticMultiGroupProfMulticastGemPortNo));
        prepareSave(getProperty(onuStaticMultiGroupProfMulticastVLANID));
        prepareSave(getProperty(onuStaticMultiGroupProfSourceIPAddress));
        prepareSave(getProperty(onuStaticMultiGroupProfImputedGroupBandwidth));
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
        return getOnuStaticMultiGroupProfileName();
    }

}
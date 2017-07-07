package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class SniAttributeTable extends SnmpMibBean {
    public static final String sniAttributeDeviceIndex = "sniAttributeDeviceIndex";
    public static final String sniAttributeCardIndex = "sniAttributeCardIndex";
    public static final String sniAttributePortIndex = "sniAttributePortIndex";
    public static final String sniPortName = "sniPortName";
    public static final String sniAdminStatus = "sniAdminStatus";
    public static final String sniOperationStatus = "sniOperationStatus";
    public static final String sniMediaType = "sniMediaType";
    public static final String sniAutoNegotiationStatus = "sniAutoNegotiationStatus";
    public static final String sniAutoNegotiationMode = "sniAutoNegotiationMode";
    public static final String sniPerfStats15minuteEnable = "sniPerfStats15minuteEnable";
    public static final String sniPerfStats24hourEnable = "sniPerfStats24hourEnable";
    public static final String sniLastStatusChangeTime = "sniLastStatusChangeTime";
    public static final String sniMacAddrLearnMaxNum = "sniMacAddrLearnMaxNum";
    public static final String sniIsolationEnable = "sniIsolationEnable";

    public SniAttributeTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(sniAttributeDeviceIndex, new SnmpMibBeanProperty(sniAttributeDeviceIndex, ".1.3.6.1.4.1.17409.2.3.2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(sniAttributeCardIndex, new SnmpMibBeanProperty(sniAttributeCardIndex, ".1.3.6.1.4.1.17409.2.3.2.1.1.2", ISnmpConstant.INTEGER));
        initProperty(sniAttributePortIndex, new SnmpMibBeanProperty(sniAttributePortIndex, ".1.3.6.1.4.1.17409.2.3.2.1.1.3", ISnmpConstant.INTEGER));
        initProperty(sniPortName, new SnmpMibBeanProperty(sniPortName, ".1.3.6.1.4.1.17409.2.3.2.1.1.4", ISnmpConstant.STRING));
        initProperty(sniAdminStatus, new SnmpMibBeanProperty(sniAdminStatus, ".1.3.6.1.4.1.17409.2.3.2.1.1.5", ISnmpConstant.INTEGER));
        initProperty(sniOperationStatus, new SnmpMibBeanProperty(sniOperationStatus, ".1.3.6.1.4.1.17409.2.3.2.1.1.6", ISnmpConstant.INTEGER));
        initProperty(sniMediaType, new SnmpMibBeanProperty(sniMediaType, ".1.3.6.1.4.1.17409.2.3.2.1.1.7", ISnmpConstant.INTEGER));
        initProperty(sniAutoNegotiationStatus, new SnmpMibBeanProperty(sniAutoNegotiationStatus, ".1.3.6.1.4.1.17409.2.3.2.1.1.8", ISnmpConstant.INTEGER));
        initProperty(sniAutoNegotiationMode, new SnmpMibBeanProperty(sniAutoNegotiationMode, ".1.3.6.1.4.1.17409.2.3.2.1.1.9", ISnmpConstant.INTEGER));
        initProperty(sniPerfStats15minuteEnable, new SnmpMibBeanProperty(sniPerfStats15minuteEnable, ".1.3.6.1.4.1.17409.2.3.2.1.1.10", ISnmpConstant.INTEGER));
        initProperty(sniPerfStats24hourEnable, new SnmpMibBeanProperty(sniPerfStats24hourEnable, ".1.3.6.1.4.1.17409.2.3.2.1.1.11", ISnmpConstant.INTEGER));
        initProperty(sniLastStatusChangeTime, new SnmpMibBeanProperty(sniLastStatusChangeTime, ".1.3.6.1.4.1.17409.2.3.2.1.1.12", ISnmpConstant.TIME_TICKS));
        initProperty(sniMacAddrLearnMaxNum, new SnmpMibBeanProperty(sniMacAddrLearnMaxNum, ".1.3.6.1.4.1.17409.2.3.2.1.1.13", ISnmpConstant.INTEGER));
        initProperty(sniIsolationEnable, new SnmpMibBeanProperty(sniIsolationEnable, ".1.3.6.1.4.1.17409.2.3.2.1.1.14", ISnmpConstant.INTEGER));

    }


    public Integer getSniAttributeDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setSniAttributeDeviceIndex(Integer aSniAttributeDeviceIndex) {
        setIndex(0, aSniAttributeDeviceIndex);
    }


    public Integer getSniAttributeCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setSniAttributeCardIndex(Integer aSniAttributeCardIndex) {
        setIndex(1, aSniAttributeCardIndex);
    }


    public Integer getSniAttributePortIndex() {
        return (Integer) getIndex(2);
    }

    public void setSniAttributePortIndex(Integer aSniAttributePortIndex) {
        setIndex(2, aSniAttributePortIndex);
    }


    public String getSniPortName() {
        return (String) getProperty(sniPortName).getValue();
    }

    public void setSniPortName(String aSniPortName) {
        getProperty(sniPortName).setValue(aSniPortName);
    }

    public Integer getSniAdminStatus() {
        return (Integer) getProperty(sniAdminStatus).getValue();
    }

    public void setSniAdminStatus(Integer aSniAdminStatus) {
        getProperty(sniAdminStatus).setValue(aSniAdminStatus);
    }

    public Integer getSniOperationStatus() {
        return (Integer) getProperty(sniOperationStatus).getValue();
    }

    public void setSniOperationStatus(Integer aSniOperationStatus) {
        getProperty(sniOperationStatus).setValue(aSniOperationStatus);
    }

    public Integer getSniMediaType() {
        return (Integer) getProperty(sniMediaType).getValue();
    }

    public void setSniMediaType(Integer aSniMediaType) {
        getProperty(sniMediaType).setValue(aSniMediaType);
    }

    public Integer getSniAutoNegotiationStatus() {
        return (Integer) getProperty(sniAutoNegotiationStatus).getValue();
    }

    public void setSniAutoNegotiationStatus(Integer aSniAutoNegotiationStatus) {
        getProperty(sniAutoNegotiationStatus).setValue(aSniAutoNegotiationStatus);
    }

    public Integer getSniAutoNegotiationMode() {
        return (Integer) getProperty(sniAutoNegotiationMode).getValue();
    }

    public void setSniAutoNegotiationMode(Integer aSniAutoNegotiationMode) {
        getProperty(sniAutoNegotiationMode).setValue(aSniAutoNegotiationMode);
    }

    public Integer getSniPerfStats15minuteEnable() {
        return (Integer) getProperty(sniPerfStats15minuteEnable).getValue();
    }

    public void setSniPerfStats15minuteEnable(Integer aSniPerfStats15minuteEnable) {
        getProperty(sniPerfStats15minuteEnable).setValue(aSniPerfStats15minuteEnable);
    }

    public Integer getSniPerfStats24hourEnable() {
        return (Integer) getProperty(sniPerfStats24hourEnable).getValue();
    }

    public void setSniPerfStats24hourEnable(Integer aSniPerfStats24hourEnable) {
        getProperty(sniPerfStats24hourEnable).setValue(aSniPerfStats24hourEnable);
    }

    public Long getSniLastStatusChangeTime() {
        return (Long) getProperty(sniLastStatusChangeTime).getValue();
    }

    public void setSniLastStatusChangeTime(Long aSniLastStatusChangeTime) {
        getProperty(sniLastStatusChangeTime).setValue(aSniLastStatusChangeTime);
    }

    public Integer getSniMacAddrLearnMaxNum() {
        return (Integer) getProperty(sniMacAddrLearnMaxNum).getValue();
    }

    public void setSniMacAddrLearnMaxNum(Integer aSniMacAddrLearnMaxNum) {
        getProperty(sniMacAddrLearnMaxNum).setValue(aSniMacAddrLearnMaxNum);
    }

    public Integer getSniIsolationEnable() {
        return (Integer) getProperty(sniIsolationEnable).getValue();
    }

    public void setSniIsolationEnable(Integer aSniIsolationEnable) {
        getProperty(sniIsolationEnable).setValue(aSniIsolationEnable);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(sniPortName));
        prepareRead(super.getProperty(sniAdminStatus));
        prepareRead(super.getProperty(sniOperationStatus));
        prepareRead(super.getProperty(sniMediaType));
        prepareRead(super.getProperty(sniAutoNegotiationStatus));
        prepareRead(super.getProperty(sniAutoNegotiationMode));
        prepareRead(super.getProperty(sniPerfStats15minuteEnable));
        prepareRead(super.getProperty(sniPerfStats24hourEnable));
        prepareRead(super.getProperty(sniLastStatusChangeTime));
        prepareRead(super.getProperty(sniMacAddrLearnMaxNum));
        prepareRead(super.getProperty(sniIsolationEnable));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(sniPortName));
        prepareRead(super.getProperty(sniAdminStatus));
        prepareRead(super.getProperty(sniOperationStatus));
        prepareRead(super.getProperty(sniMediaType));
        prepareRead(super.getProperty(sniAutoNegotiationStatus));
        prepareRead(super.getProperty(sniAutoNegotiationMode));
        prepareRead(super.getProperty(sniPerfStats15minuteEnable));
        prepareRead(super.getProperty(sniPerfStats24hourEnable));
        prepareRead(super.getProperty(sniLastStatusChangeTime));
        prepareRead(super.getProperty(sniMacAddrLearnMaxNum));
        prepareRead(super.getProperty(sniIsolationEnable));

        return loadAll(new int[]{1, 1, 1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(sniPortName));
        prepareSave(getProperty(sniAdminStatus));
        prepareSave(getProperty(sniAutoNegotiationMode));
        prepareSave(getProperty(sniPerfStats15minuteEnable));
        prepareSave(getProperty(sniPerfStats24hourEnable));
        prepareSave(getProperty(sniMacAddrLearnMaxNum));
        prepareSave(getProperty(sniIsolationEnable));

        return save();
    }


}

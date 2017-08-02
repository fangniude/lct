/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The OnuPortsEgressOuterTpidTable class.
 * Created by QuickDVM
 */
public class OnuPortsEgressOuterTpidTable extends SnmpMibBean {
    public static final String onuPortsEgressOuterTpidSlotNo = "onuPortsEgressOuterTpidSlotNo";
    public static final String onuPortsEgressOuterTpidPortNo = "onuPortsEgressOuterTpidPortNo";
    public static final String onuPortsEgressOuterTpidLogicalPortNo = "onuPortsEgressOuterTpidLogicalPortNo";
    public static final String onuPortsEgressOuterTpid = "onuPortsEgressOuterTpid";

    public OnuPortsEgressOuterTpidTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuPortsEgressOuterTpidSlotNo, new SnmpMibBeanProperty(onuPortsEgressOuterTpidSlotNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.4.1", ISnmpConstant.INTEGER));
        initProperty(onuPortsEgressOuterTpidPortNo, new SnmpMibBeanProperty(onuPortsEgressOuterTpidPortNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.4.2", ISnmpConstant.INTEGER));
        initProperty(onuPortsEgressOuterTpidLogicalPortNo, new SnmpMibBeanProperty(
                onuPortsEgressOuterTpidLogicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1000.4.3", ISnmpConstant.INTEGER));
        initProperty(onuPortsEgressOuterTpid, new SnmpMibBeanProperty(onuPortsEgressOuterTpid,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.4.10", ISnmpConstant.INTEGER));

    }

    public Integer getOnuPortsEgressOuterTpidSlotNo() {
        return (Integer) getProperty(onuPortsEgressOuterTpidSlotNo).getValue();
    }

    public void setOnuPortsEgressOuterTpidSlotNo(Integer aOnuPortsEgressOuterTpidSlotNo) {
        getProperty(onuPortsEgressOuterTpidSlotNo).setValue(aOnuPortsEgressOuterTpidSlotNo);
    }

    public Integer getOnuPortsEgressOuterTpidPortNo() {
        return (Integer) getProperty(onuPortsEgressOuterTpidPortNo).getValue();
    }

    public void setOnuPortsEgressOuterTpidPortNo(Integer aOnuPortsEgressOuterTpidPortNo) {
        getProperty(onuPortsEgressOuterTpidPortNo).setValue(aOnuPortsEgressOuterTpidPortNo);
    }

    public Integer getOnuPortsEgressOuterTpidLogicalPortNo() {
        return (Integer) getProperty(onuPortsEgressOuterTpidLogicalPortNo).getValue();
    }

    public void setOnuPortsEgressOuterTpidLogicalPortNo(Integer aOnuPortsEgressOuterTpidLogicalPortNo) {
        getProperty(onuPortsEgressOuterTpidLogicalPortNo).setValue(aOnuPortsEgressOuterTpidLogicalPortNo);
    }

    public Integer getOnuPortsEgressOuterTpid() {
        return (Integer) getProperty(onuPortsEgressOuterTpid).getValue();
    }

    public void setOnuPortsEgressOuterTpid(Integer aOnuPortsEgressOuterTpid) {
        getProperty(onuPortsEgressOuterTpid).setValue(aOnuPortsEgressOuterTpid);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuPortsEgressOuterTpidSlotNo));
        prepareRead(super.getProperty(onuPortsEgressOuterTpidPortNo));
        prepareRead(super.getProperty(onuPortsEgressOuterTpidLogicalPortNo));
        prepareRead(super.getProperty(onuPortsEgressOuterTpid));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuPortsEgressOuterTpidSlotNo));
        prepareSave(getProperty(onuPortsEgressOuterTpidPortNo));
        prepareSave(getProperty(onuPortsEgressOuterTpidLogicalPortNo));
        prepareSave(getProperty(onuPortsEgressOuterTpid));

        return save();
    }
}
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
 * The OnuMLSQosExtCosQueueSchedTable class. Created by QuickDVM
 */
public class OnuMLSQosExtCosQueueSchedTable extends SnmpMibBean {
    public static final String onuMLSQosExtCosQueueSchedSlotNo = "onuMLSQosExtCosQueueSchedSlotNo";
    public static final String onuMLSQosExtCosQueueSchedPortNo = "onuMLSQosExtCosQueueSchedPortNo";
    public static final String onuMLSQosExtCosQueueSchedLogicalPortNo = "onuMLSQosExtCosQueueSchedLogicalPortNo";
    public static final String onuMLSQosExtCosQueueSchedWeight = "onuMLSQosExtCosQueueSchedWeight";
    public static final String onuMLSQosExtCosQueueSchedMode = "onuMLSQosExtCosQueueSchedMode";

    public OnuMLSQosExtCosQueueSchedTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuMLSQosExtCosQueueSchedSlotNo, new SnmpMibBeanProperty(onuMLSQosExtCosQueueSchedSlotNo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.5.1", ISnmpConstant.INTEGER));
        initProperty(onuMLSQosExtCosQueueSchedPortNo, new SnmpMibBeanProperty(onuMLSQosExtCosQueueSchedPortNo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.5.2", ISnmpConstant.INTEGER));
        initProperty(onuMLSQosExtCosQueueSchedLogicalPortNo, new SnmpMibBeanProperty(
                onuMLSQosExtCosQueueSchedLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1000.5.3", ISnmpConstant.INTEGER));
        initProperty(onuMLSQosExtCosQueueSchedWeight, new SnmpMibBeanProperty(onuMLSQosExtCosQueueSchedWeight,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.5.10", ISnmpConstant.OCTETS));
        initProperty(onuMLSQosExtCosQueueSchedMode, new SnmpMibBeanProperty(onuMLSQosExtCosQueueSchedMode,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.5.11", ISnmpConstant.INTEGER));

    }

    public Integer getOnuMLSQosExtCosQueueSchedSlotNo() {
        return (Integer) getProperty(onuMLSQosExtCosQueueSchedSlotNo).getValue();
    }

    public void setOnuMLSQosExtCosQueueSchedSlotNo(Integer aOnuMLSQosExtCosQueueSchedSlotNo) {
        getProperty(onuMLSQosExtCosQueueSchedSlotNo).setValue(aOnuMLSQosExtCosQueueSchedSlotNo);
    }

    public Integer getOnuMLSQosExtCosQueueSchedPortNo() {
        return (Integer) getProperty(onuMLSQosExtCosQueueSchedPortNo).getValue();
    }

    public void setOnuMLSQosExtCosQueueSchedPortNo(Integer aOnuMLSQosExtCosQueueSchedPortNo) {
        getProperty(onuMLSQosExtCosQueueSchedPortNo).setValue(aOnuMLSQosExtCosQueueSchedPortNo);
    }

    public Integer getOnuMLSQosExtCosQueueSchedLogicalPortNo() {
        return (Integer) getProperty(onuMLSQosExtCosQueueSchedLogicalPortNo).getValue();
    }

    public void setOnuMLSQosExtCosQueueSchedLogicalPortNo(Integer aOnuMLSQosExtCosQueueSchedLogicalPortNo) {
        getProperty(onuMLSQosExtCosQueueSchedLogicalPortNo).setValue(aOnuMLSQosExtCosQueueSchedLogicalPortNo);
    }

    public byte[] getOnuMLSQosExtCosQueueSchedWeight() {
        return (byte[]) getProperty(onuMLSQosExtCosQueueSchedWeight).getValue();
    }

    public void setOnuMLSQosExtCosQueueSchedWeight(byte[] aOnuMLSQosExtCosQueueSchedWeight) {
        getProperty(onuMLSQosExtCosQueueSchedWeight).setValue(aOnuMLSQosExtCosQueueSchedWeight);
    }

    public Integer getOnuMLSQosExtCosQueueSchedMode() {
        return (Integer) getProperty(onuMLSQosExtCosQueueSchedMode).getValue();
    }

    public void setOnuMLSQosExtCosQueueSchedMode(Integer aOnuMLSQosExtCosQueueSchedMode) {
        getProperty(onuMLSQosExtCosQueueSchedMode).setValue(aOnuMLSQosExtCosQueueSchedMode);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuMLSQosExtCosQueueSchedSlotNo));
        prepareRead(super.getProperty(onuMLSQosExtCosQueueSchedPortNo));
        prepareRead(super.getProperty(onuMLSQosExtCosQueueSchedLogicalPortNo));
        prepareRead(super.getProperty(onuMLSQosExtCosQueueSchedWeight));
        prepareRead(super.getProperty(onuMLSQosExtCosQueueSchedMode));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuMLSQosExtCosQueueSchedSlotNo));
        prepareSave(getProperty(onuMLSQosExtCosQueueSchedPortNo));
        prepareSave(getProperty(onuMLSQosExtCosQueueSchedLogicalPortNo));
        prepareSave(getProperty(onuMLSQosExtCosQueueSchedWeight));
        prepareSave(getProperty(onuMLSQosExtCosQueueSchedMode));

        return save();
    }

}
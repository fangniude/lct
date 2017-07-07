package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The VlanGlobalInfoTable class.
 * Created by QuickDVM
 */
public class VlanGlobalInfoTable extends SnmpMibBean {
    public static final String vlanDeviceIndex = "vlanDeviceIndex";
    public static final String maxVlanId = "maxVlanId";
    public static final String maxSupportVlans = "maxSupportVlans";
    public static final String createdVlanNumber = "createdVlanNumber";

    public VlanGlobalInfoTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(vlanDeviceIndex, new SnmpMibBeanProperty(vlanDeviceIndex, ".1.3.6.1.4.1.17409.2.3.7.1.1.1", ISnmpConstant.INTEGER));
        initProperty(maxVlanId, new SnmpMibBeanProperty(maxVlanId, ".1.3.6.1.4.1.17409.2.3.7.1.1.2", ISnmpConstant.INTEGER));
        initProperty(maxSupportVlans, new SnmpMibBeanProperty(maxSupportVlans, ".1.3.6.1.4.1.17409.2.3.7.1.1.3", ISnmpConstant.INTEGER));
        initProperty(createdVlanNumber, new SnmpMibBeanProperty(createdVlanNumber, ".1.3.6.1.4.1.17409.2.3.7.1.1.4", ISnmpConstant.INTEGER));

    }


    public Integer getVlanDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setVlanDeviceIndex(Integer aVlanDeviceIndex) {
        setIndex(0, aVlanDeviceIndex);
    }


    public Integer getMaxVlanId() {
        return (Integer) getProperty(maxVlanId).getValue();
    }

    public void setMaxVlanId(Integer aMaxVlanId) {
        getProperty(maxVlanId).setValue(aMaxVlanId);
    }

    public Integer getMaxSupportVlans() {
        return (Integer) getProperty(maxSupportVlans).getValue();
    }

    public void setMaxSupportVlans(Integer aMaxSupportVlans) {
        getProperty(maxSupportVlans).setValue(aMaxSupportVlans);
    }

    public Integer getCreatedVlanNumber() {
        return (Integer) getProperty(createdVlanNumber).getValue();
    }

    public void setCreatedVlanNumber(Integer aCreatedVlanNumber) {
        getProperty(createdVlanNumber).setValue(aCreatedVlanNumber);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(maxVlanId));
        prepareRead(super.getProperty(maxSupportVlans));
        prepareRead(super.getProperty(createdVlanNumber));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(maxVlanId));
        prepareRead(super.getProperty(maxSupportVlans));
        prepareRead(super.getProperty(createdVlanNumber));

        return loadAll(new int[]{1});
    }


}

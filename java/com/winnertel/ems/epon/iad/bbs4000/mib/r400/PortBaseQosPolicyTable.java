/**
 * Created by Zhou Chao, 2010/5/26
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PortBaseQosPolicyTable extends SnmpMibBean {

    public static final String portBaseQosPolicyDeviceIndex = "portBaseQosPolicyDeviceIndex";
    public static final String portBaseQosPolicyCardIndex = "portBaseQosPolicyCardIndex";
    public static final String portBaseQosPolicyPortIndex = "portBaseQosPolicyPortIndex";
    public static final String portBaseQosPolicyMode = "portBaseQosPolicyMode";
    public static final String portBaseQosPolicyWeightOctet = "portBaseQosPolicyWeightOctet";
    public static final String portBaseQosPolicySpBandwidthRange = "portBaseQosPolicySpBandwidthRange";

    public PortBaseQosPolicyTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(portBaseQosPolicyDeviceIndex, new SnmpMibBeanProperty(portBaseQosPolicyDeviceIndex, ".1.3.6.1.4.1.17409.2.3.8.5.1.1", ISnmpConstant.INTEGER));
        initProperty(portBaseQosPolicyCardIndex, new SnmpMibBeanProperty(portBaseQosPolicyCardIndex, ".1.3.6.1.4.1.17409.2.3.8.5.1.2", ISnmpConstant.INTEGER));
        initProperty(portBaseQosPolicyPortIndex, new SnmpMibBeanProperty(portBaseQosPolicyPortIndex, ".1.3.6.1.4.1.17409.2.3.8.5.1.3", ISnmpConstant.INTEGER));
        initProperty(portBaseQosPolicyMode, new SnmpMibBeanProperty(portBaseQosPolicyMode, ".1.3.6.1.4.1.17409.2.3.8.5.1.4", ISnmpConstant.INTEGER));
        initProperty(portBaseQosPolicyWeightOctet, new SnmpMibBeanProperty(portBaseQosPolicyWeightOctet, ".1.3.6.1.4.1.17409.2.3.8.5.1.5", ISnmpConstant.OCTETS));
        initProperty(portBaseQosPolicySpBandwidthRange, new SnmpMibBeanProperty(portBaseQosPolicySpBandwidthRange, ".1.3.6.1.4.1.17409.2.3.8.5.1.6", ISnmpConstant.OCTETS));
    }

    public Integer getPortBaseQosPolicyDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setPortBaseQosPolicyDeviceIndex(Integer aPortBaseQosPolicyDeviceIndex) {
        setIndex(0, aPortBaseQosPolicyDeviceIndex);
    }

    public Integer getPortBaseQosPolicyCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setPortBaseQosPolicyCardIndex(Integer aPortBaseQosPolicyCardIndex) {
        setIndex(1, aPortBaseQosPolicyCardIndex);
    }

    public Integer getPortBaseQosPolicyPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setPortBaseQosPolicyPortIndex(Integer aPortBaseQosPolicyPortIndex) {
        setIndex(2, aPortBaseQosPolicyPortIndex);
    }

    public Integer getPortBaseQosPolicyMode() {
        return (Integer) getProperty(portBaseQosPolicyMode).getValue();
    }

    public void setPortBaseQosPolicyMode(Integer aPortBaseQosPolicyMode) {
        getProperty(portBaseQosPolicyMode).setValue(aPortBaseQosPolicyMode);
    }

    public byte[] getPortBaseQosPolicyWeightOctet() {
        return (byte[]) getProperty(portBaseQosPolicyWeightOctet).getValue();
    }

    public void setPortBaseQosPolicyWeightOctet(byte[] aPortBaseQosPolicyWeightOctet) {
        getProperty(portBaseQosPolicyWeightOctet).setValue(aPortBaseQosPolicyWeightOctet);
    }

    public byte[] getPortBaseQosPolicySpBandwidthRange() {
        return (byte[]) getProperty(portBaseQosPolicySpBandwidthRange).getValue();
    }

    public void setPortBaseQosPolicySpBandwidthRange(byte[] aPortBaseQosPolicySpBandwidthRange) {
        getProperty(portBaseQosPolicySpBandwidthRange).setValue(aPortBaseQosPolicySpBandwidthRange);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(portBaseQosPolicyMode));
        prepareRead(getProperty(portBaseQosPolicyWeightOctet));
        prepareRead(getProperty(portBaseQosPolicySpBandwidthRange));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(portBaseQosPolicyMode));
        prepareRead(getProperty(portBaseQosPolicyWeightOctet));
        prepareRead(getProperty(portBaseQosPolicySpBandwidthRange));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(portBaseQosPolicyMode));
        prepareSave(getProperty(portBaseQosPolicyWeightOctet));
        prepareSave(getProperty(portBaseQosPolicySpBandwidthRange));

        return save();
    }

}
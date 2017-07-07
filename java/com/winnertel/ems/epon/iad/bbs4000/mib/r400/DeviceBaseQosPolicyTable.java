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

public class DeviceBaseQosPolicyTable extends SnmpMibBean {

    public static final String deviceBaseQosPolicyDeviceIndex = "deviceBaseQosPolicyDeviceIndex";
    public static final String deviceBaseQosPolicyMode = "deviceBaseQosPolicyMode";
    public static final String deviceBaseQosPolicyWeightOctet = "deviceBaseQosPolicyWeightOctet";
    public static final String deviceBaseQosPolicySpBandwidthRange = "deviceBaseQosPolicySpBandwidthRange";

    public DeviceBaseQosPolicyTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(deviceBaseQosPolicyDeviceIndex, new SnmpMibBeanProperty(deviceBaseQosPolicyDeviceIndex, ".1.3.6.1.4.1.17409.2.3.8.3.1.1", ISnmpConstant.INTEGER));
        initProperty(deviceBaseQosPolicyMode, new SnmpMibBeanProperty(deviceBaseQosPolicyMode, ".1.3.6.1.4.1.17409.2.3.8.3.1.2", ISnmpConstant.INTEGER));
        initProperty(deviceBaseQosPolicyWeightOctet, new SnmpMibBeanProperty(deviceBaseQosPolicyWeightOctet, ".1.3.6.1.4.1.17409.2.3.8.3.1.3", ISnmpConstant.OCTETS));
        initProperty(deviceBaseQosPolicySpBandwidthRange, new SnmpMibBeanProperty(deviceBaseQosPolicySpBandwidthRange, ".1.3.6.1.4.1.17409.2.3.8.3.1.4", ISnmpConstant.OCTETS));
    }

    public Integer getDeviceBaseQosPolicyDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setDeviceBaseQosPolicyDeviceIndex(Integer aDeviceBaseQosPolicyDeviceIndex) {
        setIndex(0, aDeviceBaseQosPolicyDeviceIndex);
    }

    public Integer getDeviceBaseQosPolicyMode() {
        return (Integer) getProperty(deviceBaseQosPolicyMode).getValue();
    }

    public void setDeviceBaseQosPolicyMode(Integer aDeviceBaseQosPolicyMode) {
        getProperty(deviceBaseQosPolicyMode).setValue(aDeviceBaseQosPolicyMode);
    }

    public byte[] getDeviceBaseQosPolicyWeightOctet() {
        return (byte[]) getProperty(deviceBaseQosPolicyWeightOctet).getValue();
    }

    public void setDeviceBaseQosPolicyWeightOctet(byte[] aDeviceBaseQosPolicyWeightOctet) {
        getProperty(deviceBaseQosPolicyWeightOctet).setValue(aDeviceBaseQosPolicyWeightOctet);
    }

    public byte[] getDeviceBaseQosPolicySpBandwidthRange() {
        return (byte[]) getProperty(deviceBaseQosPolicySpBandwidthRange).getValue();
    }

    public void setDeviceBaseQosPolicySpBandwidthRange(byte[] aDeviceBaseQosPolicySpBandwidthRange) {
        getProperty(deviceBaseQosPolicySpBandwidthRange).setValue(aDeviceBaseQosPolicySpBandwidthRange);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(deviceBaseQosPolicyMode));
        prepareRead(getProperty(deviceBaseQosPolicyWeightOctet));
        prepareRead(getProperty(deviceBaseQosPolicySpBandwidthRange));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(deviceBaseQosPolicyMode));
        prepareRead(getProperty(deviceBaseQosPolicyWeightOctet));
        prepareRead(getProperty(deviceBaseQosPolicySpBandwidthRange));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(deviceBaseQosPolicyMode));
        prepareSave(getProperty(deviceBaseQosPolicyWeightOctet));
        prepareSave(getProperty(deviceBaseQosPolicySpBandwidthRange));

        return save();
    }

}
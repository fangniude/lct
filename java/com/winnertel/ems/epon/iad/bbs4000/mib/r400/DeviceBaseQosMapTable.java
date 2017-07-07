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

public class DeviceBaseQosMapTable extends SnmpMibBean {

    public static final String deviceBaseQosMapDeviceIndex = "deviceBaseQosMapDeviceIndex";
    public static final String deviceBaseQosMapRuleIndex = "deviceBaseQosMapRuleIndex";
    public static final String deviceBaseQosMapOctet = "deviceBaseQosMapOctet";

    public DeviceBaseQosMapTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(deviceBaseQosMapDeviceIndex, new SnmpMibBeanProperty(deviceBaseQosMapDeviceIndex, ".1.3.6.1.4.1.17409.2.3.8.2.1.1", ISnmpConstant.INTEGER));
        initProperty(deviceBaseQosMapRuleIndex, new SnmpMibBeanProperty(deviceBaseQosMapRuleIndex, ".1.3.6.1.4.1.17409.2.3.8.2.1.2", ISnmpConstant.INTEGER));
        initProperty(deviceBaseQosMapOctet, new SnmpMibBeanProperty(deviceBaseQosMapOctet, ".1.3.6.1.4.1.17409.2.3.8.2.1.3", ISnmpConstant.OCTETS));
    }

    public Integer getDeviceBaseQosMapDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setDeviceBaseQosMapDeviceIndex(Integer aDeviceBaseQosMapDeviceIndex) {
        setIndex(0, aDeviceBaseQosMapDeviceIndex);
    }

    public Integer getDeviceBaseQosMapRuleIndex() {
        return (Integer) getIndex(1);
    }

    public void setDeviceBaseQosMapRuleIndex(Integer aDeviceBaseQosMapRuleIndex) {
        setIndex(1, aDeviceBaseQosMapRuleIndex);
    }

    public byte[] getDeviceBaseQosMapOctet() {
        return (byte[]) getProperty(deviceBaseQosMapOctet).getValue();
    }

    public void setDeviceBaseQosMapOctet(byte[] aDeviceBaseQosMapOctet) {
        getProperty(deviceBaseQosMapOctet).setValue(aDeviceBaseQosMapOctet);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(deviceBaseQosMapOctet));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(deviceBaseQosMapOctet));

        return loadAll(new int[]{1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(deviceBaseQosMapOctet));

        return save();
    }

}
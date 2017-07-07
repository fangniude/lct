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

public class PortBaseQosMapTable extends SnmpMibBean {

    public static final String portBaseQosMapDeviceIndex = "portBaseQosMapDeviceIndex";
    public static final String portBaseQosMapCardIndex = "portBaseQosMapCardIndex";
    public static final String portBaseQosMapPortIndex = "portBaseQosMapPortIndex";
    public static final String portBaseQosMapRuleIndex = "portBaseQosMapRuleIndex";
    public static final String portBaseQosMapOctet = "portBaseQosMapOctet";

    public PortBaseQosMapTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(portBaseQosMapDeviceIndex, new SnmpMibBeanProperty(portBaseQosMapDeviceIndex, ".1.3.6.1.4.1.17409.2.3.8.4.1.1", ISnmpConstant.INTEGER));
        initProperty(portBaseQosMapCardIndex, new SnmpMibBeanProperty(portBaseQosMapCardIndex, ".1.3.6.1.4.1.17409.2.3.8.4.1.2", ISnmpConstant.INTEGER));
        initProperty(portBaseQosMapPortIndex, new SnmpMibBeanProperty(portBaseQosMapPortIndex, ".1.3.6.1.4.1.17409.2.3.8.4.1.3", ISnmpConstant.INTEGER));
        initProperty(portBaseQosMapRuleIndex, new SnmpMibBeanProperty(portBaseQosMapRuleIndex, ".1.3.6.1.4.1.17409.2.3.8.4.1.4", ISnmpConstant.INTEGER));
        initProperty(portBaseQosMapOctet, new SnmpMibBeanProperty(portBaseQosMapOctet, ".1.3.6.1.4.1.17409.2.3.8.4.1.5", ISnmpConstant.OCTETS));
    }

    public Integer getPortBaseQosMapDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setPortBaseQosMapDeviceIndex(Integer aPortBaseQosMapDeviceIndex) {
        setIndex(0, aPortBaseQosMapDeviceIndex);
    }

    public Integer getPortBaseQosMapCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setPortBaseQosMapCardIndex(Integer aPortBaseQosMapCardIndex) {
        setIndex(1, aPortBaseQosMapCardIndex);
    }

    public Integer getPortBaseQosMapPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setPortBaseQosMapPortIndex(Integer aPortBaseQosMapPortIndex) {
        setIndex(2, aPortBaseQosMapPortIndex);
    }

    public Integer getPortBaseQosMapRuleIndex() {
        return (Integer) getIndex(3);
    }

    public void setPortBaseQosMapRuleIndex(Integer aPortBaseQosMapRuleIndex) {
        setIndex(3, aPortBaseQosMapRuleIndex);
    }

    public byte[] getPortBaseQosMapOctet() {
        return (byte[]) getProperty(portBaseQosMapOctet).getValue();
    }

    public void setPortBaseQosMapOctet(byte[] aPortBaseQosMapOctet) {
        getProperty(portBaseQosMapOctet).setValue(aPortBaseQosMapOctet);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(portBaseQosMapOctet));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(portBaseQosMapOctet));

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(portBaseQosMapOctet));

        return save();
    }

}
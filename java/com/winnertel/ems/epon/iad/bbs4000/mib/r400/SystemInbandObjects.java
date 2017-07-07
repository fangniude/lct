package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class SystemInbandObjects extends SnmpMibBean {

    public static final String inbandIpAddress = "inbandIpAddress";
    public static final String inbandIpSubnetMask = "inbandIpSubnetMask";
    public static final String inbandIpGateway = "inbandIpGateway";
    public static final String inbandVlanId = "inbandVlanId";
    public static final String inbandMacAddress = "inbandMacAddress";

    public SystemInbandObjects(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(inbandIpAddress, new SnmpMibBeanProperty(inbandIpAddress, ".1.3.6.1.4.1.17409.2.3.1.1.2", ISnmpConstant.IP_ADDRESS));
        initProperty(inbandIpSubnetMask, new SnmpMibBeanProperty(inbandIpSubnetMask, ".1.3.6.1.4.1.17409.2.3.1.1.3", ISnmpConstant.IP_ADDRESS));
        initProperty(inbandIpGateway, new SnmpMibBeanProperty(inbandIpGateway, ".1.3.6.1.4.1.17409.2.3.1.1.4", ISnmpConstant.IP_ADDRESS));
        initProperty(inbandVlanId, new SnmpMibBeanProperty(inbandVlanId, ".1.3.6.1.4.1.17409.2.3.1.1.5", ISnmpConstant.INTEGER));
        initProperty(inbandMacAddress, new SnmpMibBeanProperty(inbandMacAddress, ".1.3.6.1.4.1.17409.2.3.1.1.6", ISnmpConstant.MAC_ADDRESS));
    }

    public String getInbandIpAddress() {
        return (String) getProperty(inbandIpAddress).getValue();
    }

    public void setInbandIpAddress(String aInbandIpAddress) {
        getProperty(inbandIpAddress).setValue(aInbandIpAddress);
    }

    public String getInbandIpSubnetMask() {
        return (String) getProperty(inbandIpSubnetMask).getValue();
    }

    public void setInbandIpSubnetMask(String aInbandIpSubnetMask) {
        getProperty(inbandIpSubnetMask).setValue(aInbandIpSubnetMask);
    }

    public String getInbandIpGateway() {
        return (String) getProperty(inbandIpGateway).getValue();
    }

    public void setInbandIpGateway(String aInbandIpGateway) {
        getProperty(inbandIpGateway).setValue(aInbandIpGateway);
    }

    public Integer getInbandVlanId() {
        return (Integer) getProperty(inbandVlanId).getValue();
    }

    public void setInbandVlanId(Integer aInbandVlanId) {
        getProperty(inbandVlanId).setValue(aInbandVlanId);
    }

    public byte[] getInbandMacAddress() {
        return (byte[]) getProperty(inbandMacAddress).getValue();
    }

    public void setInbandMacAddress(byte[] aInbandMacAddress) {
        getProperty(inbandMacAddress).setValue(aInbandMacAddress);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(inbandIpAddress));
        prepareRead(getProperty(inbandIpSubnetMask));
        prepareRead(getProperty(inbandIpGateway));
        prepareRead(getProperty(inbandVlanId));
        prepareRead(getProperty(inbandMacAddress));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(inbandIpAddress));
        prepareSave(getProperty(inbandIpSubnetMask));
        prepareSave(getProperty(inbandIpGateway));
        prepareSave(getProperty(inbandVlanId));

        return save();
    }

}
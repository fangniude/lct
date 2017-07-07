package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class SystemOutbandObjects extends SnmpMibBean {

    public static final String outbandIpAddress = "outbandIpAddress";
    public static final String outbandIpSubnetMask = "outbandIpSubnetMask";
    public static final String outbandIpGateway = "outbandIpGateway";
    public static final String outbandMacAddress = "outbandMacAddress";
    public static final String systemOUI = "systemOUI";
    public static final String vendorName = "vendorName";

    public SystemOutbandObjects(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(outbandIpAddress, new SnmpMibBeanProperty(outbandIpAddress, ".1.3.6.1.4.1.17409.2.3.1.1.7", ISnmpConstant.IP_ADDRESS));
        initProperty(outbandIpSubnetMask, new SnmpMibBeanProperty(outbandIpSubnetMask, ".1.3.6.1.4.1.17409.2.3.1.1.8", ISnmpConstant.IP_ADDRESS));
        initProperty(outbandIpGateway, new SnmpMibBeanProperty(outbandIpGateway, ".1.3.6.1.4.1.17409.2.3.1.1.9", ISnmpConstant.IP_ADDRESS));
        initProperty(outbandMacAddress, new SnmpMibBeanProperty(outbandMacAddress, ".1.3.6.1.4.1.17409.2.3.1.1.10", ISnmpConstant.MAC_ADDRESS));
        initProperty(systemOUI, new SnmpMibBeanProperty(systemOUI, ".1.3.6.1.4.1.17409.2.3.1.1.11", ISnmpConstant.OCTETS));
        initProperty(vendorName, new SnmpMibBeanProperty(vendorName, ".1.3.6.1.4.1.17409.2.3.1.1.12", ISnmpConstant.STRING));
    }

    public String getOutbandIpAddress() {
        return (String) getProperty(outbandIpAddress).getValue();
    }

    public void setOutbandIpAddress(String aOutbandIpAddress) {
        getProperty(outbandIpAddress).setValue(aOutbandIpAddress);
    }

    public String getOutbandIpSubnetMask() {
        return (String) getProperty(outbandIpSubnetMask).getValue();
    }

    public void setOutbandIpSubnetMask(String aOutbandIpSubnetMask) {
        getProperty(outbandIpSubnetMask).setValue(aOutbandIpSubnetMask);
    }

    public String getOutbandIpGateway() {
        return (String) getProperty(outbandIpGateway).getValue();
    }

    public void setOutbandIpGateway(String aOutbandIpGateway) {
        getProperty(outbandIpGateway).setValue(aOutbandIpGateway);
    }

    public byte[] getOutbandMacAddress() {
        return (byte[]) getProperty(outbandMacAddress).getValue();
    }

    public void setOutbandMacAddress(byte[] aOutbandMacAddress) {
        getProperty(outbandMacAddress).setValue(aOutbandMacAddress);
    }

    public byte[] getSystemOUI() {
        return (byte[]) getProperty(systemOUI).getValue();
    }

    public void setSystemOUI(byte[] aSystemOUI) {
        getProperty(systemOUI).setValue(aSystemOUI);
    }

    public String getVendorName() {
        return (String) getProperty(vendorName).getValue();
    }

    public void setVendorName(String aVendorName) {
        getProperty(vendorName).setValue(aVendorName);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(outbandIpAddress));
        prepareRead(getProperty(outbandIpSubnetMask));
        prepareRead(getProperty(outbandIpGateway));
        prepareRead(getProperty(outbandMacAddress));
        prepareRead(getProperty(systemOUI));
        prepareRead(getProperty(vendorName));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(outbandIpAddress));
        prepareSave(getProperty(outbandIpSubnetMask));
        prepareSave(getProperty(outbandIpGateway));

        return save();
    }

}
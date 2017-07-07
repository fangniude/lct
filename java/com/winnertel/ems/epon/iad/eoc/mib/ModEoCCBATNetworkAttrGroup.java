package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCBATNetworkAttrGroup class.
 * Created by QuickDVM
 */
public class ModEoCCBATNetworkAttrGroup extends EocBaseSnmpMibBean {
    public static final String modEoCCBATAdminMACAddress = "modEoCCBATAdminMACAddress";
    public static final String modEoCCBATAdminIPMode = "modEoCCBATAdminIPMode";
    public static final String modEoCCBATAdminIPAddress = "modEoCCBATAdminIPAddress";
    public static final String modEoCCBATAdminIPMask = "modEoCCBATAdminIPMask";
    public static final String modEoCCBATAdminIPGateway = "modEoCCBATAdminIPGateway";

    public ModEoCCBATNetworkAttrGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCBATAdminMACAddress, new SnmpMibBeanProperty(modEoCCBATAdminMACAddress, MIB_Head1 + ".1.2.1", ISnmpConstant.OCTETS));
        initProperty(modEoCCBATAdminIPMode, new SnmpMibBeanProperty(modEoCCBATAdminIPMode, MIB_Head1 + ".1.2.2", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminIPAddress, new SnmpMibBeanProperty(modEoCCBATAdminIPAddress, MIB_Head1 + ".1.2.3", ISnmpConstant.IP_ADDRESS));
        initProperty(modEoCCBATAdminIPMask, new SnmpMibBeanProperty(modEoCCBATAdminIPMask, MIB_Head1 + ".1.2.4", ISnmpConstant.IP_ADDRESS));
        initProperty(modEoCCBATAdminIPGateway, new SnmpMibBeanProperty(modEoCCBATAdminIPGateway, MIB_Head1 + ".1.2.5", ISnmpConstant.IP_ADDRESS));

    }


    public byte[] getModEoCCBATAdminMACAddress() {
        return (byte[]) getProperty(modEoCCBATAdminMACAddress).getValue();
    }

    public void setModEoCCBATAdminMACAddress(byte[] aModEoCCBATAdminMACAddress) {
        getProperty(modEoCCBATAdminMACAddress).setValue(aModEoCCBATAdminMACAddress);
    }

    public Integer getModEoCCBATAdminIPMode() {
        return (Integer) getProperty(modEoCCBATAdminIPMode).getValue();
    }

    public void setModEoCCBATAdminIPMode(Integer aModEoCCBATAdminIPMode) {
        getProperty(modEoCCBATAdminIPMode).setValue(aModEoCCBATAdminIPMode);
    }

    public String getModEoCCBATAdminIPAddress() {
        return (String) getProperty(modEoCCBATAdminIPAddress).getValue();
    }

    public void setModEoCCBATAdminIPAddress(String aModEoCCBATAdminIPAddress) {
        getProperty(modEoCCBATAdminIPAddress).setValue(aModEoCCBATAdminIPAddress);
    }

    public String getModEoCCBATAdminIPMask() {
        return (String) getProperty(modEoCCBATAdminIPMask).getValue();
    }

    public void setModEoCCBATAdminIPMask(String aModEoCCBATAdminIPMask) {
        getProperty(modEoCCBATAdminIPMask).setValue(aModEoCCBATAdminIPMask);
    }

    public String getModEoCCBATAdminIPGateway() {
        return (String) getProperty(modEoCCBATAdminIPGateway).getValue();
    }

    public void setModEoCCBATAdminIPGateway(String aModEoCCBATAdminIPGateway) {
        getProperty(modEoCCBATAdminIPGateway).setValue(aModEoCCBATAdminIPGateway);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATAdminMACAddress));
        prepareRead(super.getProperty(modEoCCBATAdminIPMode));
        prepareRead(super.getProperty(modEoCCBATAdminIPAddress));
        prepareRead(super.getProperty(modEoCCBATAdminIPMask));
        prepareRead(super.getProperty(modEoCCBATAdminIPGateway));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCBATAdminIPMode));
        prepareSave(getProperty(modEoCCBATAdminIPAddress));
        prepareSave(getProperty(modEoCCBATAdminIPMask));
        prepareSave(getProperty(modEoCCBATAdminIPGateway));

        return save();
    }


}
package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCSoftwareUpgradeGroup class.
 * Created by QuickDVM
 */
public class ModEoCSoftwareUpgradeGroup extends EocBaseSnmpMibBean {
    public static final String modEoCSoftwaretUpgradeServerIP = "modEoCSoftwaretUpgradeServerIP";
    public static final String modEoCSoftwareUpgradeServerPort = "modEoCSoftwareUpgradeServerPort";
    public static final String modEoCSoftwareUpgradeLogin = "modEoCSoftwareUpgradeLogin";
    public static final String modEoCSoftwareUpgradePassWord = "modEoCSoftwareUpgradePassWord";

    public ModEoCSoftwareUpgradeGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCSoftwaretUpgradeServerIP, new SnmpMibBeanProperty(modEoCSoftwaretUpgradeServerIP, MIB_Head1 + ".4.1", ISnmpConstant.IP_ADDRESS));
        initProperty(modEoCSoftwareUpgradeServerPort, new SnmpMibBeanProperty(modEoCSoftwareUpgradeServerPort, MIB_Head1 + ".4.2", ISnmpConstant.INTEGER));
        initProperty(modEoCSoftwareUpgradeLogin, new SnmpMibBeanProperty(modEoCSoftwareUpgradeLogin, MIB_Head1 + ".4.3", ISnmpConstant.STRING));
        initProperty(modEoCSoftwareUpgradePassWord, new SnmpMibBeanProperty(modEoCSoftwareUpgradePassWord, MIB_Head1 + ".4.4", ISnmpConstant.STRING));

    }


    public String getModEoCSoftwaretUpgradeServerIP() {
        return (String) getProperty(modEoCSoftwaretUpgradeServerIP).getValue();
    }

    public void setModEoCSoftwaretUpgradeServerIP(String aModEoCSoftwaretUpgradeServerIP) {
        getProperty(modEoCSoftwaretUpgradeServerIP).setValue(aModEoCSoftwaretUpgradeServerIP);
    }

    public Integer getModEoCSoftwareUpgradeServerPort() {
        return (Integer) getProperty(modEoCSoftwareUpgradeServerPort).getValue();
    }

    public void setModEoCSoftwareUpgradeServerPort(Integer aModEoCSoftwareUpgradeServerPort) {
        getProperty(modEoCSoftwareUpgradeServerPort).setValue(aModEoCSoftwareUpgradeServerPort);
    }

    public String getModEoCSoftwareUpgradeLogin() {
        return (String) getProperty(modEoCSoftwareUpgradeLogin).getValue();
    }

    public void setModEoCSoftwareUpgradeLogin(String aModEoCSoftwareUpgradeLogin) {
        getProperty(modEoCSoftwareUpgradeLogin).setValue(aModEoCSoftwareUpgradeLogin);
    }

    public String getModEoCSoftwareUpgradePassWord() {
        return (String) getProperty(modEoCSoftwareUpgradePassWord).getValue();
    }

    public void setModEoCSoftwareUpgradePassWord(String aModEoCSoftwareUpgradePassWord) {
        getProperty(modEoCSoftwareUpgradePassWord).setValue(aModEoCSoftwareUpgradePassWord);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCSoftwaretUpgradeServerIP));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeServerPort));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeLogin));
        prepareRead(super.getProperty(modEoCSoftwareUpgradePassWord));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCSoftwaretUpgradeServerIP));
        prepareSave(getProperty(modEoCSoftwareUpgradeServerPort));
        prepareSave(getProperty(modEoCSoftwareUpgradeLogin));
        prepareSave(getProperty(modEoCSoftwareUpgradePassWord));

        return save();
    }


}
    
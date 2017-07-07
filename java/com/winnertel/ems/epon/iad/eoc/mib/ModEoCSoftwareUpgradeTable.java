package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCSoftwareUpgradeTable class.
 * Created by QuickDVM
 */
public class ModEoCSoftwareUpgradeTable extends EocBaseSnmpMibBean {
    public static final String modEoCSoftwareUpgradeCBATCardIndex = "modEoCSoftwareUpgradeCBATCardIndex";
    public static final String modEoCSoftwareUpgradeCNUIndex = "modEoCSoftwareUpgradeCNUIndex";
    public static final String modEoCSoftwareUpgradeMACAddress = "modEoCSoftwareUpgradeMACAddress";
    public static final String modEoCSoftwareUpgradeDevType = "modEoCSoftwareUpgradeDevType";
    public static final String modEoCSoftwareUpgradeFileName = "modEoCSoftwareUpgradeFileName";
    public static final String modEoCSoftwareUpgradeProceed = "modEoCSoftwareUpgradeProceed";
    public static final String modEoCSoftwareUpgradeResult = "modEoCSoftwareUpgradeResult";

    public ModEoCSoftwareUpgradeTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCSoftwareUpgradeCBATCardIndex, new SnmpMibBeanProperty(modEoCSoftwareUpgradeCBATCardIndex, MIB_Head1 + ".4.5.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCSoftwareUpgradeCNUIndex, new SnmpMibBeanProperty(modEoCSoftwareUpgradeCNUIndex, MIB_Head1 + ".4.5.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCSoftwareUpgradeMACAddress, new SnmpMibBeanProperty(modEoCSoftwareUpgradeMACAddress, MIB_Head1 + ".4.5.1.3", ISnmpConstant.OCTETS));
        initProperty(modEoCSoftwareUpgradeDevType, new SnmpMibBeanProperty(modEoCSoftwareUpgradeDevType, MIB_Head1 + ".4.5.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCSoftwareUpgradeFileName, new SnmpMibBeanProperty(modEoCSoftwareUpgradeFileName, MIB_Head1 + ".4.5.1.5", ISnmpConstant.STRING));
        initProperty(modEoCSoftwareUpgradeProceed, new SnmpMibBeanProperty(modEoCSoftwareUpgradeProceed, MIB_Head1 + ".4.5.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCSoftwareUpgradeResult, new SnmpMibBeanProperty(modEoCSoftwareUpgradeResult, MIB_Head1 + ".4.5.1.7", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCSoftwareUpgradeCBATCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCSoftwareUpgradeCBATCardIndex(Integer aModEoCSoftwareUpgradeCBATCardIndex) {
        setIndex(0, aModEoCSoftwareUpgradeCBATCardIndex);
    }


    public Integer getModEoCSoftwareUpgradeCNUIndex() {
        return (Integer) getIndex(1);
    }

    public void setModEoCSoftwareUpgradeCNUIndex(Integer aModEoCSoftwareUpgradeCNUIndex) {
        setIndex(1, aModEoCSoftwareUpgradeCNUIndex);
    }


    public byte[] getModEoCSoftwareUpgradeMACAddress() {
        return (byte[]) getProperty(modEoCSoftwareUpgradeMACAddress).getValue();
    }

    public void setModEoCSoftwareUpgradeMACAddress(byte[] aModEoCSoftwareUpgradeMACAddress) {
        getProperty(modEoCSoftwareUpgradeMACAddress).setValue(aModEoCSoftwareUpgradeMACAddress);
    }

    public Integer getModEoCSoftwareUpgradeDevType() {
        return (Integer) getProperty(modEoCSoftwareUpgradeDevType).getValue();
    }

    public void setModEoCSoftwareUpgradeDevType(Integer aModEoCSoftwareUpgradeDevType) {
        getProperty(modEoCSoftwareUpgradeDevType).setValue(aModEoCSoftwareUpgradeDevType);
    }

    public String getModEoCSoftwareUpgradeFileName() {
        return (String) getProperty(modEoCSoftwareUpgradeFileName).getValue();
    }

    public void setModEoCSoftwareUpgradeFileName(String aModEoCSoftwareUpgradeFileName) {
        getProperty(modEoCSoftwareUpgradeFileName).setValue(aModEoCSoftwareUpgradeFileName);
    }

    public Integer getModEoCSoftwareUpgradeProceed() {
        return (Integer) getProperty(modEoCSoftwareUpgradeProceed).getValue();
    }

    public void setModEoCSoftwareUpgradeProceed(Integer aModEoCSoftwareUpgradeProceed) {
        getProperty(modEoCSoftwareUpgradeProceed).setValue(aModEoCSoftwareUpgradeProceed);
    }

    public Integer getModEoCSoftwareUpgradeResult() {
        return (Integer) getProperty(modEoCSoftwareUpgradeResult).getValue();
    }

    public void setModEoCSoftwareUpgradeResult(Integer aModEoCSoftwareUpgradeResult) {
        getProperty(modEoCSoftwareUpgradeResult).setValue(aModEoCSoftwareUpgradeResult);
    }


    public boolean retrieve() throws MibBeanException {
        //prepareRead(super.getProperty(modEoCSoftwareUpgradeMACAddress));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeDevType));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeFileName));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeProceed));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeResult));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        //prepareRead(super.getProperty(modEoCSoftwareUpgradeMACAddress));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeDevType));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeFileName));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeProceed));
        prepareRead(super.getProperty(modEoCSoftwareUpgradeResult));

        return loadAll(new int[]{1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        //prepareSave(getProperty(modEoCSoftwareUpgradeMACAddress));
        prepareSave(getProperty(modEoCSoftwareUpgradeDevType));
        prepareSave(getProperty(modEoCSoftwareUpgradeFileName));
        prepareSave(getProperty(modEoCSoftwareUpgradeProceed));

        return save();
    }


}
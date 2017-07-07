/**
 * Created by Zhou Chao, 2009/8/13
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r216;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuConfigOamTable extends SnmpMibBean {

    public static final String utsOnuSlotId = "utsOnuSlotId";
    public static final String utsOnuPortId = "utsOnuPortId";
    public static final String utsOnuLogicalPortId = "utsOnuLogicalPortId";

    public static final String utsOnuHardwareType = "utsOnuHardwareType";
    public static final String utsOnuHardwareRev = "utsOnuHardwareRev";
    public static final String utsOnuFirmwareVersion = "utsOnuFirmwareVersion";
    public static final String utsOnuSoftwareVersion = "utsOnuSoftwareVersion";
    public static final String utsOnuMacAddress = "utsOnuMacAddress";

    public static final String utsOnuRegistrationStatus = "utsOnuRegistrationStatus";

    public static final String utsOnuCtcExtOamEnable = "utsOnuCtcExtOamEnable";
    public static final String utsOnuDescription = "utsOnuDescription";
    public static final String utsOnuAdminStatus = "utsOnuAdminStatus";

    public OnuConfigOamTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsOnuSlotId, new SnmpMibBeanProperty(utsOnuSlotId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsOnuPortId, new SnmpMibBeanProperty(utsOnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsOnuLogicalPortId, new SnmpMibBeanProperty(utsOnuLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.3", ISnmpConstant.INTEGER));

        initProperty(utsOnuHardwareType, new SnmpMibBeanProperty(utsOnuHardwareType, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsOnuHardwareRev, new SnmpMibBeanProperty(utsOnuHardwareRev, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.5", ISnmpConstant.STRING));
        initProperty(utsOnuFirmwareVersion, new SnmpMibBeanProperty(utsOnuFirmwareVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.6", ISnmpConstant.STRING));
        initProperty(utsOnuSoftwareVersion, new SnmpMibBeanProperty(utsOnuSoftwareVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.7", ISnmpConstant.STRING));
        initProperty(utsOnuMacAddress, new SnmpMibBeanProperty(utsOnuMacAddress, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.8", ISnmpConstant.MAC_ADDRESS));

        initProperty(utsOnuRegistrationStatus, new SnmpMibBeanProperty(utsOnuRegistrationStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.2.1.1", ISnmpConstant.INTEGER));

        initProperty(utsOnuCtcExtOamEnable, new SnmpMibBeanProperty(utsOnuCtcExtOamEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.3.1.1", ISnmpConstant.INTEGER));
        initProperty(utsOnuDescription, new SnmpMibBeanProperty(utsOnuDescription, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.3.1.2", ISnmpConstant.STRING));
        initProperty(utsOnuAdminStatus, new SnmpMibBeanProperty(utsOnuAdminStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.3.1.32", ISnmpConstant.INTEGER));
    }

    public Integer getUtsOnuSlotId() {
        return (Integer) getIndex(0);
    }

    public void setUtsOnuSlotId(Integer aUtsOnuSlotId) {
        setIndex(0, aUtsOnuSlotId);
    }

    public Integer getUtsOnuPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsOnuPortId(Integer aUtsOnuPortId) {
        setIndex(1, aUtsOnuPortId);
    }

    public Integer getUtsOnuLogicalPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsOnuLogicalPortId(Integer aUtsOnuLogicalPortId) {
        setIndex(2, aUtsOnuLogicalPortId);
    }

    public Integer getUtsOnuHardwareType() {
        return (Integer) getProperty(utsOnuHardwareType).getValue();
    }

    public void setUtsOnuHardwareType(Integer aUtsOnuHardwareType) {
        getProperty(utsOnuHardwareType).setValue(aUtsOnuHardwareType);
    }

    public String getUtsOnuHardwareRev() {
        return (String) getProperty(utsOnuHardwareRev).getValue();
    }

    public void setUtsOnuHardwareRev(String aUtsOnuHardwareRev) {
        getProperty(utsOnuHardwareRev).setValue(aUtsOnuHardwareRev);
    }

    public String getUtsOnuFirmwareVersion() {
        return (String) getProperty(utsOnuFirmwareVersion).getValue();
    }

    public void setUtsOnuFirmwareVersion(String aUtsOnuFirmwareVersion) {
        getProperty(utsOnuFirmwareVersion).setValue(aUtsOnuFirmwareVersion);
    }

    public String getUtsOnuSoftwareVersion() {
        return (String) getProperty(utsOnuSoftwareVersion).getValue();
    }

    public void setUtsOnuSoftwareVersion(String aUtsOnuSoftwareVersion) {
        getProperty(utsOnuSoftwareVersion).setValue(aUtsOnuSoftwareVersion);
    }

    public byte[] getUtsOnuMacAddress() {
        return (byte[]) getProperty(utsOnuMacAddress).getValue();
    }

    public void setUtsOnuMacAddress(byte[] aUtsOnuMacAddress) {
        getProperty(utsOnuMacAddress).setValue(aUtsOnuMacAddress);
    }

    public Integer getUtsOnuRegistrationStatus() {
        return (Integer) getProperty(utsOnuRegistrationStatus).getValue();
    }

    public void setUtsOnuRegistrationStatus(Integer aUtsOnuRegistrationStatus) {
        getProperty(utsOnuRegistrationStatus).setValue(aUtsOnuRegistrationStatus);
    }

    public Integer getUtsOnuCtcExtOamEnable() {
        return (Integer) getProperty(utsOnuCtcExtOamEnable).getValue();
    }

    public void setUtsOnuCtcExtOamEnable(Integer aUtsOnuCtcExtOamEnable) {
        getProperty(utsOnuCtcExtOamEnable).setValue(aUtsOnuCtcExtOamEnable);
    }

    public String getUtsOnuDescription() {
        return (String) getProperty(utsOnuDescription).getValue();
    }

    public void setUtsOnuDescription(String aUtsOnuDescription) {
        getProperty(utsOnuDescription).setValue(aUtsOnuDescription);
    }

    public Integer getUtsOnuAdminStatus() {
        return (Integer) getProperty(utsOnuAdminStatus).getValue();
    }

    public void setUtsOnuAdminStatus(Integer aUtsOnuAdminStatus) {
        getProperty(utsOnuAdminStatus).setValue(aUtsOnuAdminStatus);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsOnuHardwareType));
        prepareRead(getProperty(utsOnuHardwareRev));
        prepareRead(getProperty(utsOnuFirmwareVersion));
        prepareRead(getProperty(utsOnuSoftwareVersion));
        prepareRead(getProperty(utsOnuMacAddress));

        prepareRead(getProperty(utsOnuRegistrationStatus));

        prepareRead(getProperty(utsOnuCtcExtOamEnable));
        prepareRead(getProperty(utsOnuDescription));
        prepareRead(getProperty(utsOnuAdminStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsOnuHardwareType));
        prepareRead(getProperty(utsOnuHardwareRev));
        prepareRead(getProperty(utsOnuFirmwareVersion));
        prepareRead(getProperty(utsOnuSoftwareVersion));
        prepareRead(getProperty(utsOnuMacAddress));

        prepareRead(getProperty(utsOnuRegistrationStatus));

        prepareRead(getProperty(utsOnuCtcExtOamEnable));
        prepareRead(getProperty(utsOnuDescription));
        prepareRead(getProperty(utsOnuAdminStatus));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsOnuHardwareType));
        prepareSave(getProperty(utsOnuHardwareRev));
        prepareSave(getProperty(utsOnuFirmwareVersion));
        prepareSave(getProperty(utsOnuSoftwareVersion));
        prepareSave(getProperty(utsOnuMacAddress));

        prepareSave(getProperty(utsOnuRegistrationStatus));

        prepareSave(getProperty(utsOnuCtcExtOamEnable));
        prepareSave(getProperty(utsOnuDescription));
        prepareSave(getProperty(utsOnuAdminStatus));

        return save();
    }

    public String toString() {
        return new StringBuffer().append(getUtsOnuSlotId()).append("-").append(getUtsOnuPortId()).append("-").append(getUtsOnuLogicalPortId()).toString();
    }

}
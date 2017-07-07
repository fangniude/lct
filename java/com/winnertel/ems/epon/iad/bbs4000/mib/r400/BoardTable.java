package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class BoardTable extends SnmpMibBean {

    public static final String deviceIndex = "deviceIndex";
    public static final String cardIndex = "cardIndex";
    public static final String type = "type";
    public static final String attribute = "attribute";
    public static final String operationStatus = "operationStatus";
    public static final String adminStatus = "adminStatus";
    public static final String hardwareVersion = "hardwareVersion";
    public static final String firmwareVersion = "firmwareVersion";
    public static final String softwareVersion = "softwareVersion";
    public static final String upTime = "upTime";
    public static final String alarmStatus = "alarmStatus";
    public static final String serialNumber = "serialNumber";
    public static final String action = "action";
    public static final String name = "name";
    public static final String presenceStatus = "presenceStatus";

    public BoardTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(deviceIndex, new SnmpMibBeanProperty(deviceIndex, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(cardIndex, new SnmpMibBeanProperty(cardIndex, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(type, new SnmpMibBeanProperty(type, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.3", ISnmpConstant.INTEGER));
        initProperty(attribute, new SnmpMibBeanProperty(attribute, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.4", ISnmpConstant.INTEGER));
        initProperty(operationStatus, new SnmpMibBeanProperty(operationStatus, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.5", ISnmpConstant.INTEGER));
        initProperty(adminStatus, new SnmpMibBeanProperty(adminStatus, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.6", ISnmpConstant.INTEGER));
        initProperty(hardwareVersion, new SnmpMibBeanProperty(hardwareVersion, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.7", ISnmpConstant.STRING));
        initProperty(firmwareVersion, new SnmpMibBeanProperty(firmwareVersion, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.8", ISnmpConstant.STRING));
        initProperty(softwareVersion, new SnmpMibBeanProperty(softwareVersion, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.9", ISnmpConstant.STRING));
        initProperty(upTime, new SnmpMibBeanProperty(upTime, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.10", ISnmpConstant.COUNTER));
        initProperty(alarmStatus, new SnmpMibBeanProperty(alarmStatus, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.11", ISnmpConstant.OCTETS));
        initProperty(serialNumber, new SnmpMibBeanProperty(serialNumber, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.12", ISnmpConstant.STRING));
        initProperty(action, new SnmpMibBeanProperty(action, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.13", ISnmpConstant.INTEGER));
        initProperty(name, new SnmpMibBeanProperty(name, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.14", ISnmpConstant.STRING));
        initProperty(presenceStatus, new SnmpMibBeanProperty(presenceStatus, ".1.3.6.1.4.1.17409.2.3.1.3.1.1.15", ISnmpConstant.INTEGER));
    }

    public Integer getDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setDeviceIndex(Integer aBDeviceIndex) {
        setIndex(0, aBDeviceIndex);
    }

    public Integer getCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setCardIndex(Integer aBCardIndex) {
        setIndex(1, aBCardIndex);
    }

    public Integer getType() {
        return (Integer) getProperty(type).getValue();
    }

    public void setType(Integer aBType) {
        getProperty(type).setValue(aBType);
    }

    public Integer getAttribute() {
        return (Integer) getProperty(attribute).getValue();
    }

    public void setAttribute(Integer aBAttribute) {
        getProperty(attribute).setValue(aBAttribute);
    }

    public Integer getOperationStatus() {
        return (Integer) getProperty(operationStatus).getValue();
    }

    public void setOperationStatus(Integer aOperationStatus) {
        getProperty(operationStatus).setValue(aOperationStatus);
    }

    public Integer getAdminStatus() {
        return (Integer) getProperty(adminStatus).getValue();
    }

    public void setAdminStatus(Integer aBAdminStatus) {
        getProperty(adminStatus).setValue(aBAdminStatus);
    }

    public String getHardwareVersion() {
        return (String) getProperty(hardwareVersion).getValue();
    }

    public void setHardwareVersion(String aBHardwareVersion) {
        getProperty(hardwareVersion).setValue(aBHardwareVersion);
    }

    public String getFirmwareVersion() {
        return (String) getProperty(firmwareVersion).getValue();
    }

    public void setFirmwareVersion(String aBFirmwareVersion) {
        getProperty(firmwareVersion).setValue(aBFirmwareVersion);
    }

    public String getSoftwareVersion() {
        return (String) getProperty(softwareVersion).getValue();
    }

    public void setSoftwareVersion(String aBSoftwareVersion) {
        getProperty(softwareVersion).setValue(aBSoftwareVersion);
    }

    public Long getUpTime() {
        return (Long) getProperty(upTime).getValue();
    }

    public void setUpTime(Long aBUpTime) {
        getProperty(upTime).setValue(aBUpTime);
    }

    public byte[] getAlarmStatus() {
        return (byte[]) getProperty(alarmStatus).getValue();
    }

    public void setAlarmStatus(byte[] aBAlarmStatus) {
        getProperty(alarmStatus).setValue(aBAlarmStatus);
    }

    public String getSerialNumber() {
        return (String) getProperty(serialNumber).getValue();
    }

    public void setSerialNumber(String aBSerialNumber) {
        getProperty(serialNumber).setValue(aBSerialNumber);
    }

    public Integer getAction() {
        return (Integer) getProperty(action).getValue();
    }

    public void setAction(Integer aBAction) {
        getProperty(action).setValue(aBAction);
    }

    public String getName() {
        return (String) getProperty(name).getValue();
    }

    public void setName(String aBName) {
        getProperty(name).setValue(aBName);
    }

    public Integer getPresenceStatus() {
        return (Integer) getProperty(presenceStatus).getValue();
    }

    public void setPresenceStatus(Integer aBPresenceStatus) {
        getProperty(presenceStatus).setValue(aBPresenceStatus);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(type));
        prepareRead(getProperty(attribute));
        prepareRead(getProperty(operationStatus));
        prepareRead(getProperty(adminStatus));
        prepareRead(getProperty(hardwareVersion));
        prepareRead(getProperty(firmwareVersion));
        prepareRead(getProperty(softwareVersion));
        prepareRead(getProperty(upTime));
        prepareRead(getProperty(alarmStatus));
        prepareRead(getProperty(serialNumber));
        prepareRead(getProperty(action));
        prepareRead(getProperty(name));
        prepareRead(getProperty(presenceStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(type));
        prepareRead(getProperty(attribute));
        prepareRead(getProperty(operationStatus));
        prepareRead(getProperty(adminStatus));
        prepareRead(getProperty(hardwareVersion));
        prepareRead(getProperty(firmwareVersion));
        prepareRead(getProperty(softwareVersion));
        prepareRead(getProperty(upTime));
        prepareRead(getProperty(alarmStatus));
        prepareRead(getProperty(serialNumber));
        prepareRead(getProperty(action));
        prepareRead(getProperty(name));
        prepareRead(getProperty(presenceStatus));

        return loadAll(new int[]{1, 1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(adminStatus));
        prepareSave(getProperty(action));

        return save();
    }

}
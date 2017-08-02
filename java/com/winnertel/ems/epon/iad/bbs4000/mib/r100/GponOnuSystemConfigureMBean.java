/**
 * Created by Zhou Chao, 2008/9/28
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuSystemConfigureMBean extends SnmpMibBean {

    public static final String onuCfgSlotNo = "onuCfgSlotNo";
    public static final String onuCfgPortNo = "onuCfgPortNo";
    public static final String onuCfgLogicalPortNo = "onuCfgLogicalPortNo";
    public static final String onuCfgSerialNumber = "onuCfgSerialNumber";
    public static final String onuCfgPassword = "onuCfgPassword";
    public static final String onuCfgPrimaryStatus = "onuCfgPrimaryStatus";
    public static final String onuCfgOnuHardwareType = "onuCfgOnuHardwareType";
    public static final String onuCfgOnuHardwareRevision = "onuCfgOnuHardwareRevision";
    public static final String onuCfgAdministrativeState = "onuCfgAdministrativeState";
    public static final String onuCfgOperationalState = "onuCfgOperationalState";
    public static final String onuCfgSysUpTime = "onuCfgSysUpTime";
    public static final String onuCfgOnuEqualizationDelay = "onuCfgOnuEqualizationDelay";
    public static final String onuCfgVendorID = "onuCfgVendorID";
    public static final String onuCfgVersion = "onuCfgVersion";
    public static final String onuCfgEquipmentID = "onuCfgEquipmentID";
    public static final String onuCfgOmccVersion = "onuCfgOmccVersion";

    public static final String onuCfgOnuIPAddress = "onuCfgOnuIPAddress"; //added for OpenWebMgmtAction

    public static final String onuCfgOnuReset = "onuCfgOnuReset";

    public GponOnuSystemConfigureMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCfgSlotNo, new SnmpMibBeanProperty(onuCfgSlotNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(onuCfgPortNo, new SnmpMibBeanProperty(onuCfgPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(onuCfgLogicalPortNo, new SnmpMibBeanProperty(onuCfgLogicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(onuCfgSerialNumber, new SnmpMibBeanProperty(onuCfgSerialNumber, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.16", ISnmpConstant.STRING));
        initProperty(onuCfgPassword, new SnmpMibBeanProperty(onuCfgPassword, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.4", ISnmpConstant.STRING));
        initProperty(onuCfgPrimaryStatus, new SnmpMibBeanProperty(onuCfgPrimaryStatus, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.5", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuHardwareType, new SnmpMibBeanProperty(onuCfgOnuHardwareType, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.23", ISnmpConstant.GAUGE));
        initProperty(onuCfgOnuHardwareRevision, new SnmpMibBeanProperty(onuCfgOnuHardwareRevision, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.24", ISnmpConstant.GAUGE));
        initProperty(onuCfgAdministrativeState, new SnmpMibBeanProperty(onuCfgAdministrativeState, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.19", ISnmpConstant.INTEGER));
        initProperty(onuCfgOperationalState, new SnmpMibBeanProperty(onuCfgOperationalState, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.20", ISnmpConstant.INTEGER));
        initProperty(onuCfgSysUpTime, new SnmpMibBeanProperty(onuCfgSysUpTime, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.33", ISnmpConstant.GAUGE));
        initProperty(onuCfgOnuEqualizationDelay, new SnmpMibBeanProperty(onuCfgOnuEqualizationDelay, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.11", ISnmpConstant.GAUGE));
        initProperty(onuCfgVendorID, new SnmpMibBeanProperty(onuCfgVendorID, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.14", ISnmpConstant.STRING));
        initProperty(onuCfgVersion, new SnmpMibBeanProperty(onuCfgVersion, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.15", ISnmpConstant.STRING));
        initProperty(onuCfgEquipmentID, new SnmpMibBeanProperty(onuCfgEquipmentID, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.21", ISnmpConstant.STRING));
        initProperty(onuCfgOmccVersion, new SnmpMibBeanProperty(onuCfgOmccVersion, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.22", ISnmpConstant.INTEGER));

        initProperty(onuCfgOnuIPAddress, new SnmpMibBeanProperty(onuCfgOnuIPAddress, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.44", ISnmpConstant.IP_ADDRESS));

        initProperty(onuCfgOnuReset, new SnmpMibBeanProperty(onuCfgOnuReset, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.47", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.57", ISnmpConstant.INTEGER));
    }

    public Integer getOnuCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuCfgSlotNo(Integer aOnuCfgSlotNo) {
        setIndex(0, aOnuCfgSlotNo);
    }

    public Integer getOnuCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuCfgPortNo(Integer aOnuCfgPortNo) {
        setIndex(1, aOnuCfgPortNo);
    }

    public Integer getOnuCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuCfgLogicalPortNo(Integer aOnuCfgLogicalPortNo) {
        setIndex(2, aOnuCfgLogicalPortNo);
    }

    public String getOnuCfgPassword() {
        return (String) getProperty(onuCfgPassword).getValue();
    }

    public void setOnuCfgPassword(String aOnuCfgPassword) {
        getProperty(onuCfgPassword).setValue(aOnuCfgPassword);
    }

    public Integer getOnuCfgPrimaryStatus() {
        return (Integer) getProperty(onuCfgPrimaryStatus).getValue();
    }

    public void setOnuCfgPrimaryStatus(Integer aOnuCfgPrimaryStatus) {
        getProperty(onuCfgPrimaryStatus).setValue(aOnuCfgPrimaryStatus);
    }

    public Long getOnuCfgOnuEqualizationDelay() {
        return (Long) getProperty(onuCfgOnuEqualizationDelay).getValue();
    }

    public void setOnuCfgOnuEqualizationDelay(Long aOnuCfgOnuEqualizationDelay) {
        getProperty(onuCfgOnuEqualizationDelay).setValue(aOnuCfgOnuEqualizationDelay);
    }

    public String getOnuCfgVendorID() {
        return (String) getProperty(onuCfgVendorID).getValue();
    }

    public void setOnuCfgVendorID(String aOnuCfgVendorID) {
        getProperty(onuCfgVendorID).setValue(aOnuCfgVendorID);
    }

    public String getOnuCfgVersion() {
        return (String) getProperty(onuCfgVersion).getValue();
    }

    public void setOnuCfgVersion(String aOnuCfgVersion) {
        getProperty(onuCfgVersion).setValue(aOnuCfgVersion);
    }

    public String getOnuCfgSerialNumber() {
        return (String) getProperty(onuCfgSerialNumber).getValue();
    }

    public void setOnuCfgSerialNumber(String aOnuCfgSerialNumber) {
        getProperty(onuCfgSerialNumber).setValue(aOnuCfgSerialNumber);
    }

    public Integer getOnuCfgAdministrativeState() {
        return (Integer) getProperty(onuCfgAdministrativeState).getValue();
    }

    public void setOnuCfgAdministrativeState(Integer aOnuCfgAdministrativeState) {
        getProperty(onuCfgAdministrativeState).setValue(aOnuCfgAdministrativeState);
    }

    public Integer getOnuCfgOperationalState() {
        return (Integer) getProperty(onuCfgOperationalState).getValue();
    }

    public void setOnuCfgOperationalState(Integer aOnuCfgOperationalState) {
        getProperty(onuCfgOperationalState).setValue(aOnuCfgOperationalState);
    }

    public String getOnuCfgEquipmentID() {
        return (String) getProperty(onuCfgEquipmentID).getValue();
    }

    public void setOnuCfgEquipmentID(String aOnuCfgEquipmentID) {
        getProperty(onuCfgEquipmentID).setValue(aOnuCfgEquipmentID);
    }

    public Integer getOnuCfgOmccVersion() {
        return (Integer) getProperty(onuCfgOmccVersion).getValue();
    }

    public void setOnuCfgOmccVersion(Integer aOnuCfgOmccVersion) {
        getProperty(onuCfgOmccVersion).setValue(aOnuCfgOmccVersion);
    }

    public Long getOnuCfgOnuHardwareType() {
        return (Long) getProperty(onuCfgOnuHardwareType).getValue();
    }

    public void setOnuCfgOnuHardwareType(Long aOnuCfgOnuHardwareType) {
        getProperty(onuCfgOnuHardwareType).setValue(aOnuCfgOnuHardwareType);
    }

    public Long getOnuCfgOnuHardwareRevision() {
        return (Long) getProperty(onuCfgOnuHardwareRevision).getValue();
    }

    public void setOnuCfgOnuHardwareRevision(Long aOnuCfgOnuHardwareRevision) {
        getProperty(onuCfgOnuHardwareRevision).setValue(aOnuCfgOnuHardwareRevision);
    }

    public Long getOnuCfgSysUpTime() {
        return (Long) getProperty(onuCfgSysUpTime).getValue();
    }

    public void setOnuCfgSysUpTime(Long aOnuCfgSysUpTime) {
        getProperty(onuCfgSysUpTime).setValue(aOnuCfgSysUpTime);
    }

    public String getOnuCfgOnuIPAddress() {
        return (String) getProperty(onuCfgOnuIPAddress).getValue();
    }

    public void setOnuCfgOnuIPAddress(String aOnuCfgOnuIPAddress) {
        getProperty(onuCfgOnuIPAddress).setValue(aOnuCfgOnuIPAddress);
    }

    public Integer getOnuCfgOnuReset() {
        return (Integer) getProperty(onuCfgOnuReset).getValue();
    }

    public void setOnuCfgOnuReset(Integer aOnuCfgOnuReset) {
        getProperty(onuCfgOnuReset).setValue(aOnuCfgOnuReset);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuCfgSerialNumber));
        prepareRead(getProperty(onuCfgPassword));
        prepareRead(getProperty(onuCfgPrimaryStatus));
        prepareRead(getProperty(onuCfgOnuHardwareType));
        prepareRead(getProperty(onuCfgOnuHardwareRevision));
        prepareRead(getProperty(onuCfgAdministrativeState));
        prepareRead(getProperty(onuCfgOperationalState));
        prepareRead(getProperty(onuCfgSysUpTime));
        prepareRead(getProperty(onuCfgOnuEqualizationDelay));
        prepareRead(getProperty(onuCfgVendorID));
        prepareRead(getProperty(onuCfgVersion));
        prepareRead(getProperty(onuCfgEquipmentID));
        prepareRead(getProperty(onuCfgOmccVersion));
        prepareRead(getProperty(onuCfgOnuIPAddress));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuCfgSerialNumber));
        prepareRead(getProperty(onuCfgPassword));
        prepareRead(getProperty(onuCfgPrimaryStatus));
        prepareRead(getProperty(onuCfgOnuHardwareType));
        prepareRead(getProperty(onuCfgOnuHardwareRevision));
        prepareRead(getProperty(onuCfgAdministrativeState));
        prepareRead(getProperty(onuCfgOperationalState));
        prepareRead(getProperty(onuCfgSysUpTime));
        prepareRead(getProperty(onuCfgOnuEqualizationDelay));
        prepareRead(getProperty(onuCfgVendorID));
        prepareRead(getProperty(onuCfgVersion));
        prepareRead(getProperty(onuCfgEquipmentID));
        prepareRead(getProperty(onuCfgOmccVersion));
        prepareRead(getProperty(onuCfgOnuIPAddress));

        setRowsPerFetch(50);
        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuCfgSerialNumber));
        prepareSave(getProperty(onuCfgPassword));
        prepareSave(getProperty(onuCfgAdministrativeState));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuCfgSerialNumber));
        prepareSave(getProperty(onuCfgPassword));
        //prepareSave(getProperty(onuCfgAdministrativeState));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean resetONU() throws MibBeanException {
        setOnuCfgOnuReset(1);
        prepareSave(getProperty(onuCfgOnuReset));

        return save();
    }

}
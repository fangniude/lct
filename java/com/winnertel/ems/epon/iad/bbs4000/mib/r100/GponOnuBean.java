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

public class GponOnuBean extends SnmpMibBean {

    public static final String onuCfgSlotNo = "onuCfgSlotNo";
    public static final String onuCfgPortNo = "onuCfgPortNo";
    public static final String onuCfgLogicalPortNo = "onuCfgLogicalPortNo";
    public static final String onuCfgPrimaryStatus = "onuCfgPrimaryStatus";
    public static final String onuCfgVendorID = "onuCfgVendorID";
    public static final String onuCfgVersion = "onuCfgVersion";
    public static final String onuCfgSerialNumber = "onuCfgSerialNumber";
    public static final String onuCfgAdministrativeState = "onuCfgAdministrativeState";
    public static final String onuCfgOperationalState = "onuCfgOperationalState";
    public static final String onuCfgEquipmentID = "onuCfgEquipmentID";
    public static final String onuCfgOmccVersion = "onuCfgOmccVersion";
    public static final String onuCfgOnuHardwareType = "onuCfgOnuHardwareType";
    public static final String onuCfgOnuHardwareRevision = "onuCfgOnuHardwareRevision";
    public static final String onuCfgOnuImageInstance0Version = "onuCfgOnuImageInstance0Version";
    public static final String onuCfgOnuImageInstance0Valid = "onuCfgOnuImageInstance0Valid";
    public static final String onuCfgOnuImageInstance0Activate = "onuCfgOnuImageInstance0Activate";
    public static final String onuCfgOnuImageInstance0Commit = "onuCfgOnuImageInstance0Commit";
    public static final String onuCfgOnuImageInstance1Version = "onuCfgOnuImageInstance1Version";
    public static final String onuCfgOnuImageInstance1Valid = "onuCfgOnuImageInstance1Valid";
    public static final String onuCfgOnuImageInstance1Activate = "onuCfgOnuImageInstance1Activate";
    public static final String onuCfgOnuImageInstance1Commit = "onuCfgOnuImageInstance1Commit";
    public static final String onuCfgOnuMacAddress = "onuCfgOnuMacAddress";

    public GponOnuBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCfgSlotNo, new SnmpMibBeanProperty(onuCfgSlotNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(onuCfgPortNo, new SnmpMibBeanProperty(onuCfgPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(onuCfgLogicalPortNo, new SnmpMibBeanProperty(onuCfgLogicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(onuCfgPrimaryStatus, new SnmpMibBeanProperty(onuCfgPrimaryStatus, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.5", ISnmpConstant.INTEGER));
        initProperty(onuCfgVendorID, new SnmpMibBeanProperty(onuCfgVendorID, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.14", ISnmpConstant.STRING));
        initProperty(onuCfgVersion, new SnmpMibBeanProperty(onuCfgVersion, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.15", ISnmpConstant.STRING));
        initProperty(onuCfgSerialNumber, new SnmpMibBeanProperty(onuCfgSerialNumber, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.16", ISnmpConstant.STRING));
        initProperty(onuCfgAdministrativeState, new SnmpMibBeanProperty(onuCfgAdministrativeState, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.19", ISnmpConstant.INTEGER));
        initProperty(onuCfgOperationalState, new SnmpMibBeanProperty(onuCfgOperationalState, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.20", ISnmpConstant.INTEGER));
        initProperty(onuCfgEquipmentID, new SnmpMibBeanProperty(onuCfgEquipmentID, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.21", ISnmpConstant.STRING));
        initProperty(onuCfgOmccVersion, new SnmpMibBeanProperty(onuCfgOmccVersion, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.22", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuHardwareType, new SnmpMibBeanProperty(onuCfgOnuHardwareType, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.23", ISnmpConstant.GAUGE));
        initProperty(onuCfgOnuHardwareRevision, new SnmpMibBeanProperty(onuCfgOnuHardwareRevision, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.24", ISnmpConstant.GAUGE));
        initProperty(onuCfgOnuImageInstance0Version, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Version, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.34", ISnmpConstant.STRING));
        initProperty(onuCfgOnuImageInstance0Valid, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Valid, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.35", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance0Activate, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Activate, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.36", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance0Commit, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Commit, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.37", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Version, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Version, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.38", ISnmpConstant.STRING));
        initProperty(onuCfgOnuImageInstance1Valid, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Valid, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.39", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Activate, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Activate, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.40", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Commit, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Commit, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.41", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuMacAddress, new SnmpMibBeanProperty(onuCfgOnuMacAddress, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.42", ISnmpConstant.STRING));
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

    public Integer getOnuCfgPrimaryStatus() {
        return (Integer) getProperty(onuCfgPrimaryStatus).getValue();
    }

    public void setOnuCfgPrimaryStatus(Integer aOnuCfgPrimaryStatus) {
        getProperty(onuCfgPrimaryStatus).setValue(aOnuCfgPrimaryStatus);
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

    public String getOnuCfgOnuImageInstance0Version() {
        return (String) getProperty(onuCfgOnuImageInstance0Version).getValue();
    }

    public void setOnuCfgOnuImageInstance0Version(String aOnuCfgOnuImageInstance0Version) {
        getProperty(onuCfgOnuImageInstance0Version).setValue(aOnuCfgOnuImageInstance0Version);
    }

    public Integer getOnuCfgOnuImageInstance0Valid() {
        return (Integer) getProperty(onuCfgOnuImageInstance0Valid).getValue();
    }

    public void setOnuCfgOnuImageInstance0Valid(Integer aOnuCfgOnuImageInstance0Valid) {
        getProperty(onuCfgOnuImageInstance0Valid).setValue(aOnuCfgOnuImageInstance0Valid);
    }

    public Integer getOnuCfgOnuImageInstance0Activate() {
        return (Integer) getProperty(onuCfgOnuImageInstance0Activate).getValue();
    }

    public void setOnuCfgOnuImageInstance0Activate(Integer aOnuCfgOnuImageInstance0Activate) {
        getProperty(onuCfgOnuImageInstance0Activate).setValue(aOnuCfgOnuImageInstance0Activate);
    }

    public Integer getOnuCfgOnuImageInstance0Commit() {
        return (Integer) getProperty(onuCfgOnuImageInstance0Commit).getValue();
    }

    public void setOnuCfgOnuImageInstance0Commit(Integer aOnuCfgOnuImageInstance0Commit) {
        getProperty(onuCfgOnuImageInstance0Commit).setValue(aOnuCfgOnuImageInstance0Commit);
    }

    public String getOnuCfgOnuImageInstance1Version() {
        return (String) getProperty(onuCfgOnuImageInstance1Version).getValue();
    }

    public void setOnuCfgOnuImageInstance1Version(String aOnuCfgOnuImageInstance1Version) {
        getProperty(onuCfgOnuImageInstance1Version).setValue(aOnuCfgOnuImageInstance1Version);
    }

    public Integer getOnuCfgOnuImageInstance1Valid() {
        return (Integer) getProperty(onuCfgOnuImageInstance1Valid).getValue();
    }

    public void setOnuCfgOnuImageInstance1Valid(Integer aOnuCfgOnuImageInstance1Valid) {
        getProperty(onuCfgOnuImageInstance1Valid).setValue(aOnuCfgOnuImageInstance1Valid);
    }

    public Integer getOnuCfgOnuImageInstance1Activate() {
        return (Integer) getProperty(onuCfgOnuImageInstance1Activate).getValue();
    }

    public void setOnuCfgOnuImageInstance1Activate(Integer aOnuCfgOnuImageInstance1Activate) {
        getProperty(onuCfgOnuImageInstance1Activate).setValue(aOnuCfgOnuImageInstance1Activate);
    }

    public Integer getOnuCfgOnuImageInstance1Commit() {
        return (Integer) getProperty(onuCfgOnuImageInstance1Commit).getValue();
    }

    public void setOnuCfgOnuImageInstance1Commit(Integer aOnuCfgOnuImageInstance1Commit) {
        getProperty(onuCfgOnuImageInstance1Commit).setValue(aOnuCfgOnuImageInstance1Commit);
    }

    public String getOnuCfgOnuMacAddress() {
        return (String) getProperty(onuCfgOnuMacAddress).getValue();
    }

    public void setOnuCfgOnuMacAddress(String aOnuCfgOnuMacAddress) {
        getProperty(onuCfgOnuMacAddress).setValue(aOnuCfgOnuMacAddress);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuCfgPrimaryStatus));
        prepareRead(getProperty(onuCfgVendorID));
        prepareRead(getProperty(onuCfgVersion));
        prepareRead(getProperty(onuCfgSerialNumber));
        prepareRead(getProperty(onuCfgAdministrativeState));
        prepareRead(getProperty(onuCfgOperationalState));
        prepareRead(getProperty(onuCfgEquipmentID));
        prepareRead(getProperty(onuCfgOmccVersion));
        prepareRead(getProperty(onuCfgOnuHardwareType));
        prepareRead(getProperty(onuCfgOnuHardwareRevision));
        prepareRead(getProperty(onuCfgOnuImageInstance0Version));
        prepareRead(getProperty(onuCfgOnuImageInstance0Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance0Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance0Commit));
        prepareRead(getProperty(onuCfgOnuImageInstance1Version));
        prepareRead(getProperty(onuCfgOnuImageInstance1Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance1Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance1Commit));
        prepareRead(getProperty(onuCfgOnuMacAddress));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuCfgPrimaryStatus));
        prepareRead(getProperty(onuCfgVendorID));
        prepareRead(getProperty(onuCfgVersion));
        prepareRead(getProperty(onuCfgSerialNumber));
        prepareRead(getProperty(onuCfgAdministrativeState));
        prepareRead(getProperty(onuCfgOperationalState));
        prepareRead(getProperty(onuCfgEquipmentID));
        prepareRead(getProperty(onuCfgOmccVersion));
        prepareRead(getProperty(onuCfgOnuHardwareType));
        prepareRead(getProperty(onuCfgOnuHardwareRevision));
        prepareRead(getProperty(onuCfgOnuImageInstance0Version));
        prepareRead(getProperty(onuCfgOnuImageInstance0Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance0Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance0Commit));
        prepareRead(getProperty(onuCfgOnuImageInstance1Version));
        prepareRead(getProperty(onuCfgOnuImageInstance1Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance1Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance1Commit));
        prepareRead(getProperty(onuCfgOnuMacAddress));

        return loadAll(new int[]{1, 1, 1});
    }

    /*
    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuCfgAdministrativeState));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuCfgAdministrativeState));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }
    */

}
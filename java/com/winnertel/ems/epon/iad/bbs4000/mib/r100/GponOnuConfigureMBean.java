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

public class GponOnuConfigureMBean extends SnmpMibBean {

    public static final String onuCfgSlotNo = "onuCfgSlotNo";
    public static final String onuCfgPortNo = "onuCfgPortNo";
    public static final String onuCfgLogicalPortNo = "onuCfgLogicalPortNo";
    public static final String onuCfgPassword = "onuCfgPassword";
    public static final String onuCfgPrimaryStatus = "onuCfgPrimaryStatus";
    public static final String onuCfgUpstreamTrafficMappingType = "onuCfgUpstreamTrafficMappingType";
    public static final String onuCfgUpstreamTrafficMappingProfileIndex = "onuCfgUpstreamTrafficMappingProfileIndex";
    public static final String onuCfgTcontVirtualPortBindingType = "onuCfgTcontVirtualPortBindingType";
    public static final String onuCfgTcontVirtualPortBindingProfileIndex = "onuCfgTcontVirtualPortBindingProfileIndex";
    public static final String onuCfgServiceSubscription = "onuCfgServiceSubscription";
    public static final String onuCfgOnuEqualizationDelay = "onuCfgOnuEqualizationDelay";
    public static final String onuCfgBerIntervalConfiguration = "onuCfgBerIntervalConfiguration";
    public static final String onuCfgPowerLevel = "onuCfgPowerLevel";
    public static final String onuCfgVendorID = "onuCfgVendorID";
    public static final String onuCfgVersion = "onuCfgVersion";
    public static final String onuCfgSerialNumber = "onuCfgSerialNumber";
    public static final String onuCfgTrafficManagementOption = "onuCfgTrafficManagementOption";
    public static final String onuCfgBatteryBackup = "onuCfgBatteryBackup";
    public static final String onuCfgAdministrativeState = "onuCfgAdministrativeState";
    public static final String onuCfgOperationalState = "onuCfgOperationalState";
    public static final String onuCfgEquipmentID = "onuCfgEquipmentID";
    public static final String onuCfgOmccVersion = "onuCfgOmccVersion";
    public static final String onuCfgOnuHardwareType = "onuCfgOnuHardwareType";
    public static final String onuCfgOnuHardwareRevision = "onuCfgOnuHardwareRevision";
    public static final String onuCfgSecurityCapability = "onuCfgSecurityCapability";
    public static final String onuCfgSecurityMode = "onuCfgSecurityMode";
    public static final String onuCfgTotalPriorityQueueNumber = "onuCfgTotalPriorityQueueNumber";
    public static final String onuCfgTotalTrafficSchedulerNumber = "onuCfgTotalTrafficSchedulerNumber";
    public static final String onuCfgTotalGEMPortNumber = "onuCfgTotalGEMPortNumber";
    public static final String onuCfgTotalTCONTNumber = "onuCfgTotalTCONTNumber";
    public static final String onuCfgTotalEthernetUNINumber = "onuCfgTotalEthernetUNINumber";
    public static final String onuCfgTotalPOTSUNINumber = "onuCfgTotalPOTSUNINumber";
    public static final String onuCfgSysUpTime = "onuCfgSysUpTime";
    public static final String onuCfgOnuImageInstance0Version = "onuCfgOnuImageInstance0Version";
    public static final String onuCfgOnuImageInstance0Valid = "onuCfgOnuImageInstance0Valid";
    public static final String onuCfgOnuImageInstance0Activate = "onuCfgOnuImageInstance0Activate";
    public static final String onuCfgOnuImageInstance0Commit = "onuCfgOnuImageInstance0Commit";
    public static final String onuCfgOnuImageInstance1Version = "onuCfgOnuImageInstance1Version";
    public static final String onuCfgOnuImageInstance1Valid = "onuCfgOnuImageInstance1Valid";
    public static final String onuCfgOnuImageInstance1Activate = "onuCfgOnuImageInstance1Activate";
    public static final String onuCfgOnuImageInstance1Commit = "onuCfgOnuImageInstance1Commit";
    public static final String onuCfgOnuMacAddress = "onuCfgOnuMacAddress";
    public static final String onuCfgOnuDHCPMode = "onuCfgOnuDHCPMode";
    public static final String onuCfgOnuIPAddress = "onuCfgOnuIPAddress";
    public static final String onuCfgOnuIPMask = "onuCfgOnuIPMask";
    public static final String onuCfgOnuDefaultGateway = "onuCfgOnuDefaultGateway";
    public static final String onuCfgOnuReset = "onuCfgOnuReset";

    //public static final String onuCfgOnuMulticastFilterMode = "onuCfgOnuMulticastFilterMode";
    //public static final String onuCfgOnuMulticastGemPortNo = "onuCfgOnuMulticastGemPortNo";
    //public static final String onuCfgOnuStaticMulticastGroupsProfileIndex = "onuCfgOnuStaticMulticastGroupsProfileIndex";

    public static final String onuCfgMacLimit = "onuCfgMacLimit";
    public static final String onuCfgFecTxEnable = "onuCfgFecTxEnable";
    public static final String onuCfgOnuFastLeaveCapability = "onuCfgOnuFastLeaveCapability";
    public static final String onuCfgPiggybackDbaRep = "onuCfgPiggybackDbaRep";
    public static final String onuCfgWholeOnuDbaRep = "onuCfgWholeOnuDbaRep";

    public static final String onuCfgOnuVoIPBindingType = "onuCfgOnuVoIPBindingType";
    public static final String onuCfgOnuVoIPUserName = "onuCfgOnuVoIPUserName";
    public static final String onuCfgOnuVoIPPassword = "onuCfgOnuVoIPPassword";
    public static final String onuCfgOnuVoIPServiceProfileIndex = "onuCfgOnuVoIPServiceProfileIndex";

    public GponOnuConfigureMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCfgSlotNo, new SnmpMibBeanProperty(onuCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(onuCfgPortNo, new SnmpMibBeanProperty(onuCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(onuCfgLogicalPortNo, new SnmpMibBeanProperty(onuCfgLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(onuCfgPassword, new SnmpMibBeanProperty(onuCfgPassword, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.4", ISnmpConstant.STRING));
        initProperty(onuCfgPrimaryStatus, new SnmpMibBeanProperty(onuCfgPrimaryStatus, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.5", ISnmpConstant.INTEGER));
        initProperty(onuCfgUpstreamTrafficMappingType, new SnmpMibBeanProperty(onuCfgUpstreamTrafficMappingType, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.6", ISnmpConstant.INTEGER));
        initProperty(onuCfgUpstreamTrafficMappingProfileIndex, new SnmpMibBeanProperty(onuCfgUpstreamTrafficMappingProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.7", ISnmpConstant.GAUGE));
        initProperty(onuCfgTcontVirtualPortBindingType, new SnmpMibBeanProperty(onuCfgTcontVirtualPortBindingType, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.8", ISnmpConstant.INTEGER));
        initProperty(onuCfgTcontVirtualPortBindingProfileIndex, new SnmpMibBeanProperty(onuCfgTcontVirtualPortBindingProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.9", ISnmpConstant.GAUGE));
        initProperty(onuCfgServiceSubscription, new SnmpMibBeanProperty(onuCfgServiceSubscription, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.10", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuEqualizationDelay, new SnmpMibBeanProperty(onuCfgOnuEqualizationDelay, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.11", ISnmpConstant.INTEGER));
        initProperty(onuCfgBerIntervalConfiguration, new SnmpMibBeanProperty(onuCfgBerIntervalConfiguration, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.12", ISnmpConstant.GAUGE));
        initProperty(onuCfgPowerLevel, new SnmpMibBeanProperty(onuCfgPowerLevel, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.13", ISnmpConstant.INTEGER));
        initProperty(onuCfgVendorID, new SnmpMibBeanProperty(onuCfgVendorID, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.14", ISnmpConstant.STRING));
        initProperty(onuCfgVersion, new SnmpMibBeanProperty(onuCfgVersion, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.15", ISnmpConstant.STRING));
        initProperty(onuCfgSerialNumber, new SnmpMibBeanProperty(onuCfgSerialNumber, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.16", ISnmpConstant.STRING));
        initProperty(onuCfgTrafficManagementOption, new SnmpMibBeanProperty(onuCfgTrafficManagementOption, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.17", ISnmpConstant.INTEGER));
        initProperty(onuCfgBatteryBackup, new SnmpMibBeanProperty(onuCfgBatteryBackup, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.18", ISnmpConstant.INTEGER));
        initProperty(onuCfgAdministrativeState, new SnmpMibBeanProperty(onuCfgAdministrativeState, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.19", ISnmpConstant.INTEGER));
        initProperty(onuCfgOperationalState, new SnmpMibBeanProperty(onuCfgOperationalState, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.20", ISnmpConstant.INTEGER));
        initProperty(onuCfgEquipmentID, new SnmpMibBeanProperty(onuCfgEquipmentID, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.21", ISnmpConstant.STRING));
        initProperty(onuCfgOmccVersion, new SnmpMibBeanProperty(onuCfgOmccVersion, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.22", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuHardwareType, new SnmpMibBeanProperty(onuCfgOnuHardwareType, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.23", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuHardwareRevision, new SnmpMibBeanProperty(onuCfgOnuHardwareRevision, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.24", ISnmpConstant.INTEGER));
        initProperty(onuCfgSecurityCapability, new SnmpMibBeanProperty(onuCfgSecurityCapability, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.25", ISnmpConstant.GAUGE));
        initProperty(onuCfgSecurityMode, new SnmpMibBeanProperty(onuCfgSecurityMode, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.26", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalPriorityQueueNumber, new SnmpMibBeanProperty(onuCfgTotalPriorityQueueNumber, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.27", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalTrafficSchedulerNumber, new SnmpMibBeanProperty(onuCfgTotalTrafficSchedulerNumber, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.28", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalGEMPortNumber, new SnmpMibBeanProperty(onuCfgTotalGEMPortNumber, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.29", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalTCONTNumber, new SnmpMibBeanProperty(onuCfgTotalTCONTNumber, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.30", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalEthernetUNINumber, new SnmpMibBeanProperty(onuCfgTotalEthernetUNINumber, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.31", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalPOTSUNINumber, new SnmpMibBeanProperty(onuCfgTotalPOTSUNINumber, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.32", ISnmpConstant.GAUGE));
        initProperty(onuCfgSysUpTime, new SnmpMibBeanProperty(onuCfgSysUpTime, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.33", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance0Version, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Version, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.34", ISnmpConstant.GAUGE));
        initProperty(onuCfgOnuImageInstance0Valid, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Valid, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.35", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance0Activate, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Activate, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.36", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance0Commit, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Commit, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.37", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Version, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Version, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.38", ISnmpConstant.GAUGE));
        initProperty(onuCfgOnuImageInstance1Valid, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Valid, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.39", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Activate, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Activate, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.40", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Commit, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Commit, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.41", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuMacAddress, new SnmpMibBeanProperty(onuCfgOnuMacAddress, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.42", ISnmpConstant.STRING));
        initProperty(onuCfgOnuDHCPMode, new SnmpMibBeanProperty(onuCfgOnuDHCPMode, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.43", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuIPAddress, new SnmpMibBeanProperty(onuCfgOnuIPAddress, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.44", ISnmpConstant.IP_ADDRESS));
        initProperty(onuCfgOnuIPMask, new SnmpMibBeanProperty(onuCfgOnuIPMask, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.45", ISnmpConstant.IP_ADDRESS));
        initProperty(onuCfgOnuDefaultGateway, new SnmpMibBeanProperty(onuCfgOnuDefaultGateway, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.46", ISnmpConstant.IP_ADDRESS));
        initProperty(onuCfgOnuReset, new SnmpMibBeanProperty(onuCfgOnuReset, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.47", ISnmpConstant.INTEGER));

        //initProperty(onuCfgOnuMulticastFilterMode, new SnmpMibBeanProperty(onuCfgOnuMulticastFilterMode, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.48", ISnmpConstant.INTEGER));
        //initProperty(onuCfgOnuMulticastGemPortNo, new SnmpMibBeanProperty(onuCfgOnuMulticastGemPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.49", ISnmpConstant.INTEGER));
        //initProperty(onuCfgOnuStaticMulticastGroupsProfileIndex, new SnmpMibBeanProperty(onuCfgOnuStaticMulticastGroupsProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.50", ISnmpConstant.GAUGE));

        initProperty(onuCfgMacLimit, new SnmpMibBeanProperty(onuCfgMacLimit, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.48", ISnmpConstant.INTEGER));
        initProperty(onuCfgFecTxEnable, new SnmpMibBeanProperty(onuCfgFecTxEnable, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.49", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuFastLeaveCapability, new SnmpMibBeanProperty(onuCfgOnuFastLeaveCapability, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.50", ISnmpConstant.INTEGER));
        initProperty(onuCfgPiggybackDbaRep, new SnmpMibBeanProperty(onuCfgPiggybackDbaRep, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.51", ISnmpConstant.INTEGER));
        initProperty(onuCfgWholeOnuDbaRep, new SnmpMibBeanProperty(onuCfgWholeOnuDbaRep, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.52", ISnmpConstant.INTEGER));

        initProperty(onuCfgOnuVoIPBindingType, new SnmpMibBeanProperty(onuCfgOnuVoIPBindingType, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.53", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuVoIPUserName, new SnmpMibBeanProperty(onuCfgOnuVoIPUserName, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.54", ISnmpConstant.STRING));
        initProperty(onuCfgOnuVoIPPassword, new SnmpMibBeanProperty(onuCfgOnuVoIPPassword, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.55", ISnmpConstant.STRING));
        initProperty(onuCfgOnuVoIPServiceProfileIndex, new SnmpMibBeanProperty(onuCfgOnuVoIPServiceProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.56", ISnmpConstant.GAUGE));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.57", ISnmpConstant.INTEGER));
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

    public Integer getOnuCfgUpstreamTrafficMappingType() {
        return (Integer) getProperty(onuCfgUpstreamTrafficMappingType).getValue();
    }

    public void setOnuCfgUpstreamTrafficMappingType(Integer aOnuCfgUpstreamTrafficMappingType) {
        getProperty(onuCfgUpstreamTrafficMappingType).setValue(aOnuCfgUpstreamTrafficMappingType);
    }

    public Long getOnuCfgUpstreamTrafficMappingProfileIndex() {
        return (Long) getProperty(onuCfgUpstreamTrafficMappingProfileIndex).getValue();
    }

    public void setOnuCfgUpstreamTrafficMappingProfileIndex(Long aOnuCfgUpstreamTrafficMappingProfileIndex) {
        getProperty(onuCfgUpstreamTrafficMappingProfileIndex).setValue(aOnuCfgUpstreamTrafficMappingProfileIndex);
    }

    public Integer getOnuCfgTcontVirtualPortBindingType() {
        return (Integer) getProperty(onuCfgTcontVirtualPortBindingType).getValue();
    }

    public void setOnuCfgTcontVirtualPortBindingType(Integer aOnuCfgTcontVirtualPortBindingType) {
        getProperty(onuCfgTcontVirtualPortBindingType).setValue(aOnuCfgTcontVirtualPortBindingType);
    }

    public Long getOnuCfgTcontVirtualPortBindingProfileIndex() {
        return (Long) getProperty(onuCfgTcontVirtualPortBindingProfileIndex).getValue();
    }

    public void setOnuCfgTcontVirtualPortBindingProfileIndex(Long aOnuCfgTcontVirtualPortBindingProfileIndex) {
        getProperty(onuCfgTcontVirtualPortBindingProfileIndex).setValue(aOnuCfgTcontVirtualPortBindingProfileIndex);
    }

    public Integer getOnuCfgServiceSubscription() {
        return (Integer) getProperty(onuCfgServiceSubscription).getValue();
    }

    public void setOnuCfgServiceSubscription(Integer aOnuCfgServiceSubscription) {
        getProperty(onuCfgServiceSubscription).setValue(aOnuCfgServiceSubscription);
    }

    public Long getOnuCfgOnuEqualizationDelay() {
        return (Long) getProperty(onuCfgOnuEqualizationDelay).getValue();
    }

    public void setOnuCfgOnuEqualizationDelay(Long aOnuCfgOnuEqualizationDelay) {
        getProperty(onuCfgOnuEqualizationDelay).setValue(aOnuCfgOnuEqualizationDelay);
    }

    public Long getOnuCfgBerIntervalConfiguration() {
        return (Long) getProperty(onuCfgBerIntervalConfiguration).getValue();
    }

    public void setOnuCfgBerIntervalConfiguration(Long aOnuCfgBerIntervalConfiguration) {
        getProperty(onuCfgBerIntervalConfiguration).setValue(aOnuCfgBerIntervalConfiguration);
    }

    public Integer getOnuCfgPowerLevel() {
        return (Integer) getProperty(onuCfgPowerLevel).getValue();
    }

    public void setOnuCfgPowerLevel(Integer aOnuCfgPowerLevel) {
        getProperty(onuCfgPowerLevel).setValue(aOnuCfgPowerLevel);
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

    public Integer getOnuCfgTrafficManagementOption() {
        return (Integer) getProperty(onuCfgTrafficManagementOption).getValue();
    }

    public void setOnuCfgTrafficManagementOption(Integer aOnuCfgTrafficManagementOption) {
        getProperty(onuCfgTrafficManagementOption).setValue(aOnuCfgTrafficManagementOption);
    }

    public Integer getOnuCfgBatteryBackup() {
        return (Integer) getProperty(onuCfgBatteryBackup).getValue();
    }

    public void setOnuCfgBatteryBackup(Integer aOnuCfgBatteryBackup) {
        getProperty(onuCfgBatteryBackup).setValue(aOnuCfgBatteryBackup);
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

    public Long getOnuCfgSecurityCapability() {
        return (Long) getProperty(onuCfgSecurityCapability).getValue();
    }

    public void setOnuCfgSecurityCapability(Long aOnuCfgSecurityCapability) {
        getProperty(onuCfgSecurityCapability).setValue(aOnuCfgSecurityCapability);
    }

    public Long getOnuCfgSecurityMode() {
        return (Long) getProperty(onuCfgSecurityMode).getValue();
    }

    public void setOnuCfgSecurityMode(Long aOnuCfgSecurityMode) {
        getProperty(onuCfgSecurityMode).setValue(aOnuCfgSecurityMode);
    }

    public Long getOnuCfgTotalPriorityQueueNumber() {
        return (Long) getProperty(onuCfgTotalPriorityQueueNumber).getValue();
    }

    public void setOnuCfgTotalPriorityQueueNumber(Long aOnuCfgTotalPriorityQueueNumber) {
        getProperty(onuCfgTotalPriorityQueueNumber).setValue(aOnuCfgTotalPriorityQueueNumber);
    }

    public Long getOnuCfgTotalTrafficSchedulerNumber() {
        return (Long) getProperty(onuCfgTotalTrafficSchedulerNumber).getValue();
    }

    public void setOnuCfgTotalTrafficSchedulerNumber(Long aOnuCfgTotalTrafficSchedulerNumber) {
        getProperty(onuCfgTotalTrafficSchedulerNumber).setValue(aOnuCfgTotalTrafficSchedulerNumber);
    }

    public Long getOnuCfgTotalGEMPortNumber() {
        return (Long) getProperty(onuCfgTotalGEMPortNumber).getValue();
    }

    public void setOnuCfgTotalGEMPortNumber(Long aOnuCfgTotalGEMPortNumber) {
        getProperty(onuCfgTotalGEMPortNumber).setValue(aOnuCfgTotalGEMPortNumber);
    }

    public Long getOnuCfgTotalTCONTNumber() {
        return (Long) getProperty(onuCfgTotalTCONTNumber).getValue();
    }

    public void setOnuCfgTotalTCONTNumber(Long aOnuCfgTotalTCONTNumber) {
        getProperty(onuCfgTotalTCONTNumber).setValue(aOnuCfgTotalTCONTNumber);
    }

    public Long getOnuCfgTotalEthernetUNINumber() {
        return (Long) getProperty(onuCfgTotalEthernetUNINumber).getValue();
    }

    public void setOnuCfgTotalEthernetUNINumber(Long aOnuCfgTotalEthernetUNINumber) {
        getProperty(onuCfgTotalEthernetUNINumber).setValue(aOnuCfgTotalEthernetUNINumber);
    }

    public Long getOnuCfgTotalPOTSUNINumber() {
        return (Long) getProperty(onuCfgTotalPOTSUNINumber).getValue();
    }

    public void setOnuCfgTotalPOTSUNINumber(Long aOnuCfgTotalPOTSUNINumber) {
        getProperty(onuCfgTotalPOTSUNINumber).setValue(aOnuCfgTotalPOTSUNINumber);
    }

    public Long getOnuCfgSysUpTime() {
        return (Long) getProperty(onuCfgSysUpTime).getValue();
    }

    public void setOnuCfgSysUpTime(Long aOnuCfgSysUpTime) {
        getProperty(onuCfgSysUpTime).setValue(aOnuCfgSysUpTime);
    }

    public Long getOnuCfgOnuImageInstance0Version() {
        return (Long) getProperty(onuCfgOnuImageInstance0Version).getValue();
    }

    public void setOnuCfgOnuImageInstance0Version(Long aOnuCfgOnuImageInstance0Version) {
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

    public Long getOnuCfgOnuImageInstance1Version() {
        return (Long) getProperty(onuCfgOnuImageInstance1Version).getValue();
    }

    public void setOnuCfgOnuImageInstance1Version(Long aOnuCfgOnuImageInstance1Version) {
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

    public Integer getOnuCfgOnuDHCPMode() {
        return (Integer) getProperty(onuCfgOnuDHCPMode).getValue();
    }

    public void setOnuCfgOnuDHCPMode(Integer aOnuCfgOnuDHCPMode) {
        getProperty(onuCfgOnuDHCPMode).setValue(aOnuCfgOnuDHCPMode);
    }

    public String getOnuCfgOnuIPAddress() {
        return (String) getProperty(onuCfgOnuIPAddress).getValue();
    }

    public void setOnuCfgOnuIPAddress(String aOnuCfgOnuIPAddress) {
        getProperty(onuCfgOnuIPAddress).setValue(aOnuCfgOnuIPAddress);
    }

    public String getOnuCfgOnuIPMask() {
        return (String) getProperty(onuCfgOnuIPMask).getValue();
    }

    public void setOnuCfgOnuIPMask(String aOnuCfgOnuIPMask) {
        getProperty(onuCfgOnuIPMask).setValue(aOnuCfgOnuIPMask);
    }

    public String getOnuCfgOnuDefaultGateway() {
        return (String) getProperty(onuCfgOnuDefaultGateway).getValue();
    }

    public void setOnuCfgOnuDefaultGateway(String aOnuCfgOnuDefaultGateway) {
        getProperty(onuCfgOnuDefaultGateway).setValue(aOnuCfgOnuDefaultGateway);
    }

    public Integer getOnuCfgOnuReset() {
        return (Integer) getProperty(onuCfgOnuReset).getValue();
    }

    public void setOnuCfgOnuReset(Integer aOnuCfgOnuReset) {
        getProperty(onuCfgOnuReset).setValue(aOnuCfgOnuReset);
    }

    /*
    public Integer getOnuCfgOnuMulticastFilterMode() {
        return (Integer) getProperty(onuCfgOnuMulticastFilterMode).getValue();
    }

    public void setOnuCfgOnuMulticastFilterMode(Integer aOnuCfgOnuMulticastFilterMode) {
        getProperty(onuCfgOnuMulticastFilterMode).setValue(aOnuCfgOnuMulticastFilterMode);
    }

    public Integer getOnuCfgOnuMulticastGemPortNo() {
        return (Integer) getProperty(onuCfgOnuMulticastGemPortNo).getValue();
    }

    public void setOnuCfgOnuMulticastGemPortNo(Integer aOnuCfgOnuMulticastGemPortNo) {
        getProperty(onuCfgOnuMulticastGemPortNo).setValue(aOnuCfgOnuMulticastGemPortNo);
    }

    public Long getOnuCfgOnuStaticMulticastGroupsProfileIndex() {
        return (Long) getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex).getValue();
    }

    public void setOnuCfgOnuStaticMulticastGroupsProfileIndex(Long aOnuCfgOnuStaticMulticastGroupsProfileIndex) {
        getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex).setValue(aOnuCfgOnuStaticMulticastGroupsProfileIndex);
    }
    */

    public Integer getOnuCfgMacLimit() {
        return (Integer) getProperty(onuCfgMacLimit).getValue();
    }

    public void setOnuCfgMacLimit(Integer aOnuCfgMacLimit) {
        getProperty(onuCfgMacLimit).setValue(aOnuCfgMacLimit);
    }

    public Integer getOnuCfgFecTxEnable() {
        return (Integer) getProperty(onuCfgFecTxEnable).getValue();
    }

    public void setOnuCfgFecTxEnable(Integer aOnuCfgFecTxEnable) {
        getProperty(onuCfgFecTxEnable).setValue(aOnuCfgFecTxEnable);
    }

    public Integer getOnuCfgOnuFastLeaveCapability() {
        return (Integer) getProperty(onuCfgOnuFastLeaveCapability).getValue();
    }

    public void setOnuCfgOnuFastLeaveCapability(Integer aOnuCfgOnuFastLeaveCapability) {
        getProperty(onuCfgOnuFastLeaveCapability).setValue(aOnuCfgOnuFastLeaveCapability);
    }

    public Integer getOnuCfgPiggybackDbaRep() {
        return (Integer) getProperty(onuCfgPiggybackDbaRep).getValue();
    }

    public void setOnuCfgPiggybackDbaRep(Integer aOnuCfgPiggybackDbaRep) {
        getProperty(onuCfgPiggybackDbaRep).setValue(aOnuCfgPiggybackDbaRep);
    }

    public Integer getOnuCfgWholeOnuDbaRep() {
        return (Integer) getProperty(onuCfgWholeOnuDbaRep).getValue();
    }

    public void setOnuCfgWholeOnuDbaRep(Integer aOnuCfgWholeOnuDbaRep) {
        getProperty(onuCfgWholeOnuDbaRep).setValue(aOnuCfgWholeOnuDbaRep);
    }

    public Integer getOnuCfgOnuVoIPBindingType() {
        return (Integer) getProperty(onuCfgOnuVoIPBindingType).getValue();
    }

    public void setOnuCfgOnuVoIPBindingType(Integer aOnuCfgOnuVoIPBindingType) {
        getProperty(onuCfgOnuVoIPBindingType).setValue(aOnuCfgOnuVoIPBindingType);
    }

    public String getOnuCfgOnuVoIPUserName() {
        return (String) getProperty(onuCfgOnuVoIPUserName).getValue();
    }

    public void setOnuCfgOnuVoIPUserName(String aOnuCfgOnuVoIPUserName) {
        getProperty(onuCfgOnuVoIPUserName).setValue(aOnuCfgOnuVoIPUserName);
    }

    public String getOnuCfgOnuVoIPPassword() {
        return (String) getProperty(onuCfgOnuVoIPPassword).getValue();
    }

    public void setOnuCfgOnuVoIPPassword(String aOnuCfgOnuVoIPPassword) {
        getProperty(onuCfgOnuVoIPPassword).setValue(aOnuCfgOnuVoIPPassword);
    }

    public Long getOnuCfgOnuVoIPServiceProfileIndex() {
        return (Long) getProperty(onuCfgOnuVoIPServiceProfileIndex).getValue();
    }

    public void setOnuCfgOnuVoIPServiceProfileIndex(Long aOnuCfgOnuVoIPServiceProfileIndex) {
        getProperty(onuCfgOnuVoIPServiceProfileIndex).setValue(aOnuCfgOnuVoIPServiceProfileIndex);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuCfgPassword));
        prepareRead(getProperty(onuCfgPrimaryStatus));
        prepareRead(getProperty(onuCfgUpstreamTrafficMappingType));
        prepareRead(getProperty(onuCfgUpstreamTrafficMappingProfileIndex));
        prepareRead(getProperty(onuCfgTcontVirtualPortBindingType));
        prepareRead(getProperty(onuCfgTcontVirtualPortBindingProfileIndex));
        prepareRead(getProperty(onuCfgServiceSubscription));
        prepareRead(getProperty(onuCfgOnuEqualizationDelay));
        prepareRead(getProperty(onuCfgBerIntervalConfiguration));
        prepareRead(getProperty(onuCfgPowerLevel));
        prepareRead(getProperty(onuCfgVendorID));
        prepareRead(getProperty(onuCfgVersion));
        prepareRead(getProperty(onuCfgSerialNumber));
        prepareRead(getProperty(onuCfgTrafficManagementOption));
        prepareRead(getProperty(onuCfgBatteryBackup));
        prepareRead(getProperty(onuCfgAdministrativeState));
        prepareRead(getProperty(onuCfgOperationalState));
        prepareRead(getProperty(onuCfgEquipmentID));
        prepareRead(getProperty(onuCfgOmccVersion));
        prepareRead(getProperty(onuCfgOnuHardwareType));
        prepareRead(getProperty(onuCfgOnuHardwareRevision));
        prepareRead(getProperty(onuCfgSecurityCapability));
        prepareRead(getProperty(onuCfgSecurityMode));
        prepareRead(getProperty(onuCfgTotalPriorityQueueNumber));
        prepareRead(getProperty(onuCfgTotalTrafficSchedulerNumber));
        prepareRead(getProperty(onuCfgTotalGEMPortNumber));
        prepareRead(getProperty(onuCfgTotalTCONTNumber));
        prepareRead(getProperty(onuCfgTotalEthernetUNINumber));
        prepareRead(getProperty(onuCfgTotalPOTSUNINumber));
        prepareRead(getProperty(onuCfgSysUpTime));
        prepareRead(getProperty(onuCfgOnuImageInstance0Version));
        prepareRead(getProperty(onuCfgOnuImageInstance0Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance0Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance0Commit));
        prepareRead(getProperty(onuCfgOnuImageInstance1Version));
        prepareRead(getProperty(onuCfgOnuImageInstance1Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance1Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance1Commit));
        prepareRead(getProperty(onuCfgOnuMacAddress));
        prepareRead(getProperty(onuCfgOnuDHCPMode));
        prepareRead(getProperty(onuCfgOnuIPAddress));
        prepareRead(getProperty(onuCfgOnuIPMask));
        prepareRead(getProperty(onuCfgOnuDefaultGateway));
        prepareRead(getProperty(onuCfgOnuReset));

        //prepareRead(getProperty(onuCfgOnuMulticastFilterMode));
        //prepareRead(getProperty(onuCfgOnuMulticastGemPortNo));
        //prepareRead(getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex));

        prepareRead(getProperty(onuCfgMacLimit));
        prepareRead(getProperty(onuCfgFecTxEnable));
        prepareRead(getProperty(onuCfgOnuFastLeaveCapability));
        prepareRead(getProperty(onuCfgPiggybackDbaRep));
        prepareRead(getProperty(onuCfgWholeOnuDbaRep));

        prepareRead(getProperty(onuCfgOnuVoIPBindingType));
        prepareRead(getProperty(onuCfgOnuVoIPUserName));
        prepareRead(getProperty(onuCfgOnuVoIPPassword));
        prepareRead(getProperty(onuCfgOnuVoIPServiceProfileIndex));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuCfgPassword));
        prepareRead(getProperty(onuCfgPrimaryStatus));
        prepareRead(getProperty(onuCfgUpstreamTrafficMappingType));
        prepareRead(getProperty(onuCfgUpstreamTrafficMappingProfileIndex));
        prepareRead(getProperty(onuCfgTcontVirtualPortBindingType));
        prepareRead(getProperty(onuCfgTcontVirtualPortBindingProfileIndex));
        prepareRead(getProperty(onuCfgServiceSubscription));
        prepareRead(getProperty(onuCfgOnuEqualizationDelay));
        prepareRead(getProperty(onuCfgBerIntervalConfiguration));
        prepareRead(getProperty(onuCfgPowerLevel));
        prepareRead(getProperty(onuCfgVendorID));
        prepareRead(getProperty(onuCfgVersion));
        prepareRead(getProperty(onuCfgSerialNumber));
        prepareRead(getProperty(onuCfgTrafficManagementOption));
        prepareRead(getProperty(onuCfgBatteryBackup));
        prepareRead(getProperty(onuCfgAdministrativeState));
        prepareRead(getProperty(onuCfgOperationalState));
        prepareRead(getProperty(onuCfgEquipmentID));
        prepareRead(getProperty(onuCfgOmccVersion));
        prepareRead(getProperty(onuCfgOnuHardwareType));
        prepareRead(getProperty(onuCfgOnuHardwareRevision));
        prepareRead(getProperty(onuCfgSecurityCapability));
        prepareRead(getProperty(onuCfgSecurityMode));
        prepareRead(getProperty(onuCfgTotalPriorityQueueNumber));
        prepareRead(getProperty(onuCfgTotalTrafficSchedulerNumber));
        prepareRead(getProperty(onuCfgTotalGEMPortNumber));
        prepareRead(getProperty(onuCfgTotalTCONTNumber));
        prepareRead(getProperty(onuCfgTotalEthernetUNINumber));
        prepareRead(getProperty(onuCfgTotalPOTSUNINumber));
        prepareRead(getProperty(onuCfgSysUpTime));
        prepareRead(getProperty(onuCfgOnuImageInstance0Version));
        prepareRead(getProperty(onuCfgOnuImageInstance0Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance0Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance0Commit));
        prepareRead(getProperty(onuCfgOnuImageInstance1Version));
        prepareRead(getProperty(onuCfgOnuImageInstance1Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance1Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance1Commit));
        prepareRead(getProperty(onuCfgOnuMacAddress));
        prepareRead(getProperty(onuCfgOnuDHCPMode));
        prepareRead(getProperty(onuCfgOnuIPAddress));
        prepareRead(getProperty(onuCfgOnuIPMask));
        prepareRead(getProperty(onuCfgOnuDefaultGateway));
        prepareRead(getProperty(onuCfgOnuReset));

        //prepareRead(getProperty(onuCfgOnuMulticastFilterMode));
        //prepareRead(getProperty(onuCfgOnuMulticastGemPortNo));
        //prepareRead(getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex));

        prepareRead(getProperty(onuCfgMacLimit));
        prepareRead(getProperty(onuCfgFecTxEnable));
        prepareRead(getProperty(onuCfgOnuFastLeaveCapability));
        prepareRead(getProperty(onuCfgPiggybackDbaRep));
        prepareRead(getProperty(onuCfgWholeOnuDbaRep));

        prepareRead(getProperty(onuCfgOnuVoIPBindingType));
        prepareRead(getProperty(onuCfgOnuVoIPUserName));
        prepareRead(getProperty(onuCfgOnuVoIPPassword));
        prepareRead(getProperty(onuCfgOnuVoIPServiceProfileIndex));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuCfgPassword));
        prepareSave(getProperty(onuCfgUpstreamTrafficMappingType));
        prepareSave(getProperty(onuCfgUpstreamTrafficMappingProfileIndex));
        prepareSave(getProperty(onuCfgTcontVirtualPortBindingType));
        prepareSave(getProperty(onuCfgTcontVirtualPortBindingProfileIndex));
        prepareSave(getProperty(onuCfgServiceSubscription));
        prepareSave(getProperty(onuCfgBerIntervalConfiguration));
        prepareSave(getProperty(onuCfgSerialNumber));
        prepareSave(getProperty(onuCfgBatteryBackup));
        prepareSave(getProperty(onuCfgAdministrativeState));
        prepareSave(getProperty(onuCfgSecurityMode));
        prepareSave(getProperty(onuCfgOnuDHCPMode));
        prepareSave(getProperty(onuCfgOnuIPAddress));
        prepareSave(getProperty(onuCfgOnuIPMask));
        prepareSave(getProperty(onuCfgOnuDefaultGateway));

        //prepareSave(getProperty(onuCfgOnuMulticastFilterMode));
        //prepareSave(getProperty(onuCfgOnuMulticastGemPortNo));
        //prepareSave(getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex));

        prepareSave(getProperty(onuCfgMacLimit));
        prepareSave(getProperty(onuCfgFecTxEnable));

        //prepareSave(getProperty(onuCfgOnuVoIPBindingType));
        prepareSave(getProperty(onuCfgOnuVoIPUserName));
        prepareSave(getProperty(onuCfgOnuVoIPPassword));
        prepareSave(getProperty(onuCfgOnuVoIPServiceProfileIndex));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuCfgPassword));
        prepareSave(getProperty(onuCfgUpstreamTrafficMappingType));
        prepareSave(getProperty(onuCfgUpstreamTrafficMappingProfileIndex));
        prepareSave(getProperty(onuCfgTcontVirtualPortBindingType));
        prepareSave(getProperty(onuCfgTcontVirtualPortBindingProfileIndex));
        prepareSave(getProperty(onuCfgServiceSubscription));
        prepareSave(getProperty(onuCfgBerIntervalConfiguration));
        prepareSave(getProperty(onuCfgSerialNumber));
        prepareSave(getProperty(onuCfgBatteryBackup));
        prepareSave(getProperty(onuCfgAdministrativeState));
        prepareSave(getProperty(onuCfgSecurityMode));
        prepareSave(getProperty(onuCfgOnuDHCPMode));
        prepareSave(getProperty(onuCfgOnuIPAddress));
        prepareSave(getProperty(onuCfgOnuIPMask));
        prepareSave(getProperty(onuCfgOnuDefaultGateway));

        //prepareSave(getProperty(onuCfgOnuMulticastFilterMode));
        //prepareSave(getProperty(onuCfgOnuMulticastGemPortNo));
        //prepareSave(getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex));

        prepareSave(getProperty(onuCfgMacLimit));
        prepareSave(getProperty(onuCfgFecTxEnable));

        //prepareSave(getProperty(onuCfgOnuVoIPBindingType));
        prepareSave(getProperty(onuCfgOnuVoIPUserName));
        prepareSave(getProperty(onuCfgOnuVoIPPassword));
        prepareSave(getProperty(onuCfgOnuVoIPServiceProfileIndex));

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
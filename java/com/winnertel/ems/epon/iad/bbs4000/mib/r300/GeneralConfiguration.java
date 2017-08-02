package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

//modified by Zhou Chao, 2008/12/9
public class GeneralConfiguration extends SnmpMibBean {

    public static final String utsBBSBPDUTermination = "utsBBSBPDUTermination";
    public static final String utsBBSSysSoftwareRateLimiting = "utsBBSSysSoftwareRateLimiting";
    //public static final String utsBBSSysHardwareRateLimiting = "utsBBSSysHardwareRateLimiting";
    public static final String utsBBSSysCpuUtilityAlarmThresholdTotal = "utsBBSSysCpuUtilityAlarmThresholdTotal";
    public static final String utsBBSSysCpuUtilityAlarmThresholdPerTask = "utsBBSSysCpuUtilityAlarmThresholdPerTask";
    public static final String utsBBSSysMemoryUtilityAlarmThreshold = "utsBBSSysMemoryUtilityAlarmThreshold";
    public static final String utsBBSSysARPAgingTime = "utsBBSSysARPAgingTime";
    public static final String utsBBSSysMACAgingTime = "utsBBSSysMACAgingTime";
    //public static final String utsBBSOnuByteErrorWindow = "utsBBSOnuByteErrorWindow";
    //public static final String utsBBSOnuByteErrorThresholdMin = "utsBBSOnuByteErrorThresholdMin";
    //public static final String utsPonSysLogicalPortStrictBinging = "utsPonSysLogicalPortStrictBinging";
    //public static final String utsPonSysOltMACAgingTime = "utsPonSysOltMACAgingTime";
    public static final String utsPonSysOlpMode = "utsPonSysOlpMode";
    public static final String utsBBSVlanVPNTPID = "utsBBSVlanVPNTPID";
    public static final String utsBBSVlanVPNPRISource = "utsBBSVlanVPNPRISource";
    public static final String utsBBSMaxFrameSize = "utsBBSMaxFrameSize";
    public static final String utsBBSMgmtGratuitousArpLearning = "utsBBSMgmtGratuitousArpLearning";
    public static final String utsBBSMgmtIgmpProxySourceIP = "utsBBSMgmtIgmpProxySourceIP";
    public static final String utsBBSMgmtUplinkBandwidthThreshold = "utsBBSMgmtUplinkBandwidthThreshold";
    public static final String utsBBSMgmtUniBandwidthThreshold = "utsBBSMgmtUniBandwidthThreshold";
    public static final String utsBBSMgmtIGMProxySourceInnerVLAN = "utsBBSMgmtIGMProxySourceInnerVLAN";
    public static final String utsBBSMgmtIGMProxySourceOuterVLAN = "utsBBSMgmtIGMProxySourceOuterVLAN";
    public static final String utsBBSMgmtONUSNumberSwitch = "utsBBSMgmtONUSNumberSwitch";

    public GeneralConfiguration(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsBBSBPDUTermination, new SnmpMibBeanProperty(utsBBSBPDUTermination, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.15", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysSoftwareRateLimiting, new SnmpMibBeanProperty(utsBBSSysSoftwareRateLimiting, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.16", ISnmpConstant.INTEGER));
        //initProperty(utsBBSSysHardwareRateLimiting, new SnmpMibBeanProperty(utsBBSSysHardwareRateLimiting, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.17", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysCpuUtilityAlarmThresholdTotal, new SnmpMibBeanProperty(utsBBSSysCpuUtilityAlarmThresholdTotal, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.18", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask, new SnmpMibBeanProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.19", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysMemoryUtilityAlarmThreshold, new SnmpMibBeanProperty(utsBBSSysMemoryUtilityAlarmThreshold, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.20", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysARPAgingTime, new SnmpMibBeanProperty(utsBBSSysARPAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.21", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysMACAgingTime, new SnmpMibBeanProperty(utsBBSSysMACAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.22", ISnmpConstant.INTEGER));
        //initProperty(utsBBSOnuByteErrorWindow, new SnmpMibBeanProperty(utsBBSOnuByteErrorWindow, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.24", ISnmpConstant.INTEGER));
        //initProperty(utsBBSOnuByteErrorThresholdMin, new SnmpMibBeanProperty(utsBBSOnuByteErrorThresholdMin, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.25", ISnmpConstant.INTEGER));
        //initProperty(utsPonSysLogicalPortStrictBinging, new SnmpMibBeanProperty(utsPonSysLogicalPortStrictBinging, ".1.3.6.1.4.1.45121.1800.2.1.1.2.3", ISnmpConstant.INTEGER));
        //initProperty(utsPonSysOltMACAgingTime, new SnmpMibBeanProperty(utsPonSysOltMACAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.2.5", ISnmpConstant.INTEGER));
        initProperty(utsPonSysOlpMode, new SnmpMibBeanProperty(utsPonSysOlpMode, ".1.3.6.1.4.1.45121.1800.2.1.1.2.7", ISnmpConstant.INTEGER));
        initProperty(utsBBSVlanVPNTPID, new SnmpMibBeanProperty(utsBBSVlanVPNTPID, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.1", ISnmpConstant.INTEGER));
        initProperty(utsBBSVlanVPNPRISource, new SnmpMibBeanProperty(utsBBSVlanVPNPRISource, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.3", ISnmpConstant.INTEGER));
        initProperty(utsBBSMaxFrameSize, new SnmpMibBeanProperty(utsBBSMaxFrameSize, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.4", ISnmpConstant.INTEGER));
        initProperty(utsBBSMgmtGratuitousArpLearning, new SnmpMibBeanProperty(utsBBSMgmtGratuitousArpLearning, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.38", ISnmpConstant.INTEGER));
        initProperty(utsBBSMgmtIgmpProxySourceIP, new SnmpMibBeanProperty(utsBBSMgmtIgmpProxySourceIP, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.51", ISnmpConstant.IP_ADDRESS));
        initProperty(utsBBSMgmtUplinkBandwidthThreshold, new SnmpMibBeanProperty(utsBBSMgmtUplinkBandwidthThreshold, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.54", ISnmpConstant.INTEGER));
        initProperty(utsBBSMgmtUniBandwidthThreshold, new SnmpMibBeanProperty(utsBBSMgmtUniBandwidthThreshold, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.55", ISnmpConstant.INTEGER));
        initProperty(utsBBSMgmtIGMProxySourceInnerVLAN, new SnmpMibBeanProperty(utsBBSMgmtIGMProxySourceInnerVLAN, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.56", ISnmpConstant.INTEGER));
        initProperty(utsBBSMgmtIGMProxySourceOuterVLAN, new SnmpMibBeanProperty(utsBBSMgmtIGMProxySourceOuterVLAN, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.58", ISnmpConstant.INTEGER));
        initProperty(utsBBSMgmtONUSNumberSwitch, new SnmpMibBeanProperty(utsBBSMgmtONUSNumberSwitch, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.59", ISnmpConstant.INTEGER));
    }

    public Integer getUtsBBSBPDUTermination() {
        return (Integer) getProperty(utsBBSBPDUTermination).getValue();
    }

    public void setUtsBBSBPDUTermination(Integer aUtsBBSBPDUTermination) {
        getProperty(utsBBSBPDUTermination).setValue(aUtsBBSBPDUTermination);
    }

    public Integer getUtsBBSSysSoftwareRateLimiting() {
        return (Integer) getProperty(utsBBSSysSoftwareRateLimiting).getValue();
    }

    public void setUtsBBSSysSoftwareRateLimiting(Integer aUtsBBSSysSoftwareRateLimiting) {
        getProperty(utsBBSSysSoftwareRateLimiting).setValue(aUtsBBSSysSoftwareRateLimiting);
    }

    /*
    public Integer getUtsBBSSysHardwareRateLimiting() {
        return (Integer) getProperty(utsBBSSysHardwareRateLimiting).getValue();
    }

    public void setUtsBBSSysHardwareRateLimiting(Integer aUtsBBSSysHardwareRateLimiting) {
        getProperty(utsBBSSysHardwareRateLimiting).setValue(aUtsBBSSysHardwareRateLimiting);
    }
    */

    public Integer getUtsBBSSysCpuUtilityAlarmThresholdTotal() {
        return (Integer) getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal).getValue();
    }

    public void setUtsBBSSysCpuUtilityAlarmThresholdTotal(Integer aUtsBBSSysCpuUtilityAlarmThresholdTotal) {
        getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal).setValue(aUtsBBSSysCpuUtilityAlarmThresholdTotal);
    }

    public Integer getUtsBBSSysCpuUtilityAlarmThresholdPerTask() {
        return (Integer) getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask).getValue();
    }

    public void setUtsBBSSysCpuUtilityAlarmThresholdPerTask(Integer aUtsBBSSysCpuUtilityAlarmThresholdPerTask) {
        getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask).setValue(aUtsBBSSysCpuUtilityAlarmThresholdPerTask);
    }

    public Integer getUtsBBSSysMemoryUtilityAlarmThreshold() {
        return (Integer) getProperty(utsBBSSysMemoryUtilityAlarmThreshold).getValue();
    }

    public void setUtsBBSSysMemoryUtilityAlarmThreshold(Integer aUtsBBSSysMemoryUtilityAlarmThreshold) {
        getProperty(utsBBSSysMemoryUtilityAlarmThreshold).setValue(aUtsBBSSysMemoryUtilityAlarmThreshold);
    }

    public Integer getUtsBBSSysARPAgingTime() {
        return (Integer) getProperty(utsBBSSysARPAgingTime).getValue();
    }

    public void setUtsBBSSysARPAgingTime(Integer aUtsBBSSysARPAgingTime) {
        getProperty(utsBBSSysARPAgingTime).setValue(aUtsBBSSysARPAgingTime);
    }

    public Integer getUtsBBSSysMACAgingTime() {
        return (Integer) getProperty(utsBBSSysMACAgingTime).getValue();
    }

    public void setUtsBBSSysMACAgingTime(Integer aUtsBBSSysMACAgingTime) {
        getProperty(utsBBSSysMACAgingTime).setValue(aUtsBBSSysMACAgingTime);
    }

    /*
    public Integer getUtsBBSOnuByteErrorWindow() {
        return (Integer) getProperty(utsBBSOnuByteErrorWindow).getValue();
    }

    public void setUtsBBSOnuByteErrorWindow(Integer aUtsBBSOnuByteErrorWindow) {
        getProperty(utsBBSOnuByteErrorWindow).setValue(aUtsBBSOnuByteErrorWindow);
    }

    public Integer getUtsBBSOnuByteErrorThresholdMin() {
        return (Integer) getProperty(utsBBSOnuByteErrorThresholdMin).getValue();
    }

    public void setUtsBBSOnuByteErrorThresholdMin(Integer aUtsBBSOnuByteErrorThresholdMin) {
        getProperty(utsBBSOnuByteErrorThresholdMin).setValue(aUtsBBSOnuByteErrorThresholdMin);
    }

    public Integer getUtsPonSysLogicalPortStrictBinging() {
        return (Integer) getProperty(utsPonSysLogicalPortStrictBinging).getValue();
    }

    public void setUtsPonSysLogicalPortStrictBinging(Integer aUtsPonSysLogicalPortStrictBinging) {
        getProperty(utsPonSysLogicalPortStrictBinging).setValue(aUtsPonSysLogicalPortStrictBinging);
    }

    public Integer getUtsPonSysOltMACAgingTime() {
        return (Integer) getProperty(utsPonSysOltMACAgingTime).getValue();
    }

    public void setUtsPonSysOltMACAgingTime(Integer aUtsPonSysOltMACAgingTime) {
        getProperty(utsPonSysOltMACAgingTime).setValue(aUtsPonSysOltMACAgingTime);
    }
    */

    public Integer getUtsPonSysOlpMode() {
        return (Integer) getProperty(utsPonSysOlpMode).getValue();
    }

    public void setUtsPonSysOlpMode(Integer aUtsPonSysOlpMode) {
        getProperty(utsPonSysOlpMode).setValue(aUtsPonSysOlpMode);
    }

    public Integer getUtsBBSVlanVPNTPID() {
        return (Integer) getProperty(utsBBSVlanVPNTPID).getValue();
    }

    public void setUtsBBSVlanVPNTPID(Integer aUtsBBSVlanVPNTPID) {
        getProperty(utsBBSVlanVPNTPID).setValue(aUtsBBSVlanVPNTPID);
    }

    public Integer getUtsBBSVlanVPNPRISource() {
        return (Integer) getProperty(utsBBSVlanVPNPRISource).getValue();
    }

    public void setUtsBBSVlanVPNPRISource(Integer aUtsBBSVlanVPNPRISource) {
        getProperty(utsBBSVlanVPNPRISource).setValue(aUtsBBSVlanVPNPRISource);
    }

    public Integer getUtsBBSMaxFrameSize() {
        return (Integer) getProperty(utsBBSMaxFrameSize).getValue();
    }

    public void setUtsBBSMaxFrameSize(Integer aUtsBBSMaxFrameSize) {
        getProperty(utsBBSMaxFrameSize).setValue(aUtsBBSMaxFrameSize);
    }

    public Integer getUtsBBSMgmtGratuitousArpLearning() {
        return (Integer) getProperty(utsBBSMgmtGratuitousArpLearning).getValue();
    }

    public void setUtsBBSMgmtGratuitousArpLearning(Integer aUtsBBSMgmtGratuitousArpLearning) {
        getProperty(utsBBSMgmtGratuitousArpLearning).setValue(aUtsBBSMgmtGratuitousArpLearning);
    }

    public String getUtsBBSMgmtIgmpProxySourceIP() {
        return (String) getProperty(utsBBSMgmtIgmpProxySourceIP).getValue();
    }

    public void setUtsBBSMgmtIgmpProxySourceIP(String aUtsBBSMgmtIgmpProxySourceIP) {
        getProperty(utsBBSMgmtIgmpProxySourceIP).setValue(aUtsBBSMgmtIgmpProxySourceIP);
    }

    public Integer getUtsBBSMgmtUplinkBandwidthThreshold() {
        return (Integer) getProperty(utsBBSMgmtUplinkBandwidthThreshold).getValue();
    }

    public void setUtsBBSMgmtUplinkBandwidthThreshold(Integer aUtsBBSMgmtUplinkBandwidthThreshold) {
        getProperty(utsBBSMgmtUplinkBandwidthThreshold).setValue(aUtsBBSMgmtUplinkBandwidthThreshold);
    }

    public Integer getUtsBBSMgmtUniBandwidthThreshold() {
        return (Integer) getProperty(utsBBSMgmtUniBandwidthThreshold).getValue();
    }

    public void setUtsBBSMgmtUniBandwidthThreshold(Integer aUtsBBSMgmtUniBandwidthThreshold) {
        getProperty(utsBBSMgmtUniBandwidthThreshold).setValue(aUtsBBSMgmtUniBandwidthThreshold);
    }

    public Integer getUtsBBSMgmtIGMProxySourceInnerVLAN() {
        return (Integer) getProperty(utsBBSMgmtIGMProxySourceInnerVLAN).getValue();
    }

    public void setUtsBBSMgmtIGMProxySourceInnerVLAN(Integer aUtsBBSMgmtIGMProxySourceInnerVLAN) {
        getProperty(utsBBSMgmtIGMProxySourceInnerVLAN).setValue(aUtsBBSMgmtIGMProxySourceInnerVLAN);
    }

    public Integer getUtsBBSMgmtIGMProxySourceOuterVLAN() {
        return (Integer) getProperty(utsBBSMgmtIGMProxySourceOuterVLAN).getValue();
    }

    public void setUtsBBSMgmtIGMProxySourceOuterVLAN(Integer aUtsBBSMgmtIGMProxySourceOuterVLAN) {
        getProperty(utsBBSMgmtIGMProxySourceOuterVLAN).setValue(aUtsBBSMgmtIGMProxySourceOuterVLAN);
    }

    public Integer getUtsBBSMgmtONUSNumberSwitch() {
        return (Integer) getProperty(utsBBSMgmtONUSNumberSwitch).getValue();
    }

    public void setUtsBBSMgmtONUSNumberSwitch(Integer aUtsBBSMgmtONUSNumberSwitch) {
        getProperty(utsBBSMgmtONUSNumberSwitch).setValue(aUtsBBSMgmtONUSNumberSwitch);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsBBSBPDUTermination));
        prepareRead(getProperty(utsBBSSysSoftwareRateLimiting));
        //prepareRead(getProperty(utsBBSSysHardwareRateLimiting));
        prepareRead(getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal));
        prepareRead(getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask));
        prepareRead(getProperty(utsBBSSysMemoryUtilityAlarmThreshold));
        prepareRead(getProperty(utsBBSSysARPAgingTime));
        prepareRead(getProperty(utsBBSSysMACAgingTime));
        //prepareRead(getProperty(utsBBSOnuByteErrorWindow));
        //prepareRead(getProperty(utsBBSOnuByteErrorThresholdMin));
        //prepareRead(getProperty(utsPonSysLogicalPortStrictBinging));
        //prepareRead(getProperty(utsPonSysOltMACAgingTime));
        prepareRead(getProperty(utsPonSysOlpMode));
        prepareRead(getProperty(utsBBSVlanVPNTPID));
        prepareRead(getProperty(utsBBSVlanVPNPRISource));
        prepareRead(getProperty(utsBBSMaxFrameSize));
        prepareRead(getProperty(utsBBSMgmtGratuitousArpLearning));
        prepareRead(getProperty(utsBBSMgmtIgmpProxySourceIP));
        prepareRead(getProperty(utsBBSMgmtUplinkBandwidthThreshold));
        prepareRead(getProperty(utsBBSMgmtUniBandwidthThreshold));
        prepareRead(getProperty(utsBBSMgmtIGMProxySourceInnerVLAN));
        prepareRead(getProperty(utsBBSMgmtIGMProxySourceOuterVLAN));
        prepareRead(getProperty(utsBBSMgmtONUSNumberSwitch));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsBBSBPDUTermination));
        //prepareSave(getProperty(utsBBSSysSoftwareRateLimiting));
        //prepareSave(getProperty(utsBBSSysHardwareRateLimiting));
        prepareSave(getProperty(utsBBSSysCpuUtilityAlarmThresholdTotal));
        prepareSave(getProperty(utsBBSSysCpuUtilityAlarmThresholdPerTask));
        prepareSave(getProperty(utsBBSSysMemoryUtilityAlarmThreshold));
        prepareSave(getProperty(utsBBSSysARPAgingTime));
        prepareSave(getProperty(utsBBSSysMACAgingTime));
        //prepareSave(getProperty(utsBBSOnuByteErrorWindow));
        //prepareSave(getProperty(utsBBSOnuByteErrorThresholdMin));
        //prepareSave(getProperty(utsPonSysLogicalPortStrictBinging));
        //prepareSave(getProperty(utsPonSysOltMACAgingTime));
        prepareSave(getProperty(utsPonSysOlpMode));
        //prepareSave(getProperty(utsBBSVlanVPNTPID));
        prepareSave(getProperty(utsBBSMaxFrameSize));
        prepareSave(getProperty(utsBBSMgmtGratuitousArpLearning));
        prepareSave(getProperty(utsBBSMgmtIgmpProxySourceIP));
        prepareSave(getProperty(utsBBSMgmtUplinkBandwidthThreshold));
        prepareSave(getProperty(utsBBSMgmtUniBandwidthThreshold));
        prepareSave(getProperty(utsBBSMgmtIGMProxySourceInnerVLAN));
        prepareSave(getProperty(utsBBSMgmtIGMProxySourceOuterVLAN));
        prepareSave(getProperty(utsBBSMgmtONUSNumberSwitch));

        return save();
    }

}
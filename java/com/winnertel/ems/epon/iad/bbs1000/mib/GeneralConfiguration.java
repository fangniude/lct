package com.winnertel.ems.epon.iad.bbs1000.mib;

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
    public static final String utsBBSSysARPAgingTime = "utsBBSSysARPAgingTime";
    public static final String utsBBSSysMACAgingTime = "utsBBSSysMACAgingTime";
    // public static final String utsPonSysOltMACAgingTime = "utsPonSysOltMACAgingTime";
    public static final String utsPonSysOlpMode = "utsPonSysOlpMode";
    public static final String utsPonSysDot1adTPID = "utsPonSysDot1adTPID";

    public GeneralConfiguration(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsBBSBPDUTermination, new SnmpMibBeanProperty(utsBBSBPDUTermination, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.15", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysSoftwareRateLimiting, new SnmpMibBeanProperty(utsBBSSysSoftwareRateLimiting, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.16", ISnmpConstant.INTEGER));
        //initProperty(utsBBSSysHardwareRateLimiting, new SnmpMibBeanProperty(utsBBSSysHardwareRateLimiting, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.17", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysARPAgingTime, new SnmpMibBeanProperty(utsBBSSysARPAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.21", ISnmpConstant.INTEGER));
        initProperty(utsBBSSysMACAgingTime, new SnmpMibBeanProperty(utsBBSSysMACAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.22", ISnmpConstant.INTEGER));
        //initProperty(utsPonSysOltMACAgingTime, new SnmpMibBeanProperty(utsPonSysOltMACAgingTime, ".1.3.6.1.4.1.45121.1800.2.1.1.2.5", ISnmpConstant.INTEGER));
        initProperty(utsPonSysOlpMode, new SnmpMibBeanProperty(utsPonSysOlpMode, ".1.3.6.1.4.1.45121.1800.2.1.1.2.7", ISnmpConstant.INTEGER));
        initProperty(utsPonSysDot1adTPID, new SnmpMibBeanProperty(utsPonSysDot1adTPID, ".1.3.6.1.4.1.45121.1800.2.1.1.2.8", ISnmpConstant.INTEGER));
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

    public Integer getUtsPonSysDot1adTPID() {
        return (Integer) getProperty(utsPonSysDot1adTPID).getValue();
    }

    public void setUtsPonSysDot1adTPID(Integer autsPonSysDot1adTPID) {
        getProperty(utsPonSysDot1adTPID).setValue(autsPonSysDot1adTPID);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsBBSBPDUTermination));
        prepareRead(getProperty(utsBBSSysSoftwareRateLimiting));
        //prepareRead(getProperty(utsBBSSysHardwareRateLimiting));
        prepareRead(getProperty(utsBBSSysARPAgingTime));
        prepareRead(getProperty(utsBBSSysMACAgingTime));
        //prepareRead(getProperty(utsPonSysOltMACAgingTime));
        prepareRead(getProperty(utsPonSysOlpMode));
        prepareRead(getProperty(utsPonSysDot1adTPID));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsBBSBPDUTermination));
        //prepareSave(getProperty(utsBBSSysSoftwareRateLimiting));
        //prepareSave(getProperty(utsBBSSysHardwareRateLimiting));
        prepareSave(getProperty(utsBBSSysARPAgingTime));
        prepareSave(getProperty(utsBBSSysMACAgingTime));
        //prepareSave(getProperty(utsPonSysOltMACAgingTime));
        prepareSave(getProperty(utsPonSysOlpMode));
        //prepareSave(getProperty(utsPonSysDot1adTPID));

        return save();
    }

}
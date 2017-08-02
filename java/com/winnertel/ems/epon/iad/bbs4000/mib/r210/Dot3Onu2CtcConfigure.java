package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2CtcConfigure extends SnmpMibBean {

    public static final String utsDot3Onu2CtcModuleId = "utsDot3Onu2CtcModuleId";
    public static final String utsDot3Onu2CtcDeviceId = "utsDot3Onu2CtcDeviceId";
    public static final String utsDot3Onu2CtcPortId = "utsDot3Onu2CtcPortId";
    public static final String utsDot3Onu2CtcLogicalPortId = "utsDot3Onu2CtcLogicalPortId";

    public static final String utsDot3Onu2CtcFECAbility = "utsDot3Onu2CtcFECAbility";
    public static final String utsDot3Onu2CtcFECMode = "utsDot3Onu2CtcFECMode";
    public static final String utsDot3Onu2CtcEncryptTraffic = "utsDot3Onu2CtcEncryptTraffic";
    public static final String utsDot3Onu2CtcMaxMacAddress = "utsDot3Onu2CtcMaxMacAddress";
    public static final String utsDot3Onu2EthernetPortAlarmReversion = "utsDot3Onu2EthernetPortAlarmReversion";
    public static final String utsDot3Onu2CtcAdmin = "utsDot3Onu2CtcAdmin";
    public static final String utsDot3Onu2CtcRegisterStatus = "utsDot3Onu2CtcRegisterStatus";
    public static final String utsDot3Onu2CtcPVid = "utsDot3Onu2CtcPVid";
    public static final String utsDot3Onu2CtcReset = "utsDot3Onu2CtcReset";
    public static final String utsDot3Onu2SNumberValid = "utsDot3Onu2SNumberValid"; //added by Zhou Chao, 2008/12/10
    public static final String utsDot3Onu2SNumberForService = "utsDot3Onu2SNumberForService"; //added by Zhou Chao, 2008/12/10
    public static final String utsDot3Onu2dot1xUserName = "utsDot3Onu2dot1xUserName"; //added by Zhou Chao, 2008/12/10
    public static final String utsDot3Onu2dot1xPassword = "utsDot3Onu2dot1xPassword"; //added by Zhou Chao, 2008/12/10

    public Dot3Onu2CtcConfigure(ISnmpProxy arg0) {
        super(arg0);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(
                utsDot3Onu2CtcModuleId,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.1",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(
                utsDot3Onu2CtcDeviceId,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.2",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(
                utsDot3Onu2CtcPortId,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.3",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(
                utsDot3Onu2CtcLogicalPortId,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.4",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFECAbility, new SnmpMibBeanProperty(
                utsDot3Onu2CtcFECAbility,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.24",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFECMode, new SnmpMibBeanProperty(
                utsDot3Onu2CtcFECMode,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.25",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcEncryptTraffic, new SnmpMibBeanProperty(
                utsDot3Onu2CtcEncryptTraffic,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.34",
                ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcPVid, new
        // SnmpMibBeanProperty(utsDot3Onu2CtcPVid,
        // ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.39", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMaxMacAddress, new SnmpMibBeanProperty(
                utsDot3Onu2CtcMaxMacAddress,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.40",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2EthernetPortAlarmReversion,
                new SnmpMibBeanProperty(utsDot3Onu2EthernetPortAlarmReversion,
                        ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.56",
                        ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAdmin, new SnmpMibBeanProperty(
                utsDot3Onu2CtcAdmin,
                ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.37",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPVid, new SnmpMibBeanProperty(utsDot3Onu2CtcPVid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.39", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcReset, new SnmpMibBeanProperty(utsDot3Onu2CtcReset, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.32", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcRegisterStatus, new SnmpMibBeanProperty(utsDot3Onu2CtcRegisterStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.33", ISnmpConstant.INTEGER));
    
        initProperty(utsDot3Onu2SNumberValid, new SnmpMibBeanProperty(utsDot3Onu2SNumberValid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.61", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2008/12/10
        initProperty(utsDot3Onu2SNumberForService, new SnmpMibBeanProperty(utsDot3Onu2SNumberForService, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.62", ISnmpConstant.STRING)); //added by Zhou Chao, 2008/12/10
        initProperty(utsDot3Onu2dot1xUserName, new SnmpMibBeanProperty(utsDot3Onu2dot1xUserName, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.66", ISnmpConstant.STRING)); //added by Zhou Chao, 2008/12/10
        initProperty(utsDot3Onu2dot1xPassword, new SnmpMibBeanProperty(utsDot3Onu2dot1xPassword, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.68", ISnmpConstant.STRING)); //added by Zhou Chao, 2008/12/10

    }

    public Integer getUtsDot3Onu2CtcModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcModuleId(Integer aUtsDot3Onu2CtcModuleId) {
        setIndex(0, aUtsDot3Onu2CtcModuleId);
    }

    public Integer getUtsDot3Onu2CtcDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcDeviceId(Integer aUtsDot3Onu2CtcDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcDeviceId);
    }

    public Integer getUtsDot3Onu2CtcPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcPortId(Integer aUtsDot3Onu2CtcPortId) {
        setIndex(2, aUtsDot3Onu2CtcPortId);
    }

    public Integer getUtsDot3Onu2CtcLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcLogicalPortId(Integer aUtsDot3Onu2CtcLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcLogicalPortId);
    }

    public Integer getUtsDot3Onu2CtcFECAbility() {
        return (Integer) getProperty(utsDot3Onu2CtcFECAbility).getValue();
    }

    public void setUtsDot3Onu2CtcFECAbility(Integer aUtsDot3Onu2CtcFECAbility) {
        getProperty(utsDot3Onu2CtcFECAbility).setValue(aUtsDot3Onu2CtcFECAbility);
    }

    public Integer getUtsDot3Onu2CtcFECMode() {
        return (Integer) getProperty(utsDot3Onu2CtcFECMode).getValue();
    }

    public void setUtsDot3Onu2CtcFECMode(Integer aUtsDot3Onu2CtcFECMode) {
        getProperty(utsDot3Onu2CtcFECMode).setValue(aUtsDot3Onu2CtcFECMode);
    }

    public Integer getUtsDot3Onu2CtcEncryptTraffic() {
        return (Integer) getProperty(utsDot3Onu2CtcEncryptTraffic).getValue();
    }

    public void setUtsDot3Onu2CtcEncryptTraffic(Integer aUtsDot3Onu2CtcEncryptTraffic) {
        getProperty(utsDot3Onu2CtcEncryptTraffic).setValue(aUtsDot3Onu2CtcEncryptTraffic);
    }

    public Integer getUtsDot3Onu2CtcMaxMacAddress() {
        return (Integer) getProperty(utsDot3Onu2CtcMaxMacAddress).getValue();
    }

    public void setUtsDot3Onu2CtcMaxMacAddress(Integer aUtsDot3Onu2CtcMaxMacAddress) {
        getProperty(utsDot3Onu2CtcMaxMacAddress).setValue(aUtsDot3Onu2CtcMaxMacAddress);
    }

    public Integer getUtsDot3Onu2EthernetPortAlarmReversion() {
        return (Integer) getProperty(utsDot3Onu2EthernetPortAlarmReversion).getValue();
    }

    public void setUtsDot3Onu2EthernetPortAlarmReversion(Integer aUtsDot3Onu2EthernetPortAlarmReversion) {
        getProperty(utsDot3Onu2EthernetPortAlarmReversion).setValue(aUtsDot3Onu2EthernetPortAlarmReversion);
    }

    public Integer getUtsDot3Onu2CtcAdmin() {
        return (Integer) getProperty(utsDot3Onu2CtcAdmin).getValue();
    }

    public void setUtsDot3Onu2CtcAdmin(Integer aUtsDot3Onu2CtcAdmin) {
        getProperty(utsDot3Onu2CtcAdmin).setValue(aUtsDot3Onu2CtcAdmin);
    }

    public Integer getUtsDot3Onu2CtcPVid() {
        return (Integer) getProperty(utsDot3Onu2CtcPVid).getValue();
    }

    public void setUtsDot3Onu2CtcPVid(Integer aUtsDot3Onu2CtcPVid) {
        getProperty(utsDot3Onu2CtcPVid).setValue(aUtsDot3Onu2CtcPVid);
    }

    public Integer getUtsDot3Onu2CtcRegisterStatus() {
        return (Integer) getProperty(utsDot3Onu2CtcRegisterStatus).getValue();
    }

    public void setUtsDot3Onu2CtcRegisterStatus(Integer aUtsDot3Onu2CtcRegisterStatus) {
        getProperty(utsDot3Onu2CtcRegisterStatus).setValue(aUtsDot3Onu2CtcRegisterStatus);
    }

    public Integer getUtsDot3Onu2CtcReset() {
        return (Integer) getProperty(utsDot3Onu2CtcReset).getValue();
    }

    public void setUtsDot3Onu2CtcReset(Integer aUtsDot3Onu2CtcReset3) {
        getProperty(utsDot3Onu2CtcReset).setValue(aUtsDot3Onu2CtcReset3);
    }
    
    public Integer getUtsDot3Onu2SNumberValid() { //added by Zhou Chao, 2008/12/10
        return (Integer) getProperty(utsDot3Onu2SNumberValid).getValue();
    }

    public void setUtsDot3Onu2SNumberValid(Integer aUtsDot3Onu2SNumberValid) { //added by Zhou Chao, 2008/12/10
        getProperty(utsDot3Onu2SNumberValid).setValue(aUtsDot3Onu2SNumberValid);
    }

    public String getUtsDot3Onu2SNumberForService() { //added by Zhou Chao, 2008/12/10
        return (String) getProperty(utsDot3Onu2SNumberForService).getValue();
    }

    public void setUtsDot3Onu2SNumberForService(String aUtsDot3Onu2SNumberForService) { //added by Zhou Chao, 2008/12/10
        getProperty(utsDot3Onu2SNumberForService).setValue(aUtsDot3Onu2SNumberForService);
    }

    public String getUtsDot3Onu2dot1xUserName() { //added by Zhou Chao, 2008/12/10
        return (String) getProperty(utsDot3Onu2dot1xUserName).getValue();
    }

    public void setUtsDot3Onu2dot1xUserName(String aUtsDot3Onu2dot1xUserName) { //added by Zhou Chao, 2008/12/10
        getProperty(utsDot3Onu2dot1xUserName).setValue(aUtsDot3Onu2dot1xUserName);
    }

    public String getUtsDot3Onu2dot1xPassword() { //added by Zhou Chao, 2008/12/10
        return (String) getProperty(utsDot3Onu2dot1xPassword).getValue();
    }

    public void setUtsDot3Onu2dot1xPassword(String aUtsDot3Onu2dot1xPassword) { //added by Zhou Chao, 2008/12/10
        getProperty(utsDot3Onu2dot1xPassword).setValue(aUtsDot3Onu2dot1xPassword);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcFECAbility));
        prepareRead(getProperty(utsDot3Onu2CtcFECMode));
        prepareRead(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareRead(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareRead(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        prepareRead(getProperty(utsDot3Onu2CtcAdmin));
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));
        prepareRead(getProperty(utsDot3Onu2CtcPVid));
        
        prepareRead(getProperty(utsDot3Onu2SNumberValid)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2SNumberForService)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2dot1xUserName)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2dot1xPassword)); //added by Zhou Chao, 2008/12/10


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcFECAbility));
        prepareRead(getProperty(utsDot3Onu2CtcFECMode));
        prepareRead(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareRead(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareRead(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        prepareRead(getProperty(utsDot3Onu2CtcAdmin));
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));
        prepareRead(getProperty(utsDot3Onu2CtcPVid));
        
        prepareRead(getProperty(utsDot3Onu2SNumberValid)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2SNumberForService)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2dot1xUserName)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2dot1xPassword)); //added by Zhou Chao, 2008/12/10


        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3Onu2CtcFECMode));
        prepareSave(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareSave(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareSave(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        prepareSave(getProperty(utsDot3Onu2CtcPVid));
        prepareSave(getProperty(utsDot3Onu2CtcAdmin));
        
        prepareSave(getProperty(utsDot3Onu2SNumberValid)); //added by Zhou Chao, 2008/12/10
        prepareSave(getProperty(utsDot3Onu2SNumberForService)); //added by Zhou Chao, 2008/12/10
        prepareSave(getProperty(utsDot3Onu2dot1xUserName)); //added by Zhou Chao, 2008/12/10
        prepareSave(getProperty(utsDot3Onu2dot1xPassword)); //added by Zhou Chao, 2008/12/10


        return save();
    }

    public boolean resetONU() throws MibBeanException {
        setUtsDot3Onu2CtcReset(new Integer(1));
        prepareSave(getProperty(utsDot3Onu2CtcReset));

        return save();
    }

}
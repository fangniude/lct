package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

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
    public static final String utsDot3Onu2CtcAdmin = "utsDot3Onu2CtcAdmin";
    public static final String utsDot3Onu2CtcRegisterStatus = "utsDot3Onu2CtcRegisterStatus";
    public static final String utsDot3Onu2CtcPVid = "utsDot3Onu2CtcPVid";
    public static final String utsDot3Onu2CtcVoIPPortLock = "utsDot3Onu2CtcVoIPPortLock";
    public static final String utsDot3Onu2CtcE1PortLock = "utsDot3Onu2CtcE1PortLock";
    public static final String utsDot3Onu2CtcVlanTrunkSwitch = "utsDot3Onu2CtcVlanTrunkSwitch"; //added by Zhou Chao, 2008/10/15
    public static final String utsDot3Onu2CtcVlanTrunkList = "utsDot3Onu2CtcVlanTrunkList"; //added by Zhou Chao, 2008/10/15

    public static final String utsDot3Onu2CtcReset = "utsDot3Onu2CtcReset";

    public Dot3Onu2CtcConfigure(ISnmpProxy arg0) {
        super(arg0);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.4", ISnmpConstant.INTEGER));

        initProperty(utsDot3Onu2CtcFECAbility, new SnmpMibBeanProperty(utsDot3Onu2CtcFECAbility, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.24", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFECMode, new SnmpMibBeanProperty(utsDot3Onu2CtcFECMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.25", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcEncryptTraffic, new SnmpMibBeanProperty(utsDot3Onu2CtcEncryptTraffic, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.34", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcPVid, new SnmpMibBeanProperty(utsDot3Onu2CtcPVid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.39", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMaxMacAddress, new SnmpMibBeanProperty(utsDot3Onu2CtcMaxMacAddress, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.40", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAdmin, new SnmpMibBeanProperty(utsDot3Onu2CtcAdmin, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.37", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPVid, new SnmpMibBeanProperty(utsDot3Onu2CtcPVid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.39", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcMaxMacAddress, new SnmpMibBeanProperty(utsDot3Onu2CtcMaxMacAddress, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.40", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcVoIPPortLock, new SnmpMibBeanProperty(utsDot3Onu2CtcVoIPPortLock, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.50", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcE1PortLock, new SnmpMibBeanProperty(utsDot3Onu2CtcE1PortLock, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.51", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcRegisterStatus, new SnmpMibBeanProperty(utsDot3Onu2CtcRegisterStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.33", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcVlanTrunkSwitch, new SnmpMibBeanProperty(utsDot3Onu2CtcVlanTrunkSwitch, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.55", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2008/10/15
        initProperty(utsDot3Onu2CtcVlanTrunkList, new SnmpMibBeanProperty(utsDot3Onu2CtcVlanTrunkList, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.59", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2008/10/15

        initProperty(utsDot3Onu2CtcReset, new SnmpMibBeanProperty(utsDot3Onu2CtcReset, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.32", ISnmpConstant.INTEGER));
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

    //public Integer getUtsDot3Onu2CtcMaxMacAddress() {
    //  return (Integer) getProperty(utsDot3Onu2CtcMaxMacAddress).getValue();
    //}

    //public void setUtsDot3Onu2CtcMaxMacAddress(Integer aUtsDot3Onu2CtcMaxMacAddress) {
    //  getProperty(utsDot3Onu2CtcMaxMacAddress).setValue(aUtsDot3Onu2CtcMaxMacAddress);
    //}

    public Integer getUtsDot3Onu2CtcVoIPPortLock() {
        return (Integer) getProperty(utsDot3Onu2CtcVoIPPortLock).getValue();
    }

    public void setUtsDot3Onu2CtcVoIPPortLock(Integer aUtsDot3Onu2CtcVoIPPortLock) {
        getProperty(utsDot3Onu2CtcVoIPPortLock).setValue(aUtsDot3Onu2CtcVoIPPortLock);
    }

    public Integer getUtsDot3Onu2CtcE1PortLock() {
        return (Integer) getProperty(utsDot3Onu2CtcE1PortLock).getValue();
    }

    public void setUtsDot3Onu2CtcE1PortLock(Integer aUtsDot3Onu2CtcE1PortLock) {
        getProperty(utsDot3Onu2CtcE1PortLock).setValue(aUtsDot3Onu2CtcE1PortLock);
    }

    public Integer getUtsDot3Onu2CtcRegisterStatus() {
        return (Integer) getProperty(utsDot3Onu2CtcRegisterStatus).getValue();
    }

    public void setUtsDot3Onu2CtcRegisterStatus(Integer aUtsDot3Onu2CtcRegisterStatus) {
        getProperty(utsDot3Onu2CtcRegisterStatus).setValue(aUtsDot3Onu2CtcRegisterStatus);
    }

    public Integer getUtsDot3Onu2CtcVlanTrunkSwitch() {
        return (Integer) getProperty(utsDot3Onu2CtcVlanTrunkSwitch).getValue();
    }

    public void setUtsDot3Onu2CtcVlanTrunkSwitch(Integer aUtsDot3Onu2CtcVlanTrunkSwitch) {
        getProperty(utsDot3Onu2CtcVlanTrunkSwitch).setValue(aUtsDot3Onu2CtcVlanTrunkSwitch);
    }

    public String getUtsDot3Onu2CtcVlanTrunkList() {
        return (String) getProperty(utsDot3Onu2CtcVlanTrunkList).getValue();
    }

    public void setUtsDot3Onu2CtcVlanTrunkList(String aUtsDot3Onu2CtcVlanTrunkList) {
        getProperty(utsDot3Onu2CtcVlanTrunkList).setValue(aUtsDot3Onu2CtcVlanTrunkList);
    }

    public Integer getUtsDot3Onu2CtcReset() {
        return (Integer) getProperty(utsDot3Onu2CtcReset).getValue();
    }

    public void setUtsDot3Onu2CtcReset(Integer aUtsDot3Onu2CtcReset3) {
        getProperty(utsDot3Onu2CtcReset).setValue(aUtsDot3Onu2CtcReset3);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcFECAbility));
        prepareRead(getProperty(utsDot3Onu2CtcFECMode));
        prepareRead(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareRead(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareRead(getProperty(utsDot3Onu2CtcAdmin));
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));
        prepareRead(getProperty(utsDot3Onu2CtcPVid));
        prepareRead(getProperty(utsDot3Onu2CtcVoIPPortLock));
        prepareRead(getProperty(utsDot3Onu2CtcE1PortLock));
        prepareRead(getProperty(utsDot3Onu2CtcVlanTrunkSwitch));
        prepareRead(getProperty(utsDot3Onu2CtcVlanTrunkList));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcFECAbility));
        prepareRead(getProperty(utsDot3Onu2CtcFECMode));
        prepareRead(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareRead(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareRead(getProperty(utsDot3Onu2CtcAdmin));
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));
        prepareRead(getProperty(utsDot3Onu2CtcPVid));
        prepareRead(getProperty(utsDot3Onu2CtcVoIPPortLock));
        prepareRead(getProperty(utsDot3Onu2CtcE1PortLock));
        prepareRead(getProperty(utsDot3Onu2CtcVlanTrunkSwitch));
        prepareRead(getProperty(utsDot3Onu2CtcVlanTrunkList));

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3Onu2CtcFECMode));
        prepareSave(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareSave(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareSave(getProperty(utsDot3Onu2CtcPVid));
        prepareSave(getProperty(utsDot3Onu2CtcAdmin));
        prepareSave(getProperty(utsDot3Onu2CtcVoIPPortLock));
        prepareSave(getProperty(utsDot3Onu2CtcE1PortLock));
        prepareSave(getProperty(utsDot3Onu2CtcVlanTrunkSwitch));
        prepareSave(getProperty(utsDot3Onu2CtcVlanTrunkList));

        return save();
    }

    public boolean resetONU() throws MibBeanException {
        setUtsDot3Onu2CtcReset(1);
        prepareSave(getProperty(utsDot3Onu2CtcReset));

        return save();
    }

}
/**
 * Created by Zhou Chao, 2008/8/21 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2CtcConfigure extends SnmpMibBean {

    public static final String utsDot3OnuCtcModuleId = "utsDot3OnuCtcModuleId";
    public static final String utsDot3OnuCtcDeviceId = "utsDot3OnuCtcDeviceId";
    public static final String utsDot3OnuCtcPortId = "utsDot3OnuCtcPortId";
    public static final String utsDot3OnuCtcLogicalPortId = "utsDot3OnuCtcLogicalPortId";

    public static final String utsDot3Onu2CtcAdmin = "utsDot3Onu2CtcAdmin";
    public static final String utsDot3OnuFECAbility = "utsDot3OnuFECAbility";
    public static final String utsDot3OnuFECMode = "utsDot3OnuFECMode";
    public static final String utsDot3Onu2CtcEncryptTraffic = "utsDot3Onu2CtcEncryptTraffic";
    public static final String utsDot3Onu2CtcPVid = "utsDot3Onu2CtcPVid";
    public static final String utsDot3Onu2CtcMaxMacAddress = "utsDot3Onu2CtcMaxMacAddress";
    public static final String utsDot3Onu2EthernetPortAlarmReversion = "utsDot3Onu2EthernetPortAlarmReversion";
    public static final String utsDot3Onu2SNumberValid = "utsDot3Onu2SNumberValid";
    public static final String utsDot3Onu2SNumberForService = "utsDot3Onu2SNumberForService";
    public static final String utsDot3Onu2dot1xUserName = "utsDot3Onu2dot1xUserName";
    public static final String utsDot3Onu2dot1xPassword = "utsDot3Onu2dot1xPassword";
    //public static final String utsDot3Onu2LoidAuthLoid = "utsDot3Onu2LoidAuthLoid";
    //public static final String utsDot3Onu2LoidAuthPassword = "utsDot3Onu2LoidAuthPassword";
    //public static final String utsDot3OnuCatvSwitch = "utsDot3OnuCatvSwitch";

    public static final String utsDot3Onu2CtcReset = "utsDot3Onu2CtcReset";

    public Dot3Onu2CtcConfigure(ISnmpProxy arg0) {
        super(arg0);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuCtcModuleId, new SnmpMibBeanProperty(utsDot3OnuCtcModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcDeviceId, new SnmpMibBeanProperty(utsDot3OnuCtcDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcPortId, new SnmpMibBeanProperty(utsDot3OnuCtcPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuCtcLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.4", ISnmpConstant.INTEGER));

        initProperty(utsDot3Onu2CtcAdmin, new SnmpMibBeanProperty(utsDot3Onu2CtcAdmin, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.37", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFECAbility, new SnmpMibBeanProperty(utsDot3OnuFECAbility, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.24", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFECMode, new SnmpMibBeanProperty(utsDot3OnuFECMode, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.25", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcEncryptTraffic, new SnmpMibBeanProperty(utsDot3Onu2CtcEncryptTraffic, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.34", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPVid, new SnmpMibBeanProperty(utsDot3Onu2CtcPVid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.39", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMaxMacAddress, new SnmpMibBeanProperty(utsDot3Onu2CtcMaxMacAddress, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.40", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2EthernetPortAlarmReversion, new SnmpMibBeanProperty(utsDot3Onu2EthernetPortAlarmReversion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.56", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2SNumberValid, new SnmpMibBeanProperty(utsDot3Onu2SNumberValid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.61", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2SNumberForService, new SnmpMibBeanProperty(utsDot3Onu2SNumberForService, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.62", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2dot1xUserName, new SnmpMibBeanProperty(utsDot3Onu2dot1xUserName, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.66", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2dot1xPassword, new SnmpMibBeanProperty(utsDot3Onu2dot1xPassword, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.68", ISnmpConstant.STRING));
        //initProperty(utsDot3Onu2LoidAuthLoid, new SnmpMibBeanProperty(utsDot3Onu2LoidAuthLoid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.71", ISnmpConstant.STRING));
        //initProperty(utsDot3Onu2LoidAuthPassword, new SnmpMibBeanProperty(utsDot3Onu2LoidAuthPassword, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.72", ISnmpConstant.STRING));
        //initProperty(utsDot3OnuCatvSwitch, new SnmpMibBeanProperty(utsDot3OnuCatvSwitch, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.101", ISnmpConstant.INTEGER));

        initProperty(utsDot3Onu2CtcReset, new SnmpMibBeanProperty(utsDot3Onu2CtcReset, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.32", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuCtcModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuCtcModuleId(Integer aUtsDot3OnuCtcModuleId) {
        setIndex(0, aUtsDot3OnuCtcModuleId);
    }

    public Integer getUtsDot3OnuCtcDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuCtcDeviceId(Integer aUtsDot3OnuCtcDeviceId) {
        setIndex(1, aUtsDot3OnuCtcDeviceId);
    }

    public Integer getUtsDot3OnuCtcPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuCtcPortId(Integer aUtsDot3OnuCtcPortId) {
        setIndex(2, aUtsDot3OnuCtcPortId);
    }

    public Integer getUtsDot3OnuCtcLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuCtcLogicalPortId(Integer aUtsDot3OnuCtcLogicalPortId) {
        setIndex(3, aUtsDot3OnuCtcLogicalPortId);
    }

    public Integer getUtsDot3Onu2CtcAdmin() {
        return (Integer) getProperty(utsDot3Onu2CtcAdmin).getValue();
    }

    public void setUtsDot3Onu2CtcAdmin(Integer aUtsDot3Onu2CtcAdmin) {
        getProperty(utsDot3Onu2CtcAdmin).setValue(aUtsDot3Onu2CtcAdmin);
    }

    public Integer getUtsDot3OnuFECAbility() {
        return (Integer) getProperty(utsDot3OnuFECAbility).getValue();
    }

    public void setUtsDot3OnuFECAbility(Integer aUtsDot3OnuFECAbility) {
        getProperty(utsDot3OnuFECAbility).setValue(aUtsDot3OnuFECAbility);
    }

    public Integer getUtsDot3OnuFECMode() {
        return (Integer) getProperty(utsDot3OnuFECMode).getValue();
    }

    public void setUtsDot3OnuFECMode(Integer aUtsDot3OnuFECMode) {
        getProperty(utsDot3OnuFECMode).setValue(aUtsDot3OnuFECMode);
    }

    public Integer getUtsDot3Onu2CtcEncryptTraffic() {
        return (Integer) getProperty(utsDot3Onu2CtcEncryptTraffic).getValue();
    }

    public void setUtsDot3Onu2CtcEncryptTraffic(Integer aUtsDot3Onu2CtcEncryptTraffic) {
        getProperty(utsDot3Onu2CtcEncryptTraffic).setValue(aUtsDot3Onu2CtcEncryptTraffic);
    }

    public Integer getUtsDot3Onu2CtcPVid() {
        return (Integer) getProperty(utsDot3Onu2CtcPVid).getValue();
    }

    public void setUtsDot3Onu2CtcPVid(Integer aUtsDot3Onu2CtcPVid) {
        getProperty(utsDot3Onu2CtcPVid).setValue(aUtsDot3Onu2CtcPVid);
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

    public Integer getUtsDot3Onu2SNumberValid() {
        return (Integer) getProperty(utsDot3Onu2SNumberValid).getValue();
    }

    public void setUtsDot3Onu2SNumberValid(Integer aUtsDot3Onu2SNumberValid) {
        getProperty(utsDot3Onu2SNumberValid).setValue(aUtsDot3Onu2SNumberValid);
    }

    public String getUtsDot3Onu2SNumberForService() {
        return (String) getProperty(utsDot3Onu2SNumberForService).getValue();
    }

    public void setUtsDot3Onu2SNumberForService(String aUtsDot3Onu2SNumberForService) {
        getProperty(utsDot3Onu2SNumberForService).setValue(aUtsDot3Onu2SNumberForService);
    }

    public String getUtsDot3Onu2dot1xUserName() {
        return (String) getProperty(utsDot3Onu2dot1xUserName).getValue();
    }

    public void setUtsDot3Onu2dot1xUserName(String aUtsDot3Onu2dot1xUserName) {
        getProperty(utsDot3Onu2dot1xUserName).setValue(aUtsDot3Onu2dot1xUserName);
    }

    public String getUtsDot3Onu2dot1xPassword() {
        return (String) getProperty(utsDot3Onu2dot1xPassword).getValue();
    }

    public void setUtsDot3Onu2dot1xPassword(String aUtsDot3Onu2dot1xPassword) {
        getProperty(utsDot3Onu2dot1xPassword).setValue(aUtsDot3Onu2dot1xPassword);
    }

    /*
    public String getUtsDot3Onu2LoidAuthLoid() {
        return (String) getProperty(utsDot3Onu2LoidAuthLoid).getValue();
    }

    public void setUtsDot3Onu2LoidAuthLoid(String aUtsDot3Onu2LoidAuthLoid) {
        getProperty(utsDot3Onu2LoidAuthLoid).setValue(aUtsDot3Onu2LoidAuthLoid);
    }

    public String getUtsDot3Onu2LoidAuthPassword() {
        return (String) getProperty(utsDot3Onu2LoidAuthPassword).getValue();
    }

    public void setUtsDot3Onu2LoidAuthPassword(String aUtsDot3Onu2LoidAuthPassword) {
        getProperty(utsDot3Onu2LoidAuthPassword).setValue(aUtsDot3Onu2LoidAuthPassword);
    }
    */

    /*
    public Integer getUtsDot3OnuCatvSwitch() {
        return (Integer) getProperty(utsDot3OnuCatvSwitch).getValue();
    }

    public void setUtsDot3OnuCatvSwitch(Integer aUtsDot3OnuCatvSwitch) {
        getProperty(utsDot3OnuCatvSwitch).setValue(aUtsDot3OnuCatvSwitch);
    }
    */

    public Integer getUtsDot3Onu2CtcReset() {
        return (Integer) getProperty(utsDot3Onu2CtcReset).getValue();
    }

    public void setUtsDot3Onu2CtcReset(Integer aUtsDot3Onu2CtcReset3) {
        getProperty(utsDot3Onu2CtcReset).setValue(aUtsDot3Onu2CtcReset3);
    }

    public boolean resetONU() throws MibBeanException {
        setUtsDot3Onu2CtcReset(new Integer(1));
        prepareSave(getProperty(utsDot3Onu2CtcReset));

        return save();
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcAdmin));
        prepareRead(getProperty(utsDot3OnuFECAbility));
        prepareRead(getProperty(utsDot3OnuFECMode));
        prepareRead(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareRead(getProperty(utsDot3Onu2CtcPVid));
        prepareRead(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareRead(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        prepareRead(getProperty(utsDot3Onu2SNumberValid));
        prepareRead(getProperty(utsDot3Onu2SNumberForService));
        prepareRead(getProperty(utsDot3Onu2dot1xUserName));
        prepareRead(getProperty(utsDot3Onu2dot1xPassword));
        //prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));
        //prepareRead(getProperty(utsDot3Onu2LoidAuthPassword));
        //prepareRead(getProperty(utsDot3OnuCatvSwitch));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcAdmin));
        prepareRead(getProperty(utsDot3OnuFECAbility));
        prepareRead(getProperty(utsDot3OnuFECMode));
        prepareRead(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareRead(getProperty(utsDot3Onu2CtcPVid));
        prepareRead(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareRead(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        prepareRead(getProperty(utsDot3Onu2SNumberValid));
        prepareRead(getProperty(utsDot3Onu2SNumberForService));
        prepareRead(getProperty(utsDot3Onu2dot1xUserName));
        prepareRead(getProperty(utsDot3Onu2dot1xPassword));
        //prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));
        //prepareRead(getProperty(utsDot3Onu2LoidAuthPassword));
        //prepareRead(getProperty(utsDot3OnuCatvSwitch));

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3Onu2CtcAdmin));
        prepareSave(getProperty(utsDot3OnuFECMode));
        prepareSave(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareSave(getProperty(utsDot3Onu2CtcPVid));
        prepareSave(getProperty(utsDot3Onu2CtcMaxMacAddress));
        prepareSave(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        prepareSave(getProperty(utsDot3Onu2SNumberValid));
        prepareSave(getProperty(utsDot3Onu2SNumberForService));
        prepareSave(getProperty(utsDot3Onu2dot1xUserName));
        prepareSave(getProperty(utsDot3Onu2dot1xPassword));
        //prepareSave(getProperty(utsDot3Onu2LoidAuthLoid));
        //prepareSave(getProperty(utsDot3Onu2LoidAuthPassword));
        //prepareSave(getProperty(utsDot3OnuCatvSwitch));

        return save();
    }

}
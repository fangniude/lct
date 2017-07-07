package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCBATDevStatusGroup  class.
 * Created by QuickDVM
 */
public class ModEoCCBATDevStatusGroup extends EocBaseSnmpMibBean {
    public static final String modEoCCBATAdminAlarmDetectionControl = "modEoCCBATAdminAlarmDetectionControl";
    public static final String modEoCCBATAdminStatus = "modEoCCBATAdminStatus";
    public static final String modEoCCBATAdminInternalTemperature = "modEoCCBATAdminInternalTemperature";
    public static final String modEoCCBATAdminTamperStatus = "modEoCCBATAdminTamperStatus";
    public static final String modEoCCBATAdminDateAndTime = "modEoCCBATAdminDateAndTime";
    public static final String modEoCCBATAdminReset = "modEoCCBATAdminReset";
    public static final String modEoCCBATAdminResetCause = "modEoCCBATAdminResetCause";
    public static final String modEoCCBATAdminConfigurationSaving = "modEoCCBATAdminConfigurationSaving";
    public static final String modEoCCBATAdminConfigurationResult = "modEoCCBATAdminConfigurationResult";

    public ModEoCCBATDevStatusGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCBATAdminAlarmDetectionControl, new SnmpMibBeanProperty(modEoCCBATAdminAlarmDetectionControl, MIB_Head1 + ".1.3.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminStatus, new SnmpMibBeanProperty(modEoCCBATAdminStatus, MIB_Head1 + ".1.3.2", ISnmpConstant.OCTETS));
        initProperty(modEoCCBATAdminInternalTemperature, new SnmpMibBeanProperty(modEoCCBATAdminInternalTemperature, MIB_Head1 + ".1.3.3", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminTamperStatus, new SnmpMibBeanProperty(modEoCCBATAdminTamperStatus, MIB_Head1 + ".1.3.4", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminDateAndTime, new SnmpMibBeanProperty(modEoCCBATAdminDateAndTime, MIB_Head1 + ".1.3.5", ISnmpConstant.OCTETS));
        initProperty(modEoCCBATAdminReset, new SnmpMibBeanProperty(modEoCCBATAdminReset, MIB_Head1 + ".1.3.6", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminResetCause, new SnmpMibBeanProperty(modEoCCBATAdminResetCause, MIB_Head1 + ".1.3.7", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminConfigurationSaving, new SnmpMibBeanProperty(modEoCCBATAdminConfigurationSaving, MIB_Head1 + ".1.3.8", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminConfigurationResult, new SnmpMibBeanProperty(modEoCCBATAdminConfigurationResult, MIB_Head1 + ".1.3.9", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCBATAdminAlarmDetectionControl() {
        return (Integer) getProperty(modEoCCBATAdminAlarmDetectionControl).getValue();
    }

    public void setModEoCCBATAdminAlarmDetectionControl(Integer aModEoCCBATAdminAlarmDetectionControl) {
        getProperty(modEoCCBATAdminAlarmDetectionControl).setValue(aModEoCCBATAdminAlarmDetectionControl);
    }

    public byte[] getModEoCCBATAdminStatus() {
        return (byte[]) getProperty(modEoCCBATAdminStatus).getValue();
    }

    public void setModEoCCBATAdminStatus(byte[] aModEoCCBATAdminStatus) {
        getProperty(modEoCCBATAdminStatus).setValue(aModEoCCBATAdminStatus);
    }

    public Integer getModEoCCBATAdminInternalTemperature() {
        return (Integer) getProperty(modEoCCBATAdminInternalTemperature).getValue();
    }

    public void setModEoCCBATAdminInternalTemperature(Integer aModEoCCBATAdminInternalTemperature) {
        getProperty(modEoCCBATAdminInternalTemperature).setValue(aModEoCCBATAdminInternalTemperature);
    }

    public Integer getModEoCCBATAdminTamperStatus() {
        return (Integer) getProperty(modEoCCBATAdminTamperStatus).getValue();
    }

    public void setModEoCCBATAdminTamperStatus(Integer aModEoCCBATAdminTamperStatus) {
        getProperty(modEoCCBATAdminTamperStatus).setValue(aModEoCCBATAdminTamperStatus);
    }

    public byte[] getModEoCCBATAdminDateAndTime() {
        return (byte[]) getProperty(modEoCCBATAdminDateAndTime).getValue();
    }

    public void setModEoCCBATAdminDateAndTime(byte[] aModEoCCBATAdminDateAndTime) {
        getProperty(modEoCCBATAdminDateAndTime).setValue(aModEoCCBATAdminDateAndTime);
    }

    public Integer getModEoCCBATAdminReset() {
        return (Integer) getProperty(modEoCCBATAdminReset).getValue();
    }

    public void setModEoCCBATAdminReset(Integer aModEoCCBATAdminReset) {
        getProperty(modEoCCBATAdminReset).setValue(aModEoCCBATAdminReset);
    }

    public Integer getModEoCCBATAdminResetCause() {
        return (Integer) getProperty(modEoCCBATAdminResetCause).getValue();
    }

    public void setModEoCCBATAdminResetCause(Integer aModEoCCBATAdminResetCause) {
        getProperty(modEoCCBATAdminResetCause).setValue(aModEoCCBATAdminResetCause);
    }

    public Integer getModEoCCBATAdminConfigurationSaving() {
        return (Integer) getProperty(modEoCCBATAdminConfigurationSaving).getValue();
    }

    public void setModEoCCBATAdminConfigurationSaving(Integer aModEoCCBATAdminConfigurationSaving) {
        getProperty(modEoCCBATAdminConfigurationSaving).setValue(aModEoCCBATAdminConfigurationSaving);
    }

    public Integer getModEoCCBATAdminConfigurationResult() {
        return (Integer) getProperty(modEoCCBATAdminConfigurationResult).getValue();
    }

    public void setModEoCCBATAdminConfigurationResult(Integer aModEoCCBATAdminConfigurationResult) {
        getProperty(modEoCCBATAdminConfigurationResult).setValue(aModEoCCBATAdminConfigurationResult);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATAdminAlarmDetectionControl));
        prepareRead(super.getProperty(modEoCCBATAdminStatus));
        prepareRead(super.getProperty(modEoCCBATAdminInternalTemperature));
        prepareRead(super.getProperty(modEoCCBATAdminTamperStatus));
        prepareRead(super.getProperty(modEoCCBATAdminDateAndTime));
        prepareRead(super.getProperty(modEoCCBATAdminReset));
        prepareRead(super.getProperty(modEoCCBATAdminResetCause));
        prepareRead(super.getProperty(modEoCCBATAdminConfigurationSaving));
        prepareRead(super.getProperty(modEoCCBATAdminConfigurationResult));

        return load();
    }

    public boolean resetCBat() throws MibBeanException {
        setModEoCCBATAdminReset(1);
        prepareSave(getProperty(modEoCCBATAdminReset));

        return save();
    }

    public boolean saveConfig() throws MibBeanException {

        setModEoCCBATAdminConfigurationSaving(1);
        prepareSave(getProperty(modEoCCBATAdminConfigurationSaving));

        return save();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCBATAdminAlarmDetectionControl));
        prepareSave(getProperty(modEoCCBATAdminDateAndTime));
        //prepareSave(getProperty(modEoCCBATAdminReset));
        //prepareSave(getProperty(modEoCCBATAdminConfigurationSaving));

        return save();
    }


}

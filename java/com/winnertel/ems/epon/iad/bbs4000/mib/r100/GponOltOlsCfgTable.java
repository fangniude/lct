package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

/**
 * @author Yang Yizai , 2009-3-9
 */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The GponOltOlsCfgTable class.
 * Created by QuickDVM
 */
public class GponOltOlsCfgTable extends SnmpMibBean {
    public static final String oltOlsCfgSlotNo = "oltOlsCfgSlotNo";
    public static final String oltOlsCfgPortNo = "oltOlsCfgPortNo";
    public static final String oltOlsTemperature = "oltOlsTemperature";
    public static final String oltOlsVoltage = "oltOlsVoltage";
    public static final String oltOlsBiasCurrent = "oltOlsBiasCurrent";
    public static final String oltOlsTxPower = "oltOlsTxPower";
    public static final String oltOlsTempThresholdAlarmHi = "oltOlsTempThresholdAlarmHi";
    public static final String oltOlsTempThresholdAlarmLo = "oltOlsTempThresholdAlarmLo";
    public static final String oltOlsVoltageThresholdAlarmHi = "oltOlsVoltageThresholdAlarmHi";
    public static final String oltOlsVoltageThresholdAlarmLo = "oltOlsVoltageThresholdAlarmLo";
    public static final String oltOlsBiasCurrentThresholdAlarmHi = "oltOlsBiasCurrentThresholdAlarmHi";
    public static final String oltOlsBiasCurrentThresholdAlarmLo = "oltOlsBiasCurrentThresholdAlarmLo";
    public static final String oltOlsTxPowerThresholdAlarmHi = "oltOlsTxPowerThresholdAlarmHi";
    public static final String oltOlsTxPowerThresholdAlarmLo = "oltOlsTxPowerThresholdAlarmLo";
    public static final String oltOlsTempThresholdWarningHi = "oltOlsTempThresholdWarningHi";
    public static final String oltOlsTempThresholdWarningLo = "oltOlsTempThresholdWarningLo";
    public static final String oltOlsVoltageThresholdWarningHi = "oltOlsVoltageThresholdWarningHi";
    public static final String oltOlsVoltageThresholdWarningLo = "oltOlsVoltageThresholdWarningLo";
    public static final String oltOlsBiasCurrentThresholdWarningHi = "oltOlsBiasCurrentThresholdWarningHi";
    public static final String oltOlsBiasCurrentThresholdWarningLo = "oltOlsBiasCurrentThresholdWarningLo";
    public static final String oltOlsTxPowerThresholdWarningHi = "oltOlsTxPowerThresholdWarningHi";
    public static final String oltOlsTxPowerThresholdWarningLo = "oltOlsTxPowerThresholdWarningLo";

    public GponOltOlsCfgTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltOlsCfgSlotNo, new SnmpMibBeanProperty(oltOlsCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.1",
                ISnmpConstant.INTEGER));
        initProperty(oltOlsCfgPortNo, new SnmpMibBeanProperty(oltOlsCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.2",
                ISnmpConstant.INTEGER));
        initProperty(oltOlsTemperature, new SnmpMibBeanProperty(oltOlsTemperature,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.11", ISnmpConstant.INTEGER));
        initProperty(oltOlsVoltage, new SnmpMibBeanProperty(oltOlsVoltage, ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.12",
                ISnmpConstant.INTEGER));
        initProperty(oltOlsBiasCurrent, new SnmpMibBeanProperty(oltOlsBiasCurrent,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.13", ISnmpConstant.INTEGER));
        initProperty(oltOlsTxPower, new SnmpMibBeanProperty(oltOlsTxPower, ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.14",
                ISnmpConstant.INTEGER));
        initProperty(oltOlsTempThresholdAlarmHi, new SnmpMibBeanProperty(oltOlsTempThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.16", ISnmpConstant.INTEGER));
        initProperty(oltOlsTempThresholdAlarmLo, new SnmpMibBeanProperty(oltOlsTempThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.17", ISnmpConstant.INTEGER));
        initProperty(oltOlsVoltageThresholdAlarmHi, new SnmpMibBeanProperty(oltOlsVoltageThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.18", ISnmpConstant.INTEGER));
        initProperty(oltOlsVoltageThresholdAlarmLo, new SnmpMibBeanProperty(oltOlsVoltageThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.19", ISnmpConstant.INTEGER));
        initProperty(oltOlsBiasCurrentThresholdAlarmHi, new SnmpMibBeanProperty(oltOlsBiasCurrentThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.20", ISnmpConstant.INTEGER));
        initProperty(oltOlsBiasCurrentThresholdAlarmLo, new SnmpMibBeanProperty(oltOlsBiasCurrentThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.21", ISnmpConstant.INTEGER));
        initProperty(oltOlsTxPowerThresholdAlarmHi, new SnmpMibBeanProperty(oltOlsTxPowerThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.22", ISnmpConstant.INTEGER));
        initProperty(oltOlsTxPowerThresholdAlarmLo, new SnmpMibBeanProperty(oltOlsTxPowerThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.23", ISnmpConstant.INTEGER));
        initProperty(oltOlsTempThresholdWarningHi, new SnmpMibBeanProperty(oltOlsTempThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.26", ISnmpConstant.INTEGER));
        initProperty(oltOlsTempThresholdWarningLo, new SnmpMibBeanProperty(oltOlsTempThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.27", ISnmpConstant.INTEGER));
        initProperty(oltOlsVoltageThresholdWarningHi, new SnmpMibBeanProperty(oltOlsVoltageThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.28", ISnmpConstant.INTEGER));
        initProperty(oltOlsVoltageThresholdWarningLo, new SnmpMibBeanProperty(oltOlsVoltageThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.29", ISnmpConstant.INTEGER));
        initProperty(oltOlsBiasCurrentThresholdWarningHi, new SnmpMibBeanProperty(oltOlsBiasCurrentThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.30", ISnmpConstant.INTEGER));
        initProperty(oltOlsBiasCurrentThresholdWarningLo, new SnmpMibBeanProperty(oltOlsBiasCurrentThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.31", ISnmpConstant.INTEGER));
        initProperty(oltOlsTxPowerThresholdWarningHi, new SnmpMibBeanProperty(oltOlsTxPowerThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.32", ISnmpConstant.INTEGER));
        initProperty(oltOlsTxPowerThresholdWarningLo, new SnmpMibBeanProperty(oltOlsTxPowerThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.11.1.33", ISnmpConstant.INTEGER));

    }

    public Integer getOltOlsCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOltOlsCfgSlotNo(Integer aOltOlsCfgSlotNo) {
        setIndex(0, aOltOlsCfgSlotNo);
    }

    public Integer getOltOlsCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOltOlsCfgPortNo(Integer aOltOlsCfgPortNo) {
        setIndex(1, aOltOlsCfgPortNo);
    }

    public Integer getOltOlsTemperature() {
        return (Integer) getProperty(oltOlsTemperature).getValue();
    }

    public void setOltOlsTemperature(Integer aOltOlsTemperature) {
        getProperty(oltOlsTemperature).setValue(aOltOlsTemperature);
    }

    public Integer getOltOlsVoltage() {
        return (Integer) getProperty(oltOlsVoltage).getValue();
    }

    public void setOltOlsVoltage(Integer aOltOlsVoltage) {
        getProperty(oltOlsVoltage).setValue(aOltOlsVoltage);
    }

    public Integer getOltOlsBiasCurrent() {
        return (Integer) getProperty(oltOlsBiasCurrent).getValue();
    }

    public void setOltOlsBiasCurrent(Integer aOltOlsBiasCurrent) {
        getProperty(oltOlsBiasCurrent).setValue(aOltOlsBiasCurrent);
    }

    public Integer getOltOlsTxPower() {
        return (Integer) getProperty(oltOlsTxPower).getValue();
    }

    public void setOltOlsTxPower(Integer aOltOlsTxPower) {
        getProperty(oltOlsTxPower).setValue(aOltOlsTxPower);
    }

    public Integer getOltOlsTempThresholdAlarmHi() {
        return (Integer) getProperty(oltOlsTempThresholdAlarmHi).getValue();
    }

    public void setOltOlsTempThresholdAlarmHi(Integer aOltOlsTempThresholdAlarmHi) {
        getProperty(oltOlsTempThresholdAlarmHi).setValue(aOltOlsTempThresholdAlarmHi);
    }

    public Integer getOltOlsTempThresholdAlarmLo() {
        return (Integer) getProperty(oltOlsTempThresholdAlarmLo).getValue();
    }

    public void setOltOlsTempThresholdAlarmLo(Integer aOltOlsTempThresholdAlarmLo) {
        getProperty(oltOlsTempThresholdAlarmLo).setValue(aOltOlsTempThresholdAlarmLo);
    }

    public Integer getOltOlsVoltageThresholdAlarmHi() {
        return (Integer) getProperty(oltOlsVoltageThresholdAlarmHi).getValue();
    }

    public void setOltOlsVoltageThresholdAlarmHi(Integer aOltOlsVoltageThresholdAlarmHi) {
        getProperty(oltOlsVoltageThresholdAlarmHi).setValue(aOltOlsVoltageThresholdAlarmHi);
    }

    public Integer getOltOlsVoltageThresholdAlarmLo() {
        return (Integer) getProperty(oltOlsVoltageThresholdAlarmLo).getValue();
    }

    public void setOltOlsVoltageThresholdAlarmLo(Integer aOltOlsVoltageThresholdAlarmLo) {
        getProperty(oltOlsVoltageThresholdAlarmLo).setValue(aOltOlsVoltageThresholdAlarmLo);
    }

    public Integer getOltOlsBiasCurrentThresholdAlarmHi() {
        return (Integer) getProperty(oltOlsBiasCurrentThresholdAlarmHi).getValue();
    }

    public void setOltOlsBiasCurrentThresholdAlarmHi(Integer aOltOlsBiasCurrentThresholdAlarmHi) {
        getProperty(oltOlsBiasCurrentThresholdAlarmHi).setValue(aOltOlsBiasCurrentThresholdAlarmHi);
    }

    public Integer getOltOlsBiasCurrentThresholdAlarmLo() {
        return (Integer) getProperty(oltOlsBiasCurrentThresholdAlarmLo).getValue();
    }

    public void setOltOlsBiasCurrentThresholdAlarmLo(Integer aOltOlsBiasCurrentThresholdAlarmLo) {
        getProperty(oltOlsBiasCurrentThresholdAlarmLo).setValue(aOltOlsBiasCurrentThresholdAlarmLo);
    }

    public Integer getOltOlsTxPowerThresholdAlarmHi() {
        return (Integer) getProperty(oltOlsTxPowerThresholdAlarmHi).getValue();
    }

    public void setOltOlsTxPowerThresholdAlarmHi(Integer aOltOlsTxPowerThresholdAlarmHi) {
        getProperty(oltOlsTxPowerThresholdAlarmHi).setValue(aOltOlsTxPowerThresholdAlarmHi);
    }

    public Integer getOltOlsTxPowerThresholdAlarmLo() {
        return (Integer) getProperty(oltOlsTxPowerThresholdAlarmLo).getValue();
    }

    public void setOltOlsTxPowerThresholdAlarmLo(Integer aOltOlsTxPowerThresholdAlarmLo) {
        getProperty(oltOlsTxPowerThresholdAlarmLo).setValue(aOltOlsTxPowerThresholdAlarmLo);
    }

    public Integer getOltOlsTempThresholdWarningHi() {
        return (Integer) getProperty(oltOlsTempThresholdWarningHi).getValue();
    }

    public void setOltOlsTempThresholdWarningHi(Integer aOltOlsTempThresholdWarningHi) {
        getProperty(oltOlsTempThresholdWarningHi).setValue(aOltOlsTempThresholdWarningHi);
    }

    public Integer getOltOlsTempThresholdWarningLo() {
        return (Integer) getProperty(oltOlsTempThresholdWarningLo).getValue();
    }

    public void setOltOlsTempThresholdWarningLo(Integer aOltOlsTempThresholdWarningLo) {
        getProperty(oltOlsTempThresholdWarningLo).setValue(aOltOlsTempThresholdWarningLo);
    }

    public Integer getOltOlsVoltageThresholdWarningHi() {
        return (Integer) getProperty(oltOlsVoltageThresholdWarningHi).getValue();
    }

    public void setOltOlsVoltageThresholdWarningHi(Integer aOltOlsVoltageThresholdWarningHi) {
        getProperty(oltOlsVoltageThresholdWarningHi).setValue(aOltOlsVoltageThresholdWarningHi);
    }

    public Integer getOltOlsVoltageThresholdWarningLo() {
        return (Integer) getProperty(oltOlsVoltageThresholdWarningLo).getValue();
    }

    public void setOltOlsVoltageThresholdWarningLo(Integer aOltOlsVoltageThresholdWarningLo) {
        getProperty(oltOlsVoltageThresholdWarningLo).setValue(aOltOlsVoltageThresholdWarningLo);
    }

    public Integer getOltOlsBiasCurrentThresholdWarningHi() {
        return (Integer) getProperty(oltOlsBiasCurrentThresholdWarningHi).getValue();
    }

    public void setOltOlsBiasCurrentThresholdWarningHi(Integer aOltOlsBiasCurrentThresholdWarningHi) {
        getProperty(oltOlsBiasCurrentThresholdWarningHi).setValue(aOltOlsBiasCurrentThresholdWarningHi);
    }

    public Integer getOltOlsBiasCurrentThresholdWarningLo() {
        return (Integer) getProperty(oltOlsBiasCurrentThresholdWarningLo).getValue();
    }

    public void setOltOlsBiasCurrentThresholdWarningLo(Integer aOltOlsBiasCurrentThresholdWarningLo) {
        getProperty(oltOlsBiasCurrentThresholdWarningLo).setValue(aOltOlsBiasCurrentThresholdWarningLo);
    }

    public Integer getOltOlsTxPowerThresholdWarningHi() {
        return (Integer) getProperty(oltOlsTxPowerThresholdWarningHi).getValue();
    }

    public void setOltOlsTxPowerThresholdWarningHi(Integer aOltOlsTxPowerThresholdWarningHi) {
        getProperty(oltOlsTxPowerThresholdWarningHi).setValue(aOltOlsTxPowerThresholdWarningHi);
    }

    public Integer getOltOlsTxPowerThresholdWarningLo() {
        return (Integer) getProperty(oltOlsTxPowerThresholdWarningLo).getValue();
    }

    public void setOltOlsTxPowerThresholdWarningLo(Integer aOltOlsTxPowerThresholdWarningLo) {
        getProperty(oltOlsTxPowerThresholdWarningLo).setValue(aOltOlsTxPowerThresholdWarningLo);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(oltOlsTemperature));
        prepareRead(super.getProperty(oltOlsVoltage));
        prepareRead(super.getProperty(oltOlsBiasCurrent));
        prepareRead(super.getProperty(oltOlsTxPower));
        prepareRead(super.getProperty(oltOlsTempThresholdAlarmHi));
        prepareRead(super.getProperty(oltOlsTempThresholdAlarmLo));
        prepareRead(super.getProperty(oltOlsVoltageThresholdAlarmHi));
        prepareRead(super.getProperty(oltOlsVoltageThresholdAlarmLo));
        prepareRead(super.getProperty(oltOlsBiasCurrentThresholdAlarmHi));
        prepareRead(super.getProperty(oltOlsBiasCurrentThresholdAlarmLo));
        prepareRead(super.getProperty(oltOlsTxPowerThresholdAlarmHi));
        prepareRead(super.getProperty(oltOlsTxPowerThresholdAlarmLo));
        prepareRead(super.getProperty(oltOlsTempThresholdWarningHi));
        prepareRead(super.getProperty(oltOlsTempThresholdWarningLo));
        prepareRead(super.getProperty(oltOlsVoltageThresholdWarningHi));
        prepareRead(super.getProperty(oltOlsVoltageThresholdWarningLo));
        prepareRead(super.getProperty(oltOlsBiasCurrentThresholdWarningHi));
        prepareRead(super.getProperty(oltOlsBiasCurrentThresholdWarningLo));
        prepareRead(super.getProperty(oltOlsTxPowerThresholdWarningHi));
        prepareRead(super.getProperty(oltOlsTxPowerThresholdWarningLo));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(oltOlsTempThresholdAlarmHi));
        prepareSave(getProperty(oltOlsTempThresholdAlarmLo));
        prepareSave(getProperty(oltOlsVoltageThresholdAlarmHi));
        prepareSave(getProperty(oltOlsVoltageThresholdAlarmLo));
        prepareSave(getProperty(oltOlsBiasCurrentThresholdAlarmHi));
        prepareSave(getProperty(oltOlsBiasCurrentThresholdAlarmLo));
        prepareSave(getProperty(oltOlsTxPowerThresholdAlarmHi));
        prepareSave(getProperty(oltOlsTxPowerThresholdAlarmLo));
        prepareSave(getProperty(oltOlsTempThresholdWarningHi));
        prepareSave(getProperty(oltOlsTempThresholdWarningLo));
        prepareSave(getProperty(oltOlsVoltageThresholdWarningHi));
        prepareSave(getProperty(oltOlsVoltageThresholdWarningLo));
        prepareSave(getProperty(oltOlsBiasCurrentThresholdWarningHi));
        prepareSave(getProperty(oltOlsBiasCurrentThresholdWarningLo));
        prepareSave(getProperty(oltOlsTxPowerThresholdWarningHi));
        prepareSave(getProperty(oltOlsTxPowerThresholdWarningLo));

        return save();
    }

}

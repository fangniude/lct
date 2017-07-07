package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

/**
 * @author Yang Yizai , 2009-3-9
 */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The GponOnuOlsCfgTable class.
 * Created by QuickDVM
 */
public class GponOnuOlsCfgTable extends SnmpMibBean {
    public static final String onuOlsCfgSlotNo = "onuOlsCfgSlotNo";
    public static final String onuOlsCfgPortNo = "onuOlsCfgPortNo";
    public static final String onuOlsCfgLogicalPortNo = "onuOlsCfgLogicalPortNo";
    public static final String onuOlsTemperature = "onuOlsTemperature";
    public static final String onuOlsVoltage = "onuOlsVoltage";
    public static final String onuOlsBiasCurrent = "onuOlsBiasCurrent";
    public static final String onuOlsTxPower = "onuOlsTxPower";
    public static final String onuOlsRxPower = "onuOlsRxPower";
    public static final String onuOlsTempThresholdAlarmHi = "onuOlsTempThresholdAlarmHi";
    public static final String onuOlsTempThresholdAlarmLo = "onuOlsTempThresholdAlarmLo";
    public static final String onuOlsVoltageThresholdAlarmHi = "onuOlsVoltageThresholdAlarmHi";
    public static final String onuOlsVoltageThresholdAlarmLo = "onuOlsVoltageThresholdAlarmLo";
    public static final String onuOlsBiasCurrentThresholdAlarmHi = "onuOlsBiasCurrentThresholdAlarmHi";
    public static final String onuOlsBiasCurrentThresholdAlarmLo = "onuOlsBiasCurrentThresholdAlarmLo";
    public static final String onuOlsTxPowerThresholdAlarmHi = "onuOlsTxPowerThresholdAlarmHi";
    public static final String onuOlsTxPowerThresholdAlarmLo = "onuOlsTxPowerThresholdAlarmLo";
    public static final String onuOlsRxPowerThresholdAlarmHi = "onuOlsRxPowerThresholdAlarmHi";
    public static final String onuOlsRxPowerThresholdAlarmLo = "onuOlsRxPowerThresholdAlarmLo";
    public static final String onuOlsTempThresholdWarningHi = "onuOlsTempThresholdWarningHi";
    public static final String onuOlsTempThresholdWarningLo = "onuOlsTempThresholdWarningLo";
    public static final String onuOlsVoltageThresholdWarningHi = "onuOlsVoltageThresholdWarningHi";
    public static final String onuOlsVoltageThresholdWarningLo = "onuOlsVoltageThresholdWarningLo";
    public static final String onuOlsBiasCurrentThresholdWarningHi = "onuOlsBiasCurrentThresholdWarningHi";
    public static final String onuOlsBiasCurrentThresholdWarningLo = "onuOlsBiasCurrentThresholdWarningLo";
    public static final String onuOlsTxPowerThresholdWarningHi = "onuOlsTxPowerThresholdWarningHi";
    public static final String onuOlsTxPowerThresholdWarningLo = "onuOlsTxPowerThresholdWarningLo";
    public static final String onuOlsRxPowerThresholdWarningHi = "onuOlsRxPowerThresholdWarningHi";
    public static final String onuOlsRxPowerThresholdWarningLo = "onuOlsRxPowerThresholdWarningLo";
    public static final String onuOlsEnable = "onuOlsEnable";

    public GponOnuOlsCfgTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuOlsCfgSlotNo, new SnmpMibBeanProperty(onuOlsCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.1",
                ISnmpConstant.INTEGER));
        initProperty(onuOlsCfgPortNo, new SnmpMibBeanProperty(onuOlsCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.2",
                ISnmpConstant.INTEGER));
        initProperty(onuOlsCfgLogicalPortNo, new SnmpMibBeanProperty(onuOlsCfgLogicalPortNo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.3", ISnmpConstant.INTEGER));
        initProperty(onuOlsTemperature, new SnmpMibBeanProperty(onuOlsTemperature,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.11", ISnmpConstant.INTEGER));
        initProperty(onuOlsVoltage, new SnmpMibBeanProperty(onuOlsVoltage, ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.12",
                ISnmpConstant.INTEGER));
        initProperty(onuOlsBiasCurrent, new SnmpMibBeanProperty(onuOlsBiasCurrent,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.13", ISnmpConstant.INTEGER));
        initProperty(onuOlsTxPower, new SnmpMibBeanProperty(onuOlsTxPower, ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.14",
                ISnmpConstant.INTEGER));
        initProperty(onuOlsRxPower, new SnmpMibBeanProperty(onuOlsRxPower, ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.15",
                ISnmpConstant.INTEGER));
        initProperty(onuOlsTempThresholdAlarmHi, new SnmpMibBeanProperty(onuOlsTempThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.16", ISnmpConstant.INTEGER));
        initProperty(onuOlsTempThresholdAlarmLo, new SnmpMibBeanProperty(onuOlsTempThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.17", ISnmpConstant.INTEGER));
        initProperty(onuOlsVoltageThresholdAlarmHi, new SnmpMibBeanProperty(onuOlsVoltageThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.18", ISnmpConstant.INTEGER));
        initProperty(onuOlsVoltageThresholdAlarmLo, new SnmpMibBeanProperty(onuOlsVoltageThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.19", ISnmpConstant.INTEGER));
        initProperty(onuOlsBiasCurrentThresholdAlarmHi, new SnmpMibBeanProperty(onuOlsBiasCurrentThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.20", ISnmpConstant.INTEGER));
        initProperty(onuOlsBiasCurrentThresholdAlarmLo, new SnmpMibBeanProperty(onuOlsBiasCurrentThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.21", ISnmpConstant.INTEGER));
        initProperty(onuOlsTxPowerThresholdAlarmHi, new SnmpMibBeanProperty(onuOlsTxPowerThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.22", ISnmpConstant.INTEGER));
        initProperty(onuOlsTxPowerThresholdAlarmLo, new SnmpMibBeanProperty(onuOlsTxPowerThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.23", ISnmpConstant.INTEGER));
        initProperty(onuOlsRxPowerThresholdAlarmHi, new SnmpMibBeanProperty(onuOlsRxPowerThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.24", ISnmpConstant.INTEGER));
        initProperty(onuOlsRxPowerThresholdAlarmLo, new SnmpMibBeanProperty(onuOlsRxPowerThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.25", ISnmpConstant.INTEGER));
        initProperty(onuOlsTempThresholdWarningHi, new SnmpMibBeanProperty(onuOlsTempThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.26", ISnmpConstant.INTEGER));
        initProperty(onuOlsTempThresholdWarningLo, new SnmpMibBeanProperty(onuOlsTempThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.27", ISnmpConstant.INTEGER));
        initProperty(onuOlsVoltageThresholdWarningHi, new SnmpMibBeanProperty(onuOlsVoltageThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.28", ISnmpConstant.INTEGER));
        initProperty(onuOlsVoltageThresholdWarningLo, new SnmpMibBeanProperty(onuOlsVoltageThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.29", ISnmpConstant.INTEGER));
        initProperty(onuOlsBiasCurrentThresholdWarningHi, new SnmpMibBeanProperty(onuOlsBiasCurrentThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.30", ISnmpConstant.INTEGER));
        initProperty(onuOlsBiasCurrentThresholdWarningLo, new SnmpMibBeanProperty(onuOlsBiasCurrentThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.31", ISnmpConstant.INTEGER));
        initProperty(onuOlsTxPowerThresholdWarningHi, new SnmpMibBeanProperty(onuOlsTxPowerThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.32", ISnmpConstant.INTEGER));
        initProperty(onuOlsTxPowerThresholdWarningLo, new SnmpMibBeanProperty(onuOlsTxPowerThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.33", ISnmpConstant.INTEGER));
        initProperty(onuOlsRxPowerThresholdWarningHi, new SnmpMibBeanProperty(onuOlsRxPowerThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.34", ISnmpConstant.INTEGER));
        initProperty(onuOlsRxPowerThresholdWarningLo, new SnmpMibBeanProperty(onuOlsRxPowerThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.35", ISnmpConstant.INTEGER));
        initProperty(onuOlsEnable, new SnmpMibBeanProperty(onuOlsEnable, ".1.3.6.1.4.1.41355.1.3.10.5.1.13.1.99",
                ISnmpConstant.INTEGER));

    }

    public Integer getOnuOlsCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuOlsCfgSlotNo(Integer aOnuOlsCfgSlotNo) {
        setIndex(0, aOnuOlsCfgSlotNo);
    }

    public Integer getOnuOlsCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuOlsCfgPortNo(Integer aOnuOlsCfgPortNo) {
        setIndex(1, aOnuOlsCfgPortNo);
    }

    public Integer getOnuOlsCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuOlsCfgLogicalPortNo(Integer aOnuOlsCfgLogicalPortNo) {
        setIndex(2, aOnuOlsCfgLogicalPortNo);
    }

    public Integer getOnuOlsTemperature() {
        return (Integer) getProperty(onuOlsTemperature).getValue();
    }

    public void setOnuOlsTemperature(Integer aOnuOlsTemperature) {
        getProperty(onuOlsTemperature).setValue(aOnuOlsTemperature);
    }

    public Integer getOnuOlsVoltage() {
        return (Integer) getProperty(onuOlsVoltage).getValue();
    }

    public void setOnuOlsVoltage(Integer aOnuOlsVoltage) {
        getProperty(onuOlsVoltage).setValue(aOnuOlsVoltage);
    }

    public Integer getOnuOlsBiasCurrent() {
        return (Integer) getProperty(onuOlsBiasCurrent).getValue();
    }

    public void setOnuOlsBiasCurrent(Integer aOnuOlsBiasCurrent) {
        getProperty(onuOlsBiasCurrent).setValue(aOnuOlsBiasCurrent);
    }

    public Integer getOnuOlsTxPower() {
        return (Integer) getProperty(onuOlsTxPower).getValue();
    }

    public void setOnuOlsTxPower(Integer aOnuOlsTxPower) {
        getProperty(onuOlsTxPower).setValue(aOnuOlsTxPower);
    }

    public Integer getOnuOlsRxPower() {
        return (Integer) getProperty(onuOlsRxPower).getValue();
    }

    public void setOnuOlsRxPower(Integer aOnuOlsRxPower) {
        getProperty(onuOlsRxPower).setValue(aOnuOlsRxPower);
    }

    public Integer getOnuOlsTempThresholdAlarmHi() {
        return (Integer) getProperty(onuOlsTempThresholdAlarmHi).getValue();
    }

    public void setOnuOlsTempThresholdAlarmHi(Integer aOnuOlsTempThresholdAlarmHi) {
        getProperty(onuOlsTempThresholdAlarmHi).setValue(aOnuOlsTempThresholdAlarmHi);
    }

    public Integer getOnuOlsTempThresholdAlarmLo() {
        return (Integer) getProperty(onuOlsTempThresholdAlarmLo).getValue();
    }

    public void setOnuOlsTempThresholdAlarmLo(Integer aOnuOlsTempThresholdAlarmLo) {
        getProperty(onuOlsTempThresholdAlarmLo).setValue(aOnuOlsTempThresholdAlarmLo);
    }

    public Integer getOnuOlsVoltageThresholdAlarmHi() {
        return (Integer) getProperty(onuOlsVoltageThresholdAlarmHi).getValue();
    }

    public void setOnuOlsVoltageThresholdAlarmHi(Integer aOnuOlsVoltageThresholdAlarmHi) {
        getProperty(onuOlsVoltageThresholdAlarmHi).setValue(aOnuOlsVoltageThresholdAlarmHi);
    }

    public Integer getOnuOlsVoltageThresholdAlarmLo() {
        return (Integer) getProperty(onuOlsVoltageThresholdAlarmLo).getValue();
    }

    public void setOnuOlsVoltageThresholdAlarmLo(Integer aOnuOlsVoltageThresholdAlarmLo) {
        getProperty(onuOlsVoltageThresholdAlarmLo).setValue(aOnuOlsVoltageThresholdAlarmLo);
    }

    public Integer getOnuOlsBiasCurrentThresholdAlarmHi() {
        return (Integer) getProperty(onuOlsBiasCurrentThresholdAlarmHi).getValue();
    }

    public void setOnuOlsBiasCurrentThresholdAlarmHi(Integer aOnuOlsBiasCurrentThresholdAlarmHi) {
        getProperty(onuOlsBiasCurrentThresholdAlarmHi).setValue(aOnuOlsBiasCurrentThresholdAlarmHi);
    }

    public Integer getOnuOlsBiasCurrentThresholdAlarmLo() {
        return (Integer) getProperty(onuOlsBiasCurrentThresholdAlarmLo).getValue();
    }

    public void setOnuOlsBiasCurrentThresholdAlarmLo(Integer aOnuOlsBiasCurrentThresholdAlarmLo) {
        getProperty(onuOlsBiasCurrentThresholdAlarmLo).setValue(aOnuOlsBiasCurrentThresholdAlarmLo);
    }

    public Integer getOnuOlsTxPowerThresholdAlarmHi() {
        return (Integer) getProperty(onuOlsTxPowerThresholdAlarmHi).getValue();
    }

    public void setOnuOlsTxPowerThresholdAlarmHi(Integer aOnuOlsTxPowerThresholdAlarmHi) {
        getProperty(onuOlsTxPowerThresholdAlarmHi).setValue(aOnuOlsTxPowerThresholdAlarmHi);
    }

    public Integer getOnuOlsTxPowerThresholdAlarmLo() {
        return (Integer) getProperty(onuOlsTxPowerThresholdAlarmLo).getValue();
    }

    public void setOnuOlsTxPowerThresholdAlarmLo(Integer aOnuOlsTxPowerThresholdAlarmLo) {
        getProperty(onuOlsTxPowerThresholdAlarmLo).setValue(aOnuOlsTxPowerThresholdAlarmLo);
    }

    public Integer getOnuOlsRxPowerThresholdAlarmHi() {
        return (Integer) getProperty(onuOlsRxPowerThresholdAlarmHi).getValue();
    }

    public void setOnuOlsRxPowerThresholdAlarmHi(Integer aOnuOlsRxPowerThresholdAlarmHi) {
        getProperty(onuOlsRxPowerThresholdAlarmHi).setValue(aOnuOlsRxPowerThresholdAlarmHi);
    }

    public Integer getOnuOlsRxPowerThresholdAlarmLo() {
        return (Integer) getProperty(onuOlsRxPowerThresholdAlarmLo).getValue();
    }

    public void setOnuOlsRxPowerThresholdAlarmLo(Integer aOnuOlsRxPowerThresholdAlarmLo) {
        getProperty(onuOlsRxPowerThresholdAlarmLo).setValue(aOnuOlsRxPowerThresholdAlarmLo);
    }

    public Integer getOnuOlsTempThresholdWarningHi() {
        return (Integer) getProperty(onuOlsTempThresholdWarningHi).getValue();
    }

    public void setOnuOlsTempThresholdWarningHi(Integer aOnuOlsTempThresholdWarningHi) {
        getProperty(onuOlsTempThresholdWarningHi).setValue(aOnuOlsTempThresholdWarningHi);
    }

    public Integer getOnuOlsTempThresholdWarningLo() {
        return (Integer) getProperty(onuOlsTempThresholdWarningLo).getValue();
    }

    public void setOnuOlsTempThresholdWarningLo(Integer aOnuOlsTempThresholdWarningLo) {
        getProperty(onuOlsTempThresholdWarningLo).setValue(aOnuOlsTempThresholdWarningLo);
    }

    public Integer getOnuOlsVoltageThresholdWarningHi() {
        return (Integer) getProperty(onuOlsVoltageThresholdWarningHi).getValue();
    }

    public void setOnuOlsVoltageThresholdWarningHi(Integer aOnuOlsVoltageThresholdWarningHi) {
        getProperty(onuOlsVoltageThresholdWarningHi).setValue(aOnuOlsVoltageThresholdWarningHi);
    }

    public Integer getOnuOlsVoltageThresholdWarningLo() {
        return (Integer) getProperty(onuOlsVoltageThresholdWarningLo).getValue();
    }

    public void setOnuOlsVoltageThresholdWarningLo(Integer aOnuOlsVoltageThresholdWarningLo) {
        getProperty(onuOlsVoltageThresholdWarningLo).setValue(aOnuOlsVoltageThresholdWarningLo);
    }

    public Integer getOnuOlsBiasCurrentThresholdWarningHi() {
        return (Integer) getProperty(onuOlsBiasCurrentThresholdWarningHi).getValue();
    }

    public void setOnuOlsBiasCurrentThresholdWarningHi(Integer aOnuOlsBiasCurrentThresholdWarningHi) {
        getProperty(onuOlsBiasCurrentThresholdWarningHi).setValue(aOnuOlsBiasCurrentThresholdWarningHi);
    }

    public Integer getOnuOlsBiasCurrentThresholdWarningLo() {
        return (Integer) getProperty(onuOlsBiasCurrentThresholdWarningLo).getValue();
    }

    public void setOnuOlsBiasCurrentThresholdWarningLo(Integer aOnuOlsBiasCurrentThresholdWarningLo) {
        getProperty(onuOlsBiasCurrentThresholdWarningLo).setValue(aOnuOlsBiasCurrentThresholdWarningLo);
    }

    public Integer getOnuOlsTxPowerThresholdWarningHi() {
        return (Integer) getProperty(onuOlsTxPowerThresholdWarningHi).getValue();
    }

    public void setOnuOlsTxPowerThresholdWarningHi(Integer aOnuOlsTxPowerThresholdWarningHi) {
        getProperty(onuOlsTxPowerThresholdWarningHi).setValue(aOnuOlsTxPowerThresholdWarningHi);
    }

    public Integer getOnuOlsTxPowerThresholdWarningLo() {
        return (Integer) getProperty(onuOlsTxPowerThresholdWarningLo).getValue();
    }

    public void setOnuOlsTxPowerThresholdWarningLo(Integer aOnuOlsTxPowerThresholdWarningLo) {
        getProperty(onuOlsTxPowerThresholdWarningLo).setValue(aOnuOlsTxPowerThresholdWarningLo);
    }

    public Integer getOnuOlsRxPowerThresholdWarningHi() {
        return (Integer) getProperty(onuOlsRxPowerThresholdWarningHi).getValue();
    }

    public void setOnuOlsRxPowerThresholdWarningHi(Integer aOnuOlsRxPowerThresholdWarningHi) {
        getProperty(onuOlsRxPowerThresholdWarningHi).setValue(aOnuOlsRxPowerThresholdWarningHi);
    }

    public Integer getOnuOlsRxPowerThresholdWarningLo() {
        return (Integer) getProperty(onuOlsRxPowerThresholdWarningLo).getValue();
    }

    public void setOnuOlsRxPowerThresholdWarningLo(Integer aOnuOlsRxPowerThresholdWarningLo) {
        getProperty(onuOlsRxPowerThresholdWarningLo).setValue(aOnuOlsRxPowerThresholdWarningLo);
    }

    public Integer getOnuOlsEnable() {
        return (Integer) getProperty(onuOlsEnable).getValue();
    }

    public void setOnuOlsEnable(Integer aOnuOlsEnable) {
        getProperty(onuOlsEnable).setValue(aOnuOlsEnable);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuOlsTemperature));
        prepareRead(super.getProperty(onuOlsVoltage));
        prepareRead(super.getProperty(onuOlsBiasCurrent));
        prepareRead(super.getProperty(onuOlsTxPower));
        prepareRead(super.getProperty(onuOlsRxPower));
        prepareRead(super.getProperty(onuOlsTempThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsTempThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsVoltageThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsVoltageThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsBiasCurrentThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsBiasCurrentThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsTxPowerThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsTxPowerThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsRxPowerThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsRxPowerThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsTempThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsTempThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsVoltageThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsVoltageThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsBiasCurrentThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsBiasCurrentThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsTxPowerThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsTxPowerThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsRxPowerThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsRxPowerThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsEnable));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuOlsTemperature));
        prepareRead(super.getProperty(onuOlsVoltage));
        prepareRead(super.getProperty(onuOlsBiasCurrent));
        prepareRead(super.getProperty(onuOlsTxPower));
        prepareRead(super.getProperty(onuOlsRxPower));
        prepareRead(super.getProperty(onuOlsTempThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsTempThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsVoltageThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsVoltageThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsBiasCurrentThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsBiasCurrentThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsTxPowerThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsTxPowerThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsRxPowerThresholdAlarmHi));
        prepareRead(super.getProperty(onuOlsRxPowerThresholdAlarmLo));
        prepareRead(super.getProperty(onuOlsTempThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsTempThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsVoltageThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsVoltageThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsBiasCurrentThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsBiasCurrentThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsTxPowerThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsTxPowerThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsRxPowerThresholdWarningHi));
        prepareRead(super.getProperty(onuOlsRxPowerThresholdWarningLo));
        prepareRead(super.getProperty(onuOlsEnable));

        return loadAll(new int[] { 1, 1, 1 });
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuOlsTempThresholdAlarmHi));
        prepareSave(getProperty(onuOlsTempThresholdAlarmLo));
        prepareSave(getProperty(onuOlsVoltageThresholdAlarmHi));
        prepareSave(getProperty(onuOlsVoltageThresholdAlarmLo));
        prepareSave(getProperty(onuOlsBiasCurrentThresholdAlarmHi));
        prepareSave(getProperty(onuOlsBiasCurrentThresholdAlarmLo));
        prepareSave(getProperty(onuOlsTxPowerThresholdAlarmHi));
        prepareSave(getProperty(onuOlsTxPowerThresholdAlarmLo));
        prepareSave(getProperty(onuOlsRxPowerThresholdAlarmHi));
        prepareSave(getProperty(onuOlsRxPowerThresholdAlarmLo));
        prepareSave(getProperty(onuOlsTempThresholdWarningHi));
        prepareSave(getProperty(onuOlsTempThresholdWarningLo));
        prepareSave(getProperty(onuOlsVoltageThresholdWarningHi));
        prepareSave(getProperty(onuOlsVoltageThresholdWarningLo));
        prepareSave(getProperty(onuOlsBiasCurrentThresholdWarningHi));
        prepareSave(getProperty(onuOlsBiasCurrentThresholdWarningLo));
        prepareSave(getProperty(onuOlsTxPowerThresholdWarningHi));
        prepareSave(getProperty(onuOlsTxPowerThresholdWarningLo));
        prepareSave(getProperty(onuOlsRxPowerThresholdWarningHi));
        prepareSave(getProperty(onuOlsRxPowerThresholdWarningLo));
        prepareSave(getProperty(onuOlsEnable));

        return save();
    }

}

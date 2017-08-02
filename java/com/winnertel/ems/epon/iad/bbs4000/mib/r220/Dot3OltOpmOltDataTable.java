/**
 * Created by Zhou Chao, 2010/4/26
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r220;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3OltOpmOltDataTable extends SnmpMibBean {

    public static final String utsDot3OltOpmOltDataModuleID = "utsDot3OltOpmOltDataModuleID";
    public static final String utsDot3OltOpmOltDataPortId = "utsDot3OltOpmOltDataPortId";
    public static final String utsDot3OltOpmOltDataTemperature = "utsDot3OltOpmOltDataTemperature";
    public static final String utsDot3OltOpmOltDataVoltage = "utsDot3OltOpmOltDataVoltage";
    public static final String utsDot3OltOpmOltDataBiasCurrent = "utsDot3OltOpmOltDataBiasCurrent";
    public static final String utsDot3OltOpmOltDataTxPower = "utsDot3OltOpmOltDataTxPower";
    public static final String utsDot3OltOpmVoltageMinThreshold = "utsDot3OltOpmVoltageMinThreshold";
    public static final String utsDot3OltOpmVoltageMaxThreshold = "utsDot3OltOpmVoltageMaxThreshold";
    public static final String utsDot3OltOpmBiasCurrentMinThreshold = "utsDot3OltOpmBiasCurrentMinThreshold";
    public static final String utsDot3OltOpmBiasCurrentMaxThreshold = "utsDot3OltOpmBiasCurrentMaxThreshold";
    public static final String utsDot3OltOpmTemperatureMinThreshold = "utsDot3OltOpmTemperatureMinThreshold";
    public static final String utsDot3OltOpmTemperatureMaxThreshold = "utsDot3OltOpmTemperatureMaxThreshold";
    public static final String utsDot3OltOpmTxPowerMinThreshold = "utsDot3OltOpmTxPowerMinThreshold";
    public static final String utsDot3OltOpmTxPowerMaxThreshold = "utsDot3OltOpmTxPowerMaxThreshold";

    public Dot3OltOpmOltDataTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OltOpmOltDataModuleID, new SnmpMibBeanProperty(utsDot3OltOpmOltDataModuleID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmOltDataPortId, new SnmpMibBeanProperty(utsDot3OltOpmOltDataPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmOltDataTemperature, new SnmpMibBeanProperty(utsDot3OltOpmOltDataTemperature, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmOltDataVoltage, new SnmpMibBeanProperty(utsDot3OltOpmOltDataVoltage, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmOltDataBiasCurrent, new SnmpMibBeanProperty(utsDot3OltOpmOltDataBiasCurrent, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmOltDataTxPower, new SnmpMibBeanProperty(utsDot3OltOpmOltDataTxPower, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmVoltageMinThreshold, new SnmpMibBeanProperty(utsDot3OltOpmVoltageMinThreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmVoltageMaxThreshold, new SnmpMibBeanProperty(utsDot3OltOpmVoltageMaxThreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmBiasCurrentMinThreshold, new SnmpMibBeanProperty(utsDot3OltOpmBiasCurrentMinThreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmBiasCurrentMaxThreshold, new SnmpMibBeanProperty(utsDot3OltOpmBiasCurrentMaxThreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.10", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmTemperatureMinThreshold, new SnmpMibBeanProperty(utsDot3OltOpmTemperatureMinThreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.11", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmTemperatureMaxThreshold, new SnmpMibBeanProperty(utsDot3OltOpmTemperatureMaxThreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.12", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmTxPowerMinThreshold, new SnmpMibBeanProperty(utsDot3OltOpmTxPowerMinThreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.13", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOpmTxPowerMaxThreshold, new SnmpMibBeanProperty(utsDot3OltOpmTxPowerMaxThreshold, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.14", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OltOpmOltDataModuleID() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OltOpmOltDataModuleID(Integer aUtsDot3OltOpmOltDataModuleID) {
        setIndex(0, aUtsDot3OltOpmOltDataModuleID);
    }

    public Integer getUtsDot3OltOpmOltDataPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OltOpmOltDataPortId(Integer aUtsDot3OltOpmOltDataPortId) {
        setIndex(1, aUtsDot3OltOpmOltDataPortId);
    }

    public Integer getUtsDot3OltOpmOltDataTemperature() {
        return (Integer) getProperty(utsDot3OltOpmOltDataTemperature).getValue();
    }

    public void setUtsDot3OltOpmOltDataTemperature(Integer aUtsDot3OltOpmOltDataTemperature) {
        getProperty(utsDot3OltOpmOltDataTemperature).setValue(aUtsDot3OltOpmOltDataTemperature);
    }

    public Integer getUtsDot3OltOpmOltDataVoltage() {
        return (Integer) getProperty(utsDot3OltOpmOltDataVoltage).getValue();
    }

    public void setUtsDot3OltOpmOltDataVoltage(Integer aUtsDot3OltOpmOltDataVoltage) {
        getProperty(utsDot3OltOpmOltDataVoltage).setValue(aUtsDot3OltOpmOltDataVoltage);
    }

    public Integer getUtsDot3OltOpmOltDataBiasCurrent() {
        return (Integer) getProperty(utsDot3OltOpmOltDataBiasCurrent).getValue();
    }

    public void setUtsDot3OltOpmOltDataBiasCurrent(Integer aUtsDot3OltOpmOltDataBiasCurrent) {
        getProperty(utsDot3OltOpmOltDataBiasCurrent).setValue(aUtsDot3OltOpmOltDataBiasCurrent);
    }

    public Integer getUtsDot3OltOpmOltDataTxPower() {
        return (Integer) getProperty(utsDot3OltOpmOltDataTxPower).getValue();
    }

    public void setUtsDot3OltOpmOltDataTxPower(Integer aUtsDot3OltOpmOltDataTxPower) {
        getProperty(utsDot3OltOpmOltDataTxPower).setValue(aUtsDot3OltOpmOltDataTxPower);
    }

    public Integer getUtsDot3OltOpmVoltageMinThreshold() {
        return (Integer) getProperty(utsDot3OltOpmVoltageMinThreshold).getValue();
    }

    public void setUtsDot3OltOpmVoltageMinThreshold(Integer aUtsDot3OltOpmVoltageMinThreshold) {
        getProperty(utsDot3OltOpmVoltageMinThreshold).setValue(aUtsDot3OltOpmVoltageMinThreshold);
    }

    public Integer getUtsDot3OltOpmVoltageMaxThreshold() {
        return (Integer) getProperty(utsDot3OltOpmVoltageMaxThreshold).getValue();
    }

    public void setUtsDot3OltOpmVoltageMaxThreshold(Integer aUtsDot3OltOpmVoltageMaxThreshold) {
        getProperty(utsDot3OltOpmVoltageMaxThreshold).setValue(aUtsDot3OltOpmVoltageMaxThreshold);
    }

    public Integer getUtsDot3OltOpmBiasCurrentMinThreshold() {
        return (Integer) getProperty(utsDot3OltOpmBiasCurrentMinThreshold).getValue();
    }

    public void setUtsDot3OltOpmBiasCurrentMinThreshold(Integer aUtsDot3OltOpmBiasCurrentMinThreshold) {
        getProperty(utsDot3OltOpmBiasCurrentMinThreshold).setValue(aUtsDot3OltOpmBiasCurrentMinThreshold);
    }

    public Integer getUtsDot3OltOpmBiasCurrentMaxThreshold() {
        return (Integer) getProperty(utsDot3OltOpmBiasCurrentMaxThreshold).getValue();
    }

    public void setUtsDot3OltOpmBiasCurrentMaxThreshold(Integer aUtsDot3OltOpmBiasCurrentMaxThreshold) {
        getProperty(utsDot3OltOpmBiasCurrentMaxThreshold).setValue(aUtsDot3OltOpmBiasCurrentMaxThreshold);
    }

    public Integer getUtsDot3OltOpmTemperatureMinThreshold() {
        return (Integer) getProperty(utsDot3OltOpmTemperatureMinThreshold).getValue();
    }

    public void setUtsDot3OltOpmTemperatureMinThreshold(Integer aUtsDot3OltOpmTemperatureMinThreshold) {
        getProperty(utsDot3OltOpmTemperatureMinThreshold).setValue(aUtsDot3OltOpmTemperatureMinThreshold);
    }

    public Integer getUtsDot3OltOpmTemperatureMaxThreshold() {
        return (Integer) getProperty(utsDot3OltOpmTemperatureMaxThreshold).getValue();
    }

    public void setUtsDot3OltOpmTemperatureMaxThreshold(Integer aUtsDot3OltOpmTemperatureMaxThreshold) {
        getProperty(utsDot3OltOpmTemperatureMaxThreshold).setValue(aUtsDot3OltOpmTemperatureMaxThreshold);
    }

    public Integer getUtsDot3OltOpmTxPowerMinThreshold() {
        return (Integer) getProperty(utsDot3OltOpmTxPowerMinThreshold).getValue();
    }

    public void setUtsDot3OltOpmTxPowerMinThreshold(Integer aUtsDot3OltOpmTxPowerMinThreshold) {
        getProperty(utsDot3OltOpmTxPowerMinThreshold).setValue(aUtsDot3OltOpmTxPowerMinThreshold);
    }

    public Integer getUtsDot3OltOpmTxPowerMaxThreshold() {
        return (Integer) getProperty(utsDot3OltOpmTxPowerMaxThreshold).getValue();
    }

    public void setUtsDot3OltOpmTxPowerMaxThreshold(Integer aUtsDot3OltOpmTxPowerMaxThreshold) {
        getProperty(utsDot3OltOpmTxPowerMaxThreshold).setValue(aUtsDot3OltOpmTxPowerMaxThreshold);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3OltOpmVoltageMinThreshold));
        prepareRead(getProperty(utsDot3OltOpmVoltageMaxThreshold));
        prepareRead(getProperty(utsDot3OltOpmBiasCurrentMinThreshold));
        prepareRead(getProperty(utsDot3OltOpmBiasCurrentMaxThreshold));
        prepareRead(getProperty(utsDot3OltOpmTemperatureMinThreshold));
        prepareRead(getProperty(utsDot3OltOpmTemperatureMaxThreshold));
        prepareRead(getProperty(utsDot3OltOpmTxPowerMinThreshold));
        prepareRead(getProperty(utsDot3OltOpmTxPowerMaxThreshold));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OltOpmVoltageMinThreshold));
        prepareRead(getProperty(utsDot3OltOpmVoltageMaxThreshold));
        prepareRead(getProperty(utsDot3OltOpmBiasCurrentMinThreshold));
        prepareRead(getProperty(utsDot3OltOpmBiasCurrentMaxThreshold));
        prepareRead(getProperty(utsDot3OltOpmTemperatureMinThreshold));
        prepareRead(getProperty(utsDot3OltOpmTemperatureMaxThreshold));
        prepareRead(getProperty(utsDot3OltOpmTxPowerMinThreshold));
        prepareRead(getProperty(utsDot3OltOpmTxPowerMaxThreshold));

        return loadAll(new int[]{1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3OltOpmVoltageMinThreshold));
        prepareSave(getProperty(utsDot3OltOpmVoltageMaxThreshold));
        prepareSave(getProperty(utsDot3OltOpmBiasCurrentMinThreshold));
        prepareSave(getProperty(utsDot3OltOpmBiasCurrentMaxThreshold));
        prepareSave(getProperty(utsDot3OltOpmTemperatureMinThreshold));
        prepareSave(getProperty(utsDot3OltOpmTemperatureMaxThreshold));
        prepareSave(getProperty(utsDot3OltOpmTxPowerMinThreshold));
        prepareSave(getProperty(utsDot3OltOpmTxPowerMaxThreshold));

        return save();
    }

}
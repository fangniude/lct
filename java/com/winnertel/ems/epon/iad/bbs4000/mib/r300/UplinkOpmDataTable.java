package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The UplinkOpmDataTable class.
 * Created by QuickDVM
 */
public class UplinkOpmDataTable extends SnmpMibBean {
    public static final String utsUplinkOpmDataModuleID = "utsUplinkOpmDataModuleID";
    public static final String utsUplinkOpmDataPortId = "utsUplinkOpmDataPortId";
    public static final String utsUplinkOpmDataTemperature = "utsUplinkOpmDataTemperature";
    public static final String utsUplinkOpmDataVoltage = "utsUplinkOpmDataVoltage";
    public static final String utsUplinkOpmDataBiasCurrent = "utsUplinkOpmDataBiasCurrent";
    public static final String utsUplinkOpmDataTxPower = "utsUplinkOpmDataTxPower";
    public static final String utsUplinkOpmDataRxPower = "utsUplinkOpmDataRxPower";

    public UplinkOpmDataTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsUplinkOpmDataModuleID, new SnmpMibBeanProperty(utsUplinkOpmDataModuleID, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.1", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataPortId, new SnmpMibBeanProperty(utsUplinkOpmDataPortId, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.2", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataTemperature, new SnmpMibBeanProperty(utsUplinkOpmDataTemperature, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.3", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataVoltage, new SnmpMibBeanProperty(utsUplinkOpmDataVoltage, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.4", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataBiasCurrent, new SnmpMibBeanProperty(utsUplinkOpmDataBiasCurrent, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.5", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataTxPower, new SnmpMibBeanProperty(utsUplinkOpmDataTxPower, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.6", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataRxPower, new SnmpMibBeanProperty(utsUplinkOpmDataRxPower, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.7", ISnmpConstant.INTEGER));
    }

    public Integer getUtsUplinkOpmDataModuleID() {
        return (Integer) getIndex(0);
    }

    public void setUtsUplinkOpmDataModuleID(Integer aUtsUplinkOpmDataModuleID) {
        setIndex(0, aUtsUplinkOpmDataModuleID);
    }


    public Integer getUtsUplinkOpmDataPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsUplinkOpmDataPortId(Integer aUtsUplinkOpmDataPortId) {
        setIndex(1, aUtsUplinkOpmDataPortId);
    }

    public Integer getUtsUplinkOpmDataTemperature() {
        return (Integer) getProperty(utsUplinkOpmDataTemperature).getValue();
    }

    public void setUtsUplinkOpmDataTemperature(Integer aUtsUplinkOpmDataTemperature) {
        getProperty(utsUplinkOpmDataTemperature).setValue(aUtsUplinkOpmDataTemperature);
    }

    public Integer getUtsUplinkOpmDataVoltage() {
        return (Integer) getProperty(utsUplinkOpmDataVoltage).getValue();
    }

    public void setUtsUplinkOpmDataVoltage(Integer aUtsUplinkOpmDataVoltage) {
        getProperty(utsUplinkOpmDataVoltage).setValue(aUtsUplinkOpmDataVoltage);
    }

    public Integer getUtsUplinkOpmDataBiasCurrent() {
        return (Integer) getProperty(utsUplinkOpmDataBiasCurrent).getValue();
    }

    public void setUtsUplinkOpmDataBiasCurrent(Integer aUtsUplinkOpmDataBiasCurrent) {
        getProperty(utsUplinkOpmDataBiasCurrent).setValue(aUtsUplinkOpmDataBiasCurrent);
    }

    public Integer getUtsUplinkOpmDataTxPower() {
        return (Integer) getProperty(utsUplinkOpmDataTxPower).getValue();
    }

    public void setUtsUplinkOpmDataTxPower(Integer aUtsUplinkOpmDataTxPower) {
        getProperty(utsUplinkOpmDataTxPower).setValue(aUtsUplinkOpmDataTxPower);
    }

    public Integer getUtsUplinkOpmDataRxPower() {
        return (Integer) getProperty(utsUplinkOpmDataRxPower).getValue();
    }

    public void setUtsUplinkOpmDataRxPower(Integer aUtsUplinkOpmDataRxPower) {
        getProperty(utsUplinkOpmDataRxPower).setValue(aUtsUplinkOpmDataRxPower);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsUplinkOpmDataTemperature));
        prepareRead(super.getProperty(utsUplinkOpmDataVoltage));
        prepareRead(super.getProperty(utsUplinkOpmDataBiasCurrent));
        prepareRead(super.getProperty(utsUplinkOpmDataTxPower));
        prepareRead(super.getProperty(utsUplinkOpmDataRxPower));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsUplinkOpmDataTemperature));
        prepareRead(super.getProperty(utsUplinkOpmDataVoltage));
        prepareRead(super.getProperty(utsUplinkOpmDataBiasCurrent));
        prepareRead(super.getProperty(utsUplinkOpmDataTxPower));
        prepareRead(super.getProperty(utsUplinkOpmDataRxPower));

        return loadAll(new int[]{1
                , 1
        });
    }
}

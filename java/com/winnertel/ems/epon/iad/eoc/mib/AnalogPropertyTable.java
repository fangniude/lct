package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The AnalogPropertyTable class.
 * Created by QuickDVM
 */
public class AnalogPropertyTable extends SnmpMibBean {
    public static final String analogAlarmParameterOID = "analogAlarmParameterOID";
    public static final String analogAlarmEnable = "analogAlarmEnable";
    public static final String analogAlarmState = "analogAlarmState";
    public static final String analogAlarmHIHI = "analogAlarmHIHI";
    public static final String analogAlarmHI = "analogAlarmHI";
    public static final String analogAlarmLO = "analogAlarmLO";
    public static final String analogAlarmLOLO = "analogAlarmLOLO";
    public static final String analogAlarmDeadband = "analogAlarmDeadband";

    public AnalogPropertyTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(analogAlarmParameterOID, new SnmpMibBeanProperty(analogAlarmParameterOID, ".1.3.6.1.4.1.17409.2.1.1.1.1", ISnmpConstant.OBJID));
        initProperty(analogAlarmEnable, new SnmpMibBeanProperty(analogAlarmEnable, ".1.3.6.1.4.1.17409.2.1.1.1.2", ISnmpConstant.OCTETS));
        initProperty(analogAlarmState, new SnmpMibBeanProperty(analogAlarmState, ".1.3.6.1.4.1.17409.2.1.1.1.3", ISnmpConstant.INTEGER));
        initProperty(analogAlarmHIHI, new SnmpMibBeanProperty(analogAlarmHIHI, ".1.3.6.1.4.1.17409.2.1.1.1.4", ISnmpConstant.INTEGER));
        initProperty(analogAlarmHI, new SnmpMibBeanProperty(analogAlarmHI, ".1.3.6.1.4.1.17409.2.1.1.1.5", ISnmpConstant.INTEGER));
        initProperty(analogAlarmLO, new SnmpMibBeanProperty(analogAlarmLO, ".1.3.6.1.4.1.17409.2.1.1.1.6", ISnmpConstant.INTEGER));
        initProperty(analogAlarmLOLO, new SnmpMibBeanProperty(analogAlarmLOLO, ".1.3.6.1.4.1.17409.2.1.1.1.7", ISnmpConstant.INTEGER));
        initProperty(analogAlarmDeadband, new SnmpMibBeanProperty(analogAlarmDeadband, ".1.3.6.1.4.1.17409.2.1.1.1.8", ISnmpConstant.INTEGER));

    }


    public String getAnalogAlarmParameterOID() {
        return (String) getIndex(0);
    }

    public void setAnalogAlarmParameterOID(String aAnalogAlarmParameterOID) {
        setIndex(0, aAnalogAlarmParameterOID);
    }


    public byte[] getAnalogAlarmEnable() {
        return (byte[]) getProperty(analogAlarmEnable).getValue();
    }

    public void setAnalogAlarmEnable(byte[] aAnalogAlarmEnable) {
        getProperty(analogAlarmEnable).setValue(aAnalogAlarmEnable);
    }

    public Integer getAnalogAlarmState() {
        return (Integer) getProperty(analogAlarmState).getValue();
    }

    public void setAnalogAlarmState(Integer aAnalogAlarmState) {
        getProperty(analogAlarmState).setValue(aAnalogAlarmState);
    }

    public Integer getAnalogAlarmHIHI() {
        return (Integer) getProperty(analogAlarmHIHI).getValue();
    }

    public void setAnalogAlarmHIHI(Integer aAnalogAlarmHIHI) {
        getProperty(analogAlarmHIHI).setValue(aAnalogAlarmHIHI);
    }

    public Integer getAnalogAlarmHI() {
        return (Integer) getProperty(analogAlarmHI).getValue();
    }

    public void setAnalogAlarmHI(Integer aAnalogAlarmHI) {
        getProperty(analogAlarmHI).setValue(aAnalogAlarmHI);
    }

    public Integer getAnalogAlarmLO() {
        return (Integer) getProperty(analogAlarmLO).getValue();
    }

    public void setAnalogAlarmLO(Integer aAnalogAlarmLO) {
        getProperty(analogAlarmLO).setValue(aAnalogAlarmLO);
    }

    public Integer getAnalogAlarmLOLO() {
        return (Integer) getProperty(analogAlarmLOLO).getValue();
    }

    public void setAnalogAlarmLOLO(Integer aAnalogAlarmLOLO) {
        getProperty(analogAlarmLOLO).setValue(aAnalogAlarmLOLO);
    }

    public Integer getAnalogAlarmDeadband() {
        return (Integer) getProperty(analogAlarmDeadband).getValue();
    }

    public void setAnalogAlarmDeadband(Integer aAnalogAlarmDeadband) {
        getProperty(analogAlarmDeadband).setValue(aAnalogAlarmDeadband);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(analogAlarmEnable));
        prepareRead(super.getProperty(analogAlarmState));
        prepareRead(super.getProperty(analogAlarmHIHI));
        prepareRead(super.getProperty(analogAlarmHI));
        prepareRead(super.getProperty(analogAlarmLO));
        prepareRead(super.getProperty(analogAlarmLOLO));
        prepareRead(super.getProperty(analogAlarmDeadband));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(analogAlarmEnable));
        prepareRead(super.getProperty(analogAlarmState));
        prepareRead(super.getProperty(analogAlarmHIHI));
        prepareRead(super.getProperty(analogAlarmHI));
        prepareRead(super.getProperty(analogAlarmLO));
        prepareRead(super.getProperty(analogAlarmLOLO));
        prepareRead(super.getProperty(analogAlarmDeadband));

        return loadAll(new int[]{0
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(analogAlarmEnable));
        prepareSave(getProperty(analogAlarmHIHI));
        prepareSave(getProperty(analogAlarmHI));
        prepareSave(getProperty(analogAlarmLO));
        prepareSave(getProperty(analogAlarmLOLO));
        prepareSave(getProperty(analogAlarmDeadband));

        return save();
    }

}

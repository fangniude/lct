package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The DiscretePropertyTable class.
 * Created by QuickDVM
 */
public class DiscretePropertyTable extends SnmpMibBean {
    public static final String discreteAlarmParameterOID = "discreteAlarmParameterOID";
    public static final String discreteAlarmValue = "discreteAlarmValue";
    public static final String discreteAlarmEnable = "discreteAlarmEnable";
    public static final String discreteAlarmState = "discreteAlarmState";

    public DiscretePropertyTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(discreteAlarmParameterOID, new SnmpMibBeanProperty(discreteAlarmParameterOID, ".1.3.6.1.4.1.17409.2.1.2.1.1", ISnmpConstant.OBJID));
        //initProperty(discreteAlarmValue, new SnmpMibBeanProperty(discreteAlarmValue, ".1.3.6.1.4.1.17409.2.1.2.1.2", ISnmpConstant.INTEGER));
        initProperty(discreteAlarmEnable, new SnmpMibBeanProperty(discreteAlarmEnable, ".1.3.6.1.4.1.17409.2.1.2.1.3", ISnmpConstant.INTEGER));
        initProperty(discreteAlarmState, new SnmpMibBeanProperty(discreteAlarmState, ".1.3.6.1.4.1.17409.2.1.2.1.4", ISnmpConstant.INTEGER));

    }


    public String getDiscreteAlarmParameterOID() {
        return (String) getIndex(0);
    }

    public void setDiscreteAlarmParameterOID(String aDiscreteAlarmParameterOID) {
        setIndex(0, aDiscreteAlarmParameterOID);
    }

    /*
    public Integer getDiscreteAlarmValue() {
        return (Integer) getIndex(1);
    }

    public void setDiscreteAlarmValue(Integer aDiscreteAlarmValue) {
        setIndex(1, aDiscreteAlarmValue);
    }*/


    public Integer getDiscreteAlarmEnable() {
        return (Integer) getProperty(discreteAlarmEnable).getValue();
    }

    public void setDiscreteAlarmEnable(Integer aDiscreteAlarmEnable) {
        getProperty(discreteAlarmEnable).setValue(aDiscreteAlarmEnable);
    }

    public Integer getDiscreteAlarmState() {
        return (Integer) getProperty(discreteAlarmState).getValue();
    }

    public void setDiscreteAlarmState(Integer aDiscreteAlarmState) {
        getProperty(discreteAlarmState).setValue(aDiscreteAlarmState);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(discreteAlarmEnable));
        prepareRead(super.getProperty(discreteAlarmState));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(discreteAlarmEnable));
        prepareRead(super.getProperty(discreteAlarmState));

        //return loadAll(new int[]{0 ,1});
        return loadAll(new int[]{0});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(discreteAlarmEnable));

        return save();
    }
}

package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The CurrentAlarmTable class.
 * Created by QuickDVM
 */
public class CurrentAlarmTable extends SnmpMibBean {
    public static final String currentAlarmOID = "currentAlarmOID";
    public static final String currentAlarmState = "currentAlarmState";
    public static final String currentAlarmValue = "currentAlarmValue";

    public CurrentAlarmTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(currentAlarmOID, new SnmpMibBeanProperty(currentAlarmOID, ".1.3.6.1.4.1.17409.2.1.3.1.1", ISnmpConstant.OBJID));
        initProperty(currentAlarmState, new SnmpMibBeanProperty(currentAlarmState, ".1.3.6.1.4.1.17409.2.1.3.1.2", ISnmpConstant.INTEGER));
        initProperty(currentAlarmValue, new SnmpMibBeanProperty(currentAlarmValue, ".1.3.6.1.4.1.17409.2.1.3.1.3", ISnmpConstant.INTEGER));

    }


    public String getCurrentAlarmOID() {
        return (String) getIndex(0);
    }

    public void setCurrentAlarmOID(String aCurrentAlarmOID) {
        setIndex(0, aCurrentAlarmOID);
    }


    public Integer getCurrentAlarmState() {
        return (Integer) getProperty(currentAlarmState).getValue();
    }

    public void setCurrentAlarmState(Integer aCurrentAlarmState) {
        getProperty(currentAlarmState).setValue(aCurrentAlarmState);
    }

    public Integer getCurrentAlarmValue() {
        return (Integer) getProperty(currentAlarmValue).getValue();
    }

    public void setCurrentAlarmValue(Integer aCurrentAlarmValue) {
        getProperty(currentAlarmValue).setValue(aCurrentAlarmValue);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(currentAlarmState));
        prepareRead(super.getProperty(currentAlarmValue));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(currentAlarmState));
        prepareRead(super.getProperty(currentAlarmValue));

        return loadAll(new int[]{0
        });
    }

}

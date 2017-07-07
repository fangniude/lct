package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The AlarmLogTable class.
 * Created by QuickDVM
 */
public class AlarmLogTable extends SnmpMibBean {
    public static final String alarmLogIndex = "alarmLogIndex";
    public static final String alarmLogInformation = "alarmLogInformation";

    public AlarmLogTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(alarmLogIndex, new SnmpMibBeanProperty(alarmLogIndex, ".1.3.6.1.4.1.17409.2.2.3.1.1", ISnmpConstant.INTEGER));
        initProperty(alarmLogInformation, new SnmpMibBeanProperty(alarmLogInformation, ".1.3.6.1.4.1.17409.2.2.3.1.2", ISnmpConstant.OCTETS));

    }

    public Integer getAlarmLogIndex() {
        return (Integer) getIndex(0);
    }

    public void setAlarmLogIndex(Integer aAlarmLogIndex) {
        setIndex(0, aAlarmLogIndex);
    }


    public byte[] getAlarmLogInformation() {
        return (byte[]) getProperty(alarmLogInformation).getValue();
    }

    public void setAlarmLogInformation(byte[] aAlarmLogInformation) {
        getProperty(alarmLogInformation).setValue(aAlarmLogInformation);
    }

    public byte[] getAlarmLogTime() {
        return (byte[]) getProperty(alarmLogInformation).getValue();
    }

    public void setAlarmLogTime(byte[] aAlarmLogTime) {
        getProperty(alarmLogInformation).setValue(aAlarmLogTime);
    }

    public byte[] getAlarmLogType() {
        return (byte[]) getProperty(alarmLogInformation).getValue();
    }

    public void setAlarmLogType(byte[] aAlarmLogType) {
        getProperty(alarmLogInformation).setValue(aAlarmLogType);
    }

    public byte[] getAlarmLogMessage() {
        return (byte[]) getProperty(alarmLogInformation).getValue();
    }

    public void setAlarmLogMessage(byte[] aAlarmLogInstance) {
        getProperty(alarmLogInformation).setValue(aAlarmLogInstance);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(alarmLogInformation));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(alarmLogInformation));

        return loadAll(new int[]{1
        });
    }

}

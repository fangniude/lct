package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The AlarmLog class.
 * Created by QuickDVM
 */
public class AlarmLog extends SnmpMibBean {
    public static final String alarmLogNumberOfEntries = "alarmLogNumberOfEntries";
    public static final String alarmLogLastIndex = "alarmLogLastIndex";
    public static final String alarmText = "alarmText";

    public AlarmLog(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(alarmLogNumberOfEntries, new SnmpMibBeanProperty(alarmLogNumberOfEntries, ".1.3.6.1.4.1.17409.2.2.1", ISnmpConstant.INTEGER));
        initProperty(alarmLogLastIndex, new SnmpMibBeanProperty(alarmLogLastIndex, ".1.3.6.1.4.1.17409.2.2.2", ISnmpConstant.INTEGER));
        initProperty(alarmText, new SnmpMibBeanProperty(alarmText, ".1.3.6.1.4.1.17409.2.2.4", ISnmpConstant.STRING));

    }


    public Integer getAlarmLogNumberOfEntries() {
        return (Integer) getProperty(alarmLogNumberOfEntries).getValue();
    }

    public void setAlarmLogNumberOfEntries(Integer aAlarmLogNumberOfEntries) {
        getProperty(alarmLogNumberOfEntries).setValue(aAlarmLogNumberOfEntries);
    }

    public Integer getAlarmLogLastIndex() {
        return (Integer) getProperty(alarmLogLastIndex).getValue();
    }

    public void setAlarmLogLastIndex(Integer aAlarmLogLastIndex) {
        getProperty(alarmLogLastIndex).setValue(aAlarmLogLastIndex);
    }

    public String getAlarmText() {
        return (String) getProperty(alarmText).getValue();
    }

    public void setAlarmText(String aAlarmText) {
        getProperty(alarmText).setValue(aAlarmText);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(alarmLogNumberOfEntries));
        prepareRead(super.getProperty(alarmLogLastIndex));
        //prepareRead(super.getProperty(alarmText));

        return load();
    }

}

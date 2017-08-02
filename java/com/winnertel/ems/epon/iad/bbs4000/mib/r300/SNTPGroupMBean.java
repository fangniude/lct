package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class SNTPGroupMBean extends SnmpMibBean {
    public static final String utsSNTPServiceState = "utsSNTPServiceState";
    public static final String utsSNTPPollInterval = "utsSNTPPollInterval";
    public static final String utsSNTPTimeZone = "utsSNTPTimeZone";
    public static final String utsSNTPClockSync = "utsSNTPClockSync";
    public static final String utsSNTPCurrentTime = "utsSNTPCurrentTime";
    public static final String utsSNTPLastUpdateTime = "utsSNTPLastUpdateTime";
    public static final String utsSNTPTimeZoneMinuteOffset = "utsSNTPTimeZoneMinuteOffset";

    public SNTPGroupMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsSNTPServiceState, new SnmpMibBeanProperty(utsSNTPServiceState, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.1.1", ISnmpConstant.INTEGER));
        initProperty(utsSNTPPollInterval, new SnmpMibBeanProperty(utsSNTPPollInterval, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.1.2", ISnmpConstant.INTEGER));
        initProperty(utsSNTPTimeZone, new SnmpMibBeanProperty(utsSNTPTimeZone, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.1.3", ISnmpConstant.INTEGER));
        initProperty(utsSNTPClockSync, new SnmpMibBeanProperty(utsSNTPClockSync, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.1.4", ISnmpConstant.INTEGER));
        initProperty(utsSNTPCurrentTime, new SnmpMibBeanProperty(utsSNTPCurrentTime, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.1.5", ISnmpConstant.STRING));
        initProperty(utsSNTPLastUpdateTime, new SnmpMibBeanProperty(utsSNTPLastUpdateTime, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.1.6", ISnmpConstant.STRING));
        initProperty(utsSNTPTimeZoneMinuteOffset, new SnmpMibBeanProperty(utsSNTPTimeZoneMinuteOffset, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.1.7", ISnmpConstant.INTEGER));
    }


    public Integer getUtsSNTPServiceState() {
        return (Integer) getProperty(utsSNTPServiceState).getValue();
    }

    public void setUtsSNTPServiceState(Integer aUtsSNTPServiceState) {
        getProperty(utsSNTPServiceState).setValue(aUtsSNTPServiceState);
    }

    public Integer getUtsSNTPPollInterval() {
        return (Integer) getProperty(utsSNTPPollInterval).getValue();
    }

    public void setUtsSNTPPollInterval(Integer aUtsSNTPPollInterval) {
        getProperty(utsSNTPPollInterval).setValue(aUtsSNTPPollInterval);
    }

    public Integer getUtsSNTPTimeZone() {
        return (Integer) getProperty(utsSNTPTimeZone).getValue();
    }

    public void setUtsSNTPTimeZone(Integer aUtsSNTPTimeZone) {
        getProperty(utsSNTPTimeZone).setValue(aUtsSNTPTimeZone);
    }

    public Integer getUtsSNTPClockSync() {
        return (Integer) getProperty(utsSNTPClockSync).getValue();
    }

    public void setUtsSNTPClockSync(Integer aUtsSNTPClockSync) {
        getProperty(utsSNTPClockSync).setValue(aUtsSNTPClockSync);
    }

    public String getUtsSNTPCurrentTime() {
        return (String) getProperty(utsSNTPCurrentTime).getValue();
    }

    public void setUtsSNTPCurrentTime(String aUtsSNTPCurrentTime) {
        getProperty(utsSNTPCurrentTime).setValue(aUtsSNTPCurrentTime);
    }

    public String getUtsSNTPLastUpdateTime() {
        return (String) getProperty(utsSNTPLastUpdateTime).getValue();
    }

    public void setUtsSNTPLastUpdateTime(String aUtsSNTPLastUpdateTime) {
        getProperty(utsSNTPLastUpdateTime).setValue(aUtsSNTPLastUpdateTime);
    }

    public Integer getUtsSNTPTimeZoneMinuteOffset() {
        return (Integer) getProperty(utsSNTPTimeZoneMinuteOffset).getValue();
    }

    public void setUtsSNTPTimeZoneMinuteOffset(Integer aUtsSNTPTimeZoneMinuteOffset) {
        getProperty(utsSNTPTimeZoneMinuteOffset).setValue(aUtsSNTPTimeZoneMinuteOffset);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsSNTPServiceState));
        prepareRead(super.getProperty(utsSNTPPollInterval));
        prepareRead(super.getProperty(utsSNTPTimeZone));
        prepareRead(super.getProperty(utsSNTPClockSync));
        prepareRead(super.getProperty(utsSNTPCurrentTime));
        prepareRead(super.getProperty(utsSNTPLastUpdateTime));
        prepareRead(super.getProperty(utsSNTPTimeZoneMinuteOffset));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsSNTPServiceState));
        prepareSave(getProperty(utsSNTPPollInterval));
        prepareSave(getProperty(utsSNTPTimeZone));
        prepareSave(getProperty(utsSNTPTimeZoneMinuteOffset));

        return save();
    }

    public boolean syncClock() throws MibBeanException {
        setUtsSNTPClockSync(1);
        prepareSave(getProperty(utsSNTPClockSync));

        return save();
    }
}

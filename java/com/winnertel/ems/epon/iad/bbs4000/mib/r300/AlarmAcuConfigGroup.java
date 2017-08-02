package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class AlarmAcuConfigGroup extends SnmpMibBean {
    public static final String utsBbsAlarmAcuLedControl = "utsBbsAlarmAcuLedControl";
    public static final String utsBbsAlarmAcuAudioControl = "utsBbsAlarmAcuAudioControl";
    public static final String utsBbsAlarmAcuAudioMute = "utsBbsAlarmAcuAudioMute";

    public AlarmAcuConfigGroup(ISnmpProxy snmpProxy) {
        super(snmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsBbsAlarmAcuLedControl, new SnmpMibBeanProperty(utsBbsAlarmAcuLedControl, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.8", ISnmpConstant.OCTETS));
        initProperty(utsBbsAlarmAcuAudioControl, new SnmpMibBeanProperty(utsBbsAlarmAcuAudioControl, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.9", ISnmpConstant.INTEGER));
        initProperty(utsBbsAlarmAcuAudioMute, new SnmpMibBeanProperty(utsBbsAlarmAcuAudioMute, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.11", ISnmpConstant.INTEGER));
    }

    public byte[] getUtsBbsAlarmAcuLedControl() {
        return (byte[]) getProperty(utsBbsAlarmAcuLedControl).getValue();
    }

    public void setutsBbsAlarmAcuLedControl(byte[] autsBbsAlarmAcuLedControl) {
        getProperty(utsBbsAlarmAcuLedControl).setValue(autsBbsAlarmAcuLedControl);
    }

    public Integer getUtsBbsAlarmAcuAudioControl() {
        return (Integer) getProperty(utsBbsAlarmAcuAudioControl).getValue();
    }

    public void setUtsBbsAlarmAcuAudioControl(Integer aUtsBbsAlarmAcuAudioControl) {
        getProperty(utsBbsAlarmAcuAudioControl).setValue(aUtsBbsAlarmAcuAudioControl);
    }

    public Integer getUtsBbsAlarmAcuAudioMute() {
        return (Integer) getProperty(utsBbsAlarmAcuAudioMute).getValue();
    }

    public void setUtsBbsAlarmAcuAudioMute(Integer aUtsBbsAlarmAcuAudioMute) {
        getProperty(utsBbsAlarmAcuAudioMute).setValue(aUtsBbsAlarmAcuAudioMute);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsBbsAlarmAcuLedControl));
        prepareRead(getProperty(utsBbsAlarmAcuAudioControl));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsBbsAlarmAcuLedControl));
        prepareSave(getProperty(utsBbsAlarmAcuAudioControl));

        return save();
    }

    public boolean mute() throws MibBeanException {
        setUtsBbsAlarmAcuAudioMute(1);
        prepareSave(getProperty(utsBbsAlarmAcuAudioMute));

        return save();
    }
}

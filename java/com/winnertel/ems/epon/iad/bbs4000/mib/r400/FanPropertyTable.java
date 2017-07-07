package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class FanPropertyTable extends SnmpMibBean {

    public static final String fanDeviceIndex = "fanDeviceIndex";
    public static final String fanCardIndex = "fanCardIndex";
    public static final String fanCardOperationStatus = "fanCardOperationStatus";
    public static final String fanCardAlarmStatus = "fanCardAlarmStatus";
    public static final String fanCardName = "fanCardName";
    public static final String fanCardPresenceStatus = "fanCardPresenceStatus";

    public FanPropertyTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(fanDeviceIndex, new SnmpMibBeanProperty(fanDeviceIndex, ".1.3.6.1.4.1.17409.2.3.1.5.1.1.1", ISnmpConstant.INTEGER));
        initProperty(fanCardIndex, new SnmpMibBeanProperty(fanCardIndex, ".1.3.6.1.4.1.17409.2.3.1.5.1.1.2", ISnmpConstant.GAUGE));
        initProperty(fanCardOperationStatus, new SnmpMibBeanProperty(fanCardOperationStatus, ".1.3.6.1.4.1.17409.2.3.1.5.1.1.3", ISnmpConstant.INTEGER));
        initProperty(fanCardAlarmStatus, new SnmpMibBeanProperty(fanCardAlarmStatus, ".1.3.6.1.4.1.17409.2.3.1.5.1.1.4", ISnmpConstant.OCTETS));
        initProperty(fanCardName, new SnmpMibBeanProperty(fanCardName, ".1.3.6.1.4.1.17409.2.3.1.5.1.1.5", ISnmpConstant.STRING));
        initProperty(fanCardPresenceStatus, new SnmpMibBeanProperty(fanCardPresenceStatus, ".1.3.6.1.4.1.17409.2.3.1.5.1.1.6", ISnmpConstant.INTEGER));
    }

    public Integer getFanDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setFanDeviceIndex(Integer aFanDeviceIndex) {
        setIndex(0, aFanDeviceIndex);
    }

    public Long getFanCardIndex() {
        return (Long) getIndex(1);
    }

    public void setFanCardIndex(Long aFanCardIndex) {
        setIndex(1, aFanCardIndex);
    }

    public Integer getFanCardOperationStatus() {
        return (Integer) getProperty(fanCardOperationStatus).getValue();
    }

    public void setFanCardOperationStatus(Integer aFanCardOperationStatus) {
        getProperty(fanCardOperationStatus).setValue(aFanCardOperationStatus);
    }

    public byte[] getFanCardAlarmStatus() {
        return (byte[]) getProperty(fanCardAlarmStatus).getValue();
    }

    public void setFanCardAlarmStatus(byte[] aFanCardAlarmStatus) {
        getProperty(fanCardAlarmStatus).setValue(aFanCardAlarmStatus);
    }

    public String getFanCardName() {
        return (String) getProperty(fanCardName).getValue();
    }

    public void setFanCardName(String aFanCardName) {
        getProperty(fanCardName).setValue(aFanCardName);
    }

    public Integer getFanCardPresenceStatus() {
        return (Integer) getProperty(fanCardPresenceStatus).getValue();
    }

    public void setFanCardPresenceStatus(Integer aFanCardPresenceStatus) {
        getProperty(fanCardPresenceStatus).setValue(aFanCardPresenceStatus);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(fanCardOperationStatus));
        prepareRead(getProperty(fanCardAlarmStatus));
        prepareRead(getProperty(fanCardName));
        prepareRead(getProperty(fanCardPresenceStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(fanCardOperationStatus));
        prepareRead(getProperty(fanCardAlarmStatus));
        prepareRead(getProperty(fanCardName));
        prepareRead(getProperty(fanCardPresenceStatus));

        return loadAll(new int[]{1, 2});
    }

}
package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PowerPropertyTable extends SnmpMibBean {

    public static final String powerDeviceIndex = "powerDeviceIndex";
    public static final String powerCardIndex = "powerCardIndex";
    public static final String powerCardOperationStatus = "powerCardOperationStatus";
    public static final String powerCardAlarmStatus = "powerCardAlarmStatus";
    public static final String powerCardAction = "powerCardAction";
    public static final String powerCardName = "powerCardName";
    public static final String powerCardPresenceStatus = "powerCardPresenceStatus";
    public static final String powerCardRedundancyStatus = "powerCardRedundancyStatus";

    public PowerPropertyTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(powerDeviceIndex, new SnmpMibBeanProperty(powerDeviceIndex, ".1.3.6.1.4.1.17409.2.3.1.4.1.1.1", ISnmpConstant.INTEGER));
        initProperty(powerCardIndex, new SnmpMibBeanProperty(powerCardIndex, ".1.3.6.1.4.1.17409.2.3.1.4.1.1.2", ISnmpConstant.GAUGE));
        initProperty(powerCardOperationStatus, new SnmpMibBeanProperty(powerCardOperationStatus, ".1.3.6.1.4.1.17409.2.3.1.4.1.1.3", ISnmpConstant.INTEGER));
        initProperty(powerCardAlarmStatus, new SnmpMibBeanProperty(powerCardAlarmStatus, ".1.3.6.1.4.1.17409.2.3.1.4.1.1.4", ISnmpConstant.OCTETS));
        initProperty(powerCardAction, new SnmpMibBeanProperty(powerCardAction, ".1.3.6.1.4.1.17409.2.3.1.4.1.1.5", ISnmpConstant.INTEGER));
        initProperty(powerCardName, new SnmpMibBeanProperty(powerCardName, ".1.3.6.1.4.1.17409.2.3.1.4.1.1.6", ISnmpConstant.STRING));
        initProperty(powerCardPresenceStatus, new SnmpMibBeanProperty(powerCardPresenceStatus, ".1.3.6.1.4.1.17409.2.3.1.4.1.1.7", ISnmpConstant.INTEGER));
        initProperty(powerCardRedundancyStatus, new SnmpMibBeanProperty(powerCardRedundancyStatus, ".1.3.6.1.4.1.17409.2.3.1.4.1.1.8", ISnmpConstant.INTEGER));
    }

    public Integer getPowerDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setPowerDeviceIndex(Integer aPowerDeviceIndex) {
        setIndex(0, aPowerDeviceIndex);
    }

    public Long getPowerCardIndex() {
        return (Long) getIndex(1);
    }

    public void setPowerCardIndex(Long aPowerCardIndex) {
        setIndex(1, aPowerCardIndex);
    }

    public Integer getPowerCardOperationStatus() {
        return (Integer) getProperty(powerCardOperationStatus).getValue();
    }

    public void setPowerCardOperationStatus(Integer aPowerCardOperationStatus) {
        getProperty(powerCardOperationStatus).setValue(aPowerCardOperationStatus);
    }

    public byte[] getPowerCardAlarmStatus() {
        return (byte[]) getProperty(powerCardAlarmStatus).getValue();
    }

    public void setPowerCardAlarmStatus(byte[] aPowerCardAlarmStatus) {
        getProperty(powerCardAlarmStatus).setValue(aPowerCardAlarmStatus);
    }

    public Integer getPowerCardAction() {
        return (Integer) getProperty(powerCardAction).getValue();
    }

    public void setPowerCardAction(Integer aPowerCardAction) {
        getProperty(powerCardAction).setValue(aPowerCardAction);
    }

    public String getPowerCardName() {
        return (String) getProperty(powerCardName).getValue();
    }

    public void setPowerCardName(String aPowerCardName) {
        getProperty(powerCardName).setValue(aPowerCardName);
    }

    public Integer getPowerCardPresenceStatus() {
        return (Integer) getProperty(powerCardPresenceStatus).getValue();
    }

    public void setPowerCardPresenceStatus(Integer aPowerCardPresenceStatus) {
        getProperty(powerCardPresenceStatus).setValue(aPowerCardPresenceStatus);
    }

    public Integer getPowerCardRedundancyStatus() {
        return (Integer)getProperty(powerCardRedundancyStatus).getValue();
    }

    public void setPowerCardRedundancyStatus(Integer aPowerCardRedundancyStatus) {
        getProperty(powerCardRedundancyStatus).setValue(aPowerCardRedundancyStatus);
    }
    
    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(powerCardOperationStatus));
        prepareRead(getProperty(powerCardAlarmStatus));
        prepareRead(getProperty(powerCardAction));
        prepareRead(getProperty(powerCardName));
        prepareRead(getProperty(powerCardPresenceStatus));
        prepareRead(getProperty(powerCardRedundancyStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(powerCardOperationStatus));
        prepareRead(getProperty(powerCardAlarmStatus));
        prepareRead(getProperty(powerCardAction));
        prepareRead(getProperty(powerCardName));
        prepareRead(getProperty(powerCardPresenceStatus));
        prepareRead(getProperty(powerCardRedundancyStatus));

        return loadAll(new int[]{1, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(powerCardAction));

        return save();
    }

}
/**
 * Created by Zhou Chao, 2010/7/6
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class ActiveAlarmTable extends SnmpMibBean {

    public static final String activeAlarmSeqNum = "activeAlarmSeqNum";
    public static final String activeAlarmCode = "activeAlarmCode";
    public static final String activeAlarmInstance = "activeAlarmInstance";
    public static final String activeAlarmSeverity = "activeAlarmSeverity";
    public static final String activeAlarmRaisingNumber = "activeAlarmRaisingNumber";
    public static final String activeAlarmFirstOccurTime = "activeAlarmFirstOccurTime";
    public static final String activeAlarmLastOccurTime = "activeAlarmLastOccurTime";
    public static final String activeAlarmRepeats = "activeAlarmRepeats";
    public static final String activeAlarmConfirm = "activeAlarmConfirm";
    public static final String activeAlarmAdditionalText = "activeAlarmAdditionalText";

    public ActiveAlarmTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }


    protected void init() {
        initProperty(activeAlarmSeqNum, new SnmpMibBeanProperty(activeAlarmSeqNum, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(activeAlarmCode, new SnmpMibBeanProperty(activeAlarmCode, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.2", ISnmpConstant.INTEGER));
        initProperty(activeAlarmInstance, new SnmpMibBeanProperty(activeAlarmInstance, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.3", ISnmpConstant.OCTETS));
        initProperty(activeAlarmSeverity, new SnmpMibBeanProperty(activeAlarmSeverity, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.4", ISnmpConstant.INTEGER));
        initProperty(activeAlarmRaisingNumber, new SnmpMibBeanProperty(activeAlarmRaisingNumber, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.5", ISnmpConstant.GAUGE));
        initProperty(activeAlarmFirstOccurTime, new SnmpMibBeanProperty(activeAlarmFirstOccurTime, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.6", ISnmpConstant.OCTETS));
        initProperty(activeAlarmLastOccurTime, new SnmpMibBeanProperty(activeAlarmLastOccurTime, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.7", ISnmpConstant.OCTETS));
        initProperty(activeAlarmRepeats, new SnmpMibBeanProperty(activeAlarmRepeats, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.8", ISnmpConstant.GAUGE));
        initProperty(activeAlarmConfirm, new SnmpMibBeanProperty(activeAlarmConfirm, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.9", ISnmpConstant.INTEGER));
        initProperty(activeAlarmAdditionalText, new SnmpMibBeanProperty(activeAlarmAdditionalText, ".1.3.6.1.4.1.17409.2.2.11.2.1.1.10", ISnmpConstant.STRING));
    }

    public Integer getActiveAlarmSeqNum() {
        return (Integer) getIndex(0);
    }

    public void setActiveAlarmSeqNum(Integer aActiveAlarmSeqNum) {
        setIndex(0, aActiveAlarmSeqNum);
    }

    public Long getActiveAlarmRaisingNumber() {
        return (Long) getIndex(1);
    }

    public void setActiveAlarmRaisingNumber(Long aActiveAlarmRaisingNumber) {
        setIndex(1, aActiveAlarmRaisingNumber);
    }

    public Integer getActiveAlarmCode() {
        return (Integer) getProperty(activeAlarmCode).getValue();
    }

    public void setActiveAlarmCode(Integer aActiveAlarmCode) {
        getProperty(activeAlarmCode).setValue(aActiveAlarmCode);
    }

    public byte[] getActiveAlarmInstance() {
        return (byte[]) getProperty(activeAlarmInstance).getValue();
    }

    public void setActiveAlarmInstance(byte[] aActiveAlarmInstance) {
        getProperty(activeAlarmInstance).setValue(aActiveAlarmInstance);
    }

    public Integer getActiveAlarmSeverity() {
        return (Integer) getProperty(activeAlarmSeverity).getValue();
    }

    public void setActiveAlarmSeverity(Integer aActiveAlarmSeverity) {
        getProperty(activeAlarmSeverity).setValue(aActiveAlarmSeverity);
    }

    public byte[] getActiveAlarmFirstOccurTime() {
        return (byte[]) getProperty(activeAlarmFirstOccurTime).getValue();
    }

    public void setActiveAlarmFirstOccurTime(byte[] aActiveAlarmFirstOccurTime) {
        getProperty(activeAlarmFirstOccurTime).setValue(aActiveAlarmFirstOccurTime);
    }

    public byte[] getActiveAlarmLastOccurTime() {
        return (byte[]) getProperty(activeAlarmLastOccurTime).getValue();
    }

    public void setActiveAlarmLastOccurTime(byte[] aActiveAlarmLastOccurTime) {
        getProperty(activeAlarmLastOccurTime).setValue(aActiveAlarmLastOccurTime);
    }

    public Long getActiveAlarmRepeats() {
        return (Long) getProperty(activeAlarmRepeats).getValue();
    }

    public void setActiveAlarmRepeats(Long aActiveAlarmRepeats) {
        getProperty(activeAlarmRepeats).setValue(aActiveAlarmRepeats);
    }

    public Integer getActiveAlarmConfirm() {
        return (Integer) getProperty(activeAlarmConfirm).getValue();
    }

    public void setActiveAlarmConfirm(Integer aActiveAlarmConfirm) {
        getProperty(activeAlarmConfirm).setValue(aActiveAlarmConfirm);
    }

    public String getActiveAlarmAdditionalText() {
        return (String) getProperty(activeAlarmAdditionalText).getValue();
    }

    public void setActiveAlarmAdditionalText(String aActiveAlarmAdditionalText) {
        getProperty(activeAlarmAdditionalText).setValue(aActiveAlarmAdditionalText);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(activeAlarmCode));
        prepareRead(getProperty(activeAlarmInstance));
        prepareRead(getProperty(activeAlarmSeverity));
        prepareRead(getProperty(activeAlarmFirstOccurTime));
        prepareRead(getProperty(activeAlarmLastOccurTime));
        prepareRead(getProperty(activeAlarmRepeats));
        prepareRead(getProperty(activeAlarmConfirm));
        prepareRead(getProperty(activeAlarmAdditionalText));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(activeAlarmCode));
        prepareRead(getProperty(activeAlarmInstance));
        prepareRead(getProperty(activeAlarmSeverity));
        prepareRead(getProperty(activeAlarmFirstOccurTime));
        prepareRead(getProperty(activeAlarmLastOccurTime));
        prepareRead(getProperty(activeAlarmRepeats));
        prepareRead(getProperty(activeAlarmConfirm));
        prepareRead(getProperty(activeAlarmAdditionalText));

        return loadAll(new int[]{1, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(activeAlarmConfirm));

        return save();
    }

}
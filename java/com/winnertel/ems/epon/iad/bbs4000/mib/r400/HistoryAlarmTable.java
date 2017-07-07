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

public class HistoryAlarmTable extends SnmpMibBean {

    public static final String historyAlarmSeqNum = "historyAlarmSeqNum";
    public static final String historyAlarmCode = "historyAlarmCode";
    public static final String historyAlarmInstance = "historyAlarmInstance";
    public static final String historyAlarmSeverity = "historyAlarmSeverity";
    public static final String historyAlarmRaisingNumber = "historyAlarmRaisingNumber";
    public static final String historyAlarmFirstOccurTime = "historyAlarmFirstOccurTime";
    public static final String historyAlarmLastOccurTime = "historyAlarmLastOccurTime";
    public static final String historyAlarmRepeats = "historyAlarmRepeats";
    public static final String historyAlarmCorrelationId = "historyAlarmCorrelationId";
    public static final String historyAlarmAdditionalText = "historyAlarmAdditionalText";
    public static final String historyAlarmClearTime = "historyAlarmClearTime";

    public HistoryAlarmTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(historyAlarmSeqNum, new SnmpMibBeanProperty(historyAlarmSeqNum, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.1", ISnmpConstant.INTEGER));
        initProperty(historyAlarmCode, new SnmpMibBeanProperty(historyAlarmCode, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.2", ISnmpConstant.INTEGER));
        initProperty(historyAlarmInstance, new SnmpMibBeanProperty(historyAlarmInstance, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.3", ISnmpConstant.OCTETS));
        initProperty(historyAlarmSeverity, new SnmpMibBeanProperty(historyAlarmSeverity, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.4", ISnmpConstant.INTEGER));
        initProperty(historyAlarmRaisingNumber, new SnmpMibBeanProperty(historyAlarmRaisingNumber, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.5", ISnmpConstant.GAUGE));
        initProperty(historyAlarmFirstOccurTime, new SnmpMibBeanProperty(historyAlarmFirstOccurTime, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.6", ISnmpConstant.OCTETS));
        initProperty(historyAlarmLastOccurTime, new SnmpMibBeanProperty(historyAlarmLastOccurTime, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.7", ISnmpConstant.OCTETS));
        initProperty(historyAlarmRepeats, new SnmpMibBeanProperty(historyAlarmRepeats, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.8", ISnmpConstant.COUNTER));
        initProperty(historyAlarmCorrelationId, new SnmpMibBeanProperty(historyAlarmCorrelationId, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.9", ISnmpConstant.GAUGE));
        initProperty(historyAlarmAdditionalText, new SnmpMibBeanProperty(historyAlarmAdditionalText, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.10", ISnmpConstant.STRING));
        initProperty(historyAlarmClearTime, new SnmpMibBeanProperty(historyAlarmClearTime, ".1.3.6.1.4.1.17409.2.2.11.2.2.1.11", ISnmpConstant.OCTETS));
    }

    public Integer getHistoryAlarmSeqNum() {
        return (Integer) getIndex(0);
    }

    public void setHistoryAlarmSeqNum(Integer aHistoryAlarmSeqNum) {
        setIndex(0, aHistoryAlarmSeqNum);
    }

    public Long getHistoryAlarmRaisingNumber() {
        return (Long) getIndex(1);
    }

    public void setHistoryAlarmRaisingNumber(Long aHistoryAlarmRaisingNumber) {
        setIndex(1, aHistoryAlarmRaisingNumber);
    }

    public Integer getHistoryAlarmCode() {
        return (Integer) getProperty(historyAlarmCode).getValue();
    }

    public void setHistoryAlarmCode(Integer aHistoryAlarmCode) {
        getProperty(historyAlarmCode).setValue(aHistoryAlarmCode);
    }

    public byte[] getHistoryAlarmInstance() {
        return (byte[]) getProperty(historyAlarmInstance).getValue();
    }

    public void setHistoryAlarmInstance(byte[] aHistoryAlarmInstance) {
        getProperty(historyAlarmInstance).setValue(aHistoryAlarmInstance);
    }

    public Integer getHistoryAlarmSeverity() {
        return (Integer) getProperty(historyAlarmSeverity).getValue();
    }

    public void setHistoryAlarmSeverity(Integer aHistoryAlarmSeverity) {
        getProperty(historyAlarmSeverity).setValue(aHistoryAlarmSeverity);
    }

    public byte[] getHistoryAlarmFirstOccurTime() {
        return (byte[]) getProperty(historyAlarmFirstOccurTime).getValue();
    }

    public void setHistoryAlarmFirstOccurTime(byte[] aHistoryAlarmFirstOccurTime) {
        getProperty(historyAlarmFirstOccurTime).setValue(aHistoryAlarmFirstOccurTime);
    }

    public byte[] getHistoryAlarmLastOccurTime() {
        return (byte[]) getProperty(historyAlarmLastOccurTime).getValue();
    }

    public void setHistoryAlarmLastOccurTime(byte[] aHistoryAlarmLastOccurTime) {
        getProperty(historyAlarmLastOccurTime).setValue(aHistoryAlarmLastOccurTime);
    }

    public Long getHistoryAlarmRepeats() {
        return (Long) getProperty(historyAlarmRepeats).getValue();
    }

    public void setHistoryAlarmRepeats(Long aHistoryAlarmRepeats) {
        getProperty(historyAlarmRepeats).setValue(aHistoryAlarmRepeats);
    }

    public Long getHistoryAlarmCorrelationId() {
        return (Long) getProperty(historyAlarmCorrelationId).getValue();
    }

    public void setHistoryAlarmCorrelationId(Long aHistoryAlarmCorrelationId) {
        getProperty(historyAlarmCorrelationId).setValue(aHistoryAlarmCorrelationId);
    }

    public String getHistoryAlarmAdditionalText() {
        return (String) getProperty(historyAlarmAdditionalText).getValue();
    }

    public void setHistoryAlarmAdditionalText(String aHistoryAlarmAdditionalText) {
        getProperty(historyAlarmAdditionalText).setValue(aHistoryAlarmAdditionalText);
    }

    public byte[] getHistoryAlarmClearTime() {
        return (byte[]) getProperty(historyAlarmClearTime).getValue();
    }

    public void setHistoryAlarmClearTime(byte[] aHistoryAlarmClearTime) {
        getProperty(historyAlarmClearTime).setValue(aHistoryAlarmClearTime);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(historyAlarmCode));
        prepareRead(getProperty(historyAlarmInstance));
        prepareRead(getProperty(historyAlarmSeverity));
        prepareRead(getProperty(historyAlarmFirstOccurTime));
        prepareRead(getProperty(historyAlarmLastOccurTime));
        prepareRead(getProperty(historyAlarmRepeats));
        prepareRead(getProperty(historyAlarmCorrelationId));
        prepareRead(getProperty(historyAlarmAdditionalText));
        prepareRead(getProperty(historyAlarmClearTime));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(historyAlarmCode));
        prepareRead(getProperty(historyAlarmInstance));
        prepareRead(getProperty(historyAlarmSeverity));
        prepareRead(getProperty(historyAlarmFirstOccurTime));
        prepareRead(getProperty(historyAlarmLastOccurTime));
        prepareRead(getProperty(historyAlarmRepeats));
        prepareRead(getProperty(historyAlarmCorrelationId));
        prepareRead(getProperty(historyAlarmAdditionalText));
        prepareRead(getProperty(historyAlarmClearTime));

        return loadAll(new int[]{1, 2});
    }

}
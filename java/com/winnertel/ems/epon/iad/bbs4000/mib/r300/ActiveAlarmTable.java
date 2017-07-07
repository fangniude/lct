package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class ActiveAlarmTable extends SnmpMibBean {
    public static final String utsBbsAlarmActiveSequenceNumber = "utsBbsAlarmActiveSequenceNumber";
    public static final String utsBbsAlarmActiveProbableCause = "utsBbsAlarmActiveProbableCause";
    public static final String utsBbsAlarmActiveSpecificProblem = "utsBbsAlarmActiveSpecificProblem";
    public static final String utsBbsAlarmActiveEntityType = "utsBbsAlarmActiveEntityType";
    public static final String utsBbsAlarmActiveEntityInstance = "utsBbsAlarmActiveEntityInstance";
    public static final String utsBbsAlarmActiveFirstOccurenceTime = "utsBbsAlarmActiveFirstOccurenceTime";
    public static final String utsBbsAlarmActiveClass = "utsBbsAlarmActiveClass";
    public static final String utsBbsAlarmActiveSeverity = "utsBbsAlarmActiveSeverity";
    public static final String utsBbsAlarmActiveAcknowledge = "utsBbsAlarmActiveAcknowledge";
    public static final String utsBbsAlarmActiveAdditionalText = "utsBbsAlarmActiveAdditionalText";
    public static final String utsBbsAlarmActiveRaisingNumber = "utsBbsAlarmActiveRaisingNumber";
    public static final String utsBbsAlarmActiveLastOccurenceTime = "utsBbsAlarmActiveLastOccurenceTime";
    public static final String utsBbsAlarmActiveRepeats = "utsBbsAlarmActiveRepeats";
    public static final String utsBbsAlarmActiveVersionId = "utsBbsAlarmActiveVersionId";
    public static final String utsBbsAlarmActiveSessionId = "utsBbsAlarmActiveSessionId";

    public ActiveAlarmTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsBbsAlarmActiveSequenceNumber, new SnmpMibBeanProperty(utsBbsAlarmActiveSequenceNumber, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsBbsAlarmActiveProbableCause, new SnmpMibBeanProperty(utsBbsAlarmActiveProbableCause, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.2", ISnmpConstant.COUNTER));
        initProperty(utsBbsAlarmActiveSpecificProblem, new SnmpMibBeanProperty(utsBbsAlarmActiveSpecificProblem, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.3", ISnmpConstant.COUNTER));
        initProperty(utsBbsAlarmActiveEntityType, new SnmpMibBeanProperty(utsBbsAlarmActiveEntityType, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsBbsAlarmActiveEntityInstance, new SnmpMibBeanProperty(utsBbsAlarmActiveEntityInstance, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.5", ISnmpConstant.COUNTER));
        initProperty(utsBbsAlarmActiveFirstOccurenceTime, new SnmpMibBeanProperty(utsBbsAlarmActiveFirstOccurenceTime, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.6", ISnmpConstant.OCTETS));
        initProperty(utsBbsAlarmActiveClass, new SnmpMibBeanProperty(utsBbsAlarmActiveClass, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.7", ISnmpConstant.INTEGER));
        initProperty(utsBbsAlarmActiveSeverity, new SnmpMibBeanProperty(utsBbsAlarmActiveSeverity, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.8", ISnmpConstant.INTEGER));
        initProperty(utsBbsAlarmActiveAcknowledge, new SnmpMibBeanProperty(utsBbsAlarmActiveAcknowledge, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.9", ISnmpConstant.INTEGER));
        initProperty(utsBbsAlarmActiveAdditionalText, new SnmpMibBeanProperty(utsBbsAlarmActiveAdditionalText, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.10", ISnmpConstant.STRING));
        initProperty(utsBbsAlarmActiveRaisingNumber, new SnmpMibBeanProperty(utsBbsAlarmActiveRaisingNumber, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.11", ISnmpConstant.INTEGER));
        initProperty(utsBbsAlarmActiveLastOccurenceTime, new SnmpMibBeanProperty(utsBbsAlarmActiveLastOccurenceTime, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.12", ISnmpConstant.OCTETS));
        initProperty(utsBbsAlarmActiveRepeats, new SnmpMibBeanProperty(utsBbsAlarmActiveRepeats, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.13", ISnmpConstant.COUNTER));
        initProperty(utsBbsAlarmActiveVersionId, new SnmpMibBeanProperty(utsBbsAlarmActiveVersionId, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.14", ISnmpConstant.COUNTER));
        initProperty(utsBbsAlarmActiveSessionId, new SnmpMibBeanProperty(utsBbsAlarmActiveSessionId, ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.15", ISnmpConstant.COUNTER));

    }


    public Integer getUtsBbsAlarmActiveSequenceNumber() {
        return (Integer) getIndex(0);
    }

    public void setUtsBbsAlarmActiveSequenceNumber(Integer aUtsBbsAlarmActiveSequenceNumber) {
        setIndex(0, aUtsBbsAlarmActiveSequenceNumber);
    }


    public Integer getUtsBbsAlarmActiveRaisingNumber() {
        return (Integer) getIndex(1);
    }

    public void setUtsBbsAlarmActiveRaisingNumber(Integer aUtsBbsAlarmActiveRaisingNumber) {
        setIndex(1, aUtsBbsAlarmActiveRaisingNumber);
    }


    public Long getUtsBbsAlarmActiveProbableCause() {
        return (Long) getProperty(utsBbsAlarmActiveProbableCause).getValue();
    }

    public void setUtsBbsAlarmActiveProbableCause(Long aUtsBbsAlarmActiveProbableCause) {
        getProperty(utsBbsAlarmActiveProbableCause).setValue(aUtsBbsAlarmActiveProbableCause);
    }

    public Long getUtsBbsAlarmActiveSpecificProblem() {
        return (Long) getProperty(utsBbsAlarmActiveSpecificProblem).getValue();
    }

    public void setUtsBbsAlarmActiveSpecificProblem(Long aUtsBbsAlarmActiveSpecificProblem) {
        getProperty(utsBbsAlarmActiveSpecificProblem).setValue(aUtsBbsAlarmActiveSpecificProblem);
    }

    public Integer getUtsBbsAlarmActiveEntityType() {
        return (Integer) getProperty(utsBbsAlarmActiveEntityType).getValue();
    }

    public void setUtsBbsAlarmActiveEntityType(Integer aUtsBbsAlarmActiveEntityType) {
        getProperty(utsBbsAlarmActiveEntityType).setValue(aUtsBbsAlarmActiveEntityType);
    }

    public Long getUtsBbsAlarmActiveEntityInstance() {
        return (Long) getProperty(utsBbsAlarmActiveEntityInstance).getValue();
    }

    public void setUtsBbsAlarmActiveEntityInstance(Long aUtsBbsAlarmActiveEntityInstance) {
        getProperty(utsBbsAlarmActiveEntityInstance).setValue(aUtsBbsAlarmActiveEntityInstance);
    }

    public byte[] getUtsBbsAlarmActiveFirstOccurenceTime() {
        return (byte[]) getProperty(utsBbsAlarmActiveFirstOccurenceTime).getValue();
    }

    public void setUtsBbsAlarmActiveFirstOccurenceTime(byte[] aUtsBbsAlarmActiveFirstOccurenceTime) {
        getProperty(utsBbsAlarmActiveFirstOccurenceTime).setValue(aUtsBbsAlarmActiveFirstOccurenceTime);
    }

    public Integer getUtsBbsAlarmActiveClass() {
        return (Integer) getProperty(utsBbsAlarmActiveClass).getValue();
    }

    public void setUtsBbsAlarmActiveClass(Integer aUtsBbsAlarmActiveClass) {
        getProperty(utsBbsAlarmActiveClass).setValue(aUtsBbsAlarmActiveClass);
    }

    public Integer getUtsBbsAlarmActiveSeverity() {
        return (Integer) getProperty(utsBbsAlarmActiveSeverity).getValue();
    }

    public void setUtsBbsAlarmActiveSeverity(Integer aUtsBbsAlarmActiveSeverity) {
        getProperty(utsBbsAlarmActiveSeverity).setValue(aUtsBbsAlarmActiveSeverity);
    }

    public Integer getUtsBbsAlarmActiveAcknowledge() {
        return (Integer) getProperty(utsBbsAlarmActiveAcknowledge).getValue();
    }

    public void setUtsBbsAlarmActiveAcknowledge(Integer aUtsBbsAlarmActiveAcknowledge) {
        getProperty(utsBbsAlarmActiveAcknowledge).setValue(aUtsBbsAlarmActiveAcknowledge);
    }

    public String getUtsBbsAlarmActiveAdditionalText() {
        return (String) getProperty(utsBbsAlarmActiveAdditionalText).getValue();
    }

    public void setUtsBbsAlarmActiveAdditionalText(String aUtsBbsAlarmActiveAdditionalText) {
        getProperty(utsBbsAlarmActiveAdditionalText).setValue(aUtsBbsAlarmActiveAdditionalText);
    }

    public byte[] getUtsBbsAlarmActiveLastOccurenceTime() {
        return (byte[]) getProperty(utsBbsAlarmActiveLastOccurenceTime).getValue();
    }

    public void setUtsBbsAlarmActiveLastOccurenceTime(byte[] aUtsBbsAlarmActiveLastOccurenceTime) {
        getProperty(utsBbsAlarmActiveLastOccurenceTime).setValue(aUtsBbsAlarmActiveLastOccurenceTime);
    }

    public Long getUtsBbsAlarmActiveRepeats() {
        return (Long) getProperty(utsBbsAlarmActiveRepeats).getValue();
    }

    public void setUtsBbsAlarmActiveRepeats(Long aUtsBbsAlarmActiveRepeats) {
        getProperty(utsBbsAlarmActiveRepeats).setValue(aUtsBbsAlarmActiveRepeats);
    }

    public Long getUtsBbsAlarmActiveVersionId() {
        return (Long) getProperty(utsBbsAlarmActiveVersionId).getValue();
    }

    public void setUtsBbsAlarmActiveVersionId(Long aUtsBbsAlarmActiveVersionId) {
        getProperty(utsBbsAlarmActiveVersionId).setValue(aUtsBbsAlarmActiveVersionId);
    }

    public Long getUtsBbsAlarmActiveSessionId() {
        return (Long) getProperty(utsBbsAlarmActiveSessionId).getValue();
    }

    public void setUtsBbsAlarmActiveSessionId(Long aUtsBbsAlarmActiveSessionId) {
        getProperty(utsBbsAlarmActiveSessionId).setValue(aUtsBbsAlarmActiveSessionId);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsBbsAlarmActiveProbableCause));
        prepareRead(super.getProperty(utsBbsAlarmActiveSpecificProblem));
        prepareRead(super.getProperty(utsBbsAlarmActiveEntityType));
        prepareRead(super.getProperty(utsBbsAlarmActiveEntityInstance));
        prepareRead(super.getProperty(utsBbsAlarmActiveFirstOccurenceTime));
        prepareRead(super.getProperty(utsBbsAlarmActiveClass));
        prepareRead(super.getProperty(utsBbsAlarmActiveSeverity));
        prepareRead(super.getProperty(utsBbsAlarmActiveAcknowledge));
        prepareRead(super.getProperty(utsBbsAlarmActiveAdditionalText));
        prepareRead(super.getProperty(utsBbsAlarmActiveLastOccurenceTime));
        prepareRead(super.getProperty(utsBbsAlarmActiveRepeats));
        prepareRead(super.getProperty(utsBbsAlarmActiveVersionId));
        prepareRead(super.getProperty(utsBbsAlarmActiveSessionId));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsBbsAlarmActiveProbableCause));
        prepareRead(super.getProperty(utsBbsAlarmActiveSpecificProblem));
        prepareRead(super.getProperty(utsBbsAlarmActiveEntityType));
        prepareRead(super.getProperty(utsBbsAlarmActiveEntityInstance));
        prepareRead(super.getProperty(utsBbsAlarmActiveFirstOccurenceTime));
        prepareRead(super.getProperty(utsBbsAlarmActiveClass));
        prepareRead(super.getProperty(utsBbsAlarmActiveSeverity));
        prepareRead(super.getProperty(utsBbsAlarmActiveAcknowledge));
        prepareRead(super.getProperty(utsBbsAlarmActiveAdditionalText));
        prepareRead(super.getProperty(utsBbsAlarmActiveLastOccurenceTime));
        prepareRead(super.getProperty(utsBbsAlarmActiveRepeats));
        prepareRead(super.getProperty(utsBbsAlarmActiveVersionId));
        prepareRead(super.getProperty(utsBbsAlarmActiveSessionId));

        return loadAll(new int[]{1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsBbsAlarmActiveAcknowledge));

        return save();
    }


}

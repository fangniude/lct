package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OltGponProtocolProfTable extends SnmpMibBean {

    public static final String oltGponProtocolProfProtocolPofileIndex = "oltGponProtocolProfProtocolPofileIndex";
    public static final String oltGponProtocolProfProfileName = "oltGponProtocolProfProfileName";
    public static final String oltGponProtocolProfMinRoundTripPropagationDelay = "oltGponProtocolProfMinRoundTripPropagationDelay";
    public static final String oltGponProtocolProfMinONUResponseTime = "oltGponProtocolProfMinONUResponseTime";
    public static final String oltGponProtocolProfNumberEqDMeasurementCycle = "oltGponProtocolProfNumberEqDMeasurementCycle";
    public static final String oltGponProtocolProfDefaultPowerLevelMode = "oltGponProtocolProfDefaultPowerLevelMode";
    public static final String oltGponProtocolProfDriftControlInterval = "oltGponProtocolProfDriftControlInterval";
    public static final String oltGponProtocolProfDriftControlLimit = "oltGponProtocolProfDriftControlLimit";
    public static final String oltGponProtocolProfGuardBits = "oltGponProtocolProfGuardBits";
    public static final String oltGponProtocolProfReportingGEMBlockSize = "oltGponProtocolProfReportingGEMBlockSize";
    public static final String oltGponProtocolProfUpstreamBERInterval = "oltGponProtocolProfUpstreamBERInterval";
    public static final String oltGponProtocolProfDownstreamBERInterval = "oltGponProtocolProfDownstreamBERInterval";
    public static final String oltGponProtocolProfThresholdBERSF = "oltGponProtocolProfThresholdBERSF";
    public static final String oltGponProtocolProfThresholdBERSD = "oltGponProtocolProfThresholdBERSD";
    public static final String oltGponProtocolProfAckTimeout = "oltGponProtocolProfAckTimeout";
    public static final String oltGponProtocolProfPlsMaxAllocSize = "oltGponProtocolProfPlsMaxAllocSize";
    public static final String oltGponProtocolProfNumberTxPreamble = "oltGponProtocolProfNumberTxPreamble";
    public static final String oltGponProtocolProfPreamblePatterns = "oltGponProtocolProfPreamblePatterns";
    public static final String oltGponProtocolProfFecTxEnable = "oltGponProtocolProfFecTxEnable";
    public static final String oltGponProtocolProfKeyExchange = "oltGponProtocolProfKeyExchange";
    public static final String oltGponProtocolProfPasswordRequest = "oltGponProtocolProfPasswordRequest";
    public static final String oltGponProtocolProfDisableOnu = "oltGponProtocolProfDisableOnu";

    public OltGponProtocolProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltGponProtocolProfProtocolPofileIndex, new SnmpMibBeanProperty(oltGponProtocolProfProtocolPofileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.1", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfProfileName, new SnmpMibBeanProperty(oltGponProtocolProfProfileName, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.2", ISnmpConstant.STRING));
        initProperty(oltGponProtocolProfMinRoundTripPropagationDelay, new SnmpMibBeanProperty(oltGponProtocolProfMinRoundTripPropagationDelay, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.3", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfMinONUResponseTime, new SnmpMibBeanProperty(oltGponProtocolProfMinONUResponseTime, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.4", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfNumberEqDMeasurementCycle, new SnmpMibBeanProperty(oltGponProtocolProfNumberEqDMeasurementCycle, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.5", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfDefaultPowerLevelMode, new SnmpMibBeanProperty(oltGponProtocolProfDefaultPowerLevelMode, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.6", ISnmpConstant.INTEGER));
        initProperty(oltGponProtocolProfDriftControlInterval, new SnmpMibBeanProperty(oltGponProtocolProfDriftControlInterval, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.7", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfDriftControlLimit, new SnmpMibBeanProperty(oltGponProtocolProfDriftControlLimit, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.8", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfGuardBits, new SnmpMibBeanProperty(oltGponProtocolProfGuardBits, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.9", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfReportingGEMBlockSize, new SnmpMibBeanProperty(oltGponProtocolProfReportingGEMBlockSize, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.10", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfUpstreamBERInterval, new SnmpMibBeanProperty(oltGponProtocolProfUpstreamBERInterval, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.11", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfDownstreamBERInterval, new SnmpMibBeanProperty(oltGponProtocolProfDownstreamBERInterval, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.12", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfThresholdBERSF, new SnmpMibBeanProperty(oltGponProtocolProfThresholdBERSF, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.13", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfThresholdBERSD, new SnmpMibBeanProperty(oltGponProtocolProfThresholdBERSD, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.14", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfAckTimeout, new SnmpMibBeanProperty(oltGponProtocolProfAckTimeout, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.15", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfPlsMaxAllocSize, new SnmpMibBeanProperty(oltGponProtocolProfPlsMaxAllocSize, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.16", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfNumberTxPreamble, new SnmpMibBeanProperty(oltGponProtocolProfNumberTxPreamble, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.17", ISnmpConstant.STRING));
        initProperty(oltGponProtocolProfPreamblePatterns, new SnmpMibBeanProperty(oltGponProtocolProfPreamblePatterns, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.18", ISnmpConstant.GAUGE));
        initProperty(oltGponProtocolProfFecTxEnable, new SnmpMibBeanProperty(oltGponProtocolProfFecTxEnable, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.19", ISnmpConstant.INTEGER));
        initProperty(oltGponProtocolProfKeyExchange, new SnmpMibBeanProperty(oltGponProtocolProfKeyExchange, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.20", ISnmpConstant.INTEGER));
        initProperty(oltGponProtocolProfPasswordRequest, new SnmpMibBeanProperty(oltGponProtocolProfPasswordRequest, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.21", ISnmpConstant.INTEGER));
        initProperty(oltGponProtocolProfDisableOnu, new SnmpMibBeanProperty(oltGponProtocolProfDisableOnu, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.22", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.1.4.1.23", ISnmpConstant.INTEGER));
    }

    public Long getOltGponProtocolProfProtocolPofileIndex() {
        return (Long) getIndex(0);
    }

    public void setOltGponProtocolProfProtocolPofileIndex(Long aOltGponProtocolProfProtocolPofileIndex) {
        setIndex(0, aOltGponProtocolProfProtocolPofileIndex);
    }

    public String getOltGponProtocolProfProfileName() {
        return (String) getProperty(oltGponProtocolProfProfileName).getValue();
    }

    public void setOltGponProtocolProfProfileName(String aOltGponProtocolProfProfileName) {
        getProperty(oltGponProtocolProfProfileName).setValue(aOltGponProtocolProfProfileName);
    }

    public Long getOltGponProtocolProfMinRoundTripPropagationDelay() {
        return (Long) getProperty(oltGponProtocolProfMinRoundTripPropagationDelay).getValue();
    }

    public void setOltGponProtocolProfMinRoundTripPropagationDelay(Long aOltGponProtocolProfMinRoundTripPropagationDelay) {
        getProperty(oltGponProtocolProfMinRoundTripPropagationDelay).setValue(aOltGponProtocolProfMinRoundTripPropagationDelay);
    }

    public Long getOltGponProtocolProfMinONUResponseTime() {
        return (Long) getProperty(oltGponProtocolProfMinONUResponseTime).getValue();
    }

    public void setOltGponProtocolProfMinONUResponseTime(Long aOltGponProtocolProfMinONUResponseTime) {
        getProperty(oltGponProtocolProfMinONUResponseTime).setValue(aOltGponProtocolProfMinONUResponseTime);
    }

    public Long getOltGponProtocolProfNumberEqDMeasurementCycle() {
        return (Long) getProperty(oltGponProtocolProfNumberEqDMeasurementCycle).getValue();
    }

    public void setOltGponProtocolProfNumberEqDMeasurementCycle(Long aOltGponProtocolProfNumberEqDMeasurementCycle) {
        getProperty(oltGponProtocolProfNumberEqDMeasurementCycle).setValue(aOltGponProtocolProfNumberEqDMeasurementCycle);
    }

    public Integer getOltGponProtocolProfDefaultPowerLevelMode() {
        return (Integer) getProperty(oltGponProtocolProfDefaultPowerLevelMode).getValue();
    }

    public void setOltGponProtocolProfDefaultPowerLevelMode(Integer aOltGponProtocolProfDefaultPowerLevelMode) {
        getProperty(oltGponProtocolProfDefaultPowerLevelMode).setValue(aOltGponProtocolProfDefaultPowerLevelMode);
    }

    public Long getOltGponProtocolProfDriftControlInterval() {
        return (Long) getProperty(oltGponProtocolProfDriftControlInterval).getValue();
    }

    public void setOltGponProtocolProfDriftControlInterval(Long aOltGponProtocolProfDriftControlInterval) {
        getProperty(oltGponProtocolProfDriftControlInterval).setValue(aOltGponProtocolProfDriftControlInterval);
    }

    public Long getOltGponProtocolProfDriftControlLimit() {
        return (Long) getProperty(oltGponProtocolProfDriftControlLimit).getValue();
    }

    public void setOltGponProtocolProfDriftControlLimit(Long aOltGponProtocolProfDriftControlLimit) {
        getProperty(oltGponProtocolProfDriftControlLimit).setValue(aOltGponProtocolProfDriftControlLimit);
    }

    public Long getOltGponProtocolProfGuardBits() {
        return (Long) getProperty(oltGponProtocolProfGuardBits).getValue();
    }

    public void setOltGponProtocolProfGuardBits(Long aOltGponProtocolProfGuardBits) {
        getProperty(oltGponProtocolProfGuardBits).setValue(aOltGponProtocolProfGuardBits);
    }

    public Long getOltGponProtocolProfReportingGEMBlockSize() {
        return (Long) getProperty(oltGponProtocolProfReportingGEMBlockSize).getValue();
    }

    public void setOltGponProtocolProfReportingGEMBlockSize(Long aOltGponProtocolProfReportingGEMBlockSize) {
        getProperty(oltGponProtocolProfReportingGEMBlockSize).setValue(aOltGponProtocolProfReportingGEMBlockSize);
    }

    public Long getOltGponProtocolProfUpstreamBERInterval() {
        return (Long) getProperty(oltGponProtocolProfUpstreamBERInterval).getValue();
    }

    public void setOltGponProtocolProfUpstreamBERInterval(Long aOltGponProtocolProfUpstreamBERInterval) {
        getProperty(oltGponProtocolProfUpstreamBERInterval).setValue(aOltGponProtocolProfUpstreamBERInterval);
    }

    public Long getOltGponProtocolProfDownstreamBERInterval() {
        return (Long) getProperty(oltGponProtocolProfDownstreamBERInterval).getValue();
    }

    public void setOltGponProtocolProfDownstreamBERInterval(Long aOltGponProtocolProfDownstreamBERInterval) {
        getProperty(oltGponProtocolProfDownstreamBERInterval).setValue(aOltGponProtocolProfDownstreamBERInterval);
    }

    public Long getOltGponProtocolProfThresholdBERSF() {
        return (Long) getProperty(oltGponProtocolProfThresholdBERSF).getValue();
    }

    public void setOltGponProtocolProfThresholdBERSF(Long aOltGponProtocolProfThresholdBERSF) {
        getProperty(oltGponProtocolProfThresholdBERSF).setValue(aOltGponProtocolProfThresholdBERSF);
    }

    public Long getOltGponProtocolProfThresholdBERSD() {
        return (Long) getProperty(oltGponProtocolProfThresholdBERSD).getValue();
    }

    public void setOltGponProtocolProfThresholdBERSD(Long aOltGponProtocolProfThresholdBERSD) {
        getProperty(oltGponProtocolProfThresholdBERSD).setValue(aOltGponProtocolProfThresholdBERSD);
    }

    public Long getOltGponProtocolProfAckTimeout() {
        return (Long) getProperty(oltGponProtocolProfAckTimeout).getValue();
    }

    public void setOltGponProtocolProfAckTimeout(Long aOltGponProtocolProfAckTimeout) {
        getProperty(oltGponProtocolProfAckTimeout).setValue(aOltGponProtocolProfAckTimeout);
    }

    public Long getOltGponProtocolProfPlsMaxAllocSize() {
        return (Long) getProperty(oltGponProtocolProfPlsMaxAllocSize).getValue();
    }

    public void setOltGponProtocolProfPlsMaxAllocSize(Long aOltGponProtocolProfPlsMaxAllocSize) {
        getProperty(oltGponProtocolProfPlsMaxAllocSize).setValue(aOltGponProtocolProfPlsMaxAllocSize);
    }

    public String getOltGponProtocolProfNumberTxPreamble() {
        return (String) getProperty(oltGponProtocolProfNumberTxPreamble).getValue();
    }

    public void setOltGponProtocolProfNumberTxPreamble(String aOltGponProtocolProfNumberTxPreamble) {
        getProperty(oltGponProtocolProfNumberTxPreamble).setValue(aOltGponProtocolProfNumberTxPreamble);
    }

    public Long getOltGponProtocolProfPreamblePatterns() {
        return (Long) getProperty(oltGponProtocolProfPreamblePatterns).getValue();
    }

    public void setOltGponProtocolProfPreamblePatterns(Long aOltGponProtocolProfPreamblePatterns) {
        getProperty(oltGponProtocolProfPreamblePatterns).setValue(aOltGponProtocolProfPreamblePatterns);
    }

    public Integer getOltGponProtocolProfFecTxEnable() {
        return (Integer) getProperty(oltGponProtocolProfFecTxEnable).getValue();
    }

    public void setOltGponProtocolProfFecTxEnable(Integer aOltGponProtocolProfFecTxEnable) {
        getProperty(oltGponProtocolProfFecTxEnable).setValue(aOltGponProtocolProfFecTxEnable);
    }

    public Integer getOltGponProtocolProfKeyExchange() {
        return (Integer) getProperty(oltGponProtocolProfKeyExchange).getValue();
    }

    public void setOltGponProtocolProfKeyExchange(Integer aOltGponProtocolProfKeyExchange) {
        getProperty(oltGponProtocolProfKeyExchange).setValue(aOltGponProtocolProfKeyExchange);
    }

    public Integer getOltGponProtocolProfPasswordRequest() {
        return (Integer) getProperty(oltGponProtocolProfPasswordRequest).getValue();
    }

    public void setOltGponProtocolProfPasswordRequest(Integer aOltGponProtocolProfPasswordRequest) {
        getProperty(oltGponProtocolProfPasswordRequest).setValue(aOltGponProtocolProfPasswordRequest);
    }

    public Integer getOltGponProtocolProfDisableOnu() {
        return (Integer) getProperty(oltGponProtocolProfDisableOnu).getValue();
    }

    public void setOltGponProtocolProfDisableOnu(Integer aOltGponProtocolProfDisableOnu) {
        getProperty(oltGponProtocolProfDisableOnu).setValue(aOltGponProtocolProfDisableOnu);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(oltGponProtocolProfProfileName));
        prepareRead(getProperty(oltGponProtocolProfMinRoundTripPropagationDelay));
        prepareRead(getProperty(oltGponProtocolProfMinONUResponseTime));
        prepareRead(getProperty(oltGponProtocolProfNumberEqDMeasurementCycle));
        prepareRead(getProperty(oltGponProtocolProfDefaultPowerLevelMode));
        prepareRead(getProperty(oltGponProtocolProfDriftControlInterval));
        prepareRead(getProperty(oltGponProtocolProfDriftControlLimit));
        prepareRead(getProperty(oltGponProtocolProfGuardBits));
        prepareRead(getProperty(oltGponProtocolProfReportingGEMBlockSize));
        prepareRead(getProperty(oltGponProtocolProfUpstreamBERInterval));
        prepareRead(getProperty(oltGponProtocolProfDownstreamBERInterval));
        prepareRead(getProperty(oltGponProtocolProfThresholdBERSF));
        prepareRead(getProperty(oltGponProtocolProfThresholdBERSD));
        prepareRead(getProperty(oltGponProtocolProfAckTimeout));
        prepareRead(getProperty(oltGponProtocolProfPlsMaxAllocSize));
        prepareRead(getProperty(oltGponProtocolProfNumberTxPreamble));
        prepareRead(getProperty(oltGponProtocolProfPreamblePatterns));
        prepareRead(getProperty(oltGponProtocolProfFecTxEnable));
        prepareRead(getProperty(oltGponProtocolProfKeyExchange));
        prepareRead(getProperty(oltGponProtocolProfPasswordRequest));
        prepareRead(getProperty(oltGponProtocolProfDisableOnu));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(oltGponProtocolProfProfileName));
        prepareRead(getProperty(oltGponProtocolProfMinRoundTripPropagationDelay));
        prepareRead(getProperty(oltGponProtocolProfMinONUResponseTime));
        prepareRead(getProperty(oltGponProtocolProfNumberEqDMeasurementCycle));
        prepareRead(getProperty(oltGponProtocolProfDefaultPowerLevelMode));
        prepareRead(getProperty(oltGponProtocolProfDriftControlInterval));
        prepareRead(getProperty(oltGponProtocolProfDriftControlLimit));
        prepareRead(getProperty(oltGponProtocolProfGuardBits));
        prepareRead(getProperty(oltGponProtocolProfReportingGEMBlockSize));
        prepareRead(getProperty(oltGponProtocolProfUpstreamBERInterval));
        prepareRead(getProperty(oltGponProtocolProfDownstreamBERInterval));
        prepareRead(getProperty(oltGponProtocolProfThresholdBERSF));
        prepareRead(getProperty(oltGponProtocolProfThresholdBERSD));
        prepareRead(getProperty(oltGponProtocolProfAckTimeout));
        prepareRead(getProperty(oltGponProtocolProfPlsMaxAllocSize));
        prepareRead(getProperty(oltGponProtocolProfNumberTxPreamble));
        prepareRead(getProperty(oltGponProtocolProfPreamblePatterns));
        prepareRead(getProperty(oltGponProtocolProfFecTxEnable));
        prepareRead(getProperty(oltGponProtocolProfKeyExchange));
        prepareRead(getProperty(oltGponProtocolProfPasswordRequest));
        prepareRead(getProperty(oltGponProtocolProfDisableOnu));

        return loadAll(new int[]{2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(oltGponProtocolProfProfileName));
        prepareSave(getProperty(oltGponProtocolProfDefaultPowerLevelMode));
        prepareSave(getProperty(oltGponProtocolProfThresholdBERSF));
        prepareSave(getProperty(oltGponProtocolProfThresholdBERSD));
        prepareSave(getProperty(oltGponProtocolProfFecTxEnable));
        prepareSave(getProperty(oltGponProtocolProfKeyExchange));
        //prepareSave(getProperty(oltGponProtocolProfPasswordRequest));
        prepareSave(getProperty(oltGponProtocolProfDisableOnu));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(oltGponProtocolProfProfileName));
        prepareSave(getProperty(oltGponProtocolProfDefaultPowerLevelMode));
        prepareSave(getProperty(oltGponProtocolProfThresholdBERSF));
        prepareSave(getProperty(oltGponProtocolProfThresholdBERSD));
        prepareSave(getProperty(oltGponProtocolProfFecTxEnable));
        prepareSave(getProperty(oltGponProtocolProfKeyExchange));
        //prepareSave(getProperty(oltGponProtocolProfPasswordRequest));
        prepareSave(getProperty(oltGponProtocolProfDisableOnu));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public String toString() {
        return getOltGponProtocolProfProfileName();
    }

}
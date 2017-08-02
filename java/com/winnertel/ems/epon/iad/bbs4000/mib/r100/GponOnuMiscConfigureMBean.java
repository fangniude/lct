/**
 * Created by Zhou Chao, 2008/9/28
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuMiscConfigureMBean extends SnmpMibBean {

    public static final String onuCfgSlotNo = "onuCfgSlotNo";
    public static final String onuCfgPortNo = "onuCfgPortNo";
    public static final String onuCfgLogicalPortNo = "onuCfgLogicalPortNo";
    public static final String onuCfgBerIntervalConfiguration = "onuCfgBerIntervalConfiguration";
    public static final String onuCfgPowerLevel = "onuCfgPowerLevel";
    public static final String onuCfgTrafficManagementOption = "onuCfgTrafficManagementOption";
    public static final String onuCfgBatteryBackup = "onuCfgBatteryBackup";
    public static final String onuCfgTotalPriorityQueueNumber = "onuCfgTotalPriorityQueueNumber";
    public static final String onuCfgTotalTrafficSchedulerNumber = "onuCfgTotalTrafficSchedulerNumber";
    public static final String onuCfgTotalGEMPortNumber = "onuCfgTotalGEMPortNumber";
    public static final String onuCfgTotalTCONTNumber = "onuCfgTotalTCONTNumber";
    public static final String onuCfgTotalEthernetUNINumber = "onuCfgTotalEthernetUNINumber";
    public static final String onuCfgTotalPOTSUNINumber = "onuCfgTotalPOTSUNINumber";
    public static final String onuCfgFecTxEnable = "onuCfgFecTxEnable";
    public static final String onuCfgPiggybackDbaRep = "onuCfgPiggybackDbaRep";
    public static final String onuCfgWholeOnuDbaRep = "onuCfgWholeOnuDbaRep";

    public GponOnuMiscConfigureMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCfgSlotNo, new SnmpMibBeanProperty(onuCfgSlotNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(onuCfgPortNo, new SnmpMibBeanProperty(onuCfgPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(onuCfgLogicalPortNo, new SnmpMibBeanProperty(onuCfgLogicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(onuCfgBerIntervalConfiguration, new SnmpMibBeanProperty(onuCfgBerIntervalConfiguration, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.12", ISnmpConstant.GAUGE));
        initProperty(onuCfgPowerLevel, new SnmpMibBeanProperty(onuCfgPowerLevel, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.13", ISnmpConstant.INTEGER));
        initProperty(onuCfgTrafficManagementOption, new SnmpMibBeanProperty(onuCfgTrafficManagementOption, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.17", ISnmpConstant.INTEGER));
        initProperty(onuCfgBatteryBackup, new SnmpMibBeanProperty(onuCfgBatteryBackup, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.18", ISnmpConstant.INTEGER));
        initProperty(onuCfgTotalPriorityQueueNumber, new SnmpMibBeanProperty(onuCfgTotalPriorityQueueNumber, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.27", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalTrafficSchedulerNumber, new SnmpMibBeanProperty(onuCfgTotalTrafficSchedulerNumber, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.28", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalGEMPortNumber, new SnmpMibBeanProperty(onuCfgTotalGEMPortNumber, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.29", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalTCONTNumber, new SnmpMibBeanProperty(onuCfgTotalTCONTNumber, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.30", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalEthernetUNINumber, new SnmpMibBeanProperty(onuCfgTotalEthernetUNINumber, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.31", ISnmpConstant.GAUGE));
        initProperty(onuCfgTotalPOTSUNINumber, new SnmpMibBeanProperty(onuCfgTotalPOTSUNINumber, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.32", ISnmpConstant.GAUGE));
        initProperty(onuCfgFecTxEnable, new SnmpMibBeanProperty(onuCfgFecTxEnable, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.49", ISnmpConstant.INTEGER));
        initProperty(onuCfgPiggybackDbaRep, new SnmpMibBeanProperty(onuCfgPiggybackDbaRep, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.51", ISnmpConstant.INTEGER));
        initProperty(onuCfgWholeOnuDbaRep, new SnmpMibBeanProperty(onuCfgWholeOnuDbaRep, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.52", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.1.5.1.57", ISnmpConstant.INTEGER));
    }

    public Integer getOnuCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuCfgSlotNo(Integer aOnuCfgSlotNo) {
        setIndex(0, aOnuCfgSlotNo);
    }

    public Integer getOnuCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuCfgPortNo(Integer aOnuCfgPortNo) {
        setIndex(1, aOnuCfgPortNo);
    }

    public Integer getOnuCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuCfgLogicalPortNo(Integer aOnuCfgLogicalPortNo) {
        setIndex(2, aOnuCfgLogicalPortNo);
    }

    public Long getOnuCfgBerIntervalConfiguration() {
        return (Long) getProperty(onuCfgBerIntervalConfiguration).getValue();
    }

    public void setOnuCfgBerIntervalConfiguration(Long aOnuCfgBerIntervalConfiguration) {
        getProperty(onuCfgBerIntervalConfiguration).setValue(aOnuCfgBerIntervalConfiguration);
    }

    public Integer getOnuCfgPowerLevel() {
        return (Integer) getProperty(onuCfgPowerLevel).getValue();
    }

    public void setOnuCfgPowerLevel(Integer aOnuCfgPowerLevel) {
        getProperty(onuCfgPowerLevel).setValue(aOnuCfgPowerLevel);
    }

    public Integer getOnuCfgTrafficManagementOption() {
        return (Integer) getProperty(onuCfgTrafficManagementOption).getValue();
    }

    public void setOnuCfgTrafficManagementOption(Integer aOnuCfgTrafficManagementOption) {
        getProperty(onuCfgTrafficManagementOption).setValue(aOnuCfgTrafficManagementOption);
    }

    public Integer getOnuCfgBatteryBackup() {
        return (Integer) getProperty(onuCfgBatteryBackup).getValue();
    }

    public void setOnuCfgBatteryBackup(Integer aOnuCfgBatteryBackup) {
        getProperty(onuCfgBatteryBackup).setValue(aOnuCfgBatteryBackup);
    }

    public Long getOnuCfgTotalPriorityQueueNumber() {
        return (Long) getProperty(onuCfgTotalPriorityQueueNumber).getValue();
    }

    public void setOnuCfgTotalPriorityQueueNumber(Long aOnuCfgTotalPriorityQueueNumber) {
        getProperty(onuCfgTotalPriorityQueueNumber).setValue(aOnuCfgTotalPriorityQueueNumber);
    }

    public Long getOnuCfgTotalTrafficSchedulerNumber() {
        return (Long) getProperty(onuCfgTotalTrafficSchedulerNumber).getValue();
    }

    public void setOnuCfgTotalTrafficSchedulerNumber(Long aOnuCfgTotalTrafficSchedulerNumber) {
        getProperty(onuCfgTotalTrafficSchedulerNumber).setValue(aOnuCfgTotalTrafficSchedulerNumber);
    }

    public Long getOnuCfgTotalGEMPortNumber() {
        return (Long) getProperty(onuCfgTotalGEMPortNumber).getValue();
    }

    public void setOnuCfgTotalGEMPortNumber(Long aOnuCfgTotalGEMPortNumber) {
        getProperty(onuCfgTotalGEMPortNumber).setValue(aOnuCfgTotalGEMPortNumber);
    }

    public Long getOnuCfgTotalTCONTNumber() {
        return (Long) getProperty(onuCfgTotalTCONTNumber).getValue();
    }

    public void setOnuCfgTotalTCONTNumber(Long aOnuCfgTotalTCONTNumber) {
        getProperty(onuCfgTotalTCONTNumber).setValue(aOnuCfgTotalTCONTNumber);
    }

    public Long getOnuCfgTotalEthernetUNINumber() {
        return (Long) getProperty(onuCfgTotalEthernetUNINumber).getValue();
    }

    public void setOnuCfgTotalEthernetUNINumber(Long aOnuCfgTotalEthernetUNINumber) {
        getProperty(onuCfgTotalEthernetUNINumber).setValue(aOnuCfgTotalEthernetUNINumber);
    }

    public Long getOnuCfgTotalPOTSUNINumber() {
        return (Long) getProperty(onuCfgTotalPOTSUNINumber).getValue();
    }

    public void setOnuCfgTotalPOTSUNINumber(Long aOnuCfgTotalPOTSUNINumber) {
        getProperty(onuCfgTotalPOTSUNINumber).setValue(aOnuCfgTotalPOTSUNINumber);
    }

    public Integer getOnuCfgFecTxEnable() {
        return (Integer) getProperty(onuCfgFecTxEnable).getValue();
    }

    public void setOnuCfgFecTxEnable(Integer aOnuCfgFecTxEnable) {
        getProperty(onuCfgFecTxEnable).setValue(aOnuCfgFecTxEnable);
    }

    public Integer getOnuCfgPiggybackDbaRep() {
        return (Integer) getProperty(onuCfgPiggybackDbaRep).getValue();
    }

    public void setOnuCfgPiggybackDbaRep(Integer aOnuCfgPiggybackDbaRep) {
        getProperty(onuCfgPiggybackDbaRep).setValue(aOnuCfgPiggybackDbaRep);
    }

    public Integer getOnuCfgWholeOnuDbaRep() {
        return (Integer) getProperty(onuCfgWholeOnuDbaRep).getValue();
    }

    public void setOnuCfgWholeOnuDbaRep(Integer aOnuCfgWholeOnuDbaRep) {
        getProperty(onuCfgWholeOnuDbaRep).setValue(aOnuCfgWholeOnuDbaRep);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuCfgBerIntervalConfiguration));
        prepareRead(getProperty(onuCfgPowerLevel));
        prepareRead(getProperty(onuCfgTrafficManagementOption));
        prepareRead(getProperty(onuCfgBatteryBackup));
        prepareRead(getProperty(onuCfgTotalPriorityQueueNumber));
        prepareRead(getProperty(onuCfgTotalTrafficSchedulerNumber));
        prepareRead(getProperty(onuCfgTotalGEMPortNumber));
        prepareRead(getProperty(onuCfgTotalTCONTNumber));
        prepareRead(getProperty(onuCfgTotalEthernetUNINumber));
        prepareRead(getProperty(onuCfgTotalPOTSUNINumber));
        prepareRead(getProperty(onuCfgFecTxEnable));
        prepareRead(getProperty(onuCfgPiggybackDbaRep));
        prepareRead(getProperty(onuCfgWholeOnuDbaRep));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuCfgBerIntervalConfiguration));
        prepareRead(getProperty(onuCfgPowerLevel));
        prepareRead(getProperty(onuCfgTrafficManagementOption));
        prepareRead(getProperty(onuCfgBatteryBackup));
        prepareRead(getProperty(onuCfgTotalPriorityQueueNumber));
        prepareRead(getProperty(onuCfgTotalTrafficSchedulerNumber));
        prepareRead(getProperty(onuCfgTotalGEMPortNumber));
        prepareRead(getProperty(onuCfgTotalTCONTNumber));
        prepareRead(getProperty(onuCfgTotalEthernetUNINumber));
        prepareRead(getProperty(onuCfgTotalPOTSUNINumber));
        prepareRead(getProperty(onuCfgFecTxEnable));
        prepareRead(getProperty(onuCfgPiggybackDbaRep));
        prepareRead(getProperty(onuCfgWholeOnuDbaRep));

        setRowsPerFetch(50);
        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuCfgBerIntervalConfiguration));
        prepareSave(getProperty(onuCfgBatteryBackup));
        prepareSave(getProperty(onuCfgFecTxEnable));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuCfgBerIntervalConfiguration));
        prepareSave(getProperty(onuCfgBatteryBackup));
        prepareSave(getProperty(onuCfgFecTxEnable));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}
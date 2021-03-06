package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EponModuleBoardSummaryTable extends SnmpMibBean {

    public static final String utsEponModuleBoardPhyId = "utsEponModuleBoardPhyId";
    public static final String utsEponModuleBoardType = "utsEponModuleBoardType";
    public static final String utsEponModulePhyPresenceStat = "utsEponModulePhyPresenceStat";
    public static final String utsEponModuleAdminState = "utsEponModuleAdminState";
    public static final String utsEponModuleOperationState = "utsEponModuleOperationState";
    public static final String utsEponModuleRedundancyState = "utsEponModuleRedundancyState";
    public static final String utsEponModulePhyicalUptime = "utsEponModulePhyicalUptime";
    public static final String utsEponOpStateUptime = "utsEponOpStateUptime";
    public static final String utsEponModuleCSMSwitchtime = "utsEponModuleCSMSwitchtime";
    public static final String utsEponModuleBoardSwVer = "utsEponModuleBoardSwVer";
    public static final String utsEponModuleBoardBootromVer = "utsEponModuleBoardBootromVer";
    public static final String utsEponModuleBoardPassaveVer = "utsEponModuleBoardPassaveVer";
    public static final String utsEponModuleBoardCurTemp = "utsEponModuleBoardCurTemp";
    public static final String utsEponModuleBoardTempUpLimit = "utsEponModuleBoardTempUpLimit";
    public static final String utsEponModuleBoardTempUpClearLimit = "utsEponModuleBoardTempUpClearLimit";
    public static final String utsEponModuleBoardLastAdminStateChangetime = "utsEponModuleBoardLastAdminStateChangetime";
    public static final String utsEponModuleBoardLastOperationStateChangetime = "utsEponModuleBoardLastOperationStateChangetime";
    public static final String utsEponModuleBoardDisableCause = "utsEponModuleBoardDisableCause";
    public static final String utsEponModuleBoardHwVer = "utsEponModuleBoardHwVer";
    public static final String utsEponModuleBoardCpldVer = "utsEponModuleBoardCpldVer";
    public static final String utsEponModuleBoardSerialNumber = "utsEponModuleBoardSerialNumber";
    public static final String utsEponModuleBoard2424Information = "utsEponModuleBoard2424Information";
    public static final String utsEponModuleBoardCpuUtil = "utsEponModuleBoardCpuUtil";
    public static final String utsEponModuleBoardMemUtil = "utsEponModuleBoardMemUtil";

    public EponModuleBoardSummaryTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsEponModuleBoardPhyId, new SnmpMibBeanProperty(utsEponModuleBoardPhyId, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleBoardType, new SnmpMibBeanProperty(utsEponModuleBoardType, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsEponModulePhyPresenceStat, new SnmpMibBeanProperty(utsEponModulePhyPresenceStat, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleAdminState, new SnmpMibBeanProperty(utsEponModuleAdminState, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleOperationState, new SnmpMibBeanProperty(utsEponModuleOperationState, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.5", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleRedundancyState, new SnmpMibBeanProperty(utsEponModuleRedundancyState, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.6", ISnmpConstant.INTEGER));
        initProperty(utsEponModulePhyicalUptime, new SnmpMibBeanProperty(utsEponModulePhyicalUptime, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.8", ISnmpConstant.TIME_TICKS));
        initProperty(utsEponOpStateUptime, new SnmpMibBeanProperty(utsEponOpStateUptime, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.9", ISnmpConstant.TIME_TICKS));
        initProperty(utsEponModuleCSMSwitchtime, new SnmpMibBeanProperty(utsEponModuleCSMSwitchtime, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.11", ISnmpConstant.TIME_TICKS));
        initProperty(utsEponModuleBoardSwVer, new SnmpMibBeanProperty(utsEponModuleBoardSwVer, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.12", ISnmpConstant.STRING));
        initProperty(utsEponModuleBoardBootromVer, new SnmpMibBeanProperty(utsEponModuleBoardBootromVer, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.13", ISnmpConstant.STRING));
        initProperty(utsEponModuleBoardPassaveVer, new SnmpMibBeanProperty(utsEponModuleBoardPassaveVer, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.14", ISnmpConstant.STRING));
        initProperty(utsEponModuleBoardCurTemp, new SnmpMibBeanProperty(utsEponModuleBoardCurTemp, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.15", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleBoardTempUpLimit, new SnmpMibBeanProperty(utsEponModuleBoardTempUpLimit, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.16", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleBoardTempUpClearLimit, new SnmpMibBeanProperty(utsEponModuleBoardTempUpClearLimit, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.17", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleBoardLastAdminStateChangetime, new SnmpMibBeanProperty(utsEponModuleBoardLastAdminStateChangetime, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.18", ISnmpConstant.TIME_TICKS));
        initProperty(utsEponModuleBoardLastOperationStateChangetime, new SnmpMibBeanProperty(utsEponModuleBoardLastOperationStateChangetime, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.19", ISnmpConstant.TIME_TICKS));
        initProperty(utsEponModuleBoardDisableCause, new SnmpMibBeanProperty(utsEponModuleBoardDisableCause, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.20", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleBoardHwVer, new SnmpMibBeanProperty(utsEponModuleBoardHwVer, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.21", ISnmpConstant.STRING));
        initProperty(utsEponModuleBoardCpldVer, new SnmpMibBeanProperty(utsEponModuleBoardCpldVer, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.22", ISnmpConstant.STRING));
        initProperty(utsEponModuleBoardSerialNumber, new SnmpMibBeanProperty(utsEponModuleBoardSerialNumber, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.23", ISnmpConstant.STRING));
        initProperty(utsEponModuleBoard2424Information, new SnmpMibBeanProperty(utsEponModuleBoard2424Information, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.24", ISnmpConstant.STRING));
        initProperty(utsEponModuleBoardCpuUtil, new SnmpMibBeanProperty(utsEponModuleBoardCpuUtil, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.27", ISnmpConstant.INTEGER));
        initProperty(utsEponModuleBoardMemUtil, new SnmpMibBeanProperty(utsEponModuleBoardMemUtil, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.28", ISnmpConstant.INTEGER));
    }

    public Integer getUtsEponModuleBoardPhyId() {
        return (Integer) getIndex(0);
    }

    public void setUtsEponModuleBoardPhyId(Integer aUtsEponModuleBoardPhyId) {
        setIndex(0, aUtsEponModuleBoardPhyId);
    }

    public Integer getUtsEponModuleBoardType() {
        return (Integer) getProperty(utsEponModuleBoardType).getValue();
    }

    public void setUtsEponModuleBoardType(Integer aUtsEponModuleBoardType) {
        getProperty(utsEponModuleBoardType).setValue(aUtsEponModuleBoardType);
    }

    public Integer getUtsEponModulePhyPresenceStat() {
        return (Integer) getProperty(utsEponModulePhyPresenceStat).getValue();
    }

    public void setUtsEponModulePhyPresenceStat(Integer aUtsEponModulePhyPresenceStat) {
        getProperty(utsEponModulePhyPresenceStat).setValue(aUtsEponModulePhyPresenceStat);
    }

    public Integer getUtsEponModuleAdminState() {
        return (Integer) getProperty(utsEponModuleAdminState).getValue();
    }

    public void setUtsEponModuleAdminState(Integer aUtsEponModuleAdminState) {
        getProperty(utsEponModuleAdminState).setValue(aUtsEponModuleAdminState);
    }

    public Integer getUtsEponModuleOperationState() {
        int card = 0;
        if (getUtsEponModuleBoardPhyId() != null) {
            card = getUtsEponModuleBoardPhyId();
        }
        if (card == 13 || card == 14) {
            if (getProperty(utsEponModuleRedundancyState) != null) {
                int state = getUtsEponModuleRedundancyState();
                state += 1;
                return new Integer(state);
            }
            return new Integer(2);
        } else {
            return (Integer) getProperty(utsEponModuleOperationState).getValue();
        }
    }

    public void setUtsEponModuleOperationState(Integer aUtsEponModuleOperationState) {
        getProperty(utsEponModuleOperationState).setValue(aUtsEponModuleOperationState);
    }

    public Integer getUtsEponModuleRedundancyState() {
        return (Integer) getProperty(utsEponModuleRedundancyState).getValue();
    }

    public void setUtsEponModuleRedundancyState(Integer aUtsEponModuleRedundancyState) {
        getProperty(utsEponModuleRedundancyState).setValue(aUtsEponModuleRedundancyState);
    }

    public Long getUtsEponModulePhyicalUptime() {
        return (Long) getProperty(utsEponModulePhyicalUptime).getValue();
    }

    public void setUtsEponModulePhyicalUptime(Long aUtsEponModulePhyicalUptime) {
        getProperty(utsEponModulePhyicalUptime).setValue(aUtsEponModulePhyicalUptime);
    }

    public Long getUtsEponOpStateUptime() {
        return (Long) getProperty(utsEponOpStateUptime).getValue();
    }

    public void setUtsEponOpStateUptime(Long aUtsEponOpStateUptime) {
        getProperty(utsEponOpStateUptime).setValue(aUtsEponOpStateUptime);
    }

    public Long getUtsEponModuleCSMSwitchtime() {
        return (Long) getProperty(utsEponModuleCSMSwitchtime).getValue();
    }

    public void setUtsEponModuleCSMSwitchtime(Long aUtsEponModuleCSMSwitchtime) {
        getProperty(utsEponModuleCSMSwitchtime).setValue(aUtsEponModuleCSMSwitchtime);
    }

    public String getUtsEponModuleBoardSwVer() {
        return (String) getProperty(utsEponModuleBoardSwVer).getValue();
    }

    public void setUtsEponModuleBoardSwVer(String aUtsEponModuleBoardSwVer) {
        getProperty(utsEponModuleBoardSwVer).setValue(aUtsEponModuleBoardSwVer);
    }

    public String getUtsEponModuleBoardBootromVer() {
        return (String) getProperty(utsEponModuleBoardBootromVer).getValue();
    }

    public void setUtsEponModuleBoardBootromVer(String aUtsEponModuleBoardBootromVer) {
        getProperty(utsEponModuleBoardBootromVer).setValue(aUtsEponModuleBoardBootromVer);
    }

    public String getUtsEponModuleBoardPassaveVer() {
        return (String) getProperty(utsEponModuleBoardPassaveVer).getValue();
    }

    public void setUtsEponModuleBoardPassaveVer(String aUtsEponModuleBoardPassaveVer) {
        getProperty(utsEponModuleBoardPassaveVer).setValue(aUtsEponModuleBoardPassaveVer);
    }

    public Integer getUtsEponModuleBoardCurTemp() {
        return (Integer) getProperty(utsEponModuleBoardCurTemp).getValue();
    }

    public void setUtsEponModuleBoardCurTemp(Integer aUtsEponModuleBoardCurTemp) {
        getProperty(utsEponModuleBoardCurTemp).setValue(aUtsEponModuleBoardCurTemp);
    }

    public Integer getUtsEponModuleBoardTempUpLimit() {
        return (Integer) getProperty(utsEponModuleBoardTempUpLimit).getValue();
    }

    public void setUtsEponModuleBoardTempUpLimit(Integer aUtsEponModuleBoardTempUpLimit) {
        getProperty(utsEponModuleBoardTempUpLimit).setValue(aUtsEponModuleBoardTempUpLimit);
    }

    public Integer getUtsEponModuleBoardTempUpClearLimit() {
        return (Integer) getProperty(utsEponModuleBoardTempUpClearLimit).getValue();
    }

    public void setUtsEponModuleBoardTempUpClearLimit(Integer aUtsEponModuleBoardTempUpClearLimit) {
        getProperty(utsEponModuleBoardTempUpClearLimit).setValue(aUtsEponModuleBoardTempUpClearLimit);
    }

    public Long getUtsEponModuleBoardLastAdminStateChangetime() {
        return (Long) getProperty(utsEponModuleBoardLastAdminStateChangetime).getValue();
    }

    public void setUtsEponModuleBoardLastAdminStateChangetime(Long aUtsEponModuleBoardLastAdminStateChangetime) {
        getProperty(utsEponModuleBoardLastAdminStateChangetime).setValue(aUtsEponModuleBoardLastAdminStateChangetime);
    }

    public Long getUtsEponModuleBoardLastOperationStateChangetime() {
        return (Long) getProperty(utsEponModuleBoardLastOperationStateChangetime).getValue();
    }

    public void setUtsEponModuleBoardLastOperationStateChangetime(Long aUtsEponModuleBoardLastOperationStateChangetime) {
        getProperty(utsEponModuleBoardLastOperationStateChangetime).setValue(aUtsEponModuleBoardLastOperationStateChangetime);
    }

    public Integer getUtsEponModuleBoardDisableCause() {
        return (Integer) getProperty(utsEponModuleBoardDisableCause).getValue();
    }

    public void setUtsEponModuleBoardDisableCause(Integer aUtsEponModuleBoardDisableCause) {
        getProperty(utsEponModuleBoardDisableCause).setValue(aUtsEponModuleBoardDisableCause);
    }

    public String getUtsEponModuleBoardHwVer() {
        return (String) getProperty(utsEponModuleBoardHwVer).getValue();
    }

    public void setUtsEponModuleBoardHwVer(String aUtsEponModuleBoardHwVer) {
        getProperty(utsEponModuleBoardHwVer).setValue(aUtsEponModuleBoardHwVer);
    }

    public String getUtsEponModuleBoardCpldVer() {
        return (String) getProperty(utsEponModuleBoardCpldVer).getValue();
    }

    public void setUtsEponModuleBoardCpldVer(String aUtsEponModuleBoardCpldVer) {
        getProperty(utsEponModuleBoardCpldVer).setValue(aUtsEponModuleBoardCpldVer);
    }

    public String getUtsEponModuleBoardSerialNumber() {
        return (String) getProperty(utsEponModuleBoardSerialNumber).getValue();
    }

    public void setUtsEponModuleBoardSerialNumber(String aUtsEponModuleBoardSerialNumber) {
        getProperty(utsEponModuleBoardSerialNumber).setValue(aUtsEponModuleBoardSerialNumber);
    }

    public String getUtsEponModuleBoard2424Information() {
        return (String) getProperty(utsEponModuleBoard2424Information).getValue();
    }

    public void setUtsEponModuleBoard2424Information(String aUtsEponModuleBoard2424Information) {
        getProperty(utsEponModuleBoard2424Information).setValue(aUtsEponModuleBoard2424Information);
    }

    public Integer getUtsEponModuleBoardCpuUtil() {
        return (Integer) getProperty(utsEponModuleBoardCpuUtil).getValue();
    }

    public void setUtsEponModuleBoardCpuUtil(Integer autsEponModuleBoardCpuUtil) {
        getProperty(utsEponModuleBoardCpuUtil).setValue(autsEponModuleBoardCpuUtil);
    }

    public Integer getUtsEponModuleBoardMemUtil() {
        return (Integer) getProperty(utsEponModuleBoardMemUtil).getValue();
    }

    public void setUtsEponModuleBoardMemUtil(Integer autsEponModuleBoardMemUtil) {
        getProperty(utsEponModuleBoardMemUtil).setValue(autsEponModuleBoardMemUtil);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsEponModuleBoardType));
        prepareRead(getProperty(utsEponModulePhyPresenceStat));
        prepareRead(getProperty(utsEponModuleAdminState));
        prepareRead(getProperty(utsEponModuleOperationState));
        prepareRead(getProperty(utsEponModuleRedundancyState));
        prepareRead(getProperty(utsEponModulePhyicalUptime));
        prepareRead(getProperty(utsEponOpStateUptime));
        prepareRead(getProperty(utsEponModuleCSMSwitchtime));
        prepareRead(getProperty(utsEponModuleBoardSwVer));
        prepareRead(getProperty(utsEponModuleBoardBootromVer));
        prepareRead(getProperty(utsEponModuleBoardPassaveVer));
        prepareRead(getProperty(utsEponModuleBoardCurTemp));
        prepareRead(getProperty(utsEponModuleBoardTempUpLimit));
        prepareRead(getProperty(utsEponModuleBoardTempUpClearLimit));
        prepareRead(getProperty(utsEponModuleBoardLastAdminStateChangetime));
        prepareRead(getProperty(utsEponModuleBoardLastOperationStateChangetime));
        prepareRead(getProperty(utsEponModuleBoardDisableCause));
        prepareRead(getProperty(utsEponModuleBoardHwVer));
        prepareRead(getProperty(utsEponModuleBoardCpldVer));
        prepareRead(getProperty(utsEponModuleBoardSerialNumber));
        prepareRead(getProperty(utsEponModuleBoard2424Information));
        prepareRead(getProperty(utsEponModuleBoardCpuUtil));
        prepareRead(getProperty(utsEponModuleBoardMemUtil));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsEponModuleBoardType));
        prepareRead(getProperty(utsEponModulePhyPresenceStat));
        prepareRead(getProperty(utsEponModuleAdminState));
        prepareRead(getProperty(utsEponModuleOperationState));
        prepareRead(getProperty(utsEponModuleRedundancyState));
        prepareRead(getProperty(utsEponModulePhyicalUptime));
        prepareRead(getProperty(utsEponOpStateUptime));
        prepareRead(getProperty(utsEponModuleCSMSwitchtime));
        prepareRead(getProperty(utsEponModuleBoardSwVer));
        prepareRead(getProperty(utsEponModuleBoardBootromVer));
        prepareRead(getProperty(utsEponModuleBoardPassaveVer));
        prepareRead(getProperty(utsEponModuleBoardCurTemp));
        prepareRead(getProperty(utsEponModuleBoardTempUpLimit));
        prepareRead(getProperty(utsEponModuleBoardTempUpClearLimit));
        prepareRead(getProperty(utsEponModuleBoardLastAdminStateChangetime));
        prepareRead(getProperty(utsEponModuleBoardLastOperationStateChangetime));
        prepareRead(getProperty(utsEponModuleBoardDisableCause));
        prepareRead(getProperty(utsEponModuleBoardHwVer));
        prepareRead(getProperty(utsEponModuleBoardCpldVer));
        prepareRead(getProperty(utsEponModuleBoardSerialNumber));
        prepareRead(getProperty(utsEponModuleBoard2424Information));
        prepareRead(getProperty(utsEponModuleBoardCpuUtil));
        prepareRead(getProperty(utsEponModuleBoardMemUtil));

        //filter all the non-installed module.
        Vector all = loadAll(new int[]{1});
        int i = 0;
        while (i < all.size()) {
            EponModuleBoardSummaryTable bean = (EponModuleBoardSummaryTable) all.get(i);
            if (bean.getUtsEponModulePhyPresenceStat() == 2) { // not -installed
                all.remove(i);
            } else {
                i++;
            }
        }

        return all;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsEponModuleAdminState));
        prepareSave(getProperty(utsEponModuleBoardTempUpLimit));
        prepareSave(getProperty(utsEponModuleBoardTempUpClearLimit));

        return save();
    }

    public boolean reset() throws MibBeanException {
        setUtsEponModuleAdminState(new Integer(8));
        prepareSave(getProperty(utsEponModuleAdminState));

        return save();
    }

    //added by Zhou Chao, 2010/5/14
    public boolean resetForce() throws MibBeanException {
        setUtsEponModuleAdminState(new Integer(9));
        prepareSave(getProperty(utsEponModuleAdminState));

        return save();
    }

    public String toString() {
        return "Card" + getIndex(0);
    }

}
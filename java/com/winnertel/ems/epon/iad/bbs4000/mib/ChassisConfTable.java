package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The EponModuleBoardTable class.
 * Created by QuickDVM
 */
public class ChassisConfTable extends SnmpMibBean {
    public static final String utsBBSChassisPwrType = "utsBBSChassisPwrType";
    public static final String utsBBSChassisPwrLowSlot = "utsBBSChassisPwrLowSlot";
    public static final String utsBBSChassisPwrHighSlot = "utsBBSChassisPwrHighSlot";
    public static final String utsBBSChassisInternalPowerStat = "utsBBSChassisInternalPowerStat";
    public static final String utsBBSChassisFanTrayStat = "utsBBSChassisFanTrayStat";
    public static final String utsBBSChassisTempCur = "utsBBSChassisTempCur";
    public static final String utsBBSChassisTempUpLimit = "utsBBSChassisTempUpLimit";
    public static final String utsBBSChassisLeftFanTrayStat = "utsBBSChassisLeftFanTrayStat";
    public static final String utsBBSChassisMiddleFanTrayStat = "utsBBSChassisMiddleFanTrayStat";
    public static final String utsBBSChassisRightFanTrayStat = "utsBBSChassisRightFanTrayStat";

    public ChassisConfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsBBSChassisPwrType, new SnmpMibBeanProperty(utsBBSChassisPwrType, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.1", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisPwrLowSlot, new SnmpMibBeanProperty(utsBBSChassisPwrLowSlot, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.2", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisPwrHighSlot, new SnmpMibBeanProperty(utsBBSChassisPwrHighSlot, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.3", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisInternalPowerStat, new SnmpMibBeanProperty(utsBBSChassisInternalPowerStat, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.4", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisFanTrayStat, new SnmpMibBeanProperty(utsBBSChassisFanTrayStat, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.5", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisTempCur, new SnmpMibBeanProperty(utsBBSChassisTempCur, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.6", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisTempUpLimit, new SnmpMibBeanProperty(utsBBSChassisTempUpLimit, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.7", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisLeftFanTrayStat, new SnmpMibBeanProperty(utsBBSChassisLeftFanTrayStat, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.8", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisMiddleFanTrayStat, new SnmpMibBeanProperty(utsBBSChassisMiddleFanTrayStat, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.9", ISnmpConstant.INTEGER));
        initProperty(utsBBSChassisRightFanTrayStat, new SnmpMibBeanProperty(utsBBSChassisRightFanTrayStat, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.4.10", ISnmpConstant.INTEGER));
    }


    public Integer getUtsBBSChassisPwrType() {
      return (Integer) getProperty(utsBBSChassisPwrType).getValue();
    }

    public void setUtsBBSChassisPwrType(Integer aUtsBBSChassisPwrType) {
      getProperty(utsBBSChassisPwrType).setValue(aUtsBBSChassisPwrType);
    }


    public Integer getUtsBBSChassisPwrLowSlot() {
        return (Integer) getProperty(utsBBSChassisPwrLowSlot).getValue();
    }

    public void setUtsBBSChassisPwrLowSlot(Integer aUtsBBSChassisPwrLowSlot) {
        getProperty(utsBBSChassisPwrLowSlot).setValue(aUtsBBSChassisPwrLowSlot);
    }

    public Integer getUtsBBSChassisPwrHighSlot() {
        return (Integer) getProperty(utsBBSChassisPwrHighSlot).getValue();
    }

    public void setUtsBBSChassisPwrHighSlot(Integer aUtsBBSChassisPwrHighSlot) {
        getProperty(utsBBSChassisPwrHighSlot).setValue(aUtsBBSChassisPwrHighSlot);
    }

    public Integer getUtsBBSChassisInternalPowerStat() {
        return (Integer) getProperty(utsBBSChassisInternalPowerStat).getValue();
    }

    public void setUtsBBSChassisInternalPowerStat(Integer aUtsBBSChassisInternalPowerStat) {
        getProperty(utsBBSChassisInternalPowerStat).setValue(aUtsBBSChassisInternalPowerStat);
    }

    public Integer getUtsBBSChassisFanTrayStat() {
        return (Integer) getProperty(utsBBSChassisFanTrayStat).getValue();
    }

    public void setUtsBBSChassisFanTrayStat(Integer aUtsBBSChassisFanTrayStat) {
        getProperty(utsBBSChassisFanTrayStat).setValue(aUtsBBSChassisFanTrayStat);
    }

    public Integer getUtsBBSChassisTempCur() {
        return (Integer) getProperty(utsBBSChassisTempCur).getValue();
    }

    public void setUtsBBSChassisTempCur(Integer aUtsBBSChassisTempCur) {
        getProperty(utsBBSChassisTempCur).setValue(aUtsBBSChassisTempCur);
    }

    public Integer getUtsBBSChassisTempUpLimit() {
        return (Integer) getProperty(utsBBSChassisTempUpLimit).getValue();
    }

    public void setUtsBBSChassisTempUpLimit(Integer aUtsBBSChassisTempUpLimit) {
        getProperty(utsBBSChassisTempUpLimit).setValue(aUtsBBSChassisTempUpLimit);
    }

    public Integer getUtsBBSChassisLeftFanTrayStat() {
        return (Integer) getProperty(utsBBSChassisLeftFanTrayStat).getValue();
    }

    public void setUtsBBSChassisLeftFanTrayStat(Integer aUtsBBSChassisLeftFanTrayStat) {
        getProperty(utsBBSChassisLeftFanTrayStat).setValue(aUtsBBSChassisLeftFanTrayStat);
    }

    public Integer getUtsBBSChassisMiddleFanTrayStat() {
        return (Integer) getProperty(utsBBSChassisMiddleFanTrayStat).getValue();
    }

    public void setUtsBBSChassisMiddleFanTrayStat(Integer aUtsBBSChassisMiddleFanTrayStat) {
        getProperty(utsBBSChassisMiddleFanTrayStat).setValue(aUtsBBSChassisMiddleFanTrayStat);
    }

    public Integer getUtsBBSChassisRightFanTrayStat() {
        return (Integer) getProperty(utsBBSChassisRightFanTrayStat).getValue();
    }

    public void setUtsBBSChassisRightFanTrayStat(Integer aUtsBBSChassisRightFanTrayStat) {
        getProperty(utsBBSChassisRightFanTrayStat).setValue(aUtsBBSChassisRightFanTrayStat);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsBBSChassisPwrType));
        prepareRead(super.getProperty(utsBBSChassisPwrLowSlot));
        prepareRead(super.getProperty(utsBBSChassisPwrHighSlot));
        prepareRead(super.getProperty(utsBBSChassisInternalPowerStat));
        prepareRead(super.getProperty(utsBBSChassisFanTrayStat));
        prepareRead(super.getProperty(utsBBSChassisTempCur));
        prepareRead(super.getProperty(utsBBSChassisTempUpLimit));
        prepareRead(super.getProperty(utsBBSChassisLeftFanTrayStat));
        prepareRead(super.getProperty(utsBBSChassisMiddleFanTrayStat));
        prepareRead(super.getProperty(utsBBSChassisRightFanTrayStat));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsBBSChassisPwrType));
        prepareRead(super.getProperty(utsBBSChassisPwrLowSlot));
        prepareRead(super.getProperty(utsBBSChassisPwrHighSlot));
        prepareRead(super.getProperty(utsBBSChassisInternalPowerStat));
        prepareRead(super.getProperty(utsBBSChassisFanTrayStat));
        prepareRead(super.getProperty(utsBBSChassisTempCur));
        prepareRead(super.getProperty(utsBBSChassisTempUpLimit));
        prepareRead(super.getProperty(utsBBSChassisLeftFanTrayStat));
        prepareRead(super.getProperty(utsBBSChassisMiddleFanTrayStat));
        prepareRead(super.getProperty(utsBBSChassisRightFanTrayStat));

        return loadAll(new int[]{1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsBBSChassisTempUpLimit));

        return save();
    }


}

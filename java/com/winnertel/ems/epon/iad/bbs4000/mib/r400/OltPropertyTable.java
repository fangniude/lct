package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OltPropertyTable class.
 * Created by QuickDVM
 */
public class OltPropertyTable extends SnmpMibBean {
    public static final String oltDeviceIndex = "oltDeviceIndex";
    public static final String oltName = "oltName";
    public static final String oltType = "oltType";
    public static final String oltAdminStatus = "oltAdminStatus";
    public static final String oltDeviceUpTime = "oltDeviceUpTime";
    public static final String oltDeviceNumOfTotalServiceSlot = "oltDeviceNumOfTotalServiceSlot";
    public static final String oltDeviceNumOfTotalPowerSlot = "oltDeviceNumOfTotalPowerSlot";
    public static final String oltDeviceNumOfTotalFanSlot = "oltDeviceNumOfTotalFanSlot";
    public static final String oltDeviceStyle = "oltDeviceStyle";

    public OltPropertyTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltDeviceIndex, new SnmpMibBeanProperty(oltDeviceIndex, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(oltName, new SnmpMibBeanProperty(oltName, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.2", ISnmpConstant.STRING));
        initProperty(oltType, new SnmpMibBeanProperty(oltType, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.3", ISnmpConstant.STRING));
        initProperty(oltAdminStatus, new SnmpMibBeanProperty(oltAdminStatus, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.4", ISnmpConstant.INTEGER));
        initProperty(oltDeviceUpTime, new SnmpMibBeanProperty(oltDeviceUpTime, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.5", ISnmpConstant.COUNTER));
        initProperty(oltDeviceNumOfTotalServiceSlot, new SnmpMibBeanProperty(oltDeviceNumOfTotalServiceSlot, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.6", ISnmpConstant.INTEGER));
        initProperty(oltDeviceNumOfTotalPowerSlot, new SnmpMibBeanProperty(oltDeviceNumOfTotalPowerSlot, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.7", ISnmpConstant.INTEGER));
        initProperty(oltDeviceNumOfTotalFanSlot, new SnmpMibBeanProperty(oltDeviceNumOfTotalFanSlot, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.8", ISnmpConstant.INTEGER));
        initProperty(oltDeviceStyle, new SnmpMibBeanProperty(oltDeviceStyle, ".1.3.6.1.4.1.17409.2.3.1.2.1.1.9", ISnmpConstant.INTEGER));
    }

    public Integer getOltDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setOltDeviceIndex(Integer aOltDeviceIndex) {
        setIndex(0, aOltDeviceIndex);
    }

    public String getOltName() {
        return (String) getProperty(oltName).getValue();
    }

    public void setOltName(String aOltName) {
        getProperty(oltName).setValue(aOltName);
    }

    public String getOltType() {
        return (String) getProperty(oltType).getValue();
    }

    public void setOltType(String aOltType) {
        getProperty(oltType).setValue(aOltType);
    }

    public Integer getOltAdminStatus() {
        return (Integer) getProperty(oltAdminStatus).getValue();
    }

    public void setOltAdminStatus(Integer aOltAdminStatus) {
        getProperty(oltAdminStatus).setValue(aOltAdminStatus);
    }

    public Long getOltDeviceUpTime() {
        return (Long) getProperty(oltDeviceUpTime).getValue();
    }

    public void setOltDeviceUpTime(Long aOltDeviceUpTime) {
        getProperty(oltDeviceUpTime).setValue(aOltDeviceUpTime);
    }

    public Integer getOltDeviceNumOfTotalServiceSlot() {
        return (Integer) getProperty(oltDeviceNumOfTotalServiceSlot).getValue();
    }

    public void setOltDeviceNumOfTotalServiceSlot(Integer aOltDeviceNumOfTotalServiceSlot) {
        getProperty(oltDeviceNumOfTotalServiceSlot).setValue(aOltDeviceNumOfTotalServiceSlot);
    }

    public Integer getOltDeviceNumOfTotalPowerSlot() {
        return (Integer) getProperty(oltDeviceNumOfTotalPowerSlot).getValue();
    }

    public void setOltDeviceNumOfTotalPowerSlot(Integer aOltDeviceNumOfTotalPowerSlot) {
        getProperty(oltDeviceNumOfTotalPowerSlot).setValue(aOltDeviceNumOfTotalPowerSlot);
    }

    public Integer getOltDeviceNumOfTotalFanSlot() {
        return (Integer) getProperty(oltDeviceNumOfTotalFanSlot).getValue();
    }

    public void setOltDeviceNumOfTotalFanSlot(Integer aOltDeviceNumOfTotalFanSlot) {
        getProperty(oltDeviceNumOfTotalFanSlot).setValue(aOltDeviceNumOfTotalFanSlot);
    }

    public Integer getOltDeviceStyle() {
        return (Integer) getProperty(oltDeviceStyle).getValue();
    }

    public void setOltDeviceStyle(Integer aOltDeviceStyle) {
        getProperty(oltDeviceStyle).setValue(aOltDeviceStyle);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(oltName));
        prepareRead(getProperty(oltType));
        prepareRead(getProperty(oltAdminStatus));
        prepareRead(getProperty(oltDeviceUpTime));
        prepareRead(getProperty(oltDeviceNumOfTotalServiceSlot));
        prepareRead(getProperty(oltDeviceNumOfTotalPowerSlot));
        prepareRead(getProperty(oltDeviceNumOfTotalFanSlot));
        prepareRead(getProperty(oltDeviceStyle));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(oltName));
        prepareRead(getProperty(oltType));
        prepareRead(getProperty(oltAdminStatus));
        prepareRead(getProperty(oltDeviceUpTime));
        prepareRead(getProperty(oltDeviceNumOfTotalServiceSlot));
        prepareRead(getProperty(oltDeviceNumOfTotalPowerSlot));
        prepareRead(getProperty(oltDeviceNumOfTotalFanSlot));
        prepareRead(getProperty(oltDeviceStyle));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(oltName));
        prepareSave(getProperty(oltType));
        prepareSave(getProperty(oltAdminStatus));

        return save();
    }

}
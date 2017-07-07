package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

/**
 * @author Yang Yizai , 2009-3-9
 */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The GponOltOls2CfgTable class.
 * Created by QuickDVM
 */
public class GponOltOls2CfgTable extends SnmpMibBean {
    public static final String oltOls2CfgSlotNo = "oltOls2CfgSlotNo";
    public static final String oltOls2CfgPortNo = "oltOls2CfgPortNo";
    public static final String oltOls2CfgLogicalPortNo = "oltOls2CfgLogicalPortNo";
    public static final String oltOls2RxPower = "oltOls2RxPower";
    public static final String oltOls2RxPowerThresholdAlarmHi = "oltOls2RxPowerThresholdAlarmHi";
    public static final String oltOls2RxPowerThresholdAlarmLo = "oltOls2RxPowerThresholdAlarmLo";
    public static final String oltOls2RxPowerThresholdWarningHi = "oltOls2RxPowerThresholdWarningHi";
    public static final String oltOls2RxPowerThresholdWarningLo = "oltOls2RxPowerThresholdWarningLo";
    public static final String oltOls2Enable = "oltOls2Enable";

    public GponOltOls2CfgTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltOls2CfgSlotNo, new SnmpMibBeanProperty(oltOls2CfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.1",
                ISnmpConstant.INTEGER));
        initProperty(oltOls2CfgPortNo, new SnmpMibBeanProperty(oltOls2CfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.2",
                ISnmpConstant.INTEGER));
        initProperty(oltOls2CfgLogicalPortNo, new SnmpMibBeanProperty(oltOls2CfgLogicalPortNo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.3", ISnmpConstant.INTEGER));
        initProperty(oltOls2RxPower, new SnmpMibBeanProperty(oltOls2RxPower, ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.15",
                ISnmpConstant.INTEGER));
        initProperty(oltOls2RxPowerThresholdAlarmHi, new SnmpMibBeanProperty(oltOls2RxPowerThresholdAlarmHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.24", ISnmpConstant.INTEGER));
        initProperty(oltOls2RxPowerThresholdAlarmLo, new SnmpMibBeanProperty(oltOls2RxPowerThresholdAlarmLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.25", ISnmpConstant.INTEGER));
        initProperty(oltOls2RxPowerThresholdWarningHi, new SnmpMibBeanProperty(oltOls2RxPowerThresholdWarningHi,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.34", ISnmpConstant.INTEGER));
        initProperty(oltOls2RxPowerThresholdWarningLo, new SnmpMibBeanProperty(oltOls2RxPowerThresholdWarningLo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.35", ISnmpConstant.INTEGER));
        initProperty(oltOls2Enable, new SnmpMibBeanProperty(oltOls2Enable, ".1.3.6.1.4.1.41355.1.3.10.5.1.12.1.99",
                ISnmpConstant.INTEGER));

    }

    public Integer getOltOls2CfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOltOls2CfgSlotNo(Integer aOltOls2CfgSlotNo) {
        setIndex(0, aOltOls2CfgSlotNo);
    }

    public Integer getOltOls2CfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOltOls2CfgPortNo(Integer aOltOls2CfgPortNo) {
        setIndex(1, aOltOls2CfgPortNo);
    }

    public Integer getOltOls2CfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOltOls2CfgLogicalPortNo(Integer aOltOls2CfgLogicalPortNo) {
        setIndex(2, aOltOls2CfgLogicalPortNo);
    }

    public Integer getOltOls2RxPower() {
        return (Integer) getProperty(oltOls2RxPower).getValue();
    }

    public void setOltOls2RxPower(Integer aOltOls2RxPower) {
        getProperty(oltOls2RxPower).setValue(aOltOls2RxPower);
    }

    public Integer getOltOls2RxPowerThresholdAlarmHi() {
        return (Integer) getProperty(oltOls2RxPowerThresholdAlarmHi).getValue();
    }

    public void setOltOls2RxPowerThresholdAlarmHi(Integer aOltOls2RxPowerThresholdAlarmHi) {
        getProperty(oltOls2RxPowerThresholdAlarmHi).setValue(aOltOls2RxPowerThresholdAlarmHi);
    }

    public Integer getOltOls2RxPowerThresholdAlarmLo() {
        return (Integer) getProperty(oltOls2RxPowerThresholdAlarmLo).getValue();
    }

    public void setOltOls2RxPowerThresholdAlarmLo(Integer aOltOls2RxPowerThresholdAlarmLo) {
        getProperty(oltOls2RxPowerThresholdAlarmLo).setValue(aOltOls2RxPowerThresholdAlarmLo);
    }

    public Integer getOltOls2RxPowerThresholdWarningHi() {
        return (Integer) getProperty(oltOls2RxPowerThresholdWarningHi).getValue();
    }

    public void setOltOls2RxPowerThresholdWarningHi(Integer aOltOls2RxPowerThresholdWarningHi) {
        getProperty(oltOls2RxPowerThresholdWarningHi).setValue(aOltOls2RxPowerThresholdWarningHi);
    }

    public Integer getOltOls2RxPowerThresholdWarningLo() {
        return (Integer) getProperty(oltOls2RxPowerThresholdWarningLo).getValue();
    }

    public void setOltOls2RxPowerThresholdWarningLo(Integer aOltOls2RxPowerThresholdWarningLo) {
        getProperty(oltOls2RxPowerThresholdWarningLo).setValue(aOltOls2RxPowerThresholdWarningLo);
    }

    public Integer getOltOls2Enable() {
        return (Integer) getProperty(oltOls2Enable).getValue();
    }

    public void setOltOls2Enable(Integer aOltOls2Enable) {
        getProperty(oltOls2Enable).setValue(aOltOls2Enable);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(oltOls2RxPower));
        prepareRead(super.getProperty(oltOls2RxPowerThresholdAlarmHi));
        prepareRead(super.getProperty(oltOls2RxPowerThresholdAlarmLo));
        prepareRead(super.getProperty(oltOls2RxPowerThresholdWarningHi));
        prepareRead(super.getProperty(oltOls2RxPowerThresholdWarningLo));
        prepareRead(super.getProperty(oltOls2Enable));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(oltOls2RxPower));
        prepareRead(super.getProperty(oltOls2RxPowerThresholdAlarmHi));
        prepareRead(super.getProperty(oltOls2RxPowerThresholdAlarmLo));
        prepareRead(super.getProperty(oltOls2RxPowerThresholdWarningHi));
        prepareRead(super.getProperty(oltOls2RxPowerThresholdWarningLo));
        prepareRead(super.getProperty(oltOls2Enable));

        return loadAll(new int[] { 1, 1, 1 });
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(oltOls2RxPowerThresholdAlarmHi));
        prepareSave(getProperty(oltOls2RxPowerThresholdAlarmLo));
        prepareSave(getProperty(oltOls2RxPowerThresholdWarningHi));
        prepareSave(getProperty(oltOls2RxPowerThresholdWarningLo));
        prepareSave(getProperty(oltOls2Enable));

        return save();
    }

}

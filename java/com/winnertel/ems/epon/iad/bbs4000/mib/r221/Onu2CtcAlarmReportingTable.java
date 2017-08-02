/**
 * Created by Zhou Chao, 2010/1/13
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Onu2CtcAlarmReportingTable extends SnmpMibBean {

    public static final String utsDot3Onu2CtcAlarmReportingModuleId = "utsDot3Onu2CtcAlarmReportingModuleId";
    public static final String utsDot3Onu2CtcAlarmReportingDeviceId = "utsDot3Onu2CtcAlarmReportingDeviceId";
    public static final String utsDot3Onu2CtcAlarmReportingPortId = "utsDot3Onu2CtcAlarmReportingPortId";
    public static final String utsDot3Onu2CtcAlarmReportingLogicalPortId = "utsDot3Onu2CtcAlarmReportingLogicalPortId";
    public static final String utsDot3Onu2CtcAlarmReportingAlarmId = "utsDot3Onu2CtcAlarmReportingAlarmId";
    public static final String utsDot3Onu2CtcAlarmReportingOnuPortId = "utsDot3Onu2CtcAlarmReportingOnuPortId";
    public static final String utsDot3Onu2CtcAlarmReportingAlarmObjects = "utsDot3Onu2CtcAlarmReportingAlarmObjects";
    public static final String utsDot3Onu2CtcAlarmReportingAlarmAdmin = "utsDot3Onu2CtcAlarmReportingAlarmAdmin";
    public static final String utsDot3Onu2CtcAlarmReportingThresholdSupport = "utsDot3Onu2CtcAlarmReportingThresholdSupport";
    public static final String utsDot3Onu2CtcAlarmReportingThresholdRaise = "utsDot3Onu2CtcAlarmReportingThresholdRaise";
    public static final String utsDot3Onu2CtcAlarmReportingThresholdClear = "utsDot3Onu2CtcAlarmReportingThresholdClear";
    public static final String utsDot3Onu2CtcAlarmReportingThresholdRaiseDisplay = "utsDot3Onu2CtcAlarmReportingThresholdRaiseDisplay";
    public static final String utsDot3Onu2CtcAlarmReportingThresholdClearDisplay = "utsDot3Onu2CtcAlarmReportingThresholdClearDisplay";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2CtcAlarmReportingTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcAlarmReportingModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingAlarmId, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingAlarmId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingOnuPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingOnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingAlarmObjects, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingAlarmObjects, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingAlarmAdmin, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingAlarmAdmin, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingThresholdSupport, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingThresholdSupport, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.10", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAlarmReportingThresholdClear, new SnmpMibBeanProperty(utsDot3Onu2CtcAlarmReportingThresholdClear, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.39.1.11", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcAlarmReportingModuleId(Integer aUtsDot3Onu2CtcAlarmReportingModuleId) {
        setIndex(0, aUtsDot3Onu2CtcAlarmReportingModuleId);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcAlarmReportingDeviceId(Integer aUtsDot3Onu2CtcAlarmReportingDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcAlarmReportingDeviceId);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcAlarmReportingPortId(Integer aUtsDot3Onu2CtcAlarmReportingPortId) {
        setIndex(2, aUtsDot3Onu2CtcAlarmReportingPortId);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcAlarmReportingLogicalPortId(Integer aUtsDot3Onu2CtcAlarmReportingLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcAlarmReportingLogicalPortId);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingAlarmId() {
        return (Integer) getIndex(4);
    }

    public void setUtsDot3Onu2CtcAlarmReportingAlarmId(Integer aUtsDot3Onu2CtcAlarmReportingAlarmId) {
        setIndex(4, aUtsDot3Onu2CtcAlarmReportingAlarmId);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingOnuPortId() {
        return (Integer) getIndex(5);
    }

    public void setUtsDot3Onu2CtcAlarmReportingOnuPortId(Integer aUtsDot3Onu2CtcAlarmReportingOnuPortId) {
        setIndex(5, aUtsDot3Onu2CtcAlarmReportingOnuPortId);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingAlarmObjects() {
        return (Integer) getProperty(utsDot3Onu2CtcAlarmReportingAlarmObjects).getValue();
    }

    public void setUtsDot3Onu2CtcAlarmReportingAlarmObjects(Integer aUtsDot3Onu2CtcAlarmReportingAlarmObjects) {
        getProperty(utsDot3Onu2CtcAlarmReportingAlarmObjects).setValue(aUtsDot3Onu2CtcAlarmReportingAlarmObjects);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingAlarmAdmin() {
        return (Integer) getProperty(utsDot3Onu2CtcAlarmReportingAlarmAdmin).getValue();
    }

    public void setUtsDot3Onu2CtcAlarmReportingAlarmAdmin(Integer aUtsDot3Onu2CtcAlarmReportingAlarmAdmin) {
        getProperty(utsDot3Onu2CtcAlarmReportingAlarmAdmin).setValue(aUtsDot3Onu2CtcAlarmReportingAlarmAdmin);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingThresholdSupport() {
        return (Integer) getProperty(utsDot3Onu2CtcAlarmReportingThresholdSupport).getValue();
    }

    public void setUtsDot3Onu2CtcAlarmReportingThresholdSupport(Integer aUtsDot3Onu2CtcAlarmReportingThresholdSupport) {
        getProperty(utsDot3Onu2CtcAlarmReportingThresholdSupport).setValue(aUtsDot3Onu2CtcAlarmReportingThresholdSupport);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingThresholdRaise() {
        /**
         * For temperature threshold, the unit is 1/256 degree. The range is -128 C to 128 C.
         * 8: onuOnuTemperatureHighAlarm(9)
         * 9: onuOnuTemperatureLowAlarm(10)
         * 20: ponifTemperatureHighAlarm(265)
         * 21: ponifTemperatureLowAlarm(266)
         * 30: ponifTemperatureHighWarning(275)
         * 31: ponifTemperatureLowWarning(276)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 9
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 10
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 265
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 266
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 275
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 276) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdRaise).getValue() / 256;
        }
        /**
         * For power voltage threshold, the unit is 100 uV. The range is 0 to 6.55 v.
         * 5: onuBatteryVoltageLow(5)
         * 18: ponifVccHighAlarm(263)
         * 19: ponifVccLowAlarm(264)
         * 28: ponifVccHighAlarmWarning(273)
         * 29: ponifVccLowWarning(274)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 5
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 263
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 264
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 273
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 274) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdRaise).getValue() / 10;
        }
        /**
         * For bias current threshold, the unit is 2 uA. The range is 0 to 131 mA.
         16: ponifTxBiasHighAlarm(261)
         17: ponifTxBiasLowAlarm(262)
         26: ponifTxBiasHighWarning(271)
         27: ponifTxBiasLowWarning(272)

         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 261
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 262
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 271
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 272) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdRaise).getValue() / 500;
        }
        /**
         For Tx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         14: ponifTxPowerHighAlarm(259)
         15: ponifTxPowerLowAlarm(260)
         24: ponifTxPowerHighWarning(269)
         25: ponifTxPowerLowWarning(270)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 259
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 260
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 269
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 270) {
            return (int) java.lang.Math.round(10 * java.lang.Math
                    .log10((Integer) getProperty(
                            utsDot3Onu2CtcAlarmReportingThresholdRaise)
                            .getValue() / 10000.0));
        }
        /**
         * For Rx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 12: ponifRxPowerHighAlarm(257)
         * 13: ponifRxPowerLowAlarm(258)
         * 22: ponifRxPowerHighWarning(267)
         * 23: ponifRxPowerLowWarning(268)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 257
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 258
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 267
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 268) {
            return (int) java.lang.Math.round(10 * java.lang.Math
                    .log10((Integer) getProperty(
                            utsDot3Onu2CtcAlarmReportingThresholdRaise)
                            .getValue() / 10000.0));
        }

        return (Integer) getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise)
                .getValue();
    }

    public String getUtsDot3Onu2CtcAlarmReportingThresholdRaiseDisplay() {
        /**For temperature threshold, the unit is 1/256 degree. The range is -128 C to 128 C.
         8: onuOnuTemperatureHighAlarm(9)
         9: onuOnuTemperatureLowAlarm(10)
         20: ponifTemperatureHighAlarm(265)
         21: ponifTemperatureLowAlarm(266)
         30: ponifTemperatureHighWarning(275)
         31: ponifTemperatureLowWarning(276)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 9
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 10
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 265
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 266
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 275
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 276) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdRaise).getValue()
                    / 256 + " ��";
        }
        /**
         For power voltage threshold, the unit is 100 uV. The range is 0 to 6.55 v.
         5: onuBatteryVoltageLow(5)
         18: ponifVccHighAlarm(263)
         19: ponifVccLowAlarm(264)
         28: ponifVccHighAlarmWarning(273)
         29: ponifVccLowWarning(274)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 5
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 263
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 264
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 273
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 274) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdRaise).getValue()
                    / 10 + " mV";
        }
        /**
         * For bias current threshold, the unit is 2 uA. The range is 0 to 131 mA.
         16: ponifTxBiasHighAlarm(261)
         17: ponifTxBiasLowAlarm(262)
         26: ponifTxBiasHighWarning(271)
         27: ponifTxBiasLowWarning(272)

         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 261
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 262
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 271
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 272) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdRaise).getValue()
                    / 500 + " mA";
        }
        /**
         For Tx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         14: ponifTxPowerHighAlarm(259)
         15: ponifTxPowerLowAlarm(260)
         24: ponifTxPowerHighWarning(269)
         25: ponifTxPowerLowWarning(270)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 259
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 260
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 269
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 270) {
            return (int) java.lang.Math.round(10 * java.lang.Math
                    .log10((Integer) getProperty(
                            utsDot3Onu2CtcAlarmReportingThresholdRaise)
                            .getValue() / 10000.0))
                    + " dB";
        }
        /**
         * For Rx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 12: ponifRxPowerHighAlarm(257)
         * 13: ponifRxPowerLowAlarm(258)
         * 22: ponifRxPowerHighWarning(267)
         * 23: ponifRxPowerLowWarning(268)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 257
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 258
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 267
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 268) {
            return (int) java.lang.Math.round(10 * java.lang.Math
                    .log10((Integer) getProperty(
                            utsDot3Onu2CtcAlarmReportingThresholdRaise)
                            .getValue() / 10000.0))
                    + " dB";
        }

        return getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise)
                .getValue().toString();
    }

    public void setUtsDot3Onu2CtcAlarmReportingThresholdRaise(
            Integer aUtsDot3Onu2CtcAlarmReportingThresholdRaise) {
        getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise).setValue(
                aUtsDot3Onu2CtcAlarmReportingThresholdRaise);
    }

    public void setUtsDot3Onu2CtcAlarmReportingThresholdRaiseDisplay(Integer aUtsDot3Onu2CtcAlarmReportingThresholdRaise) {
        /**
         * For temperature threshold, the unit is 1/256 degree. The range is -128 C to 128 C.
         * 8: onuOnuTemperatureHighAlarm(9)
         * 9: onuOnuTemperatureLowAlarm(10)
         * 20: ponifTemperatureHighAlarm(265)
         * 21: ponifTemperatureLowAlarm(266)
         * 30: ponifTemperatureHighWarning(275)
         * 31: ponifTemperatureLowWarning(276)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 9
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 10
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 265
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 266
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 275
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 276) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise).setValue(
                    aUtsDot3Onu2CtcAlarmReportingThresholdRaise * 256);
        }
        /**
         * For power voltage threshold, the unit is 100 uV. The range is 0 to 6.55 v.
         * 5: onuBatteryVoltageLow(5)
         * 18: ponifVccHighAlarm(263)
         * 19: ponifVccLowAlarm(264)
         * 28: ponifVccHighAlarmWarning(273)
         * 29: ponifVccLowWarning(274)
         */
        else if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 5
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 263
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 264
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 273
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 274) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise).setValue(
                    aUtsDot3Onu2CtcAlarmReportingThresholdRaise * 10);
        }
        /**
         * For bias current threshold, the unit is 2 uA. The range is 0 to 131 mA.
         * 16: ponifTxBiasHighAlarm(261)
         * 17: ponifTxBiasLowAlarm(262)
         * 26: ponifTxBiasHighWarning(271)
         * 27: ponifTxBiasLowWarning(272)
         */
        else if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 261
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 262
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 271
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 272) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise).setValue(
                    aUtsDot3Onu2CtcAlarmReportingThresholdRaise * 500);
        }
        /**
         * For Tx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 14: ponifTxPowerHighAlarm(259)
         * 15: ponifTxPowerLowAlarm(260)
         * 24: ponifTxPowerHighWarning(269)
         * 25: ponifTxPowerLowWarning(270)
         */
        else if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 259
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 260
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 269
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 270) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise)
                    .setValue(
                            (int) java.lang.Math
                                    .round(java.lang.Math
                                            .pow(
                                                    10,
                                                    aUtsDot3Onu2CtcAlarmReportingThresholdRaise / 10.0) * 10000));
        }
        /**
         * For Rx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 12: ponifRxPowerHighAlarm(257)
         * 13: ponifRxPowerLowAlarm(258)
         * 22: ponifRxPowerHighWarning(267)
         * 23: ponifRxPowerLowWarning(268)
         */
        else if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 257
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 258
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 267
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 268) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise)
                    .setValue(
                            (int) java.lang.Math
                                    .round(java.lang.Math
                                            .pow(
                                                    10,
                                                    aUtsDot3Onu2CtcAlarmReportingThresholdRaise / 10.0) * 10000));
        } else
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise).setValue(
                    aUtsDot3Onu2CtcAlarmReportingThresholdRaise);
    }

    public Integer getUtsDot3Onu2CtcAlarmReportingThresholdClear() {
        /**
         * For temperature threshold, the unit is 1/256 degree. The range is -128 C to 128 C.
         * 8: onuOnuTemperatureHighAlarm(9)
         * 9: onuOnuTemperatureLowAlarm(10)
         * 20: ponifTemperatureHighAlarm(265)
         * 21: ponifTemperatureLowAlarm(266)
         * 30: ponifTemperatureHighWarning(275)
         * 31: ponifTemperatureLowWarning(276)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 9
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 10
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 265
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 266
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 275
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 276) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdClear).getValue() / 256;
        }
        /**
         * For power voltage threshold, the unit is 100 uV. The range is 0 to 6.55 v.
         * 5: onuBatteryVoltageLow(5)
         * 18: ponifVccHighAlarm(263)
         * 19: ponifVccLowAlarm(264)
         * 28: ponifVccHighAlarmWarning(273)
         * 29: ponifVccLowWarning(274)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 5
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 263
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 264
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 273
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 274) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdClear).getValue() / 10;
        }
        /**
         * For bias current threshold, the unit is 2 uA. The range is 0 to 131 mA.
         * 16: ponifTxBiasHighAlarm(261)
         * 17: ponifTxBiasLowAlarm(262)
         * 26: ponifTxBiasHighWarning(271)
         * 27: ponifTxBiasLowWarning(272)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 261
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 262
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 271
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 272) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdClear).getValue() / 500;
        }
        /**
         * For Tx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 14: ponifTxPowerHighAlarm(259)
         * 15: ponifTxPowerLowAlarm(260)
         * 24: ponifTxPowerHighWarning(269)
         * 25: ponifTxPowerLowWarning(270)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 259
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 260
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 269
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 270) {
            return (int) java.lang.Math.round(10 * java.lang.Math
                    .log10((Integer) getProperty(
                            utsDot3Onu2CtcAlarmReportingThresholdClear)
                            .getValue() / 10000.0));
        }
        /**
         * For Rx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 12: ponifRxPowerHighAlarm(257)
         * 13: ponifRxPowerLowAlarm(258)
         * 22: ponifRxPowerHighWarning(267)
         * 23: ponifRxPowerLowWarning(268)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 257
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 258
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 267
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 268) {
            return (int) java.lang.Math.round(10 * java.lang.Math
                    .log10((Integer) getProperty(
                            utsDot3Onu2CtcAlarmReportingThresholdClear)
                            .getValue() / 10000.0));
        }

        return (Integer) getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear)
                .getValue();
    }

    public String getUtsDot3Onu2CtcAlarmReportingThresholdClearDisplay() {
        /**
         * For temperature threshold, the unit is 1/256 degree. The range is -128 C to 128 C.
         * 8: onuOnuTemperatureHighAlarm(9)
         * 9: onuOnuTemperatureLowAlarm(10)
         * 20: ponifTemperatureHighAlarm(265)
         * 21: ponifTemperatureLowAlarm(266)
         * 30: ponifTemperatureHighWarning(275)
         * 31: ponifTemperatureLowWarning(276)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 9
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 10
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 265
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 266
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 275
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 276) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdClear).getValue()
                    / 256 + " ��";
        }
        /**
         * For power voltage threshold, the unit is 100 uV. The range is 0 to 6.55 v.
         * 5: onuBatteryVoltageLow(5)
         * 18: ponifVccHighAlarm(263)
         * 19: ponifVccLowAlarm(264)
         * 28: ponifVccHighAlarmWarning(273)
         * 29: ponifVccLowWarning(274)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 5
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 263
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 264
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 273
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 274) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdClear).getValue()
                    / 10 + " mV";
        }
        /**
         * For bias current threshold, the unit is 2 uA. The range is 0 to 131 mA.
         * 16: ponifTxBiasHighAlarm(261)
         * 17: ponifTxBiasLowAlarm(262)
         * 26: ponifTxBiasHighWarning(271)
         * 27: ponifTxBiasLowWarning(272)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 261
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 262
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 271
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 272) {
            return (Integer) getProperty(
                    utsDot3Onu2CtcAlarmReportingThresholdClear).getValue()
                    / 500 + " mA";
        }
        /**
         * For Tx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 14: ponifTxPowerHighAlarm(259)
         * 15: ponifTxPowerLowAlarm(260)
         * 24: ponifTxPowerHighWarning(269)
         * 25: ponifTxPowerLowWarning(270)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 259
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 260
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 269
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 270) {
            return (int) java.lang.Math.round(10 * java.lang.Math
                    .log10((Integer) getProperty(
                            utsDot3Onu2CtcAlarmReportingThresholdClear)
                            .getValue() / 10000.0))
                    + " dB";
        }
        /**
         * For Rx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 12: ponifRxPowerHighAlarm(257)
         * 13: ponifRxPowerLowAlarm(258)
         * 22: ponifRxPowerHighWarning(267)
         * 23: ponifRxPowerLowWarning(268)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 257
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 258
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 267
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 268) {
            return (int) java.lang.Math.round(10 * java.lang.Math
                    .log10((Integer) getProperty(
                            utsDot3Onu2CtcAlarmReportingThresholdClear)
                            .getValue() / 10000.0))
                    + " dB";
        }

        return getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear)
                .getValue().toString();
    }

    public void setUtsDot3Onu2CtcAlarmReportingThresholdClear(
            Integer aUtsDot3Onu2CtcAlarmReportingThresholdClear) {
        getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear).setValue(
                aUtsDot3Onu2CtcAlarmReportingThresholdClear);
    }

    public void setUtsDot3Onu2CtcAlarmReportingThresholdClearDisplay(Integer aUtsDot3Onu2CtcAlarmReportingThresholdClear) {
        /**
         * For temperature threshold, the unit is 1/256 degree. The range is -128 C to 128 C.
         * 8: onuOnuTemperatureHighAlarm(9)
         * 9: onuOnuTemperatureLowAlarm(10)
         * 20: ponifTemperatureHighAlarm(265)
         * 21: ponifTemperatureLowAlarm(266)
         * 30: ponifTemperatureHighWarning(275)
         * 31: ponifTemperatureLowWarning(276)
         */
        if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 9
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 10
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 265
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 266
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 275
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 276) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear).setValue(
                    aUtsDot3Onu2CtcAlarmReportingThresholdClear * 256);
        }
        /**
         * For power voltage threshold, the unit is 100 uV. The range is 0 to 6.55 v.
         * 5: onuBatteryVoltageLow(5)
         * 18: ponifVccHighAlarm(263)
         * 19: ponifVccLowAlarm(264)
         * 28: ponifVccHighAlarmWarning(273)
         * 29: ponifVccLowWarning(274)
         */
        else if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 5
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 263
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 264
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 273
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 274) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear).setValue(
                    aUtsDot3Onu2CtcAlarmReportingThresholdClear * 10);
        }
        /**
         * For bias current threshold, the unit is 2 uA. The range is 0 to 131 mA.
         * 16: ponifTxBiasHighAlarm(261)
         * 17: ponifTxBiasLowAlarm(262)
         * 26: ponifTxBiasHighWarning(271)
         * 27: ponifTxBiasLowWarning(272)
         */
        else if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 261
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 262
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 271
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 272) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear).setValue(
                    aUtsDot3Onu2CtcAlarmReportingThresholdClear * 500);
        }
        /**
         * For Tx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 14: ponifTxPowerHighAlarm(259)
         * 15: ponifTxPowerLowAlarm(260)
         * 24: ponifTxPowerHighWarning(269)
         * 25: ponifTxPowerLowWarning(270)
         */
        else if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 259
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 260
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 269
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 270) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear)
                    .setValue(
                            (int) java.lang.Math
                                    .round(java.lang.Math
                                            .pow(
                                                    10,
                                                    aUtsDot3Onu2CtcAlarmReportingThresholdClear / 10.0) * 10000));
        }
        /**
         * For Rx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW.
         * 12: ponifRxPowerHighAlarm(257)
         * 13: ponifRxPowerLowAlarm(258)
         * 22: ponifRxPowerHighWarning(267)
         * 23: ponifRxPowerLowWarning(268)
         */
        else if (getUtsDot3Onu2CtcAlarmReportingAlarmId() == 257
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 258
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 267
                || getUtsDot3Onu2CtcAlarmReportingAlarmId() == 268) {
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear)
                    .setValue(
                            (int) java.lang.Math
                                    .round(java.lang.Math
                                            .pow(
                                                    10,
                                                    aUtsDot3Onu2CtcAlarmReportingThresholdClear / 10.0) * 10000));
        } else
            getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear).setValue(
                    aUtsDot3Onu2CtcAlarmReportingThresholdClear);
    }

    //added by Zhouchao, 2011/8/26
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zhouchao, 2011/8/26
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingAlarmObjects));
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingAlarmAdmin));
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingThresholdSupport));
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise));
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingAlarmObjects));
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingAlarmAdmin));
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingThresholdSupport));
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise));
        prepareRead(getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Onu2CtcAlarmReportingTable bean = (Onu2CtcAlarmReportingTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcAlarmReportingModuleId()).append("/").append(bean.getUtsDot3Onu2CtcAlarmReportingPortId()).append("/").append(bean.getUtsDot3Onu2CtcAlarmReportingLogicalPortId()).toString();
//                    if (map.containsKey(key)) {
//                        bean.setOnuLabel((String) map.get(key));
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return v;
    }

    public boolean modify() throws MibBeanException {
        //prepareSave(getProperty(utsDot3Onu2CtcAlarmReportingAlarmId));
        prepareSave(getProperty(utsDot3Onu2CtcAlarmReportingAlarmObjects));
        prepareSave(getProperty(utsDot3Onu2CtcAlarmReportingAlarmAdmin));
        prepareSave(getProperty(utsDot3Onu2CtcAlarmReportingThresholdSupport));
        prepareSave(getProperty(utsDot3Onu2CtcAlarmReportingThresholdRaise));
        prepareSave(getProperty(utsDot3Onu2CtcAlarmReportingThresholdClear));

        return save();
    }

}
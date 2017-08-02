/**
 * Created by Zhou Chao, 2010/4/26
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r220;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class UplinkOpmDataTable extends SnmpMibBean {

    public static final String utsUplinkOpmDataModuleID = "utsUplinkOpmDataModuleID";
    public static final String utsUplinkOpmDataPortId = "utsUplinkOpmDataPortId";
    public static final String utsUplinkOpmDataRxPower = "utsUplinkOpmDataRxPower";
    public static final String utsUplinkOpmDataTxPower = "utsUplinkOpmDataTxPower";
    public static final String utsUplinkOpmRxPowerMinThreshold = "utsUplinkOpmRxPowerMinThreshold";
    public static final String utsUplinkOpmRxPowerMaxThreshold = "utsUplinkOpmRxPowerMaxThreshold";
    public static final String utsUplinkOpmTxPowerMinThreshold = "utsUplinkOpmTxPowerMinThreshold";
    public static final String utsUplinkOpmTxPowerMaxThreshold = "utsUplinkOpmTxPowerMaxThreshold";

    public UplinkOpmDataTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsUplinkOpmDataModuleID, new SnmpMibBeanProperty(utsUplinkOpmDataModuleID, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.1", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataPortId, new SnmpMibBeanProperty(utsUplinkOpmDataPortId, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.2", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataRxPower, new SnmpMibBeanProperty(utsUplinkOpmDataRxPower, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.3", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmDataTxPower, new SnmpMibBeanProperty(utsUplinkOpmDataTxPower, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.4", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmRxPowerMinThreshold, new SnmpMibBeanProperty(utsUplinkOpmRxPowerMinThreshold, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.5", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmRxPowerMaxThreshold, new SnmpMibBeanProperty(utsUplinkOpmRxPowerMaxThreshold, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.6", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmTxPowerMinThreshold, new SnmpMibBeanProperty(utsUplinkOpmTxPowerMinThreshold, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.7", ISnmpConstant.INTEGER));
        initProperty(utsUplinkOpmTxPowerMaxThreshold, new SnmpMibBeanProperty(utsUplinkOpmTxPowerMaxThreshold, ".1.3.6.1.4.1.45121.1800.2.2.1.17.1.8", ISnmpConstant.INTEGER));
    }

    public Integer getUtsUplinkOpmDataModuleID() {
        return (Integer) getIndex(0);
    }

    public void setUtsUplinkOpmDataModuleID(Integer aUtsUplinkOpmDataModuleID) {
        setIndex(0, aUtsUplinkOpmDataModuleID);
    }

    public Integer getUtsUplinkOpmDataPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsUplinkOpmDataPortId(Integer aUtsUplinkOpmDataPortId) {
        setIndex(1, aUtsUplinkOpmDataPortId);
    }

    public Double getUtsUplinkOpmDataRxPower() {
//        return (Integer) getProperty(utsUplinkOpmDataRxPower).getValue();
    	if ((Integer) getProperty(utsUplinkOpmDataRxPower)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsUplinkOpmDataRxPower).getValue() / 10000.0);
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setUtsUplinkOpmDataRxPower(Double aUtsUplinkOpmDataRxPower) {
//        getProperty(utsUplinkOpmDataRxPower).setValue(aUtsUplinkOpmDataRxPower);
    	getProperty(utsUplinkOpmDataRxPower).setValue(
				(int) java.lang.Math.round(java.lang.Math.pow(10,
						aUtsUplinkOpmDataRxPower / 10.0) * 10000));
    }

    public Double getUtsUplinkOpmDataTxPower() {
//        return (Integer) getProperty(utsUplinkOpmDataTxPower).getValue();
        if ((Integer) getProperty(utsUplinkOpmDataTxPower)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsUplinkOpmDataTxPower).getValue() / 10000.0);
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setUtsUplinkOpmDataTxPower(Integer aUtsUplinkOpmDataTxPower) {
//        getProperty(utsUplinkOpmDataTxPower).setValue(aUtsUplinkOpmDataTxPower);
    	getProperty(utsUplinkOpmDataTxPower).setValue(
				(int) java.lang.Math.round(java.lang.Math.pow(10,
						aUtsUplinkOpmDataTxPower / 10.0) * 10000));
    }

    public Double getUtsUplinkOpmRxPowerMinThreshold() {
//        return (Integer) getProperty(utsUplinkOpmRxPowerMinThreshold).getValue();
    	if ((Integer) getProperty(utsUplinkOpmRxPowerMinThreshold)
				.getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsUplinkOpmRxPowerMinThreshold).getValue() / 10000.0);
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setUtsUplinkOpmRxPowerMinThreshold(Double aUtsUplinkOpmRxPowerMinThreshold) {
//        getProperty(utsUplinkOpmRxPowerMinThreshold).setValue(aUtsUplinkOpmRxPowerMinThreshold);
		getProperty(utsUplinkOpmRxPowerMinThreshold).setValue(
				(int) java.lang.Math.round(java.lang.Math.pow(10,
						aUtsUplinkOpmRxPowerMinThreshold / 10.0) * 10000));
    }

    public Double getUtsUplinkOpmRxPowerMaxThreshold() {
//        return (Integer) getProperty(utsUplinkOpmRxPowerMaxThreshold).getValue();
		if ((Integer) getProperty(utsUplinkOpmRxPowerMaxThreshold).getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsUplinkOpmRxPowerMaxThreshold).getValue() / 10000.0);
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,
				java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setUtsUplinkOpmRxPowerMaxThreshold(Double aUtsUplinkOpmRxPowerMaxThreshold) {
//        getProperty(utsUplinkOpmRxPowerMaxThreshold).setValue(aUtsUplinkOpmRxPowerMaxThreshold);
    	getProperty(utsUplinkOpmRxPowerMaxThreshold).setValue(
				(int) java.lang.Math.round(java.lang.Math.pow(10,
						aUtsUplinkOpmRxPowerMaxThreshold / 10.0) * 10000));
    }

    public Double getUtsUplinkOpmTxPowerMinThreshold() {
//        return (Integer) getProperty(utsUplinkOpmTxPowerMinThreshold).getValue();
		if ((Integer) getProperty(utsUplinkOpmTxPowerMinThreshold).getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsUplinkOpmTxPowerMinThreshold).getValue() / 10000.0);
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,
				java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setUtsUplinkOpmTxPowerMinThreshold(Double aUtsUplinkOpmTxPowerMinThreshold) {
//        getProperty(utsUplinkOpmTxPowerMinThreshold).setValue(aUtsUplinkOpmTxPowerMinThreshold);
    	getProperty(utsUplinkOpmTxPowerMinThreshold).setValue(
				(int) java.lang.Math.round(java.lang.Math.pow(10,
						aUtsUplinkOpmTxPowerMinThreshold / 10.0) * 10000));
    }

    public Double getUtsUplinkOpmTxPowerMaxThreshold() {
//        return (Integer) getProperty(utsUplinkOpmTxPowerMaxThreshold).getValue();
		if ((Integer) getProperty(utsUplinkOpmTxPowerMaxThreshold).getValue() == 0)
			return new Double(-40);
		double d = 10 * java.lang.Math.log10((Integer) getProperty(
				utsUplinkOpmTxPowerMaxThreshold).getValue() / 10000.0);
		return new java.math.BigDecimal(Double.toString(d)).setScale(1,
				java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setUtsUplinkOpmTxPowerMaxThreshold(Double aUtsUplinkOpmTxPowerMaxThreshold) {
//        getProperty(utsUplinkOpmTxPowerMaxThreshold).setValue(aUtsUplinkOpmTxPowerMaxThreshold);
    	getProperty(utsUplinkOpmTxPowerMaxThreshold).setValue(
				(int) java.lang.Math.round(java.lang.Math.pow(10,
						aUtsUplinkOpmTxPowerMaxThreshold / 10.0) * 10000));
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsUplinkOpmDataRxPower));
        prepareRead(getProperty(utsUplinkOpmDataTxPower));
        prepareRead(getProperty(utsUplinkOpmRxPowerMinThreshold));
        prepareRead(getProperty(utsUplinkOpmRxPowerMaxThreshold));
        prepareRead(getProperty(utsUplinkOpmTxPowerMinThreshold));
        prepareRead(getProperty(utsUplinkOpmTxPowerMaxThreshold));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsUplinkOpmDataRxPower));
        prepareRead(getProperty(utsUplinkOpmDataTxPower));
        prepareRead(getProperty(utsUplinkOpmRxPowerMinThreshold));
        prepareRead(getProperty(utsUplinkOpmRxPowerMaxThreshold));
        prepareRead(getProperty(utsUplinkOpmTxPowerMinThreshold));
        prepareRead(getProperty(utsUplinkOpmTxPowerMaxThreshold));

        return loadAll(new int[]{1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsUplinkOpmRxPowerMinThreshold));
        prepareSave(getProperty(utsUplinkOpmRxPowerMaxThreshold));
        prepareSave(getProperty(utsUplinkOpmTxPowerMinThreshold));
        prepareSave(getProperty(utsUplinkOpmTxPowerMaxThreshold));

        return save();
    }

}
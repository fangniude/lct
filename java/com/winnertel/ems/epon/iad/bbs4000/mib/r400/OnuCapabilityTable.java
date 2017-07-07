/**
 * Created by Zhou Chao, 2010/3/8
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuCapabilityTable extends SnmpMibBean {

    public static final String onuCapabilityDeviceIndex = "onuCapabilityDeviceIndex";
    public static final String onuGePortNum = "onuGePortNum";
    public static final String onuGePortBitmap = "onuGePortBitmap";
    public static final String onuFePortNum = "onuFePortNum";
    public static final String onuFePortBitmap = "onuFePortBitmap";
    public static final String onuQueueNumUplink = "onuQueueNumUplink";
    public static final String onuMaxQueueNumUplink = "onuMaxQueueNumUplink";
    public static final String onuQueueNumDownlink = "onuQueueNumDownlink";
    public static final String onuMaxQueueNumDownlink = "onuMaxQueueNumDownlink";
    public static final String onuFecEnable = "onuFecEnable";
    public static final String onuEncryptMode = "onuEncryptMode";
    public static final String onuEncryptKeyExchangeTime = "onuEncryptKeyExchangeTime";

    public OnuCapabilityTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCapabilityDeviceIndex, new SnmpMibBeanProperty(onuCapabilityDeviceIndex, ".1.3.6.1.4.1.17409.2.3.4.3.1.1", ISnmpConstant.INTEGER));
        initProperty(onuGePortNum, new SnmpMibBeanProperty(onuGePortNum, ".1.3.6.1.4.1.17409.2.3.4.3.1.2", ISnmpConstant.INTEGER));
        initProperty(onuGePortBitmap, new SnmpMibBeanProperty(onuGePortBitmap, ".1.3.6.1.4.1.17409.2.3.4.3.1.3", ISnmpConstant.OCTETS));
        initProperty(onuFePortNum, new SnmpMibBeanProperty(onuFePortNum, ".1.3.6.1.4.1.17409.2.3.4.3.1.4", ISnmpConstant.INTEGER));
        initProperty(onuFePortBitmap, new SnmpMibBeanProperty(onuFePortBitmap, ".1.3.6.1.4.1.17409.2.3.4.3.1.5", ISnmpConstant.OCTETS));
        initProperty(onuQueueNumUplink, new SnmpMibBeanProperty(onuQueueNumUplink, ".1.3.6.1.4.1.17409.2.3.4.3.1.6", ISnmpConstant.INTEGER));
        initProperty(onuMaxQueueNumUplink, new SnmpMibBeanProperty(onuMaxQueueNumUplink, ".1.3.6.1.4.1.17409.2.3.4.3.1.7", ISnmpConstant.INTEGER));
        initProperty(onuQueueNumDownlink, new SnmpMibBeanProperty(onuQueueNumDownlink, ".1.3.6.1.4.1.17409.2.3.4.3.1.8", ISnmpConstant.INTEGER));
        initProperty(onuMaxQueueNumDownlink, new SnmpMibBeanProperty(onuMaxQueueNumDownlink, ".1.3.6.1.4.1.17409.2.3.4.3.1.9", ISnmpConstant.INTEGER));
        initProperty(onuFecEnable, new SnmpMibBeanProperty(onuFecEnable, ".1.3.6.1.4.1.17409.2.3.4.3.1.10", ISnmpConstant.INTEGER));
        initProperty(onuEncryptMode, new SnmpMibBeanProperty(onuEncryptMode, ".1.3.6.1.4.1.17409.2.3.4.3.1.11", ISnmpConstant.INTEGER));
        initProperty(onuEncryptKeyExchangeTime, new SnmpMibBeanProperty(onuEncryptKeyExchangeTime, ".1.3.6.1.4.1.17409.2.3.4.3.1.12", ISnmpConstant.TIME_TICKS));
    }

    public Integer getOnuCapabilityDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setOnuCapabilityDeviceIndex(Integer aOnuCapabilityDeviceIndex) {
        setIndex(0, aOnuCapabilityDeviceIndex);
    }

    public Integer getOnuGePortNum() {
        return (Integer) getProperty(onuGePortNum).getValue();
    }

    public void setOnuGePortNum(Integer aOnuGePortNum) {
        getProperty(onuGePortNum).setValue(aOnuGePortNum);
    }

    public byte[] getOnuGePortBitmap() {
        return (byte[]) getProperty(onuGePortBitmap).getValue();
    }

    public void setOnuGePortBitmap(byte[] aOnuGePortBitmap) {
        getProperty(onuGePortBitmap).setValue(aOnuGePortBitmap);
    }

    public Integer getOnuFePortNum() {
        return (Integer) getProperty(onuFePortNum).getValue();
    }

    public void setOnuFePortNum(Integer aOnuFePortNum) {
        getProperty(onuFePortNum).setValue(aOnuFePortNum);
    }

    public byte[] getOnuFePortBitmap() {
        return (byte[]) getProperty(onuFePortBitmap).getValue();
    }

    public void setOnuFePortBitmap(byte[] aOnuFePortBitmap) {
        getProperty(onuFePortBitmap).setValue(aOnuFePortBitmap);
    }

    public Integer getOnuQueueNumUplink() {
        return (Integer) getProperty(onuQueueNumUplink).getValue();
    }

    public void setOnuQueueNumUplink(Integer aOnuQueueNumUplink) {
        getProperty(onuQueueNumUplink).setValue(aOnuQueueNumUplink);
    }

    public Integer getOnuMaxQueueNumUplink() {
        return (Integer) getProperty(onuMaxQueueNumUplink).getValue();
    }

    public void setOnuMaxQueueNumUplink(Integer aOnuMaxQueueNumUplink) {
        getProperty(onuMaxQueueNumUplink).setValue(aOnuMaxQueueNumUplink);
    }

    public Integer getOnuQueueNumDownlink() {
        return (Integer) getProperty(onuQueueNumDownlink).getValue();
    }

    public void setOnuQueueNumDownlink(Integer aOnuQueueNumDownlink) {
        getProperty(onuQueueNumDownlink).setValue(aOnuQueueNumDownlink);
    }

    public Integer getOnuMaxQueueNumDownlink() {
        return (Integer) getProperty(onuMaxQueueNumDownlink).getValue();
    }

    public void setOnuMaxQueueNumDownlink(Integer aOnuMaxQueueNumDownlink) {
        getProperty(onuMaxQueueNumDownlink).setValue(aOnuMaxQueueNumDownlink);
    }

    public Integer getOnuFecEnable() {
        return (Integer) getProperty(onuFecEnable).getValue();
    }

    public void setOnuFecEnable(Integer aOnuFecEnable) {
        getProperty(onuFecEnable).setValue(aOnuFecEnable);
    }

    public Integer getOnuEncryptMode() {
        return (Integer) getProperty(onuEncryptMode).getValue();
    }

    public void setOnuEncryptMode(Integer aOnuEncryptMode) {
        getProperty(onuEncryptMode).setValue(aOnuEncryptMode);
    }

    public Long getOnuEncryptKeyExchangeTime() {
        return (Long) getProperty(onuEncryptKeyExchangeTime).getValue();
    }

    public void setOnuEncryptKeyExchangeTime(Long aOnuEncryptKeyExchangeTime) {
        getProperty(onuEncryptKeyExchangeTime).setValue(aOnuEncryptKeyExchangeTime);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuGePortNum));
        prepareRead(getProperty(onuGePortBitmap));
        prepareRead(getProperty(onuFePortNum));
        prepareRead(getProperty(onuFePortBitmap));
        prepareRead(getProperty(onuQueueNumUplink));
        prepareRead(getProperty(onuMaxQueueNumUplink));
        prepareRead(getProperty(onuQueueNumDownlink));
        prepareRead(getProperty(onuMaxQueueNumDownlink));
        prepareRead(getProperty(onuFecEnable));
        prepareRead(getProperty(onuEncryptMode));
        prepareRead(getProperty(onuEncryptKeyExchangeTime));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuGePortNum));
        prepareRead(getProperty(onuGePortBitmap));
        prepareRead(getProperty(onuFePortNum));
        prepareRead(getProperty(onuFePortBitmap));
        prepareRead(getProperty(onuQueueNumUplink));
        prepareRead(getProperty(onuMaxQueueNumUplink));
        prepareRead(getProperty(onuQueueNumDownlink));
        prepareRead(getProperty(onuMaxQueueNumDownlink));
        prepareRead(getProperty(onuFecEnable));
        prepareRead(getProperty(onuEncryptMode));
        prepareRead(getProperty(onuEncryptKeyExchangeTime));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuFecEnable));

        return save();
    }

}
/**
 * Created by Zhou Chao, 2010/3/5
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PonBroadcastStormSuppressionTable extends SnmpMibBean {

    public static final String bsDeviceIndex = "bsDeviceIndex";
    public static final String bsCardIndex = "bsCardIndex";
    public static final String bsPortIndex = "bsPortIndex";
    public static final String unicastStormEnable = "unicastStormEnable";
    public static final String unicastStormInPacketRate = "unicastStormInPacketRate";
    public static final String unicastStormOutPacketRate = "unicastStormOutPacketRate";
    public static final String multicastStormEnable = "multicastStormEnable";
    public static final String multicastStormInPacketRate = "multicastStormInPacketRate";
    public static final String multicastStormOutPacketRate = "multicastStormOutPacketRate";
    public static final String broadcastStormEnable = "broadcastStormEnable";
    public static final String broadcastStormInPacketRate = "broadcastStormInPacketRate";
    public static final String broadcastStormOutPacketRate = "broadcastStormOutPacketRate";

    public PonBroadcastStormSuppressionTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(bsDeviceIndex, new SnmpMibBeanProperty(bsDeviceIndex, ".1.3.6.1.4.1.17409.2.3.3.3.1.1", ISnmpConstant.INTEGER));
        initProperty(bsCardIndex, new SnmpMibBeanProperty(bsCardIndex, ".1.3.6.1.4.1.17409.2.3.3.3.1.2", ISnmpConstant.GAUGE));
        initProperty(bsPortIndex, new SnmpMibBeanProperty(bsPortIndex, ".1.3.6.1.4.1.17409.2.3.3.3.1.3", ISnmpConstant.INTEGER));
        initProperty(unicastStormEnable, new SnmpMibBeanProperty(unicastStormEnable, ".1.3.6.1.4.1.17409.2.3.3.3.1.4", ISnmpConstant.INTEGER));
        initProperty(unicastStormInPacketRate, new SnmpMibBeanProperty(unicastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.3.3.1.5", ISnmpConstant.INTEGER));
        initProperty(unicastStormOutPacketRate, new SnmpMibBeanProperty(unicastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.3.3.1.6", ISnmpConstant.INTEGER));
        initProperty(multicastStormEnable, new SnmpMibBeanProperty(multicastStormEnable, ".1.3.6.1.4.1.17409.2.3.3.3.1.7", ISnmpConstant.INTEGER));
        initProperty(multicastStormInPacketRate, new SnmpMibBeanProperty(multicastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.3.3.1.8", ISnmpConstant.INTEGER));
        initProperty(multicastStormOutPacketRate, new SnmpMibBeanProperty(multicastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.3.3.1.9", ISnmpConstant.INTEGER));
        initProperty(broadcastStormEnable, new SnmpMibBeanProperty(broadcastStormEnable, ".1.3.6.1.4.1.17409.2.3.3.3.1.10", ISnmpConstant.INTEGER));
        initProperty(broadcastStormInPacketRate, new SnmpMibBeanProperty(broadcastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.3.3.1.11", ISnmpConstant.INTEGER));
        initProperty(broadcastStormOutPacketRate, new SnmpMibBeanProperty(broadcastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.3.3.1.12", ISnmpConstant.INTEGER));
    }

    public Integer getBsDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setBsDeviceIndex(Integer aBsDeviceIndex) {
        setIndex(0, aBsDeviceIndex);
    }

    public Long getBsCardIndex() {
        return (Long) getIndex(1);
    }

    public void setBsCardIndex(Long aBsCardIndex) {
        setIndex(1, aBsCardIndex);
    }

    public Integer getBsPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setBsPortIndex(Integer aBsPortIndex) {
        setIndex(2, aBsPortIndex);
    }

    public Integer getUnicastStormEnable() {
        return (Integer) getProperty(unicastStormEnable).getValue();
    }

    public void setUnicastStormEnable(Integer aUnicastStormEnable) {
        getProperty(unicastStormEnable).setValue(aUnicastStormEnable);
    }

    public Integer getUnicastStormInPacketRate() {
        return (Integer) getProperty(unicastStormInPacketRate).getValue();
    }

    public void setUnicastStormInPacketRate(Integer aUnicastStormInPacketRate) {
        getProperty(unicastStormInPacketRate).setValue(aUnicastStormInPacketRate);
    }

    public Integer getUnicastStormOutPacketRate() {
        return (Integer) getProperty(unicastStormOutPacketRate).getValue();
    }

    public void setUnicastStormOutPacketRate(Integer aUnicastStormOutPacketRate) {
        getProperty(unicastStormOutPacketRate).setValue(aUnicastStormOutPacketRate);
    }

    public Integer getMulticastStormEnable() {
        return (Integer) getProperty(multicastStormEnable).getValue();
    }

    public void setMulticastStormEnable(Integer aMulticastStormEnable) {
        getProperty(multicastStormEnable).setValue(aMulticastStormEnable);
    }

    public Integer getMulticastStormInPacketRate() {
        return (Integer) getProperty(multicastStormInPacketRate).getValue();
    }

    public void setMulticastStormInPacketRate(Integer aMulticastStormInPacketRate) {
        getProperty(multicastStormInPacketRate).setValue(aMulticastStormInPacketRate);
    }

    public Integer getMulticastStormOutPacketRate() {
        return (Integer) getProperty(multicastStormOutPacketRate).getValue();
    }

    public void setMulticastStormOutPacketRate(Integer aMulticastStormOutPacketRate) {
        getProperty(multicastStormOutPacketRate).setValue(aMulticastStormOutPacketRate);
    }

    public Integer getBroadcastStormEnable() {
        return (Integer) getProperty(broadcastStormEnable).getValue();
    }

    public void setBroadcastStormEnable(Integer aBroadcastStormEnable) {
        getProperty(broadcastStormEnable).setValue(aBroadcastStormEnable);
    }

    public Integer getBroadcastStormInPacketRate() {
        return (Integer) getProperty(broadcastStormInPacketRate).getValue();
    }

    public void setBroadcastStormInPacketRate(Integer aBroadcastStormInPacketRate) {
        getProperty(broadcastStormInPacketRate).setValue(aBroadcastStormInPacketRate);
    }

    public Integer getBroadcastStormOutPacketRate() {
        return (Integer) getProperty(broadcastStormOutPacketRate).getValue();
    }

    public void setBroadcastStormOutPacketRate(Integer aBroadcastStormOutPacketRate) {
        getProperty(broadcastStormOutPacketRate).setValue(aBroadcastStormOutPacketRate);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(unicastStormEnable));
        prepareRead(getProperty(unicastStormInPacketRate));
        prepareRead(getProperty(unicastStormOutPacketRate));
        prepareRead(getProperty(multicastStormEnable));
        prepareRead(getProperty(multicastStormInPacketRate));
        prepareRead(getProperty(multicastStormOutPacketRate));
        prepareRead(getProperty(broadcastStormEnable));
        prepareRead(getProperty(broadcastStormInPacketRate));
        prepareRead(getProperty(broadcastStormOutPacketRate));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(unicastStormEnable));
        prepareRead(getProperty(unicastStormInPacketRate));
        prepareRead(getProperty(unicastStormOutPacketRate));
        prepareRead(getProperty(multicastStormEnable));
        prepareRead(getProperty(multicastStormInPacketRate));
        prepareRead(getProperty(multicastStormOutPacketRate));
        prepareRead(getProperty(broadcastStormEnable));
        prepareRead(getProperty(broadcastStormInPacketRate));
        prepareRead(getProperty(broadcastStormOutPacketRate));

        return loadAll(new int[]{1, 2, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(unicastStormEnable));
        prepareSave(getProperty(unicastStormInPacketRate));
        prepareSave(getProperty(unicastStormOutPacketRate));
        prepareSave(getProperty(multicastStormEnable));
        prepareSave(getProperty(multicastStormInPacketRate));
        prepareSave(getProperty(multicastStormOutPacketRate));
        prepareSave(getProperty(broadcastStormEnable));
        prepareSave(getProperty(broadcastStormInPacketRate));
        prepareSave(getProperty(broadcastStormOutPacketRate));

        return save();
    }

}
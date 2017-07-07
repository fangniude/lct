package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The SniBroadcastStormSuppressionTable class.
 * Created by QuickDVM
 */
public class SniBroadcastStormSuppressionTable extends SnmpMibBean {
    public static final String sniBroadcastStormSuppressionDeviceIndex = "sniBroadcastStormSuppressionDeviceIndex";
    public static final String sniBroadcastStormSuppressionCardIndex = "sniBroadcastStormSuppressionCardIndex";
    public static final String sniBroadcastStormSuppressionPortIndex = "sniBroadcastStormSuppressionPortIndex";
    public static final String sniUnicastStormEnable = "sniUnicastStormEnable";
    public static final String sniUnicastStormInPacketRate = "sniUnicastStormInPacketRate";
    public static final String sniUnicastStormOutPacketRate = "sniUnicastStormOutPacketRate";
    public static final String sniMulticastStormEnable = "sniMulticastStormEnable";
    public static final String sniMulticastStormInPacketRate = "sniMulticastStormInPacketRate";
    public static final String sniMulticastStormOutPacketRate = "sniMulticastStormOutPacketRate";
    public static final String sniBroadcastStormEnable = "sniBroadcastStormEnable";
    public static final String sniBroadcastStormInPacketRate = "sniBroadcastStormInPacketRate";
    public static final String sniBroadcastStormOutPacketRate = "sniBroadcastStormOutPacketRate";

    public SniBroadcastStormSuppressionTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(sniBroadcastStormSuppressionDeviceIndex, new SnmpMibBeanProperty(sniBroadcastStormSuppressionDeviceIndex, ".1.3.6.1.4.1.17409.2.3.2.5.1.1", ISnmpConstant.INTEGER));
        initProperty(sniBroadcastStormSuppressionCardIndex, new SnmpMibBeanProperty(sniBroadcastStormSuppressionCardIndex, ".1.3.6.1.4.1.17409.2.3.2.5.1.2", ISnmpConstant.INTEGER));
        initProperty(sniBroadcastStormSuppressionPortIndex, new SnmpMibBeanProperty(sniBroadcastStormSuppressionPortIndex, ".1.3.6.1.4.1.17409.2.3.2.5.1.3", ISnmpConstant.INTEGER));
        initProperty(sniUnicastStormEnable, new SnmpMibBeanProperty(sniUnicastStormEnable, ".1.3.6.1.4.1.17409.2.3.2.5.1.4", ISnmpConstant.INTEGER));
        initProperty(sniUnicastStormInPacketRate, new SnmpMibBeanProperty(sniUnicastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.2.5.1.5", ISnmpConstant.INTEGER));
        initProperty(sniUnicastStormOutPacketRate, new SnmpMibBeanProperty(sniUnicastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.2.5.1.6", ISnmpConstant.INTEGER));
        initProperty(sniMulticastStormEnable, new SnmpMibBeanProperty(sniMulticastStormEnable, ".1.3.6.1.4.1.17409.2.3.2.5.1.7", ISnmpConstant.INTEGER));
        initProperty(sniMulticastStormInPacketRate, new SnmpMibBeanProperty(sniMulticastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.2.5.1.8", ISnmpConstant.INTEGER));
        initProperty(sniMulticastStormOutPacketRate, new SnmpMibBeanProperty(sniMulticastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.2.5.1.9", ISnmpConstant.INTEGER));
        initProperty(sniBroadcastStormEnable, new SnmpMibBeanProperty(sniBroadcastStormEnable, ".1.3.6.1.4.1.17409.2.3.2.5.1.10", ISnmpConstant.INTEGER));
        initProperty(sniBroadcastStormInPacketRate, new SnmpMibBeanProperty(sniBroadcastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.2.5.1.11", ISnmpConstant.INTEGER));
        initProperty(sniBroadcastStormOutPacketRate, new SnmpMibBeanProperty(sniBroadcastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.2.5.1.12", ISnmpConstant.INTEGER));

    }


    public Integer getSniBroadcastStormSuppressionDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setSniBroadcastStormSuppressionDeviceIndex(Integer aSniBroadcastStormSuppressionDeviceIndex) {
        setIndex(0, aSniBroadcastStormSuppressionDeviceIndex);
    }


    public Integer getSniBroadcastStormSuppressionCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setSniBroadcastStormSuppressionCardIndex(Integer aSniBroadcastStormSuppressionCardIndex) {
        setIndex(1, aSniBroadcastStormSuppressionCardIndex);
    }


    public Integer getSniBroadcastStormSuppressionPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setSniBroadcastStormSuppressionPortIndex(Integer aSniBroadcastStormSuppressionPortIndex) {
        setIndex(2, aSniBroadcastStormSuppressionPortIndex);
    }


    public Integer getSniUnicastStormEnable() {
        return (Integer) getProperty(sniUnicastStormEnable).getValue();
    }

    public void setSniUnicastStormEnable(Integer aSniUnicastStormEnable) {
        getProperty(sniUnicastStormEnable).setValue(aSniUnicastStormEnable);
    }

    public Integer getSniUnicastStormInPacketRate() {
        return (Integer) getProperty(sniUnicastStormInPacketRate).getValue();
    }

    public void setSniUnicastStormInPacketRate(Integer aSniUnicastStormInPacketRate) {
        getProperty(sniUnicastStormInPacketRate).setValue(aSniUnicastStormInPacketRate);
    }

    public Integer getSniUnicastStormOutPacketRate() {
        return (Integer) getProperty(sniUnicastStormOutPacketRate).getValue();
    }

    public void setSniUnicastStormOutPacketRate(Integer aSniUnicastStormOutPacketRate) {
        getProperty(sniUnicastStormOutPacketRate).setValue(aSniUnicastStormOutPacketRate);
    }

    public Integer getSniMulticastStormEnable() {
        return (Integer) getProperty(sniMulticastStormEnable).getValue();
    }

    public void setSniMulticastStormEnable(Integer aSniMulticastStormEnable) {
        getProperty(sniMulticastStormEnable).setValue(aSniMulticastStormEnable);
    }

    public Integer getSniMulticastStormInPacketRate() {
        return (Integer) getProperty(sniMulticastStormInPacketRate).getValue();
    }

    public void setSniMulticastStormInPacketRate(Integer aSniMulticastStormInPacketRate) {
        getProperty(sniMulticastStormInPacketRate).setValue(aSniMulticastStormInPacketRate);
    }

    public Integer getSniMulticastStormOutPacketRate() {
        return (Integer) getProperty(sniMulticastStormOutPacketRate).getValue();
    }

    public void setSniMulticastStormOutPacketRate(Integer aSniMulticastStormOutPacketRate) {
        getProperty(sniMulticastStormOutPacketRate).setValue(aSniMulticastStormOutPacketRate);
    }

    public Integer getSniBroadcastStormEnable() {
        return (Integer) getProperty(sniBroadcastStormEnable).getValue();
    }

    public void setSniBroadcastStormEnable(Integer aSniBroadcastStormEnable) {
        getProperty(sniBroadcastStormEnable).setValue(aSniBroadcastStormEnable);
    }

    public Integer getSniBroadcastStormInPacketRate() {
        return (Integer) getProperty(sniBroadcastStormInPacketRate).getValue();
    }

    public void setSniBroadcastStormInPacketRate(Integer aSniBroadcastStormInPacketRate) {
        getProperty(sniBroadcastStormInPacketRate).setValue(aSniBroadcastStormInPacketRate);
    }

    public Integer getSniBroadcastStormOutPacketRate() {
        return (Integer) getProperty(sniBroadcastStormOutPacketRate).getValue();
    }

    public void setSniBroadcastStormOutPacketRate(Integer aSniBroadcastStormOutPacketRate) {
        getProperty(sniBroadcastStormOutPacketRate).setValue(aSniBroadcastStormOutPacketRate);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(sniUnicastStormEnable));
        prepareRead(super.getProperty(sniUnicastStormInPacketRate));
        prepareRead(super.getProperty(sniUnicastStormOutPacketRate));
        prepareRead(super.getProperty(sniMulticastStormEnable));
        prepareRead(super.getProperty(sniMulticastStormInPacketRate));
        prepareRead(super.getProperty(sniMulticastStormOutPacketRate));
        prepareRead(super.getProperty(sniBroadcastStormEnable));
        prepareRead(super.getProperty(sniBroadcastStormInPacketRate));
        prepareRead(super.getProperty(sniBroadcastStormOutPacketRate));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(sniUnicastStormEnable));
        prepareRead(super.getProperty(sniUnicastStormInPacketRate));
        prepareRead(super.getProperty(sniUnicastStormOutPacketRate));
        prepareRead(super.getProperty(sniMulticastStormEnable));
        prepareRead(super.getProperty(sniMulticastStormInPacketRate));
        prepareRead(super.getProperty(sniMulticastStormOutPacketRate));
        prepareRead(super.getProperty(sniBroadcastStormEnable));
        prepareRead(super.getProperty(sniBroadcastStormInPacketRate));
        prepareRead(super.getProperty(sniBroadcastStormOutPacketRate));

        return loadAll(new int[]{1
                , 1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(sniUnicastStormEnable));
        prepareSave(getProperty(sniUnicastStormOutPacketRate));
        prepareSave(getProperty(sniUnicastStormInPacketRate));
        prepareSave(getProperty(sniMulticastStormEnable));
        prepareSave(getProperty(sniMulticastStormOutPacketRate));
        prepareSave(getProperty(sniMulticastStormInPacketRate));
        prepareSave(getProperty(sniBroadcastStormEnable));
        prepareSave(getProperty(sniBroadcastStormOutPacketRate));
        prepareSave(getProperty(sniBroadcastStormInPacketRate));

        return save();
    }


}
    
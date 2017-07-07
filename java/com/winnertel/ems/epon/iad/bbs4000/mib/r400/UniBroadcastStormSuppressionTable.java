/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class UniBroadcastStormSuppressionTable extends SnmpMibBean {

    public static final String uniBroadcastStormSuppressionCardIndex = "uniBroadcastStormSuppressionCardIndex";
    public static final String uniBroadcastStormSuppressionPortIndex = "uniBroadcastStormSuppressionPortIndex";
    public static final String uniUnicastStormEnable = "uniUnicastStormEnable";
    public static final String uniUnicastStormInPacketRate = "uniUnicastStormInPacketRate";
    public static final String uniUnicastStormOutPacketRate = "uniUnicastStormOutPacketRate";
    public static final String uniMulticastStormEnable = "uniMulticastStormEnable";
    public static final String uniMulticastStormInPacketRate = "uniMulticastStormInPacketRate";
    public static final String uniMulticastStormOutPacketRate = "uniMulticastStormOutPacketRate";
    public static final String uniBroadcastStormEnable = "uniBroadcastStormEnable";
    public static final String uniBroadcastStormInPacketRate = "uniBroadcastStormInPacketRate";
    public static final String uniBroadcastStormOutPacketRate = "uniBroadcastStormOutPacketRate";

    public UniBroadcastStormSuppressionTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniBroadcastStormSuppressionCardIndex, new SnmpMibBeanProperty(uniBroadcastStormSuppressionCardIndex, ".1.3.6.1.4.1.17409.2.3.5.6.1.1", ISnmpConstant.INTEGER));
        initProperty(uniBroadcastStormSuppressionPortIndex, new SnmpMibBeanProperty(uniBroadcastStormSuppressionPortIndex, ".1.3.6.1.4.1.17409.2.3.5.6.1.2", ISnmpConstant.INTEGER));
        initProperty(uniUnicastStormEnable, new SnmpMibBeanProperty(uniUnicastStormEnable, ".1.3.6.1.4.1.17409.2.3.5.6.1.3", ISnmpConstant.INTEGER));
        initProperty(uniUnicastStormInPacketRate, new SnmpMibBeanProperty(uniUnicastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.5.6.1.4", ISnmpConstant.INTEGER));
        initProperty(uniUnicastStormOutPacketRate, new SnmpMibBeanProperty(uniUnicastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.5.6.1.5", ISnmpConstant.INTEGER));
        initProperty(uniMulticastStormEnable, new SnmpMibBeanProperty(uniMulticastStormEnable, ".1.3.6.1.4.1.17409.2.3.5.6.1.6", ISnmpConstant.INTEGER));
        initProperty(uniMulticastStormInPacketRate, new SnmpMibBeanProperty(uniMulticastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.5.6.1.7", ISnmpConstant.INTEGER));
        initProperty(uniMulticastStormOutPacketRate, new SnmpMibBeanProperty(uniMulticastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.5.6.1.8", ISnmpConstant.INTEGER));
        initProperty(uniBroadcastStormEnable, new SnmpMibBeanProperty(uniBroadcastStormEnable, ".1.3.6.1.4.1.17409.2.3.5.6.1.9", ISnmpConstant.INTEGER));
        initProperty(uniBroadcastStormInPacketRate, new SnmpMibBeanProperty(uniBroadcastStormInPacketRate, ".1.3.6.1.4.1.17409.2.3.5.6.1.10", ISnmpConstant.INTEGER));
        initProperty(uniBroadcastStormOutPacketRate, new SnmpMibBeanProperty(uniBroadcastStormOutPacketRate, ".1.3.6.1.4.1.17409.2.3.5.6.1.11", ISnmpConstant.INTEGER));
    }

    public Integer getUniBroadcastStormSuppressionCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setUniBroadcastStormSuppressionCardIndex(Integer aUniBroadcastStormSuppressionCardIndex) {
        setIndex(0, aUniBroadcastStormSuppressionCardIndex);
    }

    public Integer getUniBroadcastStormSuppressionPortIndex() {
        return (Integer) getIndex(1);
    }

    public void setUniBroadcastStormSuppressionPortIndex(Integer aUniBroadcastStormSuppressionPortIndex) {
        setIndex(1, aUniBroadcastStormSuppressionPortIndex);
    }

    public Integer getUniUnicastStormEnable() {
        return (Integer) getProperty(uniUnicastStormEnable).getValue();
    }

    public void setUniUnicastStormEnable(Integer aUniUnicastStormEnable) {
        getProperty(uniUnicastStormEnable).setValue(aUniUnicastStormEnable);
    }

    public Integer getUniUnicastStormInPacketRate() {
        return (Integer) getProperty(uniUnicastStormInPacketRate).getValue();
    }

    public void setUniUnicastStormInPacketRate(Integer aUniUnicastStormInPacketRate) {
        getProperty(uniUnicastStormInPacketRate).setValue(aUniUnicastStormInPacketRate);
    }

    public Integer getUniUnicastStormOutPacketRate() {
        return (Integer) getProperty(uniUnicastStormOutPacketRate).getValue();
    }

    public void setUniUnicastStormOutPacketRate(Integer aUniUnicastStormOutPacketRate) {
        getProperty(uniUnicastStormOutPacketRate).setValue(aUniUnicastStormOutPacketRate);
    }

    public Integer getUniMulticastStormEnable() {
        return (Integer) getProperty(uniMulticastStormEnable).getValue();
    }

    public void setUniMulticastStormEnable(Integer aUniMulticastStormEnable) {
        getProperty(uniMulticastStormEnable).setValue(aUniMulticastStormEnable);
    }

    public Integer getUniMulticastStormInPacketRate() {
        return (Integer) getProperty(uniMulticastStormInPacketRate).getValue();
    }

    public void setUniMulticastStormInPacketRate(Integer aUniMulticastStormInPacketRate) {
        getProperty(uniMulticastStormInPacketRate).setValue(aUniMulticastStormInPacketRate);
    }

    public Integer getUniMulticastStormOutPacketRate() {
        return (Integer) getProperty(uniMulticastStormOutPacketRate).getValue();
    }

    public void setUniMulticastStormOutPacketRate(Integer aUniMulticastStormOutPacketRate) {
        getProperty(uniMulticastStormOutPacketRate).setValue(aUniMulticastStormOutPacketRate);
    }

    public Integer getUniBroadcastStormEnable() {
        return (Integer) getProperty(uniBroadcastStormEnable).getValue();
    }

    public void setUniBroadcastStormEnable(Integer aUniBroadcastStormEnable) {
        getProperty(uniBroadcastStormEnable).setValue(aUniBroadcastStormEnable);
    }

    public Integer getUniBroadcastStormInPacketRate() {
        return (Integer) getProperty(uniBroadcastStormInPacketRate).getValue();
    }

    public void setUniBroadcastStormInPacketRate(Integer aUniBroadcastStormInPacketRate) {
        getProperty(uniBroadcastStormInPacketRate).setValue(aUniBroadcastStormInPacketRate);
    }

    public Integer getUniBroadcastStormOutPacketRate() {
        return (Integer) getProperty(uniBroadcastStormOutPacketRate).getValue();
    }

    public void setUniBroadcastStormOutPacketRate(Integer aUniBroadcastStormOutPacketRate) {
        getProperty(uniBroadcastStormOutPacketRate).setValue(aUniBroadcastStormOutPacketRate);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniUnicastStormEnable));
        prepareRead(getProperty(uniUnicastStormInPacketRate));
        prepareRead(getProperty(uniUnicastStormOutPacketRate));
        prepareRead(getProperty(uniMulticastStormEnable));
        prepareRead(getProperty(uniMulticastStormInPacketRate));
        prepareRead(getProperty(uniMulticastStormOutPacketRate));
        prepareRead(getProperty(uniBroadcastStormEnable));
        prepareRead(getProperty(uniBroadcastStormInPacketRate));
        prepareRead(getProperty(uniBroadcastStormOutPacketRate));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(uniUnicastStormEnable));
        prepareRead(getProperty(uniUnicastStormInPacketRate));
        prepareRead(getProperty(uniUnicastStormOutPacketRate));
        prepareRead(getProperty(uniMulticastStormEnable));
        prepareRead(getProperty(uniMulticastStormInPacketRate));
        prepareRead(getProperty(uniMulticastStormOutPacketRate));
        prepareRead(getProperty(uniBroadcastStormEnable));
        prepareRead(getProperty(uniBroadcastStormInPacketRate));
        prepareRead(getProperty(uniBroadcastStormOutPacketRate));

        return loadAll(new int[]{1, 1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniUnicastStormEnable));
        prepareSave(getProperty(uniUnicastStormInPacketRate));
        prepareSave(getProperty(uniUnicastStormOutPacketRate));
        prepareSave(getProperty(uniMulticastStormEnable));
        prepareSave(getProperty(uniMulticastStormInPacketRate));
        prepareSave(getProperty(uniMulticastStormOutPacketRate));
        prepareSave(getProperty(uniBroadcastStormEnable));
        prepareSave(getProperty(uniBroadcastStormInPacketRate));
        prepareSave(getProperty(uniBroadcastStormOutPacketRate));

        return save();
    }

}
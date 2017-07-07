package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

/**
 * The ModEoCRealTimeStatisticTable class.
 * Created by QuickDVM
 */
public class ModEoCRealTimeStatisticTable extends SnmpMibBean {
    public static final String modEoCRealTimeStatisticCBATCardIndex = "modEoCRealTimeStatisticCBATCardIndex";
    public static final String modEoCRealTimeStatisticCNUIndex = "modEoCRealTimeStatisticCNUIndex";
    public static final String modEoCRealTimeStatisticTxByte = "modEoCRealTimeStatisticTxByte";
    public static final String modEoCRealTimeStatisticRxByte = "modEoCRealTimeStatisticRxByte";
    public static final String modEoCRealTimeStatisticTxPkt = "modEoCRealTimeStatisticTxPkt";
    public static final String modEoCRealTimeStatisticRxPkt = "modEoCRealTimeStatisticRxPkt";
    public static final String modEoCRealTimeStatisticTxBcast = "modEoCRealTimeStatisticTxBcast";
    public static final String modEoCRealTimeStatisticRxBcast = "modEoCRealTimeStatisticRxBcast";
    public static final String modEoCRealTimeStatisticTxMcast = "modEoCRealTimeStatisticTxMcast";
    public static final String modEoCRealTimeStatisticRxMcast = "modEoCRealTimeStatisticRxMcast";
    public static final String modEoCRealTimeStatisticRxCrc = "modEoCRealTimeStatisticRxCrc";
    public static final String modEoCRealTimeStatisticTxShort = "modEoCRealTimeStatisticTxShort";
    public static final String modEoCRealTimeStatisticRxShort = "modEoCRealTimeStatisticRxShort";
    public static final String modEoCRealTimeStatisticTxDropped = "modEoCRealTimeStatisticTxDropped";
    public static final String modEoCRealTimeStatisticRxDropped = "modEoCRealTimeStatisticRxDropped";
    public static final String modEoCRealTimeStatisticAveragePreFEC = "modEoCRealTimeStatisticAveragePreFEC";
    public static final String modEoCRealTimeStatisticReset = "modEoCRealTimeStatisticReset";

    public ModEoCRealTimeStatisticTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCRealTimeStatisticCBATCardIndex, new SnmpMibBeanProperty(modEoCRealTimeStatisticCBATCardIndex, ".1.3.6.1.4.1.17409.2.4.6.1.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticCNUIndex, new SnmpMibBeanProperty(modEoCRealTimeStatisticCNUIndex, ".1.3.6.1.4.1.17409.2.4.6.1.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticTxByte, new SnmpMibBeanProperty(modEoCRealTimeStatisticTxByte, ".1.3.6.1.4.1.17409.2.4.6.1.1.3", ISnmpConstant.COUNTER64));
        initProperty(modEoCRealTimeStatisticRxByte, new SnmpMibBeanProperty(modEoCRealTimeStatisticRxByte, ".1.3.6.1.4.1.17409.2.4.6.1.1.4", ISnmpConstant.COUNTER64));
        initProperty(modEoCRealTimeStatisticTxPkt, new SnmpMibBeanProperty(modEoCRealTimeStatisticTxPkt, ".1.3.6.1.4.1.17409.2.4.6.1.1.5", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticRxPkt, new SnmpMibBeanProperty(modEoCRealTimeStatisticRxPkt, ".1.3.6.1.4.1.17409.2.4.6.1.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticTxBcast, new SnmpMibBeanProperty(modEoCRealTimeStatisticTxBcast, ".1.3.6.1.4.1.17409.2.4.6.1.1.7", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticRxBcast, new SnmpMibBeanProperty(modEoCRealTimeStatisticRxBcast, ".1.3.6.1.4.1.17409.2.4.6.1.1.8", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticTxMcast, new SnmpMibBeanProperty(modEoCRealTimeStatisticTxMcast, ".1.3.6.1.4.1.17409.2.4.6.1.1.9", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticRxMcast, new SnmpMibBeanProperty(modEoCRealTimeStatisticRxMcast, ".1.3.6.1.4.1.17409.2.4.6.1.1.10", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticRxCrc, new SnmpMibBeanProperty(modEoCRealTimeStatisticRxCrc, ".1.3.6.1.4.1.17409.2.4.6.1.1.11", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticTxShort, new SnmpMibBeanProperty(modEoCRealTimeStatisticTxShort, ".1.3.6.1.4.1.17409.2.4.6.1.1.12", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticRxShort, new SnmpMibBeanProperty(modEoCRealTimeStatisticRxShort, ".1.3.6.1.4.1.17409.2.4.6.1.1.13", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticTxDropped, new SnmpMibBeanProperty(modEoCRealTimeStatisticTxDropped, ".1.3.6.1.4.1.17409.2.4.6.1.1.14", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticRxDropped, new SnmpMibBeanProperty(modEoCRealTimeStatisticRxDropped, ".1.3.6.1.4.1.17409.2.4.6.1.1.15", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticAveragePreFEC, new SnmpMibBeanProperty(modEoCRealTimeStatisticAveragePreFEC, ".1.3.6.1.4.1.17409.2.4.6.1.1.16", ISnmpConstant.INTEGER));
        initProperty(modEoCRealTimeStatisticReset, new SnmpMibBeanProperty(modEoCRealTimeStatisticReset, ".1.3.6.1.4.1.17409.2.4.6.1.1.17", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCRealTimeStatisticCBATCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCRealTimeStatisticCBATCardIndex(Integer aModEoCRealTimeStatisticCBATCardIndex) {
        setIndex(0, aModEoCRealTimeStatisticCBATCardIndex);
    }


    public Integer getModEoCRealTimeStatisticCNUIndex() {
        return (Integer) getIndex(1);
    }

    public void setModEoCRealTimeStatisticCNUIndex(Integer aModEoCRealTimeStatisticCNUIndex) {
        setIndex(1, aModEoCRealTimeStatisticCNUIndex);
    }


    public BigInteger getModEoCRealTimeStatisticTxByte() {
        return (BigInteger) getProperty(modEoCRealTimeStatisticTxByte).getValue();
    }

    public void setModEoCRealTimeStatisticTxByte(BigInteger aModEoCRealTimeStatisticTxByte) {
        getProperty(modEoCRealTimeStatisticTxByte).setValue(aModEoCRealTimeStatisticTxByte);
    }

    public BigInteger getModEoCRealTimeStatisticRxByte() {
        return (BigInteger) getProperty(modEoCRealTimeStatisticRxByte).getValue();
    }

    public void setModEoCRealTimeStatisticRxByte(BigInteger aModEoCRealTimeStatisticRxByte) {
        getProperty(modEoCRealTimeStatisticRxByte).setValue(aModEoCRealTimeStatisticRxByte);
    }

    public Integer getModEoCRealTimeStatisticTxPkt() {
        return (Integer) getProperty(modEoCRealTimeStatisticTxPkt).getValue();
    }

    public void setModEoCRealTimeStatisticTxPkt(Integer aModEoCRealTimeStatisticTxPkt) {
        getProperty(modEoCRealTimeStatisticTxPkt).setValue(aModEoCRealTimeStatisticTxPkt);
    }

    public Integer getModEoCRealTimeStatisticRxPkt() {
        return (Integer) getProperty(modEoCRealTimeStatisticRxPkt).getValue();
    }

    public void setModEoCRealTimeStatisticRxPkt(Integer aModEoCRealTimeStatisticRxPkt) {
        getProperty(modEoCRealTimeStatisticRxPkt).setValue(aModEoCRealTimeStatisticRxPkt);
    }

    public Integer getModEoCRealTimeStatisticTxBcast() {
        return (Integer) getProperty(modEoCRealTimeStatisticTxBcast).getValue();
    }

    public void setModEoCRealTimeStatisticTxBcast(Integer aModEoCRealTimeStatisticTxBcast) {
        getProperty(modEoCRealTimeStatisticTxBcast).setValue(aModEoCRealTimeStatisticTxBcast);
    }

    public Integer getModEoCRealTimeStatisticRxBcast() {
        return (Integer) getProperty(modEoCRealTimeStatisticRxBcast).getValue();
    }

    public void setModEoCRealTimeStatisticRxBcast(Integer aModEoCRealTimeStatisticRxBcast) {
        getProperty(modEoCRealTimeStatisticRxBcast).setValue(aModEoCRealTimeStatisticRxBcast);
    }

    public Integer getModEoCRealTimeStatisticTxMcast() {
        return (Integer) getProperty(modEoCRealTimeStatisticTxMcast).getValue();
    }

    public void setModEoCRealTimeStatisticTxMcast(Integer aModEoCRealTimeStatisticTxMcast) {
        getProperty(modEoCRealTimeStatisticTxMcast).setValue(aModEoCRealTimeStatisticTxMcast);
    }

    public Integer getModEoCRealTimeStatisticRxMcast() {
        return (Integer) getProperty(modEoCRealTimeStatisticRxMcast).getValue();
    }

    public void setModEoCRealTimeStatisticRxMcast(Integer aModEoCRealTimeStatisticRxMcast) {
        getProperty(modEoCRealTimeStatisticRxMcast).setValue(aModEoCRealTimeStatisticRxMcast);
    }

    public Integer getModEoCRealTimeStatisticRxCrc() {
        return (Integer) getProperty(modEoCRealTimeStatisticRxCrc).getValue();
    }

    public void setModEoCRealTimeStatisticRxCrc(Integer aModEoCRealTimeStatisticRxCrc) {
        getProperty(modEoCRealTimeStatisticRxCrc).setValue(aModEoCRealTimeStatisticRxCrc);
    }

    public Integer getModEoCRealTimeStatisticTxShort() {
        return (Integer) getProperty(modEoCRealTimeStatisticTxShort).getValue();
    }

    public void setModEoCRealTimeStatisticTxShort(Integer aModEoCRealTimeStatisticTxShort) {
        getProperty(modEoCRealTimeStatisticTxShort).setValue(aModEoCRealTimeStatisticTxShort);
    }

    public Integer getModEoCRealTimeStatisticRxShort() {
        return (Integer) getProperty(modEoCRealTimeStatisticRxShort).getValue();
    }

    public void setModEoCRealTimeStatisticRxShort(Integer aModEoCRealTimeStatisticRxShort) {
        getProperty(modEoCRealTimeStatisticRxShort).setValue(aModEoCRealTimeStatisticRxShort);
    }

    public Integer getModEoCRealTimeStatisticTxDropped() {
        return (Integer) getProperty(modEoCRealTimeStatisticTxDropped).getValue();
    }

    public void setModEoCRealTimeStatisticTxDropped(Integer aModEoCRealTimeStatisticTxDropped) {
        getProperty(modEoCRealTimeStatisticTxDropped).setValue(aModEoCRealTimeStatisticTxDropped);
    }

    public Integer getModEoCRealTimeStatisticRxDropped() {
        return (Integer) getProperty(modEoCRealTimeStatisticRxDropped).getValue();
    }

    public void setModEoCRealTimeStatisticRxDropped(Integer aModEoCRealTimeStatisticRxDropped) {
        getProperty(modEoCRealTimeStatisticRxDropped).setValue(aModEoCRealTimeStatisticRxDropped);
    }

    public Integer getModEoCRealTimeStatisticAveragePreFEC() {
        return (Integer) getProperty(modEoCRealTimeStatisticAveragePreFEC).getValue();
    }

    public void setModEoCRealTimeStatisticAveragePreFEC(Integer aModEoCRealTimeStatisticAveragePreFEC) {
        getProperty(modEoCRealTimeStatisticAveragePreFEC).setValue(aModEoCRealTimeStatisticAveragePreFEC);
    }

    public Integer getModEoCRealTimeStatisticReset() {
        return (Integer) getProperty(modEoCRealTimeStatisticReset).getValue();
    }

    public void setModEoCRealTimeStatisticReset(Integer aModEoCRealTimeStatisticReset) {
        getProperty(modEoCRealTimeStatisticReset).setValue(aModEoCRealTimeStatisticReset);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxByte));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxByte));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxPkt));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxPkt));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxBcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxBcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxMcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxMcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxCrc));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxShort));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxShort));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxDropped));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxDropped));
        prepareRead(super.getProperty(modEoCRealTimeStatisticAveragePreFEC));
        prepareRead(super.getProperty(modEoCRealTimeStatisticReset));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxByte));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxByte));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxPkt));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxPkt));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxBcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxBcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxMcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxMcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxCrc));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxShort));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxShort));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxDropped));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxDropped));
        prepareRead(super.getProperty(modEoCRealTimeStatisticAveragePreFEC));
        prepareRead(super.getProperty(modEoCRealTimeStatisticReset));

        return loadAll(new int[]{1, 1
        });
    }

    public boolean resetStatistic() throws MibBeanException {
        setModEoCRealTimeStatisticReset(1);
        prepareSave(getProperty(modEoCRealTimeStatisticReset));

        return save();
    }

}

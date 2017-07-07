package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 2010-8-9
 * Time: 18:01:48
 * To change this template use File | Settings | File Templates.
 */
public class ModEoCRealTimeStatisticSubTable1 extends ModEoCRealTimeStatisticSubTable {

    public ModEoCRealTimeStatisticSubTable1(ISnmpProxy aSnmpProxy) {
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


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxByte));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxByte));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxPkt));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxPkt));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxBcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxBcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxMcast));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxMcast));


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

        return loadAll(new int[]{1, 1
        });
    }


}

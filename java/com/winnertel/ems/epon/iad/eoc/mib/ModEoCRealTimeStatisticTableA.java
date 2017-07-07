package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

import java.math.BigInteger;
import java.util.Vector;

/**
 * The ModEoCRealTimeStatisticTable class.
 * Created by QuickDVM
 */
public class ModEoCRealTimeStatisticTableA extends SnmpMibBean {

    ModEoCRealTimeStatisticSubTable1 bean1;
    ModEoCRealTimeStatisticSubTable2 bean2;


    public ModEoCRealTimeStatisticTableA(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        bean1 = new ModEoCRealTimeStatisticSubTable1(aSnmpProxy);
        bean2 = new ModEoCRealTimeStatisticSubTable2(aSnmpProxy);
        init();
    }

    protected void init() {
        bean1.init();
        bean2.init();
    }


    public Integer getModEoCRealTimeStatisticCBATCardIndex() {
        return bean1.getModEoCRealTimeStatisticCBATCardIndex();
    }

    public void setModEoCRealTimeStatisticCBATCardIndex(Integer aModEoCRealTimeStatisticCBATCardIndex) {
        bean1.setModEoCRealTimeStatisticCBATCardIndex(aModEoCRealTimeStatisticCBATCardIndex);
        bean2.setModEoCRealTimeStatisticCBATCardIndex(aModEoCRealTimeStatisticCBATCardIndex);
    }


    public Integer getModEoCRealTimeStatisticCNUIndex() {
        return bean1.getModEoCRealTimeStatisticCNUIndex();
    }

    public void setModEoCRealTimeStatisticCNUIndex(Integer aModEoCRealTimeStatisticCNUIndex) {
        bean1.setModEoCRealTimeStatisticCNUIndex(aModEoCRealTimeStatisticCNUIndex);
        bean2.setModEoCRealTimeStatisticCNUIndex(aModEoCRealTimeStatisticCNUIndex);
    }


    public BigInteger getModEoCRealTimeStatisticTxByte() {
        return bean1.getModEoCRealTimeStatisticTxByte();
    }

    public void setModEoCRealTimeStatisticTxByte(BigInteger aModEoCRealTimeStatisticTxByte) {
        bean1.setModEoCRealTimeStatisticTxByte(aModEoCRealTimeStatisticTxByte);
    }

    public BigInteger getModEoCRealTimeStatisticRxByte() {
        return bean1.getModEoCRealTimeStatisticRxByte();
    }

    public void setModEoCRealTimeStatisticRxByte(BigInteger aModEoCRealTimeStatisticRxByte) {
        bean1.setModEoCRealTimeStatisticRxByte(aModEoCRealTimeStatisticRxByte);
    }

    public Integer getModEoCRealTimeStatisticTxPkt() {
        return bean1.getModEoCRealTimeStatisticTxPkt();
    }

    public void setModEoCRealTimeStatisticTxPkt(Integer aModEoCRealTimeStatisticTxPkt) {
        bean1.setModEoCRealTimeStatisticTxPkt(aModEoCRealTimeStatisticTxPkt);
    }

    public Integer getModEoCRealTimeStatisticRxPkt() {
        return bean1.getModEoCRealTimeStatisticRxPkt();
    }

    public void setModEoCRealTimeStatisticRxPkt(Integer aModEoCRealTimeStatisticRxPkt) {
        bean1.setModEoCRealTimeStatisticRxPkt(aModEoCRealTimeStatisticRxPkt);
    }

    public Integer getModEoCRealTimeStatisticTxBcast() {
        return bean1.getModEoCRealTimeStatisticTxBcast();
    }

    public void setModEoCRealTimeStatisticTxBcast(Integer aModEoCRealTimeStatisticTxBcast) {
        bean1.setModEoCRealTimeStatisticTxBcast(aModEoCRealTimeStatisticTxBcast);
    }

    public Integer getModEoCRealTimeStatisticRxBcast() {
        return bean1.getModEoCRealTimeStatisticRxBcast();
    }

    public void setModEoCRealTimeStatisticRxBcast(Integer aModEoCRealTimeStatisticRxBcast) {
        bean1.setModEoCRealTimeStatisticRxBcast(aModEoCRealTimeStatisticRxBcast);
    }

    public Integer getModEoCRealTimeStatisticTxMcast() {
        return bean1.getModEoCRealTimeStatisticTxMcast();
    }

    public void setModEoCRealTimeStatisticTxMcast(Integer aModEoCRealTimeStatisticTxMcast) {
        bean1.setModEoCRealTimeStatisticTxMcast(aModEoCRealTimeStatisticTxMcast);
    }

    public Integer getModEoCRealTimeStatisticRxMcast() {
        return bean1.getModEoCRealTimeStatisticRxMcast();
    }

    public void setModEoCRealTimeStatisticRxMcast(Integer aModEoCRealTimeStatisticRxMcast) {
        bean1.setModEoCRealTimeStatisticRxMcast(aModEoCRealTimeStatisticRxMcast);
    }

    public Integer getModEoCRealTimeStatisticRxCrc() {
        return bean2.getModEoCRealTimeStatisticRxCrc();
    }

    public void setModEoCRealTimeStatisticRxCrc(Integer aModEoCRealTimeStatisticRxCrc) {
        bean2.setModEoCRealTimeStatisticRxCrc(aModEoCRealTimeStatisticRxCrc);
    }

    public Integer getModEoCRealTimeStatisticTxShort() {
        return bean2.getModEoCRealTimeStatisticTxShort();
    }

    public void setModEoCRealTimeStatisticTxShort(Integer aModEoCRealTimeStatisticTxShort) {
        bean2.setModEoCRealTimeStatisticTxShort(aModEoCRealTimeStatisticTxShort);
    }

    public Integer getModEoCRealTimeStatisticRxShort() {
        return bean2.getModEoCRealTimeStatisticRxShort();
    }

    public void setModEoCRealTimeStatisticRxShort(Integer aModEoCRealTimeStatisticRxShort) {
        bean2.setModEoCRealTimeStatisticRxShort(aModEoCRealTimeStatisticRxShort);
    }

    public Integer getModEoCRealTimeStatisticTxDropped() {
        return bean2.getModEoCRealTimeStatisticTxDropped();
    }

    public void setModEoCRealTimeStatisticTxDropped(Integer aModEoCRealTimeStatisticTxDropped) {
        bean2.setModEoCRealTimeStatisticTxDropped(aModEoCRealTimeStatisticTxDropped);
    }

    public Integer getModEoCRealTimeStatisticRxDropped() {
        return bean2.getModEoCRealTimeStatisticRxDropped();
    }

    public void setModEoCRealTimeStatisticRxDropped(Integer aModEoCRealTimeStatisticRxDropped) {
        bean2.setModEoCRealTimeStatisticRxDropped(aModEoCRealTimeStatisticRxDropped);
    }

    public Integer getModEoCRealTimeStatisticAveragePreFEC() {
        return bean2.getModEoCRealTimeStatisticAveragePreFEC();
    }

    public void setModEoCRealTimeStatisticAveragePreFEC(Integer aModEoCRealTimeStatisticAveragePreFEC) {
        bean2.setModEoCRealTimeStatisticAveragePreFEC(aModEoCRealTimeStatisticAveragePreFEC);
    }

    public Integer getModEoCRealTimeStatisticReset() {
        return bean2.getModEoCRealTimeStatisticReset();
    }

    public void setModEoCRealTimeStatisticReset(Integer aModEoCRealTimeStatisticReset) {
        bean2.setModEoCRealTimeStatisticReset(aModEoCRealTimeStatisticReset);
    }


    public boolean retrieve() throws MibBeanException {

        return bean1.retrieve() && bean2.retrieve();

    }

    public Vector retrieveAll() throws MibBeanException {
        Vector v1 = bean1.retrieveAll();
        Vector v2 = bean2.retrieveAll();

        Vector ve = new Vector();
        if (v1 != null && v2 != null) {
            for (int i = 0; i < v1.size(); i++) {
                ModEoCRealTimeStatisticTableA a = new ModEoCRealTimeStatisticTableA(fSnmpProxy);
                a.bean1 = (ModEoCRealTimeStatisticSubTable1) v1.elementAt(i);
                a.bean2 = (ModEoCRealTimeStatisticSubTable2) v2.elementAt(i);
                ve.add(a);
            }
        }

        return ve;// bean1.retrieveAll() && bean2.retrieveAll() ;
    }

    public boolean resetStatistic() throws MibBeanException {

        return bean2.resetStatistic();
    }

}

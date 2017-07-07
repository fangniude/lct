package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 2010-8-9
 * Time: 18:02:25
 * To change this template use File | Settings | File Templates.
 */
public class ModEoCRealTimeStatisticSubTable2 extends ModEoCRealTimeStatisticSubTable {

    public ModEoCRealTimeStatisticSubTable2(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {

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

        prepareRead(super.getProperty(modEoCRealTimeStatisticRxCrc));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxShort));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxShort));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxDropped));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxDropped));
        prepareRead(super.getProperty(modEoCRealTimeStatisticAveragePreFEC));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {

        prepareRead(super.getProperty(modEoCRealTimeStatisticRxCrc));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxShort));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxShort));
        prepareRead(super.getProperty(modEoCRealTimeStatisticTxDropped));
        prepareRead(super.getProperty(modEoCRealTimeStatisticRxDropped));
        prepareRead(super.getProperty(modEoCRealTimeStatisticAveragePreFEC));


        return loadAll(new int[]{1, 1
        });
    }

    public boolean resetStatistic() throws MibBeanException {
        setModEoCRealTimeStatisticReset(1);
        prepareSave(getProperty(modEoCRealTimeStatisticReset));

        return save();
    }
}

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

public class SlaTable extends SnmpMibBean {

    public static final String slaIndex = "slaIndex";
    public static final String slaDsFixedBW = "slaDsFixedBW";
    public static final String slaDsPeakBW = "slaDsPeakBW";
    public static final String slaDsCommittedBW = "slaDsCommittedBW";
    public static final String slaUsFixedBW = "slaUsFixedBW";
    public static final String slaUsPeakBW = "slaUsPeakBW";
    public static final String slaUsCommittedBW = "slaUsCommittedBW";

    public SlaTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(slaIndex, new SnmpMibBeanProperty(slaIndex, ".1.3.6.1.4.1.17409.2.3.4.4.1.1", ISnmpConstant.INTEGER));
        initProperty(slaDsFixedBW, new SnmpMibBeanProperty(slaDsFixedBW, ".1.3.6.1.4.1.17409.2.3.4.4.1.2", ISnmpConstant.INTEGER));
        initProperty(slaDsPeakBW, new SnmpMibBeanProperty(slaDsPeakBW, ".1.3.6.1.4.1.17409.2.3.4.4.1.3", ISnmpConstant.INTEGER));
        initProperty(slaDsCommittedBW, new SnmpMibBeanProperty(slaDsCommittedBW, ".1.3.6.1.4.1.17409.2.3.4.4.1.4", ISnmpConstant.INTEGER));
        initProperty(slaUsFixedBW, new SnmpMibBeanProperty(slaUsFixedBW, ".1.3.6.1.4.1.17409.2.3.4.4.1.5", ISnmpConstant.INTEGER));
        initProperty(slaUsPeakBW, new SnmpMibBeanProperty(slaUsPeakBW, ".1.3.6.1.4.1.17409.2.3.4.4.1.6", ISnmpConstant.INTEGER));
        initProperty(slaUsCommittedBW, new SnmpMibBeanProperty(slaUsCommittedBW, ".1.3.6.1.4.1.17409.2.3.4.4.1.7", ISnmpConstant.INTEGER));
    }

    public Integer getSlaIndex() {
        return (Integer) getIndex(0);
    }

    public void setSlaIndex(Integer aSlaIndex) {
        setIndex(0, aSlaIndex);
    }

    public Integer getSlaDsFixedBW() {
        return (Integer) getProperty(slaDsFixedBW).getValue();
    }

    public void setSlaDsFixedBW(Integer aSlaDsFixedBW) {
        getProperty(slaDsFixedBW).setValue(aSlaDsFixedBW);
    }

    public Integer getSlaDsPeakBW() {
        return (Integer) getProperty(slaDsPeakBW).getValue();
    }

    public void setSlaDsPeakBW(Integer aSlaDsPeakBW) {
        getProperty(slaDsPeakBW).setValue(aSlaDsPeakBW);
    }

    public Integer getSlaDsCommittedBW() {
        return (Integer) getProperty(slaDsCommittedBW).getValue();
    }

    public void setSlaDsCommittedBW(Integer aSlaDsCommittedBW) {
        getProperty(slaDsCommittedBW).setValue(aSlaDsCommittedBW);
    }

    public Integer getSlaUsFixedBW() {
        return (Integer) getProperty(slaUsFixedBW).getValue();
    }

    public void setSlaUsFixedBW(Integer aSlaUsFixedBW) {
        getProperty(slaUsFixedBW).setValue(aSlaUsFixedBW);
    }

    public Integer getSlaUsPeakBW() {
        return (Integer) getProperty(slaUsPeakBW).getValue();
    }

    public void setSlaUsPeakBW(Integer aSlaUsPeakBW) {
        getProperty(slaUsPeakBW).setValue(aSlaUsPeakBW);
    }

    public Integer getSlaUsCommittedBW() {
        return (Integer) getProperty(slaUsCommittedBW).getValue();
    }

    public void setSlaUsCommittedBW(Integer aSlaUsCommittedBW) {
        getProperty(slaUsCommittedBW).setValue(aSlaUsCommittedBW);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(slaDsFixedBW));
        prepareRead(super.getProperty(slaDsPeakBW));
        prepareRead(super.getProperty(slaDsCommittedBW));
        prepareRead(super.getProperty(slaUsFixedBW));
        prepareRead(super.getProperty(slaUsPeakBW));
        prepareRead(super.getProperty(slaUsCommittedBW));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(slaDsFixedBW));
        prepareRead(super.getProperty(slaDsPeakBW));
        prepareRead(super.getProperty(slaDsCommittedBW));
        prepareRead(super.getProperty(slaUsFixedBW));
        prepareRead(super.getProperty(slaUsPeakBW));
        prepareRead(super.getProperty(slaUsCommittedBW));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(slaDsFixedBW));
        prepareSave(getProperty(slaDsPeakBW));
        prepareSave(getProperty(slaDsCommittedBW));
        prepareSave(getProperty(slaUsFixedBW));
        prepareSave(getProperty(slaUsPeakBW));
        prepareSave(getProperty(slaUsCommittedBW));

        return save();
    }

}
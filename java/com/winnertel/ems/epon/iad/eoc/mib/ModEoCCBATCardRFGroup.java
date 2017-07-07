package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCCBATCardRFGroup class.
 * Created by QuickDVM
 */
public class ModEoCCBATCardRFGroup extends EocBaseSnmpMibBean {
    public static final String modEoCCBATCardRFIndex = "modEoCCBATCardRFIndex";
    public static final String modEoCCBATCardRFLinkMaximum = "modEoCCBATCardRFLinkMaximum";
    public static final String modEoCCBATCardRFOutputLevel = "modEoCCBATCardRFOutputLevel";
    public static final String modEoCCBATCardRFDownstreamStartFreq = "modEoCCBATCardRFDownstreamStartFreq";
    public static final String modEoCCBATCardRFDownstreamStopFreq = "modEoCCBATCardRFDownstreamStopFreq";
    public static final String modEoCCBATCardRFUpstreamStartFreq = "modEoCCBATCardRFUpstreamStartFreq";
    public static final String modEoCCBATCardRFUpstreamStopFreq = "modEoCCBATCardRFUpstreamStopFreq";
    public static final String modEoCCBATCardRFDownstreamStartFreqDisplay = "modEoCCBATCardRFDownstreamStartFreqDisplay";
    public static final String modEoCCBATCardRFDownstreamStopFreqDisplay = "modEoCCBATCardRFDownstreamStopFreqDisplay";
    public static final String modEoCCBATCardRFUpstreamStartFreqDisplay = "modEoCCBATCardRFUpstreamStartFreqDisplay";
    public static final String modEoCCBATCardRFUpstreamStopFreqDisplay = "modEoCCBATCardRFUpstreamStopFreqDisplay";

    public ModEoCCBATCardRFGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCBATCardRFIndex, new SnmpMibBeanProperty(modEoCCBATCardRFIndex, MIB_Head1 + ".2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardRFLinkMaximum, new SnmpMibBeanProperty(modEoCCBATCardRFLinkMaximum, MIB_Head1 + ".2.1.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardRFOutputLevel, new SnmpMibBeanProperty(modEoCCBATCardRFOutputLevel, MIB_Head1 + ".2.1.1.3", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardRFDownstreamStartFreq, new SnmpMibBeanProperty(modEoCCBATCardRFDownstreamStartFreq, MIB_Head1 + ".2.1.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardRFDownstreamStopFreq, new SnmpMibBeanProperty(modEoCCBATCardRFDownstreamStopFreq, MIB_Head1 + ".2.1.1.5", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardRFUpstreamStartFreq, new SnmpMibBeanProperty(modEoCCBATCardRFUpstreamStartFreq, MIB_Head1 + ".2.1.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardRFUpstreamStopFreq, new SnmpMibBeanProperty(modEoCCBATCardRFUpstreamStopFreq, MIB_Head1 + ".2.1.1.7", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCBATCardRFIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCCBATCardRFIndex(Integer aModEoCCBATCardRFIndex) {
        setIndex(0, aModEoCCBATCardRFIndex);
    }


    public Integer getModEoCCBATCardRFLinkMaximum() {
        return (Integer) getProperty(modEoCCBATCardRFLinkMaximum).getValue();
    }

    public void setModEoCCBATCardRFLinkMaximum(Integer aModEoCCBATCardRFLinkMaximum) {
        getProperty(modEoCCBATCardRFLinkMaximum).setValue(aModEoCCBATCardRFLinkMaximum);
    }

    public Integer getModEoCCBATCardRFOutputLevel() {
        return (Integer) getProperty(modEoCCBATCardRFOutputLevel).getValue();
    }

    public void setModEoCCBATCardRFOutputLevel(Integer aModEoCCBATCardRFOutputLevel) {
        getProperty(modEoCCBATCardRFOutputLevel).setValue(aModEoCCBATCardRFOutputLevel);
    }

    public Integer getModEoCCBATCardRFDownstreamStartFreq() {
        return (Integer) getProperty(modEoCCBATCardRFDownstreamStartFreq).getValue();
    }

    public void setModEoCCBATCardRFDownstreamStartFreq(Integer aModEoCCBATCardRFDownstreamStartFreq) {
        getProperty(modEoCCBATCardRFDownstreamStartFreq).setValue(aModEoCCBATCardRFDownstreamStartFreq);
    }

    public Integer getModEoCCBATCardRFDownstreamStopFreq() {
        return (Integer) getProperty(modEoCCBATCardRFDownstreamStopFreq).getValue();
    }

    public void setModEoCCBATCardRFDownstreamStopFreq(Integer aModEoCCBATCardRFDownstreamStopFreq) {
        getProperty(modEoCCBATCardRFDownstreamStopFreq).setValue(aModEoCCBATCardRFDownstreamStopFreq);
    }

    public Integer getModEoCCBATCardRFUpstreamStartFreq() {
        return (Integer) getProperty(modEoCCBATCardRFUpstreamStartFreq).getValue();
    }

    public void setModEoCCBATCardRFUpstreamStartFreq(Integer aModEoCCBATCardRFUpstreamStartFreq) {
        getProperty(modEoCCBATCardRFUpstreamStartFreq).setValue(aModEoCCBATCardRFUpstreamStartFreq);
    }

    public Integer getModEoCCBATCardRFUpstreamStopFreq() {
        return (Integer) getProperty(modEoCCBATCardRFUpstreamStopFreq).getValue();
    }

    public void setModEoCCBATCardRFUpstreamStopFreq(Integer aModEoCCBATCardRFUpstreamStopFreq) {
        getProperty(modEoCCBATCardRFUpstreamStopFreq).setValue(aModEoCCBATCardRFUpstreamStopFreq);
    }

    public Double getModEoCCBATCardRFDownstreamStartFreqDisplay() {
        return Double.valueOf(getProperty(modEoCCBATCardRFDownstreamStartFreq).getValue().toString()) / 1000000;
    }

    public void setModEoCCBATCardRFDownstreamStartFreqDisplay(Double aModEoCCBATCardRFDownstreamStartFreq) {
        getProperty(modEoCCBATCardRFDownstreamStartFreq).setValue((int) (aModEoCCBATCardRFDownstreamStartFreq.doubleValue() * 1000000));
    }

    public Double getModEoCCBATCardRFDownstreamStopFreqDisplay() {
        return Double.valueOf(getProperty(modEoCCBATCardRFDownstreamStopFreq).getValue().toString()) / 1000000;
    }

    public void setModEoCCBATCardRFDownstreamStopFreqDisplay(Double aModEoCCBATCardRFDownstreamStopFreq) {
        getProperty(modEoCCBATCardRFDownstreamStopFreq).setValue((int) (aModEoCCBATCardRFDownstreamStopFreq.doubleValue() * 1000000));
    }

    public Double getModEoCCBATCardRFUpstreamStartFreqDisplay() {
        return Double.valueOf(getProperty(modEoCCBATCardRFUpstreamStartFreq).getValue().toString()) / 1000000;
    }

    public void setModEoCCBATCardRFUpstreamStartFreqDisplay(Double aModEoCCBATCardRFUpstreamStartFreq) {
        getProperty(modEoCCBATCardRFUpstreamStartFreq).setValue((int) (aModEoCCBATCardRFUpstreamStartFreq.doubleValue() * 1000000));
    }

    public Double getModEoCCBATCardRFUpstreamStopFreqDisplay() {
        return Double.valueOf(getProperty(modEoCCBATCardRFUpstreamStopFreq).getValue().toString()) / 1000000;
    }

    public void setModEoCCBATCardRFUpstreamStopFreqDisplay(Double aModEoCCBATCardRFUpstreamStopFreq) {
        getProperty(modEoCCBATCardRFUpstreamStopFreq).setValue((int) (aModEoCCBATCardRFUpstreamStopFreq.doubleValue() * 1000000));
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATCardRFLinkMaximum));
        prepareRead(super.getProperty(modEoCCBATCardRFOutputLevel));
        prepareRead(super.getProperty(modEoCCBATCardRFDownstreamStartFreq));
        prepareRead(super.getProperty(modEoCCBATCardRFDownstreamStopFreq));
        prepareRead(super.getProperty(modEoCCBATCardRFUpstreamStartFreq));
        prepareRead(super.getProperty(modEoCCBATCardRFUpstreamStopFreq));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATCardRFLinkMaximum));
        prepareRead(super.getProperty(modEoCCBATCardRFOutputLevel));
        prepareRead(super.getProperty(modEoCCBATCardRFDownstreamStartFreq));
        prepareRead(super.getProperty(modEoCCBATCardRFDownstreamStopFreq));
        prepareRead(super.getProperty(modEoCCBATCardRFUpstreamStartFreq));
        prepareRead(super.getProperty(modEoCCBATCardRFUpstreamStopFreq));

        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCBATCardRFOutputLevel));
        prepareSave(getProperty(modEoCCBATCardRFDownstreamStartFreq));
        prepareSave(getProperty(modEoCCBATCardRFDownstreamStopFreq));
        prepareSave(getProperty(modEoCCBATCardRFUpstreamStartFreq));
        prepareSave(getProperty(modEoCCBATCardRFUpstreamStopFreq));

        return save();
    }


}

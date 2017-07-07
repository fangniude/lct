package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCCNUServiceTable class.
 * Created by QuickDVM
 */
public class ModEoCCNUServiceTable extends EocBaseSnmpMibBean {
    public static final String modEoCCNUServiceIndex = "modEoCCNUServiceIndex";
    public static final String modEoCCNUServiceName = "modEoCCNUServiceName";
    public static final String modEoCCNUServiceMatchingValue = "modEoCCNUServiceMatchingValue";
    public static final String modEoCCNUServiceQOSPrio = "modEoCCNUServiceQOSPrio";
    public static final String modEoCCNUServiceDBADownstreamPIR = "modEoCCNUServiceDBADownstreamPIR";
    public static final String modEoCCNUServiceDBAUpstreamPIR = "modEoCCNUServiceDBAUpstreamPIR";
    public static final String modEoCCNUServiceDBADownstreamCIR = "modEoCCNUServiceDBADownstreamCIR";
    public static final String modEoCCNUServiceDBAUpstreamCIR = "modEoCCNUServiceDBAUpstreamCIR";
    public static final String modEoCCNUServiceMaxLatency = "modEoCCNUServiceMaxLatency";


    public ModEoCCNUServiceTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCNUServiceIndex, new SnmpMibBeanProperty(modEoCCNUServiceIndex, MIB_Head1 + ".5.3.3.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUServiceName, new SnmpMibBeanProperty(modEoCCNUServiceName, MIB_Head1 + ".5.3.3.1.2", ISnmpConstant.STRING));
        initProperty(modEoCCNUServiceMatchingValue, new SnmpMibBeanProperty(modEoCCNUServiceMatchingValue, MIB_Head1 + ".5.3.3.1.3", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUServiceQOSPrio, new SnmpMibBeanProperty(modEoCCNUServiceQOSPrio, MIB_Head1 + ".5.3.3.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUServiceDBADownstreamPIR, new SnmpMibBeanProperty(modEoCCNUServiceDBADownstreamPIR, MIB_Head1 + ".5.3.3.1.5", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUServiceDBAUpstreamPIR, new SnmpMibBeanProperty(modEoCCNUServiceDBAUpstreamPIR, MIB_Head1 + ".5.3.3.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUServiceDBADownstreamCIR, new SnmpMibBeanProperty(modEoCCNUServiceDBADownstreamCIR, MIB_Head1 + ".5.3.3.1.7", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUServiceDBAUpstreamCIR, new SnmpMibBeanProperty(modEoCCNUServiceDBAUpstreamCIR, MIB_Head1 + ".5.3.3.1.8", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUServiceMaxLatency, new SnmpMibBeanProperty(modEoCCNUServiceMaxLatency, MIB_Head1 + ".5.3.3.1.9", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, MIB_Head1 + ".5.3.3.1.10", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCNUServiceIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCCNUServiceIndex(Integer aModEoCCNUServiceIndex) {
        setIndex(0, aModEoCCNUServiceIndex);
    }


    public String getModEoCCNUServiceName() {
        return (String) getProperty(modEoCCNUServiceName).getValue();
    }

    public void setModEoCCNUServiceName(String aModEoCCNUServiceName) {
        getProperty(modEoCCNUServiceName).setValue(aModEoCCNUServiceName);
    }

    public Integer getModEoCCNUServiceMatchingValue() {
        return (Integer) getProperty(modEoCCNUServiceMatchingValue).getValue();
    }

    public void setModEoCCNUServiceMatchingValue(Integer aModEoCCNUServiceMatchingValue) {
        getProperty(modEoCCNUServiceMatchingValue).setValue(aModEoCCNUServiceMatchingValue);
    }

    public Integer getModEoCCNUServiceQOSPrio() {
        return (Integer) getProperty(modEoCCNUServiceQOSPrio).getValue();
    }

    public void setModEoCCNUServiceQOSPrio(Integer aModEoCCNUServiceQOSPrio) {
        getProperty(modEoCCNUServiceQOSPrio).setValue(aModEoCCNUServiceQOSPrio);
    }

    public Integer getModEoCCNUServiceDBADownstreamPIR() {
        return (Integer) getProperty(modEoCCNUServiceDBADownstreamPIR).getValue();
    }

    public void setModEoCCNUServiceDBADownstreamPIR(Integer aModEoCCNUServiceDBADownstreamPIR) {
        getProperty(modEoCCNUServiceDBADownstreamPIR).setValue(aModEoCCNUServiceDBADownstreamPIR);
    }

    public Integer getModEoCCNUServiceDBAUpstreamPIR() {
        return (Integer) getProperty(modEoCCNUServiceDBAUpstreamPIR).getValue();
    }

    public void setModEoCCNUServiceDBAUpstreamPIR(Integer aModEoCCNUServiceDBAUpstreamPIR) {
        getProperty(modEoCCNUServiceDBAUpstreamPIR).setValue(aModEoCCNUServiceDBAUpstreamPIR);
    }

    public Integer getModEoCCNUServiceDBADownstreamCIR() {
        return (Integer) getProperty(modEoCCNUServiceDBADownstreamCIR).getValue();
    }

    public void setModEoCCNUServiceDBADownstreamCIR(Integer aModEoCCNUServiceDBADownstreamCIR) {
        getProperty(modEoCCNUServiceDBADownstreamCIR).setValue(aModEoCCNUServiceDBADownstreamCIR);
    }

    public Integer getModEoCCNUServiceDBAUpstreamCIR() {
        return (Integer) getProperty(modEoCCNUServiceDBAUpstreamCIR).getValue();
    }

    public void setModEoCCNUServiceDBAUpstreamCIR(Integer aModEoCCNUServiceDBAUpstreamCIR) {
        getProperty(modEoCCNUServiceDBAUpstreamCIR).setValue(aModEoCCNUServiceDBAUpstreamCIR);
    }

    public Integer getModEoCCNUServiceMaxLatency() {
        return (Integer) getProperty(modEoCCNUServiceMaxLatency).getValue();
    }

    public void setModEoCCNUServiceMaxLatency(Integer aModEoCCNUServiceMaxLatency) {
        getProperty(modEoCCNUServiceMaxLatency).setValue(aModEoCCNUServiceMaxLatency);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUServiceName));
        prepareRead(super.getProperty(modEoCCNUServiceMatchingValue));
        prepareRead(super.getProperty(modEoCCNUServiceQOSPrio));
        prepareRead(super.getProperty(modEoCCNUServiceDBADownstreamPIR));
        prepareRead(super.getProperty(modEoCCNUServiceDBAUpstreamPIR));
        prepareRead(super.getProperty(modEoCCNUServiceDBADownstreamCIR));
        prepareRead(super.getProperty(modEoCCNUServiceDBAUpstreamCIR));
        prepareRead(super.getProperty(modEoCCNUServiceMaxLatency));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUServiceName));
        prepareRead(super.getProperty(modEoCCNUServiceMatchingValue));
        prepareRead(super.getProperty(modEoCCNUServiceQOSPrio));
        prepareRead(super.getProperty(modEoCCNUServiceDBADownstreamPIR));
        prepareRead(super.getProperty(modEoCCNUServiceDBAUpstreamPIR));
        prepareRead(super.getProperty(modEoCCNUServiceDBADownstreamCIR));
        prepareRead(super.getProperty(modEoCCNUServiceDBAUpstreamCIR));
        prepareRead(super.getProperty(modEoCCNUServiceMaxLatency));


        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCNUServiceName));
        prepareSave(getProperty(modEoCCNUServiceMatchingValue));
        prepareSave(getProperty(modEoCCNUServiceQOSPrio));
        prepareSave(getProperty(modEoCCNUServiceDBADownstreamPIR));
        prepareSave(getProperty(modEoCCNUServiceDBAUpstreamPIR));
        prepareSave(getProperty(modEoCCNUServiceDBADownstreamCIR));
        prepareSave(getProperty(modEoCCNUServiceDBAUpstreamCIR));
        prepareSave(getProperty(modEoCCNUServiceMaxLatency));


        return save();
    }


    public boolean add() throws MibBeanException {

        prepareSave(getProperty(modEoCCNUServiceName));
        prepareSave(getProperty(modEoCCNUServiceMatchingValue));
        prepareSave(getProperty(modEoCCNUServiceQOSPrio));
        prepareSave(getProperty(modEoCCNUServiceDBADownstreamPIR));
        prepareSave(getProperty(modEoCCNUServiceDBAUpstreamPIR));
        prepareSave(getProperty(modEoCCNUServiceDBADownstreamCIR));
        prepareSave(getProperty(modEoCCNUServiceDBAUpstreamCIR));
        prepareSave(getProperty(modEoCCNUServiceMaxLatency));

        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }


    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}

package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCCNUPortTable class.
 * Created by QuickDVM
 */
public class ModEoCCNUPortTable extends EocBaseSnmpMibBean {
    public static final String modEoCCNUPortCBATCardIndex = "modEoCCNUPortCBATCardIndex";
    public static final String modEoCCNUPortCNUIndex = "modEoCCNUPortCNUIndex";
    public static final String modEoCCNUPortIndex = "modEoCCNUPortIndex";
    public static final String modEoCCNUPortEN = "modEoCCNUPortEN";
    public static final String modEoCCNUPortService = "modEoCCNUPortService";

    public ModEoCCNUPortTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCNUPortCBATCardIndex, new SnmpMibBeanProperty(modEoCCNUPortCBATCardIndex, MIB_Head1 + ".5.4.3.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUPortCNUIndex, new SnmpMibBeanProperty(modEoCCNUPortCNUIndex, MIB_Head1 + ".5.4.3.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUPortIndex, new SnmpMibBeanProperty(modEoCCNUPortIndex, MIB_Head1 + ".5.4.3.1.3", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUPortEN, new SnmpMibBeanProperty(modEoCCNUPortEN, MIB_Head1 + ".5.4.3.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUPortService, new SnmpMibBeanProperty(modEoCCNUPortService, MIB_Head1 + ".5.4.3.1.5", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCNUPortCBATCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCCNUPortCBATCardIndex(Integer aModEoCCNUPortCBATCardIndex) {
        setIndex(0, aModEoCCNUPortCBATCardIndex);
    }


    public Integer getModEoCCNUPortCNUIndex() {
        return (Integer) getIndex(1);
    }

    public void setModEoCCNUPortCNUIndex(Integer aModEoCCNUPortCNUIndex) {
        setIndex(1, aModEoCCNUPortCNUIndex);
    }


    public Integer getModEoCCNUPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setModEoCCNUPortIndex(Integer aModEoCCNUPortIndex) {
        setIndex(2, aModEoCCNUPortIndex);
    }


    public Integer getModEoCCNUPortEN() {
        return (Integer) getProperty(modEoCCNUPortEN).getValue();
    }

    public void setModEoCCNUPortEN(Integer aModEoCCNUPortEN) {
        getProperty(modEoCCNUPortEN).setValue(aModEoCCNUPortEN);
    }

    public Integer getModEoCCNUPortService() {
        return (Integer) getProperty(modEoCCNUPortService).getValue();
    }

    public void setModEoCCNUPortService(Integer aModEoCCNUPortService) {
        getProperty(modEoCCNUPortService).setValue(aModEoCCNUPortService);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUPortEN));
        prepareRead(super.getProperty(modEoCCNUPortService));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUPortEN));
        prepareRead(super.getProperty(modEoCCNUPortService));

        return loadAll(new int[]{1
                , 1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCNUPortEN));
        prepareSave(getProperty(modEoCCNUPortService));

        return save();
    }

    public String toString() {
        return "CBATCardIndex=" + getModEoCCNUPortCBATCardIndex() +
                ",CNUIndex=" + getModEoCCNUPortCNUIndex() +
                ",CNUPortIndex=" + getModEoCCNUPortIndex();
    }
}
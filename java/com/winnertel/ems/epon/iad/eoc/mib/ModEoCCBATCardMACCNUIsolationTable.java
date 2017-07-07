package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCCBATCardMACCNUIsolationTable class.
 * Created by QuickDVM
 */
public class ModEoCCBATCardMACCNUIsolationTable extends EocBaseSnmpMibBean {
    public static final String modEoCCBATCardMACCNUIsolationIndex = "modEoCCBATCardMACCNUIsolationIndex";
    public static final String modEoCCBATCardMACCNUIsolationEN = "modEoCCBATCardMACCNUIsolationEN";

    public ModEoCCBATCardMACCNUIsolationTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCBATCardMACCNUIsolationIndex, new SnmpMibBeanProperty(modEoCCBATCardMACCNUIsolationIndex, MIB_Head1 + ".3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardMACCNUIsolationEN, new SnmpMibBeanProperty(modEoCCBATCardMACCNUIsolationEN, MIB_Head1 + ".3.1.1.2", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCBATCardMACCNUIsolationIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCCBATCardMACCNUIsolationIndex(Integer aModEoCCBATCardMACCNUIsolationIndex) {
        setIndex(0, aModEoCCBATCardMACCNUIsolationIndex);
    }


    public Integer getModEoCCBATCardMACCNUIsolationEN() {
        return (Integer) getProperty(modEoCCBATCardMACCNUIsolationEN).getValue();
    }

    public void setModEoCCBATCardMACCNUIsolationEN(Integer aModEoCCBATCardMACCNUIsolationEN) {
        getProperty(modEoCCBATCardMACCNUIsolationEN).setValue(aModEoCCBATCardMACCNUIsolationEN);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATCardMACCNUIsolationEN));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATCardMACCNUIsolationEN));

        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCBATCardMACCNUIsolationEN));

        return save();
    }


}

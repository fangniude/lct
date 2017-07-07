package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCBroadcastStormProtectionTable class.
 * Created by QuickDVM
 */
public class ModEoCBroadcastStormProtectionTable extends EocBaseSnmpMibBean {
    public static final String modEoCBroadcastStormProtectionCBATCardIndex = "modEoCBroadcastStormProtectionCBATCardIndex";
    public static final String modEoCBroadcastStormProtectionCNUIndex = "modEoCBroadcastStormProtectionCNUIndex";
    public static final String modEoCBroadcastStormProtectionPortIndex = "modEoCBroadcastStormProtectionPortIndex";
    public static final String modEoCBroadcastStormProtectionEN = "modEoCBroadcastStormProtectionEN";
    public static final String modEoCBroadcastStormThreshold = "modEoCBroadcastStormThreshold";
    public static final String modEoCMulticastStormProtectionEN = "modEoCMulticastStormProtectionEN";
    public static final String modEoCMulticastStormThreshold = "modEoCMulticastStormThreshold";
    public static final String modEoCUnknownUnicastStormProtectionEN = "modEoCUnknownUnicastStormProtectionEN";
    public static final String modEoCUnknownUnicastStormThreshold = "modEoCUnknownUnicastStormThreshold";

    public ModEoCBroadcastStormProtectionTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCBroadcastStormProtectionCBATCardIndex, new SnmpMibBeanProperty(modEoCBroadcastStormProtectionCBATCardIndex, MIB_Head1 + ".11.1.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCBroadcastStormProtectionCNUIndex, new SnmpMibBeanProperty(modEoCBroadcastStormProtectionCNUIndex, MIB_Head1 + ".11.1.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCBroadcastStormProtectionPortIndex, new SnmpMibBeanProperty(modEoCBroadcastStormProtectionPortIndex, MIB_Head1 + ".11.1.1.3", ISnmpConstant.INTEGER));
        initProperty(modEoCBroadcastStormProtectionEN, new SnmpMibBeanProperty(modEoCBroadcastStormProtectionEN, MIB_Head1 + ".11.1.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCBroadcastStormThreshold, new SnmpMibBeanProperty(modEoCBroadcastStormThreshold, MIB_Head1 + ".11.1.1.5", ISnmpConstant.INTEGER));
        initProperty(modEoCMulticastStormProtectionEN, new SnmpMibBeanProperty(modEoCMulticastStormProtectionEN, MIB_Head1 + ".11.1.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCMulticastStormThreshold, new SnmpMibBeanProperty(modEoCMulticastStormThreshold, MIB_Head1 + ".11.1.1.7", ISnmpConstant.INTEGER));
        initProperty(modEoCUnknownUnicastStormProtectionEN, new SnmpMibBeanProperty(modEoCUnknownUnicastStormProtectionEN, MIB_Head1 + ".11.1.1.8", ISnmpConstant.INTEGER));
        initProperty(modEoCUnknownUnicastStormThreshold, new SnmpMibBeanProperty(modEoCUnknownUnicastStormThreshold, MIB_Head1 + ".11.1.1.9", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCBroadcastStormProtectionCBATCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCBroadcastStormProtectionCBATCardIndex(Integer aModEoCBroadcastStormProtectionCBATCardIndex) {
        setIndex(0, aModEoCBroadcastStormProtectionCBATCardIndex);
    }


    public Integer getModEoCBroadcastStormProtectionCNUIndex() {
        return (Integer) getIndex(1);
    }

    public void setModEoCBroadcastStormProtectionCNUIndex(Integer aModEoCBroadcastStormProtectionCNUIndex) {
        setIndex(1, aModEoCBroadcastStormProtectionCNUIndex);
    }


    public Integer getModEoCBroadcastStormProtectionPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setModEoCBroadcastStormProtectionPortIndex(Integer aModEoCBroadcastStormProtectionPortIndex) {
        setIndex(2, aModEoCBroadcastStormProtectionPortIndex);
    }


    public Integer getModEoCBroadcastStormProtectionEN() {
        return (Integer) getProperty(modEoCBroadcastStormProtectionEN).getValue();
    }

    public void setModEoCBroadcastStormProtectionEN(Integer aModEoCBroadcastStormProtectionEN) {
        getProperty(modEoCBroadcastStormProtectionEN).setValue(aModEoCBroadcastStormProtectionEN);
    }

    public Integer getModEoCBroadcastStormThreshold() {
        return (Integer) getProperty(modEoCBroadcastStormThreshold).getValue();
    }

    public void setModEoCBroadcastStormThreshold(Integer aModEoCBroadcastStormThreshold) {
        getProperty(modEoCBroadcastStormThreshold).setValue(aModEoCBroadcastStormThreshold);
    }

    public Integer getModEoCMulticastStormProtectionEN() {
        return (Integer) getProperty(modEoCMulticastStormProtectionEN).getValue();
    }

    public void setModEoCMulticastStormProtectionEN(Integer aModEoCMulticastStormProtectionEN) {
        getProperty(modEoCMulticastStormProtectionEN).setValue(aModEoCMulticastStormProtectionEN);
    }

    public Integer getModEoCMulticastStormThreshold() {
        return (Integer) getProperty(modEoCMulticastStormThreshold).getValue();
    }

    public void setModEoCMulticastStormThreshold(Integer aModEoCMulticastStormThreshold) {
        getProperty(modEoCMulticastStormThreshold).setValue(aModEoCMulticastStormThreshold);
    }

    public Integer getModEoCUnknownUnicastStormProtectionEN() {
        return (Integer) getProperty(modEoCUnknownUnicastStormProtectionEN).getValue();
    }

    public void setModEoCUnknownUnicastStormProtectionEN(Integer aModEoCUnknownUnicastStormProtectionEN) {
        getProperty(modEoCUnknownUnicastStormProtectionEN).setValue(aModEoCUnknownUnicastStormProtectionEN);
    }

    public Integer getModEoCUnknownUnicastStormThreshold() {
        return (Integer) getProperty(modEoCUnknownUnicastStormThreshold).getValue();
    }

    public void setModEoCUnknownUnicastStormThreshold(Integer aModEoCUnknownUnicastStormThreshold) {
        getProperty(modEoCUnknownUnicastStormThreshold).setValue(aModEoCUnknownUnicastStormThreshold);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCBroadcastStormProtectionEN));
        prepareRead(super.getProperty(modEoCBroadcastStormThreshold));
        prepareRead(super.getProperty(modEoCMulticastStormProtectionEN));
        prepareRead(super.getProperty(modEoCMulticastStormThreshold));
        prepareRead(super.getProperty(modEoCUnknownUnicastStormProtectionEN));
        prepareRead(super.getProperty(modEoCUnknownUnicastStormThreshold));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCBroadcastStormProtectionEN));
        prepareRead(super.getProperty(modEoCBroadcastStormThreshold));
        prepareRead(super.getProperty(modEoCMulticastStormProtectionEN));
        prepareRead(super.getProperty(modEoCMulticastStormThreshold));
        prepareRead(super.getProperty(modEoCUnknownUnicastStormProtectionEN));
        prepareRead(super.getProperty(modEoCUnknownUnicastStormThreshold));

        return loadAll(new int[]{1
                , 1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCBroadcastStormProtectionEN));
        prepareSave(getProperty(modEoCBroadcastStormThreshold));
        prepareSave(getProperty(modEoCMulticastStormProtectionEN));
        prepareSave(getProperty(modEoCMulticastStormThreshold));
        prepareSave(getProperty(modEoCUnknownUnicastStormProtectionEN));
        prepareSave(getProperty(modEoCUnknownUnicastStormThreshold));

        return save();
    }


}

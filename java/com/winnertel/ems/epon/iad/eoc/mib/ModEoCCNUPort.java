package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCNUPort class.
 * Created by QuickDVM
 */
public class ModEoCCNUPort extends EocBaseSnmpMibBean {
    public static final String modEoCCNUPortPerCNULimitation = "modEoCCNUPortPerCNULimitation";
    public static final String modEoCCNUPortAmountLimitation = "modEoCCNUPortAmountLimitation";

    public ModEoCCNUPort(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCNUPortPerCNULimitation, new SnmpMibBeanProperty(modEoCCNUPortPerCNULimitation, MIB_Head1 + ".5.4.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUPortAmountLimitation, new SnmpMibBeanProperty(modEoCCNUPortAmountLimitation, MIB_Head1 + ".5.4.2", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCNUPortPerCNULimitation() {
        return (Integer) getProperty(modEoCCNUPortPerCNULimitation).getValue();
    }

    public void setModEoCCNUPortPerCNULimitation(Integer aModEoCCNUPortPerCNULimitation) {
        getProperty(modEoCCNUPortPerCNULimitation).setValue(aModEoCCNUPortPerCNULimitation);
    }

    public Integer getModEoCCNUPortAmountLimitation() {
        return (Integer) getProperty(modEoCCNUPortAmountLimitation).getValue();
    }

    public void setModEoCCNUPortAmountLimitation(Integer aModEoCCNUPortAmountLimitation) {
        getProperty(modEoCCNUPortAmountLimitation).setValue(aModEoCCNUPortAmountLimitation);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUPortPerCNULimitation));
        prepareRead(super.getProperty(modEoCCNUPortAmountLimitation));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCNUPortAmountLimitation));

        return save();
    }


}

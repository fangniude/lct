package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCNU class.
 * Created by QuickDVM
 */
public class ModEoCCNU extends EocBaseSnmpMibBean {
    public static final String modEoCCNUAllReset = "modEoCCNUAllReset";
    public static final String modEoCCNUCurrentAmount = "modEoCCNUCurrentAmount";
    public static final String modEoCCNUAmountLimitation = "modEoCCNUAmountLimitation";

    public ModEoCCNU(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCNUAllReset, new SnmpMibBeanProperty(modEoCCNUAllReset, MIB_Head1 + ".5.2.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUCurrentAmount, new SnmpMibBeanProperty(modEoCCNUCurrentAmount, MIB_Head1 + ".5.2.2", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUAmountLimitation, new SnmpMibBeanProperty(modEoCCNUAmountLimitation, MIB_Head1 + ".5.2.3", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCNUAllReset() {
        return (Integer) getProperty(modEoCCNUAllReset).getValue();
    }

    public void setModEoCCNUAllReset(Integer aModEoCCNUAllReset) {
        getProperty(modEoCCNUAllReset).setValue(aModEoCCNUAllReset);
    }

    public Integer getModEoCCNUCurrentAmount() {
        return (Integer) getProperty(modEoCCNUCurrentAmount).getValue();
    }

    public void setModEoCCNUCurrentAmount(Integer aModEoCCNUCurrentAmount) {
        getProperty(modEoCCNUCurrentAmount).setValue(aModEoCCNUCurrentAmount);
    }

    public Integer getModEoCCNUAmountLimitation() {
        return (Integer) getProperty(modEoCCNUAmountLimitation).getValue();
    }

    public void setModEoCCNUAmountLimitation(Integer aModEoCCNUAmountLimitation) {
        getProperty(modEoCCNUAmountLimitation).setValue(aModEoCCNUAmountLimitation);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUAllReset));
        prepareRead(super.getProperty(modEoCCNUCurrentAmount));
        prepareRead(super.getProperty(modEoCCNUAmountLimitation));

        return load();
    }


    public boolean modify() throws MibBeanException {
        //prepareSave(getProperty(modEoCCNUAllReset));
        prepareSave(getProperty(modEoCCNUAmountLimitation));

        return save();
    }

    public boolean reset() throws MibBeanException {

        setModEoCCNUAllReset(new Integer(1));
        prepareSave(getProperty(modEoCCNUAllReset));
        //prepareSave(getProperty(modEoCCNUAmountLimitation));

        return save();
    }


}

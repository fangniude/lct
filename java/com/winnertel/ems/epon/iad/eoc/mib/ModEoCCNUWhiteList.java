package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCNUWhiteList class.
 * Created by QuickDVM
 */
public class ModEoCCNUWhiteList extends EocBaseSnmpMibBean {
    public static final String modEoCCNUWhiteListAmountLimitation = "modEoCCNUWhiteListAmountLimitation";
    public static final String modEoCCNUWhiteListRegisteredAmount = "modEoCCNUWhiteListRegisteredAmount";
    public static final String modEoCCNUWhiteListAllRFOutputLevel = "modEoCCNUWhiteListAllRFOutputLevel";
    public static final String modEoCCNUWhiteListAllExtMACLimitation = "modEoCCNUWhiteListAllExtMACLimitation";
    public static final String modEoCCNUWhiteListPhyRateGate = "modEoCCNUWhiteListPhyRateGate";

    public ModEoCCNUWhiteList(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCNUWhiteListAmountLimitation, new SnmpMibBeanProperty(modEoCCNUWhiteListAmountLimitation, MIB_Head1 + ".5.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUWhiteListRegisteredAmount, new SnmpMibBeanProperty(modEoCCNUWhiteListRegisteredAmount, MIB_Head1 + ".5.1.2", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUWhiteListAllRFOutputLevel, new SnmpMibBeanProperty(modEoCCNUWhiteListAllRFOutputLevel, MIB_Head1 + ".5.1.3", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUWhiteListAllExtMACLimitation, new SnmpMibBeanProperty(modEoCCNUWhiteListAllExtMACLimitation, MIB_Head1 + ".5.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUWhiteListPhyRateGate, new SnmpMibBeanProperty(modEoCCNUWhiteListPhyRateGate, MIB_Head1 + ".5.1.5", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCNUWhiteListAmountLimitation() {
        return (Integer) getProperty(modEoCCNUWhiteListAmountLimitation).getValue();
    }

    public void setModEoCCNUWhiteListAmountLimitation(Integer aModEoCCNUWhiteListAmountLimitation) {
        getProperty(modEoCCNUWhiteListAmountLimitation).setValue(aModEoCCNUWhiteListAmountLimitation);
    }

    public Integer getModEoCCNUWhiteListRegisteredAmount() {
        return (Integer) getProperty(modEoCCNUWhiteListRegisteredAmount).getValue();
    }

    public void setModEoCCNUWhiteListRegisteredAmount(Integer aModEoCCNUWhiteListRegisteredAmount) {
        getProperty(modEoCCNUWhiteListRegisteredAmount).setValue(aModEoCCNUWhiteListRegisteredAmount);
    }

    public Integer getModEoCCNUWhiteListAllRFOutputLevel() {
        return (Integer) getProperty(modEoCCNUWhiteListAllRFOutputLevel).getValue();
    }

    public void setModEoCCNUWhiteListAllRFOutputLevel(Integer aModEoCCNUWhiteListAllRFOutputLevel) {
        getProperty(modEoCCNUWhiteListAllRFOutputLevel).setValue(aModEoCCNUWhiteListAllRFOutputLevel);
    }

    public Integer getModEoCCNUWhiteListAllExtMACLimitation() {
        return (Integer) getProperty(modEoCCNUWhiteListAllExtMACLimitation).getValue();
    }

    public void setModEoCCNUWhiteListAllExtMACLimitation(Integer aModEoCCNUWhiteListAllExtMACLimitation) {
        getProperty(modEoCCNUWhiteListAllExtMACLimitation).setValue(aModEoCCNUWhiteListAllExtMACLimitation);
    }

    public Integer getModEoCCNUWhiteListPhyRateGate() {
        return (Integer) getProperty(modEoCCNUWhiteListPhyRateGate).getValue();
    }

    public void setModEoCCNUWhiteListPhyRateGate(Integer aModEoCCNUWhiteListPhyRateGate) {
        getProperty(modEoCCNUWhiteListPhyRateGate).setValue(aModEoCCNUWhiteListPhyRateGate);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUWhiteListAmountLimitation));
        prepareRead(super.getProperty(modEoCCNUWhiteListRegisteredAmount));
        prepareRead(super.getProperty(modEoCCNUWhiteListAllRFOutputLevel));
        prepareRead(super.getProperty(modEoCCNUWhiteListAllExtMACLimitation));
        prepareRead(super.getProperty(modEoCCNUWhiteListPhyRateGate));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCNUWhiteListAmountLimitation));
        prepareSave(getProperty(modEoCCNUWhiteListAllRFOutputLevel));
        prepareSave(getProperty(modEoCCNUWhiteListAllExtMACLimitation));

        return save();
    }


}
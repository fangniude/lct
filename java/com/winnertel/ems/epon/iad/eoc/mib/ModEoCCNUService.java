package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCNUService class.
 * Created by QuickDVM
 */
public class ModEoCCNUService extends EocBaseSnmpMibBean {
    public static final String modEoCCNUServiceType = "modEoCCNUServiceType";
    public static final String modEoCCNUServiceAmountLimitation = "modEoCCNUServiceAmountLimitation";

    public ModEoCCNUService(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCNUServiceType, new SnmpMibBeanProperty(modEoCCNUServiceType, MIB_Head1 + ".5.3.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUServiceAmountLimitation, new SnmpMibBeanProperty(modEoCCNUServiceAmountLimitation, MIB_Head1 + ".5.3.2", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCNUServiceType() {
        return (Integer) getProperty(modEoCCNUServiceType).getValue();
    }

    public void setModEoCCNUServiceType(Integer aModEoCCNUServiceType) {
        getProperty(modEoCCNUServiceType).setValue(aModEoCCNUServiceType);
    }

    public Integer getModEoCCNUServiceAmountLimitation() {
        return (Integer) getProperty(modEoCCNUServiceAmountLimitation).getValue();
    }

    public void setModEoCCNUServiceAmountLimitation(Integer aModEoCCNUServiceAmountLimitation) {
        getProperty(modEoCCNUServiceAmountLimitation).setValue(aModEoCCNUServiceAmountLimitation);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCNUServiceType));
        prepareRead(super.getProperty(modEoCCNUServiceAmountLimitation));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCNUServiceType));
        prepareSave(getProperty(modEoCCNUServiceAmountLimitation));

        return save();
    }


}

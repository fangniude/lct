package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCBATOtherAdminGroup class.
 * Created by QuickDVM
 */
public class ModEoCCBATOtherAdminGroup extends EocBaseSnmpMibBean {
    public static final String modEoCCBATAdminLinkTopoChange = "modEoCCBATAdminLinkTopoChange";
    public static final String modEoCCBATAdminAppropriativeOID = "modEoCCBATAdminAppropriativeOID";
    public static final String modEoCCBATCardUpLinkBroadcastFrameSendManner = "modEoCCBATCardUpLinkBroadcastFrameSendManner";

    public ModEoCCBATOtherAdminGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCBATAdminLinkTopoChange, new SnmpMibBeanProperty(modEoCCBATAdminLinkTopoChange, MIB_Head1 + ".1.5.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminAppropriativeOID, new SnmpMibBeanProperty(modEoCCBATAdminAppropriativeOID, MIB_Head1 + ".1.5.2", ISnmpConstant.STRING));
        initProperty(modEoCCBATCardUpLinkBroadcastFrameSendManner, new SnmpMibBeanProperty(modEoCCBATCardUpLinkBroadcastFrameSendManner, MIB_Head1 + ".1.5.3", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCBATAdminLinkTopoChange() {
        return (Integer) getProperty(modEoCCBATAdminLinkTopoChange).getValue();
    }

    public void setModEoCCBATAdminLinkTopoChange(Integer aModEoCCBATAdminLinkTopoChange) {
        getProperty(modEoCCBATAdminLinkTopoChange).setValue(aModEoCCBATAdminLinkTopoChange);
    }

    public String getModEoCCBATAdminAppropriativeOID() {
        return (String) getProperty(modEoCCBATAdminAppropriativeOID).getValue();
    }

    public void setModEoCCBATAdminAppropriativeOID(String aModEoCCBATAdminAppropriativeOID) {
        getProperty(modEoCCBATAdminAppropriativeOID).setValue(aModEoCCBATAdminAppropriativeOID);
    }

    public Integer getModEoCCBATCardUpLinkBroadcastFrameSendManner() {
        return (Integer) getProperty(modEoCCBATCardUpLinkBroadcastFrameSendManner).getValue();
    }

    public void setModEoCCBATCardUpLinkBroadcastFrameSendManner(Integer aModEoCCBATCardUpLinkBroadcastFrameSendManner) {
        getProperty(modEoCCBATCardUpLinkBroadcastFrameSendManner).setValue(aModEoCCBATCardUpLinkBroadcastFrameSendManner);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATAdminLinkTopoChange));
        prepareRead(super.getProperty(modEoCCBATAdminAppropriativeOID));
        prepareRead(super.getProperty(modEoCCBATCardUpLinkBroadcastFrameSendManner));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCBATAdminLinkTopoChange));
        prepareSave(getProperty(modEoCCBATCardUpLinkBroadcastFrameSendManner));

        return save();
    }


}

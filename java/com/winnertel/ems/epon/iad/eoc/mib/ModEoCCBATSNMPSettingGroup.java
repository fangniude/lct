package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCBATSNMPSettingGroup class.
 * Created by QuickDVM
 */
public class ModEoCCBATSNMPSettingGroup extends EocBaseSnmpMibBean {
    public static final String modEoCCBATAdminVarBindings = "modEoCCBATAdminVarBindings";
    public static final String modEoCCBATAdminSNMPVersion = "modEoCCBATAdminSNMPVersion";
    public static final String modEoCCBATAdminSNMPCommunityTableNextIndex = "modEoCCBATAdminSNMPCommunityTableNextIndex";

    public ModEoCCBATSNMPSettingGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCBATAdminVarBindings, new SnmpMibBeanProperty(modEoCCBATAdminVarBindings, MIB_Head1 + ".1.4.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminSNMPVersion, new SnmpMibBeanProperty(modEoCCBATAdminSNMPVersion, MIB_Head1 + ".1.4.2", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminSNMPCommunityTableNextIndex, new SnmpMibBeanProperty(modEoCCBATAdminSNMPCommunityTableNextIndex, MIB_Head1 + ".1.4.3", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCBATAdminVarBindings() {
        return (Integer) getProperty(modEoCCBATAdminVarBindings).getValue();
    }

    public void setModEoCCBATAdminVarBindings(Integer aModEoCCBATAdminVarBindings) {
        getProperty(modEoCCBATAdminVarBindings).setValue(aModEoCCBATAdminVarBindings);
    }

    public Integer getModEoCCBATAdminSNMPVersion() {
        return (Integer) getProperty(modEoCCBATAdminSNMPVersion).getValue();
    }

    public void setModEoCCBATAdminSNMPVersion(Integer aModEoCCBATAdminSNMPVersion) {
        getProperty(modEoCCBATAdminSNMPVersion).setValue(aModEoCCBATAdminSNMPVersion);
    }

    public Integer getModEoCCBATAdminSNMPCommunityTableNextIndex() {
        return (Integer) getProperty(modEoCCBATAdminSNMPCommunityTableNextIndex).getValue();
    }

    public void setModEoCCBATAdminSNMPCommunityTableNextIndex(Integer aModEoCCBATAdminSNMPCommunityTableNextIndex) {
        getProperty(modEoCCBATAdminSNMPCommunityTableNextIndex).setValue(aModEoCCBATAdminSNMPCommunityTableNextIndex);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATAdminVarBindings));
        prepareRead(super.getProperty(modEoCCBATAdminSNMPVersion));
        prepareRead(super.getProperty(modEoCCBATAdminSNMPCommunityTableNextIndex));

        return load();
    }


}

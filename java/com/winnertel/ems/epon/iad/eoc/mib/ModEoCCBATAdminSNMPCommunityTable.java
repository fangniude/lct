package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCCBATAdminSNMPCommunityTable class.
 * Created by QuickDVM
 */
public class ModEoCCBATAdminSNMPCommunityTable extends EocBaseSnmpMibBean {
    public static final String modEoCCBATAdminSNMPCommunityIndex = "modEoCCBATAdminSNMPCommunityIndex";
    public static final String modEoCCBATAdminSNMPCommunity = "modEoCCBATAdminSNMPCommunity";
    public static final String modEoCCBATAdminSNMPCommunityPermission = "modEoCCBATAdminSNMPCommunityPermission";


    public ModEoCCBATAdminSNMPCommunityTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCBATAdminSNMPCommunityIndex, new SnmpMibBeanProperty(modEoCCBATAdminSNMPCommunityIndex, MIB_Head1 + ".1.4.4.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATAdminSNMPCommunity, new SnmpMibBeanProperty(modEoCCBATAdminSNMPCommunity, MIB_Head1 + ".1.4.4.1.2", ISnmpConstant.STRING));
        initProperty(modEoCCBATAdminSNMPCommunityPermission, new SnmpMibBeanProperty(modEoCCBATAdminSNMPCommunityPermission, MIB_Head1 + ".1.4.4.1.3", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, MIB_Head1 + ".1.4.4.1.4", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCBATAdminSNMPCommunityIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCCBATAdminSNMPCommunityIndex(Integer aModEoCCBATAdminSNMPCommunityIndex) {
        setIndex(0, aModEoCCBATAdminSNMPCommunityIndex);
    }


    public String getModEoCCBATAdminSNMPCommunity() {
        return (String) getProperty(modEoCCBATAdminSNMPCommunity).getValue();
    }

    public void setModEoCCBATAdminSNMPCommunity(String aModEoCCBATAdminSNMPCommunity) {
        getProperty(modEoCCBATAdminSNMPCommunity).setValue(aModEoCCBATAdminSNMPCommunity);
    }

    public Integer getModEoCCBATAdminSNMPCommunityPermission() {
        return (Integer) getProperty(modEoCCBATAdminSNMPCommunityPermission).getValue();
    }

    public void setModEoCCBATAdminSNMPCommunityPermission(Integer aModEoCCBATAdminSNMPCommunityPermission) {
        getProperty(modEoCCBATAdminSNMPCommunityPermission).setValue(aModEoCCBATAdminSNMPCommunityPermission);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATAdminSNMPCommunity));
        prepareRead(super.getProperty(modEoCCBATAdminSNMPCommunityPermission));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATAdminSNMPCommunity));
        prepareRead(super.getProperty(modEoCCBATAdminSNMPCommunityPermission));


        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCBATAdminSNMPCommunity));
        prepareSave(getProperty(modEoCCBATAdminSNMPCommunityPermission));

        return save();
    }


    public boolean add() throws MibBeanException {

        prepareSave(getProperty(modEoCCBATAdminSNMPCommunity));
        prepareSave(getProperty(modEoCCBATAdminSNMPCommunityPermission));

        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        boolean isSaveOK = save();
        return isSaveOK;
    }


    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}
package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.protocol.OltSystem;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlOperation;

import java.util.Vector;

public class OltSystemBean extends SnmpMibBean {

    public OltSystemBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        for (OltSystem.Field field : OltSystem.Field.values()) {
            initProperty(field.name(), new SnmpMibBeanProperty(field.name(), TableName.OltSystem.name() + "." + field.name(), ISnmpConstant.STRING));
        }
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, TableName.OltSystem.name() + "." + LctContants.OPERATION, ISnmpConstant.STRING));
    }

    public boolean retrieve() throws MibBeanException {
        for (OltSystem.Field field : OltSystem.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return load();
    }

    public String getProperty(OltSystem.Field field) {
        return String.valueOf(getProperty(field.name()).getValue());
    }

    public void setProperty(OltSystem.Field field, String val) {
        getProperty(field.name()).setValue(val);
    }

    public String getName() {
        return getProperty(OltSystem.Field.name);
    }

    public void setName(String name) {
        setProperty(OltSystem.Field.name, name);
    }

    public String getLocation() {
        return getProperty(OltSystem.Field.location);
    }

    public void setLocation(String location) {
        setProperty(OltSystem.Field.location, location);
    }

    public String getContact() {
        return getProperty(OltSystem.Field.contact);
    }

    public void setContact(String contact) {
        setProperty(OltSystem.Field.contact, contact);
    }

    public String getMgmtVlan() {
        return getProperty(OltSystem.Field.mgmtVlan);
    }

    public void setMgmtVlan(String mgmtVlan) {
        setProperty(OltSystem.Field.mgmtVlan, mgmtVlan);
    }

    public String getMacAgeing() {
        return getProperty(OltSystem.Field.macAgeing);
    }

    public void setMacAgeing(String macAgeing) {
        setProperty(OltSystem.Field.macAgeing, macAgeing);
    }

    public String getMacAuth() {
        return getProperty(OltSystem.Field.macAuth);
    }

    public void setMacAuth(String macAuth) {
        setProperty(OltSystem.Field.macAuth, macAuth);
    }

    public String getVlanTransParent() {
        return getProperty(OltSystem.Field.vlanTransParent);
    }

    public void setVlanTransParent(String vlanTransParent) {
        setProperty(OltSystem.Field.vlanTransParent, vlanTransParent);
    }

    public String getGlobalP2p() {
        return getProperty(OltSystem.Field.globalP2p);
    }

    public void setGlobalP2p(String globalP2p) {
        setProperty(OltSystem.Field.globalP2p, globalP2p);
    }

    public String getMgmtIp() {
        return getProperty(OltSystem.Field.mgmtIp);
    }

    public void setMgmtIp(String mgmtIp) {
        setProperty(OltSystem.Field.mgmtIp, mgmtIp);
    }

    public Vector retrieveAll() throws MibBeanException {
        for (OltSystem.Field field : OltSystem.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return loadAll(new int[]{});
    }

    public boolean modify() throws MibBeanException {
        for (OltSystem.Field field : OltSystem.Field.values()) {
            prepareSave(getProperty(field.name()));
        }
        return save();
    }

    public boolean add() throws MibBeanException {
        for (OltSystem.Field field : OltSystem.Field.values()) {
            prepareSave(getProperty(field.name()));
        }

        getProperty(ROW_STATUS).setValue(XmlOperation.ADD.name());
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        getProperty(ROW_STATUS).setValue(XmlOperation.DELETE.name());
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }
}

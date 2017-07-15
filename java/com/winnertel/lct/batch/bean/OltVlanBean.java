package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.protocol.OltVlan;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlOperation;

import java.util.Vector;

public class OltVlanBean extends SnmpMibBean {
    public OltVlanBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        for (OltVlan.Field field : OltVlan.Field.values()) {
            initProperty(field.name(), new SnmpMibBeanProperty(field.name(), TableName.OltVlan.name() + "." + field.name(), ISnmpConstant.STRING));
        }
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, TableName.OltVlan.name() + "." + LctContants.OPERATION, ISnmpConstant.STRING));
    }


    public String getId() {
        return String.valueOf(getIndex(0));
    }

    public void setId(String id) {
        setIndex(0, id);
    }

    public String getProperty(OltVlan.Field field) {
        Object value = getProperty(field.name()).getValue();
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

    public void setProperty(OltVlan.Field field, String val) {
        getProperty(field.name()).setValue(val);
    }

    public String getName() {
        return getProperty(OltVlan.Field.name);
    }

    public void setName(String name) {
        setProperty(OltVlan.Field.name, name);
    }

    public String getMember() {
        return getProperty(OltVlan.Field.member);
    }

    public void setMember(String member) {
        setProperty(OltVlan.Field.member, member);
    }

    public String getTagMember() {
        return getProperty(OltVlan.Field.tagMember);
    }

    public void setTagMember(String tagMember) {
        setProperty(OltVlan.Field.tagMember, tagMember);
    }


    public boolean retrieve() throws MibBeanException {
        for (OltVlan.Field field : OltVlan.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        for (OltVlan.Field field : OltVlan.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        for (OltVlan.Field field : OltVlan.Field.values()) {
            prepareSave(getProperty(field.name()));
        }
        return save();
    }

    public boolean add() throws MibBeanException {
        for (OltVlan.Field field : OltVlan.Field.values()) {
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

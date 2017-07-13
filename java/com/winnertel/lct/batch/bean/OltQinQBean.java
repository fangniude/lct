package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.protocol.OltQinQ;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlOperation;

import java.util.Vector;

public class OltQinQBean extends SnmpMibBean {
    public OltQinQBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        for (OltQinQ.Field field : OltQinQ.Field.values()) {
            initProperty(field.name(), new SnmpMibBeanProperty(field.name(), TableName.OltQinQ.name() + "." + field.name(), ISnmpConstant.STRING));
        }
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, TableName.OltQinQ.name() + "." + LctContants.OPERATION, ISnmpConstant.STRING));
    }


    public String getId() {
        return String.valueOf(getIndex(0));
    }

    public void setId(String id) {
        setIndex(0, id);
    }


    public String getIndex() {
        return String.valueOf(getIndex(1));
    }

    public void setIndex(String index) {
        setIndex(1, index);
    }

    public String getProperty(OltQinQ.Field field) {
        return String.valueOf(getProperty(field.name()).getValue());
    }

    public void setProperty(OltQinQ.Field field, String val) {
        getProperty(field.name()).setValue(val);
    }

    public String getStartVlan() {
        return getProperty(OltQinQ.Field.startVlan);
    }

    public void setStartVlan(String startVlan) {
        setProperty(OltQinQ.Field.startVlan, startVlan);
    }

    public String getEndVlan() {
        return getProperty(OltQinQ.Field.endVlan);
    }

    public void setEndVlan(String endVlan) {
        setProperty(OltQinQ.Field.endVlan, endVlan);
    }

    public String getEtherType() {
        return getProperty(OltQinQ.Field.etherType);
    }

    public void setEtherType(String etherType) {
        setProperty(OltQinQ.Field.etherType, etherType);
    }

    public String getNewVlan() {
        return getProperty(OltQinQ.Field.newVlan);
    }

    public void setNewVlan(String newVlan) {
        setProperty(OltQinQ.Field.newVlan, newVlan);
    }


    public boolean retrieve() throws MibBeanException {
        for (OltQinQ.Field field : OltQinQ.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        for (OltQinQ.Field field : OltQinQ.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        for (OltQinQ.Field field : OltQinQ.Field.values()) {
            prepareSave(getProperty(field.name()));
        }
        return save();
    }

    public boolean add() throws MibBeanException {
        for (OltQinQ.Field field : OltQinQ.Field.values()) {
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

package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.protocol.OnuMac;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlOperation;

import java.util.Comparator;
import java.util.Vector;

public class OnuMacBean extends SnmpMibBean {
    public OnuMacBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        for (OnuMac.Field field : OnuMac.Field.values()) {
            initProperty(field.name(), new SnmpMibBeanProperty(field.name(), TableName.OnuMac.name() + "." + field.name(), ISnmpConstant.STRING));
        }
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, TableName.OnuMac.name() + "." + LctContants.OPERATION, ISnmpConstant.STRING));
    }


    public String getId() {
        return String.valueOf(getIndex(0));
    }

    public void setId(String id) {
        setIndex(0, id);
    }

    public String getProperty(OnuMac.Field field) {
        Object value = getProperty(field.name()).getValue();
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

    public void setProperty(OnuMac.Field field, String val) {
        getProperty(field.name()).setValue(val);
    }

    public String getMac() {
        return getProperty(OnuMac.Field.mac);
    }

    public void setMac(String mac) {
        setProperty(OnuMac.Field.mac, mac);
    }

    public String getDesc() {
        return getProperty(OnuMac.Field.desc);
    }

    public void setDesc(String desc) {
        setProperty(OnuMac.Field.desc, desc);
    }

    public boolean retrieve() throws MibBeanException {
        for (OnuMac.Field field : OnuMac.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        for (OnuMac.Field field : OnuMac.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        Vector<OnuMacBean> vector = loadAll(new int[]{1});
        vector.sort(Comparator.comparing(OnuMacBean::getId));
        return vector;
    }

    public boolean modify() throws MibBeanException {
        for (OnuMac.Field field : OnuMac.Field.values()) {
            prepareSave(getProperty(field.name()));
        }
        return save();
    }

    public boolean add() throws MibBeanException {
        for (OnuMac.Field field : OnuMac.Field.values()) {
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

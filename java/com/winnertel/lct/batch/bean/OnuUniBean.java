package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.protocol.OnuUni;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlOperation;

import java.util.Vector;

public class OnuUniBean extends SnmpMibBean {
    public OnuUniBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        for (OnuUni.Field field : OnuUni.Field.values()) {
            initProperty(field.name(), new SnmpMibBeanProperty(field.name(), TableName.OnuUni.name() + "." + field.name(), ISnmpConstant.STRING));
        }
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, TableName.OnuUni.name() + "." + LctContants.OPERATION, ISnmpConstant.STRING));
    }


    public String getId() {
        return String.valueOf(getIndex(0));
    }

    public void setId(String id) {
        setIndex(0, id);
    }

    public String getProperty(OnuUni.Field field) {
        Object value = getProperty(field.name()).getValue();
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

    public void setProperty(OnuUni.Field field, String val) {
        getProperty(field.name()).setValue(val);
    }

    public String getVlanMode() {
        return getProperty(OnuUni.Field.vlanMode);
    }

    public void setVlanMode(String vlanMode) {
        setProperty(OnuUni.Field.vlanMode, vlanMode);
    }

    public String getVlanTag() {
        return getProperty(OnuUni.Field.vlanTag);
    }

    public void setVlanTag(String vlanTag) {
        setProperty(OnuUni.Field.vlanTag, vlanTag);
    }


    public String getPassVlan() {
        return getProperty(OnuUni.Field.passVlan);
    }

    public void setPassVlan(String passVlan) {
        setProperty(OnuUni.Field.passVlan, passVlan);
    }

    public String getVlanTpid() {
        return getProperty(OnuUni.Field.vlanTpid);
    }

    public void setVlanTpid(String vlanTpid) {
        setProperty(OnuUni.Field.vlanTpid, vlanTpid);
    }

    public String getPolicingEnable() {
        return getProperty(OnuUni.Field.policingEnable);
    }

    public void setPolicingEnable(String policingEnable) {
        setProperty(OnuUni.Field.policingEnable, policingEnable);
    }

    public String getPolicingCir() {
        return getProperty(OnuUni.Field.policingCir);
    }

    public void setPolicingCir(String policingCir) {
        setProperty(OnuUni.Field.policingCir, policingCir);
    }

    public String getPolicingCbs() {
        return getProperty(OnuUni.Field.policingCbs);
    }

    public void setPolicingCbs(String policingCbs) {
        setProperty(OnuUni.Field.policingCbs, policingCbs);
    }

    public String getPolicingEbs() {
        return getProperty(OnuUni.Field.policingEbs);
    }

    public void setPolicingEbs(String policingEbs) {
        setProperty(OnuUni.Field.policingEbs, policingEbs);
    }

    public String getDsCir() {
        return getProperty(OnuUni.Field.dsCir);
    }

    public void setDsCir(String dsCir) {
        setProperty(OnuUni.Field.dsCir, dsCir);
    }

    public String getDsPir() {
        return getProperty(OnuUni.Field.dsPir);
    }

    public void setDsPir(String dsPir) {
        setProperty(OnuUni.Field.dsPir, dsPir);
    }

    public String getDsEnable() {
        return getProperty(OnuUni.Field.dsEnable);
    }

    public void setDsEnable(String dsEnable) {
        setProperty(OnuUni.Field.dsEnable, dsEnable);
    }

    public String getLoopDetect() {
        return getProperty(OnuUni.Field.loopDetect);
    }

    public void setLoopDetect(String loopDetect) {
        setProperty(OnuUni.Field.loopDetect, loopDetect);
    }


    public boolean retrieve() throws MibBeanException {
        for (OnuUni.Field field : OnuUni.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        for (OnuUni.Field field : OnuUni.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        for (OnuUni.Field field : OnuUni.Field.values()) {
            prepareSave(getProperty(field.name()));
        }
        return save();
    }

    public boolean add() throws MibBeanException {
        for (OnuUni.Field field : OnuUni.Field.values()) {
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

package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.protocol.ProfileUni;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlOperation;

import java.util.Vector;

public class ProfileUniBean extends SnmpMibBean {
    public ProfileUniBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        for (ProfileUni.Field field : ProfileUni.Field.values()) {
            initProperty(field.name(), new SnmpMibBeanProperty(field.name(), TableName.ProfileUni.name() + "." + field.name(), ISnmpConstant.STRING));
        }
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, TableName.ProfileUni.name() + "." + LctContants.OPERATION, ISnmpConstant.STRING));
    }


    public String getId() {
        return String.valueOf(getIndex(0));
    }

    public void setId(String id) {
        setIndex(0, id);
    }

    public String getProperty(ProfileUni.Field field) {
        return String.valueOf(getProperty(field.name()).getValue());
    }

    public void setProperty(ProfileUni.Field field, String val) {
        getProperty(field.name()).setValue(val);
    }

    public String getVlanMode() {
        return getProperty(ProfileUni.Field.vlanMode);
    }

    public void setVlanMode(String vlanMode) {
        setProperty(ProfileUni.Field.vlanMode, vlanMode);
    }

    public String getVlanTag() {
        return getProperty(ProfileUni.Field.vlanTag);
    }

    public void setVlanTag(String vlanTag) {
        setProperty(ProfileUni.Field.vlanTag, vlanTag);
    }

    public String getVlanTpid() {
        return getProperty(ProfileUni.Field.vlanTpid);
    }

    public void setVlanTpid(String vlanTpid) {
        setProperty(ProfileUni.Field.vlanTpid, vlanTpid);
    }

    public String getPolicingEnable() {
        return getProperty(ProfileUni.Field.policingEnable);
    }

    public void setPolicingEnable(String policingEnable) {
        setProperty(ProfileUni.Field.policingEnable, policingEnable);
    }

    public String getPolicingCir() {
        return getProperty(ProfileUni.Field.policingCir);
    }

    public void setPolicingCir(String policingCir) {
        setProperty(ProfileUni.Field.policingCir, policingCir);
    }

    public String getPolicingCbs() {
        return getProperty(ProfileUni.Field.policingCbs);
    }

    public void setPolicingCbs(String policingCbs) {
        setProperty(ProfileUni.Field.policingCbs, policingCbs);
    }

    public String getPolicingEbs() {
        return getProperty(ProfileUni.Field.policingEbs);
    }

    public void setPolicingEbs(String policingEbs) {
        setProperty(ProfileUni.Field.policingEbs, policingEbs);
    }

    public String getDsCir() {
        return getProperty(ProfileUni.Field.dsCir);
    }

    public void setDsCir(String dsCir) {
        setProperty(ProfileUni.Field.dsCir, dsCir);
    }

    public String getDsPir() {
        return getProperty(ProfileUni.Field.dsPir);
    }

    public void setDsPir(String dsPir) {
        setProperty(ProfileUni.Field.dsPir, dsPir);
    }

    public String getDsEnable() {
        return getProperty(ProfileUni.Field.dsEnable);
    }

    public void setDsEnable(String dsEnable) {
        setProperty(ProfileUni.Field.dsEnable, dsEnable);
    }

    public String getLoopDetect() {
        return getProperty(ProfileUni.Field.loopDetect);
    }

    public void setLoopDetect(String loopDetect) {
        setProperty(ProfileUni.Field.loopDetect, loopDetect);
    }


    public boolean retrieve() throws MibBeanException {
        for (ProfileUni.Field field : ProfileUni.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        for (ProfileUni.Field field : ProfileUni.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        for (ProfileUni.Field field : ProfileUni.Field.values()) {
            prepareSave(getProperty(field.name()));
        }
        return save();
    }

    public boolean add() throws MibBeanException {
        for (ProfileUni.Field field : ProfileUni.Field.values()) {
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

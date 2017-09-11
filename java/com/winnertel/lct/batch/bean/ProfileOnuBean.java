package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.gui.TransformUtils;
import com.winnertel.lct.batch.protocol.ProfileOnu;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlOperation;

import java.util.Comparator;
import java.util.Vector;

public class ProfileOnuBean extends SnmpMibBean {
    public ProfileOnuBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        for (ProfileOnu.Field field : ProfileOnu.Field.values()) {
            initProperty(field.name(), new SnmpMibBeanProperty(field.name(), TableName.ProfileOnu.name() + "." + field.name(), ISnmpConstant.STRING));
        }
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, TableName.ProfileOnu.name() + "." + LctContants.OPERATION, ISnmpConstant.STRING));
    }


    public String getId() {
        return String.valueOf(getIndex(0));
    }

    public void setId(String id) {
        setIndex(0, id);
    }

    public String getProperty(ProfileOnu.Field field) {
        Object value = getProperty(field.name()).getValue();
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

    public void setProperty(ProfileOnu.Field field, String val) {
        getProperty(field.name()).setValue(val);
    }

    public String getDbaSlaEnable() {
        return getProperty(ProfileOnu.Field.dbaSlaEnable);
    }

    public void setDbaSlaEnable(String dbaSlaEnable) {
        setProperty(ProfileOnu.Field.dbaSlaEnable, dbaSlaEnable);
    }

    public String getUpMaxBw() {
        return getProperty(ProfileOnu.Field.upMaxBw);
    }

    public void setUpMaxBw(String upMaxBw) {
        setProperty(ProfileOnu.Field.upMaxBw, upMaxBw);
    }

    public String getDownMaxBw() {
        return getProperty(ProfileOnu.Field.downMaxBw);
    }

    public void setDownMaxBw(String downMaxBw) {
        setProperty(ProfileOnu.Field.downMaxBw, downMaxBw);
    }

    public String getUpCommittedBw() {
        return getProperty(ProfileOnu.Field.upCommittedBw);
    }

    public void setUpCommittedBw(String upCommittedBw) {
        setProperty(ProfileOnu.Field.upCommittedBw, upCommittedBw);
    }

    public String getDownCommittedBw() {
        return getProperty(ProfileOnu.Field.downCommittedBw);
    }

    public void setDownCommittedBw(String downCommittedBw) {
        setProperty(ProfileOnu.Field.downCommittedBw, downCommittedBw);
    }

    public String getUpFixBw() {
        return getProperty(ProfileOnu.Field.upFixBw);
    }

    public void setUpFixBw(String upFixBw) {
        setProperty(ProfileOnu.Field.upFixBw, upFixBw);
    }

    public String getUpBurstSize() {
        return getProperty(ProfileOnu.Field.upBurstSize);
    }

    public void setUpBurstSize(String upBurstSize) {
        setProperty(ProfileOnu.Field.upBurstSize, upBurstSize);
    }

    public String getDownBurstSize() {
        return getProperty(ProfileOnu.Field.downBurstSize);
    }

    public void setDownBurstSize(String downBurstSize) {
        setProperty(ProfileOnu.Field.downBurstSize, downBurstSize);
    }

    public String getUpPriority() {
        return getProperty(ProfileOnu.Field.upPriority);
    }

    public void setUpPriority(String upPriority) {
        setProperty(ProfileOnu.Field.upPriority, upPriority);
    }

    public String getMxuMgmtGlbEnable() {
        return getProperty(ProfileOnu.Field.mxuMgmtGlbEnable);
    }

    public void setMxuMgmtGlbEnable(String mxuMgmtGlbEnable) {
        setProperty(ProfileOnu.Field.mxuMgmtGlbEnable, mxuMgmtGlbEnable);
    }

    public String getMxuIpAddress() {
        return getProperty(ProfileOnu.Field.mxuIpAddress);
    }

    public void setMxuIpAddress(String mxuIpAddress) {
        setProperty(ProfileOnu.Field.mxuIpAddress, mxuIpAddress);
    }

    public String getMxuIpMask() {
        return getProperty(ProfileOnu.Field.mxuIpMask);
    }

    public void setMxuIpMask(String mxuIpMask) {
        setProperty(ProfileOnu.Field.mxuIpMask, mxuIpMask);
    }

    public String getMxuGateway() {
        return getProperty(ProfileOnu.Field.mxuGateway);
    }

    public void setMxuGateway(String mxuGateway) {
        setProperty(ProfileOnu.Field.mxuGateway, mxuGateway);
    }

    public String getMxuCVlan() {
        return getProperty(ProfileOnu.Field.mxuCVlan);
    }

    public void setMxuCVlan(String mxuCVlan) {
        setProperty(ProfileOnu.Field.mxuCVlan, mxuCVlan);
    }

    public String getMxuSVlan() {
        return getProperty(ProfileOnu.Field.mxuSVlan);
    }

    public void setMxuSVlan(String mxuSVlan) {
        setProperty(ProfileOnu.Field.mxuSVlan, mxuSVlan);
    }

    public String getMxuPriority() {
        return getProperty(ProfileOnu.Field.mxuPriority);
    }

    public void setMxuPriority(String mxuPriority) {
        setProperty(ProfileOnu.Field.mxuPriority, mxuPriority);
    }

    public boolean retrieve() throws MibBeanException {
        for (ProfileOnu.Field field : ProfileOnu.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        for (ProfileOnu.Field field : ProfileOnu.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        Vector<ProfileOnuBean> vector = loadAll(new int[]{1});
        vector.sort(Comparator.comparingInt(b -> TransformUtils.idSortNum(b.getId())));
        return vector;
    }

    public boolean modify() throws MibBeanException {
        for (ProfileOnu.Field field : ProfileOnu.Field.values()) {
            prepareSave(getProperty(field.name()));
        }
        return save();
    }

    public boolean add() throws MibBeanException {
        for (ProfileOnu.Field field : ProfileOnu.Field.values()) {
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

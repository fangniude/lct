package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.protocol.OnuCfg;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlOperation;

import java.util.Comparator;
import java.util.Vector;

public class OnuCfgBean extends SnmpMibBean {
    public OnuCfgBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        for (OnuCfg.Field field : OnuCfg.Field.values()) {
            initProperty(field.name(), new SnmpMibBeanProperty(field.name(), TableName.OnuCfg.name() + "." + field.name(), ISnmpConstant.STRING));
        }
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, TableName.OnuCfg.name() + "." + LctContants.OPERATION, ISnmpConstant.STRING));
    }


    public String getId() {
        return String.valueOf(getIndex(0));
    }

    public void setId(String id) {
        setIndex(0, id);
    }

    public String getProperty(OnuCfg.Field field) {
        Object value = getProperty(field.name()).getValue();
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

    public void setProperty(OnuCfg.Field field, String val) {
        getProperty(field.name()).setValue(val);
    }

    public String getDbaSlaEnable() {
        return getProperty(OnuCfg.Field.dbaSlaEnable);
    }

    public void setDbaSlaEnable(String dbaSlaEnable) {
        setProperty(OnuCfg.Field.dbaSlaEnable, dbaSlaEnable);
    }

    public String getUpMaxBw() {
        return getProperty(OnuCfg.Field.upMaxBw);
    }

    public void setUpMaxBw(String upMaxBw) {
        setProperty(OnuCfg.Field.upMaxBw, upMaxBw);
    }

    public String getDownMaxBw() {
        return getProperty(OnuCfg.Field.downMaxBw);
    }

    public void setDownMaxBw(String downMaxBw) {
        setProperty(OnuCfg.Field.downMaxBw, downMaxBw);
    }

    public String getUpCommittedBw() {
        return getProperty(OnuCfg.Field.upCommittedBw);
    }

    public void setUpCommittedBw(String upCommittedBw) {
        setProperty(OnuCfg.Field.upCommittedBw, upCommittedBw);
    }

    public String getDownCommittedBw() {
        return getProperty(OnuCfg.Field.downCommittedBw);
    }

    public void setDownCommittedBw(String downCommittedBw) {
        setProperty(OnuCfg.Field.downCommittedBw, downCommittedBw);
    }

    public String getUpFixBw() {
        return getProperty(OnuCfg.Field.upFixBw);
    }

    public void setUpFixBw(String upFixBw) {
        setProperty(OnuCfg.Field.upFixBw, upFixBw);
    }

    public String getUpBurstSize() {
        return getProperty(OnuCfg.Field.upBurstSize);
    }

    public void setUpBurstSize(String upBurstSize) {
        setProperty(OnuCfg.Field.upBurstSize, upBurstSize);
    }

    public String getDownBurstSize() {
        return getProperty(OnuCfg.Field.downBurstSize);
    }

    public void setDownBurstSize(String downBurstSize) {
        setProperty(OnuCfg.Field.downBurstSize, downBurstSize);
    }

    public String getUpPriority() {
        return getProperty(OnuCfg.Field.upPriority);
    }

    public void setUpPriority(String upPriority) {
        setProperty(OnuCfg.Field.upPriority, upPriority);
    }

    public String getMxuMgmtGlbEnable() {
        return getProperty(OnuCfg.Field.mxuMgmtGlbEnable);
    }

    public void setMxuMgmtGlbEnable(String mxuMgmtGlbEnable) {
        setProperty(OnuCfg.Field.mxuMgmtGlbEnable, mxuMgmtGlbEnable);
    }

    public String getMxuIpAddress() {
        return getProperty(OnuCfg.Field.mxuIpAddress);
    }

    public void setMxuIpAddress(String mxuIpAddress) {
        setProperty(OnuCfg.Field.mxuIpAddress, mxuIpAddress);
    }

    public String getMxuIpMask() {
        return getProperty(OnuCfg.Field.mxuIpMask);
    }

    public void setMxuIpMask(String mxuIpMask) {
        setProperty(OnuCfg.Field.mxuIpMask, mxuIpMask);
    }

    public String getMxuGateway() {
        return getProperty(OnuCfg.Field.mxuGateway);
    }

    public void setMxuGateway(String mxuGateway) {
        setProperty(OnuCfg.Field.mxuGateway, mxuGateway);
    }

    public String getMxuCVlan() {
        return getProperty(OnuCfg.Field.mxuCVlan);
    }

    public void setMxuCVlan(String mxuCVlan) {
        setProperty(OnuCfg.Field.mxuCVlan, mxuCVlan);
    }

    public String getMxuSVlan() {
        return getProperty(OnuCfg.Field.mxuSVlan);
    }

    public void setMxuSVlan(String mxuSVlan) {
        setProperty(OnuCfg.Field.mxuSVlan, mxuSVlan);
    }

    public String getMxuPriority() {
        return getProperty(OnuCfg.Field.mxuPriority);
    }

    public void setMxuPriority(String mxuPriority) {
        setProperty(OnuCfg.Field.mxuPriority, mxuPriority);
    }

    public boolean retrieve() throws MibBeanException {
        for (OnuCfg.Field field : OnuCfg.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        for (OnuCfg.Field field : OnuCfg.Field.values()) {
            prepareRead(getProperty(field.name()));
        }

        Vector<OnuCfgBean> vector = loadAll(new int[]{1});
        vector.sort(Comparator.comparing(OnuCfgBean::getId));
        return vector;
    }

    public boolean modify() throws MibBeanException {
        for (OnuCfg.Field field : OnuCfg.Field.values()) {
            prepareSave(getProperty(field.name()));
        }
        return save();
    }

    public boolean add() throws MibBeanException {
        for (OnuCfg.Field field : OnuCfg.Field.values()) {
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

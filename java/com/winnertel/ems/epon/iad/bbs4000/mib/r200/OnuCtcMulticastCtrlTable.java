package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuCtcMulticastCtrlTable extends SnmpMibBean {

    public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
    public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
    public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
    public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
    public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
    public static final String utsDot3OnuMCastVlan = "utsDot3OnuMCastVlan";
    public static final String utsDot3OnuMCastGroupStart = "utsDot3OnuMCastGroupStart";
    public static final String utsDot3OnuMCastGroupEnd = "utsDot3OnuMCastGroupEnd";
    public static final String utsDot3OnuAuthType = "utsDot3OnuAuthType";


    public OnuCtcMulticastCtrlTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastVlan, new SnmpMibBeanProperty(utsDot3OnuMCastVlan, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastGroupStart, new SnmpMibBeanProperty(utsDot3OnuMCastGroupStart, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.7", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3OnuMCastGroupEnd, new SnmpMibBeanProperty(utsDot3OnuMCastGroupEnd, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.8", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3OnuAuthType, new SnmpMibBeanProperty(utsDot3OnuAuthType, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.9", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.4.3.1.1.1.10", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuModuleId(Integer aUtsDot3OnuModuleId) {
        setIndex(0, aUtsDot3OnuModuleId);
    }

    public Integer getUtsDot3OnuDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuDeviceId(Integer aUtsDot3OnuDeviceId) {
        setIndex(1, aUtsDot3OnuDeviceId);
    }

    public Integer getUtsDot3OnuPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuPortId(Integer aUtsDot3OnuPortId) {
        setIndex(2, aUtsDot3OnuPortId);
    }

    public Integer getUtsDot3OnuLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuLogicalPortId(Integer aUtsDot3OnuLogicalPortId) {
        setIndex(3, aUtsDot3OnuLogicalPortId);
    }

    public Integer getUtsDot3OnuEtherPortIndex() {
        return (Integer) getIndex(4);
    }

    public void setUtsDot3OnuEtherPortIndex(Integer aUtsDot3OnuEtherPortIndex) {
        setIndex(4, aUtsDot3OnuEtherPortIndex);
    }

    public Integer getUtsDot3OnuMCastVlan() {
        return (Integer) getIndex(5);
    }

    public void setUtsDot3OnuMCastVlan(Integer aUtsDot3OnuMCastVlan) {
        setIndex(5, aUtsDot3OnuMCastVlan);
    }

    public String getUtsDot3OnuMCastGroupStart() {
        return (String) getIndex(6);
    }

    public void setUtsDot3OnuMCastGroupStart(String aUtsDot3OnuMCastGroupStart) {
        setIndex(6, aUtsDot3OnuMCastGroupStart);
    }

    public String getUtsDot3OnuMCastGroupEnd() {
        return (String) getProperty(utsDot3OnuMCastGroupEnd).getValue();
    }

    public void setUtsDot3OnuMCastGroupEnd(String aUtsDot3OnuMCastGroupEnd) {
        getProperty(utsDot3OnuMCastGroupEnd).setValue(aUtsDot3OnuMCastGroupEnd);
    }

    public Integer getUtsDot3OnuAuthType() {
        return (Integer) getProperty(utsDot3OnuAuthType).getValue();
    }

    public void setUtsDot3OnuAuthType(Integer aUtsDot3OnuAuthType) {
        getProperty(utsDot3OnuAuthType).setValue(aUtsDot3OnuAuthType);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuMCastGroupStart));
        prepareRead(getProperty(utsDot3OnuMCastGroupEnd));
        prepareRead(getProperty(utsDot3OnuAuthType));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuMCastGroupEnd));
        prepareRead(getProperty(utsDot3OnuAuthType));

        return loadAll(new int[]{1, 1, 1, 1, 1, 1, 4});
    }

    public boolean add() throws MibBeanException {
        setRowStatus(new Integer(4));
        prepareSave(getProperty(utsDot3OnuMCastGroupEnd));
        prepareSave(getProperty(utsDot3OnuAuthType));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    //added by Zhou Chao
    public String toString() {
        return "ONU " + getIndex(0) + "/" + getIndex(2) + "/" + getIndex(3);
    }

}
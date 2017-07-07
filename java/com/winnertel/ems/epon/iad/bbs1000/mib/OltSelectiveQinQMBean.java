package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OltSelectiveQinQMBean extends SnmpMibBean {

    public static final String utsDot3OnuSelectiveQinQModuleId = "utsDot3OnuSelectiveQinQModuleId";
    public static final String utsDot3OnuSelectiveQinQDeviceId = "utsDot3OnuSelectiveQinQDeviceId";
    public static final String utsDot3OnuSelectiveQinQPortId = "utsDot3OnuSelectiveQinQPortId";
    public static final String utsDot3OnuSelectiveQinQLogicalPortId = "utsDot3OnuSelectiveQinQLogicalPortId";
    public static final String utsDot3OnuSelectiveQinQEtherType = "utsDot3OnuSelectiveQinQEtherType";
    public static final String utsDot3OnuSelectiveQinQCos = "utsDot3OnuSelectiveQinQCos";
    //public static final String utsDot3OnuSelectiveQinQCVID = "utsDot3OnuSelectiveQinQCVID"; //remarked by Zhou Chao, 2008/10/15
    public static final String utsDot3OnuSelectiveQinQStartCVID = "utsDot3OnuSelectiveQinQStartCVID"; //added by Zhou Chao, 2008/10/15
    public static final String utsDot3OnuSelectiveQinQEndCVID = "utsDot3OnuSelectiveQinQEndCVID"; //added by Zhou Chao, 2008/10/15
    public static final String utsDot3OnuSelectiveQinQSVID = "utsDot3OnuSelectiveQinQSVID";
    public static final String utsDot3OnuSelectiveQinQSCosSourceSelect = "utsDot3OnuSelectiveQinQSCosSourceSelect";
    public static final String utsDot3OnuSelectiveQinQSAppointCos = "utsDot3OnuSelectiveQinQSAppointCos";

    public OltSelectiveQinQMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuSelectiveQinQModuleId, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSelectiveQinQDeviceId, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSelectiveQinQPortId, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSelectiveQinQLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSelectiveQinQEtherType, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQEtherType, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSelectiveQinQCos, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQCos, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.6", ISnmpConstant.INTEGER));
        //initProperty(utsDot3OnuSelectiveQinQCVID, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQCVID, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.7", ISnmpConstant.INTEGER)); //remarked by Zhou Chao, 2008/10/15
        initProperty(utsDot3OnuSelectiveQinQStartCVID, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQStartCVID, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.7", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2008/10/15
        initProperty(utsDot3OnuSelectiveQinQEndCVID, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQEndCVID, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.8", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2008/10/15
        initProperty(utsDot3OnuSelectiveQinQSVID, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQSVID, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSelectiveQinQSCosSourceSelect, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQSCosSourceSelect, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.10", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSelectiveQinQSAppointCos, new SnmpMibBeanProperty(utsDot3OnuSelectiveQinQSAppointCos, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.11", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.23.1.12", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuSelectiveQinQModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuSelectiveQinQModuleId(Integer aUtsDot3OnuSelectiveQinQModuleId) {
        setIndex(0, aUtsDot3OnuSelectiveQinQModuleId);
    }

    public Integer getUtsDot3OnuSelectiveQinQDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuSelectiveQinQDeviceId(Integer aUtsDot3OnuSelectiveQinQDeviceId) {
        setIndex(1, aUtsDot3OnuSelectiveQinQDeviceId);
    }

    public Integer getUtsDot3OnuSelectiveQinQPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuSelectiveQinQPortId(Integer aUtsDot3OnuSelectiveQinQPortId) {
        setIndex(2, aUtsDot3OnuSelectiveQinQPortId);
    }

    public Integer getUtsDot3OnuSelectiveQinQLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuSelectiveQinQLogicalPortId(Integer aUtsDot3OnuSelectiveQinQLogicalPortId) {
        setIndex(3, aUtsDot3OnuSelectiveQinQLogicalPortId);
    }

    public Integer getUtsDot3OnuSelectiveQinQEtherType() {
        return (Integer) getIndex(4);
    }

    public void setUtsDot3OnuSelectiveQinQEtherType(Integer aUtsDot3OnuSelectiveQinQEtherType) {
        setIndex(4, aUtsDot3OnuSelectiveQinQEtherType);
    }

    public Integer getUtsDot3OnuSelectiveQinQCos() {
        return (Integer) getIndex(5);
    }

    public void setUtsDot3OnuSelectiveQinQCos(Integer aUtsDot3OnuSelectiveQinQCos) {
        setIndex(5, aUtsDot3OnuSelectiveQinQCos);
    }

    /* remarked by Zhou Chao, 2008/10/15
    public Integer getUtsDot3OnuSelectiveQinQCVID() {
        return (Integer) getIndex(6);
    }

    public void setUtsDot3OnuSelectiveQinQCVID(Integer aUtsDot3OnuSelectiveQinQCVID) {
        setIndex(6, aUtsDot3OnuSelectiveQinQCVID);
    }
    */

    //added by Zhou Chao, 2008/10/15 -- begin

    public Integer getUtsDot3OnuSelectiveQinQStartCVID() {
        return (Integer) getIndex(6);
    }

    public void setUtsDot3OnuSelectiveQinQStartCVID(Integer aUtsDot3OnuSelectiveQinQStartCVID) {
        setIndex(6, aUtsDot3OnuSelectiveQinQStartCVID);
    }

    public Integer getUtsDot3OnuSelectiveQinQEndCVID() {
        return (Integer) getIndex(7);
    }

    public void setUtsDot3OnuSelectiveQinQEndCVID(Integer aUtsDot3OnuSelectiveQinQEndCVID) {
        setIndex(7, aUtsDot3OnuSelectiveQinQEndCVID);
    }
    //added by Zhou Chao, 2008/10/15 -- end

    public Integer getUtsDot3OnuSelectiveQinQSVID() {
        return (Integer) getProperty(utsDot3OnuSelectiveQinQSVID).getValue();
    }

    public void setUtsDot3OnuSelectiveQinQSVID(Integer aUtsDot3OnuSelectiveQinQSVID) {
        getProperty(utsDot3OnuSelectiveQinQSVID).setValue(aUtsDot3OnuSelectiveQinQSVID);
    }

    public Integer getUtsDot3OnuSelectiveQinQSCosSourceSelect() {
        return (Integer) getProperty(utsDot3OnuSelectiveQinQSCosSourceSelect).getValue();
    }

    public void setUtsDot3OnuSelectiveQinQSCosSourceSelect(Integer aUtsDot3OnuSelectiveQinQSCosSourceSelect) {
        getProperty(utsDot3OnuSelectiveQinQSCosSourceSelect).setValue(aUtsDot3OnuSelectiveQinQSCosSourceSelect);
    }

    public Integer getUtsDot3OnuSelectiveQinQSAppointCos() {
        return (Integer) getProperty(utsDot3OnuSelectiveQinQSAppointCos).getValue();
    }

    public void setUtsDot3OnuSelectiveQinQSAppointCos(Integer aUtsDot3OnuSelectiveQinQSAppointCos) {
        getProperty(utsDot3OnuSelectiveQinQSAppointCos).setValue(aUtsDot3OnuSelectiveQinQSAppointCos);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuSelectiveQinQSVID));
        prepareRead(getProperty(utsDot3OnuSelectiveQinQSCosSourceSelect));
        prepareRead(getProperty(utsDot3OnuSelectiveQinQSAppointCos));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuSelectiveQinQSVID));
        prepareRead(getProperty(utsDot3OnuSelectiveQinQSCosSourceSelect));
        prepareRead(getProperty(utsDot3OnuSelectiveQinQSAppointCos));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1, 1, 1, 1});

        //remove the onu QinQ item.
        int i = 0;
        while (i < v.size()) {
            OltSelectiveQinQMBean bean = (OltSelectiveQinQMBean) v.get(i);
            if (bean.getUtsDot3OnuSelectiveQinQLogicalPortId() != null && bean.getUtsDot3OnuSelectiveQinQLogicalPortId() != 0) {
                v.remove(i);
            } else {
                i++;
            }
        }

        return v;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuSelectiveQinQSVID));
        prepareSave(getProperty(utsDot3OnuSelectiveQinQSCosSourceSelect));
        prepareSave(getProperty(utsDot3OnuSelectiveQinQSAppointCos));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuSelectiveQinQSVID));
        prepareSave(getProperty(utsDot3OnuSelectiveQinQSCosSourceSelect));
        prepareSave(getProperty(utsDot3OnuSelectiveQinQSAppointCos));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}
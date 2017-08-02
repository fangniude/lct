/**
 * Created by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EthFlexQinQMBean extends SnmpMibBean {

    public static final String utsEthFlexQinQModuleId = "utsEthFlexQinQModuleId";
    public static final String utsEthFlexQinQDeviceId = "utsEthFlexQinQDeviceId";
    public static final String utsEthFlexQinQPortId = "utsEthFlexQinQPortId";
    public static final String utsEthFlexQinQEtherType = "utsEthFlexQinQEtherType";
    public static final String utsEthFlexQinQSourceCCos = "utsEthFlexQinQSourceCCos";
    public static final String utsEthFlexQinQSourceCVID = "utsEthFlexQinQSourceCVID";
    public static final String utsEthFlexQinQSourceCTPID = "utsEthFlexQinQSourceCTPID";
    public static final String utsEthFlexQinQSourceSCos = "utsEthFlexQinQSourceSCos";
    public static final String utsEthFlexQinQSourceSVID = "utsEthFlexQinQSourceSVID";
    public static final String utsEthFlexQinQSourceSTPID = "utsEthFlexQinQSourceSTPID";
    public static final String utsEthFlexQinQSourceTagMode = "utsEthFlexQinQSourceTagMode";
    public static final String utsEthFlexQinQDestinationSTPID = "utsEthFlexQinQDestinationSTPID";
    public static final String utsEthFlexQinQDestinationSCosAction = "utsEthFlexQinQDestinationSCosAction";
    public static final String utsEthFlexQinQDestinationSVID = "utsEthFlexQinQDestinationSVID";
    public static final String utsEthFlexQinQDestinationCTPID = "utsEthFlexQinQDestinationCTPID";
    public static final String utsEthFlexQinQDestinationCCosAction = "utsEthFlexQinQDestinationCCosAction";
    public static final String utsEthFlexQinQDestinationCVID = "utsEthFlexQinQDestinationCVID";
    public static final String utsEthFlexQinQDestinationAppointSCos = "utsEthFlexQinQDestinationAppointSCos";
    public static final String utsEthFlexQinQDestinationAppointCCos = "utsEthFlexQinQDestinationAppointCCos";
    public static final String utsEthFlexQinQDestinationTagMode = "utsEthFlexQinQDestinationTagMode";
    public static final String utsEthFlexQinQDestinationSTagProperty = "utsEthFlexQinQDestinationSTagProperty";

    public EthFlexQinQMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsEthFlexQinQModuleId, new SnmpMibBeanProperty(utsEthFlexQinQModuleId, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.1", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDeviceId, new SnmpMibBeanProperty(utsEthFlexQinQDeviceId, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.2", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQPortId, new SnmpMibBeanProperty(utsEthFlexQinQPortId, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.3", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQEtherType, new SnmpMibBeanProperty(utsEthFlexQinQEtherType, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.5", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQSourceCCos, new SnmpMibBeanProperty(utsEthFlexQinQSourceCCos, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.6", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQSourceCVID, new SnmpMibBeanProperty(utsEthFlexQinQSourceCVID, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.7", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQSourceCTPID, new SnmpMibBeanProperty(utsEthFlexQinQSourceCTPID, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.8", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQSourceSCos, new SnmpMibBeanProperty(utsEthFlexQinQSourceSCos, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.9", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQSourceSVID, new SnmpMibBeanProperty(utsEthFlexQinQSourceSVID, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.10", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQSourceSTPID, new SnmpMibBeanProperty(utsEthFlexQinQSourceSTPID, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.11", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQSourceTagMode, new SnmpMibBeanProperty(utsEthFlexQinQSourceTagMode, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.12", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationSTPID, new SnmpMibBeanProperty(utsEthFlexQinQDestinationSTPID, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.13", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationSCosAction, new SnmpMibBeanProperty(utsEthFlexQinQDestinationSCosAction, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.14", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationSVID, new SnmpMibBeanProperty(utsEthFlexQinQDestinationSVID, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.15", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationCTPID, new SnmpMibBeanProperty(utsEthFlexQinQDestinationCTPID, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.16", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationCCosAction, new SnmpMibBeanProperty(utsEthFlexQinQDestinationCCosAction, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.17", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationCVID, new SnmpMibBeanProperty(utsEthFlexQinQDestinationCVID, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.18", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationAppointSCos, new SnmpMibBeanProperty(utsEthFlexQinQDestinationAppointSCos, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.19", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationAppointCCos, new SnmpMibBeanProperty(utsEthFlexQinQDestinationAppointCCos, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.20", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationTagMode, new SnmpMibBeanProperty(utsEthFlexQinQDestinationTagMode, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.21", ISnmpConstant.INTEGER));
        initProperty(utsEthFlexQinQDestinationSTagProperty, new SnmpMibBeanProperty(utsEthFlexQinQDestinationSTagProperty, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.22", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.2.1.16.1.23", ISnmpConstant.INTEGER));
    }

    public Integer getUtsEthFlexQinQModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsEthFlexQinQModuleId(Integer aUtsEthFlexQinQModuleId) {
        setIndex(0, aUtsEthFlexQinQModuleId);
    }

    public Integer getUtsEthFlexQinQDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsEthFlexQinQDeviceId(Integer aUtsEthFlexQinQDeviceId) {
        setIndex(1, aUtsEthFlexQinQDeviceId);
    }

    public Integer getUtsEthFlexQinQPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsEthFlexQinQPortId(Integer aUtsEthFlexQinQPortId) {
        setIndex(2, aUtsEthFlexQinQPortId);
    }

    public Integer getUtsEthFlexQinQEtherType() {
        return (Integer) getIndex(3);
    }

    public void setUtsEthFlexQinQEtherType(Integer aUtsEthFlexQinQEtherType) {
        setIndex(3, aUtsEthFlexQinQEtherType);
    }

    public Integer getUtsEthFlexQinQSourceCCos() {
        return (Integer) getIndex(4);
    }

    public void setUtsEthFlexQinQSourceCCos(Integer aUtsEthFlexQinQSourceCCos) {
        setIndex(4, aUtsEthFlexQinQSourceCCos);
    }

    public Integer getUtsEthFlexQinQSourceCVID() {
        return (Integer) getIndex(5);
    }

    public void setUtsEthFlexQinQSourceCVID(Integer aUtsEthFlexQinQSourceCVID) {
        setIndex(5, aUtsEthFlexQinQSourceCVID);
    }

    public Integer getUtsEthFlexQinQSourceCTPID() {
        return (Integer) getIndex(6);
    }

    public void setUtsEthFlexQinQSourceCTPID(Integer aUtsEthFlexQinQSourceCTPID) {
        setIndex(6, aUtsEthFlexQinQSourceCTPID);
    }

    public Integer getUtsEthFlexQinQSourceSCos() {
        return (Integer) getIndex(7);
    }

    public void setUtsEthFlexQinQSourceSCos(Integer aUtsEthFlexQinQSourceSCos) {
        setIndex(7, aUtsEthFlexQinQSourceSCos);
    }

    public Integer getUtsEthFlexQinQSourceSVID() {
        return (Integer) getIndex(8);
    }

    public void setUtsEthFlexQinQSourceSVID(Integer aUtsEthFlexQinQSourceSVID) {
        setIndex(8, aUtsEthFlexQinQSourceSVID);
    }

    public Integer getUtsEthFlexQinQSourceSTPID() {
        return (Integer) getIndex(9);
    }

    public void setUtsEthFlexQinQSourceSTPID(Integer aUtsEthFlexQinQSourceSTPID) {
        setIndex(9, aUtsEthFlexQinQSourceSTPID);
    }

    public Integer getUtsEthFlexQinQSourceTagMode() {
        return (Integer) getIndex(10);
    }

    public void setUtsEthFlexQinQSourceTagMode(Integer aUtsEthFlexQinQSourceTagMode) {
        setIndex(10, aUtsEthFlexQinQSourceTagMode);
    }

    public Integer getUtsEthFlexQinQDestinationSTPID() {
        return (Integer) getProperty(utsEthFlexQinQDestinationSTPID).getValue();
    }

    public void setUtsEthFlexQinQDestinationSTPID(Integer aUtsEthFlexQinQDestinationSTPID) {
        getProperty(utsEthFlexQinQDestinationSTPID).setValue(aUtsEthFlexQinQDestinationSTPID);
    }

    public Integer getUtsEthFlexQinQDestinationSCosAction() {
        return (Integer) getProperty(utsEthFlexQinQDestinationSCosAction).getValue();
    }

    public void setUtsEthFlexQinQDestinationSCosAction(Integer aUtsEthFlexQinQDestinationSCosAction) {
        getProperty(utsEthFlexQinQDestinationSCosAction).setValue(aUtsEthFlexQinQDestinationSCosAction);
    }

    public Integer getUtsEthFlexQinQDestinationSVID() {
        return (Integer) getProperty(utsEthFlexQinQDestinationSVID).getValue();
    }

    public void setUtsEthFlexQinQDestinationSVID(Integer aUtsEthFlexQinQDestinationSVID) {
        getProperty(utsEthFlexQinQDestinationSVID).setValue(aUtsEthFlexQinQDestinationSVID);
    }

    public Integer getUtsEthFlexQinQDestinationCTPID() {
        return (Integer) getProperty(utsEthFlexQinQDestinationCTPID).getValue();
    }

    public void setUtsEthFlexQinQDestinationCTPID(Integer aUtsEthFlexQinQDestinationCTPID) {
        getProperty(utsEthFlexQinQDestinationCTPID).setValue(aUtsEthFlexQinQDestinationCTPID);
    }

    public Integer getUtsEthFlexQinQDestinationCCosAction() {
        return (Integer) getProperty(utsEthFlexQinQDestinationCCosAction).getValue();
    }

    public void setUtsEthFlexQinQDestinationCCosAction(Integer aUtsEthFlexQinQDestinationCCosAction) {
        getProperty(utsEthFlexQinQDestinationCCosAction).setValue(aUtsEthFlexQinQDestinationCCosAction);
    }

    public Integer getUtsEthFlexQinQDestinationCVID() {
        return (Integer) getProperty(utsEthFlexQinQDestinationCVID).getValue();
    }

    public void setUtsEthFlexQinQDestinationCVID(Integer aUtsEthFlexQinQDestinationCVID) {
        getProperty(utsEthFlexQinQDestinationCVID).setValue(aUtsEthFlexQinQDestinationCVID);
    }

    public Integer getUtsEthFlexQinQDestinationAppointSCos() {
        return (Integer) getProperty(utsEthFlexQinQDestinationAppointSCos).getValue();
    }

    public void setUtsEthFlexQinQDestinationAppointSCos(Integer aUtsEthFlexQinQDestinationAppointSCos) {
        getProperty(utsEthFlexQinQDestinationAppointSCos).setValue(aUtsEthFlexQinQDestinationAppointSCos);
    }

    public Integer getUtsEthFlexQinQDestinationAppointCCos() {
        return (Integer) getProperty(utsEthFlexQinQDestinationAppointCCos).getValue();
    }

    public void setUtsEthFlexQinQDestinationAppointCCos(Integer aUtsEthFlexQinQDestinationAppointCCos) {
        getProperty(utsEthFlexQinQDestinationAppointCCos).setValue(aUtsEthFlexQinQDestinationAppointCCos);
    }

    public Integer getUtsEthFlexQinQDestinationTagMode() {
        return (Integer) getProperty(utsEthFlexQinQDestinationTagMode).getValue();
    }

    public void setUtsEthFlexQinQDestinationTagMode(Integer aUtsEthFlexQinQDestinationTagMode) {
        getProperty(utsEthFlexQinQDestinationTagMode).setValue(aUtsEthFlexQinQDestinationTagMode);
    }

    public Integer getUtsEthFlexQinQDestinationSTagProperty() {
        return (Integer) getProperty(utsEthFlexQinQDestinationSTagProperty).getValue();
    }

    public void setUtsEthFlexQinQDestinationSTagProperty(Integer aUtsEthFlexQinQDestinationSTagProperty) {
        getProperty(utsEthFlexQinQDestinationSTagProperty).setValue(aUtsEthFlexQinQDestinationSTagProperty);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsEthFlexQinQDestinationSTPID));
        prepareRead(getProperty(utsEthFlexQinQDestinationSCosAction));
        prepareRead(getProperty(utsEthFlexQinQDestinationSVID));
        prepareRead(getProperty(utsEthFlexQinQDestinationCTPID));
        prepareRead(getProperty(utsEthFlexQinQDestinationCCosAction));
        prepareRead(getProperty(utsEthFlexQinQDestinationCVID));
        prepareRead(getProperty(utsEthFlexQinQDestinationAppointSCos));
        prepareRead(getProperty(utsEthFlexQinQDestinationAppointCCos));
        prepareRead(getProperty(utsEthFlexQinQDestinationTagMode));
        prepareRead(getProperty(utsEthFlexQinQDestinationSTagProperty));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsEthFlexQinQDestinationSTPID));
        prepareRead(getProperty(utsEthFlexQinQDestinationSCosAction));
        prepareRead(getProperty(utsEthFlexQinQDestinationSVID));
        prepareRead(getProperty(utsEthFlexQinQDestinationCTPID));
        prepareRead(getProperty(utsEthFlexQinQDestinationCCosAction));
        prepareRead(getProperty(utsEthFlexQinQDestinationCVID));
        prepareRead(getProperty(utsEthFlexQinQDestinationAppointSCos));
        prepareRead(getProperty(utsEthFlexQinQDestinationAppointCCos));
        prepareRead(getProperty(utsEthFlexQinQDestinationTagMode));
        prepareRead(getProperty(utsEthFlexQinQDestinationSTagProperty));

        return loadAll(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsEthFlexQinQSourceTagMode));
        prepareSave(getProperty(utsEthFlexQinQDestinationSTPID));
        prepareSave(getProperty(utsEthFlexQinQDestinationSCosAction));
        prepareSave(getProperty(utsEthFlexQinQDestinationSVID));
        prepareSave(getProperty(utsEthFlexQinQDestinationCTPID));
        prepareSave(getProperty(utsEthFlexQinQDestinationCCosAction));
        prepareSave(getProperty(utsEthFlexQinQDestinationCVID));
        prepareSave(getProperty(utsEthFlexQinQDestinationAppointSCos));
        prepareSave(getProperty(utsEthFlexQinQDestinationAppointCCos));
        prepareSave(getProperty(utsEthFlexQinQDestinationTagMode));
        prepareSave(getProperty(utsEthFlexQinQDestinationSTagProperty));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsEthFlexQinQSourceTagMode));
        prepareSave(getProperty(utsEthFlexQinQDestinationSTPID));
        prepareSave(getProperty(utsEthFlexQinQDestinationSCosAction));
        prepareSave(getProperty(utsEthFlexQinQDestinationSVID));
        prepareSave(getProperty(utsEthFlexQinQDestinationCTPID));
        prepareSave(getProperty(utsEthFlexQinQDestinationCCosAction));
        prepareSave(getProperty(utsEthFlexQinQDestinationCVID));
        prepareSave(getProperty(utsEthFlexQinQDestinationAppointSCos));
        prepareSave(getProperty(utsEthFlexQinQDestinationAppointCCos));
        prepareSave(getProperty(utsEthFlexQinQDestinationTagMode));
        prepareSave(getProperty(utsEthFlexQinQDestinationSTagProperty));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public String toString() {
        return "OLT Port " + getIndex(0) + "/" + getIndex(2);
    }

}
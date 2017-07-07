/**
 * Created by Zhou Chao, 2008/10/23
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuEthUniCfgMBean extends SnmpMibBean {

    public static final String onuEthUniCfgSlotNo = "onuEthUniCfgSlotNo";
    public static final String onuEthUniCfgPortNo = "onuEthUniCfgPortNo";
    public static final String onuEthUniCfgLogicalPortNo = "onuEthUniCfgLogicalPortNo";
    public static final String onuEthUniCfgPhysicalPortNo = "onuEthUniCfgPhysicalPortNo";
    public static final String onuEthUniCfgAdministrativeState = "onuEthUniCfgAdministrativeState";
    public static final String onuEthUniCfgOperationalState = "onuEthUniCfgOperationalState";
    public static final String onuEthUniCfgOnuVLANTranslationProfileIndex = "onuEthUniCfgOnuVLANTranslationProfileIndex";
    public static final String onuEthUniCfgOnuMulticastOperationProfileIndex = "onuEthUniCfgOnuMulticastOperationProfileIndex";
    public static final String onuEthUniCfgOnuStaticMulticastGroupsProfileIndex = "onuEthUniCfgOnuStaticMulticastGroupsProfileIndex";
    public static final String onuEthUniCfgEthernetUNIProfileIndex = "onuEthUniCfgEthernetUNIProfileIndex";
    public static final String onuEthUniCfgLoopback = "onuEthUniCfgLoopback";
    public static final String onuEthUniCfgSensedType = "onuEthUniCfgSensedType";
    public static final String onuEthUniCfgIndConfiguration = "onuEthUniCfgIndConfiguration";
    public static final String onuEthUniCfgOnuMACFilterProfileIndex = "onuEthUniCfgOnuMACFilterProfileIndex";
    public static final String onuEthUniCfgOnuMACFilterPreassignProfileIndex = "onuEthUniCfgOnuMACFilterPreassignProfileIndex";
    public static final String onuEthUniCfgmacLimit = "onuEthUniCfgmacLimit";
    public static final String onuEthUniCfgOnuVlanFilterProfileIndex = "onuEthUniCfgOnuVlanFilterProfileIndex";

    public GponOnuEthUniCfgMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuEthUniCfgSlotNo, new SnmpMibBeanProperty(onuEthUniCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.1", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgPortNo, new SnmpMibBeanProperty(onuEthUniCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.2", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgLogicalPortNo, new SnmpMibBeanProperty(onuEthUniCfgLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.3", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgPhysicalPortNo, new SnmpMibBeanProperty(onuEthUniCfgPhysicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.4", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgAdministrativeState, new SnmpMibBeanProperty(onuEthUniCfgAdministrativeState, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.5", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgOperationalState, new SnmpMibBeanProperty(onuEthUniCfgOperationalState, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.6", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgOnuVLANTranslationProfileIndex, new SnmpMibBeanProperty(onuEthUniCfgOnuVLANTranslationProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.7", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgOnuMulticastOperationProfileIndex, new SnmpMibBeanProperty(onuEthUniCfgOnuMulticastOperationProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.8", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgOnuStaticMulticastGroupsProfileIndex, new SnmpMibBeanProperty(onuEthUniCfgOnuStaticMulticastGroupsProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.9", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgEthernetUNIProfileIndex, new SnmpMibBeanProperty(onuEthUniCfgEthernetUNIProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.10", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgLoopback, new SnmpMibBeanProperty(onuEthUniCfgLoopback, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.11", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgSensedType, new SnmpMibBeanProperty(onuEthUniCfgSensedType, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.12", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgIndConfiguration, new SnmpMibBeanProperty(onuEthUniCfgIndConfiguration, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.13", ISnmpConstant.INTEGER));
        initProperty(onuEthUniCfgOnuMACFilterProfileIndex, new SnmpMibBeanProperty(onuEthUniCfgOnuMACFilterProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.14", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgOnuMACFilterPreassignProfileIndex, new SnmpMibBeanProperty(onuEthUniCfgOnuMACFilterPreassignProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.15", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgmacLimit, new SnmpMibBeanProperty(onuEthUniCfgmacLimit, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.16", ISnmpConstant.GAUGE));
        initProperty(onuEthUniCfgOnuVlanFilterProfileIndex, new SnmpMibBeanProperty(onuEthUniCfgOnuVlanFilterProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.18", ISnmpConstant.GAUGE));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.1.7.1.17", ISnmpConstant.INTEGER));
    }

    public Integer getOnuEthUniCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuEthUniCfgSlotNo(Integer aOnuEthUniCfgSlotNo) {
        setIndex(0, aOnuEthUniCfgSlotNo);
    }

    public Integer getOnuEthUniCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuEthUniCfgPortNo(Integer aOnuEthUniCfgPortNo) {
        setIndex(1, aOnuEthUniCfgPortNo);
    }

    public Integer getOnuEthUniCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuEthUniCfgLogicalPortNo(Integer aOnuEthUniCfgLogicalPortNo) {
        setIndex(2, aOnuEthUniCfgLogicalPortNo);
    }

    public Integer getOnuEthUniCfgPhysicalPortNo() {
        return (Integer) getIndex(3);
    }

    public void setOnuEthUniCfgPhysicalPortNo(Integer aOnuEthUniCfgPhysicalPortNo) {
        setIndex(3, aOnuEthUniCfgPhysicalPortNo);
    }

    public Integer getOnuEthUniCfgAdministrativeState() {
        return (Integer) getProperty(onuEthUniCfgAdministrativeState).getValue();
    }

    public void setOnuEthUniCfgAdministrativeState(Integer aOnuEthUniCfgAdministrativeState) {
        getProperty(onuEthUniCfgAdministrativeState).setValue(aOnuEthUniCfgAdministrativeState);
    }

    public Integer getOnuEthUniCfgOperationalState() {
        return (Integer) getProperty(onuEthUniCfgOperationalState).getValue();
    }

    public void setOnuEthUniCfgOperationalState(Integer aOnuEthUniCfgOperationalState) {
        getProperty(onuEthUniCfgOperationalState).setValue(aOnuEthUniCfgOperationalState);
    }

    public Long getOnuEthUniCfgOnuVLANTranslationProfileIndex() {
        return (Long) getProperty(onuEthUniCfgOnuVLANTranslationProfileIndex).getValue();
    }

    public void setOnuEthUniCfgOnuVLANTranslationProfileIndex(Long aOnuEthUniCfgOltVLANTranslationProfileIndex) {
        getProperty(onuEthUniCfgOnuVLANTranslationProfileIndex).setValue(aOnuEthUniCfgOltVLANTranslationProfileIndex);
    }

    public Long getOnuEthUniCfgOnuMulticastOperationProfileIndex() {
        return (Long) getProperty(onuEthUniCfgOnuMulticastOperationProfileIndex).getValue();
    }

    public void setOnuEthUniCfgOnuMulticastOperationProfileIndex(Long aOnuEthUniCfgOnuMulticastOperationProfileIndex) {
        getProperty(onuEthUniCfgOnuMulticastOperationProfileIndex).setValue(aOnuEthUniCfgOnuMulticastOperationProfileIndex);
    }

    public Long getOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex() {
        return (Long) getProperty(onuEthUniCfgOnuStaticMulticastGroupsProfileIndex).getValue();
    }

    public void setOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex(Long aOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex) {
        getProperty(onuEthUniCfgOnuStaticMulticastGroupsProfileIndex).setValue(aOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex);
    }

    public Long getOnuEthUniCfgEthernetUNIProfileIndex() {
        return (Long) getProperty(onuEthUniCfgEthernetUNIProfileIndex).getValue();
    }

    public void setOnuEthUniCfgEthernetUNIProfileIndex(Long aOnuEthUniCfgEthernetUNIProfileIndex) {
        getProperty(onuEthUniCfgEthernetUNIProfileIndex).setValue(aOnuEthUniCfgEthernetUNIProfileIndex);
    }

    public Integer getOnuEthUniCfgLoopback() {
        return (Integer) getProperty(onuEthUniCfgLoopback).getValue();
    }

    public void setOnuEthUniCfgLoopback(Integer aOnuEthUniCfgLoopback) {
        getProperty(onuEthUniCfgLoopback).setValue(aOnuEthUniCfgLoopback);
    }

    public Long getOnuEthUniCfgSensedType() {
        return (Long) getProperty(onuEthUniCfgSensedType).getValue();
    }

    public void setOnuEthUniCfgSensedType(Long aOnuEthUniCfgSensedType) {
        getProperty(onuEthUniCfgSensedType).setValue(aOnuEthUniCfgSensedType);
    }

    public Integer getOnuEthUniCfgIndConfiguration() {
        return (Integer) getProperty(onuEthUniCfgIndConfiguration).getValue();
    }

    public void setOnuEthUniCfgIndConfiguration(Integer aOnuEthUniCfgIndConfiguration) {
        getProperty(onuEthUniCfgIndConfiguration).setValue(aOnuEthUniCfgIndConfiguration);
    }

    public Long getOnuEthUniCfgOnuMACFilterProfileIndex() {
        return (Long) getProperty(onuEthUniCfgOnuMACFilterProfileIndex).getValue();
    }

    public void setOnuEthUniCfgOnuMACFilterProfileIndex(Long aOnuEthUniCfgOnuMACFilterProfileIndex) {
        getProperty(onuEthUniCfgOnuMACFilterProfileIndex).setValue(aOnuEthUniCfgOnuMACFilterProfileIndex);
    }

    public Long getOnuEthUniCfgOnuMACFilterPreassignProfileIndex() {
        return (Long) getProperty(onuEthUniCfgOnuMACFilterPreassignProfileIndex).getValue();
    }

    public void setOnuEthUniCfgOnuMACFilterPreassignProfileIndex(Long aOnuEthUniCfgOnuMACFilterPreassignProfileIndex) {
        getProperty(onuEthUniCfgOnuMACFilterPreassignProfileIndex).setValue(aOnuEthUniCfgOnuMACFilterPreassignProfileIndex);
    }

    public Long getOnuEthUniCfgmacLimit() {
        return (Long) getProperty(onuEthUniCfgmacLimit).getValue();
    }

    public void setOnuEthUniCfgmacLimit(Long aOnuEthUniCfgmacLimit) {
        getProperty(onuEthUniCfgmacLimit).setValue(aOnuEthUniCfgmacLimit);
    }

    public Long getOnuEthUniCfgOnuVlanFilterProfileIndex() {
        return (Long) getProperty(onuEthUniCfgOnuVlanFilterProfileIndex).getValue();
    }

    public void setOnuEthUniCfgOnuVlanFilterProfileIndex(Long aOnuEthUniCfgOnuVlanFilterProfileIndex) {
        getProperty(onuEthUniCfgOnuVlanFilterProfileIndex).setValue(aOnuEthUniCfgOnuVlanFilterProfileIndex);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuEthUniCfgAdministrativeState));
        prepareRead(getProperty(onuEthUniCfgOperationalState));
        prepareRead(getProperty(onuEthUniCfgOnuVLANTranslationProfileIndex));
        prepareRead(getProperty(onuEthUniCfgOnuMulticastOperationProfileIndex));
        prepareRead(getProperty(onuEthUniCfgOnuStaticMulticastGroupsProfileIndex));
        prepareRead(getProperty(onuEthUniCfgEthernetUNIProfileIndex));
        prepareRead(getProperty(onuEthUniCfgLoopback));
        prepareRead(getProperty(onuEthUniCfgSensedType));
        prepareRead(getProperty(onuEthUniCfgIndConfiguration));
        prepareRead(getProperty(onuEthUniCfgOnuMACFilterProfileIndex));
        prepareRead(getProperty(onuEthUniCfgOnuMACFilterPreassignProfileIndex));
        prepareRead(getProperty(onuEthUniCfgmacLimit));
        prepareRead(getProperty(onuEthUniCfgOnuVlanFilterProfileIndex));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuEthUniCfgAdministrativeState));
        prepareRead(getProperty(onuEthUniCfgOperationalState));
        prepareRead(getProperty(onuEthUniCfgOnuVLANTranslationProfileIndex));
        prepareRead(getProperty(onuEthUniCfgOnuMulticastOperationProfileIndex));
        prepareRead(getProperty(onuEthUniCfgOnuStaticMulticastGroupsProfileIndex));
        prepareRead(getProperty(onuEthUniCfgEthernetUNIProfileIndex));
        prepareRead(getProperty(onuEthUniCfgLoopback));
        prepareRead(getProperty(onuEthUniCfgSensedType));
        prepareRead(getProperty(onuEthUniCfgIndConfiguration));
        prepareRead(getProperty(onuEthUniCfgOnuMACFilterProfileIndex));
        prepareRead(getProperty(onuEthUniCfgOnuMACFilterPreassignProfileIndex));
        prepareRead(getProperty(onuEthUniCfgmacLimit));
        prepareRead(getProperty(onuEthUniCfgOnuVlanFilterProfileIndex));

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuEthUniCfgAdministrativeState));
        prepareSave(getProperty(onuEthUniCfgOnuVLANTranslationProfileIndex));
        prepareSave(getProperty(onuEthUniCfgOnuMulticastOperationProfileIndex));
        prepareSave(getProperty(onuEthUniCfgOnuStaticMulticastGroupsProfileIndex));
        prepareSave(getProperty(onuEthUniCfgEthernetUNIProfileIndex));
        prepareSave(getProperty(onuEthUniCfgLoopback));
        prepareSave(getProperty(onuEthUniCfgOnuMACFilterProfileIndex));
        prepareSave(getProperty(onuEthUniCfgOnuMACFilterPreassignProfileIndex));
        prepareSave(getProperty(onuEthUniCfgmacLimit));
        prepareSave(getProperty(onuEthUniCfgOnuVlanFilterProfileIndex));

        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuEthUniCfgAdministrativeState));
        prepareSave(getProperty(onuEthUniCfgOnuVLANTranslationProfileIndex));
        prepareSave(getProperty(onuEthUniCfgOnuMulticastOperationProfileIndex));
        prepareSave(getProperty(onuEthUniCfgOnuStaticMulticastGroupsProfileIndex));
        prepareSave(getProperty(onuEthUniCfgEthernetUNIProfileIndex));
        prepareSave(getProperty(onuEthUniCfgLoopback));
        prepareSave(getProperty(onuEthUniCfgOnuMACFilterProfileIndex));
        prepareSave(getProperty(onuEthUniCfgOnuMACFilterPreassignProfileIndex));
        prepareSave(getProperty(onuEthUniCfgmacLimit));
        prepareSave(getProperty(onuEthUniCfgOnuVlanFilterProfileIndex));

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
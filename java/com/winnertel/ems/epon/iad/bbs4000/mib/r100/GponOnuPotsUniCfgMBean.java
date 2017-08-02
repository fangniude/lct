/**
 * Created by Zhou Chao, 2008/12/2
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuPotsUniCfgMBean extends SnmpMibBean {

    public static final String onuPotsUniCfgSlotNo = "onuPotsUniCfgSlotNo";
    public static final String onuPotsUniCfgPortNo = "onuPotsUniCfgPortNo";
    public static final String onuPotsUniCfgLogicalPortNo = "onuPotsUniCfgLogicalPortNo";
    public static final String onuPotsUniCfgPhysicalPortNo = "onuPotsUniCfgPhysicalPortNo";
    public static final String onuPotsUniCfgAdministrativeState = "onuPotsUniCfgAdministrativeState";
    public static final String onuPotsUniCfgOperationalState = "onuPotsUniCfgOperationalState";
    public static final String onuPotsUniCfgOnuVoIPUserName = "onuPotsUniCfgOnuVoIPUserName";
    public static final String onuPotsUniCfgOnuVoIPPassword = "onuPotsUniCfgOnuVoIPPassword";
    public static final String onuPotsUniCfgOnuVoIPServiceProfileIndex = "onuPotsUniCfgOnuVoIPServiceProfileIndex";
    public static final String onuPotsUniCfgHookState = "onuPotsUniCfgHookState";

    public GponOnuPotsUniCfgMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuPotsUniCfgSlotNo, new SnmpMibBeanProperty(onuPotsUniCfgSlotNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.1", ISnmpConstant.INTEGER));
        initProperty(onuPotsUniCfgPortNo, new SnmpMibBeanProperty(onuPotsUniCfgPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.2", ISnmpConstant.INTEGER));
        initProperty(onuPotsUniCfgLogicalPortNo, new SnmpMibBeanProperty(onuPotsUniCfgLogicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.3", ISnmpConstant.INTEGER));
        initProperty(onuPotsUniCfgPhysicalPortNo, new SnmpMibBeanProperty(onuPotsUniCfgPhysicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.4", ISnmpConstant.INTEGER));
        initProperty(onuPotsUniCfgAdministrativeState, new SnmpMibBeanProperty(onuPotsUniCfgAdministrativeState, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.5", ISnmpConstant.INTEGER));
        initProperty(onuPotsUniCfgOperationalState, new SnmpMibBeanProperty(onuPotsUniCfgOperationalState, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.6", ISnmpConstant.INTEGER));
        initProperty(onuPotsUniCfgOnuVoIPUserName, new SnmpMibBeanProperty(onuPotsUniCfgOnuVoIPUserName, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.7", ISnmpConstant.STRING));
        initProperty(onuPotsUniCfgOnuVoIPPassword, new SnmpMibBeanProperty(onuPotsUniCfgOnuVoIPPassword, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.8", ISnmpConstant.STRING));
        initProperty(onuPotsUniCfgOnuVoIPServiceProfileIndex, new SnmpMibBeanProperty(onuPotsUniCfgOnuVoIPServiceProfileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.9", ISnmpConstant.GAUGE));
        initProperty(onuPotsUniCfgHookState, new SnmpMibBeanProperty(onuPotsUniCfgHookState, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.10", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.1.9.1.11", ISnmpConstant.INTEGER));
    }

    public Integer getOnuPotsUniCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuPotsUniCfgSlotNo(Integer aOnuPotsUniCfgSlotNo) {
        setIndex(0, aOnuPotsUniCfgSlotNo);
    }

    public Integer getOnuPotsUniCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuPotsUniCfgPortNo(Integer aOnuPotsUniCfgPortNo) {
        setIndex(1, aOnuPotsUniCfgPortNo);
    }

    public Integer getOnuPotsUniCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuPotsUniCfgLogicalPortNo(Integer aOnuPotsUniCfgLogicalPortNo) {
        setIndex(2, aOnuPotsUniCfgLogicalPortNo);
    }

    public Integer getOnuPotsUniCfgPhysicalPortNo() {
        return (Integer) getIndex(3);
    }

    public void setOnuPotsUniCfgPhysicalPortNo(Integer aOnuPotsUniCfgPhysicalPortNo) {
        setIndex(3, aOnuPotsUniCfgPhysicalPortNo);
    }

    public Integer getOnuPotsUniCfgAdministrativeState() {
        return (Integer) getProperty(onuPotsUniCfgAdministrativeState).getValue();
    }

    public void setOnuPotsUniCfgAdministrativeState(Integer aOnuPotsUniCfgAdministrativeState) {
        getProperty(onuPotsUniCfgAdministrativeState).setValue(aOnuPotsUniCfgAdministrativeState);
    }

    public Integer getOnuPotsUniCfgOperationalState() {
        return (Integer) getProperty(onuPotsUniCfgOperationalState).getValue();
    }

    public void setOnuPotsUniCfgOperationalState(Integer aOnuPotsUniCfgOperationalState) {
        getProperty(onuPotsUniCfgOperationalState).setValue(aOnuPotsUniCfgOperationalState);
    }

    public String getOnuPotsUniCfgOnuVoIPUserName() {
        return (String) getProperty(onuPotsUniCfgOnuVoIPUserName).getValue();
    }

    public void setOnuPotsUniCfgOnuVoIPUserName(String aOnuPotsUniCfgOnuVoIPUserName) {
        getProperty(onuPotsUniCfgOnuVoIPUserName).setValue(aOnuPotsUniCfgOnuVoIPUserName);
    }

    public String getOnuPotsUniCfgOnuVoIPPassword() {
        return (String) getProperty(onuPotsUniCfgOnuVoIPPassword).getValue();
    }

    public void setOnuPotsUniCfgOnuVoIPPassword(String aOnuPotsUniCfgOnuVoIPPassword) {
        getProperty(onuPotsUniCfgOnuVoIPPassword).setValue(aOnuPotsUniCfgOnuVoIPPassword);
    }

    public Long getOnuPotsUniCfgOnuVoIPServiceProfileIndex() {
        return (Long) getProperty(onuPotsUniCfgOnuVoIPServiceProfileIndex).getValue();
    }

    public void setOnuPotsUniCfgOnuVoIPServiceProfileIndex(Long aOnuPotsUniCfgOnuVoIPServiceProfileIndex) {
        getProperty(onuPotsUniCfgOnuVoIPServiceProfileIndex).setValue(aOnuPotsUniCfgOnuVoIPServiceProfileIndex);
    }

    public Integer getOnuPotsUniCfgHookState() {
        return (Integer) getProperty(onuPotsUniCfgHookState).getValue();
    }

    public void setOnuPotsUniCfgHookState(Integer aOnuPotsUniCfgHookState) {
        getProperty(onuPotsUniCfgHookState).setValue(aOnuPotsUniCfgHookState);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuPotsUniCfgAdministrativeState));
        prepareRead(getProperty(onuPotsUniCfgOperationalState));
        prepareRead(getProperty(onuPotsUniCfgOnuVoIPUserName));
        prepareRead(getProperty(onuPotsUniCfgOnuVoIPPassword));
        prepareRead(getProperty(onuPotsUniCfgOnuVoIPServiceProfileIndex));
        prepareRead(getProperty(onuPotsUniCfgHookState));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuPotsUniCfgAdministrativeState));
        prepareRead(getProperty(onuPotsUniCfgOperationalState));
        prepareRead(getProperty(onuPotsUniCfgOnuVoIPUserName));
        prepareRead(getProperty(onuPotsUniCfgOnuVoIPPassword));
        prepareRead(getProperty(onuPotsUniCfgOnuVoIPServiceProfileIndex));
        prepareRead(getProperty(onuPotsUniCfgHookState));

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuPotsUniCfgAdministrativeState));
        prepareSave(getProperty(onuPotsUniCfgOnuVoIPUserName));
        prepareSave(getProperty(onuPotsUniCfgOnuVoIPPassword));
        prepareSave(getProperty(onuPotsUniCfgOnuVoIPServiceProfileIndex));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuPotsUniCfgAdministrativeState));
        prepareSave(getProperty(onuPotsUniCfgOnuVoIPUserName));
        prepareSave(getProperty(onuPotsUniCfgOnuVoIPPassword));
        prepareSave(getProperty(onuPotsUniCfgOnuVoIPServiceProfileIndex));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}
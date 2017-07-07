/**
 * Created by Zhou Chao, 2008/10/01
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuVirtualPortConfigureMBean extends SnmpMibBean {

    public static final String onuVirtualPortCfgSlotNo = "onuVirtualPortCfgSlotNo";
    public static final String onuVirtualPortCfgPortNo = "onuVirtualPortCfgPortNo";
    public static final String onuVirtualPortCfgLogicalPortNo = "onuVirtualPortCfgLogicalPortNo";
    public static final String onuVirtualPortCfgVirtualPortNo = "onuVirtualPortCfgVirtualPortNo";
    public static final String onuVirtualPortCfgAdministrativeState = "onuVirtualPortCfgAdministrativeState";
    public static final String onuVirtualPortCfgOperationalState = "onuVirtualPortCfgOperationalState";
    public static final String onuVirtualPortCfgTcontIndex = "onuVirtualPortCfgTcontIndex";
    //public static final String onuVirtualPortCfgMacLimit = "onuVirtualPortCfgMacLimit";
    public static final String onuVirtualPortCfgoltVLANTranslationProfileIndex = "onuVirtualPortCfgoltVLANTranslationProfileIndex";
    public static final String onuVirtualPortCfgOltGEMPortNo = "onuVirtualPortCfgOltGEMPortNo";
    public static final String onuVirtualPortCfgOltAllocID = "onuVirtualPortCfgOltAllocID";
    public static final String onuVirtualPortCfgOnuMACFilterProfileIndex = "onuVirtualPortCfgOnuMACFilterProfileIndex";
    public static final String onuVirtualPortCfgOnuMACFilterPreassignProfileIndex = "onuVirtualPortCfgOnuMACFilterPreassignProfileIndex";
    //public static final String onuVirtualPortCfgOnuVlanFilterProfileIndex = "onuVirtualPortCfgOnuVlanFilterProfileIndex"; //(Reserved)

    public GponOnuVirtualPortConfigureMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVirtualPortCfgSlotNo, new SnmpMibBeanProperty(onuVirtualPortCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.1", ISnmpConstant.INTEGER));
        initProperty(onuVirtualPortCfgPortNo, new SnmpMibBeanProperty(onuVirtualPortCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.2", ISnmpConstant.INTEGER));
        initProperty(onuVirtualPortCfgLogicalPortNo, new SnmpMibBeanProperty(onuVirtualPortCfgLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.3", ISnmpConstant.INTEGER));
        initProperty(onuVirtualPortCfgVirtualPortNo, new SnmpMibBeanProperty(onuVirtualPortCfgVirtualPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.4", ISnmpConstant.INTEGER));
        initProperty(onuVirtualPortCfgAdministrativeState, new SnmpMibBeanProperty(onuVirtualPortCfgAdministrativeState, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.5", ISnmpConstant.INTEGER));
        initProperty(onuVirtualPortCfgOperationalState, new SnmpMibBeanProperty(onuVirtualPortCfgOperationalState, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.6", ISnmpConstant.INTEGER));
        initProperty(onuVirtualPortCfgTcontIndex, new SnmpMibBeanProperty(onuVirtualPortCfgTcontIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.7", ISnmpConstant.GAUGE));
        //initProperty(onuVirtualPortCfgMacLimit, new SnmpMibBeanProperty(onuVirtualPortCfgMacLimit, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.8", ISnmpConstant.GAUGE));
        initProperty(onuVirtualPortCfgoltVLANTranslationProfileIndex, new SnmpMibBeanProperty(onuVirtualPortCfgoltVLANTranslationProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.8", ISnmpConstant.GAUGE));
        initProperty(onuVirtualPortCfgOltGEMPortNo, new SnmpMibBeanProperty(onuVirtualPortCfgOltGEMPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.9", ISnmpConstant.GAUGE));
        initProperty(onuVirtualPortCfgOltAllocID, new SnmpMibBeanProperty(onuVirtualPortCfgOltAllocID, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.10", ISnmpConstant.GAUGE));
        initProperty(onuVirtualPortCfgOnuMACFilterProfileIndex, new SnmpMibBeanProperty(onuVirtualPortCfgOnuMACFilterProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.11", ISnmpConstant.GAUGE));
        initProperty(onuVirtualPortCfgOnuMACFilterPreassignProfileIndex, new SnmpMibBeanProperty(onuVirtualPortCfgOnuMACFilterPreassignProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.12", ISnmpConstant.GAUGE));
        //initProperty(onuVirtualPortCfgOnuVlanFilterProfileIndex, new SnmpMibBeanProperty(onuVirtualPortCfgOnuVlanFilterProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.14", ISnmpConstant.GAUGE)); //(Reserved)

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.1.6.1.13", ISnmpConstant.INTEGER));
    }

    public Integer getOnuVirtualPortCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuVirtualPortCfgSlotNo(Integer aOnuVirtualPortCfgSlotNo) {
        setIndex(0, aOnuVirtualPortCfgSlotNo);
    }

    public Integer getOnuVirtualPortCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuVirtualPortCfgPortNo(Integer aOnuVirtualPortCfgPortNo) {
        setIndex(1, aOnuVirtualPortCfgPortNo);
    }

    public Integer getOnuVirtualPortCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuVirtualPortCfgLogicalPortNo(Integer aOnuVirtualPortCfgLogicalPortNo) {
        setIndex(2, aOnuVirtualPortCfgLogicalPortNo);
    }

    public Integer getOnuVirtualPortCfgVirtualPortNo() {
        return (Integer) getIndex(3);
    }

    public void setOnuVirtualPortCfgVirtualPortNo(Integer aOnuVirtualPortCfgVirtualPortNo) {
        setIndex(3, aOnuVirtualPortCfgVirtualPortNo);
    }

    public Integer getOnuVirtualPortCfgAdministrativeState() {
        return (Integer) getProperty(onuVirtualPortCfgAdministrativeState).getValue();
    }

    public void setOnuVirtualPortCfgAdministrativeState(Integer aOnuVirtualPortCfgAdministrativeState) {
        getProperty(onuVirtualPortCfgAdministrativeState).setValue(aOnuVirtualPortCfgAdministrativeState);
    }

    public Integer getOnuVirtualPortCfgOperationalState() {
        return (Integer) getProperty(onuVirtualPortCfgOperationalState).getValue();
    }

    public void setOnuVirtualPortCfgOperationalState(Integer aOnuVirtualPortCfgOperationalState) {
        getProperty(onuVirtualPortCfgOperationalState).setValue(aOnuVirtualPortCfgOperationalState);
    }

    public Long getOnuVirtualPortCfgTcontIndex() {
        return (Long) getProperty(onuVirtualPortCfgTcontIndex).getValue();
    }

    public void setOnuVirtualPortCfgTcontIndex(Long aOnuVirtualPortCfgTcontIndex) {
        getProperty(onuVirtualPortCfgTcontIndex).setValue(aOnuVirtualPortCfgTcontIndex);
    }

    /*
    public Integer getOnuVirtualPortCfgMacLimit() {
        return (Integer) getProperty(onuVirtualPortCfgMacLimit).getValue();
    }

    public void setOnuVirtualPortCfgMacLimit(Integer aOnuVirtualPortCfgMacLimit) {
        getProperty(onuVirtualPortCfgMacLimit).setValue(aOnuVirtualPortCfgMacLimit);
    }
    */

    public Long getOnuVirtualPortCfgoltVLANTranslationProfileIndex() {
        return (Long) getProperty(onuVirtualPortCfgoltVLANTranslationProfileIndex).getValue();
    }

    public void setOnuVirtualPortCfgoltVLANTranslationProfileIndex(Long aOnuVirtualPortCfgoltVLANTranslationProfileIndex) {
        getProperty(onuVirtualPortCfgoltVLANTranslationProfileIndex).setValue(aOnuVirtualPortCfgoltVLANTranslationProfileIndex);
    }

    public Long getOnuVirtualPortCfgOltGEMPortNo() {
        return (Long) getProperty(onuVirtualPortCfgOltGEMPortNo).getValue();
    }

    public void setOnuVirtualPortCfgOltGEMPortNo(Long aOnuVirtualPortCfgOltGEMPortNo) {
        getProperty(onuVirtualPortCfgOltGEMPortNo).setValue(aOnuVirtualPortCfgOltGEMPortNo);
    }

    public Long getOnuVirtualPortCfgOltAllocID() {
        return (Long) getProperty(onuVirtualPortCfgOltAllocID).getValue();
    }

    public void setOnuVirtualPortCfgOltAllocID(Long aOnuVirtualPortCfgOltAllocID) {
        getProperty(onuVirtualPortCfgOltAllocID).setValue(aOnuVirtualPortCfgOltAllocID);
    }

    public Long getOnuVirtualPortCfgOnuMACFilterProfileIndex() {
        return (Long) getProperty(onuVirtualPortCfgOnuMACFilterProfileIndex).getValue();
    }

    public void setOnuVirtualPortCfgOnuMACFilterProfileIndex(Long aOnuVirtualPortCfgOnuMACFilterProfileIndex) {
        getProperty(onuVirtualPortCfgOnuMACFilterProfileIndex).setValue(aOnuVirtualPortCfgOnuMACFilterProfileIndex);
    }

    public Long getOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex() {
        return (Long) getProperty(onuVirtualPortCfgOnuMACFilterPreassignProfileIndex).getValue();
    }

    public void setOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex(Long aOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex) {
        getProperty(onuVirtualPortCfgOnuMACFilterPreassignProfileIndex).setValue(aOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex);
    }

    /* (Reserved)
    public Long getOnuVirtualPortCfgOnuVlanFilterProfileIndex() {
        return (Long) getProperty(onuVirtualPortCfgOnuVlanFilterProfileIndex).getValue();
    }

    public void setOnuVirtualPortCfgOnuVlanFilterProfileIndex(Long aOnuVirtualPortCfgOnuVlanFilterProfileIndex) {
        getProperty(onuVirtualPortCfgOnuVlanFilterProfileIndex).setValue(aOnuVirtualPortCfgOnuVlanFilterProfileIndex);
    }
    */

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuVirtualPortCfgAdministrativeState));
        prepareRead(getProperty(onuVirtualPortCfgOperationalState));
        prepareRead(getProperty(onuVirtualPortCfgTcontIndex));
        //prepareRead(getProperty(onuVirtualPortCfgMacLimit));
        prepareRead(getProperty(onuVirtualPortCfgoltVLANTranslationProfileIndex));
        prepareRead(getProperty(onuVirtualPortCfgOltGEMPortNo));
        prepareRead(getProperty(onuVirtualPortCfgOltAllocID));
        prepareRead(getProperty(onuVirtualPortCfgOnuMACFilterProfileIndex));
        prepareRead(getProperty(onuVirtualPortCfgOnuMACFilterPreassignProfileIndex));
        //prepareRead(getProperty(onuVirtualPortCfgOnuVlanFilterProfileIndex)); //(Reserved)

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuVirtualPortCfgAdministrativeState));
        prepareRead(getProperty(onuVirtualPortCfgOperationalState));
        prepareRead(getProperty(onuVirtualPortCfgTcontIndex));
        //prepareRead(getProperty(onuVirtualPortCfgMacLimit));
        prepareRead(getProperty(onuVirtualPortCfgoltVLANTranslationProfileIndex));
        prepareRead(getProperty(onuVirtualPortCfgOltGEMPortNo));
        prepareRead(getProperty(onuVirtualPortCfgOltAllocID));
        prepareRead(getProperty(onuVirtualPortCfgOnuMACFilterProfileIndex));
        prepareRead(getProperty(onuVirtualPortCfgOnuMACFilterPreassignProfileIndex));
        //prepareRead(getProperty(onuVirtualPortCfgOnuVlanFilterProfileIndex)); //(Reserved)

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuVirtualPortCfgAdministrativeState));
        //prepareSave(getProperty(onuVirtualPortCfgMacLimit));
        prepareSave(getProperty(onuVirtualPortCfgoltVLANTranslationProfileIndex));
        prepareSave(getProperty(onuVirtualPortCfgOnuMACFilterProfileIndex));
        prepareSave(getProperty(onuVirtualPortCfgOnuMACFilterPreassignProfileIndex));
        //prepareSave(getProperty(onuVirtualPortCfgOnuVlanFilterProfileIndex)); //(Reserved)

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuVirtualPortCfgAdministrativeState));
        //prepareSave(getProperty(onuVirtualPortCfgMacLimit));
        prepareSave(getProperty(onuVirtualPortCfgoltVLANTranslationProfileIndex));
        prepareSave(getProperty(onuVirtualPortCfgOnuMACFilterProfileIndex));
        prepareSave(getProperty(onuVirtualPortCfgOnuMACFilterPreassignProfileIndex));
        //prepareSave(getProperty(onuVirtualPortCfgOnuVlanFilterProfileIndex)); //(Reserved)

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
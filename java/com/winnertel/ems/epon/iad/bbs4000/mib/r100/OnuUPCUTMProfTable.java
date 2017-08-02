package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

/**
 * The OnuUPCUTMProfTable class.
 * Created by QuickDVM
 */
public class OnuUPCUTMProfTable extends SnmpMibBean {

    public static final String onuUsrPortCoSUpTrafficMapProfIndex1 = "onuUsrPortCoSUpTrafficMapProfIndex1";
    public static final String onuUsrPortCoSUpTrafficMapProfIndex2 = "onuUsrPortCoSUpTrafficMapProfIndex2";
    public static final String onuUsrPortCoSUpTrafficMapProfileName = "onuUsrPortCoSUpTrafficMapProfileName";
    public static final String cosSelection = "cosSelection";
    public static final String onuUsrPortCoSUpTrafficMapProfPhysicalPortType = "onuUsrPortCoSUpTrafficMapProfPhysicalPortType";
    public static final String onuUsrPortCoSUpTrafficMapProfPhysicalPortNo = "onuUsrPortCoSUpTrafficMapProfPhysicalPortNo";
    public static final String onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap = "onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap";
    public static final String dscpBitMap = "dscpBitMap";
    public static final String onuUsrPortCoSUpTrafficMapProfVirtualPortNo = "onuUsrPortCoSUpTrafficMapProfVirtualPortNo";

    public OnuUPCUTMProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuUsrPortCoSUpTrafficMapProfIndex1, new SnmpMibBeanProperty(onuUsrPortCoSUpTrafficMapProfIndex1, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.1", ISnmpConstant.GAUGE));
        initProperty(onuUsrPortCoSUpTrafficMapProfIndex2, new SnmpMibBeanProperty(onuUsrPortCoSUpTrafficMapProfIndex2, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.2", ISnmpConstant.GAUGE));
        initProperty(onuUsrPortCoSUpTrafficMapProfileName, new SnmpMibBeanProperty(onuUsrPortCoSUpTrafficMapProfileName, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.3", ISnmpConstant.STRING));
        initProperty(cosSelection, new SnmpMibBeanProperty(cosSelection, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.4", ISnmpConstant.INTEGER));
        initProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortType, new SnmpMibBeanProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortType, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.5", ISnmpConstant.GAUGE));
        initProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo, new SnmpMibBeanProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.6", ISnmpConstant.INTEGER));
        initProperty(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap, new SnmpMibBeanProperty(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.7", ISnmpConstant.GAUGE));
        initProperty(dscpBitMap, new SnmpMibBeanProperty(dscpBitMap, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.8", ISnmpConstant.COUNTER64));
        initProperty(onuUsrPortCoSUpTrafficMapProfVirtualPortNo, new SnmpMibBeanProperty(onuUsrPortCoSUpTrafficMapProfVirtualPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.9", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.2.10.1.10", ISnmpConstant.INTEGER));
    }

    public Long getOnuUsrPortCoSUpTrafficMapProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOnuUsrPortCoSUpTrafficMapProfIndex1(Long aOnuUsrPortCoSUpTrafficMapProfIndex1) {
        setIndex(0, aOnuUsrPortCoSUpTrafficMapProfIndex1);
    }

    public Long getOnuUsrPortCoSUpTrafficMapProfIndex2() {
        return (Long) getIndex(1);
    }

    public void setOnuUsrPortCoSUpTrafficMapProfIndex2(Long aOnuUsrPortCoSUpTrafficMapProfIndex2) {
        setIndex(1, aOnuUsrPortCoSUpTrafficMapProfIndex2);
    }

    public String getOnuUsrPortCoSUpTrafficMapProfileName() {
        return (String) getProperty(onuUsrPortCoSUpTrafficMapProfileName).getValue();
    }

    public void setOnuUsrPortCoSUpTrafficMapProfileName(String aOnuUsrPortCoSUpTrafficMapProfileName) {
        getProperty(onuUsrPortCoSUpTrafficMapProfileName).setValue(aOnuUsrPortCoSUpTrafficMapProfileName);
    }

    public Integer getCosSelection() {
        return (Integer) getProperty(cosSelection).getValue();
    }

    public void setCosSelection(Integer aCosSelection) {
        getProperty(cosSelection).setValue(aCosSelection);
    }

    public Long getOnuUsrPortCoSUpTrafficMapProfPhysicalPortType() {
        return (Long) getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortType).getValue();
    }

    public void setOnuUsrPortCoSUpTrafficMapProfPhysicalPortType(Long aOnuUsrPortCoSUpTrafficMapProfPhysicalPortType) {
        getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortType).setValue(aOnuUsrPortCoSUpTrafficMapProfPhysicalPortType);
    }

    public Integer getOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo() {
        return (Integer) getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo).getValue();
    }

    public void setOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo(Integer aOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo) {
        getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo).setValue(aOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo);
    }

    public Long getOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap() {
        return (Long) getProperty(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap).getValue();
    }

    public void setOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap(Long aOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap) {
        getProperty(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap).setValue(aOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap);
    }

    public BigInteger getDscpBitMap() {
        return (BigInteger) getProperty(dscpBitMap).getValue();
    }

    public void setDscpBitMap(BigInteger aDscpBitMap) {
        getProperty(dscpBitMap).setValue(aDscpBitMap);
    }

    public Integer getOnuUsrPortCoSUpTrafficMapProfVirtualPortNo() {
        return (Integer) getProperty(onuUsrPortCoSUpTrafficMapProfVirtualPortNo).getValue();
    }

    public void setOnuUsrPortCoSUpTrafficMapProfVirtualPortNo(Integer aOnuUsrPortCoSUpTrafficMapProfVirtualPortNo) {
        getProperty(onuUsrPortCoSUpTrafficMapProfVirtualPortNo).setValue(aOnuUsrPortCoSUpTrafficMapProfVirtualPortNo);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfileName));
        prepareRead(super.getProperty(cosSelection));
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortType));
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo));
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap));
        prepareRead(super.getProperty(dscpBitMap));
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfVirtualPortNo));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfileName));
        prepareRead(super.getProperty(cosSelection));
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortType));
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo));
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap));
        prepareRead(super.getProperty(dscpBitMap));
        prepareRead(super.getProperty(onuUsrPortCoSUpTrafficMapProfVirtualPortNo));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfileName));
        prepareSave(getProperty(cosSelection));
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortType));
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo));
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap));
        prepareSave(getProperty(dscpBitMap));
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfVirtualPortNo));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfileName));
        prepareSave(getProperty(cosSelection));
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortType));
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo));
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap));
        prepareSave(getProperty(dscpBitMap));
        prepareSave(getProperty(onuUsrPortCoSUpTrafficMapProfVirtualPortNo));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    //added by Zhou Chao, 2009/2/13
    public String toString() {
        return getOnuUsrPortCoSUpTrafficMapProfileName();
    }

}
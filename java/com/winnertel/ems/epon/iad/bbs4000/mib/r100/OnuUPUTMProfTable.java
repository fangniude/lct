package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuUPUTMProfTable class.
 * Created by Yang Yizai
 */
public class OnuUPUTMProfTable extends SnmpMibBean {

    public static final String onuUsrPortUpTrafficMapProfIndex1 = "onuUsrPortUpTrafficMapProfIndex1";
    public static final String onuUsrPortUpTrafficMapProfIndex2 = "onuUsrPortUpTrafficMapProfIndex2";
    public static final String onuUsrPortUpTrafficMapProfileName = "onuUsrPortUpTrafficMapProfileName";
    public static final String onuUsrPortUpTrafficMapProfPhysicalPortType = "onuUsrPortUpTrafficMapProfPhysicalPortType";
    public static final String onuUsrPortUpTrafficMapProfPhysicalPortNo = "onuUsrPortUpTrafficMapProfPhysicalPortNo";
    public static final String onuUsrPortUpTrafficMapProfVirtualPortNo = "onuUsrPortUpTrafficMapProfVirtualPortNo";

    public OnuUPUTMProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuUsrPortUpTrafficMapProfIndex1, new SnmpMibBeanProperty(onuUsrPortUpTrafficMapProfIndex1, ".1.3.6.1.4.1.41355.1.3.10.5.2.6.1.1", ISnmpConstant.GAUGE));
        initProperty(onuUsrPortUpTrafficMapProfIndex2, new SnmpMibBeanProperty(onuUsrPortUpTrafficMapProfIndex2, ".1.3.6.1.4.1.41355.1.3.10.5.2.6.1.2", ISnmpConstant.GAUGE));
        initProperty(onuUsrPortUpTrafficMapProfileName, new SnmpMibBeanProperty(onuUsrPortUpTrafficMapProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.6.1.3", ISnmpConstant.STRING));
        initProperty(onuUsrPortUpTrafficMapProfPhysicalPortType, new SnmpMibBeanProperty(onuUsrPortUpTrafficMapProfPhysicalPortType, ".1.3.6.1.4.1.41355.1.3.10.5.2.6.1.4", ISnmpConstant.INTEGER));
        initProperty(onuUsrPortUpTrafficMapProfPhysicalPortNo, new SnmpMibBeanProperty(onuUsrPortUpTrafficMapProfPhysicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.2.6.1.5", ISnmpConstant.INTEGER));
        initProperty(onuUsrPortUpTrafficMapProfVirtualPortNo, new SnmpMibBeanProperty(onuUsrPortUpTrafficMapProfVirtualPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.2.6.1.6", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.6.1.7", ISnmpConstant.INTEGER));
    }

    public Long getOnuUsrPortUpTrafficMapProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOnuUsrPortUpTrafficMapProfIndex1(Long aOnuUsrPortUpTrafficMapProfIndex1) {
        setIndex(0, aOnuUsrPortUpTrafficMapProfIndex1);
    }

    public Long getOnuUsrPortUpTrafficMapProfIndex2() {
        return (Long) getIndex(1);
    }

    public void setOnuUsrPortUpTrafficMapProfIndex2(Long aOnuUsrPortUpTrafficMapProfIndex2) {
        setIndex(1, aOnuUsrPortUpTrafficMapProfIndex2);
    }

    public String getOnuUsrPortUpTrafficMapProfileName() {
        return (String) getProperty(onuUsrPortUpTrafficMapProfileName).getValue();
    }

    public void setOnuUsrPortUpTrafficMapProfileName(String aOnuUsrPortUpTrafficMapProfileName) {
        getProperty(onuUsrPortUpTrafficMapProfileName).setValue(aOnuUsrPortUpTrafficMapProfileName);

    }

    public Integer getOnuUsrPortUpTrafficMapProfPhysicalPortType() {
        return (Integer) getProperty(onuUsrPortUpTrafficMapProfPhysicalPortType).getValue();
    }

    public void setOnuUsrPortUpTrafficMapProfPhysicalPortType(Integer aOnuUsrPortUpTrafficMapProfPhysicalPortType) {
        getProperty(onuUsrPortUpTrafficMapProfPhysicalPortType).setValue(aOnuUsrPortUpTrafficMapProfPhysicalPortType);
    }

    public Integer getOnuUsrPortUpTrafficMapProfPhysicalPortNo() {
        return (Integer) getProperty(onuUsrPortUpTrafficMapProfPhysicalPortNo).getValue();
    }

    public void setOnuUsrPortUpTrafficMapProfPhysicalPortNo(Integer aOnuUsrPortUpTrafficMapProfPhysicalPortNo) {
        getProperty(onuUsrPortUpTrafficMapProfPhysicalPortNo).setValue(aOnuUsrPortUpTrafficMapProfPhysicalPortNo);
    }

    public Integer getOnuUsrPortUpTrafficMapProfVirtualPortNo() {
        return (Integer) getProperty(onuUsrPortUpTrafficMapProfVirtualPortNo).getValue();
    }

    public void setOnuUsrPortUpTrafficMapProfVirtualPortNo(Integer aOnuUsrPortUpTrafficMapProfVirtualPortNo) {
        getProperty(onuUsrPortUpTrafficMapProfVirtualPortNo).setValue(aOnuUsrPortUpTrafficMapProfVirtualPortNo);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuUsrPortUpTrafficMapProfileName));
        prepareRead(super.getProperty(onuUsrPortUpTrafficMapProfPhysicalPortType));
        prepareRead(super.getProperty(onuUsrPortUpTrafficMapProfPhysicalPortNo));
        prepareRead(super.getProperty(onuUsrPortUpTrafficMapProfVirtualPortNo));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuUsrPortUpTrafficMapProfileName));
        prepareRead(super.getProperty(onuUsrPortUpTrafficMapProfPhysicalPortType));
        prepareRead(super.getProperty(onuUsrPortUpTrafficMapProfPhysicalPortNo));
        prepareRead(super.getProperty(onuUsrPortUpTrafficMapProfVirtualPortNo));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuUsrPortUpTrafficMapProfileName));
        prepareSave(getProperty(onuUsrPortUpTrafficMapProfPhysicalPortType));
        prepareSave(getProperty(onuUsrPortUpTrafficMapProfPhysicalPortNo));
        prepareSave(getProperty(onuUsrPortUpTrafficMapProfVirtualPortNo));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuUsrPortUpTrafficMapProfileName));
        prepareSave(getProperty(onuUsrPortUpTrafficMapProfPhysicalPortType));
        prepareSave(getProperty(onuUsrPortUpTrafficMapProfPhysicalPortNo));
        prepareSave(getProperty(onuUsrPortUpTrafficMapProfVirtualPortNo));

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
        return getOnuUsrPortUpTrafficMapProfileName();
    }

}
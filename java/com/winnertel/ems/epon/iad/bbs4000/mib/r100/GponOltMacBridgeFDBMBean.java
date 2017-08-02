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

public class GponOltMacBridgeFDBMBean extends SnmpMibBean {

    public static final String oltMacBridgeFDBSlotNo = "oltMacBridgeFDBSlotNo";
    public static final String oltMacBridgeFDBPortNo = "oltMacBridgeFDBPortNo";
    public static final String oltMacBridgeFDBLogicalPortNo = "oltMacBridgeFDBLogicalPortNo";
    public static final String oltMacBridgeFDBVirtualPortNo = "oltMacBridgeFDBVirtualPortNo";
    public static final String oltMacBridgeFDBMacAddress = "oltMacBridgeFDBMacAddress";
    public static final String oltMacBridgeFDBVlanID = "oltMacBridgeFDBVlanID";
    public static final String oltMacBridgeFDoltGEMPortNo = "oltMacBridgeFDoltGEMPortNo";
    public static final String oltMacBridgeFDBdynamicStatic = "oltMacBridgeFDBdynamicStatic";
    public static final String oltMacBridgeFDBage = "oltMacBridgeFDBage";

    public GponOltMacBridgeFDBMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltMacBridgeFDBSlotNo, new SnmpMibBeanProperty(oltMacBridgeFDBSlotNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.1", ISnmpConstant.INTEGER));
        initProperty(oltMacBridgeFDBPortNo, new SnmpMibBeanProperty(oltMacBridgeFDBPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.2", ISnmpConstant.INTEGER));
        initProperty(oltMacBridgeFDBLogicalPortNo, new SnmpMibBeanProperty(oltMacBridgeFDBLogicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.3", ISnmpConstant.INTEGER));
        initProperty(oltMacBridgeFDBVirtualPortNo, new SnmpMibBeanProperty(oltMacBridgeFDBVirtualPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.4", ISnmpConstant.INTEGER));
        initProperty(oltMacBridgeFDBMacAddress, new SnmpMibBeanProperty(oltMacBridgeFDBMacAddress, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.5", ISnmpConstant.STRING));
        initProperty(oltMacBridgeFDBVlanID, new SnmpMibBeanProperty(oltMacBridgeFDBVlanID, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.6", ISnmpConstant.INTEGER));
        initProperty(oltMacBridgeFDoltGEMPortNo, new SnmpMibBeanProperty(oltMacBridgeFDoltGEMPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.7", ISnmpConstant.INTEGER));
        initProperty(oltMacBridgeFDBdynamicStatic, new SnmpMibBeanProperty(oltMacBridgeFDBdynamicStatic, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.8", ISnmpConstant.INTEGER));
        initProperty(oltMacBridgeFDBage, new SnmpMibBeanProperty(oltMacBridgeFDBage, ".1.3.6.1.4.1.45121.1.3.10.5.2.13.1.9", ISnmpConstant.INTEGER));
    }

    public Integer getOltMacBridgeFDBSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOltMacBridgeFDBSlotNo(Integer aOltMacBridgeFDBSlotNo) {
        setIndex(0, aOltMacBridgeFDBSlotNo);
    }

    public Integer getOltMacBridgeFDBPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOltMacBridgeFDBPortNo(Integer aOltMacBridgeFDBPortNo) {
        setIndex(1, aOltMacBridgeFDBPortNo);
    }

    public Integer getOltMacBridgeFDBLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOltMacBridgeFDBLogicalPortNo(Integer aOltMacBridgeFDBLogicalPortNo) {
        setIndex(2, aOltMacBridgeFDBLogicalPortNo);
    }

    public Integer getOltMacBridgeFDBVirtualPortNo() {
        return (Integer) getIndex(3);
    }

    public void setOltMacBridgeFDBVirtualPortNo(Integer aOltMacBridgeFDBVirtualPortNo) {
        setIndex(3, aOltMacBridgeFDBVirtualPortNo);
    }

    public String getOltMacBridgeFDBMacAddress() {
        return (String) getIndex(4);
    }

    public void setOltMacBridgeFDBMacAddress(String aOltMacBridgeFDBMacAddress) {
        setIndex(4, aOltMacBridgeFDBMacAddress);
    }

    public Integer getOltMacBridgeFDBVlanID() {
        return (Integer) getIndex(5);
    }

    public void setOltMacBridgeFDBVlanID(Integer aOltMacBridgeFDBVlanID) {
        setIndex(5, aOltMacBridgeFDBVlanID);
    }

    public Integer getOltMacBridgeFDoltGEMPortNo() {
        return (Integer) getProperty(oltMacBridgeFDoltGEMPortNo).getValue();
    }

    public void setOltMacBridgeFDoltGEMPortNo(Integer aOltMacBridgeFDoltGEMPortNo) {
        getProperty(oltMacBridgeFDoltGEMPortNo).setValue(aOltMacBridgeFDoltGEMPortNo);
    }

    public Integer getOltMacBridgeFDBdynamicStatic() {
        return (Integer) getProperty(oltMacBridgeFDBdynamicStatic).getValue();
    }

    public void setOltMacBridgeFDBdynamicStatic(Integer aOltMacBridgeFDBdynamicStatic) {
        getProperty(oltMacBridgeFDBdynamicStatic).setValue(aOltMacBridgeFDBdynamicStatic);
    }

    public Integer getOltMacBridgeFDBage() {
        return (Integer) getProperty(oltMacBridgeFDBage).getValue();
    }

    public void setOltMacBridgeFDBage(Integer aOltMacBridgeFDBage) {
        getProperty(oltMacBridgeFDBage).setValue(aOltMacBridgeFDBage);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(oltMacBridgeFDoltGEMPortNo));
        prepareRead(getProperty(oltMacBridgeFDBdynamicStatic));
        prepareRead(getProperty(oltMacBridgeFDBage));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(oltMacBridgeFDoltGEMPortNo));
        prepareRead(getProperty(oltMacBridgeFDBdynamicStatic));
        prepareRead(getProperty(oltMacBridgeFDBage));

        return loadAll(new int[]{1, 1, 1, 1, 32, 1});
    }

}
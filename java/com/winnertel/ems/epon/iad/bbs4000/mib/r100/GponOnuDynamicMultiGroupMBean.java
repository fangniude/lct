package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuDynamicMultiGroupMBean extends SnmpMibBean {

    public static final String onuDynamicMultiGroupSlotNo = "onuDynamicMultiGroupSlotNo";
    public static final String onuDynamicMultiGroupPortNo = "onuDynamicMultiGroupPortNo";
    public static final String onuDynamicMultiGroupLogicalPortNo = "onuDynamicMultiGroupLogicalPortNo";
    public static final String onuDynamicMultiGroupPhysicalPortNo = "onuDynamicMultiGroupPhysicalPortNo";
    public static final String onuDynamicMulticastGroupAddress = "onuDynamicMulticastGroupAddress";
    public static final String onuDynamicMultiGroupVlanID = "onuDynamicMultiGroupVlanID";
    public static final String onuDynamicMultiGroupSourceIPAddress = "onuDynamicMultiGroupSourceIPAddress";
    public static final String onuDynamicMultiGroupVirtualPortNo = "onuDynamicMultiGroupVirtualPortNo";
    public static final String onuDynamicMultiGroupOltGEMPortNo = "onuDynamicMultiGroupOltGEMPortNo";

    public GponOnuDynamicMultiGroupMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuDynamicMultiGroupSlotNo, new SnmpMibBeanProperty(onuDynamicMultiGroupSlotNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.1", ISnmpConstant.INTEGER));
        initProperty(onuDynamicMultiGroupPortNo, new SnmpMibBeanProperty(onuDynamicMultiGroupPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.2", ISnmpConstant.INTEGER));
        initProperty(onuDynamicMultiGroupLogicalPortNo, new SnmpMibBeanProperty(onuDynamicMultiGroupLogicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.3", ISnmpConstant.INTEGER));
        initProperty(onuDynamicMultiGroupPhysicalPortNo, new SnmpMibBeanProperty(onuDynamicMultiGroupPhysicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.4", ISnmpConstant.INTEGER));
        initProperty(onuDynamicMulticastGroupAddress, new SnmpMibBeanProperty(onuDynamicMulticastGroupAddress, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.5", ISnmpConstant.STRING));
        initProperty(onuDynamicMultiGroupVlanID, new SnmpMibBeanProperty(onuDynamicMultiGroupVlanID, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.6", ISnmpConstant.INTEGER));
        initProperty(onuDynamicMultiGroupSourceIPAddress, new SnmpMibBeanProperty(onuDynamicMultiGroupSourceIPAddress, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.7", ISnmpConstant.IP_ADDRESS));
        initProperty(onuDynamicMultiGroupVirtualPortNo, new SnmpMibBeanProperty(onuDynamicMultiGroupVirtualPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.8", ISnmpConstant.GAUGE));
        initProperty(onuDynamicMultiGroupOltGEMPortNo, new SnmpMibBeanProperty(onuDynamicMultiGroupOltGEMPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.19.1.9", ISnmpConstant.GAUGE));
    }

    public Integer getOnuDynamicMultiGroupSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuDynamicMultiGroupSlotNo(Integer aOnuDynamicMultiGroupSlotNo) {
        setIndex(0, aOnuDynamicMultiGroupSlotNo);
    }

    public Integer getOnuDynamicMultiGroupPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuDynamicMultiGroupPortNo(Integer aOnuDynamicMultiGroupPortNo) {
        setIndex(1, aOnuDynamicMultiGroupPortNo);
    }

    public Integer getOnuDynamicMultiGroupLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuDynamicMultiGroupLogicalPortNo(Integer aOnuDynamicMultiGroupLogicalPortNo) {
        setIndex(2, aOnuDynamicMultiGroupLogicalPortNo);
    }

    public Integer getOnuDynamicMultiGroupPhysicalPortNo() {
        return (Integer) getIndex(3);
    }

    public void setOnuDynamicMultiGroupPhysicalPortNo(Integer aOnuDynamicMultiGroupPhysicalPortNo) {
        setIndex(3, aOnuDynamicMultiGroupPhysicalPortNo);
    }

    public String getOnuDynamicMulticastGroupAddress() {
        return (String) getIndex(4);
    }

    public void setOnuDynamicMulticastGroupAddress(String aOnuDynamicMulticastGroupAddress) {
        setIndex(4, aOnuDynamicMulticastGroupAddress);
    }

    public Integer getOnuDynamicMultiGroupVlanID() {
        return (Integer) getProperty(onuDynamicMultiGroupVlanID).getValue();
    }

    public void setOnuDynamicMultiGroupVlanID(Integer aOnuDynamicMultiGroupVlanID) {
        getProperty(onuDynamicMultiGroupVlanID).setValue(aOnuDynamicMultiGroupVlanID);
    }

    public String getOnuDynamicMultiGroupSourceIPAddress() {
        return (String) getProperty(onuDynamicMultiGroupSourceIPAddress).getValue();
    }

    public void setOnuDynamicMultiGroupSourceIPAddress(String aOnuDynamicMultiGroupSourceIPAddress) {
        getProperty(onuDynamicMultiGroupSourceIPAddress).setValue(aOnuDynamicMultiGroupSourceIPAddress);
    }

    public Long getOnuDynamicMultiGroupVirtualPortNo() {
        return (Long) getProperty(onuDynamicMultiGroupVirtualPortNo).getValue();
    }

    public void setOnuDynamicMultiGroupVirtualPortNo(Long aOnuDynamicMultiGroupVirtualPortNo) {
        getProperty(onuDynamicMultiGroupVirtualPortNo).setValue(aOnuDynamicMultiGroupVirtualPortNo);
    }

    public Long getOnuDynamicMultiGroupOltGEMPortNo() {
        return (Long) getProperty(onuDynamicMultiGroupOltGEMPortNo).getValue();
    }

    public void setOnuDynamicMultiGroupOltGEMPortNo(Long aOnuDynamicMultiGroupOltGEMPortNo) {
        getProperty(onuDynamicMultiGroupOltGEMPortNo).setValue(aOnuDynamicMultiGroupOltGEMPortNo);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuDynamicMultiGroupVlanID));
        prepareRead(getProperty(onuDynamicMultiGroupSourceIPAddress));
        prepareRead(getProperty(onuDynamicMultiGroupVirtualPortNo));
        prepareRead(getProperty(onuDynamicMultiGroupOltGEMPortNo));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuDynamicMultiGroupVlanID));
        prepareRead(getProperty(onuDynamicMultiGroupSourceIPAddress));
        prepareRead(getProperty(onuDynamicMultiGroupVirtualPortNo));
        prepareRead(getProperty(onuDynamicMultiGroupOltGEMPortNo));

        return loadAll(new int[]{1, 1, 1, 1, 4});
    }

}
package com.winnertel.ems.epon.iad.bbs4000.mib;


/*
    * Copyright (c) 2002-2005 UTStarcom, Inc.
    * All rights reserved.
    */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.ems.epon.snmp.SnmpUtility;

import java.util.Vector;

/**
 * The DHCPIPBindingStatusTableMBean class.
 * Created by QuickDVM
 */
public class DHCPIPBindingStatusTableMBean extends SnmpMibBean {
    public static final String utsDHCPPoolName = "utsDHCPPoolName";
    public static final String utsIpDHCPPoolBindingIpAddress = "utsIpDHCPPoolBindingIpAddress";
    public static final String utsIpDHCPPoolBindingVlanId = "utsIpDHCPPoolBindingVlanId";
    public static final String utsIpDHCPPoolBindingState = "utsIpDHCPPoolBindingState";
    public static final String utsIpDHCPPoolBindingType = "utsIpDHCPPoolBindingType";
    public static final String utsIpDHCPPoolBindingHardwareAddress = "utsIpDHCPPoolBindingHardwareAddress";
    public static final String utsIpDHCPPoolBindingLeaseExpiredTime = "utsIpDHCPPoolBindingLeaseExpiredTime";
    public static final String utsIpDHCPPoolBindingClear = "utsIpDHCPPoolBindingClear";

    ISnmpProxy proxy ;
    public DHCPIPBindingStatusTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        proxy = aSnmpProxy;
        init();
    }

    protected void init() {
        initProperty(utsDHCPPoolName, new SnmpMibBeanProperty(utsDHCPPoolName, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.1", ISnmpConstant.STRING));
        initProperty(utsIpDHCPPoolBindingIpAddress, new SnmpMibBeanProperty(utsIpDHCPPoolBindingIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.7.1.2", ISnmpConstant.STRING));
        initProperty(utsIpDHCPPoolBindingVlanId, new SnmpMibBeanProperty(utsIpDHCPPoolBindingVlanId, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.7.1.3", ISnmpConstant.INTEGER));
        initProperty(utsIpDHCPPoolBindingState, new SnmpMibBeanProperty(utsIpDHCPPoolBindingState, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.7.1.4", ISnmpConstant.INTEGER));
        initProperty(utsIpDHCPPoolBindingType, new SnmpMibBeanProperty(utsIpDHCPPoolBindingType, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.7.1.5", ISnmpConstant.INTEGER));
        initProperty(utsIpDHCPPoolBindingHardwareAddress, new SnmpMibBeanProperty(utsIpDHCPPoolBindingHardwareAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.7.1.6", ISnmpConstant.MAC_ADDRESS));
        initProperty(utsIpDHCPPoolBindingLeaseExpiredTime, new SnmpMibBeanProperty(utsIpDHCPPoolBindingLeaseExpiredTime, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.7.1.7", ISnmpConstant.STRING));
        initProperty(utsIpDHCPPoolBindingClear, new SnmpMibBeanProperty(utsIpDHCPPoolBindingClear, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.7.1.8", ISnmpConstant.INTEGER));

    }


    public String getUtsDHCPPoolName() {
        String a = (String) getIndex(0);

        return SnmpUtility.generateStringIndex(a);

    }

    public void setUtsDHCPPoolName(String aUtsDHCPPoolName) {
        setIndex(0, aUtsDHCPPoolName);
    }


    public String getUtsIpDHCPPoolBindingIpAddress() {
        String index = (String) getIndex(0);
        String newindex = index.replace('.',':');
        String[] split = newindex.split(":");
        String ipaddress = "";
        for(int i=split.length-4;i<split.length;i++){
            if(i == split.length-1)
                ipaddress+=split[i];
            else
                ipaddress+=split[i]+".";
        }
        return ipaddress;
    }

    public void setUtsIpDHCPPoolBindingIpAddress(String aUtsIpDHCPPoolBindingIpAddress) {
        setIndex(1, aUtsIpDHCPPoolBindingIpAddress);
    }


    public Integer getUtsIpDHCPPoolBindingVlanId() {
        return (Integer) getProperty(utsIpDHCPPoolBindingVlanId).getValue();
    }

    public void setUtsIpDHCPPoolBindingVlanId(Integer aUtsIpDHCPPoolBindingVlanId) {
        getProperty(utsIpDHCPPoolBindingVlanId).setValue(aUtsIpDHCPPoolBindingVlanId);
    }

    public Integer getUtsIpDHCPPoolBindingState() {
        return (Integer) getProperty(utsIpDHCPPoolBindingState).getValue();
    }

    public void setUtsIpDHCPPoolBindingState(Integer aUtsIpDHCPPoolBindingState) {
        getProperty(utsIpDHCPPoolBindingState).setValue(aUtsIpDHCPPoolBindingState);
    }

    public Integer getUtsIpDHCPPoolBindingType() {
        return (Integer) getProperty(utsIpDHCPPoolBindingType).getValue();
    }

    public void setUtsIpDHCPPoolBindingType(Integer aUtsIpDHCPPoolBindingType) {
        getProperty(utsIpDHCPPoolBindingType).setValue(aUtsIpDHCPPoolBindingType);
    }

    public byte[] getUtsIpDHCPPoolBindingHardwareAddress() {
        return (byte[]) getProperty(utsIpDHCPPoolBindingHardwareAddress).getValue();
    }

    public void setUtsIpDHCPPoolBindingHardwareAddress(byte[] aUtsIpDHCPPoolBindingHardwareAddress) {
        getProperty(utsIpDHCPPoolBindingHardwareAddress).setValue(aUtsIpDHCPPoolBindingHardwareAddress);
    }

    public String getUtsIpDHCPPoolBindingLeaseExpiredTime() {
        return (String) getProperty(utsIpDHCPPoolBindingLeaseExpiredTime).getValue();
    }

    public void setUtsIpDHCPPoolBindingLeaseExpiredTime(String aUtsIpDHCPPoolBindingLeaseExpiredTime) {
        getProperty(utsIpDHCPPoolBindingLeaseExpiredTime).setValue(aUtsIpDHCPPoolBindingLeaseExpiredTime);
    }

    public Integer getUtsIpDHCPPoolBindingClear() {
        return (Integer) getProperty(utsIpDHCPPoolBindingClear).getValue();
    }

    public void setUtsIpDHCPPoolBindingClear(Integer aUtsIpDHCPPoolBindingClear) {
        getProperty(utsIpDHCPPoolBindingClear).setValue(aUtsIpDHCPPoolBindingClear);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsIpDHCPPoolBindingVlanId));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingState));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingType));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingHardwareAddress));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingLeaseExpiredTime));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingClear));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsIpDHCPPoolBindingVlanId));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingState));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingType));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingHardwareAddress));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingLeaseExpiredTime));
        prepareRead(super.getProperty(utsIpDHCPPoolBindingClear));

        return loadAll(new int[]{0});
    }

    public boolean delete() throws MibBeanException {
        setUtsIpDHCPPoolBindingClear(new Integer(1));
        prepareSave(getProperty(utsIpDHCPPoolBindingClear));

        return save();
    }
}

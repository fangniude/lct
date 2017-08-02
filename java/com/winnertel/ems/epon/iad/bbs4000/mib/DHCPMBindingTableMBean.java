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
 * The DHCPMBindingTableMBean class.
 * Created by QuickDVM
 */
public class DHCPMBindingTableMBean extends SnmpMibBean {
    public static final String utsDHCPPoolName = "utsDHCPPoolName";
    public static final String utsDHCPPoolManualBindIpAddress = "utsDHCPPoolManualBindIpAddress";
    public static final String utsDHCPPoolManualBindVlanId = "utsDHCPPoolManualBindVlanId";
    public static final String utsDHCPPoolManualBindHardwareAddress = "utsDHCPPoolManualBindHardwareAddress";


    public DHCPMBindingTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDHCPPoolName, new SnmpMibBeanProperty(utsDHCPPoolName, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.1", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolManualBindIpAddress, new SnmpMibBeanProperty(utsDHCPPoolManualBindIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.6.1.2", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolManualBindVlanId, new SnmpMibBeanProperty(utsDHCPPoolManualBindVlanId, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.6.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDHCPPoolManualBindHardwareAddress, new SnmpMibBeanProperty(utsDHCPPoolManualBindHardwareAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.6.1.4", ISnmpConstant.MAC_ADDRESS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.6.1.6", ISnmpConstant.INTEGER));

    }


    public String getUtsDHCPPoolName() {
        String a = (String) getIndex(0);

        return SnmpUtility.generateStringIndex(a);

    }

    public void setUtsDHCPPoolName(String aUtsDHCPPoolName) {
        setIndex(0, aUtsDHCPPoolName);
    }


    public String getUtsDHCPPoolManualBindIpAddress() {
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

    public void setUtsDHCPPoolManualBindIpAddress(String aUtsDHCPPoolManualBindIpAddress) {
        setIndex(1, aUtsDHCPPoolManualBindIpAddress);
    }


    public Integer getUtsDHCPPoolManualBindVlanId() {
        return (Integer) getProperty(utsDHCPPoolManualBindVlanId).getValue();
    }

    public void setUtsDHCPPoolManualBindVlanId(Integer aUtsDHCPPoolManualBindVlanId) {
        getProperty(utsDHCPPoolManualBindVlanId).setValue(aUtsDHCPPoolManualBindVlanId);
    }

    public byte[] getUtsDHCPPoolManualBindHardwareAddress() {
        return (byte[]) getProperty(utsDHCPPoolManualBindHardwareAddress).getValue();
    }

    public void setUtsDHCPPoolManualBindHardwareAddress(byte[] aUtsDHCPPoolManualBindHardwareAddress) {
        getProperty(utsDHCPPoolManualBindHardwareAddress).setValue(aUtsDHCPPoolManualBindHardwareAddress);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDHCPPoolManualBindVlanId));
        prepareRead(super.getProperty(utsDHCPPoolManualBindHardwareAddress));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsDHCPPoolManualBindVlanId));
        prepareRead(super.getProperty(utsDHCPPoolManualBindHardwareAddress));

        Vector allBindingTbles = loadAll(new int[]{0});

        // if DHCP mode is 1: rfc2131(1), only return entries who's VLAN ID = 0; otherwise , just return all.
        DHCPGeneral dhcpGenMBean = new DHCPGeneral( fSnmpProxy );
        if ( dhcpGenMBean.retrieve() && dhcpGenMBean.getUtsDHCPServiceMode().intValue() == 2 ) {
        	return allBindingTbles;
        }

        Vector resultBindingTables = new Vector();
        for ( int i = 0; allBindingTbles != null && i < allBindingTbles.size(); i++ ) {
        	DHCPMBindingTableMBean tmpMBean = (DHCPMBindingTableMBean)allBindingTbles.elementAt(i);
        	if ( tmpMBean.getUtsDHCPPoolManualBindVlanId().intValue() == 0 ) {
        		resultBindingTables.add( tmpMBean );
        	}
        }

        return resultBindingTables;
    }


    public boolean modify() throws MibBeanException {
//        prepareSave(getProperty(utsDHCPPoolName));
//        prepareSave(getProperty(utsDHCPPoolManualBindIpAddress));
        prepareSave(getProperty(utsDHCPPoolManualBindVlanId));
        prepareSave(getProperty(utsDHCPPoolManualBindHardwareAddress));
        super.setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }


    public boolean add() throws MibBeanException {

        prepareSave(getProperty(utsDHCPPoolManualBindVlanId));
        prepareSave(getProperty(utsDHCPPoolManualBindHardwareAddress));
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }


    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}

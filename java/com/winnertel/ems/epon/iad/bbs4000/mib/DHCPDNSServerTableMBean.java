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
 * The DHCPDNSServerTableMBean class.
 * Created by QuickDVM
 */
public class DHCPDNSServerTableMBean extends SnmpMibBean {
    public static final String utsDHCPPoolName = "utsDHCPPoolName";
    public static final String utsDHCPPoolDnsServerIpAddress = "utsDHCPPoolDnsServerIpAddress";
    public static final String utsDHCPPoolDnsServerDomainName = "utsDHCPPoolDnsServerDomainName";


    public DHCPDNSServerTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDHCPPoolName, new SnmpMibBeanProperty(utsDHCPPoolName, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.2.1.1", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolDnsServerIpAddress, new SnmpMibBeanProperty(utsDHCPPoolDnsServerIpAddress, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.3.1.2", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolDnsServerDomainName, new SnmpMibBeanProperty(utsDHCPPoolDnsServerDomainName, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.3.1.3", ISnmpConstant.STRING));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.3.1.4", ISnmpConstant.INTEGER));

    }


    public String getUtsDHCPPoolName() {
        String a = (String) getIndex(0);

		return SnmpUtility.generateStringIndex(a);
    }

    public void setUtsDHCPPoolName(String aUtsDHCPPoolName) {
        setIndex(0, aUtsDHCPPoolName);
    }


    public String getUtsDHCPPoolDnsServerIpAddress() {
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

    public void setUtsDHCPPoolDnsServerIpAddress(String aUtsDHCPPoolDnsServerIpAddress) {
        setIndex(1, aUtsDHCPPoolDnsServerIpAddress);
    }


    public String getUtsDHCPPoolDnsServerDomainName() {
        return (String) getProperty(utsDHCPPoolDnsServerDomainName).getValue();
    }

    public void setUtsDHCPPoolDnsServerDomainName(String aUtsDHCPPoolDnsServerDomainName) {
        getProperty(utsDHCPPoolDnsServerDomainName).setValue(aUtsDHCPPoolDnsServerDomainName);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDHCPPoolDnsServerDomainName));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsDHCPPoolDnsServerDomainName));
        return loadAll(new int[]{0});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDHCPPoolName));
        prepareSave(getProperty(utsDHCPPoolDnsServerIpAddress));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDHCPPoolName));
        prepareSave(getProperty(utsDHCPPoolDnsServerIpAddress));
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

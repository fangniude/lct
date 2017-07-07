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
 * The DHCPNTPServerTableMBean class.
 * Created by QuickDVM
 */
public class DHCPNTPServerTableMBean extends SnmpMibBean {
    public static final String utsDHCPPoolName = "utsDHCPPoolName";
    public static final String utsDHCPPoolNtpServerIpAddress = "utsDHCPPoolNtpServerIpAddress";


    public DHCPNTPServerTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDHCPPoolName, new SnmpMibBeanProperty(utsDHCPPoolName, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.2.1.1", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolNtpServerIpAddress, new SnmpMibBeanProperty(utsDHCPPoolNtpServerIpAddress, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.8.1.2", ISnmpConstant.STRING));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.8.1.4", ISnmpConstant.INTEGER));

    }


    public String getUtsDHCPPoolName() {
        String a = (String) getIndex(0);

		return SnmpUtility.generateStringIndex(a);
    }

    public void setUtsDHCPPoolName(String aUtsDHCPPoolName) {
        setIndex(0, aUtsDHCPPoolName);
    }


    public String getUtsDHCPPoolNtpServerIpAddress() {
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

    public void setUtsDHCPPoolNtpServerIpAddress(String aUtsDHCPPoolNtpServerIpAddress) {
        setIndex(1, aUtsDHCPPoolNtpServerIpAddress);
    }


    public boolean retrieve() throws MibBeanException {


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {

        prepareRead(getProperty(utsDHCPPoolNtpServerIpAddress));

        return loadAll(new int[]{0});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDHCPPoolName));
        prepareSave(getProperty(utsDHCPPoolNtpServerIpAddress));


        return save();
    }


    public boolean add() throws MibBeanException {
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

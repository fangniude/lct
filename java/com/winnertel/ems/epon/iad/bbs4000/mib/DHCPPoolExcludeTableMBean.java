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
 * The DHCPPoolExcludeTableMBean class.
 * Created by QuickDVM
 */
public class DHCPPoolExcludeTableMBean extends SnmpMibBean {
    public static final String utsDHCPPoolName = "utsDHCPPoolName";
    public static final String utsDHCPPoolExcludedLowIpAddress = "utsDHCPPoolExcludedLowIpAddress";
    public static final String utsDHCPPoolExcludedHighIpAddress = "utsDHCPPoolExcludedHighIpAddress";

    private String poolName;


    public DHCPPoolExcludeTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDHCPPoolName, new SnmpMibBeanProperty(utsDHCPPoolName, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.2.1.1", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolExcludedLowIpAddress, new SnmpMibBeanProperty(utsDHCPPoolExcludedLowIpAddress, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.5.1.2", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolExcludedHighIpAddress, new SnmpMibBeanProperty(utsDHCPPoolExcludedHighIpAddress, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.5.1.3", ISnmpConstant.IP_ADDRESS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.5.1.5", ISnmpConstant.INTEGER));

    }

    public void setPoolName( String poolName )
    {
        this.poolName = poolName;
    }

    public String getPoolName(  )
    {
        return poolName;
    }


    public String getUtsDHCPPoolName() {
        String a = (String) getIndex(0);

		return SnmpUtility.generateStringIndex(a);
    }

    public void setUtsDHCPPoolName(String aUtsDHCPPoolName) {
        setIndex(0, aUtsDHCPPoolName);
    }


    public String getUtsDHCPPoolExcludedLowIpAddress() {
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

    public void setUtsDHCPPoolExcludedLowIpAddress(String aUtsDHCPPoolExcludedLowIpAddress) {
        setIndex(1, aUtsDHCPPoolExcludedLowIpAddress);
    }


    public String getUtsDHCPPoolExcludedHighIpAddress() {
        return (String) getProperty(utsDHCPPoolExcludedHighIpAddress).getValue();
    }

    public void setUtsDHCPPoolExcludedHighIpAddress(String aUtsDHCPPoolExcludedHighIpAddress) {
        getProperty(utsDHCPPoolExcludedHighIpAddress).setValue(aUtsDHCPPoolExcludedHighIpAddress);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDHCPPoolExcludedHighIpAddress));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsDHCPPoolExcludedHighIpAddress));
        if (poolName!=null) {
            Vector result= new Vector();
            Vector v = loadAll(new int[]{0});
            if(v!=null){
                for(int i=0;i<v.size();i++){
                    DHCPPoolExcludeTableMBean one = (DHCPPoolExcludeTableMBean)v.get(i);
                    if(one.getUtsDHCPPoolName().equals(poolName)){
                        result.add(one);
                    }
                }
            }
            return result;
        } else {
            return loadAll(new int[]{0});
        }
    }


    public boolean modify() throws MibBeanException {
//        prepareSave(getProperty(utsDHCPPoolName));
//        prepareSave(getProperty(utsDHCPPoolExcludedLowIpAddress));
        prepareSave(getProperty(utsDHCPPoolExcludedHighIpAddress));
        super.setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDHCPPoolExcludedHighIpAddress));
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

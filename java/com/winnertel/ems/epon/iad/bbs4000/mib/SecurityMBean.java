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

/**
 * The SecurityMBean class.
 * Created by QuickDVM
 */
public class SecurityMBean extends SnmpMibBean {
    public static final String utsDot3Security8021xRadiusSecondaryCliAcctSharedKey = "utsDot3Security8021xRadiusSecondaryCliAcctSharedKey";
    public static final String utsDot3Security8021xRadiusAutoSwitch = "utsDot3Security8021xRadiusAutoSwitch";
    public static final String utsDot3Security8021xRadiusRetryTimes = "utsDot3Security8021xRadiusRetryTimes";
    public static final String utsDot3Security8021xRadiusTimeout = "utsDot3Security8021xRadiusTimeout";
    public static final String utsDot3Security8021xRadiusBackToPrimary = "utsDot3Security8021xRadiusBackToPrimary";
    public static final String utsDot3Security8021xRadiusRealm = "utsDot3Security8021xRadiusRealm";
    public static final String utsDot3Security8021xRadiusNasIpAddress = "utsDot3Security8021xRadiusNasIpAddress";
    public static final String utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP = "utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP";
    public static final String utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort = "utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort";
    public static final String utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey = "utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey";
    public static final String utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP = "utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP";
    public static final String utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort = "utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort";
    public static final String utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey = "utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey";
    public static final String utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP = "utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP";
    public static final String utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort = "utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort";
    public static final String utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey = "utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey";
    public static final String utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP = "utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP";
    public static final String utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort = "utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort";
    public static final String utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey = "utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey";
    public static final String utsDot3Security8021xRadiusSvrPrimaryCliAuthIP = "utsDot3Security8021xRadiusSvrPrimaryCliAuthIP";
    public static final String utsDot3Security8021xRadiusSvrPrimaryCliAuthPort = "utsDot3Security8021xRadiusSvrPrimaryCliAuthPort";
    public static final String utsDot3Security8021xRadiusPrimaryCliAuthSharedKey = "utsDot3Security8021xRadiusPrimaryCliAuthSharedKey";
    public static final String utsDot3Security8021xRadiusSvrSecondaryCliAuthIP = "utsDot3Security8021xRadiusSvrSecondaryCliAuthIP";
    public static final String utsDot3Security8021xRadiusSvrSecondaryCliAuthPort = "utsDot3Security8021xRadiusSvrSecondaryCliAuthPort";
    public static final String utsDot3Security8021xRadiusSecondaryCliAuthSharedKey = "utsDot3Security8021xRadiusSecondaryCliAuthSharedKey";
    public static final String utsDot3Security8021xRadiusSvrPrimaryCliAcctIP = "utsDot3Security8021xRadiusSvrPrimaryCliAcctIP";
    public static final String utsDot3Security8021xRadiusSvrPrimaryCliAcctPort = "utsDot3Security8021xRadiusSvrPrimaryCliAcctPort";
    public static final String utsDot3Security8021xRadiusPrimaryCliAcctSharedKey = "utsDot3Security8021xRadiusPrimaryCliAcctSharedKey";
    public static final String utsDot3Security8021xRadiusSvrSecondaryCliAcctIP = "utsDot3Security8021xRadiusSvrSecondaryCliAcctIP";
    public static final String utsDot3Security8021xRadiusSvrSecondaryCliAcctPort = "utsDot3Security8021xRadiusSvrSecondaryCliAcctPort";

    public SecurityMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Security8021xRadiusSecondaryCliAcctSharedKey, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSecondaryCliAcctSharedKey, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.34", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusAutoSwitch, new SnmpMibBeanProperty(utsDot3Security8021xRadiusAutoSwitch, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusRetryTimes, new SnmpMibBeanProperty(utsDot3Security8021xRadiusRetryTimes, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusTimeout, new SnmpMibBeanProperty(utsDot3Security8021xRadiusTimeout, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusBackToPrimary, new SnmpMibBeanProperty(utsDot3Security8021xRadiusBackToPrimary, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusRealm, new SnmpMibBeanProperty(utsDot3Security8021xRadiusRealm, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.5", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusNasIpAddress, new SnmpMibBeanProperty(utsDot3Security8021xRadiusNasIpAddress, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.6", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.11", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.12", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey, new SnmpMibBeanProperty(utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.13", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.14", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.15", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.16", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.17", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.18", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey, new SnmpMibBeanProperty(utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.19", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.20", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.21", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.22", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthIP, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthIP, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.23", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthPort, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthPort, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.24", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusPrimaryCliAuthSharedKey, new SnmpMibBeanProperty(utsDot3Security8021xRadiusPrimaryCliAuthSharedKey, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.25", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthIP, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthIP, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.26", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthPort, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthPort, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.27", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusSecondaryCliAuthSharedKey, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSecondaryCliAuthSharedKey, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.28", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctIP, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctIP, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.29", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctPort, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctPort, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.30", ISnmpConstant.INTEGER));
        initProperty(utsDot3Security8021xRadiusPrimaryCliAcctSharedKey, new SnmpMibBeanProperty(utsDot3Security8021xRadiusPrimaryCliAcctSharedKey, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.31", ISnmpConstant.STRING));
        initProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctIP, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctIP, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.32", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctPort, new SnmpMibBeanProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctPort, ".1.3.6.1.4.1.41355.1800.5.1.1.1.2.1.33", ISnmpConstant.INTEGER));
    }


    public String getUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey() {
        return (String) getProperty(utsDot3Security8021xRadiusSecondaryCliAcctSharedKey).getValue();
    }

    public void setUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey(String aUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey) {
        getProperty(utsDot3Security8021xRadiusSecondaryCliAcctSharedKey).setValue(aUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey);
    }

    public Integer getUtsDot3Security8021xRadiusAutoSwitch() {
        return (Integer) getProperty(utsDot3Security8021xRadiusAutoSwitch).getValue();
    }

    public void setUtsDot3Security8021xRadiusAutoSwitch(Integer aUtsDot3Security8021xRadiusAutoSwitch) {
        getProperty(utsDot3Security8021xRadiusAutoSwitch).setValue(aUtsDot3Security8021xRadiusAutoSwitch);
    }

    public Integer getUtsDot3Security8021xRadiusRetryTimes() {
        return (Integer) getProperty(utsDot3Security8021xRadiusRetryTimes).getValue();
    }

    public void setUtsDot3Security8021xRadiusRetryTimes(Integer aUtsDot3Security8021xRadiusRetryTimes) {
        getProperty(utsDot3Security8021xRadiusRetryTimes).setValue(aUtsDot3Security8021xRadiusRetryTimes);
    }

    public Integer getUtsDot3Security8021xRadiusTimeout() {
        return (Integer) getProperty(utsDot3Security8021xRadiusTimeout).getValue();
    }

    public void setUtsDot3Security8021xRadiusTimeout(Integer aUtsDot3Security8021xRadiusTimeout) {
        getProperty(utsDot3Security8021xRadiusTimeout).setValue(aUtsDot3Security8021xRadiusTimeout);
    }

    public Integer getUtsDot3Security8021xRadiusBackToPrimary() {
        return (Integer) getProperty(utsDot3Security8021xRadiusBackToPrimary).getValue();
    }

    public void setUtsDot3Security8021xRadiusBackToPrimary(Integer aUtsDot3Security8021xRadiusBackToPrimary) {
        getProperty(utsDot3Security8021xRadiusBackToPrimary).setValue(aUtsDot3Security8021xRadiusBackToPrimary);
    }

    public String getUtsDot3Security8021xRadiusRealm() {
        return (String) getProperty(utsDot3Security8021xRadiusRealm).getValue();
    }

    public void setUtsDot3Security8021xRadiusRealm(String aUtsDot3Security8021xRadiusRealm) {
        getProperty(utsDot3Security8021xRadiusRealm).setValue(aUtsDot3Security8021xRadiusRealm);
    }

    public String getUtsDot3Security8021xRadiusNasIpAddress() {
        return (String) getProperty(utsDot3Security8021xRadiusNasIpAddress).getValue();
    }

    public void setUtsDot3Security8021xRadiusNasIpAddress(String aUtsDot3Security8021xRadiusNasIpAddress) {
        getProperty(utsDot3Security8021xRadiusNasIpAddress).setValue(aUtsDot3Security8021xRadiusNasIpAddress);
    }

    public String getUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP() {
        return (String) getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP(String aUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP) {
        getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP).setValue(aUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP);
    }

    public Integer getUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort() {
        return (Integer) getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort(Integer aUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort) {
        getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort).setValue(aUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort);
    }

    public String getUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey() {
        return (String) getProperty(utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey).getValue();
    }

    public void setUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey(String aUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey) {
        getProperty(utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey).setValue(aUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey);
    }

    public String getUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP() {
        return (String) getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP(String aUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP) {
        getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP).setValue(aUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP);
    }

    public Integer getUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort() {
        return (Integer) getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort(Integer aUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort) {
        getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort).setValue(aUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort);
    }

    public String getUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey() {
        return (String) getProperty(utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey).getValue();
    }

    public void setUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey(String aUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey) {
        getProperty(utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey).setValue(aUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey);
    }

    public String getUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP() {
        return (String) getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP(String aUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP) {
        getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP).setValue(aUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP);
    }

    public Integer getUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort() {
        return (Integer) getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort(Integer aUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort) {
        getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort).setValue(aUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort);
    }

    public String getUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey() {
        return (String) getProperty(utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey).getValue();
    }

    public void setUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey(String aUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey) {
        getProperty(utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey).setValue(aUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey);
    }

    public String getUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP() {
        return (String) getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP(String aUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP) {
        getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP).setValue(aUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP);
    }

    public Integer getUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort() {
        return (Integer) getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort(Integer aUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort) {
        getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort).setValue(aUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort);
    }

    public String getUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey() {
        return (String) getProperty(utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey).getValue();
    }

    public void setUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey(String aUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey) {
        getProperty(utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey).setValue(aUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey);
    }

    public String getUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP() {
        return (String) getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthIP).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP(String aUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP) {
        getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthIP).setValue(aUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP);
    }

    public Integer getUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort() {
        return (Integer) getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthPort).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort(Integer aUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort) {
        getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthPort).setValue(aUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort);
    }

    public String getUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey() {
        return (String) getProperty(utsDot3Security8021xRadiusPrimaryCliAuthSharedKey).getValue();
    }

    public void setUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey(String aUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey) {
        getProperty(utsDot3Security8021xRadiusPrimaryCliAuthSharedKey).setValue(aUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey);
    }

    public String getUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP() {
        return (String) getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthIP).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP(String aUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP) {
        getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthIP).setValue(aUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP);
    }

    public Integer getUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort() {
        return (Integer) getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthPort).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort(Integer aUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort) {
        getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthPort).setValue(aUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort);
    }

    public String getUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey() {
        return (String) getProperty(utsDot3Security8021xRadiusSecondaryCliAuthSharedKey).getValue();
    }

    public void setUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey(String aUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey) {
        getProperty(utsDot3Security8021xRadiusSecondaryCliAuthSharedKey).setValue(aUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey);
    }

    public String getUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP() {
        return (String) getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctIP).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP(String aUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP) {
        getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctIP).setValue(aUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP);
    }

    public Integer getUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort() {
        return (Integer) getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctPort).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort(Integer aUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort) {
        getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctPort).setValue(aUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort);
    }

    public String getUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey() {
        return (String) getProperty(utsDot3Security8021xRadiusPrimaryCliAcctSharedKey).getValue();
    }

    public void setUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey(String aUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey) {
        getProperty(utsDot3Security8021xRadiusPrimaryCliAcctSharedKey).setValue(aUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey);
    }

    public String getUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP() {
        return (String) getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctIP).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP(String aUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP) {
        getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctIP).setValue(aUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP);
    }

    public Integer getUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort() {
        return (Integer) getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctPort).getValue();
    }

    public void setUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort(Integer aUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort) {
        getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctPort).setValue(aUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSecondaryCliAcctSharedKey));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusAutoSwitch));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusRetryTimes));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusTimeout));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusBackToPrimary));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusRealm));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusNasIpAddress));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthIP));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthPort));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusPrimaryCliAuthSharedKey));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthIP));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthPort));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSecondaryCliAuthSharedKey));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctIP));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctPort));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusPrimaryCliAcctSharedKey));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctIP));
        prepareRead(super.getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctPort));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3Security8021xRadiusSecondaryCliAcctSharedKey));
        prepareSave(getProperty(utsDot3Security8021xRadiusAutoSwitch));
        prepareSave(getProperty(utsDot3Security8021xRadiusRetryTimes));
        prepareSave(getProperty(utsDot3Security8021xRadiusTimeout));
        prepareSave(getProperty(utsDot3Security8021xRadiusBackToPrimary));
        prepareSave(getProperty(utsDot3Security8021xRadiusRealm));
        prepareSave(getProperty(utsDot3Security8021xRadiusNasIpAddress));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort));
        prepareSave(getProperty(utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort));
        prepareSave(getProperty(utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort));
        prepareSave(getProperty(utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort));
        prepareSave(getProperty(utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthIP));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAuthPort));
        prepareSave(getProperty(utsDot3Security8021xRadiusPrimaryCliAuthSharedKey));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthIP));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAuthPort));
        prepareSave(getProperty(utsDot3Security8021xRadiusSecondaryCliAuthSharedKey));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctIP));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrPrimaryCliAcctPort));
        prepareSave(getProperty(utsDot3Security8021xRadiusPrimaryCliAcctSharedKey));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctIP));
        prepareSave(getProperty(utsDot3Security8021xRadiusSvrSecondaryCliAcctPort));

        return save();
    }


}

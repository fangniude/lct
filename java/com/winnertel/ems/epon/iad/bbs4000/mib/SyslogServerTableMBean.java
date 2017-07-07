package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The SyslogServerTableMBean class.
 * Created by QuickDVM
 */
public class SyslogServerTableMBean extends SnmpMibBean {
    public static final String utsSyslogServerId = "utsSyslogServerId";
    public static final String utsSyslogServerIpAddress = "utsSyslogServerIpAddress";
    public static final String utsSyslogServerPort = "utsSyslogServerPort";
    public static final String utsSyslogServerFacilityAuth = "utsSyslogServerFacilityAuth";
    public static final String utsSyslogServerFacilityDhcp = "utsSyslogServerFacilityDhcp";
    public static final String utsSyslogServerFacilityEthernet = "utsSyslogServerFacilityEthernet";
    public static final String utsSyslogServerFacilityPon = "utsSyslogServerFacilityPon";
    public static final String utsSyslogServerFacilitySnmp = "utsSyslogServerFacilitySnmp";
    public static final String utsSyslogServerFacilitySys = "utsSyslogServerFacilitySys";
    public static final String utsSyslogServerFacilitySyslog = "utsSyslogServerFacilitySyslog";
    public static final String utsSyslogServerFacilityUser = "utsSyslogServerFacilityUser";

    public SyslogServerTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsSyslogServerId, new SnmpMibBeanProperty(utsSyslogServerId, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.1", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerIpAddress, new SnmpMibBeanProperty(utsSyslogServerIpAddress, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.2", ISnmpConstant.IP_ADDRESS));
        initProperty(utsSyslogServerPort, new SnmpMibBeanProperty(utsSyslogServerPort, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.3", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerFacilityAuth, new SnmpMibBeanProperty(utsSyslogServerFacilityAuth, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.4", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerFacilityDhcp, new SnmpMibBeanProperty(utsSyslogServerFacilityDhcp, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.5", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerFacilityEthernet, new SnmpMibBeanProperty(utsSyslogServerFacilityEthernet, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.6", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerFacilityPon, new SnmpMibBeanProperty(utsSyslogServerFacilityPon, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.7", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerFacilitySnmp, new SnmpMibBeanProperty(utsSyslogServerFacilitySnmp, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.8", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerFacilitySys, new SnmpMibBeanProperty(utsSyslogServerFacilitySys, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.9", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerFacilitySyslog, new SnmpMibBeanProperty(utsSyslogServerFacilitySyslog, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.10", ISnmpConstant.INTEGER));
        initProperty(utsSyslogServerFacilityUser, new SnmpMibBeanProperty(utsSyslogServerFacilityUser, ".1.3.6.1.4.1.41355.1800.2.1.1.3.2.1.11", ISnmpConstant.INTEGER));

    }


    public Integer getUtsSyslogServerId() {
        return (Integer) getIndex(0);
    }

    public void setUtsSyslogServerId(Integer aUtsSyslogServerId) {
        setIndex(0, aUtsSyslogServerId);
    }


    public String getUtsSyslogServerIpAddress() {
        return (String) getProperty(utsSyslogServerIpAddress).getValue();
    }

    public void setUtsSyslogServerIpAddress(String aUtsSyslogServerIpAddress) {
        getProperty(utsSyslogServerIpAddress).setValue(aUtsSyslogServerIpAddress);
    }

    public Integer getUtsSyslogServerPort() {
        return (Integer) getProperty(utsSyslogServerPort).getValue();
    }

    public void setUtsSyslogServerPort(Integer aUtsSyslogServerPort) {
        getProperty(utsSyslogServerPort).setValue(aUtsSyslogServerPort);
    }

    public Integer getUtsSyslogServerFacilityAuth() {
        return (Integer) getProperty(utsSyslogServerFacilityAuth).getValue();
    }

    public void setUtsSyslogServerFacilityAuth(Integer aUtsSyslogServerFacilityAuth) {
        getProperty(utsSyslogServerFacilityAuth).setValue(aUtsSyslogServerFacilityAuth);
    }

    public Integer getUtsSyslogServerFacilityDhcp() {
        return (Integer) getProperty(utsSyslogServerFacilityDhcp).getValue();
    }

    public void setUtsSyslogServerFacilityDhcp(Integer aUtsSyslogServerFacilityDhcp) {
        getProperty(utsSyslogServerFacilityDhcp).setValue(aUtsSyslogServerFacilityDhcp);
    }

    public Integer getUtsSyslogServerFacilityEthernet() {
        return (Integer) getProperty(utsSyslogServerFacilityEthernet).getValue();
    }

    public void setUtsSyslogServerFacilityEthernet(Integer aUtsSyslogServerFacilityEthernet) {
        getProperty(utsSyslogServerFacilityEthernet).setValue(aUtsSyslogServerFacilityEthernet);
    }

    public Integer getUtsSyslogServerFacilityPon() {
        return (Integer) getProperty(utsSyslogServerFacilityPon).getValue();
    }

    public void setUtsSyslogServerFacilityPon(Integer aUtsSyslogServerFacilityPon) {
        getProperty(utsSyslogServerFacilityPon).setValue(aUtsSyslogServerFacilityPon);
    }

    public Integer getUtsSyslogServerFacilitySnmp() {
        return (Integer) getProperty(utsSyslogServerFacilitySnmp).getValue();
    }

    public void setUtsSyslogServerFacilitySnmp(Integer aUtsSyslogServerFacilitySnmp) {
        getProperty(utsSyslogServerFacilitySnmp).setValue(aUtsSyslogServerFacilitySnmp);
    }

    public Integer getUtsSyslogServerFacilitySys() {
        return (Integer) getProperty(utsSyslogServerFacilitySys).getValue();
    }

    public void setUtsSyslogServerFacilitySys(Integer aUtsSyslogServerFacilitySys) {
        getProperty(utsSyslogServerFacilitySys).setValue(aUtsSyslogServerFacilitySys);
    }

    public Integer getUtsSyslogServerFacilitySyslog() {
        return (Integer) getProperty(utsSyslogServerFacilitySyslog).getValue();
    }

    public void setUtsSyslogServerFacilitySyslog(Integer aUtsSyslogServerFacilitySyslog) {
        getProperty(utsSyslogServerFacilitySyslog).setValue(aUtsSyslogServerFacilitySyslog);
    }

    public Integer getUtsSyslogServerFacilityUser() {
        return (Integer) getProperty(utsSyslogServerFacilityUser).getValue();
    }

    public void setUtsSyslogServerFacilityUser(Integer aUtsSyslogServerFacilityUser) {
        getProperty(utsSyslogServerFacilityUser).setValue(aUtsSyslogServerFacilityUser);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsSyslogServerIpAddress));
        prepareRead(super.getProperty(utsSyslogServerPort));
        prepareRead(super.getProperty(utsSyslogServerFacilityAuth));
        prepareRead(super.getProperty(utsSyslogServerFacilityDhcp));
        prepareRead(super.getProperty(utsSyslogServerFacilityEthernet));
        prepareRead(super.getProperty(utsSyslogServerFacilityPon));
        prepareRead(super.getProperty(utsSyslogServerFacilitySnmp));
        prepareRead(super.getProperty(utsSyslogServerFacilitySys));
        prepareRead(super.getProperty(utsSyslogServerFacilitySyslog));
        prepareRead(super.getProperty(utsSyslogServerFacilityUser));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsSyslogServerIpAddress));
        prepareRead(super.getProperty(utsSyslogServerPort));
        prepareRead(super.getProperty(utsSyslogServerFacilityAuth));
        prepareRead(super.getProperty(utsSyslogServerFacilityDhcp));
        prepareRead(super.getProperty(utsSyslogServerFacilityEthernet));
        prepareRead(super.getProperty(utsSyslogServerFacilityPon));
        prepareRead(super.getProperty(utsSyslogServerFacilitySnmp));
        prepareRead(super.getProperty(utsSyslogServerFacilitySys));
        prepareRead(super.getProperty(utsSyslogServerFacilitySyslog));
        prepareRead(super.getProperty(utsSyslogServerFacilityUser));

        return loadAll(new int[]{1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsSyslogServerIpAddress));
        prepareSave(getProperty(utsSyslogServerPort));
        prepareSave(getProperty(utsSyslogServerFacilityAuth));
        prepareSave(getProperty(utsSyslogServerFacilityDhcp));
        prepareSave(getProperty(utsSyslogServerFacilityEthernet));
        prepareSave(getProperty(utsSyslogServerFacilityPon));
        prepareSave(getProperty(utsSyslogServerFacilitySnmp));
        prepareSave(getProperty(utsSyslogServerFacilitySys));
        prepareSave(getProperty(utsSyslogServerFacilitySyslog));
        prepareSave(getProperty(utsSyslogServerFacilityUser));

        return save();
    }


}

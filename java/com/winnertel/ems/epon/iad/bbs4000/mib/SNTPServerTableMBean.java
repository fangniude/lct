package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The SNTPServerTableMBean class.
 * Created by QuickDVM
 */
public class SNTPServerTableMBean extends SnmpMibBean {
    public static final String utsSNTPServerId = "utsSNTPServerId";
    public static final String utsSNTPServerIpAddress = "utsSNTPServerIpAddress";
    public static final String utsSNTPServerState = "utsSNTPServerState";
    public static final String utsSNTPServerVersion = "utsSNTPServerVersion";


    public SNTPServerTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsSNTPServerId, new SnmpMibBeanProperty(utsSNTPServerId, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.2.1.1", ISnmpConstant.INTEGER));
        initProperty(utsSNTPServerIpAddress, new SnmpMibBeanProperty(utsSNTPServerIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.2.1.2", ISnmpConstant.IP_ADDRESS));
        initProperty(utsSNTPServerState, new SnmpMibBeanProperty(utsSNTPServerState, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.2.1.3", ISnmpConstant.INTEGER));
        initProperty(utsSNTPServerVersion, new SnmpMibBeanProperty(utsSNTPServerVersion, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.2.1.4", ISnmpConstant.STRING));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.2.1.6.4.2.1.5", ISnmpConstant.INTEGER));

    }


    public Integer getUtsSNTPServerId() {
        return (Integer) getIndex(0);
    }

    public void setUtsSNTPServerId(Integer aUtsSNTPServerId) {
        setIndex(0, aUtsSNTPServerId);
    }


    public String getUtsSNTPServerIpAddress() {
        return (String) getProperty(utsSNTPServerIpAddress).getValue();
    }

    public void setUtsSNTPServerIpAddress(String aUtsSNTPServerIpAddress) {
        getProperty(utsSNTPServerIpAddress).setValue(aUtsSNTPServerIpAddress);
    }

    public Integer getUtsSNTPServerState() {
        return (Integer) getProperty(utsSNTPServerState).getValue();
    }

    public void setUtsSNTPServerState(Integer aUtsSNTPServerState) {
        getProperty(utsSNTPServerState).setValue(aUtsSNTPServerState);
    }

    public String getUtsSNTPServerVersion() {
        return  (String)getProperty(utsSNTPServerVersion).getValue();
    }

    public void setUtsSNTPServerVersion(String aUtsSNTPServerVersion) {
        getProperty(utsSNTPServerVersion).setValue(aUtsSNTPServerVersion);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsSNTPServerIpAddress));
        prepareRead(super.getProperty(utsSNTPServerState));
        prepareRead(super.getProperty(utsSNTPServerVersion));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsSNTPServerIpAddress));
        prepareRead(super.getProperty(utsSNTPServerState));
        prepareRead(super.getProperty(utsSNTPServerVersion));
        
        return loadAll(new int[] {1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsSNTPServerId));
        prepareSave(getProperty(utsSNTPServerIpAddress));
        prepareSave(getProperty(utsSNTPServerVersion));


        return save();
    }

     public boolean add() throws MibBeanException {
         prepareSave(getProperty(utsSNTPServerIpAddress));
         prepareSave(getProperty(utsSNTPServerVersion));
         super.setRowStatus(new Integer(5));
         prepareSave(getProperty(ROW_STATUS));
         save();
        return true;
    }


    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}

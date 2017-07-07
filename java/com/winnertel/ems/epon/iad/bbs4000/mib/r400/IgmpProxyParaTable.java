/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class IgmpProxyParaTable extends SnmpMibBean {

    public static final String proxyIndex = "proxyIndex";
    public static final String proxyName = "proxyName";
    public static final String proxySrcIPAddress = "proxySrcIPAddress";
    public static final String proxyMulticastVID = "proxyMulticastVID";
    public static final String proxyMulticastIPAddress = "proxyMulticastIPAddress";
    public static final String multicastAssuredBW = "multicastAssuredBW";
    public static final String multicastMaxBW = "multicastMaxBW";

    public IgmpProxyParaTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(proxyIndex, new SnmpMibBeanProperty(proxyIndex, ".1.3.6.1.4.1.17409.2.3.6.2.1.1", ISnmpConstant.INTEGER));
        initProperty(proxyName, new SnmpMibBeanProperty(proxyName, ".1.3.6.1.4.1.17409.2.3.6.2.1.2", ISnmpConstant.STRING));
        initProperty(proxySrcIPAddress, new SnmpMibBeanProperty(proxySrcIPAddress, ".1.3.6.1.4.1.17409.2.3.6.2.1.3", ISnmpConstant.IP_ADDRESS));
        initProperty(proxyMulticastVID, new SnmpMibBeanProperty(proxyMulticastVID, ".1.3.6.1.4.1.17409.2.3.6.2.1.4", ISnmpConstant.INTEGER));
        initProperty(proxyMulticastIPAddress, new SnmpMibBeanProperty(proxyMulticastIPAddress, ".1.3.6.1.4.1.17409.2.3.6.2.1.5", ISnmpConstant.IP_ADDRESS));
        initProperty(multicastAssuredBW, new SnmpMibBeanProperty(multicastAssuredBW, ".1.3.6.1.4.1.17409.2.3.6.2.1.6", ISnmpConstant.GAUGE));
        initProperty(multicastMaxBW, new SnmpMibBeanProperty(multicastMaxBW, ".1.3.6.1.4.1.17409.2.3.6.2.1.7", ISnmpConstant.GAUGE));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.6.2.1.8", ISnmpConstant.INTEGER));
    }

    public Integer getProxyIndex() {
        return (Integer) getIndex(0);
    }

    public void setProxyIndex(Integer aProxyIndex) {
        setIndex(0, aProxyIndex);
    }

    public String getProxyName() {
        return (String) getProperty(proxyName).getValue();
    }

    public void setProxyName(String aProxyName) {
        getProperty(proxyName).setValue(aProxyName);
    }

    public String getProxySrcIPAddress() {
        return (String) getProperty(proxySrcIPAddress).getValue();
    }

    public void setProxySrcIPAddress(String aProxySrcIPAddress) {
        getProperty(proxySrcIPAddress).setValue(aProxySrcIPAddress);
    }

    public Integer getProxyMulticastVID() {
        return (Integer) getProperty(proxyMulticastVID).getValue();
    }

    public void setProxyMulticastVID(Integer aProxyMulticastVID) {
        getProperty(proxyMulticastVID).setValue(aProxyMulticastVID);
    }

    public String getProxyMulticastIPAddress() {
        return (String) getProperty(proxyMulticastIPAddress).getValue();
    }

    public void setProxyMulticastIPAddress(String aProxyMulticastIPAddress) {
        getProperty(proxyMulticastIPAddress).setValue(aProxyMulticastIPAddress);
    }

    public Long getMulticastAssuredBW() {
        return (Long) getProperty(multicastAssuredBW).getValue();
    }

    public void setMulticastAssuredBW(Long aMulticastAssuredBW) {
        getProperty(multicastAssuredBW).setValue(aMulticastAssuredBW);
    }

    public Long getMulticastMaxBW() {
        return (Long) getProperty(multicastMaxBW).getValue();
    }

    public void setMulticastMaxBW(Long aMulticastMaxBW) {
        getProperty(multicastMaxBW).setValue(aMulticastMaxBW);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(proxyName));
        prepareRead(getProperty(proxySrcIPAddress));
        prepareRead(getProperty(proxyMulticastVID));
        prepareRead(getProperty(proxyMulticastIPAddress));
        prepareRead(getProperty(multicastAssuredBW));
        prepareRead(getProperty(multicastMaxBW));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(proxyName));
        prepareRead(getProperty(proxySrcIPAddress));
        prepareRead(getProperty(proxyMulticastVID));
        prepareRead(getProperty(proxyMulticastIPAddress));
        prepareRead(getProperty(multicastAssuredBW));
        prepareRead(getProperty(multicastMaxBW));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(proxyName));
        prepareSave(getProperty(proxySrcIPAddress));
        prepareSave(getProperty(proxyMulticastVID));
        prepareSave(getProperty(proxyMulticastIPAddress));
        prepareSave(getProperty(multicastAssuredBW));
        prepareSave(getProperty(multicastMaxBW));

        setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(proxyName));
        prepareSave(getProperty(proxySrcIPAddress));
        prepareSave(getProperty(proxyMulticastVID));
        prepareSave(getProperty(proxyMulticastIPAddress));
        prepareSave(getProperty(multicastAssuredBW));
        prepareSave(getProperty(multicastMaxBW));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}
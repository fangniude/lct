package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuVlanConfigTable class.
 * Created by QuickDVM
 */
public class OnuVlanConfigTable extends SnmpMibBean {
    public static final String onuVlanIndex = "onuVlanIndex";
    public static final String onuVlanName = "onuVlanName";
    public static final String onuVlanTaggedPort = "onuVlanTaggedPort";
    public static final String onuVlanUntaggedPort = "onuVlanUntaggedPort";


    public OnuVlanConfigTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVlanIndex, new SnmpMibBeanProperty(onuVlanIndex, ".1.3.6.1.4.1.17409.2.3.7.2.2.1.1", ISnmpConstant.INTEGER));
        initProperty(onuVlanName, new SnmpMibBeanProperty(onuVlanName, ".1.3.6.1.4.1.17409.2.3.7.2.2.1.2", ISnmpConstant.STRING));
        initProperty(onuVlanTaggedPort, new SnmpMibBeanProperty(onuVlanTaggedPort, ".1.3.6.1.4.1.17409.2.3.7.2.2.1.3", ISnmpConstant.OCTETS));
        initProperty(onuVlanUntaggedPort, new SnmpMibBeanProperty(onuVlanUntaggedPort, ".1.3.6.1.4.1.17409.2.3.7.2.2.1.4", ISnmpConstant.OCTETS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.7.2.2.1.5", ISnmpConstant.INTEGER));

    }


    public Integer getOnuVlanIndex() {
        return (Integer) getIndex(0);
    }

    public void setOnuVlanIndex(Integer aOnuVlanIndex) {
        setIndex(0, aOnuVlanIndex);
    }


    public String getOnuVlanName() {
        return (String) getProperty(onuVlanName).getValue();
    }

    public void setOnuVlanName(String aOnuVlanName) {
        getProperty(onuVlanName).setValue(aOnuVlanName);
    }

    public byte[] getOnuVlanTaggedPort() {
        return (byte[]) getProperty(onuVlanTaggedPort).getValue();
    }

    public void setOnuVlanTaggedPort(byte[] aOnuVlanTaggedPort) {
        getProperty(onuVlanTaggedPort).setValue(aOnuVlanTaggedPort);
    }

    public byte[] getOnuVlanUntaggedPort() {
        return (byte[]) getProperty(onuVlanUntaggedPort).getValue();
    }

    public void setOnuVlanUntaggedPort(byte[] aOnuVlanUntaggedPort) {
        getProperty(onuVlanUntaggedPort).setValue(aOnuVlanUntaggedPort);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuVlanName));
        prepareRead(super.getProperty(onuVlanTaggedPort));
        prepareRead(super.getProperty(onuVlanUntaggedPort));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuVlanName));
        prepareRead(super.getProperty(onuVlanTaggedPort));
        prepareRead(super.getProperty(onuVlanUntaggedPort));


        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuVlanName));
        prepareSave(getProperty(onuVlanTaggedPort));
        prepareSave(getProperty(onuVlanUntaggedPort));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuVlanName));
        prepareSave(getProperty(onuVlanTaggedPort));
        prepareSave(getProperty(onuVlanUntaggedPort));
        
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

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OltVlanConfigTable class.
 * Created by QuickDVM
 */
public class OltVlanConfigTable extends SnmpMibBean {
    public static final String oltVlanIndex = "oltVlanIndex";
    public static final String oltVlanDeviceIndex = "oltVlanDeviceIndex";
    public static final String oltVlanName = "oltVlanName";
    public static final String taggedPort = "taggedPort";
    public static final String untaggedPort = "untaggedPort";
    //public static final String ROW_STATUS = "untaggedPort" ;

    public OltVlanConfigTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltVlanIndex, new SnmpMibBeanProperty(oltVlanIndex, ".1.3.6.1.4.1.17409.2.3.7.2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(oltVlanDeviceIndex, new SnmpMibBeanProperty(oltVlanDeviceIndex, ".1.3.6.1.4.1.17409.2.3.7.2.1.1.2", ISnmpConstant.INTEGER));
        initProperty(oltVlanName, new SnmpMibBeanProperty(oltVlanName, ".1.3.6.1.4.1.17409.2.3.7.2.1.1.3", ISnmpConstant.STRING));
        initProperty(taggedPort, new SnmpMibBeanProperty(taggedPort, ".1.3.6.1.4.1.17409.2.3.7.2.1.1.4", ISnmpConstant.OCTETS));
        initProperty(untaggedPort, new SnmpMibBeanProperty(untaggedPort, ".1.3.6.1.4.1.17409.2.3.7.2.1.1.5", ISnmpConstant.OCTETS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.7.2.1.1.6", ISnmpConstant.INTEGER));

    }


    public Integer getOltVlanIndex() {
        return (Integer) getIndex(0);
    }

    public void setOltVlanIndex(Integer aOltVlanIndex) {
        setIndex(0, aOltVlanIndex);
    }


    public Integer getOltVlanDeviceIndex() {
        return (Integer) getIndex(1);
    }

    public void setOltVlanDeviceIndex(Integer aOltVlanDeviceIndex) {
        setIndex(1, aOltVlanDeviceIndex);
    }


    public String getOltVlanName() {
        return (String) getProperty(oltVlanName).getValue();
    }

    public void setOltVlanName(String aOltVlanName) {
        getProperty(oltVlanName).setValue(aOltVlanName);
    }

    public byte[] getTaggedPort() {
        return (byte[]) getProperty(taggedPort).getValue();
    }

    public void setTaggedPort(byte[] aTaggedPort) {
        getProperty(taggedPort).setValue(aTaggedPort);
    }

    public byte[] getUntaggedPort() {
        return (byte[]) getProperty(untaggedPort).getValue();
    }

    public void setUntaggedPort(byte[] aUntaggedPort) {
        getProperty(untaggedPort).setValue(aUntaggedPort);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(oltVlanName));
        prepareRead(super.getProperty(taggedPort));
        prepareRead(super.getProperty(untaggedPort));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(oltVlanName));
        prepareRead(super.getProperty(taggedPort));
        prepareRead(super.getProperty(untaggedPort));


        return loadAll(new int[]{1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(oltVlanName));
        prepareSave(getProperty(taggedPort));
        prepareSave(getProperty(untaggedPort));

        super.setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean add() throws MibBeanException {

        prepareSave(getProperty(oltVlanName));
        prepareSave(getProperty(taggedPort));
        prepareSave(getProperty(untaggedPort));
        
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
package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class SniTrunkConfigTable extends SnmpMibBean {
    public static final String sniTrunkGroupConfigIndex = "sniTrunkGroupConfigIndex";
    public static final String sniTrunkGroupConfigName = "sniTrunkGroupConfigName";
    public static final String sniTrunkGroupConfigMember = "sniTrunkGroupConfigMember";
    public static final String sniTrunkGroupConfigPolicy = "sniTrunkGroupConfigPolicy";


    public SniTrunkConfigTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(sniTrunkGroupConfigIndex, new SnmpMibBeanProperty(sniTrunkGroupConfigIndex, ".1.3.6.1.4.1.17409.2.3.2.2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(sniTrunkGroupConfigName, new SnmpMibBeanProperty(sniTrunkGroupConfigName, ".1.3.6.1.4.1.17409.2.3.2.2.1.1.2", ISnmpConstant.STRING));
        initProperty(sniTrunkGroupConfigMember, new SnmpMibBeanProperty(sniTrunkGroupConfigMember, ".1.3.6.1.4.1.17409.2.3.2.2.1.1.3", ISnmpConstant.OCTETS));
        initProperty(sniTrunkGroupConfigPolicy, new SnmpMibBeanProperty(sniTrunkGroupConfigPolicy, ".1.3.6.1.4.1.17409.2.3.2.2.1.1.4", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.2.2.1.1.5", ISnmpConstant.INTEGER));
    }


    public Integer getSniTrunkGroupConfigIndex() {
        return (Integer) getIndex(0);
    }

    public void setSniTrunkGroupConfigIndex(Integer aSniTrunkGroupConfigIndex) {
        setIndex(0, aSniTrunkGroupConfigIndex);
    }


    public String getSniTrunkGroupConfigName() {
        return (String) getProperty(sniTrunkGroupConfigName).getValue();
    }

    public void setSniTrunkGroupConfigName(String aSniTrunkGroupConfigName) {
        getProperty(sniTrunkGroupConfigName).setValue(aSniTrunkGroupConfigName);
    }

    public byte[] getSniTrunkGroupConfigMember() {
        return (byte[]) getProperty(sniTrunkGroupConfigMember).getValue();
    }

    public void setSniTrunkGroupConfigMember(byte[] aSniTrunkGroupConfigMember) {
        getProperty(sniTrunkGroupConfigMember).setValue(aSniTrunkGroupConfigMember);
    }

    public Integer getSniTrunkGroupConfigPolicy() {
        return (Integer) getProperty(sniTrunkGroupConfigPolicy).getValue();
    }

    public void setSniTrunkGroupConfigPolicy(Integer aSniTrunkGroupConfigPolicy) {
        getProperty(sniTrunkGroupConfigPolicy).setValue(aSniTrunkGroupConfigPolicy);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(sniTrunkGroupConfigName));
        prepareRead(super.getProperty(sniTrunkGroupConfigMember));
        prepareRead(super.getProperty(sniTrunkGroupConfigPolicy));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(sniTrunkGroupConfigName));
        prepareRead(super.getProperty(sniTrunkGroupConfigMember));
        prepareRead(super.getProperty(sniTrunkGroupConfigPolicy));


        return loadAll(new int[]{1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(sniTrunkGroupConfigName));
        prepareSave(getProperty(sniTrunkGroupConfigMember));
        prepareSave(getProperty(sniTrunkGroupConfigPolicy));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(sniTrunkGroupConfigName));
        prepareSave(getProperty(sniTrunkGroupConfigMember));
        prepareSave(getProperty(sniTrunkGroupConfigPolicy));

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

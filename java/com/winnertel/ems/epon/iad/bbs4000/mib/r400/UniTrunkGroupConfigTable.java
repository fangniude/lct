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

public class UniTrunkGroupConfigTable extends SnmpMibBean {

    public static final String uniTrunkGroupConfigIndex = "uniTrunkGroupConfigIndex";
    public static final String uniTrunkGroupConfigName = "uniTrunkGroupConfigName";
    public static final String uniTrunkGroupConfigMember = "uniTrunkGroupConfigMember";
    public static final String uniTrunkGroupConfigPolicy = "uniTrunkGroupConfigPolicy";

    public UniTrunkGroupConfigTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniTrunkGroupConfigIndex, new SnmpMibBeanProperty(uniTrunkGroupConfigIndex, ".1.3.6.1.4.1.17409.2.3.5.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(uniTrunkGroupConfigName, new SnmpMibBeanProperty(uniTrunkGroupConfigName, ".1.3.6.1.4.1.17409.2.3.5.3.1.1.2", ISnmpConstant.STRING));
        initProperty(uniTrunkGroupConfigMember, new SnmpMibBeanProperty(uniTrunkGroupConfigMember, ".1.3.6.1.4.1.17409.2.3.5.3.1.1.3", ISnmpConstant.OCTETS));
        initProperty(uniTrunkGroupConfigPolicy, new SnmpMibBeanProperty(uniTrunkGroupConfigPolicy, ".1.3.6.1.4.1.17409.2.3.5.3.1.1.4", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.5.3.1.1.5", ISnmpConstant.INTEGER));
    }

    public Integer getUniTrunkGroupConfigIndex() {
        return (Integer) getIndex(0);
    }

    public void setUniTrunkGroupConfigIndex(Integer aUniTrunkGroupConfigIndex) {
        setIndex(0, aUniTrunkGroupConfigIndex);
    }

    public String getUniTrunkGroupConfigName() {
        return (String) getProperty(uniTrunkGroupConfigName).getValue();
    }

    public void setUniTrunkGroupConfigName(String aUniTrunkGroupConfigName) {
        getProperty(uniTrunkGroupConfigName).setValue(aUniTrunkGroupConfigName);
    }

    public byte[] getUniTrunkGroupConfigMember() {
        return (byte[]) getProperty(uniTrunkGroupConfigMember).getValue();
    }

    public void setUniTrunkGroupConfigMember(byte[] aUniTrunkGroupConfigMember) {
        getProperty(uniTrunkGroupConfigMember).setValue(aUniTrunkGroupConfigMember);
    }

    public Integer getUniTrunkGroupConfigPolicy() {
        return (Integer) getProperty(uniTrunkGroupConfigPolicy).getValue();
    }

    public void setUniTrunkGroupConfigPolicy(Integer aUniTrunkGroupConfigPolicy) {
        getProperty(uniTrunkGroupConfigPolicy).setValue(aUniTrunkGroupConfigPolicy);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniTrunkGroupConfigName));
        prepareRead(getProperty(uniTrunkGroupConfigMember));
        prepareRead(getProperty(uniTrunkGroupConfigPolicy));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(uniTrunkGroupConfigName));
        prepareRead(getProperty(uniTrunkGroupConfigMember));
        prepareRead(getProperty(uniTrunkGroupConfigPolicy));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniTrunkGroupConfigName));
        prepareSave(getProperty(uniTrunkGroupConfigMember));
        prepareSave(getProperty(uniTrunkGroupConfigPolicy));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(uniTrunkGroupConfigName));
        prepareSave(getProperty(uniTrunkGroupConfigMember));
        prepareSave(getProperty(uniTrunkGroupConfigPolicy));

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
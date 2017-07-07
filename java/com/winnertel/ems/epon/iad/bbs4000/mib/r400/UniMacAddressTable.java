/**
 * Created by Zhou Chao, 2010/5/7
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class UniMacAddressTable extends SnmpMibBean {

    public static final String uniMacAddrIndex = "uniMacAddrIndex";
    public static final String uniMacAddrVlanIdIndex = "uniMacAddrVlanIdIndex";
    public static final String uniMacAddrType = "uniMacAddrType";
    public static final String uniMacAddrPortId = "uniMacAddrPortId";

    public UniMacAddressTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniMacAddrIndex, new SnmpMibBeanProperty(uniMacAddrIndex, ".1.3.6.1.4.1.17409.2.3.5.2.2.1.1", ISnmpConstant.OCTETS));
        initProperty(uniMacAddrVlanIdIndex, new SnmpMibBeanProperty(uniMacAddrVlanIdIndex, ".1.3.6.1.4.1.17409.2.3.5.2.2.1.2", ISnmpConstant.INTEGER));
        initProperty(uniMacAddrType, new SnmpMibBeanProperty(uniMacAddrType, ".1.3.6.1.4.1.17409.2.3.5.2.2.1.3", ISnmpConstant.INTEGER));
        initProperty(uniMacAddrPortId, new SnmpMibBeanProperty(uniMacAddrPortId, ".1.3.6.1.4.1.17409.2.3.5.2.2.1.4", ISnmpConstant.OCTETS));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.5.2.2.1.5", ISnmpConstant.INTEGER));
    }

    public byte[] getUniMacAddrIndex() {
        return (byte[]) getIndex(0);
    }

    public void setUniMacAddrIndex(byte[] aUniMacAddrIndex) {
        setIndex(0, aUniMacAddrIndex);
    }

    public Integer getUniMacAddrVlanIdIndex() {
        return (Integer) getIndex(1);
    }

    public void setUniMacAddrVlanIdIndex(Integer aUniMacAddrVlanIdIndex) {
        setIndex(1, aUniMacAddrVlanIdIndex);
    }

    public Integer getUniMacAddrType() {
        return (Integer) getProperty(uniMacAddrType).getValue();
    }

    public void setUniMacAddrType(Integer aUniMacAddrType) {
        getProperty(uniMacAddrType).setValue(aUniMacAddrType);
    }

    public byte[] getUniMacAddrPortId() {
        return (byte[]) getProperty(uniMacAddrPortId).getValue();
    }

    public void setUniMacAddrPortId(byte[] aUniMacAddrPortId) {
        getProperty(uniMacAddrPortId).setValue(aUniMacAddrPortId);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniMacAddrType));
        prepareRead(getProperty(uniMacAddrPortId));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(uniMacAddrType));
        prepareRead(getProperty(uniMacAddrPortId));

        return loadAll(new int[]{6, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniMacAddrType));
        prepareSave(getProperty(uniMacAddrPortId));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(uniMacAddrType));
        prepareSave(getProperty(uniMacAddrPortId));
//        prepareSave(getProperty(uniMacAddrPortId));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}
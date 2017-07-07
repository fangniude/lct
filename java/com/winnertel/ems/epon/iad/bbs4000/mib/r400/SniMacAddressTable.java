package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The SniMacAddressTable class.
 * Created by QuickDVM
 */
public class SniMacAddressTable extends SnmpMibBean {
    public static final String sniMacAddrIndex = "sniMacAddrIndex";
    public static final String sniMacAddrVlanIdIndex = "sniMacAddrVlanIdIndex";
    public static final String sniMacAddrType = "sniMacAddrType";
    public static final String sniMacAddrPortId = "sniMacAddrPortId";


    public SniMacAddressTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(sniMacAddrIndex, new SnmpMibBeanProperty(sniMacAddrIndex, ".1.3.6.1.4.1.17409.2.3.2.4.2.1.1", ISnmpConstant.MAC_ADDRESS));
        initProperty(sniMacAddrVlanIdIndex, new SnmpMibBeanProperty(sniMacAddrVlanIdIndex, ".1.3.6.1.4.1.17409.2.3.2.4.2.1.2", ISnmpConstant.INTEGER));
        initProperty(sniMacAddrType, new SnmpMibBeanProperty(sniMacAddrType, ".1.3.6.1.4.1.17409.2.3.2.4.2.1.3", ISnmpConstant.INTEGER));
        initProperty(sniMacAddrPortId, new SnmpMibBeanProperty(sniMacAddrPortId, ".1.3.6.1.4.1.17409.2.3.2.4.2.1.4", ISnmpConstant.GAUGE));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.2.4.2.1.5", ISnmpConstant.INTEGER));

    }


    public byte[] getSniMacAddrIndex() {
        return (byte[]) getIndex(0);
    }

    public void setSniMacAddrIndex(byte[] aSniMacAddrIndex) {
        setIndex(0, aSniMacAddrIndex);
    }


    public Integer getSniMacAddrVlanIdIndex() {
        return (Integer) getIndex(1);
    }

    public void setSniMacAddrVlanIdIndex(Integer aSniMacAddrVlanIdIndex) {
        setIndex(1, aSniMacAddrVlanIdIndex);
    }


    public Integer getSniMacAddrType() {
        return (Integer) getProperty(sniMacAddrType).getValue();
    }

    public void setSniMacAddrType(Integer aSniMacAddrType) {
        getProperty(sniMacAddrType).setValue(aSniMacAddrType);
    }

    public Long getSniMacAddrPortId() {
        return (Long) getProperty(sniMacAddrPortId).getValue();
    }

    public void setSniMacAddrPortId(Long aSniMacAddrPortId) {
        getProperty(sniMacAddrPortId).setValue(aSniMacAddrPortId);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(sniMacAddrType));
        prepareRead(super.getProperty(sniMacAddrPortId));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(sniMacAddrType));
        prepareRead(super.getProperty(sniMacAddrPortId));


        return loadAll(new int[]{6, 1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(sniMacAddrType));
        prepareSave(getProperty(sniMacAddrPortId));


        return save();
    }


    public boolean add() throws MibBeanException {
        setSniMacAddrType(1);
        prepareSave(getProperty(sniMacAddrType));
        prepareSave(getProperty(sniMacAddrPortId));

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
    
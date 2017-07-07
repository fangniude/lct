package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The PortVlanTrunkTable class.
 * Created by QuickDVM
 */
public class PortVlanTrunkTable extends SnmpMibBean {
    public static final String trunkDeviceIndex = "trunkDeviceIndex";
    public static final String trunkCardIndex = "trunkCardIndex";
    public static final String trunkPortIndex = "trunkPortIndex";
    public static final String trunkVidList = "trunkVidList";


    public PortVlanTrunkTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(trunkDeviceIndex, new SnmpMibBeanProperty(trunkDeviceIndex, ".1.3.6.1.4.1.17409.2.3.7.3.4.1.1", ISnmpConstant.INTEGER));
        initProperty(trunkCardIndex, new SnmpMibBeanProperty(trunkCardIndex, ".1.3.6.1.4.1.17409.2.3.7.3.4.1.2", ISnmpConstant.INTEGER));
        initProperty(trunkPortIndex, new SnmpMibBeanProperty(trunkPortIndex, ".1.3.6.1.4.1.17409.2.3.7.3.4.1.3", ISnmpConstant.INTEGER));
        initProperty(trunkVidList, new SnmpMibBeanProperty(trunkVidList, ".1.3.6.1.4.1.17409.2.3.7.3.4.1.4", ISnmpConstant.OCTETS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.7.3.4.1.5", ISnmpConstant.INTEGER));

    }


    public Integer getTrunkDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setTrunkDeviceIndex(Integer aTrunkDeviceIndex) {
        setIndex(0, aTrunkDeviceIndex);
    }


    public Integer getTrunkCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setTrunkCardIndex(Integer aTrunkCardIndex) {
        setIndex(1, aTrunkCardIndex);
    }


    public Integer getTrunkPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setTrunkPortIndex(Integer aTrunkPortIndex) {
        setIndex(2, aTrunkPortIndex);
    }


    public byte[] getTrunkVidList() {
        return (byte[]) getProperty(trunkVidList).getValue();
    }

    public void setTrunkVidList(byte[] aTrunkVidList) {
        getProperty(trunkVidList).setValue(aTrunkVidList);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(trunkVidList));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(trunkVidList));


        return loadAll(new int[]{1
                , 1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(trunkVidList));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(trunkVidList));
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

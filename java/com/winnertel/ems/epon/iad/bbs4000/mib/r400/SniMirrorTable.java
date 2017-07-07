package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The SniMirrorTable class.
 * Created by QuickDVM
 */
public class SniMirrorTable extends SnmpMibBean {
    public static final String sniMirrorGroupIndex = "sniMirrorGroupIndex";
    public static final String sniMirrorGroupName = "sniMirrorGroupName";
    public static final String sniMirrorGroupDstPortList = "sniMirrorGroupDstPortList";
    public static final String sniMirrorGroupSrcInPortList = "sniMirrorGroupSrcInPortList";
    public static final String sniMirrorGroupSrcOutPortList = "sniMirrorGroupSrcOutPortList";


    public SniMirrorTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(sniMirrorGroupIndex, new SnmpMibBeanProperty(sniMirrorGroupIndex, ".1.3.6.1.4.1.17409.2.3.2.3.1.1", ISnmpConstant.INTEGER));
        initProperty(sniMirrorGroupName, new SnmpMibBeanProperty(sniMirrorGroupName, ".1.3.6.1.4.1.17409.2.3.2.3.1.2", ISnmpConstant.STRING));
        initProperty(sniMirrorGroupDstPortList, new SnmpMibBeanProperty(sniMirrorGroupDstPortList, ".1.3.6.1.4.1.17409.2.3.2.3.1.3", ISnmpConstant.OCTETS));
        initProperty(sniMirrorGroupSrcInPortList, new SnmpMibBeanProperty(sniMirrorGroupSrcInPortList, ".1.3.6.1.4.1.17409.2.3.2.3.1.4", ISnmpConstant.OCTETS));
        initProperty(sniMirrorGroupSrcOutPortList, new SnmpMibBeanProperty(sniMirrorGroupSrcOutPortList, ".1.3.6.1.4.1.17409.2.3.2.3.1.5", ISnmpConstant.OCTETS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.2.3.1.6", ISnmpConstant.INTEGER));

    }


    public Integer getSniMirrorGroupIndex() {
        return (Integer) getIndex(0);
    }

    public void setSniMirrorGroupIndex(Integer aSniMirrorGroupIndex) {
        setIndex(0, aSniMirrorGroupIndex);
    }


    public String getSniMirrorGroupName() {
        return (String) getProperty(sniMirrorGroupName).getValue();
    }

    public void setSniMirrorGroupName(String aSniMirrorGroupName) {
        getProperty(sniMirrorGroupName).setValue(aSniMirrorGroupName);
    }

    public byte[] getSniMirrorGroupDstPortList() {
        return (byte[]) getProperty(sniMirrorGroupDstPortList).getValue();
    }

    public void setSniMirrorGroupDstPortList(byte[] aSniMirrorGroupDstPortList) {
        getProperty(sniMirrorGroupDstPortList).setValue(aSniMirrorGroupDstPortList);
    }

    public byte[] getSniMirrorGroupSrcInPortList() {
        return (byte[]) getProperty(sniMirrorGroupSrcInPortList).getValue();
    }

    public void setSniMirrorGroupSrcInPortList(byte[] aSniMirrorGroupSrcInPortList) {
        getProperty(sniMirrorGroupSrcInPortList).setValue(aSniMirrorGroupSrcInPortList);
    }

    public byte[] getSniMirrorGroupSrcOutPortList() {
        return (byte[]) getProperty(sniMirrorGroupSrcOutPortList).getValue();
    }

    public void setSniMirrorGroupSrcOutPortList(byte[] aSniMirrorGroupSrcOutPortList) {
        getProperty(sniMirrorGroupSrcOutPortList).setValue(aSniMirrorGroupSrcOutPortList);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(sniMirrorGroupName));
        prepareRead(super.getProperty(sniMirrorGroupDstPortList));
        prepareRead(super.getProperty(sniMirrorGroupSrcInPortList));
        prepareRead(super.getProperty(sniMirrorGroupSrcOutPortList));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(sniMirrorGroupName));
        prepareRead(super.getProperty(sniMirrorGroupDstPortList));
        prepareRead(super.getProperty(sniMirrorGroupSrcInPortList));
        prepareRead(super.getProperty(sniMirrorGroupSrcOutPortList));


        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(sniMirrorGroupName));
        prepareSave(getProperty(sniMirrorGroupDstPortList));
        prepareSave(getProperty(sniMirrorGroupSrcInPortList));
        prepareSave(getProperty(sniMirrorGroupSrcOutPortList));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(sniMirrorGroupName));
        prepareSave(getProperty(sniMirrorGroupDstPortList));
        prepareSave(getProperty(sniMirrorGroupSrcInPortList));
        prepareSave(getProperty(sniMirrorGroupSrcOutPortList));

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
    
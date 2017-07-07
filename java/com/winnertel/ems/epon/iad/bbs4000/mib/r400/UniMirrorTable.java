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

public class UniMirrorTable extends SnmpMibBean {

    public static final String uniMirrorGroupIndex = "uniMirrorGroupIndex";
    public static final String uniMirrorGroupName = "uniMirrorGroupName";
    public static final String uniMirrorGroupDstPortList = "uniMirrorGroupDstPortList";
    public static final String uniMirrorGroupSrcInPortList = "uniMirrorGroupSrcInPortList";
    public static final String uniMirrorGroupSrcOutPortList = "uniMirrorGroupSrcOutPortList";

    public UniMirrorTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniMirrorGroupIndex, new SnmpMibBeanProperty(uniMirrorGroupIndex, ".1.3.6.1.4.1.17409.2.3.5.5.1.1", ISnmpConstant.INTEGER));
        initProperty(uniMirrorGroupName, new SnmpMibBeanProperty(uniMirrorGroupName, ".1.3.6.1.4.1.17409.2.3.5.5.1.2", ISnmpConstant.STRING));
        initProperty(uniMirrorGroupDstPortList, new SnmpMibBeanProperty(uniMirrorGroupDstPortList, ".1.3.6.1.4.1.17409.2.3.5.5.1.3", ISnmpConstant.OCTETS));
        initProperty(uniMirrorGroupSrcInPortList, new SnmpMibBeanProperty(uniMirrorGroupSrcInPortList, ".1.3.6.1.4.1.17409.2.3.5.5.1.4", ISnmpConstant.OCTETS));
        initProperty(uniMirrorGroupSrcOutPortList, new SnmpMibBeanProperty(uniMirrorGroupSrcOutPortList, ".1.3.6.1.4.1.17409.2.3.5.5.1.5", ISnmpConstant.OCTETS));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.5.5.1.6", ISnmpConstant.INTEGER));
    }

    public Integer getUniMirrorGroupIndex() {
        return (Integer) getIndex(0);
    }

    public void setUniMirrorGroupIndex(Integer aUniMirrorGroupIndex) {
        setIndex(0, aUniMirrorGroupIndex);
    }

    public String getUniMirrorGroupName() {
        return (String) getProperty(uniMirrorGroupName).getValue();
    }

    public void setUniMirrorGroupName(String aUniMirrorGroupName) {
        getProperty(uniMirrorGroupName).setValue(aUniMirrorGroupName);
    }

    public byte[] getUniMirrorGroupDstPortList() {
        return (byte[]) getProperty(uniMirrorGroupDstPortList).getValue();
    }

    public void setUniMirrorGroupDstPortList(byte[] aUniMirrorGroupDstPortList) {
        getProperty(uniMirrorGroupDstPortList).setValue(aUniMirrorGroupDstPortList);
    }

    public byte[] getUniMirrorGroupSrcInPortList() {
        return (byte[]) getProperty(uniMirrorGroupSrcInPortList).getValue();
    }

    public void setUniMirrorGroupSrcInPortList(byte[] aUniMirrorGroupSrcInPortList) {
        getProperty(uniMirrorGroupSrcInPortList).setValue(aUniMirrorGroupSrcInPortList);
    }

    public byte[] getUniMirrorGroupSrcOutPortList() {
        return (byte[]) getProperty(uniMirrorGroupSrcOutPortList).getValue();
    }

    public void setUniMirrorGroupSrcOutPortList(byte[] aUniMirrorGroupSrcOutPortList) {
        getProperty(uniMirrorGroupSrcOutPortList).setValue(aUniMirrorGroupSrcOutPortList);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniMirrorGroupName));
        prepareRead(getProperty(uniMirrorGroupDstPortList));
        prepareRead(getProperty(uniMirrorGroupSrcInPortList));
        prepareRead(getProperty(uniMirrorGroupSrcOutPortList));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(uniMirrorGroupName));
        prepareRead(getProperty(uniMirrorGroupDstPortList));
        prepareRead(getProperty(uniMirrorGroupSrcInPortList));
        prepareRead(getProperty(uniMirrorGroupSrcOutPortList));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniMirrorGroupName));
        prepareSave(getProperty(uniMirrorGroupDstPortList));
        prepareSave(getProperty(uniMirrorGroupSrcInPortList));
        prepareSave(getProperty(uniMirrorGroupSrcOutPortList));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(uniMirrorGroupName));
        prepareSave(getProperty(uniMirrorGroupDstPortList));
        prepareSave(getProperty(uniMirrorGroupSrcInPortList));
        prepareSave(getProperty(uniMirrorGroupSrcOutPortList));

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
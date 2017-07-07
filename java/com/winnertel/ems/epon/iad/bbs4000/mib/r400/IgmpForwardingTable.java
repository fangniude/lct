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

public class IgmpForwardingTable extends SnmpMibBean {

    public static final String groupDeviceIndex = "groupDeviceIndex";
    public static final String groupVlanIndex = "groupVlanIndex";
    public static final String groupMacAddress = "groupMacAddress";
    public static final String groupPortList = "groupPortList";

    public IgmpForwardingTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(groupDeviceIndex, new SnmpMibBeanProperty(groupDeviceIndex, ".1.3.6.1.4.1.17409.2.3.6.3.1.1", ISnmpConstant.INTEGER));
        initProperty(groupVlanIndex, new SnmpMibBeanProperty(groupVlanIndex, ".1.3.6.1.4.1.17409.2.3.6.3.1.2", ISnmpConstant.INTEGER));
        initProperty(groupMacAddress, new SnmpMibBeanProperty(groupMacAddress, ".1.3.6.1.4.1.17409.2.3.6.3.1.3", ISnmpConstant.MAC_ADDRESS));
        initProperty(groupPortList, new SnmpMibBeanProperty(groupPortList, ".1.3.6.1.4.1.17409.2.3.6.3.1.4", ISnmpConstant.OCTETS));
    }

    public Integer getGroupDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setGroupDeviceIndex(Integer aGroupDeviceIndex) {
        setIndex(0, aGroupDeviceIndex);
    }

    public Integer getGroupVlanIndex() {
        return (Integer) getIndex(1);
    }

    public void setGroupVlanIndex(Integer aGroupVlanIndex) {
        setIndex(1, aGroupVlanIndex);
    }

    public byte[] getGroupMacAddress() {
        return (byte[]) getIndex(2);
    }

    public void setGroupMacAddress(byte[] aGroupMacAddress) {
        setIndex(2, aGroupMacAddress);
    }

    public byte[] getGroupPortList() {
        return (byte[]) getProperty(groupPortList).getValue();
    }

    public void setGroupPortList(byte[] aGroupPortList) {
        getProperty(groupPortList).setValue(aGroupPortList);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(groupPortList));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(groupPortList));

        return loadAll(new int[]{1, 1, 6});
    }

}
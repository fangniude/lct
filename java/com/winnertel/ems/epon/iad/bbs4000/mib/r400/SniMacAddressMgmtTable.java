/**
 * Modified by Zhou Chao, 2010/5/31
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class SniMacAddressMgmtTable extends SnmpMibBean {

    public static final String sniMacAddressManagementDeviceIndex = "sniMacAddressManagementDeviceIndex";
    public static final String sniMacAddrTableAgingTime = "sniMacAddrTableAgingTime";
    public static final String sniMacAddrTableClear = "sniMacAddrTableClear";

    public SniMacAddressMgmtTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(sniMacAddressManagementDeviceIndex, new SnmpMibBeanProperty(sniMacAddressManagementDeviceIndex, ".1.3.6.1.4.1.17409.2.3.2.4.1.1.1", ISnmpConstant.INTEGER));
        initProperty(sniMacAddrTableAgingTime, new SnmpMibBeanProperty(sniMacAddrTableAgingTime, ".1.3.6.1.4.1.17409.2.3.2.4.1.1.2", ISnmpConstant.INTEGER));
        initProperty(sniMacAddrTableClear, new SnmpMibBeanProperty(sniMacAddrTableClear, ".1.3.6.1.4.1.17409.2.3.2.4.1.1.3", ISnmpConstant.INTEGER));
    }

    public Integer getSniMacAddressManagementDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setSniMacAddressManagementDeviceIndex(Integer aSniMacAddressManagementDeviceIndex) {
        setIndex(0, aSniMacAddressManagementDeviceIndex);
    }

    public Integer getSniMacAddrTableAgingTime() {
        return (Integer) getProperty(sniMacAddrTableAgingTime).getValue();
    }

    public void setSniMacAddrTableAgingTime(Integer aSniMacAddrTableAgingTime) {
        getProperty(sniMacAddrTableAgingTime).setValue(aSniMacAddrTableAgingTime);
    }

    public Integer getSniMacAddrTableClear() {
        return (Integer) getProperty(sniMacAddrTableClear).getValue();
    }

    public void setSniMacAddrTableClear(Integer aSniMacAddrTableClear) {
        getProperty(sniMacAddrTableClear).setValue(aSniMacAddrTableClear);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(sniMacAddrTableAgingTime));
        //prepareRead(getProperty(sniMacAddrTableClear));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(sniMacAddrTableAgingTime));
        //prepareRead(getProperty(sniMacAddrTableClear));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(sniMacAddrTableAgingTime));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setSniMacAddrTableClear(1); //allDynamic(1)
        prepareSave(getProperty(sniMacAddrTableClear));

        return save();
    }

}
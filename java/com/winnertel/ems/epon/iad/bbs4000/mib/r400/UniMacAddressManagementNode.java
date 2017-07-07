/**
 * Created by Zhou Chao, 2010/5/7
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class UniMacAddressManagementNode extends SnmpMibBean {

    public static final String uniMacAddrAgingTime = "uniMacAddrAgingTime";
    public static final String uniMacAddrClear = "uniMacAddrClear";

    public UniMacAddressManagementNode(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniMacAddrAgingTime, new SnmpMibBeanProperty(uniMacAddrAgingTime, ".1.3.6.1.4.1.17409.2.3.5.2.1.1", ISnmpConstant.INTEGER));
        initProperty(uniMacAddrClear, new SnmpMibBeanProperty(uniMacAddrClear, ".1.3.6.1.4.1.17409.2.3.5.2.1.2", ISnmpConstant.INTEGER));
    }

    public Integer getUniMacAddrAgingTime() {
        return (Integer) getProperty(uniMacAddrAgingTime).getValue();
    }

    public void setUniMacAddrAgingTime(Integer aUniMacAddrAgingTime) {
        getProperty(uniMacAddrAgingTime).setValue(aUniMacAddrAgingTime);
    }

    public Integer getUniMacAddrClear() {
        return (Integer) getProperty(uniMacAddrClear).getValue();
    }

    public void setUniMacAddrClear(Integer aUniMacAddrClear) {
        getProperty(uniMacAddrClear).setValue(aUniMacAddrClear);
    }

    public boolean clearDynamicMacAddress() throws MibBeanException {
        setUniMacAddrClear(1);
        prepareSave(getProperty(uniMacAddrClear));

        return save();
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniMacAddrAgingTime));
        //prepareRead(getProperty(uniMacAddrClear));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniMacAddrAgingTime));
        //prepareSave(getProperty(uniMacAddrClear));

        return save();
    }

}
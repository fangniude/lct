/**
 * Created by Zhou Chao, 2009/7/29
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r216;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuStatusWoOamTable extends SnmpMibBean {

    public static final String utsOnuSlotId = "utsOnuSlotId";
    public static final String utsOnuPortId = "utsOnuPortId";
    public static final String utsOnuLogicalPortId = "utsOnuLogicalPortId";
    public static final String utsOnuRegistrationStatus = "utsOnuRegistrationStatus";

    public OnuStatusWoOamTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsOnuSlotId, new SnmpMibBeanProperty(utsOnuSlotId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsOnuPortId, new SnmpMibBeanProperty(utsOnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsOnuLogicalPortId, new SnmpMibBeanProperty(utsOnuLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsOnuRegistrationStatus, new SnmpMibBeanProperty(utsOnuRegistrationStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.2.1.1", ISnmpConstant.INTEGER));
    }

    public Integer getUtsOnuSlotId() {
        return (Integer) getIndex(0);
    }

    public void setUtsOnuSlotId(Integer aUtsOnuSlotId) {
        setIndex(0, aUtsOnuSlotId);
    }

    public Integer getUtsOnuPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsOnuPortId(Integer aUtsOnuPortId) {
        setIndex(1, aUtsOnuPortId);
    }

    public Integer getUtsOnuLogicalPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsOnuLogicalPortId(Integer aUtsOnuLogicalPortId) {
        setIndex(2, aUtsOnuLogicalPortId);
    }

    public Integer getUtsOnuRegistrationStatus() {
        return (Integer) getProperty(utsOnuRegistrationStatus).getValue();
    }

    public void setUtsOnuRegistrationStatus(Integer aUtsOnuRegistrationStatus) {
        getProperty(utsOnuRegistrationStatus).setValue(aUtsOnuRegistrationStatus);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsOnuRegistrationStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsOnuRegistrationStatus));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsOnuRegistrationStatus));

        return save();
    }

    public String toString() {
        return new StringBuffer().append(getUtsOnuSlotId()).append("-").append(getUtsOnuPortId()).append("-").append(getUtsOnuLogicalPortId()).toString();
    }

}
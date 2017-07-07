package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class SniTrunkTable extends SnmpMibBean {
    public static final String sniTrunkGroupIndex = "sniTrunkGroupIndex";
    public static final String sniTrunkGroupOperationStatus = "sniTrunkGroupOperationStatus";
    public static final String sniTrunkGroupActualSpeed = "sniTrunkGroupActualSpeed";
    public static final String sniTrunkGroupAdminStatus = "sniTrunkGroupAdminStatus";

    public SniTrunkTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(sniTrunkGroupIndex, new SnmpMibBeanProperty(sniTrunkGroupIndex, ".1.3.6.1.4.1.17409.2.3.2.2.2.1.1", ISnmpConstant.INTEGER));
        initProperty(sniTrunkGroupOperationStatus, new SnmpMibBeanProperty(sniTrunkGroupOperationStatus, ".1.3.6.1.4.1.17409.2.3.2.2.2.1.2", ISnmpConstant.INTEGER));
        initProperty(sniTrunkGroupActualSpeed, new SnmpMibBeanProperty(sniTrunkGroupActualSpeed, ".1.3.6.1.4.1.17409.2.3.2.2.2.1.3", ISnmpConstant.INTEGER));
        initProperty(sniTrunkGroupAdminStatus, new SnmpMibBeanProperty(sniTrunkGroupAdminStatus, ".1.3.6.1.4.1.17409.2.3.2.2.2.1.4", ISnmpConstant.INTEGER));

    }


    public Integer getSniTrunkGroupIndex() {
        return (Integer) getIndex(0);
    }

    public void setSniTrunkGroupIndex(Integer aSniTrunkGroupIndex) {
        setIndex(0, aSniTrunkGroupIndex);
    }


    public Integer getSniTrunkGroupOperationStatus() {
        return (Integer) getProperty(sniTrunkGroupOperationStatus).getValue();
    }

    public void setSniTrunkGroupOperationStatus(Integer aSniTrunkGroupOperationStatus) {
        getProperty(sniTrunkGroupOperationStatus).setValue(aSniTrunkGroupOperationStatus);
    }

    public Integer getSniTrunkGroupActualSpeed() {
        return (Integer) getProperty(sniTrunkGroupActualSpeed).getValue();
    }

    public void setSniTrunkGroupActualSpeed(Integer aSniTrunkGroupActualSpeed) {
        getProperty(sniTrunkGroupActualSpeed).setValue(aSniTrunkGroupActualSpeed);
    }

    public Integer getSniTrunkGroupAdminStatus() {
        return (Integer) getProperty(sniTrunkGroupAdminStatus).getValue();
    }

    public void setSniTrunkGroupAdminStatus(Integer aSniTrunkGroupAdminStatus) {
        getProperty(sniTrunkGroupAdminStatus).setValue(aSniTrunkGroupAdminStatus);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(sniTrunkGroupOperationStatus));
        prepareRead(super.getProperty(sniTrunkGroupActualSpeed));
        prepareRead(super.getProperty(sniTrunkGroupAdminStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(sniTrunkGroupOperationStatus));
        prepareRead(super.getProperty(sniTrunkGroupActualSpeed));
        prepareRead(super.getProperty(sniTrunkGroupAdminStatus));

        return loadAll(new int[]{1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(sniTrunkGroupAdminStatus));

        return save();
    }


}

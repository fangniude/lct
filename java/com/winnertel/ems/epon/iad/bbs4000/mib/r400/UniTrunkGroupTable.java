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

public class UniTrunkGroupTable extends SnmpMibBean {

    public static final String uniTrunkGroupIndex = "uniTrunkGroupIndex";
    public static final String uniTrunkGroupOperationStatus = "uniTrunkGroupOperationStatus";
    public static final String uniTrunkGroupActualSpeed = "uniTrunkGroupActualSpeed";
    public static final String uniTrunkGroupAdminStatus = "uniTrunkGroupAdminStatus";

    public UniTrunkGroupTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniTrunkGroupIndex, new SnmpMibBeanProperty(uniTrunkGroupIndex, ".1.3.6.1.4.1.17409.2.3.5.3.2.1.1", ISnmpConstant.INTEGER));
        initProperty(uniTrunkGroupOperationStatus, new SnmpMibBeanProperty(uniTrunkGroupOperationStatus, ".1.3.6.1.4.1.17409.2.3.5.3.2.1.2", ISnmpConstant.INTEGER));
        initProperty(uniTrunkGroupActualSpeed, new SnmpMibBeanProperty(uniTrunkGroupActualSpeed, ".1.3.6.1.4.1.17409.2.3.5.3.2.1.3", ISnmpConstant.INTEGER));
        initProperty(uniTrunkGroupAdminStatus, new SnmpMibBeanProperty(uniTrunkGroupAdminStatus, ".1.3.6.1.4.1.17409.2.3.5.3.2.1.4", ISnmpConstant.INTEGER));
    }

    public Integer getUniTrunkGroupIndex() {
        return (Integer) getIndex(0);
    }

    public void setUniTrunkGroupIndex(Integer aUniTrunkGroupIndex) {
        setIndex(0, aUniTrunkGroupIndex);
    }

    public Integer getUniTrunkGroupOperationStatus() {
        return (Integer) getProperty(uniTrunkGroupOperationStatus).getValue();
    }

    public void setUniTrunkGroupOperationStatus(Integer aUniTrunkGroupOperationStatus) {
        getProperty(uniTrunkGroupOperationStatus).setValue(aUniTrunkGroupOperationStatus);
    }

    public Integer getUniTrunkGroupActualSpeed() {
        return (Integer) getProperty(uniTrunkGroupActualSpeed).getValue();
    }

    public void setUniTrunkGroupActualSpeed(Integer aUniTrunkGroupActualSpeed) {
        getProperty(uniTrunkGroupActualSpeed).setValue(aUniTrunkGroupActualSpeed);
    }

    public Integer getUniTrunkGroupAdminStatus() {
        return (Integer) getProperty(uniTrunkGroupAdminStatus).getValue();
    }

    public void setUniTrunkGroupAdminStatus(Integer aUniTrunkGroupAdminStatus) {
        getProperty(uniTrunkGroupAdminStatus).setValue(aUniTrunkGroupAdminStatus);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniTrunkGroupOperationStatus));
        prepareRead(getProperty(uniTrunkGroupActualSpeed));
        prepareRead(getProperty(uniTrunkGroupAdminStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(uniTrunkGroupOperationStatus));
        prepareRead(getProperty(uniTrunkGroupActualSpeed));
        prepareRead(getProperty(uniTrunkGroupAdminStatus));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniTrunkGroupAdminStatus));

        return save();
    }

}
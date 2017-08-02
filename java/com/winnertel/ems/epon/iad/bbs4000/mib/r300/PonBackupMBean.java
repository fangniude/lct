/**
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class PonBackupMBean extends SnmpMibBean {

    public static final String utsSrcPonModuleId = "utsSrcPonModuleId";
    public static final String utsSrcPonPortId = "utsSrcPonPortId";
    public static final String utsBackupPonModuleId = "utsBackupPonModuleId";
    public static final String utsBackupPonPortId = "utsBackupPonPortId";

    public PonBackupMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsSrcPonModuleId, new SnmpMibBeanProperty(utsSrcPonModuleId, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.12.1", ISnmpConstant.INTEGER));
        initProperty(utsSrcPonPortId, new SnmpMibBeanProperty(utsSrcPonPortId, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.12.2", ISnmpConstant.INTEGER));
        initProperty(utsBackupPonModuleId, new SnmpMibBeanProperty(utsBackupPonModuleId, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.12.3", ISnmpConstant.INTEGER));
        initProperty(utsBackupPonPortId, new SnmpMibBeanProperty(utsBackupPonPortId, ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.4.1.12.4", ISnmpConstant.INTEGER));
    }

    public Integer getUtsSrcPonModuleId() {
        return (Integer) getProperty(utsSrcPonModuleId).getValue();
    }

    public void setUtsSrcPonModuleId(Integer aUtsSrcPonModuleId) {
        getProperty(utsSrcPonModuleId).setValue(aUtsSrcPonModuleId);
    }

    public Integer getUtsSrcPonPortId() {
        return (Integer) getProperty(utsSrcPonPortId).getValue();
    }

    public void setUtsSrcPonPortId(Integer aUtsSrcPonPortId) {
        getProperty(utsSrcPonPortId).setValue(aUtsSrcPonPortId);
    }

    public Integer getUtsBackupPonModuleId() {
        return (Integer) getProperty(utsBackupPonModuleId).getValue();
    }

    public void setUtsBackupPonModuleId(Integer aUtsBackupPonModuleId) {
        getProperty(utsBackupPonModuleId).setValue(aUtsBackupPonModuleId);
    }

    public Integer getUtsBackupPonPortId() {
        return (Integer) getProperty(utsBackupPonPortId).getValue();
    }

    public void setUtsBackupPonPortId(Integer aUtsBackupPonPortId) {
        getProperty(utsBackupPonPortId).setValue(aUtsBackupPonPortId);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsSrcPonModuleId));
        prepareRead(getProperty(utsSrcPonPortId));
        prepareRead(getProperty(utsBackupPonModuleId));
        prepareRead(getProperty(utsBackupPonPortId));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsSrcPonModuleId));
        prepareSave(getProperty(utsSrcPonPortId));
        prepareSave(getProperty(utsBackupPonModuleId));
        prepareSave(getProperty(utsBackupPonPortId));

        return save();
    }

}
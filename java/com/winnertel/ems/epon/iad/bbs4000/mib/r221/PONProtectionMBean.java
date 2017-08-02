package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PONProtectionMBean extends SnmpMibBean {

    public static final String utsPonTrunckProtectionGroupId = "utsPonTrunckProtectionGroupId";
    public static final String utsPonTrunckProtectionName = "utsPonTrunckProtectionName";
    //public static final String utsPonTrunckProtectionPort1ModuleId = "utsPonTrunckProtectionPort1ModuleId";
    //public static final String utsPonTrunckProtectionPort1DeviceId = "utsPonTrunckProtectionPort1DeviceId";
    public static final String utsPonTrunckProtectionPort1PortId = "utsPonTrunckProtectionPort1PortId";
    //public static final String utsPonTrunckProtectionPort2ModuleId = "utsPonTrunckProtectionPort2ModuleId";
    //public static final String utsPonTrunckProtectionPort2DeviceId = "utsPonTrunckProtectionPort2DeviceId";
    public static final String utsPonTrunckProtectionPort2PortId = "utsPonTrunckProtectionPort2PortId";
    public static final String utsPonTrunckProtectionPort1Status = "utsPonTrunckProtectionPort1Status";
    public static final String utsPonTrunckProtectionPort2Status = "utsPonTrunckProtectionPort2Status";
    public static final String utsPonTrunckProtectionPortSwitchOver = "utsPonTrunckProtectionPortSwitchOver";
    public static final String utsPonTrunckProtectionPortSwitchOverResult = "utsPonTrunckProtectionPortSwitchOverResult";
    public static final String utsPonTrunckProtectionRowStatus = "utsPonTrunckProtectionRowStatus";
    public static final String utsPonTrunckProtectionMode = "utsPonTrunckProtectionMode";

    public PONProtectionMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsPonTrunckProtectionGroupId, new SnmpMibBeanProperty(utsPonTrunckProtectionGroupId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.1", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionName, new SnmpMibBeanProperty(utsPonTrunckProtectionName, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.2", ISnmpConstant.STRING));
        //initProperty(utsPonTrunckProtectionPort1ModuleId, new SnmpMibBeanProperty(utsPonTrunckProtectionPort1ModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.3", ISnmpConstant.INTEGER));
        //initProperty(utsPonTrunckProtectionPort1DeviceId, new SnmpMibBeanProperty(utsPonTrunckProtectionPort1DeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.4", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionPort1PortId, new SnmpMibBeanProperty(utsPonTrunckProtectionPort1PortId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.5", ISnmpConstant.INTEGER));
        //initProperty(utsPonTrunckProtectionPort2ModuleId, new SnmpMibBeanProperty(utsPonTrunckProtectionPort2ModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.6", ISnmpConstant.INTEGER));
        //initProperty(utsPonTrunckProtectionPort2DeviceId, new SnmpMibBeanProperty(utsPonTrunckProtectionPort2DeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.7", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionPort2PortId, new SnmpMibBeanProperty(utsPonTrunckProtectionPort2PortId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.8", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionPort1Status, new SnmpMibBeanProperty(utsPonTrunckProtectionPort1Status, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.9", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionPort2Status, new SnmpMibBeanProperty(utsPonTrunckProtectionPort2Status, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.10", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionPortSwitchOver, new SnmpMibBeanProperty(utsPonTrunckProtectionPortSwitchOver, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.11", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionPortSwitchOverResult, new SnmpMibBeanProperty(utsPonTrunckProtectionPortSwitchOverResult, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.12", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionMode, new SnmpMibBeanProperty(utsPonTrunckProtectionMode, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.13", ISnmpConstant.INTEGER));
        initProperty(utsPonTrunckProtectionRowStatus, new SnmpMibBeanProperty(utsPonTrunckProtectionRowStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.12.1.15", ISnmpConstant.INTEGER));
    }

    public Integer getUtsPonTrunckProtectionGroupId() {
        return (Integer) getIndex(0);
    }

    public void setUtsPonTrunckProtectionGroupId(Integer aUtsPonTrunckProtectionGroupId) {
        setIndex(0, aUtsPonTrunckProtectionGroupId);
    }

    public String getUtsPonTrunckProtectionName() {
        return (String) getProperty(utsPonTrunckProtectionName).getValue();
    }

    public void setUtsPonTrunckProtectionName(String aUtsPonTrunckProtectionName) {
        getProperty(utsPonTrunckProtectionName).setValue(aUtsPonTrunckProtectionName);
    }

    /*
	public Integer getUtsPonTrunckProtectionPort1ModuleId() {
		return (Integer) getProperty(utsPonTrunckProtectionPort1ModuleId).getValue();
	}

	public void setUtsPonTrunckProtectionPort1ModuleId(Integer aUtsPonTrunckProtectionPort1ModuleId) {
		getProperty(utsPonTrunckProtectionPort1ModuleId).setValue(aUtsPonTrunckProtectionPort1ModuleId);
	}

	public Integer getUtsPonTrunckProtectionPort1DeviceId() {
		return (Integer) getProperty(utsPonTrunckProtectionPort1DeviceId).getValue();
	}

	public void setUtsPonTrunckProtectionPort1DeviceId(Integer aUtsPonTrunckProtectionPort1DeviceId) {
		getProperty(utsPonTrunckProtectionPort1DeviceId).setValue(aUtsPonTrunckProtectionPort1DeviceId);
	}
    */

    public String getUtsPonTrunckProtectionPort1PortId() {
        int id = getUtsPonTrunckProtectionGroupId();

        int card = (id + 1) / 2;
        int port = (id + 1) % 2 * 2 + 1;

        return card + "/" + port;
    }

    public void setUtsPonTrunckProtectionPort1PortId(String aUtsPonTrunckProtectionPort1PortId) {
        getProperty(utsPonTrunckProtectionPort1PortId).setValue(aUtsPonTrunckProtectionPort1PortId);
    }

    /*
	public Integer getUtsPonTrunckProtectionPort2ModuleId() {
		return (Integer) getProperty(utsPonTrunckProtectionPort2ModuleId).getValue();
	}

	public void setUtsPonTrunckProtectionPort2ModuleId(Integer aUtsPonTrunckProtectionPort2ModuleId) {
		getProperty(utsPonTrunckProtectionPort2ModuleId).setValue(aUtsPonTrunckProtectionPort2ModuleId);
	}

	public Integer getUtsPonTrunckProtectionPort2DeviceId() {
		return (Integer) getProperty(utsPonTrunckProtectionPort2DeviceId).getValue();
	}

	public void setUtsPonTrunckProtectionPort2DeviceId(Integer aUtsPonTrunckProtectionPort2DeviceId) {
		getProperty(utsPonTrunckProtectionPort2DeviceId).setValue(aUtsPonTrunckProtectionPort2DeviceId);
	}
    */

    public String getUtsPonTrunckProtectionPort2PortId() {
        int id = getUtsPonTrunckProtectionGroupId();

        int card = (id + 1) / 2;
        int port = (id + 1) % 2 * 2 + 2;

        return card + "/" + port;
    }

    public void setUtsPonTrunckProtectionPort2PortId(String aUtsPonTrunckProtectionPort2PortId) {
        getProperty(utsPonTrunckProtectionPort2PortId).setValue(aUtsPonTrunckProtectionPort2PortId);
    }

    public Integer getUtsPonTrunckProtectionPort1Status() {
        return (Integer) getProperty(utsPonTrunckProtectionPort1Status).getValue();
    }

    public void setUtsPonTrunckProtectionPort1Status(Integer aUtsPonTrunckProtectionPort1Status) {
        getProperty(utsPonTrunckProtectionPort1Status).setValue(aUtsPonTrunckProtectionPort1Status);
    }

    public Integer getUtsPonTrunckProtectionPort2Status() {
        return (Integer) getProperty(utsPonTrunckProtectionPort2Status).getValue();
    }

    public void setUtsPonTrunckProtectionPort2Status(Integer aUtsPonTrunckProtectionPort2Status) {
        getProperty(utsPonTrunckProtectionPort2Status).setValue(aUtsPonTrunckProtectionPort2Status);
    }

    public Integer getUtsPonTrunckProtectionPortSwitchOver() {
        return (Integer) getProperty(utsPonTrunckProtectionPortSwitchOver).getValue();
    }

    public void setUtsPonTrunckProtectionPortSwitchOver(Integer aUtsPonTrunckProtectionPortSwitchOver) {
        getProperty(utsPonTrunckProtectionPortSwitchOver).setValue(aUtsPonTrunckProtectionPortSwitchOver);
    }

    public Integer getUtsPonTrunckProtectionPortSwitchOverResult() {
        return (Integer) getProperty(utsPonTrunckProtectionPortSwitchOverResult).getValue();
    }

    public void setUtsPonTrunckProtectionPortSwitchOverResult(Integer aUtsPonTrunckProtectionPortSwitchOverResult) {
        getProperty(utsPonTrunckProtectionPortSwitchOverResult).setValue(aUtsPonTrunckProtectionPortSwitchOverResult);
    }

    public Integer getUtsPonTrunckProtectionRowStatus() {
        return (Integer) getProperty(utsPonTrunckProtectionRowStatus).getValue();
    }

    public void setUtsPonTrunckProtectionRowStatus(Integer aUtsPonTrunckProtectionRowStatus) {
        getProperty(utsPonTrunckProtectionRowStatus).setValue(aUtsPonTrunckProtectionRowStatus);
    }

    public Integer getUtsPonTrunckProtectionMode() {
        return (Integer)getProperty(utsPonTrunckProtectionMode).getValue();
    }

    public void setUtsPonTrunckProtectionMode(Integer aUtsPonTrunckProtectionMode) {
        getProperty(utsPonTrunckProtectionMode).setValue(aUtsPonTrunckProtectionMode);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsPonTrunckProtectionName));
        //prepareRead(getProperty(utsPonTrunckProtectionPort1ModuleId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort1DeviceId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort1PortId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort2ModuleId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort2DeviceId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort2PortId));
        prepareRead(getProperty(utsPonTrunckProtectionPort1Status));
        prepareRead(getProperty(utsPonTrunckProtectionPort2Status));
        //prepareRead(getProperty(utsPonTrunckProtectionPortSwitchOver));
        prepareRead(getProperty(utsPonTrunckProtectionPortSwitchOverResult));
        prepareRead(getProperty(utsPonTrunckProtectionMode));
        prepareRead(getProperty(utsPonTrunckProtectionRowStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsPonTrunckProtectionName));
        //prepareRead(getProperty(utsPonTrunckProtectionPort1ModuleId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort1DeviceId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort1PortId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort2ModuleId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort2DeviceId));
        //prepareRead(getProperty(utsPonTrunckProtectionPort2PortId));
        prepareRead(getProperty(utsPonTrunckProtectionPort1Status));
        prepareRead(getProperty(utsPonTrunckProtectionPort2Status));
        //prepareRead(getProperty(utsPonTrunckProtectionPortSwitchOver));
        prepareRead(getProperty(utsPonTrunckProtectionPortSwitchOverResult));
        prepareRead(getProperty(utsPonTrunckProtectionMode));
        prepareRead(getProperty(utsPonTrunckProtectionRowStatus));

        return loadAll(new int[]{1});
    }

    public boolean switchOver() throws MibBeanException {
        setUtsPonTrunckProtectionPortSwitchOver(1);
        prepareSave(getProperty(utsPonTrunckProtectionPortSwitchOver));

        return save();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsPonTrunckProtectionName));
        //prepareSave(getProperty(utsPonTrunckProtectionPort1ModuleId));
        //prepareSave(getProperty(utsPonTrunckProtectionPort1DeviceId));
        //prepareSave(getProperty(utsPonTrunckProtectionPort1PortId));
        //prepareSave(getProperty(utsPonTrunckProtectionPort2ModuleId));
        //prepareSave(getProperty(utsPonTrunckProtectionPort2DeviceId));
        //prepareSave(getProperty(utsPonTrunckProtectionPort2PortId));
        //prepareSave(getProperty(utsPonTrunckProtectionPortSwitchOver));
        prepareSave(getProperty(utsPonTrunckProtectionRowStatus));

        return save();
    }

}
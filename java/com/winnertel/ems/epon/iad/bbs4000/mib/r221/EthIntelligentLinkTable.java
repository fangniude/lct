package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EthIntelligentLinkTable extends SnmpMibBean {
    public static final String utsEthIntelligentLinkGroupId = "utsEthIntelligentLinkGroupId";
    public static final String utsEthIntelligentLinkGroupName = "utsEthIntelligentLinkGroupName";
    public static final String utsEthIntelligentLinkMasterPortType = "utsEthIntelligentLinkMasterPortType";
    public static final String utsEthIntelligentLinkMasterPortModuleId = "utsEthIntelligentLinkMasterPortModuleId";
    public static final String utsEthIntelligentLinkMasterPortDeviceId = "utsEthIntelligentLinkMasterPortDeviceId";
    public static final String utsEthIntelligentLinkMasterPortPortId = "utsEthIntelligentLinkMasterPortPortId";
    public static final String utsEthIntelligentLinkMasterLinkAggGroupId = "utsEthIntelligentLinkMasterLinkAggGroupId";
    public static final String utsEthIntelligentLinkSlavePortType = "utsEthIntelligentLinkSlavePortType";
    public static final String utsEthIntelligentLinkSlavePortModuleId = "utsEthIntelligentLinkSlavePortModuleId";
    public static final String utsEthIntelligentLinkSlavePortDeviceId = "utsEthIntelligentLinkSlavePortDeviceId";
    public static final String utsEthIntelligentLinkSlavePortPortId = "utsEthIntelligentLinkSlavePortPortId";
    public static final String utsEthIntelligentLinkSlaveLinkAggGroupId = "utsEthIntelligentLinkSlaveLinkAggGroupId";
    public static final String utsEthIntelligentLinkMasterPortStatus = "utsEthIntelligentLinkMasterPortStatus";
    public static final String utsEthIntelligentLinkSlavePortStatus = "utsEthIntelligentLinkSlavePortStatus";

    public static final String utsEthIntelligentLinkAutoReturn = "utsEthIntelligentLinkAutoReturn";
    public static final String utsEthIntelligentLinkAutoWtr = "utsEthIntelligentLinkAutoWtr";
    public static final String utsEthIntelligentLinkReturnToMaster = "utsEthIntelligentLinkReturnToMaster";

    public EthIntelligentLinkTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsEthIntelligentLinkGroupId, new SnmpMibBeanProperty(utsEthIntelligentLinkGroupId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.1", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkGroupName, new SnmpMibBeanProperty(utsEthIntelligentLinkGroupName, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.2", ISnmpConstant.STRING));
        initProperty(utsEthIntelligentLinkMasterPortType, new SnmpMibBeanProperty(utsEthIntelligentLinkMasterPortType, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.3", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkMasterPortModuleId, new SnmpMibBeanProperty(utsEthIntelligentLinkMasterPortModuleId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.4", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkMasterPortDeviceId, new SnmpMibBeanProperty(utsEthIntelligentLinkMasterPortDeviceId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.5", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkMasterPortPortId, new SnmpMibBeanProperty(utsEthIntelligentLinkMasterPortPortId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.6", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkMasterLinkAggGroupId, new SnmpMibBeanProperty(utsEthIntelligentLinkMasterLinkAggGroupId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.7", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkSlavePortType, new SnmpMibBeanProperty(utsEthIntelligentLinkSlavePortType, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.8", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkSlavePortModuleId, new SnmpMibBeanProperty(utsEthIntelligentLinkSlavePortModuleId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.9", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkSlavePortDeviceId, new SnmpMibBeanProperty(utsEthIntelligentLinkSlavePortDeviceId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.10", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkSlavePortPortId, new SnmpMibBeanProperty(utsEthIntelligentLinkSlavePortPortId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.11", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkSlaveLinkAggGroupId, new SnmpMibBeanProperty(utsEthIntelligentLinkSlaveLinkAggGroupId, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.12", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkMasterPortStatus, new SnmpMibBeanProperty(utsEthIntelligentLinkMasterPortStatus, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.13", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkSlavePortStatus, new SnmpMibBeanProperty(utsEthIntelligentLinkSlavePortStatus, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.14", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.15", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkAutoReturn, new SnmpMibBeanProperty(utsEthIntelligentLinkAutoReturn, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.16", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkAutoWtr, new SnmpMibBeanProperty(utsEthIntelligentLinkAutoWtr, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.17", ISnmpConstant.INTEGER));
        initProperty(utsEthIntelligentLinkReturnToMaster, new SnmpMibBeanProperty(utsEthIntelligentLinkReturnToMaster, ".1.3.6.1.4.1.41355.1800.2.2.1.15.1.18", ISnmpConstant.INTEGER));
    }

    public Integer getUtsEthIntelligentLinkGroupId() {
        return (Integer) getIndex(0);
    }

    public void setUtsEthIntelligentLinkGroupId(Integer aUtsEthIntelligentLinkGroupId) {
        setIndex(0, aUtsEthIntelligentLinkGroupId);
    }

    public String getUtsEthIntelligentLinkGroupName() {
        return ((String) getProperty(utsEthIntelligentLinkGroupName).getValue()).trim();
    }

    public void setUtsEthIntelligentLinkGroupName(String aUtsEthIntelligentLinkGroupName) {
    	String s = "                ";
    	if(aUtsEthIntelligentLinkGroupName == null) {
    		getProperty(utsEthIntelligentLinkGroupName).setValue(s);
    	}
    	else {
    		getProperty(utsEthIntelligentLinkGroupName).setValue((aUtsEthIntelligentLinkGroupName + s).substring(0, 16));
    	}
    }

    public Integer getUtsEthIntelligentLinkMasterPortType() {
        return (Integer) getProperty(utsEthIntelligentLinkMasterPortType).getValue();
    }

    public void setUtsEthIntelligentLinkMasterPortType(Integer aUtsEthIntelligentLinkMasterPortType) {
        getProperty(utsEthIntelligentLinkMasterPortType).setValue(aUtsEthIntelligentLinkMasterPortType);
    }

    public Integer getUtsEthIntelligentLinkMasterPortModuleId() {
        return (Integer) getProperty(utsEthIntelligentLinkMasterPortModuleId).getValue();
    }

    public void setUtsEthIntelligentLinkMasterPortModuleId(Integer aUtsEthIntelligentLinkMasterPortModuleId) {
        getProperty(utsEthIntelligentLinkMasterPortModuleId).setValue(aUtsEthIntelligentLinkMasterPortModuleId);
    }

    public Integer getUtsEthIntelligentLinkMasterPortDeviceId() {
        return (Integer) getProperty(utsEthIntelligentLinkMasterPortDeviceId).getValue();
    }

    public void setUtsEthIntelligentLinkMasterPortDeviceId(Integer aUtsEthIntelligentLinkMasterPortDeviceId) {
        getProperty(utsEthIntelligentLinkMasterPortDeviceId).setValue(aUtsEthIntelligentLinkMasterPortDeviceId);
    }

    public Integer getUtsEthIntelligentLinkMasterPortPortId() {
        return (Integer) getProperty(utsEthIntelligentLinkMasterPortPortId).getValue();
    }

    public void setUtsEthIntelligentLinkMasterPortPortId(Integer aUtsEthIntelligentLinkMasterPortPortId) {
        getProperty(utsEthIntelligentLinkMasterPortPortId).setValue(aUtsEthIntelligentLinkMasterPortPortId);
    }

    public Integer getUtsEthIntelligentLinkMasterLinkAggGroupId() {
        return (Integer) getProperty(utsEthIntelligentLinkMasterLinkAggGroupId).getValue();
    }

    public void setUtsEthIntelligentLinkMasterLinkAggGroupId(Integer aUtsEthIntelligentLinkMasterLinkAggGroupId) {
        getProperty(utsEthIntelligentLinkMasterLinkAggGroupId).setValue(aUtsEthIntelligentLinkMasterLinkAggGroupId);
    }

    public String getUtsEthIntelligentLinkMasterInterface() {
        if(getUtsEthIntelligentLinkMasterPortType() == 1) {
            return getUtsEthIntelligentLinkMasterPortModuleId() + "/" + getUtsEthIntelligentLinkMasterPortPortId();
        } else {
            return "lg" + getUtsEthIntelligentLinkMasterLinkAggGroupId();
        }
    }

    public void setUtsEthIntelligentLinkMasterInterface(String aUtsEthIntelligentLinkInterface) {
        if(aUtsEthIntelligentLinkInterface.startsWith("lg")) {
            setUtsEthIntelligentLinkMasterLinkAggGroupId(Integer.parseInt(aUtsEthIntelligentLinkInterface.substring(2)));
        } else {
            String[] split = aUtsEthIntelligentLinkInterface.split("/");

            setUtsEthIntelligentLinkMasterPortModuleId(Integer.parseInt(split[0]));
            setUtsEthIntelligentLinkMasterPortDeviceId(1);
            setUtsEthIntelligentLinkMasterPortPortId(Integer.parseInt(split[1]));
        }
    }

    public Integer getUtsEthIntelligentLinkSlavePortType() {
        return (Integer) getProperty(utsEthIntelligentLinkSlavePortType).getValue();
    }

    public void setUtsEthIntelligentLinkSlavePortType(Integer aUtsEthIntelligentLinkSlavePortType) {
        getProperty(utsEthIntelligentLinkSlavePortType).setValue(aUtsEthIntelligentLinkSlavePortType);
    }

    public Integer getUtsEthIntelligentLinkSlavePortModuleId() {
        return (Integer) getProperty(utsEthIntelligentLinkSlavePortModuleId).getValue();
    }

    public void setUtsEthIntelligentLinkSlavePortModuleId(Integer aUtsEthIntelligentLinkSlavePortModuleId) {
        getProperty(utsEthIntelligentLinkSlavePortModuleId).setValue(aUtsEthIntelligentLinkSlavePortModuleId);
    }

    public Integer getUtsEthIntelligentLinkSlavePortDeviceId() {
        return (Integer) getProperty(utsEthIntelligentLinkSlavePortDeviceId).getValue();
    }

    public void setUtsEthIntelligentLinkSlavePortDeviceId(Integer aUtsEthIntelligentLinkSlavePortDeviceId) {
        getProperty(utsEthIntelligentLinkSlavePortDeviceId).setValue(aUtsEthIntelligentLinkSlavePortDeviceId);
    }

    public Integer getUtsEthIntelligentLinkSlavePortPortId() {
        return (Integer) getProperty(utsEthIntelligentLinkSlavePortPortId).getValue();
    }

    public void setUtsEthIntelligentLinkSlavePortPortId(Integer aUtsEthIntelligentLinkSlavePortPortId) {
        getProperty(utsEthIntelligentLinkSlavePortPortId).setValue(aUtsEthIntelligentLinkSlavePortPortId);
    }

    public Integer getUtsEthIntelligentLinkSlaveLinkAggGroupId() {
        return (Integer) getProperty(utsEthIntelligentLinkSlaveLinkAggGroupId).getValue();
    }

    public void setUtsEthIntelligentLinkSlaveLinkAggGroupId(Integer aUtsEthIntelligentLinkSlaveLinkAggGroupId) {
        getProperty(utsEthIntelligentLinkSlaveLinkAggGroupId).setValue(aUtsEthIntelligentLinkSlaveLinkAggGroupId);
    }

    public String getUtsEthIntelligentLinkSlaveInterface() {
        if(getUtsEthIntelligentLinkSlavePortType() == 1) {
            return getUtsEthIntelligentLinkSlavePortModuleId() + "/" + getUtsEthIntelligentLinkSlavePortPortId();
        } else {
            return "lg" + getUtsEthIntelligentLinkSlaveLinkAggGroupId();
        }
    }

    public void setUtsEthIntelligentLinkSlaveInterface(String aUtsEthIntelligentLinkInterface) {
        if(aUtsEthIntelligentLinkInterface.startsWith("lg")) {
            setUtsEthIntelligentLinkSlaveLinkAggGroupId(Integer.parseInt(aUtsEthIntelligentLinkInterface.substring(2)));
        } else {
            String[] split = aUtsEthIntelligentLinkInterface.split("/");

            setUtsEthIntelligentLinkSlavePortModuleId(Integer.parseInt(split[0]));
            setUtsEthIntelligentLinkSlavePortDeviceId(1);
            setUtsEthIntelligentLinkSlavePortPortId(Integer.parseInt(split[1]));
        }
    }

    public Integer getUtsEthIntelligentLinkMasterPortStatus() {
        return (Integer) getProperty(utsEthIntelligentLinkMasterPortStatus).getValue();
    }

    public void setUtsEthIntelligentLinkMasterPortStatus(Integer aUtsEthIntelligentLinkMasterPortStatus) {
        getProperty(utsEthIntelligentLinkMasterPortStatus).setValue(aUtsEthIntelligentLinkMasterPortStatus);
    }

    public Integer getUtsEthIntelligentLinkSlavePortStatus() {
        return (Integer) getProperty(utsEthIntelligentLinkSlavePortStatus).getValue();
    }

    public void setUtsEthIntelligentLinkSlavePortStatus(Integer aUtsEthIntelligentLinkSlavePortStatus) {
        getProperty(utsEthIntelligentLinkSlavePortStatus).setValue(aUtsEthIntelligentLinkSlavePortStatus);
    }


    public Integer getUtsEthIntelligentLinkAutoReturn() {
        return (Integer) getProperty(utsEthIntelligentLinkAutoReturn).getValue();
    }

    public void setUtsEthIntelligentLinkAutoReturn(Integer aUtsEthIntelligentLinkAutoReturn) {
        getProperty(utsEthIntelligentLinkAutoReturn).setValue(aUtsEthIntelligentLinkAutoReturn);
    }

    public Integer getUtsEthIntelligentLinkAutoWtr() {
        return (Integer) getProperty(utsEthIntelligentLinkAutoWtr).getValue();
    }

    public void setUtsEthIntelligentLinkAutoWtr(Integer aUtsEthIntelligentLinkAutoWtr) {
        getProperty(utsEthIntelligentLinkAutoWtr).setValue(aUtsEthIntelligentLinkAutoWtr);
    }

    public Integer getUtsEthIntelligentLinkReturnToMaster() {
        return (Integer) getProperty(utsEthIntelligentLinkReturnToMaster).getValue();
    }

    public void setUtsEthIntelligentLinkReturnToMaster(Integer aUtsEthIntelligentLinkReturnToMaster) {
        getProperty(utsEthIntelligentLinkReturnToMaster).setValue(aUtsEthIntelligentLinkReturnToMaster);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsEthIntelligentLinkGroupName));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortType));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortModuleId));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortDeviceId));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortPortId));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterLinkAggGroupId));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortType));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortModuleId));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortDeviceId));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortPortId));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlaveLinkAggGroupId));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortStatus));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortStatus));
        prepareRead(super.getProperty(utsEthIntelligentLinkAutoReturn));
        prepareRead(super.getProperty(utsEthIntelligentLinkAutoWtr));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsEthIntelligentLinkGroupName));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortType));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortModuleId));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortDeviceId));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortPortId));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterLinkAggGroupId));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortType));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortModuleId));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortDeviceId));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortPortId));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlaveLinkAggGroupId));
        prepareRead(super.getProperty(utsEthIntelligentLinkMasterPortStatus));
        prepareRead(super.getProperty(utsEthIntelligentLinkSlavePortStatus));
        prepareRead(super.getProperty(utsEthIntelligentLinkAutoReturn));
        prepareRead(super.getProperty(utsEthIntelligentLinkAutoWtr));

        return loadAll(new int[]{1
        });
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsEthIntelligentLinkGroupName));
        prepareSave(getProperty(utsEthIntelligentLinkMasterPortType));
        prepareSave(getProperty(utsEthIntelligentLinkMasterPortModuleId));
        prepareSave(getProperty(utsEthIntelligentLinkMasterPortDeviceId));
        prepareSave(getProperty(utsEthIntelligentLinkMasterPortPortId));
        prepareSave(getProperty(utsEthIntelligentLinkMasterLinkAggGroupId));
        prepareSave(getProperty(utsEthIntelligentLinkSlavePortType));
        prepareSave(getProperty(utsEthIntelligentLinkSlavePortModuleId));
        prepareSave(getProperty(utsEthIntelligentLinkSlavePortDeviceId));
        prepareSave(getProperty(utsEthIntelligentLinkSlavePortPortId));
        prepareSave(getProperty(utsEthIntelligentLinkSlaveLinkAggGroupId));
        prepareSave(getProperty(utsEthIntelligentLinkAutoReturn));
        prepareSave(getProperty(utsEthIntelligentLinkAutoWtr));
        super.setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean returnToMaster() throws MibBeanException {
        setUtsEthIntelligentLinkReturnToMaster(1);
        prepareSave(getProperty(utsEthIntelligentLinkReturnToMaster));

        return save();
    }
}

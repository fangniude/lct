package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class StpPortTable extends SnmpMibBean {

    public static final String stpPortStpIndex = "stpPortStpIndex";
    public static final String stpPortCardIndex = "stpPortCardIndex";
    public static final String stpPortIndex = "stpPortIndex";
    public static final String stpPortStatus = "stpPortStatus";
    public static final String stpPortPriority = "stpPortPriority";
    public static final String stpPortPathCost = "stpPortPathCost";
    public static final String stpPortDesignatedRoot = "stpPortDesignatedRoot";
    public static final String stpPortDesignatedCost = "stpPortDesignatedCost";
    public static final String stpPortDesignatedBridge = "stpPortDesignatedBridge";
    public static final String stpPortDesignatedPort = "stpPortDesignatedPort";
    public static final String stpPortForwardTransitions = "stpPortForwardTransitions";
    public static final String stpPortRstpProtocolMigration = "stpPortRstpProtocolMigration";
    public static final String stpPortRstpAdminEdgePort = "stpPortRstpAdminEdgePort";
    public static final String stpPortRstpOperEdgePort = "stpPortRstpOperEdgePort";
    public static final String stpPortPointToPointAdminStatus = "stpPortPointToPointAdminStatus";
    public static final String stpPortPointToPointOperStatus = "stpPortPointToPointOperStatus";
    public static final String stpPortEnabled = "stpPortEnabled";

    public StpPortTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(stpPortStpIndex, new SnmpMibBeanProperty(stpPortStpIndex, ".1.3.6.1.4.1.17409.2.3.9.2.1.1", ISnmpConstant.INTEGER));
        initProperty(stpPortCardIndex, new SnmpMibBeanProperty(stpPortCardIndex, ".1.3.6.1.4.1.17409.2.3.9.2.1.2", ISnmpConstant.INTEGER));
        initProperty(stpPortIndex, new SnmpMibBeanProperty(stpPortIndex, ".1.3.6.1.4.1.17409.2.3.9.2.1.3", ISnmpConstant.INTEGER));
        initProperty(stpPortStatus, new SnmpMibBeanProperty(stpPortStatus, ".1.3.6.1.4.1.17409.2.3.9.2.1.4", ISnmpConstant.INTEGER));
        initProperty(stpPortPriority, new SnmpMibBeanProperty(stpPortPriority, ".1.3.6.1.4.1.17409.2.3.9.2.1.5", ISnmpConstant.INTEGER));
        initProperty(stpPortPathCost, new SnmpMibBeanProperty(stpPortPathCost, ".1.3.6.1.4.1.17409.2.3.9.2.1.6", ISnmpConstant.INTEGER));
        initProperty(stpPortDesignatedRoot, new SnmpMibBeanProperty(stpPortDesignatedRoot, ".1.3.6.1.4.1.17409.2.3.9.2.1.7", ISnmpConstant.OCTETS));
        initProperty(stpPortDesignatedCost, new SnmpMibBeanProperty(stpPortDesignatedCost, ".1.3.6.1.4.1.17409.2.3.9.2.1.8", ISnmpConstant.INTEGER));
        initProperty(stpPortDesignatedBridge, new SnmpMibBeanProperty(stpPortDesignatedBridge, ".1.3.6.1.4.1.17409.2.3.9.2.1.9", ISnmpConstant.OCTETS));
        initProperty(stpPortDesignatedPort, new SnmpMibBeanProperty(stpPortDesignatedPort, ".1.3.6.1.4.1.17409.2.3.9.2.1.10", ISnmpConstant.GAUGE));
        initProperty(stpPortForwardTransitions, new SnmpMibBeanProperty(stpPortForwardTransitions, ".1.3.6.1.4.1.17409.2.3.9.2.1.11", ISnmpConstant.GAUGE));
        initProperty(stpPortRstpProtocolMigration, new SnmpMibBeanProperty(stpPortRstpProtocolMigration, ".1.3.6.1.4.1.17409.2.3.9.2.1.12", ISnmpConstant.INTEGER));
        initProperty(stpPortRstpAdminEdgePort, new SnmpMibBeanProperty(stpPortRstpAdminEdgePort, ".1.3.6.1.4.1.17409.2.3.9.2.1.13", ISnmpConstant.INTEGER));
        initProperty(stpPortRstpOperEdgePort, new SnmpMibBeanProperty(stpPortRstpOperEdgePort, ".1.3.6.1.4.1.17409.2.3.9.2.1.14", ISnmpConstant.INTEGER));
        initProperty(stpPortPointToPointAdminStatus, new SnmpMibBeanProperty(stpPortPointToPointAdminStatus, ".1.3.6.1.4.1.17409.2.3.9.2.1.15", ISnmpConstant.INTEGER));
        initProperty(stpPortPointToPointOperStatus, new SnmpMibBeanProperty(stpPortPointToPointOperStatus, ".1.3.6.1.4.1.17409.2.3.9.2.1.16", ISnmpConstant.INTEGER));
        initProperty(stpPortEnabled, new SnmpMibBeanProperty(stpPortEnabled, ".1.3.6.1.4.1.17409.2.3.9.2.1.17", ISnmpConstant.INTEGER));
    }

    public Integer getStpPortStpIndex() {
        return (Integer) getIndex(0);
    }

    public void setStpPortStpIndex(Integer aStpPortStpIndex) {
        setIndex(0, aStpPortStpIndex);
    }

    public Integer getStpPortCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setStpPortCardIndex(Integer aStpPortCardIndex) {
        setIndex(1, aStpPortCardIndex);
    }

    public Integer getStpPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setStpPortIndex(Integer aStpPortIndex) {
        setIndex(2, aStpPortIndex);
    }

    public Integer getStpPortStatus() {
        return (Integer) getProperty(stpPortStatus).getValue();
    }

    public void setStpPortStatus(Integer aStpPortStatus) {
        getProperty(stpPortStatus).setValue(aStpPortStatus);
    }

    public Integer getStpPortPriority() {
        return (Integer) getProperty(stpPortPriority).getValue();
    }

    public void setStpPortPriority(Integer aStpPortPriority) {
        getProperty(stpPortPriority).setValue(aStpPortPriority);
    }

    public Integer getStpPortPathCost() {
        return (Integer) getProperty(stpPortPathCost).getValue();
    }

    public void setStpPortPathCost(Integer aStpPortPathCost) {
        getProperty(stpPortPathCost).setValue(aStpPortPathCost);
    }

    public byte[] getStpPortDesignatedRoot() {
        return (byte[]) getProperty(stpPortDesignatedRoot).getValue();
    }

    public void setStpPortDesignatedRoot(byte[] aStpPortDesignatedRoot) {
        getProperty(stpPortDesignatedRoot).setValue(aStpPortDesignatedRoot);
    }

    public Integer getStpPortDesignatedCost() {
        return (Integer) getProperty(stpPortDesignatedCost).getValue();
    }

    public void setStpPortDesignatedCost(Integer aStpPortDesignatedCost) {
        getProperty(stpPortDesignatedCost).setValue(aStpPortDesignatedCost);
    }

    public byte[] getStpPortDesignatedBridge() {
        return (byte[]) getProperty(stpPortDesignatedBridge).getValue();
    }

    public void setStpPortDesignatedBridge(byte[] aStpPortDesignatedBridge) {
        getProperty(stpPortDesignatedBridge).setValue(aStpPortDesignatedBridge);
    }

    public Long getStpPortDesignatedPort() {
        return (Long) getProperty(stpPortDesignatedPort).getValue();
    }

    public void setStpPortDesignatedPort(Long aStpPortDesignatedPort) {
        getProperty(stpPortDesignatedPort).setValue(aStpPortDesignatedPort);
    }

    public Long getStpPortForwardTransitions() {
        return (Long) getProperty(stpPortForwardTransitions).getValue();
    }

    public void setStpPortForwardTransitions(Long aStpPortForwardTransitions) {
        getProperty(stpPortForwardTransitions).setValue(aStpPortForwardTransitions);
    }

    public Integer getStpPortRstpProtocolMigration() {
        return (Integer) getProperty(stpPortRstpProtocolMigration).getValue();
    }

    public void setStpPortRstpProtocolMigration(Integer aStpPortRstpProtocolMigration) {
        getProperty(stpPortRstpProtocolMigration).setValue(aStpPortRstpProtocolMigration);
    }

    public Integer getStpPortRstpAdminEdgePort() {
        return (Integer) getProperty(stpPortRstpAdminEdgePort).getValue();
    }

    public void setStpPortRstpAdminEdgePort(Integer aStpPortRstpAdminEdgePort) {
        getProperty(stpPortRstpAdminEdgePort).setValue(aStpPortRstpAdminEdgePort);
    }

    public Integer getStpPortRstpOperEdgePort() {
        return (Integer) getProperty(stpPortRstpOperEdgePort).getValue();
    }

    public void setStpPortRstpOperEdgePort(Integer aStpPortRstpOperEdgePort) {
        getProperty(stpPortRstpOperEdgePort).setValue(aStpPortRstpOperEdgePort);
    }

    public Integer getStpPortPointToPointAdminStatus() {
        return (Integer) getProperty(stpPortPointToPointAdminStatus).getValue();
    }

    public void setStpPortPointToPointAdminStatus(Integer aStpPortPointToPointAdminStatus) {
        getProperty(stpPortPointToPointAdminStatus).setValue(aStpPortPointToPointAdminStatus);
    }

    public Integer getStpPortPointToPointOperStatus() {
        return (Integer) getProperty(stpPortPointToPointOperStatus).getValue();
    }

    public void setStpPortPointToPointOperStatus(Integer aStpPortPointToPointOperStatus) {
        getProperty(stpPortPointToPointOperStatus).setValue(aStpPortPointToPointOperStatus);
    }

    public Integer getStpPortEnabled() {
        return (Integer) getProperty(stpPortEnabled).getValue();
    }

    public void setStpPortEnabled(Integer aStpPortEnabled) {
        getProperty(stpPortEnabled).setValue(aStpPortEnabled);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(stpPortStatus));
        prepareRead(getProperty(stpPortPriority));
        prepareRead(getProperty(stpPortPathCost));
        prepareRead(getProperty(stpPortDesignatedRoot));
        prepareRead(getProperty(stpPortDesignatedCost));
        prepareRead(getProperty(stpPortDesignatedBridge));
        prepareRead(getProperty(stpPortDesignatedPort));
        prepareRead(getProperty(stpPortForwardTransitions));
        prepareRead(getProperty(stpPortRstpProtocolMigration));
        prepareRead(getProperty(stpPortRstpAdminEdgePort));
        prepareRead(getProperty(stpPortRstpOperEdgePort));
        prepareRead(getProperty(stpPortPointToPointAdminStatus));
        prepareRead(getProperty(stpPortPointToPointOperStatus));
        prepareRead(getProperty(stpPortEnabled));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(stpPortStatus));
        prepareRead(getProperty(stpPortPriority));
        prepareRead(getProperty(stpPortPathCost));
        prepareRead(getProperty(stpPortDesignatedRoot));
        prepareRead(getProperty(stpPortDesignatedCost));
        prepareRead(getProperty(stpPortDesignatedBridge));
        prepareRead(getProperty(stpPortDesignatedPort));
        prepareRead(getProperty(stpPortForwardTransitions));
        prepareRead(getProperty(stpPortRstpProtocolMigration));
        prepareRead(getProperty(stpPortRstpAdminEdgePort));
        prepareRead(getProperty(stpPortRstpOperEdgePort));
        prepareRead(getProperty(stpPortPointToPointAdminStatus));
        prepareRead(getProperty(stpPortPointToPointOperStatus));
        prepareRead(getProperty(stpPortEnabled));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(stpPortPriority));
        prepareSave(getProperty(stpPortPathCost));
        prepareSave(getProperty(stpPortRstpProtocolMigration));
        prepareSave(getProperty(stpPortRstpAdminEdgePort));
        prepareSave(getProperty(stpPortPointToPointAdminStatus));
        prepareSave(getProperty(stpPortEnabled));

        return save();
    }

}
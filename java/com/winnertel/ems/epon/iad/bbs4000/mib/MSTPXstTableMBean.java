package com.winnertel.ems.epon.iad.bbs4000.mib;


/*
    * Copyright (c) 2002-2005 UTStarcom, Inc.
    * All rights reserved.
    */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The MSTPXstTableMBean class.
 * Created by QuickDVM
 */
public class MSTPXstTableMBean extends SnmpMibBean {
    public static final String mstpXstId = "mstpXstId";
    public static final String mstpXstBridgePriority = "mstpXstBridgePriority";
    public static final String mstpXstBridgeId = "mstpXstBridgeId";
    public static final String mstpXstDesignatedRoot = "mstpXstDesignatedRoot";
    public static final String mstpXstDesignatedBridge = "mstpXstDesignatedBridge";
    public static final String mstpXstInternalRootCost = "mstpXstInternalRootCost";
    public static final String mstpXstRootPort = "mstpXstRootPort";
    public static final String mstpXstMasterPort = "mstpXstMasterPort";
    public static final String mstpXstTopologyChangeFlag = "mstpXstTopologyChangeFlag";

    public MSTPXstTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(mstpXstId, new SnmpMibBeanProperty(mstpXstId, ".1.3.6.1.2.1.17.10.13.1.1", ISnmpConstant.INTEGER));
        initProperty(mstpXstBridgePriority, new SnmpMibBeanProperty(mstpXstBridgePriority, ".1.3.6.1.2.1.17.10.13.1.2", ISnmpConstant.INTEGER));
        initProperty(mstpXstBridgeId, new SnmpMibBeanProperty(mstpXstBridgeId, ".1.3.6.1.2.1.17.10.13.1.3", ISnmpConstant.OCTETS));
        initProperty(mstpXstDesignatedRoot, new SnmpMibBeanProperty(mstpXstDesignatedRoot, ".1.3.6.1.2.1.17.10.13.1.4", ISnmpConstant.OCTETS));
        initProperty(mstpXstDesignatedBridge, new SnmpMibBeanProperty(mstpXstDesignatedBridge, ".1.3.6.1.2.1.17.10.13.1.5", ISnmpConstant.OCTETS));
        initProperty(mstpXstInternalRootCost, new SnmpMibBeanProperty(mstpXstInternalRootCost, ".1.3.6.1.2.1.17.10.13.1.6", ISnmpConstant.INTEGER));
        initProperty(mstpXstRootPort, new SnmpMibBeanProperty(mstpXstRootPort, ".1.3.6.1.2.1.17.10.13.1.7", ISnmpConstant.INTEGER));
        initProperty(mstpXstMasterPort, new SnmpMibBeanProperty(mstpXstMasterPort, ".1.3.6.1.2.1.17.10.13.1.8", ISnmpConstant.INTEGER));
//        initProperty(mstpXstTimeSinceTopologyChange, new SnmpMibBeanProperty(mstpXstTimeSinceTopologyChange, ".1.3.6.1.2.1.17.10.13.1.11", ISnmpConstant.INTEGER));
//        initProperty(mstpXstTopologyChangesCount, new SnmpMibBeanProperty(mstpXstTopologyChangesCount, ".1.3.6.1.2.1.17.10.13.1.12", ISnmpConstant.INTEGER));
        initProperty(mstpXstTopologyChangeFlag, new SnmpMibBeanProperty(mstpXstTopologyChangeFlag, ".1.3.6.1.2.1.17.10.13.1.13", ISnmpConstant.INTEGER));

    }


    public Integer getMstpXstId() {
        return new Integer(((Integer) getIndex(0)).intValue()-1);
    }

    public void setMstpXstId(Integer aMstpXstId) {
        setIndex(0, aMstpXstId);
    }


    public Integer getMstpXstBridgePriority() {
        return (Integer) getProperty(mstpXstBridgePriority).getValue();
    }

    public void setMstpXstBridgePriority(Integer aMstpXstBridgePriority) {
        getProperty(mstpXstBridgePriority).setValue(aMstpXstBridgePriority);
    }

    public byte[] getMstpXstBridgeId() {
        return (byte[]) getProperty(mstpXstBridgeId).getValue();
    }

    public void setMstpXstBridgeId(byte[] aMstpXstBridgeId) {
        getProperty(mstpXstBridgeId).setValue(aMstpXstBridgeId);
    }

    public byte[] getMstpXstDesignatedRoot() {
        return (byte[]) getProperty(mstpXstDesignatedRoot).getValue();
    }

    public void setMstpXstDesignatedRoot(byte[] aMstpXstDesignatedRoot) {
        getProperty(mstpXstDesignatedRoot).setValue(aMstpXstDesignatedRoot);
    }

    public byte[] getMstpXstDesignatedBridge() {
        return (byte[]) getProperty(mstpXstDesignatedBridge).getValue();
    }

    public void setMstpXstDesignatedBridge(byte[] aMstpXstDesignatedBridge) {
        getProperty(mstpXstDesignatedBridge).setValue(aMstpXstDesignatedBridge);
    }

    public Integer getMstpXstInternalRootCost() {
        return (Integer) getProperty(mstpXstInternalRootCost).getValue();
    }

    public void setMstpXstInternalRootCost(Integer aMstpXstInternalRootCost) {
        getProperty(mstpXstInternalRootCost).setValue(aMstpXstInternalRootCost);
    }

    public Integer getMstpXstRootPort() {
        return (Integer) getProperty(mstpXstRootPort).getValue();
    }

    public void setMstpXstRootPort(Integer aMstpXstRootPort) {
        getProperty(mstpXstRootPort).setValue(aMstpXstRootPort);
    }

    public Integer getMstpXstMasterPort() {
        return (Integer) getProperty(mstpXstMasterPort).getValue();
    }

    public void setMstpXstMasterPort(Integer aMstpXstMasterPort) {
        getProperty(mstpXstMasterPort).setValue(aMstpXstMasterPort);
    }

//    public Long getMstpXstTimeSinceTopologyChange() {
//        return (Long) getProperty(mstpXstTimeSinceTopologyChange).getValue();
//    }
//
//    public void setMstpXstTimeSinceTopologyChange(Long aMstpXstTimeSinceTopologyChange) {
//        getProperty(mstpXstTimeSinceTopologyChange).setValue(aMstpXstTimeSinceTopologyChange);
//    }
//
//    public Long getMstpXstTopologyChangesCount() {
//        return (Long) getProperty(mstpXstTopologyChangesCount).getValue();
//    }
//
//    public void setMstpXstTopologyChangesCount(Long aMstpXstTopologyChangesCount) {
//        getProperty(mstpXstTopologyChangesCount).setValue(aMstpXstTopologyChangesCount);
//    }

    public Integer getMstpXstTopologyChangeFlag() {
        return (Integer) getProperty(mstpXstTopologyChangeFlag).getValue();
    }

    public void setMstpXstTopologyChangeFlag(Integer aMstpXstTopologyChangeFlag) {
        getProperty(mstpXstTopologyChangeFlag).setValue(aMstpXstTopologyChangeFlag);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(mstpXstBridgePriority));
        prepareRead(super.getProperty(mstpXstBridgeId));
        prepareRead(super.getProperty(mstpXstDesignatedRoot));
        prepareRead(super.getProperty(mstpXstDesignatedBridge));
        prepareRead(super.getProperty(mstpXstInternalRootCost));
        prepareRead(super.getProperty(mstpXstRootPort));
        prepareRead(super.getProperty(mstpXstMasterPort));
//        prepareRead(super.getProperty(mstpXstTimeSinceTopologyChange));
//        prepareRead(super.getProperty(mstpXstTopologyChangesCount));
        prepareRead(super.getProperty(mstpXstTopologyChangeFlag));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(mstpXstBridgePriority));
        prepareRead(super.getProperty(mstpXstBridgeId));
        prepareRead(super.getProperty(mstpXstDesignatedRoot));
        prepareRead(super.getProperty(mstpXstDesignatedBridge));
        prepareRead(super.getProperty(mstpXstInternalRootCost));
        prepareRead(super.getProperty(mstpXstRootPort));
        prepareRead(super.getProperty(mstpXstMasterPort));
        prepareRead(super.getProperty(mstpXstTopologyChangeFlag));

        return loadAll(new int[]{1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(mstpXstBridgePriority));

        return save();
    }


}

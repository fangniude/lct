/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Olt2AclConfTable class. Created by QuickDVM
 */
public class Dot3Olt2AclConfTable extends SnmpMibBean {
    public static final String utsDot3OltAclConfModuleId = "utsDot3OltAclConfModuleId";
    public static final String utsDot3OltAclConfDeviceId = "utsDot3OltAclConfDeviceId";
    public static final String utsDot3OltAclConfPonPort = "utsDot3OltAclConfPonPort";
    public static final String utsDot3OltAclConfLlidPort = "utsDot3OltAclConfLlidPort";
    public static final String utsDot3OltAclConfProfId = "utsDot3OltAclConfProfId";
    // public static final String utsDot3OltAclConfUpstream = "utsDot3OltAclConfUpstream";
    // public static final String utsDot3OltAclConfDownstream = "utsDot3OltAclConfDownstream";
    // public static final String utsDot3OltAclConfDir = "utsDot3OltAclConfDir";
    public static final String utsDot3OltAclConfRowStatus = "utsDot3OltAclConfRowStatus";

    public Dot3Olt2AclConfTable(ISnmpProxy aSnmpProxy) {
	super(aSnmpProxy);
	init();
    }

    protected void init() {
	initProperty(utsDot3OltAclConfModuleId, new SnmpMibBeanProperty(utsDot3OltAclConfModuleId, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.1", ISnmpConstant.INTEGER));
	initProperty(utsDot3OltAclConfDeviceId, new SnmpMibBeanProperty(utsDot3OltAclConfDeviceId, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.2", ISnmpConstant.INTEGER));
	initProperty(utsDot3OltAclConfPonPort, new SnmpMibBeanProperty(utsDot3OltAclConfPonPort, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.4", ISnmpConstant.INTEGER));
	initProperty(utsDot3OltAclConfLlidPort, new SnmpMibBeanProperty(utsDot3OltAclConfLlidPort, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.5", ISnmpConstant.INTEGER));
	initProperty(utsDot3OltAclConfProfId, new SnmpMibBeanProperty(utsDot3OltAclConfProfId, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.6", ISnmpConstant.INTEGER));
	// initProperty(utsDot3OltAclConfUpstream, new SnmpMibBeanProperty(utsDot3OltAclConfUpstream, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.7", ISnmpConstant.INTEGER));
	// initProperty(utsDot3OltAclConfDownstream, new SnmpMibBeanProperty(utsDot3OltAclConfDownstream, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.8", ISnmpConstant.INTEGER));
	// initProperty(utsDot3OltAclConfDir, new SnmpMibBeanProperty(utsDot3OltAclConfDir, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.7", ISnmpConstant.INTEGER));
	initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.9", ISnmpConstant.INTEGER));
	initProperty(utsDot3OltAclConfRowStatus, new SnmpMibBeanProperty(utsDot3OltAclConfRowStatus, ".1.3.6.1.4.1.45121.1800.2.4.2.5.1.9", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OltAclConfModuleId() {
	return (Integer) getIndex(0);
    }

    public void setUtsDot3OltAclConfModuleId(Integer aUtsDot3OltAclConfModuleId) {
	setIndex(0, aUtsDot3OltAclConfModuleId);
    }

    public Integer getUtsDot3OltAclConfDeviceId() {
	return (Integer) getIndex(1);
    }

    public void setUtsDot3OltAclConfDeviceId(Integer aUtsDot3OltAclConfDeviceId) {
	setIndex(1, aUtsDot3OltAclConfDeviceId);
    }

    public Integer getUtsDot3OltAclConfPonPort() {
	return (Integer) getIndex(2);
    }

    public void setUtsDot3OltAclConfPonPort(Integer aUtsDot3OltAclConfPonPort) {
	setIndex(2, aUtsDot3OltAclConfPonPort);
    }

    public Integer getUtsDot3OltAclConfLlidPort() {
	return (Integer) getIndex(3);
    }

    public void setUtsDot3OltAclConfLlidPort(Integer aUtsDot3OltAclConfLlidPort) {
	setIndex(3, aUtsDot3OltAclConfLlidPort);
    }

    public Integer getUtsDot3OltAclConfProfId() {
	return (Integer) getIndex(4);
    }

    public void setUtsDot3OltAclConfProfId(Integer aUtsDot3OltAclConfProfId) {
	setIndex(4, aUtsDot3OltAclConfProfId);
    }

    // public Integer getUtsDot3OltAclConfDir() {
    // return (Integer) getIndex(5);
    // }
    //
    // public void setUtsDot3OltAclConfDir(Integer aUtsDot3OltAclConfDirection) {
    // setIndex(5, aUtsDot3OltAclConfDirection);
    // }

    public Integer getUtsDot3OltAclConfRowStatus() {
	return (Integer) getProperty(utsDot3OltAclConfRowStatus).getValue();
    }

    public void setUtsDot3OltAclConfRowStatus(Integer aUtsDot3OltAclConfRowStatus) {
	getProperty(utsDot3OltAclConfRowStatus).setValue(aUtsDot3OltAclConfRowStatus);
    }

    // public Integer getUtsDot3OltAclConfUpstream() {
    // return (Integer) getProperty(utsDot3OltAclConfUpstream).getValue();
    // }
    //
    // public void setUtsDot3OltAclConfUpstream(Integer aUtsDot3OltAclConfUpstream) {
    // getProperty(utsDot3OltAclConfUpstream).setValue(aUtsDot3OltAclConfUpstream);
    // }
    //
    // public Integer getUtsDot3OltAclConfDownstream() {
    // return (Integer) getProperty(utsDot3OltAclConfDownstream).getValue();
    // }
    //
    // public void setUtsDot3OltAclConfDownstream(Integer aUtsDot3OltAclConfDownstream) {
    // getProperty(utsDot3OltAclConfDownstream).setValue(aUtsDot3OltAclConfDownstream);
    // }

    public boolean retrieve() throws MibBeanException {
	// prepareRead(super.getProperty(utsDot3OltAclConfUpstream));
	// prepareRead(super.getProperty(utsDot3OltAclConfDownstream));
	prepareRead(super.getProperty(utsDot3OltAclConfRowStatus));

	return load();
    }

    public Vector retrieveAll() throws MibBeanException {
	// prepareRead(super.getProperty(utsDot3OltAclConfUpstream));
	// prepareRead(super.getProperty(utsDot3OltAclConfDownstream));
	prepareRead(super.getProperty(utsDot3OltAclConfRowStatus));

	return loadAll(new int[] { 1, 1, 1, 1, 1 });
    }

    public boolean add() throws MibBeanException {
	super.setRowStatus(new Integer(4));

	// prepareSave(getProperty(utsDot3OltAclConfUpstream));
	// prepareSave(getProperty(utsDot3OltAclConfDownstream));
	// prepareSave(getProperty(utsDot3OltAclConfDir));
	prepareSave(getProperty(ROW_STATUS));

	return save();
    }

    public boolean delete() throws MibBeanException {
	super.setRowStatus(new Integer(6));
	prepareSave(getProperty(ROW_STATUS));
	return save();
    }
}

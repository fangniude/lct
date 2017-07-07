/*
 * @(#)OnuPingMBean.java
 *
 * Copyright (c) 2002-2006 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The InOutBandTTLMBean class.
 * Created by QuickDVM
 */
public class TrafficTTLMBean extends SnmpMibBean {
	public static final String utsBBSMgmtTrafficTTL = "utsBBSMgmtTrafficTTL";

	public TrafficTTLMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsBBSMgmtTrafficTTL, new SnmpMibBeanProperty(utsBBSMgmtTrafficTTL, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.26", ISnmpConstant.INTEGER));
	}

	public Integer getUtsBBSMgmtTrafficTTL() {
		return (Integer) getProperty(utsBBSMgmtTrafficTTL).getValue();
	}

	public void setUtsBBSMgmtTrafficTTL(Integer aUtsBBSMgmtTrafficTTL) {
		getProperty(utsBBSMgmtTrafficTTL).setValue(aUtsBBSMgmtTrafficTTL);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsBBSMgmtTrafficTTL));

		return load();
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsBBSMgmtTrafficTTL));

		return save();
	}

}

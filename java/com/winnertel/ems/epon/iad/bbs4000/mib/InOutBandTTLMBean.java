/*
 * @(#)OnuPingMBean.java
 *
 * Copyright (c) 2002-2006 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The InOutBandTTLMBean class.
 * Created by QuickDVM
 */
public class InOutBandTTLMBean extends SnmpMibBean {
	public static final String utsBBSMgmtTrafficInBandTTL = "utsBBSMgmtTrafficInBandTTL";

	public static final String utsBBSMgmtTrafficOutBandTTL = "utsBBSMgmtTrafficOutBandTTL";

	public InOutBandTTLMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsBBSMgmtTrafficInBandTTL, new SnmpMibBeanProperty(
				utsBBSMgmtTrafficInBandTTL,
				".1.3.6.1.4.1.45121.1800.2.1.1.4.1.12",
				ISnmpConstant.INTEGER));
		initProperty(utsBBSMgmtTrafficOutBandTTL, new SnmpMibBeanProperty(
				utsBBSMgmtTrafficOutBandTTL,
				".1.3.6.1.4.1.45121.1800.2.1.1.4.1.13",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsBBSMgmtTrafficInBandTTL() {
		return (Integer) getProperty(utsBBSMgmtTrafficInBandTTL).getValue();
	}

	public void setUtsBBSMgmtTrafficInBandTTL(
			Integer aUtsBBSMgmtTrafficInBandTTL) {
		getProperty(utsBBSMgmtTrafficInBandTTL).setValue(
				aUtsBBSMgmtTrafficInBandTTL);
	}

	public Integer getUtsBBSMgmtTrafficOutBandTTL() {
		return (Integer) getProperty(utsBBSMgmtTrafficOutBandTTL).getValue();
	}

	public void setUtsBBSMgmtTrafficOutBandTTL(
			Integer aUtsBBSMgmtTrafficOutBandTTL) {
		getProperty(utsBBSMgmtTrafficOutBandTTL).setValue(
				aUtsBBSMgmtTrafficOutBandTTL);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsBBSMgmtTrafficInBandTTL));
		prepareRead(super.getProperty(utsBBSMgmtTrafficOutBandTTL));

		return load();
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsBBSMgmtTrafficInBandTTL));
		prepareSave(getProperty(utsBBSMgmtTrafficOutBandTTL));

		return save();
	}

}

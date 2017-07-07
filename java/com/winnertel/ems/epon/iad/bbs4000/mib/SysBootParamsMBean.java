/*
 * @(#)OnuPingMBean.java
 *
 * Copyright (c) 02-06 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The SysBootParamsMBean class.
 * Created by QuickDVM
 */
public class SysBootParamsMBean extends SnmpMibBean {
	public static final String utsBBSSysBootMethod = "utsBBSSysBootMethod";

	public static final String utsBBSSysBootFileName = "utsBBSSysBootFileName";

	public static final String utsBBSOutBandInterfaceIpAddr = "utsBBSOutBandInterfaceIpAddr";

	public static final String utsBBSOutbandInterfaceIpMask = "utsBBSOutbandInterfaceIpMask";

	public static final String utsBBSOutbandInterfaceNextHop = "utsBBSOutbandInterfaceNextHop";

	public static final String utsBBSBootFTPUserName = "utsBBSBootFTPUserName";

	public static final String utsBBSBootFTPPassword = " utsBBSBootFTPPassword";

	public static final String utsBBSBootFTPServerIpAddress = "utsBBSBootFTPServerIpAddress";

	public SysBootParamsMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsBBSSysBootMethod, new SnmpMibBeanProperty(
				utsBBSSysBootMethod,
				".1.3.6.1.4.1.41355.1800.2.1.1.4.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsBBSSysBootFileName, new SnmpMibBeanProperty(
				utsBBSSysBootFileName,
				".1.3.6.1.4.1.41355.1800.2.1.1.4.1.3",
				ISnmpConstant.STRING));
		initProperty(utsBBSOutBandInterfaceIpAddr, new SnmpMibBeanProperty(
				utsBBSOutBandInterfaceIpAddr,
				".1.3.6.1.4.1.41355.1800.2.1.1.4.1.4",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsBBSOutbandInterfaceIpMask, new SnmpMibBeanProperty(
				utsBBSOutbandInterfaceIpMask,
				".1.3.6.1.4.1.41355.1800.2.1.1.4.1.5",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsBBSOutbandInterfaceNextHop, new SnmpMibBeanProperty(
				utsBBSOutbandInterfaceNextHop,
				".1.3.6.1.4.1.41355.1800.2.1.1.4.1.6",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsBBSBootFTPUserName, new SnmpMibBeanProperty(
				utsBBSBootFTPUserName,
				".1.3.6.1.4.1.41355.1800.2.1.1.4.1.7",
				ISnmpConstant.STRING));
		initProperty(utsBBSBootFTPPassword, new SnmpMibBeanProperty(
				utsBBSBootFTPPassword,
				".1.3.6.1.4.1.41355.1800.2.1.1.4.1.8",
				ISnmpConstant.STRING));
		initProperty(utsBBSBootFTPServerIpAddress, new SnmpMibBeanProperty(
				utsBBSBootFTPServerIpAddress,
				".1.3.6.1.4.1.41355.1800.2.1.1.4.1.9",
				ISnmpConstant.IP_ADDRESS));
	}

	public Integer getUtsBBSSysBootMethod() {
		return (Integer) getProperty(utsBBSSysBootMethod).getValue();
	}

	public void setUtsBBSSysBootMethod(Integer aUtsBBSSysBootMethod) {
		getProperty(utsBBSSysBootMethod).setValue(aUtsBBSSysBootMethod);
	}

	public String getUtsBBSSysBootFileName() {
		return (String) getProperty(utsBBSSysBootFileName).getValue();
	}

	public void setUtsBBSSysBootFileName(String aUtsBBSSysBootFileName) {
		getProperty(utsBBSSysBootFileName).setValue(aUtsBBSSysBootFileName);
	}

	public String getUtsBBSOutBandInterfaceIpAddr() {
		return (String) getProperty(utsBBSOutBandInterfaceIpAddr).getValue();
	}

	public void setUtsBBSOutBandInterfaceIpAddr(
			String aUtsBBSOutBandInterfaceIpAddr) {
		getProperty(utsBBSOutBandInterfaceIpAddr).setValue(
				aUtsBBSOutBandInterfaceIpAddr);
	}

	public String getUtsBBSOutbandInterfaceIpMask() {
		return (String) getProperty(utsBBSOutbandInterfaceIpMask).getValue();
	}

	public void setUtsBBSOutbandInterfaceIpMask(
			String aUtsBBSOutbandInterfaceIpMask) {
		getProperty(utsBBSOutbandInterfaceIpMask).setValue(
				aUtsBBSOutbandInterfaceIpMask);
	}

	public String getUtsBBSOutbandInterfaceNextHop() {
		return (String) getProperty(utsBBSOutbandInterfaceNextHop).getValue();
	}

	public void setUtsBBSOutbandInterfaceNextHop(
			String aUtsBBSOutbandInterfaceNextHop) {
		getProperty(utsBBSOutbandInterfaceNextHop).setValue(
				aUtsBBSOutbandInterfaceNextHop);
	}

	public String getUtsBBSBootFTPUserName() {
		return (String) getProperty(utsBBSBootFTPUserName).getValue();
	}

	public void setUtsBBSBootFTPUserName(String aUtsBBSBootFTPUserName) {
		getProperty(utsBBSBootFTPUserName).setValue(aUtsBBSBootFTPUserName);
	}

	public String getUtsBBSBootFTPPassword() {
		return (String) getProperty(utsBBSBootFTPPassword).getValue();
	}

	public void setUtsBBSBootFTPPassword(String aUtsBBSBootFTPPassword) {
		getProperty(utsBBSBootFTPPassword).setValue(aUtsBBSBootFTPPassword);
	}

	public String getUtsBBSBootFTPServerIpAddress() {
		return (String) getProperty(utsBBSBootFTPServerIpAddress).getValue();
	}

	public void setUtsBBSBootFTPServerIpAddress(
			String aUtsBBSBootFTPServerIpAddress) {
		getProperty(utsBBSBootFTPServerIpAddress).setValue(
				aUtsBBSBootFTPServerIpAddress);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsBBSSysBootMethod));
		prepareRead(super.getProperty(utsBBSSysBootFileName));
		prepareRead(super.getProperty(utsBBSOutBandInterfaceIpAddr));
		prepareRead(super.getProperty(utsBBSOutbandInterfaceIpMask));
		prepareRead(super.getProperty(utsBBSOutbandInterfaceNextHop));
		prepareRead(super.getProperty(utsBBSBootFTPUserName));
		prepareRead(super.getProperty(utsBBSBootFTPPassword));
		prepareRead(super.getProperty(utsBBSBootFTPServerIpAddress));

		return load();
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsBBSSysBootMethod));
		prepareSave(getProperty(utsBBSSysBootFileName));
		prepareSave(getProperty(utsBBSOutBandInterfaceIpAddr));
		prepareSave(getProperty(utsBBSOutbandInterfaceIpMask));
		prepareSave(getProperty(utsBBSOutbandInterfaceNextHop));
		prepareSave(getProperty(utsBBSBootFTPUserName));
		prepareSave(getProperty(utsBBSBootFTPPassword));
		prepareSave(getProperty(utsBBSBootFTPServerIpAddress));

		return save();
	}

}

/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.inventory.mib;

import java.util.Vector;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ONUMBean class. Created by DVM Creator
 */
public class ONUMBean extends SnmpMibBean {
	public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";

	public static final String utsDot3OnuPortId = "utsDot3OnuPortId";

	public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";

	public static final String utsDot3OnuRegistrationState = "utsDot3OnuRegistrationState";

	public static final String utsDot3OnuHwVersion = "utsDot3OnuHwVersion";

	public static final String utsDot3OnuFwVersion = "utsDot3OnuFwVersion";

	public static final String utsDot3OnuMaxLLID = "utsDot3OnuMaxLLID";

	public static final String utsDot3OnuOAMStandardVersion = "utsDot3OnuOAMStandardVersion";

	public static final String utsDot3OnuRTT = "utsDot3OnuRTT";

	public static final String utsDot3OnuHwType = "utsDot3OnuHwType";

	public static final String utsDot3OnuSwitchHwRev = "utsDot3OnuSwitchHwRev";

	public static final String utsDot3OnuSwitchFwRev = "utsDot3OnuSwitchFwRev";

	public static final String utsDot3OnuIADStatus = "utsDot3OnuIADStatus";

	public static final String ifIndex = "ifIndex";

	public ONUMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(
				utsDot3OnuModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(
				utsDot3OnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuLogicalPortId,
				new SnmpMibBeanProperty(utsDot3OnuLogicalPortId,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuRegistrationState,
				new SnmpMibBeanProperty(utsDot3OnuRegistrationState,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuHwVersion, new SnmpMibBeanProperty(
				utsDot3OnuHwVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.5",
				ISnmpConstant.STRING));
		initProperty(utsDot3OnuFwVersion, new SnmpMibBeanProperty(
				utsDot3OnuFwVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.6",
				ISnmpConstant.STRING));
		initProperty(utsDot3OnuMaxLLID, new SnmpMibBeanProperty(
				utsDot3OnuMaxLLID, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMStandardVersion,
				new SnmpMibBeanProperty(utsDot3OnuOAMStandardVersion,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuRTT,
				new SnmpMibBeanProperty(utsDot3OnuRTT,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.9",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuHwType, new SnmpMibBeanProperty(
				utsDot3OnuHwType, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuSwitchHwRev,
				new SnmpMibBeanProperty(utsDot3OnuSwitchHwRev,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.11",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuSwitchFwRev,
				new SnmpMibBeanProperty(utsDot3OnuSwitchFwRev,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.12",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuIADStatus, new SnmpMibBeanProperty(
				utsDot3OnuIADStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.13",
				ISnmpConstant.INTEGER));
		initProperty(ifIndex, new SnmpMibBeanProperty(ifIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3OnuModuleId() {
		return (Integer) getProperty(utsDot3OnuModuleId).getValue();
	}

	public void setUtsDot3OnuModuleId(Integer aUtsDot3OnuModuleId) {
		getProperty(utsDot3OnuModuleId).setValue(aUtsDot3OnuModuleId);
	}

	public Integer getUtsDot3OnuPortId() {
		return (Integer) getProperty(utsDot3OnuPortId).getValue();
	}

	public void setUtsDot3OnuPortId(Integer aUtsDot3OnuPortId) {
		getProperty(utsDot3OnuPortId).setValue(aUtsDot3OnuPortId);
	}

	public Integer getUtsDot3OnuLogicalPortId() {
		return (Integer) getProperty(utsDot3OnuLogicalPortId).getValue();
	}

	public void setUtsDot3OnuLogicalPortId(Integer aUtsDot3OnuLogicalPortId) {
		getProperty(utsDot3OnuLogicalPortId).setValue(aUtsDot3OnuLogicalPortId);
	}

	public Integer getUtsDot3OnuRegistrationState() {
		return (Integer) getProperty(utsDot3OnuRegistrationState).getValue();
	}

	public void setUtsDot3OnuRegistrationState(
			Integer aUtsDot3OnuRegistrationState) {
		getProperty(utsDot3OnuRegistrationState).setValue(
				aUtsDot3OnuRegistrationState);
	}

	public String getUtsDot3OnuHwVersion() {
		return (String) getProperty(utsDot3OnuHwVersion).getValue();
	}

	public void setUtsDot3OnuHwVersion(String aUtsDot3OnuHwVersion) {
		getProperty(utsDot3OnuHwVersion).setValue(aUtsDot3OnuHwVersion);
	}

	public String getUtsDot3OnuFwVersion() {
		return (String) getProperty(utsDot3OnuFwVersion).getValue();
	}

	public void setUtsDot3OnuFwVersion(String aUtsDot3OnuFwVersion) {
		getProperty(utsDot3OnuFwVersion).setValue(aUtsDot3OnuFwVersion);
	}

	public Integer getUtsDot3OnuMaxLLID() {
		return (Integer) getProperty(utsDot3OnuMaxLLID).getValue();
	}

	public void setUtsDot3OnuMaxLLID(Integer aUtsDot3OnuMaxLLID) {
		getProperty(utsDot3OnuMaxLLID).setValue(aUtsDot3OnuMaxLLID);
	}

	public Integer getUtsDot3OnuOAMStandardVersion() {
		return (Integer) getProperty(utsDot3OnuOAMStandardVersion).getValue();
	}

	public void setUtsDot3OnuOAMStandardVersion(
			Integer aUtsDot3OnuOAMStandardVersion) {
		getProperty(utsDot3OnuOAMStandardVersion).setValue(
				aUtsDot3OnuOAMStandardVersion);
	}

	public Integer getUtsDot3OnuRTT() {
		return (Integer) getProperty(utsDot3OnuRTT).getValue();
	}

	public void setUtsDot3OnuRTT(Integer aUtsDot3OnuRTT) {
		getProperty(utsDot3OnuRTT).setValue(aUtsDot3OnuRTT);
	}

	public Integer getUtsDot3OnuHwType() {
		return (Integer) getProperty(utsDot3OnuHwType).getValue();
	}

	public void setUtsDot3OnuHwType(Integer aUtsDot3OnuHwType) {
		getProperty(utsDot3OnuHwType).setValue(aUtsDot3OnuHwType);
	}

	public String getUtsDot3OnuSwitchHwRev() {
		return (String) getProperty(utsDot3OnuSwitchHwRev).getValue();
	}

	public void setUtsDot3OnuSwitchHwRev(String aUtsDot3OnuSwitchHwRev) {
		getProperty(utsDot3OnuSwitchHwRev).setValue(aUtsDot3OnuSwitchHwRev);
	}

	public String getUtsDot3OnuSwitchFwRev() {
		return (String) getProperty(utsDot3OnuSwitchFwRev).getValue();
	}

	public void setUtsDot3OnuSwitchFwRev(String aUtsDot3OnuSwitchFwRev) {
		getProperty(utsDot3OnuSwitchFwRev).setValue(aUtsDot3OnuSwitchFwRev);
	}

	public Integer getUtsDot3OnuIADStatus() {
		return (Integer) getProperty(utsDot3OnuIADStatus).getValue();
	}

	public void setUtsDot3OnuIADStatus(Integer aUtsDot3OnuIADStatus) {
		getProperty(utsDot3OnuIADStatus).setValue(aUtsDot3OnuIADStatus);
	}

	public Integer getIfIndex() {
		return (Integer) getIndex(0);
	}

	public void setIfIndex(Integer aIfIndex) {
		setIndex(0, aIfIndex);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuModuleId));
		prepareRead(super.getProperty(utsDot3OnuPortId));
		prepareRead(super.getProperty(utsDot3OnuLogicalPortId));
		prepareRead(super.getProperty(utsDot3OnuRegistrationState));
		// prepareRead(super.getProperty(utsDot3OnuHwVersion));
		// prepareRead(super.getProperty(utsDot3OnuFwVersion));
		// prepareRead(super.getProperty(utsDot3OnuMaxLLID));
		// prepareRead(super.getProperty(utsDot3OnuOAMStandardVersion));
		// prepareRead(super.getProperty(utsDot3OnuRTT));
		prepareRead(super.getProperty(utsDot3OnuHwType));
		prepareRead(super.getProperty(utsDot3OnuSwitchHwRev));
		prepareRead(super.getProperty(utsDot3OnuSwitchFwRev));
		prepareRead(super.getProperty(utsDot3OnuIADStatus));
		// prepareRead(super.getProperty(ifIndex));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuModuleId));
		prepareRead(super.getProperty(utsDot3OnuPortId));
		prepareRead(super.getProperty(utsDot3OnuLogicalPortId));
		prepareRead(super.getProperty(utsDot3OnuRegistrationState));
		// prepareRead(super.getProperty(utsDot3OnuHwVersion));
		// prepareRead(super.getProperty(utsDot3OnuFwVersion));
		// prepareRead(super.getProperty(utsDot3OnuMaxLLID));
		// prepareRead(super.getProperty(utsDot3OnuOAMStandardVersion));
		// prepareRead(super.getProperty(utsDot3OnuRTT));
		prepareRead(super.getProperty(utsDot3OnuHwType));
		// prepareRead(super.getProperty(utsDot3OnuSwitchHwRev));
		// prepareRead(super.getProperty(utsDot3OnuSwitchFwRev));
		prepareRead(super.getProperty(utsDot3OnuIADStatus));
		// prepareRead(super.getProperty(ifIndex));

    this.setRowsPerFetch(50);//use getBulk to retrieve ONU data from NE to reduce the wait time.
		return loadAll(new int[] { 1 });
	}

}

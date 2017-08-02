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
 * The ONUUpgradeHwTableMBean class.
 * Created by QuickDVM
 */
public class ONUUpgradeHwTableMBean extends SnmpMibBean {
	public static final String utsDot3OnuHwTypeUpgradeHwType = "utsDot3OnuHwTypeUpgradeHwType";

	public static final String utsDot3OnuHwTypeUpgradeMethod = "utsDot3OnuHwTypeUpgradeMethod";

	public static final String utsDot3OnuHwTypeUpgradeHwRev = "utsDot3OnuHwTypeUpgradeHwRev";

	public static final String utsDot3OnuHwTypeUpgradeFwRev = "utsDot3OnuHwTypeUpgradeFwRev";

	public static final String utsDot3OnuHwTypeUpgradeImageName = "utsDot3OnuHwTypeUpgradeImageName";

	public static final String utsDot3OnuHwTypeUpgradeComponent = "utsDot3OnuHwTypeUpgradeComponent";

	public ONUUpgradeHwTableMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuHwTypeUpgradeHwType, new SnmpMibBeanProperty(
				utsDot3OnuHwTypeUpgradeHwType,
				".1.3.6.1.4.1.45121.1800.2.3.1.7.2.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuHwTypeUpgradeMethod, new SnmpMibBeanProperty(
				utsDot3OnuHwTypeUpgradeMethod,
				".1.3.6.1.4.1.45121.1800.2.3.1.7.2.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuHwTypeUpgradeHwRev, new SnmpMibBeanProperty(
				utsDot3OnuHwTypeUpgradeHwRev,
				".1.3.6.1.4.1.45121.1800.2.3.1.7.2.1.1.3",
				ISnmpConstant.STRING));
		initProperty(utsDot3OnuHwTypeUpgradeFwRev, new SnmpMibBeanProperty(
				utsDot3OnuHwTypeUpgradeFwRev,
				".1.3.6.1.4.1.45121.1800.2.3.1.7.2.1.1.4",
				ISnmpConstant.STRING));
		initProperty(utsDot3OnuHwTypeUpgradeImageName, new SnmpMibBeanProperty(
				utsDot3OnuHwTypeUpgradeImageName,
				".1.3.6.1.4.1.45121.1800.2.3.1.7.2.1.1.5",
				ISnmpConstant.STRING));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1800.2.3.1.7.2.1.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuHwTypeUpgradeComponent, new SnmpMibBeanProperty(
				utsDot3OnuHwTypeUpgradeComponent,
				".1.3.6.1.4.1.45121.1800.2.3.1.7.2.1.1.7",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3OnuHwTypeUpgradeHwType() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OnuHwTypeUpgradeHwType(
			Integer aUtsDot3OnuHwTypeUpgradeHwType) {
		setIndex(0, aUtsDot3OnuHwTypeUpgradeHwType);
	}

	public Integer getUtsDot3OnuHwTypeUpgradeMethod() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OnuHwTypeUpgradeMethod(
			Integer aUtsDot3OnuHwTypeUpgradeMethod) {
		setIndex(1, aUtsDot3OnuHwTypeUpgradeMethod);
	}

	public Integer getUtsDot3OnuHwTypeUpgradeComponent() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3OnuHwTypeUpgradeComponent(
			Integer aUtsDot3OnuHwTypeUpgradeComponent) {
		setIndex(2, aUtsDot3OnuHwTypeUpgradeComponent);
	}

	public String getUtsDot3OnuHwTypeUpgradeHwRev() {
		return (String) getProperty(utsDot3OnuHwTypeUpgradeHwRev).getValue();
	}

	public void setUtsDot3OnuHwTypeUpgradeHwRev(
			String aUtsDot3OnuHwTypeUpgradeHwRev) {
		getProperty(utsDot3OnuHwTypeUpgradeHwRev).setValue(
				aUtsDot3OnuHwTypeUpgradeHwRev);
	}

	public String getUtsDot3OnuHwTypeUpgradeFwRev() {
		return (String) getProperty(utsDot3OnuHwTypeUpgradeFwRev).getValue();
	}

	public void setUtsDot3OnuHwTypeUpgradeFwRev(
			String aUtsDot3OnuHwTypeUpgradeFwRev) {
		getProperty(utsDot3OnuHwTypeUpgradeFwRev).setValue(
				aUtsDot3OnuHwTypeUpgradeFwRev);
	}

	public String getUtsDot3OnuHwTypeUpgradeImageName() {
		return (String) getProperty(utsDot3OnuHwTypeUpgradeImageName)
				.getValue();
	}

	public void setUtsDot3OnuHwTypeUpgradeImageName(
			String aUtsDot3OnuHwTypeUpgradeImageName) {
		getProperty(utsDot3OnuHwTypeUpgradeImageName).setValue(
				aUtsDot3OnuHwTypeUpgradeImageName);
	}

    public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuHwTypeUpgradeHwRev));
		prepareRead(super.getProperty(utsDot3OnuHwTypeUpgradeFwRev));
		prepareRead(super.getProperty(utsDot3OnuHwTypeUpgradeImageName));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuHwTypeUpgradeHwRev));
		prepareRead(super.getProperty(utsDot3OnuHwTypeUpgradeFwRev));
		prepareRead(super.getProperty(utsDot3OnuHwTypeUpgradeImageName));

		return loadAll(new int[] { 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeHwType));
		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeMethod));
		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeHwRev));
		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeFwRev));
		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeImageName));
		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeComponent));

		return save();
	}

	public boolean add() throws MibBeanException {
//		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeHwRev));
		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeFwRev));
		prepareSave(getProperty(utsDot3OnuHwTypeUpgradeImageName));

		super.setRowStatus(new Integer(4));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException {
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

}

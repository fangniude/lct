/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The UtsOnuFWUpgradeManualResultTable class. Created by QuickDVM
 */
public class UtsOnuFWUpgradeManualResultTable extends SnmpMibBean {
	public static final String utsOnuFWUpgradeManualResultModule = "utsOnuFWUpgradeManualResultModule";
	public static final String utsOnuFWUpgradeManualResultPort = "utsOnuFWUpgradeManualResultPort";
	public static final String utsOnuFWUpgradeManualResultLport = "utsOnuFWUpgradeManualResultLport";
	public static final String utsOnuFWUpgradeManualResultComp = "utsOnuFWUpgradeManualResultComp";
	public static final String utsOnuFWUpgradeManualResultTargetVersion = "utsOnuFWUpgradeManualResultTargetVersion";
	public static final String utsOnuFWUpgradeManualResultCurrentVersion = "utsOnuFWUpgradeManualResultCurrentVersion";
	public static final String utsOnuFWUpgradeManualResultCurrentUpgStatus = "utsOnuFWUpgradeManualResultCurrentUpgStatus";
	public static final String utsOnuFWUpgradeManualResultFailReason = "utsOnuFWUpgradeManualResultFailReason";
	public static final String utsOnuFWUpgradeManualResultCommit = "utsOnuFWUpgradeManualResultCommit";

	public UtsOnuFWUpgradeManualResultTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsOnuFWUpgradeManualResultModule,
				new SnmpMibBeanProperty(utsOnuFWUpgradeManualResultModule,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsOnuFWUpgradeManualResultPort,
				new SnmpMibBeanProperty(utsOnuFWUpgradeManualResultPort,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.2",
						ISnmpConstant.INTEGER));
		initProperty(utsOnuFWUpgradeManualResultLport,
				new SnmpMibBeanProperty(utsOnuFWUpgradeManualResultLport,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsOnuFWUpgradeManualResultComp,
				new SnmpMibBeanProperty(utsOnuFWUpgradeManualResultComp,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsOnuFWUpgradeManualResultTargetVersion,
				new SnmpMibBeanProperty(
						utsOnuFWUpgradeManualResultTargetVersion,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.5",
						ISnmpConstant.STRING));
		initProperty(utsOnuFWUpgradeManualResultCurrentVersion,
				new SnmpMibBeanProperty(
						utsOnuFWUpgradeManualResultCurrentVersion,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.6",
						ISnmpConstant.STRING));
		initProperty(utsOnuFWUpgradeManualResultCurrentUpgStatus,
				new SnmpMibBeanProperty(
						utsOnuFWUpgradeManualResultCurrentUpgStatus,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.7",
						ISnmpConstant.STRING));
		initProperty(utsOnuFWUpgradeManualResultFailReason,
				new SnmpMibBeanProperty(utsOnuFWUpgradeManualResultFailReason,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.8",
						ISnmpConstant.STRING));
		initProperty(utsOnuFWUpgradeManualResultCommit,
				new SnmpMibBeanProperty(utsOnuFWUpgradeManualResultCommit,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.15.1.9",
						ISnmpConstant.INTEGER));

	}

	public Integer getUtsOnuFWUpgradeManualResultModule() {
		return (Integer) getProperty(utsOnuFWUpgradeManualResultModule)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultModule(
			Integer aUtsOnuFWUpgradeManualResultModule) {
		getProperty(utsOnuFWUpgradeManualResultModule).setValue(
				aUtsOnuFWUpgradeManualResultModule);
	}

	public Integer getUtsOnuFWUpgradeManualResultPort() {
		return (Integer) getProperty(utsOnuFWUpgradeManualResultPort)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultPort(
			Integer aUtsOnuFWUpgradeManualResultPort) {
		getProperty(utsOnuFWUpgradeManualResultPort).setValue(
				aUtsOnuFWUpgradeManualResultPort);
	}

	public Integer getUtsOnuFWUpgradeManualResultLport() {
		return (Integer) getProperty(utsOnuFWUpgradeManualResultLport)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultLport(
			Integer aUtsOnuFWUpgradeManualResultLport) {
		getProperty(utsOnuFWUpgradeManualResultLport).setValue(
				aUtsOnuFWUpgradeManualResultLport);
	}

	public Integer getUtsOnuFWUpgradeManualResultComp() {
		return (Integer) getProperty(utsOnuFWUpgradeManualResultComp)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultComp(
			Integer aUtsOnuFWUpgradeManualResultComp) {
		getProperty(utsOnuFWUpgradeManualResultComp).setValue(
				aUtsOnuFWUpgradeManualResultComp);
	}

	public String getUtsOnuFWUpgradeManualResultTargetVersion() {
		return (String) getProperty(utsOnuFWUpgradeManualResultTargetVersion)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultTargetVersion(
			String aUtsOnuFWUpgradeManualResultTargetVersion) {
		getProperty(utsOnuFWUpgradeManualResultTargetVersion).setValue(
				aUtsOnuFWUpgradeManualResultTargetVersion);
	}

	public String getUtsOnuFWUpgradeManualResultCurrentVersion() {
		return (String) getProperty(utsOnuFWUpgradeManualResultCurrentVersion)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultCurrentVersion(
			String aUtsOnuFWUpgradeManualResultCurrentVersion) {
		getProperty(utsOnuFWUpgradeManualResultCurrentVersion).setValue(
				aUtsOnuFWUpgradeManualResultCurrentVersion);
	}

	public String getUtsOnuFWUpgradeManualResultCurrentUpgStatus() {
		return (String) getProperty(utsOnuFWUpgradeManualResultCurrentUpgStatus)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultCurrentUpgStatus(
			String aUtsOnuFWUpgradeManualResultCurrentUpgStatus) {
		getProperty(utsOnuFWUpgradeManualResultCurrentUpgStatus).setValue(
				aUtsOnuFWUpgradeManualResultCurrentUpgStatus);
	}

	public String getUtsOnuFWUpgradeManualResultFailReason() {
		return (String) getProperty(utsOnuFWUpgradeManualResultFailReason)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultFailReason(
			String aUtsOnuFWUpgradeManualResultFailReason) {
		getProperty(utsOnuFWUpgradeManualResultFailReason).setValue(
				aUtsOnuFWUpgradeManualResultFailReason);
	}

	public Integer getUtsOnuFWUpgradeManualResultCommit() {
		return (Integer) getProperty(utsOnuFWUpgradeManualResultCommit)
				.getValue();
	}

	public void setUtsOnuFWUpgradeManualResultCommit(
			Integer aUtsOnuFWUpgradeManualResultCommit) {
		getProperty(utsOnuFWUpgradeManualResultCommit).setValue(
				aUtsOnuFWUpgradeManualResultCommit);
	}


	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultModule));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultPort));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultLport));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultComp));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultTargetVersion));
		prepareRead(super
				.getProperty(utsOnuFWUpgradeManualResultCurrentVersion));
		prepareRead(super
				.getProperty(utsOnuFWUpgradeManualResultCurrentUpgStatus));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultFailReason));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultCommit));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultModule));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultPort));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultLport));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultComp));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultTargetVersion));
		prepareRead(super
				.getProperty(utsOnuFWUpgradeManualResultCurrentVersion));
		prepareRead(super
				.getProperty(utsOnuFWUpgradeManualResultCurrentUpgStatus));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultFailReason));
		prepareRead(super.getProperty(utsOnuFWUpgradeManualResultCommit));

		Vector v = loadAll(new int[] {});

		// added by Zengtian, 2011/9/15
		// if (!DebugMode.isDebug()) {
		// try {
		// OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility
		// .getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
		// String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy
		// .getTargetHost());
		// Map map = onuMgmtMgr.getOnuLabelMap(neName);
		// for (int i = 0; i < v.size(); i++) {
		// UtsOnuFWUpgradeManualResultTable bean =
		// (UtsOnuFWUpgradeManualResultTable) v
		// .get(i);
		// String key = new StringBuilder(neName)
		// .append(bean.getUtsOnuFWUpgradeManualResultModule())
		// .append("/")
		// .append(bean.getUtsOnuFWUpgradeManualResultPort())
		// .append("/")
		// .append(bean.getUtsOnuFWUpgradeManualResultLport())
		// .toString();
		// if (map.containsKey(key)) {
		// bean.setOnuLabel((String) map.get(key));
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }

		return v;
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsOnuFWUpgradeManualResultCommit));

		return save();
	}

}

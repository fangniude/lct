package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The EponSysCliMgmtTable class. Created by QuickDVM
 */
public class EponSysCliMgmtTable extends SnmpMibBean {
	public static final String utsEponSysCliSessionId = "utsEponSysCliSessionId";
	public static final String utsEponSysCliUserAccount = "utsEponSysCliUserAccount";
	public static final String utsEponSysCliUserLoginTime = "utsEponSysCliUserLoginTime";
	public static final String utsEponSysCliUserIdleTime = "utsEponSysCliUserIdleTime";
	public static final String utsEponSysCliUserHostIp = "utsEponSysCliUserHostIp";
	public static final String utsEponSysCliUserLogoutForcely = "utsEponSysCliUserLogoutForcely";

	public EponSysCliMgmtTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsEponSysCliSessionId, new SnmpMibBeanProperty(
				utsEponSysCliSessionId,
				".1.3.6.1.4.1.45121.1800.2.1.1.4.11.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsEponSysCliUserAccount,
				new SnmpMibBeanProperty(utsEponSysCliUserAccount,
						".1.3.6.1.4.1.45121.1800.2.1.1.4.11.1.1.2",
						ISnmpConstant.STRING));
		initProperty(utsEponSysCliUserLoginTime,
				new SnmpMibBeanProperty(utsEponSysCliUserLoginTime,
						".1.3.6.1.4.1.45121.1800.2.1.1.4.11.1.1.3",
						ISnmpConstant.OCTETS));
		initProperty(utsEponSysCliUserIdleTime, new SnmpMibBeanProperty(
				utsEponSysCliUserIdleTime,
				".1.3.6.1.4.1.45121.1800.2.1.1.4.11.1.1.4",
				ISnmpConstant.GAUGE));
		initProperty(utsEponSysCliUserHostIp,
				new SnmpMibBeanProperty(utsEponSysCliUserHostIp,
						".1.3.6.1.4.1.45121.1800.2.1.1.4.11.1.1.5",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsEponSysCliUserLogoutForcely, new SnmpMibBeanProperty(
				utsEponSysCliUserLogoutForcely,
				".1.3.6.1.4.1.45121.1800.2.1.1.4.11.1.1.6",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsEponSysCliSessionId() {
		return (Integer) getIndex(0);
	}

	public void setUtsEponSysCliSessionId(Integer aUtsEponSysCliSessionId) {
		setIndex(0, aUtsEponSysCliSessionId);
	}

	public String getUtsEponSysCliUserAccount() {
		return (String) getProperty(utsEponSysCliUserAccount).getValue();
	}

	public void setUtsEponSysCliUserAccount(String aUtsEponSysCliUserAccount) {
		getProperty(utsEponSysCliUserAccount).setValue(
				aUtsEponSysCliUserAccount);
	}

	public byte[] getUtsEponSysCliUserLoginTime() {
		return (byte[]) getProperty(utsEponSysCliUserLoginTime).getValue();
	}

	public void setUtsEponSysCliUserLoginTime(byte[] aUtsEponSysCliUserLoginTime) {
		getProperty(utsEponSysCliUserLoginTime).setValue(
				aUtsEponSysCliUserLoginTime);
	}

	public Long getUtsEponSysCliUserIdleTime() {
		return (Long) getProperty(utsEponSysCliUserIdleTime).getValue();
	}

	public void setUtsEponSysCliUserIdleTime(Long aUtsEponSysCliUserIdleTime) {
		getProperty(utsEponSysCliUserIdleTime).setValue(
				aUtsEponSysCliUserIdleTime);
	}

	public String getUtsEponSysCliUserHostIp() {
		return (String) getProperty(utsEponSysCliUserHostIp).getValue();
	}

	public void setUtsEponSysCliUserHostIp(String aUtsEponSysCliUserHostIp) {
		getProperty(utsEponSysCliUserHostIp).setValue(aUtsEponSysCliUserHostIp);
	}

	public Integer getUtsEponSysCliUserLogoutForcely() {
		return (Integer) getProperty(utsEponSysCliUserLogoutForcely).getValue();
	}

	public void setUtsEponSysCliUserLogoutForcely(
			Integer aUtsEponSysCliUserLogoutForcely) {
		getProperty(utsEponSysCliUserLogoutForcely).setValue(
				aUtsEponSysCliUserLogoutForcely);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsEponSysCliUserAccount));
		prepareRead(super.getProperty(utsEponSysCliUserLoginTime));
		prepareRead(super.getProperty(utsEponSysCliUserIdleTime));
		prepareRead(super.getProperty(utsEponSysCliUserHostIp));
		prepareRead(super.getProperty(utsEponSysCliUserLogoutForcely));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsEponSysCliUserAccount));
		prepareRead(super.getProperty(utsEponSysCliUserLoginTime));
		prepareRead(super.getProperty(utsEponSysCliUserIdleTime));
		prepareRead(super.getProperty(utsEponSysCliUserHostIp));
		prepareRead(super.getProperty(utsEponSysCliUserLogoutForcely));

		return loadAll(new int[] { 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsEponSysCliUserLogoutForcely));

		return save();
	}

}

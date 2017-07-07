package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2RmsConfigTable class. Created by QuickDVM
 */
public class Dot3Onu2RmsConfigTable extends SnmpMibBean {
	public static final String utsDot3Onu2VoipModuleId = "utsDot3Onu2VoipModuleId";
	public static final String utsDot3Onu2VoipDeviceId = "utsDot3Onu2VoipDeviceId";
	public static final String utsDot3Onu2VoipPortId = "utsDot3Onu2VoipPortId";
	public static final String utsDot3Onu2VoipLogicalPortId = "utsDot3Onu2VoipLogicalPortId";
	public static final String utsDot3Onu2RmsIpMode = "utsDot3Onu2RmsIpMode";
	public static final String utsDot3Onu2RmsIpAddress = "utsDot3Onu2RmsIpAddress";
	public static final String utsDot3Onu2RmsNetmask = "utsDot3Onu2RmsNetmask";
	public static final String utsDot3Onu2RmsDefaultGw = "utsDot3Onu2RmsDefaultGw";
	public static final String utsDot3Onu2RmsPppoeMode = "utsDot3Onu2RmsPppoeMode";
	public static final String utsDot3Onu2RmsPppoeUserName = "utsDot3Onu2RmsPppoeUserName";
	public static final String utsDot3Onu2RmsPppoePassword = "utsDot3Onu2RmsPppoePassword";
	public static final String utsDot3Onu2RmsTaggedFlag = "utsDot3Onu2RmsTaggedFlag";
	public static final String utsDot3Onu2RmsCvlan = "utsDot3Onu2RmsCvlan";
	public static final String utsDot3Onu2RmsSvlan = "utsDot3Onu2RmsSvlan";
	public static final String utsDot3Onu2RmsPriority = "utsDot3Onu2RmsPriority";
	public static final String utsDot3Onu2RmsUrlBlockNum = "utsDot3Onu2RmsUrlBlockNum";
	public static final String utsDot3Onu2RmsUrlBlockSequence = "utsDot3Onu2RmsUrlBlockSequence";
	public static final String utsDot3Onu2RmsUrl = "utsDot3Onu2RmsUrl";

	public Dot3Onu2RmsConfigTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2VoipModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipModuleId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipDeviceId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPortId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2VoipLogicalPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.47.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsIpMode, new SnmpMibBeanProperty(
				utsDot3Onu2RmsIpMode,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsIpAddress,
				new SnmpMibBeanProperty(utsDot3Onu2RmsIpAddress,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.2",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2RmsNetmask,
				new SnmpMibBeanProperty(utsDot3Onu2RmsNetmask,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.3",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2RmsDefaultGw,
				new SnmpMibBeanProperty(utsDot3Onu2RmsDefaultGw,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.4",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2RmsPppoeMode, new SnmpMibBeanProperty(
				utsDot3Onu2RmsPppoeMode,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsPppoeUserName,
				new SnmpMibBeanProperty(utsDot3Onu2RmsPppoeUserName,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.6",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2RmsPppoePassword,
				new SnmpMibBeanProperty(utsDot3Onu2RmsPppoePassword,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.7",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2RmsTaggedFlag, new SnmpMibBeanProperty(
				utsDot3Onu2RmsTaggedFlag,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.8",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsCvlan, new SnmpMibBeanProperty(
				utsDot3Onu2RmsCvlan, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsSvlan, new SnmpMibBeanProperty(
				utsDot3Onu2RmsSvlan,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsPriority, new SnmpMibBeanProperty(
				utsDot3Onu2RmsPriority,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsUrlBlockNum, new SnmpMibBeanProperty(
				utsDot3Onu2RmsUrlBlockNum,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.12",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsUrlBlockSequence, new SnmpMibBeanProperty(
				utsDot3Onu2RmsUrlBlockSequence,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.13",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2RmsUrl, new SnmpMibBeanProperty(
				utsDot3Onu2RmsUrl, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.64.1.14",
				ISnmpConstant.STRING));

	}

	public Integer getUtsDot3Onu2VoipModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2VoipModuleId(Integer aUtsDot3Onu2VoipModuleId) {
		setIndex(0, aUtsDot3Onu2VoipModuleId);
	}

	public Integer getUtsDot3Onu2VoipDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2VoipDeviceId(Integer aUtsDot3Onu2VoipDeviceId) {
		setIndex(1, aUtsDot3Onu2VoipDeviceId);
	}

	public Integer getUtsDot3Onu2VoipPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2VoipPortId(Integer aUtsDot3Onu2VoipPortId) {
		setIndex(2, aUtsDot3Onu2VoipPortId);
	}

	public Integer getUtsDot3Onu2VoipLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2VoipLogicalPortId(
			Integer aUtsDot3Onu2VoipLogicalPortId) {
		setIndex(3, aUtsDot3Onu2VoipLogicalPortId);
	}

	public Integer getUtsDot3Onu2RmsIpMode() {
		return (Integer) getProperty(utsDot3Onu2RmsIpMode).getValue();
	}

	public void setUtsDot3Onu2RmsIpMode(Integer aUtsDot3Onu2RmsIpMode) {
		getProperty(utsDot3Onu2RmsIpMode).setValue(aUtsDot3Onu2RmsIpMode);
	}

	public String getUtsDot3Onu2RmsIpAddress() {
		return (String) getProperty(utsDot3Onu2RmsIpAddress).getValue();
	}

	public void setUtsDot3Onu2RmsIpAddress(String aUtsDot3Onu2RmsIpAddress) {
		getProperty(utsDot3Onu2RmsIpAddress).setValue(aUtsDot3Onu2RmsIpAddress);
	}

	public String getUtsDot3Onu2RmsNetmask() {
		return (String) getProperty(utsDot3Onu2RmsNetmask).getValue();
	}

	public void setUtsDot3Onu2RmsNetmask(String aUtsDot3Onu2RmsNetmask) {
		getProperty(utsDot3Onu2RmsNetmask).setValue(aUtsDot3Onu2RmsNetmask);
	}

	public String getUtsDot3Onu2RmsDefaultGw() {
		return (String) getProperty(utsDot3Onu2RmsDefaultGw).getValue();
	}

	public void setUtsDot3Onu2RmsDefaultGw(String aUtsDot3Onu2RmsDefaultGw) {
		getProperty(utsDot3Onu2RmsDefaultGw).setValue(aUtsDot3Onu2RmsDefaultGw);
	}

	public Integer getUtsDot3Onu2RmsPppoeMode() {
		return (Integer) getProperty(utsDot3Onu2RmsPppoeMode).getValue();
	}

	public void setUtsDot3Onu2RmsPppoeMode(Integer aUtsDot3Onu2RmsPppoeMode) {
		getProperty(utsDot3Onu2RmsPppoeMode).setValue(aUtsDot3Onu2RmsPppoeMode);
	}

	public String getUtsDot3Onu2RmsPppoeUserName() {
		return (String) getProperty(utsDot3Onu2RmsPppoeUserName).getValue();
	}

	public void setUtsDot3Onu2RmsPppoeUserName(
			String aUtsDot3Onu2RmsPppoeUserName) {
		getProperty(utsDot3Onu2RmsPppoeUserName).setValue(
				aUtsDot3Onu2RmsPppoeUserName);
	}

	public String getUtsDot3Onu2RmsPppoePassword() {
		return (String) getProperty(utsDot3Onu2RmsPppoePassword).getValue();
	}

	public void setUtsDot3Onu2RmsPppoePassword(
			String aUtsDot3Onu2RmsPppoePassword) {
		getProperty(utsDot3Onu2RmsPppoePassword).setValue(
				aUtsDot3Onu2RmsPppoePassword);
	}

	public Integer getUtsDot3Onu2RmsTaggedFlag() {
		return (Integer) getProperty(utsDot3Onu2RmsTaggedFlag).getValue();
	}

	public void setUtsDot3Onu2RmsTaggedFlag(Integer aUtsDot3Onu2RmsTaggedFlag) {
		getProperty(utsDot3Onu2RmsTaggedFlag).setValue(
				aUtsDot3Onu2RmsTaggedFlag);
	}

	public Integer getUtsDot3Onu2RmsCvlan() {
		return (Integer) getProperty(utsDot3Onu2RmsCvlan).getValue();
	}

	public void setUtsDot3Onu2RmsCvlan(Integer aUtsDot3Onu2RmsCvlan) {
		getProperty(utsDot3Onu2RmsCvlan).setValue(aUtsDot3Onu2RmsCvlan);
	}

	public Integer getUtsDot3Onu2RmsSvlan() {
		return (Integer) getProperty(utsDot3Onu2RmsSvlan).getValue();
	}

	public void setUtsDot3Onu2RmsSvlan(Integer aUtsDot3Onu2RmsSvlan) {
		getProperty(utsDot3Onu2RmsSvlan).setValue(aUtsDot3Onu2RmsSvlan);
	}

	public Integer getUtsDot3Onu2RmsPriority() {
		return (Integer) getProperty(utsDot3Onu2RmsPriority).getValue();
	}

	public void setUtsDot3Onu2RmsPriority(Integer aUtsDot3Onu2RmsPriority) {
		getProperty(utsDot3Onu2RmsPriority).setValue(aUtsDot3Onu2RmsPriority);
	}

	public Integer getUtsDot3Onu2RmsUrlBlockNum() {
		return (Integer) getProperty(utsDot3Onu2RmsUrlBlockNum).getValue();
	}

	public void setUtsDot3Onu2RmsUrlBlockNum(Integer aUtsDot3Onu2RmsUrlBlockNum) {
		getProperty(utsDot3Onu2RmsUrlBlockNum).setValue(
				aUtsDot3Onu2RmsUrlBlockNum);
	}

	public Integer getUtsDot3Onu2RmsUrlBlockSequence() {
		return (Integer) getProperty(utsDot3Onu2RmsUrlBlockSequence).getValue();
	}

	public void setUtsDot3Onu2RmsUrlBlockSequence(
			Integer aUtsDot3Onu2RmsUrlBlockSequence) {
		getProperty(utsDot3Onu2RmsUrlBlockSequence).setValue(
				aUtsDot3Onu2RmsUrlBlockSequence);
	}

	public String getUtsDot3Onu2RmsUrl() {
		return (String) getProperty(utsDot3Onu2RmsUrl).getValue();
	}

	public void setUtsDot3Onu2RmsUrl(String aUtsDot3Onu2RmsUrl) {
		getProperty(utsDot3Onu2RmsUrl).setValue(aUtsDot3Onu2RmsUrl);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2RmsIpMode));
		prepareRead(super.getProperty(utsDot3Onu2RmsIpAddress));
		prepareRead(super.getProperty(utsDot3Onu2RmsNetmask));
		prepareRead(super.getProperty(utsDot3Onu2RmsDefaultGw));
		prepareRead(super.getProperty(utsDot3Onu2RmsPppoeMode));
		prepareRead(super.getProperty(utsDot3Onu2RmsPppoeUserName));
		prepareRead(super.getProperty(utsDot3Onu2RmsPppoePassword));
		prepareRead(super.getProperty(utsDot3Onu2RmsTaggedFlag));
		prepareRead(super.getProperty(utsDot3Onu2RmsCvlan));
		prepareRead(super.getProperty(utsDot3Onu2RmsSvlan));
		prepareRead(super.getProperty(utsDot3Onu2RmsPriority));
		prepareRead(super.getProperty(utsDot3Onu2RmsUrlBlockNum));
		prepareRead(super.getProperty(utsDot3Onu2RmsUrlBlockSequence));
		prepareRead(super.getProperty(utsDot3Onu2RmsUrl));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2RmsIpMode));
		prepareRead(super.getProperty(utsDot3Onu2RmsIpAddress));
		prepareRead(super.getProperty(utsDot3Onu2RmsNetmask));
		prepareRead(super.getProperty(utsDot3Onu2RmsDefaultGw));
		prepareRead(super.getProperty(utsDot3Onu2RmsPppoeMode));
		prepareRead(super.getProperty(utsDot3Onu2RmsPppoeUserName));
		prepareRead(super.getProperty(utsDot3Onu2RmsPppoePassword));
		prepareRead(super.getProperty(utsDot3Onu2RmsTaggedFlag));
		prepareRead(super.getProperty(utsDot3Onu2RmsCvlan));
		prepareRead(super.getProperty(utsDot3Onu2RmsSvlan));
		prepareRead(super.getProperty(utsDot3Onu2RmsPriority));
		prepareRead(super.getProperty(utsDot3Onu2RmsUrlBlockNum));
		prepareRead(super.getProperty(utsDot3Onu2RmsUrlBlockSequence));
		prepareRead(super.getProperty(utsDot3Onu2RmsUrl));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2RmsIpMode));
		prepareSave(getProperty(utsDot3Onu2RmsIpAddress));
		prepareSave(getProperty(utsDot3Onu2RmsNetmask));
		prepareSave(getProperty(utsDot3Onu2RmsDefaultGw));
		prepareSave(getProperty(utsDot3Onu2RmsPppoeMode));
		prepareSave(getProperty(utsDot3Onu2RmsPppoeUserName));
		prepareSave(getProperty(utsDot3Onu2RmsPppoePassword));
		prepareSave(getProperty(utsDot3Onu2RmsTaggedFlag));
		prepareSave(getProperty(utsDot3Onu2RmsCvlan));
		prepareSave(getProperty(utsDot3Onu2RmsSvlan));
		prepareSave(getProperty(utsDot3Onu2RmsPriority));
		prepareSave(getProperty(utsDot3Onu2RmsUrlBlockNum));
		prepareSave(getProperty(utsDot3Onu2RmsUrlBlockSequence));
		prepareSave(getProperty(utsDot3Onu2RmsUrl));

		return save();
	}

}

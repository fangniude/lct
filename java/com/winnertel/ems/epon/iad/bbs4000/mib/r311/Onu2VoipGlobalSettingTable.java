package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Onu2VoipGlobalSettingTable class. Created by QuickDVM
 */
public class Onu2VoipGlobalSettingTable extends SnmpMibBean {
	public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
	public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
	public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
	public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";
	
	public static final String utsDot3Onu2CtcIadIpMode = "utsDot3Onu2CtcIadIpMode";
	public static final String utsDot3Onu2CtcIadIpAddr = "utsDot3Onu2CtcIadIpAddr";
	public static final String utsDot3Onu2CtcIadNetMask = "utsDot3Onu2CtcIadNetMask";
	public static final String utsDot3Onu2CtcIadDefaultGw = "utsDot3Onu2CtcIadDefaultGw";
	public static final String utsDot3Onu2CtcIadPppoeMode = "utsDot3Onu2CtcIadPppoeMode";
	public static final String utsDot3Onu2CtcIadPppoeUsername = "utsDot3Onu2CtcIadPppoeUsername";
	public static final String utsDot3Onu2CtcIadPppoePassword = "utsDot3Onu2CtcIadPppoePassword";
	public static final String utsDot3Onu2CtcIadTagMode = "utsDot3Onu2CtcIadTagMode";
	public static final String utsDot3Onu2CtcIadCvlan = "utsDot3Onu2CtcIadCvlan";
	public static final String utsDot3Onu2CtcIadSvlan = "utsDot3Onu2CtcIadSvlan";
	public static final String utsDot3Onu2CtcIadPriority = "utsDot3Onu2CtcIadPriority";
	public static final String utsDot3Onu2CtcConfiguredVoipProtocol = "utsDot3Onu2CtcConfiguredVoipProtocol";
//	public static final String utsDot3Onu2VoipLongTimer = "utsDot3Onu2VoipLongTimer";
//	public static final String utsDot3Onu2VoipShortTimer = "utsDot3Onu2VoipShortTimer";

	public Onu2VoipGlobalSettingTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesLogicalPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.4",
				ISnmpConstant.INTEGER));
		
		initProperty(utsDot3Onu2CtcIadIpMode, new SnmpMibBeanProperty(
				utsDot3Onu2CtcIadIpMode,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.131",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcIadIpAddr,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadIpAddr,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.132",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcIadNetMask,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadNetMask,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.133",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcIadDefaultGw,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadDefaultGw,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.134",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcIadPppoeMode, new SnmpMibBeanProperty(
				utsDot3Onu2CtcIadPppoeMode,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.135",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcIadPppoeUsername,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadPppoeUsername,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.136",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2CtcIadPppoePassword,
				new SnmpMibBeanProperty(utsDot3Onu2CtcIadPppoePassword,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.137",
						ISnmpConstant.STRING));
		initProperty(utsDot3Onu2CtcIadTagMode, new SnmpMibBeanProperty(
				utsDot3Onu2CtcIadTagMode,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.138",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcIadCvlan, new SnmpMibBeanProperty(
				utsDot3Onu2CtcIadCvlan,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.139",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcIadSvlan, new SnmpMibBeanProperty(
				utsDot3Onu2CtcIadSvlan,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.140",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcIadPriority, new SnmpMibBeanProperty(
				utsDot3Onu2CtcIadPriority,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.141",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcConfiguredVoipProtocol, new SnmpMibBeanProperty(
				utsDot3Onu2CtcConfiguredVoipProtocol,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.401",
				ISnmpConstant.INTEGER));
//		initProperty(utsDot3Onu2VoipLongTimer, new SnmpMibBeanProperty(
//				utsDot3Onu2VoipLongTimer,
//				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.63.1.1",
//				ISnmpConstant.INTEGER));
//		initProperty(utsDot3Onu2VoipShortTimer, new SnmpMibBeanProperty(
//				utsDot3Onu2VoipShortTimer,
//				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.63.1.2",
//				ISnmpConstant.INTEGER));

	}
	
	public Integer getUtsDot3Onu2CtcCombinedFeaturesModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2CtcCombinedFeaturesModuleId(Integer aUtsDot3Onu2CtcCombinedFeaturesModuleId) {
		setIndex(0, aUtsDot3Onu2CtcCombinedFeaturesModuleId);
	}

	public Integer getUtsDot3Onu2CtcCombinedFeaturesDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2CtcCombinedFeaturesDeviceId(Integer aUtsDot3Onu2CtcCombinedFeaturesDeviceId) {
		setIndex(1, aUtsDot3Onu2CtcCombinedFeaturesDeviceId);
	}

	public Integer getUtsDot3Onu2CtcCombinedFeaturesPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2CtcCombinedFeaturesPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesPortId) {
		setIndex(2, aUtsDot3Onu2CtcCombinedFeaturesPortId);
	}

	public Integer getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId() {
		return (Integer) getIndex(3);
	}
	
	public void setUtsDot3Onu2CtcCombinedFeaturesLogicalPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId) {
		setIndex(3, aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
	}


	public Integer getUtsDot3Onu2CtcIadIpMode() {
		return (Integer) getProperty(utsDot3Onu2CtcIadIpMode).getValue();
	}

	public void setUtsDot3Onu2CtcIadIpMode(
			Integer aUtsDot3Onu2CtcIadIpMode) {
		getProperty(utsDot3Onu2CtcIadIpMode).setValue(
				aUtsDot3Onu2CtcIadIpMode);
	}

	public String getUtsDot3Onu2CtcIadIpAddr() {
		return (String) getProperty(utsDot3Onu2CtcIadIpAddr).getValue();
	}

	public void setUtsDot3Onu2CtcIadIpAddr(String aUtsDot3Onu2CtcIadIpAddr) {
		getProperty(utsDot3Onu2CtcIadIpAddr).setValue(
				aUtsDot3Onu2CtcIadIpAddr);
	}

	public String getUtsDot3Onu2CtcIadNetMask() {
		return (String) getProperty(utsDot3Onu2CtcIadNetMask).getValue();
	}

	public void setUtsDot3Onu2CtcIadNetMask(String aUtsDot3Onu2CtcIadNetMask) {
		getProperty(utsDot3Onu2CtcIadNetMask).setValue(
				aUtsDot3Onu2CtcIadNetMask);
	}

	public String getUtsDot3Onu2CtcIadDefaultGw() {
		return (String) getProperty(utsDot3Onu2CtcIadDefaultGw).getValue();
	}

	public void setUtsDot3Onu2CtcIadDefaultGw(String aUtsDot3Onu2CtcIadDefaultGw) {
		getProperty(utsDot3Onu2CtcIadDefaultGw).setValue(aUtsDot3Onu2CtcIadDefaultGw);
	}

	public Integer getUtsDot3Onu2CtcIadPppoeMode() {
		return (Integer) getProperty(utsDot3Onu2CtcIadPppoeMode).getValue();
	}

	public void setUtsDot3Onu2CtcIadPppoeMode(Integer aUtsDot3Onu2CtcIadPppoeMode) {
		getProperty(utsDot3Onu2CtcIadPppoeMode).setValue(
				aUtsDot3Onu2CtcIadPppoeMode);
	}

	public String getUtsDot3Onu2CtcIadPppoeUsername() {
		return (String) getProperty(utsDot3Onu2CtcIadPppoeUsername).getValue();
	}

	public void setUtsDot3Onu2CtcIadPppoeUsername(
			String aUtsDot3Onu2CtcIadPppoeUsername) {
		getProperty(utsDot3Onu2CtcIadPppoeUsername).setValue(
				aUtsDot3Onu2CtcIadPppoeUsername);
	}

	public String getUtsDot3Onu2CtcIadPppoePassword() {
		return (String) getProperty(utsDot3Onu2CtcIadPppoePassword).getValue();
	}

	public void setUtsDot3Onu2CtcIadPppoePassword(
			String aUtsDot3Onu2CtcIadPppoePassword) {
		getProperty(utsDot3Onu2CtcIadPppoePassword).setValue(
				aUtsDot3Onu2CtcIadPppoePassword);
	}

	public Integer getUtsDot3Onu2CtcIadTagMode() {
		return (Integer) getProperty(utsDot3Onu2CtcIadTagMode).getValue();
	}

	public void setUtsDot3Onu2CtcIadTagMode(Integer aUtsDot3Onu2CtcIadTagMode) {
		getProperty(utsDot3Onu2CtcIadTagMode).setValue(
				aUtsDot3Onu2CtcIadTagMode);
	}

	public Integer getUtsDot3Onu2CtcIadCvlan() {
		return (Integer) getProperty(utsDot3Onu2CtcIadCvlan).getValue();
	}

	public void setUtsDot3Onu2CtcIadCvlan(Integer aUtsDot3Onu2CtcIadCvlan) {
		getProperty(utsDot3Onu2CtcIadCvlan).setValue(
				aUtsDot3Onu2CtcIadCvlan);
	}

	public Integer getUtsDot3Onu2CtcIadSvlan() {
		return (Integer) getProperty(utsDot3Onu2CtcIadSvlan).getValue();
	}

	public void setUtsDot3Onu2CtcIadSvlan(Integer aUtsDot3Onu2CtcIadSvlan) {
		getProperty(utsDot3Onu2CtcIadSvlan).setValue(
				aUtsDot3Onu2CtcIadSvlan);
	}

	public Integer getUtsDot3Onu2CtcIadPriority() {
		return (Integer) getProperty(utsDot3Onu2CtcIadPriority).getValue();
	}

	public void setUtsDot3Onu2CtcIadPriority(Integer aUtsDot3Onu2CtcIadPriority) {
		getProperty(utsDot3Onu2CtcIadPriority).setValue(aUtsDot3Onu2CtcIadPriority);
	}
	
	public Integer getUtsDot3Onu2CtcConfiguredVoipProtocol() {
		return (Integer) getProperty(utsDot3Onu2CtcConfiguredVoipProtocol).getValue();
	}

	public void setUtsDot3Onu2CtcConfiguredVoipProtocol(Integer aUtsDot3Onu2CtcConfiguredVoipProtocol) {
		getProperty(utsDot3Onu2CtcConfiguredVoipProtocol).setValue(aUtsDot3Onu2CtcConfiguredVoipProtocol);
	}

//	public Integer getUtsDot3Onu2VoipLongTimer() {
//		return (Integer) getProperty(utsDot3Onu2VoipLongTimer).getValue();
//	}
//
//	public void setUtsDot3Onu2VoipLongTimer(Integer aUtsDot3Onu2VoipLongTimer) {
//		getProperty(utsDot3Onu2VoipLongTimer).setValue(aUtsDot3Onu2VoipLongTimer);
//	}
//	
//	public Integer getUtsDot3Onu2VoipShortTimer() {
//		return (Integer) getProperty(utsDot3Onu2VoipShortTimer).getValue();
//	}
//
//	public void setUtsDot3Onu2VoipShortTimer(Integer aUtsDot3Onu2VoipShortTimer) {
//		getProperty(utsDot3Onu2VoipShortTimer).setValue(aUtsDot3Onu2VoipShortTimer);
//	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcIadIpMode));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadIpAddr));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadNetMask));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadDefaultGw));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadPppoeMode));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadPppoeUsername));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadPppoePassword));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadTagMode));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadCvlan));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadSvlan));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadPriority));
		prepareRead(super.getProperty(utsDot3Onu2CtcConfiguredVoipProtocol));
//		prepareRead(super.getProperty(utsDot3Onu2VoipLongTimer));
//		prepareRead(super.getProperty(utsDot3Onu2VoipShortTimer));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcIadIpMode));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadIpAddr));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadNetMask));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadDefaultGw));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadPppoeMode));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadPppoeUsername));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadPppoePassword));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadTagMode));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadCvlan));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadSvlan));
		prepareRead(super.getProperty(utsDot3Onu2CtcIadPriority));
		prepareRead(super.getProperty(utsDot3Onu2CtcConfiguredVoipProtocol));
//		prepareRead(super.getProperty(utsDot3Onu2VoipLongTimer));
//		prepareRead(super.getProperty(utsDot3Onu2VoipShortTimer));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2CtcIadIpMode));
		prepareSave(getProperty(utsDot3Onu2CtcIadIpAddr));
		prepareSave(getProperty(utsDot3Onu2CtcIadNetMask));
		prepareSave(getProperty(utsDot3Onu2CtcIadDefaultGw));
		prepareSave(getProperty(utsDot3Onu2CtcIadPppoeMode));
		prepareSave(getProperty(utsDot3Onu2CtcIadPppoeUsername));
		prepareSave(getProperty(utsDot3Onu2CtcIadPppoePassword));
		prepareSave(getProperty(utsDot3Onu2CtcIadTagMode));
		prepareSave(getProperty(utsDot3Onu2CtcIadCvlan));
		prepareSave(getProperty(utsDot3Onu2CtcIadSvlan));
		prepareSave(getProperty(utsDot3Onu2CtcIadPriority));
		prepareSave(getProperty(utsDot3Onu2CtcConfiguredVoipProtocol));
//		prepareSave(getProperty(utsDot3Onu2VoipLongTimer));
//		prepareSave(getProperty(utsDot3Onu2VoipShortTimer));

		return save();
	}

}

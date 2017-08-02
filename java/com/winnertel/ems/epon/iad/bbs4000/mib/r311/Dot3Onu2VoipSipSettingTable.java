package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Hashtable;
import java.util.Vector;

/**
 * The Dot3Onu2VoipSipSettingTable class. Created by QuickDVM
 */
public class Dot3Onu2VoipSipSettingTable extends SnmpMibBean {
	public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
	public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
	public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
	public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";
	
	public static final String utsDot3Onu2CtcSipMgPort = "utsDot3Onu2CtcSipMgPort";
	public static final String utsDot3Onu2CtcSipProxyServIp = "utsDot3Onu2CtcSipProxyServIp";
	public static final String utsDot3Onu2CtcSipProxyServComPort = "utsDot3Onu2CtcSipProxyServComPort";
	public static final String utsDot3Onu2CtcSipBackupProxyServIp = "utsDot3Onu2CtcSipBackupProxyServIp";
	public static final String utsDot3Onu2CtcSipBackupProxyServComPort = "utsDot3Onu2CtcSipBackupProxyServComPort";
	public static final String utsDot3Onu2CtcSipActiveProxyServ = "utsDot3Onu2CtcSipActiveProxyServ";
	public static final String utsDot3Onu2CtcSipRegServIp = "utsDot3Onu2CtcSipRegServIp";
	public static final String utsDot3Onu2CtcSipRegServComPort = "utsDot3Onu2CtcSipRegServComPort";
	public static final String utsDot3Onu2CtcSipBackupRegServIp = "utsDot3Onu2CtcSipBackupRegServIp";
	public static final String utsDot3Onu2CtcSipBackupRegServComPort = "utsDot3Onu2CtcSipBackupRegServComPort";
	public static final String utsDot3Onu2CtcSipOutBoundServIp = "utsDot3Onu2CtcSipOutBoundServIp";
	public static final String utsDot3Onu2CtcSipOutBoundServPort = "utsDot3Onu2CtcSipOutBoundServPort";
	public static final String utsDot3Onu2CtcSipRegInterval = "utsDot3Onu2CtcSipRegInterval";
	public static final String utsDot3Onu2CtcSipHeartbeatSwitch = "utsDot3Onu2CtcSipHeartbeatSwitch";
	public static final String utsDot3Onu2CtcSipHeartbeatCycle = "utsDot3Onu2CtcSipHeartbeatCycle";
	public static final String utsDot3Onu2CtcSipHeartbeatCount = "utsDot3Onu2CtcSipHeartbeatCount";
	public static final String utsDot3Onu2CtcSipDigitmap = "utsDot3Onu2CtcSipDigitmap";
	
	public Dot3Onu2VoipSipSettingTable(ISnmpProxy aSnmpProxy) {
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
		
		initProperty(utsDot3Onu2CtcSipMgPort, new SnmpMibBeanProperty(
				utsDot3Onu2CtcSipMgPort,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.261",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipProxyServIp,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipProxyServIp,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.262",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcSipProxyServComPort,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipProxyServComPort,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.263",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipBackupProxyServIp,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipBackupProxyServIp,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.264",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcSipBackupProxyServComPort,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipBackupProxyServComPort,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.265",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipActiveProxyServ,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipActiveProxyServ,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.266",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipRegServIp,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipRegServIp,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.267",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcSipRegServComPort,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipRegServComPort,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.268",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipBackupRegServIp,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipBackupRegServIp,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.269",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcSipBackupRegServComPort,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipBackupRegServComPort,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.270",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipOutBoundServIp, new SnmpMibBeanProperty(
				utsDot3Onu2CtcSipOutBoundServIp,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.271",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2CtcSipOutBoundServPort,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipOutBoundServPort,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.272",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipRegInterval, new SnmpMibBeanProperty(
				utsDot3Onu2CtcSipRegInterval,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.273",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipHeartbeatSwitch,
				new SnmpMibBeanProperty(utsDot3Onu2CtcSipHeartbeatSwitch,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.274",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipHeartbeatCycle, new SnmpMibBeanProperty(
				utsDot3Onu2CtcSipHeartbeatCycle,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.275",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipHeartbeatCount, new SnmpMibBeanProperty(
				utsDot3Onu2CtcSipHeartbeatCount,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.276",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcSipDigitmap, new SnmpMibBeanProperty(
				utsDot3Onu2CtcSipDigitmap,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.361",
				ISnmpConstant.STRING));

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

	public Integer getUtsDot3Onu2CtcSipMgPort() {
		return (Integer) getProperty(utsDot3Onu2CtcSipMgPort).getValue();
	}

	public void setUtsDot3Onu2CtcSipMgPort(Integer aUtsDot3Onu2CtcSipMgPort) {
		getProperty(utsDot3Onu2CtcSipMgPort).setValue(
				aUtsDot3Onu2CtcSipMgPort);
	}

	public String getUtsDot3Onu2CtcSipProxyServIp() {
		return (String) getProperty(utsDot3Onu2CtcSipProxyServIp)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipProxyServIp(
			String aUtsDot3Onu2CtcSipProxyServIp) {
		getProperty(utsDot3Onu2CtcSipProxyServIp).setValue(
				aUtsDot3Onu2CtcSipProxyServIp);
	}

	public Integer getUtsDot3Onu2CtcSipProxyServComPort() {
		return (Integer) getProperty(utsDot3Onu2CtcSipProxyServComPort)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipProxyServComPort(
			Integer aUtsDot3Onu2CtcSipProxyServComPort) {
		getProperty(utsDot3Onu2CtcSipProxyServComPort).setValue(
				aUtsDot3Onu2CtcSipProxyServComPort);
	}

	public String getUtsDot3Onu2CtcSipBackupProxyServIp() {
		return (String) getProperty(utsDot3Onu2CtcSipBackupProxyServIp)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipBackupProxyServIp(
			String aUtsDot3Onu2CtcSipBackupProxyServIp) {
		getProperty(utsDot3Onu2CtcSipBackupProxyServIp).setValue(
				aUtsDot3Onu2CtcSipBackupProxyServIp);
	}

	public Integer getUtsDot3Onu2CtcSipBackupProxyServComPort() {
		return (Integer) getProperty(utsDot3Onu2CtcSipBackupProxyServComPort)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipBackupProxyServComPort(
			Integer aUtsDot3Onu2CtcSipBackupProxyServComPort) {
		getProperty(utsDot3Onu2CtcSipBackupProxyServComPort).setValue(
				aUtsDot3Onu2CtcSipBackupProxyServComPort);
	}

	public Integer getUtsDot3Onu2CtcSipActiveProxyServ() {
		return (Integer) getProperty(utsDot3Onu2CtcSipActiveProxyServ)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipActiveProxyServ(
			Integer aUtsDot3Onu2CtcSipActiveProxyServ) {
		getProperty(utsDot3Onu2CtcSipActiveProxyServ).setValue(
				aUtsDot3Onu2CtcSipActiveProxyServ);
	}

	public String getUtsDot3Onu2CtcSipRegServIp() {
		return (String) getProperty(utsDot3Onu2CtcSipRegServIp)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipRegServIp(
			String aUtsDot3Onu2CtcSipRegServIp) {
		getProperty(utsDot3Onu2CtcSipRegServIp).setValue(
				aUtsDot3Onu2CtcSipRegServIp);
	}

	public Integer getUtsDot3Onu2CtcSipRegServComPort() {
		return (Integer) getProperty(utsDot3Onu2CtcSipRegServComPort)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipRegServComPort(
			Integer aUtsDot3Onu2CtcSipRegServComPort) {
		getProperty(utsDot3Onu2CtcSipRegServComPort).setValue(
				aUtsDot3Onu2CtcSipRegServComPort);
	}

	public String getUtsDot3Onu2CtcSipBackupRegServIp() {
		return (String) getProperty(utsDot3Onu2CtcSipBackupRegServIp)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipBackupRegServIp(
			String aUtsDot3Onu2CtcSipBackupRegServIp) {
		getProperty(utsDot3Onu2CtcSipBackupRegServIp).setValue(
				aUtsDot3Onu2CtcSipBackupRegServIp);
	}

	public Integer getUtsDot3Onu2CtcSipBackupRegServComPort() {
		return (Integer) getProperty(utsDot3Onu2CtcSipBackupRegServComPort)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipBackupRegServComPort(
			Integer aUtsDot3Onu2CtcSipBackupRegServComPort) {
		getProperty(utsDot3Onu2CtcSipBackupRegServComPort).setValue(
				aUtsDot3Onu2CtcSipBackupRegServComPort);
	}

	public String getUtsDot3Onu2CtcSipOutBoundServIp() {
		return (String) getProperty(utsDot3Onu2CtcSipOutBoundServIp)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipOutBoundServIp(
			String aUtsDot3Onu2CtcSipOutBoundServIp) {
		getProperty(utsDot3Onu2CtcSipOutBoundServIp).setValue(
				aUtsDot3Onu2CtcSipOutBoundServIp);
	}

	public Integer getUtsDot3Onu2CtcSipOutBoundServPort() {
		return (Integer) getProperty(utsDot3Onu2CtcSipOutBoundServPort)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipOutBoundServPort(
			Integer aUtsDot3Onu2CtcSipOutBoundServPort) {
		getProperty(utsDot3Onu2CtcSipOutBoundServPort).setValue(
				aUtsDot3Onu2CtcSipOutBoundServPort);
	}

	public Integer getUtsDot3Onu2CtcSipRegInterval() {
		return (Integer) getProperty(utsDot3Onu2CtcSipRegInterval).getValue();
	}

	public void setUtsDot3Onu2CtcSipRegInterval(
			Integer aUtsDot3Onu2CtcSipRegInterval) {
		getProperty(utsDot3Onu2CtcSipRegInterval).setValue(
				aUtsDot3Onu2CtcSipRegInterval);
	}

	public Integer getUtsDot3Onu2CtcSipHeartbeatSwitch() {
		return (Integer) getProperty(utsDot3Onu2CtcSipHeartbeatSwitch)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipHeartbeatSwitch(
			Integer aUtsDot3Onu2CtcSipHeartbeatSwitch) {
		getProperty(utsDot3Onu2CtcSipHeartbeatSwitch).setValue(
				aUtsDot3Onu2CtcSipHeartbeatSwitch);
	}

	public Integer getUtsDot3Onu2CtcSipHeartbeatCycle() {
		return (Integer) getProperty(utsDot3Onu2CtcSipHeartbeatCycle)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipHeartbeatCycle(
			Integer aUtsDot3Onu2CtcSipHeartbeatCycle) {
		getProperty(utsDot3Onu2CtcSipHeartbeatCycle).setValue(
				aUtsDot3Onu2CtcSipHeartbeatCycle);
	}

	public Integer getUtsDot3Onu2CtcSipHeartbeatCount() {
		return (Integer) getProperty(utsDot3Onu2CtcSipHeartbeatCount)
				.getValue();
	}

	public void setUtsDot3Onu2CtcSipHeartbeatCount(
			Integer aUtsDot3Onu2CtcSipHeartbeatCount) {
		getProperty(utsDot3Onu2CtcSipHeartbeatCount).setValue(
				aUtsDot3Onu2CtcSipHeartbeatCount);
	}

	public String getUtsDot3Onu2CtcSipDigitmap() {
		return ((String) getProperty(utsDot3Onu2CtcSipDigitmap).getValue()).trim();
	}

	public void setUtsDot3Onu2CtcSipDigitmap(String aUtsDot3Onu2CtcSipDigitmap) {
		getProperty(utsDot3Onu2CtcSipDigitmap).setValue(
				aUtsDot3Onu2CtcSipDigitmap);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcSipMgPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipProxyServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipProxyServComPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipBackupProxyServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipBackupProxyServComPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipActiveProxyServ));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipRegServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipRegServComPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipBackupRegServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipBackupRegServComPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipOutBoundServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipOutBoundServPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipRegInterval));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipHeartbeatSwitch));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipHeartbeatCycle));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipHeartbeatCount));
		
//		boolean bl = load();
//		if(!bl) return bl;
//		
//		prepareRead(super.getProperty(utsDot3Onu2CtcSipDigitmap));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcSipMgPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipProxyServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipProxyServComPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipBackupProxyServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipBackupProxyServComPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipActiveProxyServ));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipRegServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipRegServComPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipBackupRegServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipBackupRegServComPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipOutBoundServIp));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipOutBoundServPort));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipRegInterval));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipHeartbeatSwitch));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipHeartbeatCycle));
		prepareRead(super.getProperty(utsDot3Onu2CtcSipHeartbeatCount));
		
//		Vector sipSettingTable = loadAll(new int[] { 1, 1, 1, 1 });
//		
//		prepareRead(super.getProperty(utsDot3Onu2CtcSipDigitmap));
		
		return loadAll(new int[] { 1, 1, 1, 1 });

//		Vector mapTable = loadAll(new int[] { 1, 1, 1, 1 });
//		
//		Hashtable<String, Dot3Onu2VoipSipSettingTable> index2MapBean = new Hashtable<String, Dot3Onu2VoipSipSettingTable>();
//        for (Object mBeanObj : mapTable) {
//        	Dot3Onu2VoipSipSettingTable mBean = (Dot3Onu2VoipSipSettingTable) mBeanObj;
//            Integer moduleId = mBean.getUtsDot3Onu2CtcCombinedFeaturesModuleId();
//            Integer deviceId = mBean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId();
//            Integer portId = mBean.getUtsDot3Onu2CtcCombinedFeaturesPortId();
//            Integer logicalId = mBean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId();
//
//            index2MapBean.put(moduleId + "-" + deviceId + "-" + portId + "-" + logicalId, mBean);
//        }
//
//		Vector result = new Vector();
//		for (Object mBeanObj : sipSettingTable) {
//			Dot3Onu2VoipSipSettingTable mBean = (Dot3Onu2VoipSipSettingTable) mBeanObj;
//			Integer moduleId = mBean.getUtsDot3Onu2CtcCombinedFeaturesModuleId();
//            Integer deviceId = mBean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId();
//            Integer portId = mBean.getUtsDot3Onu2CtcCombinedFeaturesPortId();
//            Integer logicalId = mBean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId();
//
//			mBean.setUtsDot3Onu2CtcSipDigitmap(index2MapBean.get(
//					moduleId + "-" + deviceId + "-" + portId + "-" + logicalId)
//					.getUtsDot3Onu2CtcSipDigitmap());
//			result.add(mBean);
//		}
//        
//        return result;
	}

	public boolean modify() throws MibBeanException {		
		prepareSave(getProperty(utsDot3Onu2CtcSipMgPort));
		prepareSave(getProperty(utsDot3Onu2CtcSipProxyServIp));
		prepareSave(getProperty(utsDot3Onu2CtcSipProxyServComPort));
		prepareSave(getProperty(utsDot3Onu2CtcSipBackupProxyServIp));
		prepareSave(getProperty(utsDot3Onu2CtcSipBackupProxyServComPort));
		prepareSave(getProperty(utsDot3Onu2CtcSipActiveProxyServ));
		prepareSave(getProperty(utsDot3Onu2CtcSipRegServIp));
		prepareSave(getProperty(utsDot3Onu2CtcSipRegServComPort));
		prepareSave(getProperty(utsDot3Onu2CtcSipBackupRegServIp));
		prepareSave(getProperty(utsDot3Onu2CtcSipBackupRegServComPort));
		prepareSave(getProperty(utsDot3Onu2CtcSipOutBoundServIp));
		prepareSave(getProperty(utsDot3Onu2CtcSipOutBoundServPort));
		prepareSave(getProperty(utsDot3Onu2CtcSipRegInterval));
		prepareSave(getProperty(utsDot3Onu2CtcSipHeartbeatSwitch));
		prepareSave(getProperty(utsDot3Onu2CtcSipHeartbeatCycle));
		prepareSave(getProperty(utsDot3Onu2CtcSipHeartbeatCount));
		boolean bl1 = save();
        if (!bl1)
            return bl1;
        
		prepareSave(getProperty(utsDot3Onu2CtcSipDigitmap));

		return save();
	}

}

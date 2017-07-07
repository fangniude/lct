package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2VoipPingTestResultTable class. Created by QuickDVM
 */
public class Dot3Onu2VoipPingTestResultTable extends SnmpMibBean {
	public static final String utsDot3Onu2VoipModuleId = "utsDot3Onu2VoipModuleId";
	public static final String utsDot3Onu2VoipDeviceId = "utsDot3Onu2VoipDeviceId";
	public static final String utsDot3Onu2VoipPortId = "utsDot3Onu2VoipPortId";
	public static final String utsDot3Onu2VoipLogicalPortId = "utsDot3Onu2VoipLogicalPortId";
	public static final String utsDot3Onu2VoipPingTestResult = "utsDot3Onu2VoipPingTestResult";
	public static final String utsDot3Onu2VoipPingTxPackets = "utsDot3Onu2VoipPingTxPackets";
	public static final String utsDot3Onu2VoipPingRxPackets = "utsDot3Onu2VoipPingRxPackets";
	public static final String utsDot3Onu2VoipPingLostPackets = "utsDot3Onu2VoipPingLostPackets";
	public static final String utsDot3Onu2VoipPingLostPktRatio = "utsDot3Onu2VoipPingLostPktRatio";
	public static final String utsDot3Onu2VoipPingMinDelay = "utsDot3Onu2VoipPingMinDelay";
	public static final String utsDot3Onu2VoipPingMaxDelay = "utsDot3Onu2VoipPingMaxDelay";
	public static final String utsDot3Onu2VoipPingAvgDelay = "utsDot3Onu2VoipPingAvgDelay";

	public Dot3Onu2VoipPingTestResultTable(ISnmpProxy aSnmpProxy) {
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
		initProperty(utsDot3Onu2VoipPingTestResult, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingTestResult,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.62.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingTxPackets, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingTxPackets,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.62.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingRxPackets, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingRxPackets,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.62.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingLostPackets, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingLostPackets,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.62.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingLostPktRatio, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingLostPktRatio,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.62.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingMinDelay, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingMinDelay,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.62.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingMaxDelay, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingMaxDelay,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.62.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2VoipPingAvgDelay, new SnmpMibBeanProperty(
				utsDot3Onu2VoipPingAvgDelay,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.62.1.8",
				ISnmpConstant.INTEGER));

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

	public Integer getUtsDot3Onu2VoipPingTestResult() {
		return (Integer) getProperty(utsDot3Onu2VoipPingTestResult).getValue();
	}

	public void setUtsDot3Onu2VoipPingTestResult(
			Integer aUtsDot3Onu2VoipPingTestResult) {
		getProperty(utsDot3Onu2VoipPingTestResult).setValue(
				aUtsDot3Onu2VoipPingTestResult);
	}

	public Integer getUtsDot3Onu2VoipPingTxPackets() {
		return (Integer) getProperty(utsDot3Onu2VoipPingTxPackets).getValue();
	}

	public void setUtsDot3Onu2VoipPingTxPackets(
			Integer aUtsDot3Onu2VoipPingTxPackets) {
		getProperty(utsDot3Onu2VoipPingTxPackets).setValue(
				aUtsDot3Onu2VoipPingTxPackets);
	}

	public Integer getUtsDot3Onu2VoipPingRxPackets() {
		return (Integer) getProperty(utsDot3Onu2VoipPingRxPackets).getValue();
	}

	public void setUtsDot3Onu2VoipPingRxPackets(
			Integer aUtsDot3Onu2VoipPingRxPackets) {
		getProperty(utsDot3Onu2VoipPingRxPackets).setValue(
				aUtsDot3Onu2VoipPingRxPackets);
	}

	public Integer getUtsDot3Onu2VoipPingLostPackets() {
		return (Integer) getProperty(utsDot3Onu2VoipPingLostPackets).getValue();
	}

	public void setUtsDot3Onu2VoipPingLostPackets(
			Integer aUtsDot3Onu2VoipPingLostPackets) {
		getProperty(utsDot3Onu2VoipPingLostPackets).setValue(
				aUtsDot3Onu2VoipPingLostPackets);
	}

	public Integer getUtsDot3Onu2VoipPingLostPktRatio() {
		return (Integer) getProperty(utsDot3Onu2VoipPingLostPktRatio)
				.getValue();
	}

	public void setUtsDot3Onu2VoipPingLostPktRatio(
			Integer aUtsDot3Onu2VoipPingLostPktRatio) {
		getProperty(utsDot3Onu2VoipPingLostPktRatio).setValue(
				aUtsDot3Onu2VoipPingLostPktRatio);
	}

	public Integer getUtsDot3Onu2VoipPingMinDelay() {
		return (Integer) getProperty(utsDot3Onu2VoipPingMinDelay).getValue();
	}

	public void setUtsDot3Onu2VoipPingMinDelay(
			Integer aUtsDot3Onu2VoipPingMinDelay) {
		getProperty(utsDot3Onu2VoipPingMinDelay).setValue(
				aUtsDot3Onu2VoipPingMinDelay);
	}

	public Integer getUtsDot3Onu2VoipPingMaxDelay() {
		return (Integer) getProperty(utsDot3Onu2VoipPingMaxDelay).getValue();
	}

	public void setUtsDot3Onu2VoipPingMaxDelay(
			Integer aUtsDot3Onu2VoipPingMaxDelay) {
		getProperty(utsDot3Onu2VoipPingMaxDelay).setValue(
				aUtsDot3Onu2VoipPingMaxDelay);
	}

	public Integer getUtsDot3Onu2VoipPingAvgDelay() {
		return (Integer) getProperty(utsDot3Onu2VoipPingAvgDelay).getValue();
	}

	public void setUtsDot3Onu2VoipPingAvgDelay(
			Integer aUtsDot3Onu2VoipPingAvgDelay) {
		getProperty(utsDot3Onu2VoipPingAvgDelay).setValue(
				aUtsDot3Onu2VoipPingAvgDelay);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestResult));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTxPackets));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingRxPackets));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingLostPackets));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingLostPktRatio));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingMinDelay));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingMaxDelay));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingAvgDelay));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTestResult));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingTxPackets));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingRxPackets));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingLostPackets));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingLostPktRatio));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingMinDelay));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingMaxDelay));
		prepareRead(super.getProperty(utsDot3Onu2VoipPingAvgDelay));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

}

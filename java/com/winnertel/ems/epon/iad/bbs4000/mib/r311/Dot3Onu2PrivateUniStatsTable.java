package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

/**
 * The Dot3Onu2PrivateUniStatsTable class. Created by QuickDVM
 */
public class Dot3Onu2PrivateUniStatsTable extends SnmpMibBean {
	public static final String utsDot3Onu2Ctc3UniModuleId = "utsDot3Onu2Ctc3UniModuleId";
	public static final String utsDot3Onu2Ctc3UniDeviceId = "utsDot3Onu2Ctc3UniDeviceId";
	public static final String utsDot3Onu2Ctc3UniPortId = "utsDot3Onu2Ctc3UniPortId";
	public static final String utsDot3Onu2Ctc3UniLogicalPortId = "utsDot3Onu2Ctc3UniLogicalPortId";
	public static final String utsDot3Onu2Ctc3UniPhyPortId = "utsDot3Onu2Ctc3UniPhyPortId";
	public static final String utsDot3Onu2PrivateUniOctetsReceivedOK = "utsDot3Onu2PrivateUniOctetsReceivedOK";
	public static final String utsDot3Onu2PrivateUniOctetsReceivedBD = "utsDot3Onu2PrivateUniOctetsReceivedBD";
	public static final String utsDot3Onu2PrivateUniBroadcastFramesReceivedOK = "utsDot3Onu2PrivateUniBroadcastFramesReceivedOK";
	public static final String utsDot3Onu2PrivateUniMulticastFramesReceivedOK = "utsDot3Onu2PrivateUniMulticastFramesReceivedOK";
	public static final String utsDot3Onu2PrivateUniUnicastFramesReceivedOK = "utsDot3Onu2PrivateUniUnicastFramesReceivedOK";
	public static final String utsDot3Onu2PrivateUniPONPauseFramesReceivedOK = "utsDot3Onu2PrivateUniPONPauseFramesReceivedOK";
	public static final String utsDot3Onu2PrivateUniMacReceivedErrorFrame = "utsDot3Onu2PrivateUniMacReceivedErrorFrame";
	public static final String utsDot3Onu2PrivateUniFCSReceivedErrorFrame = "utsDot3Onu2PrivateUniFCSReceivedErrorFrame";
	public static final String utsDot3Onu2PrivateUniUnderSizeFrame = "utsDot3Onu2PrivateUniUnderSizeFrame";
	public static final String utsDot3Onu2PrivateUniOverSizeFrame = "utsDot3Onu2PrivateUniOverSizeFrame";
	public static final String utsDot3Onu2PrivateUniJabberFrame = "utsDot3Onu2PrivateUniJabberFrame";
	public static final String utsDot3Onu2PrivateUniOctetsTransmittedOK = "utsDot3Onu2PrivateUniOctetsTransmittedOK";
	public static final String utsDot3Onu2PrivateUniBroadcastFramesXmittedOK = "utsDot3Onu2PrivateUniBroadcastFramesXmittedOK";
	public static final String utsDot3Onu2PrivateUniMulticastFramesXmittedOK = "utsDot3Onu2PrivateUniMulticastFramesXmittedOK";
	public static final String utsDot3Onu2PrivateUniUnicasetFramesXmittedOK = "utsDot3Onu2PrivateUniUnicasetFramesXmittedOK";
	public static final String utsDot3Onu2PrivateUniPONPauseFramesXmittedOK = "utsDot3Onu2PrivateUniPONPauseFramesXmittedOK";
	public static final String utsDot3Onu2PrivateUniFCSTransmittedErrorFrame = "utsDot3Onu2PrivateUniFCSTransmittedErrorFrame";
	public static final String utsDot3Onu2PrivateUniDeferredFrame = "utsDot3Onu2PrivateUniDeferredFrame";
	public static final String utsDot3Onu2PrivateUniExcessiveFrame = "utsDot3Onu2PrivateUniExcessiveFrame";
	public static final String utsDot3Onu2PrivateUniSingleCollisionFrames = "utsDot3Onu2PrivateUniSingleCollisionFrames";
	public static final String utsDot3Onu2PrivateUniMultipleCollisionFrames = "utsDot3Onu2PrivateUniMultipleCollisionFrames";
	public static final String utsDot3Onu2PrivateUniLateFrames = "utsDot3Onu2PrivateUniLateFrames";
	public static final String utsDot3Onu2PrivateUniCollisionFrames = "utsDot3Onu2PrivateUniCollisionFrames";
	public static final String utsDot3Onu2PrivateUniRxTx64Octets = "utsDot3Onu2PrivateUniRxTx64Octets";
	public static final String utsDot3Onu2PrivateUniRxTx65to127Octets = "utsDot3Onu2PrivateUniRxTx65to127Octets";
	public static final String utsDot3Onu2PrivateUniRxTx128to255Octets = "utsDot3Onu2PrivateUniRxTx128to255Octets";
	public static final String utsDot3Onu2PrivateUniRxTx256to511Octets = "utsDot3Onu2PrivateUniRxTx256to511Octets";
	public static final String utsDot3Onu2PrivateUniRxTx512to1023Octets = "utsDot3Onu2PrivateUniRxTx512to1023Octets";
	public static final String utsDot3Onu2PrivateUniRxTx1024MoreOctets = "utsDot3Onu2PrivateUniRxTx1024MoreOctets";

	public Dot3Onu2PrivateUniStatsTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2Ctc3UniModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniLogicalPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniPhyPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniPhyPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniOctetsReceivedOK,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniOctetsReceivedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.1",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PrivateUniOctetsReceivedBD,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniOctetsReceivedBD,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.2",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PrivateUniBroadcastFramesReceivedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniBroadcastFramesReceivedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.3",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniMulticastFramesReceivedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniMulticastFramesReceivedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.4",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniUnicastFramesReceivedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniUnicastFramesReceivedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.5",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniPONPauseFramesReceivedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniPONPauseFramesReceivedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.6",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniMacReceivedErrorFrame,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniMacReceivedErrorFrame,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.7",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniFCSReceivedErrorFrame,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniFCSReceivedErrorFrame,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.8",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniUnderSizeFrame,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniUnderSizeFrame,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.9",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniOverSizeFrame,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniOverSizeFrame,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.10",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniJabberFrame, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniJabberFrame,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.11",
				ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniOctetsTransmittedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniOctetsTransmittedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.12",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PrivateUniBroadcastFramesXmittedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniBroadcastFramesXmittedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.13",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniMulticastFramesXmittedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniMulticastFramesXmittedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.14",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniUnicasetFramesXmittedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniUnicasetFramesXmittedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.15",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniPONPauseFramesXmittedOK,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniPONPauseFramesXmittedOK,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.16",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniFCSTransmittedErrorFrame,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniFCSTransmittedErrorFrame,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.17",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniDeferredFrame,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniDeferredFrame,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.18",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniExcessiveFrame,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniExcessiveFrame,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.19",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniSingleCollisionFrames,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniSingleCollisionFrames,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.20",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniMultipleCollisionFrames,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniMultipleCollisionFrames,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.21",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniLateFrames, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniLateFrames,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.22",
				ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniCollisionFrames,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniCollisionFrames,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.23",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniRxTx64Octets,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniRxTx64Octets,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.24",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniRxTx65to127Octets,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniRxTx65to127Octets,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.25",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniRxTx128to255Octets,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniRxTx128to255Octets,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.26",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniRxTx256to511Octets,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniRxTx256to511Octets,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.27",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniRxTx512to1023Octets,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniRxTx512to1023Octets,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.28",
						ISnmpConstant.COUNTER));
		initProperty(utsDot3Onu2PrivateUniRxTx1024MoreOctets,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateUniRxTx1024MoreOctets,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.105.1.29",
						ISnmpConstant.COUNTER));

	}

	public Integer getUtsDot3Onu2Ctc3UniModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2Ctc3UniModuleId(
			Integer aUtsDot3Onu2Ctc3UniModuleId) {
		setIndex(0, aUtsDot3Onu2Ctc3UniModuleId);
	}

	public Integer getUtsDot3Onu2Ctc3UniDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2Ctc3UniDeviceId(
			Integer aUtsDot3Onu2Ctc3UniDeviceId) {
		setIndex(1, aUtsDot3Onu2Ctc3UniDeviceId);
	}

	public Integer getUtsDot3Onu2Ctc3UniPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2Ctc3UniPortId(Integer aUtsDot3Onu2Ctc3UniPortId) {
		setIndex(2, aUtsDot3Onu2Ctc3UniPortId);
	}

	public Integer getUtsDot3Onu2Ctc3UniLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2Ctc3UniLogicalPortId(
			Integer aUtsDot3Onu2Ctc3UniLogicalPortId) {
		setIndex(3, aUtsDot3Onu2Ctc3UniLogicalPortId);
	}

	public Integer getUtsDot3Onu2Ctc3UniPhyPortId() {
		return (Integer) getIndex(4);
	}

	public void setUtsDot3Onu2Ctc3UniPhyPortId(
			Integer aUtsDot3Onu2Ctc3UniPhyPortId) {
		setIndex(4, aUtsDot3Onu2Ctc3UniPhyPortId);
	}

	public BigInteger getUtsDot3Onu2PrivateUniOctetsReceivedOK() {
		return (BigInteger) getProperty(utsDot3Onu2PrivateUniOctetsReceivedOK)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniOctetsReceivedOK(
			BigInteger aUtsDot3Onu2PrivateUniOctetsReceivedOK) {
		getProperty(utsDot3Onu2PrivateUniOctetsReceivedOK).setValue(
				aUtsDot3Onu2PrivateUniOctetsReceivedOK);
	}

	public BigInteger getUtsDot3Onu2PrivateUniOctetsReceivedBD() {
		return (BigInteger) getProperty(utsDot3Onu2PrivateUniOctetsReceivedBD)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniOctetsReceivedBD(
			BigInteger aUtsDot3Onu2PrivateUniOctetsReceivedBD) {
		getProperty(utsDot3Onu2PrivateUniOctetsReceivedBD).setValue(
				aUtsDot3Onu2PrivateUniOctetsReceivedBD);
	}

	public Long getUtsDot3Onu2PrivateUniBroadcastFramesReceivedOK() {
		return (Long) getProperty(
				utsDot3Onu2PrivateUniBroadcastFramesReceivedOK).getValue();
	}

	public void setUtsDot3Onu2PrivateUniBroadcastFramesReceivedOK(
			Long aUtsDot3Onu2PrivateUniBroadcastFramesReceivedOK) {
		getProperty(utsDot3Onu2PrivateUniBroadcastFramesReceivedOK).setValue(
				aUtsDot3Onu2PrivateUniBroadcastFramesReceivedOK);
	}

	public Long getUtsDot3Onu2PrivateUniMulticastFramesReceivedOK() {
		return (Long) getProperty(
				utsDot3Onu2PrivateUniMulticastFramesReceivedOK).getValue();
	}

	public void setUtsDot3Onu2PrivateUniMulticastFramesReceivedOK(
			Long aUtsDot3Onu2PrivateUniMulticastFramesReceivedOK) {
		getProperty(utsDot3Onu2PrivateUniMulticastFramesReceivedOK).setValue(
				aUtsDot3Onu2PrivateUniMulticastFramesReceivedOK);
	}

	public Long getUtsDot3Onu2PrivateUniUnicastFramesReceivedOK() {
		return (Long) getProperty(utsDot3Onu2PrivateUniUnicastFramesReceivedOK)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniUnicastFramesReceivedOK(
			Long aUtsDot3Onu2PrivateUniUnicastFramesReceivedOK) {
		getProperty(utsDot3Onu2PrivateUniUnicastFramesReceivedOK).setValue(
				aUtsDot3Onu2PrivateUniUnicastFramesReceivedOK);
	}

	public Long getUtsDot3Onu2PrivateUniPONPauseFramesReceivedOK() {
		return (Long) getProperty(utsDot3Onu2PrivateUniPONPauseFramesReceivedOK)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniPONPauseFramesReceivedOK(
			Long aUtsDot3Onu2PrivateUniPONPauseFramesReceivedOK) {
		getProperty(utsDot3Onu2PrivateUniPONPauseFramesReceivedOK).setValue(
				aUtsDot3Onu2PrivateUniPONPauseFramesReceivedOK);
	}

	public Long getUtsDot3Onu2PrivateUniMacReceivedErrorFrame() {
		return (Long) getProperty(utsDot3Onu2PrivateUniMacReceivedErrorFrame)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniMacReceivedErrorFrame(
			Long aUtsDot3Onu2PrivateUniMacReceivedErrorFrame) {
		getProperty(utsDot3Onu2PrivateUniMacReceivedErrorFrame).setValue(
				aUtsDot3Onu2PrivateUniMacReceivedErrorFrame);
	}

	public Long getUtsDot3Onu2PrivateUniFCSReceivedErrorFrame() {
		return (Long) getProperty(utsDot3Onu2PrivateUniFCSReceivedErrorFrame)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniFCSReceivedErrorFrame(
			Long aUtsDot3Onu2PrivateUniFCSReceivedErrorFrame) {
		getProperty(utsDot3Onu2PrivateUniFCSReceivedErrorFrame).setValue(
				aUtsDot3Onu2PrivateUniFCSReceivedErrorFrame);
	}

	public Long getUtsDot3Onu2PrivateUniUnderSizeFrame() {
		return (Long) getProperty(utsDot3Onu2PrivateUniUnderSizeFrame)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniUnderSizeFrame(
			Long aUtsDot3Onu2PrivateUniUnderSizeFrame) {
		getProperty(utsDot3Onu2PrivateUniUnderSizeFrame).setValue(
				aUtsDot3Onu2PrivateUniUnderSizeFrame);
	}

	public Long getUtsDot3Onu2PrivateUniOverSizeFrame() {
		return (Long) getProperty(utsDot3Onu2PrivateUniOverSizeFrame)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniOverSizeFrame(
			Long aUtsDot3Onu2PrivateUniOverSizeFrame) {
		getProperty(utsDot3Onu2PrivateUniOverSizeFrame).setValue(
				aUtsDot3Onu2PrivateUniOverSizeFrame);
	}

	public Long getUtsDot3Onu2PrivateUniJabberFrame() {
		return (Long) getProperty(utsDot3Onu2PrivateUniJabberFrame).getValue();
	}

	public void setUtsDot3Onu2PrivateUniJabberFrame(
			Long aUtsDot3Onu2PrivateUniJabberFrame) {
		getProperty(utsDot3Onu2PrivateUniJabberFrame).setValue(
				aUtsDot3Onu2PrivateUniJabberFrame);
	}

	public BigInteger getUtsDot3Onu2PrivateUniOctetsTransmittedOK() {
		return (BigInteger) getProperty(
				utsDot3Onu2PrivateUniOctetsTransmittedOK).getValue();
	}

	public void setUtsDot3Onu2PrivateUniOctetsTransmittedOK(
			BigInteger aUtsDot3Onu2PrivateUniOctetsTransmittedOK) {
		getProperty(utsDot3Onu2PrivateUniOctetsTransmittedOK).setValue(
				aUtsDot3Onu2PrivateUniOctetsTransmittedOK);
	}

	public Long getUtsDot3Onu2PrivateUniBroadcastFramesXmittedOK() {
		return (Long) getProperty(utsDot3Onu2PrivateUniBroadcastFramesXmittedOK)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniBroadcastFramesXmittedOK(
			Long aUtsDot3Onu2PrivateUniBroadcastFramesXmittedOK) {
		getProperty(utsDot3Onu2PrivateUniBroadcastFramesXmittedOK).setValue(
				aUtsDot3Onu2PrivateUniBroadcastFramesXmittedOK);
	}

	public Long getUtsDot3Onu2PrivateUniMulticastFramesXmittedOK() {
		return (Long) getProperty(utsDot3Onu2PrivateUniMulticastFramesXmittedOK)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniMulticastFramesXmittedOK(
			Long aUtsDot3Onu2PrivateUniMulticastFramesXmittedOK) {
		getProperty(utsDot3Onu2PrivateUniMulticastFramesXmittedOK).setValue(
				aUtsDot3Onu2PrivateUniMulticastFramesXmittedOK);
	}

	public Long getUtsDot3Onu2PrivateUniUnicasetFramesXmittedOK() {
		return (Long) getProperty(utsDot3Onu2PrivateUniUnicasetFramesXmittedOK)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniUnicasetFramesXmittedOK(
			Long aUtsDot3Onu2PrivateUniUnicasetFramesXmittedOK) {
		getProperty(utsDot3Onu2PrivateUniUnicasetFramesXmittedOK).setValue(
				aUtsDot3Onu2PrivateUniUnicasetFramesXmittedOK);
	}

	public Long getUtsDot3Onu2PrivateUniPONPauseFramesXmittedOK() {
		return (Long) getProperty(utsDot3Onu2PrivateUniPONPauseFramesXmittedOK)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniPONPauseFramesXmittedOK(
			Long aUtsDot3Onu2PrivateUniPONPauseFramesXmittedOK) {
		getProperty(utsDot3Onu2PrivateUniPONPauseFramesXmittedOK).setValue(
				aUtsDot3Onu2PrivateUniPONPauseFramesXmittedOK);
	}

	public Long getUtsDot3Onu2PrivateUniFCSTransmittedErrorFrame() {
		return (Long) getProperty(utsDot3Onu2PrivateUniFCSTransmittedErrorFrame)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniFCSTransmittedErrorFrame(
			Long aUtsDot3Onu2PrivateUniFCSTransmittedErrorFrame) {
		getProperty(utsDot3Onu2PrivateUniFCSTransmittedErrorFrame).setValue(
				aUtsDot3Onu2PrivateUniFCSTransmittedErrorFrame);
	}

	public Long getUtsDot3Onu2PrivateUniDeferredFrame() {
		return (Long) getProperty(utsDot3Onu2PrivateUniDeferredFrame)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniDeferredFrame(
			Long aUtsDot3Onu2PrivateUniDeferredFrame) {
		getProperty(utsDot3Onu2PrivateUniDeferredFrame).setValue(
				aUtsDot3Onu2PrivateUniDeferredFrame);
	}

	public Long getUtsDot3Onu2PrivateUniExcessiveFrame() {
		return (Long) getProperty(utsDot3Onu2PrivateUniExcessiveFrame)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniExcessiveFrame(
			Long aUtsDot3Onu2PrivateUniExcessiveFrame) {
		getProperty(utsDot3Onu2PrivateUniExcessiveFrame).setValue(
				aUtsDot3Onu2PrivateUniExcessiveFrame);
	}

	public Long getUtsDot3Onu2PrivateUniSingleCollisionFrames() {
		return (Long) getProperty(utsDot3Onu2PrivateUniSingleCollisionFrames)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniSingleCollisionFrames(
			Long aUtsDot3Onu2PrivateUniSingleCollisionFrames) {
		getProperty(utsDot3Onu2PrivateUniSingleCollisionFrames).setValue(
				aUtsDot3Onu2PrivateUniSingleCollisionFrames);
	}

	public Long getUtsDot3Onu2PrivateUniMultipleCollisionFrames() {
		return (Long) getProperty(utsDot3Onu2PrivateUniMultipleCollisionFrames)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniMultipleCollisionFrames(
			Long aUtsDot3Onu2PrivateUniMultipleCollisionFrames) {
		getProperty(utsDot3Onu2PrivateUniMultipleCollisionFrames).setValue(
				aUtsDot3Onu2PrivateUniMultipleCollisionFrames);
	}

	public Long getUtsDot3Onu2PrivateUniLateFrames() {
		return (Long) getProperty(utsDot3Onu2PrivateUniLateFrames).getValue();
	}

	public void setUtsDot3Onu2PrivateUniLateFrames(
			Long aUtsDot3Onu2PrivateUniLateFrames) {
		getProperty(utsDot3Onu2PrivateUniLateFrames).setValue(
				aUtsDot3Onu2PrivateUniLateFrames);
	}

	public Long getUtsDot3Onu2PrivateUniCollisionFrames() {
		return (Long) getProperty(utsDot3Onu2PrivateUniCollisionFrames)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniCollisionFrames(
			Long aUtsDot3Onu2PrivateUniCollisionFrames) {
		getProperty(utsDot3Onu2PrivateUniCollisionFrames).setValue(
				aUtsDot3Onu2PrivateUniCollisionFrames);
	}

	public Long getUtsDot3Onu2PrivateUniRxTx64Octets() {
		return (Long) getProperty(utsDot3Onu2PrivateUniRxTx64Octets).getValue();
	}

	public void setUtsDot3Onu2PrivateUniRxTx64Octets(
			Long aUtsDot3Onu2PrivateUniRxTx64Octets) {
		getProperty(utsDot3Onu2PrivateUniRxTx64Octets).setValue(
				aUtsDot3Onu2PrivateUniRxTx64Octets);
	}

	public Long getUtsDot3Onu2PrivateUniRxTx65to127Octets() {
		return (Long) getProperty(utsDot3Onu2PrivateUniRxTx65to127Octets)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniRxTx65to127Octets(
			Long aUtsDot3Onu2PrivateUniRxTx65to127Octets) {
		getProperty(utsDot3Onu2PrivateUniRxTx65to127Octets).setValue(
				aUtsDot3Onu2PrivateUniRxTx65to127Octets);
	}

	public Long getUtsDot3Onu2PrivateUniRxTx128to255Octets() {
		return (Long) getProperty(utsDot3Onu2PrivateUniRxTx128to255Octets)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniRxTx128to255Octets(
			Long aUtsDot3Onu2PrivateUniRxTx128to255Octets) {
		getProperty(utsDot3Onu2PrivateUniRxTx128to255Octets).setValue(
				aUtsDot3Onu2PrivateUniRxTx128to255Octets);
	}

	public Long getUtsDot3Onu2PrivateUniRxTx256to511Octets() {
		return (Long) getProperty(utsDot3Onu2PrivateUniRxTx256to511Octets)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniRxTx256to511Octets(
			Long aUtsDot3Onu2PrivateUniRxTx256to511Octets) {
		getProperty(utsDot3Onu2PrivateUniRxTx256to511Octets).setValue(
				aUtsDot3Onu2PrivateUniRxTx256to511Octets);
	}

	public Long getUtsDot3Onu2PrivateUniRxTx512to1023Octets() {
		return (Long) getProperty(utsDot3Onu2PrivateUniRxTx512to1023Octets)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniRxTx512to1023Octets(
			Long aUtsDot3Onu2PrivateUniRxTx512to1023Octets) {
		getProperty(utsDot3Onu2PrivateUniRxTx512to1023Octets).setValue(
				aUtsDot3Onu2PrivateUniRxTx512to1023Octets);
	}

	public Long getUtsDot3Onu2PrivateUniRxTx1024MoreOctets() {
		return (Long) getProperty(utsDot3Onu2PrivateUniRxTx1024MoreOctets)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniRxTx1024MoreOctets(
			Long aUtsDot3Onu2PrivateUniRxTx1024MoreOctets) {
		getProperty(utsDot3Onu2PrivateUniRxTx1024MoreOctets).setValue(
				aUtsDot3Onu2PrivateUniRxTx1024MoreOctets);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniOctetsReceivedOK));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniOctetsReceivedBD));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniBroadcastFramesReceivedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniMulticastFramesReceivedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniUnicastFramesReceivedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniPONPauseFramesReceivedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniMacReceivedErrorFrame));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniFCSReceivedErrorFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniUnderSizeFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniOverSizeFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniJabberFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniOctetsTransmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniBroadcastFramesXmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniMulticastFramesXmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniUnicasetFramesXmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniPONPauseFramesXmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniFCSTransmittedErrorFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniDeferredFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniExcessiveFrame));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniSingleCollisionFrames));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniMultipleCollisionFrames));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniLateFrames));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCollisionFrames));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx64Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx65to127Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx128to255Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx256to511Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx512to1023Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx1024MoreOctets));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniOctetsReceivedOK));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniOctetsReceivedBD));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniBroadcastFramesReceivedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniMulticastFramesReceivedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniUnicastFramesReceivedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniPONPauseFramesReceivedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniMacReceivedErrorFrame));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniFCSReceivedErrorFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniUnderSizeFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniOverSizeFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniJabberFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniOctetsTransmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniBroadcastFramesXmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniMulticastFramesXmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniUnicasetFramesXmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniPONPauseFramesXmittedOK));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniFCSTransmittedErrorFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniDeferredFrame));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniExcessiveFrame));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniSingleCollisionFrames));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateUniMultipleCollisionFrames));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniLateFrames));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCollisionFrames));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx64Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx65to127Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx128to255Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx256to511Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx512to1023Octets));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniRxTx1024MoreOctets));

		return loadAll(new int[] { 1, 1, 1, 1, 1 });
	}

}
package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

/**
 * The Dot3Onu2PonStatTable class. Created by QuickDVM
 */
public class Dot3Onu2PonStatTable extends SnmpMibBean {
	public static final String utsDot3Onu2Ctc3UniModuleId = "utsDot3Onu2Ctc3UniModuleId";
	public static final String utsDot3Onu2Ctc3UniDeviceId = "utsDot3Onu2Ctc3UniDeviceId";
	public static final String utsDot3Onu2Ctc3UniPortId = "utsDot3Onu2Ctc3UniPortId";
	public static final String utsDot3Onu2Ctc3UniLogicalPortId = "utsDot3Onu2Ctc3UniLogicalPortId";
	public static final String utsDot3Onu2PonStatLlid = "utsDot3Onu2PonStatLlid";
	public static final String utsDot3Onu2PonStatFramesTxOk = "utsDot3Onu2PonStatFramesTxOk";
	public static final String utsDot3Onu2PonStatOctetsTxOk = "utsDot3Onu2PonStatOctetsTxOk";
	public static final String utsDot3Onu2PonStatMulticastFramesTxOk = "utsDot3Onu2PonStatMulticastFramesTxOk";
	public static final String utsDot3Onu2PonStatBroadcastFramesTxOk = "utsDot3Onu2PonStatBroadcastFramesTxOk";
	public static final String utsDot3Onu2PonStatFramesRxOk = "utsDot3Onu2PonStatFramesRxOk";
	public static final String utsDot3Onu2PonStatOctetsRxOk = "utsDot3Onu2PonStatOctetsRxOk";
	public static final String utsDot3Onu2PonStatMulticastFramesRxOk = "utsDot3Onu2PonStatMulticastFramesRxOk";
	public static final String utsDot3Onu2PonStatBroadcastFramesRxOk = "utsDot3Onu2PonStatBroadcastFramesRxOk";
	public static final String utsDot3Onu2PonStatCrcError = "utsDot3Onu2PonStatCrcError";
	public static final String utsDot3Onu2PonStatCorrectFecBlocks = "utsDot3Onu2PonStatCorrectFecBlocks";
	public static final String utsDot3Onu2PonStatUncorrectFecBlocks = "utsDot3Onu2PonStatUncorrectFecBlocks";
	public static final String utsDot3Onu2PonStatTxMpcpControl = "utsDot3Onu2PonStatTxMpcpControl";
	public static final String utsDot3Onu2PonStatRxMpcpControl = "utsDot3Onu2PonStatRxMpcpControl";
	public static final String utsDot3Onu2PonStatTxRegister = "utsDot3Onu2PonStatTxRegister";
	public static final String utsDot3Onu2PonStatTxRegisterRequest = "utsDot3Onu2PonStatTxRegisterRequest";
	public static final String utsDot3Onu2PonStatTxReport = "utsDot3Onu2PonStatTxReport";
	public static final String utsDot3Onu2PonStatRxGate = "utsDot3Onu2PonStatRxGate";
	public static final String utsDot3Onu2PonStatRxRegister = "utsDot3Onu2PonStatRxRegister";

	public Dot3Onu2PonStatTable(ISnmpProxy aSnmpProxy) {
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
		initProperty(utsDot3Onu2PonStatLlid, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatLlid,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PonStatFramesTxOk, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatFramesTxOk,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.2",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatOctetsTxOk, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatOctetsTxOk,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.3",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatMulticastFramesTxOk,
				new SnmpMibBeanProperty(utsDot3Onu2PonStatMulticastFramesTxOk,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.4",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatBroadcastFramesTxOk,
				new SnmpMibBeanProperty(utsDot3Onu2PonStatBroadcastFramesTxOk,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.5",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatFramesRxOk, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatFramesRxOk,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.6",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatOctetsRxOk, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatOctetsRxOk,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.7",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatMulticastFramesRxOk,
				new SnmpMibBeanProperty(utsDot3Onu2PonStatMulticastFramesRxOk,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.8",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatBroadcastFramesRxOk,
				new SnmpMibBeanProperty(utsDot3Onu2PonStatBroadcastFramesRxOk,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.9",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatCrcError, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatCrcError,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.10",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatCorrectFecBlocks,
				new SnmpMibBeanProperty(utsDot3Onu2PonStatCorrectFecBlocks,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.11",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatUncorrectFecBlocks,
				new SnmpMibBeanProperty(utsDot3Onu2PonStatUncorrectFecBlocks,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.12",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatTxMpcpControl, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatTxMpcpControl,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.13",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatRxMpcpControl, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatRxMpcpControl,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.14",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatTxRegister, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatTxRegister,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.15",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatTxRegisterRequest,
				new SnmpMibBeanProperty(utsDot3Onu2PonStatTxRegisterRequest,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.16",
						ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatTxReport, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatTxReport,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.17",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatRxGate, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatRxGate,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.18",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2PonStatRxRegister, new SnmpMibBeanProperty(
				utsDot3Onu2PonStatRxRegister,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.58.1.19",
				ISnmpConstant.COUNTER64));

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

	public Integer getUtsDot3Onu2PonStatLlid() {
		return (Integer) getIndex(4);
	}

	public void setUtsDot3Onu2PonStatLlid(Integer aUtsDot3Onu2PonStatLlid) {
		setIndex(4, aUtsDot3Onu2PonStatLlid);
	}

	public BigInteger getUtsDot3Onu2PonStatFramesTxOk() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatFramesTxOk)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatFramesTxOk(
			BigInteger aUtsDot3Onu2PonStatFramesTxOk) {
		getProperty(utsDot3Onu2PonStatFramesTxOk).setValue(
				aUtsDot3Onu2PonStatFramesTxOk);
	}

	public BigInteger getUtsDot3Onu2PonStatOctetsTxOk() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatOctetsTxOk)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatOctetsTxOk(
			BigInteger aUtsDot3Onu2PonStatOctetsTxOk) {
		getProperty(utsDot3Onu2PonStatOctetsTxOk).setValue(
				aUtsDot3Onu2PonStatOctetsTxOk);
	}

	public BigInteger getUtsDot3Onu2PonStatMulticastFramesTxOk() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatMulticastFramesTxOk)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatMulticastFramesTxOk(
			BigInteger aUtsDot3Onu2PonStatMulticastFramesTxOk) {
		getProperty(utsDot3Onu2PonStatMulticastFramesTxOk).setValue(
				aUtsDot3Onu2PonStatMulticastFramesTxOk);
	}

	public BigInteger getUtsDot3Onu2PonStatBroadcastFramesTxOk() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatBroadcastFramesTxOk)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatBroadcastFramesTxOk(
			BigInteger aUtsDot3Onu2PonStatBroadcastFramesTxOk) {
		getProperty(utsDot3Onu2PonStatBroadcastFramesTxOk).setValue(
				aUtsDot3Onu2PonStatBroadcastFramesTxOk);
	}

	public BigInteger getUtsDot3Onu2PonStatFramesRxOk() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatFramesRxOk)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatFramesRxOk(
			BigInteger aUtsDot3Onu2PonStatFramesRxOk) {
		getProperty(utsDot3Onu2PonStatFramesRxOk).setValue(
				aUtsDot3Onu2PonStatFramesRxOk);
	}

	public BigInteger getUtsDot3Onu2PonStatOctetsRxOk() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatOctetsRxOk)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatOctetsRxOk(
			BigInteger aUtsDot3Onu2PonStatOctetsRxOk) {
		getProperty(utsDot3Onu2PonStatOctetsRxOk).setValue(
				aUtsDot3Onu2PonStatOctetsRxOk);
	}

	public BigInteger getUtsDot3Onu2PonStatMulticastFramesRxOk() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatMulticastFramesRxOk)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatMulticastFramesRxOk(
			BigInteger aUtsDot3Onu2PonStatMulticastFramesRxOk) {
		getProperty(utsDot3Onu2PonStatMulticastFramesRxOk).setValue(
				aUtsDot3Onu2PonStatMulticastFramesRxOk);
	}

	public BigInteger getUtsDot3Onu2PonStatBroadcastFramesRxOk() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatBroadcastFramesRxOk)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatBroadcastFramesRxOk(
			BigInteger aUtsDot3Onu2PonStatBroadcastFramesRxOk) {
		getProperty(utsDot3Onu2PonStatBroadcastFramesRxOk).setValue(
				aUtsDot3Onu2PonStatBroadcastFramesRxOk);
	}

	public BigInteger getUtsDot3Onu2PonStatCrcError() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatCrcError).getValue();
	}

	public void setUtsDot3Onu2PonStatCrcError(
			BigInteger aUtsDot3Onu2PonStatCrcError) {
		getProperty(utsDot3Onu2PonStatCrcError).setValue(
				aUtsDot3Onu2PonStatCrcError);
	}

	public BigInteger getUtsDot3Onu2PonStatCorrectFecBlocks() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatCorrectFecBlocks)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatCorrectFecBlocks(
			BigInteger aUtsDot3Onu2PonStatCorrectFecBlocks) {
		getProperty(utsDot3Onu2PonStatCorrectFecBlocks).setValue(
				aUtsDot3Onu2PonStatCorrectFecBlocks);
	}

	public BigInteger getUtsDot3Onu2PonStatUncorrectFecBlocks() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatUncorrectFecBlocks)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatUncorrectFecBlocks(
			BigInteger aUtsDot3Onu2PonStatUncorrectFecBlocks) {
		getProperty(utsDot3Onu2PonStatUncorrectFecBlocks).setValue(
				aUtsDot3Onu2PonStatUncorrectFecBlocks);
	}

	public BigInteger getUtsDot3Onu2PonStatTxMpcpControl() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatTxMpcpControl)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatTxMpcpControl(
			BigInteger aUtsDot3Onu2PonStatTxMpcpControl) {
		getProperty(utsDot3Onu2PonStatTxMpcpControl).setValue(
				aUtsDot3Onu2PonStatTxMpcpControl);
	}

	public BigInteger getUtsDot3Onu2PonStatRxMpcpControl() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatRxMpcpControl)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatRxMpcpControl(
			BigInteger aUtsDot3Onu2PonStatRxMpcpControl) {
		getProperty(utsDot3Onu2PonStatRxMpcpControl).setValue(
				aUtsDot3Onu2PonStatRxMpcpControl);
	}

	public BigInteger getUtsDot3Onu2PonStatTxRegister() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatTxRegister)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatTxRegister(
			BigInteger aUtsDot3Onu2PonStatTxRegister) {
		getProperty(utsDot3Onu2PonStatTxRegister).setValue(
				aUtsDot3Onu2PonStatTxRegister);
	}

	public BigInteger getUtsDot3Onu2PonStatTxRegisterRequest() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatTxRegisterRequest)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatTxRegisterRequest(
			BigInteger aUtsDot3Onu2PonStatTxRegisterRequest) {
		getProperty(utsDot3Onu2PonStatTxRegisterRequest).setValue(
				aUtsDot3Onu2PonStatTxRegisterRequest);
	}

	public BigInteger getUtsDot3Onu2PonStatTxReport() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatTxReport).getValue();
	}

	public void setUtsDot3Onu2PonStatTxReport(
			BigInteger aUtsDot3Onu2PonStatTxReport) {
		getProperty(utsDot3Onu2PonStatTxReport).setValue(
				aUtsDot3Onu2PonStatTxReport);
	}

	public BigInteger getUtsDot3Onu2PonStatRxGate() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatRxGate).getValue();
	}

	public void setUtsDot3Onu2PonStatRxGate(BigInteger aUtsDot3Onu2PonStatRxGate) {
		getProperty(utsDot3Onu2PonStatRxGate).setValue(
				aUtsDot3Onu2PonStatRxGate);
	}

	public BigInteger getUtsDot3Onu2PonStatRxRegister() {
		return (BigInteger) getProperty(utsDot3Onu2PonStatRxRegister)
				.getValue();
	}

	public void setUtsDot3Onu2PonStatRxRegister(
			BigInteger aUtsDot3Onu2PonStatRxRegister) {
		getProperty(utsDot3Onu2PonStatRxRegister).setValue(
				aUtsDot3Onu2PonStatRxRegister);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PonStatFramesTxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatOctetsTxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatMulticastFramesTxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatBroadcastFramesTxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatFramesRxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatOctetsRxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatMulticastFramesRxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatBroadcastFramesRxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatCrcError));
		prepareRead(super.getProperty(utsDot3Onu2PonStatCorrectFecBlocks));
		prepareRead(super.getProperty(utsDot3Onu2PonStatUncorrectFecBlocks));
		prepareRead(super.getProperty(utsDot3Onu2PonStatTxMpcpControl));
		prepareRead(super.getProperty(utsDot3Onu2PonStatRxMpcpControl));
		prepareRead(super.getProperty(utsDot3Onu2PonStatTxRegister));
		prepareRead(super.getProperty(utsDot3Onu2PonStatTxRegisterRequest));
		prepareRead(super.getProperty(utsDot3Onu2PonStatTxReport));
		prepareRead(super.getProperty(utsDot3Onu2PonStatRxGate));
		prepareRead(super.getProperty(utsDot3Onu2PonStatRxRegister));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PonStatFramesTxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatOctetsTxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatMulticastFramesTxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatBroadcastFramesTxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatFramesRxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatOctetsRxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatMulticastFramesRxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatBroadcastFramesRxOk));
		prepareRead(super.getProperty(utsDot3Onu2PonStatCrcError));
		prepareRead(super.getProperty(utsDot3Onu2PonStatCorrectFecBlocks));
		prepareRead(super.getProperty(utsDot3Onu2PonStatUncorrectFecBlocks));
		prepareRead(super.getProperty(utsDot3Onu2PonStatTxMpcpControl));
		prepareRead(super.getProperty(utsDot3Onu2PonStatRxMpcpControl));
		prepareRead(super.getProperty(utsDot3Onu2PonStatTxRegister));
		prepareRead(super.getProperty(utsDot3Onu2PonStatTxRegisterRequest));
		prepareRead(super.getProperty(utsDot3Onu2PonStatTxReport));
		prepareRead(super.getProperty(utsDot3Onu2PonStatRxGate));
		prepareRead(super.getProperty(utsDot3Onu2PonStatRxRegister));

		return loadAll(new int[] { 1, 1, 1, 1, 1 });
	}

}

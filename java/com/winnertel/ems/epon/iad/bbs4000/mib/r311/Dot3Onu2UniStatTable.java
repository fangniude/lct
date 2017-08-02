package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

/**
 * The Dot3Onu2UniStatTable class. Created by QuickDVM
 */
public class Dot3Onu2UniStatTable extends SnmpMibBean {
	public static final String utsDot3Onu2Ctc3UniModuleId = "utsDot3Onu2Ctc3UniModuleId";
	public static final String utsDot3Onu2Ctc3UniDeviceId = "utsDot3Onu2Ctc3UniDeviceId";
	public static final String utsDot3Onu2Ctc3UniPortId = "utsDot3Onu2Ctc3UniPortId";
	public static final String utsDot3Onu2Ctc3UniLogicalPortId = "utsDot3Onu2Ctc3UniLogicalPortId";
	public static final String utsDot3Onu2Ctc3UniPhyPortId = "utsDot3Onu2Ctc3UniPhyPortId";
	public static final String utsDot3Onu2UniStatInOctets = "utsDot3Onu2UniStatInOctets";
	public static final String utsDot3Onu2UniStatInUcastPkts = "utsDot3Onu2UniStatInUcastPkts";
	public static final String utsDot3Onu2UniStatInNucastPkts = "utsDot3Onu2UniStatInNucastPkts";
	public static final String utsDot3Onu2UniStatInDiscards = "utsDot3Onu2UniStatInDiscards";
	public static final String utsDot3Onu2UniStatInErrors = "utsDot3Onu2UniStatInErrors";
	public static final String utsDot3Onu2UniStatOutOctets = "utsDot3Onu2UniStatOutOctets";
	public static final String utsDot3Onu2UniStatOutUcastPkts = "utsDot3Onu2UniStatOutUcastPkts";
	public static final String utsDot3Onu2UniStatOutNucastPkts = "utsDot3Onu2UniStatOutNucastPkts";
	public static final String utsDot3Onu2UniStatOutDiscards = "utsDot3Onu2UniStatOutDiscards";
	public static final String utsDot3Onu2UniStatOutErrors = "utsDot3Onu2UniStatOutErrors";

	public Dot3Onu2UniStatTable(ISnmpProxy aSnmpProxy) {
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
		initProperty(utsDot3Onu2UniStatInOctets, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatInOctets,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.1",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatInUcastPkts, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatInUcastPkts,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.2",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatInNucastPkts, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatInNucastPkts,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.3",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatInDiscards, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatInDiscards,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.4",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatInErrors, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatInErrors,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.5",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatOutOctets, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatOutOctets,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.6",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatOutUcastPkts, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatOutUcastPkts,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.7",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatOutNucastPkts, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatOutNucastPkts,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.8",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatOutDiscards, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatOutDiscards,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.9",
				ISnmpConstant.COUNTER64));
		initProperty(utsDot3Onu2UniStatOutErrors, new SnmpMibBeanProperty(
				utsDot3Onu2UniStatOutErrors,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.59.1.10",
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
	
	public Integer getUtsDot3Onu2Ctc3UniPhyPortId() {
		return (Integer) getIndex(4);
	}

	public void setUtsDot3Onu2Ctc3UniPhyPortId(Integer aUtsDot3Onu2Ctc3UniPhyPortId) {
		setIndex(4, aUtsDot3Onu2Ctc3UniPhyPortId);
	}

	public BigInteger getUtsDot3Onu2UniStatInOctets() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatInOctets).getValue();
	}

	public void setUtsDot3Onu2UniStatInOctets(
			BigInteger aUtsDot3Onu2UniStatInOctets) {
		getProperty(utsDot3Onu2UniStatInOctets).setValue(
				aUtsDot3Onu2UniStatInOctets);
	}

	public BigInteger getUtsDot3Onu2UniStatInUcastPkts() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatInUcastPkts)
				.getValue();
	}

	public void setUtsDot3Onu2UniStatInUcastPkts(
			BigInteger aUtsDot3Onu2UniStatInUcastPkts) {
		getProperty(utsDot3Onu2UniStatInUcastPkts).setValue(
				aUtsDot3Onu2UniStatInUcastPkts);
	}

	public BigInteger getUtsDot3Onu2UniStatInNucastPkts() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatInNucastPkts)
				.getValue();
	}

	public void setUtsDot3Onu2UniStatInNucastPkts(
			BigInteger aUtsDot3Onu2UniStatInNucastPkts) {
		getProperty(utsDot3Onu2UniStatInNucastPkts).setValue(
				aUtsDot3Onu2UniStatInNucastPkts);
	}

	public BigInteger getUtsDot3Onu2UniStatInDiscards() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatInDiscards)
				.getValue();
	}

	public void setUtsDot3Onu2UniStatInDiscards(
			BigInteger aUtsDot3Onu2UniStatInDiscards) {
		getProperty(utsDot3Onu2UniStatInDiscards).setValue(
				aUtsDot3Onu2UniStatInDiscards);
	}

	public BigInteger getUtsDot3Onu2UniStatInErrors() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatInErrors).getValue();
	}

	public void setUtsDot3Onu2UniStatInErrors(
			BigInteger aUtsDot3Onu2UniStatInErrors) {
		getProperty(utsDot3Onu2UniStatInErrors).setValue(
				aUtsDot3Onu2UniStatInErrors);
	}

	public BigInteger getUtsDot3Onu2UniStatOutOctets() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatOutOctets).getValue();
	}

	public void setUtsDot3Onu2UniStatOutOctets(
			BigInteger aUtsDot3Onu2UniStatOutOctets) {
		getProperty(utsDot3Onu2UniStatOutOctets).setValue(
				aUtsDot3Onu2UniStatOutOctets);
	}

	public BigInteger getUtsDot3Onu2UniStatOutUcastPkts() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatOutUcastPkts)
				.getValue();
	}

	public void setUtsDot3Onu2UniStatOutUcastPkts(
			BigInteger aUtsDot3Onu2UniStatOutUcastPkts) {
		getProperty(utsDot3Onu2UniStatOutUcastPkts).setValue(
				aUtsDot3Onu2UniStatOutUcastPkts);
	}

	public BigInteger getUtsDot3Onu2UniStatOutNucastPkts() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatOutNucastPkts)
				.getValue();
	}

	public void setUtsDot3Onu2UniStatOutNucastPkts(
			BigInteger aUtsDot3Onu2UniStatOutNucastPkts) {
		getProperty(utsDot3Onu2UniStatOutNucastPkts).setValue(
				aUtsDot3Onu2UniStatOutNucastPkts);
	}

	public BigInteger getUtsDot3Onu2UniStatOutDiscards() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatOutDiscards)
				.getValue();
	}

	public void setUtsDot3Onu2UniStatOutDiscards(
			BigInteger aUtsDot3Onu2UniStatOutDiscards) {
		getProperty(utsDot3Onu2UniStatOutDiscards).setValue(
				aUtsDot3Onu2UniStatOutDiscards);
	}

	public BigInteger getUtsDot3Onu2UniStatOutErrors() {
		return (BigInteger) getProperty(utsDot3Onu2UniStatOutErrors).getValue();
	}

	public void setUtsDot3Onu2UniStatOutErrors(
			BigInteger aUtsDot3Onu2UniStatOutErrors) {
		getProperty(utsDot3Onu2UniStatOutErrors).setValue(
				aUtsDot3Onu2UniStatOutErrors);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2UniStatInOctets));
		prepareRead(super.getProperty(utsDot3Onu2UniStatInUcastPkts));
		prepareRead(super.getProperty(utsDot3Onu2UniStatInNucastPkts));
		prepareRead(super.getProperty(utsDot3Onu2UniStatInDiscards));
		prepareRead(super.getProperty(utsDot3Onu2UniStatInErrors));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutOctets));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutUcastPkts));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutNucastPkts));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutDiscards));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutErrors));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2UniStatInOctets));
		prepareRead(super.getProperty(utsDot3Onu2UniStatInUcastPkts));
		prepareRead(super.getProperty(utsDot3Onu2UniStatInNucastPkts));
		prepareRead(super.getProperty(utsDot3Onu2UniStatInDiscards));
		prepareRead(super.getProperty(utsDot3Onu2UniStatInErrors));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutOctets));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutUcastPkts));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutNucastPkts));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutDiscards));
		prepareRead(super.getProperty(utsDot3Onu2UniStatOutErrors));

		return loadAll(new int[] { 1, 1, 1, 1, 1 });
	}

}

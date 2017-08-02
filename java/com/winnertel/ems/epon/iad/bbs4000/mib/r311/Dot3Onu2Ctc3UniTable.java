package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2Ctc3UniTable class. Created by QuickDVM
 */
public class Dot3Onu2Ctc3UniTable extends SnmpMibBean {
	public static final String utsDot3Onu2Ctc3UniModuleId = "utsDot3Onu2Ctc3UniModuleId";
	public static final String utsDot3Onu2Ctc3UniDeviceId = "utsDot3Onu2Ctc3UniDeviceId";
	public static final String utsDot3Onu2Ctc3UniPortId = "utsDot3Onu2Ctc3UniPortId";
	public static final String utsDot3Onu2Ctc3UniLogicalPortId = "utsDot3Onu2Ctc3UniLogicalPortId";
	public static final String utsDot3Onu2Ctc3UniPhyPortId = "utsDot3Onu2Ctc3UniPhyPortId";
	public static final String utsDot3Onu2Ctc3MacLimit = "utsDot3Onu2Ctc3MacLimit";

	public Dot3Onu2Ctc3UniTable(ISnmpProxy aSnmpProxy) {
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
		initProperty(utsDot3Onu2Ctc3MacLimit, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3MacLimit,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.6",
				ISnmpConstant.GAUGE));

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

	public Long getUtsDot3Onu2Ctc3MacLimit() {
		return (Long) getProperty(utsDot3Onu2Ctc3MacLimit).getValue();
	}

	public void setUtsDot3Onu2Ctc3MacLimit(Long aUtsDot3Onu2Ctc3MacLimit) {
		getProperty(utsDot3Onu2Ctc3MacLimit).setValue(aUtsDot3Onu2Ctc3MacLimit);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2Ctc3MacLimit));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2Ctc3MacLimit));

		return loadAll(new int[] { 1, 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2Ctc3MacLimit));

		return save();
	}

}

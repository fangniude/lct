package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2PrivateOnuOamTable class. Created by QuickDVM
 */
public class Dot3Onu2PrivateOnuOamTable extends SnmpMibBean {
	public static final String utsDot3Onu2MacAgingTimeModuleId = "utsDot3Onu2MacAgingTimeModuleId";
	public static final String utsDot3Onu2MacAgingTimeDeviceId = "utsDot3Onu2MacAgingTimeDeviceId";
	public static final String utsDot3Onu2MacAgingTimePortId = "utsDot3Onu2MacAgingTimePortId";
	public static final String utsDot3Onu2MacAgingTimeLogicalPortId = "utsDot3Onu2MacAgingTimeLogicalPortId";
	public static final String utsDot3Onu2PrivateOnuOamRstp = "utsDot3Onu2PrivateOnuOamRstp";
	public static final String utsDot3Onu2PrivateOnuOamCos0 = "utsDot3Onu2PrivateOnuOamCos0";
	public static final String utsDot3Onu2PrivateOnuOamCos1 = "utsDot3Onu2PrivateOnuOamCos1";
	public static final String utsDot3Onu2PrivateOnuOamCos2 = "utsDot3Onu2PrivateOnuOamCos2";
	public static final String utsDot3Onu2PrivateOnuOamCos3 = "utsDot3Onu2PrivateOnuOamCos3";
	public static final String utsDot3Onu2PrivateOnuOamCos4 = "utsDot3Onu2PrivateOnuOamCos4";
	public static final String utsDot3Onu2PrivateOnuOamCos5 = "utsDot3Onu2PrivateOnuOamCos5";
	public static final String utsDot3Onu2PrivateOnuOamCos6 = "utsDot3Onu2PrivateOnuOamCos6";
	public static final String utsDot3Onu2PrivateOnuOamCos7 = "utsDot3Onu2PrivateOnuOamCos7";
	public static final String utsDot3Onu2PrivateOnuOamMirrorToPort = "utsDot3Onu2PrivateOnuOamMirrorToPort";
	public static final String utsDot3Onu2PrivateOnuOamMirroredPort1 = "utsDot3Onu2PrivateOnuOamMirroredPort1";
	public static final String utsDot3Onu2PrivateOnuOamMirroredPort1Mode = "utsDot3Onu2PrivateOnuOamMirroredPort1Mode";
	public static final String utsDot3Onu2PrivateOnuOamMirroredPort2 = "utsDot3Onu2PrivateOnuOamMirroredPort2";
	public static final String utsDot3Onu2PrivateOnuOamMirroredPort2Mode = "utsDot3Onu2PrivateOnuOamMirroredPort2Mode";
	public static final String utsDot3Onu2PrivateOnuOamMirroredPort3 = "utsDot3Onu2PrivateOnuOamMirroredPort3";
	public static final String utsDot3Onu2PrivateOnuOamMirroredPort3Mode = "utsDot3Onu2PrivateOnuOamMirroredPort3Mode";
	public static final String utsDot3Onu2PrivateOnuOamPortIsolate = "utsDot3Onu2PrivateOnuOamPortIsolate";

	public Dot3Onu2PrivateOnuOamTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2MacAgingTimeModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimeModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.55.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimeDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimeDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.55.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimePortId, new SnmpMibBeanProperty(
				utsDot3Onu2MacAgingTimePortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.55.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2MacAgingTimeLogicalPortId,
				new SnmpMibBeanProperty(utsDot3Onu2MacAgingTimeLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.55.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamRstp, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamRstp,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamCos0, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamCos0,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamCos1, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamCos1,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamCos2, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamCos2,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamCos3, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamCos3,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamCos4, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamCos4,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamCos5, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamCos5,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamCos6, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamCos6,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.8",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamCos7, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateOnuOamCos7,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamMirrorToPort,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateOnuOamMirrorToPort,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.10",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamMirroredPort1,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateOnuOamMirroredPort1,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.11",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamMirroredPort1Mode,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateOnuOamMirroredPort1Mode,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.12",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamMirroredPort2,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateOnuOamMirroredPort2,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.13",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamMirroredPort2Mode,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateOnuOamMirroredPort2Mode,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.14",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamMirroredPort3,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateOnuOamMirroredPort3,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.15",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamMirroredPort3Mode,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateOnuOamMirroredPort3Mode,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.16",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateOnuOamPortIsolate,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateOnuOamPortIsolate,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.101.1.17",
						ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2MacAgingTimeModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2MacAgingTimeModuleId(
			Integer aUtsDot3Onu2MacAgingTimeModuleId) {
		setIndex(0, aUtsDot3Onu2MacAgingTimeModuleId);
	}

	public Integer getUtsDot3Onu2MacAgingTimeDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2MacAgingTimeDeviceId(
			Integer aUtsDot3Onu2MacAgingTimeDeviceId) {
		setIndex(1, aUtsDot3Onu2MacAgingTimeDeviceId);
	}

	public Integer getUtsDot3Onu2MacAgingTimePortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2MacAgingTimePortId(
			Integer aUtsDot3Onu2MacAgingTimePortId) {
		setIndex(2, aUtsDot3Onu2MacAgingTimePortId);
	}

	public Integer getUtsDot3Onu2MacAgingTimeLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2MacAgingTimeLogicalPortId(
			Integer aUtsDot3Onu2MacAgingTimeLogicalPortId) {
		setIndex(3, aUtsDot3Onu2MacAgingTimeLogicalPortId);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamRstp() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamRstp).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamRstp(
			Integer aUtsDot3Onu2PrivateOnuOamRstp) {
		getProperty(utsDot3Onu2PrivateOnuOamRstp).setValue(
				aUtsDot3Onu2PrivateOnuOamRstp);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamCos0() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamCos0).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamCos0(
			Integer aUtsDot3Onu2PrivateOnuOamCos0) {
		getProperty(utsDot3Onu2PrivateOnuOamCos0).setValue(
				aUtsDot3Onu2PrivateOnuOamCos0);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamCos1() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamCos1).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamCos1(
			Integer aUtsDot3Onu2PrivateOnuOamCos1) {
		getProperty(utsDot3Onu2PrivateOnuOamCos1).setValue(
				aUtsDot3Onu2PrivateOnuOamCos1);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamCos2() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamCos2).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamCos2(
			Integer aUtsDot3Onu2PrivateOnuOamCos2) {
		getProperty(utsDot3Onu2PrivateOnuOamCos2).setValue(
				aUtsDot3Onu2PrivateOnuOamCos2);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamCos3() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamCos3).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamCos3(
			Integer aUtsDot3Onu2PrivateOnuOamCos3) {
		getProperty(utsDot3Onu2PrivateOnuOamCos3).setValue(
				aUtsDot3Onu2PrivateOnuOamCos3);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamCos4() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamCos4).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamCos4(
			Integer aUtsDot3Onu2PrivateOnuOamCos4) {
		getProperty(utsDot3Onu2PrivateOnuOamCos4).setValue(
				aUtsDot3Onu2PrivateOnuOamCos4);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamCos5() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamCos5).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamCos5(
			Integer aUtsDot3Onu2PrivateOnuOamCos5) {
		getProperty(utsDot3Onu2PrivateOnuOamCos5).setValue(
				aUtsDot3Onu2PrivateOnuOamCos5);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamCos6() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamCos6).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamCos6(
			Integer aUtsDot3Onu2PrivateOnuOamCos6) {
		getProperty(utsDot3Onu2PrivateOnuOamCos6).setValue(
				aUtsDot3Onu2PrivateOnuOamCos6);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamCos7() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamCos7).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamCos7(
			Integer aUtsDot3Onu2PrivateOnuOamCos7) {
		getProperty(utsDot3Onu2PrivateOnuOamCos7).setValue(
				aUtsDot3Onu2PrivateOnuOamCos7);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamMirrorToPort() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamMirrorToPort)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamMirrorToPort(
			Integer aUtsDot3Onu2PrivateOnuOamMirrorToPort) {
		getProperty(utsDot3Onu2PrivateOnuOamMirrorToPort).setValue(
				aUtsDot3Onu2PrivateOnuOamMirrorToPort);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamMirroredPort1() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamMirroredPort1(
			Integer aUtsDot3Onu2PrivateOnuOamMirroredPort1) {
		getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1).setValue(
				aUtsDot3Onu2PrivateOnuOamMirroredPort1);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamMirroredPort1Mode() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1Mode)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamMirroredPort1Mode(
			Integer aUtsDot3Onu2PrivateOnuOamMirroredPort1Mode) {
		getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1Mode).setValue(
				aUtsDot3Onu2PrivateOnuOamMirroredPort1Mode);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamMirroredPort2() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamMirroredPort2(
			Integer aUtsDot3Onu2PrivateOnuOamMirroredPort2) {
		getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2).setValue(
				aUtsDot3Onu2PrivateOnuOamMirroredPort2);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamMirroredPort2Mode() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2Mode)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamMirroredPort2Mode(
			Integer aUtsDot3Onu2PrivateOnuOamMirroredPort2Mode) {
		getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2Mode).setValue(
				aUtsDot3Onu2PrivateOnuOamMirroredPort2Mode);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamMirroredPort3() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamMirroredPort3(
			Integer aUtsDot3Onu2PrivateOnuOamMirroredPort3) {
		getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3).setValue(
				aUtsDot3Onu2PrivateOnuOamMirroredPort3);
	}

	public Integer getUtsDot3Onu2PrivateOnuOamMirroredPort3Mode() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3Mode)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamMirroredPort3Mode(
			Integer aUtsDot3Onu2PrivateOnuOamMirroredPort3Mode) {
		getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3Mode).setValue(
				aUtsDot3Onu2PrivateOnuOamMirroredPort3Mode);
	}
	
	public Integer getUtsDot3Onu2PrivateOnuOamPortIsolate() {
		return (Integer) getProperty(utsDot3Onu2PrivateOnuOamPortIsolate).getValue();
	}

	public void setUtsDot3Onu2PrivateOnuOamPortIsolate(
			Integer aUtsDot3Onu2PrivateOnuOamPortIsolate) {
		getProperty(utsDot3Onu2PrivateOnuOamPortIsolate).setValue(
				aUtsDot3Onu2PrivateOnuOamPortIsolate);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamRstp));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos0));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos1));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos2));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos3));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos4));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos5));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos6));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos7));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamMirrorToPort));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1Mode));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2Mode));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3Mode));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamPortIsolate));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamRstp));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos0));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos1));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos2));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos3));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos4));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos5));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos6));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamCos7));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamMirrorToPort));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1Mode));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2Mode));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3Mode));
		prepareRead(super.getProperty(utsDot3Onu2PrivateOnuOamPortIsolate));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamRstp));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamCos0));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamCos1));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamCos2));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamCos3));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamCos4));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamCos5));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamCos6));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamCos7));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamMirrorToPort));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamMirroredPort1Mode));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamMirroredPort2Mode));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamMirroredPort3Mode));
		prepareSave(getProperty(utsDot3Onu2PrivateOnuOamPortIsolate));

		return save();
	}

}

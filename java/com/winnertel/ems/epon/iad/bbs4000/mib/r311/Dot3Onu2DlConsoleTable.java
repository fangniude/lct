package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2DlConsoleTable class. Created by QuickDVM
 */
public class Dot3Onu2DlConsoleTable extends SnmpMibBean {
	public static final String utsDot3Onu2Ctc3UniModuleId = "utsDot3Onu2Ctc3UniModuleId";
	public static final String utsDot3Onu2Ctc3UniDeviceId = "utsDot3Onu2Ctc3UniDeviceId";
	public static final String utsDot3Onu2Ctc3UniPortId = "utsDot3Onu2Ctc3UniPortId";
	public static final String utsDot3Onu2Ctc3UniLogicalPortId = "utsDot3Onu2Ctc3UniLogicalPortId";
	public static final String utsDot3Onu2Ctc3UniPhyPortId = "utsDot3Onu2Ctc3UniPhyPortId";
	
	public static final String utsDot3Onu2DlConsoleState = "utsDot3Onu2DlConsoleState";
	public static final String utsDot3Onu2DlConsoleMode = "utsDot3Onu2DlConsoleMode";
	public static final String utsDot3Onu2DlConsoleBaudRate = "utsDot3Onu2DlConsoleBaudRate";
	public static final String utsDot3Onu2DlConsoleDataBits = "utsDot3Onu2DlConsoleDataBits";
	public static final String utsDot3Onu2DlConsoleParity = "utsDot3Onu2DlConsoleParity";
	public static final String utsDot3Onu2DlConsoleStopBits = "utsDot3Onu2DlConsoleStopBits";
	public static final String utsDot3Onu2DlConsoleFlowControl = "utsDot3Onu2DlConsoleFlowControl";
	public static final String utsDot3Onu2DlConsoleLocalIp = "utsDot3Onu2DlConsoleLocalIp";
	public static final String utsDot3Onu2DlConsoleLocalPort = "utsDot3Onu2DlConsoleLocalPort";
	public static final String utsDot3Onu2DlConsolePeerIp = "utsDot3Onu2DlConsolePeerIp";
	public static final String utsDot3Onu2DlConsolePeerPort = "utsDot3Onu2DlConsolePeerPort";

	public Dot3Onu2DlConsoleTable(ISnmpProxy aSnmpProxy) {
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
		initProperty(utsDot3Onu2DlConsoleState, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsoleState,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2DlConsoleMode, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsoleMode,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2DlConsoleBaudRate, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsoleBaudRate,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2DlConsoleDataBits, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsoleDataBits,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2DlConsoleParity, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsoleParity,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2DlConsoleStopBits, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsoleStopBits,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2DlConsoleFlowControl, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsoleFlowControl,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2DlConsoleLocalIp,
				new SnmpMibBeanProperty(utsDot3Onu2DlConsoleLocalIp,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.8",
						ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2DlConsoleLocalPort, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsoleLocalPort,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.9",
				ISnmpConstant.GAUGE));
		initProperty(utsDot3Onu2DlConsolePeerIp, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsolePeerIp,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.10",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2DlConsolePeerPort, new SnmpMibBeanProperty(
				utsDot3Onu2DlConsolePeerPort,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.57.1.11",
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

	public Integer getUtsDot3Onu2DlConsoleState() {
		return (Integer) getProperty(utsDot3Onu2DlConsoleState).getValue();
	}

	public void setUtsDot3Onu2DlConsoleState(Integer aUtsDot3Onu2DlConsoleState) {
		getProperty(utsDot3Onu2DlConsoleState).setValue(
				aUtsDot3Onu2DlConsoleState);
	}

	public Integer getUtsDot3Onu2DlConsoleMode() {
		return (Integer) getProperty(utsDot3Onu2DlConsoleMode).getValue();
	}

	public void setUtsDot3Onu2DlConsoleMode(Integer aUtsDot3Onu2DlConsoleMode) {
		getProperty(utsDot3Onu2DlConsoleMode).setValue(
				aUtsDot3Onu2DlConsoleMode);
	}

	public Integer getUtsDot3Onu2DlConsoleBaudRate() {
		return (Integer) getProperty(utsDot3Onu2DlConsoleBaudRate).getValue();
	}

	public void setUtsDot3Onu2DlConsoleBaudRate(
			Integer aUtsDot3Onu2DlConsoleBaudRate) {
		getProperty(utsDot3Onu2DlConsoleBaudRate).setValue(
				aUtsDot3Onu2DlConsoleBaudRate);
	}

	public Integer getUtsDot3Onu2DlConsoleDataBits() {
		return (Integer) getProperty(utsDot3Onu2DlConsoleDataBits).getValue();
	}

	public void setUtsDot3Onu2DlConsoleDataBits(
			Integer aUtsDot3Onu2DlConsoleDataBits) {
		getProperty(utsDot3Onu2DlConsoleDataBits).setValue(
				aUtsDot3Onu2DlConsoleDataBits);
	}

	public Integer getUtsDot3Onu2DlConsoleParity() {
		return (Integer) getProperty(utsDot3Onu2DlConsoleParity).getValue();
	}

	public void setUtsDot3Onu2DlConsoleParity(
			Integer aUtsDot3Onu2DlConsoleParity) {
		getProperty(utsDot3Onu2DlConsoleParity).setValue(
				aUtsDot3Onu2DlConsoleParity);
	}

	public Integer getUtsDot3Onu2DlConsoleStopBits() {
		return (Integer) getProperty(utsDot3Onu2DlConsoleStopBits).getValue();
	}

	public void setUtsDot3Onu2DlConsoleStopBits(
			Integer aUtsDot3Onu2DlConsoleStopBits) {
		getProperty(utsDot3Onu2DlConsoleStopBits).setValue(
				aUtsDot3Onu2DlConsoleStopBits);
	}

	public Integer getUtsDot3Onu2DlConsoleFlowControl() {
		return (Integer) getProperty(utsDot3Onu2DlConsoleFlowControl)
				.getValue();
	}

	public void setUtsDot3Onu2DlConsoleFlowControl(
			Integer aUtsDot3Onu2DlConsoleFlowControl) {
		getProperty(utsDot3Onu2DlConsoleFlowControl).setValue(
				aUtsDot3Onu2DlConsoleFlowControl);
	}

	public String getUtsDot3Onu2DlConsoleLocalIp() {
		return (String) getProperty(utsDot3Onu2DlConsoleLocalIp).getValue();
	}

	public void setUtsDot3Onu2DlConsoleLocalIp(
			String aUtsDot3Onu2DlConsoleLocalIp) {
		getProperty(utsDot3Onu2DlConsoleLocalIp).setValue(
				aUtsDot3Onu2DlConsoleLocalIp);
	}

	public Long getUtsDot3Onu2DlConsoleLocalPort() {
		return (Long) getProperty(utsDot3Onu2DlConsoleLocalPort).getValue();
	}

	public void setUtsDot3Onu2DlConsoleLocalPort(
			Long aUtsDot3Onu2DlConsoleLocalPort) {
		getProperty(utsDot3Onu2DlConsoleLocalPort).setValue(
				aUtsDot3Onu2DlConsoleLocalPort);
	}

	public String getUtsDot3Onu2DlConsolePeerIp() {
		return (String) getProperty(utsDot3Onu2DlConsolePeerIp).getValue();
	}

	public void setUtsDot3Onu2DlConsolePeerIp(String aUtsDot3Onu2DlConsolePeerIp) {
		getProperty(utsDot3Onu2DlConsolePeerIp).setValue(
				aUtsDot3Onu2DlConsolePeerIp);
	}

	public Long getUtsDot3Onu2DlConsolePeerPort() {
		return (Long) getProperty(utsDot3Onu2DlConsolePeerPort).getValue();
	}

	public void setUtsDot3Onu2DlConsolePeerPort(
			Long aUtsDot3Onu2DlConsolePeerPort) {
		getProperty(utsDot3Onu2DlConsolePeerPort).setValue(
				aUtsDot3Onu2DlConsolePeerPort);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleState));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleMode));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleBaudRate));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleDataBits));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleParity));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleStopBits));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleFlowControl));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleLocalIp));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleLocalPort));
		prepareRead(super.getProperty(utsDot3Onu2DlConsolePeerIp));
		prepareRead(super.getProperty(utsDot3Onu2DlConsolePeerPort));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleState));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleMode));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleBaudRate));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleDataBits));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleParity));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleStopBits));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleFlowControl));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleLocalIp));
		prepareRead(super.getProperty(utsDot3Onu2DlConsoleLocalPort));
		prepareRead(super.getProperty(utsDot3Onu2DlConsolePeerIp));
		prepareRead(super.getProperty(utsDot3Onu2DlConsolePeerPort));

		return loadAll(new int[] { 1, 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2DlConsoleState));
		prepareSave(getProperty(utsDot3Onu2DlConsoleMode));
		prepareSave(getProperty(utsDot3Onu2DlConsoleBaudRate));
		prepareSave(getProperty(utsDot3Onu2DlConsoleDataBits));
		prepareSave(getProperty(utsDot3Onu2DlConsoleParity));
		prepareSave(getProperty(utsDot3Onu2DlConsoleStopBits));
		prepareSave(getProperty(utsDot3Onu2DlConsoleFlowControl));
		prepareSave(getProperty(utsDot3Onu2DlConsoleLocalIp));
		prepareSave(getProperty(utsDot3Onu2DlConsoleLocalPort));
		prepareSave(getProperty(utsDot3Onu2DlConsolePeerIp));
		prepareSave(getProperty(utsDot3Onu2DlConsolePeerPort));

		return save();
	}

}

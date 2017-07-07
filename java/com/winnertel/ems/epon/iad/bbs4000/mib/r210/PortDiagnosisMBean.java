package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The PortDiagnosisMBean class. Created by QuickDVM
 */
public class PortDiagnosisMBean extends SnmpMibBean {
	
	final public static int START = 1;
	final public static int STOP = 2;
	
	public static final String utsDot3OltPortDiagnosisModuleId = "utsDot3OltPortDiagnosisModuleId";
	public static final String utsDot3OltPortDiagnosisDeviceId = "utsDot3OltPortDiagnosisDeviceId";
	public static final String utsDot3OltPortDiagnosisPortId = "utsDot3OltPortDiagnosisPortId";
	public static final String utsDot3OltPortDiagnosisAction = "utsDot3OltPortDiagnosisAction";
	public static final String utsDot3OltPortDiagnosisStatus = "utsDot3OltPortDiagnosisStatus";
	public static final String utsDot3OltPortDiagnosisResult = "utsDot3OltPortDiagnosisResult";

	public PortDiagnosisMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OltPortDiagnosisModuleId, new SnmpMibBeanProperty(
				utsDot3OltPortDiagnosisModuleId,
				".1.3.6.1.4.1.41355.1800.2.5.1.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortDiagnosisDeviceId, new SnmpMibBeanProperty(
				utsDot3OltPortDiagnosisDeviceId,
				".1.3.6.1.4.1.41355.1800.2.5.1.2.1.2", ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortDiagnosisPortId, new SnmpMibBeanProperty(
				utsDot3OltPortDiagnosisPortId,
				".1.3.6.1.4.1.41355.1800.2.5.1.2.1.3", ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortDiagnosisAction, new SnmpMibBeanProperty(
				utsDot3OltPortDiagnosisAction,
				".1.3.6.1.4.1.41355.1800.2.5.1.2.1.4", ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortDiagnosisStatus, new SnmpMibBeanProperty(
				utsDot3OltPortDiagnosisStatus,
				".1.3.6.1.4.1.41355.1800.2.5.1.2.1.5", ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortDiagnosisResult, new SnmpMibBeanProperty(
				utsDot3OltPortDiagnosisResult,
				".1.3.6.1.4.1.41355.1800.2.5.1.2.1.6", ISnmpConstant.STRING));

	}

	public Integer getUtsDot3OltPortDiagnosisModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OltPortDiagnosisModuleId(
			Integer aUtsDot3OltPortDiagnosisModuleId) {
		setIndex(0, aUtsDot3OltPortDiagnosisModuleId);
	}

	public Integer getUtsDot3OltPortDiagnosisDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OltPortDiagnosisDeviceId(
			Integer aUtsDot3OltPortDiagnosisDeviceId) {
		setIndex(1, aUtsDot3OltPortDiagnosisDeviceId);
	}

	public Integer getUtsDot3OltPortDiagnosisPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3OltPortDiagnosisPortId(
			Integer aUtsDot3OltPortDiagnosisPortId) {
		setIndex(2, aUtsDot3OltPortDiagnosisPortId);
	}

	public Integer getUtsDot3OltPortDiagnosisAction() {
		return (Integer) getProperty(utsDot3OltPortDiagnosisAction).getValue();
	}

	public void setUtsDot3OltPortDiagnosisAction(
			Integer aUtsDot3OltPortDiagnosisAction) {
		getProperty(utsDot3OltPortDiagnosisAction).setValue(
				aUtsDot3OltPortDiagnosisAction);
	}

	public Integer getUtsDot3OltPortDiagnosisStatus() {
		return (Integer) getProperty(utsDot3OltPortDiagnosisStatus).getValue();
	}

	public void setUtsDot3OltPortDiagnosisStatus(
			Integer aUtsDot3OltPortDiagnosisStatus) {
		getProperty(utsDot3OltPortDiagnosisStatus).setValue(
				aUtsDot3OltPortDiagnosisStatus);
	}

	public String getUtsDot3OltPortDiagnosisResult() {
		return (String) getProperty(utsDot3OltPortDiagnosisResult).getValue();
	}

	public void setUtsDot3OltPortDiagnosisResult(
			String aUtsDot3OltPortDiagnosisResult) {
		getProperty(utsDot3OltPortDiagnosisResult).setValue(
				aUtsDot3OltPortDiagnosisResult);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OltPortDiagnosisAction));
		prepareRead(super.getProperty(utsDot3OltPortDiagnosisStatus));
		prepareRead(super.getProperty(utsDot3OltPortDiagnosisResult));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OltPortDiagnosisAction));
		prepareRead(super.getProperty(utsDot3OltPortDiagnosisStatus));
		prepareRead(super.getProperty(utsDot3OltPortDiagnosisResult));

		return loadAll(new int[] { 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3OltPortDiagnosisAction));

		return save();
	}

}

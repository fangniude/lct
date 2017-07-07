package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Olt2PortDiagnosisTable extends SnmpMibBean {

	final public static int START = 1;
	final public static int STOP = 2;

	public static final String utsDot3OltPortDiagnosisModuleId = "utsDot3OltPortDiagnosisModuleId";
	public static final String utsDot3OltPortDiagnosisDeviceId = "utsDot3OltPortDiagnosisDeviceId";
	public static final String utsDot3OltPortDiagnosisPortId = "utsDot3OltPortDiagnosisPortId";
	public static final String utsDot3OltPortLaserAlwaysOnDetect = "utsDot3OltPortLaserAlwaysOnDetect";
	public static final String utsDot3OltPortLaserAlwaysOnDetectResult = "utsDot3OltPortLaserAlwaysOnDetectResult";
	public static final String utsDot3OltPortLaserAlwaysOnOnuLocating = "utsDot3OltPortLaserAlwaysOnOnuLocating";
	public static final String utsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus = "utsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus";
	public static final String utsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu = "utsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu";

	public Dot3Olt2PortDiagnosisTable(ISnmpProxy aSnmpProxy) {
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
		initProperty(utsDot3OltPortLaserAlwaysOnDetect,
				new SnmpMibBeanProperty(utsDot3OltPortLaserAlwaysOnDetect,
						".1.3.6.1.4.1.41355.1800.2.5.1.2.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortLaserAlwaysOnDetectResult,
				new SnmpMibBeanProperty(
						utsDot3OltPortLaserAlwaysOnDetectResult,
						".1.3.6.1.4.1.41355.1800.2.5.1.2.1.5",
						ISnmpConstant.STRING));
		initProperty(utsDot3OltPortLaserAlwaysOnOnuLocating,
				new SnmpMibBeanProperty(utsDot3OltPortLaserAlwaysOnOnuLocating,
						".1.3.6.1.4.1.41355.1800.2.5.1.2.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus,
				new SnmpMibBeanProperty(
						utsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus,
						".1.3.6.1.4.1.41355.1800.2.5.1.2.1.7",
						ISnmpConstant.STRING));
		initProperty(utsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu,
				new SnmpMibBeanProperty(
						utsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu,
						".1.3.6.1.4.1.41355.1800.2.5.1.2.1.8",
						ISnmpConstant.OCTETS));

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

	public Integer getUtsDot3OltPortLaserAlwaysOnDetect() {
		return (Integer) getProperty(utsDot3OltPortLaserAlwaysOnDetect)
				.getValue();
	}

	public void setUtsDot3OltPortLaserAlwaysOnDetect(
			Integer aUtsDot3OltPortLaserAlwaysOnDetect) {
		getProperty(utsDot3OltPortLaserAlwaysOnDetect).setValue(
				aUtsDot3OltPortLaserAlwaysOnDetect);
	}

	public String getUtsDot3OltPortLaserAlwaysOnDetectResult() {
		return (String) getProperty(utsDot3OltPortLaserAlwaysOnDetectResult)
				.getValue();
	}

	public void setUtsDot3OltPortLaserAlwaysOnDetectResult(
			String aUtsDot3OltPortLaserAlwaysOnDetectResult) {
		getProperty(utsDot3OltPortLaserAlwaysOnDetectResult).setValue(
				aUtsDot3OltPortLaserAlwaysOnDetectResult);
	}

	public Integer getUtsDot3OltPortLaserAlwaysOnOnuLocating() {
		return (Integer) getProperty(utsDot3OltPortLaserAlwaysOnOnuLocating)
				.getValue();
	}

	public void setUtsDot3OltPortLaserAlwaysOnOnuLocating(
			Integer aUtsDot3OltPortLaserAlwaysOnOnuLocating) {
		getProperty(utsDot3OltPortLaserAlwaysOnOnuLocating).setValue(
				aUtsDot3OltPortLaserAlwaysOnOnuLocating);
	}

	public String getUtsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus() {
		return (String) getProperty(
				utsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus).getValue();
	}

	public void setUtsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus(
			String aUtsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus) {
		getProperty(utsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus).setValue(
				aUtsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus);
	}

	public byte[] getUtsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu() {
		return (byte[]) getProperty(
				utsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu).getValue();
	}

	public void setUtsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu(
			byte[] aUtsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu) {
		getProperty(utsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu).setValue(
				aUtsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OltPortLaserAlwaysOnDetect));
		prepareRead(super.getProperty(utsDot3OltPortLaserAlwaysOnDetectResult));
		prepareRead(super.getProperty(utsDot3OltPortLaserAlwaysOnOnuLocating));
		prepareRead(super
				.getProperty(utsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus));
		prepareRead(super
				.getProperty(utsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OltPortLaserAlwaysOnDetect));
		prepareRead(super.getProperty(utsDot3OltPortLaserAlwaysOnDetectResult));
		prepareRead(super.getProperty(utsDot3OltPortLaserAlwaysOnOnuLocating));
		prepareRead(super
				.getProperty(utsDot3OltPortLaserAlwaysOnOnuLocationDiagStatus));
		prepareRead(super
				.getProperty(utsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu));

		return loadAll(new int[] { 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OltPortLaserAlwaysOnDetect));
		prepareRead(super.getProperty(utsDot3OltPortLaserAlwaysOnOnuLocating));

		return save();
	}

}

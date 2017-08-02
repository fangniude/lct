package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The EventLogTable class. Created by QuickDVM
 */
public class EventLogTable extends SnmpMibBean {
	public static final String utsBbsEventLogSequenceNumber = "utsBbsEventLogSequenceNumber";
	public static final String utsBbsEventLogEntityType = "utsBbsEventLogEntityType";
	public static final String utsBbsEventLogEntityInstance = "utsBbsEventLogEntityInstance";
	public static final String utsBbsEventLogOccurenceTime = "utsBbsEventLogOccurenceTime";
	public static final String utsBbsEventLogType = "utsBbsEventLogType";
	public static final String utsBbsEventLogInfo = "utsBbsEventLogInfo";
	public static final String utsBbsEventLogVersionId = "utsBbsEventLogVersionId";
	public static final String utsBbsEventLogSessionId = "utsBbsEventLogSessionId";

	public EventLogTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsBbsEventLogSequenceNumber, new SnmpMibBeanProperty(
				utsBbsEventLogSequenceNumber,
				".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.3.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsBbsEventLogEntityType, new SnmpMibBeanProperty(
				utsBbsEventLogEntityType,
				".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.3.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsBbsEventLogEntityInstance, new SnmpMibBeanProperty(
				utsBbsEventLogEntityInstance,
				".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.3.1.1.3",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsEventLogOccurenceTime, new SnmpMibBeanProperty(
				utsBbsEventLogOccurenceTime,
				".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.3.1.1.4",
				ISnmpConstant.OCTETS));
		initProperty(utsBbsEventLogType, new SnmpMibBeanProperty(
				utsBbsEventLogType,
				".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.3.1.1.5",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsEventLogInfo, new SnmpMibBeanProperty(
				utsBbsEventLogInfo,
				".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.3.1.1.6",
				ISnmpConstant.STRING));
		initProperty(utsBbsEventLogVersionId, new SnmpMibBeanProperty(
				utsBbsEventLogVersionId,
				".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.3.1.1.7",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsEventLogSessionId, new SnmpMibBeanProperty(
				utsBbsEventLogSessionId,
				".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.3.1.1.8",
				ISnmpConstant.COUNTER));

	}

	public Integer getUtsBbsEventLogSequenceNumber() {
		return (Integer) getIndex(0);
	}

	public void setUtsBbsEventLogSequenceNumber(
			Integer aUtsBbsEventLogSequenceNumber) {
		setIndex(0, aUtsBbsEventLogSequenceNumber);
	}

	public Integer getUtsBbsEventLogEntityType() {
		return (Integer) getProperty(utsBbsEventLogEntityType).getValue();
	}

	public void setUtsBbsEventLogEntityType(Integer aUtsBbsEventLogEntityType) {
		getProperty(utsBbsEventLogEntityType).setValue(
				aUtsBbsEventLogEntityType);
	}

	public Long getUtsBbsEventLogEntityInstance() {
		return (Long) getProperty(utsBbsEventLogEntityInstance).getValue();
	}

	public void setUtsBbsEventLogEntityInstance(
			Long aUtsBbsEventLogEntityInstance) {
		getProperty(utsBbsEventLogEntityInstance).setValue(
				aUtsBbsEventLogEntityInstance);
	}

	public byte[] getUtsBbsEventLogOccurenceTime() {
		return (byte[]) getProperty(utsBbsEventLogOccurenceTime).getValue();
	}

	public void setUtsBbsEventLogOccurenceTime(
			byte[] aUtsBbsEventLogOccurenceTime) {
		getProperty(utsBbsEventLogOccurenceTime).setValue(
				aUtsBbsEventLogOccurenceTime);
	}

	public Long getUtsBbsEventLogType() {
		return (Long) getProperty(utsBbsEventLogType).getValue();
	}

	public void setUtsBbsEventLogType(Long aUtsBbsEventLogType) {
		getProperty(utsBbsEventLogType).setValue(aUtsBbsEventLogType);
	}

	public String getUtsBbsEventLogInfo() {
		return (String) getProperty(utsBbsEventLogInfo).getValue();
	}

	public void setUtsBbsEventLogInfo(String aUtsBbsEventLogInfo) {
		getProperty(utsBbsEventLogInfo).setValue(aUtsBbsEventLogInfo);
	}

	public Long getUtsBbsEventLogVersionId() {
		return (Long) getProperty(utsBbsEventLogVersionId).getValue();
	}

	public void setUtsBbsEventLogVersionId(Long aUtsBbsEventLogVersionId) {
		getProperty(utsBbsEventLogVersionId).setValue(aUtsBbsEventLogVersionId);
	}

	public Long getUtsBbsEventLogSessionId() {
		return (Long) getProperty(utsBbsEventLogSessionId).getValue();
	}

	public void setUtsBbsEventLogSessionId(Long aUtsBbsEventLogSessionId) {
		getProperty(utsBbsEventLogSessionId).setValue(aUtsBbsEventLogSessionId);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsBbsEventLogEntityType));
		prepareRead(super.getProperty(utsBbsEventLogEntityInstance));
		prepareRead(super.getProperty(utsBbsEventLogOccurenceTime));
		prepareRead(super.getProperty(utsBbsEventLogType));
		prepareRead(super.getProperty(utsBbsEventLogInfo));
		prepareRead(super.getProperty(utsBbsEventLogVersionId));
		prepareRead(super.getProperty(utsBbsEventLogSessionId));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsBbsEventLogEntityType));
		prepareRead(super.getProperty(utsBbsEventLogEntityInstance));
		prepareRead(super.getProperty(utsBbsEventLogOccurenceTime));
		prepareRead(super.getProperty(utsBbsEventLogType));
		prepareRead(super.getProperty(utsBbsEventLogInfo));
		prepareRead(super.getProperty(utsBbsEventLogVersionId));
		prepareRead(super.getProperty(utsBbsEventLogSessionId));

		return loadAll(new int[] { 1 });
	}

}

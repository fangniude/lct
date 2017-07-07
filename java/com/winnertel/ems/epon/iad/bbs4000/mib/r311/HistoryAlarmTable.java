package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class HistoryAlarmTable extends SnmpMibBean {
	public static final String utsBbsAlarmHistorySequenceNumber = "utsBbsAlarmHistorySequenceNumber";
	public static final String utsBbsAlarmHistoryProbableCause = "utsBbsAlarmHistoryProbableCause";
	public static final String utsBbsAlarmHistorySpecificProblem = "utsBbsAlarmHistorySpecificProblem";
	public static final String utsBbsAlarmHistoryEntityType = "utsBbsAlarmHistoryEntityType";
	public static final String utsBbsAlarmHistoryEntityInstance = "utsBbsAlarmHistoryEntityInstance";
	public static final String utsBbsAlarmHistoryFirstOccurenceTime = "utsBbsAlarmHistoryFirstOccurenceTime";
	public static final String utsBbsAlarmHistoryClass = "utsBbsAlarmHistoryClass";
	public static final String utsBbsAlarmHistorySeverity = "utsBbsAlarmHistorySeverity";
	public static final String utsBbsAlarmHistoryCorrelationId = "utsBbsAlarmHistoryCorrelationId";
	public static final String utsBbsAlarmHistoryAdditionalText = "utsBbsAlarmHistoryAdditionalText";
	public static final String utsBbsAlarmHistoryRaisingNumber = "utsBbsAlarmHistoryRaisingNumber";
	public static final String utsBbsAlarmHistoryLastOccurenceTime = "utsBbsAlarmHistoryLastOccurenceTime";
	public static final String utsBbsAlarmHistoryRepeats = "utsBbsAlarmHistoryRepeats";
	public static final String utsBbsAlarmHistoryVersionId = "utsBbsAlarmHistoryVersionId";
	public static final String utsBbsAlarmHistorySessionId = "utsBbsAlarmHistorySessionId";
	public static final String utsBbsAlarmHistoryClearTime = "utsBbsAlarmHistoryClearTime";
	public static final String utsBbsAlarmHistoryClearFlag = "utsBbsAlarmHistoryClearFlag";

	public HistoryAlarmTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsBbsAlarmHistorySequenceNumber, new SnmpMibBeanProperty(
				utsBbsAlarmHistorySequenceNumber,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsBbsAlarmHistoryProbableCause, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryProbableCause,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.2",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsAlarmHistorySpecificProblem,
				new SnmpMibBeanProperty(utsBbsAlarmHistorySpecificProblem,
						".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.3",
						ISnmpConstant.COUNTER));
		initProperty(utsBbsAlarmHistoryEntityType, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryEntityType,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsBbsAlarmHistoryEntityInstance, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryEntityInstance,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.5",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsAlarmHistoryFirstOccurenceTime,
				new SnmpMibBeanProperty(utsBbsAlarmHistoryFirstOccurenceTime,
						".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.6",
						ISnmpConstant.OCTETS));
		initProperty(utsBbsAlarmHistoryClass, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryClass,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsBbsAlarmHistorySeverity, new SnmpMibBeanProperty(
				utsBbsAlarmHistorySeverity,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.8",
				ISnmpConstant.INTEGER));
		initProperty(utsBbsAlarmHistoryCorrelationId, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryCorrelationId,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.9",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsAlarmHistoryAdditionalText, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryAdditionalText,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.10",
				ISnmpConstant.STRING));
		initProperty(utsBbsAlarmHistoryRaisingNumber, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryRaisingNumber,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsBbsAlarmHistoryLastOccurenceTime,
				new SnmpMibBeanProperty(utsBbsAlarmHistoryLastOccurenceTime,
						".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.12",
						ISnmpConstant.OCTETS));
		initProperty(utsBbsAlarmHistoryRepeats, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryRepeats,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.13",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsAlarmHistoryVersionId, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryVersionId,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.14",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsAlarmHistorySessionId, new SnmpMibBeanProperty(
				utsBbsAlarmHistorySessionId,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.15",
				ISnmpConstant.COUNTER));
		initProperty(utsBbsAlarmHistoryClearTime, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryClearTime,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.16",
				ISnmpConstant.OCTETS));
		initProperty(utsBbsAlarmHistoryClearFlag, new SnmpMibBeanProperty(
				utsBbsAlarmHistoryClearFlag,
				".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.17",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsBbsAlarmHistorySequenceNumber() {
		return (Integer) getIndex(0);
	}

	public void setUtsBbsAlarmHistorySequenceNumber(
			Integer aUtsBbsAlarmHistorySequenceNumber) {
		setIndex(0, aUtsBbsAlarmHistorySequenceNumber);
	}

	public Integer getUtsBbsAlarmHistoryRaisingNumber() {
		return (Integer) getIndex(1);
	}

	public void setUtsBbsAlarmHistoryRaisingNumber(
			Integer aUtsBbsAlarmHistoryRaisingNumber) {
		setIndex(1, aUtsBbsAlarmHistoryRaisingNumber);
	}
	
	public Long getAlarmDescription() {
		return 65536 * getUtsBbsAlarmHistoryProbableCause() + getUtsBbsAlarmHistorySpecificProblem();
	}
	
	public void setAlarmDescription(Long aAlarmDescription) {
	}

	public Long getUtsBbsAlarmHistoryProbableCause() {
		return (Long) getProperty(utsBbsAlarmHistoryProbableCause)
				.getValue();
	}

	public void setUtsBbsAlarmHistoryProbableCause(
			Long aUtsBbsAlarmHistoryProbableCause) {
		getProperty(utsBbsAlarmHistoryProbableCause).setValue(
				aUtsBbsAlarmHistoryProbableCause);
	}

	public Long getUtsBbsAlarmHistorySpecificProblem() {
		return (Long) getProperty(utsBbsAlarmHistorySpecificProblem)
				.getValue();
	}

	public void setUtsBbsAlarmHistorySpecificProblem(
			Long aUtsBbsAlarmHistorySpecificProblem) {
		getProperty(utsBbsAlarmHistorySpecificProblem).setValue(
				aUtsBbsAlarmHistorySpecificProblem);
	}

	public Integer getUtsBbsAlarmHistoryEntityType() {
		return (Integer) getProperty(utsBbsAlarmHistoryEntityType).getValue();
	}

	public void setUtsBbsAlarmHistoryEntityType(
			Integer aUtsBbsAlarmHistoryEntityType) {
		getProperty(utsBbsAlarmHistoryEntityType).setValue(
				aUtsBbsAlarmHistoryEntityType);
	}

	public Long getUtsBbsAlarmHistoryEntityInstance() {
		return (Long) getProperty(utsBbsAlarmHistoryEntityInstance)
				.getValue();
	}

	public void setUtsBbsAlarmHistoryEntityInstance(
			Long aUtsBbsAlarmHistoryEntityInstance) {
		getProperty(utsBbsAlarmHistoryEntityInstance).setValue(
				aUtsBbsAlarmHistoryEntityInstance);
	}

	public byte[] getUtsBbsAlarmHistoryFirstOccurenceTime() {
		return (byte[]) getProperty(utsBbsAlarmHistoryFirstOccurenceTime)
				.getValue();
	}

	public void setUtsBbsAlarmHistoryFirstOccurenceTime(
			byte[] aUtsBbsAlarmHistoryFirstOccurenceTime) {
		getProperty(utsBbsAlarmHistoryFirstOccurenceTime).setValue(
				aUtsBbsAlarmHistoryFirstOccurenceTime);
	}

	public Integer getUtsBbsAlarmHistoryClass() {
		return (Integer) getProperty(utsBbsAlarmHistoryClass).getValue();
	}

	public void setUtsBbsAlarmHistoryClass(Integer aUtsBbsAlarmHistoryClass) {
		getProperty(utsBbsAlarmHistoryClass).setValue(aUtsBbsAlarmHistoryClass);
	}

	public Integer getUtsBbsAlarmHistorySeverity() {
		return (Integer) getProperty(utsBbsAlarmHistorySeverity).getValue();
	}

	public void setUtsBbsAlarmHistorySeverity(
			Integer aUtsBbsAlarmHistorySeverity) {
		getProperty(utsBbsAlarmHistorySeverity).setValue(
				aUtsBbsAlarmHistorySeverity);
	}

	public Long getUtsBbsAlarmHistoryCorrelationId() {
		return (Long) getProperty(utsBbsAlarmHistoryCorrelationId)
				.getValue();
	}

	public void setUtsBbsAlarmHistoryCorrelationId(
			Long aUtsBbsAlarmHistoryCorrelationId) {
		getProperty(utsBbsAlarmHistoryCorrelationId).setValue(
				aUtsBbsAlarmHistoryCorrelationId);
	}

	public String getUtsBbsAlarmHistoryAdditionalText() {
		return (String) getProperty(utsBbsAlarmHistoryAdditionalText)
				.getValue();
	}

	public void setUtsBbsAlarmHistoryAdditionalText(
			String aUtsBbsAlarmHistoryAdditionalText) {
		getProperty(utsBbsAlarmHistoryAdditionalText).setValue(
				aUtsBbsAlarmHistoryAdditionalText);
	}

	public byte[] getUtsBbsAlarmHistoryLastOccurenceTime() {
		return (byte[]) getProperty(utsBbsAlarmHistoryLastOccurenceTime)
				.getValue();
	}

	public void setUtsBbsAlarmHistoryLastOccurenceTime(
			byte[] aUtsBbsAlarmHistoryLastOccurenceTime) {
		getProperty(utsBbsAlarmHistoryLastOccurenceTime).setValue(
				aUtsBbsAlarmHistoryLastOccurenceTime);
	}

	public Long getUtsBbsAlarmHistoryRepeats() {
		return (Long) getProperty(utsBbsAlarmHistoryRepeats).getValue();
	}

	public void setUtsBbsAlarmHistoryRepeats(Long aUtsBbsAlarmHistoryRepeats) {
		getProperty(utsBbsAlarmHistoryRepeats).setValue(
				aUtsBbsAlarmHistoryRepeats);
	}

	public Long getUtsBbsAlarmHistoryVersionId() {
		return (Long) getProperty(utsBbsAlarmHistoryVersionId).getValue();
	}

	public void setUtsBbsAlarmHistoryVersionId(
			Long aUtsBbsAlarmHistoryVersionId) {
		getProperty(utsBbsAlarmHistoryVersionId).setValue(
				aUtsBbsAlarmHistoryVersionId);
	}

	public Long getUtsBbsAlarmHistorySessionId() {
		return (Long) getProperty(utsBbsAlarmHistorySessionId).getValue();
	}

	public void setUtsBbsAlarmHistorySessionId(
			Long aUtsBbsAlarmHistorySessionId) {
		getProperty(utsBbsAlarmHistorySessionId).setValue(
				aUtsBbsAlarmHistorySessionId);
	}

	public byte[] getUtsBbsAlarmHistoryClearTime() {
		return (byte[]) getProperty(utsBbsAlarmHistoryClearTime).getValue();
	}

	public void setUtsBbsAlarmHistoryClearTime(
			byte[] aUtsBbsAlarmHistoryClearTime) {
		getProperty(utsBbsAlarmHistoryClearTime).setValue(
				aUtsBbsAlarmHistoryClearTime);
	}

	public Integer getUtsBbsAlarmHistoryClearFlag() {
		return (Integer) getProperty(utsBbsAlarmHistoryClearFlag).getValue();
	}

	public void setUtsBbsAlarmHistoryClearFlag(
			Integer aUtsBbsAlarmHistoryClearFlag) {
		getProperty(utsBbsAlarmHistoryClearFlag).setValue(
				aUtsBbsAlarmHistoryClearFlag);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsBbsAlarmHistoryProbableCause));
		prepareRead(super.getProperty(utsBbsAlarmHistorySpecificProblem));
		prepareRead(super.getProperty(utsBbsAlarmHistoryEntityType));
		prepareRead(super.getProperty(utsBbsAlarmHistoryEntityInstance));
		prepareRead(super.getProperty(utsBbsAlarmHistoryFirstOccurenceTime));
		prepareRead(super.getProperty(utsBbsAlarmHistoryClass));
		prepareRead(super.getProperty(utsBbsAlarmHistorySeverity));
		prepareRead(super.getProperty(utsBbsAlarmHistoryCorrelationId));
		prepareRead(super.getProperty(utsBbsAlarmHistoryAdditionalText));
		prepareRead(super.getProperty(utsBbsAlarmHistoryLastOccurenceTime));
		prepareRead(super.getProperty(utsBbsAlarmHistoryRepeats));
		prepareRead(super.getProperty(utsBbsAlarmHistoryVersionId));
		prepareRead(super.getProperty(utsBbsAlarmHistorySessionId));
		prepareRead(super.getProperty(utsBbsAlarmHistoryClearTime));
		prepareRead(super.getProperty(utsBbsAlarmHistoryClearFlag));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsBbsAlarmHistoryProbableCause));
		prepareRead(super.getProperty(utsBbsAlarmHistorySpecificProblem));
		prepareRead(super.getProperty(utsBbsAlarmHistoryEntityType));
		prepareRead(super.getProperty(utsBbsAlarmHistoryEntityInstance));
		prepareRead(super.getProperty(utsBbsAlarmHistoryFirstOccurenceTime));
		prepareRead(super.getProperty(utsBbsAlarmHistoryClass));
		prepareRead(super.getProperty(utsBbsAlarmHistorySeverity));
		prepareRead(super.getProperty(utsBbsAlarmHistoryCorrelationId));
		prepareRead(super.getProperty(utsBbsAlarmHistoryAdditionalText));
		prepareRead(super.getProperty(utsBbsAlarmHistoryLastOccurenceTime));
		prepareRead(super.getProperty(utsBbsAlarmHistoryRepeats));
		prepareRead(super.getProperty(utsBbsAlarmHistoryVersionId));
		prepareRead(super.getProperty(utsBbsAlarmHistorySessionId));
		prepareRead(super.getProperty(utsBbsAlarmHistoryClearTime));
		prepareRead(super.getProperty(utsBbsAlarmHistoryClearFlag));

		return loadAll(new int[] { 1, 1 });
	}

}

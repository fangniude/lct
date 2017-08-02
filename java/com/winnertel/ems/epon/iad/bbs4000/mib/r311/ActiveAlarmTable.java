package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class ActiveAlarmTable extends SnmpMibBean {
	public static final String epActiveAlarmEntryID = "epActiveAlarmEntryID";
	public static final String epActiveAlarmObjectID = "epActiveAlarmObjectID";
	public static final String epActiveAlarmSourceMO = "epActiveAlarmSourceMO";
	public static final String epActiveAlarmSeqNo = "epActiveAlarmSeqNo";
	public static final String epActiveAlarmFirstDectetTime = "epActiveAlarmFirstDectetTime";
	public static final String epActiveAlarmLastReportTime = "epActiveAlarmLastReportTime";
	public static final String epActiveAlarmRepeatedNumbers = "epActiveAlarmRepeatedNumbers";
	public static final String epActiveAlarmSeverity = "epActiveAlarmSeverity";
	public static final String epActiveAlarmFirstTrapPDU = "epActiveAlarmFirstTrapPDU";
//	public static final String epActiveAlarmClearingFlag = "epActiveAlarmClearingFlag";

	public ActiveAlarmTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(epActiveAlarmEntryID, new SnmpMibBeanProperty(epActiveAlarmEntryID,
				".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.1", ISnmpConstant.INTEGER));
		initProperty(epActiveAlarmObjectID, new SnmpMibBeanProperty(epActiveAlarmObjectID,
				".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.2", ISnmpConstant.OBJID));
		initProperty(epActiveAlarmSourceMO, new SnmpMibBeanProperty(epActiveAlarmSourceMO,
				".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.3", ISnmpConstant.STRING));
		initProperty(epActiveAlarmSeqNo, new SnmpMibBeanProperty(
				epActiveAlarmSeqNo, ".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.4",
				ISnmpConstant.GAUGE));
		initProperty(epActiveAlarmFirstDectetTime, new SnmpMibBeanProperty(epActiveAlarmFirstDectetTime,
				".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.5", ISnmpConstant.OCTETS));
		initProperty(epActiveAlarmLastReportTime, new SnmpMibBeanProperty(
				epActiveAlarmLastReportTime, ".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.6",
				ISnmpConstant.OCTETS));
		initProperty(epActiveAlarmRepeatedNumbers, new SnmpMibBeanProperty(epActiveAlarmRepeatedNumbers,
				".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.7", ISnmpConstant.COUNTER));
		initProperty(epActiveAlarmSeverity, new SnmpMibBeanProperty(
				epActiveAlarmSeverity, ".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.8",
				ISnmpConstant.INTEGER));
		initProperty(epActiveAlarmFirstTrapPDU, new SnmpMibBeanProperty(
				epActiveAlarmFirstTrapPDU, ".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.9",
				ISnmpConstant.OCTETS));
//		initProperty(epActiveAlarmClearingFlag, new SnmpMibBeanProperty(epActiveAlarmClearingFlag,
//				".1.3.6.1.4.1.45121.1800.3.1.1.4.4.1.10", ISnmpConstant.INTEGER));

	}

	public Integer getEpActiveAlarmEntryID() {
		return (Integer) getIndex(0);
	}

	public void setEpActiveAlarmEntryID(Integer aEpActiveAlarmEntryID) {
		setIndex(0, aEpActiveAlarmEntryID);
	}

	public String getEpActiveAlarmObjectID() {
//		String temp = String.valueOf(getProperty(epActiveAlarmObjectID).getValue());
//        return translateNeType(temp);
		return String.valueOf(getProperty(epActiveAlarmObjectID).getValue());
	}

	public void setEpActiveAlarmObjectID(String aEpActiveAlarmObjectID) {
		getProperty(epActiveAlarmObjectID).setValue(aEpActiveAlarmObjectID);
	}
	
	public String getEpActiveAlarmSourceMO() {
		return ((String) getProperty(epActiveAlarmSourceMO).getValue()).trim();
	}

	public void setEpActiveAlarmSourceMO(
			String aEpActiveAlarmSourceMO) {
		getProperty(epActiveAlarmSourceMO).setValue(
				aEpActiveAlarmSourceMO);
	}
	
	public Long getEpActiveAlarmSeqNo() {
		return (Long) getProperty(epActiveAlarmSeqNo).getValue();
	}

	public void setEpActiveAlarmSeqNo(Long aEpActiveAlarmSeqNo) {
		getProperty(epActiveAlarmSeqNo).setValue(aEpActiveAlarmSeqNo);
	}
	
	public byte[] getEpActiveAlarmFirstDectetTime() {
		return (byte[]) getProperty(epActiveAlarmFirstDectetTime).getValue();
	}

	public void setEpActiveAlarmFirstDectetTime(byte[] aEpActiveAlarmFirstDectetTime) {
		getProperty(epActiveAlarmFirstDectetTime).setValue(aEpActiveAlarmFirstDectetTime);
	}
	
	public byte[] getEpActiveAlarmLastReportTime() {
		return (byte[]) getProperty(epActiveAlarmLastReportTime).getValue();
	}

	public void setEpActiveAlarmLastReportTime(byte[] aEpActiveAlarmLastReportTime) {
		getProperty(epActiveAlarmLastReportTime).setValue(aEpActiveAlarmLastReportTime);
	}
	
	public Long getEpActiveAlarmRepeatedNumbers() {
		return (Long) getProperty(epActiveAlarmRepeatedNumbers).getValue();
	}

	public void setEpActiveAlarmRepeatedNumbers(
			Long aEpActiveAlarmRepeatedNumbers) {
		getProperty(epActiveAlarmRepeatedNumbers).setValue(
				aEpActiveAlarmRepeatedNumbers);
	}
	
	public Integer getEpActiveAlarmSeverity() {
		return (Integer) getProperty(epActiveAlarmSeverity).getValue();
	}

	public void setEpActiveAlarmSeverity(Integer aEpActiveAlarmSeverity) {
		getProperty(epActiveAlarmSeverity).setValue(aEpActiveAlarmSeverity);
	}
	
	public byte[] getEpActiveAlarmFirstTrapPDU() {
		return (byte[]) getProperty(epActiveAlarmFirstTrapPDU).getValue();
	}

	public void setEpActiveAlarmFirstTrapPDU(byte[] aEpActiveAlarmFirstTrapPDU) {
		getProperty(epActiveAlarmFirstTrapPDU).setValue(aEpActiveAlarmFirstTrapPDU);
	}
	
//	public Integer getEpActiveAlarmClearingFlag() {
//		return (Integer) getProperty(epActiveAlarmClearingFlag).getValue();
//	}
//
//	public void setEpActiveAlarmClearingFlag(Integer aEpActiveAlarmClearingFlag) {
//		getProperty(epActiveAlarmClearingFlag).setValue(aEpActiveAlarmClearingFlag);
//	}
	
	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(epActiveAlarmObjectID));
		prepareRead(super.getProperty(epActiveAlarmSourceMO));
		prepareRead(super.getProperty(epActiveAlarmSeqNo));
		prepareRead(super.getProperty(epActiveAlarmFirstDectetTime));
		prepareRead(super.getProperty(epActiveAlarmLastReportTime));
		prepareRead(super.getProperty(epActiveAlarmRepeatedNumbers));
		prepareRead(super.getProperty(epActiveAlarmSeverity));
		prepareRead(super.getProperty(epActiveAlarmFirstTrapPDU));
//		prepareRead(super.getProperty(epActiveAlarmClearingFlag));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(epActiveAlarmObjectID));
		prepareRead(super.getProperty(epActiveAlarmSourceMO));
		prepareRead(super.getProperty(epActiveAlarmSeqNo));
		prepareRead(super.getProperty(epActiveAlarmFirstDectetTime));
		prepareRead(super.getProperty(epActiveAlarmLastReportTime));
		prepareRead(super.getProperty(epActiveAlarmRepeatedNumbers));
		prepareRead(super.getProperty(epActiveAlarmSeverity));
		prepareRead(super.getProperty(epActiveAlarmFirstTrapPDU));
//		prepareRead(super.getProperty(epActiveAlarmClearingFlag));

		return loadAll(new int[] {1});
	}
	
//	private static String translateNeType(String oid) {
//        if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.1"))
//            return "BBS1000";
//        else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.2"))
//            return "FBW3000";
//        else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.3"))
//            return "FBW5000";
//        else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.4"))
//            return "BBS2000";
//        else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.5"))
//            return "BBS5000";
//        else
//            return oid;
//    }

//	public boolean modify() throws MibBeanException {
//		prepareSave(getProperty(utsBbsAlarmActiveAcknowledge));
//		prepareSave(getProperty(utsBbsAlarmActiveClearManually));
//
//		return save();
//	}
//
//	public boolean ack() throws MibBeanException {
//		prepareSave(getProperty(utsBbsAlarmActiveAcknowledge));
//
//		return save();
//	}
//
//	public boolean clear() throws MibBeanException {
//		prepareSave(getProperty(utsBbsAlarmActiveClearManually));
//
//		return save();
//	}

}

/**
 * Created by Zhou Chao, 2009/7/20
 */

package com.winnertel.ems.epon.fm.trap.bbs.parse;

import com.winnertel.ems.epon.fm.trap.bbs.EponTrapUtil;
import com.winnertel.ems.epon.fm.trap.util.AlarmUtil;
import com.winnertel.ems.epon.global.ServerResourceManager;
import com.winnertel.em.broadband.common.alarm.ParseEntity;
import com.winnertel.em.broadband.common.alarm.util.BBFMUtil;
import com.winnertel.em.broadband.common.version.VersionMap;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.nms.topodb.ULManagedObject;
import com.winnertel.snmp.snmp2.SnmpOID;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.snmp.snmp2.SnmpVar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class BbsTrapParser implements BbsTrapConstant {
    public static final int EntityType_Interface = 3000;
    public static final int EntityType_Node = 3001;
    public static final int Equipment = 3;
    public static final int Undefined = 7;
    public static final int AlarmType_Unknown = 0;
    public static final int AlarmType_LinkDown = 1;
    public static final int AlarmType_UpsStatusGetFailed = 2;
    public static final int AlarmType_BatteryPowerLow = 3;
    public static final int AlarmType_UpsDevFailed = 4;
    public static final int EventType_Unknown = 0;
    public static final int EventType_UpsChangeToUtility = 1;
    public static final int EventType_UpsChangeToBattery = 2;
    public static final int EventType_UpsUseBattery = 3;
    public static final int EventType_UpsBatteryPowerLower = 4;
    public static final int EventType_UpsBatteryChargeEnable = 5;
    public static final int EventType_UpsBatteryChargeDisable = 6;
    public static final int EventType_coldStart = 7;
    public static final int EventType_warmStart = 8;
    public static final String CLT2168 = "CLT2168";
    public static final String CLT2168_online = EponTrapParserHelper.getDescriptionByKey("CLT2168_online");
    public static final String CLT2168_offline = EponTrapParserHelper.getDescriptionByKey("CLT2168_offline");
    public static final String CLT2168_intact = EponTrapParserHelper.getDescriptionByKey("CLT2168_intact");
    public static final String CLT2168_compromised = EponTrapParserHelper.getDescriptionByKey("CLT2168_compromised");
    public static final String CLT2168_value = EponTrapParserHelper.getDescriptionByKey("CLT2168_value");
//    private static final EponLogger LOG = LoggerUtility.getLogger(BbsTrapParser.class.getName());

    // [start]
    public BbsTrapParser() {
        System.out.println("init BbsTrapParser");
    }

    public void init() {
    }

    /**
     * Deprecated by Li Pengpeng, instead by EponAlarmBean.parse. 2011/12/22
     *
     * @param pdu
     * @return
     * @throws Exception
     */
    @Deprecated
    // modified by Zhou Chao, 2010/5/13
    public ParseEntity decodeAlarm(SnmpPDU pdu) throws Exception {
        if (pdu == null)
            return null;

        int vbs = pdu.getVariableBindings().size();
        if (vbs < 13)
            throw new Exception("Expect 13 VBs but " + vbs + " sent by NE");

        System.out.println("<decodeAlarm> ***************** PDU *****************");

        try {
            int sessionId = 0;
            int seqNo = 0;
            long timeStamp = 0;
            int alarmClass = 0;
            int entityType = 0;
            int entityInstance = 0;
            int severity = 0;
            int problemCause = 0;
            int specificProblem = 0;
            long versionId = 0;
            long correlationId = 0;
            String sourceIp = "";
            String addInfo = "";
            String deviceType = "";

            for (int i = 0; i < vbs; i++) {
                SnmpOID oid = pdu.getObjectID(i);
                SnmpVar value = pdu.getVariable(i);

                String str = oid.toString();
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.length() - 2);
                }

                if (str.equals(utsBbsAlarmSessionId)) {
                    sessionId = Integer.parseInt(value.toString());
                }

                if (str.equals(utsBbsAlarmSequenceNumber)) {
                    seqNo = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(utsBbsAlarmTime)) {
                    timeStamp = AlarmUtil.getDateAndTimeFromSnmpVar(value);
                }

                if (str.equals(utsBbsAlarmClass)) {
                    alarmClass = Integer.parseInt(value.toString());
                }

                if (str.equals(utsBbsAlarmEntityType)) {
                    entityType = Integer.parseInt(value.toString());
                }

                if (str.equals(utsBbsAlarmEntityInstance)) {
                    entityInstance = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(utsBbsAlarmSeverity)) {
                    severity = Integer.parseInt(value.toString());
                    if (severity < com.winnertel.ems.fm.common.ConstantVar.CRITICAL || severity > com.winnertel.ems.fm.common.ConstantVar.CLEAR) {
                        throw new Exception("severity of the alarm is not correct: " + severity);
                    }
                }

                if (str.equals(utsBbsAlarmProbableCause)) {
                    problemCause = Integer.parseInt(value.toString());
                }

                if (str.equals(utsBbsAlarmSpecificProblem)) {
                    specificProblem = Integer.parseInt(value.toString());
                }

                if (str.equals(utsBbsAlarmVersionId)) {
                    versionId = Long.parseLong(value.toValue().toString());
                }

                if (str.equals(utsBbsAlarmCorrelationId)) {
                    correlationId = Long.parseLong(value.toValue().toString());
                    if (correlationId == 0) {
                        correlationId = -1;
                    }
                }

                if (str.equals(utsBbsAlarmSourceIp)) {
                    sourceIp = value.toString();
                    // if(sourceIp != null) {
                    // rtEntity.setSenderIP(sourceIp); //set node address
                    // }
                }

                if (str.equals(utsBbsAlarmAdditionalText)) {
                    addInfo = value.toString().trim();

                    String moName = UTopoAPI.getAPI().getNodeNameByIP(pdu.getRemoteAddress());
                    ULManagedObject moInstance = UTopoAPI.getAPI().getByName(moName);
                    Properties prop = moInstance.getProperties();
                    String nodeVersion = prop.getProperty("version");

                    if (addInfo.length() > 0)
                        addInfo += ", Session ID = " + sessionId + ", Version = " + nodeVersion;
                    else
                        addInfo += "Session ID = " + sessionId + ", Version = " + nodeVersion;
                }

                if (str.equals(utsBbsAlarmDeviceType)) {
                    deviceType = value.toString();
                }
            }

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(pdu.getRemoteHost());
            if (deviceType != null && deviceType.length() > 0)
                rtEntity.setMoType(deviceType);
            rtEntity.setSenderIP(pdu.getRemoteAddress()); // set node address
            rtEntity.setTrapOID(utsBbsAlarmTrap);

            rtEntity.setSeqNO(seqNo);
            rtEntity.setSessionID(sessionId);
            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(alarmClass)); // set
            // alarm
            // class
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(entityType)); // set
            // entity
            // Type
            rtEntity.setETCode(Integer.toString(entityType)); // set entity Type

            String instance = EponTrapParserHelper.getEntityInstanceByNodeVersion(entityType, entityInstance, rtEntity.getNodeVersion(), rtEntity.getMoType());
            if (instance.equalsIgnoreCase("N/A"))
                rtEntity.setEntityInstance(rtEntity.getMoType() + "-" + rtEntity.getSenderIP());
            else
                rtEntity.setEntityInstance(instance);

            // TODO
            if (rtEntity.getMoName() != null) {
                String source = rtEntity.getMoName();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getMoName());
            } else {
                String source = rtEntity.getSenderIP();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getSenderIP());
            }

            rtEntity.setSeverity(severity);
            if (correlationId >= 1) { // clear alarm
                rtEntity.setSeverity(com.winnertel.ems.fm.common.ConstantVar.CLEAR);
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), correlationId);
                // String key = getKey(trapEntity.getSenderIP(), correlationId);
                rtEntity.setEntity(key);
            } else {// raise alarm
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), seqNo);
                // String key = getKey(trapEntity.getSenderIP(), seqNo);
                rtEntity.setEntity(key);
            }

            // String key = EponTrapParserHelper.getKey(rtEntity.getMoName(),
            // seqNo);
            // rtEntity.setEntity(key);

            rtEntity.setCreateTime(timeStamp);

            rtEntity.setProCause(EponTrapParserHelper.getProbableCause(problemCause)); // set
            // probable
            // cause
            rtEntity.setPCode(Integer.toString(problemCause)); // set probable
            // cause

            rtEntity.setSepCause(EponTrapParserHelper.getSpecificProblem(specificProblem)); // set
            // probable
            // cause
            rtEntity.setSPCode(Integer.toString(specificProblem)); // set
            // probable
            // cause

            rtEntity.setMessage(EponTrapParserHelper.getUTMessage(rtEntity, addInfo));
            rtEntity.setAdditionalInfo(addInfo);

            int alarmID = ((problemCause & 0x0000ffff) << 16) + (specificProblem & 0x0000ffff);
            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + alarmID);
            rtEntity.setAlarmID(String.valueOf(alarmID));

            rtEntity.setEntity(rtEntity.getEntity() + "_" + rtEntity.getSessionID());

            System.out.println("<decodeAlarm> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeAlarm> ***************** [Exception] com.winnertel.em.broadband.common.alarm.ParseEntity object is NULL *****************");
            e.printStackTrace();
        }

        return null;
    }

    // modified by Zhou Chao, 2010/5/13
    public ParseEntity decodeEponAlarm(String remoteAddress, int sequenceNumber, Object[] data) throws Exception {
        /*
         * { //utsBbsAlarmActiveTable
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.2", //0:
         * utsBbsAlarmActiveProbableCause
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.3", //1:
         * utsBbsAlarmActiveSpecificProblem
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.4", //2:
         * utsBbsAlarmActiveEntityType
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.5", //3:
         * utsBbsAlarmActiveEntityInstance
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.6", //4:
         * utsBbsAlarmActiveFirstOccurenceTime
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.7", //5:
         * utsBbsAlarmActiveClass
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.8", //6:
         * utsBbsAlarmActiveSeverity
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.9", //7:
         * utsBbsAlarmActiveAcknowledge
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.10", //8:
         * utsBbsAlarmActiveAdditionalText
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.12", //9:
         * utsBbsAlarmActiveLastOccurenceTime
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.13", //10:
         * utsBbsAlarmActiveRepeats
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.14", //11:
         * utsBbsAlarmActiveVersionId
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.15", //12:
         * utsBbsAlarmActiveSessionId
         * };
         */

        if (sequenceNumber <= 0 || data == null || data.length <= 0)
            return null;

        if (data.length < 13)
            throw new Exception("Expect 13 VBs but " + data.length + " sent by NE");

        System.out.println("<decodeEponAlarm> ***************** Data *****************");

        try {
            int sessionId = Integer.parseInt(data[12].toString());
            long timeStamp = 0;
            int alarmClass = Integer.parseInt(data[5].toString());
            int entityType = Integer.parseInt(data[2].toString());
            int entityInstance = Integer.parseInt(data[3].toString());
            int severity = Integer.parseInt(data[6].toString());
            int problemCause = Integer.parseInt(data[0].toString());
            int specificProblem = Integer.parseInt(data[1].toString());
            // long versionId = Long.parseLong(data[11].toString());
            long correlationId = -1;
            // String sourceIp = "";
            String addInfo = data[8].toString().trim();
            String deviceType = data.length > 13 ? data[13].toString().trim() : "";

            Date date = AlarmUtil.bytes2Date(data[4].toString().getBytes("iso-8859-1"));
            timeStamp = (date == null) ? (new Date()).getTime() : date.getTime();

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(remoteAddress);
            if (deviceType != null && deviceType.length() > 0)
                rtEntity.setMoType(deviceType);
            rtEntity.setSenderIP(remoteAddress); // set node address
            rtEntity.setTrapOID(utsBbsAlarmTrap);

            rtEntity.setSeqNO(sequenceNumber);
            rtEntity.setSessionID(sessionId);
            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(alarmClass)); // set
            // alarm
            // class
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(entityType)); // set
            // entity
            // Type
            rtEntity.setETCode(Integer.toString(entityType)); // set entity Type

            String instance = EponTrapParserHelper.getEntityInstanceByNodeVersion(entityType, entityInstance, rtEntity.getNodeVersion(), rtEntity.getMoType());
            if (instance.equalsIgnoreCase("N/A"))
                rtEntity.setEntityInstance(rtEntity.getMoType() + "-" + rtEntity.getSenderIP());
            else
                rtEntity.setEntityInstance(instance);

            // TODO
            if (rtEntity.getMoName() != null) {
                String source = rtEntity.getMoName();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getMoName());
            } else {
                String source = rtEntity.getSenderIP();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getSenderIP());
            }

            rtEntity.setSeverity(severity);
            if (correlationId >= 1) { // clear alarm
                rtEntity.setSeverity(com.winnertel.ems.fm.common.ConstantVar.CLEAR);
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), correlationId);
                // String key = getKey(trapEntity.getSenderIP(), correlationId);
                rtEntity.setEntity(key);
            } else {
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), sequenceNumber);
                // String key = getKey(trapEntity.getSenderIP(), seqNo);
                rtEntity.setEntity(key);
            }
            // String key = EponTrapParserHelper.getKey(rtEntity.getMoName(),
            // seqNo);
            // rtEntity.setEntity(key);

            rtEntity.setCreateTime(timeStamp);

            rtEntity.setProCause(EponTrapParserHelper.getProbableCause(problemCause)); // set
            // probable
            // cause
            rtEntity.setPCode(Integer.toString(problemCause)); // set probable
            // cause

            rtEntity.setSepCause(EponTrapParserHelper.getSpecificProblem(specificProblem)); // set
            // probable
            // cause
            rtEntity.setSPCode(Integer.toString(specificProblem)); // set
            // probable
            // cause

            rtEntity.setMessage(EponTrapParserHelper.getUTMessage(rtEntity, addInfo));
            rtEntity.setAdditionalInfo(addInfo);

            int alarmID = ((problemCause & 0x0000ffff) << 16) + (specificProblem & 0x0000ffff);
            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + alarmID);
            rtEntity.setAlarmID(String.valueOf(alarmID));

            rtEntity.setEntity(rtEntity.getEntity() + "_" + rtEntity.getSessionID());

            System.out.println("<decodeEponAlarm> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeEponAlarm> ***************** [Exception] com.winnertel.em.broadband.common.alarm.ParseEntity object is NULL *****************");
            e.printStackTrace();
        }

        return null;
    }

    // modified by Zhou Chao, 2010/5/13
    public ParseEntity decodeEponPartAlarm(String remoteAddress, int sequenceNumber, Object[] data) throws Exception {
        /*
         * { //utsBbsAlarmTrapLogTable
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.2", //0:
         * utsBbsAlarmTrapLogProbableCause
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.3", //1:
         * utsBbsAlarmTrapLogSpecificProblem
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.4", //2:
         * utsBbsAlarmTrapLogEntityType
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.5", //3:
         * utsBbsAlarmTrapLogEntityInstance
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.6", //4:
         * utsBbsAlarmTrapLogOccurenceTime
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.7", //5:
         * utsBbsAlarmTrapLogClass
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.8", //6:
         * utsBbsAlarmTrapLogSeverity
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.9", //7:
         * utsBbsAlarmTrapLogCorrelationId
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.10", //8:
         * utsBbsAlarmTrapLogAdditionalText
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.14", //9:
         * utsBbsAlarmTrapLogVersionId
         * ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.15", //10:
         * utsBbsAlarmTrapLogSessionId
         * };
         */

        if (sequenceNumber <= 0 || data == null || data.length <= 0)
            return null;

        if (data.length < 11)
            throw new Exception("Expect 11 VBs but " + data.length + " sent by NE");

        System.out.println("<decodeEponPartAlarm> ***************** Data *****************");

        try {
            int sessionId = Integer.parseInt(data[10].toString());
            long timeStamp = 0;
            int alarmClass = Integer.parseInt(data[5].toString());
            int entityType = Integer.parseInt(data[2].toString());
            int entityInstance = Integer.parseInt(data[3].toString());
            int severity = Integer.parseInt(data[6].toString());
            int problemCause = Integer.parseInt(data[0].toString());
            int specificProblem = Integer.parseInt(data[1].toString());
            // long versionId = Long.parseLong(data[9].toString());
            long correlationId = Long.parseLong(data[7].toString());
            String addInfo = data[8].toString().trim();
            String deviceType = data.length > 13 ? data[13].toString().trim() : "";

            Date date = AlarmUtil.bytes2Date(data[4].toString().getBytes("iso-8859-1"));
            timeStamp = (date == null) ? (new Date()).getTime() : date.getTime();

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(remoteAddress);
            if (deviceType != null && deviceType.length() > 0)
                rtEntity.setMoType(deviceType);
            rtEntity.setSenderIP(remoteAddress); // set node address
            rtEntity.setTrapOID(utsBbsAlarmTrap);

            rtEntity.setSeqNO(sequenceNumber);
            rtEntity.setSessionID(sessionId);
            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(alarmClass)); // set
            // alarm
            // class
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(entityType)); // set
            // entity
            // Type
            rtEntity.setETCode(Integer.toString(entityType)); // set entity Type

            String instance = EponTrapParserHelper.getEntityInstanceByNodeVersion(entityType, entityInstance, rtEntity.getNodeVersion(), rtEntity.getMoType());
            if (instance.equalsIgnoreCase("N/A"))
                rtEntity.setEntityInstance(rtEntity.getMoType() + "-" + rtEntity.getSenderIP());
            else
                rtEntity.setEntityInstance(instance);

            // TODO
            if (rtEntity.getMoName() != null) {
                String source = rtEntity.getMoName();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getMoName());
            } else {
                String source = rtEntity.getSenderIP();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getSenderIP());
            }

            rtEntity.setSeverity(severity);
            if (correlationId >= 1) { // clear alarm
                rtEntity.setSeverity(com.winnertel.ems.fm.common.ConstantVar.CLEAR);
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), correlationId);
                // String key = getKey(trapEntity.getSenderIP(), correlationId);
                rtEntity.setEntity(key);
            } else {
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), sequenceNumber);
                // String key = getKey(trapEntity.getSenderIP(), seqNo);
                rtEntity.setEntity(key);
            }
            // String key = EponTrapParserHelper.getKey(rtEntity.getMoName(),
            // seqNo);
            // rtEntity.setEntity(key);

            rtEntity.setCreateTime(timeStamp);

            rtEntity.setProCause(EponTrapParserHelper.getProbableCause(problemCause)); // set
            // probable
            // cause
            rtEntity.setPCode(Integer.toString(problemCause)); // set probable
            // cause

            rtEntity.setSepCause(EponTrapParserHelper.getSpecificProblem(specificProblem)); // set
            // probable
            // cause
            rtEntity.setSPCode(Integer.toString(specificProblem)); // set
            // probable
            // cause

            rtEntity.setMessage(EponTrapParserHelper.getUTMessage(rtEntity, addInfo));
            rtEntity.setAdditionalInfo(addInfo);

            int alarmID = ((problemCause & 0x0000ffff) << 16) + (specificProblem & 0x0000ffff);
            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + alarmID);
            rtEntity.setAlarmID(String.valueOf(alarmID));

            rtEntity.setEntity(rtEntity.getEntity() + "_" + rtEntity.getSessionID());

            System.out.println("<decodeEponPartAlarm> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeEponPartAlarm> ***************** [Exception] com.winnertel.em.broadband.common.alarm.ParseEntity object is NULL *****************");
            e.printStackTrace();
        }

        return null;
    }

    public ParseEntity decodeONU402IK2Alarm(SnmpPDU pdu) throws Exception {
        if (pdu == null)
            return null;
        int vbs = pdu.getVariableBindings().size();
        if (vbs < 7)
            throw new Exception("Expect 7 VBs but " + vbs + " sent by NE");

        System.out.println("<decodeONU402IK2Alarm> ***************** PDU *****************");
        /**
         * Objects:
         * 1: eponTrapSequenceNumber 1.3.6.1.4.1.17409.2.2.1.2.7
         * 2: eponTrapOccurTime 1.3.6.1.4.1.17409.2.2.1.2.6
         * 3: eponTrapCode 1.3.6.1.4.1.17409.2.2.1.2.4
         * 4: eponTrapInstance 1.3.6.1.4.1.17409.2.2.1.2.1
         * 5: eponTrapSeverity 1.3.6.1.4.1.17409.2.2.1.2.5
         * 6: eponTrapCorrelationId 1.3.6.1.4.1.17409.2.2.1.2.2
         * 7: eponTrapAdditionalText 1.3.6.1.4.1.17409.2.2.1.2.3
         **/

        int sessionID = 0;
        int sequenceNumber = 0;
        long trapOccurTime = 0;
        int alarmClass = 0;
        int entityType = 0;
        int entityInstance = 0;
        int severity = 0;
        int pcCode = 0;
        int spCode = 0;
        int trapCode = 0;
        String versionID = "";
        int correlationID = 0;
        String sourceIP = "";
        String additionalText = "";

        for (int i = 0; i < vbs; i++) {
            SnmpOID oid = pdu.getObjectID(i);
            SnmpVar value = pdu.getVariable(i);

            String str = oid.toString();
            try {
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.length() - 2);
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.1.2.7")) { // eponTrapSequenceNumber
                    sequenceNumber = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.1.2.6")) { // eponTrapOccurTime
                    trapOccurTime = AlarmUtil.getDateAndTimeFromSnmpVar(value);
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.1.2.1")) { // eponTrapInstance
                    entityInstance = value.toValue().toString().getBytes()[5];
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.1.2.5")) { // eponTrapSeverity
                    severity = Integer.parseInt(value.toValue().toString());
                    if (severity < com.winnertel.ems.fm.common.ConstantVar.CRITICAL || severity > com.winnertel.ems.fm.common.ConstantVar.CLEAR) {
                        throw new Exception("severity of the alarm is not correct: " + severity);
                    }
                    continue;
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.1.2.4")) { // eponTrapCode
                    trapCode = Integer.parseInt(value.toValue().toString());
                    pcCode = trapCode;
                    spCode = trapCode;
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.1.2.2")) { // eponTrapCorrelationId
                    correlationID = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.1.2.3")) { // utsGponAlarmAdditionalText
                    additionalText = value.toValue().toString().trim();
                    String moName = UTopoAPI.getAPI().getNodeNameByIP(pdu.getRemoteAddress());
                    ULManagedObject moInstance = UTopoAPI.getAPI().getByName(moName);
                    Properties prop = moInstance.getProperties();
                    String nodeVersion = prop.getProperty("version");
                    if (additionalText.length() > 0)
                        additionalText += ", Version = " + nodeVersion;
                    else
                        additionalText += "Version = " + nodeVersion;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(pdu.getRemoteAddress());
            rtEntity.setSenderIP(pdu.getRemoteAddress()); // set node address
            rtEntity.setTrapOID(".1.3.6.1.4.1.17409.2.2.1.1"); // utsGponAlarmTrap
            rtEntity.setSessionID(sessionID);
            rtEntity.setSeqNO(sequenceNumber);
            rtEntity.setCreateTime(trapOccurTime);
            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(alarmClass)); // set
            // alarm
            // class
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(entityType)); // set
            // entity
            // Type
            rtEntity.setETCode(Integer.toString(entityType)); // set entity type
            String instance = "PON-" + entityInstance;
            rtEntity.setEntityInstance(instance);

            // TODO
            if (rtEntity.getMoName() != null) {
                String source = rtEntity.getMoName();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getMoName());
            } else {
                String source = rtEntity.getSenderIP();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getSenderIP());
            }

            if (severity == com.winnertel.ems.fm.common.ConstantVar.CLEAR) {
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), correlationID);
                // String key = getKey(trapEntity.getSenderIP(), correlationId);
                rtEntity.setEntity(key);
            } else {
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), sequenceNumber);
                // String key = getKey(trapEntity.getSenderIP(), seqNo);
                rtEntity.setEntity(key);
            }

            rtEntity.setSeverity(severity);
            if (correlationID >= 1) { // clear alarm
                rtEntity.setSeverity(com.winnertel.ems.fm.common.ConstantVar.CLEAR);
            }

            rtEntity.setProCause(EponTrapParserHelper.getBbs4000R4EponAlarmCode(pcCode)); // set
            // probable
            // cause
            rtEntity.setPCode(Integer.toString(pcCode)); // set probable cause

            rtEntity.setSepCause(EponTrapParserHelper.getBbs4000R4EponAlarmCode(spCode)); // set
            // probable
            // cause
            rtEntity.setSPCode(Integer.toString(spCode)); // set probable cause

            rtEntity.setMessage(EponTrapParserHelper.getUTMessage(rtEntity, additionalText));
            rtEntity.setAdditionalInfo(additionalText);

            int alarmID = ((pcCode & 0x0000ffff) << 16) + (spCode & 0x0000ffff);
            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + alarmID);
            rtEntity.setAlarmID(String.valueOf(alarmID));

            System.out.println("<decodeONU402IK2Alarm> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeONU402IK2Alarm> ***************** [Exception] com.winnertel.em.broadband.common.alarm.ParseEntity object is NULL *****************");
            e.printStackTrace();
        }

        return null;
    }


    private static String getFormatedCNUMACAddress(String str) {
        if (str == null || str.length() != 16)
            return null;

        str = str.substring(4);// skip "0406"
        char[] c = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < c.length; i++) {
            stringBuilder.append(c[i]);
            if (i % 2 != 0 && i < c.length - 1)
                stringBuilder.append(":");
        }
        return stringBuilder.toString();
    }

    private static String getAlarmMessage(String code) {
        String eponAlarmCodeKey = "EoC_AlarmMessage_" + code;
        String eponAlarmCodeStr = ServerResourceManager.getString(eponAlarmCodeKey);

        return eponAlarmCodeStr != null ? eponAlarmCodeStr : "";
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString().toUpperCase();
    }

    private static String getSpecificCode2Oid(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }

        boolean isBigDigital = false;
        List<String> digitalList = null;
        for (int i = 1; i < src.length; i++) {// src[0] is length
            if ("128".equals(String.valueOf(src[i] & 0x80)) && !isBigDigital) {
                digitalList = new ArrayList<String>();
                digitalList.add(Integer.toBinaryString(src[i] & 0x7f));
                isBigDigital = true;
            } else if ("128".equals(String.valueOf(src[i] & 0x80)) && isBigDigital) {
                String str = Integer.toBinaryString(src[i] & 0x7f);
                digitalList.add(upTo7bits(str));
            } else if ("0".equals(String.valueOf(src[i] & 0x80)) && isBigDigital) {
                String str = Integer.toBinaryString(src[i]);
                digitalList.add(upTo7bits(str));

                stringBuilder.append(".").append(getIntFromBinary(digitalList));
                isBigDigital = false;
            } else {
                stringBuilder.append(".").append(src[i]);
            }
        }

        return stringBuilder.toString();
    }

    private static int getIntFromBinary(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (String str : list)
            stringBuilder.append(str);

        return Integer.parseInt(stringBuilder.toString(), 2);
    }

    private static String upTo7bits(String str) {
        if (str == null || str.length() <= 0)
            return null;
        if (str.length() == 7)
            return str;

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 7 - str.length(); i++) {
            stringBuilder.append("0");
        }

        return stringBuilder.append(str).toString();
    }



    /**
     * Deprecated by Li Pengpeng, instead by EponEventBean.parse. 2011/12/22
     *
     * @param pdu
     * @return
     * @throws Exception
     */
    @Deprecated
    // modified by Zhou Chao, 2010/5/13
    public ParseEntity decodeEvent(SnmpPDU pdu) throws Exception {
        if (pdu == null)
            return null;

        int vbs = pdu.getVariableBindings().size();
        if (vbs < 9)
            throw new Exception("Expect 9 VBs but " + vbs + " sent by NE");

        System.out.println("<decodeEvent> ***************** PDU *****************");

        try {
            int sessionId = 0;
            int seqNo = -1;
            long timeStamp = 0;
            int entityType = 0;
            int entityInstance = 0;
            int eventType = 0;
            String addInfo = "";
            String sourceIp = "";
            long versionId = 0;
            String deviceType = "";

            for (int i = 0; i < vbs; i++) {
                SnmpOID oid = pdu.getObjectID(i);
                SnmpVar value = pdu.getVariable(i);

                String str = oid.toString();
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.length() - 2);
                }

                if (str.equals(utsBbsAlarmSessionId)) {
                    sessionId = Integer.parseInt(value.toString());
                }

                // if (str.equals(utsBbsAlarmSequenceNumber)) {
                // seqNo = Integer.parseInt(value.toValue().toString());
                // }

                if (str.equals(utsBbsAlarmTime)) {
                    timeStamp = AlarmUtil.getDateAndTimeFromSnmpVar(value);
                }

                if (str.equals(utsBbsAlarmEntityType)) {
                    entityType = Integer.parseInt(value.toString());
                }

                if (oid.toString().equals(utsBbsAlarmEntityInstance)) {
                    entityInstance = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(utsBbsEventType)) {
                    eventType = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(utsBbsAlarmAdditionalText)) {
                    addInfo = value.toString().trim();

                    String moName = UTopoAPI.getAPI().getNodeNameByIP(pdu.getRemoteAddress());
                    ULManagedObject moInstance = UTopoAPI.getAPI().getByName(moName);
                    Properties prop = moInstance.getProperties();
                    String nodeVersion = prop.getProperty("version");

                    if (addInfo.length() > 0)
                        addInfo += ", Session ID = " + sessionId + ", Version = " + nodeVersion;
                    else
                        addInfo += "Session ID = " + sessionId + ", Version = " + nodeVersion;
                }

                if (str.equals(utsBbsAlarmSourceIp)) {
                    sourceIp = value.toString();
                    // if(sourceIp != null) {
                    // rtEntity.setSenderIP(sourceIp); //set node address
                    // }
                }

                if (str.equals(utsBbsAlarmVersionId)) {
                    versionId = Long.parseLong(value.toValue().toString());
                }

                if (str.equals(utsBbsAlarmDeviceType)) {
                    deviceType = value.toString();
                }
            }

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(pdu.getRemoteHost());
            if (deviceType != null && deviceType.length() > 0)
                rtEntity.setMoType(deviceType);
            rtEntity.setSenderIP(pdu.getRemoteAddress()); // set node address
            rtEntity.setTrapOID(utsBbsEventTrap);

            rtEntity.setCreateTime(timeStamp);

            rtEntity.setSeqNO(seqNo);
            rtEntity.setSessionID(sessionId);
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(entityType)); // set
            // entity
            // Type
            // rtEntity.setETCode(Integer.toString(entityType)); //set entity
            // Type
            rtEntity.setEventType(EponTrapParserHelper.getEventType(eventType)); // set
            // event
            // type
            rtEntity.setCategory("");
            rtEntity.setProCause("");
            rtEntity.setSepCause("");

            if (rtEntity.getMoName() != null)
                rtEntity.setSource(rtEntity.getMoName());
            else
                rtEntity.setSource(rtEntity.getSenderIP());

            // rtEntity.setAlarmID(EponTrapUtil.getAlarmID(rtEntity.getSenderIP()));
            rtEntity.setAlarmID(rtEntity.getSenderIP() + "-" + sessionId + "-" + entityType + "-" + eventType);

            rtEntity.setSeverity(6);

            String nodeVersion = BBFMUtil.getNodeVersion(rtEntity.getMoName());
            String disVersion = VersionMap.getDisplayVersion(rtEntity.getMoType(), nodeVersion);

            final String instance = EponTrapParserHelper.getEntityInstanceByNodeVersion(entityType, entityInstance, disVersion, rtEntity.getMoType());
            if (instance.equalsIgnoreCase("N/A"))
                rtEntity.setEntityInstance(rtEntity.getMoType() + "-" + rtEntity.getSenderIP());
            else
                rtEntity.setEntityInstance(instance);

            rtEntity.setMessage(addInfo);
            rtEntity.setAdditionalInfo(addInfo);

            rtEntity.setEntity(rtEntity.getEntity() + "_" + rtEntity.getSessionID());

            /*
             * //moves following code to EponEventListener.java
             * 
             * 
             * if( eventType == 21 || eventType == 22 || eventType == 23 ) {
             * final int type = eventType;
             * final String additional = addInfo;
             * final String oltIP = rtEntity.getSenderIP();
             * 
             * BroadbandCommonProcessBE.getInstance().
             * getStandardConfiguredPoolExecutorService("OnuAuth").execute(new
             * Runnable() {
             * 
             * @Override
             * public void run() {
             * OnuAuthNotification notification = new OnuAuthNotification();
             * notification.setType(type);
             * notification.setOltIP(oltIP);
             * notification.setLogicalPort(instance);
             * 
             * if( OnuAuthNotification.parse( notification, additional ) ) {
             * UNotificationEvent event = new
             * UNotificationEvent(UNotificationTypeDef.USERDEF, notification);
             * UNotificationServer nsAPI = (UNotificationServer)
             * EmsBEServerUtil.getAPI(UNotificationServer.API_NAME);
             * try {
             * nsAPI.addNotification(event);
             * } catch (RemoteException e) {
             * e.printStackTrace();
             * }
             * }
             * 
             * }
             * 
             * });
             * 
             * }
             */

            System.out.println("<decodeEvent> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeEvent> ***************** [Exception] com.winnertel.em.broadband.common.alarm.ParseEntity object is NULL *****************");
            e.printStackTrace();
        }

        return null;
    }

    public ParseEntity decodeCLT2168Event(SnmpPDU pdu) throws Exception {
        if (pdu == null)
            return null;

        int vbs = pdu.getVariableBindings().size();
        if (vbs < 5)
            throw new Exception("Expect 5 VBs but " + vbs + " sent by NE");

        System.out.println("<decodeCLT2168Event> ***************** PDU *****************");

        /*
         * 1: eventSeqNum (1.3.6.1.4.1.17409.2.2.11.2.3.1.1)
         * 2: eventCode (1.3.6.1.4.1.17409.2.2.11.2.3.1.2)
         * 3: eventInstance (1.3.6.1.4.1.17409.2.2.11.2.3.1.3)
         * 4: eventOccurTime (1.3.6.1.4.1.17409.2.2.11.2.3.1.4)
         * 5: eventAdditionalText (1.3.6.1.4.1.17409.2.2.11.2.3.1.5)
         */

        try {
            int trapSequenceNumber = 0;
            long trapOccurTime = 0;
            int trapCode = 0;
            byte[] trapInstance = null;
            String trapAdditionalText = "";

            for (int i = 0; i < vbs; i++) {
                SnmpOID oid = pdu.getObjectID(i);
                SnmpVar value = pdu.getVariable(i);

                String str = oid.toString();
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.length() - 2);
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.2.3.1.1")) { // eventSeqNum
                    trapSequenceNumber = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.2.3.1.4")) { // eventOccurTime
                    trapOccurTime = AlarmUtil.getDateAndTimeFromSnmpVar(value);
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.2.3.1.2")) { // eventCode
                    trapCode = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.2.3.1.3")) { // eventInstance
                    trapInstance = value.toValue().toString().getBytes();
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.2.3.1.5")) { // eventAdditionalText
                    trapAdditionalText = "";
                    // Do nothing because it is an empty value which is defined
                    // in SRS.
                }
            }

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(pdu.getRemoteAddress());
            rtEntity.setSenderIP(pdu.getRemoteAddress());
            rtEntity.setTrapOID(".1.3.6.1.4.1.17409.2.2.11.2.3.1");

            rtEntity.setSeqNO(trapSequenceNumber);

            rtEntity.setAlarmID(String.valueOf(trapCode));

            String eponAlarmInstance = EponTrapParserHelper.getBbs4000R4EponAlarmInstanceString(trapInstance);
            if (eponAlarmInstance.equalsIgnoreCase("N/A"))
                rtEntity.setEntityInstance(rtEntity.getMoType() + "-" + rtEntity.getSenderIP());
            else
                rtEntity.setEntityInstance(eponAlarmInstance);

            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(1)); // set
            // alarm
            // class
            // as
            // 'communication'

            String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), trapSequenceNumber);
            rtEntity.setEntity(key);

            rtEntity.setCreateTime(trapOccurTime);

            rtEntity.setSeverity(6);

            rtEntity.setAdditionalInfo("");

            trapAdditionalText = (eponAlarmInstance != null && !eponAlarmInstance.equalsIgnoreCase("N/A") && !"".equals(eponAlarmInstance)) ? "Slot " + eponAlarmInstance : "";
            rtEntity.setMessage(EponTrapParserHelper.getBbs4000R4EponEventMessage(trapCode, trapAdditionalText));

            rtEntity.setSource(rtEntity.getMoName());

            System.out.println("<decodeCLT2168Event> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeCLT2168Event> ***************** [Exception]: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    // addes by Zhou Chao, 2010/5/13
    public ParseEntity decodeBbs4000R4Event(SnmpPDU pdu) throws Exception {
        if (pdu == null)
            return null;

        int vbs = pdu.getVariableBindings().size();
        if (vbs < 5)
            throw new Exception("Expect 5 VBs but " + vbs + " sent by NE");

        System.out.println("<decodeBbs4000R4Event> ***************** PDU *****************");

        /*
         * eponEventNotification (1.3.6.1.4.1.17409.2.2.11.1.1.2):
         * 1: eponTrapSequenceNumber (1.3.6.1.4.1.17409.2.2.11.1.2.7)
         * 2: eponTrapOccurTime (1.3.6.1.4.1.17409.2.2.11.1.2.6)
         * 3: eponTrapCode (1.3.6.1.4.1.17409.2.2.11.1.2.4)
         * 4: eponTrapInstance (1.3.6.1.4.1.17409.2.2.11.1.2.1)
         * 5: eponTrapAdditionalText (1.3.6.1.4.1.17409.2.2.11.1.2.3)
         */

        try {
            int trapSequenceNumber = 0;
            long trapOccurTime = 0;
            int trapCode = 0;
            byte[] trapInstance = null;
            String trapAdditionalText = "";

            for (int i = 0; i < vbs; i++) {
                SnmpOID oid = pdu.getObjectID(i);
                SnmpVar value = pdu.getVariable(i);

                String str = oid.toString();
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.length() - 2);
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.1.2.7")) { // eponTrapSequenceNumber
                    trapSequenceNumber = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.1.2.6")) { // eponTrapOccurTime
                    trapOccurTime = AlarmUtil.getDateAndTimeFromSnmpVar(value);
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.1.2.4")) { // eponTrapCode
                    trapCode = Integer.parseInt(value.toValue().toString());
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.1.2.1")) { // eponTrapInstance
                    trapInstance = value.toValue().toString().getBytes();
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.11.1.2.3")) { // eponTrapAdditionalText
                    trapAdditionalText = value.toString().trim();

                    String moName = UTopoAPI.getAPI().getNodeNameByIP(pdu.getRemoteAddress());
                    ULManagedObject moInstance = UTopoAPI.getAPI().getByName(moName);
                    Properties prop = moInstance.getProperties();
                    String nodeVersion = prop.getProperty("version");

                    if (trapAdditionalText.length() > 0)
                        trapAdditionalText += ", Version = " + nodeVersion;
                    else
                        trapAdditionalText += "Version = " + nodeVersion;
                }
            }

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(pdu.getRemoteAddress());
            rtEntity.setSenderIP(pdu.getRemoteAddress()); // set node address
            rtEntity.setTrapOID(".1.3.6.1.4.1.17409.2.2.11.1.1.2"); // eponEventNotification

            rtEntity.setSeqNO(trapSequenceNumber);

            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + trapCode);
            rtEntity.setAlarmID(String.valueOf(trapCode));

            String eponAlarmInstance = EponTrapParserHelper.getBbs4000R4EponAlarmInstanceString(trapInstance);
            if (eponAlarmInstance.equalsIgnoreCase("N/A"))
                rtEntity.setEntityInstance(rtEntity.getMoType() + "-" + rtEntity.getSenderIP());
            else
                rtEntity.setEntityInstance(eponAlarmInstance);

            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(1)); // set
            // alarm
            // class
            // as
            // 'communication'

            String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), trapSequenceNumber);
            rtEntity.setEntity(key);

            rtEntity.setCreateTime(trapOccurTime);

            rtEntity.setSeverity(6);

            rtEntity.setAdditionalInfo(trapAdditionalText);

            rtEntity.setMessage(EponTrapParserHelper.getBbs4000R4EponEventMessage(trapCode, trapAdditionalText));

            rtEntity.setSource(rtEntity.getMoName());

            System.out.println("<decodeBbs4000R4Event> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeBbs4000R4Event> ***************** [Exception]: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    // addes by Zhou Chao, 2010/7/26
    public ParseEntity decodeEocEvent(SnmpPDU pdu) throws Exception {
        if (pdu == null)
            return null;

        int vbs = pdu.getVariableBindings().size();
        if (vbs < 3)
            throw new Exception("Expect 3 VBs but " + vbs + " sent by NE");

        System.out.println("<decodeEocEvent> ***************** PDU *****************");

        /*
         * modEoCAlarmEvent:
         * 1: alarmLogInformation (1.3.6.1.4.1.17409.2.2.3.1.2)
         * 2: modEoCCBATCardMACAddress (1.3.6.1.4.1.17409.2.4.3.2.1.2)
         * 3: modEoCCNUMACAddress (1.3.6.1.4.1.17409.2.4.5.2.4.1.3)
         * //4: alarmText (1.3.6.1.4.1.17409.2.2.4)
         */
        try {
            String eocObjectIp = pdu.getRemoteAddress();
            long eventCreateTime = 0;
            int eventLevel = 0;
            String eventLevelText = "";
            String eventOid = "";
            String eventOidText = "";
            String eventTypeText = "";
            String eventInstance = "";
            int eventParaValue = 0;
            String modEoCCBATCardMACAddress = "";
            String modEoCCNUMACAddress = "";
            String alarmText = ""; // reserved

            for (int i = 0; i < vbs; i++) {
                SnmpOID oid = pdu.getObjectID(i);
                SnmpVar value = pdu.getVariable(i);

                String str = oid.toString();
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.length() - 2);
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.3.1.2")) { // alarmLogInformation
                    byte[] data = value.toBytes();
                    /**
                     * Description: ???????????????????????????
                     * ??? 1??8: ?????????(POSIX?????????????????????32??????64?????2038??????)
                     * ??? 9: ??????(??????????)
                     * ??? 10??m: ??????????????(????????ASN.1)
                     * ??? n??z: ??????? (????????ASN.1)
                     */
                    byte[] eventTime = null;
                    byte[] asn1Oid = null;
                    byte[] asn1Value = null;
                    int p = 0; // pos
                    int l = 0; // length

                    if (data != null) {
                        // event time
                        p = 0;
                        l = 8;
                        if (data.length >= (p + l)) {
                            eventCreateTime = 0;
                            eventTime = new byte[l];
                            System.arraycopy(data, p, eventTime, 0, l);
                            for (int n = 0; n < eventTime.length; n++)
                                eventCreateTime += (eventTime[eventTime.length - 1 - n] & 0xFF) << (8 * n);
                            // System.out.println("Event Time: [" +
                            // eventCreateTime + "]");
                        }

                        // event level
                        p += l;
                        l = 1;
                        if (data.length >= (p + l)) {
                            eventLevel = data[p];
                            /**
                             * ??????????
                             * 1 NOMINAL
                             * 2 HIHI
                             * 3 HI
                             * 4 LO
                             * 5 LOLO
                             * 6 Discrete Major
                             * 7 Discrete Minor
                             */
                            if (eventLevel == 1)
                                eventLevelText = "NOMINAL";
                            else if (eventLevel == 2)
                                eventLevelText = "HIHI";
                            else if (eventLevel == 3)
                                eventLevelText = "HI";
                            else if (eventLevel == 4)
                                eventLevelText = "LO";
                            else if (eventLevel == 5)
                                eventLevelText = "LOLO";
                            else if (eventLevel == 6)
                                eventLevelText = "Discrete Major";
                            else if (eventLevel == 7)
                                eventLevelText = "Discrete Minor";
                            // System.out.println("Event Level: [" + eventLevel
                            // + "], Event Level Text: [" + eventLevelText +
                            // "]");
                        }

                        // event oid
                        p += l;
                        if (data.length > p + 2) {
                            if (data[p] == 0x06) { // is OID
                                l = data[p + 1] + 2; // oid length
                                asn1Oid = new byte[l];
                                System.arraycopy(data, p, asn1Oid, 0, l);
                                org.ietf.jgss.Oid oidElement = new org.ietf.jgss.Oid(asn1Oid);
                                eventOid = oidElement.toString();
                                /**
                                 * ?????????????????8???????5???????????????????3???????????????
                                 * modEoCCNUOnlineStatus
                                 * (1.3.6.1.4.1.17409.2.4.5.2.4.1.4 +
                                 * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
                                 * modEoCCNURFAttenuation
                                 * (1.3.6.1.4.1.17409.2.4.5.2.4.1.10 +
                                 * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
                                 * modEoCCNURFDownstreamQuality
                                 * (1.3.6.1.4.1.17409.2.4.5.2.4.1.11 +
                                 * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
                                 * modEoCCNURFUpstreamQuality
                                 * (1.3.6.1.4.1.17409.2.4.5.2.4.1.12 +
                                 * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
                                 * modEoCCNUPhyDownstreamRate
                                 * (1.3.6.1.4.1.17409.2.4.5.2.4.1.13 +
                                 * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
                                 * modEoCCNUPhyUpstreamRate
                                 * (1.3.6.1.4.1.17409.2.4.5.2.4.1.14 +
                                 * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
                                 * modEoCCBATCardOnlineStatus
                                 * (1.3.6.1.4.1.17409.2.4.3.2.1.3 +
                                 * .modEoCCBATCardIndex)
                                 * modEoCCBATAdminTamperStatus
                                 * (1.3.6.1.4.1.17409.2.4.1.3.4 + .0)
                                 */
                                // System.out.println("Event OID: [" + eventOid
                                // + "]");
                                int pos = 0;
                                if ((pos = eventOid.indexOf("1.3.6.1.4.1.17409.2.4.5.2.4.1.4.")) >= 0) {
                                    eventOidText = "modEoCCNUOnlineStatus";
                                    pos += "1.3.6.1.4.1.17409.2.4.5.2.4.1.4.".length();
                                } else if ((pos = eventOid.indexOf("1.3.6.1.4.1.17409.2.4.5.2.4.1.10.")) >= 0) {
                                    eventOidText = "modEoCCNURFAttenuation";
                                    pos += "1.3.6.1.4.1.17409.2.4.5.2.4.1.10.".length();
                                } else if ((pos = eventOid.indexOf("1.3.6.1.4.1.17409.2.4.5.2.4.1.11.")) >= 0) {
                                    eventOidText = "modEoCCNURFDownstreamQuality";
                                    pos += "1.3.6.1.4.1.17409.2.4.5.2.4.1.11.".length();
                                } else if ((pos = eventOid.indexOf("1.3.6.1.4.1.17409.2.4.5.2.4.1.12.")) >= 0) {
                                    eventOidText = "modEoCCNURFUpstreamQuality";
                                    pos += "1.3.6.1.4.1.17409.2.4.5.2.4.1.12.".length();
                                } else if ((pos = eventOid.indexOf("1.3.6.1.4.1.17409.2.4.5.2.4.1.13.")) >= 0) {
                                    eventOidText = "modEoCCNUPhyDownstreamRate";
                                    pos += "1.3.6.1.4.1.17409.2.4.5.2.4.1.13.".length();
                                } else if ((pos = eventOid.indexOf("1.3.6.1.4.1.17409.2.4.5.2.4.1.14.")) >= 0) {
                                    eventOidText = "modEoCCNUPhyUpstreamRate";
                                    pos += "1.3.6.1.4.1.17409.2.4.5.2.4.1.14.".length();
                                } else if ((pos = eventOid.indexOf("1.3.6.1.4.1.17409.2.4.3.2.1.3.")) >= 0) {
                                    eventOidText = "modEoCCBATCardOnlineStatus";
                                    pos += "1.3.6.1.4.1.17409.2.4.3.2.1.3.".length();
                                } else if ((pos = eventOid.indexOf("1.3.6.1.4.1.17409.2.4.1.3.4.")) >= 0) {
                                    eventOidText = "modEoCCBATAdminTamperStatus";
                                    // pos +=
                                    // "1.3.6.1.4.1.17409.2.4.1.3.4.".length();
                                    pos = -1;
                                }
                                if (pos >= 0) {
                                    eventInstance = eventOid.substring(pos);
                                    eventInstance = eventInstance.replaceAll("\\.", "/");
                                }
                                eventTypeText = ServerResourceManager.getString("EoC_" + eventOidText) + (eventInstance.trim().length() > 0 ? (" (" + eventInstance + ")") : "");
                                // System.out.println("Event Type Text: [" +
                                // eventTypeText + "]");
                            }
                        }

                        // event parameter value
                        p += l;
                        if (data.length > p + 2) {
                            eventParaValue = 0;
                            if (data[p] == 0x02) { // is Integer
                                l = data[p + 1]; // value size
                                asn1Value = new byte[l];
                                System.arraycopy(data, p + 2, asn1Value, 0, l);
                                eventParaValue = getAsn1Int(asn1Value);
                            }
                            // System.out.println("Event Para Value: [" +
                            // eventParaValue + "]");
                        }
                    }
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.4.3.2.1.2")) { // modEoCCBATCardMACAddress
                    byte[] data = value.toBytes();
                    if (data != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int n = 0; n < data.length; n++) {
                            byte b = data[n];
                            if (b >= 0 && b < 16) {
                                sb.append("0");
                            }
                            sb.append(Integer.toHexString(data[n] & 0xFF).toUpperCase());
                            if (n < data.length - 1) {
                                sb.append("-");
                            }
                        }
                        modEoCCBATCardMACAddress = sb.toString();
                    }
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.4.5.2.4.1.3")) { // modEoCCNUMACAddress
                    byte[] data = value.toBytes();
                    if (data != null) {
                        StringBuilder sb = new StringBuilder(modEoCCNUMACAddress);
                        for (int n = 0; n < data.length; n++) {
                            byte b = data[n];
                            if (b >= 0 && b < 16) {
                                sb.append("0");
                            }
                            sb.append(Integer.toHexString(data[n] & 0xFF).toUpperCase());
                            if (n < data.length - 1) {
                                sb.append("-");
                            }
                        }
                        modEoCCNUMACAddress = sb.toString();
                    }
                }

                if (str.equals(".1.3.6.1.4.1.17409.2.2.4")) { // alarmText
                    alarmText = value != null ? value.toString().trim() : "";
                }
            }

            if (modEoCCNUMACAddress != null && modEoCCNUMACAddress.trim().length() > 0) {
                if (eventInstance != null && eventInstance.trim().length() > 0)
                    eventInstance = modEoCCNUMACAddress + "|" + eventInstance;
                else
                    eventInstance = modEoCCNUMACAddress;
            } else {
                if (modEoCCBATCardMACAddress != null && modEoCCBATCardMACAddress.trim().length() > 0)
                    if (eventInstance != null && eventInstance.trim().length() > 0)
                        eventInstance = modEoCCBATCardMACAddress + "|" + eventInstance;
                    else
                        eventInstance = modEoCCBATCardMACAddress;
            }
            eventTypeText = ServerResourceManager.getString("EoC_" + eventOidText) + (eventInstance.trim().length() > 0 ? (" (" + eventInstance + ")") : "");
            // System.out.println("Event Type Text: [" + eventTypeText + "]");

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(eocObjectIp);
            rtEntity.setSenderIP(eocObjectIp); // set node address
            rtEntity.setTrapOID(".1.3.6.1.4.1.17409.2.2.3.1"); // alarmLogEntry

            rtEntity.setSeqNO(-1);

            /**
             * ?????????????????8???????5???????????????????3???????????????
             * modEoCCNURFAttenuation (1.3.6.1.4.1.17409.2.4.5.2.4.1.10 +
             * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
             * modEoCCNURFDownstreamQuality (1.3.6.1.4.1.17409.2.4.5.2.4.1.11 +
             * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
             * modEoCCNURFUpstreamQuality (1.3.6.1.4.1.17409.2.4.5.2.4.1.12 +
             * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
             * modEoCCNUPhyDownstreamRate (1.3.6.1.4.1.17409.2.4.5.2.4.1.13 +
             * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
             * modEoCCNUPhyUpstreamRate (1.3.6.1.4.1.17409.2.4.5.2.4.1.14 +
             * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
             * modEoCCBATAdminTamperStatus (1.3.6.1.4.1.17409.2.4.1.3.4 + .0)
             * modEoCCBATCardOnlineStatus (1.3.6.1.4.1.17409.2.4.3.2.1.3 +
             * .modEoCCBATCardIndex)
             * modEoCCNUOnlineStatus (1.3.6.1.4.1.17409.2.4.5.2.4.1.4 +
             * .modEoCCNUCBATCardIndex.modEoCCNUIndex)
             */
            // TODO
            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + eventOidText);
            rtEntity.setAlarmID(String.valueOf(eventOidText));

            // String eponAlarmInstance =
            // EponTrapParserHelper.getBbs4000R4EponAlarmInstanceString(trapInstance);
            // if (eponAlarmInstance.equalsIgnoreCase("N/A"))
            // rtEntity.setEntityInstance(rtEntity.getMoType() + "-" +
            // rtEntity.getSenderIP());
            // else
            // rtEntity.setEntityInstance(eponAlarmInstance);
            rtEntity.setEntityInstance(eocObjectIp + (eventInstance.trim().length() > 0 ? ("-" + eventInstance) : "")); // TODO

            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(1)); // set
            // alarm
            // class
            // as
            // 'communication'

            // String key = EponTrapParserHelper.getKey(rtEntity.getMoName(),
            // trapSequenceNumber);
            // rtEntity.setEntity(key);
            rtEntity.setEntity(eocObjectIp); // TODO

            rtEntity.setCreateTime(eventCreateTime * 1000);

            rtEntity.setSeverity(6);

            // message: eventType + eventOidText + Index + alarmText
            rtEntity.setAdditionalInfo(alarmText);

            // rtEntity.setMessage(EponTrapParserHelper.getEocEventMessage(trapCode,
            // alarmText));
            String sMessage = eventLevelText;
            if (eventTypeText.trim().length() > 0) {
                sMessage += ", " + eventTypeText;
                String eventParaValueText = "";
                if ("modEoCCBATAdminTamperStatus".equalsIgnoreCase(eventOidText))
                    eventParaValueText = (eventParaValue == 1 ? "intact" : (eventParaValue == 2 ? "compromised" : String.valueOf(eventParaValue)));
                else if ("modEoCCBATCardOnlineStatus".equalsIgnoreCase(eventOidText))
                    eventParaValueText = (eventParaValue == 0 ? "offline" : (eventParaValue == 1 ? "online" : String.valueOf(eventParaValue)));
                else if ("modEoCCNUOnlineStatus".equalsIgnoreCase(eventOidText))
                    eventParaValueText = (eventParaValue == 0 ? "offline" : (eventParaValue == 1 ? "online" : String.valueOf(eventParaValue)));
                else
                    eventParaValueText = String.valueOf(eventParaValue);
                sMessage += ", Value: " + eventParaValueText;
            }
            if (modEoCCBATCardMACAddress.trim().length() > 0)
                sMessage += ", CBAT Card MAC: " + modEoCCBATCardMACAddress;
            if (modEoCCNUMACAddress.trim().length() > 0)
                sMessage += ", CNU MAC: " + modEoCCNUMACAddress;
            if (alarmText.trim().length() > 0)
                sMessage += ", " + alarmText;
            rtEntity.setMessage(sMessage); // TODO

            rtEntity.setSource(rtEntity.getMoName());

            System.out.println("<decodeEocEvent> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeEocEvent> ***************** [Exception]: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static int getAsn1Int(byte[] value) {
        if (value == null)
            return 0;

        boolean isNegative = (value[0] < 0);

        int pv = 1;
        for (int n = 0; n < value.length; n++)
            pv *= 256;

        int z = 0;
        for (int i = 0; i < value.length; i++) {
            z += (value[value.length - 1 - i] & 0xFF) << (8 * i);
        }
        if (isNegative)
            z = z - pv;

        return z;
    }

    public ParseEntity decodeONU204IK2HistoryAlarm(String remoteAddress, int sequenceNumber, Object[] data) throws Exception {
        /**
         * //".1.3.6.1.4.1.17409.2.2.11.2.2.1.1", //: historyAlarmSeqNum
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.2", //0: historyAlarmCode
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.3", //1: historyAlarmInstance
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.4", //2: historyAlarmSeverity
         * //".1.3.6.1.4.1.17409.2.2.11.2.2.1.5", //: historyAlarmRaisingNumber
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.6", //3: historyAlarmFirstOccurTime
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.7", //4: historyAlarmLastOccurTime
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.8", //5: historyAlarmRepeats
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.9", //6: historyAlarmCorrelationId
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.10", //7: historyAlarmAdditionalText
         * ".1.3.6.1.4.1.17409.2.2.11.2.2.1.11", //8: historyAlarmClearTime
         * };
         **/

        if (sequenceNumber <= 0 || data == null || data.length <= 0)
            return null;

        if (data.length < 9)
            throw new Exception("Expect 9 VBs but " + data.length + " sent by NE");

        System.out.println("<decodeONU204IK2HistoryAlarm> ***************** Data *****************");

        try {
            int pcCode = Integer.parseInt(data[0].toString());
            int spCode = Integer.parseInt(data[0].toString());
            int entityType = 0;
            // int entityType = Integer.parseInt(data[3].toString());

            int entityInstance = data[1].toString().getBytes()[5];
            int alarmSeverity = Integer.parseInt(data[2].toString());
            String alarmAdditionalText = data[7].toString().trim();

            long alarmOccurTime = 0L;
            Date occurTime = AlarmUtil.bytes2Date(data[3].toString().getBytes("iso-8859-1"));
            alarmOccurTime = (occurTime == null) ? (new Date()).getTime() : occurTime.getTime();

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(remoteAddress);
            rtEntity.setSenderIP(remoteAddress); // set node address
            rtEntity.setTrapOID(".1.3.6.1.4.1.17409.2.2.2.2.1"); // utsGponAlarmTrap
            rtEntity.setSessionID(sequenceNumber);
            rtEntity.setSeqNO(sequenceNumber);
            rtEntity.setCreateTime(alarmOccurTime);

            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(1)); // set
            // alarm
            // class
            // as
            // 'communication'
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(entityType)); // set
            // entity
            // Type
            rtEntity.setETCode(Integer.toString(entityType)); // set entity Type

            String instance = "PON-" + entityInstance;
            rtEntity.setEntityInstance(instance);

            // TODO
            if (rtEntity.getMoName() != null) {
                String source = rtEntity.getMoName();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getMoName());
            } else {
                String source = rtEntity.getSenderIP();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getSenderIP());
            }

            // if (alarmSeverity ==
            // com.winnertel.ems.fm.common.ConstantVar.CLEAR) {
            String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), sequenceNumber);
            // String key = getKey(trapEntity.getSenderIP(), correlationId);
            rtEntity.setEntity(key);
            // } else {
            // String key = EponTrapParserHelper.getKey(rtEntity.getMoName(),
            // sequenceNumber);
            // String key = getKey(trapEntity.getSenderIP(), seqNo);
            // rtEntity.setEntity(key);
            // }

            rtEntity.setSeverity(alarmSeverity);
            // if (correlationID >= 1) { //clear alarm
            // rtEntity.setSeverity(com.winnertel.ems.fm.common.ConstantVar.CLEAR);
            // }

            rtEntity.setProCause(EponTrapParserHelper.getBbs4000R4EponAlarmCode(pcCode)); // set
            // probable
            // cause
            rtEntity.setPCode(Integer.toString(pcCode)); // set probable cause

            rtEntity.setSepCause(EponTrapParserHelper.getBbs4000R4EponAlarmCode(spCode)); // set
            // probable
            // cause
            rtEntity.setSPCode(Integer.toString(spCode)); // set probable cause

            rtEntity.setMessage(EponTrapParserHelper.getUTMessage(rtEntity, alarmAdditionalText));
            rtEntity.setAdditionalInfo(alarmAdditionalText);

            int alarmID = ((pcCode & 0x0000ffff) << 16) + (spCode & 0x0000ffff);
            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + alarmID);
            rtEntity.setAlarmID(String.valueOf(alarmID));

            System.out.println("<decodeONU204IK2HistoryAlarm> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeONU204IK2HistoryAlarm> ***************** [Exception]: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public ParseEntity decodeONU204IK2ActiveAlarm(String remoteAddress, int sequenceNumber, Object[] data) throws Exception {
        /**
         * //".1.3.6.1.4.1.17409.2.2.11.2.1.1.1", //1: activeAlarmSeqNum
         * ".1.3.6.1.4.1.17409.2.2.11.2.1.1.2." + id + ".0", //0:
         * activeAlarmCode
         * ".1.3.6.1.4.1.17409.2.2.11.2.1.1.3." + id + ".0", //1:
         * activeAlarmInstance
         * ".1.3.6.1.4.1.17409.2.2.11.2.1.1.4." + id + ".0", //2:
         * activeAlarmSeverity
         * //".1.3.6.1.4.1.17409.2.2.11.2.1.5.", //5: activeAlarmRaisingNumber
         * ".1.3.6.1.4.1.17409.2.2.11.2.1.1.6." + id + ".0", //3:
         * activeAlarmFirstOccurTime
         * ".1.3.6.1.4.1.17409.2.2.11.2.1.1.7." + id + ".0", //4:
         * activeAlarmLastOccurTime
         * ".1.3.6.1.4.1.17409.2.2.11.2.1.1.8." + id + ".0", //5:
         * activeAlarmRepeats
         * ".1.3.6.1.4.1.17409.2.2.11.2.1.1.9." + id + ".0", //6:
         * activeAlarmAdditionalText
         * };
         **/

        if (sequenceNumber <= 0 || data == null || data.length <= 0)
            return null;

        if (data.length < 7)
            throw new Exception("Expect 7 VBs but " + data.length + " sent by NE");

        System.out.println("<decodeONU204IK2ActiveAlarm> ***************** Data *****************");

        try {
            int pcCode = Integer.parseInt(data[0].toString());
            int spCode = Integer.parseInt(data[0].toString());
            int entityType = 0;
            // int entityType = Integer.parseInt(data[3].toString());

            int entityInstance = data[1].toString().getBytes()[5];

            int alarmSeverity = Integer.parseInt(data[2].toString());
            String alarmAdditionalText = data[6].toString().trim();

            long alarmOccurTime = 0L;
            Date occurTime = AlarmUtil.bytes2Date(data[3].toString().getBytes("iso-8859-1"));
            alarmOccurTime = (occurTime == null) ? (new Date()).getTime() : occurTime.getTime();

            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(remoteAddress);
            rtEntity.setSenderIP(remoteAddress); // set node address
            rtEntity.setTrapOID(".1.3.6.1.4.1.17409.2.2.2.2.1"); // utsGponAlarmTrap
            rtEntity.setSessionID(sequenceNumber);
            rtEntity.setSeqNO(sequenceNumber);
            rtEntity.setCreateTime(alarmOccurTime);

            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(1)); // set
            // alarm
            // class
            // as
            // 'communication'
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(entityType)); // set
            // entity
            // Type
            rtEntity.setETCode(Integer.toString(entityType)); // set entity Type

            String instance = "PON-" + entityInstance;
            rtEntity.setEntityInstance(instance);

            // TODO
            if (rtEntity.getMoName() != null) {
                String source = rtEntity.getMoName();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getMoName());
            } else {
                String source = rtEntity.getSenderIP();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getSenderIP());
            }

            // if (alarmSeverity ==
            // com.winnertel.ems.fm.common.ConstantVar.CLEAR) {
            String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), sequenceNumber);
            // String key = getKey(trapEntity.getSenderIP(), correlationId);
            rtEntity.setEntity(key);
            // } else {
            // String key = EponTrapParserHelper.getKey(rtEntity.getMoName(),
            // sequenceNumber);
            // String key = getKey(trapEntity.getSenderIP(), seqNo);
            // rtEntity.setEntity(key);
            // }

            rtEntity.setSeverity(alarmSeverity);
            // if (correlationID >= 1) { //clear alarm
            // rtEntity.setSeverity(com.winnertel.ems.fm.common.ConstantVar.CLEAR);
            // }

            rtEntity.setProCause(EponTrapParserHelper.getBbs4000R4EponAlarmCode(pcCode)); // set
            // probable
            // cause
            rtEntity.setPCode(Integer.toString(pcCode)); // set probable cause

            rtEntity.setSepCause(EponTrapParserHelper.getBbs4000R4EponAlarmCode(spCode)); // set
            // probable
            // cause
            rtEntity.setSPCode(Integer.toString(spCode)); // set probable cause

            rtEntity.setMessage(EponTrapParserHelper.getUTMessage(rtEntity, alarmAdditionalText));
            rtEntity.setAdditionalInfo(alarmAdditionalText);

            int alarmID = ((pcCode & 0x0000ffff) << 16) + (spCode & 0x0000ffff);
            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + alarmID);
            rtEntity.setAlarmID(String.valueOf(alarmID));

            System.out.println("<decodeONU204IK2ActiveAlarm> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeONU204IK2ActiveAlarm> ***************** [Exception]: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    /**
     * parse JS16B-v/JS24B-v alarm
     *
     * @param pdu
     * @return
     * @throws Exception
     */
    public ParseEntity decodeJSXB_vAlarm(SnmpPDU pdu) throws Exception {
        if (pdu == null)
            return null;
        int vbs = pdu.getVariableBindings().size();
        if (vbs < 1)
            throw new Exception("Expect 1 or more VBs but " + vbs + " sent by NE");

        System.out.println("<decodeJS16B-v/JS24B-vAlarm> ***************** PDU *****************");
        /**
         * Mib Oid Objects:
         *
         * 1: linkDown 1.3.6.1.6.3.1.1.5.3 (1: ifIndex 2: ifAdminStatus 3:
         * ifOperStatus)
         * oid 1.3.6.1.2.1.2.2.1.1
         * oid 1.3.6.1.2.1.2.2.1.7
         * 1: up(1)
         * 2: down(2)
         * 3: testing(3)
         * oid 1.3.6.1.2.1.2.2.1.8
         * 1: up(1)
         * 2: down(2)
         * 3: testing(3)
         * 4: unknown(4)
         * 5: dormant(5)
         * 6: notPresent(6)
         * 7: lowerLayerDown(7)
         * 2: linkUp 1.3.6.1.6.3.1.1.5.4 (1: ifIndex 2: ifAdminStatus 3:
         * ifOperStatus)
         * 3: ponOnuTrapUpsStatusGetFailed 1.3.6.1.4.1.13367.1.10.1 (1:
         * ponOnuUpsStatus)
         * oid 1.3.6.1.4.1.13367.1.1.7.1
         * 1: upsStatusGetFailed(1)
         * 2: upsStatusGetSuccess(2)
         * 3: changeToUtility(3)
         * 4: changeToBattery(4)
         * 5: useBattery(5)
         * 6: batteryPowerLower(6)
         * 7: batteryPowerLow2Normal(7)
         * 8: batteryPowerNormal2Low(8)
         * 9: batteryChargeEnable(9)
         * 10: batteryChargeDisable(10)
         * 11: upsDevFailed(11)
         * 4: ponOnuTrapUpsStatusGetSuccessful 1.3.6.1.4.1.13367.1.10.2 (1:
         * ponOnuUpsStatus)
         * 5: ponOnuTrapUpsBatteryPowerNormal2low 1.3.6.1.4.1.13367.1.10.8 (1:
         * ponOnuUpsStatus 2: ponOnuUpsVoltage)
         * oid 1.3.6.1.4.1.13367.1.1.7.1
         * oid 1.3.6.1.4.1.13367.1.1.7.2
         * 6: ponOnuTrapUpsBatteryPowerLow2normal 1.3.6.1.4.1.13367.1.10.7 (1:
         * ponOnuUpsStatus)
         * 7: ponOnuTrapUpsDevFailed 1.3.6.1.4.1.13367.1.10.11 (1:
         * ponOnuUpsStatus)
         **/

        int sessionID = 0;
        int sequenceNumber = 0;
        long trapOccurTime = 0;
        int alarmClass = 0;
        int entityType = 0;
        int entityInstance = 0;
        int severity = 0;
        int pcCode = 0;
        int spCode = 0;
        int trapCode = 0;
        String versionID = "";
        int correlationID = 0;
        String sourceIP = "";
        String additionalText = "";
        int alarmID = 0;
        String trapOID = "";
        int voltage = 0;
        int alarmType = AlarmType_Unknown;
        String adminStatus = "";
        String operStatus = "";
        boolean isAlarm = false;

        for (int i = 0; i < vbs; i++) {
            SnmpOID oid = pdu.getObjectID(i);
            SnmpVar value = pdu.getVariable(i);

            String str = oid.toString();
            try {
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.length() - 2);
                }

                // general object
                trapOccurTime = new Date().getTime();

                // linkDown/linkUp-----------------------------------------------------
                if (str.indexOf(".1.3.6.1.2.1.2.2.1.1") >= 0) { // ifIndex
                    entityInstance = Integer.parseInt(value.toValue().toString());
                } else if (str.indexOf(".1.3.6.1.2.1.2.2.1.7") >= 0) { // ifAdminStatus
                    adminStatus = EponTrapParserHelper.getInterfaceIfAdminStatus(Integer.parseInt(value.toValue().toString()));
                } else if (str.indexOf(".1.3.6.1.2.1.2.2.1.8") >= 0) { // ifOperStatus
                    trapOID = ".1.3.6.1.2.1.2.2.1";
                    String tmp = value.toValue().toString();
                    if ("1".equals(tmp)) {// linkUp
                        alarmType = AlarmType_LinkDown;
                        alarmID = 33882113;
                        pcCode = 517;
                        spCode = 1;
                        entityType = EntityType_Interface;
                        severity = com.winnertel.ems.fm.common.ConstantVar.CLEAR;
                        alarmClass = Equipment;
                        isAlarm = true;
                    } else if ("2".equals(tmp)) {// linkDown
                        alarmType = AlarmType_LinkDown;
                        alarmID = 33882113;
                        pcCode = 517;
                        spCode = 1;
                        entityType = EntityType_Interface;
                        severity = com.winnertel.ems.fm.common.ConstantVar.MINOR;
                        alarmClass = Equipment;
                        isAlarm = true;
                    }
                    operStatus = EponTrapParserHelper.getInterfaceIfOperStatus(Integer.parseInt(tmp));
                    // linkDown/linkUp-----------------------------------------------------END
                } else if (str.indexOf(".1.3.6.1.4.1.13367.1.1.7.1") >= 0) {// ponOnuUpsStatus
                    trapOID = ".1.3.6.1.4.1.13367.1.1.7";
                    String tmp = value.toValue().toString();
                    if ("1".equals(tmp)) {// ponOnuTrapUpsStatusGetFailed
                        alarmType = AlarmType_UpsStatusGetFailed;
                        alarmID = 1;
                        pcCode = 0;
                        spCode = 1;
                        entityType = EntityType_Node;
                        severity = com.winnertel.ems.fm.common.ConstantVar.MAJOR;
                        alarmClass = Undefined;
                        isAlarm = true;
                    } else if ("2".equals(tmp)) {// upsStatusGetSuccess
                        alarmType = AlarmType_UpsStatusGetFailed;
                        alarmID = 1;
                        pcCode = 0;
                        spCode = 1;
                        entityType = EntityType_Node;
                        severity = com.winnertel.ems.fm.common.ConstantVar.CLEAR;
                        alarmClass = Undefined;
                        isAlarm = true;
                    } else if ("7".equals(tmp)) {// ponOnuTrapUpsBatteryPowerLow2normal
                        alarmType = AlarmType_BatteryPowerLow;
                        alarmID = 7340033;
                        pcCode = 112;
                        spCode = 1;
                        entityType = EntityType_Node;
                        severity = com.winnertel.ems.fm.common.ConstantVar.CLEAR;
                        alarmClass = Equipment;
                        isAlarm = true;
                    } else if ("8".equals(tmp)) {// ponOnuTrapUpsBatteryPowerNormal2low
                        alarmType = AlarmType_BatteryPowerLow;
                        alarmID = 7340033;
                        pcCode = 112;
                        spCode = 1;
                        entityType = EntityType_Node;
                        severity = com.winnertel.ems.fm.common.ConstantVar.MAJOR;
                        alarmClass = Equipment;
                        isAlarm = true;
                    } else if ("11".equals(tmp)) {// ponOnuTrapUpsDevFailed
                        alarmType = AlarmType_UpsDevFailed;
                        alarmID = 36110337;
                        pcCode = 551;
                        spCode = 1;
                        entityType = EntityType_Node;
                        severity = com.winnertel.ems.fm.common.ConstantVar.MAJOR;
                        alarmClass = Equipment;
                        isAlarm = true;
                    }

                } else if (str.indexOf(".1.3.6.1.4.1.13367.1.1.7.2") >= 0) {// ponOnuUpsVoltage
                    voltage = Integer.parseInt(value.toValue().toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!isAlarm)
            return null;

        switch (alarmType) {
            case AlarmType_LinkDown:
                additionalText = EponTrapParserHelper.getDescriptionByKey("ONU_Interface_IfAdminStatus_Label") + "Down" + EponTrapParserHelper.getDescriptionByKey("ONU_Interface_IfOperStatus_Label") + "Down";
                break;
            case AlarmType_UpsStatusGetFailed:
                additionalText = "";
                break;
            case AlarmType_BatteryPowerLow:
                additionalText = EponTrapParserHelper.getDescriptionByKey("ONU_UpsBatteryPower_Label") + voltage;
                break;
            case AlarmType_UpsDevFailed:
                additionalText = "";
                break;
            default:
                additionalText = "";
        }

        try {
            ParseEntity rtEntity = EponTrapUtil.generateBasicParseEntity(pdu.getRemoteAddress());
            rtEntity.setSenderIP(pdu.getRemoteAddress()); // set node address
            rtEntity.setTrapOID(trapOID); //
            rtEntity.setSessionID(sessionID);
            rtEntity.setSeqNO(sequenceNumber);
            rtEntity.setCreateTime(trapOccurTime);
            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(alarmClass)); // set
            // alarm
            // class
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(entityType)); // set
            // entity
            // Type
            rtEntity.setETCode(Integer.toString(entityType)); // set entity type
            String instance = "Ethernet-" + entityInstance;
            rtEntity.setEntityInstance(instance);

            if (rtEntity.getMoName() != null) {
                String source = rtEntity.getMoName();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
            } else {
                String source = rtEntity.getSenderIP();
                source = source + "_" + entityType + "_" + entityInstance;
                rtEntity.setSource(source);
            }

            // the same key in same type alarm
            String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), alarmID);
            rtEntity.setEntity(key);

            rtEntity.setSeverity(severity);

            rtEntity.setProCause(EponTrapParserHelper.getBbs4000R4EponAlarmCode(pcCode)); // set
            // probable
            // cause
            rtEntity.setPCode(Integer.toString(pcCode)); // set probable
            // cause

            rtEntity.setSepCause(""); // set probable cause
            rtEntity.setSPCode(Integer.toString(spCode)); // set probable
            // cause

            rtEntity.setMessage(EponTrapParserHelper.getUTMessage(rtEntity, additionalText));
            rtEntity.setAdditionalInfo(additionalText);

            rtEntity.setAlarmID(String.valueOf(alarmID));

            System.out.println("<decodeJS16B-v/JS24B-vAlarm> ***************** com.winnertel.em.broadband.common.alarm.ParseEntity object value is [" + rtEntity.toString() + "] *****************");
            return rtEntity;
        } catch (Exception e) {
            System.out.println("<decodeJS16B-v/JS24B-vAlarm> ***************** [Exception] com.winnertel.em.broadband.common.alarm.ParseEntity object is NULL *****************");
            e.printStackTrace();
        }

        return null;
    }



}
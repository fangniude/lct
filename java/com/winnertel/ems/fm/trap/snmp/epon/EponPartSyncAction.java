package com.winnertel.ems.fm.trap.snmp.epon;

import com.winnertel.ems.epon.fm.BBSNeAlarmSync;
import com.winnertel.ems.epon.fm.EponAlarmTrapParser;
import com.winnertel.ems.epon.fm.EponAlarmUtils;
import com.winnertel.ems.epon.fm.trap.bbs.parse.BbsTrapParser;
import com.winnertel.ems.fm.common.AlarmUtil;
import com.winnertel.em.broadband.common.alarm.ParseEntity;
import com.winnertel.em.broadband.common.alarmsync.action.AlarmSyncAction;
import com.winnertel.em.broadband.common.alarmsync.config.FMEConstant;
import com.winnertel.em.broadband.common.alarmsync.exception.ActionException;
import com.winnertel.em.broadband.common.alarmsync.exception.ActionNonRecException;
import com.winnertel.em.broadband.common.util.FmLogUtil;
import com.winnertel.ems.fm.alarmdb.Alarm;
import com.winnertel.nms.alertdb.UEventAPI;
import com.winnertel.snmp.beans.SnmpErrorMessages;
import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.DefaultSnmpAPI;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.snmp.snmp2.SnmpVar;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class EponPartSyncAction implements AlarmSyncAction {

    private EponAlarmTrapParser alarmParser;

    public EponPartSyncAction() {
        alarmParser = new EponAlarmTrapParser();
    }

    public Vector execute(String nodeName, int syncType, Map para) throws ActionException {
        // boolean isCommonTrap = true;
        boolean isBbs4000R4Trap = false;
        boolean isCLT2168Trap = false;
        String nodeAddress = AlarmUtil.getNodeAddress(nodeName);
//        Properties prop = ServerUtility.getNePropertiesByIpAddr(nodeAddress);
//        if (prop != null) {
//            String neType = prop.getProperty(NEConstant.NE_TYPE_KEY, "BBS4000");
//            String neVersion = prop.getProperty(NEConstant.NE_VERSION_KEY, "2.1.0");
//            if (neType.startsWith("BBS4000")) {
//                if (neVersion.startsWith("4.0."))
//                    isBbs4000R4Trap = true;
//                // else
//                // isCommonTrap = Version.greatOrEqual(neVersion, "2.1.6");
//            } else if (neType.startsWith("BBS1000")) {
//                // isCommonTrap = Version.greatOrEqual(neVersion, "3.4.0");
//            } else if (neType.startsWith("CLT2168")) {
//                isCLT2168Trap = true;
//            }
//        }

        SnmpTarget target = BBSNeAlarmSync.getSnmpTargetForGet(nodeName);
        int startSeqID = 0;
        int endSeqID = 0;
        int sessionID = 0;

        List idList = new Vector();

        if (isBbs4000R4Trap) {
            // TODO
            int nmSQ = Integer.parseInt((para.get(FMEConstant.NMS_QID)).toString());
            if (nmSQ <= 0)
                nmSQ = 1;
            else if (nmSQ % 2 == 0)
                nmSQ += 1;
            startSeqID = nmSQ + 1;
            endSeqID = Integer.parseInt((para.get(FMEConstant.NE_SQID)).toString());
            if (endSeqID % 2 != 0) {
                endSeqID += 1;
            }
            sessionID = Integer.parseInt((para.get(FMEConstant.NE_SID)).toString());

            for (int i = startSeqID; i <= endSeqID; i += 2) {
                idList.add(Integer.valueOf(i));
            }
        } else {
            startSeqID = Integer.parseInt((para.get(FMEConstant.NMS_QID)).toString()) + 1;
            endSeqID = Integer.parseInt((para.get(FMEConstant.NE_SQID)).toString()) + 1;
            sessionID = Integer.parseInt((para.get(FMEConstant.NE_SID)).toString());

            for (int i = startSeqID; i <= endSeqID; i++) {
                idList.add(Integer.valueOf(i));
            }
        }

        Vector entityList = getAlarms(nodeName, target, idList, sessionID);
        for (int i = 0; i < entityList.size(); i++) {
            ParseEntity parseEntity = (ParseEntity) entityList.get(i);
            Alarm alarm = EponAlarmUtils.convertEponParseEntity(parseEntity);
            UEventAPI.addAlarm(alarm);
        }

        return null;
    }

    // modified by Zhou Chao, 2010/5/13
    public Vector getAlarms(String neName, SnmpTarget target, List idList, long sessionID) throws ActionException {
        if (neName == null || target == null || idList == null)
            return null;

        boolean isCommonTrap = true;
        boolean isBbs4000R4Trap = false;
        boolean isCLT2168Trap = false;
        boolean isBBS4606Trap = false;
        boolean isONU204IK2 = false;
        String nodeAddress = AlarmUtil.getNodeAddress(neName);
//        Properties prop = ServerUtility.getNePropertiesByIpAddr(nodeAddress);
//        if (prop != null) {
//            String neType = prop.getProperty(NEConstant.NE_TYPE_KEY, "BBS4000");
//            String neVersion = prop.getProperty(NEConstant.NE_VERSION_KEY, "2.1.0");
//            if (neType.startsWith("BBS4000")) {
//                if (neVersion.startsWith("4.0."))
//                    isBbs4000R4Trap = true;
//                else
//                    isCommonTrap = Version.greatOrEqual(neVersion, "2.1.6");
//            } else if (neType.startsWith("BBS1000")) {
//                isCommonTrap = Version.greatOrEqual(neVersion, "3.4.0");
//            } else if (neType.startsWith("BBS4606")) {
//                isBBS4606Trap = true;
//            } else if (neType.startsWith("ONU204i-k2")) {
//                isONU204IK2 = true;
//            } else if (neType.startsWith("CLT2168")) {
//                isCLT2168Trap = true;
//            }
//        }

//        if (isONU204IK2) {
//            return doBBSONU204IK2PartSync(neName, target, idList, sessionID);
//        } else if (isBbs4000R4Trap) {
//            return doBbs4000R4NePartSync(neName, target, idList, sessionID);
//        } else if (isCLT2168Trap) {
//            return doCLT2168NePartSync(neName, target, idList, sessionID);
//        } else if (isBBS4606Trap) {
//            return doBBS4606NEPartSync(neName, target, idList, sessionID);
//        } else if (isCommonTrap) {
            return doEponNePartSync(neName, target, idList, sessionID);
//        } else {
//            return doG3NePartSync(neName, target, idList, sessionID);
//        }
    }

    // added by Zhou Chao, 2010/5/13
    private Vector doG3NePartSync(String neName, SnmpTarget target, List idList, long sessionID) {
        Vector result = new Vector();

        try {
            String nodeAddress = AlarmUtil.getNodeAddress(neName);
            for (int i = 0; i < idList.size(); i++) {
                int id = (Integer) idList.get(i);
                try {
                    String oids[] = {".1.3.6.1.4.1.41355.2.3.2.2.5.1.2." + id}; // utHistoryAlarmEntry
                    target.setObjectIDList(oids);

                    SnmpVar[] vbs = target.snmpGetVariables();
                    if (vbs == null) {
                        if (target.getErrorCode() == SnmpErrorMessages.REQ_TIMEDOUT) {
                            FmLogUtil.writeErrLog("EponPartSyncAction->doG3NePartSync: fetch alarm " + id + " time out");
                        } else {
                            FmLogUtil.writeErrLog("EponPartSyncAction->doG3NePartSync: fetch alarm " + id + " sync error. code: " + target.getErrorCode());
                        }
                    } else {
                        // String seqNo = String.valueOf(id);
                        SnmpPDU pdu = BBSNeAlarmSync.generateSnmpPDU(vbs[0].toBytes(), nodeAddress);
                        if (pdu != null) {
                            if (pdu.getVersion() == DefaultSnmpAPI.SNMP_VERSION_2 || pdu.getVersion() == DefaultSnmpAPI.SNMP_VERSION_2C) {
                                pdu = BBSNeAlarmSync.changeToV1(pdu);
                            }
                        } else {
                            FmLogUtil.writeErrLog("EponPartSyncAction->doG3NePartSync: pdu is null, octet string of original pdu is : " + vbs[0].toString());
                        }

                        Alarm alarm = alarmParser.parseToAlarm(pdu);
                        if (alarm != null) {
                            result.add(EponAlarmUtils.convertEponAlarm(alarm, pdu, sessionID));
                        }
                    }
                } catch (Exception e) {
                    FmLogUtil.writeErrLog(e);
                    throw new ActionNonRecException(nodeAddress, FMEConstant.PARTIAL_SYNC, "Sync Error");
                }
            }
        } catch (Exception e) {
            FmLogUtil.writeErrLog(e);
        }

        return result;
    }

    // added by Zhou Chao, 2010/5/13
    private Vector doEponNePartSync(String neName, SnmpTarget target, List idList, long sessionID) {
        Vector result = new Vector();

        try {
            String nodeAddress = AlarmUtil.getNodeAddress(neName);
            for (int i = 0; i < idList.size(); i++) {
                int id = (Integer) idList.get(i);
                try {
                    String oids[] = new String[]{ // utsBbsAlarmTrapLogTable
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.2." + id, // 0:
                            // utsBbsAlarmTrapLogProbableCause
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.3." + id, // 1:
                            // utsBbsAlarmTrapLogSpecificProblem
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.4." + id, // 2:
                            // utsBbsAlarmTrapLogEntityType
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.5." + id, // 3:
                            // utsBbsAlarmTrapLogEntityInstance
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.6." + id, // 4:
                            // utsBbsAlarmTrapLogOccurenceTime
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.7." + id, // 5:
                            // utsBbsAlarmTrapLogClass
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.8." + id, // 6:
                            // utsBbsAlarmTrapLogSeverity
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.9." + id, // 7:
                            // utsBbsAlarmTrapLogCorrelationId
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.10." + id, // 8:
                            // utsBbsAlarmTrapLogAdditionalText
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.14." + id, // 9:
                            // utsBbsAlarmTrapLogVersionId
                            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.2.1.15." + id, // 10:
                            // utsBbsAlarmTrapLogSessionId
                    };
                    target.setObjectIDList(oids);
                    SnmpVar[] vbs = target.snmpGetVariables();
                    if (vbs == null) {
                        if (target.getErrorCode() == SnmpErrorMessages.REQ_TIMEDOUT) {
                            FmLogUtil.writeErrLog("EponPartSyncAction->doEponNePartSync: fetch alarm " + id + " time out");
                        } else {
                            FmLogUtil.writeErrLog("EponPartSyncAction->doEponNePartSync: fetch alarm " + id + " sync error. code: " + target.getErrorCode());
                        }
                    } else {
                        BbsTrapParser bbsTrapParser = new BbsTrapParser();
                        ParseEntity entity = bbsTrapParser.decodeEponPartAlarm(nodeAddress, id, vbs);
                        if (entity != null)
                            result.add(entity);
                    }
                } catch (Exception e) {
                    FmLogUtil.writeErrLog(e);
                    throw new ActionNonRecException(nodeAddress, FMEConstant.PARTIAL_SYNC, "Sync Error");
                }
            }
        } catch (Exception e) {
            FmLogUtil.writeErrLog(e);
        }

        return result;
    }
//
//    private Vector doBBSONU204IK2PartSync(String neName, SnmpTarget target, List idList, long sessionID) {
//
//        Vector result = new Vector();
//
//        try {
//            String nodeAddress = AlarmUtil.getNodeAddress(neName);
//
//            for (int i = 0; i < idList.size(); i++) {
//                int id = (Integer) idList.get(i);
//                String oids[] = new String[]{
//                        // ".1.3.6.1.4.1.17409.2.2.11.2.2.1.1", //1:
//                        // historyAlarmSeqNum
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.2." + id + ".0", // 0:
//                        // historyAlarmCode
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.3." + id + ".0", // 1:
//                        // historyAlarmInstance
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.4." + id + ".0", // 2:
//                        // historyAlarmSeverity
//                        // ".1.3.6.1.4.1.17409.2.2.11.2.2.1.5", //5:
//                        // historyAlarmRaisingNumber
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.6." + id + ".0", // 3:
//                        // historyAlarmFirstOccurTime
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.7." + id + ".0", // 4:
//                        // historyAlarmLastOccurTime
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.8." + id + ".0", // 5:
//                        // historyAlarmRepeats
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.9." + id + ".0", // 6:
//                        // historyAlarmCorrelationId
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.10." + id + ".0", // 7:
//                        // historyAlarmAdditionalText
//                        ".1.3.6.1.4.1.17409.2.2.11.2.2.1.11." + id + ".0", // 8:
//                        // historyAlarmClearTime
//                };
//
//                try {
//                    target.setObjectIDList(oids);
//                    // SnmpVar[] vbs = target.snmpGetVariables();
//                    SnmpVar[] vbs = target.snmpGetNextVariables();
//                    if (vbs == null || vbs.length <= 0) {
//                        if (target.getErrorCode() == SnmpErrorMessages.REQ_TIMEDOUT) {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doBBSONU204IK2PartSync: fetch alarm " + id + " time out");
//                        } else {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doBBSONU204IK2PartSync: fetch alarm " + id + " sync error. code: " + target.getErrorCode());
//                        }
//                    } else {
//                        String oidList1 = target.getObjectIDList()[0];
//                        if (oidList1.startsWith(oids[0] + ".")) {
//                            BbsTrapParser bbsTrapParser = new BbsTrapParser();
//                            ParseEntity entity = bbsTrapParser.decodeONU204IK2HistoryAlarm(nodeAddress, id, vbs);
//                            if (entity != null)
//                                result.add(entity);
//                        }
//                    }
//                } catch (Exception e) {
//                    FmLogUtil.writeErrLog(e);
//                    throw new ActionNonRecException(nodeAddress, FMEConstant.PARTIAL_SYNC, "Sync Error");
//                }
//
//                oids = new String[]{
//                        // ".1.3.6.1.4.1.17409.2.2.11.2.1.1.1", //1:
//                        // activeAlarmSeqNum
//                        ".1.3.6.1.4.1.17409.2.2.11.2.1.1.2." + id + ".0", // 0:
//                        // activeAlarmCode
//                        ".1.3.6.1.4.1.17409.2.2.11.2.1.1.3." + id + ".0", // 1:
//                        // activeAlarmInstance
//                        ".1.3.6.1.4.1.17409.2.2.11.2.1.1.4." + id + ".0", // 2:
//                        // activeAlarmSeverity
//                        // ".1.3.6.1.4.1.17409.2.2.11.2.1.5.", //5:
//                        // activeAlarmRaisingNumber
//                        ".1.3.6.1.4.1.17409.2.2.11.2.1.1.6." + id + ".0", // 3:
//                        // activeAlarmFirstOccurTime
//                        ".1.3.6.1.4.1.17409.2.2.11.2.1.1.7." + id + ".0", // 4:
//                        // activeAlarmLastOccurTime
//                        ".1.3.6.1.4.1.17409.2.2.11.2.1.1.8." + id + ".0", // 5:
//                        // activeAlarmRepeats
//                        ".1.3.6.1.4.1.17409.2.2.11.2.1.1.9." + id + ".0", // 7:
//                        // activeAlarmAdditionalText
//                };
//                try {
//                    target.setObjectIDList(oids);
//                    // SnmpVar[] vbs = target.snmpGetVariables();
//                    SnmpVar[] vbs = target.snmpGetNextVariables();
//                    if (vbs == null || vbs.length <= 0) {
//                        if (target.getErrorCode() == SnmpErrorMessages.REQ_TIMEDOUT) {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doBBSONU204IK2PartSync: fetch alarm " + id + " time out");
//                        } else {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doBBSONU204IK2PartSync: fetch alarm " + id + " sync error. code: " + target.getErrorCode());
//                        }
//                    } else {
//                        String oidList1 = target.getObjectIDList()[0];
//                        if (oidList1.startsWith(oids[0] + ".")) {
//                            BbsTrapParser bbsTrapParser = new BbsTrapParser();
//                            ParseEntity entity = bbsTrapParser.decodeONU204IK2ActiveAlarm(nodeAddress, id, vbs);
//                            if (entity != null)
//                                result.add(entity);
//                        }
//                    }
//                } catch (Exception e) {
//                    FmLogUtil.writeErrLog(e);
//                    throw new ActionNonRecException(nodeAddress, FMEConstant.PARTIAL_SYNC, "Sync Error");
//                }
//
//            }
//        } catch (Exception e) {
//            FmLogUtil.writeErrLog(e);
//        }
//
//        return result;
//    }
//
//    private Vector doBBS4606NEPartSync(String neName, SnmpTarget target, List idList, long sessionID) {
//        Vector result = new Vector();
//
//        try {
//            String nodeAddress = AlarmUtil.getNodeAddress(neName);
//
//            for (int i = 0; i < idList.size(); i++) {
//                int id = (Integer) idList.get(i);
//                String oids[] = new String[]{ // utsGponAlarmTrapEntry
//                        // ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.1",
//                        // //utsGponAlarmTrapSequenceNumber
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.2." + id, // utsGponAlarmTrapProbableCause
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.3." + id, // utsGponAlarmTrapSpecificProblem
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.4." + id, // utsGponAlarmTrapEntityType
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.5." + id, // utsGponAlarmTrapEntityInstance
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.6." + id, // utsGponAlarmTrapOccurTime
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.7." + id, // utsGponAlarmTrapClass
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.9." + id, // utsGponAlarmTrapSeverity
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.10." + id, // utsGponAlarmTrapCorrelationId
//                        ".1.3.6.1.4.1.41355.1.3.20.1.4.1.2.2.3.1.11." + id, // utsGponAlarmTrapAdditionalText
//                };
//
//                try {
//                    target.setObjectIDList(oids);
//                    // SnmpVar[] vbs = target.snmpGetVariables();
//                    SnmpVar[] vbs = target.snmpGetNextVariables();
//                    if (vbs == null || vbs.length <= 0) {
//                        if (target.getErrorCode() == SnmpErrorMessages.REQ_TIMEDOUT) {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doBBS4606NEPartSync: fetch alarm " + id + " time out");
//                        } else {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doBBS4606NEPartSync: fetch alarm " + id + " sync error. code: " + target.getErrorCode());
//                        }
//                    } else {
//                        String oidList1 = target.getObjectIDList()[0];
//                        if (oidList1.startsWith(oids[0] + ".")) {
//                            BbsTrapParser bbsTrapParser = new BbsTrapParser();
//                            ParseEntity entity = bbsTrapParser.decodeBbs4606PartAlarm(nodeAddress, id, vbs);
//                            if (entity != null)
//                                result.add(entity);
//                        }
//                    }
//                } catch (Exception e) {
//                    FmLogUtil.writeErrLog(e);
//                    throw new ActionNonRecException(nodeAddress, FMEConstant.PARTIAL_SYNC, "Sync Error");
//                }
//            }
//        } catch (Exception e) {
//            FmLogUtil.writeErrLog(e);
//        }
//
//        return result;
//    }
//
//    private Vector doCLT2168NePartSync(String neName, SnmpTarget target, List idList, long sessionID) {
//        Vector result = new Vector();
//        try {
//            String nodeAddress = AlarmUtil.getNodeAddress(neName);
//
//            for (int i = 0; i < idList.size(); i++) {
//                int id = (Integer) idList.get(i);
//                try {
//                    String oids[] = new String[]{ // historyAlarmTable
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.2." + id, // 0:
//                            // historyAlarmCode
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.3." + id, // 1:
//                            // historyAlarmInstance
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.4." + id, // 2:
//                            // historyAlarmSeverity
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.6." + id, // 3:
//                            // historyAlarmFirstOccurTime
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.7." + id, // 4:
//                            // historyAlarmLastOccurTime
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.8." + id, // 5:
//                            // historyAlarmRepeats
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.9." + id, // 6:
//                            // historyAlarmCorrelationId
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.10." + id, // 7:
//                            // historyAlarmAdditionalText
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.11." + id, // 8:
//                            // historyAlarmClearTime
//                    };
//
//                    target.setObjectIDList(oids);
//                    // SnmpVar[] vbs = target.snmpGetVariables();
//                    SnmpVar[] vbs = target.snmpGetNextVariables();
//                    if (vbs == null || vbs.length <= 0) {
//                        if (target.getErrorCode() == SnmpErrorMessages.REQ_TIMEDOUT) {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doCLT2168NePartSync: fetch alarm " + id + " time out");
//                        } else {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doCLT2168NePartSync: fetch alarm " + id + " sync error. code: " + target.getErrorCode());
//                        }
//                    } else {
//                        String oidList1 = target.getObjectIDList()[0];
//                        if (oidList1.startsWith(oids[0] + ".")) {
//                            BbsTrapParser bbsTrapParser = new BbsTrapParser();
//                            ParseEntity entity = bbsTrapParser.decodeCLT2168PartAlarm(nodeAddress, id, vbs);
//                            if (entity != null)
//                                result.add(entity);
//                        }
//                    }
//                } catch (Exception e) {
//                    FmLogUtil.writeErrLog(e);
//                    throw new ActionNonRecException(nodeAddress, FMEConstant.PARTIAL_SYNC, "Sync Error");
//                }
//            }
//        } catch (Exception e) {
//            FmLogUtil.writeErrLog(e);
//        }
//
//        return result;
//    }
//
//    // added by Zhou Chao, 2010/5/13
//    private Vector doBbs4000R4NePartSync(String neName, SnmpTarget target, List idList, long sessionID) {
//        Vector result = new Vector();
//
//        try {
//            String nodeAddress = AlarmUtil.getNodeAddress(neName);
//
//            for (int i = 0; i < idList.size(); i++) {
//                int id = (Integer) idList.get(i);
//                try {
//                    String oids[] = new String[]{ // historyAlarmTable
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.2." + id, // 0:
//                            // historyAlarmCode
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.3." + id, // 1:
//                            // historyAlarmInstance
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.4." + id, // 2:
//                            // historyAlarmSeverity
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.6." + id, // 3:
//                            // historyAlarmFirstOccurTime
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.7." + id, // 4:
//                            // historyAlarmLastOccurTime
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.8." + id, // 5:
//                            // historyAlarmRepeats
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.9." + id, // 6:
//                            // historyAlarmCorrelationId
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.10." + id, // 7:
//                            // historyAlarmAdditionalText
//                            ".1.3.6.1.4.1.17409.2.2.11.2.2.1.11." + id, // 8:
//                            // historyAlarmClearTime
//                    };
//
//                    target.setObjectIDList(oids);
//                    // SnmpVar[] vbs = target.snmpGetVariables();
//                    SnmpVar[] vbs = target.snmpGetNextVariables();
//                    if (vbs == null || vbs.length <= 0) {
//                        if (target.getErrorCode() == SnmpErrorMessages.REQ_TIMEDOUT) {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doBbs4000R4NePartSync: fetch alarm " + id + " time out");
//                        } else {
//                            FmLogUtil.writeErrLog("EponPartSyncAction->doBbs4000R4NePartSync: fetch alarm " + id + " sync error. code: " + target.getErrorCode());
//                        }
//                    } else {
//                        String oidList1 = target.getObjectIDList()[0];
//                        if (oidList1.startsWith(oids[0] + ".")) {
//                            BbsTrapParser bbsTrapParser = new BbsTrapParser();
//                            ParseEntity entity = bbsTrapParser.decodeBbs4000R4PartAlarm(nodeAddress, id, vbs);
//                            if (entity != null)
//                                result.add(entity);
//                        }
//                    }
//                } catch (Exception e) {
//                    FmLogUtil.writeErrLog(e);
//                    throw new ActionNonRecException(nodeAddress, FMEConstant.PARTIAL_SYNC, "Sync Error");
//                }
//            }
//        } catch (Exception e) {
//            FmLogUtil.writeErrLog(e);
//        }
//
//        return result;
//    }

}
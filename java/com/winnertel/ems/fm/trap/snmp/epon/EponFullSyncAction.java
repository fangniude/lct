package com.winnertel.ems.fm.trap.snmp.epon;

import com.winnertel.ems.epon.fm.BBSNeAlarmSync;
import com.winnertel.ems.epon.fm.EponAlarmTrapParser;
import com.winnertel.ems.epon.fm.EponAlarmUtils;
import com.winnertel.ems.epon.fm.trap.bbs.parse.BbsTrapParser;
import com.winnertel.ems.epon.snmp.SnmpTargetExt;
import com.winnertel.ems.fm.common.AlarmUtil;
import com.winnertel.em.broadband.common.alarm.ParseEntity;
import com.winnertel.em.broadband.common.alarmsync.action.AlarmSyncAction;
import com.winnertel.em.broadband.common.alarmsync.config.FMEConstant;
import com.winnertel.em.broadband.common.alarmsync.exception.ActionException;
import com.winnertel.em.broadband.common.alarmsync.exception.ActionNonRecException;
import com.winnertel.em.broadband.common.util.FmLogUtil;
import com.winnertel.ems.fm.FMConstant;
import com.winnertel.ems.fm.alarmdb.Alarm;
import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.DefaultSnmpAPI;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.snmp.snmp2.SnmpVar;

import java.util.Map;
import java.util.Vector;

public class EponFullSyncAction implements AlarmSyncAction {

    private EponAlarmTrapParser alarmParser;

    public EponFullSyncAction() {
        alarmParser = new EponAlarmTrapParser();
    }

    // modified by Zhou Chao, 2010/5/13
    public Vector execute(String nodeName, int syncType, Map para) throws ActionException {
        if (nodeName == null || para == null)
            return null;

        boolean isCommonTrap = true;
        boolean isBbs4000R4Trap = false;
        boolean isCLT2168Trap = false;
        boolean isBBS4606Trap = false;
        boolean isONU204iK2 = false;

        long sessionID = (Long) para.get(FMEConstant.NE_SID);
        SnmpTarget target = BBSNeAlarmSync.getSnmpTargetForGet(nodeName);
        String nodeAddress = AlarmUtil.getNodeAddress(nodeName);
//        Properties prop = ServerUtility.getNePropertiesByIpAddr(nodeAddress);
//        if (prop != null) {
//            String neType = prop.getProperty(NEConstant.NE_TYPE_KEY, "BBS4000");
//            String neVersion = prop.getProperty(NEConstant.NE_VERSION_KEY, "2.1.0");
//            FmLogUtil.writeOutLog("EponFullSyncAction->execute: neType=[" + neType + "], neVersion=[" + neVersion + "]");
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
//                isONU204iK2 = true;
//            } else if (neType.startsWith("CLT2168")) {
//                isCLT2168Trap = true;
//            }
//        }

//        if (isONU204iK2) {
//            return doONU204IK2FullSync(nodeName, target, sessionID);
//        } else if (isBbs4000R4Trap) {
//            return doBbs4000R4NeFullSync(nodeName, target, sessionID);
//        } else if (isCLT2168Trap) {
//            return doCLT2168NeFullSync(nodeName, target, sessionID);
//        } else if (isBBS4606Trap) {
//            return doBBS4606NeFullSync(nodeName, target, sessionID);
//        } else if (isCommonTrap) {
            return doEponNeFullSync(nodeName, target, sessionID);
//        } else {
//            return doG3NeFullSync(nodeName, target, sessionID);
//        }
    }

    private Vector doONU204IK2FullSync(String neName, SnmpTarget target, long sessionID) throws ActionException {
        Vector result = new Vector();

        try {
            FmLogUtil.writeOutLog("EponFullSyncAction->doONU204IK2FullSync: begin");

            SnmpTargetExt snmpTargetExt = new SnmpTargetExt(neName);
            String oids[] = new String[]{
                    // ".1.3.6.1.4.1.17409.2.2.11.2.2.1.1", //1:
                    // historyAlarmSeqNum
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.2", // 0: historyAlarmCode
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.3", // 1:
                    // historyAlarmInstance
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.4", // 2:
                    // historyAlarmSeverity
                    // ".1.3.6.1.4.1.17409.2.2.11.2.2.1.5", //5:
                    // historyAlarmRaisingNumber
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.6", // 3:
                    // historyAlarmFirstOccurTime
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.7", // 4:
                    // historyAlarmLastOccurTime
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.8", // 5:
                    // historyAlarmRepeats
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.9", // 6:
                    // historyAlarmCorrelationId
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.10", // 7:
                    // historyAlarmAdditionalText
                    ".1.3.6.1.4.1.17409.2.2.11.2.2.1.11", // 8:
                    // historyAlarmClearTime
            };
            Object[][] data = snmpTargetExt.getTable(oids);
            String[] indexArray = snmpTargetExt.getMibIndexes();
            if (data != null) {
                BbsTrapParser bbsTrapParser = new BbsTrapParser();
                for (int i = 0; i < data.length; i++) {
                    String[] indexes = indexArray[i].split("\\.");
                    String sSeqno = indexes[0];
                    int iSeqNo = -1;
                    try {
                        iSeqNo = Integer.parseInt(sSeqno);
                    } catch (Exception ex) {
                        FmLogUtil.writeErrLog(ex);
                    }
                    int ii = 1;
                    ParseEntity entity = bbsTrapParser.decodeONU204IK2HistoryAlarm(target.getTargetHost(), iSeqNo, data[i]);
                    if (entity != null)
                        result.add(entity);
                }
            }

            oids = new String[]{
                    // ".1.3.6.1.4.1.17409.2.2.11.2.1.1.1", //1:
                    // activeAlarmSeqNum
                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.2", // 0: activeAlarmCode
                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.3", // 1:
                    // activeAlarmInstance
                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.4", // 2:
                    // activeAlarmSeverity
                    // ".1.3.6.1.4.1.17409.2.2.11.2.1.5.", //5:
                    // activeAlarmRaisingNumber
                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.6", // 3:
                    // activeAlarmFirstOccurTime
                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.7", // 4:
                    // activeAlarmLastOccurTime
                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.8", // 5:
                    // activeAlarmRepeats
                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.9", // 6:
                    // activeAlarmAdditionalText
            };

            data = snmpTargetExt.getTable(oids);
            indexArray = snmpTargetExt.getMibIndexes();
            if (data != null) {
                BbsTrapParser bbsTrapParser = new BbsTrapParser();
                for (int i = 0; i < data.length; i++) {
                    String[] indexes = indexArray[i].split("\\.");
                    String sSeqno = indexes[0];
                    int iSeqNo = -1;
                    try {
                        iSeqNo = Integer.parseInt(sSeqno);
                    } catch (Exception ex) {
                        FmLogUtil.writeErrLog(ex);
                    }
                    ParseEntity entity = bbsTrapParser.decodeONU204IK2ActiveAlarm(target.getTargetHost(), iSeqNo, data[i]);
                    if (entity != null)
                        result.add(entity);
                }
            }

            FmLogUtil.writeOutLog("EponFullSyncAction->doONU204IK2FullSync: end");
        } catch (Exception e) {
            FmLogUtil.writeErrLog(e);
            throw new ActionNonRecException(target.getTargetHost(), FMEConstant.FULL_SYNC, "Sync Error");
        }

        return result;
    }

    private Vector doG3NeFullSync(String neName, SnmpTarget target, long sessionID) throws ActionException {
        Vector result = new Vector();
        String nodeAddress = AlarmUtil.getNodeAddress(neName);

        try {
            FmLogUtil.writeOutLog("EponFullSyncAction->doG3NeFullSync: begin");

            target.setObjectIDList(new String[]{FMConstant.G3_CUR_SEQNO, FMConstant.G3_CUR_PDUID});
            String initIds = FMConstant.G3_CUR_PDUID;

            String curLastOid;

            SnmpVar[] vars = target.snmpGetNextVariables();
            if (vars == null)
                return null;

            for (; vars != null; vars = target.snmpGetNextVariables()) {
                curLastOid = (target.getObjectIDList())[1];
                if (!curLastOid.startsWith(initIds) || curLastOid.equalsIgnoreCase(initIds)) {
                    break;
                }
                SnmpVar varSeq = vars[0];
                String sSeqno = varSeq.toString();
                int iSeqNo = -1;
                try {
                    iSeqNo = Integer.parseInt(sSeqno);
                } catch (Exception ex) {
                    FmLogUtil.writeErrLog(ex);
                }

                if (iSeqNo <= 0)
                    continue;

                SnmpVar temp = vars[1];
                byte[] bytes = temp.toBytes();
                SnmpPDU pdu = BBSNeAlarmSync.generateSnmpPDU(bytes, nodeAddress);
                if (pdu != null) {
                    if (pdu.getVersion() == DefaultSnmpAPI.SNMP_VERSION_2 || pdu.getVersion() == DefaultSnmpAPI.SNMP_VERSION_2C) {
                        pdu = BBSNeAlarmSync.changeToV1(pdu);
                    }
                    if (pdu != null) {
                        Alarm alarm = alarmParser.parseToAlarm(pdu);
                        if (alarm != null) {
                            result.add(EponAlarmUtils.convertEponAlarm(alarm, pdu, sessionID));
                        }
                    }
                } else {
                    FmLogUtil.writeErrLog("EponFullSyncAction->doG3NeFullSync: pdu is null, octet string of original pdu is : " + temp.toString());
                }
            }

            FmLogUtil.writeOutLog("EponFullSyncAction->doG3NeFullSync: end");
        } catch (Exception e) {
            FmLogUtil.writeErrLog(e);
            throw new ActionNonRecException(target.getTargetHost(), FMEConstant.FULL_SYNC, "Sync Error");
        }

        return result;
    }

    // added by Zhou Chao, 2009/8/26
    private Vector doEponNeFullSync(String neName, SnmpTarget target, long sessionID) throws ActionException {
        Vector result = new Vector();

        try {
            FmLogUtil.writeOutLog("EponFullSyncAction->doEponNeFullSync: begin");

            SnmpTargetExt snmpTargetExt = new SnmpTargetExt(neName);
            String oids[] = new String[]{ // utsBbsAlarmActiveTable
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.2", // 0:
                    // utsBbsAlarmActiveProbableCause
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.3", // 1:
                    // utsBbsAlarmActiveSpecificProblem
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.4", // 2:
                    // utsBbsAlarmActiveEntityType
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.5", // 3:
                    // utsBbsAlarmActiveEntityInstance
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.6", // 4:
                    // utsBbsAlarmActiveFirstOccurenceTime
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.7", // 5:
                    // utsBbsAlarmActiveClass
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.8", // 6:
                    // utsBbsAlarmActiveSeverity
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.9", // 7:
                    // utsBbsAlarmActiveAcknowledge
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.10", // 8:
                    // utsBbsAlarmActiveAdditionalText
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.12", // 9:
                    // utsBbsAlarmActiveLastOccurenceTime
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.13", // 10:
                    // utsBbsAlarmActiveRepeats
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.14", // 11:
                    // utsBbsAlarmActiveVersionId
                    ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.1.2.2.1.1.15", // 12:
                    // utsBbsAlarmActiveSessionId
            };
            Object[][] data = snmpTargetExt.getTable(oids);
            String[] indexArray = snmpTargetExt.getMibIndexes();
            if (data != null) {
                BbsTrapParser bbsTrapParser = new BbsTrapParser();
                for (int i = 0; i < data.length; i++) {
                    String[] indexes = indexArray[i].split("\\.");
                    String sSeqno = indexes[0];
                    int iSeqNo = -1;
                    try {
                        iSeqNo = Integer.parseInt(sSeqno);
                    } catch (Exception ex) {
                        FmLogUtil.writeErrLog(ex);
                    }
                    ParseEntity entity = bbsTrapParser.decodeEponAlarm(target.getTargetHost(), iSeqNo, data[i]);
                    if (entity != null)
                        result.add(entity);
                }
            }

            FmLogUtil.writeOutLog("EponFullSyncAction->doEponNeFullSync: end");
        } catch (Exception e) {
            FmLogUtil.writeErrLog(e);
            throw new ActionNonRecException(target.getTargetHost(), FMEConstant.FULL_SYNC, "Sync Error");
        }

        return result;
    }
//
//    private Vector doCLT2168NeFullSync(String neName, SnmpTarget target, long sessionID) throws ActionException {
//        Vector result = new Vector();
//
//        try {
//            FmLogUtil.writeOutLog("EponFullSyncAction->doCLT2168NeFullSync: begin");
//
//            SnmpTargetExt snmpTargetExt = new SnmpTargetExt(neName);
//            String oids[] = new String[]{ // activeAlarmTable
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.2", // 0: activeAlarmCode
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.3", // 1:
//                    // activeAlarmInstance
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.4", // 2:
//                    // activeAlarmSeverity
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.6", // 3:
//                    // activeAlarmFirstOccurTime
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.7", // 4:
//                    // activeAlarmLastOccurTime
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.8", // 5:
//                    // activeAlarmRepeats
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.9", // 6:
//                    // activeAlarmConfirm
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.10", // 7:
//                    // activeAlarmAdditionalText
//            };
//            Object[][] data = snmpTargetExt.getTable(oids);
//            String[] indexArray = snmpTargetExt.getMibIndexes();
//            if (data != null) {
//                BbsTrapParser bbsTrapParser = new BbsTrapParser();
//                for (int i = 0; i < data.length; i++) {
//                    String[] indexes = indexArray[i].split("\\.");
//                    String sSeqno = indexes[0];
//                    int iSeqNo = -1;
//                    try {
//                        iSeqNo = Integer.parseInt(sSeqno);
//                    } catch (Exception ex) {
//                        FmLogUtil.writeErrLog(ex);
//                    }
//                    ParseEntity entity = bbsTrapParser.decodeCLT2168Alarm(target.getTargetHost(), iSeqNo, data[i]);
//                    if (entity != null)
//                        result.add(entity);
//                }
//            }
//
//            FmLogUtil.writeOutLog("EponFullSyncAction->doCLT2168NeFullSync: end");
//        } catch (Exception e) {
//            FmLogUtil.writeErrLog(e);
//            throw new ActionNonRecException(target.getTargetHost(), FMEConstant.FULL_SYNC, "Sync Error");
//        }
//
//        return result;
//    }
//
//    // added by Zhou Chao, 2010/5/13
//    private Vector doBbs4000R4NeFullSync(String neName, SnmpTarget target, long sessionID) throws ActionException {
//        Vector result = new Vector();
//
//        try {
//            FmLogUtil.writeOutLog("EponFullSyncAction->doBbs4000R4NeFullSync: begin");
//
//            SnmpTargetExt snmpTargetExt = new SnmpTargetExt(neName);
//            String oids[] = new String[]{ // activeAlarmTable
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.2", // 0: activeAlarmCode
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.3", // 1:
//                    // activeAlarmInstance
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.4", // 2:
//                    // activeAlarmSeverity
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.5", // 3:
//                    // activeAlarmRaisingNumber
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.6", // 4:
//                    // activeAlarmFirstOccurTime
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.7", // 5:
//                    // activeAlarmLastOccurTime
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.8", // 6:
//                    // activeAlarmRepeats
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.9", // 7:
//                    // activeAlarmConfirm
//                    ".1.3.6.1.4.1.17409.2.2.11.2.1.1.10", // 8:
//                    // activeAlarmAdditionalText
//            };
//            Object[][] data = snmpTargetExt.getTable(oids);
//            String[] indexArray = snmpTargetExt.getMibIndexes();
//            if (data != null) {
//                BbsTrapParser bbsTrapParser = new BbsTrapParser();
//                for (int i = 0; i < data.length; i++) {
//                    String[] indexes = indexArray[i].split("\\.");
//                    String sSeqno = indexes[0];
//                    int iSeqNo = -1;
//                    try {
//                        iSeqNo = Integer.parseInt(sSeqno);
//                    } catch (Exception ex) {
//                        FmLogUtil.writeErrLog(ex);
//                    }
//                    ParseEntity entity = bbsTrapParser.decodeBbs4000R4Alarm(target.getTargetHost(), iSeqNo, data[i]);
//                    if (entity != null)
//                        result.add(entity);
//                }
//            }
//
//            FmLogUtil.writeOutLog("EponFullSyncAction->doBbs4000R4NeFullSync: end");
//        } catch (Exception e) {
//            FmLogUtil.writeErrLog(e);
//            throw new ActionNonRecException(target.getTargetHost(), FMEConstant.FULL_SYNC, "Sync Error");
//        }
//
//        return result;
//    }
//
//    /**
//     * add by Tsinyun(hz08282)
//     * do BBS4606 NE Full Synchronize.
//     *
//     * @param neName    the NE Name
//     * @param target
//     * @param sessionID
//     * @return
//     */
//    private Vector doBBS4606NeFullSync(String neName, SnmpTarget target, long sessionID) throws ActionException {
//        Vector result = new Vector();
//
//        try {
//            FmLogUtil.writeOutLog("EponFullSyncAction->doBBS4606NeFullSync: begin");
//
//            SnmpTargetExt snmpTargetExt = new SnmpTargetExt(neName);
//            String oids[] = new String[]{ // activeAlarmTable
//
//                    // ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.1",
//                    // //utsGponAlarmActiveSequenceNumber
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.2", // utsGponAlarmActiveSequenceId
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.3", // utsGponAlarmActiveProbableCause
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.4", // utsGponAlarmActiveSpecificProblem
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.5", // utsGponAlarmActiveEntityType
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.6", // utsGponAlarmActiveEntityInstance
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.7", // utsGponAlarmActiveOccurTime
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.9", // utsGponAlarmActiveSeverity
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.10", // utsGponAlarmActiveAcknowledge
//                    ".1.3.6.1.4.1.45121.1.3.20.1.4.1.2.2.1.1.11", // utsGponAlarmActiveAdditionalText
//            };
//            Object[][] data = snmpTargetExt.getTable(oids);
//            String[] indexArray = snmpTargetExt.getMibIndexes();
//            if (data != null) {
//                BbsTrapParser bbsTrapParser = new BbsTrapParser();
//                for (int i = 0; i < data.length; i++) {
//                    String[] indexes = indexArray[i].split("\\.");
//                    String sSeqno = indexes[0];
//                    int iSeqNo = -1;
//                    try {
//                        iSeqNo = Integer.parseInt(sSeqno);
//                    } catch (Exception ex) {
//                        FmLogUtil.writeErrLog(ex);
//                    }
//                    ParseEntity entity = bbsTrapParser.decodeBBS4606Alarm(target.getTargetHost(), iSeqNo, data[i]);
//                    if (entity != null)
//                        result.add(entity);
//                }
//            }
//
//            FmLogUtil.writeOutLog("EponFullSyncAction->doBBS4606NeFullSync: end");
//        } catch (Exception e) {
//            FmLogUtil.writeErrLog(e);
//            throw new ActionNonRecException(target.getTargetHost(), FMEConstant.FULL_SYNC, "Sync Error");
//        }
//
//        return result;
//    }

}
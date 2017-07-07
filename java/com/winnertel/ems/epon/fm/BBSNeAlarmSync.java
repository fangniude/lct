/**
 * Modified by Zhouchao
 */

package com.winnertel.ems.epon.fm;

import com.winnertel.ems.epon.fm.trap.bbs.parse.BbsTrapParser;
import com.winnertel.ems.epon.snmp.SnmpTargetExt;
import com.winnertel.em.broadband.common.util.FmLogUtil;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.ems.epon.topo.impl.PropertyConstant;
import com.winnertel.ems.fm.FMConstant;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.DefaultSnmpAPI;
import com.winnertel.snmp.snmp2.SnmpMessage;
import com.winnertel.snmp.snmp2.SnmpOID;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.snmp.snmp2.SnmpVarBind;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class BBSNeAlarmSync {

//    private static EponLogger log = LoggerUtility.getLogger(BBSNeAlarmSync.class.getName());

    // public static boolean CLEAR_BEFORE_SYNC = true;

    // active alarm table fields, seqNo, pdu
    // public static final String[] g3TableId = { FMConstant.G3_CUR_SEQNO,
    // FMConstant.G3_CUR_PDUID };

    public static boolean doSync(String neName) {
        /*
         * Fault2TopoInf inf = (Fault2TopoInf) FMUtil.getFault2TopoInf();
         * if (inf == null) {
         * log.error("Can't sync the alarm in NE[" + neId +
         * "]: Fault2TopoInf is null.");
         * return false;
         * }
         * 
         * SnmpTarget target = inf.getSnmpTargetForGet(neId);
         */

        SnmpTarget target = getSnmpTargetForGet(neName);

        boolean succ;

        if (SnmpUtility.snmpPing(target.getTargetHost(), target.getTargetPort(), target.getCommunity())) {
            boolean isCommonTrap = true;

//            String nodeAddress = AlarmUtil.getNodeAddress(neName);
//            Properties prop = ServerUtility.getNePropertiesByIpAddr(nodeAddress);
//            if (prop != null) {
//                String neType = prop.getProperty(NEConstant.NE_TYPE_KEY, "FBW5000");
//                String neVersion = prop.getProperty(NEConstant.NE_VERSION_KEY, "2.1.0");
//                if (neType != null && neVersion != null) {
//                    if (neType.startsWith("FBW5000")) {
//                        if (neVersion.startsWith("4.0."))
//                            isBbs4000R4Trap = true;
//                        else
//                            isCommonTrap = Version.greatOrEqual(neVersion, "2.1.6");
//                    } else if (neType.startsWith("FBW3000")) {
//                        isCommonTrap = Version.greatOrEqual(neVersion, "3.4.0");
//                    } else if (neType.startsWith("BBS4606")) {
//                        isBBS4606Trap = true;
//                    } else if (neType.startsWith("ONU204i-k2")) {
//                        isONU204iK2 = true;
//                    }
//                }
//            }

            /*
             * if (isCommonTrap) {
             * succ = doEponNeSync(neName, target);
             * } else {
             * succ = doG3NeSync(neName, target);
             * }
             */

//            if (isONU204iK2) {
//                succ = doONU204IK2FullSync(neName, target);
//            } else if (isBbs4000R4Trap) {
//                succ = doBbs4000R4NeFullSync(neName, target);
//            } else if (isBBS4606Trap) {
//                succ = doBBS4606NeFullSync(neName, target);
//            } else if (isCommonTrap) {
                succ = doEponNeFullSync(neName, target);
//            } else {
//                succ = doG3NeFullSync(neName, target);
//            }
        } else {
//            log.info("Don't invoke the Alarm Sychronization, because the NE is inactive: " + target.getTargetHost());
            return false;
        }

        return succ;
    }

    private static boolean doONU204IK2FullSync(String neName, SnmpTarget target) {
        try {
//            FmLogUtil.writeOutLog("BBSNeAlarmSync.doONU204IK2FullSync --- begin");

            SnmpTargetExt snmpTargetExt = new SnmpTargetExt(neName);
            String oids[] = new String[] {
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
                    bbsTrapParser.decodeONU204IK2HistoryAlarm(target.getTargetHost(), iSeqNo, data[i]);
                }
            }

            oids = new String[] {
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
                    bbsTrapParser.decodeONU204IK2ActiveAlarm(target.getTargetHost(), iSeqNo, data[i]);
                }
            }

            FmLogUtil.writeOutLog("BBSNeAlarmSync.doONU204IK2FullSync --- end");
        } catch (Exception e) {
            FmLogUtil.writeErrLog(e);
            return false;
        }

        return true;
    }

//    private static boolean doG3NeFullSync(String neName, SnmpTarget target) {
//        Vector retrievePDUs = new Vector();
//        String nodeAddress = AlarmUtil.getNodeAddress(neName);
//
//        try {
//            FmLogUtil.writeOutLog("BBSNeAlarmSync.doG3NeFullSync --- begin");
//
//            target.setObjectIDList(new String[] { FMConstant.G3_CUR_SEQNO, FMConstant.G3_CUR_PDUID });
//            String initIds = FMConstant.G3_CUR_PDUID;
//            String curLastOid;
//
//            SnmpVar[] vars = target.snmpGetNextVariables();
//            if (vars == null)
//                return false;
//
//            for (; vars != null; vars = target.snmpGetNextVariables()) {
//                curLastOid = (target.getObjectIDList())[1];
//                if (!curLastOid.startsWith(initIds) || curLastOid.equalsIgnoreCase(initIds)) {
//                    break;
//                }
//                SnmpVar varSeq = vars[0];
//                String sSeqno = varSeq.toString();
//                int iSeqNo = -1;
//                try {
//                    iSeqNo = Integer.parseInt(sSeqno);
//                } catch (Exception ex) {
//                    FmLogUtil.writeErrLog(ex);
//                }
//
//                if (iSeqNo <= 0)
//                    continue;
//
//                SnmpVar temp = vars[1];
//                byte[] bytes = temp.toBytes();
//                SnmpPDU pdu = BBSNeAlarmSync.generateSnmpPDU(bytes, nodeAddress);
//                if (pdu != null) {
//                    if (pdu.getVersion() == DefaultSnmpAPI.SNMP_VERSION_2 || pdu.getVersion() == DefaultSnmpAPI.SNMP_VERSION_2C) {
//                        pdu = BBSNeAlarmSync.changeToV1(pdu);
//                    }
//                    if (pdu != null)
//                        retrievePDUs.addElement(pdu);
//                } else {
//                    FmLogUtil.writeErrLog("pdu is null, octet string of original pdu is : " + temp.toString());
//                }
//            }
//
//            for (int i = 0; i < retrievePDUs.size(); i++) {
//                SnmpPDU pdu = (SnmpPDU) retrievePDUs.elementAt(i);
////                log.debug(pdu.getMsg().getClass());
//                Vector variables = pdu.getVariableBindings();
//                for (int j = 0; j < variables.size(); j++) {
//                    String keys = pdu.getObjectID(j).toString();
//                    String value = pdu.getVariable(j).toString();
////                    log.debug("PDU VarBind: " + keys + "=" + value);
//                }
//
//                EponTrapProcess.getInstance().process(pdu);
//            }
//
//            FmLogUtil.writeOutLog("BBSNeAlarmSync.doG3NeFullSync --- end");
//        } catch (Exception e) {
//            FmLogUtil.writeErrLog(e);
//        }
//
//        return true;
//    }

    private static boolean doEponNeFullSync(String neName, SnmpTarget target) {
        try {
            FmLogUtil.writeOutLog("BBSNeAlarmSync.doEponNeFullSync --- begin");

            SnmpTargetExt snmpTargetExt = new SnmpTargetExt(neName);
            String oids[] = new String[] { // utsBbsAlarmActiveTable
            ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.2", // 0:
                                                              // utsBbsAlarmActiveProbableCause
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.3", // 1:
                                                                      // utsBbsAlarmActiveSpecificProblem
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.4", // 2:
                                                                      // utsBbsAlarmActiveEntityType
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.5", // 3:
                                                                      // utsBbsAlarmActiveEntityInstance
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.6", // 4:
                                                                      // utsBbsAlarmActiveFirstOccurenceTime
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.7", // 5:
                                                                      // utsBbsAlarmActiveClass
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.8", // 6:
                                                                      // utsBbsAlarmActiveSeverity
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.9", // 7:
                                                                      // utsBbsAlarmActiveAcknowledge
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.10", // 8:
                                                                       // utsBbsAlarmActiveAdditionalText
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.12", // 9:
                                                                       // utsBbsAlarmActiveLastOccurenceTime
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.13", // 10:
                                                                       // utsBbsAlarmActiveRepeats
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.14", // 11:
                                                                       // utsBbsAlarmActiveVersionId
                    ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.15", // 12:
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
                    bbsTrapParser.decodeEponAlarm(target.getTargetHost(), iSeqNo, data[i]);
                }
            }

            FmLogUtil.writeOutLog("BBSNeAlarmSync.doEponNeFullSync --- end");
        } catch (Exception e) {
            FmLogUtil.writeErrLog(e);
            return false;
        }

        return true;
    }


    public static SnmpPDU generateSnmpPDU(byte bytes[], String remoteHost) {
        SnmpPDU snmppdu = null;
        try {
            SnmpMessage snmpmessage = new SnmpMessage(bytes);
            snmppdu = snmpmessage.getPDU();
            snmppdu.decode();
            snmppdu.setAgentAddr("localhost");
            snmppdu.setRemoteHost(remoteHost);
            snmppdu.setRemotePort(162);
        } catch (Exception exception) {
//            log.error(null, exception);
            exception.printStackTrace();
        }

        return snmppdu;
    }

    public static SnmpTarget getSnmpTargetForGet(String neName) {
        Properties neProperty = null;
        try {
            neProperty = UTopoAPI.getAPI().getPropertiesOfObject(neName);
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
//        Properties neProperty = ServerUtility.getNePropertiesByNeName(neName);
        SnmpTarget target = new SnmpTarget();
        target.setTargetHost(neProperty.getProperty(PropertyConstant.NE_IP_ADDRESS));

        String getCommunity = neProperty.getProperty(PropertyConstant.NE_GET_COMMUNITY, "public");
        target.setCommunity(getCommunity);
        int defaultPort = 161;
        try {
            String sPort = neProperty.getProperty(PropertyConstant.NE_SNMP_PORT, "161");
            defaultPort = Integer.parseInt(sPort);
        } catch (Exception e) {
        }
        target.setTargetPort(defaultPort);
        /*
         * int defaultVersion = SnmpTarget.VERSION2C;
         * try {
         * String sVersion = neProperty.getProperty("SNMPVERSION", "v2c");
         * if (sVersion.equals("v2c"))
         * defaultVersion = SnmpTarget.VERSION2C;
         * else if (sVersion.equals("v1"))
         * defaultVersion = SnmpTarget.VERSION1;
         * } catch (Exception e) {
         * }
         * target.setSnmpVersion(defaultVersion);
         */

        return target;
    }

    public static SnmpPDU changeToV1(SnmpPDU pdu) {
        // SnmpVarBind uptime = pdu.getVariableBinding(0);
        SnmpVarBind trapoid = pdu.getVariableBinding(1);
        // SnmpVarBind agent = pdu.getVariableBinding(2);

        String temp = trapoid.getVariable().toString();
        String sIszero = temp.substring(temp.lastIndexOf(".") + 1, temp.length());

        String sTrapOid;
        if (sIszero.equals("0"))
            sTrapOid = temp.substring(0, temp.lastIndexOf("."));
        else
            sTrapOid = temp;

        String enterprise = sTrapOid.substring(0, sTrapOid.lastIndexOf("."));
        String specifictype = sTrapOid.substring(sTrapOid.lastIndexOf(".") + 1, sTrapOid.length());
        // set enterprise and specifictype of PDU
        pdu.setEnterprise(new SnmpOID(enterprise));
        pdu.setSpecificType(Integer.parseInt(specifictype));
        // String agentAddress = agent.getVariable().toString();
        // set remote host as the default agent address of Snmp V1 pdu
        String agentAddress = pdu.getRemoteHost();
        if (agentAddress != null && !agentAddress.equals("")) {
            try {
                InetAddress address = InetAddress.getByName(agentAddress);
                pdu.setAgentAddress(address);
            } catch (UnknownHostException e) {
                pdu.setAgentAddress(pdu.getAddress());
            }
        } else {
            pdu.setAgentAddress(pdu.getAddress());
        }

        pdu.removeVariableBinding(0);
        pdu.removeVariableBinding(0);
        // pdu.removeVariableBinding(0);
        // for mSwitch alarm, agante add agaent address field
        if (pdu.getObjectID(0).toString().trim().equalsIgnoreCase(FMConstant.AGENT_ADDRESS)) {
            pdu.removeVariableBinding(0);
        }

        // set other V1 specific feather of PDU
        pdu.setTrapType(6);
        pdu.setCommand(DefaultSnmpAPI.TRP_REQ_MSG);
        pdu.setVersion(DefaultSnmpAPI.SNMP_VERSION_1);

        return pdu;
    }

}
/**
 * Modified by Zhou Chao, 2009/7/20
 */

package com.winnertel.ems.epon.fm;

import com.winnertel.ems.epon.eventserver.EponEventListener;
import com.winnertel.ems.epon.fm.trap.bbs.parse.BbsTrapParser;
import com.winnertel.ems.epon.fm.trap.bbs.parse.EponAlarmBean;
import com.winnertel.ems.epon.fm.trap.bbs.parse.EponEventBean;
import com.winnertel.ems.epon.global.ServerResourceManager;
import com.winnertel.em.broadband.common.alarm.ParseEntity;
import com.winnertel.em.broadband.common.alarm.parser.ParserInf;
import com.winnertel.em.broadband.common.alarm.util.TrapData;
import com.winnertel.ems.fm.alarmdb.Alarm;
import com.winnertel.ems.fm.eventdb.Event;
import com.winnertel.nms.alertdb.UEventAPI;
import com.winnertel.snmp.snmp2.SnmpPDU;

import java.util.ArrayList;
import java.util.List;

//import com.utstar.ems.epon.eventserver.EponEventListener;
//import com.utstar.ems.epon.log.EponLogger;
//import com.winnertel.ems.epon.util.LoggerUtility;

public class EponTrapParser implements ParserInf {

//    private static EponLogger log = LoggerUtility.getLogger(EponTrapParser.class.getName());
    private EponAlarmTrapParser alarmParser;
    private EponEventTrapParser eventParser;
    private EponEventListener eventListener;

    private BbsTrapParser bbsTrapParser;

    private static List<TrapParser> parserList = new ArrayList();

    public static synchronized void addParser(TrapParser parser) {
        if (!parserList.contains(parser)) {
            parserList.add(parser);
        }
    }

    public static synchronized void removeParser(TrapParser parser) {
        parserList.remove(parser);
    }

    public EponTrapParser() {
//        log.info("Init EponTrapParser.");

        init();
    }

    public void init() {
        alarmParser = new EponAlarmTrapParser();
        eventParser = new EponEventTrapParser();
        eventListener = new EponEventListener();

        bbsTrapParser = new BbsTrapParser();
    }

    public Object processTrap(Object trapPDU, TrapData trapdata) {
        SnmpPDU pdu = (SnmpPDU) trapPDU;
        ParseEntity entity = parseAlarm(pdu.copy());
        if (entity == null) {
            entity = parseEvent(pdu.copy());
        }
        eventListener.parse(pdu.copy());
        synchronized (parserList) {
            for (TrapParser parser : parserList) {
                parser.parse(pdu.copy());
            }
        }

        return entity;
    }

    private ParseEntity parseAlarm(SnmpPDU pdu) {
        boolean isCommonTrap = false;
        boolean isBbs4000R4Trap = false;
        boolean isEocTrap = false;
        boolean isBBS4606Trap = false;
        boolean isONU204iK2 = false;
        boolean isJSxB_v = false; // JS16B-v JS24B-v

        for (int i = 0; i < pdu.getVariableBindings().size(); i++) {
            String oid = pdu.getObjectID(i).toString();
            if (oid.indexOf("1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2") != -1) {
                isCommonTrap = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.2.2.11.1.2") != -1) {
                isBbs4000R4Trap = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.2.2.3.1") != -1) {
                isEocTrap = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.1.3.20.1.4.2") != -1) {
                isBBS4606Trap = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.2.2.1.1") != -1) {
                isONU204iK2 = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.13367.1.1.7") != -1 || oid.indexOf("1.3.6.1.2.1.2.2.1") != -1) {
                isJSxB_v = true;
                break;
            }
        }

        if (isCommonTrap) {
            try {
                ParseEntity parseEntity = new EponAlarmBean(pdu).parse();

                String community = pdu.getCommunity();
                // if the alarm is sent by ONU, add it to DB directly.
                if (community.indexOf("#OLTchassis:") != -1) {
                    parseEntity.setSeqNO(-1); // to avoid the alarm
                                              // sychronization.
                    Alarm alarm = EponAlarmUtils.convertEponParseEntity(parseEntity);

                    int index[] = formatOnuIndex(community);
                    String prefix = new StringBuffer().append(index[0]).append("-").append(index[1]).append("-").append(index[2]).toString();
                    String instance = alarm.getEntityInstance();
                    if (ServerResourceManager.getString("ONU Node").equalsIgnoreCase(instance)) {
                        alarm.setEntityInstance(prefix);
                    } else {
                        alarm.setEntityInstance(prefix + ":" + instance);
                    }

                    UEventAPI.addAlarm(alarm);
                    return null;
                }

                return parseEntity;
            } catch (Exception e) {
                return null;
            }
        }

//        if (isBbs4000R4Trap) {
//            try {
//                ParseEntity parseEntity = bbsTrapParser.decodeBbs4000R4Alarm(pdu);
//
//                return parseEntity;
//            } catch (Exception e) {
//                return null;
//            }
//        }


        Alarm alarm = alarmParser.parseToAlarm(pdu);
        if (alarm != null) {
            return EponAlarmUtils.convertEponAlarm(alarm, pdu, -1);
        } else {
            return null;
        }
    }

    private ParseEntity parseEvent(SnmpPDU pdu) {
        boolean isCommonTrap = false;
        boolean isBbs4000R4Trap = false;
        boolean isEocTrap = false;
        boolean isBBS4606Trap = false;
        boolean isONU204iK2 = false;
        boolean isJSXB_v = false; // JS16B-v JS24B-v
        boolean isCLT2168Trap = false;

        for (int i = 0; i < pdu.getVariableBindings().size(); i++) {
            String oid = pdu.getObjectID(i).toString();
            if (oid.indexOf("1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2") != -1) {
                isCommonTrap = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.2.2.11.1.2") != -1) {
                isBbs4000R4Trap = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.2.2.3.1") != -1) {
                isEocTrap = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.1.3.20.1.4.2") != -1) {
                isBBS4606Trap = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.2.2.1.1") != -1) {
                isONU204iK2 = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.13367.1.1.7") != -1 || oid.indexOf("1.3.6.1.6.3.1.1.5") != -1) {
                isJSXB_v = true;
                break;
            }
            if (oid.indexOf("1.3.6.1.4.1.41355.2.2.11.2.3.1") != -1) {
                isCLT2168Trap = true;
                break;
            }
        }

        if (isCommonTrap) {
            try {
                return new EponEventBean(pdu).parse();
            } catch (Exception e) {
                return null;
            }
        }

//        if (isBbs4000R4Trap) {
//            try {
//                ParseEntity parseEntity = bbsTrapParser.decodeBbs4000R4Event(pdu);
//
//                return parseEntity;
//            } catch (Exception e) {
//                return null;
//            }
//        }

        if (isCLT2168Trap) {
            try {
                ParseEntity parseEntity = bbsTrapParser.decodeCLT2168Event(pdu);
                return parseEntity;
            } catch (Exception e) {
                return null;
            }
        }

//        if (isEocTrap) {
//            try {
//                ParseEntity parseEntity = bbsTrapParser.decodeEocEvent(pdu);
//
//                return parseEntity;
//            } catch (Exception e) {
//                return null;
//            }
//        }

//        if (isBBS4606Trap) {
//            try {
//                ParseEntity parseEntity = bbsTrapParser.decodeBBS4606Event(pdu);
//                return parseEntity;
//            } catch (Exception e) {
//                return null;
//            }
//        }
//
//        if (isONU204iK2) {
//            try {
//                ParseEntity parseEntity = bbsTrapParser.decodeONU204IK2Event(pdu);
//                return parseEntity;
//            } catch (Exception e) {
//                return null;
//            }
//        }
//
//        if (isJSXB_v) {
//            try {
//                ParseEntity parseEntity = bbsTrapParser.decodeJSXB_vEvent(pdu);
//                return parseEntity;
//            } catch (Exception e) {
//                return null;
//            }
//        }

        Event event = eventParser.parseToEvent(pdu);
        if (event != null) {
            return EponAlarmUtils.convertEponEvent(event, pdu);
        } else {
            return null;
        }
    }

    int[] formatOnuIndex(String community) {
        int[] result = new int[3];

        int index = community.indexOf("#ONU:");
        result[2] = Integer.parseInt(community.substring(index + 5));

        community = community.substring(0, index);
        index = community.indexOf("#OLTport:");
        result[1] = Integer.parseInt(community.substring(index + 9));

        community = community.substring(0, index);
        index = community.indexOf("#OLTmodule:");
        result[0] = Integer.parseInt(community.substring(index + 11));

        return result;
    }

}
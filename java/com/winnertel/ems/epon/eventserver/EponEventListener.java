package com.winnertel.ems.epon.eventserver;

import com.winnertel.common.notification.UNotificationEvent;
import com.winnertel.common.notification.UNotificationServerImpl;
import com.winnertel.common.notification.UNotificationTypeDef;
import com.winnertel.common.topo.model.NEStatus;
import com.winnertel.em.broadband.common.inventory.DNUtils;
import com.winnertel.ems.epon.fm.TrapParser;
import com.winnertel.ems.epon.fm.trap.bbs.parse.EponTrapParserHelper;
import com.winnertel.ems.fm.common.AlarmUtil;
import com.winnertel.ems.fm.common.ConstantVar;
import com.winnertel.nms.lite.momodel.ManagedElement;
import com.winnertel.nms.topodb.ULManagedObject;
import com.winnertel.snmp.snmp2.SnmpOID;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.snmp.snmp2.SnmpVar;

import java.util.StringTokenizer;

public class EponEventListener implements TrapParser {

//    static EponLogger log = LoggerUtility.getLogger(EponEventListener.class.getName());

    public EponEventListener() {
//        log.info("Init EponEventListener.");
    }

    public void parse(SnmpPDU pdu) {
        if (pdu == null)
            return;

        boolean isCommonTrap = true;
        if (isCommonTrap) {
            try {
                String action = "";
                String instance = "";
                int severity = 0;
                int raiseFlag = 0; //0: raise; else: clear
                int pc = 0, sp = 0;
                int eventType = 0;
                String additionalInfo = "";
                int entityType = 0;
                int activeEntity = 0;

                int vbs = pdu.getVariableBindings().size();
                for (int i = 0; i < vbs; i++) {
                    SnmpOID oid = pdu.getObjectID(i);
                    SnmpVar value = pdu.getVariable(i);

                    String utsBbsAlarmSeverity = ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.2.2.7";
                    if (oid.toString().equals(utsBbsAlarmSeverity)) {
                        severity = Integer.parseInt(value.toString());
                    }

                    String utsBbsAlarmEntityType = ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.2.2.5";
                    String utsBbsAlarmEntityInstance = ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.2.2.6";
                    if (oid.toString().equals(utsBbsAlarmEntityType)) {
                        entityType = Integer.parseInt(value.toString());
                    }
                    if (oid.toString().equals(utsBbsAlarmEntityInstance)) {
                        activeEntity = Integer.parseInt(value.toValue().toString());
                    }

                    String utsBbsAlarmAdditionalText = ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.2.2.13";
                    if (oid.toString().equals(utsBbsAlarmAdditionalText)) {
                        additionalInfo = value.toString().trim();
                    }

                    if (vbs >= 13) { //alarm
                        String utsBbsAlarmProbableCause = ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.2.2.8";
                        String utsBbsAlarmSpecificProblem = ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.2.2.9";
                        if (oid.toString().equals(utsBbsAlarmProbableCause)) {
                            pc = Integer.parseInt(value.toString());
                        }
                        if (oid.toString().equals(utsBbsAlarmSpecificProblem)) {
                            sp = Integer.parseInt(value.toString());
                        }

                        String utsBbsAlarmCorrelationId = ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.2.2.11";
                        if (oid.toString().equals(utsBbsAlarmCorrelationId)) {
                            raiseFlag = Integer.parseInt(value.toString());
                        }
                    } else if (vbs == 9 || vbs == 10) { //event, 9 for 3.1, 10 for 2.2
                        String utsBbsEventType = ".1.3.6.1.4.1.45121.1.3.10.200.6.7.1.2.2.14";
                        if (oid.toString().equals(utsBbsEventType)) {
                            eventType = Integer.parseInt(value.toString());
                        }
                    }
                }

                String moName = AlarmUtil.getTopAPI().getNodeNameByIP(pdu.getRemoteAddress()); //String moName = UTTopoAPI.getAPI().getNodeNameByIP(pdu.getRemoteAddress());
                ULManagedObject moInstance = AlarmUtil.getTopAPI().getByName(moName); //ULManagedObject moInstance = UTTopoAPI.getAPI().getByName(moName);
                String moType = moInstance.getType();
                instance = EponTrapParserHelper.getEntityInstanceByNodeVersion(entityType, activeEntity, "", moType);

                //if (pc == 236 && sp == 4 && (severity == ConstantVar.CLEAR || raiseFlag != 0)) {
//                    action = "utsEponOnuLinkUp";

//                } else if (pc == 236 && sp == 4 && (severity != ConstantVar.CLEAR || raiseFlag == 0)) {
//                    action = "utsEponOnuLinkDown";

//                } else if (pc == 236 && (sp == 3 || sp == 2 || sp == 12) && (severity == com.utstarcom.ems.fm.common.ConstantVar.CLEAR || raiseFlag != 0)) {
                //} else
                if (pc == 236 && (sp == 3 || sp == 2) && (severity == ConstantVar.CLEAR || raiseFlag != 0)) {
                    action = "utsEponOltLinkUp";

//                } else if (pc == 236 && (sp == 3 || sp == 2 || sp == 12) && (severity != com.utstarcom.ems.fm.common.ConstantVar.CLEAR || raiseFlag == 0)) {
                } else if (pc == 236 && (sp == 3 || sp == 2) && (severity != ConstantVar.CLEAR || raiseFlag == 0)) {
                    action = "utsEponOltLinkDown";

                } else if( pc == 236 && sp == 4 ) {
                    if( raiseFlag != 0 ) {
                        action="powerup";
                    } else {
                        action="poweroff";
                    }

                } else if (pc == 236 && sp == 12 && raiseFlag == 0) {
//                    action = "utsEponOnuOam802Dot3DyingGasp";

                } else if (pc == 307 && sp == 14 && (severity == ConstantVar.CLEAR || raiseFlag != 0)) {
                    action = "utsEponOnuInvalidRegisterClear";

                } else if (pc == 307 && sp == 14 && (severity != ConstantVar.CLEAR || raiseFlag == 0)) {
                    action = "utsEponOnuInvalidRegister";

                } else if (eventType == 3) {
                    action = "utsEponOnuRegisterEvent";
                    //additionalInfo is onu mac

                } else if (eventType == 4) {
                    action = "utsEponOnuDeregisterEvent";
                    //additionalInfo is onu mac

                } else if (eventType == 18) {
                    action = "newCbatRecognized";

                } else if (eventType == 19) {
                    action = "existedCbatUpdate";

                } else if (eventType == 20) {
                    action = "existedCbatRemoved";

                } else if (eventType == 13) {
                    action = "utsEponOltPonProtectionEvent";
                }

                if("powerup".equalsIgnoreCase(action) || "poweroff".equalsIgnoreCase(action) ) {
                    notifyONUUp(moInstance, instance, "powerup".equalsIgnoreCase(action));
                }



            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }

    private void notifyONUUp(ULManagedObject moInstance, String instance, boolean isUp) {
        try {

            String slot = null,port = null,onu = null;
            try {
                StringTokenizer st = new StringTokenizer(instance,"-");
                slot = st.nextToken();
                port = st.nextToken();
                onu = st.nextToken();
            } catch ( Exception ex ) {
                ex.printStackTrace();
            }

            if( slot == null || port == null || onu == null ) {
                return;
            }
            UNotificationEvent event = new UNotificationEvent();
            event.setEventType(UNotificationTypeDef.TOPO_STATUSCHANGE);
            event.setOpType( isUp ? 1 : 0 );
            NEStatus neStatus = new NEStatus();
            neStatus.setName(DNUtils.composeDN(moInstance.getName(),"1", slot, slot ,port ,onu));
            neStatus.setUsageState(isUp ? ManagedElement.USAGE_REACHABLE : ManagedElement.USAGE_UNREACHABLE );
            neStatus.setOperationState(ManagedElement.OPSTATE_MANAGED);
            event.setObj(neStatus);
            UNotificationServerImpl.getInstance().addNotification(event);
        } catch (Exception e) {
            e.printStackTrace( System.err );
        }

    }


    private boolean match(String oid) {
        if (oid == null || oid.trim().length() <= 0)
            return false;

        if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.11")) { //utsEponModuleInsert
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.12")) { //utsEponModuleRemove
            return true;
        //} else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.101")) { //utsEponSFPLinkUp
        //    return true;
        //} else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.102")) { //utsEponSFPLinkDown
        //    return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.201")) { //utsEponOltLinkUp
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.202")) { //utsEponOltLinkDown
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.301")) { //utsEponOnuLinkUp
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.302")) { //utsEponOnuLinkDown
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.1035")) { //utsEponOnuInvalidRegisterClear
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.1036")) { //utsEponOnuInvalidRegister
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.1041")) { //utsEponOnuRegisterEvent
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.1042")) { //utsEponOnuDeregisterEvent
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.1200")) { //utsEponConfigChangeEvent
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.7064.1800.3.2.0.305")) { //utsEponOnuOam802Dot3DyingGasp
            return true;
        //} else if (oid.equals(".1.3.6.1.6.3.1.1.5.1")) { //coldStart
        //    return true;
        } else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.5.3.2.1.1")) { //lOSi
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.5.3.2.1.2")) { //rLOSi
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.5.3.2.1.17")) { //dGi
            return true;
        } else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.5.3.2.1.18")) { //rDGi
            return true;
        }

        return false;
    }

    public String toString() {
        return "EponEventListener";
    }

}
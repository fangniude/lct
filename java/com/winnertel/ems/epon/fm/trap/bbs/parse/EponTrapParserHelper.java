/**
 * Created by Zhou Chao, 2009/7/20
 */

package com.winnertel.ems.epon.fm.trap.bbs.parse;

import com.winnertel.ems.epon.fm.trap.bbs.EponTrapUtil;
import com.winnertel.ems.epon.global.ServerResourceManager;
import com.winnertel.ems.fm.common.ConstantVar;
//import com.winnertel.ems.fm.trap.uncp.parser.AnTrapUtil;
import com.winnertel.em.broadband.common.alarm.ParseEntity;

import java.util.ResourceBundle;

public class EponTrapParserHelper implements ConstantVar {

    public static String getKey(String nodeAddress, long id) {
        return nodeAddress + "_" + id;
    }

    protected static ParseEntity getBasicEntity(String ipAddress) throws Exception {
        return EponTrapUtil.generateBasicParseEntity(ipAddress);
    }

    @Deprecated // ParseHelper.getAlarmClass()
    public static String getAlarmClass(int alarmClass) throws Exception {
        // modified by Zhou Chao, 2009/8/28
        String alarmClassStr = "";
        if (alarmClass == 0)
            alarmClassStr = "classNone";
        else if (alarmClass == 1)
            alarmClassStr = "communication";
        else if (alarmClass == 2)
            alarmClassStr = "qualityOfService";
        else if (alarmClass == 3)
            alarmClassStr = "equipment";
        else if (alarmClass == 4)
            alarmClassStr = "processingError";
        else if (alarmClass == 5)
            alarmClassStr = "environment";
        else if (alarmClass == 6)
            alarmClassStr = "Equipment";
        else if (alarmClass == 7)
            alarmClassStr = "Undefined";

        return alarmClassStr;
    }

    public static String getProbableCause(int pc) throws Exception {
        String probableCauseKey = "FM_ProbableCause_" + pc;
        String probableCauseStr = ServerResourceManager.getString(probableCauseKey);

        return probableCauseStr != null ? probableCauseStr : "";
    }

    public static String getSpecificProblem(int sp) throws Exception {
        String specificProblemKey = "FM_SpecificProblem_" + sp;
        String specificProblemStr = ServerResourceManager.getString(specificProblemKey);

        return specificProblemStr != null ? specificProblemStr : "";
    }

    public static String getProbableCause(String pc) throws Exception {
        String probableCauseKey = "FM_ProbableCause_" + pc;
        String probableCauseStr = ServerResourceManager.getString(probableCauseKey);

        return probableCauseStr != null ? probableCauseStr : "";
    }

    protected static String getSpecificProblem(String sp) throws Exception {
        String specificProblemKey = "FM_SpecificProblem_" + sp;
        String specificProblemStr = ServerResourceManager.getString(specificProblemKey);

        return specificProblemStr != null ? specificProblemStr : "";
    }

    public static String getInterfaceIfAdminStatus(int ifAdminStatus) {
        String ifAdminStatusKey = "IfAdminStatus_" + ifAdminStatus;
        String ifAdminStatusStr = ServerResourceManager.getString(ifAdminStatusKey);
        return ifAdminStatusStr != null ? ifAdminStatusStr : "";
    }

    public static String getInterfaceIfOperStatus(int ifAdminStatus) {
        String ifOperStatusKey = "IfOperStatus_" + ifAdminStatus;
        String ifOperStatusStr = ServerResourceManager.getString(ifOperStatusKey);
        return ifOperStatusStr != null ? ifOperStatusStr : "";
    }

    public static String getDescriptionByKey(String key) {
        String str = ServerResourceManager.getString(key);
        return str != null ? str : "";
    }

    public static String getEntityType(String trapCode, String neType) throws Exception {
        String entityTypeStr = "";
        // for CLT2168,BBS4000R4

        if ("CLT2168".equals(neType)) {// ONU
            if ("101".equals(trapCode) || "102".equals(trapCode) || "103".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_ONUModule");
            else if ("315".equals(trapCode) || "316".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_OLTONU");
            else if ("401".equals(trapCode) || "402".equals(trapCode) || "403".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_ONUUNI");
            else if ("100001".equals(trapCode) || "100002".equals(trapCode) || "100003".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_ONUModule");
            else if ("100010-01".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_CLTNode");
            else if ("100010-02".equals(trapCode) || "100010-03".equals(trapCode) || "100010-04".equals(trapCode) || "100010-05".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_CNU");
        } else if ("BBS4000".equals(neType)) {
            if ("101".equals(trapCode) || "102".equals(trapCode) || "103".equals(trapCode) || "104".equals(trapCode) || "105".equals(trapCode) || "106".equals(trapCode) || "107".equals(trapCode) || "108".equals(trapCode) || "109".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_OLTModule");
            else if ("201".equals(trapCode) || "202".equals(trapCode) || "203".equals(trapCode) || "204".equals(trapCode) || "205".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_OLTPort");
            else if ("301".equals(trapCode) || "302".equals(trapCode) || "303".equals(trapCode) || "304".equals(trapCode) || "305".equals(trapCode) || "306".equals(trapCode) || "307".equals(trapCode) || "308".equals(trapCode) || "310".equals(trapCode) || "311".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_OLTONU");
            else if ("315".equals(trapCode) || "316".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_OLTPort");
            else if ("401".equals(trapCode) || "402".equals(trapCode) || "403".equals(trapCode))
                entityTypeStr = ServerResourceManager.getString("EntityType_OLTUNI");
        }

        return entityTypeStr != null ? entityTypeStr : "";
    }

    public static String getFormattedAlarmInstanceOfCLT2168(byte[] eponAlarmInstance, String trapCode) {
        String str = "";
        if (eponAlarmInstance != null && eponAlarmInstance.length > 0) {
            int index = 0;
            for (int i = 0; i < eponAlarmInstance.length; i++)
                index += (((int) eponAlarmInstance[i]) & 0xFF) << (8 * (eponAlarmInstance.length - 1 - i));

            int[] arr = new int[8];
            for (int i = 0; i < arr.length; i++) {
                arr[arr.length - 1 - i] = index & 0xFF;
                index = index >> 8;
            }

            if ("101".equals(trapCode) || "102".equals(trapCode) || "103".equals(trapCode) || "100001".equals(trapCode) || "100002".equals(trapCode) || "100003".equals(trapCode)) {
                str = "Eoc-" + arr[4];
            } else if ("315".equals(trapCode) || "316".equals(trapCode) || "401".equals(trapCode) || "402".equals(trapCode) || "403".equals(trapCode)) {
                if (arr[4] == 0)
                    str += "CPM/FE";
                else
                    str += "Eoc-";
                str += arr[5];
            }

        }

        return str;
    }

    // [start]
    public static String getEntityType(int entityType) throws Exception {
        String entityTypeStr = "";

        // for BBS4000 v2.1.6
        if (entityType == 2001)
            entityTypeStr = ServerResourceManager.getString("Node");
        else if (entityType == 2002)
            entityTypeStr = ServerResourceManager.getString("Module");
        else if (entityType == 2003)
            entityTypeStr = ServerResourceManager.getString("FAN Module");
        else if (entityType == 2004)
            entityTypeStr = ServerResourceManager.getString("Power Module");
        else if (entityType == 2005)
            entityTypeStr = ServerResourceManager.getString("Shelf");
        else if (entityType == 2006)
            entityTypeStr = ServerResourceManager.getString("OLT PON Protection Group");
        else if (entityType == 2007)
            entityTypeStr = ServerResourceManager.getString("Port");
        else if (entityType == 2008)
            entityTypeStr = ServerResourceManager.getString("ONU");
        else if (entityType == 2009)
            entityTypeStr = ServerResourceManager.getString("ONU UNI");
        else if (entityType == 2010)
            entityTypeStr = ServerResourceManager.getString("ONU PON IF");
        else if (entityType == 2011)
            entityTypeStr = ServerResourceManager.getString("ONU POTS UNI");
        else if (entityType == 2012)
            entityTypeStr = ServerResourceManager.getString("ONU E1 UNI");

        // for ONU4024i, ONU404i
        if (entityType == 1000)
            entityTypeStr = ServerResourceManager.getString("ONU Node");
        else if (entityType == 1001)
            entityTypeStr = ServerResourceManager.getString("ONU Shelf");
        else if (entityType == 1002)
            entityTypeStr = ServerResourceManager.getString("ONU Module");
        else if (entityType == 1003)
            entityTypeStr = ServerResourceManager.getString("ONU Clock");
        else if (entityType == 1004)
            entityTypeStr = ServerResourceManager.getString("ONU External");
        else if (entityType == 1005)
            entityTypeStr = ServerResourceManager.getString("ONU CSM Port");
        else if (entityType == 1007)
            entityTypeStr = ServerResourceManager.getString("ONU V5 Signaling");
        else if (entityType == 1008)
            entityTypeStr = ServerResourceManager.getString("ONU V5 E1 Link");
        else if (entityType == 1009)
            entityTypeStr = ServerResourceManager.getString("ONU E1 Port");
        else if (entityType == 1010)
            entityTypeStr = ServerResourceManager.getString("ONU ONU MG");
        else if (entityType == 1011)
            entityTypeStr = ServerResourceManager.getString("ONU Fax Service");
        else if (entityType == 1012)
            entityTypeStr = ServerResourceManager.getString("ONU VPM Ethernet Port");
        else if (entityType == 1013)
            entityTypeStr = ServerResourceManager.getString("ONU FXS Port");
        else if (entityType == 1014)
            entityTypeStr = ServerResourceManager.getString("ONU DSL Port");
        else if (entityType == 1015)
            entityTypeStr = ServerResourceManager.getString("ONU DSL Channel");
        else if (entityType == 1016)
            entityTypeStr = ServerResourceManager.getString("ONU FE port");

        else if (entityType == 3000)
            entityTypeStr = ServerResourceManager.getString("EntityType_Interface");
        else if (entityType == 3001)
            entityTypeStr = ServerResourceManager.getString("EntityType_Node");

        return entityTypeStr != null ? entityTypeStr : "";
    }

    public static String getEventType(int et) throws Exception {
        String eventTypeKey = "FM_EventType_" + et;
        String eventTypeStr = ServerResourceManager.getString(eventTypeKey);

        return eventTypeStr != null ? eventTypeStr : "";
    }

    protected static String getUTMessage(ParseEntity trapEntity, String additionalInfo) throws Exception {
        String message = trapEntity.getProCause();
        if (trapEntity.getSepCause() != null && !trapEntity.getSepCause().trim().equalsIgnoreCase("") && !trapEntity.getSepCause().trim().equalsIgnoreCase("NULL"))
            message = message + " ; " + trapEntity.getSepCause();
        if (additionalInfo != null && !additionalInfo.trim().equalsIgnoreCase("") && !additionalInfo.trim().equalsIgnoreCase("NULL"))
            message = message + " ; " + additionalInfo;

        return message;
    }

    public static String getEntityInstanceByNodeVersion(int entityType, int entityInstance, String nodeVersion, String nodeType) throws Exception {
//        String strEntityInstance = instanceToStringByNodeVersion(entityType, entityInstance, AnTrapUtil.getBundle(), nodeVersion, nodeType);
        String strEntityInstance = instanceToStringByNodeVersion(entityType, entityInstance, null, nodeVersion, nodeType);
        if (strEntityInstance == null || strEntityInstance.trim().length() <= 0 || strEntityInstance.equalsIgnoreCase("0"))
            strEntityInstance = "N/A";

        return strEntityInstance;
    }

    public static String instanceToStringByNodeVersion(int entityType, int instance, ResourceBundle bundle, String nodeVersion, String nodeType) {
        return getInstanceStringFromValue(entityType, instance, nodeVersion, nodeType);
    }

    public static String getInstanceStringFromValue(int entityType, int instance, String nodeVersion, String nodeType) {
        String strInstance = String.valueOf(instance);

        //
        // for BBS4000 v2.1.6
        //
        // In 4-6-6-8-8 shelf-slot-port-OnuID-OnuUNI port format,
        // port is set to 63,
        // ONU ID is set to 255,
        // ONU UNI port ID is set to 255
        //
        if (entityType == 2001) {
            strInstance = ServerResourceManager.getString("Node");
        } else if (entityType == 2005) {
            int shelf = instance >> 28;
            strInstance = String.valueOf(shelf);
        } else if (entityType == 2006) {
            int shelf = instance >> 28;
            int groupid = instance - (shelf << 28);
            // strInstance = String.valueOf(shelf) + "-" +
            // String.valueOf(groupid);
            strInstance = String.valueOf(groupid);
        } else if (entityType == 2002 || entityType == 2003 || entityType == 2004) {
            int shelf = instance >> 28;
            int slot = (instance - (shelf << 28)) >> 22;
            // strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot);
            strInstance = String.valueOf(slot);
        } else if (entityType == 2007) {
            int shelf = instance >> 28;
            int slot = (instance - (shelf << 28)) >> 22;
            int port = (instance - (shelf << 28) - (slot << 22)) >> 16;
            // strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot)
            // + "-" + String.valueOf(port);
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port);
        } else if (entityType == 2008) {
            int shelf = instance >> 28;
            int slot = (instance - (shelf << 28)) >> 22;
            int port = (instance - (shelf << 28) - (slot << 22)) >> 16;
            int onu = (instance - (shelf << 28) - (slot << 22) - (port << 16)) >> 8;
            // strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot)
            // + "-" + String.valueOf(port) + "-" + onu;
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port) + "-" + onu;
        } else if (entityType == 2009 || entityType == 2010 || entityType == 2011 || entityType == 2012) {
            int shelf = instance >> 28;
            int slot = (instance - (shelf << 28)) >> 22;
            int port = (instance - (shelf << 28) - (slot << 22)) >> 16;
            int onu = (instance - (shelf << 28) - (slot << 22) - (port << 16)) >> 8;
            int uni = instance - (shelf << 28) - (slot << 22) - (port << 16) - (onu << 8);
            // strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot)
            // + "-" + String.valueOf(port) + "-" + onu + "-" + uni;
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port) + "-" + onu + "-" + uni;
        }

        //
        // for ONU4024i, ONU404i
        //
        // In 8-8-8 shelf-slot-port format,
        // slot and port is set to 255
        //
        else if (entityType == 1000) {
            strInstance = ServerResourceManager.getString("ONU Node");
        } else if (entityType == 1001) {
            int shelf = instance >> 16;
            strInstance = String.valueOf(shelf);
        } else if (entityType == 1005 || entityType == 1009 || entityType == 1012 || entityType == 1014) {
            int shelf = instance >> 16;
            int slot = (instance - (shelf << 16)) >> 8;
            int port = (instance - (shelf << 16) - (slot << 8));
            // strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot)
            // + "-" + String.valueOf(port);
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port);
        } else if (entityType == 1015) {
            int shelf = instance >> 16;
            int slot = (instance - (shelf << 16)) >> 8;
            int port = (instance - (shelf << 16) - (slot << 8));
            int channel = 1; // channnel is fixed at 1, others are reserved.
            // strInstance = String.valueOf(shelf) + "-" + String.valueOf(slot)
            // + "-" + String.valueOf(port) + "-" + channel;
            strInstance = String.valueOf(slot) + "-" + String.valueOf(port) + "-" + channel;
        } else if (entityType == 1002 || entityType == 1013 || entityType == 1016) {
            // strInstance = "0-0";
            strInstance = "0";
        } else if (entityType == 1003) {
            // TODO
            // Clock
        } else if (entityType == 1004) {
            // TODO
            // External
        } else if (entityType == 1007) {
            // TODO
            // V5 Signaling
        } else if (entityType == 1008) {
            // TODO
            // V5 E1 Link
        } else if (entityType == 1010) {
            // TODO
            // MG
        } else if (entityType == 1011) {
            // TODO
            // Fax Service
        }

        return strInstance;
    }

    // added by Zhou Chao, 2010/5/19
    public static String getBbs4000R4EponAlarmInstanceString(byte[] eponAlarmInstance) {
        //
        // for BBS4000 v4.0.0
        //
        // Alarm instance, which define the detailed management object
        // reported the alarm. For example, OLT device 1, slot 2, port 3
        // reports a port down alarm.
        //
        // It is represents in OCTET STRING format.
        //
        // 1. The first four OCTET has same definition as EponDeviceIndex TC.
        // 2. The fifth OCTET is the slot definition of ONU, which shall
        // have same definition as last byte definition in EponCardIndex
        // TC.
        // 3. The sixth OCTET is the UNI port ID of ONU, which is similar to
        // EponPortIndex TC.
        // 4. The seventh and eighth OCTETS are reserved and shall be set to
        // 0 at any time, and shall be ignored by maangement system.
        //
        // For example,
        // 0x01 02 03 04 05 06 00 00, represents OLT device 1, slot 2, port 3,
        // ONU logical ID 4, slot 5 UNI port 6 of the connected ONU.
        //

        StringBuffer sb = new StringBuffer();

        if (eponAlarmInstance != null && eponAlarmInstance.length > 0) {
            int index = 0;
            for (int i = 0; i < eponAlarmInstance.length; i++)
                index += (((int) eponAlarmInstance[i]) & 0xFF) << (8 * (eponAlarmInstance.length - 1 - i));

            int[] array = new int[8];
            for (int i = 0; i < array.length; i++) {
                array[array.length - 1 - i] = index & 0xFF;
                index = index >> 8;
            }

            for (int i = 0; i < 8; i++) {
                if (array[i] > 0)
                    sb.append(array[i]).append("-");
            }
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append("N/A");
        }

        return sb.toString();
    }

    // added by Zhou Chao, 2010/5/21
    public static String getBbs4000R4EponAlarmCode(int code) throws Exception {
        String eponAlarmCodeKey = "FM_EponAlarmCode_" + code;
        String eponAlarmCodeStr = ServerResourceManager.getString(eponAlarmCodeKey);

        return eponAlarmCodeStr != null ? eponAlarmCodeStr : "";
    }

    // added by Zhou Chao, 2010/5/21
    public static String getBbs4000R4EponAlarmMessage(int code, String additionalInfo) throws Exception {
        String message = getBbs4000R4EponAlarmCode(code);

        if (additionalInfo != null && !additionalInfo.trim().equalsIgnoreCase("") && !additionalInfo.trim().equalsIgnoreCase("NULL")) {
            if (message.length() > 0)
                message += " ; ";
            message += additionalInfo;
        }

        return message;
    }

    // added by Zhou Chao, 2010/7/20
    public static String getBbs4000R4EponEventCode(int code) throws Exception {
        String eponEventCodeKey = "FM_EponEventCode_" + code;
        String eponEventCodeStr = ServerResourceManager.getString(eponEventCodeKey);

        return eponEventCodeStr != null ? eponEventCodeStr : "";
    }

    // added by Zhou Chao, 2010/7/20
    public static String getBbs4000R4EponEventMessage(int code, String additionalInfo) throws Exception {
        String message = getBbs4000R4EponEventCode(code);

        if (additionalInfo != null && !additionalInfo.trim().equalsIgnoreCase("") && !additionalInfo.trim().equalsIgnoreCase("NULL")) {
            if (message.length() > 0)
                message += " ; ";
            message += additionalInfo;
        }

        return message;
    }
    // [end]
}
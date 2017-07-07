package com.winnertel.ems.epon.fm;

import com.winnertel.em.broadband.common.alarm.ParseEntity;
import com.winnertel.em.broadband.common.alarmsync.config.FMEConstant;
import com.winnertel.em.broadband.common.util.FmLogUtil;
import com.winnertel.em.broadband.common.util.OEMServerUtils;
import com.winnertel.ems.fm.FMUtil;
import com.winnertel.ems.fm.alarmdb.Alarm;
import com.winnertel.ems.fm.eventdb.Event;
import com.winnertel.snmp.snmp2.DefaultSnmpAPI;
import com.winnertel.snmp.snmp2.SnmpOID;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.snmp.snmp2.SnmpVar;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Date;

public class EponAlarmUtils {

    public static final String EPON_ALARM_SESSION_OID = ".1.3.6.1.4.1.41355.1800.2.1.2.1.45";
    public static final String COLD_START = ".1.3.6.1.6.3.1.1.5.1";
    public static final String WARM_START = ".1.3.6.1.6.3.1.1.5.2";

    public static ParseEntity convertEponAlarm(Alarm alarm, SnmpPDU pdu, long sessionID) {
        // String moName = BBFMUtil.getMOName(pdu.getAgentAddr());
        // if (moName == null) {
        // FmLogUtil.writeErrLog("the mo name is null for node: "
        // + pdu.getAgentAddr() + ", so discard it!");
        // return null;
        // }

        int version = pdu.getVersion();
        String trapoid = null;
        if (version == DefaultSnmpAPI.SNMP_VERSION_2 || version == DefaultSnmpAPI.SNMP_VERSION_2C) {
            trapoid = pdu.getVariable(1).toString();
        } else if (version == DefaultSnmpAPI.SNMP_VERSION_1) {
            trapoid = pdu.getEnterprise().toString() + "." + pdu.getSpecificType();
        }
        ParseEntity entity = new ParseEntity();
        entity.setTrapOID(trapoid);
        entity.setEntity(alarm.getEntity() + "_" + alarm.getAlarmId());
        entity.setAlarmID(alarm.getAlarmId());
        entity.setEntityType(alarm.getEntityType());
        entity.setEntityInstance(alarm.getEntityInstance());
        entity.setMoName(alarm.getNeName());
        entity.setMoType(alarm.getNeType());
        entity.setSource(alarm.getSource());
        entity.setCategory(alarm.getCategory());
        entity.setSeverity(alarm.getSeverity());
        entity.setMessage(alarm.getMessage());
        entity.setProCause(alarm.getProbableCause());
        entity.setSepCause(alarm.getSpecialReason());
        entity.setSeqNO(alarm.getSeqNo());
        entity.setAckUser(alarm.getAckUser());
        entity.setAckTime(alarm.getAckTime());
        entity.setAdditionalInfo(alarm.getAddInfo());
        entity.setCreateTime(alarm.getCreateTime());
        if (sessionID != -1) {
            entity.setSessionID(sessionID);
        } else {
            entity.setSessionID(getEponAlarmSessionID(pdu));
        }
        return entity;
    }

    public static int getEponAlarmSessionID(SnmpPDU pdu) {
        int sessionID = -1;
        int vbs = pdu.getVariableBindings().size();
        for (int i = 1; i < vbs; i++) {
            SnmpOID oid = pdu.getObjectID(i);
            SnmpVar value = pdu.getVariable(i);
            if (oid.toString().startsWith(EPON_ALARM_SESSION_OID)) {
                try {
                    sessionID = Integer.parseInt(value.toValue().toString());
                } catch (Exception ex) {
                    sessionID = -1;
                    FmLogUtil.writeErrLog("Can't get session ID from PDU.");
                }
            }
        }
        return sessionID;
    }

    public static ParseEntity convertEponEvent(Event event, SnmpPDU pdu) {
        int version = pdu.getVersion();
        String trapoid = null;
        if (version == DefaultSnmpAPI.SNMP_VERSION_2 || version == DefaultSnmpAPI.SNMP_VERSION_2C) {
            trapoid = pdu.getVariable(1).toString();
        } else if (version == DefaultSnmpAPI.SNMP_VERSION_1) {
            trapoid = pdu.getEnterprise().toString() + "." + pdu.getSpecificType();
        } else {
            trapoid = "";
            FmLogUtil.writeErrLog("EponAlarmUtils->convertEponEvent: unknow snmp version:" + version);
        }
        ParseEntity entity = new ParseEntity();
        entity.setSeverity(FMEConstant.EVENT);
        entity.setTrapOID(trapoid);
        entity.setEntityType(event.getEntityType());
        entity.setCreateTime(event.getCreateTime());
        entity.setMessage(event.getMessage());
        entity.setMoName(event.getNeId());
        entity.setSource(event.getSource());
        entity.setMoType(event.getNeType());
        entity.setEntityInstance(event.getEntityInstance());
        entity.setEventType(event.getEventId());
        entity.setSeqNO(event.getSeqNo());
        if (trapoid.equalsIgnoreCase(COLD_START)) {
            entity.setEventType("WarmStart");
            entity.setMessage("NE " + FMUtil.getString("warmStart") + ". IP=" + pdu.getRemoteHost());
            entity.setResetFlag(FMEConstant.EVENT_RESET);
        }
        if (trapoid.equalsIgnoreCase(WARM_START)) {
            entity.setEventType("WarmStart");
            entity.setMessage("NE " + FMUtil.getString("warmStart") + ". IP=" + pdu.getRemoteHost());
            entity.setResetFlag(FMEConstant.EVENT_RESET);
        }
        return entity;
    }

    public static Alarm convertEponParseEntity(ParseEntity entity) {
        Alarm alarm = new Alarm();
        alarm.setEntity(entity.getEntity());
        String alarmID = entity.getAlarmID();
        alarm.setAlarmId(alarmID);
        alarm.setEntityType(entity.getEntityType());
        String instance = entity.getEntityInstance();
        if (instance.startsWith(entity.getMoType())) {
            String instanceLabel = OEMServerUtils.getLabelByNEType(entity.getMoType()) + instance.substring(entity.getMoType().length());
            alarm.setEntityInstance(instanceLabel);
        } else {
            alarm.setEntityInstance(entity.getEntityInstance());
        }
        alarm.setNeId(entity.getMoName());
        alarm.setNeType(entity.getMoType());
        alarm.setSource(entity.getSource());
        alarm.setCategory(entity.getCategory());
        alarm.setSeverity(entity.getSeverity());
        if (entity.getCreateTime() == 0) {
            alarm.setCreateTime((new Date()).getTime());
        } else {
            alarm.setCreateTime(entity.getCreateTime());
        }
        alarm.setMessage(entity.getMessage());
        alarm.setProbableCause(entity.getProCause());
        alarm.setSpecialReason(entity.getSepCause());

        alarm.setSeqNo(entity.getSeqNO());

        if (entity.getAckUser() != null) {
            alarm.setAckUser(entity.getAckUser());
            alarm.setAckTime(entity.getAckTime());
        }
        if (entity.getAdditionalInfo() != null && !entity.getAdditionalInfo().equalsIgnoreCase("null")) {
            alarm.setAddInfo(entity.getAdditionalInfo());
        }

        int offset = 40000;
        String pCode = entity.getPCode();
        String spCode = entity.getSPCode();
        String etCode = entity.getETCode();
        String help = null;
        if (pCode != null && NumberUtils.isNumber(pCode)) {
            int pc = Integer.parseInt(pCode) + offset;
            help = "PC=" + Integer.toString(pc) + ",";
        }
        if (spCode != null && NumberUtils.isNumber(spCode)) {
            int sp = Integer.parseInt(spCode) + offset;
            help = help + "SP=" + Integer.toString(sp) + ",";
        }
        if (etCode != null && NumberUtils.isNumber(etCode)) {
            int et = Integer.parseInt(etCode) + offset;
            help = help + "ET=" + Integer.toString(et);
        }
        if (help != null) {
            alarm.setHelp(help);
            FmLogUtil.writeOutLog("AlarmAction->the NBIF:" + help);
        }

        return alarm;
    }

    // added by Zhou Chao, 2010/5/19 -- begin
    public static Alarm convertBbs4000R4ParseEntity(ParseEntity entity) {
        Alarm alarm = new Alarm();
        alarm.setEntity(entity.getEntity());
        String alarmID = entity.getAlarmID();
        alarm.setAlarmId(alarmID);
        // alarm.setEntityType(entity.getEntityType());
        String instance = entity.getEntityInstance();
        if (instance.startsWith(entity.getMoType())) {
            String instanceLabel = OEMServerUtils.getLabelByNEType(entity.getMoType()) + instance.substring(entity.getMoType().length());
            alarm.setEntityInstance(instanceLabel);
        } else {
            alarm.setEntityInstance(entity.getEntityInstance());
        }
        alarm.setNeId(entity.getMoName());
        alarm.setNeType(entity.getMoType());
        // alarm.setSource(entity.getSource()); //todo
        // alarm.setCategory(entity.getCategory());
        alarm.setSeverity(entity.getSeverity());
        if (entity.getCreateTime() == 0) {
            alarm.setCreateTime((new Date()).getTime());
        } else {
            alarm.setCreateTime(entity.getCreateTime());
        }
        // alarm.setMessage(entity.getMessage());

        alarm.setSeqNo(entity.getSeqNO());

        if (entity.getAckUser() != null) {
            alarm.setAckUser(entity.getAckUser());
            alarm.setAckTime(entity.getAckTime());
        }
        if (entity.getAdditionalInfo() != null && !entity.getAdditionalInfo().equalsIgnoreCase("null")) {
            alarm.setAddInfo(entity.getAdditionalInfo());
        }

        // alarm.setProbableCause(entity.getProCause());
        // alarm.setSpecialReason(entity.getSepCause());
        //
        // int offset = 40000;
        // String PCode = entity.getPCode();
        // String SPCode = entity.getSPCode();
        // String ETCode = entity.getETCode();
        // String help = null;
        // if (PCode != null && NumberUtils.isNumber(PCode)) {
        // int pc = Integer.parseInt(PCode) + offset;
        // help = "PC=" + Integer.toString(pc) + ",";
        // }
        // if (SPCode != null && NumberUtils.isNumber(SPCode)) {
        // int sp = Integer.parseInt(SPCode) + offset;
        // help = help + "SP=" + Integer.toString(sp) + ",";
        // }
        // if (ETCode != null && NumberUtils.isNumber(ETCode)) {
        // int et = Integer.parseInt(ETCode) + offset;
        // help = help + "ET=" + Integer.toString(et);
        // }
        // if (help != null) {
        // alarm.setHelp(help);
        // FmLogUtil.writeOutLog("AlarmAction->the NBIF:" + help);
        // }

        return alarm;
    }
    // added by Zhou Chao, 2010/5/19 -- end

}
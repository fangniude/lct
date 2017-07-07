package com.winnertel.ems.epon.fm.trap.bbs.parse;

import com.winnertel.em.broadband.common.alarm.ParseEntity;
import com.winnertel.em.broadband.common.util.FmLogUtil;
import com.winnertel.ems.epon.fm.trap.bbs.EponTrapUtil;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.nms.topodb.ULManagedObject;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.ems.fm.common.ConstantVar;
import com.winnertel.em.broadband.common.alarm.AbstractSnmpTrapBean;

import java.util.Properties;

/**
 * Created by HZ20192
 * Date: 2011-12-22
 *
 * @auther Li Pengpeng
 */
public class EponAlarmBean extends AbstractSnmpTrapBean {

    private static final String utsBbsAlarmSessionId = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.1";
    private static final String utsBbsAlarmSequenceNumber = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.2";
    private static final String utsBbsAlarmTime = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.3";
    private static final String utsBbsAlarmClass = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.4";
    private static final String utsBbsAlarmEntityType = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.5";
    private static final String utsBbsAlarmEntityInstance = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.6";
    private static final String utsBbsAlarmSeverity = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.7";
    private static final String utsBbsAlarmProbableCause = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.8";
    private static final String utsBbsAlarmSpecificProblem = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.9";
    private static final String utsBbsAlarmVersionId = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.10";
    private static final String utsBbsAlarmCorrelationId = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.11";
    private static final String utsBbsAlarmSourceIp = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.12";
    private static final String utsBbsAlarmAdditionalText = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.13";
    private static final String utsBbsAlarmDeviceType = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.15";

    public EponAlarmBean(SnmpPDU aSnmpPdu) {
        super(aSnmpPdu);
    }

    @Override
    protected void initProperty() {
        addProperty(new SnmpTrapProperty(utsBbsAlarmSessionId, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmSequenceNumber, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmTime, DataType.DATE_AND_TIME));
        addProperty(new SnmpTrapProperty(utsBbsAlarmClass, DataType.INTEGER));
        addProperty(new SnmpTrapProperty(utsBbsAlarmEntityType, DataType.INTEGER));
        addProperty(new SnmpTrapProperty(utsBbsAlarmEntityInstance, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmSeverity, DataType.INTEGER));
        addProperty(new SnmpTrapProperty(utsBbsAlarmProbableCause, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmSpecificProblem, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmVersionId, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmCorrelationId, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmSourceIp, DataType.IP_ADDRESS));
        addProperty(new SnmpTrapProperty(utsBbsAlarmAdditionalText, DataType.OCTETS));
        addProperty(new SnmpTrapProperty(utsBbsAlarmDeviceType, DataType.OCTETS));
    }


    private Long getSessionId() {
        return (Long) getProperty(utsBbsAlarmSessionId);
    }

    private Long getSequenceNumber() {
        return (Long) getProperty(utsBbsAlarmSequenceNumber);
    }

    private Long getTime() {
        return (Long) getProperty(utsBbsAlarmTime);
    }

    private Integer getAlarmClass() {
        return (Integer) getProperty(utsBbsAlarmClass);
    }

    private Integer getEntityType() {
        return (Integer) getProperty(utsBbsAlarmEntityType);
    }

    private Long getEntityInstance() {
        return (Long) getProperty(utsBbsAlarmEntityInstance);
    }

    private Integer getAlarmSeverity() {
        return (Integer) getProperty(utsBbsAlarmSeverity);
    }

    private Long getAlarmProbableCause() {
        return (Long) getProperty(utsBbsAlarmProbableCause);
    }

    private Long getAlarmSpecificProblem() {
        return (Long) getProperty(utsBbsAlarmSpecificProblem);
    }

    private Long getVersionId() {
        return (Long) getProperty(utsBbsAlarmVersionId);
    }

    private Long getAlarmCorrelationId() {
        return (Long) getProperty(utsBbsAlarmCorrelationId);
    }

    private String getSourceIp() {
        return (String) getProperty(utsBbsAlarmSourceIp);
    }

    private String getAdditionalText() {
        return (String) getProperty(utsBbsAlarmAdditionalText);
    }

    private String getDeviceType() {
        return (String) getProperty(utsBbsAlarmDeviceType);
    }

//    @Override
    public ParseEntity parse() {
        if (fSnmpPdu.getVariableBindings().size() < 13) {
            FmLogUtil.writeErrLog("EponAlarmBean->parse: The event is lost, because the size of varBindings is less than 13:" + fSnmpPdu.getVariableBindings().size());
            return null;
        }

        ParseEntity rtEntity = null;
        try {
            rtEntity = EponTrapUtil.generateBasicParseEntity(fSnmpPdu.getRemoteHost());
            if (getDeviceType() != null && getDeviceType().length() > 0) {
                rtEntity.setMoType(getDeviceType());
            }
            rtEntity.setSenderIP(fSnmpPdu.getRemoteAddress()); // set node address
            rtEntity.setTrapOID(BbsTrapConstant.utsBbsAlarmTrap);

            rtEntity.setSeqNO(getSequenceNumber().intValue());
            rtEntity.setSessionID(getSessionId());

            // set alarm class
            rtEntity.setCategory(EponTrapParserHelper.getAlarmClass(getAlarmClass()));

            // set entity Type
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(getEntityType()));
            rtEntity.setETCode(Integer.toString(getEntityType())); // set entity Type

            String instance = EponTrapParserHelper.getEntityInstanceByNodeVersion(getEntityType(), getEntityInstance().intValue(), rtEntity.getNodeVersion(), rtEntity.getMoType());
            if (instance.equalsIgnoreCase("N/A")) {
                rtEntity.setEntityInstance(rtEntity.getMoType() + "-" + rtEntity.getSenderIP());
            } else {
                rtEntity.setEntityInstance(instance);
            }

            // TODO
            if (rtEntity.getMoName() != null) {
                String source = rtEntity.getMoName();
                source = source + "_" + getEntityType() + "_" + getEntityInstance();
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getMoName());
            } else {
                String source = rtEntity.getSenderIP();
                source = source + "_" + getEntityType() + "_" + getEntityInstance();
                rtEntity.setSource(source);
                // rtEntity.setSource(rtEntity.getSenderIP());
            }

            if (getAlarmSeverity() < ConstantVar.CRITICAL || getAlarmSeverity() > ConstantVar.CLEAR) {
                throw new Exception("severity of the alarm is not correct: " + getAlarmSeverity());
            }

            rtEntity.setSeverity(getAlarmSeverity());

            long correlationId = getAlarmCorrelationId();
            if (correlationId == 0) {
                correlationId = -1;
            }
            if (correlationId >= 1) { // clear alarm
                rtEntity.setSeverity(com.winnertel.ems.fm.common.ConstantVar.CLEAR);
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), correlationId);
                // String key = getKey(trapEntity.getSenderIP(), correlationId);
                rtEntity.setEntity(key);
            } else {// raise alarm
                String key = EponTrapParserHelper.getKey(rtEntity.getMoName(), getSequenceNumber());
                // String key = getKey(trapEntity.getSenderIP(), seqNo);
                rtEntity.setEntity(key);
            }

            // String key = EponTrapParserHelper.getKey(rtEntity.getMoName(),
            // seqNo);
            // rtEntity.setEntity(key);

            rtEntity.setCreateTime(getTime());

            // set probable cause
            rtEntity.setProCause(EponTrapParserHelper.getProbableCause(getAlarmProbableCause().intValue()));

            // set probable cause
            rtEntity.setPCode(String.valueOf(getAlarmProbableCause()));

            // set probable cause
            rtEntity.setSepCause(EponTrapParserHelper.getSpecificProblem(getAlarmSpecificProblem().intValue()));

            // set probable cause
            rtEntity.setSPCode(String.valueOf(getAlarmSpecificProblem()));

            String addInfo = getAdditionalText().trim();

            String moName = UTopoAPI.getAPI().getNodeNameByIP(fSnmpPdu.getRemoteAddress());
            ULManagedObject moInstance = UTopoAPI.getAPI().getByName(moName);
            Properties prop = moInstance.getProperties();
            String nodeVersion = prop.getProperty("version");

            if (addInfo.length() > 0) {
                addInfo += ", Session ID = " + getSessionId() + ", Version = " + nodeVersion;
            } else {
                addInfo += "Session ID = " + getSessionId() + ", Version = " + nodeVersion;
            }

            rtEntity.setMessage(EponTrapParserHelper.getUTMessage(rtEntity, addInfo));
            rtEntity.setAdditionalInfo(addInfo);

            int alarmID = ((getAlarmProbableCause().intValue() & 0x0000ffff) << 16) + (getAlarmSpecificProblem().intValue() & 0x0000ffff);
            // rtEntity.setAlarmID(rtEntity.getMoType() + "-" + alarmID);
            rtEntity.setAlarmID(String.valueOf(alarmID));

            rtEntity.setEntity(rtEntity.getEntity() + "_" + rtEntity.getSessionID());
        } catch (Exception e) {
            FmLogUtil.writeErrLog("EponEventBean->parse: Parse alarm fail.");
            FmLogUtil.writeErrLog(e);
            return null;
        }

        return rtEntity;
    }


}

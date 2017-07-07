package com.winnertel.ems.epon.fm.trap.bbs.parse;

import com.winnertel.em.broadband.common.alarm.AbstractSnmpTrapBean;
import com.winnertel.em.broadband.common.alarm.ParseEntity;
import com.winnertel.em.broadband.common.alarm.util.BBFMUtil;
import com.winnertel.em.broadband.common.util.FmLogUtil;
import com.winnertel.em.broadband.common.version.VersionMap;
import com.winnertel.ems.epon.fm.trap.bbs.EponTrapUtil;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.nms.topodb.ULManagedObject;
import com.winnertel.snmp.snmp2.SnmpPDU;

import java.util.Properties;

/**
 * Created by HZ20192
 * Date: 2011-12-21
 *
 * @auther Li Pengpeng
 */
public class EponEventBean extends AbstractSnmpTrapBean {

    private static final String utsBbsAlarmSessionId = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.1";
    private static final String utsBbsAlarmSequenceNumber = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.2";
    private static final String utsBbsAlarmTime = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.3";
    private static final String utsBbsAlarmEntityType = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.5";
    private static final String utsBbsAlarmEntityInstance = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.6";
    private static final String utsBbsEventType = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.14";
    private static final String utsBbsAlarmAdditionalText = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.13";
    private static final String utsBbsAlarmSourceIp = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.12";
    private static final String utsBbsAlarmVersionId = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.10";
    private static final String utsBbsAlarmDeviceType = "1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.15";

    public EponEventBean(SnmpPDU aSnmpPdu) {
        super(aSnmpPdu);
    }

    @Override
    protected void initProperty() {
        addProperty(new SnmpTrapProperty(utsBbsAlarmSessionId, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmSequenceNumber, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmTime, DataType.DATE_AND_TIME));
        addProperty(new SnmpTrapProperty(utsBbsAlarmEntityType, DataType.INTEGER));
        addProperty(new SnmpTrapProperty(utsBbsAlarmEntityInstance, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsEventType, DataType.GAUGE));
        addProperty(new SnmpTrapProperty(utsBbsAlarmAdditionalText, DataType.OCTETS));
        addProperty(new SnmpTrapProperty(utsBbsAlarmSourceIp, DataType.IP_ADDRESS));
        addProperty(new SnmpTrapProperty(utsBbsAlarmVersionId, DataType.GAUGE));
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

    private Integer getEntityType() {
        return (Integer) getProperty(utsBbsAlarmEntityType);
    }

    private Long getEntityInstance() {
        return (Long) getProperty(utsBbsAlarmEntityInstance);
    }

    private Long getEventType() {
        return (Long) getProperty(utsBbsEventType);
    }

    private String getAdditionalText() {
        return (String) getProperty(utsBbsAlarmAdditionalText);
    }

    private String getSourceIp() {
        return (String) getProperty(utsBbsAlarmSourceIp);
    }

    private Long getVersionId() {
        return (Long) getProperty(utsBbsAlarmVersionId);
    }

    private String getDeviceType() {
        return (String) getProperty(utsBbsAlarmDeviceType);
    }

//    @Override
    public ParseEntity parse() {
        if (fSnmpPdu.getVariableBindings().size() < 9) {
            FmLogUtil.writeErrLog("EponEventBean->parse: The event is lost, because the size of varBindings is less than 10");
            return null;
        }

        ParseEntity rtEntity = null;

        try {
            rtEntity = EponTrapUtil.generateBasicParseEntity(fSnmpPdu.getRemoteHost());

            if (getDeviceType() != null && getDeviceType().length() > 0) {
                rtEntity.setMoType(getDeviceType());
            }
            rtEntity.setSenderIP(fSnmpPdu.getRemoteAddress()); // set node address
            rtEntity.setTrapOID(BbsTrapConstant.utsBbsEventTrap);

            rtEntity.setCreateTime(getTime());

            rtEntity.setSeqNO(-1);// TODO maybe a bug, seems to set getSequenceNumber()
            rtEntity.setSessionID(getSessionId());
            rtEntity.setEntityType(EponTrapParserHelper.getEntityType(getEntityType())); // set

            rtEntity.setEventType(EponTrapParserHelper.getEventType(getEventType().intValue())); // set

            rtEntity.setCategory("");
            rtEntity.setProCause("");
            rtEntity.setSepCause("");

            if (rtEntity.getMoName() != null) {
                rtEntity.setSource(rtEntity.getMoName());
            } else {
                rtEntity.setSource(rtEntity.getSenderIP());
            }

            rtEntity.setAlarmID(rtEntity.getSenderIP() + "-" + getSessionId() + "-" + getEntityType() + "-" + getEventType());

            rtEntity.setSeverity(6);

            String nodeVersion = BBFMUtil.getNodeVersion(rtEntity.getMoName());
            String disVersion = VersionMap.getDisplayVersion(rtEntity.getMoType(), nodeVersion);

            final String instance = EponTrapParserHelper.getEntityInstanceByNodeVersion(getEntityType(), getEntityInstance().intValue(), disVersion, rtEntity.getMoType());
            if (instance.equalsIgnoreCase("N/A"))
                rtEntity.setEntityInstance(rtEntity.getMoType() + "-" + rtEntity.getSenderIP());
            else
                rtEntity.setEntityInstance(instance);

            String addInfo = buildAddInfo();
            rtEntity.setMessage(addInfo);
            rtEntity.setAdditionalInfo(addInfo);

            rtEntity.setEntity(rtEntity.getEntity() + "_" + rtEntity.getSessionID());
        } catch (Exception e) {
            FmLogUtil.writeErrLog("EponEventBean->parse: Parse fail.");
            FmLogUtil.writeErrLog(e);
        }


        return rtEntity; 
    }

    private String buildAddInfo() throws Exception {
        String addInfo = getAdditionalText().trim();
        if( addInfo.length() > 5 && addInfo.startsWith( "TYPE=" )){
        	String boardType = addInfo.substring( 5, addInfo.length() );
        	if( isNumeric( boardType ) ){
        		boardType = getBoardType( Integer.parseInt( boardType ) );
        	}
        	addInfo = EponTrapParserHelper.getDescriptionByKey( "bbs4000_moduleType" ) + boardType;
        }
        
        String moName = UTopoAPI.getAPI().getNodeNameByIP(fSnmpPdu.getRemoteAddress());
        ULManagedObject moInstance = UTopoAPI.getAPI().getByName(moName);
        Properties prop = moInstance.getProperties();
        String nodeVersion = prop.getProperty("version");

        if (addInfo.length() > 0) {
            addInfo += ", Session ID = " + getSessionId() + ", Version = " + nodeVersion;
        } else {
            addInfo += "Session ID = " + getSessionId() + ", Version = " + nodeVersion;
        }

        return addInfo;
    }
    
    public static String getBoardType( int type ){
    	switch( type ){
    		case 1:
    			return "OTHER";
    		case 2:
    			return "CSM";
    		case 3:
    			return "EPM04A";
    		case 4:
    			return "EPM04B";
    		case 5:
    			return "EPM04C";
    		case 6:
    			return "GEM04A";
    		case 7:
    			return "GEM04B";
    		case 8:
    			return "XGM01A";
    		case 9:
    			return "OSM04A";
    		case 10:
    			return "GPM02A";
    		case 11:
    			return "EPM04D";
    		case 12:
    			return "GEM04C";
    	}
    	
		return "";
    }
    
	public static boolean isNumeric( String str ){
		if( str == null || str.length() <= 0 )
			return false;
		if( "-".equals( String.valueOf( str.charAt( 0 ) ) ) ){
			str = str.substring( 1 );
		}

		if( str.matches( "\\d*" ) ){
			return true;
		}else{
			return false;
		}
	}
}

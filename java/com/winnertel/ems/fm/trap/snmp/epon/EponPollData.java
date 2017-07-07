package com.winnertel.ems.fm.trap.snmp.epon;

import com.winnertel.ems.epon.fm.BBSNeAlarmSync;
import com.winnertel.ems.fm.common.AlarmUtil;
import com.winnertel.em.broadband.common.alarmsync.config.FMEConstant;
import com.winnertel.em.broadband.common.alarmsync.syncMechanism.PollData;
import com.winnertel.em.broadband.common.util.FmLogUtil;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.SnmpVar;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class EponPollData implements PollData{

	private static final String EPON_FME_SESSION_ID = ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.39.0";
	private static final String EPON_FME_ALARM_LAST_SEQ_NO = ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.40.0";
	private static final String ALARM_LAST_SEQUENCE_NUMBER = ".1.3.6.1.4.1.17409.2.2.11.2.11.0";

	public Map poll( String moName ){
		try{
			String nodeAddress = AlarmUtil.getNodeAddress( moName );
			SnmpTarget target = BBSNeAlarmSync.getSnmpTargetForGet(moName);
			String neType = getNeType( moName );
			SnmpVar[] values = null;
			if( "CLT2168".equals( neType ) ){
				String oids[] = { ALARM_LAST_SEQUENCE_NUMBER };
				target.setObjectIDList( oids );
				values = target.snmpGetVariables();
			}else{
				String oids[] = { EPON_FME_SESSION_ID, EPON_FME_ALARM_LAST_SEQ_NO };
				target.setObjectIDList( oids );
				values = target.snmpGetVariables();
			}
			String seqID = null;
			String sessionID = null;
			if( values == null ){
				FmLogUtil.writeErrLog( "EponPollData->poll: Can't get session ID & sequence ID from node: "
						+ nodeAddress );
				sessionID = "-1";
				seqID = "-1";
			}else if( values.length == 1 ){
				sessionID = "-1";
				seqID = values[0].toString();
			}else{
				sessionID = values[0].toString();
				seqID = values[1].toString();
			}

			HashMap rtMap = new HashMap();
			rtMap.put( FMEConstant.NE_NAME, nodeAddress );
			rtMap.put(	FMEConstant.NE_SQID,
						new Integer( isNumeric( seqID ) ? seqID : "-1" ) );
			rtMap.put(	FMEConstant.NE_SID,
						new Long( isNumeric( sessionID ) ? sessionID : "-1" ) );
			return rtMap;
		}catch(Exception e){
			FmLogUtil.writeErrLog( e );
			return null;
		}

	}
	
	private String getNeType( String moName ){
		String type = "";
		try{
			type = UTopoAPI.getAPI().getByName(moName).getType();
		}catch(RemoteException e){
			e.printStackTrace();
        }catch(Exception e){
			e.printStackTrace();
		}
		return type;
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

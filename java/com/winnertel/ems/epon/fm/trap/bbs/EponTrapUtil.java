/**
 * Created by Zhou Chao, 2009/7/20
 */

package com.winnertel.ems.epon.fm.trap.bbs;

import com.winnertel.ems.fm.common.AlarmUtil;
import com.winnertel.em.broadband.common.alarm.ParseEntity;
import com.winnertel.em.broadband.common.alarmsync.config.FMEConstant;
import com.winnertel.em.broadband.common.util.FmLogUtil;
import com.winnertel.nms.topodb.ULManagedObject;

public class EponTrapUtil {

    // private static ResourceBundle mBundle = null;
    // private static Locale m_Locale = null;

    public static void log(String msg) {
        FmLogUtil.writeOutLog(msg);
        // System.err.println(msg);
    }

    public static String getAlarmID(String trapOID) {
        return "GEPON-" + trapOID;
    }

    public static ParseEntity generateBasicParseEntity(String ipAddress) throws Exception {
        try {
            ParseEntity parseEntity = new ParseEntity();
            String moName = AlarmUtil.getTopAPI().getNodeNameByIP(ipAddress);
            ULManagedObject moInstance = AlarmUtil.getTopAPI().getByName(moName);

            String moType = moInstance.getType();
            String nodeVersion = moInstance.getProperties().getProperty(FMEConstant.NODE_VERSION);
            parseEntity.setMoName(moName);
            parseEntity.setMoType(moType);
            parseEntity.setNodeVersion(nodeVersion);

            return parseEntity;
        } catch (Exception e) {
            log("***** Can't find MO for this trap: sender=" + ipAddress + ", return trap, end. *****");
            throw e;
        }
    }

    public static String getIPAddress(String stackAddress) {
        return stackAddress.substring(stackAddress.indexOf("@") + 1);
    }

//    public static ResourceBundle getBundle() {
//        return AnTrapUtil.getBundle();
//    }
//
//    public static Locale getLocale() {
//        return AnTrapUtil.getLocale();
//    }

}
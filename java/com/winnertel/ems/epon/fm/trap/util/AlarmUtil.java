/**
 * Created by Zhou Chao, 2009/7/20
 */

package com.winnertel.ems.epon.fm.trap.util;

import com.winnertel.snmp.snmp2.SnmpVar;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class AlarmUtil {

    // adventnet severity
    public static final int CRITICAL = 1;
    public static final int MAJOR = 2;
    public static final int MINOR = 3;
    public static final int WARNING = 4;
    public static final int CLEAR = 5;
    public static final int UNKNOW = 6;

    public static final int LOCALTIME_SIZE = 8;
    public static final int UTCTIME_SIZE = 11;
    public static final String TIMEZONE_GMT = "GMT";

    public AlarmUtil() {
    }

    public static boolean isLocalTime(byte[] dateAndTime) {
        if ((dateAndTime == null) || (dateAndTime.length != LOCALTIME_SIZE))
            return false;

        return true;
    }

    private static int byte2Int(byte byte1) {
        int nValue = ((int) byte1) & 0x000000FF;

        return nValue;
    }

    private static int bytes2Int(byte byte1, byte byte2) {
        int nValue = ((int) byte1) & 0x000000FF;
        nValue = nValue << 8;
        nValue = nValue + (((int) byte2) & 0x000000FF);

        return nValue;
    }

    public static Date localTime2Date(byte[] localTime) {
        if (!isLocalTime(localTime))
            return null;

        try {
            int nYear = bytes2Int(localTime[0], localTime[1]);
            int nMonth = byte2Int(localTime[2]);
            int nDay = byte2Int(localTime[3]);
            int nHour = byte2Int(localTime[4]);
            int nMinute = byte2Int(localTime[5]);
            int nSecond = byte2Int(localTime[6]);
//            int nMilliSecond = byte2Int(localTime[7]);

            Calendar rightNow = Calendar.getInstance();
            rightNow.set(nYear, nMonth - 1, nDay, nHour, nMinute, nSecond);
            
            rightNow.set(Calendar.MILLISECOND, 0);
            
            return (rightNow.getTime());
        } catch (Exception e) {
        }

        return null;
    }

    public static boolean isUTCTime(byte[] dateAndTime) {
        if ((dateAndTime == null) || (dateAndTime.length != UTCTIME_SIZE))
            return false;

        return true;
    }

    public static Date bytes2Date(byte[] dateAndTime) {
        if (dateAndTime != null) {
            if (isLocalTime(dateAndTime)) {
                return localTime2Date(dateAndTime);
            }
            if (dateAndTime.length > LOCALTIME_SIZE && dateAndTime.length < UTCTIME_SIZE) {
                byte[] dt = new byte[LOCALTIME_SIZE];
                System.arraycopy(dateAndTime, 0, dt, 0, LOCALTIME_SIZE);
                return localTime2Date(dt);
            }

            if (isUTCTime(dateAndTime)) {
                return utcTime2Date(dateAndTime);
            }
            if (dateAndTime.length > UTCTIME_SIZE) {
                byte[] dt = new byte[UTCTIME_SIZE];
                System.arraycopy(dateAndTime, 0, dt, 0, UTCTIME_SIZE);
                return utcTime2Date(dt);
            }
        }

        return null;
    }

    private static String format(int nHour, int nMinute) {
        String strHour = String.valueOf(nHour);
        if ((nHour >= 0) && (nHour <= 9)) {
            strHour = "0" + String.valueOf(nHour);
        }

        String strMin = String.valueOf(nMinute);
        if ((nMinute >= 0) && (nMinute <= 9)) {
            strMin = "0" + String.valueOf(nMinute);
        }

        return (strHour + ":" + strMin);
    }

    private static String getTimeZoneID(byte byte1, byte byte2, byte byte3) {
        int sign = byte2Int(byte1);
        int nHour = byte2Int(byte2);
        int nMinute = byte2Int(byte3);
        String tzID = null;

        switch (sign) {
        // '+' sign
        case 0x2B: {
            tzID = TIMEZONE_GMT + "+" + format(nHour, nMinute);
        }
            break;

        // '-' sign
        case 0x2D: {
            tzID = TIMEZONE_GMT + "-" + format(nHour, nMinute);
        }
            break;

        }

        return tzID;
    }

    public static Date utcTime2Date(byte[] utcTime) {
        if (!isUTCTime(utcTime))
            return null;

        try {
            int nYear = bytes2Int(utcTime[0], utcTime[1]);
            int nMonth = byte2Int(utcTime[2]);
            int nDay = byte2Int(utcTime[3]);
            int nHour = byte2Int(utcTime[4]);
            int nMinute = byte2Int(utcTime[5]);
            int nSecond = byte2Int(utcTime[6]);
//            int nMilliSecond = byte2Int(utcTime[7]);

            String tzID = getTimeZoneID(utcTime[8], utcTime[9], utcTime[10]);
            if (tzID == null) {
                Calendar rightNow = Calendar.getInstance();
                rightNow.set(nYear, nMonth - 1, nDay, nHour, nMinute, nSecond);

                return (rightNow.getTime());
            }

            TimeZone tz = TimeZone.getTimeZone(tzID);
            Calendar rightNow = Calendar.getInstance(tz);
            rightNow.set(nYear, nMonth - 1, nDay, nHour, nMinute, nSecond);
            
            rightNow.set(Calendar.MILLISECOND, 0);
            
            return (rightNow.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static long getDateAndTimeFromSnmpVar(SnmpVar sv) {
        Date date = bytes2Date(sv.toBytes());
        if (date == null) {
            return (new Date()).getTime();
        } else {
            return date.getTime();
        }
    }

    static public String getStringSeverity(int severity) {
        switch (severity) {
        case CRITICAL:
            return "Critical";
        case MAJOR:
            return "Major";
        case MINOR:
            return "Minor";
        case WARNING:
            return "Warning";
        case CLEAR:
            return "Clear";
        default:
            return "Unknow";
        }
    }

    static public Color getColor(int severity) {
        switch (severity) {
        case CRITICAL:
            return new Color(255, 0, 0);
        case MAJOR:
            return new Color(255, 200, 0);
        case MINOR:
            return new Color(255, 255, 0);
        case WARNING:
            return new Color(0, 255, 255);
        case CLEAR:
            return new Color(51, 255, 51);
        default:
            return null;
        }
    }

    static public int getIntSeverity(String severity) {
        if (severity.equalsIgnoreCase("Critical"))
            return CRITICAL;
        if (severity.equalsIgnoreCase("Major"))
            return MAJOR;
        if (severity.equalsIgnoreCase("Minor"))
            return MINOR;
        if (severity.equalsIgnoreCase("Warning"))
            return WARNING;
        if (severity.equalsIgnoreCase("Clear"))
            return CLEAR;
        return UNKNOW;
    }

}
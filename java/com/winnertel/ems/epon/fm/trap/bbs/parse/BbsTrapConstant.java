/**
 * Created by Zhou Chao, 2009/7/20
 */

package com.winnertel.ems.epon.fm.trap.bbs.parse;

public interface BbsTrapConstant {

    public static final String ACTIVE_ALARM_TABLE = "utsBbsAlarmActiveTable";

    public static final String ACTIVE_ALARM_TABLE_VERSION = "1.0.0";

    public static final String HISTORY_ALARM_TABLE = "utsBbsAlarmHistoryTable";

    public static final String HISTORY_ALARM_TABLE_VERSION = "1.0.0";

    /**
     * It's for trap
     */
    public static final int NOTIFY_ID = 1;
    public static final String utsBbsAlarmTrap = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.1.1";
    public static final String utsBbsAlarmSessionId = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.1";
    public static final String utsBbsAlarmSequenceNumber = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.2";
    public static final String utsBbsAlarmTime = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.3";
    public static final String utsBbsAlarmClass = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.4";
    public static final String utsBbsAlarmEntityType = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.5";
    public static final String utsBbsAlarmEntityInstance = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.6";
    public static final String utsBbsAlarmSeverity = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.7";
    public static final String utsBbsAlarmProbableCause = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.8";
    public static final String utsBbsAlarmSpecificProblem = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.9";
    public static final String utsBbsAlarmVersionId = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.10";
    public static final String utsBbsAlarmCorrelationId = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.11";
    public static final String utsBbsAlarmSourceIp = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.12";
    public static final String utsBbsAlarmAdditionalText = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.13";

    public static final String utsBbsEventTrap = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.1.2";
    public static final String utsBbsEventType = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.14";

    public static final String utsBbsAlarmDeviceType = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.2.2.15";

    /**
     * It's for active alarm
     */
    public static final String utsBbsAlarmActiveSequenceNumber = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.1";
    public static final String utsBbsAlarmActiveProbableCause = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.2";
    public static final String utsBbsAlarmActiveSpecificProblem = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.3";
    public static final String utsBbsAlarmActiveEntityType = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.4";
    public static final String utsBbsAlarmActiveEntityInstance = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.5";
    public static final String utsBbsAlarmActiveFirstOccurenceTime = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.6";
    public static final String utsBbsAlarmActiveClass = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.7";
    public static final String utsBbsAlarmActiveSeverity = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.8";
    public static final String utsBbsAlarmActiveAcknowledge = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.9";
    public static final String utsBbsAlarmActiveAdditionalText = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.10";
    public static final String utsBbsAlarmActiveRaisingNumber = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.11";
    public static final String utsBbsAlarmActiveLastOccurenceTime = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.12";
    public static final String utsBbsAlarmActiveRepeats = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.13";
    public static final String utsBbsAlarmActiveVersionId = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.14";
    public static final String utsBbsAlarmActiveSessionId = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.1.1.15";

    /**
     * It's for history alarm
     */
    public static final String utsBbsAlarmHistorySequenceNumber = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.1";
    public static final String utsBbsAlarmHistoryProbableCause = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.2";
    public static final String utsBbsAlarmHistorySpecificProblem = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.3";
    public static final String utsBbsAlarmHistoryEntityType = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.4";
    public static final String utsBbsAlarmHistoryEntityInstance = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.5";
    public static final String utsBbsAlarmHistoryFirstOccurenceTime = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.6";
    public static final String utsBbsAlarmHistoryClass = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.7";
    public static final String utsBbsAlarmHistorySeverity = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.8";
    public static final String utsBbsAlarmHistoryCorrelationId = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.9";
    public static final String utsBbsAlarmHistoryAdditionalText = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.10";
    public static final String utsBbsAlarmHistoryRaisingNumber = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.11";
    public static final String utsBbsAlarmHistoryLastOccurenceTime = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.12";
    public static final String utsBbsAlarmHistoryRepeats = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.13";
    public static final String utsBbsAlarmHistoryVersionId = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.14";
    public static final String utsBbsAlarmHistorySessionId = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.15";
    public static final String utsBbsAlarmHistoryClearTime = ".1.3.6.1.4.1.41355.1.3.10.200.6.7.1.1.2.2.3.1.16";

}
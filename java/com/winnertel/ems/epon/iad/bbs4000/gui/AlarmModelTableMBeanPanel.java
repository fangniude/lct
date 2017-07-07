package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.AlarmModelTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

//import com.winnertel.em.standard.util.gui.layout.HSpacer;

/**
 * The AlarmModelTableMBeanPanel class.
 * Created by DVM Creator
 */
public class AlarmModelTableMBeanPanel extends UPanel {


    private int[] utAlarmModelSeverityVList = new int[]{
         1, 2, 3, 4, 5, };
    private String[] utAlarmModelSeverityTList = new String[]{
        fStringMap.getString("alarmLevelWarning"),
        fStringMap.getString("alarmLevelMinor"),
        fStringMap.getString("alarmLevelMajor"),
        fStringMap.getString("alarmLevelCritical"),
        fStringMap.getString("alarmLevelIndeterminate"),
    };
    private JComboBox tfUtAlarmModelSeverity = new JComboBox(utAlarmModelSeverityTList);
    private int[] utAlarmModelTypeVList = new int[]{
        2, 3, 4, 10, 11, };
    private String[] utAlarmModelTypeTList = new String[]{
        fStringMap.getString("alarmTypeCommunication"),
        fStringMap.getString("alarmTypeEquipment"),
        fStringMap.getString("alarmTypeEnvironmental"),
        fStringMap.getString("alarmTypeProcessingError"),
        fStringMap.getString("alarmTypeQualityOfService"),
    };
    private JComboBox tfUtAlarmModelType = new JComboBox(utAlarmModelTypeTList);
//    private int[] utAlarmModelProbableCauseVList = new int[]{
//        558, 10, 503, 36, 69, 200, 237, 53, 6, 7, 531, 207, 506, 17, 501, 58, 20,
//        556, 13, 56, 60, 12, 561, 1, 538, 536, 55, 221, 5, 547, 236, 27, 214, 548,
//        63, 544, 505, 45, 23, 67, 3, 560, 529, 38, 64, 217, 509, 52, 528, 533, 66,
//        1000, 47, 59, 25, 73, 39, 49, 219, 65, 522, 61, 74, 541, 223, 535, 224, 225,
//        226, 209, 206, 215, 229, 504, 72, 557, 34, 29, 540, 555, 51, 44, 203, 218,
//        546, 537, 526, 500, 534, 234, 37, 211, 14, 212, 26, 46, 31, 43, 525, 238,
//        2, 42, 512, 33, 30, 228, 227, 513, 524, 532, 16, 239, 222, 28, 32, 50, 520,
//        70, 559, 517, 542, 230, 210, 62, 502, 553, 519, 213, 201, 523, 15, 22, 511,
//        4, 204, 68, 48, 220, 8, 208, 539, 510, 24, 57, 21, 232, 205, 507, 514, 549,
//        527, 233, 9, 202, 521, 71, 543, 216, 554, 231, 550, 19, 54, 11, 545, 552,
//        516, 41, 530, 515, 40, 18, 235, 518, 75, 551, 508, 35, };
//    private String[] utAlarmModelProbableCauseTList = new String[]{
//        fStringMap.getString("probableCauseLocalAlarmIndication"),
//        fStringMap.getString("probableCausePayloadTypeMismatch"),
//        fStringMap.getString("probableCauseBatteryBreakdown"),
//        fStringMap.getString("probableCauseReplaceableUnitProblem"),
//        fStringMap.getString("probableCauseToxicGas"),
//        fStringMap.getString("probableCauseAdapterError"),
//        fStringMap.getString("probableCauseTransmitFailure"),
//        fStringMap.getString("probableCauseVentilationSystemFailure"),
//        fStringMap.getString("probableCauseFramingError"),
//        fStringMap.getString("probableCauseLossOfFrame"),
//        fStringMap.getString("probableCauseTransmitterAntennaNotAdjusted"),
//        fStringMap.getString("probableCauseCpuCyclesLimitExceeded"),
//        fStringMap.getString("probableCauseCombinerProblem"),
//        fStringMap.getString("probableCauseLossOfMultiFrame"),
//        fStringMap.getString("probableCauseAbisToTRXInterfaceFailure"),
//        fStringMap.getString("probableCauseHighHumidity"),
//        fStringMap.getString("probableCauseEquipmentIdentifierDuplication"),
//        fStringMap.getString("probableCauseInvalidMSUReceived"),
//        fStringMap.getString("probableCauseExcessiveBitErrorRate"),
//        fStringMap.getString("probableCauseFireDetected"),
//        fStringMap.getString("probableCauseHighWind"),
//        fStringMap.getString("probableCauseRemoteAlarmInterface"),
//        fStringMap.getString("probableCauseSs7ProtocolFailure"),
//        fStringMap.getString("probableCauseIndeterminate"),
//        fStringMap.getString("probableCauseInvalidPointer"),
//        fStringMap.getString("probableCauseInputParameterOutOfRange"),
//        fStringMap.getString("probableCauseExplosiveGas"),
//        fStringMap.getString("probableCauseOutOfMemory"),
//        fStringMap.getString("probableCauseFarEndReceiverFailure"),
//        fStringMap.getString("probableCauseExternalPowerSupplyFailure"),
//        fStringMap.getString("probableCauseToxicLeakDetected"),
//        fStringMap.getString("probableCauseProtectionPathFailure"),
//        fStringMap.getString("probableCauseHumidityUnacceptable"),
//        fStringMap.getString("probableCauseExternalTransmissionDeviceFailure"),
//        fStringMap.getString("probableCauseLowFuel"),
//        fStringMap.getString("probableCauseVariableOutOfRange"),
//        fStringMap.getString("probableCauseClockSynchronisationProblem"),
//        fStringMap.getString("probableCauseFireDetectorFailure"),
//        fStringMap.getString("probableCauseMultiplexerProblem"),
//        fStringMap.getString("probableCauseLowWater"),
//        fStringMap.getString("probableCauseCallSetupFailure"),
//        fStringMap.getString("probableCauseRoutingFailure"),
//        fStringMap.getString("probableCauseTranscoderOrRateAdapterProblem"),
//        fStringMap.getString("probableCauseAirConditioningFailure"),
//        fStringMap.getString("probableCauseLowHumidity"),
//        fStringMap.getString("probableCauseLanError"),
//        fStringMap.getString("probableCauseExcessiveReceiverTemperature"),
//        fStringMap.getString("probableCauseRectifierLowFVoltage"),
//        fStringMap.getString("probableCauseTranscoderProblem"),
//        fStringMap.getString("probableCauseTransmitterOffFrequency"),
//        fStringMap.getString("probableCauseLowTemperature"),
//        fStringMap.getString("probableCauseTca"),
//        fStringMap.getString("probableCauseGeneratorFailure"),
//        fStringMap.getString("probableCauseHighTemperature"),
//        fStringMap.getString("probableCausePowerProblem"),
//        fStringMap.getString("probableCauseOutOfCPUCycles"),
//        fStringMap.getString("probableCauseAirDryerFailure"),
//        fStringMap.getString("probableCausePumpFailure"),
//        fStringMap.getString("probableCauseLocalNodeTransmissionError"),
//        fStringMap.getString("probableCauseLowCablePressure"),
//        fStringMap.getString("probableCauseReceiverAntennaFault"),
//        fStringMap.getString("probableCauseIceBuildUp"),
//        fStringMap.getString("probableCauseSoftwareEnvironmentProblem"),
//        fStringMap.getString("probableCauseMessageOutOfSequence"),
//        fStringMap.getString("probableCausePerformanceDegraded"),
//        fStringMap.getString("probableCauseFileSystemCallUnsuccessful"),
//        fStringMap.getString("probableCausePressureUnacceptable"),
//        fStringMap.getString("probableCauseQueueSizeExceeded"),
//        fStringMap.getString("probableCauseReceiveFailure"),
//        fStringMap.getString("probableCauseDteDceInterfaceError"),
//        fStringMap.getString("probableCauseCongestion"),
//        fStringMap.getString("probableCauseInputOutputDeviceError"),
//        fStringMap.getString("probableCauseResponseTimeExcessive"),
//        fStringMap.getString("probableCauseBatteryChargingFault"),
//        fStringMap.getString("probableCauseCorruptData"),
//        fStringMap.getString("probableCauseLapdLinkProtocolFailure"),
//        fStringMap.getString("probableCauseTransmitterFailure"),
//        fStringMap.getString("probableCauseReplaceableUnitMissing"),
//        fStringMap.getString("probableCauseMessageNotInitialised"),
//        fStringMap.getString("probableCauseInvalidMessageReceived"),
//        fStringMap.getString("probableCauseRectifierHighVoltage"),
//        fStringMap.getString("probableCauseEngineFailure"),
//        fStringMap.getString("probableCauseCommunicationProtocolError"),
//        fStringMap.getString("probableCauseLeakDetection"),
//        fStringMap.getString("probableCauseCoolingSystemFailure"),
//        fStringMap.getString("probableCauseInvalidParameter"),
//        fStringMap.getString("probableCauseTimeslotHardwareFailure"),
//        fStringMap.getString("probableCauseAbisToBTSInterfaceFailure"),
//        fStringMap.getString("probableCauseDatabaseInconsistency"),
//        fStringMap.getString("probableCauseTemperatureUnacceptable"),
//        fStringMap.getString("probableCauseAirCompressorFailure"),
//        fStringMap.getString("probableCauseExcessiveVibration"),
//        fStringMap.getString("probableCausePathTraceMismatch"),
//        fStringMap.getString("probableCauseFileError"),
//        fStringMap.getString("probableCauseProcessorProblem"),
//        fStringMap.getString("probableCauseFuseFailure"),
//        fStringMap.getString("probableCauseSynchronisationSourceMismatch"),
//        fStringMap.getString("probableCauseCoolingFanFailure"),
//        fStringMap.getString("probableCauseSignalQualityEvaluationFault"),
//        fStringMap.getString("probableCauseUnderlyingResourceUnavailable"),
//        fStringMap.getString("probableCauseAlarmIndicationSignal"),
//        fStringMap.getString("probableCauseCommercialPowerFailure"),
//        fStringMap.getString("probableCauseFrequencyHoppingDegraded"),
//        fStringMap.getString("probableCauseTimingProblem"),
//        fStringMap.getString("probableCauseReplaceableUnitTypeMismatch"),
//        fStringMap.getString("probableCauseResourceAtOrNearingCapacity"),
//        fStringMap.getString("probableCauseRemoteNodeTransmissionError"),
//        fStringMap.getString("probableCauseFrequencyHoppingFailure"),
//        fStringMap.getString("probableCauseReducedTransmitterOutputPower"),
//        fStringMap.getString("probableCauseTransmitterLowVoltageOrCurrent"),
//        fStringMap.getString("probableCauseSignalLabelMismatch"),
//        fStringMap.getString("probableCauseVersionMismatch"),
//        fStringMap.getString("probableCauseOutputDeviceError"),
//        fStringMap.getString("probableCauseReceiverFailure"),
//        fStringMap.getString("probableCauseTerminalProblem"),
//        fStringMap.getString("probableCauseRectifierFailure"),
//        fStringMap.getString("probableCauseMainsBreakdownWithoutBatteryBackup"),
//        fStringMap.getString("probableCauseStorageCapacityProblem"),
//        fStringMap.getString("probableCauseRemoteAlarmIndication"),
//        fStringMap.getString("probableCauseLossOfSynchronisation"),
//        fStringMap.getString("probableCauseSystemCallUnsuccessful"),
//        fStringMap.getString("probableCauseRetransmissionRateExcessive"),
//        fStringMap.getString("probableCauseEquipmentMalfunction"),
//        fStringMap.getString("probableCauseIntrusionDetection"),
//        fStringMap.getString("probableCauseAntennaProblem"),
//        fStringMap.getString("probableCauseBroadcastChannelFailure"),
//        fStringMap.getString("probableCauseMainsBreakdownWithBatteryBackup"),
//        fStringMap.getString("probableCauseHeatingOrVentilationOrCoolingSystemProblem"),
//        fStringMap.getString("probableCauseApplicationSubsystemFailure"),
//        fStringMap.getString("probableCauseReceiverMulticouplerFailure"),
//        fStringMap.getString("probableCauseUnavailable"),
//        fStringMap.getString("probableCauseLineCardProblem"),
//        fStringMap.getString("probableCauseExcessiveTransmitterTemperature"),
//        fStringMap.getString("probableCauseDegradedSignal"),
//        fStringMap.getString("probableCauseCommunicationSubsystemFailure"),
//        fStringMap.getString("probableCauseSmokeDetected"),
//        fStringMap.getString("probableCauseLowBatteryThreshold"),
//        fStringMap.getString("probableCauseMaterialSupplyExhausted"),
//        fStringMap.getString("probableCauseLossOfPointer"),
//        fStringMap.getString("probableCauseDataSetOrModemError"),
//        fStringMap.getString("probableCauseMessageNotExpected"),
//        fStringMap.getString("probableCauseExcessiveTransmitterOutputPower"),
//        fStringMap.getString("probableCauseNeIdentifierDuplication"),
//        fStringMap.getString("probableCauseFloodDetected"),
//        fStringMap.getString("probableCauseExternalInterfaceDeviceProblem"),
//        fStringMap.getString("probableCauseSoftwareProgramAbnormallyTerminated"),
//        fStringMap.getString("probableCauseConfigurationOrCustomizingError"),
//        fStringMap.getString("probableCauseDiskProblem"),
//        fStringMap.getString("probableCauseFrequencyRedefinitionFailed"),
//        fStringMap.getString("probableCauseReducedAlarmReporting"),
//        fStringMap.getString("probableCauseTransceiverProblem"),
//        fStringMap.getString("probableCauseSoftwareProgramError"),
//        fStringMap.getString("probableCauseLossOfSignal"),
//        fStringMap.getString("probableCauseBandwidthReduction"),
//        fStringMap.getString("probableCausePowerSupplyFailure"),
//        fStringMap.getString("probableCauseMemoryMismatch"),
//        fStringMap.getString("probableCauseTimeoutExpired"),
//        fStringMap.getString("probableCauseInputDeviceError"),
//        fStringMap.getString("probableCauseConnectionEstablishmentError"),
//        fStringMap.getString("probableCauseSoftwareError"),
//        fStringMap.getString("probableCauseReducedEventReporting"),
//        fStringMap.getString("probableCauseDataSetProblem"),
//        fStringMap.getString("probableCauseEnclosureDoorOpen"),
//        fStringMap.getString("probableCauseTransmissionError"),
//        fStringMap.getString("probableCauseWatchDogTimerExpired"),
//        fStringMap.getString("probableCauseSystemResourcesOverload"),
//        fStringMap.getString("probableCauseLinkFailure"),
//        fStringMap.getString("probableCauseBatteryFailure"),
//        fStringMap.getString("probableCauseTransmitterAntennaFailure"),
//        fStringMap.getString("probableCauseLineInterfaceFailure"),
//        fStringMap.getString("probableCauseBatteryDischarging"),
//        fStringMap.getString("probableCauseBackPlaneFailure"),
//        fStringMap.getString("probableCauseThresholdCrossed"),
//        fStringMap.getString("probableCauseLostRedundancy"),
//        fStringMap.getString("probableCauseSoftwareDownloadFailure"),
//        fStringMap.getString("probableCauseReducedLoggingCapability"),
//        fStringMap.getString("probableCauseEquipmentFailure"),
//        fStringMap.getString("probableCauseTrunkCardProblem"),
//    };
//    private JComboBox tfUtAlarmModelProbableCause = new JComboBox(utAlarmModelProbableCauseTList);
//    private int[] utAlarmModelClearTypeVList = new int[]{
//        1, 0, };
//    private String[] utAlarmModelClearTypeTList = new String[]{
//        fStringMap.getString("adac"),
//        fStringMap.getString("admc"),
//    };
//    private JComboBox tfUtAlarmModelClearType = new JComboBox(utAlarmModelClearTypeTList);
//    private int[] utAlarmModelResourceTypeVList = new int[]{
//        81, 115, 118, 37, 50, 33, 51, 32, 86, 1, 45, 71, 34, 44, 87, 29, 28, 72,
//        4, 74, 79, 22, 23, 40, 113, 49, 47, 46, 7, 84, 83, 6, 0, 36, 5, 41, 24, 3,
//        35, 119, 43, 120, 30, 26, 82, 48, 117, 76, 85, 78, 111, 31, 75, 2, 77, 116,
//        25, 114, 42, 80, 121, 38, 151, 27, 39, 73, 112, 21, };
//    private String[] utAlarmModelResourceTypeTList = new String[]{
//        fStringMap.getString("alarmResourceTrunkCircuit"),
//        fStringMap.getString("alarmResourcePlatformMgmtChannel"),
//        fStringMap.getString("alarmResourceUsrDialog"),
//        fStringMap.getString("alarmResourceMapLgProtocol"),
//        fStringMap.getString("alarmResourceAlCapProtocol"),
//        fStringMap.getString("alarmResourceMapGProtocol"),
//        fStringMap.getString("alarmResourceGtpUProtocol"),
//        fStringMap.getString("alarmResourceMapEProtocol"),
//        fStringMap.getString("alarmResourceAal2Pvc"),
//        fStringMap.getString("alarmResourceInnerSofModuleComm"),
//        fStringMap.getString("alarmResourceSmProtocol"),
//        fStringMap.getString("alarmResourceMtp3link"),
//        fStringMap.getString("alarmResourceMapGrProtocol"),
//        fStringMap.getString("alarmResourceBssapProtocol"),
//        fStringMap.getString("alarmResourceAal5Pvc"),
//        fStringMap.getString("alarmResourceMapGdProtocol"),
//        fStringMap.getString("alarmResourceMapBProtocol"),
//        fStringMap.getString("alarmResourceMtp3linkSet"),
//        fStringMap.getString("alarmResourcePlatformSoft"),
//        fStringMap.getString("alarmResourceMtp3BLink"),
//        fStringMap.getString("alarmResourceM3uaPs"),
//        fStringMap.getString("alarmResourceMtp2Protocol"),
//        fStringMap.getString("alarmResourceMtp3Protocol"),
//        fStringMap.getString("alarmResourceInapProtcol"),
//        fStringMap.getString("alarmResourceHwRcsource"),
//        fStringMap.getString("alarmResourceStcProtocol"),
//        fStringMap.getString("alarmResourceGiInterface"),
//        fStringMap.getString("alarmResourceSgsnSmProtocol"),
//        fStringMap.getString("alarmResourceNeExtComm"),
//        fStringMap.getString("alarmResourceIpLink"),
//        fStringMap.getString("alarmResourceStmlink"),
//        fStringMap.getString("alarmResourceInterSoftModule"),
//        fStringMap.getString("alarmResourceTypeDefault"),
//        fStringMap.getString("alarmResourceMapLhProtocol"),
//        fStringMap.getString("alarmResourceSoftModule"),
//        fStringMap.getString("alarmResourceGtpProtocol"),
//        fStringMap.getString("alarmResourceM3uaProtocol"),
//        fStringMap.getString("alarmResourceInterBoardComm"),
//        fStringMap.getString("alarmResourceMapGcProtocol"),
//        fStringMap.getString("alarmResourceDbConn"),
//        fStringMap.getString("alarmResourceGmmProtocol"),
//        fStringMap.getString("alarmResourceAuthentication"),
//        fStringMap.getString("alarmResourceMapCProtocol"),
//        fStringMap.getString("alarmResourceIsupProtocol"),
//        fStringMap.getString("alarmResourceH110TimeSlot"),
//        fStringMap.getString("alarmResourceImaProtocol"),
//        fStringMap.getString("alarmResourceCpHaControl"),
//        fStringMap.getString("alarmResourceMtp3BRouteSet"),
//        fStringMap.getString("alarmResourceSccopLink"),
//        fStringMap.getString("alarmResourceM3uaPsp"),
//        fStringMap.getString("alarmResourceCdr"),
//        fStringMap.getString("alarmResourceMapDProtocol"),
//        fStringMap.getString("alarmResourceMtp3BLinkSet"),
//        fStringMap.getString("alarmResourceGenSoftErr"),
//        fStringMap.getString("alarmResourceAssociation"),
//        fStringMap.getString("alarmResourceIpOrMacAddr"),
//        fStringMap.getString("alarmResourceSccpProtocol"),
//        fStringMap.getString("alarmResourceSaFailure"),
//        fStringMap.getString("alarmResourceMegacoProtocol"),
//        fStringMap.getString("alarmResourceTrunk"),
//        fStringMap.getString("alarmResourceGmlcRoute"),
//        fStringMap.getString("alarmResourceSaalProtocol"),
//        fStringMap.getString("alarmResourceTca"),
//        fStringMap.getString("alarmResourceRanapProtocol"),
//        fStringMap.getString("alarmResourceCapProtocol"),
//        fStringMap.getString("alarmResourceMtp3RouteSet"),
//        fStringMap.getString("alarmResourceCell"),
//        fStringMap.getString("alarmResourceMtp1Protocol"),
//    };
//    private JComboBox tfUtAlarmModelResourceType = new JComboBox(utAlarmModelResourceTypeTList);
    private int[] utAlarmModelFilteredFlagVList = new int[]{
        1, 0, };
    private String[] utAlarmModelFilteredFlagTList = new String[]{
        fStringMap.getString("Enable"),
        fStringMap.getString("Disable"),
    };
    private JComboBox tfUtAlarmModelFilteredFlag = new JComboBox(utAlarmModelFilteredFlagTList);


//    private final String utAlarmModelOID = fStringMap.getString("utAlarmModelOID") + " : ";
    private final String utAlarmModelSeverity = fStringMap.getString("utAlarmModelSeverity") + " : ";
    private final String utAlarmModelType = fStringMap.getString("utAlarmModelType") + " : ";
//    private final String utAlarmModelProbableCause = fStringMap.getString("utAlarmModelProbableCause") + " : ";
//    private final String utAlarmModelClearType = fStringMap.getString("utAlarmModelClearType") + " : ";
//    private final String utAlarmModelResourceType = fStringMap.getString("utAlarmModelResourceType") + " : ";
    private final String utAlarmModelFilteredFlag = fStringMap.getString("utAlarmModelFilteredFlag") + " : ";


    public AlarmModelTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

//        baseInfoPanel.add(new JLabel(utAlarmModelOID));
////        baseInfoPanel.add( cbUtAlarmModelOID) ;
//        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utAlarmModelSeverity));
        tfUtAlarmModelSeverity.setName(fStringMap.getString("utAlarmModelSeverity"));
        baseInfoPanel.add(tfUtAlarmModelSeverity);


        baseInfoPanel.add(new JLabel(utAlarmModelType));
        tfUtAlarmModelType.setName(fStringMap.getString("utAlarmModelType"));
        baseInfoPanel.add(tfUtAlarmModelType);


//        baseInfoPanel.add(new JLabel(utAlarmModelProbableCause));
//        baseInfoPanel.add(tfUtAlarmModelProbableCause);


//        baseInfoPanel.add(new JLabel(utAlarmModelClearType));
//        baseInfoPanel.add(tfUtAlarmModelClearType);
//
//
//        baseInfoPanel.add(new JLabel(utAlarmModelResourceType));
//        baseInfoPanel.add(tfUtAlarmModelResourceType);


        baseInfoPanel.add(new JLabel(utAlarmModelFilteredFlag));
        tfUtAlarmModelFilteredFlag.setName(fStringMap.getString("utAlarmModelFilteredFlag"));
        baseInfoPanel.add(tfUtAlarmModelFilteredFlag);


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);


    }

    protected void initForm() {


    }

    public void refresh() {

        if (SnmpAction.IType.ADD.equals(fCommand)) {


            return;
        }

        AlarmModelTableMBean mbean = (AlarmModelTableMBean) getModel();

//          cbUtAlarmModelOID.setText(mbean.getUtAlarmModelOID());
        tfUtAlarmModelSeverity.setSelectedIndex(getIndexFromValue(utAlarmModelSeverityVList, mbean.getUtAlarmModelSeverity().intValue()));
        tfUtAlarmModelType.setSelectedIndex(getIndexFromValue(utAlarmModelTypeVList, mbean.getUtAlarmModelType().intValue()));
//        tfUtAlarmModelProbableCause.setSelectedIndex(getIndexFromValue(utAlarmModelProbableCauseVList, mbean.getUtAlarmModelProbableCause().intValue()));
//        tfUtAlarmModelClearType.setSelectedIndex(getIndexFromValue(utAlarmModelClearTypeVList, mbean.getUtAlarmModelClearType().intValue()));
//        tfUtAlarmModelResourceType.setSelectedIndex(getIndexFromValue(utAlarmModelResourceTypeVList, mbean.getUtAlarmModelResourceType().intValue()));
        tfUtAlarmModelFilteredFlag.setSelectedIndex(getIndexFromValue(utAlarmModelFilteredFlagVList, mbean.getUtAlarmModelFilteredFlag().intValue()));

    }

    public void updateModel() {

        AlarmModelTableMBean mbean = (AlarmModelTableMBean) getModel();


        mbean.setUtAlarmModelSeverity(new Integer(utAlarmModelSeverityVList[tfUtAlarmModelSeverity.getSelectedIndex()]));
        mbean.setUtAlarmModelType(new Integer(utAlarmModelTypeVList[tfUtAlarmModelType.getSelectedIndex()]));


        mbean.setUtAlarmModelFilteredFlag(new Integer(utAlarmModelFilteredFlagVList[tfUtAlarmModelFilteredFlag.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

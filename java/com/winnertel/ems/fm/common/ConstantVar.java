package com.winnertel.ems.fm.common;

/**
 * Title: ConstantVar.java
 * Description: This interface defines constant value used in alarm module
 * Copyright: Copyright (c) 2001
 * Company: UTStarcom
 * 
 * @author Henry Wang
 * @version Demo 1.0
 */

public interface ConstantVar {
    public static final int OTHER_TYPE = 0;
    public static final int AN_NODE_TYPE = 1;
    public static final int AN_OLDNODE_TYPE = 2;
    public static final int IPDSLAM_NODE_TYPE = 3;
    public static final int ATMMINIDSLAM_NODE_TYPE = 4;
    public static final int IPMINIDSLAMATM_NODE_TYPE = 5;

    static final String TRAP_AN2000_OLD = "2.2.1.98";
    static final String TRAP_AN2000_ALARM = "2.2.100.1";
    static final String TRAP_AN2000_EVENT = "2.2.100.2";
    static final String TRAP_AN2000_TRAPACK = "2.2.100.4";

    static final String TRAP_AN2000_SWITCHOVER = "2.2.100.11";
    static final String TRAP_AN2000_VERIFYREQ = "2.2.100.12";
    static final String TRAP_AN2000_VERIFYREMOTEPROV = "2.2.100.13";
    static final String TRAP_AN2000_BLOCKINGSTARTED = "2.2.100.14";
    static final String TRAP_AN2000_REQREMOTEPROV = "2.2.100.15";
    static final String TRAP_AN2000_SWITCHOVERTONEW = "2.2.100.16";
    static final String TRAP_OMUX300A = "3.5.100.1";
    static final String TRAP_OMUX400A = "3.4.100.1";
    // Old OMUX traps
    static final String TRAP_OMUX200P_MODULE = "3.2.1.2";
    static final String TRAP_OMUX200P_ALARM = "3.2.1.3";
    static final String TRAP_OMUX300_ALARM = "3.3.1.3";
    static final String TRAP_OMUX300A_MODULE = "3.5.1.2";
    static final String TRAP_OMUX300A_ALARM = "3.5.1.3";
    static final String TRAP_OMUX300A_RINGPROTECTION = "3.5.1.16";
    static final String TRAP_OMUX400_MODULE = "3.4.1.2";
    static final String TRAP_OMUX400_ALARM = "3.4.1.3";
    static final String TRAP_OMUX400_RINGPROTECTION = "3.4.1.16";
    // End of old OMUX traps
    static final int ENT_PLACEHOLDER = -1; // For places where alarmpanel needs
                                           // to be grayed out.
    static final int ENT_NODE = 0;
    static final int ENT_SHELF = 1;
    static final int ENT_BOARD = 2;
    static final int ENT_PORT = 3;

    static final int ENT_SYSTEM = 4;

    static final int ENT_E1_TP = 5;
    static final int ENT_E1_PORT = 5;
    static final int ENT_BRI_TP = 6;
    static final int ENT_BRI_PORT = 6;
    static final int ENT_FXS_TP = 7;
    static final int ENT_FXS_PORT = 7;
    static final int ENT_FXO_TP = 8;
    static final int ENT_FXO_PORT = 8;
    static final int ENT_ENM_TP = 9;
    static final int ENT_ENM_PORT = 9;
    static final int ENT_STM1_TP = 10;
    static final int ENT_STM1_PORT = 10;
    static final int ENT_HDSL_PORT = 11;
    static final int ENT_V35_PORT = 12;

    static final int ENT_SIGNALING = 13;
    static final int ENT_V5_SIGNALING = 14; // this is interface

    static final int ENT_DATA = 15;
    static final int ENT_IP = 16;
    static final int ENT_ETHER = 17;
    static final int ENT_RTM = 18;
    static final int ENT_HDSL_TP = 19;
    static final int ENT_NTU = 20;

    static final int ENT_ALL_V5_SIGNALING = 21;
    static final int ENT_EQUIP = 22;/* Equipment */
    static final int ENT_CLOCK = 23;/* Clock related alarms */
    static final int ENT_FUSE = 24;/* Clock related alarms */
    static final int ENT_RINGER = 25;/* Clock related alarms */
    static final int ENT_EXTERNAL = 26;/* External alarms */
    static final int ENT_LVDS_IF = 27;
    static final int ENT_TDM_PHY_IF = 28;
    static final int ENT_ATM_IF = 29;
    static final int ENT_ADSL_PORT = 30;
    static final int ENT_STM1_PORT2 = 31;
    static final int ENT_STM1_PATH = 32;
    static final int ENT_DCD_PORT = 33;
    static final int ENT_SDT12_PORT = 34;
    static final int ENT_SDT12_RS = 35;
    static final int ENT_SDT12_MS = 36;
    static final int ENT_SDT12_VC4 = 37;
    static final int ENT_SDT12_VC12 = 38;
    static final int ENT_SDT12_ASYNCE1 = 39;
    static final int ENT_SDT12_SYNCE1 = 40;
    static final int ENT_SDT12_DCC = 41;
    static final int ENT_ATM_VCL = 42;
    static final int ENT_ATM_VPL = 43;
    static final int ENT_ADSL_CHANNEL = 44;

    // for SDT2
    static final int ENT_SDT2_PORT = 146;
    static final int ENT_SDT2_RS = 147;
    static final int ENT_SDT2_MS = 148;
    static final int ENT_SDT2_VC4 = 149;
    static final int ENT_SDT2_VC12 = 150;
    static final int ENT_SDT2_ASYNCE1 = 151;
    static final int ENT_SDT2_SYNCE1 = 152;
    static final int ENT_SDT2_DCC = 153;
    static final int ENT_SDT2_VCL = 154;
    static final int ENT_SDT2_VPL = 155;

    // <<Add by Qian for MCU Alarm
    static final int ALARM_SPECIFIC_MCU_FIRST = 61;
    static final int ALARM_SPECIFIC_MCU_LAST = 78;
    static final int ALARM_SPECIFIC_MCU_CONF = 560;

    // >>
    // HCM and HDM port
    static final int ENT_HCM_PORT = 79;
    static final int ENT_HDM_PORT = 80;
    // ADD BY MHTIAN FOR iAN8000 2.0.1
    static final int ENT_PRJ_PORT = 81;
    static final int ENT_FAX_SERVICE = 272;
    static final int ENT_EBAM3 = 275;
    static final int ENT_STANDBY_SCM4 = 274;
    static final int ENT_SCM4 = 276;

    static final int ENT_SDT1_PSEUDO_E1 = 100;
    static final int ENT_SDT1_VC4 = 101;

    // For ICM Entity Type
    static final int ENT_ICM_EXTERANLPORT = 105;
    static final int ENT_ICM_INTERANLPORT = 106;
    static final int ENT_ICM_GIGABITPORT = 107;

    // Jim:
    // TODO: add this to properties file!
    static final int ENT_SCM3T_STM1_PORT = 110;
    static final int ENT_SCM3T_VC4 = 111;

    // For ETM T1 board
    static final int ENT_ETM_T1_PORT = 112;
    static final int ENT_SHDSL_PORT = 113;

    // For new ICM port mapping
    static final int ENT_INTERNAL_CRT = 116;
    static final int ENT_EXTERNAL_CRT = 115;

    static final int ENT_GR303_SIGNAL = 117;

    static final int ENT_SCM3T_PSEUDO_E1 = 121;

    // for ASM
    public static final int ENT_ASM_E1_PORT = 122;
    public static final int ENT_ASM_T1_PORT = 123;
    public static final int ENT_ASM_DS3_PORT = 124;
    public static final int ENT_ASM_E3_PORT = 125;
    public static final int ENT_ASM_STM1_PORT = 126;
    public static final int ENT_ASM_OC3_PORT = 127;
    public static final int ENT_ASM_STM4_PORT = 128;
    public static final int ENT_ASM_OC12_PORT = 129;
    public static final int ENT_ASM_IMA_LINK = 130;
    public static final int ENT_ASM_IMA_GROUP = 131;
    public static final int ENT_ASM_ATM = 132;
    public static final int ENT_ASM_VP = 133;
    public static final int ENT_ASM_VC = 134;
    public static final int ENT_ASM_ETH = 135;

    // For PAS ELU project
    static final int ENT_L2_SIGNALING = 256;
    static final int ENT_LAPD = 257;
    static final int ENT_L2_PRI = 258;
    static final int ENT_L2_BRI = 259;
    static final int ENT_LAPB = 260;
    static final int ENT_CALL_PROCESS = 261;
    static final int ENT_CP_PRI = 262;
    static final int ENT_CP_BRI = 263;
    static final int ENT_X25 = 264;
    static final int ENT_EOC = 265;
    static final int ENT_CS = 266;
    static final int ENT_NW_INTF = 267;
    static final int ENT_PIAFS_INTF = 268;
    static final int ENT_REMOTE_NODE = 278;

    // Added by Amit Bindal for SHTM - begin
    static final int ENT_SHTM_STU_C = 269;
    static final int ENT_SHTM_STU_R = 270;
    // Added by Amit Bindal for SHTM - end

    static final int ENT_IPADSL6_PORT = 279;
    static final int ENT_ATM_IF_48 = 280;
    static final int ENT_CHANNEL_48 = 281;
    static final int ENT_VPM = 282;
    static final int ENT_IVD = 277;

    static final int ENT_iE1M_VC = 283;
    static final int ENT_FXS9_PORT = 284;
    static final int ENT_EOEE1_PORT = 285;

    static final int ENT_VDSL_PORT = 279;// 286;
    // static final int ENT_VDSL_CHANNEL = 287;

    // pcu constant
    static final int ALARM_SPECIFIC_PCU_FIRST = 450;
    static final int ALARM_SPECIFIC_PCU_LAST = 457;

    static final int ENT_MAX = 512;

    // for B1205 Alarm
    static final int ENT_B1205_NODE = 1000;
    static final int ENT_B1205_SHELF = 1001;
    static final int ENT_B1205_MODULe = 1002;
    static final int ENT_B1205_CLOCK = 1003;
    static final int ENT_B1205_EXTERNAL = 1004;
    static final int ENT_B1205_CSM_POET = 1005;
    static final int ENT_B1205_V5_SIN = 1007;
    static final int ENT_B1205_V5_E1LINK = 1008;
    static final int ENT_B1205_E1_PORT = 1009;
    static final int ENT_B1205_MG = 1010;
    static final int ENT_B1205_FXS_SERVICE = 1011;
    static final int ENT_B1205_VPM_ETH_PORT = 1012;
    static final int ENT_B1205_FXS_PORT = 1013;
    static final int ENT_B1205_DSL_PORT = 1014;
    static final int ENT_B1205_SDL_CHANNEL = 1015;
    static final int ENT_B1205_PON_MODULE = 1016;
    static final int ENT_B1205_EPON_UPLINK = 1017;
    static final int ENT_B1205_FE_PORT = 1018;
    static final int ENT_B1205_ETHERNET_OAM = 1019;
    static final int ENT_B1205_GEM_PORT = 1020;

    // for B1205 Event's type
    static final int evTypeNodeStart = 10000;
    static final int evTypeModuleStart = 10001;
    static final int evTypeCSMStwitch = 10002;
    static final int evTypeCLICommand = 10003;
    static final int evTypeModuelFailed = 10004;
    static final int evTyptLogUpdate = 10005;

    static final int evTypeRegMGC = 11000;
    static final int evTypeDeregMGC = 11001;
    static final int evTypeMGSwitch = 11002;
    static final int evTypeFAXCall = 11005;

    static final int evTypeProtectionSwitch = 12000;
    static final int evTypeVariantSwitch = 12001;
    static final int evTypeVerifyRemote = 12002;
    static final int evTypeVerifyE1Link = 12003;

    static final int evTypeDSLPortUP = 13000;
    static final int evTypeDSLPortDown = 13001;
    static final int evTypeLineRateChange = 13002;
    static final int evTypeChangeL0ToL2 = 13003;
    static final int evTypeChangeL2ToL0 = 13004;
    static final int evTypeChangeL0ToL3 = 13005;
    static final int evTypeCahngeL3ToL0 = 13006;
    static final int evTypeMacDetected = 14000;
    static final int evTypeIPBingding = 14001;
    static final int evTypeMoreIPDetected = 14002;

    // for B1205 end

    static final int CHANNEL_NONE = 0;
    static final int CHANNEL_FAST = 1;
    static final int CHANNEL_INTERLEAVED = 2;
    // UNCP severity
    static final int UNCP_WARNING = 0;
    static final int UNCP_MINOR = 1;
    static final int UNCP_MAJOR = 2;
    static final int UNCP_CRITICAL = 3;
    static final int UNCP_CLEAR = 4;
    // adventnet severity
    static final int NO_RESPONSE = 0; // this must be zero since all modules
                                      // assume lower severity is more critical
    static final int CRITICAL = 1;
    static final int MAJOR = 2;
    static final int MINOR = 3;
    static final int WARNING = 4;
    static final int CLEAR = 5;
    static final int UNKNOW = 6;
    static final int UNKNOWN = 10;
    // old AN alarms
    static final int OLDAN_NORMAL = 0;
    static final int OLDAN_MINOR = 1;
    static final int OLDAN_MAJOR = 2;
    static final int OLDAN_CRITICAL = 3;

    // UNCP cmd
    static final char UNCP_TRAP = 'T';

    // AN2000 Event type
    static final int evTypeStateChange = 1;
    static final int evTypeSDHProtectionSwitch = 2;
    static final int evTypeV5ProtectionSwitch = 3;
    static final int evTypeV5VariantSwitch = 4;
    static final int evTypeVerifyRemotePR = 5;
    static final int evTypeNodeReset = 7;
    static final int evTypeSDT12ProtectionSwitch = 8;
    static final int evTypeE1VerifyLinkIdRslt = 9;
    static final int evTypeModule_Reset = 10;
    static final int evTypeGR303Protection = 11;
    static final int evTypePhsUserAccess = 12;
    static final int evTypeDataLinkSwitchover = 13;
    static final int evTypeSatcSwitch = 14;
    static final int evTypeWRTTestCall = 15;
    static final int evTypeOperatorError = 16;
    static final int evTypeRoutingTableDownload = 17;
    static final int evTypeTimeSync = 18;

    // Add by mhtian for iAN8000 2.0.1
    static final int evTypeRegisterWithCS = 100;
    static final int evTypeDeregisteredCS = 101;
    static final int evTypeSwitchOver = 102;
    static final int evTypeCSOutOfService = 103;
    static final int evTypeSwitchoverRedundantCS = 104;
    static final int evTypeNoEnoughChannel = 105;
    static final int evTypeNoActivityTimeOut = 106;
    static final int evTypeNetworkTimeOut = 107;

    // Add by mhtian for iAN8000 3.1
    static final int evTypeScm4SwitchOver = 20;
    static final int evTypeScm4Mismatch = 21;
    static final int evTypeEbam3SwitchOver = 22;

    // Added by Somnath sinha maha patra for iAN8000 2.2
    static final int evTypeHwyDefragment = 23;
    static final int evTypeInvalidTS = 24;
    // for iAN8K R2.1.0
    static final int evTypeComIncon = 28;
    static final int evTypeSwitchSCMIP = 29;

    // Fix MR 16858
    static final int ALARM_SPECIFIC_PSM_FAILURE = 87;

    static final int NODERESET = 0xFFFFFFFF;
}

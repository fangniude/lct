package com.winnertel.ems.epon.constant;

/**
 * Define NE, card and port level constants for BBS1000/5000.
 * Creation date: 7/15/2004
 */
public interface NEConstant {

    // Group type.
    public static final String GENERAL_BBS = "GENERAL_BBS";
    // NE types.
    public static final String NE_BBS1000 = "BBS1000";
    public static final String NE_BBS5000 = "BBS5000";
    public static final String NE_RadiusServer = "RADIUSServer";
    public static final String NE_BBS1000Plus = "BBS1000+";
    public static final String NE_BBS4000 = "BBS4000";
    public static final String NE_BBS1000_ONU_MANAGEMENT = "BBS1000_Onu_Management";
    public static final String NE_BBS1000_ONU_DIAGNOSTICS = "BBS1000_Onu_Diagnostics";
    public static final String NE_BBS1000_ONU_FIREWARE_UPGRADE = "BBS1000_Onu_Firmware_Upgrade";
    // public static final String NE_BBS1000_ONU_RTTD = "BBS1000_Onu_RTTD";
    // MO names
    public static final String MO_BBS100O_ONU_RTTD = "RoundTripTimeMOD";
    public static final String MO_BBS100O_ONU_FW_UPGRADE = "OnuFWUpgradeMOD";
    public static final String MO_BBS100O_FILE_SYSTEM = "FileSystemGroupMOD";
    public static final String MO_BBS100O_FTP_CONF_GROUP = "FtpConfGroupMOD";
    public static final String MO_BBS_TFTP_CONF_GROUP = "TftpConfMOD";
    public static final String MO_BBS100O_SYSTEM_BOOT = "SystemBootGroupMOD_Update";
    // Shelf types.
    public static final int SHELF_BBS1000 = 1;
    public static final int SHELF_BBS5000 = 2; // Reserved for future support of
    // new shelf type.
    // Card types.
    public static final int CARD_UNKNOWN = 1;
    public static final int CARD_GSM = 2; // Broadcom uplink card.
    public static final int CARD_LTM = 3; // OLT donwlink card.
    public static final int CARD_EMPTY = 99;
    // Port types.
    public static final int PORT_UNKNOWN = 1;
    public static final int PORT_GSM = 2; // GSM Gigabit ethernet uplink port.
    public static final int PORT_LTM = 3; // OLT Gigabit ethernet downlink port.
    // ONU types.
    public static final int ONU_UNKNOWN = 0;
    public static final int ONU_ONU100 = 1;
    public static final int ONU_ONU1000B = 2;
    public static final int ONU_ONU1000C = 3;
    public static final int ONU_ONU200A = 4;
    public static final int ONU_ONU200B = 5;
    public static final int ONU_ONU2024 = 6;
    public static final int ONU_ONU2004 = 7;
    public static final int ONU_ONU101K = 8;
    public static final int ONU_ONU301 = 9;
    public static final int ONU_ONU301C = 10;
    public static final int ONU_ONU404 = 11;
    public static final int ONU_ONU404C = 12;
    public static final int ONU_ONU804 = 13;
    public static final int ONU_ONU804C = 14;
    public static final int ONU_ONU1001C = 15;
    public static final int ONU_ONU3004 = 16;
    public static final int ONU_ONU1001i = 17;
    public static final int ONU_ONU2004i = 18;
    public static final int ONU_ONU404i = 19;
    public static final int ONU_CLT2060 = 20;
    public static final int ONU_ONU204i = 21;
    public static final int ONU_ONU208i = 22;

    // Card admin status.
    public static final int CARD_ADMIN_IN_SERVICE = 1;
    public static final int CARD_ADMIN_OUT_SERVICE = 2;
    public static final int CARD_ADMIN_SHUTDOWN = 3;
    // Card oper status.
    public static final int CARD_OPER_UNKNOWN = 1;
    public static final int CARD_OPER_INIT = 2;
    public static final int CARD_OPER_ACTIVE = 3;
    public static final int CARD_OPER_OFFLINE = 4;
    // PORT admin status.
    public static final int PORT_ADMIN_UP = 1;
    public static final int PORT_ADMIN_DOWN = 2;
    public static final int PORT_ADMIN_TESTING = 3;
    // PORT oper status.
    public static final int PORT_OPER_UP = 1;
    public static final int PORT_OPER_DOWN = 2;
    public static final int PORT_OPER_TESTING = 3;
    public static final int PORT_OPER_UNKOWN = 4;
    public static final int PORT_OPER_DORMANT = 5;
    public static final int PORT_OPER_NOT_PRESENT = 6;
    public static final int PORT_OPER_LOWER_LAYER_DOWN = 7;
    // event type
    public static final String EVENT_ACTION_KEY = "action";
    public static final int EVENT_TYPE_REFRESH = 0;
    public static final int EVENT_TYPE_CREATE = 1;
    public static final int EVENT_TYPE_UPDATE = 2;
    public static final int EVENT_TYPE_DELETE = 3;
    // special event type
    public static final int EVENT_TYPE_RESET = 4;
    public static final int EVENT_TYPE_SAVECONFIGURATION = 5;
    public static final int EVENT_TYPE_DOWNLOAD = 6;
    public static final int EVENT_TYPE_UPLOAD = 7;
    public static final int EVENT_TYPE_LIST = 8;
    public static final int EVENT_TYPE_RENAME = 9;
    public static final int EVENT_TYPE_COPY = 10;
    public static final int EVENT_TYPE_REMOVE = 11;
    public static final int EVENT_TYPE_UNBOUND = 12;
    public static final int EVENT_TYPE_OTHER = 99;
    // execute commands' result.
    public static final String COMMAND_RESULT = "commandResult";
    public static final String COMMAND_SUCCESS = "success";
    public static final String COMMAND_FAILURE = "failure";
    public static final String COMMAND_RUNNING = "running";
    // return error message key
    public static final String ERROR_MESSAGE_KEY = "errorMessage";
    // mo name key
    public static final String MO_PARENT_KEY = "parentName";
    public static final String MO_NAME_KEY = "moName";
    public static final String MO_PANEL_NAME_KEY = "moPanelName";
    // NE name key
    public static final String NE_ID_KEY = "neId";
    public static final String NE_NAME_KEY = "neName";
    public static final String NE_TYPE_KEY = "neType";
    public static final String NE_VERSION_KEY = "swVersion";
    // EventServer
    public static final String TRAP_TYPE = "trapType";
    public static final String TRAP_COLDSTART = "coldStart";
    // LogManager
    public static final short DVM_LOG_SUCCEED = 1;
    public static final short DVM_LOG_FAIL = -1;
    // Security manager
    public static final String SECURITY_MO_SET_KEY = "securityMOSet";
    public static final String MODULE_NAME_KEY = "moduleName";
    public static final String EDIT_NAME_KEY = "EDIT";
    public static final String VIEW_NAME_KEY = "VIEW";
    // Operational flow
    public static final String OF_NAME_KEY = "OperationFlow";
    // GUI Spilter width
    public static final int VERTICAL_DIVIDER_WIDTH = 8;
    public static final int HORIZONTAL_DIVIDER_WIDTH = 6;
    // GUI Spilter location
    public static final double VERTICAL_DIVIDER_LOCATION = 0.25;
    public static final double HORIZONTAL_DIVIDER_LOCATION = 0.618;

}
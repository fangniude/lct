package com.winnertel.ems.epon.iad.bbs4000.constant;

public class CommonConstant
{
  public final static String CHASSIS_LIST = "chassisList";
  public final static String CHASSIS_MASTER_ID = "masterChassisID";
  public final static String SLOT_LIST = "slotList";
  public final static String EXT_SLOT_LIST = "extSlotList";
  public final static String TREE_NODE_INFO = "treeNodeInfo";
//
  public final static String CHASSIS_ID = "shelfIndex";
  public final static String SLOT_ID = "slotIndex";
  public final static String PORT_ID = "portId";

  public final static String CHASSIS_WORKING_MODE = "workMode";
  public final static String CHASSIS_CURRENT_WORKING_MODE = "currentWorkMode";
  public final static String CHASSIS_CSM_ID = "csmID";

  public final static String MO_LEVEL = "moLevel";
  public final static String CARD_TYPE = "cardType";
  public final static String CARD_COMMUNITY_TYPE = "cardCommunityType";

  public final static String CPE_TYPE = "cpeType";
  public final static String CURRENT_STATUS = "currentStatus";
  public final static String CURRENT_FAILED_REASON = "currentFailedReason";
  public final static String SLOT_CONTAIN_CPE = "isModule";
  public final static String SLOT_CONTAIN_CPE_TRUE = "true";

  public final static String CURRENT_TREE_NODE_INFO = "currentTreeNodeInfo";
  public final static String CURRENT_CARD_TYPE = "FocusedCardType";
  public final static String CURRENT_CARD_ID = "FocusedCardIndex";
  public final static String CURRENT_SLOT_ID = "FocusedSlotIndex";
  public final static String CURRENT_PORT_ID = "MBeanIndex";
  public final static String CURRENT_ONU_ID = "FocusedOnuIndex";
  public final static String CURRENT_ONU_IFINDEX = "FocusedOnuIfIndex";
  
  public final static String CHASSIS_MODULE = "chassisModule";
  public final static String SHELFVIEW_EQUIPMENT = "shelfviewEquipment";
  public final static String SHELFVIEW_THREAD = "shelfviewThread";
//
  //the ratio of ONU to OLT, the usual value is 32 and 64.
  public final static String PON_SPLIT_RATIO = "systemSplitRatio";
  
  public final static int PON_SPLIT_RATIO_64 = 64;

  public final static int MO_LEVEL_SYSTEM = 0;
  public final static int MO_LEVEL_CHASSIS = 1;
  public final static int MO_LEVEL_SLOT = 2;
  public final static int MO_LEVEL_PORT = 3;
  public final static int MO_LEVEL_PROFILE = 4;
  public final static int MO_LEVEL_EXT_SLOT = 5;

  public final static int CARD_TYPE_CSM = 1;
  public final static int CARD_TYPE_AD24 = 2;
  public final static int CARD_TYPE_VD24 = 3;
  public final static int CARD_TYPE_AD48 = 4;

  public final static int CARD_EXT_TYPE_LTC = 1;
  public final static int CARD_EXT_TYPE_CSM = 2;

  public final static int CHASSIS_MASTER = 1;
  public final static int CHASSIS_SLAVE = 2;

  public final static int CARD_EXT_WORK_STATUS_NORMAL = 1;
  public final static int CARD_EXT_WORK_STATUS_ABNORMAL = 2;

  public final static int CARD_EXT_INSTALL = 1;
  public final static int CARD_EXT_NOT_INSTALL = 2;

  public final static int L2_MODE = 1;
  public final static int L3_MODE = 2;

  public final static int OPERATION_DISABLE = 0;
  public final static int OPERATION_ENABLE = 1;
  public final static int OPERATION_SHUTDOWN = 2;

  public final static int DISABLE_REASON_NOT_FAILED = 0;
  public final static int DISABLE_REASON_ADMIN_LOCKED = 1;
  public final static int DISABLE_REASON_NOT_DETECT = 2;
  public final static int DISABLE_REASON_UNAVIALABALE = 3;
  public final static int DISABLE_REASON_SHUTDOWN = 4;

//  //used for release resources when dvm shutdown
  public final static String BBS4000_SHUTDOWN_NOTIFICATION_FILTER = "workingModeFilter";
  public final static String BBS4000_SHUTDOWN_WORKING_MODE_HANDLER = "workingModeHandler";
  public final static String BBS4000_SHUTDOWN_SHELF_INFORMATION = "ShelfInformation";

  public static String getChassisWorkmodeKey(int chassisIndex)
  {
    return CommonConstant.CHASSIS_ID + "_" + chassisIndex + "_" + CommonConstant.CHASSIS_WORKING_MODE;
  }

  public static String getCurrentChassisWorkingmodeKey(int chassisIndex)
  {
    return CommonConstant.CHASSIS_ID + "_" + chassisIndex + "_" + CommonConstant.CHASSIS_CURRENT_WORKING_MODE;
  }

  public static String getChassisModuleKey(int chassisIndex)
  {
    return CommonConstant.CHASSIS_ID + "_" + chassisIndex + "_" + CommonConstant.CHASSIS_MODULE;
  }

  public static String getFailedReason(int reason)
  {
    switch(reason)
    {
      case DISABLE_REASON_NOT_FAILED:
        return "Not Failed";
      case DISABLE_REASON_ADMIN_LOCKED:
        return "Admin Locked";
      case DISABLE_REASON_NOT_DETECT:
        return "Not Detected";
      case DISABLE_REASON_UNAVIALABALE:
        return "Service Unavailable";
      case DISABLE_REASON_SHUTDOWN:
        return "Shutdown";
      default:
        return "";
    }
  }
}

package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview;

public class ModuleType extends BaseModuleType {

    public static final int Unkown_Module = 1;

    public static final int GSM_Module = 2;
    

    public static final int EPM_04a_Module = 3;
    public static final int EPM_04b_Module = 4;
    public static final int EPM_04c_Module = 5;

    public static final int GEM_04a_Module = 6;
    public static final int GEM_04b_Module = 7;


    public static final int LTM_Module = 20;
    public static final int LTM6_Module = 21;
    public static final int EPM_04d_Module = 11;
    

    public int getCommunityType(int moduleType) {
        int communityType = -1;
        if (isGSMModule(moduleType)) {
            communityType = GSM_Module;
        } else if (isLTMModule(moduleType)) {
            communityType = LTM_Module;
        }

        return communityType;
    }

    public boolean isGSMModule(int moduleType) {
        return GSM_Module == moduleType;
    }

    
    public boolean isLTMModule(int moduleType)
    {
      return EPM_04a_Module == moduleType || EPM_04b_Module == moduleType || EPM_04c_Module == moduleType || EPM_04d_Module == moduleType || LTM_Module == moduleType || LTM6_Module == moduleType;
    }


    public int[] getAllGSMModuleType() {
        return new int[]{GSM_Module};
    }

    public int[] getAllLTMModuleType() {
        return new int[]{LTM_Module, LTM6_Module, EPM_04d_Module};
    }

    //Zhangyunfang change the 'a' to 'A' something liked..  2007.4.8
    public String getModuleDisplayName(int moduleType) {
        String name = "Unknown";
        if (moduleType == GSM_Module) {
            name = "GSM";
        } else if (moduleType == LTM_Module) {
            name = "LTM";
        } else if (moduleType == LTM6_Module) {
            name = "LTM6";
        }

        return name;
    }

}  
  
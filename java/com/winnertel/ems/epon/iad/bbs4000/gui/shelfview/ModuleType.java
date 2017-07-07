package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview;

public class ModuleType extends BaseModuleType {

    public static final int Unkown_Module = 1;

    public static final int CSM_Module = 2;

    public static final int EPM_04a_Module = 3;
    public static final int EPM_04b_Module = 4;
    public static final int EPM_04c_Module = 5;

    public static final int GEM_04a_Module = 6;
    public static final int GEM_04b_Module = 7;

    public static final int XGM_01a_Module = 8; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public static final int OSM_04a_Module = 9; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public static final int GPM_02a_Module = 10; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public static final int EPM_04d_Module = 11;

    public static final int GEM_04c_Module = 12;

    public static final int CSM_UPLINK = 14;
    //module community.
    public static final int CSM_Community_Module = 1;
    public static final int GEM_Community_Module = 2;
    public static final int EPM_Community_Module = 3;
    public static final int XGM_Community_Module = 4; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
    public static final int OSM_Community_Module = 5; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
    public static final int GPM_Community_Module = 6; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public int getCommunityType(int moduleType) {
        int communityType = -1;
        if (isCSMModule(moduleType)) {
            communityType = CSM_Community_Module;
        } else if (isGEMModule(moduleType)) {
            communityType = GEM_Community_Module;
        } else if (isEPMModule(moduleType)) {
            communityType = EPM_Community_Module;
        } else if (isXGMModule(moduleType)) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
            communityType = XGM_Community_Module;
        } else if (isOSMModule(moduleType)) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
            communityType = OSM_Community_Module;
        } else if (isGPMModule(moduleType)) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
            communityType = GPM_Community_Module;
        }

        return communityType;
    }

    public boolean isCSMModule(int moduleType) {
        return CSM_Module == moduleType || CSM_UPLINK == moduleType;
    }


    public boolean isGEMModule(int moduleType) {
        return GEM_04a_Module == moduleType || GEM_04b_Module == moduleType || GEM_04c_Module == moduleType || CSM_UPLINK == moduleType;
    }


    public boolean isEPMModule(int moduleType) {
        return EPM_04a_Module == moduleType || EPM_04b_Module == moduleType || EPM_04c_Module == moduleType || EPM_04d_Module == moduleType;
    }

    public boolean isEPM04BModule(int moduleType) {
        return EPM_04b_Module == moduleType;
    }

    public boolean isXGMModule(int moduleType) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        return XGM_01a_Module == moduleType;
    }

    public boolean isOSMModule(int moduleType) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        return OSM_04a_Module == moduleType;
    }

    public boolean isGPMModule(int moduleType) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        return GPM_02a_Module == moduleType;
    }

    public int[] getAllCSMModuleType() {
        return new int[]{CSM_Module, CSM_UPLINK};
    }

    public int[] getAllGEMModuleType() {
        return new int[]{GEM_04a_Module, GEM_04b_Module, GEM_04c_Module, CSM_UPLINK};
    }


    public int[] getAllEPMModuleType() {
        return new int[]{EPM_04a_Module, EPM_04b_Module, EPM_04c_Module, EPM_04d_Module};
    }

    public int[] getAllXGMModuleType() { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        return new int[]{XGM_01a_Module};
    }

    public int[] getAllOSMModuleType() { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        return new int[]{OSM_04a_Module};
    }

    public int[] getAllGPMModuleType() { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        return new int[]{GPM_02a_Module};
    }

    //Zhangyunfang change the 'a' to 'A' something liked..  2007.4.8
    public String getModuleDisplayName(int moduleType) {
        String name = "Unknown";
        if (moduleType == CSM_Module) {
            name = "CSM";
        } else if (moduleType == GEM_04a_Module) {
            name = "GEM04A";
        } else if (moduleType == GEM_04b_Module) {
            name = "GEM04B";
        } else if (moduleType == GEM_04c_Module) { //added by Zhou Chao, 2011/1/27 (for BBS4000 v2.2.0)
            name = "GEM04C";
        } else if (moduleType == EPM_04a_Module) {
            name = "EPM04A";
        } else if (moduleType == EPM_04b_Module) {
            name = "EPM04B";
        } else if (moduleType == EPM_04c_Module) {
            name = "EPM04C";
        } else if (moduleType == EPM_04d_Module) {
            name = "EPM04D";
        } else if (moduleType == XGM_01a_Module) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
            name = "XGM01A";
        } else if (moduleType == OSM_04a_Module) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
            name = "OSM04A";
        } else if (moduleType == GPM_02a_Module) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
            name = "GPM02A";
        } else if ( moduleType == CSM_UPLINK ) {
            name  = "CSM uplink";
        }

    return name;
    }

}
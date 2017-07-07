package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview;

/**
 * Created by IntelliJ IDEA.
 * User: HZ03286
 * Date: 2003-12-2
 * Time: 18:05:53
 * To change this template use Options | File Templates.
 */
abstract public class BaseModuleType {

    public static final int unknown_module = 0;
    public static final int Profile_module = 999999;

    public final static String BBS4000_ModuleType = "BBS4000_ModuleType";

    public abstract int getCommunityType(int moduleType);

    public abstract boolean isCSMModule(int moduleType);

    public abstract boolean isGEMModule(int moduleType);

    public abstract boolean isEPMModule(int moduleType);

    public abstract boolean isEPM04BModule(int moduleType);

    public abstract boolean isXGMModule(int moduleType); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public abstract boolean isOSMModule(int moduleType); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public abstract boolean isGPMModule(int moduleType); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public abstract int[] getAllCSMModuleType();

    public abstract int[] getAllGEMModuleType();

    public abstract int[] getAllEPMModuleType();

    public abstract int[] getAllXGMModuleType(); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public abstract int[] getAllOSMModuleType(); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public abstract int[] getAllGPMModuleType(); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

    public abstract String getModuleDisplayName(int moduleType);

}
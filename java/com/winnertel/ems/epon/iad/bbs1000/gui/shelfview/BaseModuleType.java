package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview;

/**
 * Created by IntelliJ IDEA.
 * User: HZ03286
 *
 * Modified by Zhou Chao
 */
abstract public class BaseModuleType {

    public static final int unknown_module = 0;
    public static final int Profile_module = 999999;

    public final static String BBS1000_ModuleType = "BBS1000_ModuleType";

    public abstract int getCommunityType(int moduleType);

    public abstract boolean isGSMModule(int moduleType);

    public abstract boolean isLTMModule(int moduleType);

    public abstract int[] getAllGSMModuleType();

    public abstract int[] getAllLTMModuleType();

    public abstract String getModuleDisplayName(int moduleType);

}
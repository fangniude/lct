package com.winnertel.ems.epon.iad.bbs4000;

import com.winnertel.em.standard.device.DvmUtil;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;

import java.util.Properties;

/**
 * Description:
 * Copyright:   Copyright(c) 2005
 * Company:     UTStarcom
 * Date: 2005-12-21
 * Time: 13:52:09
 *
 * @author King Yao
 * @version 1.0
 */

public class MockIADManager /*implements IADMainInf */ {

    Properties frameParamMap = new Properties();
    Properties omcdParmMap = new Properties();
    String aReadCommunity = "public";
    String aWriteCommunity = "private";
    String aSnmpVersion = "v2";
    String aSnmpPort = "161";
    SnmpProxy snmpProxy = null;

    String host = "10.4.33.222";
    String swVersion = "2.1.0";
    String country = "US";
    String language = "en";

    public MockIADManager() {
    }

    public void setHost(String ip) {
        host = ip;
    }

    public String getHost() {
        return host;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setReadCommunity(String community) {
        aReadCommunity = community;
    }

    public String getReadCommunity() {
        return aReadCommunity;
    }

    public void setWriteCommunity(String community) {
        aWriteCommunity = community;
    }

    public String getWriteCommunity() {
        return aWriteCommunity;
    }

    public void setSwVersion(String version) {
        swVersion = version;
    }

    public String getSwVersion() {
        return swVersion;
    }

    public void init() {
//        DebugMode.setDebug(true);

        frameParamMap.put("neType", "FBW5000");
        frameParamMap.put("neName", "test");
        frameParamMap.put("NodeIPAddress", host);
        frameParamMap.put("swVersion", swVersion);
        frameParamMap.put("label", "test_label");
        frameParamMap.setProperty(MainApplet.PARAM_COUNTRY, country);
        frameParamMap.setProperty(MainApplet.PARAM_LANGUAGE, language);
        frameParamMap.setProperty("USER_NAME", "root");
        frameParamMap.setProperty("ReadCommunity", aReadCommunity);
        frameParamMap.setProperty("WriteCommunity", aWriteCommunity);
        frameParamMap.setProperty("SnmpVersion", aSnmpVersion);
        frameParamMap.setProperty("SnmpPort", aSnmpPort);
        frameParamMap.setProperty("Debug", "true");
        frameParamMap.setProperty("MoNameList", "FBW5000");
        frameParamMap.setProperty("FocusMoName", "FBW5000");
        frameParamMap.setProperty("GUIStyle", "embedded");
    }

    public void showDVM() {
        init();

        String host = frameParamMap.getProperty("NodeIPAddress");
        int port = Integer.parseInt(frameParamMap.getProperty("SnmpPort"));
        SnmpParameter param = new SnmpParameter( host, port);
        param.setReadCommunity(frameParamMap.getProperty("ReadCommunity"));
        param.setWriteCommunity(frameParamMap.getProperty("WriteCommunity"));
        param.setSnmpVersion(DvmUtil.convertSnmpVersion(frameParamMap.getProperty("SnmpVersion")));

        // setVisible(false);
        String title = "BBS4000 Debug - " + this.host;
        MainApplet.openManagedDVM(true, frameParamMap, param, title);
    }

    public static void main(String args[]) {
        MockIADManager mgr = new MockIADManager();

        if (args.length > 0) {
            mgr.setHost(args[0]);
        }

        if (args.length > 1) {
            mgr.setCountry(args[1]);
        }

        if (args.length > 2) {
            mgr.setLanguage(args[2]);
        }

        if (args.length > 3) {
            mgr.setReadCommunity(args[3]);
        }

        if (args.length > 4) {
            mgr.setWriteCommunity(args[4]);
        }

        if (args.length > 5) {
            mgr.setSwVersion(args[5]);
        }

        mgr.showDVM();
    }

}
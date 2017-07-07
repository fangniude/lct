package com.winnertel.ems.epon.iad.common;

import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.MainApplet;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;

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

public class MockIADManager {

    Properties frameParamMap = new Properties();
    Properties omcdParmMap = new Properties();

    String aReadCommunity = "public";

    String aWriteCommunity = "private";

    String aSnmpVersion = "v2";

    String aSnmpPort = "161";

    SnmpProxy snmpProxy = null;

    String host = "10.4.142.127";
    String type = "";
    String version = "";
    String country = "CN";
    String language = "zh";

    public void setHost(String ip) {
        host = ip;
    }

    public String getHost() {
        return host;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
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

    public void init() {
        frameParamMap.put("neType", getType());
        frameParamMap.put("neName", "test");
        frameParamMap.put("NodeIPAddress", host);
        frameParamMap.put("label", "test_label");
        frameParamMap.setProperty(MainApplet.PARAM_COUNTRY, country);
        frameParamMap.setProperty(MainApplet.PARAM_LANGUAGE, language);
        frameParamMap.setProperty("USER_NAME", "root");
        frameParamMap.setProperty("ReadCommunity", aReadCommunity);
        frameParamMap.setProperty("WriteCommunity", aWriteCommunity);
        frameParamMap.setProperty("SnmpVersion", aSnmpVersion);
        frameParamMap.setProperty("SnmpPort", aSnmpPort);
        frameParamMap.setProperty("Debug", "true");

        if(version != null) {
            frameParamMap.setProperty("swVersion", version);
        } else {
            frameParamMap.setProperty("swVersion", "1.1");
        }
        frameParamMap.setProperty("MoNameList", getType());
        frameParamMap.setProperty("GUIStyle", "embedded");
    }

    public void showDVM() {
        init();

        String host = frameParamMap.getProperty("NodeIPAddress");
        int port = Integer.parseInt(frameParamMap.getProperty("SnmpPort"));
        SnmpParameter param = new SnmpParameter(host, port);
        param.setReadCommunity(frameParamMap.getProperty("ReadCommunity"));
        param.setWriteCommunity(frameParamMap.getProperty("WriteCommunity"));
        param.setSnmpVersion(ISnmpConstant.VERSION2C);

        // setVisible(false);
        String title = getType() + " Debug - " + this.host;
        MainApplet.openManagedDVM(true, frameParamMap, param, title);
    }

    public static void main(String args[]) {
        MockIADManager mgr = new MockIADManager();

        if(args.length < 1) {
            System.err.println("ONU Type is not specified.");
            System.exit(-1);
        }

        if(args.length > 0) {
            mgr.setType(args[0]);
        }

        if(args.length > 1) {
            mgr.setVersion(args[1]);
        }

        if(args.length > 2) {
            mgr.setHost(args[2]);
        }

        if(args.length > 3) {
            mgr.setCountry(args[3]);
        }

        if(args.length > 4) {
            mgr.setLanguage(args[4]);
        }

        if(args.length > 5) {
            mgr.setReadCommunity(args[5]);
        }

        if(args.length > 6) {
            mgr.setWriteCommunity(args[6]);
        }

        mgr.showDVM();
    }
}

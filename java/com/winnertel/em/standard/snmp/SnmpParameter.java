package com.winnertel.em.standard.snmp;

import com.winnertel.em.framework.model.snmp.ISnmpConstant;

import javax.swing.*;

public class SnmpParameter implements ISnmpParameter {
    private JApplet fApplet = null;

    private String fTargetHost = null;

    private int fTargetPort = 0;

    private int fTimeout = 15; // changed to 15s for NE's slow response

    private int fRetries = 3;

    private int fSnmpVersion = ISnmpConstant.VERSION2C;

    private String fReadCommunity = "public";

    private String fWriteCommunity = "private";

    private boolean fIsClient = false;

    public SnmpParameter(){
    }

    public SnmpParameter(String aTargetHost) {
        this(aTargetHost, 161);
    }

    public SnmpParameter(String aTargetHost, int aTargetPort) {
        this(aTargetHost, aTargetPort, false);
    }

    public SnmpParameter(String aTargetHost, int aTargetPort, boolean isClient) {
        fTargetHost = aTargetHost;
        fTargetPort = aTargetPort;
        fIsClient = isClient;
    }

//    public SnmpParameter(JApplet aApplet, String aTargetHost, int aTargetPort) {
//        fApplet = aApplet;
//        fTargetHost = aTargetHost;
//        fTargetPort = aTargetPort;
//    }

//    public JApplet getApplet() {
//        return fApplet;
//    }
//
//    public void setApplet(JApplet applet) {
//        fApplet = applet;
//    }

    public String getTargetHost() {
        return fTargetHost;
    }

    public void setTargetHost(String targetHost) {
        fTargetHost = targetHost;
    }

    public int getTargetPort() {
        return fTargetPort;
    }

    public void setTargetPort(int aTargetPort) {
        fTargetPort = aTargetPort;
    }

    public int getTimeout() {
        return fTimeout;
    }

    public void setTimeout(int aTimeout) {
        fTimeout = aTimeout;
    }

    public int getRetries() {
        return fRetries;
    }

    public void setRetries(int aRetries) {
        fRetries = aRetries;
    }

    public int getSnmpVersion() {
        return fSnmpVersion;
    }

    public void setSnmpVersion(int aSnmpVersion) {
        fSnmpVersion = aSnmpVersion;
    }

    public String getReadCommunity() {
        return fReadCommunity;
    }

    public void setReadCommunity(String aReadCommunity) {
        fReadCommunity = aReadCommunity;
    }

    public String getWriteCommunity() {
        return fWriteCommunity;
    }

    public void setWriteCommunity(String aWriteCommunity) {
        fWriteCommunity = aWriteCommunity;
    }

    public boolean isClient() {
        return fIsClient;
    }

    public void setClient(boolean isClient) {
        this.fIsClient = isClient;
    }
}

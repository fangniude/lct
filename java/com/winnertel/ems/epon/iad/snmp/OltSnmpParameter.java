/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.snmp;

import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.standard.device.DvmUtil;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.inms.topoui.UTopoUIContext;
import com.winnertel.nms.lite.momodel.ManagedElement;

import javax.swing.*;

/**
 * The SnmpParameter class.
 *
 * @author Rox Liu
 */
public class OltSnmpParameter implements ISnmpParameter {

    private JApplet fApplet = null;
    private String fTargetHost = null;
    private int fTargetPort = 0;
    private int fTimeout = 5; //changed to 5s for NE's slow response
    private int fRetries = 3;
    private int fSnmpVersion = ISnmpConstant.VERSION2C;
    private String fReadCommunity = "public";
    private String fWriteCommunity = "private";
    private String neName = null;

    public OltSnmpParameter(JApplet aApplet, String neName) {
        fApplet = aApplet;
        this.neName = neName;

        update();
    }

    public JApplet getApplet() {
        return fApplet;
    }

    public void setApplet(JApplet applet) {
        fApplet = applet;
    }

    public void setTargetHost(String targetHost) {
        fTargetHost = targetHost;
    }

    public String getTargetHost() {
        return fTargetHost;
    }

    public int getTargetPort() {
        return fTargetPort;
    }

    public void setTargetPort(int port) {
        fTargetPort = port;
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

    @Override
    public boolean isClient() {
        return true;
    }

    public void setWriteCommunity(String aWriteCommunity) {
        fWriteCommunity = aWriteCommunity;
    }

    public void update() {
        if (neName != null) {
            UTopoUIContext context = UTopoUIContext.getInstance();
            if (context != null) {
                ManagedElement me = context.getMONodeByNEId(neName);
                if (me != null) {
                    setTargetHost(me.getIpAddress());
                    setTargetPort(me.getSnmpPort());
                    setSnmpVersion(DvmUtil.convertSnmpVersion(me.getSnmpVersion()));
                    setReadCommunity(me.getReadCommunity());
                    setWriteCommunity(me.getWriteCommunity());
                }
            }
        }
    }

}
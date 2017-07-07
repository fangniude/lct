/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.snmp;

import com.winnertel.ems.epon.iad.IADManager;
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
public class OnuSnmpParameter implements ISnmpParameter {

    private JApplet fApplet = null;
    private String fTargetHost = null;
    private int fTargetPort = 0;
    private int fTimeout = 5; //changed to 5s for NE's slow response
    private int fRetries = 3;
    private int fSnmpVersion = ISnmpConstant.VERSION2C;
    private String fReadCommunity = "public";
    private String fWriteCommunity = "private";
    private String neName = null;
    private int moduleId = 0;
    private int portId = 0;
    private int onuId = 0;

    public OnuSnmpParameter(JApplet aApplet, String neName, int moduleId, int portId, int onuId) {
        fApplet = aApplet;
        this.neName = neName;
        this.moduleId = moduleId;
        this.portId = portId;
        this.onuId = onuId;

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

    public void setTargetPort(int port) {
        fTargetPort = port;
    }

    public int getTargetPort() {
        return fTargetPort;
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

    public String getNeName() {
        return neName;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    public int getOnuId() {
        return onuId;
    }

    public void setOnuId(int onuId) {
        this.onuId = onuId;
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

                    String community = getCommunity(me.getReadCommunity());
                    setReadCommunity(community);

                    community = getCommunity(me.getWriteCommunity());
                    setWriteCommunity(community);
                } else {
                    if (fApplet instanceof IADManager) {
                        IADManager iadManager = (IADManager) fApplet;
                        setTargetHost(iadManager.getSnmpProxy().getTargetHost());
                        setTargetPort(iadManager.getSnmpProxy().getTargetPort());
                        setSnmpVersion(iadManager.getSnmpProxy().getSnmpVersion());
                    }

                    String community = getCommunity(getReadCommunity());
                    setReadCommunity(community);

                    community = getCommunity(getWriteCommunity());
                    setWriteCommunity(community);
                }
            }
        }
    }

    public String getCommunity(String neCommunity) {
        StringBuffer sb = new StringBuffer(neCommunity);
        sb.append("#OLTchassis:1");
        sb.append("#OLTmodule:").append(moduleId);
        sb.append("#OLTport:").append(portId);
        sb.append("#ONU:").append(onuId);

        return sb.toString();
    }

}
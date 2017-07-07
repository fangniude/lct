/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common;

import java.io.Serializable;

public class OnuMulticastCtrlHeadModel implements Serializable {

    /*
    create table OnuMulticastCtrlHead (
        module int NOT NULL,
        device int default 1 NOT NULL,
        port int NOT NULL,
        logical_port int NOT NULL,
        ether_port int NOT NULL,
        profile varchar(32) NOT NULL,
        PRIMARY KEY (module, device, port, logical_port, ether_port, profile)
    )
    */

    private int moduleId;
    private int deviceId;
    private int portId;
    private int logicalPortId;
    private int etherPortIndex;
    private String profile;

    public OnuMulticastCtrlHeadModel() {
        super();
    }

    public OnuMulticastCtrlHeadModel(int moduleId, int deviceId, int portId, int logicalPortId, int etherPortIndex, String profile) {
        super();

        this.moduleId = moduleId;
        this.deviceId = deviceId;
        this.portId = portId;
        this.logicalPortId = logicalPortId;
        this.etherPortIndex = etherPortIndex;
        this.profile = profile;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    public int getLogicalPortId() {
        return logicalPortId;
    }

    public void setLogicalPortId(int logicalPortId) {
        this.logicalPortId = logicalPortId;
    }

    public int getEtherPortIndex() {
        return etherPortIndex;
    }

    public void setEtherPortIndex(int etherPortIndex) {
        this.etherPortIndex = etherPortIndex;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setColumn(int columnIndex, String value) {
        switch (columnIndex) {
            case 0: {
                setModuleId(Integer.parseInt(value));
            }
            case 1: {
                setDeviceId(Integer.parseInt(value));
            }
            case 2: {
                setPortId(Integer.parseInt(value));
            }
            case 3: {
                setLogicalPortId(Integer.parseInt(value));
            }
            case 4: {
                setEtherPortIndex(Integer.parseInt(value));
            }
            case 5: {
                setProfile(value);
            }
        }
    }

    public String getColumn(int columnIndex) {
        switch (columnIndex) {
            case 0: {
                return String.valueOf(getModuleId());
            }
            case 1: {
                return String.valueOf(getDeviceId());
            }
            case 2: {
                return String.valueOf(getPortId());
            }
            case 3: {
                return String.valueOf(getLogicalPortId());
            }
            case 4: {
                return String.valueOf(getEtherPortIndex());
            }
            case 5: {
                return getProfile();
            }
            default:
                return null;
        }
    }

}
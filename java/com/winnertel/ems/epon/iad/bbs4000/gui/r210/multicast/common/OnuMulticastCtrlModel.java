/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common;

import java.io.Serializable;
import java.util.Vector;

public class OnuMulticastCtrlModel implements Serializable {

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

    create table OnuMulticastCtrlProfile (
        profile varchar(32) NOT NULL,
        multicast_vlan int NULL,
        multicast_group_start varchar(15) NULL,
        multicast_group_end varchar(15) NULL,
        authentication_type int NULL,
        PRIMARY KEY (profile)
    )
    */

    private int moduleId;
    private int deviceId = 1; //reserved
    private int portId;
    private int logicalPortId;
    private int etherPortIndex;
    private String profile;

    private Vector profileData = new Vector(); //OnuMulticastCtrlProfileModel list

    public OnuMulticastCtrlModel() {
        super();
    }

    public OnuMulticastCtrlModel(int moduleId, int deviceId, int portId, int logicalPortId, int etherPortIndex, String profile) {
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

    public Vector getProfileData() {
        return profileData;
    }

    public void setProfileData(Vector profileData) {
        this.profileData = profileData;
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
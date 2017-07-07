/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common;


import java.io.Serializable;

public class OnuMulticastCtrlProfileModel implements Serializable {

    /*
    create table OnuMulticastCtrlProfile (
        profile varchar(32) NOT NULL,
        multicast_vlan int NULL,
        multicast_group_start varchar(15) NULL,
        multicast_group_end varchar(15) NULL,
        authentication_type int NULL,
        PRIMARY KEY (profile)
    )
    */

    private String profile;
    private int vlan;
    private String groupStart;
    private String groupEnd;
    private int authType;

    public OnuMulticastCtrlProfileModel() {
        super();
    }

    public OnuMulticastCtrlProfileModel(String profile, int vlan, String groupStart, String groupEnd, int authType) {
        super();

        this.profile = profile;
        this.vlan = vlan;
        this.groupStart = groupStart;
        this.groupEnd = groupEnd;
        this.authType = authType;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getVlan() {
        return vlan;
    }

    public void setVlan(int vlan) {
        this.vlan = vlan;
    }

    public String getGroupStart() {
        return groupStart;
    }

    public void setGroupStart(String groupStart) {
        this.groupStart = groupStart;
    }

    public String getGroupEnd() {
        return groupEnd;
    }

    public void setGroupEnd(String groupEnd) {
        this.groupEnd = groupEnd;
    }

    public int getAuthType() {
        return authType;
    }

    public void setAuthType(int authType) {
        this.authType = authType;
    }

    public void setColumn(int columnIndex, String value) {
        switch (columnIndex) {
            case 0: {
                setProfile(value);
            }
            case 1: {
                setVlan(Integer.parseInt(value));
            }
            case 2: {
                setGroupStart(value);
            }
            case 3: {
                setGroupEnd(value);
            }
            case 4: {
                setAuthType(Integer.parseInt(value));
            }
        }
    }

    public String getColumn(int columnIndex) {
        switch (columnIndex) {
            case 0: {
                return getProfile();
            }
            case 1: {
                return String.valueOf(getVlan());
            }
            case 2: {
                return getGroupStart();
            }
            case 3: {
                return getGroupEnd();
            }
            case 4: {
                return String.valueOf(getAuthType());
            }
            default:
                return null;
        }
    }

}
package com.winnertel.ems.epon.topo.model;

import com.winnertel.nms.lite.momodel.ManagedElement;

public class CBAT extends ManagedElement {
    public static final String onuName = "onuName";
    public static final String macAddress = "macAddress";
    public static final String mibVersion = "mibVersion";
    public static final String venderVersion = "venderVersion";
    public static final String manufactoryInfo = "manufactoryInfo";
    public static final String serialNumber = "serialNumber";
    public static final String hardwareVersion = "hardwareVersion";
    public static final String adminModelNumber  = "adminModelNumber";
    public static final String isLawless  = "isLawless"; //used to mark the CNU count in the cbat is exceeding license or not

    public CBAT() {
        super();
    }

    public void setOnuName(String value) {
        setAttribute(onuName, value);
    }

    public String getOnuName() {
        return getAttribute(onuName).toString();
    }

    public void setMacAddress(String value) {
        setAttribute(macAddress, value);
    }

    public String getMacAddress() {
        return getAttribute(macAddress).toString() ;
    }

    public void setMibVersion(String value) {
        setAttribute(mibVersion, value);
    }

    public String getMibVersion() {
        return getAttribute(mibVersion).toString() ;
    }

    public void setVenderVersion(String value) {
        setAttribute(venderVersion, value);
    }

    public String getVenderVersion() {
        return getAttribute(venderVersion).toString() ;
    }

    public void setManufactoryInfo(String value) {
        setAttribute(manufactoryInfo, value);
    }

    public String getManufactoryInfo() {
        return getAttribute(manufactoryInfo).toString() ;
    }

    public void setSerialNumber(String value) {
        setAttribute(serialNumber, value);
    }

    public String getSerialNumber() {
        return getAttribute(serialNumber).toString() ;
    }

    public void setHardwareVersion(String value) {
        setAttribute(hardwareVersion, value);
    }

    public String getHardwareVersion() {
        return getAttribute(hardwareVersion).toString() ;
    }
    public void setAdminModelNumber (String value) {
        setAttribute(adminModelNumber , value);
    }

    public String getAdminModelNumber () {
        return getAttribute(adminModelNumber ).toString() ;
    }
    public void setIsLawless (String value) {
        setAttribute(isLawless , value);
    }

    public String getIsLawless () {
        return getAttribute(isLawless ).toString() ;
    }
}


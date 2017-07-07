package com.winnertel.ems.epon.inventory;

import java.io.Serializable;

/**
 * <p>
 * OnuMOD represents a physical ONU port at the end user side. In addition
 * to the attributes defined in this class, the following attributes defined in
 * ManagedObject superclass will also be used:
 * </p>
 */
public class OnuMOD implements Serializable {

    private String onuId = "";
    private String label = "";
    private String neName = "";
    private String neLabel = "";
    private String shelfId = "";
    private String cardId = "";
    private String portId = "";
    private String macAddress = "";
    private String hwType = "";
    private String adminStatus = "";
    private String registerStatus = "";
    private String swVersion = "";
    private String hwVersion = "";
    private String iadStatus = "";
    private String splitterLabel = ""; //added by Zhou Chao
    private String splitterPort = ""; //added by Zhou Chao

    public OnuMOD() {
    }

    public OnuMOD(String id) {
        setOnuId(id);
    }

    public String getOnuId() {
        return onuId;
    }

    public String getLabel() {
        return label;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public String getHwType() {
        return hwType;
    }

    public String getNeName() {
        return neName;
    }

    public String getNeLabel() {
        return neLabel;
    }

    public String getShelfId() {
        return shelfId;
    }

    public String getCardId() {
        return cardId;
    }

    public String getPortId() {
        return portId;
    }

    public void setOnuId(String id) {
        this.onuId = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public void setHwType(String hwType) {
        this.hwType = hwType;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public void setNeLabel(String neLabel) {
        this.neLabel = neLabel;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String status) {
        adminStatus = status;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String status) {
        registerStatus = status;
    }

    public String getSwVersion() {
        return swVersion;
    }

    public void setSwVersion(String version) {
        swVersion = version;
    }

    public String getHwVersion() {
        return hwVersion;
    }

    public void setHwVersion(String version) {
        hwVersion = version;
    }

    public String getIadStatus() {
        return iadStatus;
    }

    public void setIadStatus(String status) {
        iadStatus = status;
    }

    public String getSplitterLabel() {
        return splitterLabel;
    }

    public void setSplitterLabel(String splitterLabel) {
        this.splitterLabel = splitterLabel;
    }

    public String getSplitterPort() {
        return splitterPort;
    }

    public void setSplitterPort(String splitterPort) {
        this.splitterPort = splitterPort;
    }

}
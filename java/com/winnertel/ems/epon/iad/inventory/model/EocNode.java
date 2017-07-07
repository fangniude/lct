package com.winnertel.ems.epon.iad.inventory.model;

public class EocNode extends InventoryNode {

    private String deviceId = "";
    private String cardId = "";
    private String portId = "";
    private String seriesNumber = "";
    private String ipAddress = "";
    private String macAddress = "";

    boolean hasChild = false;

    public EocNode(String deviceId, String cardId, String portId) {
        this.deviceId = deviceId;
        this.cardId = cardId;
        this.portId = portId;
    }

    public EocNode(String deviceId, String cardId, String portId, String seriesNumber, String ipAddress, String macAddress) {
        this.deviceId = deviceId;
        this.cardId = cardId;
        this.portId = portId;
        this.seriesNumber = seriesNumber;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
    }

    public String getSearchId() {
        return (deviceId + "/" + cardId + "/" + portId);
    }

    public boolean haveChild() {
        return hasChild;
    }

    public String toString() {
        return "CBAT";
        //return (deviceId + "/" + cardId + "/" + portId + "@" + ipAddress);
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getPortId() {
        return portId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

}
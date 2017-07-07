package com.winnertel.em.framework.model.snmp;

public class DefaultSnmpPduException extends com.winnertel.snmp.snmp2.DefaultSnmpException {

    private int requestId = -1;
    private int errorStatus = -1;
    private int errorIndex = -1;
    private String localAddress = null;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(int errorStatus) {
        this.errorStatus = errorStatus;
    }

    public int getErrorIndex() {
        return errorIndex;
    }

    public void setErrorIndex(int errorIndex) {
        this.errorIndex = errorIndex;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getLocalAddress() {
        return localAddress;
    }

}

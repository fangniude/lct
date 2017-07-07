package com.winnertel.em.framework.model;

import com.winnertel.em.framework.util.BaseException;

public class MibBeanException extends BaseException {

    private int requestId = -1;
    private int errorStatus = -1;
    private String errorItem = null;
    private String localAddress = null;

    public MibBeanException() {
        super();
    }

    public MibBeanException(String msg) {
        super(msg);
    }

    public MibBeanException(Throwable aWrapee) {
        super(aWrapee);
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setErrorStatus(int errorCode) {
        this.errorStatus = errorCode;
    }

    public int getErrorStatus() {
        return errorStatus;
    }

    public void setErrorItem(String errorItem) {
        this.errorItem = errorItem;
    }

    public String getErrorItem() {
        return errorItem;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getLocalAddress() {
        return localAddress;
    }

}

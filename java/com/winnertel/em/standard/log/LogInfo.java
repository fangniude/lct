package com.winnertel.em.standard.log;

import com.winnertel.em.framework.log.ILogInfo;

import java.util.Date;

public class LogInfo implements ILogInfo {
    private String fUser = null;
    private String fHostIp = null;
    private String fHostName = null;
    private String fOperation = null;
    private String fOperationObject = null;
    private String fAnnotation = null;
    private int fLevel = 3;
    private Date fTime;
    private short fStatus = ILogInfo.COMPLETED;


    public LogInfo() {
    }


    public String getUser() {
        return fUser;
    }

    public void setUser(String aUser) {
        fUser = aUser;
    }


    public String getHostIp() {
        return fHostIp;
    }

    public void setHostIp(String aHostIp) {
        fHostIp = aHostIp;
    }


    public String getHostName() {
        return fHostName;
    }

    public void setHostName(String aHostName) {
        fHostName = aHostName;
    }


    public String getOperation() {
        return fOperation;
    }

    public void setOperation(String aOperation) {
        fOperation = aOperation;
    }


    public String getOperationObject() {
        return fOperationObject;
    }

    public void setOperationObject(String aOperationObject) {
        fOperationObject = aOperationObject;
    }


    public String getAnnotation() {
        return fAnnotation;
    }

    public void setAnnotation(String aAnnotation) {
        fAnnotation = aAnnotation;
    }


    public int getLevel() {
        return fLevel;
    }

    public void setLevel(int aLevel) {
        fLevel = aLevel;
    }


    public void setStatus(short aStatus) {
        fStatus = aStatus;
    }

    public short getStatus() {
        return fStatus;
    }


    public Date getTime() {
        return fTime;
    }

    public void setTime(Date aTime) {
        fTime = aTime;
    }


    public Object clone() {
        LogInfo result = new LogInfo();
        result.setAnnotation(getAnnotation());
        result.setHostIp(getHostIp());
        result.setHostName(getHostName());
        result.setLevel(getLevel());
        result.setOperation(getOperation());
        result.setOperationObject(getOperationObject());
        result.setStatus(getStatus());
        result.setTime(getTime());
        result.setUser(getUser());
        return result;
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[User=");
        sb.append(fUser);
        sb.append(", HostIP=");
        sb.append(fHostIp);
        sb.append(", HostName=");
        sb.append(fHostName);
        sb.append(", Operation=");
        sb.append(fOperation);
        sb.append(", OperationObject=");
        sb.append(fOperationObject);
        sb.append(", Level=");
        sb.append(fLevel);
        sb.append(", Time=");
        sb.append(fTime);
        sb.append(", Annotation=");
        sb.append(fAnnotation);
        sb.append(", Status=");
        sb.append(fStatus);
        return sb.toString();
    }
}


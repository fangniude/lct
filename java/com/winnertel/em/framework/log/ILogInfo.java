package com.winnertel.em.framework.log;

import java.util.Date;

public interface ILogInfo {
    public final static short COMPLETED = 1;
    public final static short FAILED = 2;


    public String getUser();

    public void setUser(String aUser);

    public String getHostIp();

    public void setHostIp(String aHostIp);

    public String getHostName();

    public void setHostName(String aHostName);

    public String getOperation();

    public void setOperation(String anOperation);

    public String getOperationObject();

    public void setOperationObject(String anOperationObject);

    public String getAnnotation();

    public void setAnnotation(String anAnnotation);

    public int getLevel();

    public void setLevel(int aLevel);

    public Date getTime();

    public void setTime(Date aTime);

    public short getStatus();

    public void setStatus(short aStatus);
}

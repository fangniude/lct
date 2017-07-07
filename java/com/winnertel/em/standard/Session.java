package com.winnertel.em.standard;

import com.winnertel.em.framework.ISession;

public class Session implements ISession {
    private String fUser = null;
    private String fHostIp = null;
    private String fHostName = null;


    public Session(String aUser) {
        fUser = aUser;
    }


    public String getUser() {
        return fUser;
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
}

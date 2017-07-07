package com.winnertel.em.framework;

public interface ISession {
    public String getUser();

    public String getHostIp();

    public void setHostIp(String aHostIp);

    public String getHostName();

    public void setHostName(String aHostName);
}

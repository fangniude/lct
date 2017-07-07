package com.winnertel.em.standard.snmp;

public interface ISnmpParameter {

    public String getTargetHost();

    public int getTargetPort();

    public int getTimeout();

    public int getRetries();

    public int getSnmpVersion();

    public String getReadCommunity();

    public String getWriteCommunity();

    public boolean isClient();
}

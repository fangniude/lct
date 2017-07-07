package com.winnertel.ems.epon.iad.bbs4000.mib;


/*
    * Copyright (c) 2002-2005 UTStarcom, Inc.
    * All rights reserved.
    */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The DHCPServerStatsMBean class.
 * Created by QuickDVM
 */
public class DHCPServerStatsMBean extends SnmpMibBean {
    public static final String utsIpDhcpServerStatsFreeBindings = "utsIpDhcpServerStatsFreeBindings";
    public static final String utsIpDhcpServerStatsAutoBindings = "utsIpDhcpServerStatsAutoBindings";
    public static final String utsIpDhcpServerStatsExpiredBindings = "utsIpDhcpServerStatsExpiredBindings";
    public static final String utsIpDhcpServerStatsOfferBindings = "utsIpDhcpServerStatsOfferBindings";
    public static final String utsIpDhcpServerStatsManualFree = "utsIpDhcpServerStatsManualFree";
    public static final String utsIpDhcpServerStatsManualBindings = "utsIpDhcpServerStatsManualBindings";
    public static final String utsIpDhcpServerStatsManualExpired = "utsIpDhcpServerStatsManualExpired";
    public static final String utsIpDhcpServerStatsManualOffer = "utsIpDhcpServerStatsManualOffer";
    public static final String utsIpDhcpServerStatsDiscoverPackets = "utsIpDhcpServerStatsDiscoverPackets";
    public static final String utsIpDhcpServerStatsRequestPackets = "utsIpDhcpServerStatsRequestPackets";
    public static final String utsIpDhcpServerStatsReleasePackets = "utsIpDhcpServerStatsReleasePackets";
    public static final String utsIpDhcpServerStatsDeclinePackets = "utsIpDhcpServerStatsDeclinePackets";
    public static final String utsIpDhcpServerStatsInformPackets = "utsIpDhcpServerStatsInformPackets";
    public static final String utsIpDhcpServerStatsinvalidPackets = "utsIpDhcpServerStatsinvalidPackets";
    public static final String utsIpDhcpServerStatsOfferPackets = "utsIpDhcpServerStatsOfferPackets";
    public static final String utsIpDhcpServerStatsAckPackets = "utsIpDhcpServerStatsAckPackets";
    public static final String utsIpDhcpServerStatsNakPackets = "utsIpDhcpServerStatsNakPackets";
    public static final String utsIpDhcpServerStatsReplyPackets = "utsIpDhcpServerStatsReplyPackets";

    public DHCPServerStatsMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsIpDhcpServerStatsFreeBindings, new SnmpMibBeanProperty(utsIpDhcpServerStatsFreeBindings, ".1.3.6.1.4.1.41355.1800.4.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsAutoBindings, new SnmpMibBeanProperty(utsIpDhcpServerStatsAutoBindings, ".1.3.6.1.4.1.41355.1800.4.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsExpiredBindings, new SnmpMibBeanProperty(utsIpDhcpServerStatsExpiredBindings, ".1.3.6.1.4.1.41355.1800.4.3.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsOfferBindings, new SnmpMibBeanProperty(utsIpDhcpServerStatsOfferBindings, ".1.3.6.1.4.1.41355.1800.4.3.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsManualFree, new SnmpMibBeanProperty(utsIpDhcpServerStatsManualFree, ".1.3.6.1.4.1.41355.1800.4.3.1.1.5", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsManualBindings, new SnmpMibBeanProperty(utsIpDhcpServerStatsManualBindings, ".1.3.6.1.4.1.41355.1800.4.3.1.1.6", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsManualExpired, new SnmpMibBeanProperty(utsIpDhcpServerStatsManualExpired, ".1.3.6.1.4.1.41355.1800.4.3.1.1.7", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsManualOffer, new SnmpMibBeanProperty(utsIpDhcpServerStatsManualOffer, ".1.3.6.1.4.1.41355.1800.4.3.1.1.8", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsDiscoverPackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsDiscoverPackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.9", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsRequestPackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsRequestPackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.10", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsReleasePackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsReleasePackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.11", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsDeclinePackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsDeclinePackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.12", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsInformPackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsInformPackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.13", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsinvalidPackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsinvalidPackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.14", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsOfferPackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsOfferPackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.15", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsAckPackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsAckPackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.16", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsNakPackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsNakPackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.17", ISnmpConstant.INTEGER));
        initProperty(utsIpDhcpServerStatsReplyPackets, new SnmpMibBeanProperty(utsIpDhcpServerStatsReplyPackets, ".1.3.6.1.4.1.41355.1800.4.3.1.1.18", ISnmpConstant.INTEGER));

    }


    public Integer getUtsIpDhcpServerStatsFreeBindings() {
        return (Integer) getProperty(utsIpDhcpServerStatsFreeBindings).getValue();
    }

    public void setUtsIpDhcpServerStatsFreeBindings(Integer aUtsIpDhcpServerStatsFreeBindings) {
        getProperty(utsIpDhcpServerStatsFreeBindings).setValue(aUtsIpDhcpServerStatsFreeBindings);
    }

    public Integer getUtsIpDhcpServerStatsAutoBindings() {
        return (Integer) getProperty(utsIpDhcpServerStatsAutoBindings).getValue();
    }

    public void setUtsIpDhcpServerStatsAutoBindings(Integer aUtsIpDhcpServerStatsAutoBindings) {
        getProperty(utsIpDhcpServerStatsAutoBindings).setValue(aUtsIpDhcpServerStatsAutoBindings);
    }

    public Integer getUtsIpDhcpServerStatsExpiredBindings() {
        return (Integer) getProperty(utsIpDhcpServerStatsExpiredBindings).getValue();
    }

    public void setUtsIpDhcpServerStatsExpiredBindings(Integer aUtsIpDhcpServerStatsExpiredBindings) {
        getProperty(utsIpDhcpServerStatsExpiredBindings).setValue(aUtsIpDhcpServerStatsExpiredBindings);
    }

    public Integer getUtsIpDhcpServerStatsOfferBindings() {
        return (Integer) getProperty(utsIpDhcpServerStatsOfferBindings).getValue();
    }

    public void setUtsIpDhcpServerStatsOfferBindings(Integer aUtsIpDhcpServerStatsOfferBindings) {
        getProperty(utsIpDhcpServerStatsOfferBindings).setValue(aUtsIpDhcpServerStatsOfferBindings);
    }

    public Integer getUtsIpDhcpServerStatsManualFree() {
        return (Integer) getProperty(utsIpDhcpServerStatsManualFree).getValue();
    }

    public void setUtsIpDhcpServerStatsManualFree(Integer aUtsIpDhcpServerStatsManualFree) {
        getProperty(utsIpDhcpServerStatsManualFree).setValue(aUtsIpDhcpServerStatsManualFree);
    }

    public Integer getUtsIpDhcpServerStatsManualBindings() {
        return (Integer) getProperty(utsIpDhcpServerStatsManualBindings).getValue();
    }

    public void setUtsIpDhcpServerStatsManualBindings(Integer aUtsIpDhcpServerStatsManualBindings) {
        getProperty(utsIpDhcpServerStatsManualBindings).setValue(aUtsIpDhcpServerStatsManualBindings);
    }

    public Integer getUtsIpDhcpServerStatsManualExpired() {
        return (Integer) getProperty(utsIpDhcpServerStatsManualExpired).getValue();
    }

    public void setUtsIpDhcpServerStatsManualExpired(Integer aUtsIpDhcpServerStatsManualExpired) {
        getProperty(utsIpDhcpServerStatsManualExpired).setValue(aUtsIpDhcpServerStatsManualExpired);
    }

    public Integer getUtsIpDhcpServerStatsManualOffer() {
        return (Integer) getProperty(utsIpDhcpServerStatsManualOffer).getValue();
    }

    public void setUtsIpDhcpServerStatsManualOffer(Integer aUtsIpDhcpServerStatsManualOffer) {
        getProperty(utsIpDhcpServerStatsManualOffer).setValue(aUtsIpDhcpServerStatsManualOffer);
    }

    public Integer getUtsIpDhcpServerStatsDiscoverPackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsDiscoverPackets).getValue();
    }

    public void setUtsIpDhcpServerStatsDiscoverPackets(Integer aUtsIpDhcpServerStatsDiscoverPackets) {
        getProperty(utsIpDhcpServerStatsDiscoverPackets).setValue(aUtsIpDhcpServerStatsDiscoverPackets);
    }

    public Integer getUtsIpDhcpServerStatsRequestPackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsRequestPackets).getValue();
    }

    public void setUtsIpDhcpServerStatsRequestPackets(Integer aUtsIpDhcpServerStatsRequestPackets) {
        getProperty(utsIpDhcpServerStatsRequestPackets).setValue(aUtsIpDhcpServerStatsRequestPackets);
    }

    public Integer getUtsIpDhcpServerStatsReleasePackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsReleasePackets).getValue();
    }

    public void setUtsIpDhcpServerStatsReleasePackets(Integer aUtsIpDhcpServerStatsReleasePackets) {
        getProperty(utsIpDhcpServerStatsReleasePackets).setValue(aUtsIpDhcpServerStatsReleasePackets);
    }

    public Integer getUtsIpDhcpServerStatsDeclinePackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsDeclinePackets).getValue();
    }

    public void setUtsIpDhcpServerStatsDeclinePackets(Integer aUtsIpDhcpServerStatsDeclinePackets) {
        getProperty(utsIpDhcpServerStatsDeclinePackets).setValue(aUtsIpDhcpServerStatsDeclinePackets);
    }

    public Integer getUtsIpDhcpServerStatsInformPackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsInformPackets).getValue();
    }

    public void setUtsIpDhcpServerStatsInformPackets(Integer aUtsIpDhcpServerStatsInformPackets) {
        getProperty(utsIpDhcpServerStatsInformPackets).setValue(aUtsIpDhcpServerStatsInformPackets);
    }

    public Integer getUtsIpDhcpServerStatsinvalidPackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsinvalidPackets).getValue();
    }

    public void setUtsIpDhcpServerStatsinvalidPackets(Integer aUtsIpDhcpServerStatsinvalidPackets) {
        getProperty(utsIpDhcpServerStatsinvalidPackets).setValue(aUtsIpDhcpServerStatsinvalidPackets);
    }

    public Integer getUtsIpDhcpServerStatsOfferPackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsOfferPackets).getValue();
    }

    public void setUtsIpDhcpServerStatsOfferPackets(Integer aUtsIpDhcpServerStatsOfferPackets) {
        getProperty(utsIpDhcpServerStatsOfferPackets).setValue(aUtsIpDhcpServerStatsOfferPackets);
    }

    public Integer getUtsIpDhcpServerStatsAckPackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsAckPackets).getValue();
    }

    public void setUtsIpDhcpServerStatsAckPackets(Integer aUtsIpDhcpServerStatsAckPackets) {
        getProperty(utsIpDhcpServerStatsAckPackets).setValue(aUtsIpDhcpServerStatsAckPackets);
    }

    public Integer getUtsIpDhcpServerStatsNakPackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsNakPackets).getValue();
    }

    public void setUtsIpDhcpServerStatsNakPackets(Integer aUtsIpDhcpServerStatsNakPackets) {
        getProperty(utsIpDhcpServerStatsNakPackets).setValue(aUtsIpDhcpServerStatsNakPackets);
    }

    public Integer getUtsIpDhcpServerStatsReplyPackets() {
        return (Integer) getProperty(utsIpDhcpServerStatsReplyPackets).getValue();
    }

    public void setUtsIpDhcpServerStatsReplyPackets(Integer aUtsIpDhcpServerStatsReplyPackets) {
        getProperty(utsIpDhcpServerStatsReplyPackets).setValue(aUtsIpDhcpServerStatsReplyPackets);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsIpDhcpServerStatsFreeBindings));
        prepareRead(super.getProperty(utsIpDhcpServerStatsAutoBindings));
        prepareRead(super.getProperty(utsIpDhcpServerStatsExpiredBindings));
        prepareRead(super.getProperty(utsIpDhcpServerStatsOfferBindings));
        prepareRead(super.getProperty(utsIpDhcpServerStatsManualFree));
        prepareRead(super.getProperty(utsIpDhcpServerStatsManualBindings));
        prepareRead(super.getProperty(utsIpDhcpServerStatsManualExpired));
        prepareRead(super.getProperty(utsIpDhcpServerStatsManualOffer));
        prepareRead(super.getProperty(utsIpDhcpServerStatsDiscoverPackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsRequestPackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsReleasePackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsDeclinePackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsInformPackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsinvalidPackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsOfferPackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsAckPackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsNakPackets));
        prepareRead(super.getProperty(utsIpDhcpServerStatsReplyPackets));

        return load();
    }


}

package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPServerStatsMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The DHCPServerStatsMBeanPanel class.
 * Created by DVM Creator
 */
public class DHCPServerStatsMBeanPanel extends UPanel {

    private JLabel tfUtsIpDhcpServerStatsFreeBindings = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsAutoBindings = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsExpiredBindings = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsOfferBindings = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsManualFree = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsManualBindings = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsManualExpired = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsManualOffer = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsDiscoverPackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsRequestPackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsReleasePackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsDeclinePackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsInformPackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsOfferPackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsAckPackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsNakPackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsReplyPackets = new JLabel();
    private JLabel tfUtsIpDhcpServerStatsinvalidPackets = new JLabel();

    private final String utsIpDhcpServerStatsFreeBindings = fStringMap.getString("utsIpDhcpServerStatsFreeBindings") + " : ";
    private final String utsIpDhcpServerStatsAutoBindings = fStringMap.getString("utsIpDhcpServerStatsAutoBindings") + " : ";
    private final String utsIpDhcpServerStatsExpiredBindings = fStringMap.getString("utsIpDhcpServerStatsExpiredBindings") + " : ";
    private final String utsIpDhcpServerStatsOfferBindings = fStringMap.getString("utsIpDhcpServerStatsOfferBindings") + " : ";
    private final String utsIpDhcpServerStatsManualFree = fStringMap.getString("utsIpDhcpServerStatsManualFree") + " : ";
    private final String utsIpDhcpServerStatsManualBindings = fStringMap.getString("utsIpDhcpServerStatsManualBindings") + " : ";
    private final String utsIpDhcpServerStatsManualExpired = fStringMap.getString("utsIpDhcpServerStatsManualExpired") + " : ";
    private final String utsIpDhcpServerStatsManualOffer = fStringMap.getString("utsIpDhcpServerStatsManualOffer") + " : ";
    private final String utsIpDhcpServerStatsDiscoverPackets = fStringMap.getString("utsIpDhcpServerStatsDiscoverPackets") + " : ";
    private final String utsIpDhcpServerStatsRequestPackets = fStringMap.getString("utsIpDhcpServerStatsRequestPackets") + " : ";
    private final String utsIpDhcpServerStatsReleasePackets = fStringMap.getString("utsIpDhcpServerStatsReleasePackets") + " : ";
    private final String utsIpDhcpServerStatsDeclinePackets = fStringMap.getString("utsIpDhcpServerStatsDeclinePackets") + " : ";
    private final String utsIpDhcpServerStatsInformPackets = fStringMap.getString("utsIpDhcpServerStatsInformPackets") + " : ";
    private final String utsIpDhcpServerStatsinvalidPackets = fStringMap.getString("utsIpDhcpServerStatsinvalidPackets") + " : ";
    private final String utsIpDhcpServerStatsOfferPackets = fStringMap.getString("utsIpDhcpServerStatsOfferPackets") + " : ";
    private final String utsIpDhcpServerStatsAckPackets = fStringMap.getString("utsIpDhcpServerStatsAckPackets") + " : ";
    private final String utsIpDhcpServerStatsNakPackets = fStringMap.getString("utsIpDhcpServerStatsNakPackets") + " : ";
    private final String utsIpDhcpServerStatsReplyPackets = fStringMap.getString("utsIpDhcpServerStatsReplyPackets") + " : ";


    private SnmpRefreshButton btRefresh;


    public DHCPServerStatsMBeanPanel(IApplication app) {
        super(app);
        setModel(new DHCPServerStatsMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(18, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsFreeBindings));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsFreeBindings);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsAutoBindings));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsAutoBindings);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsExpiredBindings));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsExpiredBindings);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsOfferBindings));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsOfferBindings);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsManualFree));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsManualFree);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsManualBindings));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsManualBindings);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsManualExpired));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsManualExpired);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsManualOffer));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsManualOffer);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsDiscoverPackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsDiscoverPackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsRequestPackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsRequestPackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsReleasePackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsReleasePackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsDeclinePackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsDeclinePackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsInformPackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsInformPackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsinvalidPackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsinvalidPackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsOfferPackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsOfferPackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsAckPackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsAckPackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsNakPackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsNakPackets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsIpDhcpServerStatsReplyPackets));
        baseInfoPanel.add(tfUtsIpDhcpServerStatsReplyPackets);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);


    }

    protected void initForm() {


    }

    public void refresh() {

        DHCPServerStatsMBean mbean = (DHCPServerStatsMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);


        tfUtsIpDhcpServerStatsFreeBindings.setText(mbean.getUtsIpDhcpServerStatsFreeBindings().toString());
        tfUtsIpDhcpServerStatsAutoBindings.setText(mbean.getUtsIpDhcpServerStatsAutoBindings().toString());
        tfUtsIpDhcpServerStatsExpiredBindings.setText(mbean.getUtsIpDhcpServerStatsExpiredBindings().toString());
        tfUtsIpDhcpServerStatsOfferBindings.setText(mbean.getUtsIpDhcpServerStatsOfferBindings().toString());
        tfUtsIpDhcpServerStatsManualFree.setText(mbean.getUtsIpDhcpServerStatsManualFree().toString());
        tfUtsIpDhcpServerStatsManualBindings.setText(mbean.getUtsIpDhcpServerStatsManualBindings().toString());
        tfUtsIpDhcpServerStatsManualExpired.setText(mbean.getUtsIpDhcpServerStatsManualExpired().toString());
        tfUtsIpDhcpServerStatsManualOffer.setText(mbean.getUtsIpDhcpServerStatsManualOffer().toString());
        tfUtsIpDhcpServerStatsDiscoverPackets.setText(mbean.getUtsIpDhcpServerStatsDiscoverPackets().toString());
        tfUtsIpDhcpServerStatsRequestPackets.setText(mbean.getUtsIpDhcpServerStatsRequestPackets().toString());
        tfUtsIpDhcpServerStatsReleasePackets.setText(mbean.getUtsIpDhcpServerStatsReleasePackets().toString());
        tfUtsIpDhcpServerStatsDeclinePackets.setText(mbean.getUtsIpDhcpServerStatsDeclinePackets().toString());
        tfUtsIpDhcpServerStatsInformPackets.setText(mbean.getUtsIpDhcpServerStatsInformPackets().toString());
        tfUtsIpDhcpServerStatsinvalidPackets.setText(mbean.getUtsIpDhcpServerStatsinvalidPackets().toString());
        tfUtsIpDhcpServerStatsOfferPackets.setText(mbean.getUtsIpDhcpServerStatsOfferPackets().toString());
        tfUtsIpDhcpServerStatsAckPackets.setText(mbean.getUtsIpDhcpServerStatsAckPackets().toString());
        tfUtsIpDhcpServerStatsNakPackets.setText(mbean.getUtsIpDhcpServerStatsNakPackets().toString());
        tfUtsIpDhcpServerStatsReplyPackets.setText(mbean.getUtsIpDhcpServerStatsReplyPackets().toString());

    }

    public void updateModel() {

        DHCPServerStatsMBean mbean = (DHCPServerStatsMBean) getModel();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

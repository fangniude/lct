package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.EPortStaticsCounterTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ONUPortStaticsCounterTableMBeanPanel class.
 * Created by DVM Creator
 */
public class EPortStaticsCounterTableMBeanPanel extends UPanel {

    private JLabel tfUtsEthIfExtIndex = new JLabel();

    private JLabel tfUtsEthIfHCInOctets = new JLabel();

    private JLabel tfUtsEthIfHCInUcastPkts = new JLabel();

    private JLabel tfUtsEthIfHCInMulticastPkts = new JLabel();

    private JLabel tfUtsEthIfHCInBroadcastPkts = new JLabel();

    private JLabel tfUtsEthIfHCOutOctets = new JLabel();

    private JLabel tfUtsEthIfHCOutUcastPkts = new JLabel();

    private JLabel tfUtsEthIfHCOutMulticastPkts = new JLabel();

    private JLabel tfUtsEthIfHCOutBroadcastPkts = new JLabel();


    private final String utsEthIfExtIndex = fStringMap.getString("utsEthIfExtIndex") + " : ";
    private final String utsEthIfHCInOctets = fStringMap.getString("utsEthIfHCInOctets") + " : ";
    private final String utsEthIfHCInUcastPkts = fStringMap.getString("utsEthIfHCInUcastPkts") + " : ";
    private final String utsEthIfHCInMulticastPkts = fStringMap.getString("utsEthIfHCInMulticastPkts") + " : ";
    private final String utsEthIfHCInBroadcastPkts = fStringMap.getString("utsEthIfHCInBroadcastPkts") + " : ";
    private final String utsEthIfHCOutOctets = fStringMap.getString("utsEthIfHCOutOctets") + " : ";
    private final String utsEthIfHCOutUcastPkts = fStringMap.getString("utsEthIfHCOutUcastPkts") + " : ";
    private final String utsEthIfHCOutMulticastPkts = fStringMap.getString("utsEthIfHCOutMulticastPkts") + " : ";
    private final String utsEthIfHCOutBroadcastPkts = fStringMap.getString("utsEthIfHCOutBroadcastPkts") + " : ";


    public EPortStaticsCounterTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(67, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsEthIfExtIndex));
        baseInfoPanel.add(tfUtsEthIfExtIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthIfHCInOctets));
        baseInfoPanel.add(tfUtsEthIfHCInOctets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthIfHCInUcastPkts));
        baseInfoPanel.add(tfUtsEthIfHCInUcastPkts);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthIfHCInMulticastPkts));
        baseInfoPanel.add(tfUtsEthIfHCInMulticastPkts);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthIfHCInBroadcastPkts));
        baseInfoPanel.add(tfUtsEthIfHCInBroadcastPkts);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthIfHCOutOctets));
        baseInfoPanel.add(tfUtsEthIfHCOutOctets);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthIfHCOutUcastPkts));
        baseInfoPanel.add(tfUtsEthIfHCOutUcastPkts);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthIfHCOutMulticastPkts));
        baseInfoPanel.add(tfUtsEthIfHCOutMulticastPkts);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEthIfHCOutBroadcastPkts));
        baseInfoPanel.add(tfUtsEthIfHCOutBroadcastPkts);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);


    }

    protected void initForm() {


    }

    public void refresh() {

        EPortStaticsCounterTableMBean mbean = (EPortStaticsCounterTableMBean) getModel();

        tfUtsEthIfExtIndex.setText(mbean.getUtsEthIfExtIndex().toString());
        tfUtsEthIfHCInOctets.setText(mbean.getUtsEthIfHCInOctets().toString());
        tfUtsEthIfHCInUcastPkts.setText(mbean.getUtsEthIfHCInUcastPkts().toString());
        tfUtsEthIfHCInMulticastPkts.setText(mbean.getUtsEthIfHCInMulticastPkts().toString());
        tfUtsEthIfHCInBroadcastPkts.setText(mbean.getUtsEthIfHCInBroadcastPkts().toString());
        tfUtsEthIfHCOutOctets.setText(mbean.getUtsEthIfHCOutOctets().toString());
        tfUtsEthIfHCOutUcastPkts.setText(mbean.getUtsEthIfHCOutUcastPkts().toString());
        tfUtsEthIfHCOutMulticastPkts.setText(mbean.getUtsEthIfHCOutMulticastPkts().toString());
        tfUtsEthIfHCOutBroadcastPkts.setText(mbean.getUtsEthIfHCOutBroadcastPkts().toString());

    }

    public void updateModel() {

        EPortStaticsCounterTableMBean mbean = (EPortStaticsCounterTableMBean) getModel();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

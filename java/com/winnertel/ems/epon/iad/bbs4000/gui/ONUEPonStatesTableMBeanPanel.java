package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.ONUEPonStatesTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ONUEPonStatesTableMBeanPanel class.
 * Created by DVM Creator
 */
public class ONUEPonStatesTableMBeanPanel extends UPanel {

    private JLabel tfUtsPonIfExtIndex = new JLabel();

    private JLabel tfUtsPonIfExtStatsFramePonTxOk = new JLabel();

    private JLabel tfUtsPonIfExtStatsFramePonRxOk = new JLabel();

    private JLabel tfUtsPonIfExtStatsFramePonRxErr = new JLabel();

    private final String utsPonIfExtIndex = fStringMap.getString("utsPonIfExtIndex") + " : ";
    private final String utsPonIfExtStatsFramePonTxOk = fStringMap.getString("utsPonIfExtStatsFramePonTxOk") + " : ";
    private final String utsPonIfExtStatsFramePonRxOk = fStringMap.getString("utsPonIfExtStatsFramePonRxOk") + " : ";
    private final String utsPonIfExtStatsFramePonRxErr = fStringMap.getString("utsPonIfExtStatsFramePonRxErr") + " : ";


    public ONUEPonStatesTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(86, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsPonIfExtIndex));
        baseInfoPanel.add(tfUtsPonIfExtIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsPonIfExtStatsFramePonTxOk));
        baseInfoPanel.add(tfUtsPonIfExtStatsFramePonTxOk);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsPonIfExtStatsFramePonRxOk));
        baseInfoPanel.add(tfUtsPonIfExtStatsFramePonRxOk);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsPonIfExtStatsFramePonRxErr));
        baseInfoPanel.add(tfUtsPonIfExtStatsFramePonRxErr);
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

        ONUEPonStatesTableMBean mbean = (ONUEPonStatesTableMBean) getModel();

        tfUtsPonIfExtIndex.setText(mbean.getUtsPonIfExtIndex().toString());
        tfUtsPonIfExtStatsFramePonTxOk.setText(mbean.getUtsPonIfExtStatsFramePonTxOk().toString());
        tfUtsPonIfExtStatsFramePonRxOk.setText(mbean.getUtsPonIfExtStatsFramePonRxOk().toString());
        tfUtsPonIfExtStatsFramePonRxErr.setText(mbean.getUtsPonIfExtStatsFramePonRxErr().toString());
    }

    public void updateModel() {

        ONUEPonStatesTableMBean mbean = (ONUEPonStatesTableMBean) getModel();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

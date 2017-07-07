package com.winnertel.ems.epon.iad.bbs4000.gui;

/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The SysCommuTableMBeanPanel class.
 * Created by DVM Creator
 */
public class SNMPConfigPanel extends UPanel {

    SnmpTablePane tablepanel1;
    SnmpTablePane tablepanel2;

    public SNMPConfigPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

//        JPanel baseInfoPanel = new JPanel();
//         layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
//        layout.setMargins(6, 10, 6, 10);
//        baseInfoPanel.setLayout(layout);
//        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel allPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
//        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);


        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel1 = (SnmpTablePane) composer1.composeSnmpTablePane("SysCommunityTable");
        tablepanel1.setPreferredSize(new Dimension(100, 200));
        tablepanel1.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsSysCommunityTable")));

        IGuiComposer composer2 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel2 = (SnmpTablePane) composer2.composeSnmpTablePane("EponTrapTable");
        tablepanel2.setPreferredSize(new Dimension(100, 200));
        tablepanel2.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsEponTrapTable")));
        allPanel.add(tablepanel1);
//        allPanel.add(new VSpacer());
        allPanel.add(tablepanel2);
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.NORTH);

        tablepanel1.refresh();
        tablepanel2.refresh();

        this.setPreferredSize(new Dimension(100, 200));

    }

    protected void initForm() {


    }

    public void refresh() {


    }

    public void updateModel() {
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

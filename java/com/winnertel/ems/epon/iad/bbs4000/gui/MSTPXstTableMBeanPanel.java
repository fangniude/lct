package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.MSTPXstTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The MSTPXstTableMBeanPanel class.
 * Created by DVM Creator
 */
public class MSTPXstTableMBeanPanel extends UPanel {

    private Object[] utsMstpXstBridgePriorityVList = {"0","4096","8192","12288","16384",
                                                      "20480","24576","28672","32768",
                                                      "36864","40960","45056","49152",
                                                      "53248","57344","61440"};
    private JComboBox tfMstpXstBridgePriority = new JComboBox(utsMstpXstBridgePriorityVList);

    private final String mstpXstBridgePriority = fStringMap.getString("mstpXstBridgePriority") + " : ";

    public MSTPXstTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(mstpXstBridgePriority));
        tfMstpXstBridgePriority.setName(fStringMap.getString("mstpXstBridgePriority"));
        baseInfoPanel.add(tfMstpXstBridgePriority);
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

        MSTPXstTableMBean mbean = (MSTPXstTableMBean) getModel();

//        tfMstpXstId.setText(mbean.getMstpXstId().toString());
        tfMstpXstBridgePriority.setSelectedItem(mbean.getMstpXstBridgePriority().toString());
//        tfMstpXstBridgeId.setText(mbean.getMstpXstBridgeId());
//        tfMstpXstDesignatedRoot.setText(mbean.getMstpXstDesignatedRoot());
//        tfMstpXstDesignatedBridge.setText(mbean.getMstpXstDesignatedBridge());
//        tfMstpXstInternalRootCost.setText(mbean.getMstpXstInternalRootCost().toString());
//        tfMstpXstRootPort.setText(mbean.getMstpXstRootPort().toString());
//        tfMstpXstMasterPort.setText(mbean.getMstpXstMasterPort().toString());
//        tfMstpXstTimeSinceTopologyChange.setText(mbean.getMstpXstTimeSinceTopologyChange().toString());
//        tfMstpXstTopologyChangesCount.setText(mbean.getMstpXstTopologyChangesCount().toString());
//        tfMstpXstTopologyChangeFlag.setSelectedIndex(getIndexFromValue(mstpXstTopologyChangeFlagVList, mbean.getMstpXstTopologyChangeFlag().intValue()));

    }

    public void updateModel() {

        MSTPXstTableMBean mbean = (MSTPXstTableMBean) getModel();


        mbean.setMstpXstBridgePriority(new Integer(tfMstpXstBridgePriority.getSelectedItem().toString()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

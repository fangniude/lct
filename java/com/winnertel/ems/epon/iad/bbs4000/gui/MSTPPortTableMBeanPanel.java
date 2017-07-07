package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.MSTPPortTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The MSTPPortTableMBeanPanel class.
 * Created by DVM Creator
 */
public class MSTPPortTableMBeanPanel extends UPanel {

    private JLabel tfMstpPortIndex = new JLabel();

    private int[] mstpPortAdminEdgeVList = new int[]{
        1, 2, };
    private String[] mstpPortAdminEdgeTList = new String[]{
        fStringMap.getString("enable"),
        fStringMap.getString("disable"),
    };
    private JComboBox tfMstpPortAdminEdge = new JComboBox(mstpPortAdminEdgeTList);

    private int[] mstpPortAdminPointToPointVList = new int[]{
        1, 0 };
    private String[] mstpPortAdminPointToPointTList = new String[]{
        fStringMap.getString("forceFalse"),
        fStringMap.getString("forceTrue"),
//        fStringMap.getString("auto"),
    };
    private JComboBox tfMstpPortAdminPointToPoint = new JComboBox(mstpPortAdminPointToPointTList);


    private final String mstpPortIndex = fStringMap.getString("mstpPortIndex") + " : ";
//    private final String mstpPortAdminMACEnable = fStringMap.getString("mstpPortAdminMACEnable") + " : ";
    private final String mstpPortAdminEdge = fStringMap.getString("mstpPortAdminEdge") + " : ";
    private final String mstpPortAdminPointToPoint = fStringMap.getString("mstpPortAdminPointToPoint") + " : ";


    public MSTPPortTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(mstpPortIndex));
        baseInfoPanel.add(tfMstpPortIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpPortAdminEdge));
        tfMstpPortAdminEdge.setName(fStringMap.getString("mstpPortAdminEdge"));
        baseInfoPanel.add(tfMstpPortAdminEdge);
        baseInfoPanel.add(new HSpacer());



        baseInfoPanel.add(new JLabel(mstpPortAdminPointToPoint));
        tfMstpPortAdminPointToPoint.setName(fStringMap.getString("mstpPortAdminPointToPoint"));
        baseInfoPanel.add(tfMstpPortAdminPointToPoint);
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

        MSTPPortTableMBean mbean = (MSTPPortTableMBean) getModel();

        tfMstpPortIndex.setText(mbean.getMstpPortIndex().toString());
        tfMstpPortAdminEdge.setSelectedIndex(getIndexFromValue(mstpPortAdminEdgeVList, mbean.getMstpPortAdminEdge().intValue()));
        tfMstpPortAdminPointToPoint.setSelectedIndex(getIndexFromValue(mstpPortAdminPointToPointVList, mbean.getMstpPortAdminPointToPoint().intValue()));

    }

    public void updateModel() {

        MSTPPortTableMBean mbean = (MSTPPortTableMBean) getModel();

        mbean.setMstpPortAdminEdge(new Integer(mstpPortAdminEdgeVList[tfMstpPortAdminEdge.getSelectedIndex()]));

        mbean.setMstpPortAdminPointToPoint(new Integer(mstpPortAdminPointToPointVList[tfMstpPortAdminPointToPoint.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

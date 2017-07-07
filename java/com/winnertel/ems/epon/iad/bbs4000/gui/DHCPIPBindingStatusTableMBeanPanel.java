package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPIPBindingStatusTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The DHCPIPBindingStatusTableMBeanPanel class.
 * Created by DVM Creator
 */
public class DHCPIPBindingStatusTableMBeanPanel extends UPanel {

    private StringTextField tfUtsDHCPPoolName = new StringTextField();
//
//    private JLabel tfUtsIpDHCPPoolBindingIpAddress = new JLabel();
//
//    private JLabel tfUtsIpDHCPPoolBindingVlanId = new JLabel();

//    private int[] utsIpDHCPPoolBindingStateVList = new int[]{
//        1, 4, 2, 3, };
//    private String[] utsIpDHCPPoolBindingStateTList = new String[]{
//        fStringMap.getString("free"),
//        fStringMap.getString("bind"),
//        fStringMap.getString("expire"),
//        fStringMap.getString("offer"),
//    };
//    private JComboBox tfUtsIpDHCPPoolBindingState = new JComboBox(utsIpDHCPPoolBindingStateTList);
//    private int[] utsIpDHCPPoolBindingTypeVList = new int[]{
//        3, 2, 1, };
//    private String[] utsIpDHCPPoolBindingTypeTList = new String[]{
//        fStringMap.getString("framed"),
//        fStringMap.getString("manual"),
//        fStringMap.getString("automatic"),
//    };
//    private JComboBox tfUtsIpDHCPPoolBindingType = new JComboBox(utsIpDHCPPoolBindingTypeTList);
//    private JLabel tfUtsIpDHCPPoolBindingHardwareAddress = new JLabel();
//
//    private JLabel tfUtsIpDHCPPoolBindingLeaseExpiredTime = new JLabel();
//
//    private int[] utsIpDHCPPoolBindingClearVList = new int[]{
//        1, 0, };
//    private String[] utsIpDHCPPoolBindingClearTList = new String[]{
//        fStringMap.getString("clear"),
//        fStringMap.getString("normal"),
//    };
//    private JComboBox tfUtsIpDHCPPoolBindingClear = new JComboBox(utsIpDHCPPoolBindingClearTList);
//
//
    private final String utsDHCPPoolName = fStringMap.getString("utsDHCPPoolName") + " : ";
//    private final String utsIpDHCPPoolBindingIpAddress = fStringMap.getString("utsIpDHCPPoolBindingIpAddress") + " : ";
//    private final String utsIpDHCPPoolBindingVlanId = fStringMap.getString("utsIpDHCPPoolBindingVlanId") + " : ";
//    private final String utsIpDHCPPoolBindingState = fStringMap.getString("utsIpDHCPPoolBindingState") + " : ";
//    private final String utsIpDHCPPoolBindingType = fStringMap.getString("utsIpDHCPPoolBindingType") + " : ";
//    private final String utsIpDHCPPoolBindingHardwareAddress = fStringMap.getString("utsIpDHCPPoolBindingHardwareAddress") + " : ";
//    private final String utsIpDHCPPoolBindingLeaseExpiredTime = fStringMap.getString("utsIpDHCPPoolBindingLeaseExpiredTime") + " : ";
//    private final String utsIpDHCPPoolBindingClear = fStringMap.getString("utsIpDHCPPoolBindingClear") + " : ";


    public DHCPIPBindingStatusTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel("Do you want to apply this action to the address?"));

//        baseInfoPanel.add(new JLabel(utsDHCPPoolName));
//        tfUtsDHCPPoolName.setName(fStringMap.getString("utsDHCPPoolName"));
//        baseInfoPanel.add(tfUtsDHCPPoolName);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(utsIpDHCPPoolBindingIpAddress));
//        baseInfoPanel.add(tfUtsIpDHCPPoolBindingIpAddress);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(utsIpDHCPPoolBindingVlanId));
//        baseInfoPanel.add(tfUtsIpDHCPPoolBindingVlanId);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(utsIpDHCPPoolBindingState));
//        baseInfoPanel.add(tfUtsIpDHCPPoolBindingState);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(utsIpDHCPPoolBindingType));
//        baseInfoPanel.add(tfUtsIpDHCPPoolBindingType);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(utsIpDHCPPoolBindingHardwareAddress));
//        baseInfoPanel.add(tfUtsIpDHCPPoolBindingHardwareAddress);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(utsIpDHCPPoolBindingLeaseExpiredTime));
//        baseInfoPanel.add(tfUtsIpDHCPPoolBindingLeaseExpiredTime);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(utsIpDHCPPoolBindingClear));
//        tfUtsIpDHCPPoolBindingClear.setName(fStringMap.getString("utsIpDHCPPoolBindingClear"));
//        baseInfoPanel.add(tfUtsIpDHCPPoolBindingClear);
//        baseInfoPanel.add(new HSpacer());


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
//        tfUtsDHCPPoolName.setLenScope(0, 63);
//              tfUtsIpDHCPPoolBindingHardwareAddress.setEditable( false ) ;


    }

    public void refresh() {

        DHCPIPBindingStatusTableMBean mbean = (DHCPIPBindingStatusTableMBean) getModel();
//
        tfUtsDHCPPoolName.setValue(mbean.getUtsDHCPPoolName());
//        tfUtsIpDHCPPoolBindingIpAddress.setText(mbean.getUtsIpDHCPPoolBindingIpAddress());
//        tfUtsIpDHCPPoolBindingVlanId.setText(mbean.getUtsIpDHCPPoolBindingVlanId().toString());
//        tfUtsIpDHCPPoolBindingState.setSelectedIndex(getIndexFromValue(utsIpDHCPPoolBindingStateVList, mbean.getUtsIpDHCPPoolBindingState().intValue()));
//        tfUtsIpDHCPPoolBindingType.setSelectedIndex(getIndexFromValue(utsIpDHCPPoolBindingTypeVList, mbean.getUtsIpDHCPPoolBindingType().intValue()));
////         tfUtsIpDHCPPoolBindingHardwareAddress.setValue( mbean.getUtsIpDHCPPoolBindingHardwareAddress()) ;
//        tfUtsIpDHCPPoolBindingLeaseExpiredTime.setText(mbean.getUtsIpDHCPPoolBindingLeaseExpiredTime());
//        tfUtsIpDHCPPoolBindingClear.setSelectedIndex(getIndexFromValue(utsIpDHCPPoolBindingClearVList, mbean.getUtsIpDHCPPoolBindingClear().intValue()));

    }

    public void updateModel() {

        DHCPIPBindingStatusTableMBean mbean = (DHCPIPBindingStatusTableMBean) getModel();

        mbean.setUtsDHCPPoolName(new String(tfUtsDHCPPoolName.getValue()));


        mbean.setUtsIpDHCPPoolBindingClear(new Integer(1));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}


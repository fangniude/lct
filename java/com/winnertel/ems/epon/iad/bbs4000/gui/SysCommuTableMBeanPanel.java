package com.winnertel.ems.epon.iad.bbs4000.gui;

/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.SysCommuTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The SysCommuTableMBeanPanel class.
 * Created by DVM Creator
 */
public class SysCommuTableMBeanPanel extends UPanel {

    private JLabel tfUtsSysCommunityIndex = new JLabel();

    private StringTextField tfUtsSysCommunityString = new StringTextField();

    private int[] utsSysCommunityAccessVList = new int[]{
        2, 1, };
    private String[] utsSysCommunityAccessTList = new String[]{
        fStringMap.getString("readWrite"),
        fStringMap.getString("readOnly"),
    };
    private JComboBox tfUtsSysCommunityAccess = new JComboBox(utsSysCommunityAccessTList);
    private int[] utsSysCommunityRowStatusVList = new int[]{
        1, 2, 5, 4, 3, 6, };
    private String[] utsSysCommunityRowStatusTList = new String[]{
        fStringMap.getString("active"),
        fStringMap.getString("notInService"),
        fStringMap.getString("createAndWait"),
        fStringMap.getString("createAndGo"),
        fStringMap.getString("notReady"),
        fStringMap.getString("destroy"),
    };
    private JComboBox tfUtsSysCommunityRowStatus = new JComboBox(utsSysCommunityRowStatusTList);


    private final String utsSysCommunityIndex = fStringMap.getString("utsSysCommunityIndex") + " : ";
    private final String utsSysCommunityString = fStringMap.getString("utsSysCommunityString") + " : ";
    private final String utsSysCommunityAccess = fStringMap.getString("utsSysCommunityAccess") + " : ";


    public SysCommuTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

//        baseInfoPanel.add(new JLabel(utsSysCommunityIndex));
//        baseInfoPanel.add(tfUtsSysCommunityIndex);
//        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSysCommunityString));
        tfUtsSysCommunityString.setName(fStringMap.getString("utsSysCommunityString"));
        baseInfoPanel.add(tfUtsSysCommunityString);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSysCommunityAccess));
        tfUtsSysCommunityAccess.setName(fStringMap.getString("utsSysCommunityAccess"));
        baseInfoPanel.add(tfUtsSysCommunityAccess);
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
        tfUtsSysCommunityString.setLenScope(1, 32);

    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            return;
        }

        SysCommuTableMBean mbean = (SysCommuTableMBean) getModel();

        BeanService.refreshBean(fApplication, mbean);

        tfUtsSysCommunityIndex.setText(mbean.getUtsSysCommunityIndex().toString());
        tfUtsSysCommunityString.setValue(mbean.getUtsSysCommunityString());
        tfUtsSysCommunityAccess.setSelectedIndex(getIndexFromValue(utsSysCommunityAccessVList, mbean.getUtsSysCommunityAccess().intValue()));


    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new SysCommuTableMBean(fApplication.getSnmpProxy()));

        SysCommuTableMBean mbean = (SysCommuTableMBean) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            int t = 1;
            for(int i=0;i<v.size();i++){
                SysCommuTableMBean one = (SysCommuTableMBean)v.get(i);
                if(t == one.getUtsSysCommunityIndex().intValue()){
                    t++;
                    continue;
                }
                else{
                    break;
                }
            }
            if(t!=5){
                mbean.setUtsSysCommunityIndex(new Integer(t));
            }


        }


        mbean.setUtsSysCommunityString(new String(tfUtsSysCommunityString.getValue()));
        mbean.setUtsSysCommunityAccess(new Integer(utsSysCommunityAccessVList[tfUtsSysCommunityAccess.getSelectedIndex()]));
//          mbean.setUtsSysCommunityRowStatus(new Integer(utsSysCommunityRowStatusVList[tfUtsSysCommunityRowStatus.getSelectedIndex()]));]
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    public void afterUpdateModel() {
        GuiUtil.getParentDialog( this ).dispose();

    }

}

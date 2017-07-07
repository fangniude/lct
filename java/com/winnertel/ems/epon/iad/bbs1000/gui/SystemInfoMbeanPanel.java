package com.winnertel.ems.epon.iad.bbs1000.gui;

/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs1000.mib.SystemInfoMBean;
import com.winnertel.em.broadband.common.util.OEMClientUtils;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The SystemInfoMbeanPanel class.
 * Created by DVM Creator
 */
public class SystemInfoMbeanPanel extends UPanel {

    private JLabel tfSysDescr = new JLabel();
    private JLabel tfSysObjectID = new JLabel();
    private JLabel tfSysUpTime = new JLabel();

    private StringTextField tfSysContact = new StringTextField();

    private StringTextField tfSysName = new StringTextField();

    private StringTextField tfSysLocation = new StringTextField();

    private JLabel tfSysServices = new JLabel();


    private final String sysDescr = fStringMap.getString("sysDescr") + " : ";
    private final String sysObjectID = fStringMap.getString("sysObjectID") + " : ";
    private final String sysUpTime = fStringMap.getString("sysUpTime") + " : ";
    private final String sysContact = fStringMap.getString("sysContact") + " : ";
    private final String sysName = fStringMap.getString("sysName") + " : ";
    private final String sysLocation = fStringMap.getString("sysLocation") + " : ";
    private final String sysServices = fStringMap.getString("sysServices") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public SystemInfoMbeanPanel(IApplication app) {
        super(app);
      setModel(new SystemInfoMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SystemInfoMbean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(sysDescr));
        baseInfoPanel.add(tfSysDescr);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sysObjectID));
        baseInfoPanel.add(tfSysObjectID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sysUpTime));
        baseInfoPanel.add(tfSysUpTime);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sysContact));
        tfSysContact.setName(fStringMap.getString("sysContact"));
        baseInfoPanel.add(tfSysContact);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sysName));
        tfSysName.setName(fStringMap.getString("sysName"));
        baseInfoPanel.add(tfSysName);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sysLocation));
        tfSysLocation.setName(fStringMap.getString("sysLocation"));
        baseInfoPanel.add(tfSysLocation);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sysServices));
        baseInfoPanel.add(tfSysServices);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());

        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.SOUTH);
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {


        tfSysContact.setLenScope(0, 255);

        tfSysName.setLenScope(0, 255);

        tfSysLocation.setLenScope(0, 255);


    }

    public void refresh() {

        SystemInfoMBean mbean = (SystemInfoMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfSysDescr.setText(mbean.getSysDescr());
        tfSysObjectID.setText(OEMClientUtils.getLabelByNEType(mbean.getSysObjectID()));
        tfSysUpTime.setText(mbean.getSysUpTime().toString());
        tfSysContact.setValue(mbean.getSysContact());
        tfSysName.setValue(mbean.getSysName());
        tfSysLocation.setValue(mbean.getSysLocation());
        tfSysServices.setText(mbean.getSysServices());

    }

    public void updateModel() {
        SystemInfoMBean mbean = (SystemInfoMBean) getModel();

        mbean.setSysContact(new String(tfSysContact.getValue()));
        mbean.setSysName(new String(tfSysName.getValue()));
        mbean.setSysLocation(new String(tfSysLocation.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.SyslogServerTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The SyslogServerTableMBeanPanel class.
 * Created by DVM Creator
 */
public class SyslogServerTableMBeanPanel extends UPanel {

    private JLabel tfUtsSyslogServerId = new JLabel();

    private IPAddressField tfUtsSyslogServerIpAddress = new IPAddressField();

    private IntegerTextField tfUtsSyslogServerPort = new IntegerTextField();

    private int[] utsSyslogServerFacilityAuthVList = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsSyslogServerFacilityAuthTList = new String[]{
        fStringMap.getString("emergencies"),
        fStringMap.getString("alerts"),
        fStringMap.getString("critical"),
        fStringMap.getString("errors"),
        fStringMap.getString("warning"),
        fStringMap.getString("notification"),
        fStringMap.getString("informational"),
        fStringMap.getString("debugging"),
    };
    private JComboBox tfUtsSyslogServerFacilityAuth = new JComboBox(utsSyslogServerFacilityAuthTList);
    private int[] utsSyslogServerFacilityDhcpVList = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsSyslogServerFacilityDhcpTList = new String[]{
        fStringMap.getString("emergencies"),
        fStringMap.getString("alerts"),
        fStringMap.getString("critical"),
        fStringMap.getString("errors"),
        fStringMap.getString("warning"),
        fStringMap.getString("notification"),
        fStringMap.getString("informational"),
        fStringMap.getString("debugging"),
    };
    private JComboBox tfUtsSyslogServerFacilityDhcp = new JComboBox(utsSyslogServerFacilityDhcpTList);
    private int[] utsSyslogServerFacilityEthernetVList = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsSyslogServerFacilityEthernetTList = new String[]{
        fStringMap.getString("emergencies"),
        fStringMap.getString("alerts"),
        fStringMap.getString("critical"),
        fStringMap.getString("errors"),
        fStringMap.getString("warning"),
        fStringMap.getString("notification"),
        fStringMap.getString("informational"),
        fStringMap.getString("debugging"),
    };
    private JComboBox tfUtsSyslogServerFacilityEthernet = new JComboBox(utsSyslogServerFacilityEthernetTList);
    private int[] utsSyslogServerFacilityPonVList = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsSyslogServerFacilityPonTList = new String[]{
        fStringMap.getString("emergencies"),
        fStringMap.getString("alerts"),
        fStringMap.getString("critical"),
        fStringMap.getString("errors"),
        fStringMap.getString("warning"),
        fStringMap.getString("notification"),
        fStringMap.getString("informational"),
        fStringMap.getString("debugging"),
    };
    private JComboBox tfUtsSyslogServerFacilityPon = new JComboBox(utsSyslogServerFacilityPonTList);
    private int[] utsSyslogServerFacilitySnmpVList = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsSyslogServerFacilitySnmpTList = new String[]{
        fStringMap.getString("emergencies"),
        fStringMap.getString("alerts"),
        fStringMap.getString("critical"),
        fStringMap.getString("errors"),
        fStringMap.getString("warning"),
        fStringMap.getString("notification"),
        fStringMap.getString("informational"),
        fStringMap.getString("debugging"),
    };
    private JComboBox tfUtsSyslogServerFacilitySnmp = new JComboBox(utsSyslogServerFacilitySnmpTList);
    private int[] utsSyslogServerFacilitySysVList = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsSyslogServerFacilitySysTList = new String[]{
        fStringMap.getString("emergencies"),
        fStringMap.getString("alerts"),
        fStringMap.getString("critical"),
        fStringMap.getString("errors"),
        fStringMap.getString("warning"),
        fStringMap.getString("notification"),
        fStringMap.getString("informational"),
        fStringMap.getString("debugging"),
    };
    private JComboBox tfUtsSyslogServerFacilitySys = new JComboBox(utsSyslogServerFacilitySysTList);
    private int[] utsSyslogServerFacilitySyslogVList = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsSyslogServerFacilitySyslogTList = new String[]{
        fStringMap.getString("emergencies"),
        fStringMap.getString("alerts"),
        fStringMap.getString("critical"),
        fStringMap.getString("errors"),
        fStringMap.getString("warning"),
        fStringMap.getString("notification"),
        fStringMap.getString("informational"),
        fStringMap.getString("debugging"),
    };
    private JComboBox tfUtsSyslogServerFacilitySyslog = new JComboBox(utsSyslogServerFacilitySyslogTList);
    private int[] utsSyslogServerFacilityUserVList = new int[]{
        1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsSyslogServerFacilityUserTList = new String[]{
        fStringMap.getString("emergencies"),
        fStringMap.getString("alerts"),
        fStringMap.getString("critical"),
        fStringMap.getString("errors"),
        fStringMap.getString("warning"),
        fStringMap.getString("notification"),
        fStringMap.getString("informational"),
        fStringMap.getString("debugging"),
    };
    private JComboBox tfUtsSyslogServerFacilityUser = new JComboBox(utsSyslogServerFacilityUserTList);


    private final String utsSyslogServerId = fStringMap.getString("utsSyslogServerId") + " : ";
    private final String utsSyslogServerIpAddress = fStringMap.getString("utsSyslogServerIpAddress") + " : ";
    private final String utsSyslogServerPort = fStringMap.getString("utsSyslogServerPort") + " : ";
    private final String utsSyslogServerFacilityAuth = fStringMap.getString("utsSyslogServerFacilityAuth") + " : ";
    private final String utsSyslogServerFacilityDhcp = fStringMap.getString("utsSyslogServerFacilityDhcp") + " : ";
    private final String utsSyslogServerFacilityEthernet = fStringMap.getString("utsSyslogServerFacilityEthernet") + " : ";
    private final String utsSyslogServerFacilityPon = fStringMap.getString("utsSyslogServerFacilityPon") + " : ";
    private final String utsSyslogServerFacilitySnmp = fStringMap.getString("utsSyslogServerFacilitySnmp") + " : ";
    private final String utsSyslogServerFacilitySys = fStringMap.getString("utsSyslogServerFacilitySys") + " : ";
    private final String utsSyslogServerFacilitySyslog = fStringMap.getString("utsSyslogServerFacilitySyslog") + " : ";
    private final String utsSyslogServerFacilityUser = fStringMap.getString("utsSyslogServerFacilityUser") + " : ";


    public SyslogServerTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsSyslogServerId));
        baseInfoPanel.add(tfUtsSyslogServerId);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerIpAddress));
        tfUtsSyslogServerIpAddress.setName(fStringMap.getString("utsSyslogServerIpAddress"));
        baseInfoPanel.add(tfUtsSyslogServerIpAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerPort));
        tfUtsSyslogServerPort.setName(fStringMap.getString("utsSyslogServerPort"));
        baseInfoPanel.add(tfUtsSyslogServerPort);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerFacilityAuth));
        tfUtsSyslogServerFacilityAuth.setName(fStringMap.getString("utsSyslogServerFacilityAuth"));
        baseInfoPanel.add(tfUtsSyslogServerFacilityAuth);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerFacilityDhcp));
        tfUtsSyslogServerFacilityDhcp.setName(fStringMap.getString("utsSyslogServerFacilityDhcp"));
        baseInfoPanel.add(tfUtsSyslogServerFacilityDhcp);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerFacilityEthernet));
        tfUtsSyslogServerFacilityEthernet.setName(fStringMap.getString("utsSyslogServerFacilityEthernet"));
        baseInfoPanel.add(tfUtsSyslogServerFacilityEthernet);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerFacilityPon));
        tfUtsSyslogServerFacilityPon.setName(fStringMap.getString("utsSyslogServerFacilityPon"));
        baseInfoPanel.add(tfUtsSyslogServerFacilityPon);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerFacilitySnmp));
        tfUtsSyslogServerFacilitySnmp.setName(fStringMap.getString("utsSyslogServerFacilitySnmp"));
        baseInfoPanel.add(tfUtsSyslogServerFacilitySnmp);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerFacilitySys));
        tfUtsSyslogServerFacilitySys.setName(fStringMap.getString("utsSyslogServerFacilitySys"));
        baseInfoPanel.add(tfUtsSyslogServerFacilitySys);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerFacilitySyslog));
        tfUtsSyslogServerFacilitySyslog.setName(fStringMap.getString("utsSyslogServerFacilitySyslog"));
        baseInfoPanel.add(tfUtsSyslogServerFacilitySyslog);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSyslogServerFacilityUser));
        tfUtsSyslogServerFacilityUser.setName(fStringMap.getString("utsSyslogServerFacilityUser"));
        baseInfoPanel.add(tfUtsSyslogServerFacilityUser);
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


        tfUtsSyslogServerPort.setValueScope(1, 65535);
        tfUtsSyslogServerPort.setDefaultValue(514);
        tfUtsSyslogServerFacilityAuth.setSelectedIndex(4);
        tfUtsSyslogServerFacilityDhcp.setSelectedIndex(4);
        tfUtsSyslogServerFacilityEthernet.setSelectedIndex(4);
        tfUtsSyslogServerFacilityPon.setSelectedIndex(4);
        tfUtsSyslogServerFacilitySnmp.setSelectedIndex(4);
        tfUtsSyslogServerFacilitySys.setSelectedIndex(4);
        tfUtsSyslogServerFacilitySyslog.setSelectedIndex(4);
        tfUtsSyslogServerFacilityUser.setSelectedIndex(4);

    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            SyslogServerTableMBean mbean = new SyslogServerTableMBean(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            if (v == null)
                return;
            else {
                if (v.size() != 5)
                    return;
                else {
                    String error = "There are at most five records.";
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                }
            }
        }

        SyslogServerTableMBean mbean = (SyslogServerTableMBean) getModel();

        tfUtsSyslogServerId.setText(mbean.getUtsSyslogServerId().toString());
        tfUtsSyslogServerIpAddress.setValue(mbean.getUtsSyslogServerIpAddress());
        tfUtsSyslogServerPort.setValue(mbean.getUtsSyslogServerPort().intValue());
        tfUtsSyslogServerFacilityAuth.setSelectedIndex(getIndexFromValue(utsSyslogServerFacilityAuthVList, mbean.getUtsSyslogServerFacilityAuth().intValue()));
        tfUtsSyslogServerFacilityDhcp.setSelectedIndex(getIndexFromValue(utsSyslogServerFacilityDhcpVList, mbean.getUtsSyslogServerFacilityDhcp().intValue()));
        tfUtsSyslogServerFacilityEthernet.setSelectedIndex(getIndexFromValue(utsSyslogServerFacilityEthernetVList, mbean.getUtsSyslogServerFacilityEthernet().intValue()));
        tfUtsSyslogServerFacilityPon.setSelectedIndex(getIndexFromValue(utsSyslogServerFacilityPonVList, mbean.getUtsSyslogServerFacilityPon().intValue()));
        tfUtsSyslogServerFacilitySnmp.setSelectedIndex(getIndexFromValue(utsSyslogServerFacilitySnmpVList, mbean.getUtsSyslogServerFacilitySnmp().intValue()));
        tfUtsSyslogServerFacilitySys.setSelectedIndex(getIndexFromValue(utsSyslogServerFacilitySysVList, mbean.getUtsSyslogServerFacilitySys().intValue()));
        tfUtsSyslogServerFacilitySyslog.setSelectedIndex(getIndexFromValue(utsSyslogServerFacilitySyslogVList, mbean.getUtsSyslogServerFacilitySyslog().intValue()));
        tfUtsSyslogServerFacilityUser.setSelectedIndex(getIndexFromValue(utsSyslogServerFacilityUserVList, mbean.getUtsSyslogServerFacilityUser().intValue()));

    }

    public boolean validateFrom() {
        SyslogServerTableMBean mbean = (SyslogServerTableMBean) getModel();
        Vector v = BeanService.refreshTableBean(fApplication, mbean);
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                SyslogServerTableMBean one = (SyslogServerTableMBean) v.get(i);
                String ipaddress = one.getUtsSyslogServerIpAddress();
                if (tfUtsSyslogServerIpAddress.getValue().equals(ipaddress)) {
                    String error = fStringMap.getString("Err_Log_Server_IP_Exist");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
        }
        return true;
    }

    public void updateModel() {

        SyslogServerTableMBean mbean = (SyslogServerTableMBean) getModel();


        mbean.setUtsSyslogServerIpAddress(new String(tfUtsSyslogServerIpAddress.getIPString()));
        mbean.setUtsSyslogServerPort(new Integer(tfUtsSyslogServerPort.getValue()));
        mbean.setUtsSyslogServerFacilityAuth(new Integer(utsSyslogServerFacilityAuthVList[tfUtsSyslogServerFacilityAuth.getSelectedIndex()]));
        mbean.setUtsSyslogServerFacilityDhcp(new Integer(utsSyslogServerFacilityDhcpVList[tfUtsSyslogServerFacilityDhcp.getSelectedIndex()]));
        mbean.setUtsSyslogServerFacilityEthernet(new Integer(utsSyslogServerFacilityEthernetVList[tfUtsSyslogServerFacilityEthernet.getSelectedIndex()]));
        mbean.setUtsSyslogServerFacilityPon(new Integer(utsSyslogServerFacilityPonVList[tfUtsSyslogServerFacilityPon.getSelectedIndex()]));
        mbean.setUtsSyslogServerFacilitySnmp(new Integer(utsSyslogServerFacilitySnmpVList[tfUtsSyslogServerFacilitySnmp.getSelectedIndex()]));
        mbean.setUtsSyslogServerFacilitySys(new Integer(utsSyslogServerFacilitySysVList[tfUtsSyslogServerFacilitySys.getSelectedIndex()]));
        mbean.setUtsSyslogServerFacilitySyslog(new Integer(utsSyslogServerFacilitySyslogVList[tfUtsSyslogServerFacilitySyslog.getSelectedIndex()]));
        mbean.setUtsSyslogServerFacilityUser(new Integer(utsSyslogServerFacilityUserVList[tfUtsSyslogServerFacilityUser.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

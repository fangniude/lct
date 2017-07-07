package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.SecurityMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The SecurityMBeanPanel class.
 * Created by DVM Creator
 */
public class SecurityMBeanPanel extends UPanel {
//    private StringTextField tfUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey = new StringTextField();

    private int[] utsDot3Security8021xRadiusAutoSwitchVList = new int[]{
        1, 2, };
    private String[] utsDot3Security8021xRadiusAutoSwitchTList = new String[]{
        fStringMap.getString("enabled"),
        fStringMap.getString("disabled"),
    };
    private JComboBox tfUtsDot3Security8021xRadiusAutoSwitch = new JComboBox(utsDot3Security8021xRadiusAutoSwitchTList);
    private IntegerTextField tfUtsDot3Security8021xRadiusRetryTimes = new IntegerTextField();

    private IntegerTextField tfUtsDot3Security8021xRadiusTimeout = new IntegerTextField();

    private IntegerTextField tfUtsDot3Security8021xRadiusBackToPrimary = new IntegerTextField();

    private StringTextField tfUtsDot3Security8021xRadiusRealm = new StringTextField();

    private IPAddressField tfUtsDot3Security8021xRadiusNasIpAddress = new IPAddressField();

    private IPAddressField tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP = new IPAddressField();

    private IntegerTextField tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort = new IntegerTextField();

    private StringTextField tfUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey = new StringTextField();

    private IPAddressField tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP = new IPAddressField();

    private IntegerTextField tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort = new IntegerTextField();

//    private StringTextField tfUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey = new StringTextField();

    private IPAddressField tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP = new IPAddressField();

    private IntegerTextField tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort = new IntegerTextField();

    private StringTextField tfUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey = new StringTextField();

    private IPAddressField tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP = new IPAddressField();

    private IntegerTextField tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort = new IntegerTextField();

//    private StringTextField tfUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey = new StringTextField();

    private IPAddressField tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP = new IPAddressField();

    private IntegerTextField tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort = new IntegerTextField();

    private StringTextField tfUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey = new StringTextField();

    private IPAddressField tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP = new IPAddressField();

    private IntegerTextField tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort = new IntegerTextField();

//    private StringTextField tfUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey = new StringTextField();

    private IPAddressField tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP = new IPAddressField();

    private IntegerTextField tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort = new IntegerTextField();

    private StringTextField tfUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey = new StringTextField();

    private IPAddressField tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP = new IPAddressField();

    private IntegerTextField tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort = new IntegerTextField();

//    private final String utsDot3Security8021xRadiusSecondaryCliAcctSharedKey = fStringMap.getString("utsDot3Security8021xRadiusSecondaryCliAcctSharedKey") + " : ";
    private final String utsDot3Security8021xRadiusAutoSwitch = fStringMap.getString("utsDot3Security8021xRadiusAutoSwitch") + " : ";
    private final String utsDot3Security8021xRadiusRetryTimes = fStringMap.getString("utsDot3Security8021xRadiusRetryTimes") + " : ";
    private final String utsDot3Security8021xRadiusTimeout = fStringMap.getString("utsDot3Security8021xRadiusTimeout") + " : ";
    private final String utsDot3Security8021xRadiusBackToPrimary = fStringMap.getString("utsDot3Security8021xRadiusBackToPrimary") + " : ";
    private final String utsDot3Security8021xRadiusRealm = fStringMap.getString("utsDot3Security8021xRadiusRealm") + " : ";
    private final String utsDot3Security8021xRadiusNasIpAddress = fStringMap.getString("utsDot3Security8021xRadiusNasIpAddress") + " : ";
    private final String utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP = fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP") + " : ";
    private final String utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort = fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort") + " : ";
    private final String utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey = fStringMap.getString("utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey") + " : ";
    private final String utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP = fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP") + " : ";
    private final String utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort = fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort") + " : ";
    private final String utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP = fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP") + " : ";
    private final String utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort = fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort") + " : ";
    private final String utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey = fStringMap.getString("utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey") + " : ";
    private final String utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP = fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP") + " : ";
    private final String utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort = fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort") + " : ";
    private final String utsDot3Security8021xRadiusSvrPrimaryCliAuthIP = fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryCliAuthIP") + " : ";
    private final String utsDot3Security8021xRadiusSvrPrimaryCliAuthPort = fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryCliAuthPort") + " : ";
    private final String utsDot3Security8021xRadiusPrimaryCliAuthSharedKey = fStringMap.getString("utsDot3Security8021xRadiusPrimaryCliAuthSharedKey") + " : ";
    private final String utsDot3Security8021xRadiusSvrSecondaryCliAuthIP = fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryCliAuthIP") + " : ";
    private final String utsDot3Security8021xRadiusSvrSecondaryCliAuthPort = fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryCliAuthPort") + " : ";
    private final String utsDot3Security8021xRadiusSvrPrimaryCliAcctIP = fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryCliAcctIP") + " : ";
    private final String utsDot3Security8021xRadiusSvrPrimaryCliAcctPort = fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryCliAcctPort") + " : ";
    private final String utsDot3Security8021xRadiusPrimaryCliAcctSharedKey = fStringMap.getString("utsDot3Security8021xRadiusPrimaryCliAcctSharedKey") + " : ";
    private final String utsDot3Security8021xRadiusSvrSecondaryCliAcctIP = fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryCliAcctIP") + " : ";
    private final String utsDot3Security8021xRadiusSvrSecondaryCliAcctPort = fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryCliAcctPort") + " : ";

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public SecurityMBeanPanel(IApplication app) {
        super(app);
        setModel(new SecurityMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SecurityMBean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel basicPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        basicPanel.setLayout(layout);
        basicPanel.setBorder(BorderFactory.createTitledBorder( fStringMap.getString( "Basic RADIUS Parameters")) );

        basicPanel.add(new JLabel(utsDot3Security8021xRadiusAutoSwitch));
        tfUtsDot3Security8021xRadiusAutoSwitch.setName(fStringMap.getString("utsDot3Security8021xRadiusAutoSwitch"));
        basicPanel.add(tfUtsDot3Security8021xRadiusAutoSwitch);

        basicPanel.add(new JLabel(utsDot3Security8021xRadiusRetryTimes));
        tfUtsDot3Security8021xRadiusRetryTimes.setName(fStringMap.getString("utsDot3Security8021xRadiusRetryTimes"));
        basicPanel.add(tfUtsDot3Security8021xRadiusRetryTimes);
        basicPanel.add(new HSpacer());


        basicPanel.add(new JLabel(utsDot3Security8021xRadiusTimeout));
        tfUtsDot3Security8021xRadiusTimeout.setName(fStringMap.getString("utsDot3Security8021xRadiusTimeout"));
        basicPanel.add(tfUtsDot3Security8021xRadiusTimeout);
//        basicPanel.add(new HSpacer());

        basicPanel.add(new JLabel(utsDot3Security8021xRadiusBackToPrimary));
        tfUtsDot3Security8021xRadiusBackToPrimary.setName(fStringMap.getString("utsDot3Security8021xRadiusBackToPrimary"));
        basicPanel.add(tfUtsDot3Security8021xRadiusBackToPrimary);
        basicPanel.add(new HSpacer());


        basicPanel.add(new JLabel(utsDot3Security8021xRadiusRealm));
        tfUtsDot3Security8021xRadiusRealm.setName(fStringMap.getString("utsDot3Security8021xRadiusRealm"));
        basicPanel.add(tfUtsDot3Security8021xRadiusRealm);
//        basicPanel.add(new HSpacer());


        basicPanel.add(new JLabel(utsDot3Security8021xRadiusNasIpAddress));
        tfUtsDot3Security8021xRadiusNasIpAddress.setName(fStringMap.getString("utsDot3Security8021xRadiusNasIpAddress"));
        basicPanel.add(tfUtsDot3Security8021xRadiusNasIpAddress);
        basicPanel.add(new HSpacer());

        JPanel sauthPanel = new JPanel();
        layout = new NTLayout(3, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        sauthPanel.setLayout(layout);
        sauthPanel.setBorder(BorderFactory.createTitledBorder( fStringMap.getString( "ONU RADIUS Authentication Server Assignment")) );

        sauthPanel.add(new JLabel(utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP));
        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryOnuAuthIP"));
        sauthPanel.add(tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP);

        sauthPanel.add(new JLabel(utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP));
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryOnuAuthIP"));
        sauthPanel.add(tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP);

        sauthPanel.add(new JLabel(utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort));
        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryOnuAuthPort"));
        sauthPanel.add(tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort);

        sauthPanel.add(new JLabel(utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort));
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryOnuAuthPort"));
        sauthPanel.add(tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort);

        sauthPanel.add(new JLabel(utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey));
        tfUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey.setName(fStringMap.getString("utsDot3Security8021xRadiusPrimaryOnuAuthSharedKey"));
        sauthPanel.add(tfUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey);
//
//        sauthPanel.add(new JLabel(utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey));
//        tfUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey.setName(fStringMap.getString("utsDot3Security8021xRadiusSecondaryOnuAuthSharedKey"));
//        sauthPanel.add(tfUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey);


        JPanel sacctPanel = new JPanel();
        layout = new NTLayout(3, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        sacctPanel.setLayout(layout);
        sacctPanel.setBorder(BorderFactory.createTitledBorder( fStringMap.getString( "ONU RADIUS Accounting Server Assignment")) ); 

        sacctPanel.add(new JLabel(utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP));
        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryOnuAcctIP"));
        sacctPanel.add(tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP);

        sacctPanel.add(new JLabel(utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP));
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryOnuAcctIP"));
        sacctPanel.add(tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP);

        sacctPanel.add(new JLabel(utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort));
        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryOnuAcctPort"));
        sacctPanel.add(tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort);

        sacctPanel.add(new JLabel(utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort));
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryOnuAcctPort"));
        sacctPanel.add(tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort);

        sacctPanel.add(new JLabel(utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey));
        tfUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey.setName(fStringMap.getString("utsDot3Security8021xRadiusPrimaryOnuAcctSharedKey"));
        sacctPanel.add(tfUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey);

//        sacctPanel.add(new JLabel(utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey));
//        tfUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey.setName(fStringMap.getString("utsDot3Security8021xRadiusSecondaryOnuAcctSharedKey"));
//        sacctPanel.add(tfUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey);
//        sacctPanel.add(new HSpacer());


        JPanel cauthPanel = new JPanel();
        layout = new NTLayout(3, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        cauthPanel.setLayout(layout);
        cauthPanel.setBorder(BorderFactory.createTitledBorder( fStringMap.getString( "CLI RADIUS Authentication Server Assignment")) );

        cauthPanel.add(new JLabel(utsDot3Security8021xRadiusSvrPrimaryCliAuthIP));
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryCliAuthIP"));
        cauthPanel.add(tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP);

        cauthPanel.add(new JLabel(utsDot3Security8021xRadiusSvrSecondaryCliAuthIP));
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryCliAuthIP"));
        cauthPanel.add(tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP);

        cauthPanel.add(new JLabel(utsDot3Security8021xRadiusSvrPrimaryCliAuthPort));
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryCliAuthPort"));
        cauthPanel.add(tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort);

        cauthPanel.add(new JLabel(utsDot3Security8021xRadiusSvrSecondaryCliAuthPort));
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryCliAuthPort"));
        cauthPanel.add(tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort);

        cauthPanel.add(new JLabel(utsDot3Security8021xRadiusPrimaryCliAuthSharedKey));
        tfUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey.setName(fStringMap.getString("utsDot3Security8021xRadiusPrimaryCliAuthSharedKey"));
        cauthPanel.add(tfUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey);

//        cauthPanel.add(new JLabel(utsDot3Security8021xRadiusSecondaryCliAuthSharedKey));
//        tfUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey.setName(fStringMap.getString("utsDot3Security8021xRadiusSecondaryCliAuthSharedKey"));
//        cauthPanel.add(tfUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey);


        JPanel cacctPanel = new JPanel();
        layout = new NTLayout(3, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        cacctPanel.setLayout(layout);
        cacctPanel.setBorder(BorderFactory.createTitledBorder( fStringMap.getString( "CLI RADIUS Accounting Server Assignment")) );

        cacctPanel.add(new JLabel(utsDot3Security8021xRadiusSvrPrimaryCliAcctIP));
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryCliAcctIP"));
        cacctPanel.add(tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP);

        cacctPanel.add(new JLabel(utsDot3Security8021xRadiusSvrSecondaryCliAcctIP));
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryCliAcctIP"));
        cacctPanel.add(tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP);

        cacctPanel.add(new JLabel(utsDot3Security8021xRadiusSvrPrimaryCliAcctPort));
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrPrimaryCliAcctPort"));
        cacctPanel.add(tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort);

        cacctPanel.add(new JLabel(utsDot3Security8021xRadiusSvrSecondaryCliAcctPort));
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort.setName(fStringMap.getString("utsDot3Security8021xRadiusSvrSecondaryCliAcctPort"));
        cacctPanel.add(tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort);

        cacctPanel.add(new JLabel(utsDot3Security8021xRadiusPrimaryCliAcctSharedKey));
        tfUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey.setName(fStringMap.getString("utsDot3Security8021xRadiusPrimaryCliAcctSharedKey"));
        cacctPanel.add(tfUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey);

//        cacctPanel.add(new JLabel(utsDot3Security8021xRadiusSecondaryCliAcctSharedKey));
//        tfUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey.setName(fStringMap.getString("utsDot3Security8021xRadiusSecondaryCliAcctSharedKey"));
//        cacctPanel.add(tfUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey);


        JPanel allPanel = new JPanel();
        layout = new NTLayout(5, 1, NTLayout.FILL, NTLayout.CENTER, 5, 1);
        allPanel.setLayout(layout);

        allPanel.add(basicPanel);
//        allPanel.add(new VSpacer());

        allPanel.add(sauthPanel);
//        allPanel.add(new VSpacer());

        allPanel.add(sacctPanel);
//        allPanel.add(new VSpacer());
//
        allPanel.add(cauthPanel);
//        allPanel.add(new VSpacer());

        allPanel.add(cacctPanel);

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {


        tfUtsDot3Security8021xRadiusRetryTimes.setValueScope(1, 10);

        tfUtsDot3Security8021xRadiusTimeout.setValueScope(1, 15);

        tfUtsDot3Security8021xRadiusBackToPrimary.setValueScope(1, 255);

        tfUtsDot3Security8021xRadiusRealm.setLenScope(0, 31);

        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort.setValueScope(0, 65535);
        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort.setDefaultValue(1812);

        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort.setValueScope(0, 65535);
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort.setDefaultValue(1812);

        tfUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey.setLenScope(0, 31);

//        tfUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey.setLenScope(0, 31);

        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort.setValueScope(0, 65535);
        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort.setDefaultValue(1813);

        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort.setValueScope(0, 65535);
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort.setDefaultValue(1813);

        tfUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey.setLenScope(0, 31);


//        tfUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey.setLenScope(0, 31);

        tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort.setValueScope(0, 65535);
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort.setDefaultValue(1812);

        tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort.setValueScope(0, 65535);
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort.setDefaultValue(1812);

        tfUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey.setLenScope(0, 31);


//        tfUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey.setLenScope(0, 31);

        tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort.setValueScope(0, 65535);
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort.setDefaultValue(1813);

        tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort.setValueScope(0, 65535);
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort.setDefaultValue(1813);

        tfUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey.setLenScope(0, 31);
//        tfUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey.setLenScope(0, 31);
    }

    public void refresh() {

        SecurityMBean mbean = (SecurityMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

//        tfUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey.setValue(mbean.getUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey());
        tfUtsDot3Security8021xRadiusAutoSwitch.setSelectedIndex(getIndexFromValue(utsDot3Security8021xRadiusAutoSwitchVList, mbean.getUtsDot3Security8021xRadiusAutoSwitch().intValue()));
        tfUtsDot3Security8021xRadiusRetryTimes.setValue(mbean.getUtsDot3Security8021xRadiusRetryTimes().intValue());
        tfUtsDot3Security8021xRadiusTimeout.setValue(mbean.getUtsDot3Security8021xRadiusTimeout().intValue());
        tfUtsDot3Security8021xRadiusBackToPrimary.setValue(mbean.getUtsDot3Security8021xRadiusBackToPrimary().intValue());
        tfUtsDot3Security8021xRadiusRealm.setValue(mbean.getUtsDot3Security8021xRadiusRealm());
        tfUtsDot3Security8021xRadiusNasIpAddress.setValue(mbean.getUtsDot3Security8021xRadiusNasIpAddress());

        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP.setValue(mbean.getUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP());
        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort.setValue(mbean.getUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort().intValue());
        tfUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey.setValue(mbean.getUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey());
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP.setValue(mbean.getUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP());
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort.setValue(mbean.getUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort().intValue());
//        tfUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey.setValue(mbean.getUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey());

        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP.setValue(mbean.getUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP());
        tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort.setValue(mbean.getUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort().intValue());
        tfUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey.setValue(mbean.getUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey());
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP.setValue(mbean.getUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP());
        tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort.setValue(mbean.getUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort().intValue());
//        tfUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey.setValue(mbean.getUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey());

        tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP.setValue(mbean.getUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP());
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort.setValue(mbean.getUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort().intValue());
        tfUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey.setValue(mbean.getUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey());
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP.setValue(mbean.getUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP());
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort.setValue(mbean.getUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort().intValue());
//        tfUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey.setValue(mbean.getUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey());
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP.setValue(mbean.getUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP());
        tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort.setValue(mbean.getUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort().intValue());
        tfUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey.setValue(mbean.getUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey());
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP.setValue(mbean.getUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP());
        tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort.setValue(mbean.getUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort().intValue());
    }

    public void updateModel() {
        SecurityMBean mbean = (SecurityMBean) getModel();

//        mbean.setUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey(new String(tfUtsDot3Security8021xRadiusSecondaryCliAcctSharedKey.getValue()));
        mbean.setUtsDot3Security8021xRadiusAutoSwitch(new Integer(utsDot3Security8021xRadiusAutoSwitchVList[tfUtsDot3Security8021xRadiusAutoSwitch.getSelectedIndex()]));
        mbean.setUtsDot3Security8021xRadiusRetryTimes(new Integer(tfUtsDot3Security8021xRadiusRetryTimes.getValue()));
        mbean.setUtsDot3Security8021xRadiusTimeout(new Integer(tfUtsDot3Security8021xRadiusTimeout.getValue()));
        mbean.setUtsDot3Security8021xRadiusBackToPrimary(new Integer(tfUtsDot3Security8021xRadiusBackToPrimary.getValue()));
        mbean.setUtsDot3Security8021xRadiusRealm(new String(tfUtsDot3Security8021xRadiusRealm.getValue()));
        mbean.setUtsDot3Security8021xRadiusNasIpAddress(new String(tfUtsDot3Security8021xRadiusNasIpAddress.getIPString()));

        mbean.setUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP(new String(tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthIP.getIPString()));
        mbean.setUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort(new Integer(tfUtsDot3Security8021xRadiusSvrPrimaryOnuAuthPort.getValue()));
        mbean.setUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey(new String(tfUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey.getValue()));
        mbean.setUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP(new String(tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthIP.getIPString()));
        mbean.setUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort(new Integer(tfUtsDot3Security8021xRadiusSvrSecondaryOnuAuthPort.getValue()));
        mbean.setUtsDot3Security8021xRadiusSecondaryOnuAuthSharedKey(new String(tfUtsDot3Security8021xRadiusPrimaryOnuAuthSharedKey.getValue()));
        mbean.setUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP(new String(tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctIP.getIPString()));
        mbean.setUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort(new Integer(tfUtsDot3Security8021xRadiusSvrPrimaryOnuAcctPort.getValue()));
        mbean.setUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey(new String(tfUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey.getValue()));
        mbean.setUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP(new String(tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctIP.getIPString()));
        mbean.setUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort(new Integer(tfUtsDot3Security8021xRadiusSvrSecondaryOnuAcctPort.getValue()));
        mbean.setUtsDot3Security8021xRadiusSecondaryOnuAcctSharedKey(new String(tfUtsDot3Security8021xRadiusPrimaryOnuAcctSharedKey.getValue()));
        mbean.setUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP(new String(tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthIP.getIPString()));
        mbean.setUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort(new Integer(tfUtsDot3Security8021xRadiusSvrPrimaryCliAuthPort.getValue()));
        mbean.setUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey(new String(tfUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey.getValue()));
        mbean.setUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP(new String(tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthIP.getIPString()));
        mbean.setUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort(new Integer(tfUtsDot3Security8021xRadiusSvrSecondaryCliAuthPort.getValue()));
        mbean.setUtsDot3Security8021xRadiusSecondaryCliAuthSharedKey(new String(tfUtsDot3Security8021xRadiusPrimaryCliAuthSharedKey.getValue()));
        mbean.setUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP(new String(tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctIP.getIPString()));
        mbean.setUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort(new Integer(tfUtsDot3Security8021xRadiusSvrPrimaryCliAcctPort.getValue()));
        mbean.setUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey(new String(tfUtsDot3Security8021xRadiusPrimaryCliAcctSharedKey.getValue()));
        mbean.setUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP(new String(tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctIP.getIPString()));
        mbean.setUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort(new Integer(tfUtsDot3Security8021xRadiusSvrSecondaryCliAcctPort.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

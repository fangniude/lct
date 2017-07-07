/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2Table;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2TablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2TablePanel extends UPanel {

  private JLabel tfUtsDot3OnuModuleId = new JLabel();

  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

  private JLabel tfUtsDot3OnuPortId = new JLabel();

  private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

  private JLabel tfUtsDot3OnuLlid = new JLabel();

  private JLabel tfUtsDot3EepromVersion = new JLabel();

  private JLabel tfUtsDot3OamVersion = new JLabel();

  private MacAddressField tfUtsDot3OnuMacAddress = new MacAddressField();

  private int[] utsDot3OnuAdminVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuAdminTList = new String[]{
    fStringMap.getString("up"),
    fStringMap.getString("down"),
  };
  private JComboBox tfUtsDot3OnuAdmin = new JComboBox(utsDot3OnuAdminTList);
  private int[] utsDot3OnuTransparentModeVList = new int[]{
    2, 1, };
  private String[] utsDot3OnuTransparentModeTList = new String[]{
    fStringMap.getString("disable"),
    fStringMap.getString("enable"),
  };
  private JComboBox tfUtsDot3OnuTransparentMode = new JComboBox(utsDot3OnuTransparentModeTList);
  private int[] utsDot3OnuStatusVList = new int[]{
    2, 1, };
  private String[] utsDot3OnuStatusTList = new String[]{
    fStringMap.getString("deregistered"),
    fStringMap.getString("registered"),
  };
  private JComboBox tfUtsDot3OnuStatus = new JComboBox(utsDot3OnuStatusTList);
  private IntegerTextField tfUtsDot3OnuMpcpTimeout = new IntegerTextField();

  private JLabel tfUtsDot3OnuVendor = new JLabel();

  private JLabel tfUtsDot3OnuModule = new JLabel();

  private JLabel tfUtsDot3OnuHwVersion2 = new JLabel();

  private JLabel tfUtsDot3OnuSerialNumber = new JLabel();

  private JLabel tfUtsDot3OnuLaserOnTime = new JLabel();

  private JLabel tfUtsDot3OnuLaserOffTime = new JLabel();

  private int[] utsDot3OnuDot1adEnableVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuDot1adEnableTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OnuDot1adEnable = new JComboBox(utsDot3OnuDot1adEnableTList);
  private IntegerTextField tfUtsDot3OnuDot1adTPID = new IntegerTextField();

  private int[] utsDot3OnuReset2VList = new int[]{
    3, 1, 2, };
  private String[] utsDot3OnuReset2TList = new String[]{
    fStringMap.getString("resetMpcp"),
    fStringMap.getString("normal"),
    fStringMap.getString("resetGlobal"),
  };
  private JComboBox tfUtsDot3OnuReset2 = new JComboBox(utsDot3OnuReset2TList);


  private final String utsDot3OnuModuleId2 = fStringMap.getString("utsDot3OnuModuleId") + " : ";
  private final String utsDot3OnuDeviceId2 = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId2 = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId2 = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3OnuLlid2 = fStringMap.getString("utsDot3OnuLlid") + " : ";
  private final String utsDot3EepromVersion = fStringMap.getString("utsDot3EepromVersion") + " : ";
  private final String utsDot3OamVersion = fStringMap.getString("utsDot3OamVersion") + " : ";
  private final String utsDot3OnuMacAddress = fStringMap.getString("utsDot3OnuMacAddress") + " : ";
  private final String utsDot3OnuAdmin = fStringMap.getString("utsDot3OnuAdmin") + " : ";
  private final String utsDot3OnuTransparentMode = fStringMap.getString("utsDot3OnuTransparentMode") + " : ";
  private final String utsDot3OnuStatus = fStringMap.getString("utsDot3OnuStatus") + " : ";
  private final String utsDot3OnuMpcpTimeout = fStringMap.getString("utsDot3OnuMpcpTimeout") + " : ";
  private final String utsDot3OnuVendor = fStringMap.getString("utsDot3OnuVendor") + " : ";
  private final String utsDot3OnuModule = fStringMap.getString("utsDot3OnuModule") + " : ";
  private final String utsDot3OnuHwVersion2 = fStringMap.getString("utsDot3OnuHwVersion2") + " : ";
  private final String utsDot3OnuSerialNumber = fStringMap.getString("utsDot3OnuSerialNumber") + " : ";
  private final String utsDot3OnuLaserOnTime = fStringMap.getString("utsDot3OnuLaserOnTime") + " : ";
  private final String utsDot3OnuLaserOffTime = fStringMap.getString("utsDot3OnuLaserOffTime") + " : ";
  private final String utsDot3OnuDot1adEnable = fStringMap.getString("utsDot3OnuDot1adEnable") + " : ";
  private final String utsDot3OnuDot1adTPID = fStringMap.getString("utsDot3OnuDot1adTPID") + " : ";
  private final String utsDot3OnuReset2 = fStringMap.getString("utsDot3OnuReset2") + " : ";


  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;


  public Dot3Onu2TablePanel(IApplication app) {
    super(app);
    setModel(new Dot3Onu2Table(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_Dot3Onu2Table");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(21, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuModuleId2));
    baseInfoPanel.add(tfUtsDot3OnuModuleId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId2));
    baseInfoPanel.add(tfUtsDot3OnuDeviceId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPortId2));
    baseInfoPanel.add(tfUtsDot3OnuPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId2));
    baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLlid2));
    baseInfoPanel.add(tfUtsDot3OnuLlid);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3EepromVersion));
    baseInfoPanel.add(tfUtsDot3EepromVersion);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OamVersion));
    baseInfoPanel.add(tfUtsDot3OamVersion);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMacAddress));
    baseInfoPanel.add(tfUtsDot3OnuMacAddress);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuAdmin));
    tfUtsDot3OnuAdmin.setName(fStringMap.getString("utsDot3OnuAdmin"));
    baseInfoPanel.add(tfUtsDot3OnuAdmin);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuTransparentMode));
    tfUtsDot3OnuTransparentMode.setName(fStringMap.getString("utsDot3OnuTransparentMode"));
    baseInfoPanel.add(tfUtsDot3OnuTransparentMode);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuStatus));
    tfUtsDot3OnuStatus.setName(fStringMap.getString("utsDot3OnuStatus"));
    baseInfoPanel.add(tfUtsDot3OnuStatus);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMpcpTimeout));
    tfUtsDot3OnuMpcpTimeout.setName(fStringMap.getString("utsDot3OnuMpcpTimeout"));
    baseInfoPanel.add(tfUtsDot3OnuMpcpTimeout);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuVendor));
    baseInfoPanel.add(tfUtsDot3OnuVendor);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuModule));
    baseInfoPanel.add(tfUtsDot3OnuModule);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuHwVersion2));
    baseInfoPanel.add(tfUtsDot3OnuHwVersion2);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuSerialNumber));
    baseInfoPanel.add(tfUtsDot3OnuSerialNumber);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLaserOnTime));
    baseInfoPanel.add(tfUtsDot3OnuLaserOnTime);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLaserOffTime));
    baseInfoPanel.add(tfUtsDot3OnuLaserOffTime);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDot1adEnable));
    tfUtsDot3OnuDot1adEnable.setName(fStringMap.getString("utsDot3OnuDot1adEnable"));
    baseInfoPanel.add(tfUtsDot3OnuDot1adEnable);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDot1adTPID));
    tfUtsDot3OnuDot1adTPID.setName(fStringMap.getString("utsDot3OnuDot1adTPID"));
    baseInfoPanel.add(tfUtsDot3OnuDot1adTPID);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuReset2));
    tfUtsDot3OnuReset2.setName(fStringMap.getString("utsDot3OnuReset2"));
    baseInfoPanel.add(tfUtsDot3OnuReset2);
    baseInfoPanel.add(new HSpacer());


    JPanel allPanel = new JPanel();
    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.SOUTH);


  }

  protected void initForm() {


    tfUtsDot3OnuMacAddress.setEditable(false);


  }

  public void refresh() {

    Dot3Onu2Table mbean = (Dot3Onu2Table) getModel();

    tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
    tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
    tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
    tfUtsDot3OnuLlid.setText(mbean.getUtsDot3OnuLlid().toString());
    tfUtsDot3EepromVersion.setText(mbean.getUtsDot3EepromVersion().toString());
    tfUtsDot3OamVersion.setText(mbean.getUtsDot3OamVersion().toString());
    tfUtsDot3OnuMacAddress.setValue(mbean.getUtsDot3OnuMacAddress());
    tfUtsDot3OnuAdmin.setSelectedIndex(getIndexFromValue(utsDot3OnuAdminVList, mbean.getUtsDot3OnuAdmin().intValue()));
    tfUtsDot3OnuTransparentMode.setSelectedIndex(getIndexFromValue(utsDot3OnuTransparentModeVList, mbean.getUtsDot3OnuTransparentMode().intValue()));
    tfUtsDot3OnuStatus.setSelectedIndex(getIndexFromValue(utsDot3OnuStatusVList, mbean.getUtsDot3OnuStatus().intValue()));
    tfUtsDot3OnuMpcpTimeout.setValue(mbean.getUtsDot3OnuMpcpTimeout().intValue());
    tfUtsDot3OnuVendor.setText(mbean.getUtsDot3OnuVendor());
    tfUtsDot3OnuModule.setText(mbean.getUtsDot3OnuModule());
    tfUtsDot3OnuHwVersion2.setText(mbean.getUtsDot3OnuHwVersion2());
    tfUtsDot3OnuSerialNumber.setText(mbean.getUtsDot3OnuSerialNumber());
    tfUtsDot3OnuLaserOnTime.setText(mbean.getUtsDot3OnuLaserOnTime().toString());
    tfUtsDot3OnuLaserOffTime.setText(mbean.getUtsDot3OnuLaserOffTime().toString());
    tfUtsDot3OnuDot1adEnable.setSelectedIndex(getIndexFromValue(utsDot3OnuDot1adEnableVList, mbean.getUtsDot3OnuDot1adEnable().intValue()));
    tfUtsDot3OnuDot1adTPID.setValue(mbean.getUtsDot3OnuDot1adTPID().intValue());
    tfUtsDot3OnuReset2.setSelectedIndex(getIndexFromValue(utsDot3OnuReset2VList, mbean.getUtsDot3OnuReset2().intValue()));

  }

  public void updateModel() {
    Dot3Onu2Table mbean = (Dot3Onu2Table) getModel();

    mbean.setUtsDot3OnuAdmin(new Integer(utsDot3OnuAdminVList[tfUtsDot3OnuAdmin.getSelectedIndex()]));
    mbean.setUtsDot3OnuTransparentMode(new Integer(utsDot3OnuTransparentModeVList[tfUtsDot3OnuTransparentMode.getSelectedIndex()]));
    mbean.setUtsDot3OnuStatus(new Integer(utsDot3OnuStatusVList[tfUtsDot3OnuStatus.getSelectedIndex()]));
    mbean.setUtsDot3OnuMpcpTimeout(new Integer(tfUtsDot3OnuMpcpTimeout.getValue()));


    mbean.setUtsDot3OnuDot1adEnable(new Integer(utsDot3OnuDot1adEnableVList[tfUtsDot3OnuDot1adEnable.getSelectedIndex()]));
    mbean.setUtsDot3OnuDot1adTPID(new Integer(tfUtsDot3OnuDot1adTPID.getValue()));
    mbean.setUtsDot3OnuReset2(new Integer(utsDot3OnuReset2VList[tfUtsDot3OnuReset2.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}

/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.model.BBS1000NE;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2StaticFDBTable;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2StaticFDBTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2StaticFDBTablePanel extends UPanel {

  private JComboBox tfUtsDot3OnuStaticFDBModuleId = new JComboBox(new Integer[]{1, 2});

//  private JComboBox tfUtsDot3OnuStaticFDBDeviceId = new JComboBox();

  private JComboBox tfUtsDot3OnuStaticFDBPortId = new JComboBox(new Integer[]{1, 2, 3, 4});

  private JComboBox tfUtsDot3OnuStaticFDBLPortId = new JComboBox();

  private MacAddressField tfUtsDot3OnuStaticFDBDstMacAddr = new MacAddressField("00:00:00:00:00:00");

  private IntegerTextField tfUtsDot3OnuStaticFDBVlanId = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuStaticFDBEgressPort = new IntegerTextField();

  private int[] utsDot3OnuStaticFDBFunctionVList = new int[]{
    3, 1, 2, };
  private String[] utsDot3OnuStaticFDBFunctionTList = new String[]{
    fStringMap.getString("filterDstMac"),
    fStringMap.getString("staticForward"),
    fStringMap.getString("filterSrcMac"),
  };
  private JComboBox tfUtsDot3OnuStaticFDBFunction = new JComboBox(utsDot3OnuStaticFDBFunctionTList);

  private final String utsDot3OnuStaticFDBModuleId = fStringMap.getString("utsDot3OnuStaticFDBModuleId") + " : ";
//  private final String utsDot3OnuStaticFDBDeviceId = fStringMap.getString("utsDot3OnuStaticFDBDeviceId") + " : ";
  private final String utsDot3OnuStaticFDBPortId = fStringMap.getString("utsDot3OnuStaticFDBPortId") + " : ";
  private final String utsDot3OnuStaticFDBLPortId = fStringMap.getString("utsDot3OnuStaticFDBLPortId") + " : ";
  private final String utsDot3OnuStaticFDBDstMacAddr = fStringMap.getString("utsDot3OnuStaticFDBDstMacAddr") + " : ";
  private final String utsDot3OnuStaticFDBVlanId = fStringMap.getString("utsDot3OnuStaticFDBVlanId") + " : ";
  private final String utsDot3OnuStaticFDBEgressPort = fStringMap.getString("utsDot3OnuStaticFDBEgressPort") + " : ";
  private final String utsDot3OnuStaticFDBFunction = fStringMap.getString("utsDot3OnuStaticFDBFunction") + " : ";


  public Dot3Onu2StaticFDBTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuStaticFDBModuleId));
    baseInfoPanel.add(tfUtsDot3OnuStaticFDBModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuStaticFDBDeviceId));
//    baseInfoPanel.add(tfUtsDot3OnuStaticFDBDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuStaticFDBPortId));
    baseInfoPanel.add(tfUtsDot3OnuStaticFDBPortId);
    baseInfoPanel.add(new HSpacer());

    int count = new BBS1000NE(fApplication).getPonSplitRatio();
    for (int i = 1; i <= count; i++) {
      tfUtsDot3OnuStaticFDBLPortId.addItem(new Integer(i));
    }
    baseInfoPanel.add(new JLabel(utsDot3OnuStaticFDBLPortId));
    baseInfoPanel.add(tfUtsDot3OnuStaticFDBLPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuStaticFDBDstMacAddr));
    tfUtsDot3OnuStaticFDBDstMacAddr.setName(fStringMap.getString("utsDot3OnuStaticFDBDstMacAddr"));
    baseInfoPanel.add(tfUtsDot3OnuStaticFDBDstMacAddr);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuStaticFDBVlanId));
    tfUtsDot3OnuStaticFDBVlanId.setName(fStringMap.getString("utsDot3OnuStaticFDBVlanId"));
    baseInfoPanel.add(tfUtsDot3OnuStaticFDBVlanId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuStaticFDBEgressPort));
    tfUtsDot3OnuStaticFDBEgressPort.setName(fStringMap.getString("utsDot3OnuStaticFDBEgressPort"));
    baseInfoPanel.add(tfUtsDot3OnuStaticFDBEgressPort);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuStaticFDBFunction));
    tfUtsDot3OnuStaticFDBFunction.setName(fStringMap.getString("utsDot3OnuStaticFDBFunction"));
    baseInfoPanel.add(tfUtsDot3OnuStaticFDBFunction);
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


    tfUtsDot3OnuStaticFDBVlanId.setValueScope(1, 4094);


  }

  public void refresh() {
//    if (SnmpAction.IType.ADD.equals(fCommand)) {
//      //
//      tfUtsDot3OnuStaticFDBModuleId.removeAllItems();
//      BBS4000NE ne = new BBS4000NE(fApplication);
//
//      Vector v = ne.getEPMCardList();
//
//      for (int i = 0; i < v.size(); i++) {
//        tfUtsDot3OnuStaticFDBModuleId.addItem(v.get(i));
//      }
//    }
  }

  public boolean validateFrom() {
    if (tfUtsDot3OnuStaticFDBModuleId.getSelectedItem() == null) {
      String error = fStringMap.getString("Err_Module_Id_Is_Null");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }
    return true;
  }

  public void updateModel() {
    if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new Dot3Onu2StaticFDBTable(fApplication.getSnmpProxy()));

    Dot3Onu2StaticFDBTable mbean = (Dot3Onu2StaticFDBTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsDot3OnuStaticFDBModuleId((Integer)tfUtsDot3OnuStaticFDBModuleId.getSelectedItem());
      mbean.setUtsDot3OnuStaticFDBDeviceId(new Integer(1));
      mbean.setUtsDot3OnuStaticFDBPortId((Integer)tfUtsDot3OnuStaticFDBPortId.getSelectedItem());
      mbean.setUtsDot3OnuStaticFDBLPortId((Integer)tfUtsDot3OnuStaticFDBLPortId.getSelectedItem());
    }

    mbean.setUtsDot3OnuStaticFDBDstMacAddr(tfUtsDot3OnuStaticFDBDstMacAddr.getValue());
    mbean.setUtsDot3OnuStaticFDBVlanId(new Integer(tfUtsDot3OnuStaticFDBVlanId.getValue()));
    mbean.setUtsDot3OnuStaticFDBEgressPort(new Integer(tfUtsDot3OnuStaticFDBEgressPort.getValue()));
    mbean.setUtsDot3OnuStaticFDBFunction(new Integer(utsDot3OnuStaticFDBFunctionVList[tfUtsDot3OnuStaticFDBFunction.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}

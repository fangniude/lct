/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcLpBkTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The Dot3Onu2CtcLpBkTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2CtcLpBkTablePanel extends UPanel {

  private JComboBox tfUtsDot3OnuLpBkModuleId = new JComboBox();

//  private JComboBox tfUtsDot3OnuLpBkDeviceId = new JComboBox();

  private JComboBox tfUtsDot3OnuLpBkPortId = new JComboBox(new String[]{"1", "2", "3", "4"});

  private JComboBox tfUtsDot3OnuLpBkLogicalPortId = new JComboBox();

  private int[] utsDot3OnuLpBkModeVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuLpBkModeTList = new String[]{
    fStringMap.getString("local"),
    fStringMap.getString("remote"),
  };
  private JComboBox tfUtsDot3OnuLpBkMode = new JComboBox(utsDot3OnuLpBkModeTList);
  private IntegerTextField tfUtsDot3OnuLpBkPacketSize = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuLpBkPacketNum = new IntegerTextField();

  private int[] utsDot3OnuLpBkStartVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuLpBkStartTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OnuLpBkStart = new JComboBox(utsDot3OnuLpBkStartTList);
  private int[] utsDot3OnuLpBkEndVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuLpBkEndTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OnuLpBkEnd = new JComboBox(utsDot3OnuLpBkEndTList);

  private final String utsDot3OnuLpBkModuleId = fStringMap.getString("utsDot3OnuLpBkModuleId") + " : ";
//  private final String utsDot3OnuLpBkDeviceId = fStringMap.getString("utsDot3OnuLpBkDeviceId") + " : ";
  private final String utsDot3OnuLpBkPortId = fStringMap.getString("utsDot3OnuLpBkPortId") + " : ";
  private final String utsDot3OnuLpBkLogicalPortId = fStringMap.getString("utsDot3OnuLpBkLogicalPortId") + " : ";
  private final String utsDot3OnuLpBkMode = fStringMap.getString("utsDot3OnuLpBkMode") + " : ";
  private final String utsDot3OnuLpBkPacketSize = fStringMap.getString("utsDot3OnuLpBkPacketSize") + " : ";
  private final String utsDot3OnuLpBkPacketNum = fStringMap.getString("utsDot3OnuLpBkPacketNum") + " : ";
  private final String utsDot3OnuLpBkStart = fStringMap.getString("utsDot3OnuLpBkStart") + " : ";
  private final String utsDot3OnuLpBkEnd = fStringMap.getString("utsDot3OnuLpBkEnd") + " : ";

  public Dot3Onu2CtcLpBkTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkModuleId));
    baseInfoPanel.add(tfUtsDot3OnuLpBkModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkDeviceId));
//    baseInfoPanel.add(tfUtsDot3OnuLpBkDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkPortId));
    baseInfoPanel.add(tfUtsDot3OnuLpBkPortId);
    baseInfoPanel.add(new HSpacer());

    int count = new BBS4000NE(fApplication).getPonSplitRatio();
    for (int i = 1; i <= count; i++) {
      tfUtsDot3OnuLpBkLogicalPortId.addItem("" + i);
    }
    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkLogicalPortId));
    baseInfoPanel.add(tfUtsDot3OnuLpBkLogicalPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkMode));
    tfUtsDot3OnuLpBkMode.setName(fStringMap.getString("utsDot3OnuLpBkMode"));
    baseInfoPanel.add(tfUtsDot3OnuLpBkMode);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkPacketSize));
    tfUtsDot3OnuLpBkPacketSize.setName(fStringMap.getString("utsDot3OnuLpBkPacketSize"));
    baseInfoPanel.add(tfUtsDot3OnuLpBkPacketSize);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkPacketNum));
    tfUtsDot3OnuLpBkPacketNum.setName(fStringMap.getString("utsDot3OnuLpBkPacketNum"));
    baseInfoPanel.add(tfUtsDot3OnuLpBkPacketNum);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkStart));
    tfUtsDot3OnuLpBkStart.setName(fStringMap.getString("utsDot3OnuLpBkStart"));
    baseInfoPanel.add(tfUtsDot3OnuLpBkStart);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkEnd));
    tfUtsDot3OnuLpBkEnd.setName(fStringMap.getString("utsDot3OnuLpBkEnd"));
    baseInfoPanel.add(tfUtsDot3OnuLpBkEnd);
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
    tfUtsDot3OnuLpBkPacketSize.setValueScope(64, 1500);
    tfUtsDot3OnuLpBkPacketNum.setValueScope(1, 65535);
  }

  public void refresh() {
    if (SnmpAction.IType.ADD.equals(fCommand)) {
      //
      tfUtsDot3OnuLpBkModuleId.removeAllItems();
      BBS4000NE ne = new BBS4000NE(fApplication);

      Vector v = ne.getEPMCardList();

      for (int i = 0; i < v.size(); i++) {
        tfUtsDot3OnuLpBkModuleId.addItem(v.get(i));
      }
    }
//    else
//    {
//      Dot3Onu2CtcLpBkTable mbean = (Dot3Onu2CtcLpBkTable) getModel();
//
////    tfUtsDot3OnuLpBkModuleId.setText(mbean.getUtsDot3OnuLpBkModuleId().toString());
////    tfUtsDot3OnuLpBkDeviceId.setText(mbean.getUtsDot3OnuLpBkDeviceId().toString());
////    tfUtsDot3OnuLpBkPortId.setText(mbean.getUtsDot3OnuLpBkPortId().toString());
////    tfUtsDot3OnuLpBkLogicalPortId.setText(mbean.getUtsDot3OnuLpBkLogicalPortId().toString());
//      tfUtsDot3OnuLpBkMode.setSelectedIndex(getIndexFromValue(utsDot3OnuLpBkModeVList, mbean.getUtsDot3OnuLpBkMode().intValue()));
//      tfUtsDot3OnuLpBkPacketSize.setValue(mbean.getUtsDot3OnuLpBkPacketSize().intValue());
//      tfUtsDot3OnuLpBkPacketNum.setValue(mbean.getUtsDot3OnuLpBkPacketNum().intValue());
//      tfUtsDot3OnuLpBkStart.setSelectedIndex(getIndexFromValue(utsDot3OnuLpBkStartVList, mbean.getUtsDot3OnuLpBkStart().intValue()));
//      tfUtsDot3OnuLpBkEnd.setSelectedIndex(getIndexFromValue(utsDot3OnuLpBkEndVList, mbean.getUtsDot3OnuLpBkEnd().intValue()));
//      tfUtsDot3OnuLpBkResult.setText(mbean.getUtsDot3OnuLpBkResult());
//    }
  }

  public boolean validateFrom() {
    if (tfUtsDot3OnuLpBkModuleId.getSelectedItem() == null) {
      String error = fStringMap.getString("Err_Module_Id_Is_Null");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }
    return true;
  }

  public void updateModel() {

    if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new Dot3Onu2CtcLpBkTable(fApplication.getSnmpProxy()));

    Dot3Onu2CtcLpBkTable mbean = (Dot3Onu2CtcLpBkTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsDot3OnuLpBkModuleId(new Integer((String)tfUtsDot3OnuLpBkModuleId.getSelectedItem()));
      mbean.setUtsDot3OnuLpBkDeviceId(new Integer(1));
      mbean.setUtsDot3OnuLpBkPortId(new Integer((String)tfUtsDot3OnuLpBkPortId.getSelectedItem()));
      mbean.setUtsDot3OnuLpBkLogicalPortId(new Integer((String)tfUtsDot3OnuLpBkLogicalPortId.getSelectedItem()));
    }

    mbean.setUtsDot3OnuLpBkMode(new Integer(utsDot3OnuLpBkModeVList[tfUtsDot3OnuLpBkMode.getSelectedIndex()]));
    mbean.setUtsDot3OnuLpBkPacketSize(new Integer(tfUtsDot3OnuLpBkPacketSize.getValue()));
    mbean.setUtsDot3OnuLpBkPacketNum(new Integer(tfUtsDot3OnuLpBkPacketNum.getValue()));
    mbean.setUtsDot3OnuLpBkStart(new Integer(utsDot3OnuLpBkStartVList[tfUtsDot3OnuLpBkStart.getSelectedIndex()]));
    mbean.setUtsDot3OnuLpBkEnd(new Integer(utsDot3OnuLpBkEndVList[tfUtsDot3OnuLpBkEnd.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}

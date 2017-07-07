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
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.model.BBS1000NE;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2FDBTable;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2FDBTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2FDBTablePanel extends UPanel {

  private JComboBox tfUtsDot3OnuFDBModuleId = new JComboBox(new Integer[]{1, 2});

//  private JComboBox tfUtsDot3OnuFDBDeviceId = new JComboBox();

  private JComboBox tfUtsDot3OnuFDBPortId = new JComboBox(new Integer[]{1, 2, 3, 4});

  private JComboBox tfUtsDot3OnuFDBLPortId = new JComboBox();

  private IntegerTextField tfUtsDot3OnuFDBIndex = new IntegerTextField();

  private MacAddressField tfUtsDot3OnuFDBDstMacAddr = new MacAddressField("00:00:00:00:00:00");

  private IntegerTextField tfUtsDot3OnuFDBVlanId = new IntegerTextField();

  private StringTextField tfUtsDot3OnuFDBEgressPort = new StringTextField();

  private final String utsDot3OnuFDBModuleId = fStringMap.getString("utsDot3OnuFDBModuleId") + " : ";
//  private final String utsDot3OnuFDBDeviceId = fStringMap.getString("utsDot3OnuFDBDeviceId") + " : ";
  private final String utsDot3OnuFDBLPortId = fStringMap.getString("utsDot3OnuFDBLPortId") + " : ";
  private final String utsDot3OnuFDBPortId = fStringMap.getString("utsDot3OnuFDBPortId") + " : ";
  private final String utsDot3OnuFDBIndex = fStringMap.getString("utsDot3OnuFDBIndex") + " : ";
  private final String utsDot3OnuFDBDstMacAddr = fStringMap.getString("utsDot3OnuFDBDstMacAddr") + " : ";
  private final String utsDot3OnuFDBVlanId = fStringMap.getString("utsDot3OnuFDBVlanId") + " : ";
  private final String utsDot3OnuFDBEgressPort = fStringMap.getString("utsDot3OnuFDBEgressPort") + " : ";

  public Dot3Onu2FDBTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuFDBModuleId));
    baseInfoPanel.add(tfUtsDot3OnuFDBModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuFDBDeviceId));
//    baseInfoPanel.add(tfUtsDot3OnuFDBDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuFDBPortId));
    baseInfoPanel.add(tfUtsDot3OnuFDBPortId);
    baseInfoPanel.add(new HSpacer());


    int count = new BBS1000NE(fApplication).getPonSplitRatio();
    for (int i = 1; i <= count; i++) {
      tfUtsDot3OnuFDBLPortId.addItem(new Integer(i));
    }
    baseInfoPanel.add(new JLabel(utsDot3OnuFDBLPortId));
    baseInfoPanel.add(tfUtsDot3OnuFDBLPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuFDBIndex));
    baseInfoPanel.add(tfUtsDot3OnuFDBIndex);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuFDBDstMacAddr));
    tfUtsDot3OnuFDBDstMacAddr.setName(fStringMap.getString("utsDot3OnuFDBDstMacAddr"));
    baseInfoPanel.add(tfUtsDot3OnuFDBDstMacAddr);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuFDBVlanId));
    tfUtsDot3OnuFDBVlanId.setName(fStringMap.getString("utsDot3OnuFDBVlanId"));
    baseInfoPanel.add(tfUtsDot3OnuFDBVlanId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuFDBEgressPort));
    tfUtsDot3OnuFDBEgressPort.setName(fStringMap.getString("utsDot3OnuFDBEgressPort"));
    baseInfoPanel.add(tfUtsDot3OnuFDBEgressPort);
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


    tfUtsDot3OnuFDBVlanId.setValueScope(1, 4094);


  }

  public void refresh() {
//    if (SnmpAction.IType.ADD.equals(fCommand)) {
//      //
//      tfUtsDot3OnuFDBModuleId.removeAllItems();
//      BBS4000NE ne = new BBS4000NE(fApplication);
//
//      Vector v = ne.getEPMCardList();
//
//      for (int i = 0; i < v.size(); i++) {
//        tfUtsDot3OnuFDBModuleId.addItem(v.get(i));
//      }
//    }
  }

  public boolean validateFrom() {
    if (tfUtsDot3OnuFDBModuleId.getSelectedItem() == null) {
      String error = fStringMap.getString("Err_Module_Id_Is_Null");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }
    return true;
  }

  public void updateModel() {
    if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new Dot3Onu2FDBTable(fApplication.getSnmpProxy()));

    Dot3Onu2FDBTable mbean = (Dot3Onu2FDBTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsDot3OnuFDBModuleId((Integer)tfUtsDot3OnuFDBModuleId.getSelectedItem());
      mbean.setUtsDot3OnuFDBDeviceId(new Integer(1));
      mbean.setUtsDot3OnuFDBPortId((Integer)tfUtsDot3OnuFDBPortId.getSelectedItem());
      mbean.setUtsDot3OnuFDBLPortId((Integer)tfUtsDot3OnuFDBLPortId.getSelectedItem());
      mbean.setUtsDot3OnuFDBIndex(new Integer(tfUtsDot3OnuFDBIndex.getValue()));
    }

    mbean.setUtsDot3OnuFDBDstMacAddr(tfUtsDot3OnuFDBDstMacAddr.getValue());
    mbean.setUtsDot3OnuFDBVlanId(new Integer(tfUtsDot3OnuFDBVlanId.getValue()));
    mbean.setUtsDot3OnuFDBEgressPort(new String(tfUtsDot3OnuFDBEgressPort.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}

/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OnuCtcMulticastCtrlTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The OnuCtcMulticastCtrlTablePanel class.
 * Created by DVM Creator
 */
public class OnuCtcMulticastCtrlTablePanel extends UPanel {

  private JComboBox tfUtsDot3OnuModuleId = new JComboBox();

//  private IntegerTextField tfUtsDot3OnuDeviceId = new IntegerTextField();

  private JComboBox tfUtsDot3OnuPortId = null;

  private JComboBox tfUtsDot3OnuLogicalPortId = null;

  private JComboBox tfUtsDot3OnuEtherPortIndex = null;

  private IntegerTextField tfUtsDot3OnuMCastVlan = new IntegerTextField();

  private IPAddressField tfUtsDot3OnuMCastGroupStart = new IPAddressField(IPAddressField.IPMULTICAST);

  private IPAddressField tfUtsDot3OnuMCastGroupEnd = new IPAddressField(IPAddressField.IPMULTICAST);

  private int[] utsDot3OnuAuthTypeVList = new int[]{
    3, 2, 1, };
  private String[] utsDot3OnuAuthTypeTList = new String[]{
    fStringMap.getString("preview"),
    fStringMap.getString("deny"),
    fStringMap.getString("permit"),
  };
  private JComboBox tfUtsDot3OnuAuthType = new JComboBox(utsDot3OnuAuthTypeTList);

  private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
//  private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3OnuEtherPortIndex = fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";
  private final String utsDot3OnuMCastVlan = fStringMap.getString("utsDot3OnuMCastVlan") + " : ";
  private final String utsDot3OnuMCastGroupStart = fStringMap.getString("utsDot3OnuMCastGroupStart") + " : ";
  private final String utsDot3OnuMCastGroupEnd = fStringMap.getString("utsDot3OnuMCastGroupEnd") + " : ";
  private final String utsDot3OnuAuthType = fStringMap.getString("utsDot3OnuAuthType") + " : ";


  public OnuCtcMulticastCtrlTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
    baseInfoPanel.add(tfUtsDot3OnuModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId));
//    tfUtsDot3OnuDeviceId.setName(fStringMap.getString("utsDot3OnuDeviceId"));
//    baseInfoPanel.add(tfUtsDot3OnuDeviceId);
//    baseInfoPanel.add(new HSpacer());

    String[] list2 = new String[4];
    for(int i = 0; i < list2.length; i++)
    {
      list2[i] = "" + (i + 1);
    }
    tfUtsDot3OnuPortId = new JComboBox(list2);
    baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
    baseInfoPanel.add(tfUtsDot3OnuPortId);
    baseInfoPanel.add(new HSpacer());

    String[] list3 = new String[64];
    for(int i = 0; i < list3.length; i++)
    {
      list3[i] = "" + (i + 1);
    }
    tfUtsDot3OnuLogicalPortId = new JComboBox(list3);
    baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
    baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
    baseInfoPanel.add(new HSpacer());

    String[] list4 = new String[8];
    for(int i = 0; i < list4.length; i++)
    {
      list4[i] = "" + (i + 1);
    }
    tfUtsDot3OnuEtherPortIndex = new JComboBox(list4);
    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMCastVlan));
    tfUtsDot3OnuMCastVlan.setName(fStringMap.getString("utsDot3OnuMCastVlan"));
    baseInfoPanel.add(tfUtsDot3OnuMCastVlan);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMCastGroupStart));
    tfUtsDot3OnuMCastGroupStart.setName(fStringMap.getString("utsDot3OnuMCastGroupStart"));
    baseInfoPanel.add(tfUtsDot3OnuMCastGroupStart);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMCastGroupEnd));
    tfUtsDot3OnuMCastGroupEnd.setName(fStringMap.getString("utsDot3OnuMCastGroupEnd"));
    baseInfoPanel.add(tfUtsDot3OnuMCastGroupEnd);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuAuthType));
    tfUtsDot3OnuAuthType.setName(fStringMap.getString("utsDot3OnuAuthType"));
    baseInfoPanel.add(tfUtsDot3OnuAuthType);
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
    tfUtsDot3OnuMCastVlan.setValueScope(1, 4094);
  }

  public void refresh() {

    tfUtsDot3OnuModuleId.removeAllItems();
    BBS4000NE ne = new BBS4000NE(fApplication);

    Vector v = ne.getEPMCardList();

    for (int i = 0; i < v.size(); i++) {
      tfUtsDot3OnuModuleId.addItem(v.get(i));
    }

    if (SnmpAction.IType.ADD.equals(fCommand))
    {
      tfUtsDot3OnuModuleId.setEnabled(true);
      tfUtsDot3OnuPortId.setEnabled(true);
      tfUtsDot3OnuLogicalPortId.setEnabled(true);
      tfUtsDot3OnuEtherPortIndex.setEnabled(true);
      tfUtsDot3OnuMCastVlan.setEnabled(true);
      tfUtsDot3OnuMCastGroupStart.setEnabled(true);
      return;
    }
    else
    {
      tfUtsDot3OnuModuleId.setEnabled(false);
      tfUtsDot3OnuPortId.setEnabled(false);
      tfUtsDot3OnuLogicalPortId.setEnabled(false);
      tfUtsDot3OnuEtherPortIndex.setEnabled(false);
      tfUtsDot3OnuMCastVlan.setEnabled(false);
      tfUtsDot3OnuMCastGroupStart.setEnabled(false);

      OnuCtcMulticastCtrlTable mbean = (OnuCtcMulticastCtrlTable) getModel();
      tfUtsDot3OnuMCastGroupEnd.setValue(mbean.getUtsDot3OnuMCastGroupEnd());
      tfUtsDot3OnuAuthType.setSelectedIndex(getIndexFromValue(utsDot3OnuAuthTypeVList, mbean.getUtsDot3OnuAuthType().intValue()));
    }
  }

  public void updateModel() {

    if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new OnuCtcMulticastCtrlTable(fApplication.getSnmpProxy()));

    OnuCtcMulticastCtrlTable mbean = (OnuCtcMulticastCtrlTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsDot3OnuModuleId(new Integer((String)tfUtsDot3OnuModuleId.getSelectedItem()));
      mbean.setUtsDot3OnuDeviceId(new Integer(1));
      mbean.setUtsDot3OnuPortId(new Integer((String)tfUtsDot3OnuPortId.getSelectedItem()));
      mbean.setUtsDot3OnuLogicalPortId(new Integer((String)tfUtsDot3OnuLogicalPortId.getSelectedItem()));
      mbean.setUtsDot3OnuEtherPortIndex(new Integer((String)tfUtsDot3OnuEtherPortIndex.getSelectedItem()));
      mbean.setUtsDot3OnuMCastVlan(new Integer(tfUtsDot3OnuMCastVlan.getValue()));
      mbean.setUtsDot3OnuMCastGroupStart(tfUtsDot3OnuMCastGroupStart.getIPString());
    }

    mbean.setUtsDot3OnuMCastGroupEnd(tfUtsDot3OnuMCastGroupEnd.getIPString());
    mbean.setUtsDot3OnuAuthType(new Integer(utsDot3OnuAuthTypeVList[tfUtsDot3OnuAuthType.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}
    
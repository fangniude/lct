/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcMulticastCtrlTable;
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
 * The Dot3Onu2CtcMulticastCtrlTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2CtcMulticastCtrlTablePanel extends UPanel {

  private JLabel tfUtsDot3OnuModuleId = new JLabel();

  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

  private JLabel tfUtsDot3OnuPortId = new JLabel();

  private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

  private IntegerTextField tfUtsDot3OnuMCastEntryIndex = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuMCastEntryUserId = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuMCastEntryMcVlanId = new IntegerTextField();

  private MacAddressField tfUtsDot3OnuMCastEntryMcMacAddr = new MacAddressField();

  private final String utsDot3OnuModuleId9 = fStringMap.getString("utsDot3OnuModuleId") + " : ";
  private final String utsDot3OnuDeviceId9 = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId9 = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId9 = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3OnuMCastEntryIndex = fStringMap.getString("utsDot3OnuMCastEntryIndex") + " : ";
  private final String utsDot3OnuMCastEntryUserId = fStringMap.getString("utsDot3OnuMCastEntryUserId") + " : ";
  private final String utsDot3OnuMCastEntryMcVlanId = fStringMap.getString("utsDot3OnuMCastEntryMcVlanId") + " : ";
  private final String utsDot3OnuMCastEntryMcMacAddr = fStringMap.getString("utsDot3OnuMCastEntryMcMacAddr") + " : ";


  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;


  public Dot3Onu2CtcMulticastCtrlTablePanel(IApplication app) {
    super(app);
    setModel(new Dot3Onu2CtcMulticastCtrlTable(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_Dot3Onu2CtcMulticastCtrlTable");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuModuleId9));
    baseInfoPanel.add(tfUtsDot3OnuModuleId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId9));
    baseInfoPanel.add(tfUtsDot3OnuDeviceId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPortId9));
    baseInfoPanel.add(tfUtsDot3OnuPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId9));
    baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMCastEntryIndex));
    tfUtsDot3OnuMCastEntryIndex.setName(fStringMap.getString("utsDot3OnuMCastEntryIndex"));
    baseInfoPanel.add(tfUtsDot3OnuMCastEntryIndex);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMCastEntryUserId));
    tfUtsDot3OnuMCastEntryUserId.setName(fStringMap.getString("utsDot3OnuMCastEntryUserId"));
    baseInfoPanel.add(tfUtsDot3OnuMCastEntryUserId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMCastEntryMcVlanId));
    tfUtsDot3OnuMCastEntryMcVlanId.setName(fStringMap.getString("utsDot3OnuMCastEntryMcVlanId"));
    baseInfoPanel.add(tfUtsDot3OnuMCastEntryMcVlanId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMCastEntryMcMacAddr));
    tfUtsDot3OnuMCastEntryMcMacAddr.setName(fStringMap.getString("utsDot3OnuMCastEntryMcMacAddr"));
    baseInfoPanel.add(tfUtsDot3OnuMCastEntryMcMacAddr);
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
    tfUtsDot3OnuMCastEntryIndex.setValueScope(1, 32);
    tfUtsDot3OnuMCastEntryMcVlanId.setValueScope(1, 4094);
  }

  public void refresh() {

    Dot3Onu2CtcMulticastCtrlTable mbean = (Dot3Onu2CtcMulticastCtrlTable) getModel();

    tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
    tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
    tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
    tfUtsDot3OnuMCastEntryIndex.setValue(mbean.getUtsDot3OnuMCastEntryIndex().intValue());
    tfUtsDot3OnuMCastEntryUserId.setValue(mbean.getUtsDot3OnuMCastEntryUserId().intValue());
    tfUtsDot3OnuMCastEntryMcVlanId.setValue(mbean.getUtsDot3OnuMCastEntryMcVlanId().intValue());
    tfUtsDot3OnuMCastEntryMcMacAddr.setValue(mbean.getUtsDot3OnuMCastEntryMcMacAddr());
  }

  public void updateModel() {

    Dot3Onu2CtcMulticastCtrlTable mbean = (Dot3Onu2CtcMulticastCtrlTable) getModel();

    mbean.setUtsDot3OnuMCastEntryIndex(new Integer(tfUtsDot3OnuMCastEntryIndex.getValue()));
    mbean.setUtsDot3OnuMCastEntryUserId(new Integer(tfUtsDot3OnuMCastEntryUserId.getValue()));
    mbean.setUtsDot3OnuMCastEntryMcVlanId(new Integer(tfUtsDot3OnuMCastEntryMcVlanId.getValue()));
    mbean.setUtsDot3OnuMCastEntryMcMacAddr(tfUtsDot3OnuMCastEntryMcMacAddr.getValue());
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}
    
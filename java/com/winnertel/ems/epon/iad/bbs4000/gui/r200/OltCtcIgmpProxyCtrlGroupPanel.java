/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OltCtcIgmpProxyCtrlGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The OltCtcIgmpProxyCtrlGroupPanel class.
 * Created by DVM Creator
 */
public class OltCtcIgmpProxyCtrlGroupPanel extends UPanel {

  private IntegerTextField tfUtsOltCtcIgmpProxyVlan = new IntegerTextField();


  private final String utsOltCtcIgmpProxyVlan = fStringMap.getString("utsOltCtcIgmpProxyVlan") + " : ";


  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;


  public OltCtcIgmpProxyCtrlGroupPanel(IApplication app) {
    super(app);
    setModel(new OltCtcIgmpProxyCtrlGroup(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_OltCtcIgmpProxyCtrlGroup");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsOltCtcIgmpProxyVlan));
    tfUtsOltCtcIgmpProxyVlan.setName(fStringMap.getString("utsOltCtcIgmpProxyVlan"));
    baseInfoPanel.add(tfUtsOltCtcIgmpProxyVlan);
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
    tfUtsOltCtcIgmpProxyVlan.setValueScope(1, 4094);


  }

  public void refresh() {

    OltCtcIgmpProxyCtrlGroup mbean = (OltCtcIgmpProxyCtrlGroup) getModel();
    BeanService.refreshBean(fApplication, mbean);

    tfUtsOltCtcIgmpProxyVlan.setValue(mbean.getUtsOltCtcIgmpProxyVlan().intValue());

  }

  public void updateModel() {

    OltCtcIgmpProxyCtrlGroup mbean = (OltCtcIgmpProxyCtrlGroup) getModel();

    mbean.setUtsOltCtcIgmpProxyVlan(new Integer(tfUtsOltCtcIgmpProxyVlan.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}
    
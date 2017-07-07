package com.winnertel.ems.epon.iad.bbs4000.gui;

/*
* Copyright (c) 2002-2005 UTStarcom, Inc.
* All rights reserved.
*/

import com.winnertel.ems.epon.iad.bbs4000.mib.MSTPXstPortTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The MSTPXstPortTableMBeanPanel class.
 * Created by DVM Creator
 */
public class MSTPXstPortTableMBeanPanel extends UPanel {
  private JLabel tfMstpXstPortIndex = new JLabel();
  private JComboBox tfMstpXstPortPriority = new JComboBox();
  private IntegerTextField tfMstpXstPortAdminInternalPathCost = new IntegerTextField();

  private final String mstpXstPortIndex = fStringMap.getString("mstpXstPortIndex") + " : ";
  private final String mstpXstPortPriority = fStringMap.getString("mstpXstPortPriority") + " : ";
  private final String mstpXstPortAdminInternalPathCost = fStringMap.getString("mstpXstPortAdminInternalPathCost") + " : ";

  public MSTPXstPortTableMBeanPanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(mstpXstPortIndex));
    baseInfoPanel.add(tfMstpXstPortIndex);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(mstpXstPortPriority));
    tfMstpXstPortPriority.setName(fStringMap.getString("mstpXstPortPriority"));
    baseInfoPanel.add(tfMstpXstPortPriority);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(mstpXstPortAdminInternalPathCost));
    tfMstpXstPortPriority.setName(fStringMap.getString("mstpXstPortAdminInternalPathCost"));
    baseInfoPanel.add(tfMstpXstPortAdminInternalPathCost);
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
    tfMstpXstPortPriority.removeAllItems();

    for (int i = 0; i < 16; i++) {
      tfMstpXstPortPriority.addItem("" + (i * 16));
    }

    tfMstpXstPortAdminInternalPathCost.setValueScope(0, 200000000);
  }

  public void refresh() {
    MSTPXstPortTableMBean mbean = (MSTPXstPortTableMBean) getModel();

    tfMstpXstPortIndex.setText(mbean.getMstpXstPortIndex());
    tfMstpXstPortPriority.setSelectedItem("" + mbean.getMstpXstPortPriority().intValue());
    tfMstpXstPortAdminInternalPathCost.setValue(mbean.getMstpXstPortAdminInternalPathCost());
  }

  public void updateModel() {
    MSTPXstPortTableMBean mbean = (MSTPXstPortTableMBean) getModel();
    mbean.setMstpXstPortPriority(new Integer((String) tfMstpXstPortPriority.getSelectedItem()));
    mbean.setMstpXstPortAdminInternalPathCost(tfMstpXstPortAdminInternalPathCost.getValue());
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}


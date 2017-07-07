/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OnuCtcBandCtrlTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The OnuCtcBandCtrlTablePanel class.
 * Created by DVM Creator
 */
public class OnuCtcBandCtrlTablePanel extends UPanel {

  private JLabel tfUtsDot3OnuModuleId = new JLabel();

//  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

  private JLabel tfUtsDot3OnuPortId = new JLabel();

  private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

  private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

  private IntegerTextField tfUtsDot3OnuMaxBand = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuPreviewLength = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuPreviewCount = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuPreviewInterval = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuPreviewResetTime = new IntegerTextField();


  private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
//  private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3OnuEtherPortIndex = fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";
  private final String utsDot3OnuMaxBand = fStringMap.getString("utsDot3OnuMaxBand") + " : ";
  private final String utsDot3OnuPreviewLength = fStringMap.getString("utsDot3OnuPreviewLength") + " : ";
  private final String utsDot3OnuPreviewCount = fStringMap.getString("utsDot3OnuPreviewCount") + " : ";
  private final String utsDot3OnuPreviewInterval = fStringMap.getString("utsDot3OnuPreviewInterval") + " : ";
  private final String utsDot3OnuPreviewResetTime = fStringMap.getString("utsDot3OnuPreviewResetTime") + " : ";


  public OnuCtcBandCtrlTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
    baseInfoPanel.add(tfUtsDot3OnuModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId));
//    baseInfoPanel.add(tfUtsDot3OnuDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
    baseInfoPanel.add(tfUtsDot3OnuPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
    baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuMaxBand));
    tfUtsDot3OnuMaxBand.setName(fStringMap.getString("utsDot3OnuMaxBand"));
    baseInfoPanel.add(tfUtsDot3OnuMaxBand);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPreviewLength));
    tfUtsDot3OnuPreviewLength.setName(fStringMap.getString("utsDot3OnuPreviewLength"));
    baseInfoPanel.add(tfUtsDot3OnuPreviewLength);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPreviewCount));
    tfUtsDot3OnuPreviewCount.setName(fStringMap.getString("utsDot3OnuPreviewCount"));
    baseInfoPanel.add(tfUtsDot3OnuPreviewCount);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPreviewInterval));
    tfUtsDot3OnuPreviewInterval.setName(fStringMap.getString("utsDot3OnuPreviewInterval"));
    baseInfoPanel.add(tfUtsDot3OnuPreviewInterval);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPreviewResetTime));
    tfUtsDot3OnuPreviewResetTime.setName(fStringMap.getString("utsDot3OnuPreviewResetTime"));
    baseInfoPanel.add(tfUtsDot3OnuPreviewResetTime);
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
    tfUtsDot3OnuMaxBand.setValueScope(1, 128);
    tfUtsDot3OnuPreviewLength.setValueScope(1, 300);
    tfUtsDot3OnuPreviewCount.setValueScope(1, 10);
    tfUtsDot3OnuPreviewInterval.setValueScope(1, 60);
    tfUtsDot3OnuPreviewResetTime.setValueScope(10, 3600);
  }

  public void refresh() {
    OnuCtcBandCtrlTable mbean = (OnuCtcBandCtrlTable) getModel();

    tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
//    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
    tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
    tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
    tfUtsDot3OnuEtherPortIndex.setText(mbean.getUtsDot3OnuEtherPortIndex().toString());
    tfUtsDot3OnuMaxBand.setValue(mbean.getUtsDot3OnuMaxBand().intValue());
    tfUtsDot3OnuPreviewLength.setValue(mbean.getUtsDot3OnuPreviewLength().intValue());
    tfUtsDot3OnuPreviewCount.setValue(mbean.getUtsDot3OnuPreviewCount().intValue());
    tfUtsDot3OnuPreviewInterval.setValue(mbean.getUtsDot3OnuPreviewInterval().intValue());
    tfUtsDot3OnuPreviewResetTime.setValue(mbean.getUtsDot3OnuPreviewResetTime().intValue());
  }

  public void updateModel() {
    OnuCtcBandCtrlTable mbean = (OnuCtcBandCtrlTable) getModel();
    
    mbean.setUtsDot3OnuMaxBand(new Integer(tfUtsDot3OnuMaxBand.getValue()));
    mbean.setUtsDot3OnuPreviewLength(new Integer(tfUtsDot3OnuPreviewLength.getValue()));
    mbean.setUtsDot3OnuPreviewCount(new Integer(tfUtsDot3OnuPreviewCount.getValue()));
    mbean.setUtsDot3OnuPreviewInterval(new Integer(tfUtsDot3OnuPreviewInterval.getValue()));
    mbean.setUtsDot3OnuPreviewResetTime(new Integer(tfUtsDot3OnuPreviewResetTime.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}
    
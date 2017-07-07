/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2PolicingTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Olt2PolicingTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Olt2PolicingTablePanel extends UPanel {

  private JLabel tfUtsDot3OltModuleId = new JLabel();

  private JLabel tfUtsDot3OltDeviceId = new JLabel();

  private int[] utsDot3OltBcPoliceEnableVList = new int[]{
    1, 2, };
  private String[] utsDot3OltBcPoliceEnableTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OltBcPoliceEnable = new JComboBox(utsDot3OltBcPoliceEnableTList);
  private IntegerTextField tfUtsDot3OltBcPoliceRate = new IntegerTextField();

  private IntegerTextField tfUtsDot3OltBcPoliceBurstSize = new IntegerTextField();

  private int[] utsDot3OltUmcPoliceEnableVList = new int[]{
    1, 2, };
  private String[] utsDot3OltUmcPoliceEnableTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OltUmcPoliceEnable = new JComboBox(utsDot3OltUmcPoliceEnableTList);
  private IntegerTextField tfUtsDot3OltUmcPoliceRate = new IntegerTextField();

  private IntegerTextField tfUtsDot3OltUmcPoliceBurstSize = new IntegerTextField();

  private int[] utsDot3OltUucPoliceEnableVList = new int[]{
    1, 2, };
  private String[] utsDot3OltUucPoliceEnableTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OltUucPoliceEnable = new JComboBox(utsDot3OltUucPoliceEnableTList);
  private IntegerTextField tfUtsDot3OltUucPoliceRate = new IntegerTextField();

  private IntegerTextField tfUtsDot3OltUucPoliceBurstSize = new IntegerTextField();


  private final String utsDot3OltModuleId6 = fStringMap.getString("utsDot3OltModuleId") + " : ";
  private final String utsDot3OltDeviceId6 = fStringMap.getString("utsDot3OltDeviceId") + " : ";
  private final String utsDot3OltBcPoliceEnable = fStringMap.getString("utsDot3OltBcPoliceEnable") + " : ";
  private final String utsDot3OltBcPoliceRate = fStringMap.getString("utsDot3OltBcPoliceRate") + " : ";
  private final String utsDot3OltBcPoliceBurstSize = fStringMap.getString("utsDot3OltBcPoliceBurstSize") + " : ";
  private final String utsDot3OltUmcPoliceEnable = fStringMap.getString("utsDot3OltUmcPoliceEnable") + " : ";
  private final String utsDot3OltUmcPoliceRate = fStringMap.getString("utsDot3OltUmcPoliceRate") + " : ";
  private final String utsDot3OltUmcPoliceBurstSize = fStringMap.getString("utsDot3OltUmcPoliceBurstSize") + " : ";
  private final String utsDot3OltUucPoliceEnable = fStringMap.getString("utsDot3OltUucPoliceEnable") + " : ";
  private final String utsDot3OltUucPoliceRate = fStringMap.getString("utsDot3OltUucPoliceRate") + " : ";
  private final String utsDot3OltUucPoliceBurstSize = fStringMap.getString("utsDot3OltUucPoliceBurstSize") + " : ";


  public Dot3Olt2PolicingTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OltModuleId6));
    baseInfoPanel.add(tfUtsDot3OltModuleId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltDeviceId6));
    baseInfoPanel.add(tfUtsDot3OltDeviceId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltBcPoliceEnable));
    tfUtsDot3OltBcPoliceEnable.setName(fStringMap.getString("utsDot3OltBcPoliceEnable"));
    baseInfoPanel.add(tfUtsDot3OltBcPoliceEnable);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltBcPoliceRate));
    tfUtsDot3OltBcPoliceRate.setName(fStringMap.getString("utsDot3OltBcPoliceRate"));
    baseInfoPanel.add(tfUtsDot3OltBcPoliceRate);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltBcPoliceBurstSize));
    tfUtsDot3OltBcPoliceBurstSize.setName(fStringMap.getString("utsDot3OltBcPoliceBurstSize"));
    baseInfoPanel.add(tfUtsDot3OltBcPoliceBurstSize);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltUmcPoliceEnable));
    tfUtsDot3OltUmcPoliceEnable.setName(fStringMap.getString("utsDot3OltUmcPoliceEnable"));
    baseInfoPanel.add(tfUtsDot3OltUmcPoliceEnable);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltUmcPoliceRate));
    tfUtsDot3OltUmcPoliceRate.setName(fStringMap.getString("utsDot3OltUmcPoliceRate"));
    baseInfoPanel.add(tfUtsDot3OltUmcPoliceRate);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltUmcPoliceBurstSize));
    tfUtsDot3OltUmcPoliceBurstSize.setName(fStringMap.getString("utsDot3OltUmcPoliceBurstSize"));
    baseInfoPanel.add(tfUtsDot3OltUmcPoliceBurstSize);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltUucPoliceEnable));
    tfUtsDot3OltUucPoliceEnable.setName(fStringMap.getString("utsDot3OltUucPoliceEnable"));
    baseInfoPanel.add(tfUtsDot3OltUucPoliceEnable);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltUucPoliceRate));
    tfUtsDot3OltUucPoliceRate.setName(fStringMap.getString("utsDot3OltUucPoliceRate"));
    baseInfoPanel.add(tfUtsDot3OltUucPoliceRate);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltUucPoliceBurstSize));
    tfUtsDot3OltUucPoliceBurstSize.setName(fStringMap.getString("utsDot3OltUucPoliceBurstSize"));
    baseInfoPanel.add(tfUtsDot3OltUucPoliceBurstSize);
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


  }

  public void refresh() {

    Dot3Olt2PolicingTable mbean = (Dot3Olt2PolicingTable) getModel();

    tfUtsDot3OltModuleId.setText(mbean.getUtsDot3OltModuleId().toString());
    tfUtsDot3OltDeviceId.setText(mbean.getUtsDot3OltDeviceId().toString());
    tfUtsDot3OltBcPoliceEnable.setSelectedIndex(getIndexFromValue(utsDot3OltBcPoliceEnableVList, mbean.getUtsDot3OltBcPoliceEnable().intValue()));
    tfUtsDot3OltBcPoliceRate.setValue(mbean.getUtsDot3OltBcPoliceRate().intValue());
    tfUtsDot3OltBcPoliceBurstSize.setValue(mbean.getUtsDot3OltBcPoliceBurstSize().intValue());
    tfUtsDot3OltUmcPoliceEnable.setSelectedIndex(getIndexFromValue(utsDot3OltUmcPoliceEnableVList, mbean.getUtsDot3OltUmcPoliceEnable().intValue()));
    tfUtsDot3OltUmcPoliceRate.setValue(mbean.getUtsDot3OltUmcPoliceRate().intValue());
    tfUtsDot3OltUmcPoliceBurstSize.setValue(mbean.getUtsDot3OltUmcPoliceBurstSize().intValue());
    tfUtsDot3OltUucPoliceEnable.setSelectedIndex(getIndexFromValue(utsDot3OltUucPoliceEnableVList, mbean.getUtsDot3OltUucPoliceEnable().intValue()));
    tfUtsDot3OltUucPoliceRate.setValue(mbean.getUtsDot3OltUucPoliceRate().intValue());
    tfUtsDot3OltUucPoliceBurstSize.setValue(mbean.getUtsDot3OltUucPoliceBurstSize().intValue());

  }

  public void updateModel() {

    Dot3Olt2PolicingTable mbean = (Dot3Olt2PolicingTable) getModel();


    mbean.setUtsDot3OltBcPoliceEnable(new Integer(utsDot3OltBcPoliceEnableVList[tfUtsDot3OltBcPoliceEnable.getSelectedIndex()]));
    mbean.setUtsDot3OltBcPoliceRate(new Integer(tfUtsDot3OltBcPoliceRate.getValue()));
    mbean.setUtsDot3OltBcPoliceBurstSize(new Integer(tfUtsDot3OltBcPoliceBurstSize.getValue()));
    mbean.setUtsDot3OltUmcPoliceEnable(new Integer(utsDot3OltUmcPoliceEnableVList[tfUtsDot3OltUmcPoliceEnable.getSelectedIndex()]));
    mbean.setUtsDot3OltUmcPoliceRate(new Integer(tfUtsDot3OltUmcPoliceRate.getValue()));
    mbean.setUtsDot3OltUmcPoliceBurstSize(new Integer(tfUtsDot3OltUmcPoliceBurstSize.getValue()));
    mbean.setUtsDot3OltUucPoliceEnable(new Integer(utsDot3OltUucPoliceEnableVList[tfUtsDot3OltUucPoliceEnable.getSelectedIndex()]));
    mbean.setUtsDot3OltUucPoliceRate(new Integer(tfUtsDot3OltUucPoliceRate.getValue()));
    mbean.setUtsDot3OltUucPoliceBurstSize(new Integer(tfUtsDot3OltUucPoliceBurstSize.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}

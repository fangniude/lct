/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2ClassifiRuleTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2ClassifiRuleTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2ClassifiRuleTablePanel extends UPanel {

  private JLabel tfUtsDot3OnuModuleId = new JLabel();

  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

  private JLabel tfUtsDot3OnuPortId = new JLabel();

  private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

  private IntegerTextField tfUtsDot3OnuClassifiRuleIndex = new IntegerTextField();

  private int[] utsDot3OnuClassifiRuleEnableVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuClassifiRuleEnableTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OnuClassifiRuleEnable = new JComboBox(utsDot3OnuClassifiRuleEnableTList);
  private int[] utsDot3OnuClassifiRuleProtIdVList = new int[]{
    2, 1, 3, };
  private String[] utsDot3OnuClassifiRuleProtIdTList = new String[]{
    fStringMap.getString("udp"),
    fStringMap.getString("tcp"),
    fStringMap.getString("any"),
  };
  private JComboBox tfUtsDot3OnuClassifiRuleProtId = new JComboBox(utsDot3OnuClassifiRuleProtIdTList);
  private IntegerTextField tfUtsDot3OnuClassifiRuleUniPort = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiRuleL4SrcPortStart = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiRuleL4SrcPortEnd = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiRuleL4DstPortStart = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiRuleL4DstPortEnd = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiRuleDscp = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiRule802Dot1p = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiRuleCosQueue = new IntegerTextField();


  private final String utsDot3OnuModuleId6 = fStringMap.getString("utsDot3OnuModuleId") + " : ";
  private final String utsDot3OnuDeviceId6 = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId6 = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId6 = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3OnuClassifiRuleIndex = fStringMap.getString("utsDot3OnuClassifiRuleIndex") + " : ";
  private final String utsDot3OnuClassifiRuleEnable = fStringMap.getString("utsDot3OnuClassifiRuleEnable") + " : ";
  private final String utsDot3OnuClassifiRuleProtId = fStringMap.getString("utsDot3OnuClassifiRuleProtId") + " : ";
  private final String utsDot3OnuClassifiRuleUniPort = fStringMap.getString("utsDot3OnuClassifiRuleUniPort") + " : ";
  private final String utsDot3OnuClassifiRuleL4SrcPortStart = fStringMap.getString("utsDot3OnuClassifiRuleL4SrcPortStart") + " : ";
  private final String utsDot3OnuClassifiRuleL4SrcPortEnd = fStringMap.getString("utsDot3OnuClassifiRuleL4SrcPortEnd") + " : ";
  private final String utsDot3OnuClassifiRuleL4DstPortStart = fStringMap.getString("utsDot3OnuClassifiRuleL4DstPortStart") + " : ";
  private final String utsDot3OnuClassifiRuleL4DstPortEnd = fStringMap.getString("utsDot3OnuClassifiRuleL4DstPortEnd") + " : ";
  private final String utsDot3OnuClassifiRuleDscp = fStringMap.getString("utsDot3OnuClassifiRuleDscp") + " : ";
  private final String utsDot3OnuClassifiRule802Dot1p = fStringMap.getString("utsDot3OnuClassifiRule802Dot1p") + " : ";
  private final String utsDot3OnuClassifiRuleCosQueue = fStringMap.getString("utsDot3OnuClassifiRuleCosQueue") + " : ";


  public Dot3Onu2ClassifiRuleTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(15, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuModuleId6));
    baseInfoPanel.add(tfUtsDot3OnuModuleId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId6));
    baseInfoPanel.add(tfUtsDot3OnuDeviceId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPortId6));
    baseInfoPanel.add(tfUtsDot3OnuPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId6));
    baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleIndex));
    tfUtsDot3OnuClassifiRuleIndex.setName(fStringMap.getString("utsDot3OnuClassifiRuleIndex"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleIndex);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleEnable));
    tfUtsDot3OnuClassifiRuleEnable.setName(fStringMap.getString("utsDot3OnuClassifiRuleEnable"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleEnable);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleProtId));
    tfUtsDot3OnuClassifiRuleProtId.setName(fStringMap.getString("utsDot3OnuClassifiRuleProtId"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleProtId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleUniPort));
    tfUtsDot3OnuClassifiRuleUniPort.setName(fStringMap.getString("utsDot3OnuClassifiRuleUniPort"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleUniPort);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleL4SrcPortStart));
    tfUtsDot3OnuClassifiRuleL4SrcPortStart.setName(fStringMap.getString("utsDot3OnuClassifiRuleL4SrcPortStart"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleL4SrcPortStart);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleL4SrcPortEnd));
    tfUtsDot3OnuClassifiRuleL4SrcPortEnd.setName(fStringMap.getString("utsDot3OnuClassifiRuleL4SrcPortEnd"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleL4SrcPortEnd);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleL4DstPortStart));
    tfUtsDot3OnuClassifiRuleL4DstPortStart.setName(fStringMap.getString("utsDot3OnuClassifiRuleL4DstPortStart"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleL4DstPortStart);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleL4DstPortEnd));
    tfUtsDot3OnuClassifiRuleL4DstPortEnd.setName(fStringMap.getString("utsDot3OnuClassifiRuleL4DstPortEnd"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleL4DstPortEnd);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleDscp));
    tfUtsDot3OnuClassifiRuleDscp.setName(fStringMap.getString("utsDot3OnuClassifiRuleDscp"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleDscp);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRule802Dot1p));
    tfUtsDot3OnuClassifiRule802Dot1p.setName(fStringMap.getString("utsDot3OnuClassifiRule802Dot1p"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRule802Dot1p);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleCosQueue));
    tfUtsDot3OnuClassifiRuleCosQueue.setName(fStringMap.getString("utsDot3OnuClassifiRuleCosQueue"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleCosQueue);
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

    Dot3Onu2ClassifiRuleTable mbean = (Dot3Onu2ClassifiRuleTable) getModel();

    tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
    tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
    tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
    tfUtsDot3OnuClassifiRuleIndex.setValue(mbean.getUtsDot3OnuClassifiRuleIndex().intValue());
    tfUtsDot3OnuClassifiRuleEnable.setSelectedIndex(getIndexFromValue(utsDot3OnuClassifiRuleEnableVList, mbean.getUtsDot3OnuClassifiRuleEnable().intValue()));
    tfUtsDot3OnuClassifiRuleProtId.setSelectedIndex(getIndexFromValue(utsDot3OnuClassifiRuleProtIdVList, mbean.getUtsDot3OnuClassifiRuleProtId().intValue()));
    tfUtsDot3OnuClassifiRuleUniPort.setValue(mbean.getUtsDot3OnuClassifiRuleUniPort().intValue());
    tfUtsDot3OnuClassifiRuleL4SrcPortStart.setValue(mbean.getUtsDot3OnuClassifiRuleL4SrcPortStart().intValue());
    tfUtsDot3OnuClassifiRuleL4SrcPortEnd.setValue(mbean.getUtsDot3OnuClassifiRuleL4SrcPortEnd().intValue());
    tfUtsDot3OnuClassifiRuleL4DstPortStart.setValue(mbean.getUtsDot3OnuClassifiRuleL4DstPortStart().intValue());
    tfUtsDot3OnuClassifiRuleL4DstPortEnd.setValue(mbean.getUtsDot3OnuClassifiRuleL4DstPortEnd().intValue());
    tfUtsDot3OnuClassifiRuleDscp.setValue(mbean.getUtsDot3OnuClassifiRuleDscp().intValue());
    tfUtsDot3OnuClassifiRule802Dot1p.setValue(mbean.getUtsDot3OnuClassifiRule802Dot1p().intValue());
    tfUtsDot3OnuClassifiRuleCosQueue.setValue(mbean.getUtsDot3OnuClassifiRuleCosQueue().intValue());

  }

  public void updateModel() {

    Dot3Onu2ClassifiRuleTable mbean = (Dot3Onu2ClassifiRuleTable) getModel();


    mbean.setUtsDot3OnuClassifiRuleIndex(new Integer(tfUtsDot3OnuClassifiRuleIndex.getValue()));
    mbean.setUtsDot3OnuClassifiRuleEnable(new Integer(utsDot3OnuClassifiRuleEnableVList[tfUtsDot3OnuClassifiRuleEnable.getSelectedIndex()]));
    mbean.setUtsDot3OnuClassifiRuleProtId(new Integer(utsDot3OnuClassifiRuleProtIdVList[tfUtsDot3OnuClassifiRuleProtId.getSelectedIndex()]));
    mbean.setUtsDot3OnuClassifiRuleUniPort(new Integer(tfUtsDot3OnuClassifiRuleUniPort.getValue()));
    mbean.setUtsDot3OnuClassifiRuleL4SrcPortStart(new Integer(tfUtsDot3OnuClassifiRuleL4SrcPortStart.getValue()));
    mbean.setUtsDot3OnuClassifiRuleL4SrcPortEnd(new Integer(tfUtsDot3OnuClassifiRuleL4SrcPortEnd.getValue()));
    mbean.setUtsDot3OnuClassifiRuleL4DstPortStart(new Integer(tfUtsDot3OnuClassifiRuleL4DstPortStart.getValue()));
    mbean.setUtsDot3OnuClassifiRuleL4DstPortEnd(new Integer(tfUtsDot3OnuClassifiRuleL4DstPortEnd.getValue()));
    mbean.setUtsDot3OnuClassifiRuleDscp(new Integer(tfUtsDot3OnuClassifiRuleDscp.getValue()));
    mbean.setUtsDot3OnuClassifiRule802Dot1p(new Integer(tfUtsDot3OnuClassifiRule802Dot1p.getValue()));
    mbean.setUtsDot3OnuClassifiRuleCosQueue(new Integer(tfUtsDot3OnuClassifiRuleCosQueue.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}
    
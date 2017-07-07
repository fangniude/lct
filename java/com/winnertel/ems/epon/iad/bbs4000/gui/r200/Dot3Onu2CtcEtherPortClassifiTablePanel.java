/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcEtherPortClassifiTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2CtcEtherPortClassifiTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2CtcEtherPortClassifiTablePanel extends UPanel {

  private JLabel tfUtsDot3OnuModuleId = new JLabel();

  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

  private JLabel tfUtsDot3OnuPortId = new JLabel();

  private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

  private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

  private IntegerTextField tfUtsDot3OnuClassifiRuleIndex = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiPrecedence = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiQueueMapped = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiEtherPriMark = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiFSelect1 = new IntegerTextField();

  private StringTextField tfUtsDot3OnuClassifiFMatch1 = new StringTextField();

  private IntegerTextField tfUtsDot3OnuClassifiOperator1 = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiFSelect2 = new IntegerTextField();

  private StringTextField tfUtsDot3OnuClassifiFMatch2 = new StringTextField();

  private IntegerTextField tfUtsDot3OnuClassifiOperator2 = new IntegerTextField();

  private IntegerTextField tfUtsDot3OnuClassifiFSelect3 = new IntegerTextField();

  private StringTextField tfUtsDot3OnuClassifiFMatch3 = new StringTextField();

  private IntegerTextField tfUtsDot3OnuClassifiOperator3 = new IntegerTextField();

  private final String utsDot3OnuModuleId8 = fStringMap.getString("utsDot3OnuModuleId") + " : ";
  private final String utsDot3OnuDeviceId8 = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId8 = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId8 = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3OnuEtherPortIndex2 = fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";
  private final String utsDot3OnuClassifiRuleIndex2 = fStringMap.getString("utsDot3OnuClassifiRuleIndex") + " : ";
  private final String utsDot3OnuClassifiPrecedence = fStringMap.getString("utsDot3OnuClassifiPrecedence") + " : ";
  private final String utsDot3OnuClassifiQueueMapped = fStringMap.getString("utsDot3OnuClassifiQueueMapped") + " : ";
  private final String utsDot3OnuClassifiEtherPriMark = fStringMap.getString("utsDot3OnuClassifiEtherPriMark") + " : ";
  private final String utsDot3OnuClassifiFSelect1 = fStringMap.getString("utsDot3OnuClassifiFSelect1") + " : ";
  private final String utsDot3OnuClassifiFMatch1 = fStringMap.getString("utsDot3OnuClassifiFMatch1") + " : ";
  private final String utsDot3OnuClassifiOperator1 = fStringMap.getString("utsDot3OnuClassifiOperator1") + " : ";
  private final String utsDot3OnuClassifiFSelect2 = fStringMap.getString("utsDot3OnuClassifiFSelect2") + " : ";
  private final String utsDot3OnuClassifiFMatch2 = fStringMap.getString("utsDot3OnuClassifiFMatch2") + " : ";
  private final String utsDot3OnuClassifiOperator2 = fStringMap.getString("utsDot3OnuClassifiOperator2") + " : ";
  private final String utsDot3OnuClassifiFSelect3 = fStringMap.getString("utsDot3OnuClassifiFSelect3") + " : ";
  private final String utsDot3OnuClassifiFMatch3 = fStringMap.getString("utsDot3OnuClassifiFMatch3") + " : ";
  private final String utsDot3OnuClassifiOperator3 = fStringMap.getString("utsDot3OnuClassifiOperator3") + " : ";


  public Dot3Onu2CtcEtherPortClassifiTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(19, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuModuleId8));
    baseInfoPanel.add(tfUtsDot3OnuModuleId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId8));
    baseInfoPanel.add(tfUtsDot3OnuDeviceId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPortId8));
    baseInfoPanel.add(tfUtsDot3OnuPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId8));
    baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex2));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiRuleIndex2));
    tfUtsDot3OnuClassifiRuleIndex.setName(fStringMap.getString("utsDot3OnuClassifiRuleIndex"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiRuleIndex);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiPrecedence));
    tfUtsDot3OnuClassifiPrecedence.setName(fStringMap.getString("utsDot3OnuClassifiPrecedence"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiPrecedence);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiQueueMapped));
    tfUtsDot3OnuClassifiQueueMapped.setName(fStringMap.getString("utsDot3OnuClassifiQueueMapped"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiQueueMapped);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiEtherPriMark));
    tfUtsDot3OnuClassifiEtherPriMark.setName(fStringMap.getString("utsDot3OnuClassifiEtherPriMark"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiEtherPriMark);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiFSelect1));
    tfUtsDot3OnuClassifiFSelect1.setName(fStringMap.getString("utsDot3OnuClassifiFSelect1"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiFSelect1);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiFMatch1));
    tfUtsDot3OnuClassifiFMatch1.setName(fStringMap.getString("utsDot3OnuClassifiFMatch1"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiFMatch1);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiOperator1));
    tfUtsDot3OnuClassifiOperator1.setName(fStringMap.getString("utsDot3OnuClassifiOperator1"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiOperator1);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiFSelect2));
    tfUtsDot3OnuClassifiFSelect2.setName(fStringMap.getString("utsDot3OnuClassifiFSelect2"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiFSelect2);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiFMatch2));
    tfUtsDot3OnuClassifiFMatch2.setName(fStringMap.getString("utsDot3OnuClassifiFMatch2"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiFMatch2);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiOperator2));
    tfUtsDot3OnuClassifiOperator2.setName(fStringMap.getString("utsDot3OnuClassifiOperator2"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiOperator2);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiFSelect3));
    tfUtsDot3OnuClassifiFSelect3.setName(fStringMap.getString("utsDot3OnuClassifiFSelect3"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiFSelect3);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiFMatch3));
    tfUtsDot3OnuClassifiFMatch3.setName(fStringMap.getString("utsDot3OnuClassifiFMatch3"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiFMatch3);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuClassifiOperator3));
    tfUtsDot3OnuClassifiOperator3.setName(fStringMap.getString("utsDot3OnuClassifiOperator3"));
    baseInfoPanel.add(tfUtsDot3OnuClassifiOperator3);
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


    tfUtsDot3OnuClassifiRuleIndex.setValueScope(1, 8);

    tfUtsDot3OnuClassifiPrecedence.setValueScope(1, 8);

    tfUtsDot3OnuClassifiQueueMapped.setValueScope(1, 8);

    tfUtsDot3OnuClassifiEtherPriMark.setValueScope(0, 7);

    tfUtsDot3OnuClassifiFSelect1.setValueScope(0, 11);


    tfUtsDot3OnuClassifiOperator1.setValueScope(0, 7);

    tfUtsDot3OnuClassifiFSelect2.setValueScope(0, 11);


    tfUtsDot3OnuClassifiOperator2.setValueScope(0, 7);

    tfUtsDot3OnuClassifiFSelect3.setValueScope(0, 11);


    tfUtsDot3OnuClassifiOperator3.setValueScope(0, 7);


  }

  public void refresh() {
    if (SnmpAction.IType.ADD.equals(fCommand)) return;
    Dot3Onu2CtcEtherPortClassifiTable mbean = (Dot3Onu2CtcEtherPortClassifiTable) getModel();

    tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
    tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
    tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
    tfUtsDot3OnuEtherPortIndex.setText(mbean.getUtsDot3OnuEtherPortIndex().toString());
    tfUtsDot3OnuClassifiRuleIndex.setValue(mbean.getUtsDot3OnuClassifiRuleIndex().intValue());
    tfUtsDot3OnuClassifiPrecedence.setValue(mbean.getUtsDot3OnuClassifiPrecedence().intValue());
    tfUtsDot3OnuClassifiQueueMapped.setValue(mbean.getUtsDot3OnuClassifiQueueMapped().intValue());
    tfUtsDot3OnuClassifiEtherPriMark.setValue(mbean.getUtsDot3OnuClassifiEtherPriMark().intValue());
    tfUtsDot3OnuClassifiFSelect1.setValue(mbean.getUtsDot3OnuClassifiFSelect1().intValue());
    tfUtsDot3OnuClassifiFMatch1.setValue(mbean.getUtsDot3OnuClassifiFMatch1());
    tfUtsDot3OnuClassifiOperator1.setValue(mbean.getUtsDot3OnuClassifiOperator1().intValue());
    tfUtsDot3OnuClassifiFSelect2.setValue(mbean.getUtsDot3OnuClassifiFSelect2().intValue());
    tfUtsDot3OnuClassifiFMatch2.setValue(mbean.getUtsDot3OnuClassifiFMatch2());
    tfUtsDot3OnuClassifiOperator2.setValue(mbean.getUtsDot3OnuClassifiOperator2().intValue());
    tfUtsDot3OnuClassifiFSelect3.setValue(mbean.getUtsDot3OnuClassifiFSelect3().intValue());
    tfUtsDot3OnuClassifiFMatch3.setValue(mbean.getUtsDot3OnuClassifiFMatch3());
    tfUtsDot3OnuClassifiOperator3.setValue(mbean.getUtsDot3OnuClassifiOperator3().intValue());
  }

  public void updateModel() {

    if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new Dot3Onu2CtcEtherPortClassifiTable(fApplication.getSnmpProxy()));

    Dot3Onu2CtcEtherPortClassifiTable mbean = (Dot3Onu2CtcEtherPortClassifiTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      //  here set the value of index
//      mbean.set
    }

    mbean.setUtsDot3OnuClassifiRuleIndex(new Integer(tfUtsDot3OnuClassifiRuleIndex.getValue()));
    mbean.setUtsDot3OnuClassifiPrecedence(new Integer(tfUtsDot3OnuClassifiPrecedence.getValue()));
    mbean.setUtsDot3OnuClassifiQueueMapped(new Integer(tfUtsDot3OnuClassifiQueueMapped.getValue()));
    mbean.setUtsDot3OnuClassifiEtherPriMark(new Integer(tfUtsDot3OnuClassifiEtherPriMark.getValue()));
    mbean.setUtsDot3OnuClassifiFSelect1(new Integer(tfUtsDot3OnuClassifiFSelect1.getValue()));
    mbean.setUtsDot3OnuClassifiFMatch1(new String(tfUtsDot3OnuClassifiFMatch1.getValue()));
    mbean.setUtsDot3OnuClassifiOperator1(new Integer(tfUtsDot3OnuClassifiOperator1.getValue()));
    mbean.setUtsDot3OnuClassifiFSelect2(new Integer(tfUtsDot3OnuClassifiFSelect2.getValue()));
    mbean.setUtsDot3OnuClassifiFMatch2(new String(tfUtsDot3OnuClassifiFMatch2.getValue()));
    mbean.setUtsDot3OnuClassifiOperator2(new Integer(tfUtsDot3OnuClassifiOperator2.getValue()));
    mbean.setUtsDot3OnuClassifiFSelect3(new Integer(tfUtsDot3OnuClassifiFSelect3.getValue()));
    mbean.setUtsDot3OnuClassifiFMatch3(new String(tfUtsDot3OnuClassifiFMatch3.getValue()));
    mbean.setUtsDot3OnuClassifiOperator3(new Integer(tfUtsDot3OnuClassifiOperator3.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}
    
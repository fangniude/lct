/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcLpBkGroup;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The Dot3Onu2CtcLpBkGroupPanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2CtcLpBkGroupPanel extends UPanel {

  private JComboBox tfUtsDot3Onu2LpBkModuleId = new JComboBox();

//  private JComboBox tfUtsDot3Onu2LpBkDeviceId = new JComboBox();

  private JComboBox tfUtsDot3Onu2LpBkPortId = new JComboBox(new String[]{"1", "2", "3", "4"});

  private JComboBox tfUtsDot3Onu2LpBkLogicalPortId = new JComboBox();


  private IntegerTextField tfUtsDot3Onu2LpBkPacketSize = new IntegerTextField();

  private IntegerTextField tfUtsDot3Onu2LpBkPacketNum = new IntegerTextField();

  private int[] utsDot3Onu2LpBkModeVList = new int[]{
    1, 2 };
  private String[] utsDot3Onu2LpBkModeTList = new String[]{
    fStringMap.getString("local"),
    fStringMap.getString("remote")
  };
  private JComboBox tfUtsDot3Onu2LpBkMode = new JComboBox(utsDot3Onu2LpBkModeTList);

  private int[] utsDot3Onu2LpBkStartVList = new int[]{1, 2};
  private String[] utsDot3Onu2LpBkStartTList = new String[]{
    fStringMap.getString("start"),
    fStringMap.getString("stop")
  };
  private JComboBox tfUtsDot3Onu2LpBkStart = new JComboBox(utsDot3Onu2LpBkStartTList);

  private JLabel tfUtsDot3Onu2LpBkResult = new JLabel();

  private final String utsDot3Onu2LpBkModuleId = fStringMap.getString("utsDot3Onu2LpBkModuleId") + " : ";
//  private final String utsDot3Onu2LpBkDeviceId = fStringMap.getString("utsDot3Onu2LpBkDeviceId") + " : ";
  private final String utsDot3Onu2LpBkPortId = fStringMap.getString("utsDot3Onu2LpBkPortId") + " : ";
  private final String utsDot3Onu2LpBkLogicalPortId = fStringMap.getString("utsDot3Onu2LpBkLogicalPortId") + " : ";
  private final String utsDot3Onu2LpBkMode = fStringMap.getString("utsDot3Onu2LpBkMode") + " : ";
  private final String utsDot3Onu2LpBkPacketSize = fStringMap.getString("utsDot3Onu2LpBkPacketSize") + " : ";
  private final String utsDot3Onu2LpBkPacketNum = fStringMap.getString("utsDot3Onu2LpBkPacketNum") + " : ";
  private final String utsDot3Onu2LpBkStart = fStringMap.getString("utsDot3Onu2LpBkStart") + " : ";
  private final String utsDot3Onu2LpBkResult = fStringMap.getString("utsDot3Onu2LpBkResult") + ":";


  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;


  public Dot3Onu2CtcLpBkGroupPanel(IApplication app) {
    super(app);
    setModel(new Dot3Onu2CtcLpBkGroup(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_Dot3Onu2CtcLpBkGroup");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3Onu2LpBkModuleId));
    baseInfoPanel.add(tfUtsDot3Onu2LpBkModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuLpBkDeviceId));
//    baseInfoPanel.add(tfUtsDot3OnuLpBkDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3Onu2LpBkPortId));
    baseInfoPanel.add(tfUtsDot3Onu2LpBkPortId);
    baseInfoPanel.add(new HSpacer());

    int count = new BBS4000NE(fApplication).getPonSplitRatio();
    for (int i = 1; i <= count; i++) {
      tfUtsDot3Onu2LpBkLogicalPortId.addItem("" + i);
    }
    baseInfoPanel.add(new JLabel(utsDot3Onu2LpBkLogicalPortId));
    baseInfoPanel.add(tfUtsDot3Onu2LpBkLogicalPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3Onu2LpBkMode));
    tfUtsDot3Onu2LpBkMode.setName(fStringMap.getString("utsDot3OnuLpBkMode"));
    baseInfoPanel.add(tfUtsDot3Onu2LpBkMode);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3Onu2LpBkPacketSize));
    tfUtsDot3Onu2LpBkPacketSize.setName(fStringMap.getString("utsDot3OnuLpBkPacketSize"));
    baseInfoPanel.add(tfUtsDot3Onu2LpBkPacketSize);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3Onu2LpBkPacketNum));
    tfUtsDot3Onu2LpBkPacketNum.setName(fStringMap.getString("utsDot3OnuLpBkPacketNum"));
    baseInfoPanel.add(tfUtsDot3Onu2LpBkPacketNum);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3Onu2LpBkStart));
    tfUtsDot3Onu2LpBkStart.setName(fStringMap.getString("utsDot3OnuLpBkStart"));
    baseInfoPanel.add(tfUtsDot3Onu2LpBkStart);
    baseInfoPanel.add(new HSpacer());


    JPanel lpResultPanel = new JPanel();
    layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    lpResultPanel.setLayout(layout);

    lpResultPanel.add(new JLabel(utsDot3Onu2LpBkResult));
    tfUtsDot3Onu2LpBkResult.setName(fStringMap.getString("utsDot3Onu2LpBkResult"));
    lpResultPanel.add(tfUtsDot3Onu2LpBkResult);
    lpResultPanel.add(new HSpacer());

    JPanel allPanel = new JPanel();
    layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(lpResultPanel);
    allPanel.add(new HSpacer());
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.SOUTH);
  }

  protected void initForm() {
    tfUtsDot3Onu2LpBkPacketSize.setValueScope(64, 1500);
    tfUtsDot3Onu2LpBkPacketNum.setValueScope(1, 99);
  }

  public void refresh() {
    tfUtsDot3Onu2LpBkModuleId.removeAllItems();
    BBS4000NE ne = new BBS4000NE(fApplication);

    Vector v = ne.getEPMCardList();

    for (int i = 0; i < v.size(); i++) {
      tfUtsDot3Onu2LpBkModuleId.addItem(v.get(i));
    }

    Dot3Onu2CtcLpBkGroup mbean = (Dot3Onu2CtcLpBkGroup) getModel();

//    BeanService.refreshBean(fApplication, mbean);

    try {
		mbean.retrieve();
	} catch (MibBeanException e) {
		e.printStackTrace();
	}

    tfUtsDot3Onu2LpBkModuleId.setSelectedItem("" + mbean.getUtsDot3OnuLpBkModuleId());
    tfUtsDot3Onu2LpBkPortId.setSelectedItem("" + mbean.getUtsDot3OnuLpBkPortId());
    tfUtsDot3Onu2LpBkLogicalPortId.setSelectedItem("" + mbean.getUtsDot3OnuLpBkLogicalPortId());
    tfUtsDot3Onu2LpBkPacketSize.setValue(mbean.getUtsDot3OnuLpBkPacketSize().intValue());
    tfUtsDot3Onu2LpBkPacketNum.setValue(mbean.getUtsDot3OnuLpBkPacketNum().intValue());
    tfUtsDot3Onu2LpBkMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2LpBkModeVList, mbean.getUtsDot3OnuLpBkMode().intValue()));
    tfUtsDot3Onu2LpBkStart.setSelectedIndex(getIndexFromValue(utsDot3Onu2LpBkStartVList, mbean.getUtsDot3OnuLpBkStart().intValue()));
    tfUtsDot3Onu2LpBkResult.setText(mbean.getUtsDot3OnuLpBkResult());
  }

  public boolean validateFrom() {
    if (tfUtsDot3Onu2LpBkModuleId.getSelectedItem() == null) {
      String error = fStringMap.getString("Err_Module_Id_Is_Null");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }

    Dot3Onu2CtcLpBkGroup mbean = (Dot3Onu2CtcLpBkGroup) getModel();
    String oldModulePortLogical = new StringBuffer().append( mbean.getUtsDot3OnuLpBkModuleId()).append("/").
    												append( mbean.getUtsDot3OnuLpBkPortId()).append("/").
    												append( mbean.getUtsDot3OnuLpBkLogicalPortId()).toString();
    String newModulePortLogical = new StringBuffer().append( (String)tfUtsDot3Onu2LpBkModuleId.getSelectedItem() ).append("/").
    												append( (String)tfUtsDot3Onu2LpBkPortId.getSelectedItem()).append("/").
    												append( (String)tfUtsDot3Onu2LpBkLogicalPortId.getSelectedItem()).toString();

    if ( ( utsDot3Onu2LpBkStartVList[tfUtsDot3Onu2LpBkStart.getSelectedIndex()] == 1 && mbean.getUtsDot3OnuLpBkStart().intValue() == 1 ) 
    		&& !oldModulePortLogical.equals("0/0/0")
    		&& !oldModulePortLogical.equals(newModulePortLogical) ) {
    	MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_LPTest_Start_Should_Stop"));
    	refresh();
    	return false;
    }

    return true;
  }

  public void updateModel() {

    Dot3Onu2CtcLpBkGroup mbean = (Dot3Onu2CtcLpBkGroup) getModel();

    mbean.setUtsDot3OnuLpBkModuleId(new Integer((String)tfUtsDot3Onu2LpBkModuleId.getSelectedItem()));
    mbean.setUtsDot3OnuLpBkPortId(new Integer((String)tfUtsDot3Onu2LpBkPortId.getSelectedItem()));
    mbean.setUtsDot3OnuLpBkLogicalPortId(new Integer((String)tfUtsDot3Onu2LpBkLogicalPortId.getSelectedItem()));
    mbean.setUtsDot3OnuLpBkPacketSize(new Integer(tfUtsDot3Onu2LpBkPacketSize.getValue()));
    mbean.setUtsDot3OnuLpBkPacketNum(new Integer(tfUtsDot3Onu2LpBkPacketNum.getValue()));
    mbean.setUtsDot3OnuLpBkMode(new Integer(utsDot3Onu2LpBkModeVList[tfUtsDot3Onu2LpBkMode.getSelectedIndex()]));
    mbean.setUtsDot3OnuLpBkStart(new Integer(utsDot3Onu2LpBkStartVList[tfUtsDot3Onu2LpBkStart.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}

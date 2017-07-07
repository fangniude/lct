/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2QosGlbTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Olt2QosGlbTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Olt2QosGlbTablePanel extends UPanel {

  private JLabel tfUtsDot3OltModuleId = new JLabel();

//  private JLabel tfUtsDot3OltDeviceId = new JLabel();

  private int[] utsDot3OltQoSModeVList = new int[]{
    1, 2, };
  private String[] utsDot3OltQoSModeTList = new String[]{
    fStringMap.getString("modeDscp"),
    fStringMap.getString("mode8021p"),
  };
  private JComboBox tfUtsDot3OltQoSMode = new JComboBox(utsDot3OltQoSModeTList);
  private int[] utsDot3OltQoSL2OverheadIncludeVList = new int[]{
    1, 2, };
  private String[] utsDot3OltQoSL2OverheadIncludeTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OltQoSL2OverheadInclude = new JComboBox(utsDot3OltQoSL2OverheadIncludeTList);
  private int[] utsDot3OltWREDEnableVList = new int[]{
    1, 2, };
  private String[] utsDot3OltWREDEnableTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OltWREDEnable = new JComboBox(utsDot3OltWREDEnableTList);
  private int[] utsDot3OltSchedulingModeVList = new int[]{ 1, 2, 3 };
  private String[] utsDot3OltSchedulingModeTList = new String[]{
    fStringMap.getString("sp"),
    fStringMap.getString("wrr"),
    fStringMap.getString("hierarchical"),
  };
  private JComboBox tfUtsDot3OltSchedulingMode = new JComboBox(utsDot3OltSchedulingModeTList);

  //value: 1 - 16
  private String[] utsDot3OltSchedulingWeightVList = null;
  private JComboBox[] tfUtsDot3OltSchedulingWeight = null;

  //value: 0 - 7
  private String[] utsDot3OltQueueMapVList = null;
  private JComboBox[] tfUtsDot3OltDot1p2QueueMap = null;

  //value: 0 - 7
  private JComboBox[] tfUtsDot3OltDscp2QueueMap = null;

  // utsDot3OltTxDot1pRemark, value: 0-7
  private JComboBox[] tfUtsDot3OltTxDot1pRemark = null;

  // utsDot3OltTxDscpRemark, value: 0-63
  private String[] utsDot3OltTxDscpRemarkVList = null;
  private JComboBox[] tfUtsDot3OltTxDscpRemark = null;

  private IntegerTextField tfUtsDot3OltDefaultTx802Dot1pValue = new IntegerTextField();

  private JComboBox tfUtsDot3OltDefaultCosQueue = new JComboBox();


  private final String utsDot3OltModuleId3 = fStringMap.getString("utsDot3OltModuleId") + " : ";
//  private final String utsDot3OltDeviceId3 = fStringMap.getString("utsDot3OltDeviceId") + " : ";
  private final String utsDot3OltQoSMode = fStringMap.getString("utsDot3OltQoSMode") + " : ";
  private final String utsDot3OltQoSL2OverheadInclude = fStringMap.getString("utsDot3OltQoSL2OverheadInclude") + " : ";
  private final String utsDot3OltWREDEnable = fStringMap.getString("utsDot3OltWREDEnable") + " : ";
  private final String utsDot3OltSchedulingMode = fStringMap.getString("utsDot3OltSchedulingMode") + " : ";
  private final String utsDot3OltSchedulingWeight = fStringMap.getString("utsDot3OltSchedulingWeight") + " : ";
  private final String utsDot3OltDot1p2QueueMap = fStringMap.getString("utsDot3OltDot1p2QueueMap") + " : ";
  private final String utsDot3OltDscp2QueueMap = fStringMap.getString("utsDot3OltDscp2QueueMap") + " : ";
  private final String utsDot3OltTxDot1pRemark = fStringMap.getString("utsDot3OltTxDot1pRemark") + " : ";
  private final String utsDot3OltTxDscpRemark = fStringMap.getString("utsDot3OltTxDscpRemark") + " : ";
  private final String utsDot3OltDefaultTx802Dot1pValue = fStringMap.getString("utsDot3OltDefaultTx802Dot1pValue") + " : ";
  private final String utsDot3OltDefaultCosQueue = fStringMap.getString("utsDot3OltDefaultCosQueue") + " : ";


  public Dot3Olt2QosGlbTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);

    baseInfoPanel.add(new JLabel(utsDot3OltModuleId3));
    baseInfoPanel.add(tfUtsDot3OltModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OltDeviceId3));
//    baseInfoPanel.add(tfUtsDot3OltDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltQoSMode));
    tfUtsDot3OltQoSMode.setName(fStringMap.getString("utsDot3OltQoSMode"));
    baseInfoPanel.add(tfUtsDot3OltQoSMode);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltQoSL2OverheadInclude));
    tfUtsDot3OltQoSL2OverheadInclude.setName(fStringMap.getString("utsDot3OltQoSL2OverheadInclude"));
    baseInfoPanel.add(tfUtsDot3OltQoSL2OverheadInclude);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltWREDEnable));
    tfUtsDot3OltWREDEnable.setName(fStringMap.getString("utsDot3OltWREDEnable"));
    baseInfoPanel.add(tfUtsDot3OltWREDEnable);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltSchedulingMode));
    tfUtsDot3OltSchedulingMode.setName(fStringMap.getString("utsDot3OltSchedulingMode"));
    baseInfoPanel.add(tfUtsDot3OltSchedulingMode);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsDot3OltDefaultTx802Dot1pValue));
    tfUtsDot3OltDefaultTx802Dot1pValue.setName(fStringMap.getString("utsDot3OltDefaultTx802Dot1pValue"));
    baseInfoPanel.add(tfUtsDot3OltDefaultTx802Dot1pValue);
    baseInfoPanel.add(new HSpacer());

    for(int i = 0; i < 8; i++)
    {
      tfUtsDot3OltDefaultCosQueue.addItem("" + i);
    }
    baseInfoPanel.add(new JLabel(utsDot3OltDefaultCosQueue));
    tfUtsDot3OltDefaultCosQueue.setName(fStringMap.getString("utsDot3OltDefaultCosQueue"));
    baseInfoPanel.add(tfUtsDot3OltDefaultCosQueue);
    baseInfoPanel.add(new HSpacer());

    //scheduling weight
    JPanel weightPanel = new JPanel();
    NTLayout layout2 = new NTLayout(2, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout2.setMargins(6, 10, 6, 10);
    weightPanel.setLayout(layout2);
    weightPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(utsDot3OltSchedulingWeight)));

    utsDot3OltSchedulingWeightVList = new String[255];
    for(int i = 0; i < utsDot3OltSchedulingWeightVList.length; i++)
    {
      utsDot3OltSchedulingWeightVList[i] = "" + (i + 1);
    }

    tfUtsDot3OltSchedulingWeight = new JComboBox[8];
    for(int i = 0; i < tfUtsDot3OltSchedulingWeight.length; i++)
    {
      tfUtsDot3OltSchedulingWeight[i] = new JComboBox(utsDot3OltSchedulingWeightVList);

      weightPanel.add(new JLabel(fStringMap.getString("utsDot3OltSchedulingWeightQueue") + (i)));
      weightPanel.add(tfUtsDot3OltSchedulingWeight[i]);
    }

    //802.1p2 Queue Map Panel
    JPanel dot1p2QueueMapPanel = new JPanel();
    NTLayout layout3 = new NTLayout(2, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout3.setMargins(6, 10, 6, 10);
    dot1p2QueueMapPanel.setLayout(layout3);
    dot1p2QueueMapPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(utsDot3OltDot1p2QueueMap)));

    utsDot3OltQueueMapVList = new String[8];
    for(int i = 0; i < utsDot3OltQueueMapVList.length; i++)
    {
      utsDot3OltQueueMapVList[i] = "" + i;
    }

    tfUtsDot3OltDot1p2QueueMap = new JComboBox[8];
    for(int i = 0; i < tfUtsDot3OltDot1p2QueueMap.length; i++)
    {
      tfUtsDot3OltDot1p2QueueMap[i] = new JComboBox(utsDot3OltQueueMapVList);

      dot1p2QueueMapPanel.add(new JLabel(fStringMap.getString("utsDot3OltDot1p2QueueMapQueue") + i));
      dot1p2QueueMapPanel.add(tfUtsDot3OltDot1p2QueueMap[i]);
    }

    //Dscp Queue Map Panel
    JPanel dscp2QueueMapPanel = new JPanel();
    NTLayout layout4 = new NTLayout(2, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout4.setMargins(6, 10, 6, 10);
    dscp2QueueMapPanel.setLayout(layout4);
    dscp2QueueMapPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(utsDot3OltDscp2QueueMap)));

    tfUtsDot3OltDscp2QueueMap = new JComboBox[8];
    for(int i = 0; i < tfUtsDot3OltDscp2QueueMap.length; i++)
    {
      tfUtsDot3OltDscp2QueueMap[i] = new JComboBox(utsDot3OltQueueMapVList);

      dscp2QueueMapPanel.add(new JLabel(fStringMap.getString("utsDot3OltDot1p2QueueMapQueue") + i));
      dscp2QueueMapPanel.add(tfUtsDot3OltDscp2QueueMap[i]);
    }

    //802.1p Remark Mapping
    JPanel txDot1pRemarkPanel = new JPanel();
    NTLayout layout5 = new NTLayout(2, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout5.setMargins(6, 10, 6, 10);
    txDot1pRemarkPanel.setLayout(layout5);
    txDot1pRemarkPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(utsDot3OltTxDot1pRemark)));

    tfUtsDot3OltTxDot1pRemark = new JComboBox[8];
    for(int i = 0; i < tfUtsDot3OltTxDot1pRemark.length; i++)
    {
    	tfUtsDot3OltTxDot1pRemark[i] = new JComboBox(utsDot3OltQueueMapVList);

    	txDot1pRemarkPanel.add(new JLabel(fStringMap.getString("utsDot3OltTxxxxxRemark") + i));
    	txDot1pRemarkPanel.add(tfUtsDot3OltTxDot1pRemark[i]);
    }

    //DSCP Remark Mapping
    JPanel txDscpRemarkPanel = new JPanel();
    NTLayout layout6 = new NTLayout(16, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout6.setMargins(6, 10, 6, 10);
    txDscpRemarkPanel.setLayout(layout6);
    txDscpRemarkPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(utsDot3OltTxDscpRemark)));

    utsDot3OltTxDscpRemarkVList = new String[64];
    for(int i = 0; i < utsDot3OltTxDscpRemarkVList.length; i++)
    {
    	utsDot3OltTxDscpRemarkVList[i] = "" + i;
    }

    tfUtsDot3OltTxDscpRemark = new JComboBox[64];
    for(int i = 0; i < tfUtsDot3OltTxDscpRemark.length; i++)
    {
    	tfUtsDot3OltTxDscpRemark[i] = new JComboBox(utsDot3OltTxDscpRemarkVList);

    	txDscpRemarkPanel.add(new JLabel(fStringMap.getString("utsDot3OltTxxxxxRemark") + i));
    	txDscpRemarkPanel.add(tfUtsDot3OltTxDscpRemark[i]);
    }

    JPanel allPanel = new JPanel();
    layout = new NTLayout(6, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setBorder(BorderFactory.createEtchedBorder());
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(weightPanel);
    allPanel.add(dot1p2QueueMapPanel);
    allPanel.add(dscp2QueueMapPanel);
    allPanel.add(txDot1pRemarkPanel);
    allPanel.add(txDscpRemarkPanel);
    setLayout(new BorderLayout());
    add( new JScrollPane(allPanel), BorderLayout.CENTER);

    setPreferredSize(new Dimension(500, 550));
  }

  protected void initForm() {
    tfUtsDot3OltDefaultTx802Dot1pValue.setValueScope(0, 255);
  }

  public void refresh() {

    Dot3Olt2QosGlbTable mbean = (Dot3Olt2QosGlbTable) getModel();

    tfUtsDot3OltModuleId.setText(mbean.getUtsDot3OltModuleId().toString());
//    tfUtsDot3OltDeviceId.setText(mbean.getUtsDot3OltDeviceId().toString());
    tfUtsDot3OltQoSMode.setSelectedIndex(getIndexFromValue(utsDot3OltQoSModeVList, mbean.getUtsDot3OltQoSMode().intValue()));
    tfUtsDot3OltQoSL2OverheadInclude.setSelectedIndex(getIndexFromValue(utsDot3OltQoSL2OverheadIncludeVList, mbean.getUtsDot3OltQoSL2OverheadInclude().intValue()));
    tfUtsDot3OltWREDEnable.setSelectedIndex(getIndexFromValue(utsDot3OltWREDEnableVList, mbean.getUtsDot3OltWREDEnable().intValue()));
    tfUtsDot3OltSchedulingMode.setSelectedIndex(getIndexFromValue(utsDot3OltSchedulingModeVList, mbean.getUtsDot3OltSchedulingMode().intValue()));
    setSchedulingWeight(mbean.getUtsDot3OltSchedulingWeight());
    setDot1p2QueueMap(mbean.getUtsDot3OltDot1p2QueueMap());
    setTxDot1pRemark(mbean.getUtsDot3OltTxDot1pRemark());
    setTxDscpRemark(mbean.getUtsDot3OltTxDscpRemark());
    setDscp2QueueMap(mbean.getUtsDot3OltDscp2QueueMap());
    tfUtsDot3OltDefaultTx802Dot1pValue.setValue(mbean.getUtsDot3OltDefaultTx802Dot1pValue().intValue());
    tfUtsDot3OltDefaultCosQueue.setSelectedItem("" + mbean.getUtsDot3OltDefaultCosQueue().intValue());
  }

  public void updateModel() {

    Dot3Olt2QosGlbTable mbean = (Dot3Olt2QosGlbTable) getModel();

    mbean.setUtsDot3OltQoSMode(new Integer(utsDot3OltQoSModeVList[tfUtsDot3OltQoSMode.getSelectedIndex()]));
    mbean.setUtsDot3OltQoSL2OverheadInclude(new Integer(utsDot3OltQoSL2OverheadIncludeVList[tfUtsDot3OltQoSL2OverheadInclude.getSelectedIndex()]));
    mbean.setUtsDot3OltWREDEnable(new Integer(utsDot3OltWREDEnableVList[tfUtsDot3OltWREDEnable.getSelectedIndex()]));
    mbean.setUtsDot3OltSchedulingMode(new Integer(utsDot3OltSchedulingModeVList[tfUtsDot3OltSchedulingMode.getSelectedIndex()]));
    mbean.setUtsDot3OltSchedulingWeight(getSchedulingWeight());
    mbean.setUtsDot3OltDot1p2QueueMap(getDot1p2QueueMap());
    mbean.setUtsDot3OltTxDot1pRemark(getTxDot1pRemark());
    mbean.setUtsDot3OltTxDscpRemark(getTxDscpRemark());
    mbean.setUtsDot3OltDscp2QueueMap(getDscp2QueueMap());
    mbean.setUtsDot3OltDefaultTx802Dot1pValue(new Integer(tfUtsDot3OltDefaultTx802Dot1pValue.getValue()));
    mbean.setUtsDot3OltDefaultCosQueue(new Integer((String)tfUtsDot3OltDefaultCosQueue.getSelectedItem()));
  }

  private void setSchedulingWeight(byte[] weight)
  {
    setBitMap(tfUtsDot3OltSchedulingWeight, weight);
  }

  private byte[] getSchedulingWeight()
  {
    return getBitMap(tfUtsDot3OltSchedulingWeight);
  }

  private void setDot1p2QueueMap(byte[] queueMap)
  {
    setBitMap(tfUtsDot3OltDot1p2QueueMap, queueMap);
  }

  private byte[] getDot1p2QueueMap()
  {
    return getBitMap(tfUtsDot3OltDot1p2QueueMap);
  }

  private void setTxDot1pRemark(byte[] dot1Remark)
  {
    setBitMap(tfUtsDot3OltTxDot1pRemark, dot1Remark);
  }

  private byte[] getTxDot1pRemark()
  {
    return getBitMap(tfUtsDot3OltTxDot1pRemark);
  }

  private void setTxDscpRemark(byte[] dscpRemark)
  {
    setBitMap(tfUtsDot3OltTxDscpRemark, dscpRemark);
  }

  private byte[] getTxDscpRemark()
  {
    return getBitMap(tfUtsDot3OltTxDscpRemark);
  }

  private void setDscp2QueueMap(byte[] queueMap)
  {
    setBitMap(tfUtsDot3OltDscp2QueueMap, queueMap);
  }

  private byte[] getDscp2QueueMap()
  {
    return getBitMap(tfUtsDot3OltDscp2QueueMap);
  }

  private void setBitMap(JComboBox[] boxes, byte[] mibValue)
  {
    for(int i = 0; i < mibValue.length; i++)
    {
      boxes[i].setSelectedItem(String.valueOf(mibValue[i] & 255));
    }
  }

  private byte[] getBitMap(JComboBox[] boxes)
  {
    byte[] b = new byte[boxes.length];

    for(int i = 0; i < boxes.length; i++)
    {
      b[i] = (byte)Integer.parseInt((String)boxes[i].getSelectedItem());
    }

    return b;
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}

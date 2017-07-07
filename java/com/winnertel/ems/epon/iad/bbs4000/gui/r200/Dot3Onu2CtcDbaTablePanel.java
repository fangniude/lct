/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.Dot3Onu2DbaQueuePanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcDbaTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Dot3Onu2CtcDbaTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2CtcDbaTablePanel extends UPanel implements ActionListener {

  private JLabel tfUtsDot3OnuModuleId = new JLabel();

//  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

  private JLabel tfUtsDot3OnuPortId = new JLabel();

  private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

  private JComboBox tfUtsDot3Onu2DbaQueueSetNum = new JComboBox();

  JTabbedPane tabbedPane = new JTabbedPane();
  private Dot3Onu2DbaQueuePanel[] queuePanelList = new Dot3Onu2DbaQueuePanel[4];

  private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
//  private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3Onu2DbaQueueSetNum = fStringMap.getString("utsDot3Onu2DbaQueueSetNum") + " : ";

  public Dot3Onu2CtcDbaTablePanel(IApplication app) {
    super(app);
    setModel(new Dot3Onu2CtcDbaTable(app.getSnmpProxy()));
    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

    for(int i = 2; i <=4; i++)
    {
      tfUtsDot3Onu2DbaQueueSetNum.addItem(i);
    }
    tfUtsDot3Onu2DbaQueueSetNum.addActionListener(this);

    baseInfoPanel.add(new JLabel(utsDot3Onu2DbaQueueSetNum));
    tfUtsDot3Onu2DbaQueueSetNum.setName(fStringMap.getString("utsDot3Onu2DbaQueueSetNum"));
    baseInfoPanel.add(tfUtsDot3Onu2DbaQueueSetNum);
    baseInfoPanel.add(new HSpacer());

    for(int i = 0; i < queuePanelList.length; i++)
    {
      queuePanelList[i] = new Dot3Onu2DbaQueuePanel(fApplication, fStringMap.getString("Queue_Bit_Map_Panel") + (i + 1));
      tabbedPane.addTab(fStringMap.getString("Dba_BitMap") + (i+1), queuePanelList[i]);
    }

    JPanel allPanel = new JPanel();
    layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(tabbedPane);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);
  }

  protected void initForm() {
  }

  public void refresh() {

    Dot3Onu2CtcDbaTable mbean = (Dot3Onu2CtcDbaTable) getModel();

    tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
//    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
    tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
    tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
    tfUtsDot3Onu2DbaQueueSetNum.setSelectedItem(mbean.getUtsDot3Onu2DbaQueueSetNum());
    queuePanelList[0].setQueueThreshold(mbean.getUtsDot3Onu2DbaQueueSetThreshold1());

    if(mbean.getUtsDot3Onu2DbaQueueSetThreshold2() != null)
      queuePanelList[1].setQueueThreshold(mbean.getUtsDot3Onu2DbaQueueSetThreshold2());

    if(mbean.getUtsDot3Onu2DbaQueueSetThreshold3() != null)
      queuePanelList[2].setQueueThreshold(mbean.getUtsDot3Onu2DbaQueueSetThreshold3());

    if(mbean.getUtsDot3Onu2DbaQueueSetThreshold4() != null)
      queuePanelList[3].setQueueThreshold(mbean.getUtsDot3Onu2DbaQueueSetThreshold4());
  }

  public void updateModel() {

    Dot3Onu2CtcDbaTable mbean = (Dot3Onu2CtcDbaTable) getModel();

    mbean.setUtsDot3Onu2DbaQueueSetNum((Integer)tfUtsDot3Onu2DbaQueueSetNum.getSelectedItem());
    mbean.setUtsDot3Onu2DbaQueueBitmap1(queuePanelList[0].getQueueBitmap());
    mbean.setUtsDot3Onu2DbaQueueSetThreshold1(queuePanelList[0].getQueueThreshold());

    if(tabbedPane.isEnabledAt(1)) {
      mbean.setUtsDot3Onu2DbaQueueBitmap2(queuePanelList[1].getQueueBitmap());
      mbean.setUtsDot3Onu2DbaQueueSetThreshold2(queuePanelList[1].getQueueThreshold());
    }

    if (tabbedPane.isEnabledAt(2)){
        mbean.setUtsDot3Onu2DbaQueueBitmap3(queuePanelList[2].getQueueBitmap());
        mbean.setUtsDot3Onu2DbaQueueSetThreshold3(queuePanelList[2].getQueueThreshold());
    }
    if (tabbedPane.isEnabledAt(3)){
        mbean.setUtsDot3Onu2DbaQueueBitmap4(queuePanelList[3].getQueueBitmap());
        mbean.setUtsDot3Onu2DbaQueueSetThreshold4(queuePanelList[3].getQueueThreshold());
    }
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

  public void actionPerformed(ActionEvent e) {
    int count = (Integer)tfUtsDot3Onu2DbaQueueSetNum.getSelectedItem();

    for(int i = 0; i < count; i++)
    {
      tabbedPane.setEnabledAt(i, true);
    }

    for(int i = count; i < queuePanelList.length; i++)
    {
      tabbedPane.setEnabledAt(i, false);
    }
  }

}
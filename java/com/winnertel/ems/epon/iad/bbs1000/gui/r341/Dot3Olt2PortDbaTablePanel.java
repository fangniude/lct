/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs1000.gui.r341;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2PortDbaTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Olt2PortDbaTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Olt2PortDbaTablePanel extends UPanel {

  private JLabel tfUtsDot3OltPortDbaModuleId = new JLabel();

//  private JLabel tfUtsDot3OltPortDbaDeviceId = new JLabel();

  private JLabel tfUtsDot3OltPortDbaPortId = new JLabel();

  private IntegerTextField tfUtsDot3OltPortDbaCycleSize = new IntegerTextField();

  private IntegerTextField tfUtsDot3OltPortDbaDiscoveryFreq = new IntegerTextField();

  private IntegerTextField tfUtsDot3OltPortDbaDiscoverySize = new IntegerTextField();

  private final String utsDot3OltPortDbaModuleId = fStringMap.getString("utsDot3OltPortDbaModuleId") + " : ";
//  private final String utsDot3OltPortDbaDeviceId = fStringMap.getString("utsDot3OltPortDbaDeviceId") + " : ";
  private final String utsDot3OltPortDbaPortId = fStringMap.getString("utsDot3OltPortDbaPortId") + " : ";
  private final String utsDot3OltPortDbaCycleSize = fStringMap.getString("utsDot3OltPortDbaCycleSize") + " : ";
  private final String utsDot3OltPortDbaDiscoveryFreq = fStringMap.getString("utsDot3OltPortDbaDiscoveryFreq") + " : ";
  private final String utsDot3OltPortDbaDiscoverySize = fStringMap.getString("utsDot3OltPortDbaDiscoverySize") + " : ";


  public Dot3Olt2PortDbaTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OltPortDbaModuleId));
    baseInfoPanel.add(tfUtsDot3OltPortDbaModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OltPortDbaDeviceId));
//    baseInfoPanel.add(tfUtsDot3OltPortDbaDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltPortDbaPortId));
    baseInfoPanel.add(tfUtsDot3OltPortDbaPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltPortDbaCycleSize));
    tfUtsDot3OltPortDbaCycleSize.setName(fStringMap.getString("utsDot3OltPortDbaCycleSize"));
    baseInfoPanel.add(tfUtsDot3OltPortDbaCycleSize);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltPortDbaDiscoveryFreq));
    tfUtsDot3OltPortDbaDiscoveryFreq.setName(fStringMap.getString("utsDot3OltPortDbaDiscoveryFreq"));
    baseInfoPanel.add(tfUtsDot3OltPortDbaDiscoveryFreq);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OltPortDbaDiscoverySize));
    tfUtsDot3OltPortDbaDiscoverySize.setName(fStringMap.getString("utsDot3OltPortDbaDiscoverySize"));
    baseInfoPanel.add(tfUtsDot3OltPortDbaDiscoverySize);
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
    tfUtsDot3OltPortDbaCycleSize.setValueScope(6250, 145000);
    tfUtsDot3OltPortDbaDiscoveryFreq.setValueScope(100, 60000);
    tfUtsDot3OltPortDbaDiscoverySize.setValueScope(200, 10240);
  }

  public void refresh() {

    Dot3Olt2PortDbaTable mbean = (Dot3Olt2PortDbaTable) getModel();

    tfUtsDot3OltPortDbaModuleId.setText(mbean.getUtsDot3OltPortDbaModuleId().toString());
//    tfUtsDot3OltPortDbaDeviceId.setText(mbean.getUtsDot3OltPortDbaDeviceId().toString());
    tfUtsDot3OltPortDbaPortId.setText(mbean.getUtsDot3OltPortDbaPortId().toString());
    tfUtsDot3OltPortDbaCycleSize.setValue(mbean.getUtsDot3OltPortDbaCycleSize().intValue());
    tfUtsDot3OltPortDbaDiscoveryFreq.setValue(mbean.getUtsDot3OltPortDbaDiscoveryFreq().intValue());
    tfUtsDot3OltPortDbaDiscoverySize.setValue(mbean.getUtsDot3OltPortDbaDiscoverySize().intValue());

  }

  public void updateModel() {

    Dot3Olt2PortDbaTable mbean = (Dot3Olt2PortDbaTable) getModel();


    mbean.setUtsDot3OltPortDbaCycleSize(new Integer(tfUtsDot3OltPortDbaCycleSize.getValue()));
    mbean.setUtsDot3OltPortDbaDiscoveryFreq(new Integer(tfUtsDot3OltPortDbaDiscoveryFreq.getValue()));
    mbean.setUtsDot3OltPortDbaDiscoverySize(new Integer(tfUtsDot3OltPortDbaDiscoverySize.getValue()));
  }

  public void afterUpdateModel() {
    MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Info_Take_Effect_After_Register"));
  }
  
  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}

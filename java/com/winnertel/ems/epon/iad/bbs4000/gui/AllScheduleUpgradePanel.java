package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class AllScheduleUpgradePanel extends UPanel{

  private SnmpTablePane SUpgradePanel ;
  private SnmpTablePane SUpgradeResultPanel ;
  public AllScheduleUpgradePanel(IApplication app) {
    super(app);
    init();
  }

  @Override
  protected void initGui() {
    // TODO Auto-generated method stub
    JPanel allPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    allPanel.setLayout(layout);
    IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
    SUpgradePanel = (SnmpTablePane) composer1.composeSnmpTablePane("Schedule_Upgrade");
    SUpgradePanel.setPreferredSize(new Dimension(100, 200));
    SUpgradePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Schedule_Upgrade")));
    IGuiComposer composer2 = fApplication.getActiveDeviceManager().getGuiComposer();
    SUpgradeResultPanel = (SnmpTablePane) composer2.composeSnmpTablePane("Schedule_Upgrade_Result");
    SUpgradeResultPanel.setPreferredSize(new Dimension(100, 200));
    SUpgradeResultPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Schedule_Upgrade_Result")));
    allPanel.add(SUpgradePanel);
    allPanel.add(SUpgradeResultPanel);
    
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);
    
    SUpgradePanel.refresh();
    SUpgradeResultPanel.refresh();
  }

  @Override
  public void refresh() {
    // TODO Auto-generated method stub
    
  }

}

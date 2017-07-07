package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.ChassisConfGroup;

import javax.swing.*;
import java.awt.*;

/**
 * The ChassisConfTablePanel class.
 * Created by DVM Creator
 */
public class ChassisConfGroupPanel extends UPanel
{
  private IntegerTextField tfUtsBBSChassisTempUpLimit = new IntegerTextField();

  private final String utsBBSChassisTempUpLimit = fStringMap.getString("utsBBSChassisTempUpLimit") + " : ";

  public ChassisConfGroupPanel(IApplication app)
  {
    super(app);
    setModel(new ChassisConfGroup(app.getSnmpProxy()));
    init();
  }

  public void initGui()
  {
    JPanel buttonsPanel = new JPanel();
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsBBSChassisTempUpLimit));
    tfUtsBBSChassisTempUpLimit.setName(fStringMap.getString("utsBBSChassisTempUpLimit"));
    baseInfoPanel.add(tfUtsBBSChassisTempUpLimit);
    baseInfoPanel.add(new HSpacer());

    JPanel allPanel = new JPanel();
    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.SOUTH);
  }

  protected void initForm()
  {
    tfUtsBBSChassisTempUpLimit.setValueScope(0, 75);
  }

  public void refresh()
  {
    ChassisConfGroup mbean = (ChassisConfGroup)getModel();
    BeanService.refreshBean(fApplication, mbean);
    tfUtsBBSChassisTempUpLimit.setValue(mbean.getUtsBBSChassisTempUpLimit().intValue());
  }

  public void updateModel()
  {
    ChassisConfGroup mbean = (ChassisConfGroup)getModel();
    mbean.setUtsBBSChassisTempUpLimit(new Integer(tfUtsBBSChassisTempUpLimit.getValue()));
  }
}

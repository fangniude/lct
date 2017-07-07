package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class OltBasePanel extends UPanel {
  private final DvmStringMap stringMap;
  private IGuiComposer composer;

  public OltBasePanel(IApplication app) {
    super(app);
    this.fApplication = app;
    composer = fApplication.getActiveDeviceManager().getGuiComposer();
    stringMap = new DvmStringMap(composer);
    initGui();
  }

  public void initGui() {
    JTabbedPane jTabbedPane = new JTabbedPane();


    SnmpTablePane vlanPanel = (SnmpTablePane) composer.composeSnmpTablePane("PortBasedVLAN_Panel");
    jTabbedPane.addTab(stringMap.getString("VLAN_Config"), vlanPanel);
    SnmpTablePane qinqPanel = (SnmpTablePane) composer.composeSnmpTablePane("OltSelectiveQinQ_Panel");
    jTabbedPane.addTab(stringMap.getString("QinQ_Config"), qinqPanel);

    this.setLayout(new BorderLayout());
    this.add(jTabbedPane, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.add(new JButton(stringMap.getString("Import")));
    buttonPanel.add(new JButton(stringMap.getString("Save_As")));
    buttonPanel.add(new JButton(stringMap.getString("Apply")));
    this.add(buttonPanel, BorderLayout.SOUTH);
  }

  @Override
  public void refresh() {
  }

}
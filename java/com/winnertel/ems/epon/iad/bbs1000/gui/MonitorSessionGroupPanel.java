/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.ems.epon.iad.bbs1000.gui.swing.BBS1000PortSelectionPanel;
import com.winnertel.ems.epon.iad.bbs1000.mib.MonitorSessionGroup;
import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The MonitorSessionGroupPanel class.
 * Created by DVM Creator
 */
public class MonitorSessionGroupPanel extends UPanel implements ActionListener {

  //private JComboBox tfUtsMonitorSessionModule = new JComboBox(new String[]{fStringMap.getString("disable"), "1", "2", "3"});
  private JComboBox tfUtsMonitorSessionModule = new JComboBox(new String[]{fStringMap.getString("disable"), "3"}); //(for NMS00064273) modified by Zhou Chao, 2009/1/6

  private String[] portList = new String[]{"1", "2", "3", "4"};
  private JComboBox tfUtsMonitorSessionPort = new JComboBox();

  private BBS1000PortSelectionPanel tfIngressPortPanel = new BBS1000PortSelectionPanel(fApplication);

  private BBS1000PortSelectionPanel tfEgressPortPanel = new BBS1000PortSelectionPanel(fApplication);

  private final String utsMonitorSessionModule = fStringMap.getString("utsMonitorSessionModule") + " : ";
  private final String utsMonitorSessionPort = fStringMap.getString("utsMonitorSessionPort") + " : ";
  private final String utsMonitorSessionIngressPortBitLists = fStringMap.getString("utsMonitorSessionIngressPortBitLists") + " : ";
  private final String utsMonitorSessionEngressPortBitLists = fStringMap.getString("utsMonitorSessionEngressPortBitLists") + " : ";

  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;

  public MonitorSessionGroupPanel(IApplication app) {
    super(app);
    setModel(new MonitorSessionGroup(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_MonitorSessionGroup");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    tfUtsMonitorSessionModule.addActionListener(this);
    baseInfoPanel.add(new JLabel(utsMonitorSessionModule));
    baseInfoPanel.add(tfUtsMonitorSessionModule);
    baseInfoPanel.add(new HSpacer());

    tfUtsMonitorSessionPort.addItem(fStringMap.getString("disable"));
    tfUtsMonitorSessionPort.setEnabled(false);
    baseInfoPanel.add(new JLabel(utsMonitorSessionPort));
    baseInfoPanel.add(tfUtsMonitorSessionPort);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsMonitorSessionIngressPortBitLists));
    baseInfoPanel.add(tfIngressPortPanel);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsMonitorSessionEngressPortBitLists));
    baseInfoPanel.add(tfEgressPortPanel);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new VSpacer());
    baseInfoPanel.add(new VSpacer());
    baseInfoPanel.add(new VSpacer());

    setLayout(new BorderLayout());
    add(baseInfoPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.SOUTH);
  }

  protected void initForm() {
  }

  public void refresh() {
    MonitorSessionGroup mbean = (MonitorSessionGroup) getModel();
    BeanService.refreshBean(fApplication, mbean);

    if(mbean.getUtsMonitorSessionModule() == null || mbean.getUtsMonitorSessionModule() == 0)
    {
      tfUtsMonitorSessionModule.setSelectedIndex(0);
    }
    else
    {
      tfUtsMonitorSessionModule.setSelectedItem("" + mbean.getUtsMonitorSessionModule());
      tfUtsMonitorSessionPort.setSelectedItem("" + mbean.getUtsMonitorSessionPort());
    }
    tfIngressPortPanel.setSelectedPorts(ConfigUtility.portMappingToStringArray(mbean.getUtsMonitorSessionIngressPortBitLists()));
    tfEgressPortPanel.setSelectedPorts(ConfigUtility.portMappingToStringArray(mbean.getUtsMonitorSessionEngressPortBitLists()));
  }

  public boolean validateFrom() {
    if(tfUtsMonitorSessionModule.getSelectedIndex() != 0)
    {
      String des = tfUtsMonitorSessionModule.getSelectedItem() + "/" + tfUtsMonitorSessionPort.getSelectedItem();

      String[] ingress = tfIngressPortPanel.getSelectedPorts();
      if(ingress != null)
      {
        for(int i = 0; i < ingress.length; i++)
        {
          if(des.equals(ingress[i]))
          {
            String error = fStringMap.getString("Err_Ingress_Port_List_Contain_Assigned_Port");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
          }
        }
      }

      String[] egress = tfEgressPortPanel.getSelectedPorts();
      if(egress != null)
      {
        for(int i = 0; i < egress.length; i++)
        {
          if(des.equals(egress[i]))
          {
            String error = fStringMap.getString("Err_Egress_Port_List_Contain_Assigned_Port");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
          }
        }
      }
    }

    return true;
  }

  public void updateModel() {
    MonitorSessionGroup mbean = (MonitorSessionGroup) getModel();

    if(tfUtsMonitorSessionModule.getSelectedIndex() != 0)
    {
      mbean.setUtsMonitorSessionModule(new Integer((String)tfUtsMonitorSessionModule.getSelectedItem()));
      mbean.setUtsMonitorSessionPort(new Integer((String)tfUtsMonitorSessionPort.getSelectedItem()));
    }

    if(tfIngressPortPanel.isEnabled())
    {
      mbean.setUtsMonitorSessionIngressPortBitLists(ConfigUtility.StringArrayToPortMapping(tfIngressPortPanel.getSelectedPorts()));
    }
    else
    {
      mbean.setUtsMonitorSessionIngressPortBitLists(new byte[8]);
    }

    if(tfEgressPortPanel.isEnabled())
    {
      mbean.setUtsMonitorSessionEngressPortBitLists(ConfigUtility.StringArrayToPortMapping(tfEgressPortPanel.getSelectedPorts()));
    }
    else
    {
      mbean.setUtsMonitorSessionEngressPortBitLists(new byte[8]);
    }
  }

  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    System.out.println("Action Command: " + command);

    if("comboBoxChanged".equals(command))
    {
      if(tfUtsMonitorSessionModule.getSelectedIndex() == 0)
      {
        tfUtsMonitorSessionPort.removeAllItems();
        tfUtsMonitorSessionPort.addItem(fStringMap.getString("disable"));
        tfUtsMonitorSessionPort.setEnabled(false);

        tfIngressPortPanel.setEnabled(false);
        tfEgressPortPanel.setEnabled(false);
      }
      else
      {
        tfUtsMonitorSessionPort.removeAllItems();
        for(int i = 0; i < portList.length; i++)
        {
          tfUtsMonitorSessionPort.addItem(portList[i]);
        }
        tfUtsMonitorSessionPort.setEnabled(true);

        tfIngressPortPanel.setEnabled(true);
        tfEgressPortPanel.setEnabled(true);
      }
    }
  }

}
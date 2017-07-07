/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OltGlbMulticastGroupTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The OltGlbMulticastGroupTablePanel class.
 * Created by DVM Creator
 */
public class OltGlbMulticastGroupTablePanel extends UPanel {

  private IntegerTextField tfUtsOltGlbMulticastGroupMVlan = new IntegerTextField();

  private IPAddressField tfUtsOltGlbMulticastGroupIpAddrStart = new IPAddressField(IPAddressField.IPMULTICAST);

  private IPAddressField tfUtsOltGlbMulticastGroupIpAddrEnd = new IPAddressField(IPAddressField.IPMULTICAST);

  private final String utsOltGlbMulticastGroupMVlan = fStringMap.getString("utsOltGlbMulticastGroupMVlan") + " : ";
  private final String utsOltGlbMulticastGroupIpAddrStart = fStringMap.getString("utsOltGlbMulticastGroupIpAddrStart") + " : ";
  private final String utsOltGlbMulticastGroupIpAddrEnd = fStringMap.getString("utsOltGlbMulticastGroupIpAddrEnd") + " : ";

  public OltGlbMulticastGroupTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsOltGlbMulticastGroupMVlan));
    baseInfoPanel.add(tfUtsOltGlbMulticastGroupMVlan);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsOltGlbMulticastGroupIpAddrStart));
    tfUtsOltGlbMulticastGroupIpAddrStart.setName(fStringMap.getString("utsOltGlbMulticastGroupIpAddrStart"));
    baseInfoPanel.add(tfUtsOltGlbMulticastGroupIpAddrStart);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsOltGlbMulticastGroupIpAddrEnd));
    tfUtsOltGlbMulticastGroupIpAddrEnd.setName(fStringMap.getString("utsOltGlbMulticastGroupIpAddrEnd"));
    baseInfoPanel.add(tfUtsOltGlbMulticastGroupIpAddrEnd);
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
    tfUtsOltGlbMulticastGroupMVlan.setValueScope(1, 4094);
    tfUtsOltGlbMulticastGroupIpAddrStart.setValue("224.0.2.0");
    tfUtsOltGlbMulticastGroupIpAddrEnd.setValue("224.0.2.0");
  }

  public void refresh() {
    if (SnmpAction.IType.ADD.equals(fCommand)) return;
    OltGlbMulticastGroupTable mbean = (OltGlbMulticastGroupTable) getModel();

    tfUtsOltGlbMulticastGroupIpAddrStart.setValue(mbean.getUtsOltGlbMulticastGroupIpAddrStart());
    tfUtsOltGlbMulticastGroupIpAddrEnd.setValue(mbean.getUtsOltGlbMulticastGroupIpAddrEnd());
  }

  public boolean validateFrom()
  {
    if(tfUtsOltGlbMulticastGroupIpAddrStart.getIPString().startsWith("224.0.0.") ||
       tfUtsOltGlbMulticastGroupIpAddrStart.getIPString().startsWith("224.0.1."))
    {
      String error = fStringMap.getString("Err_Multicast_Address_Is_Used");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      tfUtsOltGlbMulticastGroupIpAddrStart.requestFocus();
      return false;
    }

    if(tfUtsOltGlbMulticastGroupIpAddrEnd.getIPString().startsWith("224.0.0.") ||
       tfUtsOltGlbMulticastGroupIpAddrEnd.getIPString().startsWith("224.0.1."))
    {
      String error = fStringMap.getString("Err_Multicast_Address_Is_Used");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      tfUtsOltGlbMulticastGroupIpAddrEnd.requestFocus();
      return false;
    }

    OltGlbMulticastGroupTable mbean = new OltGlbMulticastGroupTable(fApplication.getSnmpProxy());
    Vector v = BeanService.refreshTableBean(fApplication, mbean);

    if(v != null)
    {
      for(int i = 0; i < v.size(); i++)
      {
        OltGlbMulticastGroupTable one = (OltGlbMulticastGroupTable)v.get(i);
        if(one.getUtsOltGlbMulticastGroupMVlan().intValue() == tfUtsOltGlbMulticastGroupMVlan.getValue())
        {
          String error = fStringMap.getString("Err_MVlan_Is_Used");
          MessageDialog.showErrorMessageDialog(fApplication, error);
          return false;
        }
      }
    }
    return true;
  }
  public void updateModel() {

    if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new OltGlbMulticastGroupTable(fApplication.getSnmpProxy()));

    OltGlbMulticastGroupTable mbean = (OltGlbMulticastGroupTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsOltGlbMulticastGroupMVlan(new Integer(tfUtsOltGlbMulticastGroupMVlan.getValue()));
    }

    mbean.setUtsOltGlbMulticastGroupIpAddrStart(tfUtsOltGlbMulticastGroupIpAddrStart.getIPString());
    mbean.setUtsOltGlbMulticastGroupIpAddrEnd(tfUtsOltGlbMulticastGroupIpAddrEnd.getIPString());
  }
}

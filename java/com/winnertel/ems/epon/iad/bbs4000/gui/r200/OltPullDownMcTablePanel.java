/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OltPullDownMcTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The OltPullDownMcTablePanel class.
 * Created by DVM Creator
 */
public class OltPullDownMcTablePanel extends UPanel {

  private IPAddressField tfUtsOltPullDownMcGroupIpAddr = new IPAddressField(IPAddressField.IPMULTICAST);

  private IntegerTextField tfUtsOltPullDownMcGroupMVlan = new IntegerTextField();

  private final String utsOltPullDownMcGroupIpAddr = fStringMap.getString("utsOltPullDownMcGroupIpAddr") + " : ";
  private final String utsOltPullDownMcGroupMVlan = fStringMap.getString("utsOltPullDownMcGroupMVlan") + " : ";


  public OltPullDownMcTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsOltPullDownMcGroupIpAddr));
    baseInfoPanel.add(tfUtsOltPullDownMcGroupIpAddr);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsOltPullDownMcGroupMVlan));
    tfUtsOltPullDownMcGroupMVlan.setName(fStringMap.getString("utsOltPullDownMcGroupMVlan"));
    baseInfoPanel.add(tfUtsOltPullDownMcGroupMVlan);
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
    tfUtsOltPullDownMcGroupMVlan.setValueScope(1, 65535);
    tfUtsOltPullDownMcGroupIpAddr.setValue("224.0.2.0");
  }

  public void refresh() {
    if (SnmpAction.IType.ADD.equals(fCommand)) return;
    OltPullDownMcTable mbean = (OltPullDownMcTable) getModel();

    tfUtsOltPullDownMcGroupIpAddr.setValue(mbean.getUtsOltPullDownMcGroupIpAddr());
    tfUtsOltPullDownMcGroupMVlan.setValue(mbean.getUtsOltPullDownMcGroupMVlan().intValue());
  }

  public boolean validateFrom() {
    if(tfUtsOltPullDownMcGroupIpAddr.getIPString().startsWith("224.0.0.") ||
       tfUtsOltPullDownMcGroupIpAddr.getIPString().startsWith("224.0.1."))
    {
      String error = fStringMap.getString("Err_Multicast_Address_Is_Used");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      tfUtsOltPullDownMcGroupIpAddr.requestFocus();
      return false;
    }

    return true;
  }

  public void updateModel() {

    if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new OltPullDownMcTable(fApplication.getSnmpProxy()));

    OltPullDownMcTable mbean = (OltPullDownMcTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsOltPullDownMcGroupIpAddr(tfUtsOltPullDownMcGroupIpAddr.getIPString());
    }

    mbean.setUtsOltPullDownMcGroupMVlan(new Integer(tfUtsOltPullDownMcGroupMVlan.getValue()));
  }
}

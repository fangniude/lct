package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.ems.epon.iad.bbs1000.mib.DHCPGeneral;

import javax.swing.*;
import java.awt.*;

public class DHCPGeneralPanel extends UPanel {

//  private int[] utsDHCPServiceStateVList = new int[]
//      {1, 2, 3,};
//
//  private String[] utsDHCPServiceStateTList = new String[]
//      {fStringMap.getString("no-service"),
//          fStringMap.getString("server-active"),
//          fStringMap.getString("relay-active"),};
//
//  private JComboBox tfUtsDHCPServiceState = new JComboBox(utsDHCPServiceStateTList);

  private int[] utsDHCPServiceModeVList = new int[]
      {1, 2,};

  private String[] utsDHCPServiceModeTList = new String[]
      {fStringMap.getString("rfc2131"), fStringMap.getString("sbb"),};

  private JComboBox tfUtsDHCPServiceMode = new JComboBox(utsDHCPServiceModeTList);

//  private final String utsDHCPServiceState = fStringMap
//      .getString("utsDHCPServiceState")
//      + " : ";

  private final String utsDHCPServiceMode = fStringMap
      .getString("utsDHCPServiceMode")
      + " : ";

  private SnmpApplyButton btApply;

  private SnmpRefreshButton btRefresh;

  public DHCPGeneralPanel(IApplication app) {
    super(app);
    setModel(new DHCPGeneral(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_DHCPServiceState");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5,
        5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

//    baseInfoPanel.add(new JLabel(utsDHCPServiceState));
//    tfUtsDHCPServiceState.setName(fStringMap
//        .getString("utsDHCPServiceState"));
//    baseInfoPanel.add(tfUtsDHCPServiceState);
//    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsDHCPServiceMode));
    tfUtsDHCPServiceMode
        .setName(fStringMap.getString("utsDHCPServiceMode"));
    baseInfoPanel.add(tfUtsDHCPServiceMode);
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

  protected void initForm() {

  }

  public void refresh() {

    DHCPGeneral mbean = (DHCPGeneral) getModel();
    BeanService.refreshBean(fApplication, mbean);

//    tfUtsDHCPServiceState.setSelectedIndex(getIndexFromValue(utsDHCPServiceStateVList, mbean.getUtsDHCPServiceState().intValue()));
    tfUtsDHCPServiceMode.setSelectedIndex(getIndexFromValue(utsDHCPServiceModeVList, mbean.getUtsDHCPServiceMode()
        .intValue()));

  }

  public boolean validateFrom() {
//        DHCPGeneral mbean = (DHCPGeneral) getModel();
//        BeanService.refreshBean(fApplication, mbean);
//        if (mbean.getUtsDHCPServiceState().intValue() == 2 && tfUtsDHCPServiceState.getSelectedIndex() == 2
//                || mbean.getUtsDHCPServiceState().intValue() == 3 && tfUtsDHCPServiceState.getSelectedIndex() == 1) {
//            String error = "The DHCP Status cannot be directly switched " +
//                    "from \"Server Active\" to \"Relay Active\" or from \"Relay Active\" to \"Server Active\".";
//            MessageDialog.showErrorMessageDialog(fApplication, error);
//
//            return false;
//        }
//        if (tfUtsDHCPServiceState.getSelectedIndex() == 0 || tfUtsDHCPServiceState.getSelectedIndex() == 1) {
//            DHCPRelayServerTable mbeanserver = new DHCPRelayServerTable(fApplication.getSnmpProxy());
//            Vector v = BeanService.refreshTableBean(fApplication, mbeanserver);
//            if (v.size() > 0) {
//                String error = "Please remove the Relay Servers first.";
//                MessageDialog.showErrorMessageDialog(fApplication, error);
//                return false;
//            }
//        }
    return true;
  }

  public void updateModel() {

    DHCPGeneral mbean = (DHCPGeneral) getModel();

//    mbean.setUtsDHCPServiceState(new Integer(utsDHCPServiceStateVList[tfUtsDHCPServiceState.getSelectedIndex()]));
    mbean.setUtsDHCPServiceMode(new Integer(utsDHCPServiceModeVList[tfUtsDHCPServiceMode.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v)
        return i;
    }
    return 0;
  }

}


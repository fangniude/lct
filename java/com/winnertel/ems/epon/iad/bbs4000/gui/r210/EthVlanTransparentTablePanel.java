package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.r210.EthVlanTransparentTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class EthVlanTransparentTablePanel extends UPanel {
  private JLabel tfIfIndex = new JLabel();

  int[] utsEthVlanTransparentSwitchVList = new int[]{2, 1};
  String[] utsEthVlanTransparentSwitchTList = new String[] {
      fStringMap.getString("enable"), fStringMap.getString("disable")
  };
  private JComboBox tfUtsEthVlanTransparentSwitch = new JComboBox(utsEthVlanTransparentSwitchTList);

  private int[] utsEthVlanTransparentTagModeVList = new int[] {1, 2};
  private String[] utsEthVlanTransparentTagModeTList = new String[] {
      fStringMap.getString("singletag"), fStringMap.getString("doubletag"),
  };
  private JComboBox tfUtsEthVlanTransparentTagMode = new JComboBox(utsEthVlanTransparentTagModeTList);

  private final String ifIndex = fStringMap.getString("ifIndex") + " : ";
  private final String utsEthVlanTransparentSwitch = fStringMap.getString("utsEthVlanTransparentSwitch") + " : ";
  private final String utsEthVlanTransparentTagMode = fStringMap.getString("utsEthVlanTransparentTagMode") + " : ";

  public EthVlanTransparentTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(ifIndex));
    tfIfIndex.setName(fStringMap.getString("utsEthVlanMappingModuleID"));
    baseInfoPanel.add(tfIfIndex);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsEthVlanTransparentSwitch));
    tfUtsEthVlanTransparentSwitch.setName(fStringMap.getString("utsEthVlanTransparentSwitch"));
    baseInfoPanel.add(tfUtsEthVlanTransparentSwitch);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsEthVlanTransparentTagMode));
    tfUtsEthVlanTransparentTagMode.setName(fStringMap.getString("utsEthVlanTransparentTagMode"));
    tfUtsEthVlanTransparentTagMode.setEnabled(false);
    baseInfoPanel.add(tfUtsEthVlanTransparentTagMode);
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

  public void refresh() {
    if (SnmpAction.IType.MODIFY.equals(fCommand))
    {
      EthVlanTransparentTable mbean = (EthVlanTransparentTable)getModel();

      tfIfIndex.setText(ConfigUtility.formatIfIndex(mbean.getIfIndex()));
      tfUtsEthVlanTransparentSwitch.setSelectedIndex(getIndexFromValue(utsEthVlanTransparentSwitchVList, mbean.getUtsEthVlanTransparentSwitch()));
      tfUtsEthVlanTransparentTagMode.setSelectedIndex(getIndexFromValue(utsEthVlanTransparentTagModeVList, mbean.getUtsEthVlanTransparentTagMode()));
    }
  }

  public void updateModel() {
    if (SnmpAction.IType.MODIFY.equals(fCommand)) {
      EthVlanTransparentTable mbean = (EthVlanTransparentTable) getModel();

      mbean.setUtsEthVlanTransparentSwitch(utsEthVlanTransparentSwitchVList[tfUtsEthVlanTransparentSwitch.getSelectedIndex()]);
//      mbean.setUtsEthVlanTransparentTagMode(utsEthVlanTransparentTagModeVList[tfUtsEthVlanTransparentTagMode.getSelectedIndex()]);
    }
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}


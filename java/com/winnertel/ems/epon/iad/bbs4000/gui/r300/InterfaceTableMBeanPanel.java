package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.InterfaceTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class InterfaceTableMBeanPanel extends UPanel {
  private int[] ifAdminStatusVList = new int[]{
      1, 2,};
  private String[] ifAdminStatusTList = new String[]{
      fStringMap.getString("Up"),
      fStringMap.getString("Down"),
  };
  private JComboBox tfIfAdminStatus = new JComboBox(ifAdminStatusTList);

  private final String ifAdminStatus = fStringMap.getString("ifAdminStatus") + " : ";

  public InterfaceTableMBeanPanel(IApplication app) {
    super(app);
    setModel(new InterfaceTableMBean(app.getSnmpProxy()));
    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(ifAdminStatus));
    tfIfAdminStatus.setName(fStringMap.getString("ifAdminStatus"));
    tfIfAdminStatus.setPreferredSize(new Dimension(100, 25));
    baseInfoPanel.add(tfIfAdminStatus);
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
  }

  public boolean validateFrom() {
    return true;
  }

  public void refresh() {
    InterfaceTableMBean mbean = (InterfaceTableMBean) getModel();

    tfIfAdminStatus.setSelectedIndex(getIndexFromValue(ifAdminStatusVList, mbean.getIfAdminStatus().intValue()));
  }

  public void updateModel() {
    InterfaceTableMBean mbean = (InterfaceTableMBean) getModel();

    mbean.setIfAdminStatus(new Integer(ifAdminStatusVList[tfIfAdminStatus.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}


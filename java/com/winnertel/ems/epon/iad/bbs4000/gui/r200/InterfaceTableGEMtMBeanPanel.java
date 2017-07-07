package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.InterfaceTableGEMtMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-18
 * Time: 14:28:42
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceTableGEMtMBeanPanel extends UPanel {

  private int[] ifAdminStatusVList = new int[]{
    1, 2, };
  private String[] ifAdminStatusTList = new String[]{
    fStringMap.getString("Up"),
    fStringMap.getString("Down"),
  };
  private JComboBox tfIfAdminStatus = new JComboBox(ifAdminStatusTList);

  private StringTextField tfUtsEthIfExtDescription = new StringTextField();

  private final String ifAdminStatus = fStringMap.getString("ifAdminStatus") + " : ";
  private final String utsEthIfExtDescription = fStringMap.getString("utsEthIfExtDescription") + " : ";

  public InterfaceTableGEMtMBeanPanel(IApplication app) {
    super(app);
    setModel(new InterfaceTableGEMtMBean(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(ifAdminStatus));
    tfIfAdminStatus.setName(fStringMap.getString("ifAdminStatus"));
    tfIfAdminStatus.setPreferredSize(new Dimension(100, 25));
    baseInfoPanel.add(tfIfAdminStatus);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsEthIfExtDescription));
    tfUtsEthIfExtDescription.setPreferredSize(new Dimension(100, 25));
    baseInfoPanel.add(tfUtsEthIfExtDescription);
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
    tfUtsEthIfExtDescription.setLenScope(0, 64);
  }

  public boolean validateFrom() {
    InterfaceTableGEMtMBean mbean = (InterfaceTableGEMtMBean) getModel();
    String index = ConfigUtility.formatIfIndex("" + mbean.getIfIndex());
    if (index.indexOf("lg") != -1) {
      String error = fStringMap.getString("Err_Forbid_Modify_LG");
      JOptionPane.showMessageDialog(this, error);
      return false;
    }
    return true;
  }

  public void refresh() {
    InterfaceTableGEMtMBean mbean = (InterfaceTableGEMtMBean) getModel();

    tfIfAdminStatus.setSelectedIndex(getIndexFromValue(ifAdminStatusVList, mbean.getIfAdminStatus().intValue()));
    tfUtsEthIfExtDescription.setValue(mbean.getUtsEthIfExtDescription());
  }

  public void updateModel() {
    InterfaceTableGEMtMBean mbean = (InterfaceTableGEMtMBean) getModel();

    mbean.setIfAdminStatus(new Integer(ifAdminStatusVList[tfIfAdminStatus.getSelectedIndex()]));
    mbean.setUtsEthIfExtDescription(tfUtsEthIfExtDescription.getValue());
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}

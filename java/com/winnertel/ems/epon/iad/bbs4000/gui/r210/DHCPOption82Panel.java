package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.DHCPOption82MBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The DHCPServiceStatePanel class. Created by DVM Creator
 */
public class DHCPOption82Panel extends UPanel implements ActionListener {
  private int[] vList = new int[] { 1, 2, 3};
  private String[] utsBBSMgmtOption82FormatModeSettingTList = new String[] {
    fStringMap.getString("Default"), fStringMap.getString("Customized"), fStringMap.getString("CTC")};
  private JComboBox tfUtsBBSMgmtOption82FormatModeSetting = new JComboBox(utsBBSMgmtOption82FormatModeSettingTList);
  private JLabel tfUtsBBSMgmtOption82DefaultCircuitID = new JLabel();
  private StringTextField tfUtsBBSMgmtOption82CustomizedCircuitID = new StringTextField(30);
  private JLabel tfUtsBBSMgmtOption82DefaultRemoteID = new JLabel();
  private StringTextField tfUtsBBSMgmtOption82CustomizedRemoteID = new StringTextField(30);
  private StringTextField tfutsBBSMgmtOption82CtcAccessNodeIdentifier = new StringTextField(30);

  private final String utsBBSMgmtOption82FormatModeSetting = fStringMap.getString("utsBBSMgmtOption82FormatModeSetting") + " : ";
  private final String utsBBSMgmtOption82DefaultCircuitID = fStringMap.getString("utsBBSMgmtOption82DefaultCircuitID") + " : ";
  private final String utsBBSMgmtOption82CustomizedCircuitID = fStringMap.getString("utsBBSMgmtOption82CustomizedCircuitID") + " : ";
  private final String utsBBSMgmtOption82DefaultRemoteID = fStringMap.getString("utsBBSMgmtOption82DefaultRemoteID") + " : ";
  private final String utsBBSMgmtOption82CustomizedRemoteID = fStringMap.getString("utsBBSMgmtOption82CustomizedRemoteID") + " : ";
  private final String utsBBSMgmtOption82CtcAccessNodeIdentifier = fStringMap.getString("utsBBSMgmtOption82CtcAccessNodeIdentifier") + " : ";

  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;

  public DHCPOption82Panel(IApplication app) {
    super(app);
    setModel(new DHCPOption82MBean(app.getSnmpProxy()));
    init();
  }

  public void initGui() {
    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_DHCPOption82");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5,
        5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsBBSMgmtOption82FormatModeSetting));
    tfUtsBBSMgmtOption82FormatModeSetting.setName(fStringMap.getString("utsBBSMgmtOption82FormatModeSetting"));
    tfUtsBBSMgmtOption82FormatModeSetting.addActionListener(this);
    baseInfoPanel.add(tfUtsBBSMgmtOption82FormatModeSetting);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtOption82DefaultCircuitID));
    baseInfoPanel.add(tfUtsBBSMgmtOption82DefaultCircuitID);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtOption82CustomizedCircuitID));
    tfUtsBBSMgmtOption82CustomizedCircuitID.setName(fStringMap.getString("utsBBSMgmtOption82CustomizedCircuitID"));
    baseInfoPanel.add(tfUtsBBSMgmtOption82CustomizedCircuitID);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtOption82DefaultRemoteID));
    baseInfoPanel.add(tfUtsBBSMgmtOption82DefaultRemoteID);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtOption82CustomizedRemoteID));
    tfUtsBBSMgmtOption82CustomizedRemoteID.setName(fStringMap.getString("utsBBSMgmtOption82CustomizedRemoteID"));
    baseInfoPanel.add(tfUtsBBSMgmtOption82CustomizedRemoteID);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtOption82CtcAccessNodeIdentifier));
    tfutsBBSMgmtOption82CtcAccessNodeIdentifier.setName(fStringMap.getString("utsBBSMgmtOption82CtcAccessNodeIdentifier"));
    baseInfoPanel.add(tfutsBBSMgmtOption82CtcAccessNodeIdentifier);
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
    tfUtsBBSMgmtOption82CustomizedCircuitID.setLenScope(0, 63);
    tfUtsBBSMgmtOption82CustomizedRemoteID.setLenScope(0, 63);
    tfutsBBSMgmtOption82CtcAccessNodeIdentifier.setLenScope(0, 50);
  }

  public void refresh() {
    DHCPOption82MBean mbean = (DHCPOption82MBean)getModel();
    BeanService.refreshBean(fApplication, mbean);

    tfUtsBBSMgmtOption82FormatModeSetting.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSMgmtOption82FormatModeSetting()));
    tfUtsBBSMgmtOption82DefaultCircuitID.setText(mbean.getUtsBBSMgmtOption82DefaultCircuitID());
    tfUtsBBSMgmtOption82CustomizedCircuitID.setText(mbean.getUtsBBSMgmtOption82CustomizedCircuitID());
    tfUtsBBSMgmtOption82DefaultRemoteID.setText(mbean.getUtsBBSMgmtOption82DefaultRemoteID());
    tfUtsBBSMgmtOption82CustomizedRemoteID.setText(mbean.getUtsBBSMgmtOption82CustomizedRemoteID());
    tfutsBBSMgmtOption82CtcAccessNodeIdentifier.setText(mbean.getUtsBBSMgmtOption82CtcAccessNodeIdentifier());
  }

  public boolean validateFrom() {
    return true;
  }

  public void updateModel() {
    DHCPOption82MBean mbean = (DHCPOption82MBean) getModel();

    mbean.setUtsBBSMgmtOption82FormatModeSetting(vList[tfUtsBBSMgmtOption82FormatModeSetting.getSelectedIndex()]);

    if(tfUtsBBSMgmtOption82CustomizedCircuitID.isEnabled())
      mbean.setUtsBBSMgmtOption82CustomizedCircuitID(tfUtsBBSMgmtOption82CustomizedCircuitID.getValue());

    if(tfUtsBBSMgmtOption82CustomizedRemoteID.isEnabled())
      mbean.setUtsBBSMgmtOption82CustomizedRemoteID(tfUtsBBSMgmtOption82CustomizedRemoteID.getValue());

    if(tfutsBBSMgmtOption82CtcAccessNodeIdentifier.isEnabled())
      mbean.setUtsBBSMgmtOption82CtcAccessNodeIdentifier(tfutsBBSMgmtOption82CtcAccessNodeIdentifier.getValue());
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v)
        return i;
    }
    return 0;
  }

  public void actionPerformed(ActionEvent e) {
    if(tfUtsBBSMgmtOption82FormatModeSetting.getSelectedIndex() == 0){ //Default mode.
      tfUtsBBSMgmtOption82CustomizedCircuitID.setEnabled(false);
      tfUtsBBSMgmtOption82CustomizedRemoteID.setEnabled(false);
      tfutsBBSMgmtOption82CtcAccessNodeIdentifier.setEnabled(false);
    } else if (tfUtsBBSMgmtOption82FormatModeSetting.getSelectedIndex() == 1){ //Default mode.
      tfUtsBBSMgmtOption82CustomizedCircuitID.setEnabled(true);
      tfUtsBBSMgmtOption82CustomizedRemoteID.setEnabled(true);
      tfutsBBSMgmtOption82CtcAccessNodeIdentifier.setEnabled(false);
    } else {
      tfUtsBBSMgmtOption82CustomizedCircuitID.setEnabled(false);
      tfUtsBBSMgmtOption82CustomizedRemoteID.setEnabled(false);
      tfutsBBSMgmtOption82CtcAccessNodeIdentifier.setEnabled(true);
    }
  }
}

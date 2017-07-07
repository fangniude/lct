package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class OntFilterPanel extends JPanel implements ActionListener {

  protected IApplication fApplication = null;
  protected DvmStringMap fStringMap = null;

  private JComboBox cmbModule = new JComboBox();
  private JComboBox cmbPort = new JComboBox();
  private JComboBox cmbLogicalPort = new JComboBox();

  private JButton btnRefresh = null;
  BBS4000NE ne = null;

  public OntFilterPanel(IApplication app) {
    fApplication = app;
    if (fApplication.getActiveDeviceManager() != null) {
      fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
    }
    ne = new BBS4000NE(fApplication);
    init();
  }

  private void init() {
    NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    setLayout(layout);
    setBorder(BorderFactory.createTitledBorder(getString("Filter")));

    JPanel conditionPanel = new JPanel(new FlowLayout());
    conditionPanel.add(new Label(getString("Module ID") + ": "));
    conditionPanel.add(cmbModule);
    conditionPanel.add(new Label(getString("Port ID") + ": "));
    conditionPanel.add(cmbPort);
    conditionPanel.add(new Label(getString("Logical Port ID") + ": "));
    conditionPanel.add(cmbLogicalPort);

    add(conditionPanel, null);
    add(new HSpacer());
    add(getRefreshButton(), null);

    //Port
    cmbPort.removeAllItems();
    cmbPort.addItem(getString("All"));
    for (int i = 1; i <= ne.getPortCount(); i++) {
      cmbPort.addItem(getString("Port") + " " + i);
    }

    //Logical Port
    cmbLogicalPort.removeAllItems();
    cmbLogicalPort.addItem(getString("All"));
    int count = ne.getPonSplitRatio();
    for (int i = 1; i <= count; i++) {
      cmbLogicalPort.addItem(getString("ONT") + " " + i);
    }

    cmbModule.addActionListener(this);
    cmbPort.addActionListener(this);
    cmbLogicalPort.addActionListener(this);
  }

  private JButton getRefreshButton() {
    if (btnRefresh == null) {
      btnRefresh = new JButton();
      btnRefresh.setText(getString("Refresh"));
    }

    return btnRefresh;
  }

  public void refresh() {
    Object module = fApplication.getActiveDeviceManager().getProperties().getProperty("OntFilterPanel.moduleId");
    Object port = fApplication.getActiveDeviceManager().getProperties().getProperty("OntFilterPanel.portId");
    Object onu = fApplication.getActiveDeviceManager().getProperties().getProperty("OntFilterPanel.ontId");

    cmbModule.removeActionListener(this);
    cmbModule.removeAllItems();
    cmbModule.addActionListener(this);
    cmbModule.addItem(getString("All"));
    BaseModuleType fModuleType = new ModuleType();
    BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
    Vector list = BeanService.refreshTableBean(fApplication, bean);
    for (int i = 0; i < list.size(); i++) {
      BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
      if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
        cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
      } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
        cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
      } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }*/
    }

    if (module != null)
      cmbModule.setSelectedItem(module);
    else if (cmbModule.getItemCount() > 1)
      cmbModule.setSelectedIndex(1);
    if (port != null)
      cmbPort.setSelectedItem(port);
    if (onu != null)
      cmbLogicalPort.setSelectedItem(onu);
  }

  public int[] getAllSlotId() {
    int[] result = new int[cmbModule.getItemCount() - 1];

    for (int i = 1; i < cmbModule.getItemCount(); i++) {
      String item = (String) cmbModule.getItemAt(i);
      result[i - 1] = Integer.parseInt(item.split(" ")[1]);
    }

    return result;
  }

  public int getSelectedSlotId() {
    if (cmbModule.getSelectedIndex() != 0 && cmbModule.getSelectedItem() != null) {
      String item = (String) cmbModule.getSelectedItem();
      return (Integer.parseInt(item.split(" ")[1]));
    }

    return 0;
  }

  public int getSelectedPortId() {
    if (cmbPort.getSelectedIndex() != 0 && cmbPort.getSelectedItem() != null) {
      String item = (String) cmbPort.getSelectedItem();
      return (Integer.parseInt(item.split(" ")[1]));
    }

    return 0;
  }

  public int getSelectedOntId() {
    if (cmbLogicalPort.getSelectedIndex() != 0 && cmbLogicalPort.getSelectedItem() != null) {
      String item = (String) cmbLogicalPort.getSelectedItem();
      return (Integer.parseInt(item.split(" ")[1]));
    }

    return 0;
  }

  public void addActionListener(ActionListener l) {
    btnRefresh.addActionListener(l);
  }

  public void removeActionListener(ActionListener l) {
    btnRefresh.removeActionListener(l);
  }

  public void actionPerformed(ActionEvent e) {
    fApplication.getActiveDeviceManager().getProperties().setProperty("OntFilterPanel.moduleId", (String) cmbModule.getSelectedItem());
    fApplication.getActiveDeviceManager().getProperties().setProperty("OntFilterPanel.portId", (String) cmbPort.getSelectedItem());
    fApplication.getActiveDeviceManager().getProperties().setProperty("OntFilterPanel.ontId", (String) cmbLogicalPort.getSelectedItem());

    if (cmbModule != null && cmbModule.getSelectedIndex() == 0) {
      if (cmbPort != null && cmbPort.getItemCount() > 0) {
        cmbPort.setSelectedIndex(0);
        cmbPort.setEnabled(false);
      }
    } else {
      cmbPort.setEnabled(true);
    }
    if (cmbPort != null && cmbPort.getSelectedIndex() == 0) {
      if (cmbLogicalPort != null && cmbLogicalPort.getItemCount() > 0) {
        cmbLogicalPort.setSelectedIndex(0);
        cmbLogicalPort.setEnabled(false);
      }
    } else {
      cmbLogicalPort.setEnabled(true);
    }
  }

  public String getString(String s) {
    return (s == null || s.length() <= 0) ? s : fStringMap.getString(s);
  }
}
package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.EthInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.PortTreeNodeBuilder;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.SuperVlanInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.SVIMemberVlanListInputPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The SuperSVITablePanel class. Created by DVM Creator
 */
public class SuperSVITablePanel extends UPanel implements ActionListener {

  private JComboBox tfUtsIntfSuperSVIVlanId = new JComboBox();

  private SVIMemberVlanListInputPanel vlanListInputPanel = new SVIMemberVlanListInputPanel(fApplication);
  private final String utsIntfSuperSVIVlanId = fStringMap
      .getString("utsIntfSuperSVIVlanId")
      + " : ";

  private final String utsIntfSuperSVIVlanMemberBitmap = fStringMap
      .getString("utsIntfSuperSVIVlanMemberBitmap")
      + " : ";

  public SuperSVITablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
        5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsIntfSuperSVIVlanId));
    tfUtsIntfSuperSVIVlanId.setName(fStringMap.getString("utsIntfSuperSVIVlanId"));
    tfUtsIntfSuperSVIVlanId.addActionListener(this);
    baseInfoPanel.add(tfUtsIntfSuperSVIVlanId);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIntfSuperSVIVlanMemberBitmap));
    vlanListInputPanel.setName(fStringMap
        .getString("utsIntfSuperSVIVlanMemberBitmap"));
    baseInfoPanel.add(vlanListInputPanel);
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
    if (SnmpAction.IType.ADD.equals(fCommand)) {
      tfUtsIntfSuperSVIVlanId.removeAllItems();

      String[] vlan = getVlanForAdd();
      for (int i = 0; i < vlan.length; i++) {
        tfUtsIntfSuperSVIVlanId.addItem(vlan[i]);
      }
      return;
    }

    SuperSVITable mbean = (SuperSVITable) getModel();

    tfUtsIntfSuperSVIVlanId.setEditable(false);
    tfUtsIntfSuperSVIVlanId.removeAllItems();
    tfUtsIntfSuperSVIVlanId.addItem("" + mbean.getUtsIntfSuperSVIVlanId());
    vlanListInputPanel.setVlanList(mbean.getUtsIntfSuperSVIVlanMemberBitmap());
  }

  public void updateModel() {
    if (SnmpAction.IType.ADD.equals(fCommand))
      setModel(new SuperSVITable(fApplication.getSnmpProxy()));

    SuperSVITable mbean = (SuperSVITable) getModel();
    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsIntfSuperSVIVlanId(new Integer(tfUtsIntfSuperSVIVlanId.getSelectedItem().toString()));
    }

    mbean.setUtsIntfSuperSVIVlanMemberBitmap(vlanListInputPanel.getVlanList());
  }

  public boolean validateFrom() {
    String vlanID = (String)tfUtsIntfSuperSVIVlanId.getSelectedItem();

    if (vlanID == null) {
      String error = fStringMap.getString("Err_Super_VLAN_Is_Empty");
      MessageDialog.showInfoMessageDialog(fApplication, error);
      return false;
    }

    String result = vlanListInputPanel.validateForm();

    if (result != null) {
      MessageDialog.showInfoMessageDialog(fApplication, result);
      return false;
    }

    return true;
  }

  private String[] getVlanForAdd() {
    ArrayList list = new ArrayList();

    EthInterface[] layer3Vlan = getLayer3Vlan();
    SuperVlanInterface[] superVlan = SuperVlanInterface.getSuperVlanInterface(this.fApplication.getSnmpProxy());

    for (int i = 0; i < layer3Vlan.length; i++) {
      String vlan = layer3Vlan[i].getInterfaceID().substring(4);
      for (int j = 0; j < superVlan.length; j++) {
        if (vlan != null && vlan.equals(superVlan[j].getVlanId())) {
          vlan = null;
        }
      }

      if (vlan != null) {
        list.add(vlan);
      }
    }

    return (String[]) list.toArray(new String[0]);
  }

  private EthInterface[] getLayer3Vlan() {
    ArrayList list = new ArrayList();
    PortTreeNodeBuilder builder = new PortTreeNodeBuilder(this.fApplication.getSnmpProxy());
    EthInterface[] layer3Interface = builder.getLayer3EthInterface();

    for (int i = 0; i < layer3Interface.length; i++) {
      if (layer3Interface[i].getInterfaceID().indexOf("vlan") != -1) {
        list.add(layer3Interface[i]);
      }
    }

    return (EthInterface[]) list.toArray(new EthInterface[0]);
  }

  public void actionPerformed(ActionEvent e) {
    String value = (String)tfUtsIntfSuperSVIVlanId.getSelectedItem();

    if(value != null)
    {
      vlanListInputPanel.setSuperSVI(Integer.parseInt(value));
    }
  }
}
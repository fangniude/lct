package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.PonVlanTranslationTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PonVlanTranslationTablePanel extends UPanel {
  private JComboBox tfUtsPonVlanTranslationModuleID = new JComboBox();
  private JComboBox tfUtsPonVlanTranslationPortID = new JComboBox();
  private JComboBox tfUtsPonVlanTranslationLogicPortID = new JComboBox();
  private IntegerTextField tfUtsPonVlanTranslationOldVID = new IntegerTextField();
  private JComboBox tfUtsPonVlanTranslationOldCos = new JComboBox();
  private IntegerTextField tfUtsPonVlanTranslationNewVID = new IntegerTextField();
  private JComboBox tfUtsPonVlanTranslationNewCos = new JComboBox();

  private final String utsPonVlanTranslationModuleID = fStringMap.getString("utsPonVlanTranslationModuleID") + " : ";
  private final String utsPonVlanTranslationPortID = fStringMap.getString("utsPonVlanTranslationPortID") + " : ";
  private final String utsPonVlanTranslationLogicPortID = fStringMap.getString("utsPonVlanTranslationLogicPortID") + " : ";
  private final String utsPonVlanTranslationOldVID = fStringMap.getString("utsPonVlanTranslationOldVID") + " : ";
  private final String utsPonVlanTranslationOldCos = fStringMap.getString("utsPonVlanTranslationOldCos") + " : ";
  private final String utsPonVlanTranslationNewVID = fStringMap.getString("utsPonVlanTranslationNewVID") + " : ";
  private final String utsPonVlanTranslationNewCos = fStringMap.getString("utsPonVlanTranslationNewCos") + " : ";

  public PonVlanTranslationTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    tfUtsPonVlanTranslationModuleID.setName(fStringMap.getString("utsEthVlanMappingModuleID"));
    baseInfoPanel.add(new JLabel(utsPonVlanTranslationModuleID));
    baseInfoPanel.add(tfUtsPonVlanTranslationModuleID);
    baseInfoPanel.add(new HSpacer());

    for(int i = 1; i <= 4; i++) {
      tfUtsPonVlanTranslationPortID.addItem("" + i);
    }
    tfUtsPonVlanTranslationPortID.setName(fStringMap.getString("utsPonVlanTranslationPortID"));
    baseInfoPanel.add(new JLabel(utsPonVlanTranslationPortID));
    baseInfoPanel.add(tfUtsPonVlanTranslationPortID);
    baseInfoPanel.add(new HSpacer());

    int split = new BBS4000NE(fApplication).getPonSplitRatio();
    for(int i = 1; i <= split; i++) {
      tfUtsPonVlanTranslationLogicPortID.addItem("" + i);
    }
    tfUtsPonVlanTranslationLogicPortID.setName(fStringMap.getString("utsEthSmartQinQEtherType"));
    baseInfoPanel.add(new JLabel(utsPonVlanTranslationLogicPortID));
    baseInfoPanel.add(tfUtsPonVlanTranslationLogicPortID);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsPonVlanTranslationOldVID));
    tfUtsPonVlanTranslationOldVID.setName(fStringMap.getString("utsPonVlanTranslationOldVID"));
    baseInfoPanel.add(tfUtsPonVlanTranslationOldVID);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsPonVlanTranslationOldCos));
    tfUtsPonVlanTranslationOldCos.setName(fStringMap.getString("utsPonVlanTranslationOldCos"));
    baseInfoPanel.add(tfUtsPonVlanTranslationOldCos);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsPonVlanTranslationNewVID));
    tfUtsPonVlanTranslationNewVID.setName(fStringMap.getString("utsPonVlanTranslationNewVID"));
    baseInfoPanel.add(tfUtsPonVlanTranslationNewVID);
    baseInfoPanel.add(new HSpacer());

    tfUtsPonVlanTranslationOldCos.addItem(fStringMap.getString("none"));
    tfUtsPonVlanTranslationNewCos .addItem(fStringMap.getString("none"));
    for(int i = 0; i < 8; i++)
    {
      tfUtsPonVlanTranslationOldCos.addItem("" + i);
      tfUtsPonVlanTranslationNewCos.addItem("" + i);
    }

    baseInfoPanel.add(new JLabel(utsPonVlanTranslationNewCos));
    tfUtsPonVlanTranslationNewCos.setName(fStringMap.getString("utsPonVlanTranslationNewCos"));
    baseInfoPanel.add(tfUtsPonVlanTranslationNewCos);
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

  public void initForm()
  {
    tfUtsPonVlanTranslationOldVID.setValueScope(1, 4094);
    tfUtsPonVlanTranslationNewVID.setValueScope(1, 4094);
  }

  public void refresh() {
    tfUtsPonVlanTranslationModuleID.removeAllItems();

    BaseModuleType fModuleType = new ModuleType();
    BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
    Vector cardList = BeanService.refreshTableBean(fApplication, bean);

    for(int i = 0; i < cardList.size(); i++) {
      BBS4000CardMibBean card = (BBS4000CardMibBean)cardList.get(i);

      if(fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
        tfUtsPonVlanTranslationModuleID.addItem("" + card.getUtsEponModuleBoardPhyId());
      }
    }
  }

  public boolean validateFrom()
  {
    if (tfUtsPonVlanTranslationModuleID.getSelectedItem() == null) {
      String error = fStringMap.getString("Err_Module_Id_Is_Null");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }
//    if(tfUtsPonVlanTranslationModuleID.getSelectedIndex() == -1)
//    {
//      String msg = fStringMap.getString("Err_If_Index_Is_Null");
//      MessageDialog.showInfoMessageDialog( fApplication, msg );
//
//      return false;
//    }
//
//    EthVlanMappingTable bean = new EthVlanMappingTable(fApplication.getSnmpProxy());
//    Vector mappingList = BeanService.refreshTableBean(fApplication, bean);
//
//    for(int i = 0; i < mappingList.size(); i++)
//    {
//      bean = (EthVlanMappingTable)mappingList.get(i);
//
//      //The recorder exists in system.
//      if(tfUtsPonVlanTranslationModuleID.getSelectedItem().equals(bean.getutsPonVlanTranslationModuleID()) &&
//          Integer.parseInt(((String) tfUtsPonVlanTranslationPortID.getSelectedItem()).substring(4)) == bean.getutsPonVlanTranslationPortID() &&
//          Integer.parseInt(((String) tfUtsPonVlanTranslationLogicPortID.getSelectedItem()).substring(4)) == bean.getutsPonVlanTranslationLogicPortID())
//      {
//        String msg = fStringMap.getString("Err_Vlan_Mapping_Exists");
//        MessageDialog.showInfoMessageDialog( fApplication, msg );
//
//        return false;
//      }
//    }
//
    return true;
  }

  public void updateModel() {
    if (SnmpAction.IType.ADD.equals(fCommand))
    {
      setModel(new PonVlanTranslationTable(fApplication.getSnmpProxy()));
    }

    PonVlanTranslationTable mbean = (PonVlanTranslationTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsPonVlanTranslationModuleID(Integer.parseInt((String)tfUtsPonVlanTranslationModuleID.getSelectedItem()));
      mbean.setUtsPonVlanTranslationDeviceID(1);
      mbean.setUtsPonVlanTranslationPortID(Integer.parseInt((String)tfUtsPonVlanTranslationPortID.getSelectedItem()));
      mbean.setUtsPonVlanTranslationLogicPortID(Integer.parseInt((String)tfUtsPonVlanTranslationLogicPortID.getSelectedItem()));
      mbean.setUtsPonVlanTranslationOldVID(tfUtsPonVlanTranslationOldVID.getValue());

      if(tfUtsPonVlanTranslationOldCos.getSelectedIndex() > 0)
        mbean.setUtsPonVlanTranslationOldCos(tfUtsPonVlanTranslationOldCos.getSelectedIndex() - 1);
      else
        mbean.setUtsPonVlanTranslationOldCos(8);

      mbean.setUtsPonVlanTranslationNewVID(tfUtsPonVlanTranslationNewVID.getValue());

      if(tfUtsPonVlanTranslationNewCos.getSelectedIndex() > 0)
        mbean.setUtsPonVlanTranslationNewCos(tfUtsPonVlanTranslationNewCos.getSelectedIndex() - 1);
      else
        mbean.setUtsPonVlanTranslationNewCos(8);
    }
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}


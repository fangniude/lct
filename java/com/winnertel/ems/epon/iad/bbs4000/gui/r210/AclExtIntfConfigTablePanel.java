package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.AclExtProfileImportTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.r210.AclExtIntfConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class AclExtIntfConfigTablePanel extends UPanel {
  //	private IntegerTextField tfUtsAclExtIntfConfigIntfNum = new IntegerTextField();
  private JComboBox cbUtsAclExtIntfConfigIntfNum = new JComboBox();
  //	private IntegerTextField tfUtsAclExtIntfConfigApplProfileId = new IntegerTextField();
  private JComboBox cbUtsAclExtIntfConfigApplProfileId = new JComboBox();
  int[] utsAclExtIntfConfigFlowDirectionVList = new int[] {1, 2};
  String[] utsAclExtIntfConfigFlowDirectionTList = new String[] {
      fStringMap.getString("ingress"), fStringMap.getString("egress")
  };
  private JComboBox cbUtsAclExtIntfConfigFlowDirection = new JComboBox(utsAclExtIntfConfigFlowDirectionTList);

  private final String utsAclExtIntfConfigIntfNum = fStringMap
      .getString("utsAclExtIntfConfigIntfNum")
      + " : ";

  private final String utsAclExtIntfConfigApplProfileId = fStringMap
      .getString("utsAclExtIntfConfigApplProfileId")
      + " : ";
  private final String utsAclExtIntfConfigFlowDirection = fStringMap.getString("utsAclExtIntfConfigFlowDirection") + " : ";

  public AclExtIntfConfigTablePanel(IApplication app) {
    super(app);
    setModel(new AclExtIntfConfigTable(app.getSnmpProxy()));
    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
        5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsAclExtIntfConfigIntfNum));
    cbUtsAclExtIntfConfigIntfNum.setName(fStringMap.getString("utsAclExtIntfConfigIntfNum"));
    baseInfoPanel.add(cbUtsAclExtIntfConfigIntfNum);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsAclExtIntfConfigApplProfileId));
    cbUtsAclExtIntfConfigApplProfileId.setName(fStringMap
        .getString("utsAclExtIntfConfigApplProfileId"));
    baseInfoPanel.add(cbUtsAclExtIntfConfigApplProfileId);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsAclExtIntfConfigFlowDirection));
    cbUtsAclExtIntfConfigFlowDirection.setName(fStringMap.getString("utsAclExtIntfConfigFlowDirection"));
    baseInfoPanel.add(cbUtsAclExtIntfConfigFlowDirection);
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

  public void refresh() {
    cbUtsAclExtIntfConfigApplProfileId.removeAllItems();
    AclExtProfileImportTable mbean = new AclExtProfileImportTable(fApplication.getSnmpProxy());
    Vector v = BeanService.refreshTableBean(fApplication, mbean);
    for (int i = 0; i < v.size(); i++) {
      AclExtProfileImportTable one = (AclExtProfileImportTable) v.get(i);
      if (one.getUtsAclExtProfileImportProfileId().intValue() <= 32) {
        cbUtsAclExtIntfConfigApplProfileId.addItem(one.getUtsAclExtProfileImportProfileId());
      }
    }
    if (SnmpAction.IType.ADD.equals(fCommand)) {
      cbUtsAclExtIntfConfigIntfNum.removeAllItems();
      getAllInterface();
      return;
    }
    AclExtIntfConfigTable mbean1 = (AclExtIntfConfigTable) getModel();
    String index = mbean1.getUtsAclExtIntfConfigIntfNum();
    cbUtsAclExtIntfConfigIntfNum.addItem(index);
    cbUtsAclExtIntfConfigIntfNum.setEnabled(false);
    cbUtsAclExtIntfConfigApplProfileId.setSelectedItem(mbean1.getUtsAclExtIntfConfigApplProfileId());
    cbUtsAclExtIntfConfigFlowDirection.setSelectedIndex(getIndexFromValue(utsAclExtIntfConfigFlowDirectionVList, mbean1.getUtsAclExtIntfConfigFlowDirection()));
  }

  public void updateModel() {

    if (SnmpAction.IType.ADD.equals(fCommand))
      setModel(new AclExtIntfConfigTable(fApplication.getSnmpProxy()));

    AclExtIntfConfigTable mbean = (AclExtIntfConfigTable) getModel();
    String id = cbUtsAclExtIntfConfigIntfNum.getSelectedItem().toString();
    int indexnum = 0;
    if (id.startsWith("lg")) {
      indexnum = 48 + Integer.parseInt(id.substring(2));
    } else if (id.equalsIgnoreCase(fStringMap.getString("CPU Port"))) {
      indexnum = 5000;
    } else {
      Integer module = Integer.valueOf(id.substring(0, id.indexOf('/')));
      Integer port = Integer.valueOf(id.substring(id.indexOf('/') + 1, id.length()));
      indexnum = new Integer((module.intValue() - 1) * 4 + port.intValue()).intValue();
    }

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsAclExtIntfConfigIntfNum(new Integer(indexnum));
    }

    mbean.setUtsAclExtIntfConfigApplProfileId(new Integer(cbUtsAclExtIntfConfigApplProfileId.getSelectedItem().toString()));
    mbean.setUtsAclExtIntfConfigFlowDirection(new Integer(utsAclExtIntfConfigFlowDirectionVList[cbUtsAclExtIntfConfigFlowDirection.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v)
        return i;
    }
    return 0;
  }

  public void afterUpdateModel() {
    GuiUtil.getParentDialog(this).dispose();

  }

  void getAllInterface() {
    Vector result = new Vector();
    BBS4000CardMibBean cardMBean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
    Vector v = BeanService.refreshTableBean(fApplication, cardMBean);

    Set moduleBoardTypeSet = new HashSet();
    ModuleType moduleType = new ModuleType();

    for (int i = 0; i < v.size(); i++) {
      int moduleBoardPhyId = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId().intValue();
      int moduleBoardType = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardType().intValue();
      int modulePhyPreStat = ((BBS4000CardMibBean) v.get(i)).getUtsEponModulePhyPresenceStat().intValue();
      int moduleAdminState = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleAdminState().intValue();
      if ((moduleType.isGEMModule(moduleBoardType) || moduleType.isEPMModule(moduleBoardType))
          && modulePhyPreStat == 1
          && moduleAdminState == 2) {
        moduleBoardTypeSet.add(String.valueOf(moduleBoardPhyId));
      }
    }

    for (Iterator iter = moduleBoardTypeSet.iterator(); iter.hasNext();) {
      String tmpBoardID = (String) iter.next();
      for (int i = 1; i <= 4; i++) {
        result.add(tmpBoardID + "/" + i);
      }
    }

    LinkAggregation lgMBean = new LinkAggregation(fApplication.getSnmpProxy());
    Vector lgVec = BeanService.refreshTableBean(fApplication, lgMBean);
    if (lgVec == null) lgVec = new Vector(0);

    Set l2PortInLGSet = new HashSet();
    for (int i = 0; i < lgVec.size(); i++) {
      LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(i);
      String lgport = "lg" + tmpLGMBean.getUtsLagExtDot3adAggGroupId().toString();
      result.add(lgport);
      String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());

      for (int j = 0; j < array.length; j++) {
        l2PortInLGSet.add(array[j]);
      }
    }

    for (Iterator iter = l2PortInLGSet.iterator(); iter.hasNext();) {
      result.remove(iter.next());
    }

    AclExtIntfConfigTable cmbean = new AclExtIntfConfigTable(fApplication.getSnmpProxy());
    Vector v1 = BeanService.refreshTableBean(fApplication, cmbean);
    if (v1 != null) {
      String[] ids = new String[v1.size()];
      for (int i = 0; i < v1.size(); i++) {
        AclExtIntfConfigTable one = (AclExtIntfConfigTable) v1.get(i);
        ids[i] = one.getUtsAclExtIntfConfigIntfNum();
      }
      if (ids.length != 0) {
        for (int i = 0; i < ids.length; i++) {
          if (result.contains(ids[i]) == true)
            result.remove(ids[i]);
        }
      }
    }

    for (Iterator iter = result.iterator(); iter.hasNext();) {
      cbUtsAclExtIntfConfigIntfNum.addItem(iter.next().toString());
    }

    cbUtsAclExtIntfConfigIntfNum.addItem(fStringMap.getString("CPU Port"));
  }


}

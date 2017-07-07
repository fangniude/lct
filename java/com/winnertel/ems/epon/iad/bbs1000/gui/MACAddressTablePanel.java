package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.PortBasedVLAN;
import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.MACAddressTable;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * The MACAddressTablePanel class. Created by DVM Creator
 */
public class MACAddressTablePanel extends UPanel
{
  private JComboBox tfUtsLagExtLinkAggMacifIndex = new JComboBox();
  private JComboBox tfUtsLagExtLinkAggMacVlanId = new JComboBox();
  private MacAddressField tfUtsLagExtLinkAggMacAddress = new MacAddressField("00:00:00:00:00:00");

  private final String InterfaceIndex = fStringMap.getString("InterfaceIndex") + ":";
  private final String utsLagExtLinkAggMacVlanId = fStringMap.getString("utsLagExtLinkAggMacVlanId") + " : ";
  private final String utsLagExtLinkAggMacAddress = fStringMap.getString("utsLagExtLinkAggMacAddress") + " : ";

  private ArrayList ifList = new ArrayList();
  private ArrayList vlanList = new ArrayList();


  public MACAddressTablePanel(IApplication app)
  {
    super(app);

    init();
  }

  public void initGui()
  {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
        5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(InterfaceIndex));
    tfUtsLagExtLinkAggMacifIndex.setName(fStringMap.getString("InterfaceIndex"));
    baseInfoPanel.add(tfUtsLagExtLinkAggMacifIndex);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsLagExtLinkAggMacVlanId));
    tfUtsLagExtLinkAggMacVlanId.setName(fStringMap.getString("utsLagExtLinkAggMacVlanId"));
    baseInfoPanel.add(tfUtsLagExtLinkAggMacVlanId);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsLagExtLinkAggMacAddress));
    tfUtsLagExtLinkAggMacAddress.setName(fStringMap.getString("utsLagExtLinkAggMacAddress"));
    baseInfoPanel.add(tfUtsLagExtLinkAggMacAddress);
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

  private void refreshData() {
    ifList.clear();
    vlanList.clear();

    try {
      BBS1000CardMibBean cardMBean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
      Vector v = cardMBean.retrieveAll();

      for (int i = 0; i < v.size(); i++) {
        int moduleBoardPhyId = ((BBS1000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId().intValue();
        int modulePhyPreStat = ((BBS1000CardMibBean) v.get(i)).getUtsEponModuleBoardState().intValue();
        if (modulePhyPreStat == 3) {
          for (int j = 1; j <= 4; j++) {
            ifList.add(moduleBoardPhyId + "/" + j);
          }
        }
      }

      // remove L2 port that in Link Aggregation set
      LinkAggregation lgMBean = new LinkAggregation(fApplication.getSnmpProxy());
      Vector lgVec = lgMBean.retrieveAll();
      if (lgVec == null) lgVec = new Vector(0);

      for (int i = 0; i < lgVec.size(); i++) {
        LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(i);

        Integer lgGroupId = tmpLGMBean.getUtsLagExtDot3adAggGroupId();
        ifList.add("lg" + lgGroupId);

        String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());

        for (int j = 0; j < array.length; j++) {
          ifList.remove(array[j]);
        }
      }

      //
      PortBasedVLAN vlanBean = new PortBasedVLAN(fApplication.getSnmpProxy());
      Vector vlanVector = vlanBean.retrieveAll();

      for(int i = 0; i < vlanVector.size(); i++)
      {
        PortBasedVLAN vlan = (PortBasedVLAN)vlanVector.get(i);
        vlanList.add(vlan.getUtsLagExtDot1qVlanIndex());
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void initForm()
  {
  }

  public void refresh()
  {
    //refresh the data from NE.
    refreshData();

    tfUtsLagExtLinkAggMacifIndex.removeAllItems();
    tfUtsLagExtLinkAggMacVlanId.removeAllItems();

    for(int i = 0; i < ifList.size(); i++)
    {
      tfUtsLagExtLinkAggMacifIndex.addItem(ifList.get(i));
    }

    for(int i = 0; i < vlanList.size(); i++)
    {
      tfUtsLagExtLinkAggMacVlanId.addItem(vlanList.get(i));
    }
  }

  public boolean validateFrom() {
    try {
      MACAddressTable macAddrTblMBean = new MACAddressTable(fApplication.getSnmpProxy());
      Vector macAddrTblVec = macAddrTblMBean.retrieveAll();

      int thisVLANID = ((Integer)tfUtsLagExtLinkAggMacVlanId.getSelectedItem()).intValue();
      String thisMacAddr = tfUtsLagExtLinkAggMacAddress.getMacString();

      for (int i = 0; i < macAddrTblVec.size(); i++) {
        MACAddressTable tmpMacAddrMBean = (MACAddressTable) macAddrTblVec.elementAt(i);
        int tmpVLANID = tmpMacAddrMBean.getUtsLagExtLinkAggMacVlanId().intValue();
        byte[] tmpMacAddrByte = tmpMacAddrMBean.getUtsLagExtLinkAggMacAddress();

        StringBuffer tmpMacAddrStrBuf = new StringBuffer();
        for (int j = 0; j < tmpMacAddrByte.length; j++) {
          String tmpMacAddrHex = Integer.toHexString(tmpMacAddrByte[j]);
          tmpMacAddrStrBuf.append(tmpMacAddrHex.length() == 1 ? ("0" + tmpMacAddrHex) : tmpMacAddrHex).append(":");
        }

        String tmpMacAddrStr = tmpMacAddrStrBuf.substring(0, tmpMacAddrStrBuf.length() - 1);

        if (tmpVLANID == thisVLANID && tmpMacAddrStr.equals(thisMacAddr)) {
          String error = fStringMap.getString("Err_MAC_Entry_Exist");
          MessageDialog.showInfoMessageDialog(fApplication, error);
          return false;
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return true;
  }

  public void updateModel()
  {
    if (SnmpAction.IType.ADD.equals(fCommand)) {
      setModel(new MACAddressTable(fApplication.getSnmpProxy()));
    }

    MACAddressTable mbean = (MACAddressTable) getModel();

    if (SnmpAction.IType.ADD.equals(fCommand)) {
      mbean.setUtsLagExtLinkAggMacAddress(tfUtsLagExtLinkAggMacAddress.getValue());

      mbean.setUtsLagExtLinkAggMacVlanId((Integer)tfUtsLagExtLinkAggMacVlanId.getSelectedItem());
    }

    // set utsLagExtLinkAggMacIsStatic as 1
    mbean.setUtsLagExtLinkAggMacIsStatic(new Integer(1));

    String ifIndex = (String)tfUtsLagExtLinkAggMacifIndex.getSelectedItem();

    if(ifIndex.startsWith("lg"))
    {
      mbean.setUtsLagExtLinkAggMacIntfType(new Integer(1));
      mbean.setUtsLagExtLinkAggMacTrunkId(new Integer(ifIndex.substring(2)));
    }
    else
    {
      mbean.setUtsLagExtLinkAggMacIntfType(new Integer(2));

      String[] selCardPortStrs = ifIndex.split("/");
      if (selCardPortStrs.length == 2) {
        mbean.setUtsLagExtLinkAggMacModule(new Integer(selCardPortStrs[0]));
        mbean.setUtsLagExtLinkAggMacPort(new Integer(selCardPortStrs[1]));
      }
    }
  }
}

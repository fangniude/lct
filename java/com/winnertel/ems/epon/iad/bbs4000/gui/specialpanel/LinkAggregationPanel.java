package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.MultiItemSelector;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The LinkAggregationPanel class. Created by DVM Creator
 */
public class LinkAggregationPanel extends UPanel
{
  private JComboBox tfUtsLagExtDot3adAggGroupId = new JComboBox();

  private StringTextField tfUtsLagExtDot3adAggName = new StringTextField();

  private int[] utsLagExtDot3adAggRtagVList = new int[] { 1, 2, 3, 4, 5, 6};

  private String[] utsLagExtDot3adAggRtagTList = new String[]
  { fStringMap.getString("srcMac"), fStringMap.getString("destMac"),
      fStringMap.getString("srcMacNDestMac"),
      fStringMap.getString("srcIp"), fStringMap.getString("destIp"),
      fStringMap.getString("srcIpNDestIp"), };

  private JComboBox tfUtsLagExtDot3adAggRtag = new JComboBox(
      utsLagExtDot3adAggRtagTList);

  private MultiItemSelector tfUtsLagExtDot3adAggPortListPorts = new MultiItemSelector();

  private final String utsLagExtDot3adAggGroupId = fStringMap.getString("utsLagExtDot3adAggGroupId") + " : ";
  private final String utsLagExtDot3adAggName = fStringMap.getString("utsLagExtDot3adAggName") + " : ";
  private final String utsLagExtDot3adAggPortListPorts = fStringMap.getString("utsLagExtDot3adAggPortListPorts") + " : ";
  private final String utsLagExtDot3adAggRtag = fStringMap.getString("utsLagExtDot3adAggRtag") + " : ";

  private LinkAggregationModel model = new LinkAggregationModel(fApplication.getSnmpProxy());
  public LinkAggregationPanel(IApplication app)
  {
    super(app);
    init();
  }

  public void initGui()
  {
    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsLagExtDot3adAggGroupId));
    tfUtsLagExtDot3adAggGroupId.setName(fStringMap.getString("utsLagExtDot3adAggGroupId"));
    baseInfoPanel.add(tfUtsLagExtDot3adAggGroupId);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsLagExtDot3adAggName));
    tfUtsLagExtDot3adAggName.setName(fStringMap.getString("utsLagExtDot3adAggName"));
    baseInfoPanel.add(tfUtsLagExtDot3adAggName);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsLagExtDot3adAggRtag));
    tfUtsLagExtDot3adAggRtag.setName(fStringMap.getString("utsLagExtDot3adAggRtag"));
    baseInfoPanel.add(tfUtsLagExtDot3adAggRtag);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsLagExtDot3adAggPortListPorts));
    baseInfoPanel.add(tfUtsLagExtDot3adAggPortListPorts);
    baseInfoPanel.add(new HSpacer());

    add(baseInfoPanel, BorderLayout.CENTER);
//    this.setPreferredSize(new Dimension(800, 600));
  }

  protected void initForm()
  {
    tfUtsLagExtDot3adAggName.setLenScope(0, 16);
  }

  public void refresh()
  {
    if (SnmpAction.IType.ADD.equals(fCommand))
    {
      model.retrieveForAdd();

      tfUtsLagExtDot3adAggGroupId.removeAllItems();
      Vector lgIdList = model.getLgIdList();
      for(int i = 0; i < lgIdList.size(); i++)
        tfUtsLagExtDot3adAggGroupId.addItem(lgIdList.get(i));

      tfUtsLagExtDot3adAggPortListPorts.setSelectionChoices(model.getPortList());
    }
    else if(SnmpAction.IType.MODIFY.equals(fCommand))
    {
      LinkAggregation mbean = (LinkAggregation) getModel();

      tfUtsLagExtDot3adAggGroupId.removeAllItems();
      tfUtsLagExtDot3adAggGroupId.addItem("" + mbean.getUtsLagExtDot3adAggGroupId());
      tfUtsLagExtDot3adAggGroupId.setSelectedIndex(0);
      tfUtsLagExtDot3adAggGroupId.setEnabled(false);
      tfUtsLagExtDot3adAggRtag.setSelectedIndex(getIndexFromValue(utsLagExtDot3adAggRtagVList,mbean.getUtsLagExtDot3adAggRtag()));

      tfUtsLagExtDot3adAggName.setValue(mbean.getUtsLagExtDot3adAggName());

      model.retrieveForModify(mbean);

      String[] portList = ConfigUtility.portMappingToStringArray(mbean.getUtsLagExtDot3adAggPortListPorts());

      Vector dataVector = model.getPortList();
      tfUtsLagExtDot3adAggPortListPorts.setSelectionChoices(dataVector);

      Vector selected = new Vector();
      for(int j = 0; j < portList.length; j++)
      {
        selected.add(portList[j]);
      }

      tfUtsLagExtDot3adAggPortListPorts.setSelectedChoices(selected);
    }
  }

  public boolean validateFrom() {
    if(tfUtsLagExtDot3adAggPortListPorts.getSelectedChoices().size() < 1)
    {
      MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Port_Not_Selected"));
      return false;
    }

    return true;
  }

  public void updateModel()
  {
    if (SnmpAction.IType.ADD.equals(fCommand))
    {
      LinkAggregation mbean = new LinkAggregation(fApplication.getSnmpProxy());
      mbean.setUtsLagExtDot3adAggGroupId(new Integer((String)tfUtsLagExtDot3adAggGroupId.getSelectedItem()));
      mbean.setUtsLagExtDot3adAggName(tfUtsLagExtDot3adAggName.getValue());
      mbean.setUtsLagExtDot3adAggRtag(new Integer(utsLagExtDot3adAggRtagVList[tfUtsLagExtDot3adAggRtag.getSelectedIndex()]));

      Vector selected = tfUtsLagExtDot3adAggPortListPorts.getSelectedChoices();
      String[] ports = (String[])selected.toArray(new String[0]);

      mbean.setUtsLagExtDot3adAggPortListPorts(ConfigUtility.StringArrayToPortMapping(ports));

      setModel(mbean);
    }
    else if(SnmpAction.IType.MODIFY.equals(fCommand))
    {
      LinkAggregation mbean = (LinkAggregation)getModel();
      mbean.setUtsLagExtDot3adAggName(tfUtsLagExtDot3adAggName.getValue());
      mbean.setUtsLagExtDot3adAggRtag(new Integer(utsLagExtDot3adAggRtagVList[tfUtsLagExtDot3adAggRtag.getSelectedIndex()]));

      Vector selected = tfUtsLagExtDot3adAggPortListPorts.getSelectedChoices();
      String[] ports = (String[])selected.toArray(new String[0]);

      mbean.setUtsLagExtDot3adAggPortListPorts(ConfigUtility.StringArrayToPortMapping(ports));
    }
  }

  public void afterUpdateModel()
  {
    if (SnmpAction.IType.ADD.equals(fCommand))
    {
      refresh();
    }
  }

  public int getIndexFromValue(int[] list, int v)
  {
    for (int i = 0; i != list.length; i++)
    {
      if (list[i] == v)
        return i;
    }
    return 0;
  }
}

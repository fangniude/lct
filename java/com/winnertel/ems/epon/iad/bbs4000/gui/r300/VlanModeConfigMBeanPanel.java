package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.VlanModeConfigMBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VlanModeConfigMBeanPanel extends UPanel implements ActionListener
{
    private JLabel tfUtsDot3OnuModuleId = new JLabel();

//    private Integer[] portList = new Integer[] { 1, 2, 3, 4 };
    private JLabel tfUtsDot3OnuPortId = new JLabel();

    private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

    private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

    private int[] utsDot3OnuEtherPortVlanModeVList = new int[] { 1, 2, 3, /**4 */};
    private String[] utsDot3OnuEtherPortVlanModeTList =
        new String[] { fStringMap.getString("transparent"), fStringMap.getString("tag"),
            fStringMap.getString("translation"), /**fStringMap.getString("vlanStacking") */};
    private JComboBox tfUtsDot3OnuEtherPortVlanMode =
        new JComboBox(utsDot3OnuEtherPortVlanModeTList);

    private IntegerTextField tfUtsDot3OnuEtherPortVlanTag = new IntegerTextField();

  private StringTextField tfUtsDot3OnuEtherPortVlanTPID = new StringTextField();

  private Dot3OnuEtherPortVlanPanel vlanPanel = null;

    private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
    private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
    private final String utsDot3OnuLogicalPortId =
        fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
    private final String utsDot3OnuEtherPortIndex =
        fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";

    private final String utsDot3OnuEtherPortVlanMode =
        fStringMap.getString("utsDot3OnuEtherPortVlanMode") + " : ";
    private final String utsDot3OnuEtherPortVlanTag =
        fStringMap.getString("utsDot3OnuEtherPortVlanTag") + " : ";

  private final String utsDot3OnuEtherPortVlanTPID =
      fStringMap.getString("utsDot3OnuEtherPortVlanTPID") + " : ";

    BBS4000NE bbs4000NE;

    public VlanModeConfigMBeanPanel(IApplication app)
    {
        super(app);

        bbs4000NE = new BBS4000NE(app);

        init();
    }

    private Integer[] getLogicalPortList() {
        int number = bbs4000NE.getPonSplitRatio();
        Integer[] logicalPorts = new Integer[number];

        for (int i = 1; i <= number; i++) {
            logicalPorts[i - 1] = new Integer(i);
        }

        return logicalPorts;
    }

    public void initGui()
    {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.TOP, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
        baseInfoPanel.add(tfUtsDot3OnuModuleId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
        baseInfoPanel.add(tfUtsDot3OnuPortId);
        baseInfoPanel.add(new HSpacer());

//        tfUtsDot3OnuLogicalPortId.setModel( new DefaultComboBoxModel( getLogicalPortList( ) ));
        baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanMode));
        tfUtsDot3OnuEtherPortVlanMode.setName(fStringMap.getString("utsDot3OnuEtherPortVlanMode"));
      tfUtsDot3OnuEtherPortVlanMode.addActionListener(this);
        baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTag));
        tfUtsDot3OnuEtherPortVlanTag.setName(fStringMap.getString("utsDot3OnuEtherPortVlanTag"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTag);
        baseInfoPanel.add(new HSpacer());

      baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTPID));
      tfUtsDot3OnuEtherPortVlanTPID.setName(fStringMap.getString("utsDot3OnuEtherPortVlanTPID"));
      baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTPID);
      baseInfoPanel.add(new HSpacer());

      baseInfoPanel.add(new VSpacer());
      baseInfoPanel.add(new VSpacer());
      baseInfoPanel.add(new VSpacer());

      //VLAN Setting
      vlanPanel = new Dot3OnuEtherPortVlanPanel(fApplication);

      JTabbedPane tabbedPane = new JTabbedPane();
      tabbedPane.add(fStringMap.getString("Basic_Info"), baseInfoPanel);
      tabbedPane.add(fStringMap.getString("VLAN_Translation_Panel"), vlanPanel);

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(tabbedPane);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm()
    {
        tfUtsDot3OnuEtherPortVlanTag.setValueScope(0, 4094);
    }

    public boolean validateFrom()
    {
      try
      {
          Integer theValue = Integer.valueOf(tfUtsDot3OnuEtherPortVlanTPID.getText(), 16);
          if (theValue.intValue() < 0 || theValue.intValue() > 65535)
          {
              MessageDialog.showInfoMessageDialog(fApplication,
                  utsDot3OnuEtherPortVlanTPID + fStringMap.getString("Err_hex"));
              return false;
          }
      }
      catch (Exception e)
      {
          MessageDialog.showInfoMessageDialog(fApplication,
              utsDot3OnuEtherPortVlanTPID + fStringMap.getString("Err_hex"));
          return false;
      }

      if(vlanPanel.isEnabled() && vlanPanel.isNull()) {
        MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Vlan_Translation_0"));
        return false;
      }

//      return vlanPanel.validateFrom();
      return true;
    }

    public void refresh()
    {
        VlanModeConfigMBean mbean = (VlanModeConfigMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
        tfUtsDot3OnuPortId.setText( "" + mbean.getUtsDot3OnuPortId());
        tfUtsDot3OnuLogicalPortId.setText("" + mbean.getUtsDot3OnuLogicalPortId());
        tfUtsDot3OnuEtherPortIndex.setText("" + mbean.getUtsDot3OnuEtherPortIndex());

        tfUtsDot3OnuEtherPortVlanMode.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortVlanModeVList, mbean.getUtsDot3OnuEtherPortVlanMode().intValue()));
        tfUtsDot3OnuEtherPortVlanTag.setValue(mbean.getUtsDot3OnuEtherPortVlanTag().intValue());
      tfUtsDot3OnuEtherPortVlanTPID.setValue(Integer.toHexString(mbean.getUtsDot3OnuEtherPortVlanTPID().intValue()));

      vlanPanel.clear();
      vlanPanel.setVlanTranslation(mbean.getUtsDot3OnuEtherPortVlanNTo1Translation());
      vlanPanel.setVlanTranslation(mbean.getUtsDot3OnuEtherPortVlanTranslation());
    }

    public void updateModel()
    {
        VlanModeConfigMBean mbean = (VlanModeConfigMBean) getModel();

        mbean.setUtsDot3OnuEtherPortVlanMode(new Integer(utsDot3OnuEtherPortVlanModeVList[tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex()]));

      if(tfUtsDot3OnuEtherPortVlanTag.isEnabled())
        mbean.setUtsDot3OnuEtherPortVlanTag(new Integer(tfUtsDot3OnuEtherPortVlanTag.getValue()));

      if(tfUtsDot3OnuEtherPortVlanTPID.isEnabled())
        mbean.setUtsDot3OnuEtherPortVlanTPID(Integer.valueOf(tfUtsDot3OnuEtherPortVlanTPID.getText(), 16));

      if(vlanPanel.isEnabled()){
        vlanPanel.calculate();

        if(!isNull(vlanPanel.getVlanNTo1Translation()))
          mbean.setUtsDot3OnuEtherPortVlanNTo1Translation(vlanPanel.getVlanNTo1Translation());

        if(!isNull(vlanPanel.getVlanTranslation())){
          byte[] vlanList = new byte[64];

          byte[] b = vlanPanel.getVlanTranslation();

          int index = 0;
          for(int i = 0; i < b.length; i++) {
            if(b[i] != 0) {
              break;
            } else {
              index++;
            }
          }

          System.arraycopy(b, index, vlanList, 0, b.length - index);
          mbean.setUtsDot3OnuEtherPortVlanTranslation(vlanList);
        }
      }
    }

  boolean isNull(byte[] b) {
    for(int i = 0; i < b.length; i++) {
      if(b[i] != 0) return false;
    }

    return true;
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

  public void actionPerformed(ActionEvent e) {
    if(tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex() == 0) {//
      tfUtsDot3OnuEtherPortVlanTag.setEnabled(false);
      tfUtsDot3OnuEtherPortVlanTPID.setEnabled(false);
      tfUtsDot3OnuEtherPortVlanTPID.setValue("0");
      vlanPanel.setEnabled(false);
    } else if (tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex() == 1){
      tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
      tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
      tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
      vlanPanel.setEnabled(false);
    }else {
      tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
      tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
      tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
      vlanPanel.setEnabled(true);
    }
  }
}

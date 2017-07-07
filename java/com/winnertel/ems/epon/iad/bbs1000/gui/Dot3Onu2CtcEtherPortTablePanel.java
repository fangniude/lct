/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs1000.gui;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.Dot3OnuEtherPortVlanPanel;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.Dot3OnuEtherPortVlanListPanel;
import com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcEtherPortTable;

/**
 * The Dot3Onu2CtcEtherPortTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2CtcEtherPortTablePanel extends UPanel {

  private JLabel tfUtsDot3OnuModuleId = new JLabel();

//  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

  private JLabel tfUtsDot3OnuPortId = new JLabel();

  private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

  private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

  private int[] utsDot3OnuEtherPortPhyAdminCtrlVList = new int[]{
    2, 1, };
  private String[] utsDot3OnuEtherPortPhyAdminCtrlTList = new String[]{
    fStringMap.getString("activate"),
    fStringMap.getString("deactivate"),
  };
  private JComboBox tfUtsDot3OnuEtherPortPhyAdminCtrl = new JComboBox(utsDot3OnuEtherPortPhyAdminCtrlTList);

  private int[] utsDot3OnuEtherPortAutoNegAdminCtrlVList = new int[]{
    2, 1, };
  private String[] utsDot3OnuEtherPortAutoNegAdminCtrlTList = new String[]{
    fStringMap.getString("activate"),
    fStringMap.getString("deactivate"),
  };
  private JComboBox tfUtsDot3OnuEtherPortAutoNegAdminCtrl = new JComboBox(utsDot3OnuEtherPortAutoNegAdminCtrlTList);

  private int[] utsDot3OnuEtherPortPauseVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuEtherPortPauseTList = new String[]{
    fStringMap.getString("disable"),
    fStringMap.getString("enable"),
  };
  private JComboBox tfUtsDot3OnuEtherPortPause = new JComboBox(utsDot3OnuEtherPortPauseTList);
  private int[] utsDot3OnuEtherPortPolicingEnableVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuEtherPortPolicingEnableTList = new String[]{
    fStringMap.getString("true"),
    fStringMap.getString("false"),
  };
  private JComboBox tfUtsDot3OnuEtherPortPolicingEnable = new JComboBox(utsDot3OnuEtherPortPolicingEnableTList);
  private JComboBox tfUtsDot3OnuEtherPortPolicingCIR = null;
  private JComboBox tfUtsDot3OnuEtherPortPolicingCBS = null;

  private IntegerTextField tfUtsDot3OnuEtherPortPolicingEBS = new IntegerTextField();

  private int[] utsDot3OnuEtherPortVlanModeVList = new int[]{ 1, 2, 3, 4 };

  private String[] utsDot3OnuEtherPortVlanModeTList = new String[]{
    fStringMap.getString("transparent"),
    fStringMap.getString("tag"),
    fStringMap.getString("translation"),
    fStringMap.getString("vlanStacking")
  };
  private JComboBox tfUtsDot3OnuEtherPortVlanMode = new JComboBox(utsDot3OnuEtherPortVlanModeTList);
  private StringTextField tfUtsDot3OnuEtherPortVlanTPID = new StringTextField();

  private IntegerTextField tfUtsDot3OnuEtherPortVlanTag = new IntegerTextField();

//  private IntegerTextField tfUtsDot3OnuEtherPortVlanDefTag = new IntegerTextField();

//  private IntegerTextField tfUtsDot3OnuEtherPortMaxMcGroupNum = new IntegerTextField();

  private int[] utsDot3OnuEtherPortMaxMcTagStripeVList = new int[]{
    1, 2, };
  private String[] utsDot3OnuEtherPortMaxMcTagStripeTList = new String[]{
    fStringMap.getString("enable"),
    fStringMap.getString("disable"),
  };
  private JComboBox tfUtsDot3OnuEtherPortMaxMcTagStripe = new JComboBox(utsDot3OnuEtherPortMaxMcTagStripeTList);

  private Dot3OnuEtherPortVlanPanel vlanPanel = null;
  private Dot3OnuEtherPortVlanListPanel vlanListPanel = null;

  private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
//  private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3OnuEtherPortIndex = fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";
  private final String utsDot3OnuEtherPortPhyAdminCtrl = fStringMap.getString("utsDot3OnuEtherPortPhyAdminCtrl") + " : ";
  private final String utsDot3OnuEtherPortAutoNegAdminCtrl = fStringMap.getString("utsDot3OnuEtherPortAutoNegAdminCtrl") + " : ";
  private final String utsDot3OnuEtherPortPause = fStringMap.getString("utsDot3OnuEtherPortPause") + " : ";
  private final String utsDot3OnuEtherPortPolicingEnable = fStringMap.getString("utsDot3OnuEtherPortPolicingEnable") + " : ";
  private final String utsDot3OnuEtherPortPolicingCIR = fStringMap.getString("utsDot3OnuEtherPortPolicingCIR") + " : ";
  private final String utsDot3OnuEtherPortPolicingCBS = fStringMap.getString("utsDot3OnuEtherPortPolicingCBS") + " : ";
  private final String utsDot3OnuEtherPortPolicingEBS = fStringMap.getString("utsDot3OnuEtherPortPolicingEBS") + " : ";
  private final String utsDot3OnuEtherPortVlanMode = fStringMap.getString("utsDot3OnuEtherPortVlanMode") + " : ";
  private final String utsDot3OnuEtherPortVlanTPID = fStringMap.getString("utsDot3OnuEtherPortVlanTPID") + " : ";
  private final String utsDot3OnuEtherPortVlanTag = fStringMap.getString("utsDot3OnuEtherPortVlanTag") + " : ";
//  private final String utsDot3OnuEtherPortVlanDefTag = fStringMap.getString("utsDot3OnuEtherPortVlanDefTag") + " : ";
//  private final String utsDot3OnuEtherPortMaxMcGroupNum = fStringMap.getString("utsDot3OnuEtherPortMaxMcGroupNum") + " : ";
  private final String utsDot3OnuEtherPortMaxMcTagStripe = fStringMap.getString("utsDot3OnuEtherPortMaxMcTagStripe") + " : ";


  public Dot3Onu2CtcEtherPortTablePanel(IApplication app) {
    super(app);

    init();
  }

  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(15, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
    baseInfoPanel.add(tfUtsDot3OnuModuleId);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId));
//    baseInfoPanel.add(tfUtsDot3OnuDeviceId);
//    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
    baseInfoPanel.add(tfUtsDot3OnuPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
    baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPhyAdminCtrl));
    tfUtsDot3OnuEtherPortPhyAdminCtrl.setName(fStringMap.getString("utsDot3OnuEtherPortPhyAdminCtrl"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortPhyAdminCtrl);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortAutoNegAdminCtrl));
    tfUtsDot3OnuEtherPortAutoNegAdminCtrl.setName(fStringMap.getString("utsDot3OnuEtherPortAutoNegAdminCtrl"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortAutoNegAdminCtrl);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPause));
    tfUtsDot3OnuEtherPortPause.setName(fStringMap.getString("utsDot3OnuEtherPortPause"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortPause);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingEnable));
    tfUtsDot3OnuEtherPortPolicingEnable.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingEnable"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingEnable);
    baseInfoPanel.add(new HSpacer());

    tfUtsDot3OnuEtherPortPolicingEnable.addItemListener( new ItemListener() {
    	public void itemStateChanged(ItemEvent itemevent) {
    		toggleEnableDisable();
    	}
    });

    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingCIR));
    Vector tmpVec = new Vector(127);
    for ( int i = 1000; i <= 127000; i+=1000 ) {
    	tmpVec.add( new Integer(i) );
    }
    tfUtsDot3OnuEtherPortPolicingCIR = new JComboBox(tmpVec);
    tfUtsDot3OnuEtherPortPolicingCIR.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingCIR"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingCIR);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingCBS));
    tmpVec = new Vector();
    for ( int i = 0; i <= 65280; i+=256 ) {
    	tmpVec.add( new Integer(i) );
    }
    tfUtsDot3OnuEtherPortPolicingCBS = new JComboBox(tmpVec);
    tfUtsDot3OnuEtherPortPolicingCBS.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingCBS"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingCBS);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingEBS));
    tfUtsDot3OnuEtherPortPolicingEBS.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingEBS"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingEBS);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanMode));
    tfUtsDot3OnuEtherPortVlanMode.setName(fStringMap.getString("utsDot3OnuEtherPortVlanMode"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanMode);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTPID));
    tfUtsDot3OnuEtherPortVlanTPID.setName(fStringMap.getString("utsDot3OnuEtherPortVlanTPID"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTPID);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTag));
    tfUtsDot3OnuEtherPortVlanTag.setName(fStringMap.getString("utsDot3OnuEtherPortVlanTag"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTag);
    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanDefTag));
//    tfUtsDot3OnuEtherPortVlanDefTag.setName(fStringMap.getString("utsDot3OnuEtherPortVlanDefTag"));
//    baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanDefTag);
//    baseInfoPanel.add(new HSpacer());


//    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortMaxMcGroupNum));
//    tfUtsDot3OnuEtherPortMaxMcGroupNum.setName(fStringMap.getString("utsDot3OnuEtherPortMaxMcGroupNum"));
//    baseInfoPanel.add(tfUtsDot3OnuEtherPortMaxMcGroupNum);
//    baseInfoPanel.add(new HSpacer());
//

    baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortMaxMcTagStripe));
    tfUtsDot3OnuEtherPortMaxMcTagStripe.setName(fStringMap.getString("utsDot3OnuEtherPortMaxMcTagStripe"));
    baseInfoPanel.add(tfUtsDot3OnuEtherPortMaxMcTagStripe);
    baseInfoPanel.add(new HSpacer());

    //VLAN Setting
    vlanPanel = new Dot3OnuEtherPortVlanPanel(fApplication);
    vlanListPanel = new Dot3OnuEtherPortVlanListPanel(fApplication);

    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.add(fStringMap.getString("Basic_Info"), baseInfoPanel);
    tabbedPane.add(fStringMap.getString("VLAN_Translation_Panel"), vlanPanel);
    tabbedPane.add(fStringMap.getString("Multicast_Vlan_Panel"), vlanListPanel);


    JPanel allPanel = new JPanel();
    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(tabbedPane);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);
  }

  protected void initForm() {
    tfUtsDot3OnuEtherPortPolicingEBS.setValueScope(0, 512);
//    tfUtsDot3OnuEtherPortMaxMcGroupNum.setValueScope(4, 16);
    tfUtsDot3OnuEtherPortVlanTag.setValueScope(1, 4094);
  }

  public boolean validateFrom() {
      try{
          Integer theValue = Integer.valueOf(tfUtsDot3OnuEtherPortVlanTPID.getText(),16);
          if (theValue.intValue()<0 ||theValue.intValue()>65535){
              MessageDialog.showInfoMessageDialog(fApplication, utsDot3OnuEtherPortVlanTPID +fStringMap.getString("Err_hex"));
              return false;
          }
      }catch(Exception e){
          MessageDialog.showInfoMessageDialog(fApplication,utsDot3OnuEtherPortVlanTPID + fStringMap.getString("Err_hex"));
          return false;
      }

      return vlanPanel.validateFrom();
  }

  public void toggleEnableDisable() {
	    if ( tfUtsDot3OnuEtherPortPolicingEnable.getSelectedIndex() == 1 ) {
	    	tfUtsDot3OnuEtherPortPolicingCIR.setEnabled( false );
	    	tfUtsDot3OnuEtherPortPolicingCBS.setEnabled( false );
	    	tfUtsDot3OnuEtherPortPolicingEBS.setEnabled( false );
	    } else {
	    	tfUtsDot3OnuEtherPortPolicingCIR.setEnabled( true );
	    	tfUtsDot3OnuEtherPortPolicingCBS.setEnabled( true );
	    	tfUtsDot3OnuEtherPortPolicingEBS.setEnabled( true );
	    }
  }

  public void refresh() {

    Dot3Onu2CtcEtherPortTable mbean = (Dot3Onu2CtcEtherPortTable) getModel();

    tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
//    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
    tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
    tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
    tfUtsDot3OnuEtherPortIndex.setText(mbean.getUtsDot3OnuEtherPortIndex().toString());
    tfUtsDot3OnuEtherPortPhyAdminCtrl.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortPhyAdminCtrlVList, mbean.getUtsDot3OnuEtherPortPhyAdminCtrl().intValue()));
    tfUtsDot3OnuEtherPortAutoNegAdminCtrl.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortAutoNegAdminCtrlVList, mbean.getUtsDot3OnuEtherPortAutoNegAdminCtrl().intValue()));
    tfUtsDot3OnuEtherPortPause.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortPauseVList, mbean.getUtsDot3OnuEtherPortPause().intValue()));
    tfUtsDot3OnuEtherPortPolicingEnable.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortPolicingEnableVList, mbean.getUtsDot3OnuEtherPortPolicingEnable().intValue()));

    int tmpIntValue = mbean.getUtsDot3OnuEtherPortPolicingCIR().intValue() / 1000 - 1;
    tfUtsDot3OnuEtherPortPolicingCIR.setSelectedIndex( tmpIntValue >= 0 ? tmpIntValue : 0 );

    tmpIntValue = mbean.getUtsDot3OnuEtherPortPolicingCBS().intValue() / 256 - 1;
    tfUtsDot3OnuEtherPortPolicingCBS.setSelectedIndex( tmpIntValue >= 0 ? tmpIntValue : 0 );

    tfUtsDot3OnuEtherPortPolicingEBS.setValue(mbean.getUtsDot3OnuEtherPortPolicingEBS().intValue());
    tfUtsDot3OnuEtherPortVlanMode.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortVlanModeVList, mbean.getUtsDot3OnuEtherPortVlanMode().intValue()));
    tfUtsDot3OnuEtherPortVlanTPID.setValue(Integer.toHexString(mbean.getUtsDot3OnuEtherPortVlanTPID().intValue()));
    tfUtsDot3OnuEtherPortVlanTag.setValue(mbean.getUtsDot3OnuEtherPortVlanTag().intValue());
//    tfUtsDot3OnuEtherPortVlanDefTag.setValue(mbean.getUtsDot3OnuEtherPortVlanDefTag().intValue());
//    tfUtsDot3OnuEtherPortMaxMcGroupNum.setValue(mbean.getUtsDot3OnuEtherPortMaxMcGroupNum().intValue());
    tfUtsDot3OnuEtherPortMaxMcTagStripe.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortMaxMcTagStripeVList, mbean.getUtsDot3OnuEtherPortMaxMcTagStripe().intValue()));

    toggleEnableDisable();

    vlanPanel.setVlanTranslation(mbean.getUtsDot3OnuEtherPortVlanTranslation());
    vlanListPanel.setMulticastVlanList(mbean.getUtsDot3OnuEtherPortMVlanList());
  }

  public void updateModel() {

    Dot3Onu2CtcEtherPortTable mbean = (Dot3Onu2CtcEtherPortTable) getModel();

    mbean.setUtsDot3OnuEtherPortPhyAdminCtrl(new Integer(utsDot3OnuEtherPortPhyAdminCtrlVList[tfUtsDot3OnuEtherPortPhyAdminCtrl.getSelectedIndex()]));
    mbean.setUtsDot3OnuEtherPortAutoNegAdminCtrl(new Integer(utsDot3OnuEtherPortAutoNegAdminCtrlVList[tfUtsDot3OnuEtherPortAutoNegAdminCtrl.getSelectedIndex()]));
    mbean.setUtsDot3OnuEtherPortPause(new Integer(utsDot3OnuEtherPortPauseVList[tfUtsDot3OnuEtherPortPause.getSelectedIndex()]));
    mbean.setUtsDot3OnuEtherPortPolicingEnable(new Integer(utsDot3OnuEtherPortPolicingEnableVList[tfUtsDot3OnuEtherPortPolicingEnable.getSelectedIndex()]));
    mbean.setUtsDot3OnuEtherPortPolicingCIR( (Integer)tfUtsDot3OnuEtherPortPolicingCIR.getSelectedItem());
    mbean.setUtsDot3OnuEtherPortPolicingCBS( (Integer)tfUtsDot3OnuEtherPortPolicingCBS.getSelectedItem());
    mbean.setUtsDot3OnuEtherPortPolicingEBS(new Integer(tfUtsDot3OnuEtherPortPolicingEBS.getValue()));
    mbean.setUtsDot3OnuEtherPortVlanMode(new Integer(utsDot3OnuEtherPortVlanModeVList[tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex()]));
      mbean.setUtsDot3OnuEtherPortVlanTPID(Integer.valueOf(tfUtsDot3OnuEtherPortVlanTPID.getText(),16));
    mbean.setUtsDot3OnuEtherPortVlanTag(new Integer(tfUtsDot3OnuEtherPortVlanTag.getValue()));
//    mbean.setUtsDot3OnuEtherPortVlanDefTag(new Integer(tfUtsDot3OnuEtherPortVlanDefTag.getValue()));
//    mbean.setUtsDot3OnuEtherPortMaxMcGroupNum(new Integer(tfUtsDot3OnuEtherPortMaxMcGroupNum.getValue()));
    mbean.setUtsDot3OnuEtherPortMaxMcTagStripe(new Integer(utsDot3OnuEtherPortMaxMcTagStripeVList[tfUtsDot3OnuEtherPortMaxMcTagStripe.getSelectedIndex()]));

    mbean.setUtsDot3OnuEtherPortVlanTranslation(vlanPanel.getVlanTranslation());
    mbean.setUtsDot3OnuEtherPortMVlanList(vlanListPanel.getMulticastVlanList());
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}

/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcEtherPortTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2CtcEtherPortTablePanel class.
 * Created by DVM Creator
 */
public class Dot3Onu2CtcEtherPortTablePanel extends UPanel {

  private JLabel tfUtsDot3OnuModuleId = new JLabel();

//  private JLabel tfUtsDot3OnuDeviceId = new JLabel();

  private Integer[] portList = new Integer[] {1,2,3,4};
  private JComboBox tfUtsDot3OnuPortId = new JComboBox( portList );

  
  private JComboBox tfUtsDot3OnuLogicalPortId = new JComboBox();

  private IntegerTextField tfUtsDot3OnuEtherPortIndex = new IntegerTextField();

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

  private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
//  private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
  private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
  private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
  private final String utsDot3OnuEtherPortIndex = fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";
  private final String utsDot3OnuEtherPortPhyAdminCtrl = fStringMap.getString("utsDot3OnuEtherPortPhyAdminCtrl") + " : ";
  private final String utsDot3OnuEtherPortAutoNegAdminCtrl = fStringMap.getString("utsDot3OnuEtherPortAutoNegAdminCtrl") + " : ";

  BBS4000NE bbs4000NE;
  public Dot3Onu2CtcEtherPortTablePanel(IApplication app) {
    super(app);

    bbs4000NE = new BBS4000NE( app );
    init();
  }

  private Integer[] getLogicalPortList( ) {
	  int number =  bbs4000NE.getPonSplitRatio();
	  Integer[] logicalPorts = new Integer[ number ];
	  
	  for( int i = 1; i<= number; i ++ ) {
		  logicalPorts[i-1] = new Integer(i );
	  }
	  
	  return logicalPorts;
  }
  
  public void initGui() {

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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


    tfUtsDot3OnuLogicalPortId.setModel( new DefaultComboBoxModel( getLogicalPortList( ) ));    
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

  public boolean validateFrom() {
    return true;
  }

  public void refresh() {

    Dot3Onu2CtcEtherPortTable mbean = (Dot3Onu2CtcEtherPortTable) getModel();

    tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
//    tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
    //tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
    tfUtsDot3OnuPortId.setSelectedItem( mbean.getUtsDot3OnuPortId() );
    //tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
    tfUtsDot3OnuLogicalPortId.setSelectedItem( mbean.getUtsDot3OnuLogicalPortId() );
    tfUtsDot3OnuEtherPortIndex.setValue(mbean.getUtsDot3OnuEtherPortIndex());
    tfUtsDot3OnuEtherPortPhyAdminCtrl.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortPhyAdminCtrlVList, mbean.getUtsDot3OnuEtherPortPhyAdminCtrl().intValue()));
    tfUtsDot3OnuEtherPortAutoNegAdminCtrl.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortAutoNegAdminCtrlVList, mbean.getUtsDot3OnuEtherPortAutoNegAdminCtrl().intValue()));
    
    tfUtsDot3OnuModuleId.setEnabled(false);
	tfUtsDot3OnuPortId.setEnabled(false);
	tfUtsDot3OnuLogicalPortId.setEnabled(false);
	tfUtsDot3OnuEtherPortIndex.setEnabled(false);
  }

  public void updateModel() {

    Dot3Onu2CtcEtherPortTable mbean = (Dot3Onu2CtcEtherPortTable) getModel();
	mbean.setUtsDot3OnuPortId( (Integer)tfUtsDot3OnuPortId.getSelectedItem());
	mbean.setUtsDot3OnuLogicalPortId( (Integer)tfUtsDot3OnuLogicalPortId.getSelectedItem() );
	mbean.setUtsDot3OnuEtherPortIndex( tfUtsDot3OnuEtherPortIndex.getValue() );
    mbean.setUtsDot3OnuEtherPortPhyAdminCtrl(new Integer(utsDot3OnuEtherPortPhyAdminCtrlVList[tfUtsDot3OnuEtherPortPhyAdminCtrl.getSelectedIndex()]));
    mbean.setUtsDot3OnuEtherPortAutoNegAdminCtrl(new Integer(utsDot3OnuEtherPortAutoNegAdminCtrlVList[tfUtsDot3OnuEtherPortAutoNegAdminCtrl.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }
}
    
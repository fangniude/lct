package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.OnuTreePanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.ONUManualUpgradeTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ONUManualUpgradePanel class.
 * Created by DVM Creator
 */
public class ONUManualUpgradePanel extends UPanel {

    private OnuTreePanel trONUListTree;

//    private String[] utsDot3OnuFWUpgradeOptionTList = new String[]{
//        fStringMap.getString("normal"),
//        fStringMap.getString("force"),
//    };
//    
    private JCheckBox tfUtsDot3OnuFWUpgradeOption = new JCheckBox(fStringMap.getString("force"));
 //   private JComboBox tfUtsDot3OnuFWUpgradeOption = new JComboBox(utsDot3OnuFWUpgradeOptionTList);

    private final String utsDot3OnuFWUpgradeOption = fStringMap.getString("utsDot3OnuFWUpgradeOption") + " : ";

    public ONUManualUpgradePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
      JPanel baseInfoPanel = new JPanel();
      NTLayout layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
      layout.setMargins(6, 10, 6, 10);
      baseInfoPanel.setLayout(layout);
      baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

      JPanel optionPanel = new JPanel();
      layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.FILL, 5, 5);
      layout.setMargins(6, 10, 6, 10);
      optionPanel.setLayout(layout);
      optionPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Upgrade_Mode")));
      optionPanel.add(new JLabel(utsDot3OnuFWUpgradeOption));
      optionPanel.add(tfUtsDot3OnuFWUpgradeOption);
      optionPanel.add(new HSpacer());

      baseInfoPanel.add(optionPanel);

      trONUListTree = new OnuTreePanel(fApplication);
      baseInfoPanel.add(trONUListTree);

      JPanel allPanel = new JPanel();
      layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
      layout.setMargins(6, 10, 6, 10);
      allPanel.setLayout(layout);
      allPanel.add(baseInfoPanel);
      allPanel.add(new VSpacer());
      setLayout(new BorderLayout());
      add(allPanel, BorderLayout.CENTER);
      this.setPreferredSize(new Dimension(400, 400));
     }

    protected void initForm() {
    }

    public void refresh() {
        trONUListTree.init();
    }

    public boolean validateFrom(){
      return true;
    }

    public void updateModel() {
        byte[] bitmap = trONUListTree.getSelectedOnuBitMap();
        ONUManualUpgradeTableMBean mbean = new ONUManualUpgradeTableMBean(fApplication.getSnmpProxy());
        //if(tfUtsDot3OnuFWUpgradeOption.getSelectedIndex() == 0) //normal
        if(tfUtsDot3OnuFWUpgradeOption.isSelected()) //force
        {
          mbean.setUtsDot3OnuUpgradeForceManualPortListBitMap(bitmap);
        }
        else
        {
          mbean.setUtsDot3OnuUpgradeNormalManualPortListBitMap(bitmap);
        }

        setModel(mbean);
    }
}

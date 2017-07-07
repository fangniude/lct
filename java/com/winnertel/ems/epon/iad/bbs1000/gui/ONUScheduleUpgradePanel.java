package com.winnertel.ems.epon.iad.bbs1000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.ems.epon.iad.bbs1000.gui.swing.OnuTreePanel;
import com.winnertel.ems.epon.iad.bbs1000.mib.ONUScheduleUpgradeTableMBean;

import javax.swing.*;

import java.awt.*;
import java.util.Vector;

/**
 * The ONUUpgradeResultTableMBeanPanel class.
 * Created by DVM Creator
 */
public class ONUScheduleUpgradePanel extends UPanel {

    private OnuTreePanel onuTreePanel;

    private IntegerTextField tfUtsDot3OnuFWUpgradeResultStartingMinute = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuFWUpgradeResultStartingHour = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuFWUpgradeResultDuration = new IntegerTextField();

//    private String[] utsDot3OnuFWUpgradeOptionTList = new String[]{
//        fStringMap.getString("normal"),
//        fStringMap.getString("force"),
//    };
//    private JComboBox tfUtsDot3OnuFWUpgradeOption = new JComboBox(utsDot3OnuFWUpgradeOptionTList);
    private JCheckBox tfUtsDot3OnuFWUpgradeOption = new JCheckBox(fStringMap.getString("force"));
    private final String utsDot3OnuFWUpgradeResultStartingHour = fStringMap.getString("utsDot3OnuFWUpgradeResultStartingHour") + " : ";
    private final String utsDot3OnuFWUpgradeResultStartingMinute = fStringMap.getString("utsDot3OnuFWUpgradeResultStartingMinute") + " : ";
    private final String utsDot3OnuFWUpgradeDuration = fStringMap.getString("utsDot3OnuFWUpgradeDuration") + " : ";
    private final String utsDot3OnuFWUpgradeOption = fStringMap.getString("utsDot3OnuFWUpgradeOption") + " : ";

    public ONUScheduleUpgradePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel timePanel = new JPanel();
        layout = new NTLayout(2, 4, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        timePanel.setLayout(layout);
        timePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Schedule_Configure")));

        timePanel.add(new JLabel(utsDot3OnuFWUpgradeResultStartingHour));
        timePanel.add(tfUtsDot3OnuFWUpgradeResultStartingHour);
        timePanel.add(new JLabel(utsDot3OnuFWUpgradeResultStartingMinute));
        timePanel.add(tfUtsDot3OnuFWUpgradeResultStartingMinute);

        timePanel.add(new JLabel(utsDot3OnuFWUpgradeDuration));
        timePanel.add(tfUtsDot3OnuFWUpgradeResultDuration);
        timePanel.add(new HSpacer());
        timePanel.add(new HSpacer());

        JPanel optionPanel = new JPanel();
        layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        optionPanel.setLayout(layout);
        optionPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Upgrade_Mode")));
        optionPanel.add(new JLabel(utsDot3OnuFWUpgradeOption));
        optionPanel.add(tfUtsDot3OnuFWUpgradeOption);
        optionPanel.add(new HSpacer());

        baseInfoPanel.add(timePanel);
        baseInfoPanel.add(optionPanel);
        onuTreePanel = new OnuTreePanel(fApplication);
        baseInfoPanel.add(onuTreePanel);

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(500, 500));
    }


    protected void initForm() {
        tfUtsDot3OnuFWUpgradeResultStartingHour.setValueScope(0, 23);
        tfUtsDot3OnuFWUpgradeResultStartingHour.setDefaultValue(0);
        tfUtsDot3OnuFWUpgradeResultStartingMinute.setValueScope(0, 59);
        tfUtsDot3OnuFWUpgradeResultStartingMinute.setDefaultValue(0);
        tfUtsDot3OnuFWUpgradeResultDuration.setValueScope(10, 600);
        tfUtsDot3OnuFWUpgradeResultDuration.setDefaultValue(30);
    }

    public void refresh() {
    }

    public boolean validateFrom(){
      int hour = tfUtsDot3OnuFWUpgradeResultStartingHour.getValue();
    	int minu = tfUtsDot3OnuFWUpgradeResultStartingMinute.getValue();
    	int dura = tfUtsDot3OnuFWUpgradeResultDuration.getValue();

    	int begin = hour * 60 + minu;
    	int end = begin + dura;
      ONUScheduleUpgradeTableMBean mbean = new ONUScheduleUpgradeTableMBean(fApplication.getSnmpProxy());
    	Vector v = null;
      try {
          v = mbean.retrieveAll();
      } catch (MibBeanException e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
      if(v!=null){
          for (int i=0; i<v.size(); i++) {
              ONUScheduleUpgradeTableMBean one = (ONUScheduleUpgradeTableMBean)v.get(i);
              int tempHour = one.getUtsDot3OnuFWUpgradeStartingHour().intValue();
              int tempMinu = one.getUtsDot3OnuFWUpgradeStartingMinute().intValue();
              int tempDura = one.getUtsDot3OnuFWUpgradeDuration().intValue();
              int tempBegin = tempHour * 60 + tempMinu;
              int tempEnd = tempBegin + tempDura + 1;
              if ((begin > tempBegin && begin < tempEnd) || (end > tempBegin && end < tempEnd)) {
                  String str = fStringMap.getString("Err_Schedule_Time_Is_Wrong");
                  MessageDialog.showErrorMessageDialog(fApplication, str);
                  return false;
              }
          }
        }
    	return true;
    }

    public void updateModel() {
        byte[] bitmap = onuTreePanel.getSelectedOnuBitMap();
        ONUScheduleUpgradeTableMBean mbean = new ONUScheduleUpgradeTableMBean(fApplication.getSnmpProxy());
        mbean.setUtsDot3OnuFWUpgradeStartingHour(new Integer(tfUtsDot3OnuFWUpgradeResultStartingHour.getValue()));
        mbean.setUtsDot3OnuFWUpgradeStartingMinute(new Integer(tfUtsDot3OnuFWUpgradeResultStartingMinute.getValue()));
        mbean.setUtsDot3OnuFWUpgradePortListBitMap(bitmap);
        mbean.setUtsDot3OnuFWUpgradeDuration(new Integer(tfUtsDot3OnuFWUpgradeResultDuration.getValue()));
       // mbean.setUtsDot3OnuFWUpgradeOption(new Integer(tfUtsDot3OnuFWUpgradeOption.getSelectedIndex()+1));
        if(tfUtsDot3OnuFWUpgradeOption.isSelected()){ //force
          mbean.setUtsDot3OnuFWUpgradeOption(new Integer(2));
        }else{
          mbean.setUtsDot3OnuFWUpgradeOption(new Integer(1));
        }
        setModel(mbean);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }
}

package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.TCAConfig;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class TCAConfigPanel extends UPanel{
  
  private IntegerTextField tfUtsBBSSysCpuUtilityAlarmThresholdTotal = new IntegerTextField();
  private IntegerTextField tfUtsBBSSysCpuUtilityAlarmThresholdPerTask = new IntegerTextField();
  private IntegerTextField tfUtsBBSSysMemoryUtilityAlarmThreshold = new IntegerTextField();
 
  
  private final String utsBBSSysCpuUtilityAlarmThresholdTotal = fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdTotal") + " : ";
  private final String utsBBSSysCpuUtilityAlarmThresholdPerTask = fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdPerTask") + " : ";
  private final String utsBBSSysMemoryUtilityAlarmThreshold = fStringMap.getString("utsBBSSysMemoryUtilityAlarmThreshold") + " : ";
 
  
  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;
  
  public TCAConfigPanel(IApplication app) {
    super(app);
    setModel(new TCAConfig(app.getSnmpProxy()));
    init();
  }
  
  public void initGui() {
    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_TCAConfig");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER,
        5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());
    
    baseInfoPanel.add(new JLabel(utsBBSSysCpuUtilityAlarmThresholdTotal));
    tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setName(fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdTotal"));
    baseInfoPanel.add(tfUtsBBSSysCpuUtilityAlarmThresholdTotal);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSSysCpuUtilityAlarmThresholdPerTask));
    tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setName(fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdPerTask"));
    baseInfoPanel.add(tfUtsBBSSysCpuUtilityAlarmThresholdPerTask);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSSysMemoryUtilityAlarmThreshold));
    tfUtsBBSSysMemoryUtilityAlarmThreshold.setName(fStringMap.getString("utsBBSSysMemoryUtilityAlarmThreshold"));
    baseInfoPanel.add(tfUtsBBSSysMemoryUtilityAlarmThreshold);
    baseInfoPanel.add(new HSpacer());
    
 
    
    JPanel allPanel = new JPanel();
    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.SOUTH);
  }

  protected void initForm() {
    tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setValueScope(0, 100);
    tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setValueScope(0, 100);
    tfUtsBBSSysMemoryUtilityAlarmThreshold.setValueScope(0, 1000);
   
  }
  
  @Override
  public void refresh() {
    TCAConfig mbean = (TCAConfig) getModel();
    BeanService.refreshBean(fApplication, mbean);
    tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setValue(mbean.getUtsBBSSysCpuUtilityAlarmThresholdTotal().intValue());
    tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setValue(mbean.getUtsBBSSysCpuUtilityAlarmThresholdPerTask().intValue());
    tfUtsBBSSysMemoryUtilityAlarmThreshold.setValue(mbean.getUtsBBSSysMemoryUtilityAlarmThreshold().intValue());    
   
  }
  
  public void updateModel() {
    TCAConfig mbean = (TCAConfig) getModel();

    mbean.setUtsBBSSysCpuUtilityAlarmThresholdTotal(new Integer(tfUtsBBSSysCpuUtilityAlarmThresholdTotal.getValue()));
    mbean.setUtsBBSSysCpuUtilityAlarmThresholdPerTask(new Integer(tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.getValue()));
    mbean.setUtsBBSSysMemoryUtilityAlarmThreshold(new Integer(tfUtsBBSSysMemoryUtilityAlarmThreshold.getValue()));
   

  }
  
}

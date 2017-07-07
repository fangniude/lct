package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.LoopbackGlobalSettingBean;
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

public class LoopbackGlobalSettingPanel extends UPanel {
  private IntegerTextField tfUtsBBSMgmtLoopbackDetectIntervalTime = new IntegerTextField();

  private final String utsBBSMgmtLoopbackDetectIntervalTime = fStringMap.getString("utsBBSMgmtLoopbackDetectIntervalTime") + " : ";

  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;


  public LoopbackGlobalSettingPanel(IApplication app) {
    super(app);
    setModel(new LoopbackGlobalSettingBean(fApplication.getSnmpProxy()));
    init();
  }

  public void initGui() {
    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_LoopbackGlobalSettingBean");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5,
        5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsBBSMgmtLoopbackDetectIntervalTime));
    tfUtsBBSMgmtLoopbackDetectIntervalTime.setName(fStringMap.getString("utsBBSMgmtLoopbackDetectIntervalTime"));
    baseInfoPanel.add(tfUtsBBSMgmtLoopbackDetectIntervalTime);
    baseInfoPanel.add(new HSpacer());

    JPanel allPanel = new JPanel();
    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.SOUTH);
  }

  protected void initForm() {
    tfUtsBBSMgmtLoopbackDetectIntervalTime.setValueScope(1, 120);
  }

  public void refresh() {
    LoopbackGlobalSettingBean mbean = (LoopbackGlobalSettingBean) getModel();

    BeanService.refreshBean(fApplication, mbean);

    tfUtsBBSMgmtLoopbackDetectIntervalTime.setValue(mbean.getUtsBBSMgmtLoopbackDetectIntervalTime().intValue() / 60);
  }

  public void updateModel() {
    LoopbackGlobalSettingBean mbean = (LoopbackGlobalSettingBean) getModel();

    mbean.setUtsBBSMgmtLoopbackDetectIntervalTime(new Integer(tfUtsBBSMgmtLoopbackDetectIntervalTime.getValue() * 60));
  }
}

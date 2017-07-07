package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.OnuLoopbackTestGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The DHCPRelayPanel class. Created by DVM Creator
 */
public class OnuLoopbackTestPanel extends UPanel {
  private int[] vList = new int[] {1, 2};

  private String[] tList = new String[]
      {fStringMap.getString("disable"), fStringMap.getString("enable"),};

  private JComboBox tfUtsBBSMgmtLoopbackDetection = new JComboBox(tList);

  private IntegerTextField tfIntervalTime = new IntegerTextField();

  private final String utsBBSMgmtLoopbackDetection = fStringMap.getString("utsBBSMgmtLoopbackDetection") + " : ";
  private final String utsBBSMgmtLoopbackDetectIntervalTime = fStringMap.getString("utsBBSMgmtLoopbackDetectIntervalTime") + " : ";

  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;

  public OnuLoopbackTestPanel(IApplication app) {
    super(app);
    setModel(new OnuLoopbackTestGroup(app.getSnmpProxy()));
    init();
  }

  public void initGui() {
    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_OnuLoopbackTest");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsBBSMgmtLoopbackDetection));
    tfUtsBBSMgmtLoopbackDetection.setName(fStringMap.getString("utsBBSMgmtLoopbackDetection"));
    baseInfoPanel.add(tfUtsBBSMgmtLoopbackDetection);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtLoopbackDetectIntervalTime));
    tfIntervalTime.setName(fStringMap.getString("utsBBSMgmtLoopbackDetectIntervalTime"));
    baseInfoPanel.add(tfIntervalTime);
    baseInfoPanel.add(new HSpacer());

    JPanel allPanel = new JPanel();
    layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(new VSpacer());
    allPanel.add(buttonsPanel);

    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);

    IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
    SnmpTablePane tablepanel1 = (SnmpTablePane) composer.composeSnmpTablePane("OnuLoopbackTestTable_Panel");

    add(tablepanel1, BorderLayout.SOUTH);
    tablepanel1.refresh();
  }

  protected void initForm() {

    tfIntervalTime.setValueScope(1, 15);

  }

  public void refresh() {
    OnuLoopbackTestGroup mbean = (OnuLoopbackTestGroup) getModel();
    BeanService.refreshBean(fApplication, mbean);

    tfUtsBBSMgmtLoopbackDetection.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSMgmtLoopbackDetection().intValue()));
    tfIntervalTime.setValue(mbean.getUtsBBSMgmtLoopbackDetectIntervalTime().intValue());

  }

  public void updateModel() {
    OnuLoopbackTestGroup mbean = (OnuLoopbackTestGroup) getModel();

    mbean.setUtsBBSMgmtLoopbackDetection(new Integer(vList[tfUtsBBSMgmtLoopbackDetection.getSelectedIndex()]));
    mbean.setUtsBBSMgmtLoopbackDetectIntervalTime(new Integer(tfIntervalTime.getValue()));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v)
        return i;
    }
    return 0;
  }

}

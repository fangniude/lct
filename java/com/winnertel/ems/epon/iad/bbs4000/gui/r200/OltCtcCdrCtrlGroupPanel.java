/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OltCtcCdrCtrlGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The OltCtcCdrCtrlGroupPanel class.
 * Created by DVM Creator
 */
public class OltCtcCdrCtrlGroupPanel extends UPanel {

  private IPAddressField tfUtsOltCtcCdrServer = new IPAddressField();

  private IntegerTextField tfUtsOltCtcCdrPort = new IntegerTextField();

  private IntegerTextField tfUtsOltCtcCdrReportInterval = new IntegerTextField();

  private IntegerTextField tfUtsOltCtcCdrReportCount = new IntegerTextField();

  private int[] utsOltCtcCdrReportModeVList = new int[]{ 1, 2, 3, };

  private String[] utsOltCtcCdrReportModeTList = new String[]{
    fStringMap.getString("cdr_periodical"),
    fStringMap.getString("cdr_counting"),
    fStringMap.getString("cdr_force"),
  };

  private JComboBox tfUtsOltCtcCdrReportMode = new JComboBox(utsOltCtcCdrReportModeTList);

  private final String utsOltCtcCdrServer = fStringMap.getString("utsOltCtcCdrServer") + " : ";
  private final String utsOltCtcCdrPort = fStringMap.getString("utsOltCtcCdrPort") + " : ";
  private final String utsOltCtcCdrReportInterval = fStringMap.getString("utsOltCtcCdrReportInterval") + " : ";
  private final String utsOltCtcCdrReportCount = fStringMap.getString("utsOltCtcCdrReportCount") + " : ";
  private final String utsOltCtcCdrReportMode = fStringMap.getString("utsOltCtcCdrReportMode") + " : ";

  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;
  private JButton btReport;

  public OltCtcCdrCtrlGroupPanel(IApplication app) {
    super(app);
    setModel(new OltCtcCdrCtrlGroup(app.getSnmpProxy()));
    init();
  }

  public void initGui() {
    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_OltCtcCdrCtrlGroup");
    btRefresh = new SnmpRefreshButton(fApplication, this);
    JPanel buttonsPanel = new JPanel();

    btReport = new JButton();
    btReport.setText(fStringMap.getString("Force_Report"));
    btReport.setActionCommand("Force_Report");
    btReport.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        if ( !fApplication.isDebug()) {
          ISecurityManager securityManager = fApplication.getSecurityManager();
          ISession session = fApplication.getSession();
          if ( !securityManager.isAuthorized( session, "Force_Report" ) ) {
              MessageDialog.showPermissionDeniedDialog( fApplication );
              return;
          }
        }

        ILogInfo logInfo = fApplication.getLogManager().getLogInfo("Force_Report");

        try
        {
          OltCtcCdrCtrlGroup mbean = (OltCtcCdrCtrlGroup) getModel();
          mbean.forceReport();
          logInfo.setStatus( ILogInfo.COMPLETED );
        }
        catch(Exception ex)
        {
          MessageDialog.showOperationFailedDialog(fApplication);
          logInfo.setStatus( ILogInfo.FAILED );
        }

        fApplication.getLogManager().writeLog(logInfo);
      }
    });
    buttonsPanel.add(btReport);
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsOltCtcCdrServer));
    tfUtsOltCtcCdrServer.setName(fStringMap.getString("utsOltCtcCdrServer"));
    baseInfoPanel.add(tfUtsOltCtcCdrServer);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsOltCtcCdrPort));
    tfUtsOltCtcCdrPort.setName(fStringMap.getString("utsOltCtcCdrPort"));
    baseInfoPanel.add(tfUtsOltCtcCdrPort);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsOltCtcCdrReportInterval));
    tfUtsOltCtcCdrReportInterval.setName(fStringMap.getString("utsOltCtcCdrReportInterval"));
    baseInfoPanel.add(tfUtsOltCtcCdrReportInterval);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsOltCtcCdrReportCount));
    tfUtsOltCtcCdrReportCount.setName(fStringMap.getString("utsOltCtcCdrReportCount"));
    baseInfoPanel.add(tfUtsOltCtcCdrReportCount);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsOltCtcCdrReportMode));
    tfUtsOltCtcCdrReportMode.setName(fStringMap.getString("utsOltCtcCdrReportMode"));
    baseInfoPanel.add(tfUtsOltCtcCdrReportMode);
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
    tfUtsOltCtcCdrPort.setValueScope(1, 65535);
    tfUtsOltCtcCdrReportInterval.setValueScope(10, 3600);
    tfUtsOltCtcCdrReportCount.setValueScope(10, 1000);
  }

  public void refresh() {

    OltCtcCdrCtrlGroup mbean = (OltCtcCdrCtrlGroup) getModel();
    BeanService.refreshBean(fApplication, mbean);

    tfUtsOltCtcCdrServer.setValue(mbean.getUtsOltCtcCdrServer());
    tfUtsOltCtcCdrPort.setValue(mbean.getUtsOltCtcCdrPort().intValue());
    tfUtsOltCtcCdrReportInterval.setValue(mbean.getUtsOltCtcCdrReportInterval().intValue());
    tfUtsOltCtcCdrReportCount.setValue(mbean.getUtsOltCtcCdrReportCount().intValue());
    tfUtsOltCtcCdrReportMode.setSelectedIndex(getIndexFromValue(utsOltCtcCdrReportModeVList, mbean.getUtsOltCtcCdrReportMode().intValue()));
  }

  public void updateModel() {

    OltCtcCdrCtrlGroup mbean = (OltCtcCdrCtrlGroup) getModel();

    mbean.setUtsOltCtcCdrServer(tfUtsOltCtcCdrServer.getIPString());
    mbean.setUtsOltCtcCdrPort(new Integer(tfUtsOltCtcCdrPort.getValue()));
    mbean.setUtsOltCtcCdrReportInterval(new Integer(tfUtsOltCtcCdrReportInterval.getValue()));
    mbean.setUtsOltCtcCdrReportCount(new Integer(tfUtsOltCtcCdrReportCount.getValue()));
    mbean.setUtsOltCtcCdrReportMode(new Integer(utsOltCtcCdrReportModeVList[tfUtsOltCtcCdrReportMode.getSelectedIndex()]));
  }

  public int getIndexFromValue(int[] list, int v) {
    for (int i = 0; i != list.length; i++) {
      if (list[i] == v) return i;
    }
    return 0;
  }

}
    
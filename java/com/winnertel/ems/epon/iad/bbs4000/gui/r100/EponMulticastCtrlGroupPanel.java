package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.EponMulticastCtrlGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.em.framework.model.MibBeanException;
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
import java.util.Vector;

public class EponMulticastCtrlGroupPanel extends UPanel implements ActionListener
{
  private int[] utsEponMulticastCtrlIpmcEnableVList = new int[]
  { 1, 2, };

  private String[] utsEponMulticastCtrlIpmcEnableTList = new String[]
  { fStringMap.getString("enabled"), fStringMap.getString("disabled"), };

  private JComboBox tfUtsEponMulticastCtrlIpmcEnable = new JComboBox(
      utsEponMulticastCtrlIpmcEnableTList);

  private int[] utsEponMulticastCtrlIgmpSnoopingStatusVList = new int[]
  { 1, 2, };

  private String[] utsEponMulticastCtrlIgmpSnoopingStatusTList = new String[]
  { fStringMap.getString("enabled"), fStringMap.getString("disabled"), };

  private JComboBox tfUtsEponMulticastCtrlIgmpSnoopingStatus = new JComboBox(
      utsEponMulticastCtrlIgmpSnoopingStatusTList);

  private int[] utsEponMcastCtrlIgmpProxyStatusVList = new int[]
  { 1, 2, };

  private String[] utsEponMcastCtrlIgmpProxyStatusTList = new String[]
  { fStringMap.getString("enabled"), fStringMap.getString("disabled"), };

  private JComboBox tfUtsEponMcastCtrlIgmpProxyStatus = new JComboBox(
      utsEponMcastCtrlIgmpProxyStatusTList);

  private int[] utsOltCtcMulticastCtrlModeVList = new int[]
  { 1, 2, 3};

  private String[] utsOltCtcMulticastCtrlModeTList = new String[]
  { fStringMap.getString("special-mode"), fStringMap.getString("control-mode"), fStringMap.getString("standard-mode")};

  private JComboBox tfUtsOltCtcMulticastCtrlMode = new JComboBox(
      utsOltCtcMulticastCtrlModeTList);

  private IntegerTextField tfUtsOltNoCdrForShortJoinLeave = new IntegerTextField();
  private IntegerTextField tfUtsOltNoTimeForShortPreview = new IntegerTextField();
  private int[] utsOltAcrossVlanMulticastForwardVList = new int[] { 1, 2, };
  private String[] utsOltAcrossVlanMulticastForwardTList = new String[] { fStringMap.getString("enabled"), fStringMap.getString("disabled"), };
  private JComboBox tfUtsOltAcrossVlanMulticastForward = new JComboBox(utsOltAcrossVlanMulticastForwardTList);
//  private JList tfUtsEponMulticastCtrlSuperVidList = new JList();

  private IntegerTextField tfUtsBBSMgmtLastMembQueryIntvl = new IntegerTextField();
  private IntegerTextField tfUtsBBSMgmtQueryInterval = new IntegerTextField();
  private IntegerTextField tfUtsBBSMgmtQueryMaxRespTime = new IntegerTextField();
  private IntegerTextField tfUtsBBSMgmtRobustness = new IntegerTextField();
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
//
  private final String utsOltCtcCdrServer = fStringMap.getString("utsOltCtcCdrServer") + " : ";
  private final String utsOltCtcCdrPort = fStringMap.getString("utsOltCtcCdrPort") + " : ";
  private final String utsOltCtcCdrReportInterval = fStringMap.getString("utsOltCtcCdrReportInterval") + " : ";
  private final String utsOltCtcCdrReportCount = fStringMap.getString("utsOltCtcCdrReportCount") + " : ";
  private final String utsOltCtcCdrReportMode = fStringMap.getString("utsOltCtcCdrReportMode") + " : ";
  private final String utsOltAcrossVlanMulticastForward = fStringMap.getString("utsOltAcrossVlanMulticastForward") + " : ";
  private final String utsEponMulticastCtrlIpmcEnable = fStringMap.getString("utsEponMulticastCtrlIpmcEnable") + " : ";
  private final String utsEponMulticastCtrlIgmpSnoopingStatus = fStringMap.getString("utsEponMulticastCtrlIgmpSnoopingStatus") + " : ";
  private final String utsEponMcastCtrlIgmpProxyStatus = fStringMap.getString("utsEponMcastCtrlIgmpProxyStatus") + " : ";
  private final String utsOltCtcMulticastCtrlMode = fStringMap.getString("utsOltCtcMulticastCtrlMode") + " : ";
  private final String utsOltNoCdrForShortJoinLeave = fStringMap.getString("utsOltNoCdrForShortJoinLeave") + " : ";
  private final String utsOltNoTimeForShortPreview = fStringMap.getString("utsOltNoTimeForShortPreview") + " : ";
//  private final String utsEponMulticastCtrlSuperVidList = fStringMap.getString("utsEponMulticastCtrlSuperVidList") + " : ";
  private final String utsBBSMgmtLastMembQueryIntvl = fStringMap.getString("utsBBSMgmtLastMembQueryIntvl") + " : ";
  private final String utsBBSMgmtQueryInterval = fStringMap.getString("utsBBSMgmtQueryInterval") + " : ";
  private final String utsBBSMgmtQueryMaxRespTime = fStringMap.getString("utsBBSMgmtQueryMaxRespTime") + " : ";
  private final String utsBBSMgmtRobustness = fStringMap.getString("utsBBSMgmtRobustness") + " : ";

  private SnmpApplyButton btApply;
  private SnmpRefreshButton btRefresh;
  private JButton btReport;
  
  public EponMulticastCtrlGroupPanel(IApplication app)
  {
    super(app);
    setModel(new EponMulticastCtrlGroup(app.getSnmpProxy()));
    init();
  }

  public void initGui()
  {
    btApply = new SnmpApplyButton(fApplication, this);
    btApply.getAction().putValue(BaseAction.ID, "Modify_EponMulticastCtrlGroup");
    btRefresh = new SnmpRefreshButton(fApplication, this);
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
          EponMulticastCtrlGroup mbean = (EponMulticastCtrlGroup) getModel();
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
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(btReport);
    buttonsPanel.add(btApply);
    buttonsPanel.add(btRefresh);

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    baseInfoPanel.setLayout(layout);
    baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("EponMulticastCtrlGroupPanel")));

    baseInfoPanel.add(new JLabel(utsEponMulticastCtrlIpmcEnable));
    tfUtsEponMulticastCtrlIpmcEnable.setName(fStringMap.getString("utsEponMulticastCtrlIpmcEnable"));
    baseInfoPanel.add(tfUtsEponMulticastCtrlIpmcEnable);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsEponMulticastCtrlIgmpSnoopingStatus));
    tfUtsEponMulticastCtrlIgmpSnoopingStatus.setName(fStringMap
        .getString("utsEponMulticastCtrlIgmpSnoopingStatus"));
    baseInfoPanel.add(tfUtsEponMulticastCtrlIgmpSnoopingStatus);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsEponMcastCtrlIgmpProxyStatus));
    tfUtsEponMcastCtrlIgmpProxyStatus.setName(fStringMap
        .getString("utsEponMcastCtrlIgmpProxyStatus"));
    baseInfoPanel.add(tfUtsEponMcastCtrlIgmpProxyStatus);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsOltCtcMulticastCtrlMode));
    tfUtsOltCtcMulticastCtrlMode.setName(fStringMap.getString("utsOltCtcMulticastCtrlMode"));
    tfUtsOltCtcMulticastCtrlMode.addActionListener(this);
    baseInfoPanel.add(tfUtsOltCtcMulticastCtrlMode);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsOltNoCdrForShortJoinLeave));
    tfUtsOltNoCdrForShortJoinLeave.setName(fStringMap.getString("utsOltNoCdrForShortJoinLeave"));
    baseInfoPanel.add(tfUtsOltNoCdrForShortJoinLeave);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsOltNoTimeForShortPreview));
    tfUtsOltNoTimeForShortPreview.setName(fStringMap.getString("utsOltNoTimeForShortPreview"));
    baseInfoPanel.add(tfUtsOltNoTimeForShortPreview);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsOltAcrossVlanMulticastForward));
    tfUtsOltAcrossVlanMulticastForward.setName(fStringMap.getString("utsOltAcrossVlanMulticastForward"));
    baseInfoPanel.add(tfUtsOltAcrossVlanMulticastForward);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtLastMembQueryIntvl));
    tfUtsBBSMgmtLastMembQueryIntvl.setName(fStringMap.getString("utsBBSMgmtLastMembQueryIntvl"));
    baseInfoPanel.add(tfUtsBBSMgmtLastMembQueryIntvl);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtQueryInterval));
    tfUtsBBSMgmtQueryInterval.setName(fStringMap.getString("utsBBSMgmtQueryInterval"));
    baseInfoPanel.add(tfUtsBBSMgmtQueryInterval);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtQueryMaxRespTime));
    tfUtsBBSMgmtQueryMaxRespTime.setName(fStringMap.getString("utsBBSMgmtQueryMaxRespTime"));
    baseInfoPanel.add(tfUtsBBSMgmtQueryMaxRespTime);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSMgmtRobustness));
    tfUtsBBSMgmtRobustness.setName(fStringMap.getString("utsBBSMgmtRobustness"));
    baseInfoPanel.add(tfUtsBBSMgmtRobustness);
    baseInfoPanel.add(new HSpacer());
    
    JPanel OltCtcCdrCtrlGroupPanel = new JPanel();
    layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    OltCtcCdrCtrlGroupPanel.setLayout(layout);
    OltCtcCdrCtrlGroupPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("OltCtcCdrCtrlGroup_Panel")));

    OltCtcCdrCtrlGroupPanel.add(new JLabel(utsOltCtcCdrServer));
    tfUtsOltCtcCdrServer.setName(fStringMap.getString("utsOltCtcCdrServer"));
    OltCtcCdrCtrlGroupPanel.add(tfUtsOltCtcCdrServer);
    OltCtcCdrCtrlGroupPanel.add(new HSpacer());


    OltCtcCdrCtrlGroupPanel.add(new JLabel(utsOltCtcCdrPort));
    tfUtsOltCtcCdrPort.setName(fStringMap.getString("utsOltCtcCdrPort"));
    OltCtcCdrCtrlGroupPanel.add(tfUtsOltCtcCdrPort);
    OltCtcCdrCtrlGroupPanel.add(new HSpacer());


    OltCtcCdrCtrlGroupPanel.add(new JLabel(utsOltCtcCdrReportInterval));
    tfUtsOltCtcCdrReportInterval.setName(fStringMap.getString("utsOltCtcCdrReportInterval"));
    OltCtcCdrCtrlGroupPanel.add(tfUtsOltCtcCdrReportInterval);
    OltCtcCdrCtrlGroupPanel.add(new HSpacer());


    OltCtcCdrCtrlGroupPanel.add(new JLabel(utsOltCtcCdrReportCount));
    tfUtsOltCtcCdrReportCount.setName(fStringMap.getString("utsOltCtcCdrReportCount"));
    OltCtcCdrCtrlGroupPanel.add(tfUtsOltCtcCdrReportCount);
    OltCtcCdrCtrlGroupPanel.add(new HSpacer());


    OltCtcCdrCtrlGroupPanel.add(new JLabel(utsOltCtcCdrReportMode));
    tfUtsOltCtcCdrReportMode.setName(fStringMap.getString("utsOltCtcCdrReportMode"));
    OltCtcCdrCtrlGroupPanel.add(tfUtsOltCtcCdrReportMode);
    OltCtcCdrCtrlGroupPanel.add(new HSpacer());



//    baseInfoPanel.add(new JLabel(utsEponMulticastCtrlSuperVidList));
//    tfUtsEponMulticastCtrlSuperVidList.setName(fStringMap.getString("utsEponMulticastCtrlSuperVidList"));
//    tfUtsEponMulticastCtrlSuperVidList.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
//    JScrollPane pane = new JScrollPane(tfUtsEponMulticastCtrlSuperVidList);
//    pane.setPreferredSize( new Dimension(200, 200) );
//    baseInfoPanel.add(pane);
//    baseInfoPanel.add(new HSpacer());

    JPanel allPanel = new JPanel();
    layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(OltCtcCdrCtrlGroupPanel);
    allPanel.add(new VSpacer());
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.SOUTH);

  }

  private Vector getData()
  {
    Vector list = new Vector();

    list.add("None");

    SuperSVITable superSVI = new SuperSVITable( fApplication.getSnmpProxy() );
    try {
      Vector result = superSVI.retrieveAll();
      if( result != null )
      {
        for( int i=0; i<result.size(); i++ )
        {
          SuperSVITable mbean = ( SuperSVITable )result.get( i );
          list.add("vlan" + mbean.getUtsIntfSuperSVIVlanId().toString() );
        }
      }
    } catch (MibBeanException e) {
      e.printStackTrace();
    }

    return list;
  }

  protected void initForm()
  {
    tfUtsOltNoCdrForShortJoinLeave.setValueScope(1, 15);
    tfUtsOltNoTimeForShortPreview.setValueScope(1, 15);
//    tfUtsEponMulticastCtrlSuperVidList.setLenScope(0, 512);
    tfUtsBBSMgmtLastMembQueryIntvl.setValueScope(1, 25);
    tfUtsBBSMgmtQueryInterval.setValueScope(10, 3600);
    tfUtsBBSMgmtQueryMaxRespTime.setValueScope(1, 25);
    tfUtsBBSMgmtRobustness.setValueScope(2, 10);
    
    tfUtsOltCtcCdrPort.setValueScope(1, 65535);
    tfUtsOltCtcCdrReportInterval.setValueScope(10, 3600);
    tfUtsOltCtcCdrReportCount.setValueScope(10, 1000);
  }

  public void refresh() {
    EponMulticastCtrlGroup mbean = (EponMulticastCtrlGroup) getModel();
    BeanService.refreshBean(fApplication, mbean);

    tfUtsEponMulticastCtrlIpmcEnable.setSelectedIndex(getIndexFromValue( utsEponMulticastCtrlIpmcEnableVList, mbean.getUtsEponMulticastCtrlIpmcEnable().intValue()));
    tfUtsEponMulticastCtrlIgmpSnoopingStatus.setSelectedIndex(getIndexFromValue( utsEponMulticastCtrlIgmpSnoopingStatusVList, mbean.getUtsEponMulticastCtrlIgmpSnoopingStatus().intValue()));
    tfUtsEponMcastCtrlIgmpProxyStatus.setSelectedIndex(getIndexFromValue( utsEponMcastCtrlIgmpProxyStatusVList, mbean.getUtsEponMcastCtrlIgmpProxyStatus().intValue()));
    tfUtsOltCtcMulticastCtrlMode.setSelectedIndex(getIndexFromValue( utsOltCtcMulticastCtrlModeVList, mbean.getUtsOltCtcMulticastCtrlMode().intValue()));
    tfUtsOltNoTimeForShortPreview.setValue(mbean.getUtsOltNoTimeForShortPreview());
    tfUtsOltNoCdrForShortJoinLeave.setValue(mbean.getUtsOltNoCdrForShortJoinLeave());
    tfUtsOltAcrossVlanMulticastForward.setSelectedIndex(getIndexFromValue(utsOltAcrossVlanMulticastForwardVList, mbean.getUtsOltAcrossVlanMulticastForward()));
    tfUtsBBSMgmtLastMembQueryIntvl.setValue(mbean.getUtsBBSMgmtLastMembQueryIntvl());
    tfUtsBBSMgmtQueryInterval.setValue(mbean.getUtsBBSMgmtQueryInterval());
    tfUtsBBSMgmtQueryMaxRespTime.setValue(mbean.getUtsBBSMgmtQueryMaxRespTime());
    tfUtsBBSMgmtRobustness.setValue(mbean.getUtsBBSMgmtRobustness());
    tfUtsOltCtcCdrServer.setValue(mbean.getUtsOltCtcCdrServer());
    tfUtsOltCtcCdrPort.setValue(mbean.getUtsOltCtcCdrPort().intValue());
    tfUtsOltCtcCdrReportInterval.setValue(mbean.getUtsOltCtcCdrReportInterval().intValue());
    tfUtsOltCtcCdrReportCount.setValue(mbean.getUtsOltCtcCdrReportCount().intValue());
    tfUtsOltCtcCdrReportMode.setSelectedIndex(getIndexFromValue(utsOltCtcCdrReportModeVList, mbean.getUtsOltCtcCdrReportMode().intValue()));
  
    // init vid list
//     Vector superSVI = getData();
//     tfUtsEponMulticastCtrlSuperVidList.setListData( superSVI );

    // set selection index
//    String[] selectedVidList = ConfigUtility.vlanMapToVlanList(mbean.getUtsEponMulticastCtrlSuperVidList());
//    if(selectedVidList.length > 0)
//    {
//      int[] indices = new int[selectedVidList.length];
//      for (int i = 0; i < selectedVidList.length; i++) {
//        int tmpIdx = superSVI.indexOf(selectedVidList[i]);
//        if (tmpIdx >= 0) {
//          indices[i] = tmpIdx;
//        }
//      }
//
//      tfUtsEponMulticastCtrlSuperVidList.setSelectedIndices( indices );
//    }
//    else
//    {
//      tfUtsEponMulticastCtrlSuperVidList.setSelectedIndex(0);
//    }
  }

  public void updateModel()
  {
    EponMulticastCtrlGroup mbean = (EponMulticastCtrlGroup) getModel();

    mbean.setUtsEponMulticastCtrlIpmcEnable(new Integer(utsEponMulticastCtrlIpmcEnableVList[tfUtsEponMulticastCtrlIpmcEnable.getSelectedIndex()]));
    mbean.setUtsEponMulticastCtrlIgmpSnoopingStatus(new Integer(utsEponMulticastCtrlIgmpSnoopingStatusVList[tfUtsEponMulticastCtrlIgmpSnoopingStatus.getSelectedIndex()]));
    mbean.setUtsEponMcastCtrlIgmpProxyStatus(new Integer(utsEponMcastCtrlIgmpProxyStatusVList[tfUtsEponMcastCtrlIgmpProxyStatus.getSelectedIndex()]));
    mbean.setUtsOltCtcMulticastCtrlMode(new Integer(utsOltCtcMulticastCtrlModeVList[tfUtsOltCtcMulticastCtrlMode.getSelectedIndex()]));
    mbean.setUtsBBSMgmtLastMembQueryIntvl(tfUtsBBSMgmtLastMembQueryIntvl.getValue());
    mbean.setUtsBBSMgmtQueryInterval(tfUtsBBSMgmtQueryInterval.getValue());
    mbean.setUtsBBSMgmtQueryMaxRespTime(tfUtsBBSMgmtQueryMaxRespTime.getValue());
    mbean.setUtsBBSMgmtRobustness(tfUtsBBSMgmtRobustness.getValue());

    if(tfUtsOltNoCdrForShortJoinLeave.isEnabled())
    {
      mbean.setUtsOltNoCdrForShortJoinLeave(tfUtsOltNoCdrForShortJoinLeave.getValue());
    }

    if(tfUtsOltNoTimeForShortPreview.isEnabled())
    {
      mbean.setUtsOltNoTimeForShortPreview(tfUtsOltNoTimeForShortPreview.getValue());
    }
    if(tfUtsOltAcrossVlanMulticastForward.isEnabled()){
        mbean.setUtsOltAcrossVlanMulticastForward(utsOltAcrossVlanMulticastForwardVList[tfUtsOltAcrossVlanMulticastForward.getSelectedIndex()]);
    }
    mbean.setUtsOltCtcCdrServer(tfUtsOltCtcCdrServer.getIPString());
    mbean.setUtsOltCtcCdrPort(new Integer(tfUtsOltCtcCdrPort.getValue()));
    mbean.setUtsOltCtcCdrReportInterval(new Integer(tfUtsOltCtcCdrReportInterval.getValue()));
    mbean.setUtsOltCtcCdrReportCount(new Integer(tfUtsOltCtcCdrReportCount.getValue()));
    mbean.setUtsOltCtcCdrReportMode(new Integer(utsOltCtcCdrReportModeVList[tfUtsOltCtcCdrReportMode.getSelectedIndex()]));
//    //user select "None" item.
//    int[] indices = tfUtsEponMulticastCtrlSuperVidList.getSelectedIndices();
//    if(indices.length == 1 && indices[0] == 0)
//    {
//      mbean.setUtsEponMulticastCtrlSuperVidList(new byte[512]);
//    }
//    else if(indices.length > 0)
//    {
//      if(indices[0] == 0)
//      {
//        String[] vlanList = new String[indices.length - 1];
//        System.arraycopy(tfUtsEponMulticastCtrlSuperVidList.getSelectedValues(), 1, vlanList, 0, vlanList.length);
//        mbean.setUtsEponMulticastCtrlSuperVidList(ConfigUtility.vlanListToVlanMap(vlanList));
//      }
//      else
//      {
//        String[] vlanList = new String[indices.length];
//        System.arraycopy(tfUtsEponMulticastCtrlSuperVidList.getSelectedValues(), 0, vlanList, 0, vlanList.length);
//        mbean.setUtsEponMulticastCtrlSuperVidList(ConfigUtility.vlanListToVlanMap(vlanList));
//      }
//    }
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
    if(tfUtsOltCtcMulticastCtrlMode.getSelectedIndex() != 1)//control mode
    {
      tfUtsOltNoCdrForShortJoinLeave.setEnabled(false);
      tfUtsOltNoTimeForShortPreview.setEnabled(false);
    }
    else
    {
      tfUtsOltNoCdrForShortJoinLeave.setEnabled(true);
      tfUtsOltNoTimeForShortPreview.setEnabled(true);
    }
  }
}
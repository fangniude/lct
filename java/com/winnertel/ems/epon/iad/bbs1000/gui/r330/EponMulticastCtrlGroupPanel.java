package com.winnertel.ems.epon.iad.bbs1000.gui.r330;

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
import com.winnertel.ems.epon.iad.bbs4000.mib.r210.EponMulticastCtrlGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

//	private JList tfUtsEponMulticastCtrlSuperVidList = new JList();

  private IntegerTextField tfUtsBBSMgmtLastMembQueryIntvl = new IntegerTextField();
  private IntegerTextField tfUtsBBSMgmtQueryInterval = new IntegerTextField();
  private IntegerTextField tfUtsBBSMgmtQueryMaxRespTime = new IntegerTextField();
  private IntegerTextField tfUtsBBSMgmtRobustness = new IntegerTextField();
//
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

	public EponMulticastCtrlGroupPanel(IApplication app)
	{
		super(app);
		setModel(new EponMulticastCtrlGroup(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{
		SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID, "Modify_EponMulticastCtrlGroup");
		SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

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

//    baseInfoPanel.add(new JLabel(utsEponMulticastCtrlSuperVidList));
//		tfUtsEponMulticastCtrlSuperVidList.setName(fStringMap.getString("utsEponMulticastCtrlSuperVidList"));
//		tfUtsEponMulticastCtrlSuperVidList.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
//    JScrollPane pane = new JScrollPane(tfUtsEponMulticastCtrlSuperVidList);
//    pane.setPreferredSize( new Dimension(200, 200) );
//		baseInfoPanel.add(pane);
//		baseInfoPanel.add(new HSpacer());

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

	protected void initForm()
	{
    tfUtsOltNoCdrForShortJoinLeave.setValueScope(1, 15);
    tfUtsOltNoTimeForShortPreview.setValueScope(1, 15);
//		tfUtsEponMulticastCtrlSuperVidList.setLenScope(0, 512);
    tfUtsBBSMgmtLastMembQueryIntvl.setValueScope(1, 3600);
    tfUtsBBSMgmtQueryInterval.setValueScope(10, 3600);
    tfUtsBBSMgmtQueryMaxRespTime.setValueScope(10, 25);
    tfUtsBBSMgmtRobustness.setValueScope(2, 10);
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
    tfUtsBBSMgmtLastMembQueryIntvl.setValue(mbean.getUtsBBSMgmtLastMembQueryIntvl());
    tfUtsBBSMgmtQueryInterval.setValue(mbean.getUtsBBSMgmtQueryInterval());
    tfUtsBBSMgmtQueryMaxRespTime.setValue(mbean.getUtsBBSMgmtQueryMaxRespTime());
    tfUtsBBSMgmtRobustness.setValue(mbean.getUtsBBSMgmtRobustness());
    // init vid list
//		 Vector superSVI = getData();
//		 tfUtsEponMulticastCtrlSuperVidList.setListData( superSVI );

		// set selection index
//		String[] selectedVidList = ConfigUtility.vlanMapToVlanList(mbean.getUtsEponMulticastCtrlSuperVidList());
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
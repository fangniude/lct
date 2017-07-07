package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.EponMulticastCtrlGroup;
import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The EponMulticastCtrlGroupPanel class. Created by DVM Creator
 */
public class EponMulticastCtrlGroupPanel extends UPanel
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
	{ 1, 2, };

	private String[] utsOltCtcMulticastCtrlModeTList = new String[]
	{ fStringMap.getString("traditional"), fStringMap.getString("control-mode"), };

	private JComboBox tfUtsOltCtcMulticastCtrlMode = new JComboBox(
			utsOltCtcMulticastCtrlModeTList);

////	private StringTextField tfUtsEponMulticastCtrlSuperVidList = new StringTextField();
//	private JList tfUtsEponMulticastCtrlSuperVidList = new JList();
//
	private final String utsEponMulticastCtrlIpmcEnable = fStringMap.getString("utsEponMulticastCtrlIpmcEnable") + " : ";

	private final String utsEponMulticastCtrlIgmpSnoopingStatus = fStringMap.getString("utsEponMulticastCtrlIgmpSnoopingStatus") + " : ";

	private final String utsEponMcastCtrlIgmpProxyStatus = fStringMap.getString("utsEponMcastCtrlIgmpProxyStatus") + " : ";

	private final String utsOltCtcMulticastCtrlMode = fStringMap.getString("utsOltCtcMulticastCtrlMode") + " : ";

//	private final String utsEponMulticastCtrlSuperVidList = fStringMap
//			.getString("utsEponMulticastCtrlSuperVidList")
//			+ " : ";

	private SnmpApplyButton btApply;

	private SnmpRefreshButton btRefresh;

	private Vector superSVI = null;

	public EponMulticastCtrlGroupPanel(IApplication app)
	{
		super(app);
		setModel(new EponMulticastCtrlGroup(app.getSnmpProxy()));
		superSVI = getData();
		init();
	}

	public void initGui()
	{

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID, "Modify_EponMulticastCtrlGroup");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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
		baseInfoPanel.add(tfUtsOltCtcMulticastCtrlMode);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsEponMulticastCtrlSuperVidList));
//		tfUtsEponMulticastCtrlSuperVidList.setName(fStringMap
//				.getString("utsEponMulticastCtrlSuperVidList"));
//		tfUtsEponMulticastCtrlSuperVidList.setPreferredSize( new Dimension(200, 100) );
//		tfUtsEponMulticastCtrlSuperVidList.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
//		baseInfoPanel.add(tfUtsEponMulticastCtrlSuperVidList);
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
	
	private Vector getData()
	{
		Vector list = new Vector();

		list.add(" ");

		SuperSVITable superSVI = new SuperSVITable( fApplication.getSnmpProxy() );
		try {
			Vector result = superSVI.retrieveAll();
			if( result != null )
			{
				for( int i=0; i<result.size(); i++ )
				{
					SuperSVITable mbean = ( SuperSVITable )result.get( i );
					list.add( mbean.getUtsIntfSuperSVIVlanId().toString() );
				}
			}
		} catch (MibBeanException e) {
			e.printStackTrace();
		}

		return list;
	}

	protected void initForm()
	{

//		tfUtsEponMulticastCtrlSuperVidList.setLenScope(0, 512);

	}

	public void refresh() {
		EponMulticastCtrlGroup mbean = (EponMulticastCtrlGroup) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfUtsEponMulticastCtrlIpmcEnable.setSelectedIndex(getIndexFromValue( utsEponMulticastCtrlIpmcEnableVList, mbean.getUtsEponMulticastCtrlIpmcEnable().intValue()));
		tfUtsEponMulticastCtrlIgmpSnoopingStatus.setSelectedIndex(getIndexFromValue( utsEponMulticastCtrlIgmpSnoopingStatusVList, mbean.getUtsEponMulticastCtrlIgmpSnoopingStatus().intValue()));
		tfUtsEponMcastCtrlIgmpProxyStatus.setSelectedIndex(getIndexFromValue( utsEponMcastCtrlIgmpProxyStatusVList, mbean.getUtsEponMcastCtrlIgmpProxyStatus().intValue()));
		tfUtsOltCtcMulticastCtrlMode.setSelectedIndex(getIndexFromValue( utsOltCtcMulticastCtrlModeVList, mbean.getUtsOltCtcMulticastCtrlMode().intValue()));

		// init vid list
		// superSVI = getData();
		// tfUtsEponMulticastCtrlSuperVidList.setListData( superSVI );

		// set selection index
		String[] selectedVidList = mbean.getUtsEponMulticastCtrlSuperVidList().split(" ");
		int[] indices = new int[selectedVidList.length];
		for (int i = 0; i < selectedVidList.length; i++) {
			int tmpIdx = superSVI.indexOf(selectedVidList[i]);
			if (tmpIdx >= 0) {
				indices[i] = tmpIdx;
			}
		}

		// tfUtsEponMulticastCtrlSuperVidList.setSelectedIndices( indices );
	}

	public void updateModel()
	{
		EponMulticastCtrlGroup mbean = (EponMulticastCtrlGroup) getModel();

		mbean.setUtsEponMulticastCtrlIpmcEnable(new Integer(
						utsEponMulticastCtrlIpmcEnableVList[tfUtsEponMulticastCtrlIpmcEnable.getSelectedIndex()]));

		mbean.setUtsEponMulticastCtrlIgmpSnoopingStatus(new Integer(
						utsEponMulticastCtrlIgmpSnoopingStatusVList[tfUtsEponMulticastCtrlIgmpSnoopingStatus.getSelectedIndex()]));

		mbean.setUtsEponMcastCtrlIgmpProxyStatus(new Integer(
						utsEponMcastCtrlIgmpProxyStatusVList[tfUtsEponMcastCtrlIgmpProxyStatus.getSelectedIndex()]));

		mbean.setUtsOltCtcMulticastCtrlMode(new Integer( utsOltCtcMulticastCtrlModeVList[tfUtsOltCtcMulticastCtrlMode.getSelectedIndex()]));

//		StringBuffer vidStr = new StringBuffer();
//		Object[] selectedVidList = (Object[])tfUtsEponMulticastCtrlSuperVidList.getSelectedValues();
//		for ( int i = 0; i < selectedVidList.length; i++ ) {
//			vidStr.append( selectedVidList[i].toString() ).append(" ");
//		}
//		mbean.setUtsEponMulticastCtrlSuperVidList( vidStr.toString() );
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

}
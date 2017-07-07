package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OltTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OnuTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3OnuTablePanel class. Created by DVM Creator
 */
public class Dot3OnuTablePanel extends UPanel
{

	private JLabel tfIfIndex = new JLabel();

	// private JLabel tfUtsDot3OnuModuleId = new JLabel();
	//
	// private JLabel tfUtsDot3OnuPortId = new JLabel();
	//
	// private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();
	//
	// private int[] utsDot3OnuRegistrationStateVList = new int[]
	// { 2, 1, 3, };
	//
	// private String[] utsDot3OnuRegistrationStateTList = new String[]
	// { fStringMap.getString("pending"), fStringMap.getString("unregistered"),
	// fStringMap.getString("registered"), };
	//
	// private JComboBox tfUtsDot3OnuRegistrationState = new JComboBox(
	// utsDot3OnuRegistrationStateTList);

	// private JLabel tfUtsDot3OnuHwVersion = new JLabel();
	//
	// private JLabel tfUtsDot3OnuFwVersion = new JLabel();
	//
	// private JLabel tfUtsDot3OnuMaxLLID = new JLabel();
	//
	// private int[] utsDot3OnuOAMStandardVersionVList = new int[]
	// { 1, 2, };
	//
	// private String[] utsDot3OnuOAMStandardVersionTList = new String[]
	// { fStringMap.getString("oam-802-3ah-draft-1-2"),
	// fStringMap.getString("oam-802-3ah-draft-2-0"), };
	//
	// private JComboBox tfUtsDot3OnuOAMStandardVersion = new JComboBox(
	// utsDot3OnuOAMStandardVersionTList);

	// private JLabel tfUtsDot3OnuRTT = new JLabel();

	// private int[] utsDot3OnuHwTypeVList = new int[]
	// { 3, 8, 5, 2, 4, 6, 7, 1, };
	//
	// private String[] utsDot3OnuHwTypeTList = new String[]
	// { fStringMap.getString("onu1000c"), fStringMap.getString("onu101k"),
	// fStringMap.getString("onu200b"), fStringMap.getString("onu1000b"),
	// fStringMap.getString("onu200a"), fStringMap.getString("onu2024"),
	// fStringMap.getString("onu2004"), fStringMap.getString("onu100"), };
	//
	// private JComboBox tfUtsDot3OnuHwType = new
	// JComboBox(utsDot3OnuHwTypeTList);
	//
	// private JLabel tfUtsDot3OnuSwitchHwRev = new JLabel();

	// private JLabel tfUtsDot3OnuSwitchFwRev = new JLabel();
	//
	// private int[] utsDot3OnuIADStatusVList = new int[]
	// { 2, 1, };
	//
	// private String[] utsDot3OnuIADStatusTList = new String[]
	// { fStringMap.getString("unknown"), fStringMap.getString("ready"), };
	//
	// private JComboBox tfUtsDot3OnuIADStatus = new JComboBox(
	// utsDot3OnuIADStatusTList);
	//
	// private JLabel tfUtsDot3OnuPonMacAddress = new JLabel();

	private int[] utsDot3OnuAES128EncryptionStatusVList = new int[]
	{ 2, 1, 3, };

	private String[] utsDot3OnuAES128EncryptionStatusTList = new String[]
	{ fStringMap.getString("bidirectional"), fStringMap.getString("disable"),
			fStringMap.getString("downlink"), };

	private JComboBox tfUtsDot3OnuAES128EncryptionStatus = new JComboBox(
			utsDot3OnuAES128EncryptionStatusTList);

	private StringTextField tfUtsDot3OnuAES128EncryptionKey = new StringTextField();

	// private int[] utsDot3OnuPonLoopbackTestStatusVList = new int[]
	// { 1, 2, };
	//
	// private String[] utsDot3OnuPonLoopbackTestStatusTList = new String[]
	// { fStringMap.getString("disable"), fStringMap.getString("enable"), };
	//
	// private JComboBox tfUtsDot3OnuPonLoopbackTestStatus = new JComboBox(
	// utsDot3OnuPonLoopbackTestStatusTList);
	//
	// private IntegerTextField tfUtsDot3OnuPonLoopbackTestVlanId = new
	// IntegerTextField();

	// private int[] utsDot3OnuEthernetLinkStatusVList = new int[]
	// { 2, 3, 1, };
	//
	// private String[] utsDot3OnuEthernetLinkStatusTList = new String[]
	// { fStringMap.getString("linkup"), fStringMap.getString("unknow"),
	// fStringMap.getString("linkdown"), };
	//
	// private JComboBox tfUtsDot3OnuEthernetLinkStatus = new JComboBox(
	// utsDot3OnuEthernetLinkStatusTList);

	// private JLabel tfUtsDot3OnuSwitchMacAddress = new JLabel();

	private int[] utsDot3OnuAdminStatusVList = new int[]
	{ 1, 2, };

	private String[] utsDot3OnuAdminStatusTList = new String[]
	{ fStringMap.getString("up"), fStringMap.getString("down"), };

	private JComboBox tfUtsDot3OnuAdminStatus = new JComboBox(
			utsDot3OnuAdminStatusTList);

	private int[] utsDot3OnuMulticastFilterVList = new int[]
	{ 2, 1, };

	private String[] utsDot3OnuMulticastFilterTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsDot3OnuMulticastFilter = new JComboBox(
			utsDot3OnuMulticastFilterTList);

	private int[] utsDot3OnuRMAutoNegotiationVList = new int[]
	{ 1, 2, 3, 4, 5, 6, 7, };

	private String[] utsDot3OnuRMAutoNegotiationTList = new String[]
	{ 		fStringMap.getString("auto10M"), 
			fStringMap.getString("auto100M"),
			fStringMap.getString("auto1000M"), 
			fStringMap.getString("half10M"),
			fStringMap.getString("full10M"), 
			fStringMap.getString("half100M"),
			fStringMap.getString("full100M"), };

	private JComboBox tfUtsDot3OnuRMAutoNegotiation = new JComboBox(
			utsDot3OnuRMAutoNegotiationTList);

	// private int[] utsDot3OnuResetVList = new int[]
	// { 1, 0, };
	//
	// private String[] utsDot3OnuResetTList = new String[]
	// { fStringMap.getString("reset"), fStringMap.getString("normal"), };
	//
	// private JComboBox tfUtsDot3OnuReset = new
	// JComboBox(utsDot3OnuResetTList);

	private int[] utsDot3OnuQinQVList = new int[]
	{ 1, 2, };

	private String[] utsDot3OnuQinQTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsDot3OnuQinQ = new JComboBox(utsDot3OnuQinQTList);

	private final String ifIndex = fStringMap.getString("ifOnuIndex") + " : ";

	private final String utsDot3OnuAES128EncryptionStatus = fStringMap
			.getString("utsDot3OnuAES128EncryptionStatus")
			+ " : ";

	private final String utsDot3OnuAES128EncryptionKey = fStringMap
			.getString("utsDot3OnuAES128EncryptionKey")
			+ " : ";

	private final String utsDot3OnuAdminStatus = fStringMap
			.getString("utsDot3OnuAdminStatus")
			+ " : ";

	private final String utsDot3OnuMulticastFilter = fStringMap
			.getString("utsDot3OnuMulticastFilter")
			+ " : ";

	private final String utsDot3OnuRMAutoNegotiation = fStringMap
			.getString("utsDot3OnuRMAutoNegotiation")
			+ " : ";

	private final String utsDot3OnuQinQ = fStringMap
			.getString("utsDot3OnuQinQ")
			+ " : ";

	private SnmpApplyButton btApply;

	private SnmpRefreshButton btRefresh;

	public Dot3OnuTablePanel(IApplication app)
	{
		super(app);
		setModel(new Dot3OnuTable(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID, "Modify_Dot3OnuTable");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(ifIndex));
		baseInfoPanel.add(tfIfIndex);
		baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
		// baseInfoPanel.add(tfUtsDot3OnuModuleId);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
		// baseInfoPanel.add(tfUtsDot3OnuPortId);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
		// baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuRegistrationState));
		// baseInfoPanel.add(tfUtsDot3OnuRegistrationState);
		// baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3OnuHwVersion));
		// baseInfoPanel.add(tfUtsDot3OnuHwVersion);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuFwVersion));
		// baseInfoPanel.add(tfUtsDot3OnuFwVersion);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuMaxLLID));
		// baseInfoPanel.add(tfUtsDot3OnuMaxLLID);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuOAMStandardVersion));
		// baseInfoPanel.add(tfUtsDot3OnuOAMStandardVersion);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuRTT));
		// baseInfoPanel.add(tfUtsDot3OnuRTT);
		// baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3OnuHwType));
		// baseInfoPanel.add(tfUtsDot3OnuHwType);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuSwitchHwRev));
		// baseInfoPanel.add(tfUtsDot3OnuSwitchHwRev);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuSwitchFwRev));
		// baseInfoPanel.add(tfUtsDot3OnuSwitchFwRev);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuIADStatus));
		// baseInfoPanel.add(tfUtsDot3OnuIADStatus);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuPonMacAddress));
		// baseInfoPanel.add(tfUtsDot3OnuPonMacAddress);
		// baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuAES128EncryptionStatus));
		tfUtsDot3OnuAES128EncryptionStatus.setName(fStringMap
				.getString("utsDot3OnuAES128EncryptionStatus"));
		baseInfoPanel.add(tfUtsDot3OnuAES128EncryptionStatus);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuAES128EncryptionKey));
		tfUtsDot3OnuAES128EncryptionKey.setName(fStringMap
				.getString("utsDot3OnuAES128EncryptionKey"));
		baseInfoPanel.add(tfUtsDot3OnuAES128EncryptionKey);
		baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3OnuPonLoopbackTestStatus));
		// tfUtsDot3OnuPonLoopbackTestStatus.setName(fStringMap
		// .getString("utsDot3OnuPonLoopbackTestStatus"));
		// baseInfoPanel.add(tfUtsDot3OnuPonLoopbackTestStatus);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuPonLoopbackTestVlanId));
		// tfUtsDot3OnuPonLoopbackTestVlanId.setName(fStringMap
		// .getString("utsDot3OnuPonLoopbackTestVlanId"));
		// baseInfoPanel.add(tfUtsDot3OnuPonLoopbackTestVlanId);
		// baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3OnuEthernetLinkStatus));
		// baseInfoPanel.add(tfUtsDot3OnuEthernetLinkStatus);
		// baseInfoPanel.add(new HSpacer());
		//
		// baseInfoPanel.add(new JLabel(utsDot3OnuSwitchMacAddress));
		// baseInfoPanel.add(tfUtsDot3OnuSwitchMacAddress);
		// baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuAdminStatus));
		tfUtsDot3OnuAdminStatus.setName(fStringMap
				.getString("utsDot3OnuAdminStatus"));
		baseInfoPanel.add(tfUtsDot3OnuAdminStatus);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuMulticastFilter));
		tfUtsDot3OnuMulticastFilter.setName(fStringMap
				.getString("utsDot3OnuMulticastFilter"));
		baseInfoPanel.add(tfUtsDot3OnuMulticastFilter);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuRMAutoNegotiation));
		tfUtsDot3OnuRMAutoNegotiation.setName(fStringMap
				.getString("utsDot3OnuRMAutoNegotiation"));
		baseInfoPanel.add(tfUtsDot3OnuRMAutoNegotiation);
		baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3OnuReset));
		// tfUtsDot3OnuReset.setName(fStringMap.getString("utsDot3OnuReset"));
		// baseInfoPanel.add(tfUtsDot3OnuReset);
		// baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuQinQ));
		tfUtsDot3OnuQinQ.setName(fStringMap.getString("utsDot3OnuQinQ"));
		baseInfoPanel.add(tfUtsDot3OnuQinQ);
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

		// add(buttonsPanel, BorderLayout.SOUTH);

	}

	protected void initForm()
	{

		// tfUtsDot3OnuPonMacAddress.setEditable(false);

		tfUtsDot3OnuAES128EncryptionKey.setLenScope(0, 16);

		// tfUtsDot3OnuPonLoopbackTestVlanId.setValueScope(1, 4094);

		// tfUtsDot3OnuSwitchMacAddress.setEditable(false);

	}

	public void refresh()
	{

		Dot3OnuTable mbean = (Dot3OnuTable) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfIfIndex.setText(ConfigUtility.formatIfIndex(mbean.getIfOnuIndex()
				.toString()));
		// tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
		// tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
		// tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId()
		// .toString());
		// tfUtsDot3OnuRegistrationState.setSelectedIndex(getIndexFromValue(
		// utsDot3OnuRegistrationStateVList, mbean
		// .getUtsDot3OnuRegistrationState().intValue()));
		// tfUtsDot3OnuHwVersion.setText(mbean.getUtsDot3OnuHwVersion());
		// tfUtsDot3OnuFwVersion.setText(mbean.getUtsDot3OnuFwVersion());
		// tfUtsDot3OnuMaxLLID.setText(mbean.getUtsDot3OnuMaxLLID().toString());
		// tfUtsDot3OnuOAMStandardVersion.setSelectedIndex(getIndexFromValue(
		// utsDot3OnuOAMStandardVersionVList, mbean
		// .getUtsDot3OnuOAMStandardVersion().intValue()));
		// tfUtsDot3OnuRTT.setText(mbean.getUtsDot3OnuRTT().toString());
		// tfUtsDot3OnuHwType.setSelectedIndex(getIndexFromValue(
		// utsDot3OnuHwTypeVList, mbean.getUtsDot3OnuHwType().intValue()));
		// tfUtsDot3OnuSwitchHwRev.setText(mbean.getUtsDot3OnuSwitchHwRev());
		// tfUtsDot3OnuSwitchFwRev.setText(mbean.getUtsDot3OnuSwitchFwRev());
		// tfUtsDot3OnuIADStatus.setSelectedIndex(getIndexFromValue(
		// utsDot3OnuIADStatusVList, mbean.getUtsDot3OnuIADStatus()
		// .intValue()));
		// tfUtsDot3OnuPonMacAddress.setText(mbean.getUtsDot3OnuPonMacAddress());
		tfUtsDot3OnuAES128EncryptionStatus.setSelectedIndex(getIndexFromValue(
				utsDot3OnuAES128EncryptionStatusVList, mbean
						.getUtsDot3OnuAES128EncryptionStatus().intValue()));
		tfUtsDot3OnuAES128EncryptionKey.setValue(mbean
				.getUtsDot3OnuAES128EncryptionKey());
		// tfUtsDot3OnuPonLoopbackTestStatus.setSelectedIndex(getIndexFromValue(
		// utsDot3OnuPonLoopbackTestStatusVList, mbean
		// .getUtsDot3OnuPonLoopbackTestStatus().intValue()));
		// tfUtsDot3OnuPonLoopbackTestVlanId.setValue(mbean
		// .getUtsDot3OnuPonLoopbackTestVlanId().intValue());
		// tfUtsDot3OnuEthernetLinkStatus.setSelectedIndex(getIndexFromValue(
		// utsDot3OnuEthernetLinkStatusVList, mbean
		// .getUtsDot3OnuEthernetLinkStatus().intValue()));
		// tfUtsDot3OnuSwitchMacAddress.setText(mbean
		// .getUtsDot3OnuSwitchMacAddress());
		tfUtsDot3OnuAdminStatus.setSelectedIndex(getIndexFromValue(
				utsDot3OnuAdminStatusVList, mbean.getUtsDot3OnuAdminStatus().intValue()));
		tfUtsDot3OnuMulticastFilter.setSelectedIndex(getIndexFromValue(
				utsDot3OnuMulticastFilterVList, mbean.getUtsDot3OnuMulticastFilter().intValue()));
		tfUtsDot3OnuRMAutoNegotiation.setSelectedIndex(getIndexFromValue(
				utsDot3OnuRMAutoNegotiationVList, mbean.getUtsDot3OnuRMAutoNegotiation().intValue()));
		// tfUtsDot3OnuReset.setSelectedIndex(getIndexFromValue(
		// utsDot3OnuResetVList, mbean.getUtsDot3OnuReset().intValue()));
		tfUtsDot3OnuQinQ.setSelectedIndex(getIndexFromValue(
				utsDot3OnuQinQVList, mbean.getUtsDot3OnuQinQ().intValue()));

		// If the OLT port's utsDot3OltRunningMode=application-tag-handling-mode(2), should disable QinQ service.
		try {
			Dot3OltTable tmpOltMBean = new Dot3OltTable( fApplication.getSnmpProxy() );

			String tmpPortPortIdx = mbean.getUtsDot3OnuModuleId() + "/" + mbean.getUtsDot3OnuPortId();
	        int ifIndex = ConfigUtility.generateIfIndex( tmpPortPortIdx); //port if index

			tmpOltMBean.setIndex( 0, ifIndex + "" );
			if ( tmpOltMBean.retrieve() == true ) {
				int tmpOltRunningMode = tmpOltMBean.getUtsDot3OltRunningMode().intValue();
				if ( tmpOltRunningMode == 2 ) {
					tfUtsDot3OnuQinQ.setEnabled( false );
				}
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
	}

	public void updateModel()
	{

		Dot3OnuTable mbean = (Dot3OnuTable) getModel();

		mbean.setUtsDot3OnuAES128EncryptionStatus(new Integer(
						utsDot3OnuAES128EncryptionStatusVList[tfUtsDot3OnuAES128EncryptionStatus.getSelectedIndex()]));

		mbean.setUtsDot3OnuAES128EncryptionKey(new String(
				tfUtsDot3OnuAES128EncryptionKey.getValue()));
		// mbean.setUtsDot3OnuPonLoopbackTestStatus(new Integer(
		// utsDot3OnuPonLoopbackTestStatusVList[tfUtsDot3OnuPonLoopbackTestStatus
		// .getSelectedIndex()]));
		// mbean.setUtsDot3OnuPonLoopbackTestVlanId(new Integer(
		// tfUtsDot3OnuPonLoopbackTestVlanId.getValue()));

		mbean.setUtsDot3OnuAdminStatus(new Integer(
				utsDot3OnuAdminStatusVList[tfUtsDot3OnuAdminStatus.getSelectedIndex()]));

		mbean.setUtsDot3OnuMulticastFilter(new Integer(
				utsDot3OnuMulticastFilterVList[tfUtsDot3OnuMulticastFilter.getSelectedIndex()]));

		mbean.setUtsDot3OnuRMAutoNegotiation(new Integer(
				utsDot3OnuRMAutoNegotiationVList[tfUtsDot3OnuRMAutoNegotiation.getSelectedIndex()]));

		// mbean.setUtsDot3OnuReset(new Integer(
		// utsDot3OnuResetVList[tfUtsDot3OnuReset.getSelectedIndex()]));
		if( tfUtsDot3OnuQinQ.isEnabled() ) {
			mbean.setUtsDot3OnuQinQ(new Integer(
					utsDot3OnuQinQVList[tfUtsDot3OnuQinQ.getSelectedIndex()]));
		}
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
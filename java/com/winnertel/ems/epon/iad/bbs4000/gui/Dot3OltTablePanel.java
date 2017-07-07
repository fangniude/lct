package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OltTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3OltTablePanel class. Created by DVM Creator
 */
public class Dot3OltTablePanel extends UPanel
{

	private JLabel tfIfIndex = new JLabel();

//	private JLabel tfUtsDot3OltModuleId = new JLabel();
//
//	private JLabel tfUtsDot3OltPortId = new JLabel();
//
//	private int[] utsDot3OltOperStatusVList = new int[]
//	{ 1, 2, };
//
//	private String[] utsDot3OltOperStatusTList = new String[]
//	{ fStringMap.getString("up"), fStringMap.getString("down"), };
//
//	private JComboBox tfUtsDot3OltOperStatus = new JComboBox(
//			utsDot3OltOperStatusTList);
//
//	private MacAddressField tfUtsDot3OltMACAddress = new MacAddressField();
//
//	private JLabel tfUtsDot3OltMaxLLID = new JLabel();
//
//	private JLabel tfUtsDot3OltMACAddressAgingTime = new JLabel();
//
//	private int[] utsDot3OltARPPON2CNIVList = new int[]
//	{ 1, 2, };
//
//	private String[] utsDot3OltARPPON2CNITList = new String[]
//	{ fStringMap.getString("true"), fStringMap.getString("false"), };
//
//	private JComboBox tfUtsDot3OltARPPON2CNI = new JComboBox(
//			utsDot3OltARPPON2CNITList);
//
//	private int[] utsDot3OltARPCNI2PONVList = new int[]
//	{ 1, 2, };
//
//	private String[] utsDot3OltARPCNI2PONTList = new String[]
//	{ fStringMap.getString("true"), fStringMap.getString("false"), };
//
//	private JComboBox tfUtsDot3OltARPCNI2PON = new JComboBox(
//			utsDot3OltARPCNI2PONTList);
//
//	private int[] utsDot3OltIGMPSnoopingVList = new int[]
//	{ 1, 2, };
//
//	private String[] utsDot3OltIGMPSnoopingTList = new String[]
//	{ fStringMap.getString("true"), fStringMap.getString("false"), };
//
//	private JComboBox tfUtsDot3OltIGMPSnooping = new JComboBox(
//			utsDot3OltIGMPSnoopingTList);
//
//	private JLabel tfUtsDot3OltIGMPTimeout = new JLabel();
//
//	private JLabel tfUtsDot3OltVlanTagExchangeDnLinkPrefix = new JLabel();
//
//	private JLabel tfUtsDot3OltVlanStackNestedModeVlanType = new JLabel();
//
//	private int[] utsDot3OltMultiCopyBroadcastEnableVList = new int[]
//	{ 1, 2, };
//
//	private String[] utsDot3OltMultiCopyBroadcastEnableTList = new String[]
//	{ fStringMap.getString("true"), fStringMap.getString("false"), };
//
//	private JComboBox tfUtsDot3OltMultiCopyBroadcastEnable = new JComboBox(
//			utsDot3OltMultiCopyBroadcastEnableTList);
//
//	private int[] utsDot3OltDiscardUnlearnedAddressVList = new int[]
//	{ 1, 2, };
//
//	private String[] utsDot3OltDiscardUnlearnedAddressTList = new String[]
//	{ fStringMap.getString("true"), fStringMap.getString("false"), };
//
//	private JComboBox tfUtsDot3OltDiscardUnlearnedAddress = new JComboBox(
//			utsDot3OltDiscardUnlearnedAddressTList);
//
//	private JLabel tfUtsDot3OltHwVersion = new JLabel();
//
//	private JLabel tfUtsDot3OltFwVersion = new JLabel();
//
//	private int[] utsDot3OltTransceiverTypeVList = new int[]
//	{ 1, 3, 5, };
//
//	private String[] utsDot3OltTransceiverTypeTList = new String[]
//	{ fStringMap.getString("null"), fStringMap.getString("sff"),
//			fStringMap.getString("sfp"), };
//
//	private JComboBox tfUtsDot3OltTransceiverType = new JComboBox(
//			utsDot3OltTransceiverTypeTList);

	private int[] utsDot3OltAdminStatusVList = new int[]
	{ 1, 2 };

	private String[] utsDot3OltAdminStatusTList = new String[]
	{ fStringMap.getString("up"),
			fStringMap.getString("down") };

	private JComboBox tfUtsDot3OltAdminStatus = new JComboBox(
			utsDot3OltAdminStatusTList);

//	private int[] utsDot3OltTransceiverVendorVList = new int[]
//	{ 3, 5, 2, 1, 4, };
//
//	private String[] utsDot3OltTransceiverVendorTList = new String[]
//	{ fStringMap.getString("infineon"), fStringMap.getString("ezconn"),
//			fStringMap.getString("zonu"), fStringMap.getString("zenko"),
//			fStringMap.getString("fiberxon"), };
//
//	private JComboBox tfUtsDot3OltTransceiverVendor = new JComboBox(
//			utsDot3OltTransceiverVendorTList);
//
//	private JLabel tfUtsDot3OltRegisteredONUCount = new JLabel();

	private int[] utsDot3OltOamLimitVList = new int[]
	{ 2, 1 };

	private String[] utsDot3OltOamLimitTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable") };

	private JComboBox tfUtsDot3OltOamLimit = new JComboBox(
			utsDot3OltOamLimitTList);

	private int[] utsDot3OltRunningModeVList = new int[]
	{ 1, 2, };

	private String[] utsDot3OltRunningModeTList = new String[]
	{ fStringMap.getString("isp-service-tag-handling-mode"),
			fStringMap.getString("application-tag-handling-mode"), };

	private JComboBox tfUtsDot3OltRunningMode = new JComboBox(
			utsDot3OltRunningModeTList);

	private final String ifIndex = fStringMap.getString("ifIndex") + " : ";

//	private final String utsDot3OltModuleId = fStringMap
//			.getString("utsDot3OltModuleId")
//			+ " : ";
//
//	private final String utsDot3OltPortId = fStringMap
//			.getString("utsDot3OltPortId")
//			+ " : ";
//
//	private final String utsDot3OltOperStatus = fStringMap
//			.getString("utsDot3OltOperStatus")
//			+ " : ";
//
//	private final String utsDot3OltMACAddress = fStringMap
//			.getString("utsDot3OltMACAddress")
//			+ " : ";
//
//	private final String utsDot3OltMaxLLID = fStringMap
//			.getString("utsDot3OltMaxLLID")
//			+ " : ";
//
//	private final String utsDot3OltMACAddressAgingTime = fStringMap
//			.getString("utsDot3OltMACAddressAgingTime")
//			+ " : ";
//
//	private final String utsDot3OltARPPON2CNI = fStringMap
//			.getString("utsDot3OltARPPON2CNI")
//			+ " : ";
//
//	private final String utsDot3OltARPCNI2PON = fStringMap
//			.getString("utsDot3OltARPCNI2PON")
//			+ " : ";
//
//	private final String utsDot3OltIGMPSnooping = fStringMap
//			.getString("utsDot3OltIGMPSnooping")
//			+ " : ";
//
//	private final String utsDot3OltIGMPTimeout = fStringMap
//			.getString("utsDot3OltIGMPTimeout")
//			+ " : ";
//
//	private final String utsDot3OltVlanTagExchangeDnLinkPrefix = fStringMap
//			.getString("utsDot3OltVlanTagExchangeDnLinkPrefix")
//			+ " : ";
//
//	private final String utsDot3OltVlanStackNestedModeVlanType = fStringMap
//			.getString("utsDot3OltVlanStackNestedModeVlanType")
//			+ " : ";
//
//	private final String utsDot3OltMultiCopyBroadcastEnable = fStringMap
//			.getString("utsDot3OltMultiCopyBroadcastEnable")
//			+ " : ";
//
//	private final String utsDot3OltDiscardUnlearnedAddress = fStringMap
//			.getString("utsDot3OltDiscardUnlearnedAddress")
//			+ " : ";
//
//	private final String utsDot3OltHwVersion = fStringMap
//			.getString("utsDot3OltHwVersion")
//			+ " : ";
//
//	private final String utsDot3OltFwVersion = fStringMap
//			.getString("utsDot3OltFwVersion")
//			+ " : ";
//
//	private final String utsDot3OltTransceiverType = fStringMap
//			.getString("utsDot3OltTransceiverType")
//			+ " : ";

	private final String utsDot3OltAdminStatus = fStringMap
			.getString("utsDot3OltAdminStatus")
			+ " : ";

//	private final String utsDot3OltTransceiverVendor = fStringMap
//			.getString("utsDot3OltTransceiverVendor")
//			+ " : ";
//
//	private final String utsDot3OltRegisteredONUCount = fStringMap
//			.getString("utsDot3OltRegisteredONUCount")
//			+ " : ";

	private final String utsDot3OltOamLimit = fStringMap
			.getString("utsDot3OltOamLimit")
			+ " : ";

	private final String utsDot3OltRunningMode = fStringMap
			.getString("utsDot3OltRunningMode")
			+ " : ";

	public Dot3OltTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(ifIndex));
		baseInfoPanel.add(tfIfIndex);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3OltModuleId));
//		baseInfoPanel.add(tfUtsDot3OltModuleId);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltPortId));
//		baseInfoPanel.add(tfUtsDot3OltPortId);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltOperStatus));
//		baseInfoPanel.add(tfUtsDot3OltOperStatus);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltMACAddress));
//		baseInfoPanel.add(tfUtsDot3OltMACAddress);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltMaxLLID));
//		baseInfoPanel.add(tfUtsDot3OltMaxLLID);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltMACAddressAgingTime));
//		baseInfoPanel.add(tfUtsDot3OltMACAddressAgingTime);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltARPPON2CNI));
//		baseInfoPanel.add(tfUtsDot3OltARPPON2CNI);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltARPCNI2PON));
//		baseInfoPanel.add(tfUtsDot3OltARPCNI2PON);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltIGMPSnooping));
//		baseInfoPanel.add(tfUtsDot3OltIGMPSnooping);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltIGMPTimeout));
//		baseInfoPanel.add(tfUtsDot3OltIGMPTimeout);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltVlanTagExchangeDnLinkPrefix));
//		baseInfoPanel.add(tfUtsDot3OltVlanTagExchangeDnLinkPrefix);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltVlanStackNestedModeVlanType));
//		baseInfoPanel.add(tfUtsDot3OltVlanStackNestedModeVlanType);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltMultiCopyBroadcastEnable));
//		baseInfoPanel.add(tfUtsDot3OltMultiCopyBroadcastEnable);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltDiscardUnlearnedAddress));
//		baseInfoPanel.add(tfUtsDot3OltDiscardUnlearnedAddress);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltHwVersion));
//		baseInfoPanel.add(tfUtsDot3OltHwVersion);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltFwVersion));
//		baseInfoPanel.add(tfUtsDot3OltFwVersion);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverType));
//		baseInfoPanel.add(tfUtsDot3OltTransceiverType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltAdminStatus));
		tfUtsDot3OltAdminStatus.setName(fStringMap
				.getString("utsDot3OltAdminStatus"));
		baseInfoPanel.add(tfUtsDot3OltAdminStatus);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverVendor));
//		baseInfoPanel.add(tfUtsDot3OltTransceiverVendor);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OltRegisteredONUCount));
//		baseInfoPanel.add(tfUtsDot3OltRegisteredONUCount);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOamLimit));
		tfUtsDot3OltOamLimit
				.setName(fStringMap.getString("utsDot3OltOamLimit"));
		baseInfoPanel.add(tfUtsDot3OltOamLimit);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltRunningMode));
		tfUtsDot3OltRunningMode.setName(fStringMap
				.getString("utsDot3OltRunningMode"));
		baseInfoPanel.add(tfUtsDot3OltRunningMode);
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

	}

	protected void initForm()
	{

//		tfUtsDot3OltMACAddress.setEditable(false);

	}

	public void refresh()
	{

		Dot3OltTable mbean = (Dot3OltTable) getModel();

		tfIfIndex.setText(ConfigUtility.formatIfIndex(mbean.getIfIndex().toString()));
//		tfUtsDot3OltModuleId.setText(mbean.getUtsDot3OltModuleId().toString());
//		tfUtsDot3OltPortId.setText(mbean.getUtsDot3OltPortId().toString());
//		tfUtsDot3OltOperStatus.setSelectedIndex(getIndexFromValue(
//				utsDot3OltOperStatusVList, mbean.getUtsDot3OltOperStatus()
//						.intValue()));
//		tfUtsDot3OltMACAddress.setValue(mbean.getUtsDot3OltMACAddress());
//		tfUtsDot3OltMaxLLID.setText(mbean.getUtsDot3OltMaxLLID().toString());
//		tfUtsDot3OltMACAddressAgingTime.setText(mbean
//				.getUtsDot3OltMACAddressAgingTime().toString());
//		tfUtsDot3OltARPPON2CNI.setSelectedIndex(getIndexFromValue(
//				utsDot3OltARPPON2CNIVList, mbean.getUtsDot3OltARPPON2CNI()
//						.intValue()));
//		tfUtsDot3OltARPCNI2PON.setSelectedIndex(getIndexFromValue(
//				utsDot3OltARPCNI2PONVList, mbean.getUtsDot3OltARPCNI2PON()
//						.intValue()));
//		tfUtsDot3OltIGMPSnooping.setSelectedIndex(getIndexFromValue(
//				utsDot3OltIGMPSnoopingVList, mbean.getUtsDot3OltIGMPSnooping()
//						.intValue()));
//		tfUtsDot3OltIGMPTimeout.setText(mbean.getUtsDot3OltIGMPTimeout()
//				.toString());
//		tfUtsDot3OltVlanTagExchangeDnLinkPrefix.setText(mbean
//				.getUtsDot3OltVlanTagExchangeDnLinkPrefix().toString());
//		tfUtsDot3OltVlanStackNestedModeVlanType.setText(mbean
//				.getUtsDot3OltVlanStackNestedModeVlanType().toString());
//		tfUtsDot3OltMultiCopyBroadcastEnable
//				.setSelectedIndex(getIndexFromValue(
//						utsDot3OltMultiCopyBroadcastEnableVList, mbean
//								.getUtsDot3OltMultiCopyBroadcastEnable()
//								.intValue()));
//		tfUtsDot3OltDiscardUnlearnedAddress.setSelectedIndex(getIndexFromValue(
//				utsDot3OltDiscardUnlearnedAddressVList, mbean
//						.getUtsDot3OltDiscardUnlearnedAddress().intValue()));
//		tfUtsDot3OltHwVersion.setText(mbean.getUtsDot3OltHwVersion());
//		tfUtsDot3OltFwVersion.setText(mbean.getUtsDot3OltFwVersion());
//		tfUtsDot3OltTransceiverType.setSelectedIndex(getIndexFromValue(
//				utsDot3OltTransceiverTypeVList, mbean
//						.getUtsDot3OltTransceiverType().intValue()));
		tfUtsDot3OltAdminStatus.setSelectedIndex(getIndexFromValue(
				utsDot3OltAdminStatusVList, mbean.getUtsDot3OltAdminStatus()
						.intValue()));
//		tfUtsDot3OltTransceiverVendor.setSelectedIndex(getIndexFromValue(
//				utsDot3OltTransceiverVendorVList, mbean
//						.getUtsDot3OltTransceiverVendor().intValue()));
//		tfUtsDot3OltRegisteredONUCount.setText(mbean
//				.getUtsDot3OltRegisteredONUCount().toString());
		tfUtsDot3OltOamLimit.setSelectedIndex(getIndexFromValue(
				utsDot3OltOamLimitVList, mbean.getUtsDot3OltOamLimit()
						.intValue()));
		tfUtsDot3OltRunningMode.setSelectedIndex(getIndexFromValue(
				utsDot3OltRunningModeVList, mbean.getUtsDot3OltRunningMode()
						.intValue()));

	}

	public void updateModel()
	{

		Dot3OltTable mbean = (Dot3OltTable) getModel();

		mbean.setUtsDot3OltAdminStatus(new Integer(
				utsDot3OltAdminStatusVList[tfUtsDot3OltAdminStatus
						.getSelectedIndex()]));

		mbean.setUtsDot3OltOamLimit(new Integer(
						utsDot3OltOamLimitVList[tfUtsDot3OltOamLimit
								.getSelectedIndex()]));
		mbean.setUtsDot3OltRunningMode(new Integer(
				utsDot3OltRunningModeVList[tfUtsDot3OltRunningMode
						.getSelectedIndex()]));
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

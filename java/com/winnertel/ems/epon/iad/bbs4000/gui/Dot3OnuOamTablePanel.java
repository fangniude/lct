package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OnuOamTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3OnuOamTablePanel class. Created by DVM Creator
 */
public class Dot3OnuOamTablePanel extends UPanel
{

	private JLabel tfIfIndex = new JLabel();

	private JLabel tfUtsDot3OnuOAMModuleId = new JLabel();

	private JLabel tfUtsDot3OnuOAMPortId = new JLabel();

	private JLabel tfUtsDot3OnuOAMLogicalPortId = new JLabel();

	private int[] utsDot3OnuOAMModeVList = new int[]
	{ 2, 1, };

	private String[] utsDot3OnuOAMModeTList = new String[]
	{ fStringMap.getString("active"), fStringMap.getString("passive"), };

	private JComboBox tfUtsDot3OnuOAMMode = new JComboBox(
			utsDot3OnuOAMModeTList);

	private JLabel tfUtsDot3OnuOAMDeviceIdentifier = new JLabel();

	private JLabel tfUtsDot3OnuOAMVersionIdentifier = new JLabel();

//	private IntegerTextField tfUtsDot3OnuOAMLinktestTotalFrame = new IntegerTextField();
//
//	private IntegerTextField tfUtsDot3OnuOAMLinktestFrameSize = new IntegerTextField();
//
//	private int[] utsDot3OnuOAMLinktestDelayMeasureEnableVList = new int[]
//	{ 1, 2, };
//
//	private String[] utsDot3OnuOAMLinktestDelayMeasureEnableTList = new String[]
//	{ fStringMap.getString("true"), fStringMap.getString("false"), };
//
//	private JComboBox tfUtsDot3OnuOAMLinktestDelayMeasureEnable = new JComboBox(
//			utsDot3OnuOAMLinktestDelayMeasureEnableTList);
//
//	private int[] utsDot3OnuOAMLinktestVLANTagEnableVList = new int[]
//	{ 1, 2, };
//
//	private String[] utsDot3OnuOAMLinktestVLANTagEnableTList = new String[]
//	{ fStringMap.getString("true"), fStringMap.getString("false"), };
//
//	private JComboBox tfUtsDot3OnuOAMLinktestVLANTagEnable = new JComboBox(
//			utsDot3OnuOAMLinktestVLANTagEnableTList);
//
//	private JLabel tfUtsDot3OnuOAMLinktestVLANTagPriority = new JLabel();
//
//	private JLabel tfUtsDot3OnuOAMLinktestVLANTagVID = new JLabel();
//
//	private JLabel tfUtsDot3OnuOAMLinktestFrameSent = new JLabel();
//
//	private JLabel tfUtsDot3OnuOAMLinktestFrameReceived = new JLabel();
//
//	private JLabel tfUtsDot3OnuOAMLinktestErrFrameReceived = new JLabel();
//
//	private JLabel tfUtsDot3OnuOAMLinktestMinDelay = new JLabel();
//
//	private JLabel tfUtsDot3OnuOAMLinktestMeanDelay = new JLabel();
//
//	private JLabel tfUtsDot3OnuOAMLinktestMaxDelay = new JLabel();
//
//	private JLabel tfUtsDot3OnuOAMPingElapsedTime = new JLabel();

	private int[] utsDot3OnuOAMPortStateVList = new int[]
	{ 1, 2, };

	private String[] utsDot3OnuOAMPortStateTList = new String[]
	{ fStringMap.getString("onuOAMOk"),
			fStringMap.getString("onuOAMnotRunning"), };

	private JComboBox tfUtsDot3OnuOAMPortState = new JComboBox(
			utsDot3OnuOAMPortStateTList);

//	private int[] utsDot3OnuOAMStartTestVList = new int[]
//	{ 2, 1, 3, };
//
//	private String[] utsDot3OnuOAMStartTestTList = new String[]
//	{ fStringMap.getString("onulinktest"),
//			fStringMap.getString("onuloopbacktest"),
//			fStringMap.getString("onupingtest"), };
//
//	private JComboBox tfUtsDot3OnuOAMStartTest = new JComboBox(
//			utsDot3OnuOAMStartTestTList);
//
//	private int[] utsDot3OnuOAMLinkTestStatusVList = new int[]
//	{ 3, 1, 2, };
//
//	private String[] utsDot3OnuOAMLinkTestStatusTList = new String[]
//	{ fStringMap.getString("busy"), fStringMap.getString("success"),
//			fStringMap.getString("failure"), };
//
//	private JComboBox tfUtsDot3OnuOAMLinkTestStatus = new JComboBox(
//			utsDot3OnuOAMLinkTestStatusTList);
//
//	private StringTextField tfUtsDot3OnuOAMLinkTestStationId = new StringTextField();
//
//	private JLabel tfUtsDot3OnuOAMLinkTestResultStr = new JLabel();
//
//	private int[] utsDot3OnuOAMPingStatusVList = new int[]
//	{ 3, 1, 2, };
//
//	private String[] utsDot3OnuOAMPingStatusTList = new String[]
//	{ fStringMap.getString("busy"), fStringMap.getString("success"),
//			fStringMap.getString("failure"), };
//
//	private JComboBox tfUtsDot3OnuOAMPingStatus = new JComboBox(
//			utsDot3OnuOAMPingStatusTList);
//
//	private StringTextField tfUtsDot3OnuOAMPingStationId = new StringTextField();
//
//	private JLabel tfUtsDot3OnuOAMPingResultStr = new JLabel();

	private final String ifIndex = fStringMap.getString("ifOnuIndex") + " : ";

	private final String utsDot3OnuOAMModuleId = fStringMap
			.getString("utsDot3OnuOAMModuleId")
			+ " : ";

	private final String utsDot3OnuOAMPortId = fStringMap
			.getString("utsDot3OnuOAMPortId")
			+ " : ";

	private final String utsDot3OnuOAMLogicalPortId = fStringMap
			.getString("utsDot3OnuOAMLogicalPortId")
			+ " : ";

	private final String utsDot3OnuOAMMode = fStringMap
			.getString("utsDot3OnuOAMMode")
			+ " : ";

	private final String utsDot3OnuOAMDeviceIdentifier = fStringMap
			.getString("utsDot3OnuOAMDeviceIdentifier")
			+ " : ";

	private final String utsDot3OnuOAMVersionIdentifier = fStringMap
			.getString("utsDot3OnuOAMVersionIdentifier")
			+ " : ";

//	private final String utsDot3OnuOAMLinktestTotalFrame = fStringMap
//			.getString("utsDot3OnuOAMLinktestTotalFrame")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestFrameSize = fStringMap
//			.getString("utsDot3OnuOAMLinktestFrameSize")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestDelayMeasureEnable = fStringMap
//			.getString("utsDot3OnuOAMLinktestDelayMeasureEnable")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestVLANTagEnable = fStringMap
//			.getString("utsDot3OnuOAMLinktestVLANTagEnable")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestVLANTagPriority = fStringMap
//			.getString("utsDot3OnuOAMLinktestVLANTagPriority")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestVLANTagVID = fStringMap
//			.getString("utsDot3OnuOAMLinktestVLANTagVID")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestFrameSent = fStringMap
//			.getString("utsDot3OnuOAMLinktestFrameSent")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestFrameReceived = fStringMap
//			.getString("utsDot3OnuOAMLinktestFrameReceived")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestErrFrameReceived = fStringMap
//			.getString("utsDot3OnuOAMLinktestErrFrameReceived")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestMinDelay = fStringMap
//			.getString("utsDot3OnuOAMLinktestMinDelay")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestMeanDelay = fStringMap
//			.getString("utsDot3OnuOAMLinktestMeanDelay")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinktestMaxDelay = fStringMap
//			.getString("utsDot3OnuOAMLinktestMaxDelay")
//			+ " : ";
//
//	private final String utsDot3OnuOAMPingElapsedTime = fStringMap
//			.getString("utsDot3OnuOAMPingElapsedTime")
//			+ " : ";

	private final String utsDot3OnuOAMPortState = fStringMap
			.getString("utsDot3OnuOAMPortState")
			+ " : ";

//	private final String utsDot3OnuOAMStartTest = fStringMap
//			.getString("utsDot3OnuOAMStartTest")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinkTestStatus = fStringMap
//			.getString("utsDot3OnuOAMLinkTestStatus")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinkTestStationId = fStringMap
//			.getString("utsDot3OnuOAMLinkTestStationId")
//			+ " : ";
//
//	private final String utsDot3OnuOAMLinkTestResultStr = fStringMap
//			.getString("utsDot3OnuOAMLinkTestResultStr")
//			+ " : ";
//
//	private final String utsDot3OnuOAMPingStatus = fStringMap
//			.getString("utsDot3OnuOAMPingStatus")
//			+ " : ";
//
//	private final String utsDot3OnuOAMPingStationId = fStringMap
//			.getString("utsDot3OnuOAMPingStationId")
//			+ " : ";
//
//	private final String utsDot3OnuOAMPingResultStr = fStringMap
//			.getString("utsDot3OnuOAMPingResultStr")
//			+ " : ";

	public Dot3OnuOamTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(28, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(ifIndex));
		baseInfoPanel.add(tfIfIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMModuleId));
		baseInfoPanel.add(tfUtsDot3OnuOAMModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMPortId));
		baseInfoPanel.add(tfUtsDot3OnuOAMPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLogicalPortId));
		baseInfoPanel.add(tfUtsDot3OnuOAMLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMMode));
		baseInfoPanel.add(tfUtsDot3OnuOAMMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMDeviceIdentifier));
		baseInfoPanel.add(tfUtsDot3OnuOAMDeviceIdentifier);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMVersionIdentifier));
		baseInfoPanel.add(tfUtsDot3OnuOAMVersionIdentifier);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestTotalFrame));
//		tfUtsDot3OnuOAMLinktestTotalFrame.setName(fStringMap
//				.getString("utsDot3OnuOAMLinktestTotalFrame"));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestTotalFrame);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestFrameSize));
//		tfUtsDot3OnuOAMLinktestFrameSize.setName(fStringMap
//				.getString("utsDot3OnuOAMLinktestFrameSize"));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestFrameSize);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestDelayMeasureEnable));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestDelayMeasureEnable);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestVLANTagEnable));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestVLANTagEnable);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestVLANTagPriority));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestVLANTagPriority);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestVLANTagVID));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestVLANTagVID);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestFrameSent));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestFrameSent);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestFrameReceived));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestFrameReceived);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestErrFrameReceived));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestErrFrameReceived);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestMinDelay));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestMinDelay);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestMeanDelay));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestMeanDelay);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestMaxDelay));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestMaxDelay);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMPingElapsedTime));
//		baseInfoPanel.add(tfUtsDot3OnuOAMPingElapsedTime);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMPortState));
		baseInfoPanel.add(tfUtsDot3OnuOAMPortState);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMStartTest));
//		tfUtsDot3OnuOAMStartTest.setName(fStringMap
//				.getString("utsDot3OnuOAMStartTest"));
//		baseInfoPanel.add(tfUtsDot3OnuOAMStartTest);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinkTestStatus));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinkTestStatus);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinkTestStationId));
//		tfUtsDot3OnuOAMLinkTestStationId.setName(fStringMap
//				.getString("utsDot3OnuOAMLinkTestStationId"));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinkTestStationId);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinkTestResultStr));
//		baseInfoPanel.add(tfUtsDot3OnuOAMLinkTestResultStr);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMPingStatus));
//		baseInfoPanel.add(tfUtsDot3OnuOAMPingStatus);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMPingStationId));
//		tfUtsDot3OnuOAMPingStationId.setName(fStringMap
//				.getString("utsDot3OnuOAMPingStationId"));
//		baseInfoPanel.add(tfUtsDot3OnuOAMPingStationId);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3OnuOAMPingResultStr));
//		baseInfoPanel.add(tfUtsDot3OnuOAMPingResultStr);
//		baseInfoPanel.add(new HSpacer());

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

//		tfUtsDot3OnuOAMLinktestTotalFrame.setValueScope(0, 1000);
//
//		tfUtsDot3OnuOAMLinktestFrameSize.setValueScope(60, 1514);
//
//		tfUtsDot3OnuOAMLinkTestStationId.setLenScope(0, 16);
//
//		tfUtsDot3OnuOAMPingStationId.setLenScope(0, 16);

	}

	public void refresh()
	{

		Dot3OnuOamTable mbean = (Dot3OnuOamTable) getModel();

		tfIfIndex.setText(mbean.getIfOnuIndex().toString());
		tfUtsDot3OnuOAMModuleId.setText(mbean.getUtsDot3OnuOAMModuleId()
				.toString());
		tfUtsDot3OnuOAMPortId
				.setText(mbean.getUtsDot3OnuOAMPortId().toString());
		tfUtsDot3OnuOAMLogicalPortId.setText(mbean
				.getUtsDot3OnuOAMLogicalPortId().toString());
		tfUtsDot3OnuOAMMode
				.setSelectedIndex(getIndexFromValue(utsDot3OnuOAMModeVList,
						mbean.getUtsDot3OnuOAMMode().intValue()));
		tfUtsDot3OnuOAMDeviceIdentifier.setText(mbean
				.getUtsDot3OnuOAMDeviceIdentifier().toString());
		tfUtsDot3OnuOAMVersionIdentifier.setText(mbean
				.getUtsDot3OnuOAMVersionIdentifier().toString());
//		tfUtsDot3OnuOAMLinktestTotalFrame.setValue(mbean
//				.getUtsDot3OnuOAMLinktestTotalFrame().intValue());
//		tfUtsDot3OnuOAMLinktestFrameSize.setValue(mbean
//				.getUtsDot3OnuOAMLinktestFrameSize().intValue());
//		tfUtsDot3OnuOAMLinktestDelayMeasureEnable
//				.setSelectedIndex(getIndexFromValue(
//						utsDot3OnuOAMLinktestDelayMeasureEnableVList, mbean
//								.getUtsDot3OnuOAMLinktestDelayMeasureEnable()
//								.intValue()));
//		tfUtsDot3OnuOAMLinktestVLANTagEnable
//				.setSelectedIndex(getIndexFromValue(
//						utsDot3OnuOAMLinktestVLANTagEnableVList, mbean
//								.getUtsDot3OnuOAMLinktestVLANTagEnable()
//								.intValue()));
//		tfUtsDot3OnuOAMLinktestVLANTagPriority.setText(mbean
//				.getUtsDot3OnuOAMLinktestVLANTagPriority().toString());
//		tfUtsDot3OnuOAMLinktestVLANTagVID.setText(mbean
//				.getUtsDot3OnuOAMLinktestVLANTagVID().toString());
//		tfUtsDot3OnuOAMLinktestFrameSent.setText(mbean
//				.getUtsDot3OnuOAMLinktestFrameSent().toString());
//		tfUtsDot3OnuOAMLinktestFrameReceived.setText(mbean
//				.getUtsDot3OnuOAMLinktestFrameReceived().toString());
//		tfUtsDot3OnuOAMLinktestErrFrameReceived.setText(mbean
//				.getUtsDot3OnuOAMLinktestErrFrameReceived().toString());
//		tfUtsDot3OnuOAMLinktestMinDelay.setText(mbean
//				.getUtsDot3OnuOAMLinktestMinDelay().toString());
//		tfUtsDot3OnuOAMLinktestMeanDelay.setText(mbean
//				.getUtsDot3OnuOAMLinktestMeanDelay().toString());
//		tfUtsDot3OnuOAMLinktestMaxDelay.setText(mbean
//				.getUtsDot3OnuOAMLinktestMaxDelay().toString());
//		tfUtsDot3OnuOAMPingElapsedTime.setText(mbean
//				.getUtsDot3OnuOAMPingElapsedTime().toString());
//		tfUtsDot3OnuOAMPortState.setSelectedIndex(getIndexFromValue(
//				utsDot3OnuOAMPortStateVList, mbean.getUtsDot3OnuOAMPortState()
//						.intValue()));
//		tfUtsDot3OnuOAMStartTest.setSelectedIndex(getIndexFromValue(
//				utsDot3OnuOAMStartTestVList, mbean.getUtsDot3OnuOAMStartTest()
//						.intValue()));
//		tfUtsDot3OnuOAMLinkTestStatus.setSelectedIndex(getIndexFromValue(
//				utsDot3OnuOAMLinkTestStatusVList, mbean
//						.getUtsDot3OnuOAMLinkTestStatus().intValue()));
//		tfUtsDot3OnuOAMLinkTestStationId.setValue(mbean
//				.getUtsDot3OnuOAMLinkTestStationId());
//		tfUtsDot3OnuOAMLinkTestResultStr.setText(mbean
//				.getUtsDot3OnuOAMLinkTestResultStr());
//		tfUtsDot3OnuOAMPingStatus.setSelectedIndex(getIndexFromValue(
//				utsDot3OnuOAMPingStatusVList, mbean
//						.getUtsDot3OnuOAMPingStatus().intValue()));
//		tfUtsDot3OnuOAMPingStationId.setValue(mbean
//				.getUtsDot3OnuOAMPingStationId());
//		tfUtsDot3OnuOAMPingResultStr.setText(mbean
//				.getUtsDot3OnuOAMPingResultStr());

	}

	public void updateModel()
	{

//		Dot3OnuOamTable mbean = (Dot3OnuOamTable) getModel();
//
//		mbean.setUtsDot3OnuOAMLinktestTotalFrame(new Integer(
//				tfUtsDot3OnuOAMLinktestTotalFrame.getValue()));
//		mbean.setUtsDot3OnuOAMLinktestFrameSize(new Integer(
//				tfUtsDot3OnuOAMLinktestFrameSize.getValue()));
//
//		mbean.setUtsDot3OnuOAMStartTest(new Integer(
//				utsDot3OnuOAMStartTestVList[tfUtsDot3OnuOAMStartTest
//						.getSelectedIndex()]));
//
//		mbean.setUtsDot3OnuOAMLinkTestStationId(new String(
//				tfUtsDot3OnuOAMLinkTestStationId.getValue()));
//
//		mbean.setUtsDot3OnuOAMPingStationId(new String(
//				tfUtsDot3OnuOAMPingStationId.getValue()));
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

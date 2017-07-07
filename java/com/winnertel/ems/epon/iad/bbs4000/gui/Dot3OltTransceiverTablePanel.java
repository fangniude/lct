package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OltTransceiverTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3OltTransceiverTablePanel class. Created by DVM Creator
 */
public class Dot3OltTransceiverTablePanel extends UPanel
{

	private JLabel tfUtsDot3OltTransceiverIndex = new JLabel();

	private JLabel tfUtsDot3OltTransceiverPONPortLinkIndPolarity = new JLabel();

	private JLabel tfUtsDot3OltTransceiverAGCResetGateOffset = new JLabel();

	private JLabel tfUtsDot3OltTransceiverAGCResetDiscoveryOffset = new JLabel();

	private JLabel tfUtsDot3OltTransceiverAGCResetDuration = new JLabel();

	private JLabel tfUtsDot3OltTransceiverAGCResetPolarity = new JLabel();

	private JLabel tfUtsDot3OltTransceiverCDRResetGateOffset = new JLabel();

	private JLabel tfUtsDot3OltTransceiverCDRResetDiscoveryOffset = new JLabel();

	private JLabel tfUtsDot3OltTransceiverCDRResetDuration = new JLabel();

	private JLabel tfUtsDot3OltTransceiverCDRResetPolarity = new JLabel();

	private JLabel tfUtsDot3OltTransceiverEndGrantResetOffset = new JLabel();

	private JLabel tfUtsDot3OltTransceiverEndGrantResetDuration = new JLabel();

	private JLabel tfUtsDot3OltTransceiverEndGrantResetPolarity = new JLabel();

	private int[] utsDot3OltTransceiverDiscoveryRelockEnableVList = new int[]
	{ 1, 2, };

	private String[] utsDot3OltTransceiverDiscoveryRelockEnableTList = new String[]
	{ fStringMap.getString("true"), fStringMap.getString("false"), };

	private JComboBox tfUtsDot3OltTransceiverDiscoveryRelockEnable = new JComboBox(
			utsDot3OltTransceiverDiscoveryRelockEnableTList);

	private JLabel tfUtsDot3OltTransceiverDiscoveryLaserRxLossPolarity = new JLabel();

	private JLabel tfUtsDot3OltTransceiverPONTxDisablePolarity = new JLabel();

	private JLabel tfUtsDot3OltTransceiverOpticsDeadZone = new JLabel();

	private int[] utsDot3OltTransceiverUseOpticsSignalLossVList = new int[]
	{ 1, 2, };

	private String[] utsDot3OltTransceiverUseOpticsSignalLossTList = new String[]
	{ fStringMap.getString("true"), fStringMap.getString("false"), };

	private JComboBox tfUtsDot3OltTransceiverUseOpticsSignalLoss = new JComboBox(
			utsDot3OltTransceiverUseOpticsSignalLossTList);

	private JLabel tfUtsDot3OltTransceiverAGCLockTime = new JLabel();

	private JLabel tfUtsDot3OltTransceiverCDRLockTime = new JLabel();

	private final String utsDot3OltTransceiverIndex = fStringMap
			.getString("utsDot3OltTransceiverIndex")
			+ " : ";

	private final String utsDot3OltTransceiverPONPortLinkIndPolarity = fStringMap
			.getString("utsDot3OltTransceiverPONPortLinkIndPolarity")
			+ " : ";

	private final String utsDot3OltTransceiverAGCResetGateOffset = fStringMap
			.getString("utsDot3OltTransceiverAGCResetGateOffset")
			+ " : ";

	private final String utsDot3OltTransceiverAGCResetDiscoveryOffset = fStringMap
			.getString("utsDot3OltTransceiverAGCResetDiscoveryOffset")
			+ " : ";

	private final String utsDot3OltTransceiverAGCResetDuration = fStringMap
			.getString("utsDot3OltTransceiverAGCResetDuration")
			+ " : ";

	private final String utsDot3OltTransceiverAGCResetPolarity = fStringMap
			.getString("utsDot3OltTransceiverAGCResetPolarity")
			+ " : ";

	private final String utsDot3OltTransceiverCDRResetGateOffset = fStringMap
			.getString("utsDot3OltTransceiverCDRResetGateOffset")
			+ " : ";

	private final String utsDot3OltTransceiverCDRResetDiscoveryOffset = fStringMap
			.getString("utsDot3OltTransceiverCDRResetDiscoveryOffset")
			+ " : ";

	private final String utsDot3OltTransceiverCDRResetDuration = fStringMap
			.getString("utsDot3OltTransceiverCDRResetDuration")
			+ " : ";

	private final String utsDot3OltTransceiverCDRResetPolarity = fStringMap
			.getString("utsDot3OltTransceiverCDRResetPolarity")
			+ " : ";

	private final String utsDot3OltTransceiverEndGrantResetOffset = fStringMap
			.getString("utsDot3OltTransceiverEndGrantResetOffset")
			+ " : ";

	private final String utsDot3OltTransceiverEndGrantResetDuration = fStringMap
			.getString("utsDot3OltTransceiverEndGrantResetDuration")
			+ " : ";

	private final String utsDot3OltTransceiverEndGrantResetPolarity = fStringMap
			.getString("utsDot3OltTransceiverEndGrantResetPolarity")
			+ " : ";

	private final String utsDot3OltTransceiverDiscoveryRelockEnable = fStringMap
			.getString("utsDot3OltTransceiverDiscoveryRelockEnable")
			+ " : ";

	private final String utsDot3OltTransceiverDiscoveryLaserRxLossPolarity = fStringMap
			.getString("utsDot3OltTransceiverDiscoveryLaserRxLossPolarity")
			+ " : ";

	private final String utsDot3OltTransceiverPONTxDisablePolarity = fStringMap
			.getString("utsDot3OltTransceiverPONTxDisablePolarity")
			+ " : ";

	private final String utsDot3OltTransceiverOpticsDeadZone = fStringMap
			.getString("utsDot3OltTransceiverOpticsDeadZone")
			+ " : ";

	private final String utsDot3OltTransceiverUseOpticsSignalLoss = fStringMap
			.getString("utsDot3OltTransceiverUseOpticsSignalLoss")
			+ " : ";

	private final String utsDot3OltTransceiverAGCLockTime = fStringMap
			.getString("utsDot3OltTransceiverAGCLockTime")
			+ " : ";

	private final String utsDot3OltTransceiverCDRLockTime = fStringMap
			.getString("utsDot3OltTransceiverCDRLockTime")
			+ " : ";

	public Dot3OltTransceiverTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(20, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverIndex));
		baseInfoPanel.add(tfUtsDot3OltTransceiverIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OltTransceiverPONPortLinkIndPolarity));
		baseInfoPanel.add(tfUtsDot3OltTransceiverPONPortLinkIndPolarity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverAGCResetGateOffset));
		baseInfoPanel.add(tfUtsDot3OltTransceiverAGCResetGateOffset);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OltTransceiverAGCResetDiscoveryOffset));
		baseInfoPanel.add(tfUtsDot3OltTransceiverAGCResetDiscoveryOffset);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverAGCResetDuration));
		baseInfoPanel.add(tfUtsDot3OltTransceiverAGCResetDuration);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverAGCResetPolarity));
		baseInfoPanel.add(tfUtsDot3OltTransceiverAGCResetPolarity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverCDRResetGateOffset));
		baseInfoPanel.add(tfUtsDot3OltTransceiverCDRResetGateOffset);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OltTransceiverCDRResetDiscoveryOffset));
		baseInfoPanel.add(tfUtsDot3OltTransceiverCDRResetDiscoveryOffset);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverCDRResetDuration));
		baseInfoPanel.add(tfUtsDot3OltTransceiverCDRResetDuration);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverCDRResetPolarity));
		baseInfoPanel.add(tfUtsDot3OltTransceiverCDRResetPolarity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverEndGrantResetOffset));
		baseInfoPanel.add(tfUtsDot3OltTransceiverEndGrantResetOffset);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltTransceiverEndGrantResetDuration));
		baseInfoPanel.add(tfUtsDot3OltTransceiverEndGrantResetDuration);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltTransceiverEndGrantResetPolarity));
		baseInfoPanel.add(tfUtsDot3OltTransceiverEndGrantResetPolarity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltTransceiverDiscoveryRelockEnable));
		baseInfoPanel.add(tfUtsDot3OltTransceiverDiscoveryRelockEnable);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OltTransceiverDiscoveryLaserRxLossPolarity));
		baseInfoPanel.add(tfUtsDot3OltTransceiverDiscoveryLaserRxLossPolarity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OltTransceiverPONTxDisablePolarity));
		baseInfoPanel.add(tfUtsDot3OltTransceiverPONTxDisablePolarity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverOpticsDeadZone));
		baseInfoPanel.add(tfUtsDot3OltTransceiverOpticsDeadZone);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverUseOpticsSignalLoss));
		baseInfoPanel.add(tfUtsDot3OltTransceiverUseOpticsSignalLoss);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverAGCLockTime));
		baseInfoPanel.add(tfUtsDot3OltTransceiverAGCLockTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltTransceiverCDRLockTime));
		baseInfoPanel.add(tfUtsDot3OltTransceiverCDRLockTime);
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

	}

	public void refresh()
	{

		Dot3OltTransceiverTable mbean = (Dot3OltTransceiverTable) getModel();

		tfUtsDot3OltTransceiverIndex.setText(mbean
				.getUtsDot3OltTransceiverIndex().toString());
		tfUtsDot3OltTransceiverPONPortLinkIndPolarity.setText(mbean
				.getUtsDot3OltTransceiverPONPortLinkIndPolarity().toString());
		tfUtsDot3OltTransceiverAGCResetGateOffset.setText(mbean
				.getUtsDot3OltTransceiverAGCResetGateOffset().toString());
		tfUtsDot3OltTransceiverAGCResetDiscoveryOffset.setText(mbean
				.getUtsDot3OltTransceiverAGCResetDiscoveryOffset().toString());
		tfUtsDot3OltTransceiverAGCResetDuration.setText(mbean
				.getUtsDot3OltTransceiverAGCResetDuration().toString());
		tfUtsDot3OltTransceiverAGCResetPolarity.setText(mbean
				.getUtsDot3OltTransceiverAGCResetPolarity().toString());
		tfUtsDot3OltTransceiverCDRResetGateOffset.setText(mbean
				.getUtsDot3OltTransceiverCDRResetGateOffset().toString());
		tfUtsDot3OltTransceiverCDRResetDiscoveryOffset.setText(mbean
				.getUtsDot3OltTransceiverCDRResetDiscoveryOffset().toString());
		tfUtsDot3OltTransceiverCDRResetDuration.setText(mbean
				.getUtsDot3OltTransceiverCDRResetDuration().toString());
		tfUtsDot3OltTransceiverCDRResetPolarity.setText(mbean
				.getUtsDot3OltTransceiverCDRResetPolarity().toString());
		tfUtsDot3OltTransceiverEndGrantResetOffset.setText(mbean
				.getUtsDot3OltTransceiverEndGrantResetOffset().toString());
		tfUtsDot3OltTransceiverEndGrantResetDuration.setText(mbean
				.getUtsDot3OltTransceiverEndGrantResetDuration().toString());
		tfUtsDot3OltTransceiverEndGrantResetPolarity.setText(mbean
				.getUtsDot3OltTransceiverEndGrantResetPolarity().toString());
		tfUtsDot3OltTransceiverDiscoveryRelockEnable
				.setSelectedIndex(getIndexFromValue(
						utsDot3OltTransceiverDiscoveryRelockEnableVList,
						mbean.getUtsDot3OltTransceiverDiscoveryRelockEnable()
								.intValue()));
		tfUtsDot3OltTransceiverDiscoveryLaserRxLossPolarity.setText(mbean
				.getUtsDot3OltTransceiverDiscoveryLaserRxLossPolarity()
				.toString());
		tfUtsDot3OltTransceiverPONTxDisablePolarity.setText(mbean
				.getUtsDot3OltTransceiverPONTxDisablePolarity().toString());
		tfUtsDot3OltTransceiverOpticsDeadZone.setText(mbean
				.getUtsDot3OltTransceiverOpticsDeadZone().toString());
		tfUtsDot3OltTransceiverUseOpticsSignalLoss
				.setSelectedIndex(getIndexFromValue(
						utsDot3OltTransceiverUseOpticsSignalLossVList, mbean
								.getUtsDot3OltTransceiverUseOpticsSignalLoss()
								.intValue()));
		tfUtsDot3OltTransceiverAGCLockTime.setText(mbean
				.getUtsDot3OltTransceiverAGCLockTime().toString());
		tfUtsDot3OltTransceiverCDRLockTime.setText(mbean
				.getUtsDot3OltTransceiverCDRLockTime().toString());

	}

	public void updateModel()
	{
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

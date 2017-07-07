package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipPingTestResultTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2VoipPingTestResultTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2VoipPingTestResultTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private int[] utsDot3Onu2VoipPingTestResultVList = new int[] { 10, 3, 5, 2,
			7, 6, 1, 9, 8, 11, 4, };
	private String[] utsDot3Onu2VoipPingTestResultTList = new String[] {
			fStringMap.getString("dns-not-parse"),
			fStringMap.getString("test-not-restart"),
			fStringMap.getString("unknown-destip"),
			fStringMap.getString("test-in-progress"),
			fStringMap.getString("dest-port-not-activate"),
			fStringMap.getString("no-route"), fStringMap.getString("test-end"),
			fStringMap.getString("exceed-max-intercurrent-count"),
			fStringMap.getString("arp-failure"),
			fStringMap.getString("invalid-host-address"),
			fStringMap.getString("unknown-error"), };
	private JComboBox tfUtsDot3Onu2VoipPingTestResult = new JComboBox(
			utsDot3Onu2VoipPingTestResultTList);
	private JLabel tfUtsDot3Onu2VoipPingTxPackets = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPingRxPackets = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPingLostPackets = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPingLostPktRatio = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPingMinDelay = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPingMaxDelay = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPingAvgDelay = new JLabel();

	private final String utsDot3Onu2VoipModuleId = fStringMap
			.getString("utsDot3Onu2VoipModuleId")
			+ " : ";
	private final String utsDot3Onu2VoipDeviceId = fStringMap
			.getString("utsDot3Onu2VoipDeviceId")
			+ " : ";
	private final String utsDot3Onu2VoipPortId = fStringMap
			.getString("utsDot3Onu2VoipPortId")
			+ " : ";
	private final String utsDot3Onu2VoipLogicalPortId = fStringMap
			.getString("utsDot3Onu2VoipLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2VoipPingTestResult = fStringMap
			.getString("utsDot3Onu2VoipPingTestResult")
			+ " : ";
	private final String utsDot3Onu2VoipPingTxPackets = fStringMap
			.getString("utsDot3Onu2VoipPingTxPackets")
			+ " : ";
	private final String utsDot3Onu2VoipPingRxPackets = fStringMap
			.getString("utsDot3Onu2VoipPingRxPackets")
			+ " : ";
	private final String utsDot3Onu2VoipPingLostPackets = fStringMap
			.getString("utsDot3Onu2VoipPingLostPackets")
			+ " : ";
	private final String utsDot3Onu2VoipPingLostPktRatio = fStringMap
			.getString("utsDot3Onu2VoipPingLostPktRatio")
			+ " : ";
	private final String utsDot3Onu2VoipPingMinDelay = fStringMap
			.getString("utsDot3Onu2VoipPingMinDelay")
			+ " : ";
	private final String utsDot3Onu2VoipPingMaxDelay = fStringMap
			.getString("utsDot3Onu2VoipPingMaxDelay")
			+ " : ";
	private final String utsDot3Onu2VoipPingAvgDelay = fStringMap
			.getString("utsDot3Onu2VoipPingAvgDelay")
			+ " : ";

	public Dot3Onu2VoipPingTestResultTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(12, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipDeviceId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipDeviceId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingTestResult));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingTestResult);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingTxPackets));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingTxPackets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingRxPackets));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingRxPackets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingLostPackets));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingLostPackets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingLostPktRatio));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingLostPktRatio);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingMinDelay));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingMinDelay);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingMaxDelay));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingMaxDelay);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingAvgDelay));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingAvgDelay);
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

	protected void initForm() {

	}

	public void refresh() {

		Dot3Onu2VoipPingTestResultTable mbean = (Dot3Onu2VoipPingTestResultTable) getModel();

		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2VoipModuleId()
				.toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2VoipDeviceId()
				.toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2VoipPortId()
				.toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean
				.getUtsDot3Onu2VoipLogicalPortId().toString());
		tfUtsDot3Onu2VoipPingTestResult.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipPingTestResultVList, mbean
						.getUtsDot3Onu2VoipPingTestResult().intValue()));
		tfUtsDot3Onu2VoipPingTxPackets.setText(mbean
				.getUtsDot3Onu2VoipPingTxPackets().toString());
		tfUtsDot3Onu2VoipPingRxPackets.setText(mbean
				.getUtsDot3Onu2VoipPingRxPackets().toString());
		tfUtsDot3Onu2VoipPingLostPackets.setText(mbean
				.getUtsDot3Onu2VoipPingLostPackets().toString());
		tfUtsDot3Onu2VoipPingLostPktRatio.setText(mbean
				.getUtsDot3Onu2VoipPingLostPktRatio().toString());
		tfUtsDot3Onu2VoipPingMinDelay.setText(mbean
				.getUtsDot3Onu2VoipPingMinDelay().toString());
		tfUtsDot3Onu2VoipPingMaxDelay.setText(mbean
				.getUtsDot3Onu2VoipPingMaxDelay().toString());
		tfUtsDot3Onu2VoipPingAvgDelay.setText(mbean
				.getUtsDot3Onu2VoipPingAvgDelay().toString());

	}

	public void updateModel() {

		Dot3Onu2VoipPingTestResultTable mbean = (Dot3Onu2VoipPingTestResultTable) getModel();

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
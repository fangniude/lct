package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2PrivateUniStatsTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2PrivateUniStatsTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2PrivateUniStatsTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2Ctc3UniModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPhyPortId = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniOctetsReceivedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniOctetsReceivedBD = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniBroadcastFramesReceivedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniMulticastFramesReceivedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniUnicastFramesReceivedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniPONPauseFramesReceivedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniMacReceivedErrorFrame = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniFCSReceivedErrorFrame = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniUnderSizeFrame = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniOverSizeFrame = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniJabberFrame = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniOctetsTransmittedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniBroadcastFramesXmittedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniMulticastFramesXmittedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniUnicasetFramesXmittedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniPONPauseFramesXmittedOK = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniFCSTransmittedErrorFrame = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniDeferredFrame = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniExcessiveFrame = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniSingleCollisionFrames = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniMultipleCollisionFrames = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniLateFrames = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniCollisionFrames = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniRxTx64Octets = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniRxTx65to127Octets = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniRxTx128to255Octets = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniRxTx256to511Octets = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniRxTx512to1023Octets = new JLabel();

	private JLabel tfUtsDot3Onu2PrivateUniRxTx1024MoreOctets = new JLabel();

	private final String utsDot3Onu2Ctc3UniModuleId = fStringMap
			.getString("utsDot3Onu2Ctc3UniModuleId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniDeviceId = fStringMap
			.getString("utsDot3Onu2Ctc3UniDeviceId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniLogicalPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniPhyPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPhyPortId")
			+ " : ";
	private final String utsDot3Onu2PrivateUniOctetsReceivedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniOctetsReceivedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniOctetsReceivedBD = fStringMap
			.getString("utsDot3Onu2PrivateUniOctetsReceivedBD")
			+ " : ";
	private final String utsDot3Onu2PrivateUniBroadcastFramesReceivedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniBroadcastFramesReceivedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniMulticastFramesReceivedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniMulticastFramesReceivedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniUnicastFramesReceivedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniUnicastFramesReceivedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniPONPauseFramesReceivedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniPONPauseFramesReceivedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniMacReceivedErrorFrame = fStringMap
			.getString("utsDot3Onu2PrivateUniMacReceivedErrorFrame")
			+ " : ";
	private final String utsDot3Onu2PrivateUniFCSReceivedErrorFrame = fStringMap
			.getString("utsDot3Onu2PrivateUniFCSReceivedErrorFrame")
			+ " : ";
	private final String utsDot3Onu2PrivateUniUnderSizeFrame = fStringMap
			.getString("utsDot3Onu2PrivateUniUnderSizeFrame")
			+ " : ";
	private final String utsDot3Onu2PrivateUniOverSizeFrame = fStringMap
			.getString("utsDot3Onu2PrivateUniOverSizeFrame")
			+ " : ";
	private final String utsDot3Onu2PrivateUniJabberFrame = fStringMap
			.getString("utsDot3Onu2PrivateUniJabberFrame")
			+ " : ";
	private final String utsDot3Onu2PrivateUniOctetsTransmittedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniOctetsTransmittedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniBroadcastFramesXmittedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniBroadcastFramesXmittedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniMulticastFramesXmittedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniMulticastFramesXmittedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniUnicasetFramesXmittedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniUnicasetFramesXmittedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniPONPauseFramesXmittedOK = fStringMap
			.getString("utsDot3Onu2PrivateUniPONPauseFramesXmittedOK")
			+ " : ";
	private final String utsDot3Onu2PrivateUniFCSTransmittedErrorFrame = fStringMap
			.getString("utsDot3Onu2PrivateUniFCSTransmittedErrorFrame")
			+ " : ";
	private final String utsDot3Onu2PrivateUniDeferredFrame = fStringMap
			.getString("utsDot3Onu2PrivateUniDeferredFrame")
			+ " : ";
	private final String utsDot3Onu2PrivateUniExcessiveFrame = fStringMap
			.getString("utsDot3Onu2PrivateUniExcessiveFrame")
			+ " : ";
	private final String utsDot3Onu2PrivateUniSingleCollisionFrames = fStringMap
			.getString("utsDot3Onu2PrivateUniSingleCollisionFrames")
			+ " : ";
	private final String utsDot3Onu2PrivateUniMultipleCollisionFrames = fStringMap
			.getString("utsDot3Onu2PrivateUniMultipleCollisionFrames")
			+ " : ";
	private final String utsDot3Onu2PrivateUniLateFrames = fStringMap
			.getString("utsDot3Onu2PrivateUniLateFrames")
			+ " : ";
	private final String utsDot3Onu2PrivateUniCollisionFrames = fStringMap
			.getString("utsDot3Onu2PrivateUniCollisionFrames")
			+ " : ";
	private final String utsDot3Onu2PrivateUniRxTx64Octets = fStringMap
			.getString("utsDot3Onu2PrivateUniRxTx64Octets")
			+ " : ";
	private final String utsDot3Onu2PrivateUniRxTx65to127Octets = fStringMap
			.getString("utsDot3Onu2PrivateUniRxTx65to127Octets")
			+ " : ";
	private final String utsDot3Onu2PrivateUniRxTx128to255Octets = fStringMap
			.getString("utsDot3Onu2PrivateUniRxTx128to255Octets")
			+ " : ";
	private final String utsDot3Onu2PrivateUniRxTx256to511Octets = fStringMap
			.getString("utsDot3Onu2PrivateUniRxTx256to511Octets")
			+ " : ";
	private final String utsDot3Onu2PrivateUniRxTx512to1023Octets = fStringMap
			.getString("utsDot3Onu2PrivateUniRxTx512to1023Octets")
			+ " : ";
	private final String utsDot3Onu2PrivateUniRxTx1024MoreOctets = fStringMap
			.getString("utsDot3Onu2PrivateUniRxTx1024MoreOctets")
			+ " : ";

	public Dot3Onu2PrivateUniStatsTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(34, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniDeviceId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniDeviceId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPhyPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPhyPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniOctetsReceivedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniOctetsReceivedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniOctetsReceivedBD));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniOctetsReceivedBD);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniBroadcastFramesReceivedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniBroadcastFramesReceivedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniMulticastFramesReceivedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniMulticastFramesReceivedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniUnicastFramesReceivedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniUnicastFramesReceivedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniPONPauseFramesReceivedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniPONPauseFramesReceivedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2PrivateUniMacReceivedErrorFrame));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniMacReceivedErrorFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2PrivateUniFCSReceivedErrorFrame));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniFCSReceivedErrorFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniUnderSizeFrame));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniUnderSizeFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniOverSizeFrame));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniOverSizeFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniJabberFrame));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniJabberFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniOctetsTransmittedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniOctetsTransmittedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniBroadcastFramesXmittedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniBroadcastFramesXmittedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniMulticastFramesXmittedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniMulticastFramesXmittedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniUnicasetFramesXmittedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniUnicasetFramesXmittedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniPONPauseFramesXmittedOK));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniPONPauseFramesXmittedOK);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniFCSTransmittedErrorFrame));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniFCSTransmittedErrorFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniDeferredFrame));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniDeferredFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniExcessiveFrame));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniExcessiveFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2PrivateUniSingleCollisionFrames));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniSingleCollisionFrames);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3Onu2PrivateUniMultipleCollisionFrames));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniMultipleCollisionFrames);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniLateFrames));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniLateFrames);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniCollisionFrames));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniCollisionFrames);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniRxTx64Octets));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniRxTx64Octets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniRxTx65to127Octets));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniRxTx65to127Octets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniRxTx128to255Octets));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniRxTx128to255Octets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniRxTx256to511Octets));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniRxTx256to511Octets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniRxTx512to1023Octets));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniRxTx512to1023Octets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateUniRxTx1024MoreOctets));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateUniRxTx1024MoreOctets);
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

		Dot3Onu2PrivateUniStatsTable mbean = (Dot3Onu2PrivateUniStatsTable) getModel();

		tfUtsDot3Onu2Ctc3UniModuleId.setText(mbean
				.getUtsDot3Onu2Ctc3UniModuleId().toString());
		tfUtsDot3Onu2Ctc3UniDeviceId.setText(mbean
				.getUtsDot3Onu2Ctc3UniDeviceId().toString());
		tfUtsDot3Onu2Ctc3UniPortId.setText(mbean.getUtsDot3Onu2Ctc3UniPortId()
				.toString());
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniLogicalPortId().toString());
		tfUtsDot3Onu2Ctc3UniPhyPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniPhyPortId().toString());
		tfUtsDot3Onu2PrivateUniOctetsReceivedOK.setText(mbean
				.getUtsDot3Onu2PrivateUniOctetsReceivedOK().toString());
		tfUtsDot3Onu2PrivateUniOctetsReceivedBD.setText(mbean
				.getUtsDot3Onu2PrivateUniOctetsReceivedBD().toString());
		tfUtsDot3Onu2PrivateUniBroadcastFramesReceivedOK
				.setText(mbean
						.getUtsDot3Onu2PrivateUniBroadcastFramesReceivedOK()
						.toString());
		tfUtsDot3Onu2PrivateUniMulticastFramesReceivedOK
				.setText(mbean
						.getUtsDot3Onu2PrivateUniMulticastFramesReceivedOK()
						.toString());
		tfUtsDot3Onu2PrivateUniUnicastFramesReceivedOK.setText(mbean
				.getUtsDot3Onu2PrivateUniUnicastFramesReceivedOK().toString());
		tfUtsDot3Onu2PrivateUniPONPauseFramesReceivedOK.setText(mbean
				.getUtsDot3Onu2PrivateUniPONPauseFramesReceivedOK().toString());
		tfUtsDot3Onu2PrivateUniMacReceivedErrorFrame.setText(mbean
				.getUtsDot3Onu2PrivateUniMacReceivedErrorFrame().toString());
		tfUtsDot3Onu2PrivateUniFCSReceivedErrorFrame.setText(mbean
				.getUtsDot3Onu2PrivateUniFCSReceivedErrorFrame().toString());
		tfUtsDot3Onu2PrivateUniUnderSizeFrame.setText(mbean
				.getUtsDot3Onu2PrivateUniUnderSizeFrame().toString());
		tfUtsDot3Onu2PrivateUniOverSizeFrame.setText(mbean
				.getUtsDot3Onu2PrivateUniOverSizeFrame().toString());
		tfUtsDot3Onu2PrivateUniJabberFrame.setText(mbean
				.getUtsDot3Onu2PrivateUniJabberFrame().toString());
		tfUtsDot3Onu2PrivateUniOctetsTransmittedOK.setText(mbean
				.getUtsDot3Onu2PrivateUniOctetsTransmittedOK().toString());
		tfUtsDot3Onu2PrivateUniBroadcastFramesXmittedOK.setText(mbean
				.getUtsDot3Onu2PrivateUniBroadcastFramesXmittedOK().toString());
		tfUtsDot3Onu2PrivateUniMulticastFramesXmittedOK.setText(mbean
				.getUtsDot3Onu2PrivateUniMulticastFramesXmittedOK().toString());
		tfUtsDot3Onu2PrivateUniUnicasetFramesXmittedOK.setText(mbean
				.getUtsDot3Onu2PrivateUniUnicasetFramesXmittedOK().toString());
		tfUtsDot3Onu2PrivateUniPONPauseFramesXmittedOK.setText(mbean
				.getUtsDot3Onu2PrivateUniPONPauseFramesXmittedOK().toString());
		tfUtsDot3Onu2PrivateUniFCSTransmittedErrorFrame.setText(mbean
				.getUtsDot3Onu2PrivateUniFCSTransmittedErrorFrame().toString());
		tfUtsDot3Onu2PrivateUniDeferredFrame.setText(mbean
				.getUtsDot3Onu2PrivateUniDeferredFrame().toString());
		tfUtsDot3Onu2PrivateUniExcessiveFrame.setText(mbean
				.getUtsDot3Onu2PrivateUniExcessiveFrame().toString());
		tfUtsDot3Onu2PrivateUniSingleCollisionFrames.setText(mbean
				.getUtsDot3Onu2PrivateUniSingleCollisionFrames().toString());
		tfUtsDot3Onu2PrivateUniMultipleCollisionFrames.setText(mbean
				.getUtsDot3Onu2PrivateUniMultipleCollisionFrames().toString());
		tfUtsDot3Onu2PrivateUniLateFrames.setText(mbean
				.getUtsDot3Onu2PrivateUniLateFrames().toString());
		tfUtsDot3Onu2PrivateUniCollisionFrames.setText(mbean
				.getUtsDot3Onu2PrivateUniCollisionFrames().toString());
		tfUtsDot3Onu2PrivateUniRxTx64Octets.setText(mbean
				.getUtsDot3Onu2PrivateUniRxTx64Octets().toString());
		tfUtsDot3Onu2PrivateUniRxTx65to127Octets.setText(mbean
				.getUtsDot3Onu2PrivateUniRxTx65to127Octets().toString());
		tfUtsDot3Onu2PrivateUniRxTx128to255Octets.setText(mbean
				.getUtsDot3Onu2PrivateUniRxTx128to255Octets().toString());
		tfUtsDot3Onu2PrivateUniRxTx256to511Octets.setText(mbean
				.getUtsDot3Onu2PrivateUniRxTx256to511Octets().toString());
		tfUtsDot3Onu2PrivateUniRxTx512to1023Octets.setText(mbean
				.getUtsDot3Onu2PrivateUniRxTx512to1023Octets().toString());
		tfUtsDot3Onu2PrivateUniRxTx1024MoreOctets.setText(mbean
				.getUtsDot3Onu2PrivateUniRxTx1024MoreOctets().toString());

	}

	public void updateModel() {

		Dot3Onu2PrivateUniStatsTable mbean = (Dot3Onu2PrivateUniStatsTable) getModel();

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

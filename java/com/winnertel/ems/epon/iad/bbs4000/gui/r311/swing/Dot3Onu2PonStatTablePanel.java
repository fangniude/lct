package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2PonStatTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2PonStatTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2PonStatTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2Ctc3UniModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatLlid = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatFramesTxOk = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatOctetsTxOk = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatMulticastFramesTxOk = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatBroadcastFramesTxOk = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatFramesRxOk = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatOctetsRxOk = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatMulticastFramesRxOk = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatBroadcastFramesRxOk = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatCrcError = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatCorrectFecBlocks = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatUncorrectFecBlocks = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatTxMpcpControl = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatRxMpcpControl = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatTxRegister = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatTxRegisterRequest = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatTxReport = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatRxGate = new JLabel();

	private JLabel tfUtsDot3Onu2PonStatRxRegister = new JLabel();

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
	private final String utsDot3Onu2PonStatLlid = fStringMap
			.getString("utsDot3Onu2PonStatLlid")
			+ " : ";
	private final String utsDot3Onu2PonStatFramesTxOk = fStringMap
			.getString("utsDot3Onu2PonStatFramesTxOk")
			+ " : ";
	private final String utsDot3Onu2PonStatOctetsTxOk = fStringMap
			.getString("utsDot3Onu2PonStatOctetsTxOk")
			+ " : ";
	private final String utsDot3Onu2PonStatMulticastFramesTxOk = fStringMap
			.getString("utsDot3Onu2PonStatMulticastFramesTxOk")
			+ " : ";
	private final String utsDot3Onu2PonStatBroadcastFramesTxOk = fStringMap
			.getString("utsDot3Onu2PonStatBroadcastFramesTxOk")
			+ " : ";
	private final String utsDot3Onu2PonStatFramesRxOk = fStringMap
			.getString("utsDot3Onu2PonStatFramesRxOk")
			+ " : ";
	private final String utsDot3Onu2PonStatOctetsRxOk = fStringMap
			.getString("utsDot3Onu2PonStatOctetsRxOk")
			+ " : ";
	private final String utsDot3Onu2PonStatMulticastFramesRxOk = fStringMap
			.getString("utsDot3Onu2PonStatMulticastFramesRxOk")
			+ " : ";
	private final String utsDot3Onu2PonStatBroadcastFramesRxOk = fStringMap
			.getString("utsDot3Onu2PonStatBroadcastFramesRxOk")
			+ " : ";
	private final String utsDot3Onu2PonStatCrcError = fStringMap
			.getString("utsDot3Onu2PonStatCrcError")
			+ " : ";
	private final String utsDot3Onu2PonStatCorrectFecBlocks = fStringMap
			.getString("utsDot3Onu2PonStatCorrectFecBlocks")
			+ " : ";
	private final String utsDot3Onu2PonStatUncorrectFecBlocks = fStringMap
			.getString("utsDot3Onu2PonStatUncorrectFecBlocks")
			+ " : ";
	private final String utsDot3Onu2PonStatTxMpcpControl = fStringMap
			.getString("utsDot3Onu2PonStatTxMpcpControl")
			+ " : ";
	private final String utsDot3Onu2PonStatRxMpcpControl = fStringMap
			.getString("utsDot3Onu2PonStatRxMpcpControl")
			+ " : ";
	private final String utsDot3Onu2PonStatTxRegister = fStringMap
			.getString("utsDot3Onu2PonStatTxRegister")
			+ " : ";
	private final String utsDot3Onu2PonStatTxRegisterRequest = fStringMap
			.getString("utsDot3Onu2PonStatTxRegisterRequest")
			+ " : ";
	private final String utsDot3Onu2PonStatTxReport = fStringMap
			.getString("utsDot3Onu2PonStatTxReport")
			+ " : ";
	private final String utsDot3Onu2PonStatRxGate = fStringMap
			.getString("utsDot3Onu2PonStatRxGate")
			+ " : ";
	private final String utsDot3Onu2PonStatRxRegister = fStringMap
			.getString("utsDot3Onu2PonStatRxRegister")
			+ " : ";

	public Dot3Onu2PonStatTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(23, 3, NTLayout.FILL, NTLayout.CENTER,
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatLlid));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatLlid);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatFramesTxOk));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatFramesTxOk);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatOctetsTxOk));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatOctetsTxOk);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatMulticastFramesTxOk));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatMulticastFramesTxOk);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatBroadcastFramesTxOk));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatBroadcastFramesTxOk);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatFramesRxOk));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatFramesRxOk);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatOctetsRxOk));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatOctetsRxOk);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatMulticastFramesRxOk));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatMulticastFramesRxOk);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatBroadcastFramesRxOk));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatBroadcastFramesRxOk);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatCrcError));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatCrcError);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatCorrectFecBlocks));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatCorrectFecBlocks);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatUncorrectFecBlocks));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatUncorrectFecBlocks);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatTxMpcpControl));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatTxMpcpControl);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatRxMpcpControl));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatRxMpcpControl);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatTxRegister));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatTxRegister);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatTxRegisterRequest));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatTxRegisterRequest);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatTxReport));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatTxReport);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatRxGate));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatRxGate);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PonStatRxRegister));
		baseInfoPanel.add(tfUtsDot3Onu2PonStatRxRegister);
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

		Dot3Onu2PonStatTable mbean = (Dot3Onu2PonStatTable) getModel();

		tfUtsDot3Onu2Ctc3UniModuleId.setText(mbean
				.getUtsDot3Onu2Ctc3UniModuleId().toString());
		tfUtsDot3Onu2Ctc3UniDeviceId.setText(mbean
				.getUtsDot3Onu2Ctc3UniDeviceId().toString());
		tfUtsDot3Onu2Ctc3UniPortId.setText(mbean.getUtsDot3Onu2Ctc3UniPortId()
				.toString());
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniLogicalPortId().toString());
		tfUtsDot3Onu2PonStatLlid.setText(mbean.getUtsDot3Onu2PonStatLlid()
				.toString());
		tfUtsDot3Onu2PonStatFramesTxOk.setText(mbean
				.getUtsDot3Onu2PonStatFramesTxOk().toString());
		tfUtsDot3Onu2PonStatOctetsTxOk.setText(mbean
				.getUtsDot3Onu2PonStatOctetsTxOk().toString());
		tfUtsDot3Onu2PonStatMulticastFramesTxOk.setText(mbean
				.getUtsDot3Onu2PonStatMulticastFramesTxOk().toString());
		tfUtsDot3Onu2PonStatBroadcastFramesTxOk.setText(mbean
				.getUtsDot3Onu2PonStatBroadcastFramesTxOk().toString());
		tfUtsDot3Onu2PonStatFramesRxOk.setText(mbean
				.getUtsDot3Onu2PonStatFramesRxOk().toString());
		tfUtsDot3Onu2PonStatOctetsRxOk.setText(mbean
				.getUtsDot3Onu2PonStatOctetsRxOk().toString());
		tfUtsDot3Onu2PonStatMulticastFramesRxOk.setText(mbean
				.getUtsDot3Onu2PonStatMulticastFramesRxOk().toString());
		tfUtsDot3Onu2PonStatBroadcastFramesRxOk.setText(mbean
				.getUtsDot3Onu2PonStatBroadcastFramesRxOk().toString());
		tfUtsDot3Onu2PonStatCrcError.setText(mbean
				.getUtsDot3Onu2PonStatCrcError().toString());
		tfUtsDot3Onu2PonStatCorrectFecBlocks.setText(mbean
				.getUtsDot3Onu2PonStatCorrectFecBlocks().toString());
		tfUtsDot3Onu2PonStatUncorrectFecBlocks.setText(mbean
				.getUtsDot3Onu2PonStatUncorrectFecBlocks().toString());
		tfUtsDot3Onu2PonStatTxMpcpControl.setText(mbean
				.getUtsDot3Onu2PonStatTxMpcpControl().toString());
		tfUtsDot3Onu2PonStatRxMpcpControl.setText(mbean
				.getUtsDot3Onu2PonStatRxMpcpControl().toString());
		tfUtsDot3Onu2PonStatTxRegister.setText(mbean
				.getUtsDot3Onu2PonStatTxRegister().toString());
		tfUtsDot3Onu2PonStatTxRegisterRequest.setText(mbean
				.getUtsDot3Onu2PonStatTxRegisterRequest().toString());
		tfUtsDot3Onu2PonStatTxReport.setText(mbean
				.getUtsDot3Onu2PonStatTxReport().toString());
		tfUtsDot3Onu2PonStatRxGate.setText(mbean.getUtsDot3Onu2PonStatRxGate()
				.toString());
		tfUtsDot3Onu2PonStatRxRegister.setText(mbean
				.getUtsDot3Onu2PonStatRxRegister().toString());

	}

	public void updateModel() {

		Dot3Onu2PonStatTable mbean = (Dot3Onu2PonStatTable) getModel();

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

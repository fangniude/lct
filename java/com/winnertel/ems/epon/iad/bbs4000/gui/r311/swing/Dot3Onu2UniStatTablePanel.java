package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2UniStatTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2UniStatTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2UniStatTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2Ctc3UniModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatInOctets = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatInUcastPkts = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatInNucastPkts = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatInDiscards = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatInErrors = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatOutOctets = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatOutUcastPkts = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatOutNucastPkts = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatOutDiscards = new JLabel();

	private JLabel tfUtsDot3Onu2UniStatOutErrors = new JLabel();

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
	private final String utsDot3Onu2UniStatInOctets = fStringMap
			.getString("utsDot3Onu2UniStatInOctets")
			+ " : ";
	private final String utsDot3Onu2UniStatInUcastPkts = fStringMap
			.getString("utsDot3Onu2UniStatInUcastPkts")
			+ " : ";
	private final String utsDot3Onu2UniStatInNucastPkts = fStringMap
			.getString("utsDot3Onu2UniStatInNucastPkts")
			+ " : ";
	private final String utsDot3Onu2UniStatInDiscards = fStringMap
			.getString("utsDot3Onu2UniStatInDiscards")
			+ " : ";
	private final String utsDot3Onu2UniStatInErrors = fStringMap
			.getString("utsDot3Onu2UniStatInErrors")
			+ " : ";
	private final String utsDot3Onu2UniStatOutOctets = fStringMap
			.getString("utsDot3Onu2UniStatOutOctets")
			+ " : ";
	private final String utsDot3Onu2UniStatOutUcastPkts = fStringMap
			.getString("utsDot3Onu2UniStatOutUcastPkts")
			+ " : ";
	private final String utsDot3Onu2UniStatOutNucastPkts = fStringMap
			.getString("utsDot3Onu2UniStatOutNucastPkts")
			+ " : ";
	private final String utsDot3Onu2UniStatOutDiscards = fStringMap
			.getString("utsDot3Onu2UniStatOutDiscards")
			+ " : ";
	private final String utsDot3Onu2UniStatOutErrors = fStringMap
			.getString("utsDot3Onu2UniStatOutErrors")
			+ " : ";

	public Dot3Onu2UniStatTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(14, 3, NTLayout.FILL, NTLayout.CENTER,
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatInOctets));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatInOctets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatInUcastPkts));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatInUcastPkts);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatInNucastPkts));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatInNucastPkts);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatInDiscards));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatInDiscards);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatInErrors));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatInErrors);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatOutOctets));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatOutOctets);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatOutUcastPkts));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatOutUcastPkts);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatOutNucastPkts));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatOutNucastPkts);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatOutDiscards));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatOutDiscards);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniStatOutErrors));
		baseInfoPanel.add(tfUtsDot3Onu2UniStatOutErrors);
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

		Dot3Onu2UniStatTable mbean = (Dot3Onu2UniStatTable) getModel();

		tfUtsDot3Onu2Ctc3UniModuleId.setText(mbean
				.getUtsDot3Onu2Ctc3UniModuleId().toString());
		tfUtsDot3Onu2Ctc3UniDeviceId.setText(mbean
				.getUtsDot3Onu2Ctc3UniDeviceId().toString());
		tfUtsDot3Onu2Ctc3UniPortId.setText(mbean.getUtsDot3Onu2Ctc3UniPortId()
				.toString());
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniLogicalPortId().toString());
		tfUtsDot3Onu2UniStatInOctets.setText(mbean
				.getUtsDot3Onu2UniStatInOctets().toString());
		tfUtsDot3Onu2UniStatInUcastPkts.setText(mbean
				.getUtsDot3Onu2UniStatInUcastPkts().toString());
		tfUtsDot3Onu2UniStatInNucastPkts.setText(mbean
				.getUtsDot3Onu2UniStatInNucastPkts().toString());
		tfUtsDot3Onu2UniStatInDiscards.setText(mbean
				.getUtsDot3Onu2UniStatInDiscards().toString());
		tfUtsDot3Onu2UniStatInErrors.setText(mbean
				.getUtsDot3Onu2UniStatInErrors().toString());
		tfUtsDot3Onu2UniStatOutOctets.setText(mbean
				.getUtsDot3Onu2UniStatOutOctets().toString());
		tfUtsDot3Onu2UniStatOutUcastPkts.setText(mbean
				.getUtsDot3Onu2UniStatOutUcastPkts().toString());
		tfUtsDot3Onu2UniStatOutNucastPkts.setText(mbean
				.getUtsDot3Onu2UniStatOutNucastPkts().toString());
		tfUtsDot3Onu2UniStatOutDiscards.setText(mbean
				.getUtsDot3Onu2UniStatOutDiscards().toString());
		tfUtsDot3Onu2UniStatOutErrors.setText(mbean
				.getUtsDot3Onu2UniStatOutErrors().toString());

	}

	public void updateModel() {

		Dot3Onu2UniStatTable mbean = (Dot3Onu2UniStatTable) getModel();

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2Ctc3UniTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2Ctc3UniTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2Ctc3UniTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2Ctc3UniModuleId = new JLabel();

//	private JLabel tfUtsDot3Onu2Ctc3UniDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPhyPortId = new JLabel();

	private IntegerTextField tfUtsDot3Onu2Ctc3MacLimit = new IntegerTextField();

	private final String utsDot3Onu2Ctc3UniModuleId = fStringMap
			.getString("utsDot3Onu2Ctc3UniModuleId")
			+ " : ";
//	private final String utsDot3Onu2Ctc3UniDeviceId = fStringMap
//			.getString("utsDot3Onu2Ctc3UniDeviceId")
//			+ " : ";
	private final String utsDot3Onu2Ctc3UniPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniLogicalPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniPhyPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPhyPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3MacLimit = fStringMap
			.getString("utsDot3Onu2Ctc3MacLimit")
			+ " : ";

	public Dot3Onu2Ctc3UniTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPhyPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPhyPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3MacLimit));
		tfUtsDot3Onu2Ctc3MacLimit.setName(fStringMap
				.getString("utsDot3Onu2Ctc3MacLimit"));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3MacLimit);
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

		tfUtsDot3Onu2Ctc3MacLimit.setValueScope(0, 65535);

	}

	public void refresh() {

		Dot3Onu2Ctc3UniTable mbean = (Dot3Onu2Ctc3UniTable) getModel();

		tfUtsDot3Onu2Ctc3UniModuleId.setText(mbean
				.getUtsDot3Onu2Ctc3UniModuleId().toString());
//		tfUtsDot3Onu2Ctc3UniDeviceId.setText(mbean
//				.getUtsDot3Onu2Ctc3UniDeviceId().toString());
		tfUtsDot3Onu2Ctc3UniPortId.setText(mbean.getUtsDot3Onu2Ctc3UniPortId()
				.toString());
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniLogicalPortId().toString());
		tfUtsDot3Onu2Ctc3UniPhyPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniPhyPortId().toString());
		tfUtsDot3Onu2Ctc3MacLimit.setValue(mbean.getUtsDot3Onu2Ctc3MacLimit()
				.intValue());

	}

	public void updateModel() {

		Dot3Onu2Ctc3UniTable mbean = (Dot3Onu2Ctc3UniTable) getModel();

		mbean.setUtsDot3Onu2Ctc3MacLimit(new Long(tfUtsDot3Onu2Ctc3MacLimit
				.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

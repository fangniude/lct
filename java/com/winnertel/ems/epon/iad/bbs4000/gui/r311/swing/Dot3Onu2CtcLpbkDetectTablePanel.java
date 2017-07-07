package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2CtcLpbkDetectTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2CtcLpbkDetectTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2CtcLpbkDetectTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2CtcLpbkDetectModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcLpbkDetectDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcLpbkDetectPortId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcLpbkDetectLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2CtcLpbkDetectUniPort = new JLabel();

	private int[] utsDot3Onu2CtcLpbkDetectActionVList = new int[] { 2, 1, };
	private String[] utsDot3Onu2CtcLpbkDetectActionTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };
	private JComboBox tfUtsDot3Onu2CtcLpbkDetectAction = new JComboBox(
			utsDot3Onu2CtcLpbkDetectActionTList);

	private final String utsDot3Onu2CtcLpbkDetectModuleId = fStringMap
			.getString("utsDot3Onu2CtcLpbkDetectModuleId")
			+ " : ";
	private final String utsDot3Onu2CtcLpbkDetectDeviceId = fStringMap
			.getString("utsDot3Onu2CtcLpbkDetectDeviceId")
			+ " : ";
	private final String utsDot3Onu2CtcLpbkDetectPortId = fStringMap
			.getString("utsDot3Onu2CtcLpbkDetectPortId")
			+ " : ";
	private final String utsDot3Onu2CtcLpbkDetectLogicalPortId = fStringMap
			.getString("utsDot3Onu2CtcLpbkDetectLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2CtcLpbkDetectUniPort = fStringMap
			.getString("utsDot3Onu2CtcLpbkDetectUniPort")
			+ " : ";
	private final String utsDot3Onu2CtcLpbkDetectAction = fStringMap
			.getString("utsDot3Onu2CtcLpbkDetectAction")
			+ " : ";

	public Dot3Onu2CtcLpbkDetectTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLpbkDetectModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcLpbkDetectModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLpbkDetectDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2CtcLpbkDetectDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLpbkDetectPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcLpbkDetectPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLpbkDetectLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2CtcLpbkDetectLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLpbkDetectUniPort));
		baseInfoPanel.add(tfUtsDot3Onu2CtcLpbkDetectUniPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLpbkDetectAction));
		tfUtsDot3Onu2CtcLpbkDetectAction.setName(fStringMap
				.getString("utsDot3Onu2CtcLpbkDetectAction"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcLpbkDetectAction);
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

		Dot3Onu2CtcLpbkDetectTable mbean = (Dot3Onu2CtcLpbkDetectTable) getModel();

		tfUtsDot3Onu2CtcLpbkDetectModuleId.setText(mbean
				.getUtsDot3Onu2CtcLpbkDetectModuleId().toString());
		tfUtsDot3Onu2CtcLpbkDetectDeviceId.setText(mbean
				.getUtsDot3Onu2CtcLpbkDetectDeviceId().toString());
		tfUtsDot3Onu2CtcLpbkDetectPortId.setText(mbean
				.getUtsDot3Onu2CtcLpbkDetectPortId().toString());
		tfUtsDot3Onu2CtcLpbkDetectLogicalPortId.setText(mbean
				.getUtsDot3Onu2CtcLpbkDetectLogicalPortId().toString());
		tfUtsDot3Onu2CtcLpbkDetectUniPort.setText(mbean
				.getUtsDot3Onu2CtcLpbkDetectUniPort().toString());
		tfUtsDot3Onu2CtcLpbkDetectAction.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2CtcLpbkDetectActionVList, mbean
						.getUtsDot3Onu2CtcLpbkDetectAction().intValue()));

	}

	public void updateModel() {

		Dot3Onu2CtcLpbkDetectTable mbean = (Dot3Onu2CtcLpbkDetectTable) getModel();

		mbean
				.setUtsDot3Onu2CtcLpbkDetectAction(new Integer(
						utsDot3Onu2CtcLpbkDetectActionVList[tfUtsDot3Onu2CtcLpbkDetectAction
								.getSelectedIndex()]));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}

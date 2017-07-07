package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipFaxSettingTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2VoipFaxSettingTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2VoipFaxSettingTablePanel extends UPanel {
	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private int[] utsDot3Onu2VoipFaxModeVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2VoipFaxModeTList = new String[] {
			fStringMap.getString("t30"), fStringMap.getString("t38"), };
	private JComboBox tfUtsDot3Onu2VoipFaxMode = new JComboBox(
			utsDot3Onu2VoipFaxModeTList);
	private int[] utsDot3Onu2VoipFaxControlModeVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2VoipFaxControlModeTList = new String[] {
			fStringMap.getString("negotiation"),
			fStringMap.getString("autoVbd"), };
	private JComboBox tfUtsDot3Onu2VoipFaxControlMode = new JComboBox(
			utsDot3Onu2VoipFaxControlModeTList);

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

	private final String utsDot3Onu2VoipFaxMode = fStringMap
			.getString("utsDot3Onu2VoipFaxMode")
			+ " : ";
	private final String utsDot3Onu2VoipFaxControlMode = fStringMap
			.getString("utsDot3Onu2VoipFaxControlMode")
			+ " : ";

	public Dot3Onu2VoipFaxSettingTablePanel(IApplication app) {
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2VoipDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipLogicalPortId);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipFaxMode));
		tfUtsDot3Onu2VoipFaxMode.setName(fStringMap
				.getString("utsDot3Onu2VoipFaxMode"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipFaxMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipFaxControlMode));
		tfUtsDot3Onu2VoipFaxControlMode.setName(fStringMap
				.getString("utsDot3Onu2VoipFaxControlMode"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipFaxControlMode);
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

		Dot3Onu2VoipFaxSettingTable mbean = (Dot3Onu2VoipFaxSettingTable) getModel();
		
		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId()
				.toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId()
				.toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId()
				.toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean
				.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());

		tfUtsDot3Onu2VoipFaxMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipFaxModeVList, mbean.getUtsDot3Onu2CtcFaxmodemCfgT38Mode()
						.intValue()));
		tfUtsDot3Onu2VoipFaxControlMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipFaxControlModeVList, mbean
						.getUtsDot3Onu2CtcFaxmodemCfgCtrl().intValue()));

	}

	public void updateModel() {

		Dot3Onu2VoipFaxSettingTable mbean = (Dot3Onu2VoipFaxSettingTable) getModel();

		mbean.setUtsDot3Onu2CtcFaxmodemCfgT38Mode(new Integer(
				utsDot3Onu2VoipFaxModeVList[tfUtsDot3Onu2VoipFaxMode
						.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2CtcFaxmodemCfgCtrl(new Integer(
						utsDot3Onu2VoipFaxControlModeVList[tfUtsDot3Onu2VoipFaxControlMode
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
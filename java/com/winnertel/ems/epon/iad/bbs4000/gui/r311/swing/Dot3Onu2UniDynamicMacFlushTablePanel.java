package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2MacAgingTimeTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2UniDynamicMacFlushTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.IMibBean;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2UniDynamicMacFlushTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2UniDynamicMacFlushTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2MacAgingTimeModuleId = new JLabel();

//	private JLabel tfUtsDot3Onu2MacAgingTimeDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimePortId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimeLogicalPortId = new JLabel();

//	private JLabel tfUtsDot3Onu2UniDynamicMacFlushPort = new JLabel();
	
	private int[] Dot3Onu2UniDynamicMacFlushPortVList = new int[] {
			0, 1, 2, 3, 4, };
	private String[] Dot3Onu2UniDynamicMacFlushPortTList = new String[] {
			fStringMap.getString("flush_all_dynamic_MAC_address"), "1", "2", "3", "4", };
	private JComboBox tfUtsDot3Onu2UniDynamicMacFlushPort = new JComboBox(
			Dot3Onu2UniDynamicMacFlushPortTList);

	private final String utsDot3Onu2MacAgingTimeModuleId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeModuleId")
			+ " : ";
	private final String utsDot3Onu2MacAgingTimeDeviceId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeDeviceId")
			+ " : ";
	private final String utsDot3Onu2MacAgingTimePortId = fStringMap
			.getString("utsDot3Onu2MacAgingTimePortId")
			+ " : ";
	private final String utsDot3Onu2MacAgingTimeLogicalPortId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2UniDynamicMacFlushPort = fStringMap
			.getString("utsDot3Onu2UniDynamicMacFlushPort")
			+ " : ";

	public Dot3Onu2UniDynamicMacFlushTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimePortId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimePortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2UniDynamicMacFlushPort));
		baseInfoPanel.add(tfUtsDot3Onu2UniDynamicMacFlushPort);
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

//		Dot3Onu2UniDynamicMacFlushTable mbean = (Dot3Onu2UniDynamicMacFlushTable) getModel();

//		tfUtsDot3Onu2MacAgingTimeModuleId.setText(mbean
//				.getUtsDot3Onu2MacAgingTimeModuleId().toString());
//		tfUtsDot3Onu2MacAgingTimeDeviceId.setText(mbean
//				.getUtsDot3Onu2MacAgingTimeDeviceId().toString());
//		tfUtsDot3Onu2MacAgingTimePortId.setText(mbean
//				.getUtsDot3Onu2MacAgingTimePortId().toString());
//		tfUtsDot3Onu2MacAgingTimeLogicalPortId.setText(mbean
//				.getUtsDot3Onu2MacAgingTimeLogicalPortId().toString());
//		tfUtsDot3Onu2UniDynamicMacFlushPort.setText(mbean
//				.getUtsDot3Onu2UniDynamicMacFlushPort().toString());
		
		Dot3Onu2MacAgingTimeTable mbean = (Dot3Onu2MacAgingTimeTable) getModel();
		tfUtsDot3Onu2MacAgingTimeModuleId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeModuleId().toString());
//		tfUtsDot3Onu2MacAgingTimeDeviceId.setText(mbean.getUtsDot3Onu2Ctc3UniDeviceId());
		tfUtsDot3Onu2MacAgingTimePortId.setText(mbean
				.getUtsDot3Onu2MacAgingTimePortId().toString());
		tfUtsDot3Onu2MacAgingTimeLogicalPortId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeLogicalPortId().toString());
		
	}

	public void updateModel() {

		IMibBean tbean = getModel();
		if(tbean instanceof Dot3Onu2MacAgingTimeTable) {
			Dot3Onu2MacAgingTimeTable bean = (Dot3Onu2MacAgingTimeTable) getModel();

			Dot3Onu2UniDynamicMacFlushTable mBean = new Dot3Onu2UniDynamicMacFlushTable(
					fApplication.getSnmpProxy());
			mBean.setUtsDot3Onu2MacAgingTimeModuleId(bean
					.getUtsDot3Onu2MacAgingTimeModuleId());
			mBean.setUtsDot3Onu2MacAgingTimeDeviceId(bean
					.getUtsDot3Onu2MacAgingTimeDeviceId());
			mBean.setUtsDot3Onu2MacAgingTimePortId(bean
					.getUtsDot3Onu2MacAgingTimePortId());
			mBean.setUtsDot3Onu2MacAgingTimeLogicalPortId(bean
					.getUtsDot3Onu2MacAgingTimeLogicalPortId());
			mBean
					.setUtsDot3Onu2UniDynamicMacFlushPort(new Integer(
							Dot3Onu2UniDynamicMacFlushPortVList[tfUtsDot3Onu2UniDynamicMacFlushPort
									.getSelectedIndex()]));
			setModel(mBean);
		}
		if(tbean instanceof Dot3Onu2UniDynamicMacFlushTable) {
			Dot3Onu2UniDynamicMacFlushTable mBean = (Dot3Onu2UniDynamicMacFlushTable) getModel();
			mBean
					.setUtsDot3Onu2UniDynamicMacFlushPort(new Integer(
							Dot3Onu2UniDynamicMacFlushPortVList[tfUtsDot3Onu2UniDynamicMacFlushPort
									.getSelectedIndex()]));
			setModel(mBean);
		}
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
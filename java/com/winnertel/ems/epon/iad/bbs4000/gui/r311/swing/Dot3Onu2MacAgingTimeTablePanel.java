package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2MacAgingTimeTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2MacAgingTimeTable Panel class. Created by DVM Creator
 */

public class Dot3Onu2MacAgingTimeTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2MacAgingTimeModuleId = new JLabel();

//	private JLabel tfUtsDot3Onu2MacAgingTimeDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimePortId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimeLogicalPortId = new JLabel();

	private IntegerTextField tfUtsDot3Onu2MacAgingTime = new IntegerTextField();

	private final String utsDot3Onu2MacAgingTimeModuleId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeModuleId")
			+ " : ";
//	private final String utsDot3Onu2MacAgingTimeDeviceId = fStringMap
//			.getString("utsDot3Onu2MacAgingTimeDeviceId")
//			+ " : ";
	private final String utsDot3Onu2MacAgingTimePortId = fStringMap
			.getString("utsDot3Onu2MacAgingTimePortId")
			+ " : ";
	private final String utsDot3Onu2MacAgingTimeLogicalPortId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2MacAgingTime = fStringMap
			.getString("utsDot3Onu2MacAgingTime")
			+ " : ";

	public Dot3Onu2MacAgingTimeTablePanel(IApplication app) {
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

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTime));
		tfUtsDot3Onu2MacAgingTime.setName(fStringMap
				.getString("utsDot3Onu2MacAgingTime"));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTime);
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

		 tfUtsDot3Onu2MacAgingTime.setValueScope( 0, Integer.MAX_VALUE );

	}
	
	public boolean validateFrom() {
		Integer theValue = Integer.valueOf(tfUtsDot3Onu2MacAgingTime.getText());
		if (theValue.intValue() < 0
				|| (theValue.intValue() > 0 && theValue.intValue() < 15)
				|| theValue.intValue() > 3825) {
			MessageDialog.showInfoMessageDialog(fApplication,
					utsDot3Onu2MacAgingTime
							+ fStringMap.getString("Err_Dot3Onu2MacAgingTime_Value"));
			return false;
		}
		
		return true;

	}

	public void refresh() {

		Dot3Onu2MacAgingTimeTable mbean = (Dot3Onu2MacAgingTimeTable) getModel();

		tfUtsDot3Onu2MacAgingTimeModuleId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeModuleId().toString());
//		tfUtsDot3Onu2MacAgingTimeDeviceId.setText(mbean
//				.getUtsDot3Onu2MacAgingTimeDeviceId().toString());
		tfUtsDot3Onu2MacAgingTimePortId.setText(mbean
				.getUtsDot3Onu2MacAgingTimePortId().toString());
		tfUtsDot3Onu2MacAgingTimeLogicalPortId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeLogicalPortId().toString());
		tfUtsDot3Onu2MacAgingTime.setValue(mbean.getUtsDot3Onu2MacAgingTime()
				.intValue());

	}

	public void updateModel() {

		Dot3Onu2MacAgingTimeTable mbean = (Dot3Onu2MacAgingTimeTable) getModel();

		mbean.setUtsDot3Onu2MacAgingTime(new Long(tfUtsDot3Onu2MacAgingTime
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
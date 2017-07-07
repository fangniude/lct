package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3OltOpmOnuRxPowerTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3OltOpmOnuRxPowerTablePanel extends UPanel {

	private JLabel tfUtsDot3OltOpmOnuRxPowerModuleID = new JLabel();
	private JLabel tfUtsDot3OltOpmOnuRxPowerPortId = new JLabel();
	private JLabel tfUtsDot3OltOpmOnuRxPowerLogicalPortId = new JLabel();
	private JLabel tfUtsDot3OltOpmOnuRxPower = new JLabel();

	private final String utsDot3OltOpmOnuRxPowerModuleID = fStringMap
			.getString("utsDot3OltOpmOnuRxPowerModuleID")
			+ " : ";
	private final String utsDot3OltOpmOnuRxPowerPortId = fStringMap
			.getString("utsDot3OltOpmOnuRxPowerPortId")
			+ " : ";
	private final String utsDot3OltOpmOnuRxPowerLogicalPortId = fStringMap
			.getString("utsDot3OltOpmOnuRxPowerLogicalPortId")
			+ " : ";
	private final String utsDot3OltOpmOnuRxPower = fStringMap
			.getString("utsDot3OltOpmOnuRxPower")
			+ " : ";

	public Dot3OltOpmOnuRxPowerTablePanel(IApplication app) {
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

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPowerModuleID));
		baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerModuleID);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPowerPortId));
		baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPowerLogicalPortId));
		baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPower));
		baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPower);
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
		Dot3OltOpmOnuRxPowerTable mbean = (Dot3OltOpmOnuRxPowerTable) getModel();
		if (mbean == null)
			return;

		tfUtsDot3OltOpmOnuRxPowerModuleID.setText(mbean
				.getUtsDot3OltOpmOnuRxPowerModuleID().toString());
		tfUtsDot3OltOpmOnuRxPowerPortId.setText(mbean
				.getUtsDot3OltOpmOnuRxPowerPortId().toString());
		tfUtsDot3OltOpmOnuRxPowerLogicalPortId.setText(mbean
				.getUtsDot3OltOpmOnuRxPowerLogicalPortId().toString());
		tfUtsDot3OltOpmOnuRxPower.setText(mbean.getUtsDot3OltOpmOnuRxPower()
				.toString());

	}

	public void updateModel() {
		Dot3OltOpmOnuRxPowerTable mbean = (Dot3OltOpmOnuRxPowerTable) getModel();
		if (mbean == null)
			return;
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}

		return 0;
	}

}

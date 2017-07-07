package com.winnertel.ems.epon.iad.bbs1000.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.bbs4000.gui.AlarmFilteringMBeanPanel;

public class AlarmConfigPanel extends UPanel {

	private AlarmFilteringMBeanPanel filterPanel;
	private SnmpTablePane redefinePanel;

	public AlarmConfigPanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel allPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		allPanel.setLayout(layout);
		filterPanel = new AlarmFilteringMBeanPanel(fApplication);
		filterPanel.setPreferredSize(new Dimension(100, 200));
		IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
		redefinePanel = (SnmpTablePane) composer.composeSnmpTablePane("Alarm_Redefinition");
		redefinePanel.setPreferredSize(new Dimension(100, 300));

		redefinePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Alarm_Redefinition")));
		allPanel.add(filterPanel);
		allPanel.add(redefinePanel);
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);
	}

	protected void initForm() {

	}

	public void refresh() {
		filterPanel.refresh();
		redefinePanel.refresh();
	}

	public void updateModel() {
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
}

package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class UtsOnuFwUpgradeAutoAllPanel extends UPanel {

    private UPanel upgradeConfigPanel;
    private SnmpTablePane upgradeResultPanel;

    public UtsOnuFwUpgradeAutoAllPanel(IApplication app) {
	super(app);
	init();
    }

    @Override
    protected void initGui() {
	JPanel allPanel = new JPanel();
	NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
	allPanel.setLayout(layout);

	upgradeConfigPanel = new UtsOnuFwUpgradeAutoPanel(fApplication);
	upgradeConfigPanel.setPreferredSize(new Dimension(100, 400));

	IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
	upgradeResultPanel = (SnmpTablePane) composer.composeSnmpTablePane("UtsOnuFWUpgradeAutoResultTable_Panel");
	upgradeResultPanel.setPreferredSize(new Dimension(100, 200));

	allPanel.add(upgradeConfigPanel);
	allPanel.add(upgradeResultPanel);

	setLayout(new BorderLayout());
	add(allPanel, BorderLayout.CENTER);

    }

    @Override
    public void refresh() {
	upgradeConfigPanel.refresh();
	upgradeResultPanel.refresh();
    }

}

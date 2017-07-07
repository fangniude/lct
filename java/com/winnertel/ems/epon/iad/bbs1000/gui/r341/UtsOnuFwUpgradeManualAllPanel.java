package com.winnertel.ems.epon.iad.bbs1000.gui.r341;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

public class UtsOnuFwUpgradeManualAllPanel extends UPanel {

    private UPanel upgradeConfigPanel;
    private SnmpTablePane upgradeResultPanel;

    public UtsOnuFwUpgradeManualAllPanel(IApplication app) {
	super(app);
	init();
    }

    @Override
    protected void initGui() {
	JPanel allPanel = new JPanel();
	NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
	allPanel.setLayout(layout);

	upgradeConfigPanel = new UtsOnuFwUpgradeManualPanel(fApplication);
	upgradeConfigPanel.setPreferredSize(new Dimension(100, 400));

	IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
	upgradeResultPanel = (SnmpTablePane) composer.composeSnmpTablePane("UtsOnuFWUpgradeManualResultTable_Panel");
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

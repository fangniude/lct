package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import javax.swing.event.TableModelEvent;

import java.awt.*;
import java.util.Vector;

public class UtsOnuFwUpgradeManualAllPanel extends UPanel {

	private UPanel upgradeConfigPanel;
	private SnmpTablePane upgradeResultPanel;
	private SnmpTable fTable;
	private SnmpTableModel fTableModel;
	private SnmpMibBean fBean;
//	private boolean fRunning = false;

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

		IGuiComposer composer = fApplication.getActiveDeviceManager()
				.getGuiComposer();
		upgradeResultPanel = (SnmpTablePane) composer
				.composeSnmpTablePane("UtsOnuFWUpgradeManualResultTable_Panel");
		upgradeResultPanel.setPreferredSize(new Dimension(100, 200));

		allPanel.add(upgradeConfigPanel);
		allPanel.add(upgradeResultPanel);

		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

	}

	@Override
	public void refresh() {
		upgradeConfigPanel.refresh();
		// upgradeResultPanel.refresh();
		refreshTable();
	}

	private void refreshTable() {
		this.fTable = upgradeResultPanel.getTable();
		this.fTableModel = (SnmpTableModel) fTable.getModel();
		this.fBean = fTableModel.getMibBean();

		synchronized (fTableModel) {
			fTable.clearSelection();
			fTableModel.getDataVector().clear();
			fTableModel
					.fireTableChanged(new TableModelEvent(fTableModel, 0, 0));
			fTable.updateUI();
//			this.fRunning = true;

			// while (fRunning && fTable.isShowing()) {
			Vector<SnmpMibBean> vector = null;
			try {
				vector = fBean.retrieveAll();
			} catch (MibBeanException e) {
				e.printStackTrace();
			}

			fTableModel.addRows(vector);
			// if (isEnd(vector)) {
			// break;
			// }

//			SnmpMibBean lastBean = vector.get(vector.size() - 1);
//			for (int i = 0; i < lastBean.getIndexCount(); i++) {
//				fBean.setIndex(i, lastBean.getIndex(i));
//			}
			// }

//			this.fRunning = false;

			int count = fBean.getIndexCount();
			for (int i = 0; i < count; i++) {
				fBean.setIndex(i, null);
			}
		}

	}

//	private boolean isEnd(Vector<SnmpMibBean> vector) {
//		if (vector.size() < fBean.getRowsToFetch()) {
//			return true;
//		}
//
//		String indexPrefix = fBean.getIndexPrefix();
//		if (indexPrefix != null
//				&& vector.get(0).getIndexCount() == fBean.getIndexPrefix()
//						.split("\\.").length) {
//			return true;
//		}
//
//		return false;
//	}

}

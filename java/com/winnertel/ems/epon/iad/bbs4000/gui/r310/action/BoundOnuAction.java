package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing.Dot3UnboundOnuTablePanel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.event.ActionEvent;

public class BoundOnuAction extends SnmpAction {

	public BoundOnuAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent e) throws OperationFailedException,
			OperationCanceledException, OperationFinishedWithoutLogException {
		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

		if (fPanel == null || fPanel instanceof SnmpTablePane) {
			fPanel = new Dot3UnboundOnuTablePanel(fApplication);
			((Dot3UnboundOnuTablePanel) fPanel).setTable(fTable);
		}

		if (fDialog == null) {
			String title = fApplication.getActiveDeviceManager()
					.getGuiComposer().getString("Bound");
			fDialog = new SnmpDialog(fApplication, title, "Modify", "A|Q");
			((SnmpDialog) fDialog).setTable(fTable);
			((SnmpDialog) fDialog).setPanel(fPanel);
			((SnmpDialog) fDialog)
					.setApplyId("Modify_Dot3Onu2CtcValidOnuMacTable_Log");
		}

		fPanel.setModel(bean);
		fPanel.refresh();
		fDialog.pack();
		fDialog.show();

	}
}
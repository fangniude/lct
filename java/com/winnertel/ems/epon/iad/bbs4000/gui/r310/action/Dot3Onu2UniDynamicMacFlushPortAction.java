package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing.Dot3Onu2UniDynamicMacFlushTablePanel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.event.ActionEvent;

public class Dot3Onu2UniDynamicMacFlushPortAction extends SnmpAction {

	public Dot3Onu2UniDynamicMacFlushPortAction(IApplication anApplication) {
		super(anApplication);
	}
	
	
	public void executeAction(ActionEvent e) throws OperationFailedException,
			OperationCanceledException, OperationFinishedWithoutLogException {
		if(fTable.getSelectedRowCount() < 1) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}
		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

		if (fPanel == null || fPanel instanceof SnmpTablePane) {
			fPanel = new Dot3Onu2UniDynamicMacFlushTablePanel(fApplication);
			((Dot3Onu2UniDynamicMacFlushTablePanel) fPanel).setTable(fTable);
		}

		if (fDialog == null) {
			String title = fApplication.getActiveDeviceManager()
					.getGuiComposer().getString("Flush");
			fDialog = new SnmpDialog(fApplication, title, "Modify", "A|Q");
			((SnmpDialog) fDialog).setTable(fTable);
			((SnmpDialog) fDialog).setPanel(fPanel);
			((SnmpDialog) fDialog)
					.setApplyId("Modify_Dot3Onu2UniDynamicMacFlushTable_Log");
		}

		fPanel.setModel(bean);
		fPanel.refresh();
		fDialog.pack();
		fDialog.show();

	}

//	public void executeAction(ActionEvent e) throws OperationFailedException,
//			OperationCanceledException, OperationFinishedWithoutLogException {
//		int selectedRowCount = fTable.getSelectedRowCount();
//		if (selectedRowCount == 0) {
//			MessageDialog.showSelectRowDialog(fApplication);
//			return;
//		}
//
//		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
//		SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());
//
//		// if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
//		// throw new OperationCanceledException("Voice module reset");
//		// }
//
//		// Reset the ONU, set utsDot3Onu2CtcReset 1: reset(1)
//		Task t = new CommitTask(fTable);
//		t.setWaitPrompt(fApplication.getGlobalStringMap().getString(
//				"Please wait while configuring NE"));
//		try {
//			Boolean result = (Boolean) fApplication.getTaskManager()
//					.executeTask(t);
//			if (!result.booleanValue()) {
//				throw new OperationFailedException("Voice module reset failed");
//			}
//		} catch (Exception ex) {
//			MessageDialog.showOperationFailedDialog(fApplication);
//			throw new OperationFailedException("Voice module reset failed");
//		} finally {
//			MibBeanIdFormatter idFormatter = fTable.getRowIdFormatter();
//			if (idFormatter != null) {
//				OperationObject oo = idFormatter.format(bean, tableModel
//						.getRowText(fTable.getSelectedRow()));
//				// set operation object to device manager
//				OperationObject currentOo = fApplication
//						.getActiveDeviceManager().getOperationObject();
//				currentOo.setChassis(oo.getChassis());
//				currentOo.setBoard(oo.getBoard());
//				currentOo.setPort(oo.getPort());
//			}
//		}
//	}
//
//	class CommitTask extends Task {
//
//		SnmpTable fTable = null;
//
//		public CommitTask(SnmpTable table) {
//			fTable = table;
//		}
//
//		public Object execute() throws Exception {
//			SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
//			Dot3Onu2UniStaticMacTable bean = (Dot3Onu2UniStaticMacTable) tableModel
//					.getRow(fTable.getSelectedRow());
//			Dot3Onu2UniDynamicMacFlushTable mBean = new Dot3Onu2UniDynamicMacFlushTable(
//					fApplication.getSnmpProxy());
//			mBean.setUtsDot3Onu2MacAgingTimeModuleId(bean
//					.getUtsDot3Onu2Ctc3UniModuleId());
//			mBean.setUtsDot3Onu2MacAgingTimeDeviceId(bean
//					.getUtsDot3Onu2Ctc3UniDeviceId());
//			mBean.setUtsDot3Onu2MacAgingTimePortId(bean
//					.getUtsDot3Onu2Ctc3UniPortId());
//			mBean.setUtsDot3Onu2MacAgingTimeLogicalPortId(bean
//					.getUtsDot3Onu2Ctc3UniLogicalPortId());
//			mBean.setUtsDot3Onu2UniDynamicMacFlushPort(2);
//
//			return mBean.modify();
//		}
//
//	}

}
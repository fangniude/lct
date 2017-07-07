package com.winnertel.ems.epon.iad.bbs4000.gui.r221.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesIadCfg;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesIadOperation;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;

import java.awt.event.ActionEvent;

public class Onu2CtcCombinedFeaturesIadRegisterAction extends SnmpAction {

	public Onu2CtcCombinedFeaturesIadRegisterAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent e) throws OperationFailedException,
			OperationCanceledException, OperationFinishedWithoutLogException {
		int selectedRowCount = fTable.getSelectedRowCount();
		if (selectedRowCount == 0) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}

		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

//		if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
//			throw new OperationCanceledException("Register to softswitch");
//		}

		// Reset the ONU, set utsDot3Onu2CtcReset 1: reset(1)
		Task t = new CommitTask(fTable);
		t.setWaitPrompt(fApplication.getGlobalStringMap().getString(
				"Please wait while configuring NE"));
		try {
			Boolean result = (Boolean) fApplication.getTaskManager()
					.executeTask(t);
			if (!result.booleanValue()) {
				throw new OperationFailedException(
						"Register to softswitch failed");
			}
		} catch (Exception ex) {
			MessageDialog.showOperationFailedDialog(fApplication);
			throw new OperationFailedException(
					"Register to softswitch failed");
		} finally {
			MibBeanIdFormatter idFormatter = fTable.getRowIdFormatter();
			if (idFormatter != null) {
				OperationObject oo = idFormatter.format(bean, tableModel
						.getRowText(fTable.getSelectedRow()));
				// set operation object to device manager
				OperationObject currentOo = fApplication
						.getActiveDeviceManager().getOperationObject();
				currentOo.setChassis(oo.getChassis());
				currentOo.setBoard(oo.getBoard());
				currentOo.setPort(oo.getPort());
			}
		}
	}

	class CommitTask extends Task {

		SnmpTable fTable = null;

		public CommitTask(SnmpTable table) {
			fTable = table;
		}

		public Object execute() throws Exception {
			SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
			Onu2CtcCombinedFeaturesIadCfg bean = (Onu2CtcCombinedFeaturesIadCfg) tableModel
					.getRow(fTable.getSelectedRow());
			Onu2CtcCombinedFeaturesIadOperation mBean = new Onu2CtcCombinedFeaturesIadOperation(
					fApplication.getSnmpProxy());
			mBean.setUtsDot3Onu2CtcCombinedFeaturesModuleId(bean
					.getUtsDot3Onu2CtcCombinedFeaturesModuleId());
			mBean.setUtsDot3Onu2CtcCombinedFeaturesDeviceId(bean
					.getUtsDot3Onu2CtcCombinedFeaturesDeviceId());
			mBean.setUtsDot3Onu2CtcCombinedFeaturesPortId(bean
					.getUtsDot3Onu2CtcCombinedFeaturesPortId());
			mBean.setUtsDot3Onu2CtcCombinedFeaturesLogicalPortId(bean
					.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId());
			mBean.setUtsDot3Onu2CtcIadOperation(0);

			return mBean.modify();
		}

	}

}
package com.winnertel.ems.epon.iad.bbs4000.gui.r200.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.PerfStaOperGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import java.awt.event.ActionEvent;

public class OnuIf2ExtStatResetAction extends SnmpAction {

	public OnuIf2ExtStatResetAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent arg0) throws Exception {
		if(!MessageDialog.showConfirmOperationDialog(fApplication))
			return;

		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		
		PerfStaOperGroup mbean = new PerfStaOperGroup(this.fApplication.getSnmpProxy());
	    mbean.setUtsPerfStaClearAll(new Integer(5));

		ResetTask task = new ResetTask(mbean);

		task.setWaitPrompt(fApplication.getGlobalStringMap().getString(
				"Please wait while configuring NE"));
		try {
			Boolean result = (Boolean) fApplication.getTaskManager()
					.executeTask(task);

			if (!result.booleanValue()) {
				throw new OperationFailedException("Diagnosis operation failed");
			}

			new RefreshAllCommand(fApplication, fTable).execute();
		} catch (Exception ex) {
			MessageDialog.showOperationFailedDialog(fApplication);
			throw new OperationFailedException("Diagnosis operation failed");
		} finally {
		}
	}

	class ResetTask extends Task {

		PerfStaOperGroup fBean = null;

		public ResetTask(PerfStaOperGroup bean) {
			fBean = bean;
		}

		public Object execute() throws Exception {
			return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
		}

	}

}

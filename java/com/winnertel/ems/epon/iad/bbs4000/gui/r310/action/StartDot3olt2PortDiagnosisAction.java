package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Olt2PortDiagnosisTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartDot3olt2PortDiagnosisAction extends SnmpAction {

	public StartDot3olt2PortDiagnosisAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent arg0) throws Exception {
		int selectedRowCount = fTable.getSelectedRowCount();
		if (selectedRowCount == 0) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}

		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

		Dot3Olt2PortDiagnosisTable diagBean = (Dot3Olt2PortDiagnosisTable) bean;
		if (!diagBean.retrieve())
			return;

		String status = diagBean.getUtsDot3OltPortLaserAlwaysOnDetectResult();
		if (status != null && status.trim().length()!= 0 && status.indexOf("No laser-always-on ONU") == -1) {
			MessageDialog.showErrorMessageDialog(fApplication, fApplication
					.getActiveDeviceManager().getGuiComposer().getString(
							"error_already_starting"));
			return;
		}

		if (MessageDialog.showConfirmDialog(fApplication, fApplication
				.getActiveDeviceManager().getGuiComposer().getString(
						"sure_to_locate_on_onu")) == JOptionPane.YES_OPTION) {
			diagBean.setUtsDot3OltPortLaserAlwaysOnOnuLocating(Dot3Olt2PortDiagnosisTable.START);
		}
		else {
			diagBean.setUtsDot3OltPortLaserAlwaysOnOnuLocating(Dot3Olt2PortDiagnosisTable.STOP);
		}
		
		if (MessageDialog.showConfirmDialog(fApplication, fApplication
				.getActiveDeviceManager().getGuiComposer().getString(
						"sure_to_continue_start_diagnosis")) == JOptionPane.NO_OPTION) {
			return;
		}

		diagBean
				.setUtsDot3OltPortLaserAlwaysOnDetect(Dot3Olt2PortDiagnosisTable.START);
		DiagnosisTask task = new DiagnosisTask(diagBean);

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

	class DiagnosisTask extends Task {

		Dot3Olt2PortDiagnosisTable fBean = null;

		public DiagnosisTask(Dot3Olt2PortDiagnosisTable bean) {
			fBean = bean;
		}

		public Object execute() throws Exception {
			return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
		}

	}

}

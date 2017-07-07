package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.EponSysCliMgmtTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import java.awt.event.ActionEvent;

public class CliUserLogoutForcelyAction extends SnmpAction {

	public CliUserLogoutForcelyAction(IApplication anApplication) {
		super(anApplication);
	}
	
	
	public void executeAction(ActionEvent e) throws OperationFailedException,
			OperationCanceledException, OperationFinishedWithoutLogException {
		if(fTable.getSelectedRowCount() < 1) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}
		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		EponSysCliMgmtTable bean = (EponSysCliMgmtTable)tableModel.getRow(fTable.getSelectedRow());

		if ( !MessageDialog.showConfirmOperationDialog( fApplication) ){
			return;
		}
		
		bean.setUtsEponSysCliUserLogoutForcely( 1 );
		OperationActionTask task = new OperationActionTask( bean );
			
		task.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
		try {
			Boolean result = (Boolean) fApplication.getTaskManager().executeTask( task );

			if (!result.booleanValue()) {
				throw new OperationFailedException(" operation failed");
			}

			new RefreshAllCommand(fApplication, fTable).execute();
		} catch (Exception ex) {
			MessageDialog.showOperationFailedDialog(fApplication);
			throw new OperationFailedException(  "operation failed" );
		} finally {			
		}

	}
	
	class OperationActionTask extends Task {

		EponSysCliMgmtTable fBean = null;

		public OperationActionTask( EponSysCliMgmtTable bean) {
			fBean = bean;
		}

		public Object execute() throws Exception {
			return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
		}

	}

}
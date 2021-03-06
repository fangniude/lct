package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2OperationTable;
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

public class Dot3Onu2RestoreFactoryConfigAction extends SnmpAction {

	public Dot3Onu2RestoreFactoryConfigAction(IApplication anApplication) {
		super(anApplication);
	}
	
	
	public void executeAction(ActionEvent e) throws OperationFailedException,
			OperationCanceledException, OperationFinishedWithoutLogException {
		if(fTable.getSelectedRowCount() < 1) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}
		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		Dot3Onu2CtcTable bean = (Dot3Onu2CtcTable)tableModel.getRow(fTable.getSelectedRow());

		if(bean.getUtsDot3Onu2CtcRegisterStatus() != 1) {
			MessageDialog.showErrorMessageDialog(fApplication, 
					fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Only_Register_ONU_Can_Oam_Config"));
			return;
		}
		
		if ( !MessageDialog.showConfirmOperationDialog( fApplication) ){
			return;
		}
		
		Dot3Onu2OperationTable fBean = new Dot3Onu2OperationTable(fApplication.getSnmpProxy());
		
		fBean.setUtsDot3Onu2MacAgingTimeModuleId(bean.getUtsDot3Onu2CtcModuleId());
		fBean.setUtsDot3Onu2MacAgingTimeDeviceId(bean.getUtsDot3Onu2CtcDeviceId());
		fBean.setUtsDot3Onu2MacAgingTimePortId(bean.getUtsDot3Onu2CtcPortId());
		fBean.setUtsDot3Onu2MacAgingTimeLogicalPortId(bean.getUtsDot3Onu2CtcLogicalPortId());
		fBean.setUtsDot3Onu2ConfigActions(3);
		
		OperationActionTask task = new OperationActionTask( fBean );
			
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

		Dot3Onu2OperationTable fBean = null;

		public OperationActionTask( Dot3Onu2OperationTable bean) {
			fBean = bean;
		}

		public Object execute() throws Exception {
			return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
		}

	}

}
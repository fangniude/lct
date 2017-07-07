package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Onu2OPTDTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import java.awt.event.ActionEvent;

public class DisableDot3OnuPmSwitchAction extends SnmpAction{
	
	public DisableDot3OnuPmSwitchAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent arg0) throws Exception {
		int selectedRowCount = fTable.getSelectedRowCount();
		if (selectedRowCount == 0) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}
		
		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		Dot3Onu2OPTDTable bean = (Dot3Onu2OPTDTable)tableModel.getRow(fTable.getSelectedRow());
		
		if ( !MessageDialog.showConfirmOperationDialog( fApplication) ){
			return;
		}
		
		bean.setUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch( 2 );
		DiagnosisPmSwitchTask task = new DiagnosisPmSwitchTask( bean );
			
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

}
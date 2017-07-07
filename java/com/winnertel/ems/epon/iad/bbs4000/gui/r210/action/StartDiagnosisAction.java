package com.winnertel.ems.epon.iad.bbs4000.gui.r210.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PortDiagnosisMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartDiagnosisAction extends SnmpAction{
	
	public StartDiagnosisAction(IApplication anApplication) {
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
		
		PortDiagnosisMBean diagBean = (PortDiagnosisMBean)bean;
		if ( !diagBean.retrieve() )
			return;
		
		int status = diagBean.getUtsDot3OltPortDiagnosisStatus( );
		if ( status > 0 && status < 100 ) {
			MessageDialog.showErrorMessageDialog( fApplication, 
					fApplication.getActiveDeviceManager().getGuiComposer().getString("error_already_starting"));
			return;
		}
		
		if ( MessageDialog.showConfirmDialog( fApplication, 
				fApplication.getActiveDeviceManager().getGuiComposer().getString( "sure_to_continue_start_diagnosis" )) 
				==	JOptionPane.NO_OPTION ){
			return;
		}
		
		diagBean.setUtsDot3OltPortDiagnosisAction( PortDiagnosisMBean.START );
		DiagnosisTask task = new DiagnosisTask( diagBean );
			
		task.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
		try {
			Boolean result = (Boolean) fApplication.getTaskManager().executeTask( task );

			if (!result.booleanValue()) {
				throw new OperationFailedException("Diagnosis operation failed");
			}

			new RefreshAllCommand(fApplication, fTable).execute();
		} catch (Exception ex) {
			MessageDialog.showOperationFailedDialog(fApplication);
			throw new OperationFailedException(  "Diagnosis operation failed" );
		} finally {			
		}
	}

}

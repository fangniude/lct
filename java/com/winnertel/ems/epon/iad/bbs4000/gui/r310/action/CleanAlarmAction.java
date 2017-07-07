//package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;
//
//import com.winnertel.ems.epon.iad.bbs4000.mib.r311.ActiveAlarmTable;
//import com.winnertel.em.framework.IApplication;
//import com.winnertel.em.framework.gui.util.MessageDialog;
//import com.winnertel.em.framework.task.Task;
//import com.winnertel.em.framework.util.OperationCanceledException;
//import com.winnertel.em.framework.util.OperationFailedException;
//import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
//import com.winnertel.em.standard.snmp.action.SnmpAction;
//import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
//import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
//
//import java.awt.event.ActionEvent;
//
//public class CleanAlarmAction extends SnmpAction {
//
//	public CleanAlarmAction(IApplication anApplication) {
//		super(anApplication);
//	}
//	
//	
//	public void executeAction(ActionEvent e) throws OperationFailedException,
//			OperationCanceledException, OperationFinishedWithoutLogException {
//		if(fTable.getSelectedRowCount() < 1) {
//			MessageDialog.showSelectRowDialog(fApplication);
//			return;
//		}
//		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
//		ActiveAlarmTable bean = (ActiveAlarmTable)tableModel.getRow(fTable.getSelectedRow());
//
//		Long alarmId = 65536 * bean.getUtsBbsAlarmActiveProbableCause() + bean.getUtsBbsAlarmActiveSpecificProblem();
//		
//		if(!isADMCAlarm(alarmId)) {
//			return;
//		}
//		
//		if ( !MessageDialog.showConfirmOperationDialog( fApplication) ){
//			return;
//		}
//		
//		bean.setUtsBbsAlarmActiveClearManually( 1 );
//		CleanAlarmTask task = new CleanAlarmTask( bean );
//			
//		task.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
//		try {
//			Boolean result = (Boolean) fApplication.getTaskManager().executeTask( task );
//
//			if (!result.booleanValue()) {
//				throw new OperationFailedException(" operation failed");
//			}
//
//			new RefreshAllCommand(fApplication, fTable).execute();
//		} catch (Exception ex) {
//			MessageDialog.showOperationFailedDialog(fApplication);
//			throw new OperationFailedException(  "operation failed" );
//		} finally {			
//		}
//
//	}
//	
//	private boolean isADMCAlarm(Long alarmId) {
//		if(alarmId == 20119576 || alarmId == 20119577 || alarmId == 20119578 || alarmId == 20250698 || alarmId == 20250732)
//			return true;
//		return false;
//	}
//	
//	class CleanAlarmTask extends Task {
//
//		ActiveAlarmTable fBean = null;
//
//		public CleanAlarmTask( ActiveAlarmTable bean) {
//			fBean = bean;
//		}
//
//		public Object execute() throws Exception {
//			return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
//		}
//
//	}
//
//}

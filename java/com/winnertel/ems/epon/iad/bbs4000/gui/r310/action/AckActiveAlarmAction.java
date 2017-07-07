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
//import com.winnertel.ems.fm.client.util.FMClientUtil;
//import com.winnertel.inms.topodb.UTopoAPI;
//
//import java.awt.event.ActionEvent;
//
//public class AckActiveAlarmAction extends SnmpAction {
//
//	public AckActiveAlarmAction(IApplication anApplication) {
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
////		if(bean.getUtsBbsAlarmActiveAcknowledge() == 1)
////			return;
//
//		if ( !MessageDialog.showConfirmOperationDialog( fApplication) ){
//			return;
//		}
//		
//		bean.setUtsBbsAlarmActiveAcknowledge( 1 );
//		AckAlarmTask task = new AckAlarmTask( bean );
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
//	class AckAlarmTask extends Task {
//
//		ActiveAlarmTable fBean = null;
//
//		public AckAlarmTask( ActiveAlarmTable bean) {
//			fBean = bean;
//		}
//
//		public Object execute() throws Exception {
////			String instance = (String)formatter.format(fBean, "utsBbsAlarmActiveEntityInstance");
//			//entity = mo_utsBbsAlarmActiveSequenceNumber_utsBbsAlarmActiveSessionId
//			try {
//				String neName = UTopoAPI.getAPI().getNodeNameByIP(fApplication.getSnmpProxy().getTargetHost());
//				String entity = neName+"_"+fBean.getUtsBbsAlarmActiveSequenceNumber()+"_"+fBean.getUtsBbsAlarmActiveSessionId();
//				FMClientUtil.ackAlert(entity);
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//			return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
//		}
//
//	}
//
//}

//package com.winnertel.ems.epon.iad.bbs4000.checker.r310;
//
//import com.winnertel.ems.epon.iad.bbs4000.mib.r311.ActiveAlarmTable;
//import com.winnertel.em.framework.IApplication;
//import com.winnertel.em.framework.gui.action.BaseChecker;
//import com.winnertel.em.framework.gui.util.MessageDialog;
//import com.winnertel.em.framework.model.snmp.SnmpMibBean;
//
//public class ActiveAlarmCleanChecker extends BaseChecker {
//	public ActiveAlarmCleanChecker(IApplication app) {
//		super(app);
//	}
//
//	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
//		String error = "";
//
//		ActiveAlarmTable bean = (ActiveAlarmTable) selectedMibBeans[0];
//
//		Long alarmId = 65536 * bean.getUtsBbsAlarmActiveProbableCause()
//				+ bean.getUtsBbsAlarmActiveSpecificProblem();
//
//		if (!isADMCAlarm(alarmId)) {
//			MessageDialog.showErrorMessageDialog(fApplication, fApplication
//					.getActiveDeviceManager().getGuiComposer().getString(
//							"Error_ADMC_ALARM_CLEAR"));
//			return false;
//		}
//
//		return true;
//	}
//
//	private boolean isADMCAlarm(Long alarmId) {
//		if (alarmId == 20119576 || alarmId == 20119577 || alarmId == 20119578
//				|| alarmId == 20250698 || alarmId == 20250732)
//			return true;
//		return false;
//	}
//}
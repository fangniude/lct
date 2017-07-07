package com.winnertel.ems.epon.iad.bbs1000.gui.action;

import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.task.ModifyTask;
import com.winnertel.ems.epon.iad.bbs4000.mib.SystemAdministrationBean;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RestoreSystemAction extends BaseAction {
	public RestoreSystemAction(IApplication anApplication) {
		super(anApplication);
	}

	// for fix MR NMS00055501 by Tsinyun
	IStringMap fStringMap = null;

	private IStringMap getStringMap() {
		if (fStringMap == null) {
			if (fApplication.getActiveDeviceManager() != null) {
				fStringMap = new DvmStringMap(fApplication
						.getActiveDeviceManager().getGuiComposer());
			}
		}
		return fStringMap;
	}

	public void executeAction(ActionEvent e) throws Exception {
		// Check the privilege.
		if (!fApplication.isDebug()) {
			final ISecurityManager securityManager = fApplication
					.getSecurityManager();
			final ISession session = fApplication.getSession();
			if (!securityManager.isAuthorized(session,
					"SystemBootGroupMOD_Restore")) {
				MessageDialog.showPermissionDeniedDialog(fApplication);
				return;
			}
		}

		//String msg = "Do you confirm to restore the default settings?\nIf NE is restored, all the configuration data will be lost!";
    String msg = getStringMap().getString("Confirm_Restore_NE_1") + "\r\n" + getStringMap().getString("Confirm_Restore_NE_2");
		if (JOptionPane.OK_OPTION == MessageDialog.showConfirmDialog(
				fApplication, msg)) {
			SystemAdministrationBean bean = new SystemAdministrationBean(
					fApplication.getSnmpProxy());
			bean.setUtsBBSSysFactoryDefault(new Integer(1)); // 1- reset the
																// system.

			Task t = new ModifyTask(bean);
			t.setCancelable(false);

			try {
				Object o = fApplication.getTaskManager().executeTask(t);
				if (Boolean.TRUE == o) {
					MessageDialog.showOperationSucceedDialog(fApplication);
				} else {
					MessageDialog.showOperationFailedDialog(fApplication);
				}
			} catch (Exception ex) {
				MessageDialog.showOperationFailedDialog(fApplication);
			}
		}
	}
}

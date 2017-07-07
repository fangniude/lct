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

public class ResetSystemAction extends BaseAction {
	IStringMap fStringMap = null;

	public ResetSystemAction(IApplication anApplication) {
		super(anApplication);
	}

	// for fix MR NMS00055501 by Tsinyun
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
					"SystemBootGroupMOD_Restart")) {
				MessageDialog.showPermissionDeniedDialog(fApplication);
				return;
			}
		}

		// String msg =
		// fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Cfm_Reset_System");
		// String msg = "Do you confirm to restart NE?\nAll operations will fail
		// before the NE is restarted.";
		// for fix MR NMS00055501 by Tsinyun
		String msg = getStringMap().getString("Confirm_Reset_NE_1") + "\r\n" + getStringMap().getString("Confirm_Reset_NE_2");
		if (JOptionPane.OK_OPTION == MessageDialog.showConfirmDialog(
				fApplication, msg)) {
			SystemAdministrationBean bean = new SystemAdministrationBean(
					fApplication.getSnmpProxy());
			bean.setUtsBBSSysOperState(new Integer(3)); // 3- reset the system.

			Task t = new ModifyTask(bean);
			t.setCancelable(false);

			try {
				Object o = fApplication.getTaskManager().executeTask(t);

				// NE doesn't return the result to EMS. So if no exception is
				// thrown,
				// show the success message to user.
				MessageDialog.showOperationSucceedDialog(fApplication);
			} catch (Exception ex) {
				MessageDialog.showOperationFailedDialog(fApplication);
			}
		}
	}
}

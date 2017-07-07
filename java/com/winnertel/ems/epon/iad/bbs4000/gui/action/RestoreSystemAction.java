package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.SystemAdministrationBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.task.ModifyTask;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RestoreSystemAction extends BaseAction {

    public RestoreSystemAction(IApplication anApplication) {
        super(anApplication);
        putValue(BaseAction.ID, "Restore_NE");
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
            return;

        //Check the privilege.
        if (!fApplication.isDebug()) {
            final ISecurityManager securityManager = fApplication.getSecurityManager();
            final ISession session = fApplication.getSession();
            if (!securityManager.isAuthorized(session, "SystemBootGroupMOD_Restore")) {
                MessageDialog.showPermissionDeniedDialog(fApplication);
                return;
            }
        }

        String msg1 = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Cfm_Restore_System_1");
        String msg2 = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Cfm_Restore_System_2");

        if (JOptionPane.OK_OPTION == MessageDialog.showConfirmDialog(fApplication, msg1 + "\r\n" + msg2)) {
            SystemAdministrationBean bean = new SystemAdministrationBean(fApplication.getSnmpProxy());
            bean.setUtsBBSSysFactoryDefault(1); //1- reset the system.

            Task t = new ModifyTask(bean);
            t.setCancelable(false);

            try {
                Object o = fApplication.getTaskManager().executeTask(t);
                if (Boolean.TRUE == o) {
                    MessageDialog.showOperationSucceedDialog(fApplication);
                } else {
                    MessageDialog.showOperationFailedDialog(fApplication);
                    throw new OperationFailedException(fApplication.getSession().getUser() + " failed to restore ne.");
                }
            } catch (Exception ex) {
                MessageDialog.showOperationFailedDialog(fApplication);
                throw new OperationFailedException(fApplication.getSession().getUser() + " failed to restore ne.");
            }
        } else {
            throw new OperationCanceledException(fApplication.getSession().getUser() + " canceled the operation.");
        }
    }

}
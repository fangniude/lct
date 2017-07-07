package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.SystemAdministrationBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.task.ModifyTask;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResetSystemAction extends BaseAction {

    public ResetSystemAction(IApplication anApplication) {
        super(anApplication);
        putValue(BaseAction.ID, "Restart_NE");
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
            return;

        //Check the privilege.
        if (!fApplication.isDebug()) {
            final ISecurityManager securityManager = fApplication.getSecurityManager();
            final ISession session = fApplication.getSession();
            if (!securityManager.isAuthorized(session, "SystemBootGroupMOD_Restart")) {
                MessageDialog.showPermissionDeniedDialog(fApplication);
                return;
            }
        }

        // NMS00060620
        String msg1 = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Cfm_Reset_System_1");
        String msg2 = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Cfm_Reset_System_2");
        String warningTitle = fApplication.getActiveDeviceManager().getGuiComposer().getString("Risky Operation Prompt");

        int result = JOptionPane.showConfirmDialog(fApplication.getTopMostFrame(), msg1 + "\r\n" + msg2, warningTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (JOptionPane.OK_OPTION == result) {
            SystemAdministrationBean bean = new SystemAdministrationBean(fApplication.getSnmpProxy());
            bean.setUtsBBSSysOperState(3); //3- reset the system.

            Task t = new ModifyTask(bean);
            t.setCancelable(false);

            try {
                Object o = fApplication.getTaskManager().executeTask(t);

                //NE doesn't return the result to EMS. So if no exception is thrown, show the success message to user.
                MessageDialog.showOperationSucceedDialog(fApplication);
            } catch (Exception ex) {
                MessageDialog.showOperationFailedDialog(fApplication);
            }
        }
    }

}
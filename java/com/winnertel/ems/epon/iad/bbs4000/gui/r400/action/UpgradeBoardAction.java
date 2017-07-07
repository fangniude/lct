package com.winnertel.ems.epon.iad.bbs4000.gui.r400.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.BoardTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.task.ModifyTask;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UpgradeBoardAction extends SnmpAction {

    public UpgradeBoardAction(IApplication anApplication) {
        super(anApplication);
        putValue(BaseAction.ID, "Upgrade_Board");
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
            return;

        //Check the privilege.
        if (!fApplication.isDebug()) {
            final ISecurityManager securityManager = fApplication.getSecurityManager();
            final ISession session = fApplication.getSession();
            if (!securityManager.isAuthorized(session, "Upgrade_Board")) {
                MessageDialog.showPermissionDeniedDialog(fApplication);
                return;
            }
        }

        int row = fTable.getSelectedRow();

        if (row == -1) {
            return;
        }

        SnmpTableModel model = (SnmpTableModel) fTable.getModel();
        BoardTable bean = (BoardTable) model.getRow(row);

        bean.setAction(3); //upgrade

        String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_cfm_Upgrade_board");
        if (JOptionPane.OK_OPTION == MessageDialog.showConfirmDialog(fApplication, msg)) {
            Task t = new ModifyTask(bean);
            try {
                Object o = fApplication.getTaskManager().executeTask(t);
                if (Boolean.TRUE == o) {
                    MessageDialog.showOperationSucceedDialog(fApplication);
                } else {
                    MessageDialog.showOperationFailedDialog(fApplication);
                    throw new OperationFailedException(fApplication.getSession().getUser() + " failed to Upgrade board.");
                }
            } catch (Exception ex) {
                MessageDialog.showOperationFailedDialog(fApplication);
                throw new OperationFailedException(fApplication.getSession().getUser() + " failed to Upgrade board.");
            }
        } else {
            throw new OperationCanceledException(fApplication.getSession().getUser() + " canceled the operation.");
        }
    }

}
package com.winnertel.ems.epon.iad.eoc.gui.action;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;

import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: GGG
 * Date: 2010-7-7
 * Time: 13:07:30
 * To change this template use File | Settings | File Templates.
 */
public class ResetCNUAction extends SnmpAction {

    public ResetCNUAction(IApplication anApplication) {
        super(anApplication);
        putValue(BaseAction.ID, "Reset_CNU");
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
            return;

        //Check the privilege.   todo
        if (!fApplication.isDebug()) {
            final ISecurityManager securityManager = fApplication.getSecurityManager();
            final ISession session = fApplication.getSession();
            //if (!securityManager.isAuthorized(session, "Switch_Board")) {
            //    MessageDialog.showPermissionDeniedDialog(fApplication);
            //    return;
            ///}
        }

        int selectedRowCount = fTable.getSelectedRowCount();
        if (selectedRowCount == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        int row = fTable.getSelectedRow();

        if (row == -1) {
            return;
        }

        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw new OperationCanceledException("Reset CNU action canceled");
        }

        // Reset the ONU, set utsDot3Onu2CtcReset 1: reset(1)
        Task t = new ResetCardTask(fTable);
        t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
        try {
            Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
            if (!result.booleanValue()) {
                throw new OperationFailedException("Reset CNU operation failed");
            }
            new RefreshAllCommand(fApplication, fTable).execute();
        } catch (Exception ex) {
            MessageDialog.showOperationFailedDialog(fApplication);
            throw new OperationFailedException("Reset CNU operation failed");
        } finally {
            MibBeanIdFormatter idFormatter = fTable.getRowIdFormatter();
            if (idFormatter != null) {
                OperationObject oo = idFormatter.format(bean, tableModel.getRowText(fTable.getSelectedRow()));
                // set operation object to device manager
                OperationObject currentOo = fApplication.getActiveDeviceManager().getOperationObject();
                currentOo.setChassis(oo.getChassis());
                currentOo.setBoard(oo.getBoard());
                currentOo.setPort(oo.getPort());
            }
        }

        /*
        SnmpTableModel model = (SnmpTableModel) fTable.getModel();
        ModEoCCBATCardTable bean = (ModEoCCBATCardTable) model.getRow(row);

        boolean isOk=bean.resetCard();

        if (isOk) {
            MessageDialog.showOperationSucceedDialog(fApplication);
        } else {
            MessageDialog.showOperationFailedDialog(fApplication);
            //throw new OperationFailedException(fApplication.getSession().getUser() + " failed to switch board.");
        } */
        /*
        String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_cfm_switch_board");
        if (JOptionPane.OK_OPTION == MessageDialog.showConfirmDialog(fApplication, msg)) {
            Task t = new ModifyTask(bean);
            try {
                Object o = fApplication.getTaskManager().executeTask(t);
                if (Boolean.TRUE == o) {
                    MessageDialog.showOperationSucceedDialog(fApplication);
                } else {
                    MessageDialog.showOperationFailedDialog(fApplication);
                    throw new OperationFailedException(fApplication.getSession().getUser() + " failed to switch board.");
                }
            } catch (Exception ex) {
                MessageDialog.showOperationFailedDialog(fApplication);
                throw new OperationFailedException(fApplication.getSession().getUser() + " failed to switch board.");
            }
        } else {
            throw new OperationCanceledException(fApplication.getSession().getUser() + " canceled the operation.");
        }
        */
    }

    class ResetCardTask extends Task {

        SnmpTable fTable = null;

        public ResetCardTask(SnmpTable table) {
            fTable = table;
        }

        public Object execute() throws Exception {
            SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
            ModEoCCNUTable bean = (ModEoCCNUTable) tableModel.getRow(fTable.getSelectedRow());

            return bean.resetCNU() ? Boolean.TRUE : Boolean.FALSE;
        }

    }
}

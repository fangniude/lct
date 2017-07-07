package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.errorcode.IErrorCodeManager;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;
import com.winnertel.em.standard.snmp.task.DeleteTask;


public class DeleteCommand extends SnmpTableCommand {
    public DeleteCommand(IApplication aApplication, SnmpTable aTable) {
        super(aApplication, aTable);
    }


    public boolean execute() throws OperationCanceledException {
        OperationCanceledException exception = new OperationCanceledException("Delete action canceled");

        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw exception;
        }

        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

        // clear current selection
        fTable.clearSelection();

        // delete the row
        Task t = new DeleteTask(bean);
        t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
        try {
            Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
//            MessageDialog.showOperationSucceedDialog( fApplication );
            return result.booleanValue();
        } catch (Exception ex) {
            if (ex instanceof MibBeanException) {
                dealWithException((MibBeanException) ex);
            } else {
                MessageDialog.showOperationFailedDialog(fApplication);
            }
            return false;
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
    }

    private void dealWithException(MibBeanException aMibBeanException) {
        IErrorCodeManager errorCodeManager = fApplication.getErrorCodeManager();

        if (errorCodeManager != null && aMibBeanException.getErrorStatus() == 5) {// Error code
            String errorMessage = errorCodeManager.getErrorMessage(aMibBeanException.getRequestId(), aMibBeanException.getLocalAddress());
            if (errorMessage == null || "".equalsIgnoreCase(errorMessage.trim())) {
                MessageDialog.showOperationFailedDialog(fApplication);
            } else {
                MessageDialog.showErrorMessageDialog(fApplication, errorMessage.trim());
            }
        } else {
            MessageDialog.showOperationFailedDialog(fApplication);
        }
    }
}

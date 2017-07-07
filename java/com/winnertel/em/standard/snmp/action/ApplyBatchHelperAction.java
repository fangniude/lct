package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.task.AddTask;
import com.winnertel.em.standard.snmp.task.ModifyTask;

import java.awt.event.ActionEvent;

public class ApplyBatchHelperAction extends SnmpAction {
    private ILogger fLogger = LoggerController.createLogger(ApplyBatchHelperAction.class);

    private int fResult;

    public ApplyBatchHelperAction(IApplication anApplication) {
        super(anApplication);
    }

    public int getResult() {
        return fResult;
    }

    public void executeAction(ActionEvent e)
            throws OperationFailedException, OperationCanceledException {
        try {
            fPanel.beforeUpdateModel();

            // update the mib bean from gui
            fPanel.updateModel();

            // apply to device
            Task t = null;
            String command = (String) getValue(SnmpAction.COMMAND);
            if (SnmpAction.IType.ADD.equals(command)) {
                t = new AddTask((SnmpMibBean) fPanel.getModel());
            } else if (SnmpAction.IType.MODIFY.equals(command)) {
                t = new ModifyTask((SnmpMibBean) fPanel.getModel());
            }

            if (t != null) {
                t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
            }

            fApplication.getTaskManager().executeTask(t);
            fResult = t.getStatus();
        } catch (Exception ex) {
            fResult = Task.FAILED;
            throw new OperationFailedException("Apply batch helper action failed", ex);
        } finally {
            try {
                fPanel.afterUpdateModel();
            } catch (Exception ex) {
                fLogger.error("Error in after update model", ex);
            }
            if (fResult == Task.CANCELED) {
                throw new OperationCanceledException("Apply batch helper action canceled");
            }
        }
    }
}

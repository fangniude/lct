package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.task.DeleteTask;

import java.awt.event.ActionEvent;

public class DeleteBatchHelperAction extends BaseAction {
    private SnmpMibBean fMibBean;
    private int fResult;


    public DeleteBatchHelperAction(IApplication anApplication, SnmpMibBean aMibBean) {
        super(anApplication);
        fMibBean = aMibBean;
    }


    public int getResult() {
        return fResult;
    }


    public void executeAction(ActionEvent e)
            throws OperationFailedException, OperationCanceledException {
        Task t = new DeleteTask(fMibBean);
        t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
        try {
            Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
            fResult = t.getStatus();
        } catch (Exception ex) {
            fResult = Task.FAILED;
            throw new OperationFailedException("Delete batch helper action failed", ex);
        } finally {
            if (fResult == Task.CANCELED) {
                throw new OperationCanceledException("Delete batch helper action canceled");
            }
        }
    }
}

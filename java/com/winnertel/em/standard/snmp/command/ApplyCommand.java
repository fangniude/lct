package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.errorcode.IErrorCodeManager;
import com.winnertel.em.framework.gui.action.BaseCommand;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.task.AddTask;
import com.winnertel.em.standard.snmp.task.ModifyTask;

import javax.swing.*;

//import IErrorCodeManager;

public class ApplyCommand extends BaseCommand {
    private ILogger fLogger = LoggerController.createLogger(ApplyCommand.class);

    private UPanel fPanel = null;

    private String fCommand = null;

    public ApplyCommand(IApplication aApplication, UPanel aPanel, String aCommand) {
        super(aApplication);
        fPanel = aPanel;
        fCommand = aCommand;
    }

    public boolean execute() {
        fPanel.beforeUpdateModel();

        // update the mib bean from gui
        fPanel.updateModel();

        // apply to device
        Task t = null;
        if (fCommand.equals(SnmpAction.IType.ADD)) {
            t = new AddTask((SnmpMibBean) fPanel.getModel());
        } else if (fCommand.equals(SnmpAction.IType.MODIFY)) {
            t = new ModifyTask((SnmpMibBean) fPanel.getModel());
        }

        if (t != null) {
            t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
        }

        try {
            fApplication.getTaskManager().executeTask(t);
        } catch (Exception ex) {
            if (ex instanceof MibBeanException) {
                dealWithException((MibBeanException) ex);
            } else {
                MessageDialog.showOperationFailedDialog(fApplication);
            }
        } finally {
            try {
                fPanel.afterUpdateModel();
            } catch (Exception e) {
                fLogger.error("Error in after update model", e);
            }
        }


        return true;
    }

    private void dealWithException(MibBeanException aMibBeanException) {
        IErrorCodeManager errorCodeManager = fApplication.getErrorCodeManager();

        if (errorCodeManager != null && aMibBeanException.getErrorStatus() == 5) {// Error
                                                                                  // code
            String errorMessage = errorCodeManager.getErrorMessage(aMibBeanException.getRequestId(), aMibBeanException.getLocalAddress());
            if (errorMessage == null || "".equalsIgnoreCase(errorMessage.trim())) {
                MessageDialog.showOperationFailedDialog(fApplication);
            } else {
                MessageDialog.showInfoMessageDialog(fApplication, errorMessage.trim());
            }
        } else if (hasErrorIndex(aMibBeanException)) {// error index
            String itemString = fApplication.getActiveDeviceManager().getGuiComposer().getString(aMibBeanException.getErrorItem());
            String configString = fApplication.getGlobalStringMap().getString("Configuration");
            String errorString = fApplication.getGlobalStringMap().getString("Error");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(itemString);
            stringBuilder.append(" ");
            stringBuilder.append(configString);
            stringBuilder.append(" ");
            stringBuilder.append(errorString);
            stringBuilder.append("!");

            String title = getTitle(aMibBeanException.getErrorStatus());

            MessageDialog.showMessageDialog(fApplication, stringBuilder.toString(), errorString, JOptionPane.ERROR_MESSAGE);
        } else if (aMibBeanException.getErrorStatus() == 6) {// it defined by NMS
            String errMsg = fApplication.getActiveDeviceManager().getGuiComposer().getString(aMibBeanException.getErrorItem());

            String title = getTitle(aMibBeanException.getErrorStatus());

            MessageDialog.showErrorMessageDialog(fApplication, errMsg);
        } else {
            MessageDialog.showOperationFailedDialog(fApplication);
        }
    }

    private String getTitle(int errorStatus) {
        IStringMap globalStringMap = fApplication.getGlobalStringMap();
        switch (errorStatus) {
            case 2:
                return globalStringMap.getString("No Such Name");
            case 3:
                return globalStringMap.getString("Bad Value");
            case 4:
                return globalStringMap.getString("Read Only");
            case 5:
                return globalStringMap.getString("Gen Error");
            default:
                return globalStringMap.getString("Error");
        }
    }

    private boolean hasErrorIndex(MibBeanException aMibBeanException) {
        int errorStatus = aMibBeanException.getErrorStatus();
        if (errorStatus < 2 || errorStatus > 5) {
            // error index is valid when the error status is in
            // {2:noSuchName,3:badValue,4:readOnly,5:genErr}
            return false;
        }

        String errorItem = aMibBeanException.getErrorItem();
        if (errorItem == null || errorItem.equalsIgnoreCase("")) {
            // the error index is invalid
            return false;
        }
        return true;
    }

}

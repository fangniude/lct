package com.winnertel.em.framework.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.framework.util.ValidationFailedException;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class BaseAction extends AbstractAction {
    private ILogger fLogger = LoggerController.createLogger(BaseAction.class);

    public static final String ID = "id";

    protected IApplication fApplication = null;


    public BaseAction(IApplication anApplication) {
        super();
        fApplication = anApplication;
    }


    final public void actionPerformed(ActionEvent e) {
        String actionId = (String) getValue(ID);
        if (checkPermission(actionId)) {
//            boolean completed = false;
            if (canExecute(e)) {
                try {
                    executeAction(e);
                    writeOperationLog(true);
//                    completed = true;
                } catch (OperationCanceledException ex) {
                    fLogger.error("Operation canceled, action id=" + actionId, ex);
                } catch (OperationFinishedWithoutLogException ex) {
                    fLogger.error("Operation finished without log, action id=" + actionId, ex);
                } catch (ValidationFailedException ex) {
                    fLogger.error("Validation failed: action id=" + actionId, ex);
                } catch (OperationFailedException ex) {
                    fLogger.error("Operation failed: action id=" + actionId, ex);
                    writeOperationLog(false);
                } catch (Exception ex) {
                    fLogger.error("Error in executing action: action id=" + actionId, ex);
                    writeOperationLog(false);
                }/* finally {
                	writeOperationLog( completed );
                }*/
            }
        }
    }

    private boolean checkPermission(String anActionId) {
        if (fApplication.isDebug() || anActionId == null || anActionId.length() == 0) {
            return true;
        }

        final ISecurityManager securityManager = fApplication.getSecurityManager();
        final ISession session = fApplication.getSession();
        if (!securityManager.isAuthorized(session, anActionId)) {
            MessageDialog.showPermissionDeniedDialog(fApplication);
            return false;
        } else {
            return true;
        }
    }

    private void writeOperationLog(boolean isCompleted) {
        try {
            ILogInfo logInfo = fApplication.getLogManager().getLogInfo((String) getValue(BaseAction.ID));
            if (logInfo != null) {
                if (isCompleted) {
                    logInfo.setStatus(ILogInfo.COMPLETED);
                } else {
                    logInfo.setStatus(ILogInfo.FAILED);
                }
                fApplication.getLogManager().writeLog(logInfo);
                // Removed by SuPeng's request
                //fApplication.getMainApplet().getMessageWindow().writeLog( logInfo );
            }
        } catch (Exception ex) {
            fLogger.error("Failed to write operation log", ex);
        }
    }


    public boolean canExecute(ActionEvent e) {
        return true;
    }


    public abstract void executeAction(ActionEvent e) throws Exception;
}

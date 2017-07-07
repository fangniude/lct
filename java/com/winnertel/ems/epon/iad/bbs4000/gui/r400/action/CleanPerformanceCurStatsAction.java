/**
 * Created by Zhou Chao, 2010/5/11
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.CurStatsTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.task.ModifyTask;

import java.awt.event.ActionEvent;

/**
 * Clean Performance 'curStatsTable' Action
 */
public class CleanPerformanceCurStatsAction extends SnmpAction {

    public CleanPerformanceCurStatsAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw new OperationCanceledException("Clean Performance 'curStatsTable' action canceled");
        }

        // Clean Performance 'curStatsTable', set curStatsStatusAndAction 2: clean(2)
        CurStatsTable bean = null;
        try {
            bean = new CurStatsTable(fApplication.getSnmpProxy());
            bean.cleanCurStats();

            Task t = new ModifyTask(bean);
            t.setCancelable(false);

            t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));

            Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
            if (!result) {
                throw new OperationFailedException("Clean Performance 'curStatsTable' operation failed");
            }

            new RefreshAllCommand(fApplication, fTable).execute();
        } catch (Exception ex) {
            MessageDialog.showOperationFailedDialog(fApplication);
            throw new OperationFailedException("Clean Performance 'curStatsTable' operation failed");
        }
    }

}
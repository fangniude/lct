package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseCommand;
import com.winnertel.em.framework.gui.swing.UPanel;

public class RefreshCommand extends BaseCommand {
    private UPanel fPanel = null;


    public RefreshCommand(IApplication aApplication, UPanel aPanel) {
        super(aApplication);
        fPanel = aPanel;
    }


    public boolean execute() {
/*
        Task t = new RefreshTask((SnmpMibBean) fPanel.getModel());
        try {
            fApplication.getTaskManager().executeTask(t);
        } catch (Exception ex) {
            MessageDialog.showQueryFailedDialog(fApplication);
            return false;
        }
*/

        fPanel.refresh();

        return true;
    }
}

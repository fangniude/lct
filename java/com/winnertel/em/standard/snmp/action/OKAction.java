package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.command.ApplyCommand;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.command.RefreshCommand;

import java.awt.event.ActionEvent;

public class OKAction extends SnmpAction {

    public OKAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (!GuiUtil.validateFrom(fPanel, fApplication) || !fPanel.validateFrom()) {
            return;
        }

/*
        // prompt user for confirmation
        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw new OperationCanceledException( "Apply action canceled" );
        }
*/

        if (fCommand == null) {
            fCommand = new ApplyCommand(fApplication, fPanel, (String) getValue(COMMAND));
        }

        boolean operationSucceed = false;
        try {
            operationSucceed = fCommand.execute();
        } catch (Exception ex) {
        } finally {
            if (!operationSucceed) {
                throw new OperationFailedException("Apply action failed");
            }
        }
        if (fTable != null) {
            new RefreshAllCommand(fApplication, fTable).execute();
        } else {
            new RefreshCommand(fApplication, fPanel).execute();
        }
        if (fPanel != null) {
            GuiUtil.getParentDialog(fPanel).dispose();
        }
    }
}

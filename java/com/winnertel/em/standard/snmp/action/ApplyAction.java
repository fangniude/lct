package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.framework.util.ValidationFailedException;
import com.winnertel.em.standard.snmp.command.ApplyBatchCommand;
import com.winnertel.em.standard.snmp.command.ApplyCommand;
import com.winnertel.em.standard.snmp.command.RefreshCommand;
import com.winnertel.em.standard.snmp.command.RefreshTableCommand;

import java.awt.event.ActionEvent;

public class ApplyAction extends SnmpAction {
    public ApplyAction(IApplication anApplication) {
        super(anApplication);
    }


    public void executeAction(ActionEvent e)
            throws OperationFailedException, OperationCanceledException,
            ValidationFailedException, OperationFinishedWithoutLogException {
        // validate form value
        if (!GuiUtil.validateFrom(fPanel, fApplication) ||
                !fPanel.validateFrom()) {
            throw new ValidationFailedException("Validation failed before apply");
        }

/*
        // prompt user for confirmation
        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw new OperationCanceledException( "Apply action canceled" );
        }
*/

        if (fTable != null && fTable.getSelectedRowCount() > 1 && ((String) getValue(SnmpAction.COMMAND)).equals(SnmpAction.IType.MODIFY)) {
            fCommand = new ApplyBatchCommand(fApplication, fPanel, fTable, (String) getValue(SnmpAction.COMMAND), (String) getValue(BaseAction.ID));
        } else {
            fCommand = new ApplyCommand(fApplication, fPanel, (String) getValue(SnmpAction.COMMAND));
        }

        try {
            if (!fCommand.execute()) {
                throw new OperationFailedException("Apply action failed");
            }

            //change the configChanged property to indicate that the configuration data is changed.
            fApplication.getActiveDeviceManager().getProperties().setProperty("configChanged", "true");
        } catch (OperationFinishedWithoutLogException ex) {
            //change the configChanged property to indicate that the configuration data is changed.
            fApplication.getActiveDeviceManager().getProperties().setProperty("configChanged", "true");
            throw ex;
        } catch (Exception ex) {
            throw new OperationFailedException("Apply action failed", ex);
        } finally {
            if (fTable != null) {
                RefreshTableCommand cmd = new RefreshTableCommand(fApplication, fTable);

                //only refresh the selected rows. 
                if (SnmpAction.IType.MODIFY.equals(getValue(SnmpAction.COMMAND))) {
                    cmd.setMode(RefreshTableCommand.REFRESH_SELECTION);
                }

                cmd.execute();
            } else {
                new RefreshCommand(fApplication, fPanel).execute();
            }
        }
    }
}

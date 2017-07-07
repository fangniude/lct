package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.util.BaseException;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.command.DeleteBatchCommand;
import com.winnertel.em.standard.snmp.command.DeleteCommand;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.command.SnmpTableCommand;

import java.awt.event.ActionEvent;

public class DeleteAction extends SnmpAction {
    public DeleteAction(IApplication anApplication) {
        super(anApplication);
    }


    public void executeAction(ActionEvent e)
            throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
        int selectedRowCount = fTable.getSelectedRowCount();
        if (selectedRowCount == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        SnmpTableCommand cmd = null;
        if (selectedRowCount == 1) {
            cmd = new DeleteCommand(fApplication, fTable);
        } else {
            cmd = new DeleteBatchCommand(fApplication, fTable, (String) getValue(BaseAction.ID));
        }

        try {
            if (!cmd.execute()) {
                throw new OperationFailedException("Delete operation failed");
            }

            new RefreshAllCommand(fApplication, fTable).execute();
        } catch (OperationCanceledException ex) {
            throw ex;
        } catch (OperationFinishedWithoutLogException ex) {
            new RefreshAllCommand(fApplication, fTable).execute();
            throw ex;
        } catch (BaseException ex) {
            new RefreshAllCommand(fApplication, fTable).execute();
            throw new OperationFailedException("Delete operation failed", ex);
        }
    }
}

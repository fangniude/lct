package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.task.RefreshAllTask;

import java.util.Vector;

public class RefreshAllCommand extends SnmpTableCommand {

    public RefreshAllCommand(IApplication aApplication, SnmpTable aTable) {
        super(aApplication, aTable);
    }


    public boolean execute() {
        SnmpTableModel model = (SnmpTableModel) fTable.getModel();

        int[] selectRows = fTable.getSelectedRows();
        Task t = new RefreshAllTask(model.getMibBean());
        t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while retrieving data from NE"));
        Vector dataVector = null;
        try {
            dataVector = (Vector) fApplication.getTaskManager().executeTask(t);
            //doesn't show the information dialog when user tries to cancel the operation.
//            if ( t.getStatus() == Task.CANCELED ) {
//                JOptionPane.showMessageDialog( this.fApplication.getTopMostFrame(), "Canceled by User",
//                                "Warning", JOptionPane.PLAIN_MESSAGE );
//                return false;
//            }
        } catch (Exception ex) {
            MessageDialog.showQueryFailedDialog(fApplication);
            return false;
        }

        model.setDataVector(dataVector);
        fTable.updateUI();

        fTable.clearSelection();
        for (int i = 0; i < selectRows.length; i++) {
            if (selectRows[i] < fTable.getRowCount()) {
                fTable.addRowSelectionInterval(selectRows[i], selectRows[i]);
            }
        }
        return true;
    }
}

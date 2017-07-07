package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.action.DeleteBatchHelperAction;
import com.winnertel.em.standard.snmp.gui.MultipleOperationSummaryDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;
import com.winnertel.em.standard.snmp.task.MultipleOperationSummary;

public class DeleteBatchCommand extends SnmpTableCommand {
    private ILogger fLogger = LoggerController.createLogger(DeleteBatchCommand.class);

    private String fActionID;


    public DeleteBatchCommand(IApplication aApplication, SnmpTable aTable, String anActionID) {
        super(aApplication, aTable);
        fActionID = anActionID;
    }


    public boolean execute() throws OperationCanceledException, OperationFinishedWithoutLogException {
        boolean result = true;
        OperationCanceledException canceledException = new OperationCanceledException("Delete action canceled");

        int[] selectedRows = fTable.getSelectedRows();
        if (selectedRows.length == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            throw canceledException;
        }

        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw canceledException;
        }

        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        MultipleOperationSummary summary = new MultipleOperationSummary();
        for (int i = 0; i < selectedRows.length; i++) {
            SnmpMibBean mibBean = (SnmpMibBean) tableModel.getRow(selectedRows[i]);
            String mibBeanId = mibBean.toString();

            MibBeanIdFormatter idFormatter = fTable.getRowIdFormatter();
            if (idFormatter != null) {
                OperationObject oo = idFormatter.format(mibBean, tableModel.getRowText(selectedRows[i]));
                // set operation object to device manager
                OperationObject currentOo = fApplication.getActiveDeviceManager().getOperationObject();
                currentOo.setChassis(oo.getChassis());
                currentOo.setBoard(oo.getBoard());
                currentOo.setPort(oo.getPort());
                currentOo.setName(oo.getName());

                mibBeanId = currentOo.toString();
            }

            DeleteBatchHelperAction helperAction = new DeleteBatchHelperAction(fApplication, mibBean);
            helperAction.putValue(BaseAction.ID, fActionID);
            helperAction.actionPerformed(null);
            summary.add(mibBeanId, new Integer(helperAction.getResult()));
        }

        MultipleOperationSummaryDialog summaryDlg =
                new MultipleOperationSummaryDialog(fApplication, summary);
        summaryDlg.pack();
        summaryDlg.show();

        // We throw OperationFinishedWithoutLogException because we have written log 
        // in ApplyBatchHelperAction and don't need write log for this action
        throw new OperationFinishedWithoutLogException();
    }
}

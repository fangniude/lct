package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.action.BaseCommand;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.action.ApplyBatchHelperAction;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.MultipleOperationSummaryDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;
import com.winnertel.em.standard.snmp.task.MultipleOperationSummary;

public class ApplyBatchCommand extends BaseCommand {
    private ILogger fLogger = LoggerController.createLogger(ApplyCommand.class);

    private SnmpTable fTable;
    private UPanel fPanel;
    private String fCommand;
    private String fActionID;


    public ApplyBatchCommand(IApplication aApplication, UPanel aPanel,
                             SnmpTable aTable, String aCommand, String anActionID) {
        super(aApplication);
        fTable = aTable;
        fPanel = aPanel;
        fCommand = aCommand;
        fActionID = anActionID;
    }


    public boolean execute() throws OperationFinishedWithoutLogException {
        // only modify command is supported!
        if (!fCommand.equals(SnmpAction.IType.MODIFY)) {
            return false;
        }

        boolean result = true;

        fPanel.beforeUpdateModel();

        // update the mib bean from gui
        fPanel.updateModel();

        SnmpMibBean panelBean = (SnmpMibBean) fPanel.getModel();

        SnmpTableModel tableModel = ((SnmpTableModel) fTable.getModel());
        MultipleOperationSummary summary = new MultipleOperationSummary();
        int[] selectedRows = fTable.getSelectedRows();
        for (int i = 0; i < selectedRows.length; i++) {
            SnmpMibBean mibBean = tableModel.getRow(selectedRows[i]);
            mibBean.copyProperties(panelBean);
            fPanel.setModel(mibBean);

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

            ApplyBatchHelperAction helperAction = new ApplyBatchHelperAction(fApplication);
            helperAction.setPanel(fPanel);
            helperAction.putValue(BaseAction.ID, fActionID);
            helperAction.putValue(SnmpAction.COMMAND, fCommand);
            helperAction.actionPerformed(null);
            summary.add(mibBeanId, new Integer(helperAction.getResult()));
        }

        MultipleOperationSummaryDialog summaryDlg =
                new MultipleOperationSummaryDialog(fApplication, summary);
        summaryDlg.pack();
        summaryDlg.show();

        try {
            fPanel.afterUpdateModel();
        } catch (Exception ex) {
            fLogger.error("Error in after update model", ex);
        }

        // close the dialog if modification succeed
        /*
        if (fCommand.equals(SnmpAction.IType.MODIFY)) {
            GuiUtil.getParentDialog(fPanel).dispose();
        }
        */

        // We throw OperationFinishedWithoutLogException because we have written log 
        // in ApplyBatchHelperAction and don't need write log for this action
        throw new OperationFinishedWithoutLogException();
    }
}

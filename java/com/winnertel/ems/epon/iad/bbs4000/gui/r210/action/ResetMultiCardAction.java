package com.winnertel.ems.epon.iad.bbs4000.gui.r210.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.EponModuleBoardSummaryTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.MultipleOperationSummaryDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.task.MultipleOperationSummary;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResetMultiCardAction extends SnmpAction {
  public ResetMultiCardAction(IApplication anApplication) {
    super(anApplication);
  }

  public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {

    int selectedRowCount = fTable.getSelectedRowCount();
    if (selectedRowCount == 0) {
//      MessageDialog.showSelectRowDialog(fApplication);
      return;
    }

    // NMS00060620
    IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
    String warningTitle = composer.getString("Risky Operation Prompt");
    String warningMessage = composer.getString("Are you sure to do this configuration?");

    int confirmResult = JOptionPane.showConfirmDialog(fApplication.getTopMostFrame(),
        warningMessage,
        warningTitle,
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.WARNING_MESSAGE);

    if (confirmResult != JOptionPane.OK_OPTION) {
      throw new OperationCanceledException("Reset Card action canceled");
    }

    SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
    MultipleOperationSummary summary = new MultipleOperationSummary();
    int[] selectedRows = fTable.getSelectedRows();

    for ( int i = 0; i < selectedRows.length; i++ ) {

      EponModuleBoardSummaryTable onu = (EponModuleBoardSummaryTable)tableModel.getRow(selectedRows[i]);

      // Reset the card.
      Task t = new ResetCardTask(onu);
      t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
      Boolean result = null;
      try {
        result = (Boolean) fApplication.getTaskManager().executeTask(t);
      } catch (Exception ex) {
        ex.printStackTrace();
        result = Boolean.FALSE;
      }

      summary.add(onu.toString(), new Integer(result? Task.COMPLETED : Task.FAILED));
    }

/*
    try {
      // delay 10 seconds to wait for device ready; also according device side requirement.
      fApplication.getTaskManager().executeTask(new DelayTask());
    } catch (Exception e1) {
      e1.printStackTrace();
    }
*/

    MultipleOperationSummaryDialog summaryDlg = new MultipleOperationSummaryDialog( fApplication, summary );
    summaryDlg.pack();
    summaryDlg.show();
  }

  class ResetCardTask extends Task {

    EponModuleBoardSummaryTable card = null;

    public ResetCardTask(EponModuleBoardSummaryTable table) {
      card = table;
    }

    public Object execute() throws Exception {
      return card.reset() ? Boolean.TRUE : Boolean.FALSE;
    }
  }

  class DelayTask extends Task {

    public Object execute() throws Exception {
      try {
        setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
        Thread.sleep(10 * 1000);
      } catch (Exception ex) {
        ex.printStackTrace();
      }

      return null;
    }
  }
}
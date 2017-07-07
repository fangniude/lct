package com.winnertel.ems.epon.iad.bbs4000.gui.r200.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OnuMonitorTable;
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

public class ResetMultiOnuAction extends SnmpAction {
  public ResetMultiOnuAction(IApplication anApplication) {
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
    String warningMessage = composer.getString("Are you sure to do this configuration?") + "\r\n" + composer.getString("Err_Only_Register_ONU_Can_Reset");

    int confirmResult = JOptionPane.showConfirmDialog(fApplication.getTopMostFrame(),
        warningMessage,
        warningTitle,
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.WARNING_MESSAGE);

    if (confirmResult != JOptionPane.OK_OPTION) {
      throw new OperationCanceledException("Reset ONU action canceled");
    }

    SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
    MultipleOperationSummary summary = new MultipleOperationSummary();
    int[] selectedRows = fTable.getSelectedRows();

    for ( int i = 0; i < selectedRows.length; i++ ) {

      OnuMonitorTable onu = (OnuMonitorTable)tableModel.getRow(selectedRows[i]);

      // if register state is not 1: register(1), prompt error message.
      if (onu.getUtsDot3Onu2CtcRegisterStatus() == null || onu.getUtsDot3Onu2CtcRegisterStatus().intValue() != 1) {
        summary.add(onu.toString(), new Integer(Task.CANCELED));
        continue;
      }

      // Reset the ONU, set utsDot3Onu2CtcReset 1: reset(1)
      Task t = new ResetONUTask(onu);
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

  class ResetONUTask extends Task {

    OnuMonitorTable onu = null;

    public ResetONUTask(OnuMonitorTable table) {
      onu = table;
    }

    public Object execute() throws Exception {
      return onu.reset() ? Boolean.TRUE : Boolean.FALSE;
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
package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcConfigure;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Reset ONU Action
 */
public class ResetOnuAction extends SnmpAction {

    private static final long serialVersionUID = 1613898190444288213L;

    public ResetOnuAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {

        int selectedRowCount = fTable.getSelectedRowCount();
        if (selectedRowCount == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());
        if (bean == null)
            return;

        // if register state is not 1: register(1), prompt error message.
        if (((Dot3Onu2CtcConfigure) bean).getUtsDot3Onu2CtcRegisterStatus() == null || ((Dot3Onu2CtcConfigure) bean).getUtsDot3Onu2CtcRegisterStatus().intValue() != 1) { //modified by Zhou Chao, 2008/7/17
            MessageDialog.showInfoMessageDialog(fApplication, fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Only_Register_ONU_Can_Reset"));
            return;
        }

        // NMS00060620
        String warningTitle = fApplication.getActiveDeviceManager().getGuiComposer().getString("Risky Operation Prompt");
        String warningMessage = fApplication.getActiveDeviceManager().getGuiComposer().getString("Are you sure to do this configuration?");
        
        int confirmResult = JOptionPane.showConfirmDialog(fApplication.getTopMostFrame(),
        		warningMessage,
        		warningTitle,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);
        
        
        if ( confirmResult != JOptionPane.OK_OPTION ) {
            throw new OperationCanceledException("Reset ONU action canceled");
        }

        // Reset the ONU, set utsDot3Onu2CtcReset 1: reset(1)
        Task t = new ResetONUTask(fTable);
        t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
        try {
            Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
            if (!result.booleanValue()) {
                throw new OperationFailedException("Restart Auto Negotiation operation failed");
            }

            // delay 10 seconds to wait for device ready; also according device side requirement.
            fApplication.getTaskManager().executeTask(new DelayTask());

            new RefreshAllCommand(fApplication, fTable).execute();
        } catch (Exception ex) {
            MessageDialog.showOperationFailedDialog(fApplication);
            throw new OperationFailedException("Restart Auto Negotiation operation failed");
        } finally {
            MibBeanIdFormatter idFormatter = fTable.getRowIdFormatter();
            if (idFormatter != null) {
                OperationObject oo = idFormatter.format(bean, tableModel.getRowText(fTable.getSelectedRow()));
                // set operation object to device manager
                OperationObject currentOo = fApplication.getActiveDeviceManager().getOperationObject();
                currentOo.setChassis(oo.getChassis());
                currentOo.setBoard(oo.getBoard());
                currentOo.setPort(oo.getPort());
            }
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

    class ResetONUTask extends Task {

        SnmpTable fTable = null;

        public ResetONUTask(SnmpTable table) {
            fTable = table;
        }

        public Object execute() throws Exception {
            SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
            Dot3Onu2CtcConfigure bean = (Dot3Onu2CtcConfigure) tableModel.getRow(fTable.getSelectedRow());

            return bean.resetONU() ? Boolean.TRUE : Boolean.FALSE;
        }

    }

}
/**
 * Created by Zhou Chao, 2008/10/01
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuSystemConfigureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
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

import java.awt.event.ActionEvent;

/**
 * Reset ONU Action
 */
public class GponResetOnuAction extends SnmpAction {

    public GponResetOnuAction(IApplication anApplication) {
        super(anApplication);
        
        putValue(BaseAction.ID, "Reset_GponOnu");
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {

        int selectedRowCount = fTable.getSelectedRowCount();
        if (selectedRowCount == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

        //if (((GponOnuConfigureMBean) bean).getOnuCfgOperationalState() == null || ((GponOnuConfigureMBean) bean).getOnuCfgOperationalState().intValue() != 1) {
        //    MessageDialog.showInfoMessageDialog(fApplication, fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Only_Enabled_ONT_Can_Reset"));
        //    return;
        //}

        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw new OperationCanceledException("Reset ONT action canceled");
        }

        // Reset the ONU
        Task t = new ResetONUTask(fTable);
        t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
        try {
            Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
            if (!result.booleanValue()) {
                throw new OperationFailedException("Restart Auto Negotiation operation failed");
            }
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

    class ResetONUTask extends Task {

        SnmpTable fTable = null;

        public ResetONUTask(SnmpTable table) {
            fTable = table;
        }

        public Object execute() throws Exception {
            SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
            GponOnuSystemConfigureMBean bean = (GponOnuSystemConfigureMBean) tableModel.getRow(fTable.getSelectedRow());

            return bean.resetONU() ? Boolean.TRUE : Boolean.FALSE;
        }

    }

}
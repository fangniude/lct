/**
 * Created by Zhou Chao, 2010/3/16
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniAttributeTable;
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

import java.awt.event.ActionEvent;

public class RestartAutoNegotiationAction extends SnmpAction {

    public RestartAutoNegotiationAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
        int selectedRowCount = fTable.getSelectedRowCount();
        if (selectedRowCount == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw new OperationCanceledException("Restart Auto Negotiation action canceled");
        }

        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

        // delete the row
        Task t = new RestartAutoNegotiationTask(fTable);
        t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
        try {
            Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
            //MessageDialog.showOperationSucceedDialog(fApplication);

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

}

class RestartAutoNegotiationTask extends Task {

    SnmpTable fTable = null;

    public RestartAutoNegotiationTask(SnmpTable table) {
        fTable = table;
    }

    public Object execute() throws Exception {
        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        try{
	        UniAttributeTable bean = (UniAttributeTable) tableModel.getRow(fTable.getSelectedRow());
	        return bean.restartAutoNeg() ? Boolean.TRUE : Boolean.FALSE;
        }catch(ClassCastException e){
//        	com.winnertel.ems.epon.iad.onu204i_k2.mib.UniAttributeTable bean = (com.winnertel.ems.epon.iad.onu204i_k2.mib.UniAttributeTable) tableModel.getRow(fTable.getSelectedRow());
//	        return bean.restartAutoNeg() ? Boolean.TRUE : Boolean.FALSE;
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

}
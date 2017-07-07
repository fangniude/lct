package com.winnertel.ems.epon.iad.bbs4000.gui.r221.action;

import java.awt.event.ActionEvent;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Olt2PonProtectionMBean;

public class ClosePonProtectionAction extends SnmpAction{
	public ClosePonProtectionAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent arg0) throws Exception {
        //Check the privilege.
//        if(!fApplication.isDebug()) {
//            final ISecurityManager securityManager = fApplication.getSecurityManager();
//            final ISession session = fApplication.getSession();
//            if(!securityManager.isAuthorized(session, "Switch_Board")) {
//                MessageDialog.showPermissionDeniedDialog(fApplication);
//                return;
//            }
//        }

        int selectedRowCount = fTable.getSelectedRowCount();
        if(selectedRowCount == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        if(!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw new OperationCanceledException("User cancel this operation.");
        }

        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        Dot3Olt2PonProtectionMBean bean = (Dot3Olt2PonProtectionMBean) tableModel.getRow(fTable.getSelectedRow());

        try {
            bean.close();

            new RefreshAllCommand(fApplication, fTable).execute();
        } catch(Exception ex) {
//            MessageDialog.showOperationFailedDialog(fApplication);
        	MessageDialog.showErrorMessageDialog(fApplication, fApplication.getActiveDeviceManager().getGuiComposer().getString("Error_Close_Pon_Protection"));
            throw new OperationFailedException("Close operation failed.");
        } finally {
        }
    }
}

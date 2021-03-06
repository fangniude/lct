package com.winnertel.ems.epon.iad.bbs4000.gui.r210.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PONProtectionMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import java.awt.event.ActionEvent;

public class SwitchPonProtectionAction extends SnmpAction {

  public SwitchPonProtectionAction(IApplication anApplication) {
    super(anApplication);
  }

  public void executeAction(ActionEvent arg0) throws Exception {
    //Check the privilege.
    if (!fApplication.isDebug()) {
        final ISecurityManager securityManager = fApplication.getSecurityManager();
        final ISession session = fApplication.getSession();
        if (!securityManager.isAuthorized(session, "Switch_Board")) {
            MessageDialog.showPermissionDeniedDialog(fApplication);
            return;
        }
    }

    int selectedRowCount = fTable.getSelectedRowCount();
    if (selectedRowCount == 0) {
      MessageDialog.showSelectRowDialog(fApplication);
      return;
    }

    if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
      throw new OperationCanceledException("User cancel this operation.");
    }

    SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
    PONProtectionMBean bean = (PONProtectionMBean)tableModel.getRow(fTable.getSelectedRow());

    try {
      bean.switchOver();

      new RefreshAllCommand(fApplication, fTable).execute();
    } catch (Exception ex) {
      MessageDialog.showOperationFailedDialog(fApplication);
      throw new OperationFailedException(  "Switch operation failed." );
    } finally {
    }
  }

}

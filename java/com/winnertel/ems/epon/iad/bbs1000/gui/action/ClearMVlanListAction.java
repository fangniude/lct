package com.winnertel.ems.epon.iad.bbs1000.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcEtherPortTable;

import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 */
public class ClearMVlanListAction extends SnmpAction {
  public ClearMVlanListAction(IApplication anApplication) {
    super(anApplication);
  }

  public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
    int selectedRowCount = fTable.getSelectedRowCount();
    if (selectedRowCount == 0) {
      MessageDialog.showSelectRowDialog(fApplication);
      return;
    }

    if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
      throw new OperationCanceledException("Clear Multicast VLAN List action canceled");
    }

    SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
    SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

    // delete the row
    Task t = new ClearMVlanListTask(fTable);
    t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
    try {
      Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
//            MessageDialog.showOperationSucceedDialog( fApplication );

      if(!result.booleanValue())
      {
        throw new OperationFailedException("Clear Multicast VLAN List operation failed");
      }

      new RefreshAllCommand( fApplication, fTable ).execute();
    } catch (Exception ex) {
      MessageDialog.showOperationFailedDialog(fApplication);
      throw new OperationFailedException("Clear Multicast VLAN List operation failed");
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

class ClearMVlanListTask extends Task {
  SnmpTable fTable = null;

  public ClearMVlanListTask(SnmpTable table) {
    fTable = table;
  }

  public Object execute() throws Exception {
    SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
    Dot3Onu2CtcEtherPortTable bean = (Dot3Onu2CtcEtherPortTable) tableModel.getRow(fTable.getSelectedRow());

    return bean.clearMulticastVlanList() ? Boolean.TRUE : Boolean.FALSE;
  }
}
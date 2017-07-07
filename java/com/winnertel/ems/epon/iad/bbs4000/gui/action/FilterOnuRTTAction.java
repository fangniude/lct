package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.ems.epon.iad.bbs4000.gui.r200.Dot3OnuRTTPanel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.event.ActionEvent;

public class FilterOnuRTTAction extends SnmpAction {
  public FilterOnuRTTAction(IApplication anApplication) {
    super(anApplication);
  }

  public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
    SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
    SnmpMibBean bean = tableModel.getMibBean();

    if(fPanel == null || fPanel instanceof SnmpTablePane) {
      fPanel = new Dot3OnuRTTPanel(fApplication);
    }

    if(fDialog == null) {
      String title = fApplication.getActiveDeviceManager().getGuiComposer().getString("Filter");
      fDialog = new SnmpDialog(fApplication, title, "Modify", "O|C");
      ((SnmpDialog) fDialog).setTable(fTable);
      ((SnmpDialog) fDialog).setPanel(fPanel);
    }

    //use the bean in tableModel directly.
    fPanel.setModel(bean);
    fPanel.refresh();
    fDialog.pack();
    fDialog.show();
  }
}
package com.winnertel.ems.epon.iad.bbs4000.gui.r100.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUpgradeResultTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUpgradeTandRTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.event.ActionEvent;

public class ShowUpgradeResultAction extends SnmpAction {
  public ShowUpgradeResultAction(IApplication anApplication) {
    super(anApplication);
  }

  public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
    //No upgrade task is selected.
    if(fTable.getSelectedRowCount() < 1) return;

    SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
    OnuUpgradeTandRTable bean = (OnuUpgradeTandRTable)tableModel.getRow(fTable.getSelectedRow());

    if(fPanel == null || fPanel instanceof SnmpTablePane) {
      fPanel = fApplication.getActiveDeviceManager().getGuiComposer().composeSnmpTablePane("Onu_Upgrade_Result_Panel");
    }

    OnuUpgradeResultTable result = (OnuUpgradeResultTable)fPanel.getModel();
    result.setOnuUpgradeTaskandResultIndex(bean.getOnuUpgradeTaskandResultIndex());
    result.setOnuUpgradeTaskandResultOnuUpgradeTarget(bean.getOnuUpgradeTaskandResultOnuUpgradeTarget());
    result.setOnuUpgradeTaskandResultOnuUpgradeMethod(bean.getOnuUpgradeTaskandResultOnuUpgradeMethod());

    if(fDialog == null) {
      String title = fApplication.getActiveDeviceManager().getGuiComposer().getString("Upgrade_Result");
      fDialog = new SnmpDialog(fApplication, title, "View", "R|Q");
      ((SnmpDialog) fDialog).setTable(fPanel.getTable());
      ((SnmpDialog) fDialog).setPanel(fPanel);
    }

    fPanel.refresh();
    fDialog.pack();
    fDialog.show();
  }
}
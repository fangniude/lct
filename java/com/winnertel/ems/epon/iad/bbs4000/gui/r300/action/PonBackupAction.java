package com.winnertel.ems.epon.iad.bbs4000.gui.r300.action;

import com.winnertel.ems.epon.iad.bbs4000.gui.r300.PonBackupMBeanPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Olt2PortTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.PonBackupMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.event.ActionEvent;

public class PonBackupAction extends SnmpAction {
    public PonBackupAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        if(fTable.getSelectedRow() == -1) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        Dot3Olt2PortTable bean = (Dot3Olt2PortTable)tableModel.getRow(fTable.getSelectedRow());

        if (fPanel == null || fPanel instanceof SnmpTablePane) {
            fPanel = new PonBackupMBeanPanel(fApplication);
            fPanel.setModel(new PonBackupMBean(fApplication.getSnmpProxy()));
        }

        PonBackupMBean backup = (PonBackupMBean)fPanel.getModel();
        backup.setUtsSrcPonModuleId(bean.getUtsDot3OltModuleId());
        backup.setUtsSrcPonPortId(bean.getUtsDot3OltPortId());

        if (fDialog == null) {
            String title = fApplication.getActiveDeviceManager().getGuiComposer().getString("Backup Port");
            fDialog = new SnmpDialog(fApplication, title, "Modify", "O|C");
            ((SnmpDialog) fDialog).setPanel(fPanel);
        }

        fPanel.refresh();
        fDialog.pack();
        fDialog.show();
    }
}
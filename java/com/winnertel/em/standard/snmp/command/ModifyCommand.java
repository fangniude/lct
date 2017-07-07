package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

public class ModifyCommand extends SnmpTableCommand {
    private ILogger fLogger = LoggerController.createLogger(ModifyCommand.class);

    private UPanel fPanel = null;

    private UDialog fDialog = null;


    public ModifyCommand(IApplication aApplication, SnmpTable aTable) {
        super(aApplication, aTable);
    }


    public void setPanel(UPanel aPanel) {
        fPanel = aPanel;
    }

    public void setDialog(UDialog aDialog) {
        fDialog = aDialog;
    }


    public boolean execute() {
        int selectedRow = fTable.getSelectedRow();
        if (selectedRow == -1) {
            MessageDialog.showSelectRowDialog(fApplication);
            return false;
        }

        // no panel for modify command, just return
        if (fPanel == null && fDialog == null) {
            fLogger.debug("No panel or dialog found for modify command");
            return false;
        }

        if (fDialog != null) {
            if (fDialog instanceof SnmpDialog) {
                SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
                SnmpMibBean bean = (SnmpMibBean) tableModel.getRow(selectedRow).clone();
                SnmpDialog dlg = (SnmpDialog) fDialog;
                dlg.setMask(SnmpDialog.STYLE_REFRESH, true);
                dlg.getPanel().setModel(bean);
                dlg.getPanel().setTable(fTable);
                dlg.getPanel().refresh();
            }
            fDialog.pack();
            fDialog.show();
        }

        return true;
    }
}

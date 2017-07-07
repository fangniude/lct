package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTable;

public class AddCommand extends SnmpTableCommand {
    private ILogger fLogger = LoggerController.createLogger(AddCommand.class);

    private UPanel fPanel = null;

    private UDialog fDialog = null;


    public AddCommand(IApplication aApplication, SnmpTable aTable) {
        super(aApplication, aTable);
    }


    public void setPanel(UPanel aPanel) {
        fPanel = aPanel;
    }

    public void setDialog(UDialog aDialog) {
        fDialog = aDialog;
    }


    public boolean execute() {
        // no panel for add command, just return
        if (fPanel == null && fDialog == null) {
            fLogger.debug("No panel or dialog found for add command");
            return false;
        }

        if (fDialog != null) {
            if (fDialog instanceof SnmpDialog) {
                SnmpDialog dlg = (SnmpDialog) fDialog;
                dlg.setMask(SnmpDialog.STYLE_REFRESH, false);
                dlg.getPanel().setTable(fTable);
                dlg.getPanel().refresh();
            }
            fDialog.pack();
            fDialog.show();
        }

        return true;
    }
}

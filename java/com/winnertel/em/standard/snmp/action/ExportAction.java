package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.snmp.command.ExportCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTable;

import java.awt.event.ActionEvent;

public class ExportAction extends SnmpAction {

    public ExportAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fTable == null || fTable.getRowCount() == 0) {
            return;
        }
        if (fCommand != null) {
            fCommand.execute();
        }
    }

    public void setTable(SnmpTable aTable) {
        super.setTable(aTable);
        fCommand = new ExportCommand(fApplication, fTable);
    }

}

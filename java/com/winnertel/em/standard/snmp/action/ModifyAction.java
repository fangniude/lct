package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.snmp.command.ModifyCommand;

import java.awt.event.ActionEvent;

public class ModifyAction extends SnmpAction {
    public ModifyAction(IApplication anApplication) {
        super(anApplication);
    }


    public void executeAction(ActionEvent e) {
        ModifyCommand cmd = new ModifyCommand(fApplication, fTable);
        cmd.setPanel(fPanel);
        cmd.setDialog(fDialog);
        cmd.execute();
    }
}

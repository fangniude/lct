package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.snmp.command.AddCommand;

import java.awt.event.ActionEvent;

public class AddAction extends SnmpAction {
    public AddAction(IApplication anApplication) {
        super(anApplication);
    }


    public void executeAction(ActionEvent e) {
        AddCommand cmd = new AddCommand(fApplication, fTable);
        cmd.setPanel(fPanel);
        cmd.setDialog(fDialog);
        cmd.execute();
    }
}

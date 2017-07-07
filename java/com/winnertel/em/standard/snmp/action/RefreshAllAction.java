package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;

import java.awt.event.ActionEvent;

public class RefreshAllAction extends SnmpAction {
    public RefreshAllAction(IApplication anApplication) {
        super(anApplication);
    }


    public void executeAction(ActionEvent e) {
        new RefreshAllCommand(fApplication, fTable).execute();
    }
}


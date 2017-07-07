package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.OKAction;
import com.winnertel.em.standard.snmp.action.SnmpAction;

import javax.swing.*;

public class SnmpOKButton extends JButton {
    private IApplication fApplication = null;

    public SnmpOKButton(IApplication anApplication, UPanel aPanel) {
        fApplication = anApplication;
        OKAction action = new OKAction(anApplication);
        action.putValue(Action.NAME, fApplication.getGlobalStringMap().getString("OK"));
        action.putValue(SnmpAction.COMMAND, SnmpAction.IType.MODIFY);
        action.setPanel(aPanel);
        setAction(action);
    }
}

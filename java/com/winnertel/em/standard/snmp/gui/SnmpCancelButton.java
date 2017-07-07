package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.CloseAction;

import javax.swing.*;

public class SnmpCancelButton extends JButton {
    private IApplication fApplication = null;

    public SnmpCancelButton(IApplication anApplication, UPanel aPanel) {
        fApplication = anApplication;
        CloseAction action = new CloseAction(anApplication);
        action.setPanel(aPanel);
        setAction(action);
        setText(fApplication.getGlobalStringMap().getString("Cancel"));
    }
}

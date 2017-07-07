package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.RefreshAction;

import javax.swing.*;

public class SnmpRefreshButton extends JButton {
    private IApplication fApplication = null;


    public SnmpRefreshButton(IApplication anApplication, UPanel aPanel) {
        fApplication = anApplication;
        RefreshAction action = new RefreshAction(anApplication, aPanel);
        action.putValue(Action.NAME, fApplication.getGlobalStringMap().getString("Refresh"));
        setAction(action);
    }
}


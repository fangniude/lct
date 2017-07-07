package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.ApplyAction;
import com.winnertel.em.standard.snmp.action.SnmpAction;

import javax.swing.*;

public class SnmpApplyButton extends JButton {
    private IApplication fApplication = null;

    public SnmpApplyButton(IApplication anApplication, UPanel aPanel) {
        this(anApplication, aPanel, null);
    }

    public SnmpApplyButton(IApplication anApplication, UPanel aPanel, String actionId) {
        fApplication = anApplication;
        ApplyAction action = new ApplyAction(anApplication);
        action.putValue(Action.NAME, fApplication.getGlobalStringMap().getString("Apply"));
        action.putValue(SnmpAction.COMMAND, SnmpAction.IType.MODIFY);
        if (actionId != null) {
            action.putValue(BaseAction.ID, actionId);
        }
        action.setPanel(aPanel);
        setAction(action);
    }
}

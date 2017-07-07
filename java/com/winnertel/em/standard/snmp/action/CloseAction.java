package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.GuiUtil;

import java.awt.event.ActionEvent;

public class CloseAction extends SnmpAction {

    public CloseAction(IApplication anApplication) {
        super(anApplication);
        putValue(NAME, fApplication.getGlobalStringMap().getString("Close"));
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fPanel == null) {
            return;
        }
        GuiUtil.getParentDialog(fPanel).dispose();
    }
}

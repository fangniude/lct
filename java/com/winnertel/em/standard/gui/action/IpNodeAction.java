package com.winnertel.em.standard.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;

import java.awt.event.ActionEvent;

public class IpNodeAction extends BaseAction {
    public IpNodeAction(IApplication anApplication) {
        super(anApplication);
    }


    public void executeAction(ActionEvent e) {
        if (fApplication.getActiveDeviceManager() != null) {
            fApplication.getMainApplet().setActiveDeviceManager(null);
        }
    }
}

package com.winnertel.ems.epon.iad.framework.gui.shelfview.action;

import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.IApplication;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.ShelfView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RefreshChassisAction extends AbstractAction {
    IApplication fApplication;

    
    public RefreshChassisAction(IApplication anApplication) {
        fApplication = anApplication;
        putValue(NAME, fApplication.getActiveDeviceManager().getGuiComposer().getString("Refresh"));
    }

    public void actionPerformed(ActionEvent e) {
        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
            return;

        ShelfView shelfView = (ShelfView)fApplication.getActiveDeviceManager().getProperties().get("ShelfView");

        if(shelfView != null) {
            shelfView.refresh();
        }

        MessageDialog.showOperationSucceedDialog(fApplication);
    }
}
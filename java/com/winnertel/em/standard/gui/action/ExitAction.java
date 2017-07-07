package com.winnertel.em.standard.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.nms.lite.LiteContext;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class ExitAction extends BaseAction {
    public ExitAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) {
        // simulate user click on "X"(close) button
        fApplication.getTopMostFrame().dispatchEvent(
                new WindowEvent(fApplication.getTopMostFrame(), WindowEvent.WINDOW_CLOSING));

        if (!LiteContext.isLCTModel() && fApplication.isDebug()) {
            System.exit(0);
        }
    }
}

package com.winnertel.em.standard.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.nms.helpsys.HelpUtilityHolder;

import java.awt.event.ActionEvent;


public class HelpAction extends BaseAction {
    private String fHelpId;


    public HelpAction(IApplication anApplication, String aHelpIdArray[]) {
        this(anApplication, aHelpIdArray[0]);
    }

    public HelpAction(IApplication anApplication, String aHelpId) {
        super(anApplication);

        if (aHelpId == null || aHelpId.length() == 0) {
            throw new IllegalArgumentException("Help ID should not be null or empty string");
        }
        fHelpId = aHelpId;
    }


    public void executeAction(ActionEvent e) throws Exception {
        HelpUtilityHolder.openHelpDocument(
                fApplication.getMainApplet().getEditorDialog().getGui(),
                fHelpId);
    }
}

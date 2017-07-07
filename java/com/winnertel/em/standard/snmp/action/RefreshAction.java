package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.command.RefreshCommand;

import java.awt.event.ActionEvent;

public class RefreshAction extends SnmpAction {
    private ILogger fLogger = LoggerController.createLogger(RefreshAction.class);

    private UPanel fPanel = null;


    public RefreshAction(IApplication anApplication, UPanel aPanel) {
        super(anApplication);
        fPanel = aPanel;
    }


    public void executeAction(ActionEvent e) {
        if (fCommand != null) {
            try {
                fCommand.execute();
            } catch (Exception ex) {
                fLogger.debug("Error in execute refresh command", ex);
            }
        } else {
            new RefreshCommand(fApplication, fPanel).execute();
        }
    }
}

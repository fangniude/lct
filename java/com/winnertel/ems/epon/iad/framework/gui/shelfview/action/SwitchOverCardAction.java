package com.winnertel.ems.epon.iad.framework.gui.shelfview.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.task.ModifyTask;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.BoardTable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchOverCardAction extends BaseAction {

    public SwitchOverCardAction(IApplication anApplication) {
        super(anApplication);
        putValue(BaseAction.ID, "Restart_NE");
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
            return;


        String msg1 = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Cfm_Reset_Card_1");
        String msg2 = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Cfm_Reset_Card_2");
        String warningTitle = fApplication.getActiveDeviceManager().getGuiComposer().getString("Risky Operation Prompt");

        int result = JOptionPane.showConfirmDialog(fApplication.getTopMostFrame(), msg1 + "\r\n" + msg2, warningTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (JOptionPane.OK_OPTION == result) {
            BoardTable bean = new BoardTable(fApplication.getSnmpProxy());
            bean.setAction(2); //3- switch over.

            Task t = new ModifyTask(bean);
            t.setCancelable(false);

            try {
                Object o = fApplication.getTaskManager().executeTask(t);

                //NE doesn't return the result to EMS. So if no exception is thrown, show the success message to user.
                MessageDialog.showOperationSucceedDialog(fApplication);
            } catch (Exception ex) {
                MessageDialog.showOperationFailedDialog(fApplication);
            }
        }
    }

}
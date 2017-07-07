package com.winnertel.ems.epon.iad.eoc.gui.action;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATDevStatusGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;

import java.awt.event.ActionEvent;

public class ResetAction extends BaseAction {

    public ResetAction(IApplication anApplication) {
        super(anApplication);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void executeAction(ActionEvent e) throws Exception {
        // TODO Auto-generated method stub
        try {
            if (MessageDialog.showConfirmOperationDialog(fApplication)) {
                fApplication.getTaskManager().executeTask(new Task() {

                    public Object execute() throws Exception {
                        ModEoCCBATDevStatusGroup resetBean = new ModEoCCBATDevStatusGroup(fApplication.getSnmpProxy());
                        resetBean.resetCBat();
                        return null;
                    }
                });
            }
        } catch (Exception e1) {
            MessageDialog.showOperationFailedDialog(fApplication);
            e1.printStackTrace();
        }
    }

}

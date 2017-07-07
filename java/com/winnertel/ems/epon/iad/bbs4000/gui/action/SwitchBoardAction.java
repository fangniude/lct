package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.task.ModifyTask;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: hz03842
 * Date: 2007-4-8
 * Time: 13:48:28
 * To change this template use File | Settings | File Templates.
 * <p/>
 * Modified by Zhou Chao
 */
public class SwitchBoardAction extends BaseAction {

    public SwitchBoardAction(IApplication anApplication) {
        super(anApplication);
        putValue(BaseAction.ID, "Switch_Board");
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
            return;

        //Check the privilege.
        if (!fApplication.isDebug()) {
            final ISecurityManager securityManager = fApplication.getSecurityManager();
            final ISession session = fApplication.getSession();
            if (!securityManager.isAuthorized(session, "Switch_Board")) {
                MessageDialog.showPermissionDeniedDialog(fApplication);
                return;
            }
        }

        BBS4000CardMibBean bean1 = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        bean1.setUtsEponModuleBoardPhyId(13);
        bean1.retrieve();
        Integer installed1 = bean1.getUtsEponModulePhyPresenceStat();
        Integer active1 = bean1.getUtsEponModuleRedundancyState();

        BBS4000CardMibBean bean2 = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        bean2.setUtsEponModuleBoardPhyId(14);
        bean2.retrieve();
        Integer installed2 = bean2.getUtsEponModulePhyPresenceStat();
        Integer active2 = bean2.getUtsEponModuleRedundancyState();

        if ((installed1 == null || installed1 != 1) || (installed2 == null || installed2 != 1)) {
            String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_can_not_switch");
            MessageDialog.showInfoMessageDialog(fApplication, msg);
            throw new OperationFailedException(fApplication.getSession().getUser() + " failed to switch CSM board.");
        } else if (active1 != null && active1 == 2) {
            bean1.setUtsEponModuleAdminState(8); //8-reset
            switchBoard(bean1);
        } else if (active2 != null && active2 == 2) {
            bean2.setUtsEponModuleAdminState(8); //8-reset
            switchBoard(bean2);
        } else {
            //String msg = "����CSM����inactive!";
            //MessageDialog.showInfoMessageDialog(fApplication, msg);
            //return;
        }
    }

    private void switchBoard(BBS4000CardMibBean bean) throws Exception {
        String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_cfm_switch");
        if (JOptionPane.OK_OPTION == MessageDialog.showConfirmDialog(fApplication, msg)) {
            Task t = new ModifyTask(bean);
            try {
                Object o = fApplication.getTaskManager().executeTask(t);
                if (Boolean.TRUE == o) {
                    MessageDialog.showOperationSucceedDialog(fApplication);
                } else {
                    MessageDialog.showOperationFailedDialog(fApplication);
                    throw new OperationFailedException(fApplication.getSession().getUser() + " failed to switch CSM board.");
                }
            } catch (Exception ex) {
                MessageDialog.showOperationFailedDialog(fApplication);
                throw new OperationFailedException(fApplication.getSession().getUser() + " failed to switch CSM board.");
            }
        } else {
            throw new OperationCanceledException(fApplication.getSession().getUser() + " canceled the operation.");
        }
    }

}
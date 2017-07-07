/**
 * Created by Zhou Chao, 2010/5/7
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniMacAddressManagementNode;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;

import java.awt.event.ActionEvent;

/**
 * Clear All Dynamic MAC Address Action
 */
public class ClearDynamicMacAction extends SnmpAction {

    public ClearDynamicMacAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
        if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
            throw new OperationCanceledException("Clear all dynamic MAC address action canceled");
        }

        // Clear all dynamic MAC address, set uniMacAddrClear 1: clear(1)
        UniMacAddressManagementNode bean = null;
        try {
            bean = new UniMacAddressManagementNode(fApplication.getSnmpProxy());
            bean.clearDynamicMacAddress();

//            Task t = new ModifyTask(bean);
//            t.setCancelable(false);
//
//            t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
//
//            Boolean result = (Boolean) fApplication.getTaskManager().executeTask(t);
//            if (!result) {
//                throw new OperationFailedException("Clear all dynamic MAC address operation failed");
//            }

            new RefreshAllCommand(fApplication, fTable).execute();
        } catch (Exception ex) {
            MessageDialog.showOperationFailedDialog(fApplication);
            throw new OperationFailedException("Clear all dynamic MAC address operation failed");
        }
    }

}
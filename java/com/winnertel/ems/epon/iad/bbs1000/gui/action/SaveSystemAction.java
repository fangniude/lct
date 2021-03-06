package com.winnertel.ems.epon.iad.bbs1000.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.task.ModifyTask;
import com.winnertel.ems.epon.iad.bbs4000.mib.SystemAdministrationBean;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveSystemAction extends BaseAction
{
  public SaveSystemAction(IApplication anApplication)
  {
    super(anApplication);
  }

  public void executeAction(ActionEvent e)
  {
    //Check the privilege.
    if (!fApplication.isDebug()) {
      final ISecurityManager securityManager = fApplication.getSecurityManager();
      final ISession session = fApplication.getSession();
      if ( !securityManager.isAuthorized( session, "SystemBootGroupMOD_Save" ) ) {
            MessageDialog.showPermissionDeniedDialog( fApplication );
          return;
      }
    }

    String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Cfm_Save_Cfg");
    if(JOptionPane.OK_OPTION == MessageDialog.showConfirmDialog(fApplication, msg))
    {
      SystemAdministrationBean bean = new SystemAdministrationBean(fApplication.getSnmpProxy());
      bean.setUtsBBSSaveRunningConfigure(new Integer(3)); //3- save the system configuration.

      Task t = new ModifyTask(bean);
      t.setCancelable(false);
      
      try
      {
        Object o = fApplication.getTaskManager().executeTask(t);
        if(Boolean.TRUE ==o)
        {
          MessageDialog.showOperationSucceedDialog(fApplication);
        }
        else
        {
          MessageDialog.showOperationFailedDialog(fApplication);
        }
      }
      catch(Exception ex)
      {
        MessageDialog.showOperationFailedDialog(fApplication);
      }
    }
  }
}

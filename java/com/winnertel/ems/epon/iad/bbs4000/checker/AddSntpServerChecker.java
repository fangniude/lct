package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-29
 * Time: 10:54:32
 * To change this template use File | Settings | File Templates.
 */
public class AddSntpServerChecker extends BaseChecker {

  public AddSntpServerChecker(IApplication app) {
    super(app);
  }

  public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
    if (data != null && data.length > 2) {
      String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_More_3_SNTP_Server");
      MessageDialog.showErrorMessageDialog(fApplication, error);

      return false;
    }

    return true;
  }
}

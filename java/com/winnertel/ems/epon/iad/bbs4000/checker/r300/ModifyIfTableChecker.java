package com.winnertel.ems.epon.iad.bbs4000.checker.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.InterfaceTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class ModifyIfTableChecker extends BaseChecker {
  public ModifyIfTableChecker(IApplication app) {
    super(app);
  }

  public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
    String error = "";
    InterfaceTableMBean mbean = (InterfaceTableMBean) selectedMibBeans[0];

    if(mbean.getIfDescr() != null && mbean.getIfDescr().startsWith("EPM")) {
      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Modify_EPM");
      MessageDialog.showErrorMessageDialog(getApplication(), error);
      return false;
    }

    return true;
  }
}

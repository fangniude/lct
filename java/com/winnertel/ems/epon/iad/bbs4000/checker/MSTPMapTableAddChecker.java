package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.MSTPGeneralMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class MSTPMapTableAddChecker extends BaseChecker {

  public MSTPMapTableAddChecker(IApplication app) {
    super(app);
  }

  public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
    MSTPGeneralMBean mbean = new MSTPGeneralMBean(fApplication.getSnmpProxy());
    try {
      mbean.retrieve();

      if (mbean.getMstpGenForceVersion().intValue() == 0) {
        String err = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Add_MSTP");
        MessageDialog.showInfoMessageDialog(fApplication, err);
        return false;
      }
    } catch (Exception e) {
    }

    return true;
  }
}

package com.winnertel.ems.epon.iad.bbs4000.checker.r200;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class BoundMultiOnuChecker extends BaseChecker {

    private IApplication fApplication;
    public BoundMultiOnuChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    @Override
    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {

        if(selectedMibBeans.length > 1) {
            String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Bound_One_ONU_Once_Time");
            MessageDialog.showInfoMessageDialog(fApplication, msg);
            return false;
        }

        return true;
    }
}

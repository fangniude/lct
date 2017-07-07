package com.winnertel.ems.epon.iad.bbs4000.checker.r216;

import com.winnertel.ems.epon.iad.bbs4000.mib.r216.EponArpTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-10-10
 * Time: 14:12:39
 * To change this template use File | Settings | File Templates.
 */
public class DeleteARPChecker extends BaseChecker  {
    IApplication fApplication;
    public DeleteARPChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        EponArpTable one = (EponArpTable)selectedMibBeans[0];
        String error = "";
        if(one.getUtsEponArpItemType().intValue() != 1){
            error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Only_For_Static_Entry");
            MessageDialog.showErrorMessageDialog(getApplication(), error);
            return false;
        }
        return true;
    }
}

package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.HostRouteTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-10-10
 * Time: 13:59:11
 * To change this template use File | Settings | File Templates.
 */
public class DeleteHostRouteChecker extends BaseChecker  {
    IApplication fApplication;
    public DeleteHostRouteChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        HostRouteTable one = (HostRouteTable)selectedMibBeans[0];
        String error = "";
        if(one.getUtsHostRouteArpType().intValue() != 4){
            error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Only_For_Static_Entry");
            MessageDialog.showErrorMessageDialog(getApplication(), error);
            return false;
        }
        return true;
    }
}

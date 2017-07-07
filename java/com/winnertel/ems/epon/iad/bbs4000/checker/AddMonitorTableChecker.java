package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-27
 * Time: 16:48:59
 * To change this template use File | Settings | File Templates.
 */
public class AddMonitorTableChecker   extends BaseChecker  {
    public AddMonitorTableChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        String error = "";
        if(data.length>=4){
            error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_More_4_Items");
            MessageDialog.showErrorMessageDialog(getApplication(), error);
            return false;
        }


        return true;
    }
}

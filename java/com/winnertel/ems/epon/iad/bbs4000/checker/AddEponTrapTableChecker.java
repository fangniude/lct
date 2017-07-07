package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-26
 * Time: 10:48:16
 * To change this template use File | Settings | File Templates.
 */
public class AddEponTrapTableChecker   extends BaseChecker  {
    public AddEponTrapTableChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        String error = "";
        if(data.length>=5){
            error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_More_5_Items");
            MessageDialog.showErrorMessageDialog(getApplication(), error);
            return false;
        }


        return true;
    }
}

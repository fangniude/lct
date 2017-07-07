package com.winnertel.ems.epon.iad.eoc.checker;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATCardTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class ResetModEoCCBATCardTableChecker extends BaseChecker {
    public ResetModEoCCBATCardTableChecker(IApplication app) {
        super(app);
    }

    @Override
    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        // TODO Auto-generated method stub
        String infoMessage = fApplication.getActiveDeviceManager().getGuiComposer().getString("Info_Reset_ModEoCCBATCard");
        if (selectedMibBeans.length != 0) {
            ModEoCCBATCardTable mbean = (ModEoCCBATCardTable) selectedMibBeans[0];
            if (!"0".equals(mbean.getModEoCCBATCardIndex().toString())) {
                MessageDialog.showInfoMessageDialog(getApplication(), infoMessage);
                return false;
            }
            return true;
        }
        return true;
    }
}

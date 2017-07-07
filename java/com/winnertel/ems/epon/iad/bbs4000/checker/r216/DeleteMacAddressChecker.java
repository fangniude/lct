package com.winnertel.ems.epon.iad.bbs4000.checker.r216;

import com.winnertel.ems.epon.iad.bbs4000.mib.r216.MACAddressTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * TODO: add function declaration here
 *
 * @author ZhouTao(zhoutao@utstar.com)
 * @version 1.0.0, 2006-10-25
 */
public class DeleteMacAddressChecker extends BaseChecker {

    IApplication fApplication;

    public DeleteMacAddressChecker(IApplication app) {
        super(app);
        this.fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        MACAddressTable mbean = (MACAddressTable) selectedMibBeans[0];

        Integer intfType = mbean.getUtsLagExtLinkAggMacIntfType();

        if (intfType.intValue() == 3) {
            String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Delete_CPU_MAC");
            MessageDialog.showInfoMessageDialog(fApplication, error);
            return false;
        }

        return true;
    }
}

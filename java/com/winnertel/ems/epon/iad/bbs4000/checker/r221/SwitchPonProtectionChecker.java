package com.winnertel.ems.epon.iad.bbs4000.checker.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Olt2PonProtectionMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class SwitchPonProtectionChecker extends BaseChecker {
    IApplication fApplication;

    public SwitchPonProtectionChecker(IApplication app) {
        super(app);
        this.fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
    	Dot3Olt2PonProtectionMBean mbean = (Dot3Olt2PonProtectionMBean) selectedMibBeans[0];

//        if(mbean.getUtsPonTrunckProtectionRowStatus() == 2) {
//            String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Pon_Is_Not_Protected");
//            MessageDialog.showInfoMessageDialog(fApplication, error);
//            return false;
//        }

        return true;
    }
}

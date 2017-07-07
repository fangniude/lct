package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolDefaultRouterTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.util.BeanService;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-10-9
 * Time: 14:28:26
 * To change this template use File | Settings | File Templates.
 */
public class AddDHCPDefaultTouterChecker   extends BaseChecker  {

    private IApplication fApplication;
    public AddDHCPDefaultTouterChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        DHCPPoolTable mbean = new DHCPPoolTable(fApplication.getSnmpProxy());
        DHCPPoolDefaultRouterTable thismbean = new DHCPPoolDefaultRouterTable(fApplication.getSnmpProxy());

        Vector v = BeanService.refreshTableBean(fApplication, mbean);
        Vector thisv = BeanService.refreshTableBean(fApplication, thismbean);
        if (v != null && thisv != null) {
                if (v.size() == thisv.size()){
                    String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Only_1_Default_Router");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
         }
        return true;
    }
}

package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPRelayServerTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.util.BeanService;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-11-2
 * Time: 15:10:51
 * To change this template use File | Settings | File Templates.
 */
public class AddDHCPRelayServerChecker extends BaseChecker {

    private IApplication fApplication;

    public AddDHCPRelayServerChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        EthIfExtTable tablembean = new EthIfExtTable(fApplication.getSnmpProxy());
        DHCPRelayServerTable servermbean = new DHCPRelayServerTable(fApplication.getSnmpProxy());
        Vector tablev = BeanService.refreshTableBean(fApplication, tablembean);
        Vector serverv = BeanService.refreshTableBean(fApplication, servermbean);
        if (tablev == null) {
            String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_No_VLAN_Interface");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }
        int count = 0;
        for (int i = 0; i < tablev.size(); i++) {
            EthIfExtTable one = (EthIfExtTable) tablev.get(i);
            String index = ConfigUtility.formatIfIndex(one.getIfIndex().toString());
            if (index.length() >= 4) {
                if (index.substring(0, 4).compareToIgnoreCase("vlan") == 0) {
                    count++;
                }
            }
        }
        if (count == serverv.size()) {
            String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_No_VLAN_Interface");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }
        return true;
    }
}

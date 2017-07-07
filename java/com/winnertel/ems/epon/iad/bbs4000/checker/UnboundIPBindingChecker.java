package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPIPBindingStatusTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-10-9
 * Time: 16:37:59
 * To change this template use File | Settings | File Templates.
 */
public class UnboundIPBindingChecker extends BaseChecker  {
    public UnboundIPBindingChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        String error = "";
        DHCPIPBindingStatusTableMBean mbean = (DHCPIPBindingStatusTableMBean) selectedMibBeans[0];
        int state = mbean.getUtsIpDHCPPoolBindingState().intValue();
        if(state !=4 ){
            error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Unbound_Not_Bind_Onu");
            MessageDialog.showErrorMessageDialog(getApplication(), error);
            return false;
        }

        return true;
    }
}

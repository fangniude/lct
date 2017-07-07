package com.winnertel.ems.epon.iad.bbs4000.checker.r300;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.InterfaceTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class ModifyIfConfChecker extends BaseChecker  {
    public ModifyIfConfChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        String error = "";
        InterfaceTableMBean mbean = (InterfaceTableMBean) selectedMibBeans[0];
        String index = ConfigUtility.formatIfIndex("" + mbean.getIfIndex());
//        if(index.indexOf("lg")!=-1){
//            error = "The update operation is not allowed for Link Aggregation.";
//            MessageDialog.showErrorMessageDialog(getApplication(), error);
//            return false;
//        }

        int index1 = index.indexOf('/');
        if(index1!=-1){
            int index2 = index.indexOf('/',index1+1);
            if(index2!=-1&&index.indexOf('/',index2+1)!=-1){
                if(mbean.getIfAdminStatus().intValue() == 1&&
                     mbean.getIfOperStatus().intValue() == 2){
                     error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Modify_Unregistered_Onu");
                    MessageDialog.showErrorMessageDialog(getApplication(), error);
                    return false;
                }
            }
        }
        return true;
    }
}

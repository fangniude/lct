package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontVPortBindProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVPorSvcProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.util.BeanService;

import javax.swing.*;
import java.util.Vector;

public class OnuVPorSvcProfChecker extends BaseChecker {

    public OnuVPorSvcProfChecker(IApplication app) {
        super(app);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        if (selectedMibBeans == null || selectedMibBeans.length == 0) return true;
        String error = "";
        OnuVPorSvcProfTable mbean = (OnuVPorSvcProfTable) selectedMibBeans[0];

        if (mbean.getVirtualPortServiceProfileIndex() != null && mbean.getVirtualPortServiceProfileIndex() == 1) {
            error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
            MessageDialog.showErrorMessageDialog(getApplication(), error);
            return false;
        }

        SnmpMibBean onuTcontVPortBindProf_beans = new OnuTcontVPortBindProfTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, onuTcontVPortBindProf_beans);
        for (int i = 0; i < v.size(); i++) {
            OnuTcontVPortBindProfTable onuTcontVPortBindProf_bean = (OnuTcontVPortBindProfTable) v.get(i);
            if (onuTcontVPortBindProf_bean.getVirtualPortServicePr().equals(mbean.getVirtualPortServiceProfileIndex())) {
//	                   error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_TcontSvcProf_Used_In_OnuTcontVPortBindProf");
//	                   MessageDialog.showErrorMessageDialog(getApplication(), error);
//	                   return false;
                String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Cfm_Profile_Is_Used");
                int result = MessageDialog.showConfirmDialog(fApplication, msg);

                if (result != JOptionPane.YES_OPTION) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        return true;
    }

}

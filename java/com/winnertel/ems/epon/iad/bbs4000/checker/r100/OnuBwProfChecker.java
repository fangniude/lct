package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuBwProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontSvcProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVPorSvcProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.util.BeanService;

import javax.swing.*;
import java.util.Vector;

public class OnuBwProfChecker extends BaseChecker {

    public OnuBwProfChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        if (selectedMibBeans == null || selectedMibBeans.length == 0) return true;
        String error = "";
        OnuBwProfTable mbean = (OnuBwProfTable) selectedMibBeans[0];

        if (mbean.getBandwidthProfileIndex() != null && mbean.getBandwidthProfileIndex() == 1) {
            error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
            MessageDialog.showErrorMessageDialog(getApplication(), error);
            return false;
        }

        boolean used = false;
        SnmpMibBean onuTcontSvcProf_beans = new OnuTcontSvcProfTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, onuTcontSvcProf_beans);
        for (int i = 0; i < v.size(); i++) {
            OnuTcontSvcProfTable onuTcontSvcProf_bean = (OnuTcontSvcProfTable) v.get(i);
            if (onuTcontSvcProf_bean.getUpstreamBandwidthProfileIndex().equals(mbean.getBandwidthProfileIndex())) {
                used = true;
                break;
//                   error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_BwProf_Used_In_TcontSvcProf");
//                   MessageDialog.showErrorMessageDialog(getApplication(), error);
//                   return false;
            }
        }

        if (!used) {
            SnmpMibBean onuVPorSvcProf_beans = new OnuVPorSvcProfTable(fApplication.getSnmpProxy());
            Vector v2 = BeanService.refreshTableBean(fApplication, onuVPorSvcProf_beans);
            for (int i = 0; i < v2.size(); i++) {
                OnuVPorSvcProfTable onuVPorSvcProf_bean = (OnuVPorSvcProfTable) v2.get(i);
                if (onuVPorSvcProf_bean.getDownstreamBandwidthProfileIndex().equals(mbean.getBandwidthProfileIndex())) {
                    used = true;
                    break;
//                   error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_BwProf_Used_In_VPorSvcProf_DownBW");
//                   MessageDialog.showErrorMessageDialog(getApplication(), error);
//                   return false;
                }
                if (onuVPorSvcProf_bean.getOnuVPortSvcProfUpstreamBandwidthProfileIndex().equals(mbean.getBandwidthProfileIndex())) {
                    used = true;
                    break;
//                    error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_BwProf_Used_In_VPorSvcProf_UpBW");
//                    MessageDialog.showErrorMessageDialog(getApplication(), error);
//                    return false;
                }
            }
        }

        if (used) {
            String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Cfm_Profile_Is_Used");
            int result = MessageDialog.showConfirmDialog(fApplication, msg);

            if (result != JOptionPane.YES_OPTION) {
                return false;
            }
        }

        return true;
    }
}

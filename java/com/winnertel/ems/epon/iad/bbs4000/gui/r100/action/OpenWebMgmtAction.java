/**
 * Created by Zhou Chao, 2009/3/3
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuNetworkConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuSystemConfigureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Vector;

public class OpenWebMgmtAction extends SnmpAction {

    public OpenWebMgmtAction(IApplication anApplication) {
        super(anApplication);
        putValue(BaseAction.ID, "OpenWebMgmt");
    }

    public void executeAction(ActionEvent e) {
        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        int selectedRow = fTable.getSelectedRow();
        if (selectedRow < 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }
        SnmpMibBean bean = tableModel.getRow(selectedRow);
        if (bean instanceof GponOnuSystemConfigureMBean) {
            /*
            if (((GponOnuSystemConfigureMBean) bean).getOnuCfgOnuHardwareType() != 2 && ((GponOnuSystemConfigureMBean) bean).getOnuCfgOnuHardwareType() != 4) { //is not ONT408t, ONT404t
                MessageDialog.showInfoMessageDialog(fApplication, fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_Only_For_ONT408t_ONT404t"));
                return;
            }
            */

            String ipAddr = ((GponOnuSystemConfigureMBean) bean).getOnuCfgOnuIPAddress();
            if (ipAddr == null || ipAddr.trim().length() <= 0) {
                int slot = ((GponOnuSystemConfigureMBean) bean).getOnuCfgSlotNo();
                int port = ((GponOnuSystemConfigureMBean) bean).getOnuCfgPortNo();
                int ont = ((GponOnuSystemConfigureMBean) bean).getOnuCfgLogicalPortNo();

                GponOnuNetworkConfigureMBean mbean = new GponOnuNetworkConfigureMBean(fApplication.getSnmpProxy());
                String index = slot + "." + port;
                mbean.setOnuCfgSlotNo(slot);
                mbean.setOnuCfgPortNo(port);
                if (ont > 0)
                    mbean.setOnuCfgLogicalPortNo(ont - 1);
                else
                    mbean.setOnuCfgLogicalPortNo(0);
                mbean.setIndexPrefix(index);
                mbean.setRowsToFetch(1);

                try {
                    Vector beans = mbean.retrieveAll();
                    if (beans != null && beans.size() > 0) {
                        GponOnuNetworkConfigureMBean aBean = (GponOnuNetworkConfigureMBean) beans.get(0);
                        if (aBean != null)
                            ipAddr = aBean.getOnuCfgOnuIPAddress() != null ? aBean.getOnuCfgOnuIPAddress() : String.valueOf(index);
                    }
                } catch (MibBeanException e1) {
                    e1.printStackTrace();
                }
            }

            String webPageUrl = "http://" + ipAddr + "/";
            try {
                Runtime.getRuntime().exec("cmd.exe /c start " + webPageUrl);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
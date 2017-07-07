/**
 * Created by Zhou Chao, 2009/3/13
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100.action;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.InterfaceTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponSfpE1MngIpCfgTable;
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

public class OpenE1WebMgmtAction extends SnmpAction {

    public OpenE1WebMgmtAction(IApplication anApplication) {
        super(anApplication);
        putValue(BaseAction.ID, "OpenE1WebMgmt");
    }

    public void executeAction(ActionEvent e) {
        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        int selectedRow = fTable.getSelectedRow();
        if (selectedRow < 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }
        SnmpMibBean bean = tableModel.getRow(selectedRow);
        if (bean instanceof InterfaceTableMBean) {
            String ipAddr = "";
            if (ipAddr == null || ipAddr.trim().length() <= 0) {
                int ifIndex = ((InterfaceTableMBean) bean).getIfIndex();
                String ifIndexStr = ConfigUtility.formatIfIndex(ifIndex);
                String[] indexes = ifIndexStr.split("/");
                int slot = 0;
                int port = 0;
                try {
                    slot = ((indexes != null && indexes.length > 0) ? Integer.parseInt(indexes[0]) : 0);
                    port = ((indexes != null && indexes.length > 1) ? Integer.parseInt(indexes[1]) : 0);
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }

                GponSfpE1MngIpCfgTable mbean = new GponSfpE1MngIpCfgTable(fApplication.getSnmpProxy());
                String index = slot + "";
                mbean.setSfpE1MngIpCfgSlotNo(slot);
                mbean.setSfpE1MngIpCfgPortNo(port);
                mbean.setIndexPrefix(index);
                mbean.setRowsToFetch(1);

                try {
                    Vector beans = mbean.retrieveAll();
                    if (beans != null && beans.size() > 0) {
                        GponSfpE1MngIpCfgTable aBean = (GponSfpE1MngIpCfgTable) beans.get(0);
                        if (aBean != null)
                            ipAddr = aBean.getSfpE1MngIpCfgMngIpAddress() != null ? aBean.getSfpE1MngIpCfgMngIpAddress() : String.valueOf(index);
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
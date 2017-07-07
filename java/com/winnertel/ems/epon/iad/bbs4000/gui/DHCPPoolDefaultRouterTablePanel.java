package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolDefaultRouterTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolTable;
import com.winnertel.ems.epon.iad.bbs4000.model.DHCPPool;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.snmp.SnmpUtility;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The DHCPPoolDefaultRouterTablePanel class. Created by DVM Creator
 */
public class DHCPPoolDefaultRouterTablePanel extends UPanel {

    private JComboBox tfUtsDHCPPoolName = new JComboBox();

    private IPAddressField tfUtsDHCPPoolDefaultRouterIpAddress = new IPAddressField();

    private final String utsDHCPPoolName = fStringMap
            .getString("utsDHCPPoolName")
            + " : ";

    private final String utsDHCPPoolDefaultRouterIpAddress = fStringMap
            .getString("utsDHCPPoolDefaultRouterIpAddress")
            + " : ";

    public DHCPPoolDefaultRouterTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5,
                5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDHCPPoolName));
        tfUtsDHCPPoolName.setName(fStringMap.getString("utsDHCPPoolName"));
        baseInfoPanel.add(tfUtsDHCPPoolName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDHCPPoolDefaultRouterIpAddress));
        tfUtsDHCPPoolDefaultRouterIpAddress.setName(fStringMap
                .getString("utsDHCPPoolDefaultRouterIpAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolDefaultRouterIpAddress);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

    }

    protected void initForm() {

    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUtsDHCPPoolName.removeAllItems();
            DHCPPoolTable mbean = new DHCPPoolTable(fApplication.getSnmpProxy());
            DHCPPoolDefaultRouterTable thismbean = new DHCPPoolDefaultRouterTable(fApplication.getSnmpProxy());

            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            Vector thisv = BeanService.refreshTableBean(fApplication, thismbean);
            if (v != null && thisv != null && v.size() != thisv.size()) {
                for (int i = 0; i < v.size(); i++) {
                    DHCPPoolTable one = (DHCPPoolTable) v.get(i);
                    String str = one.getUtsDHCPPoolName();
                    int j = 0;
                    for (j = 0; j < thisv.size(); j++) {
                        DHCPPoolDefaultRouterTable thisone = (DHCPPoolDefaultRouterTable) thisv.get(j);
                        if (str.equals(thisone.getUtsDHCPPoolName()))
                            break;
                    }
                    if (j == thisv.size())
                        tfUtsDHCPPoolName.addItem(str);

                }
            }
            return;
        }
        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            tfUtsDHCPPoolName.setEnabled(false);
        }
        DHCPPoolDefaultRouterTable mbean = (DHCPPoolDefaultRouterTable) getModel();

        tfUtsDHCPPoolName.addItem(mbean.getUtsDHCPPoolName().toString());
        tfUtsDHCPPoolName.setSelectedItem(mbean.getUtsDHCPPoolName().toString());
        tfUtsDHCPPoolDefaultRouterIpAddress.setValue(mbean
                .getUtsDHCPPoolDefaultRouterIpAddress());
//		tfUtsDHCPPoolDefaultRouterStatus.setSelectedIndex(getIndexFromValue(
//				utsDHCPPoolDefaultRouterStatusVList, mbean
//						.getUtsDHCPPoolDefaultRouterStatus().intValue()));

    }

    public boolean validateFrom() {
      String ipAddr = tfUtsDHCPPoolDefaultRouterIpAddress.getIPString();

      DHCPPool pool = new DHCPPool(fApplication, (String)tfUtsDHCPPoolName.getSelectedItem());
      if(!pool.isIpInSameSubnet(ipAddr))
      {
        String error = fStringMap.getString("Err_IP_Not_Exist_DHCP_Pool_1") + ipAddr +
                fStringMap.getString("Err_IP_Not_Exist_DHCP_Pool_2") + tfUtsDHCPPoolName.getSelectedItem() + 
                fStringMap.getString("Err_IP_Not_Exist_DHCP_Pool_3") + ".";
        MessageDialog.showErrorMessageDialog(fApplication, error);
        return false;
      }

      if(pool.isIpReserved(ipAddr))
      {
        String error = fStringMap.getString("Err_IP_Reserved_In_DHCP_Pool_1") + ipAddr +
                fStringMap.getString("Err_IP_Reserved_In_DHCP_Pool_2") + tfUtsDHCPPoolName.getSelectedItem() + fStringMap.getString("Err_IP_Reserved_In_DHCP_Pool_3");
        MessageDialog.showErrorMessageDialog(fApplication, error);
        return false;
      }

      return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new DHCPPoolDefaultRouterTable(fApplication.getSnmpProxy()));

        DHCPPoolDefaultRouterTable mbean = (DHCPPoolDefaultRouterTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // // here set the value of index
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(tfUtsDHCPPoolName.getSelectedItem().toString()) + "." +
                    new String(tfUtsDHCPPoolDefaultRouterIpAddress.getIPString()));
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

    public void afterUpdateModel() {
        GuiUtil.getParentDialog( this ).dispose();
                       
    }

}

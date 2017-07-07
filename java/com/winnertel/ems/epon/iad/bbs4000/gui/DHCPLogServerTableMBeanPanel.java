package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPLogServerTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
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
 * The DHCPLogServerTableMBeanPanel class.
 * Created by DVM Creator
 */
public class DHCPLogServerTableMBeanPanel extends UPanel {

    private JComboBox tfUtsDHCPPoolName = new JComboBox();

    private IPAddressField tfUtsDHCPPoolLogServerIpAddress = new IPAddressField();

    private final String utsDHCPPoolName = fStringMap.getString("utsDHCPPoolName") + " : ";
    private final String utsDHCPPoolLogServerIpAddress = fStringMap.getString("utsDHCPPoolLogServerIpAddress") + " : ";


    public DHCPLogServerTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDHCPPoolName));
        tfUtsDHCPPoolName.setName(fStringMap.getString("utsDHCPPoolName"));
        baseInfoPanel.add(tfUtsDHCPPoolName);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDHCPPoolLogServerIpAddress));
        tfUtsDHCPPoolLogServerIpAddress.setName(fStringMap.getString("utsDHCPPoolLogServerIpAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolLogServerIpAddress);
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
            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            if (v != null) {
                for (int i = 0; i < v.size(); i++) {
                    DHCPPoolTable one = (DHCPPoolTable) v.get(i);
                    String str = one.getUtsDHCPPoolName();
                    tfUtsDHCPPoolName.addItem(str);
                }
            }
            return;
        }
        DHCPLogServerTableMBean mbean = (DHCPLogServerTableMBean) getModel();

        tfUtsDHCPPoolName.setSelectedItem(mbean.getUtsDHCPPoolName());
        tfUtsDHCPPoolLogServerIpAddress.setValue(mbean.getUtsDHCPPoolLogServerIpAddress());
//         tfUtsDHCPPoolLogServerStatus.setSelectedIndex(getIndexFromValue(utsDHCPPoolLogServerStatusVList,mbean.getUtsDHCPPoolLogServerStatus().intValue()));

    }

    public boolean validateFrom() {
        DHCPLogServerTableMBean mbean = new DHCPLogServerTableMBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, mbean);
        int count = 0;
        for (int i = 0; i < v.size(); i++) {
            DHCPLogServerTableMBean one = (DHCPLogServerTableMBean) v.get(i);
            if (one.getUtsDHCPPoolName().equals(tfUtsDHCPPoolName.getSelectedItem())) {
                if (one.getUtsDHCPPoolLogServerIpAddress().equals(new String(tfUtsDHCPPoolLogServerIpAddress.getIPString()))) {
                    String error = fStringMap.getString("Err_IP_Exist_In_Pool") + tfUtsDHCPPoolName.getSelectedItem() + ".";
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
                count++;
            }


        }
        if (count == 3) {
            String error = fStringMap.getString("Err_More_3_DHCP_Log_Server");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }


        return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new DHCPLogServerTableMBean(fApplication.getSnmpProxy()));

        DHCPLogServerTableMBean mbean = (DHCPLogServerTableMBean) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(tfUtsDHCPPoolName.getSelectedItem().toString()) + "." +
                    new String(tfUtsDHCPPoolLogServerIpAddress.getIPString()));
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

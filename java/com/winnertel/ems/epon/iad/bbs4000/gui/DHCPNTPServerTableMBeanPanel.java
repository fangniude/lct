package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPNTPServerTableMBean;
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
 * The DHCPNTPServerTableMBeanPanel class.
 * Created by DVM Creator
 */
public class DHCPNTPServerTableMBeanPanel extends UPanel {

    private JComboBox tfUtsDHCPPoolName = new JComboBox();

    private IPAddressField tfUtsDHCPPoolNtpServerIpAddress = new IPAddressField();

    private final String utsDHCPPoolName = fStringMap.getString("utsDHCPPoolName") + " : ";
    private final String utsDHCPPoolNtpServerIpAddress = fStringMap.getString("utsDHCPPoolNtpServerIpAddress") + " : ";


    public DHCPNTPServerTableMBeanPanel(IApplication app) {
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


        baseInfoPanel.add(new JLabel(utsDHCPPoolNtpServerIpAddress));
        tfUtsDHCPPoolNtpServerIpAddress.setName(fStringMap.getString("utsDHCPPoolNtpServerIpAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolNtpServerIpAddress);
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
        DHCPNTPServerTableMBean mbean = (DHCPNTPServerTableMBean) getModel();

        tfUtsDHCPPoolName.setSelectedItem(mbean.getUtsDHCPPoolName());
        tfUtsDHCPPoolNtpServerIpAddress.setValue(mbean.getUtsDHCPPoolNtpServerIpAddress());
//         tfUtsDHCPPoolNtpServerStatus.setSelectedIndex(getIndexFromValue(utsDHCPPoolNtpServerStatusVList,mbean.getUtsDHCPPoolNtpServerStatus().intValue()));

    }

    public boolean validateFrom() {
        DHCPNTPServerTableMBean mbean = new DHCPNTPServerTableMBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, mbean);
        int count = 0;
        for (int i = 0; i < v.size(); i++) {
            DHCPNTPServerTableMBean one = (DHCPNTPServerTableMBean) v.get(i);
            if (one.getUtsDHCPPoolName().equals(tfUtsDHCPPoolName.getSelectedItem())) {
                if (one.getUtsDHCPPoolNtpServerIpAddress().equals(new String(tfUtsDHCPPoolNtpServerIpAddress.getIPString()))) {
                    String error = fStringMap.getString("Err_IP_Exist_In_Pool") + tfUtsDHCPPoolName.getSelectedItem() + ".";
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
                count++;
            }

        }
        if (count == 3) {
            String error = fStringMap.getString("Err_More_3_DHCP_NTP_Server");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new DHCPNTPServerTableMBean(fApplication.getSnmpProxy()));

        DHCPNTPServerTableMBean mbean = (DHCPNTPServerTableMBean) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(tfUtsDHCPPoolName.getSelectedItem().toString()) + "." +
                    new String(tfUtsDHCPPoolNtpServerIpAddress.getIPString()));

        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

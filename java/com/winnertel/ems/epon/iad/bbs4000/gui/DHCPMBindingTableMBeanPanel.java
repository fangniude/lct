package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPGeneral;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPIPBindingStatusTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPMBindingTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolTable;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.snmp.SnmpUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * The DHCPMBindingTableMBeanPanel class.
 * Created by DVM Creator
 */
public class DHCPMBindingTableMBeanPanel extends UPanel {

    private JComboBox tfUtsDHCPPoolName = new JComboBox();

    private JLabel lUtsDHCPNetworkAddress = new JLabel();

    private IPAddressField tfUtsDHCPPoolManualBindIpAddress = new IPAddressField();

    private IntegerTextField tfUtsDHCPPoolManualBindVlanId = new IntegerTextField();

    private MacAddressField tfUtsDHCPPoolManualBindHardwareAddress = new MacAddressField();

    private JComboBox cbChoose = new JComboBox(new String[]{"VLAN Based", "MAC Based"});

    private final String utsDHCPPoolName = fStringMap.getString("utsDHCPPoolName") + " : ";
    private final String utsDHCPPoolManualBindIpAddress = fStringMap.getString("utsDHCPPoolManualBindIpAddress") + " : ";
    private final String utsDHCPPoolManualBindVlanId = fStringMap.getString("utsDHCPPoolManualBindVlanId") + " : ";
    private final String utsDHCPPoolManualBindHardwareAddress = fStringMap.getString("utsDHCPPoolManualBindHardwareAddress") + " : ";


    public DHCPMBindingTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {


        DHCPGeneral mbean = new DHCPGeneral(fApplication.getSnmpProxy());
        try {
            mbean.retrieve();
        } catch (MibBeanException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout;
        if(mbean.getUtsDHCPServiceMode().intValue() == 2){

            layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        }
        else
            layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);

        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());


        baseInfoPanel.add(new JLabel(utsDHCPPoolName));
        tfUtsDHCPPoolName.setName(fStringMap.getString("utsDHCPPoolName"));
        baseInfoPanel.add(tfUtsDHCPPoolName);
        baseInfoPanel.add(new HSpacer());
        tfUtsDHCPPoolName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DHCPPoolTable mbean = new DHCPPoolTable(fApplication.getSnmpProxy());
                Vector v = BeanService.refreshTableBean(fApplication, mbean);
                String address = "";
                if (v != null) {
                    for (int i = 0; i < v.size(); i++) {
                        DHCPPoolTable one = (DHCPPoolTable) v.get(i);
                        String strname = one.getUtsDHCPPoolName();
                        if(strname.equals(tfUtsDHCPPoolName.getSelectedItem())){
                            address = one.getUtsDHCPPoolNetworkAddress();
                            break;
                        }
                    }
                    lUtsDHCPNetworkAddress.setText(address);
                }
            }
        });

        baseInfoPanel.add(new JLabel(fStringMap.getString("Network Address:")));
        baseInfoPanel.add(lUtsDHCPNetworkAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDHCPPoolManualBindIpAddress));
        tfUtsDHCPPoolManualBindIpAddress.setName(fStringMap.getString("utsDHCPPoolManualBindIpAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolManualBindIpAddress);
        baseInfoPanel.add(new HSpacer());


        if(mbean.getUtsDHCPServiceMode().intValue() == 2){
            baseInfoPanel.add(new JLabel("Binding Type:"));
            cbChoose.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(cbChoose.getSelectedIndex() == 0){
                        tfUtsDHCPPoolManualBindHardwareAddress.setEditable(false);
                        tfUtsDHCPPoolManualBindHardwareAddress.setValue("00.00.00.00.00.00");
                        tfUtsDHCPPoolManualBindVlanId.setEditable(true);
                        tfUtsDHCPPoolManualBindVlanId.setText("1");
                    }
                    if(cbChoose.getSelectedIndex() == 1){
                        tfUtsDHCPPoolManualBindHardwareAddress.setEditable(true);
                        tfUtsDHCPPoolManualBindVlanId.setText("0");
                        tfUtsDHCPPoolManualBindVlanId.setEditable(false);
                    }
                }
            });
            baseInfoPanel.add(cbChoose);
            baseInfoPanel.add(new HSpacer());
            tfUtsDHCPPoolManualBindHardwareAddress.setEditable(false);
        }

        if(mbean.getUtsDHCPServiceMode().intValue() == 2){
            baseInfoPanel.add(new JLabel(utsDHCPPoolManualBindVlanId));
            tfUtsDHCPPoolManualBindVlanId.setName(fStringMap.getString("utsDHCPPoolManualBindVlanId"));
            baseInfoPanel.add(tfUtsDHCPPoolManualBindVlanId);
            baseInfoPanel.add(new HSpacer());
        }


        baseInfoPanel.add(new JLabel(utsDHCPPoolManualBindHardwareAddress));
        tfUtsDHCPPoolManualBindHardwareAddress.setName(fStringMap.getString("utsDHCPPoolManualBindHardwareAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolManualBindHardwareAddress);
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

        tfUtsDHCPPoolManualBindHardwareAddress.setValue("00.00.00.00.00.00");
        tfUtsDHCPPoolManualBindVlanId.setValue(0);
        tfUtsDHCPPoolManualBindVlanId.setEditable(false);
        DHCPGeneral generalmbean = new DHCPGeneral(fApplication.getSnmpProxy());
        BeanService.refreshBean(fApplication,generalmbean);
        if(generalmbean.getUtsDHCPServiceMode().intValue() == 2){
            tfUtsDHCPPoolManualBindVlanId.setEditable(true);
            tfUtsDHCPPoolManualBindVlanId.setValueScope(1,4094);
            tfUtsDHCPPoolManualBindVlanId.setValue(0);
        }
        else{
            tfUtsDHCPPoolManualBindVlanId.setEditable(false);
            tfUtsDHCPPoolManualBindVlanId.setValueScope(0,0);
        }

    }

    public void refresh() {
        DHCPMBindingTableMBean mbean = (DHCPMBindingTableMBean) getModel();

        tfUtsDHCPPoolName.removeAllItems();
        DHCPPoolTable mbean1 = new DHCPPoolTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, mbean1);
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                DHCPPoolTable one = (DHCPPoolTable) v.get(i);
                String strname = one.getUtsDHCPPoolName();
                tfUtsDHCPPoolName.addItem(strname);
                if(i == 0){
                    String straddress = one.getUtsDHCPPoolNetworkAddress();
                    lUtsDHCPNetworkAddress.setText(straddress);
                }
            }
        }
        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            tfUtsDHCPPoolName.setEnabled(false);
            tfUtsDHCPPoolManualBindIpAddress.setEditable(false);
            if(mbean.getUtsDHCPPoolManualBindVlanId().intValue() == 0)
            {
              cbChoose.setSelectedIndex(1);//MAC Based
            }
            else
            {
              cbChoose.setSelectedIndex(0);//VLAN Based
            }
        }
        if (SnmpAction.IType.ADD.equals(fCommand)) {

            return;

        }


        tfUtsDHCPPoolName.setSelectedItem(mbean.getUtsDHCPPoolName().toString());
        tfUtsDHCPPoolManualBindIpAddress.setValue(mbean.getUtsDHCPPoolManualBindIpAddress());
        tfUtsDHCPPoolManualBindVlanId.setValue(mbean.getUtsDHCPPoolManualBindVlanId().intValue());
        tfUtsDHCPPoolManualBindHardwareAddress.setValue(mbean.getUtsDHCPPoolManualBindHardwareAddress());
//         tfUtsDHCPPoolManualBindStatus.setSelectedIndex(getIndexFromValue(utsDHCPPoolManualBindStatusVList,mbean.getUtsDHCPPoolManualBindStatus().intValue()));

    }

    public boolean validateFrom() {
        String name = tfUtsDHCPPoolName.getSelectedItem().toString();
        String ipAddr = tfUtsDHCPPoolManualBindIpAddress.getIPString();
        int vlan = tfUtsDHCPPoolManualBindVlanId.getValue();
        String ipaddress = "", poolMask = "";
        DHCPPoolTable mbean = new DHCPPoolTable(fApplication.getSnmpProxy());
        Vector v = new Vector();
        try {
            v = mbean.retrieveAll();
        } catch (MibBeanException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        for (int i = 0; i < v.size(); i++) {
            DHCPPoolTable one = (DHCPPoolTable) v.get(i);
            if (one.getUtsDHCPPoolName().equals(name)) {
                ipaddress = one.getUtsDHCPPoolNetworkAddress();
                poolMask = one.getUtsDHCPPoolNetworkMask();
                break;
            }
        }
        String subnet = ConfigUtility.getSubnetAddress(ipAddr, poolMask);

        if (!subnet.equals(ipaddress)) {
            String error = fStringMap.getString("Err_IP_Not_Exist_DHCP_Pool_1") + ipAddr +
                    fStringMap.getString("Err_IP_Not_Exist_DHCP_Pool_2") + tfUtsDHCPPoolName.getSelectedItem() + fStringMap.getString("Err_IP_Not_Exist_DHCP_Pool_3");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }
        String haddr = new String(tfUtsDHCPPoolManualBindHardwareAddress.getValue());
        if(!tfUtsDHCPPoolManualBindVlanId.isEditable()){
            if (haddr.equals("\u0000\u0000\u0000\u0000\u0000\u0000")) {
                String error = fStringMap.getString("Err_Invalid_MAC_Address");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }
        else{
            if((haddr.equals("\u0000\u0000\u0000\u0000\u0000\u0000")&&vlan == 0)||
                    (!haddr.equals("\u0000\u0000\u0000\u0000\u0000\u0000")&&vlan != 0)){
                String error = fStringMap.getString("Err_Invalid_IP_Or_MAC");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }
        if(SnmpAction.IType.ADD.equals(fCommand)){
            DHCPMBindingTableMBean mbean1 = new DHCPMBindingTableMBean(fApplication.getSnmpProxy());
            Vector v1 = BeanService.refreshTableBean(fApplication, mbean1);
            if (v1 != null) {
                for (int i = 0; i < v1.size(); i++) {
                    DHCPMBindingTableMBean one = (DHCPMBindingTableMBean) v1.get(i);
                    if (tfUtsDHCPPoolManualBindIpAddress.getIPString().equals(one.getUtsDHCPPoolManualBindIpAddress())) {
                        String error = fStringMap.getString("Err_Bind_IP_Exist");
                        MessageDialog.showErrorMessageDialog(fApplication, error);
                        return false;
                    }
                }
            }
        }
        DHCPIPBindingStatusTableMBean mbean2 = new DHCPIPBindingStatusTableMBean(fApplication.getSnmpProxy());
        Vector v2 = BeanService.refreshTableBean(fApplication, mbean2);
        if (v2 != null) {
            int i = 0;
            for (i = 0; i < v2.size(); i++) {
                DHCPIPBindingStatusTableMBean one = (DHCPIPBindingStatusTableMBean) v2.get(i);
                if (one.getUtsDHCPPoolName().equals(name)) {
                    if (one.getUtsIpDHCPPoolBindingIpAddress().equals(ipAddr))
                        break;
                }
            }
            if (i == v2.size()) {
                String error = fStringMap.getString("Err_Bind_IP_Not_In_List");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }

        return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new DHCPMBindingTableMBean(fApplication.getSnmpProxy()));

        DHCPMBindingTableMBean mbean = (DHCPMBindingTableMBean) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(tfUtsDHCPPoolName.getSelectedItem().toString()) + "." +
                    new String(tfUtsDHCPPoolManualBindIpAddress.getIPString()));
            mbean.setUtsDHCPPoolManualBindIpAddress(new String(tfUtsDHCPPoolManualBindIpAddress.getIPString()));
        }

//        mbean.setUtsDHCPPoolName(tfUtsDHCPPoolName.getSelectedItem().toString());
        mbean.setUtsDHCPPoolManualBindVlanId(new Integer(tfUtsDHCPPoolManualBindVlanId.getValue()));
        mbean.setUtsDHCPPoolManualBindHardwareAddress(tfUtsDHCPPoolManualBindHardwareAddress.getValue());
//         mbean.setUtsDHCPPoolManualBindStatus(new Integer(utsDHCPPoolManualBindStatusVList[tfUtsDHCPPoolManualBindStatus.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

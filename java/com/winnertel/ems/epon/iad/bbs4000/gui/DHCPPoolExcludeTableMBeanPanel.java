package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolExcludeTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolIncludeTableMBean;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
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
 * The DHCPPoolExcludeTableMBeanPanel class.
 * Created by DVM Creator
 */
public class DHCPPoolExcludeTableMBeanPanel extends UPanel {

    private IPAddressField tfUtsDHCPPoolExcludedLowIpAddress = new IPAddressField();

    private IPAddressField tfUtsDHCPPoolExcludedHighIpAddress = new IPAddressField();

//    private final String utsDHCPPoolName = fStringMap.getString("utsDHCPPoolName") + " : ";
    private final String utsDHCPPoolExcludedLowIpAddress = fStringMap.getString("utsDHCPPoolExcludedLowIpAddress") + " : ";
    private final String utsDHCPPoolExcludedHighIpAddress = fStringMap.getString("utsDHCPPoolExcludedHighIpAddress") + " : ";

    String poolName;


    public DHCPPoolExcludeTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDHCPPoolExcludedLowIpAddress));
        tfUtsDHCPPoolExcludedLowIpAddress.setName(fStringMap.getString("utsDHCPPoolExcludedLowIpAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolExcludedLowIpAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDHCPPoolExcludedHighIpAddress));
        tfUtsDHCPPoolExcludedHighIpAddress.setName(fStringMap.getString("utsDHCPPoolExcludedHighIpAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolExcludedHighIpAddress);
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
        java.awt.Container p = this;
        while( !(p instanceof SnmpDialog))
        {
            p = p.getParent();
        }
        SnmpTable fTable = (( SnmpDialog )p).getTable();
        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        SnmpMibBean bean = ( SnmpMibBean ) tableModel.getMibBean();
        this.poolName = ((DHCPPoolExcludeTableMBean)bean).getPoolName();
        if (SnmpAction.IType.ADD.equals(fCommand)) {

            return;
        }
        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            tfUtsDHCPPoolExcludedLowIpAddress.setEditable(false);
        }
        DHCPPoolExcludeTableMBean mbean1 = (DHCPPoolExcludeTableMBean) getModel();

        tfUtsDHCPPoolExcludedLowIpAddress.setValue(mbean1.getUtsDHCPPoolExcludedLowIpAddress());
        tfUtsDHCPPoolExcludedHighIpAddress.setValue(mbean1.getUtsDHCPPoolExcludedHighIpAddress());
//         tfUtsDHCPPoolExcludedStatus.setSelectedIndex(getIndexFromValue(utsDHCPPoolExcludedStatusVList,mbean.getUtsDHCPPoolExcludedStatus().intValue()));

    }

    public boolean validateFrom(){
        String lowaddr = tfUtsDHCPPoolExcludedLowIpAddress.getIPString();
        String highaddr = tfUtsDHCPPoolExcludedHighIpAddress.getIPString();

        if(ConfigUtility.compareIP(highaddr, lowaddr) < 0){
            String error = fStringMap.getString("Err_Start_IP_Hight_Than_End_IP");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        if (SnmpAction.IType.ADD.equals(fCommand)){
            if (isExAddrOverLapped(lowaddr, highaddr,0))
                return false;
        }
        if(SnmpAction.IType.MODIFY.equals(fCommand)){
            if (isExAddrOverLapped(lowaddr, highaddr,1))
                return false;
        }

        if(!isInInAddr(lowaddr,highaddr))
            return false;


        return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new DHCPPoolExcludeTableMBean(fApplication.getSnmpProxy()));

        DHCPPoolExcludeTableMBean mbean = (DHCPPoolExcludeTableMBean) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(poolName) + "." +
                    new String(tfUtsDHCPPoolExcludedLowIpAddress.getIPString()));
        }


        mbean.setUtsDHCPPoolExcludedLowIpAddress(new String(tfUtsDHCPPoolExcludedLowIpAddress.getIPString()));
        mbean.setUtsDHCPPoolExcludedHighIpAddress(new String(tfUtsDHCPPoolExcludedHighIpAddress.getIPString()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    public boolean isExAddrOverLapped(String lowaddr,String highaddr,int mode) {
        DHCPPoolExcludeTableMBean mbean = new DHCPPoolExcludeTableMBean(fApplication.getSnmpProxy());
        Vector exv = BeanService.refreshTableBean(fApplication, mbean);
        if (exv != null) {
            for (int i = 0; i < exv.size(); i++) {
                DHCPPoolExcludeTableMBean one = (DHCPPoolExcludeTableMBean) exv.get(i);
                String exlowaddr = one.getUtsDHCPPoolExcludedLowIpAddress();
                String exhighaddr = one.getUtsDHCPPoolExcludedHighIpAddress();
                String poolname = one.getUtsDHCPPoolName();
                if (poolname.equals(poolName)) {
                    if(mode == 0){
                        if (ConfigUtility.checkIPScope(lowaddr, exlowaddr, exhighaddr)) {
                            String error = fStringMap.getString("Err_Duplicate_IP");
                            MessageDialog.showErrorMessageDialog(fApplication, error);
                            return true;
                        } else if (ConfigUtility.checkIPScope(highaddr, exlowaddr, exhighaddr)) {
                            String error = fStringMap.getString("Err_Duplicate_IP");
                            MessageDialog.showErrorMessageDialog(fApplication, error);
                            return true;
                        } else if (ConfigUtility.checkIPScope(exlowaddr, lowaddr, highaddr)) {
                            String error = fStringMap.getString("Err_Duplicate_IP");
                            MessageDialog.showErrorMessageDialog(fApplication, error);
                            return true;

                        }
                    }
                    if(mode == 1&&!lowaddr.equals(exlowaddr)){
                        if (ConfigUtility.checkIPScope(highaddr, exlowaddr, exhighaddr)) {
                            String error = fStringMap.getString("Err_Duplicate_IP");
                            MessageDialog.showErrorMessageDialog(fApplication, error);
                            return true;
                        }

                    }
                }
            }
        }

        return false;
    }

    public boolean isInInAddr(String lowaddr,String highaddr){
        DHCPPoolIncludeTableMBean mbean = new DHCPPoolIncludeTableMBean(fApplication.getSnmpProxy());
        Vector inv = BeanService.refreshTableBean(fApplication, mbean);
        if (inv != null) {
            int i = 0;
            for (i = 0; i < inv.size(); i++) {
                DHCPPoolIncludeTableMBean one = (DHCPPoolIncludeTableMBean) inv.get(i);
                String inlowaddr = one.getUtsDHCPPoolIncludedLowIpAddress();
                String inhighaddr = one.getUtsDHCPPoolIncludedHighIpAddress();
                String poolname = one.getUtsDHCPPoolName();
                if(poolname.equals(poolName)){
                    if(ConfigUtility.checkIPScope(lowaddr, inlowaddr, inhighaddr) &&
   							ConfigUtility.checkIPScope(highaddr, inlowaddr, inhighaddr))
                        break;
                }
            }
            if(i == inv.size()){
                String error = fStringMap.getString("Err_Excluded_IP_Not_In_Included_IP");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }
        return true;
    }



}


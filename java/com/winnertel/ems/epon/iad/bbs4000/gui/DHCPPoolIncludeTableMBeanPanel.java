package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolDefaultRouterTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolIncludeTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
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
 * The DHCPPoolIncludeTableMBeanPanel class.
 * Created by DVM Creator
 */
public class DHCPPoolIncludeTableMBeanPanel extends UPanel {

    private IPAddressField tfUtsDHCPPoolIncludedLowIpAddress = new IPAddressField();

    private IPAddressField tfUtsDHCPPoolIncludedHighIpAddress = new IPAddressField();

    private final String utsDHCPPoolName = fStringMap.getString("utsDHCPPoolName") + " : ";
    private final String utsDHCPPoolIncludedLowIpAddress = fStringMap.getString("utsDHCPPoolIncludedLowIpAddress") + " : ";
    private final String utsDHCPPoolIncludedHighIpAddress = fStringMap.getString("utsDHCPPoolIncludedHighIpAddress") + " : ";

    private String poolName;
    private String HighIpAddress;


    public DHCPPoolIncludeTableMBeanPanel(IApplication app) {
        super(app);
        setModel(new DHCPPoolIncludeTableMBean(app.getSnmpProxy()));
        init();
    }


    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDHCPPoolIncludedLowIpAddress));
        tfUtsDHCPPoolIncludedLowIpAddress.setName(fStringMap.getString("utsDHCPPoolIncludedLowIpAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolIncludedLowIpAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDHCPPoolIncludedHighIpAddress));
        tfUtsDHCPPoolIncludedHighIpAddress.setName(fStringMap.getString("utsDHCPPoolIncludedHighIpAddress"));
        baseInfoPanel.add(tfUtsDHCPPoolIncludedHighIpAddress);
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
        while (!(p instanceof SnmpDialog)) {
            p = p.getParent();
        }
        SnmpTable fTable = ((SnmpDialog) p).getTable();
        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        SnmpMibBean bean = (SnmpMibBean) tableModel.getMibBean();
        this.poolName = ((DHCPPoolIncludeTableMBean) bean).getPoolName();

        if (SnmpAction.IType.ADD.equals(fCommand)) {

            return;
        }
        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            tfUtsDHCPPoolIncludedLowIpAddress.setEditable(false);
        }
        DHCPPoolIncludeTableMBean mbean1 = (DHCPPoolIncludeTableMBean) getModel();
        tfUtsDHCPPoolIncludedLowIpAddress.setValue(mbean1.getUtsDHCPPoolIncludedLowIpAddress());
        tfUtsDHCPPoolIncludedHighIpAddress.setValue(mbean1.getUtsDHCPPoolIncludedHighIpAddress());

//         tfUtsDHCPPoolIncludedStatus.setSelectedIndex(getIndexFromValue(utsDHCPPoolIncludedStatusVList,mbean.getUtsDHCPPoolIncludedStatus().intValue()));


    }

    public boolean validateFrom() {
        String lowaddr = tfUtsDHCPPoolIncludedLowIpAddress.getIPString();
        String highaddr = tfUtsDHCPPoolIncludedHighIpAddress.getIPString();
        if(ConfigUtility.compareIP(highaddr, lowaddr) < 0){
            String error = fStringMap.getString("Err_Start_IP_Hight_Than_End_IP");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            if (isInAddrOverLapped(lowaddr, highaddr,0))
                return false;
        }
        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            if (isInAddrOverLapped(lowaddr, highaddr,1))
                return false;
        }
        if(isDefRootin(lowaddr,highaddr))
            return false;
        
        if(!isInInAddr(lowaddr,highaddr))
            return false;

        EthIfExtTable mbean = new EthIfExtTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication,mbean);
        if(v!=null){
            for(int i=0;i<v.size();i++){
                EthIfExtTable one = (EthIfExtTable)v.get(i);
                String ipaddress = one.getUtsEthIfExtIpAddress();
                if(ConfigUtility.checkIPScope(ipaddress, lowaddr, highaddr)){
                    String error = "The IP Addresses "+ipaddress+" is in the Interface table" +
                            ", can not finish the operation.";
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
        }


        return true;
    }


    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new DHCPPoolIncludeTableMBean(fApplication.getSnmpProxy()));

        DHCPPoolIncludeTableMBean mbean = (DHCPPoolIncludeTableMBean) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(poolName) + "." +
                    new String(tfUtsDHCPPoolIncludedLowIpAddress.getIPString()));
        }
        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(poolName));
        }

        mbean.setUtsDHCPPoolIncludedLowIpAddress(new String(tfUtsDHCPPoolIncludedLowIpAddress.getIPString()));
        mbean.setUtsDHCPPoolIncludedHighIpAddress(new String(tfUtsDHCPPoolIncludedHighIpAddress.getIPString()));
//         mbean.setUtsDHCPPoolIncludedStatus(new Integer(utsDHCPPoolIncludedStatusVList[tfUtsDHCPPoolIncludedStatus.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    public boolean isInAddrOverLapped(String lowaddr, String highaddr,int mode) {
        DHCPPoolIncludeTableMBean mbean = new DHCPPoolIncludeTableMBean(fApplication.getSnmpProxy());
        Vector inv = BeanService.refreshTableBean(fApplication, mbean);
        if (inv != null) {
            for (int i = 0; i < inv.size(); i++) {
                DHCPPoolIncludeTableMBean one = (DHCPPoolIncludeTableMBean) inv.get(i);
                String inlowaddr = one.getUtsDHCPPoolIncludedLowIpAddress();
                String inhighaddr = one.getUtsDHCPPoolIncludedHighIpAddress();
                String poolname = one.getUtsDHCPPoolName();
                if (poolname.equals(poolName)) {
                    if(mode == 0){
                        if (ConfigUtility.checkIPScope(lowaddr, inlowaddr, inhighaddr)) {
                            String error = fStringMap.getString("Err_Duplicate_IP");
                            MessageDialog.showErrorMessageDialog(fApplication, error);
                            return true;
                        } else if (ConfigUtility.checkIPScope(highaddr, inlowaddr, inhighaddr)) {
                            String error = fStringMap.getString("Err_Duplicate_IP");
                            MessageDialog.showErrorMessageDialog(fApplication, error);
                            return true;
                        } else if (ConfigUtility.checkIPScope(inlowaddr, lowaddr, highaddr)) {
                            String error = fStringMap.getString("Err_Duplicate_IP");
                            MessageDialog.showErrorMessageDialog(fApplication, error);
                            return true;

                        }
                    }
                    if(mode == 1&&!lowaddr.equals(inlowaddr)){
                        if (ConfigUtility.checkIPScope(highaddr, inlowaddr, inhighaddr)) {
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

    public boolean isDefRootin(String lowaddr,String highaddr){
        DHCPPoolDefaultRouterTable mbean = new DHCPPoolDefaultRouterTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication,mbean);
        if(v!=null){
            for(int i=0;i<v.size();i++){
                DHCPPoolDefaultRouterTable one = (DHCPPoolDefaultRouterTable)v.get(i);
                if(one.getUtsDHCPPoolName().equals(poolName)){
                    String ip = one.getUtsDHCPPoolDefaultRouterIpAddress();
                    if(ConfigUtility.checkIPScope(ip, lowaddr, highaddr)){
                        String error = fStringMap.getString("Err_IP_Is_Default_Route_1") + ip + fStringMap.getString("Err_IP_Is_Default_Route_2");
                        MessageDialog.showErrorMessageDialog(fApplication, error);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isInInAddr(String lowaddr,String highaddr){
    	DHCPPoolTable mbean = new DHCPPoolTable(fApplication.getSnmpProxy());
    	Vector inv = BeanService.refreshTableBean(fApplication, mbean);
    	if(inv!=null) {
          for (int i = 0; i < inv.size(); i++) {
        	  DHCPPoolTable one = (DHCPPoolTable) inv.get(i);
        	  String poolname = one.getUtsDHCPPoolName();
        	  if(poolname.equals(poolName)){
            	  String ipaddress = one.getUtsDHCPPoolNetworkAddress();
            	  String maskaddress = one.getUtsDHCPPoolNetworkMask();
        		  if(ConfigUtility.getSubnetAddress(lowaddr, maskaddress).equals(ipaddress) &&
        				  ConfigUtility.getSubnetAddress(highaddr, maskaddress).equals(ipaddress))
        			  return true;
        	  }
          }
          
          String error = fStringMap.getString("Err_Included_IP_Not_In_Included_IP");
          MessageDialog.showErrorMessageDialog(fApplication, error);
          return false;
    	}
    	
    	return true;
    }


}

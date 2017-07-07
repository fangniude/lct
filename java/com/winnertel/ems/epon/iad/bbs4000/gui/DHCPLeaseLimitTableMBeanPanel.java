package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPLeaseLimitTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The DHCPLeaseLimitTableMBeanPanel class.
 * Created by DVM Creator
 */
public class DHCPLeaseLimitTableMBeanPanel extends UPanel {

//    private JLabel UtsDHCPLeaseNumVlan = new JLabel();
    private IntegerTextField tfUtsDHCPLeaseNumVlan = new IntegerTextField();

    private IntegerTextField tfUtsDHCPLeaseNumVal = new IntegerTextField();

    private final String utsDHCPLeaseNumVlan = fStringMap.getString("utsDHCPLeaseNumVlan") + " : ";
    private final String utsDHCPLeaseNumVal = fStringMap.getString("utsDHCPLeaseNumVal") + " : ";


    public DHCPLeaseLimitTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDHCPLeaseNumVlan));
        tfUtsDHCPLeaseNumVlan.setName(fStringMap.getString("utsDHCPLeaseNumVlan"));
        baseInfoPanel.add(tfUtsDHCPLeaseNumVlan);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDHCPLeaseNumVal));
        tfUtsDHCPLeaseNumVal.setName(fStringMap.getString("utsDHCPLeaseNumVal"));
        baseInfoPanel.add(tfUtsDHCPLeaseNumVal);
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
        tfUtsDHCPLeaseNumVal.setValueScope(1, 512);
        tfUtsDHCPLeaseNumVlan.setValueScope(1, 4094);
    }

    public boolean validateFrom() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            DHCPLeaseLimitTableMBean mbean1 = new DHCPLeaseLimitTableMBean(fApplication.getSnmpProxy());
            Vector v = new Vector();
            try {
                v = mbean1.retrieveAll();
            } catch (MibBeanException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            if (v != null) {
                for (int i = 0; i < v.size(); i++) {
                    DHCPLeaseLimitTableMBean one = (DHCPLeaseLimitTableMBean) v.get(i);
                    if (one.getUtsDHCPLeaseNumVlan().intValue() == tfUtsDHCPLeaseNumVlan.getValue()) {
                        String error = fStringMap.getString("Err_VLAN_Exist");
                        MessageDialog.showErrorMessageDialog(fApplication, error);
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void refresh() {
      if (SnmpAction.IType.ADD.equals(fCommand)) {
        tfUtsDHCPLeaseNumVlan.setEnabled(true);
      }else{
        DHCPLeaseLimitTableMBean mbean = (DHCPLeaseLimitTableMBean) getModel();
        tfUtsDHCPLeaseNumVlan.setValue(mbean.getUtsDHCPLeaseNumVlan().intValue());
        tfUtsDHCPLeaseNumVal.setValue(mbean.getUtsDHCPLeaseNumVal().intValue());
        tfUtsDHCPLeaseNumVlan.setEnabled(false);
      }
    }

    public void updateModel() {

        if(SnmpAction.IType.ADD.equals(fCommand)) setModel(new DHCPLeaseLimitTableMBean(fApplication.getSnmpProxy()));

        DHCPLeaseLimitTableMBean mbean = (DHCPLeaseLimitTableMBean) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsDHCPLeaseNumVlan(new Integer(tfUtsDHCPLeaseNumVlan.getValue()));
        }

      	mbean.setUtsDHCPLeaseNumVal(new Integer(tfUtsDHCPLeaseNumVal.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

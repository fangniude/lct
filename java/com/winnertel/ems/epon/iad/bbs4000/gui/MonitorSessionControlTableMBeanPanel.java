package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.MonitorSessionControlTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * The MonitorSessionControlTableMBeanPanel class.
 * Created by DVM Creator
 */
public class MonitorSessionControlTableMBeanPanel extends UPanel {

    private IntegerTextField tfUtsMonitorSessionID = new IntegerTextField();
    private IntegerTextField tfUtsMonitorSessionModule = new IntegerTextField();

    private IntegerTextField tfUtsMonitorSessionPort = new IntegerTextField();

    private StringTextField tfUtsMonitorSessionIngressPortBitLists = new StringTextField();

    private StringTextField tfUtsMonitorSessionEngressPortBitLists = new StringTextField();

    private final String utsMonitorSessionID = fStringMap.getString("utsMonitorSessionID") + " : ";
    private final String utsMonitorSessionModule = fStringMap.getString("utsMonitorSessionModule") + " : ";
    private final String utsMonitorSessionPort = fStringMap.getString("utsMonitorSessionPort") + " : ";
    private final String utsMonitorSessionIngressPortBitLists = fStringMap.getString("utsMonitorSessionIngressPortBitLists") + " : ";
    private final String utsMonitorSessionEngressPortBitLists = fStringMap.getString("utsMonitorSessionEngressPortBitLists") + " : ";

    public MonitorSessionControlTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsMonitorSessionID));
        tfUtsMonitorSessionID.setName(fStringMap.getString("utsMonitorSessionID"));
        baseInfoPanel.add(tfUtsMonitorSessionID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsMonitorSessionModule));
        tfUtsMonitorSessionModule.setName(fStringMap.getString("utsMonitorSessionModule"));
        baseInfoPanel.add(tfUtsMonitorSessionModule);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsMonitorSessionPort));
        tfUtsMonitorSessionPort.setName(fStringMap.getString("utsMonitorSessionPort"));
        baseInfoPanel.add(tfUtsMonitorSessionPort);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsMonitorSessionIngressPortBitLists));
        tfUtsMonitorSessionIngressPortBitLists.setName(fStringMap.getString("utsMonitorSessionIngressPortBitLists"));
        baseInfoPanel.add(tfUtsMonitorSessionIngressPortBitLists);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsMonitorSessionEngressPortBitLists));
        tfUtsMonitorSessionEngressPortBitLists.setName(fStringMap.getString("utsMonitorSessionEngressPortBitLists"));
        baseInfoPanel.add(tfUtsMonitorSessionEngressPortBitLists);
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
        tfUtsMonitorSessionID.setValueScope(1, 4);
        tfUtsMonitorSessionModule.setValueScope(1, 12);
        tfUtsMonitorSessionPort.setValueScope(1, 4);

    }

    public void refresh() {

        if (SnmpAction.IType.ADD.equals(fCommand)) {

            return;
        }

        MonitorSessionControlTableMBean mbean = (MonitorSessionControlTableMBean) getModel();

        if (SnmpAction.IType.MODIFY.equals(fCommand)) {

            tfUtsMonitorSessionID.setEditable(false);
            tfUtsMonitorSessionModule.setEditable(false);
            tfUtsMonitorSessionPort.setEditable(false);
            tfUtsMonitorSessionEngressPortBitLists.setEditable(false);
            tfUtsMonitorSessionIngressPortBitLists.setEditable(false);
        }

        tfUtsMonitorSessionID.setValue(mbean.getUtsMonitorSessionID().intValue());
        tfUtsMonitorSessionModule.setValue(mbean.getUtsMonitorSessionModule().intValue());
        tfUtsMonitorSessionPort.setValue(mbean.getUtsMonitorSessionPort().intValue());
        tfUtsMonitorSessionIngressPortBitLists.setValue(ConfigUtility.byteArrayToContractionString(mbean.getUtsMonitorSessionIngressPortBitLists()));
        tfUtsMonitorSessionEngressPortBitLists.setValue(ConfigUtility.byteArrayToContractionString(mbean.getUtsMonitorSessionEngressPortBitLists()));
    }

    public boolean validateFrom() {
        MonitorSessionControlTableMBean mbean = new MonitorSessionControlTableMBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, mbean);
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            if (mbean != null) {
                for (int i = 0; i < v.size(); i++) {
                    MonitorSessionControlTableMBean one = (MonitorSessionControlTableMBean) v.get(i);
                    if (one.getUtsMonitorSessionID().intValue() == tfUtsMonitorSessionID.getValue()) {
                        String error = fStringMap.getString("Err_Session_ID_Exist");
                        MessageDialog.showErrorMessageDialog(fApplication, error);
                        return false;
                    }
                }
            }
        }

        int cardId = tfUtsMonitorSessionModule.getValue();
        int portId = tfUtsMonitorSessionPort.getValue();
        String inPortList = tfUtsMonitorSessionIngressPortBitLists.getValue();
        String enPortList = tfUtsMonitorSessionEngressPortBitLists.getValue();
        String temp = cardId + "/" + portId;
        int[] tempInt = com.winnertel.ems.epon.util.ConfigUtility.transferPortList(temp);

        StringTokenizer intoken = new StringTokenizer(inPortList, " ");
        while (intoken.hasMoreElements()) {
            String str = intoken.nextElement().toString();
            if (!(str.startsWith("lg") || str.startsWith("ge") || startsWithNum(str))) {
                String error = fStringMap.getString("Err_Ingress_Port_List_Is_Wrong");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }

        }
        StringTokenizer etoken = new StringTokenizer(enPortList, " ");
        while (etoken.hasMoreElements()) {
            String str = etoken.nextElement().toString();
            if (!(str.startsWith("lg") || str.startsWith("ge") || startsWithNum(str))) {
                String error = fStringMap.getString("Err_Egress_Port_List_Is_Wrong");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }

        }
        int[] inArray = com.winnertel.ems.epon.util.ConfigUtility.transferPortList(inPortList);
        int[] enArray = com.winnertel.ems.epon.util.ConfigUtility.transferPortList(enPortList);

        for (int i = 0; i < inArray.length; i++) {
            if (tempInt[0] == inArray[i]) {
                String error = fStringMap.getString("Err_Ingress_Port_List_Contain_Assigned_Port");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }
        for (int i = 0; i < enArray.length; i++) {
            if (tempInt[0] == enArray[i]) {
                String error = fStringMap.getString("Err_Egress_Port_List_Contain_Assigned_Port");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }


        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new MonitorSessionControlTableMBean(fApplication.getSnmpProxy()));
        MonitorSessionControlTableMBean mbean = (MonitorSessionControlTableMBean) getModel();
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setUtsMonitorSessionID(new Integer(tfUtsMonitorSessionID.getValue()));
            mbean.setUtsMonitorSessionModule(new Integer(tfUtsMonitorSessionModule.getValue()));
            mbean.setUtsMonitorSessionPort(new Integer(tfUtsMonitorSessionPort.getValue()));
            String instr = ConfigUtility.generatePortList(new String(tfUtsMonitorSessionIngressPortBitLists.getValue()));
            for (int i = instr.length(); i <= 7; i++) {
                instr = instr + "\u0000";
            }
//            mbean.setUtsMonitorSessionIngressPortBitLists(instr);
            String enstr = ConfigUtility.generatePortList(new String(tfUtsMonitorSessionEngressPortBitLists.getValue()));
            for (int i = enstr.length(); i <= 7; i++) {
                enstr = enstr + "\u0000";
            }
//            mbean.setUtsMonitorSessionEngressPortBitLists(enstr);
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    public void afterUpdateModel() {
        GuiUtil.getParentDialog(this).dispose();

    }

    boolean startsWithNum(String str) {
        if (!(str.startsWith("lg") || str.startsWith("ge"))) {
            String[] split = str.split("/");
            if (split.length != 2)
                return false;

            //check the format like: 1-5/1-4.
            String[] cards = split[0].split("-");
            String[] ports = split[1].split("-");
            if(cards.length > 2 || ports.length > 2) return false;

            try{
              for(int i = 0; i < cards.length; i++){
                if(Integer.parseInt(cards[i]) < 1 || Integer.parseInt(cards[i]) > 12)
                  return false;
              }

              for(int i = 0; i < ports.length; i++){
                if(Integer.parseInt(ports[i]) < 1 || Integer.parseInt(ports[i]) > 4)
                  return false;
              }
            }catch(NumberFormatException e){
              return false;
            }
        }
        return true;
    }

}


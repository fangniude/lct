package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.SNTPServerTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The SNTPServerTableMBeanPanel class.
 * Created by DVM Creator
 */
public class SNTPServerTableMBeanPanel extends UPanel {

//    private IntegerTextField tfUtsSNTPServerId = new IntegerTextField();

    private JComboBox cbUtsSNTPServerId = new JComboBox();

    private IPAddressField tfUtsSNTPServerIpAddress = new IPAddressField();


//    private StringTextField tfUtsSNTPServerVersion = new StringTextField();
    private int[] utsSNTPServerVersionVlist = new int[]{1, 2, 3, 4};
    private String[] utsSNTPServerVersionTlist = new String[]{"1", "2", "3", "4"};
    private JComboBox cbSNTPServerVersion = new JComboBox(utsSNTPServerVersionTlist);

    private final String utsSNTPServerId = fStringMap.getString("utsSNTPServerId") + " : ";
    private final String utsSNTPServerIpAddress = fStringMap.getString("utsSNTPServerIpAddress") + " : ";
    private final String utsSNTPServerVersion = fStringMap.getString("utsSNTPServerVersion") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public SNTPServerTableMBeanPanel(IApplication app) {
        super(app);
        setModel(new SNTPServerTableMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SNTPServerTableMBean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());


        baseInfoPanel.add(new JLabel(utsSNTPServerId));
        cbUtsSNTPServerId.setName(fStringMap.getString("utsSNTPServerId"));
        baseInfoPanel.add(cbUtsSNTPServerId);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSNTPServerIpAddress));
        tfUtsSNTPServerIpAddress.setName(fStringMap.getString("utsSNTPServerIpAddress"));
        baseInfoPanel.add(tfUtsSNTPServerIpAddress);
        baseInfoPanel.add(new HSpacer());


//        baseInfoPanel.add(new JLabel(utsSNTPServerState));
////        baseInfoPanel.add(tfUtsSNTPServerState);
//        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSNTPServerVersion));
        cbSNTPServerVersion.setName(fStringMap.getString("utsSNTPServerVersion"));
        baseInfoPanel.add(cbSNTPServerVersion);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

//        add(buttonsPanel, BorderLayout.SOUTH);


    }

    protected void initForm() {


    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            SNTPServerTableMBean mbean = new SNTPServerTableMBean(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            cbUtsSNTPServerId.removeAllItems();
            cbUtsSNTPServerId.addItem("1");
            cbUtsSNTPServerId.addItem("2");
            cbUtsSNTPServerId.addItem("3");

            for(int i = 0; v!= null && i < v.size(); i++)
            {
              SNTPServerTableMBean one = (SNTPServerTableMBean) v.get(i);
              cbUtsSNTPServerId.removeItem("" + one.getUtsSNTPServerId());
            }
         }
         else if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            SNTPServerTableMBean mbean = (SNTPServerTableMBean) getModel();
            BeanService.refreshBean(fApplication, mbean);
            cbUtsSNTPServerId.removeAllItems();
            cbUtsSNTPServerId.addItem(mbean.getUtsSNTPServerId());
            cbUtsSNTPServerId.setEnabled(false);
            cbUtsSNTPServerId.setSelectedItem(mbean.getUtsSNTPServerId());
            tfUtsSNTPServerIpAddress.setValue(mbean.getUtsSNTPServerIpAddress());

            cbSNTPServerVersion.setSelectedIndex(getIndexFromValue(utsSNTPServerVersionVlist, Integer.parseInt(mbean.getUtsSNTPServerVersion())));
        }
    }

    public boolean validateFrom() {

      if(cbUtsSNTPServerId.getSelectedItem() == null)
      {
        String error = fStringMap.getString("Err_SNTP_Server_Id_Is_Null");
        MessageDialog.showErrorMessageDialog(fApplication, error);
        return false;
      }
      
		int rowcount = ((SnmpTable) this.getTable()).getRowCount();
		String ipaddress = tfUtsSNTPServerIpAddress.getIPString();
		
		if (SnmpAction.IType.MODIFY.equals(fCommand)) {
			SNTPServerTableMBean mbean = (SNTPServerTableMBean) getModel();
			if(mbean.getUtsSNTPServerIpAddress().equalsIgnoreCase(tfUtsSNTPServerIpAddress.getIPString())) {
				return true;
			}
		}
		
		for (int i = 0; i < rowcount; i++) {
			if (((SnmpTable) this.getTable()).getValueAt(i, 1).toString()
					.equals(ipaddress)) {
				MessageDialog.showInfoMessageDialog(fApplication, fStringMap
						.getString("Err_SNTP_Server_Id_Is_Exist"));
				return false;
			}
		}

      return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new SNTPServerTableMBean(fApplication.getSnmpProxy()));

        SNTPServerTableMBean mbean = (SNTPServerTableMBean) getModel();

        mbean.setUtsSNTPServerId(Integer.valueOf(cbUtsSNTPServerId.getSelectedItem().toString()));
        mbean.setUtsSNTPServerIpAddress(new String(tfUtsSNTPServerIpAddress.getIPString()));

        mbean.setUtsSNTPServerVersion(String.valueOf(utsSNTPServerVersionVlist[cbSNTPServerVersion.getSelectedIndex()]));
    }

    public void afterUpdateModel() {
      refresh();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

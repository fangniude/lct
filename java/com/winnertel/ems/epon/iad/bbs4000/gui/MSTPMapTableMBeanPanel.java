package com.winnertel.ems.epon.iad.bbs4000.gui;


/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.MSTPMapTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.PortBasedVLAN;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The MSTPMapTableMBeanPanel class.
 * Created by DVM Creator
 */
public class MSTPMapTableMBeanPanel extends UPanel {

    private IntegerTextField tfMstpMapMISTID = new IntegerTextField();

    private JComboBox cbMstpMapVlanRangeIndex = new JComboBox();
    
    private IntegerTextField tfMstpMapVlanMin = new IntegerTextField();

    private IntegerTextField tfMstpMapVlanMax = new IntegerTextField();

    private final String mstpMapMSTiID = fStringMap.getString("mstpMapMSTiID") + " : ";
    private final String mstpMapVlanMin = fStringMap.getString("mstpMapVlanMin") + " : ";
    private final String mstpMapVlanMax = fStringMap.getString("mstpMapVlanMax") + " : ";
    private final String mstpMapVlanRangeIndex = fStringMap.getString("mstpMapVlanRangeIndex");

    public MSTPMapTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(mstpMapMSTiID));
        tfMstpMapMISTID.setName(fStringMap.getString("mstpMapMSTiID"));
        baseInfoPanel.add(tfMstpMapMISTID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpMapVlanRangeIndex));
        cbMstpMapVlanRangeIndex.setName(fStringMap.getString("mstpMapVlanRangeIndex"));
        baseInfoPanel.add(cbMstpMapVlanRangeIndex);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(mstpMapVlanMin));
        tfMstpMapVlanMin.setName(fStringMap.getString("mstpMapVlanMin"));
        baseInfoPanel.add(tfMstpMapVlanMin);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(mstpMapVlanMax));
        tfMstpMapVlanMax.setName(fStringMap.getString("mstpMapVlanMax"));
        baseInfoPanel.add(tfMstpMapVlanMax);
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
        tfMstpMapMISTID.setValueScope(1,15);

        tfMstpMapVlanMin.setValueScope(1, 4094);

        tfMstpMapVlanMax.setValueScope(1, 4094);


    }

    public void getCBIndexItems(){
    	cbMstpMapVlanRangeIndex.removeAllItems();
    	PortBasedVLAN mbean = new PortBasedVLAN(fApplication.getSnmpProxy());
         Vector v = BeanService.refreshTableBean(fApplication, mbean);
         if(v!=null){
         	for(int i=0;i<v.size();i++){
         		PortBasedVLAN one = (PortBasedVLAN)v.get(i);
         		cbMstpMapVlanRangeIndex.addItem(one.getUtsLagExtDot1qVlanIndex());
         	}
         }
    	
    }
    public void refresh() {
//    	getCBIndexItems();
        if (SnmpAction.IType.ADD.equals(fCommand)){
        	cbMstpMapVlanRangeIndex.setEnabled(false);
        	return;
        }
        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
            tfMstpMapMISTID.setEditable(false);
            cbMstpMapVlanRangeIndex.setEnabled(false);
        }
        
        MSTPMapTableMBean mbean = (MSTPMapTableMBean) getModel();
//        cbMstpMapVlanRangeIndex.setSelectedItem(mbean.getMstpMapVlanRangeIndex());
        cbMstpMapVlanRangeIndex.addItem(mbean.getMstpMapVlanRangeIndex());
        tfMstpMapMISTID.setValue(mbean.getMstpMapMSTiID().intValue());
        tfMstpMapVlanMin.setValue(mbean.getMstpMapVlanMin().intValue());
        tfMstpMapVlanMax.setValue(mbean.getMstpMapVlanMax().intValue());

    }
    public boolean validateFrom(){
      if (SnmpAction.IType.ADD.equals(fCommand))
      {
        MSTPMapTableMBean mbean = new MSTPMapTableMBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication,mbean);
        if(v!=null){
            for(int i=0;i<v.size();i++){
                MSTPMapTableMBean one = (MSTPMapTableMBean)v.get(i);
//                if(one.getMstpMapVlanRangeIndex().equals(cbMstpMapVlanRangeIndex.getSelectedItem()))
//                if(one.getMstpMapMSTiID().intValue() == (tfMstpMapMISTID.getValue()) ){
//                    String error = fStringMap.getString("Err_MIST_ID_Exist");
//                    MessageDialog.showErrorMessageDialog(fApplication,error);
//                    return false;
//                }
                if((one.getMstpMapMSTiID().intValue() == (tfMstpMapMISTID.getValue()))
                		&& one.getMstpMapVlanMin().intValue() == tfMstpMapVlanMin.getValue()
                		&& one.getMstpMapVlanMax().intValue() == tfMstpMapVlanMax.getValue()) {
                	String error = fStringMap.getString("Err_MIST_ID_Exist");
                	MessageDialog.showErrorMessageDialog(fApplication,error);
                	return false;
                }
                	
            }
        }
      }
      
      return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new MSTPMapTableMBean(fApplication.getSnmpProxy()));

        MSTPMapTableMBean mbean = (MSTPMapTableMBean) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setMstpMapMSTiID(new Integer(tfMstpMapMISTID.getValue()));
//            mbean.setMstpMapVlanRangeIndex(Integer.parseInt((cbMstpMapVlanRangeIndex.getSelectedItem().toString())));
            mbean.setMstpMapVlanRangeIndex(new Integer(tfMstpMapVlanMin.getValue()));
        }


        mbean.setMstpMapVlanMin(new Integer(tfMstpMapVlanMin.getValue()));
        mbean.setMstpMapVlanMax(new Integer(tfMstpMapVlanMax.getValue()));
//         mbean.setMstpMapRowStatus(new Integer(mstpMapRowStatusVList[tfMstpMapRowStatus.getSelectedIndex()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

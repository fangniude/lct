/**
 * Title          :   OnuVlanIdVlanPriBitUpTrafficMapProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.MultiItemSelector;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanIdVlanPriBitUpTrafficMapProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * @author Shen Dayong
 *         Create on 2008-10-2
 *         Modify by HZ21044
 */

public class OnuVlanIdVlanPriBitUpTrafficMapProfTablePanel extends UPanel {

//    private LongIndexGenField tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField  tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex = new IndexAutoGenField(fApplication,2);
    private StringTextField tfOnuVlanIdVlanPriBitUpTrafficMapProfileName = new StringTextField();

    private LongTextField tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart =
            new LongTextField();

    private LongTextField tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop =
            new LongTextField();

    
    private MultiItemSelector tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap = new MultiItemSelector();

    private JComboBox tfOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo =
            new JComboBox();


    private final String onuVlanIdVlanPriBitUpTrafficMapProfIndex1 =
            fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfIndex1") + " : ";
    private final String onuVlanIdVlanPriBitUpTrafficMapProfIndex2 =
            fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfIndex2") + " : ";
    private final String onuVlanIdVlanPriBitUpTrafficMapProfileName =
            fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfileName") + " : ";
    private final String onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart =
            fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart") + " : ";
    private final String onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop =
            fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop") + " : ";
    private final String onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap =
            fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap") + " : ";
    private final String onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo =
            fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo") + " : ";
    private VlanPriorityBitMapModel model = new VlanPriorityBitMapModel();
    
    public OnuVlanIdVlanPriBitUpTrafficMapProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuVlanIdVlanPriBitUpTrafficMapProfIndex1));
        baseInfoPanel.add(tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdVlanPriBitUpTrafficMapProfIndex2));
        baseInfoPanel.add(tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdVlanPriBitUpTrafficMapProfileName));
        baseInfoPanel.add(tfOnuVlanIdVlanPriBitUpTrafficMapProfileName);
        tfOnuVlanIdVlanPriBitUpTrafficMapProfileName.setValue("New Profile");
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart));
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart.setName(fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart"));
        baseInfoPanel.add(tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop));
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop.setName(fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop"));
        baseInfoPanel.add(tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap));
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap.setName(fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap"));
        baseInfoPanel.add(tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo));
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo.setName(fStringMap.getString("onuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo"));
        baseInfoPanel.add(tfOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(int i=1;i<=40;i++){
        	tfOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo.addItem(i);
        }

    }

    protected void initForm() {
        tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.setValueScope(0,2, 128);
        tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.setValueScope(1,1, 127);
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart.setValueScope(1, 4095);
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart.setValue(101);
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop.setValueScope(1, 4095);
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop.setValue(101);

    }

    public boolean validateFrom() {
        long start = tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart.getValue();
        long end = tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop.getValue();
        if (end - start > 11) {
            String msg = fStringMap.getString("error_vlanId_start_end");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
            return false;
        }
//        if(tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap.getSelectedChoices().size() < 1)
//        {
//          MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_VlanPriorityBitMap_Not_Selected"));
//          return false;
//        }
//        
        SnmpMibBean beans = new OnuVlanIdVlanPriBitUpTrafficMapProfTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, beans);
        Vector selected = tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap.getSelectedChoices();
        long newVlanPriority = model.priorityBitMapToLong(selected);
        for (int i = 0; i < v.size(); i++) {
        	OnuVlanIdVlanPriBitUpTrafficMapProfTable bean = (OnuVlanIdVlanPriBitUpTrafficMapProfTable)v.get(i);
        	if(tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.getValue(0)==bean.getOnuVlanIdVlanPriBitUpTrafficMapProfIndex1()&&tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.getValue(1)==bean.getOnuVlanIdVlanPriBitUpTrafficMapProfIndex2())
        	    continue;
        	long vlanPriority = bean.getOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap();
        if(newVlanPriority==vlanPriority){
        	if(!tfOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo.getSelectedItem().equals(bean.getOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo())){
        	MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("VlanPriority_VP_Conflict"));
            return false;
            }
        }
        }
        
        return true;
    }

    public void refresh() {
    	tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap.setSelectionChoices(model.getPriorityBitMap());
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.setEnabled(true);
            tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.setTable(fTable);
            tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.refresh();
            tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap.setSelectedChoices(model.priorityBitMapToVector(1));
            return;
        } else {
            tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.setEnabled(false);
        }
        OnuVlanIdVlanPriBitUpTrafficMapProfTable mbean =
                (OnuVlanIdVlanPriBitUpTrafficMapProfTable) getModel();
        
        Vector<String> selected_priorityBitMap = model.priorityBitMapToVector(mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap()); 
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap.setSelectedChoices(selected_priorityBitMap);
        
        tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.setValue(0,mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfIndex1());
        tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.setValue(1,mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfIndex2());
        tfOnuVlanIdVlanPriBitUpTrafficMapProfileName.setValue(mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfileName());
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart.setValue(mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart().intValue());
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop.setValue(mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop().intValue());
        tfOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo.setSelectedItem((mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuVlanIdVlanPriBitUpTrafficMapProfTable(fApplication.getSnmpProxy()));

        OnuVlanIdVlanPriBitUpTrafficMapProfTable mbean = (OnuVlanIdVlanPriBitUpTrafficMapProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuVlanIdVlanPriBitUpTrafficMapProfIndex1(tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.getValue(0));
            mbean.setOnuVlanIdVlanPriBitUpTrafficMapProfIndex2(tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.getValue(1));
        }
        Vector selected = tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap.getSelectedChoices();
        mbean.setOnuVlanIdVlanPriBitUpTrafficMapProfVlanPriorityBitMap(new Long(model.priorityBitMapToLong(selected)));
        mbean.setOnuVlanIdVlanPriBitUpTrafficMapProfileName(new String(tfOnuVlanIdVlanPriBitUpTrafficMapProfileName.getValue()));
        mbean.setOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart(new Long(tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStart.getValue()));
        mbean.setOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop(new Long(tfOnuVlanIdVlanPriBitUpTrafficMapProfVlanIDStop.getValue()));
        mbean.setOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo(Integer.parseInt((tfOnuVlanIdVlanPriBitUpTrafficMapProfVirtualPortNo.getSelectedItem().toString())));
    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuVlanIdVlanPriBitUpTrafficMapProfIndex.increaseIndexValue();
    }
    
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
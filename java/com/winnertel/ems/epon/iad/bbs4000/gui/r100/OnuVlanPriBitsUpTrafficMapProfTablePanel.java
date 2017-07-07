/**
 * Title          :   OnuVlanPriBitsUpTrafficMapProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.MultiItemSelector;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanPriBitsUpTrafficMapProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
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

public class OnuVlanPriBitsUpTrafficMapProfTablePanel extends UPanel {

//    private LongIndexGenField tfOnuVlanPriBitsUpTrafficMapProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOnuVlanPriBitsUpTrafficMapProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField tfOnuVlanPriBitsUpTrafficMapProfIndex = new IndexAutoGenField(fApplication,2);
    

    private StringTextField tfOnuVlanPriBitsUpTrafficMapProfileName = new StringTextField();


    private MultiItemSelector tfOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap = new MultiItemSelector();


    private JComboBox tfOnuVlanPriBitsUpTrafficMapProfVirtualPortNo = new JComboBox();

    private final String onuVlanPriBitsUpTrafficMapProfIndex1 =
            fStringMap.getString("onuVlanPriBitsUpTrafficMapProfIndex1") + " : ";
    private final String onuVlanPriBitsUpTrafficMapProfIndex2 =
            fStringMap.getString("onuVlanPriBitsUpTrafficMapProfIndex2") + " : ";
    private final String onuVlanPriBitsUpTrafficMapProfileName =
            fStringMap.getString("onuVlanPriBitsUpTrafficMapProfileName") + " : ";
    private final String onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap =
            fStringMap.getString("onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap") + " : ";
    private final String onuVlanPriBitsUpTrafficMapProfVirtualPortNo =
            fStringMap.getString("onuVlanPriBitsUpTrafficMapProfVirtualPortNo") + " : ";
    
    private VlanPriorityBitMapModel model = new VlanPriorityBitMapModel();
    public OnuVlanPriBitsUpTrafficMapProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuVlanPriBitsUpTrafficMapProfIndex1));
        baseInfoPanel.add(tfOnuVlanPriBitsUpTrafficMapProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanPriBitsUpTrafficMapProfIndex2));
        baseInfoPanel.add(tfOnuVlanPriBitsUpTrafficMapProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanPriBitsUpTrafficMapProfileName));
        tfOnuVlanPriBitsUpTrafficMapProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuVlanPriBitsUpTrafficMapProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap));
        tfOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap.setName(fStringMap.getString("onuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap"));
        baseInfoPanel.add(tfOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanPriBitsUpTrafficMapProfVirtualPortNo));
        tfOnuVlanPriBitsUpTrafficMapProfVirtualPortNo.setName(fStringMap.getString("onuVlanPriBitsUpTrafficMapProfVirtualPortNo"));
        baseInfoPanel.add(tfOnuVlanPriBitsUpTrafficMapProfVirtualPortNo);
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
        	tfOnuVlanPriBitsUpTrafficMapProfVirtualPortNo.addItem(i);
        }
    }

    protected void initForm() {
        tfOnuVlanPriBitsUpTrafficMapProfIndex.setValueScope(0,2, 128);
        tfOnuVlanPriBitsUpTrafficMapProfIndex.setValueScope(1,1, 7);
        
    }

    public void refresh() {
    	 tfOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap.setSelectionChoices(model.getPriorityBitMap());
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuVlanPriBitsUpTrafficMapProfIndex.setEnabled(true);
            tfOnuVlanPriBitsUpTrafficMapProfIndex.setTable(fTable);
            tfOnuVlanPriBitsUpTrafficMapProfIndex.refresh();
            tfOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap.setSelectedChoices(model.priorityBitMapToVector(1));
            return;
        } else {
            tfOnuVlanPriBitsUpTrafficMapProfIndex.setEnabled(false);
        }
        OnuVlanPriBitsUpTrafficMapProfTable mbean =
                (OnuVlanPriBitsUpTrafficMapProfTable) getModel();
        Vector<String> selected_priorityBitMap = model.priorityBitMapToVector(mbean.getOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap()); 
        tfOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap.setSelectedChoices(selected_priorityBitMap);
        String sValue = "";
        int iValue = 0;
        long lValue = 0;

        tfOnuVlanPriBitsUpTrafficMapProfIndex.setValue(0,mbean.getOnuVlanPriBitsUpTrafficMapProfIndex1());
        tfOnuVlanPriBitsUpTrafficMapProfIndex.setValue(1,mbean.getOnuVlanPriBitsUpTrafficMapProfIndex2());

        try {
            sValue = mbean.getOnuVlanPriBitsUpTrafficMapProfileName();
        } catch (Exception e) {
            sValue = "";
        }
        tfOnuVlanPriBitsUpTrafficMapProfileName.setText(sValue);


        try {
            iValue = mbean.getOnuVlanPriBitsUpTrafficMapProfVirtualPortNo().intValue();
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuVlanPriBitsUpTrafficMapProfVirtualPortNo.setSelectedItem(iValue);
    }
    
    public boolean validateFrom() {
        
        SnmpMibBean beans = new OnuVlanPriBitsUpTrafficMapProfTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, beans);
        Vector selected = tfOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap.getSelectedChoices();
        int newVlanPriority = model.priorityBitMapToLong(selected);
        for (int i = 0; i < v.size(); i++) {
        	OnuVlanPriBitsUpTrafficMapProfTable bean = (OnuVlanPriBitsUpTrafficMapProfTable)v.get(i);
        	if(tfOnuVlanPriBitsUpTrafficMapProfIndex.getValue(0)==bean.getOnuVlanPriBitsUpTrafficMapProfIndex1()&&tfOnuVlanPriBitsUpTrafficMapProfIndex.getValue(1)==bean.getOnuVlanPriBitsUpTrafficMapProfIndex2())
        	    continue;
        	long vlanPriority = bean.getOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap();
        	if(newVlanPriority==vlanPriority){
        	if(!tfOnuVlanPriBitsUpTrafficMapProfVirtualPortNo.getSelectedItem().equals(bean.getOnuVlanPriBitsUpTrafficMapProfVirtualPortNo()))
        	{
        	MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("VlanPriority_VP_Conflict"));
            return false;
            }
        }
        }

        return true;
      }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuVlanPriBitsUpTrafficMapProfTable(fApplication.getSnmpProxy()));

        OnuVlanPriBitsUpTrafficMapProfTable mbean = (OnuVlanPriBitsUpTrafficMapProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setOnuVlanPriBitsUpTrafficMapProfIndex1(tfOnuVlanPriBitsUpTrafficMapProfIndex.getValue(0));
            mbean.setOnuVlanPriBitsUpTrafficMapProfIndex2(tfOnuVlanPriBitsUpTrafficMapProfIndex.getValue(1));
        }
        mbean.setOnuVlanPriBitsUpTrafficMapProfileName(tfOnuVlanPriBitsUpTrafficMapProfileName.getValue());
        mbean.setOnuVlanPriBitsUpTrafficMapProfVirtualPortNo(Integer.parseInt(tfOnuVlanPriBitsUpTrafficMapProfVirtualPortNo.getSelectedItem().toString()));
        Vector selected = tfOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap.getSelectedChoices();
        mbean.setOnuVlanPriBitsUpTrafficMapProfVlanPriorityBitMap(new Long(model.priorityBitMapToLong(selected)));
    }

    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuVlanPriBitsUpTrafficMapProfIndex.increaseIndexValue();
    }
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.QueueModeWeightField;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuMLSQosExtCosQueueSchedTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The OnuMLSQosExtCosQueueSchedTablePanel class.
 * Created by DVM Creator
 */
public class OnuMLSQosExtCosQueueSchedTablePanel extends UPanel {

    private JComboBox tfOnuMLSQosExtCosQueueSchedSlotNo = new JComboBox();
    private JComboBox tfOnuMLSQosExtCosQueueSchedPortNo = new JComboBox();
    private JComboBox tfOnuMLSQosExtCosQueueSchedLogicalPortNo = new JComboBox();

    private StringTextField tfOnuMLSQosExtCosQueueSchedWeight = new StringTextField();

//    private int[] onuMLSQosExtCosQueueSchedModeVList = new int[] { 1, 3, 2, };
//    private String[] onuMLSQosExtCosQueueSchedModeTList = new String[] { fStringMap.getString("sp"),
//            fStringMap.getString("spwrr"), fStringMap.getString("wrr"), };
    private QueueModeWeightField weightPanel = new QueueModeWeightField(fApplication);
//    private JComboBox tfOnuMLSQosExtCosQueueSchedMode = new JComboBox(onuMLSQosExtCosQueueSchedModeTList);

    private final String onuMLSQosExtCosQueueSchedSlotNo = fStringMap.getString("onuMLSQosExtCosQueueSchedSlotNo")
            + " : ";
    private final String onuMLSQosExtCosQueueSchedPortNo = fStringMap.getString("onuMLSQosExtCosQueueSchedPortNo")
            + " : ";
    private final String onuMLSQosExtCosQueueSchedLogicalPortNo = fStringMap
            .getString("onuMLSQosExtCosQueueSchedLogicalPortNo")
            + " : ";
    private final String onuMLSQosExtCosQueueSchedWeight = fStringMap.getString("onuMLSQosExtCosQueueSchedWeight")
            + " : ";
    private final String onuMLSQosExtCosQueueSchedMode = fStringMap.getString("onuMLSQosExtCosQueueSchedMode") + " : ";
    private BBS4000NE ne = null;
    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public OnuMLSQosExtCosQueueSchedTablePanel(IApplication app) {
        super(app);
        setModel(new OnuMLSQosExtCosQueueSchedTable(app.getSnmpProxy()));
        ne = new BBS4000NE(fApplication);
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_OnuMLSQosExtCosQueueSchedTable");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        
        baseInfoPanel.add(new JLabel(onuMLSQosExtCosQueueSchedSlotNo));
        tfOnuMLSQosExtCosQueueSchedSlotNo.setName(fStringMap.getString("onuMLSQosExtCosQueueSchedSlotNo"));
        baseInfoPanel.add(tfOnuMLSQosExtCosQueueSchedSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMLSQosExtCosQueueSchedPortNo));
        tfOnuMLSQosExtCosQueueSchedPortNo.setName(fStringMap.getString("onuMLSQosExtCosQueueSchedPortNo"));
        baseInfoPanel.add(tfOnuMLSQosExtCosQueueSchedPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMLSQosExtCosQueueSchedLogicalPortNo));
        tfOnuMLSQosExtCosQueueSchedLogicalPortNo
                .setName(fStringMap.getString("onuMLSQosExtCosQueueSchedLogicalPortNo"));
        baseInfoPanel.add(tfOnuMLSQosExtCosQueueSchedLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMLSQosExtCosQueueSchedMode));
        baseInfoPanel.add(weightPanel.getModePanel());
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(onuMLSQosExtCosQueueSchedWeight));
        baseInfoPanel.add(weightPanel.getWeightPanel());
        baseInfoPanel.add(new HSpacer());
        
        

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);

    }

    protected void initForm() {
        
    }

    public void refresh() {
        
        //Slot
        tfOnuMLSQosExtCosQueueSchedSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuMLSQosExtCosQueueSchedSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuMLSQosExtCosQueueSchedSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } 
        }
        //Port
        tfOnuMLSQosExtCosQueueSchedPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuMLSQosExtCosQueueSchedPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuMLSQosExtCosQueueSchedLogicalPortNo.removeAllItems();
        int count = ne.getPonSplitRatio();
        for (int i = 1; i <= count; i++) {
            tfOnuMLSQosExtCosQueueSchedLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }
        //-------------------

        OnuMLSQosExtCosQueueSchedTable mbean = (OnuMLSQosExtCosQueueSchedTable) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfOnuMLSQosExtCosQueueSchedSlotNo.setSelectedItem((mbean.getOnuMLSQosExtCosQueueSchedSlotNo() != null) ? mbean.getOnuMLSQosExtCosQueueSchedSlotNo().toString() : "");
        tfOnuMLSQosExtCosQueueSchedPortNo.setSelectedItem((mbean.getOnuMLSQosExtCosQueueSchedPortNo() != null) ? mbean.getOnuMLSQosExtCosQueueSchedPortNo().toString() : "");
        tfOnuMLSQosExtCosQueueSchedLogicalPortNo.setSelectedItem((mbean.getOnuMLSQosExtCosQueueSchedLogicalPortNo() != null) ? mbean.getOnuMLSQosExtCosQueueSchedLogicalPortNo().toString() : "");
        weightPanel.setModeValue(mbean.getOnuMLSQosExtCosQueueSchedMode()!=null? mbean.getOnuMLSQosExtCosQueueSchedMode().intValue():0);
        weightPanel.setWeightEnabled(mbean.getOnuMLSQosExtCosQueueSchedMode()!=null&&mbean.getOnuMLSQosExtCosQueueSchedMode() != 1);
        if(mbean.getOnuMLSQosExtCosQueueSchedWeight()!=null)
        weightPanel.setWeightValue(mbean.getOnuMLSQosExtCosQueueSchedWeight());

    }

    public void updateModel() {

        OnuMLSQosExtCosQueueSchedTable mbean = (OnuMLSQosExtCosQueueSchedTable) getModel();

        mbean.setOnuMLSQosExtCosQueueSchedSlotNo(getSelectedSlotId());
        mbean.setOnuMLSQosExtCosQueueSchedPortNo(getSelectedPortId());
        mbean.setOnuMLSQosExtCosQueueSchedLogicalPortNo(getSelectedOnuId());
        if(weightPanel.isWeightEnabled())
        mbean.setOnuMLSQosExtCosQueueSchedWeight(weightPanel.getWeightValue());
        mbean.setOnuMLSQosExtCosQueueSchedMode(weightPanel.getModeValue());

    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }
    
    public int getSelectedSlotId() {
        if (tfOnuMLSQosExtCosQueueSchedSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuMLSQosExtCosQueueSchedSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuMLSQosExtCosQueueSchedPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuMLSQosExtCosQueueSchedPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuMLSQosExtCosQueueSchedLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuMLSQosExtCosQueueSchedLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

}

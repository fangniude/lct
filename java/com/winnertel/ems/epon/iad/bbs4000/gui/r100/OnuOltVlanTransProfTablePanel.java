package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

/**
 * Title          :   OnuOltVlanTransProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */


import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuOltVlanTransProfTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;



public class OnuOltVlanTransProfTablePanel extends UPanel {
    
    private JComboBox tfOnuOltVlanTransProfSlotNo = new JComboBox();
    private JComboBox tfOnuOltVlanTransProfPortNo = new JComboBox();
    private JComboBox tfOnuOltVlanTransProfLogicalPortNo = new JComboBox();
    private JComboBox tfOnuOltVlanTransProfOnuUniPortNo = new JComboBox();
    private LongTextField tfOnuOltVlanTransProfIndex1 = new LongTextField();
    private LongTextField tfOnuOltVlanTransProfIndex2 = new LongTextField();
    private StringTextField tfOnuOltVlanTransProfileName = new StringTextField();

    private int[] onuOltVlanTransProfDownstreamModeVList = new int[]{0, 1};
    private String[] onuOltVlanTransProfDownstreamModeTList = new String[]{fStringMap.getString("operation"), fStringMap.getString("no-operation")};
    private JComboBox tfOnuOltVlanTransProfDownstreamMode = new JComboBox(onuOltVlanTransProfDownstreamModeTList);

    private HexTextField tfOnuOltVlanTransProfInputTPID = new HexTextField();
    private HexTextField tfOnuOltVlanTransProfOutputTPID = new HexTextField();
    
    private long[] onuOltVlanTransProfFilterOuterPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,14,15};
    private String[] onuOltVlanTransProfFilterOuterPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","14","15"};
    private JComboBox tfOnuOltVlanTransProfFilterOuterPriority = new JComboBox(onuOltVlanTransProfFilterOuterPriorityTList);
    
    private LongTextField tfOnuOltVlanTransProfFilterOuterVID = new LongTextField();

    private int[] onuOltVlanTransProfFilterOuterTPIDDEVList = new int[]{0, 4, 5, 6, 7};
    private String[] onuOltVlanTransProfFilterOuterTPIDDETList = new String[]{fStringMap.getString("no-filter"), fStringMap.getString("outer-TPID-8100")
            , fStringMap.getString("input-TPID"), fStringMap.getString("input-TPID-DE-0"), fStringMap.getString("input-TPID-DE-1")};
    private JComboBox tfOnuOltVlanTransProfFilterOuterTPIDDE = new JComboBox(onuOltVlanTransProfFilterOuterTPIDDETList);

    private long[] onuOltVlanTransProfFilterInnerPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,14,15};
    private String[] onuOltVlanTransProfFilterInnerPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","14","15"};
    private JComboBox tfOnuOltVlanTransProfFilterInnerPriority = new JComboBox(onuOltVlanTransProfFilterInnerPriorityTList);
    
    private LongTextField tfOnuOltVlanTransProfFilterInnerVID = new LongTextField();
    private int[] onuOltVlanTransProfFilterInnerTPIDDEVList = new int[]{0, 4, 5, 6, 7};
    private String[] onuOltVlanTransProfFilterInnerTPIDDETList = new String[]{fStringMap.getString("no-filter"), fStringMap.getString("outer-TPID-8100")
            , fStringMap.getString("input-TPID"), fStringMap.getString("input-TPID-DE-0"), fStringMap.getString("input-TPID-DE-1")};
    private JComboBox tfOnuOltVlanTransProfFilterInnerTPIDDE = new JComboBox(onuOltVlanTransProfFilterInnerTPIDDETList);

    private int[] onuOltVlanTransProfFilterEthertypeVList = new int[]{0,1,2,3};

    private String[] onuOltVlanTransProfFilterEthertypeTList = new String[]{fStringMap.getString("Don't filter on Ethertype"),
            fStringMap.getString("filter IPoE frames"),fStringMap.getString("filter PPPoE frames"),fStringMap.getString("filter ARP frames")};
    private JComboBox tfOnuOltVlanTransProfFilterEthertype = new JComboBox(onuOltVlanTransProfFilterEthertypeTList);

    private int[] onuOltVlanTransProfTreatmentTagsRemoveVList = new int[]{1, 2, 3, 4};
    private String[] onuOltVlanTransProfTreatmentTagsRemoveTList = new String[]{fStringMap.getString("do-not-remove"), fStringMap.getString("remove-outer-tag"),fStringMap.getString("remove-inner-tag"), fStringMap.getString("remove-all")};
    private JComboBox tfOnuOltVlanTransProfTreatmentTagsRemove = new JComboBox(onuOltVlanTransProfTreatmentTagsRemoveTList);

    private long[] onuOltVlanTransProfTreatmentOuterPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,9,15};
    private String[] onuOltVlanTransProfTreatmentOuterPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","9","15"};
    private JComboBox tfOnuOltVlanTransProfTreatmentOuterPriority = new JComboBox(onuOltVlanTransProfTreatmentOuterPriorityTList);
    
    private LongTextField tfOnuOltVlanTransProfTreatmentOuterVID = new LongTextField();
    private int[] onuOltVlanTransProfTreatmentOuterTPIDDEVList = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private String[] onuOltVlanTransProfTreatmentOuterTPIDDETList = new String[]{fStringMap.getString("copy-tpid-inner"),
            fStringMap.getString("copy-tpid-outer"), fStringMap.getString("set-tpid-output-copy-de-inner"), fStringMap.getString("set-tpid-output-copy-de-outer"),
            fStringMap.getString("set-tpid-0x8100"), fStringMap.getString("reserved"), fStringMap.getString("set-tpid-output-de-0"), fStringMap.getString("set-tpid-output-de-1")};
    private JComboBox tfOnuOltVlanTransProfTreatmentOuterTPIDDE = new JComboBox(onuOltVlanTransProfTreatmentOuterTPIDDETList);

    private long[] onuOltVlanTransProfTreatmentInnerPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,9,15};
    private String[] onuOltVlanTransProfTreatmentInnerPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","9","15"};
    private JComboBox tfOnuOltVlanTransProfTreatmentInnerPriority = new JComboBox(onuOltVlanTransProfTreatmentInnerPriorityTList);
    
    private LongTextField tfOnuOltVlanTransProfTreatmentInnerVID = new LongTextField();
    private int[] onuOltVlanTransProfTreatmentInnerTPIDDEVList = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private String[] onuOltVlanTransProfTreatmentInnerTPIDDETList = new String[]{fStringMap.getString("copy-tpid-inner"),
            fStringMap.getString("copy-tpid-outer"), fStringMap.getString("set-tpid-output-copy-de-inner"), fStringMap.getString("set-tpid-output-copy-de-outer"),
            fStringMap.getString("set-tpid-0x8100"), fStringMap.getString("reserved"), fStringMap.getString("set-tpid-output-de-0"), fStringMap.getString("set-tpid-output-de-1")};
    private JComboBox tfOnuOltVlanTransProfTreatmentInnerTPIDDE = new JComboBox(onuOltVlanTransProfTreatmentInnerTPIDDETList);

    private int[] onuOltVlanTransProfTreatmentTagsModeVList = new int[]{1, 2, 3, 4};
    private String[] onuOltVlanTransProfTreatmentTagsModeTList = new String[]{fStringMap.getString("sit"), fStringMap.getString("sot")
            , fStringMap.getString("dt"), fStringMap.getString("unknown")};
    private JComboBox tfOnuOltVlanTransProfTreatmentTagsMode = new JComboBox(onuOltVlanTransProfTreatmentTagsModeTList);
    private BBS4000NE ne = null;
    private final String onuOltVlanTransProfOnuUniPortNo = fStringMap.getString("onuOltVlanTransProfOnuUniPortNo") + " : ";
    private final String onuOltVlanTransProfSlotNo = fStringMap.getString("onuOltVlanTransProfSlotNo") + " : ";
    private final String onuOltVlanTransProfPortNo = fStringMap.getString("onuOltVlanTransProfPortNo") + " : ";
    private final String onuOltVlanTransProfLogicalPortNo = fStringMap.getString("onuOltVlanTransProfLogicalPortNo") + " : ";
    private final String onuOltVlanTransProfIndex1 =
            fStringMap.getString("onuOltVlanTransProfIndex1") + " : ";
    private final String onuOltVlanTransProfIndex2 = fStringMap.getString("onuOltVlanTransProfIndex2");
    private final String onuOltVlanTransProfileName =
            fStringMap.getString("onuOltVlanTransProfileName") + " : ";
    private final String onuOltVlanTransProfDownstreamMode =
            fStringMap.getString("onuOltVlanTransProfDownstreamMode") + " : ";
    private final String onuOltVlanTransProfInputTPID =
            fStringMap.getString("onuOltVlanTransProfInputTPID") + " : ";
    private final String onuOltVlanTransProfOutputTPID =
            fStringMap.getString("onuOltVlanTransProfOutputTPID") + " : ";
    private final String onuOltVlanTransProfFilterOuterPriority =
            fStringMap.getString("onuOltVlanTransProfFilterOuterPriority") + " : ";
    private final String onuOltVlanTransProfFilterOuterVID =
            fStringMap.getString("onuOltVlanTransProfFilterOuterVID") + " : ";
    private final String onuOltVlanTransProfFilterOuterTPIDDE = fStringMap.getString("onuOltVlanTransProfFilterOuterTPIDDE") + " : ";
    private final String onuOltVlanTransProfFilterInnerPriority =
            fStringMap.getString("onuOltVlanTransProfFilterInnerPriority") + " : ";
    private final String onuOltVlanTransProfFilterInnerVID =
            fStringMap.getString("onuOltVlanTransProfFilterInnerVID") + " : ";
    private final String onuOltVlanTransProfFilterInnerTPIDDE = fStringMap.getString("onuOltVlanTransProfFilterInnerTPIDDE") + " : ";

    private final String onuOltVlanTransProfFilterEthertype =
            fStringMap.getString("onuOltVlanTransProfFilterEthertype") + " : ";
    private final String onuOltVlanTransProfTreatmentTagsRemove =
            fStringMap.getString("onuOltVlanTransProfTreatmentTagsRemove") + " : ";
    private final String onuOltVlanTransProfTreatmentOuterPriority =
            fStringMap.getString("onuOltVlanTransProfTreatmentOuterPriority") + " : ";
    private final String onuOltVlanTransProfTreatmentOuterVID =
            fStringMap.getString("onuOltVlanTransProfTreatmentOuterVID") + " : ";
    private final String onuOltVlanTransProfTreatmentOuterTPIDDE = fStringMap.getString("onuOltVlanTransProfTreatmentOuterTPIDDE") + " : ";

    private final String onuOltVlanTransProfTreatmentInnerPriority =
            fStringMap.getString("onuOltVlanTransProfTreatmentInnerPriority") + " : ";
    private final String onuOltVlanTransProfTreatmentInnerVID =
            fStringMap.getString("onuOltVlanTransProfTreatmentInnerVID") + " : ";
    private final String onuOltVlanTransProfTreatmentInnerTPIDDE = fStringMap.getString("onuOltVlanTransProfTreatmentInnerTPIDDE") + " : ";
    private final String onuOltVlanTransProfTreatmentTagsMode = fStringMap.getString("onuOltVlanTransProfTreatmentTagsMode") + " : ";

    public OnuOltVlanTransProfTablePanel(IApplication app) {
        super(app);
        ne = new BBS4000NE(fApplication);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(25, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());
        
        baseInfoPanel.add(new JLabel(onuOltVlanTransProfSlotNo));
        tfOnuOltVlanTransProfSlotNo.setName(fStringMap.getString("onuOltVlanTransProfSlotNo"));
        baseInfoPanel.add(tfOnuOltVlanTransProfSlotNo);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(onuOltVlanTransProfPortNo));
        tfOnuOltVlanTransProfPortNo.setName(fStringMap.getString("onuOltVlanTransProfPortNo"));
        baseInfoPanel.add(tfOnuOltVlanTransProfPortNo);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(onuOltVlanTransProfLogicalPortNo));
        tfOnuOltVlanTransProfLogicalPortNo.setName(fStringMap.getString("onuOltVlanTransProfLogicalPortNo"));
        baseInfoPanel.add(tfOnuOltVlanTransProfLogicalPortNo);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(onuOltVlanTransProfOnuUniPortNo));
        tfOnuOltVlanTransProfOnuUniPortNo.setName(fStringMap.getString("onuOltVlanTransProfOnuUniPortNo"));
        baseInfoPanel.add(tfOnuOltVlanTransProfOnuUniPortNo);
        baseInfoPanel.add(new HSpacer());
        
        

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfIndex1));
        baseInfoPanel.add(tfOnuOltVlanTransProfIndex1);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfIndex2));
        baseInfoPanel.add(tfOnuOltVlanTransProfIndex2);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfileName));
        tfOnuOltVlanTransProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuOltVlanTransProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfDownstreamMode));
        tfOnuOltVlanTransProfDownstreamMode.setName(fStringMap.getString("onuOltVlanTransProfDownstreamMode"));
        baseInfoPanel.add(tfOnuOltVlanTransProfDownstreamMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfInputTPID));
        tfOnuOltVlanTransProfInputTPID.setName(fStringMap.getString("onuOltVlanTransProfInputTPID"));
        baseInfoPanel.add(tfOnuOltVlanTransProfInputTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfOutputTPID));
        tfOnuOltVlanTransProfOutputTPID.setName(fStringMap.getString("onuOltVlanTransProfOutputTPID"));
        baseInfoPanel.add(tfOnuOltVlanTransProfOutputTPID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuOltVlanTransProfFilterOuterPriority));
        tfOnuOltVlanTransProfFilterOuterPriority.setName(fStringMap.getString("onuOltVlanTransProfFilterOuterPriority"));
        baseInfoPanel.add(tfOnuOltVlanTransProfFilterOuterPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuOltVlanTransProfFilterOuterVID));
        tfOnuOltVlanTransProfFilterOuterVID.setName(fStringMap.getString("onuOltVlanTransProfFilterOuterVID"));
        baseInfoPanel.add(tfOnuOltVlanTransProfFilterOuterVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfFilterOuterTPIDDE));
        tfOnuOltVlanTransProfFilterOuterTPIDDE.setName(fStringMap.getString("onuOltVlanTransProfFilterOuterTPIDDE"));
        baseInfoPanel.add(tfOnuOltVlanTransProfFilterOuterTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfFilterInnerPriority));
        tfOnuOltVlanTransProfFilterInnerPriority.setName(fStringMap.getString("onuOltVlanTransProfFilterInnerPriority"));
        baseInfoPanel.add(tfOnuOltVlanTransProfFilterInnerPriority);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfFilterInnerVID));
        tfOnuOltVlanTransProfFilterInnerVID.setName(fStringMap.getString("onuOltVlanTransProfFilterInnerVID"));
        baseInfoPanel.add(tfOnuOltVlanTransProfFilterInnerVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfFilterInnerTPIDDE));
        tfOnuOltVlanTransProfFilterInnerTPIDDE.setName(fStringMap.getString("onuOltVlanTransProfFilterInnerTPIDDE"));
        baseInfoPanel.add(tfOnuOltVlanTransProfFilterInnerTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfFilterEthertype));
        tfOnuOltVlanTransProfFilterEthertype.setName(fStringMap.getString("onuOltVlanTransProfFilterEthertype"));
        baseInfoPanel.add(tfOnuOltVlanTransProfFilterEthertype);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfTreatmentTagsRemove));
        tfOnuOltVlanTransProfTreatmentTagsRemove.setName(fStringMap.getString("onuOltVlanTransProfTreatmentTagsRemove"));
        baseInfoPanel.add(tfOnuOltVlanTransProfTreatmentTagsRemove);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuOltVlanTransProfTreatmentOuterPriority));
        tfOnuOltVlanTransProfTreatmentOuterPriority.setName(fStringMap.getString("onuOltVlanTransProfTreatmentOuterPriority"));
        baseInfoPanel.add(tfOnuOltVlanTransProfTreatmentOuterPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuOltVlanTransProfTreatmentOuterVID));
        tfOnuOltVlanTransProfTreatmentOuterVID.setName(fStringMap.getString("onuOltVlanTransProfTreatmentOuterVID"));
        baseInfoPanel.add(tfOnuOltVlanTransProfTreatmentOuterVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfTreatmentOuterTPIDDE));
        tfOnuOltVlanTransProfTreatmentOuterTPIDDE.setName(fStringMap.getString("onuOltVlanTransProfTreatmentOuterTPIDDE"));
        baseInfoPanel.add(tfOnuOltVlanTransProfTreatmentOuterTPIDDE);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuOltVlanTransProfTreatmentInnerPriority));
        tfOnuOltVlanTransProfTreatmentInnerPriority.setName(fStringMap.getString("onuOltVlanTransProfTreatmentInnerPriority"));
        baseInfoPanel.add(tfOnuOltVlanTransProfTreatmentInnerPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuOltVlanTransProfTreatmentInnerVID));
        tfOnuOltVlanTransProfTreatmentInnerVID.setName(fStringMap.getString("onuOltVlanTransProfTreatmentInnerVID"));
        baseInfoPanel.add(tfOnuOltVlanTransProfTreatmentInnerVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfTreatmentInnerTPIDDE));
        tfOnuOltVlanTransProfTreatmentInnerTPIDDE.setName(fStringMap.getString("onuOltVlanTransProfTreatmentInnerTPIDDE"));
        baseInfoPanel.add(tfOnuOltVlanTransProfTreatmentInnerTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuOltVlanTransProfTreatmentTagsMode));
        tfOnuOltVlanTransProfTreatmentTagsMode.setName(fStringMap.getString("onuOltVlanTransProfTreatmentTagsMode"));
        baseInfoPanel.add(tfOnuOltVlanTransProfTreatmentTagsMode);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add( new JScrollPane(allPanel), BorderLayout.CENTER);
        setPreferredSize(new Dimension(450, 550));
        for(int i=1; i<=128; i++){
            tfOnuOltVlanTransProfOnuUniPortNo.addItem(i);
        }
      
    }

    protected void initForm() {
        tfOnuOltVlanTransProfInputTPID.setLenScope(1, 4);
        tfOnuOltVlanTransProfInputTPID.setDefaultString("8100");
        tfOnuOltVlanTransProfOutputTPID.setLenScope(1, 4);
        tfOnuOltVlanTransProfOutputTPID.setDefaultString("88a8"); 
        tfOnuOltVlanTransProfFilterOuterVID.setValueScope(0, 4096);
        tfOnuOltVlanTransProfFilterOuterVID.setValue(4096);
        tfOnuOltVlanTransProfFilterInnerVID.setValueScope(0, 4096);
        tfOnuOltVlanTransProfFilterInnerVID.setValue(101);
        tfOnuOltVlanTransProfTreatmentOuterVID.setValueScope(0, 4097);
        tfOnuOltVlanTransProfTreatmentOuterVID.setValue(1000);
        tfOnuOltVlanTransProfTreatmentInnerVID.setValueScope(0, 4097);
        tfOnuOltVlanTransProfTreatmentInnerVID.setValue(4096);
        tfOnuOltVlanTransProfIndex1.setValueScope(2, 128);
        tfOnuOltVlanTransProfIndex2.setValueScope(1, 64);
        tfOnuOltVlanTransProfFilterOuterPriority.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfFilterOuterPriorityVList, 8));
        tfOnuOltVlanTransProfFilterInnerPriority.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfFilterInnerPriorityVList, 8));
        tfOnuOltVlanTransProfTreatmentOuterPriority.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfTreatmentOuterPriorityVList, 8));
        tfOnuOltVlanTransProfTreatmentInnerPriority.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfTreatmentInnerPriorityVList, 15));
        
     
    }
    public boolean validateFrom(){
        String msg = null;
        
        if(tfOnuOltVlanTransProfFilterOuterVID.getValue()==4095){
            msg = fStringMap.getString("FilterOuterVID_4095_Reserved");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg); 
        return false;
        }
        if(tfOnuOltVlanTransProfFilterInnerVID.getValue()==4095){
            msg = fStringMap.getString("FilterInnerVID_4095_Reserved");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
            return false;
        }
        if(tfOnuOltVlanTransProfTreatmentOuterVID.getValue()==4095){
            msg = fStringMap.getString("TreatmentOuterVID_4095_Reserved");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
            return false;
        }
        if(tfOnuOltVlanTransProfTreatmentInnerVID.getValue()==4095){
            msg = fStringMap.getString("TreatmentInnerVID_4095_Reserved");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
            return false;
            
        }
        return true;
        
    }
    

    public void refresh() {
        
      //Slot
        tfOnuOltVlanTransProfSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuOltVlanTransProfSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuOltVlanTransProfSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }*/
        }
        //Port
        tfOnuOltVlanTransProfPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuOltVlanTransProfPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuOltVlanTransProfLogicalPortNo.removeAllItems();
        int count = ne.getPonSplitRatio();
        for (int i = 1; i <= count; i++) {
            tfOnuOltVlanTransProfLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }
        //-------------------
        
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuOltVlanTransProfIndex1.setEnabled(true);
            tfOnuOltVlanTransProfIndex2.setEnabled(true);
            tfOnuOltVlanTransProfSlotNo.setEnabled(true);
            tfOnuOltVlanTransProfPortNo.setEnabled(true);
            tfOnuOltVlanTransProfLogicalPortNo.setEnabled(true);
            tfOnuOltVlanTransProfOnuUniPortNo.setEnabled(true);
            return;
        } else {
            tfOnuOltVlanTransProfIndex1.setEnabled(false);
            tfOnuOltVlanTransProfIndex2.setEnabled(false);
            tfOnuOltVlanTransProfSlotNo.setEnabled(false);
            tfOnuOltVlanTransProfPortNo.setEnabled(false);
            tfOnuOltVlanTransProfLogicalPortNo.setEnabled(false);
            tfOnuOltVlanTransProfOnuUniPortNo.setEnabled(false);
        }

        OnuOltVlanTransProfTable mbean = (OnuOltVlanTransProfTable) getModel();
        tfOnuOltVlanTransProfSlotNo.setSelectedItem((mbean.getOnuOltVlanTransProfSlotNo() != null) ? fStringMap.getString("Slot") + " " +mbean.getOnuOltVlanTransProfSlotNo()+ " - GPM" : "");
        tfOnuOltVlanTransProfPortNo.setSelectedItem((mbean.getOnuOltVlanTransProfPortNo() != null) ? fStringMap.getString("Port") + " " + mbean.getOnuOltVlanTransProfPortNo() : "");
        tfOnuOltVlanTransProfLogicalPortNo.setSelectedItem((mbean.getOnuOltVlanTransProfLogicalPortNo() != null) ? fStringMap.getString("ONT")+ " " + mbean.getOnuOltVlanTransProfLogicalPortNo() : "");
        tfOnuOltVlanTransProfOnuUniPortNo.setSelectedItem((mbean.getOnuOltVlanTransProfOnuUniPortNo()!=null)? mbean.getOnuOltVlanTransProfOnuUniPortNo():"");
        tfOnuOltVlanTransProfIndex1.setValue(mbean.getOnuOltVlanTransProfIndex1());
        tfOnuOltVlanTransProfIndex2.setValue(mbean.getOnuOltVlanTransProfIndex2());
        tfOnuOltVlanTransProfileName.setValue(mbean.getOnuOltVlanTransProfileName());
        tfOnuOltVlanTransProfDownstreamMode.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfDownstreamModeVList, mbean.getOnuOltVlanTransProfDownstreamMode().intValue()));
        tfOnuOltVlanTransProfInputTPID.setValue(Long.toHexString(mbean.getOnuOltVlanTransProfInputTPID()));
        tfOnuOltVlanTransProfOutputTPID.setValue(Long.toHexString(mbean.getOnuOltVlanTransProfOutputTPID()));
        tfOnuOltVlanTransProfFilterOuterPriority.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfFilterOuterPriorityVList, mbean.getOnuOltVlanTransProfFilterOuterPriority()));
        tfOnuOltVlanTransProfFilterOuterVID.setValue(mbean.getOnuOltVlanTransProfFilterOuterVID().intValue());
        tfOnuOltVlanTransProfFilterOuterTPIDDE.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfFilterOuterTPIDDEVList, mbean.getOnuOltVlanTransProfFilterOuterTPIDDE().intValue()));
        tfOnuOltVlanTransProfFilterInnerPriority.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfFilterInnerPriorityVList, mbean.getOnuOltVlanTransProfFilterInnerPriority()));
        tfOnuOltVlanTransProfFilterInnerVID.setValue(mbean.getOnuOltVlanTransProfFilterInnerVID().intValue());
        tfOnuOltVlanTransProfFilterInnerTPIDDE.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfFilterInnerTPIDDEVList, mbean.getOnuOltVlanTransProfFilterInnerTPIDDE().intValue()));
        tfOnuOltVlanTransProfFilterEthertype.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfFilterEthertypeVList, mbean.getOnuOltVlanTransProfFilterEthertype().intValue()));
        tfOnuOltVlanTransProfTreatmentTagsRemove.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfTreatmentTagsRemoveVList, mbean.getOnuOltVlanTransProfTreatmentTagsRemove().intValue()));
        tfOnuOltVlanTransProfTreatmentOuterPriority.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfTreatmentOuterPriorityVList, mbean.getOnuOltVlanTransProfTreatmentOuterPriority()));
        tfOnuOltVlanTransProfTreatmentOuterVID.setValue(mbean.getOnuOltVlanTransProfTreatmentOuterVID().intValue());
        tfOnuOltVlanTransProfTreatmentOuterTPIDDE.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfTreatmentOuterTPIDDEVList, mbean.getOnuOltVlanTransProfTreatmentOuterTPIDDE().intValue()));
        tfOnuOltVlanTransProfTreatmentInnerPriority.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfTreatmentInnerPriorityVList, mbean.getOnuOltVlanTransProfTreatmentInnerPriority()));
        tfOnuOltVlanTransProfTreatmentInnerVID.setValue(mbean.getOnuOltVlanTransProfTreatmentInnerVID().intValue());
        tfOnuOltVlanTransProfTreatmentInnerTPIDDE.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfTreatmentInnerTPIDDEVList, mbean.getOnuOltVlanTransProfTreatmentInnerTPIDDE().intValue()));
        tfOnuOltVlanTransProfTreatmentTagsMode.setSelectedIndex(getIndexFromValue(onuOltVlanTransProfTreatmentTagsModeVList, mbean.getOnuOltVlanTransProfTreatmentTagsMode().intValue()));
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuOltVlanTransProfTable(fApplication.getSnmpProxy()));

        OnuOltVlanTransProfTable mbean = (OnuOltVlanTransProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuOltVlanTransProfIndex1(tfOnuOltVlanTransProfIndex1.getValue());
            mbean.setOnuOltVlanTransProfIndex2(tfOnuOltVlanTransProfIndex2.getValue());
            mbean.setOnuOltVlanTransProfSlotNo(getSelectedSlotId());
            mbean.setOnuOltVlanTransProfPortNo(getSelectedPortId());
            mbean.setOnuOltVlanTransProfLogicalPortNo(getSelectedOnuId());
            mbean.setOnuOltVlanTransProfOnuUniPortNo(new Integer(tfOnuOltVlanTransProfOnuUniPortNo.getSelectedItem().toString()));
        }
        
        mbean.setOnuOltVlanTransProfileName(new String(tfOnuOltVlanTransProfileName.getValue()));
        mbean.setOnuOltVlanTransProfDownstreamMode(onuOltVlanTransProfDownstreamModeVList[tfOnuOltVlanTransProfDownstreamMode.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfInputTPID(Long.parseLong(tfOnuOltVlanTransProfInputTPID.getValue(), 16));
        mbean.setOnuOltVlanTransProfOutputTPID(Long.parseLong(tfOnuOltVlanTransProfOutputTPID.getValue(),16));
        mbean.setOnuOltVlanTransProfFilterOuterPriority(onuOltVlanTransProfFilterOuterPriorityVList[tfOnuOltVlanTransProfFilterOuterPriority.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfFilterOuterVID(new Long(tfOnuOltVlanTransProfFilterOuterVID.getValue()));
        mbean.setOnuOltVlanTransProfFilterOuterTPIDDE(onuOltVlanTransProfFilterOuterTPIDDEVList[tfOnuOltVlanTransProfFilterOuterTPIDDE.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfFilterInnerPriority(onuOltVlanTransProfFilterInnerPriorityVList[tfOnuOltVlanTransProfFilterInnerPriority.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfFilterInnerVID(new Long(tfOnuOltVlanTransProfFilterInnerVID.getValue()));
        mbean.setOnuOltVlanTransProfFilterInnerTPIDDE(onuOltVlanTransProfFilterInnerTPIDDEVList[tfOnuOltVlanTransProfFilterInnerTPIDDE.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfFilterEthertype(new Long(onuOltVlanTransProfFilterEthertypeVList[tfOnuOltVlanTransProfFilterEthertype.getSelectedIndex()]));
        mbean.setOnuOltVlanTransProfTreatmentTagsRemove(onuOltVlanTransProfTreatmentTagsRemoveVList[tfOnuOltVlanTransProfTreatmentTagsRemove.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfTreatmentOuterPriority(onuOltVlanTransProfTreatmentOuterPriorityVList[tfOnuOltVlanTransProfTreatmentOuterPriority.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfTreatmentOuterVID(new Long(tfOnuOltVlanTransProfTreatmentOuterVID.getValue()));
        mbean.setOnuOltVlanTransProfTreatmentOuterTPIDDE(onuOltVlanTransProfTreatmentOuterTPIDDEVList[tfOnuOltVlanTransProfTreatmentOuterTPIDDE.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfTreatmentInnerPriority(onuOltVlanTransProfTreatmentInnerPriorityVList[tfOnuOltVlanTransProfTreatmentInnerPriority.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfTreatmentInnerVID(new Long(tfOnuOltVlanTransProfTreatmentInnerVID.getValue()));
        mbean.setOnuOltVlanTransProfTreatmentInnerTPIDDE(onuOltVlanTransProfTreatmentInnerTPIDDEVList[tfOnuOltVlanTransProfTreatmentInnerTPIDDE.getSelectedIndex()]);
        mbean.setOnuOltVlanTransProfTreatmentTagsMode(onuOltVlanTransProfTreatmentTagsModeVList[tfOnuOltVlanTransProfTreatmentTagsMode.getSelectedIndex()]);
    }
    
    public void afterUpdateModel(){
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }
    public int getIndexFromValue(long[] list, long v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }
    
    public int getSelectedSlotId() {
        if (tfOnuOltVlanTransProfSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuOltVlanTransProfSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }
    public int getSelectedPortId() {
        if (tfOnuOltVlanTransProfPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuOltVlanTransProfPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuOltVlanTransProfLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuOltVlanTransProfLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

}

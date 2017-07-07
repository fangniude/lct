/**
 * Title          :   OnuVlanTransProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanTransProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shen Dayong
 *         Create on 2008-10-2
 *         Modify by HZ21044
 */

public class OnuVlanTransProfTablePanel extends UPanel {

//    private LongIndexGenField tfOnuVlanTransProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOnuVlanTransProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField tfOnuVlanTransProfIndex = new IndexAutoGenField(fApplication,2);
    private StringTextField tfOnuVlanTransProfileName = new StringTextField();

    private int[] onuVlanTransProfDownstreamModeVList = new int[]{0, 1};
    private String[] onuVlanTransProfDownstreamModeTList = new String[]{fStringMap.getString("operation"), fStringMap.getString("no-operation")};
    private JComboBox tfOnuVlanTransProfDownstreamMode = new JComboBox(onuVlanTransProfDownstreamModeTList);

    private HexTextField tfOnuVlanTransProfInputTPID = new HexTextField();
    private HexTextField tfOnuVlanTransProfOutputTPID = new HexTextField();
    
    private long[] onuVlanTransProfFilterOuterPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,14,15};
    private String[] onuVlanTransProfFilterOuterPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","14","15"};
    private JComboBox tfOnuVlanTransProfFilterOuterPriority = new JComboBox(onuVlanTransProfFilterOuterPriorityTList);
    
    private LongTextField tfOnuVlanTransProfFilterOuterVID = new LongTextField();

    private int[] onuVlanTransProfFilterOuterTPIDDEVList = new int[]{0, 4, 5, 6, 7};
    private String[] onuVlanTransProfFilterOuterTPIDDETList = new String[]{fStringMap.getString("no-filter"), fStringMap.getString("outer-TPID-8100")
            , fStringMap.getString("input-TPID"), fStringMap.getString("input-TPID-DE-0"), fStringMap.getString("input-TPID-DE-1")};
    private JComboBox tfOnuVlanTransProfFilterOuterTPIDDE = new JComboBox(onuVlanTransProfFilterOuterTPIDDETList);

    private long[] onuVlanTransProfFilterInnerPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,14,15};
    private String[] onuVlanTransProfFilterInnerPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","14","15"};
    private JComboBox tfOnuVlanTransProfFilterInnerPriority = new JComboBox(onuVlanTransProfFilterInnerPriorityTList);
    
    private LongTextField tfOnuVlanTransProfFilterInnerVID = new LongTextField();
    private int[] onuVlanTransProfFilterInnerTPIDDEVList = new int[]{0, 4, 5, 6, 7};
    private String[] onuVlanTransProfFilterInnerTPIDDETList = new String[]{fStringMap.getString("no-filter"), fStringMap.getString("outer-TPID-8100")
            , fStringMap.getString("input-TPID"), fStringMap.getString("input-TPID-DE-0"), fStringMap.getString("input-TPID-DE-1")};
    private JComboBox tfOnuVlanTransProfFilterInnerTPIDDE = new JComboBox(onuVlanTransProfFilterOuterTPIDDETList);

    private int[] onuVlanTransProfFilterEthertypeVList = new int[]{0,1,2,3};

    private String[] onuVlanTransProfFilterEthertypeTList = new String[]{fStringMap.getString("Don't filter on Ethertype"),
            fStringMap.getString("filter IPoE frames"),fStringMap.getString("filter PPPoE frames"),fStringMap.getString("filter ARP frames")};
    private JComboBox tfOnuVlanTransProfFilterEthertype = new JComboBox(onuVlanTransProfFilterEthertypeTList);

    private int[] onuVlanTransProfTreatmentTagsRemoveVList = new int[]{1, 2, 3, 4};
    private String[] onuVlanTransProfTreatmentTagsRemoveTList = new String[]{fStringMap.getString("do-not-remove"), fStringMap.getString("remove-outer-tag"),fStringMap.getString("remove-inner-tag"), fStringMap.getString("remove-all")};
    private JComboBox tfOnuVlanTransProfTreatmentTagsRemove = new JComboBox(onuVlanTransProfTreatmentTagsRemoveTList);

    private long[] onuVlanTransProfTreatmentOuterPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,9,15};
    private String[] onuVlanTransProfTreatmentOuterPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","9","15"};
    private JComboBox tfOnuVlanTransProfTreatmentOuterPriority = new JComboBox(onuVlanTransProfTreatmentOuterPriorityTList);
    
    private LongTextField tfOnuVlanTransProfTreatmentOuterVID = new LongTextField();
    private int[] onuVlanTransProfTreatmentOuterTPIDDEVList = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private String[] onuVlanTransProfTreatmentOuterTPIDDETList = new String[]{fStringMap.getString("copy-tpid-inner"),
            fStringMap.getString("copy-tpid-outer"), fStringMap.getString("set-tpid-output-copy-de-inner"), fStringMap.getString("set-tpid-output-copy-de-outer"),
            fStringMap.getString("set-tpid-0x8100"), fStringMap.getString("reserved"), fStringMap.getString("set-tpid-output-de-0"), fStringMap.getString("set-tpid-output-de-1")};
    private JComboBox tfOnuVlanTransProfTreatmentOuterTPIDDE = new JComboBox(onuVlanTransProfTreatmentOuterTPIDDETList);

    private long[] onuVlanTransProfTreatmentInnerPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,9,15};
    private String[] onuVlanTransProfTreatmentInnerPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","9","15"};
    private JComboBox tfOnuVlanTransProfTreatmentInnerPriority = new JComboBox(onuVlanTransProfTreatmentInnerPriorityTList);
    
    private LongTextField tfOnuVlanTransProfTreatmentInnerVID = new LongTextField();
    private int[] onuVlanTransProfTreatmentInnerTPIDDEVList = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private String[] onuVlanTransProfTreatmentInnerTPIDDETList = new String[]{fStringMap.getString("copy-tpid-inner"),
            fStringMap.getString("copy-tpid-outer"), fStringMap.getString("set-tpid-output-copy-de-inner"), fStringMap.getString("set-tpid-output-copy-de-outer"),
            fStringMap.getString("set-tpid-0x8100"), fStringMap.getString("reserved"), fStringMap.getString("set-tpid-output-de-0"), fStringMap.getString("set-tpid-output-de-1")};
    private JComboBox tfOnuVlanTransProfTreatmentInnerTPIDDE = new JComboBox(onuVlanTransProfTreatmentInnerTPIDDETList);

    private int[] onuVlanTransProfTreatmentTagsModeVList = new int[]{1, 2, 3, 4};
    private String[] onuVlanTransProfTreatmentTagsModeTList = new String[]{fStringMap.getString("sit"), fStringMap.getString("sot")
            , fStringMap.getString("dt"), fStringMap.getString("unknown")};
    private JComboBox tfOnuVlanTransProfTreatmentTagsMode = new JComboBox(onuVlanTransProfTreatmentTagsModeTList);


    private final String onuVlanTransProfIndex1 =
            fStringMap.getString("onuVlanTransProfIndex1") + " : ";
    private final String onuVlanTransProfIndex2 = fStringMap.getString("onuVlanTransProfIndex2");
    private final String onuVlanTransProfileName =
            fStringMap.getString("onuVlanTransProfileName") + " : ";
    private final String onuVlanTransProfDownstreamMode =
            fStringMap.getString("onuVlanTransProfDownstreamMode") + " : ";
    private final String onuVlanTransProfInputTPID =
            fStringMap.getString("onuVlanTransProfInputTPID") + " : ";
    private final String onuVlanTransProfOutputTPID =
            fStringMap.getString("onuVlanTransProfOutputTPID") + " : ";
    private final String onuVlanTransProfFilterOuterPriority =
            fStringMap.getString("onuVlanTransProfFilterOuterPriority") + " : ";
    private final String onuVlanTransProfFilterOuterVID =
            fStringMap.getString("onuVlanTransProfFilterOuterVID") + " : ";
    private final String onuVlanTransProfFilterOuterTPIDDE = fStringMap.getString("onuVlanTransProfFilterOuterTPIDDE") + " : ";
    private final String onuVlanTransProfFilterInnerPriority =
            fStringMap.getString("onuVlanTransProfFilterInnerPriority") + " : ";
    private final String onuVlanTransProfFilterInnerVID =
            fStringMap.getString("onuVlanTransProfFilterInnerVID") + " : ";
    private final String onuVlanTransProfFilterInnerTPIDDE = fStringMap.getString("onuVlanTransProfFilterInnerTPIDDE") + " : ";

    private final String onuVlanTransProfFilterEthertype =
            fStringMap.getString("onuVlanTransProfFilterEthertype") + " : ";
    private final String onuVlanTransProfTreatmentTagsRemove =
            fStringMap.getString("onuVlanTransProfTreatmentTagsRemove") + " : ";
    private final String onuVlanTransProfTreatmentOuterPriority =
            fStringMap.getString("onuVlanTransProfTreatmentOuterPriority") + " : ";
    private final String onuVlanTransProfTreatmentOuterVID =
            fStringMap.getString("onuVlanTransProfTreatmentOuterVID") + " : ";
    private final String onuVlanTransProfTreatmentOuterTPIDDE = fStringMap.getString("onuVlanTransProfTreatmentOuterTPIDDE") + " : ";

    private final String onuVlanTransProfTreatmentInnerPriority =
            fStringMap.getString("onuVlanTransProfTreatmentInnerPriority") + " : ";
    private final String onuVlanTransProfTreatmentInnerVID =
            fStringMap.getString("onuVlanTransProfTreatmentInnerVID") + " : ";
    private final String onuVlanTransProfTreatmentInnerTPIDDE = fStringMap.getString("onuVlanTransProfTreatmentInnerTPIDDE") + " : ";
    private final String onuVlanTransProfTreatmentTagsMode = fStringMap.getString("onuVlanTransProfTreatmentTagsMode") + " : ";

    public OnuVlanTransProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(21, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuVlanTransProfIndex1));
        baseInfoPanel.add(tfOnuVlanTransProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfIndex2));
        baseInfoPanel.add(tfOnuVlanTransProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfileName));
        tfOnuVlanTransProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuVlanTransProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfDownstreamMode));
        tfOnuVlanTransProfDownstreamMode.setName(fStringMap.getString("onuVlanTransProfDownstreamMode"));
        baseInfoPanel.add(tfOnuVlanTransProfDownstreamMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfInputTPID));
        tfOnuVlanTransProfInputTPID.setName(fStringMap.getString("onuVlanTransProfInputTPID"));
        baseInfoPanel.add(tfOnuVlanTransProfInputTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfOutputTPID));
        tfOnuVlanTransProfOutputTPID.setName(fStringMap.getString("onuVlanTransProfOutputTPID"));
        baseInfoPanel.add(tfOnuVlanTransProfOutputTPID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuVlanTransProfFilterOuterPriority));
        tfOnuVlanTransProfFilterOuterPriority.setName(fStringMap.getString("onuVlanTransProfFilterOuterPriority"));
        baseInfoPanel.add(tfOnuVlanTransProfFilterOuterPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuVlanTransProfFilterOuterVID));
        tfOnuVlanTransProfFilterOuterVID.setName(fStringMap.getString("onuVlanTransProfFilterOuterVID"));
        baseInfoPanel.add(tfOnuVlanTransProfFilterOuterVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfFilterOuterTPIDDE));
        tfOnuVlanTransProfFilterOuterTPIDDE.setName(fStringMap.getString("onuVlanTransProfFilterOuterTPIDDE"));
        baseInfoPanel.add(tfOnuVlanTransProfFilterOuterTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfFilterInnerPriority));
        tfOnuVlanTransProfFilterInnerPriority.setName(fStringMap.getString("onuVlanTransProfFilterInnerPriority"));
        baseInfoPanel.add(tfOnuVlanTransProfFilterInnerPriority);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfFilterInnerVID));
        tfOnuVlanTransProfFilterInnerVID.setName(fStringMap.getString("onuVlanTransProfFilterInnerVID"));
        baseInfoPanel.add(tfOnuVlanTransProfFilterInnerVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfFilterInnerTPIDDE));
        tfOnuVlanTransProfFilterInnerTPIDDE.setName(fStringMap.getString("onuVlanTransProfFilterInnerTPIDDE"));
        baseInfoPanel.add(tfOnuVlanTransProfFilterInnerTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfFilterEthertype));
        tfOnuVlanTransProfFilterEthertype.setName(fStringMap.getString("onuVlanTransProfFilterEthertype"));
        baseInfoPanel.add(tfOnuVlanTransProfFilterEthertype);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfTreatmentTagsRemove));
        tfOnuVlanTransProfTreatmentTagsRemove.setName(fStringMap.getString("onuVlanTransProfTreatmentTagsRemove"));
        baseInfoPanel.add(tfOnuVlanTransProfTreatmentTagsRemove);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuVlanTransProfTreatmentOuterPriority));
        tfOnuVlanTransProfTreatmentOuterPriority.setName(fStringMap.getString("onuVlanTransProfTreatmentOuterPriority"));
        baseInfoPanel.add(tfOnuVlanTransProfTreatmentOuterPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuVlanTransProfTreatmentOuterVID));
        tfOnuVlanTransProfTreatmentOuterVID.setName(fStringMap.getString("onuVlanTransProfTreatmentOuterVID"));
        baseInfoPanel.add(tfOnuVlanTransProfTreatmentOuterVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfTreatmentOuterTPIDDE));
        tfOnuVlanTransProfTreatmentOuterTPIDDE.setName(fStringMap.getString("onuVlanTransProfTreatmentOuterTPIDDE"));
        baseInfoPanel.add(tfOnuVlanTransProfTreatmentOuterTPIDDE);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuVlanTransProfTreatmentInnerPriority));
        tfOnuVlanTransProfTreatmentInnerPriority.setName(fStringMap.getString("onuVlanTransProfTreatmentInnerPriority"));
        baseInfoPanel.add(tfOnuVlanTransProfTreatmentInnerPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuVlanTransProfTreatmentInnerVID));
        tfOnuVlanTransProfTreatmentInnerVID.setName(fStringMap.getString("onuVlanTransProfTreatmentInnerVID"));
        baseInfoPanel.add(tfOnuVlanTransProfTreatmentInnerVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfTreatmentInnerTPIDDE));
        tfOnuVlanTransProfTreatmentInnerTPIDDE.setName(fStringMap.getString("onuVlanTransProfTreatmentInnerTPIDDE"));
        baseInfoPanel.add(tfOnuVlanTransProfTreatmentInnerTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTransProfTreatmentTagsMode));
        tfOnuVlanTransProfTreatmentTagsMode.setName(fStringMap.getString("onuVlanTransProfTreatmentTagsMode"));
        baseInfoPanel.add(tfOnuVlanTransProfTreatmentTagsMode);
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

        tfOnuVlanTransProfInputTPID.setLenScope(1, 4);
        tfOnuVlanTransProfInputTPID.setDefaultString("8100");
        tfOnuVlanTransProfOutputTPID.setLenScope(1, 4);
        tfOnuVlanTransProfOutputTPID.setDefaultString("88a8"); 
        tfOnuVlanTransProfFilterOuterVID.setValueScope(0, 4096);
        tfOnuVlanTransProfFilterOuterVID.setValue(4096);
        tfOnuVlanTransProfFilterInnerVID.setValueScope(0, 4096);
        tfOnuVlanTransProfFilterInnerVID.setValue(101);
        tfOnuVlanTransProfTreatmentOuterVID.setValueScope(0, 4097);
        tfOnuVlanTransProfTreatmentOuterVID.setValue(1000);
        tfOnuVlanTransProfTreatmentInnerVID.setValueScope(0, 4097);
        tfOnuVlanTransProfTreatmentInnerVID.setValue(4096);
        tfOnuVlanTransProfIndex.setValueScope(0,2, 128);
        tfOnuVlanTransProfIndex.setValueScope(1,1, 64);
        tfOnuVlanTransProfFilterOuterPriority.setSelectedIndex(getIndexFromValue(onuVlanTransProfFilterOuterPriorityVList, 8));
        tfOnuVlanTransProfFilterInnerPriority.setSelectedIndex(getIndexFromValue(onuVlanTransProfFilterInnerPriorityVList, 8));
        tfOnuVlanTransProfTreatmentOuterPriority.setSelectedIndex(getIndexFromValue(onuVlanTransProfTreatmentOuterPriorityVList, 8));
        tfOnuVlanTransProfTreatmentInnerPriority.setSelectedIndex(getIndexFromValue(onuVlanTransProfTreatmentInnerPriorityVList, 15));
        
     
    }
    public boolean validateFrom(){
        String msg = null;
        
        if(tfOnuVlanTransProfFilterOuterVID.getValue()==4095){
            msg = fStringMap.getString("FilterOuterVID_4095_Reserved");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg); 
        return false;
        }
        if(tfOnuVlanTransProfFilterInnerVID.getValue()==4095){
            msg = fStringMap.getString("FilterInnerVID_4095_Reserved");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
            return false;
        }
        if(tfOnuVlanTransProfTreatmentOuterVID.getValue()==4095){
            msg = fStringMap.getString("TreatmentOuterVID_4095_Reserved");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
            return false;
        }
        if(tfOnuVlanTransProfTreatmentInnerVID.getValue()==4095){
            msg = fStringMap.getString("TreatmentInnerVID_4095_Reserved");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
            return false;
            
        }
        return true;
        
    }
    

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuVlanTransProfIndex.setEnabled(true);
            tfOnuVlanTransProfIndex.setTable(fTable);
            tfOnuVlanTransProfIndex.refresh();
            return;
        } else {
            tfOnuVlanTransProfIndex.setEnabled(false);
        }

        OnuVlanTransProfTable mbean = (OnuVlanTransProfTable) getModel();

        tfOnuVlanTransProfIndex.setValue(0,mbean.getOnuVlanTransProfIndex1());
        tfOnuVlanTransProfIndex.setValue(1,mbean.getOnuVlanTransProfIndex2());
        tfOnuVlanTransProfileName.setValue(mbean.getOnuVlanTransProfileName());
        tfOnuVlanTransProfDownstreamMode.setSelectedIndex(getIndexFromValue(onuVlanTransProfDownstreamModeVList, mbean.getOnuVlanTransProfDownstreamMode().intValue()));
        tfOnuVlanTransProfInputTPID.setValue(Long.toHexString(mbean.getOnuVlanTransProfInputTPID()));
        tfOnuVlanTransProfOutputTPID.setValue(Long.toHexString(mbean.getOnuVlanTransProfOutputTPID()));
        tfOnuVlanTransProfFilterOuterPriority.setSelectedIndex(getIndexFromValue(onuVlanTransProfFilterOuterPriorityVList, mbean.getOnuVlanTransProfFilterOuterPriority()));
        tfOnuVlanTransProfFilterOuterVID.setValue(mbean.getOnuVlanTransProfFilterOuterVID().intValue());
        tfOnuVlanTransProfFilterOuterTPIDDE.setSelectedIndex(getIndexFromValue(onuVlanTransProfFilterOuterTPIDDEVList, mbean.getOnuVlanTransProfFilterOuterTPIDDE().intValue()));
        tfOnuVlanTransProfFilterInnerPriority.setSelectedIndex(getIndexFromValue(onuVlanTransProfFilterInnerPriorityVList, mbean.getOnuVlanTransProfFilterInnerPriority()));
        tfOnuVlanTransProfFilterInnerVID.setValue(mbean.getOnuVlanTransProfFilterInnerVID().intValue());
        tfOnuVlanTransProfFilterInnerTPIDDE.setSelectedIndex(getIndexFromValue(onuVlanTransProfFilterInnerTPIDDEVList, mbean.getOnuVlanTransProfFilterInnerTPIDDE().intValue()));
        tfOnuVlanTransProfFilterEthertype.setSelectedIndex(getIndexFromValue(onuVlanTransProfFilterEthertypeVList, mbean.getOnuVlanTransProfFilterEthertype().intValue()));
        tfOnuVlanTransProfTreatmentTagsRemove.setSelectedIndex(getIndexFromValue(onuVlanTransProfTreatmentTagsRemoveVList, mbean.getOnuVlanTransProfTreatmentTagsRemove().intValue()));
        tfOnuVlanTransProfTreatmentOuterPriority.setSelectedIndex(getIndexFromValue(onuVlanTransProfTreatmentOuterPriorityVList, mbean.getOnuVlanTransProfTreatmentOuterPriority()));
        tfOnuVlanTransProfTreatmentOuterVID.setValue(mbean.getOnuVlanTransProfTreatmentOuterVID().intValue());
        tfOnuVlanTransProfTreatmentOuterTPIDDE.setSelectedIndex(getIndexFromValue(onuVlanTransProfTreatmentOuterTPIDDEVList, mbean.getOnuVlanTransProfTreatmentOuterTPIDDE().intValue()));
        tfOnuVlanTransProfTreatmentInnerPriority.setSelectedIndex(getIndexFromValue(onuVlanTransProfTreatmentInnerPriorityVList, mbean.getOnuVlanTransProfTreatmentInnerPriority()));
        tfOnuVlanTransProfTreatmentInnerVID.setValue(mbean.getOnuVlanTransProfTreatmentInnerVID().intValue());
        tfOnuVlanTransProfTreatmentInnerTPIDDE.setSelectedIndex(getIndexFromValue(onuVlanTransProfTreatmentInnerTPIDDEVList, mbean.getOnuVlanTransProfTreatmentInnerTPIDDE().intValue()));
        tfOnuVlanTransProfTreatmentTagsMode.setSelectedIndex(getIndexFromValue(onuVlanTransProfTreatmentTagsModeVList, mbean.getOnuVlanTransProfTreatmentTagsMode().intValue()));
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuVlanTransProfTable(fApplication.getSnmpProxy()));

        OnuVlanTransProfTable mbean = (OnuVlanTransProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuVlanTransProfIndex1(tfOnuVlanTransProfIndex.getValue(0));
            mbean.setOnuVlanTransProfIndex2(tfOnuVlanTransProfIndex.getValue(1));
        }

        mbean.setOnuVlanTransProfileName(new String(tfOnuVlanTransProfileName.getValue()));
        mbean.setOnuVlanTransProfDownstreamMode(onuVlanTransProfDownstreamModeVList[tfOnuVlanTransProfDownstreamMode.getSelectedIndex()]);
        mbean.setOnuVlanTransProfInputTPID(Long.parseLong(tfOnuVlanTransProfInputTPID.getValue(), 16));
        mbean.setOnuVlanTransProfOutputTPID(Long.parseLong(tfOnuVlanTransProfOutputTPID.getValue(),16));
        mbean.setOnuVlanTransProfFilterOuterPriority(onuVlanTransProfFilterOuterPriorityVList[tfOnuVlanTransProfFilterOuterPriority.getSelectedIndex()]);
        mbean.setOnuVlanTransProfFilterOuterVID(new Long(tfOnuVlanTransProfFilterOuterVID.getValue()));
        mbean.setOnuVlanTransProfFilterOuterTPIDDE(onuVlanTransProfFilterOuterTPIDDEVList[tfOnuVlanTransProfFilterOuterTPIDDE.getSelectedIndex()]);
        mbean.setOnuVlanTransProfFilterInnerPriority(onuVlanTransProfFilterInnerPriorityVList[tfOnuVlanTransProfFilterInnerPriority.getSelectedIndex()]);
        mbean.setOnuVlanTransProfFilterInnerVID(new Long(tfOnuVlanTransProfFilterInnerVID.getValue()));
        mbean.setOnuVlanTransProfFilterInnerTPIDDE(onuVlanTransProfFilterInnerTPIDDEVList[tfOnuVlanTransProfFilterInnerTPIDDE.getSelectedIndex()]);
        mbean.setOnuVlanTransProfFilterEthertype(new Long(onuVlanTransProfFilterEthertypeVList[tfOnuVlanTransProfFilterEthertype.getSelectedIndex()]));
        mbean.setOnuVlanTransProfTreatmentTagsRemove(onuVlanTransProfTreatmentTagsRemoveVList[tfOnuVlanTransProfTreatmentTagsRemove.getSelectedIndex()]);
        mbean.setOnuVlanTransProfTreatmentOuterPriority(onuVlanTransProfTreatmentOuterPriorityVList[tfOnuVlanTransProfTreatmentOuterPriority.getSelectedIndex()]);
        mbean.setOnuVlanTransProfTreatmentOuterVID(new Long(tfOnuVlanTransProfTreatmentOuterVID.getValue()));
        mbean.setOnuVlanTransProfTreatmentOuterTPIDDE(onuVlanTransProfTreatmentOuterTPIDDEVList[tfOnuVlanTransProfTreatmentOuterTPIDDE.getSelectedIndex()]);
        mbean.setOnuVlanTransProfTreatmentInnerPriority(onuVlanTransProfTreatmentInnerPriorityVList[tfOnuVlanTransProfTreatmentInnerPriority.getSelectedIndex()]);
        mbean.setOnuVlanTransProfTreatmentInnerVID(new Long(tfOnuVlanTransProfTreatmentInnerVID.getValue()));
        mbean.setOnuVlanTransProfTreatmentInnerTPIDDE(onuVlanTransProfTreatmentInnerTPIDDEVList[tfOnuVlanTransProfTreatmentInnerTPIDDE.getSelectedIndex()]);
        mbean.setOnuVlanTransProfTreatmentTagsMode(onuVlanTransProfTreatmentTagsModeVList[tfOnuVlanTransProfTreatmentTagsMode.getSelectedIndex()]);
    }

    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuVlanTransProfIndex.increaseIndexValue();
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

}
/**
 * Title          :   OltVlanTransProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltVlanTransProfTable;
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

public class OltVlanTransProfTablePanel extends UPanel {

//    private LongIndexGenField tfOltVlanTransProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOltVlanTransProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField tfOltVlanTransProfIndex = new IndexAutoGenField(fApplication,2);
    private StringTextField tfOltVlanTransProfileName = new StringTextField();

    private int[] oltVlanTransProfDownstreamModeVList = new int[]{0, 1};
    private String[] oltVlanTransProfDownstreamModeTList = new String[]{fStringMap.getString("operation"), fStringMap.getString("no-operation")};
    private JComboBox tfOltVlanTransProfDownstreamMode = new JComboBox(oltVlanTransProfDownstreamModeTList);

    private HexTextField tfOltVlanTransProfInputTPID = new HexTextField();
    private HexTextField tfOltVlanTransProfOutputTPID = new HexTextField();
    
    private long[] oltVlanTransProfFilterOuterPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,14,15};
    private String[] oltVlanTransProfFilterOuterPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","14","15"};
    private JComboBox tfOltVlanTransProfFilterOuterPriority = new JComboBox(oltVlanTransProfFilterOuterPriorityTList);
    
    private LongTextField tfOltVlanTransProfFilterOuterVID = new LongTextField();

    private int[] oltVlanTransProfFilterOuterTPIDDEVList = new int[]{0, 4, 5, 6, 7};
    private String[] oltVlanTransProfFilterOuterTPIDDETList = new String[]{fStringMap.getString("no-filter"), fStringMap.getString("outer-TPID-8100")
            , fStringMap.getString("input-TPID"), fStringMap.getString("input-TPID-DE-0"), fStringMap.getString("input-TPID-DE-1")};
    private JComboBox tfOltVlanTransProfFilterOuterTPIDDE = new JComboBox(oltVlanTransProfFilterOuterTPIDDETList);

    private long[] oltVlanTransProfFilterInnerPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,14,15};
    private String[] oltVlanTransProfFilterInnerPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","14","15"};
    private JComboBox tfOltVlanTransProfFilterInnerPriority = new JComboBox(oltVlanTransProfFilterInnerPriorityTList);
    
    private LongTextField tfOltVlanTransProfFilterInnerVID = new LongTextField();
    private int[] oltVlanTransProfFilterInnerTPIDDEVList = new int[]{0, 4, 5, 6, 7};
    private String[] oltVlanTransProfFilterInnerTPIDDETList = new String[]{fStringMap.getString("no-filter"), fStringMap.getString("outer-TPID-8100")
            , fStringMap.getString("input-TPID"), fStringMap.getString("input-TPID-DE-0"), fStringMap.getString("input-TPID-DE-1")};
    private JComboBox tfOltVlanTransProfFilterInnerTPIDDE = new JComboBox(oltVlanTransProfFilterOuterTPIDDETList);

    private int[] oltVlanTransProfFilterEthertypeVList = new int[]{0,1,2,3};

    private String[] oltVlanTransProfFilterEthertypeTList = new String[]{fStringMap.getString("Don't filter on Ethertype"),
 			fStringMap.getString("filter IPoE frames"),fStringMap.getString("filter PPPoE frames"),fStringMap.getString("filter ARP frames")};
    private JComboBox tfOltVlanTransProfFilterEthertype = new JComboBox(oltVlanTransProfFilterEthertypeTList);

    private int[] oltVlanTransProfTreatmentTagsRemoveVList = new int[]{1, 2, 3, 4};
    private String[] oltVlanTransProfTreatmentTagsRemoveTList = new String[]{fStringMap.getString("do-not-remove"), fStringMap.getString("remove-outer-tag"),fStringMap.getString("remove-inner-tag"), fStringMap.getString("remove-all")};
    private JComboBox tfOltVlanTransProfTreatmentTagsRemove = new JComboBox(oltVlanTransProfTreatmentTagsRemoveTList);

    private long[] oltVlanTransProfTreatmentOuterPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,9,15};
    private String[] oltVlanTransProfTreatmentOuterPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","9","15"};
    private JComboBox tfOltVlanTransProfTreatmentOuterPriority = new JComboBox(oltVlanTransProfTreatmentOuterPriorityTList);
    
    private LongTextField tfOltVlanTransProfTreatmentOuterVID = new LongTextField();
    private int[] oltVlanTransProfTreatmentOuterTPIDDEVList = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private String[] oltVlanTransProfTreatmentOuterTPIDDETList = new String[]{fStringMap.getString("copy-tpid-inner"),
            fStringMap.getString("copy-tpid-outer"), fStringMap.getString("set-tpid-output-copy-de-inner"), fStringMap.getString("set-tpid-output-copy-de-outer"),
            fStringMap.getString("set-tpid-0x8100"), fStringMap.getString("reserved"), fStringMap.getString("set-tpid-output-de-0"), fStringMap.getString("set-tpid-output-de-1")};
    private JComboBox tfOltVlanTransProfTreatmentOuterTPIDDE = new JComboBox(oltVlanTransProfTreatmentOuterTPIDDETList);

    private long[] oltVlanTransProfTreatmentInnerPriorityVList = new long[]{0,1,2,3,4,5,6,7,8,9,15};
    private String[] oltVlanTransProfTreatmentInnerPriorityTList = new String[]{"0","1","2","3","4","5","6","7","8","9","15"};
    private JComboBox tfOltVlanTransProfTreatmentInnerPriority = new JComboBox(oltVlanTransProfTreatmentInnerPriorityTList);
    
    private LongTextField tfOltVlanTransProfTreatmentInnerVID = new LongTextField();
    private int[] oltVlanTransProfTreatmentInnerTPIDDEVList = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private String[] oltVlanTransProfTreatmentInnerTPIDDETList = new String[]{fStringMap.getString("copy-tpid-inner"),
            fStringMap.getString("copy-tpid-outer"), fStringMap.getString("set-tpid-output-copy-de-inner"), fStringMap.getString("set-tpid-output-copy-de-outer"),
            fStringMap.getString("set-tpid-0x8100"), fStringMap.getString("reserved"), fStringMap.getString("set-tpid-output-de-0"), fStringMap.getString("set-tpid-output-de-1")};
    private JComboBox tfOltVlanTransProfTreatmentInnerTPIDDE = new JComboBox(oltVlanTransProfTreatmentInnerTPIDDETList);

    private int[] oltVlanTransProfTreatmentTagsModeVList = new int[]{1, 2, 3, 4};
    private String[] oltVlanTransProfTreatmentTagsModeTList = new String[]{fStringMap.getString("sit"), fStringMap.getString("sot")
            , fStringMap.getString("dt"), fStringMap.getString("unknown")};
    private JComboBox tfOltVlanTransProfTreatmentTagsMode = new JComboBox(oltVlanTransProfTreatmentTagsModeTList);


    private final String oltVlanTransProfIndex1 =
            fStringMap.getString("oltVlanTransProfIndex1") + " : ";
    private final String oltVlanTransProfIndex2 = fStringMap.getString("oltVlanTransProfIndex2");
    private final String oltVlanTransProfileName =
            fStringMap.getString("oltVlanTransProfileName") + " : ";
    private final String oltVlanTransProfDownstreamMode =
            fStringMap.getString("oltVlanTransProfDownstreamMode") + " : ";
    private final String oltVlanTransProfInputTPID =
            fStringMap.getString("oltVlanTransProfInputTPID") + " : ";
    private final String oltVlanTransProfOutputTPID =
            fStringMap.getString("oltVlanTransProfOutputTPID") + " : ";
    private final String oltVlanTransProfFilterOuterPriority =
            fStringMap.getString("oltVlanTransProfFilterOuterPriority") + " : ";
    private final String oltVlanTransProfFilterOuterVID =
            fStringMap.getString("oltVlanTransProfFilterOuterVID") + " : ";
    private final String oltVlanTransProfFilterOuterTPIDDE = fStringMap.getString("oltVlanTransProfFilterOuterTPIDDE") + " : ";
    private final String oltVlanTransProfFilterInnerPriority =
            fStringMap.getString("oltVlanTransProfFilterInnerPriority") + " : ";
    private final String oltVlanTransProfFilterInnerVID =
            fStringMap.getString("oltVlanTransProfFilterInnerVID") + " : ";
    private final String oltVlanTransProfFilterInnerTPIDDE = fStringMap.getString("oltVlanTransProfFilterInnerTPIDDE") + " : ";

    private final String oltVlanTransProfFilterEthertype =
            fStringMap.getString("oltVlanTransProfFilterEthertype") + " : ";
    private final String oltVlanTransProfTreatmentTagsRemove =
            fStringMap.getString("oltVlanTransProfTreatmentTagsRemove") + " : ";
    private final String oltVlanTransProfTreatmentOuterPriority =
            fStringMap.getString("oltVlanTransProfTreatmentOuterPriority") + " : ";
    private final String oltVlanTransProfTreatmentOuterVID =
            fStringMap.getString("oltVlanTransProfTreatmentOuterVID") + " : ";
    private final String oltVlanTransProfTreatmentOuterTPIDDE = fStringMap.getString("oltVlanTransProfTreatmentOuterTPIDDE") + " : ";

    private final String oltVlanTransProfTreatmentInnerPriority =
            fStringMap.getString("oltVlanTransProfTreatmentInnerPriority") + " : ";
    private final String oltVlanTransProfTreatmentInnerVID =
            fStringMap.getString("oltVlanTransProfTreatmentInnerVID") + " : ";
    private final String oltVlanTransProfTreatmentInnerTPIDDE = fStringMap.getString("oltVlanTransProfTreatmentInnerTPIDDE") + " : ";
    private final String oltVlanTransProfTreatmentTagsMode = fStringMap.getString("oltVlanTransProfTreatmentTagsMode") + " : ";

    public OltVlanTransProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(21, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(oltVlanTransProfIndex1));
        baseInfoPanel.add(tfOltVlanTransProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfIndex2));
        baseInfoPanel.add(tfOltVlanTransProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfileName));
        tfOltVlanTransProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOltVlanTransProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfDownstreamMode));
        tfOltVlanTransProfDownstreamMode.setName(fStringMap.getString("oltVlanTransProfDownstreamMode"));
        baseInfoPanel.add(tfOltVlanTransProfDownstreamMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfInputTPID));
        tfOltVlanTransProfInputTPID.setName(fStringMap.getString("oltVlanTransProfInputTPID"));
        baseInfoPanel.add(tfOltVlanTransProfInputTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfOutputTPID));
        tfOltVlanTransProfOutputTPID.setName(fStringMap.getString("oltVlanTransProfOutputTPID"));
        baseInfoPanel.add(tfOltVlanTransProfOutputTPID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(oltVlanTransProfFilterOuterPriority));
        tfOltVlanTransProfFilterOuterPriority.setName(fStringMap.getString("oltVlanTransProfFilterOuterPriority"));
        baseInfoPanel.add(tfOltVlanTransProfFilterOuterPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(oltVlanTransProfFilterOuterVID));
        tfOltVlanTransProfFilterOuterVID.setName(fStringMap.getString("oltVlanTransProfFilterOuterVID"));
        baseInfoPanel.add(tfOltVlanTransProfFilterOuterVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfFilterOuterTPIDDE));
        tfOltVlanTransProfFilterOuterTPIDDE.setName(fStringMap.getString("oltVlanTransProfFilterOuterTPIDDE"));
        baseInfoPanel.add(tfOltVlanTransProfFilterOuterTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfFilterInnerPriority));
        tfOltVlanTransProfFilterInnerPriority.setName(fStringMap.getString("oltVlanTransProfFilterInnerPriority"));
        baseInfoPanel.add(tfOltVlanTransProfFilterInnerPriority);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfFilterInnerVID));
        tfOltVlanTransProfFilterInnerVID.setName(fStringMap.getString("oltVlanTransProfFilterInnerVID"));
        baseInfoPanel.add(tfOltVlanTransProfFilterInnerVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfFilterInnerTPIDDE));
        tfOltVlanTransProfFilterInnerTPIDDE.setName(fStringMap.getString("oltVlanTransProfFilterInnerTPIDDE"));
        baseInfoPanel.add(tfOltVlanTransProfFilterInnerTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfFilterEthertype));
        tfOltVlanTransProfFilterEthertype.setName(fStringMap.getString("oltVlanTransProfFilterEthertype"));
        baseInfoPanel.add(tfOltVlanTransProfFilterEthertype);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfTreatmentTagsRemove));
        tfOltVlanTransProfTreatmentTagsRemove.setName(fStringMap.getString("oltVlanTransProfTreatmentTagsRemove"));
        baseInfoPanel.add(tfOltVlanTransProfTreatmentTagsRemove);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(oltVlanTransProfTreatmentOuterPriority));
        tfOltVlanTransProfTreatmentOuterPriority.setName(fStringMap.getString("oltVlanTransProfTreatmentOuterPriority"));
        baseInfoPanel.add(tfOltVlanTransProfTreatmentOuterPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(oltVlanTransProfTreatmentOuterVID));
        tfOltVlanTransProfTreatmentOuterVID.setName(fStringMap.getString("oltVlanTransProfTreatmentOuterVID"));
        baseInfoPanel.add(tfOltVlanTransProfTreatmentOuterVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfTreatmentOuterTPIDDE));
        tfOltVlanTransProfTreatmentOuterTPIDDE.setName(fStringMap.getString("oltVlanTransProfTreatmentOuterTPIDDE"));
        baseInfoPanel.add(tfOltVlanTransProfTreatmentOuterTPIDDE);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(oltVlanTransProfTreatmentInnerPriority));
        tfOltVlanTransProfTreatmentInnerPriority.setName(fStringMap.getString("oltVlanTransProfTreatmentInnerPriority"));
        baseInfoPanel.add(tfOltVlanTransProfTreatmentInnerPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(oltVlanTransProfTreatmentInnerVID));
        tfOltVlanTransProfTreatmentInnerVID.setName(fStringMap.getString("oltVlanTransProfTreatmentInnerVID"));
        baseInfoPanel.add(tfOltVlanTransProfTreatmentInnerVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfTreatmentInnerTPIDDE));
        tfOltVlanTransProfTreatmentInnerTPIDDE.setName(fStringMap.getString("oltVlanTransProfTreatmentInnerTPIDDE"));
        baseInfoPanel.add(tfOltVlanTransProfTreatmentInnerTPIDDE);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltVlanTransProfTreatmentTagsMode));
        tfOltVlanTransProfTreatmentTagsMode.setName(fStringMap.getString("oltVlanTransProfTreatmentTagsMode"));
        baseInfoPanel.add(tfOltVlanTransProfTreatmentTagsMode);
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

        tfOltVlanTransProfInputTPID.setLenScope(1, 4);
        tfOltVlanTransProfInputTPID.setDefaultString("8100");
        tfOltVlanTransProfOutputTPID.setLenScope(1, 4);
        tfOltVlanTransProfOutputTPID.setDefaultString("88a8"); 
        tfOltVlanTransProfFilterOuterVID.setValueScope(0, 4096);
        tfOltVlanTransProfFilterOuterVID.setValue(4096);
        tfOltVlanTransProfFilterInnerVID.setValueScope(0, 4096);
        tfOltVlanTransProfFilterInnerVID.setValue(101);
        tfOltVlanTransProfTreatmentOuterVID.setValueScope(0, 4097);
        tfOltVlanTransProfTreatmentOuterVID.setValue(1000);
        tfOltVlanTransProfTreatmentInnerVID.setValueScope(0, 4097);
        tfOltVlanTransProfTreatmentInnerVID.setValue(4096);
        tfOltVlanTransProfIndex.setValueScope(0,2, 128);
        tfOltVlanTransProfIndex.setValueScope(1,1, 64);
        tfOltVlanTransProfFilterOuterPriority.setSelectedIndex(getIndexFromValue(oltVlanTransProfFilterOuterPriorityVList, 8));
        tfOltVlanTransProfFilterInnerPriority.setSelectedIndex(getIndexFromValue(oltVlanTransProfFilterInnerPriorityVList, 8));
        tfOltVlanTransProfTreatmentOuterPriority.setSelectedIndex(getIndexFromValue(oltVlanTransProfTreatmentOuterPriorityVList, 8));
        tfOltVlanTransProfTreatmentInnerPriority.setSelectedIndex(getIndexFromValue(oltVlanTransProfTreatmentInnerPriorityVList, 15));
        
     
    }
    public boolean validateFrom(){
    	String msg = null;
        
    	if(tfOltVlanTransProfFilterOuterVID.getValue()==4095){
    		msg = fStringMap.getString("FilterOuterVID_4095_Reserved");
    		JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);	
    	return false;
    	}
    	if(tfOltVlanTransProfFilterInnerVID.getValue()==4095){
    		msg = fStringMap.getString("FilterInnerVID_4095_Reserved");
    		JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
    		return false;
    	}
    	if(tfOltVlanTransProfTreatmentOuterVID.getValue()==4095){
    		msg = fStringMap.getString("TreatmentOuterVID_4095_Reserved");
    		JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
    		return false;
    	}
    	if(tfOltVlanTransProfTreatmentInnerVID.getValue()==4095){
    		msg = fStringMap.getString("TreatmentInnerVID_4095_Reserved");
    		JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
    		return false;
    		
    	}
    	return true;
    	
    }
    

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOltVlanTransProfIndex.setEnabled(true);
            tfOltVlanTransProfIndex.setTable(fTable);
            tfOltVlanTransProfIndex.refresh();
            return;
        } else {
            tfOltVlanTransProfIndex.setEnabled(false);
        }

        OltVlanTransProfTable mbean = (OltVlanTransProfTable) getModel();

        tfOltVlanTransProfIndex.setValue(0,mbean.getOltVlanTransProfIndex1());
        tfOltVlanTransProfIndex.setValue(1,mbean.getOltVlanTransProfIndex2());
        tfOltVlanTransProfileName.setValue(mbean.getOltVlanTransProfileName());
        tfOltVlanTransProfDownstreamMode.setSelectedIndex(getIndexFromValue(oltVlanTransProfDownstreamModeVList, mbean.getOltVlanTransProfDownstreamMode().intValue()));
        tfOltVlanTransProfInputTPID.setValue(Long.toHexString(mbean.getOltVlanTransProfInputTPID()));
        tfOltVlanTransProfOutputTPID.setValue(Long.toHexString(mbean.getOltVlanTransProfOutputTPID()));
        tfOltVlanTransProfFilterOuterPriority.setSelectedIndex(getIndexFromValue(oltVlanTransProfFilterOuterPriorityVList, mbean.getOltVlanTransProfFilterOuterPriority()));
        tfOltVlanTransProfFilterOuterVID.setValue(mbean.getOltVlanTransProfFilterOuterVID().intValue());
        tfOltVlanTransProfFilterOuterTPIDDE.setSelectedIndex(getIndexFromValue(oltVlanTransProfFilterOuterTPIDDEVList, mbean.getOltVlanTransProfFilterOuterTPIDDE().intValue()));
        tfOltVlanTransProfFilterInnerPriority.setSelectedIndex(getIndexFromValue(oltVlanTransProfFilterInnerPriorityVList, mbean.getOltVlanTransProfFilterInnerPriority()));
        tfOltVlanTransProfFilterInnerVID.setValue(mbean.getOltVlanTransProfFilterInnerVID().intValue());
        tfOltVlanTransProfFilterInnerTPIDDE.setSelectedIndex(getIndexFromValue(oltVlanTransProfFilterInnerTPIDDEVList, mbean.getOltVlanTransProfFilterInnerTPIDDE().intValue()));
        tfOltVlanTransProfFilterEthertype.setSelectedIndex(getIndexFromValue(oltVlanTransProfFilterEthertypeVList, mbean.getOltVlanTransProfFilterEthertype().intValue()));
        tfOltVlanTransProfTreatmentTagsRemove.setSelectedIndex(getIndexFromValue(oltVlanTransProfTreatmentTagsRemoveVList, mbean.getOltVlanTransProfTreatmentTagsRemove().intValue()));
        tfOltVlanTransProfTreatmentOuterPriority.setSelectedIndex(getIndexFromValue(oltVlanTransProfTreatmentOuterPriorityVList, mbean.getOltVlanTransProfTreatmentOuterPriority()));
        tfOltVlanTransProfTreatmentOuterVID.setValue(mbean.getOltVlanTransProfTreatmentOuterVID().intValue());
        tfOltVlanTransProfTreatmentOuterTPIDDE.setSelectedIndex(getIndexFromValue(oltVlanTransProfTreatmentOuterTPIDDEVList, mbean.getOltVlanTransProfTreatmentOuterTPIDDE().intValue()));
        tfOltVlanTransProfTreatmentInnerPriority.setSelectedIndex(getIndexFromValue(oltVlanTransProfTreatmentInnerPriorityVList, mbean.getOltVlanTransProfTreatmentInnerPriority()));
        tfOltVlanTransProfTreatmentInnerVID.setValue(mbean.getOltVlanTransProfTreatmentInnerVID().intValue());
        tfOltVlanTransProfTreatmentInnerTPIDDE.setSelectedIndex(getIndexFromValue(oltVlanTransProfTreatmentInnerTPIDDEVList, mbean.getOltVlanTransProfTreatmentInnerTPIDDE().intValue()));
        tfOltVlanTransProfTreatmentTagsMode.setSelectedIndex(getIndexFromValue(oltVlanTransProfTreatmentTagsModeVList, mbean.getOltVlanTransProfTreatmentTagsMode().intValue()));
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OltVlanTransProfTable(fApplication.getSnmpProxy()));

        OltVlanTransProfTable mbean = (OltVlanTransProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOltVlanTransProfIndex1(tfOltVlanTransProfIndex.getValue(0));
            mbean.setOltVlanTransProfIndex2(tfOltVlanTransProfIndex.getValue(1));
        }

        mbean.setOltVlanTransProfileName(new String(tfOltVlanTransProfileName.getValue()));
        mbean.setOltVlanTransProfDownstreamMode(oltVlanTransProfDownstreamModeVList[tfOltVlanTransProfDownstreamMode.getSelectedIndex()]);
        mbean.setOltVlanTransProfInputTPID(Long.parseLong(tfOltVlanTransProfInputTPID.getValue(), 16));
        mbean.setOltVlanTransProfOutputTPID(Long.parseLong(tfOltVlanTransProfOutputTPID.getValue(),16));
        mbean.setOltVlanTransProfFilterOuterPriority(oltVlanTransProfFilterOuterPriorityVList[tfOltVlanTransProfFilterOuterPriority.getSelectedIndex()]);
        mbean.setOltVlanTransProfFilterOuterVID(new Long(tfOltVlanTransProfFilterOuterVID.getValue()));
        mbean.setOltVlanTransProfFilterOuterTPIDDE(oltVlanTransProfFilterOuterTPIDDEVList[tfOltVlanTransProfFilterOuterTPIDDE.getSelectedIndex()]);
        mbean.setOltVlanTransProfFilterInnerPriority(oltVlanTransProfFilterInnerPriorityVList[tfOltVlanTransProfFilterInnerPriority.getSelectedIndex()]);
        mbean.setOltVlanTransProfFilterInnerVID(new Long(tfOltVlanTransProfFilterInnerVID.getValue()));
        mbean.setOltVlanTransProfFilterInnerTPIDDE(oltVlanTransProfFilterInnerTPIDDEVList[tfOltVlanTransProfFilterInnerTPIDDE.getSelectedIndex()]);
        mbean.setOltVlanTransProfFilterEthertype(new Long(oltVlanTransProfFilterEthertypeVList[tfOltVlanTransProfFilterEthertype.getSelectedIndex()]));
        mbean.setOltVlanTransProfTreatmentTagsRemove(oltVlanTransProfTreatmentTagsRemoveVList[tfOltVlanTransProfTreatmentTagsRemove.getSelectedIndex()]);
        mbean.setOltVlanTransProfTreatmentOuterPriority(oltVlanTransProfTreatmentOuterPriorityVList[tfOltVlanTransProfTreatmentOuterPriority.getSelectedIndex()]);
        mbean.setOltVlanTransProfTreatmentOuterVID(new Long(tfOltVlanTransProfTreatmentOuterVID.getValue()));
        mbean.setOltVlanTransProfTreatmentOuterTPIDDE(oltVlanTransProfTreatmentOuterTPIDDEVList[tfOltVlanTransProfTreatmentOuterTPIDDE.getSelectedIndex()]);
        mbean.setOltVlanTransProfTreatmentInnerPriority(oltVlanTransProfTreatmentInnerPriorityVList[tfOltVlanTransProfTreatmentInnerPriority.getSelectedIndex()]);
        mbean.setOltVlanTransProfTreatmentInnerVID(new Long(tfOltVlanTransProfTreatmentInnerVID.getValue()));
        mbean.setOltVlanTransProfTreatmentInnerTPIDDE(oltVlanTransProfTreatmentInnerTPIDDEVList[tfOltVlanTransProfTreatmentInnerTPIDDE.getSelectedIndex()]);
        mbean.setOltVlanTransProfTreatmentTagsMode(oltVlanTransProfTreatmentTagsModeVList[tfOltVlanTransProfTreatmentTagsMode.getSelectedIndex()]);
    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOltVlanTransProfIndex.increaseIndexValue();
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
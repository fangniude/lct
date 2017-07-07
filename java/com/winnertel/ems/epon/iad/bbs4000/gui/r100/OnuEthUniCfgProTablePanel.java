/**
 * Title          :   OnuEthUniCfgProTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuEthUniCfgProTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shen Dayong
 *         Create on 2008-9-30
 *         Modify by HZ21044
 */

public class OnuEthUniCfgProTablePanel extends UPanel {

    private IndexAutoGenField tfOnuEthUniCfgProEthernetUNIProfileIndex = new IndexAutoGenField(fApplication,1);

    private StringTextField tfOnuEthUniCfgProProfileName = new StringTextField();

    //    private LongTextField tfOnuEthUniCfgProAutoNegotiation = new LongTextField();
    private int[] onuEthUniCfgProAutoNegotiationVList = new int[]{1, 2};
    private String[] onuEthUniCfgProAutoNegotiationTList = new String[]{
            fStringMap.getString("enabled"), fStringMap.getString("disabled")};
    private JComboBox tfOnuEthUniCfgProAutoNegotiation = new JComboBox(
            onuEthUniCfgProAutoNegotiationTList);

    //    private LongTextField tfOnuEthUniCfgProSpeed = new LongTextField();
    private int[] onuEthUniCfgProSpeedVList = new int[]{1, 2, 3};
    private String[] onuEthUniCfgProSpeedTList = new String[]{
            fStringMap.getString("10Mbps"), fStringMap.getString("100Mbps"),
            fStringMap.getString("1000Mbps")};
    private JComboBox tfOnuEthUniCfgProSpeed = new JComboBox(
            onuEthUniCfgProSpeedTList);

    //    private LongTextField tfOnuEthUniCfgProDuplex = new LongTextField();
    private int[] onuEthUniCfgProDuplexVList = new int[]{1, 2};
    private String[] onuEthUniCfgProDuplexTList = new String[]{
            fStringMap.getString("full"), fStringMap.getString("half")};
    private JComboBox tfOnuEthUniCfgProDuplex = new JComboBox(
            onuEthUniCfgProDuplexTList);

    private JComboBox tfOnuEthUniCfgProExpectedType = new JComboBox();

    private LongTextField tfOnuEthUniCfgProMaxFrameSize = new LongTextField();

    //    private LongTextField tfOnuEthUniCfgProIndDTEDCE = new LongTextField();
    private int[] onuEthUniCfgProIndDTEDCEVList = new int[]{1, 2};
    private String[] onuEthUniCfgProIndDTEDCETList = new String[]{
            fStringMap.getString("DCE"), fStringMap.getString("DTE")};
    private JComboBox tfOnuEthUniCfgProIndDTEDCE = new JComboBox(
            onuEthUniCfgProIndDTEDCETList);

    private final String onuEthUniCfgProEthernetUNIProfileIndex =
            fStringMap.getString("onuEthUniCfgProEthernetUNIProfileIndex") + " : ";
    private final String onuEthUniCfgProProfileName =
            fStringMap.getString("onuEthUniCfgProProfileName") + " : ";
    private final String onuEthUniCfgProAutoNegotiation =
            fStringMap.getString("onuEthUniCfgProAutoNegotiation") + " : ";
    private final String onuEthUniCfgProSpeed =
            fStringMap.getString("onuEthUniCfgProSpeed") + " : ";
    private final String onuEthUniCfgProDuplex =
            fStringMap.getString("onuEthUniCfgProDuplex") + " : ";
    private final String onuEthUniCfgProExpectedType =
            fStringMap.getString("onuEthUniCfgProExpectedType") + " : ";
    private final String onuEthUniCfgProMaxFrameSize =
            fStringMap.getString("onuEthUniCfgProMaxFrameSize") + " : ";
    private final String onuEthUniCfgProIndDTEDCE =
            fStringMap.getString("onuEthUniCfgProIndDTEDCE") + " : ";

    public OnuEthUniCfgProTablePanel(IApplication app) {
        super(app);
        setModel(new OnuEthUniCfgProTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuEthUniCfgProEthernetUNIProfileIndex));
        baseInfoPanel.add(tfOnuEthUniCfgProEthernetUNIProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgProProfileName));
        tfOnuEthUniCfgProProfileName.setName(fStringMap.getString("onuEthUniCfgProProfileName"));
        tfOnuEthUniCfgProProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuEthUniCfgProProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgProAutoNegotiation));
        tfOnuEthUniCfgProAutoNegotiation.setName(fStringMap.getString("onuEthUniCfgProAutoNegotiation"));
        baseInfoPanel.add(tfOnuEthUniCfgProAutoNegotiation);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgProSpeed));
        tfOnuEthUniCfgProSpeed.setName(fStringMap.getString("onuEthUniCfgProSpeed"));
        baseInfoPanel.add(tfOnuEthUniCfgProSpeed);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgProDuplex));
        tfOnuEthUniCfgProDuplex.setName(fStringMap.getString("onuEthUniCfgProDuplex"));
        baseInfoPanel.add(tfOnuEthUniCfgProDuplex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgProExpectedType));
        tfOnuEthUniCfgProExpectedType.setName(fStringMap.getString("onuEthUniCfgProExpectedType"));
        baseInfoPanel.add(tfOnuEthUniCfgProExpectedType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgProMaxFrameSize));
        tfOnuEthUniCfgProMaxFrameSize.setName(fStringMap.getString("onuEthUniCfgProMaxFrameSize"));
        baseInfoPanel.add(tfOnuEthUniCfgProMaxFrameSize);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgProIndDTEDCE));
        tfOnuEthUniCfgProIndDTEDCE.setName(fStringMap.getString("onuEthUniCfgProIndDTEDCE"));
        baseInfoPanel.add(tfOnuEthUniCfgProIndDTEDCE);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(int i=0;i<=254;i++){
        	tfOnuEthUniCfgProExpectedType.addItem(i);
        }
        
    }

    protected void initForm() {
        tfOnuEthUniCfgProEthernetUNIProfileIndex.setValueScope(0,2, 32);
    //    tfOnuEthUniCfgProExpectedType.setValueScope(0, 254);
       tfOnuEthUniCfgProMaxFrameSize.setValueScope(0, 4294967295l);
        tfOnuEthUniCfgProMaxFrameSize.setValue(1522);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuEthUniCfgProEthernetUNIProfileIndex.setEnabled(true);
            tfOnuEthUniCfgProEthernetUNIProfileIndex.setTable(fTable);
            tfOnuEthUniCfgProEthernetUNIProfileIndex.refresh();
            return;
        } else {
            tfOnuEthUniCfgProEthernetUNIProfileIndex.setEnabled(false);
        }

        OnuEthUniCfgProTable mbean = (OnuEthUniCfgProTable) getModel();
        BeanService.refreshBean(fApplication, mbean);

        String sValue = "";
        int iValue = 0;
        long lValue = 0;

        tfOnuEthUniCfgProEthernetUNIProfileIndex.setValue(0,mbean.getOnuEthUniCfgProEthernetUNIProfileIndex());

        try {
            sValue = mbean.getOnuEthUniCfgProProfileName();
        } catch (Exception e) {
            sValue = "";
        }
        tfOnuEthUniCfgProProfileName.setValue(sValue);

        try {
            iValue = getIndexFromValue(onuEthUniCfgProAutoNegotiationVList, mbean.getOnuEthUniCfgProAutoNegotiation().intValue());
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuEthUniCfgProAutoNegotiation.setSelectedIndex(iValue);

        try {
            iValue = getIndexFromValue(onuEthUniCfgProAutoNegotiationVList, mbean.getOnuEthUniCfgProSpeed().intValue());
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuEthUniCfgProSpeed.setSelectedIndex(iValue);

        try {
            iValue = getIndexFromValue(onuEthUniCfgProDuplexVList, mbean.getOnuEthUniCfgProDuplex().intValue());
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuEthUniCfgProDuplex.setSelectedIndex(iValue);

        try {
            iValue = mbean.getOnuEthUniCfgProExpectedType().intValue();
        } catch (Exception e) {
            lValue = 0;
        }
        tfOnuEthUniCfgProExpectedType.setSelectedItem(iValue);

        try {
            lValue = mbean.getOnuEthUniCfgProMaxFrameSize().longValue();
        } catch (Exception e) {
            lValue = 0;
        }
        tfOnuEthUniCfgProMaxFrameSize.setValue(lValue);

        try {
            iValue = getIndexFromValue(onuEthUniCfgProIndDTEDCEVList, mbean.getOnuEthUniCfgProIndDTEDCE().intValue());
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuEthUniCfgProIndDTEDCE.setSelectedIndex(iValue);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new OnuEthUniCfgProTable(fApplication.getSnmpProxy()));
        }

        OnuEthUniCfgProTable mbean = (OnuEthUniCfgProTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuEthUniCfgProEthernetUNIProfileIndex(tfOnuEthUniCfgProEthernetUNIProfileIndex.getValue(0));
        }

        mbean.setOnuEthUniCfgProProfileName(new String(tfOnuEthUniCfgProProfileName.getValue()));
        mbean.setOnuEthUniCfgProAutoNegotiation(new Integer(
                onuEthUniCfgProAutoNegotiationVList[tfOnuEthUniCfgProAutoNegotiation.getSelectedIndex()]));
        mbean.setOnuEthUniCfgProSpeed(new Integer(onuEthUniCfgProAutoNegotiationVList[tfOnuEthUniCfgProSpeed.getSelectedIndex()]));
        mbean.setOnuEthUniCfgProDuplex(new Integer(onuEthUniCfgProDuplexVList[tfOnuEthUniCfgProDuplex.getSelectedIndex()]));
        mbean.setOnuEthUniCfgProExpectedType(new Long(tfOnuEthUniCfgProExpectedType.getSelectedItem().toString()));
        mbean.setOnuEthUniCfgProMaxFrameSize(new Long(tfOnuEthUniCfgProMaxFrameSize.getValue()));
        mbean.setOnuEthUniCfgProIndDTEDCE(new Integer(onuEthUniCfgProIndDTEDCEVList[tfOnuEthUniCfgProIndDTEDCE.getSelectedIndex()]));
    }

    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
        tfOnuEthUniCfgProEthernetUNIProfileIndex.increaseIndexValue();
    }
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
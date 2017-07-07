/**
 * Title          :   OnuStaticMultiGroupProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuStaticMultiGroupProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.input.base.IPAddressDataLayer;
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

public class OnuStaticMultiGroupProfTablePanel extends UPanel {

//    private LongIndexGenField tfOnuStaticMultiGroupProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOnuStaticMultiGroupProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField tfOnuStaticMultiGroupProfIndex = new IndexAutoGenField(fApplication,2);
    private StringTextField tfOnuStaticMultiGroupProfileName = new StringTextField();

    private LongTextField tfOnuStaticMultiGroupProfMulticastGemPortNo = new LongTextField();
    private LongTextField tfOnuStaticMultiGroupProfMulticastVLANID = new LongTextField();
    private IPAddressField tfOnuStaticMultiGroupProfSourceIPAddress =
            new IPAddressField();

    private IPAddressField tfOnuStaticMultiGroupProfMulticastGroupAddressStart =
            new IPAddressField(IPAddressDataLayer.IPMULTICAST);

    private IPAddressField tfOnuStaticMultiGroupProfMulticastGroupAddressStop =
            new IPAddressField(IPAddressDataLayer.IPMULTICAST);
    private LongTextField tfOnuStaticMultiGroupProfImputedGroupBandwidth = new LongTextField();

    private final String onuStaticMultiGroupProfIndex1 =
            fStringMap.getString("onuStaticMultiGroupProfIndex1") + " : ";
    private final String onuStaticMultiGroupProfIndex2 =
            fStringMap.getString("onuStaticMultiGroupProfIndex2") + " : ";
    private final String onuStaticMultiGroupProfileName =
            fStringMap.getString("onuStaticMultiGroupProfileName") + " : ";
    private final String onuStaticMultiGroupProfMulticastGroupAddressStart =
            fStringMap.getString("onuStaticMultiGroupProfMulticastGroupAddressStart") + " : ";
    private final String onuStaticMultiGroupProfMulticastGroupAddressStop =
            fStringMap.getString("onuStaticMultiGroupProfMulticastGroupAddressStop") + " : ";
    private final String onuStaticMultiGroupProfMulticastGemPortNo =
            fStringMap.getString("onuStaticMultiGroupProfMulticastGemPortNo") + " : ";
    private final String onuStaticMultiGroupProfMulticastVLANID =
            fStringMap.getString("onuStaticMultiGroupProfMulticastVLANID") + " : ";
    private final String onuStaticMultiGroupProfSourceIPAddress =
            fStringMap.getString("onuStaticMultiGroupProfSourceIPAddress") + " : ";
    private final String onuStaticMultiGroupProfImputedGroupBandwidth =
            fStringMap.getString("onuStaticMultiGroupProfImputedGroupBandwidth") + " : ";

    public OnuStaticMultiGroupProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfIndex1));
        baseInfoPanel.add(tfOnuStaticMultiGroupProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfIndex2));
        baseInfoPanel.add(tfOnuStaticMultiGroupProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfileName));
        tfOnuStaticMultiGroupProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuStaticMultiGroupProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfMulticastGemPortNo));
        tfOnuStaticMultiGroupProfMulticastGemPortNo.setName(fStringMap.getString("onuStaticMultiGroupProfMulticastGemPortNo"));
        baseInfoPanel.add(tfOnuStaticMultiGroupProfMulticastGemPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfMulticastVLANID));
        tfOnuStaticMultiGroupProfMulticastVLANID.setName(fStringMap.getString("onuStaticMultiGroupProfMulticastVLANID"));
        baseInfoPanel.add(tfOnuStaticMultiGroupProfMulticastVLANID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfSourceIPAddress));
        tfOnuStaticMultiGroupProfSourceIPAddress.setName(fStringMap.getString("onuStaticMultiGroupProfSourceIPAddress"));
        baseInfoPanel.add(tfOnuStaticMultiGroupProfSourceIPAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfMulticastGroupAddressStart));
        tfOnuStaticMultiGroupProfMulticastGroupAddressStart.setName(fStringMap.getString("onuStaticMultiGroupProfMulticastGroupAddressStart"));
        baseInfoPanel.add(tfOnuStaticMultiGroupProfMulticastGroupAddressStart);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfMulticastGroupAddressStop));
        tfOnuStaticMultiGroupProfMulticastGroupAddressStop.setName(fStringMap.getString("onuStaticMultiGroupProfMulticastGroupAddressStop"));
        baseInfoPanel.add(tfOnuStaticMultiGroupProfMulticastGroupAddressStop);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuStaticMultiGroupProfImputedGroupBandwidth));
        tfOnuStaticMultiGroupProfImputedGroupBandwidth.setName(fStringMap.getString("onuStaticMultiGroupProfImputedGroupBandwidth"));
        baseInfoPanel.add(tfOnuStaticMultiGroupProfImputedGroupBandwidth);
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
        tfOnuStaticMultiGroupProfIndex.setValueScope(0,2, 256);
        tfOnuStaticMultiGroupProfIndex.setValueScope(1,1, 31);
        tfOnuStaticMultiGroupProfMulticastVLANID.setValueScope(1, 4095);
        tfOnuStaticMultiGroupProfMulticastVLANID.setValue(4095);
        tfOnuStaticMultiGroupProfMulticastGemPortNo.setValueScope(0, 3999);
        tfOnuStaticMultiGroupProfImputedGroupBandwidth.setValueScope(0, 31);
        tfOnuStaticMultiGroupProfImputedGroupBandwidth.setValue(0);
    }

    public boolean validateFrom() {
        long gemPortNo = tfOnuStaticMultiGroupProfMulticastGemPortNo.getValue();
        if (gemPortNo != 0 && (gemPortNo > 3999 || gemPortNo < 3800)) {
            String err = fStringMap.getString("Err_GemPortNo_Value");
            MessageDialog.showErrorMessageDialog(fApplication, err);
            return false;
        }
        return true;
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuStaticMultiGroupProfIndex.setEnabled(true);
            tfOnuStaticMultiGroupProfIndex.setTable(fTable);
            tfOnuStaticMultiGroupProfIndex.refresh();
            return;
        } else {
            tfOnuStaticMultiGroupProfIndex.setEnabled(true);
        }
        OnuStaticMultiGroupProfTable mbean = (OnuStaticMultiGroupProfTable) getModel();

        tfOnuStaticMultiGroupProfIndex.setValue(0,mbean.getOnuStaticMultiGroupProfIndex1());
        tfOnuStaticMultiGroupProfIndex.setValue(1,mbean.getOnuStaticMultiGroupProfIndex2());
        tfOnuStaticMultiGroupProfileName.setValue(mbean.getOnuStaticMultiGroupProfileName());
        tfOnuStaticMultiGroupProfMulticastGroupAddressStart.setValue(mbean.getOnuStaticMultiGroupProfMulticastGroupAddressStart());
        tfOnuStaticMultiGroupProfMulticastGroupAddressStop.setValue(mbean.getOnuStaticMultiGroupProfMulticastGroupAddressStop());
        tfOnuStaticMultiGroupProfMulticastGemPortNo.setValue(mbean.getOnuStaticMultiGroupProfMulticastGemPortNo());
        tfOnuStaticMultiGroupProfMulticastVLANID.setValue(mbean.getOnuStaticMultiGroupProfMulticastVLANID());
        tfOnuStaticMultiGroupProfSourceIPAddress.setValue(mbean.getOnuStaticMultiGroupProfSourceIPAddress());
        tfOnuStaticMultiGroupProfImputedGroupBandwidth.setValue(mbean.getOnuStaticMultiGroupProfImputedGroupBandwidth());
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuStaticMultiGroupProfTable(fApplication.getSnmpProxy()));

        OnuStaticMultiGroupProfTable mbean = (OnuStaticMultiGroupProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuStaticMultiGroupProfIndex1(tfOnuStaticMultiGroupProfIndex.getValue(0));
            mbean.setOnuStaticMultiGroupProfIndex2(tfOnuStaticMultiGroupProfIndex.getValue(1));
        }
        mbean.setOnuStaticMultiGroupProfileName(tfOnuStaticMultiGroupProfileName.getValue());
        mbean.setOnuStaticMultiGroupProfMulticastGroupAddressStart(new String(tfOnuStaticMultiGroupProfMulticastGroupAddressStart.getIPString()));
        mbean.setOnuStaticMultiGroupProfMulticastGroupAddressStop(new String(tfOnuStaticMultiGroupProfMulticastGroupAddressStop.getIPString()));
        mbean.setOnuStaticMultiGroupProfMulticastGemPortNo(tfOnuStaticMultiGroupProfMulticastGemPortNo.getValue());
        mbean.setOnuStaticMultiGroupProfMulticastVLANID(tfOnuStaticMultiGroupProfMulticastVLANID.getValue());
        mbean.setOnuStaticMultiGroupProfSourceIPAddress(tfOnuStaticMultiGroupProfSourceIPAddress.getIPString());
        mbean.setOnuStaticMultiGroupProfImputedGroupBandwidth(tfOnuStaticMultiGroupProfImputedGroupBandwidth.getValue());

    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuStaticMultiGroupProfIndex.increaseIndexValue();
    }
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
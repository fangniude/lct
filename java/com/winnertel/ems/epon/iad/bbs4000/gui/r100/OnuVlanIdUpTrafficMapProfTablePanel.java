/**
 * Title          :   OnuVlanIdUpTrafficMapProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanIdUpTrafficMapProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
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

public class OnuVlanIdUpTrafficMapProfTablePanel extends UPanel {

//    private LongIndexGenField tfOnuVlanIdUpTrafficMapProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOnuVlanIdUpTrafficMapProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField tfOnuVlanIdUpTrafficMapProfIndex = new IndexAutoGenField(fApplication,2);
    private StringTextField tfOnuVlanIdUpTrafficMapProfileName = new StringTextField();

    private LongTextField tfOnuVlanIdUpTrafficMapProfVlanIDStart = new LongTextField();

    private LongTextField tfOnuVlanIdUpTrafficMapProfVlanIDStop = new LongTextField();

    private JComboBox tfOnuVlanIdUpTrafficMapProfVirtualPortNo = new JComboBox();

    private final String onuVlanIdUpTrafficMapProfIndex1 =
            fStringMap.getString("onuVlanIdUpTrafficMapProfIndex1") + " : ";

    private final String onuVlanIdUpTrafficMapProfIndex2 =
            fStringMap.getString("onuVlanIdUpTrafficMapProfIndex2") + " : ";
    private final String onuVlanIdUpTrafficMapProfileName =
            fStringMap.getString("onuVlanIdUpTrafficMapProfileName") + " : ";
    private final String onuVlanIdUpTrafficMapProfVlanIDStart =
            fStringMap.getString("onuVlanIdUpTrafficMapProfVlanIDStart") + " : ";
    private final String onuVlanIdUpTrafficMapProfVlanIDStop =
            fStringMap.getString("onuVlanIdUpTrafficMapProfVlanIDStop") + " : ";
    private final String onuVlanIdUpTrafficMapProfVirtualPortNo =
            fStringMap.getString("onuVlanIdUpTrafficMapProfVirtualPortNo") + " : ";

    public OnuVlanIdUpTrafficMapProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuVlanIdUpTrafficMapProfIndex1));
        baseInfoPanel.add(tfOnuVlanIdUpTrafficMapProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdUpTrafficMapProfIndex2));
        baseInfoPanel.add(tfOnuVlanIdUpTrafficMapProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdUpTrafficMapProfileName));
        tfOnuVlanIdUpTrafficMapProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuVlanIdUpTrafficMapProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdUpTrafficMapProfVlanIDStart));
        tfOnuVlanIdUpTrafficMapProfVlanIDStart.setName(fStringMap.getString("onuVlanIdUpTrafficMapProfVlanIDStart"));
        baseInfoPanel.add(tfOnuVlanIdUpTrafficMapProfVlanIDStart);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdUpTrafficMapProfVlanIDStop));
        tfOnuVlanIdUpTrafficMapProfVlanIDStop.setName(fStringMap.getString("onuVlanIdUpTrafficMapProfVlanIDStop"));
        baseInfoPanel.add(tfOnuVlanIdUpTrafficMapProfVlanIDStop);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanIdUpTrafficMapProfVirtualPortNo));
        tfOnuVlanIdUpTrafficMapProfVirtualPortNo.setName(fStringMap.getString("onuVlanIdUpTrafficMapProfVirtualPortNo"));
        baseInfoPanel.add(tfOnuVlanIdUpTrafficMapProfVirtualPortNo);
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
        	tfOnuVlanIdUpTrafficMapProfVirtualPortNo.addItem(i);
        }

    }

    protected void initForm() {
        tfOnuVlanIdUpTrafficMapProfIndex.setValueScope(0,2, 128);
        tfOnuVlanIdUpTrafficMapProfIndex.setValueScope(1,1, 127);
        tfOnuVlanIdUpTrafficMapProfVlanIDStart.setValueScope(1, 4095);

        tfOnuVlanIdUpTrafficMapProfVlanIDStop.setValueScope(1, 4095);

    }


    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuVlanIdUpTrafficMapProfIndex.setEnabled(true);
            tfOnuVlanIdUpTrafficMapProfIndex.setTable(fTable);
            tfOnuVlanIdUpTrafficMapProfIndex.refresh();
            return;
        } else {
            tfOnuVlanIdUpTrafficMapProfIndex.setEnabled(false);

        }
        OnuVlanIdUpTrafficMapProfTable mbean = (OnuVlanIdUpTrafficMapProfTable) getModel();
        tfOnuVlanIdUpTrafficMapProfIndex.setValue(0,mbean.getOnuVlanIdUpTrafficMapProfIndex1());
        tfOnuVlanIdUpTrafficMapProfIndex.setValue(1,mbean.getOnuVlanIdUpTrafficMapProfIndex2());
        tfOnuVlanIdUpTrafficMapProfileName.setValue(mbean.getOnuVlanIdUpTrafficMapProfileName());
        tfOnuVlanIdUpTrafficMapProfVlanIDStart.setValue(mbean.getOnuVlanIdUpTrafficMapProfVlanIDStart().intValue());
        tfOnuVlanIdUpTrafficMapProfVlanIDStop.setValue(mbean.getOnuVlanIdUpTrafficMapProfVlanIDStop().intValue());
        tfOnuVlanIdUpTrafficMapProfVirtualPortNo.setSelectedItem((mbean.getOnuVlanIdUpTrafficMapProfVirtualPortNo().intValue()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuVlanIdUpTrafficMapProfTable(fApplication.getSnmpProxy()));

        OnuVlanIdUpTrafficMapProfTable mbean = (OnuVlanIdUpTrafficMapProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuVlanIdUpTrafficMapProfIndex1(tfOnuVlanIdUpTrafficMapProfIndex.getValue(0));
            mbean.setOnuVlanIdUpTrafficMapProfIndex2(tfOnuVlanIdUpTrafficMapProfIndex.getValue(1));

        }
        mbean.setOnuVlanIdUpTrafficMapProfileName(new String(tfOnuVlanIdUpTrafficMapProfileName.getValue()));
        mbean.setOnuVlanIdUpTrafficMapProfVlanIDStart(new Long(tfOnuVlanIdUpTrafficMapProfVlanIDStart.getValue()));
        mbean.setOnuVlanIdUpTrafficMapProfVlanIDStop(new Long(tfOnuVlanIdUpTrafficMapProfVlanIDStop.getValue()));
        mbean.setOnuVlanIdUpTrafficMapProfVirtualPortNo(Integer.parseInt((tfOnuVlanIdUpTrafficMapProfVirtualPortNo.getSelectedItem().toString())));
    }

    public boolean validateFrom() {
        long start = tfOnuVlanIdUpTrafficMapProfVlanIDStart.getValue();
        long end = tfOnuVlanIdUpTrafficMapProfVlanIDStop.getValue();
        if (end - start > 12) {
            String msg = fStringMap.getString("error_vlanId_start_end");
            JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
            return false;
        }
        return true;
    }

    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuVlanIdUpTrafficMapProfIndex.increaseIndexValue();
    }
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
/**
 * Modified by Zhou Chao, 2008/9/30
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUPUTMProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuUPUTMProfTablePanel extends UPanel {

//    private LongIndexGenField tfOnuUsrPortUpTrafficMapProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOnuUsrPortUpTrafficMapProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField tfOnuUsrPortUpTrafficMapProfIndex = new IndexAutoGenField(fApplication,2);
    private StringTextField tfOnuUsrPortUpTrafficMapProfileName = new StringTextField();

    private int[] onuUsrPortUpTrafficMapProfPhysicalPortTypeVList = new int[]{1, 2, 3, 4, 5,};
    private String[] onuUsrPortUpTrafficMapProfPhysicalPortTypeTList = new String[]{
            fStringMap.getString("ethernet-uni"),
            fStringMap.getString("pots-uni"),
            fStringMap.getString("t1"),
            fStringMap.getString("e1"),
            fStringMap.getString("hpna"),};
    private JComboBox tfOnuUsrPortUpTrafficMapProfPhysicalPortType = new JComboBox(onuUsrPortUpTrafficMapProfPhysicalPortTypeTList);

    private JComboBox tfOnuUsrPortUpTrafficMapProfPhysicalPortNo = new JComboBox();
    private JComboBox tfOnuUsrPortUpTrafficMapProfVirtualPortNo = new JComboBox();

    private final String onuUsrPortUpTrafficMapProfIndex1 = fStringMap.getString("onuUsrPortUpTrafficMapProfIndex1") + ": ";
    private final String onuUsrPortUpTrafficMapProfIndex2 = fStringMap.getString("onuUsrPortUpTrafficMapProfIndex2") + ": ";
    private final String onuUsrPortUpTrafficMapProfileName = fStringMap.getString("onuUsrPortUpTrafficMapProfileName") + ": ";
    private final String onuUsrPortUpTrafficMapProfPhysicalPortType = fStringMap.getString("onuUsrPortUpTrafficMapProfPhysicalPortType") + ": ";
    private final String onuUsrPortUpTrafficMapProfPhysicalPortNo = fStringMap.getString("onuUsrPortUpTrafficMapProfPhysicalPortNo") + ": ";
    private final String onuUsrPortUpTrafficMapProfVirtualPortNo = fStringMap.getString("onuUsrPortUpTrafficMapProfVirtualPortNo") + ": ";

    public OnuUPUTMProfTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuUsrPortUpTrafficMapProfIndex1));
        baseInfoPanel.add(tfOnuUsrPortUpTrafficMapProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortUpTrafficMapProfIndex2));
        baseInfoPanel.add(tfOnuUsrPortUpTrafficMapProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortUpTrafficMapProfileName));
        tfOnuUsrPortUpTrafficMapProfileName.setName(fStringMap.getString("onuUsrPortUpTrafficMapProfileName"));
        tfOnuUsrPortUpTrafficMapProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuUsrPortUpTrafficMapProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortUpTrafficMapProfPhysicalPortType));
        tfOnuUsrPortUpTrafficMapProfPhysicalPortType.setName(fStringMap.getString("onuUsrPortUpTrafficMapProfPhysicalPortType"));
        baseInfoPanel.add(tfOnuUsrPortUpTrafficMapProfPhysicalPortType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortUpTrafficMapProfPhysicalPortNo));
        tfOnuUsrPortUpTrafficMapProfPhysicalPortNo.setName(fStringMap.getString("onuUsrPortUpTrafficMapProfPhysicalPortNo"));
        baseInfoPanel.add(tfOnuUsrPortUpTrafficMapProfPhysicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortUpTrafficMapProfVirtualPortNo));
        tfOnuUsrPortUpTrafficMapProfVirtualPortNo.setName(fStringMap.getString("onuUsrPortUpTrafficMapProfVirtualPortNo"));
        baseInfoPanel.add(tfOnuUsrPortUpTrafficMapProfVirtualPortNo);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        
        for(int i=1;i<=128;i++){
        	tfOnuUsrPortUpTrafficMapProfPhysicalPortNo.addItem(i);
        	if(i<=40)
        		tfOnuUsrPortUpTrafficMapProfVirtualPortNo.addItem(i);	
        }
    }

    protected void initForm() {
        tfOnuUsrPortUpTrafficMapProfIndex.setValueScope(0,2, 128);
        tfOnuUsrPortUpTrafficMapProfIndex.setValueScope(1,1, 127);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuUsrPortUpTrafficMapProfIndex.setEnabled(true);
            tfOnuUsrPortUpTrafficMapProfIndex.setTable(fTable);
            tfOnuUsrPortUpTrafficMapProfIndex.refresh();
            return;
        } else {
            tfOnuUsrPortUpTrafficMapProfIndex.setEnabled(false);
        }
        OnuUPUTMProfTable mbean = (OnuUPUTMProfTable) getModel();

        String sValue = "";
        int iValue = 0;
        tfOnuUsrPortUpTrafficMapProfIndex.setValue(0,mbean.getOnuUsrPortUpTrafficMapProfIndex1());
        tfOnuUsrPortUpTrafficMapProfIndex.setValue(1,mbean.getOnuUsrPortUpTrafficMapProfIndex2());

        try {
            sValue = mbean.getOnuUsrPortUpTrafficMapProfileName();
        } catch (Exception e) {
            sValue = "";
        }
        tfOnuUsrPortUpTrafficMapProfileName.setValue(sValue);

        try {
            iValue = mbean.getOnuUsrPortUpTrafficMapProfPhysicalPortType();
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuUsrPortUpTrafficMapProfPhysicalPortType.setSelectedIndex(getIndexFromValue(onuUsrPortUpTrafficMapProfPhysicalPortTypeVList, iValue));

        try {
            iValue = mbean.getOnuUsrPortUpTrafficMapProfPhysicalPortNo();
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuUsrPortUpTrafficMapProfPhysicalPortNo.setSelectedItem(iValue);

        try {
            iValue = mbean.getOnuUsrPortUpTrafficMapProfVirtualPortNo();
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuUsrPortUpTrafficMapProfVirtualPortNo.setSelectedItem(iValue);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuUPUTMProfTable(fApplication.getSnmpProxy()));

        OnuUPUTMProfTable mbean = (OnuUPUTMProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuUsrPortUpTrafficMapProfIndex1(tfOnuUsrPortUpTrafficMapProfIndex.getValue(0));
            mbean.setOnuUsrPortUpTrafficMapProfIndex2(tfOnuUsrPortUpTrafficMapProfIndex.getValue(1));
        }

        mbean.setOnuUsrPortUpTrafficMapProfileName(tfOnuUsrPortUpTrafficMapProfileName.getValue());
        mbean.setOnuUsrPortUpTrafficMapProfPhysicalPortType(onuUsrPortUpTrafficMapProfPhysicalPortTypeVList[tfOnuUsrPortUpTrafficMapProfPhysicalPortType.getSelectedIndex()]);
        mbean.setOnuUsrPortUpTrafficMapProfPhysicalPortNo(Integer.parseInt(tfOnuUsrPortUpTrafficMapProfPhysicalPortNo.getSelectedItem().toString()));
        mbean.setOnuUsrPortUpTrafficMapProfVirtualPortNo(new Integer(tfOnuUsrPortUpTrafficMapProfVirtualPortNo.getSelectedItem().toString()));
    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuUsrPortUpTrafficMapProfIndex.increaseIndexValue();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}
package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontVPortBindProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuTcontVPortBindProfTablePanel extends UPanel {

    //private LongIndexGenField tfTcontVirtualPortBindingProfileIndex = new LongIndexGenField(fApplication);

    //private LongIndexGenField tfTcontVirtualPortBindingProfileVirtualPortNo = new LongIndexGenField(fApplication);

    private IndexAutoGenField tfTcontVirtualPortBindingProfileIndex = new IndexAutoGenField(fApplication,2);

    private StringTextField tfOnuTcontVPortBindProfileName = new StringTextField();

    private ProfileChooser tfVirtualPortServicePr = new ProfileChooser(fApplication);

    private JComboBox tfTcontIndex = new JComboBox();

    private ProfileChooser tfTcontServiceProfileIndex = new ProfileChooser(fApplication);

    private final String tcontVirtualPortBindingProfileIndex = fStringMap.getString("tcontVirtualPortBindingProfileIndex") + ": ";
    private final String tcontVirtualPortBindingProfileVirtualPortNo = fStringMap.getString("tcontVirtualPortBindingProfileVirtualPortNo") + ": ";
    private final String onuTcontVPortBindProfileName = fStringMap.getString("onuTcontVPortBindProfileName") + ": ";
    private final String virtualPortServicePr = fStringMap.getString("virtualPortServicePr") + ": ";
    private final String tcontIndex = fStringMap.getString("tcontIndex") + ": ";
    private final String tcontServiceProfileIndex = fStringMap.getString("tcontServiceProfileIndex") + ": ";

    public OnuTcontVPortBindProfTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(tcontVirtualPortBindingProfileIndex));
        baseInfoPanel.add(tfTcontVirtualPortBindingProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(tcontVirtualPortBindingProfileVirtualPortNo));
        baseInfoPanel.add(tfTcontVirtualPortBindingProfileIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuTcontVPortBindProfileName));
        tfOnuTcontVPortBindProfileName.setName(fStringMap.getString("onuTcontVPortBindProfileName"));
        tfOnuTcontVPortBindProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuTcontVPortBindProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(virtualPortServicePr));
        tfVirtualPortServicePr.setName(fStringMap.getString("virtualPortServicePr"));
        tfVirtualPortServicePr.setProfile("OnuVPorSvcProfTable_Panel");
        baseInfoPanel.add(tfVirtualPortServicePr);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(tcontIndex));
        tfTcontIndex.setName(fStringMap.getString("tcontIndex"));
        baseInfoPanel.add(tfTcontIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(tcontServiceProfileIndex));
        tfTcontServiceProfileIndex.setName(fStringMap.getString("tcontServiceProfileIndex"));
        tfTcontServiceProfileIndex.setProfile("OnuTcontSvcProfTable_Panel");
        baseInfoPanel.add(tfTcontServiceProfileIndex);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(int i=1;i<=6;i++){
        	tfTcontIndex.addItem(i);
        }
    }

    protected void initForm() {
        tfTcontVirtualPortBindingProfileIndex.setValueScope(0,2, 128);
        tfTcontVirtualPortBindingProfileIndex.setValueScope(1,1,40);
        //tfTcontIndex.setValueScope(1, 6);
    }

    public void refresh() {
        tfVirtualPortServicePr.refresh();
        tfTcontServiceProfileIndex.refresh();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfTcontVirtualPortBindingProfileIndex.setTable(fTable);
            tfTcontVirtualPortBindingProfileIndex.setEnabled(true);
            tfTcontVirtualPortBindingProfileIndex.refresh();
            tfVirtualPortServicePr.setSelectedProfileIndex(1);
            tfTcontServiceProfileIndex.setSelectedProfileIndex(1);
            return;
        } else {
            tfTcontVirtualPortBindingProfileIndex.setEnabled(false);
        }

        OnuTcontVPortBindProfTable mbean = (OnuTcontVPortBindProfTable) getModel();
        if (mbean == null)
            return;

        String sValue = "";
        int iValue = 0;

        tfTcontVirtualPortBindingProfileIndex.setValue(0,mbean.getTcontVirtualPortBindingProfileIndex());

        tfTcontVirtualPortBindingProfileIndex.setValue(1,mbean.getTcontVirtualPortBindingProfileVirtualPortNo());

        try {
            sValue = mbean.getOnuTcontVPortBindProfileName();
        } catch (Exception e) {
            sValue = "";
        }
        tfOnuTcontVPortBindProfileName.setValue(sValue);

        try {
            iValue = mbean.getVirtualPortServicePr().intValue();
        } catch (Exception e) {
            iValue = 0;
        }
        tfVirtualPortServicePr.setSelectedProfileIndex(iValue);

        try {
            iValue = mbean.getTcontIndex().intValue();
        } catch (Exception e) {
            iValue = 0;
        }
        tfTcontIndex.setSelectedItem(iValue);

        try {
            iValue = mbean.getTcontServiceProfileIndex().intValue();
        } catch (Exception e) {
            iValue = 0;
        }
        tfTcontServiceProfileIndex.setSelectedProfileIndex(iValue);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuTcontVPortBindProfTable(fApplication.getSnmpProxy()));

        OnuTcontVPortBindProfTable mbean = (OnuTcontVPortBindProfTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setTcontVirtualPortBindingProfileIndex(tfTcontVirtualPortBindingProfileIndex.getValue(0));
            mbean.setTcontVirtualPortBindingProfileVirtualPortNo((int)tfTcontVirtualPortBindingProfileIndex.getValue(1));
        }

        mbean.setOnuTcontVPortBindProfileName(tfOnuTcontVPortBindProfileName.getValue());

        mbean.setVirtualPortServicePr(tfVirtualPortServicePr.getSelectedProfileIndex() >= 0 ? tfVirtualPortServicePr.getSelectedProfileIndex() : 1);

        mbean.setTcontIndex(Long.parseLong(tfTcontIndex.getSelectedItem().toString()));

        mbean.setTcontServiceProfileIndex(tfTcontServiceProfileIndex.getSelectedProfileIndex() >= 0 ? tfTcontServiceProfileIndex.getSelectedProfileIndex() : 1);
    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfTcontVirtualPortBindingProfileIndex.increaseIndexValue();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }
    
}
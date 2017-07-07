package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuMacFilterProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class GponOnuMacFilterProfTablePanel extends UPanel {


//    private LongIndexGenField tfOnuMacFilterProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOnuMacFilterProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField tfOnuMacFilterProfIndex = new IndexAutoGenField(fApplication,2);
    private StringTextField tfOnuMacFilterProfileName = new StringTextField();
    private MacAddressField tfOnuMacFilterProfMacAddress = new MacAddressField();
    private int[] onuMacFilterProfFilterForwardVList = new int[]{1, 2};
    private String[] onuMacFilterProfFilterForwardTList = new String[]{fStringMap.getString("forward"), fStringMap.getString("filter")};
    private JComboBox tfOnuMacFilterProfFilterForward = new JComboBox(onuMacFilterProfFilterForwardTList);

    private final String onuMacFilterProfIndex1 = fStringMap.getString("onuMacFilterProfIndex1") + ":";
    private final String onuMacFilterProfIndex2 = fStringMap.getString("onuMacFilterProfIndex2") + ":";
    private final String onuMacFilterProfileName = fStringMap.getString("onuMacFilterProfileName") + ":";
    private final String onuMacFilterProfMacAddress = fStringMap.getString("onuMacFilterProfMacAddress") + ":";
    private final String onuMacFilterProfFilterForward = fStringMap.getString("onuMacFilterProfFilterForward") + ":";

    public GponOnuMacFilterProfTablePanel(IApplication app) {
        super(app);
        init();
    }


    @Override
    protected void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5,
                5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuMacFilterProfIndex1));
        baseInfoPanel.add(tfOnuMacFilterProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterProfIndex2));
        baseInfoPanel.add(tfOnuMacFilterProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterProfileName));
        tfOnuMacFilterProfileName.setName(fStringMap.getString("onuMacFilterProfileName"));
        tfOnuMacFilterProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuMacFilterProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterProfMacAddress));
        tfOnuMacFilterProfMacAddress.setName(fStringMap.getString("onuMacFilterProfMacAddress"));
        baseInfoPanel.add(tfOnuMacFilterProfMacAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterProfFilterForward));
        tfOnuMacFilterProfFilterForward.setName(fStringMap.getString("onuMacFilterProfFilterForward"));
        baseInfoPanel.add(tfOnuMacFilterProfFilterForward);
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
        tfOnuMacFilterProfIndex.setValueScope(0,2, 1024);
        tfOnuMacFilterProfIndex.setValueScope(1,1, 64);
    }

    @Override
    public void refresh() {

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuMacFilterProfIndex.setEnabled(true);
            tfOnuMacFilterProfIndex.setTable(fTable);
            tfOnuMacFilterProfIndex.refresh();
            return;
        } else {
            tfOnuMacFilterProfIndex.setEnabled(false);
        }
        GponOnuMacFilterProfTable mbean = (GponOnuMacFilterProfTable) getModel();
        tfOnuMacFilterProfIndex.setValue(0,mbean.getOnuMacFilterProfIndex1());
        tfOnuMacFilterProfIndex.setValue(1,mbean.getOnuMacFilterProfIndex2());
        tfOnuMacFilterProfileName.setValue(mbean.getOnuMacFilterProfileName());
        tfOnuMacFilterProfMacAddress.setValue(mbean.getOnuMacFilterProfMacAddress());
        tfOnuMacFilterProfFilterForward.setSelectedIndex(getIndexFromValue(onuMacFilterProfFilterForwardVList, mbean.getOnuMacFilterProfFilterForward()));

    }

    public boolean validateFrom(){
        if(tfOnuMacFilterProfMacAddress.getMacString().equals("00:00:00:00:00:00")){
            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Invalid_MAC_Address"));
            return false;
        }
        return true;
    }
    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuMacFilterProfTable(fApplication.getSnmpProxy()));

        GponOnuMacFilterProfTable mbean = (GponOnuMacFilterProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setOnuMacFilterProfIndex1(tfOnuMacFilterProfIndex.getValue(0));
            mbean.setOnuMacFilterProfIndex2(tfOnuMacFilterProfIndex.getValue(1));
        }
        mbean.setOnuMacFilterProfileName(tfOnuMacFilterProfileName.getValue());
        mbean.setOnuMacFilterProfMacAddress(tfOnuMacFilterProfMacAddress.getValue());
        mbean.setOnuMacFilterProfFilterForward(onuMacFilterProfFilterForwardVList[tfOnuMacFilterProfFilterForward.getSelectedIndex()]);

    }

    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuMacFilterProfIndex.increaseIndexValue();
    }
    
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }
}

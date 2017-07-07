package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PortVlanTranslationTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The PortVlanTranslationTablePanel class.
 * Created by DVM Creator
 */
public class PortVlanTranslationTablePanel extends UPanel {
    private LongTextField tfPortVidIndex = new LongTextField();

    private IntegerTextField tfTranslationNewVid = new IntegerTextField();

    EponDeviceIndexPanel deviceIndex=null;

    private final String portVidIndex = fStringMap.getString("portVidIndex") + " : ";
    private final String translationNewVid = fStringMap.getString("translationNewVid") + " : ";


    public PortVlanTranslationTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel lb1=new JLabel(portVidIndex);
        lb1.setPreferredSize(new Dimension(120,20));
        baseInfoPanel.add(lb1);
        baseInfoPanel.add(tfPortVidIndex);
        baseInfoPanel.add(new HSpacer(30));


        baseInfoPanel.add(new JLabel(translationNewVid));
        tfTranslationNewVid.setName(fStringMap.getString("translationNewVid"));
        baseInfoPanel.add(tfTranslationNewVid);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);

        deviceIndex=new EponDeviceIndexPanel(fStringMap,fApplication);
        allPanel.add(deviceIndex);

        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {

        try{
            deviceIndex.initData();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            deviceIndex.setEnabled(true);
            return;
        } else {
            deviceIndex.setEnabled(false);
        }

        PortVlanTranslationTable mbean = (PortVlanTranslationTable) getModel();

        tfPortVidIndex.setEnabled(false);
        tfPortVidIndex.setText(mbean.getPortVidIndex().toString());
        tfTranslationNewVid.setValue(mbean.getTranslationNewVid().intValue());
    }

    public boolean validateFrom() {

        if (SnmpAction.IType.ADD.equals(fCommand)){
            if (!deviceIndex.validateFrom()){
                return false;
            }
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new PortVlanTranslationTable(fApplication.getSnmpProxy()));

        PortVlanTranslationTable mbean = (PortVlanTranslationTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setPvtDeviceIndex(deviceIndex.getEponDeviceIndex());
            mbean.setPvtCardIndex(deviceIndex.getOnuCardId());
            mbean.setPvtPortIndex(deviceIndex.getOnuPortId());
            mbean.setPortVidIndex(tfPortVidIndex.getValue());
        }


        mbean.setTranslationNewVid(new Long(tfTranslationNewVid.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }
}
package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUServiceTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCNUServiceTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCCNUServiceTablePanel extends UPanel {

    private IntegerTextField tfModEoCCNUServiceIndex = new IntegerTextField();

    private StringTextField tfModEoCCNUServiceName = new StringTextField();

    private IntegerTextField tfModEoCCNUServiceMatchingValue = new IntegerTextField();

    private IntegerTextField tfModEoCCNUServiceQOSPrio = new IntegerTextField();

    private IntegerTextField tfModEoCCNUServiceDBADownstreamPIR = new IntegerTextField();

    private IntegerTextField tfModEoCCNUServiceDBAUpstreamPIR = new IntegerTextField();

    private IntegerTextField tfModEoCCNUServiceDBADownstreamCIR = new IntegerTextField();

    private IntegerTextField tfModEoCCNUServiceDBAUpstreamCIR = new IntegerTextField();

    private IntegerTextField tfModEoCCNUServiceMaxLatency = new IntegerTextField();

    /*
        private int[] modEoCCNUServiceRowStatusVList =new int[]{
1,2,5,4,3,6,};
private String[] modEoCCNUServiceRowStatusTList =new String[]{
        fStringMap.getString("active"),
        fStringMap.getString("notInService"),
        fStringMap.getString("createAndWait"),
        fStringMap.getString("createAndGo"),
        fStringMap.getString("notReady"),
        fStringMap.getString("destroy"),
};
private JComboBox tfModEoCCNUServiceRowStatus = new JComboBox( modEoCCNUServiceRowStatusTList);
        */

    private final String modEoCCNUServiceIndex = fStringMap.getString("modEoCCNUServiceIndex") + " : ";
    private final String modEoCCNUServiceName = fStringMap.getString("modEoCCNUServiceName") + " : ";
    private final String modEoCCNUServiceMatchingValue = fStringMap.getString("modEoCCNUServiceMatchingValue") + " : ";
    private final String modEoCCNUServiceQOSPrio = fStringMap.getString("modEoCCNUServiceQOSPrio") + " : ";
    private final String modEoCCNUServiceDBADownstreamPIR = fStringMap.getString("modEoCCNUServiceDBADownstreamPIR") + " : ";
    private final String modEoCCNUServiceDBAUpstreamPIR = fStringMap.getString("modEoCCNUServiceDBAUpstreamPIR") + " : ";
    private final String modEoCCNUServiceDBADownstreamCIR = fStringMap.getString("modEoCCNUServiceDBADownstreamCIR") + " : ";
    private final String modEoCCNUServiceDBAUpstreamCIR = fStringMap.getString("modEoCCNUServiceDBAUpstreamCIR") + " : ";
    private final String modEoCCNUServiceMaxLatency = fStringMap.getString("modEoCCNUServiceMaxLatency") + " : ";


    public ModEoCCNUServiceTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCNUServiceIndex));
        baseInfoPanel.add(tfModEoCCNUServiceIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceName));
        tfModEoCCNUServiceName.setName(fStringMap.getString("modEoCCNUServiceName"));
        baseInfoPanel.add(tfModEoCCNUServiceName);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceMatchingValue));
        tfModEoCCNUServiceMatchingValue.setName(fStringMap.getString("modEoCCNUServiceMatchingValue"));
        baseInfoPanel.add(tfModEoCCNUServiceMatchingValue);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceQOSPrio));
        tfModEoCCNUServiceQOSPrio.setName(fStringMap.getString("modEoCCNUServiceQOSPrio"));
        baseInfoPanel.add(tfModEoCCNUServiceQOSPrio);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceDBADownstreamPIR));
        tfModEoCCNUServiceDBADownstreamPIR.setName(fStringMap.getString("modEoCCNUServiceDBADownstreamPIR"));
        baseInfoPanel.add(tfModEoCCNUServiceDBADownstreamPIR);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceDBAUpstreamPIR));
        tfModEoCCNUServiceDBAUpstreamPIR.setName(fStringMap.getString("modEoCCNUServiceDBAUpstreamPIR"));
        baseInfoPanel.add(tfModEoCCNUServiceDBAUpstreamPIR);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceDBADownstreamCIR));
        tfModEoCCNUServiceDBADownstreamCIR.setName(fStringMap.getString("modEoCCNUServiceDBADownstreamCIR"));
        baseInfoPanel.add(tfModEoCCNUServiceDBADownstreamCIR);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceDBAUpstreamCIR));
        tfModEoCCNUServiceDBAUpstreamCIR.setName(fStringMap.getString("modEoCCNUServiceDBAUpstreamCIR"));
        baseInfoPanel.add(tfModEoCCNUServiceDBAUpstreamCIR);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceMaxLatency));
        tfModEoCCNUServiceMaxLatency.setName(fStringMap.getString("modEoCCNUServiceMaxLatency"));
        baseInfoPanel.add(tfModEoCCNUServiceMaxLatency);
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
        tfModEoCCNUServiceIndex.setValueScope(1, 16);
        tfModEoCCNUServiceName.setLenScope(0, 255);


        tfModEoCCNUServiceQOSPrio.setValueScope(0, 7);


    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfModEoCCNUServiceIndex.setEnabled(true);
            return;
        } else {
            tfModEoCCNUServiceIndex.setEnabled(false);
        }
        ModEoCCNUServiceTable mbean = (ModEoCCNUServiceTable) getModel();

        tfModEoCCNUServiceIndex.setText(mbean.getModEoCCNUServiceIndex().toString());
        tfModEoCCNUServiceName.setValue(mbean.getModEoCCNUServiceName());
        tfModEoCCNUServiceMatchingValue.setValue(mbean.getModEoCCNUServiceMatchingValue().intValue());
        tfModEoCCNUServiceQOSPrio.setValue(mbean.getModEoCCNUServiceQOSPrio().intValue());

        //DecimalFormat df2  = new DecimalFormat("##0.000");

        tfModEoCCNUServiceDBADownstreamPIR.setValue((mbean.getModEoCCNUServiceDBADownstreamPIR().intValue() / 1000));
        tfModEoCCNUServiceDBAUpstreamPIR.setValue(mbean.getModEoCCNUServiceDBAUpstreamPIR().intValue() / 1000);
        tfModEoCCNUServiceDBADownstreamCIR.setValue(mbean.getModEoCCNUServiceDBADownstreamCIR().intValue() / 1000);
        tfModEoCCNUServiceDBAUpstreamCIR.setValue(mbean.getModEoCCNUServiceDBAUpstreamCIR().intValue() / 1000);
        tfModEoCCNUServiceMaxLatency.setValue(mbean.getModEoCCNUServiceMaxLatency().intValue());
        //tfModEoCCNUServiceRowStatus.setSelectedIndex(getIndexFromValue(modEoCCNUServiceRowStatusVList,mbean.getModEoCCNUServiceRowStatus().intValue()));

    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new ModEoCCNUServiceTable(fApplication.getSnmpProxy()));

        ModEoCCNUServiceTable mbean = (ModEoCCNUServiceTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            //    mbean.set??(new Integer(??.getValue()));
            mbean.setModEoCCNUServiceIndex(tfModEoCCNUServiceIndex.getValue());
        }


        mbean.setModEoCCNUServiceName(new String(tfModEoCCNUServiceName.getValue()));
        mbean.setModEoCCNUServiceMatchingValue(new Integer(tfModEoCCNUServiceMatchingValue.getValue()));
        mbean.setModEoCCNUServiceQOSPrio(new Integer(tfModEoCCNUServiceQOSPrio.getValue()));
        mbean.setModEoCCNUServiceDBADownstreamPIR(new Integer(tfModEoCCNUServiceDBADownstreamPIR.getValue()) * 1000);
        mbean.setModEoCCNUServiceDBAUpstreamPIR(new Integer(tfModEoCCNUServiceDBAUpstreamPIR.getValue()) * 1000);
        mbean.setModEoCCNUServiceDBADownstreamCIR(new Integer(tfModEoCCNUServiceDBADownstreamCIR.getValue()) * 1000);
        mbean.setModEoCCNUServiceDBAUpstreamCIR(new Integer(tfModEoCCNUServiceDBAUpstreamCIR.getValue()) * 1000);
        mbean.setModEoCCNUServiceMaxLatency(new Integer(tfModEoCCNUServiceMaxLatency.getValue()));
        //     mbean.setModEoCCNUServiceRowStatus(new Integer(modEoCCNUServiceRowStatusVList[tfModEoCCNUServiceRowStatus.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATCardRFGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCBATCardRFGroupPanel class.
 * Created by DVM Creator
 */
public class ModEoCCBATCardRFGroupPanel extends UPanel {

    private IntegerTextField tfModEoCCBATCardRFIndex = new IntegerTextField();

    private IntegerTextField tfModEoCCBATCardRFLinkMaximum = new IntegerTextField();

    private IntegerTextField tfModEoCCBATCardRFOutputLevel = new IntegerTextField();

    private IntegerTextField tfModEoCCBATCardRFDownstreamStartFreq = new IntegerTextField();

    private IntegerTextField tfModEoCCBATCardRFDownstreamStopFreq = new IntegerTextField();

    private IntegerTextField tfModEoCCBATCardRFUpstreamStartFreq = new IntegerTextField();

    private IntegerTextField tfModEoCCBATCardRFUpstreamStopFreq = new IntegerTextField();


    private final String modEoCCBATCardRFIndex = fStringMap.getString("modEoCCBATCardRFIndex") + " : ";
    private final String modEoCCBATCardRFLinkMaximum = fStringMap.getString("modEoCCBATCardRFLinkMaximum") + " : ";
    private final String modEoCCBATCardRFOutputLevel = fStringMap.getString("modEoCCBATCardRFOutputLevel") + " : ";
    private final String modEoCCBATCardRFDownstreamStartFreq = fStringMap.getString("modEoCCBATCardRFDownstreamStartFreq") + " : ";
    private final String modEoCCBATCardRFDownstreamStopFreq = fStringMap.getString("modEoCCBATCardRFDownstreamStopFreq") + " : ";
    private final String modEoCCBATCardRFUpstreamStartFreq = fStringMap.getString("modEoCCBATCardRFUpstreamStartFreq") + " : ";
    private final String modEoCCBATCardRFUpstreamStopFreq = fStringMap.getString("modEoCCBATCardRFUpstreamStopFreq") + " : ";


    public ModEoCCBATCardRFGroupPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATCardRFIndex));
        baseInfoPanel.add(tfModEoCCBATCardRFIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardRFLinkMaximum));
        baseInfoPanel.add(tfModEoCCBATCardRFLinkMaximum);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardRFOutputLevel));
        tfModEoCCBATCardRFOutputLevel.setName(fStringMap.getString("modEoCCBATCardRFOutputLevel"));
        baseInfoPanel.add(tfModEoCCBATCardRFOutputLevel);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardRFDownstreamStartFreq));
        tfModEoCCBATCardRFDownstreamStartFreq.setName(fStringMap.getString("modEoCCBATCardRFDownstreamStartFreq"));
        baseInfoPanel.add(tfModEoCCBATCardRFDownstreamStartFreq);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardRFDownstreamStopFreq));
        tfModEoCCBATCardRFDownstreamStopFreq.setName(fStringMap.getString("modEoCCBATCardRFDownstreamStopFreq"));
        baseInfoPanel.add(tfModEoCCBATCardRFDownstreamStopFreq);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardRFUpstreamStartFreq));
        tfModEoCCBATCardRFUpstreamStartFreq.setName(fStringMap.getString("modEoCCBATCardRFUpstreamStartFreq"));
        baseInfoPanel.add(tfModEoCCBATCardRFUpstreamStartFreq);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardRFUpstreamStopFreq));
        tfModEoCCBATCardRFUpstreamStopFreq.setName(fStringMap.getString("modEoCCBATCardRFUpstreamStopFreq"));
        baseInfoPanel.add(tfModEoCCBATCardRFUpstreamStopFreq);
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
        tfModEoCCBATCardRFIndex.setEditable(false);
        tfModEoCCBATCardRFLinkMaximum.setEditable(false);

    }

    public void refresh() {

        ModEoCCBATCardRFGroup mbean = (ModEoCCBATCardRFGroup) getModel();

        if (mbean == null)
            return;

        tfModEoCCBATCardRFIndex.setText(mbean.getModEoCCBATCardRFIndex().toString());
        tfModEoCCBATCardRFLinkMaximum.setText(mbean.getModEoCCBATCardRFLinkMaximum().toString());
        tfModEoCCBATCardRFOutputLevel.setValue(mbean.getModEoCCBATCardRFOutputLevel().intValue());
        tfModEoCCBATCardRFDownstreamStartFreq.setValue(mbean.getModEoCCBATCardRFDownstreamStartFreq().intValue());
        tfModEoCCBATCardRFDownstreamStopFreq.setValue(mbean.getModEoCCBATCardRFDownstreamStopFreq().intValue());
        tfModEoCCBATCardRFUpstreamStartFreq.setValue(mbean.getModEoCCBATCardRFUpstreamStartFreq().intValue());
        tfModEoCCBATCardRFUpstreamStopFreq.setValue(mbean.getModEoCCBATCardRFUpstreamStopFreq().intValue());

    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new ModEoCCBATCardRFGroup(fApplication.getSnmpProxy()));

        ModEoCCBATCardRFGroup mbean = (ModEoCCBATCardRFGroup) getModel();


        mbean.setModEoCCBATCardRFOutputLevel(new Integer(tfModEoCCBATCardRFOutputLevel.getValue()));
        mbean.setModEoCCBATCardRFDownstreamStartFreq(new Integer(tfModEoCCBATCardRFDownstreamStartFreq.getValue()));
        mbean.setModEoCCBATCardRFDownstreamStopFreq(new Integer(tfModEoCCBATCardRFDownstreamStopFreq.getValue()));
        mbean.setModEoCCBATCardRFUpstreamStartFreq(new Integer(tfModEoCCBATCardRFUpstreamStartFreq.getValue()));
        mbean.setModEoCCBATCardRFUpstreamStopFreq(new Integer(tfModEoCCBATCardRFUpstreamStopFreq.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

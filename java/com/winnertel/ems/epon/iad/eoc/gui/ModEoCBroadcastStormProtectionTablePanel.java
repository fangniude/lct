package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCBroadcastStormProtectionTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ModEoCBroadcastStormProtectionTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCBroadcastStormProtectionTablePanel extends UPanel {

    private JLabel tfModEoCBroadcastStormProtectionCBATCardIndex = new JLabel();

    private JLabel tfModEoCBroadcastStormProtectionCNUIndex = new JLabel();

    private JLabel tfModEoCBroadcastStormProtectionPortIndex = new JLabel();

    private int[] modEoCBroadcastStormProtectionENVList = new int[]{
            0, 1,};
    private String[] modEoCBroadcastStormProtectionENTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };

    private int[] modEoCStormThresholdVList = new int[]{10, 20, 40, 80, 160,
            320, 640,};
    private String[] modEoCStormThresholdTList = new String[]{"10", "20",
            "40", "80", "160", "320", "640",};

    private JComboBox tfModEoCBroadcastStormProtectionEN = new JComboBox(modEoCBroadcastStormProtectionENTList);
    private JComboBox tfModEoCBroadcastStormThreshold = new JComboBox(modEoCStormThresholdTList);

    private int[] modEoCMulticastStormProtectionENVList = new int[]{
            0, 1,};
    private String[] modEoCMulticastStormProtectionENTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfModEoCMulticastStormProtectionEN = new JComboBox(modEoCMulticastStormProtectionENTList);
    private JComboBox tfModEoCMulticastStormThreshold = new JComboBox(modEoCStormThresholdTList);

    private int[] modEoCUnknownUnicastStormProtectionENVList = new int[]{
            0, 1,};
    private String[] modEoCUnknownUnicastStormProtectionENTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfModEoCUnknownUnicastStormProtectionEN = new JComboBox(modEoCUnknownUnicastStormProtectionENTList);
    private JComboBox tfModEoCUnknownUnicastStormThreshold = new JComboBox(modEoCStormThresholdTList);


    private final String modEoCBroadcastStormProtectionCBATCardIndex = fStringMap.getString("modEoCBroadcastStormProtectionCBATCardIndex") + " : ";
    private final String modEoCBroadcastStormProtectionCNUIndex = fStringMap.getString("modEoCBroadcastStormProtectionCNUIndex") + " : ";
    private final String modEoCBroadcastStormProtectionPortIndex = fStringMap.getString("modEoCBroadcastStormProtectionPortIndex") + " : ";
    private final String modEoCBroadcastStormProtectionEN = fStringMap.getString("modEoCBroadcastStormProtectionEN") + " : ";
    private final String modEoCBroadcastStormThreshold = fStringMap.getString("modEoCBroadcastStormThreshold") + " : ";
    private final String modEoCMulticastStormProtectionEN = fStringMap.getString("modEoCMulticastStormProtectionEN") + " : ";
    private final String modEoCMulticastStormThreshold = fStringMap.getString("modEoCMulticastStormThreshold") + " : ";
    private final String modEoCUnknownUnicastStormProtectionEN = fStringMap.getString("modEoCUnknownUnicastStormProtectionEN") + " : ";
    private final String modEoCUnknownUnicastStormThreshold = fStringMap.getString("modEoCUnknownUnicastStormThreshold") + " : ";


    public ModEoCBroadcastStormProtectionTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCBroadcastStormProtectionCBATCardIndex));
        baseInfoPanel.add(tfModEoCBroadcastStormProtectionCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCBroadcastStormProtectionCNUIndex));
        baseInfoPanel.add(tfModEoCBroadcastStormProtectionCNUIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCBroadcastStormProtectionPortIndex));
        baseInfoPanel.add(tfModEoCBroadcastStormProtectionPortIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCBroadcastStormProtectionEN));
        tfModEoCBroadcastStormProtectionEN.setName(fStringMap.getString("modEoCBroadcastStormProtectionEN"));
        baseInfoPanel.add(tfModEoCBroadcastStormProtectionEN);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCBroadcastStormThreshold));
        tfModEoCBroadcastStormThreshold.setName(fStringMap.getString("modEoCBroadcastStormThreshold"));
        baseInfoPanel.add(tfModEoCBroadcastStormThreshold);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCMulticastStormProtectionEN));
        tfModEoCMulticastStormProtectionEN.setName(fStringMap.getString("modEoCMulticastStormProtectionEN"));
        baseInfoPanel.add(tfModEoCMulticastStormProtectionEN);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCMulticastStormThreshold));
        tfModEoCMulticastStormThreshold.setName(fStringMap.getString("modEoCMulticastStormThreshold"));
        baseInfoPanel.add(tfModEoCMulticastStormThreshold);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCUnknownUnicastStormProtectionEN));
        tfModEoCUnknownUnicastStormProtectionEN.setName(fStringMap.getString("modEoCUnknownUnicastStormProtectionEN"));
        baseInfoPanel.add(tfModEoCUnknownUnicastStormProtectionEN);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCUnknownUnicastStormThreshold));
        tfModEoCUnknownUnicastStormThreshold.setName(fStringMap.getString("modEoCUnknownUnicastStormThreshold"));
        baseInfoPanel.add(tfModEoCUnknownUnicastStormThreshold);
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

        tfModEoCMulticastStormThreshold.setEnabled(false);
        tfModEoCUnknownUnicastStormThreshold.setEnabled(false);

        tfModEoCBroadcastStormThreshold.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                tfModEoCMulticastStormThreshold
                        .setSelectedItem(tfModEoCBroadcastStormThreshold
                                .getSelectedItem());

                tfModEoCUnknownUnicastStormThreshold
                        .setSelectedItem(tfModEoCBroadcastStormThreshold
                                .getSelectedItem());
            }
        });

    }

    public void refresh() {

        ModEoCBroadcastStormProtectionTable mbean = (ModEoCBroadcastStormProtectionTable) getModel();

        if (mbean == null)
            return;

        tfModEoCBroadcastStormProtectionCBATCardIndex.setText(mbean.getModEoCBroadcastStormProtectionCBATCardIndex().toString());
        tfModEoCBroadcastStormProtectionCNUIndex.setText(mbean.getModEoCBroadcastStormProtectionCNUIndex().toString());
        tfModEoCBroadcastStormProtectionPortIndex.setText(mbean.getModEoCBroadcastStormProtectionPortIndex().toString());
        tfModEoCBroadcastStormProtectionEN.setSelectedIndex(getIndexFromValue(modEoCBroadcastStormProtectionENVList, mbean.getModEoCBroadcastStormProtectionEN().intValue()));
        tfModEoCBroadcastStormThreshold.setSelectedIndex(getIndexFromValue(modEoCStormThresholdVList, mbean.getModEoCBroadcastStormThreshold()));
        tfModEoCMulticastStormProtectionEN.setSelectedIndex(getIndexFromValue(modEoCMulticastStormProtectionENVList, mbean.getModEoCMulticastStormProtectionEN().intValue()));
        tfModEoCMulticastStormThreshold.setSelectedIndex(getIndexFromValue(modEoCStormThresholdVList, mbean.getModEoCBroadcastStormThreshold()));
        tfModEoCUnknownUnicastStormProtectionEN.setSelectedIndex(getIndexFromValue(modEoCUnknownUnicastStormProtectionENVList, mbean.getModEoCUnknownUnicastStormProtectionEN().intValue()));
        tfModEoCUnknownUnicastStormThreshold.setSelectedIndex(getIndexFromValue(modEoCStormThresholdVList, mbean.getModEoCBroadcastStormThreshold()));

    }

    public void updateModel() {

        ModEoCBroadcastStormProtectionTable mbean = (ModEoCBroadcastStormProtectionTable) getModel();


        mbean.setModEoCBroadcastStormProtectionEN(new Integer(modEoCBroadcastStormProtectionENVList[tfModEoCBroadcastStormProtectionEN.getSelectedIndex()]));
        mbean.setModEoCBroadcastStormThreshold(new Integer(modEoCStormThresholdVList[tfModEoCBroadcastStormThreshold.getSelectedIndex()]));
        mbean.setModEoCMulticastStormProtectionEN(new Integer(modEoCMulticastStormProtectionENVList[tfModEoCMulticastStormProtectionEN.getSelectedIndex()]));
        mbean.setModEoCMulticastStormThreshold(new Integer(modEoCStormThresholdVList[tfModEoCBroadcastStormThreshold.getSelectedIndex()]));
        mbean.setModEoCUnknownUnicastStormProtectionEN(new Integer(modEoCUnknownUnicastStormProtectionENVList[tfModEoCUnknownUnicastStormProtectionEN.getSelectedIndex()]));
        mbean.setModEoCUnknownUnicastStormThreshold(new Integer(modEoCStormThresholdVList[tfModEoCBroadcastStormThreshold.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

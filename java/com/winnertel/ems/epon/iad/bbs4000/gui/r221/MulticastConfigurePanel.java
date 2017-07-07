package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.MulticastConfigure;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class MulticastConfigurePanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcMulticastSwitchVList = new int[]{1, 2, 3, 4};
    private String[] utsDot3Onu2CtcMulticastSwitchTList = new String[]{
            fStringMap.getString("special-snooping"),
            fStringMap.getString("control-snooping"),
            fStringMap.getString("standard-snooping"),
            fStringMap.getString("disable")
    };
    private JComboBox tfUtsDot3Onu2CtcMulticastSwitch = new JComboBox(utsDot3Onu2CtcMulticastSwitchTList);

    private int[] fastLeaveVList = new int[]{1, 2,};
    private String[] fastLeaveTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    }; //modified by Zhou Chao, 2008/8/23
    private JComboBox tfUtsDot3Onu2FastLeaveAdminControl = new JComboBox(fastLeaveTList);

    private int[] multicastFilterVList = new int[]{1, 2,};
    private String[] multicastFilterTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable"),
    };
    private JComboBox tfUtsDot3Onu2MulticastFilter = new JComboBox(multicastFilterTList);

    private int[] utsDot3OnuMCastControlTypeVList = new int[]{1, 2, 3, 4};
    private String[] utsDot3OnuMCastControlTypeTList = new String[] {
            fStringMap.getString("gda-mac-only"),
            fStringMap.getString("gda-mac-mvlan"),
            fStringMap.getString("gda-mac-sa-mac"),
            fStringMap.getString("gda-ip-mvlan")
    };

    private JComboBox tfUtsDot3OnuMCastControlType = new JComboBox(utsDot3OnuMCastControlTypeTList);

    private final String utsDot3Onu2CtcMulticastSwitch = fStringMap.getString("utsDot3Onu2CtcMulticastSwitch") + ": ";
    private final String utsDot3Onu2MulticastFilter = fStringMap.getString("utsDot3Onu2MulticastFilter") + ": ";
    private final String utsDot3Onu2FastLeaveAdminControl = fStringMap.getString("utsDot3Onu2FastLeaveAdminControl") + ": ";
    private final String utsDot3Onu2CtcModuleId = fStringMap.getString("utsDot3Onu2CtcModuleId") + ": ";
    //private final String utsDot3Onu2CtcDeviceId = fStringMap.getString("utsDot3Onu2CtcDeviceId") + ": ";
    private final String utsDot3Onu2CtcPortId = fStringMap.getString("utsDot3Onu2CtcPortId") + ": ";
    private final String utsDot3Onu2CtcLogicalPortId = fStringMap.getString("utsDot3Onu2CtcLogicalPortId") + ": ";
    private final String utsDot3OnuMCastControlType = fStringMap.getString("utsDot3Onu2CtcMCastControlType") + ": ";

    public MulticastConfigurePanel(IApplication app) {
        super(app);
        init();
    }

    protected void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcDeviceId));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMulticastSwitch));
        tfUtsDot3Onu2CtcMulticastSwitch.setName(fStringMap.getString("utsDot3Onu2CtcMulticastSwitch"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMulticastSwitch);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2FastLeaveAdminControl));
        tfUtsDot3Onu2FastLeaveAdminControl.setName(fStringMap.getString("utsDot3Onu2FastLeaveAdminControl"));
        baseInfoPanel.add(tfUtsDot3Onu2FastLeaveAdminControl);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2MulticastFilter));
        tfUtsDot3Onu2MulticastFilter.setName(fStringMap.getString("utsDot3Onu2MulticastFilter"));
        baseInfoPanel.add(tfUtsDot3Onu2MulticastFilter);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsDot3OnuMCastControlType));
//        tfUtsDot3OnuMCastControlType.setName(fStringMap.getString("utsDot3OnuMCastControlType"));
//        baseInfoPanel.add(tfUtsDot3OnuMCastControlType);
//        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    public void refresh() {
        MulticastConfigure mbean = (MulticastConfigure) getModel();

        tfUtsDot3Onu2CtcModuleId.setText(mbean.getUtsDot3Onu2CtcModuleId().toString());
        //tfUtsDot3Onu2CtcDeviceId.setText(mbean.getUtsDot3Onu2CtcDeviceId().toString());
        tfUtsDot3Onu2CtcPortId.setText(mbean.getUtsDot3Onu2CtcPortId().toString());
        tfUtsDot3Onu2CtcLogicalPortId.setText(mbean.getUtsDot3Onu2CtcLogicalPortId().toString());

        tfUtsDot3Onu2CtcMulticastSwitch.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcMulticastSwitchVList, mbean.getUtsDot3Onu2CtcMulticastSwitch().intValue()));

        boolean adminStatusUpOrNot = mbean.getUtsDot3Onu2CtcAdmin().intValue() == 1;
        tfUtsDot3Onu2CtcMulticastSwitch.setEnabled(adminStatusUpOrNot);

        tfUtsDot3Onu2FastLeaveAdminControl.setSelectedIndex(getIndexFromValue(fastLeaveVList, mbean.getUtsDot3Onu2FastLeaveAdminControl()));
        tfUtsDot3Onu2MulticastFilter.setSelectedIndex(getIndexFromValue(multicastFilterVList, mbean.getUtsDot3Onu2MulticastFilter()));
        tfUtsDot3OnuMCastControlType.setSelectedIndex(getIndexFromValue(utsDot3OnuMCastControlTypeVList, mbean.getUtsDot3Onu2CtcMCastControlType()));
    }

    public void updateModel() {
        MulticastConfigure mbean = (MulticastConfigure) getModel();
        if (mbean.getUtsDot3Onu2CtcMulticastSwitch().intValue() != utsDot3Onu2CtcMulticastSwitchVList[tfUtsDot3Onu2CtcMulticastSwitch.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcMulticastSwitch(new Integer(utsDot3Onu2CtcMulticastSwitchVList[tfUtsDot3Onu2CtcMulticastSwitch.getSelectedIndex()]));
        }
        mbean.setUtsDot3Onu2FastLeaveAdminControl(fastLeaveVList[tfUtsDot3Onu2FastLeaveAdminControl.getSelectedIndex()]);
        mbean.setUtsDot3Onu2MulticastFilter(multicastFilterVList[tfUtsDot3Onu2MulticastFilter.getSelectedIndex()]);
        mbean.setUtsDot3Onu2CtcMCastControlType(utsDot3OnuMCastControlTypeVList[tfUtsDot3OnuMCastControlType.getSelectedIndex()]);
    }

    public void afterUpdateModel() {
        refresh();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}
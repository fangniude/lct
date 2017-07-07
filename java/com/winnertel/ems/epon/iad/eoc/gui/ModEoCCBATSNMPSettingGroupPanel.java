package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATSNMPSettingGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCBATSNMPSettingGroupPanel class.
 * Created by DVM Creator
 */
public class ModEoCCBATSNMPSettingGroupPanel extends UPanel {

    /*
    private int[] modEoCCBATAdminVarBindingsVList = new int[]{
            0 };
    private String[] modEoCCBATAdminVarBindingsTList = new String[]{
            fStringMap.getString("0-noLimit"),
    };
    private JComboBox tfModEoCCBATAdminVarBindings = new JComboBox(modEoCCBATAdminVarBindingsTList);
    */
    private JLabel tfModEoCCBATAdminVarBindings = new JLabel();

    private int[] modEoCCBATAdminSNMPVersionVList = new int[]{
            1, 0,};
    private String[] modEoCCBATAdminSNMPVersionTList = new String[]{
            fStringMap.getString("snmpv2c"),
            fStringMap.getString("snmpv1"),
    };
    private JComboBox tfModEoCCBATAdminSNMPVersion = new JComboBox(modEoCCBATAdminSNMPVersionTList);
    private JLabel tfModEoCCBATAdminSNMPCommunityTableNextIndex = new JLabel();


    private final String modEoCCBATAdminVarBindings = fStringMap.getString("modEoCCBATAdminVarBindings") + " : ";
    private final String modEoCCBATAdminSNMPVersion = fStringMap.getString("modEoCCBATAdminSNMPVersion") + " : ";
    private final String modEoCCBATAdminSNMPCommunityTableNextIndex = fStringMap.getString("modEoCCBATAdminSNMPCommunityTableNextIndex") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCCBATSNMPSettingGroupPanel(IApplication app) {
        super(app);
        setModel(new ModEoCCBATSNMPSettingGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCCBATSNMPSettingGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        //buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminVarBindings));
        baseInfoPanel.add(tfModEoCCBATAdminVarBindings);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminSNMPVersion));
        baseInfoPanel.add(tfModEoCCBATAdminSNMPVersion);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATAdminSNMPCommunityTableNextIndex));
        baseInfoPanel.add(tfModEoCCBATAdminSNMPCommunityTableNextIndex);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);


    }

    protected void initForm() {

        //tfModEoCCBATAdminSNMPVersion.setEnabled(false);
        //tfModEoCCBATAdminVarBindings.setEditable(true);
        //tfModEoCCBATAdminVarBindings.setEnabled(false);
        tfModEoCCBATAdminSNMPVersion.setEnabled(false);
    }

    public void refresh() {

        ModEoCCBATSNMPSettingGroup mbean = (ModEoCCBATSNMPSettingGroup) getModel();

        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        int bindNum = mbean.getModEoCCBATAdminVarBindings().intValue();
        String strNum = String.valueOf(bindNum);
        if (bindNum == 0) {
            strNum = fStringMap.getString("0-noLimit");
        }

        tfModEoCCBATAdminVarBindings.setText(strNum);
        tfModEoCCBATAdminSNMPVersion.setSelectedIndex(getIndexFromValue(modEoCCBATAdminSNMPVersionVList, mbean.getModEoCCBATAdminSNMPVersion().intValue()));
        tfModEoCCBATAdminSNMPCommunityTableNextIndex.setText(mbean.getModEoCCBATAdminSNMPCommunityTableNextIndex().toString());

    }

    public void updateModel() {

        ModEoCCBATSNMPSettingGroup mbean = (ModEoCCBATSNMPSettingGroup) getModel();


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATOtherAdminGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCBATOtherAdminGroupPanel class.
 * Created by DVM Creator
 */
public class ModEoCCBATOtherAdminGroupPanel extends UPanel {

    private int[] modEoCCBATAdminLinkTopoChangeVList = new int[]{
            1, 0,};
    private String[] modEoCCBATAdminLinkTopoChangeTList = new String[]{
            fStringMap.getString("modEoCCBATAdminLinkTopoChangeTList_change"),
            fStringMap.getString("modEoCCBATAdminLinkTopoChangeTList_no-change"),
    };
    private JComboBox tfModEoCCBATAdminLinkTopoChange = new JComboBox(modEoCCBATAdminLinkTopoChangeTList);
    private StringTextField tfModEoCCBATAdminAppropriativeOID = new StringTextField();


    private int[] modEoCCBATCardUpLinkBroadcastFrameSendMannerVList = new int[]{
            1, 2,};
    private String[] modEoCCBATCardUpLinkBroadcastFrameSendMannerTList = new String[]{
            fStringMap.getString("modEoCCBATCardUpLinkBroadcastFrameSendMannerTList_t1"),
            fStringMap.getString("modEoCCBATCardUpLinkBroadcastFrameSendMannerTList_t2"),
    };

    private JComboBox tfModEoCCBATCardUpLinkBroadcastFrameSendManner = new JComboBox(modEoCCBATCardUpLinkBroadcastFrameSendMannerTList);


    private final String modEoCCBATAdminLinkTopoChange = fStringMap.getString("modEoCCBATAdminLinkTopoChange") + " : ";
    private final String modEoCCBATAdminAppropriativeOID = fStringMap.getString("modEoCCBATAdminAppropriativeOID") + " : ";
    private final String modEoCCBATCardUpLinkBroadcastFrameSendManner = fStringMap.getString("modEoCCBATCardUpLinkBroadcastFrameSendManner") + " : ";

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCCBATOtherAdminGroupPanel(IApplication app) {
        super(app);
        setModel(new ModEoCCBATOtherAdminGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCCBATOtherAdminGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminLinkTopoChange));
        tfModEoCCBATAdminLinkTopoChange.setName(fStringMap.getString("modEoCCBATAdminLinkTopoChange"));
        baseInfoPanel.add(tfModEoCCBATAdminLinkTopoChange);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminAppropriativeOID));
        //tfModEoCCBATAdminLinkTopoChange.setName(fStringMap.getString("modEoCCBATAdminLinkTopoChange"));
        baseInfoPanel.add(tfModEoCCBATAdminAppropriativeOID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(modEoCCBATCardUpLinkBroadcastFrameSendManner));
        //tfModEoCCBATAdminLinkTopoChange.setName(fStringMap.getString("modEoCCBATAdminLinkTopoChange"));
        baseInfoPanel.add(tfModEoCCBATCardUpLinkBroadcastFrameSendManner);
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

        tfModEoCCBATAdminAppropriativeOID.setEditable(false);
        //tfModEoCCBATCardUpLinkBroadcastFrameSendManner.setEnabled(false);

    }

    public void refresh() {

        ModEoCCBATOtherAdminGroup mbean = (ModEoCCBATOtherAdminGroup) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCCBATAdminLinkTopoChange.setSelectedIndex(getIndexFromValue(modEoCCBATAdminLinkTopoChangeVList, mbean.getModEoCCBATAdminLinkTopoChange().intValue()));
        tfModEoCCBATAdminAppropriativeOID.setText(mbean.getModEoCCBATAdminAppropriativeOID());
        tfModEoCCBATCardUpLinkBroadcastFrameSendManner.setSelectedIndex(getIndexFromValue(modEoCCBATCardUpLinkBroadcastFrameSendMannerVList, mbean.getModEoCCBATCardUpLinkBroadcastFrameSendManner().intValue()));

    }

    public void updateModel() {

        ModEoCCBATOtherAdminGroup mbean = (ModEoCCBATOtherAdminGroup) getModel();

        mbean.setModEoCCBATAdminLinkTopoChange(new Integer(modEoCCBATAdminLinkTopoChangeVList[tfModEoCCBATAdminLinkTopoChange.getSelectedIndex()]));
        mbean.setModEoCCBATCardUpLinkBroadcastFrameSendManner(new Integer(modEoCCBATCardUpLinkBroadcastFrameSendMannerVList[tfModEoCCBATCardUpLinkBroadcastFrameSendManner.getSelectedIndex()]));

    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}


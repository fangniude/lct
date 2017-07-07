package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUPort;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCNUPortPanel class.
 * Created by DVM Creator
 */
public class ModEoCCNUPortPanel extends UPanel {

    private JLabel tfModEoCCNUPortPerCNULimitation = new JLabel();

    private IntegerTextField tfModEoCCNUPortAmountLimitation = new IntegerTextField();


    private final String modEoCCNUPortPerCNULimitation = fStringMap.getString("modEoCCNUPortPerCNULimitation") + " : ";
    private final String modEoCCNUPortAmountLimitation = fStringMap.getString("modEoCCNUPortAmountLimitation") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCCNUPortPanel(IApplication app) {
        super(app);
        setModel(new ModEoCCNUPort(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCCNUPort");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCNUPortPerCNULimitation));
        baseInfoPanel.add(tfModEoCCNUPortPerCNULimitation);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortAmountLimitation));
        tfModEoCCNUPortAmountLimitation.setName(fStringMap.getString("modEoCCNUPortAmountLimitation"));
        baseInfoPanel.add(tfModEoCCNUPortAmountLimitation);
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


    }

    public void refresh() {

        ModEoCCNUPort mbean = (ModEoCCNUPort) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCCNUPortPerCNULimitation.setText(mbean.getModEoCCNUPortPerCNULimitation().toString());
        tfModEoCCNUPortAmountLimitation.setValue(mbean.getModEoCCNUPortAmountLimitation().intValue());

    }

    public void updateModel() {

        ModEoCCNUPort mbean = (ModEoCCNUPort) getModel();


        mbean.setModEoCCNUPortAmountLimitation(new Integer(tfModEoCCNUPortAmountLimitation.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUWhiteList;
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
 * The ModEoCCNUWhiteListPanel class.
 * Created by DVM Creator
 */
public class ModEoCCNUWhiteListPanel extends UPanel {

    private IntegerTextField tfModEoCCNUWhiteListAmountLimitation = new IntegerTextField();

    private JLabel tfModEoCCNUWhiteListRegisteredAmount = new JLabel();

    private IntegerTextField tfModEoCCNUWhiteListAllRFOutputLevel = new IntegerTextField();

    private IntegerTextField tfModEoCCNUWhiteListAllExtMACLimitation = new IntegerTextField();

    private JLabel tfModEoCCNUWhiteListPhyRateGate = new JLabel();


    private final String modEoCCNUWhiteListAmountLimitation = fStringMap.getString("modEoCCNUWhiteListAmountLimitation") + " : ";
    private final String modEoCCNUWhiteListRegisteredAmount = fStringMap.getString("modEoCCNUWhiteListRegisteredAmount") + " : ";
    private final String modEoCCNUWhiteListAllRFOutputLevel = fStringMap.getString("modEoCCNUWhiteListAllRFOutputLevel") + " : ";
    private final String modEoCCNUWhiteListAllExtMACLimitation = fStringMap.getString("modEoCCNUWhiteListAllExtMACLimitation") + " : ";
    private final String modEoCCNUWhiteListPhyRateGate = fStringMap.getString("modEoCCNUWhiteListPhyRateGate") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCCNUWhiteListPanel(IApplication app) {
        super(app);
        setModel(new ModEoCCNUWhiteList(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCCNUWhiteList");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListAmountLimitation));
        tfModEoCCNUWhiteListAmountLimitation.setName(fStringMap.getString("modEoCCNUWhiteListAmountLimitation"));
        baseInfoPanel.add(tfModEoCCNUWhiteListAmountLimitation);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListRegisteredAmount));
        baseInfoPanel.add(tfModEoCCNUWhiteListRegisteredAmount);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListAllRFOutputLevel));
        tfModEoCCNUWhiteListAllRFOutputLevel.setName(fStringMap.getString("modEoCCNUWhiteListAllRFOutputLevel"));
        baseInfoPanel.add(tfModEoCCNUWhiteListAllRFOutputLevel);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListAllExtMACLimitation));
        tfModEoCCNUWhiteListAllExtMACLimitation.setName(fStringMap.getString("modEoCCNUWhiteListAllExtMACLimitation"));
        baseInfoPanel.add(tfModEoCCNUWhiteListAllExtMACLimitation);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUWhiteListPhyRateGate));
        baseInfoPanel.add(tfModEoCCNUWhiteListPhyRateGate);
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

        ModEoCCNUWhiteList mbean = (ModEoCCNUWhiteList) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCCNUWhiteListAmountLimitation.setValue(mbean.getModEoCCNUWhiteListAmountLimitation().intValue());
        tfModEoCCNUWhiteListRegisteredAmount.setText(mbean.getModEoCCNUWhiteListRegisteredAmount().toString());
        tfModEoCCNUWhiteListAllRFOutputLevel.setValue(mbean.getModEoCCNUWhiteListAllRFOutputLevel().intValue());
        tfModEoCCNUWhiteListAllExtMACLimitation.setValue(mbean.getModEoCCNUWhiteListAllExtMACLimitation().intValue());
        tfModEoCCNUWhiteListPhyRateGate.setText(mbean.getModEoCCNUWhiteListPhyRateGate().toString());

    }

    public void updateModel() {

        ModEoCCNUWhiteList mbean = (ModEoCCNUWhiteList) getModel();

        mbean.setModEoCCNUWhiteListAmountLimitation(new Integer(tfModEoCCNUWhiteListAmountLimitation.getValue()));

        mbean.setModEoCCNUWhiteListAllRFOutputLevel(new Integer(tfModEoCCNUWhiteListAllRFOutputLevel.getValue()));
        mbean.setModEoCCNUWhiteListAllExtMACLimitation(new Integer(tfModEoCCNUWhiteListAllExtMACLimitation.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

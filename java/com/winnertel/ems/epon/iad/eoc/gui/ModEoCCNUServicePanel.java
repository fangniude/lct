package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUService;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
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
 * The ModEoCCNUServicePanel class.
 * Created by DVM Creator
 */
public class ModEoCCNUServicePanel extends UPanel {

    private int[] modEoCCNUServiceTypeVList = new int[]{
            1, 2, 3};
    private String[] modEoCCNUServiceTypeTList = new String[]{
            fStringMap.getString("VID"),
            fStringMap.getString("dot1p"),
            fStringMap.getString("TOS"),
    };

    private JComboBox tfModEoCCNUServiceType = new JComboBox(modEoCCNUServiceTypeTList);

    private IntegerTextField tfModEoCCNUServiceAmountLimitation = new IntegerTextField();


    private final String modEoCCNUServiceType = fStringMap.getString("modEoCCNUServiceType") + " : ";
    private final String modEoCCNUServiceAmountLimitation = fStringMap.getString("modEoCCNUServiceAmountLimitation") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCCNUServicePanel(IApplication app) {
        super(app);
        setModel(new ModEoCCNUService(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCCNUService");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCNUServiceType));
        tfModEoCCNUServiceType.setName(fStringMap.getString("modEoCCNUServiceType"));
        baseInfoPanel.add(tfModEoCCNUServiceType);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUServiceAmountLimitation));
        tfModEoCCNUServiceAmountLimitation.setName(fStringMap.getString("modEoCCNUServiceAmountLimitation"));
        baseInfoPanel.add(tfModEoCCNUServiceAmountLimitation);
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

        ModEoCCNUService mbean = (ModEoCCNUService) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCCNUServiceType.setSelectedIndex(getIndexFromValue(modEoCCNUServiceTypeVList, mbean.getModEoCCNUServiceType().intValue()));
        tfModEoCCNUServiceAmountLimitation.setValue(mbean.getModEoCCNUServiceAmountLimitation().intValue());

    }

    public boolean validateFrom() {
        /* compiled code */
        if (tfModEoCCNUServiceType.getSelectedIndex() < 0) {
            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Select_ModEoCCNUServiceType"));
            return false;
        }

        return true;
    }

    public void updateModel() {

        ModEoCCNUService mbean = (ModEoCCNUService) getModel();

        mbean.setModEoCCNUServiceType(new Integer(modEoCCNUServiceTypeVList[tfModEoCCNUServiceType.getSelectedIndex()]));
        mbean.setModEoCCNUServiceAmountLimitation(new Integer(tfModEoCCNUServiceAmountLimitation.getValue()));

    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return -1;
    }

}
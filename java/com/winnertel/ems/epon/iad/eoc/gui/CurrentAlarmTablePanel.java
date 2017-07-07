package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.CurrentAlarmTable;
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
 * The CurrentAlarmTablePanel class.
 * Created by DVM Creator
 */
public class CurrentAlarmTablePanel extends UPanel {


    private StringTextField cbCurrentAlarmOID = new StringTextField();

    private int[] currentAlarmStateVList = new int[]{
            2, 3, 7, 4, 5, 6,};
    private String[] currentAlarmStateTList = new String[]{
            fStringMap.getString("caasHIHI"),
            fStringMap.getString("caasHI"),
            fStringMap.getString("caasDiscreteMinor"),
            fStringMap.getString("caasLO"),
            fStringMap.getString("caasLOLO"),
            fStringMap.getString("caasDiscreteMajor"),
    };
    private JComboBox tfCurrentAlarmState = new JComboBox(currentAlarmStateTList);
    private JLabel tfCurrentAlarmValue = new JLabel();


    private final String currentAlarmOID = fStringMap.getString("currentAlarmOID") + " : ";
    private final String currentAlarmState = fStringMap.getString("currentAlarmState") + " : ";
    private final String currentAlarmValue = fStringMap.getString("currentAlarmValue") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public CurrentAlarmTablePanel(IApplication app) {
        super(app);
        setModel(new CurrentAlarmTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_CurrentAlarmTable");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(currentAlarmOID));
        baseInfoPanel.add(cbCurrentAlarmOID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(currentAlarmState));
        baseInfoPanel.add(tfCurrentAlarmState);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(currentAlarmValue));
        baseInfoPanel.add(tfCurrentAlarmValue);
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

        CurrentAlarmTable mbean = (CurrentAlarmTable) getModel();
        BeanService.refreshBean(fApplication, mbean);

        cbCurrentAlarmOID.setText(mbean.getCurrentAlarmOID());
        tfCurrentAlarmState.setSelectedIndex(getIndexFromValue(currentAlarmStateVList, mbean.getCurrentAlarmState().intValue()));
        tfCurrentAlarmValue.setText(mbean.getCurrentAlarmValue().toString());

    }

    public void updateModel() {

        CurrentAlarmTable mbean = (CurrentAlarmTable) getModel();


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}

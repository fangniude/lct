package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.AlarmLog;
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
 * The AlarmLogPanel class.
 * Created by DVM Creator
 */
public class AlarmLogPanel extends UPanel {

    private JLabel tfAlarmLogNumberOfEntries = new JLabel();

    private JLabel tfAlarmLogLastIndex = new JLabel();

    private JLabel tfAlarmText = new JLabel();


    private final String alarmLogNumberOfEntries = fStringMap.getString("alarmLogNumberOfEntries") + " : ";
    private final String alarmLogLastIndex = fStringMap.getString("alarmLogLastIndex") + " : ";
    private final String alarmText = fStringMap.getString("alarmText") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public AlarmLogPanel(IApplication app) {
        super(app);
        setModel(new AlarmLog(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_AlarmLog");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(alarmLogNumberOfEntries));
        baseInfoPanel.add(tfAlarmLogNumberOfEntries);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(alarmLogLastIndex));
        baseInfoPanel.add(tfAlarmLogLastIndex);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(alarmText));
        baseInfoPanel.add(tfAlarmText);
        baseInfoPanel.add(new HSpacer());
        */

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

        AlarmLog mbean = (AlarmLog) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfAlarmLogNumberOfEntries.setText(mbean.getAlarmLogNumberOfEntries().toString());
        tfAlarmLogLastIndex.setText(mbean.getAlarmLogLastIndex().toString());
        tfAlarmText.setText(mbean.getAlarmText());

    }

    public void updateModel() {

        AlarmLog mbean = (AlarmLog) getModel();


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }
}

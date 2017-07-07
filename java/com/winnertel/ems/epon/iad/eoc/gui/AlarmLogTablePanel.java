package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.AlarmLogTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The AlarmLogTablePanel class.
 * Created by DVM Creator
 */
public class AlarmLogTablePanel extends UPanel {

    private JLabel tfAlarmLogIndex = new JLabel();

    private JLabel tfAlarmLogInformation = new JLabel();


    private final String alarmLogIndex = fStringMap.getString("alarmLogIndex") + " : ";
    private final String alarmLogInformation = fStringMap.getString("alarmLogInformation") + " : ";


    public AlarmLogTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(alarmLogIndex));
        baseInfoPanel.add(tfAlarmLogIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(alarmLogInformation));
        baseInfoPanel.add(tfAlarmLogInformation);
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


    }

    public void refresh() {

        AlarmLogTable mbean = (AlarmLogTable) getModel();

        tfAlarmLogIndex.setText(mbean.getAlarmLogIndex().toString());
        //tfAlarmLogInformation.setText(mbean.getAlarmLogInformation());

    }

    public void updateModel() {

        AlarmLogTable mbean = (AlarmLogTable) getModel();


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }
}

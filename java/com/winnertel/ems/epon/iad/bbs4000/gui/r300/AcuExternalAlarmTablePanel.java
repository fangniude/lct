package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.AcuExternalAlarmTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class AcuExternalAlarmTablePanel extends UPanel {

    private JLabel tfUtsBbsAcuExternalAlarmIndex = new JLabel();
    private int[] utsBbsAcuExternalAlarmEnableVList = new int[]{1, 2,};
    private String[] utsBbsAcuExternalAlarmEnableTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };

    private JComboBox tfUtsBbsAcuExternalAlarmEnable = new JComboBox(utsBbsAcuExternalAlarmEnableTList);
    private StringTextField tfUtsBbsAcuExternalAlarmDescription = new StringTextField();

    private int[] utsBbsAcuExternalAlarmSeverityVList = new int[]{1, 2, 3,};
    private String[] utsBbsAcuExternalAlarmSeverityTList = new String[]{
            fStringMap.getString("Critical"),
            fStringMap.getString("Major"),
            fStringMap.getString("Minor"),
    };
    private JComboBox tfUtsBbsAcuExternalAlarmSeverity = new JComboBox(utsBbsAcuExternalAlarmSeverityTList);

    private int[] utsBbsAcuExternalAlarmReportCriteriaVList = new int[]{1, 2,};
    private String[] utsBbsAcuExternalAlarmReportCriteriaTList = new String[]{
            fStringMap.getString("Open"),
            fStringMap.getString("Close"),
    };
    private JComboBox tfUtsBbsAcuExternalAlarmReportCriteria = new JComboBox(utsBbsAcuExternalAlarmReportCriteriaTList);

    private final String utsBbsAcuExternalAlarmIndex = fStringMap.getString("utsBbsAcuExternalAlarmIndex") + ": ";
    private final String utsBbsAcuExternalAlarmEnable = fStringMap.getString("utsBbsAcuExternalAlarmEnable") + ": ";
    private final String utsBbsAcuExternalAlarmDescription = fStringMap.getString("utsBbsAcuExternalAlarmDescription") + ": ";
    private final String utsBbsAcuExternalAlarmSeverity = fStringMap.getString("utsBbsAcuExternalAlarmSeverity") + ": ";
    private final String utsBbsAcuExternalAlarmReportCriteria = fStringMap.getString("utsBbsAcuExternalAlarmReportCriteria") + ": ";

    public AcuExternalAlarmTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsBbsAcuExternalAlarmIndex));
        baseInfoPanel.add(tfUtsBbsAcuExternalAlarmIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBbsAcuExternalAlarmEnable));
        tfUtsBbsAcuExternalAlarmEnable.setName(fStringMap.getString("utsBbsAcuExternalAlarmEnable"));
        baseInfoPanel.add(tfUtsBbsAcuExternalAlarmEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBbsAcuExternalAlarmDescription));
        tfUtsBbsAcuExternalAlarmDescription.setName(fStringMap.getString("utsBbsAcuExternalAlarmDescription"));
        baseInfoPanel.add(tfUtsBbsAcuExternalAlarmDescription);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBbsAcuExternalAlarmSeverity));
        tfUtsBbsAcuExternalAlarmSeverity.setName(fStringMap.getString("utsBbsAcuExternalAlarmSeverity"));
        baseInfoPanel.add(tfUtsBbsAcuExternalAlarmSeverity);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBbsAcuExternalAlarmReportCriteria));
        tfUtsBbsAcuExternalAlarmReportCriteria.setName(fStringMap.getString("utsBbsAcuExternalAlarmReportCriteria"));
        baseInfoPanel.add(tfUtsBbsAcuExternalAlarmReportCriteria);
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
        tfUtsBbsAcuExternalAlarmDescription.setLenScope(0, 64);
    }

    public void refresh() { //modified by Zhou Chao, 2009/6/19
        AcuExternalAlarmTable mbean = (AcuExternalAlarmTable) getModel();

        tfUtsBbsAcuExternalAlarmIndex.setText(mbean.getUtsBbsAcuExternalAlarmIndex().toString());
        tfUtsBbsAcuExternalAlarmEnable.setSelectedIndex(getIndexFromValue(utsBbsAcuExternalAlarmEnableVList, mbean.getUtsBbsAcuExternalAlarmEnable()));
        tfUtsBbsAcuExternalAlarmDescription.setValue(new String(mbean.getUtsBbsAcuExternalAlarmDescription()));
        tfUtsBbsAcuExternalAlarmSeverity.setSelectedIndex(getIndexFromValue(utsBbsAcuExternalAlarmSeverityVList, mbean.getUtsBbsAcuExternalAlarmSeverity()));
        tfUtsBbsAcuExternalAlarmReportCriteria.setSelectedIndex(getIndexFromValue(utsBbsAcuExternalAlarmReportCriteriaVList, mbean.getUtsBbsAcuExternalAlarmReportCriteria()));
    }

    public void updateModel() { //modified by Zhou Chao, 2009/6/19
        AcuExternalAlarmTable mbean = (AcuExternalAlarmTable) getModel();

        mbean.setUtsBbsAcuExternalAlarmEnable(utsBbsAcuExternalAlarmEnableVList[tfUtsBbsAcuExternalAlarmEnable.getSelectedIndex()]);
        mbean.setUtsBbsAcuExternalAlarmDescription(tfUtsBbsAcuExternalAlarmDescription.getValue().getBytes());
        mbean.setUtsBbsAcuExternalAlarmSeverity(utsBbsAcuExternalAlarmSeverityVList[tfUtsBbsAcuExternalAlarmSeverity.getSelectedIndex()]);
        mbean.setUtsBbsAcuExternalAlarmReportCriteria(utsBbsAcuExternalAlarmReportCriteriaVList[tfUtsBbsAcuExternalAlarmReportCriteria.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}
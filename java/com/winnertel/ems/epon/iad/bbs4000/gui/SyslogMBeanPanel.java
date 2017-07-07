package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.SyslogMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class SyslogMBeanPanel extends UPanel {

    private int[] utsSyslogFormatVList = new int[]{1, 2,};
    private String[] utsSyslogFormatTList = new String[]{
            fStringMap.getString("non-rfc3164"),
            fStringMap.getString("rfc3164"),
    };
    private JComboBox tfUtsSyslogFormat = new JComboBox(utsSyslogFormatTList);
    /*
Severity Level        Description 
0 �C emergency       System is unusable
1 �C alert           Immediate action required
2 �C critical        Critical condition
3 �C error           Error condition
4 - warning         Warning condition
5 - notification    Normal but significant condition
6 - informational   Informational message only
7 - debugging       Message that appears during debugging only
     */
    private int[] utsSyslogConsoleSeverityVList = new int[]{1, 2, 3, 4, 5, 6, 7, 8,};
    private String[] utsSyslogConsoleSeverityTList = new String[]{           
            fStringMap.getString("emergencies"), //3
            fStringMap.getString("alerts"),  //1
            fStringMap.getString("critical"),  //6
            fStringMap.getString("errors"),  //4
            fStringMap.getString("warning"),  //5
            fStringMap.getString("notification"),  //2
            fStringMap.getString("informational"),  //7
            fStringMap.getString("debugging"), //8
    };
    private JComboBox tfUtsSyslogConsoleSeverity = new JComboBox(utsSyslogConsoleSeverityTList);

    private int[] utsSyslogFlashSeverityVList = new int[]{1, 2, 3, 4, 5, 6, 7, 8,};
    private String[] utsSyslogFlashSeverityTList = new String[]{            
            fStringMap.getString("emergencies"), //3
            fStringMap.getString("alerts"),  //1
            fStringMap.getString("critical"),  //6
            fStringMap.getString("errors"),  //4
            fStringMap.getString("warning"),  //5
            fStringMap.getString("notification"),  //2
            fStringMap.getString("informational"),  //7
            fStringMap.getString("debugging"), //8
    };
    private JComboBox tfUtsSyslogFlashSeverity = new JComboBox(utsSyslogFlashSeverityTList);

    private final String utsSyslogFormat = fStringMap.getString("utsSyslogFormat") + ": ";
    private final String utsSyslogConsoleSeverity = fStringMap.getString("utsSyslogConsoleSeverity") + ": ";
    private final String utsSyslogFlashSeverity = fStringMap.getString("utsSyslogFlashSeverity") + ": ";

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public SyslogMBeanPanel(IApplication app) {
        super(app);
        setModel(new SyslogMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SyslogMBean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsSyslogGroup")));

        baseInfoPanel.add(new JLabel(utsSyslogFormat));
        tfUtsSyslogFormat.setName(fStringMap.getString("utsSyslogFormat"));
        baseInfoPanel.add(tfUtsSyslogFormat);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsSyslogConsoleSeverity));
        tfUtsSyslogConsoleSeverity.setName(fStringMap.getString("utsSyslogConsoleSeverity"));
        baseInfoPanel.add(tfUtsSyslogConsoleSeverity);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsSyslogFlashSeverity));
        tfUtsSyslogFlashSeverity.setName(fStringMap.getString("utsSyslogFlashSeverity"));
        baseInfoPanel.add(tfUtsSyslogFlashSeverity);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(6, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        // allPanel.add(new VSpacer());
        allPanel.add(buttonsPanel);
        allPanel.add(new VSpacer());

        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        SnmpTablePane tablepanel1 = (SnmpTablePane) composer1.composeSnmpTablePane("SyslogServerTable");
        tablepanel1.setPreferredSize(new Dimension(100, 300));
        tablepanel1.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsSyslogServerTable")));

        allPanel.add(tablepanel1);

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.NORTH);

        tablepanel1.refresh();
    }

    protected void initForm() {
        tfUtsSyslogConsoleSeverity.setSelectedIndex(4);
        tfUtsSyslogFlashSeverity.setSelectedIndex(4);
    }

    public void refresh() {
        SyslogMBean mbean = (SyslogMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfUtsSyslogFormat.setSelectedIndex(getIndexFromValue(utsSyslogFormatVList, mbean.getUtsSyslogFormat().intValue()));
        tfUtsSyslogConsoleSeverity.setSelectedIndex(getIndexFromValue(utsSyslogConsoleSeverityVList, mbean.getUtsSyslogConsoleSeverity().intValue()));
        tfUtsSyslogFlashSeverity.setSelectedIndex(getIndexFromValue(utsSyslogFlashSeverityVList, mbean.getUtsSyslogFlashSeverity().intValue()));
    }

    public void updateModel() {
        SyslogMBean mbean = (SyslogMBean) getModel();

        mbean.setUtsSyslogFormat(new Integer(utsSyslogFormatVList[tfUtsSyslogFormat.getSelectedIndex()]));
        mbean.setUtsSyslogConsoleSeverity(new Integer(utsSyslogConsoleSeverityVList[tfUtsSyslogConsoleSeverity.getSelectedIndex()]));
        mbean.setUtsSyslogFlashSeverity(new Integer(utsSyslogFlashSeverityVList[tfUtsSyslogFlashSeverity.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}
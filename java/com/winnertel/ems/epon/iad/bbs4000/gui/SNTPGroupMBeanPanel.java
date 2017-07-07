package com.winnertel.ems.epon.iad.bbs4000.gui;

/*
           * Copyright (c) 2002-2005 UTStarcom, Inc.
           * All rights reserved.
           */

import com.winnertel.ems.epon.iad.bbs4000.mib.SNTPGroupMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SNTPGroupMBeanPanel class.
 * Created by DVM Creator
 */
public class SNTPGroupMBeanPanel extends UPanel implements ActionListener {

    private int[] utsSNTPServiceStateVList = new int[]{
        1, 2, };
    private String[] utsSNTPServiceStateTList = new String[]{
        fStringMap.getString("No-Service"),
        fStringMap.getString("Client-Active"),
    };
    private JComboBox tfUtsSNTPServiceState = new JComboBox(utsSNTPServiceStateTList);
    private IntegerTextField tfUtsSNTPPollInterval = new IntegerTextField();

//    private IntegerTextField tfUtsSNTPTimeZone = new IntegerTextField();
    private int[] SNTPTimeZoneVlist = new int[]{-12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
                                                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private String[] SNTPTimeZoneTlist = new String[]{"GMT -12:00) International Dateline West",
                                                      "(GMT -11:00) Midway Island, Samoa",
                                                      "(GMT -10:00) Hawaii",
                                                      "(GMT -09:00) Alaska",
                                                      "(GMT -08:00) Pacific Time(US, Canada); Tijuana",
                                                      "(GMT -07:00) Mountain Time (US, Canada)",
                                                      "(GMT -06:00) Central Time (US, Canada)",
                                                      "(GMT -05:00) Eastern Time (US, Canada)",
                                                      "(GMT -04:00) Atlantic Time (Canada)",
                                                      "(GMT -03:00) Buenos Aires, Georgetown",
                                                      "(GMT -02:00) Mid-Atlantic",
                                                      "(GMT -01:00) Cape Verde Is",
                                                      "(GMT) Casablanca, Monrovia,Greenwich Mean Time  Dublin, Edinburgh, Lisbon, London",
                                                      "(GMT +01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna",
                                                      "(GMT +02:00) Athens, Bucharest, Istanbul, Minsk",
                                                      "(GMT +03:00) Moscow, St. Petersburg, Volgograd",
                                                      "(GMT +04:00) Abu Dhabi, Muscat",
                                                      "(GMT +05:00) Islamabad, Karachi, Tashkent",
                                                      "(GMT +06:00) Almaty, Novosibirsk,Rangoon",
                                                      "(GMT +07:00) Bangkok, Hanoi, Jakarta",
                                                      "(GMT +08:00) Beijing, Chongqing, Hong Kong, Urumqi",
                                                      "(GMT +09:00) Osaka, Sapporo, Tokyo",
                                                      "(GMT +10:00) Canberra, Melbourne, Sydney",
                                                      "(GMT +11:00) Magadan, Solomon Is., New Caledonia",
                                                      "(GMT +12:00) Auckland, Fiji, Kamchatka, Marshal Is.",
                                                      "(GMT +13:00) Nuku'alfoa"};
    private JComboBox cbUtsSNTPTimeZone = new JComboBox(SNTPTimeZoneTlist);

//    private IntegerTextField tfUtsSNTPClockSync = new IntegerTextField();

    private JLabel tfUtsSNTPCurrentTime = new JLabel();

    private JLabel tfUtsSNTPLastUpdateTime = new JLabel();


    private final String utsSNTPServiceState = fStringMap.getString("utsSNTPServiceState") + " : ";
    private final String utsSNTPPollInterval = fStringMap.getString("utsSNTPPollInterval") + " : ";
    private final String utsSNTPTimeZone = fStringMap.getString("utsSNTPTimeZone") + " : ";
    private final String utsSNTPCurrentTime = fStringMap.getString("utsSNTPCurrentTime") + " : ";
    private final String utsSNTPLastUpdateTime = fStringMap.getString("utsSNTPLastUpdateTime") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;
    private JButton syncButton;
    private SnmpTablePane tablepanel1;
    private JPanel baseInfoPanel;

    public SNTPGroupMBeanPanel(IApplication app) {
        super(app);
        setModel(new SNTPGroupMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SNTPGroupMBean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        syncButton = new JButton(fStringMap.getString("utsSNTPClockSync"));
        syncButton.addActionListener(this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);
        buttonsPanel.add(syncButton);

        baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsSNTPGroup")));
        
        baseInfoPanel.add(new JLabel(utsSNTPServiceState));
        tfUtsSNTPServiceState.setName(fStringMap.getString("utsSNTPServiceState"));
        baseInfoPanel.add(tfUtsSNTPServiceState);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsSNTPPollInterval));
        tfUtsSNTPPollInterval.setName(fStringMap.getString("utsSNTPPollInterval"));
        baseInfoPanel.add(tfUtsSNTPPollInterval);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSNTPTimeZone));
        cbUtsSNTPTimeZone.setName(fStringMap.getString("utsSNTPTimeZone"));
        baseInfoPanel.add(cbUtsSNTPTimeZone);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSNTPCurrentTime));
        baseInfoPanel.add(tfUtsSNTPCurrentTime);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsSNTPLastUpdateTime));
        baseInfoPanel.add(tfUtsSNTPLastUpdateTime);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(6, 1, NTLayout.FILL, NTLayout.CENTER, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
      //  allPanel.add(new VSpacer());
        allPanel.add(buttonsPanel);
        allPanel.add(new VSpacer());

        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel1 = (SnmpTablePane) composer1.composeSnmpTablePane("SNTPServerTable");
        tablepanel1.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsSNTPServerTable")));
        allPanel.add(tablepanel1);

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.NORTH);
        this.setPreferredSize(new Dimension(100, 200));
    }

    protected void initForm() {

        tfUtsSNTPPollInterval.setValueScope(16, 16284);
        tfUtsSNTPPollInterval.setDefaultValue(1800);
        cbUtsSNTPTimeZone.setSelectedIndex(8);
        tablepanel1.setPreferredSize(new Dimension(100, 300));
        baseInfoPanel.setPreferredSize(new Dimension(100, 200));
    }

    public void refresh() {
        SNTPGroupMBean mbean = (SNTPGroupMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfUtsSNTPServiceState.setSelectedIndex(getIndexFromValue(utsSNTPServiceStateVList, mbean.getUtsSNTPServiceState().intValue()));
        tfUtsSNTPPollInterval.setValue(mbean.getUtsSNTPPollInterval().intValue());
        cbUtsSNTPTimeZone.setSelectedIndex(getIndexFromValue(SNTPTimeZoneVlist,mbean.getUtsSNTPTimeZone().intValue()));
        tfUtsSNTPCurrentTime.setText(mbean.getUtsSNTPCurrentTime());
        tfUtsSNTPLastUpdateTime.setText(mbean.getUtsSNTPLastUpdateTime());

        if (mbean.getUtsSNTPServiceState() == 2)
            syncButton.setEnabled(true);
        else
            syncButton.setEnabled(false);

        tablepanel1.refresh();
    }

    public void updateModel() {

        SNTPGroupMBean mbean = (SNTPGroupMBean) getModel();

        mbean.setUtsSNTPServiceState(new Integer(utsSNTPServiceStateVList[tfUtsSNTPServiceState.getSelectedIndex()]));
        mbean.setUtsSNTPPollInterval(new Integer(tfUtsSNTPPollInterval.getValue()));
        mbean.setUtsSNTPTimeZone(new Integer(SNTPTimeZoneVlist[cbUtsSNTPTimeZone.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        SNTPGroupMBean mbean = (SNTPGroupMBean) getModel();

        try {
            mbean.syncClock();
            refresh();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.SNTPGroupMBean;
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

public class SNTPGroupMBeanPanel extends UPanel implements ActionListener {

    private int[] utsSNTPServiceStateVList = new int[]{
            1, 2,};
    private String[] utsSNTPServiceStateTList = new String[]{
            fStringMap.getString("No-Service"),
            fStringMap.getString("Client-Active"),
    };
    private JComboBox tfUtsSNTPServiceState = new JComboBox(utsSNTPServiceStateTList);
    private IntegerTextField tfUtsSNTPPollInterval = new IntegerTextField();

//    private IntegerTextField tfUtsSNTPTimeZone = new IntegerTextField();
    private int[] SNTPTimeZoneVlist = new int[]{-12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private String[] SNTPTimeZoneTlist = new String[]{"GMT -12",
            "GMT -11",
            "GMT -10",
            "GMT -09",
            "GMT -08",
            "GMT -07",
            "GMT -06",
            "GMT -05",
            "GMT -04",
            "GMT -03",
            "GMT -02",
            "GMT -01",
            "GMT",
            "GMT +01",
            "GMT +02",
            "GMT +03",
            "GMT +04",
            "GMT +05",
            "GMT +06",
            "GMT +07",
            "GMT +08",
            "GMT +09",
            "GMT +10",
            "GMT +11",
            "GMT +12",
            "GMT +13"};
    private JComboBox cbUtsSNTPTimeZone = new JComboBox(SNTPTimeZoneTlist);

    private JComboBox tfUtsSNTPTimeZoneMinuteOffset = new JComboBox();
//    private IntegerTextField tfUtsSNTPClockSync = new IntegerTextField();

    private JLabel tfUtsSNTPCurrentTime = new JLabel();

    private JLabel tfUtsSNTPLastUpdateTime = new JLabel();


    private final String utsSNTPServiceState = fStringMap.getString("utsSNTPServiceState") + " : ";
    private final String utsSNTPPollInterval = fStringMap.getString("utsSNTPPollInterval") + " : ";
    private final String utsSNTPTimeZone = fStringMap.getString("utsSNTPTimeZone") + " : ";
    private final String utsSNTPCurrentTime = fStringMap.getString("utsSNTPCurrentTime") + " : ";
    private final String utsSNTPLastUpdateTime = fStringMap.getString("utsSNTPLastUpdateTime") + " : ";
    private final String utsSNTPTimeZoneMinuteOffset = fStringMap.getString("utsSNTPTimeZoneMinuteOffset") + " : ";

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
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        for (int i = 0; i < 60; i++) {
            tfUtsSNTPTimeZoneMinuteOffset.addItem(i);
        }
        baseInfoPanel.add(new JLabel(utsSNTPTimeZoneMinuteOffset));
        tfUtsSNTPTimeZoneMinuteOffset.setName(fStringMap.getString("utsSNTPTimeZoneMinuteOffset"));
        baseInfoPanel.add(tfUtsSNTPTimeZoneMinuteOffset);
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
        cbUtsSNTPTimeZone.setSelectedIndex(getIndexFromValue(SNTPTimeZoneVlist, mbean.getUtsSNTPTimeZone().intValue()));
        tfUtsSNTPTimeZoneMinuteOffset.setSelectedItem(mbean.getUtsSNTPTimeZoneMinuteOffset());
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
        mbean.setUtsSNTPTimeZoneMinuteOffset((Integer) tfUtsSNTPTimeZoneMinuteOffset.getSelectedItem());
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

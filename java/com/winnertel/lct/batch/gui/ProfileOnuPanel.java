package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.lct.batch.bean.ProfileOnuBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import java.awt.*;

public class ProfileOnuPanel extends UPanel {

    private final String dbaSlaEnableLabel = fStringMap.getString("dbaSlaEnable");
    private final String upMaxBwLabel = fStringMap.getString("utsDot3OnuUpstreamPir");
    private final String downMaxBwLabel = fStringMap.getString("utsDot3OnuDownstreamPir");

    private JCheckBox pon1 = new JCheckBox("PON 1");
    private JCheckBox pon2 = new JCheckBox("PON 2");
    private JCheckBox pon3 = new JCheckBox("PON 3");
    private JCheckBox pon4 = new JCheckBox("PON 4");


    private int[] dbaSlaEnableVList = new int[]{0, 1};
    private String[] dbaSlaEnableTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable")
    };
    private JComboBox dbaSlaEnableF = new JComboBox(dbaSlaEnableTList);
    private IntegerTextField upMaxBwF = new IntegerTextField();
    private IntegerTextField downMaxBwF = new IntegerTextField();

    public ProfileOnuPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel ponPanel = new JPanel();
        NTLayout ponLayout = new NTLayout(1, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ponPanel.setLayout(ponLayout);
        ponPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("PON_Port")));

        ponPanel.add(pon1);
        ponPanel.add(pon2);
        ponPanel.add(pon3);
        ponPanel.add(pon4);

        NTLayout onuLayout = new NTLayout(2, 6, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel onuPanel = new JPanel();
        onuPanel.setLayout(onuLayout);
        onuPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_PON_port_config")));

        onuPanel.add(new JLabel(dbaSlaEnableLabel));
        onuPanel.add(dbaSlaEnableF);
        dbaSlaEnableF.addItemListener(e -> mxuMgmtGlbEnableChange());
        onuPanel.add(new HSpacer());
        onuPanel.add(new HSpacer());
        onuPanel.add(new HSpacer());
        onuPanel.add(new HSpacer());

        onuPanel.add(new JLabel(upMaxBwLabel));
        onuPanel.add(upMaxBwF);
        onuPanel.add(new HSpacer());

        onuPanel.add(new JLabel(downMaxBwLabel));
        onuPanel.add(downMaxBwF);
        onuPanel.add(new HSpacer());


        baseInfoPanel.add(ponPanel);
        baseInfoPanel.add(onuPanel);

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    private void mxuMgmtGlbEnableChange() {
        boolean enable = dbaSlaEnableF.getSelectedIndex() == 1;
        upMaxBwF.setEnabled(enable);
        downMaxBwF.setEnabled(enable);
    }

    protected void initForm() {
        upMaxBwF.setValueScope(1, 1000000);
        upMaxBwF.setDefaultValue(100000);
        downMaxBwF.setValueScope(1, 1000000);
        downMaxBwF.setDefaultValue(100000);
    }

    public void refresh() {
        pon1.setSelected(false);
        pon2.setSelected(false);
        pon3.setSelected(false);
        pon4.setSelected(false);
        dbaSlaEnableF.setSelectedIndex(0);
        mxuMgmtGlbEnableChange();
    }

    public void updateModel() {
//        uniTable.updateUI();
        if (pon1.isSelected()) {
            save(1);
        }
        if (pon2.isSelected()) {
            save(2);
        }
        if (pon3.isSelected()) {
            save(3);
        }
        if (pon4.isSelected()) {
            save(4);
        }
    }

    private void save(int i) {
        try {
            XmlProxy proxy = new XmlProxy(fApplication.getSnmpProxy().getTargetHost());

            ProfileOnuBean onu = new ProfileOnuBean(proxy);
            onu.setId(i + "-1");
            onu.setUpCommittedBw("128");
            onu.setDownCommittedBw("512");
            onu.setUpBurstSize("512");
            onu.setDownBurstSize("1536");
            onu.setUpFixBw("0");
            onu.setUpPriority("1");
            onu.setMxuMgmtGlbEnable("0");
            if (dbaSlaEnableF.getSelectedIndex() == 1) {
                onu.setDbaSlaEnable("1");
                int upMaxBw = upMaxBwF.getValue();
                int downMaxBw = downMaxBwF.getValue();
                onu.setDbaSlaEnable("1");
                onu.setUpMaxBw(String.valueOf(upMaxBw));
                onu.setDownMaxBw(String.valueOf(downMaxBw));
            } else {
                onu.setDbaSlaEnable("0");
            }
            onu.add();

            setModel(onu);

            onu.setId(i + "-1");
            onu.setUpCommittedBw("128");
            onu.setDownCommittedBw("512");
            onu.setUpBurstSize("512");
            onu.setDownBurstSize("1536");
            onu.setUpFixBw("0");
            onu.setUpPriority("1");
            onu.setMxuMgmtGlbEnable("0");
            if (dbaSlaEnableF.getSelectedIndex() == 1) {
                onu.setDbaSlaEnable("1");
                int upMaxBw = upMaxBwF.getValue();
                int downMaxBw = downMaxBwF.getValue();
                onu.setDbaSlaEnable("1");
                onu.setUpMaxBw(String.valueOf(upMaxBw));
                onu.setDownMaxBw(String.valueOf(downMaxBw));
            } else {
                onu.setDbaSlaEnable("0");
            }

        } catch (MibBeanException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterUpdateModel() {
        super.afterUpdateModel();
        SnmpTablePane snmpTablePane = (SnmpTablePane) this.getTable().getParent().getParent().getParent();
        ProfilePanel profilePanel = (ProfilePanel) snmpTablePane.getParent().getParent().getParent();
        profilePanel.refresh();
    }

    public int getIndexFromValue(String[] list, String v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i].equals(v))
                return i;
        }

        return 0;
    }
}

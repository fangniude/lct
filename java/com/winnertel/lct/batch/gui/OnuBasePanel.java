package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class OnuBasePanel extends UPanel {
    private final DvmStringMap stringMap;
    private IGuiComposer composer;

    public OnuBasePanel(IApplication app) {
        super(app);
        this.fApplication = app;
        composer = fApplication.getActiveDeviceManager().getGuiComposer();
        stringMap = new DvmStringMap(composer);
        initGui();
    }

    public void initGui() {
    }

    @Override
    public void refresh() {
        JTabbedPane jTabbedPane = new JTabbedPane();

        SnmpTablePane macPanel = (SnmpTablePane) composer.composeSnmpTablePane("OnuMacTable_Panel");
        SnmpTablePane onuCfgPanel = (SnmpTablePane) composer.composeSnmpTablePane("OnuCfgTable_Panel");
        SnmpTablePane onuUniPanel = (SnmpTablePane) composer.composeSnmpTablePane("OnuUniTable_Panel");

        jTabbedPane.addTab(stringMap.getString("Onu_Mac"), macPanel);
        jTabbedPane.addTab(stringMap.getString("Onu_Config"), onuCfgPanel);
        jTabbedPane.addTab(stringMap.getString("Uni_Config"), onuUniPanel);

        this.setLayout(new BorderLayout());
        this.add(jTabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
//    buttonPanel.add(new JButton(stringMap.getString("Import")));
//    buttonPanel.add(new JButton(stringMap.getString("Save_As")));
        buttonPanel.add(new JButton(stringMap.getString("Apply")));
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

}
package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.lct.batch.proxy.XmlDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class OnuBasePanel extends UPanel {
    private final DvmStringMap stringMap;
    private IGuiComposer composer;
    private JTabbedPane jTabbedPane;
    private SnmpTablePane macPanel;
    private SnmpTablePane onuCfgPanel;
    private SnmpTablePane onuUniPanel;

    public OnuBasePanel(IApplication app) {
        super(app);
        this.fApplication = app;
        composer = fApplication.getActiveDeviceManager().getGuiComposer();
        stringMap = new DvmStringMap(composer);
        initGui();
    }

    public void initGui() {
        jTabbedPane = new JTabbedPane();

        macPanel = (SnmpTablePane) composer.composeSnmpTablePane("OnuMacTable_Panel");
        onuCfgPanel = (SnmpTablePane) composer.composeSnmpTablePane("OnuCfgTable_Panel");
        onuUniPanel = (SnmpTablePane) composer.composeSnmpTablePane("OnuUniTable_Panel");

        jTabbedPane.addTab(stringMap.getString("Onu_Mac"), macPanel);
        jTabbedPane.addTab(stringMap.getString("Onu_Config"), onuCfgPanel);
        jTabbedPane.addTab(stringMap.getString("Uni_Config"), onuUniPanel);

        this.setLayout(new BorderLayout());
        this.add(jTabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
//    buttonPanel.add(new JButton(stringMap.getString("Import")));
//    buttonPanel.add(new JButton(stringMap.getString("Save_As")));
        JButton button = new JButton(stringMap.getString("Apply_OnuBase_xml"));
        buttonPanel.add(button);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                XmlDataBase db = XmlDataBase.getInstance(fApplication.getSnmpProxy().getTargetHost());
                db.sendOnuBase();
            }
        });
        this.add(buttonPanel, BorderLayout.SOUTH);
        jTabbedPane.addChangeListener(e -> refresh());
    }

    @Override
    public void refresh() {
        if (jTabbedPane.getSelectedIndex() == 0) {
            macPanel.refresh();
        } else if (jTabbedPane.getSelectedIndex() == 1) {
            onuCfgPanel.refresh();
        } else if (jTabbedPane.getSelectedIndex() == 2) {
            onuUniPanel.refresh();
        }
    }

}
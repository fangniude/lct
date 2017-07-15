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
public class OnuProfilePanel extends UPanel {
    private final DvmStringMap stringMap;
    private IGuiComposer composer;
    private JTabbedPane jTabbedPane;
    private SnmpTablePane onuPanel;
    private SnmpTablePane uniPanel;

    public OnuProfilePanel(IApplication app) {
        super(app);
        this.fApplication = app;
        composer = fApplication.getActiveDeviceManager().getGuiComposer();
        stringMap = new DvmStringMap(composer);
        initGui();
    }

    public void initGui() {
        jTabbedPane = new JTabbedPane();

        onuPanel = (SnmpTablePane) composer.composeSnmpTablePane("ProfileOnuTable_Panel");
        uniPanel = (SnmpTablePane) composer.composeSnmpTablePane("ProfileUniTable_Panel");

        jTabbedPane.addTab(stringMap.getString("Onu_Profile"), onuPanel);
        jTabbedPane.addTab(stringMap.getString("Uni_Profile"), uniPanel);

        this.setLayout(new BorderLayout());
        this.add(jTabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
//    buttonPanel.add(new JButton(stringMap.getString("Import")));
//    buttonPanel.add(new JButton(stringMap.getString("Save_As")));
        JButton button = new JButton(stringMap.getString("Apply_OnuProfile_xml"));
        buttonPanel.add(button);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                XmlDataBase db = XmlDataBase.getInstance(fApplication.getSnmpProxy().getTargetHost());
                db.sendOnuProfile();
            }
        });
        this.add(buttonPanel, BorderLayout.SOUTH);
        jTabbedPane.addChangeListener(e -> refresh());
    }

    @Override
    public void refresh() {
        if (jTabbedPane.getSelectedIndex() == 0) {
            onuPanel.refresh();
        } else if (jTabbedPane.getSelectedIndex() == 1) {
            uniPanel.refresh();
        }
    }

}
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
public class OltBasePanel extends UPanel {
    private final DvmStringMap stringMap;
    private IGuiComposer composer;
    private SnmpTablePane vlanPanel;
    private JButton applyOltBaseXml;
    private JTabbedPane jTabbedPane;
    private SnmpTablePane qinqPanel;
    private OltSystemPanel systemPanel;

    public OltBasePanel(IApplication app) {
        super(app);
        this.fApplication = app;
        composer = fApplication.getActiveDeviceManager().getGuiComposer();
        stringMap = new DvmStringMap(composer);
        initGui();
    }

    public void initGui() {
        jTabbedPane = new JTabbedPane();

        systemPanel = new OltSystemPanel(fApplication);
        jTabbedPane.addTab(stringMap.getString("System_Information"), systemPanel);
        vlanPanel = (SnmpTablePane) composer.composeSnmpTablePane("OltVlanTable_Panel");
        jTabbedPane.addTab(stringMap.getString("VLAN_Config"), vlanPanel);
        qinqPanel = (SnmpTablePane) composer.composeSnmpTablePane("OltQinQTable_Panel");
        jTabbedPane.addTab(stringMap.getString("QinQ_Config"), qinqPanel);

        this.setLayout(new BorderLayout());
        this.add(jTabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
//    buttonPanel.add(new JButton(stringMap.getString("Import")));
//    buttonPanel.add(new JButton(stringMap.getString("Save_As")));
        applyOltBaseXml = new JButton(stringMap.getString("Apply_OltBase_xml"));
        applyOltBaseXml.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                XmlDataBase db = XmlDataBase.getInstance(fApplication.getSnmpProxy().getTargetHost());
                db.sendOltBase();
            }
        });
        buttonPanel.add(applyOltBaseXml);
        this.add(buttonPanel, BorderLayout.SOUTH);

        jTabbedPane.addChangeListener(e -> refresh());
    }

    @Override
    public void refresh() {
        if (jTabbedPane.getSelectedIndex() == 0) {
            systemPanel.refresh();
        } else if (jTabbedPane.getSelectedIndex() == 1) {
            vlanPanel.refresh();
        } else if (jTabbedPane.getSelectedIndex() == 2) {
            qinqPanel.refresh();
        }
    }

}
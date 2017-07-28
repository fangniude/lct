package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.lct.batch.proxy.XmlDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class ProfilePanel extends UPanel {
    private final DvmStringMap stringMap;
    private IGuiComposer composer;
    private JPanel jTabbedPane;
    private SnmpTablePane onuPanel;
    private SnmpTablePane uniPanel;

    public ProfilePanel(IApplication app) {
        super(app);
        this.fApplication = app;
        composer = fApplication.getActiveDeviceManager().getGuiComposer();
        stringMap = new DvmStringMap(composer);
        initGui();
    }

    public void initGui() {
        NTLayout layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        jTabbedPane = new JPanel(layout);

        onuPanel = (SnmpTablePane) composer.composeSnmpTablePane("ProfileOnuTable_Panel");
        uniPanel = (SnmpTablePane) composer.composeSnmpTablePane("ProfileUniTable_Panel");


        NTLayout onuLayout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        onuLayout.setMargins(6, 10, 6, 10);
        JPanel onu = new JPanel(onuLayout);
        onu.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_PON_profile_table")));
        onu.add(onuPanel);

        NTLayout uniLayout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        uniLayout.setMargins(6, 10, 6, 10);
        JPanel uni = new JPanel(uniLayout);
        uni.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_UNI_profile_table")));
        uni.add(uniPanel);

        jTabbedPane.add(onu);
        jTabbedPane.add(uni);

        this.setLayout(new BorderLayout());
        this.add(jTabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
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
    }

    @Override
    public void refresh() {
        onuPanel.refresh();
        uniPanel.refresh();
    }

}
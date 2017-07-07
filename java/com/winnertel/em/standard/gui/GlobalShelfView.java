package com.winnertel.em.standard.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.swing.UPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GlobalShelfView extends UPanel {

    private JPanel fShelfViewPane = null;

    public GlobalShelfView(IApplication app) {
        super(app);

        init();
    }

    protected void initGui() {
        setLayout(new BorderLayout());

        add(Box.createVerticalStrut(50), BorderLayout.NORTH);

        fShelfViewPane = new JPanel();
        fShelfViewPane.setLayout(new BoxLayout(fShelfViewPane, BoxLayout.Y_AXIS));
        add(fShelfViewPane, BorderLayout.CENTER);

        add(Box.createVerticalStrut(50), BorderLayout.SOUTH);

        add(Box.createHorizontalStrut(30), BorderLayout.EAST);
        add(Box.createHorizontalStrut(30), BorderLayout.WEST);

        IDeviceManager[] dvmList = fApplication.getDeviceManagerList();
        if (dvmList != null) {
            for (int i = 0; i < dvmList.length; i++) {
                IDeviceManager dvm = dvmList[i];
                fShelfViewPane.add(new ShelfViewButton(fApplication, dvm));
                if (i < dvmList.length - 1) {
                    fShelfViewPane.add(Box.createVerticalStrut(20));
                }
            }
        }
    }

    public void refresh() {
    }

    private class ShelfViewButton extends JButton {

        public ShelfViewButton(final IApplication anApp, final IDeviceManager aDvm) {
            add(new JLabel(aDvm.getImage()));
            setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
            setAction(new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    anApp.getMainApplet().setActiveDeviceManager(aDvm);
                }
            });
        }

    }

}
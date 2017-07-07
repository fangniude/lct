package com.winnertel.em.standard.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IEditorDialog;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public final class EditorDialog extends UDialog implements IEditorDialog {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

    private JTabbedPane fTabbedPane = null;

    public EditorDialog(IApplication app) {
        super(app);
        init();
    }

    public EditorDialog(IApplication app, boolean modal) {
        super(app, "", modal);
        init();
    }

    protected void init() {
        setResizable(true);
        fTabbedPane = new JTabbedPane();
        fTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                EditorDialog dialog = EditorDialog.this;
                if (!dialog.isVisible()) {
                    return;
                }

                int selected = fTabbedPane.getModel().getSelectedIndex();
                if (selected != -1) {
                    ((UPanel) fTabbedPane.getSelectedComponent()).refresh();
                }
            }
        });
        getContentPane().add(fTabbedPane, BorderLayout.CENTER);
    }


    public JTabbedPane getTabbedPane() {
        return fTabbedPane;
    }

    public UDialog getGui() {
        return this;
    }


    public void show() {
        int panelCount = fTabbedPane.getComponentCount();
        for (int i = 0; i < panelCount; i++) {
            fTabbedPane.setSelectedIndex(i);
        }
        fTabbedPane.setSelectedIndex(0);

        UPanel panel = (UPanel) getTabbedPane().getComponentAt(0);
        panel.refresh();
        pack();
        int width = DEFAULT_WIDTH;
        int height = DEFAULT_HEIGHT;
        if (getWidth() > width) {
            width = getWidth();
        }
        if (getHeight() > height) {
            height = getHeight();
        }
        setSize(width, height);
        super.show();
    }


    public void compose(String aTabbedPaneID) {
        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
        composer.composeTabbedPane(aTabbedPaneID, getTabbedPane());
    }
}

package com.winnertel.em.standard.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IEditorDialog;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class EmbeddedEditorDialog implements IEditorDialog {
    private IApplication fApplication;
    private JPanel fTabbedPanelContainer;
    private JTabbedPane fTabbedPane;
    private boolean fComposing = false;
    private ILogger fLogger = LoggerController.createLogger(EmbeddedEditorDialog.class);


    public EmbeddedEditorDialog(IApplication anApplication, JPanel aTabbedPanelContainer) {
        fApplication = anApplication;
        fTabbedPanelContainer = aTabbedPanelContainer;
        init();
    }

    protected void init() {
        fTabbedPane = new JTabbedPane();
        fTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (fComposing) {
                    return;
                }

                int selected = fTabbedPane.getModel().getSelectedIndex();
                if (selected != -1) {
                    UPanel panel = (UPanel) fTabbedPane.getSelectedComponent();
                    fLogger.debug("Panel ID:" + panel.getName());
                    panel.refresh();
                    //fApplication.getNSManager().register(panel);
                }
            }
        });
    }


    public JTabbedPane getTabbedPane() {
        return fTabbedPane;
    }

    public UDialog getGui() {
        return null;
    }

    public void show() {
        if (fTabbedPane.getSelectedComponent() != null) {
            UPanel panel = (UPanel) fTabbedPane.getSelectedComponent();
            panel.refresh();
        }
//        if ( fTabbedPane.getComponentCount() > 0 ) {
//            UPanel panel = ( UPanel ) fTabbedPane.getComponentAt( 0 );
//            panel.refresh();
//        }
        fTabbedPanelContainer.removeAll();
        fTabbedPanelContainer.add(fTabbedPane, BorderLayout.CENTER);
        fTabbedPanelContainer.validate();
        fTabbedPanelContainer.repaint();
    }


    public void setTitle(String aTitle) {
    }


    public void dispose() {
    }

    public void compose(String aTabbedPaneID) {
        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
        fComposing = true;
        composer.composeTabbedPane(aTabbedPaneID, getTabbedPane());
        if (getTabbedPane().getComponentCount() > 0) {
            //fApplication.getNSManager().register(( UPanel ) getTabbedPane().getComponentAt( 0 ));
        }
        fComposing = false;
    }
}

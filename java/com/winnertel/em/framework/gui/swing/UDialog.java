package com.winnertel.em.framework.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;

import javax.swing.*;
import java.awt.*;

public abstract class UDialog extends JDialog {
    protected IApplication fApplication = null;

    public UDialog(IApplication app) {
        this(app, "", true);
    }

    public UDialog(IApplication app, String title) {
        this(app, title, true);
    }

    public UDialog(IApplication app, String title, boolean modal) {
        super(app.getTopMostFrame(), title, modal);

        fApplication = app;
    }

    public UDialog(Window win, IApplication app, String title, ModalityType modal) {
        super(win, title, modal);

        fApplication = app;
    }

    public UDialog(Window owner, ModalityType modalityType, IApplication app) {
        super(owner, modalityType);
        fApplication = app;
    }

    /**
     * This method create gui representation of the dialog. Subclass should implement this method to customize the gui.
     */
    protected abstract void init();

    public void show() {
        // setLocationRelativeTo(fApplication.getTopMostFrame());
        Container parent = getParent();
        if (parent instanceof JDialog) {
            Point point = parent.getLocation();
            if (this instanceof SnmpDialog) {
                this.setLocation(point.x + 60, point.y + 60);
            } else {
                this.setLocation(point.x + 30, point.y + 30);
            }
        } else {
            setLocationRelativeTo(fApplication.getTopMostFrame());
        }
        super.show();
    }

    /**
     * This helper method create a dialog instance.
     *
     * @return a dialog instance
     */
    public static UDialog createInstance(IApplication anApplication) {
        return new UDialog(anApplication) {
            protected void init() {
            }
        };
    }
}

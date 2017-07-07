package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;

/**
 * Created by Li Pengpeng.
 * User: HZ20192
 * Date: 2012-05-21
 */
public abstract class CustomTablePanel extends UPanel {
    public CustomTablePanel(IApplication app) {
        super(app);
    }

    public abstract void refreshTable();
}

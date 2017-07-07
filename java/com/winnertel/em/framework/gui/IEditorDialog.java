package com.winnertel.em.framework.gui;

import com.winnertel.em.framework.gui.swing.UDialog;

import javax.swing.*;

public interface IEditorDialog {
    public JTabbedPane getTabbedPane();

    /**
     * This method is supposed to be removed. All GUI related method
     * should be defined in this class, such as show(), setTitle().
     *
     * @deprecated
     */
    public UDialog getGui();

    public void show();

    public void setTitle(String aTitle);

    public void dispose();

    public void compose(String aTabbedPaneID);
}

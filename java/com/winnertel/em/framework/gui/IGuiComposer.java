package com.winnertel.em.framework.gui;

import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;

import javax.swing.*;
import java.util.List;

public interface IGuiComposer extends ISearch {
    public JMenuBar composeMenuBar(String anId);

    public JPopupMenu composePopupMenu(String anId);

    public JToolBar composeToolBar(String anId);

    public List getFunctionTreeTypes();

    public FunctionTreeNode composeFunctionTreeNode(IDeviceManager aDvm, String aType);

    public void composeTabbedPane(String aName, JTabbedPane aTabbedPane);

    public UPanel composeSnmpTablePane(String aName);

    public UPanel composeShelfView();

    /**
     * Get a string from the string map file according to the name specified.
     *
     * @param name key of entry in the string map
     * @return a string value for the key
     */
    public String getString(String name);

    public JComponent composeComponent( String aFieldName );
}

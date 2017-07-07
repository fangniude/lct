package com.winnertel.em.framework;

import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.IEditorDialog;
import com.winnertel.em.framework.gui.ILogable;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.swing.UTree;

import javax.swing.*;

public interface IMainApplet {
    /**
     * This mothod indicate the running mode, applet or application
     *
     * @return true if in applet mode, false if in application mode
     */
    public boolean isStandAlone();

    public ILogable getMessageWindow();


    public IEditorDialog getEditorDialog();

    public void setShelfView(UPanel aShelfView);

    /**
     * Get actual gui instance
     *
     * @return actual gui instance
     */
    public JApplet getGui();


    /**
     * Set active device manager instance
     *
     * @param aDeviceManager active device manager instance
     */
    public void setActiveDeviceManager(IDeviceManager aDeviceManager);

    /**
     * Get parameter
     *
     * @param name
     */
    public String getParameter(String name);


    /**
     * Get a function tree accroding to the type specified.
     *
     * @param aType function tree type
     * @return function tree of the type, null if not exsit
     */
    public UTree getFunctionTree(String aType);
}

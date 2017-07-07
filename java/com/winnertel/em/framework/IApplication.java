package com.winnertel.em.framework;

import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.errorcode.IErrorCodeManager;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.log.ILogManager;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.ITaskManager;
import com.winnertel.em.framework.util.IPlatformProxy;

import java.awt.*;
import java.util.Locale;

public interface IApplication {
    // GUI style constants
    public static final byte POPUP_STYLE = 1;
    public static final byte EMBEDDED_STYLE = 2;

    /**
     * Get top most frame of the application
     *
     * @return top most frame of the application
     */
    public Frame getTopMostFrame();

    /**
     * Set top most frame of the application
     *
     * @param aFrame top most frame of the application
     */
    public void setTopMostFrame(Frame aFrame);


    /**
     * Get main applet of the application
     *
     * @return main applet of the application
     * @see IMainApplet
     */
    public IMainApplet getMainApplet();

    /**
     * Set main applet of the application
     *
     * @param aMainApplet main applet of the application
     */
    public void setMainApplet(IMainApplet aMainApplet);


    /**
     * Process start up jobs
     */
    public void startUp();

    /**
     * Process shut down jobs
     */
    public void shutDown();


    /**
     * Get active device manager instance
     *
     * @return active device manager instance
     */
    public IDeviceManager getActiveDeviceManager();

    /**
     * Set active device manager instance
     *
     * @param aDeviceManager active device manager instance
     */
    public void setActiveDeviceManager(IDeviceManager aDeviceManager);

    /**
     * Get all device managers
     *
     * @return all device managers
     */
    public IDeviceManager[] getDeviceManagerList();

    public void setDeviceManagerList(IDeviceManager[] aList);


    public ITaskManager getTaskManager();


    public IPlatformProxy getPlatformProxy();

    public ISnmpProxy getSnmpProxy();

    public void setSnmpProxy(ISnmpProxy aSnmpProxy);


    /**
     * Get the string map for the framework
     *
     * @return the string map for the framework
     */
    public IStringMap getGlobalStringMap();


    public void setSession(ISession aSession);

    public ISession getSession();

    public Locale getLocale();

    public byte getGUIStyle();

    public void setGUIStyle(byte aGUIStyle);

    public ISecurityManager getSecurityManager();

    public ILogManager getLogManager();


    public boolean isDebug();

    public void setDebug( boolean debug );

    public IErrorCodeManager getErrorCodeManager();

    public void setErrorCodeManager(IErrorCodeManager aErrorCodeManager);

}

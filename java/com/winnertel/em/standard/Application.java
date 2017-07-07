package com.winnertel.em.standard;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.IMainApplet;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.errorcode.IErrorCodeManager;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.log.ILogManager;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.ITaskManager;
import com.winnertel.em.framework.util.IPlatformProxy;
import com.winnertel.em.standard.gui.util.GlobalStringMap;
import com.winnertel.em.standard.log.LogManager;
import com.winnertel.em.standard.task.TaskManager;
import com.winnertel.em.standard.util.MockPlatformProxy;
import com.winnertel.em.standard.util.PlatformProxy;
import com.winnertel.em.standard.security.SecurityManager;

import java.awt.*;
import java.util.Locale;

public class Application implements IApplication {

    public static final byte POPUP_STYLE = 1;
    public static final byte EMBEDDED_STYLE = 2;

    private Locale fLocale = null;

    private byte fGUIStyle = EMBEDDED_STYLE;

    private IStringMap fStringMap = null;

    private Frame fTopMostFrame = null;

    private IMainApplet fMainApplet = null;

    private IDeviceManager fActiveDeviceManager = null;

    private IDeviceManager[] fDeviceManagerList = null;

    private ITaskManager fTaskManager = null;

    private ISecurityManager fSecurityManager = null;
    private ISnmpProxy fSnmpProxy = null;

    private IPlatformProxy fPlatformProxy = null;

    private ISession fSession = null;
    private ILogManager fLogManager = null;
    private boolean fDebug = false;

    public Application(Locale aLocale) {
        fLocale = aLocale;
        if (fLocale == null) {
            fLocale = Locale.ENGLISH;
        }
    }

    public byte getGUIStyle() {
        return fGUIStyle;
    }

    public void setGUIStyle(byte aStyle) {
        fGUIStyle = aStyle;
    }

    public Frame getTopMostFrame() {
        return fTopMostFrame;
    }

    public void setTopMostFrame(Frame aFrame) {
        fTopMostFrame = aFrame;
    }

    public IMainApplet getMainApplet() {
        return fMainApplet;
    }

    public void setMainApplet(IMainApplet aMainApplet) {
        fMainApplet = aMainApplet;
    }

    public void startUp() {
        fTaskManager = new TaskManager(this);
        fSecurityManager = new SecurityManager(this);
        fStringMap = new GlobalStringMap(fLocale);
        if (fDebug) {
            fPlatformProxy = new MockPlatformProxy(this);
        } else {
            fPlatformProxy = new PlatformProxy(this);
        }
        fLogManager = new LogManager(this);
    }

    public void shutDown() {
        fSnmpProxy.releaseResources();
        if (fDeviceManagerList != null) {
            for (int i = 0; i < fDeviceManagerList.length; i++) {
                IDeviceManager dvm = fDeviceManagerList[i];
                dvm.shutdown();
            }
        }
        fStringMap = null;
        fTopMostFrame = null;
        fMainApplet = null;
        fActiveDeviceManager = null;
        fDeviceManagerList = null;
        fTaskManager = null;
        fSecurityManager = null;
        fSnmpProxy = null;
        fPlatformProxy = null;
        fSession = null;
    }

    public IDeviceManager getActiveDeviceManager() {
        return fActiveDeviceManager;
    }

    public void setActiveDeviceManager(IDeviceManager aDvm) {
        fActiveDeviceManager = aDvm;
    }

    public ITaskManager getTaskManager() {
        return fTaskManager;
    }

    public ISnmpProxy getSnmpProxy() {
        return fSnmpProxy;
    }

    public void setSnmpProxy(ISnmpProxy aSnmpProxy) {
        fSnmpProxy = aSnmpProxy;
    }

    public IStringMap getGlobalStringMap() {
        return fStringMap;
    }

    public IDeviceManager[] getDeviceManagerList() {
        return fDeviceManagerList;
    }

    public void setDeviceManagerList(IDeviceManager[] aList) {
        fDeviceManagerList = aList;
    }

    public ISession getSession() {
        return fSession;
    }

    public void setSession(ISession aSession) {
        fSession = aSession;
    }

    public IPlatformProxy getPlatformProxy() {
        return fPlatformProxy;
    }

    public ISecurityManager getSecurityManager() {
        return fSecurityManager;
    }

    public Locale getLocale() {
        return fLocale;
    }

    public ILogManager getLogManager() {
        return fLogManager;
    }

    public boolean isDebug() {
        return fDebug;
    }

    public void setDebug(boolean isDebug) {
        fDebug = isDebug;
    }

    @Override
    public IErrorCodeManager getErrorCodeManager() {
        return fErrorCodeManager;
    }

    @Override
    public void setErrorCodeManager(IErrorCodeManager aErrorCodeManager) {
        fErrorCodeManager = aErrorCodeManager;
    }

    private IErrorCodeManager fErrorCodeManager;

}
package com.winnertel.em.standard.device;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.swing.UTree;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.resource.IResourceManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.Application;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DeviceManager implements IDeviceManager {
    private ILogger fLogger = LoggerController.createLogger(DeviceManager.class);

    private IApplication fApplication = null;

    private String fName = null;

    private String fDisplayName = null;

    private String fVersion = null;

    private String fType = null;

    private String fResourcePath = null;

    private JMenuBar fMenuBar = null;

    private JToolBar fToolBar = null;

    private Properties fVersionInfo = null;

    private Icon fImage = null;

    private Map fFuncTreeNodeMap = new HashMap();

    private IGuiComposer fGuiComposer = null;

    private UPanel fShelfViewPane = null;

    private BaseAction fCommunitySelector = null;

    private Task fStartupTask = null;

    private Task fShutdownTask = null;

    private boolean fStarted = false;

    private String fReadCommunity = null;

    private String fWriteCommunity = null;

    private int fSnmpVersion = 0;

    private int fTargetPort = 161;

    private TreePath fRootPath = null;

    private Properties fProperties = null;

    private IResourceManager fResourceManager = null;

    private OperationObject fOperationObject;


    private Map fCustomCache = new HashMap();// custom share data


    public DeviceManager(Application anApplication) {
        fApplication = anApplication;
    }


    public String getName() {
        return fName;
    }

    public void setName(String aName) {
        fName = aName;
    }


    public String getDisplayName() {
        return fDisplayName;
    }

    public void setDisplayName(String aDisplayName) {
        fDisplayName = aDisplayName;
    }


    public String getVersion() {
        return fVersion;
    }

    public void setVersion(String aVersion) {
        fVersion = aVersion;
    }


    public String getType() {
        return fType;
    }

    public void setType(String aType) {
        fType = aType;
    }


    public String getResourcePath() {
        return fResourcePath;
    }

    public void setResourcePath(String aResourcePath) {
        fResourcePath = aResourcePath;
    }


    public JMenuBar getMenuBar() {
        return fMenuBar;
    }

    public void setMenuBar(JMenuBar aMenuBar) {
        fMenuBar = aMenuBar;
        if (fMenuBar != null) {
            JApplet applet = fApplication.getMainApplet().getGui();
            applet.setJMenuBar(fMenuBar);
            applet.invalidate();
            applet.validate();
            applet.repaint();
        }
    }


    public JToolBar getToolBar() {
        return fToolBar;
    }

    public void setToolBar(JToolBar aToolBar) {
        JApplet applet = fApplication.getMainApplet().getGui();
        if (fToolBar != null) {
            applet.getContentPane().remove(fToolBar);
        }
        fToolBar = aToolBar;
        if (fToolBar != null) {
            applet.getContentPane().add(fToolBar, BorderLayout.NORTH);
            applet.invalidate();
            applet.validate();
            applet.repaint();
        }
    }


    public FunctionTreeNode getFunctionTreeNode(String aType) {
        return (FunctionTreeNode) fFuncTreeNodeMap.get(aType);
    }

    public void setFunctionTreeNode(String aType, FunctionTreeNode aNode) {
        fFuncTreeNodeMap.put(aType, aNode);

        UTree functionTree = fApplication.getMainApplet().getFunctionTree(aType);
        Object root = functionTree.getModel().getRoot();
        if (root != null && root != aNode) {
            ((DefaultTreeModel) functionTree.getModel()).setRoot(aNode);
            functionTree.repaint();
        }
    }


    public IGuiComposer getGuiComposer() {
        return fGuiComposer;
    }

    public void setGuiComposer(IGuiComposer aGuiComposer) {
        fGuiComposer = aGuiComposer;
    }


    public Properties getVersionInfo() {
        return fVersionInfo;
    }

    public void setVersionInfo(Properties aVersionInfo) {
        fVersionInfo = aVersionInfo;
    }


    public Icon getImage() {
        return fImage;
    }

    public void setImage(Icon aImage) {
        fImage = aImage;
    }


    public UPanel getShelfViewPane() {
        return fShelfViewPane;
    }

    public void setShelfViewPane(UPanel aShelfViewPane) {
        fShelfViewPane = aShelfViewPane;
    }


    public BaseAction getCommunitySelector() {
        return fCommunitySelector;
    }

    public void setCommunitySelector(BaseAction aCommunitySelector) {
        fCommunitySelector = aCommunitySelector;
    }


    public Task getStartupTask() {
        return fStartupTask;
    }

    public void setStartupTask(Task aStartupTask) {
        fStartupTask = aStartupTask;
    }


    public Task getShutdownTask() {
        return fShutdownTask;
    }

    public void setShutdownTask(Task aShutdownTask) {
        fShutdownTask = aShutdownTask;
    }


    public boolean isStarted() {
        return fStarted;
    }

    public void setStarted(boolean aStarted) {
        fStarted = aStarted;
    }


    public String getReadCommunity() {
        return fReadCommunity;
    }

    public void setReadCommunity(String aReadCommunity) {
        fReadCommunity = aReadCommunity;
    }


    public String getWriteCommunity() {
        return fWriteCommunity;
    }

    public void setWriteCommunity(String aWriteCommunity) {
        fWriteCommunity = aWriteCommunity;
    }


    public int getSnmpVersion() {
        return fSnmpVersion;
    }

    public void setSnmpVersion(int aSnmpVersion) {
        fSnmpVersion = aSnmpVersion;
    }


    public int getTargetPort() {
        return fTargetPort;
    }

    public void setTargetPort(int aTargetPort) {
        fTargetPort = aTargetPort;
    }


    public TreePath getRootPath() {
        return fRootPath;
    }

    public void setRootPath(TreePath aRootPath) {
        fRootPath = aRootPath;
    }


    public Properties getProperties() {
        return fProperties;
    }

    public void setProperties(Properties aProperties) {
        fProperties = aProperties;
    }


    public IResourceManager getResourceManager() {
        return fResourceManager;
    }

    public void setResourceManager(IResourceManager aResourceManager) {
        fResourceManager = aResourceManager;
    }


    public OperationObject getOperationObject() {
        return fOperationObject;
    }

    public void setOperationObject(OperationObject aOperationObject) {
        fOperationObject = aOperationObject;
    }

    public Map getCustomCache() {
        return fCustomCache;
    }

    public void startup() {
        // execute startup task
        if (!isStarted() && getStartupTask() != null) {
            try {
                fApplication.getTaskManager().executeTask(getStartupTask());
            } catch (Exception ex) {
                fLogger.debug("Error in execute dvm startup task", ex);
            }
        }
        setStarted(true);
    }

    public void shutdown() {
        // execute shutdown task
        if (isStarted() && getShutdownTask() != null) {
            try {
                fApplication.getTaskManager().executeTask(getShutdownTask());
            } catch (Exception ex) {
                fLogger.debug("Error in execute dvm shutdown task", ex);
            }
        }
    }
}

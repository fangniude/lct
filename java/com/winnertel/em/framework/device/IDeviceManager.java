package com.winnertel.em.framework.device;

import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.resource.IResourceManager;
import com.winnertel.em.framework.task.Task;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.util.Map;
import java.util.Properties;

public interface IDeviceManager {
    public String getName();

    public void setName(String aName);

    public String getDisplayName();

    public void setDisplayName(String aName);

    public String getVersion();

    public void setVersion(String aVersion);

    public String getType();

    public void setType(String aType);

    public String getResourcePath();

    public void setResourcePath(String aPath);

    public JMenuBar getMenuBar();

    public void setMenuBar(JMenuBar aMenuBar);

    public JToolBar getToolBar();

    public void setToolBar(JToolBar aToolBar);

    public FunctionTreeNode getFunctionTreeNode(String aType);

    public void setFunctionTreeNode(String aType, FunctionTreeNode aNode);

    public Properties getVersionInfo();

    public void setVersionInfo(Properties aProperties);

    public Icon getImage();

    public void setImage(Icon anImage);

    public UPanel getShelfViewPane();

    public void setShelfViewPane(UPanel aShelfViewPane);

    public void setCommunitySelector(BaseAction anAction);

    public BaseAction getCommunitySelector();

    public Task getStartupTask();

    public void setStartupTask(Task aTask);

    public Task getShutdownTask();

    public void setShutdownTask(Task aTask);

    public boolean isStarted();

    public void setStarted(boolean aStarted);

    public void setReadCommunity(String aCommunity);

    public String getReadCommunity();

    public void setWriteCommunity(String aCommunity);

    public String getWriteCommunity();

    public void setSnmpVersion(int aVersion);

    public int getSnmpVersion();

    public void setTargetPort(int aPort);

    public int getTargetPort();

    public TreePath getRootPath();

    public void setRootPath(TreePath aPath);

    public Properties getProperties();

    public void setProperties(Properties aProperties);

    public OperationObject getOperationObject();

    public void setOperationObject(OperationObject anOperationObject);

    public Map getCustomCache();


    /**
     * Get gui composer of the application
     *
     * @return gui composer of the application
     */
    public IGuiComposer getGuiComposer();

    /**
     * Set gui composer of the application
     *
     * @param aGuiComposer gui composer of the application
     */
    public void setGuiComposer(IGuiComposer aGuiComposer);


    public IResourceManager getResourceManager();

    public void setResourceManager(IResourceManager aResourceManager);


    public void startup();

    public void shutdown();
}

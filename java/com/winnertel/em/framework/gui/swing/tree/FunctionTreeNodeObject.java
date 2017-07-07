package com.winnertel.em.framework.gui.swing.tree;

import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.nms.topodb.ULManagedObject;

import javax.swing.*;
import java.net.URL;
import java.util.Properties;

public final class FunctionTreeNodeObject {
    public static final String ME = "ME";
    public static final String CHASSIS = "Chassis";
    public static final String BOARD = "Board";
    public static final String PORT = "Port";
    public static final String FIBER_PORT = "FiberPort";
    public static final String GROUP = "Group";
    public static final String ITEM = "Item";
    public static final String CPE = "CPE";

    private final String ICON_PACKAGE = "com/winnertel/em/framework/gui/swing/images/";

    private IDeviceManager fDeviceManager = null;

    private String fId = null;

    private String fText = null;

    private BaseAction fExecutor = null;

    private INodeDecorator fNodeDecorator = null;

    private ULManagedObject fMO = null;

    private Icon fIcon;

    private Properties fProperties = new Properties();

    private String fReadCommunity = null;
    private String fWriteCommunity = null;


    public FunctionTreeNodeObject(IDeviceManager aDvm, String anId, String aText,
                                  BaseAction anExecutor, INodeDecorator aNodeDecorator) {
        fDeviceManager = aDvm;
        fId = anId;
        fText = aText;
        fExecutor = anExecutor;
        fNodeDecorator = aNodeDecorator;

        if (fExecutor != null) {
            fExecutor.putValue(BaseAction.ID, anId);
            fExecutor.putValue(BaseAction.NAME, aText);
        }
    }


    public FunctionTreeNodeObject(IDeviceManager aDvm, String anId,
                                  String aText, BaseAction anExecutor,
                                  INodeDecorator aNodeDecorator, String anIconType) {
        this(aDvm, anId, aText, anExecutor, aNodeDecorator);

        fIcon = loadIcon(anIconType);
    }

    public Icon loadIcon(String anIconType) {
        URL iconUrl = getClass().getClassLoader().getResource(ICON_PACKAGE + anIconType + ".gif");
        if (iconUrl != null) {
            return new ImageIcon(iconUrl);
        } else {
            return null;
        }
    }


    public String getId() {
        return fId;
    }

    public String getText() {
        return fText;
    }

    public void setText(String aText) {
        fText = aText;
    }

    public BaseAction getExecutor() {
        return fExecutor;
    }

    public INodeDecorator getNodeDecorator() {
        return fNodeDecorator;
    }

    public IDeviceManager getDeviceManager() {
        return fDeviceManager;
    }


    public ULManagedObject getMO() {
        return fMO;
    }

    public void setMO(ULManagedObject aMO) {
        fMO = aMO;
    }


    public Icon getIcon() {
        return fIcon;
    }

    public void setIcon(Icon anIcon) {
        fIcon = anIcon;
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


    public Properties getProperties() {
        return fProperties;
    }

    public void setProperties(Properties aProperties) {
        fProperties = aProperties;
    }


    public String toString() {
        return fText;
    }

    public int hashCode() {
        return fId.hashCode();
    }

    public boolean equals(Object obj) {
        if( obj == null ) {
            return false;
        }
        if( obj instanceof FunctionTreeNodeObject ) {
            return fId.equals( ((FunctionTreeNodeObject)obj).getId());
        }
        return false;
    }
}

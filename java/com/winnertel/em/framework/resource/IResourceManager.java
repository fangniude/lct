package com.winnertel.em.framework.resource;

import org.jdom.Element;

import java.util.Map;

public interface IResourceManager {
    //resource type
    public static final String FILE_MENU_TOOL_BAR = "MenuToolBar";
    public static final String FILE_FUNCTION_TREE = "FunctionTree";
    public static final String FILE_TABBED_PANEL = "TabbedPanel";
    public static final String FILE_STRING_MAP = "StringMap";
    public static final String FILE_DEVICE_MANAGER = "DeviceManager";
    public static final String FILE_TABLE_FORM = "TableForm";
    public static final String FILE_SHELF_VIEW = "ShelfView";
    public static final String FILE_SECURITY = "Security";
    public static final String FILE_LOG = "Log";
    public static final String FILE_ERROR_CODE = "ErrorCode";
    //resource getting type
    public static final int DIRECT = 0;
    public static final int INDIRECT = 1;

    public Element loadMenuBarRoot(String anId);

    public Element loadPopupMenu(String anId);

    public Element loadToolBarRoot(String anId);

    public Element loadActionRoot();

    public Element loadFunctionTreeRoot();

    public Element loadTabbedPaneRoot();


    public Map loadStringMap();

    public Map loadSnmpFieldMap();

    public Map loadAuthorizationMap();

    public Map loadLogMap();

    public Element loadTablePane(String aName);


    public Element loadDeviceManagerRoot();

    public Element loadShelfViewRoot();

    /**
     * Get resource path where the manager can find resource files needed
     *
     * @return resource path
     */
    public String getResourcePath();

    /**
     * to get the mode by resource type
     *
     * @param aResourceType to see ResourceManager contants list
     * @return DIRECT / INDIRECT
     */
    public int getRetrieveMode(String aResourceType);
}

package com.winnertel.em.standard.resource;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.errorcode.IErrorCodeManager;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.resource.IResourceManager;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.gui.util.InstanceCreator;
import com.winnertel.em.standard.log.LogInfo;
import com.winnertel.em.standard.snmp.gui.SnmpField;
import org.apache.commons.collections.map.ListOrderedMap;
import org.jdom.Element;

import java.net.URL;
import java.util.*;

public final class ResourceManager implements IResourceManager {

    private static ILogger fgLogger = LoggerController.createLogger(ResourceManager.class);

    private IApplication fApplication = null;

    private String fResourcePath = null;

    private Locale fLocale = null;

    private Element fMenuToolBarRoot = null;

    private Element fTableFormRoot = null;

    private Element fFunctionTreeRoot = null;

    private HashMap version = new HashMap();

    private String fMenuToolBarResource = FILE_MENU_TOOL_BAR;

    private String fFunctionTreeResource = FILE_FUNCTION_TREE;

    private String fTabbedPaneResource = FILE_TABBED_PANEL;

    private String fTableFormResource = FILE_TABLE_FORM;

    private String fSecurityResource = FILE_SECURITY;

    private String fLogResource = FILE_LOG;

    private String fStringMapResource = FILE_STRING_MAP;

    private String fErrorCodeResource = FILE_ERROR_CODE;

    public ResourceManager(String aResourcePath, IApplication anApplication, Locale aLocale) {
        fResourcePath = aResourcePath;
        fApplication = anApplication;
        fLocale = aLocale;
        initMenuToolBarRoot();
        initTableFormRoot();
        initErrorCode();
    }

    private void initErrorCode() {
        Element errorCodeList = loadDocumentRoot(fErrorCodeResource);
        if (errorCodeList == null) {
            return;
        }
        String errorCodeBuilderPath = errorCodeList.getAttributeValue("builder");
        IErrorCodeManager errorCodeManager = (IErrorCodeManager) InstanceCreator.instantiateObject(fApplication, errorCodeBuilderPath);
        fApplication.setErrorCodeManager(errorCodeManager);
    }

    /**
     * set FunctionTree resource file path
     *
     * @param functionTreeFile
     */
    public void setFunctionTreeNodeRoot(String functionTreeFile) {
        if (functionTreeFile != null) {
            fFunctionTreeResource = functionTreeFile;
        }
    }

    /**
     * set TabbedPane resource file path
     *
     * @param tabbedPaneFile
     */
    public void setTabbedPane(String tabbedPaneFile) {
        if (tabbedPaneFile != null) {
            fTabbedPaneResource = tabbedPaneFile;
        }
    }

    /**
     * set MenuToolBar resource file path, and this call will take effect at once.
     *
     * @param aMenuResourceName
     */
    public void setMenuToolBarSource(String aMenuResourceName) {
        if (aMenuResourceName != null) {
            fMenuToolBarResource = aMenuResourceName;
        }
        fMenuToolBarRoot = loadDocumentRoot(fMenuToolBarResource);
    }

    /**
     * set TableForm resource file path, and this call will take effect at once.
     *
     * @param aTableFormResourceName
     */
    public void setTableFormSource(String aTableFormResourceName) {
        if (aTableFormResourceName != null) {
            fTableFormResource = aTableFormResourceName;
        }
        fTableFormRoot = loadDocumentRoot(fTableFormResource);
    }

    /**
     * set StringMap resource file path
     *
     * @param stringFile
     */
    public void setStringMap(String stringFile) {
        if (stringFile != null) {
            fStringMapResource = stringFile;
        }
    }

    /**
     * set Security resource file path
     *
     * @param aSecurity
     */
    public void setSecurityResource(String aSecurity) {
        if (aSecurity != null) {
            fSecurityResource = aSecurity;
        }
    }

    /**
     * set Log resource file path
     *
     * @param aLogResource
     */
    public void setLogResource(String aLogResource) {
        if (aLogResource != null) {
            fLogResource = aLogResource;
        }
    }

    private void initMenuToolBarRoot() {
        /*
        if (DebugMode.isDebug() || "true".equalsIgnoreCase(System.getProperty("dvm.mode.lct")))
            fMenuToolBarRoot = loadDocumentRoot(fMenuToolBarResource + "_LCT");
        else
            fMenuToolBarRoot = loadDocumentRoot(fMenuToolBarResource);
        */
        fMenuToolBarRoot = loadDocumentRoot(fMenuToolBarResource);
    }

    private void initTableFormRoot() {
        fTableFormRoot = loadDocumentRoot(fTableFormResource);
    }

    public Element loadMenuBarRoot(String anId) {
        if (anId == null || fMenuToolBarRoot == null) {
            return null;
        }

        List eMenuBarList = fMenuToolBarRoot.getChild("MenuBarList").getChildren("MenuBar");
        if (eMenuBarList == null || eMenuBarList.size() == 0) {
            return null;
        }

        Iterator it = eMenuBarList.iterator();
        while (it.hasNext()) {
            Element eMenuBar = (Element) it.next();
            String id = eMenuBar.getAttributeValue("id");
            if (anId.equals(id)) {
                return eMenuBar;
            }
        }

        return null;
    }

    public Element loadPopupMenu(String anId) {
        if (anId == null || fMenuToolBarRoot == null) {
            return null;
        }

        Element ePopupMenuList = fMenuToolBarRoot.getChild("PopupMenuList");
        List popupMenuList = ePopupMenuList.getChildren("PopupMenu");
        if (popupMenuList == null || popupMenuList.size() == 0) {
            return null;
        }

        Iterator it = popupMenuList.iterator();
        while (it.hasNext()) {
            Element eMenu = (Element) it.next();
            if (anId.equals(eMenu.getAttributeValue("id"))) {
                return eMenu;
            }
        }

        return null;
    }

    public Element loadToolBarRoot(String anId) {
        if (anId == null || fMenuToolBarRoot == null) {
            return null;
        }

        List eMenuBarList = fMenuToolBarRoot.getChild("ToolBarList").getChildren("ToolBar");
        if (eMenuBarList == null || eMenuBarList.size() == 0) {
            return null;
        }

        Iterator it = eMenuBarList.iterator();
        while (it.hasNext()) {
            Element eMenuBar = (Element) it.next();
            String id = eMenuBar.getAttributeValue("id");
            if (anId.equals(id)) {
                return eMenuBar;
            }
        }

        return null;
    }

    public Element loadActionRoot() {
        if (fMenuToolBarRoot == null) {
            return null;
        }

        return fMenuToolBarRoot.getChild("ActionList");
    }

    public Element loadFunctionTreeRoot() {
        if (fFunctionTreeRoot == null) {
            fFunctionTreeRoot = loadDocumentRoot(fFunctionTreeResource);
        }

        return fFunctionTreeRoot;
    }

    public Element loadTabbedPaneRoot() {
        return loadDocumentRoot(fTabbedPaneResource);
    }

    public Map loadAuthorizationMap() {
        Map result = new HashMap();

        Element eRoot = loadDocumentRoot(fSecurityResource);
        if (eRoot == null) {
            return result;
        }

        List eAuthorizationList = eRoot.getChildren("Authorization");
        if (eAuthorizationList == null || eAuthorizationList.size() == 0) {
            return result;
        }

        Iterator it = eAuthorizationList.iterator();
        while (it.hasNext()) {
            Element eAuthorization = (Element) it.next();
            try {
                String action = eAuthorization.getAttributeValue("action");
                String privilege = eAuthorization.getAttributeValue("privilege");
                result.put(action, privilege);
            } catch (Exception ex) {
                fgLogger.debug("Error in parsing security info", ex);
            }
        }

        return result;
    }

    public Map loadLogMap() {
        Map result = new HashMap();
        Element eRoot = loadDocumentRoot(fLogResource);
        if (eRoot == null) {
            return result;
        }

        List eLogList = eRoot.getChildren("Log");
        if (eLogList == null || eLogList.size() == 0) {
            return result;
        }
        Iterator it = eLogList.iterator();
        while (it.hasNext()) {
            Element eLog = (Element) it.next();
            String strId = eLog.getAttributeValue("id");
            String strOperation = eLog.getChildText("Operation");
            String strLevel = eLog.getChildText("Level");
            String strAnnotation = eLog.getChildText("Annotation");
            int level = 3;
            try {
                level = Integer.parseInt(strLevel);
            } catch (Exception ex) {
            }
            LogInfo tLogInfo = new LogInfo();
            tLogInfo.setOperation(strOperation);
            tLogInfo.setLevel(level);
            tLogInfo.setAnnotation(strAnnotation);
            result.put(strId, tLogInfo);
        }

        return result;
    }

    public Map loadStringMap() {
        return loadStringMapHelper(loadDocumentRoot(fStringMapResource));
    }

    public static Map loadStringMapHelper(Element aRoot) {
        Map result = new TreeMap();
        try {
            List eEntryList = aRoot.getChildren("String");
            if (eEntryList == null || eEntryList.size() == 0) {
                return result;
            }

            Iterator it = eEntryList.iterator();
            while (it.hasNext()) {
                Element eEntry = (Element) it.next();
                String name = eEntry.getAttributeValue("key");
                String value = eEntry.getAttributeValue("value");
                if (name != null && value != null) {
                    if (result.containsKey(name)) {
                        fgLogger.debug("Duplicate entry for " + name + " found in DvmStringMap.");
                        fgLogger.debug("Use the last entry");
                    }
                    result.put(name, value);
                }
            }
        } catch (Exception ex) {
            fgLogger.debug("Error in loading string map", ex);
        }

        return result;
    }

    public Map loadSnmpFieldMap() {
        Map result = new TreeMap();

        if (fTableFormRoot == null) {
            return result;
        }

        List fieldList = fTableFormRoot.getChild("FieldList").getChildren("Field");
        if (fieldList == null || fieldList.size() == 0) {
            return result;
        }

        Iterator it = fieldList.iterator();
        while (it.hasNext()) {
            Element eField = (Element) it.next();
            String name = eField.getAttributeValue("name");
            String label = eField.getAttributeValue("label");
            String formatter = eField.getAttributeValue("formatter");

            // load mib config
            Element eMib = eField.getChild("Mib");
            String oid = null;
            String type = null;
            Map valueMap = null;
            if (eMib != null) {
                oid = eMib.getAttributeValue("oid");
                type = eMib.getAttributeValue("type");
                Element eValueMap = eMib.getChild("ValueMap");
                if (eValueMap != null) {
                    valueMap = new ListOrderedMap();
                    List valueList = eValueMap.getChildren("Entry");
                    Iterator itValueMap = valueList.iterator();
                    while (itValueMap.hasNext()) {
                        Element eEntry = (Element) itValueMap.next();
                        String entryValue = eEntry.getAttributeValue("value");
                        String entryDisplay = eEntry.getAttributeValue("display");
                        valueMap.put(entryValue, entryDisplay);
                    }
                }
            }

            SnmpField field = new SnmpField(name, label, oid, convertMibType(type),
                    valueMap, InstanceCreator.instantiateFieldFormatter(fApplication, formatter));
            result.put(name, field);
        }

        return result;
    }

    public byte convertMibType(String aType) {
        byte result = 0;

        if (aType == null || aType.length() == 0) {
            return result;
        }

        if (aType.equals("Integer")) {
            result = ISnmpConstant.INTEGER;
        } else if (aType.equals("IpAddress")) {
            result = ISnmpConstant.IP_ADDRESS;
        } else if (aType.equals("String")) {
            result = ISnmpConstant.STRING;
        } else if (aType.equals("Counter")) {
            result = ISnmpConstant.COUNTER;
        } else if (aType.equals("Gauge")) {
            result = ISnmpConstant.GAUGE;
        } else if (aType.equals("Timeticks")) {
            result = ISnmpConstant.TIME_TICKS;
        } else if (aType.equals("MacAddress")) {
            result = ISnmpConstant.MAC_ADDRESS;
        } else if (aType.equals("ObjectId")) {
            result = ISnmpConstant.OBJID;
        }

        return result;
    }

    public Element loadTablePane(String aName) {
        if (fTableFormRoot == null) {
            return null;
        }
        Element eTablePanelList = fTableFormRoot.getChild("TablePanelList");
        if (eTablePanelList == null) {
            return null;
        }
        List panelList = eTablePanelList.getChildren("Panel");
        if (panelList == null || panelList.size() == 0) {
            return null;
        }

        Iterator it = panelList.iterator();
        while (it.hasNext()) {
            Element ePanel = (Element) it.next();
            if (aName.equals(ePanel.getAttributeValue("name"))) {
                return ePanel;
            }
        }

        return null;
    }

    public Element loadShelfViewRoot() {
        return loadDocumentRoot(FILE_SHELF_VIEW);
    }

    public Element loadDeviceManagerRoot() {
        return loadDocumentRoot(FILE_DEVICE_MANAGER);
    }

    private URL getUrl(String aFileName) {
        URL result = null;
        String file = aFileName;
        result = getClass().getClassLoader().getResource(file);
        if (result == null) {
            file = fResourcePath + aFileName;
            result = getClass().getClassLoader().getResource(file);
        }
        if (result == null) {
            fgLogger.debug("Can't find the file: " + file);
        }
        // add for supporting the fourth little version such as 1.1.0.35
        // if the file not exist in r110_35, look at r110 folder
        if (result == null && fResourcePath.contains("_")) {
            String candidateResourcePath = fResourcePath.substring(0, fResourcePath.lastIndexOf("_")) + "/";
            file = candidateResourcePath + aFileName;
            result = getClass().getClassLoader().getResource(file);
        }
        if (result == null) {
            fgLogger.debug("Can't find the file: " + file);
        }

        return result;
    }

    //For the enginner will set the filename with extension or not.
    //This method slide over this issue.
    private String getFileName(String filename) {
        if (filename == null) {
            return "";
        }
        int index = filename.lastIndexOf(".");
        if (index == -1) {
            return filename;
        }

        return filename.substring(0, index);
    }

    private Element loadDocumentRoot(String aFile) {
        //change implementation by Rex.zhu at 2004-01-14
        //for the new feature
        //reduce the maintaince work for resource file by different locale

        //orginial resource filename
        String fileName = getFileName(aFile) + "_" + fLocale.getLanguage() + "_" + fLocale.getCountry() + ".xml";
        URL fileUrl = getUrl(fileName);
        if (fileUrl != null) {
            version.put(aFile, new Integer(DIRECT));
        } else {
            //if == null, use load new feature's resource file
            fileName = getFileName(aFile) + ".xml";
            fileUrl = getUrl(fileName);
            if (fileUrl != null) {
                version.put(aFile, new Integer(INDIRECT));
            } else {
                return null;
            }
        }

        return DocumentLoader.buildDocument(fileUrl);
    }

    public int getRetrieveMode(String aResourceType) {
        Object ver = version.get(aResourceType);
        if (ver == null) {
            return DIRECT;
        }

        return ((Integer) ver);
    }

    public String getResourcePath() {
        return fResourcePath;
    }

}
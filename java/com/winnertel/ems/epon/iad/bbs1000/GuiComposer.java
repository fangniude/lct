/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs1000;

import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ShelfViewPane;
import com.winnertel.ems.epon.iad.bbs1000.model.BBS1000NE;
import com.winnertel.ems.epon.iad.bbs4000.CellRendererIntf;
import com.winnertel.ems.epon.iad.bbs4000.constant.CommonConstant;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import com.winnertel.em.framework.gui.swing.tree.INodeDecorator;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.resource.IResourceManager;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.Application;
import com.winnertel.em.standard.gui.GuiStyle;
import com.winnertel.em.standard.gui.action.FunctionTreeNodeAction;
import com.winnertel.em.standard.gui.action.HelpAction;
import com.winnertel.em.standard.gui.util.InstanceCreator;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpField;
import com.winnertel.em.standard.snmp.gui.SnmpFieldReference;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableButton;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.inms.topodb.UTopoAPI;
import org.jdom.Element;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;

/**
 * The GuiComposer class.
 *
 * @author Jason Hao
 */
public final class GuiComposer implements IGuiComposer {

    private ILogger fLogger = LoggerController.createLogger(GuiComposer.class);
    private IApplication fApplication = null;
    private IResourceManager fResourceManager = null;
    private Map fActionMap = null;
    private Map fTabbedPaneMap = null;

    //string cache
    private Map fStringCache = new HashMap();
    private Map fSnmpFieldCache = null;

    private GuiStyle fGuiStyle = GuiStyle.getDefaultGuiStyle();

    public GuiComposer(IApplication anApplication, IResourceManager aResourceManager) {
        fApplication = anApplication;
        fResourceManager = aResourceManager;

        init();
    }

    private void init() {
        cacheStringMap();
        cacheActionMap();
        cacheTabbedPaneMap();
        cacheSnmpFieldMap();
    }

    private void cacheStringMap() {
        fStringCache = fResourceManager.loadStringMap();
    }

    private void cacheActionMap() {
        fActionMap = new TreeMap();
        Element eActionList = fResourceManager.loadActionRoot();
        if (eActionList == null) {
            return;
        }

        List actionList = eActionList.getChildren("Action");
        if (actionList == null) {
            return;
        }

        Iterator it = actionList.iterator();
        while (it.hasNext()) {
            Element eAction = (Element) it.next();
            String name = eAction.getAttributeValue("name");
            Properties props = new Properties();
            String[] keys = {"Description", "Icon", "Mnemonic", "Accelerator", "Executor"};
            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                String value = eAction.getChildTextTrim(key);
                if (value != null) {
                    props.setProperty(key, value);
                }
            }

            Element eExecutor = eAction.getChild("Executor");
            if (eExecutor != null) {
                String executorClass = eExecutor.getAttributeValue("class");
                if (executorClass != null) {
                    props.setProperty("Executor", executorClass);

                    List eParamList = eExecutor.getChildren("Parameter");
                    if (eParamList != null && eParamList.size() > 0) {
                        String[] params = new String[eParamList.size()];
                        for (int i = 0; i < eParamList.size(); i++) {
                            params[i] = ((Element) eParamList.get(i)).getTextTrim();
                        }
                        props.put("ExecutorParameters", params);
                    }
                }
            }
            fActionMap.put(name, props);
        }
    }

    private void cacheTabbedPaneMap() {
        fTabbedPaneMap = new TreeMap();
        Element eRoot = fResourceManager.loadTabbedPaneRoot();
        if (eRoot == null) {
            return;
        }

        List tabbedPaneList = eRoot.getChildren("TabbedPane");
        if (tabbedPaneList == null) {
            return;
        }

        Iterator it = tabbedPaneList.iterator();
        while (it.hasNext()) {
            Element eTabbedPane = (Element) it.next();
            String id = eTabbedPane.getAttributeValue("id");
            fTabbedPaneMap.put(id, createTabbedPaneMap(eTabbedPane));
        }
    }

    public GuiStyle getGuiStyle() {
        return fGuiStyle;
    }

    public void setGuiStyle(GuiStyle aGuiStyle) {
        fGuiStyle = aGuiStyle;
    }

    private Collection createTabbedPaneMap(Element anElement) {
        List ePanelList = anElement.getChildren("Panel");
        if (ePanelList == null || ePanelList.size() == 0) {
            return null;
        }

        Collection result = new ArrayList();
        Iterator it = ePanelList.iterator();
        while (it.hasNext()) {
            Element ePanel = (Element) it.next();
            Properties props = new Properties();
            String[] keys = {"name", "class", "help_id", "version"};
            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                String value = ePanel.getAttributeValue(key);
                if (key != null && value != null) {
                    props.setProperty(key, value);
                }
            }
            result.add(props);
        }

        return result;
    }

    private void cacheSnmpFieldMap() {
        fSnmpFieldCache = fResourceManager.loadSnmpFieldMap();
    }

    public JMenuBar composeMenuBar(String anId) {
        Element eMenuBar = fResourceManager.loadMenuBarRoot(anId);
        if (eMenuBar == null) {
            return null;
        }
        List menuList = eMenuBar.getChildren("Menu");
        if (menuList.size() == 0) {
            return null;
        }

        JMenuBar menuBar = new JMenuBar();
        Iterator it = menuList.iterator();
        while (it.hasNext()) {
            Element eMenu = (Element) it.next();
            JMenu menu = composeMenu(eMenu);
            if (menu != null) {
                menuBar.add(menu);
            }
        }

        return menuBar;
    }

    private JMenu composeMenu(Element anElement) {
        JMenu result = null;
        List children = anElement.getChildren();
        if (children == null || children.size() == 0) {
            return null;
        }

        String id = anElement.getAttributeValue("id");
        String name = anElement.getAttributeValue("name");
        if (id == null) {
            id = name;
        }
        result = new JMenu(getActualContent(IResourceManager.FILE_MENU_TOOL_BAR, name));
        composeMenuDetail(result, children);

        Properties props = (Properties) fActionMap.get(id);
        if (props != null) {
            String mnemonic = props.getProperty("Mnemonic");
            if (mnemonic != null && mnemonic.length() > 0) {
                result.setMnemonic(mnemonic.charAt(0));
            }
        }

        return result;
    }

    private void composeMenuDetail(JComponent aMenu, List aList) {
        Iterator it = aList.iterator();
        while (it.hasNext()) {
            Element child = (Element) it.next();
            if ("Menu".equals(child.getName())) {
                JMenu menu = composeMenu(child);
                aMenu.add(menu);
            } else if ("MenuItem".equals(child.getName())) {
                String id = child.getAttributeValue("id");
                String name = child.getAttributeValue("name");
                if (id == null) {
                    id = name;
                }
                if ("-".equals(id)) {
                    ((JMenu) aMenu).addSeparator();
                } else {
                    JMenuItem menuItem = composeMenuItem(id, name);
                    if (menuItem != null) {
                        aMenu.add(menuItem);
                    }
                }
            }
        }
    }

    private JMenuItem composeMenuItem(String anId, String aName) {
        JMenuItem menuItem = new JMenuItem(getActualContent(IResourceManager.FILE_MENU_TOOL_BAR, aName));
        Properties props = (Properties) fActionMap.get(anId);
        if (props != null) {
            String clazzName = props.getProperty("Executor");
            if (clazzName != null && clazzName.length() > 0) {
                if (anId == null || anId.length() == 0) {
                    anId = aName;
                }
                try {
                    String[] executorParameters = (String[]) props.get("ExecutorParameters");
                    BaseAction action = null;
                    if (executorParameters == null) {
                        action = createActionInstance(anId,
                                getActualContent(IResourceManager.FILE_MENU_TOOL_BAR, aName),
                                clazzName);
                    } else {
                        action = createActionInstance(anId,
                                getActualContent(IResourceManager.FILE_MENU_TOOL_BAR, aName),
                                clazzName,
                                executorParameters);
                    }
                    menuItem.setAction(action);
                } catch (Exception ex) {
                    fLogger.debug("Error in create action class", ex);
                }
            }

            String mnemonic = props.getProperty("Mnemonic");
            if (mnemonic != null && mnemonic.length() > 0) {
                menuItem.setMnemonic(mnemonic.charAt(0));
            }

            String accelerator = props.getProperty("Accelerator");
            if (accelerator != null && accelerator.length() > 0) {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator));
            }

            String iconLocation = props.getProperty("Icon");
            URL iconUrl = getIconUrl(iconLocation);
            if (iconUrl != null) {
                menuItem.setIcon(new ImageIcon(iconUrl));
            }
        }

        return menuItem;
    }

    public JPopupMenu composePopupMenu(String anId) {
        Element ePopupMenu = fResourceManager.loadPopupMenu(anId);
        if (ePopupMenu == null) {
            return null;
        }
        List children = ePopupMenu.getChildren();
        if (children == null || children.size() == 0) {
            return null;
        }

        JPopupMenu popupMenu = new JPopupMenu();
        composeMenuDetail(popupMenu, children);

        return popupMenu;
    }

    public JToolBar composeToolBar(String anId) {
        JToolBar toolBar = null;
        Element eToolBar = fResourceManager.loadToolBarRoot(anId);
        if (eToolBar == null) {
            return null;
        }
        List buttonList = eToolBar.getChildren("Button");
        if (buttonList.size() == 0) {
            return toolBar;
        }

        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        Iterator it = buttonList.iterator();
        while (it.hasNext()) {
            Element eButton = (Element) it.next();
            String id = eButton.getAttributeValue("id");
            String name = eButton.getAttributeValue("name");
            if (id == null) {
                id = name;
            }
            if ("-".equals(name)) {
                toolBar.add(Box.createHorizontalStrut(5));
                continue;
            }

            JButton button = new JButton();
            Properties props = (Properties) fActionMap.get(id);
            if (props != null) {
                String clazzName = props.getProperty("Executor");
                if (clazzName != null && clazzName.length() > 0) {
                    try {
                        button.setAction(createActionInstance(id, "", clazzName));
                    } catch (Exception ex) {
                        fLogger.debug("Error in create action class", ex);
                    }
                }

                String iconLocation = props.getProperty("Icon");
                URL iconUrl = getIconUrl(iconLocation);
                if (iconUrl != null) {
                    button.setIcon(new ImageIcon(iconUrl));
                }

                String desc = props.getProperty("Description");
                if (desc != null && desc.length() > 0) {
                    button.setToolTipText(desc);
                }
            }
            toolBar.add(button);
        }

        return toolBar;
    }

    public List getFunctionTreeTypes() {
        Element eRoot = fResourceManager.loadFunctionTreeRoot();
        List eNodeList = eRoot.getChildren("FunctionTree");
        if (eNodeList == null || eNodeList.size() == 0) {
            return null;
        }

        ArrayList result = new ArrayList(eNodeList.size());
        Element eFunctionTree = null;
        Iterator it = eNodeList.iterator();
        while (it.hasNext()) {
            eFunctionTree = (Element) it.next();
            String type = eFunctionTree.getAttributeValue("type");
            if (type != null) {
                result.add(type);
            }
        }

        return result;
    }

    public FunctionTreeNode composeFunctionTreeNode(IDeviceManager aDvm, String aType) {
        Element eRoot = fResourceManager.loadFunctionTreeRoot();
        List eNodeList = eRoot.getChildren("FunctionTree");
        if (eNodeList == null || eNodeList.size() == 0) {
            return null;
        }

        Element eFunctionTree = null;
        Iterator it = eNodeList.iterator();
        while (it.hasNext()) {
            eFunctionTree = (Element) it.next();
            if (aType.equals(eFunctionTree.getAttributeValue("type"))) {
                break;
            } else {
                eFunctionTree = null;
            }
        }
        if (eFunctionTree == null) {
            return null;
        }

        FunctionTreeNode node = composeFunctionTreeNodeHelper(eFunctionTree.getChild("Node"), aDvm);
        if (node != null) {
            FunctionTreeNodeObject userObject = ((FunctionTreeNodeObject) node.getUserObject());
            userObject.setText(aDvm.getDisplayName());
            userObject.setIcon(userObject.loadIcon(FunctionTreeNodeObject.ME));
        }

        return node;
    }

    private FunctionTreeNode composeFunctionTreeNodeHelper(Element anElement, IDeviceManager aDvm) {
        FunctionTreeNode treeNode = null;

        // compose the node itself
        String id = anElement.getAttributeValue("id");
        if (id == null) {
            id = "";
        }
        String text = anElement.getAttributeValue("text");
        text = getActualContent(IResourceManager.FILE_FUNCTION_TREE, text);
        if (text == null) {
            text = id;
        }

        String executorClazz = anElement.getAttributeValue("executor");
        BaseAction act = null;
        if (executorClazz != null && executorClazz.length() > 0) {
            try {
                act = createActionInstance(id, text, executorClazz);
            } catch (Exception ex) {
                fLogger.debug("Error in create action instance", ex);
            }
        }
        if (act == null) {
            act = new FunctionTreeNodeAction(fApplication);
        }

        String decoratorClazz = anElement.getAttributeValue("decorator");
        INodeDecorator decorator = null;
        if (decoratorClazz != null && decoratorClazz.length() > 0) {
            decorator = InstanceCreator.instantiateNodeDecorator(fApplication, decoratorClazz);
        }

        String iconType = anElement.getAttributeValue("icon_type");
        FunctionTreeNodeObject treeExecutor =
                new FunctionTreeNodeObject(aDvm, id, text, act, decorator, iconType);
        treeNode = new FunctionTreeNode(treeExecutor);
        ((FunctionTreeNodeAction) act).setFunctionTreeNode(treeNode);
        if (decorator != null) {
            decorator.decorateNode(treeNode);
        }

        // compose children of the node
        List eNodeList = anElement.getChildren("Node");
        if (eNodeList != null && eNodeList.size() > 0) {
            Iterator it = eNodeList.iterator();
            while (it.hasNext()) {
                Element eNode = (Element) it.next();
                FunctionTreeNode tn = composeFunctionTreeNodeHelper(eNode, aDvm);
                if (tn != null) {
                    treeNode.add(tn);
                }
            }
        }

        return treeNode;
    }

    private BaseAction createActionInstance(String anId, String aName, String aClazzName) {
        BaseAction result = InstanceCreator.instantiateBaseAction(fApplication, aClazzName);
        if (result != null) {
            setActionProperties(result, anId, aName);
        }

        return result;
    }

    private BaseAction createActionInstance(String anId, String aName, String aClazzName, String[] aParameterArray) {
        BaseAction result = InstanceCreator.instantiateBaseAction(fApplication, aClazzName, aParameterArray);
        if (result != null) {
            setActionProperties(result, anId, aName);
        }

        return result;
    }

    private void setActionProperties(BaseAction aResult, String anId, String aName) {
        if (anId != null) {
            aResult.putValue(BaseAction.ID, anId);
        }
        if (aName != null) {
            aResult.putValue(BaseAction.NAME, aName);
        }
    }

    private SnmpAction createSnmpActionInstance(String anId, String aName, String aClazzName, String aChecker) {
        SnmpAction result = (SnmpAction) createActionInstance(anId, aName, aClazzName);
        if (result != null) {
            if (aChecker != null) {
                BaseChecker tChecker = InstanceCreator.instantiateCheker(fApplication, aChecker);
                if (tChecker != null) {
                    result.setChecker(tChecker);
                }
            }
        }

        return result;
    }

    public void composeTabbedPane(String aName, JTabbedPane aTabbedPane) {
        aTabbedPane.removeAll();
        Collection cTabbedPane = (Collection) fTabbedPaneMap.get(aName);
        if (cTabbedPane == null) {
            return;
        }

        Iterator it = cTabbedPane.iterator();
        while (it.hasNext()) {
            Properties props = (Properties) it.next();
            String name = props.getProperty("name");

            if (!checkPermission(name)) continue;

            String version = props.getProperty("version");
            if (!checkVersion(version)) continue;

            String id = name;
            final String helpId = props.getProperty("help_id");
            name = getActualContent(IResourceManager.FILE_TABBED_PANEL, name);
            String clazzName = props.getProperty("class");
            JPanel panel = null;
            if (SnmpTablePane.class.getName().equals(clazzName)) {
                panel = composeSnmpTablePane(id);
            } else {
                try {
                    Class c = Class.forName(clazzName);
                    if (ShelfViewPane.class.equals(c)) {
                        panel = composeShelfView();
                    } else if (UPanel.class.isAssignableFrom(c)) {
                        panel = InstanceCreator.instantiatePanel(fApplication, clazzName);
                    } else if (JPanel.class.isAssignableFrom(c)) {
                        panel = (JPanel) InstanceCreator.instantiateObject(clazzName);
                    }
                } catch (Exception ex) {
                    fLogger.debug("Error in finding panel class: " + clazzName, ex);
                }
            }
            if (panel != null) {
                panel.setName(id);
                if (helpId != null && helpId.length() > 0) {
                    panel.registerKeyboardAction(new HelpAction(fApplication, helpId), KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
                }
                aTabbedPane.add(name, panel);
            }
        }
    }

    public UPanel composeSnmpTablePane(String aName) {
        //the aName is the id, not bind locale
        Element ePanel = fResourceManager.loadTablePane(aName);
        Element eTable = ePanel.getChild("Table");

        /*
        String closeEnable = ePanel.getAttributeValue("enableClose");
        boolean bEnableClose = true;
        if (closeEnable != null && closeEnable.trim().equalsIgnoreCase("false")) {
            bEnableClose = false;
        }
        */

        String mibBeanClazz = eTable.getAttributeValue("mib_bean");
        String sRowsPerFetch = null;
        String sRowsToFetch = null;
        SnmpMibBean bean = null;
        if (mibBeanClazz == null) {
            Element eMibBean = eTable.getChild("MibBean");
            mibBeanClazz = eMibBean.getAttributeValue("class");
            sRowsPerFetch = eMibBean.getAttributeValue("rows_per_fetch");
            sRowsToFetch = eMibBean.getAttributeValue("rows_to_fetch");
        } else {
            sRowsPerFetch = eTable.getAttributeValue("rows_per_fetch");
            sRowsToFetch = eTable.getAttributeValue("rows_to_fetch");
        }

        bean = InstanceCreator.instantiateSnmpMibBean(fApplication.getSnmpProxy(), mibBeanClazz);

        if (sRowsPerFetch != null && sRowsPerFetch.length() > 0) {
            try {
                bean.setRowsPerFetch(Integer.parseInt(sRowsPerFetch));
            } catch (Throwable ex) {
                fLogger.error("Failed to parse rows per fetch value for snmp table " + aName, ex);
            }
        }

        /*
        Object[] indices = generateIndex(aName);
        if (indices != null) {
            for (int i = 0; i < indices.length; i++) {
                bean.setIndex(i, indices[i]);
            }
        }
        */

        int count = 0;

        try {
            if (sRowsToFetch != null) {
                count = Integer.parseInt(sRowsToFetch);
            }
            /*
            else {
                count = getRowsToFetch(aName);
            }
            */
        } catch (Exception e) {
        }

        if (count > 0) {
            bean.setRowsToFetch(count);
        }

        /*
        String indexPrefix = getIndexPrefix(aName);
        if (indexPrefix != null) {
            bean.setIndexPrefix(indexPrefix);
        }
        */

        String filterClazz = eTable.getAttributeValue("filter");
        String sMarkable = eTable.getAttributeValue("markable");
        boolean markable = false;
        if ("true".equals(sMarkable)) {
            markable = true;
        }

        // parse and set field list
        List fieldList = eTable.getChildren("Field");
        Vector vField = new Vector(fieldList.size());
        Iterator itField = fieldList.iterator();
        while (itField.hasNext()) {
            Element eField = (Element) itField.next();
            //these fields are always displayed as english
            String name = eField.getAttributeValue("name");
            String mibProperty = eField.getAttributeValue("mib_property");
            SnmpField field = (SnmpField) fSnmpFieldCache.get(name);
            translateFieldStrings(field);
            field.setMibProperty(mibProperty);

            // load field reference
            SnmpFieldReference ref = null;
            Element eRef = eField.getChild("Reference");
            if (eRef != null) {
                String mbeanClazz = eRef.getAttributeValue("mib_bean");
                String mibProp = eRef.getAttributeValue("mib_property");
                SnmpMibBean snmpMBean = InstanceCreator.instantiateSnmpMibBean(fApplication.getSnmpProxy(),
                        mbeanClazz);
                ref = new SnmpFieldReference(snmpMBean, mibProp);

                List conditionList = eRef.getChildren("Condition");
                Iterator itCondition = conditionList.iterator();
                while (itCondition.hasNext()) {
                    Element eCondtion = (Element) itCondition.next();
                    ref.addConditionItem(eCondtion.getAttributeValue("mib_property"),
                            eCondtion.getAttributeValue("ref_mib_property"));
                }
                field.setReference(ref);
            }
            vField.add(field);
        }

        final SnmpTablePane tablePane = new SnmpTablePane(fApplication);
        SnmpTable table = new SnmpTable(new SnmpTableModel(vField, bean, InstanceCreator.instantiateFilter(filterClazz), markable));
        tablePane.setTable(table);
        if ("true".equals(eTable.getAttributeValue("multiple_selection"))) {
            table.setMultipleSelection(true);
        }

        //added by Zhouchao, 2011/4/28 -- begin
        //cellrenderer
        String rendererClazz = eTable.getAttributeValue("cellrenderer");
        if (rendererClazz != null) {
            try {
                TableCellRenderer renderer = (TableCellRenderer) InstanceCreator.instantiateObject(rendererClazz);
                if (renderer != null && renderer instanceof CellRendererIntf) {
                    ((CellRendererIntf) renderer).setApplication(fApplication);
                    String neName = UTopoAPI.getAPI().getNodeNameByIP(fApplication.getSnmpProxy().getTargetHost());
                    ((CellRendererIntf) renderer).setNeName(neName);
                }
                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumn(table.getColumnName(i)).setCellRenderer(renderer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //added by Zhouchao, 2011/4/28 -- end

        if ("false".equals(eTable.getAttributeValue("refreshAllAfterAdd"))) {
            table.setRefreshAllAfterAdd(false);
        }

        if ("false".equals(eTable.getAttributeValue("refreshAllAfterModify"))) {
            table.setRefreshAllAfterModify(false);
        }
        Element eIdFormatter = eTable.getChild("MibBeanIdFormatter");
        if (eIdFormatter != null) {
            String className = eIdFormatter.getAttributeValue("class");
            String pattern = eIdFormatter.getAttributeValue("pattern");
            table.setRowIdFormatter(InstanceCreator.instantiateIdFormatter(fApplication, className, pattern));
        }

        // parse and set button list
        List buttonList = ePanel.getChildren("Button");
        Vector vButton = new Vector(buttonList.size());
        Iterator itButton = buttonList.iterator();
        boolean bConfigClose = false;
        while (itButton.hasNext()) {
            Element eButton = (Element) itButton.next();
            String id = eButton.getAttributeValue("id");
            String type = eButton.getAttributeValue("type");
            String text = eButton.getAttributeValue("text");
            String mnemonic = eButton.getAttributeValue("mnemonic");
            String checker = eButton.getAttributeValue("business_checker");
            if (text == null) {
                text = type;
            }
            text = getActualContent(IResourceManager.FILE_TABLE_FORM, text);
            String panelClazz = eButton.getAttributeValue("panel");
            String sTyle = eButton.getAttributeValue("style");
            String panelActionId = null;
            String panelTitle = null;
            if (panelClazz == null) {
                Element ePanel2 = eButton.getChild("Panel");
                if (ePanel2 != null) {
                    panelActionId = ePanel2.getAttributeValue("action_id");
                    panelClazz = ePanel2.getAttributeValue("class");
                    panelTitle = ePanel2.getAttributeValue("title");
                }
            }
            String dialogClazz = eButton.getAttributeValue("dialog");
            Element eAction = eButton.getChild("Action");
            String clazzName = null;
            if (eAction != null) {
                clazzName = eAction.getAttributeValue("class");
                id = eAction.getAttributeValue("id");
            }
            String visibleValue = eButton.getAttributeValue("visible");
            boolean bVisible = true;
            if (visibleValue != null && visibleValue.equalsIgnoreCase("false")) {
                bVisible = false;
            }
            if (SnmpAction.IType.CLOSE.equalsIgnoreCase(type)) {
                bConfigClose = true;
            }
            if (!bVisible) {
                continue;
            }
            SnmpAction act = createSnmpTableAction(id, type, clazzName, checker);
            SnmpTableButton btn = new SnmpTableButton(type, text,  act);
            UPanel panel = InstanceCreator.instantiatePanel(fApplication, panelClazz);
            UDialog dlg = null;
            if (panel != null) {
                panel.setCommand(type);
                if (SnmpAction.IType.ADD.equals(type) || SnmpAction.IType.MODIFY.equals(type)) {
                    //SnmpApplyButton applyButton = new SnmpApplyButton(fApplication, panel);
                    //applyButton.getAction().putValue(BaseAction.ID, panelActionId);
                    String title = fApplication.getGlobalStringMap().getString(type);
                    dlg = new SnmpDialog(fApplication, title, type, sTyle);
                    //((SnmpDialog) dlg).setApplyButton(applyButton);
                    ((SnmpDialog) dlg).setApplyId(panelActionId);
                    ((SnmpDialog) dlg).setTable(table);
                    //setPanel must be the end step
                    ((SnmpDialog) dlg).setPanel(panel);
                }
            } else if (SnmpAction.IType.EXPORT.equals(type)) {
                act.setTable(table);
            } else {
                dlg = InstanceCreator.instantiateDialog(fApplication, dialogClazz);
            }
            if (panelTitle != null) {
                dlg.setTitle(getString(panelTitle));
            }
            btn.setDialog(dlg);
            vButton.add(btn);
        }
        if (fApplication.getGUIStyle() == Application.EMBEDDED_STYLE) {
            tablePane.setButtonList(vButton, false, getGuiStyle());
        } else {
            tablePane.setButtonList(vButton, !bConfigClose, getGuiStyle());
        }

        return tablePane;
    }

    private Object[] generateIndex(String panel) {
        if (panel == null) {
            return null;
        }

        Object[] result = null;
        int slotId = 0;
        int cardId = 0;
        int portId = 0;
        int onuId = 0;
        try {
            String sSlotId = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_SLOT_ID);
            String sCardId = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_CARD_ID);
            if ((sSlotId == null) || (sCardId == null)) return null;
            slotId = Integer.parseInt(sSlotId);
            cardId = Integer.parseInt(sCardId);

            String sPortId = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_PORT_ID);
            if (sPortId != null && !sPortId.equals(""))
                portId = Integer.parseInt(sPortId);

            String sOnuId = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_ONU_ID);
            if (sOnuId != null && !sOnuId.equals(""))
                onuId = Integer.parseInt(sOnuId);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }

        if (panel.equals("QosExtCosQueueSchedTable_Panel") || panel.equals("QosExtIpPrecDscpMapTable_Panel")) {
            result = new String[2];
            result[0] = "" + (slotId - 1) * 4;
            result[1] = "7";
        } else if (panel.equals("QosExtDscpTrustTable_Panel")
                || panel.equals("SwitchPortExtTable_Panel")) {
            result = new String[1];
            result[0] = "" + (slotId - 1) * 4;
        } else if (panel.equals("Dot3OnuSwitchTable_Panel")) {
            result = new Integer[3];
            result[0] = slotId;
            result[1] = 0;
            result[2] = 0;
        } else if (panel.equals("Dot3OltTable_Panel")
                || panel.equals("Dot3DbaOltTable_Panel"))

        {
            int ifIndex = ConfigUtility.generateIfIndex((slotId) + "/1"); //port if index
            result = new String[1];
            result[0] = "" + (ifIndex - 29696);
        } else if (panel.equals("Dot3OltTransceiverTable_Panel")) {
            result = new String[1];
            result[0] = "" + (cardId - 1) * 4;  //uses cardId not slotId!
        } else if (panel.equals("IntfRateControlTable_Panel") || panel.equals("IntfRateControlTable_Panel_gem")) {
            result = new String[2];
            result[0] = "" + (slotId - 1);
            result[1] = "4";
        } else if (panel.equals("Module_Information")) {
            result = new String[1];
            result[0] = "" + (slotId - 1);
        } else if (panel.equals("Interface_table_gem")) {
            BBS1000NE ne = new BBS1000NE(fApplication);
            int ifIndex = ConfigUtility.generateIfIndex((slotId) + "/1");
            result = new Integer[1];
            result[0] = (ifIndex - 29696 + ne.getPonSplitRatio());
        } else if (panel.equals("Interface_table")
                || panel.equals("Interface_table_lg") || panel.equals("Ethernet_Performance")
                || panel.equals("OLT_Performance") || panel.equals("ONU_Performance")) {
            int ifIndex = ConfigUtility.generateIfIndex((slotId) + "/1");
            result = new Integer[1];
            result[0] = (ifIndex - 29664);
        } else if (panel.equals("Dot3Olt2QosGlbTable_Panel")
                || panel.equals("Dot3Olt2DbaGlbTable_Panel")
                || panel.equals("Dot3Olt2Table_Panel")) {
            result = new Integer[2];
            result[0] = slotId - 1;
            result[1] = 1;
        } else if (panel.equals("Dot3Olt2PortTable_Panel") ||
                panel.equals("Dot3Olt2PortDbaTable_Panel")) {
            result = new Integer[3];
            result[0] = slotId;
            result[1] = 1;
            result[2] = 0;
        } else if (panel.equals("Dot3Onu2CtcEtherPortTable_Panel") || panel.equals("OnuCtcBandCtrlTable_Panel") ||
                panel.equals("Dot3Olt2VlanStackingTable_Panel") || panel.equals("Dot3Onu2CtcMulticastCtrlTable_Panel")) {
            result = new Integer[5];
            result[0] = slotId;
            result[1] = 1;
            result[2] = portId;
            result[3] = onuId;
            result[4] = 0;
        } else if (panel.equals("Dot3Onu2QoSTable_Panel") || panel.equals("Dot3Onu2TrafficProfTable_Panel")
                || panel.equals("Dot3Onu2StaticFDBTable_Panel")
                || panel.equals("Dot3Onu2FDBTable_Panel") || panel.equals("Dot3Onu2CtcTable_Panel")
                || panel.equals("Dot3Onu2CtcDbaTable_Panel")) {
            result = new Integer[4];
            result[0] = slotId;
            result[1] = 1;
            result[2] = portId;
            result[3] = onuId - 1;
        } else if (panel.equals("Dot3Onu2CtcValidOnuMacTable_Panel")) {
            result = new Integer[4];
            result[0] = slotId;
            result[1] = 1;
            result[2] = 1;
            result[3] = 0;
        } else if (panel.equals("PonIf2ExtStatTable_OLT_Panel")) {
            result = new Integer[4];
            result[0] = slotId;
            result[1] = 1;
            result[2] = 0;
            result[3] = 0;
        } else if (panel.equals("PonIf2ExtStatTable_ONU_Panel")) {
            result = new Integer[4];
            result[0] = slotId - 1;
            result[1] = 1;
            result[2] = 4;
            BBS1000NE ne = new BBS1000NE(fApplication);
            result[3] = ne.getPonSplitRatio();
        } else if (panel.equals("Dot3Onu2CtcClassifiAppTable_Panel")) {
            result = new Integer[7];
            result[0] = slotId;
            result[1] = 1;
            result[2] = portId;
            result[3] = onuId - 1;
            result[4] = 4;
            result[5] = 32;
            result[6] = 120;
        } else if (panel.equals("LgQosExtCosQueueSchedTable_Panel")) {
            result = new Integer[2];
            result[0] = 12;
            result[1] = 3;
        } else if (panel.equals("LgQosExtDscpTrustTable_Panel") || panel.equals("SwitchPortExtTable_Panel_lg")) {
            result = new Integer[1];
            result[0] = 12; //12 - GE3/4
        } else if (panel.equals("QosExtDscpCosMapTable_Panel") || panel.equals("QosExtDscpMutMapTable_Panel")) {
            result = new Integer[2];
            result[0] = (slotId - 1) * 4;
            result[1] = 63;
        } else if (panel.equals("OltSelectiveQinQ_Panel")) {
            result = new Integer[7];
            result[0] = slotId;
            result[1] = 1;
            result[2] = 0;
            result[3] = 0;
            result[4] = 0;
            result[5] = 0;
            result[6] = 0;
        } else if (panel.equals("OnuSelectiveQinQ_Panel")) {
            result = new Integer[7];
            result[0] = slotId;
            result[1] = 1;
            result[2] = portId;
            result[3] = onuId;
            result[4] = 0;
            result[5] = 0;
            result[6] = 0;
        }

        return result;
    }

    private int getRowsToFetch(String panel) {
        BBS1000NE ne = new BBS1000NE(fApplication);

        if (panel.equals("ONU_Performance")) {
            //All ONUs under 1 OLT Card: ONU(split ratio) * 4 + 4 OLT = 260;
            return ne.getPonSplitRatio() * 4 + 4;
        }

        if (panel.equals("Dot3Olt2PortTable_Panel") || panel.equals("Dot3Olt2PortDbaTable_Panel")
                || panel.equals("PonIf2ExtStatTable_OLT_Panel") || panel.equals("IntfRateControlTable_Panel")
                || panel.equals("Ethernet_Performance") || panel.equals("QosExtDscpTrustTable_Panel")
                || panel.equals("SwitchPortExtTable_Panel")) {
            return 4;
        }

        if (panel.equals("Dot3Onu2StaticFDBTable_Panel") || panel.equals("Dot3Onu2FDBTable_Panel")
                || panel.equals("Dot3Onu2CtcTable_Panel") || panel.equals("Dot3Onu2CtcDbaTable_Panel")
                || panel.equals("Dot3Onu2QoSTable_Panel") || panel.equals("Dot3Onu2TrafficProfTable_Panel")
                || panel.equals("Module_Information") || panel.equals("Dot3Olt2Table_Panel")
                || panel.equals("Dot3Olt2QosGlbTable_Panel") || panel.equals("Dot3Olt2DbaGlbTable_Panel")) {
            return 1;
        }

        if (panel.equals("QosExtCosQueueSchedTable_Panel")) {
            return 16;
        }

        if (panel.equals("QosExtIpPrecDscpMapTable_Panel")) {
            return 32;
        }

        if (panel.equals("QosExtDscpCosMapTable_Panel") || panel.equals("QosExtDscpMutMapTable_Panel")) {
            return 256;
        }

        return -1;
    }

    private String getIndexPrefix(String panel) {
        String prefix = null;
        String sSlotId = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_SLOT_ID);

        if (panel.equals("Dot3Onu2CtcValidOnuMacTable_Panel") || panel.equals("PonIf2ExtStatTable_ONU_Panel")
                || panel.equals("OltSelectiveQinQ_Panel")) {
            prefix = sSlotId + ".1";
        }

        if (panel.equals("Dot3Onu2CtcTable_Panel") || panel.equals("Dot3Onu2CtcEtherPortTable_Panel")
                || panel.equals("OnuCtcBandCtrlTable_Panel") || panel.equals("Dot3Onu2CtcDbaTable_Panel")
                || panel.equals("Dot3Onu2QoSTable_Panel") || panel.equals("Dot3Onu2TrafficProfTable_Panel")
                || panel.equals("Dot3Olt2VlanStackingTable_Panel") || panel.equals("Dot3Onu2CtcClassifiAppTable_Panel")
                || panel.equals("Dot3Onu2CtcMulticastCtrlTable_Panel") || panel.equals("OnuSelectiveQinQ_Panel")
                ) {
            prefix = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_ONU_IFINDEX);
        }

        return prefix;
    }

    private void translateFieldStrings(SnmpField aField) {
        if (aField.getLabel() != null) {
            aField.setLabel(getActualContent(IResourceManager.FILE_TABLE_FORM, aField.getLabel()));
        }

        Map valueMap = aField.getValueMap();
        if (valueMap != null && valueMap.size() > 0) {
            Iterator it = valueMap.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                if (key != null) {
                    String value = (String) valueMap.get(key);
                    valueMap.put(key, getActualContent(IResourceManager.FILE_TABLE_FORM, value));
                }
            }
        }
    }

    private SnmpAction createSnmpTableAction(String id, String type, String clazzName, String depend) {
        if (clazzName == null || clazzName.length() == 0) {
            if (type.equals(SnmpAction.IType.ADD)) {
                clazzName = SnmpAction.IAction.ADD;
            } else if (type.equals(SnmpAction.IType.MODIFY)) {
                clazzName = SnmpAction.IAction.MODIFY;
            } else if (type.equals(SnmpAction.IType.DELETE)) {
                clazzName = SnmpAction.IAction.DELETE;
            } else if (type.equals(SnmpAction.IType.REFRESH)) {
                clazzName = SnmpAction.IAction.REFRESH;
            } else if (type.equalsIgnoreCase(SnmpAction.IType.CLOSE)) {
                clazzName = SnmpAction.IAction.CLOSE;
            } else if (type.equals(SnmpAction.IType.EXPORT)) {
                clazzName = SnmpAction.IAction.EXPORT;
            }
        }

        return createSnmpActionInstance(id, type, clazzName, depend);
    }

    public UPanel composeShelfView() {
        try {
            UPanel shelfView = fApplication.getActiveDeviceManager().getShelfViewPane();
            if (shelfView == null) {
                shelfView = new ShelfViewPane(fApplication);
                shelfView.setName("Chassis_View");

                /*
                shelfView = (UPanel) fApplication.getTaskManager().executeTask(new Task() {
                    public Object execute() throws Exception {
                        return new ShelfViewPane(fApplication);
                    }
                });
                */

                fApplication.getActiveDeviceManager().setShelfViewPane(shelfView);
            } else {
                shelfView.refresh();
            }

            return shelfView;
        } catch (Exception ex) {
            fLogger.debug("Error in compose shelf view instance", ex);
        }

        return null;
    }

    private URL getIconUrl(String iconLocation) {
        URL result = null;
        if (iconLocation != null) {
            iconLocation = fResourceManager.getResourcePath() + iconLocation;
            result = getClass().getClassLoader().getResource(iconLocation);
        }

        return result;
    }

    public String getString(String name) {
        String s = (String) fStringCache.get(name);
        if (s == null) {
            s = name;
        }

        return s;
    }

    @Override
    public JComponent composeComponent(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void destroy() {
        if (fActionMap != null) {
            fActionMap.clear();
        }
        if (fTabbedPaneMap != null) {
            fTabbedPaneMap.clear();
        }
        if (fStringCache != null) {
            fStringCache.clear();
        }
        if (fSnmpFieldCache != null) {
            fSnmpFieldCache.clear();
        }
    }

    private String getActualContent(String resourceType, String value) {
        switch (fResourceManager.getRetrieveMode(resourceType)) {
            case IResourceManager.INDIRECT:
                //get resource from dvm resource first
                //if not found, then get it from global setting
                String retValue = getString(value);
                if (retValue.equals(value)) {
                    //not found from dvm
                    return fApplication.getGlobalStringMap().getString(value);
                } else {
                    return retValue;
                }
            case IResourceManager.DIRECT:
                return fApplication.getGlobalStringMap().getString(value);
            default:
                return value;
        }
    }

    private boolean checkPermission(String anActionId) {
        if (fApplication.isDebug() || anActionId == null || anActionId.length() == 0) {
            return true;
        }

        final ISecurityManager securityManager = fApplication.getSecurityManager();
        final ISession session = fApplication.getSession();

        if (!securityManager.isAuthorized(session, anActionId)) {
            //MessageDialog.showPermissionDeniedDialog( fApplication );
            return false;
        } else {
            return true;
        }
    }

    private boolean checkVersion(String version) {
        if (version != null) {
            String[] split = version.split("[;,]");
            String ver = fApplication.getActiveDeviceManager().getVersion();
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals(ver)) {
                    return true;
                }
            }

            return false;
        }

        return true;
    }

    @Override
    public void stopSearch() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector<TreePath> search(TreeNode treeNode, String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}